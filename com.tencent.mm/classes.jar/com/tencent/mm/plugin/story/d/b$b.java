package com.tencent.mm.plugin.story.d;

import a.l;
import a.y;
import com.google.android.exoplayer2.v;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.chj;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "", "back", "", "checkLocation", "", "destroy", "getItemContainer", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;", "getLocation", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "getMusicRequestId", "", "getVideoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "isShow", "isShowSmileyPanel", "isShowTextEditor", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPause", "onResume", "reset", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setup", "videoPath", "", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "startTime", "endTime", "isPhotoToVideo", "config", "Lcom/tencent/mm/plugin/story/config/EditorConfig;", "videoPreparedCallback", "Lkotlin/Function0;", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "textBgColor", "mode", "plugin-story_release"})
public abstract interface b$b
{
  public abstract boolean Pk();
  
  public abstract void a(String paramString, ArrayList<String> paramArrayList, long paramLong1, long paramLong2, boolean paramBoolean, com.tencent.mm.plugin.story.c.a parama, a.f.a.a<y> parama1);
  
  public abstract boolean czN();
  
  public abstract void destroy();
  
  public abstract EditorItemContainer getItemContainer();
  
  public abstract chj getLocation();
  
  public abstract VideoPlayerTextureView getVideoPlayView();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void reset();
  
  public abstract void setMusicPlayer(v paramv);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.d.b.b
 * JD-Core Version:    0.7.0.1
 */