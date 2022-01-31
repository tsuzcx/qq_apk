package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;
import java.util.Map;

final class AppGrid$a
  extends BaseAdapter
{
  List<f> gfG;
  private int vUM;
  private int vUN;
  private Map<String, f> vUO;
  
  public AppGrid$a(Context paramContext, List<f> paramList, Map<String, f> paramMap)
  {
    AppMethodBeat.i(27729);
    this.vUO = null;
    if (paramMap == null) {}
    for (int i = -1;; i = paramMap.size())
    {
      ab.i("MicroMsg.AppGrid", "AppGridAdapter infoList size:%s ", new Object[] { Integer.valueOf(i) });
      this.gfG = paramMap;
      Object localObject;
      this.vUO = localObject;
      this.vUM = BackwardSupportUtil.b.b(paramList, 56.0F);
      this.vUN = BackwardSupportUtil.b.b(paramList, 53.299999F);
      AppMethodBeat.o(27729);
      return;
    }
  }
  
  private void a(AppGrid.a.a parama, String paramString1, String paramString2)
  {
    AppMethodBeat.i(27733);
    if (this.vUO == null)
    {
      ab.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
      AppMethodBeat.o(27733);
      return;
    }
    paramString1 = (f)this.vUO.get(paramString1);
    if (paramString1 == null)
    {
      ab.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
      AppMethodBeat.o(27733);
      return;
    }
    aw.aaz();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (paramString1.dlw()) {
        g.b(paramString1.field_appId, 4, com.tencent.mm.cb.a.getDensity(AppGrid.h(this.vUL)));
      }
      if (f.vKX.equals(paramString1.field_appId))
      {
        parama.iTH.setImageResource(2131231846);
        if (bo.isNullOrNil(paramString2)) {
          break label382;
        }
        parama.nwS.setText(g.c(AppGrid.h(this.vUL), paramString1, paramString2));
      }
    }
    int i;
    for (;;)
    {
      if ((paramString1.dlw()) && (paramString1.dlx()))
      {
        if (AppGrid.i(this.vUL) == null) {
          AppGrid.a(this.vUL, AppGrid.h(this.vUL).getSharedPreferences(ah.dsP(), 0));
        }
        if (AppGrid.i(this.vUL).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramString1.field_appId, true)) {
          parama.vUP.setVisibility(0);
        }
      }
      if (!f.vKX.equals(paramString1.field_appId)) {
        break label459;
      }
      aw.aaz();
      i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
      if (i > 1) {
        break label404;
      }
      AppMethodBeat.o(27733);
      return;
      if (f.vKZ.equals(paramString1.field_appId))
      {
        parama.iTH.setImageResource(2131231841);
        break;
      }
      if (f.vKY.equals(paramString1.field_appId))
      {
        parama.iTH.setImageResource(2131231835);
        break;
      }
      if (f.vLa.equals(paramString1.field_appId))
      {
        parama.iTH.setImageResource(2131231833);
        break;
      }
      parama.iTH.setImageResource(2130837795);
      break;
      parama.iTH.setImageResource(2130840316);
      break;
      label382:
      parama.nwS.setText(g.b(AppGrid.h(this.vUL), paramString1, null));
    }
    label404:
    aw.aaz();
    if (!bo.P(((String)com.tencent.mm.model.c.Ru().get(ac.a.yEL, "")).split(";")).contains(String.valueOf(i))) {
      parama.vUP.setVisibility(0);
    }
    AppMethodBeat.o(27733);
    return;
    label459:
    if (f.vKZ.equals(paramString1.field_appId))
    {
      if (com.tencent.mm.x.c.PJ().a(ac.a.yJi, ac.a.yJj)) {
        parama.vUQ.setVisibility(0);
      }
      for (;;)
      {
        aw.aaz();
        i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
        if (i > 1) {
          break;
        }
        parama.vUP.setVisibility(8);
        AppMethodBeat.o(27733);
        return;
        parama.vUQ.setVisibility(8);
      }
      aw.aaz();
      if (!bo.P(((String)com.tencent.mm.model.c.Ru().get(ac.a.yEM, "")).split(";")).contains(String.valueOf(i))) {
        parama.vUP.setVisibility(0);
      }
    }
    AppMethodBeat.o(27733);
  }
  
  public final f Gn(int paramInt)
  {
    AppMethodBeat.i(27731);
    if (((paramInt < AppGrid.g(this.vUL)) && (AppGrid.a(this.vUL) == 0)) || (AppGrid.a(this.vUL) * AppGrid.b(this.vUL) + paramInt < AppGrid.g(this.vUL)) || (paramInt - AppGrid.g(this.vUL) + AppGrid.a(this.vUL) * AppGrid.b(this.vUL) >= this.gfG.size()))
    {
      AppMethodBeat.o(27731);
      return null;
    }
    paramInt = paramInt - AppGrid.g(this.vUL) + AppGrid.a(this.vUL) * AppGrid.b(this.vUL);
    ab.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[] { Integer.valueOf(paramInt) });
    f localf = (f)this.gfG.get(paramInt);
    AppMethodBeat.o(27731);
    return localf;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(27730);
    if (AppGrid.a(this.vUL) == AppGrid.e(this.vUL) - 1)
    {
      i = AppGrid.f(this.vUL);
      int j = AppGrid.a(this.vUL);
      int k = AppGrid.b(this.vUL);
      AppMethodBeat.o(27730);
      return i - j * k;
    }
    int i = AppGrid.b(this.vUL);
    AppMethodBeat.o(27730);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27732);
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new AppGrid.a.a(this);
      paramView = View.inflate(AppGrid.h(this.vUL), 2130968757, null);
      paramViewGroup.iTH = ((ImageView)paramView.findViewById(2131821478));
      paramViewGroup.qMe = paramView.findViewById(2131821477);
      paramViewGroup.nwS = ((TextView)paramView.findViewById(2131821479));
      paramViewGroup.vUP = ((TextView)paramView.findViewById(2131821480));
      paramViewGroup.vUQ = paramView.findViewById(2131821481);
      paramView.setTag(paramViewGroup);
      ab.i("MicroMsg.AppGrid", "pos:" + paramInt + " page:" + AppGrid.a(this.vUL));
      paramViewGroup.nwS.setVisibility(0);
      paramViewGroup.vUQ.setVisibility(8);
      paramViewGroup.vUP.setVisibility(8);
      paramViewGroup.qMe.setVisibility(0);
      localObject = paramViewGroup.iTH.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.vUM;
      ((ViewGroup.LayoutParams)localObject).height = this.vUM;
      paramViewGroup.iTH.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = AppGrid.a(this.vUL) * AppGrid.b(this.vUL) + paramInt;
      int j = AppGrid.c(this.vUL).Mf(i);
      if (i >= AppGrid.g(this.vUL)) {
        break label1415;
      }
      switch (j)
      {
      }
    }
    for (;;)
    {
      localObject = Gn(paramInt);
      if ((localObject != null) && (g.n((f)localObject))) {
        paramViewGroup.vUP.setVisibility(0);
      }
      AppMethodBeat.o(27732);
      return paramView;
      paramViewGroup = (AppGrid.a.a)paramView.getTag();
      break;
      paramViewGroup.iTH.setImageResource(2131231837);
      paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296934));
      continue;
      paramViewGroup.iTH.setImageResource(2131231851);
      paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296948));
      label1415:
      label1493:
      try
      {
        aw.aaz();
        if (((Boolean)com.tencent.mm.model.c.Ru().get(67, Boolean.FALSE)).booleanValue())
        {
          paramViewGroup.vUP.setVisibility(0);
          continue;
        }
        paramViewGroup.vUP.setVisibility(8);
      }
      catch (Exception localException2) {}
      paramViewGroup.iTH.setImageResource(2131231848);
      paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131300625));
      label1685:
      try
      {
        aw.aaz();
        if (((Boolean)com.tencent.mm.model.c.Ru().get(73, Boolean.FALSE)).booleanValue())
        {
          paramViewGroup.vUP.setVisibility(0);
          continue;
        }
        paramViewGroup.vUP.setVisibility(8);
      }
      catch (Exception localException3) {}
      if (ae.glE)
      {
        paramViewGroup.iTH.setImageResource(2131231845);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296947));
      }
      else
      {
        paramViewGroup.iTH.setImageResource(2131231834);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296938));
        continue;
        paramViewGroup.iTH.setImageResource(2131231843);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296941));
        continue;
        paramViewGroup.iTH.setImageResource(2131231840);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296936));
        try
        {
          aw.aaz();
          if (((Boolean)com.tencent.mm.model.c.Ru().get(290817, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.vUQ.setVisibility(0);
            continue;
          }
          paramViewGroup.vUQ.setVisibility(8);
        }
        catch (Exception localException4) {}
        paramViewGroup.iTH.setImageResource(2131231844);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296946));
        try
        {
          aw.aaz();
          if (((Boolean)com.tencent.mm.model.c.Ru().get(327744, Boolean.TRUE)).booleanValue())
          {
            paramViewGroup.vUQ.setVisibility(0);
            continue;
          }
          paramViewGroup.vUQ.setVisibility(8);
        }
        catch (Exception localException5) {}
        paramViewGroup.iTH.setImageResource(2131231839);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296930));
        continue;
        paramViewGroup.iTH.setImageResource(2131231849);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296952));
        try
        {
          aw.aaz();
          if (((Boolean)com.tencent.mm.model.c.Ru().get(54, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.vUP.setVisibility(0);
            continue;
          }
          paramViewGroup.vUP.setVisibility(8);
        }
        catch (Exception localException6) {}
        paramViewGroup.iTH.setImageResource(2131231850);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296954));
        try
        {
          aw.aaz();
          if (((Boolean)com.tencent.mm.model.c.Ru().get(62, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.vUP.setVisibility(0);
            continue;
          }
          paramViewGroup.vUP.setVisibility(8);
        }
        catch (Exception localException7) {}
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131299253));
        try
        {
          aw.aaz();
          boolean bool1 = ((Boolean)com.tencent.mm.model.c.Ru().get(208899, Boolean.FALSE)).booleanValue();
          aw.aaz();
          boolean bool2 = ((Boolean)com.tencent.mm.model.c.Ru().get(208913, Boolean.FALSE)).booleanValue();
          if ((bool1) || (bool2))
          {
            paramViewGroup.vUP.setVisibility(0);
            if (bool2)
            {
              paramViewGroup.vUP.setText(2131296966);
              continue;
            }
            paramViewGroup.vUP.setText(2131297012);
            continue;
          }
          paramViewGroup.vUP.setVisibility(8);
        }
        catch (Exception localException8) {}
        ab.i("MicroMsg.AppGrid", "attach remittance");
        a(paramViewGroup, f.vKX, AppGrid.h(this.vUL).getString(2131296949));
        continue;
        ab.i("MicroMsg.AppGrid", "attach lucky money");
        a(paramViewGroup, f.vKZ, AppGrid.h(this.vUL).getString(2131296937));
        continue;
        paramViewGroup.iTH.setImageResource(2131231842);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296954));
        try
        {
          aw.aaz();
          if (((Boolean)com.tencent.mm.model.c.Ru().get(81, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.vUP.setVisibility(0);
            continue;
          }
          paramViewGroup.vUP.setVisibility(8);
        }
        catch (Exception localException9) {}
        paramViewGroup.iTH.setImageResource(2131231836);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296933));
        try
        {
          paramViewGroup.vUQ.setVisibility(8);
        }
        catch (Exception localException1) {}
        continue;
        a(paramViewGroup, f.vLa, null);
        continue;
        paramViewGroup.iTH.setImageResource(2131231838);
        paramViewGroup.nwS.setText(AppGrid.h(this.vUL).getString(2131296935));
        continue;
        localException1.width = this.vUN;
        localException1.height = this.vUN;
        paramViewGroup.iTH.setLayoutParams(localException1);
        f localf = Gn(paramInt);
        if (localf != null)
        {
          aw.aaz();
          if (com.tencent.mm.model.c.isSDCardAvailable()) {
            if (localf.field_status == 5)
            {
              g.b(localf.field_appId, 3, com.tencent.mm.cb.a.getDensity(AppGrid.h(this.vUL)));
              if (!f.vKX.equals(localf.field_appId)) {
                break label1685;
              }
              paramViewGroup.iTH.setImageResource(2131231846);
            }
          }
          for (;;)
          {
            paramViewGroup.nwS.setText(g.b(AppGrid.h(this.vUL), localf, null));
            if ((!localf.dlw()) || (!localf.dlx())) {
              break;
            }
            if (AppGrid.i(this.vUL) == null) {
              AppGrid.a(this.vUL, AppGrid.h(this.vUL).getSharedPreferences(ah.dsP(), 0));
            }
            if (!AppGrid.i(this.vUL).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + localf.field_appId, true)) {
              break;
            }
            paramViewGroup.vUP.setVisibility(0);
            break;
            if (localf.dlw())
            {
              g.b(localf.field_appId, 4, com.tencent.mm.cb.a.getDensity(AppGrid.h(this.vUL)));
              break label1493;
            }
            g.b(localf.field_appId, 1, com.tencent.mm.cb.a.getDensity(AppGrid.h(this.vUL)));
            break label1493;
            if (f.vKZ.equals(localf.field_appId))
            {
              paramViewGroup.iTH.setImageResource(2131231841);
            }
            else if (f.vKY.equals(localf.field_appId))
            {
              paramViewGroup.iTH.setImageResource(2131231835);
            }
            else if (f.vLa.equals(localf.field_appId))
            {
              paramViewGroup.iTH.setImageResource(2131231833);
            }
            else
            {
              paramViewGroup.iTH.setBackgroundResource(2130837795);
              continue;
              paramViewGroup.iTH.setBackgroundResource(2130840316);
            }
          }
          continue;
          continue;
          continue;
          continue;
          continue;
          continue;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid.a
 * JD-Core Version:    0.7.0.1
 */