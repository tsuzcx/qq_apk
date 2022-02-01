package com.tencent.wework.api.model;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.util.OpenDataUtils;

public class WWMediaFile
  extends WWMediaMessage.WWMediaObject
{
  private int contentLengthLimit = 104857600;
  public byte[] fileData;
  public String fileId;
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
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(190356);
    this.fileData = paramBundle.getByteArray("_wwfileobject_fileData");
    this.filePath = paramBundle.getString("_wwfileobject_filePath");
    this.fileName = paramBundle.getString("_wwfileobject_fileName");
    this.fileId = paramBundle.getString("_wwfileobject_fileId");
    super.fromBundle(paramBundle);
    AppMethodBeat.o(190356);
  }
  
  public final void setContentLengthLimit(int paramInt)
  {
    this.contentLengthLimit = paramInt;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106541);
    paramBundle.putByteArray("_wwfileobject_fileData", this.fileData);
    paramBundle.putString("_wwfileobject_filePath", this.filePath);
    paramBundle.putString("_wwfileobject_fileName", this.fileName);
    paramBundle.putString("_wwfileobject_fileId", this.fileId);
    super.toBundle(paramBundle);
    AppMethodBeat.o(106541);
  }
  
  public final void x(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(190357);
    if ((this.filePath != null) && (this.filePath.startsWith("content")))
    {
      paramIntent.setDataAndType(Uri.parse(this.filePath), "*/*");
      paramIntent.addFlags(1);
    }
    for (this.fileId = null;; this.fileId = OpenDataUtils.W(this.mContext, paramString, this.filePath))
    {
      paramIntent.putExtra("_wwfileobject_fileId", this.fileId);
      AppMethodBeat.o(190357);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaFile
 * JD-Core Version:    0.7.0.1
 */