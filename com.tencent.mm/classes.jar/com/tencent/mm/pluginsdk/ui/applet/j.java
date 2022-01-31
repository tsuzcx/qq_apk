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
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public static int scD = 44;
  public static int scE = 5;
  boolean bRz;
  private List<String> bSN = new ArrayList();
  u dnL;
  boolean dpW;
  c drd = null;
  boolean kax = false;
  private Context mContext;
  j.a scF;
  private ArrayList<ad> scG = new ArrayList();
  public boolean scH = false;
  public boolean scI = false;
  private List<ad> scJ = new ArrayList();
  private List<Object> scK = new ArrayList();
  int scL = 0;
  int scM = 0;
  d scN;
  public boolean scO = false;
  public boolean scP = false;
  public boolean scQ = false;
  private boolean scR = true;
  boolean scS = false;
  int scT = 12;
  String scU;
  private final int scV;
  public boolean scW = false;
  private boolean scX = true;
  boolean scY = true;
  public boolean scZ = false;
  String username;
  
  public j(Context paramContext)
  {
    this.mContext = paramContext;
    this.dpW = false;
    this.scV = paramContext.getResources().getDimensionPixelSize(a.c.BasicPaddingSize);
  }
  
  private void cjm()
  {
    if (this.scF != null) {
      this.scF.cjm();
    }
  }
  
  private void cmM()
  {
    if (this.scG == null) {
      return;
    }
    y.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[] { Integer.valueOf(this.scG.size()) });
    this.scJ.clear();
    if (this.scG.size() > 0)
    {
      Iterator localIterator = this.scG.iterator();
      while (localIterator.hasNext())
      {
        ad localad = (ad)localIterator.next();
        this.scJ.add(localad);
      }
    }
    this.scM = this.scJ.size();
  }
  
  private j.c dx(View paramView)
  {
    j.c localc = new j.c(this);
    localc.sdd = ((ImageView)paramView.findViewById(a.e.room_info_contact_owner));
    localc.doU = ((ImageView)paramView.findViewById(a.e.roominfo_img));
    localc.nWs = ((ImageView)paramView.findViewById(a.e.room_info_contact_del));
    localc.doV = ((TextView)paramView.findViewById(a.e.roominfo_contact_name));
    localc.drf = ((TextView)paramView.findViewById(a.e.roominfo_contact_name_for_span));
    localc.sdc = ((TextView)paramView.findViewById(a.e.roominfo_contact_sub_detail));
    localc.hqD = ((ImageView)paramView.findViewById(a.e.room_info_contact_status));
    localc.doU.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.setTag(localc);
    return localc;
  }
  
  public final boolean Eb(int paramInt)
  {
    if (!this.dpW)
    {
      if (paramInt < this.scM)
      {
        this.dpW = true;
        cjm();
      }
      return true;
    }
    return false;
  }
  
  public final boolean Ec(int paramInt)
  {
    return paramInt < this.scM;
  }
  
  public final void ab(ArrayList<ad> paramArrayList)
  {
    this.scR = false;
    this.scG = paramArrayList;
  }
  
  public final void cD(List<String> paramList)
  {
    this.scR = true;
    this.bSN = paramList;
  }
  
  public final boolean cmL()
  {
    if (this.kax) {
      return this.scI;
    }
    return s.fn(this.username);
  }
  
  public final int getCount()
  {
    if (this.scS) {
      return Math.min(this.scT, this.scL);
    }
    return this.scL;
  }
  
  public final Object getItem(int paramInt)
  {
    if (paramInt < this.scM)
    {
      if (this.kax) {
        return this.scK.get(paramInt);
      }
      return this.scJ.get(paramInt);
    }
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ad localad;
    int i;
    if (paramInt < this.scM) {
      if (this.kax)
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
        localView = View.inflate(this.mContext, a.f.roominfo_contact, null);
        localc = dx(localView);
      }
      label274:
      label1179:
      label1184:
      for (;;)
      {
        label52:
        int j;
        label107:
        Object localObject;
        if ((scE == 4) || (this.scZ))
        {
          j = this.mContext.getResources().getDimensionPixelSize(a.c.NormalAvatarWrapSize);
          localc.doU.getLayoutParams().height = j;
          localc.doU.getLayoutParams().width = j;
          localc.sdd.setVisibility(8);
          localc.sdc.setVisibility(8);
          if (i != 0) {
            break label932;
          }
          localc.doU.setVisibility(0);
          if (!this.bRz) {
            break label648;
          }
          if (bk.bl(localad.field_conRemark)) {
            break label618;
          }
          paramView = localad.field_conRemark;
          label165:
          localObject = paramView;
          if (bk.bl(paramView)) {
            localObject = localad.field_conRemark;
          }
          paramView = (View)localObject;
          if (bk.bl((String)localObject)) {
            paramView = localad.Bp();
          }
          paramView = com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, paramView, localc.doV.getTextSize());
          label216:
          if (!(paramView instanceof SpannableString)) {
            break label770;
          }
          localc.doV.setVisibility(8);
          localc.drf.setVisibility(0);
          localc.drf.setText(paramView);
          label251:
          paramView = com.tencent.mm.openim.room.a.a.z(localad);
          if (!TextUtils.isEmpty(paramView)) {
            break label801;
          }
          localc.sdc.setVisibility(8);
          localc.doU.setContentDescription("");
          if (!this.kax) {
            break label822;
          }
          o.ON().a(p.a.sdn.bK(paramViewGroup), localc.doU, this.drd);
          localc.doU.setBackgroundDrawable(null);
          label325:
          if (!this.kax) {
            break label878;
          }
          if ((!this.dpW) || ((this.scU != null) && (this.scU.equals(p.a.sdn.bL(paramViewGroup))))) {
            break label865;
          }
          localc.nWs.setVisibility(0);
        }
        label801:
        label822:
        label952:
        label1112:
        for (;;)
        {
          if ((!this.kax) || (paramViewGroup == null)) {
            localc.hqD.setVisibility(8);
          }
          localc.ivk = i;
          return localView;
          localad = (ad)getItem(paramInt);
          paramViewGroup = null;
          i = 0;
          break;
          if ((paramInt == this.scM) && (this.scP))
          {
            paramViewGroup = null;
            localad = null;
            i = 3;
            break;
          }
          if ((paramInt == this.scM + 1) && (this.scO))
          {
            paramViewGroup = null;
            localad = null;
            i = 4;
            break;
          }
          if ((paramInt == this.scM + 1) && (this.scQ) && (!this.scO))
          {
            paramViewGroup = null;
            localad = null;
            i = 5;
            break;
          }
          if ((paramInt != this.scM + 2) || (!this.scQ) || (!this.scO)) {
            break label1517;
          }
          paramViewGroup = null;
          localad = null;
          i = 5;
          break;
          localc = (j.c)paramView.getTag();
          if (localc != null) {
            break label1511;
          }
          localc = dx(paramView);
          localView = paramView;
          break label52;
          j = this.mContext.getResources().getDimensionPixelSize(a.c.NormalAvatarSize);
          localc.doU.getLayoutParams().height = j;
          localc.doU.getLayoutParams().width = j;
          break label107;
          label618:
          paramView = localad.field_username;
          if (this.dnL == null)
          {
            paramView = null;
            break label165;
          }
          paramView = this.dnL.gV(paramView);
          break label165;
          if (this.kax)
          {
            paramView = com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, p.a.sdn.bJ(paramViewGroup), localc.doV.getTextSize());
            break label216;
          }
          if (ad.aaU(localad.field_username))
          {
            paramView = (b)g.r(b.class);
            localObject = ae.getContext();
            String str1 = localad.Bq();
            String str2 = localad.field_openImAppid;
            paramView = paramView.d((Context)localObject, str1, (int)localc.doV.getTextSize());
            break label216;
          }
          paramView = com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, localad.Bq(), localc.doV.getTextSize());
          break label216;
          localc.doV.setVisibility(0);
          localc.drf.setVisibility(8);
          localc.doV.setText(paramView);
          break label251;
          localc.sdc.setVisibility(0);
          localc.sdc.setText(paramView);
          break label274;
          a.b.a(localc.doU, localad.field_username);
          paramView = (com.tencent.mm.pluginsdk.ui.a)localc.doU.getDrawable();
          if (this.scN == null) {
            break label325;
          }
          this.scN.a(paramView);
          break label325;
          label865:
          localc.nWs.setVisibility(8);
          continue;
          label878:
          if ((this.dpW) && ((this.scU == null) || (!this.scU.equals(localad.field_username))))
          {
            localc.nWs.setVisibility(0);
          }
          else
          {
            localc.nWs.setVisibility(8);
            continue;
            if (i == 3)
            {
              paramView = localc.doV;
              if (paramInt == 0)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.drf;
                if (paramInt != 0) {
                  break label1011;
                }
              }
              label1011:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.nWs.setVisibility(8);
                if (!this.dpW) {
                  break label1016;
                }
                localc.doU.setVisibility(4);
                break;
                j = 4;
                break label952;
              }
              label1016:
              localc.doU.setVisibility(0);
              if (this.kax)
              {
                o.ON().a("", localc.doU, this.drd);
                localc.doU.setBackgroundDrawable(null);
              }
              localc.doU.setImageResource(a.d.big_add_selector);
              localc.doU.setContentDescription(this.mContext.getString(a.h.add_selector_btn));
            }
            else if (i == 4)
            {
              paramView = localc.doV;
              if (1 == paramInt)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.drf;
                if (1 != paramInt) {
                  break label1179;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.nWs.setVisibility(8);
                if ((!this.dpW) && (this.scM != 0)) {
                  break label1184;
                }
                localc.doU.setVisibility(4);
                break;
                j = 4;
                break label1112;
              }
              localc.doU.setVisibility(0);
              if (this.kax)
              {
                o.ON().a("", localc.doU, this.drd);
                localc.doU.setBackgroundDrawable(null);
              }
              localc.doU.setImageResource(a.d.big_del_selector);
              localc.doU.setContentDescription(this.mContext.getString(a.h.del_selector_btn));
            }
            else if (i == 5)
            {
              paramView = localc.doV;
              if (paramInt == 0)
              {
                j = 8;
                label1279:
                paramView.setVisibility(j);
                paramView = localc.drf;
                if (paramInt != 0) {
                  break label1338;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.nWs.setVisibility(8);
                if (!this.dpW) {
                  break label1343;
                }
                localc.doU.setVisibility(4);
                break;
                j = 4;
                break label1279;
              }
              localc.doU.setVisibility(0);
              if (this.kax)
              {
                o.ON().a("", localc.doU, this.drd);
                localc.doU.setBackgroundDrawable(null);
              }
              localc.doU.setImageResource(a.d.big_more_selector);
              localc.doU.setContentDescription(this.mContext.getString(a.h.more_selector_btn));
            }
            else if (i == 2)
            {
              if (this.kax) {
                o.ON().a("", localc.doU, this.drd);
              }
              localc.doV.setVisibility(4);
              localc.drf.setVisibility(4);
              localc.nWs.setVisibility(8);
              localc.doU.setVisibility(4);
              localc.doU.setImageResource(a.d.mm_trans);
              localc.doU.setBackgroundResource(a.d.mm_trans);
            }
          }
        }
        label932:
        label1338:
        label1343:
        label1511:
        localView = paramView;
      }
      label648:
      label1517:
      paramViewGroup = null;
      label770:
      localad = null;
      i = 2;
    }
  }
  
  public final void notifyChanged()
  {
    int i;
    if ((this.bSN != null) || (this.scG != null))
    {
      if (!this.scR) {
        break label555;
      }
      if (this.bSN != null)
      {
        y.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[] { Integer.valueOf(this.bSN.size()) });
        this.scJ.clear();
        this.scK.clear();
        Object localObject1 = new LinkedList();
        if (this.bSN.size() > 0)
        {
          Object localObject2 = this.bSN.iterator();
          i = 1;
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if (this.kax)
            {
              this.scK.add(p.a.sdn.WD(str));
            }
            else
            {
              ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str);
              if ((this.dnL != null) && (str.equals(this.dnL.field_roomowner)))
              {
                ((LinkedList)localObject1).add(new j.b(this, localad, 0));
              }
              else if ((this.dnL != null) && (this.dnL.aaM(localad.field_username)))
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
          if (this.scX) {
            Collections.sort((List)localObject1, new j.1(this));
          }
          if (!this.kax)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (j.b)((Iterator)localObject1).next();
              this.scJ.add((ad)((j.b)localObject2).sdb);
            }
          }
        }
        if (!this.kax) {
          break label431;
        }
        this.scM = this.scK.size();
      }
      if (this.scM != 0) {
        break label562;
      }
      this.scL = scE;
    }
    for (;;)
    {
      y.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.scM + " realySize : " + this.scL);
      cjm();
      return;
      label431:
      if (this.bRz)
      {
        if ((this.dnL != null) && (!this.dnL.xw()))
        {
          if (this.scJ.size() >= scD) {}
          for (i = scD;; i = this.scJ.size())
          {
            this.scM = i;
            break;
          }
        }
        if (this.scJ.size() >= scD - 1) {}
        for (i = scD - 1;; i = this.scJ.size())
        {
          this.scM = i;
          break;
        }
      }
      this.scM = this.scJ.size();
      break;
      label555:
      cmM();
      break;
      label562:
      if ((this.scP) && (this.scO) && (this.scQ)) {
        this.scL = (((this.scM + 2) / scE + 1) * scE);
      } else if (((this.scP) && (this.scO) && (!this.scQ)) || ((this.scP) && (!this.scO) && (this.scQ)) || ((!this.scP) && (this.scO) && (this.scQ))) {
        this.scL = (((this.scM + 1) / scE + 1) * scE);
      } else if (((this.scP) && (!this.scO) && (!this.scQ)) || ((!this.scP) && (this.scO) && (!this.scQ)) || ((!this.scP) && (!this.scO) && (this.scQ))) {
        this.scL = ((this.scM / scE + 1) * scE);
      } else if ((!this.scP) && (!this.scO) && (!this.scQ)) {
        this.scL = (((this.scM - 1) / scE + 1) * scE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.j
 * JD-Core Version:    0.7.0.1
 */