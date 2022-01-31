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
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsNotInterestUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  private static Context context;
  private static View.OnClickListener qXA;
  private static int qXB;
  private static int qXC;
  private static long qXD;
  private static View qXE;
  private static b qXF;
  private static NotInterestMenu.c qXG;
  private static com.tencent.mm.sdk.b.c qXH;
  private static com.tencent.mm.sdk.b.c qXI;
  private static boolean qXy;
  private static String qXz;
  
  static
  {
    AppMethodBeat.i(35662);
    qXy = false;
    qXz = "0";
    qXA = null;
    qXB = -1;
    qXC = -1;
    qXD = 0L;
    qXE = null;
    qXF = null;
    qXG = null;
    context = null;
    qXH = new a.1();
    qXI = new a.2();
    AppMethodBeat.o(35662);
  }
  
  public static void a(Context paramContext, n paramn)
  {
    int i = 2;
    AppMethodBeat.i(35653);
    Intent localIntent;
    if ((qXy) && (paramn != null) && (paramContext != null))
    {
      qXD = paramn.field_snsId;
      a(paramn);
      localIntent = new Intent(paramContext, SnsNotInterestUI.class);
      localIntent.putExtra("sns_info_svr_id", qXD);
      if ((!qXy) || (bo.isNullOrNil(qXz))) {
        break label155;
      }
      if ((!qXz.equals("1")) && (!qXz.equals("2"))) {
        break label111;
      }
      i = 1;
    }
    label155:
    for (;;)
    {
      localIntent.putExtra("sns_info_not_interest_scene", i);
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(35653);
      return;
      label111:
      if (qXz.equals("3"))
      {
        if (i.i(paramn)) {
          i = 4;
        } else if (paramn.field_type == 1) {
          i = 3;
        } else if (paramn.field_type == 2) {}
      }
      else {
        i = 0;
      }
    }
  }
  
  public static void a(ContextMenu paramContextMenu, n paramn)
  {
    AppMethodBeat.i(35654);
    if ((qXy) && (qXz.equals("3")) && (paramn != null) && (!paramn.Ex(32)) && (!paramn.field_userName.equals(ag.coK())) && (paramn.field_type != 15)) {
      paramContextMenu.add(0, 13, 0, 2131303836);
    }
    AppMethodBeat.o(35654);
  }
  
  public static void a(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(35655);
    if ((qXy) && (!bo.isNullOrNil(qXz)) && (!qXz.equals("0")))
    {
      paramBaseViewHolder.shF = ((ImageView)paramView.findViewById(2131828143));
      paramBaseViewHolder.shF.setVisibility(8);
      paramBaseViewHolder.shG = false;
      if (!qXz.equals("3")) {
        paramBaseViewHolder.shF.setOnClickListener(qXA);
      }
    }
    AppMethodBeat.o(35655);
  }
  
  private static void a(n paramn)
  {
    AppMethodBeat.i(35652);
    boolean bool = qXz.equals("3");
    if (paramn.field_type == 1)
    {
      if (bool)
      {
        qXC = 5;
        AppMethodBeat.o(35652);
        return;
      }
      qXC = 0;
      AppMethodBeat.o(35652);
      return;
    }
    if (paramn.field_type == 2)
    {
      if (bool)
      {
        qXC = 4;
        AppMethodBeat.o(35652);
        return;
      }
      qXC = 1;
      AppMethodBeat.o(35652);
      return;
    }
    if (paramn.field_type == 15)
    {
      if (!bool)
      {
        qXC = 2;
        AppMethodBeat.o(35652);
      }
    }
    else if (i.i(paramn))
    {
      if (bool)
      {
        qXC = 6;
        AppMethodBeat.o(35652);
        return;
      }
      qXC = 3;
    }
    AppMethodBeat.o(35652);
  }
  
  public static void b(n paramn)
  {
    AppMethodBeat.i(35656);
    if (qXy)
    {
      qXD = paramn.field_snsId;
      a(paramn);
    }
    AppMethodBeat.o(35656);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(35657);
    qXC = -1;
    qXB = -1;
    qXD = 0L;
    qXA = null;
    qXG = null;
    qXE = null;
    context = null;
    qXy = false;
    qXz = "0";
    f.pQ("7");
    com.tencent.mm.sdk.b.a.ymk.d(qXH);
    com.tencent.mm.sdk.b.a.ymk.d(qXI);
    AppMethodBeat.o(35657);
  }
  
  public static void cnw()
  {
    AppMethodBeat.i(35651);
    if (qXF != null) {
      qXF.cnA();
    }
    AppMethodBeat.o(35651);
  }
  
  public static void d(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35650);
    if (g.abw().pL("7") != null)
    {
      qXy = true;
      qXz = g.abw().pL("7").value;
      ab.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[] { qXz });
      qXE = paramViewGroup;
      qXF = new b(paramViewGroup);
      context = paramContext;
      com.tencent.mm.sdk.b.a.ymk.c(qXH);
      com.tencent.mm.sdk.b.a.ymk.c(qXI);
      qXA = new a.3();
      qXG = new a.4();
      qXF.qXL = qXG;
    }
    AppMethodBeat.o(35650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a
 * JD-Core Version:    0.7.0.1
 */