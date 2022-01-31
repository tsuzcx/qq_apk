package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaMiniProgram
  extends WWMediaMessage.WWMediaObject
{
  public byte[] BCN;
  public String iconUrl;
  public String name;
  public String path;
  public String title;
  public String username;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(80511);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(80511);
      return false;
    }
    if ((this.username == null) || (this.username.length() <= 0))
    {
      AppMethodBeat.o(80511);
      return false;
    }
    if ((this.BCN == null) || (this.BCN.length <= 0) || (this.BCN.length > 1048576))
    {
      AppMethodBeat.o(80511);
      return false;
    }
    AppMethodBeat.o(80511);
    return true;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(80512);
    paramBundle.putString("_wwwxaobject_userName", this.username);
    if (this.path == null)
    {
      str = "";
      paramBundle.putString("_wwwxaobject_path", str);
      if (this.iconUrl != null) {
        break label112;
      }
      str = "";
      label42:
      paramBundle.putString("_wwwxaobject_iconUrl", str);
      if (this.name != null) {
        break label120;
      }
      str = "";
      label59:
      paramBundle.putString("_wwwxaobject_name", str);
      if (this.title != null) {
        break label128;
      }
    }
    label128:
    for (String str = "";; str = this.title)
    {
      paramBundle.putString("_wwwxaobject_title", str);
      paramBundle.putByteArray("_wwwxaobject_hdImageData", this.BCN);
      super.toBundle(paramBundle);
      AppMethodBeat.o(80512);
      return;
      str = this.path;
      break;
      label112:
      str = this.iconUrl;
      break label42;
      label120:
      str = this.name;
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMiniProgram
 * JD-Core Version:    0.7.0.1
 */