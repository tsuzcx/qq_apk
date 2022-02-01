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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e;
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
  public static int Kfx = 5;
  public static int MAX_COUNT = 44;
  private List<as> GjL;
  public boolean KfA;
  public boolean KfB;
  private List<Object> KfC;
  int KfD;
  int KfE;
  e KfF;
  public boolean KfG;
  public boolean KfH;
  public boolean KfI;
  private boolean KfJ;
  boolean KfK;
  int KfL;
  String KfM;
  private final int KfN;
  public boolean KfO;
  private boolean KfP;
  boolean KfQ;
  public boolean KfR;
  a Kfy;
  private ArrayList<as> Kfz;
  private boolean dRx;
  private List<String> dSU;
  ah gtd;
  boolean gyp;
  private com.tencent.mm.av.a.a.c gzE;
  private Context mContext;
  boolean tca;
  private String username;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(152192);
    this.dSU = new ArrayList();
    this.Kfz = new ArrayList();
    this.tca = false;
    this.KfA = false;
    this.KfB = false;
    this.GjL = new ArrayList();
    this.KfC = new ArrayList();
    this.KfD = 0;
    this.KfE = 0;
    this.KfG = false;
    this.KfH = false;
    this.KfI = false;
    this.KfJ = true;
    this.KfK = false;
    this.KfL = 12;
    this.KfO = false;
    this.gzE = null;
    this.KfP = true;
    this.KfQ = true;
    this.KfR = false;
    this.mContext = paramContext;
    this.gyp = false;
    this.KfN = paramContext.getResources().getDimensionPixelSize(2131165190);
    AppMethodBeat.o(152192);
  }
  
  private void aim(int paramInt)
  {
    AppMethodBeat.i(152199);
    if (paramInt < this.KfE)
    {
      this.gyp = true;
      cCu();
    }
    AppMethodBeat.o(152199);
  }
  
  private void cCu()
  {
    AppMethodBeat.i(152200);
    if (this.Kfy != null) {
      this.Kfy.cCu();
    }
    AppMethodBeat.o(152200);
  }
  
  private c gm(View paramView)
  {
    AppMethodBeat.i(152201);
    c localc = new c();
    localc.KfU = ((ImageView)paramView.findViewById(2131307130));
    localc.gAf = ((AvatarPatTipImageView)paramView.findViewById(2131307155));
    localc.DeA = ((ImageView)paramView.findViewById(2131307129));
    localc.gvw = ((TextView)paramView.findViewById(2131307151));
    localc.gzG = ((TextView)paramView.findViewById(2131307152));
    localc.gzH = ((TextView)paramView.findViewById(2131307154));
    localc.ooE = ((ImageView)paramView.findViewById(2131307131));
    localc.gAf.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.setTag(localc);
    AppMethodBeat.o(152201);
    return localc;
  }
  
  private void gpB()
  {
    AppMethodBeat.i(152193);
    if ((this.tca) && (x.a.Kge != null)) {
      this.gzE = x.a.Kge.beG(this.username);
    }
    AppMethodBeat.o(152193);
  }
  
  private void gpD()
  {
    AppMethodBeat.i(152197);
    if (this.Kfz == null)
    {
      AppMethodBeat.o(152197);
      return;
    }
    Log.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[] { Integer.valueOf(this.Kfz.size()) });
    this.GjL.clear();
    if (this.Kfz.size() > 0)
    {
      Iterator localIterator = this.Kfz.iterator();
      while (localIterator.hasNext())
      {
        as localas = (as)localIterator.next();
        this.GjL.add(localas);
      }
    }
    this.KfE = this.GjL.size();
    AppMethodBeat.o(152197);
  }
  
  public final boolean ail(int paramInt)
  {
    AppMethodBeat.i(152198);
    if (!this.gyp)
    {
      aim(paramInt);
      AppMethodBeat.o(152198);
      return true;
    }
    AppMethodBeat.o(152198);
    return false;
  }
  
  public final boolean ain(int paramInt)
  {
    return paramInt < this.KfE;
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(152196);
    if ((this.dSU == null) && (this.Kfz == null))
    {
      AppMethodBeat.o(152196);
      return;
    }
    int i;
    if (this.KfJ) {
      if (this.dSU != null)
      {
        Log.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[] { Integer.valueOf(this.dSU.size()) });
        this.GjL.clear();
        this.KfC.clear();
        Object localObject1 = new LinkedList();
        if (this.dSU.size() > 0)
        {
          Object localObject2 = this.dSU.iterator();
          i = 1;
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if (this.tca)
            {
              this.KfC.add(x.a.Kge.beF(str));
            }
            else
            {
              as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
              if ((this.gtd != null) && (str.equals(this.gtd.field_roomowner)))
              {
                ((LinkedList)localObject1).add(new b(localas, 0));
              }
              else if ((this.gtd != null) && (this.gtd.bjf(localas.field_username)))
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
          if (this.KfP) {
            Collections.sort((List)localObject1, new Comparator() {});
          }
          if (!this.tca)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b)((Iterator)localObject1).next();
              this.GjL.add((as)((b)localObject2).KfT);
            }
          }
        }
        if (this.tca) {
          this.KfE = this.KfC.size();
        }
      }
      else
      {
        if (this.KfE != 0) {
          break label581;
        }
        this.KfD = Kfx;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.KfE + " realySize : " + this.KfD);
      cCu();
      AppMethodBeat.o(152196);
      return;
      if (this.dRx)
      {
        if ((this.gtd != null) && (!this.gtd.amD()))
        {
          if (this.GjL.size() >= MAX_COUNT) {}
          for (i = MAX_COUNT;; i = this.GjL.size())
          {
            this.KfE = i;
            break;
          }
        }
        if (this.GjL.size() >= MAX_COUNT - 1) {}
        for (i = MAX_COUNT - 1;; i = this.GjL.size())
        {
          this.KfE = i;
          break;
        }
      }
      this.KfE = this.GjL.size();
      break;
      gpD();
      break;
      label581:
      if ((this.KfH) && (this.KfG) && (this.KfI)) {
        this.KfD = (((this.KfE + 2) / Kfx + 1) * Kfx);
      } else if (((this.KfH) && (this.KfG) && (!this.KfI)) || ((this.KfH) && (!this.KfG) && (this.KfI)) || ((!this.KfH) && (this.KfG) && (this.KfI))) {
        this.KfD = (((this.KfE + 1) / Kfx + 1) * Kfx);
      } else if (((this.KfH) && (!this.KfG) && (!this.KfI)) || ((!this.KfH) && (this.KfG) && (!this.KfI)) || ((!this.KfH) && (!this.KfG) && (this.KfI))) {
        this.KfD = ((this.KfE / Kfx + 1) * Kfx);
      } else if ((!this.KfH) && (!this.KfG) && (!this.KfI)) {
        this.KfD = (((this.KfE - 1) / Kfx + 1) * Kfx);
      }
    }
  }
  
  public final void bh(ArrayList<as> paramArrayList)
  {
    this.KfJ = false;
    this.Kfz = paramArrayList;
  }
  
  public final void fm(List<String> paramList)
  {
    AppMethodBeat.i(152204);
    gX(paramList);
    amZ();
    AppMethodBeat.o(152204);
  }
  
  public final void gX(List<String> paramList)
  {
    this.KfJ = true;
    this.dSU = paramList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(152205);
    if (this.KfK)
    {
      i = Math.min(this.KfL, this.KfD);
      AppMethodBeat.o(152205);
      return i;
    }
    int i = this.KfD;
    AppMethodBeat.o(152205);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152206);
    if (paramInt < this.KfE)
    {
      if (this.tca)
      {
        localObject = this.KfC.get(paramInt);
        AppMethodBeat.o(152206);
        return localObject;
      }
      Object localObject = this.GjL.get(paramInt);
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
    if (paramInt < this.KfE)
    {
      i = 0;
      if (this.tca) {
        paramViewGroup = getItem(paramInt);
      }
    }
    for (;;)
    {
      View localView;
      c localc;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, 2131496126, null);
        localc = gm(localView);
      }
      label257:
      label645:
      label1547:
      for (;;)
      {
        label58:
        int j;
        if ((Kfx == 4) || (this.KfR))
        {
          j = this.mContext.getResources().getDimensionPixelSize(2131165528);
          localc.gAf.getLayoutParams().height = j;
          localc.gAf.getLayoutParams().width = j;
          label113:
          localc.KfU.setVisibility(8);
          localc.gzH.setVisibility(8);
          if (i != 0) {
            break label968;
          }
          localc.gAf.setVisibility(0);
          if (!this.dRx) {
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
            paramView = localas.arI();
          }
          paramView = com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, paramView, localc.gvw.getTextSize());
          label222:
          if (!(paramView instanceof SpannableString)) {
            break label750;
          }
          localc.gvw.setVisibility(8);
          localc.gzG.setVisibility(0);
          localc.gzG.setText(paramView);
          paramView = com.tencent.mm.openim.room.a.a.O(localas);
          if (!TextUtils.isEmpty(paramView)) {
            break label781;
          }
          localc.gzH.setVisibility(8);
          label280:
          localc.gAf.setContentDescription("");
          if (!this.tca) {
            break label802;
          }
          q.bcV().a(x.a.Kge.dY(paramViewGroup), localc.gAf, this.gzE);
          localc.gAf.setBackgroundDrawable(null);
          label331:
          if (!this.tca) {
            break label914;
          }
          if ((!this.gyp) || ((this.KfM != null) && (this.KfM.equals(x.a.Kge.dZ(paramViewGroup))))) {
            break label901;
          }
          localc.DeA.setVisibility(0);
        }
        label781:
        label802:
        label1315:
        for (;;)
        {
          if ((!this.tca) || (paramViewGroup == null)) {
            localc.ooE.setVisibility(8);
          }
          localc.qcr = i;
          AppMethodBeat.o(152202);
          return localView;
          localas = (as)getItem(paramInt);
          paramViewGroup = null;
          break;
          if ((paramInt == this.KfE) && (this.KfH))
          {
            paramViewGroup = null;
            i = 3;
            break;
          }
          if ((paramInt == this.KfE + 1) && (this.KfG))
          {
            paramViewGroup = null;
            i = 4;
            break;
          }
          if ((paramInt == this.KfE + 1) && (this.KfI) && (!this.KfG))
          {
            paramViewGroup = null;
            i = 5;
            break;
          }
          if ((paramInt != this.KfE + 2) || (!this.KfI) || (!this.KfG)) {
            break label1553;
          }
          paramViewGroup = null;
          i = 5;
          break;
          localc = (c)paramView.getTag();
          if (localc != null) {
            break label1547;
          }
          localc = gm(paramView);
          localView = paramView;
          break label58;
          j = this.mContext.getResources().getDimensionPixelSize(2131165526);
          localc.gAf.getLayoutParams().height = j;
          localc.gAf.getLayoutParams().width = j;
          break label113;
          label615:
          paramView = localas.field_username;
          if (this.gtd == null)
          {
            paramView = null;
            break label171;
          }
          paramView = this.gtd.getDisplayName(paramView);
          break label171;
          if (this.tca)
          {
            paramView = com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, x.a.Kge.dX(paramViewGroup), localc.gvw.getTextSize());
            break label222;
          }
          if (as.bjp(localas.field_username))
          {
            paramView = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), localas.arJ(), (int)localc.gvw.getTextSize());
            break label222;
          }
          paramView = com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, localas.arJ(), localc.gvw.getTextSize());
          break label222;
          label750:
          localc.gvw.setVisibility(0);
          localc.gzG.setVisibility(8);
          localc.gvw.setText(paramView);
          break label257;
          localc.gzH.setVisibility(0);
          localc.gzH.setText(paramView);
          break label280;
          a.b.c(localc.gAf, localas.field_username);
          paramView = (com.tencent.mm.pluginsdk.ui.a)localc.gAf.getDrawable();
          if (this.KfF != null) {
            this.KfF.a(paramView);
          }
          localc.gAf.setTagUsername(localas.field_username);
          localc.gAf.setTagTalker(this.username);
          if (ab.Ix(this.username))
          {
            localc.gAf.setTagScene(4);
            break label331;
          }
          localc.gAf.setTagScene(3);
          break label331;
          localc.DeA.setVisibility(8);
          continue;
          label1215:
          label1220:
          if ((this.gyp) && ((this.KfM == null) || (!this.KfM.equals(localas.field_username))))
          {
            localc.DeA.setVisibility(0);
          }
          else
          {
            localc.DeA.setVisibility(8);
            continue;
            label968:
            if (i == 3)
            {
              paramView = localc.gvw;
              if (paramInt == 0)
              {
                j = 8;
                label988:
                paramView.setVisibility(j);
                paramView = localc.gzG;
                if (paramInt != 0) {
                  break label1047;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.DeA.setVisibility(8);
                if (!this.gyp) {
                  break label1052;
                }
                localc.gAf.setVisibility(4);
                break;
                j = 4;
                break label988;
              }
              localc.gAf.setVisibility(0);
              if (this.tca)
              {
                q.bcV().a("", localc.gAf, this.gzE);
                localc.gAf.setBackgroundDrawable(null);
              }
              localc.gAf.setImageResource(2131231212);
              localc.gAf.setContentDescription(this.mContext.getString(2131755174));
            }
            else if (i == 4)
            {
              paramView = localc.gvw;
              if (1 == paramInt)
              {
                j = 8;
                label1148:
                paramView.setVisibility(j);
                paramView = localc.gzG;
                if (1 != paramInt) {
                  break label1215;
                }
              }
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.DeA.setVisibility(8);
                if ((!this.gyp) && (this.KfE != 0)) {
                  break label1220;
                }
                localc.gAf.setVisibility(4);
                break;
                j = 4;
                break label1148;
              }
              localc.gAf.setVisibility(0);
              if (this.tca)
              {
                q.bcV().a("", localc.gAf, this.gzE);
                localc.gAf.setBackgroundDrawable(null);
              }
              localc.gAf.setImageResource(2131231213);
              localc.gAf.setContentDescription(this.mContext.getString(2131758280));
            }
            else if (i == 5)
            {
              paramView = localc.gvw;
              if (paramInt == 0)
              {
                j = 8;
                paramView.setVisibility(j);
                paramView = localc.gzG;
                if (paramInt != 0) {
                  break label1374;
                }
              }
              label1374:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localc.DeA.setVisibility(8);
                if (!this.gyp) {
                  break label1379;
                }
                localc.gAf.setVisibility(4);
                break;
                j = 4;
                break label1315;
              }
              label1379:
              localc.gAf.setVisibility(0);
              if (this.tca)
              {
                q.bcV().a("", localc.gAf, this.gzE);
                localc.gAf.setBackgroundDrawable(null);
              }
              localc.gAf.setImageResource(2131231214);
              localc.gAf.setContentDescription(this.mContext.getString(2131763163));
            }
            else if (i == 2)
            {
              if (this.tca) {
                q.bcV().a("", localc.gAf, this.gzE);
              }
              localc.gvw.setVisibility(4);
              localc.gzG.setVisibility(4);
              localc.DeA.setVisibility(8);
              localc.gAf.setVisibility(4);
              localc.gAf.setImageResource(2131233974);
              localc.gAf.setBackgroundResource(2131233974);
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
  
  public final boolean gpC()
  {
    AppMethodBeat.i(152195);
    if (this.tca)
    {
      bool = this.KfB;
      AppMethodBeat.o(152195);
      return bool;
    }
    boolean bool = ab.Eq(this.username);
    AppMethodBeat.o(152195);
    return bool;
  }
  
  public final void gpE()
  {
    AppMethodBeat.i(152203);
    this.gyp = false;
    amZ();
    AppMethodBeat.o(152203);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(152194);
    this.username = paramString;
    this.dRx = ab.Eq(paramString);
    if ((!this.dRx) && (x.a.Kge != null)) {
      this.tca = x.a.Kge.beE(paramString);
    }
    if (!this.tca) {
      this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    }
    gpB();
    AppMethodBeat.o(152194);
  }
  
  public static abstract interface a
  {
    public abstract void cCu();
  }
  
  final class b
  {
    public Object KfT;
    public int order;
    
    public b(Object paramObject, int paramInt)
    {
      this.KfT = paramObject;
      this.order = paramInt;
    }
  }
  
  final class c
  {
    public ImageView DeA;
    public ImageView KfU;
    public AvatarPatTipImageView gAf;
    public TextView gvw;
    public TextView gzG;
    public TextView gzH;
    public ImageView ooE;
    public int qcr;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.r
 * JD-Core Version:    0.7.0.1
 */