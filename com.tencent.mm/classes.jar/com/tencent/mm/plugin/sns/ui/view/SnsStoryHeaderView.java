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
import com.tencent.mm.f.b.a.mb;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.eom;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class SnsStoryHeaderView
  extends FrameLayout
  implements l.b
{
  private int BZZ;
  private int KCZ;
  private String Khd;
  private StoryAvatarDotsView LlV;
  public boolean Lsi;
  private TextView Lsj;
  private TextView Lsk;
  private TextView Lsl;
  private int Lsm;
  private int Lsn;
  private int Lso;
  private int Lsp;
  private a Lsq;
  public boolean aJQ;
  public boolean fEs;
  private boolean fWq;
  private List<String> lFX;
  private String nYA;
  private String sessionId;
  private View vpA;
  
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
    this.BZZ = 10000;
    this.lFX = new LinkedList();
    this.sessionId = null;
    this.Khd = null;
    this.fEs = false;
    this.Lsi = false;
    this.Lsm = 0;
    this.Lsn = 0;
    this.Lso = 0;
    this.nYA = "";
    this.Lsp = 0;
    this.fWq = true;
    this.aJQ = false;
    paramInt = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vxb, 0);
    if (paramInt > 0) {}
    for (this.BZZ = paramInt;; this.BZZ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvF, 10000))
    {
      if (((e)com.tencent.mm.kernel.h.ag(e.class)).getStoryUserInfo().Ure == 1) {
        this.BZZ = 10001;
      }
      Log.i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", new Object[] { Integer.valueOf(this.BZZ), Integer.valueOf(paramInt) });
      inflate(getContext(), i.g.sns_story_header_view, this);
      this.vpA = findViewById(i.f.sns_story_header_content);
      this.Lsj = ((TextView)findViewById(i.f.sns_story_header_title));
      this.LlV = ((StoryAvatarDotsView)findViewById(i.f.sns_story_header_avatars));
      this.Lsk = ((TextView)findViewById(i.f.sns_story_header_count));
      this.Lsl = ((TextView)findViewById(i.f.sns_story_header_reply_unread_tv));
      this.vpA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100430);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (SnsStoryHeaderView.a(SnsStoryHeaderView.this) != null) {
            SnsStoryHeaderView.a(SnsStoryHeaderView.this).fXB();
          }
          com.tencent.mm.plugin.report.service.h.IzE.p(1015L, 5L, 1L);
          SnsStoryHeaderView.b(SnsStoryHeaderView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100430);
        }
      });
      AppMethodBeat.o(100432);
      return;
    }
  }
  
  private void cBa()
  {
    AppMethodBeat.i(100439);
    Log.i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
    if (this.lFX.size() <= 0)
    {
      AppMethodBeat.o(100439);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.Lsm > 0) {
      localStringBuilder.append((String)this.lFX.get(0));
    }
    int i = 1;
    while (i < this.Lsm)
    {
      localStringBuilder.append("|").append((String)this.lFX.get(i));
      i += 1;
    }
    mb localmb = new mb();
    localmb.CA(this.Khd);
    long l = System.currentTimeMillis();
    this.nYA = ("99_" + l);
    localmb.CB(this.nYA);
    localmb.gSI = this.Lsm;
    localmb.CC(localStringBuilder.toString());
    localmb.gSK = this.Lsn;
    localmb.gRK = this.Lso;
    localmb.bpa();
    this.Lsp += 1;
    AppMethodBeat.o(100439);
  }
  
  private void fZo()
  {
    AppMethodBeat.i(100435);
    List localList1 = ((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().gbC();
    List localList2 = ((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().gbD();
    int i;
    int j;
    if (localList1.size() > 0)
    {
      i = localList1.size();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().gbE().keySet());
      this.Lsn = i;
      this.lFX.addAll(localList1);
      this.lFX.addAll(localList2);
      this.lFX.addAll(localArrayList);
      this.Lsj.setText(getResources().getString(i.j.sns_story_header_title_newer));
      hW(localList1);
      this.Lsk.setTextColor(getContext().getResources().getColor(i.c.BW_0_Alpha_0_3));
      j = com.tencent.mm.n.h.axc().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
      Log.i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", new Object[] { Integer.valueOf(j) });
      if (localList1.size() <= 0) {
        break label319;
      }
      com.tencent.mm.plugin.report.service.h.IzE.p(1015L, 1L, 1L);
    }
    for (;;)
    {
      if (this.lFX.size() == 0) {
        com.tencent.mm.plugin.report.service.h.IzE.p(1015L, 3L, 1L);
      }
      if (i <= j) {
        break label335;
      }
      j = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 4.0F);
      this.Lsk.setPadding(j, 0, j, 0);
      this.Lsk.setText(String.format("%s", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(100435);
      return;
      i = 0;
      break;
      label319:
      com.tencent.mm.plugin.report.service.h.IzE.p(1015L, 2L, 1L);
    }
    label335:
    this.Lsk.setPadding(0, 0, 0, 0);
    this.Lsk.setText("");
    AppMethodBeat.o(100435);
  }
  
  private void fZp()
  {
    AppMethodBeat.i(100436);
    List localList1 = ((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().gbC();
    List localList2 = ((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().gbG();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().gbE().keySet());
    this.lFX.addAll(localList1);
    this.lFX.addAll(localList2);
    this.lFX.addAll(localArrayList);
    this.Lsj.setText(getResources().getString(i.j.sns_story_header_title_all));
    hW(localList1);
    AppMethodBeat.o(100436);
  }
  
  private void hW(List<String> paramList)
  {
    AppMethodBeat.i(100437);
    this.LlV.setIconSize(com.tencent.mm.ci.a.fromDPToPix(getContext(), 26));
    this.LlV.setIconGap(com.tencent.mm.ci.a.fromDPToPix(getContext(), 16));
    this.Lsm = 0;
    if (paramList.size() > 0)
    {
      this.LlV.setVisibility(0);
      this.LlV.setIconLayerCount(Math.min(paramList.size(), 3));
      this.Lsm = this.LlV.getChildCount();
      int i = 0;
      while (i < this.LlV.getChildCount())
      {
        a.b.a(this.LlV.Dt(i), (String)paramList.get(i), 0.5F, false);
        this.LlV.Dt(i).setBackground(getResources().getDrawable(i.e.sns_story_avatar_bg));
        this.LlV.Dt(i).setPadding(com.tencent.mm.ci.a.fromDPToPix(getContext(), 1), com.tencent.mm.ci.a.fromDPToPix(getContext(), 1), com.tencent.mm.ci.a.fromDPToPix(getContext(), 1), com.tencent.mm.ci.a.fromDPToPix(getContext(), 1));
        i += 1;
      }
      AppMethodBeat.o(100437);
      return;
    }
    this.LlV.setVisibility(8);
    AppMethodBeat.o(100437);
  }
  
  private void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(100434);
    Log.i("MicroMsg.SnsStoryHeaderView", "updateView: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aJQ) });
    if (this.aJQ)
    {
      AppMethodBeat.o(100434);
      return;
    }
    this.lFX.clear();
    this.Lso = ((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().gbF();
    if ((this.KCZ != 1) || (this.BZZ == 10000) || (this.BZZ == 10001))
    {
      this.vpA.setVisibility(8);
      this.Lsi = false;
      if (this.lFX.size() != 0) {
        break label270;
      }
      this.vpA.setVisibility(8);
      this.Lsi = false;
    }
    for (;;)
    {
      if (!((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().gbE().isEmpty()) {
        break label292;
      }
      this.Lsl.setVisibility(8);
      AppMethodBeat.o(100434);
      return;
      if (this.BZZ == 2)
      {
        fZp();
        ((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().a(this);
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.p(1006L, 0L, 1L);
      com.tencent.mm.plugin.report.service.h.IzE.p(1015L, 0L, 1L);
      fZo();
      ((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().a(this);
      break;
      label270:
      this.vpA.setVisibility(0);
      if (!this.fEs) {
        fZq();
      }
    }
    label292:
    this.Lsl.setVisibility(0);
    this.Lsl.setText(String.valueOf(this.Lso));
    AppMethodBeat.o(100434);
  }
  
  public final void fZq()
  {
    AppMethodBeat.i(100438);
    if (!this.fWq)
    {
      this.vpA.setVisibility(8);
      AppMethodBeat.o(100438);
      return;
    }
    if (this.vpA.getVisibility() == 0)
    {
      int[] arrayOfInt = new int[2];
      this.vpA.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] <= 0) {
        break label102;
      }
      if (!this.Lsi)
      {
        this.Lsi = true;
        cBa();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", new Object[] { Boolean.valueOf(this.Lsi) });
      AppMethodBeat.o(100438);
      return;
      label102:
      this.Lsi = false;
    }
  }
  
  public final void fZr()
  {
    AppMethodBeat.i(100440);
    jq(false);
    if (this.lFX.size() > 0) {
      ((e)com.tencent.mm.kernel.h.ag(e.class)).preloadForSnsUser((String)this.lFX.get(0), false);
    }
    AppMethodBeat.o(100440);
  }
  
  public void setEnterObjectId(String paramString)
  {
    this.Khd = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSnsType(int paramInt)
  {
    AppMethodBeat.i(100433);
    this.KCZ = paramInt;
    jq(true);
    if (this.lFX.size() > 0) {
      ((e)com.tencent.mm.kernel.h.ag(e.class)).preloadForSnsUser((String)this.lFX.get(0), true);
    }
    AppMethodBeat.o(100433);
  }
  
  public void setStoryAction(a parama)
  {
    this.Lsq = parama;
  }
  
  public void setTopLineVisibility(int paramInt)
  {
    AppMethodBeat.i(259866);
    findViewById(i.f.sns_story_header_top_line_view).setVisibility(paramInt);
    AppMethodBeat.o(259866);
  }
  
  public static abstract interface a
  {
    public abstract void fXB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView
 * JD-Core Version:    0.7.0.1
 */