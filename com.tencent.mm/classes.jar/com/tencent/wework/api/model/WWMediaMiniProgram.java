package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaMiniProgram
  extends WWMediaMessage.WWMediaObject
{
  public byte[] ZYw;
  public int ZYx;
  public String iconUrl;
  public String name;
  public String path;
  public String title;
  public int type;
  public String username;
  public String webpageUrl;
  
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
    if ((this.ZYw == null) || (this.ZYw.length <= 0) || (this.ZYw.length > 1048576))
    {
      AppMethodBeat.o(106553);
      return false;
    }
    AppMethodBeat.o(106553);
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(233426);
    this.username = paramBundle.getString("_wwwxaobject_userName");
    this.path = paramBundle.getString("_wwwxaobject_path");
    this.iconUrl = paramBundle.getString("_wwwxaobject_iconUrl");
    this.name = paramBundle.getString("_wwwxaobject_name");
    this.title = paramBundle.getString("_wwwxaobject_title");
    this.ZYw = paramBundle.getByteArray("_wwwxaobject_hdImageData");
    this.type = paramBundle.getInt("_wwwxaobject_type", 2);
    this.webpageUrl = paramBundle.getString("_wwwxaobject_webpageurl");
    this.ZYx = paramBundle.getInt("_wwwxaobject_programtype", 0);
    super.fromBundle(paramBundle);
    AppMethodBeat.o(233426);
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
        break label149;
      }
      str = "";
      label42:
      paramBundle.putString("_wwwxaobject_iconUrl", str);
      if (this.name != null) {
        break label157;
      }
      str = "";
      label59:
      paramBundle.putString("_wwwxaobject_name", str);
      if (this.title != null) {
        break label165;
      }
      str = "";
      label76:
      paramBundle.putString("_wwwxaobject_title", str);
      paramBundle.putByteArray("_wwwxaobject_hdImageData", this.ZYw);
      paramBundle.putInt("_wwwxaobject_type", this.type);
      if (this.webpageUrl != null) {
        break label173;
      }
    }
    label149:
    label157:
    label165:
    label173:
    for (String str = "";; str = this.webpageUrl)
    {
      paramBundle.putString("_wwwxaobject_webpageurl", str);
      paramBundle.putInt("_wwwxaobject_programtype", this.ZYx);
      super.toBundle(paramBundle);
      AppMethodBeat.o(106554);
      return;
      str = this.path;
      break;
      str = this.iconUrl;
      break label42;
      str = this.name;
      break label59;
      str = this.title;
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMiniProgram
 * JD-Core Version:    0.7.0.1
 */