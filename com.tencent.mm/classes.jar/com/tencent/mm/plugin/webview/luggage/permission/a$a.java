package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class a$a
{
  public JsapiPermissionWrapper uUR;
  public GeneralControlWrapper uUS;
  
  public a$a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    this.uUR = paramJsapiPermissionWrapper;
    this.uUS = paramGeneralControlWrapper;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(6481);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Permission: jsPerm = ");
    ((StringBuilder)localObject).append(this.uUR);
    ((StringBuilder)localObject).append(", genCtrl = ");
    ((StringBuilder)localObject).append(this.uUS);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(6481);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.a.a
 * JD-Core Version:    0.7.0.1
 */