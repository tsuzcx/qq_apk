package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AppGrid
  extends GridView
{
  private b FpB;
  int FpC;
  int FpD;
  int FpE;
  int FpF;
  int FpG;
  a FpH;
  Context context;
  AdapterView.OnItemClickListener oey;
  AdapterView.OnItemLongClickListener rEE;
  private SharedPreferences sp;
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31442);
    this.FpD = 0;
    this.FpE = 0;
    this.oey = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).ZG(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).Tr(paramAnonymousInt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31433);
      }
    };
    this.rEE = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).ZG(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).Tr(paramAnonymousInt);
        paramAnonymousAdapterView.ZH(i);
        AppMethodBeat.o(31434);
        return true;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(31442);
  }
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31441);
    this.FpD = 0;
    this.FpE = 0;
    this.oey = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).ZG(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).Tr(paramAnonymousInt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31433);
      }
    };
    this.rEE = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).ZG(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).Tr(paramAnonymousInt);
        paramAnonymousAdapterView.ZH(i);
        AppMethodBeat.o(31434);
        return true;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(31441);
  }
  
  public static a.b a(a.a parama)
  {
    AppMethodBeat.i(163203);
    if (parama == null)
    {
      AppMethodBeat.o(163203);
      return null;
    }
    String str = ad.fom();
    if ("zh_CN".equals(str))
    {
      parama = parama.Frg;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_TW".equals(str))
    {
      parama = parama.Fri;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_HK".equals(str))
    {
      parama = parama.Frh;
      AppMethodBeat.o(163203);
      return parama;
    }
    parama = parama.Frj;
    AppMethodBeat.o(163203);
    return parama;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(31446);
    int i = this.FpH.getCount();
    AppMethodBeat.o(31446);
    return i;
  }
  
  public void setOnAppSelectedListener(b paramb)
  {
    this.FpB = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    private int FpJ;
    private int FpK;
    private Map<String, g> FpL;
    List<g> iKp;
    private boolean xnk;
    
    public a(List<g> paramList, Map<String, g> paramMap, ArrayList<a.a> paramArrayList)
    {
      AppMethodBeat.i(163201);
      this.iKp = new ArrayList();
      this.FpL = null;
      this.xnk = false;
      if (paramMap == null) {}
      for (int i = -1;; i = paramMap.size())
      {
        ae.i("MicroMsg.AppGrid", "AppGridAdapter infoList size:%s ", new Object[] { Integer.valueOf(i) });
        this.iKp.clear();
        this.iKp.addAll(paramMap);
        Collection localCollection;
        this.iKp.addAll(localCollection);
        this.FpL = paramArrayList;
        this.FpJ = BackwardSupportUtil.b.h(paramList, 56.0F);
        this.FpK = BackwardSupportUtil.b.h(paramList, 53.299999F);
        this$1 = localCollection.iterator();
        do
        {
          if (!AppGrid.this.hasNext()) {
            break;
          }
          paramList = AppGrid.a((a.a)AppGrid.this.next());
        } while ((paramList == null) || (bu.isNullOrNil(paramList.desc)));
        this.xnk = true;
        AppMethodBeat.o(163201);
        return;
      }
      AppMethodBeat.o(163201);
    }
    
    private void a(a parama, String paramString1, String paramString2)
    {
      AppMethodBeat.i(31439);
      if (this.FpL == null)
      {
        ae.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
        AppMethodBeat.o(31439);
        return;
      }
      paramString1 = (g)this.FpL.get(paramString1);
      if (paramString1 == null)
      {
        ae.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
        AppMethodBeat.o(31439);
        return;
      }
      if (g.Ffa.equals(paramString1.field_appId))
      {
        parama.ka.setImageResource(2131691015);
        if (bu.isNullOrNil(paramString2)) {
          break label338;
        }
        parama.uyh.setText(h.b(AppGrid.h(AppGrid.this), paramString1, paramString2));
      }
      int i;
      for (;;)
      {
        if ((paramString1.fdF()) && (paramString1.fdG()))
        {
          if (AppGrid.i(AppGrid.this) == null) {
            AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(ak.fow(), 0));
          }
          if (AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramString1.field_appId, true)) {
            parama.FpN.setVisibility(0);
          }
        }
        if (!g.Ffa.equals(paramString1.field_appId)) {
          break label416;
        }
        bc.aCg();
        i = ((Integer)c.ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
        if (i > 1) {
          break label360;
        }
        AppMethodBeat.o(31439);
        return;
        if (g.Ffc.equals(paramString1.field_appId))
        {
          parama.ka.setImageResource(2131691010);
          break;
        }
        if (g.Ffb.equals(paramString1.field_appId))
        {
          parama.ka.setImageResource(2131691004);
          break;
        }
        if (g.Ffd.equals(paramString1.field_appId))
        {
          parama.ka.setImageResource(2131691002);
          break;
        }
        parama.ka.setImageResource(2131231048);
        break;
        label338:
        parama.uyh.setText(h.a(AppGrid.h(AppGrid.this), paramString1, null));
      }
      label360:
      bc.aCg();
      if (!bu.U(((String)c.ajA().get(am.a.IRW, "")).split(";")).contains(String.valueOf(i))) {
        parama.FpN.setVisibility(0);
      }
      AppMethodBeat.o(31439);
      return;
      label416:
      if (g.Ffc.equals(paramString1.field_appId))
      {
        bc.aCg();
        i = ((Integer)c.ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
        if (i <= 1)
        {
          parama.FpN.setVisibility(8);
          AppMethodBeat.o(31439);
          return;
        }
        bc.aCg();
        if (!bu.U(((String)c.ajA().get(am.a.IRX, "")).split(";")).contains(String.valueOf(i))) {
          parama.FpN.setVisibility(0);
        }
      }
      AppMethodBeat.o(31439);
    }
    
    public final g Tr(int paramInt)
    {
      AppMethodBeat.i(31437);
      if (((paramInt < AppGrid.g(AppGrid.this)) && (AppGrid.a(AppGrid.this) == 0)) || (AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt < AppGrid.g(AppGrid.this)) || (paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) >= this.iKp.size()))
      {
        AppMethodBeat.o(31437);
        return null;
      }
      paramInt = paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this);
      ae.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[] { Integer.valueOf(paramInt) });
      g localg = (g)this.iKp.get(paramInt);
      AppMethodBeat.o(31437);
      return localg;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(31436);
      if (AppGrid.a(AppGrid.this) == AppGrid.e(AppGrid.this) - 1)
      {
        i = AppGrid.f(AppGrid.this);
        int j = AppGrid.a(AppGrid.this);
        int k = AppGrid.b(AppGrid.this);
        AppMethodBeat.o(31436);
        return i - j * k;
      }
      int i = AppGrid.b(AppGrid.this);
      AppMethodBeat.o(31436);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(31438);
      label192:
      Object localObject1;
      int i;
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(AppGrid.h(AppGrid.this), 2131493083, null);
        paramViewGroup.ka = ((ImageView)paramView.findViewById(2131296847));
        paramViewGroup.FpM = ((CdnImageView)paramView.findViewById(2131296846));
        paramViewGroup.FpO = paramView.findViewById(2131296848);
        paramViewGroup.uyh = ((TextView)paramView.findViewById(2131296849));
        paramViewGroup.iGz = ((TextView)paramView.findViewById(2131296845));
        paramViewGroup.FpN = ((TextView)paramView.findViewById(2131296850));
        paramViewGroup.FpP = paramView.findViewById(2131296851);
        paramView.setTag(paramViewGroup);
        ae.i("MicroMsg.AppGrid", "pos:" + paramInt + " page:" + AppGrid.a(AppGrid.this));
        paramViewGroup.uyh.setVisibility(0);
        if (!this.xnk) {
          break label467;
        }
        paramViewGroup.iGz.setVisibility(0);
        paramViewGroup.FpP.setVisibility(8);
        paramViewGroup.FpN.setVisibility(8);
        paramViewGroup.FpO.setVisibility(0);
        paramViewGroup.ka.setVisibility(0);
        paramViewGroup.FpM.setVisibility(8);
        localObject1 = paramViewGroup.ka.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.FpJ;
        ((ViewGroup.LayoutParams)localObject1).height = this.FpJ;
        paramViewGroup.ka.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        i = AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt;
        int j = AppGrid.c(AppGrid.this).ZG(i);
        if (i >= AppGrid.g(AppGrid.this)) {
          break label1635;
        }
        switch (j)
        {
        }
      }
      for (;;)
      {
        localObject1 = Tr(paramInt);
        if ((localObject1 != null) && (h.o((g)localObject1))) {
          paramViewGroup.FpN.setVisibility(0);
        }
        AppMethodBeat.o(31438);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label467:
        paramViewGroup.iGz.setVisibility(8);
        break label192;
        paramViewGroup.ka.setImageResource(2131691006);
        paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755742));
        continue;
        paramViewGroup.ka.setImageResource(2131691020);
        paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755758));
        label1635:
        try
        {
          bc.aCg();
          if (((Boolean)c.ajA().get(67, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.FpN.setVisibility(0);
            continue;
          }
          paramViewGroup.FpN.setVisibility(8);
        }
        catch (Exception localException2) {}
        paramViewGroup.ka.setImageResource(2131691017);
        paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131760219));
        label1736:
        label2018:
        try
        {
          bc.aCg();
          if (((Boolean)c.ajA().get(73, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.FpN.setVisibility(0);
            continue;
          }
          paramViewGroup.FpN.setVisibility(8);
        }
        catch (Exception localException3) {}
        if (ac.iSG)
        {
          paramViewGroup.ka.setImageResource(2131691014);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755756));
        }
        else
        {
          paramViewGroup.ka.setImageResource(2131691003);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755747));
          continue;
          paramViewGroup.ka.setImageResource(2131691012);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755750));
          continue;
          paramViewGroup.ka.setImageResource(2131691009);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755745));
          try
          {
            bc.aCg();
            if (((Boolean)c.ajA().get(290817, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.FpP.setVisibility(0);
              continue;
            }
            paramViewGroup.FpP.setVisibility(8);
          }
          catch (Exception localException4) {}
          paramViewGroup.ka.setImageResource(2131691013);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755755));
          try
          {
            bc.aCg();
            if (((Boolean)c.ajA().get(327744, Boolean.TRUE)).booleanValue())
            {
              paramViewGroup.FpP.setVisibility(0);
              continue;
            }
            paramViewGroup.FpP.setVisibility(8);
          }
          catch (Exception localException5) {}
          paramViewGroup.ka.setImageResource(2131691008);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755737));
          continue;
          paramViewGroup.ka.setImageResource(2131691018);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755762));
          try
          {
            bc.aCg();
            if (((Boolean)c.ajA().get(54, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.FpN.setVisibility(0);
              continue;
            }
            paramViewGroup.FpN.setVisibility(8);
          }
          catch (Exception localException6) {}
          paramViewGroup.ka.setImageResource(2131691019);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755764));
          try
          {
            bc.aCg();
            if (((Boolean)c.ajA().get(62, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.FpN.setVisibility(0);
              continue;
            }
            paramViewGroup.FpN.setVisibility(8);
          }
          catch (Exception localException7) {}
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131758379));
          try
          {
            bc.aCg();
            boolean bool1 = ((Boolean)c.ajA().get(208899, Boolean.FALSE)).booleanValue();
            bc.aCg();
            boolean bool2 = ((Boolean)c.ajA().get(208913, Boolean.FALSE)).booleanValue();
            if ((bool1) || (bool2))
            {
              paramViewGroup.FpN.setVisibility(0);
              if (bool2)
              {
                paramViewGroup.FpN.setText(2131755781);
                continue;
              }
              paramViewGroup.FpN.setText(2131755829);
              continue;
            }
            paramViewGroup.FpN.setVisibility(8);
          }
          catch (Exception localException8) {}
          ae.i("MicroMsg.AppGrid", "attach remittance");
          a(paramViewGroup, g.Ffa, AppGrid.h(AppGrid.this).getString(2131755759));
          continue;
          ae.i("MicroMsg.AppGrid", "attach lucky money");
          a(paramViewGroup, g.Ffc, AppGrid.h(AppGrid.this).getString(2131755746));
          continue;
          paramViewGroup.ka.setImageResource(2131691011);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755764));
          try
          {
            bc.aCg();
            if (((Boolean)c.ajA().get(81, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.FpN.setVisibility(0);
              continue;
            }
            paramViewGroup.FpN.setVisibility(8);
          }
          catch (Exception localException9) {}
          paramViewGroup.ka.setImageResource(2131691005);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755741));
          try
          {
            paramViewGroup.FpP.setVisibility(8);
          }
          catch (Exception localException1) {}
          continue;
          paramViewGroup.ka.setImageResource(2131691601);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131757997));
          continue;
          a(paramViewGroup, g.Ffd, null);
          continue;
          paramViewGroup.ka.setImageResource(2131691007);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755743));
          continue;
          paramViewGroup.ka.setImageResource(2131690410);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131755744));
          continue;
          paramViewGroup.ka.setImageResource(2131691467);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131756237));
          continue;
          paramViewGroup.ka.setImageResource(2131691550);
          paramViewGroup.uyh.setText(AppGrid.h(AppGrid.this).getString(2131756264));
          continue;
          localException1.width = this.FpK;
          localException1.height = this.FpK;
          paramViewGroup.ka.setLayoutParams(localException1);
          Object localObject2 = Tr(paramInt);
          if (localObject2 != null)
          {
            if ((localObject2 instanceof a.a))
            {
              localObject2 = (a.a)localObject2;
              a.b localb = AppGrid.a((a.a)localObject2);
              String str = ((a.a)localObject2).iconUrl;
              i = -1;
              switch (str.hashCode())
              {
              default: 
                switch (i)
                {
                default: 
                  paramViewGroup.ka.setVisibility(8);
                  paramViewGroup.FpM.setVisibility(0);
                  if ((al.isDarkMode()) && (!bu.isNullOrNil(((a.a)localObject2).Frk))) {
                    paramViewGroup.FpM.aK(((a.a)localObject2).Frk, com.tencent.mm.cb.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).Frl), com.tencent.mm.cb.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).Frm));
                  }
                  break;
                }
                break;
              }
              for (;;)
              {
                paramViewGroup.uyh.setText(localb.title);
                if (bu.isNullOrNil(localb.desc)) {
                  break;
                }
                paramViewGroup.iGz.setText(localb.desc);
                break;
                if (!str.equals("icons_filled_health_note")) {
                  break label1736;
                }
                i = 0;
                break label1736;
                if (!str.equals("icons_filled_live_mark")) {
                  break label1736;
                }
                i = 1;
                break label1736;
                paramViewGroup.ka.setImageResource(2131690412);
                continue;
                paramViewGroup.ka.setImageResource(2131690421);
                continue;
                paramViewGroup.FpM.aK(((a.a)localObject2).iconUrl, com.tencent.mm.cb.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).Frl), com.tencent.mm.cb.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).Frm));
              }
            }
            bc.aCg();
            if (c.isSDCardAvailable()) {
              if (((g)localObject2).field_status == 5)
              {
                h.c(((g)localObject2).field_appId, 3, com.tencent.mm.cb.a.getDensity(AppGrid.h(AppGrid.this)));
                if (!g.Ffa.equals(((g)localObject2).field_appId)) {
                  break label2210;
                }
                paramViewGroup.ka.setImageResource(2131691015);
              }
            }
            for (;;)
            {
              paramViewGroup.uyh.setText(h.a(AppGrid.h(AppGrid.this), (g)localObject2, null));
              if ((!((g)localObject2).fdF()) || (!((g)localObject2).fdG())) {
                break;
              }
              if (AppGrid.i(AppGrid.this) == null) {
                AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(ak.fow(), 0));
              }
              if (!AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + ((g)localObject2).field_appId, true)) {
                break;
              }
              paramViewGroup.FpN.setVisibility(0);
              break;
              if (((g)localObject2).fdF())
              {
                h.c(((g)localObject2).field_appId, 4, com.tencent.mm.cb.a.getDensity(AppGrid.h(AppGrid.this)));
                break label2018;
              }
              h.c(((g)localObject2).field_appId, 1, com.tencent.mm.cb.a.getDensity(AppGrid.h(AppGrid.this)));
              break label2018;
              label2210:
              if (g.Ffc.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.ka.setImageResource(2131691010);
              }
              else if (g.Ffb.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.ka.setImageResource(2131691004);
              }
              else if (g.Ffd.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.ka.setImageResource(2131691002);
              }
              else
              {
                paramViewGroup.ka.setBackgroundResource(2131231048);
                continue;
                paramViewGroup.ka.setBackgroundResource(2131234029);
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
    
    final class a
    {
      CdnImageView FpM;
      TextView FpN;
      View FpO;
      View FpP;
      TextView iGz;
      ImageView ka;
      TextView uyh;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract int ZG(int paramInt);
    
    public abstract void ZH(int paramInt);
    
    public abstract void a(int paramInt, g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid
 * JD-Core Version:    0.7.0.1
 */