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
import com.tencent.mm.g.b.a.js;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.eel;
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
  private String DTT;
  private int FdB;
  public boolean FdC;
  private TextView FdD;
  private StoryAvatarDotsView FdE;
  private TextView FdF;
  private TextView FdG;
  private int FdH;
  private int FdI;
  private int FdJ;
  private int FdK;
  private a FdL;
  public boolean aMn;
  public boolean dLD;
  private boolean eco;
  private List<String> iPH;
  private String lem;
  private View pxo;
  private String sessionId;
  private int xnH;
  
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
    this.xnH = 10000;
    this.iPH = new LinkedList();
    this.sessionId = null;
    this.DTT = null;
    this.dLD = false;
    this.FdC = false;
    this.FdH = 0;
    this.FdI = 0;
    this.FdJ = 0;
    this.lem = "";
    this.FdK = 0;
    this.eco = true;
    this.aMn = false;
    paramInt = g.aAh().azQ().getInt(ar.a.OiL, 0);
    if (paramInt > 0) {}
    for (this.xnH = paramInt;; this.xnH = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPu, 10000))
    {
      if (((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo().NeF == 1) {
        this.xnH = 10001;
      }
      Log.i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", new Object[] { Integer.valueOf(this.xnH), Integer.valueOf(paramInt) });
      inflate(getContext(), 2131496491, this);
      this.pxo = findViewById(2131308213);
      this.FdD = ((TextView)findViewById(2131308225));
      this.FdE = ((StoryAvatarDotsView)findViewById(2131308211));
      this.FdF = ((TextView)findViewById(2131308214));
      this.FdG = ((TextView)findViewById(2131308215));
      this.pxo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100430);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (SnsStoryHeaderView.a(SnsStoryHeaderView.this) != null) {
            SnsStoryHeaderView.a(SnsStoryHeaderView.this).fjo();
          }
          com.tencent.mm.plugin.report.service.h.CyF.n(1015L, 5L, 1L);
          SnsStoryHeaderView.b(SnsStoryHeaderView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100430);
        }
      });
      AppMethodBeat.o(100432);
      return;
    }
  }
  
  private void cnl()
  {
    AppMethodBeat.i(100439);
    Log.i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
    if (this.iPH.size() <= 0)
    {
      AppMethodBeat.o(100439);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.FdH > 0) {
      localStringBuilder.append((String)this.iPH.get(0));
    }
    int i = 1;
    while (i < this.FdH)
    {
      localStringBuilder.append("|").append((String)this.iPH.get(i));
      i += 1;
    }
    js localjs = new js();
    localjs.wZ(this.DTT);
    long l = System.currentTimeMillis();
    this.lem = ("99_" + l);
    localjs.xa(this.lem);
    localjs.eSm = this.FdH;
    localjs.xb(localStringBuilder.toString());
    localjs.eSo = this.FdI;
    localjs.eRo = this.FdJ;
    localjs.bfK();
    this.FdK += 1;
    AppMethodBeat.o(100439);
  }
  
  private void fkU()
  {
    AppMethodBeat.i(100435);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().fnj();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().fnk();
    int i;
    int j;
    if (localList1.size() > 0)
    {
      i = localList1.size();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().fnl().keySet());
      this.FdI = i;
      this.iPH.addAll(localList1);
      this.iPH.addAll(localList2);
      this.iPH.addAll(localArrayList);
      this.FdD.setText(getResources().getString(2131766221));
      hn(localList1);
      this.FdF.setTextColor(getContext().getResources().getColor(2131099662));
      j = com.tencent.mm.n.h.aqJ().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
      Log.i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", new Object[] { Integer.valueOf(j) });
      if (localList1.size() <= 0) {
        break label319;
      }
      com.tencent.mm.plugin.report.service.h.CyF.n(1015L, 1L, 1L);
    }
    for (;;)
    {
      if (this.iPH.size() == 0) {
        com.tencent.mm.plugin.report.service.h.CyF.n(1015L, 3L, 1L);
      }
      if (i <= j) {
        break label335;
      }
      j = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 4.0F);
      this.FdF.setPadding(j, 0, j, 0);
      this.FdF.setText(String.format("%s", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(100435);
      return;
      i = 0;
      break;
      label319:
      com.tencent.mm.plugin.report.service.h.CyF.n(1015L, 2L, 1L);
    }
    label335:
    this.FdF.setPadding(0, 0, 0, 0);
    this.FdF.setText("");
    AppMethodBeat.o(100435);
  }
  
  private void fkV()
  {
    AppMethodBeat.i(100436);
    List localList1 = ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().fnj();
    List localList2 = ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().fnn();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().fnl().keySet());
    this.iPH.addAll(localList1);
    this.iPH.addAll(localList2);
    this.iPH.addAll(localArrayList);
    this.FdD.setText(getResources().getString(2131766218));
    hn(localList1);
    AppMethodBeat.o(100436);
  }
  
  private void hn(List<String> paramList)
  {
    AppMethodBeat.i(100437);
    this.FdE.setIconSize(com.tencent.mm.cb.a.fromDPToPix(getContext(), 26));
    this.FdE.setIconGap(com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    this.FdH = 0;
    if (paramList.size() > 0)
    {
      this.FdE.setVisibility(0);
      this.FdE.setIconLayerCount(Math.min(paramList.size(), 3));
      this.FdH = this.FdE.getChildCount();
      int i = 0;
      while (i < this.FdE.getChildCount())
      {
        a.b.a(this.FdE.zK(i), (String)paramList.get(i), 0.5F, false);
        this.FdE.zK(i).setBackground(getResources().getDrawable(2131235011));
        this.FdE.zK(i).setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1));
        i += 1;
      }
      AppMethodBeat.o(100437);
      return;
    }
    this.FdE.setVisibility(8);
    AppMethodBeat.o(100437);
  }
  
  private void is(boolean paramBoolean)
  {
    AppMethodBeat.i(100434);
    Log.i("MicroMsg.SnsStoryHeaderView", "updateView: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aMn) });
    if (this.aMn)
    {
      AppMethodBeat.o(100434);
      return;
    }
    this.iPH.clear();
    this.FdJ = ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().fnm();
    if ((this.FdB != 1) || (this.xnH == 10000) || (this.xnH == 10001))
    {
      this.pxo.setVisibility(8);
      this.FdC = false;
      if (this.iPH.size() != 0) {
        break label270;
      }
      this.pxo.setVisibility(8);
      this.FdC = false;
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().fnl().isEmpty()) {
        break label292;
      }
      this.FdG.setVisibility(8);
      AppMethodBeat.o(100434);
      return;
      if (this.xnH == 2)
      {
        fkV();
        ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
        break;
      }
      com.tencent.mm.plugin.report.service.h.CyF.n(1006L, 0L, 1L);
      com.tencent.mm.plugin.report.service.h.CyF.n(1015L, 0L, 1L);
      fkU();
      ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().a(this);
      break;
      label270:
      this.pxo.setVisibility(0);
      if (!this.dLD) {
        fkW();
      }
    }
    label292:
    this.FdG.setVisibility(0);
    this.FdG.setText(String.valueOf(this.FdJ));
    AppMethodBeat.o(100434);
  }
  
  public final void fkW()
  {
    AppMethodBeat.i(100438);
    if (!this.eco)
    {
      this.pxo.setVisibility(8);
      AppMethodBeat.o(100438);
      return;
    }
    if (this.pxo.getVisibility() == 0)
    {
      int[] arrayOfInt = new int[2];
      this.pxo.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] <= 0) {
        break label102;
      }
      if (!this.FdC)
      {
        this.FdC = true;
        cnl();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", new Object[] { Boolean.valueOf(this.FdC) });
      AppMethodBeat.o(100438);
      return;
      label102:
      this.FdC = false;
    }
  }
  
  public final void fkX()
  {
    AppMethodBeat.i(100440);
    is(false);
    if (this.iPH.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.iPH.get(0), false);
    }
    AppMethodBeat.o(100440);
  }
  
  public void setEnterObjectId(String paramString)
  {
    this.DTT = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSnsType(int paramInt)
  {
    AppMethodBeat.i(100433);
    this.FdB = paramInt;
    is(true);
    if (this.iPH.size() > 0) {
      ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser((String)this.iPH.get(0), true);
    }
    AppMethodBeat.o(100433);
  }
  
  public void setStoryAction(a parama)
  {
    this.FdL = parama;
  }
  
  public void setTopLineVisibility(int paramInt)
  {
    AppMethodBeat.i(203984);
    findViewById(2131308226).setVisibility(paramInt);
    AppMethodBeat.o(203984);
  }
  
  public static abstract interface a
  {
    public abstract void fjo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView
 * JD-Core Version:    0.7.0.1
 */