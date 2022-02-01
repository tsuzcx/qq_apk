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
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.a.a.a;
import com.tencent.mm.pluginsdk.a.a.c;
import com.tencent.mm.pluginsdk.a.a.d;
import com.tencent.mm.pluginsdk.a.a.e;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  public static int Rgl = 5;
  private List<as> MWw;
  String RgA;
  private final int RgB;
  public boolean RgC;
  private boolean RgD;
  boolean RgE;
  public boolean RgF;
  a Rgm;
  private ArrayList<as> Rgn;
  public boolean Rgo;
  public boolean Rgp;
  private List<Object> Rgq;
  int Rgr;
  int Rgs;
  e Rgt;
  public boolean Rgu;
  public boolean Rgv;
  public boolean Rgw;
  private boolean Rgx;
  boolean Rgy;
  int Rgz;
  private boolean fKN;
  private List<String> fMr;
  ah iXp;
  boolean jis;
  private c jjH;
  private Context mContext;
  private String username;
  boolean wIf;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(152192);
    this.fMr = new ArrayList();
    this.Rgn = new ArrayList();
    this.wIf = false;
    this.Rgo = false;
    this.Rgp = false;
    this.MWw = new ArrayList();
    this.Rgq = new ArrayList();
    this.Rgr = 0;
    this.Rgs = 0;
    this.Rgu = false;
    this.Rgv = false;
    this.Rgw = false;
    this.Rgx = true;
    this.Rgy = false;
    this.Rgz = 12;
    this.RgC = false;
    this.jjH = null;
    this.RgD = true;
    this.RgE = true;
    this.RgF = false;
    this.mContext = paramContext;
    this.jis = false;
    this.RgB = paramContext.getResources().getDimensionPixelSize(a.a.BasicPaddingSize);
    AppMethodBeat.o(152192);
  }
  
  private void aqo(int paramInt)
  {
    AppMethodBeat.i(152199);
    if (paramInt < this.Rgs)
    {
      this.jis = true;
      cQZ();
    }
    AppMethodBeat.o(152199);
  }
  
  private void cQZ()
  {
    AppMethodBeat.i(152200);
    if (this.Rgm != null) {
      this.Rgm.cQZ();
    }
    AppMethodBeat.o(152200);
  }
  
  private void hkB()
  {
    AppMethodBeat.i(152197);
    if (this.Rgn == null)
    {
      AppMethodBeat.o(152197);
      return;
    }
    Log.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[] { Integer.valueOf(this.Rgn.size()) });
    this.MWw.clear();
    if (this.Rgn.size() > 0)
    {
      Iterator localIterator = this.Rgn.iterator();
      while (localIterator.hasNext())
      {
        as localas = (as)localIterator.next();
        this.MWw.add(localas);
      }
    }
    this.Rgs = this.MWw.size();
    AppMethodBeat.o(152197);
  }
  
  private void hkz()
  {
    AppMethodBeat.i(152193);
    if ((this.wIf) && (x.a.RgS != null)) {
      this.jjH = x.a.RgS.brc(this.username);
    }
    AppMethodBeat.o(152193);
  }
  
  private c hw(View paramView)
  {
    AppMethodBeat.i(152201);
    c localc = new c();
    localc.RgI = ((ImageView)paramView.findViewById(a.c.room_info_contact_owner));
    localc.jki = ((AvatarPatTipImageView)paramView.findViewById(a.c.roominfo_img));
    localc.Jkg = ((ImageView)paramView.findViewById(a.c.room_info_contact_del));
    localc.iZH = ((TextView)paramView.findViewById(a.c.roominfo_contact_name));
    localc.jjJ = ((TextView)paramView.findViewById(a.c.roominfo_contact_name_for_span));
    localc.jjK = ((TextView)paramView.findViewById(a.c.roominfo_contact_sub_detail));
    localc.rql = ((ImageView)paramView.findViewById(a.c.room_info_contact_status));
    localc.jki.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.setTag(localc);
    AppMethodBeat.o(152201);
    return localc;
  }
  
  public final boolean aqn(int paramInt)
  {
    AppMethodBeat.i(152198);
    if (!this.jis)
    {
      aqo(paramInt);
      AppMethodBeat.o(152198);
      return true;
    }
    AppMethodBeat.o(152198);
    return false;
  }
  
  public final boolean aqp(int paramInt)
  {
    return paramInt < this.Rgs;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(152196);
    if ((this.fMr == null) && (this.Rgn == null))
    {
      AppMethodBeat.o(152196);
      return;
    }
    int i;
    if (this.Rgx) {
      if (this.fMr != null)
      {
        Log.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[] { Integer.valueOf(this.fMr.size()) });
        this.MWw.clear();
        this.Rgq.clear();
        Object localObject1 = new LinkedList();
        if (this.fMr.size() > 0)
        {
          Object localObject2 = this.fMr.iterator();
          i = 1;
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if (this.wIf)
            {
              this.Rgq.add(x.a.RgS.brb(str));
            }
            else
            {
              as localas = ((n)h.ae(n.class)).bbL().RG(str);
              if ((this.iXp != null) && (str.equals(this.iXp.field_roomowner)))
              {
                ((LinkedList)localObject1).add(new b(localas, 0));
              }
              else if ((this.iXp != null) && (this.iXp.bvA(localas.field_username)))
              {
                ((LinkedList)localObject1).add(new b(localas, i));
                i += 1;
              }
              else
              {
                ((LinkedList)localObject1).add(new b(localas, 100));
              }
            }
          }
          if (this.RgD) {
            Collections.sort((List)localObject1, new Comparator() {});
          }
          if (!this.wIf)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b)((Iterator)localObject1).next();
              this.MWw.add((as)((b)localObject2).RgH);
            }
          }
        }
        if (this.wIf) {
          this.Rgs = this.Rgq.size();
        }
      }
      else
      {
        if (this.Rgs != 0) {
          break label581;
        }
        this.Rgr = Rgl;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.Rgs + " realySize : " + this.Rgr);
      cQZ();
      AppMethodBeat.o(152196);
      return;
      if (this.fKN)
      {
        if ((this.iXp != null) && (!this.iXp.asE()))
        {
          if (this.MWw.size() >= MAX_COUNT) {}
          for (i = MAX_COUNT;; i = this.MWw.size())
          {
            this.Rgs = i;
            break;
          }
        }
        if (this.MWw.size() >= MAX_COUNT - 1) {}
        for (i = MAX_COUNT - 1;; i = this.MWw.size())
        {
          this.Rgs = i;
          break;
        }
      }
      this.Rgs = this.MWw.size();
      break;
      hkB();
      break;
      label581:
      if ((this.Rgv) && (this.Rgu) && (this.Rgw)) {
        this.Rgr = (((this.Rgs + 2) / Rgl + 1) * Rgl);
      } else if (((this.Rgv) && (this.Rgu) && (!this.Rgw)) || ((this.Rgv) && (!this.Rgu) && (this.Rgw)) || ((!this.Rgv) && (this.Rgu) && (this.Rgw))) {
        this.Rgr = (((this.Rgs + 1) / Rgl + 1) * Rgl);
      } else if (((this.Rgv) && (!this.Rgu) && (!this.Rgw)) || ((!this.Rgv) && (this.Rgu) && (!this.Rgw)) || ((!this.Rgv) && (!this.Rgu) && (this.Rgw))) {
        this.Rgr = ((this.Rgs / Rgl + 1) * Rgl);
      } else if ((!this.Rgv) && (!this.Rgu) && (!this.Rgw)) {
        this.Rgr = (((this.Rgs - 1) / Rgl + 1) * Rgl);
      }
    }
  }
  
  public final void bw(ArrayList<as> paramArrayList)
  {
    this.Rgx = false;
    this.Rgn = paramArrayList;
  }
  
  public final void fO(List<String> paramList)
  {
    AppMethodBeat.i(152204);
    hF(paramList);
    ata();
    AppMethodBeat.o(152204);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(152205);
    if (this.Rgy)
    {
      i = Math.min(this.Rgz, this.Rgr);
      AppMethodBeat.o(152205);
      return i;
    }
    int i = this.Rgr;
    AppMethodBeat.o(152205);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152206);
    if (paramInt < this.Rgs)
    {
      if (this.wIf)
      {
        localObject = this.Rgq.get(paramInt);
        AppMethodBeat.o(152206);
        return localObject;
      }
      Object localObject = this.MWw.get(paramInt);
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
    as localas = null;
    int i;
    if (paramInt < this.Rgs)
    {
      i = 0;
      if (this.wIf) {
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
        localc = hw(localView);
      }
      label257:
      label645:
      label1547:
      for (;;)
      {
        label58:
        int j;
        if ((Rgl == 4) || (this.RgF))
        {
          j = this.mContext.getResources().getDimensionPixelSize(a.a.NormalAvatarWrapSize);
          localc.jki.getLayoutParams().height = j;
          localc.jki.getLayoutParams().width = j;
          label113:
          localc.RgI.setVisibility(8);
          localc.jjK.setVisibility(8);
          if (i != 0) {
            break label968;
          }
          localc.jki.setVisibility(0);
          if (!this.fKN) {
            break label645;
          }
          if (Util.isNullOrNil(localas.field_conRemark)) {
            break label615;
          }
          paramView = localas.field_conRemark;
          label171:
          Object localObject = paramView;
          if (Util.isNullOrNil(paramView)) {
            localObject = localas.field_conRemark;
          }
          paramView = (View)localObject;
          if (Util.isNullOrNil((String)localObject)) {
            paramView = localas.ayr();
          }
          paramView = l.b(this.mContext, paramView, localc.iZH.getTextSize());
          label222:
          if (!(paramView instanceof SpannableString)) {
            break label750;
          }
          localc.iZH.setVisibility(8);
          localc.jjJ.setVisibility(0);
          localc.jjJ.setText(paramView);
          paramView = com.tencent.mm.openim.room.a.a.V(localas);
          if (!TextUtils.isEmpty(paramView)) {
            break label781;
          }
          localc.jjK.setVisibility(8);
          label280:
          localc.jki.setContentDescription("");
          if (!this.wIf) {
            break label802;
          }
          q.bml().a(x.a.RgS.ec(paramViewGroup), localc.jki, this.jjH);
          localc.jki.setBackgroundDrawable(null);
          label331:
          if (!this.wIf) {
            break label914;
          }
          if ((!this.jis) || ((this.RgA != null) && (this.RgA.equals(x.a.RgS.ed(paramViewGroup))))) {
            break label901;
          }
          localc.Jkg.setVisibility(0);
        }
        label781:
        label802:
        label1315:
        for (;;)
        {
          if ((!this.wIf) || (paramViewGroup == null)) {
            localc.rql.setVisibility(8);
          }
          localc.viewType = i;
          AppMethodBeat.o(152202);
          return localView;
          localas = (as)getItem(paramInt);
          paramViewGroup = null;
          break;
          if ((paramInt == this.Rgs) && (this.Rgv))
          {
            paramViewGroup = null;
            i = 3;
            break;
          }
          if ((paramInt == this.Rgs + 1) && (this.Rgu))
          {
            paramViewGroup = null;
            i = 4;
            break;
          }
          if ((paramInt == this.Rgs + 1) && (this.Rgw) && (!this.Rgu))
          {
            paramViewGroup = null;
            i = 5;
            break;
          }
          if ((paramInt != this.Rgs + 2) || (!this.Rgw) || (!this.Rgu)) {
            break label1553;
          }
          paramViewGroup = null;
          i = 5;
          break;
          localc = (c)paramView.getTag();
          if (localc != null) {
            break label1547;
          }
          localc = hw(paramView);
          localView = paramView;
          break label58;
          j = this.mContext.getResources().getDimensionPixelSize(a.a.NormalAvatarSize);
          localc.jki.getLayoutParams().height = j;
          localc.jki.getLayoutParams().width = j;
          break label113;
          label615:
          paramView = localas.field_username;
          if (this.iXp == null)
          {
            paramView = null;
            break label171;
          }
          paramView = this.iXp.PJ(paramView);
          break label171;
          if (this.wIf)
          {
            paramView = l.b(this.mContext, x.a.RgS.eb(paramViewGroup), localc.iZH.getTextSize());
            break label222;
          }
          if (as.bvK(localas.field_username))
          {
            paramView = ((com.tencent.mm.openim.a.a)h.ae(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), localas.ays(), (int)localc.iZH.getTextSize());
            break label222;
          }
          paramView = l.b(this.mContext, localas.ays(), localc.iZH.getTextSize());
          break label222;
          label750:
          localc.iZH.setVisibility(0);
          localc.jjJ.setVisibility(8);
          localc.iZH.setText(paramView);
          break label257;
          localc.jjK.setVisibility(0);
          localc.jjK.setText(paramView);
          break label280;
          com.tencent.mm.pluginsdk.ui.a.b.c(localc.jki, localas.field_username);
          paramView = (com.tencent.mm.pluginsdk.ui.a)localc.jki.getDrawable();
          if (this.Rgt != null) {
            this.Rgt.a(paramView);
          }
          localc.jki.setTagUsername(localas.field_username);
          localc.jki.setTagTalker(this.username);
          if (ab.PP(this.username))
          {
            localc.jki.setTagScene(4);
            break label331;
          }
          localc.jki.setTagScene(3);
          break label331;
          localc.Jkg.setVisibility(8);
          continue;
          label1215:
          label1220:
          if ((this.jis) && ((this.RgA == null) || (!this.RgA.equals(localas.field_username))))
          {
            localc.Jkg.setVisibility(0);
          }
          else
          {
            localc.Jkg.setVisibility(8);
            continue;
            label968:
            if (i == 3)
            {
              paramView = localc.iZH;
              if (paramInt == 0)
              {
                j = 8;
                label988:
                paramView.setVisibility(j);
                paramView = localc.jjJ;
                if (paramInt != 0) {
                  break label1047;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.Jkg.setVisibility(8);
                if (!this.jis) {
                  break label1052;
                }
                localc.jki.setVisibility(4);
                break;
                j = 4;
                break label988;
              }
              localc.jki.setVisibility(0);
              if (this.wIf)
              {
                q.bml().a("", localc.jki, this.jjH);
                localc.jki.setBackgroundDrawable(null);
              }
              localc.jki.setImageResource(com.tencent.mm.pluginsdk.a.a.b.big_add_selector);
              localc.jki.setContentDescription(this.mContext.getString(a.e.add_selector_btn));
            }
            else if (i == 4)
            {
              paramView = localc.iZH;
              if (1 == paramInt)
              {
                j = 8;
                label1148:
                paramView.setVisibility(j);
                paramView = localc.jjJ;
                if (1 != paramInt) {
                  break label1215;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.Jkg.setVisibility(8);
                if ((!this.jis) && (this.Rgs != 0)) {
                  break label1220;
                }
                localc.jki.setVisibility(4);
                break;
                j = 4;
                break label1148;
              }
              localc.jki.setVisibility(0);
              if (this.wIf)
              {
                q.bml().a("", localc.jki, this.jjH);
                localc.jki.setBackgroundDrawable(null);
              }
              localc.jki.setImageResource(com.tencent.mm.pluginsdk.a.a.b.big_del_selector);
              localc.jki.setContentDescription(this.mContext.getString(a.e.del_selector_btn));
            }
            else if (i == 5)
            {
              paramView = localc.iZH;
              if (paramInt == 0)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.jjJ;
                if (paramInt != 0) {
                  break label1374;
                }
              }
              label1374:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.Jkg.setVisibility(8);
                if (!this.jis) {
                  break label1379;
                }
                localc.jki.setVisibility(4);
                break;
                j = 4;
                break label1315;
              }
              label1379:
              localc.jki.setVisibility(0);
              if (this.wIf)
              {
                q.bml().a("", localc.jki, this.jjH);
                localc.jki.setBackgroundDrawable(null);
              }
              localc.jki.setImageResource(com.tencent.mm.pluginsdk.a.a.b.big_more_selector);
              localc.jki.setContentDescription(this.mContext.getString(a.e.more_selector_btn));
            }
            else if (i == 2)
            {
              if (this.wIf) {
                q.bml().a("", localc.jki, this.jjH);
              }
              localc.iZH.setVisibility(4);
              localc.jjJ.setVisibility(4);
              localc.Jkg.setVisibility(8);
              localc.jki.setVisibility(4);
              localc.jki.setImageResource(com.tencent.mm.pluginsdk.a.a.b.mm_trans);
              localc.jki.setBackgroundResource(com.tencent.mm.pluginsdk.a.a.b.mm_trans);
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
  
  public final void hF(List<String> paramList)
  {
    this.Rgx = true;
    this.fMr = paramList;
  }
  
  public final boolean hkA()
  {
    AppMethodBeat.i(152195);
    if (this.wIf)
    {
      bool = this.Rgp;
      AppMethodBeat.o(152195);
      return bool;
    }
    boolean bool = ab.Lj(this.username);
    AppMethodBeat.o(152195);
    return bool;
  }
  
  public final void hkC()
  {
    AppMethodBeat.i(152203);
    this.jis = false;
    ata();
    AppMethodBeat.o(152203);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(152194);
    this.username = paramString;
    this.fKN = ab.Lj(paramString);
    if ((!this.fKN) && (x.a.RgS != null)) {
      this.wIf = x.a.RgS.bra(paramString);
    }
    if (!this.wIf) {
      this.iXp = ((b)h.ae(b.class)).bbV().Rw(paramString);
    }
    hkz();
    AppMethodBeat.o(152194);
  }
  
  public static abstract interface a
  {
    public abstract void cQZ();
  }
  
  final class b
  {
    public Object RgH;
    public int order;
    
    public b(Object paramObject, int paramInt)
    {
      this.RgH = paramObject;
      this.order = paramInt;
    }
  }
  
  final class c
  {
    public ImageView Jkg;
    public ImageView RgI;
    public TextView iZH;
    public TextView jjJ;
    public TextView jjK;
    public AvatarPatTipImageView jki;
    public ImageView rql;
    public int viewType;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.r
 * JD-Core Version:    0.7.0.1
 */