package com.tencent.mm.plugin.profile.ui;

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
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BizBindWxaInfoUI
  extends MMActivity
{
  private TextView MUT;
  private ListView MUU;
  private String MUV;
  private String MUW;
  
  public final int getLayoutId()
  {
    return ba.g.biz_bind_wxa_info_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(50057);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(50057);
      return;
    }
    this.MUV = getIntent().getStringExtra("extra_username");
    this.MUW = getIntent().getStringExtra("extra_appid");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(50050);
        BizBindWxaInfoUI.this.finish();
        AppMethodBeat.o(50050);
        return false;
      }
    });
    setMMTitle(ba.i.contact_info_bind_weapp);
    setActionbarColor(getActionbarColor());
    paramBundle = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
    View localView = getLayoutInflater().inflate(ba.g.biz_bind_wxa_info_header, null);
    this.MUT = ((TextView)localView.findViewById(ba.f.titleTv));
    TextView localTextView = this.MUT;
    int j = ba.i.biz_bind_weapp_provide_service;
    if (paramBundle != null) {}
    for (int i = paramBundle.size();; i = 0)
    {
      localTextView.setText(getString(j, new Object[] { Integer.valueOf(i) }));
      this.MUU = ((ListView)findViewById(ba.f.dataLv));
      this.MUU.addHeaderView(localView);
      this.MUU.setAdapter(new a(getLayoutInflater(), paramBundle));
      this.MUU.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(50051);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = (WxaAttributes.WxaEntryInfo)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(50051);
            return;
          }
          paramAnonymousView = new AppBrandStatObject();
          paramAnonymousView.scene = 1020;
          paramAnonymousView.hzx = BizBindWxaInfoUI.a(BizBindWxaInfoUI.this);
          ((t)h.ax(t.class)).a(BizBindWxaInfoUI.this, paramAnonymousAdapterView.username, null, 0, 0, null, paramAnonymousView, BizBindWxaInfoUI.b(BizBindWxaInfoUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(50051);
        }
      });
      getContentView().setBackgroundResource(ba.c.settings_bg);
      AppMethodBeat.o(50057);
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
    private List<WxaAttributes.WxaEntryInfo> uQh;
    
    public a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
    {
      AppMethodBeat.i(50052);
      this.mInflater = paramLayoutInflater;
      this.uQh = new LinkedList();
      if (paramList != null) {
        this.uQh.addAll(paramList);
      }
      AppMethodBeat.o(50052);
    }
    
    private WxaAttributes.WxaEntryInfo afE(int paramInt)
    {
      AppMethodBeat.i(50054);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.uQh.get(paramInt);
      AppMethodBeat.o(50054);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50053);
      int i = this.uQh.size();
      AppMethodBeat.o(50053);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(50055);
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(ba.g.app_brand_launcher_recents_item_as_normal, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.lPb = ((ImageView)paramView.findViewById(ba.f.icon));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(ba.f.primary_text));
        paramViewGroup.pKl = paramView.findViewById(ba.f.divider);
        paramView.setTag(paramViewGroup);
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = afE(paramInt);
        com.tencent.mm.modelappbrand.a.b.bEY().a(paramViewGroup.lPb, localWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.bEX(), g.org);
        paramViewGroup.titleTv.setText(Util.nullAsNil(localWxaEntryInfo.title));
        if (this.uQh != null)
        {
          paramViewGroup = paramViewGroup.pKl;
          if (this.uQh.size() - 1 != paramInt) {
            break label172;
          }
        }
      }
      label172:
      for (paramInt = 8;; paramInt = 0)
      {
        paramViewGroup.setVisibility(paramInt);
        AppMethodBeat.o(50055);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    static final class a
    {
      ImageView lPb;
      View pKl;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */