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
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
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
  private Map<Integer, a> AfD;
  private ColorStateList AfE;
  private ColorStateList AfF;
  private Map<Integer, String> AfL;
  private Context context;
  private bd rOH;
  
  public SnsTagContactListUI$a(Context paramContext, List<Long> paramList)
  {
    AppMethodBeat.i(33957);
    this.context = null;
    this.AfD = new HashMap();
    this.AfL = new HashMap();
    this.rOH = null;
    this.context = paramContext;
    this.AfD.clear();
    this.AfL.clear();
    aw.aaz();
    this.rOH = c.YA();
    paramList = paramList.iterator();
    Object localObject;
    int j;
    for (int i = 0; paramList.hasNext(); i = j)
    {
      long l = ((Long)paramList.next()).longValue();
      localObject = n.raT;
      j = i;
      if (localObject != null)
      {
        Iterator localIterator = ((k)localObject).lo(l).iterator();
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          String str = (String)localIterator.next();
          a locala = new a();
          locala.setUsername(str);
          this.AfL.put(Integer.valueOf(this.AfD.size()), ((k)localObject).lp(l));
          this.AfD.put(Integer.valueOf(i), locala);
          i += 1;
        }
      }
    }
    try
    {
      paramList = paramContext.getResources().getXml(2131690768);
      localObject = paramContext.getResources().getXml(2131690769);
      this.AfE = ColorStateList.createFromXml(paramContext.getResources(), paramList);
      this.AfF = ColorStateList.createFromXml(paramContext.getResources(), (XmlPullParser)localObject);
      AppMethodBeat.o(33957);
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.SnsTagContactList", paramContext, "", new Object[0]);
      AppMethodBeat.o(33957);
      return;
    }
    catch (IOException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.SnsTagContactList", paramContext, "", new Object[0]);
      AppMethodBeat.o(33957);
    }
  }
  
  private String Qw(int paramInt)
  {
    AppMethodBeat.i(33961);
    if (!this.AfL.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(33961);
      return "";
    }
    String str = (String)this.AfL.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(33961);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(33958);
    int i = this.AfD.size();
    AppMethodBeat.o(33958);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(33959);
    if (paramInt < 0)
    {
      AppMethodBeat.o(33959);
      return null;
    }
    a locala = (a)this.AfD.get(Integer.valueOf(paramInt));
    Object localObject = locala;
    if (locala.field_showHead == 0)
    {
      ad localad = this.rOH.arw(locala.field_username);
      localObject = locala;
      if (localad != null)
      {
        this.AfD.put(Integer.valueOf(paramInt), localad);
        localObject = localad;
      }
    }
    AppMethodBeat.o(33959);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33960);
    label103:
    a locala;
    label148:
    TextView localTextView;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2130969256, null);
      paramViewGroup = new SnsTagContactListUI.b((byte)0);
      paramViewGroup.nSs = ((TextView)paramView.findViewById(2131821089));
      paramViewGroup.ejS = ((MaskLayout)paramView.findViewById(2131821092));
      paramViewGroup.ejj = ((TextView)paramView.findViewById(2131821099));
      paramViewGroup.AfH = ((TextView)paramView.findViewById(2131821100));
      paramView.setTag(paramViewGroup);
      if ((a)getItem(paramInt - 1) != null) {
        break label265;
      }
      localObject = "";
      locala = (a)getItem(paramInt);
      if (paramInt != 0) {
        break label277;
      }
      paramViewGroup.nSs.setVisibility(0);
      paramViewGroup.nSs.setText(Qw(paramInt));
      paramViewGroup.nSs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      localTextView = paramViewGroup.ejj;
      if (t.oD(locala.field_username)) {
        break label340;
      }
    }
    label265:
    label277:
    label340:
    for (Object localObject = this.AfE;; localObject = this.AfF)
    {
      localTextView.setTextColor((ColorStateList)localObject);
      a.b.u((ImageView)paramViewGroup.ejS.getContentView(), locala.field_username);
      paramViewGroup.AfH.setVisibility(8);
      paramViewGroup.ejS.setVisibility(0);
      paramViewGroup.ejj.setText(j.b(this.context, locala.Of(), paramViewGroup.ejj.getTextSize()));
      paramViewGroup.ejj.setVisibility(0);
      AppMethodBeat.o(33960);
      return paramView;
      paramViewGroup = (SnsTagContactListUI.b)paramView.getTag();
      break;
      localObject = Qw(paramInt - 1);
      break label103;
      if ((paramInt > 0) && (!Qw(paramInt).equals(localObject)))
      {
        paramViewGroup.nSs.setVisibility(0);
        paramViewGroup.nSs.setText(Qw(paramInt));
        paramViewGroup.nSs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        break label148;
      }
      paramViewGroup.nSs.setVisibility(8);
      break label148;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI.a
 * JD-Core Version:    0.7.0.1
 */