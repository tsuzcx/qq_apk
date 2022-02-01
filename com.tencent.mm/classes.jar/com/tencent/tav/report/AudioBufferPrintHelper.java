package com.tencent.tav.report;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AudioBufferPrintHelper
{
  public static final boolean CLEAR_MODE = false;
  public static final boolean ENABLE = false;
  public static final String SDCARD_TAVKIT_DEMO_INFO = "/sdcard/tavkit_demo/info/";
  private static final String TAG = "DebugUtils";
  private boolean enable;
  private List<String> list;
  private int maxPrintCount;
  private long startIndex;
  private String startName;
  private long startTimeMs;
  private long waitMs;
  
  public AudioBufferPrintHelper()
  {
    AppMethodBeat.i(218704);
    this.startTimeMs = 0L;
    this.startName = "";
    this.enable = false;
    this.maxPrintCount = 0;
    this.startIndex = 0L;
    this.list = new ArrayList();
    AppMethodBeat.o(218704);
  }
  
  public static void clearFiles() {}
  
  public static ByteBuffer clone(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(218707);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.capacity());
    paramByteBuffer.rewind();
    localByteBuffer.put(paramByteBuffer);
    paramByteBuffer.rewind();
    localByteBuffer.flip();
    AppMethodBeat.o(218707);
    return localByteBuffer;
  }
  
  public static ShortBuffer clone(ShortBuffer paramShortBuffer)
  {
    AppMethodBeat.i(218708);
    ShortBuffer localShortBuffer = ShortBuffer.allocate(paramShortBuffer.capacity());
    paramShortBuffer.rewind();
    localShortBuffer.put(paramShortBuffer);
    paramShortBuffer.rewind();
    localShortBuffer.flip();
    AppMethodBeat.o(218708);
    return localShortBuffer;
  }
  
  public static File createNewFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218715);
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) && (!paramString1.mkdirs()))
    {
      AppMethodBeat.o(218715);
      return null;
    }
    paramString1 = new File(paramString1, paramString2);
    try
    {
      paramString1.delete();
      if (!paramString1.createNewFile())
      {
        new StringBuilder("export: 创建输出文件失败:").append(paramString1.getAbsolutePath());
        AppMethodBeat.o(218715);
        return null;
      }
    }
    catch (IOException paramString1)
    {
      AppMethodBeat.o(218715);
      return null;
    }
    AppMethodBeat.o(218715);
    return paramString1;
  }
  
  private static void deleteAllFiles(File paramFile)
  {
    AppMethodBeat.i(218709);
    paramFile = paramFile.listFiles();
    if (paramFile == null)
    {
      AppMethodBeat.o(218709);
      return;
    }
    int j = paramFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory())
      {
        deleteAllFiles(localFile);
        localFile.delete();
      }
      for (;;)
      {
        i += 1;
        break;
        if (localFile.exists())
        {
          deleteAllFiles(localFile);
          localFile.delete();
        }
      }
    }
    AppMethodBeat.o(218709);
  }
  
  public static AudioBufferPrintHelper getInstance()
  {
    AppMethodBeat.i(218705);
    AudioBufferPrintHelper localAudioBufferPrintHelper = Instance.INSTANCE;
    AppMethodBeat.o(218705);
    return localAudioBufferPrintHelper;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private void initFlag(int paramInt)
  {
    AppMethodBeat.i(218714);
    if (this.startTimeMs == 0L)
    {
      this.startTimeMs = System.currentTimeMillis();
      this.startName = new SimpleDateFormat("HHmmss").format(new Date(this.startTimeMs));
    }
    if (this.maxPrintCount == 0) {
      this.maxPrintCount = paramInt;
    }
    AppMethodBeat.o(218714);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(218706);
    Instance.access$002(new AudioBufferPrintHelper());
    AppMethodBeat.o(218706);
  }
  
  public void printByteBuffer(String paramString, ByteBuffer paramByteBuffer) {}
  
  public void printByteBuffer(String paramString, ShortBuffer paramShortBuffer) {}
  
  public void printByteBuffer(String paramString, short[] paramArrayOfShort) {}
  
  public void startDelay(long paramLong)
  {
    AppMethodBeat.i(218712);
    startDelay(paramLong, 100);
    AppMethodBeat.o(218712);
  }
  
  public void startDelay(long paramLong, int paramInt)
  {
    AppMethodBeat.i(218713);
    initFlag(paramInt);
    if (System.currentTimeMillis() >= this.startTimeMs + paramLong) {}
    for (boolean bool = true;; bool = false)
    {
      this.enable = bool;
      if (this.enable)
      {
        paramInt = this.maxPrintCount;
        this.maxPrintCount = (paramInt - 1);
        if (paramInt < 0) {
          this.enable = false;
        }
      }
      AppMethodBeat.o(218713);
      return;
    }
  }
  
  public void startIgnoreBegin(int paramInt)
  {
    AppMethodBeat.i(218710);
    startIgnoreBegin(paramInt, 100);
    AppMethodBeat.o(218710);
  }
  
  public void startIgnoreBegin(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218711);
    initFlag(paramInt2);
    long l = this.startIndex;
    this.startIndex = (1L + l);
    if (l > paramInt1) {
      this.enable = true;
    }
    if (this.enable)
    {
      paramInt1 = this.maxPrintCount;
      this.maxPrintCount = (paramInt1 - 1);
      if (paramInt1 < 0) {
        this.enable = false;
      }
    }
    AppMethodBeat.o(218711);
  }
  
  static class Instance
  {
    private static AudioBufferPrintHelper INSTANCE;
    
    static
    {
      AppMethodBeat.i(218703);
      INSTANCE = new AudioBufferPrintHelper();
      AppMethodBeat.o(218703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tav.report.AudioBufferPrintHelper
 * JD-Core Version:    0.7.0.1
 */