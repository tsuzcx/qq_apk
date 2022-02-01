package com.tencent.mm.plugin.textstatus.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.Time;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.g;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.aa;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ak.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(32)
@c(0)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDetailActivity;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivMask", "Landroid/view/View;", "getIvMask", "()Landroid/view/View;", "setIvMask", "(Landroid/view/View;)V", "lastSetThirdTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getLastSetThirdTopicInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "setLastSetThirdTopicInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)V", "layoutThirdContainer", "Landroid/widget/FrameLayout;", "getLayoutThirdContainer", "()Landroid/widget/FrameLayout;", "setLayoutThirdContainer", "(Landroid/widget/FrameLayout;)V", "layoutThirdThumb", "getLayoutThirdThumb", "setLayoutThirdThumb", "layoutVideo", "getLayoutVideo", "setLayoutVideo", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "thirdBack", "Lcom/tencent/mm/ui/widget/IPullDownView;", "getThirdBack", "()Lcom/tencent/mm/ui/widget/IPullDownView;", "setThirdBack", "(Lcom/tencent/mm/ui/widget/IPullDownView;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;)V", "checkCurThirdBackValid", "", "topicInfo", "destroyCustomPartsManual", "", "destroyThirdBackManual", "destroyVideo", "doMoreClick", "getCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "getLayoutId", "", "sourceId", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "handleThirdBack", "handleThirdThumb", "handleVideo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pauseThirdPreview", "pauseVideo", "playThirdPreview", "playVideo", "updateMask", "Companion", "plugin-textstatus_release"})
public final class TextStatusDetailActivity
  extends MMActivity
  implements com.tencent.mm.an.i
{
  public static final TextStatusDetailActivity.a MKN;
  private MMTPEffectVideoLayout Bba;
  public com.tencent.mm.plugin.textstatus.g.e.a MCs;
  private FrameLayout MJb;
  private FrameLayout MJd;
  private FrameLayout MJg;
  private com.tencent.mm.ui.widget.b MJn;
  private TextStatusTopicInfo MJo;
  public com.tencent.mm.plugin.textstatus.e.e MKE;
  private View MKF;
  s iYE;
  
  static
  {
    AppMethodBeat.i(234826);
    MKN = new TextStatusDetailActivity.a((byte)0);
    AppMethodBeat.o(234826);
  }
  
  private com.tencent.mm.ui.widget.b F(String paramString, List<? extends TextStatusJumpInfo> paramList)
  {
    localObject2 = null;
    AppMethodBeat.i(234816);
    p.k(paramString, "sourceId");
    com.tencent.mm.plugin.textstatus.proto.d locald = new com.tencent.mm.plugin.textstatus.proto.d();
    locald.kYn = 0;
    locald.MEO = 3;
    localObject1 = this.MCs;
    if (localObject1 == null) {
      p.bGy("info");
    }
    locald.MEQ = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_CreateTime;
    try
    {
      localFrameLayout = this.MJd;
      if (localFrameLayout != null) {
        break label79;
      }
      localObject1 = localObject2;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        FrameLayout localFrameLayout;
        localObject1 = localObject2;
      }
    }
    AppMethodBeat.o(234816);
    return localObject1;
    label79:
    if (paramList != null)
    {
      paramList = com.tencent.mm.plugin.textstatus.j.e.in(paramList);
      label88:
      localObject1 = com.tencent.mm.plugin.textstatus.j.d.MIW;
      if (paramList == null) {
        break label137;
      }
    }
    label137:
    for (localObject1 = paramList.jumpType;; localObject1 = null)
    {
      com.tencent.mm.plugin.textstatus.a.m localm = com.tencent.mm.plugin.textstatus.j.d.beD((String)localObject1);
      localObject1 = localObject2;
      if (localm == null) {
        break;
      }
      localObject1 = localm.a(paramString, localFrameLayout, paramList, locald);
      break;
      paramList = null;
      break label88;
    }
  }
  
  private void Tf()
  {
    AppMethodBeat.i(234822);
    Object localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).gos();
        AppMethodBeat.o(234822);
        return;
      }
    }
    AppMethodBeat.o(234822);
  }
  
  private void gmC()
  {
    AppMethodBeat.i(234814);
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null) {
      localb.dDC();
    }
    localb = this.MJn;
    if (localb != null)
    {
      localb.onPostClose();
      AppMethodBeat.o(234814);
      return;
    }
    AppMethodBeat.o(234814);
  }
  
  private void gmq()
  {
    AppMethodBeat.i(234823);
    Object localObject = this.MJb;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = this.MJb;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).stopAsync();
      }
    }
    localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).recycle();
      }
    }
    localObject = this.Bba;
    if (localObject != null)
    {
      ((MMTPEffectVideoLayout)localObject).MUh.YIy.release();
      AppMethodBeat.o(234823);
      return;
    }
    AppMethodBeat.o(234823);
  }
  
  private final void gmr()
  {
    AppMethodBeat.i(234818);
    gmC();
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null) {
      localb.onDestroy();
    }
    this.MJn = null;
    this.MJo = null;
    AppMethodBeat.o(234818);
  }
  
  public final int getLayoutId()
  {
    return b.f.MxG;
  }
  
  @SuppressLint({"ResourceType"})
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(234813);
    com.tencent.mm.pluginsdk.h.r((MMActivity)this);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1792);
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    setNavigationbarColor(getResources().getColor(b.b.transparent));
    setMMTitleSize(com.tencent.mm.ci.a.fromDPToPix((Context)this, 14));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    paramBundle = getIntent().getStringExtra("username");
    localObject2 = getIntent().getByteArrayExtra("history_item");
    Object localObject1 = new com.tencent.mm.plugin.textstatus.proto.i();
    Object localObject3 = (CharSequence)paramBundle;
    if ((localObject3 == null) || (n.ba((CharSequence)localObject3)))
    {
      i = 1;
      if (i != 0) {
        break label204;
      }
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      paramBundle = com.tencent.mm.plugin.textstatus.b.f.bep(paramBundle);
    }
    for (;;)
    {
      if (paramBundle != null) {
        break label251;
      }
      finish();
      Log.e("MicroMsg.TextStatus.TextStatusDetailActivity", "err info == null");
      AppMethodBeat.o(234813);
      return;
      i = 0;
      break;
      label204:
      if (localObject2 != null)
      {
        paramBundle = new aa();
        paramBundle.parseFrom((byte[])localObject2);
        ((com.tencent.mm.plugin.textstatus.proto.i)localObject1).MFk = (paramBundle.MFs + paramBundle.MFt);
        paramBundle = com.tencent.mm.plugin.textstatus.g.a.b.a(paramBundle);
      }
      else
      {
        paramBundle = null;
      }
    }
    label251:
    this.MCs = paramBundle;
    localObject2 = com.tencent.mm.plugin.textstatus.e.f.MCG;
    localObject2 = r.gkT();
    p.j(localObject2, "StatusShowParam.defDetail()");
    this.MKE = com.tencent.mm.plugin.textstatus.e.f.c((r)localObject2);
    localObject2 = this.MKE;
    if (localObject2 == null) {
      p.bGy("loadLogic");
    }
    localObject3 = getContentView();
    p.j(localObject3, "contentView");
    ((com.tencent.mm.plugin.textstatus.e.e)localObject2).g((View)localObject3);
    localObject2 = this.MKE;
    if (localObject2 == null) {
      p.bGy("loadLogic");
    }
    ((com.tencent.mm.plugin.textstatus.e.e)localObject2).ag((kotlin.g.a.a)TextStatusDetailActivity.e.MKP);
    localObject2 = this.MKE;
    if (localObject2 == null) {
      p.bGy("loadLogic");
    }
    localObject3 = paramBundle.field_UserName;
    p.j(localObject3, "info.field_UserName");
    if (!((com.tencent.mm.plugin.textstatus.e.e)localObject2).b((String)localObject3, paramBundle, (com.tencent.mm.plugin.textstatus.proto.i)localObject1))
    {
      finish();
      Log.e("MicroMsg.TextStatus.TextStatusDetailActivity", "logic init fail");
      AppMethodBeat.o(234813);
      return;
    }
    this.MKF = findViewById(b.e.Mvu);
    this.MJb = ((FrameLayout)findViewById(b.e.Mwm));
    this.MJg = ((FrameLayout)findViewById(b.e.Mwi));
    this.MJd = ((FrameLayout)findViewById(b.e.Mwh));
    localObject1 = new Time();
    ((Time)localObject1).set(paramBundle.field_CreateTime * 1000L);
    setMMTitle(com.tencent.mm.pluginsdk.j.e.a((CharSequence)getContext().getString(b.h.fmt_longtime, new Object[] { com.tencent.mm.pluginsdk.j.f.x((Context)getContext(), ((Time)localObject1).hour * 3600000L) }), (Time)localObject1));
    showOptionMenu(true);
    addIconOptionMenu(0, b.g.icons_outlined_more, (MenuItem.OnMenuItemClickListener)new f(this));
    localObject1 = this.MCs;
    if (localObject1 == null) {
      p.bGy("info");
    }
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_MediaThumbUrl;
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (!n.ba((CharSequence)localObject1))) {
        break label951;
      }
      i = 1;
      label618:
      if (i == 0)
      {
        localObject1 = this.MCs;
        if (localObject1 == null) {
          p.bGy("info");
        }
        if ((localObject1 == null) || (((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).gma() != true)) {
          break label956;
        }
      }
      localObject1 = this.MKF;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    try
    {
      label670:
      localObject1 = this.MCs;
      if (localObject1 == null) {
        p.bGy("info");
      }
      str2 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_UserName;
      locala = this.MCs;
      if (locala == null) {
        p.bGy("info");
      }
      if (locala != null) {
        break label976;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str2;
        com.tencent.mm.plugin.textstatus.g.e.a locala;
        label714:
        int j;
        continue;
        String str1 = "";
        continue;
        localObject2 = "";
        continue;
        i = 0;
        continue;
        i = 1;
      }
    }
    localObject1 = this.MKE;
    if (localObject1 == null) {
      p.bGy("loadLogic");
    }
    localObject1 = ((com.tencent.mm.plugin.textstatus.e.e)localObject1).glR();
    j = 0;
    localObject2 = this.MJg;
    i = j;
    if (localObject2 != null)
    {
      ((FrameLayout)localObject2).removeAllViews();
      i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((com.tencent.mm.plugin.textstatus.a.i)localObject1).d(this.MJg) == true) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      localObject1 = this.MJg;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setVisibility(0);
      }
      label805:
      if (paramBundle == null) {
        break label1424;
      }
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.glY();
        if (paramBundle == null) {
          break label1465;
        }
        localObject1 = (CharSequence)paramBundle.sourceId;
        if (localObject1 == null) {
          break label1511;
        }
        if (!n.ba((CharSequence)localObject1)) {
          break label1429;
        }
      }
      catch (Throwable paramBundle)
      {
        AppMethodBeat.o(234813);
        return;
      }
      if (i == 0)
      {
        if (this.MJn == null)
        {
          i = 0;
          if (i == 0)
          {
            gmr();
            localObject1 = this.MJd;
            if (localObject1 != null) {
              ((FrameLayout)localObject1).removeAllViews();
            }
            localObject1 = paramBundle.sourceId;
            p.j(localObject1, "topicInfo.sourceId");
            this.MJn = F((String)localObject1, (List)paramBundle.jumpInfos);
            this.MJo = paramBundle;
          }
          paramBundle = this.MJd;
          if (paramBundle == null) {
            break label1458;
          }
          paramBundle.setVisibility(0);
          AppMethodBeat.o(234813);
          return;
          localObject1 = null;
          break;
          label951:
          i = 0;
          break label618;
          label956:
          localObject1 = this.MKF;
          if (localObject1 == null) {
            break label670;
          }
          ((View)localObject1).setVisibility(0);
          break label670;
          label976:
          if (locala.field_MediaType == 2)
          {
            localObject1 = this.MJb;
            if (localObject1 != null) {
              ((FrameLayout)localObject1).removeAllViews();
            }
            MMTPEffectVideoLayout localMMTPEffectVideoLayout = new MMTPEffectVideoLayout((Context)this, (byte)0);
            localObject1 = new FrameLayout.LayoutParams(-1, -1);
            ((FrameLayout.LayoutParams)localObject1).gravity = 17;
            localObject2 = this.MJb;
            if (localObject2 != null) {
              ((FrameLayout)localObject2).addView((View)localMMTPEffectVideoLayout, (ViewGroup.LayoutParams)localObject1);
            }
            localObject1 = this.MJb;
            if (localObject1 != null) {
              ((FrameLayout)localObject1).setVisibility(0);
            }
            if (locala.field_MediaUrl == null) {
              break label1521;
            }
            localObject1 = locala.field_MediaUrl;
            p.j(localObject1, "info.field_MediaUrl");
            localObject2 = kotlin.n.d.UTF_8;
            if (localObject1 == null)
            {
              localObject1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(234813);
              throw ((Throwable)localObject1);
            }
            localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
            p.j(localObject1, "(this as java.lang.String).getBytes(charset)");
            localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
            localObject1 = localObject2;
            if (localObject2 == null) {
              break label1521;
            }
            if (locala.field_MediaUrl == null) {
              break label1529;
            }
            localObject3 = locala.field_MediaUrl;
            localObject2 = localObject3;
            if (localObject3 == null) {
              break label1529;
            }
            localObject3 = com.tencent.mm.plugin.textstatus.k.f.MOw;
            localObject3 = locala.field_MediaUrl;
            p.j(localObject3, "info.field_MediaUrl");
            p.j(str2, "username");
            localObject3 = com.tencent.mm.plugin.textstatus.k.f.lE((String)localObject3, str2);
            j = locala.field_mediaWidth;
            int k = locala.field_mediaHeight;
            if (j > 0)
            {
              i = k;
              if (k > 0) {}
            }
            else
            {
              j = ak.kU((Context)this).width;
              i = ak.kU((Context)this).height;
            }
            localObject1 = new com.tencent.mm.plugin.thumbplayer.e.d((String)localObject1, (String)localObject3, (String)localObject2, j, i);
            ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF = false;
            localMMTPEffectVideoLayout.setMediaInfo((com.tencent.mm.plugin.thumbplayer.e.d)localObject1);
            localObject1 = localMMTPEffectVideoLayout.getPlayer();
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).ALj = true;
            }
            localObject1 = localMMTPEffectVideoLayout.getPlayer();
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).setLoop(true);
            }
            localMMTPEffectVideoLayout.getEffectManager().ikd();
            if (locala.gma())
            {
              localObject1 = localMMTPEffectVideoLayout.getEffectManager().ikc();
              ((com.tencent.mm.xeffect.effect.b)localObject1).setRadius(5.0F);
              ((com.tencent.mm.xeffect.effect.b)localObject1).ikb();
            }
            this.Bba = localMMTPEffectVideoLayout;
            Tf();
            break label714;
          }
          gmq();
          break label714;
          localObject1 = this.MJg;
          if (localObject1 == null) {
            break label805;
          }
          ((FrameLayout)localObject1).setVisibility(8);
          break label805;
          label1424:
          paramBundle = null;
          continue;
          label1429:
          i = 0;
          continue;
        }
        localObject1 = this.MJo;
        if (localObject1 == null) {
          break label1537;
        }
        if (b.a((TextStatusTopicInfo)localObject1, paramBundle) == true) {
          break label1542;
        }
        break label1537;
        label1458:
        AppMethodBeat.o(234813);
        return;
      }
      label1465:
      gmr();
      paramBundle = this.MJd;
      if (paramBundle != null) {
        paramBundle.removeAllViews();
      }
      paramBundle = this.MJd;
      if (paramBundle != null)
      {
        paramBundle.setVisibility(8);
        AppMethodBeat.o(234813);
        return;
      }
      AppMethodBeat.o(234813);
      return;
      label1511:
      i = 1;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(234812);
    super.onDestroy();
    gmq();
    com.tencent.mm.plugin.textstatus.e.e locale = this.MKE;
    if (locale == null) {
      p.bGy("loadLogic");
    }
    locale.glS();
    gmr();
    com.tencent.mm.kernel.h.aGY().b(5967, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(234812);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(234824);
    super.onPause();
    gmC();
    Object localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).pause();
        AppMethodBeat.o(234824);
        return;
      }
    }
    AppMethodBeat.o(234824);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(234825);
    super.onResume();
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null) {
      localb.dDB();
    }
    localb = this.MJn;
    if (localb != null) {
      localb.dDE();
    }
    Tf();
    AppMethodBeat.o(234825);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(234820);
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.g.a))
    {
      com.tencent.mm.kernel.h.aGY().b(((com.tencent.mm.plugin.textstatus.g.a)paramq).getType(), (com.tencent.mm.an.i)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label70;
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        finish();
      }
      paramString = this.iYE;
      if (paramString == null) {
        break;
      }
      paramString.dismiss();
      AppMethodBeat.o(234820);
      return;
      label70:
      paramString = getContext();
      if (paramString != null) {
        com.tencent.mm.ui.base.h.af((Context)paramString, paramString.getString(b.h.Myu), "");
      }
    }
    AppMethodBeat.o(234820);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setIvMask(View paramView)
  {
    this.MKF = paramView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements q.f
  {
    b(TextStatusDetailActivity paramTextStatusDetailActivity) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(232279);
      paramo.a(b.e.Mwp, this.MKO.getResources().getColor(b.b.Red), (CharSequence)this.MKO.getString(b.h.Mys));
      AppMethodBeat.o(232279);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements q.g
  {
    c(TextStatusDetailActivity paramTextStatusDetailActivity, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(236256);
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == b.e.Mwp)
      {
        paramMenuItem = this.MKO;
        Context localContext = (Context)this.MKO.getContext();
        this.MKO.getResources().getString(b.h.Myw);
        paramMenuItem.iYE = com.tencent.mm.ui.base.h.a(localContext, this.MKO.getResources().getString(b.h.Myw), false, null);
        paramMenuItem = this.MCL;
        p.j(paramMenuItem, "statusId");
        paramMenuItem = new com.tencent.mm.plugin.textstatus.g.a(paramMenuItem, 2);
        com.tencent.mm.kernel.h.aGY().a(paramMenuItem.getType(), (com.tencent.mm.an.i)this.MKO);
        com.tencent.mm.kernel.h.aGY().b((q)paramMenuItem);
        paramMenuItem = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        paramMenuItem = this.MKO.getContext();
        p.j(paramMenuItem, "context");
        com.tencent.mm.plugin.textstatus.h.a.a((Context)paramMenuItem, 43L, null, null, 12);
      }
      AppMethodBeat.o(236256);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(TextStatusDetailActivity paramTextStatusDetailActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(236328);
      this.MKO.finish();
      AppMethodBeat.o(236328);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(TextStatusDetailActivity paramTextStatusDetailActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(238490);
      paramMenuItem = this.MKO;
      com.tencent.mm.ui.tools.m localm = new com.tencent.mm.ui.tools.m((Context)paramMenuItem.getContext());
      localm.a((q.f)new TextStatusDetailActivity.b(paramMenuItem));
      com.tencent.mm.plugin.textstatus.g.e.a locala = paramMenuItem.MCs;
      if (locala == null) {
        p.bGy("info");
      }
      localm.a((q.g)new TextStatusDetailActivity.c(paramMenuItem, locala.field_StatusID));
      localm.hYu();
      AppMethodBeat.o(238490);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDetailActivity
 * JD-Core Version:    0.7.0.1
 */