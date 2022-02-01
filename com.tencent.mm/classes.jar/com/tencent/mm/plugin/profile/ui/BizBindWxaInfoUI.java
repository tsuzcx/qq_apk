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
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BizBindWxaInfoUI
  extends MMActivity
{
  private TextView Bdb;
  private ListView Bdc;
  private String Bdd;
  private String Bde;
  
  public final int getLayoutId()
  {
    return 2131493237;
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
    this.Bdd = getIntent().getStringExtra("extra_username");
    this.Bde = getIntent().getStringExtra("extra_appid");
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
    setMMTitle(2131757814);
    setActionbarColor(getActionbarColor());
    paramBundle = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
    View localView = getLayoutInflater().inflate(2131493236, null);
    this.Bdb = ((TextView)localView.findViewById(2131309199));
    TextView localTextView = this.Bdb;
    if (paramBundle != null) {}
    for (int i = paramBundle.size();; i = 0)
    {
      localTextView.setText(getString(2131756703, new Object[] { Integer.valueOf(i) }));
      this.Bdc = ((ListView)findViewById(2131299408));
      this.Bdc.addHeaderView(localView);
      this.Bdc.setAdapter(new a(getLayoutInflater(), paramBundle));
      this.Bdc.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(50051);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = (WxaAttributes.WxaEntryInfo)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(50051);
            return;
          }
          paramAnonymousView = new AppBrandStatObject();
          paramAnonymousView.scene = 1020;
          paramAnonymousView.dCw = BizBindWxaInfoUI.a(BizBindWxaInfoUI.this);
          ((r)com.tencent.mm.kernel.g.af(r.class)).a(BizBindWxaInfoUI.this, paramAnonymousAdapterView.username, null, 0, 0, null, paramAnonymousView, BizBindWxaInfoUI.b(BizBindWxaInfoUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(50051);
        }
      });
      getContentView().setBackgroundResource(2131101059);
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
    private List<WxaAttributes.WxaEntryInfo> opg;
    
    public a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
    {
      AppMethodBeat.i(50052);
      this.mInflater = paramLayoutInflater;
      this.opg = new LinkedList();
      if (paramList != null) {
        this.opg.addAll(paramList);
      }
      AppMethodBeat.o(50052);
    }
    
    private WxaAttributes.WxaEntryInfo Uz(int paramInt)
    {
      AppMethodBeat.i(50054);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.opg.get(paramInt);
      AppMethodBeat.o(50054);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50053);
      int i = this.opg.size();
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
        paramView = this.mInflater.inflate(2131493046, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.gBZ = ((ImageView)paramView.findViewById(2131302468));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306126));
        paramViewGroup.jWr = paramView.findViewById(2131299682);
        paramView.setTag(paramViewGroup);
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = Uz(paramInt);
        com.tencent.mm.modelappbrand.a.b.aXY().a(paramViewGroup.gBZ, localWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
        paramViewGroup.titleTv.setText(Util.nullAsNil(localWxaEntryInfo.title));
        if (this.opg != null)
        {
          paramViewGroup = paramViewGroup.jWr;
          if (this.opg.size() - 1 != paramInt) {
            break label168;
          }
        }
      }
      label168:
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
      ImageView gBZ;
      View jWr;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */