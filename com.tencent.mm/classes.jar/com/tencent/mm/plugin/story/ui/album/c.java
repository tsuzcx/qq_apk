package com.tencent.mm.plugin.story.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eek;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "", "label", "", "storyInfos", "", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getLabel", "()Ljava/lang/String;", "getStoryInfos", "()Ljava/util/List;", "toString", "plugin-story_release"})
public final class c
{
  final List<h> FyP;
  final String label;
  
  public c()
  {
    this(null, null, 3);
  }
  
  public c(String paramString, List<h> paramList)
  {
    AppMethodBeat.i(119821);
    this.label = paramString;
    this.FyP = paramList;
    AppMethodBeat.o(119821);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119820);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = ((Iterable)this.FyP).iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (h)localIterator.next();
      if (((h)localObject2).Fqr.frG().NeB.LoV.size() > 0)
      {
        localObject1 = (edt)((h)localObject2).Fqr.frG().NeB.LoV.get(0);
        label88:
        StringBuilder localStringBuilder2 = new StringBuilder("\t[date=").append(((h)localObject2).field_date).append(" localId=").append((int)((h)localObject2).Fqr.systemRowid).append(", storyId=").append(((h)localObject2).Fqr.field_storyID).append(", thumb=");
        if (localObject1 == null) {
          break label198;
        }
        localObject2 = ((edt)localObject1).Msz;
        label151:
        localObject2 = localStringBuilder2.append((String)localObject2).append(", video=");
        if (localObject1 == null) {
          break label203;
        }
      }
      label198:
      label203:
      for (localObject1 = ((edt)localObject1).Url;; localObject1 = null)
      {
        localStringBuilder1.append((String)localObject1 + "]\n");
        break;
        localObject1 = null;
        break label88;
        localObject2 = null;
        break label151;
      }
    }
    Object localObject1 = "[" + this.label + "] \n " + localStringBuilder1;
    AppMethodBeat.o(119820);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.c
 * JD-Core Version:    0.7.0.1
 */