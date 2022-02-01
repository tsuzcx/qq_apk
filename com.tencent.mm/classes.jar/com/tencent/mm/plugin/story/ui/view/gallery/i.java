package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ox;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.e;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.model.d.j;
import com.tencent.mm.plugin.story.model.e.a;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "", "()V", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  boolean SCA;
  private b SCB;
  private boolean SCC;
  e SCv;
  private boolean SCw;
  private String SCx;
  private boolean SCy;
  private j SCz;
  final String TAG;
  boolean lAj;
  
  public i()
  {
    AppMethodBeat.i(120526);
    this.TAG = "MicroMsg.Gallery.StoryImageVideoViewMgr";
    this.SCB = new b(MMApplicationContext.getContext());
    AppMethodBeat.o(120526);
  }
  
  private final void Y(ViewGroup paramViewGroup)
  {
    int j = 0;
    AppMethodBeat.i(120516);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.SCv;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.SCv;
      if (localObject2 != null) {
        break label225;
      }
      bool = false;
      label68:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.SCv;
      if (localObject1 != null) {
        break label235;
      }
      localObject1 = null;
      label96:
      if (localObject1 == null) {
        break label245;
      }
      i = localObject1.hashCode();
      label107:
      localObject1 = ((StringBuilder)localObject2).append(i).append(", newParent:");
      i = j;
      if (paramViewGroup != null) {
        i = paramViewGroup.hashCode();
      }
      Log.i(str, i + ", isPlayingVideoItem:" + this.SCy);
      localObject1 = this.SCv;
      if (localObject1 != null) {
        break label250;
      }
      localObject1 = null;
      label171:
      if ((localObject1 == null) || (Z(paramViewGroup))) {
        break label287;
      }
      a(this);
      paramViewGroup = this.SCv;
      if (paramViewGroup != null) {
        break label260;
      }
    }
    label260:
    for (paramViewGroup = null;; paramViewGroup = paramViewGroup.getParent())
    {
      if (paramViewGroup != null) {
        break label268;
      }
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(120516);
      throw paramViewGroup;
      i = 0;
      break;
      label225:
      bool = ((e)localObject2).isPlaying();
      break label68;
      label235:
      localObject1 = ((e)localObject1).getParent();
      break label96;
      label245:
      i = 0;
      break label107;
      label250:
      localObject1 = ((e)localObject1).getParent();
      break label171;
    }
    label268:
    ((ViewGroup)paramViewGroup).removeView((View)this.SCv);
    this.SCz = null;
    label287:
    AppMethodBeat.o(120516);
  }
  
  private final boolean Z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120517);
    Object localObject = this.SCv;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((e)localObject).getParent())
    {
      boolean bool = s.p(localObject, paramViewGroup);
      AppMethodBeat.o(120517);
      return bool;
    }
  }
  
  private final boolean g(j paramj)
  {
    AppMethodBeat.i(120518);
    int i;
    if (paramj.icg != 0)
    {
      localObject = this.SCz;
      if ((localObject != null) && (((j)localObject).icg == paramj.icg)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(120518);
        return true;
      }
    }
    Object localObject = (CharSequence)paramj.Smx.Url;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label139;
      }
      localObject = this.SCz;
      if (localObject != null) {
        break label117;
      }
      localObject = null;
    }
    for (;;)
    {
      if (!s.p(localObject, paramj.Smx.Url)) {
        break label139;
      }
      AppMethodBeat.o(120518);
      return true;
      i = 0;
      break;
      label117:
      localObject = ((j)localObject).Smx;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((fis)localObject).Url;
      }
    }
    label139:
    AppMethodBeat.o(120518);
    return false;
  }
  
  private final void hAk()
  {
    AppMethodBeat.i(120522);
    Log.i(this.TAG, s.X("setVideoViewProp, isMute:", Boolean.valueOf(this.lAj)));
    e locale = this.SCv;
    if (locale != null) {
      locale.setMute(this.lAj);
    }
    AppMethodBeat.o(120522);
  }
  
  private final void kd(Context paramContext)
  {
    AppMethodBeat.i(120519);
    a locala = a.SmE;
    this.SCv = a.kc(paramContext);
    this.SCy = false;
    AppMethodBeat.o(120519);
  }
  
  public final void EZ(boolean paramBoolean)
  {
    AppMethodBeat.i(120520);
    Log.i(this.TAG, s.X("stopVideo, detach: ", Boolean.valueOf(paramBoolean)));
    if (this.SCy)
    {
      this.SCx = null;
      e locale = this.SCv;
      if (locale != null) {
        locale.stop();
      }
      this.SCw = false;
      if (this.SCC)
      {
        this.SCB.aPS();
        this.SCC = false;
      }
      this.SCy = false;
    }
    if (paramBoolean)
    {
      this.SCA = false;
      Y(null);
    }
    AppMethodBeat.o(120520);
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120514);
    s.u(paramViewGroup, "parent");
    boolean bool = Z(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.SCw).append(", currentSessionId:").append(this.SCx).append(", isPlayingVideoItem:").append(this.SCy).append(" videoView ");
    Object localObject = this.SCv;
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, localObject + " sameParent " + bool + " this:" + hashCode());
      Y(paramViewGroup);
      if (this.SCv == null)
      {
        localObject = MMApplicationContext.getContext();
        s.s(localObject, "getContext()");
        kd((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break label224;
      }
      paramViewGroup.addView((View)this.SCv);
    }
    for (;;)
    {
      paramViewGroup = this.SCv;
      if (paramViewGroup != null) {
        paramViewGroup.setAlpha(0.0F);
      }
      AppMethodBeat.o(120514);
      return;
      localObject = Integer.valueOf(((e)localObject).hashCode());
      break;
      label224:
      paramViewGroup.addView((View)this.SCv, paramLayoutParams);
      continue;
      label239:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.SCv;
        if (paramViewGroup != null) {
          paramViewGroup.setLayoutParams(paramLayoutParams);
        }
      }
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(120515);
    s.u(paramj, "item");
    if (!g(paramj)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(this.TAG, "change:" + bool + ' ' + this.SCA + ", " + paramBoolean + ", changeVideoItem: origin: " + this.SCz + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.SCz = paramj;
        if ((this.SCA) || (paramBoolean))
        {
          a(this);
          atK();
        }
      }
      AppMethodBeat.o(120515);
      return;
    }
  }
  
  public final void atK()
  {
    AppMethodBeat.i(120521);
    Log.printInfoStack(this.TAG, "playVideo, " + this.SCw + ' ' + this.SCA + ", " + this.SCz, new Object[0]);
    hAk();
    this.SCA = true;
    j localj = this.SCz;
    if (localj != null)
    {
      boolean bool = this.SCw;
      this.SCw = false;
      if (!bool) {
        break label201;
      }
      localObject1 = this.SCv;
      if (localObject1 != null) {
        ((e)localObject1).setAlpha(1.0F);
      }
      localObject1 = this.SCv;
      if (localObject1 != null) {
        ((e)localObject1).b(localj.Smy);
      }
      this.SCw = false;
      if (localj.heF()) {
        this.SCy = true;
      }
      if (!this.SCC)
      {
        this.SCB.requestFocus();
        this.SCC = true;
      }
    }
    Object localObject1 = h.SqZ;
    Object localObject2 = h.hxW();
    localObject1 = this.SCv;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((e)localObject1).getContext())
    {
      ((ox)localObject2).itb = NetStatusUtil.getIOSNetType((Context)localObject1);
      AppMethodBeat.o(120521);
      return;
      label201:
      this.SCx = UUID.randomUUID().toString();
      e locale = this.SCv;
      if (locale == null) {
        break;
      }
      localObject2 = localj.Smy;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new c();
      }
      locale.a((c)localObject1);
      break;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120525);
    Log.i(this.TAG, s.X("onUIDestroy ", Integer.valueOf(hashCode())));
    this.SCA = false;
    Y(null);
    this.SCz = null;
    this.SCv = null;
    if (this.SCC)
    {
      this.SCB.aPS();
      this.SCC = false;
    }
    AppMethodBeat.o(120525);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120524);
    Log.i(this.TAG, s.X("onUIPause ", Integer.valueOf(hashCode())));
    Y(null);
    if (this.SCC)
    {
      this.SCB.aPS();
      this.SCC = false;
    }
    AppMethodBeat.o(120524);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120523);
    Log.i(this.TAG, s.X("onUIResume ", Integer.valueOf(hashCode())));
    if (this.SCA)
    {
      e locale = this.SCv;
      if (locale != null) {
        locale.onUIResume();
      }
      if (!this.SCC)
      {
        this.SCB.requestFocus();
        this.SCC = true;
      }
    }
    AppMethodBeat.o(120523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.i
 * JD-Core Version:    0.7.0.1
 */