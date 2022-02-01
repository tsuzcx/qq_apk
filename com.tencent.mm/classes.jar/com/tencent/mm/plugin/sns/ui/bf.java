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
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bf
  extends AnimatedExpandableListView.a
{
  public static int[] KSE = { i.j.sns_label_public, i.j.sns_label_private, i.j.sns_label_include, i.j.sns_label_exclude };
  public static int KTd = 0;
  public static int KTe = 1;
  public static int KTf = 2;
  public static int[] KTg = { i.j.sns_label_public_hint, i.j.sns_label_private_hint, i.j.sns_label_include_hint, i.j.sns_label_exclude_hint };
  public boolean KSM;
  ArrayList<String> KTh;
  public int KTi;
  public boolean KTj;
  public ArrayList<String> KTk;
  public ArrayList<String> KTl;
  public ArrayList<String> KTm;
  public ArrayList<String> KTn;
  public ArrayList<String> KTp;
  public ArrayList<String> KTq;
  public ArrayList<String> KTr;
  public ArrayList<String> KTs;
  b KTt;
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  
  public bf(Context paramContext)
  {
    AppMethodBeat.i(98824);
    this.KTi = 0;
    this.KSM = false;
    this.KTj = false;
    this.KTk = new ArrayList();
    this.KTl = new ArrayList();
    this.KTm = new ArrayList();
    this.KTn = new ArrayList();
    this.KTp = new ArrayList();
    this.KTq = new ArrayList();
    this.KTr = new ArrayList();
    this.KTs = new ArrayList();
    this.KTt = null;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vMY, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label227;
      }
      KTd = 0;
    }
    for (KTe = 1;; KTe = 0)
    {
      KTf = KTe + 1;
      Log.i("MicroMsg.Sns.AnimatedExpandableListAdapter", "initWithConfig %s %s %s", new Object[] { Integer.valueOf(KTd), Integer.valueOf(KTe), Integer.valueOf(KTf) });
      AppMethodBeat.o(98824);
      return;
      i = 0;
      break;
      label227:
      KTd = -1;
    }
  }
  
  private static List<String> S(List<String> paramList)
  {
    AppMethodBeat.i(98832);
    LinkedList localLinkedList = new LinkedList();
    h.aHH();
    if (!h.aHE().aGM())
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
    AppMethodBeat.o(98832);
    return localLinkedList;
  }
  
  public static void bcc(String paramString)
  {
    AppMethodBeat.i(98828);
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
      AppMethodBeat.o(98828);
      return;
    }
    h.aHH();
    h.aHG().aHp().i(335875, paramString);
    AppMethodBeat.o(98828);
  }
  
  private boolean cv(int paramInt, String paramString)
  {
    AppMethodBeat.i(98830);
    if (paramInt == 1)
    {
      bool = r(this.KTk, paramString);
      AppMethodBeat.o(98830);
      return bool;
    }
    boolean bool = r(this.KTl, paramString);
    AppMethodBeat.o(98830);
    return bool;
  }
  
  private static List<String> fWF()
  {
    AppMethodBeat.i(98827);
    h.aHH();
    Object localObject = (String)h.aHG().aHp().b(335875, null);
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
  
  private static boolean r(List<String> paramList, String paramString)
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
  
  public final int ahl(int paramInt)
  {
    AppMethodBeat.i(98834);
    if ((paramInt > 1) && (this.KTh != null))
    {
      paramInt = this.KTh.size();
      int i = KTf;
      AppMethodBeat.o(98834);
      return paramInt + i;
    }
    AppMethodBeat.o(98834);
    return 0;
  }
  
  public final void bf(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(98826);
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
            AppMethodBeat.i(98823);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof bf.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (bf.c)paramAnonymousView.getTag())
            {
              Log.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98823);
              return;
            }
            if (bf.a(bf.this) != null) {
              bf.a(bf.this).a(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98823);
          }
        });
        paramView.setTag(locala);
        if (paramInt2 != KTe) {
          break label513;
        }
        locala.titleView.setVisibility(8);
        locala.EqJ.setVisibility(8);
        locala.EPM.setVisibility(8);
        locala.KTx.setVisibility(8);
        locala.KTv.setVisibility(0);
        locala.KTv.setText(this.mContext.getResources().getString(i.j.sns_label_select_contact));
        locala.KTw.setVisibility(0);
        if (paramInt1 != 3) {
          break label392;
        }
        if (this.KTn.size() <= 0) {
          break label368;
        }
        localObject1 = Util.listToString(S(this.KTn), ",");
        locala.KTw.setText(l.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.KTw.getTextSize()));
        locala.KTw.setVisibility(0);
        locala.KTw.setTextColor(this.mContext.getResources().getColor(i.c.sns_selected_other_user_name_color_black));
      }
    }
    label513:
    for (;;)
    {
      AppMethodBeat.o(98833);
      return paramView;
      paramView = this.mInflater.inflate(i.g.sns_label_child_item, null);
      break;
      locala = (a)paramView.getTag();
      break label153;
      label368:
      locala.KTw.setText("");
      locala.KTw.setVisibility(8);
      continue;
      label392:
      if (paramInt1 == 2) {
        if (this.KTm.size() > 0)
        {
          localObject1 = Util.listToString(S(this.KTm), ",");
          locala.KTw.setText(l.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.KTw.getTextSize()));
          locala.KTw.setVisibility(0);
          locala.KTw.setTextColor(this.mContext.getResources().getColor(i.c.sns_selected_other_user_name_color));
        }
        else
        {
          locala.KTw.setText("");
          locala.KTw.setVisibility(8);
          continue;
          label1292:
          if (paramInt2 == KTd)
          {
            locala.titleView.setVisibility(8);
            locala.EqJ.setVisibility(8);
            locala.EPM.setVisibility(8);
            locala.KTx.setVisibility(8);
            locala.KTv.setVisibility(0);
            locala.KTv.setText(this.mContext.getResources().getString(i.j.sns_label_select_group));
            locala.KTw.setVisibility(0);
            if (paramInt1 == 3)
            {
              if (this.KTq.size() > 0)
              {
                localObject1 = Util.listToString(S(this.KTq), ",");
                locala.KTw.setText("√".concat(String.valueOf(localObject1)));
                locala.KTw.setVisibility(0);
                locala.KTw.setTextColor(this.mContext.getResources().getColor(i.c.sns_selected_other_user_name_color_black));
              }
              else
              {
                locala.KTw.setText("");
                locala.KTw.setVisibility(8);
              }
            }
            else if (paramInt1 == 2) {
              if (this.KTp.size() > 0)
              {
                localObject1 = Util.listToString(S(this.KTp), ",");
                locala.KTw.setText("√".concat(String.valueOf(localObject1)));
                locala.KTw.setVisibility(0);
                locala.KTw.setTextColor(this.mContext.getResources().getColor(i.c.sns_selected_other_user_name_color));
              }
              else
              {
                locala.KTw.setText("");
                locala.KTw.setVisibility(8);
              }
            }
          }
          else
          {
            paramInt2 -= KTf;
            localObject1 = locala.KTx;
            Object localObject2 = ((View)localObject1).getTag();
            label873:
            TextView localTextView;
            Object localObject3;
            if ((localObject2 == null) || (!(localObject2 instanceof c)))
            {
              localObject2 = new c();
              ((c)localObject2).KTy = paramInt1;
              ((c)localObject2).KTz = paramInt2;
              ((View)localObject1).setTag(localObject2);
              locala.titleView.setVisibility(0);
              locala.EqJ.setVisibility(0);
              locala.EPM.setVisibility(0);
              locala.KTx.setVisibility(0);
              locala.KTv.setVisibility(8);
              locala.KTw.setVisibility(8);
              localObject2 = (String)this.KTh.get(paramInt2);
              locala.titleView.setText(l.c(this.mContext, (CharSequence)localObject2));
              localTextView = locala.EqJ;
              localObject1 = com.tencent.mm.plugin.label.a.a.eLe().aMO((String)localObject2);
              localObject3 = com.tencent.mm.plugin.label.a.a.eLe().aMR((String)localObject1);
              if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
                break label1110;
              }
            }
            for (localObject1 = "";; localObject1 = l.c(this.mContext, (CharSequence)localObject1))
            {
              localTextView.setText((CharSequence)localObject1);
              locala.KTx.setImageDrawable(au.o(this.mContext, i.i.sns_label_more_btn, this.mContext.getResources().getColor(i.c.BW_50)));
              if (this.style != 1) {
                break label1292;
              }
              if (paramInt1 != 2) {
                break label1216;
              }
              if (!cv(1, (String)localObject2)) {
                break label1202;
              }
              locala.EPM.setImageResource(i.i.sight_list_checkbox_selected);
              break;
              localObject1 = (c)((View)localObject1).getTag();
              ((c)localObject1).KTy = paramInt1;
              ((c)localObject1).KTz = paramInt2;
              break label873;
              label1110:
              localObject1 = new ArrayList(((List)localObject3).size());
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ((String)((Iterator)localObject3).next()));
              }
              localObject1 = Util.listToString((List)localObject1, ",");
            }
            label1202:
            locala.EPM.setImageResource(i.i.sight_list_checkbox_unselected);
            continue;
            label1216:
            if (paramInt1 == 3)
            {
              if (this.KTi != paramInt1) {
                locala.EPM.setImageResource(i.i.sight_list_checkbox_unselected_red);
              }
              for (;;)
              {
                if (!cv(2, (String)localObject2)) {
                  break label1278;
                }
                locala.EPM.setImageResource(i.i.sight_list_checkbox_selected_red);
                break;
                locala.EPM.setImageResource(i.i.sight_list_checkbox_selected_red);
              }
              label1278:
              locala.EPM.setImageResource(i.i.sight_list_checkbox_unselected_red);
              continue;
              if (paramInt1 == 2)
              {
                if (cv(1, (String)localObject2)) {
                  locala.EPM.setImageResource(i.i.checkbox_selected);
                } else {
                  locala.EPM.setImageResource(i.e.checkbox_unselected);
                }
              }
              else if (paramInt1 == 3) {
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
  }
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98825);
    Object localObject = this.KTh.get(paramInt2);
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
        paramView = this.mInflater.inflate(i.g.sns_label_expand_item_black, null);
        paramViewGroup = new a((byte)0);
        paramViewGroup.titleView = ((TextView)paramView.findViewById(i.f.sns_label_title));
        paramViewGroup.EPM = ((ImageView)paramView.findViewById(i.f.sns_label_check_img));
        paramViewGroup.EqJ = ((TextView)paramView.findViewById(i.f.sns_label_sub_title));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(KSE[paramInt]);
        paramViewGroup.EqJ.setText(KTg[paramInt]);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      if ((!this.KTj) || (paramInt != 1)) {
        break label449;
      }
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(98831);
      return paramView;
      paramView = this.mInflater.inflate(i.g.sns_label_expand_item, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label102;
      if (this.KTi != paramInt)
      {
        paramViewGroup.EPM.setImageResource(i.i.radio_off);
      }
      else
      {
        paramViewGroup.EPM.setImageResource(i.i.radio_on);
        paramViewGroup.EPM.setContentDescription(this.mContext.getString(i.j.selected_Imgbtn));
        continue;
        if (this.KTi != paramInt)
        {
          paramViewGroup.EPM.setImageResource(i.i.radio_off);
        }
        else
        {
          paramViewGroup.EPM.setImageResource(i.i.radio_on);
          paramViewGroup.EPM.setContentDescription(this.mContext.getString(i.j.selected_Imgbtn));
          continue;
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
    }
    label449:
    if ((this.KSM) && ((paramInt == 1) || (paramInt == 2)))
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
    public abstract void a(bf.c paramc);
  }
  
  final class c
  {
    public int KTy;
    public int KTz;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf
 * JD-Core Version:    0.7.0.1
 */