package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.bq.d;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;

public final class f
  extends b
{
  int elr = -1;
  private int mCN = 0;
  int zPk = 0;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(32625);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(32625);
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.g.ca(paramString, true);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(32625);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(32625);
    }
    return null;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(32623);
    f.b localb = (f.b)parama;
    f.a locala = (f.a)PD(paramInt);
    localb.ekh.setText(j.g(this.mContext, locala.timestamp));
    Bitmap localBitmap = o.ahC().a(locala.imagePath, a.getDensity(this.mContext), false);
    if (localBitmap != null)
    {
      parama = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localBitmap = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, a.getDensity(this.mContext));
      if (localBitmap != null)
      {
        parama = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        localb.ivs.setImageResource(2131230829);
      }
    }
    for (;;)
    {
      localb.mCZ.setText(bo.bf(locala.source, ""));
      f.b.c(localb.mCZ, this.zPd.zDO);
      AppMethodBeat.o(32623);
      return;
      localb.ivs.setImageBitmap(parama);
    }
  }
  
  protected final void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, long paramLong1, long paramLong2, bi parambi)
  {
    AppMethodBeat.i(32624);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ab.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
      AppMethodBeat.o(32624);
      return;
    }
    String str;
    if (at.isMobile(this.mContext))
    {
      str = paramString1;
      if (paramString2 != null)
      {
        if (paramString2.length() > 0) {
          break label303;
        }
        str = paramString1;
      }
    }
    for (;;)
    {
      paramString1 = new Intent();
      paramString1.putExtra("msg_id", paramLong1);
      paramString1.putExtra("rawUrl", str);
      paramString1.putExtra("version_name", paramString3);
      paramString1.putExtra("version_code", paramInt);
      paramString1.putExtra("usePlugin", true);
      paramString1.putExtra("geta8key_username", this.ejr);
      paramString1.putExtra("KPublisherId", "msg_" + Long.toString(paramLong2));
      paramString1.putExtra("KAppId", paramString4);
      paramString2 = b(parambi, t.lA(this.ejr));
      paramString1.putExtra("pre_username", paramString2);
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (parambi != null) {
        paramString1.putExtra("preUsername", paramString2);
      }
      paramString1.putExtra("preChatName", this.ejr);
      paramString1.putExtra("preChatTYPE", u.ah(paramString2, this.ejr));
      paramString1.putExtra("preMsgIndex", 0);
      d.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramString1);
      AppMethodBeat.o(32624);
      return;
      if (paramString1 != null)
      {
        str = paramString1;
        if (paramString1.length() > 0) {}
      }
      else
      {
        label303:
        str = paramString2;
      }
    }
  }
  
  public final String apc()
  {
    AppMethodBeat.i(32619);
    String str = this.mContext.getString(2131296522);
    AppMethodBeat.o(32619);
    return str;
  }
  
  public final void dJQ()
  {
    AppMethodBeat.i(32618);
    this.zPc.dJU();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new f.1(this));
    AppMethodBeat.o(32618);
  }
  
  public final c.e dJR()
  {
    AppMethodBeat.i(32621);
    f.2 local2 = new f.2(this);
    AppMethodBeat.o(32621);
    return local2;
  }
  
  public final String dJT()
  {
    AppMethodBeat.i(32620);
    String str = this.mContext.getString(2131296522);
    AppMethodBeat.o(32620);
    return str;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final RecyclerView.v v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(32622);
    paramViewGroup = new f.b(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130971056, paramViewGroup, false));
    AppMethodBeat.o(32622);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.f
 * JD-Core Version:    0.7.0.1
 */