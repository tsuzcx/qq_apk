package com.tencent.mm.plugin.story.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fjj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "", "label", "", "storyInfos", "", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getLabel", "()Ljava/lang/String;", "getStoryInfos", "()Ljava/util/List;", "toString", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final List<h> Sve;
  final String label;
  
  public c()
  {
    this(null, null, 3);
  }
  
  public c(String paramString, List<h> paramList)
  {
    AppMethodBeat.i(119821);
    this.label = paramString;
    this.Sve = paramList;
    AppMethodBeat.o(119821);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119820);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = ((Iterable)this.Sve).iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (h)localIterator.next();
      if (((h)localObject2).SnL.hzt().abJZ.Zpr.size() > 0)
      {
        localObject1 = (fis)((h)localObject2).SnL.hzt().abJZ.Zpr.get(0);
        label88:
        StringBuilder localStringBuilder2 = new StringBuilder("\t[date=").append(((h)localObject2).field_date).append(" localId=").append((int)((h)localObject2).SnL.systemRowid).append(", storyId=").append(((h)localObject2).SnL.field_storyID).append(", thumb=");
        if (localObject1 != null) {
          break label192;
        }
        localObject2 = null;
        label148:
        localObject2 = localStringBuilder2.append(localObject2).append(", video=");
        if (localObject1 != null) {
          break label200;
        }
      }
      label192:
      label200:
      for (localObject1 = null;; localObject1 = ((fis)localObject1).Url)
      {
        localStringBuilder1.append(localObject1 + "]\n");
        break;
        localObject1 = null;
        break label88;
        localObject2 = ((fis)localObject1).aaTl;
        break label148;
      }
    }
    Object localObject1 = "[" + this.label + "] \n " + localStringBuilder1;
    AppMethodBeat.o(119820);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.c
 * JD-Core Version:    0.7.0.1
 */