package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsNotInterestUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  private static Context context;
  private static boolean xHm;
  private static String xHn;
  private static View.OnClickListener xHo;
  private static int xHp;
  private static int xHq;
  private static long xHr;
  private static View xHs;
  private static b xHt;
  private static NotInterestMenu.c xHu;
  private static com.tencent.mm.sdk.b.c xHv;
  private static com.tencent.mm.sdk.b.c xHw;
  
  static
  {
    AppMethodBeat.i(94936);
    xHm = false;
    xHn = "0";
    xHo = null;
    xHp = -1;
    xHq = -1;
    xHr = 0L;
    xHs = null;
    xHt = null;
    xHu = null;
    context = null;
    xHv = new com.tencent.mm.sdk.b.c() {};
    xHw = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(94936);
  }
  
  public static void a(Context paramContext, p paramp)
  {
    int i = 2;
    AppMethodBeat.i(94927);
    Intent localIntent;
    if ((xHm) && (paramp != null) && (paramContext != null))
    {
      xHr = paramp.field_snsId;
      a(paramp);
      localIntent = new Intent(paramContext, SnsNotInterestUI.class);
      localIntent.putExtra("sns_info_svr_id", xHr);
      if ((!xHm) || (bs.isNullOrNil(xHn))) {
        break label210;
      }
      if ((!xHn.equals("1")) && (!xHn.equals("2"))) {
        break label166;
      }
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("sns_info_not_interest_scene", i);
      paramp = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramp.aeD(), "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramp.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(94927);
      return;
      label166:
      if (xHn.equals("3"))
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
    if ((xHm) && (xHn.equals("3")) && (paramp != null) && (!paramp.Pe(32)) && (!paramp.field_userName.equals(af.dHx())) && (paramp.field_type != 15)) {
      paramContextMenu.add(0, 13, 0, 2131763845);
    }
    AppMethodBeat.o(94928);
  }
  
  public static void a(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94929);
    if ((xHm) && (!bs.isNullOrNil(xHn)) && (!xHn.equals("0")))
    {
      paramBaseViewHolder.zeb = ((ImageView)paramView.findViewById(2131304979));
      paramBaseViewHolder.zeb.setVisibility(8);
      paramBaseViewHolder.zec = false;
      if (!xHn.equals("3")) {
        paramBaseViewHolder.zeb.setOnClickListener(xHo);
      }
    }
    AppMethodBeat.o(94929);
  }
  
  private static void a(p paramp)
  {
    AppMethodBeat.i(94926);
    boolean bool = xHn.equals("3");
    if (paramp.field_type == 1)
    {
      if (bool)
      {
        xHq = 5;
        AppMethodBeat.o(94926);
        return;
      }
      xHq = 0;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramp.field_type == 2)
    {
      if (bool)
      {
        xHq = 4;
        AppMethodBeat.o(94926);
        return;
      }
      xHq = 1;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramp.field_type == 15)
    {
      if (!bool)
      {
        xHq = 2;
        AppMethodBeat.o(94926);
      }
    }
    else if (q.k(paramp))
    {
      if (bool)
      {
        xHq = 6;
        AppMethodBeat.o(94926);
        return;
      }
      xHq = 3;
    }
    AppMethodBeat.o(94926);
  }
  
  public static void b(p paramp)
  {
    AppMethodBeat.i(94930);
    if (xHm)
    {
      xHr = paramp.field_snsId;
      a(paramp);
    }
    AppMethodBeat.o(94930);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(94931);
    xHq = -1;
    xHp = -1;
    xHr = 0L;
    xHo = null;
    xHu = null;
    xHs = null;
    context = null;
    xHm = false;
    xHn = "0";
    f.yK("7");
    com.tencent.mm.sdk.b.a.GpY.d(xHv);
    com.tencent.mm.sdk.b.a.GpY.d(xHw);
    AppMethodBeat.o(94931);
  }
  
  public static void d(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94924);
    if (g.azO().yF("7") != null)
    {
      xHm = true;
      xHn = g.azO().yF("7").value;
      ac.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[] { xHn });
      xHs = paramViewGroup;
      xHt = new b(paramViewGroup);
      context = paramContext;
      com.tencent.mm.sdk.b.a.GpY.c(xHv);
      com.tencent.mm.sdk.b.a.GpY.c(xHw);
      xHo = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(94920);
          if ((paramAnonymousView.getTag() instanceof p))
          {
            p localp = (p)paramAnonymousView.getTag();
            a.a(paramAnonymousView, paramAnonymousView.getContext(), localp);
          }
          AppMethodBeat.o(94920);
        }
      };
      xHu = new NotInterestMenu.c()
      {
        public final void c(p paramAnonymousp)
        {
          AppMethodBeat.i(94921);
          a.a(a.dFw(), paramAnonymousp);
          AppMethodBeat.o(94921);
        }
        
        public final void d(p paramAnonymousp)
        {
          AppMethodBeat.i(94922);
          a.b(a.dFw(), paramAnonymousp);
          AppMethodBeat.o(94922);
        }
        
        public final void e(p paramAnonymousp)
        {
          AppMethodBeat.i(94923);
          a.c(a.dFw(), paramAnonymousp);
          AppMethodBeat.o(94923);
        }
      };
      xHt.xHz = xHu;
    }
    AppMethodBeat.o(94924);
  }
  
  public static void dFv()
  {
    AppMethodBeat.i(94925);
    if (xHt != null) {
      xHt.dFz();
    }
    AppMethodBeat.o(94925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a
 * JD-Core Version:    0.7.0.1
 */