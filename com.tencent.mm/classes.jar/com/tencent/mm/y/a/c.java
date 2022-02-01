package com.tencent.mm.y.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.account.ui.r.d;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bv;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a.b
{
  public com.tencent.mm.plugin.account.friend.a.a jSW;
  public boolean jSX;
  private a jSY;
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(127653);
    this.jSY = new a();
    AppMethodBeat.o(127653);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(127654);
    this.username = this.olG.BHS;
    this.contact = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.username);
    paramVarArgs = (com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg();
    int i = (int)this.olG.BIZ;
    parama = new com.tencent.mm.plugin.account.friend.a.a();
    String str = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + i + ';';
    paramVarArgs = paramVarArgs.lvy.rawQuery(str, null, 2);
    if (paramVarArgs.moveToFirst()) {
      parama.convertFrom(paramVarArgs);
    }
    paramVarArgs.close();
    this.jSW = parama;
    str = this.jSW.bxT();
    boolean bool1;
    int j;
    switch (this.olG.BHR)
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
        this.szA = l.d(paramContext, str, com.tencent.mm.ci.a.aY(paramContext, r.d.NormalTextSize));
        this.szA = com.tencent.mm.plugin.fts.a.f.a(e.a(this.szA, this.BHY, bool2, bool1)).BIp;
        label279:
        if (i != 0)
        {
          this.szB = l.d(paramContext, parama, com.tencent.mm.ci.a.aY(paramContext, r.d.NormalTextSize));
          this.szB = com.tencent.mm.plugin.fts.a.f.a(e.a(this.szB, this.BHY, bool2, bool1)).BIp;
          this.szB = TextUtils.concat(new CharSequence[] { paramVarArgs, this.szB });
        }
        AppMethodBeat.o(127654);
        return;
        bool1 = true;
        label356:
        bool2 = true;
        label359:
        parama = this.jSW.bxY();
        paramVarArgs = paramContext.getString(r.j.search_contact_tag_mobile);
        i = 0;
        j = 1;
        continue;
        parama = this.jSW.bxY();
        paramVarArgs = paramContext.getString(r.j.search_contact_tag_mobile);
        bool1 = false;
        bool2 = false;
        i = 1;
        j = 0;
        continue;
        bool1 = true;
      }
    }
    label418:
    for (boolean bool2 = true;; bool2 = false)
    {
      parama = this.jSW.getNickName();
      paramVarArgs = paramContext.getString(r.j.search_contact_tag_wxnick);
      i = 1;
      j = 0;
      break;
      this.szA = l.d(paramContext, str, com.tencent.mm.ci.a.aY(paramContext, r.d.NormalTextSize));
      break label279;
      bool1 = false;
      break label356;
      bool1 = false;
      bool2 = false;
      break label359;
      bool1 = false;
      break label418;
      bool1 = false;
    }
  }
  
  public final a.b aEw()
  {
    return this.jSY;
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
      AppMethodBeat.i(221966);
      paramView = (c)paramVarArgs;
      if (paramView.jSW == null)
      {
        AppMethodBeat.o(221966);
        return true;
      }
      if ((paramView.jSW.status == 1) || (paramView.jSW.status == 2))
      {
        Log.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
        paramView = new Intent();
        paramView.putExtra("Contact_User", c.this.jSW.getUsername());
        paramView.putExtra("Contact_Nick", c.this.jSW.getNickName());
        paramView.putExtra("Contact_Mobile_MD5", c.this.jSW.getMd5());
        paramView.putExtra("Contact_Alias", c.this.jSW.mVD);
        paramView.putExtra("Contact_Sex", c.this.jSW.mVy);
        paramView.putExtra("Contact_Signature", c.this.jSW.mVB);
        paramView.putExtra("Contact_RegionCode", RegionCodeDecoder.bl(c.this.jSW.mVH, c.this.jSW.mVz, c.this.jSW.mVA));
        paramView.putExtra("Contact_Scene", 13);
        paramView.putExtra("Contact_ShowUserName", false);
        if (c.this.jSX) {
          paramView.putExtra("add_more_friend_search_scene", 1);
        }
        com.tencent.mm.plugin.account.sdk.a.mIG.c(paramView, paramContext);
        AppMethodBeat.o(221966);
        return true;
      }
      if (c.this.jSW.status == 0)
      {
        Log.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
        paramView = new Intent(paramContext, InviteFriendUI.class);
        paramView.putExtra("friend_type", 1);
        paramView.putExtra("friend_user_name", c.this.jSW.getUsername());
        paramView.putExtra("friend_num", c.this.jSW.bxY());
        paramView.putExtra("friend_nick", c.this.jSW.bxT());
        paramView.putExtra("friend_weixin_nick", c.this.jSW.getNickName());
        paramView.putExtra("friend_scene", 13);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramView.aFh(), "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(221966);
        return true;
      }
      Log.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
      AppMethodBeat.o(221966);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.y.a.c
 * JD-Core Version:    0.7.0.1
 */