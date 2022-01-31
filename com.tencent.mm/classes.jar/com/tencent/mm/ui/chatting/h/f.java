package com.tencent.mm.ui.chatting.h;

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
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.d.b.b;

public final class f
  extends b
{
  int hkM = -1;
  private int kih = 0;
  int vyN = 0;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.g.by(paramString, true);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public final String VE()
  {
    return this.mContext.getString(R.l.all_history_music);
  }
  
  public final void a(c.a parama, int paramInt)
  {
    f.b localb = (f.b)parama;
    f.a locala = (f.a)Ha(paramInt);
    localb.dsz.setText(j.f(this.mContext, locala.timestamp));
    Bitmap localBitmap = o.OJ().a(locala.imagePath, a.getDensity(this.mContext), false);
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
        localb.gSx.setImageResource(R.k.app_attach_file_icon_webpage);
      }
    }
    for (;;)
    {
      localb.kiv.setText(bk.aM(locala.aWf, ""));
      f.b.e(localb.kiv, this.vyE.vos);
      return;
      localb.gSx.setImageBitmap(parama);
    }
  }
  
  protected final void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, long paramLong1, long paramLong2, bi parambi)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      y.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
      return;
    }
    String str;
    if (aq.isMobile(this.mContext))
    {
      str = paramString1;
      if (paramString2 != null)
      {
        if (paramString2.length() > 0) {
          break label285;
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
      paramString1.putExtra("geta8key_username", this.drJ);
      paramString1.putExtra("KPublisherId", "msg_" + Long.toString(paramLong2));
      paramString1.putExtra("KAppId", paramString4);
      paramString2 = j(parambi, s.fn(this.drJ));
      paramString1.putExtra("pre_username", paramString2);
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (parambi != null) {
        paramString1.putExtra("preUsername", paramString2);
      }
      paramString1.putExtra("preChatName", this.drJ);
      paramString1.putExtra("preChatTYPE", t.R(paramString2, this.drJ));
      paramString1.putExtra("preMsgIndex", 0);
      d.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramString1);
      return;
      if (paramString1 != null)
      {
        str = paramString1;
        if (paramString1.length() > 0) {}
      }
      else
      {
        label285:
        str = paramString2;
      }
    }
  }
  
  public final void cFN()
  {
    this.vyD.cFR();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new f.1(this));
  }
  
  public final c.e cFO()
  {
    return new f.2(this);
  }
  
  public final String cFQ()
  {
    return this.mContext.getString(R.l.all_history_music);
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final RecyclerView.v q(ViewGroup paramViewGroup)
  {
    return new f.b(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.url_list_item, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.f
 * JD-Core Version:    0.7.0.1
 */