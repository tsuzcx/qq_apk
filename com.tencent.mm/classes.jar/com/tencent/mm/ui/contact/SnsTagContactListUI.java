package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SnsTagContactListUI
  extends MMActivity
{
  private ListView Een;
  private a XwP;
  private List<Long> XwQ;
  
  public SnsTagContactListUI()
  {
    AppMethodBeat.i(38084);
    this.XwQ = new ArrayList();
    AppMethodBeat.o(38084);
  }
  
  public int getLayoutId()
  {
    return R.i.address;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38086);
    setMMTitle(R.l.sns_tag_see);
    findViewById(R.h.loading_tips_area).setVisibility(8);
    this.Een = ((ListView)findViewById(R.h.address_contactlist));
    long[] arrayOfLong = getIntent().getLongArrayExtra("sns_tag_list");
    if (arrayOfLong == null)
    {
      finish();
      AppMethodBeat.o(38086);
      return;
    }
    int i = 0;
    while (i < arrayOfLong.length)
    {
      this.XwQ.add(Long.valueOf(arrayOfLong[i]));
      i += 1;
    }
    ((TextView)findViewById(R.h.dFv)).setVisibility(8);
    findViewById(R.h.dqz).setVisibility(8);
    this.Een.setBackgroundColor(getResources().getColor(R.e.white));
    ((View)this.Een.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
    this.XwP = new a(this, this.XwQ);
    this.Een.setAdapter(this.XwP);
    this.Een.setVisibility(0);
    this.Een.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38077);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousAdapterView);
        ((b)localObject).bn(paramAnonymousView);
        ((b)localObject).sg(paramAnonymousInt);
        ((b)localObject).Fs(paramAnonymousLong);
        a.c("com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aFi());
        paramAnonymousAdapterView = new Intent();
        paramAnonymousView = (d)SnsTagContactListUI.a(SnsTagContactListUI.this).getItem(paramAnonymousInt);
        localObject = p.JPh;
        if (localObject == null)
        {
          SnsTagContactListUI.this.finish();
          a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38077);
          return;
        }
        paramAnonymousAdapterView = ((j)localObject).f(paramAnonymousAdapterView, paramAnonymousView.field_username);
        if (paramAnonymousAdapterView == null)
        {
          SnsTagContactListUI.this.finish();
          a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38077);
          return;
        }
        paramAnonymousAdapterView.putExtra("sns_adapter_type", 1);
        com.tencent.mm.by.c.b(SnsTagContactListUI.this.getContext(), "sns", ".ui.SnsTimeLineUserPagerUI", paramAnonymousAdapterView);
        a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(38077);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38078);
        SnsTagContactListUI.this.finish();
        AppMethodBeat.o(38078);
        return true;
      }
    });
    showOptionMenu(false);
    AppMethodBeat.o(38086);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38085);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(38085);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38088);
    super.onDestroy();
    AppMethodBeat.o(38088);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38087);
    super.onResume();
    if (this.XwP != null) {
      this.XwP.notifyDataSetChanged();
    }
    AppMethodBeat.o(38087);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    private bv KOY;
    private ColorStateList LRp;
    private ColorStateList LRq;
    private Map<Integer, d> XwN;
    private Map<Integer, String> XwS;
    private Context context;
    
    public a(Context paramContext, List<Long> paramList)
    {
      AppMethodBeat.i(38079);
      this.context = null;
      this.XwN = new HashMap();
      this.XwS = new HashMap();
      this.KOY = null;
      this.context = paramContext;
      this.XwN.clear();
      this.XwS.clear();
      bh.beI();
      this.KOY = com.tencent.mm.model.c.bbL();
      paramList = paramList.iterator();
      Object localObject;
      int j;
      for (int i = 0; paramList.hasNext(); i = j)
      {
        long l = ((Long)paramList.next()).longValue();
        localObject = p.JPf;
        j = i;
        if (localObject != null)
        {
          Iterator localIterator = ((m)localObject).Qs(l).iterator();
          for (;;)
          {
            j = i;
            if (!localIterator.hasNext()) {
              break;
            }
            String str = (String)localIterator.next();
            d locald = new d();
            locald.setUsername(str);
            this.XwS.put(Integer.valueOf(this.XwN.size()), ((m)localObject).Qt(l));
            this.XwN.put(Integer.valueOf(i), locald);
            i += 1;
          }
        }
      }
      try
      {
        paramList = paramContext.getResources().getXml(R.e.mm_list_textcolor_one);
        localObject = paramContext.getResources().getXml(R.e.mm_list_textcolor_spuser);
        this.LRp = ColorStateList.createFromXml(paramContext.getResources(), paramList);
        this.LRq = ColorStateList.createFromXml(paramContext.getResources(), (XmlPullParser)localObject);
        AppMethodBeat.o(38079);
        return;
      }
      catch (XmlPullParserException paramContext)
      {
        Log.printErrStackTrace("MicroMsg.SnsTagContactList", paramContext, "", new Object[0]);
        AppMethodBeat.o(38079);
        return;
      }
      catch (IOException paramContext)
      {
        Log.printErrStackTrace("MicroMsg.SnsTagContactList", paramContext, "", new Object[0]);
        AppMethodBeat.o(38079);
      }
    }
    
    private String awQ(int paramInt)
    {
      AppMethodBeat.i(38083);
      if (!this.XwS.containsKey(Integer.valueOf(paramInt)))
      {
        AppMethodBeat.o(38083);
        return "";
      }
      String str = (String)this.XwS.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(38083);
      return str;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(38080);
      int i = this.XwN.size();
      AppMethodBeat.o(38080);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(38081);
      if (paramInt < 0)
      {
        AppMethodBeat.o(38081);
        return null;
      }
      d locald = (d)this.XwN.get(Integer.valueOf(paramInt));
      Object localObject = locald;
      if (locald.field_showHead == 0)
      {
        as localas = this.KOY.RG(locald.field_username);
        localObject = locald;
        if (localas != null)
        {
          this.XwN.put(Integer.valueOf(paramInt), localas);
          localObject = localas;
        }
      }
      AppMethodBeat.o(38081);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(38082);
      label108:
      d locald;
      label153:
      TextView localTextView;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, R.i.efr, null);
        paramViewGroup = new SnsTagContactListUI.b((byte)0);
        paramViewGroup.DUW = ((TextView)paramView.findViewById(R.h.dCx));
        paramViewGroup.jkT = ((MaskLayout)paramView.findViewById(R.h.dCv));
        paramViewGroup.jbe = ((TextView)paramView.findViewById(R.h.dCB));
        paramViewGroup.LRr = ((TextView)paramView.findViewById(R.h.dCt));
        paramView.setTag(paramViewGroup);
        if ((d)getItem(paramInt - 1) != null) {
          break label270;
        }
        localObject = "";
        locald = (d)getItem(paramInt);
        if (paramInt != 0) {
          break label282;
        }
        paramViewGroup.DUW.setVisibility(0);
        paramViewGroup.DUW.setText(awQ(paramInt));
        paramViewGroup.DUW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        localTextView = paramViewGroup.jbe;
        if (ab.QX(locald.field_username)) {
          break label345;
        }
      }
      label270:
      label282:
      label345:
      for (Object localObject = this.LRp;; localObject = this.LRq)
      {
        localTextView.setTextColor((ColorStateList)localObject);
        a.b.C((ImageView)paramViewGroup.jkT.getContentView(), locald.field_username);
        paramViewGroup.LRr.setVisibility(8);
        paramViewGroup.jkT.setVisibility(0);
        paramViewGroup.jbe.setText(l.b(this.context, locald.ays(), paramViewGroup.jbe.getTextSize()));
        paramViewGroup.jbe.setVisibility(0);
        AppMethodBeat.o(38082);
        return paramView;
        paramViewGroup = (SnsTagContactListUI.b)paramView.getTag();
        break;
        localObject = awQ(paramInt - 1);
        break label108;
        if ((paramInt > 0) && (!awQ(paramInt).equals(localObject)))
        {
          paramViewGroup.DUW.setVisibility(0);
          paramViewGroup.DUW.setText(awQ(paramInt));
          paramViewGroup.DUW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label153;
        }
        paramViewGroup.DUW.setVisibility(8);
        break label153;
      }
    }
  }
  
  static final class b
  {
    TextView DUW;
    TextView LRr;
    TextView jbe;
    MaskLayout jkT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI
 * JD-Core Version:    0.7.0.1
 */