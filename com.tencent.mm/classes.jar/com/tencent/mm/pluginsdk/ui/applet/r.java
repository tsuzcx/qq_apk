package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  public static int FoG = 5;
  public static int MAX_COUNT = 44;
  private List<an> BJc;
  a FoH;
  private ArrayList<an> FoI;
  public boolean FoJ;
  public boolean FoK;
  private List<Object> FoL;
  int FoM;
  int FoN;
  e FoO;
  public boolean FoP;
  public boolean FoQ;
  public boolean FoR;
  private boolean FoS;
  boolean FoT;
  int FoU;
  String FoV;
  private final int FoW;
  public boolean FoX;
  private boolean FoY;
  boolean FoZ;
  public boolean Fpa;
  private List<String> dBf;
  private boolean dzK;
  ac fNS;
  boolean fTh;
  private com.tencent.mm.av.a.a.c fUx;
  private Context mContext;
  boolean rCv;
  private String username;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(152192);
    this.dBf = new ArrayList();
    this.FoI = new ArrayList();
    this.rCv = false;
    this.FoJ = false;
    this.FoK = false;
    this.BJc = new ArrayList();
    this.FoL = new ArrayList();
    this.FoM = 0;
    this.FoN = 0;
    this.FoP = false;
    this.FoQ = false;
    this.FoR = false;
    this.FoS = true;
    this.FoT = false;
    this.FoU = 12;
    this.FoX = false;
    this.fUx = null;
    this.FoY = true;
    this.FoZ = true;
    this.Fpa = false;
    this.mContext = paramContext;
    this.fTh = false;
    this.FoW = paramContext.getResources().getDimensionPixelSize(2131165187);
    AppMethodBeat.o(152192);
  }
  
  private void ZB(int paramInt)
  {
    AppMethodBeat.i(152199);
    if (paramInt < this.FoN)
    {
      this.fTh = true;
      ceE();
    }
    AppMethodBeat.o(152199);
  }
  
  private void ceE()
  {
    AppMethodBeat.i(152200);
    if (this.FoH != null) {
      this.FoH.ceE();
    }
    AppMethodBeat.o(152200);
  }
  
  private c fT(View paramView)
  {
    AppMethodBeat.i(152201);
    c localc = new c();
    localc.Fpd = ((ImageView)paramView.findViewById(2131304212));
    localc.fUY = ((AvatarPatTipImageView)paramView.findViewById(2131304237));
    localc.yZI = ((ImageView)paramView.findViewById(2131304211));
    localc.fQm = ((TextView)paramView.findViewById(2131304233));
    localc.fUz = ((TextView)paramView.findViewById(2131304234));
    localc.fUA = ((TextView)paramView.findViewById(2131304236));
    localc.ndr = ((ImageView)paramView.findViewById(2131304213));
    localc.fUY.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.setTag(localc);
    AppMethodBeat.o(152201);
    return localc;
  }
  
  private void fgs()
  {
    AppMethodBeat.i(152193);
    if ((this.rCv) && (x.a.Fpn != null)) {
      this.fUx = x.a.Fpn.aOe(this.username);
    }
    AppMethodBeat.o(152193);
  }
  
  private void fgu()
  {
    AppMethodBeat.i(152197);
    if (this.FoI == null)
    {
      AppMethodBeat.o(152197);
      return;
    }
    ae.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[] { Integer.valueOf(this.FoI.size()) });
    this.BJc.clear();
    if (this.FoI.size() > 0)
    {
      Iterator localIterator = this.FoI.iterator();
      while (localIterator.hasNext())
      {
        an localan = (an)localIterator.next();
        this.BJc.add(localan);
      }
    }
    this.FoN = this.BJc.size();
    AppMethodBeat.o(152197);
  }
  
  public final boolean ZA(int paramInt)
  {
    AppMethodBeat.i(152198);
    if (!this.fTh)
    {
      ZB(paramInt);
      AppMethodBeat.o(152198);
      return true;
    }
    AppMethodBeat.o(152198);
    return false;
  }
  
  public final boolean ZC(int paramInt)
  {
    return paramInt < this.FoN;
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(152196);
    if ((this.dBf == null) && (this.FoI == null))
    {
      AppMethodBeat.o(152196);
      return;
    }
    int i;
    if (this.FoS) {
      if (this.dBf != null)
      {
        ae.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[] { Integer.valueOf(this.dBf.size()) });
        this.BJc.clear();
        this.FoL.clear();
        Object localObject1 = new LinkedList();
        if (this.dBf.size() > 0)
        {
          Object localObject2 = this.dBf.iterator();
          i = 1;
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if (this.rCv)
            {
              this.FoL.add(x.a.Fpn.aOd(str));
            }
            else
            {
              an localan = ((l)g.ab(l.class)).azF().BH(str);
              if ((this.fNS != null) && (str.equals(this.fNS.field_roomowner)))
              {
                ((LinkedList)localObject1).add(new b(localan, 0));
              }
              else if ((this.fNS != null) && (this.fNS.aUg(localan.field_username)))
              {
                ((LinkedList)localObject1).add(new b(localan, i));
                i += 1;
              }
              else
              {
                ((LinkedList)localObject1).add(new b(localan, 100));
              }
            }
          }
          if (this.FoY) {
            Collections.sort((List)localObject1, new Comparator() {});
          }
          if (!this.rCv)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b)((Iterator)localObject1).next();
              this.BJc.add((an)((b)localObject2).Fpc);
            }
          }
        }
        if (this.rCv) {
          this.FoN = this.FoL.size();
        }
      }
      else
      {
        if (this.FoN != 0) {
          break label581;
        }
        this.FoM = FoG;
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.FoN + " realySize : " + this.FoM);
      ceE();
      AppMethodBeat.o(152196);
      return;
      if (this.dzK)
      {
        if ((this.fNS != null) && (!this.fNS.YQ()))
        {
          if (this.BJc.size() >= MAX_COUNT) {}
          for (i = MAX_COUNT;; i = this.BJc.size())
          {
            this.FoN = i;
            break;
          }
        }
        if (this.BJc.size() >= MAX_COUNT - 1) {}
        for (i = MAX_COUNT - 1;; i = this.BJc.size())
        {
          this.FoN = i;
          break;
        }
      }
      this.FoN = this.BJc.size();
      break;
      fgu();
      break;
      label581:
      if ((this.FoQ) && (this.FoP) && (this.FoR)) {
        this.FoM = (((this.FoN + 2) / FoG + 1) * FoG);
      } else if (((this.FoQ) && (this.FoP) && (!this.FoR)) || ((this.FoQ) && (!this.FoP) && (this.FoR)) || ((!this.FoQ) && (this.FoP) && (this.FoR))) {
        this.FoM = (((this.FoN + 1) / FoG + 1) * FoG);
      } else if (((this.FoQ) && (!this.FoP) && (!this.FoR)) || ((!this.FoQ) && (this.FoP) && (!this.FoR)) || ((!this.FoQ) && (!this.FoP) && (this.FoR))) {
        this.FoM = ((this.FoN / FoG + 1) * FoG);
      } else if ((!this.FoQ) && (!this.FoP) && (!this.FoR)) {
        this.FoM = (((this.FoN - 1) / FoG + 1) * FoG);
      }
    }
  }
  
  public final void aP(ArrayList<an> paramArrayList)
  {
    this.FoS = false;
    this.FoI = paramArrayList;
  }
  
  public final void es(List<String> paramList)
  {
    AppMethodBeat.i(152204);
    gb(paramList);
    Zm();
    AppMethodBeat.o(152204);
  }
  
  public final boolean fgt()
  {
    AppMethodBeat.i(152195);
    if (this.rCv)
    {
      bool = this.FoK;
      AppMethodBeat.o(152195);
      return bool;
    }
    boolean bool = com.tencent.mm.model.x.wb(this.username);
    AppMethodBeat.o(152195);
    return bool;
  }
  
  public final void fgv()
  {
    AppMethodBeat.i(152203);
    this.fTh = false;
    Zm();
    AppMethodBeat.o(152203);
  }
  
  public final void gb(List<String> paramList)
  {
    this.FoS = true;
    this.dBf = paramList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(152205);
    if (this.FoT)
    {
      i = Math.min(this.FoU, this.FoM);
      AppMethodBeat.o(152205);
      return i;
    }
    int i = this.FoM;
    AppMethodBeat.o(152205);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152206);
    if (paramInt < this.FoN)
    {
      if (this.rCv)
      {
        localObject = this.FoL.get(paramInt);
        AppMethodBeat.o(152206);
        return localObject;
      }
      Object localObject = this.BJc.get(paramInt);
      AppMethodBeat.o(152206);
      return localObject;
    }
    AppMethodBeat.o(152206);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(152202);
    an localan = null;
    int i;
    if (paramInt < this.FoN)
    {
      i = 0;
      if (this.rCv) {
        paramViewGroup = getItem(paramInt);
      }
    }
    for (;;)
    {
      View localView;
      c localc;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, 2131495276, null);
        localc = fT(localView);
      }
      label257:
      label645:
      label1547:
      for (;;)
      {
        label58:
        int j;
        if ((FoG == 4) || (this.Fpa))
        {
          j = this.mContext.getResources().getDimensionPixelSize(2131165510);
          localc.fUY.getLayoutParams().height = j;
          localc.fUY.getLayoutParams().width = j;
          label113:
          localc.Fpd.setVisibility(8);
          localc.fUA.setVisibility(8);
          if (i != 0) {
            break label968;
          }
          localc.fUY.setVisibility(0);
          if (!this.dzK) {
            break label645;
          }
          if (bu.isNullOrNil(localan.field_conRemark)) {
            break label615;
          }
          paramView = localan.field_conRemark;
          label171:
          Object localObject = paramView;
          if (bu.isNullOrNil(paramView)) {
            localObject = localan.field_conRemark;
          }
          paramView = (View)localObject;
          if (bu.isNullOrNil((String)localObject)) {
            paramView = localan.adF();
          }
          paramView = k.b(this.mContext, paramView, localc.fQm.getTextSize());
          label222:
          if (!(paramView instanceof SpannableString)) {
            break label750;
          }
          localc.fQm.setVisibility(8);
          localc.fUz.setVisibility(0);
          localc.fUz.setText(paramView);
          paramView = com.tencent.mm.openim.room.a.a.O(localan);
          if (!TextUtils.isEmpty(paramView)) {
            break label781;
          }
          localc.fUA.setVisibility(8);
          label280:
          localc.fUY.setContentDescription("");
          if (!this.rCv) {
            break label802;
          }
          q.aJb().a(x.a.Fpn.dO(paramViewGroup), localc.fUY, this.fUx);
          localc.fUY.setBackgroundDrawable(null);
          label331:
          if (!this.rCv) {
            break label914;
          }
          if ((!this.fTh) || ((this.FoV != null) && (this.FoV.equals(x.a.Fpn.dP(paramViewGroup))))) {
            break label901;
          }
          localc.yZI.setVisibility(0);
        }
        label781:
        label802:
        label1315:
        for (;;)
        {
          if ((!this.rCv) || (paramViewGroup == null)) {
            localc.ndr.setVisibility(8);
          }
          localc.oOD = i;
          AppMethodBeat.o(152202);
          return localView;
          localan = (an)getItem(paramInt);
          paramViewGroup = null;
          break;
          if ((paramInt == this.FoN) && (this.FoQ))
          {
            paramViewGroup = null;
            i = 3;
            break;
          }
          if ((paramInt == this.FoN + 1) && (this.FoP))
          {
            paramViewGroup = null;
            i = 4;
            break;
          }
          if ((paramInt == this.FoN + 1) && (this.FoR) && (!this.FoP))
          {
            paramViewGroup = null;
            i = 5;
            break;
          }
          if ((paramInt != this.FoN + 2) || (!this.FoR) || (!this.FoP)) {
            break label1553;
          }
          paramViewGroup = null;
          i = 5;
          break;
          localc = (c)paramView.getTag();
          if (localc != null) {
            break label1547;
          }
          localc = fT(paramView);
          localView = paramView;
          break label58;
          j = this.mContext.getResources().getDimensionPixelSize(2131165508);
          localc.fUY.getLayoutParams().height = j;
          localc.fUY.getLayoutParams().width = j;
          break label113;
          label615:
          paramView = localan.field_username;
          if (this.fNS == null)
          {
            paramView = null;
            break label171;
          }
          paramView = this.fNS.zP(paramView);
          break label171;
          if (this.rCv)
          {
            paramView = k.b(this.mContext, x.a.Fpn.dN(paramViewGroup), localc.fQm.getTextSize());
            break label222;
          }
          if (an.aUq(localan.field_username))
          {
            paramView = ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).e(ak.getContext(), localan.adG(), (int)localc.fQm.getTextSize());
            break label222;
          }
          paramView = k.b(this.mContext, localan.adG(), localc.fQm.getTextSize());
          break label222;
          label750:
          localc.fQm.setVisibility(0);
          localc.fUz.setVisibility(8);
          localc.fQm.setText(paramView);
          break label257;
          localc.fUA.setVisibility(0);
          localc.fUA.setText(paramView);
          break label280;
          a.b.c(localc.fUY, localan.field_username);
          paramView = (com.tencent.mm.pluginsdk.ui.a)localc.fUY.getDrawable();
          if (this.FoO != null) {
            this.FoO.a(paramView);
          }
          localc.fUY.setTagUsername(localan.field_username);
          localc.fUY.setTagTalker(this.username);
          if (com.tencent.mm.model.x.zU(this.username))
          {
            localc.fUY.setTagScene(4);
            break label331;
          }
          localc.fUY.setTagScene(3);
          break label331;
          localc.yZI.setVisibility(8);
          continue;
          label1215:
          label1220:
          if ((this.fTh) && ((this.FoV == null) || (!this.FoV.equals(localan.field_username))))
          {
            localc.yZI.setVisibility(0);
          }
          else
          {
            localc.yZI.setVisibility(8);
            continue;
            label968:
            if (i == 3)
            {
              paramView = localc.fQm;
              if (paramInt == 0)
              {
                j = 8;
                label988:
                paramView.setVisibility(j);
                paramView = localc.fUz;
                if (paramInt != 0) {
                  break label1047;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.yZI.setVisibility(8);
                if (!this.fTh) {
                  break label1052;
                }
                localc.fUY.setVisibility(4);
                break;
                j = 4;
                break label988;
              }
              localc.fUY.setVisibility(0);
              if (this.rCv)
              {
                q.aJb().a("", localc.fUY, this.fUx);
                localc.fUY.setBackgroundDrawable(null);
              }
              localc.fUY.setImageResource(2131231164);
              localc.fUY.setContentDescription(this.mContext.getString(2131755156));
            }
            else if (i == 4)
            {
              paramView = localc.fQm;
              if (1 == paramInt)
              {
                j = 8;
                label1148:
                paramView.setVisibility(j);
                paramView = localc.fUz;
                if (1 != paramInt) {
                  break label1215;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.yZI.setVisibility(8);
                if ((!this.fTh) && (this.FoN != 0)) {
                  break label1220;
                }
                localc.fUY.setVisibility(4);
                break;
                j = 4;
                break label1148;
              }
              localc.fUY.setVisibility(0);
              if (this.rCv)
              {
                q.aJb().a("", localc.fUY, this.fUx);
                localc.fUY.setBackgroundDrawable(null);
              }
              localc.fUY.setImageResource(2131231165);
              localc.fUY.setContentDescription(this.mContext.getString(2131758028));
            }
            else if (i == 5)
            {
              paramView = localc.fQm;
              if (paramInt == 0)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.fUz;
                if (paramInt != 0) {
                  break label1374;
                }
              }
              label1374:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.yZI.setVisibility(8);
                if (!this.fTh) {
                  break label1379;
                }
                localc.fUY.setVisibility(4);
                break;
                j = 4;
                break label1315;
              }
              label1379:
              localc.fUY.setVisibility(0);
              if (this.rCv)
              {
                q.aJb().a("", localc.fUY, this.fUx);
                localc.fUY.setBackgroundDrawable(null);
              }
              localc.fUY.setImageResource(2131231166);
              localc.fUY.setContentDescription(this.mContext.getString(2131761336));
            }
            else if (i == 2)
            {
              if (this.rCv) {
                q.aJb().a("", localc.fUY, this.fUx);
              }
              localc.fQm.setVisibility(4);
              localc.fUz.setVisibility(4);
              localc.yZI.setVisibility(8);
              localc.fUY.setVisibility(4);
              localc.fUY.setImageResource(2131233299);
              localc.fUY.setBackgroundResource(2131233299);
            }
          }
        }
        label914:
        label1047:
        label1052:
        localView = paramView;
      }
      label901:
      label1553:
      paramViewGroup = null;
      i = 2;
    }
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(152194);
    this.username = paramString;
    this.dzK = com.tencent.mm.model.x.wb(paramString);
    if ((!this.dzK) && (x.a.Fpn != null)) {
      this.rCv = x.a.Fpn.aOc(paramString);
    }
    if (!this.rCv) {
      this.fNS = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    }
    fgs();
    AppMethodBeat.o(152194);
  }
  
  public static abstract interface a
  {
    public abstract void ceE();
  }
  
  final class b
  {
    public Object Fpc;
    public int order;
    
    public b(Object paramObject, int paramInt)
    {
      this.Fpc = paramObject;
      this.order = paramInt;
    }
  }
  
  final class c
  {
    public ImageView Fpd;
    public TextView fQm;
    public TextView fUA;
    public AvatarPatTipImageView fUY;
    public TextView fUz;
    public ImageView ndr;
    public int oOD;
    public ImageView yZI;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.r
 * JD-Core Version:    0.7.0.1
 */