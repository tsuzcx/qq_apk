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
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.dkd;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class SnsStoryHeaderView
  extends FrameLayout
  implements l.b
{
  private int ABA;
  private int ABB;
  private int ABC;
  private int ABD;
  private a ABE;
  private int ABu;
  public boolean ABv;
  private TextView ABw;
  private StoryAvatarDotsView ABx;
  private TextView ABy;
  private TextView ABz;
  public boolean aMv;
  private boolean dJm;
  public boolean dtm;
  private List<String> hRC;
  private String jXQ;
  private View oeQ;
  private String sessionId;
  private int tLG;
  private String zsC;
  
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
    this.tLG = 10000;
    this.hRC = new LinkedList();
    this.sessionId = null;
    this.zsC = null;
    this.dtm = false;
    this.ABv = false;
    this.ABA = 0;
    this.ABB = 0;
    this.ABC = 0;
    this.jXQ = "";
    this.ABD = 0;
    this.dJm = true;
    this.aMv = false;
    paramInt = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IFF, 0);
    if (paramInt > 0) {}
    for (this.tLG = paramInt;; this.tLG = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqP, 10000))
    {
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo().HyR == 1) {
        this.tLG = 10001;
      }
      ad.i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", new Object[] { Integer.valueOf(this.tLG), Integer.valueOf(paramInt) });
      inflate(getContext(), 2131495592, this);
      this.oeQ = findViewById(2131305058);
      this.ABw = ((TextView)findViewById(2131305070));
      this.ABx = ((StoryAvatarDotsView)findViewById(2131305056));
      this.ABy = ((TextView)findViewById(2131305059));
      this.ABz = ((TextView)findViewById(2131305060));
      this.oeQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100430);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (SnsStoryHeaderView.a(SnsStoryHeaderView.this) != null) {
            SnsStoryHeaderView.a(SnsStoryHeaderView.this).edf();
          }
          com.tencent.mm.plugin.report.service.g.yhR.n(1015L, 5L, 1L);
          SnsStoryHeaderView.b(SnsStoryHeaderView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100430);
        }
      });
      AppMethodBeat.o(100432);
      return;
    }
  }
  
  private void eeM()
  {
    AppMethodBeat.i(100435);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().eha();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ehb();
    int i;
    int j;
    if (localList1.size() > 0)
    {
      i = localList1.size();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ehc().keySet());
      this.ABB = i;
      this.hRC.addAll(localList1);
      this.hRC.addAll(localList2);
      this.hRC.addAll(localArrayList);
      this.ABw.setText(getResources().getString(2131763983));
      gh(localList1);
      this.ABy.setTextColor(getContext().getResources().getColor(2131099660));
      j = com.tencent.mm.n.g.acA().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
      ad.i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", new Object[] { Integer.valueOf(j) });
      if (localList1.size() <= 0) {
        break label317;
      }
      com.tencent.mm.plugin.report.service.g.yhR.n(1015L, 1L, 1L);
    }
    for (;;)
    {
      if (this.hRC.size() == 0) {
        com.tencent.mm.plugin.report.service.g.yhR.n(1015L, 3L, 1L);
      }
      if (i <= j) {
        break label333;
      }
      j = BackwardSupportUtil.b.g(getContext(), 4.0F);
      this.ABy.setPadding(j, 0, j, 0);
      this.ABy.setText(String.format("%s", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(100435);
      return;
      i = 0;
      break;
      label317:
      com.tencent.mm.plugin.report.service.g.yhR.n(1015L, 2L, 1L);
    }
    label333:
    this.ABy.setPadding(0, 0, 0, 0);
    this.ABy.setText("");
    AppMethodBeat.o(100435);
  }
  
  private void eeN()
  {
    AppMethodBeat.i(100436);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().eha();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ehe();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ehc().keySet());
    this.hRC.addAll(localList1);
    this.hRC.addAll(localList2);
    this.hRC.addAll(localArrayList);
    this.ABw.setText(getResources().getString(2131763980));
    gh(localList1);
    AppMethodBeat.o(100436);
  }
  
  private void eeP()
  {
    AppMethodBeat.i(100439);
    ad.i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
    if (this.hRC.size() <= 0)
    {
      AppMethodBeat.o(100439);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.ABA > 0) {
      localStringBuilder.append((String)this.hRC.get(0));
    }
    int i = 1;
    while (i < this.ABA)
    {
      localStringBuilder.append("|").append((String)this.hRC.get(i));
      i += 1;
    }
    gc localgc = new gc();
    localgc.oV(this.zsC);
    this.jXQ = "99_".concat(String.valueOf(System.currentTimeMillis()));
    localgc.oW(this.jXQ);
    localgc.emZ = this.ABA;
    localgc.oX(localStringBuilder.toString());
    localgc.enb = this.ABB;
    localgc.ema = this.ABC;
    localgc.aLk();
    this.ABD += 1;
    AppMethodBeat.o(100439);
  }
  
  private void gh(List<String> paramList)
  {
    AppMethodBeat.i(100437);
    this.ABx.setIconSize(com.tencent.mm.cc.a.fromDPToPix(getContext(), 26));
    this.ABx.setIconGap(com.tencent.mm.cc.a.fromDPToPix(getContext(), 16));
    this.ABA = 0;
    if (paramList.size() > 0)
    {
      this.ABx.setVisibility(0);
      this.ABx.setIconLayerCount(Math.min(paramList.size(), 3));
      this.ABA = this.ABx.getChildCount();
      int i = 0;
      while (i < this.ABx.getChildCount())
      {
        a.b.a(this.ABx.vQ(i), (String)paramList.get(i), 0.5F, false);
        this.ABx.vQ(i).setBackground(getResources().getDrawable(2131234145));
        this.ABx.vQ(i).setPadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 1), com.tencent.mm.cc.a.fromDPToPix(getContext(), 1), com.tencent.mm.cc.a.fromDPToPix(getContext(), 1), com.tencent.mm.cc.a.fromDPToPix(getContext(), 1));
        i += 1;
      }
      AppMethodBeat.o(100437);
      return;
    }
    this.ABx.setVisibility(8);
    AppMethodBeat.o(100437);
  }
  
  private void hq(boolean paramBoolean)
  {
    AppMethodBeat.i(100434);
    ad.i("MicroMsg.SnsStoryHeaderView", "updateView: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aMv) });
    if (this.aMv)
    {
      AppMethodBeat.o(100434);
      return;
    }
    this.hRC.clear();
    this.ABC = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ehd();
    if ((this.ABu != 1) || (this.tLG == 10000) || (this.tLG == 10001))
    {
      this.oeQ.setVisibility(8);
      this.ABv = false;
      if (this.hRC.size() != 0) {
        break label270;
      }
      this.oeQ.setVisibility(8);
      this.ABv = false;
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ehc().isEmpty()) {
        break label292;
      }
      this.ABz.setVisibility(8);
      AppMethodBeat.o(100434);
      return;
      if (this.tLG == 2)
      {
        eeN();
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
        break;
      }
      com.tencent.mm.plugin.report.service.g.yhR.n(1006L, 0L, 1L);
      com.tencent.mm.plugin.report.service.g.yhR.n(1015L, 0L, 1L);
      eeM();
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
      break;
      label270:
      this.oeQ.setVisibility(0);
      if (!this.dtm) {
        eeO();
      }
    }
    label292:
    this.ABz.setVisibility(0);
    this.ABz.setText(String.valueOf(this.ABC));
    AppMethodBeat.o(100434);
  }
  
  public final void eeO()
  {
    AppMethodBeat.i(100438);
    if (!this.dJm)
    {
      this.oeQ.setVisibility(8);
      AppMethodBeat.o(100438);
      return;
    }
    if (this.oeQ.getVisibility() == 0)
    {
      int[] arrayOfInt = new int[2];
      this.oeQ.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] <= 0) {
        break label102;
      }
      if (!this.ABv)
      {
        this.ABv = true;
        eeP();
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", new Object[] { Boolean.valueOf(this.ABv) });
      AppMethodBeat.o(100438);
      return;
      label102:
      this.ABv = false;
    }
  }
  
  public final void eeQ()
  {
    AppMethodBeat.i(100440);
    hq(false);
    if (this.hRC.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.hRC.get(0), false);
    }
    AppMethodBeat.o(100440);
  }
  
  public void setEnterObjectId(String paramString)
  {
    this.zsC = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSnsType(int paramInt)
  {
    AppMethodBeat.i(100433);
    this.ABu = paramInt;
    hq(true);
    if (this.hRC.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.hRC.get(0), true);
    }
    AppMethodBeat.o(100433);
  }
  
  public void setStoryAction(a parama)
  {
    this.ABE = parama;
  }
  
  public static abstract interface a
  {
    public abstract void edf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView
 * JD-Core Version:    0.7.0.1
 */