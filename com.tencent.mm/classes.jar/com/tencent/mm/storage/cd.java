package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;

public final class cd
  extends i<cc>
  implements g.a
{
  public static final String[] dXp = { i.a(cc.buS, "VoiceTransText") };
  public e dXw;
  
  public cd(e parame)
  {
    this(parame, cc.buS, "VoiceTransText");
  }
  
  private cd(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.dXw = parame;
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final boolean a(cc paramcc)
  {
    if (paramcc == null) {}
    do
    {
      return false;
      paramcc = paramcc.vf();
    } while (this.dXw.replace("VoiceTransText", "msgId", paramcc) < 0L);
    return true;
  }
  
  public final cc acw(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    cc localcc = new cc();
    paramString = this.dXw.a("VoiceTransText", null, "cmsgId=?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcc.d(paramString);
    }
    paramString.close();
    return localcc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cd
 * JD-Core Version:    0.7.0.1
 */