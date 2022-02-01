package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.c.n;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.MaskLayout;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class SnsTagContactListUI$a
  extends BaseAdapter
{
  private bx RoL;
  private ColorStateList StV;
  private ColorStateList StW;
  private Map<Integer, d> afiQ;
  private Map<Integer, String> afiV;
  private Context context;
  
  public SnsTagContactListUI$a(Context paramContext, List<Long> paramList)
  {
    AppMethodBeat.i(38079);
    this.context = null;
    this.afiQ = new HashMap();
    this.afiV = new HashMap();
    this.RoL = null;
    this.context = paramContext;
    this.afiQ.clear();
    this.afiV.clear();
    bh.bCz();
    this.RoL = c.bzA();
    paramList = paramList.iterator();
    Object localObject;
    int j;
    for (int i = 0; paramList.hasNext(); i = j)
    {
      long l = ((Long)paramList.next()).longValue();
      localObject = q.Qkl;
      j = i;
      if (localObject != null)
      {
        Iterator localIterator = ((n)localObject).ux(l).iterator();
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          String str = (String)localIterator.next();
          d locald = new d();
          locald.setUsername(str);
          this.afiV.put(Integer.valueOf(this.afiQ.size()), ((n)localObject).uy(l));
          this.afiQ.put(Integer.valueOf(i), locald);
          i += 1;
        }
      }
    }
    try
    {
      paramList = paramContext.getResources().getXml(R.e.mm_list_textcolor_one);
      localObject = paramContext.getResources().getXml(R.e.mm_list_textcolor_spuser);
      this.StV = ColorStateList.createFromXml(paramContext.getResources(), paramList);
      this.StW = ColorStateList.createFromXml(paramContext.getResources(), (XmlPullParser)localObject);
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
  
  private String aDx(int paramInt)
  {
    AppMethodBeat.i(38083);
    if (!this.afiV.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(38083);
      return "";
    }
    String str = (String)this.afiV.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(38083);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(38080);
    int i = this.afiQ.size();
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
    d locald = (d)this.afiQ.get(Integer.valueOf(paramInt));
    Object localObject = locald;
    if (locald.field_showHead == 0)
    {
      au localau = this.RoL.JE(locald.field_username);
      localObject = locald;
      if (localau != null)
      {
        this.afiQ.put(Integer.valueOf(paramInt), localau);
        localObject = localau;
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
      paramView = View.inflate(this.context, R.i.gim, null);
      paramViewGroup = new SnsTagContactListUI.b((byte)0);
      paramViewGroup.JMf = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
      paramViewGroup.lNy = ((MaskLayout)paramView.findViewById(R.h.fDl));
      paramViewGroup.lDe = ((TextView)paramView.findViewById(R.h.fDq));
      paramViewGroup.StX = ((TextView)paramView.findViewById(R.h.fDj));
      paramView.setTag(paramViewGroup);
      if ((d)getItem(paramInt - 1) != null) {
        break label270;
      }
      localObject = "";
      locald = (d)getItem(paramInt);
      if (paramInt != 0) {
        break label282;
      }
      paramViewGroup.JMf.setVisibility(0);
      paramViewGroup.JMf.setText(aDx(paramInt));
      paramViewGroup.JMf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      localTextView = paramViewGroup.lDe;
      if (ab.IV(locald.field_username)) {
        break label345;
      }
    }
    label270:
    label282:
    label345:
    for (Object localObject = this.StV;; localObject = this.StW)
    {
      localTextView.setTextColor((ColorStateList)localObject);
      a.b.C((ImageView)paramViewGroup.lNy.getContentView(), locald.field_username);
      paramViewGroup.StX.setVisibility(8);
      paramViewGroup.lNy.setVisibility(0);
      paramViewGroup.lDe.setText(p.b(this.context, locald.aSV(), paramViewGroup.lDe.getTextSize()));
      paramViewGroup.lDe.setVisibility(0);
      AppMethodBeat.o(38082);
      return paramView;
      paramViewGroup = (SnsTagContactListUI.b)paramView.getTag();
      break;
      localObject = aDx(paramInt - 1);
      break label108;
      if ((paramInt > 0) && (!aDx(paramInt).equals(localObject)))
      {
        paramViewGroup.JMf.setVisibility(0);
        paramViewGroup.JMf.setText(aDx(paramInt));
        paramViewGroup.JMf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        break label153;
      }
      paramViewGroup.JMf.setVisibility(8);
      break label153;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI.a
 * JD-Core Version:    0.7.0.1
 */