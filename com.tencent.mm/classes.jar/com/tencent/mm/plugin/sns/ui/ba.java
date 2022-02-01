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
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  public static int[] AvA = { 2131763871, 2131763869, 2131763865, 2131763856 };
  public static int AvX = 0;
  public static int AvY = 1;
  public static int AvZ = 2;
  public static int[] Awa = { 2131763872, 2131763870, 2131763866, 2131763857 };
  ArrayList<String> Awb;
  public int Awc;
  public boolean Awd;
  public ArrayList<String> Awe;
  public ArrayList<String> Awf;
  public ArrayList<String> Awg;
  public ArrayList<String> Awh;
  public ArrayList<String> Awi;
  public ArrayList<String> Awj;
  b Awk;
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  
  public ba(Context paramContext)
  {
    AppMethodBeat.i(98824);
    this.Awc = 0;
    this.Awd = false;
    this.Awe = new ArrayList();
    this.Awf = new ArrayList();
    this.Awg = new ArrayList();
    this.Awh = new ArrayList();
    this.Awi = new ArrayList();
    this.Awj = new ArrayList();
    this.Awk = null;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIx, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label200;
      }
      AvX = 0;
    }
    for (AvY = 1;; AvY = 0)
    {
      AvZ = AvY + 1;
      ae.i("MicroMsg.Sns.AnimatedExpandableListAdapter", "initWithConfig %s %s %s", new Object[] { Integer.valueOf(AvX), Integer.valueOf(AvY), Integer.valueOf(AvZ) });
      AppMethodBeat.o(98824);
      return;
      i = 0;
      break;
      label200:
      AvX = -1;
    }
  }
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(98832);
    LinkedList localLinkedList = new LinkedList();
    g.ajS();
    if (!g.ajP().aiZ())
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
      g.ajS();
      an localan = ((l)g.ab(l.class)).azF().BH(str);
      paramList = str;
      if (localan != null)
      {
        paramList = str;
        if ((int)localan.ght != 0) {
          paramList = localan.adG();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(98832);
    return localLinkedList;
  }
  
  public static void aCg(String paramString)
  {
    AppMethodBeat.i(98828);
    ae.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[] { paramString });
    if (efT() != null)
    {
      ArrayList localArrayList = new ArrayList(efT());
      if (!o(localArrayList, paramString))
      {
        if (localArrayList.size() == 5) {
          localArrayList.remove(4);
        }
        localArrayList.add(0, paramString);
        paramString = bu.m(localArrayList, ",");
        g.ajS();
        g.ajR().ajA().set(335875, paramString);
      }
      AppMethodBeat.o(98828);
      return;
    }
    g.ajS();
    g.ajR().ajA().set(335875, paramString);
    AppMethodBeat.o(98828);
  }
  
  private boolean cd(int paramInt, String paramString)
  {
    AppMethodBeat.i(98830);
    if (paramInt == 1)
    {
      bool = o(this.Awe, paramString);
      AppMethodBeat.o(98830);
      return bool;
    }
    boolean bool = o(this.Awf, paramString);
    AppMethodBeat.o(98830);
    return bool;
  }
  
  private static List<String> efT()
  {
    AppMethodBeat.i(98827);
    g.ajS();
    Object localObject = (String)g.ajR().ajA().get(335875, null);
    ae.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(98827);
      return null;
    }
    localObject = bu.U(((String)localObject).split(","));
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
  
  public final int RS(int paramInt)
  {
    AppMethodBeat.i(98834);
    if ((paramInt > 1) && (this.Awb != null))
    {
      paramInt = this.Awb.size();
      int i = AvZ;
      AppMethodBeat.o(98834);
      return paramInt + i;
    }
    AppMethodBeat.o(98834);
    return 0;
  }
  
  public final void aA(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(98826);
    Object localObject2 = efT();
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
      localObject1 = bu.m((List)localObject1, ",");
      g.ajS();
      g.ajR().ajA().set(335875, localObject1);
    }
    this.Awb = paramArrayList;
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
        locala.vsZ = ((TextView)paramView.findViewById(2131304996));
        locala.Awm = ((TextView)paramView.findViewById(2131304995));
        locala.Awn = ((TextView)paramView.findViewById(2131304994));
        locala.vQs = ((ImageView)paramView.findViewById(2131304990));
        locala.Awo = ((ImageView)paramView.findViewById(2131304993));
        locala.Awo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98823);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof ba.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (ba.c)paramAnonymousView.getTag())
            {
              ae.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
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
        if (paramInt2 != AvY) {
          break label511;
        }
        locala.titleView.setVisibility(8);
        locala.vsZ.setVisibility(8);
        locala.vQs.setVisibility(8);
        locala.Awo.setVisibility(8);
        locala.Awm.setVisibility(0);
        locala.Awm.setText(this.mContext.getResources().getString(2131763873));
        locala.Awn.setVisibility(0);
        if (paramInt1 != 3) {
          break label391;
        }
        if (this.Awh.size() <= 0) {
          break label367;
        }
        localObject1 = bu.m(P(this.Awh), ",");
        locala.Awn.setText(k.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.Awn.getTextSize()));
        locala.Awn.setVisibility(0);
        locala.Awn.setTextColor(this.mContext.getResources().getColor(2131100929));
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
      locala.Awn.setText("");
      locala.Awn.setVisibility(8);
      continue;
      label1106:
      if (paramInt1 == 2) {
        label869:
        label1273:
        if (this.Awg.size() > 0)
        {
          localObject1 = bu.m(P(this.Awg), ",");
          locala.Awn.setText(k.b(this.mContext, "√".concat(String.valueOf(localObject1)), locala.Awn.getTextSize()));
          locala.Awn.setVisibility(0);
          locala.Awn.setTextColor(this.mContext.getResources().getColor(2131100928));
        }
        else
        {
          locala.Awn.setText("");
          locala.Awn.setVisibility(8);
          continue;
          label511:
          if (paramInt2 == AvX)
          {
            locala.titleView.setVisibility(8);
            locala.vsZ.setVisibility(8);
            locala.vQs.setVisibility(8);
            locala.Awo.setVisibility(8);
            locala.Awm.setVisibility(0);
            locala.Awm.setText(this.mContext.getResources().getString(2131763874));
            locala.Awn.setVisibility(0);
            if (paramInt1 == 3)
            {
              if (this.Awj.size() > 0)
              {
                localObject1 = bu.m(P(this.Awj), ",");
                locala.Awn.setText("√".concat(String.valueOf(localObject1)));
                locala.Awn.setVisibility(0);
                locala.Awn.setTextColor(this.mContext.getResources().getColor(2131100929));
              }
              else
              {
                locala.Awn.setText("");
                locala.Awn.setVisibility(8);
              }
            }
            else if (paramInt1 == 2) {
              if (this.Awi.size() > 0)
              {
                localObject1 = bu.m(P(this.Awi), ",");
                locala.Awn.setText("√".concat(String.valueOf(localObject1)));
                locala.Awn.setVisibility(0);
                locala.Awn.setTextColor(this.mContext.getResources().getColor(2131100928));
              }
              else
              {
                locala.Awn.setText("");
                locala.Awn.setVisibility(8);
              }
            }
          }
          else
          {
            paramInt2 -= AvZ;
            localObject1 = locala.Awo;
            Object localObject2 = ((View)localObject1).getTag();
            TextView localTextView;
            Object localObject3;
            if ((localObject2 == null) || (!(localObject2 instanceof c)))
            {
              localObject2 = new c();
              ((c)localObject2).Awp = paramInt1;
              ((c)localObject2).Awq = paramInt2;
              ((View)localObject1).setTag(localObject2);
              locala.titleView.setVisibility(0);
              locala.vsZ.setVisibility(0);
              locala.vQs.setVisibility(0);
              locala.Awo.setVisibility(0);
              locala.Awm.setVisibility(8);
              locala.Awn.setVisibility(8);
              localObject2 = (String)this.Awb.get(paramInt2);
              locala.titleView.setText(k.c(this.mContext, (CharSequence)localObject2));
              localTextView = locala.vsZ;
              localObject1 = com.tencent.mm.plugin.label.a.a.dig().apo((String)localObject2);
              localObject3 = com.tencent.mm.plugin.label.a.a.dig().apr((String)localObject1);
              if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
                break label1106;
              }
            }
            for (localObject1 = "";; localObject1 = k.c(this.mContext, (CharSequence)localObject1))
            {
              localTextView.setText((CharSequence)localObject1);
              locala.Awo.setImageDrawable(ao.k(this.mContext, 2131691196, this.mContext.getResources().getColor(2131099676)));
              if (this.style != 1) {
                break label1287;
              }
              if (paramInt1 != 2) {
                break label1211;
              }
              if (!cd(1, (String)localObject2)) {
                break label1197;
              }
              locala.vQs.setImageResource(2131691180);
              break;
              localObject1 = (c)((View)localObject1).getTag();
              ((c)localObject1).Awp = paramInt1;
              ((c)localObject1).Awq = paramInt2;
              break label869;
              localObject1 = new ArrayList(((List)localObject3).size());
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP((String)((Iterator)localObject3).next()));
              }
              localObject1 = bu.m((List)localObject1, ",");
            }
            locala.vQs.setImageResource(2131691182);
            continue;
            if (paramInt1 == 3)
            {
              if (this.Awc != paramInt1) {
                locala.vQs.setImageResource(2131691183);
              }
              for (;;)
              {
                if (!cd(2, (String)localObject2)) {
                  break label1273;
                }
                locala.vQs.setImageResource(2131691181);
                break;
                locala.vQs.setImageResource(2131691181);
              }
              locala.vQs.setImageResource(2131691183);
              continue;
              if (paramInt1 == 2)
              {
                if (cd(1, (String)localObject2)) {
                  locala.vQs.setImageResource(2131689936);
                } else {
                  locala.vQs.setImageResource(2131231750);
                }
              }
              else if (paramInt1 == 3) {
                if (cd(2, (String)localObject2)) {
                  locala.vQs.setImageResource(2131689940);
                } else {
                  locala.vQs.setImageResource(2131231750);
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
    Object localObject = this.Awb.get(paramInt2);
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
        paramViewGroup.vQs = ((ImageView)paramView.findViewById(2131304990));
        paramViewGroup.vsZ = ((TextView)paramView.findViewById(2131304996));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(AvA[paramInt]);
        paramViewGroup.vsZ.setText(Awa[paramInt]);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      if ((!this.Awd) || (paramInt != 1)) {
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
      if (this.Awc != paramInt)
      {
        paramViewGroup.vQs.setImageResource(2131691077);
      }
      else
      {
        paramViewGroup.vQs.setImageResource(2131691078);
        paramViewGroup.vQs.setContentDescription(this.mContext.getString(2131763023));
        continue;
        if (this.Awc != paramInt)
        {
          paramViewGroup.vQs.setImageResource(2131691077);
        }
        else
        {
          paramViewGroup.vQs.setImageResource(2131691078);
          paramViewGroup.vQs.setContentDescription(this.mContext.getString(2131763023));
          continue;
          if (this.style == 1)
          {
            if (this.Awc != paramInt)
            {
              paramViewGroup.vQs.setImageResource(2131691077);
            }
            else
            {
              paramViewGroup.vQs.setImageResource(2131691106);
              paramViewGroup.vQs.setContentDescription(this.mContext.getString(2131763023));
            }
          }
          else if (this.Awc != paramInt)
          {
            paramViewGroup.vQs.setImageResource(2131691077);
          }
          else
          {
            paramViewGroup.vQs.setImageResource(2131691079);
            paramViewGroup.vQs.setContentDescription(this.mContext.getString(2131763023));
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
    TextView Awm;
    TextView Awn;
    ImageView Awo;
    TextView titleView;
    ImageView vQs;
    TextView vsZ;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(ba.c paramc);
  }
  
  final class c
  {
    public int Awp;
    public int Awq;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba
 * JD-Core Version:    0.7.0.1
 */