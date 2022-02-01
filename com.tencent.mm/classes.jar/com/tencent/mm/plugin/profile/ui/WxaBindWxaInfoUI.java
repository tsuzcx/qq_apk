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

public final class WxaBindWxaInfoUI
  extends MMActivity
{
  private ListView mListView;
  private TextView uzE;
  
  public final int getLayoutId()
  {
    return 2131496116;
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
    setMMTitle(2131755600);
    setActionbarColor(getActionbarColor());
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
    paramBundle = getIntent().getStringExtra("register");
    View localView = getLayoutInflater().inflate(2131496115, null);
    this.uzE = ((TextView)localView.findViewById(2131305906));
    TextView localTextView = this.uzE;
    if (bt.isNullOrNil(paramBundle)) {
      paramBundle = getString(2131755600);
    }
    for (;;)
    {
      localTextView.setText(paramBundle);
      this.mListView = ((ListView)findViewById(2131298924));
      this.mListView.addHeaderView(localView);
      this.mListView.setAdapter(new a(getLayoutInflater(), localArrayList));
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(50067);
          paramAnonymousAdapterView = (WxaAttributes.WxaEntryInfo)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(50067);
            return;
          }
          paramAnonymousView = (n)com.tencent.mm.kernel.g.ab(n.class);
          if (paramAnonymousView != null)
          {
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1135;
            paramAnonymousView.a(WxaBindWxaInfoUI.this.getContext(), paramAnonymousAdapterView.username, null, 0, -1, null, localAppBrandStatObject);
          }
          AppMethodBeat.o(50067);
        }
      });
      getContentView().setBackgroundResource(2131100860);
      AppMethodBeat.o(50073);
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
      AppMethodBeat.i(50068);
      this.mInflater = paramLayoutInflater;
      this.lWb = new LinkedList();
      if (paramList != null) {
        this.lWb.addAll(paramList);
      }
      AppMethodBeat.o(50068);
    }
    
    private WxaAttributes.WxaEntryInfo Jf(int paramInt)
    {
      AppMethodBeat.i(50070);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.lWb.get(paramInt);
      AppMethodBeat.o(50070);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50069);
      int i = this.lWb.size();
      AppMethodBeat.o(50069);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(50071);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo;
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(2131493027, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.fxT = ((ImageView)paramView.findViewById(2131300874));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131303405));
        paramViewGroup.lEA = ((TextView)paramView.findViewById(2131304468));
        paramViewGroup.icB = paramView.findViewById(2131299154);
        paramView.setTag(paramViewGroup);
        localWxaEntryInfo = Jf(paramInt);
        b.aub().a(paramViewGroup.fxT, localWxaEntryInfo.iconUrl, a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
        paramViewGroup.titleTv.setText(bt.nullAsNil(localWxaEntryInfo.title));
        if (!bt.isNullOrNil(localWxaEntryInfo.jfu)) {
          break label201;
        }
        paramViewGroup.lEA.setVisibility(8);
        label148:
        if (this.lWb != null)
        {
          paramViewGroup = paramViewGroup.icB;
          if (this.lWb.size() - 1 != paramInt) {
            break label224;
          }
        }
      }
      label201:
      label224:
      for (paramInt = 8;; paramInt = 0)
      {
        paramViewGroup.setVisibility(paramInt);
        AppMethodBeat.o(50071);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.lEA.setVisibility(0);
        paramViewGroup.lEA.setText(localWxaEntryInfo.jfu);
        break label148;
      }
    }
    
    static final class a
    {
      ImageView fxT;
      View icB;
      TextView lEA;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */