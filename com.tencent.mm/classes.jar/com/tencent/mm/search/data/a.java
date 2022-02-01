package com.tencent.mm.search.data;

import com.tencent.mm.am.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "", "getSimilarEmojiList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onCrate", "onDestroy", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract void a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, h paramh);
  
  public abstract void iTu();
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.data.a
 * JD-Core Version:    0.7.0.1
 */