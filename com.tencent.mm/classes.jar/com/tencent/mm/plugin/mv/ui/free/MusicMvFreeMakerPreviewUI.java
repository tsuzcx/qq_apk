package com.tencent.mm.plugin.mv.ui.free;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.ui.BaseMusicMvUI;
import com.tencent.mm.plugin.mv.ui.uic.r;
import com.tencent.mm.plugin.mv.ui.uic.t;
import com.tencent.mm.plugin.mv.ui.widget.MvTracksEditView;
import com.tencent.mm.plugin.mv.ui.widget.MvTracksEditView.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFreeMakerPreviewUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "startPostUI", "", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "appendDefaultVideo", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "syncToRefObjects", "Companion", "plugin-mv_release"})
public final class MusicMvFreeMakerPreviewUI
  extends BaseMusicMvUI
{
  public static final MusicMvFreeMakerPreviewUI.a GgL;
  private dbo Geg;
  private boolean Geh;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(225974);
    GgL = new MusicMvFreeMakerPreviewUI.a((byte)0);
    AppMethodBeat.o(225974);
  }
  
  public MusicMvFreeMakerPreviewUI()
  {
    AppMethodBeat.i(225972);
    this.Geg = new dbo();
    AppMethodBeat.o(225972);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(225984);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(225984);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(225982);
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
    AppMethodBeat.o(225982);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.f.FZz;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(225936);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.b(localSet, (Iterable)ak.setOf(new Class[] { com.tencent.mm.plugin.mv.ui.uic.q.class, a.class, r.class, t.class }));
      AppMethodBeat.o(225936);
      return localSet;
    }
    AppMethodBeat.o(225936);
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(225967);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 7) && (paramInt2 == -1)) {
      finish();
    }
    AppMethodBeat.o(225967);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(225966);
    finish();
    AppMethodBeat.o(225966);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(225964);
    super.onCreate(paramBundle);
    setMMTitle(b.h.FZW);
    updateBackBtn(au.o((Context)this, b.g.icons_filled_back2, -1));
    if (2 == getIntent().getIntExtra("key_mv_from_scene", 0)) {
      updateBackBtn(au.o((Context)this, b.g.icons_filled_close, -1));
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    setActionbarColor(androidx.core.content.a.w((Context)this, b.b.transparent));
    hideActionbarLine();
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null) {
      this.Geg.parseFrom(paramBundle);
    }
    paramBundle = this.Geg.TIV;
    label215:
    Object localObject1;
    label350:
    Object localObject2;
    Object localObject3;
    label498:
    long l;
    label529:
    Object localObject4;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.objectDesc;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.mvInfo;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.SOE;
          if ((paramBundle != null) && (!paramBundle.isEmpty())) {
            break label926;
          }
          Log.w("MicroMsg.MusicMvFreeMakerPreviewUI", "null or empty track list: ".concat(String.valueOf(paramBundle)));
          finish();
          paramBundle = k.fet();
          p.j(paramBundle, "MusicPlayerManager.Instance()");
          paramBundle.feg().wG(0);
          paramBundle = com.tencent.mm.ui.component.g.Xox;
          paramBundle = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.mv.ui.uic.q.class);
          p.j(paramBundle, "UICProvider.of(this).get…PreviewBgUIC::class.java)");
          localObject1 = (com.tencent.mm.plugin.mv.ui.uic.q)paramBundle;
          ((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).thumbPath = this.Geg.TIW;
          paramBundle = this.Geg.TIV;
          if (paramBundle == null) {
            break label1296;
          }
          paramBundle = paramBundle.objectDesc;
          if (paramBundle == null) {
            break label1296;
          }
          paramBundle = paramBundle.media;
          if (paramBundle == null) {
            break label1296;
          }
          paramBundle = (FinderMedia)j.lp((List)paramBundle);
          if (paramBundle == null) {
            break label1296;
          }
          paramBundle = paramBundle.thumbUrl + paramBundle.thumb_url_token;
          ((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).thumbUrl = paramBundle;
          ((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).a((com.tencent.mm.plugin.mv.ui.uic.x)new c());
          ((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).Geg = this.Geg;
          ((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).a((com.tencent.mm.plugin.thumbplayer.view.d)new d());
          paramBundle = com.tencent.mm.ui.component.g.Xox;
          localObject2 = (a)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(a.class);
          ((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).GlX = ((kotlin.g.a.b)new e((a)localObject2));
          localObject3 = this.Geg;
          p.k(localObject3, "mvData");
          paramBundle = ((dbo)localObject3).TIV;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.objectDesc;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.mvInfo;
              if (paramBundle != null)
              {
                localObject1 = paramBundle.SOE;
                paramBundle = (Bundle)localObject1;
                if (localObject1 != null) {
                  break label498;
                }
              }
            }
          }
          paramBundle = new LinkedList();
          ((a)localObject2).Ggf = paramBundle;
          paramBundle = ((dbo)localObject3).TIX;
          if (paramBundle == null) {
            break label1301;
          }
          paramBundle = paramBundle.GaB;
          if (paramBundle == null) {
            break label1301;
          }
          l = paramBundle.duration;
          ((a)localObject2).Ggg = l;
          paramBundle = ((a)localObject2).getActivity().findViewById(b.e.FWZ);
          p.j(paramBundle, "activity.findViewById(R.id.crop_thumb_view)");
          ((a)localObject2).Ggc = ((MvTracksEditView)paramBundle);
          paramBundle = ((a)localObject2).getActivity().findViewById(b.e.complete_btn);
          p.j(paramBundle, "activity.findViewById(R.id.complete_btn)");
          ((a)localObject2).Gge = ((Button)paramBundle);
          paramBundle = ((a)localObject2).getActivity().findViewById(b.e.FWG);
          p.j(paramBundle, "activity.findViewById(R.id.cancel_select_button)");
          localObject1 = ((a)localObject2).getActivity().findViewById(b.e.FWS);
          p.j(localObject1, "activity.findViewById(R.id.complete_select_button)");
          localObject4 = ((a)localObject2).getActivity().findViewById(b.e.FYQ);
          p.j(localObject4, "activity.findViewById(R.…select_buttons_container)");
          ((a)localObject2).Ggd = ((ViewGroup)localObject4);
          localObject4 = ((a)localObject2).Ggc;
          if (localObject4 == null) {
            p.bGy("tracksEditView");
          }
          ((MvTracksEditView)localObject4).setThumbLoader(((a)localObject2).Ggi);
          paramBundle.setOnClickListener((View.OnClickListener)new a.b((a)localObject2));
          ((View)localObject1).setOnClickListener((View.OnClickListener)new a.c((a)localObject2));
          paramBundle = com.tencent.mm.ui.component.g.Xox;
          paramBundle = com.tencent.mm.ui.component.g.b(((a)localObject2).getActivity()).i(com.tencent.mm.plugin.mv.ui.uic.q.class);
          p.j(paramBundle, "UICProvider.of(activity)…PreviewBgUIC::class.java)");
          paramBundle = (com.tencent.mm.plugin.mv.ui.uic.q)paramBundle;
          localObject1 = ((a)localObject2).Ggc;
          if (localObject1 == null) {
            p.bGy("tracksEditView");
          }
          ((MvTracksEditView)localObject1).setCallback((MvTracksEditView.a)new a.d((a)localObject2, paramBundle));
          kotlinx.coroutines.g.b(((a)localObject2).rcY, null, (m)new a.e((a)localObject2, (dbo)localObject3, null), 3);
          paramBundle = (Button)findViewById(b.e.complete_btn);
          if (paramBundle != null) {
            paramBundle.setOnClickListener((View.OnClickListener)new f(this));
          }
          paramBundle = com.tencent.mm.ui.component.g.Xox;
          localObject1 = (r)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(r.class);
          paramBundle = this.Geg.TIV;
          if (paramBundle == null) {
            break label1306;
          }
          paramBundle = paramBundle.objectDesc;
          if (paramBundle == null) {
            break label1306;
          }
          paramBundle = paramBundle.mvInfo;
          if (paramBundle == null) {
            break label1306;
          }
        }
      }
    }
    label1175:
    label1306:
    for (paramBundle = paramBundle.GaB;; paramBundle = null)
    {
      ((r)localObject1).GaB = paramBundle;
      ((r)localObject1).fht();
      AppMethodBeat.o(225964);
      return;
      paramBundle = null;
      break;
      label926:
      localObject1 = this.Geg.TIX;
      if (localObject1 != null)
      {
        localObject1 = ((bdp)localObject1).GaB;
        if (localObject1 == null) {}
      }
      for (localObject1 = Integer.valueOf(((bds)localObject1).duration);; localObject1 = null)
      {
        if ((localObject1 != null) && (((Integer)localObject1).intValue() > 0)) {
          break label996;
        }
        Log.w("MicroMsg.MusicMvFreeMakerPreviewUI", "invalid music duration");
        finish();
        break;
      }
      label996:
      localObject2 = this.Geg.SGC;
      p.j(localObject2, "trackData.refObjectList");
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((FinderObject)((Iterator)localObject3).next()).objectNonceId);
      }
      localObject2 = j.r((Iterable)localObject2);
      l = 0L;
      localObject3 = ((Iterable)paramBundle).iterator();
      label1216:
      label1219:
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label1221;
        }
        localObject4 = (bdt)((Iterator)localObject3).next();
        l += ((bdt)localObject4).SOR;
        if (((bdt)localObject4).refObjectId == 0L)
        {
          CharSequence localCharSequence = (CharSequence)((bdt)localObject4).SOS;
          if ((localCharSequence == null) || (localCharSequence.length() == 0))
          {
            i = 1;
            if ((i == 0) && (((Set)localObject2).contains(((bdt)localObject4).SOS))) {
              break label1216;
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label1219;
          }
          Log.i("MicroMsg.MusicMvFreeMakerPreviewUI", "default video has already been appended");
          break;
          i = 0;
          break label1175;
        }
      }
      label1221:
      localObject2 = new bdt();
      ((bdt)localObject2).MSE = l;
      ((bdt)localObject2).SOR = ((int)Math.max(((Integer)localObject1).intValue() - l, 0L));
      Log.i("MicroMsg.MusicMvFreeMakerPreviewUI", "append default video with " + ((bdt)localObject2).SOR + "ms duration");
      paramBundle.add(localObject2);
      break label215;
      paramBundle = null;
      break label350;
      l = 0L;
      break label529;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(225971);
    super.onPause();
    c localc = c.FRf;
    c.feJ();
    AppMethodBeat.o(225971);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(225969);
    super.onResume();
    if (!this.Geh)
    {
      this.Geh = false;
      c localc = c.FRf;
      c.onResume();
    }
    AppMethodBeat.o(225969);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(MusicMvFreeMakerPreviewUI paramMusicMvFreeMakerPreviewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(232045);
      this.GgM.onBackPressed();
      AppMethodBeat.o(232045);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/free/MusicMvFreeMakerPreviewUI$onCreate$4", "Lcom/tencent/mm/plugin/mv/ui/uic/OnBackgroundBitmapReadyListener;", "onReady", "", "bitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
  public static final class c
    implements com.tencent.mm.plugin.mv.ui.uic.x
  {
    public final void ah(Bitmap paramBitmap)
    {
      AppMethodBeat.i(230361);
      p.k(paramBitmap, "bitmap");
      AppMethodBeat.o(230361);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/free/MusicMvFreeMakerPreviewUI$onCreate$5", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onChange", "", "index", "", "targetMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
  public static final class d
    implements com.tencent.mm.plugin.thumbplayer.view.d
  {
    public final void a(int paramInt, com.tencent.mm.plugin.thumbplayer.e.d paramd)
    {
      AppMethodBeat.i(231348);
      p.k(paramd, "targetMedia");
      Log.i("MicroMsg.MusicMvFreeMakerPreviewUI", "media changed: Index=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(231348);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(MusicMvFreeMakerPreviewUI paramMusicMvFreeMakerPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(225138);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFreeMakerPreviewUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      com.tencent.mm.ae.d.h((kotlin.g.a.a)new kotlin.g.b.q(h.a((Context)this.GgM.getContext(), this.GgM.getContext().getString(b.h.loading_tips), false, null))
      {
        @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
        static final class a
          extends kotlin.g.b.q
          implements kotlin.g.a.b<Boolean, kotlin.x>
        {
          a(MusicMvFreeMakerPreviewUI.f.1 param1)
          {
            super();
          }
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/free/MusicMvFreeMakerPreviewUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(225138);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.free.MusicMvFreeMakerPreviewUI
 * JD-Core Version:    0.7.0.1
 */