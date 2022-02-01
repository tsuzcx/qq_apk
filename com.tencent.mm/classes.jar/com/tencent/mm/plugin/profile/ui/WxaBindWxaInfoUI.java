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
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class WxaBindWxaInfoUI
  extends MMActivity
{
  private ListView mListView;
  private TextView xfv;
  
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
    this.xfv = ((TextView)localView.findViewById(2131305906));
    TextView localTextView = this.xfv;
    if (bu.isNullOrNil(paramBundle)) {
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
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousAdapterView = (WxaAttributes.WxaEntryInfo)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(50067);
            return;
          }
          paramAnonymousView = (p)com.tencent.mm.kernel.g.ab(p.class);
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
    private LayoutInflater mInflater;
    private List<WxaAttributes.WxaEntryInfo> ndS;
    
    public a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
    {
      AppMethodBeat.i(50068);
      this.mInflater = paramLayoutInflater;
      this.ndS = new LinkedList();
      if (paramList != null) {
        this.ndS.addAll(paramList);
      }
      AppMethodBeat.o(50068);
    }
    
    private WxaAttributes.WxaEntryInfo Nm(int paramInt)
    {
      AppMethodBeat.i(50070);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.ndS.get(paramInt);
      AppMethodBeat.o(50070);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50069);
      int i = this.ndS.size();
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
        paramViewGroup.fWT = ((ImageView)paramView.findViewById(2131300874));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131303405));
        paramViewGroup.gXb = ((TextView)paramView.findViewById(2131304468));
        paramViewGroup.iYM = paramView.findViewById(2131299154);
        paramView.setTag(paramViewGroup);
        localWxaEntryInfo = Nm(paramInt);
        com.tencent.mm.modelappbrand.a.b.aEl().a(paramViewGroup.fWT, localWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
        paramViewGroup.titleTv.setText(bu.nullAsNil(localWxaEntryInfo.title));
        if (!bu.isNullOrNil(localWxaEntryInfo.kdj)) {
          break label201;
        }
        paramViewGroup.gXb.setVisibility(8);
        label148:
        if (this.ndS != null)
        {
          paramViewGroup = paramViewGroup.iYM;
          if (this.ndS.size() - 1 != paramInt) {
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
        paramViewGroup.gXb.setVisibility(0);
        paramViewGroup.gXb.setText(localWxaEntryInfo.kdj);
        break label148;
      }
    }
    
    static final class a
    {
      ImageView fWT;
      TextView gXb;
      View iYM;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */