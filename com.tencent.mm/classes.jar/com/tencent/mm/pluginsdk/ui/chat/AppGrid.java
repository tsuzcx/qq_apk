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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AppGrid
  extends GridView
{
  private b Rhd;
  int Rhe;
  int Rhf;
  int Rhg;
  int Rhh;
  int Rhi;
  a Rhj;
  Context context;
  private SharedPreferences sp;
  AdapterView.OnItemClickListener syv;
  AdapterView.OnItemLongClickListener wKu;
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31442);
    this.Rhf = 0;
    this.Rhg = 0;
    this.syv = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).aqt(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).aiJ(paramAnonymousInt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31433);
      }
    };
    this.wKu = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).aqt(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).aiJ(paramAnonymousInt);
        paramAnonymousAdapterView.aqu(i);
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
    this.Rhf = 0;
    this.Rhg = 0;
    this.syv = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).aqt(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).aiJ(paramAnonymousInt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31433);
      }
    };
    this.wKu = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).aqt(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).aiJ(paramAnonymousInt);
        paramAnonymousAdapterView.aqu(i);
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
      parama = parama.RiH;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_TW".equals(str))
    {
      parama = parama.RiJ;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_HK".equals(str))
    {
      parama = parama.RiI;
      AppMethodBeat.o(163203);
      return parama;
    }
    parama = parama.RiK;
    AppMethodBeat.o(163203);
    return parama;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(31446);
    int i = this.Rhj.getCount();
    AppMethodBeat.o(31446);
    return i;
  }
  
  public void setOnAppSelectedListener(b paramb)
  {
    this.Rhd = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    private boolean Hfy;
    private int Rhl;
    private int Rhm;
    private Map<String, g> Rhn;
    List<g> mxJ;
    
    public a(List<g> paramList, Map<String, g> paramMap, ArrayList<a.a> paramArrayList)
    {
      AppMethodBeat.i(163201);
      this.mxJ = new ArrayList();
      this.Rhn = null;
      this.Hfy = false;
      if (paramMap == null) {}
      for (int i = -1;; i = paramMap.size())
      {
        Log.i("MicroMsg.AppGrid", "AppGridAdapter infoList size:%s ", new Object[] { Integer.valueOf(i) });
        this.mxJ.clear();
        this.mxJ.addAll(paramMap);
        Collection localCollection;
        this.mxJ.addAll(localCollection);
        this.Rhn = paramArrayList;
        this.Rhl = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramList, 56.0F);
        this.Rhm = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramList, 53.299999F);
        this$1 = localCollection.iterator();
        do
        {
          if (!AppGrid.this.hasNext()) {
            break;
          }
          paramList = AppGrid.a((a.a)AppGrid.this.next());
        } while ((paramList == null) || (Util.isNullOrNil(paramList.desc)));
        this.Hfy = true;
        AppMethodBeat.o(163201);
        return;
      }
      AppMethodBeat.o(163201);
    }
    
    private void a(a parama, String paramString1, String paramString2)
    {
      AppMethodBeat.i(31439);
      if (this.Rhn == null)
      {
        Log.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
        AppMethodBeat.o(31439);
        return;
      }
      paramString1 = (g)this.Rhn.get(paramString1);
      if (paramString1 == null)
      {
        Log.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
        AppMethodBeat.o(31439);
        return;
      }
      if (g.QWe.equals(paramString1.field_appId))
      {
        parama.bwJ.setImageResource(R.k.panel_icon_transfer);
        if (Util.isNullOrNil(paramString2)) {
          break label339;
        }
        parama.znp.setText(h.b(AppGrid.h(AppGrid.this), paramString1, paramString2));
      }
      int i;
      for (;;)
      {
        if ((paramString1.hhs()) && (paramString1.hht()))
        {
          if (AppGrid.i(AppGrid.this) == null) {
            AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
          }
          if (AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramString1.field_appId, true)) {
            parama.Rhp.setVisibility(0);
          }
        }
        if (!g.QWe.equals(paramString1.field_appId)) {
          break label417;
        }
        bh.beI();
        i = ((Integer)c.aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
        if (i > 1) {
          break label361;
        }
        AppMethodBeat.o(31439);
        return;
        if (g.QWg.equals(paramString1.field_appId))
        {
          parama.bwJ.setImageResource(R.k.panel_icon_luckymoney);
          break;
        }
        if (g.QWf.equals(paramString1.field_appId))
        {
          parama.bwJ.setImageResource(R.k.panel_icon_card);
          break;
        }
        if (g.QWh.equals(paramString1.field_appId))
        {
          parama.bwJ.setImageResource(R.k.panel_icon_aa);
          break;
        }
        parama.bwJ.setImageResource(R.g.app_panel_icon_unknowed);
        break;
        label339:
        parama.znp.setText(h.a(AppGrid.h(AppGrid.this), paramString1, null));
      }
      label361:
      bh.beI();
      if (!Util.stringsToList(((String)c.aHp().get(ar.a.VnZ, "")).split(";")).contains(String.valueOf(i))) {
        parama.Rhp.setVisibility(0);
      }
      AppMethodBeat.o(31439);
      return;
      label417:
      if (g.QWg.equals(paramString1.field_appId))
      {
        bh.beI();
        i = ((Integer)c.aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
        if (i <= 1)
        {
          parama.Rhp.setVisibility(8);
          AppMethodBeat.o(31439);
          return;
        }
        bh.beI();
        if (!Util.stringsToList(((String)c.aHp().get(ar.a.Voa, "")).split(";")).contains(String.valueOf(i))) {
          parama.Rhp.setVisibility(0);
        }
      }
      AppMethodBeat.o(31439);
    }
    
    public final g aiJ(int paramInt)
    {
      AppMethodBeat.i(31437);
      if (((paramInt < AppGrid.g(AppGrid.this)) && (AppGrid.a(AppGrid.this) == 0)) || (AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt < AppGrid.g(AppGrid.this)) || (paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) >= this.mxJ.size()))
      {
        AppMethodBeat.o(31437);
        return null;
      }
      paramInt = paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this);
      Log.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[] { Integer.valueOf(paramInt) });
      g localg = (g)this.mxJ.get(paramInt);
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
        paramView = View.inflate(AppGrid.h(AppGrid.this), R.i.ebz, null);
        paramViewGroup.bwJ = ((ImageView)paramView.findViewById(R.h.dqY));
        paramViewGroup.Rho = ((CdnImageView)paramView.findViewById(R.h.dqX));
        paramViewGroup.Rhq = paramView.findViewById(R.h.dqZ);
        paramViewGroup.znp = ((TextView)paramView.findViewById(R.h.dra));
        paramViewGroup.msF = ((TextView)paramView.findViewById(R.h.dqW));
        paramViewGroup.Rhp = ((TextView)paramView.findViewById(R.h.drb));
        paramViewGroup.Rhr = paramView.findViewById(R.h.drc);
        paramView.setTag(paramViewGroup);
        Log.i("MicroMsg.AppGrid", "pos:" + paramInt + " page:" + AppGrid.a(AppGrid.this));
        paramViewGroup.znp.setVisibility(0);
        if (!this.Hfy) {
          break label467;
        }
        paramViewGroup.msF.setVisibility(0);
        paramViewGroup.Rhr.setVisibility(8);
        paramViewGroup.Rhp.setVisibility(8);
        paramViewGroup.Rhq.setVisibility(0);
        paramViewGroup.bwJ.setVisibility(0);
        paramViewGroup.Rho.setVisibility(8);
        localObject1 = paramViewGroup.bwJ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.Rhl;
        ((ViewGroup.LayoutParams)localObject1).height = this.Rhl;
        paramViewGroup.bwJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        i = AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt;
        int j = AppGrid.c(AppGrid.this).aqt(i);
        if (i >= AppGrid.g(AppGrid.this)) {
          break label1635;
        }
        switch (j)
        {
        }
      }
      for (;;)
      {
        localObject1 = aiJ(paramInt);
        if ((localObject1 != null) && (h.p((g)localObject1))) {
          paramViewGroup.Rhp.setVisibility(0);
        }
        AppMethodBeat.o(31438);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label467:
        paramViewGroup.msF.setVisibility(8);
        break label192;
        paramViewGroup.bwJ.setImageResource(R.k.panel_icon_fav);
        paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_favorite));
        continue;
        paramViewGroup.bwJ.setImageResource(R.k.panel_icon_wxtalk);
        paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_talkroom));
        label1635:
        try
        {
          bh.beI();
          if (((Boolean)c.aHp().b(67, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.Rhp.setVisibility(0);
            continue;
          }
          paramViewGroup.Rhp.setVisibility(8);
        }
        catch (Exception localException2) {}
        paramViewGroup.bwJ.setImageResource(R.k.panel_icon_voiceinput);
        paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.eHF));
        label1736:
        label2018:
        try
        {
          bh.beI();
          if (((Boolean)c.aHp().b(73, Boolean.FALSE)).booleanValue())
          {
            paramViewGroup.Rhp.setVisibility(0);
            continue;
          }
          paramViewGroup.Rhp.setVisibility(8);
        }
        catch (Exception localException3) {}
        if (ac.mGL)
        {
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_sights);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_sight));
        }
        else
        {
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_camera);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_mmsight));
          continue;
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_pic);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_new_pic));
          continue;
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_location);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_location));
          try
          {
            bh.beI();
            if (((Boolean)c.aHp().b(290817, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.Rhr.setVisibility(0);
              continue;
            }
            paramViewGroup.Rhr.setVisibility(8);
          }
          catch (Exception localException4) {}
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_service);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_service));
          try
          {
            bh.beI();
            if (((Boolean)c.aHp().b(327744, Boolean.TRUE)).booleanValue())
            {
              paramViewGroup.Rhr.setVisibility(0);
              continue;
            }
            paramViewGroup.Rhr.setVisibility(8);
          }
          catch (Exception localException5) {}
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_friendcard);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_card));
          continue;
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_voip);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_voip));
          try
          {
            bh.beI();
            if (((Boolean)c.aHp().b(54, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.Rhp.setVisibility(0);
              continue;
            }
            paramViewGroup.Rhp.setVisibility(8);
          }
          catch (Exception localException6) {}
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_voipvoice);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_voipaudio));
          try
          {
            bh.beI();
            if (((Boolean)c.aHp().b(62, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.Rhp.setVisibility(0);
              continue;
            }
            paramViewGroup.Rhp.setVisibility(8);
          }
          catch (Exception localException7) {}
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.emoji_store_title));
          try
          {
            bh.beI();
            boolean bool1 = ((Boolean)c.aHp().b(208899, Boolean.FALSE)).booleanValue();
            bh.beI();
            boolean bool2 = ((Boolean)c.aHp().b(208913, Boolean.FALSE)).booleanValue();
            if ((bool1) || (bool2))
            {
              paramViewGroup.Rhp.setVisibility(0);
              if (bool2)
              {
                paramViewGroup.Rhp.setText(R.l.app_free);
                continue;
              }
              paramViewGroup.Rhp.setText(R.l.app_new);
              continue;
            }
            paramViewGroup.Rhp.setVisibility(8);
          }
          catch (Exception localException8) {}
          Log.i("MicroMsg.AppGrid", "attach remittance");
          a(paramViewGroup, g.QWe, AppGrid.h(AppGrid.this).getString(R.l.app_field_transfer));
          continue;
          Log.i("MicroMsg.AppGrid", "attach lucky money");
          a(paramViewGroup, g.QWg, AppGrid.h(AppGrid.this).getString(R.l.app_field_lucky_money));
          continue;
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_multitalk);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_voipaudio));
          try
          {
            bh.beI();
            if (((Boolean)c.aHp().b(81, Boolean.FALSE)).booleanValue())
            {
              paramViewGroup.Rhp.setVisibility(0);
              continue;
            }
            paramViewGroup.Rhp.setVisibility(8);
          }
          catch (Exception localException9) {}
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_enterprise);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_enterprise_brand));
          try
          {
            paramViewGroup.Rhr.setVisibility(8);
          }
          catch (Exception localException1) {}
          continue;
          paramViewGroup.bwJ.setImageResource(R.k.icons_filled_gift);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_gift));
          continue;
          a(paramViewGroup, g.QWh, null);
          continue;
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_file_explorer);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_file));
          continue;
          paramViewGroup.bwJ.setImageResource(R.k.icons_filled_grouptool);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_group_tools));
          continue;
          paramViewGroup.bwJ.setImageResource(R.k.icons_outlined_continued_form);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_group_solitaire));
          continue;
          paramViewGroup.bwJ.setImageResource(R.k.panel_icon_live);
          paramViewGroup.znp.setText(AppGrid.h(AppGrid.this).getString(R.l.app_field_live));
          continue;
          localException1.width = this.Rhm;
          localException1.height = this.Rhm;
          paramViewGroup.bwJ.setLayoutParams(localException1);
          Object localObject2 = aiJ(paramInt);
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
                  paramViewGroup.bwJ.setVisibility(8);
                  paramViewGroup.Rho.setVisibility(0);
                  if ((ar.isDarkMode()) && (!Util.isNullOrNil(((a.a)localObject2).RiL))) {
                    paramViewGroup.Rho.aO(((a.a)localObject2).RiL, com.tencent.mm.ci.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).RiM), com.tencent.mm.ci.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).RiN));
                  }
                  break;
                }
                break;
              }
              for (;;)
              {
                paramViewGroup.znp.setText(localb.title);
                if (Util.isNullOrNil(localb.desc)) {
                  break;
                }
                paramViewGroup.msF.setText(localb.desc);
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
                paramViewGroup.bwJ.setImageResource(R.k.icons_filled_health_note);
                continue;
                paramViewGroup.bwJ.setImageResource(R.k.icons_filled_live_mark);
                continue;
                paramViewGroup.Rho.aO(((a.a)localObject2).iconUrl, com.tencent.mm.ci.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).RiM), com.tencent.mm.ci.a.fromDPToPix(AppGrid.h(AppGrid.this), ((a.a)localObject2).RiN));
              }
            }
            bh.beI();
            if (c.isSDCardAvailable()) {
              if (((g)localObject2).field_status == 5)
              {
                h.c(((g)localObject2).field_appId, 3, com.tencent.mm.ci.a.getDensity(AppGrid.h(AppGrid.this)));
                if (!g.QWe.equals(((g)localObject2).field_appId)) {
                  break label2211;
                }
                paramViewGroup.bwJ.setImageResource(R.k.panel_icon_transfer);
              }
            }
            for (;;)
            {
              paramViewGroup.znp.setText(h.a(AppGrid.h(AppGrid.this), (g)localObject2, null));
              if ((!((g)localObject2).hhs()) || (!((g)localObject2).hht())) {
                break;
              }
              if (AppGrid.i(AppGrid.this) == null) {
                AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
              }
              if (!AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + ((g)localObject2).field_appId, true)) {
                break;
              }
              paramViewGroup.Rhp.setVisibility(0);
              break;
              if (((g)localObject2).hhs())
              {
                h.c(((g)localObject2).field_appId, 4, com.tencent.mm.ci.a.getDensity(AppGrid.h(AppGrid.this)));
                break label2018;
              }
              h.c(((g)localObject2).field_appId, 1, com.tencent.mm.ci.a.getDensity(AppGrid.h(AppGrid.this)));
              break label2018;
              label2211:
              if (g.QWg.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.bwJ.setImageResource(R.k.panel_icon_luckymoney);
              }
              else if (g.QWf.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.bwJ.setImageResource(R.k.panel_icon_card);
              }
              else if (g.QWh.equals(((g)localObject2).field_appId))
              {
                paramViewGroup.bwJ.setImageResource(R.k.panel_icon_aa);
              }
              else
              {
                paramViewGroup.bwJ.setBackgroundResource(R.g.app_panel_icon_unknowed);
                continue;
                paramViewGroup.bwJ.setBackgroundResource(R.g.sharemore_nosdcard_icon);
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
      CdnImageView Rho;
      TextView Rhp;
      View Rhq;
      View Rhr;
      ImageView bwJ;
      TextView msF;
      TextView znp;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, g paramg);
    
    public abstract int aqt(int paramInt);
    
    public abstract void aqu(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid
 * JD-Core Version:    0.7.0.1
 */