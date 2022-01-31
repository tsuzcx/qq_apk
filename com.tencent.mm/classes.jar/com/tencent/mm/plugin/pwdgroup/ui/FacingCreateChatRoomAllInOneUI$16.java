package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

final class FacingCreateChatRoomAllInOneUI$16
  implements b.a
{
  FacingCreateChatRoomAllInOneUI$16(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(24001);
    ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
    if (paramBoolean)
    {
      Location localLocation = new Location(paramFloat2, paramFloat1, (int)paramDouble2, paramInt, "", "");
      if (!localLocation.dlP())
      {
        FacingCreateChatRoomAllInOneUI.a(this.pGF, localLocation);
        FacingCreateChatRoomAllInOneUI.b(this.pGF, true);
        FacingCreateChatRoomAllInOneUI.e(this.pGF);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(24001);
      return false;
      if ((!FacingCreateChatRoomAllInOneUI.j(this.pGF)) && (!d.agR()))
      {
        FacingCreateChatRoomAllInOneUI.k(this.pGF);
        h.a(this.pGF, this.pGF.getString(2131300538), this.pGF.getString(2131297087), this.pGF.getString(2131300996), this.pGF.getString(2131296888), false, new FacingCreateChatRoomAllInOneUI.16.1(this), null);
      }
      FacingCreateChatRoomAllInOneUI.b(this.pGF, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.16
 * JD-Core Version:    0.7.0.1
 */