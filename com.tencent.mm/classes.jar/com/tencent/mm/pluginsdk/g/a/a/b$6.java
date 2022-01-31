package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bk;

final class b$6
  implements Runnable
{
  b$6(b paramb, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, boolean paramBoolean) {}
  
  public final void run()
  {
    s locals = q.a.clL().Wl(this.rWl);
    String str1 = this.rWo;
    String str2 = this.rWp;
    int i = this.rWq;
    int j = this.fFi;
    String str3 = this.rWm;
    boolean bool = this.rWr;
    if (locals == null)
    {
      locals = new s();
      locals.field_keyVersion = i;
      locals.field_encryptKey = str2;
      locals.field_reportId = j;
      locals.field_sampleId = str3;
      locals.field_originalMd5 = str1;
      q.a.clL().g(locals);
      j.s(j, 51L);
      j.s(j, 45L);
    }
    do
    {
      return;
      if (locals.field_keyVersion < i)
      {
        locals.field_keyVersion = i;
        locals.field_encryptKey = str2;
        locals.field_reportId = j;
        locals.field_sampleId = str3;
        if (bk.bl(locals.field_originalMd5)) {
          locals.field_originalMd5 = str1;
        }
        q.a.clL().g(locals);
        f.b.a(locals, true, bool);
        return;
      }
    } while ((!bool) || (locals.field_keyVersion != i));
    f.b.a(locals, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.6
 * JD-Core Version:    0.7.0.1
 */