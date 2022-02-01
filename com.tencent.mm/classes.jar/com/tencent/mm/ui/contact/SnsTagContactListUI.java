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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private a KMS;
  private List<Long> KMT;
  private ListView viQ;
  
  public SnsTagContactListUI()
  {
    AppMethodBeat.i(38084);
    this.KMT = new ArrayList();
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
    this.viQ = ((ListView)findViewById(2131296471));
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
      this.KMT.add(Long.valueOf(arrayOfLong[i]));
      i += 1;
    }
    ((TextView)findViewById(2131299460)).setVisibility(8);
    findViewById(2131296489).setVisibility(8);
    this.viQ.setBackgroundColor(getResources().getColor(2131101179));
    ((View)this.viQ.getParent()).setBackgroundColor(getResources().getColor(2131101179));
    this.KMS = new a(this, this.KMT);
    this.viQ.setAdapter(this.KMS);
    this.viQ.setVisibility(0);
    this.viQ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38077);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousAdapterView);
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).mu(paramAnonymousInt);
        ((b)localObject).rl(paramAnonymousLong);
        a.b("com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahF());
        paramAnonymousAdapterView = new Intent();
        paramAnonymousView = (com.tencent.mm.contact.c)SnsTagContactListUI.a(SnsTagContactListUI.this).getItem(paramAnonymousInt);
        localObject = o.zsA;
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
    if (this.KMS != null) {
      this.KMS.notifyDataSetChanged();
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
    private bq Asc;
    private ColorStateList Bmx;
    private ColorStateList Bmy;
    private Map<Integer, com.tencent.mm.contact.c> KMQ;
    private Map<Integer, String> KMV;
    private Context context;
    
    public a(Context paramContext, List<Long> paramList)
    {
      AppMethodBeat.i(38079);
      this.context = null;
      this.KMQ = new HashMap();
      this.KMV = new HashMap();
      this.Asc = null;
      this.context = paramContext;
      this.KMQ.clear();
      this.KMV.clear();
      bc.aCg();
      this.Asc = com.tencent.mm.model.c.azF();
      paramList = paramList.iterator();
      Object localObject;
      int j;
      for (int i = 0; paramList.hasNext(); i = j)
      {
        long l = ((Long)paramList.next()).longValue();
        localObject = o.zsy;
        j = i;
        if (localObject != null)
        {
          Iterator localIterator = ((l)localObject).zT(l).iterator();
          for (;;)
          {
            j = i;
            if (!localIterator.hasNext()) {
              break;
            }
            String str = (String)localIterator.next();
            com.tencent.mm.contact.c localc = new com.tencent.mm.contact.c();
            localc.setUsername(str);
            this.KMV.put(Integer.valueOf(this.KMQ.size()), ((l)localObject).zU(l));
            this.KMQ.put(Integer.valueOf(i), localc);
            i += 1;
          }
        }
      }
      try
      {
        paramList = paramContext.getResources().getXml(2131100638);
        localObject = paramContext.getResources().getXml(2131100639);
        this.Bmx = ColorStateList.createFromXml(paramContext.getResources(), paramList);
        this.Bmy = ColorStateList.createFromXml(paramContext.getResources(), (XmlPullParser)localObject);
        AppMethodBeat.o(38079);
        return;
      }
      catch (XmlPullParserException paramContext)
      {
        ae.printErrStackTrace("MicroMsg.SnsTagContactList", paramContext, "", new Object[0]);
        AppMethodBeat.o(38079);
        return;
      }
      catch (IOException paramContext)
      {
        ae.printErrStackTrace("MicroMsg.SnsTagContactList", paramContext, "", new Object[0]);
        AppMethodBeat.o(38079);
      }
    }
    
    private String afa(int paramInt)
    {
      AppMethodBeat.i(38083);
      if (!this.KMV.containsKey(Integer.valueOf(paramInt)))
      {
        AppMethodBeat.o(38083);
        return "";
      }
      String str = (String)this.KMV.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(38083);
      return str;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(38080);
      int i = this.KMQ.size();
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
      com.tencent.mm.contact.c localc = (com.tencent.mm.contact.c)this.KMQ.get(Integer.valueOf(paramInt));
      Object localObject = localc;
      if (localc.field_showHead == 0)
      {
        an localan = this.Asc.BH(localc.field_username);
        localObject = localc;
        if (localan != null)
        {
          this.KMQ.put(Integer.valueOf(paramInt), localan);
          localObject = localan;
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
        paramView = View.inflate(this.context, 2131493644, null);
        paramViewGroup = new SnsTagContactListUI.b((byte)0);
        paramViewGroup.vcs = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fVG = ((MaskLayout)paramView.findViewById(2131298721));
        paramViewGroup.fRI = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.Bmz = ((TextView)paramView.findViewById(2131298719));
        paramView.setTag(paramViewGroup);
        if ((com.tencent.mm.contact.c)getItem(paramInt - 1) != null) {
          break label265;
        }
        localObject = "";
        localc = (com.tencent.mm.contact.c)getItem(paramInt);
        if (paramInt != 0) {
          break label277;
        }
        paramViewGroup.vcs.setVisibility(0);
        paramViewGroup.vcs.setText(afa(paramInt));
        paramViewGroup.vcs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        localTextView = paramViewGroup.fRI;
        if (x.AZ(localc.field_username)) {
          break label340;
        }
      }
      label265:
      label277:
      label340:
      for (Object localObject = this.Bmx;; localObject = this.Bmy)
      {
        localTextView.setTextColor((ColorStateList)localObject);
        a.b.w((ImageView)paramViewGroup.fVG.getContentView(), localc.field_username);
        paramViewGroup.Bmz.setVisibility(8);
        paramViewGroup.fVG.setVisibility(0);
        paramViewGroup.fRI.setText(k.b(this.context, localc.adG(), paramViewGroup.fRI.getTextSize()));
        paramViewGroup.fRI.setVisibility(0);
        AppMethodBeat.o(38082);
        return paramView;
        paramViewGroup = (SnsTagContactListUI.b)paramView.getTag();
        break;
        localObject = afa(paramInt - 1);
        break label103;
        if ((paramInt > 0) && (!afa(paramInt).equals(localObject)))
        {
          paramViewGroup.vcs.setVisibility(0);
          paramViewGroup.vcs.setText(afa(paramInt));
          paramViewGroup.vcs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label148;
        }
        paramViewGroup.vcs.setVisibility(8);
        break label148;
      }
    }
  }
  
  static final class b
  {
    TextView Bmz;
    TextView fRI;
    MaskLayout fVG;
    TextView vcs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI
 * JD-Core Version:    0.7.0.1
 */