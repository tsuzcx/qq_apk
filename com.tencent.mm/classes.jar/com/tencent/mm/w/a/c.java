package com.tencent.mm.w.a;

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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.h;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a.b
{
  public com.tencent.mm.plugin.account.friend.a.a fYr;
  public boolean fYs;
  private a fYt;
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(127653);
    this.fYt = new a();
    AppMethodBeat.o(127653);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(127654);
    this.username = this.jPN.sxG;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.username);
    paramVarArgs = (com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    int i = (int)this.jPN.syN;
    parama = new com.tencent.mm.plugin.account.friend.a.a();
    String str = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + i + ';';
    paramVarArgs = paramVarArgs.hpA.a(str, null, 2);
    if (paramVarArgs.moveToFirst()) {
      parama.convertFrom(paramVarArgs);
    }
    paramVarArgs.close();
    this.fYr = parama;
    str = this.fYr.aPm();
    boolean bool1;
    int j;
    switch (this.jPN.sxF)
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
        this.nyw = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str, com.tencent.mm.cc.a.au(paramContext, 2131165517));
        this.nyw = com.tencent.mm.plugin.fts.a.f.a(e.a(this.nyw, this.sxM, bool2, bool1)).syd;
        label278:
        if (i != 0)
        {
          this.nyx = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, com.tencent.mm.cc.a.au(paramContext, 2131165517));
          this.nyx = com.tencent.mm.plugin.fts.a.f.a(e.a(this.nyx, this.sxM, bool2, bool1)).syd;
          this.nyx = TextUtils.concat(new CharSequence[] { paramVarArgs, this.nyx });
        }
        AppMethodBeat.o(127654);
        return;
        bool1 = true;
        label354:
        bool2 = true;
        label357:
        parama = this.fYr.aPr();
        paramVarArgs = paramContext.getString(2131762929);
        i = 0;
        j = 1;
        continue;
        parama = this.fYr.aPr();
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
      parama = this.fYr.getNickName();
      paramVarArgs = paramContext.getString(2131762936);
      i = 1;
      j = 0;
      break;
      this.nyw = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str, com.tencent.mm.cc.a.au(paramContext, 2131165517));
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
  
  public final a.b adW()
  {
    return this.fYt;
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
      if (paramVarArgs.fYr == null)
      {
        AppMethodBeat.o(127652);
        return true;
      }
      if ((paramVarArgs.fYr.status == 1) || (paramVarArgs.fYr.status == 2))
      {
        ac.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Contact_User", c.this.fYr.getUsername());
        paramVarArgs.putExtra("Contact_Nick", c.this.fYr.getNickName());
        paramVarArgs.putExtra("Contact_Mobile_MD5", c.this.fYr.JC());
        paramVarArgs.putExtra("Contact_Alias", c.this.fYr.iJY);
        paramVarArgs.putExtra("Contact_Sex", c.this.fYr.iJT);
        paramVarArgs.putExtra("Contact_Signature", c.this.fYr.iJW);
        paramVarArgs.putExtra("Contact_RegionCode", RegionCodeDecoder.aW(c.this.fYr.iKc, c.this.fYr.iJU, c.this.fYr.iJV));
        paramVarArgs.putExtra("Contact_Scene", 13);
        paramVarArgs.putExtra("Contact_ShowUserName", false);
        if (c.this.fYs) {
          paramVarArgs.putExtra("add_more_friend_search_scene", 1);
        }
        com.tencent.mm.plugin.account.a.a.iyx.c(paramVarArgs, paramContext);
        AppMethodBeat.o(127652);
        return true;
      }
      if (c.this.fYr.status == 0)
      {
        ac.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
        paramVarArgs = new Intent(paramContext, InviteFriendUI.class);
        paramVarArgs.putExtra("friend_type", 1);
        paramVarArgs.putExtra("friend_user_name", c.this.fYr.getUsername());
        paramVarArgs.putExtra("friend_num", c.this.fYr.aPr());
        paramVarArgs.putExtra("friend_nick", c.this.fYr.aPm());
        paramVarArgs.putExtra("friend_weixin_nick", c.this.fYr.getNickName());
        paramVarArgs.putExtra("friend_scene", 13);
        paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().ba(paramVarArgs);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.aeD(), "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramVarArgs.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(127652);
        return true;
      }
      ac.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
      AppMethodBeat.o(127652);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.w.a.c
 * JD-Core Version:    0.7.0.1
 */