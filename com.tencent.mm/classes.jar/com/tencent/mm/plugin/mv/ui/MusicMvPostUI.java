package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvSaveDraftUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(33)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/MusicMvPostUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "captureOutputPath", "", "forceHideFloatBallWhenDestroy", "", "isFinderNew", "originCoverPath", "postData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getPostData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setPostData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "requestForRequest", "selfFinderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getSelfFinderContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setSelfFinderContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "chooseCover", "", "cropCover", "path", "doPost", "needCreateFinderContact", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "processPostData", "processor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "updateCoverImg", "srcImgPath", "updateFinderContact", "updateWhenNotFinderUser", "Companion", "plugin-mv_release"})
public final class MusicMvPostUI
  extends BaseMusicMvUI
{
  public static final a Ars;
  csp Arp;
  private g Arq;
  private String Arr;
  private String UqS;
  private boolean UqT;
  private boolean UqU;
  private boolean UqV;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(256930);
    Ars = new a((byte)0);
    AppMethodBeat.o(256930);
  }
  
  private final void aIn(String paramString)
  {
    AppMethodBeat.i(256924);
    Intent localIntent = new Intent();
    localIntent.putExtra("CropImageMode", 1);
    a locala = a.ArA;
    localIntent.putExtra("CropImage_OutputPath", a.aIo(paramString));
    localIntent.putExtra("CropImage_ImgPath", paramString);
    localIntent.putExtra("CropImage_from_scene", 4);
    paramString = com.tencent.mm.plugin.music.model.c.Akc;
    com.tencent.mm.plugin.music.model.c.sm(true);
    this.UqT = true;
    com.tencent.mm.plugin.setting.c.jRt.a((Activity)this, localIntent, 1003);
    AppMethodBeat.o(256924);
  }
  
  private final void evG()
  {
    AppMethodBeat.i(256922);
    Object localObject;
    if (this.Arq == null)
    {
      localObject = (CharSequence)z.aUg();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label60;
      }
    }
    label60:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.finder.api.c.tsp;
        this.Arq = com.tencent.mm.plugin.finder.api.c.a.asG(z.aUg());
      }
      AppMethodBeat.o(256922);
      return;
    }
  }
  
  private final void sq(boolean paramBoolean)
  {
    AppMethodBeat.i(256923);
    Object localObject1 = (kotlin.g.a.b)new e(this);
    evG();
    Object localObject2;
    if (this.Arq != null)
    {
      localObject2 = this.Arp;
      if (localObject2 == null) {
        break label172;
      }
      a locala = a.ArA;
      a.c((csp)localObject2);
      ((kotlin.g.a.b)localObject1).invoke(localObject2);
    }
    label172:
    for (localObject1 = x.SXb;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = (MusicMvPostUI)this;
        Log.i("MicroMsg.Mv.MusicMvPostUI", "create finder contact");
        if (paramBoolean)
        {
          localObject2 = y.vXH;
          if (y.an((Activity)localObject1))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).setClassName((Context)localObject1, "com.tencent.mm.plugin.finder.ui.FinderCreateContactUI");
            ((Intent)localObject2).putExtra("scene", 89);
            ((Intent)localObject2).putExtra("key_create_scene", 7);
            ((Intent)localObject2).putExtra("key_router_to_profile", false);
            ((Intent)localObject2).putExtra("key_mv_status", 2);
            ((MusicMvPostUI)localObject1).startActivityForResult((Intent)localObject2, 1002);
          }
        }
        localObject1 = x.SXb;
      }
      AppMethodBeat.o(256923);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256934);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256934);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256933);
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
    AppMethodBeat.o(256933);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131495796;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(256928);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.b(localSet, (Iterable)ak.setOf(MusicMvSaveDraftUIC.class));
      AppMethodBeat.o(256928);
      return localSet;
    }
    AppMethodBeat.o(256928);
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(256925);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(256925);
      return;
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = com.tencent.mm.ui.tools.a.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.aSY());
        if (paramIntent == null)
        {
          Log.i("MicroMsg.Mv.MusicMvPostUI", "onActivityResult: choose path null");
          AppMethodBeat.o(256925);
          return;
        }
        aIn(paramIntent);
        AppMethodBeat.o(256925);
        return;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          paramIntent = paramIntent.getStringExtra("KEY_RECORD_PHOTO_PATH");
          if (paramIntent == null)
          {
            Log.w("MicroMsg.Mv.MusicMvPostUI", "capture null: ");
            AppMethodBeat.o(256925);
            return;
          }
          this.UqS = paramIntent;
          aIn(paramIntent);
          AppMethodBeat.o(256925);
          return;
          Log.i("MicroMsg.Mv.MusicMvPostUI", "callback create finder contact post");
          sq(false);
          AppMethodBeat.o(256925);
          return;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
            if (paramIntent == null)
            {
              Log.i("MicroMsg.Mv.MusicMvPostUI", "onActivityResult: crop path null");
              AppMethodBeat.o(256925);
              return;
            }
            com.tencent.mm.vfs.s.deleteFile(this.UqS);
            if (paramInt2 == -1)
            {
              com.tencent.mm.vfs.s.deleteFile(this.Arr);
              this.Arr = paramIntent;
              Object localObject = this.Arp;
              if (localObject != null) {
                ((csp)localObject).MxF = paramIntent;
              }
              localObject = findViewById(2131297645);
              ImageView localImageView = (ImageView)findViewById(2131309073);
              if (localImageView != null)
              {
                com.tencent.mm.av.a.a.c localc = new com.tencent.mm.av.a.a.c.a().bdo().bdr().bdv();
                p.g(localc, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
                com.tencent.mm.av.q.bcV().a(paramIntent, localImageView, localc, (h)new j(this, paramIntent, (View)localObject));
                AppMethodBeat.o(256925);
                return;
              }
              AppMethodBeat.o(256925);
              return;
            }
            com.tencent.mm.vfs.s.deleteFile(paramIntent);
          }
        }
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(256929);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    ((MusicMvSaveDraftUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(MusicMvSaveDraftUIC.class)).a(this.Arp, true, 4);
    AppMethodBeat.o(256929);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(256921);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131099672));
    setMMTitle(2131763402);
    addTextOptionMenu(0, getString(2131766193), (MenuItem.OnMenuItemClickListener)new g(this), null, t.b.OHf);
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    evG();
    paramBundle = this.Arq;
    com.tencent.mm.av.a.a.c localc;
    if (paramBundle != null)
    {
      localObject2 = (TextView)findViewById(2131305440);
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)paramBundle.getNickname()));
      }
      localObject2 = (ImageView)findViewById(2131297134);
      if (localObject2 != null)
      {
        localc = new com.tencent.mm.av.a.a.c.a().bdp().bdo().bdt().bdv();
        com.tencent.mm.av.q.bcV().a(paramBundle.cXH(), (ImageView)localObject2, localc);
        paramBundle = x.SXb;
        if (paramBundle != null) {
          break label322;
        }
      }
    }
    else
    {
      localObject2 = (MusicMvPostUI)this;
      paramBundle = (LinearLayout)((MusicMvPostUI)localObject2).findViewById(2131305196);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)((MusicMvPostUI)localObject2).findViewById(2131305196);
      if (paramBundle == null) {
        break label268;
      }
    }
    label268:
    for (paramBundle = paramBundle.getLayoutParams();; paramBundle = null)
    {
      if (paramBundle != null) {
        break label273;
      }
      paramBundle = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(256921);
      throw paramBundle;
      paramBundle = null;
      break;
    }
    label273:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    paramBundle.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context)((MusicMvPostUI)localObject2).getContext(), 56);
    Object localObject2 = (LinearLayout)((MusicMvPostUI)localObject2).findViewById(2131305196);
    if (localObject2 != null) {
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    }
    label322:
    this.Arp = new csp();
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null)
    {
      localObject2 = this.Arp;
      if (localObject2 != null) {
        ((csp)localObject2).parseFrom(paramBundle);
      }
    }
    localObject2 = this.Arp;
    paramBundle = (Bundle)localObject1;
    if (localObject2 != null) {
      paramBundle = ((csp)localObject2).MxF;
    }
    this.Arr = paramBundle;
    localObject1 = (LinearLayout)findViewById(2131305087);
    paramBundle = findViewById(2131297645);
    if (ao.isDarkMode()) {
      ((LinearLayout)localObject1).setBackgroundResource(2131234996);
    }
    for (;;)
    {
      localObject1 = this.Arp;
      if (localObject1 != null)
      {
        localObject1 = ((csp)localObject1).MxF;
        if (localObject1 != null)
        {
          localObject2 = (ImageView)findViewById(2131309073);
          if (localObject2 != null)
          {
            localc = new com.tencent.mm.av.a.a.c.a().bdo().bdr().bdv();
            p.g(localc, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
            com.tencent.mm.av.q.bcV().a((String)localObject1, (ImageView)localObject2, localc, (h)new f((String)localObject1, this, paramBundle));
          }
        }
      }
      paramBundle = this.Arp;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.MxE;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.objectDesc;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.mvInfo;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.Aqo;
              if (paramBundle != null)
              {
                localObject1 = (TextView)findViewById(2131305167);
                if (localObject1 != null) {
                  ((TextView)localObject1).setText((CharSequence)paramBundle.BPc);
                }
                localObject1 = (TextView)findViewById(2131305169);
                if (localObject1 != null) {
                  ((TextView)localObject1).setText((CharSequence)paramBundle.lDR);
                }
              }
            }
          }
        }
      }
      paramBundle = (LinearLayout)findViewById(2131298280);
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new i(this));
      }
      float f = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 8);
      paramBundle = (RoundCornerRelativeLayout)findViewById(2131307176);
      if (paramBundle == null) {
        break;
      }
      paramBundle.setRadius(f);
      AppMethodBeat.o(256921);
      return;
      ((LinearLayout)localObject1).setBackgroundResource(2131234997);
    }
    AppMethodBeat.o(256921);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(258890);
    super.onDestroy();
    if (this.UqU)
    {
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.Akc;
      com.tencent.mm.plugin.music.model.c.cjj();
    }
    AppMethodBeat.o(258890);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(256927);
    super.onPause();
    com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.Akc;
    com.tencent.mm.plugin.music.model.c.gFa();
    AppMethodBeat.o(256927);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(256926);
    super.onResume();
    if (!this.UqT)
    {
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.Akc;
      com.tencent.mm.plugin.music.model.c.onResume();
      AppMethodBeat.o(256926);
      return;
    }
    this.UqT = false;
    AppMethodBeat.o(256926);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/MusicMvPostUI$Companion;", "", "()V", "MENU_ID_FROM_ALBUM", "", "MENU_ID_FROM_CAMERA", "REQUEST_CODE_CREATE_FINDER_POST", "REQUEST_CODE_CROP_COVER", "REQUEST_CODE_SELECT_COVER_FROM_ALBUM", "REQUEST_CODE_SELECT_COVER_FROM_SIGHT", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements o.f
  {
    b(MusicMvPostUI paramMusicMvPostUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(256912);
      AppCompatActivity localAppCompatActivity = this.Art.getContext();
      p.g(localAppCompatActivity, "context");
      paramm.d(1, (CharSequence)localAppCompatActivity.getResources().getString(2131755822));
      localAppCompatActivity = this.Art.getContext();
      p.g(localAppCompatActivity, "context");
      paramm.d(2, (CharSequence)localAppCompatActivity.getResources().getString(2131763394));
      AppMethodBeat.o(256912);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class c
    implements o.g
  {
    c(MusicMvPostUI paramMusicMvPostUI, e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(256913);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        this.nkZ.bMo();
        AppMethodBeat.o(256913);
        return;
      case 1: 
        paramMenuItem = new Intent((Context)this.Art, MusicMvRouterUI.class);
        paramMenuItem.putExtra("KEY_MUSIC_ROUTER", 2);
        com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.sm(true);
        MusicMvPostUI.e(this.Art);
        this.Art.startActivityForResult(paramMenuItem, 1000);
        AppMethodBeat.o(256913);
        return;
      }
      paramMenuItem = com.tencent.mm.plugin.music.model.c.Akc;
      com.tencent.mm.plugin.music.model.c.sm(true);
      MusicMvPostUI.e(this.Art);
      com.tencent.mm.pluginsdk.ui.tools.s.a((Activity)this.Art, 1001, 1, 27, 1, null);
      AppMethodBeat.o(256913);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<csp, x>
  {
    e(MusicMvPostUI paramMusicMvPostUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$6$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release", "com/tencent/mm/plugin/mv/ui/MusicMvPostUI$$special$$inlined$let$lambda$1"})
  public static final class f
    implements h
  {
    f(String paramString, MusicMvPostUI paramMusicMvPostUI, View paramView) {}
    
    public final Bitmap a(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
    {
      return null;
    }
    
    public final void b(String paramString, View paramView) {}
    
    public final void b(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
    {
      View localView = null;
      AppMethodBeat.i(256916);
      p.h(paramString, "url");
      if (paramb != null) {}
      for (paramView = paramb.bitmap;; paramView = null)
      {
        if (paramView != null)
        {
          paramView = localView;
          if (paramb != null) {
            paramView = paramb.bitmap;
          }
          p.g(paramView, "imageData?.bitmap");
          if (!paramView.isRecycled())
          {
            paramString = paramString.getBytes(kotlin.n.d.UTF_8);
            p.g(paramString, "(this as java.lang.String).getBytes(charset)");
            paramString = com.tencent.xweb.util.d.getMessageDigest(paramString);
            paramView = com.tencent.mm.plugin.comm.b.qCp;
            paramView = jdField_this.getContext();
            p.g(paramView, "context");
            paramView = (Context)paramView;
            localView = paramBundle;
            p.g(localView, "mvBlurBg");
            paramb = paramb.bitmap;
            p.g(paramb, "imageData.bitmap");
            p.g(paramString, "md5Key");
            com.tencent.mm.plugin.comm.b.a(paramView, localView, paramb, paramString);
          }
        }
        AppMethodBeat.o(256916);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(MusicMvPostUI paramMusicMvPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(256917);
      paramMenuItem = this.Art;
      CharSequence localCharSequence = (CharSequence)z.aUg();
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        MusicMvPostUI.a(paramMenuItem, bool);
        MusicMvPostUI.a(this.Art);
        AppMethodBeat.o(256917);
        return true;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(MusicMvPostUI paramMusicMvPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(256918);
      paramMenuItem = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvSaveDraftUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Art).get(MusicMvSaveDraftUIC.class)).a(this.Art.Arp, true, 4);
      AppMethodBeat.o(256918);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(MusicMvPostUI paramMusicMvPostUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256919);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      MusicMvPostUI.b(this.Art);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256919);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvPostUI$updateCoverImg$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
  public static final class j
    implements h
  {
    j(MusicMvPostUI paramMusicMvPostUI, String paramString, View paramView) {}
    
    public final Bitmap a(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
    {
      return null;
    }
    
    public final void b(String paramString, View paramView) {}
    
    public final void b(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
    {
      Object localObject = null;
      AppMethodBeat.i(256920);
      p.h(paramString, "url");
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
        p.g(paramView, "imageData?.bitmap");
        if (!paramView.isRecycled())
        {
          paramString = paramString.getBytes(kotlin.n.d.UTF_8);
          p.g(paramString, "(this as java.lang.String).getBytes(charset)");
          paramView = com.tencent.xweb.util.d.getMessageDigest(paramString);
          paramString = com.tencent.mm.plugin.comm.b.qCp;
          paramString = this.Art.getContext();
          p.g(paramString, "context");
          Context localContext = (Context)paramString;
          View localView = this.Arw;
          p.g(localView, "mvBlurBg");
          paramString = localObject;
          if (paramb != null) {
            paramString = paramb.bitmap;
          }
          p.g(paramString, "imageData?.bitmap");
          p.g(paramView, "md5Key");
          com.tencent.mm.plugin.comm.b.a(localContext, localView, paramString, paramView);
        }
        AppMethodBeat.o(256920);
        return;
        paramView = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvPostUI
 * JD-Core Version:    0.7.0.1
 */