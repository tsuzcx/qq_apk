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
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends BaseAdapter
{
  public static int MAX_COUNT = 44;
  public static int vTJ = 5;
  private List<String> cAs;
  private boolean czb;
  u efi;
  boolean eht;
  private com.tencent.mm.at.a.a.c eiK;
  private Context mContext;
  boolean muT;
  private List<ad> tfq;
  private String username;
  j.a vTK;
  private ArrayList<ad> vTL;
  public boolean vTM;
  public boolean vTN;
  private List<Object> vTO;
  int vTP;
  int vTQ;
  d vTR;
  public boolean vTS;
  public boolean vTT;
  public boolean vTU;
  private boolean vTV;
  boolean vTW;
  int vTX;
  String vTY;
  private final int vTZ;
  public boolean vUa;
  private boolean vUb;
  boolean vUc;
  public boolean vUd;
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(79744);
    this.cAs = new ArrayList();
    this.vTL = new ArrayList();
    this.muT = false;
    this.vTM = false;
    this.vTN = false;
    this.tfq = new ArrayList();
    this.vTO = new ArrayList();
    this.vTP = 0;
    this.vTQ = 0;
    this.vTS = false;
    this.vTT = false;
    this.vTU = false;
    this.vTV = true;
    this.vTW = false;
    this.vTX = 12;
    this.vUa = false;
    this.eiK = null;
    this.vUb = true;
    this.vUc = true;
    this.vUd = false;
    this.mContext = paramContext;
    this.eht = false;
    this.vTZ = paramContext.getResources().getDimensionPixelSize(2131427496);
    AppMethodBeat.o(79744);
  }
  
  private void LZ(int paramInt)
  {
    AppMethodBeat.i(79751);
    if (paramInt < this.vTQ)
    {
      this.eht = true;
      djN();
    }
    AppMethodBeat.o(79751);
  }
  
  private void djN()
  {
    AppMethodBeat.i(79752);
    if (this.vTK != null) {
      this.vTK.djN();
    }
    AppMethodBeat.o(79752);
  }
  
  private void dnC()
  {
    AppMethodBeat.i(79745);
    if ((this.muT) && (p.a.vUq != null)) {
      this.eiK = p.a.vUq.amk(this.username);
    }
    AppMethodBeat.o(79745);
  }
  
  private void dnE()
  {
    AppMethodBeat.i(79749);
    if (this.vTL == null)
    {
      AppMethodBeat.o(79749);
      return;
    }
    ab.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[] { Integer.valueOf(this.vTL.size()) });
    this.tfq.clear();
    if (this.vTL.size() > 0)
    {
      Iterator localIterator = this.vTL.iterator();
      while (localIterator.hasNext())
      {
        ad localad = (ad)localIterator.next();
        this.tfq.add(localad);
      }
    }
    this.vTQ = this.tfq.size();
    AppMethodBeat.o(79749);
  }
  
  private j.c eD(View paramView)
  {
    AppMethodBeat.i(79753);
    j.c localc = new j.c(this);
    localc.vUg = ((ImageView)paramView.findViewById(2131822800));
    localc.egq = ((ImageView)paramView.findViewById(2131827385));
    localc.qKC = ((ImageView)paramView.findViewById(2131827386));
    localc.egr = ((TextView)paramView.findViewById(2131827389));
    localc.eiM = ((TextView)paramView.findViewById(2131827390));
    localc.eiN = ((TextView)paramView.findViewById(2131827391));
    localc.jfv = ((ImageView)paramView.findViewById(2131827387));
    localc.egq.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.setTag(localc);
    AppMethodBeat.o(79753);
    return localc;
  }
  
  public final void Kc()
  {
    AppMethodBeat.i(79748);
    if ((this.cAs == null) && (this.vTL == null))
    {
      AppMethodBeat.o(79748);
      return;
    }
    int i;
    if (this.vTV) {
      if (this.cAs != null)
      {
        ab.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[] { Integer.valueOf(this.cAs.size()) });
        this.tfq.clear();
        this.vTO.clear();
        Object localObject1 = new LinkedList();
        if (this.cAs.size() > 0)
        {
          Object localObject2 = this.cAs.iterator();
          i = 1;
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if (this.muT)
            {
              this.vTO.add(p.a.vUq.amj(str));
            }
            else
            {
              ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(str);
              if ((this.efi != null) && (str.equals(this.efi.field_roomowner)))
              {
                ((LinkedList)localObject1).add(new j.b(this, localad, 0));
              }
              else if ((this.efi != null) && (this.efi.aqW(localad.field_username)))
              {
                ((LinkedList)localObject1).add(new j.b(this, localad, i));
                i += 1;
              }
              else
              {
                ((LinkedList)localObject1).add(new j.b(this, localad, 100));
              }
            }
          }
          if (this.vUb) {
            Collections.sort((List)localObject1, new j.1(this));
          }
          if (!this.muT)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (j.b)((Iterator)localObject1).next();
              this.tfq.add((ad)((j.b)localObject2).vUf);
            }
          }
        }
        if (this.muT) {
          this.vTQ = this.vTO.size();
        }
      }
      else
      {
        if (this.vTQ != 0) {
          break label581;
        }
        this.vTP = vTJ;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.vTQ + " realySize : " + this.vTP);
      djN();
      AppMethodBeat.o(79748);
      return;
      if (this.czb)
      {
        if ((this.efi != null) && (!this.efi.JP()))
        {
          if (this.tfq.size() >= MAX_COUNT) {}
          for (i = MAX_COUNT;; i = this.tfq.size())
          {
            this.vTQ = i;
            break;
          }
        }
        if (this.tfq.size() >= MAX_COUNT - 1) {}
        for (i = MAX_COUNT - 1;; i = this.tfq.size())
        {
          this.vTQ = i;
          break;
        }
      }
      this.vTQ = this.tfq.size();
      break;
      dnE();
      break;
      label581:
      if ((this.vTT) && (this.vTS) && (this.vTU)) {
        this.vTP = (((this.vTQ + 2) / vTJ + 1) * vTJ);
      } else if (((this.vTT) && (this.vTS) && (!this.vTU)) || ((this.vTT) && (!this.vTS) && (this.vTU)) || ((!this.vTT) && (this.vTS) && (this.vTU))) {
        this.vTP = (((this.vTQ + 1) / vTJ + 1) * vTJ);
      } else if (((this.vTT) && (!this.vTS) && (!this.vTU)) || ((!this.vTT) && (this.vTS) && (!this.vTU)) || ((!this.vTT) && (!this.vTS) && (this.vTU))) {
        this.vTP = ((this.vTQ / vTJ + 1) * vTJ);
      } else if ((!this.vTT) && (!this.vTS) && (!this.vTU)) {
        this.vTP = (((this.vTQ - 1) / vTJ + 1) * vTJ);
      }
    }
  }
  
  public final boolean LY(int paramInt)
  {
    AppMethodBeat.i(79750);
    if (!this.eht)
    {
      LZ(paramInt);
      AppMethodBeat.o(79750);
      return true;
    }
    AppMethodBeat.o(79750);
    return false;
  }
  
  public final boolean Ma(int paramInt)
  {
    return paramInt < this.vTQ;
  }
  
  public final void ai(ArrayList<ad> paramArrayList)
  {
    this.vTV = false;
    this.vTL = paramArrayList;
  }
  
  public final void cg(List<String> paramList)
  {
    AppMethodBeat.i(79756);
    dj(paramList);
    Kc();
    AppMethodBeat.o(79756);
  }
  
  public final void dj(List<String> paramList)
  {
    this.vTV = true;
    this.cAs = paramList;
  }
  
  public final boolean dnD()
  {
    AppMethodBeat.i(79747);
    if (this.muT)
    {
      bool = this.vTN;
      AppMethodBeat.o(79747);
      return bool;
    }
    boolean bool = t.lA(this.username);
    AppMethodBeat.o(79747);
    return bool;
  }
  
  public final void dnF()
  {
    AppMethodBeat.i(79755);
    this.eht = false;
    Kc();
    AppMethodBeat.o(79755);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(79757);
    if (this.vTW)
    {
      i = Math.min(this.vTX, this.vTP);
      AppMethodBeat.o(79757);
      return i;
    }
    int i = this.vTP;
    AppMethodBeat.o(79757);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(79758);
    if (paramInt < this.vTQ)
    {
      if (this.muT)
      {
        localObject = this.vTO.get(paramInt);
        AppMethodBeat.o(79758);
        return localObject;
      }
      Object localObject = this.tfq.get(paramInt);
      AppMethodBeat.o(79758);
      return localObject;
    }
    AppMethodBeat.o(79758);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(79754);
    ad localad;
    int i;
    if (paramInt < this.vTQ) {
      if (this.muT)
      {
        paramViewGroup = getItem(paramInt);
        localad = null;
        i = 0;
      }
    }
    for (;;)
    {
      View localView;
      j.c localc;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, 2130970591, null);
        localc = eD(localView);
      }
      label257:
      label280:
      label1179:
      for (;;)
      {
        label58:
        int j;
        if ((vTJ == 4) || (this.vUd))
        {
          j = this.mContext.getResources().getDimensionPixelSize(2131427802);
          localc.egq.getLayoutParams().height = j;
          localc.egq.getLayoutParams().width = j;
          label113:
          localc.vUg.setVisibility(8);
          localc.eiN.setVisibility(8);
          if (i != 0) {
            break label927;
          }
          localc.egq.setVisibility(0);
          if (!this.czb) {
            break label660;
          }
          if (bo.isNullOrNil(localad.field_conRemark)) {
            break label630;
          }
          paramView = localad.field_conRemark;
          label171:
          Object localObject = paramView;
          if (bo.isNullOrNil(paramView)) {
            localObject = localad.field_conRemark;
          }
          paramView = (View)localObject;
          if (bo.isNullOrNil((String)localObject)) {
            paramView = localad.Oe();
          }
          paramView = com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, paramView, localc.egr.getTextSize());
          label222:
          if (!(paramView instanceof SpannableString)) {
            break label765;
          }
          localc.egr.setVisibility(8);
          localc.eiM.setVisibility(0);
          localc.eiM.setText(paramView);
          paramView = com.tencent.mm.openim.room.a.a.A(localad);
          if (!TextUtils.isEmpty(paramView)) {
            break label796;
          }
          localc.eiN.setVisibility(8);
          localc.egq.setContentDescription("");
          if (!this.muT) {
            break label817;
          }
          o.ahG().a(p.a.vUq.co(paramViewGroup), localc.egq, this.eiK);
          localc.egq.setBackgroundDrawable(null);
          label331:
          if (!this.muT) {
            break label873;
          }
          if ((!this.eht) || ((this.vTY != null) && (this.vTY.equals(p.a.vUq.cp(paramViewGroup))))) {
            break label860;
          }
          localc.qKC.setVisibility(0);
        }
        label796:
        label817:
        label947:
        label1107:
        for (;;)
        {
          if ((!this.muT) || (paramViewGroup == null)) {
            localc.jfv.setVisibility(8);
          }
          localc.kwo = i;
          AppMethodBeat.o(79754);
          return localView;
          localad = (ad)getItem(paramInt);
          paramViewGroup = null;
          i = 0;
          break;
          if ((paramInt == this.vTQ) && (this.vTT))
          {
            paramViewGroup = null;
            localad = null;
            i = 3;
            break;
          }
          if ((paramInt == this.vTQ + 1) && (this.vTS))
          {
            paramViewGroup = null;
            localad = null;
            i = 4;
            break;
          }
          if ((paramInt == this.vTQ + 1) && (this.vTU) && (!this.vTS))
          {
            paramViewGroup = null;
            localad = null;
            i = 5;
            break;
          }
          if ((paramInt != this.vTQ + 2) || (!this.vTU) || (!this.vTS)) {
            break label1512;
          }
          paramViewGroup = null;
          localad = null;
          i = 5;
          break;
          localc = (j.c)paramView.getTag();
          if (localc != null) {
            break label1506;
          }
          localc = eD(paramView);
          localView = paramView;
          break label58;
          j = this.mContext.getResources().getDimensionPixelSize(2131427800);
          localc.egq.getLayoutParams().height = j;
          localc.egq.getLayoutParams().width = j;
          break label113;
          label630:
          paramView = localad.field_username;
          if (this.efi == null)
          {
            paramView = null;
            break label171;
          }
          paramView = this.efi.nE(paramView);
          break label171;
          if (this.muT)
          {
            paramView = com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, p.a.vUq.cn(paramViewGroup), localc.egr.getTextSize());
            break label222;
          }
          if (ad.arf(localad.field_username))
          {
            paramView = ((b)g.E(b.class)).e(ah.getContext(), localad.Of(), (int)localc.egr.getTextSize());
            break label222;
          }
          paramView = com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, localad.Of(), localc.egr.getTextSize());
          break label222;
          label765:
          localc.egr.setVisibility(0);
          localc.eiM.setVisibility(8);
          localc.egr.setText(paramView);
          break label257;
          localc.eiN.setVisibility(0);
          localc.eiN.setText(paramView);
          break label280;
          a.b.c(localc.egq, localad.field_username);
          paramView = (com.tencent.mm.pluginsdk.ui.a)localc.egq.getDrawable();
          if (this.vTR == null) {
            break label331;
          }
          this.vTR.a(paramView);
          break label331;
          label860:
          localc.qKC.setVisibility(8);
          continue;
          label873:
          if ((this.eht) && ((this.vTY == null) || (!this.vTY.equals(localad.field_username))))
          {
            localc.qKC.setVisibility(0);
          }
          else
          {
            localc.qKC.setVisibility(8);
            continue;
            if (i == 3)
            {
              paramView = localc.egr;
              if (paramInt == 0)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.eiM;
                if (paramInt != 0) {
                  break label1006;
                }
              }
              label1006:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.qKC.setVisibility(8);
                if (!this.eht) {
                  break label1011;
                }
                localc.egq.setVisibility(4);
                break;
                j = 4;
                break label947;
              }
              label1011:
              localc.egq.setVisibility(0);
              if (this.muT)
              {
                o.ahG().a("", localc.egq, this.eiK);
                localc.egq.setBackgroundDrawable(null);
              }
              localc.egq.setImageResource(2130837890);
              localc.egq.setContentDescription(this.mContext.getString(2131296428));
            }
            else if (i == 4)
            {
              paramView = localc.egr;
              if (1 == paramInt)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.eiM;
                if (1 != paramInt) {
                  break label1174;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.qKC.setVisibility(8);
                if ((!this.eht) && (this.vTQ != 0)) {
                  break label1179;
                }
                localc.egq.setVisibility(4);
                break;
                j = 4;
                break label1107;
              }
              localc.egq.setVisibility(0);
              if (this.muT)
              {
                o.ahG().a("", localc.egq, this.eiK);
                localc.egq.setBackgroundDrawable(null);
              }
              localc.egq.setImageResource(2130837891);
              localc.egq.setContentDescription(this.mContext.getString(2131298943));
            }
            else if (i == 5)
            {
              paramView = localc.egr;
              if (paramInt == 0)
              {
                j = 8;
                label1274:
                paramView.setVisibility(j);
                paramView = localc.eiM;
                if (paramInt != 0) {
                  break label1333;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.qKC.setVisibility(8);
                if (!this.eht) {
                  break label1338;
                }
                localc.egq.setVisibility(4);
                break;
                j = 4;
                break label1274;
              }
              localc.egq.setVisibility(0);
              if (this.muT)
              {
                o.ahG().a("", localc.egq, this.eiK);
                localc.egq.setBackgroundDrawable(null);
              }
              localc.egq.setImageResource(2130837892);
              localc.egq.setContentDescription(this.mContext.getString(2131301627));
            }
            else if (i == 2)
            {
              if (this.muT) {
                o.ahG().a("", localc.egq, this.eiK);
              }
              localc.egr.setVisibility(4);
              localc.eiM.setVisibility(4);
              localc.qKC.setVisibility(8);
              localc.egq.setVisibility(4);
              localc.egq.setImageResource(2130839676);
              localc.egq.setBackgroundResource(2130839676);
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
      localad = null;
      i = 2;
    }
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(79746);
    this.username = paramString;
    this.czb = t.lA(paramString);
    if ((!this.czb) && (p.a.vUq != null)) {
      this.muT = p.a.vUq.ami(paramString);
    }
    if (!this.muT) {
      this.efi = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(paramString);
    }
    dnC();
    AppMethodBeat.o(79746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.j
 * JD-Core Version:    0.7.0.1
 */