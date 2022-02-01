package com.tencent.tav.report;

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
    AppMethodBeat.i(214861);
    this.startTimeMs = 0L;
    this.startName = "";
    this.enable = false;
    this.maxPrintCount = 0;
    this.startIndex = 0L;
    this.list = new ArrayList();
    AppMethodBeat.o(214861);
  }
  
  public static void clearFiles() {}
  
  public static ByteBuffer clone(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(214896);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.capacity());
    paramByteBuffer.rewind();
    localByteBuffer.put(paramByteBuffer);
    paramByteBuffer.rewind();
    localByteBuffer.flip();
    AppMethodBeat.o(214896);
    return localByteBuffer;
  }
  
  public static ShortBuffer clone(ShortBuffer paramShortBuffer)
  {
    AppMethodBeat.i(214900);
    ShortBuffer localShortBuffer = ShortBuffer.allocate(paramShortBuffer.capacity());
    paramShortBuffer.rewind();
    localShortBuffer.put(paramShortBuffer);
    paramShortBuffer.rewind();
    localShortBuffer.flip();
    AppMethodBeat.o(214900);
    return localShortBuffer;
  }
  
  public static File createNewFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214945);
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) && (!paramString1.mkdirs()))
    {
      AppMethodBeat.o(214945);
      return null;
    }
    paramString1 = new File(paramString1, paramString2);
    try
    {
      paramString1.delete();
      if (!paramString1.createNewFile())
      {
        new StringBuilder("export: 创建输出文件失败:").append(paramString1.getAbsolutePath());
        AppMethodBeat.o(214945);
        return null;
      }
    }
    catch (IOException paramString1)
    {
      AppMethodBeat.o(214945);
      return null;
    }
    AppMethodBeat.o(214945);
    return paramString1;
  }
  
  private static void deleteAllFiles(File paramFile)
  {
    AppMethodBeat.i(214921);
    paramFile = paramFile.listFiles();
    if (paramFile == null)
    {
      AppMethodBeat.o(214921);
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
    AppMethodBeat.o(214921);
  }
  
  public static AudioBufferPrintHelper getInstance()
  {
    AppMethodBeat.i(214871);
    AudioBufferPrintHelper localAudioBufferPrintHelper = Instance.INSTANCE;
    AppMethodBeat.o(214871);
    return localAudioBufferPrintHelper;
  }
  
  private void initFlag(int paramInt)
  {
    AppMethodBeat.i(214932);
    if (this.startTimeMs == 0L)
    {
      this.startTimeMs = System.currentTimeMillis();
      this.startName = new SimpleDateFormat("HHmmss").format(new Date(this.startTimeMs));
    }
    if (this.maxPrintCount == 0) {
      this.maxPrintCount = paramInt;
    }
    AppMethodBeat.o(214932);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(214883);
    Instance.access$002(new AudioBufferPrintHelper());
    AppMethodBeat.o(214883);
  }
  
  public void printByteBuffer(String paramString, ByteBuffer paramByteBuffer) {}
  
  public void printByteBuffer(String paramString, ShortBuffer paramShortBuffer) {}
  
  public void printByteBuffer(String paramString, short[] paramArrayOfShort) {}
  
  public void startDelay(long paramLong)
  {
    AppMethodBeat.i(214980);
    startDelay(paramLong, 100);
    AppMethodBeat.o(214980);
  }
  
  public void startDelay(long paramLong, int paramInt)
  {
    AppMethodBeat.i(214987);
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
      AppMethodBeat.o(214987);
      return;
    }
  }
  
  public void startIgnoreBegin(int paramInt)
  {
    AppMethodBeat.i(214956);
    startIgnoreBegin(paramInt, 100);
    AppMethodBeat.o(214956);
  }
  
  public void startIgnoreBegin(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214967);
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
    AppMethodBeat.o(214967);
  }
  
  static class Instance
  {
    private static AudioBufferPrintHelper INSTANCE;
    
    static
    {
      AppMethodBeat.i(214963);
      INSTANCE = new AudioBufferPrintHelper();
      AppMethodBeat.o(214963);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.report.AudioBufferPrintHelper
 * JD-Core Version:    0.7.0.1
 */