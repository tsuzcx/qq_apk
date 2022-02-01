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
import com.tencent.mm.autogen.mmdata.rpt.pb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.fjk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class SnsStoryHeaderView
  extends FrameLayout
  implements l.b
{
  private int HLY;
  private String QEN;
  private StoryAvatarDotsView RLI;
  public boolean RVl;
  private TextView RVm;
  private TextView RVn;
  private TextView RVo;
  private int RVp;
  private int RVq;
  private int RVr;
  private int RVs;
  private a RVt;
  private int RcH;
  public boolean aUP;
  public boolean hJi;
  private boolean icp;
  private List<String> oxE;
  private String qYC;
  private String sessionId;
  private View yBS;
  
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
    this.HLY = 10000;
    this.oxE = new LinkedList();
    this.sessionId = null;
    this.QEN = null;
    this.hJi = false;
    this.RVl = false;
    this.RVp = 0;
    this.RVq = 0;
    this.RVr = 0;
    this.qYC = "";
    this.RVs = 0;
    this.icp = true;
    this.aUP = false;
    paramInt = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acYM, 0);
    if (paramInt > 0) {}
    for (this.HLY = paramInt;; this.HLY = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yII, 10000))
    {
      if (((e)com.tencent.mm.kernel.h.az(e.class)).getStoryUserInfo().abKd == 1) {
        this.HLY = 10001;
      }
      Log.i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", new Object[] { Integer.valueOf(this.HLY), Integer.valueOf(paramInt) });
      inflate(getContext(), b.g.sns_story_header_view, this);
      this.yBS = findViewById(b.f.sns_story_header_content);
      this.RVm = ((TextView)findViewById(b.f.sns_story_header_title));
      this.RLI = ((StoryAvatarDotsView)findViewById(b.f.sns_story_header_avatars));
      this.RVn = ((TextView)findViewById(b.f.sns_story_header_count));
      this.RVo = ((TextView)findViewById(b.f.sns_story_header_reply_unread_tv));
      this.yBS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100430);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (SnsStoryHeaderView.a(SnsStoryHeaderView.this) != null) {
            SnsStoryHeaderView.a(SnsStoryHeaderView.this).hpV();
          }
          com.tencent.mm.plugin.report.service.h.OAn.p(1015L, 5L, 1L);
          SnsStoryHeaderView.b(SnsStoryHeaderView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100430);
        }
      });
      AppMethodBeat.o(100432);
      return;
    }
  }
  
  private void def()
  {
    AppMethodBeat.i(100439);
    Log.i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
    if (this.oxE.size() <= 0)
    {
      AppMethodBeat.o(100439);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.RVp > 0) {
      localStringBuilder.append((String)this.oxE.get(0));
    }
    int i = 1;
    while (i < this.RVp)
    {
      localStringBuilder.append("|").append((String)this.oxE.get(i));
      i += 1;
    }
    pb localpb = new pb();
    localpb.wD(this.QEN);
    long l = System.currentTimeMillis();
    this.qYC = ("99_" + l);
    localpb.wE(this.qYC);
    localpb.jle = this.RVp;
    localpb.wF(localStringBuilder.toString());
    localpb.jlg = this.RVq;
    localpb.jkg = this.RVr;
    localpb.bMH();
    this.RVs += 1;
    AppMethodBeat.o(100439);
  }
  
  private void hsC()
  {
    AppMethodBeat.i(100435);
    List localList1 = ((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().huV();
    List localList2 = ((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().huW();
    int i;
    int j;
    if (localList1.size() > 0)
    {
      i = localList1.size();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().huX().keySet());
      this.RVq = i;
      this.oxE.addAll(localList1);
      this.oxE.addAll(localList2);
      this.oxE.addAll(localArrayList);
      this.RVm.setText(getResources().getString(b.j.sns_story_header_title_newer));
      lb(localList1);
      this.RVn.setTextColor(getContext().getResources().getColor(b.c.BW_0_Alpha_0_3));
      j = i.aRC().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
      Log.i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", new Object[] { Integer.valueOf(j) });
      if (localList1.size() <= 0) {
        break label319;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(1015L, 1L, 1L);
    }
    for (;;)
    {
      if (this.oxE.size() == 0) {
        com.tencent.mm.plugin.report.service.h.OAn.p(1015L, 3L, 1L);
      }
      if (i <= j) {
        break label335;
      }
      j = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 4.0F);
      this.RVn.setPadding(j, 0, j, 0);
      this.RVn.setText(String.format("%s", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(100435);
      return;
      i = 0;
      break;
      label319:
      com.tencent.mm.plugin.report.service.h.OAn.p(1015L, 2L, 1L);
    }
    label335:
    this.RVn.setPadding(0, 0, 0, 0);
    this.RVn.setText("");
    AppMethodBeat.o(100435);
  }
  
  private void hsD()
  {
    AppMethodBeat.i(100436);
    List localList1 = ((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().huV();
    List localList2 = ((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().huZ();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().huX().keySet());
    this.oxE.addAll(localList1);
    this.oxE.addAll(localList2);
    this.oxE.addAll(localArrayList);
    this.RVm.setText(getResources().getString(b.j.sns_story_header_title_all));
    lb(localList1);
    AppMethodBeat.o(100436);
  }
  
  private void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(100434);
    Log.i("MicroMsg.SnsStoryHeaderView", "updateView: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aUP) });
    if (this.aUP)
    {
      AppMethodBeat.o(100434);
      return;
    }
    this.oxE.clear();
    this.RVr = ((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().huY();
    if ((this.RcH != 1) || (this.HLY == 10000) || (this.HLY == 10001))
    {
      this.yBS.setVisibility(8);
      this.RVl = false;
      if (this.oxE.size() != 0) {
        break label270;
      }
      this.yBS.setVisibility(8);
      this.RVl = false;
    }
    for (;;)
    {
      if (!((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().huX().isEmpty()) {
        break label292;
      }
      this.RVo.setVisibility(8);
      AppMethodBeat.o(100434);
      return;
      if (this.HLY == 2)
      {
        hsD();
        ((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().a(this);
        break;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(1006L, 0L, 1L);
      com.tencent.mm.plugin.report.service.h.OAn.p(1015L, 0L, 1L);
      hsC();
      ((e)com.tencent.mm.kernel.h.az(e.class)).getContactFetcher().a(this);
      break;
      label270:
      this.yBS.setVisibility(0);
      if (!this.hJi) {
        hsE();
      }
    }
    label292:
    this.RVo.setVisibility(0);
    this.RVo.setText(String.valueOf(this.RVr));
    AppMethodBeat.o(100434);
  }
  
  private void lb(List<String> paramList)
  {
    AppMethodBeat.i(100437);
    this.RLI.setIconSize(com.tencent.mm.cd.a.fromDPToPix(getContext(), 26));
    this.RLI.setIconGap(com.tencent.mm.cd.a.fromDPToPix(getContext(), 16));
    this.RVp = 0;
    if (paramList.size() > 0)
    {
      this.RLI.setVisibility(0);
      this.RLI.setIconLayerCount(Math.min(paramList.size(), 3));
      this.RVp = this.RLI.getChildCount();
      int i = 0;
      while (i < this.RLI.getChildCount())
      {
        a.b.a(this.RLI.DS(i), (String)paramList.get(i), 0.5F, false);
        this.RLI.DS(i).setBackground(getResources().getDrawable(b.e.sns_story_avatar_bg));
        this.RLI.DS(i).setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 1), com.tencent.mm.cd.a.fromDPToPix(getContext(), 1), com.tencent.mm.cd.a.fromDPToPix(getContext(), 1), com.tencent.mm.cd.a.fromDPToPix(getContext(), 1));
        i += 1;
      }
      AppMethodBeat.o(100437);
      return;
    }
    this.RLI.setVisibility(8);
    AppMethodBeat.o(100437);
  }
  
  public final void hsE()
  {
    AppMethodBeat.i(100438);
    if (!this.icp)
    {
      this.yBS.setVisibility(8);
      AppMethodBeat.o(100438);
      return;
    }
    if (this.yBS.getVisibility() == 0)
    {
      int[] arrayOfInt = new int[2];
      this.yBS.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] <= 0) {
        break label102;
      }
      if (!this.RVl)
      {
        this.RVl = true;
        def();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", new Object[] { Boolean.valueOf(this.RVl) });
      AppMethodBeat.o(100438);
      return;
      label102:
      this.RVl = false;
    }
  }
  
  public final void hsF()
  {
    AppMethodBeat.i(100440);
    kD(false);
    if (this.oxE.size() > 0) {
      ((e)com.tencent.mm.kernel.h.az(e.class)).preloadForSnsUser((String)this.oxE.get(0), false);
    }
    AppMethodBeat.o(100440);
  }
  
  public void setEnterObjectId(String paramString)
  {
    this.QEN = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSnsType(int paramInt)
  {
    AppMethodBeat.i(100433);
    this.RcH = paramInt;
    kD(true);
    if (this.oxE.size() > 0) {
      ((e)com.tencent.mm.kernel.h.az(e.class)).preloadForSnsUser((String)this.oxE.get(0), true);
    }
    AppMethodBeat.o(100433);
  }
  
  public void setStoryAction(a parama)
  {
    this.RVt = parama;
  }
  
  public void setTopLineVisibility(int paramInt)
  {
    AppMethodBeat.i(308483);
    findViewById(b.f.sns_story_header_top_line_view).setVisibility(paramInt);
    AppMethodBeat.o(308483);
  }
  
  public static abstract interface a
  {
    public abstract void hpV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView
 * JD-Core Version:    0.7.0.1
 */