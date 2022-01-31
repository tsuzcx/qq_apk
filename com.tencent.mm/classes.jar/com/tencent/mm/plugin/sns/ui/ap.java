package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.plugin.expt.a.a.a;
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

public final class ap
  extends AnimatedExpandableListView.a
{
  public static int[] rRO = { 2131303862, 2131303860, 2131303856, 2131303847 };
  public static int rSl = 0;
  public static int rSm = 1;
  public static int rSn = 2;
  public static int[] rSo = { 2131303863, 2131303861, 2131303857, 2131303848 };
  private Context mContext;
  private LayoutInflater mInflater;
  ArrayList<String> rSp;
  public int rSq;
  public boolean rSr;
  public ArrayList<String> rSs;
  public ArrayList<String> rSt;
  public ArrayList<String> rSu;
  public ArrayList<String> rSv;
  public ArrayList<String> rSw;
  public ArrayList<String> rSx;
  b rSy;
  public int style;
  
  public ap(Context paramContext)
  {
    AppMethodBeat.i(39050);
    this.rSq = 0;
    this.rSr = false;
    this.rSs = new ArrayList();
    this.rSt = new ArrayList();
    this.rSu = new ArrayList();
    this.rSv = new ArrayList();
    this.rSw = new ArrayList();
    this.rSx = new ArrayList();
    this.rSy = null;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    int i;
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWk, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label200;
      }
      rSl = 0;
    }
    for (rSm = 1;; rSm = 0)
    {
      rSn = rSm + 1;
      ab.i("MicroMsg.Sns.AnimatedExpandableListAdapter", "initWithConfig %s %s %s", new Object[] { Integer.valueOf(rSl), Integer.valueOf(rSm), Integer.valueOf(rSn) });
      AppMethodBeat.o(39050);
      return;
      i = 0;
      break;
      label200:
      rSl = -1;
    }
  }
  
  private static List<String> M(List<String> paramList)
  {
    AppMethodBeat.i(39058);
    LinkedList localLinkedList = new LinkedList();
    g.RM();
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(39058);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(39058);
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
    AppMethodBeat.o(39058);
    return localLinkedList;
  }
  
  public static void acg(String paramString)
  {
    AppMethodBeat.i(39054);
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
      AppMethodBeat.o(39054);
      return;
    }
    g.RM();
    g.RL().Ru().set(335875, paramString);
    AppMethodBeat.o(39054);
  }
  
  private boolean bg(int paramInt, String paramString)
  {
    AppMethodBeat.i(39056);
    if (paramInt == 1)
    {
      bool = i(this.rSs, paramString);
      AppMethodBeat.o(39056);
      return bool;
    }
    boolean bool = i(this.rSt, paramString);
    AppMethodBeat.o(39056);
    return bool;
  }
  
  private static List<String> cvB()
  {
    AppMethodBeat.i(39053);
    g.RM();
    Object localObject = (String)g.RL().Ru().get(335875, null);
    ab.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[] { localObject });
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(39053);
      return null;
    }
    localObject = bo.P(((String)localObject).split(","));
    AppMethodBeat.o(39053);
    return localObject;
  }
  
  private static boolean i(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(39055);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((String)paramList.next()).equals(paramString))
      {
        AppMethodBeat.o(39055);
        return true;
      }
    }
    AppMethodBeat.o(39055);
    return false;
  }
  
  public final int ET(int paramInt)
  {
    AppMethodBeat.i(39060);
    if ((paramInt > 1) && (this.rSp != null))
    {
      paramInt = this.rSp.size();
      int i = rSn;
      AppMethodBeat.o(39060);
      return paramInt + i;
    }
    AppMethodBeat.o(39060);
    return 0;
  }
  
  public final void S(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(39052);
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
    AppMethodBeat.o(39052);
  }
  
  public final View d(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(39059);
    ap.a locala;
    label153:
    Object localObject1;
    if (paramView == null) {
      if (this.style == 1)
      {
        paramView = this.mInflater.inflate(2130970833, null);
        locala = new ap.a(this, (byte)0);
        locala.titleView = ((TextView)paramView.findViewById(2131828017));
        locala.ogO = ((TextView)paramView.findViewById(2131828018));
        locala.rSA = ((TextView)paramView.findViewById(2131828019));
        locala.rSB = ((TextView)paramView.findViewById(2131828020));
        locala.oyN = ((ImageView)paramView.findViewById(2131828015));
        locala.rSC = ((ImageView)paramView.findViewById(2131828016));
        locala.rSC.setOnClickListener(new ap.1(this));
        paramView.setTag(locala);
        if (paramInt2 != rSm) {
          break label481;
        }
        locala.titleView.setVisibility(8);
        locala.ogO.setVisibility(8);
        locala.oyN.setVisibility(8);
        locala.rSC.setVisibility(8);
        locala.rSA.setVisibility(0);
        locala.rSA.setText(this.mContext.getResources().getString(2131303864));
        locala.rSB.setVisibility(0);
        if (paramInt1 != 3) {
          break label376;
        }
        if (this.rSv.size() <= 0) {
          break label352;
        }
        localObject1 = bo.d(M(this.rSv), ",");
        locala.rSB.setText("√".concat(String.valueOf(localObject1)));
        locala.rSB.setVisibility(0);
        locala.rSB.setTextColor(this.mContext.getResources().getColor(2131690504));
      }
    }
    label352:
    label481:
    for (;;)
    {
      AppMethodBeat.o(39059);
      return paramView;
      paramView = this.mInflater.inflate(2130970832, null);
      break;
      locala = (ap.a)paramView.getTag();
      break label153;
      locala.rSB.setText("");
      locala.rSB.setVisibility(8);
      continue;
      label376:
      if (paramInt1 == 2) {
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
          if (paramInt2 == rSl)
          {
            locala.titleView.setVisibility(8);
            locala.ogO.setVisibility(8);
            locala.oyN.setVisibility(8);
            locala.rSC.setVisibility(8);
            locala.rSA.setVisibility(0);
            locala.rSA.setText(this.mContext.getResources().getString(2131303865));
            locala.rSB.setVisibility(0);
            if (paramInt1 == 3)
            {
              if (this.rSx.size() > 0)
              {
                localObject1 = bo.d(M(this.rSx), ",");
                locala.rSB.setText("√".concat(String.valueOf(localObject1)));
                locala.rSB.setVisibility(0);
                locala.rSB.setTextColor(this.mContext.getResources().getColor(2131690504));
              }
              else
              {
                locala.rSB.setText("");
                locala.rSB.setVisibility(8);
              }
            }
            else if (paramInt1 == 2) {
              if (this.rSw.size() > 0)
              {
                localObject1 = bo.d(M(this.rSw), ",");
                locala.rSB.setText("√".concat(String.valueOf(localObject1)));
                locala.rSB.setVisibility(0);
                locala.rSB.setTextColor(this.mContext.getResources().getColor(2131690503));
              }
              else
              {
                locala.rSB.setText("");
                locala.rSB.setVisibility(8);
              }
            }
          }
          else
          {
            paramInt2 -= rSn;
            localObject1 = locala.rSC;
            Object localObject2 = ((View)localObject1).getTag();
            TextView localTextView;
            Object localObject3;
            if ((localObject2 == null) || (!(localObject2 instanceof c)))
            {
              localObject2 = new c();
              ((c)localObject2).rSD = paramInt1;
              ((c)localObject2).rSE = paramInt2;
              ((View)localObject1).setTag(localObject2);
              locala.titleView.setVisibility(0);
              locala.ogO.setVisibility(0);
              locala.oyN.setVisibility(0);
              locala.rSC.setVisibility(0);
              locala.rSA.setVisibility(8);
              locala.rSB.setVisibility(8);
              localObject2 = (String)this.rSp.get(paramInt2);
              locala.titleView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, (CharSequence)localObject2));
              localTextView = locala.ogO;
              localObject1 = com.tencent.mm.plugin.label.a.a.bKV().RO((String)localObject2);
              localObject3 = com.tencent.mm.plugin.label.a.a.bKV().RR((String)localObject1);
              if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
                break label1056;
              }
            }
            for (localObject1 = "";; localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, (CharSequence)localObject1))
            {
              localTextView.setText((CharSequence)localObject1);
              locala.rSC.setImageResource(2131232009);
              if (this.style != 1) {
                break label1237;
              }
              if (paramInt1 != 2) {
                break label1161;
              }
              if (!bg(1, (String)localObject2)) {
                break label1147;
              }
              locala.oyN.setImageResource(2131231994);
              break;
              localObject1 = (c)((View)localObject1).getTag();
              ((c)localObject1).rSD = paramInt1;
              ((c)localObject1).rSE = paramInt2;
              break label839;
              localObject1 = new ArrayList(((List)localObject3).size());
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((com.tencent.mm.plugin.messenger.a.b)g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE((String)((Iterator)localObject3).next()));
              }
              localObject1 = bo.d((List)localObject1, ",");
            }
            label1147:
            locala.oyN.setImageResource(2131231996);
            continue;
            if (paramInt1 == 3)
            {
              if (this.rSq != paramInt1) {
                locala.oyN.setImageResource(2131231997);
              }
              for (;;)
              {
                if (!bg(2, (String)localObject2)) {
                  break label1223;
                }
                locala.oyN.setImageResource(2131231995);
                break;
                locala.oyN.setImageResource(2131231995);
              }
              locala.oyN.setImageResource(2131231997);
              continue;
              if (paramInt1 == 2)
              {
                if (bg(1, (String)localObject2)) {
                  locala.oyN.setImageResource(2131231137);
                } else {
                  locala.oyN.setImageResource(2131231142);
                }
              }
              else if (paramInt1 == 3) {
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
  }
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39051);
    Object localObject = this.rSp.get(paramInt2);
    AppMethodBeat.o(39051);
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
    AppMethodBeat.i(39057);
    if ((paramView == null) || (!(paramView.getTag() instanceof ap.a))) {
      if (this.style == 1)
      {
        paramView = this.mInflater.inflate(2130970835, null);
        paramViewGroup = new ap.a(this, (byte)0);
        paramViewGroup.titleView = ((TextView)paramView.findViewById(2131828017));
        paramViewGroup.oyN = ((ImageView)paramView.findViewById(2131828015));
        paramViewGroup.ogO = ((TextView)paramView.findViewById(2131828018));
        paramView.setTag(paramViewGroup);
        label102:
        paramViewGroup.titleView.setText(rRO[paramInt]);
        paramViewGroup.ogO.setText(rSo[paramInt]);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      if ((!this.rSr) || (paramInt != 1)) {
        break label449;
      }
      paramView = new View(this.mContext);
      paramView.setVisibility(8);
      AppMethodBeat.o(39057);
      return paramView;
      paramView = this.mInflater.inflate(2130970834, null);
      break;
      paramViewGroup = (ap.a)paramView.getTag();
      break label102;
      if (this.rSq != paramInt)
      {
        paramViewGroup.oyN.setImageResource(2131231905);
      }
      else
      {
        paramViewGroup.oyN.setImageResource(2131231906);
        paramViewGroup.oyN.setContentDescription(this.mContext.getString(2131303075));
        continue;
        if (this.rSq != paramInt)
        {
          paramViewGroup.oyN.setImageResource(2131231905);
        }
        else
        {
          paramViewGroup.oyN.setImageResource(2131231906);
          paramViewGroup.oyN.setContentDescription(this.mContext.getString(2131303075));
          continue;
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
    }
    label449:
    AppMethodBeat.o(39057);
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
  
  public static abstract interface b
  {
    public abstract void a(ap.c paramc);
  }
  
  final class c
  {
    public int rSD;
    public int rSE;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap
 * JD-Core Version:    0.7.0.1
 */