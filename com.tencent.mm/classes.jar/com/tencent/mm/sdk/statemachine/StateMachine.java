package com.tencent.mm.sdk.statemachine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class StateMachine
{
  public static final boolean HANDLED = true;
  public static final boolean NOT_HANDLED = false;
  public static final int SM_INIT_CMD = -2;
  private static final int SM_QUIT_CMD = -1;
  private String mName;
  private volatile SmHandler mSmHandler;
  private volatile HandlerThread mSmThread;
  
  protected StateMachine(String paramString)
  {
    AppMethodBeat.i(230463);
    this.mSmThread = new HandlerThread(paramString);
    this.mSmThread.start();
    initStateMachine(paramString, this.mSmThread.getLooper());
    AppMethodBeat.o(230463);
  }
  
  protected StateMachine(String paramString, Handler paramHandler)
  {
    AppMethodBeat.i(230464);
    initStateMachine(paramString, paramHandler.getLooper());
    AppMethodBeat.o(230464);
  }
  
  protected StateMachine(String paramString, Looper paramLooper)
  {
    AppMethodBeat.i(158037);
    initStateMachine(paramString, paramLooper);
    AppMethodBeat.o(158037);
  }
  
  private void initStateMachine(String paramString, Looper paramLooper)
  {
    AppMethodBeat.i(230462);
    this.mName = paramString;
    this.mSmHandler = new SmHandler(paramLooper, this, null);
    AppMethodBeat.o(230462);
  }
  
  protected void addLogRec(String paramString)
  {
    AppMethodBeat.i(230474);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230474);
      return;
    }
    localSmHandler.mLogRecords.add(this, SmHandler.access$1000(localSmHandler), paramString, SmHandler.access$1100(localSmHandler), localSmHandler.mStateStack[localSmHandler.mStateStackTopIndex].state, localSmHandler.mDestState);
    AppMethodBeat.o(230474);
  }
  
  public final void addState(State paramState)
  {
    AppMethodBeat.i(158038);
    SmHandler.access$800(this.mSmHandler, paramState, null);
    AppMethodBeat.o(158038);
  }
  
  protected final void addState(State paramState1, State paramState2)
  {
    AppMethodBeat.i(230465);
    SmHandler.access$800(this.mSmHandler, paramState1, paramState2);
    AppMethodBeat.o(230465);
  }
  
  public final Collection<LogRec> copyLogRecs()
  {
    AppMethodBeat.i(230473);
    Vector localVector = new Vector();
    Object localObject = this.mSmHandler;
    if (localObject != null)
    {
      localObject = SmHandler.access$1600((SmHandler)localObject).mLogRecVector.iterator();
      while (((Iterator)localObject).hasNext()) {
        localVector.add((LogRec)((Iterator)localObject).next());
      }
    }
    AppMethodBeat.o(230473);
    return localVector;
  }
  
  protected final void deferMessage(Message paramMessage)
  {
    AppMethodBeat.i(230467);
    SmHandler.access$1400(this.mSmHandler, paramMessage);
    AppMethodBeat.o(230467);
  }
  
  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    AppMethodBeat.i(230498);
    paramPrintWriter.println(getName() + ":");
    paramPrintWriter.println(" total records=" + getLogRecCount());
    try
    {
      while (i < getLogRecSize())
      {
        paramPrintWriter.printf(" rec[%d]: %s\n", new Object[] { Integer.valueOf(i), getLogRec(i).toString() });
        paramPrintWriter.flush();
        i += 1;
      }
      return;
    }
    catch (Exception paramFileDescriptor)
    {
      paramPrintWriter.println("curState=" + getCurrentState().getName());
      AppMethodBeat.o(230498);
    }
  }
  
  protected final Message getCurrentMessage()
  {
    AppMethodBeat.i(158040);
    Object localObject = this.mSmHandler;
    if (localObject == null)
    {
      AppMethodBeat.o(158040);
      return null;
    }
    localObject = SmHandler.access$1000((SmHandler)localObject);
    AppMethodBeat.o(158040);
    return localObject;
  }
  
  public final IState getCurrentState()
  {
    AppMethodBeat.i(158041);
    Object localObject = this.mSmHandler;
    if (localObject == null)
    {
      AppMethodBeat.o(158041);
      return null;
    }
    localObject = SmHandler.access$1100((SmHandler)localObject);
    AppMethodBeat.o(158041);
    return localObject;
  }
  
  public final Handler getHandler()
  {
    return this.mSmHandler;
  }
  
  public final LogRec getLogRec(int paramInt)
  {
    AppMethodBeat.i(230472);
    Object localObject = this.mSmHandler;
    if (localObject == null)
    {
      AppMethodBeat.o(230472);
      return null;
    }
    localObject = ((SmHandler)localObject).mLogRecords.get(paramInt);
    AppMethodBeat.o(230472);
    return localObject;
  }
  
  public final int getLogRecCount()
  {
    AppMethodBeat.i(230471);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230471);
      return 0;
    }
    int i = localSmHandler.mLogRecords.count();
    AppMethodBeat.o(230471);
    return i;
  }
  
  public final int getLogRecSize()
  {
    AppMethodBeat.i(230470);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230470);
      return 0;
    }
    int i = localSmHandler.mLogRecords.size();
    AppMethodBeat.o(230470);
    return i;
  }
  
  protected String getLogRecString(Message paramMessage)
  {
    return "";
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  protected String getWhatToString(int paramInt)
  {
    return null;
  }
  
  protected void haltedProcessMessage(Message paramMessage) {}
  
  public boolean isDbg()
  {
    AppMethodBeat.i(230497);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230497);
      return false;
    }
    boolean bool = SmHandler.access$2400(localSmHandler);
    AppMethodBeat.o(230497);
    return bool;
  }
  
  protected final boolean isQuit(Message paramMessage)
  {
    AppMethodBeat.i(230496);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      if (paramMessage.what == -1)
      {
        AppMethodBeat.o(230496);
        return true;
      }
      AppMethodBeat.o(230496);
      return false;
    }
    boolean bool = SmHandler.access$2100(localSmHandler, paramMessage);
    AppMethodBeat.o(230496);
    return bool;
  }
  
  protected void log(String paramString) {}
  
  protected void logAndAddLogRec(String paramString)
  {
    AppMethodBeat.i(230499);
    addLogRec(paramString);
    log(paramString);
    AppMethodBeat.o(230499);
  }
  
  protected void logd(String paramString) {}
  
  protected void loge(String paramString) {}
  
  protected void loge(String paramString, Throwable paramThrowable) {}
  
  protected void logi(String paramString) {}
  
  protected void logv(String paramString) {}
  
  protected void logw(String paramString) {}
  
  public final Message obtainMessage()
  {
    AppMethodBeat.i(230475);
    Message localMessage = Message.obtain(this.mSmHandler);
    AppMethodBeat.o(230475);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(158044);
    Message localMessage = Message.obtain(this.mSmHandler, paramInt);
    AppMethodBeat.o(158044);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230476);
    Message localMessage = Message.obtain(this.mSmHandler, paramInt1, paramInt2, 0);
    AppMethodBeat.o(230476);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230477);
    Message localMessage = Message.obtain(this.mSmHandler, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(230477);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(230478);
    paramObject = Message.obtain(this.mSmHandler, paramInt1, paramInt2, paramInt3, paramObject);
    AppMethodBeat.o(230478);
    return paramObject;
  }
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(158045);
    paramObject = Message.obtain(this.mSmHandler, paramInt, paramObject);
    AppMethodBeat.o(158045);
    return paramObject;
  }
  
  protected void onHalting() {}
  
  protected void onQuitting() {}
  
  public final void quit()
  {
    AppMethodBeat.i(158048);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(158048);
      return;
    }
    SmHandler.access$2200(localSmHandler);
    AppMethodBeat.o(158048);
  }
  
  protected final void quitNow()
  {
    AppMethodBeat.i(158049);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(158049);
      return;
    }
    SmHandler.access$2300(localSmHandler);
    AppMethodBeat.o(158049);
  }
  
  protected boolean recordLogRec(Message paramMessage)
  {
    return true;
  }
  
  protected final void removeMessages(int paramInt)
  {
    AppMethodBeat.i(230495);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230495);
      return;
    }
    localSmHandler.removeMessages(paramInt);
    AppMethodBeat.o(230495);
  }
  
  public final void sendMessage(int paramInt)
  {
    AppMethodBeat.i(158046);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(158046);
      return;
    }
    localSmHandler.sendMessage(obtainMessage(paramInt));
    AppMethodBeat.o(158046);
  }
  
  public final void sendMessage(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230480);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230480);
      return;
    }
    localSmHandler.sendMessage(obtainMessage(paramInt1, paramInt2));
    AppMethodBeat.o(230480);
  }
  
  public final void sendMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230481);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230481);
      return;
    }
    localSmHandler.sendMessage(obtainMessage(paramInt1, paramInt2, paramInt3));
    AppMethodBeat.o(230481);
  }
  
  public final void sendMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(230482);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230482);
      return;
    }
    localSmHandler.sendMessage(obtainMessage(paramInt1, paramInt2, paramInt3, paramObject));
    AppMethodBeat.o(230482);
  }
  
  public final void sendMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(230479);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230479);
      return;
    }
    localSmHandler.sendMessage(obtainMessage(paramInt, paramObject));
    AppMethodBeat.o(230479);
  }
  
  public final void sendMessage(Message paramMessage)
  {
    AppMethodBeat.i(230483);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230483);
      return;
    }
    localSmHandler.sendMessage(paramMessage);
    AppMethodBeat.o(230483);
  }
  
  protected final void sendMessageAtFrontOfQueue(int paramInt)
  {
    AppMethodBeat.i(158047);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(158047);
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(obtainMessage(paramInt));
    AppMethodBeat.o(158047);
  }
  
  protected final void sendMessageAtFrontOfQueue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230491);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230491);
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(obtainMessage(paramInt1, paramInt2));
    AppMethodBeat.o(230491);
  }
  
  protected final void sendMessageAtFrontOfQueue(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230492);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230492);
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(obtainMessage(paramInt1, paramInt2, paramInt3));
    AppMethodBeat.o(230492);
  }
  
  protected final void sendMessageAtFrontOfQueue(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(230493);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230493);
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(obtainMessage(paramInt1, paramInt2, paramInt3, paramObject));
    AppMethodBeat.o(230493);
  }
  
  protected final void sendMessageAtFrontOfQueue(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(230490);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230490);
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(obtainMessage(paramInt, paramObject));
    AppMethodBeat.o(230490);
  }
  
  protected final void sendMessageAtFrontOfQueue(Message paramMessage)
  {
    AppMethodBeat.i(230494);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230494);
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(paramMessage);
    AppMethodBeat.o(230494);
  }
  
  public final void sendMessageDelayed(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(230487);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230487);
      return;
    }
    localSmHandler.sendMessageDelayed(obtainMessage(paramInt1, paramInt2, paramInt3), paramLong);
    AppMethodBeat.o(230487);
  }
  
  public final void sendMessageDelayed(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(230488);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230488);
      return;
    }
    localSmHandler.sendMessageDelayed(obtainMessage(paramInt1, paramInt2, paramInt3, paramObject), paramLong);
    AppMethodBeat.o(230488);
  }
  
  public final void sendMessageDelayed(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(230486);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230486);
      return;
    }
    localSmHandler.sendMessageDelayed(obtainMessage(paramInt1, paramInt2), paramLong);
    AppMethodBeat.o(230486);
  }
  
  public final void sendMessageDelayed(int paramInt, long paramLong)
  {
    AppMethodBeat.i(230484);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230484);
      return;
    }
    localSmHandler.sendMessageDelayed(obtainMessage(paramInt), paramLong);
    AppMethodBeat.o(230484);
  }
  
  public final void sendMessageDelayed(int paramInt, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(230485);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230485);
      return;
    }
    localSmHandler.sendMessageDelayed(obtainMessage(paramInt, paramObject), paramLong);
    AppMethodBeat.o(230485);
  }
  
  public final void sendMessageDelayed(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(230489);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(230489);
      return;
    }
    localSmHandler.sendMessageDelayed(paramMessage, paramLong);
    AppMethodBeat.o(230489);
  }
  
  public void setDbg(boolean paramBoolean)
  {
    AppMethodBeat.i(158050);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(158050);
      return;
    }
    SmHandler.access$2500(localSmHandler, paramBoolean);
    AppMethodBeat.o(158050);
  }
  
  public final void setInitialState(State paramState)
  {
    AppMethodBeat.i(158039);
    SmHandler.access$900(this.mSmHandler, paramState);
    AppMethodBeat.o(158039);
  }
  
  public final void setLogOnlyTransitions(boolean paramBoolean)
  {
    AppMethodBeat.i(230469);
    this.mSmHandler.mLogRecords.setLogOnlyTransitions(paramBoolean);
    AppMethodBeat.o(230469);
  }
  
  public final void setLogRecSize(int paramInt)
  {
    AppMethodBeat.i(230468);
    this.mSmHandler.mLogRecords.setSize(paramInt);
    AppMethodBeat.o(230468);
  }
  
  public void start()
  {
    AppMethodBeat.i(158051);
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null)
    {
      AppMethodBeat.o(158051);
      return;
    }
    SmHandler.access$2600(localSmHandler);
    AppMethodBeat.o(158051);
  }
  
  public final void transitionTo(IState paramIState)
  {
    AppMethodBeat.i(158042);
    SmHandler.access$1200(this.mSmHandler, paramIState);
    AppMethodBeat.o(158042);
  }
  
  protected final void transitionToHaltingState()
  {
    AppMethodBeat.i(230466);
    SmHandler.access$1200(this.mSmHandler, this.mSmHandler.mHaltingState);
    AppMethodBeat.o(230466);
  }
  
  protected void unhandledMessage(Message paramMessage)
  {
    AppMethodBeat.i(158043);
    if (this.mSmHandler.mDbg) {
      loge(" - unhandledMessage: msg.what=" + paramMessage.what);
    }
    AppMethodBeat.o(158043);
  }
  
  public static class LogRec
  {
    private IState mDstState;
    private String mInfo;
    private IState mOrgState;
    private StateMachine mSm;
    private IState mState;
    private long mTime;
    private int mWhat;
    
    LogRec(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
    {
      AppMethodBeat.i(158011);
      update(paramStateMachine, paramMessage, paramString, paramIState1, paramIState2, paramIState3);
      AppMethodBeat.o(158011);
    }
    
    public IState getDestState()
    {
      return this.mDstState;
    }
    
    public String getInfo()
    {
      return this.mInfo;
    }
    
    public IState getOriginalState()
    {
      return this.mOrgState;
    }
    
    public IState getState()
    {
      return this.mState;
    }
    
    public long getTime()
    {
      return this.mTime;
    }
    
    public long getWhat()
    {
      return this.mWhat;
    }
    
    public String toString()
    {
      AppMethodBeat.i(158013);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time=");
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(this.mTime);
      localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
      localStringBuilder.append(" processed=");
      if (this.mState == null)
      {
        localObject = "<null>";
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" org=");
        if (this.mOrgState != null) {
          break label259;
        }
        localObject = "<null>";
        label111:
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" dest=");
        if (this.mDstState != null) {
          break label272;
        }
        localObject = "<null>";
        label134:
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" what=");
        if (this.mSm == null) {
          break label285;
        }
        localObject = this.mSm.getWhatToString(this.mWhat);
        label166:
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label291;
        }
        localStringBuilder.append(this.mWhat);
        localStringBuilder.append("(0x");
        localStringBuilder.append(Integer.toHexString(this.mWhat));
        localStringBuilder.append(")");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.mInfo))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(this.mInfo);
        }
        localObject = localStringBuilder.toString();
        AppMethodBeat.o(158013);
        return localObject;
        localObject = this.mState.getName();
        break;
        label259:
        localObject = this.mOrgState.getName();
        break label111;
        label272:
        localObject = this.mDstState.getName();
        break label134;
        label285:
        localObject = "";
        break label166;
        label291:
        localStringBuilder.append((String)localObject);
      }
    }
    
    public void update(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
    {
      AppMethodBeat.i(158012);
      this.mSm = paramStateMachine;
      this.mTime = System.currentTimeMillis();
      if (paramMessage != null) {}
      for (int i = paramMessage.what;; i = 0)
      {
        this.mWhat = i;
        this.mInfo = paramString;
        this.mState = paramIState1;
        this.mOrgState = paramIState2;
        this.mDstState = paramIState3;
        AppMethodBeat.o(158012);
        return;
      }
    }
  }
  
  static class LogRecords
  {
    private static final int DEFAULT_SIZE = 20;
    private int mCount;
    private boolean mLogOnlyTransitions;
    private Vector<StateMachine.LogRec> mLogRecVector;
    private int mMaxSize;
    private int mOldestIndex;
    
    private LogRecords()
    {
      AppMethodBeat.i(158014);
      this.mLogRecVector = new Vector();
      this.mMaxSize = 20;
      this.mOldestIndex = 0;
      this.mCount = 0;
      this.mLogOnlyTransitions = false;
      AppMethodBeat.o(158014);
    }
    
    /* Error */
    void add(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 53
      //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: aload_0
      //   9: getfield 40	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mCount	I
      //   12: iconst_1
      //   13: iadd
      //   14: putfield 40	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mCount	I
      //   17: aload_0
      //   18: getfield 34	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mLogRecVector	Ljava/util/Vector;
      //   21: invokevirtual 57	java/util/Vector:size	()I
      //   24: aload_0
      //   25: getfield 36	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mMaxSize	I
      //   28: if_icmpge +35 -> 63
      //   31: aload_0
      //   32: getfield 34	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mLogRecVector	Ljava/util/Vector;
      //   35: new 59	com/tencent/mm/sdk/statemachine/StateMachine$LogRec
      //   38: dup
      //   39: aload_1
      //   40: aload_2
      //   41: aload_3
      //   42: aload 4
      //   44: aload 5
      //   46: aload 6
      //   48: invokespecial 61	com/tencent/mm/sdk/statemachine/StateMachine$LogRec:<init>	(Lcom/tencent/mm/sdk/statemachine/StateMachine;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/mm/sdk/statemachine/IState;Lcom/tencent/mm/sdk/statemachine/IState;Lcom/tencent/mm/sdk/statemachine/IState;)V
      //   51: invokevirtual 64	java/util/Vector:add	(Ljava/lang/Object;)Z
      //   54: pop
      //   55: ldc 53
      //   57: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   60: aload_0
      //   61: monitorexit
      //   62: return
      //   63: aload_0
      //   64: getfield 34	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mLogRecVector	Ljava/util/Vector;
      //   67: aload_0
      //   68: getfield 38	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mOldestIndex	I
      //   71: invokevirtual 68	java/util/Vector:get	(I)Ljava/lang/Object;
      //   74: checkcast 59	com/tencent/mm/sdk/statemachine/StateMachine$LogRec
      //   77: astore 7
      //   79: aload_0
      //   80: aload_0
      //   81: getfield 38	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mOldestIndex	I
      //   84: iconst_1
      //   85: iadd
      //   86: putfield 38	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mOldestIndex	I
      //   89: aload_0
      //   90: getfield 38	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mOldestIndex	I
      //   93: aload_0
      //   94: getfield 36	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mMaxSize	I
      //   97: if_icmplt +8 -> 105
      //   100: aload_0
      //   101: iconst_0
      //   102: putfield 38	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mOldestIndex	I
      //   105: aload 7
      //   107: aload_1
      //   108: aload_2
      //   109: aload_3
      //   110: aload 4
      //   112: aload 5
      //   114: aload 6
      //   116: invokevirtual 71	com/tencent/mm/sdk/statemachine/StateMachine$LogRec:update	(Lcom/tencent/mm/sdk/statemachine/StateMachine;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/mm/sdk/statemachine/IState;Lcom/tencent/mm/sdk/statemachine/IState;Lcom/tencent/mm/sdk/statemachine/IState;)V
      //   119: ldc 53
      //   121: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   124: goto -64 -> 60
      //   127: astore_1
      //   128: aload_0
      //   129: monitorexit
      //   130: aload_1
      //   131: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	132	0	this	LogRecords
      //   0	132	1	paramStateMachine	StateMachine
      //   0	132	2	paramMessage	Message
      //   0	132	3	paramString	String
      //   0	132	4	paramIState1	IState
      //   0	132	5	paramIState2	IState
      //   0	132	6	paramIState3	IState
      //   77	29	7	localLogRec	StateMachine.LogRec
      // Exception table:
      //   from	to	target	type
      //   2	60	127	finally
      //   63	105	127	finally
      //   105	124	127	finally
    }
    
    void cleanup()
    {
      try
      {
        AppMethodBeat.i(158015);
        this.mLogRecVector.clear();
        AppMethodBeat.o(158015);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    int count()
    {
      try
      {
        int i = this.mCount;
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    StateMachine.LogRec get(int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 79
      //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 38	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mOldestIndex	I
      //   11: iload_1
      //   12: iadd
      //   13: istore_2
      //   14: iload_2
      //   15: istore_1
      //   16: iload_2
      //   17: aload_0
      //   18: getfield 36	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mMaxSize	I
      //   21: if_icmplt +10 -> 31
      //   24: iload_2
      //   25: aload_0
      //   26: getfield 36	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mMaxSize	I
      //   29: isub
      //   30: istore_1
      //   31: iload_1
      //   32: aload_0
      //   33: invokevirtual 80	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:size	()I
      //   36: if_icmplt +14 -> 50
      //   39: aconst_null
      //   40: astore_3
      //   41: ldc 79
      //   43: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_3
      //   49: areturn
      //   50: aload_0
      //   51: getfield 34	com/tencent/mm/sdk/statemachine/StateMachine$LogRecords:mLogRecVector	Ljava/util/Vector;
      //   54: iload_1
      //   55: invokevirtual 68	java/util/Vector:get	(I)Ljava/lang/Object;
      //   58: checkcast 59	com/tencent/mm/sdk/statemachine/StateMachine$LogRec
      //   61: astore_3
      //   62: ldc 79
      //   64: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   67: goto -21 -> 46
      //   70: astore_3
      //   71: aload_0
      //   72: monitorexit
      //   73: aload_3
      //   74: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	LogRecords
      //   0	75	1	paramInt	int
      //   13	17	2	i	int
      //   40	22	3	localLogRec	StateMachine.LogRec
      //   70	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	14	70	finally
      //   16	31	70	finally
      //   31	39	70	finally
      //   41	46	70	finally
      //   50	67	70	finally
    }
    
    boolean logOnlyTransitions()
    {
      try
      {
        boolean bool = this.mLogOnlyTransitions;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    void setLogOnlyTransitions(boolean paramBoolean)
    {
      try
      {
        this.mLogOnlyTransitions = paramBoolean;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    void setSize(int paramInt)
    {
      try
      {
        AppMethodBeat.i(230443);
        this.mMaxSize = paramInt;
        this.mCount = 0;
        this.mLogRecVector.clear();
        AppMethodBeat.o(230443);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    int size()
    {
      try
      {
        AppMethodBeat.i(230444);
        int i = this.mLogRecVector.size();
        AppMethodBeat.o(230444);
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  static class SmHandler
    extends Handler
  {
    private static final Object mSmHandlerObj;
    private boolean mDbg;
    private ArrayList<Message> mDeferredMessages;
    private State mDestState;
    private HaltingState mHaltingState;
    private boolean mHasQuit;
    private State mInitialState;
    private boolean mIsConstructionCompleted;
    private StateMachine.LogRecords mLogRecords;
    private Message mMsg;
    private QuittingState mQuittingState;
    private StateMachine mSm;
    private HashMap<State, StateInfo> mStateInfo;
    private StateInfo[] mStateStack;
    private int mStateStackTopIndex;
    private StateInfo[] mTempStateStack;
    private int mTempStateStackCount;
    
    static
    {
      AppMethodBeat.i(158036);
      mSmHandlerObj = new Object();
      AppMethodBeat.o(158036);
    }
    
    private SmHandler(Looper paramLooper, StateMachine paramStateMachine)
    {
      super();
      AppMethodBeat.i(158027);
      this.mHasQuit = false;
      this.mDbg = false;
      this.mLogRecords = new StateMachine.LogRecords(null);
      this.mStateStackTopIndex = -1;
      this.mHaltingState = new HaltingState(null);
      this.mQuittingState = new QuittingState(null);
      this.mStateInfo = new HashMap();
      this.mDeferredMessages = new ArrayList();
      this.mSm = paramStateMachine;
      addState(this.mHaltingState, null);
      addState(this.mQuittingState, null);
      AppMethodBeat.o(158027);
    }
    
    private final StateInfo addState(State paramState1, State paramState2)
    {
      AppMethodBeat.i(230450);
      Object localObject2;
      Object localObject1;
      if (this.mDbg)
      {
        localObject2 = this.mSm;
        StringBuilder localStringBuilder = new StringBuilder("addStateInternal: E state=").append(paramState1.getName()).append(",parent=");
        if (paramState2 == null)
        {
          localObject1 = "";
          ((StateMachine)localObject2).log((String)localObject1);
        }
      }
      else
      {
        if (paramState2 == null) {
          break label221;
        }
        localObject1 = (StateInfo)this.mStateInfo.get(paramState2);
        if (localObject1 != null) {
          break label216;
        }
        paramState2 = addState(paramState2, null);
      }
      for (;;)
      {
        localObject2 = (StateInfo)this.mStateInfo.get(paramState1);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new StateInfo(null);
          this.mStateInfo.put(paramState1, localObject1);
        }
        if ((((StateInfo)localObject1).parentStateInfo != null) && (((StateInfo)localObject1).parentStateInfo != paramState2))
        {
          paramState1 = new RuntimeException("state already added");
          AppMethodBeat.o(230450);
          throw paramState1;
          localObject1 = paramState2.getName();
          break;
        }
        ((StateInfo)localObject1).state = paramState1;
        ((StateInfo)localObject1).parentStateInfo = paramState2;
        ((StateInfo)localObject1).active = false;
        if (this.mDbg) {
          this.mSm.log("addStateInternal: X stateInfo: ".concat(String.valueOf(localObject1)));
        }
        AppMethodBeat.o(230450);
        return localObject1;
        label216:
        paramState2 = (State)localObject1;
        continue;
        label221:
        paramState2 = null;
      }
    }
    
    private final void cleanupAfterQuitting()
    {
      AppMethodBeat.i(230446);
      if (this.mSm.mSmThread != null)
      {
        getLooper().quit();
        StateMachine.access$402(this.mSm, null);
      }
      StateMachine.access$502(this.mSm, null);
      this.mSm = null;
      this.mMsg = null;
      this.mLogRecords.cleanup();
      this.mStateStack = null;
      this.mTempStateStack = null;
      this.mStateInfo.clear();
      this.mInitialState = null;
      this.mDestState = null;
      this.mDeferredMessages.clear();
      this.mHasQuit = true;
      AppMethodBeat.o(230446);
    }
    
    private final void completeConstruction()
    {
      AppMethodBeat.i(230447);
      if (this.mDbg) {
        this.mSm.log("completeConstruction: E");
      }
      Iterator localIterator = this.mStateInfo.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        StateInfo localStateInfo = (StateInfo)localIterator.next();
        int j = 0;
        while (localStateInfo != null)
        {
          localStateInfo = localStateInfo.parentStateInfo;
          j += 1;
        }
        if (i >= j) {
          break label170;
        }
        i = j;
      }
      label170:
      for (;;)
      {
        break;
        if (this.mDbg) {
          this.mSm.log("completeConstruction: maxDepth=".concat(String.valueOf(i)));
        }
        this.mStateStack = new StateInfo[i];
        this.mTempStateStack = new StateInfo[i];
        setupInitialStateStack();
        sendMessageAtFrontOfQueue(obtainMessage(-2, mSmHandlerObj));
        if (this.mDbg) {
          this.mSm.log("completeConstruction: X");
        }
        AppMethodBeat.o(230447);
        return;
      }
    }
    
    private final void deferMessage(Message paramMessage)
    {
      AppMethodBeat.i(230452);
      if (this.mDbg) {
        this.mSm.log("deferMessage: msg=" + paramMessage.what);
      }
      Message localMessage = obtainMessage();
      localMessage.copyFrom(paramMessage);
      this.mDeferredMessages.add(localMessage);
      AppMethodBeat.o(230452);
    }
    
    private final Message getCurrentMessage()
    {
      return this.mMsg;
    }
    
    private final IState getCurrentState()
    {
      return this.mStateStack[this.mStateStackTopIndex].state;
    }
    
    private final void invokeEnterMethods(int paramInt)
    {
      AppMethodBeat.i(158023);
      while (paramInt <= this.mStateStackTopIndex)
      {
        if (this.mDbg) {
          this.mSm.log("invokeEnterMethods: " + this.mStateStack[paramInt].state.getName());
        }
        this.mStateStack[paramInt].state.enter();
        this.mStateStack[paramInt].active = true;
        paramInt += 1;
      }
      AppMethodBeat.o(158023);
    }
    
    private final void invokeExitMethods(StateInfo paramStateInfo)
    {
      AppMethodBeat.i(158022);
      while ((this.mStateStackTopIndex >= 0) && (this.mStateStack[this.mStateStackTopIndex] != paramStateInfo))
      {
        State localState = this.mStateStack[this.mStateStackTopIndex].state;
        if (this.mDbg) {
          this.mSm.log("invokeExitMethods: " + localState.getName());
        }
        localState.exit();
        this.mStateStack[this.mStateStackTopIndex].active = false;
        this.mStateStackTopIndex -= 1;
      }
      AppMethodBeat.o(158022);
    }
    
    private final boolean isDbg()
    {
      return this.mDbg;
    }
    
    private final boolean isQuit(Message paramMessage)
    {
      return (paramMessage.what == -1) && (paramMessage.obj == mSmHandlerObj);
    }
    
    private final void moveDeferredMessageAtFrontOfQueue()
    {
      AppMethodBeat.i(158024);
      int i = this.mDeferredMessages.size() - 1;
      while (i >= 0)
      {
        Message localMessage = (Message)this.mDeferredMessages.get(i);
        if (this.mDbg) {
          this.mSm.log("moveDeferredMessageAtFrontOfQueue; what=" + localMessage.what);
        }
        sendMessageAtFrontOfQueue(localMessage);
        i -= 1;
      }
      this.mDeferredMessages.clear();
      AppMethodBeat.o(158024);
    }
    
    private final int moveTempStateStackToStateStack()
    {
      AppMethodBeat.i(158025);
      int k = this.mStateStackTopIndex + 1;
      int i = this.mTempStateStackCount - 1;
      int j = k;
      while (i >= 0)
      {
        if (this.mDbg) {
          this.mSm.log("moveTempStackToStateStack: i=" + i + ",j=" + j);
        }
        this.mStateStack[j] = this.mTempStateStack[i];
        j += 1;
        i -= 1;
      }
      this.mStateStackTopIndex = (j - 1);
      if (this.mDbg) {
        this.mSm.log("moveTempStackToStateStack: X mStateStackTop=" + this.mStateStackTopIndex + ",startingIndex=" + k + ",Top=" + this.mStateStack[this.mStateStackTopIndex].state.getName());
      }
      AppMethodBeat.o(158025);
      return k;
    }
    
    private void performTransitions(State paramState, Message paramMessage)
    {
      AppMethodBeat.i(158020);
      State localState = this.mStateStack[this.mStateStackTopIndex].state;
      int i;
      if ((this.mSm.recordLogRec(this.mMsg)) && (paramMessage.obj != mSmHandlerObj))
      {
        i = 1;
        if (!this.mLogRecords.logOnlyTransitions()) {
          break label166;
        }
        if (this.mDestState != null) {
          this.mLogRecords.add(this.mSm, this.mMsg, this.mSm.getLogRecString(this.mMsg), paramState, localState, this.mDestState);
        }
      }
      for (;;)
      {
        paramState = this.mDestState;
        paramMessage = paramState;
        if (paramState == null) {
          break label213;
        }
        for (;;)
        {
          if (this.mDbg) {
            this.mSm.log("handleMessage: new destination call exit/enter");
          }
          invokeExitMethods(setupTempStateStackWithStatesToEnter(paramState));
          invokeEnterMethods(moveTempStateStackToStateStack());
          moveDeferredMessageAtFrontOfQueue();
          if (paramState == this.mDestState) {
            break;
          }
          paramState = this.mDestState;
        }
        i = 0;
        break;
        label166:
        if (i != 0) {
          this.mLogRecords.add(this.mSm, this.mMsg, this.mSm.getLogRecString(this.mMsg), paramState, localState, this.mDestState);
        }
      }
      this.mDestState = null;
      paramMessage = paramState;
      label213:
      if (paramMessage != null)
      {
        if (paramMessage == this.mQuittingState)
        {
          this.mSm.onQuitting();
          cleanupAfterQuitting();
          AppMethodBeat.o(158020);
          return;
        }
        if (paramMessage == this.mHaltingState) {
          this.mSm.onHalting();
        }
      }
      AppMethodBeat.o(158020);
    }
    
    private final State processMsg(Message paramMessage)
    {
      AppMethodBeat.i(158021);
      Object localObject2 = this.mStateStack[this.mStateStackTopIndex];
      if (this.mDbg) {
        this.mSm.log("processMsg: " + ((StateInfo)localObject2).state.getName());
      }
      Object localObject1 = localObject2;
      if (isQuit(paramMessage)) {
        transitionTo(this.mQuittingState);
      }
      while (localObject2 != null)
      {
        paramMessage = ((StateInfo)localObject2).state;
        AppMethodBeat.o(158021);
        return paramMessage;
        do
        {
          localObject1 = localObject2;
          if (this.mDbg)
          {
            this.mSm.log("processMsg: " + ((StateInfo)localObject2).state.getName());
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1.state.processMessage(paramMessage)) {
            break;
          }
          localObject2 = localObject1.parentStateInfo;
        } while (localObject2 != null);
        this.mSm.unhandledMessage(paramMessage);
      }
      AppMethodBeat.o(158021);
      return null;
    }
    
    private final void quit()
    {
      AppMethodBeat.i(230453);
      if (this.mDbg) {
        this.mSm.log("quit:");
      }
      sendMessage(obtainMessage(-1, mSmHandlerObj));
      AppMethodBeat.o(230453);
    }
    
    private final void quitNow()
    {
      AppMethodBeat.i(230454);
      if (this.mDbg) {
        this.mSm.log("quitNow:");
      }
      sendMessageAtFrontOfQueue(obtainMessage(-1, mSmHandlerObj));
      AppMethodBeat.o(230454);
    }
    
    private final void setDbg(boolean paramBoolean)
    {
      this.mDbg = paramBoolean;
    }
    
    private final void setInitialState(State paramState)
    {
      AppMethodBeat.i(230451);
      if (this.mDbg) {
        this.mSm.log("setInitialState: initialState=" + paramState.getName());
      }
      this.mInitialState = paramState;
      AppMethodBeat.o(230451);
    }
    
    private final void setupInitialStateStack()
    {
      AppMethodBeat.i(230449);
      if (this.mDbg) {
        this.mSm.log("setupInitialStateStack: E mInitialState=" + this.mInitialState.getName());
      }
      StateInfo localStateInfo = (StateInfo)this.mStateInfo.get(this.mInitialState);
      for (this.mTempStateStackCount = 0; localStateInfo != null; this.mTempStateStackCount += 1)
      {
        this.mTempStateStack[this.mTempStateStackCount] = localStateInfo;
        localStateInfo = localStateInfo.parentStateInfo;
      }
      this.mStateStackTopIndex = -1;
      moveTempStateStackToStateStack();
      AppMethodBeat.o(230449);
    }
    
    private final StateInfo setupTempStateStackWithStatesToEnter(State paramState)
    {
      AppMethodBeat.i(230448);
      this.mTempStateStackCount = 0;
      paramState = (StateInfo)this.mStateInfo.get(paramState);
      Object localObject;
      do
      {
        localObject = this.mTempStateStack;
        int i = this.mTempStateStackCount;
        this.mTempStateStackCount = (i + 1);
        localObject[i] = paramState;
        localObject = paramState.parentStateInfo;
        if (localObject == null) {
          break;
        }
        paramState = (State)localObject;
      } while (!((StateInfo)localObject).active);
      if (this.mDbg) {
        this.mSm.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.mTempStateStackCount + ",curStateInfo: " + localObject);
      }
      AppMethodBeat.o(230448);
      return localObject;
    }
    
    private final void transitionTo(IState paramIState)
    {
      AppMethodBeat.i(158028);
      this.mDestState = ((State)paramIState);
      if (this.mDbg) {
        this.mSm.log("transitionTo: destState=" + this.mDestState.getName());
      }
      AppMethodBeat.o(158028);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(158019);
      State localState;
      if (!this.mHasQuit)
      {
        if (this.mDbg) {
          this.mSm.log("handleMessage: E msg.what=" + paramMessage.what);
        }
        this.mMsg = paramMessage;
        localState = null;
        if (!this.mIsConstructionCompleted) {
          break label104;
        }
        localState = processMsg(paramMessage);
      }
      for (;;)
      {
        performTransitions(localState, paramMessage);
        if ((this.mDbg) && (this.mSm != null)) {
          this.mSm.log("handleMessage: X");
        }
        AppMethodBeat.o(158019);
        return;
        label104:
        if ((this.mIsConstructionCompleted) || (this.mMsg.what != -2) || (this.mMsg.obj != mSmHandlerObj)) {
          break;
        }
        this.mIsConstructionCompleted = true;
        invokeEnterMethods(0);
      }
      paramMessage = new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: ".concat(String.valueOf(paramMessage)));
      AppMethodBeat.o(158019);
      throw paramMessage;
    }
    
    class HaltingState
      extends State
    {
      private HaltingState() {}
      
      public boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(158017);
        StateMachine.this.haltedProcessMessage(paramMessage);
        AppMethodBeat.o(158017);
        return true;
      }
    }
    
    class QuittingState
      extends State
    {
      private QuittingState() {}
      
      public boolean processMessage(Message paramMessage)
      {
        return false;
      }
    }
    
    class StateInfo
    {
      boolean active;
      StateInfo parentStateInfo;
      State state;
      
      private StateInfo() {}
      
      public String toString()
      {
        AppMethodBeat.i(158018);
        StringBuilder localStringBuilder = new StringBuilder("state=").append(this.state.getName()).append(",active=").append(this.active).append(",parent=");
        if (this.parentStateInfo == null) {}
        for (String str = "null";; str = this.parentStateInfo.state.getName())
        {
          str = str;
          AppMethodBeat.o(158018);
          return str;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.statemachine.StateMachine
 * JD-Core Version:    0.7.0.1
 */