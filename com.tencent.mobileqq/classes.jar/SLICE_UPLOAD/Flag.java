package SLICE_UPLOAD;

import java.io.Serializable;

public final class Flag
  implements Serializable
{
  public static final int _FLAG_ERROR = 10;
  public static final int _FLAG_FILECOMPLETE = 1;
  public static final int _FLAG_FILENEEDCOMMIT = 2;
  public static final int _FLAG_RETRY_CTRL_NOSESSION = 13;
  public static final int _FLAG_RETRY_CTRL_SESSION = 12;
  public static final int _FLAG_RETRY_CURRENT = 11;
  public static final int _FLAG_RETRY_RECONNECT_CTRL_NOSESSION = 14;
  public static final int _FLAG_SUCC = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.Flag
 * JD-Core Version:    0.7.0.1
 */