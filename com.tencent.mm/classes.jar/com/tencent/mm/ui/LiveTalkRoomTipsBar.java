package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public class LiveTalkRoomTipsBar
  extends LinearLayout
{
  private boolean FQQ;
  private RelativeLayout KuW;
  private WeImageView LCA;
  private WeImageView LCB;
  private ListView LCC;
  private ar LCt;
  private RelativeLayout LCu;
  private RelativeLayout LCv;
  private RelativeLayout LCw;
  private FrameLayout LCx;
  private TextView LCy;
  private TextView LCz;
  public Context context;
  private View mXu;
  
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204904);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(204904);
  }
  
  @TargetApi(11)
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204903);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(204903);
  }
  
  private void gae()
  {
    AppMethodBeat.i(204910);
    this.LCv.setVisibility(8);
    setVisibility(8);
    AppMethodBeat.o(204910);
  }
  
  private void initView()
  {
    AppMethodBeat.i(204906);
    inflate(getContext(), 2131496332, this);
    this.KuW = ((RelativeLayout)findViewById(2131304246));
    this.KuW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView) {}
    });
    this.LCu = ((RelativeLayout)findViewById(2131307713));
    this.LCA = ((WeImageView)findViewById(2131307712));
    this.LCA.setIconColor(0);
    this.LCy = ((TextView)findViewById(2131307718));
    this.LCw = ((RelativeLayout)findViewById(2131307710));
    this.LCv = ((RelativeLayout)findViewById(2131307719));
    this.LCx = ((FrameLayout)findViewById(2131307720));
    this.LCz = ((TextView)findViewById(2131307717));
    this.LCC = ((ListView)findViewById(2131307715));
    this.mXu = y.js(this.context).inflate(2131496333, null);
    this.LCC.addFooterView(this.mXu);
    this.LCB = ((WeImageView)findViewById(2131307714));
    setTipsBarLayout(true);
    this.LCu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204900);
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this) != null)
        {
          int i = LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).getCount();
          ad.i("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout count:%s", new Object[] { Integer.valueOf(i) });
          if (i <= 0)
          {
            ad.e("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout error, count:%d", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(204900);
            return;
          }
          if (i == 1)
          {
            paramAnonymousView = LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).ain(0);
            if (paramAnonymousView == null)
            {
              ad.e("MicroMsg.LiveTalkRoomTipsBar", "count 1, but liveTipsBar null.");
              AppMethodBeat.o(204900);
              return;
            }
            LiveTalkRoomTipsBar.this.b(paramAnonymousView);
            AppMethodBeat.o(204900);
            return;
          }
          if (LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).getVisibility() == 8)
          {
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, false);
            AppMethodBeat.o(204900);
            return;
          }
          LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
        }
        AppMethodBeat.o(204900);
      }
    });
    this.LCw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204901);
        as.aWj(LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).qsP);
        AppMethodBeat.o(204901);
      }
    });
    this.LCB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204902);
        LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
        AppMethodBeat.o(204902);
      }
    });
    AppMethodBeat.o(204906);
  }
  
  public final void b(com.tencent.mm.live.b.c.a parama)
  {
    AppMethodBeat.i(204908);
    Object localObject = new LiveConfig.a();
    if ((((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.r.a.cd(this.context)) && (!com.tencent.mm.r.a.ce(this.context)) && (!com.tencent.mm.r.a.cc(this.context))))
    {
      if (parama.field_isSender) {}
      for (int i = LiveConfig.qsH;; i = LiveConfig.qsJ)
      {
        ((LiveConfig.a)localObject).qsO = i;
        ((LiveConfig.a)localObject).thumbUrl = parama.field_thumbUrl;
        ((LiveConfig.a)localObject).qsP = parama.field_hostRoomId;
        ((LiveConfig.a)localObject).DlB = parama.field_liveId;
        ((LiveConfig.a)localObject).qud = parama.field_liveName;
        ((LiveConfig.a)localObject).fromScene = LiveConfig.qsL;
        ((LiveConfig.a)localObject).quk = parama.field_anchorUsername;
        localObject = ((LiveConfig.a)localObject).cld();
        if (!parama.field_isSender) {
          break;
        }
        ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(this.context, (LiveConfig)localObject);
        AppMethodBeat.o(204908);
        return;
      }
      f.fQa();
      ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().b(this.context, (LiveConfig)localObject);
    }
    AppMethodBeat.o(204908);
  }
  
  public final void gad()
  {
    int i = 4;
    AppMethodBeat.i(204909);
    LinkedList localLinkedList;
    Object localObject;
    if (this.LCt != null)
    {
      localLinkedList = this.LCt.LCF;
      if ((localLinkedList == null) || (localLinkedList.size() <= 0))
      {
        if (localLinkedList == null) {}
        for (localObject = "null";; localObject = "0")
        {
          ad.e("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List error:%s", new Object[] { localObject });
          gae();
          AppMethodBeat.o(204909);
          return;
        }
      }
      boolean bool1 = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving();
      boolean bool2 = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving();
      if (localLinkedList != null) {
        break label279;
      }
      localObject = "null";
      ad.i("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List size:%s, isAnchorLiving:%b, isVisitorLiving:%b", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (!bool2)) {
        break label309;
      }
      localObject = this.context.getString(2131766693, new Object[] { Integer.valueOf(localLinkedList.size()) });
      if (this.LCv.getVisibility() != 0) {
        break label297;
      }
      this.LCz.setText((CharSequence)localObject);
      localObject = this.LCC.getLayoutParams();
      if (localLinkedList.size() >= 4) {
        break label292;
      }
      i = localLinkedList.size();
      label232:
      ((ViewGroup.LayoutParams)localObject).height = ((i + 1) * com.tencent.mm.cd.a.ao(this.context, 2131165301));
      this.LCC.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.LCt.notifyDataSetChanged();
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(204909);
      return;
      label279:
      localObject = Integer.valueOf(localLinkedList.size());
      break;
      label292:
      i = 4;
      break label232;
      label297:
      this.LCy.setText((CharSequence)localObject);
      continue;
      label309:
      if (localLinkedList.size() == 1)
      {
        localObject = (com.tencent.mm.live.b.c.a)localLinkedList.get(0);
        localObject = this.context.getString(2131766692, new Object[] { ((com.tencent.mm.live.b.c.a)localObject).field_liveName });
        this.LCy.setText(k.c(this.context, (CharSequence)localObject));
        this.LCu.setVisibility(0);
        this.LCv.setVisibility(8);
      }
      else
      {
        localObject = this.context.getString(2131766694, new Object[] { Integer.valueOf(localLinkedList.size()) });
        if (this.LCv.getVisibility() == 0)
        {
          this.LCz.setText((CharSequence)localObject);
          localObject = this.LCC.getLayoutParams();
          if (localLinkedList.size() < 4) {
            i = localLinkedList.size();
          }
          ((ViewGroup.LayoutParams)localObject).height = ((i + 1) * com.tencent.mm.cd.a.ao(this.context, 2131165301));
          this.LCC.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.LCt.notifyDataSetChanged();
        }
        else
        {
          this.LCy.setText((CharSequence)localObject);
        }
      }
    }
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.FQQ = paramBoolean;
  }
  
  public void setLiveTalkRoomTipsBarAdapter(ar paramar)
  {
    AppMethodBeat.i(204905);
    this.LCt = paramar;
    if (this.LCC != null) {
      this.LCC.setAdapter(paramar);
    }
    AppMethodBeat.o(204905);
  }
  
  public void setTipsBarLayout(boolean paramBoolean)
  {
    AppMethodBeat.i(204907);
    if (paramBoolean)
    {
      this.LCu.setVisibility(0);
      this.LCv.setVisibility(8);
      gad();
      AppMethodBeat.o(204907);
      return;
    }
    this.LCu.setVisibility(8);
    this.LCv.setVisibility(0);
    gad();
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2130772173);
    this.LCx.startAnimation(localAnimation);
    AppMethodBeat.o(204907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.LiveTalkRoomTipsBar
 * JD-Core Version:    0.7.0.1
 */