package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.pluginsdk.model.a.a;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class j
  implements MMActivity.a
{
  WeakReference<Context> aqU;
  d fwu;
  c ofr;
  int vrR;
  boolean vrS;
  int vrT;
  j.e vrU;
  j.e vrV;
  String vrW;
  j.d vrX;
  c.a vrY;
  c.a vrZ;
  b.a vsa;
  final Runnable vsb;
  
  j()
  {
    AppMethodBeat.i(9837);
    this.vrS = false;
    this.ofr = null;
    this.vrY = null;
    this.vrZ = null;
    this.fwu = null;
    this.vsa = null;
    this.vsb = new j.1(this);
    AppMethodBeat.o(9837);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9836);
    Context localContext = (Context)this.aqU.get();
    if ((this.vrX == null) || (localContext == null)) {}
    for (;;)
    {
      if ((this.vrS) && (this.vrX != null)) {
        this.vrX.KV(this.vrR);
      }
      this.vrS = false;
      this.vrT = a.a.vKa.code;
      this.vrU = null;
      this.vrV = null;
      this.aqU = null;
      this.vrX = null;
      this.vrW = null;
      this.vrY = null;
      this.vrZ = null;
      if ((this.fwu != null) && (this.vsa != null)) {
        this.fwu.c(this.vsa);
      }
      this.fwu = null;
      this.vsa = null;
      if (this.ofr != null)
      {
        if (this.vrY != null) {
          this.ofr.a(this.vrY);
        }
        if (this.vrZ != null) {
          this.ofr.a(this.vrZ);
        }
      }
      this.ofr = null;
      this.vrY = null;
      this.vrZ = null;
      AppMethodBeat.o(9836);
      return;
      if (!this.vrS)
      {
        ab.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
      }
      else if (paramInt1 != 33)
      {
        ab.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", new Object[] { Integer.valueOf(paramInt1) });
        this.vrX.onFail(this.vrR);
      }
      else if ((paramInt2 == 4097) || (paramInt2 == 0))
      {
        this.vrX.Cp(this.vrR);
      }
      else if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("selectpkg");
        if (bo.isNullOrNil(paramIntent))
        {
          ab.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
          this.vrX.onFail(this.vrR);
        }
        else
        {
          if (a.a.vKb.getPackage().equals(paramIntent)) {
            paramIntent = new j.c((byte)0);
          }
          for (;;)
          {
            paramIntent.a(localContext, this.vrU, this.vrV, this.vrW);
            this.vrX.onSuccess(this.vrR);
            break;
            if (a.a.vKd.getPackage().equals(paramIntent)) {
              paramIntent = new j.a((byte)0);
            } else if (a.a.vKc.getPackage().equals(paramIntent)) {
              paramIntent = new j.g((byte)0);
            } else if (a.a.vKe.getPackage().equals(paramIntent)) {
              paramIntent = new j.b((byte)0);
            } else {
              paramIntent = new j.h((byte)0);
            }
          }
        }
      }
      else
      {
        ab.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", new Object[] { Integer.valueOf(paramInt2) });
        this.vrX.onFail(this.vrR);
      }
    }
  }
  
  final void dgR()
  {
    Context localContext = null;
    AppMethodBeat.i(9838);
    this.vsa = null;
    this.vrY = null;
    this.vrZ = null;
    if (this.aqU == null) {}
    while (localContext == null)
    {
      AppMethodBeat.o(9838);
      return;
      localContext = (Context)this.aqU.get();
    }
    Intent localIntent = new Intent(localContext, AppChooserUI.class);
    Object localObject = new ArrayList(5);
    ((ArrayList)localObject).add(a.a.vKa.getPackage());
    ((ArrayList)localObject).add(a.a.vKb.getPackage());
    ((ArrayList)localObject).add(a.a.vKc.getPackage());
    ((ArrayList)localObject).add(a.a.vKd.getPackage());
    ((ArrayList)localObject).add(a.a.vKe.getPackage());
    localIntent.putStringArrayListExtra("targetwhitelist", (ArrayList)localObject);
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Double.valueOf(this.vrV.latitude), Double.valueOf(this.vrV.longitude) })));
    localIntent.putExtra("targetintent", (Parcelable)localObject);
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("key_map_app", this.vrT);
    localBundle.putParcelable("key_target_intent", (Parcelable)localObject);
    localIntent.putExtra("key_recommend_params", localBundle);
    localIntent.putExtra("type", 2);
    localIntent.putExtra("title", localContext.getString(2131306028));
    ((MMActivity)localContext).mmStartActivityForResult(this, localIntent, 33);
    AppMethodBeat.o(9838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j
 * JD-Core Version:    0.7.0.1
 */