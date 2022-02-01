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
import com.tencent.mm.cd.a;
import com.tencent.mm.g.b.a.dp;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class SnsStoryHeaderView
  extends FrameLayout
  implements l.b
{
  public boolean aJO;
  public boolean dkt;
  private boolean dzo;
  private List<String> gYI;
  private View mZJ;
  private int rHn;
  private String sessionId;
  private String wQb;
  private StoryAvatarDotsView xWA;
  private TextView xWB;
  private TextView xWC;
  private int xWD;
  private int xWE;
  private int xWF;
  private String xWG;
  private int xWH;
  private a xWI;
  private int xWx;
  public boolean xWy;
  private TextView xWz;
  
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
    this.rHn = 10000;
    this.gYI = new LinkedList();
    this.sessionId = null;
    this.wQb = null;
    this.dkt = false;
    this.xWy = false;
    this.xWD = 0;
    this.xWE = 0;
    this.xWF = 0;
    this.xWG = "";
    this.xWH = 0;
    this.dzo = true;
    this.aJO = false;
    paramInt = com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.Fvg, 0);
    if (paramInt > 0) {}
    for (this.rHn = paramInt;; this.rHn = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pjB, 10000))
    {
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo().Ere == 1) {
        this.rHn = 10001;
      }
      ad.i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", new Object[] { Integer.valueOf(this.rHn), Integer.valueOf(paramInt) });
      inflate(getContext(), 2131495592, this);
      this.mZJ = findViewById(2131305058);
      this.xWz = ((TextView)findViewById(2131305070));
      this.xWA = ((StoryAvatarDotsView)findViewById(2131305056));
      this.xWB = ((TextView)findViewById(2131305059));
      this.xWC = ((TextView)findViewById(2131305060));
      this.mZJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100430);
          if (SnsStoryHeaderView.a(SnsStoryHeaderView.this) != null) {
            SnsStoryHeaderView.a(SnsStoryHeaderView.this).dCp();
          }
          h.vKh.m(1015L, 5L, 1L);
          SnsStoryHeaderView.b(SnsStoryHeaderView.this);
          AppMethodBeat.o(100430);
        }
      });
      AppMethodBeat.o(100432);
      return;
    }
  }
  
  private void dDU()
  {
    AppMethodBeat.i(100435);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dGk();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dGl();
    int i;
    int j;
    if (localList1.size() > 0)
    {
      i = localList1.size();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dGm().keySet());
      this.xWE = i;
      this.gYI.addAll(localList1);
      this.gYI.addAll(localList2);
      this.gYI.addAll(localArrayList);
      this.xWz.setText(getResources().getString(2131763983));
      fO(localList1);
      this.xWB.setTextColor(getContext().getResources().getColor(2131099660));
      j = com.tencent.mm.m.g.Zd().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
      ad.i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", new Object[] { Integer.valueOf(j) });
      if (localList1.size() <= 0) {
        break label317;
      }
      h.vKh.m(1015L, 1L, 1L);
    }
    for (;;)
    {
      if (this.gYI.size() == 0) {
        h.vKh.m(1015L, 3L, 1L);
      }
      if (i <= j) {
        break label333;
      }
      j = BackwardSupportUtil.b.g(getContext(), 4.0F);
      this.xWB.setPadding(j, 0, j, 0);
      this.xWB.setText(String.format("%s", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(100435);
      return;
      i = 0;
      break;
      label317:
      h.vKh.m(1015L, 2L, 1L);
    }
    label333:
    this.xWB.setPadding(0, 0, 0, 0);
    this.xWB.setText("");
    AppMethodBeat.o(100435);
  }
  
  private void dDV()
  {
    AppMethodBeat.i(100436);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dGk();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dGo();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dGm().keySet());
    this.gYI.addAll(localList1);
    this.gYI.addAll(localList2);
    this.gYI.addAll(localArrayList);
    this.xWz.setText(getResources().getString(2131763980));
    fO(localList1);
    AppMethodBeat.o(100436);
  }
  
  private void dDX()
  {
    AppMethodBeat.i(100439);
    ad.i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
    if (this.gYI.size() <= 0)
    {
      AppMethodBeat.o(100439);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.xWD > 0) {
      localStringBuilder.append((String)this.gYI.get(0));
    }
    int i = 1;
    while (i < this.xWD)
    {
      localStringBuilder.append("|").append((String)this.gYI.get(i));
      i += 1;
    }
    dp localdp = new dp();
    localdp.jS(this.wQb);
    this.xWG = "99_".concat(String.valueOf(System.currentTimeMillis()));
    localdp.jT(this.xWG);
    localdp.dUX = this.xWD;
    localdp.jU(localStringBuilder.toString());
    localdp.dUZ = this.xWE;
    localdp.dTX = this.xWF;
    localdp.aBj();
    this.xWH += 1;
    AppMethodBeat.o(100439);
  }
  
  private void fO(List<String> paramList)
  {
    AppMethodBeat.i(100437);
    this.xWA.setIconSize(a.fromDPToPix(getContext(), 26));
    this.xWA.setIconGap(a.fromDPToPix(getContext(), 16));
    this.xWD = 0;
    if (paramList.size() > 0)
    {
      this.xWA.setVisibility(0);
      this.xWA.setIconLayerCount(Math.min(paramList.size(), 3));
      this.xWD = this.xWA.getChildCount();
      int i = 0;
      while (i < this.xWA.getChildCount())
      {
        a.b.a(this.xWA.us(i), (String)paramList.get(i), 0.5F, false);
        this.xWA.us(i).setBackground(getResources().getDrawable(2131234145));
        this.xWA.us(i).setPadding(a.fromDPToPix(getContext(), 1), a.fromDPToPix(getContext(), 1), a.fromDPToPix(getContext(), 1), a.fromDPToPix(getContext(), 1));
        i += 1;
      }
      AppMethodBeat.o(100437);
      return;
    }
    this.xWA.setVisibility(8);
    AppMethodBeat.o(100437);
  }
  
  private void gP(boolean paramBoolean)
  {
    AppMethodBeat.i(100434);
    ad.i("MicroMsg.SnsStoryHeaderView", "updateView: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aJO) });
    if (this.aJO)
    {
      AppMethodBeat.o(100434);
      return;
    }
    this.gYI.clear();
    this.xWF = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dGn();
    if ((this.xWx != 1) || (this.rHn == 10000) || (this.rHn == 10001))
    {
      this.mZJ.setVisibility(8);
      this.xWy = false;
      if (this.gYI.size() != 0) {
        break label270;
      }
      this.mZJ.setVisibility(8);
      this.xWy = false;
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().dGm().isEmpty()) {
        break label292;
      }
      this.xWC.setVisibility(8);
      AppMethodBeat.o(100434);
      return;
      if (this.rHn == 2)
      {
        dDV();
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
        break;
      }
      h.vKh.m(1006L, 0L, 1L);
      h.vKh.m(1015L, 0L, 1L);
      dDU();
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
      break;
      label270:
      this.mZJ.setVisibility(0);
      if (!this.dkt) {
        dDW();
      }
    }
    label292:
    this.xWC.setVisibility(0);
    this.xWC.setText(String.valueOf(this.xWF));
    AppMethodBeat.o(100434);
  }
  
  public final void dDW()
  {
    AppMethodBeat.i(100438);
    if (!this.dzo)
    {
      this.mZJ.setVisibility(8);
      AppMethodBeat.o(100438);
      return;
    }
    if (this.mZJ.getVisibility() == 0)
    {
      int[] arrayOfInt = new int[2];
      this.mZJ.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] <= 0) {
        break label102;
      }
      if (!this.xWy)
      {
        this.xWy = true;
        dDX();
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", new Object[] { Boolean.valueOf(this.xWy) });
      AppMethodBeat.o(100438);
      return;
      label102:
      this.xWy = false;
    }
  }
  
  public final void dDY()
  {
    AppMethodBeat.i(100440);
    gP(false);
    if (this.gYI.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.gYI.get(0), false);
    }
    AppMethodBeat.o(100440);
  }
  
  public void setEnterObjectId(String paramString)
  {
    this.wQb = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSnsType(int paramInt)
  {
    AppMethodBeat.i(100433);
    this.xWx = paramInt;
    gP(true);
    if (this.gYI.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.gYI.get(0), true);
    }
    AppMethodBeat.o(100433);
  }
  
  public void setStoryAction(a parama)
  {
    this.xWI = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dCp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView
 * JD-Core Version:    0.7.0.1
 */