package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.iz;
import com.tencent.mm.f.a.wq;
import com.tencent.mm.model.a.c;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
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
  private static boolean JwD;
  private static String JwE;
  private static View.OnClickListener JwF;
  private static int JwG;
  private static int JwH;
  private static long JwI;
  private static View JwJ;
  private static b JwK;
  private static NotInterestMenu.c JwL;
  private static IListener JwM;
  private static IListener JwN;
  private static Context context;
  
  static
  {
    AppMethodBeat.i(94936);
    JwD = false;
    JwE = "0";
    JwF = null;
    JwG = -1;
    JwH = -1;
    JwI = 0L;
    JwJ = null;
    JwK = null;
    JwL = null;
    context = null;
    JwM = new IListener() {};
    JwN = new IListener() {};
    AppMethodBeat.o(94936);
  }
  
  public static void a(Context paramContext, SnsInfo paramSnsInfo)
  {
    int i = 2;
    AppMethodBeat.i(94927);
    Intent localIntent;
    if ((JwD) && (paramSnsInfo != null) && (paramContext != null))
    {
      JwI = paramSnsInfo.field_snsId;
      a(paramSnsInfo);
      localIntent = new Intent(paramContext, SnsNotInterestUI.class);
      localIntent.putExtra("sns_info_svr_id", JwI);
      if ((!JwD) || (Util.isNullOrNil(JwE))) {
        break label210;
      }
      if ((!JwE.equals("1")) && (!JwE.equals("2"))) {
        break label166;
      }
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("sns_info_not_interest_scene", i);
      paramSnsInfo = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramSnsInfo.aFh(), "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramSnsInfo.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealNotInterest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(94927);
      return;
      label166:
      if (JwE.equals("3"))
      {
        if (t.v(paramSnsInfo)) {
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
    if ((JwD) && (JwE.equals("3")) && (paramSnsInfo != null) && (!paramSnsInfo.isAd()) && (!paramSnsInfo.getUserName().equals(aj.fOo())) && (paramSnsInfo.field_type != 15)) {
      paramContextMenu.add(0, 13, 0, i.j.sns_hate_op_un_like);
    }
    AppMethodBeat.o(94928);
  }
  
  public static void a(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94929);
    if ((JwD) && (!Util.isNullOrNil(JwE)) && (!JwE.equals("0")))
    {
      paramBaseViewHolder.LlG = ((ImageView)paramView.findViewById(i.f.sns_hate_item_arrow));
      paramBaseViewHolder.LlG.setVisibility(8);
      paramBaseViewHolder.LlH = false;
      if (!JwE.equals("3")) {
        paramBaseViewHolder.LlG.setOnClickListener(JwF);
      }
    }
    AppMethodBeat.o(94929);
  }
  
  private static void a(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(94926);
    boolean bool = JwE.equals("3");
    if (paramSnsInfo.field_type == 1)
    {
      if (bool)
      {
        JwH = 5;
        AppMethodBeat.o(94926);
        return;
      }
      JwH = 0;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramSnsInfo.field_type == 2)
    {
      if (bool)
      {
        JwH = 4;
        AppMethodBeat.o(94926);
        return;
      }
      JwH = 1;
      AppMethodBeat.o(94926);
      return;
    }
    if (paramSnsInfo.field_type == 15)
    {
      if (!bool)
      {
        JwH = 2;
        AppMethodBeat.o(94926);
      }
    }
    else if (t.v(paramSnsInfo))
    {
      if (bool)
      {
        JwH = 6;
        AppMethodBeat.o(94926);
        return;
      }
      JwH = 3;
    }
    AppMethodBeat.o(94926);
  }
  
  public static void b(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(94930);
    if (JwD)
    {
      JwI = paramSnsInfo.field_snsId;
      a(paramSnsInfo);
    }
    AppMethodBeat.o(94930);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(94931);
    JwH = -1;
    JwG = -1;
    JwI = 0L;
    JwF = null;
    JwL = null;
    JwJ = null;
    context = null;
    JwD = false;
    JwE = "0";
    f.Sp("7");
    EventCenter.instance.removeListener(JwM);
    EventCenter.instance.removeListener(JwN);
    AppMethodBeat.o(94931);
  }
  
  public static void d(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94924);
    if (g.bga().Sk("7") != null)
    {
      JwD = true;
      JwE = g.bga().Sk("7").value;
      Log.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[] { JwE });
      JwJ = paramViewGroup;
      JwK = new b(paramViewGroup);
      context = paramContext;
      EventCenter.instance.addListener(JwM);
      EventCenter.instance.addListener(JwN);
      JwF = new a.3();
      JwL = new NotInterestMenu.c()
      {
        public final void c(SnsInfo paramAnonymousSnsInfo)
        {
          AppMethodBeat.i(94921);
          a.a(a.fJy(), paramAnonymousSnsInfo);
          AppMethodBeat.o(94921);
        }
        
        public final void d(SnsInfo paramAnonymousSnsInfo)
        {
          AppMethodBeat.i(94922);
          a.b(a.fJy(), paramAnonymousSnsInfo);
          AppMethodBeat.o(94922);
        }
        
        public final void e(SnsInfo paramAnonymousSnsInfo)
        {
          AppMethodBeat.i(94923);
          a.c(a.fJy(), paramAnonymousSnsInfo);
          AppMethodBeat.o(94923);
        }
      };
      JwK.JwQ = JwL;
    }
    AppMethodBeat.o(94924);
  }
  
  public static void fJx()
  {
    AppMethodBeat.i(94925);
    if (JwK != null) {
      JwK.fJB();
    }
    AppMethodBeat.o(94925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a
 * JD-Core Version:    0.7.0.1
 */