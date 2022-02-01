package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.model.a.c;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsNotInterestUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static boolean DqY;
  private static String DqZ;
  private static View.OnClickListener Dra;
  private static int Drb;
  private static int Drc;
  private static long Drd;
  private static View Dre;
  private static b Drf;
  private static NotInterestMenu.c Drg;
  private static IListener Drh;
  private static IListener Dri;
  private static Context context;
  
  static
  {
    AppMethodBeat.i(94936);
    DqY = false;
    DqZ = "0";
    Dra = null;
    Drb = -1;
    Drc = -1;
    Drd = 0L;
    Dre = null;
    Drf = null;
    Drg = null;
    context = null;
    Drh = new IListener() {};
    Dri = new IListener() {};
    AppMethodBeat.o(94936);
  }
  
  public static void a(Context paramContext, SnsInfo paramSnsInfo)
  {
    int i = 2;
    AppMethodBeat.i(94927);
    Intent localIntent;
    if ((DqY) && (paramSnsInfo != null) && (paramContext != null))
    {
      Drd = paramSnsInfo.field_snsId;
      a(paramSnsInfo);
      localIntent = new Intent(paramContext, SnsNotInterestUI.class);
      localIntent.putExtra("sns_info_svr_id", Drd);
      if ((!DqY) || (Util.isNullOrNil(DqZ))) {
        break label210;
      }
      if ((!DqZ.equals("1")) && (!DqZ.equals("2"))) {
        break label166;
      }
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("sns_info_not_interest_scene", i);
      paramSnsInfo = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramSnsInfo.axQ(), "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramSnsInfo.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(94927);
      return;
      label166:
      if (DqZ.equals("3"))
      {
        if (r.u(paramSnsInfo)) {
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
    if ((DqY) && (DqZ.equals("3")) && (paramSnsInfo != null) && (!paramSnsInfo.isAd()) && (!paramSnsInfo.getUserName().equals(aj.fau())) && (paramSnsInfo.field_type != 15)) {
      paramContextMenu.add(0, 13, 0, 2131766071);
    }
    AppMethodBeat.o(94928);
  }
  
  public static void a(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94929);
    if ((DqY) && (!Util.isNullOrNil(DqZ)) && (!DqZ.equals("0")))
    {
      paramBaseViewHolder.EXs = ((ImageView)paramView.findViewById(2131308128));
      paramBaseViewHolder.EXs.setVisibility(8);
      paramBaseViewHolder.EXt = false;
      if (!DqZ.equals("3")) {
        paramBaseViewHolder.EXs.setOnClickListener(Dra);
      }
    }
    AppMethodBeat.o(94929);
  }
  
  private static void a(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(94926);
    boolean bool = DqZ.equals("3");
    if (paramSnsInfo.field_type == 1)
    {
      if (bool)
      {
        Drc = 5;
        AppMethodBeat.o(94926);
        return;
      }
      Drc = 0;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramSnsInfo.field_type == 2)
    {
      if (bool)
      {
        Drc = 4;
        AppMethodBeat.o(94926);
        return;
      }
      Drc = 1;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramSnsInfo.field_type == 15)
    {
      if (!bool)
      {
        Drc = 2;
        AppMethodBeat.o(94926);
      }
    }
    else if (r.u(paramSnsInfo))
    {
      if (bool)
      {
        Drc = 6;
        AppMethodBeat.o(94926);
        return;
      }
      Drc = 3;
    }
    AppMethodBeat.o(94926);
  }
  
  public static void b(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(94930);
    if (DqY)
    {
      Drd = paramSnsInfo.field_snsId;
      a(paramSnsInfo);
    }
    AppMethodBeat.o(94930);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(94931);
    Drc = -1;
    Drb = -1;
    Drd = 0L;
    Dra = null;
    Drg = null;
    Dre = null;
    context = null;
    DqY = false;
    DqZ = "0";
    f.KW("7");
    EventCenter.instance.removeListener(Drh);
    EventCenter.instance.removeListener(Dri);
    AppMethodBeat.o(94931);
  }
  
  public static void d(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94924);
    if (g.aWT().KR("7") != null)
    {
      DqY = true;
      DqZ = g.aWT().KR("7").value;
      Log.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[] { DqZ });
      Dre = paramViewGroup;
      Drf = new b(paramViewGroup);
      context = paramContext;
      EventCenter.instance.addListener(Drh);
      EventCenter.instance.addListener(Dri);
      Dra = new a.3();
      Drg = new NotInterestMenu.c()
      {
        public final void c(SnsInfo paramAnonymousSnsInfo)
        {
          AppMethodBeat.i(94921);
          a.a(a.eWv(), paramAnonymousSnsInfo);
          AppMethodBeat.o(94921);
        }
        
        public final void d(SnsInfo paramAnonymousSnsInfo)
        {
          AppMethodBeat.i(94922);
          a.b(a.eWv(), paramAnonymousSnsInfo);
          AppMethodBeat.o(94922);
        }
        
        public final void e(SnsInfo paramAnonymousSnsInfo)
        {
          AppMethodBeat.i(94923);
          a.c(a.eWv(), paramAnonymousSnsInfo);
          AppMethodBeat.o(94923);
        }
      };
      Drf.Drl = Drg;
    }
    AppMethodBeat.o(94924);
  }
  
  public static void eWu()
  {
    AppMethodBeat.i(94925);
    if (Drf != null) {
      Drf.eWy();
    }
    AppMethodBeat.o(94925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a
 * JD-Core Version:    0.7.0.1
 */