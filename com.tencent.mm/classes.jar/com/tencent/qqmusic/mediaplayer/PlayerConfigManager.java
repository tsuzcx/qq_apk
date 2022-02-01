package com.tencent.qqmusic.mediaplayer;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;

public class PlayerConfigManager
{
  private static final int ADD = 1;
  private static final int DTS_COST_THRESHOLD = 40;
  private static boolean ENABLE_CHANGE_THREAD_PRIORITY = false;
  private static final boolean ENABLE_REAL_CHECK = true;
  private static final int MAX_RATIO = 4;
  private static final int MAX_TIMES = 10;
  private static final int MIN_RATIO = 8;
  private static final int NONE = 0;
  private static final int SUB = -1;
  private static final String TAG = "PlayerConfigManager";
  private static PlayerConfigManager mInstance;
  private int[] THREAD_PRIORITY;
  private int count;
  private int mAddPriority;
  private int mBufRatio;
  private WeakReference<CorePlayer> mCommonPlayerRef;
  private int mCurrPriorityIndex;
  private long mLastDecodeSpeed;
  private long mPlaySpeed;
  private int mProcessorNumber;
  private long mStartTime;
  
  private PlayerConfigManager()
  {
    AppMethodBeat.i(76713);
    this.mBufRatio = 4;
    this.count = 0;
    this.mStartTime = 0L;
    this.mPlaySpeed = 1L;
    this.mAddPriority = 0;
    this.mProcessorNumber = Runtime.getRuntime().availableProcessors();
    this.mCommonPlayerRef = null;
    this.THREAD_PRIORITY = new int[] { 19, 10, -2, -4, -8, -16, -19 };
    this.mCurrPriorityIndex = 0;
    this.mBufRatio = 4;
    this.count = 0;
    this.mStartTime = 0L;
    AppMethodBeat.o(76713);
  }
  
  private boolean add()
  {
    return this.mAddPriority > 0;
  }
  
  public static PlayerConfigManager getInstance()
  {
    try
    {
      AppMethodBeat.i(76714);
      if (mInstance == null) {
        mInstance = new PlayerConfigManager();
      }
      PlayerConfigManager localPlayerConfigManager = mInstance;
      AppMethodBeat.o(76714);
      return localPlayerConfigManager;
    }
    finally {}
  }
  
  private boolean sub()
  {
    return this.mAddPriority < -1;
  }
  
  public void calDTSCostEnd()
  {
    AppMethodBeat.i(76717);
    if (this.mBufRatio == 8)
    {
      AppMethodBeat.o(76717);
      return;
    }
    if (System.currentTimeMillis() - this.mStartTime > 40L)
    {
      this.count += 1;
      if (this.count > 10)
      {
        this.mBufRatio *= 2;
        this.count = 0;
      }
    }
    AppMethodBeat.o(76717);
  }
  
  public void calDTSCostStart()
  {
    AppMethodBeat.i(76716);
    if (this.mBufRatio == 8)
    {
      AppMethodBeat.o(76716);
      return;
    }
    this.mStartTime = System.currentTimeMillis();
    AppMethodBeat.o(76716);
  }
  
  public void changeDecodeThreadPriority()
  {
    AppMethodBeat.i(76720);
    if (this.mCommonPlayerRef != null)
    {
      CorePlayer localCorePlayer = (CorePlayer)this.mCommonPlayerRef.get();
      if (localCorePlayer != null) {
        localCorePlayer.changePlayThreadPriorityImmediately();
      }
    }
    AppMethodBeat.o(76720);
  }
  
  public void changeDecodeThreadPriorityIfNeed()
  {
    int j = 0;
    AppMethodBeat.i(76721);
    for (;;)
    {
      int i;
      try
      {
        int k = this.mCurrPriorityIndex;
        if ((isSingleCpuOrScreenOff()) && (ENABLE_CHANGE_THREAD_PRIORITY))
        {
          if (add())
          {
            i = k + 1;
            if ((i != this.mCurrPriorityIndex) || (i < 0) || (i >= this.THREAD_PRIORITY.length)) {
              break label168;
            }
            Logger.i("PlayerConfigManager", "changeDecodeThreadPriorityIfNeed don't change Priority mCurrPriorityIndex = " + this.THREAD_PRIORITY[this.mCurrPriorityIndex]);
            AppMethodBeat.o(76721);
            return;
          }
          i = k;
          if (!sub()) {
            continue;
          }
          i = k - 1;
          continue;
          this.mCurrPriorityIndex = i;
          this.mAddPriority = 0;
        }
        Process.setThreadPriority(0);
        AppMethodBeat.o(76721);
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("PlayerConfigManager", localThrowable);
        AppMethodBeat.o(76721);
        return;
      }
      if (i >= this.THREAD_PRIORITY.length)
      {
        i = this.THREAD_PRIORITY.length;
        i -= 1;
      }
      else
      {
        continue;
        label168:
        if (i < 0) {
          i = j;
        }
      }
    }
  }
  
  public int getBufRatio()
  {
    AppMethodBeat.i(76715);
    if (this.mBufRatio <= 1) {
      this.mBufRatio = 4;
    }
    for (;;)
    {
      Logger.i("PlayerConfigManager", "getBufRatio = " + this.mBufRatio);
      this.count = 0;
      int i = this.mBufRatio;
      AppMethodBeat.o(76715);
      return i;
      if (this.mBufRatio > 8) {
        this.mBufRatio = 8;
      }
    }
  }
  
  public boolean isSingleCpuOrScreenOff()
  {
    AppMethodBeat.i(76718);
    this.mProcessorNumber = Runtime.getRuntime().availableProcessors();
    if (this.mProcessorNumber <= 1)
    {
      AppMethodBeat.o(76718);
      return true;
    }
    AppMethodBeat.o(76718);
    return false;
  }
  
  public void setCommonPlayerRef(CorePlayer paramCorePlayer)
  {
    AppMethodBeat.i(76719);
    if (paramCorePlayer != null)
    {
      this.mCommonPlayerRef = new WeakReference(paramCorePlayer);
      this.mCurrPriorityIndex = 0;
      this.mAddPriority = 0;
      paramCorePlayer = paramCorePlayer.getCurrentAudioInformation();
      if (paramCorePlayer != null)
      {
        this.mPlaySpeed = (((float)(paramCorePlayer.getSampleRate() * 2L * paramCorePlayer.getChannels()) / 1000.0F));
        Logger.i("PlayerConfigManager", "setCommonPlayerRef info = " + paramCorePlayer + ",mPlaySpeed = " + this.mPlaySpeed);
      }
    }
    AppMethodBeat.o(76719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.PlayerConfigManager
 * JD-Core Version:    0.7.0.1
 */