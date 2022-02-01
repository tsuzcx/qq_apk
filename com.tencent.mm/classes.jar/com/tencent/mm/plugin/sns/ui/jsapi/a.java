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
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends AnimatedExpandableListView.a
{
  public int APl;
  public int APm;
  public int APn;
  public int APo;
  int APu;
  List<String> APv;
  b APw;
  boolean APx;
  public int[] AvA;
  public int[] Awa;
  ArrayList<String> Awb;
  public int Awc;
  public boolean Awd;
  public ArrayList<String> Awe;
  public ArrayList<String> Awf;
  public ArrayList<String> Awg;
  public ArrayList<String> Awh;
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(100178);
    this.APu = 4;
    this.APl = 0;
    this.APm = 1;
    this.APn = 2;
    this.APo = 3;
    this.AvA = new int[] { 2131763871, 2131763869, 2131763865, 2131763856 };
    this.Awa = new int[] { 2131763872, 2131763870, 2131763866, 2131763857 };
    this.Awc = 0;
    this.Awd = false;
    this.Awe = new ArrayList();
    this.Awf = new ArrayList();
    this.Awg = new ArrayList();
    this.Awh = new ArrayList();
    this.APw = null;
    this.APx = true;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    AppMethodBeat.o(100178);
  }
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(100186);
    LinkedList localLinkedList = new LinkedList();
    g.ajS();
    if (!g.ajP().aiZ())
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
    AppMethodBeat.o(100186);
    return localLinkedList;
  }
  
  public static void aCg(String paramString)
  {
    AppMethodBeat.i(100182);
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
      AppMethodBeat.o(100182);
      return;
    }
    g.ajS();
    g.ajR().ajA().set(335875, paramString);
    AppMethodBeat.o(100182);
  }
  
  private boolean cd(int paramInt, String paramString)
  {
    AppMethodBeat.i(100184);
    if (paramInt == 1)
    {
      bool = o(this.Awe, paramString);
      AppMethodBeat.o(100184);
      return bool;
    }
    boolean bool = o(this.Awf, paramString);
    AppMethodBeat.o(100184);
    return bool;
  }
  
  private static List<String> efT()
  {
    AppMethodBeat.i(100181);
    g.ajS();
    Object localObject = (String)g.ajR().ajA().get(335875, null);
    ae.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(100181);
      return null;
    }
    localObject = bu.U(((String)localObject).split(","));
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
  
  public final int RS(int paramInt)
  {
    AppMethodBeat.i(100188);
    if ((("visible".equals(this.APv.get(paramInt))) || ("invisible".equals(this.APv.get(paramInt)))) && (this.Awb != null))
    {
      paramInt = this.Awb.size();
      AppMethodBeat.o(100188);
      return paramInt + 1;
    }
    AppMethodBeat.o(100188);
    return 0;
  }
  
  public final void aA(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(100180);
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
        locala.vsZ = ((TextView)paramView.findViewById(2131304996));
        locala.Awm = ((TextView)paramView.findViewById(2131304995));
        locala.Awn = ((TextView)paramView.findViewById(2131304994));
        locala.vQs = ((ImageView)paramView.findViewById(2131304990));
        locala.Awo = ((ImageView)paramView.findViewById(2131304993));
        locala.Awo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(100177);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/jsapi/JsapiSnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof a.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (a.c)paramAnonymousView.getTag())
            {
              ae.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
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
        localObject1 = locala.Awo;
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 != null) && ((localObject2 instanceof c))) {
          break label394;
        }
        localObject2 = new c();
        ((c)localObject2).Awp = paramInt1;
        ((c)localObject2).Awq = paramInt2;
        ((View)localObject1).setTag(localObject2);
        label209:
        if (paramInt2 != this.Awb.size()) {
          break label551;
        }
        locala.titleView.setVisibility(8);
        locala.vsZ.setVisibility(8);
        locala.vQs.setVisibility(8);
        locala.Awo.setVisibility(8);
        locala.Awm.setVisibility(0);
        locala.Awn.setVisibility(0);
        if (paramInt1 != this.APo) {
          break label443;
        }
        if (this.Awh.size() <= 0) {
          break label419;
        }
        localObject1 = bu.m(P(this.Awh), ",");
        locala.Awn.setText("√".concat(String.valueOf(localObject1)));
        locala.Awn.setVisibility(0);
        locala.Awn.setTextColor(this.mContext.getResources().getColor(2131100929));
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
      ((c)localObject1).Awp = paramInt1;
      ((c)localObject1).Awq = paramInt2;
      break label209;
      locala.Awn.setText("");
      locala.Awn.setVisibility(8);
      continue;
      label443:
      if (paramInt1 == this.APn) {
        if (this.Awg.size() > 0)
        {
          localObject1 = bu.m(P(this.Awg), ",");
          locala.Awn.setText("√".concat(String.valueOf(localObject1)));
          locala.Awn.setVisibility(0);
          locala.Awn.setTextColor(this.mContext.getResources().getColor(2131100928));
        }
        else
        {
          locala.Awn.setText("");
          locala.Awn.setVisibility(8);
          continue;
          locala.titleView.setVisibility(0);
          locala.vsZ.setVisibility(0);
          locala.vQs.setVisibility(0);
          locala.Awo.setVisibility(4);
          locala.Awm.setVisibility(8);
          locala.Awn.setVisibility(8);
          localObject2 = (String)this.Awb.get(paramInt2);
          locala.titleView.setText(k.c(this.mContext, (CharSequence)localObject2));
          TextView localTextView = locala.vsZ;
          localObject1 = com.tencent.mm.plugin.label.a.a.dig().apo((String)localObject2);
          Object localObject3 = com.tencent.mm.plugin.label.a.a.dig().apr((String)localObject1);
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {}
          for (localObject1 = "";; localObject1 = k.c(this.mContext, (CharSequence)localObject1))
          {
            localTextView.setText((CharSequence)localObject1);
            locala.Awo.setImageResource(2131691196);
            if (this.style != 1) {
              break label930;
            }
            if (paramInt1 != this.APn) {
              break label851;
            }
            if (!cd(1, (String)localObject2)) {
              break label837;
            }
            locala.vQs.setImageResource(2131691180);
            break;
            localObject1 = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP((String)((Iterator)localObject3).next()));
            }
            localObject1 = bu.m((List)localObject1, ",");
          }
          label837:
          locala.vQs.setImageResource(2131691182);
          continue;
          label851:
          if (paramInt1 == this.APo)
          {
            if (this.Awc != paramInt1) {
              locala.vQs.setImageResource(2131691183);
            }
            for (;;)
            {
              if (!cd(2, (String)localObject2)) {
                break label916;
              }
              locala.vQs.setImageResource(2131691181);
              break;
              locala.vQs.setImageResource(2131691181);
            }
            locala.vQs.setImageResource(2131691183);
            continue;
            if (paramInt1 == this.APn)
            {
              if (cd(1, (String)localObject2)) {
                locala.vQs.setImageResource(2131689936);
              } else {
                locala.vQs.setImageResource(2131231750);
              }
            }
            else if (paramInt1 == this.APo) {
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
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100179);
    Object localObject = this.Awb.get(paramInt2);
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
    return this.APu;
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
        paramViewGroup.vQs = ((ImageView)paramView.findViewById(2131304990));
        paramViewGroup.vsZ = ((TextView)paramView.findViewById(2131304996));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(this.AvA[paramInt]);
        paramViewGroup.vsZ.setText(this.Awa[paramInt]);
        if ((paramInt != this.APm) && (paramInt != this.APl)) {
          break label265;
        }
        if (this.Awc == paramInt) {
          break label233;
        }
        paramViewGroup.vQs.setImageResource(2131691077);
      }
    }
    for (;;)
    {
      if ((!this.Awd) || (paramInt != this.APm)) {
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
      paramViewGroup.vQs.setImageResource(2131691078);
      paramViewGroup.vQs.setContentDescription(this.mContext.getString(2131763023));
      continue;
      label265:
      if (paramInt == this.APn)
      {
        if (this.Awc != paramInt)
        {
          paramViewGroup.vQs.setImageResource(2131691077);
        }
        else
        {
          paramViewGroup.vQs.setImageResource(2131691078);
          paramViewGroup.vQs.setContentDescription(this.mContext.getString(2131763023));
        }
      }
      else if (paramInt == this.APo) {
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
    public abstract void a(a.c paramc);
  }
  
  final class c
  {
    public int Awp;
    public int Awq;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.a
 * JD-Core Version:    0.7.0.1
 */