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
    AppMethodBeat.i(106540);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106540);
      return false;
    }
    if (((this.fileData != null) && (this.fileData.length != 0)) || ((this.filePath != null) && (this.filePath.length() != 0)))
    {
      if ((this.fileData != null) && (this.fileData.length > this.contentLengthLimit))
      {
        AppMethodBeat.o(106540);
        return false;
      }
      if ((this.filePath != null) && (getFileSize(this.filePath) > this.contentLengthLimit))
      {
        AppMethodBeat.o(106540);
        return false;
      }
      AppMethodBeat.o(106540);
      return true;
    }
    AppMethodBeat.o(106540);
    return false;
  }
  
  public final void fqr()
  {
    this.contentLengthLimit = 104857600;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106541);
    paramBundle.putByteArray("_wwfileobject_fileData", this.fileData);
    paramBundle.putString("_wwfileobject_filePath", this.filePath);
    paramBundle.putString("_wwfileobject_fileName", this.fileName);
    super.toBundle(paramBundle);
    AppMethodBeat.o(106541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaFile
 * JD-Core Version:    0.7.0.1
 */