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
import com.tencent.mm.br.d;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoUI
  extends MMActivity
{
  private ListView mListView;
  private TextView vIx;
  
  public int getLayoutId()
  {
    return 2131496112;
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
    }, 2131689490);
    setMMTitle(2131755587);
    setActionbarColor(getActionbarColor());
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
    paramBundle = getIntent().getStringExtra("register");
    View localView = getLayoutInflater().inflate(2131493190, null);
    this.vIx = ((TextView)localView.findViewById(2131305906));
    TextView localTextView = this.vIx;
    if (bs.isNullOrNil(paramBundle)) {
      paramBundle = getString(2131755587);
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
          AppMethodBeat.i(50059);
          paramAnonymousAdapterView = (WxaAttributes.WxaEntryInfo)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(50059);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.username);
          paramAnonymousView.putExtra("key_start_biz_profile_from_app_brand_profile", true);
          paramAnonymousView.putExtra("key_use_new_contact_profile", true);
          paramAnonymousView.putExtra("force_get_contact", true);
          d.b(WxaBindBizInfoUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
          AppMethodBeat.o(50059);
        }
      });
      getContentView().setBackgroundResource(2131100860);
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
    private List<WxaAttributes.WxaEntryInfo> myd;
    
    public a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
    {
      AppMethodBeat.i(50060);
      this.mInflater = paramLayoutInflater;
      this.myd = new LinkedList();
      if (paramList != null) {
        this.myd.addAll(paramList);
      }
      AppMethodBeat.o(50060);
    }
    
    private WxaAttributes.WxaEntryInfo Le(int paramInt)
    {
      AppMethodBeat.i(50062);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.myd.get(paramInt);
      AppMethodBeat.o(50062);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50061);
      int i = this.myd.size();
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
        paramView = this.mInflater.inflate(2131493027, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.fBA = ((ImageView)paramView.findViewById(2131300874));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131303405));
        paramViewGroup.gAI = ((TextView)paramView.findViewById(2131304468));
        paramViewGroup.iCJ = paramView.findViewById(2131299154);
        paramView.setTag(paramViewGroup);
        localWxaEntryInfo = Le(paramInt);
        b.aAS().a(paramViewGroup.fBA, localWxaEntryInfo.iconUrl, a.aAR(), g.htk);
        paramViewGroup.titleTv.setText(bs.nullAsNil(localWxaEntryInfo.title));
        if (!bs.isNullOrNil(localWxaEntryInfo.jFJ)) {
          break label201;
        }
        paramViewGroup.gAI.setVisibility(8);
        label148:
        if (this.myd != null)
        {
          paramViewGroup = paramViewGroup.iCJ;
          if (this.myd.size() - 1 != paramInt) {
            break label224;
          }
        }
      }
      label201:
      label224:
      for (paramInt = 8;; paramInt = 0)
      {
        paramViewGroup.setVisibility(paramInt);
        AppMethodBeat.o(50063);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.gAI.setVisibility(0);
        paramViewGroup.gAI.setText(localWxaEntryInfo.jFJ);
        break label148;
      }
    }
    
    static final class a
    {
      ImageView fBA;
      TextView gAI;
      View iCJ;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI
 * JD-Core Version:    0.7.0.1
 */