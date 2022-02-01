package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.videocomposition.c;
import com.tencent.mm.videocomposition.c.a;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "dialogView", "Landroid/view/View;", "getDialogView", "()Landroid/view/View;", "dialogView$delegate", "Lkotlin/Lazy;", "editorControlIconsContainer", "kotlin.jvm.PlatformType", "getEditorControlIconsContainer", "editorControlIconsContainer$delegate", "enable", "", "finishBtn", "Landroid/widget/Button;", "getFinishBtn", "()Landroid/widget/Button;", "finishBtn$delegate", "fullScreenThumbView", "Landroid/widget/ImageView;", "getFullScreenThumbView", "()Landroid/widget/ImageView;", "fullScreenThumbView$delegate", "halfScreenHeader", "halfScreenSelectBtn", "halfScreenThumbView", "getHalfScreenThumbView", "halfScreenThumbView$delegate", "helpDialog", "Landroid/support/design/widget/BottomSheetDialog;", "getHelpDialog", "()Landroid/support/design/widget/BottomSheetDialog;", "helpDialog$delegate", "value", "isFirstEnter", "()Z", "setFirstEnter", "(Z)V", "isNeedCropFullScreen", "isPreviewHalfScreen", "getLayout", "()Landroid/view/ViewGroup;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbHeight", "", "thumbPath", "", "thumbWidth", "changePreviewMode", "", "halfScreen", "enablePreview", "ensureThumb", "hide", "isEnablePreview", "isInHalfScreenMode", "need", "onBackPress", "onUpdate", "seekTo", "", "seekToOriginPosition", "onUpdateImage", "show", "showHelpDialogIfNeed", "Companion", "plugin-vlog_release"})
public final class s
  implements t, e.d
{
  public static final s.a GHT;
  public boolean GGS;
  private final View GHL;
  private final View GHM;
  private final f GHN;
  private final f GHO;
  private final f GHP;
  private final f GHQ;
  public boolean GHR;
  private final f GHS;
  private ac GxA;
  private final MultiProcessMMKV cQe;
  private final Context context;
  private boolean enable;
  private final int thumbHeight;
  public String thumbPath;
  private final int thumbWidth;
  private final f vJA;
  private com.tencent.mm.videocomposition.g vNj;
  final ViewGroup wgq;
  private final d wgr;
  
  static
  {
    AppMethodBeat.i(191381);
    GHT = new s.a((byte)0);
    AppMethodBeat.o(191381);
  }
  
  public s(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191380);
    this.wgq = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.wgq.getContext();
    p.g(paramViewGroup, "layout.context");
    this.context = paramViewGroup;
    this.cQe = MultiProcessMMKV.getMMKV("MultiEditPostPreviewPlugin");
    paramViewGroup = this.wgq.findViewById(2131302243);
    p.g(paramViewGroup, "layout.findViewById(R.id.half_screen_select_btn)");
    this.GHL = paramViewGroup;
    paramViewGroup = this.wgq.findViewById(2131302239);
    p.g(paramViewGroup, "layout.findViewById(R.id.half_screen_header)");
    this.GHM = paramViewGroup;
    this.GHN = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.vJA = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.GHO = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.GHP = kotlin.g.ah((kotlin.g.a.a)new g(this));
    this.GHQ = kotlin.g.ah((kotlin.g.a.a)new f(this));
    this.thumbWidth = com.tencent.mm.cb.a.aG(this.context, 2131165281);
    this.thumbHeight = com.tencent.mm.cb.a.aG(this.context, 2131165292);
    this.GHS = kotlin.g.ah((kotlin.g.a.a)new h(this));
    this.GHL.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191358);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.GHU;
        if (!s.e(this.GHU)) {}
        for (boolean bool = true;; bool = false)
        {
          s.a(paramAnonymousView, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(191358);
          return;
        }
      }
    });
    this.GHM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191359);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        s.f(this.GHU);
        s.g(this.GHU).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191359);
      }
    });
    AppMethodBeat.o(191380);
  }
  
  private final boolean fDq()
  {
    AppMethodBeat.i(191368);
    boolean bool = this.cQe.getBoolean("isFirstEnter", false);
    AppMethodBeat.o(191368);
    return bool;
  }
  
  private final void fDr()
  {
    AppMethodBeat.i(191369);
    this.cQe.putBoolean("isFirstEnter", true);
    AppMethodBeat.o(191369);
  }
  
  private final View fDs()
  {
    AppMethodBeat.i(191370);
    View localView = (View)this.GHN.getValue();
    AppMethodBeat.o(191370);
    return localView;
  }
  
  private final Button fDt()
  {
    AppMethodBeat.i(191371);
    Button localButton = (Button)this.vJA.getValue();
    AppMethodBeat.o(191371);
    return localButton;
  }
  
  private final ImageView fDu()
  {
    AppMethodBeat.i(191372);
    ImageView localImageView = (ImageView)this.GHP.getValue();
    AppMethodBeat.o(191372);
    return localImageView;
  }
  
  private final ImageView fDv()
  {
    AppMethodBeat.i(191373);
    ImageView localImageView = (ImageView)this.GHQ.getValue();
    AppMethodBeat.o(191373);
    return localImageView;
  }
  
  private final android.support.design.widget.a fDw()
  {
    AppMethodBeat.i(191374);
    android.support.design.widget.a locala = (android.support.design.widget.a)this.GHS.getValue();
    AppMethodBeat.o(191374);
    return locala;
  }
  
  private final void fDx()
  {
    AppMethodBeat.i(191377);
    Object localObject3 = this.thumbPath;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = com.tencent.mm.plugin.gallery.a.a.dZ(com.tencent.mm.vfs.s.k(this.thumbPath, false), Math.max(this.thumbWidth, this.thumbHeight));
      if (localObject2 == null) {}
    }
    for (;;)
    {
      try
      {
        int i = new android.support.e.a(com.tencent.mm.vfs.s.openRead((String)localObject3)).l("Orientation");
        localObject3 = new Matrix();
        switch (i)
        {
        case 6: 
          Object localObject1;
          ((Matrix)localObject3).postRotate(localObject1);
          localObject2 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject3, true);
          fDu().setImageBitmap((Bitmap)localObject2);
          fDv().setImageBitmap((Bitmap)localObject2);
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MultiEditPostPreviewPlugin", "cannot decode thumbnail from " + this.thumbPath + ", " + localException.getLocalizedMessage());
        continue;
        AppMethodBeat.o(191377);
        return;
      }
      localObject2 = this.GxA;
      if (localObject2 != null)
      {
        localObject3 = this.vNj;
        if (localObject3 != null) {
          ((com.tencent.mm.videocomposition.g)localObject3).destroy();
        }
        localObject3 = c.RgU;
        this.vNj = ((com.tencent.mm.videocomposition.g)c.a.b(((ad)j.ks((List)((ac)localObject2).Gzn)).GzA));
        localObject2 = this.vNj;
        if (localObject2 != null) {
          ((com.tencent.mm.videocomposition.g)localObject2).setSize(this.thumbWidth, this.thumbHeight);
        }
        localObject2 = this.vNj;
        if (localObject2 != null)
        {
          ((com.tencent.mm.videocomposition.g)localObject2).b(j.listOf(Long.valueOf(0L)), (m)new d(this));
          AppMethodBeat.o(191377);
          return;
          f = 90.0F;
          continue;
          f = 180.0F;
          continue;
          f = 270.0F;
          continue;
        }
      }
      AppMethodBeat.o(191377);
      return;
      float f = 0.0F;
    }
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    this.GxA = paramac;
  }
  
  public final void aSs() {}
  
  public final void fDy()
  {
    AppMethodBeat.i(191378);
    if ((!fDq()) && (this.enable))
    {
      fDr();
      fDx();
      fDw().show();
    }
    AppMethodBeat.o(191378);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(191379);
    if (this.GGS)
    {
      wG(false);
      AppMethodBeat.o(191379);
      return true;
    }
    AppMethodBeat.o(191379);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191382);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191382);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  public final void wF(boolean paramBoolean)
  {
    AppMethodBeat.i(191375);
    this.enable = paramBoolean;
    if (paramBoolean)
    {
      this.GHL.setVisibility(0);
      AppMethodBeat.o(191375);
      return;
    }
    this.GHL.setVisibility(8);
    AppMethodBeat.o(191375);
  }
  
  public final void wG(boolean paramBoolean)
  {
    AppMethodBeat.i(191376);
    this.GGS = paramBoolean;
    Object localObject;
    d.c localc;
    Bundle localBundle;
    if (this.GGS)
    {
      this.GHM.setVisibility(0);
      this.GHL.setVisibility(8);
      localObject = fDs();
      p.g(localObject, "editorControlIconsContainer");
      ((View)localObject).setVisibility(8);
      localObject = fDt();
      p.g(localObject, "finishBtn");
      ((Button)localObject).setText((CharSequence)this.context.getString(2131755921));
      localObject = this.wgr;
      localc = d.c.BVA;
      localBundle = new Bundle();
      if (!this.GGS) {
        break label202;
      }
    }
    label202:
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("PARAM_1_INT", i);
      ((d)localObject).a(localc, localBundle);
      AppMethodBeat.o(191376);
      return;
      this.GHM.setVisibility(8);
      this.GHL.setVisibility(0);
      localObject = fDs();
      p.g(localObject, "editorControlIconsContainer");
      ((View)localObject).setVisibility(0);
      localObject = fDt();
      p.g(localObject, "finishBtn");
      ((Button)localObject).setText((CharSequence)this.context.getString(2131755916));
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<View>
  {
    b(s params)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<View>
  {
    c(s params)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "thumb", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$ensureThumb$2$1"})
  static final class d
    extends q
    implements m<Long, Bitmap, x>
  {
    d(s params)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<Button>
  {
    e(s params)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(s params)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    g(s params)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/design/widget/BottomSheetDialog;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<android.support.design.widget.a>
  {
    h(s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.s
 * JD-Core Version:    0.7.0.1
 */