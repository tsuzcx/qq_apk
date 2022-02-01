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
import com.tencent.mm.g.b.a.ge;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class SnsStoryHeaderView
  extends FrameLayout
  implements l.b
{
  private int ASV;
  public boolean ASW;
  private TextView ASX;
  private StoryAvatarDotsView ASY;
  private TextView ASZ;
  private TextView ATa;
  private int ATb;
  private int ATc;
  private int ATd;
  private int ATe;
  private a ATf;
  public boolean aMv;
  private boolean dKA;
  public boolean dus;
  private List<String> hUu;
  private String kbf;
  private View okQ;
  private String sessionId;
  private int tWx;
  private String zJR;
  
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
    this.tWx = 10000;
    this.hUu = new LinkedList();
    this.sessionId = null;
    this.zJR = null;
    this.dus = false;
    this.ASW = false;
    this.ATb = 0;
    this.ATc = 0;
    this.ATd = 0;
    this.kbf = "";
    this.ATe = 0;
    this.dKA = true;
    this.aMv = false;
    paramInt = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.Jaf, 0);
    if (paramInt > 0) {}
    for (this.tWx = paramInt;; this.tWx = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxC, 10000))
    {
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo().HSC == 1) {
        this.tWx = 10001;
      }
      ae.i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", new Object[] { Integer.valueOf(this.tWx), Integer.valueOf(paramInt) });
      inflate(getContext(), 2131495592, this);
      this.okQ = findViewById(2131305058);
      this.ASX = ((TextView)findViewById(2131305070));
      this.ASY = ((StoryAvatarDotsView)findViewById(2131305056));
      this.ASZ = ((TextView)findViewById(2131305059));
      this.ATa = ((TextView)findViewById(2131305060));
      this.okQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100430);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (SnsStoryHeaderView.a(SnsStoryHeaderView.this) != null) {
            SnsStoryHeaderView.a(SnsStoryHeaderView.this).egM();
          }
          com.tencent.mm.plugin.report.service.g.yxI.n(1015L, 5L, 1L);
          SnsStoryHeaderView.b(SnsStoryHeaderView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100430);
        }
      });
      AppMethodBeat.o(100432);
      return;
    }
  }
  
  private void eit()
  {
    AppMethodBeat.i(100435);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ekI();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ekJ();
    int i;
    int j;
    if (localList1.size() > 0)
    {
      i = localList1.size();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ekK().keySet());
      this.ATc = i;
      this.hUu.addAll(localList1);
      this.hUu.addAll(localList2);
      this.hUu.addAll(localArrayList);
      this.ASX.setText(getResources().getString(2131763983));
      gq(localList1);
      this.ASZ.setTextColor(getContext().getResources().getColor(2131099660));
      j = com.tencent.mm.n.g.acL().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
      ae.i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", new Object[] { Integer.valueOf(j) });
      if (localList1.size() <= 0) {
        break label317;
      }
      com.tencent.mm.plugin.report.service.g.yxI.n(1015L, 1L, 1L);
    }
    for (;;)
    {
      if (this.hUu.size() == 0) {
        com.tencent.mm.plugin.report.service.g.yxI.n(1015L, 3L, 1L);
      }
      if (i <= j) {
        break label333;
      }
      j = BackwardSupportUtil.b.h(getContext(), 4.0F);
      this.ASZ.setPadding(j, 0, j, 0);
      this.ASZ.setText(String.format("%s", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(100435);
      return;
      i = 0;
      break;
      label317:
      com.tencent.mm.plugin.report.service.g.yxI.n(1015L, 2L, 1L);
    }
    label333:
    this.ASZ.setPadding(0, 0, 0, 0);
    this.ASZ.setText("");
    AppMethodBeat.o(100435);
  }
  
  private void eiu()
  {
    AppMethodBeat.i(100436);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ekI();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ekM();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ekK().keySet());
    this.hUu.addAll(localList1);
    this.hUu.addAll(localList2);
    this.hUu.addAll(localArrayList);
    this.ASX.setText(getResources().getString(2131763980));
    gq(localList1);
    AppMethodBeat.o(100436);
  }
  
  private void eiw()
  {
    AppMethodBeat.i(100439);
    ae.i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
    if (this.hUu.size() <= 0)
    {
      AppMethodBeat.o(100439);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.ATb > 0) {
      localStringBuilder.append((String)this.hUu.get(0));
    }
    int i = 1;
    while (i < this.ATb)
    {
      localStringBuilder.append("|").append((String)this.hUu.get(i));
      i += 1;
    }
    ge localge = new ge();
    localge.pq(this.zJR);
    this.kbf = "99_".concat(String.valueOf(System.currentTimeMillis()));
    localge.pr(this.kbf);
    localge.eoI = this.ATb;
    localge.pt(localStringBuilder.toString());
    localge.eoK = this.ATc;
    localge.enI = this.ATd;
    localge.aLH();
    this.ATe += 1;
    AppMethodBeat.o(100439);
  }
  
  private void gq(List<String> paramList)
  {
    AppMethodBeat.i(100437);
    this.ASY.setIconSize(com.tencent.mm.cb.a.fromDPToPix(getContext(), 26));
    this.ASY.setIconGap(com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    this.ATb = 0;
    if (paramList.size() > 0)
    {
      this.ASY.setVisibility(0);
      this.ASY.setIconLayerCount(Math.min(paramList.size(), 3));
      this.ATb = this.ASY.getChildCount();
      int i = 0;
      while (i < this.ASY.getChildCount())
      {
        a.b.a(this.ASY.vV(i), (String)paramList.get(i), 0.5F, false);
        this.ASY.vV(i).setBackground(getResources().getDrawable(2131234145));
        this.ASY.vV(i).setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1));
        i += 1;
      }
      AppMethodBeat.o(100437);
      return;
    }
    this.ASY.setVisibility(8);
    AppMethodBeat.o(100437);
  }
  
  private void hr(boolean paramBoolean)
  {
    AppMethodBeat.i(100434);
    ae.i("MicroMsg.SnsStoryHeaderView", "updateView: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aMv) });
    if (this.aMv)
    {
      AppMethodBeat.o(100434);
      return;
    }
    this.hUu.clear();
    this.ATd = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ekL();
    if ((this.ASV != 1) || (this.tWx == 10000) || (this.tWx == 10001))
    {
      this.okQ.setVisibility(8);
      this.ASW = false;
      if (this.hUu.size() != 0) {
        break label270;
      }
      this.okQ.setVisibility(8);
      this.ASW = false;
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ekK().isEmpty()) {
        break label292;
      }
      this.ATa.setVisibility(8);
      AppMethodBeat.o(100434);
      return;
      if (this.tWx == 2)
      {
        eiu();
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
        break;
      }
      com.tencent.mm.plugin.report.service.g.yxI.n(1006L, 0L, 1L);
      com.tencent.mm.plugin.report.service.g.yxI.n(1015L, 0L, 1L);
      eit();
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
      break;
      label270:
      this.okQ.setVisibility(0);
      if (!this.dus) {
        eiv();
      }
    }
    label292:
    this.ATa.setVisibility(0);
    this.ATa.setText(String.valueOf(this.ATd));
    AppMethodBeat.o(100434);
  }
  
  public final void eiv()
  {
    AppMethodBeat.i(100438);
    if (!this.dKA)
    {
      this.okQ.setVisibility(8);
      AppMethodBeat.o(100438);
      return;
    }
    if (this.okQ.getVisibility() == 0)
    {
      int[] arrayOfInt = new int[2];
      this.okQ.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] <= 0) {
        break label102;
      }
      if (!this.ASW)
      {
        this.ASW = true;
        eiw();
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", new Object[] { Boolean.valueOf(this.ASW) });
      AppMethodBeat.o(100438);
      return;
      label102:
      this.ASW = false;
    }
  }
  
  public final void eix()
  {
    AppMethodBeat.i(100440);
    hr(false);
    if (this.hUu.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.hUu.get(0), false);
    }
    AppMethodBeat.o(100440);
  }
  
  public void setEnterObjectId(String paramString)
  {
    this.zJR = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSnsType(int paramInt)
  {
    AppMethodBeat.i(100433);
    this.ASV = paramInt;
    hr(true);
    if (this.hUu.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.hUu.get(0), true);
    }
    AppMethodBeat.o(100433);
  }
  
  public void setStoryAction(a parama)
  {
    this.ATf = parama;
  }
  
  public static abstract interface a
  {
    public abstract void egM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView
 * JD-Core Version:    0.7.0.1
 */