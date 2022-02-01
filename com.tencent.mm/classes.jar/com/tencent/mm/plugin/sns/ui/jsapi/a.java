package com.tencent.mm.plugin.sns.ui.jsapi;

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
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends AnimatedExpandableListView.a
{
  public int RPA;
  int RPG;
  List<String> RPH;
  b RPI;
  boolean RPJ;
  public int RPx;
  public int RPy;
  public int RPz;
  public int[] RsD;
  public int[] Rte;
  ArrayList<String> Rtf;
  public int Rtg;
  public boolean Rth;
  public ArrayList<String> Rti;
  public ArrayList<String> Rtj;
  public ArrayList<String> Rtk;
  public ArrayList<String> Rtl;
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(100178);
    this.RPG = 4;
    this.RPx = 0;
    this.RPy = 1;
    this.RPz = 2;
    this.RPA = 3;
    this.RsD = new int[] { b.j.sns_label_public, b.j.sns_label_private, b.j.sns_label_include, b.j.sns_label_exclude };
    this.Rte = new int[] { b.j.sns_label_public_hint, b.j.sns_label_private_hint, b.j.sns_label_include_hint, b.j.sns_label_exclude_hint };
    this.Rtg = 0;
    this.Rth = false;
    this.Rti = new ArrayList();
    this.Rtj = new ArrayList();
    this.Rtk = new ArrayList();
    this.Rtl = new ArrayList();
    this.RPI = null;
    this.RPJ = true;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    AppMethodBeat.o(100178);
  }
  
  private static boolean F(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(100183);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((String)paramList.next()).equals(paramString))
      {
        AppMethodBeat.o(100183);
        return true;
      }
    }
    AppMethodBeat.o(100183);
    return false;
  }
  
  public static void baH(String paramString)
  {
    AppMethodBeat.i(100182);
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
      AppMethodBeat.o(100182);
      return;
    }
    h.baF();
    h.baE().ban().B(335875, paramString);
    AppMethodBeat.o(100182);
  }
  
  private static List<String> bs(List<String> paramList)
  {
    AppMethodBeat.i(100186);
    LinkedList localLinkedList = new LinkedList();
    h.baF();
    if (!h.baC().aZN())
    {
      AppMethodBeat.o(100186);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(100186);
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
    AppMethodBeat.o(100186);
    return localLinkedList;
  }
  
  private boolean di(int paramInt, String paramString)
  {
    AppMethodBeat.i(100184);
    if (paramInt == 1)
    {
      bool = F(this.Rti, paramString);
      AppMethodBeat.o(100184);
      return bool;
    }
    boolean bool = F(this.Rtj, paramString);
    AppMethodBeat.o(100184);
    return bool;
  }
  
  private static List<String> hoW()
  {
    AppMethodBeat.i(100181);
    h.baF();
    Object localObject = (String)h.baE().ban().d(335875, null);
    Log.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(100181);
      return null;
    }
    localObject = Util.stringsToList(((String)localObject).split(","));
    AppMethodBeat.o(100181);
    return localObject;
  }
  
  public final int amf(int paramInt)
  {
    AppMethodBeat.i(100188);
    if ((("visible".equals(this.RPH.get(paramInt))) || ("invisible".equals(this.RPH.get(paramInt)))) && (this.Rtf != null))
    {
      paramInt = this.Rtf.size();
      AppMethodBeat.o(100188);
      return paramInt + 1;
    }
    AppMethodBeat.o(100188);
    return 0;
  }
  
  public final void bF(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(100180);
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
    AppMethodBeat.o(100180);
  }
  
  public final View d(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(100187);
    a locala;
    label153:
    Object localObject1;
    Object localObject2;
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
            AppMethodBeat.i(100177);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/jsapi/JsapiSnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof a.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (a.c)paramAnonymousView.getTag())
            {
              Log.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/jsapi/JsapiSnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100177);
              return;
            }
            if (a.a(a.this) != null) {
              a.a(a.this).a(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/jsapi/JsapiSnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100177);
          }
        });
        paramView.setTag(locala);
        localObject1 = locala.Rtu;
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 != null) && ((localObject2 instanceof c))) {
          break label394;
        }
        localObject2 = new c();
        ((c)localObject2).Rtv = paramInt1;
        ((c)localObject2).Rtw = paramInt2;
        ((View)localObject1).setTag(localObject2);
        label209:
        if (paramInt2 != this.Rtf.size()) {
          break label551;
        }
        locala.titleView.setVisibility(8);
        locala.KbK.setVisibility(8);
        locala.KKj.setVisibility(8);
        locala.Rtu.setVisibility(8);
        locala.Rts.setVisibility(0);
        locala.Rtt.setVisibility(0);
        if (paramInt1 != this.RPA) {
          break label443;
        }
        if (this.Rtl.size() <= 0) {
          break label419;
        }
        localObject1 = Util.listToString(bs(this.Rtl), ",");
        locala.Rtt.setText("√".concat(String.valueOf(localObject1)));
        locala.Rtt.setVisibility(0);
        locala.Rtt.setTextColor(this.mContext.getResources().getColor(b.c.sns_selected_other_user_name_color_black));
      }
    }
    label394:
    label419:
    label551:
    for (;;)
    {
      AppMethodBeat.o(100187);
      return paramView;
      paramView = this.mInflater.inflate(b.g.sns_label_child_item, null);
      break;
      locala = (a)paramView.getTag();
      break label153;
      localObject1 = (c)((View)localObject1).getTag();
      ((c)localObject1).Rtv = paramInt1;
      ((c)localObject1).Rtw = paramInt2;
      break label209;
      locala.Rtt.setText("");
      locala.Rtt.setVisibility(8);
      continue;
      label443:
      if (paramInt1 == this.RPz) {
        if (this.Rtk.size() > 0)
        {
          localObject1 = Util.listToString(bs(this.Rtk), ",");
          locala.Rtt.setText("√".concat(String.valueOf(localObject1)));
          locala.Rtt.setVisibility(0);
          locala.Rtt.setTextColor(this.mContext.getResources().getColor(b.c.sns_selected_other_user_name_color));
        }
        else
        {
          locala.Rtt.setText("");
          locala.Rtt.setVisibility(8);
          continue;
          locala.titleView.setVisibility(0);
          locala.KbK.setVisibility(0);
          locala.KKj.setVisibility(0);
          locala.Rtu.setVisibility(4);
          locala.Rts.setVisibility(8);
          locala.Rtt.setVisibility(8);
          localObject2 = (String)this.Rtf.get(paramInt2);
          locala.titleView.setText(p.b(this.mContext, (CharSequence)localObject2));
          TextView localTextView = locala.KbK;
          localObject1 = com.tencent.mm.plugin.label.a.a.fTb().aJH((String)localObject2);
          Object localObject3 = com.tencent.mm.plugin.label.a.a.fTb().aJK((String)localObject1);
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {}
          for (localObject1 = "";; localObject1 = p.b(this.mContext, (CharSequence)localObject1))
          {
            localTextView.setText((CharSequence)localObject1);
            locala.Rtu.setImageResource(b.i.sns_label_more_btn);
            if (this.style != 1) {
              break label930;
            }
            if (paramInt1 != this.RPz) {
              break label851;
            }
            if (!di(1, (String)localObject2)) {
              break label837;
            }
            locala.KKj.setImageResource(b.i.sight_list_checkbox_selected);
            break;
            localObject1 = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)((Iterator)localObject3).next()));
            }
            localObject1 = Util.listToString((List)localObject1, ",");
          }
          label837:
          locala.KKj.setImageResource(b.i.sight_list_checkbox_unselected);
          continue;
          label851:
          if (paramInt1 == this.RPA)
          {
            if (this.Rtg != paramInt1) {
              locala.KKj.setImageResource(b.i.sight_list_checkbox_unselected_red);
            }
            for (;;)
            {
              if (!di(2, (String)localObject2)) {
                break label916;
              }
              locala.KKj.setImageResource(b.i.sight_list_checkbox_selected_red);
              break;
              locala.KKj.setImageResource(b.i.sight_list_checkbox_selected_red);
            }
            locala.KKj.setImageResource(b.i.sight_list_checkbox_unselected_red);
            continue;
            if (paramInt1 == this.RPz)
            {
              if (di(1, (String)localObject2)) {
                locala.KKj.setImageResource(b.i.checkbox_selected);
              } else {
                locala.KKj.setImageResource(b.e.checkbox_unselected);
              }
            }
            else if (paramInt1 == this.RPA) {
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
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100179);
    Object localObject = this.Rtf.get(paramInt2);
    AppMethodBeat.o(100179);
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
    return this.RPG;
  }
  
  public final long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public final View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(100185);
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
        paramViewGroup.titleView.setText(this.RsD[paramInt]);
        paramViewGroup.KbK.setText(this.Rte[paramInt]);
        if ((paramInt != this.RPy) && (paramInt != this.RPx)) {
          break label265;
        }
        if (this.Rtg == paramInt) {
          break label233;
        }
        paramViewGroup.KKj.setImageResource(b.i.radio_off);
      }
    }
    for (;;)
    {
      if ((!this.Rth) || (paramInt != this.RPy)) {
        break label451;
      }
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(100185);
      return paramView;
      paramView = this.mInflater.inflate(b.g.sns_label_expand_item, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label102;
      label233:
      paramViewGroup.KKj.setImageResource(b.i.radio_on);
      paramViewGroup.KKj.setContentDescription(this.mContext.getString(b.j.selected_Imgbtn));
      continue;
      label265:
      if (paramInt == this.RPz)
      {
        if (this.Rtg != paramInt)
        {
          paramViewGroup.KKj.setImageResource(b.i.radio_off);
        }
        else
        {
          paramViewGroup.KKj.setImageResource(b.i.radio_on);
          paramViewGroup.KKj.setContentDescription(this.mContext.getString(b.j.selected_Imgbtn));
        }
      }
      else if (paramInt == this.RPA) {
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
    label451:
    AppMethodBeat.o(100185);
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
    public abstract void a(a.c paramc);
  }
  
  final class c
  {
    public int Rtv;
    public int Rtw;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.a
 * JD-Core Version:    0.7.0.1
 */