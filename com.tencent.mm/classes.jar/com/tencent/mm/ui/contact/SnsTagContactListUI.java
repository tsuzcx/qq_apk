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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.sns.c.i;
import com.tencent.mm.plugin.sns.c.l;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  private a GZc;
  private List<Long> GZd;
  private ListView sMV;
  
  public SnsTagContactListUI()
  {
    AppMethodBeat.i(38084);
    this.GZd = new ArrayList();
    AppMethodBeat.o(38084);
  }
  
  public int getLayoutId()
  {
    return 2131492947;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38086);
    setMMTitle(2131764016);
    findViewById(2131301512).setVisibility(8);
    this.sMV = ((ListView)findViewById(2131296471));
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
      this.GZd.add(Long.valueOf(arrayOfLong[i]));
      i += 1;
    }
    ((TextView)findViewById(2131299460)).setVisibility(8);
    findViewById(2131296489).setVisibility(8);
    this.sMV.setBackgroundColor(getResources().getColor(2131101179));
    ((View)this.sMV.getParent()).setBackgroundColor(getResources().getColor(2131101179));
    this.GZc = new a(this, this.GZd);
    this.sMV.setAdapter(this.GZc);
    this.sMV.setVisibility(0);
    this.sMV.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38077);
        paramAnonymousAdapterView = new Intent();
        paramAnonymousView = (b)SnsTagContactListUI.a(SnsTagContactListUI.this).getItem(paramAnonymousInt);
        i locali = o.wzL;
        if (locali == null)
        {
          SnsTagContactListUI.this.finish();
          AppMethodBeat.o(38077);
          return;
        }
        paramAnonymousAdapterView = locali.f(paramAnonymousAdapterView, paramAnonymousView.field_username);
        if (paramAnonymousAdapterView == null)
        {
          SnsTagContactListUI.this.finish();
          AppMethodBeat.o(38077);
          return;
        }
        paramAnonymousAdapterView.putExtra("sns_adapter_type", 1);
        d.b(SnsTagContactListUI.this.getContext(), "sns", ".ui.SnsTimeLineUserPagerUI", paramAnonymousAdapterView);
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
    if (this.GZc != null) {
      this.GZc.notifyDataSetChanged();
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
    private Map<Integer, b> GZa;
    private Map<Integer, String> GZf;
    private Context context;
    private bg xwF;
    private ColorStateList yqc;
    private ColorStateList yqd;
    
    public a(Context paramContext, List<Long> paramList)
    {
      AppMethodBeat.i(38079);
      this.context = null;
      this.GZa = new HashMap();
      this.GZf = new HashMap();
      this.xwF = null;
      this.context = paramContext;
      this.GZa.clear();
      this.GZf.clear();
      az.arV();
      this.xwF = c.apM();
      paramList = paramList.iterator();
      Object localObject;
      int j;
      for (int i = 0; paramList.hasNext(); i = j)
      {
        long l = ((Long)paramList.next()).longValue();
        localObject = o.wzJ;
        j = i;
        if (localObject != null)
        {
          Iterator localIterator = ((l)localObject).sr(l).iterator();
          for (;;)
          {
            j = i;
            if (!localIterator.hasNext()) {
              break;
            }
            String str = (String)localIterator.next();
            b localb = new b();
            localb.setUsername(str);
            this.GZf.put(Integer.valueOf(this.GZa.size()), ((l)localObject).ss(l));
            this.GZa.put(Integer.valueOf(i), localb);
            i += 1;
          }
        }
      }
      try
      {
        paramList = paramContext.getResources().getXml(2131100638);
        localObject = paramContext.getResources().getXml(2131100639);
        this.yqc = ColorStateList.createFromXml(paramContext.getResources(), paramList);
        this.yqd = ColorStateList.createFromXml(paramContext.getResources(), (XmlPullParser)localObject);
        AppMethodBeat.o(38079);
        return;
      }
      catch (XmlPullParserException paramContext)
      {
        ad.printErrStackTrace("MicroMsg.SnsTagContactList", paramContext, "", new Object[0]);
        AppMethodBeat.o(38079);
        return;
      }
      catch (IOException paramContext)
      {
        ad.printErrStackTrace("MicroMsg.SnsTagContactList", paramContext, "", new Object[0]);
        AppMethodBeat.o(38079);
      }
    }
    
    private String ZG(int paramInt)
    {
      AppMethodBeat.i(38083);
      if (!this.GZf.containsKey(Integer.valueOf(paramInt)))
      {
        AppMethodBeat.o(38083);
        return "";
      }
      String str = (String)this.GZf.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(38083);
      return str;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(38080);
      int i = this.GZa.size();
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
      b localb = (b)this.GZa.get(Integer.valueOf(paramInt));
      Object localObject = localb;
      if (localb.field_showHead == 0)
      {
        af localaf = this.xwF.aHY(localb.field_username);
        localObject = localb;
        if (localaf != null)
        {
          this.GZa.put(Integer.valueOf(paramInt), localaf);
          localObject = localaf;
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
      label103:
      b localb;
      label148:
      TextView localTextView;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131493644, null);
        paramViewGroup = new SnsTagContactListUI.b((byte)0);
        paramViewGroup.sGm = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fwD = ((MaskLayout)paramView.findViewById(2131298721));
        paramViewGroup.fsI = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.yqe = ((TextView)paramView.findViewById(2131298719));
        paramView.setTag(paramViewGroup);
        if ((b)getItem(paramInt - 1) != null) {
          break label265;
        }
        localObject = "";
        localb = (b)getItem(paramInt);
        if (paramInt != 0) {
          break label277;
        }
        paramViewGroup.sGm.setVisibility(0);
        paramViewGroup.sGm.setText(ZG(paramInt));
        paramViewGroup.sGm.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        localTextView = paramViewGroup.fsI;
        if (w.to(localb.field_username)) {
          break label340;
        }
      }
      label265:
      label277:
      label340:
      for (Object localObject = this.yqc;; localObject = this.yqd)
      {
        localTextView.setTextColor((ColorStateList)localObject);
        a.b.w((ImageView)paramViewGroup.fwD.getContentView(), localb.field_username);
        paramViewGroup.yqe.setVisibility(8);
        paramViewGroup.fwD.setVisibility(0);
        paramViewGroup.fsI.setText(k.b(this.context, localb.ZX(), paramViewGroup.fsI.getTextSize()));
        paramViewGroup.fsI.setVisibility(0);
        AppMethodBeat.o(38082);
        return paramView;
        paramViewGroup = (SnsTagContactListUI.b)paramView.getTag();
        break;
        localObject = ZG(paramInt - 1);
        break label103;
        if ((paramInt > 0) && (!ZG(paramInt).equals(localObject)))
        {
          paramViewGroup.sGm.setVisibility(0);
          paramViewGroup.sGm.setText(ZG(paramInt));
          paramViewGroup.sGm.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label148;
        }
        paramViewGroup.sGm.setVisibility(8);
        break label148;
      }
    }
  }
  
  static final class b
  {
    TextView fsI;
    MaskLayout fwD;
    TextView sGm;
    TextView yqe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI
 * JD-Core Version:    0.7.0.1
 */