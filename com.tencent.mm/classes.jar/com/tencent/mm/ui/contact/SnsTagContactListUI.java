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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private a Kqy;
  private List<Long> Kqz;
  private ListView uXc;
  
  public SnsTagContactListUI()
  {
    AppMethodBeat.i(38084);
    this.Kqz = new ArrayList();
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
    this.uXc = ((ListView)findViewById(2131296471));
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
      this.Kqz.add(Long.valueOf(arrayOfLong[i]));
      i += 1;
    }
    ((TextView)findViewById(2131299460)).setVisibility(8);
    findViewById(2131296489).setVisibility(8);
    this.uXc.setBackgroundColor(getResources().getColor(2131101179));
    ((View)this.uXc.getParent()).setBackgroundColor(getResources().getColor(2131101179));
    this.Kqy = new a(this, this.Kqz);
    this.uXc.setAdapter(this.Kqy);
    this.uXc.setVisibility(0);
    this.uXc.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38077);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        a.b("com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousAdapterView = new Intent();
        paramAnonymousView = (com.tencent.mm.o.b)SnsTagContactListUI.a(SnsTagContactListUI.this).getItem(paramAnonymousInt);
        localObject = o.zbX;
        if (localObject == null)
        {
          SnsTagContactListUI.this.finish();
          a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38077);
          return;
        }
        paramAnonymousAdapterView = ((i)localObject).f(paramAnonymousAdapterView, paramAnonymousView.field_username);
        if (paramAnonymousAdapterView == null)
        {
          SnsTagContactListUI.this.finish();
          a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38077);
          return;
        }
        paramAnonymousAdapterView.putExtra("sns_adapter_type", 1);
        d.b(SnsTagContactListUI.this.getContext(), "sns", ".ui.SnsTimeLineUserPagerUI", paramAnonymousAdapterView);
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
    if (this.Kqy != null) {
      this.Kqy.notifyDataSetChanged();
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
    private ColorStateList AUZ;
    private ColorStateList AVa;
    private bp AaP;
    private Map<Integer, String> KqB;
    private Map<Integer, com.tencent.mm.o.b> Kqw;
    private Context context;
    
    public a(Context paramContext, List<Long> paramList)
    {
      AppMethodBeat.i(38079);
      this.context = null;
      this.Kqw = new HashMap();
      this.KqB = new HashMap();
      this.AaP = null;
      this.context = paramContext;
      this.Kqw.clear();
      this.KqB.clear();
      ba.aBQ();
      this.AaP = c.azp();
      paramList = paramList.iterator();
      Object localObject;
      int j;
      for (int i = 0; paramList.hasNext(); i = j)
      {
        long l = ((Long)paramList.next()).longValue();
        localObject = o.zbV;
        j = i;
        if (localObject != null)
        {
          Iterator localIterator = ((l)localObject).zu(l).iterator();
          for (;;)
          {
            j = i;
            if (!localIterator.hasNext()) {
              break;
            }
            String str = (String)localIterator.next();
            com.tencent.mm.o.b localb = new com.tencent.mm.o.b();
            localb.setUsername(str);
            this.KqB.put(Integer.valueOf(this.Kqw.size()), ((l)localObject).zv(l));
            this.Kqw.put(Integer.valueOf(i), localb);
            i += 1;
          }
        }
      }
      try
      {
        paramList = paramContext.getResources().getXml(2131100638);
        localObject = paramContext.getResources().getXml(2131100639);
        this.AUZ = ColorStateList.createFromXml(paramContext.getResources(), paramList);
        this.AVa = ColorStateList.createFromXml(paramContext.getResources(), (XmlPullParser)localObject);
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
    
    private String aer(int paramInt)
    {
      AppMethodBeat.i(38083);
      if (!this.KqB.containsKey(Integer.valueOf(paramInt)))
      {
        AppMethodBeat.o(38083);
        return "";
      }
      String str = (String)this.KqB.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(38083);
      return str;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(38080);
      int i = this.Kqw.size();
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
      com.tencent.mm.o.b localb = (com.tencent.mm.o.b)this.Kqw.get(Integer.valueOf(paramInt));
      Object localObject = localb;
      if (localb.field_showHead == 0)
      {
        am localam = this.AaP.Bf(localb.field_username);
        localObject = localb;
        if (localam != null)
        {
          this.Kqw.put(Integer.valueOf(paramInt), localam);
          localObject = localam;
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
      com.tencent.mm.o.b localb;
      label148:
      TextView localTextView;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131493644, null);
        paramViewGroup = new SnsTagContactListUI.b((byte)0);
        paramViewGroup.uQG = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fTA = ((MaskLayout)paramView.findViewById(2131298721));
        paramViewGroup.fPC = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.AVb = ((TextView)paramView.findViewById(2131298719));
        paramView.setTag(paramViewGroup);
        if ((com.tencent.mm.o.b)getItem(paramInt - 1) != null) {
          break label265;
        }
        localObject = "";
        localb = (com.tencent.mm.o.b)getItem(paramInt);
        if (paramInt != 0) {
          break label277;
        }
        paramViewGroup.uQG.setVisibility(0);
        paramViewGroup.uQG.setText(aer(paramInt));
        paramViewGroup.uQG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        localTextView = paramViewGroup.fPC;
        if (w.Ap(localb.field_username)) {
          break label340;
        }
      }
      label265:
      label277:
      label340:
      for (Object localObject = this.AUZ;; localObject = this.AVa)
      {
        localTextView.setTextColor((ColorStateList)localObject);
        a.b.w((ImageView)paramViewGroup.fTA.getContentView(), localb.field_username);
        paramViewGroup.AVb.setVisibility(8);
        paramViewGroup.fTA.setVisibility(0);
        paramViewGroup.fPC.setText(k.b(this.context, localb.adv(), paramViewGroup.fPC.getTextSize()));
        paramViewGroup.fPC.setVisibility(0);
        AppMethodBeat.o(38082);
        return paramView;
        paramViewGroup = (SnsTagContactListUI.b)paramView.getTag();
        break;
        localObject = aer(paramInt - 1);
        break label103;
        if ((paramInt > 0) && (!aer(paramInt).equals(localObject)))
        {
          paramViewGroup.uQG.setVisibility(0);
          paramViewGroup.uQG.setText(aer(paramInt));
          paramViewGroup.uQG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label148;
        }
        paramViewGroup.uQG.setVisibility(8);
        break label148;
      }
    }
  }
  
  static final class b
  {
    TextView AVb;
    TextView fPC;
    MaskLayout fTA;
    TextView uQG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI
 * JD-Core Version:    0.7.0.1
 */