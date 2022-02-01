package com.tencent.mm.w.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a.b
{
  public com.tencent.mm.plugin.account.friend.a.a gun;
  public boolean guo;
  private a gup;
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(127653);
    this.gup = new a();
    AppMethodBeat.o(127653);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(127654);
    this.username = this.kno.tEY;
    this.contact = ((l)g.ab(l.class)).azF().BH(this.username);
    paramVarArgs = (com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    int i = (int)this.kno.tGf;
    parama = new com.tencent.mm.plugin.account.friend.a.a();
    String str = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + i + ';';
    paramVarArgs = paramVarArgs.hKK.a(str, null, 2);
    if (paramVarArgs.moveToFirst()) {
      parama.convertFrom(paramVarArgs);
    }
    paramVarArgs.close();
    this.gun = parama;
    str = this.gun.aSX();
    boolean bool1;
    int j;
    switch (this.kno.tEX)
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
        this.ofE = k.b(paramContext, str, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
        this.ofE = com.tencent.mm.plugin.fts.a.f.a(e.a(this.ofE, this.tFe, bool2, bool1)).tFv;
        label278:
        if (i != 0)
        {
          this.ofF = k.b(paramContext, parama, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
          this.ofF = com.tencent.mm.plugin.fts.a.f.a(e.a(this.ofF, this.tFe, bool2, bool1)).tFv;
          this.ofF = TextUtils.concat(new CharSequence[] { paramVarArgs, this.ofF });
        }
        AppMethodBeat.o(127654);
        return;
        bool1 = true;
        label354:
        bool2 = true;
        label357:
        parama = this.gun.aTc();
        paramVarArgs = paramContext.getString(2131762929);
        i = 0;
        j = 1;
        continue;
        parama = this.gun.aTc();
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
      parama = this.gun.getNickName();
      paramVarArgs = paramContext.getString(2131762936);
      i = 1;
      j = 0;
      break;
      this.ofE = k.b(paramContext, str, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
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
  
  public final a.b agQ()
  {
    return this.gup;
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
      if (paramVarArgs.gun == null)
      {
        AppMethodBeat.o(127652);
        return true;
      }
      if ((paramVarArgs.gun.status == 1) || (paramVarArgs.gun.status == 2))
      {
        ae.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Contact_User", c.this.gun.getUsername());
        paramVarArgs.putExtra("Contact_Nick", c.this.gun.getNickName());
        paramVarArgs.putExtra("Contact_Mobile_MD5", c.this.gun.Lj());
        paramVarArgs.putExtra("Contact_Alias", c.this.gun.jga);
        paramVarArgs.putExtra("Contact_Sex", c.this.gun.jfV);
        paramVarArgs.putExtra("Contact_Signature", c.this.gun.jfY);
        paramVarArgs.putExtra("Contact_RegionCode", RegionCodeDecoder.bg(c.this.gun.jge, c.this.gun.jfW, c.this.gun.jfX));
        paramVarArgs.putExtra("Contact_Scene", 13);
        paramVarArgs.putExtra("Contact_ShowUserName", false);
        if (c.this.guo) {
          paramVarArgs.putExtra("add_more_friend_search_scene", 1);
        }
        com.tencent.mm.plugin.account.a.a.iUz.c(paramVarArgs, paramContext);
        AppMethodBeat.o(127652);
        return true;
      }
      if (c.this.gun.status == 0)
      {
        ae.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
        paramVarArgs = new Intent(paramContext, InviteFriendUI.class);
        paramVarArgs.putExtra("friend_type", 1);
        paramVarArgs.putExtra("friend_user_name", c.this.gun.getUsername());
        paramVarArgs.putExtra("friend_num", c.this.gun.aTc());
        paramVarArgs.putExtra("friend_nick", c.this.gun.aSX());
        paramVarArgs.putExtra("friend_weixin_nick", c.this.gun.getNickName());
        paramVarArgs.putExtra("friend_scene", 13);
        paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().bc(paramVarArgs);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.ahE(), "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramVarArgs.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(127652);
        return true;
      }
      ae.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
      AppMethodBeat.o(127652);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.w.a.c
 * JD-Core Version:    0.7.0.1
 */