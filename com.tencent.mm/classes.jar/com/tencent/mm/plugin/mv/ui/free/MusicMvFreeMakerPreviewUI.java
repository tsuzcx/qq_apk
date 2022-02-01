package com.tencent.mm.plugin.mv.ui.free;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.ui.BaseMusicMvUI;
import com.tencent.mm.plugin.mv.ui.uic.n;
import com.tencent.mm.plugin.mv.ui.uic.o;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFreeMakerPreviewUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "startPostUI", "", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "appendDefaultVideo", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "syncToRefObjects", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvFreeMakerPreviewUI
  extends BaseMusicMvUI
{
  public static final MusicMvFreeMakerPreviewUI.a MbY;
  private dtf LZM;
  private boolean LZN;
  
  static
  {
    AppMethodBeat.i(286865);
    MbY = new MusicMvFreeMakerPreviewUI.a((byte)0);
    AppMethodBeat.o(286865);
  }
  
  public MusicMvFreeMakerPreviewUI()
  {
    AppMethodBeat.i(286815);
    this.LZM = new dtf();
    AppMethodBeat.o(286815);
  }
  
  private static final void a(MusicMvFreeMakerPreviewUI paramMusicMvFreeMakerPreviewUI, View paramView)
  {
    AppMethodBeat.i(286832);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMvFreeMakerPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFreeMakerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMusicMvFreeMakerPreviewUI, "this$0");
    com.tencent.mm.ae.d.B((kotlin.g.a.a)new e(paramMusicMvFreeMakerPreviewUI, com.tencent.mm.ui.base.k.a((Context)paramMusicMvFreeMakerPreviewUI.getContext(), paramMusicMvFreeMakerPreviewUI.getContext().getString(b.h.loading_tips), false, null)));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/free/MusicMvFreeMakerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286832);
  }
  
  private static final boolean a(MusicMvFreeMakerPreviewUI paramMusicMvFreeMakerPreviewUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(286823);
    s.u(paramMusicMvFreeMakerPreviewUI, "this$0");
    paramMusicMvFreeMakerPreviewUI.onBackPressed();
    AppMethodBeat.o(286823);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.f.LVw;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(286882);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(286882);
      return null;
    }
    localSet = ar.b(localSet, (Iterable)ar.setOf(new Class[] { n.class, a.class, o.class, com.tencent.mm.plugin.mv.ui.uic.q.class }));
    AppMethodBeat.o(286882);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(286911);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 7) && (paramInt2 == -1)) {
      finish();
    }
    AppMethodBeat.o(286911);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(286907);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    ((a)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(a.class)).gqk();
    AppMethodBeat.o(286907);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(286899);
    super.onCreate(paramBundle);
    setMMTitle(b.h.LVX);
    updateBackBtn(bb.m((Context)this, b.g.icons_filled_back2, -1));
    if (2 == getIntent().getIntExtra("key_mv_from_scene", 0)) {
      updateBackBtn(bb.m((Context)this, b.g.icons_filled_close, -1));
    }
    setBackBtn(new MusicMvFreeMakerPreviewUI..ExternalSyntheticLambda0(this));
    paramBundle = getWindow().getDecorView();
    s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    setActionbarColor(androidx.core.content.a.w((Context)this, b.b.transparent));
    hideActionbarLine();
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null) {
      this.LZM.parseFrom(paramBundle);
    }
    paramBundle = this.LZM.aaYK;
    label179:
    Object localObject1;
    if (paramBundle == null)
    {
      paramBundle = null;
      if ((paramBundle != null) && (!paramBundle.isEmpty())) {
        break label463;
      }
      Log.w("MicroMsg.MusicMvFreeMakerPreviewUI", s.X("null or empty track list: ", paramBundle));
      finish();
      j.gnw().gnj().wH(0);
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(n.class);
      s.s(paramBundle, "UICProvider.of(this).get…PreviewBgUIC::class.java)");
      localObject1 = (n)paramBundle;
      ((n)localObject1).thumbPath = this.LZM.aaYL;
      paramBundle = this.LZM.aaYK;
      if (paramBundle != null) {
        break label839;
      }
      paramBundle = null;
      label249:
      ((n)localObject1).thumbUrl = paramBundle;
      ((n)localObject1).a((com.tencent.mm.plugin.mv.ui.uic.u)new MusicMvFreeMakerPreviewUI.b());
      ((n)localObject1).LZM = this.LZM;
      ((n)localObject1).a((com.tencent.mm.plugin.thumbplayer.view.d)new MusicMvFreeMakerPreviewUI.c());
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = (a)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(a.class);
      s.s(paramBundle, "");
      ((n)localObject1).Mgt = ((kotlin.g.a.b)new d(paramBundle));
      paramBundle.e(this.LZM);
      paramBundle = (Button)findViewById(b.e.complete_btn);
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new MusicMvFreeMakerPreviewUI..ExternalSyntheticLambda1(this));
      }
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = (o)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(o.class);
      paramBundle = this.LZM.aaYK;
      if (paramBundle != null) {
        break label902;
      }
      paramBundle = null;
    }
    for (;;)
    {
      ((o)localObject1).LWI = paramBundle;
      ((o)localObject1).gre();
      AppMethodBeat.o(286899);
      return;
      paramBundle = paramBundle.objectDesc;
      if (paramBundle == null)
      {
        paramBundle = null;
        break;
      }
      paramBundle = paramBundle.mvInfo;
      if (paramBundle == null)
      {
        paramBundle = null;
        break;
      }
      paramBundle = paramBundle.ZWL;
      break;
      label463:
      localObject1 = this.LZM.aaYM;
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if ((localObject1 != null) && (((Integer)localObject1).intValue() > 0)) {
          break label539;
        }
        Log.w("MicroMsg.MusicMvFreeMakerPreviewUI", "invalid music duration");
        finish();
        break;
        localObject1 = ((bol)localObject1).LWI;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = Integer.valueOf(((boo)localObject1).duration);
        }
      }
      label539:
      Object localObject2 = this.LZM.ZJp;
      s.s(localObject2, "trackData.refObjectList");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((FinderObject)((Iterator)localObject3).next()).objectNonceId);
      }
      localObject2 = p.r((Iterable)localObject2);
      long l = 0L;
      localObject3 = ((Iterable)paramBundle).iterator();
      label718:
      label759:
      label762:
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label764;
        }
        boq localboq = (boq)((Iterator)localObject3).next();
        l += localboq.ZWY;
        if (localboq.refObjectId == 0L)
        {
          CharSequence localCharSequence = (CharSequence)localboq.ZWZ;
          if ((localCharSequence == null) || (localCharSequence.length() == 0))
          {
            i = 1;
            if ((i == 0) && (((Set)localObject2).contains(localboq.ZWZ))) {
              break label759;
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label762;
          }
          Log.i("MicroMsg.MusicMvFreeMakerPreviewUI", "default video has already been appended");
          break;
          i = 0;
          break label718;
        }
      }
      label764:
      localObject2 = new boq();
      ((boq)localObject2).TBM = l;
      ((boq)localObject2).ZWY = ((int)Math.max(((Integer)localObject1).intValue() - l, 0L));
      Log.i("MicroMsg.MusicMvFreeMakerPreviewUI", "append default video with " + ((boq)localObject2).ZWY + "ms duration");
      paramBundle.add(localObject2);
      break label179;
      label839:
      paramBundle = paramBundle.objectDesc;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label249;
      }
      paramBundle = paramBundle.media;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label249;
      }
      paramBundle = (FinderMedia)p.oL((List)paramBundle);
      if (paramBundle == null)
      {
        paramBundle = null;
        break label249;
      }
      paramBundle = s.X(paramBundle.thumbUrl, paramBundle.thumb_url_token);
      break label249;
      label902:
      paramBundle = paramBundle.objectDesc;
      if (paramBundle == null)
      {
        paramBundle = null;
      }
      else
      {
        paramBundle = paramBundle.mvInfo;
        if (paramBundle == null) {
          paramBundle = null;
        } else {
          paramBundle = paramBundle.LWI;
        }
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(286929);
    super.onPause();
    c localc = c.LLZ;
    c.gnQ();
    AppMethodBeat.o(286929);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(286921);
    super.onResume();
    if (!this.LZN)
    {
      this.LZN = false;
      c localc = c.LLZ;
      c.onResume();
    }
    AppMethodBeat.o(286921);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    e(MusicMvFreeMakerPreviewUI paramMusicMvFreeMakerPreviewUI, w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.free.MusicMvFreeMakerPreviewUI
 * JD-Core Version:    0.7.0.1
 */