package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;

final class f$7
  implements bd.a
{
  f$7(f paramf) {}
  
  public final void a(bd parambd, ad paramad)
  {
    if ((parambd != null) && (paramad != null) && (paramad.Bg()))
    {
      g.DN().CX();
      ((j)g.r(j.class)).bhL().Ht(paramad.field_username);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f.7
 * JD-Core Version:    0.7.0.1
 */