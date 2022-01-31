package com.tencent.mm.x.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.fts.ui.a.b.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;
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
    paramVarArgs = (c)paramVarArgs;
    if (paramVarArgs.dCj == null) {
      return true;
    }
    if ((paramVarArgs.dCj.status == 1) || (paramVarArgs.dCj.status == 2))
    {
      y.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("Contact_User", this.dCm.dCj.getUsername());
      paramVarArgs.putExtra("Contact_Nick", this.dCm.dCj.WA());
      paramVarArgs.putExtra("Contact_Mobile_MD5", this.dCm.dCj.Wv());
      paramVarArgs.putExtra("Contact_Alias", this.dCm.dCj.ffm);
      paramVarArgs.putExtra("Contact_Sex", this.dCm.dCj.ffh);
      paramVarArgs.putExtra("Contact_Signature", this.dCm.dCj.ffk);
      paramVarArgs.putExtra("Contact_RegionCode", RegionCodeDecoder.ao(this.dCm.dCj.ffq, this.dCm.dCj.ffi, this.dCm.dCj.ffj));
      paramVarArgs.putExtra("Contact_Scene", 13);
      paramVarArgs.putExtra("Contact_ShowUserName", false);
      if (this.dCm.dCk) {
        paramVarArgs.putExtra("add_more_friend_search_scene", 1);
      }
      com.tencent.mm.plugin.account.a.a.eUR.d(paramVarArgs, paramContext);
      return true;
    }
    if (this.dCm.dCj.status == 0)
    {
      y.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
      paramVarArgs = new Intent(paramContext, InviteFriendUI.class);
      paramVarArgs.putExtra("friend_type", 1);
      paramVarArgs.putExtra("friend_user_name", this.dCm.dCj.getUsername());
      paramVarArgs.putExtra("friend_num", this.dCm.dCj.WD());
      paramVarArgs.putExtra("friend_nick", this.dCm.dCj.Wx());
      paramVarArgs.putExtra("friend_weixin_nick", this.dCm.dCj.WA());
      paramVarArgs.putExtra("friend_scene", 13);
      paramContext.startActivity(paramVarArgs);
      return true;
    }
    y.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.x.a.c.a
 * JD-Core Version:    0.7.0.1
 */