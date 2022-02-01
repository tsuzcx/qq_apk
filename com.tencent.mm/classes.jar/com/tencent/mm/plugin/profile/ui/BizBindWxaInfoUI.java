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

public final class BizBindWxaInfoUI
  extends MMActivity
{
  private TextView xfv;
  private ListView xfw;
  private String xfx;
  private String xfy;
  
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
    this.xfx = getIntent().getStringExtra("extra_username");
    this.xfy = getIntent().getStringExtra("extra_appid");
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
    this.xfv = ((TextView)localView.findViewById(2131305906));
    TextView localTextView = this.xfv;
    if (paramBundle != null) {}
    for (int i = paramBundle.size();; i = 0)
    {
      localTextView.setText(getString(2131756567, new Object[] { Integer.valueOf(i) }));
      this.xfw = ((ListView)findViewById(2131298924));
      this.xfw.addHeaderView(localView);
      this.xfw.setAdapter(new a(getLayoutInflater(), paramBundle));
      this.xfw.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(50051);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          paramAnonymousAdapterView = (WxaAttributes.WxaEntryInfo)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(50051);
            return;
          }
          paramAnonymousView = new AppBrandStatObject();
          paramAnonymousView.scene = 1020;
          paramAnonymousView.dlj = BizBindWxaInfoUI.a(BizBindWxaInfoUI.this);
          ((p)com.tencent.mm.kernel.g.ab(p.class)).a(BizBindWxaInfoUI.this, paramAnonymousAdapterView.username, null, 0, 0, null, paramAnonymousView, BizBindWxaInfoUI.b(BizBindWxaInfoUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
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
    private List<WxaAttributes.WxaEntryInfo> ndS;
    
    public a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
    {
      AppMethodBeat.i(50052);
      this.mInflater = paramLayoutInflater;
      this.ndS = new LinkedList();
      if (paramList != null) {
        this.ndS.addAll(paramList);
      }
      AppMethodBeat.o(50052);
    }
    
    private WxaAttributes.WxaEntryInfo Nm(int paramInt)
    {
      AppMethodBeat.i(50054);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.ndS.get(paramInt);
      AppMethodBeat.o(50054);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50053);
      int i = this.ndS.size();
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
        paramViewGroup.fWT = ((ImageView)paramView.findViewById(2131300874));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131303405));
        paramViewGroup.iYM = paramView.findViewById(2131299154);
        paramView.setTag(paramViewGroup);
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = Nm(paramInt);
        com.tencent.mm.modelappbrand.a.b.aEl().a(paramViewGroup.fWT, localWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
        paramViewGroup.titleTv.setText(bu.nullAsNil(localWxaEntryInfo.title));
        if (this.ndS != null)
        {
          paramViewGroup = paramViewGroup.iYM;
          if (this.ndS.size() - 1 != paramInt) {
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
      ImageView fWT;
      View iYM;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */