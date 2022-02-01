package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaMiniProgram
  extends WWMediaMessage.WWMediaObject
{
  public byte[] aida;
  private Bundle aidb;
  public String iconUrl;
  public boolean isSecretMessage;
  public int miniProgramType;
  public String name;
  public String path;
  public int type;
  public String username;
  public String webpageUrl;
  
  public WWMediaMiniProgram()
  {
    AppMethodBeat.i(210621);
    this.isSecretMessage = false;
    this.aidb = new Bundle();
    AppMethodBeat.o(210621);
  }
  
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
    if ((this.aida == null) || (this.aida.length <= 0) || (this.aida.length > 134217728))
    {
      AppMethodBeat.o(106553);
      return false;
    }
    AppMethodBeat.o(106553);
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(210633);
    this.username = paramBundle.getString("_wwwxaobject_userName");
    this.path = paramBundle.getString("_wwwxaobject_path");
    this.iconUrl = paramBundle.getString("_wwwxaobject_iconUrl");
    this.name = paramBundle.getString("_wwwxaobject_name");
    this.aida = paramBundle.getByteArray("_wwwxaobject_hdImageData");
    this.type = paramBundle.getInt("_wwwxaobject_type", 2);
    this.webpageUrl = paramBundle.getString("_wwwxaobject_webpageurl");
    this.miniProgramType = paramBundle.getInt("_wwwxaobject_programtype", 0);
    this.isSecretMessage = paramBundle.getBoolean("_wwwxminiprogram_issecretmsg", false);
    this.aidb = paramBundle.getBundle("_wwwxminiprogram_ext");
    super.fromBundle(paramBundle);
    AppMethodBeat.o(210633);
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
        break label152;
      }
      str = "";
      label42:
      paramBundle.putString("_wwwxaobject_iconUrl", str);
      if (this.name != null) {
        break label160;
      }
      str = "";
      label59:
      paramBundle.putString("_wwwxaobject_name", str);
      paramBundle.putByteArray("_wwwxaobject_hdImageData", this.aida);
      paramBundle.putInt("_wwwxaobject_type", this.type);
      if (this.webpageUrl != null) {
        break label168;
      }
    }
    label152:
    label160:
    label168:
    for (String str = "";; str = this.webpageUrl)
    {
      paramBundle.putString("_wwwxaobject_webpageurl", str);
      paramBundle.putInt("_wwwxaobject_programtype", this.miniProgramType);
      paramBundle.putBoolean("_wwwxminiprogram_issecretmsg", this.isSecretMessage);
      paramBundle.putBundle("_wwwxminiprogram_ext", this.aidb);
      super.toBundle(paramBundle);
      AppMethodBeat.o(106554);
      return;
      str = this.path;
      break;
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