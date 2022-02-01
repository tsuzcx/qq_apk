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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AppGrid
  extends GridView
{
  private b EXh;
  int EXi;
  int EXj;
  int EXk;
  int EXl;
  int EXm;
  a EXn;
  Context context;
  AdapterView.OnItemClickListener nYP;
  AdapterView.OnItemLongClickListener rws;
  private SharedPreferences sp;
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31442);
    this.EXj = 0;
    this.EXk = 0;
    this.nYP = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).Za(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).SK(paramAnonymousInt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31433);
      }
    };
    this.rws = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).Za(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).SK(paramAnonymousInt);
        paramAnonymousAdapterView.Zb(i);
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
    this.EXj = 0;
    this.EXk = 0;
    this.nYP = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).Za(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).SK(paramAnonymousInt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31433);
      }
    };
    this.rws = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).Za(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).SK(paramAnonymousInt);
        paramAnonymousAdapterView.Zb(i);
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
    String str = com.tencent.mm.sdk.platformtools.ac.fks();
    if ("zh_CN".equals(str))
    {
      parama = parama.EYL;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_TW".equals(str))
    {
      parama = parama.EYN;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_HK".equals(str))
    {
      parama = parama.EYM;
      AppMethodBeat.o(163203);
      return parama;
    }
    parama = parama.EYO;
    AppMethodBeat.o(163203);
    return parama;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(31446);
    int i = this.EXn.getCount();
    AppMethodBeat.o(31446);
    return i;
  }
  
  public void setOnAppSelectedListener(b paramb)
  {
    this.EXh = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    private int EXp;
    private int EXq;
    private Map<String, g> EXr;
    List<g> iHw;
    private boolean wXt;
    
    public a(List<g> paramList, Map<String, g> paramMap, ArrayList<a.a> paramArrayList)
    {
      AppMethodBeat.i(163201);
      this.iHw = new ArrayList();
      this.EXr = null;
      this.wXt = false;
      if (paramMap == null) {}
      for (int i = -1;; i = paramMap.size())
      {
        ad.i("MicroMsg.AppGrid", "AppGridAdapter infoList size:%s ", new Object[] { Integer.valueOf(i) });
        this.iHw.clear();
        this.iHw.addAll(paramMap);
        Collection localCollection;
        this.iHw.addAll(localCollection);
        this.EXr = paramArrayList;
        this.EXp = BackwardSupportUtil.b.g(paramList, 56.0F);
        this.EXq = BackwardSupportUtil.b.g(paramList, 53.299999F);
        this$1 = localCollection.iterator();
        do
        {
          if (!AppGrid.this.hasNext()) {
            break;
          }
          paramList = AppGrid.a((a.a)AppGrid.this.next());
        } while ((paramList == null) || (bt.isNullOrNil(paramList.desc)));
        this.wXt = true;
        AppMethodBeat.o(163201);
        return;
      }
      AppMethodBeat.o(163201);
    }
    
    private void a(a parama, String paramString1, String paramString2)
    {
      AppMethodBeat.i(31439);
      if (this.EXr == null)
      {
        ad.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
        AppMethodBeat.o(31439);
        return;
      }
      paramString1 = (g)this.EXr.get(paramString1);
      if (paramString1 == null)
      {
        ad.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
        AppMethodBeat.o(31439);
        return;
      }
      if (g.EMD.equals(paramString1.field_appId))
      {
        parama.ka.setImageResource(2131691015);
        if (bt.isNullOrNil(paramString2)) {
          break label338;
        }
        parama.umK.setText(h.b(AppGrid.h(AppGrid.this), paramString1, paramString2));
      }
      int i;
      for (;;)
      {
        if ((paramString1.eZR()) && (paramString1.eZS()))
        {
          if (AppGrid.i(AppGrid.this) == null) {
            AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(aj.fkC(), 0));
          }
          if (AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramString1.field_appId, true)) {
            parama.EXt.setVisibility(0);
          }
        }
        if (!g.EMD.equals(paramString1.field_appId)) {
          break label416;
        }
        ba.aBQ();
        i = ((Integer)c.ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
        if (i > 1) {
          break label360;
        }
        AppMethodBeat.o(31439);
        return;
        if (g.EMF.equals(paramString1.field_appId))
        {
          parama.ka.setImageResource(2131691010);
          break;
        }
        if (g.EME.equals(paramString1.field_appId))
        {
          parama.ka.setImageResource(2131691004);
          break;
        }
        if (g.EMG.equals(paramString1.field_appId))
        {
          parama.ka.setImageResource(2131691002);
          break;
        }
        parama.ka.setImageResource(2131231048);
        break;
        label338:
        parama.umK.setText(h.a(AppGrid.h(AppGrid.this), paramString1, null));
      }
      label360:
      ba.aBQ();
      if (!bt.U(((String)c.ajl().get(al.a.Ixy, "")).split(";")).contains(String.valueOf(i))) {
        parama.EXt.setVisibility(0);
      }
      AppMethodBeat.o(31439);
      return;
      label416:
      if (g.EMF.equals(paramString1.field_appId))
      {
        ba.aBQ();
        i = ((Integer)c.ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
        if (i <= 1)
        {
          parama.EXt.setVisibility(8);
          AppMethodBeat.o(31439);
          return;
        }
        ba.aBQ();
        if (!bt.U(((String)c.ajl().get(al.a.Ixz, "")).split(";")).contains(String.valueOf(i))) {
          parama.EXt.setVisibility(0);
        }
      }
      AppMethodBeat.o(31439);
    }
    
    public final g SK(int paramInt)
    {
      AppMethodBeat.i(31437);
      if (((paramInt < AppGrid.g(AppGrid.this)) && (AppGrid.a(AppGrid.this) == 0)) || (AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt < AppGrid.g(AppGrid.this)) || (paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) >= this.iHw.size()))
      {
        AppMethodBeat.o(31437);
        return null;
      }
      paramInt = paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this);
      ad.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[] { Integer.valueOf(paramInt) });
      g localg = (g)this.iHw.get(paramInt);
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
        paramViewGroup.EXs = ((CdnImageView)paramView.findViewById(2131296846));
        paramViewGroup.EXu = paramView.findViewById(2131296848);
        paramViewGroup.umK = ((TextView)paramView.findViewById(2131296849));
        paramViewGroup.iDG = ((TextView)paramView.findViewById(2131296845));
        paramViewGroup.EXt = ((TextView)paramView.findViewById(2131296850));
        paramViewGroup.EXv = paramView.findViewById(2131296851);
        paramView.setTag(paramViewGroup);
        ad.i("MicroMsg.AppGrid", "pos:" + paramInt + " page:" + AppGrid.a(AppGrid.this));
        paramViewGroup.umK.setVisibility(0);
        if (!this.wXt) {
          break label467;
        }
        paramViewGroup.iDG.setVisibility(0);
        paramViewGroup.EXv.setVisibility(8);
        paramViewGroup.EXt.setVisibility(8);
        paramViewGroup.EXu.setVisibility(0);
        paramViewGroup.ka.setVisibility(0);
        paramViewGroup.EXs.setVisibility(8);
        localObject1 = paramViewGroup.ka.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.EXp;
        ((ViewGroup.LayoutParams)localObject1).height = this.EXp;
        paramViewGroup.ka.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        i = AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt;
        int j = AppGrid.c(AppGrid.this).Za(i);
        if (i >= AppGrid.g(AppGrid.this)) {
          break label1635;
        }
        switch (j)
        {
        }
      }
      for (;;)
      {
        localObject1 = SK(paramInt);
        if ((localObject1 != null) && (h.o((g)localObject1))) {
          paramViewGroup.EXt.setVisibility(0);
        }
        AppMethodBeat.o(31438);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label467:
        paramViewGroup.iDG.setVisibility(8);
        break label192;
        paramViewGroup.ka.setImageResource(2131691006);
        paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755742));
        continue;
        paramViewGroup.ka.setImageResource(2131691020);
        paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755758));
        label1635:
        label2150:
        try
        {
          ba.aBQ();
          if (((Boolean)c.ajl().get(67, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.EXt.setVisibility(0);
            continue;
          }
          paramViewGroup.EXt.setVisibility(8);
        }
        catch (Exception localException2) {}
        paramViewGroup.ka.setImageResource(2131691017);
        paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131760219));
        label1736:
        try
        {
          ba.aBQ();
          if (((Boolean)c.ajl().get(73, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.EXt.setVisibility(0);
            continue;
          }
          paramViewGroup.EXt.setVisibility(8);
        }
        catch (Exception localException3) {}
        if (com.tencent.mm.platformtools.ac.iPN)
        {
          paramViewGroup.ka.setImageResource(2131691014);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755756));
        }
        else
        {
          paramViewGroup.ka.setImageResource(2131691003);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755747));
          continue;
          paramViewGroup.ka.setImageResource(2131691012);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755750));
          continue;
          paramViewGroup.ka.setImageResource(2131691009);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755745));
          try
          {
            ba.aBQ();
            if (((Boolean)c.ajl().get(290817, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.EXv.setVisibility(0);
              continue;
            }
            paramViewGroup.EXv.setVisibility(8);
          }
          catch (Exception localException4) {}
          paramViewGroup.ka.setImageResource(2131691013);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755755));
          try
          {
            ba.aBQ();
            if (((Boolean)c.ajl().get(327744, Boolean.TRUE)).booleanValue())
            {
              paramViewGroup.EXv.setVisibility(0);
              continue;
            }
            paramViewGroup.EXv.setVisibility(8);
          }
          catch (Exception localException5) {}
          paramViewGroup.ka.setImageResource(2131691008);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755737));
          continue;
          paramViewGroup.ka.setImageResource(2131691018);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755762));
          try
          {
            ba.aBQ();
            if (((Boolean)c.ajl().get(54, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.EXt.setVisibility(0);
              continue;
            }
            paramViewGroup.EXt.setVisibility(8);
          }
          catch (Exception localException6) {}
          paramViewGroup.ka.setImageResource(2131691019);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755764));
          try
          {
            ba.aBQ();
            if (((Boolean)c.ajl().get(62, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.EXt.setVisibility(0);
              continue;
            }
            paramViewGroup.EXt.setVisibility(8);
          }
          catch (Exception localException7) {}
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131758379));
          try
          {
            ba.aBQ();
            boolean bool1 = ((Boolean)c.ajl().get(208899, Boolean.FALSE)).booleanValue();
            ba.aBQ();
            boolean bool2 = ((Boolean)c.ajl().get(208913, Boolean.FALSE)).booleanValue();
            if ((bool1) || (bool2))
            {
              paramViewGroup.EXt.setVisibility(0);
              if (bool2)
              {
                paramViewGroup.EXt.setText(2131755781);
                continue;
              }
              paramViewGroup.EXt.setText(2131755829);
              continue;
            }
            paramViewGroup.EXt.setVisibility(8);
          }
          catch (Exception localException8) {}
          ad.i("MicroMsg.AppGrid", "attach remittance");
          a(paramViewGroup, g.EMD, AppGrid.h(AppGrid.this).getString(2131755759));
          continue;
          ad.i("MicroMsg.AppGrid", "attach lucky money");
          a(paramViewGroup, g.EMF, AppGrid.h(AppGrid.this).getString(2131755746));
          continue;
          paramViewGroup.ka.setImageResource(2131691011);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755764));
          try
          {
            ba.aBQ();
            if (((Boolean)c.ajl().get(81, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.EXt.setVisibility(0);
              continue;
            }
            paramViewGroup.EXt.setVisibility(8);
          }
          catch (Exception localException9) {}
          paramViewGroup.ka.setImageResource(2131691005);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755741));
          try
          {
            paramViewGroup.EXv.setVisibility(8);
          }
          catch (Exception localException1) {}
          continue;
          paramViewGroup.ka.setImageResource(2131691601);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131757997));
          continue;
          a(paramViewGroup, g.EMG, null);
          continue;
          paramViewGroup.ka.setImageResource(2131691007);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755743));
          continue;
          paramViewGroup.ka.setImageResource(2131690410);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131755744));
          continue;
          paramViewGroup.ka.setImageResource(2131691467);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131756237));
          continue;
          paramViewGroup.ka.setImageResource(2131691550);
          paramViewGroup.umK.setText(AppGrid.h(AppGrid.this).getString(2131756264));
          continue;
          localException1.width = this.EXq;
          localException1.height = this.EXq;
          paramViewGroup.ka.setLayoutParams(localException1);
          Object localObject2 = SK(paramInt);
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
                  paramViewGroup.EXs.setVisibility(0);
                  if ((al.isDarkMode()) && (!bt.isNullOrNil(((a.a)localObject2).EYP))) {
                    paramViewGroup.EXs.setUrl(((a.a)localObject2).EYP);
                  }
                  break;
                }
                break;
              }
              for (;;)
              {
                paramViewGroup.umK.setText(localb.title);
                if (bt.isNullOrNil(localb.desc)) {
                  break;
                }
                paramViewGroup.iDG.setText(localb.desc);
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
                paramViewGroup.EXs.setUrl(((a.a)localObject2).iconUrl);
              }
            }
            ba.aBQ();
            if (c.isSDCardAvailable()) {
              if (((g)localObject2).field_status == 5)
              {
                h.c(((g)localObject2).field_appId, 3, com.tencent.mm.cc.a.getDensity(AppGrid.h(AppGrid.this)));
                label1958:
                if (!g.EMD.equals(((g)localObject2).field_appId)) {
                  break label2150;
                }
                paramViewGroup.ka.setImageResource(2131691015);
              }
            }
            for (;;)
            {
              paramViewGroup.umK.setText(h.a(AppGrid.h(AppGrid.this), (g)localObject2, null));
              if ((!((g)localObject2).eZR()) || (!((g)localObject2).eZS())) {
                break;
              }
              if (AppGrid.i(AppGrid.this) == null) {
                AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(aj.fkC(), 0));
              }
              if (!AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + ((g)localObject2).field_appId, true)) {
                break;
              }
              paramViewGroup.EXt.setVisibility(0);
              break;
              if (((g)localObject2).eZR())
              {
                h.c(((g)localObject2).field_appId, 4, com.tencent.mm.cc.a.getDensity(AppGrid.h(AppGrid.this)));
                break label1958;
              }
              h.c(((g)localObject2).field_appId, 1, com.tencent.mm.cc.a.getDensity(AppGrid.h(AppGrid.this)));
              break label1958;
              if (g.EMF.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.ka.setImageResource(2131691010);
              }
              else if (g.EME.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.ka.setImageResource(2131691004);
              }
              else if (g.EMG.equals(((g)localObject2).field_appId))
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
      CdnImageView EXs;
      TextView EXt;
      View EXu;
      View EXv;
      TextView iDG;
      ImageView ka;
      TextView umK;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract int Za(int paramInt);
    
    public abstract void Zb(int paramInt);
    
    public abstract void a(int paramInt, g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid
 * JD-Core Version:    0.7.0.1
 */