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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  public static int xAB = 0;
  public static int xAC = 1;
  public static int xAD = 2;
  public static int[] xAE = { 2131763872, 2131763870, 2131763866, 2131763857 };
  public static int[] xAe = { 2131763871, 2131763869, 2131763865, 2131763856 };
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  ArrayList<String> xAF;
  public int xAG;
  public boolean xAH;
  public ArrayList<String> xAI;
  public ArrayList<String> xAJ;
  public ArrayList<String> xAK;
  public ArrayList<String> xAL;
  public ArrayList<String> xAM;
  public ArrayList<String> xAN;
  b xAO;
  
  public ax(Context paramContext)
  {
    AppMethodBeat.i(98824);
    this.xAG = 0;
    this.xAH = false;
    this.xAI = new ArrayList();
    this.xAJ = new ArrayList();
    this.xAK = new ArrayList();
    this.xAL = new ArrayList();
    this.xAM = new ArrayList();
    this.xAN = new ArrayList();
    this.xAO = null;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    int i;
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psf, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label200;
      }
      xAB = 0;
    }
    for (xAC = 1;; xAC = 0)
    {
      xAD = xAC + 1;
      ad.i("MicroMsg.Sns.AnimatedExpandableListAdapter", "initWithConfig %s %s %s", new Object[] { Integer.valueOf(xAB), Integer.valueOf(xAC), Integer.valueOf(xAD) });
      AppMethodBeat.o(98824);
      return;
      i = 0;
      break;
      label200:
      xAB = -1;
    }
  }
  
  private static List<String> Z(List<String> paramList)
  {
    AppMethodBeat.i(98832);
    LinkedList localLinkedList = new LinkedList();
    g.afC();
    if (!g.afz().aeI())
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
      g.afC();
      af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
      paramList = str;
      if (localaf != null)
      {
        paramList = str;
        if ((int)localaf.fId != 0) {
          paramList = localaf.ZX();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(98832);
    return localLinkedList;
  }
  
  public static void aqz(String paramString)
  {
    AppMethodBeat.i(98828);
    ad.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[] { paramString });
    if (dBy() != null)
    {
      ArrayList localArrayList = new ArrayList(dBy());
      if (!p(localArrayList, paramString))
      {
        if (localArrayList.size() == 5) {
          localArrayList.remove(4);
        }
        localArrayList.add(0, paramString);
        paramString = bt.n(localArrayList, ",");
        g.afC();
        g.afB().afk().set(335875, paramString);
      }
      AppMethodBeat.o(98828);
      return;
    }
    g.afC();
    g.afB().afk().set(335875, paramString);
    AppMethodBeat.o(98828);
  }
  
  private boolean bS(int paramInt, String paramString)
  {
    AppMethodBeat.i(98830);
    if (paramInt == 1)
    {
      bool = p(this.xAI, paramString);
      AppMethodBeat.o(98830);
      return bool;
    }
    boolean bool = p(this.xAJ, paramString);
    AppMethodBeat.o(98830);
    return bool;
  }
  
  private static List<String> dBy()
  {
    AppMethodBeat.i(98827);
    g.afC();
    Object localObject = (String)g.afB().afk().get(335875, null);
    ad.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(98827);
      return null;
    }
    localObject = bt.S(((String)localObject).split(","));
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
  
  public final int Ny(int paramInt)
  {
    AppMethodBeat.i(98834);
    if ((paramInt > 1) && (this.xAF != null))
    {
      paramInt = this.xAF.size();
      int i = xAD;
      AppMethodBeat.o(98834);
      return paramInt + i;
    }
    AppMethodBeat.o(98834);
    return 0;
  }
  
  public final void ap(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(98826);
    Object localObject2 = dBy();
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
      localObject1 = bt.n((List)localObject1, ",");
      g.afC();
      g.afB().afk().set(335875, localObject1);
    }
    this.xAF = paramArrayList;
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
        locala.sVW = ((TextView)paramView.findViewById(2131304996));
        locala.xAQ = ((TextView)paramView.findViewById(2131304995));
        locala.xAR = ((TextView)paramView.findViewById(2131304994));
        locala.tto = ((ImageView)paramView.findViewById(2131304990));
        locala.xAS = ((ImageView)paramView.findViewById(2131304993));
        locala.xAS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98823);
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof ax.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (ax.c)paramAnonymousView.getTag())
            {
              ad.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
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
        if (paramInt2 != xAC) {
          break label511;
        }
        locala.titleView.setVisibility(8);
        locala.sVW.setVisibility(8);
        locala.tto.setVisibility(8);
        locala.xAS.setVisibility(8);
        locala.xAQ.setVisibility(0);
        locala.xAQ.setText(this.mContext.getResources().getString(2131763873));
        locala.xAR.setVisibility(0);
        if (paramInt1 != 3) {
          break label391;
        }
        if (this.xAL.size() <= 0) {
          break label367;
        }
        localObject1 = bt.n(Z(this.xAL), ",");
        locala.xAR.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.xAR.getTextSize()));
        locala.xAR.setVisibility(0);
        locala.xAR.setTextColor(this.mContext.getResources().getColor(2131100929));
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
      locala.xAR.setText("");
      locala.xAR.setVisibility(8);
      continue;
      label1106:
      if (paramInt1 == 2) {
        label869:
        label1273:
        if (this.xAK.size() > 0)
        {
          localObject1 = bt.n(Z(this.xAK), ",");
          locala.xAR.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.xAR.getTextSize()));
          locala.xAR.setVisibility(0);
          locala.xAR.setTextColor(this.mContext.getResources().getColor(2131100928));
        }
        else
        {
          locala.xAR.setText("");
          locala.xAR.setVisibility(8);
          continue;
          label511:
          if (paramInt2 == xAB)
          {
            locala.titleView.setVisibility(8);
            locala.sVW.setVisibility(8);
            locala.tto.setVisibility(8);
            locala.xAS.setVisibility(8);
            locala.xAQ.setVisibility(0);
            locala.xAQ.setText(this.mContext.getResources().getString(2131763874));
            locala.xAR.setVisibility(0);
            if (paramInt1 == 3)
            {
              if (this.xAN.size() > 0)
              {
                localObject1 = bt.n(Z(this.xAN), ",");
                locala.xAR.setText("√".concat(String.valueOf(localObject1)));
                locala.xAR.setVisibility(0);
                locala.xAR.setTextColor(this.mContext.getResources().getColor(2131100929));
              }
              else
              {
                locala.xAR.setText("");
                locala.xAR.setVisibility(8);
              }
            }
            else if (paramInt1 == 2) {
              if (this.xAM.size() > 0)
              {
                localObject1 = bt.n(Z(this.xAM), ",");
                locala.xAR.setText("√".concat(String.valueOf(localObject1)));
                locala.xAR.setVisibility(0);
                locala.xAR.setTextColor(this.mContext.getResources().getColor(2131100928));
              }
              else
              {
                locala.xAR.setText("");
                locala.xAR.setVisibility(8);
              }
            }
          }
          else
          {
            paramInt2 -= xAD;
            localObject1 = locala.xAS;
            Object localObject2 = ((View)localObject1).getTag();
            TextView localTextView;
            Object localObject3;
            if ((localObject2 == null) || (!(localObject2 instanceof c)))
            {
              localObject2 = new c();
              ((c)localObject2).xAT = paramInt1;
              ((c)localObject2).xAU = paramInt2;
              ((View)localObject1).setTag(localObject2);
              locala.titleView.setVisibility(0);
              locala.sVW.setVisibility(0);
              locala.tto.setVisibility(0);
              locala.xAS.setVisibility(0);
              locala.xAQ.setVisibility(8);
              locala.xAR.setVisibility(8);
              localObject2 = (String)this.xAF.get(paramInt2);
              locala.titleView.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, (CharSequence)localObject2));
              localTextView = locala.sVW;
              localObject1 = com.tencent.mm.plugin.label.a.a.cIS().aeI((String)localObject2);
              localObject3 = com.tencent.mm.plugin.label.a.a.cIS().aeL((String)localObject1);
              if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
                break label1106;
              }
            }
            for (localObject1 = "";; localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, (CharSequence)localObject1))
            {
              localTextView.setText((CharSequence)localObject1);
              locala.xAS.setImageDrawable(am.i(this.mContext, 2131691196, this.mContext.getResources().getColor(2131099676)));
              if (this.style != 1) {
                break label1287;
              }
              if (paramInt1 != 2) {
                break label1211;
              }
              if (!bS(1, (String)localObject2)) {
                break label1197;
              }
              locala.tto.setImageResource(2131691180);
              break;
              localObject1 = (c)((View)localObject1).getTag();
              ((c)localObject1).xAT = paramInt1;
              ((c)localObject1).xAU = paramInt2;
              break label869;
              localObject1 = new ArrayList(((List)localObject3).size());
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh((String)((Iterator)localObject3).next()));
              }
              localObject1 = bt.n((List)localObject1, ",");
            }
            locala.tto.setImageResource(2131691182);
            continue;
            if (paramInt1 == 3)
            {
              if (this.xAG != paramInt1) {
                locala.tto.setImageResource(2131691183);
              }
              for (;;)
              {
                if (!bS(2, (String)localObject2)) {
                  break label1273;
                }
                locala.tto.setImageResource(2131691181);
                break;
                locala.tto.setImageResource(2131691181);
              }
              locala.tto.setImageResource(2131691183);
              continue;
              if (paramInt1 == 2)
              {
                if (bS(1, (String)localObject2)) {
                  locala.tto.setImageResource(2131689936);
                } else {
                  locala.tto.setImageResource(2131231750);
                }
              }
              else if (paramInt1 == 3) {
                if (bS(2, (String)localObject2)) {
                  locala.tto.setImageResource(2131689940);
                } else {
                  locala.tto.setImageResource(2131231750);
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
    Object localObject = this.xAF.get(paramInt2);
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
        paramViewGroup.tto = ((ImageView)paramView.findViewById(2131304990));
        paramViewGroup.sVW = ((TextView)paramView.findViewById(2131304996));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(xAe[paramInt]);
        paramViewGroup.sVW.setText(xAE[paramInt]);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      if ((!this.xAH) || (paramInt != 1)) {
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
      if (this.xAG != paramInt)
      {
        paramViewGroup.tto.setImageResource(2131691077);
      }
      else
      {
        paramViewGroup.tto.setImageResource(2131691078);
        paramViewGroup.tto.setContentDescription(this.mContext.getString(2131763023));
        continue;
        if (this.xAG != paramInt)
        {
          paramViewGroup.tto.setImageResource(2131691077);
        }
        else
        {
          paramViewGroup.tto.setImageResource(2131691078);
          paramViewGroup.tto.setContentDescription(this.mContext.getString(2131763023));
          continue;
          if (this.style == 1)
          {
            if (this.xAG != paramInt)
            {
              paramViewGroup.tto.setImageResource(2131691077);
            }
            else
            {
              paramViewGroup.tto.setImageResource(2131691106);
              paramViewGroup.tto.setContentDescription(this.mContext.getString(2131763023));
            }
          }
          else if (this.xAG != paramInt)
          {
            paramViewGroup.tto.setImageResource(2131691077);
          }
          else
          {
            paramViewGroup.tto.setImageResource(2131691079);
            paramViewGroup.tto.setContentDescription(this.mContext.getString(2131763023));
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
    TextView sVW;
    TextView titleView;
    ImageView tto;
    TextView xAQ;
    TextView xAR;
    ImageView xAS;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(ax.c paramc);
  }
  
  final class c
  {
    public int xAT;
    public int xAU;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ax
 * JD-Core Version:    0.7.0.1
 */