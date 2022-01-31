package com.tencent.mm.plugin.sport.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.storage.bd;
import java.util.List;

final class SportBlackListUI$2
  implements ContactListExpandPreference.a
{
  SportBlackListUI$2(SportBlackListUI paramSportBlackListUI) {}
  
  public final void JR()
  {
    AppMethodBeat.i(25140);
    SportBlackListUI.a(this.sqg).dnF();
    AppMethodBeat.o(25140);
  }
  
  public final void iw(int paramInt)
  {
    AppMethodBeat.i(25137);
    String str = SportBlackListUI.a(this.sqg).Mb(paramInt);
    SportBlackListUI.b(this.sqg).remove(str);
    SportBlackListUI.a(this.sqg).v(null, SportBlackListUI.b(this.sqg));
    SportBlackListUI.a(this.sqg).refresh();
    aw.aaz();
    t.h(c.YA().arw(str));
    com.tencent.mm.plugin.sport.a.d.kS(40);
    AppMethodBeat.o(25137);
  }
  
  public final void ix(int paramInt)
  {
    AppMethodBeat.i(25139);
    String str = SportBlackListUI.a(this.sqg).Mb(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", str);
    com.tencent.mm.bq.d.b(this.sqg, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(25139);
  }
  
  public final void iy(int paramInt)
  {
    AppMethodBeat.i(25138);
    SportBlackListUI.c(this.sqg);
    AppMethodBeat.o(25138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportBlackListUI.2
 * JD-Core Version:    0.7.0.1
 */