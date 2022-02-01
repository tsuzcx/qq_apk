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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.a.b;
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
  private a PZS;
  private List<Long> PZT;
  private ListView yCT;
  
  public SnsTagContactListUI()
  {
    AppMethodBeat.i(38084);
    this.PZT = new ArrayList();
    AppMethodBeat.o(38084);
  }
  
  public int getLayoutId()
  {
    return 2131492980;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38086);
    setMMTitle(2131766254);
    findViewById(2131303716).setVisibility(8);
    this.yCT = ((ListView)findViewById(2131296545));
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
      this.PZT.add(Long.valueOf(arrayOfLong[i]));
      i += 1;
    }
    ((TextView)findViewById(2131300081)).setVisibility(8);
    findViewById(2131296563).setVisibility(8);
    this.yCT.setBackgroundColor(getResources().getColor(2131101424));
    ((View)this.yCT.getParent()).setBackgroundColor(getResources().getColor(2131101424));
    this.PZS = new a(this, this.PZT);
    this.yCT.setAdapter(this.PZS);
    this.yCT.setVisibility(0);
    this.yCT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38077);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousAdapterView);
        ((b)localObject).bm(paramAnonymousView);
        ((b)localObject).pH(paramAnonymousInt);
        ((b)localObject).zo(paramAnonymousLong);
        a.b("com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
        paramAnonymousAdapterView = new Intent();
        paramAnonymousView = (com.tencent.mm.contact.c)SnsTagContactListUI.a(SnsTagContactListUI.this).getItem(paramAnonymousInt);
        localObject = o.DCR;
        if (localObject == null)
        {
          SnsTagContactListUI.this.finish();
          a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38077);
          return;
        }
        paramAnonymousAdapterView = ((i)localObject).g(paramAnonymousAdapterView, paramAnonymousView.field_username);
        if (paramAnonymousAdapterView == null)
        {
          SnsTagContactListUI.this.finish();
          a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38077);
          return;
        }
        paramAnonymousAdapterView.putExtra("sns_adapter_type", 1);
        com.tencent.mm.br.c.b(SnsTagContactListUI.this.getContext(), "sns", ".ui.SnsTimeLineUserPagerUI", paramAnonymousAdapterView);
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
    if (this.PZS != null) {
      this.PZS.notifyDataSetChanged();
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
    private bv EBg;
    private ColorStateList Fxn;
    private ColorStateList Fxo;
    private Map<Integer, com.tencent.mm.contact.c> PZQ;
    private Map<Integer, String> PZV;
    private Context context;
    
    public a(Context paramContext, List<Long> paramList)
    {
      AppMethodBeat.i(38079);
      this.context = null;
      this.PZQ = new HashMap();
      this.PZV = new HashMap();
      this.EBg = null;
      this.context = paramContext;
      this.PZQ.clear();
      this.PZV.clear();
      bg.aVF();
      this.EBg = com.tencent.mm.model.c.aSN();
      paramList = paramList.iterator();
      Object localObject;
      int j;
      for (int i = 0; paramList.hasNext(); i = j)
      {
        long l = ((Long)paramList.next()).longValue();
        localObject = o.DCP;
        j = i;
        if (localObject != null)
        {
          Iterator localIterator = ((com.tencent.mm.plugin.sns.b.l)localObject).IZ(l).iterator();
          for (;;)
          {
            j = i;
            if (!localIterator.hasNext()) {
              break;
            }
            String str = (String)localIterator.next();
            com.tencent.mm.contact.c localc = new com.tencent.mm.contact.c();
            localc.setUsername(str);
            this.PZV.put(Integer.valueOf(this.PZQ.size()), ((com.tencent.mm.plugin.sns.b.l)localObject).Ja(l));
            this.PZQ.put(Integer.valueOf(i), localc);
            i += 1;
          }
        }
      }
      try
      {
        paramList = paramContext.getResources().getXml(2131100808);
        localObject = paramContext.getResources().getXml(2131100809);
        this.Fxn = ColorStateList.createFromXml(paramContext.getResources(), paramList);
        this.Fxo = ColorStateList.createFromXml(paramContext.getResources(), (XmlPullParser)localObject);
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
    
    private String anL(int paramInt)
    {
      AppMethodBeat.i(38083);
      if (!this.PZV.containsKey(Integer.valueOf(paramInt)))
      {
        AppMethodBeat.o(38083);
        return "";
      }
      String str = (String)this.PZV.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(38083);
      return str;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(38080);
      int i = this.PZQ.size();
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
      com.tencent.mm.contact.c localc = (com.tencent.mm.contact.c)this.PZQ.get(Integer.valueOf(paramInt));
      Object localObject = localc;
      if (localc.field_showHead == 0)
      {
        as localas = this.EBg.Kn(localc.field_username);
        localObject = localc;
        if (localas != null)
        {
          this.PZQ.put(Integer.valueOf(paramInt), localas);
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
      label103:
      com.tencent.mm.contact.c localc;
      label148:
      TextView localTextView;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131493774, null);
        paramViewGroup = new SnsTagContactListUI.b((byte)0);
        paramViewGroup.yuS = ((TextView)paramView.findViewById(2131299162));
        paramViewGroup.gAN = ((MaskLayout)paramView.findViewById(2131299159));
        paramViewGroup.gwR = ((TextView)paramView.findViewById(2131299167));
        paramViewGroup.Fxp = ((TextView)paramView.findViewById(2131299157));
        paramView.setTag(paramViewGroup);
        if ((com.tencent.mm.contact.c)getItem(paramInt - 1) != null) {
          break label265;
        }
        localObject = "";
        localc = (com.tencent.mm.contact.c)getItem(paramInt);
        if (paramInt != 0) {
          break label277;
        }
        paramViewGroup.yuS.setVisibility(0);
        paramViewGroup.yuS.setText(anL(paramInt));
        paramViewGroup.yuS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        localTextView = paramViewGroup.gwR;
        if (ab.JE(localc.field_username)) {
          break label340;
        }
      }
      label265:
      label277:
      label340:
      for (Object localObject = this.Fxn;; localObject = this.Fxo)
      {
        localTextView.setTextColor((ColorStateList)localObject);
        a.b.A((ImageView)paramViewGroup.gAN.getContentView(), localc.field_username);
        paramViewGroup.Fxp.setVisibility(8);
        paramViewGroup.gAN.setVisibility(0);
        paramViewGroup.gwR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, localc.arJ(), paramViewGroup.gwR.getTextSize()));
        paramViewGroup.gwR.setVisibility(0);
        AppMethodBeat.o(38082);
        return paramView;
        paramViewGroup = (SnsTagContactListUI.b)paramView.getTag();
        break;
        localObject = anL(paramInt - 1);
        break label103;
        if ((paramInt > 0) && (!anL(paramInt).equals(localObject)))
        {
          paramViewGroup.yuS.setVisibility(0);
          paramViewGroup.yuS.setText(anL(paramInt));
          paramViewGroup.yuS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label148;
        }
        paramViewGroup.yuS.setVisibility(8);
        break label148;
      }
    }
  }
  
  static final class b
  {
    TextView Fxp;
    MaskLayout gAN;
    TextView gwR;
    TextView yuS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI
 * JD-Core Version:    0.7.0.1
 */