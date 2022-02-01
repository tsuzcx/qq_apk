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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.a.a.a;
import com.tencent.mm.pluginsdk.a.a.c;
import com.tencent.mm.pluginsdk.a.a.d;
import com.tencent.mm.pluginsdk.a.a.e;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  public static int MAX_COUNT = 19;
  public static int Yco = 5;
  boolean Aet;
  private List<au> TJa;
  private boolean YcA;
  boolean YcB;
  int YcC;
  String YcD;
  private final int YcE;
  public boolean YcF;
  private boolean YcG;
  boolean YcH;
  public boolean YcI;
  a Ycp;
  private ArrayList<au> Ycq;
  public boolean Ycr;
  public boolean Ycs;
  private List<Object> Yct;
  int Ycu;
  int Ycv;
  com.tencent.mm.pluginsdk.ui.e Ycw;
  public boolean Ycx;
  public boolean Ycy;
  public boolean Ycz;
  private boolean hQu;
  private List<String> hSb;
  boolean lKI;
  private c lMm;
  aj lzy;
  private Context mContext;
  private String username;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(152192);
    this.hSb = new ArrayList();
    this.Ycq = new ArrayList();
    this.Aet = false;
    this.Ycr = false;
    this.Ycs = false;
    this.TJa = new ArrayList();
    this.Yct = new ArrayList();
    this.Ycu = 0;
    this.Ycv = 0;
    this.Ycx = false;
    this.Ycy = false;
    this.Ycz = false;
    this.YcA = true;
    this.YcB = false;
    this.YcC = 12;
    this.YcF = false;
    this.lMm = null;
    this.YcG = true;
    this.YcH = true;
    this.YcI = false;
    this.mContext = paramContext;
    this.lKI = false;
    this.YcE = paramContext.getResources().getDimensionPixelSize(a.a.BasicPaddingSize);
    AppMethodBeat.o(152192);
  }
  
  private void aws(int paramInt)
  {
    AppMethodBeat.i(152199);
    if (paramInt < this.Ycv)
    {
      this.lKI = true;
      dvs();
    }
    AppMethodBeat.o(152199);
  }
  
  private void dvs()
  {
    AppMethodBeat.i(152200);
    if (this.Ycp != null) {
      this.Ycp.dvs();
    }
    AppMethodBeat.o(152200);
  }
  
  private void iLq()
  {
    AppMethodBeat.i(152193);
    if ((this.Aet) && (x.a.YcW != null)) {
      this.lMm = x.a.YcW.bqQ(this.username);
    }
    AppMethodBeat.o(152193);
  }
  
  private void iLs()
  {
    AppMethodBeat.i(152197);
    if (this.Ycq == null)
    {
      AppMethodBeat.o(152197);
      return;
    }
    Log.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[] { Integer.valueOf(this.Ycq.size()) });
    this.TJa.clear();
    if (this.Ycq.size() > 0)
    {
      Iterator localIterator = this.Ycq.iterator();
      while (localIterator.hasNext())
      {
        au localau = (au)localIterator.next();
        this.TJa.add(localau);
      }
    }
    this.Ycv = this.TJa.size();
    AppMethodBeat.o(152197);
  }
  
  private c kM(View paramView)
  {
    AppMethodBeat.i(152201);
    c localc = new c();
    localc.YcL = ((ImageView)paramView.findViewById(a.c.room_info_contact_owner));
    localc.lMM = ((AvatarPatTipImageView)paramView.findViewById(a.c.roominfo_img));
    localc.PwH = ((ImageView)paramView.findViewById(a.c.room_info_contact_del));
    localc.lBD = ((TextView)paramView.findViewById(a.c.roominfo_contact_name));
    localc.lKP = ((TextView)paramView.findViewById(a.c.roominfo_contact_name_for_span));
    localc.lMo = ((TextView)paramView.findViewById(a.c.roominfo_contact_sub_detail));
    localc.uAw = ((ImageView)paramView.findViewById(a.c.room_info_contact_status));
    localc.lMM.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.setTag(localc);
    AppMethodBeat.o(152201);
    return localc;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(152196);
    if ((this.hSb == null) && (this.Ycq == null))
    {
      AppMethodBeat.o(152196);
      return;
    }
    int i;
    if (this.YcA) {
      if (this.hSb != null)
      {
        Log.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[] { Integer.valueOf(this.hSb.size()) });
        this.TJa.clear();
        this.Yct.clear();
        Object localObject1 = new LinkedList();
        if (this.hSb.size() > 0)
        {
          Object localObject2 = this.hSb.iterator();
          i = 1;
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if (this.Aet)
            {
              this.Yct.add(x.a.YcW.bqP(str));
            }
            else
            {
              au localau = ((n)h.ax(n.class)).bzA().JE(str);
              if ((this.lzy != null) && (str.equals(this.lzy.field_roomowner)))
              {
                ((LinkedList)localObject1).add(new b(localau, 0));
              }
              else if ((this.lzy != null) && (this.lzy.bvK(localau.field_username)))
              {
                ((LinkedList)localObject1).add(new b(localau, i));
                i += 1;
              }
              else
              {
                ((LinkedList)localObject1).add(new b(localau, 100));
              }
            }
          }
          if (this.YcG) {
            Collections.sort((List)localObject1, new Comparator() {});
          }
          if (!this.Aet)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b)((Iterator)localObject1).next();
              this.TJa.add((au)((b)localObject2).YcK);
            }
          }
        }
        if (this.Aet) {
          this.Ycv = this.Yct.size();
        }
      }
      else
      {
        if (this.Ycv != 0) {
          break label581;
        }
        this.Ycu = Yco;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.Ycv + " realySize : " + this.Ycu);
      dvs();
      AppMethodBeat.o(152196);
      return;
      if (this.hQu)
      {
        if ((this.lzy != null) && (!this.lzy.aMF()))
        {
          if (this.TJa.size() >= MAX_COUNT) {}
          for (i = MAX_COUNT;; i = this.TJa.size())
          {
            this.Ycv = i;
            break;
          }
        }
        if (this.TJa.size() >= MAX_COUNT - 1) {}
        for (i = MAX_COUNT - 1;; i = this.TJa.size())
        {
          this.Ycv = i;
          break;
        }
      }
      this.Ycv = this.TJa.size();
      break;
      iLs();
      break;
      label581:
      if ((this.Ycy) && (this.Ycx) && (this.Ycz)) {
        this.Ycu = (((this.Ycv + 2) / Yco + 1) * Yco);
      } else if (((this.Ycy) && (this.Ycx) && (!this.Ycz)) || ((this.Ycy) && (!this.Ycx) && (this.Ycz)) || ((!this.Ycy) && (this.Ycx) && (this.Ycz))) {
        this.Ycu = (((this.Ycv + 1) / Yco + 1) * Yco);
      } else if (((this.Ycy) && (!this.Ycx) && (!this.Ycz)) || ((!this.Ycy) && (this.Ycx) && (!this.Ycz)) || ((!this.Ycy) && (!this.Ycx) && (this.Ycz))) {
        this.Ycu = ((this.Ycv / Yco + 1) * Yco);
      } else if ((!this.Ycy) && (!this.Ycx) && (!this.Ycz)) {
        this.Ycu = (((this.Ycv - 1) / Yco + 1) * Yco);
      }
    }
  }
  
  public final boolean awr(int paramInt)
  {
    AppMethodBeat.i(152198);
    if (!this.lKI)
    {
      aws(paramInt);
      AppMethodBeat.o(152198);
      return true;
    }
    AppMethodBeat.o(152198);
    return false;
  }
  
  public final boolean awt(int paramInt)
  {
    return paramInt < this.Ycv;
  }
  
  public final void bX(ArrayList<au> paramArrayList)
  {
    this.YcA = false;
    this.Ycq = paramArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(152205);
    if (this.YcB)
    {
      i = Math.min(this.YcC, this.Ycu);
      AppMethodBeat.o(152205);
      return i;
    }
    int i = this.Ycu;
    AppMethodBeat.o(152205);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152206);
    if (paramInt < this.Ycv)
    {
      if (this.Aet)
      {
        localObject = this.Yct.get(paramInt);
        AppMethodBeat.o(152206);
        return localObject;
      }
      Object localObject = this.TJa.get(paramInt);
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
    au localau = null;
    int i;
    if (paramInt < this.Ycv)
    {
      i = 0;
      if (this.Aet) {
        paramViewGroup = getItem(paramInt);
      }
    }
    for (;;)
    {
      View localView;
      c localc;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, a.d.roominfo_contact, null);
        localc = kM(localView);
      }
      label263:
      label669:
      label805:
      label1577:
      for (;;)
      {
        label58:
        int j;
        if ((Yco == 4) || (this.YcI))
        {
          j = this.mContext.getResources().getDimensionPixelSize(a.a.NormalAvatarWrapSize);
          localc.lMM.getLayoutParams().height = j;
          localc.lMM.getLayoutParams().width = j;
          label113:
          localc.YcL.setVisibility(8);
          localc.lMo.setVisibility(8);
          localView.setImportantForAccessibility(0);
          if (i != 0) {
            break label992;
          }
          localc.lMM.setVisibility(0);
          if (!this.hQu) {
            break label669;
          }
          if (Util.isNullOrNil(localau.field_conRemark)) {
            break label639;
          }
          paramView = localau.field_conRemark;
          label177:
          Object localObject = paramView;
          if (Util.isNullOrNil(paramView)) {
            localObject = localau.field_conRemark;
          }
          paramView = (View)localObject;
          if (Util.isNullOrNil((String)localObject)) {
            paramView = localau.aSU();
          }
          paramView = p.b(this.mContext, paramView, localc.lBD.getTextSize());
          label228:
          if (!(paramView instanceof SpannableString)) {
            break label774;
          }
          localc.lBD.setVisibility(8);
          localc.lKP.setVisibility(0);
          localc.lKP.setText(paramView);
          localObject = com.tencent.mm.openim.room.a.a.X(localau);
          paramView = (View)localObject;
          if (Util.isNullOrNil((CharSequence)localObject)) {
            paramView = com.tencent.mm.openim.room.a.a.Y(localau);
          }
          if (!TextUtils.isEmpty(paramView)) {
            break label805;
          }
          localc.lMo.setVisibility(8);
          label304:
          localc.lMM.setContentDescription("");
          if (!this.Aet) {
            break label826;
          }
          com.tencent.mm.modelimage.r.bKe().a(x.a.YcW.gy(paramViewGroup), localc.lMM, this.lMm);
          localc.lMM.setBackgroundDrawable(null);
          label355:
          if (!this.Aet) {
            break label938;
          }
          if ((!this.lKI) || ((this.YcD != null) && (this.YcD.equals(x.a.YcW.gz(paramViewGroup))))) {
            break label925;
          }
          localc.PwH.setVisibility(0);
        }
        label826:
        label1339:
        for (;;)
        {
          if ((!this.Aet) || (paramViewGroup == null)) {
            localc.uAw.setVisibility(8);
          }
          localc.viewType = i;
          AppMethodBeat.o(152202);
          return localView;
          localau = (au)getItem(paramInt);
          paramViewGroup = null;
          break;
          if ((paramInt == this.Ycv) && (this.Ycy))
          {
            paramViewGroup = null;
            i = 3;
            break;
          }
          if ((paramInt == this.Ycv + 1) && (this.Ycx))
          {
            paramViewGroup = null;
            i = 4;
            break;
          }
          if ((paramInt == this.Ycv + 1) && (this.Ycz) && (!this.Ycx))
          {
            paramViewGroup = null;
            i = 5;
            break;
          }
          if ((paramInt != this.Ycv + 2) || (!this.Ycz) || (!this.Ycx)) {
            break label1583;
          }
          paramViewGroup = null;
          i = 5;
          break;
          localc = (c)paramView.getTag();
          if (localc != null) {
            break label1577;
          }
          localc = kM(paramView);
          localView = paramView;
          break label58;
          j = this.mContext.getResources().getDimensionPixelSize(a.a.NormalAvatarSize);
          localc.lMM.getLayoutParams().height = j;
          localc.lMM.getLayoutParams().width = j;
          break label113;
          label639:
          paramView = localau.field_username;
          if (this.lzy == null)
          {
            paramView = null;
            break label177;
          }
          paramView = this.lzy.getDisplayName(paramView);
          break label177;
          if (this.Aet)
          {
            paramView = p.b(this.mContext, x.a.YcW.gx(paramViewGroup), localc.lBD.getTextSize());
            break label228;
          }
          if (au.bwO(localau.field_username))
          {
            paramView = ((com.tencent.mm.openim.api.e)h.ax(com.tencent.mm.openim.api.e.class)).e(MMApplicationContext.getContext(), localau.aSV(), (int)localc.lBD.getTextSize());
            break label228;
          }
          paramView = p.b(this.mContext, localau.aSV(), localc.lBD.getTextSize());
          break label228;
          localc.lBD.setVisibility(0);
          localc.lKP.setVisibility(8);
          localc.lBD.setText(paramView);
          break label263;
          localc.lMo.setVisibility(0);
          localc.lMo.setText(paramView);
          break label304;
          com.tencent.mm.pluginsdk.ui.a.b.g(localc.lMM, localau.field_username);
          paramView = (com.tencent.mm.pluginsdk.ui.a)localc.lMM.getDrawable();
          if (this.Ycw != null) {
            this.Ycw.a(paramView);
          }
          localc.lMM.setTagUsername(localau.field_username);
          localc.lMM.setTagTalker(this.username);
          if (au.bwG(this.username))
          {
            localc.lMM.setTagScene(4);
            break label355;
          }
          localc.lMM.setTagScene(3);
          break label355;
          localc.PwH.setVisibility(8);
          continue;
          label1239:
          label1244:
          if ((this.lKI) && ((this.YcD == null) || (!this.YcD.equals(localau.field_username))))
          {
            localc.PwH.setVisibility(0);
          }
          else
          {
            localc.PwH.setVisibility(8);
            continue;
            label992:
            if (i == 3)
            {
              paramView = localc.lBD;
              if (paramInt == 0)
              {
                j = 8;
                label1012:
                paramView.setVisibility(j);
                paramView = localc.lKP;
                if (paramInt != 0) {
                  break label1071;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.PwH.setVisibility(8);
                if (!this.lKI) {
                  break label1076;
                }
                localc.lMM.setVisibility(4);
                break;
                j = 4;
                break label1012;
              }
              localc.lMM.setVisibility(0);
              if (this.Aet)
              {
                com.tencent.mm.modelimage.r.bKe().a("", localc.lMM, this.lMm);
                localc.lMM.setBackgroundDrawable(null);
              }
              localc.lMM.setImageResource(com.tencent.mm.pluginsdk.a.a.b.big_add_selector);
              localc.lMM.setContentDescription(this.mContext.getString(a.e.add_selector_btn));
            }
            else if (i == 4)
            {
              paramView = localc.lBD;
              if (1 == paramInt)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.lKP;
                if (1 != paramInt) {
                  break label1239;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.PwH.setVisibility(8);
                if ((!this.lKI) && (this.Ycv != 0)) {
                  break label1244;
                }
                localc.lMM.setVisibility(4);
                break;
                j = 4;
                break label1172;
              }
              localc.lMM.setVisibility(0);
              if (this.Aet)
              {
                com.tencent.mm.modelimage.r.bKe().a("", localc.lMM, this.lMm);
                localc.lMM.setBackgroundDrawable(null);
              }
              localc.lMM.setImageResource(com.tencent.mm.pluginsdk.a.a.b.big_del_selector);
              localc.lMM.setContentDescription(this.mContext.getString(a.e.del_selector_btn));
            }
            else if (i == 5)
            {
              paramView = localc.lBD;
              if (paramInt == 0)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.lKP;
                if (paramInt != 0) {
                  break label1398;
                }
              }
              label1398:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.PwH.setVisibility(8);
                if (!this.lKI) {
                  break label1403;
                }
                localc.lMM.setVisibility(4);
                break;
                j = 4;
                break label1339;
              }
              label1403:
              localc.lMM.setVisibility(0);
              if (this.Aet)
              {
                com.tencent.mm.modelimage.r.bKe().a("", localc.lMM, this.lMm);
                localc.lMM.setBackgroundDrawable(null);
              }
              localc.lMM.setImageResource(com.tencent.mm.pluginsdk.a.a.b.big_more_selector);
              localc.lMM.setContentDescription(this.mContext.getString(a.e.more_selector_btn));
            }
            else if (i == 2)
            {
              if (this.Aet) {
                com.tencent.mm.modelimage.r.bKe().a("", localc.lMM, this.lMm);
              }
              localc.lBD.setVisibility(4);
              localc.lKP.setVisibility(4);
              localc.PwH.setVisibility(8);
              localc.lMM.setVisibility(4);
              localc.lMM.setImageResource(com.tencent.mm.pluginsdk.a.a.b.mm_trans);
              localc.lMM.setBackgroundResource(com.tencent.mm.pluginsdk.a.a.b.mm_trans);
              localView.setImportantForAccessibility(4);
            }
          }
        }
        label938:
        label1071:
        label1076:
        localView = paramView;
      }
      label774:
      label925:
      label1583:
      paramViewGroup = null;
      label1172:
      i = 2;
    }
  }
  
  public final boolean iLr()
  {
    AppMethodBeat.i(152195);
    if (this.Aet)
    {
      bool = this.Ycs;
      AppMethodBeat.o(152195);
      return bool;
    }
    boolean bool = au.bwE(this.username);
    AppMethodBeat.o(152195);
    return bool;
  }
  
  public final void iLt()
  {
    AppMethodBeat.i(152203);
    this.lKI = false;
    aNi();
    AppMethodBeat.o(152203);
  }
  
  public final void iM(List<String> paramList)
  {
    AppMethodBeat.i(152204);
    kG(paramList);
    aNi();
    AppMethodBeat.o(152204);
  }
  
  public final void kG(List<String> paramList)
  {
    this.YcA = true;
    this.hSb = paramList;
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(152194);
    this.username = paramString;
    this.hQu = au.bwE(paramString);
    if ((!this.hQu) && (x.a.YcW != null)) {
      this.Aet = x.a.YcW.bqO(paramString);
    }
    if (!this.Aet) {
      this.lzy = ((b)h.ax(b.class)).bzK().Ju(paramString);
    }
    iLq();
    AppMethodBeat.o(152194);
  }
  
  public static abstract interface a
  {
    public abstract void dvs();
  }
  
  final class b
  {
    public Object YcK;
    public int order;
    
    public b(Object paramObject, int paramInt)
    {
      this.YcK = paramObject;
      this.order = paramInt;
    }
  }
  
  final class c
  {
    public ImageView PwH;
    public ImageView YcL;
    public TextView lBD;
    public TextView lKP;
    public AvatarPatTipImageView lMM;
    public TextView lMo;
    public ImageView uAw;
    public int viewType;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.r
 * JD-Core Version:    0.7.0.1
 */