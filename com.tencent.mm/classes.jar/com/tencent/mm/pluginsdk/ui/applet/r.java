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
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  public static int BYQ = 5;
  public static int llh = 44;
  a BYR;
  private ArrayList<af> BYS;
  public boolean BYT;
  public boolean BYU;
  private List<Object> BYV;
  int BYW;
  int BYX;
  d BYY;
  public boolean BYZ;
  public boolean BZa;
  public boolean BZb;
  private boolean BZc;
  boolean BZd;
  int BZe;
  String BZf;
  private final int BZg;
  public boolean BZh;
  private boolean BZi;
  boolean BZj;
  public boolean BZk;
  private boolean dph;
  private List<String> dqB;
  com.tencent.mm.storage.w fql;
  boolean fuh;
  private com.tencent.mm.aw.a.a.c fvx;
  private Context mContext;
  boolean qbB;
  private String username;
  private List<af> yLZ;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(152192);
    this.dqB = new ArrayList();
    this.BYS = new ArrayList();
    this.qbB = false;
    this.BYT = false;
    this.BYU = false;
    this.yLZ = new ArrayList();
    this.BYV = new ArrayList();
    this.BYW = 0;
    this.BYX = 0;
    this.BYZ = false;
    this.BZa = false;
    this.BZb = false;
    this.BZc = true;
    this.BZd = false;
    this.BZe = 12;
    this.BZh = false;
    this.fvx = null;
    this.BZi = true;
    this.BZj = true;
    this.BZk = false;
    this.mContext = paramContext;
    this.fuh = false;
    this.BZg = paramContext.getResources().getDimensionPixelSize(2131165187);
    AppMethodBeat.o(152192);
  }
  
  private void UQ(int paramInt)
  {
    AppMethodBeat.i(152199);
    if (paramInt < this.BYX)
    {
      this.fuh = true;
      bRw();
    }
    AppMethodBeat.o(152199);
  }
  
  private void bRw()
  {
    AppMethodBeat.i(152200);
    if (this.BYR != null) {
      this.BYR.bRw();
    }
    AppMethodBeat.o(152200);
  }
  
  private void eyl()
  {
    AppMethodBeat.i(152193);
    if ((this.qbB) && (x.a.BZz != null)) {
      this.fvx = x.a.BZz.aBN(this.username);
    }
    AppMethodBeat.o(152193);
  }
  
  private void eyn()
  {
    AppMethodBeat.i(152197);
    if (this.BYS == null)
    {
      AppMethodBeat.o(152197);
      return;
    }
    ad.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[] { Integer.valueOf(this.BYS.size()) });
    this.yLZ.clear();
    if (this.BYS.size() > 0)
    {
      Iterator localIterator = this.BYS.iterator();
      while (localIterator.hasNext())
      {
        af localaf = (af)localIterator.next();
        this.yLZ.add(localaf);
      }
    }
    this.BYX = this.yLZ.size();
    AppMethodBeat.o(152197);
  }
  
  private c fs(View paramView)
  {
    AppMethodBeat.i(152201);
    c localc = new c();
    localc.BZn = ((ImageView)paramView.findViewById(2131304212));
    localc.frr = ((ImageView)paramView.findViewById(2131304237));
    localc.wjx = ((ImageView)paramView.findViewById(2131304211));
    localc.frs = ((TextView)paramView.findViewById(2131304233));
    localc.fvz = ((TextView)paramView.findViewById(2131304234));
    localc.fvA = ((TextView)paramView.findViewById(2131304236));
    localc.lVB = ((ImageView)paramView.findViewById(2131304213));
    localc.frr.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.setTag(localc);
    AppMethodBeat.o(152201);
    return localc;
  }
  
  public final boolean UP(int paramInt)
  {
    AppMethodBeat.i(152198);
    if (!this.fuh)
    {
      UQ(paramInt);
      AppMethodBeat.o(152198);
      return true;
    }
    AppMethodBeat.o(152198);
    return false;
  }
  
  public final boolean UR(int paramInt)
  {
    return paramInt < this.BYX;
  }
  
  public final void VL()
  {
    AppMethodBeat.i(152196);
    if ((this.dqB == null) && (this.BYS == null))
    {
      AppMethodBeat.o(152196);
      return;
    }
    int i;
    if (this.BZc) {
      if (this.dqB != null)
      {
        ad.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[] { Integer.valueOf(this.dqB.size()) });
        this.yLZ.clear();
        this.BYV.clear();
        Object localObject1 = new LinkedList();
        if (this.dqB.size() > 0)
        {
          Object localObject2 = this.dqB.iterator();
          i = 1;
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if (this.qbB)
            {
              this.BYV.add(x.a.BZz.aBM(str));
            }
            else
            {
              af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
              if ((this.fql != null) && (str.equals(this.fql.field_roomowner)))
              {
                ((LinkedList)localObject1).add(new b(localaf, 0));
              }
              else if ((this.fql != null) && (this.fql.aHz(localaf.field_username)))
              {
                ((LinkedList)localObject1).add(new b(localaf, i));
                i += 1;
              }
              else
              {
                ((LinkedList)localObject1).add(new b(localaf, 100));
              }
            }
          }
          if (this.BZi) {
            Collections.sort((List)localObject1, new Comparator() {});
          }
          if (!this.qbB)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b)((Iterator)localObject1).next();
              this.yLZ.add((af)((b)localObject2).BZm);
            }
          }
        }
        if (this.qbB) {
          this.BYX = this.BYV.size();
        }
      }
      else
      {
        if (this.BYX != 0) {
          break label581;
        }
        this.BYW = BYQ;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.BYX + " realySize : " + this.BYW);
      bRw();
      AppMethodBeat.o(152196);
      return;
      if (this.dph)
      {
        if ((this.fql != null) && (!this.fql.Vq()))
        {
          if (this.yLZ.size() >= llh) {}
          for (i = llh;; i = this.yLZ.size())
          {
            this.BYX = i;
            break;
          }
        }
        if (this.yLZ.size() >= llh - 1) {}
        for (i = llh - 1;; i = this.yLZ.size())
        {
          this.BYX = i;
          break;
        }
      }
      this.BYX = this.yLZ.size();
      break;
      eyn();
      break;
      label581:
      if ((this.BZa) && (this.BYZ) && (this.BZb)) {
        this.BYW = (((this.BYX + 2) / BYQ + 1) * BYQ);
      } else if (((this.BZa) && (this.BYZ) && (!this.BZb)) || ((this.BZa) && (!this.BYZ) && (this.BZb)) || ((!this.BZa) && (this.BYZ) && (this.BZb))) {
        this.BYW = (((this.BYX + 1) / BYQ + 1) * BYQ);
      } else if (((this.BZa) && (!this.BYZ) && (!this.BZb)) || ((!this.BZa) && (this.BYZ) && (!this.BZb)) || ((!this.BZa) && (!this.BYZ) && (this.BZb))) {
        this.BYW = ((this.BYX / BYQ + 1) * BYQ);
      } else if ((!this.BZa) && (!this.BYZ) && (!this.BZb)) {
        this.BYW = (((this.BYX - 1) / BYQ + 1) * BYQ);
      }
    }
  }
  
  public final void aF(ArrayList<af> paramArrayList)
  {
    this.BZc = false;
    this.BYS = paramArrayList;
  }
  
  public final void dX(List<String> paramList)
  {
    AppMethodBeat.i(152204);
    fz(paramList);
    VL();
    AppMethodBeat.o(152204);
  }
  
  public final boolean eym()
  {
    AppMethodBeat.i(152195);
    if (this.qbB)
    {
      bool = this.BYU;
      AppMethodBeat.o(152195);
      return bool;
    }
    boolean bool = com.tencent.mm.model.w.pF(this.username);
    AppMethodBeat.o(152195);
    return bool;
  }
  
  public final void eyo()
  {
    AppMethodBeat.i(152203);
    this.fuh = false;
    VL();
    AppMethodBeat.o(152203);
  }
  
  public final void fz(List<String> paramList)
  {
    this.BZc = true;
    this.dqB = paramList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(152205);
    if (this.BZd)
    {
      i = Math.min(this.BZe, this.BYW);
      AppMethodBeat.o(152205);
      return i;
    }
    int i = this.BYW;
    AppMethodBeat.o(152205);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152206);
    if (paramInt < this.BYX)
    {
      if (this.qbB)
      {
        localObject = this.BYV.get(paramInt);
        AppMethodBeat.o(152206);
        return localObject;
      }
      Object localObject = this.yLZ.get(paramInt);
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
    af localaf;
    int i;
    if (paramInt < this.BYX) {
      if (this.qbB)
      {
        paramViewGroup = getItem(paramInt);
        localaf = null;
        i = 0;
      }
    }
    for (;;)
    {
      View localView;
      c localc;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, 2131495276, null);
        localc = fs(localView);
      }
      label257:
      label280:
      label1179:
      for (;;)
      {
        label58:
        int j;
        if ((BYQ == 4) || (this.BZk))
        {
          j = this.mContext.getResources().getDimensionPixelSize(2131165510);
          localc.frr.getLayoutParams().height = j;
          localc.frr.getLayoutParams().width = j;
          label113:
          localc.BZn.setVisibility(8);
          localc.fvA.setVisibility(8);
          if (i != 0) {
            break label927;
          }
          localc.frr.setVisibility(0);
          if (!this.dph) {
            break label660;
          }
          if (bt.isNullOrNil(localaf.field_conRemark)) {
            break label630;
          }
          paramView = localaf.field_conRemark;
          label171:
          Object localObject = paramView;
          if (bt.isNullOrNil(paramView)) {
            localObject = localaf.field_conRemark;
          }
          paramView = (View)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramView = localaf.ZW();
          }
          paramView = com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, localc.frs.getTextSize());
          label222:
          if (!(paramView instanceof SpannableString)) {
            break label765;
          }
          localc.frs.setVisibility(8);
          localc.fvz.setVisibility(0);
          localc.fvz.setText(paramView);
          paramView = com.tencent.mm.openim.room.a.a.G(localaf);
          if (!TextUtils.isEmpty(paramView)) {
            break label796;
          }
          localc.fvA.setVisibility(8);
          localc.frr.setContentDescription("");
          if (!this.qbB) {
            break label817;
          }
          o.ayJ().a(x.a.BZz.dJ(paramViewGroup), localc.frr, this.fvx);
          localc.frr.setBackgroundDrawable(null);
          label331:
          if (!this.qbB) {
            break label873;
          }
          if ((!this.fuh) || ((this.BZf != null) && (this.BZf.equals(x.a.BZz.dK(paramViewGroup))))) {
            break label860;
          }
          localc.wjx.setVisibility(0);
        }
        label796:
        label817:
        label947:
        label1107:
        for (;;)
        {
          if ((!this.qbB) || (paramViewGroup == null)) {
            localc.lVB.setVisibility(8);
          }
          localc.nBH = i;
          AppMethodBeat.o(152202);
          return localView;
          localaf = (af)getItem(paramInt);
          paramViewGroup = null;
          i = 0;
          break;
          if ((paramInt == this.BYX) && (this.BZa))
          {
            paramViewGroup = null;
            localaf = null;
            i = 3;
            break;
          }
          if ((paramInt == this.BYX + 1) && (this.BYZ))
          {
            paramViewGroup = null;
            localaf = null;
            i = 4;
            break;
          }
          if ((paramInt == this.BYX + 1) && (this.BZb) && (!this.BYZ))
          {
            paramViewGroup = null;
            localaf = null;
            i = 5;
            break;
          }
          if ((paramInt != this.BYX + 2) || (!this.BZb) || (!this.BYZ)) {
            break label1512;
          }
          paramViewGroup = null;
          localaf = null;
          i = 5;
          break;
          localc = (c)paramView.getTag();
          if (localc != null) {
            break label1506;
          }
          localc = fs(paramView);
          localView = paramView;
          break label58;
          j = this.mContext.getResources().getDimensionPixelSize(2131165508);
          localc.frr.getLayoutParams().height = j;
          localc.frr.getLayoutParams().width = j;
          break label113;
          label630:
          paramView = localaf.field_username;
          if (this.fql == null)
          {
            paramView = null;
            break label171;
          }
          paramView = this.fql.sh(paramView);
          break label171;
          if (this.qbB)
          {
            paramView = com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, x.a.BZz.dI(paramViewGroup), localc.frs.getTextSize());
            break label222;
          }
          if (af.aHH(localaf.field_username))
          {
            paramView = ((b)g.ab(b.class)).e(com.tencent.mm.sdk.platformtools.aj.getContext(), localaf.ZX(), (int)localc.frs.getTextSize());
            break label222;
          }
          paramView = com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localaf.ZX(), localc.frs.getTextSize());
          break label222;
          label765:
          localc.frs.setVisibility(0);
          localc.fvz.setVisibility(8);
          localc.frs.setText(paramView);
          break label257;
          localc.fvA.setVisibility(0);
          localc.fvA.setText(paramView);
          break label280;
          a.b.c(localc.frr, localaf.field_username);
          paramView = (com.tencent.mm.pluginsdk.ui.a)localc.frr.getDrawable();
          if (this.BYY == null) {
            break label331;
          }
          this.BYY.a(paramView);
          break label331;
          label860:
          localc.wjx.setVisibility(8);
          continue;
          label873:
          if ((this.fuh) && ((this.BZf == null) || (!this.BZf.equals(localaf.field_username))))
          {
            localc.wjx.setVisibility(0);
          }
          else
          {
            localc.wjx.setVisibility(8);
            continue;
            if (i == 3)
            {
              paramView = localc.frs;
              if (paramInt == 0)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.fvz;
                if (paramInt != 0) {
                  break label1006;
                }
              }
              label1006:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.wjx.setVisibility(8);
                if (!this.fuh) {
                  break label1011;
                }
                localc.frr.setVisibility(4);
                break;
                j = 4;
                break label947;
              }
              label1011:
              localc.frr.setVisibility(0);
              if (this.qbB)
              {
                o.ayJ().a("", localc.frr, this.fvx);
                localc.frr.setBackgroundDrawable(null);
              }
              localc.frr.setImageResource(2131231164);
              localc.frr.setContentDescription(this.mContext.getString(2131755156));
            }
            else if (i == 4)
            {
              paramView = localc.frs;
              if (1 == paramInt)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.fvz;
                if (1 != paramInt) {
                  break label1174;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.wjx.setVisibility(8);
                if ((!this.fuh) && (this.BYX != 0)) {
                  break label1179;
                }
                localc.frr.setVisibility(4);
                break;
                j = 4;
                break label1107;
              }
              localc.frr.setVisibility(0);
              if (this.qbB)
              {
                o.ayJ().a("", localc.frr, this.fvx);
                localc.frr.setBackgroundDrawable(null);
              }
              localc.frr.setImageResource(2131231165);
              localc.frr.setContentDescription(this.mContext.getString(2131758028));
            }
            else if (i == 5)
            {
              paramView = localc.frs;
              if (paramInt == 0)
              {
                j = 8;
                label1274:
                paramView.setVisibility(j);
                paramView = localc.fvz;
                if (paramInt != 0) {
                  break label1333;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.wjx.setVisibility(8);
                if (!this.fuh) {
                  break label1338;
                }
                localc.frr.setVisibility(4);
                break;
                j = 4;
                break label1274;
              }
              localc.frr.setVisibility(0);
              if (this.qbB)
              {
                o.ayJ().a("", localc.frr, this.fvx);
                localc.frr.setBackgroundDrawable(null);
              }
              localc.frr.setImageResource(2131231166);
              localc.frr.setContentDescription(this.mContext.getString(2131761336));
            }
            else if (i == 2)
            {
              if (this.qbB) {
                o.ayJ().a("", localc.frr, this.fvx);
              }
              localc.frs.setVisibility(4);
              localc.fvz.setVisibility(4);
              localc.wjx.setVisibility(8);
              localc.frr.setVisibility(4);
              localc.frr.setImageResource(2131233299);
              localc.frr.setBackgroundResource(2131233299);
            }
          }
        }
        label927:
        label1333:
        label1338:
        label1506:
        localView = paramView;
      }
      label660:
      label1174:
      label1512:
      paramViewGroup = null;
      localaf = null;
      i = 2;
    }
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(152194);
    this.username = paramString;
    this.dph = com.tencent.mm.model.w.pF(paramString);
    if ((!this.dph) && (x.a.BZz != null)) {
      this.qbB = x.a.BZz.aBL(paramString);
    }
    if (!this.qbB) {
      this.fql = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(paramString);
    }
    eyl();
    AppMethodBeat.o(152194);
  }
  
  public static abstract interface a
  {
    public abstract void bRw();
  }
  
  final class b
  {
    public Object BZm;
    public int order;
    
    public b(Object paramObject, int paramInt)
    {
      this.BZm = paramObject;
      this.order = paramInt;
    }
  }
  
  final class c
  {
    public ImageView BZn;
    public ImageView frr;
    public TextView frs;
    public TextView fvA;
    public TextView fvz;
    public ImageView lVB;
    public int nBH;
    public ImageView wjx;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.r
 * JD-Core Version:    0.7.0.1
 */