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
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  public static int EWl = 5;
  public static int MAX_COUNT = 44;
  private List<am> BrD;
  String EWA;
  private final int EWB;
  public boolean EWC;
  private boolean EWD;
  boolean EWE;
  public boolean EWF;
  a EWm;
  private ArrayList<am> EWn;
  public boolean EWo;
  public boolean EWp;
  private List<Object> EWq;
  int EWr;
  int EWs;
  e EWt;
  public boolean EWu;
  public boolean EWv;
  public boolean EWw;
  private boolean EWx;
  boolean EWy;
  int EWz;
  private List<String> dAa;
  private boolean dyF;
  ab fLO;
  boolean fRb;
  private com.tencent.mm.aw.a.a.c fSr;
  private Context mContext;
  boolean ruj;
  private String username;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(152192);
    this.dAa = new ArrayList();
    this.EWn = new ArrayList();
    this.ruj = false;
    this.EWo = false;
    this.EWp = false;
    this.BrD = new ArrayList();
    this.EWq = new ArrayList();
    this.EWr = 0;
    this.EWs = 0;
    this.EWu = false;
    this.EWv = false;
    this.EWw = false;
    this.EWx = true;
    this.EWy = false;
    this.EWz = 12;
    this.EWC = false;
    this.fSr = null;
    this.EWD = true;
    this.EWE = true;
    this.EWF = false;
    this.mContext = paramContext;
    this.fRb = false;
    this.EWB = paramContext.getResources().getDimensionPixelSize(2131165187);
    AppMethodBeat.o(152192);
  }
  
  private void YV(int paramInt)
  {
    AppMethodBeat.i(152199);
    if (paramInt < this.EWs)
    {
      this.fRb = true;
      cdp();
    }
    AppMethodBeat.o(152199);
  }
  
  private void cdp()
  {
    AppMethodBeat.i(152200);
    if (this.EWm != null) {
      this.EWm.cdp();
    }
    AppMethodBeat.o(152200);
  }
  
  private c fU(View paramView)
  {
    AppMethodBeat.i(152201);
    c localc = new c();
    localc.EWI = ((ImageView)paramView.findViewById(2131304212));
    localc.fSS = ((AvatarPatTipImageView)paramView.findViewById(2131304237));
    localc.yJy = ((ImageView)paramView.findViewById(2131304211));
    localc.fOg = ((TextView)paramView.findViewById(2131304233));
    localc.fSt = ((TextView)paramView.findViewById(2131304234));
    localc.fSu = ((TextView)paramView.findViewById(2131304236));
    localc.mYk = ((ImageView)paramView.findViewById(2131304213));
    localc.fSS.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.setTag(localc);
    AppMethodBeat.o(152201);
    return localc;
  }
  
  private void fcE()
  {
    AppMethodBeat.i(152193);
    if ((this.ruj) && (x.a.EWT != null)) {
      this.fSr = x.a.EWT.aMI(this.username);
    }
    AppMethodBeat.o(152193);
  }
  
  private void fcG()
  {
    AppMethodBeat.i(152197);
    if (this.EWn == null)
    {
      AppMethodBeat.o(152197);
      return;
    }
    ad.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[] { Integer.valueOf(this.EWn.size()) });
    this.BrD.clear();
    if (this.EWn.size() > 0)
    {
      Iterator localIterator = this.EWn.iterator();
      while (localIterator.hasNext())
      {
        am localam = (am)localIterator.next();
        this.BrD.add(localam);
      }
    }
    this.EWs = this.BrD.size();
    AppMethodBeat.o(152197);
  }
  
  public final boolean YU(int paramInt)
  {
    AppMethodBeat.i(152198);
    if (!this.fRb)
    {
      YV(paramInt);
      AppMethodBeat.o(152198);
      return true;
    }
    AppMethodBeat.o(152198);
    return false;
  }
  
  public final boolean YW(int paramInt)
  {
    return paramInt < this.EWs;
  }
  
  public final void Zd()
  {
    AppMethodBeat.i(152196);
    if ((this.dAa == null) && (this.EWn == null))
    {
      AppMethodBeat.o(152196);
      return;
    }
    int i;
    if (this.EWx) {
      if (this.dAa != null)
      {
        ad.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[] { Integer.valueOf(this.dAa.size()) });
        this.BrD.clear();
        this.EWq.clear();
        Object localObject1 = new LinkedList();
        if (this.dAa.size() > 0)
        {
          Object localObject2 = this.dAa.iterator();
          i = 1;
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if (this.ruj)
            {
              this.EWq.add(x.a.EWT.aMH(str));
            }
            else
            {
              am localam = ((l)g.ab(l.class)).azp().Bf(str);
              if ((this.fLO != null) && (str.equals(this.fLO.field_roomowner)))
              {
                ((LinkedList)localObject1).add(new b(localam, 0));
              }
              else if ((this.fLO != null) && (this.fLO.aSH(localam.field_username)))
              {
                ((LinkedList)localObject1).add(new b(localam, i));
                i += 1;
              }
              else
              {
                ((LinkedList)localObject1).add(new b(localam, 100));
              }
            }
          }
          if (this.EWD) {
            Collections.sort((List)localObject1, new Comparator() {});
          }
          if (!this.ruj)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b)((Iterator)localObject1).next();
              this.BrD.add((am)((b)localObject2).EWH);
            }
          }
        }
        if (this.ruj) {
          this.EWs = this.EWq.size();
        }
      }
      else
      {
        if (this.EWs != 0) {
          break label581;
        }
        this.EWr = EWl;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.EWs + " realySize : " + this.EWr);
      cdp();
      AppMethodBeat.o(152196);
      return;
      if (this.dyF)
      {
        if ((this.fLO != null) && (!this.fLO.YH()))
        {
          if (this.BrD.size() >= MAX_COUNT) {}
          for (i = MAX_COUNT;; i = this.BrD.size())
          {
            this.EWs = i;
            break;
          }
        }
        if (this.BrD.size() >= MAX_COUNT - 1) {}
        for (i = MAX_COUNT - 1;; i = this.BrD.size())
        {
          this.EWs = i;
          break;
        }
      }
      this.EWs = this.BrD.size();
      break;
      fcG();
      break;
      label581:
      if ((this.EWv) && (this.EWu) && (this.EWw)) {
        this.EWr = (((this.EWs + 2) / EWl + 1) * EWl);
      } else if (((this.EWv) && (this.EWu) && (!this.EWw)) || ((this.EWv) && (!this.EWu) && (this.EWw)) || ((!this.EWv) && (this.EWu) && (this.EWw))) {
        this.EWr = (((this.EWs + 1) / EWl + 1) * EWl);
      } else if (((this.EWv) && (!this.EWu) && (!this.EWw)) || ((!this.EWv) && (this.EWu) && (!this.EWw)) || ((!this.EWv) && (!this.EWu) && (this.EWw))) {
        this.EWr = ((this.EWs / EWl + 1) * EWl);
      } else if ((!this.EWv) && (!this.EWu) && (!this.EWw)) {
        this.EWr = (((this.EWs - 1) / EWl + 1) * EWl);
      }
    }
  }
  
  public final void aO(ArrayList<am> paramArrayList)
  {
    this.EWx = false;
    this.EWn = paramArrayList;
  }
  
  public final void eo(List<String> paramList)
  {
    AppMethodBeat.i(152204);
    fS(paramList);
    Zd();
    AppMethodBeat.o(152204);
  }
  
  public final void fS(List<String> paramList)
  {
    this.EWx = true;
    this.dAa = paramList;
  }
  
  public final boolean fcF()
  {
    AppMethodBeat.i(152195);
    if (this.ruj)
    {
      bool = this.EWp;
      AppMethodBeat.o(152195);
      return bool;
    }
    boolean bool = w.vF(this.username);
    AppMethodBeat.o(152195);
    return bool;
  }
  
  public final void fcH()
  {
    AppMethodBeat.i(152203);
    this.fRb = false;
    Zd();
    AppMethodBeat.o(152203);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(152205);
    if (this.EWy)
    {
      i = Math.min(this.EWz, this.EWr);
      AppMethodBeat.o(152205);
      return i;
    }
    int i = this.EWr;
    AppMethodBeat.o(152205);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152206);
    if (paramInt < this.EWs)
    {
      if (this.ruj)
      {
        localObject = this.EWq.get(paramInt);
        AppMethodBeat.o(152206);
        return localObject;
      }
      Object localObject = this.BrD.get(paramInt);
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
    am localam = null;
    int i;
    if (paramInt < this.EWs)
    {
      i = 0;
      if (this.ruj) {
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
        localc = fU(localView);
      }
      label257:
      label645:
      label1547:
      for (;;)
      {
        label58:
        int j;
        if ((EWl == 4) || (this.EWF))
        {
          j = this.mContext.getResources().getDimensionPixelSize(2131165510);
          localc.fSS.getLayoutParams().height = j;
          localc.fSS.getLayoutParams().width = j;
          label113:
          localc.EWI.setVisibility(8);
          localc.fSu.setVisibility(8);
          if (i != 0) {
            break label968;
          }
          localc.fSS.setVisibility(0);
          if (!this.dyF) {
            break label645;
          }
          if (bt.isNullOrNil(localam.field_conRemark)) {
            break label615;
          }
          paramView = localam.field_conRemark;
          label171:
          Object localObject = paramView;
          if (bt.isNullOrNil(paramView)) {
            localObject = localam.field_conRemark;
          }
          paramView = (View)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramView = localam.adu();
          }
          paramView = k.b(this.mContext, paramView, localc.fOg.getTextSize());
          label222:
          if (!(paramView instanceof SpannableString)) {
            break label750;
          }
          localc.fOg.setVisibility(8);
          localc.fSt.setVisibility(0);
          localc.fSt.setText(paramView);
          paramView = com.tencent.mm.openim.room.a.a.H(localam);
          if (!TextUtils.isEmpty(paramView)) {
            break label781;
          }
          localc.fSu.setVisibility(8);
          label280:
          localc.fSS.setContentDescription("");
          if (!this.ruj) {
            break label802;
          }
          q.aIJ().a(x.a.EWT.dN(paramViewGroup), localc.fSS, this.fSr);
          localc.fSS.setBackgroundDrawable(null);
          label331:
          if (!this.ruj) {
            break label914;
          }
          if ((!this.fRb) || ((this.EWA != null) && (this.EWA.equals(x.a.EWT.dO(paramViewGroup))))) {
            break label901;
          }
          localc.yJy.setVisibility(0);
        }
        label781:
        label802:
        label1315:
        for (;;)
        {
          if ((!this.ruj) || (paramViewGroup == null)) {
            localc.mYk.setVisibility(8);
          }
          localc.oIb = i;
          AppMethodBeat.o(152202);
          return localView;
          localam = (am)getItem(paramInt);
          paramViewGroup = null;
          break;
          if ((paramInt == this.EWs) && (this.EWv))
          {
            paramViewGroup = null;
            i = 3;
            break;
          }
          if ((paramInt == this.EWs + 1) && (this.EWu))
          {
            paramViewGroup = null;
            i = 4;
            break;
          }
          if ((paramInt == this.EWs + 1) && (this.EWw) && (!this.EWu))
          {
            paramViewGroup = null;
            i = 5;
            break;
          }
          if ((paramInt != this.EWs + 2) || (!this.EWw) || (!this.EWu)) {
            break label1553;
          }
          paramViewGroup = null;
          i = 5;
          break;
          localc = (c)paramView.getTag();
          if (localc != null) {
            break label1547;
          }
          localc = fU(paramView);
          localView = paramView;
          break label58;
          j = this.mContext.getResources().getDimensionPixelSize(2131165508);
          localc.fSS.getLayoutParams().height = j;
          localc.fSS.getLayoutParams().width = j;
          break label113;
          label615:
          paramView = localam.field_username;
          if (this.fLO == null)
          {
            paramView = null;
            break label171;
          }
          paramView = this.fLO.zf(paramView);
          break label171;
          if (this.ruj)
          {
            paramView = k.b(this.mContext, x.a.EWT.dM(paramViewGroup), localc.fOg.getTextSize());
            break label222;
          }
          if (am.aSQ(localam.field_username))
          {
            paramView = ((b)g.ab(b.class)).e(aj.getContext(), localam.adv(), (int)localc.fOg.getTextSize());
            break label222;
          }
          paramView = k.b(this.mContext, localam.adv(), localc.fOg.getTextSize());
          break label222;
          label750:
          localc.fOg.setVisibility(0);
          localc.fSt.setVisibility(8);
          localc.fOg.setText(paramView);
          break label257;
          localc.fSu.setVisibility(0);
          localc.fSu.setText(paramView);
          break label280;
          a.b.c(localc.fSS, localam.field_username);
          paramView = (com.tencent.mm.pluginsdk.ui.a)localc.fSS.getDrawable();
          if (this.EWt != null) {
            this.EWt.a(paramView);
          }
          localc.fSS.setTagUsername(localam.field_username);
          localc.fSS.setTagTalker(this.username);
          if (w.zk(this.username))
          {
            localc.fSS.setTagScene(4);
            break label331;
          }
          localc.fSS.setTagScene(3);
          break label331;
          localc.yJy.setVisibility(8);
          continue;
          label1215:
          label1220:
          if ((this.fRb) && ((this.EWA == null) || (!this.EWA.equals(localam.field_username))))
          {
            localc.yJy.setVisibility(0);
          }
          else
          {
            localc.yJy.setVisibility(8);
            continue;
            label968:
            if (i == 3)
            {
              paramView = localc.fOg;
              if (paramInt == 0)
              {
                j = 8;
                label988:
                paramView.setVisibility(j);
                paramView = localc.fSt;
                if (paramInt != 0) {
                  break label1047;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.yJy.setVisibility(8);
                if (!this.fRb) {
                  break label1052;
                }
                localc.fSS.setVisibility(4);
                break;
                j = 4;
                break label988;
              }
              localc.fSS.setVisibility(0);
              if (this.ruj)
              {
                q.aIJ().a("", localc.fSS, this.fSr);
                localc.fSS.setBackgroundDrawable(null);
              }
              localc.fSS.setImageResource(2131231164);
              localc.fSS.setContentDescription(this.mContext.getString(2131755156));
            }
            else if (i == 4)
            {
              paramView = localc.fOg;
              if (1 == paramInt)
              {
                j = 8;
                label1148:
                paramView.setVisibility(j);
                paramView = localc.fSt;
                if (1 != paramInt) {
                  break label1215;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.yJy.setVisibility(8);
                if ((!this.fRb) && (this.EWs != 0)) {
                  break label1220;
                }
                localc.fSS.setVisibility(4);
                break;
                j = 4;
                break label1148;
              }
              localc.fSS.setVisibility(0);
              if (this.ruj)
              {
                q.aIJ().a("", localc.fSS, this.fSr);
                localc.fSS.setBackgroundDrawable(null);
              }
              localc.fSS.setImageResource(2131231165);
              localc.fSS.setContentDescription(this.mContext.getString(2131758028));
            }
            else if (i == 5)
            {
              paramView = localc.fOg;
              if (paramInt == 0)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.fSt;
                if (paramInt != 0) {
                  break label1374;
                }
              }
              label1374:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.yJy.setVisibility(8);
                if (!this.fRb) {
                  break label1379;
                }
                localc.fSS.setVisibility(4);
                break;
                j = 4;
                break label1315;
              }
              label1379:
              localc.fSS.setVisibility(0);
              if (this.ruj)
              {
                q.aIJ().a("", localc.fSS, this.fSr);
                localc.fSS.setBackgroundDrawable(null);
              }
              localc.fSS.setImageResource(2131231166);
              localc.fSS.setContentDescription(this.mContext.getString(2131761336));
            }
            else if (i == 2)
            {
              if (this.ruj) {
                q.aIJ().a("", localc.fSS, this.fSr);
              }
              localc.fOg.setVisibility(4);
              localc.fSt.setVisibility(4);
              localc.yJy.setVisibility(8);
              localc.fSS.setVisibility(4);
              localc.fSS.setImageResource(2131233299);
              localc.fSS.setBackgroundResource(2131233299);
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
    this.dyF = w.vF(paramString);
    if ((!this.dyF) && (x.a.EWT != null)) {
      this.ruj = x.a.EWT.aMG(paramString);
    }
    if (!this.ruj) {
      this.fLO = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(paramString);
    }
    fcE();
    AppMethodBeat.o(152194);
  }
  
  public static abstract interface a
  {
    public abstract void cdp();
  }
  
  final class b
  {
    public Object EWH;
    public int order;
    
    public b(Object paramObject, int paramInt)
    {
      this.EWH = paramObject;
      this.order = paramInt;
    }
  }
  
  final class c
  {
    public ImageView EWI;
    public TextView fOg;
    public AvatarPatTipImageView fSS;
    public TextView fSt;
    public TextView fSu;
    public ImageView mYk;
    public int oIb;
    public ImageView yJy;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.r
 * JD-Core Version:    0.7.0.1
 */