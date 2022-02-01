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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ax
  extends AnimatedExpandableListView.a
{
  public static int[] yMS = { 2131763871, 2131763869, 2131763865, 2131763856 };
  public static int yNp = 0;
  public static int yNq = 1;
  public static int yNr = 2;
  public static int[] yNs = { 2131763872, 2131763870, 2131763866, 2131763857 };
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  public ArrayList<String> yNA;
  public ArrayList<String> yNB;
  b yNC;
  ArrayList<String> yNt;
  public int yNu;
  public boolean yNv;
  public ArrayList<String> yNw;
  public ArrayList<String> yNx;
  public ArrayList<String> yNy;
  public ArrayList<String> yNz;
  
  public ax(Context paramContext)
  {
    AppMethodBeat.i(98824);
    this.yNu = 0;
    this.yNv = false;
    this.yNw = new ArrayList();
    this.yNx = new ArrayList();
    this.yNy = new ArrayList();
    this.yNz = new ArrayList();
    this.yNA = new ArrayList();
    this.yNB = new ArrayList();
    this.yNC = null;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    int i;
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWk, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label200;
      }
      yNp = 0;
    }
    for (yNq = 1;; yNq = 0)
    {
      yNr = yNq + 1;
      ac.i("MicroMsg.Sns.AnimatedExpandableListAdapter", "initWithConfig %s %s %s", new Object[] { Integer.valueOf(yNp), Integer.valueOf(yNq), Integer.valueOf(yNr) });
      AppMethodBeat.o(98824);
      return;
      i = 0;
      break;
      label200:
      yNp = -1;
    }
  }
  
  private static List<String> Q(List<String> paramList)
  {
    AppMethodBeat.i(98832);
    LinkedList localLinkedList = new LinkedList();
    g.agS();
    if (!g.agP().afY())
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
      g.agS();
      ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
      paramList = str;
      if (localai != null)
      {
        paramList = str;
        if ((int)localai.fLJ != 0) {
          paramList = localai.aaS();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(98832);
    return localLinkedList;
  }
  
  public static void avI(String paramString)
  {
    AppMethodBeat.i(98828);
    ac.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[] { paramString });
    if (dPV() != null)
    {
      ArrayList localArrayList = new ArrayList(dPV());
      if (!p(localArrayList, paramString))
      {
        if (localArrayList.size() == 5) {
          localArrayList.remove(4);
        }
        localArrayList.add(0, paramString);
        paramString = bs.n(localArrayList, ",");
        g.agS();
        g.agR().agA().set(335875, paramString);
      }
      AppMethodBeat.o(98828);
      return;
    }
    g.agS();
    g.agR().agA().set(335875, paramString);
    AppMethodBeat.o(98828);
  }
  
  private boolean bW(int paramInt, String paramString)
  {
    AppMethodBeat.i(98830);
    if (paramInt == 1)
    {
      bool = p(this.yNw, paramString);
      AppMethodBeat.o(98830);
      return bool;
    }
    boolean bool = p(this.yNx, paramString);
    AppMethodBeat.o(98830);
    return bool;
  }
  
  private static List<String> dPV()
  {
    AppMethodBeat.i(98827);
    g.agS();
    Object localObject = (String)g.agR().agA().get(335875, null);
    ac.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(98827);
      return null;
    }
    localObject = bs.S(((String)localObject).split(","));
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
  
  public final int PC(int paramInt)
  {
    AppMethodBeat.i(98834);
    if ((paramInt > 1) && (this.yNt != null))
    {
      paramInt = this.yNt.size();
      int i = yNr;
      AppMethodBeat.o(98834);
      return paramInt + i;
    }
    AppMethodBeat.o(98834);
    return 0;
  }
  
  public final void aB(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(98826);
    Object localObject2 = dPV();
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
      localObject1 = bs.n((List)localObject1, ",");
      g.agS();
      g.agR().agA().set(335875, localObject1);
    }
    this.yNt = paramArrayList;
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
        paramView = this.mInflater.inflate(2131495556, null);
        locala = new a((byte)0);
        locala.titleView = ((TextView)paramView.findViewById(2131304997));
        locala.uej = ((TextView)paramView.findViewById(2131304996));
        locala.yNE = ((TextView)paramView.findViewById(2131304995));
        locala.yNF = ((TextView)paramView.findViewById(2131304994));
        locala.uBH = ((ImageView)paramView.findViewById(2131304990));
        locala.yNG = ((ImageView)paramView.findViewById(2131304993));
        locala.yNG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98823);
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof ax.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (ax.c)paramAnonymousView.getTag())
            {
              ac.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
              AppMethodBeat.o(98823);
              return;
            }
            if (ax.a(ax.this) != null) {
              ax.a(ax.this).a(paramAnonymousView);
            }
            AppMethodBeat.o(98823);
          }
        });
        paramView.setTag(locala);
        if (paramInt2 != yNq) {
          break label511;
        }
        locala.titleView.setVisibility(8);
        locala.uej.setVisibility(8);
        locala.uBH.setVisibility(8);
        locala.yNG.setVisibility(8);
        locala.yNE.setVisibility(0);
        locala.yNE.setText(this.mContext.getResources().getString(2131763873));
        locala.yNF.setVisibility(0);
        if (paramInt1 != 3) {
          break label391;
        }
        if (this.yNz.size() <= 0) {
          break label367;
        }
        localObject1 = bs.n(Q(this.yNz), ",");
        locala.yNF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.yNF.getTextSize()));
        locala.yNF.setVisibility(0);
        locala.yNF.setTextColor(this.mContext.getResources().getColor(2131100929));
      }
    }
    label391:
    label1197:
    label1211:
    for (;;)
    {
      AppMethodBeat.o(98833);
      return paramView;
      paramView = this.mInflater.inflate(2131495555, null);
      break;
      locala = (a)paramView.getTag();
      break label153;
      label367:
      locala.yNF.setText("");
      locala.yNF.setVisibility(8);
      continue;
      label1106:
      if (paramInt1 == 2) {
        label869:
        label1273:
        if (this.yNy.size() > 0)
        {
          localObject1 = bs.n(Q(this.yNy), ",");
          locala.yNF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.yNF.getTextSize()));
          locala.yNF.setVisibility(0);
          locala.yNF.setTextColor(this.mContext.getResources().getColor(2131100928));
        }
        else
        {
          locala.yNF.setText("");
          locala.yNF.setVisibility(8);
          continue;
          label511:
          if (paramInt2 == yNp)
          {
            locala.titleView.setVisibility(8);
            locala.uej.setVisibility(8);
            locala.uBH.setVisibility(8);
            locala.yNG.setVisibility(8);
            locala.yNE.setVisibility(0);
            locala.yNE.setText(this.mContext.getResources().getString(2131763874));
            locala.yNF.setVisibility(0);
            if (paramInt1 == 3)
            {
              if (this.yNB.size() > 0)
              {
                localObject1 = bs.n(Q(this.yNB), ",");
                locala.yNF.setText("√".concat(String.valueOf(localObject1)));
                locala.yNF.setVisibility(0);
                locala.yNF.setTextColor(this.mContext.getResources().getColor(2131100929));
              }
              else
              {
                locala.yNF.setText("");
                locala.yNF.setVisibility(8);
              }
            }
            else if (paramInt1 == 2) {
              if (this.yNA.size() > 0)
              {
                localObject1 = bs.n(Q(this.yNA), ",");
                locala.yNF.setText("√".concat(String.valueOf(localObject1)));
                locala.yNF.setVisibility(0);
                locala.yNF.setTextColor(this.mContext.getResources().getColor(2131100928));
              }
              else
              {
                locala.yNF.setText("");
                locala.yNF.setVisibility(8);
              }
            }
          }
          else
          {
            paramInt2 -= yNr;
            localObject1 = locala.yNG;
            Object localObject2 = ((View)localObject1).getTag();
            TextView localTextView;
            Object localObject3;
            if ((localObject2 == null) || (!(localObject2 instanceof c)))
            {
              localObject2 = new c();
              ((c)localObject2).yNH = paramInt1;
              ((c)localObject2).yNI = paramInt2;
              ((View)localObject1).setTag(localObject2);
              locala.titleView.setVisibility(0);
              locala.uej.setVisibility(0);
              locala.uBH.setVisibility(0);
              locala.yNG.setVisibility(0);
              locala.yNE.setVisibility(8);
              locala.yNF.setVisibility(8);
              localObject2 = (String)this.yNt.get(paramInt2);
              locala.titleView.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, (CharSequence)localObject2));
              localTextView = locala.uej;
              localObject1 = com.tencent.mm.plugin.label.a.a.cWd().ajA((String)localObject2);
              localObject3 = com.tencent.mm.plugin.label.a.a.cWd().ajD((String)localObject1);
              if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
                break label1106;
              }
            }
            for (localObject1 = "";; localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, (CharSequence)localObject1))
            {
              localTextView.setText((CharSequence)localObject1);
              locala.yNG.setImageDrawable(am.k(this.mContext, 2131691196, this.mContext.getResources().getColor(2131099676)));
              if (this.style != 1) {
                break label1287;
              }
              if (paramInt1 != 2) {
                break label1211;
              }
              if (!bW(1, (String)localObject2)) {
                break label1197;
              }
              locala.uBH.setImageResource(2131691180);
              break;
              localObject1 = (c)((View)localObject1).getTag();
              ((c)localObject1).yNH = paramInt1;
              ((c)localObject1).yNI = paramInt2;
              break label869;
              localObject1 = new ArrayList(((List)localObject3).size());
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk((String)((Iterator)localObject3).next()));
              }
              localObject1 = bs.n((List)localObject1, ",");
            }
            locala.uBH.setImageResource(2131691182);
            continue;
            if (paramInt1 == 3)
            {
              if (this.yNu != paramInt1) {
                locala.uBH.setImageResource(2131691183);
              }
              for (;;)
              {
                if (!bW(2, (String)localObject2)) {
                  break label1273;
                }
                locala.uBH.setImageResource(2131691181);
                break;
                locala.uBH.setImageResource(2131691181);
              }
              locala.uBH.setImageResource(2131691183);
              continue;
              if (paramInt1 == 2)
              {
                if (bW(1, (String)localObject2)) {
                  locala.uBH.setImageResource(2131689936);
                } else {
                  locala.uBH.setImageResource(2131231750);
                }
              }
              else if (paramInt1 == 3) {
                if (bW(2, (String)localObject2)) {
                  locala.uBH.setImageResource(2131689940);
                } else {
                  locala.uBH.setImageResource(2131231750);
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
    Object localObject = this.yNt.get(paramInt2);
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
        paramView = this.mInflater.inflate(2131495558, null);
        paramViewGroup = new a((byte)0);
        paramViewGroup.titleView = ((TextView)paramView.findViewById(2131304997));
        paramViewGroup.uBH = ((ImageView)paramView.findViewById(2131304990));
        paramViewGroup.uej = ((TextView)paramView.findViewById(2131304996));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(yMS[paramInt]);
        paramViewGroup.uej.setText(yNs[paramInt]);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      if ((!this.yNv) || (paramInt != 1)) {
        break label449;
      }
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(98831);
      return paramView;
      paramView = this.mInflater.inflate(2131495557, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label102;
      if (this.yNu != paramInt)
      {
        paramViewGroup.uBH.setImageResource(2131691077);
      }
      else
      {
        paramViewGroup.uBH.setImageResource(2131691078);
        paramViewGroup.uBH.setContentDescription(this.mContext.getString(2131763023));
        continue;
        if (this.yNu != paramInt)
        {
          paramViewGroup.uBH.setImageResource(2131691077);
        }
        else
        {
          paramViewGroup.uBH.setImageResource(2131691078);
          paramViewGroup.uBH.setContentDescription(this.mContext.getString(2131763023));
          continue;
          if (this.style == 1)
          {
            if (this.yNu != paramInt)
            {
              paramViewGroup.uBH.setImageResource(2131691077);
            }
            else
            {
              paramViewGroup.uBH.setImageResource(2131691106);
              paramViewGroup.uBH.setContentDescription(this.mContext.getString(2131763023));
            }
          }
          else if (this.yNu != paramInt)
          {
            paramViewGroup.uBH.setImageResource(2131691077);
          }
          else
          {
            paramViewGroup.uBH.setImageResource(2131691079);
            paramViewGroup.uBH.setContentDescription(this.mContext.getString(2131763023));
          }
        }
      }
    }
    label449:
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
    TextView titleView;
    ImageView uBH;
    TextView uej;
    TextView yNE;
    TextView yNF;
    ImageView yNG;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(ax.c paramc);
  }
  
  final class c
  {
    public int yNH;
    public int yNI;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ax
 * JD-Core Version:    0.7.0.1
 */