package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaFile
  extends WWMediaMessage.WWMediaObject
{
  private int contentLengthLimit = 104857600;
  public byte[] fileData;
  public String fileName;
  public String filePath;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(80499);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(80499);
      return false;
    }
    if (((this.fileData != null) && (this.fileData.length != 0)) || ((this.filePath != null) && (this.filePath.length() != 0)))
    {
      if ((this.fileData != null) && (this.fileData.length > this.contentLengthLimit))
      {
        AppMethodBeat.o(80499);
        return false;
      }
      if ((this.filePath != null) && (getFileSize(this.filePath) > this.contentLengthLimit))
      {
        AppMethodBeat.o(80499);
        return false;
      }
      AppMethodBeat.o(80499);
      return true;
    }
    AppMethodBeat.o(80499);
    return false;
  }
  
  public final void dYa()
  {
    this.contentLengthLimit = 104857600;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(80500);
    paramBundle.putByteArray("_wwfileobject_fileData", this.fileData);
    paramBundle.putString("_wwfileobject_filePath", this.filePath);
    paramBundle.putString("_wwfileobject_fileName", this.fileName);
    super.toBundle(paramBundle);
    AppMethodBeat.o(80500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaFile
 * JD-Core Version:    0.7.0.1
 */