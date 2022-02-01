package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaMiniProgram
  extends WWMediaMessage.WWMediaObject
{
  public byte[] IMb;
  public String iconUrl;
  public String name;
  public String path;
  public String title;
  public int type;
  public String username;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106553);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106553);
      return false;
    }
    if ((this.username == null) || (this.username.length() <= 0))
    {
      AppMethodBeat.o(106553);
      return false;
    }
    if ((this.IMb == null) || (this.IMb.length <= 0) || (this.IMb.length > 1048576))
    {
      AppMethodBeat.o(106553);
      return false;
    }
    AppMethodBeat.o(106553);
    return true;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106554);
    paramBundle.putString("_wwwxaobject_userName", this.username);
    if (this.path == null)
    {
      str = "";
      paramBundle.putString("_wwwxaobject_path", str);
      if (this.iconUrl != null) {
        break label122;
      }
      str = "";
      label42:
      paramBundle.putString("_wwwxaobject_iconUrl", str);
      if (this.name != null) {
        break label130;
      }
      str = "";
      label59:
      paramBundle.putString("_wwwxaobject_name", str);
      if (this.title != null) {
        break label138;
      }
    }
    label130:
    label138:
    for (String str = "";; str = this.title)
    {
      paramBundle.putString("_wwwxaobject_title", str);
      paramBundle.putByteArray("_wwwxaobject_hdImageData", this.IMb);
      paramBundle.putInt("_wwwxaobject_type", this.type);
      super.toBundle(paramBundle);
      AppMethodBeat.o(106554);
      return;
      str = this.path;
      break;
      label122:
      str = this.iconUrl;
      break label42;
      str = this.name;
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMiniProgram
 * JD-Core Version:    0.7.0.1
 */