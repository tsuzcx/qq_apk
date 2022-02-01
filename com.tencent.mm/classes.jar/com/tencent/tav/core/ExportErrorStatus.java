package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.coremedia.CMSampleState;

public class ExportErrorStatus
{
  public static final int APPEND_BUFFER = -110;
  public static final int APPEND_VIDEO_SAMPLE_MAKE_CURRENT = -111;
  public static final int APPEND_VIDEO_SAMPLE_SWAP_BUFFERS = -113;
  public static final int AUDIO_CONFIGURE = -104;
  public static final int AUDIO_DECODER = -202;
  public static final int AUDIO_FRAME_HANDLE_TIMEOUT = -204;
  public static final int END_WRITE_AUDIO_SAMPLE = -124;
  public static final int END_WRITE_VIDEO_SAMPLE = -123;
  public static final int ERROR_CODE_AUDIO_EXPORTING = -15;
  public static final int ERROR_CODE_VIDEO_EXPORTING = -14;
  public static final int ERROR_FINISHING = -10;
  public static final int EXPORT_CANCEL = -11;
  public static final int EXPORT_SUCCESS = 0;
  public static final int RENDER_SAMPLE_BUFFER = -112;
  public static final int START_AUDIO_ENCODER = -102;
  public static final int START_VIDEO_ENCODER = -101;
  public static final int VIDEO_CONFIGURE = -103;
  public static final int VIDEO_DECODER = -201;
  public static final int VIDEO_FRAME_HANDLE_TIMEOUT = -203;
  public static final int VIDEO_MUXER_ERROR = -205;
  public static final int WRITE_AUDIO_SAMPLE = -122;
  public static final int WRITE_VIDEO_SAMPLE = -121;
  public int code;
  public PipelineIndicatorInfo indicatorInfo;
  public String msg;
  public Throwable throwable;
  
  public ExportErrorStatus(int paramInt)
  {
    this(paramInt, null);
  }
  
  public ExportErrorStatus(int paramInt, Throwable paramThrowable)
  {
    this(paramInt, paramThrowable, null);
  }
  
  public ExportErrorStatus(int paramInt, Throwable paramThrowable, String paramString)
  {
    this.code = paramInt;
    this.throwable = paramThrowable;
    this.msg = paramString;
  }
  
  public ExportErrorStatus(int paramInt, Throwable paramThrowable, String paramString, PipelineIndicatorInfo paramPipelineIndicatorInfo)
  {
    this(paramInt, paramThrowable, paramString);
    this.indicatorInfo = paramPipelineIndicatorInfo;
  }
  
  public ExportErrorStatus(CMSampleState paramCMSampleState)
  {
    this(getErrCode(paramCMSampleState), paramCMSampleState.getThrowable(), paramCMSampleState.getMsg());
    AppMethodBeat.i(215452);
    AppMethodBeat.o(215452);
  }
  
  private static int getErrCode(CMSampleState paramCMSampleState)
  {
    AppMethodBeat.i(215457);
    int j = paramCMSampleState.getExportCode();
    int i = j;
    if (j == 0) {
      i = (int)paramCMSampleState.getStateCode();
    }
    AppMethodBeat.o(215457);
    return i;
  }
  
  public static boolean hardwareError(int paramInt)
  {
    return (paramInt == -101) || (paramInt == -102) || (paramInt == -103) || (paramInt == -104);
  }
  
  public String toString()
  {
    AppMethodBeat.i(215472);
    String str = "ExportErrorStatus{code=" + this.code + ", throwable=" + this.throwable + ", msg='" + this.msg + '\'' + ", indicatorInfo=" + this.indicatorInfo + '}';
    AppMethodBeat.o(215472);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.ExportErrorStatus
 * JD-Core Version:    0.7.0.1
 */