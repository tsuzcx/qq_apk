package com.tencent.mm.x.a;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.q.d;
import com.tencent.mm.plugin.account.ui.q.j;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.storage.bd;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a.b
{
  public com.tencent.mm.plugin.account.friend.a.a dCj;
  public boolean dCk;
  private c.a dCl = new c.a(this);
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public final a.b BD()
  {
    return this.dCl;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    this.username = this.fYx.kwg;
    this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.username);
    paramVarArgs = (com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    long l = this.fYx.kxk;
    parama = new com.tencent.mm.plugin.account.friend.a.a();
    String str = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + Long.toString(l) + ';';
    paramVarArgs = paramVarArgs.dXo.a(str, null, 2);
    if (paramVarArgs.moveToFirst()) {
      parama.d(paramVarArgs);
    }
    paramVarArgs.close();
    this.dCj = parama;
    str = this.dCj.Wx();
    boolean bool1;
    int i;
    int j;
    switch (this.fYx.kwf)
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
        this.ieA = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str, com.tencent.mm.cb.a.aa(paramContext, q.d.NormalTextSize));
        this.ieA = f.a(d.a(this.ieA, this.kwi, bool2, bool1)).kwz;
        label275:
        if (i != 0)
        {
          this.ieB = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, parama, com.tencent.mm.cb.a.aa(paramContext, q.d.NormalTextSize));
          this.ieB = f.a(d.a(this.ieB, this.kwi, bool2, bool1)).kwz;
          this.ieB = TextUtils.concat(new CharSequence[] { paramVarArgs, this.ieB });
        }
        return;
        bool1 = true;
        label347:
        bool2 = true;
        label350:
        parama = this.dCj.WD();
        paramVarArgs = paramContext.getString(q.j.search_contact_tag_mobile);
        i = 0;
        j = 1;
        continue;
        parama = this.dCj.WD();
        paramVarArgs = paramContext.getString(q.j.search_contact_tag_mobile);
        bool1 = false;
        bool2 = false;
        i = 1;
        j = 0;
        continue;
        bool1 = true;
      }
    }
    label409:
    for (boolean bool2 = true;; bool2 = false)
    {
      parama = this.dCj.WA();
      paramVarArgs = paramContext.getString(q.j.search_contact_tag_wxnick);
      i = 1;
      j = 0;
      break;
      this.ieA = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str, com.tencent.mm.cb.a.aa(paramContext, q.d.NormalTextSize));
      break label275;
      bool1 = false;
      break label347;
      bool1 = false;
      bool2 = false;
      break label350;
      bool1 = false;
      break label409;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.x.a.c
 * JD-Core Version:    0.7.0.1
 */