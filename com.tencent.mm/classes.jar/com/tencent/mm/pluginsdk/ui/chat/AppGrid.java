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
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AppGrid
  extends GridView
{
  private b Kgs;
  int Kgt;
  int Kgu;
  int Kgv;
  int Kgw;
  int Kgx;
  a Kgy;
  Context context;
  AdapterView.OnItemClickListener ppw;
  private SharedPreferences sp;
  AdapterView.OnItemLongClickListener tej;
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31442);
    this.Kgu = 0;
    this.Kgv = 0;
    this.ppw = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).air(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).abn(paramAnonymousInt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31433);
      }
    };
    this.tej = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).air(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).abn(paramAnonymousInt);
        paramAnonymousAdapterView.ais(i);
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
    this.Kgu = 0;
    this.Kgv = 0;
    this.ppw = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).air(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).abn(paramAnonymousInt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31433);
      }
    };
    this.tej = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).air(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).abn(paramAnonymousInt);
        paramAnonymousAdapterView.ais(i);
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
    String str = LocaleUtil.getApplicationLanguage();
    if ("zh_CN".equals(str))
    {
      parama = parama.KhX;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_TW".equals(str))
    {
      parama = parama.KhZ;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_HK".equals(str))
    {
      parama = parama.KhY;
      AppMethodBeat.o(163203);
      return parama;
    }
    parama = parama.Kia;
    AppMethodBeat.o(163203);
    return parama;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(31446);
    int i = this.Kgy.getCount();
    AppMethodBeat.o(31446);
    return i;
  }
  
  public void setOnAppSelectedListener(b paramb)
  {
    this.Kgs = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    private boolean Blm;
    private int KgA;
    private int KgB;
    private Map<String, g> KgC;
    List<g> jGV;
    
    public a(List<g> paramList, Map<String, g> paramMap, ArrayList<a.a> paramArrayList)
    {
      AppMethodBeat.i(163201);
      this.jGV = new ArrayList();
      this.KgC = null;
      this.Blm = false;
      if (paramMap == null) {}
      for (int i = -1;; i = paramMap.size())
      {
        Log.i("MicroMsg.AppGrid", "AppGridAdapter infoList size:%s ", new Object[] { Integer.valueOf(i) });
        this.jGV.clear();
        this.jGV.addAll(paramMap);
        Collection localCollection;
        this.jGV.addAll(localCollection);
        this.KgC = paramArrayList;
        this.KgA = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramList, 56.0F);
        this.KgB = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramList, 53.299999F);
        this$1 = localCollection.iterator();
        do
        {
          if (!AppGrid.this.hasNext()) {
            break;
          }
          paramList = AppGrid.a((a.a)AppGrid.this.next());
        } while ((paramList == null) || (Util.isNullOrNil(paramList.desc)));
        this.Blm = true;
        AppMethodBeat.o(163201);
        return;
      }
      AppMethodBeat.o(163201);
    }
    
    private void a(a parama, String paramString1, String paramString2)
    {
      AppMethodBeat.i(31439);
      if (this.KgC == null)
      {
        Log.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
        AppMethodBeat.o(31439);
        return;
      }
      paramString1 = (g)this.KgC.get(paramString1);
      if (paramString1 == null)
      {
        Log.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
        AppMethodBeat.o(31439);
        return;
      }
      if (g.JVR.equals(paramString1.field_appId))
      {
        parama.kc.setImageResource(2131691314);
        if (Util.isNullOrNil(paramString2)) {
          break label338;
        }
        parama.uGh.setText(h.b(AppGrid.h(AppGrid.this), paramString1, paramString2));
      }
      int i;
      for (;;)
      {
        if ((paramString1.gmR()) && (paramString1.gmS()))
        {
          if (AppGrid.i(AppGrid.this) == null) {
            AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
          }
          if (AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramString1.field_appId, true)) {
            parama.KgE.setVisibility(0);
          }
        }
        if (!g.JVR.equals(paramString1.field_appId)) {
          break label416;
        }
        bg.aVF();
        i = ((Integer)c.azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
        if (i > 1) {
          break label360;
        }
        AppMethodBeat.o(31439);
        return;
        if (g.JVT.equals(paramString1.field_appId))
        {
          parama.kc.setImageResource(2131691309);
          break;
        }
        if (g.JVS.equals(paramString1.field_appId))
        {
          parama.kc.setImageResource(2131691302);
          break;
        }
        if (g.JVU.equals(paramString1.field_appId))
        {
          parama.kc.setImageResource(2131691300);
          break;
        }
        parama.kc.setImageResource(2131231081);
        break;
        label338:
        parama.uGh.setText(h.a(AppGrid.h(AppGrid.this), paramString1, null));
      }
      label360:
      bg.aVF();
      if (!Util.stringsToList(((String)c.azQ().get(ar.a.NZY, "")).split(";")).contains(String.valueOf(i))) {
        parama.KgE.setVisibility(0);
      }
      AppMethodBeat.o(31439);
      return;
      label416:
      if (g.JVT.equals(paramString1.field_appId))
      {
        bg.aVF();
        i = ((Integer)c.azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
        if (i <= 1)
        {
          parama.KgE.setVisibility(8);
          AppMethodBeat.o(31439);
          return;
        }
        bg.aVF();
        if (!Util.stringsToList(((String)c.azQ().get(ar.a.NZZ, "")).split(";")).contains(String.valueOf(i))) {
          parama.KgE.setVisibility(0);
        }
      }
      AppMethodBeat.o(31439);
    }
    
    public final g abn(int paramInt)
    {
      AppMethodBeat.i(31437);
      if (((paramInt < AppGrid.g(AppGrid.this)) && (AppGrid.a(AppGrid.this) == 0)) || (AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt < AppGrid.g(AppGrid.this)) || (paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) >= this.jGV.size()))
      {
        AppMethodBeat.o(31437);
        return null;
      }
      paramInt = paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this);
      Log.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[] { Integer.valueOf(paramInt) });
      g localg = (g)this.jGV.get(paramInt);
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
        paramView = View.inflate(AppGrid.h(AppGrid.this), 2131493125, null);
        paramViewGroup.kc = ((ImageView)paramView.findViewById(2131296939));
        paramViewGroup.KgD = ((CdnImageView)paramView.findViewById(2131296938));
        paramViewGroup.KgF = paramView.findViewById(2131296940);
        paramViewGroup.uGh = ((TextView)paramView.findViewById(2131296941));
        paramViewGroup.jCB = ((TextView)paramView.findViewById(2131296937));
        paramViewGroup.KgE = ((TextView)paramView.findViewById(2131296942));
        paramViewGroup.KgG = paramView.findViewById(2131296943);
        paramView.setTag(paramViewGroup);
        Log.i("MicroMsg.AppGrid", "pos:" + paramInt + " page:" + AppGrid.a(AppGrid.this));
        paramViewGroup.uGh.setVisibility(0);
        if (!this.Blm) {
          break label467;
        }
        paramViewGroup.jCB.setVisibility(0);
        paramViewGroup.KgG.setVisibility(8);
        paramViewGroup.KgE.setVisibility(8);
        paramViewGroup.KgF.setVisibility(0);
        paramViewGroup.kc.setVisibility(0);
        paramViewGroup.KgD.setVisibility(8);
        localObject1 = paramViewGroup.kc.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.KgA;
        ((ViewGroup.LayoutParams)localObject1).height = this.KgA;
        paramViewGroup.kc.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        i = AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt;
        int j = AppGrid.c(AppGrid.this).air(i);
        if (i >= AppGrid.g(AppGrid.this)) {
          break label1635;
        }
        switch (j)
        {
        }
      }
      for (;;)
      {
        localObject1 = abn(paramInt);
        if ((localObject1 != null) && (h.p((g)localObject1))) {
          paramViewGroup.KgE.setVisibility(0);
        }
        AppMethodBeat.o(31438);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label467:
        paramViewGroup.jCB.setVisibility(8);
        break label192;
        paramViewGroup.kc.setImageResource(2131691304);
        paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755814));
        continue;
        paramViewGroup.kc.setImageResource(2131691319);
        paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755835));
        label1635:
        try
        {
          bg.aVF();
          if (((Boolean)c.azQ().get(67, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.KgE.setVisibility(0);
            continue;
          }
          paramViewGroup.KgE.setVisibility(8);
        }
        catch (Exception localException2) {}
        paramViewGroup.kc.setImageResource(2131691316);
        paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131761605));
        label1736:
        label2018:
        try
        {
          bg.aVF();
          if (((Boolean)c.azQ().get(73, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.KgE.setVisibility(0);
            continue;
          }
          paramViewGroup.KgE.setVisibility(8);
        }
        catch (Exception localException3) {}
        if (ac.jPB)
        {
          paramViewGroup.kc.setImageResource(2131691313);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755833));
        }
        else
        {
          paramViewGroup.kc.setImageResource(2131691301);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755822));
          continue;
          paramViewGroup.kc.setImageResource(2131691311);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755825));
          continue;
          paramViewGroup.kc.setImageResource(2131691308);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755820));
          try
          {
            bg.aVF();
            if (((Boolean)c.azQ().get(290817, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.KgG.setVisibility(0);
              continue;
            }
            paramViewGroup.KgG.setVisibility(8);
          }
          catch (Exception localException4) {}
          paramViewGroup.kc.setImageResource(2131691312);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755832));
          try
          {
            bg.aVF();
            if (((Boolean)c.azQ().get(327744, Boolean.TRUE)).booleanValue())
            {
              paramViewGroup.KgG.setVisibility(0);
              continue;
            }
            paramViewGroup.KgG.setVisibility(8);
          }
          catch (Exception localException5) {}
          paramViewGroup.kc.setImageResource(2131691306);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755809));
          continue;
          paramViewGroup.kc.setImageResource(2131691317);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755840));
          try
          {
            bg.aVF();
            if (((Boolean)c.azQ().get(54, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.KgE.setVisibility(0);
              continue;
            }
            paramViewGroup.KgE.setVisibility(8);
          }
          catch (Exception localException6) {}
          paramViewGroup.kc.setImageResource(2131691318);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755842));
          try
          {
            bg.aVF();
            if (((Boolean)c.azQ().get(62, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.KgE.setVisibility(0);
              continue;
            }
            paramViewGroup.KgE.setVisibility(8);
          }
          catch (Exception localException7) {}
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131758673));
          try
          {
            bg.aVF();
            boolean bool1 = ((Boolean)c.azQ().get(208899, Boolean.FALSE)).booleanValue();
            bg.aVF();
            boolean bool2 = ((Boolean)c.azQ().get(208913, Boolean.FALSE)).booleanValue();
            if ((bool1) || (bool2))
            {
              paramViewGroup.KgE.setVisibility(0);
              if (bool2)
              {
                paramViewGroup.KgE.setText(2131755860);
                continue;
              }
              paramViewGroup.KgE.setText(2131755915);
              continue;
            }
            paramViewGroup.KgE.setVisibility(8);
          }
          catch (Exception localException8) {}
          Log.i("MicroMsg.AppGrid", "attach remittance");
          a(paramViewGroup, g.JVR, AppGrid.h(AppGrid.this).getString(2131755836));
          continue;
          Log.i("MicroMsg.AppGrid", "attach lucky money");
          a(paramViewGroup, g.JVT, AppGrid.h(AppGrid.this).getString(2131755821));
          continue;
          paramViewGroup.kc.setImageResource(2131691310);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755842));
          try
          {
            bg.aVF();
            if (((Boolean)c.azQ().get(81, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.KgE.setVisibility(0);
              continue;
            }
            paramViewGroup.KgE.setVisibility(8);
          }
          catch (Exception localException9) {}
          paramViewGroup.kc.setImageResource(2131691303);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755813));
          try
          {
            paramViewGroup.KgG.setVisibility(8);
          }
          catch (Exception localException1) {}
          continue;
          paramViewGroup.kc.setImageResource(2131690564);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755816));
          continue;
          a(paramViewGroup, g.JVU, null);
          continue;
          paramViewGroup.kc.setImageResource(2131691305);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755815));
          continue;
          paramViewGroup.kc.setImageResource(2131690567);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755818));
          continue;
          paramViewGroup.kc.setImageResource(2131690778);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755817));
          continue;
          paramViewGroup.kc.setImageResource(2131691307);
          paramViewGroup.uGh.setText(AppGrid.h(AppGrid.this).getString(2131755819));
          continue;
          localException1.width = this.KgB;
          localException1.height = this.KgB;
          paramViewGroup.kc.setLayoutParams(localException1);
          Object localObject2 = abn(paramInt);
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
                  paramViewGroup.kc.setVisibility(8);
                  paramViewGroup.KgD.setVisibility(0);
                  if ((com.tencent.mm.ui.ao.isDarkMode()) && (!Util.isNullOrNil(((a.a)localObject2).Kib))) {
                    paramViewGroup.KgD.aM(((a.a)localObject2).Kib, com.tencent.mm.cb.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).Kic), com.tencent.mm.cb.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).Kid));
                  }
                  break;
                }
                break;
              }
              for (;;)
              {
                paramViewGroup.uGh.setText(localb.title);
                if (Util.isNullOrNil(localb.desc)) {
                  break;
                }
                paramViewGroup.jCB.setText(localb.desc);
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
                paramViewGroup.kc.setImageResource(2131690569);
                continue;
                paramViewGroup.kc.setImageResource(2131690587);
                continue;
                paramViewGroup.KgD.aM(((a.a)localObject2).iconUrl, com.tencent.mm.cb.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).Kic), com.tencent.mm.cb.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).Kid));
              }
            }
            bg.aVF();
            if (c.isSDCardAvailable()) {
              if (((g)localObject2).field_status == 5)
              {
                h.c(((g)localObject2).field_appId, 3, com.tencent.mm.cb.a.getDensity(AppGrid.h(AppGrid.this)));
                if (!g.JVR.equals(((g)localObject2).field_appId)) {
                  break label2210;
                }
                paramViewGroup.kc.setImageResource(2131691314);
              }
            }
            for (;;)
            {
              paramViewGroup.uGh.setText(h.a(AppGrid.h(AppGrid.this), (g)localObject2, null));
              if ((!((g)localObject2).gmR()) || (!((g)localObject2).gmS())) {
                break;
              }
              if (AppGrid.i(AppGrid.this) == null) {
                AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
              }
              if (!AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + ((g)localObject2).field_appId, true)) {
                break;
              }
              paramViewGroup.KgE.setVisibility(0);
              break;
              if (((g)localObject2).gmR())
              {
                h.c(((g)localObject2).field_appId, 4, com.tencent.mm.cb.a.getDensity(AppGrid.h(AppGrid.this)));
                break label2018;
              }
              h.c(((g)localObject2).field_appId, 1, com.tencent.mm.cb.a.getDensity(AppGrid.h(AppGrid.this)));
              break label2018;
              label2210:
              if (g.JVT.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.kc.setImageResource(2131691309);
              }
              else if (g.JVS.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.kc.setImageResource(2131691302);
              }
              else if (g.JVU.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.kc.setImageResource(2131691300);
              }
              else
              {
                paramViewGroup.kc.setBackgroundResource(2131231081);
                continue;
                paramViewGroup.kc.setBackgroundResource(2131234868);
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
      CdnImageView KgD;
      TextView KgE;
      View KgF;
      View KgG;
      TextView jCB;
      ImageView kc;
      TextView uGh;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, g paramg);
    
    public abstract int air(int paramInt);
    
    public abstract void ais(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid
 * JD-Core Version:    0.7.0.1
 */