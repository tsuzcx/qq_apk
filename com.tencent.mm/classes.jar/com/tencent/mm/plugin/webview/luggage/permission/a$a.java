package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class a$a
{
  public JsapiPermissionWrapper reJ;
  public GeneralControlWrapper reK;
  
  public a$a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    this.reJ = paramJsapiPermissionWrapper;
    this.reK = paramGeneralControlWrapper;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Permission: jsPerm = ");
    localStringBuilder.append(this.reJ);
    localStringBuilder.append(", genCtrl = ");
    localStringBuilder.append(this.reK);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.a.a
 * JD-Core Version:    0.7.0.1
 */