package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.a;
import com.tencent.mm.media.editor.a.h;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.story.ui.view.editor.item.g;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "pendingTextItem", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/TextItemView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;", "setView", "(Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;)V", "addEmojiItem", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addTextItem", "text", "", "textColor", "", "textBgColor", "getDrawingRect", "", "getEditorDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "Lkotlin/collections/ArrayList;", "getEditorItemList", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getEmojiCount", "getTextCount", "gotoClipMode", "gotoPreviewMode", "initConfig", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "initSafeArea", "onBackPress", "", "onPause", "onResume", "release", "reset", "setVisibility", "visibility", "showPreview", "plugin-recordvideo_release"})
public final class e
  implements q
{
  d qbI;
  public g qbP;
  public EditorItemContainer qbQ;
  
  public e(EditorItemContainer paramEditorItemContainer, d paramd)
  {
    AppMethodBeat.i(150615);
    this.qbQ = paramEditorItemContainer;
    this.qbI = paramd;
    this.qbQ.setOnTextClick((View.OnClickListener)new e.1(this));
    this.qbQ.setDeleteStateListener((a.f.a.b)new e.2(this));
    this.qbQ.setSafeType(1);
    AppMethodBeat.o(150615);
  }
  
  public final boolean cgq()
  {
    return false;
  }
  
  public final ArrayList<com.tencent.mm.media.editor.a.b> cgr()
  {
    AppMethodBeat.i(150609);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.qbQ.getAllItemViews()).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.media.editor.a.b localb = ((h)localIterator.next()).UH();
      if (localb != null) {
        localArrayList.add(localb);
      }
    }
    AppMethodBeat.o(150609);
    return localArrayList;
  }
  
  public final ArrayList<a> cgs()
  {
    AppMethodBeat.i(150610);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.qbQ.getAllItemViews()).iterator();
    while (localIterator.hasNext())
    {
      a locala = ((h)localIterator.next()).UI();
      if (locala != null) {
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(150610);
    return localArrayList;
  }
  
  public final void cgt()
  {
    AppMethodBeat.i(150614);
    this.qbQ.setEnableTouch(true);
    AppMethodBeat.o(150614);
  }
  
  public final int cgu()
  {
    AppMethodBeat.i(154635);
    int i = 0;
    Iterator localIterator = ((Iterable)this.qbQ.getAllItemViews()).iterator();
    if (localIterator.hasNext())
    {
      if (!((h)localIterator.next() instanceof com.tencent.mm.plugin.story.ui.view.editor.item.b)) {
        break label61;
      }
      i += 1;
    }
    label61:
    for (;;)
    {
      break;
      AppMethodBeat.o(154635);
      return i;
    }
  }
  
  public final int cgv()
  {
    AppMethodBeat.i(154636);
    int i = 0;
    Iterator localIterator = ((Iterable)this.qbQ.getAllItemViews()).iterator();
    if (localIterator.hasNext())
    {
      if (!((h)localIterator.next() instanceof g)) {
        break label61;
      }
      i += 1;
    }
    label61:
    for (;;)
    {
      break;
      AppMethodBeat.o(154636);
      return i;
    }
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(150608);
    this.qbQ.pause();
    AppMethodBeat.o(150608);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(150611);
    this.qbQ.resume();
    AppMethodBeat.o(150611);
  }
  
  public final void release()
  {
    AppMethodBeat.i(150612);
    this.qbQ.reset();
    AppMethodBeat.o(150612);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(150613);
    this.qbQ.reset();
    AppMethodBeat.o(150613);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150607);
    this.qbQ.setVisibility(paramInt);
    AppMethodBeat.o(150607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.e
 * JD-Core Version:    0.7.0.1
 */