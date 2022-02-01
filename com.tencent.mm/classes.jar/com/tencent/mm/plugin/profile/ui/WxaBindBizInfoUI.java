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
import com.tencent.mm.br.c;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoUI
  extends MMActivity
{
  private TextView Bdb;
  private ListView mListView;
  
  public int getLayoutId()
  {
    return 2131497105;
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
    }, 2131689492);
    setMMTitle(2131755631);
    setActionbarColor(getActionbarColor());
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
    paramBundle = getIntent().getStringExtra("register");
    View localView = getLayoutInflater().inflate(2131493236, null);
    this.Bdb = ((TextView)localView.findViewById(2131309199));
    TextView localTextView = this.Bdb;
    if (Util.isNullOrNil(paramBundle)) {
      paramBundle = getString(2131755631);
    }
    for (;;)
    {
      localTextView.setText(paramBundle);
      this.mListView = ((ListView)findViewById(2131299408));
      this.mListView.addHeaderView(localView);
      this.mListView.setAdapter(new a(getLayoutInflater(), localArrayList));
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(50059);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/WxaBindBizInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
      getContentView().setBackgroundResource(2131101059);
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
    private List<WxaAttributes.WxaEntryInfo> opg;
    
    public a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
    {
      AppMethodBeat.i(50060);
      this.mInflater = paramLayoutInflater;
      this.opg = new LinkedList();
      if (paramList != null) {
        this.opg.addAll(paramList);
      }
      AppMethodBeat.o(50060);
    }
    
    private WxaAttributes.WxaEntryInfo Uz(int paramInt)
    {
      AppMethodBeat.i(50062);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.opg.get(paramInt);
      AppMethodBeat.o(50062);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50061);
      int i = this.opg.size();
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
        paramView = this.mInflater.inflate(2131493066, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.gBZ = ((ImageView)paramView.findViewById(2131302468));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306126));
        paramViewGroup.hPW = ((TextView)paramView.findViewById(2131307446));
        paramViewGroup.jWr = paramView.findViewById(2131299682);
        paramView.setTag(paramViewGroup);
        localWxaEntryInfo = Uz(paramInt);
        com.tencent.mm.modelappbrand.a.b.aXY().a(paramViewGroup.gBZ, localWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aXX(), g.iJB);
        paramViewGroup.titleTv.setText(Util.nullAsNil(localWxaEntryInfo.title));
        if (!Util.isNullOrNil(localWxaEntryInfo.lgO)) {
          break label201;
        }
        paramViewGroup.hPW.setVisibility(8);
        label148:
        if (this.opg != null)
        {
          paramViewGroup = paramViewGroup.jWr;
          if (this.opg.size() - 1 != paramInt) {
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
        paramViewGroup.hPW.setVisibility(0);
        paramViewGroup.hPW.setText(localWxaEntryInfo.lgO);
        break label148;
      }
    }
    
    static final class a
    {
      ImageView gBZ;
      TextView hPW;
      View jWr;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI
 * JD-Core Version:    0.7.0.1
 */