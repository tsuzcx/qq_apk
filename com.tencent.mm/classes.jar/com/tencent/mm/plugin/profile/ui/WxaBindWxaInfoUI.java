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
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.profile.model.WxaRegisterInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class WxaBindWxaInfoUI
  extends MMActivity
{
  private ListView mListView;
  
  public final int getLayoutId()
  {
    return ba.g.wxa_bind_wxa_info_ui;
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
    setMMTitle(ba.i.app_brand_profile_related_wxa);
    setActionbarColor(getActionbarColor());
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("register"));
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("wxa_register_info_list");
    View localView = getLayoutInflater().inflate(ba.g.wxa_bind_wxa_info_footer, null);
    localView.setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        AppMethodBeat.i(305688);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousAccessibilityNodeInfo.setClickable(false);
        AppMethodBeat.o(305688);
      }
    });
    ((TextView)localView.findViewById(ba.f.titleTv)).setText(getString(ba.i.app_brand_profile_related_wxa_hint, new Object[] { paramBundle }));
    this.mListView = ((ListView)findViewById(ba.f.dataLv));
    this.mListView.addFooterView(localView);
    this.mListView.setAdapter(new b(getLayoutInflater(), localArrayList));
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(305691);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousAdapterView = (WxaBindWxaInfoUI.a)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (1 != paramAnonymousAdapterView.type))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(305691);
          return;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.NbA;
        paramAnonymousView = (t)h.ax(t.class);
        if (paramAnonymousView != null)
        {
          localObject = new AppBrandStatObject();
          ((AppBrandStatObject)localObject).scene = 1135;
          paramAnonymousView.a(WxaBindWxaInfoUI.this.getContext(), paramAnonymousAdapterView.username, null, 0, -1, null, (AppBrandStatObject)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(305691);
      }
    });
    getContentView().setBackgroundResource(ba.c.settings_bg);
    AppMethodBeat.o(50073);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    public final String MUK;
    public final WxaAttributes.WxaEntryInfo NbA;
    public final boolean NbB;
    public final int type;
    
    private a(int paramInt, String paramString, WxaAttributes.WxaEntryInfo paramWxaEntryInfo, boolean paramBoolean)
    {
      this.type = paramInt;
      this.MUK = paramString;
      this.NbA = paramWxaEntryInfo;
      this.NbB = paramBoolean;
    }
    
    public static List<a> jx(List<WxaRegisterInfo> paramList)
    {
      AppMethodBeat.i(305643);
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WxaRegisterInfo localWxaRegisterInfo = (WxaRegisterInfo)paramList.next();
        if (localWxaRegisterInfo != null)
        {
          int i;
          label64:
          label86:
          label92:
          WxaAttributes.WxaEntryInfo localWxaEntryInfo;
          if (((CharSequence)localWxaRegisterInfo.MUK).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label199;
            }
            if (((Collection)localWxaRegisterInfo.MUL).isEmpty()) {
              break label194;
            }
            i = 1;
            if (i == 0) {
              break label199;
            }
            i = 1;
            if (i == 0) {
              break label202;
            }
            localArrayList.add(new a(0, localWxaRegisterInfo.MUK, null, false));
            int j = localWxaRegisterInfo.MUL.size();
            i = 0;
            label132:
            if (i < j)
            {
              localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)localWxaRegisterInfo.MUL.get(i);
              if (i != j - 1) {
                break label204;
              }
            }
          }
          label194:
          label199:
          label202:
          label204:
          for (boolean bool = true;; bool = false)
          {
            localArrayList.add(new a(1, null, localWxaEntryInfo, bool));
            i += 1;
            break label132;
            break;
            i = 0;
            break label64;
            i = 0;
            break label86;
            i = 0;
            break label92;
            break;
          }
        }
      }
      AppMethodBeat.o(305643);
      return localArrayList;
    }
  }
  
  static final class b
    extends BaseAdapter
  {
    private LayoutInflater mInflater;
    private List<WxaBindWxaInfoUI.a> uQh;
    
    public b(LayoutInflater paramLayoutInflater, List<WxaRegisterInfo> paramList)
    {
      AppMethodBeat.i(50068);
      this.mInflater = paramLayoutInflater;
      this.uQh = WxaBindWxaInfoUI.a.jx(paramList);
      AppMethodBeat.o(50068);
    }
    
    private WxaBindWxaInfoUI.a afR(int paramInt)
    {
      AppMethodBeat.i(305641);
      WxaBindWxaInfoUI.a locala = (WxaBindWxaInfoUI.a)this.uQh.get(paramInt);
      AppMethodBeat.o(305641);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50069);
      int i = this.uQh.size();
      AppMethodBeat.o(50069);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(305646);
      paramInt = afR(paramInt).type;
      AppMethodBeat.o(305646);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 0;
      AppMethodBeat.i(50071);
      WxaBindWxaInfoUI.a locala = afR(paramInt);
      String str;
      if (1 == locala.type)
      {
        Object localObject;
        if ((paramView == null) || (!(paramView.getTag() instanceof d)))
        {
          paramView = this.mInflater.inflate(ba.g.app_brand_profile_bind_list_item, paramViewGroup, false);
          paramViewGroup = new d((byte)0);
          paramViewGroup.lPb = ((ImageView)paramView.findViewById(ba.f.icon));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(ba.f.primary_text));
          paramViewGroup.descTv = ((TextView)paramView.findViewById(ba.f.secondary_text));
          paramViewGroup.pKl = paramView.findViewById(ba.f.divider);
          paramView.setAccessibilityDelegate(paramViewGroup.NbD);
          paramView.setTag(paramViewGroup);
          localObject = locala.NbA;
          com.tencent.mm.modelappbrand.a.b.bEY().a(paramViewGroup.lPb, ((WxaAttributes.WxaEntryInfo)localObject).iconUrl, com.tencent.mm.modelappbrand.a.a.bEX(), g.org);
          str = Util.nullAsNil(((WxaAttributes.WxaEntryInfo)localObject).title);
          paramViewGroup.titleTv.setText(Util.nullAsNil(str));
          localObject = ((WxaAttributes.WxaEntryInfo)localObject).rcg;
          if (!Util.isNullOrNil((String)localObject)) {
            break label260;
          }
          paramViewGroup.descTv.setVisibility(4);
        }
        for (;;)
        {
          if (this.uQh != null)
          {
            localObject = paramViewGroup.pKl;
            paramInt = i;
            if (locala.NbB) {
              paramInt = 8;
            }
            ((View)localObject).setVisibility(paramInt);
          }
          paramViewGroup.NbD.contentDescription = str;
          AppMethodBeat.o(50071);
          return paramView;
          paramViewGroup = (d)paramView.getTag();
          break;
          label260:
          paramViewGroup.descTv.setVisibility(0);
          paramViewGroup.descTv.setText((CharSequence)localObject);
          str = str + ", " + (String)localObject;
        }
      }
      if ((paramView == null) || (!(paramView.getTag() instanceof b)))
      {
        paramView = this.mInflater.inflate(ba.g.wxa_bind_wxa_info_header, paramViewGroup, false);
        paramViewGroup = new b((byte)0);
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(ba.f.titleTv));
        paramView.setAccessibilityDelegate(paramViewGroup.NbC);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        str = locala.MUK;
        paramViewGroup.titleTv.setText(str);
        break;
        paramViewGroup = (b)paramView.getTag();
      }
    }
    
    static final class a
      extends View.AccessibilityDelegate
    {
      public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
      {
        AppMethodBeat.i(305450);
        super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
        paramAccessibilityNodeInfo.setClickable(false);
        AppMethodBeat.o(305450);
      }
    }
    
    static final class b
    {
      public final WxaBindWxaInfoUI.b.a NbC;
      TextView titleTv;
      
      private b()
      {
        AppMethodBeat.i(305446);
        this.NbC = new WxaBindWxaInfoUI.b.a((byte)0);
        AppMethodBeat.o(305446);
      }
    }
    
    static final class c
      extends View.AccessibilityDelegate
    {
      public String contentDescription = null;
      
      public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
      {
        AppMethodBeat.i(305451);
        super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
        paramAccessibilityNodeInfo.setContentDescription(this.contentDescription);
        paramAccessibilityNodeInfo.setClassName(Button.class.getName());
        paramAccessibilityNodeInfo.setFocusable(true);
        paramAccessibilityNodeInfo.setClickable(true);
        AppMethodBeat.o(305451);
      }
    }
    
    static final class d
    {
      public final WxaBindWxaInfoUI.b.c NbD;
      TextView descTv;
      ImageView lPb;
      View pKl;
      TextView titleTv;
      
      private d()
      {
        AppMethodBeat.i(305453);
        this.NbD = new WxaBindWxaInfoUI.b.c((byte)0);
        AppMethodBeat.o(305453);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */