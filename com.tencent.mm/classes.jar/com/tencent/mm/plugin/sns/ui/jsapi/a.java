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
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends AnimatedExpandableListView.a
{
  public int[] AeO;
  ArrayList<String> AeP;
  public int AeQ;
  public boolean AeR;
  public ArrayList<String> AeS;
  public ArrayList<String> AeT;
  public ArrayList<String> AeU;
  public ArrayList<String> AeV;
  public int[] Aeo;
  public int AxS;
  public int AxT;
  public int AxU;
  public int AxV;
  int Ayb;
  List<String> Ayc;
  b Ayd;
  boolean Aye;
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(100178);
    this.Ayb = 4;
    this.AxS = 0;
    this.AxT = 1;
    this.AxU = 2;
    this.AxV = 3;
    this.Aeo = new int[] { 2131763871, 2131763869, 2131763865, 2131763856 };
    this.AeO = new int[] { 2131763872, 2131763870, 2131763866, 2131763857 };
    this.AeQ = 0;
    this.AeR = false;
    this.AeS = new ArrayList();
    this.AeT = new ArrayList();
    this.AeU = new ArrayList();
    this.AeV = new ArrayList();
    this.Ayd = null;
    this.Aye = true;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    AppMethodBeat.o(100178);
  }
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(100186);
    LinkedList localLinkedList = new LinkedList();
    g.ajD();
    if (!g.ajA().aiK())
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
    AppMethodBeat.o(100186);
    return localLinkedList;
  }
  
  public static void aAP(String paramString)
  {
    AppMethodBeat.i(100182);
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
      AppMethodBeat.o(100182);
      return;
    }
    g.ajD();
    g.ajC().ajl().set(335875, paramString);
    AppMethodBeat.o(100182);
  }
  
  private boolean cd(int paramInt, String paramString)
  {
    AppMethodBeat.i(100184);
    if (paramInt == 1)
    {
      bool = o(this.AeS, paramString);
      AppMethodBeat.o(100184);
      return bool;
    }
    boolean bool = o(this.AeT, paramString);
    AppMethodBeat.o(100184);
    return bool;
  }
  
  private static List<String> ecm()
  {
    AppMethodBeat.i(100181);
    g.ajD();
    Object localObject = (String)g.ajC().ajl().get(335875, null);
    ad.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(100181);
      return null;
    }
    localObject = bt.U(((String)localObject).split(","));
    AppMethodBeat.o(100181);
    return localObject;
  }
  
  private static boolean o(List<String> paramList, String paramString)
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
  
  public final int Rl(int paramInt)
  {
    AppMethodBeat.i(100188);
    if ((("visible".equals(this.Ayc.get(paramInt))) || ("invisible".equals(this.Ayc.get(paramInt)))) && (this.AeP != null))
    {
      paramInt = this.AeP.size();
      AppMethodBeat.o(100188);
      return paramInt + 1;
    }
    AppMethodBeat.o(100188);
    return 0;
  }
  
  public final void az(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(100180);
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
        locala.vgS = ((TextView)paramView.findViewById(2131304996));
        locala.Afa = ((TextView)paramView.findViewById(2131304995));
        locala.Afb = ((TextView)paramView.findViewById(2131304994));
        locala.vEo = ((ImageView)paramView.findViewById(2131304990));
        locala.Afc = ((ImageView)paramView.findViewById(2131304993));
        locala.Afc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(100177);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/jsapi/JsapiSnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof a.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (a.c)paramAnonymousView.getTag())
            {
              ad.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
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
        localObject1 = locala.Afc;
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 != null) && ((localObject2 instanceof c))) {
          break label394;
        }
        localObject2 = new c();
        ((c)localObject2).Afd = paramInt1;
        ((c)localObject2).Afe = paramInt2;
        ((View)localObject1).setTag(localObject2);
        label209:
        if (paramInt2 != this.AeP.size()) {
          break label551;
        }
        locala.titleView.setVisibility(8);
        locala.vgS.setVisibility(8);
        locala.vEo.setVisibility(8);
        locala.Afc.setVisibility(8);
        locala.Afa.setVisibility(0);
        locala.Afb.setVisibility(0);
        if (paramInt1 != this.AxV) {
          break label443;
        }
        if (this.AeV.size() <= 0) {
          break label419;
        }
        localObject1 = bt.m(P(this.AeV), ",");
        locala.Afb.setText("√".concat(String.valueOf(localObject1)));
        locala.Afb.setVisibility(0);
        locala.Afb.setTextColor(this.mContext.getResources().getColor(2131100929));
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
      ((c)localObject1).Afd = paramInt1;
      ((c)localObject1).Afe = paramInt2;
      break label209;
      locala.Afb.setText("");
      locala.Afb.setVisibility(8);
      continue;
      label443:
      if (paramInt1 == this.AxU) {
        if (this.AeU.size() > 0)
        {
          localObject1 = bt.m(P(this.AeU), ",");
          locala.Afb.setText("√".concat(String.valueOf(localObject1)));
          locala.Afb.setVisibility(0);
          locala.Afb.setTextColor(this.mContext.getResources().getColor(2131100928));
        }
        else
        {
          locala.Afb.setText("");
          locala.Afb.setVisibility(8);
          continue;
          locala.titleView.setVisibility(0);
          locala.vgS.setVisibility(0);
          locala.vEo.setVisibility(0);
          locala.Afc.setVisibility(4);
          locala.Afa.setVisibility(8);
          locala.Afb.setVisibility(8);
          localObject2 = (String)this.AeP.get(paramInt2);
          locala.titleView.setText(k.c(this.mContext, (CharSequence)localObject2));
          TextView localTextView = locala.vgS;
          localObject1 = com.tencent.mm.plugin.label.a.a.dfo().aom((String)localObject2);
          Object localObject3 = com.tencent.mm.plugin.label.a.a.dfo().aop((String)localObject1);
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {}
          for (localObject1 = "";; localObject1 = k.c(this.mContext, (CharSequence)localObject1))
          {
            localTextView.setText((CharSequence)localObject1);
            locala.Afc.setImageResource(2131691196);
            if (this.style != 1) {
              break label930;
            }
            if (paramInt1 != this.AxU) {
              break label851;
            }
            if (!cd(1, (String)localObject2)) {
              break label837;
            }
            locala.vEo.setImageResource(2131691180);
            break;
            localObject1 = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf((String)((Iterator)localObject3).next()));
            }
            localObject1 = bt.m((List)localObject1, ",");
          }
          label837:
          locala.vEo.setImageResource(2131691182);
          continue;
          label851:
          if (paramInt1 == this.AxV)
          {
            if (this.AeQ != paramInt1) {
              locala.vEo.setImageResource(2131691183);
            }
            for (;;)
            {
              if (!cd(2, (String)localObject2)) {
                break label916;
              }
              locala.vEo.setImageResource(2131691181);
              break;
              locala.vEo.setImageResource(2131691181);
            }
            locala.vEo.setImageResource(2131691183);
            continue;
            if (paramInt1 == this.AxU)
            {
              if (cd(1, (String)localObject2)) {
                locala.vEo.setImageResource(2131689936);
              } else {
                locala.vEo.setImageResource(2131231750);
              }
            }
            else if (paramInt1 == this.AxV) {
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
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100179);
    Object localObject = this.AeP.get(paramInt2);
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
    return this.Ayb;
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
        paramViewGroup.vEo = ((ImageView)paramView.findViewById(2131304990));
        paramViewGroup.vgS = ((TextView)paramView.findViewById(2131304996));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(this.Aeo[paramInt]);
        paramViewGroup.vgS.setText(this.AeO[paramInt]);
        if ((paramInt != this.AxT) && (paramInt != this.AxS)) {
          break label265;
        }
        if (this.AeQ == paramInt) {
          break label233;
        }
        paramViewGroup.vEo.setImageResource(2131691077);
      }
    }
    for (;;)
    {
      if ((!this.AeR) || (paramInt != this.AxT)) {
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
      paramViewGroup.vEo.setImageResource(2131691078);
      paramViewGroup.vEo.setContentDescription(this.mContext.getString(2131763023));
      continue;
      label265:
      if (paramInt == this.AxU)
      {
        if (this.AeQ != paramInt)
        {
          paramViewGroup.vEo.setImageResource(2131691077);
        }
        else
        {
          paramViewGroup.vEo.setImageResource(2131691078);
          paramViewGroup.vEo.setContentDescription(this.mContext.getString(2131763023));
        }
      }
      else if (paramInt == this.AxV) {
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
    public abstract void a(a.c paramc);
  }
  
  final class c
  {
    public int Afd;
    public int Afe;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.a
 * JD-Core Version:    0.7.0.1
 */