package com.tencent.mm.plugin.sns.ui.jsapi;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
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
  public int[] rRO;
  public int[] rSo;
  ArrayList<String> rSp;
  public int rSq;
  public boolean rSr;
  public ArrayList<String> rSs;
  public ArrayList<String> rSt;
  public ArrayList<String> rSu;
  public ArrayList<String> rSv;
  public int siV;
  public int siW;
  public int siX;
  public int siY;
  int sje;
  List<String> sjf;
  a.b sjg;
  boolean sjh;
  public int style;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(40218);
    this.sje = 4;
    this.siV = 0;
    this.siW = 1;
    this.siX = 2;
    this.siY = 3;
    this.rRO = new int[] { 2131303862, 2131303860, 2131303856, 2131303847 };
    this.rSo = new int[] { 2131303863, 2131303861, 2131303857, 2131303848 };
    this.rSq = 0;
    this.rSr = false;
    this.rSs = new ArrayList();
    this.rSt = new ArrayList();
    this.rSu = new ArrayList();
    this.rSv = new ArrayList();
    this.sjg = null;
    this.sjh = true;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    AppMethodBeat.o(40218);
  }
  
  private static List<String> M(List<String> paramList)
  {
    AppMethodBeat.i(40226);
    LinkedList localLinkedList = new LinkedList();
    g.RM();
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(40226);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(40226);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      g.RM();
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.euF != 0) {
          paramList = localad.Of();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(40226);
    return localLinkedList;
  }
  
  public static void acg(String paramString)
  {
    AppMethodBeat.i(40222);
    ab.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[] { paramString });
    if (cvB() != null)
    {
      ArrayList localArrayList = new ArrayList(cvB());
      if (!i(localArrayList, paramString))
      {
        if (localArrayList.size() == 5) {
          localArrayList.remove(4);
        }
        localArrayList.add(0, paramString);
        paramString = bo.d(localArrayList, ",");
        g.RM();
        g.RL().Ru().set(335875, paramString);
      }
      AppMethodBeat.o(40222);
      return;
    }
    g.RM();
    g.RL().Ru().set(335875, paramString);
    AppMethodBeat.o(40222);
  }
  
  private boolean bg(int paramInt, String paramString)
  {
    AppMethodBeat.i(40224);
    if (paramInt == 1)
    {
      bool = i(this.rSs, paramString);
      AppMethodBeat.o(40224);
      return bool;
    }
    boolean bool = i(this.rSt, paramString);
    AppMethodBeat.o(40224);
    return bool;
  }
  
  private static List<String> cvB()
  {
    AppMethodBeat.i(40221);
    g.RM();
    Object localObject = (String)g.RL().Ru().get(335875, null);
    ab.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(40221);
      return null;
    }
    localObject = bo.P(((String)localObject).split(","));
    AppMethodBeat.o(40221);
    return localObject;
  }
  
  private static boolean i(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(40223);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((String)paramList.next()).equals(paramString))
      {
        AppMethodBeat.o(40223);
        return true;
      }
    }
    AppMethodBeat.o(40223);
    return false;
  }
  
  public final int ET(int paramInt)
  {
    AppMethodBeat.i(40228);
    if ((("visible".equals(this.sjf.get(paramInt))) || ("invisible".equals(this.sjf.get(paramInt)))) && (this.rSp != null))
    {
      paramInt = this.rSp.size();
      AppMethodBeat.o(40228);
      return paramInt + 1;
    }
    AppMethodBeat.o(40228);
    return 0;
  }
  
  public final void S(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(40220);
    Object localObject2 = cvB();
    Object localObject1 = new ArrayList();
    if ((localObject2 != null) && (paramArrayList != null))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (i(paramArrayList, str))
        {
          paramArrayList.remove(str);
          ((ArrayList)localObject1).add(str);
        }
      }
      paramArrayList.addAll(0, (Collection)localObject1);
      localObject1 = bo.d((List)localObject1, ",");
      g.RM();
      g.RL().Ru().set(335875, localObject1);
    }
    this.rSp = paramArrayList;
    AppMethodBeat.o(40220);
  }
  
  public final View d(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(40227);
    a.a locala;
    label153:
    Object localObject1;
    Object localObject2;
    if (paramView == null) {
      if (this.style == 1)
      {
        paramView = this.mInflater.inflate(2130970833, null);
        locala = new a.a(this, (byte)0);
        locala.titleView = ((TextView)paramView.findViewById(2131828017));
        locala.ogO = ((TextView)paramView.findViewById(2131828018));
        locala.rSA = ((TextView)paramView.findViewById(2131828019));
        locala.rSB = ((TextView)paramView.findViewById(2131828020));
        locala.oyN = ((ImageView)paramView.findViewById(2131828015));
        locala.rSC = ((ImageView)paramView.findViewById(2131828016));
        locala.rSC.setOnClickListener(new a.1(this));
        paramView.setTag(locala);
        localObject1 = locala.rSC;
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 != null) && ((localObject2 instanceof a.c))) {
          break label394;
        }
        localObject2 = new a.c(this);
        ((a.c)localObject2).rSD = paramInt1;
        ((a.c)localObject2).rSE = paramInt2;
        ((View)localObject1).setTag(localObject2);
        label209:
        if (paramInt2 != this.rSp.size()) {
          break label551;
        }
        locala.titleView.setVisibility(8);
        locala.ogO.setVisibility(8);
        locala.oyN.setVisibility(8);
        locala.rSC.setVisibility(8);
        locala.rSA.setVisibility(0);
        locala.rSB.setVisibility(0);
        if (paramInt1 != this.siY) {
          break label443;
        }
        if (this.rSv.size() <= 0) {
          break label419;
        }
        localObject1 = bo.d(M(this.rSv), ",");
        locala.rSB.setText("√".concat(String.valueOf(localObject1)));
        locala.rSB.setVisibility(0);
        locala.rSB.setTextColor(this.mContext.getResources().getColor(2131690504));
      }
    }
    label394:
    label419:
    label551:
    for (;;)
    {
      AppMethodBeat.o(40227);
      return paramView;
      paramView = this.mInflater.inflate(2130970832, null);
      break;
      locala = (a.a)paramView.getTag();
      break label153;
      localObject1 = (a.c)((View)localObject1).getTag();
      ((a.c)localObject1).rSD = paramInt1;
      ((a.c)localObject1).rSE = paramInt2;
      break label209;
      locala.rSB.setText("");
      locala.rSB.setVisibility(8);
      continue;
      label443:
      if (paramInt1 == this.siX) {
        if (this.rSu.size() > 0)
        {
          localObject1 = bo.d(M(this.rSu), ",");
          locala.rSB.setText("√".concat(String.valueOf(localObject1)));
          locala.rSB.setVisibility(0);
          locala.rSB.setTextColor(this.mContext.getResources().getColor(2131690503));
        }
        else
        {
          locala.rSB.setText("");
          locala.rSB.setVisibility(8);
          continue;
          locala.titleView.setVisibility(0);
          locala.ogO.setVisibility(0);
          locala.oyN.setVisibility(0);
          locala.rSC.setVisibility(4);
          locala.rSA.setVisibility(8);
          locala.rSB.setVisibility(8);
          localObject2 = (String)this.rSp.get(paramInt2);
          locala.titleView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, (CharSequence)localObject2));
          TextView localTextView = locala.ogO;
          localObject1 = com.tencent.mm.plugin.label.a.a.bKV().RO((String)localObject2);
          Object localObject3 = com.tencent.mm.plugin.label.a.a.bKV().RR((String)localObject1);
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {}
          for (localObject1 = "";; localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, (CharSequence)localObject1))
          {
            localTextView.setText((CharSequence)localObject1);
            locala.rSC.setImageResource(2131232009);
            if (this.style != 1) {
              break label930;
            }
            if (paramInt1 != this.siX) {
              break label851;
            }
            if (!bg(1, (String)localObject2)) {
              break label837;
            }
            locala.oyN.setImageResource(2131231994);
            break;
            localObject1 = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE((String)((Iterator)localObject3).next()));
            }
            localObject1 = bo.d((List)localObject1, ",");
          }
          label837:
          locala.oyN.setImageResource(2131231996);
          continue;
          label851:
          if (paramInt1 == this.siY)
          {
            if (this.rSq != paramInt1) {
              locala.oyN.setImageResource(2131231997);
            }
            for (;;)
            {
              if (!bg(2, (String)localObject2)) {
                break label916;
              }
              locala.oyN.setImageResource(2131231995);
              break;
              locala.oyN.setImageResource(2131231995);
            }
            locala.oyN.setImageResource(2131231997);
            continue;
            if (paramInt1 == this.siX)
            {
              if (bg(1, (String)localObject2)) {
                locala.oyN.setImageResource(2131231137);
              } else {
                locala.oyN.setImageResource(2131231142);
              }
            }
            else if (paramInt1 == this.siY) {
              if (bg(2, (String)localObject2)) {
                locala.oyN.setImageResource(2131231140);
              } else {
                locala.oyN.setImageResource(2131231142);
              }
            }
          }
        }
      }
    }
  }
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40219);
    Object localObject = this.rSp.get(paramInt2);
    AppMethodBeat.o(40219);
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
    return this.sje;
  }
  
  public final long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public final View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(40225);
    if ((paramView == null) || (!(paramView.getTag() instanceof a.a))) {
      if (this.style == 1)
      {
        paramView = this.mInflater.inflate(2130970835, null);
        paramViewGroup = new a.a(this, (byte)0);
        paramViewGroup.titleView = ((TextView)paramView.findViewById(2131828017));
        paramViewGroup.oyN = ((ImageView)paramView.findViewById(2131828015));
        paramViewGroup.ogO = ((TextView)paramView.findViewById(2131828018));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(this.rRO[paramInt]);
        paramViewGroup.ogO.setText(this.rSo[paramInt]);
        if ((paramInt != this.siW) && (paramInt != this.siV)) {
          break label265;
        }
        if (this.rSq == paramInt) {
          break label233;
        }
        paramViewGroup.oyN.setImageResource(2131231905);
      }
    }
    for (;;)
    {
      if ((!this.rSr) || (paramInt != this.siW)) {
        break label451;
      }
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(40225);
      return paramView;
      paramView = this.mInflater.inflate(2130970834, null);
      break;
      paramViewGroup = (a.a)paramView.getTag();
      break label102;
      label233:
      paramViewGroup.oyN.setImageResource(2131231906);
      paramViewGroup.oyN.setContentDescription(this.mContext.getString(2131303075));
      continue;
      label265:
      if (paramInt == this.siX)
      {
        if (this.rSq != paramInt)
        {
          paramViewGroup.oyN.setImageResource(2131231905);
        }
        else
        {
          paramViewGroup.oyN.setImageResource(2131231906);
          paramViewGroup.oyN.setContentDescription(this.mContext.getString(2131303075));
        }
      }
      else if (paramInt == this.siY) {
        if (this.style == 1)
        {
          if (this.rSq != paramInt)
          {
            paramViewGroup.oyN.setImageResource(2131231905);
          }
          else
          {
            paramViewGroup.oyN.setImageResource(2131231932);
            paramViewGroup.oyN.setContentDescription(this.mContext.getString(2131303075));
          }
        }
        else if (this.rSq != paramInt)
        {
          paramViewGroup.oyN.setImageResource(2131231905);
        }
        else
        {
          paramViewGroup.oyN.setImageResource(2131231907);
          paramViewGroup.oyN.setContentDescription(this.mContext.getString(2131303075));
        }
      }
    }
    label451:
    AppMethodBeat.o(40225);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.a
 * JD-Core Version:    0.7.0.1
 */