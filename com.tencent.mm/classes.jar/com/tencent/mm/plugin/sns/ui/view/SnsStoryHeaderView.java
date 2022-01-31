package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.k.b;
import com.tencent.mm.plugin.story.api.k.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class SnsStoryHeaderView
  extends FrameLayout
  implements k.b
{
  private boolean cIy;
  private String cpW;
  public boolean cvo;
  private List<String> fxt;
  private View jXt;
  private String rnO;
  private int sml;
  private int smm;
  public boolean smn;
  private TextView smo;
  private StoryAvatarDotsView smp;
  private TextView smq;
  private TextView smr;
  private int sms;
  private int smt;
  private int smu;
  private String smv;
  private int smw;
  private SnsStoryHeaderView.a smx;
  
  public SnsStoryHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnsStoryHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40423);
    this.smm = 10000;
    this.fxt = new LinkedList();
    this.cpW = null;
    this.rnO = null;
    this.cvo = false;
    this.smn = false;
    this.sms = 0;
    this.smt = 0;
    this.smu = 0;
    this.smv = "";
    this.smw = 0;
    this.cIy = true;
    paramInt = com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yLK, 0);
    if (paramInt > 0) {}
    for (this.smm = paramInt;; this.smm = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSh, 10000))
    {
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo().xSO == 1) {
        this.smm = 10001;
      }
      ab.i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", new Object[] { Integer.valueOf(this.smm), Integer.valueOf(paramInt) });
      inflate(getContext(), 2130970867, this);
      this.jXt = findViewById(2131828087);
      this.smo = ((TextView)findViewById(2131828091));
      this.smp = ((StoryAvatarDotsView)findViewById(2131828090));
      this.smq = ((TextView)findViewById(2131828089));
      this.smr = ((TextView)findViewById(2131828092));
      this.jXt.setOnClickListener(new SnsStoryHeaderView.1(this));
      AppMethodBeat.o(40423);
      return;
    }
  }
  
  private void cxB()
  {
    AppMethodBeat.i(40430);
    ab.i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
    if (this.fxt.size() <= 0)
    {
      AppMethodBeat.o(40430);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.sms > 0) {
      localStringBuilder.append((String)this.fxt.get(0));
    }
    int i = 1;
    while (i < this.sms)
    {
      localStringBuilder.append("|").append((String)this.fxt.get(i));
      i += 1;
    }
    be localbe = new be();
    localbe.gu(this.rnO);
    this.smv = "99_".concat(String.valueOf(System.currentTimeMillis()));
    localbe.gv(this.smv);
    localbe.cWR = this.sms;
    localbe.gw(localStringBuilder.toString());
    localbe.cWT = this.smt;
    localbe.cVW = this.smu;
    localbe.ake();
    this.smw += 1;
    AppMethodBeat.o(40430);
  }
  
  private void cxx()
  {
    AppMethodBeat.i(40425);
    this.fxt.clear();
    this.smu = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().czx();
    if ((this.sml != 1) || (this.smm == 10000) || (this.smm == 10001))
    {
      this.jXt.setVisibility(8);
      this.smn = false;
      if (this.fxt.size() != 0) {
        break label227;
      }
      this.jXt.setVisibility(8);
      this.smn = false;
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().czw().isEmpty()) {
        break label249;
      }
      this.smr.setVisibility(8);
      AppMethodBeat.o(40425);
      return;
      if (this.smm == 2)
      {
        cxz();
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
        break;
      }
      h.qsU.j(1006L, 0L, 1L);
      h.qsU.j(1015L, 0L, 1L);
      cxy();
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
      break;
      label227:
      this.jXt.setVisibility(0);
      if (!this.cvo) {
        cxA();
      }
    }
    label249:
    this.smr.setVisibility(0);
    this.smr.setText(String.valueOf(this.smu));
    AppMethodBeat.o(40425);
  }
  
  private void cxy()
  {
    AppMethodBeat.i(40426);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().czu();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().czv();
    int i;
    int j;
    if (localList1.size() > 0)
    {
      i = localList1.size();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().czw().keySet());
      this.smt = i;
      this.fxt.addAll(localList1);
      this.fxt.addAll(localList2);
      this.fxt.addAll(localArrayList);
      this.smo.setText(getResources().getString(2131303966));
      dw(localList1);
      this.smq.setTextColor(getContext().getResources().getColor(2131689483));
      j = com.tencent.mm.m.g.Nq().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
      ab.i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", new Object[] { Integer.valueOf(j) });
      if (localList1.size() <= 0) {
        break label319;
      }
      h.qsU.j(1015L, 1L, 1L);
    }
    for (;;)
    {
      if (this.fxt.size() == 0) {
        h.qsU.j(1015L, 3L, 1L);
      }
      if (i <= j) {
        break label335;
      }
      j = BackwardSupportUtil.b.b(getContext(), 4.0F);
      this.smq.setPadding(j, 0, j, 0);
      this.smq.setText(String.format("%s", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(40426);
      return;
      i = 0;
      break;
      label319:
      h.qsU.j(1015L, 2L, 1L);
    }
    label335:
    this.smq.setPadding(0, 0, 0, 0);
    this.smq.setText("");
    AppMethodBeat.o(40426);
  }
  
  private void cxz()
  {
    AppMethodBeat.i(40427);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().czu();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().czy();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().czw().keySet());
    this.fxt.addAll(localList1);
    this.fxt.addAll(localList2);
    this.fxt.addAll(localArrayList);
    this.smo.setText(getResources().getString(2131303963));
    dw(localList1);
    AppMethodBeat.o(40427);
  }
  
  private void dw(List<String> paramList)
  {
    AppMethodBeat.i(40428);
    this.smp.setIconSize(com.tencent.mm.cb.a.fromDPToPix(getContext(), 26));
    this.smp.setIconGap(com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    this.sms = 0;
    if (paramList.size() > 0)
    {
      this.smp.setVisibility(0);
      this.smp.setIconLayerCount(Math.min(paramList.size(), 3));
      this.sms = this.smp.getChildCount();
      int i = 0;
      while (i < this.smp.getChildCount())
      {
        a.b.a(this.smp.pU(i), (String)paramList.get(i), 0.5F, false);
        this.smp.pU(i).setBackground(getResources().getDrawable(2130840424));
        this.smp.pU(i).setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1));
        i += 1;
      }
      AppMethodBeat.o(40428);
      return;
    }
    this.smp.setVisibility(8);
    AppMethodBeat.o(40428);
  }
  
  public final void cxA()
  {
    AppMethodBeat.i(40429);
    if (!this.cIy)
    {
      this.jXt.setVisibility(8);
      AppMethodBeat.o(40429);
      return;
    }
    if (this.jXt.getVisibility() == 0)
    {
      int[] arrayOfInt = new int[2];
      this.jXt.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] <= 0) {
        break label102;
      }
      if (!this.smn)
      {
        this.smn = true;
        cxB();
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", new Object[] { Boolean.valueOf(this.smn) });
      AppMethodBeat.o(40429);
      return;
      label102:
      this.smn = false;
    }
  }
  
  public final void cxC()
  {
    AppMethodBeat.i(40431);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(40422);
        SnsStoryHeaderView.d(SnsStoryHeaderView.this);
        if (SnsStoryHeaderView.e(SnsStoryHeaderView.this).size() > 0) {
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)SnsStoryHeaderView.e(SnsStoryHeaderView.this).get(0), false);
        }
        AppMethodBeat.o(40422);
      }
    });
    AppMethodBeat.o(40431);
  }
  
  public void setEnterObjectId(String paramString)
  {
    this.rnO = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.cpW = paramString;
  }
  
  public void setSnsType(int paramInt)
  {
    AppMethodBeat.i(40424);
    this.sml = paramInt;
    cxx();
    if (this.fxt.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.fxt.get(0), true);
    }
    AppMethodBeat.o(40424);
  }
  
  public void setStoryAction(SnsStoryHeaderView.a parama)
  {
    this.smx = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView
 * JD-Core Version:    0.7.0.1
 */