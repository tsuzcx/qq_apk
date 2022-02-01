package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.b.a.ii;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.d;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.x;

@com.tencent.mm.ui.base.a(33)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/MusicMvPostUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "captureOutputPath", "", "forceHideFloatBallWhenDestroy", "", "isFinderNew", "originCoverPath", "postData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getPostData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setPostData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "requestForRequest", "selfFinderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getSelfFinderContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setSelfFinderContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "chooseCover", "", "cropCover", "path", "doPost", "needCreateFinderContact", "enterFixPreviewUI", "enterFlexPreviewUI", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "processPostData", "processor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "updateCoverImg", "srcImgPath", "updateFinderContact", "updateWhenNotFinderUser", "Companion", "plugin-mv_release"})
public final class MusicMvPostUI
  extends BaseMusicMvUI
{
  public static final a GeZ;
  dbo GeS;
  private i GeT;
  private String GeU;
  private String GeV;
  private boolean GeW;
  private boolean GeX;
  private boolean GeY;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(227595);
    GeZ = new a((byte)0);
    AppMethodBeat.o(227595);
  }
  
  private final void aSG(String paramString)
  {
    AppMethodBeat.i(227573);
    Intent localIntent = new Intent();
    localIntent.putExtra("CropImageMode", 1);
    Object localObject = av.AJz;
    StringBuilder localStringBuilder = new StringBuilder("music_mv_cover_");
    localObject = this.GeS;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((dbo)localObject).localId);; localObject = null)
    {
      localIntent.putExtra("CropImage_OutputPath", av.aGe(localObject + '_' + MD5Util.getMD5String(paramString)));
      localIntent.putExtra("CropImage_ImgPath", paramString);
      localIntent.putExtra("CropImage_from_scene", 4);
      paramString = com.tencent.mm.plugin.music.model.c.FRf;
      com.tencent.mm.plugin.music.model.c.vs(true);
      this.GeW = true;
      com.tencent.mm.plugin.setting.c.mIG.a((Activity)this, localIntent, 1003);
      AppMethodBeat.o(227573);
      return;
    }
  }
  
  private final void fgx()
  {
    AppMethodBeat.i(227568);
    Object localObject;
    if (this.GeT == null)
    {
      localObject = (CharSequence)z.bdh();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label60;
      }
    }
    label60:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
        this.GeT = d.a.aAK(z.bdh());
      }
      AppMethodBeat.o(227568);
      return;
    }
  }
  
  private final void vC(boolean paramBoolean)
  {
    AppMethodBeat.i(227571);
    Object localObject1 = (kotlin.g.a.b)new MusicMvPostUI.e(this);
    fgx();
    Object localObject2;
    if (this.GeT != null)
    {
      localObject2 = this.GeS;
      if (localObject2 == null) {
        break label162;
      }
      a locala = a.Gfi;
      a.d((dbo)localObject2);
      ((kotlin.g.a.b)localObject1).invoke(localObject2);
    }
    label162:
    for (localObject1 = x.aazN;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = (MusicMvPostUI)this;
        Log.i("MicroMsg.Mv.MusicMvPostUI", "create finder contact");
        if (paramBoolean)
        {
          localObject2 = aj.AGc;
          if (aj.at((Activity)localObject1))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).setClassName((Context)localObject1, "com.tencent.mm.plugin.finder.ui.FinderCreateContactUI");
            ((Intent)localObject2).putExtra("key_create_scene", 7);
            ((Intent)localObject2).putExtra("key_router_to_profile", false);
            ((Intent)localObject2).putExtra("key_mv_status", 2);
            ((MusicMvPostUI)localObject1).startActivityForResult((Intent)localObject2, 1002);
          }
        }
        localObject1 = x.aazN;
      }
      AppMethodBeat.o(227571);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(227613);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(227613);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(227612);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(227612);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.f.FZJ;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(227588);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.b(localSet, (Iterable)ak.setOf(com.tencent.mm.plugin.mv.ui.uic.t.class));
      AppMethodBeat.o(227588);
      return localSet;
    }
    AppMethodBeat.o(227588);
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(227582);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227582);
      return;
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = com.tencent.mm.ui.tools.b.h((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.bbW());
        if (paramIntent == null)
        {
          Log.i("MicroMsg.Mv.MusicMvPostUI", "onActivityResult: choose path null");
          AppMethodBeat.o(227582);
          return;
        }
        aSG(paramIntent);
        AppMethodBeat.o(227582);
        return;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          paramIntent = paramIntent.getStringExtra("KEY_RECORD_PHOTO_PATH");
          if (paramIntent == null)
          {
            Log.w("MicroMsg.Mv.MusicMvPostUI", "capture null: ");
            AppMethodBeat.o(227582);
            return;
          }
          this.GeV = paramIntent;
          aSG(paramIntent);
          AppMethodBeat.o(227582);
          return;
          Log.i("MicroMsg.Mv.MusicMvPostUI", "callback create finder contact post");
          vC(false);
          AppMethodBeat.o(227582);
          return;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
            if (paramIntent == null)
            {
              Log.i("MicroMsg.Mv.MusicMvPostUI", "onActivityResult: crop path null");
              AppMethodBeat.o(227582);
              return;
            }
            com.tencent.mm.vfs.u.deleteFile(this.GeV);
            if (paramInt2 == -1)
            {
              com.tencent.mm.vfs.u.deleteFile(this.GeU);
              this.GeU = paramIntent;
              Object localObject = this.GeS;
              if (localObject != null) {
                ((dbo)localObject).TIW = paramIntent;
              }
              localObject = findViewById(b.e.blur_bg_view);
              ImageView localImageView = (ImageView)findViewById(b.e.thumb_iv);
              if (localImageView != null)
              {
                com.tencent.mm.ay.a.a.c localc = new c.a().gs(true).bmH().bmL();
                p.j(localc, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
                q.bml().a(paramIntent, localImageView, localc, (h)new k(this, paramIntent, (View)localObject));
                AppMethodBeat.o(227582);
                return;
              }
              AppMethodBeat.o(227582);
              return;
            }
            com.tencent.mm.vfs.u.deleteFile(paramIntent);
          }
        }
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(227589);
    g localg = g.Xox;
    ((com.tencent.mm.plugin.mv.ui.uic.t)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.mv.ui.uic.t.class)).a(this.GeS, true, 4);
    AppMethodBeat.o(227589);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(227567);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(b.b.BW_100));
    setMMTitle(b.h.music_post_to_finder);
    addTextOptionMenu(0, getString(b.h.sns_send), (MenuItem.OnMenuItemClickListener)new g(this), null, w.b.Waz);
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    fgx();
    paramBundle = this.GeT;
    com.tencent.mm.ay.a.a.c localc;
    if (paramBundle != null)
    {
      localObject2 = (TextView)findViewById(b.e.nickname_tv);
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)paramBundle.getNickname()));
      }
      localObject2 = (ImageView)findViewById(b.e.avatar_iv);
      if (localObject2 != null)
      {
        localc = new c.a().bmF().gs(true).bmJ().bmL();
        q.bml().a(paramBundle.Mm(), (ImageView)localObject2, localc);
        paramBundle = x.aazN;
        if (paramBundle != null) {
          break label324;
        }
      }
    }
    else
    {
      localObject2 = (MusicMvPostUI)this;
      paramBundle = (LinearLayout)((MusicMvPostUI)localObject2).findViewById(b.e.FYy);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)((MusicMvPostUI)localObject2).findViewById(b.e.FYy);
      if (paramBundle == null) {
        break label270;
      }
    }
    label270:
    for (paramBundle = paramBundle.getLayoutParams();; paramBundle = null)
    {
      if (paramBundle != null) {
        break label275;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(227567);
      throw paramBundle;
      paramBundle = null;
      break;
    }
    label275:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    paramBundle.topMargin = com.tencent.mm.ci.a.fromDPToPix((Context)((MusicMvPostUI)localObject2).getContext(), 56);
    Object localObject2 = (LinearLayout)((MusicMvPostUI)localObject2).findViewById(b.e.FYy);
    if (localObject2 != null) {
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    }
    label324:
    this.GeS = new dbo();
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null)
    {
      localObject2 = this.GeS;
      if (localObject2 != null) {
        ((dbo)localObject2).parseFrom(paramBundle);
      }
    }
    localObject2 = this.GeS;
    paramBundle = (Bundle)localObject1;
    if (localObject2 != null) {
      paramBundle = ((dbo)localObject2).TIW;
    }
    this.GeU = paramBundle;
    localObject1 = (LinearLayout)findViewById(b.e.music_container);
    paramBundle = findViewById(b.e.blur_bg_view);
    if (ar.isDarkMode()) {
      ((LinearLayout)localObject1).setBackgroundResource(b.d.sns_music_mv_dark_gradient_bg);
    }
    for (;;)
    {
      localObject1 = this.GeS;
      if (localObject1 != null)
      {
        localObject1 = ((dbo)localObject1).TIW;
        if (localObject1 != null)
        {
          localObject2 = (ImageView)findViewById(b.e.thumb_iv);
          if (localObject2 != null)
          {
            int i = b.d.music_mv_cover_empty_lightmode;
            if (ar.isDarkMode()) {
              i = b.d.music_mv_cover_empty_darkmode;
            }
            ((ImageView)localObject2).setImageDrawable(getContext().getDrawable(i));
            localc = new c.a().gs(true).bmH().bmL();
            p.j(localc, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
            q.bml().a((String)localObject1, (ImageView)localObject2, localc, (h)new f((String)localObject1, this, paramBundle));
          }
        }
      }
      paramBundle = this.GeS;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.TIV;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.objectDesc;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.mvInfo;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.GaB;
              if (paramBundle != null)
              {
                localObject1 = (TextView)findViewById(b.e.FYp);
                if (localObject1 != null) {
                  ((TextView)localObject1).setText((CharSequence)paramBundle.HLH);
                }
                localObject1 = (TextView)findViewById(b.e.FYq);
                if (localObject1 != null) {
                  ((TextView)localObject1).setText((CharSequence)paramBundle.ozs);
                }
              }
            }
          }
        }
      }
      paramBundle = (LinearLayout)findViewById(b.e.FWH);
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new i(this));
      }
      float f = com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 8);
      paramBundle = (RoundCornerRelativeLayout)findViewById(b.e.round_corner_rl);
      if (paramBundle != null) {
        paramBundle.setRadius(f);
      }
      if (paramBundle == null) {
        break;
      }
      paramBundle.setOnClickListener((View.OnClickListener)new j(this));
      AppMethodBeat.o(227567);
      return;
      ((LinearLayout)localObject1).setBackgroundResource(b.d.sns_music_mv_light_gradient_bg);
    }
    AppMethodBeat.o(227567);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(227591);
    super.onDestroy();
    if (this.GeX)
    {
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.FRf;
      com.tencent.mm.plugin.music.model.c.cwB();
    }
    AppMethodBeat.o(227591);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(227586);
    super.onPause();
    com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.FRf;
    com.tencent.mm.plugin.music.model.c.feJ();
    AppMethodBeat.o(227586);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(227585);
    super.onResume();
    if (!this.GeW)
    {
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.FRf;
      com.tencent.mm.plugin.music.model.c.onResume();
      AppMethodBeat.o(227585);
      return;
    }
    this.GeW = false;
    AppMethodBeat.o(227585);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/MusicMvPostUI$Companion;", "", "()V", "MENU_ID_FROM_ALBUM", "", "MENU_ID_FROM_CAMERA", "REQUEST_CODE_CREATE_FINDER_POST", "REQUEST_CODE_CROP_COVER", "REQUEST_CODE_SELECT_COVER_FROM_ALBUM", "REQUEST_CODE_SELECT_COVER_FROM_SIGHT", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements q.f
  {
    b(MusicMvPostUI paramMusicMvPostUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(228766);
      AppCompatActivity localAppCompatActivity = this.Gfa.getContext();
      p.j(localAppCompatActivity, "context");
      paramo.d(1, (CharSequence)localAppCompatActivity.getResources().getString(b.h.app_field_mmsight));
      localAppCompatActivity = this.Gfa.getContext();
      p.j(localAppCompatActivity, "context");
      paramo.d(2, (CharSequence)localAppCompatActivity.getResources().getString(b.h.music_post_menu_album));
      AppMethodBeat.o(228766);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class c
    implements q.g
  {
    c(MusicMvPostUI paramMusicMvPostUI, e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(228563);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        this.qmB.bYF();
        AppMethodBeat.o(228563);
        return;
      case 1: 
        paramMenuItem = new Intent((Context)this.Gfa, MusicMvRouterUI.class);
        paramMenuItem.putExtra("KEY_MUSIC_ROUTER", 2);
        com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.FRf;
        com.tencent.mm.plugin.music.model.c.vs(true);
        MusicMvPostUI.g(this.Gfa);
        this.Gfa.startActivityForResult(paramMenuItem, 1000);
        AppMethodBeat.o(228563);
        return;
      }
      paramMenuItem = com.tencent.mm.plugin.music.model.c.FRf;
      com.tencent.mm.plugin.music.model.c.vs(true);
      MusicMvPostUI.g(this.Gfa);
      com.tencent.mm.pluginsdk.ui.tools.u.a((Activity)this.Gfa, 1001, 1, 27, 1, null);
      AppMethodBeat.o(228563);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$6$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release", "com/tencent/mm/plugin/mv/ui/MusicMvPostUI$$special$$inlined$let$lambda$1"})
  public static final class f
    implements h
  {
    f(String paramString, MusicMvPostUI paramMusicMvPostUI, View paramView) {}
    
    public final Bitmap a(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
    {
      return null;
    }
    
    public final void b(String paramString, View paramView) {}
    
    public final void b(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
    {
      View localView = null;
      AppMethodBeat.i(231290);
      p.k(paramString, "url");
      if (paramb != null) {}
      for (paramView = paramb.bitmap;; paramView = null)
      {
        if (paramView != null)
        {
          paramView = localView;
          if (paramb != null) {
            paramView = paramb.bitmap;
          }
          p.j(paramView, "imageData?.bitmap");
          if (!paramView.isRecycled())
          {
            paramString = paramString.getBytes(kotlin.n.d.UTF_8);
            p.j(paramString, "(this as java.lang.String).getBytes(charset)");
            paramString = com.tencent.xweb.util.d.getMessageDigest(paramString);
            paramView = com.tencent.mm.plugin.comm.b.ubp;
            paramView = jdField_this.getContext();
            p.j(paramView, "context");
            paramView = (Context)paramView;
            localView = paramBundle;
            p.j(localView, "mvBlurBg");
            paramb = paramb.bitmap;
            p.j(paramb, "imageData.bitmap");
            p.j(paramString, "md5Key");
            com.tencent.mm.plugin.comm.b.a(paramView, localView, paramb, paramString);
          }
        }
        AppMethodBeat.o(231290);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(MusicMvPostUI paramMusicMvPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(225197);
      paramMenuItem = this.Gfa;
      Object localObject = (CharSequence)z.bdh();
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        MusicMvPostUI.a(paramMenuItem, bool);
        paramMenuItem = com.tencent.mm.plugin.mv.model.m.GcA;
        paramMenuItem = com.tencent.mm.plugin.mv.model.m.fgi();
        paramMenuItem.sP(14L);
        paramMenuItem.bpa();
        localObject = com.tencent.mm.util.c.Yyz;
        com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)paramMenuItem);
        MusicMvPostUI.b(this.Gfa);
        AppMethodBeat.o(225197);
        return true;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(MusicMvPostUI paramMusicMvPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(227749);
      paramMenuItem = g.Xox;
      ((com.tencent.mm.plugin.mv.ui.uic.t)g.b((AppCompatActivity)this.Gfa).i(com.tencent.mm.plugin.mv.ui.uic.t.class)).a(this.Gfa.GeS, true, 4);
      AppMethodBeat.o(227749);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(MusicMvPostUI paramMusicMvPostUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231420);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      MusicMvPostUI.c(this.Gfa);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(231420);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(MusicMvPostUI paramMusicMvPostUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231428);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Gfa.GeS;
      int i;
      if (paramView != null)
      {
        paramView = paramView.TIV;
        if (paramView != null)
        {
          paramView = paramView.objectDesc;
          if (paramView != null)
          {
            paramView = paramView.mvInfo;
            if ((paramView != null) && (paramView.SOF == 1))
            {
              i = 1;
              if (i == 0) {
                break label117;
              }
              MusicMvPostUI.d(this.Gfa);
            }
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231428);
        return;
        i = 0;
        break;
        label117:
        MusicMvPostUI.e(this.Gfa);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvPostUI$updateCoverImg$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
  public static final class k
    implements h
  {
    k(MusicMvPostUI paramMusicMvPostUI, String paramString, View paramView) {}
    
    public final Bitmap a(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
    {
      return null;
    }
    
    public final void b(String paramString, View paramView) {}
    
    public final void b(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
    {
      Object localObject = null;
      AppMethodBeat.i(230144);
      p.k(paramString, "url");
      if (paramb != null)
      {
        paramView = paramb.bitmap;
        if (paramView != null) {
          if (paramb == null) {
            break label149;
          }
        }
      }
      label149:
      for (paramView = paramb.bitmap;; paramView = null)
      {
        p.j(paramView, "imageData?.bitmap");
        if (!paramView.isRecycled())
        {
          paramString = paramString.getBytes(kotlin.n.d.UTF_8);
          p.j(paramString, "(this as java.lang.String).getBytes(charset)");
          paramView = com.tencent.xweb.util.d.getMessageDigest(paramString);
          paramString = com.tencent.mm.plugin.comm.b.ubp;
          paramString = this.Gfa.getContext();
          p.j(paramString, "context");
          Context localContext = (Context)paramString;
          View localView = this.Gfd;
          p.j(localView, "mvBlurBg");
          paramString = localObject;
          if (paramb != null) {
            paramString = paramb.bitmap;
          }
          p.j(paramString, "imageData?.bitmap");
          p.j(paramView, "md5Key");
          com.tencent.mm.plugin.comm.b.a(localContext, localView, paramString, paramView);
        }
        AppMethodBeat.o(230144);
        return;
        paramView = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvPostUI
 * JD-Core Version:    0.7.0.1
 */