package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.scanner.a;
import com.tencent.mm.plugin.webview.luggage.c.b.b;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.xweb.WebView.b;

public final class h
  implements View.OnCreateContextMenuListener
{
  l igW;
  String igX;
  int igY;
  int igZ;
  com.tencent.mm.plugin.webview.modeltools.h iha;
  WebView.b ihb;
  WebView.b ihc;
  private com.tencent.mm.plugin.webview.modeltools.h.c ihh;
  private a.b nkf;
  public e uSb;
  
  public h(e parame)
  {
    AppMethodBeat.i(6144);
    this.ihh = new com.tencent.mm.plugin.webview.modeltools.h.c()
    {
      public final void Dd(String paramAnonymousString)
      {
        AppMethodBeat.i(6120);
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 1);
        localBundle.putString("img_path", paramAnonymousString);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", localBundle, h.c.class, new h.1.1(this));
        AppMethodBeat.o(6120);
      }
    };
    this.nkf = new a.b()
    {
      public final void aVA()
      {
        AppMethodBeat.i(6130);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        AppBrandMainProcessService.a(localFavUrlTask);
        AppMethodBeat.o(6130);
      }
    };
    this.uSb = parame;
    this.igW = new l(parame.mContext);
    this.igW.a(parame.getWebView(), this, null);
    this.igW.setOnCancelListener(new h.2(this));
    AppMethodBeat.o(6144);
  }
  
  private boolean a(ContextMenu paramContextMenu, String paramString)
  {
    AppMethodBeat.i(6146);
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      ab.e("MicroMsg.GameWebViewMenuListHelper", "SD card unavailable");
      AppMethodBeat.o(6146);
      return true;
    }
    boolean bool;
    Object localObject;
    if (ah.brt())
    {
      bool = g.RG();
      paramContextMenu.setHeaderTitle(2131306023);
      ab.i("MicroMsg.GameWebViewMenuListHelper", "hasSetAcc = %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        paramContextMenu.add(0, 0, 0, this.uSb.mContext.getString(2131302282)).setOnMenuItemClickListener(new h.4(this, paramString));
      }
      paramContextMenu.add(0, 0, 0, this.uSb.mContext.getString(2131302871)).setOnMenuItemClickListener(new h.5(this, paramString));
      if (bool) {
        paramContextMenu.add(0, 0, 0, this.uSb.mContext.getString(2131302102)).setOnMenuItemClickListener(new h.6(this, paramString));
      }
      if (this.igX == null) {
        break label356;
      }
      localObject = this.igX;
      if (a.CB(this.igY)) {
        break label339;
      }
      if (!a.ba(this.igY, this.igX)) {
        break label312;
      }
      paramString = this.uSb.mContext.getString(2131302339);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramString)) {
        paramContextMenu.add(0, 0, 0, paramString).setOnMenuItemClickListener(new h.7(this, (String)localObject));
      }
      this.igX = null;
      AppMethodBeat.o(6146);
      return true;
      localObject = (Bundle)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", null, b.b.class);
      if (localObject != null)
      {
        bool = ((Bundle)localObject).getBoolean("has_set_uin", false);
        break;
      }
      bool = true;
      break;
      label312:
      if (a.CA(this.igY)) {
        paramString = this.uSb.mContext.getString(2131302335);
      } else {
        label339:
        paramString = this.uSb.mContext.getString(2131302336);
      }
    }
    label356:
    AppMethodBeat.o(6146);
    return false;
  }
  
  private static boolean dbn()
  {
    AppMethodBeat.i(6149);
    IPCBoolean localIPCBoolean = (IPCBoolean)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", null, h.b.class);
    if (localIPCBoolean != null)
    {
      boolean bool = localIPCBoolean.value;
      AppMethodBeat.o(6149);
      return bool;
    }
    AppMethodBeat.o(6149);
    return true;
  }
  
  final void a(ContextMenu paramContextMenu, WebView.b paramb)
  {
    AppMethodBeat.i(6147);
    if ((!a(paramContextMenu, paramb.mExtra)) && (this.uSb.dba().agT(this.uSb.getUrl()).dqw()) && (dbn()))
    {
      this.ihc = paramb;
      this.iha = new com.tencent.mm.plugin.webview.modeltools.h();
      this.iha.a(this.uSb.getWebView(), this.ihh);
    }
    AppMethodBeat.o(6147);
  }
  
  final void b(ContextMenu paramContextMenu, WebView.b paramb)
  {
    AppMethodBeat.i(6148);
    if ((!a(paramContextMenu, paramb.mExtra)) && (this.uSb.dba().agT(this.uSb.getUrl()).dqw()) && (dbn()))
    {
      this.ihb = paramb;
      this.iha = new com.tencent.mm.plugin.webview.modeltools.h();
      this.iha.a(this.uSb.getWebView(), this.ihh);
    }
    AppMethodBeat.o(6148);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(6145);
    ab.d("MicroMsg.GameWebViewMenuListHelper", "onCreateContextMenu");
    if ((paramView instanceof WebView))
    {
      paramView = this.uSb.getWebView().getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(6145);
        return;
      }
      if ((paramView.mType == 5) || (paramView.mType == 8)) {
        b(paramContextMenu, paramView);
      }
      AppMethodBeat.o(6145);
      return;
    }
    paramView = this.uSb.getWebView().getHitTestResult();
    if (paramView == null)
    {
      AppMethodBeat.o(6145);
      return;
    }
    if ((paramView.mType == 5) || (paramView.mType == 8)) {
      a(paramContextMenu, paramView);
    }
    AppMethodBeat.o(6145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h
 * JD-Core Version:    0.7.0.1
 */