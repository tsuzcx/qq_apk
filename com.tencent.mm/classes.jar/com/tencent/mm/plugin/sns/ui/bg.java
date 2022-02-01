package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bg
  extends AnimatedExpandableListView.a
{
  public static int[] RsD = { b.j.sns_label_public, b.j.sns_label_private, b.j.sns_label_include, b.j.sns_label_exclude };
  public static int Rtb = 0;
  public static int Rtc = 1;
  public static int Rtd = 2;
  public static int[] Rte = { b.j.sns_label_public_hint, b.j.sns_label_private_hint, b.j.sns_label_include_hint, b.j.sns_label_exclude_hint };
  public boolean RsK;
  private ArrayList<String> Rtf;
  public int Rtg;
  public boolean Rth;
  public ArrayList<String> Rti;
  public ArrayList<String> Rtj;
  public ArrayList<String> Rtk;
  public ArrayList<String> Rtl;
  public ArrayList<String> Rtm;
  public ArrayList<String> Rtn;
  public ArrayList<String> Rto;
  public ArrayList<String> Rtp;
  b Rtq;
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  
  public bg(Context paramContext)
  {
    AppMethodBeat.i(98824);
    this.Rtg = 0;
    this.RsK = false;
    this.Rth = false;
    this.Rti = new ArrayList();
    this.Rtj = new ArrayList();
    this.Rtk = new ArrayList();
    this.Rtl = new ArrayList();
    this.Rtm = new ArrayList();
    this.Rtn = new ArrayList();
    this.Rto = new ArrayList();
    this.Rtp = new ArrayList();
    this.Rtq = null;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    int i;
    if (((c)h.ax(c.class)).a(c.a.zeX, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label227;
      }
      Rtb = 0;
    }
    for (Rtc = 1;; Rtc = 0)
    {
      Rtd = Rtc + 1;
      Log.i("MicroMsg.Sns.AnimatedExpandableListAdapter", "initWithConfig %s %s %s", new Object[] { Integer.valueOf(Rtb), Integer.valueOf(Rtc), Integer.valueOf(Rtd) });
      AppMethodBeat.o(98824);
      return;
      i = 0;
      break;
      label227:
      Rtb = -1;
    }
  }
  
  private static boolean F(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(98829);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((String)paramList.next()).equals(paramString))
      {
        AppMethodBeat.o(98829);
        return true;
      }
    }
    AppMethodBeat.o(98829);
    return false;
  }
  
  public static void baH(String paramString)
  {
    AppMethodBeat.i(98828);
    Log.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[] { paramString });
    if (hoW() != null)
    {
      ArrayList localArrayList = new ArrayList(hoW());
      if (!F(localArrayList, paramString))
      {
        if (localArrayList.size() == 5) {
          localArrayList.remove(4);
        }
        localArrayList.add(0, paramString);
        paramString = Util.listToString(localArrayList, ",");
        h.baF();
        h.baE().ban().B(335875, paramString);
      }
      AppMethodBeat.o(98828);
      return;
    }
    h.baF();
    h.baE().ban().B(335875, paramString);
    AppMethodBeat.o(98828);
  }
  
  private static List<String> bs(List<String> paramList)
  {
    AppMethodBeat.i(98832);
    LinkedList localLinkedList = new LinkedList();
    h.baF();
    if (!h.baC().aZN())
    {
      AppMethodBeat.o(98832);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(98832);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      h.baF();
      au localau = ((n)h.ax(n.class)).bzA().JE(str);
      paramList = str;
      if (localau != null)
      {
        paramList = str;
        if ((int)localau.maN != 0) {
          paramList = localau.aSV();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(98832);
    return localLinkedList;
  }
  
  private boolean di(int paramInt, String paramString)
  {
    AppMethodBeat.i(98830);
    if (paramInt == 1)
    {
      bool = F(this.Rti, paramString);
      AppMethodBeat.o(98830);
      return bool;
    }
    boolean bool = F(this.Rtj, paramString);
    AppMethodBeat.o(98830);
    return bool;
  }
  
  private static List<String> hoW()
  {
    AppMethodBeat.i(98827);
    h.baF();
    Object localObject = (String)h.baE().ban().d(335875, null);
    Log.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(98827);
      return null;
    }
    localObject = Util.stringsToList(((String)localObject).split(","));
    AppMethodBeat.o(98827);
    return localObject;
  }
  
  public final int amf(int paramInt)
  {
    AppMethodBeat.i(98834);
    if ((paramInt > 1) && (this.Rtf != null))
    {
      paramInt = this.Rtf.size();
      int i = Rtd;
      AppMethodBeat.o(98834);
      return paramInt + i;
    }
    AppMethodBeat.o(98834);
    return 0;
  }
  
  public final void bF(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(98826);
    Object localObject2 = hoW();
    Object localObject1 = new ArrayList();
    if ((localObject2 != null) && (paramArrayList != null))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (F(paramArrayList, str))
        {
          paramArrayList.remove(str);
          ((ArrayList)localObject1).add(str);
        }
      }
      paramArrayList.addAll(0, (Collection)localObject1);
      localObject1 = Util.listToString((List)localObject1, ",");
      h.baF();
      h.baE().ban().B(335875, localObject1);
    }
    this.Rtf = paramArrayList;
    AppMethodBeat.o(98826);
  }
  
  public final View d(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(98833);
    a locala;
    label153:
    Object localObject1;
    if (paramView == null) {
      if (this.style == 1)
      {
        paramView = this.mInflater.inflate(b.g.sns_label_child_item_black, null);
        locala = new a((byte)0);
        locala.titleView = ((TextView)paramView.findViewById(b.f.sns_label_title));
        locala.KbK = ((TextView)paramView.findViewById(b.f.sns_label_sub_title));
        locala.Rts = ((TextView)paramView.findViewById(b.f.sns_label_single_line));
        locala.Rtt = ((TextView)paramView.findViewById(b.f.sns_label_selected_other_users));
        locala.KKj = ((ImageView)paramView.findViewById(b.f.sns_label_check_img));
        locala.Rtu = ((ImageView)paramView.findViewById(b.f.sns_label_more_img));
        locala.Rtu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98823);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof bg.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (bg.c)paramAnonymousView.getTag())
            {
              Log.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98823);
              return;
            }
            if (bg.a(bg.this) != null) {
              bg.a(bg.this).a(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98823);
          }
        });
        paramView.setTag(locala);
        if (paramInt2 != Rtc) {
          break label511;
        }
        locala.titleView.setVisibility(8);
        locala.KbK.setVisibility(8);
        locala.KKj.setVisibility(8);
        locala.Rtu.setVisibility(8);
        locala.Rts.setVisibility(0);
        locala.Rts.setText(this.mContext.getResources().getString(b.j.sns_label_select_contact));
        locala.Rtt.setVisibility(0);
        if (paramInt1 != 3) {
          break label391;
        }
        if (this.Rtl.size() <= 0) {
          break label367;
        }
        localObject1 = Util.listToString(bs(this.Rtl), ",");
        locala.Rtt.setText(p.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.Rtt.getTextSize()));
        locala.Rtt.setVisibility(0);
        locala.Rtt.setTextColor(this.mContext.getResources().getColor(b.c.sns_selected_other_user_name_color_black));
      }
    }
    label391:
    label1197:
    label1211:
    for (;;)
    {
      AppMethodBeat.o(98833);
      return paramView;
      paramView = this.mInflater.inflate(b.g.sns_label_child_item, null);
      break;
      locala = (a)paramView.getTag();
      break label153;
      label367:
      locala.Rtt.setText("");
      locala.Rtt.setVisibility(8);
      continue;
      label1106:
      if (paramInt1 == 2) {
        label869:
        label1273:
        if (this.Rtk.size() > 0)
        {
          localObject1 = Util.listToString(bs(this.Rtk), ",");
          locala.Rtt.setText(p.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.Rtt.getTextSize()));
          locala.Rtt.setVisibility(0);
          locala.Rtt.setTextColor(this.mContext.getResources().getColor(b.c.sns_selected_other_user_name_color));
        }
        else
        {
          locala.Rtt.setText("");
          locala.Rtt.setVisibility(8);
          continue;
          label511:
          if (paramInt2 == Rtb)
          {
            locala.titleView.setVisibility(8);
            locala.KbK.setVisibility(8);
            locala.KKj.setVisibility(8);
            locala.Rtu.setVisibility(8);
            locala.Rts.setVisibility(0);
            locala.Rts.setText(this.mContext.getResources().getString(b.j.sns_label_select_group));
            locala.Rtt.setVisibility(0);
            if (paramInt1 == 3)
            {
              if (this.Rtn.size() > 0)
              {
                localObject1 = Util.listToString(bs(this.Rtn), ",");
                locala.Rtt.setText("√".concat(String.valueOf(localObject1)));
                locala.Rtt.setVisibility(0);
                locala.Rtt.setTextColor(this.mContext.getResources().getColor(b.c.sns_selected_other_user_name_color_black));
              }
              else
              {
                locala.Rtt.setText("");
                locala.Rtt.setVisibility(8);
              }
            }
            else if (paramInt1 == 2) {
              if (this.Rtm.size() > 0)
              {
                localObject1 = Util.listToString(bs(this.Rtm), ",");
                locala.Rtt.setText("√".concat(String.valueOf(localObject1)));
                locala.Rtt.setVisibility(0);
                locala.Rtt.setTextColor(this.mContext.getResources().getColor(b.c.sns_selected_other_user_name_color));
              }
              else
              {
                locala.Rtt.setText("");
                locala.Rtt.setVisibility(8);
              }
            }
          }
          else
          {
            paramInt2 -= Rtd;
            localObject1 = locala.Rtu;
            Object localObject2 = ((View)localObject1).getTag();
            TextView localTextView;
            Object localObject3;
            if ((localObject2 == null) || (!(localObject2 instanceof c)))
            {
              localObject2 = new c();
              ((c)localObject2).Rtv = paramInt1;
              ((c)localObject2).Rtw = paramInt2;
              ((View)localObject1).setTag(localObject2);
              locala.titleView.setVisibility(0);
              locala.KbK.setVisibility(0);
              locala.KKj.setVisibility(0);
              locala.Rtu.setVisibility(0);
              locala.Rts.setVisibility(8);
              locala.Rtt.setVisibility(8);
              localObject2 = (String)this.Rtf.get(paramInt2);
              locala.titleView.setText(p.b(this.mContext, (CharSequence)localObject2));
              localTextView = locala.KbK;
              localObject1 = com.tencent.mm.plugin.label.a.a.fTb().aJH((String)localObject2);
              localObject3 = com.tencent.mm.plugin.label.a.a.fTb().aJK((String)localObject1);
              if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
                break label1106;
              }
            }
            for (localObject1 = "";; localObject1 = p.b(this.mContext, (CharSequence)localObject1))
            {
              localTextView.setText((CharSequence)localObject1);
              locala.Rtu.setImageDrawable(bb.m(this.mContext, b.i.sns_label_more_btn, this.mContext.getResources().getColor(b.c.BW_50)));
              if (this.style != 1) {
                break label1287;
              }
              if (paramInt1 != 2) {
                break label1211;
              }
              if (!di(1, (String)localObject2)) {
                break label1197;
              }
              locala.KKj.setImageResource(b.i.sight_list_checkbox_selected);
              break;
              localObject1 = (c)((View)localObject1).getTag();
              ((c)localObject1).Rtv = paramInt1;
              ((c)localObject1).Rtw = paramInt2;
              break label869;
              localObject1 = new ArrayList(((List)localObject3).size());
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)((Iterator)localObject3).next()));
              }
              localObject1 = Util.listToString((List)localObject1, ",");
            }
            locala.KKj.setImageResource(b.i.sight_list_checkbox_unselected);
            continue;
            if (paramInt1 == 3)
            {
              if (this.Rtg != paramInt1) {
                locala.KKj.setImageResource(b.i.sight_list_checkbox_unselected_red);
              }
              for (;;)
              {
                if (!di(2, (String)localObject2)) {
                  break label1273;
                }
                locala.KKj.setImageResource(b.i.sight_list_checkbox_selected_red);
                break;
                locala.KKj.setImageResource(b.i.sight_list_checkbox_selected_red);
              }
              locala.KKj.setImageResource(b.i.sight_list_checkbox_unselected_red);
              continue;
              if (paramInt1 == 2)
              {
                if (di(1, (String)localObject2)) {
                  locala.KKj.setImageResource(b.i.checkbox_selected);
                } else {
                  locala.KKj.setImageResource(b.e.checkbox_unselected);
                }
              }
              else if (paramInt1 == 3) {
                if (di(2, (String)localObject2)) {
                  locala.KKj.setImageResource(b.i.checkbox_selected_red);
                } else {
                  locala.KKj.setImageResource(b.e.checkbox_unselected);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98825);
    Object localObject = this.Rtf.get(paramInt2);
    AppMethodBeat.o(98825);
    return localObject;
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
    AppMethodBeat.i(98831);
    if ((paramView == null) || (!(paramView.getTag() instanceof a))) {
      if (this.style == 1)
      {
        paramView = this.mInflater.inflate(b.g.sns_label_expand_item_black, null);
        paramViewGroup = new a((byte)0);
        paramViewGroup.titleView = ((TextView)paramView.findViewById(b.f.sns_label_title));
        paramViewGroup.KKj = ((ImageView)paramView.findViewById(b.f.sns_label_check_img));
        paramViewGroup.KbK = ((TextView)paramView.findViewById(b.f.sns_label_sub_title));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(RsD[paramInt]);
        paramViewGroup.KbK.setText(Rte[paramInt]);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      if ((!this.Rth) || (paramInt != 1)) {
        break label449;
      }
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(98831);
      return paramView;
      paramView = this.mInflater.inflate(b.g.sns_label_expand_item, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label102;
      if (this.Rtg != paramInt)
      {
        paramViewGroup.KKj.setImageResource(b.i.radio_off);
      }
      else
      {
        paramViewGroup.KKj.setImageResource(b.i.radio_on);
        paramViewGroup.KKj.setContentDescription(this.mContext.getString(b.j.selected_Imgbtn));
        continue;
        if (this.Rtg != paramInt)
        {
          paramViewGroup.KKj.setImageResource(b.i.radio_off);
        }
        else
        {
          paramViewGroup.KKj.setImageResource(b.i.radio_on);
          paramViewGroup.KKj.setContentDescription(this.mContext.getString(b.j.selected_Imgbtn));
          continue;
          if (this.style == 1)
          {
            if (this.Rtg != paramInt)
            {
              paramViewGroup.KKj.setImageResource(b.i.radio_off);
            }
            else
            {
              paramViewGroup.KKj.setImageResource(b.i.round_selector_checked_orange);
              paramViewGroup.KKj.setContentDescription(this.mContext.getString(b.j.selected_Imgbtn));
            }
          }
          else if (this.Rtg != paramInt)
          {
            paramViewGroup.KKj.setImageResource(b.i.radio_off);
          }
          else
          {
            paramViewGroup.KKj.setImageResource(b.i.radio_on_red);
            paramViewGroup.KKj.setContentDescription(this.mContext.getString(b.j.selected_Imgbtn));
          }
        }
      }
    }
    label449:
    if ((this.RsK) && ((paramInt == 1) || (paramInt == 2)))
    {
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(98831);
      return paramView;
    }
    AppMethodBeat.o(98831);
    return paramView;
  }
  
  public final boolean hasStableIds()
  {
    return false;
  }
  
  public final boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  final class a
  {
    ImageView KKj;
    TextView KbK;
    TextView Rts;
    TextView Rtt;
    ImageView Rtu;
    TextView titleView;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(bg.c paramc);
  }
  
  final class c
  {
    public int Rtv;
    public int Rtw;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bg
 * JD-Core Version:    0.7.0.1
 */