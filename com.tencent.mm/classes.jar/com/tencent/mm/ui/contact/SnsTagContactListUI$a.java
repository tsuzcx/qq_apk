package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.y;
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
  private Context context = null;
  private bd oWj = null;
  private Map<Integer, a> vNV = new HashMap();
  private ColorStateList vNW;
  private ColorStateList vNX;
  private Map<Integer, String> vOd = new HashMap();
  
  public SnsTagContactListUI$a(Context paramContext, List<Long> paramList)
  {
    this.context = paramContext;
    this.vNV.clear();
    this.vOd.clear();
    au.Hx();
    this.oWj = c.Fw();
    paramList = paramList.iterator();
    Object localObject;
    int j;
    for (int i = 0; paramList.hasNext(); i = j)
    {
      long l = ((Long)paramList.next()).longValue();
      localObject = n.omF;
      j = i;
      if (localObject != null)
      {
        Iterator localIterator = ((k)localObject).fL(l).iterator();
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          String str = (String)localIterator.next();
          a locala = new a();
          locala.setUsername(str);
          this.vOd.put(Integer.valueOf(this.vNV.size()), ((k)localObject).fM(l));
          this.vNV.put(Integer.valueOf(i), locala);
          i += 1;
        }
      }
    }
    try
    {
      paramList = paramContext.getResources().getXml(R.e.mm_list_textcolor_one);
      localObject = paramContext.getResources().getXml(R.e.mm_list_textcolor_spuser);
      this.vNW = ColorStateList.createFromXml(paramContext.getResources(), paramList);
      this.vNX = ColorStateList.createFromXml(paramContext.getResources(), (XmlPullParser)localObject);
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      y.printErrStackTrace("MicroMsg.SnsTagContactList", paramContext, "", new Object[0]);
      return;
    }
    catch (IOException paramContext)
    {
      y.printErrStackTrace("MicroMsg.SnsTagContactList", paramContext, "", new Object[0]);
    }
  }
  
  private String HN(int paramInt)
  {
    if (!this.vOd.containsKey(Integer.valueOf(paramInt))) {
      return "";
    }
    return (String)this.vOd.get(Integer.valueOf(paramInt));
  }
  
  public final int getCount()
  {
    return this.vNV.size();
  }
  
  public final Object getItem(int paramInt)
  {
    Object localObject;
    if (paramInt < 0) {
      localObject = null;
    }
    ad localad;
    do
    {
      a locala;
      do
      {
        return localObject;
        locala = (a)this.vNV.get(Integer.valueOf(paramInt));
        localObject = locala;
      } while (locala.field_showHead != 0);
      localad = this.oWj.abl(locala.field_username);
      localObject = locala;
    } while (localad == null);
    this.vNV.put(Integer.valueOf(paramInt), localad);
    return localad;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label103:
    a locala;
    label148:
    TextView localTextView;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.contact_item, null);
      paramViewGroup = new SnsTagContactListUI.b((byte)0);
      paramViewGroup.lvb = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
      paramViewGroup.dsk = ((MaskLayout)paramView.findViewById(R.h.contactitem_avatar));
      paramViewGroup.drB = ((TextView)paramView.findViewById(R.h.contactitem_nick));
      paramViewGroup.vNZ = ((TextView)paramView.findViewById(R.h.contactitem_account));
      paramView.setTag(paramViewGroup);
      if ((a)getItem(paramInt - 1) != null) {
        break label260;
      }
      localObject = "";
      locala = (a)getItem(paramInt);
      if (paramInt != 0) {
        break label272;
      }
      paramViewGroup.lvb.setVisibility(0);
      paramViewGroup.lvb.setText(HN(paramInt));
      paramViewGroup.lvb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      localTextView = paramViewGroup.drB;
      if (s.hU(locala.field_username)) {
        break label335;
      }
    }
    label260:
    label272:
    label335:
    for (Object localObject = this.vNW;; localObject = this.vNX)
    {
      localTextView.setTextColor((ColorStateList)localObject);
      a.b.p((ImageView)paramViewGroup.dsk.getContentView(), locala.field_username);
      paramViewGroup.vNZ.setVisibility(8);
      paramViewGroup.dsk.setVisibility(0);
      paramViewGroup.drB.setText(j.a(this.context, locala.Bq(), paramViewGroup.drB.getTextSize()));
      paramViewGroup.drB.setVisibility(0);
      return paramView;
      paramViewGroup = (SnsTagContactListUI.b)paramView.getTag();
      break;
      localObject = HN(paramInt - 1);
      break label103;
      if ((paramInt > 0) && (!HN(paramInt).equals(localObject)))
      {
        paramViewGroup.lvb.setVisibility(0);
        paramViewGroup.lvb.setText(HN(paramInt));
        paramViewGroup.lvb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        break label148;
      }
      paramViewGroup.lvb.setVisibility(8);
      break label148;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI.a
 * JD-Core Version:    0.7.0.1
 */