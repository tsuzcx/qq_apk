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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BizBindWxaInfoUI
  extends MMActivity
{
  private TextView uzE;
  private ListView uzF;
  private String uzG;
  private String uzH;
  
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
    this.uzG = getIntent().getStringExtra("extra_username");
    this.uzH = getIntent().getStringExtra("extra_appid");
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
    this.uzE = ((TextView)localView.findViewById(2131305906));
    TextView localTextView = this.uzE;
    if (paramBundle != null) {}
    for (int i = paramBundle.size();; i = 0)
    {
      localTextView.setText(getString(2131756567, new Object[] { Integer.valueOf(i) }));
      this.uzF = ((ListView)findViewById(2131298924));
      this.uzF.addHeaderView(localView);
      this.uzF.setAdapter(new a(getLayoutInflater(), paramBundle));
      this.uzF.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
          paramAnonymousView.dbt = BizBindWxaInfoUI.a(BizBindWxaInfoUI.this);
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
    private List<WxaAttributes.WxaEntryInfo> lWb;
    private LayoutInflater mInflater;
    
    public a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
    {
      AppMethodBeat.i(50052);
      this.mInflater = paramLayoutInflater;
      this.lWb = new LinkedList();
      if (paramList != null) {
        this.lWb.addAll(paramList);
      }
      AppMethodBeat.o(50052);
    }
    
    private WxaAttributes.WxaEntryInfo Jf(int paramInt)
    {
      AppMethodBeat.i(50054);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.lWb.get(paramInt);
      AppMethodBeat.o(50054);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50053);
      int i = this.lWb.size();
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
        paramViewGroup.fxT = ((ImageView)paramView.findViewById(2131300874));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131303405));
        paramViewGroup.icB = paramView.findViewById(2131299154);
        paramView.setTag(paramViewGroup);
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = Jf(paramInt);
        b.aub().a(paramViewGroup.fxT, localWxaEntryInfo.iconUrl, a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
        paramViewGroup.titleTv.setText(bt.nullAsNil(localWxaEntryInfo.title));
        if (this.lWb != null)
        {
          paramViewGroup = paramViewGroup.icB;
          if (this.lWb.size() - 1 != paramInt) {
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
      ImageView fxT;
      View icB;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */