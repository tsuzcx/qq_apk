package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class k$a
{
  public JsapiPermissionWrapper uUR;
  public GeneralControlWrapper uUS;
  
  public k$a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    this.uUR = paramJsapiPermissionWrapper;
    this.uUS = paramGeneralControlWrapper;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(7687);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Permission: jsPerm = ");
    ((StringBuilder)localObject).append(this.uUR);
    ((StringBuilder)localObject).append(", genCtrl = ");
    ((StringBuilder)localObject).append(this.uUS);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(7687);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.k.a
 * JD-Core Version:    0.7.0.1
 */