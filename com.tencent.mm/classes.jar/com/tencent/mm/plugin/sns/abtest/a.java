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
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsNotInterestUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  private static Context context;
  private static boolean zmg;
  private static String zmh;
  private static View.OnClickListener zmi;
  private static int zmj;
  private static int zmk;
  private static long zml;
  private static View zmm;
  private static b zmn;
  private static NotInterestMenu.c zmo;
  private static com.tencent.mm.sdk.b.c zmp;
  private static com.tencent.mm.sdk.b.c zmq;
  
  static
  {
    AppMethodBeat.i(94936);
    zmg = false;
    zmh = "0";
    zmi = null;
    zmj = -1;
    zmk = -1;
    zml = 0L;
    zmm = null;
    zmn = null;
    zmo = null;
    context = null;
    zmp = new a.1();
    zmq = new a.2();
    AppMethodBeat.o(94936);
  }
  
  public static void a(Context paramContext, p paramp)
  {
    int i = 2;
    AppMethodBeat.i(94927);
    Intent localIntent;
    if ((zmg) && (paramp != null) && (paramContext != null))
    {
      zml = paramp.field_snsId;
      a(paramp);
      localIntent = new Intent(paramContext, SnsNotInterestUI.class);
      localIntent.putExtra("sns_info_svr_id", zml);
      if ((!zmg) || (bu.isNullOrNil(zmh))) {
        break label210;
      }
      if ((!zmh.equals("1")) && (!zmh.equals("2"))) {
        break label166;
      }
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("sns_info_not_interest_scene", i);
      paramp = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramp.ahE(), "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramp.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(94927);
      return;
      label166:
      if (zmh.equals("3"))
      {
        if (r.n(paramp)) {
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
    if ((zmg) && (zmh.equals("3")) && (paramp != null) && (!paramp.Rt(32)) && (!paramp.field_userName.equals(ah.dXj())) && (paramp.field_type != 15)) {
      paramContextMenu.add(0, 13, 0, 2131763845);
    }
    AppMethodBeat.o(94928);
  }
  
  public static void a(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94929);
    if ((zmg) && (!bu.isNullOrNil(zmh)) && (!zmh.equals("0")))
    {
      paramBaseViewHolder.ANi = ((ImageView)paramView.findViewById(2131304979));
      paramBaseViewHolder.ANi.setVisibility(8);
      paramBaseViewHolder.ANj = false;
      if (!zmh.equals("3")) {
        paramBaseViewHolder.ANi.setOnClickListener(zmi);
      }
    }
    AppMethodBeat.o(94929);
  }
  
  private static void a(p paramp)
  {
    AppMethodBeat.i(94926);
    boolean bool = zmh.equals("3");
    if (paramp.field_type == 1)
    {
      if (bool)
      {
        zmk = 5;
        AppMethodBeat.o(94926);
        return;
      }
      zmk = 0;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramp.field_type == 2)
    {
      if (bool)
      {
        zmk = 4;
        AppMethodBeat.o(94926);
        return;
      }
      zmk = 1;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramp.field_type == 15)
    {
      if (!bool)
      {
        zmk = 2;
        AppMethodBeat.o(94926);
      }
    }
    else if (r.n(paramp))
    {
      if (bool)
      {
        zmk = 6;
        AppMethodBeat.o(94926);
        return;
      }
      zmk = 3;
    }
    AppMethodBeat.o(94926);
  }
  
  public static void b(p paramp)
  {
    AppMethodBeat.i(94930);
    if (zmg)
    {
      zml = paramp.field_snsId;
      a(paramp);
    }
    AppMethodBeat.o(94930);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(94931);
    zmk = -1;
    zmj = -1;
    zml = 0L;
    zmi = null;
    zmo = null;
    zmm = null;
    context = null;
    zmg = false;
    zmh = "0";
    f.Cl("7");
    com.tencent.mm.sdk.b.a.IvT.d(zmp);
    com.tencent.mm.sdk.b.a.IvT.d(zmq);
    AppMethodBeat.o(94931);
  }
  
  public static void d(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94924);
    if (g.aDh().Cg("7") != null)
    {
      zmg = true;
      zmh = g.aDh().Cg("7").value;
      ae.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[] { zmh });
      zmm = paramViewGroup;
      zmn = new b(paramViewGroup);
      context = paramContext;
      com.tencent.mm.sdk.b.a.IvT.c(zmp);
      com.tencent.mm.sdk.b.a.IvT.c(zmq);
      zmi = new a.3();
      zmo = new NotInterestMenu.c()
      {
        public final void c(p paramAnonymousp)
        {
          AppMethodBeat.i(94921);
          a.a(a.dUv(), paramAnonymousp);
          AppMethodBeat.o(94921);
        }
        
        public final void d(p paramAnonymousp)
        {
          AppMethodBeat.i(94922);
          a.b(a.dUv(), paramAnonymousp);
          AppMethodBeat.o(94922);
        }
        
        public final void e(p paramAnonymousp)
        {
          AppMethodBeat.i(94923);
          a.c(a.dUv(), paramAnonymousp);
          AppMethodBeat.o(94923);
        }
      };
      zmn.zmt = zmo;
    }
    AppMethodBeat.o(94924);
  }
  
  public static void dUu()
  {
    AppMethodBeat.i(94925);
    if (zmn != null) {
      zmn.dUy();
    }
    AppMethodBeat.o(94925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a
 * JD-Core Version:    0.7.0.1
 */