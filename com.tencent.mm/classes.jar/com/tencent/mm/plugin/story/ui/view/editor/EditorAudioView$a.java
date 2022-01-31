package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.baz;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "", "cancel", "", "confirm", "onAudioSelected", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "onLyricsSelected", "visible", "", "lyricsInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "pauseAudio", "toggleOrigin", "remove", "plugin-story_release"})
public abstract interface EditorAudioView$a
{
  public abstract void a(AudioCacheInfo paramAudioCacheInfo);
  
  public abstract void b(boolean paramBoolean, List<? extends baz> paramList);
  
  public abstract void kt(boolean paramBoolean);
  
  public abstract void pauseAudio();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView.a
 * JD-Core Version:    0.7.0.1
 */