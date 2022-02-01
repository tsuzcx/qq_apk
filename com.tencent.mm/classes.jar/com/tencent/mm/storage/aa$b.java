package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardScene;", "", "scene", "", "(Ljava/lang/String;II)V", "getScene", "()I", "RECYCLE_CARD_SCENE_NEW_MSG", "RECYCLE_CARD_SCENE_ENTER_BOX", "RECYCLE_CARD_SCENE_FEEDBACK", "RECYCLE_CARD_SCENE_RESORT", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum aa$b
{
  final int scene;
  
  static
  {
    AppMethodBeat.i(248764);
    acFi = new b("RECYCLE_CARD_SCENE_NEW_MSG", 0, 1);
    acFj = new b("RECYCLE_CARD_SCENE_ENTER_BOX", 1, 2);
    acFk = new b("RECYCLE_CARD_SCENE_FEEDBACK", 2, 3);
    acFl = new b("RECYCLE_CARD_SCENE_RESORT", 3, 4);
    acFm = new b[] { acFi, acFj, acFk, acFl };
    AppMethodBeat.o(248764);
  }
  
  private aa$b(int paramInt)
  {
    this.scene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.aa.b
 * JD-Core Version:    0.7.0.1
 */