package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.Time;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.textstatus.a.b;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.a.x;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.an;
import com.tencent.mm.plugin.textstatus.proto.t;
import com.tencent.mm.plugin.textstatus.third.i;
import com.tencent.mm.plugin.textstatus.third.j;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(32)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDetailActivity;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivMask", "Landroid/view/View;", "getIvMask", "()Landroid/view/View;", "setIvMask", "(Landroid/view/View;)V", "lastSetThirdTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getLastSetThirdTopicInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "setLastSetThirdTopicInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)V", "layoutThirdContainer", "Landroid/widget/FrameLayout;", "getLayoutThirdContainer", "()Landroid/widget/FrameLayout;", "setLayoutThirdContainer", "(Landroid/widget/FrameLayout;)V", "layoutThirdThumb", "getLayoutThirdThumb", "setLayoutThirdThumb", "layoutVideo", "getLayoutVideo", "setLayoutVideo", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "thirdBack", "Lcom/tencent/mm/ui/widget/IPullDownView;", "getThirdBack", "()Lcom/tencent/mm/ui/widget/IPullDownView;", "setThirdBack", "(Lcom/tencent/mm/ui/widget/IPullDownView;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;)V", "checkCurThirdBackValid", "", "topicInfo", "destroyCustomPartsManual", "", "destroyThirdBackManual", "destroyVideo", "doMoreClick", "getCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "getLayoutId", "", "sourceId", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "handleThirdBack", "handleThirdThumb", "handleVideo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pauseThirdPreview", "pauseVideo", "playThirdPreview", "playVideo", "updateMask", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusDetailActivity
  extends MMActivity
  implements com.tencent.mm.am.h
{
  public static final TextStatusDetailActivity.a Txi;
  private MMTPEffectVideoLayout Goz;
  public com.tencent.mm.plugin.textstatus.h.f.b Tmb;
  private TextStatusTopicInfo TvA;
  private FrameLayout Tvm;
  private FrameLayout Tvo;
  private FrameLayout Tvs;
  private com.tencent.mm.ui.widget.b Tvz;
  public com.tencent.mm.plugin.textstatus.f.e TwP;
  private View TwR;
  private w psR;
  
  static
  {
    AppMethodBeat.i(291690);
    Txi = new TextStatusDetailActivity.a((byte)0);
    AppMethodBeat.o(291690);
  }
  
  private com.tencent.mm.ui.widget.b N(String paramString, List<? extends TextStatusJumpInfo> paramList)
  {
    localObject2 = null;
    AppMethodBeat.i(291639);
    kotlin.g.b.s.u(paramString, "sourceId");
    com.tencent.mm.plugin.textstatus.proto.l locall = new com.tencent.mm.plugin.textstatus.proto.l();
    locall.nDl = 0;
    locall.ToO = 3;
    locall.ToQ = hIG().field_CreateTime;
    try
    {
      localFrameLayout = this.Tvo;
      if (localFrameLayout != null) {
        break label68;
      }
      localObject1 = localObject2;
    }
    finally
    {
      for (;;)
      {
        FrameLayout localFrameLayout;
        Object localObject1 = localObject2;
      }
    }
    AppMethodBeat.o(291639);
    return localObject1;
    label68:
    if (paramList == null)
    {
      paramList = null;
      label74:
      localObject1 = i.TuX;
      if (paramList != null) {
        break label123;
      }
    }
    label123:
    for (localObject1 = null;; localObject1 = paramList.jumpType)
    {
      o localo = i.bec((String)localObject1);
      localObject1 = localObject2;
      if (localo == null) {
        break;
      }
      localObject1 = localo.a(paramString, localFrameLayout, paramList, locall);
      break;
      paramList = j.lu(paramList);
      break label74;
    }
  }
  
  private static final void a(TextStatusDetailActivity paramTextStatusDetailActivity, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(291672);
    kotlin.g.b.s.u(paramTextStatusDetailActivity, "this$0");
    params.a(a.e.TdG, paramTextStatusDetailActivity.getResources().getColor(a.b.Red), (CharSequence)paramTextStatusDetailActivity.getString(a.h.TfV));
    AppMethodBeat.o(291672);
  }
  
  private static final void a(TextStatusDetailActivity paramTextStatusDetailActivity, String paramString, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(291685);
    kotlin.g.b.s.u(paramTextStatusDetailActivity, "this$0");
    if (paramMenuItem.getItemId() == a.e.TdG)
    {
      paramMenuItem = (Context)paramTextStatusDetailActivity.getContext();
      paramTextStatusDetailActivity.getResources().getString(a.h.Tgd);
      paramTextStatusDetailActivity.psR = com.tencent.mm.ui.base.k.a(paramMenuItem, paramTextStatusDetailActivity.getResources().getString(a.h.Tgd), false, null);
      kotlin.g.b.s.s(paramString, "statusId");
      paramString = new com.tencent.mm.plugin.textstatus.h.a(paramString, 2);
      com.tencent.mm.kernel.h.aZW().a(paramString.getType(), (com.tencent.mm.am.h)paramTextStatusDetailActivity);
      com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
      paramString = com.tencent.mm.plugin.textstatus.i.b.Trt;
      paramTextStatusDetailActivity = paramTextStatusDetailActivity.getContext();
      kotlin.g.b.s.s(paramTextStatusDetailActivity, "context");
      com.tencent.mm.plugin.textstatus.i.b.a((Context)paramTextStatusDetailActivity, 43L, null, null, 0L, 0L, 0L, 124);
    }
    AppMethodBeat.o(291685);
  }
  
  private static final boolean a(TextStatusDetailActivity paramTextStatusDetailActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291658);
    kotlin.g.b.s.u(paramTextStatusDetailActivity, "this$0");
    paramTextStatusDetailActivity.finish();
    AppMethodBeat.o(291658);
    return false;
  }
  
  private void atK()
  {
    AppMethodBeat.i(291647);
    Object localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).hLh();
      }
    }
    AppMethodBeat.o(291647);
  }
  
  private static final boolean b(TextStatusDetailActivity paramTextStatusDetailActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291666);
    kotlin.g.b.s.u(paramTextStatusDetailActivity, "this$0");
    paramMenuItem = new com.tencent.mm.ui.tools.l((Context)paramTextStatusDetailActivity.getContext());
    paramMenuItem.Vtg = new TextStatusDetailActivity..ExternalSyntheticLambda2(paramTextStatusDetailActivity);
    paramMenuItem.GAC = new TextStatusDetailActivity..ExternalSyntheticLambda3(paramTextStatusDetailActivity, paramTextStatusDetailActivity.hIG().field_StatusID);
    paramMenuItem.jDd();
    AppMethodBeat.o(291666);
    return true;
  }
  
  private void hIC()
  {
    AppMethodBeat.i(291628);
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.etM();
    }
    localb = this.Tvz;
    if (localb != null) {
      localb.onPostClose();
    }
    AppMethodBeat.o(291628);
  }
  
  private com.tencent.mm.plugin.textstatus.h.f.b hIG()
  {
    AppMethodBeat.i(291617);
    com.tencent.mm.plugin.textstatus.h.f.b localb = this.Tmb;
    if (localb != null)
    {
      AppMethodBeat.o(291617);
      return localb;
    }
    kotlin.g.b.s.bIx("info");
    AppMethodBeat.o(291617);
    return null;
  }
  
  private com.tencent.mm.plugin.textstatus.f.e hIH()
  {
    AppMethodBeat.i(291620);
    com.tencent.mm.plugin.textstatus.f.e locale = this.TwP;
    if (locale != null)
    {
      AppMethodBeat.o(291620);
      return locale;
    }
    kotlin.g.b.s.bIx("loadLogic");
    AppMethodBeat.o(291620);
    return null;
  }
  
  private void hIi()
  {
    AppMethodBeat.i(291653);
    Object localObject = this.Tvm;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = this.Tvm;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).stopAsync();
      }
    }
    localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
    }
    localObject = this.Goz;
    if (localObject != null) {
      ((MMTPEffectVideoLayout)localObject).TGP.HkF.release();
    }
    AppMethodBeat.o(291653);
  }
  
  private final void hIj()
  {
    AppMethodBeat.i(291641);
    hIC();
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.onDestroy();
    }
    this.Tvz = null;
    this.TvA = null;
    AppMethodBeat.o(291641);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.f.Tfk;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291752);
    com.tencent.mm.pluginsdk.h.w((MMActivity)this);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    setNavigationbarColor(getResources().getColor(a.b.transparent));
    setMMTitleSize(com.tencent.mm.cd.a.fromDPToPix((Context)this, 14));
    hideActionbarLine();
    setBackBtn(new TextStatusDetailActivity..ExternalSyntheticLambda1(this));
    paramBundle = getIntent().getStringExtra("username");
    Object localObject4 = getIntent().getByteArrayExtra("history_item");
    Object localObject1 = new t();
    Object localObject5 = (CharSequence)paramBundle;
    if ((localObject5 == null) || (n.bp((CharSequence)localObject5)))
    {
      i = 1;
      if (i != 0) {
        break label183;
      }
      localObject4 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      paramBundle = com.tencent.mm.plugin.textstatus.b.f.bdN(paramBundle);
    }
    for (;;)
    {
      if (paramBundle != null) {
        break label230;
      }
      finish();
      Log.e("MicroMsg.TextStatus.TextStatusDetailActivity", "err info == null");
      AppMethodBeat.o(291752);
      return;
      i = 0;
      break;
      label183:
      if (localObject4 != null)
      {
        paramBundle = new an();
        paramBundle.parseFrom((byte[])localObject4);
        ((t)localObject1).Tpr = (paramBundle.TpF + paramBundle.TpG);
        paramBundle = com.tencent.mm.plugin.textstatus.h.a.b.a(paramBundle);
      }
      else
      {
        paramBundle = null;
      }
    }
    label230:
    kotlin.g.b.s.u(paramBundle, "<set-?>");
    this.Tmb = paramBundle;
    localObject4 = com.tencent.mm.plugin.textstatus.f.f.Tmq;
    localObject4 = x.hFM();
    kotlin.g.b.s.s(localObject4, "defDetail()");
    localObject4 = com.tencent.mm.plugin.textstatus.f.f.c((x)localObject4);
    kotlin.g.b.s.u(localObject4, "<set-?>");
    this.TwP = ((com.tencent.mm.plugin.textstatus.f.e)localObject4);
    localObject4 = hIH();
    localObject5 = getContentView();
    kotlin.g.b.s.s(localObject5, "contentView");
    ((com.tencent.mm.plugin.textstatus.f.e)localObject4).g((View)localObject5);
    hIH().bO((kotlin.g.a.a)TextStatusDetailActivity.b.Txj);
    localObject4 = hIH();
    localObject5 = paramBundle.field_UserName;
    kotlin.g.b.s.s(localObject5, "info.field_UserName");
    if (!((com.tencent.mm.plugin.textstatus.f.e)localObject4).b((String)localObject5, paramBundle, (t)localObject1))
    {
      finish();
      Log.e("MicroMsg.TextStatus.TextStatusDetailActivity", "logic init fail");
      AppMethodBeat.o(291752);
      return;
    }
    this.TwR = findViewById(a.e.TcH);
    this.Tvm = ((FrameLayout)findViewById(a.e.TdB));
    this.Tvs = ((FrameLayout)findViewById(a.e.Tdx));
    this.Tvo = ((FrameLayout)findViewById(a.e.Tdw));
    localObject1 = new Time();
    ((Time)localObject1).set(paramBundle.field_CreateTime * 1000L);
    setMMTitle(com.tencent.mm.pluginsdk.platformtools.e.a((CharSequence)getContext().getString(a.h.fmt_longtime, new Object[] { com.tencent.mm.pluginsdk.platformtools.f.A((Context)getContext(), ((Time)localObject1).hour * 3600000L) }), (Time)localObject1));
    showOptionMenu(true);
    addIconOptionMenu(0, a.g.icons_outlined_more, new TextStatusDetailActivity..ExternalSyntheticLambda0(this));
    localObject1 = hIG();
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
        break label1187;
      }
      i = 1;
      label562:
      if (i == 0)
      {
        localObject1 = hIG();
        if ((localObject1 == null) || (((com.tencent.mm.plugin.textstatus.h.f.b)localObject1).hHI() != true)) {
          break label1192;
        }
        i = 1;
        label588:
        if (i == 0) {
          break label1197;
        }
      }
      localObject1 = this.TwR;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    for (;;)
    {
      try
      {
        String str = hIG().field_UserName;
        localb = hIG();
        if (localb != null)
        {
          if (localb.field_MediaType != 2) {
            continue;
          }
          localObject1 = this.Tvm;
          if (localObject1 != null) {
            ((FrameLayout)localObject1).removeAllViews();
          }
          MMTPEffectVideoLayout localMMTPEffectVideoLayout = new MMTPEffectVideoLayout((Context)this, (byte)0);
          localObject1 = new FrameLayout.LayoutParams(-1, -1);
          ((FrameLayout.LayoutParams)localObject1).gravity = 17;
          localObject4 = this.Tvm;
          if (localObject4 != null) {
            ((FrameLayout)localObject4).addView((View)localMMTPEffectVideoLayout, (ViewGroup.LayoutParams)localObject1);
          }
          localObject1 = this.Tvm;
          if (localObject1 != null) {
            ((FrameLayout)localObject1).setVisibility(0);
          }
          if (localb.field_MediaUrl != null) {
            continue;
          }
          localObject1 = "";
          if (localb.field_MediaUrl != null) {
            continue;
          }
          localObject4 = "";
          localObject5 = com.tencent.mm.plugin.textstatus.util.e.TAU;
          localObject5 = localb.field_MediaUrl;
          kotlin.g.b.s.s(localObject5, "info.field_MediaUrl");
          kotlin.g.b.s.s(str, "username");
          localObject5 = com.tencent.mm.plugin.textstatus.util.e.nm((String)localObject5, str);
          j = localb.field_mediaWidth;
          k = localb.field_mediaHeight;
          if (j > 0)
          {
            i = k;
            if (k > 0) {}
          }
          else
          {
            j = ao.mX((Context)this).width;
            i = ao.mX((Context)this).height;
          }
          localObject1 = new com.tencent.mm.plugin.thumbplayer.a.b((String)localObject1, (String)localObject5, (String)localObject4, j, i);
          ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hJv = false;
          localMMTPEffectVideoLayout.setMediaInfo((com.tencent.mm.plugin.thumbplayer.a.b)localObject1);
          localObject1 = localMMTPEffectVideoLayout.getPlayer();
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).Flr = true;
          }
          localObject1 = localMMTPEffectVideoLayout.getPlayer();
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).setLoop(true);
          }
          localMMTPEffectVideoLayout.getEffectManager().jQk();
          if (localb.hHI())
          {
            localObject1 = localMMTPEffectVideoLayout.getEffectManager().jQj();
            ((com.tencent.mm.xeffect.effect.b)localObject1).setRadius(5.0F);
            ((com.tencent.mm.xeffect.effect.b)localObject1).eC(1.0F);
          }
          this.Goz = localMMTPEffectVideoLayout;
          atK();
        }
      }
      finally
      {
        com.tencent.mm.plugin.textstatus.h.f.b localb;
        int j;
        int k;
        label1187:
        label1192:
        label1197:
        continue;
        i = 0;
        continue;
        Object localObject3 = this.Tvs;
        if (localObject3 == null) {
          continue;
        }
        ((FrameLayout)localObject3).setVisibility(8);
        continue;
        paramBundle = com.tencent.mm.plugin.textstatus.h.f.b.b(paramBundle);
        continue;
        localObject3 = this.TvA;
        if ((localObject3 == null) || (b.a((TextStatusTopicInfo)localObject3, paramBundle) != true)) {
          continue;
        }
        i = 1;
        continue;
        hIj();
        paramBundle = this.Tvo;
        if (paramBundle == null) {
          continue;
        }
        paramBundle.removeAllViews();
        paramBundle = this.Tvo;
        if (paramBundle == null) {
          continue;
        }
        paramBundle.setVisibility(8);
        AppMethodBeat.o(291752);
        return;
        i = 1;
        continue;
        i = 0;
        continue;
        if (i != 0) {
          continue;
        }
        i = 0;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
      }
      localObject1 = hIH().hHx();
      k = 0;
      localObject4 = this.Tvs;
      j = k;
      if (localObject4 != null)
      {
        ((FrameLayout)localObject4).removeAllViews();
        if ((localObject1 == null) || (((com.tencent.mm.plugin.textstatus.a.k)localObject1).d(this.Tvs) != true)) {
          continue;
        }
        i = 1;
        j = k;
        if (i != 0) {
          j = 1;
        }
      }
      if (j == 0) {
        continue;
      }
      localObject1 = this.Tvs;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setVisibility(0);
      }
      if (paramBundle != null) {
        continue;
      }
      paramBundle = null;
      if (paramBundle == null) {
        continue;
      }
      try
      {
        localObject1 = (CharSequence)paramBundle.sourceId;
        if (localObject1 == null) {
          continue;
        }
        if (!n.bp((CharSequence)localObject1)) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(291752);
        return;
      }
      if (i != 0) {
        continue;
      }
      if (this.Tvz != null) {
        continue;
      }
      i = 0;
      if (i == 0)
      {
        hIj();
        localObject1 = this.Tvo;
        if (localObject1 != null) {
          ((FrameLayout)localObject1).removeAllViews();
        }
        localObject1 = paramBundle.sourceId;
        kotlin.g.b.s.s(localObject1, "topicInfo.sourceId");
        this.Tvz = N((String)localObject1, (List)paramBundle.jumpInfos);
        this.TvA = paramBundle;
      }
      paramBundle = this.Tvo;
      if (paramBundle == null) {
        continue;
      }
      paramBundle.setVisibility(0);
      AppMethodBeat.o(291752);
      return;
      localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject1).field_MediaThumbUrl;
      break;
      i = 0;
      break label562;
      i = 0;
      break label588;
      localObject1 = this.TwR;
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        continue;
        localObject1 = localb.field_MediaUrl;
        kotlin.g.b.s.s(localObject1, "info.field_MediaUrl");
        localObject1 = ((String)localObject1).getBytes(kotlin.n.d.UTF_8);
        kotlin.g.b.s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
        localObject4 = g.getMessageDigest((byte[])localObject1);
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = "";
          continue;
          localObject5 = localb.field_MediaUrl;
          localObject4 = localObject5;
          if (localObject5 == null)
          {
            localObject4 = "";
            continue;
            hIi();
          }
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291723);
    super.onDestroy();
    hIi();
    hIH().hHu();
    hIH().hHt();
    hIj();
    com.tencent.mm.kernel.h.aZW().b(5967, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(291723);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(291761);
    super.onPause();
    hIC();
    Object localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.b((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
      }
    }
    AppMethodBeat.o(291761);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291767);
    super.onResume();
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.etL();
    }
    localb = this.Tvz;
    if (localb != null) {
      localb.etO();
    }
    atK();
    AppMethodBeat.o(291767);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(291756);
    if ((paramp instanceof com.tencent.mm.plugin.textstatus.h.a))
    {
      com.tencent.mm.kernel.h.aZW().b(((com.tencent.mm.plugin.textstatus.h.a)paramp).getType(), (com.tencent.mm.am.h)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label70;
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        finish();
      }
      paramString = this.psR;
      if (paramString != null) {
        paramString.dismiss();
      }
      AppMethodBeat.o(291756);
      return;
      label70:
      paramString = getContext();
      if (paramString != null) {
        com.tencent.mm.ui.base.k.c((Context)paramString, paramString.getString(a.h.Tgb), "", true);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setIvMask(View paramView)
  {
    this.TwR = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDetailActivity
 * JD-Core Version:    0.7.0.1
 */