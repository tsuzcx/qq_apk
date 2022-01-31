package com.tencent.wework.api.model;

import android.os.Bundle;

public class WWMediaFile
  extends WWMediaMessage.WWMediaObject
{
  public int contentLengthLimit = 10485760;
  public byte[] fileData;
  public String fileName;
  public String filePath;
  
  public final boolean checkArgs()
  {
    if (!super.checkArgs()) {}
    while (((this.fileData == null) || (this.fileData.length == 0)) && ((this.filePath == null) || (this.filePath.length() == 0) || ((this.fileData != null) && (this.fileData.length > this.contentLengthLimit)) || ((this.filePath != null) && (getFileSize(this.filePath) > this.contentLengthLimit)))) {
      return false;
    }
    return true;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wwfileobject_fileData", this.fileData);
    paramBundle.putString("_wwfileobject_filePath", this.filePath);
    paramBundle.putString("_wwfileobject_fileName", this.fileName);
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaFile
 * JD-Core Version:    0.7.0.1
 */