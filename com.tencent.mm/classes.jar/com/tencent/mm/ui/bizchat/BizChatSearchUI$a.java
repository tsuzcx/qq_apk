package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.a.l;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class BizChatSearchUI$a
  extends BaseAdapter
  implements com.tencent.mm.ai.f
{
  public static int ztI = 3;
  private int ZY;
  private Context context;
  String ejd;
  private com.tencent.mm.at.a.a.c fHh;
  String jUE;
  private int scene;
  private int ztJ;
  boolean ztK;
  boolean ztL;
  private ArrayList<com.tencent.mm.aj.a.c> ztM;
  private ArrayList<Object> ztN;
  private ArrayList<com.tencent.mm.aj.a.c> ztO;
  private BizChatSearchUI.g ztP;
  private ArrayList<BizChatSearchUI.g> ztQ;
  private BizChatSearchUI.g ztR;
  private BizChatSearchUI.g ztS;
  private ArrayList<BizChatSearchUI.g> ztT;
  private BizChatSearchUI.g ztU;
  public boolean ztV;
  public boolean ztW;
  public boolean ztX;
  private boolean ztY;
  private int ztZ;
  public boolean zua;
  int zub;
  
  public BizChatSearchUI$a(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(30138);
    this.ztM = new ArrayList();
    this.ztN = new ArrayList();
    this.ztO = new ArrayList();
    this.ztQ = new ArrayList();
    this.ztT = new ArrayList();
    this.ztV = true;
    this.ztW = false;
    this.ztX = false;
    this.ztY = true;
    this.ztZ = 0;
    this.ZY = 0;
    this.zua = false;
    this.zub = 0;
    this.context = paramContext;
    this.jUE = paramString;
    this.scene = paramInt;
    boolean bool1;
    if ((this.scene == 1) || (this.scene == 2))
    {
      bool1 = true;
      this.ztK = bool1;
      if (this.scene != 1)
      {
        bool1 = bool2;
        if (this.scene != 3) {}
      }
      else
      {
        bool1 = true;
      }
      this.ztL = bool1;
      if (this.scene != 1) {
        break label267;
      }
    }
    label267:
    for (paramInt = ztI;; paramInt = 2147483647)
    {
      this.ztJ = paramInt;
      paramContext = new c.a();
      paramContext.eNP = e.cV(this.jUE);
      paramContext.eNM = true;
      paramContext.eOe = true;
      paramContext.eNY = 2131231207;
      this.fHh = paramContext.ahY();
      if (this.ztK) {
        aw.Rc().a(1364, this);
      }
      AppMethodBeat.o(30138);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static SpannableString a(Context paramContext, Spannable paramSpannable, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(30144);
    paramContext = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramSpannable, paramInt);
    ForegroundColorSpan[] arrayOfForegroundColorSpan = (ForegroundColorSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ForegroundColorSpan.class);
    if (arrayOfForegroundColorSpan != null)
    {
      int j = arrayOfForegroundColorSpan.length;
      paramInt = i;
      while (paramInt < j)
      {
        ForegroundColorSpan localForegroundColorSpan = arrayOfForegroundColorSpan[paramInt];
        paramContext.setSpan(localForegroundColorSpan, paramSpannable.getSpanStart(localForegroundColorSpan), paramSpannable.getSpanEnd(localForegroundColorSpan), paramSpannable.getSpanFlags(localForegroundColorSpan));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(30144);
    return paramContext;
  }
  
  private void dEX()
  {
    AppMethodBeat.i(30143);
    if (dEZ())
    {
      this.ztW = false;
      this.zua = true;
      dFd();
    }
    AppMethodBeat.o(30143);
  }
  
  private boolean dEY()
  {
    return this.scene == 1;
  }
  
  private boolean dFa()
  {
    return this.scene == 3;
  }
  
  private void dFb()
  {
    int k = 1;
    AppMethodBeat.i(30147);
    int i = this.ztN.size();
    int m = this.ztO.size();
    boolean bool;
    label73:
    int j;
    if (this.scene != 2)
    {
      if (this.ztN.size() > this.ztJ)
      {
        bool = true;
        this.ztV = bool;
      }
    }
    else
    {
      if (this.ztO.size() <= this.ztJ) {
        break label197;
      }
      bool = true;
      this.ztY = bool;
      if ((i <= 0) && (!this.ztW)) {
        break label218;
      }
      j = Math.min(i, this.ztJ) + 1;
      if (!dEY()) {
        break label213;
      }
      if ((!this.ztW) && (!this.ztV)) {
        break label203;
      }
      i = 1;
      label124:
      i += j;
    }
    for (;;)
    {
      this.ztZ = i;
      j = i;
      if (m > 0)
      {
        m = i + 1 + Math.min(m, this.ztJ);
        j = m;
        if (dEY()) {
          if (!this.ztY) {
            break label208;
          }
        }
      }
      label197:
      label203:
      label208:
      for (i = k;; i = 0)
      {
        j = m + i;
        this.ZY = j;
        AppMethodBeat.o(30147);
        return;
        bool = false;
        break;
        bool = false;
        break label73;
        i = 0;
        break label124;
      }
      label213:
      i = j;
      continue;
      label218:
      i = 0;
    }
  }
  
  private void dFc()
  {
    int k = 0;
    AppMethodBeat.i(30150);
    this.ztQ.clear();
    this.ztT.clear();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= Math.min(this.ztJ, this.ztN.size())) {
        break;
      }
      this.ztQ.add(new BizChatSearchUI.g(BizChatSearchUI.g.zuf, this.ztN.get(i)));
      i += 1;
    }
    while (j < Math.min(this.ztJ, this.ztO.size()))
    {
      this.ztT.add(new BizChatSearchUI.g(BizChatSearchUI.g.zug, this.ztO.get(j)));
      j += 1;
    }
    AppMethodBeat.o(30150);
  }
  
  public final BizChatSearchUI.g OZ(int paramInt)
  {
    AppMethodBeat.i(30140);
    if (paramInt < this.ztZ)
    {
      if (paramInt == 0)
      {
        if (this.ztP == null) {
          this.ztP = new BizChatSearchUI.g(BizChatSearchUI.g.zuj, Integer.valueOf(BizChatSearchUI.g.zul));
        }
        localg = this.ztP;
        AppMethodBeat.o(30140);
        return localg;
      }
      if ((paramInt == this.ztZ - 1) && (this.ztW) && (dEY()))
      {
        if (this.ztR == null) {
          this.ztR = new BizChatSearchUI.g();
        }
        this.ztR.kwo = BizChatSearchUI.g.zui;
        this.ztR.data = Integer.valueOf(BizChatSearchUI.g.zul);
        localg = this.ztR;
        AppMethodBeat.o(30140);
        return localg;
      }
      if ((paramInt == this.ztZ - 1) && (this.ztV) && (dEY()))
      {
        if (this.ztR == null) {
          this.ztR = new BizChatSearchUI.g();
        }
        this.ztR.kwo = BizChatSearchUI.g.zuh;
        this.ztR.data = Integer.valueOf(BizChatSearchUI.g.zul);
        localg = this.ztR;
        AppMethodBeat.o(30140);
        return localg;
      }
      paramInt -= 1;
      if ((paramInt >= 0) && (paramInt < this.ztQ.size()))
      {
        localg = (BizChatSearchUI.g)this.ztQ.get(paramInt);
        AppMethodBeat.o(30140);
        return localg;
      }
    }
    else
    {
      if (paramInt == this.ztZ)
      {
        if (this.ztS == null) {
          this.ztS = new BizChatSearchUI.g(BizChatSearchUI.g.zuj, Integer.valueOf(BizChatSearchUI.g.zum));
        }
        localg = this.ztS;
        AppMethodBeat.o(30140);
        return localg;
      }
      if ((paramInt == this.ZY - 1) && (this.ztY) && (dEY()))
      {
        if (this.ztU == null) {
          this.ztU = new BizChatSearchUI.g(BizChatSearchUI.g.zuh, Integer.valueOf(BizChatSearchUI.g.zum));
        }
        localg = this.ztU;
        AppMethodBeat.o(30140);
        return localg;
      }
      paramInt = paramInt - this.ztZ - 1;
      if ((paramInt >= 0) && (paramInt < this.ztT.size()))
      {
        localg = (BizChatSearchUI.g)this.ztT.get(paramInt);
        AppMethodBeat.o(30140);
        return localg;
      }
    }
    BizChatSearchUI.g localg = new BizChatSearchUI.g();
    AppMethodBeat.o(30140);
    return localg;
  }
  
  final void atF(String paramString)
  {
    AppMethodBeat.i(30146);
    if (!this.ztK)
    {
      AppMethodBeat.o(30146);
      return;
    }
    al.p(new BizChatSearchUI.a.1(this, paramString), 200L);
    AppMethodBeat.o(30146);
  }
  
  final void clearData()
  {
    AppMethodBeat.i(30148);
    this.zub = 0;
    this.ztN.clear();
    this.ztM.clear();
    this.ztO.clear();
    AppMethodBeat.o(30148);
  }
  
  final void cm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(30145);
    paramString = z.afl().aG(this.jUE, paramString);
    clearData();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      com.tencent.mm.aj.a.c localc = (com.tencent.mm.aj.a.c)paramString.next();
      bool = localc.isGroup();
      if ((bool) && (this.ztL))
      {
        this.ztO.add(localc);
      }
      else if ((!bool) && (this.ztK))
      {
        this.ztN.add(localc);
        this.ztM.add(localc);
      }
    }
    if (this.ztK) {
      if (this.ztN.size() > this.ztJ) {
        break label153;
      }
    }
    label153:
    for (boolean bool = true;; bool = false)
    {
      this.ztW = bool;
      qN(paramBoolean);
      AppMethodBeat.o(30145);
      return;
    }
  }
  
  final boolean dEZ()
  {
    return this.scene == 2;
  }
  
  final void dFd()
  {
    AppMethodBeat.i(30151);
    ((BizChatSearchUI)this.context).a(this);
    AppMethodBeat.o(30151);
  }
  
  public final int getCount()
  {
    return this.ZY;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(30139);
    BizChatSearchUI.g localg = OZ(paramInt);
    if (localg != null)
    {
      paramInt = localg.kwo;
      AppMethodBeat.o(30139);
      return paramInt;
    }
    paramInt = BizChatSearchUI.g.zue;
    AppMethodBeat.o(30139);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30141);
    BizChatSearchUI.g localg = OZ(paramInt);
    View localView;
    int i;
    BizChatSearchUI.f localf;
    boolean bool1;
    Object localObject1;
    Object localObject2;
    if ((localg.kwo == BizChatSearchUI.g.zuf) || (localg.kwo == BizChatSearchUI.g.zug))
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.context).inflate(2130969650, paramViewGroup, false);
        i = paramViewGroup.getPaddingLeft();
        int j = paramViewGroup.getPaddingRight();
        localView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), i + j, -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
        paramView = new BizChatSearchUI.f((byte)0);
        paramView.egq = ((ImageView)localView.findViewById(2131821210));
        paramView.gpL = ((TextView)localView.findViewById(2131821212));
        paramView.gpM = ((TextView)localView.findViewById(2131821007));
        paramView.contentView = localView.findViewById(2131821209);
        localView.setTag(paramView);
      }
      localf = (BizChatSearchUI.f)localView.getTag();
      paramViewGroup = "";
      bool1 = false;
      localObject1 = "";
      if ((localg.data instanceof com.tencent.mm.aj.a.c))
      {
        paramView = (com.tencent.mm.aj.a.c)localg.data;
        if (paramView == null) {
          break label1217;
        }
        if (!paramView.isGroup())
        {
          localObject2 = z.afm().df(paramView.field_bizChatServId);
          if (localObject2 != null)
          {
            paramViewGroup = ((com.tencent.mm.aj.a.j)localObject2).field_userName;
            paramView = ((com.tencent.mm.aj.a.j)localObject2).field_headImageUrl;
          }
        }
      }
    }
    for (;;)
    {
      bool1 = false;
      i = 1;
      for (;;)
      {
        if (i != 0)
        {
          paramViewGroup = com.tencent.mm.plugin.fts.a.f.a(paramViewGroup, this.ejd);
          paramViewGroup = a(this.context, paramViewGroup, com.tencent.mm.plugin.fts.ui.b.c.mVV);
          label289:
          if (!bool1) {
            break label561;
          }
          localObject2 = this.context.getString(2131297765);
          localObject1 = com.tencent.mm.plugin.fts.a.f.a((CharSequence)localObject1, this.ejd);
        }
        label561:
        for (localObject1 = TextUtils.concat(new CharSequence[] { localObject2, a(this.context, (Spannable)localObject1, com.tencent.mm.plugin.fts.ui.b.c.mVV) });; localObject1 = "")
        {
          boolean bool2 = true;
          bool1 = bool2;
          if (localg.kwo == BizChatSearchUI.g.zuf)
          {
            bool1 = bool2;
            if (paramInt == this.ztZ - 1)
            {
              bool1 = bool2;
              if (this.ztZ != this.ZY) {
                bool1 = false;
              }
            }
          }
          com.tencent.mm.plugin.fts.ui.m.q(localf.contentView, bool1);
          o.ahG().a(paramView, localf.egq, this.fHh);
          com.tencent.mm.plugin.fts.ui.m.a(paramViewGroup, localf.gpL);
          com.tencent.mm.plugin.fts.ui.m.a((CharSequence)localObject1, localf.gpM);
          AppMethodBeat.o(30141);
          return localView;
          paramViewGroup = paramView.field_chatName;
          paramView = paramView.field_headImageUrl;
          break;
          if (!(localg.data instanceof kt)) {
            break label1203;
          }
          localObject1 = (kt)localg.data;
          paramView = ((kt)localObject1).wyk;
          paramViewGroup = paramView.kqi;
          paramView = paramView.wyc;
          bool1 = "userid".equals(((kt)localObject1).wyl);
          if (!bool1) {}
          for (i = 1;; i = 0)
          {
            localObject1 = ((kt)localObject1).wym;
            break;
          }
          paramViewGroup = a(this.context, new SpannableString(paramViewGroup), com.tencent.mm.plugin.fts.ui.b.c.mVV);
          break label289;
        }
        if (localg.kwo == BizChatSearchUI.g.zuj)
        {
          localView = paramView;
          if (paramView == null)
          {
            localView = LayoutInflater.from(this.context).inflate(2130968860, paramViewGroup, false);
            paramView = new BizChatSearchUI.b((byte)0);
            paramView.kHN = ((TextView)localView.findViewById(2131822836));
            paramView.mYK = localView.findViewById(2131820910);
            paramView.contentView = localView.findViewById(2131821209);
            localView.setTag(paramView);
          }
          paramViewGroup = (BizChatSearchUI.b)localView.getTag();
          if (((Integer)localg.data).intValue() == BizChatSearchUI.g.zul) {
            paramView = this.context.getResources().getString(2131297763);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.fts.ui.m.a(paramView, paramViewGroup.kHN);
          if (paramInt == 0) {
            paramViewGroup.mYK.setVisibility(8);
          }
          for (;;)
          {
            paramViewGroup.contentView.setBackgroundResource(2130839285);
            AppMethodBeat.o(30141);
            return localView;
            if (((Integer)localg.data).intValue() != BizChatSearchUI.g.zum) {
              break label1196;
            }
            paramView = this.context.getResources().getString(2131297756);
            break;
            paramViewGroup.mYK.setVisibility(0);
          }
          if (localg.kwo == BizChatSearchUI.g.zuh)
          {
            localView = paramView;
            if (paramView == null)
            {
              localView = LayoutInflater.from(this.context).inflate(2130968861, paramViewGroup, false);
              paramView = new BizChatSearchUI.e((byte)0);
              paramView.mYs = ((TextView)localView.findViewById(2131821071));
              paramView.ivs = ((ImageView)localView.findViewById(2131821253));
              paramView.contentView = localView.findViewById(2131821209);
              localView.setTag(paramView);
            }
            paramViewGroup = (BizChatSearchUI.e)localView.getTag();
            paramView = "";
            if (((Integer)localg.data).intValue() == BizChatSearchUI.g.zul)
            {
              paramView = this.context.getResources().getString(2131297762);
              if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.zul) || (this.ztZ == this.ZY)) {
                break label1190;
              }
            }
          }
          label1184:
          label1190:
          for (bool1 = false;; bool1 = true)
          {
            com.tencent.mm.plugin.fts.ui.m.q(paramViewGroup.contentView, bool1);
            paramViewGroup.mYs.setText(paramView);
            paramViewGroup.ivs.setImageResource(2131231376);
            AppMethodBeat.o(30141);
            return localView;
            if (((Integer)localg.data).intValue() != BizChatSearchUI.g.zum) {
              break;
            }
            paramView = this.context.getResources().getString(2131297761);
            break;
            if (localg.kwo == BizChatSearchUI.g.zui)
            {
              localView = paramView;
              if (paramView == null)
              {
                localView = LayoutInflater.from(this.context).inflate(2130969664, paramViewGroup, false);
                paramView = new BizChatSearchUI.d((byte)0);
                paramView.mYs = ((TextView)localView.findViewById(2131821071));
                paramView.contentView = localView.findViewById(2131821209);
                localView.setTag(paramView);
              }
              paramView = (BizChatSearchUI.d)localView.getTag();
              if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.zul) || (this.ztZ == this.ZY)) {
                break label1184;
              }
            }
            for (bool1 = false;; bool1 = true)
            {
              com.tencent.mm.plugin.fts.ui.m.q(paramView.contentView, bool1);
              paramView.mYs.setText(this.context.getResources().getString(2131297758));
              AppMethodBeat.o(30141);
              return localView;
              AppMethodBeat.o(30141);
              return null;
            }
          }
          label1196:
          paramView = "";
        }
        label1203:
        i = 0;
        paramView = "";
        paramViewGroup = "";
      }
      label1217:
      paramView = "";
    }
  }
  
  public final int getViewTypeCount()
  {
    return BizChatSearchUI.g.zuk;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(30142);
    Object localObject1;
    Object localObject2;
    if ((this.ztK) && (paramm.getType() == 1364) && ((paramm instanceof l)))
    {
      this.ztX = false;
      localObject1 = (l)paramm;
      if ((((l)localObject1).rr != null) && (((l)localObject1).rr.fsV.fta != null)) {}
      for (paramString = (ku)((l)localObject1).rr.fsV.fta;; paramString = null)
      {
        paramm = paramString.cnv;
        localObject2 = paramString.wyh;
        if ((paramm.equals(this.ejd)) && (((String)localObject2).equals(this.jUE)) && (this.zub == paramString.offset)) {
          break;
        }
        AppMethodBeat.o(30142);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        dEX();
        AppMethodBeat.o(30142);
        return;
      }
      if ((((l)localObject1).rr != null) && (((l)localObject1).rr.fsW.fta != null)) {}
      for (paramString = (kv)((l)localObject1).rr.fsW.fta; (paramString == null) || (paramString.wyn == null) || (paramString.wyn.ret != 0); paramString = null)
      {
        dEX();
        AppMethodBeat.o(30142);
        return;
      }
      localObject1 = paramString.wyo;
      boolean bool = paramString.wyp;
      if (paramm.equals(this.ejd))
      {
        this.ztW = false;
        this.zub += ((List)localObject1).size();
        if (dEY())
        {
          if (this.ztN.size() < this.ztM.size())
          {
            cm(paramm, true);
            AppMethodBeat.o(30142);
            return;
          }
          if (this.ztN.size() > this.ztM.size()) {}
        }
        else
        {
          if (dEZ()) {
            this.ztV = bool;
          }
          if (dFa()) {
            break label470;
          }
          paramString = ((List)localObject1).iterator();
        }
      }
    }
    label470:
    label480:
    for (;;)
    {
      if (paramString.hasNext())
      {
        paramm = (kt)paramString.next();
        localObject1 = paramm.wyk;
        if (!bo.isNullOrNil(((kw)localObject1).wyi))
        {
          localObject2 = this.ztM.iterator();
          com.tencent.mm.aj.a.c localc;
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localc = (com.tencent.mm.aj.a.c)((Iterator)localObject2).next();
          } while (!((kw)localObject1).wyi.equals(localc.field_bizChatServId));
        }
      }
      else
      {
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label480;
          }
          this.ztN.add(paramm);
          break;
          qN(true);
          AppMethodBeat.o(30142);
          return;
        }
      }
    }
  }
  
  final void qN(boolean paramBoolean)
  {
    AppMethodBeat.i(30149);
    dFc();
    dFb();
    if (paramBoolean)
    {
      notifyDataSetChanged();
      dFd();
    }
    AppMethodBeat.o(30149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI.a
 * JD-Core Version:    0.7.0.1
 */