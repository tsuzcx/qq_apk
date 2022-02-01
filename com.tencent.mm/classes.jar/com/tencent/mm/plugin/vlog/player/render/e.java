package com.tencent.mm.plugin.vlog.player.render;

import android.util.Size;
import com.tencent.mm.plugin.vlog.model.p;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "", "()V", "inputTracks", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/TrackRenderInfo;", "Lkotlin/collections/ArrayList;", "getInputTracks", "()Ljava/util/ArrayList;", "setInputTracks", "(Ljava/util/ArrayList;)V", "renderSize", "Landroid/util/Size;", "getRenderSize", "()Landroid/util/Size;", "setRenderSize", "(Landroid/util/Size;)V", "release", "", "render", "Lcom/tencent/tav/coremedia/TextureInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "ptsMs", "", "inputTextures", "", "trackList", "updateInputTracks", "track", "updateRenderSize", "size", "Companion", "plugin-vlog_release"})
public abstract class e
{
  public static final e.a Arh = new e.a((byte)0);
  volatile Size AqM = new Size(0, 0);
  ArrayList<p> Arg = new ArrayList();
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.render.e
 * JD-Core Version:    0.7.0.1
 */