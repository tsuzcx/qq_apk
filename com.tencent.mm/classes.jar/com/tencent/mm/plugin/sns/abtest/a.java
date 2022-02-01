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
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsNotInterestUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private static Context context;
  private static boolean wvW;
  private static String wvX;
  private static View.OnClickListener wvY;
  private static int wvZ;
  private static int wwa;
  private static long wwb;
  private static View wwc;
  private static b wwd;
  private static NotInterestMenu.c wwe;
  private static com.tencent.mm.sdk.b.c wwf;
  private static com.tencent.mm.sdk.b.c wwg;
  
  static
  {
    AppMethodBeat.i(94936);
    wvW = false;
    wvX = "0";
    wvY = null;
    wvZ = -1;
    wwa = -1;
    wwb = 0L;
    wwc = null;
    wwd = null;
    wwe = null;
    context = null;
    wwf = new a.1();
    wwg = new a.2();
    AppMethodBeat.o(94936);
  }
  
  public static void a(Context paramContext, p paramp)
  {
    int i = 2;
    AppMethodBeat.i(94927);
    Intent localIntent;
    if ((wvW) && (paramp != null) && (paramContext != null))
    {
      wwb = paramp.field_snsId;
      a(paramp);
      localIntent = new Intent(paramContext, SnsNotInterestUI.class);
      localIntent.putExtra("sns_info_svr_id", wwb);
      if ((!wvW) || (bt.isNullOrNil(wvX))) {
        break label210;
      }
      if ((!wvX.equals("1")) && (!wvX.equals("2"))) {
        break label166;
      }
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("sns_info_not_interest_scene", i);
      paramp = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramp.adn(), "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramp.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(94927);
      return;
      label166:
      if (wvX.equals("3"))
      {
        if (q.k(paramp)) {
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
    if ((wvW) && (wvX.equals("3")) && (paramp != null) && (!paramp.Nb(32)) && (!paramp.field_userName.equals(af.dta())) && (paramp.field_type != 15)) {
      paramContextMenu.add(0, 13, 0, 2131763845);
    }
    AppMethodBeat.o(94928);
  }
  
  public static void a(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94929);
    if ((wvW) && (!bt.isNullOrNil(wvX)) && (!wvX.equals("0")))
    {
      paramBaseViewHolder.xRl = ((ImageView)paramView.findViewById(2131304979));
      paramBaseViewHolder.xRl.setVisibility(8);
      paramBaseViewHolder.xRm = false;
      if (!wvX.equals("3")) {
        paramBaseViewHolder.xRl.setOnClickListener(wvY);
      }
    }
    AppMethodBeat.o(94929);
  }
  
  private static void a(p paramp)
  {
    AppMethodBeat.i(94926);
    boolean bool = wvX.equals("3");
    if (paramp.field_type == 1)
    {
      if (bool)
      {
        wwa = 5;
        AppMethodBeat.o(94926);
        return;
      }
      wwa = 0;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramp.field_type == 2)
    {
      if (bool)
      {
        wwa = 4;
        AppMethodBeat.o(94926);
        return;
      }
      wwa = 1;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramp.field_type == 15)
    {
      if (!bool)
      {
        wwa = 2;
        AppMethodBeat.o(94926);
      }
    }
    else if (q.k(paramp))
    {
      if (bool)
      {
        wwa = 6;
        AppMethodBeat.o(94926);
        return;
      }
      wwa = 3;
    }
    AppMethodBeat.o(94926);
  }
  
  public static void b(p paramp)
  {
    AppMethodBeat.i(94930);
    if (wvW)
    {
      wwb = paramp.field_snsId;
      a(paramp);
    }
    AppMethodBeat.o(94930);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(94931);
    wwa = -1;
    wvZ = -1;
    wwb = 0L;
    wvY = null;
    wwe = null;
    wwc = null;
    context = null;
    wvW = false;
    wvX = "0";
    f.uE("7");
    com.tencent.mm.sdk.b.a.ESL.d(wwf);
    com.tencent.mm.sdk.b.a.ESL.d(wwg);
    AppMethodBeat.o(94931);
  }
  
  public static void d(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94924);
    if (g.asX().uz("7") != null)
    {
      wvW = true;
      wvX = g.asX().uz("7").value;
      ad.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[] { wvX });
      wwc = paramViewGroup;
      wwd = new b(paramViewGroup);
      context = paramContext;
      com.tencent.mm.sdk.b.a.ESL.c(wwf);
      com.tencent.mm.sdk.b.a.ESL.c(wwg);
      wvY = new a.3();
      wwe = new NotInterestMenu.c()
      {
        public final void c(p paramAnonymousp)
        {
          AppMethodBeat.i(94921);
          a.a(a.drn(), paramAnonymousp);
          AppMethodBeat.o(94921);
        }
        
        public final void d(p paramAnonymousp)
        {
          AppMethodBeat.i(94922);
          a.b(a.drn(), paramAnonymousp);
          AppMethodBeat.o(94922);
        }
        
        public final void e(p paramAnonymousp)
        {
          AppMethodBeat.i(94923);
          a.c(a.drn(), paramAnonymousp);
          AppMethodBeat.o(94923);
        }
      };
      wwd.wwj = wwe;
    }
    AppMethodBeat.o(94924);
  }
  
  public static void drm()
  {
    AppMethodBeat.i(94925);
    if (wwd != null) {
      wwd.drq();
    }
    AppMethodBeat.o(94925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a
 * JD-Core Version:    0.7.0.1
 */