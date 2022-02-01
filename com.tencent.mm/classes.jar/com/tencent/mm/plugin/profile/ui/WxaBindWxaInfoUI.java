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
    return 2131497110;
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
    setMMTitle(2131755644);
    setActionbarColor(getActionbarColor());
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("register"));
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("wxa_register_info_list");
    View localView = getLayoutInflater().inflate(2131497108, null);
    ((TextView)localView.findViewById(2131309199)).setText(getString(2131755645, new Object[] { paramBundle }));
    this.mListView = ((ListView)findViewById(2131299408));
    this.mListView.addFooterView(localView);
    this.mListView.setAdapter(new b(getLayoutInflater(), localArrayList));
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(50067);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousAdapterView = (WxaBindWxaInfoUI.a)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (1 != paramAnonymousAdapterView.type))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(50067);
          return;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.BiN;
        paramAnonymousView = (r)com.tencent.mm.kernel.g.af(r.class);
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
    getContentView().setBackgroundResource(2131101059);
    AppMethodBeat.o(50073);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    public final String BcS;
    public final WxaAttributes.WxaEntryInfo BiN;
    public final boolean BiO;
    public final int type;
    
    private a(int paramInt, String paramString, WxaAttributes.WxaEntryInfo paramWxaEntryInfo, boolean paramBoolean)
    {
      this.type = paramInt;
      this.BcS = paramString;
      this.BiN = paramWxaEntryInfo;
      this.BiO = paramBoolean;
    }
    
    public static List<a> fS(List<WxaRegisterInfo> paramList)
    {
      AppMethodBeat.i(227871);
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
          if (((CharSequence)localWxaRegisterInfo.BcS).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label199;
            }
            if (((Collection)localWxaRegisterInfo.BcT).isEmpty()) {
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
            localArrayList.add(new a(0, localWxaRegisterInfo.BcS, null, false));
            int j = localWxaRegisterInfo.BcT.size();
            i = 0;
            label132:
            if (i < j)
            {
              localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)localWxaRegisterInfo.BcT.get(i);
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
      AppMethodBeat.o(227871);
      return localArrayList;
    }
  }
  
  static final class b
    extends BaseAdapter
  {
    private LayoutInflater mInflater;
    private List<WxaBindWxaInfoUI.a> opg;
    
    public b(LayoutInflater paramLayoutInflater, List<WxaRegisterInfo> paramList)
    {
      AppMethodBeat.i(50068);
      this.mInflater = paramLayoutInflater;
      this.opg = WxaBindWxaInfoUI.a.fS(paramList);
      AppMethodBeat.o(50068);
    }
    
    private WxaBindWxaInfoUI.a UR(int paramInt)
    {
      AppMethodBeat.i(227872);
      WxaBindWxaInfoUI.a locala = (WxaBindWxaInfoUI.a)this.opg.get(paramInt);
      AppMethodBeat.o(227872);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(50069);
      int i = this.opg.size();
      AppMethodBeat.o(50069);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(227873);
      paramInt = UR(paramInt).type;
      AppMethodBeat.o(227873);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(50071);
      WxaBindWxaInfoUI.a locala = UR(paramInt);
      Object localObject;
      if (1 == locala.type)
      {
        if ((paramView == null) || (!(paramView.getTag() instanceof b)))
        {
          paramView = this.mInflater.inflate(2131493066, paramViewGroup, false);
          paramViewGroup = new b((byte)0);
          paramViewGroup.gBZ = ((ImageView)paramView.findViewById(2131302468));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306126));
          paramViewGroup.hPW = ((TextView)paramView.findViewById(2131307446));
          paramViewGroup.jWr = paramView.findViewById(2131299682);
          paramView.setTag(paramViewGroup);
          localObject = locala.BiN;
          com.tencent.mm.modelappbrand.a.b.aXY().a(paramViewGroup.gBZ, ((WxaAttributes.WxaEntryInfo)localObject).iconUrl, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
          paramViewGroup.titleTv.setText(Util.nullAsNil(((WxaAttributes.WxaEntryInfo)localObject).title));
          if (!Util.isNullOrNil(((WxaAttributes.WxaEntryInfo)localObject).lgO)) {
            break label226;
          }
          paramViewGroup.hPW.setVisibility(4);
          label173:
          localObject = paramView;
          if (this.opg != null)
          {
            paramViewGroup = paramViewGroup.jWr;
            if (!locala.BiO) {
              break label249;
            }
          }
        }
        label226:
        label249:
        for (paramInt = 8;; paramInt = 0)
        {
          paramViewGroup.setVisibility(paramInt);
          localObject = paramView;
          AppMethodBeat.o(50071);
          return localObject;
          paramViewGroup = (b)paramView.getTag();
          break;
          paramViewGroup.hPW.setVisibility(0);
          paramViewGroup.hPW.setText(((WxaAttributes.WxaEntryInfo)localObject).lgO);
          break label173;
        }
      }
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        paramView = this.mInflater.inflate(2131497109, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131309199));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = locala.BcS;
        paramViewGroup.titleTv.setText((CharSequence)localObject);
        localObject = paramView;
        break;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    static final class a
    {
      TextView titleTv;
    }
    
    static final class b
    {
      ImageView gBZ;
      TextView hPW;
      View jWr;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */