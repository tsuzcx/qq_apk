package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkUpdater$PatchFileConfig
{
  public String originalFileName;
  public int originalFileType;
  public String patchEndFileMd5;
  public String patchFileName;
  public int type;
  
  public boolean isExtractedFile()
  {
    return this.originalFileType == 2;
  }
  
  public boolean isOriginalFileTypeApk()
  {
    return this.originalFileType == 1;
  }
  
  public boolean isTypeAdd()
  {
    return this.type == 1;
  }
  
  public boolean isTypeModify()
  {
    return this.type == 2;
  }
  
  public boolean isTypeRemove()
  {
    return this.type == 3;
  }
  
  public String toString()
  {
    AppMethodBeat.i(85909);
    String str = "PatchFileConfig type:" + this.type + ",originalFileType:" + this.originalFileType + ",originalFileName:" + this.originalFileName + ",patchFileName:" + this.patchFileName + ",patchEndFileMd5:" + this.patchEndFileMd5;
    AppMethodBeat.o(85909);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.PatchFileConfig
 * JD-Core Version:    0.7.0.1
 */