package com.tencent.mm.plugin.vlog.player.a;

import android.util.Size;
import com.tencent.mm.plugin.vlog.model.u;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "", "()V", "inputTracks", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/TrackRenderInfo;", "Lkotlin/collections/ArrayList;", "getInputTracks", "()Ljava/util/ArrayList;", "setInputTracks", "(Ljava/util/ArrayList;)V", "renderSize", "Landroid/util/Size;", "getRenderSize", "()Landroid/util/Size;", "setRenderSize", "(Landroid/util/Size;)V", "release", "", "render", "Lcom/tencent/tav/coremedia/TextureInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "ptsMs", "", "inputTextures", "", "trackList", "updateInputTracks", "track", "updateRenderSize", "size", "Companion", "plugin-vlog_release"})
public abstract class e
{
  public static final a Lta = new a((byte)0);
  volatile Size LsG = new Size(0, 0);
  ArrayList<u> LsZ = new ArrayList();
  
  public void release() {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a.e
 * JD-Core Version:    0.7.0.1
 */