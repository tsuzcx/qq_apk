package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ad;
import java.util.List;

public final class am$2
  implements DialogInterface.OnClickListener
{
  public am$2(Context paramContext, ad paramad, List paramList, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31034);
    am.a(this.val$context, this.ejm, this.zCu, this.zCv);
    AppMethodBeat.o(31034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.am.2
 * JD-Core Version:    0.7.0.1
 */