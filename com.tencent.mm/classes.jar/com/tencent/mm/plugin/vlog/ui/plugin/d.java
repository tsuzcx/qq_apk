package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditImageAddMusicPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin$AudioStateListener;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addMusicGroup", "Landroid/view/View;", "addMusicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "addMusicIndicator", "addMusicText", "Landroid/widget/TextView;", "hasLocal", "", "hasMusic", "getLayout", "()Landroid/view/ViewGroup;", "musicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "onAudioPause", "", "onAudioResume", "setMusic", "setVisibility", "visibility", "", "updateContent", "plugin-vlog_release"})
public final class d
  implements t
{
  private final WeImageView GGH;
  private boolean GGI;
  private final ViewGroup wgq;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  private final View whe;
  private final WeImageView whf;
  private final TextView whg;
  private AudioCacheInfo whj;
  private boolean whk;
  
  public d(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(191217);
    this.wgq = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.wgq.findViewById(2131299830);
    p.g(paramViewGroup, "layout.findViewById(R.id.edit_image_add_music)");
    this.whe = paramViewGroup;
    paramViewGroup = this.wgq.findViewById(2131302535);
    p.g(paramViewGroup, "layout.findViewById(R.id.image_add_music_text)");
    this.whg = ((TextView)paramViewGroup);
    paramViewGroup = this.wgq.findViewById(2131302533);
    p.g(paramViewGroup, "layout.findViewById(R.id.image_add_music_icon)");
    this.whf = ((WeImageView)paramViewGroup);
    paramViewGroup = this.wgq.findViewById(2131302534);
    p.g(paramViewGroup, "layout.findViewById(R.id…mage_add_music_indicator)");
    this.GGH = ((WeImageView)paramViewGroup);
    this.whe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191213);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/EditImageAddMusicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.b.a(this.GGJ.wgr, d.c.BWV);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/EditImageAddMusicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191213);
      }
    });
    this.whg.setMaxWidth(com.tencent.mm.cb.a.jn(this.wgq.getContext()) - com.tencent.mm.cb.a.fromDPToPix(this.wgq.getContext(), 206));
    AppMethodBeat.o(191217);
  }
  
  private final void dFW()
  {
    Object localObject2 = null;
    AppMethodBeat.i(191216);
    if ((this.whk) || (this.GGI))
    {
      TextView localTextView = this.whg;
      Object localObject1 = this.whj;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((AudioCacheInfo)localObject1).BOZ;
        localObject1 = (Collection)localObject1;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label101;
        }
        i = 1;
        label61:
        if (i == 0) {
          break label111;
        }
        localObject1 = this.whj;
        if (localObject1 == null) {
          break label106;
        }
      }
      label101:
      label106:
      for (localObject1 = ((AudioCacheInfo)localObject1).BPc;; localObject1 = null)
      {
        localObject1 = (CharSequence)localObject1;
        localTextView.setText((CharSequence)localObject1);
        AppMethodBeat.o(191216);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label61;
      }
      label111:
      localObject1 = this.whj;
      if (localObject1 != null) {}
      for (localObject1 = ((AudioCacheInfo)localObject1).BOZ;; localObject1 = null)
      {
        String str = Util.listToString((List)localObject1, ",");
        StringBuilder localStringBuilder = new StringBuilder();
        AudioCacheInfo localAudioCacheInfo = this.whj;
        localObject1 = localObject2;
        if (localAudioCacheInfo != null) {
          localObject1 = localAudioCacheInfo.BPc;
        }
        localObject1 = (CharSequence)((String)localObject1 + " - " + str);
        break;
      }
    }
    this.whg.setText(2131758456);
    AppMethodBeat.o(191216);
  }
  
  public final void aSs() {}
  
  public final void f(AudioCacheInfo paramAudioCacheInfo)
  {
    boolean bool2 = false;
    AppMethodBeat.i(191214);
    this.whj = paramAudioCacheInfo;
    if (paramAudioCacheInfo != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.whk = bool1;
      bool1 = bool2;
      if (paramAudioCacheInfo != null) {
        bool1 = paramAudioCacheInfo.BPb;
      }
      this.GGI = bool1;
      dFW();
      AppMethodBeat.o(191214);
      return;
    }
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191218);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191218);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191215);
    if (!w.fBt())
    {
      this.whe.setVisibility(8);
      AppMethodBeat.o(191215);
      return;
    }
    if (this.whe.getVisibility() != paramInt)
    {
      this.whe.setVisibility(paramInt);
      if (this.whe.getVisibility() == 0) {
        dFW();
      }
    }
    AppMethodBeat.o(191215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.d
 * JD-Core Version:    0.7.0.1
 */