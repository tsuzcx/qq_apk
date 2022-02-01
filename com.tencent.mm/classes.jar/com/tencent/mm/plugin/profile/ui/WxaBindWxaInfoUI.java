package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.profile.model.WxaRegisterInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class WxaBindWxaInfoUI
  extends MMActivity
{
  private ListView mListView;
  
  public final int getLayoutId()
  {
    return au.g.wxa_bind_wxa_info_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(50073);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(50073);
      return;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(50066);
        WxaBindWxaInfoUI.this.finish();
        AppMethodBeat.o(50066);
        return false;
      }
    });
    setMMTitle(au.i.app_brand_profile_related_wxa);
    setActionbarColor(getActionbarColor());
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("register"));
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("wxa_register_info_list");
    View localView = getLayoutInflater().inflate(au.g.wxa_bind_wxa_info_footer, null);
    ((TextView)localView.findViewById(au.f.titleTv)).setText(getString(au.i.app_brand_profile_related_wxa_hint, new Object[] { paramBundle }));
    this.mListView = ((ListView)findViewById(au.f.dataLv));
    this.mListView.addFooterView(localView);
    this.mListView.setAdapter(new b(getLayoutInflater(), localArrayList));
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(50067);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousAdapterView = (WxaBindWxaInfoUI.a)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (1 != paramAnonymousAdapterView.type))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(50067);
          return;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.Hdm;
        paramAnonymousView = (r)h.ae(r.class);
        if (paramAnonymousView != null)
        {
          localObject = new AppBrandStatObject();
          ((AppBrandStatObject)localObject).scene = 1135;
          paramAnonymousView.a(WxaBindWxaInfoUI.this.getContext(), paramAnonymousAdapterView.username, null, 0, -1, null, (AppBrandStatObject)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(50067);
      }
    });
    getContentView().setBackgroundResource(au.c.settings_bg);
    AppMethodBeat.o(50073);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    public final String GWR;
    public final WxaAttributes.WxaEntryInfo Hdm;
    public final boolean Hdn;
    public final int type;
    
    private a(int paramInt, String paramString, WxaAttributes.WxaEntryInfo paramWxaEntryInfo, boolean paramBoolean)
    {
      this.type = paramInt;
      this.GWR = paramString;
      this.Hdm = paramWxaEntryInfo;
      this.Hdn = paramBoolean;
    }
    
    public static List<a> gx(List<WxaRegisterInfo> paramList)
    {
      AppMethodBeat.i(277476);
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WxaRegisterInfo localWxaRegisterInfo = (WxaRegisterInfo)paramList.next();
        if (localWxaRegisterInfo != null)
        {
          int i;
          label64:
          label86:
          label92:
          WxaAttributes.WxaEntryInfo localWxaEntryInfo;
          if (((CharSequence)localWxaRegisterInfo.GWR).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label199;
            }
            if (((Collection)localWxaRegisterInfo.GWS).isEmpty()) {
              break label194;
            }
            i = 1;
            if (i == 0) {
              break label199;
            }
            i = 1;
            if (i == 0) {
              break label202;
            }
            localArrayList.add(new a(0, localWxaRegisterInfo.GWR, null, false));
            int j = localWxaRegisterInfo.GWS.size();
            i = 0;
            label132:
            if (i < j)
            {
              localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)localWxaRegisterInfo.GWS.get(i);
              if (i != j - 1) {
                break label204;
              }
            }
          }
          label194:
          label199:
          label202:
          label204:
          for (boolean bool = true;; bool = false)
          {
            localArrayList.add(new a(1, null, localWxaEntryInfo, bool));
            i += 1;
            break label132;
            break;
            i = 0;
            break label64;
            i = 0;
            break label86;
            i = 0;
            break label92;
            break;
          }
        }
      }
      AppMethodBeat.o(277476);
      return localArrayList;
    }
  }
  
  static final class b
    extends BaseAdapter
  {
    private LayoutInflater mInflater;
    private List<WxaBindWxaInfoUI.a> rEV;
    
    public b(LayoutInflater paramLayoutInflater, List<WxaRegisterInfo> paramList)
    {
      AppMethodBeat.i(50068);
      this.mInflater = paramLayoutInflater;
      this.rEV = WxaBindWxaInfoUI.a.gx(paramList);
      AppMethodBeat.o(50068);
    }
    
    private WxaBindWxaInfoUI.a abx(int paramInt)
    {
      AppMethodBeat.i(251959);
      WxaBindWxaInfoUI.a locala = (WxaBindWxaInfoUI.a)this.rEV.get(paramInt);
      AppMethodBeat.o(251959);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50069);
      int i = this.rEV.size();
      AppMethodBeat.o(50069);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(251962);
      paramInt = abx(paramInt).type;
      AppMethodBeat.o(251962);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(50071);
      WxaBindWxaInfoUI.a locala = abx(paramInt);
      Object localObject;
      if (1 == locala.type)
      {
        if ((paramView == null) || (!(paramView.getTag() instanceof b)))
        {
          paramView = this.mInflater.inflate(au.g.app_brand_profile_bind_list_item, paramViewGroup, false);
          paramViewGroup = new b((byte)0);
          paramViewGroup.jmf = ((ImageView)paramView.findViewById(au.f.icon));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(au.f.primary_text));
          paramViewGroup.kEs = ((TextView)paramView.findViewById(au.f.secondary_text));
          paramViewGroup.mND = paramView.findViewById(au.f.divider);
          paramView.setTag(paramViewGroup);
          localObject = locala.Hdm;
          com.tencent.mm.modelappbrand.a.b.bhh().a(paramViewGroup.jmf, ((WxaAttributes.WxaEntryInfo)localObject).iconUrl, com.tencent.mm.modelappbrand.a.a.bhg(), g.lzF);
          paramViewGroup.titleTv.setText(Util.nullAsNil(((WxaAttributes.WxaEntryInfo)localObject).title));
          if (!Util.isNullOrNil(((WxaAttributes.WxaEntryInfo)localObject).obt)) {
            break label231;
          }
          paramViewGroup.kEs.setVisibility(4);
          label178:
          localObject = paramView;
          if (this.rEV != null)
          {
            paramViewGroup = paramViewGroup.mND;
            if (!locala.Hdn) {
              break label254;
            }
          }
        }
        label231:
        label254:
        for (paramInt = 8;; paramInt = 0)
        {
          paramViewGroup.setVisibility(paramInt);
          localObject = paramView;
          AppMethodBeat.o(50071);
          return localObject;
          paramViewGroup = (b)paramView.getTag();
          break;
          paramViewGroup.kEs.setVisibility(0);
          paramViewGroup.kEs.setText(((WxaAttributes.WxaEntryInfo)localObject).obt);
          break label178;
        }
      }
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        paramView = this.mInflater.inflate(au.g.wxa_bind_wxa_info_header, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(au.f.titleTv));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = locala.GWR;
        paramViewGroup.titleTv.setText((CharSequence)localObject);
        localObject = paramView;
        break;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    static final class a
    {
      TextView titleTv;
    }
    
    static final class b
    {
      ImageView jmf;
      TextView kEs;
      View mND;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */