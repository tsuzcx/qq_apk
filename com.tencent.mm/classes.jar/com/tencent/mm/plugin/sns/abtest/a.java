package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.c;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsNotInterestUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static boolean PKd;
  private static String PKe;
  private static View.OnClickListener PKf;
  private static int PKg;
  private static int PKh;
  private static long PKi;
  private static View PKj;
  private static b PKk;
  private static NotInterestMenu.c PKl;
  private static IListener PKm;
  private static IListener PKn;
  private static Context context;
  
  static
  {
    AppMethodBeat.i(94936);
    PKd = false;
    PKe = "0";
    PKf = null;
    PKg = -1;
    PKh = -1;
    PKi = 0L;
    PKj = null;
    PKk = null;
    PKl = null;
    context = null;
    PKm = new NotInteresetABTestManager.1(com.tencent.mm.app.f.hfK);
    PKn = new NotInteresetABTestManager.2(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(94936);
  }
  
  public static void a(Context paramContext, SnsInfo paramSnsInfo)
  {
    int i = 2;
    AppMethodBeat.i(94927);
    Intent localIntent;
    if ((PKd) && (paramSnsInfo != null) && (paramContext != null))
    {
      PKi = paramSnsInfo.field_snsId;
      b(paramSnsInfo);
      localIntent = new Intent(paramContext, SnsNotInterestUI.class);
      localIntent.putExtra("sns_info_svr_id", PKi);
      if ((!PKd) || (Util.isNullOrNil(PKe))) {
        break label210;
      }
      if ((!PKe.equals("1")) && (!PKe.equals("2"))) {
        break label166;
      }
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("sns_info_not_interest_scene", i);
      paramSnsInfo = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramSnsInfo.aYi(), "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramSnsInfo.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(94927);
      return;
      label166:
      if (PKe.equals("3"))
      {
        if (t.w(paramSnsInfo)) {
          i = 4;
        } else if (paramSnsInfo.field_type == 1) {
          i = 3;
        } else if (paramSnsInfo.field_type == 2) {}
      }
      else {
        label210:
        i = 0;
      }
    }
  }
  
  public static void a(ContextMenu paramContextMenu, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(94928);
    if ((PKd) && (PKe.equals("3")) && (paramSnsInfo != null) && (!paramSnsInfo.isAd()) && (!paramSnsInfo.getUserName().equals(al.hgg())) && (paramSnsInfo.field_type != 15)) {
      paramContextMenu.add(0, 13, 0, b.j.sns_hate_op_un_like);
    }
    AppMethodBeat.o(94928);
  }
  
  public static void a(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94929);
    if ((PKd) && (!Util.isNullOrNil(PKe)) && (!PKe.equals("0")))
    {
      paramBaseViewHolder.RLu = ((ImageView)paramView.findViewById(b.f.sns_hate_item_arrow));
      paramBaseViewHolder.RLu.setVisibility(8);
      paramBaseViewHolder.RLv = false;
      if (!PKe.equals("3")) {
        paramBaseViewHolder.RLu.setOnClickListener(PKf);
      }
    }
    AppMethodBeat.o(94929);
  }
  
  private static void b(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(94926);
    boolean bool = PKe.equals("3");
    if (paramSnsInfo.field_type == 1)
    {
      if (bool)
      {
        PKh = 5;
        AppMethodBeat.o(94926);
        return;
      }
      PKh = 0;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramSnsInfo.field_type == 2)
    {
      if (bool)
      {
        PKh = 4;
        AppMethodBeat.o(94926);
        return;
      }
      PKh = 1;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramSnsInfo.field_type == 15)
    {
      if (!bool)
      {
        PKh = 2;
        AppMethodBeat.o(94926);
      }
    }
    else if (t.w(paramSnsInfo))
    {
      if (bool)
      {
        PKh = 6;
        AppMethodBeat.o(94926);
        return;
      }
      PKh = 3;
    }
    AppMethodBeat.o(94926);
  }
  
  public static void c(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(94930);
    if (PKd)
    {
      PKi = paramSnsInfo.field_snsId;
      b(paramSnsInfo);
    }
    AppMethodBeat.o(94930);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(94931);
    PKh = -1;
    PKg = -1;
    PKi = 0L;
    PKf = null;
    PKl = null;
    PKj = null;
    context = null;
    PKd = false;
    PKe = "0";
    com.tencent.mm.model.a.f.Kr("7");
    PKm.dead();
    PKn.dead();
    AppMethodBeat.o(94931);
  }
  
  public static void d(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94924);
    if (g.bDR().Km("7") != null)
    {
      PKd = true;
      PKe = g.bDR().Km("7").value;
      Log.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[] { PKe });
      PKj = paramViewGroup;
      PKk = new b(paramViewGroup);
      context = paramContext;
      PKm.alive();
      PKn.alive();
      PKf = new a.1();
      PKl = new NotInterestMenu.c()
      {
        public final void d(SnsInfo paramAnonymousSnsInfo)
        {
          AppMethodBeat.i(94921);
          a.a(a.gZs(), paramAnonymousSnsInfo);
          AppMethodBeat.o(94921);
        }
        
        public final void e(SnsInfo paramAnonymousSnsInfo)
        {
          AppMethodBeat.i(94922);
          a.b(a.gZs(), paramAnonymousSnsInfo);
          AppMethodBeat.o(94922);
        }
        
        public final void f(SnsInfo paramAnonymousSnsInfo)
        {
          AppMethodBeat.i(94923);
          a.c(a.gZs(), paramAnonymousSnsInfo);
          AppMethodBeat.o(94923);
        }
      };
      PKk.PKq = PKl;
    }
    AppMethodBeat.o(94924);
  }
  
  public static void gZr()
  {
    AppMethodBeat.i(94925);
    if (PKk != null) {
      PKk.gZv();
    }
    AppMethodBeat.o(94925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a
 * JD-Core Version:    0.7.0.1
 */