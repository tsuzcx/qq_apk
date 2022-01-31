package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ap
  extends AnimatedExpandableListView.a
{
  public static int[] oZR = { i.j.sns_label_public_hint, i.j.sns_label_private_hint, i.j.sns_label_include_hint, i.j.sns_label_exclude_hint };
  public static int[] oZv = { i.j.sns_label_public, i.j.sns_label_private, i.j.sns_label_include, i.j.sns_label_exclude };
  private LayoutInflater Lu;
  private Context mContext;
  ArrayList<String> oZS;
  public int oZT = 0;
  public boolean oZU = false;
  public ArrayList<String> oZV = new ArrayList();
  public ArrayList<String> oZW = new ArrayList();
  public ArrayList<String> oZX = new ArrayList();
  public ArrayList<String> oZY = new ArrayList();
  b oZZ = null;
  public int style;
  
  public ap(Context paramContext)
  {
    this.mContext = paramContext;
    this.Lu = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private static List<String> F(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    g.DQ();
    if (!g.DN().Dc()) {
      return localLinkedList;
    }
    if (paramList == null) {
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      g.DQ();
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.dBe != 0) {
          paramList = localad.Bq();
        }
      }
      localLinkedList.add(paramList);
    }
    return localLinkedList;
  }
  
  public static void Pm(String paramString)
  {
    y.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[] { paramString });
    if (bJe() != null)
    {
      ArrayList localArrayList = new ArrayList(bJe());
      if (!i(localArrayList, paramString))
      {
        if (localArrayList.size() == 5) {
          localArrayList.remove(4);
        }
        localArrayList.add(0, paramString);
        paramString = bk.c(localArrayList, ",");
        g.DQ();
        g.DP().Dz().o(335875, paramString);
      }
      return;
    }
    g.DQ();
    g.DP().Dz().o(335875, paramString);
  }
  
  private CharSequence Pn(String paramString)
  {
    paramString = com.tencent.mm.plugin.label.a.a.bdA().Gl(paramString);
    Object localObject = com.tencent.mm.plugin.label.a.a.bdA().Go(paramString);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return "";
    }
    paramString = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((com.tencent.mm.plugin.messenger.a.b)g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV((String)((Iterator)localObject).next()));
    }
    paramString = bk.c(paramString, ",");
    return com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, paramString);
  }
  
  private boolean aJ(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      return i(this.oZV, paramString);
    }
    return i(this.oZW, paramString);
  }
  
  private static List<String> bJe()
  {
    g.DQ();
    String str = (String)g.DP().Dz().get(335875, null);
    y.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { str });
    if (bk.bl(str)) {
      return null;
    }
    return bk.G(str.split(","));
  }
  
  private static boolean i(List<String> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((String)paramList.next()).equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public final void Q(ArrayList<String> paramArrayList)
  {
    Object localObject2 = bJe();
    Object localObject1 = new ArrayList();
    if ((localObject2 != null) && (paramArrayList != null))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (i(paramArrayList, str))
        {
          paramArrayList.remove(str);
          ((ArrayList)localObject1).add(str);
        }
      }
      paramArrayList.addAll(0, (Collection)localObject1);
      localObject1 = bk.c((List)localObject1, ",");
      g.DQ();
      g.DP().Dz().o(335875, localObject1);
    }
    this.oZS = paramArrayList;
  }
  
  public final View d(int paramInt1, int paramInt2, View paramView)
  {
    ap.a locala;
    label147:
    Object localObject1;
    if (paramView == null) {
      if (this.style == 1)
      {
        paramView = this.Lu.inflate(i.g.sns_label_child_item_black, null);
        locala = new ap.a(this, (byte)0);
        locala.titleView = ((TextView)paramView.findViewById(i.f.sns_label_title));
        locala.lJA = ((TextView)paramView.findViewById(i.f.sns_label_sub_title));
        locala.pab = ((TextView)paramView.findViewById(i.f.sns_label_single_line));
        locala.pac = ((TextView)paramView.findViewById(i.f.sns_label_selected_other_users));
        locala.lZf = ((ImageView)paramView.findViewById(i.f.sns_label_check_img));
        locala.pad = ((ImageView)paramView.findViewById(i.f.sns_label_more_img));
        locala.pad.setOnClickListener(new ap.1(this));
        paramView.setTag(locala);
        localObject1 = locala.pad;
        Object localObject2 = ((View)localObject1).getTag();
        if ((localObject2 != null) && ((localObject2 instanceof c))) {
          break label386;
        }
        localObject2 = new c();
        ((c)localObject2).pae = paramInt1;
        ((c)localObject2).paf = paramInt2;
        ((View)localObject1).setTag(localObject2);
        label203:
        if (paramInt2 != this.oZS.size()) {
          break label542;
        }
        locala.titleView.setVisibility(8);
        locala.lJA.setVisibility(8);
        locala.lZf.setVisibility(8);
        locala.pad.setVisibility(8);
        locala.pab.setVisibility(0);
        locala.pac.setVisibility(0);
        if (paramInt1 != 3) {
          break label433;
        }
        if (this.oZY.size() <= 0) {
          break label411;
        }
        localObject1 = bk.c(F(this.oZY), ",");
        locala.pac.setText("√" + (String)localObject1);
        locala.pac.setVisibility(0);
        locala.pac.setTextColor(this.mContext.getResources().getColor(i.c.sns_selected_other_user_name_color_black));
      }
    }
    label386:
    label411:
    label433:
    do
    {
      do
      {
        do
        {
          return paramView;
          paramView = this.Lu.inflate(i.g.sns_label_child_item, null);
          break;
          locala = (ap.a)paramView.getTag();
          break label147;
          localObject1 = (c)((View)localObject1).getTag();
          ((c)localObject1).pae = paramInt1;
          ((c)localObject1).paf = paramInt2;
          break label203;
          locala.pac.setText("");
          locala.pac.setVisibility(8);
          return paramView;
        } while (paramInt1 != 2);
        if (this.oZX.size() > 0)
        {
          localObject1 = bk.c(F(this.oZX), ",");
          locala.pac.setText("√" + (String)localObject1);
          locala.pac.setVisibility(0);
          locala.pac.setTextColor(this.mContext.getResources().getColor(i.c.sns_selected_other_user_name_color));
          return paramView;
        }
        locala.pac.setText("");
        locala.pac.setVisibility(8);
        return paramView;
        locala.titleView.setVisibility(0);
        locala.lJA.setVisibility(0);
        locala.lZf.setVisibility(0);
        locala.pad.setVisibility(0);
        locala.pab.setVisibility(8);
        locala.pac.setVisibility(8);
        localObject1 = (String)this.oZS.get(paramInt2);
        locala.titleView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, (CharSequence)localObject1));
        locala.lJA.setText(Pn((String)localObject1));
        locala.pad.setImageResource(i.i.sns_label_more_btn);
        if (this.style != 1) {
          break label776;
        }
        if (paramInt1 == 2)
        {
          if (aJ(1, (String)localObject1))
          {
            locala.lZf.setImageResource(i.i.sight_list_checkbox_selected);
            return paramView;
          }
          locala.lZf.setImageResource(i.i.sight_list_checkbox_unselected);
          return paramView;
        }
      } while (paramInt1 != 3);
      if (this.oZT != paramInt1) {
        locala.lZf.setImageResource(i.i.sight_list_checkbox_unselected_red);
      }
      while (aJ(2, (String)localObject1))
      {
        locala.lZf.setImageResource(i.i.sight_list_checkbox_selected_red);
        return paramView;
        locala.lZf.setImageResource(i.i.sight_list_checkbox_selected_red);
      }
      locala.lZf.setImageResource(i.i.sight_list_checkbox_unselected_red);
      return paramView;
      if (paramInt1 == 2)
      {
        if (aJ(1, (String)localObject1))
        {
          locala.lZf.setImageResource(i.i.checkbox_selected);
          return paramView;
        }
        locala.lZf.setImageResource(i.i.checkbox_unselected);
        return paramView;
      }
    } while (paramInt1 != 3);
    label542:
    if (aJ(2, (String)localObject1))
    {
      locala.lZf.setImageResource(i.i.checkbox_selected_red);
      return paramView;
    }
    label776:
    locala.lZf.setImageResource(i.i.checkbox_unselected);
    return paramView;
  }
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    return this.oZS.get(paramInt2);
  }
  
  public final long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public final Object getGroup(int paramInt)
  {
    return null;
  }
  
  public final int getGroupCount()
  {
    return 4;
  }
  
  public final long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public final View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof ap.a))) {
      if (this.style == 1)
      {
        paramView = this.Lu.inflate(i.g.sns_label_expand_item_black, null);
        paramViewGroup = new ap.a(this, (byte)0);
        paramViewGroup.titleView = ((TextView)paramView.findViewById(i.f.sns_label_title));
        paramViewGroup.lZf = ((ImageView)paramView.findViewById(i.f.sns_label_check_img));
        paramViewGroup.lJA = ((TextView)paramView.findViewById(i.f.sns_label_sub_title));
        paramView.setTag(paramViewGroup);
        label96:
        paramViewGroup.titleView.setText(oZv[paramInt]);
        paramViewGroup.lJA.setText(oZR[paramInt]);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      paramViewGroup = paramView;
      if (this.oZU)
      {
        paramViewGroup = paramView;
        if (paramInt == 1)
        {
          paramViewGroup = new View(this.mContext);
          paramViewGroup.setVisibility(8);
        }
      }
      return paramViewGroup;
      paramView = this.Lu.inflate(i.g.sns_label_expand_item, null);
      break;
      paramViewGroup = (ap.a)paramView.getTag();
      break label96;
      if (this.oZT != paramInt)
      {
        paramViewGroup.lZf.setImageResource(i.i.radio_off);
      }
      else
      {
        paramViewGroup.lZf.setImageResource(i.i.radio_on);
        paramViewGroup.lZf.setContentDescription(this.mContext.getString(i.j.selected_Imgbtn));
        continue;
        if (this.oZT != paramInt)
        {
          paramViewGroup.lZf.setImageResource(i.i.radio_off);
        }
        else
        {
          paramViewGroup.lZf.setImageResource(i.i.radio_on);
          paramViewGroup.lZf.setContentDescription(this.mContext.getString(i.j.selected_Imgbtn));
          continue;
          if (this.style == 1)
          {
            if (this.oZT != paramInt)
            {
              paramViewGroup.lZf.setImageResource(i.i.radio_off);
            }
            else
            {
              paramViewGroup.lZf.setImageResource(i.i.round_selector_checked_orange);
              paramViewGroup.lZf.setContentDescription(this.mContext.getString(i.j.selected_Imgbtn));
            }
          }
          else if (this.oZT != paramInt)
          {
            paramViewGroup.lZf.setImageResource(i.i.radio_off);
          }
          else
          {
            paramViewGroup.lZf.setImageResource(i.i.radio_on_red);
            paramViewGroup.lZf.setContentDescription(this.mContext.getString(i.j.selected_Imgbtn));
          }
        }
      }
    }
  }
  
  public final boolean hasStableIds()
  {
    return false;
  }
  
  public final boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public final int yL(int paramInt)
  {
    if ((paramInt > 1) && (this.oZS != null)) {
      return this.oZS.size() + 1;
    }
    return 0;
  }
  
  public static abstract interface b
  {
    public abstract void a(ap.c paramc);
  }
  
  final class c
  {
    public int pae;
    public int paf;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap
 * JD-Core Version:    0.7.0.1
 */