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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends AnimatedExpandableListView.a
{
  public int[] EEO;
  public int[] EFp;
  ArrayList<String> EFq;
  public int EFr;
  public boolean EFs;
  public ArrayList<String> EFt;
  public ArrayList<String> EFu;
  public ArrayList<String> EFv;
  public ArrayList<String> EFw;
  public int EZU;
  public int EZV;
  public int EZW;
  public int EZX;
  int Fad;
  List<String> Fae;
  b Faf;
  boolean Fag;
  private Context mContext;
  private LayoutInflater mInflater;
  public int style;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(100178);
    this.Fad = 4;
    this.EZU = 0;
    this.EZV = 1;
    this.EZW = 2;
    this.EZX = 3;
    this.EEO = new int[] { 2131766098, 2131766096, 2131766092, 2131766083 };
    this.EFp = new int[] { 2131766099, 2131766097, 2131766093, 2131766084 };
    this.EFr = 0;
    this.EFs = false;
    this.EFt = new ArrayList();
    this.EFu = new ArrayList();
    this.EFv = new ArrayList();
    this.EFw = new ArrayList();
    this.Faf = null;
    this.Fag = true;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    AppMethodBeat.o(100178);
  }
  
  private static List<String> V(List<String> paramList)
  {
    AppMethodBeat.i(100186);
    LinkedList localLinkedList = new LinkedList();
    g.aAi();
    if (!g.aAf().azp())
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
    AppMethodBeat.o(100186);
    return localLinkedList;
  }
  
  public static void aRb(String paramString)
  {
    AppMethodBeat.i(100182);
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
      AppMethodBeat.o(100182);
      return;
    }
    g.aAi();
    g.aAh().azQ().set(335875, paramString);
    AppMethodBeat.o(100182);
  }
  
  private boolean cu(int paramInt, String paramString)
  {
    AppMethodBeat.i(100184);
    if (paramInt == 1)
    {
      bool = p(this.EFt, paramString);
      AppMethodBeat.o(100184);
      return bool;
    }
    boolean bool = p(this.EFu, paramString);
    AppMethodBeat.o(100184);
    return bool;
  }
  
  private static List<String> fit()
  {
    AppMethodBeat.i(100181);
    g.aAi();
    Object localObject = (String)g.aAh().azQ().get(335875, null);
    Log.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(100181);
      return null;
    }
    localObject = Util.stringsToList(((String)localObject).split(","));
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
  
  public final int ZO(int paramInt)
  {
    AppMethodBeat.i(100188);
    if ((("visible".equals(this.Fae.get(paramInt))) || ("invisible".equals(this.Fae.get(paramInt)))) && (this.EFq != null))
    {
      paramInt = this.EFq.size();
      AppMethodBeat.o(100188);
      return paramInt + 1;
    }
    AppMethodBeat.o(100188);
    return 0;
  }
  
  public final void aR(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(100180);
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
            AppMethodBeat.i(100177);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/jsapi/JsapiSnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof a.c))) {}
            for (paramAnonymousView = null; paramAnonymousView == null; paramAnonymousView = (a.c)paramAnonymousView.getTag())
            {
              Log.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
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
        localObject1 = locala.EFD;
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 != null) && ((localObject2 instanceof c))) {
          break label394;
        }
        localObject2 = new c();
        ((c)localObject2).EFE = paramInt1;
        ((c)localObject2).EFF = paramInt2;
        ((View)localObject1).setTag(localObject2);
        label209:
        if (paramInt2 != this.EFq.size()) {
          break label551;
        }
        locala.titleView.setVisibility(8);
        locala.yMM.setVisibility(8);
        locala.zkw.setVisibility(8);
        locala.EFD.setVisibility(8);
        locala.EFB.setVisibility(0);
        locala.EFC.setVisibility(0);
        if (paramInt1 != this.EZX) {
          break label443;
        }
        if (this.EFw.size() <= 0) {
          break label419;
        }
        localObject1 = Util.listToString(V(this.EFw), ",");
        locala.EFC.setText("√".concat(String.valueOf(localObject1)));
        locala.EFC.setVisibility(0);
        locala.EFC.setTextColor(this.mContext.getResources().getColor(2131101146));
      }
    }
    label394:
    label419:
    label551:
    for (;;)
    {
      AppMethodBeat.o(100187);
      return paramView;
      paramView = this.mInflater.inflate(2131496447, null);
      break;
      locala = (a)paramView.getTag();
      break label153;
      localObject1 = (c)((View)localObject1).getTag();
      ((c)localObject1).EFE = paramInt1;
      ((c)localObject1).EFF = paramInt2;
      break label209;
      locala.EFC.setText("");
      locala.EFC.setVisibility(8);
      continue;
      label443:
      if (paramInt1 == this.EZW) {
        if (this.EFv.size() > 0)
        {
          localObject1 = Util.listToString(V(this.EFv), ",");
          locala.EFC.setText("√".concat(String.valueOf(localObject1)));
          locala.EFC.setVisibility(0);
          locala.EFC.setTextColor(this.mContext.getResources().getColor(2131101145));
        }
        else
        {
          locala.EFC.setText("");
          locala.EFC.setVisibility(8);
          continue;
          locala.titleView.setVisibility(0);
          locala.yMM.setVisibility(0);
          locala.zkw.setVisibility(0);
          locala.EFD.setVisibility(4);
          locala.EFB.setVisibility(8);
          locala.EFC.setVisibility(8);
          localObject2 = (String)this.EFq.get(paramInt2);
          locala.titleView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.mContext, (CharSequence)localObject2));
          TextView localTextView = locala.yMM;
          localObject1 = com.tencent.mm.plugin.label.a.a.ecg().aCH((String)localObject2);
          Object localObject3 = com.tencent.mm.plugin.label.a.a.ecg().aCK((String)localObject1);
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {}
          for (localObject1 = "";; localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c(this.mContext, (CharSequence)localObject1))
          {
            localTextView.setText((CharSequence)localObject1);
            locala.EFD.setImageResource(2131691518);
            if (this.style != 1) {
              break label930;
            }
            if (paramInt1 != this.EZW) {
              break label851;
            }
            if (!cu(1, (String)localObject2)) {
              break label837;
            }
            locala.zkw.setImageResource(2131691496);
            break;
            localObject1 = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)((Iterator)localObject3).next()));
            }
            localObject1 = Util.listToString((List)localObject1, ",");
          }
          label837:
          locala.zkw.setImageResource(2131691498);
          continue;
          label851:
          if (paramInt1 == this.EZX)
          {
            if (this.EFr != paramInt1) {
              locala.zkw.setImageResource(2131691499);
            }
            for (;;)
            {
              if (!cu(2, (String)localObject2)) {
                break label916;
              }
              locala.zkw.setImageResource(2131691497);
              break;
              locala.zkw.setImageResource(2131691497);
            }
            locala.zkw.setImageResource(2131691499);
            continue;
            if (paramInt1 == this.EZW)
            {
              if (cu(1, (String)localObject2)) {
                locala.zkw.setImageResource(2131689951);
              } else {
                locala.zkw.setImageResource(2131231825);
              }
            }
            else if (paramInt1 == this.EZX) {
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
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100179);
    Object localObject = this.EFq.get(paramInt2);
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
    return this.Fad;
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
        paramView = this.mInflater.inflate(2131496450, null);
        paramViewGroup = new a((byte)0);
        paramViewGroup.titleView = ((TextView)paramView.findViewById(2131308148));
        paramViewGroup.zkw = ((ImageView)paramView.findViewById(2131308141));
        paramViewGroup.yMM = ((TextView)paramView.findViewById(2131308147));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(this.EEO[paramInt]);
        paramViewGroup.yMM.setText(this.EFp[paramInt]);
        if ((paramInt != this.EZV) && (paramInt != this.EZU)) {
          break label265;
        }
        if (this.EFr == paramInt) {
          break label233;
        }
        paramViewGroup.zkw.setImageResource(2131691379);
      }
    }
    for (;;)
    {
      if ((!this.EFs) || (paramInt != this.EZV)) {
        break label451;
      }
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(100185);
      return paramView;
      paramView = this.mInflater.inflate(2131496449, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label102;
      label233:
      paramViewGroup.zkw.setImageResource(2131691380);
      paramViewGroup.zkw.setContentDescription(this.mContext.getString(2131765172));
      continue;
      label265:
      if (paramInt == this.EZW)
      {
        if (this.EFr != paramInt)
        {
          paramViewGroup.zkw.setImageResource(2131691379);
        }
        else
        {
          paramViewGroup.zkw.setImageResource(2131691380);
          paramViewGroup.zkw.setContentDescription(this.mContext.getString(2131765172));
        }
      }
      else if (paramInt == this.EZX) {
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
    public abstract void a(a.c paramc);
  }
  
  final class c
  {
    public int EFE;
    public int EFF;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.a
 * JD-Core Version:    0.7.0.1
 */