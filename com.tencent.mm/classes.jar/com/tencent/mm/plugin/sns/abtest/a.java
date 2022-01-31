package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsNotInterestUI;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  private static Context context = null;
  private static boolean ojn = false;
  private static String ojo = "0";
  private static View.OnClickListener ojp = null;
  private static int ojq = -1;
  private static int ojr = -1;
  private static long ojs = 0L;
  private static View ojt = null;
  private static b oju = null;
  private static NotInterestMenu.c ojv = null;
  private static com.tencent.mm.sdk.b.c ojw = new a.1();
  private static com.tencent.mm.sdk.b.c ojx = new a.2();
  
  public static void a(Context paramContext, n paramn)
  {
    int i = 2;
    Intent localIntent;
    if ((ojn) && (paramn != null) && (paramContext != null))
    {
      ojs = paramn.field_snsId;
      a(paramn);
      localIntent = new Intent(paramContext, SnsNotInterestUI.class);
      localIntent.putExtra("sns_info_svr_id", ojs);
      if ((!ojn) || (bk.bl(ojo))) {
        break label145;
      }
      if ((!ojo.equals("1")) && (!ojo.equals("2"))) {
        break label101;
      }
      i = 1;
    }
    label145:
    for (;;)
    {
      localIntent.putExtra("sns_info_not_interest_scene", i);
      paramContext.startActivity(localIntent);
      return;
      label101:
      if (ojo.equals("3"))
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
    if ((ojn) && (ojo.equals("3")) && (paramn != null) && (!paramn.yr(32)) && (!paramn.field_userName.equals(af.bDl())) && (paramn.field_type != 15)) {
      paramContextMenu.add(0, 13, 0, i.j.sns_hate_op_un_like);
    }
  }
  
  public static void a(View paramView, a.c paramc)
  {
    if ((ojn) && (!bk.bl(ojo)) && (!ojo.equals("0")))
    {
      paramc.pnu = ((ImageView)paramView.findViewById(i.f.sns_hate_item_arrow));
      paramc.pnu.setVisibility(8);
      paramc.pnv = false;
      if (!ojo.equals("3")) {
        paramc.pnu.setOnClickListener(ojp);
      }
    }
  }
  
  private static void a(n paramn)
  {
    boolean bool = ojo.equals("3");
    if (paramn.field_type == 1) {
      if (bool) {
        ojr = 5;
      }
    }
    do
    {
      do
      {
        return;
        ojr = 0;
        return;
        if (paramn.field_type == 2)
        {
          if (bool)
          {
            ojr = 4;
            return;
          }
          ojr = 1;
          return;
        }
        if (paramn.field_type != 15) {
          break;
        }
      } while (bool);
      ojr = 2;
      return;
    } while (!i.i(paramn));
    if (bool)
    {
      ojr = 6;
      return;
    }
    ojr = 3;
  }
  
  public static void b(n paramn)
  {
    if (ojn)
    {
      ojs = paramn.field_snsId;
      a(paramn);
    }
  }
  
  public static void bBV()
  {
    if (oju != null) {
      oju.bBZ();
    }
  }
  
  public static void clean()
  {
    ojr = -1;
    ojq = -1;
    ojs = 0L;
    ojp = null;
    ojv = null;
    ojt = null;
    context = null;
    ojn = false;
    ojo = "0";
    f.jc("7");
    com.tencent.mm.sdk.b.a.udP.d(ojw);
    com.tencent.mm.sdk.b.a.udP.d(ojx);
  }
  
  public static void d(Context paramContext, ViewGroup paramViewGroup)
  {
    if (g.Iy().iX("7") != null)
    {
      ojn = true;
      ojo = g.Iy().iX("7").value;
      y.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[] { ojo });
      ojt = paramViewGroup;
      oju = new b(paramViewGroup);
      context = paramContext;
      com.tencent.mm.sdk.b.a.udP.c(ojw);
      com.tencent.mm.sdk.b.a.udP.c(ojx);
      ojp = new a.3();
      ojv = new a.4();
      oju.ojA = ojv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a
 * JD-Core Version:    0.7.0.1
 */