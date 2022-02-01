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
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bd
  extends AnimatedExpandableListView.a
{
  public static int[] EEO = { 2131766098, 2131766096, 2131766092, 2131766083 };
  public static int EFm = 0;
  public static int EFn = 1;
  public static int EFo = 2;
  public static int[] EFp = { 2131766099, 2131766097, 2131766093, 2131766084 };
  public boolean EEV;
  ArrayList<String> EFq;
  public int EFr;
  public boolean EFs;
  public ArrayList<String> EFt;
  public ArrayList<String> EFu;
  public ArrayList<String> EFv;
  public ArrayList<String> EFw;
  public ArrayList<String> EFx;
  public ArrayList<String> EFy;
  b EFz;
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  
  public bd(Context paramContext)
  {
    AppMethodBeat.i(98824);
    this.EFr = 0;
    this.EEV = false;
    this.EFs = false;
    this.EFt = new ArrayList();
    this.EFu = new ArrayList();
    this.EFv = new ArrayList();
    this.EFw = new ArrayList();
    this.EFx = new ArrayList();
    this.EFy = new ArrayList();
    this.EFz = null;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sdE, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label205;
      }
      EFm = 0;
    }
    for (EFn = 1;; EFn = 0)
    {
      EFo = EFn + 1;
      Log.i("MicroMsg.Sns.AnimatedExpandableListAdapter", "initWithConfig %s %s %s", new Object[] { Integer.valueOf(EFm), Integer.valueOf(EFn), Integer.valueOf(EFo) });
      AppMethodBeat.o(98824);
      return;
      i = 0;
      break;
      label205:
      EFm = -1;
    }
  }
  
  private static List<String> V(List<String> paramList)
  {
    AppMethodBeat.i(98832);
    LinkedList localLinkedList = new LinkedList();
    g.aAi();
    if (!g.aAf().azp())
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
      g.aAi();
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
      paramList = str;
      if (localas != null)
      {
        paramList = str;
        if ((int)localas.gMZ != 0) {
          paramList = localas.arJ();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(98832);
    return localLinkedList;
  }
  
  public static void aRb(String paramString)
  {
    AppMethodBeat.i(98828);
    Log.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[] { paramString });
    if (fit() != null)
    {
      ArrayList localArrayList = new ArrayList(fit());
      if (!p(localArrayList, paramString))
      {
        if (localArrayList.size() == 5) {
          localArrayList.remove(4);
        }
        localArrayList.add(0, paramString);
        paramString = Util.listToString(localArrayList, ",");
        g.aAi();
        g.aAh().azQ().set(335875, paramString);
      }
      AppMethodBeat.o(98828);
      return;
    }
    g.aAi();
    g.aAh().azQ().set(335875, paramString);
    AppMethodBeat.o(98828);
  }
  
  private boolean cu(int paramInt, String paramString)
  {
    AppMethodBeat.i(98830);
    if (paramInt == 1)
    {
      bool = p(this.EFt, paramString);
      AppMethodBeat.o(98830);
      return bool;
    }
    boolean bool = p(this.EFu, paramString);
    AppMethodBeat.o(98830);
    return bool;
  }
  
  private static List<String> fit()
  {
    AppMethodBeat.i(98827);
    g.aAi();
    Object localObject = (String)g.aAh().azQ().get(335875, null);
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
  
  private static boolean p(List<String> paramList, String paramString)
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
  
  public final int ZO(int paramInt)
  {
    AppMethodBeat.i(98834);
    if ((paramInt > 1) && (this.EFq != null))
    {
      paramInt = this.EFq.size();
      int i = EFo;
      AppMethodBeat.o(98834);
      return paramInt + i;
    }
    AppMethodBeat.o(98834);
    return 0;
  }
  
  public final void aR(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(98826);
    Object localObject2 = fit();
    Object localObject1 = new ArrayList();
    if ((localObject2 != null) && (paramArrayList != null))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (p(paramArrayList, str))
        {
          paramArrayList.remove(str);
          ((ArrayList)localObject1).add(str);
        }
      }
      paramArrayList.addAll(0, (Collection)localObject1);
      localObject1 = Util.listToString((List)localObject1, ",");
      g.aAi();
      g.aAh().azQ().set(335875, localObject1);
    }
    this.EFq = paramArrayList;
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
        paramView = this.mInflater.inflate(2131496448, null);
        locala = new a((byte)0);
        locala.titleView = ((TextView)paramView.findViewById(2131308148));
        locala.yMM = ((TextView)paramView.findViewById(2131308147));
        locala.EFB = ((TextView)paramView.findViewById(2131308146));
        locala.EFC = ((TextView)paramView.findViewById(2131308145));
        locala.zkw = ((ImageView)paramView.findViewById(2131308141));
        locala.EFD = ((ImageView)paramView.findViewById(2131308144));
        locala.EFD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98823);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof bd.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (bd.c)paramAnonymousView.getTag())
            {
              Log.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98823);
              return;
            }
            if (bd.a(bd.this) != null) {
              bd.a(bd.this).a(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98823);
          }
        });
        paramView.setTag(locala);
        if (paramInt2 != EFn) {
          break label511;
        }
        locala.titleView.setVisibility(8);
        locala.yMM.setVisibility(8);
        locala.zkw.setVisibility(8);
        locala.EFD.setVisibility(8);
        locala.EFB.setVisibility(0);
        locala.EFB.setText(this.mContext.getResources().getString(2131766100));
        locala.EFC.setVisibility(0);
        if (paramInt1 != 3) {
          break label391;
        }
        if (this.EFw.size() <= 0) {
          break label367;
        }
        localObject1 = Util.listToString(V(this.EFw), ",");
        locala.EFC.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.EFC.getTextSize()));
        locala.EFC.setVisibility(0);
        locala.EFC.setTextColor(this.mContext.getResources().getColor(2131101146));
      }
    }
    label391:
    label1197:
    label1211:
    for (;;)
    {
      AppMethodBeat.o(98833);
      return paramView;
      paramView = this.mInflater.inflate(2131496447, null);
      break;
      locala = (a)paramView.getTag();
      break label153;
      label367:
      locala.EFC.setText("");
      locala.EFC.setVisibility(8);
      continue;
      label1106:
      if (paramInt1 == 2) {
        label869:
        label1273:
        if (this.EFv.size() > 0)
        {
          localObject1 = Util.listToString(V(this.EFv), ",");
          locala.EFC.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.EFC.getTextSize()));
          locala.EFC.setVisibility(0);
          locala.EFC.setTextColor(this.mContext.getResources().getColor(2131101145));
        }
        else
        {
          locala.EFC.setText("");
          locala.EFC.setVisibility(8);
          continue;
          label511:
          if (paramInt2 == EFm)
          {
            locala.titleView.setVisibility(8);
            locala.yMM.setVisibility(8);
            locala.zkw.setVisibility(8);
            locala.EFD.setVisibility(8);
            locala.EFB.setVisibility(0);
            locala.EFB.setText(this.mContext.getResources().getString(2131766101));
            locala.EFC.setVisibility(0);
            if (paramInt1 == 3)
            {
              if (this.EFy.size() > 0)
              {
                localObject1 = Util.listToString(V(this.EFy), ",");
                locala.EFC.setText("√".concat(String.valueOf(localObject1)));
                locala.EFC.setVisibility(0);
                locala.EFC.setTextColor(this.mContext.getResources().getColor(2131101146));
              }
              else
              {
                locala.EFC.setText("");
                locala.EFC.setVisibility(8);
              }
            }
            else if (paramInt1 == 2) {
              if (this.EFx.size() > 0)
              {
                localObject1 = Util.listToString(V(this.EFx), ",");
                locala.EFC.setText("√".concat(String.valueOf(localObject1)));
                locala.EFC.setVisibility(0);
                locala.EFC.setTextColor(this.mContext.getResources().getColor(2131101145));
              }
              else
              {
                locala.EFC.setText("");
                locala.EFC.setVisibility(8);
              }
            }
          }
          else
          {
            paramInt2 -= EFo;
            localObject1 = locala.EFD;
            Object localObject2 = ((View)localObject1).getTag();
            TextView localTextView;
            Object localObject3;
            if ((localObject2 == null) || (!(localObject2 instanceof c)))
            {
              localObject2 = new c();
              ((c)localObject2).EFE = paramInt1;
              ((c)localObject2).EFF = paramInt2;
              ((View)localObject1).setTag(localObject2);
              locala.titleView.setVisibility(0);
              locala.yMM.setVisibility(0);
              locala.zkw.setVisibility(0);
              locala.EFD.setVisibility(0);
              locala.EFB.setVisibility(8);
              locala.EFC.setVisibility(8);
              localObject2 = (String)this.EFq.get(paramInt2);
              locala.titleView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.mContext, (CharSequence)localObject2));
              localTextView = locala.yMM;
              localObject1 = com.tencent.mm.plugin.label.a.a.ecg().aCH((String)localObject2);
              localObject3 = com.tencent.mm.plugin.label.a.a.ecg().aCK((String)localObject1);
              if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
                break label1106;
              }
            }
            for (localObject1 = "";; localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c(this.mContext, (CharSequence)localObject1))
            {
              localTextView.setText((CharSequence)localObject1);
              locala.EFD.setImageDrawable(ar.m(this.mContext, 2131691518, this.mContext.getResources().getColor(2131099683)));
              if (this.style != 1) {
                break label1287;
              }
              if (paramInt1 != 2) {
                break label1211;
              }
              if (!cu(1, (String)localObject2)) {
                break label1197;
              }
              locala.zkw.setImageResource(2131691496);
              break;
              localObject1 = (c)((View)localObject1).getTag();
              ((c)localObject1).EFE = paramInt1;
              ((c)localObject1).EFF = paramInt2;
              break label869;
              localObject1 = new ArrayList(((List)localObject3).size());
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)((Iterator)localObject3).next()));
              }
              localObject1 = Util.listToString((List)localObject1, ",");
            }
            locala.zkw.setImageResource(2131691498);
            continue;
            if (paramInt1 == 3)
            {
              if (this.EFr != paramInt1) {
                locala.zkw.setImageResource(2131691499);
              }
              for (;;)
              {
                if (!cu(2, (String)localObject2)) {
                  break label1273;
                }
                locala.zkw.setImageResource(2131691497);
                break;
                locala.zkw.setImageResource(2131691497);
              }
              locala.zkw.setImageResource(2131691499);
              continue;
              if (paramInt1 == 2)
              {
                if (cu(1, (String)localObject2)) {
                  locala.zkw.setImageResource(2131689951);
                } else {
                  locala.zkw.setImageResource(2131231825);
                }
              }
              else if (paramInt1 == 3) {
                if (cu(2, (String)localObject2)) {
                  locala.zkw.setImageResource(2131689959);
                } else {
                  locala.zkw.setImageResource(2131231825);
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
    Object localObject = this.EFq.get(paramInt2);
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
        paramView = this.mInflater.inflate(2131496450, null);
        paramViewGroup = new a((byte)0);
        paramViewGroup.titleView = ((TextView)paramView.findViewById(2131308148));
        paramViewGroup.zkw = ((ImageView)paramView.findViewById(2131308141));
        paramViewGroup.yMM = ((TextView)paramView.findViewById(2131308147));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(EEO[paramInt]);
        paramViewGroup.yMM.setText(EFp[paramInt]);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      if ((!this.EFs) || (paramInt != 1)) {
        break label449;
      }
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(98831);
      return paramView;
      paramView = this.mInflater.inflate(2131496449, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label102;
      if (this.EFr != paramInt)
      {
        paramViewGroup.zkw.setImageResource(2131691379);
      }
      else
      {
        paramViewGroup.zkw.setImageResource(2131691380);
        paramViewGroup.zkw.setContentDescription(this.mContext.getString(2131765172));
        continue;
        if (this.EFr != paramInt)
        {
          paramViewGroup.zkw.setImageResource(2131691379);
        }
        else
        {
          paramViewGroup.zkw.setImageResource(2131691380);
          paramViewGroup.zkw.setContentDescription(this.mContext.getString(2131765172));
          continue;
          if (this.style == 1)
          {
            if (this.EFr != paramInt)
            {
              paramViewGroup.zkw.setImageResource(2131691379);
            }
            else
            {
              paramViewGroup.zkw.setImageResource(2131691409);
              paramViewGroup.zkw.setContentDescription(this.mContext.getString(2131765172));
            }
          }
          else if (this.EFr != paramInt)
          {
            paramViewGroup.zkw.setImageResource(2131691379);
          }
          else
          {
            paramViewGroup.zkw.setImageResource(2131691381);
            paramViewGroup.zkw.setContentDescription(this.mContext.getString(2131765172));
          }
        }
      }
    }
    label449:
    if ((this.EEV) && ((paramInt == 1) || (paramInt == 2)))
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
    TextView EFB;
    TextView EFC;
    ImageView EFD;
    TextView titleView;
    TextView yMM;
    ImageView zkw;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(bd.c paramc);
  }
  
  final class c
  {
    public int EFE;
    public int EFF;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd
 * JD-Core Version:    0.7.0.1
 */