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
import com.tencent.mm.by.c;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoUI
  extends MMActivity
{
  private TextView GXa;
  private ListView mListView;
  
  public int getLayoutId()
  {
    return au.g.wxa_bind_biz_info_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(50065);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(50065);
      return;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(50058);
        WxaBindBizInfoUI.this.finish();
        AppMethodBeat.o(50058);
        return false;
      }
    }, au.h.actionbar_icon_dark_back);
    setMMTitle(au.i.app_brand_profile_biz_brand_belong_title);
    setActionbarColor(getActionbarColor());
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
    paramBundle = getIntent().getStringExtra("register");
    View localView = getLayoutInflater().inflate(au.g.biz_bind_wxa_info_header, null);
    this.GXa = ((TextView)localView.findViewById(au.f.titleTv));
    TextView localTextView = this.GXa;
    if (Util.isNullOrNil(paramBundle)) {
      paramBundle = getString(au.i.app_brand_profile_biz_brand_belong_title);
    }
    for (;;)
    {
      localTextView.setText(paramBundle);
      this.mListView = ((ListView)findViewById(au.f.dataLv));
      this.mListView.addHeaderView(localView);
      this.mListView.setAdapter(new a(getLayoutInflater(), localArrayList));
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(50059);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/WxaBindBizInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          paramAnonymousAdapterView = (WxaAttributes.WxaEntryInfo)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindBizInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(50059);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.username);
          paramAnonymousView.putExtra("key_start_biz_profile_from_app_brand_profile", true);
          paramAnonymousView.putExtra("key_use_new_contact_profile", true);
          paramAnonymousView.putExtra("force_get_contact", true);
          c.b(WxaBindBizInfoUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindBizInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(50059);
        }
      });
      getContentView().setBackgroundResource(au.c.settings_bg);
      AppMethodBeat.o(50065);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    private LayoutInflater mInflater;
    private List<WxaAttributes.WxaEntryInfo> rEV;
    
    public a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
    {
      AppMethodBeat.i(50060);
      this.mInflater = paramLayoutInflater;
      this.rEV = new LinkedList();
      if (paramList != null) {
        this.rEV.addAll(paramList);
      }
      AppMethodBeat.o(50060);
    }
    
    private WxaAttributes.WxaEntryInfo abl(int paramInt)
    {
      AppMethodBeat.i(50062);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.rEV.get(paramInt);
      AppMethodBeat.o(50062);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50061);
      int i = this.rEV.size();
      AppMethodBeat.o(50061);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(50063);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo;
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(au.g.app_brand_profile_bind_list_item, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.jmf = ((ImageView)paramView.findViewById(au.f.icon));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(au.f.primary_text));
        paramViewGroup.kEs = ((TextView)paramView.findViewById(au.f.secondary_text));
        paramViewGroup.mND = paramView.findViewById(au.f.divider);
        paramView.setTag(paramViewGroup);
        localWxaEntryInfo = abl(paramInt);
        com.tencent.mm.modelappbrand.a.b.bhh().a(paramViewGroup.jmf, localWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.bhg(), g.lzF);
        paramViewGroup.titleTv.setText(Util.nullAsNil(localWxaEntryInfo.title));
        if (!Util.isNullOrNil(localWxaEntryInfo.obt)) {
          break label206;
        }
        paramViewGroup.kEs.setVisibility(8);
        label153:
        if (this.rEV != null)
        {
          paramViewGroup = paramViewGroup.mND;
          if (this.rEV.size() - 1 != paramInt) {
            break label229;
          }
        }
      }
      label206:
      label229:
      for (paramInt = 8;; paramInt = 0)
      {
        paramViewGroup.setVisibility(paramInt);
        AppMethodBeat.o(50063);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.kEs.setVisibility(0);
        paramViewGroup.kEs.setText(localWxaEntryInfo.obt);
        break label153;
      }
    }
    
    static final class a
    {
      ImageView jmf;
      TextView kEs;
      View mND;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI
 * JD-Core Version:    0.7.0.1
 */