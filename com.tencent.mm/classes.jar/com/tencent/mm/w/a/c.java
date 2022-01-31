package com.tencent.mm.w.a;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
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
  public com.tencent.mm.plugin.account.friend.a.a ezA;
  public boolean ezB;
  private c.a ezC;
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(124495);
    this.ezC = new c.a(this);
    AppMethodBeat.o(124495);
  }
  
  public final a.b Pr()
  {
    return this.ezC;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(124496);
    this.username = this.hrL.mRV;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.username);
    paramVarArgs = (com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    long l = this.hrL.mSZ;
    parama = new com.tencent.mm.plugin.account.friend.a.a();
    String str = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + Long.toString(l) + ';';
    paramVarArgs = paramVarArgs.fnw.a(str, null, 2);
    if (paramVarArgs.moveToFirst()) {
      parama.convertFrom(paramVarArgs);
    }
    paramVarArgs.close();
    this.ezA = parama;
    str = this.ezA.apZ();
    boolean bool1;
    int i;
    int j;
    switch (this.hrL.mRU)
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
        this.jVn = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
        this.jVn = f.a(d.a(this.jVn, this.mRX, bool2, bool1)).mSp;
        label282:
        if (i != 0)
        {
          this.jVo = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, parama, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
          this.jVo = f.a(d.a(this.jVo, this.mRX, bool2, bool1)).mSp;
          this.jVo = TextUtils.concat(new CharSequence[] { paramVarArgs, this.jVo });
        }
        AppMethodBeat.o(124496);
        return;
        bool1 = true;
        label358:
        bool2 = true;
        label361:
        parama = this.ezA.aqf();
        paramVarArgs = paramContext.getString(2131302991);
        i = 0;
        j = 1;
        continue;
        parama = this.ezA.aqf();
        paramVarArgs = paramContext.getString(2131302991);
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
      parama = this.ezA.aqc();
      paramVarArgs = paramContext.getString(2131302997);
      i = 1;
      j = 0;
      break;
      this.jVn = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
      break label282;
      bool1 = false;
      break label358;
      bool1 = false;
      bool2 = false;
      break label361;
      bool1 = false;
      break label418;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.w.a.c
 * JD-Core Version:    0.7.0.1
 */