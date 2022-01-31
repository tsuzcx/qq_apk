package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.d.b.b;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class h
  extends b
{
  int hkM = -1;
  int vyN = 0;
  HashSet<Integer> vzh = new HashSet();
  
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean a(bi parambi, f paramf)
  {
    if ((!parambi.field_talker.endsWith("@qqim")) || (!paramf.field_packageName.equals("com.tencent.mobileqq"))) {
      return false;
    }
    y.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
    parambi = new Intent("android.intent.action.MAIN", null);
    parambi.addCategory("android.intent.category.LAUNCHER");
    parambi.addFlags(268435456);
    parambi.setClassName("com.tencent.mobileqq", aF(this.mContext, "com.tencent.mobileqq"));
    parambi.putExtra("platformId", "wechat");
    au.Hx();
    paramf = com.tencent.mm.model.c.Dz().get(9, null);
    int i;
    if ((paramf != null) && ((paramf instanceof Integer))) {
      i = ((Integer)paramf).intValue();
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        paramf = String.valueOf(i).getBytes("utf-8");
        byte[] arrayOfByte = "asdfghjkl;'".getBytes("utf-8");
        int k = arrayOfByte.length;
        int j = 0;
        i = 0;
        while (j < k)
        {
          int m = arrayOfByte[j];
          if (i >= paramf.length) {
            break;
          }
          paramf[i] = ((byte)(m ^ paramf[i]));
          j += 1;
          i += 1;
        }
        parambi.putExtra("tencent_gif", paramf);
        label222:
        i = 0;
      }
      catch (UnsupportedEncodingException paramf)
      {
        try
        {
          for (;;)
          {
            this.mContext.startActivity(parambi);
            return true;
            paramf = paramf;
            y.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramf, "", new Object[0]);
          }
        }
        catch (Exception parambi)
        {
          break label222;
        }
      }
    }
  }
  
  private static String aF(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext != null)
      {
        paramContext = paramContext.activityInfo.name;
        return paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
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
      y.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public final String VE()
  {
    return this.mContext.getString(R.l.all_history_url);
  }
  
  public final void a(c.a parama, int paramInt)
  {
    h.b localb = (h.b)parama;
    h.a locala = (h.a)Ha(paramInt);
    if ((bk.bl(locala.desc)) || (!bk.bl(locala.aWf)))
    {
      localb.eXP.setVisibility(8);
      Bitmap localBitmap = o.OJ().a(locala.imagePath, a.getDensity(this.mContext), false);
      if (localBitmap != null)
      {
        parama = localBitmap;
        if (!localBitmap.isRecycled()) {
          break label216;
        }
      }
      localBitmap = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, a.getDensity(this.mContext));
      if (localBitmap != null)
      {
        parama = localBitmap;
        if (!localBitmap.isRecycled()) {
          break label216;
        }
      }
      localBitmap = x.a(new q(locala.imagePath, locala.type, "@S"));
      parama = localBitmap;
      if (localBitmap != null) {
        break label216;
      }
      localb.gSx.setImageResource(R.k.app_attach_file_icon_webpage);
    }
    for (;;)
    {
      localb.kiv.setText(bk.aM(locala.aWf, ""));
      h.b.e(localb.kiv, this.vyE.vos);
      return;
      localb.eXP.setVisibility(0);
      localb.eXP.setText(bk.aM(locala.desc, ""));
      break;
      label216:
      localb.gSx.setImageBitmap(parama);
    }
  }
  
  public final void cFN()
  {
    this.vyD.cFR();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new h.1(this));
  }
  
  public final c.e cFO()
  {
    return new h.2(this);
  }
  
  public final String cFQ()
  {
    return this.mContext.getString(R.l.all_history_url);
  }
  
  public final int getType()
  {
    this.vzh.add(Integer.valueOf(5));
    this.vzh.add(Integer.valueOf(7));
    this.vzh.add(Integer.valueOf(27));
    this.vzh.add(Integer.valueOf(26));
    this.vzh.add(Integer.valueOf(15));
    return -1;
  }
  
  public final RecyclerView.v q(ViewGroup paramViewGroup)
  {
    return new h.b(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.url_list_item, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.h
 * JD-Core Version:    0.7.0.1
 */