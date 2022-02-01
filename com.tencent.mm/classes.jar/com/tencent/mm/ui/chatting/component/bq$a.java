package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$BarStatus;", "", "(Ljava/lang/String;I)V", "BarStatusEmpty", "BarStatusTranslating", "BarStatusTranslateFinish", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum bq$a
{
  static
  {
    AppMethodBeat.i(255895);
    aeyN = new a("BarStatusEmpty", 0);
    aeyO = new a("BarStatusTranslating", 1);
    aeyP = new a("BarStatusTranslateFinish", 2);
    aeyQ = new a[] { aeyN, aeyO, aeyP };
    AppMethodBeat.o(255895);
  }
  
  private bq$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bq.a
 * JD-Core Version:    0.7.0.1
 */