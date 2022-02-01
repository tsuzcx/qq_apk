package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsNotInterestUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private static Context context;
  private static boolean yVW;
  private static String yVX;
  private static View.OnClickListener yVY;
  private static int yVZ;
  private static int yWa;
  private static long yWb;
  private static View yWc;
  private static b yWd;
  private static NotInterestMenu.c yWe;
  private static com.tencent.mm.sdk.b.c yWf;
  private static com.tencent.mm.sdk.b.c yWg;
  
  static
  {
    AppMethodBeat.i(94936);
    yVW = false;
    yVX = "0";
    yVY = null;
    yVZ = -1;
    yWa = -1;
    yWb = 0L;
    yWc = null;
    yWd = null;
    yWe = null;
    context = null;
    yWf = new a.1();
    yWg = new a.2();
    AppMethodBeat.o(94936);
  }
  
  public static void a(Context paramContext, p paramp)
  {
    int i = 2;
    AppMethodBeat.i(94927);
    Intent localIntent;
    if ((yVW) && (paramp != null) && (paramContext != null))
    {
      yWb = paramp.field_snsId;
      a(paramp);
      localIntent = new Intent(paramContext, SnsNotInterestUI.class);
      localIntent.putExtra("sns_info_svr_id", yWb);
      if ((!yVW) || (bt.isNullOrNil(yVX))) {
        break label210;
      }
      if ((!yVX.equals("1")) && (!yVX.equals("2"))) {
        break label166;
      }
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("sns_info_not_interest_scene", i);
      paramp = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramp.ahp(), "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramp.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(94927);
      return;
      label166:
      if (yVX.equals("3"))
      {
        if (q.m(paramp)) {
          i = 4;
        } else if (paramp.field_type == 1) {
          i = 3;
        } else if (paramp.field_type == 2) {}
      }
      else {
        label210:
        i = 0;
      }
    }
  }
  
  public static void a(ContextMenu paramContextMenu, p paramp)
  {
    AppMethodBeat.i(94928);
    if ((yVW) && (yVX.equals("3")) && (paramp != null) && (!paramp.QM(32)) && (!paramp.field_userName.equals(ag.dTJ())) && (paramp.field_type != 15)) {
      paramContextMenu.add(0, 13, 0, 2131763845);
    }
    AppMethodBeat.o(94928);
  }
  
  public static void a(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94929);
    if ((yVW) && (!bt.isNullOrNil(yVX)) && (!yVX.equals("0")))
    {
      paramBaseViewHolder.AvR = ((ImageView)paramView.findViewById(2131304979));
      paramBaseViewHolder.AvR.setVisibility(8);
      paramBaseViewHolder.AvS = false;
      if (!yVX.equals("3")) {
        paramBaseViewHolder.AvR.setOnClickListener(yVY);
      }
    }
    AppMethodBeat.o(94929);
  }
  
  private static void a(p paramp)
  {
    AppMethodBeat.i(94926);
    boolean bool = yVX.equals("3");
    if (paramp.field_type == 1)
    {
      if (bool)
      {
        yWa = 5;
        AppMethodBeat.o(94926);
        return;
      }
      yWa = 0;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramp.field_type == 2)
    {
      if (bool)
      {
        yWa = 4;
        AppMethodBeat.o(94926);
        return;
      }
      yWa = 1;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramp.field_type == 15)
    {
      if (!bool)
      {
        yWa = 2;
        AppMethodBeat.o(94926);
      }
    }
    else if (q.m(paramp))
    {
      if (bool)
      {
        yWa = 6;
        AppMethodBeat.o(94926);
        return;
      }
      yWa = 3;
    }
    AppMethodBeat.o(94926);
  }
  
  public static void b(p paramp)
  {
    AppMethodBeat.i(94930);
    if (yVW)
    {
      yWb = paramp.field_snsId;
      a(paramp);
    }
    AppMethodBeat.o(94930);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(94931);
    yWa = -1;
    yVZ = -1;
    yWb = 0L;
    yVY = null;
    yWe = null;
    yWc = null;
    context = null;
    yVW = false;
    yVX = "0";
    f.BJ("7");
    com.tencent.mm.sdk.b.a.IbL.d(yWf);
    com.tencent.mm.sdk.b.a.IbL.d(yWg);
    AppMethodBeat.o(94931);
  }
  
  public static void d(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94924);
    if (g.aCR().BE("7") != null)
    {
      yVW = true;
      yVX = g.aCR().BE("7").value;
      ad.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[] { yVX });
      yWc = paramViewGroup;
      yWd = new b(paramViewGroup);
      context = paramContext;
      com.tencent.mm.sdk.b.a.IbL.c(yWf);
      com.tencent.mm.sdk.b.a.IbL.c(yWg);
      yVY = new a.3();
      yWe = new NotInterestMenu.c()
      {
        public final void c(p paramAnonymousp)
        {
          AppMethodBeat.i(94921);
          a.a(a.dQY(), paramAnonymousp);
          AppMethodBeat.o(94921);
        }
        
        public final void d(p paramAnonymousp)
        {
          AppMethodBeat.i(94922);
          a.b(a.dQY(), paramAnonymousp);
          AppMethodBeat.o(94922);
        }
        
        public final void e(p paramAnonymousp)
        {
          AppMethodBeat.i(94923);
          a.c(a.dQY(), paramAnonymousp);
          AppMethodBeat.o(94923);
        }
      };
      yWd.yWj = yWe;
    }
    AppMethodBeat.o(94924);
  }
  
  public static void dQX()
  {
    AppMethodBeat.i(94925);
    if (yWd != null) {
      yWd.dRb();
    }
    AppMethodBeat.o(94925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a
 * JD-Core Version:    0.7.0.1
 */