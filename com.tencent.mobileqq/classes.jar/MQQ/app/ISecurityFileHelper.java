package mqq.app;

import java.io.File;

public abstract interface ISecurityFileHelper
{
  public static final int REPORT_INFO_FILE_AMOUNT = 1;
  public static final int REPORT_INFO_FILE_SIZE = 0;
  public static final String TAG = "ISecurityFileHelper";
  
  public abstract String declareBusinessFileName();
  
  public abstract boolean doMigrate(File paramFile);
  
  public abstract boolean needMigration();
  
  public abstract File oldBusinessDir(String paramString);
  
  public abstract boolean oldBusinessDirExist(String paramString);
  
  public abstract String[] reportHistoryFileInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.ISecurityFileHelper
 * JD-Core Version:    0.7.0.1
 */