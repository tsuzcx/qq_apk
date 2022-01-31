package com.tencent.mm.w.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.fts.ui.a.b.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.RegionCodeDecoder;

public final class c$a
  extends b.b
{
  public c$a(c paramc)
  {
    super(paramc);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(124494);
    paramVarArgs = (c)paramVarArgs;
    if (paramVarArgs.ezA == null)
    {
      AppMethodBeat.o(124494);
      return true;
    }
    if ((paramVarArgs.ezA.status == 1) || (paramVarArgs.ezA.status == 2))
    {
      ab.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("Contact_User", this.ezD.ezA.getUsername());
      paramVarArgs.putExtra("Contact_Nick", this.ezD.ezA.aqc());
      paramVarArgs.putExtra("Contact_Mobile_MD5", this.ezD.ezA.Al());
      paramVarArgs.putExtra("Contact_Alias", this.ezD.ezA.gwU);
      paramVarArgs.putExtra("Contact_Sex", this.ezD.ezA.gwP);
      paramVarArgs.putExtra("Contact_Signature", this.ezD.ezA.gwS);
      paramVarArgs.putExtra("Contact_RegionCode", RegionCodeDecoder.aF(this.ezD.ezA.gwY, this.ezD.ezA.gwQ, this.ezD.ezA.gwR));
      paramVarArgs.putExtra("Contact_Scene", 13);
      paramVarArgs.putExtra("Contact_ShowUserName", false);
      if (this.ezD.ezB) {
        paramVarArgs.putExtra("add_more_friend_search_scene", 1);
      }
      com.tencent.mm.plugin.account.a.a.gmO.c(paramVarArgs, paramContext);
      AppMethodBeat.o(124494);
      return true;
    }
    if (this.ezD.ezA.status == 0)
    {
      ab.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
      paramVarArgs = new Intent(paramContext, InviteFriendUI.class);
      paramVarArgs.putExtra("friend_type", 1);
      paramVarArgs.putExtra("friend_user_name", this.ezD.ezA.getUsername());
      paramVarArgs.putExtra("friend_num", this.ezD.ezA.aqf());
      paramVarArgs.putExtra("friend_nick", this.ezD.ezA.apZ());
      paramVarArgs.putExtra("friend_weixin_nick", this.ezD.ezA.aqc());
      paramVarArgs.putExtra("friend_scene", 13);
      paramContext.startActivity(paramVarArgs);
      AppMethodBeat.o(124494);
      return true;
    }
    ab.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
    AppMethodBeat.o(124494);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.w.a.c.a
 * JD-Core Version:    0.7.0.1
 */