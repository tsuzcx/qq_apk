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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  public int[] yMS;
  public int[] yNs;
  ArrayList<String> yNt;
  public int yNu;
  public boolean yNv;
  public ArrayList<String> yNw;
  public ArrayList<String> yNx;
  public ArrayList<String> yNy;
  public ArrayList<String> yNz;
  public int zfT;
  public int zfU;
  public int zfV;
  public int zfW;
  int zgc;
  List<String> zgd;
  b zge;
  boolean zgf;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(100178);
    this.zgc = 4;
    this.zfT = 0;
    this.zfU = 1;
    this.zfV = 2;
    this.zfW = 3;
    this.yMS = new int[] { 2131763871, 2131763869, 2131763865, 2131763856 };
    this.yNs = new int[] { 2131763872, 2131763870, 2131763866, 2131763857 };
    this.yNu = 0;
    this.yNv = false;
    this.yNw = new ArrayList();
    this.yNx = new ArrayList();
    this.yNy = new ArrayList();
    this.yNz = new ArrayList();
    this.zge = null;
    this.zgf = true;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    AppMethodBeat.o(100178);
  }
  
  private static List<String> Q(List<String> paramList)
  {
    AppMethodBeat.i(100186);
    LinkedList localLinkedList = new LinkedList();
    g.agS();
    if (!g.agP().afY())
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
    AppMethodBeat.o(100186);
    return localLinkedList;
  }
  
  public static void avI(String paramString)
  {
    AppMethodBeat.i(100182);
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
      AppMethodBeat.o(100182);
      return;
    }
    g.agS();
    g.agR().agA().set(335875, paramString);
    AppMethodBeat.o(100182);
  }
  
  private boolean bW(int paramInt, String paramString)
  {
    AppMethodBeat.i(100184);
    if (paramInt == 1)
    {
      bool = p(this.yNw, paramString);
      AppMethodBeat.o(100184);
      return bool;
    }
    boolean bool = p(this.yNx, paramString);
    AppMethodBeat.o(100184);
    return bool;
  }
  
  private static List<String> dPV()
  {
    AppMethodBeat.i(100181);
    g.agS();
    Object localObject = (String)g.agR().agA().get(335875, null);
    ac.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(100181);
      return null;
    }
    localObject = bs.S(((String)localObject).split(","));
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
  
  public final int PC(int paramInt)
  {
    AppMethodBeat.i(100188);
    if ((("visible".equals(this.zgd.get(paramInt))) || ("invisible".equals(this.zgd.get(paramInt)))) && (this.yNt != null))
    {
      paramInt = this.yNt.size();
      AppMethodBeat.o(100188);
      return paramInt + 1;
    }
    AppMethodBeat.o(100188);
    return 0;
  }
  
  public final void aB(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(100180);
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
        locala.uej = ((TextView)paramView.findViewById(2131304996));
        locala.yNE = ((TextView)paramView.findViewById(2131304995));
        locala.yNF = ((TextView)paramView.findViewById(2131304994));
        locala.uBH = ((ImageView)paramView.findViewById(2131304990));
        locala.yNG = ((ImageView)paramView.findViewById(2131304993));
        locala.yNG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(100177);
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof a.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (a.c)paramAnonymousView.getTag())
            {
              ac.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
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
        localObject1 = locala.yNG;
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 != null) && ((localObject2 instanceof c))) {
          break label394;
        }
        localObject2 = new c();
        ((c)localObject2).yNH = paramInt1;
        ((c)localObject2).yNI = paramInt2;
        ((View)localObject1).setTag(localObject2);
        label209:
        if (paramInt2 != this.yNt.size()) {
          break label551;
        }
        locala.titleView.setVisibility(8);
        locala.uej.setVisibility(8);
        locala.uBH.setVisibility(8);
        locala.yNG.setVisibility(8);
        locala.yNE.setVisibility(0);
        locala.yNF.setVisibility(0);
        if (paramInt1 != this.zfW) {
          break label443;
        }
        if (this.yNz.size() <= 0) {
          break label419;
        }
        localObject1 = bs.n(Q(this.yNz), ",");
        locala.yNF.setText("√".concat(String.valueOf(localObject1)));
        locala.yNF.setVisibility(0);
        locala.yNF.setTextColor(this.mContext.getResources().getColor(2131100929));
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
      ((c)localObject1).yNH = paramInt1;
      ((c)localObject1).yNI = paramInt2;
      break label209;
      locala.yNF.setText("");
      locala.yNF.setVisibility(8);
      continue;
      label443:
      if (paramInt1 == this.zfV) {
        if (this.yNy.size() > 0)
        {
          localObject1 = bs.n(Q(this.yNy), ",");
          locala.yNF.setText("√".concat(String.valueOf(localObject1)));
          locala.yNF.setVisibility(0);
          locala.yNF.setTextColor(this.mContext.getResources().getColor(2131100928));
        }
        else
        {
          locala.yNF.setText("");
          locala.yNF.setVisibility(8);
          continue;
          locala.titleView.setVisibility(0);
          locala.uej.setVisibility(0);
          locala.uBH.setVisibility(0);
          locala.yNG.setVisibility(4);
          locala.yNE.setVisibility(8);
          locala.yNF.setVisibility(8);
          localObject2 = (String)this.yNt.get(paramInt2);
          locala.titleView.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, (CharSequence)localObject2));
          TextView localTextView = locala.uej;
          localObject1 = com.tencent.mm.plugin.label.a.a.cWd().ajA((String)localObject2);
          Object localObject3 = com.tencent.mm.plugin.label.a.a.cWd().ajD((String)localObject1);
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {}
          for (localObject1 = "";; localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, (CharSequence)localObject1))
          {
            localTextView.setText((CharSequence)localObject1);
            locala.yNG.setImageResource(2131691196);
            if (this.style != 1) {
              break label930;
            }
            if (paramInt1 != this.zfV) {
              break label851;
            }
            if (!bW(1, (String)localObject2)) {
              break label837;
            }
            locala.uBH.setImageResource(2131691180);
            break;
            localObject1 = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk((String)((Iterator)localObject3).next()));
            }
            localObject1 = bs.n((List)localObject1, ",");
          }
          label837:
          locala.uBH.setImageResource(2131691182);
          continue;
          label851:
          if (paramInt1 == this.zfW)
          {
            if (this.yNu != paramInt1) {
              locala.uBH.setImageResource(2131691183);
            }
            for (;;)
            {
              if (!bW(2, (String)localObject2)) {
                break label916;
              }
              locala.uBH.setImageResource(2131691181);
              break;
              locala.uBH.setImageResource(2131691181);
            }
            locala.uBH.setImageResource(2131691183);
            continue;
            if (paramInt1 == this.zfV)
            {
              if (bW(1, (String)localObject2)) {
                locala.uBH.setImageResource(2131689936);
              } else {
                locala.uBH.setImageResource(2131231750);
              }
            }
            else if (paramInt1 == this.zfW) {
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
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100179);
    Object localObject = this.yNt.get(paramInt2);
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
    return this.zgc;
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
        paramViewGroup.uBH = ((ImageView)paramView.findViewById(2131304990));
        paramViewGroup.uej = ((TextView)paramView.findViewById(2131304996));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(this.yMS[paramInt]);
        paramViewGroup.uej.setText(this.yNs[paramInt]);
        if ((paramInt != this.zfU) && (paramInt != this.zfT)) {
          break label265;
        }
        if (this.yNu == paramInt) {
          break label233;
        }
        paramViewGroup.uBH.setImageResource(2131691077);
      }
    }
    for (;;)
    {
      if ((!this.yNv) || (paramInt != this.zfU)) {
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
      paramViewGroup.uBH.setImageResource(2131691078);
      paramViewGroup.uBH.setContentDescription(this.mContext.getString(2131763023));
      continue;
      label265:
      if (paramInt == this.zfV)
      {
        if (this.yNu != paramInt)
        {
          paramViewGroup.uBH.setImageResource(2131691077);
        }
        else
        {
          paramViewGroup.uBH.setImageResource(2131691078);
          paramViewGroup.uBH.setContentDescription(this.mContext.getString(2131763023));
        }
      }
      else if (paramInt == this.zfW) {
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
    public abstract void a(a.c paramc);
  }
  
  final class c
  {
    public int yNH;
    public int yNI;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.a
 * JD-Core Version:    0.7.0.1
 */