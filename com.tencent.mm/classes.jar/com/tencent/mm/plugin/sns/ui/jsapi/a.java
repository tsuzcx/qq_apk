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
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends AnimatedExpandableListView.a
{
  public int[] KSE;
  public int[] KTg;
  ArrayList<String> KTh;
  public int KTi;
  public boolean KTj;
  public ArrayList<String> KTk;
  public ArrayList<String> KTl;
  public ArrayList<String> KTm;
  public ArrayList<String> KTn;
  int LoB;
  List<String> LoC;
  b LoD;
  boolean LoE;
  public int Los;
  public int Lot;
  public int Lou;
  public int Lov;
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(100178);
    this.LoB = 4;
    this.Los = 0;
    this.Lot = 1;
    this.Lou = 2;
    this.Lov = 3;
    this.KSE = new int[] { i.j.sns_label_public, i.j.sns_label_private, i.j.sns_label_include, i.j.sns_label_exclude };
    this.KTg = new int[] { i.j.sns_label_public_hint, i.j.sns_label_private_hint, i.j.sns_label_include_hint, i.j.sns_label_exclude_hint };
    this.KTi = 0;
    this.KTj = false;
    this.KTk = new ArrayList();
    this.KTl = new ArrayList();
    this.KTm = new ArrayList();
    this.KTn = new ArrayList();
    this.LoD = null;
    this.LoE = true;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    AppMethodBeat.o(100178);
  }
  
  private static List<String> S(List<String> paramList)
  {
    AppMethodBeat.i(100186);
    LinkedList localLinkedList = new LinkedList();
    h.aHH();
    if (!h.aHE().aGM())
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
      h.aHH();
      as localas = ((n)h.ae(n.class)).bbL().RG(str);
      paramList = str;
      if (localas != null)
      {
        paramList = str;
        if ((int)localas.jxt != 0) {
          paramList = localas.ays();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(100186);
    return localLinkedList;
  }
  
  public static void bcc(String paramString)
  {
    AppMethodBeat.i(100182);
    Log.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[] { paramString });
    if (fWF() != null)
    {
      ArrayList localArrayList = new ArrayList(fWF());
      if (!r(localArrayList, paramString))
      {
        if (localArrayList.size() == 5) {
          localArrayList.remove(4);
        }
        localArrayList.add(0, paramString);
        paramString = Util.listToString(localArrayList, ",");
        h.aHH();
        h.aHG().aHp().i(335875, paramString);
      }
      AppMethodBeat.o(100182);
      return;
    }
    h.aHH();
    h.aHG().aHp().i(335875, paramString);
    AppMethodBeat.o(100182);
  }
  
  private boolean cv(int paramInt, String paramString)
  {
    AppMethodBeat.i(100184);
    if (paramInt == 1)
    {
      bool = r(this.KTk, paramString);
      AppMethodBeat.o(100184);
      return bool;
    }
    boolean bool = r(this.KTl, paramString);
    AppMethodBeat.o(100184);
    return bool;
  }
  
  private static List<String> fWF()
  {
    AppMethodBeat.i(100181);
    h.aHH();
    Object localObject = (String)h.aHG().aHp().b(335875, null);
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
  
  private static boolean r(List<String> paramList, String paramString)
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
  
  public final int ahl(int paramInt)
  {
    AppMethodBeat.i(100188);
    if ((("visible".equals(this.LoC.get(paramInt))) || ("invisible".equals(this.LoC.get(paramInt)))) && (this.KTh != null))
    {
      paramInt = this.KTh.size();
      AppMethodBeat.o(100188);
      return paramInt + 1;
    }
    AppMethodBeat.o(100188);
    return 0;
  }
  
  public final void bf(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(100180);
    Object localObject2 = fWF();
    Object localObject1 = new ArrayList();
    if ((localObject2 != null) && (paramArrayList != null))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (r(paramArrayList, str))
        {
          paramArrayList.remove(str);
          ((ArrayList)localObject1).add(str);
        }
      }
      paramArrayList.addAll(0, (Collection)localObject1);
      localObject1 = Util.listToString((List)localObject1, ",");
      h.aHH();
      h.aHG().aHp().i(335875, localObject1);
    }
    this.KTh = paramArrayList;
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
        paramView = this.mInflater.inflate(i.g.sns_label_child_item_black, null);
        locala = new a((byte)0);
        locala.titleView = ((TextView)paramView.findViewById(i.f.sns_label_title));
        locala.EqJ = ((TextView)paramView.findViewById(i.f.sns_label_sub_title));
        locala.KTv = ((TextView)paramView.findViewById(i.f.sns_label_single_line));
        locala.KTw = ((TextView)paramView.findViewById(i.f.sns_label_selected_other_users));
        locala.EPM = ((ImageView)paramView.findViewById(i.f.sns_label_check_img));
        locala.KTx = ((ImageView)paramView.findViewById(i.f.sns_label_more_img));
        locala.KTx.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(100177);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/jsapi/JsapiSnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
        localObject1 = locala.KTx;
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 != null) && ((localObject2 instanceof c))) {
          break label394;
        }
        localObject2 = new c();
        ((c)localObject2).KTy = paramInt1;
        ((c)localObject2).KTz = paramInt2;
        ((View)localObject1).setTag(localObject2);
        label209:
        if (paramInt2 != this.KTh.size()) {
          break label551;
        }
        locala.titleView.setVisibility(8);
        locala.EqJ.setVisibility(8);
        locala.EPM.setVisibility(8);
        locala.KTx.setVisibility(8);
        locala.KTv.setVisibility(0);
        locala.KTw.setVisibility(0);
        if (paramInt1 != this.Lov) {
          break label443;
        }
        if (this.KTn.size() <= 0) {
          break label419;
        }
        localObject1 = Util.listToString(S(this.KTn), ",");
        locala.KTw.setText("√".concat(String.valueOf(localObject1)));
        locala.KTw.setVisibility(0);
        locala.KTw.setTextColor(this.mContext.getResources().getColor(i.c.sns_selected_other_user_name_color_black));
      }
    }
    label394:
    label419:
    label551:
    for (;;)
    {
      AppMethodBeat.o(100187);
      return paramView;
      paramView = this.mInflater.inflate(i.g.sns_label_child_item, null);
      break;
      locala = (a)paramView.getTag();
      break label153;
      localObject1 = (c)((View)localObject1).getTag();
      ((c)localObject1).KTy = paramInt1;
      ((c)localObject1).KTz = paramInt2;
      break label209;
      locala.KTw.setText("");
      locala.KTw.setVisibility(8);
      continue;
      label443:
      if (paramInt1 == this.Lou) {
        if (this.KTm.size() > 0)
        {
          localObject1 = Util.listToString(S(this.KTm), ",");
          locala.KTw.setText("√".concat(String.valueOf(localObject1)));
          locala.KTw.setVisibility(0);
          locala.KTw.setTextColor(this.mContext.getResources().getColor(i.c.sns_selected_other_user_name_color));
        }
        else
        {
          locala.KTw.setText("");
          locala.KTw.setVisibility(8);
          continue;
          locala.titleView.setVisibility(0);
          locala.EqJ.setVisibility(0);
          locala.EPM.setVisibility(0);
          locala.KTx.setVisibility(4);
          locala.KTv.setVisibility(8);
          locala.KTw.setVisibility(8);
          localObject2 = (String)this.KTh.get(paramInt2);
          locala.titleView.setText(l.c(this.mContext, (CharSequence)localObject2));
          TextView localTextView = locala.EqJ;
          localObject1 = com.tencent.mm.plugin.label.a.a.eLe().aMO((String)localObject2);
          Object localObject3 = com.tencent.mm.plugin.label.a.a.eLe().aMR((String)localObject1);
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {}
          for (localObject1 = "";; localObject1 = l.c(this.mContext, (CharSequence)localObject1))
          {
            localTextView.setText((CharSequence)localObject1);
            locala.KTx.setImageResource(i.i.sns_label_more_btn);
            if (this.style != 1) {
              break label930;
            }
            if (paramInt1 != this.Lou) {
              break label851;
            }
            if (!cv(1, (String)localObject2)) {
              break label837;
            }
            locala.EPM.setImageResource(i.i.sight_list_checkbox_selected);
            break;
            localObject1 = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ((String)((Iterator)localObject3).next()));
            }
            localObject1 = Util.listToString((List)localObject1, ",");
          }
          label837:
          locala.EPM.setImageResource(i.i.sight_list_checkbox_unselected);
          continue;
          label851:
          if (paramInt1 == this.Lov)
          {
            if (this.KTi != paramInt1) {
              locala.EPM.setImageResource(i.i.sight_list_checkbox_unselected_red);
            }
            for (;;)
            {
              if (!cv(2, (String)localObject2)) {
                break label916;
              }
              locala.EPM.setImageResource(i.i.sight_list_checkbox_selected_red);
              break;
              locala.EPM.setImageResource(i.i.sight_list_checkbox_selected_red);
            }
            locala.EPM.setImageResource(i.i.sight_list_checkbox_unselected_red);
            continue;
            if (paramInt1 == this.Lou)
            {
              if (cv(1, (String)localObject2)) {
                locala.EPM.setImageResource(i.i.checkbox_selected);
              } else {
                locala.EPM.setImageResource(i.e.checkbox_unselected);
              }
            }
            else if (paramInt1 == this.Lov) {
              if (cv(2, (String)localObject2)) {
                locala.EPM.setImageResource(i.i.checkbox_selected_red);
              } else {
                locala.EPM.setImageResource(i.e.checkbox_unselected);
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
    Object localObject = this.KTh.get(paramInt2);
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
    return this.LoB;
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
        paramView = this.mInflater.inflate(i.g.sns_label_expand_item_black, null);
        paramViewGroup = new a((byte)0);
        paramViewGroup.titleView = ((TextView)paramView.findViewById(i.f.sns_label_title));
        paramViewGroup.EPM = ((ImageView)paramView.findViewById(i.f.sns_label_check_img));
        paramViewGroup.EqJ = ((TextView)paramView.findViewById(i.f.sns_label_sub_title));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(this.KSE[paramInt]);
        paramViewGroup.EqJ.setText(this.KTg[paramInt]);
        if ((paramInt != this.Lot) && (paramInt != this.Los)) {
          break label265;
        }
        if (this.KTi == paramInt) {
          break label233;
        }
        paramViewGroup.EPM.setImageResource(i.i.radio_off);
      }
    }
    for (;;)
    {
      if ((!this.KTj) || (paramInt != this.Lot)) {
        break label451;
      }
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(100185);
      return paramView;
      paramView = this.mInflater.inflate(i.g.sns_label_expand_item, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label102;
      label233:
      paramViewGroup.EPM.setImageResource(i.i.radio_on);
      paramViewGroup.EPM.setContentDescription(this.mContext.getString(i.j.selected_Imgbtn));
      continue;
      label265:
      if (paramInt == this.Lou)
      {
        if (this.KTi != paramInt)
        {
          paramViewGroup.EPM.setImageResource(i.i.radio_off);
        }
        else
        {
          paramViewGroup.EPM.setImageResource(i.i.radio_on);
          paramViewGroup.EPM.setContentDescription(this.mContext.getString(i.j.selected_Imgbtn));
        }
      }
      else if (paramInt == this.Lov) {
        if (this.style == 1)
        {
          if (this.KTi != paramInt)
          {
            paramViewGroup.EPM.setImageResource(i.i.radio_off);
          }
          else
          {
            paramViewGroup.EPM.setImageResource(i.i.round_selector_checked_orange);
            paramViewGroup.EPM.setContentDescription(this.mContext.getString(i.j.selected_Imgbtn));
          }
        }
        else if (this.KTi != paramInt)
        {
          paramViewGroup.EPM.setImageResource(i.i.radio_off);
        }
        else
        {
          paramViewGroup.EPM.setImageResource(i.i.radio_on_red);
          paramViewGroup.EPM.setContentDescription(this.mContext.getString(i.j.selected_Imgbtn));
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
    ImageView EPM;
    TextView EqJ;
    TextView KTv;
    TextView KTw;
    ImageView KTx;
    TextView titleView;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(a.c paramc);
  }
  
  final class c
  {
    public int KTy;
    public int KTz;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.a
 * JD-Core Version:    0.7.0.1
 */