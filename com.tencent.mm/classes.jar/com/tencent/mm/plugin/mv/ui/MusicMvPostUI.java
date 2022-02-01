package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kp;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.d;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.ui.free.MusicMvFreeMakerPreviewUI;
import com.tencent.mm.plugin.mv.ui.uic.q;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.vfs.y;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(33)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/MusicMvPostUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "captureOutputPath", "", "forceHideFloatBallWhenDestroy", "", "isFinderNew", "originCoverPath", "postData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getPostData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setPostData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "requestForRequest", "selfFinderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getSelfFinderContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setSelfFinderContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "chooseCover", "", "cropCover", "path", "doPost", "needCreateFinderContact", "enterFixPreviewUI", "enterFlexPreviewUI", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "processPostData", "processor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "updateCoverImg", "srcImgPath", "updateFinderContact", "updateWhenNotFinderUser", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvPostUI
  extends BaseMusicMvUI
{
  public static final MusicMvPostUI.a Mam;
  dtf Man;
  private com.tencent.mm.plugin.finder.api.m Mao;
  private String Map;
  private String Maq;
  private boolean Mar;
  private boolean Mas;
  private boolean Mat;
  
  static
  {
    AppMethodBeat.i(286527);
    Mam = new MusicMvPostUI.a((byte)0);
    AppMethodBeat.o(286527);
  }
  
  private static final void a(MusicMvPostUI paramMusicMvPostUI, View paramView)
  {
    AppMethodBeat.i(286489);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMvPostUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvPostUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMusicMvPostUI, "this$0");
    paramMusicMvPostUI.gqa();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/MusicMvPostUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286489);
  }
  
  private static final void a(MusicMvPostUI paramMusicMvPostUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(286502);
    kotlin.g.b.s.u(paramMusicMvPostUI, "this$0");
    params.c(1, (CharSequence)paramMusicMvPostUI.getContext().getResources().getString(b.h.app_field_mmsight));
    params.c(2, (CharSequence)paramMusicMvPostUI.getContext().getResources().getString(b.h.music_post_menu_album));
    AppMethodBeat.o(286502);
  }
  
  private static final void a(MusicMvPostUI paramMusicMvPostUI, f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(286510);
    kotlin.g.b.s.u(paramMusicMvPostUI, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    switch (paramMenuItem.getItemId())
    {
    default: 
      paramf.cyW();
      AppMethodBeat.o(286510);
      return;
    case 1: 
      paramf = new Intent((Context)paramMusicMvPostUI, MusicMvRouterUI.class);
      paramf.putExtra("KEY_MUSIC_ROUTER", 2);
      paramMenuItem = com.tencent.mm.plugin.music.model.c.LLZ;
      com.tencent.mm.plugin.music.model.c.zK(true);
      paramMusicMvPostUI.Mar = true;
      paramMusicMvPostUI.startActivityForResult(paramf, 1000);
      AppMethodBeat.o(286510);
      return;
    }
    paramf = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.zK(true);
    paramMusicMvPostUI.Mar = true;
    t.a((Activity)paramMusicMvPostUI, 1001, 1, 27, 1, false, null);
    AppMethodBeat.o(286510);
  }
  
  private static final boolean a(MusicMvPostUI paramMusicMvPostUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(286472);
    kotlin.g.b.s.u(paramMusicMvPostUI, "this$0");
    paramMenuItem = (CharSequence)z.bAW();
    if ((paramMenuItem == null) || (paramMenuItem.length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      paramMusicMvPostUI.Mat = bool;
      paramMenuItem = com.tencent.mm.plugin.mv.model.m.LYc;
      paramMenuItem = com.tencent.mm.plugin.mv.model.m.gpJ();
      paramMenuItem.ioV = 14L;
      paramMenuItem.bMH();
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)paramMenuItem);
      paramMusicMvPostUI.zW(true);
      AppMethodBeat.o(286472);
      return true;
    }
  }
  
  private final void aPA(String paramString)
  {
    AppMethodBeat.i(286462);
    Intent localIntent = new Intent();
    localIntent.putExtra("CropImageMode", 1);
    Object localObject = bm.GlZ;
    StringBuilder localStringBuilder = new StringBuilder("music_mv_cover_");
    localObject = this.Man;
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((dtf)localObject).localId))
    {
      localIntent.putExtra("CropImage_OutputPath", bm.aCh(localObject + '_' + MD5Util.getMD5String(paramString)));
      localIntent.putExtra("CropImage_ImgPath", paramString);
      localIntent.putExtra("CropImage_from_scene", 4);
      paramString = com.tencent.mm.plugin.music.model.c.LLZ;
      com.tencent.mm.plugin.music.model.c.zK(true);
      this.Mar = true;
      com.tencent.mm.plugin.setting.c.pFn.a((Activity)this, localIntent, 1003);
      AppMethodBeat.o(286462);
      return;
    }
  }
  
  private static final void b(MusicMvPostUI paramMusicMvPostUI, View paramView)
  {
    Intent localIntent = null;
    AppMethodBeat.i(286498);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMvPostUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvPostUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMusicMvPostUI, "this$0");
    paramView = paramMusicMvPostUI.Man;
    int i;
    if (paramView != null)
    {
      paramView = paramView.aaYK;
      if (paramView != null)
      {
        paramView = paramView.objectDesc;
        if (paramView != null)
        {
          paramView = paramView.mvInfo;
          if ((paramView != null) && (paramView.ZWM == 1))
          {
            i = 1;
            if (i == 0) {
              break label281;
            }
            localIntent = new Intent((Context)paramMusicMvPostUI, MusicMvFreeMakerPreviewUI.class);
            paramView = paramMusicMvPostUI.Man;
            if (paramView != null) {
              break label273;
            }
          }
        }
      }
    }
    label273:
    for (paramView = null;; paramView = paramView.toByteArray())
    {
      localIntent.putExtra("key_track_data", paramView);
      localIntent.putExtra("key_seek_to_start", true);
      localIntent.putExtra("key_mv_from_scene", 2);
      paramView = com.tencent.mm.plugin.music.model.c.LLZ;
      com.tencent.mm.plugin.music.model.c.zK(true);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramMusicMvPostUI, paramView.aYi(), "com/tencent/mm/plugin/mv/ui/MusicMvPostUI", "enterFlexPreviewUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMusicMvPostUI.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramMusicMvPostUI, "com/tencent/mm/plugin/mv/ui/MusicMvPostUI", "enterFlexPreviewUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/MusicMvPostUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286498);
      return;
      i = 0;
      break;
    }
    label281:
    localObject = new Intent((Context)paramMusicMvPostUI, MusicMvMakerPreviewUI.class);
    paramView = paramMusicMvPostUI.Man;
    if (paramView == null) {}
    for (paramView = localIntent;; paramView = paramView.toByteArray())
    {
      ((Intent)localObject).putExtra("key_track_data", paramView);
      ((Intent)localObject).putExtra("key_seek_to_start", true);
      com.tencent.mm.ae.d.a((Intent)localObject, paramMusicMvPostUI.getIntent(), "key_mv_from_scene");
      paramView = com.tencent.mm.plugin.music.model.c.LLZ;
      com.tencent.mm.plugin.music.model.c.zK(true);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramMusicMvPostUI, paramView.aYi(), "com/tencent/mm/plugin/mv/ui/MusicMvPostUI", "enterFixPreviewUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMusicMvPostUI.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramMusicMvPostUI, "com/tencent/mm/plugin/mv/ui/MusicMvPostUI", "enterFixPreviewUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break;
    }
  }
  
  private static final boolean b(MusicMvPostUI paramMusicMvPostUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(286481);
    kotlin.g.b.s.u(paramMusicMvPostUI, "this$0");
    paramMenuItem = k.aeZF;
    ((q)k.d((AppCompatActivity)paramMusicMvPostUI).q(q.class)).a(paramMusicMvPostUI.Man, true, 4);
    AppMethodBeat.o(286481);
    return true;
  }
  
  private final void gpZ()
  {
    AppMethodBeat.i(286433);
    Object localObject;
    if (this.Mao == null)
    {
      localObject = (CharSequence)z.bAW();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label60;
      }
    }
    label60:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.finder.api.d.AwY;
        this.Mao = d.a.auT(z.bAW());
      }
      AppMethodBeat.o(286433);
      return;
    }
  }
  
  private final void gqa()
  {
    AppMethodBeat.i(286452);
    f localf = new f((Context)this, 1, false);
    localf.setBackgroundColor(getContext().getResources().getColor(b.b.Dark_5));
    localf.NE(true);
    localf.Vtg = new MusicMvPostUI..ExternalSyntheticLambda4(this);
    localf.GAC = new MusicMvPostUI..ExternalSyntheticLambda5(this, localf);
    localf.aeLi = MusicMvPostUI..ExternalSyntheticLambda6.INSTANCE;
    localf.dDn();
    AppMethodBeat.o(286452);
  }
  
  private static final void gqb() {}
  
  private final void zW(boolean paramBoolean)
  {
    AppMethodBeat.i(286442);
    Object localObject1 = (kotlin.g.a.b)new b(this);
    gpZ();
    if (this.Mao == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject1 = (MusicMvPostUI)this;
        Log.i("MicroMsg.Mv.MusicMvPostUI", "create finder contact");
        if (paramBoolean)
        {
          localObject2 = av.GiL;
          if (av.aO((Activity)localObject1))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).setClassName((Context)localObject1, "com.tencent.mm.plugin.finder.ui.FinderCreateContactUI");
            ((Intent)localObject2).putExtra("key_create_scene", 7);
            ((Intent)localObject2).putExtra("key_router_to_profile", false);
            ((Intent)localObject2).putExtra("key_mv_status", 2);
            ((MusicMvPostUI)localObject1).startActivityForResult((Intent)localObject2, 1002);
          }
        }
      }
      AppMethodBeat.o(286442);
      return;
      Object localObject2 = this.Man;
      if (localObject2 == null)
      {
        localObject1 = null;
      }
      else
      {
        a locala = a.Maz;
        a.d((dtf)localObject2);
        ((kotlin.g.a.b)localObject1).invoke(localObject2);
        localObject1 = ah.aiuX;
      }
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.f.LVG;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(286634);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(286634);
      return null;
    }
    localSet = ar.b(localSet, (Iterable)ar.setOf(q.class));
    AppMethodBeat.o(286634);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(286604);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(286604);
      return;
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = com.tencent.mm.ui.tools.b.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
        if (paramIntent == null)
        {
          Log.i("MicroMsg.Mv.MusicMvPostUI", "onActivityResult: choose path null");
          AppMethodBeat.o(286604);
          return;
        }
        aPA(paramIntent);
        AppMethodBeat.o(286604);
        return;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          paramIntent = paramIntent.getStringExtra("KEY_RECORD_PHOTO_PATH");
          if (paramIntent == null)
          {
            Log.w("MicroMsg.Mv.MusicMvPostUI", "capture null: ");
            AppMethodBeat.o(286604);
            return;
          }
          this.Maq = paramIntent;
          aPA(paramIntent);
          AppMethodBeat.o(286604);
          return;
          Log.i("MicroMsg.Mv.MusicMvPostUI", "callback create finder contact post");
          zW(false);
          AppMethodBeat.o(286604);
          return;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
            if (paramIntent == null)
            {
              Log.i("MicroMsg.Mv.MusicMvPostUI", "onActivityResult: crop path null");
              AppMethodBeat.o(286604);
              return;
            }
            y.deleteFile(this.Maq);
            if (paramInt2 == -1)
            {
              y.deleteFile(this.Map);
              this.Map = paramIntent;
              Object localObject1 = this.Man;
              if (localObject1 != null) {
                ((dtf)localObject1).aaYL = paramIntent;
              }
              localObject1 = findViewById(b.e.blur_bg_view);
              ImageView localImageView = (ImageView)findViewById(b.e.thumb_iv);
              if (localImageView != null)
              {
                Object localObject2 = new c.a();
                ((c.a)localObject2).oKn = true;
                ((c.a)localObject2).oKs = 1;
                localObject2 = ((c.a)localObject2).bKx();
                kotlin.g.b.s.s(localObject2, "Builder().setCacheInMemo…ns.LoadFrom.FILE).build()");
                r.bKe().a(paramIntent, localImageView, (com.tencent.mm.modelimage.loader.a.c)localObject2, (h)new MusicMvPostUI.d(this, (View)localObject1));
              }
              AppMethodBeat.o(286604);
              return;
            }
            y.deleteFile(paramIntent);
          }
        }
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(286641);
    k localk = k.aeZF;
    ((q)k.d((AppCompatActivity)this).q(q.class)).a(this.Man, true, 4);
    AppMethodBeat.o(286641);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(286590);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(b.b.BW_100));
    setMMTitle(b.h.music_post_to_finder);
    addTextOptionMenu(0, getString(b.h.sns_send), new MusicMvPostUI..ExternalSyntheticLambda0(this), null, y.b.adEU);
    setBackBtn(new MusicMvPostUI..ExternalSyntheticLambda1(this));
    gpZ();
    paramBundle = this.Mao;
    if (paramBundle == null)
    {
      paramBundle = null;
      if (paramBundle != null) {
        break label330;
      }
      localObject2 = (MusicMvPostUI)this;
      paramBundle = (LinearLayout)((MusicMvPostUI)localObject2).findViewById(b.e.LUc);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)((MusicMvPostUI)localObject2).findViewById(b.e.LUc);
      if (paramBundle != null) {
        break label273;
      }
    }
    Object localObject3;
    label273:
    for (paramBundle = null;; paramBundle = paramBundle.getLayoutParams())
    {
      if (paramBundle != null) {
        break label281;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(286590);
      throw paramBundle;
      localObject2 = (TextView)findViewById(b.e.nickname_tv);
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)p.b((Context)getContext(), (CharSequence)paramBundle.getNickname()));
      }
      localObject2 = (ImageView)findViewById(b.e.avatar_iv);
      if (localObject2 != null)
      {
        localObject3 = new c.a();
        ((c.a)localObject3).oKp = true;
        ((c.a)localObject3).oKn = true;
        ((c.a)localObject3).nrc = true;
        localObject3 = ((c.a)localObject3).bKx();
        r.bKe().a(paramBundle.amx(), (ImageView)localObject2, (com.tencent.mm.modelimage.loader.a.c)localObject3);
      }
      paramBundle = ah.aiuX;
      break;
    }
    label281:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    paramBundle.topMargin = com.tencent.mm.cd.a.fromDPToPix((Context)((MusicMvPostUI)localObject2).getContext(), 56);
    Object localObject2 = (LinearLayout)((MusicMvPostUI)localObject2).findViewById(b.e.LUc);
    if (localObject2 != null) {
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    }
    label330:
    this.Man = new dtf();
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null)
    {
      localObject2 = this.Man;
      if (localObject2 != null) {
        ((dtf)localObject2).parseFrom(paramBundle);
      }
    }
    paramBundle = this.Man;
    if (paramBundle == null)
    {
      paramBundle = (Bundle)localObject1;
      this.Map = paramBundle;
      localObject1 = (LinearLayout)findViewById(b.e.music_container);
      paramBundle = findViewById(b.e.blur_bg_view);
      if (!aw.isDarkMode()) {
        break label747;
      }
      ((LinearLayout)localObject1).setBackgroundResource(b.d.sns_music_mv_dark_gradient_bg);
    }
    for (;;)
    {
      localObject1 = this.Man;
      if (localObject1 != null)
      {
        localObject1 = ((dtf)localObject1).aaYL;
        if (localObject1 != null)
        {
          localObject2 = (ImageView)findViewById(b.e.thumb_iv);
          if (localObject2 != null)
          {
            int i = b.d.music_mv_cover_empty_lightmode;
            if (aw.isDarkMode()) {
              i = b.d.music_mv_cover_empty_darkmode;
            }
            ((ImageView)localObject2).setImageDrawable(getContext().getDrawable(i));
            localObject3 = new c.a();
            ((c.a)localObject3).oKn = true;
            ((c.a)localObject3).oKs = 1;
            localObject3 = ((c.a)localObject3).bKx();
            kotlin.g.b.s.s(localObject3, "Builder().setCacheInMemo…ns.LoadFrom.FILE).build()");
            r.bKe().a((String)localObject1, (ImageView)localObject2, (com.tencent.mm.modelimage.loader.a.c)localObject3, (h)new MusicMvPostUI.c(this, paramBundle));
          }
        }
      }
      paramBundle = this.Man;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.aaYK;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.objectDesc;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.mvInfo;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.LWI;
              if (paramBundle != null)
              {
                localObject1 = (TextView)findViewById(b.e.LTS);
                if (localObject1 != null) {
                  ((TextView)localObject1).setText((CharSequence)paramBundle.songName);
                }
                localObject1 = (TextView)findViewById(b.e.LTT);
                if (localObject1 != null) {
                  ((TextView)localObject1).setText((CharSequence)paramBundle.rDl);
                }
              }
            }
          }
        }
      }
      paramBundle = (LinearLayout)findViewById(b.e.LRT);
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new MusicMvPostUI..ExternalSyntheticLambda2(this));
      }
      float f = com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 8);
      paramBundle = (RoundCornerRelativeLayout)findViewById(b.e.round_corner_rl);
      if (paramBundle != null) {
        paramBundle.setRadius(f);
      }
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new MusicMvPostUI..ExternalSyntheticLambda3(this));
      }
      AppMethodBeat.o(286590);
      return;
      paramBundle = paramBundle.aaYL;
      break;
      label747:
      ((LinearLayout)localObject1).setBackgroundResource(b.d.sns_music_mv_light_gradient_bg);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(286646);
    super.onDestroy();
    if (this.Mas)
    {
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.LLZ;
      com.tencent.mm.plugin.music.model.c.gnR();
    }
    AppMethodBeat.o(286646);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(286628);
    super.onPause();
    com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.gnQ();
    AppMethodBeat.o(286628);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(286620);
    super.onResume();
    if (!this.Mar)
    {
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.LLZ;
      com.tencent.mm.plugin.music.model.c.onResume();
      AppMethodBeat.o(286620);
      return;
    }
    this.Mar = false;
    AppMethodBeat.o(286620);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<dtf, ah>
  {
    b(MusicMvPostUI paramMusicMvPostUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvPostUI
 * JD-Core Version:    0.7.0.1
 */