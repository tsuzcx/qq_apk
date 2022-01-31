package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.c;

final class FriendPreference$1$1
  implements h.c
{
  FriendPreference$1$1(FriendPreference.1 param1, String[] paramArrayOfString) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(23619);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23619);
      return;
      if ((this.pAM.pAK == null) || (this.pAM.pAK.length() == 0))
      {
        AppMethodBeat.o(23619);
        return;
      }
      paramInt = this.pAM.pAK.lastIndexOf(' ') + 1;
      if (paramInt > 0)
      {
        FriendPreference.a(this.pAM.pAL, this.pAM.pAK.substring(paramInt));
        AppMethodBeat.o(23619);
        return;
        if ((this.pAM.pAK == null) || (this.pAM.pAK.length() == 0))
        {
          AppMethodBeat.o(23619);
          return;
        }
        paramInt = this.pAM.pAK.lastIndexOf(' ');
        Object localObject = this.pAM.pAK.substring(0, paramInt);
        if ((localObject == null) || (((String)localObject).length() == 0))
        {
          AppMethodBeat.o(23619);
          return;
        }
        t.b(FriendPreference.c(this.pAM.pAL), ((String)localObject).trim());
        AppMethodBeat.o(23619);
        return;
        if ((this.hKi == null) || (this.hKi.length <= 2) || (FriendPreference.a(this.pAM.pAL) == null) || (FriendPreference.c(this.pAM.pAL) == null))
        {
          AppMethodBeat.o(23619);
          return;
        }
        if ((FriendPreference.a(this.pAM.pAL) != null) && (!bo.isNullOrNil(FriendPreference.a(this.pAM.pAL).fsf)))
        {
          FriendPreference.a(this.pAM.pAL, FriendPreference.c(this.pAM.pAL).field_username, FriendPreference.a(this.pAM.pAL).fsf);
          AppMethodBeat.o(23619);
          return;
        }
        localObject = new Intent();
        Bundle localBundle = new Bundle();
        localBundle.putInt("fromScene", 2);
        ((Intent)localObject).putExtra("reportArgs", localBundle);
        b.gmO.j((Intent)localObject, FriendPreference.b(this.pAM.pAL));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference.1.1
 * JD-Core Version:    0.7.0.1
 */