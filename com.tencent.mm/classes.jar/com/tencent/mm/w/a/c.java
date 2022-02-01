package com.tencent.mm.w.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a.b
{
  public com.tencent.mm.plugin.account.friend.a.a hhc;
  public boolean hhd;
  private a hhe;
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(127653);
    this.hhe = new a();
    AppMethodBeat.o(127653);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(127654);
    this.username = this.lqW.wVX;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.username);
    paramVarArgs = (com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    int i = (int)this.lqW.wXe;
    parama = new com.tencent.mm.plugin.account.friend.a.a();
    String str = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + i + ';';
    paramVarArgs = paramVarArgs.iFy.rawQuery(str, null, 2);
    if (paramVarArgs.moveToFirst()) {
      parama.convertFrom(paramVarArgs);
    }
    paramVarArgs.close();
    this.hhc = parama;
    str = this.hhc.bnK();
    boolean bool1;
    int j;
    switch (this.lqW.wVW)
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
        this.pqB = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, str, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
        this.pqB = com.tencent.mm.plugin.fts.a.f.a(e.a(this.pqB, this.wWd, bool2, bool1)).wWu;
        label278:
        if (i != 0)
        {
          this.pqC = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, parama, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
          this.pqC = com.tencent.mm.plugin.fts.a.f.a(e.a(this.pqC, this.wWd, bool2, bool1)).wWu;
          this.pqC = TextUtils.concat(new CharSequence[] { paramVarArgs, this.pqC });
        }
        AppMethodBeat.o(127654);
        return;
        bool1 = true;
        label354:
        bool2 = true;
        label357:
        parama = this.hhc.bnP();
        paramVarArgs = paramContext.getString(2131765065);
        i = 0;
        j = 1;
        continue;
        parama = this.hhc.bnP();
        paramVarArgs = paramContext.getString(2131765065);
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
      parama = this.hhc.getNickName();
      paramVarArgs = paramContext.getString(2131765072);
      i = 1;
      j = 0;
      break;
      this.pqB = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, str, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
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
  
  public final a.b axc()
  {
    return this.hhe;
  }
  
  public final class a
    extends b.b
  {
    public a()
    {
      super();
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(196835);
      paramView = (c)paramVarArgs;
      if (paramView.hhc == null)
      {
        AppMethodBeat.o(196835);
        return true;
      }
      if ((paramView.hhc.status == 1) || (paramView.hhc.status == 2))
      {
        Log.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
        paramView = new Intent();
        paramView.putExtra("Contact_User", c.this.hhc.getUsername());
        paramView.putExtra("Contact_Nick", c.this.hhc.getNickName());
        paramView.putExtra("Contact_Mobile_MD5", c.this.hhc.getMd5());
        paramView.putExtra("Contact_Alias", c.this.hhc.ked);
        paramView.putExtra("Contact_Sex", c.this.hhc.kdY);
        paramView.putExtra("Contact_Signature", c.this.hhc.keb);
        paramView.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(c.this.hhc.keh, c.this.hhc.kdZ, c.this.hhc.kea));
        paramView.putExtra("Contact_Scene", 13);
        paramView.putExtra("Contact_ShowUserName", false);
        if (c.this.hhd) {
          paramView.putExtra("add_more_friend_search_scene", 1);
        }
        com.tencent.mm.plugin.account.a.a.jRt.c(paramView, paramContext);
        AppMethodBeat.o(196835);
        return true;
      }
      if (c.this.hhc.status == 0)
      {
        Log.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
        paramView = new Intent(paramContext, InviteFriendUI.class);
        paramView.putExtra("friend_type", 1);
        paramView.putExtra("friend_user_name", c.this.hhc.getUsername());
        paramView.putExtra("friend_num", c.this.hhc.bnP());
        paramView.putExtra("friend_nick", c.this.hhc.bnK());
        paramView.putExtra("friend_weixin_nick", c.this.hhc.getNickName());
        paramView.putExtra("friend_scene", 13);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramView.axQ(), "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(196835);
        return true;
      }
      Log.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
      AppMethodBeat.o(196835);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.w.a.c
 * JD-Core Version:    0.7.0.1
 */