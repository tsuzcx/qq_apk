package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$a
{
  int IOx;
  boolean IPu;
  Bundle dNV;
  String dVP;
  String data;
  
  public j$a(int paramInt, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
  {
    this.IOx = paramInt;
    this.data = paramString1;
    this.IPu = paramBoolean;
    this.dVP = paramString2;
    this.dNV = paramBundle;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210847);
    String str = "NetReqResult{webviewId=" + this.IOx + ", data='" + this.data + '\'' + ", isNewQuery=" + this.IPu + ", reqId='" + this.dVP + '\'' + ", extData=" + this.dNV + '}';
    AppMethodBeat.o(210847);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.j.a
 * JD-Core Version:    0.7.0.1
 */