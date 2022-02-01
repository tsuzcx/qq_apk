package com.tencent.mm.videocomposition;

import android.util.Pair;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/ICompositionLabelRetriever;", "", "getVideoLabel", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "callback", "Lkotlin/Function1;", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "", "Lkotlin/collections/HashMap;", "isEnable", "", "video_composition_release"})
public abstract interface e
{
  public abstract void a(n paramn, b<? super HashMap<String, Pair<Integer, Long>>, x> paramb);
  
  public abstract boolean isEnable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.e
 * JD-Core Version:    0.7.0.1
 */