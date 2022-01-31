package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.a.l;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.is;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class BizChatSearchUI$a
  extends BaseAdapter
  implements com.tencent.mm.ah.f
{
  public static int vfj = 3;
  private int Zn = 0;
  private Context context;
  String drv;
  private com.tencent.mm.as.a.a.c eqR;
  String idQ;
  private int scene;
  private int vfA = 0;
  public boolean vfB = false;
  int vfC = 0;
  private int vfk;
  boolean vfl;
  boolean vfm;
  private ArrayList<com.tencent.mm.ai.a.c> vfn = new ArrayList();
  private ArrayList<Object> vfo = new ArrayList();
  private ArrayList<com.tencent.mm.ai.a.c> vfp = new ArrayList();
  private BizChatSearchUI.g vfq;
  private ArrayList<BizChatSearchUI.g> vfr = new ArrayList();
  private BizChatSearchUI.g vfs;
  private BizChatSearchUI.g vft;
  private ArrayList<BizChatSearchUI.g> vfu = new ArrayList();
  private BizChatSearchUI.g vfv;
  public boolean vfw = true;
  public boolean vfx = false;
  public boolean vfy = false;
  private boolean vfz = true;
  
  public BizChatSearchUI$a(Context paramContext, String paramString, int paramInt)
  {
    this.context = paramContext;
    this.idQ = paramString;
    this.scene = paramInt;
    boolean bool1;
    if ((this.scene == 1) || (this.scene == 2))
    {
      bool1 = true;
      this.vfl = bool1;
      if (this.scene != 1)
      {
        bool1 = bool2;
        if (this.scene != 3) {}
      }
      else
      {
        bool1 = true;
      }
      this.vfm = bool1;
      if (this.scene != 1) {
        break label256;
      }
    }
    label256:
    for (paramInt = vfj;; paramInt = 2147483647)
    {
      this.vfk = paramInt;
      paramContext = new c.a();
      paramContext.eri = com.tencent.mm.ai.a.e.bT(this.idQ);
      paramContext.erf = true;
      paramContext.erC = true;
      paramContext.eru = R.k.default_avatar;
      this.eqR = paramContext.OV();
      if (this.vfl) {
        au.Dk().a(1364, this);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private static SpannableString a(Context paramContext, Spannable paramSpannable, int paramInt)
  {
    int i = 0;
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
    return paramContext;
  }
  
  private void cBD()
  {
    if (cBF())
    {
      this.vfx = false;
      this.vfB = true;
      cBH();
    }
  }
  
  private boolean cBE()
  {
    return this.scene == 1;
  }
  
  private boolean cBG()
  {
    return this.scene == 3;
  }
  
  public final BizChatSearchUI.g GF(int paramInt)
  {
    if (paramInt < this.vfA)
    {
      if (paramInt == 0)
      {
        if (this.vfq == null) {
          this.vfq = new BizChatSearchUI.g(BizChatSearchUI.g.vfK, Integer.valueOf(BizChatSearchUI.g.vfM));
        }
        return this.vfq;
      }
      if ((paramInt == this.vfA - 1) && (this.vfx) && (cBE()))
      {
        if (this.vfs == null) {
          this.vfs = new BizChatSearchUI.g();
        }
        this.vfs.ivk = BizChatSearchUI.g.vfJ;
        this.vfs.data = Integer.valueOf(BizChatSearchUI.g.vfM);
        return this.vfs;
      }
      if ((paramInt == this.vfA - 1) && (this.vfw) && (cBE()))
      {
        if (this.vfs == null) {
          this.vfs = new BizChatSearchUI.g();
        }
        this.vfs.ivk = BizChatSearchUI.g.vfI;
        this.vfs.data = Integer.valueOf(BizChatSearchUI.g.vfM);
        return this.vfs;
      }
      paramInt -= 1;
      if ((paramInt >= 0) && (paramInt < this.vfr.size())) {
        return (BizChatSearchUI.g)this.vfr.get(paramInt);
      }
    }
    else
    {
      if (paramInt == this.vfA)
      {
        if (this.vft == null) {
          this.vft = new BizChatSearchUI.g(BizChatSearchUI.g.vfK, Integer.valueOf(BizChatSearchUI.g.vfN));
        }
        return this.vft;
      }
      if ((paramInt == this.Zn - 1) && (this.vfz) && (cBE()))
      {
        if (this.vfv == null) {
          this.vfv = new BizChatSearchUI.g(BizChatSearchUI.g.vfI, Integer.valueOf(BizChatSearchUI.g.vfN));
        }
        return this.vfv;
      }
      paramInt = paramInt - this.vfA - 1;
      if ((paramInt >= 0) && (paramInt < this.vfu.size())) {
        return (BizChatSearchUI.g)this.vfu.get(paramInt);
      }
    }
    return new BizChatSearchUI.g();
  }
  
  final void adg()
  {
    this.vfC = 0;
    this.vfo.clear();
    this.vfn.clear();
    this.vfp.clear();
  }
  
  final void adk(String paramString)
  {
    if (!this.vfl) {
      return;
    }
    ai.l(new BizChatSearchUI.a.1(this, paramString), 200L);
  }
  
  final void bK(String paramString, boolean paramBoolean)
  {
    Object localObject2 = z.MB();
    String str = this.idQ;
    Object localObject1 = new ArrayList();
    if (!bk.bl(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("select BizChatInfo.*");
      localStringBuilder.append(" from BizChatConversation , BizChatInfo");
      localStringBuilder.append(" where BizChatConversation.brandUserName = '").append(str).append("'");
      localStringBuilder.append(" and BizChatInfo.brandUserName = '").append(str).append("'");
      localStringBuilder.append(" and BizChatConversation.bizChatId");
      localStringBuilder.append(" = BizChatInfo.bizChatLocalId");
      localStringBuilder.append(" and BizChatInfo.chatName like '%").append(paramString).append("%'");
      localStringBuilder.append(" order by BizChatConversation.flag desc");
      localStringBuilder.append(" , BizChatConversation.lastMsgTime desc");
      y.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", new Object[] { localStringBuilder.toString() });
      paramString = ((com.tencent.mm.ai.a.b)localObject2).rawQuery(localStringBuilder.toString(), new String[0]);
      if (paramString != null)
      {
        if (paramString.moveToFirst()) {
          do
          {
            localObject2 = new com.tencent.mm.ai.a.c();
            ((com.tencent.mm.ai.a.c)localObject2).d(paramString);
            ((ArrayList)localObject1).add(localObject2);
          } while (paramString.moveToNext());
        }
        paramString.close();
      }
    }
    adg();
    paramString = ((List)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (com.tencent.mm.ai.a.c)paramString.next();
      bool = ((com.tencent.mm.ai.a.c)localObject1).isGroup();
      if ((bool) && (this.vfm))
      {
        this.vfp.add(localObject1);
      }
      else if ((!bool) && (this.vfl))
      {
        this.vfo.add(localObject1);
        this.vfn.add(localObject1);
      }
    }
    if (this.vfl) {
      if (this.vfo.size() > this.vfk) {
        break label366;
      }
    }
    label366:
    for (boolean bool = true;; bool = false)
    {
      this.vfx = bool;
      nh(paramBoolean);
      return;
    }
  }
  
  final boolean cBF()
  {
    return this.scene == 2;
  }
  
  final void cBH()
  {
    BizChatSearchUI localBizChatSearchUI = (BizChatSearchUI)this.context;
    if (cBE()) {
      if (bk.bl(this.drv))
      {
        localBizChatSearchUI.vfg.setVisibility(8);
        localBizChatSearchUI.vff.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      if (getCount() <= 0)
      {
        localBizChatSearchUI.vfg.setVisibility(0);
        localBizChatSearchUI.vff.setVisibility(8);
        return;
      }
      localBizChatSearchUI.vfg.setVisibility(8);
      localBizChatSearchUI.vff.setVisibility(0);
      return;
      if (bk.bl(this.drv))
      {
        localBizChatSearchUI.vfg.setVisibility(0);
        localBizChatSearchUI.vfg.setText("");
        localBizChatSearchUI.vff.setVisibility(8);
      }
      while (cBF())
      {
        if (!this.vfy) {
          break label317;
        }
        localBizChatSearchUI.GE(1);
        return;
        if ((cBF()) && (this.vfx))
        {
          localBizChatSearchUI.vfg.setVisibility(0);
          localBizChatSearchUI.vfg.setText(R.l.bizchat_search_loading);
          localBizChatSearchUI.vff.setVisibility(8);
        }
        else if ((cBF()) && (this.vfB))
        {
          localBizChatSearchUI.vfg.setVisibility(0);
          localBizChatSearchUI.vfg.setText(R.l.bizchat_search_loading_error);
          localBizChatSearchUI.vff.setVisibility(8);
        }
        else if (getCount() <= 0)
        {
          localBizChatSearchUI.vfg.setVisibility(0);
          localBizChatSearchUI.vfg.setText(com.tencent.mm.plugin.fts.a.f.a(localBizChatSearchUI.getString(R.l.search_contact_no_result_pre), localBizChatSearchUI.getString(R.l.search_contact_no_result_post), d.b(this.drv, this.drv)).kwz);
          localBizChatSearchUI.vff.setVisibility(8);
        }
        else
        {
          localBizChatSearchUI.vfg.setVisibility(8);
          localBizChatSearchUI.vff.setVisibility(0);
        }
      }
    }
    label317:
    if (this.vfw)
    {
      localBizChatSearchUI.GE(2);
      return;
    }
    localBizChatSearchUI.GE(0);
  }
  
  public final int getCount()
  {
    return this.Zn;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    BizChatSearchUI.g localg = GF(paramInt);
    if (localg != null) {
      return localg.ivk;
    }
    return BizChatSearchUI.g.vfF;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool2 = true;
    BizChatSearchUI.g localg = GF(paramInt);
    View localView;
    int i;
    BizChatSearchUI.f localf;
    Object localObject1;
    Object localObject2;
    if ((localg.ivk == BizChatSearchUI.g.vfG) || (localg.ivk == BizChatSearchUI.g.vfH))
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.context).inflate(R.i.fts_contact_item, paramViewGroup, false);
        i = paramViewGroup.getPaddingLeft();
        int j = paramViewGroup.getPaddingRight();
        localView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), i + j, -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
        paramView = new BizChatSearchUI.f((byte)0);
        paramView.doU = ((ImageView)localView.findViewById(R.h.avatar_iv));
        paramView.eXO = ((TextView)localView.findViewById(R.h.title_tv));
        paramView.eXP = ((TextView)localView.findViewById(R.h.desc_tv));
        paramView.contentView = localView.findViewById(R.h.search_item_content_layout);
        localView.setTag(paramView);
      }
      localf = (BizChatSearchUI.f)localView.getTag();
      paramViewGroup = "";
      localObject1 = "";
      if ((localg.data instanceof com.tencent.mm.ai.a.c))
      {
        paramView = (com.tencent.mm.ai.a.c)localg.data;
        if (paramView == null) {
          break label1191;
        }
        if (!paramView.isGroup())
        {
          localObject2 = z.MC().bY(paramView.field_bizChatServId);
          if (localObject2 != null)
          {
            paramViewGroup = ((com.tencent.mm.ai.a.j)localObject2).field_userName;
            paramView = ((com.tencent.mm.ai.a.j)localObject2).field_headImageUrl;
          }
        }
      }
    }
    for (;;)
    {
      i = 1;
      boolean bool1 = false;
      for (;;)
      {
        if (i != 0)
        {
          paramViewGroup = com.tencent.mm.plugin.fts.a.f.a(paramViewGroup, this.drv);
          paramViewGroup = a(this.context, paramViewGroup, com.tencent.mm.plugin.fts.ui.b.c.kAd);
          label289:
          if (!bool1) {
            break label552;
          }
          localObject2 = this.context.getString(R.l.bizchat_search_user_tag_userid);
          localObject1 = com.tencent.mm.plugin.fts.a.f.a((CharSequence)localObject1, this.drv);
        }
        label552:
        for (localObject1 = TextUtils.concat(new CharSequence[] { localObject2, a(this.context, (Spannable)localObject1, com.tencent.mm.plugin.fts.ui.b.c.kAd) });; localObject1 = "")
        {
          bool1 = bool2;
          if (localg.ivk == BizChatSearchUI.g.vfG)
          {
            bool1 = bool2;
            if (paramInt == this.vfA - 1)
            {
              bool1 = bool2;
              if (this.vfA != this.Zn) {
                bool1 = false;
              }
            }
          }
          com.tencent.mm.plugin.fts.ui.m.k(localf.contentView, bool1);
          o.ON().a(paramView, localf.doU, this.eqR);
          com.tencent.mm.plugin.fts.ui.m.a(paramViewGroup, localf.eXO);
          com.tencent.mm.plugin.fts.ui.m.a((CharSequence)localObject1, localf.eXP);
          return localView;
          paramViewGroup = paramView.field_chatName;
          paramView = paramView.field_headImageUrl;
          break;
          if (!(localg.data instanceof is)) {
            break label1174;
          }
          localObject1 = (is)localg.data;
          paramView = ((is)localObject1).sCR;
          paramViewGroup = paramView.ipb;
          paramView = paramView.sCJ;
          bool1 = "userid".equals(((is)localObject1).sCS);
          if (!bool1) {}
          for (i = 1;; i = 0)
          {
            localObject1 = ((is)localObject1).sCT;
            break;
          }
          paramViewGroup = a(this.context, new SpannableString(paramViewGroup), com.tencent.mm.plugin.fts.ui.b.c.kAd);
          break label289;
        }
        if (localg.ivk == BizChatSearchUI.g.vfK)
        {
          localView = paramView;
          if (paramView == null)
          {
            localView = LayoutInflater.from(this.context).inflate(R.i.fts_header_item, paramViewGroup, false);
            paramView = new BizChatSearchUI.b((byte)0);
            paramView.iCG = ((TextView)localView.findViewById(R.h.header_tv));
            paramView.kCO = localView.findViewById(R.h.padding_view);
            paramView.contentView = localView.findViewById(R.h.search_item_content_layout);
            localView.setTag(paramView);
          }
          paramViewGroup = (BizChatSearchUI.b)localView.getTag();
          if (((Integer)localg.data).intValue() == BizChatSearchUI.g.vfM) {
            paramView = this.context.getResources().getString(R.l.bizchat_search_user);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.fts.ui.m.a(paramView, paramViewGroup.iCG);
          if (paramInt == 0) {
            paramViewGroup.kCO.setVisibility(8);
          }
          for (;;)
          {
            paramViewGroup.contentView.setBackgroundResource(R.g.list_thicklinecell_bg);
            return localView;
            if (((Integer)localg.data).intValue() != BizChatSearchUI.g.vfN) {
              break label1167;
            }
            paramView = this.context.getResources().getString(R.l.bizchat_search_group);
            break;
            paramViewGroup.kCO.setVisibility(0);
          }
          if (localg.ivk == BizChatSearchUI.g.vfI)
          {
            localView = paramView;
            if (paramView == null)
            {
              localView = LayoutInflater.from(this.context).inflate(R.i.fts_more_item, paramViewGroup, false);
              paramView = new BizChatSearchUI.e((byte)0);
              paramView.kCv = ((TextView)localView.findViewById(R.h.tip_tv));
              paramView.gSx = ((ImageView)localView.findViewById(R.h.icon_iv));
              paramView.contentView = localView.findViewById(R.h.search_item_content_layout);
              localView.setTag(paramView);
            }
            paramViewGroup = (BizChatSearchUI.e)localView.getTag();
            paramView = "";
            if (((Integer)localg.data).intValue() == BizChatSearchUI.g.vfM) {
              paramView = this.context.getResources().getString(R.l.bizchat_search_more_user);
            }
            for (;;)
            {
              bool1 = bool3;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.vfM)
              {
                bool1 = bool3;
                if (this.vfA != this.Zn) {
                  bool1 = false;
                }
              }
              com.tencent.mm.plugin.fts.ui.m.k(paramViewGroup.contentView, bool1);
              paramViewGroup.kCv.setText(paramView);
              paramViewGroup.gSx.setImageResource(R.k.fts_more_button_icon);
              return localView;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.vfN) {
                paramView = this.context.getResources().getString(R.l.bizchat_search_more_group);
              }
            }
          }
          if (localg.ivk == BizChatSearchUI.g.vfJ)
          {
            localView = paramView;
            if (paramView == null)
            {
              localView = LayoutInflater.from(this.context).inflate(R.i.fts_loading_item, paramViewGroup, false);
              paramView = new BizChatSearchUI.d((byte)0);
              paramView.kCv = ((TextView)localView.findViewById(R.h.tip_tv));
              paramView.contentView = localView.findViewById(R.h.search_item_content_layout);
              localView.setTag(paramView);
            }
            paramView = (BizChatSearchUI.d)localView.getTag();
            bool1 = bool4;
            if (((Integer)localg.data).intValue() == BizChatSearchUI.g.vfM)
            {
              bool1 = bool4;
              if (this.vfA != this.Zn) {
                bool1 = false;
              }
            }
            com.tencent.mm.plugin.fts.ui.m.k(paramView.contentView, bool1);
            paramView.kCv.setText(this.context.getResources().getString(R.l.bizchat_search_loading));
            return localView;
          }
          return null;
          label1167:
          paramView = "";
        }
        label1174:
        i = 0;
        bool1 = false;
        paramView = "";
        paramViewGroup = "";
      }
      label1191:
      paramView = "";
    }
  }
  
  public final int getViewTypeCount()
  {
    return BizChatSearchUI.g.vfL;
  }
  
  final void nh(boolean paramBoolean)
  {
    int k = 1;
    this.vfr.clear();
    this.vfu.clear();
    int i = 0;
    while (i < Math.min(this.vfk, this.vfo.size()))
    {
      this.vfr.add(new BizChatSearchUI.g(BizChatSearchUI.g.vfG, this.vfo.get(i)));
      i += 1;
    }
    i = 0;
    while (i < Math.min(this.vfk, this.vfp.size()))
    {
      this.vfu.add(new BizChatSearchUI.g(BizChatSearchUI.g.vfH, this.vfp.get(i)));
      i += 1;
    }
    i = this.vfo.size();
    int m = this.vfp.size();
    boolean bool;
    label188:
    int j;
    if (this.scene != 2)
    {
      if (this.vfo.size() > this.vfk)
      {
        bool = true;
        this.vfw = bool;
      }
    }
    else
    {
      if (this.vfp.size() <= this.vfk) {
        break label319;
      }
      bool = true;
      this.vfz = bool;
      if ((i <= 0) && (!this.vfx)) {
        break label340;
      }
      j = Math.min(i, this.vfk) + 1;
      if (!cBE()) {
        break label335;
      }
      if ((!this.vfx) && (!this.vfw)) {
        break label325;
      }
      i = 1;
      label239:
      i += j;
    }
    for (;;)
    {
      this.vfA = i;
      j = i;
      if (m > 0)
      {
        m = i + 1 + Math.min(m, this.vfk);
        j = m;
        if (cBE()) {
          if (!this.vfz) {
            break label330;
          }
        }
      }
      label319:
      label325:
      label330:
      for (i = k;; i = 0)
      {
        j = m + i;
        this.Zn = j;
        if (paramBoolean)
        {
          notifyDataSetChanged();
          cBH();
        }
        return;
        bool = false;
        break;
        bool = false;
        break label188;
        i = 0;
        break label239;
      }
      label335:
      i = j;
      continue;
      label340:
      i = 0;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    Object localObject1;
    Object localObject2;
    if ((this.vfl) && (paramm.getType() == 1364) && ((paramm instanceof l)))
    {
      this.vfy = false;
      localObject1 = (l)paramm;
      if ((((l)localObject1).dmK == null) || (((l)localObject1).dmK.ecE.ecN == null)) {
        break label123;
      }
      paramString = (it)((l)localObject1).dmK.ecE.ecN;
      paramm = paramString.bGm;
      localObject2 = paramString.sCO;
      if ((paramm.equals(this.drv)) && (((String)localObject2).equals(this.idQ)) && (this.vfC == paramString.offset)) {
        break label128;
      }
    }
    label123:
    do
    {
      boolean bool;
      do
      {
        return;
        paramString = null;
        break;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          cBD();
          return;
        }
        if ((((l)localObject1).dmK != null) && (((l)localObject1).dmK.ecF.ecN != null)) {}
        for (paramString = (iu)((l)localObject1).dmK.ecF.ecN; (paramString == null) || (paramString.sCU == null) || (paramString.sCU.ret != 0); paramString = null)
        {
          cBD();
          return;
        }
        localObject1 = paramString.sCV;
        bool = paramString.sCW;
      } while (!paramm.equals(this.drv));
      this.vfx = false;
      this.vfC += ((List)localObject1).size();
      if (cBE())
      {
        if (this.vfo.size() < this.vfn.size())
        {
          bK(paramm, true);
          return;
        }
        if (this.vfo.size() > this.vfn.size()) {
          break label435;
        }
      }
      if (cBF()) {
        this.vfw = bool;
      }
    } while (cBG());
    label128:
    paramString = ((List)localObject1).iterator();
    label435:
    label444:
    for (;;)
    {
      if (paramString.hasNext())
      {
        paramm = (is)paramString.next();
        localObject1 = paramm.sCR;
        if (!bk.bl(((iv)localObject1).sCP))
        {
          localObject2 = this.vfn.iterator();
          com.tencent.mm.ai.a.c localc;
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localc = (com.tencent.mm.ai.a.c)((Iterator)localObject2).next();
          } while (!((iv)localObject1).sCP.equals(localc.field_bizChatServId));
        }
      }
      else
      {
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label444;
          }
          this.vfo.add(paramm);
          break;
          nh(true);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI.a
 * JD-Core Version:    0.7.0.1
 */