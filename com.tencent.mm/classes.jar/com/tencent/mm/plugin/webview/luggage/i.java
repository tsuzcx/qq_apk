package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.tencent.mm.R.l;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a;
import com.tencent.mm.plugin.webview.luggage.d.c.b;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.xweb.WebView.b;

public final class i
  implements View.OnCreateContextMenuListener
{
  j gGp;
  String gGq;
  int gGr;
  int gGs;
  h gGt;
  WebView.b gGu;
  WebView.b gGv;
  private h.c gGz = new i.1(this);
  private a.b kNz = new i.8(this);
  e rcp;
  
  public i(e parame)
  {
    this.rcp = parame;
    this.gGp = new j(parame.mContext);
    this.gGp.a(parame.rbA, this, null);
    this.gGp.d(new i.2(this));
  }
  
  private boolean a(ContextMenu paramContextMenu, String paramString)
  {
    if (!com.tencent.mm.compatible.util.f.zF())
    {
      y.e("MicroMsg.GameWebViewMenuListHelper", "SD card unavailable");
      return true;
    }
    boolean bool;
    Object localObject;
    if (ae.cqV())
    {
      bool = au.DK();
      paramContextMenu.setHeaderTitle(R.l.wv_image);
      y.i("MicroMsg.GameWebViewMenuListHelper", "hasSetAcc = %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        paramContextMenu.add(0, 0, 0, this.rcp.mContext.getString(R.l.readerapp_alert_retransmit)).setOnMenuItemClickListener(new i.4(this, paramString));
      }
      paramContextMenu.add(0, 0, 0, this.rcp.mContext.getString(R.l.save_to_local)).setOnMenuItemClickListener(new i.5(this, paramString));
      if (bool) {
        paramContextMenu.add(0, 0, 0, this.rcp.mContext.getString(R.l.plugin_favorite_opt)).setOnMenuItemClickListener(new i.6(this, paramString));
      }
      if (this.gGq == null) {
        break label345;
      }
      localObject = this.gGq;
      if (a.wM(this.gGr)) {
        break label328;
      }
      if (!a.aD(this.gGr, this.gGq)) {
        break label301;
      }
      paramString = this.rcp.mContext.getString(R.l.recog_wxcode_of_image_file);
    }
    for (;;)
    {
      if (!bk.bl(paramString)) {
        paramContextMenu.add(0, 0, 0, paramString).setOnMenuItemClickListener(new i.7(this, (String)localObject));
      }
      this.gGq = null;
      return true;
      localObject = (Bundle)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", null, c.b.class);
      if (localObject != null)
      {
        bool = ((Bundle)localObject).getBoolean("has_set_uin", false);
        break;
      }
      bool = true;
      break;
      label301:
      if (a.wL(this.gGr)) {
        paramString = this.rcp.mContext.getString(R.l.recog_barcode_of_image_file);
      } else {
        label328:
        paramString = this.rcp.mContext.getString(R.l.recog_qbar_of_image_file);
      }
    }
    label345:
    return false;
  }
  
  private static boolean cbj()
  {
    IPCBoolean localIPCBoolean = (IPCBoolean)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", null, i.b.class);
    if (localIPCBoolean != null) {
      return localIPCBoolean.value;
    }
    return true;
  }
  
  final void a(ContextMenu paramContextMenu, WebView.b paramb)
  {
    if ((!a(paramContextMenu, paramb.mExtra)) && (this.rcp.caW().RQ(this.rcp.getUrl()).coW()) && (cbj()))
    {
      this.gGv = paramb;
      this.gGt = new h();
      this.gGt.a(this.rcp.rbA, this.gGz);
    }
  }
  
  final void b(ContextMenu paramContextMenu, WebView.b paramb)
  {
    if ((!a(paramContextMenu, paramb.mExtra)) && (this.rcp.caW().RQ(this.rcp.getUrl()).coW()) && (cbj()))
    {
      this.gGu = paramb;
      this.gGt = new h();
      this.gGt.a(this.rcp.rbA, this.gGz);
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    y.d("MicroMsg.GameWebViewMenuListHelper", "onCreateContextMenu");
    if ((paramView instanceof WebView))
    {
      paramView = this.rcp.rbA.getHitTestResult();
      if (paramView != null) {}
    }
    do
    {
      do
      {
        return;
      } while ((paramView.mType != 5) && (paramView.mType != 8));
      b(paramContextMenu, paramView);
      return;
      paramView = this.rcp.rbA.getHitTestResult();
    } while ((paramView == null) || ((paramView.mType != 5) && (paramView.mType != 8)));
    a(paramContextMenu, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i
 * JD-Core Version:    0.7.0.1
 */