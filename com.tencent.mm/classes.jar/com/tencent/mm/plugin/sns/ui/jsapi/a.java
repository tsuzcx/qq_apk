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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends AnimatedExpandableListView.a
{
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  public int[] xAE;
  ArrayList<String> xAF;
  public int xAG;
  public boolean xAH;
  public ArrayList<String> xAI;
  public ArrayList<String> xAJ;
  public ArrayList<String> xAK;
  public ArrayList<String> xAL;
  public int[] xAe;
  public int xSX;
  public int xSY;
  public int xSZ;
  public int xTa;
  int xTg;
  List<String> xTh;
  b xTi;
  boolean xTj;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(100178);
    this.xTg = 4;
    this.xSX = 0;
    this.xSY = 1;
    this.xSZ = 2;
    this.xTa = 3;
    this.xAe = new int[] { 2131763871, 2131763869, 2131763865, 2131763856 };
    this.xAE = new int[] { 2131763872, 2131763870, 2131763866, 2131763857 };
    this.xAG = 0;
    this.xAH = false;
    this.xAI = new ArrayList();
    this.xAJ = new ArrayList();
    this.xAK = new ArrayList();
    this.xAL = new ArrayList();
    this.xTi = null;
    this.xTj = true;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    AppMethodBeat.o(100178);
  }
  
  private static List<String> Z(List<String> paramList)
  {
    AppMethodBeat.i(100186);
    LinkedList localLinkedList = new LinkedList();
    g.afC();
    if (!g.afz().aeI())
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
    AppMethodBeat.o(100186);
    return localLinkedList;
  }
  
  public static void aqz(String paramString)
  {
    AppMethodBeat.i(100182);
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
      AppMethodBeat.o(100182);
      return;
    }
    g.afC();
    g.afB().afk().set(335875, paramString);
    AppMethodBeat.o(100182);
  }
  
  private boolean bS(int paramInt, String paramString)
  {
    AppMethodBeat.i(100184);
    if (paramInt == 1)
    {
      bool = p(this.xAI, paramString);
      AppMethodBeat.o(100184);
      return bool;
    }
    boolean bool = p(this.xAJ, paramString);
    AppMethodBeat.o(100184);
    return bool;
  }
  
  private static List<String> dBy()
  {
    AppMethodBeat.i(100181);
    g.afC();
    Object localObject = (String)g.afB().afk().get(335875, null);
    ad.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(100181);
      return null;
    }
    localObject = bt.S(((String)localObject).split(","));
    AppMethodBeat.o(100181);
    return localObject;
  }
  
  private static boolean p(List<String> paramList, String paramString)
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
  
  public final int Ny(int paramInt)
  {
    AppMethodBeat.i(100188);
    if ((("visible".equals(this.xTh.get(paramInt))) || ("invisible".equals(this.xTh.get(paramInt)))) && (this.xAF != null))
    {
      paramInt = this.xAF.size();
      AppMethodBeat.o(100188);
      return paramInt + 1;
    }
    AppMethodBeat.o(100188);
    return 0;
  }
  
  public final void ap(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(100180);
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
            AppMethodBeat.i(100177);
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof a.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (a.c)paramAnonymousView.getTag())
            {
              ad.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
              AppMethodBeat.o(100177);
              return;
            }
            if (a.a(a.this) != null) {
              a.a(a.this).a(paramAnonymousView);
            }
            AppMethodBeat.o(100177);
          }
        });
        paramView.setTag(locala);
        localObject1 = locala.xAS;
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 != null) && ((localObject2 instanceof c))) {
          break label394;
        }
        localObject2 = new c();
        ((c)localObject2).xAT = paramInt1;
        ((c)localObject2).xAU = paramInt2;
        ((View)localObject1).setTag(localObject2);
        label209:
        if (paramInt2 != this.xAF.size()) {
          break label551;
        }
        locala.titleView.setVisibility(8);
        locala.sVW.setVisibility(8);
        locala.tto.setVisibility(8);
        locala.xAS.setVisibility(8);
        locala.xAQ.setVisibility(0);
        locala.xAR.setVisibility(0);
        if (paramInt1 != this.xTa) {
          break label443;
        }
        if (this.xAL.size() <= 0) {
          break label419;
        }
        localObject1 = bt.n(Z(this.xAL), ",");
        locala.xAR.setText("√".concat(String.valueOf(localObject1)));
        locala.xAR.setVisibility(0);
        locala.xAR.setTextColor(this.mContext.getResources().getColor(2131100929));
      }
    }
    label394:
    label419:
    label551:
    for (;;)
    {
      AppMethodBeat.o(100187);
      return paramView;
      paramView = this.mInflater.inflate(2131495555, null);
      break;
      locala = (a)paramView.getTag();
      break label153;
      localObject1 = (c)((View)localObject1).getTag();
      ((c)localObject1).xAT = paramInt1;
      ((c)localObject1).xAU = paramInt2;
      break label209;
      locala.xAR.setText("");
      locala.xAR.setVisibility(8);
      continue;
      label443:
      if (paramInt1 == this.xSZ) {
        if (this.xAK.size() > 0)
        {
          localObject1 = bt.n(Z(this.xAK), ",");
          locala.xAR.setText("√".concat(String.valueOf(localObject1)));
          locala.xAR.setVisibility(0);
          locala.xAR.setTextColor(this.mContext.getResources().getColor(2131100928));
        }
        else
        {
          locala.xAR.setText("");
          locala.xAR.setVisibility(8);
          continue;
          locala.titleView.setVisibility(0);
          locala.sVW.setVisibility(0);
          locala.tto.setVisibility(0);
          locala.xAS.setVisibility(4);
          locala.xAQ.setVisibility(8);
          locala.xAR.setVisibility(8);
          localObject2 = (String)this.xAF.get(paramInt2);
          locala.titleView.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, (CharSequence)localObject2));
          TextView localTextView = locala.sVW;
          localObject1 = com.tencent.mm.plugin.label.a.a.cIS().aeI((String)localObject2);
          Object localObject3 = com.tencent.mm.plugin.label.a.a.cIS().aeL((String)localObject1);
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {}
          for (localObject1 = "";; localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, (CharSequence)localObject1))
          {
            localTextView.setText((CharSequence)localObject1);
            locala.xAS.setImageResource(2131691196);
            if (this.style != 1) {
              break label930;
            }
            if (paramInt1 != this.xSZ) {
              break label851;
            }
            if (!bS(1, (String)localObject2)) {
              break label837;
            }
            locala.tto.setImageResource(2131691180);
            break;
            localObject1 = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh((String)((Iterator)localObject3).next()));
            }
            localObject1 = bt.n((List)localObject1, ",");
          }
          label837:
          locala.tto.setImageResource(2131691182);
          continue;
          label851:
          if (paramInt1 == this.xTa)
          {
            if (this.xAG != paramInt1) {
              locala.tto.setImageResource(2131691183);
            }
            for (;;)
            {
              if (!bS(2, (String)localObject2)) {
                break label916;
              }
              locala.tto.setImageResource(2131691181);
              break;
              locala.tto.setImageResource(2131691181);
            }
            locala.tto.setImageResource(2131691183);
            continue;
            if (paramInt1 == this.xSZ)
            {
              if (bS(1, (String)localObject2)) {
                locala.tto.setImageResource(2131689936);
              } else {
                locala.tto.setImageResource(2131231750);
              }
            }
            else if (paramInt1 == this.xTa) {
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
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100179);
    Object localObject = this.xAF.get(paramInt2);
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
    return this.xTg;
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
        paramView = this.mInflater.inflate(2131495558, null);
        paramViewGroup = new a((byte)0);
        paramViewGroup.titleView = ((TextView)paramView.findViewById(2131304997));
        paramViewGroup.tto = ((ImageView)paramView.findViewById(2131304990));
        paramViewGroup.sVW = ((TextView)paramView.findViewById(2131304996));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(this.xAe[paramInt]);
        paramViewGroup.sVW.setText(this.xAE[paramInt]);
        if ((paramInt != this.xSY) && (paramInt != this.xSX)) {
          break label265;
        }
        if (this.xAG == paramInt) {
          break label233;
        }
        paramViewGroup.tto.setImageResource(2131691077);
      }
    }
    for (;;)
    {
      if ((!this.xAH) || (paramInt != this.xSY)) {
        break label451;
      }
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(100185);
      return paramView;
      paramView = this.mInflater.inflate(2131495557, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label102;
      label233:
      paramViewGroup.tto.setImageResource(2131691078);
      paramViewGroup.tto.setContentDescription(this.mContext.getString(2131763023));
      continue;
      label265:
      if (paramInt == this.xSZ)
      {
        if (this.xAG != paramInt)
        {
          paramViewGroup.tto.setImageResource(2131691077);
        }
        else
        {
          paramViewGroup.tto.setImageResource(2131691078);
          paramViewGroup.tto.setContentDescription(this.mContext.getString(2131763023));
        }
      }
      else if (paramInt == this.xTa) {
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
    public abstract void a(a.c paramc);
  }
  
  final class c
  {
    public int xAT;
    public int xAU;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.a
 * JD-Core Version:    0.7.0.1
 */