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
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BizBindWxaInfoUI
  extends MMActivity
{
  private String vIA;
  private TextView vIx;
  private ListView vIy;
  private String vIz;
  
  public final int getLayoutId()
  {
    return 2131493191;
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
    this.vIz = getIntent().getStringExtra("extra_username");
    this.vIA = getIntent().getStringExtra("extra_appid");
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
    setMMTitle(2131757587);
    setActionbarColor(getActionbarColor());
    paramBundle = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
    View localView = getLayoutInflater().inflate(2131493190, null);
    this.vIx = ((TextView)localView.findViewById(2131305906));
    TextView localTextView = this.vIx;
    if (paramBundle != null) {}
    for (int i = paramBundle.size();; i = 0)
    {
      localTextView.setText(getString(2131756567, new Object[] { Integer.valueOf(i) }));
      this.vIy = ((ListView)findViewById(2131298924));
      this.vIy.addHeaderView(localView);
      this.vIy.setAdapter(new a(getLayoutInflater(), paramBundle));
      this.vIy.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(50051);
          paramAnonymousAdapterView = (WxaAttributes.WxaEntryInfo)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(50051);
            return;
          }
          paramAnonymousView = new AppBrandStatObject();
          paramAnonymousView.scene = 1020;
          paramAnonymousView.cYP = BizBindWxaInfoUI.a(BizBindWxaInfoUI.this);
          ((n)com.tencent.mm.kernel.g.ab(n.class)).a(BizBindWxaInfoUI.this, paramAnonymousAdapterView.username, null, 0, 0, null, paramAnonymousView, BizBindWxaInfoUI.b(BizBindWxaInfoUI.this));
          AppMethodBeat.o(50051);
        }
      });
      getContentView().setBackgroundResource(2131100860);
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
    private List<WxaAttributes.WxaEntryInfo> myd;
    
    public a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
    {
      AppMethodBeat.i(50052);
      this.mInflater = paramLayoutInflater;
      this.myd = new LinkedList();
      if (paramList != null) {
        this.myd.addAll(paramList);
      }
      AppMethodBeat.o(50052);
    }
    
    private WxaAttributes.WxaEntryInfo Le(int paramInt)
    {
      AppMethodBeat.i(50054);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.myd.get(paramInt);
      AppMethodBeat.o(50054);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50053);
      int i = this.myd.size();
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
        paramView = this.mInflater.inflate(2131493008, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.fBA = ((ImageView)paramView.findViewById(2131300874));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131303405));
        paramViewGroup.iCJ = paramView.findViewById(2131299154);
        paramView.setTag(paramViewGroup);
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = Le(paramInt);
        b.aAS().a(paramViewGroup.fBA, localWxaEntryInfo.iconUrl, a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
        paramViewGroup.titleTv.setText(bs.nullAsNil(localWxaEntryInfo.title));
        if (this.myd != null)
        {
          paramViewGroup = paramViewGroup.iCJ;
          if (this.myd.size() - 1 != paramInt) {
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
      ImageView fBA;
      View iCJ;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */