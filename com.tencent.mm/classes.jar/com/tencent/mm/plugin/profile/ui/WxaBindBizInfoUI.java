package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoUI
  extends MMActivity
{
  private TextView MUT;
  private ListView mListView;
  
  public int getLayoutId()
  {
    return ba.g.wxa_bind_biz_info_ui;
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
    }, ba.h.actionbar_icon_dark_back);
    setMMTitle(ba.i.app_brand_profile_biz_brand_belong_title);
    setActionbarColor(getActionbarColor());
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
    paramBundle = getIntent().getStringExtra("register");
    View localView = getLayoutInflater().inflate(ba.g.biz_bind_wxa_info_header, null);
    localView.setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        AppMethodBeat.i(305628);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousAccessibilityNodeInfo.setClickable(false);
        AppMethodBeat.o(305628);
      }
    });
    this.MUT = ((TextView)localView.findViewById(ba.f.titleTv));
    TextView localTextView = this.MUT;
    if (Util.isNullOrNil(paramBundle)) {
      paramBundle = getString(ba.i.app_brand_profile_biz_brand_belong_title);
    }
    for (;;)
    {
      localTextView.setText(paramBundle);
      this.mListView = ((ListView)findViewById(ba.f.dataLv));
      this.mListView.addHeaderView(localView);
      this.mListView.setAdapter(new a(getLayoutInflater(), localArrayList));
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(305633);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/WxaBindBizInfoUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = (WxaAttributes.WxaEntryInfo)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindBizInfoUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(305633);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.username);
          paramAnonymousView.putExtra("key_start_biz_profile_from_app_brand_profile", true);
          paramAnonymousView.putExtra("key_use_new_contact_profile", true);
          paramAnonymousView.putExtra("force_get_contact", true);
          c.b(WxaBindBizInfoUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindBizInfoUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(305633);
        }
      });
      getContentView().setBackgroundResource(ba.c.settings_bg);
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
    private List<WxaAttributes.WxaEntryInfo> uQh;
    
    public a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
    {
      AppMethodBeat.i(50060);
      this.mInflater = paramLayoutInflater;
      this.uQh = new LinkedList();
      if (paramList != null) {
        this.uQh.addAll(paramList);
      }
      AppMethodBeat.o(50060);
    }
    
    private WxaAttributes.WxaEntryInfo afE(int paramInt)
    {
      AppMethodBeat.i(50062);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.uQh.get(paramInt);
      AppMethodBeat.o(50062);
      return localWxaEntryInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50061);
      int i = this.uQh.size();
      AppMethodBeat.o(50061);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 8;
      AppMethodBeat.i(50063);
      Object localObject;
      String str;
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(ba.g.app_brand_profile_bind_list_item, paramViewGroup, false);
        paramViewGroup = new b((byte)0);
        paramViewGroup.lPb = ((ImageView)paramView.findViewById(ba.f.icon));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(ba.f.primary_text));
        paramViewGroup.descTv = ((TextView)paramView.findViewById(ba.f.secondary_text));
        paramViewGroup.pKl = paramView.findViewById(ba.f.divider);
        paramView.setAccessibilityDelegate(paramViewGroup.Nby);
        paramView.setTag(paramViewGroup);
        localObject = afE(paramInt);
        com.tencent.mm.modelappbrand.a.b.bEY().a(paramViewGroup.lPb, ((WxaAttributes.WxaEntryInfo)localObject).iconUrl, com.tencent.mm.modelappbrand.a.a.bEX(), g.org);
        str = Util.nullAsNil(((WxaAttributes.WxaEntryInfo)localObject).title);
        paramViewGroup.titleTv.setText(str);
        localObject = ((WxaAttributes.WxaEntryInfo)localObject).rcg;
        if (!Util.isNullOrNil((String)localObject)) {
          break label237;
        }
        paramViewGroup.descTv.setVisibility(8);
        label173:
        if (this.uQh != null)
        {
          localObject = paramViewGroup.pKl;
          if (this.uQh.size() - 1 != paramInt) {
            break label284;
          }
        }
      }
      label284:
      for (paramInt = i;; paramInt = 0)
      {
        ((View)localObject).setVisibility(paramInt);
        paramViewGroup.Nby.contentDescription = str;
        AppMethodBeat.o(50063);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        label237:
        paramViewGroup.descTv.setVisibility(0);
        paramViewGroup.descTv.setText((CharSequence)localObject);
        str = str + ", " + (String)localObject;
        break label173;
      }
    }
    
    static final class a
      extends View.AccessibilityDelegate
    {
      public String contentDescription = null;
      
      public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
      {
        AppMethodBeat.i(305480);
        super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
        paramAccessibilityNodeInfo.setContentDescription(this.contentDescription);
        paramAccessibilityNodeInfo.setClassName(Button.class.getName());
        paramAccessibilityNodeInfo.setFocusable(true);
        paramAccessibilityNodeInfo.setClickable(true);
        AppMethodBeat.o(305480);
      }
    }
    
    static final class b
    {
      public final WxaBindBizInfoUI.a.a Nby;
      TextView descTv;
      ImageView lPb;
      View pKl;
      TextView titleTv;
      
      private b()
      {
        AppMethodBeat.i(305470);
        this.Nby = new WxaBindBizInfoUI.a.a((byte)0);
        AppMethodBeat.o(305470);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI
 * JD-Core Version:    0.7.0.1
 */