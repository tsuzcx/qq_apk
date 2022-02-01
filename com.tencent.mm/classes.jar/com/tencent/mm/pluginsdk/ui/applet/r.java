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
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  public static int Drh = 5;
  public static int MAX_COUNT = 44;
  boolean DrA;
  public boolean DrB;
  a Dri;
  private ArrayList<com.tencent.mm.storage.ai> Drj;
  public boolean Drk;
  public boolean Drl;
  private List<Object> Drm;
  int Drn;
  int Dro;
  d Drp;
  public boolean Drq;
  public boolean Drr;
  public boolean Drs;
  private boolean Drt;
  boolean Dru;
  int Drv;
  String Drw;
  private final int Drx;
  public boolean Dry;
  private boolean Drz;
  private boolean dmR;
  private List<String> dom;
  com.tencent.mm.storage.x ftP;
  boolean fxO;
  private com.tencent.mm.av.a.a.c fze;
  private Context mContext;
  boolean qKh;
  private String username;
  private List<com.tencent.mm.storage.ai> zZR;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(152192);
    this.dom = new ArrayList();
    this.Drj = new ArrayList();
    this.qKh = false;
    this.Drk = false;
    this.Drl = false;
    this.zZR = new ArrayList();
    this.Drm = new ArrayList();
    this.Drn = 0;
    this.Dro = 0;
    this.Drq = false;
    this.Drr = false;
    this.Drs = false;
    this.Drt = true;
    this.Dru = false;
    this.Drv = 12;
    this.Dry = false;
    this.fze = null;
    this.Drz = true;
    this.DrA = true;
    this.DrB = false;
    this.mContext = paramContext;
    this.fxO = false;
    this.Drx = paramContext.getResources().getDimensionPixelSize(2131165187);
    AppMethodBeat.o(152192);
  }
  
  private void WZ(int paramInt)
  {
    AppMethodBeat.i(152199);
    if (paramInt < this.Dro)
    {
      this.fxO = true;
      bYL();
    }
    AppMethodBeat.o(152199);
  }
  
  private void bYL()
  {
    AppMethodBeat.i(152200);
    if (this.Dri != null) {
      this.Dri.bYL();
    }
    AppMethodBeat.o(152200);
  }
  
  private void eNF()
  {
    AppMethodBeat.i(152193);
    if ((this.qKh) && (x.a.DrP != null)) {
      this.fze = x.a.DrP.aHf(this.username);
    }
    AppMethodBeat.o(152193);
  }
  
  private void eNH()
  {
    AppMethodBeat.i(152197);
    if (this.Drj == null)
    {
      AppMethodBeat.o(152197);
      return;
    }
    ac.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[] { Integer.valueOf(this.Drj.size()) });
    this.zZR.clear();
    if (this.Drj.size() > 0)
    {
      Iterator localIterator = this.Drj.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.storage.ai localai = (com.tencent.mm.storage.ai)localIterator.next();
        this.zZR.add(localai);
      }
    }
    this.Dro = this.zZR.size();
    AppMethodBeat.o(152197);
  }
  
  private c fF(View paramView)
  {
    AppMethodBeat.i(152201);
    c localc = new c();
    localc.DrE = ((ImageView)paramView.findViewById(2131304212));
    localc.fuY = ((ImageView)paramView.findViewById(2131304237));
    localc.xuN = ((ImageView)paramView.findViewById(2131304211));
    localc.fuZ = ((TextView)paramView.findViewById(2131304233));
    localc.fzg = ((TextView)paramView.findViewById(2131304234));
    localc.fzh = ((TextView)paramView.findViewById(2131304236));
    localc.mxD = ((ImageView)paramView.findViewById(2131304213));
    localc.fuY.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.setTag(localc);
    AppMethodBeat.o(152201);
    return localc;
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(152196);
    if ((this.dom == null) && (this.Drj == null))
    {
      AppMethodBeat.o(152196);
      return;
    }
    int i;
    if (this.Drt) {
      if (this.dom != null)
      {
        ac.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[] { Integer.valueOf(this.dom.size()) });
        this.zZR.clear();
        this.Drm.clear();
        Object localObject1 = new LinkedList();
        if (this.dom.size() > 0)
        {
          Object localObject2 = this.dom.iterator();
          i = 1;
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if (this.qKh)
            {
              this.Drm.add(x.a.DrP.aHe(str));
            }
            else
            {
              com.tencent.mm.storage.ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
              if ((this.ftP != null) && (str.equals(this.ftP.field_roomowner)))
              {
                ((LinkedList)localObject1).add(new b(localai, 0));
              }
              else if ((this.ftP != null) && (this.ftP.aMU(localai.field_username)))
              {
                ((LinkedList)localObject1).add(new b(localai, i));
                i += 1;
              }
              else
              {
                ((LinkedList)localObject1).add(new b(localai, 100));
              }
            }
          }
          if (this.Drz) {
            Collections.sort((List)localObject1, new Comparator() {});
          }
          if (!this.qKh)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b)((Iterator)localObject1).next();
              this.zZR.add((com.tencent.mm.storage.ai)((b)localObject2).DrD);
            }
          }
        }
        if (this.qKh) {
          this.Dro = this.Drm.size();
        }
      }
      else
      {
        if (this.Dro != 0) {
          break label581;
        }
        this.Drn = Drh;
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.Dro + " realySize : " + this.Drn);
      bYL();
      AppMethodBeat.o(152196);
      return;
      if (this.dmR)
      {
        if ((this.ftP != null) && (!this.ftP.Wp()))
        {
          if (this.zZR.size() >= MAX_COUNT) {}
          for (i = MAX_COUNT;; i = this.zZR.size())
          {
            this.Dro = i;
            break;
          }
        }
        if (this.zZR.size() >= MAX_COUNT - 1) {}
        for (i = MAX_COUNT - 1;; i = this.zZR.size())
        {
          this.Dro = i;
          break;
        }
      }
      this.Dro = this.zZR.size();
      break;
      eNH();
      break;
      label581:
      if ((this.Drr) && (this.Drq) && (this.Drs)) {
        this.Drn = (((this.Dro + 2) / Drh + 1) * Drh);
      } else if (((this.Drr) && (this.Drq) && (!this.Drs)) || ((this.Drr) && (!this.Drq) && (this.Drs)) || ((!this.Drr) && (this.Drq) && (this.Drs))) {
        this.Drn = (((this.Dro + 1) / Drh + 1) * Drh);
      } else if (((this.Drr) && (!this.Drq) && (!this.Drs)) || ((!this.Drr) && (this.Drq) && (!this.Drs)) || ((!this.Drr) && (!this.Drq) && (this.Drs))) {
        this.Drn = ((this.Dro / Drh + 1) * Drh);
      } else if ((!this.Drr) && (!this.Drq) && (!this.Drs)) {
        this.Drn = (((this.Dro - 1) / Drh + 1) * Drh);
      }
    }
  }
  
  public final boolean WY(int paramInt)
  {
    AppMethodBeat.i(152198);
    if (!this.fxO)
    {
      WZ(paramInt);
      AppMethodBeat.o(152198);
      return true;
    }
    AppMethodBeat.o(152198);
    return false;
  }
  
  public final boolean Xa(int paramInt)
  {
    return paramInt < this.Dro;
  }
  
  public final void aR(ArrayList<com.tencent.mm.storage.ai> paramArrayList)
  {
    this.Drt = false;
    this.Drj = paramArrayList;
  }
  
  public final boolean eNG()
  {
    AppMethodBeat.i(152195);
    if (this.qKh)
    {
      bool = this.Drl;
      AppMethodBeat.o(152195);
      return bool;
    }
    boolean bool = w.sQ(this.username);
    AppMethodBeat.o(152195);
    return bool;
  }
  
  public final void eNI()
  {
    AppMethodBeat.i(152203);
    this.fxO = false;
    WJ();
    AppMethodBeat.o(152203);
  }
  
  public final void eb(List<String> paramList)
  {
    AppMethodBeat.i(152204);
    fH(paramList);
    WJ();
    AppMethodBeat.o(152204);
  }
  
  public final void fH(List<String> paramList)
  {
    this.Drt = true;
    this.dom = paramList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(152205);
    if (this.Dru)
    {
      i = Math.min(this.Drv, this.Drn);
      AppMethodBeat.o(152205);
      return i;
    }
    int i = this.Drn;
    AppMethodBeat.o(152205);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152206);
    if (paramInt < this.Dro)
    {
      if (this.qKh)
      {
        localObject = this.Drm.get(paramInt);
        AppMethodBeat.o(152206);
        return localObject;
      }
      Object localObject = this.zZR.get(paramInt);
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
    com.tencent.mm.storage.ai localai;
    int i;
    if (paramInt < this.Dro) {
      if (this.qKh)
      {
        paramViewGroup = getItem(paramInt);
        localai = null;
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
        localc = fF(localView);
      }
      label257:
      label280:
      label1179:
      for (;;)
      {
        label58:
        int j;
        if ((Drh == 4) || (this.DrB))
        {
          j = this.mContext.getResources().getDimensionPixelSize(2131165510);
          localc.fuY.getLayoutParams().height = j;
          localc.fuY.getLayoutParams().width = j;
          label113:
          localc.DrE.setVisibility(8);
          localc.fzh.setVisibility(8);
          if (i != 0) {
            break label927;
          }
          localc.fuY.setVisibility(0);
          if (!this.dmR) {
            break label660;
          }
          if (bs.isNullOrNil(localai.field_conRemark)) {
            break label630;
          }
          paramView = localai.field_conRemark;
          label171:
          Object localObject = paramView;
          if (bs.isNullOrNil(paramView)) {
            localObject = localai.field_conRemark;
          }
          paramView = (View)localObject;
          if (bs.isNullOrNil((String)localObject)) {
            paramView = localai.aaR();
          }
          paramView = com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, localc.fuZ.getTextSize());
          label222:
          if (!(paramView instanceof SpannableString)) {
            break label765;
          }
          localc.fuZ.setVisibility(8);
          localc.fzg.setVisibility(0);
          localc.fzg.setText(paramView);
          paramView = com.tencent.mm.openim.room.a.a.H(localai);
          if (!TextUtils.isEmpty(paramView)) {
            break label796;
          }
          localc.fzh.setVisibility(8);
          localc.fuY.setContentDescription("");
          if (!this.qKh) {
            break label817;
          }
          o.aFB().a(x.a.DrP.dK(paramViewGroup), localc.fuY, this.fze);
          localc.fuY.setBackgroundDrawable(null);
          label331:
          if (!this.qKh) {
            break label873;
          }
          if ((!this.fxO) || ((this.Drw != null) && (this.Drw.equals(x.a.DrP.dL(paramViewGroup))))) {
            break label860;
          }
          localc.xuN.setVisibility(0);
        }
        label796:
        label817:
        label947:
        label1107:
        for (;;)
        {
          if ((!this.qKh) || (paramViewGroup == null)) {
            localc.mxD.setVisibility(8);
          }
          localc.oeH = i;
          AppMethodBeat.o(152202);
          return localView;
          localai = (com.tencent.mm.storage.ai)getItem(paramInt);
          paramViewGroup = null;
          i = 0;
          break;
          if ((paramInt == this.Dro) && (this.Drr))
          {
            paramViewGroup = null;
            localai = null;
            i = 3;
            break;
          }
          if ((paramInt == this.Dro + 1) && (this.Drq))
          {
            paramViewGroup = null;
            localai = null;
            i = 4;
            break;
          }
          if ((paramInt == this.Dro + 1) && (this.Drs) && (!this.Drq))
          {
            paramViewGroup = null;
            localai = null;
            i = 5;
            break;
          }
          if ((paramInt != this.Dro + 2) || (!this.Drs) || (!this.Drq)) {
            break label1512;
          }
          paramViewGroup = null;
          localai = null;
          i = 5;
          break;
          localc = (c)paramView.getTag();
          if (localc != null) {
            break label1506;
          }
          localc = fF(paramView);
          localView = paramView;
          break label58;
          j = this.mContext.getResources().getDimensionPixelSize(2131165508);
          localc.fuY.getLayoutParams().height = j;
          localc.fuY.getLayoutParams().width = j;
          break label113;
          label630:
          paramView = localai.field_username;
          if (this.ftP == null)
          {
            paramView = null;
            break label171;
          }
          paramView = this.ftP.wk(paramView);
          break label171;
          if (this.qKh)
          {
            paramView = com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, x.a.DrP.dJ(paramViewGroup), localc.fuZ.getTextSize());
            break label222;
          }
          if (com.tencent.mm.storage.ai.aNc(localai.field_username))
          {
            paramView = ((b)g.ab(b.class)).e(com.tencent.mm.sdk.platformtools.ai.getContext(), localai.aaS(), (int)localc.fuZ.getTextSize());
            break label222;
          }
          paramView = com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localai.aaS(), localc.fuZ.getTextSize());
          break label222;
          label765:
          localc.fuZ.setVisibility(0);
          localc.fzg.setVisibility(8);
          localc.fuZ.setText(paramView);
          break label257;
          localc.fzh.setVisibility(0);
          localc.fzh.setText(paramView);
          break label280;
          a.b.c(localc.fuY, localai.field_username);
          paramView = (com.tencent.mm.pluginsdk.ui.a)localc.fuY.getDrawable();
          if (this.Drp == null) {
            break label331;
          }
          this.Drp.a(paramView);
          break label331;
          label860:
          localc.xuN.setVisibility(8);
          continue;
          label873:
          if ((this.fxO) && ((this.Drw == null) || (!this.Drw.equals(localai.field_username))))
          {
            localc.xuN.setVisibility(0);
          }
          else
          {
            localc.xuN.setVisibility(8);
            continue;
            if (i == 3)
            {
              paramView = localc.fuZ;
              if (paramInt == 0)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.fzg;
                if (paramInt != 0) {
                  break label1006;
                }
              }
              label1006:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.xuN.setVisibility(8);
                if (!this.fxO) {
                  break label1011;
                }
                localc.fuY.setVisibility(4);
                break;
                j = 4;
                break label947;
              }
              label1011:
              localc.fuY.setVisibility(0);
              if (this.qKh)
              {
                o.aFB().a("", localc.fuY, this.fze);
                localc.fuY.setBackgroundDrawable(null);
              }
              localc.fuY.setImageResource(2131231164);
              localc.fuY.setContentDescription(this.mContext.getString(2131755156));
            }
            else if (i == 4)
            {
              paramView = localc.fuZ;
              if (1 == paramInt)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.fzg;
                if (1 != paramInt) {
                  break label1174;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.xuN.setVisibility(8);
                if ((!this.fxO) && (this.Dro != 0)) {
                  break label1179;
                }
                localc.fuY.setVisibility(4);
                break;
                j = 4;
                break label1107;
              }
              localc.fuY.setVisibility(0);
              if (this.qKh)
              {
                o.aFB().a("", localc.fuY, this.fze);
                localc.fuY.setBackgroundDrawable(null);
              }
              localc.fuY.setImageResource(2131231165);
              localc.fuY.setContentDescription(this.mContext.getString(2131758028));
            }
            else if (i == 5)
            {
              paramView = localc.fuZ;
              if (paramInt == 0)
              {
                j = 8;
                label1274:
                paramView.setVisibility(j);
                paramView = localc.fzg;
                if (paramInt != 0) {
                  break label1333;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.xuN.setVisibility(8);
                if (!this.fxO) {
                  break label1338;
                }
                localc.fuY.setVisibility(4);
                break;
                j = 4;
                break label1274;
              }
              localc.fuY.setVisibility(0);
              if (this.qKh)
              {
                o.aFB().a("", localc.fuY, this.fze);
                localc.fuY.setBackgroundDrawable(null);
              }
              localc.fuY.setImageResource(2131231166);
              localc.fuY.setContentDescription(this.mContext.getString(2131761336));
            }
            else if (i == 2)
            {
              if (this.qKh) {
                o.aFB().a("", localc.fuY, this.fze);
              }
              localc.fuZ.setVisibility(4);
              localc.fzg.setVisibility(4);
              localc.xuN.setVisibility(8);
              localc.fuY.setVisibility(4);
              localc.fuY.setImageResource(2131233299);
              localc.fuY.setBackgroundResource(2131233299);
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
      localai = null;
      i = 2;
    }
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(152194);
    this.username = paramString;
    this.dmR = w.sQ(paramString);
    if ((!this.dmR) && (x.a.DrP != null)) {
      this.qKh = x.a.DrP.aHd(paramString);
    }
    if (!this.qKh) {
      this.ftP = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(paramString);
    }
    eNF();
    AppMethodBeat.o(152194);
  }
  
  public static abstract interface a
  {
    public abstract void bYL();
  }
  
  final class b
  {
    public Object DrD;
    public int order;
    
    public b(Object paramObject, int paramInt)
    {
      this.DrD = paramObject;
      this.order = paramInt;
    }
  }
  
  final class c
  {
    public ImageView DrE;
    public ImageView fuY;
    public TextView fuZ;
    public TextView fzg;
    public TextView fzh;
    public ImageView mxD;
    public int oeH;
    public ImageView xuN;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.r
 * JD-Core Version:    0.7.0.1
 */