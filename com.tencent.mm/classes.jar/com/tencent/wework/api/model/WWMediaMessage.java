package com.tencent.wework.api.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public class WWMediaMessage
  extends WWBaseMessage
{
  public String description;
  public byte[] thumbData;
  public String title;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(80510);
    if ((this.thumbData != null) && (this.thumbData.length > 32768))
    {
      AppMethodBeat.o(80510);
      return false;
    }
    if ((this.title != null) && (this.title.length() > 512))
    {
      AppMethodBeat.o(80510);
      return false;
    }
    if ((this.description != null) && (this.description.length() > 1024))
    {
      AppMethodBeat.o(80510);
      return false;
    }
    AppMethodBeat.o(80510);
    return true;
  }
  
  public final void setThumbImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(140111);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.thumbData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      AppMethodBeat.o(140111);
      return;
    }
    catch (Exception paramBitmap)
    {
      AppMethodBeat.o(140111);
    }
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(80509);
    super.toBundle(paramBundle);
    paramBundle.putString("_wwobject_title", this.title);
    paramBundle.putString("_wwobject_description", this.description);
    paramBundle.putByteArray("_wwobject_thumbdata", this.thumbData);
    AppMethodBeat.o(80509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMessage
 * JD-Core Version:    0.7.0.1
 */