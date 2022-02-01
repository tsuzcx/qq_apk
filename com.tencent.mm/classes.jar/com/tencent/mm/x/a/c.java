package com.tencent.mm.x.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.b.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a.b
{
  public com.tencent.mm.plugin.account.friend.a.a fUw;
  public boolean fUx;
  private a fUy;
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(127653);
    this.fUy = new a();
    AppMethodBeat.o(127653);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(127654);
    this.username = this.jpy.roN;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.username);
    paramVarArgs = (com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    int i = (int)this.jpy.rpT;
    parama = new com.tencent.mm.plugin.account.friend.a.a();
    String str = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + i + ';';
    paramVarArgs = paramVarArgs.gPa.a(str, null, 2);
    if (paramVarArgs.moveToFirst()) {
      parama.convertFrom(paramVarArgs);
    }
    paramVarArgs.close();
    this.fUw = parama;
    str = this.fUw.aIv();
    boolean bool1;
    int j;
    switch (this.jpy.roM)
    {
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 15: 
    default: 
      bool1 = false;
      bool2 = false;
      i = 0;
      j = 0;
      parama = null;
      paramVarArgs = null;
    case 14: 
    case 16: 
    case 7: 
      while (j != 0)
      {
        this.mVX = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
        this.mVX = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mVX, this.roS, bool2, bool1)).rpj;
        label278:
        if (i != 0)
        {
          this.mVY = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
          this.mVY = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mVY, this.roS, bool2, bool1)).rpj;
          this.mVY = TextUtils.concat(new CharSequence[] { paramVarArgs, this.mVY });
        }
        AppMethodBeat.o(127654);
        return;
        bool1 = true;
        label354:
        bool2 = true;
        label357:
        parama = this.fUw.aIA();
        paramVarArgs = paramContext.getString(2131762929);
        i = 0;
        j = 1;
        continue;
        parama = this.fUw.aIA();
        paramVarArgs = paramContext.getString(2131762929);
        bool1 = false;
        bool2 = false;
        i = 1;
        j = 0;
        continue;
        bool1 = true;
      }
    }
    label414:
    for (boolean bool2 = true;; bool2 = false)
    {
      parama = this.fUw.getNickName();
      paramVarArgs = paramContext.getString(2131762936);
      i = 1;
      j = 0;
      break;
      this.mVX = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
      break label278;
      bool1 = false;
      break label354;
      bool1 = false;
      bool2 = false;
      break label357;
      bool1 = false;
      break label414;
      bool1 = false;
    }
  }
  
  public final a.b acQ()
  {
    return this.fUy;
  }
  
  public final class a
    extends b.b
  {
    public a()
    {
      super();
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(127652);
      paramVarArgs = (c)paramVarArgs;
      if (paramVarArgs.fUw == null)
      {
        AppMethodBeat.o(127652);
        return true;
      }
      if ((paramVarArgs.fUw.status == 1) || (paramVarArgs.fUw.status == 2))
      {
        ad.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Contact_User", c.this.fUw.getUsername());
        paramVarArgs.putExtra("Contact_Nick", c.this.fUw.getNickName());
        paramVarArgs.putExtra("Contact_Mobile_MD5", c.this.fUw.JS());
        paramVarArgs.putExtra("Contact_Alias", c.this.fUw.ijR);
        paramVarArgs.putExtra("Contact_Sex", c.this.fUw.ijM);
        paramVarArgs.putExtra("Contact_Signature", c.this.fUw.ijP);
        paramVarArgs.putExtra("Contact_RegionCode", RegionCodeDecoder.aT(c.this.fUw.ijV, c.this.fUw.ijN, c.this.fUw.ijO));
        paramVarArgs.putExtra("Contact_Scene", 13);
        paramVarArgs.putExtra("Contact_ShowUserName", false);
        if (c.this.fUx) {
          paramVarArgs.putExtra("add_more_friend_search_scene", 1);
        }
        com.tencent.mm.plugin.account.a.a.hYt.c(paramVarArgs, paramContext);
        AppMethodBeat.o(127652);
        return true;
      }
      if (c.this.fUw.status == 0)
      {
        ad.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
        paramVarArgs = new Intent(paramContext, InviteFriendUI.class);
        paramVarArgs.putExtra("friend_type", 1);
        paramVarArgs.putExtra("friend_user_name", c.this.fUw.getUsername());
        paramVarArgs.putExtra("friend_num", c.this.fUw.aIA());
        paramVarArgs.putExtra("friend_nick", c.this.fUw.aIv());
        paramVarArgs.putExtra("friend_weixin_nick", c.this.fUw.getNickName());
        paramVarArgs.putExtra("friend_scene", 13);
        paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().bd(paramVarArgs);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.adn(), "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramVarArgs.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(127652);
        return true;
      }
      ad.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
      AppMethodBeat.o(127652);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.x.a.c
 * JD-Core Version:    0.7.0.1
 */