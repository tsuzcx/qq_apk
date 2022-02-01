package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.g.b.a.fd;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.deq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class SnsStoryHeaderView
  extends FrameLayout
  implements l.b
{
  public boolean aKE;
  public boolean dhO;
  private boolean dxa;
  private List<String> hzh;
  private String jDP;
  private View nCh;
  private int sPc;
  private String sessionId;
  private String ycH;
  private int zjA;
  private int zjB;
  private int zjC;
  private a zjD;
  private int zjt;
  public boolean zju;
  private TextView zjv;
  private StoryAvatarDotsView zjw;
  private TextView zjx;
  private TextView zjy;
  private int zjz;
  
  public SnsStoryHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnsStoryHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnsStoryHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100432);
    this.sPc = 10000;
    this.hzh = new LinkedList();
    this.sessionId = null;
    this.ycH = null;
    this.dhO = false;
    this.zju = false;
    this.zjz = 0;
    this.zjA = 0;
    this.zjB = 0;
    this.jDP = "";
    this.zjC = 0;
    this.dxa = true;
    this.aKE = false;
    paramInt = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GTa, 0);
    if (paramInt > 0) {}
    for (this.sPc = paramInt;; this.sPc = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pMS, 10000))
    {
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo().FOg == 1) {
        this.sPc = 10001;
      }
      ac.i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", new Object[] { Integer.valueOf(this.sPc), Integer.valueOf(paramInt) });
      inflate(getContext(), 2131495592, this);
      this.nCh = findViewById(2131305058);
      this.zjv = ((TextView)findViewById(2131305070));
      this.zjw = ((StoryAvatarDotsView)findViewById(2131305056));
      this.zjx = ((TextView)findViewById(2131305059));
      this.zjy = ((TextView)findViewById(2131305060));
      this.nCh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100430);
          if (SnsStoryHeaderView.a(SnsStoryHeaderView.this) != null) {
            SnsStoryHeaderView.a(SnsStoryHeaderView.this).dQN();
          }
          h.wUl.n(1015L, 5L, 1L);
          SnsStoryHeaderView.b(SnsStoryHeaderView.this);
          AppMethodBeat.o(100430);
        }
      });
      AppMethodBeat.o(100432);
      return;
    }
  }
  
  private void dSs()
  {
    AppMethodBeat.i(100435);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dUL();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dUM();
    int i;
    int j;
    if (localList1.size() > 0)
    {
      i = localList1.size();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dUN().keySet());
      this.zjA = i;
      this.hzh.addAll(localList1);
      this.hzh.addAll(localList2);
      this.hzh.addAll(localArrayList);
      this.zjv.setText(getResources().getString(2131763983));
      fW(localList1);
      this.zjx.setTextColor(getContext().getResources().getColor(2131099660));
      j = com.tencent.mm.m.g.ZY().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
      ac.i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", new Object[] { Integer.valueOf(j) });
      if (localList1.size() <= 0) {
        break label317;
      }
      h.wUl.n(1015L, 1L, 1L);
    }
    for (;;)
    {
      if (this.hzh.size() == 0) {
        h.wUl.n(1015L, 3L, 1L);
      }
      if (i <= j) {
        break label333;
      }
      j = BackwardSupportUtil.b.g(getContext(), 4.0F);
      this.zjx.setPadding(j, 0, j, 0);
      this.zjx.setText(String.format("%s", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(100435);
      return;
      i = 0;
      break;
      label317:
      h.wUl.n(1015L, 2L, 1L);
    }
    label333:
    this.zjx.setPadding(0, 0, 0, 0);
    this.zjx.setText("");
    AppMethodBeat.o(100435);
  }
  
  private void dSt()
  {
    AppMethodBeat.i(100436);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dUL();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dUP();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dUN().keySet());
    this.hzh.addAll(localList1);
    this.hzh.addAll(localList2);
    this.hzh.addAll(localArrayList);
    this.zjv.setText(getResources().getString(2131763980));
    fW(localList1);
    AppMethodBeat.o(100436);
  }
  
  private void dSv()
  {
    AppMethodBeat.i(100439);
    ac.i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
    if (this.hzh.size() <= 0)
    {
      AppMethodBeat.o(100439);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.zjz > 0) {
      localStringBuilder.append((String)this.hzh.get(0));
    }
    int i = 1;
    while (i < this.zjz)
    {
      localStringBuilder.append("|").append((String)this.hzh.get(i));
      i += 1;
    }
    fd localfd = new fd();
    localfd.mI(this.ycH);
    this.jDP = "99_".concat(String.valueOf(System.currentTimeMillis()));
    localfd.mJ(this.jDP);
    localfd.dWJ = this.zjz;
    localfd.mK(localStringBuilder.toString());
    localfd.dWL = this.zjA;
    localfd.dVJ = this.zjB;
    localfd.aHZ();
    this.zjC += 1;
    AppMethodBeat.o(100439);
  }
  
  private void fW(List<String> paramList)
  {
    AppMethodBeat.i(100437);
    this.zjw.setIconSize(a.fromDPToPix(getContext(), 26));
    this.zjw.setIconGap(a.fromDPToPix(getContext(), 16));
    this.zjz = 0;
    if (paramList.size() > 0)
    {
      this.zjw.setVisibility(0);
      this.zjw.setIconLayerCount(Math.min(paramList.size(), 3));
      this.zjz = this.zjw.getChildCount();
      int i = 0;
      while (i < this.zjw.getChildCount())
      {
        a.b.a(this.zjw.vk(i), (String)paramList.get(i), 0.5F, false);
        this.zjw.vk(i).setBackground(getResources().getDrawable(2131234145));
        this.zjw.vk(i).setPadding(a.fromDPToPix(getContext(), 1), a.fromDPToPix(getContext(), 1), a.fromDPToPix(getContext(), 1), a.fromDPToPix(getContext(), 1));
        i += 1;
      }
      AppMethodBeat.o(100437);
      return;
    }
    this.zjw.setVisibility(8);
    AppMethodBeat.o(100437);
  }
  
  private void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(100434);
    ac.i("MicroMsg.SnsStoryHeaderView", "updateView: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aKE) });
    if (this.aKE)
    {
      AppMethodBeat.o(100434);
      return;
    }
    this.hzh.clear();
    this.zjB = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dUO();
    if ((this.zjt != 1) || (this.sPc == 10000) || (this.sPc == 10001))
    {
      this.nCh.setVisibility(8);
      this.zju = false;
      if (this.hzh.size() != 0) {
        break label270;
      }
      this.nCh.setVisibility(8);
      this.zju = false;
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dUN().isEmpty()) {
        break label292;
      }
      this.zjy.setVisibility(8);
      AppMethodBeat.o(100434);
      return;
      if (this.sPc == 2)
      {
        dSt();
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
        break;
      }
      h.wUl.n(1006L, 0L, 1L);
      h.wUl.n(1015L, 0L, 1L);
      dSs();
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
      break;
      label270:
      this.nCh.setVisibility(0);
      if (!this.dhO) {
        dSu();
      }
    }
    label292:
    this.zjy.setVisibility(0);
    this.zjy.setText(String.valueOf(this.zjB));
    AppMethodBeat.o(100434);
  }
  
  public final void dSu()
  {
    AppMethodBeat.i(100438);
    if (!this.dxa)
    {
      this.nCh.setVisibility(8);
      AppMethodBeat.o(100438);
      return;
    }
    if (this.nCh.getVisibility() == 0)
    {
      int[] arrayOfInt = new int[2];
      this.nCh.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] <= 0) {
        break label102;
      }
      if (!this.zju)
      {
        this.zju = true;
        dSv();
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", new Object[] { Boolean.valueOf(this.zju) });
      AppMethodBeat.o(100438);
      return;
      label102:
      this.zju = false;
    }
  }
  
  public final void dSw()
  {
    AppMethodBeat.i(100440);
    hj(false);
    if (this.hzh.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.hzh.get(0), false);
    }
    AppMethodBeat.o(100440);
  }
  
  public void setEnterObjectId(String paramString)
  {
    this.ycH = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSnsType(int paramInt)
  {
    AppMethodBeat.i(100433);
    this.zjt = paramInt;
    hj(true);
    if (this.hzh.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.hzh.get(0), true);
    }
    AppMethodBeat.o(100433);
  }
  
  public void setStoryAction(a parama)
  {
    this.zjD = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dQN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView
 * JD-Core Version:    0.7.0.1
 */