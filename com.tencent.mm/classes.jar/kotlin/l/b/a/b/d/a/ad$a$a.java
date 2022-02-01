package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.f;

public final class ad$a$a
{
  final f aiJy;
  final String signature;
  
  public ad$a$a(f paramf, String paramString)
  {
    AppMethodBeat.i(191984);
    this.aiJy = paramf;
    this.signature = paramString;
    AppMethodBeat.o(191984);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191996);
    if (this == paramObject)
    {
      AppMethodBeat.o(191996);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(191996);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.aiJy, paramObject.aiJy))
    {
      AppMethodBeat.o(191996);
      return false;
    }
    if (!s.p(this.signature, paramObject.signature))
    {
      AppMethodBeat.o(191996);
      return false;
    }
    AppMethodBeat.o(191996);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191994);
    int i = this.aiJy.hashCode();
    int j = this.signature.hashCode();
    AppMethodBeat.o(191994);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191989);
    String str = "NameAndSignature(name=" + this.aiJy + ", signature=" + this.signature + ')';
    AppMethodBeat.o(191989);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.ad.a.a
 * JD-Core Version:    0.7.0.1
 */