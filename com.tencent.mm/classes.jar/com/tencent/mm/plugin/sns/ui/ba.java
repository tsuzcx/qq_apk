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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ba
  extends AnimatedExpandableListView.a
{
  public static int AeL = 0;
  public static int AeM = 1;
  public static int AeN = 2;
  public static int[] AeO = { 2131763872, 2131763870, 2131763866, 2131763857 };
  public static int[] Aeo = { 2131763871, 2131763869, 2131763865, 2131763856 };
  ArrayList<String> AeP;
  public int AeQ;
  public boolean AeR;
  public ArrayList<String> AeS;
  public ArrayList<String> AeT;
  public ArrayList<String> AeU;
  public ArrayList<String> AeV;
  public ArrayList<String> AeW;
  public ArrayList<String> AeX;
  b AeY;
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  
  public ba(Context paramContext)
  {
    AppMethodBeat.i(98824);
    this.AeQ = 0;
    this.AeR = false;
    this.AeS = new ArrayList();
    this.AeT = new ArrayList();
    this.AeU = new ArrayList();
    this.AeV = new ArrayList();
    this.AeW = new ArrayList();
    this.AeX = new ArrayList();
    this.AeY = null;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBe, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label200;
      }
      AeL = 0;
    }
    for (AeM = 1;; AeM = 0)
    {
      AeN = AeM + 1;
      ad.i("MicroMsg.Sns.AnimatedExpandableListAdapter", "initWithConfig %s %s %s", new Object[] { Integer.valueOf(AeL), Integer.valueOf(AeM), Integer.valueOf(AeN) });
      AppMethodBeat.o(98824);
      return;
      i = 0;
      break;
      label200:
      AeL = -1;
    }
  }
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(98832);
    LinkedList localLinkedList = new LinkedList();
    g.ajD();
    if (!g.ajA().aiK())
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
      g.ajD();
      am localam = ((l)g.ab(l.class)).azp().Bf(str);
      paramList = str;
      if (localam != null)
      {
        paramList = str;
        if ((int)localam.gfj != 0) {
          paramList = localam.adv();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(98832);
    return localLinkedList;
  }
  
  public static void aAP(String paramString)
  {
    AppMethodBeat.i(98828);
    ad.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[] { paramString });
    if (ecm() != null)
    {
      ArrayList localArrayList = new ArrayList(ecm());
      if (!o(localArrayList, paramString))
      {
        if (localArrayList.size() == 5) {
          localArrayList.remove(4);
        }
        localArrayList.add(0, paramString);
        paramString = bt.m(localArrayList, ",");
        g.ajD();
        g.ajC().ajl().set(335875, paramString);
      }
      AppMethodBeat.o(98828);
      return;
    }
    g.ajD();
    g.ajC().ajl().set(335875, paramString);
    AppMethodBeat.o(98828);
  }
  
  private boolean cd(int paramInt, String paramString)
  {
    AppMethodBeat.i(98830);
    if (paramInt == 1)
    {
      bool = o(this.AeS, paramString);
      AppMethodBeat.o(98830);
      return bool;
    }
    boolean bool = o(this.AeT, paramString);
    AppMethodBeat.o(98830);
    return bool;
  }
  
  private static List<String> ecm()
  {
    AppMethodBeat.i(98827);
    g.ajD();
    Object localObject = (String)g.ajC().ajl().get(335875, null);
    ad.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(98827);
      return null;
    }
    localObject = bt.U(((String)localObject).split(","));
    AppMethodBeat.o(98827);
    return localObject;
  }
  
  private static boolean o(List<String> paramList, String paramString)
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
  
  public final int Rl(int paramInt)
  {
    AppMethodBeat.i(98834);
    if ((paramInt > 1) && (this.AeP != null))
    {
      paramInt = this.AeP.size();
      int i = AeN;
      AppMethodBeat.o(98834);
      return paramInt + i;
    }
    AppMethodBeat.o(98834);
    return 0;
  }
  
  public final void az(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(98826);
    Object localObject2 = ecm();
    Object localObject1 = new ArrayList();
    if ((localObject2 != null) && (paramArrayList != null))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (o(paramArrayList, str))
        {
          paramArrayList.remove(str);
          ((ArrayList)localObject1).add(str);
        }
      }
      paramArrayList.addAll(0, (Collection)localObject1);
      localObject1 = bt.m((List)localObject1, ",");
      g.ajD();
      g.ajC().ajl().set(335875, localObject1);
    }
    this.AeP = paramArrayList;
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
        locala.vgS = ((TextView)paramView.findViewById(2131304996));
        locala.Afa = ((TextView)paramView.findViewById(2131304995));
        locala.Afb = ((TextView)paramView.findViewById(2131304994));
        locala.vEo = ((ImageView)paramView.findViewById(2131304990));
        locala.Afc = ((ImageView)paramView.findViewById(2131304993));
        locala.Afc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98823);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof ba.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (ba.c)paramAnonymousView.getTag())
            {
              ad.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98823);
              return;
            }
            if (ba.a(ba.this) != null) {
              ba.a(ba.this).a(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98823);
          }
        });
        paramView.setTag(locala);
        if (paramInt2 != AeM) {
          break label511;
        }
        locala.titleView.setVisibility(8);
        locala.vgS.setVisibility(8);
        locala.vEo.setVisibility(8);
        locala.Afc.setVisibility(8);
        locala.Afa.setVisibility(0);
        locala.Afa.setText(this.mContext.getResources().getString(2131763873));
        locala.Afb.setVisibility(0);
        if (paramInt1 != 3) {
          break label391;
        }
        if (this.AeV.size() <= 0) {
          break label367;
        }
        localObject1 = bt.m(P(this.AeV), ",");
        locala.Afb.setText(k.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.Afb.getTextSize()));
        locala.Afb.setVisibility(0);
        locala.Afb.setTextColor(this.mContext.getResources().getColor(2131100929));
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
      locala.Afb.setText("");
      locala.Afb.setVisibility(8);
      continue;
      label1106:
      if (paramInt1 == 2) {
        label869:
        label1273:
        if (this.AeU.size() > 0)
        {
          localObject1 = bt.m(P(this.AeU), ",");
          locala.Afb.setText(k.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.Afb.getTextSize()));
          locala.Afb.setVisibility(0);
          locala.Afb.setTextColor(this.mContext.getResources().getColor(2131100928));
        }
        else
        {
          locala.Afb.setText("");
          locala.Afb.setVisibility(8);
          continue;
          label511:
          if (paramInt2 == AeL)
          {
            locala.titleView.setVisibility(8);
            locala.vgS.setVisibility(8);
            locala.vEo.setVisibility(8);
            locala.Afc.setVisibility(8);
            locala.Afa.setVisibility(0);
            locala.Afa.setText(this.mContext.getResources().getString(2131763874));
            locala.Afb.setVisibility(0);
            if (paramInt1 == 3)
            {
              if (this.AeX.size() > 0)
              {
                localObject1 = bt.m(P(this.AeX), ",");
                locala.Afb.setText("√".concat(String.valueOf(localObject1)));
                locala.Afb.setVisibility(0);
                locala.Afb.setTextColor(this.mContext.getResources().getColor(2131100929));
              }
              else
              {
                locala.Afb.setText("");
                locala.Afb.setVisibility(8);
              }
            }
            else if (paramInt1 == 2) {
              if (this.AeW.size() > 0)
              {
                localObject1 = bt.m(P(this.AeW), ",");
                locala.Afb.setText("√".concat(String.valueOf(localObject1)));
                locala.Afb.setVisibility(0);
                locala.Afb.setTextColor(this.mContext.getResources().getColor(2131100928));
              }
              else
              {
                locala.Afb.setText("");
                locala.Afb.setVisibility(8);
              }
            }
          }
          else
          {
            paramInt2 -= AeN;
            localObject1 = locala.Afc;
            Object localObject2 = ((View)localObject1).getTag();
            TextView localTextView;
            Object localObject3;
            if ((localObject2 == null) || (!(localObject2 instanceof c)))
            {
              localObject2 = new c();
              ((c)localObject2).Afd = paramInt1;
              ((c)localObject2).Afe = paramInt2;
              ((View)localObject1).setTag(localObject2);
              locala.titleView.setVisibility(0);
              locala.vgS.setVisibility(0);
              locala.vEo.setVisibility(0);
              locala.Afc.setVisibility(0);
              locala.Afa.setVisibility(8);
              locala.Afb.setVisibility(8);
              localObject2 = (String)this.AeP.get(paramInt2);
              locala.titleView.setText(k.c(this.mContext, (CharSequence)localObject2));
              localTextView = locala.vgS;
              localObject1 = com.tencent.mm.plugin.label.a.a.dfo().aom((String)localObject2);
              localObject3 = com.tencent.mm.plugin.label.a.a.dfo().aop((String)localObject1);
              if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
                break label1106;
              }
            }
            for (localObject1 = "";; localObject1 = k.c(this.mContext, (CharSequence)localObject1))
            {
              localTextView.setText((CharSequence)localObject1);
              locala.Afc.setImageDrawable(ao.k(this.mContext, 2131691196, this.mContext.getResources().getColor(2131099676)));
              if (this.style != 1) {
                break label1287;
              }
              if (paramInt1 != 2) {
                break label1211;
              }
              if (!cd(1, (String)localObject2)) {
                break label1197;
              }
              locala.vEo.setImageResource(2131691180);
              break;
              localObject1 = (c)((View)localObject1).getTag();
              ((c)localObject1).Afd = paramInt1;
              ((c)localObject1).Afe = paramInt2;
              break label869;
              localObject1 = new ArrayList(((List)localObject3).size());
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf((String)((Iterator)localObject3).next()));
              }
              localObject1 = bt.m((List)localObject1, ",");
            }
            locala.vEo.setImageResource(2131691182);
            continue;
            if (paramInt1 == 3)
            {
              if (this.AeQ != paramInt1) {
                locala.vEo.setImageResource(2131691183);
              }
              for (;;)
              {
                if (!cd(2, (String)localObject2)) {
                  break label1273;
                }
                locala.vEo.setImageResource(2131691181);
                break;
                locala.vEo.setImageResource(2131691181);
              }
              locala.vEo.setImageResource(2131691183);
              continue;
              if (paramInt1 == 2)
              {
                if (cd(1, (String)localObject2)) {
                  locala.vEo.setImageResource(2131689936);
                } else {
                  locala.vEo.setImageResource(2131231750);
                }
              }
              else if (paramInt1 == 3) {
                if (cd(2, (String)localObject2)) {
                  locala.vEo.setImageResource(2131689940);
                } else {
                  locala.vEo.setImageResource(2131231750);
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
    Object localObject = this.AeP.get(paramInt2);
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
        paramViewGroup.vEo = ((ImageView)paramView.findViewById(2131304990));
        paramViewGroup.vgS = ((TextView)paramView.findViewById(2131304996));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(Aeo[paramInt]);
        paramViewGroup.vgS.setText(AeO[paramInt]);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      if ((!this.AeR) || (paramInt != 1)) {
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
      if (this.AeQ != paramInt)
      {
        paramViewGroup.vEo.setImageResource(2131691077);
      }
      else
      {
        paramViewGroup.vEo.setImageResource(2131691078);
        paramViewGroup.vEo.setContentDescription(this.mContext.getString(2131763023));
        continue;
        if (this.AeQ != paramInt)
        {
          paramViewGroup.vEo.setImageResource(2131691077);
        }
        else
        {
          paramViewGroup.vEo.setImageResource(2131691078);
          paramViewGroup.vEo.setContentDescription(this.mContext.getString(2131763023));
          continue;
          if (this.style == 1)
          {
            if (this.AeQ != paramInt)
            {
              paramViewGroup.vEo.setImageResource(2131691077);
            }
            else
            {
              paramViewGroup.vEo.setImageResource(2131691106);
              paramViewGroup.vEo.setContentDescription(this.mContext.getString(2131763023));
            }
          }
          else if (this.AeQ != paramInt)
          {
            paramViewGroup.vEo.setImageResource(2131691077);
          }
          else
          {
            paramViewGroup.vEo.setImageResource(2131691079);
            paramViewGroup.vEo.setContentDescription(this.mContext.getString(2131763023));
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
    TextView Afa;
    TextView Afb;
    ImageView Afc;
    TextView titleView;
    ImageView vEo;
    TextView vgS;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(ba.c paramc);
  }
  
  final class c
  {
    public int Afd;
    public int Afe;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba
 * JD-Core Version:    0.7.0.1
 */