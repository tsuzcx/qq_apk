package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class WWMediaMessage
  extends WWBaseMessage
{
  public String description;
  public byte[] thumbData;
  public String title;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(106552);
    if ((this.thumbData != null) && (this.thumbData.length > 32768))
    {
      AppMethodBeat.o(106552);
      return false;
    }
    if ((this.title != null) && (this.title.length() > 512))
    {
      AppMethodBeat.o(106552);
      return false;
    }
    if ((this.description != null) && (this.description.length() > 1024))
    {
      AppMethodBeat.o(106552);
      return false;
    }
    AppMethodBeat.o(106552);
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(210630);
    super.fromBundle(paramBundle);
    this.title = paramBundle.getString("_wwobject_title");
    this.description = paramBundle.getString("_wwobject_description");
    this.thumbData = paramBundle.getByteArray("_wwobject_thumbdata");
    AppMethodBeat.o(210630);
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106550);
    super.toBundle(paramBundle);
    paramBundle.putString("_wwobject_title", this.title);
    paramBundle.putString("_wwobject_description", this.description);
    paramBundle.putByteArray("_wwobject_thumbdata", this.thumbData);
    AppMethodBeat.o(106550);
  }
  
  public static abstract class WWMediaObject
    extends WWMediaMessage
  {
    protected static int getFileSize(String paramString)
    {
      if ((paramString != null) && (paramString.length() != 0))
      {
        paramString = new File(paramString);
        if (paramString.exists()) {
          return (int)paramString.length();
        }
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMessage
 * JD-Core Version:    0.7.0.1
 */