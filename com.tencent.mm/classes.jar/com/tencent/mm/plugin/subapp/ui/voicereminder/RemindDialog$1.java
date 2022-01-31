package com.tencent.mm.plugin.subapp.ui.voicereminder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class RemindDialog$1
  implements ao.d
{
  RemindDialog$1(RemindDialog paramRemindDialog) {}
  
  public final void w(String paramString, long paramLong)
  {
    AppMethodBeat.i(25559);
    ab.d("MicroMsg.RemindDialog", "onVoiceRemind ".concat(String.valueOf(paramString)));
    RemindDialog.a(this.sZX).add(paramString);
    RemindDialog.b(this.sZX);
    AppMethodBeat.o(25559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.1
 * JD-Core Version:    0.7.0.1
 */