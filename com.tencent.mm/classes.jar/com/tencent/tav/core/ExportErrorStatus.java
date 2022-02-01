package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleState;

public class ExportErrorStatus
{
  public static final int APPEND_BUFFER = -110;
  public static final int APPEND_VIDEO_SAMPLE_MAKE_CURRENT = -111;
  public static final int APPEND_VIDEO_SAMPLE_SWAP_BUFFERS = -113;
  public static final int AUDIO_CONFIGURE = -104;
  public static final int END_WRITE_AUDIO_SAMPLE = -124;
  public static final int END_WRITE_VIDEO_SAMPLE = -123;
  public static final int ERROR_CODE_AUDIO_EXPORTING = -15;
  public static final int ERROR_CODE_VIDEO_EXPORTING = -14;
  public static final int ERROR_FINISHING = -10;
  public static final int EXPORT_CANCEL = -11;
  public static final int RENDER_SAMPLE_BUFFER = -112;
  public static final int START_AUDIO_ENCODER = -102;
  public static final int START_VIDEO_ENCODER = -101;
  public static final int VIDEO_CONFIGURE = -103;
  public static final int WRITE_AUDIO_SAMPLE = -122;
  public static final int WRITE_VIDEO_SAMPLE = -121;
  public int code;
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
  
  public ExportErrorStatus(CMSampleState paramCMSampleState)
  {
    this((int)paramCMSampleState.getStateCode(), paramCMSampleState.getThrowable(), paramCMSampleState.getMsg());
    AppMethodBeat.i(214574);
    AppMethodBeat.o(214574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.ExportErrorStatus
 * JD-Core Version:    0.7.0.1
 */