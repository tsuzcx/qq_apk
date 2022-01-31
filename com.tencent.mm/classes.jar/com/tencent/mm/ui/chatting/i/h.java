package com.tencent.mm.ui.chatting.i;

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.at.q;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class h
  extends b
{
  int elr;
  HashSet<Integer> zPE;
  int zPk;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(32648);
    this.zPE = new HashSet();
    this.elr = -1;
    this.zPk = 0;
    AppMethodBeat.o(32648);
  }
  
  private boolean a(bi parambi, f paramf)
  {
    AppMethodBeat.i(32656);
    if ((!parambi.field_talker.endsWith("@qqim")) || (!paramf.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(32656);
      return false;
    }
    ab.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
    parambi = new Intent("android.intent.action.MAIN", null);
    parambi.addCategory("android.intent.category.LAUNCHER");
    parambi.addFlags(268435456);
    parambi.setClassName("com.tencent.mobileqq", aO(this.mContext, "com.tencent.mobileqq"));
    parambi.putExtra("platformId", "wechat");
    aw.aaz();
    paramf = com.tencent.mm.model.c.Ru().get(9, null);
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
        label235:
        i = 0;
      }
      catch (UnsupportedEncodingException paramf)
      {
        try
        {
          for (;;)
          {
            this.mContext.startActivity(parambi);
            AppMethodBeat.o(32656);
            return true;
            paramf = paramf;
            ab.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramf, "", new Object[0]);
          }
        }
        catch (Exception parambi)
        {
          break label235;
        }
      }
    }
  }
  
  private static String aO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(32657);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext == null) {
        break label101;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(32657);
    return paramContext;
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(32658);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(32658);
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
      AppMethodBeat.o(32658);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(32658);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    AppMethodBeat.i(32655);
    b localb = (b)parama;
    h.a locala = (h.a)PD(paramInt);
    if ((bo.isNullOrNil(locala.desc)) || (!bo.isNullOrNil(locala.source)))
    {
      localb.gpM.setVisibility(8);
      Bitmap localBitmap = o.ahC().a(locala.imagePath, com.tencent.mm.cb.a.getDensity(this.mContext), false);
      if (localBitmap != null)
      {
        parama = localBitmap;
        if (!localBitmap.isRecycled()) {
          break label267;
        }
      }
      localBitmap = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
      String str = q.ts(locala.imagePath);
      if (localBitmap != null)
      {
        parama = localBitmap;
        if (!localBitmap.isRecycled()) {
          break label267;
        }
      }
      parama = new com.tencent.mm.at.a.a.c.a();
      parama.eNY = 2131689878;
      parama.eNL = true;
      parama.eNO = p.aln(str);
      parama.cx(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50)).eNK = true;
      o.ahG().a(str, localb.ivs, parama.ahY());
    }
    for (;;)
    {
      localb.mCZ.setText(bo.bf(locala.source, ""));
      b.c(localb.mCZ, this.zPd.zDO);
      AppMethodBeat.o(32655);
      return;
      localb.gpM.setVisibility(0);
      localb.gpM.setText(bo.bf(locala.desc, ""));
      break;
      label267:
      localb.ivs.setImageBitmap(parama);
    }
  }
  
  public final String apc()
  {
    AppMethodBeat.i(32651);
    String str = this.mContext.getString(2131296523);
    AppMethodBeat.o(32651);
    return str;
  }
  
  public final void dJQ()
  {
    AppMethodBeat.i(32650);
    this.zPc.dJU();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new h.1(this));
    AppMethodBeat.o(32650);
  }
  
  public final c.e dJR()
  {
    AppMethodBeat.i(32653);
    h.2 local2 = new h.2(this);
    AppMethodBeat.o(32653);
    return local2;
  }
  
  public final String dJT()
  {
    AppMethodBeat.i(32652);
    String str = this.mContext.getString(2131296523);
    AppMethodBeat.o(32652);
    return str;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(32649);
    this.zPE.add(Integer.valueOf(5));
    this.zPE.add(Integer.valueOf(7));
    this.zPE.add(Integer.valueOf(27));
    this.zPE.add(Integer.valueOf(26));
    this.zPE.add(Integer.valueOf(15));
    AppMethodBeat.o(32649);
    return -1;
  }
  
  public final RecyclerView.v v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(32654);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130971056, paramViewGroup, false));
    AppMethodBeat.o(32654);
    return paramViewGroup;
  }
  
  final class b
    extends com.tencent.mm.ui.chatting.a.c.a
  {
    TextView gpM;
    ImageView ivs;
    TextView mCZ;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(32647);
      this.ivs = ((ImageView)paramView.findViewById(2131821517));
      this.gpM = ((TextView)paramView.findViewById(2131820602));
      this.mCZ = ((TextView)paramView.findViewById(2131820615));
      this.mCZ.setVisibility(0);
      AppMethodBeat.o(32647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.h
 * JD-Core Version:    0.7.0.1
 */