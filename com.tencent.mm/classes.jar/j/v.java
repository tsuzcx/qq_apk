package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Segment;", "", "()V", "data", "", "pos", "", "limit", "shared", "", "owner", "([BIIZZ)V", "next", "prev", "compact", "", "pop", "push", "segment", "sharedCopy", "split", "byteCount", "unsharedCopy", "writeTo", "sink", "Companion", "okio"}, k=1, mv={1, 4, 1})
public final class v
{
  public static final v.a ajTz;
  public boolean ajTw;
  public v ajTx;
  public v ajTy;
  public boolean ajwa;
  public final byte[] data;
  public int limit;
  public int pos;
  
  static
  {
    AppMethodBeat.i(186298);
    ajTz = new v.a((byte)0);
    AppMethodBeat.o(186298);
  }
  
  public v()
  {
    AppMethodBeat.i(186291);
    this.data = new byte[8192];
    this.ajTw = true;
    this.ajwa = false;
    AppMethodBeat.o(186291);
  }
  
  public v(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(186294);
    this.data = paramArrayOfByte;
    this.pos = paramInt1;
    this.limit = paramInt2;
    this.ajwa = paramBoolean;
    this.ajTw = false;
    AppMethodBeat.o(186294);
  }
  
  public final v a(v paramv)
  {
    AppMethodBeat.i(186306);
    s.u(paramv, "segment");
    paramv.ajTy = ((v)this);
    paramv.ajTx = this.ajTx;
    v localv = this.ajTx;
    s.checkNotNull(localv);
    localv.ajTy = paramv;
    this.ajTx = paramv;
    AppMethodBeat.o(186306);
    return paramv;
  }
  
  public final void a(v paramv, int paramInt)
  {
    AppMethodBeat.i(186310);
    s.u(paramv, "sink");
    if (!paramv.ajTw)
    {
      paramv = (Throwable)new IllegalStateException("only owner can write".toString());
      AppMethodBeat.o(186310);
      throw paramv;
    }
    if (paramv.limit + paramInt > 8192)
    {
      if (paramv.ajwa)
      {
        paramv = (Throwable)new IllegalArgumentException();
        AppMethodBeat.o(186310);
        throw paramv;
      }
      if (paramv.limit + paramInt - paramv.pos > 8192)
      {
        paramv = (Throwable)new IllegalArgumentException();
        AppMethodBeat.o(186310);
        throw paramv;
      }
      k.b(paramv.data, paramv.data, paramv.pos, paramv.limit);
      paramv.limit -= paramv.pos;
      paramv.pos = 0;
    }
    k.a(this.data, paramv.data, paramv.limit, this.pos, this.pos + paramInt);
    paramv.limit += paramInt;
    this.pos += paramInt;
    AppMethodBeat.o(186310);
  }
  
  public final v kIZ()
  {
    AppMethodBeat.i(186301);
    this.ajwa = true;
    v localv = new v(this.data, this.pos, this.limit, true);
    AppMethodBeat.o(186301);
    return localv;
  }
  
  public final v kJa()
  {
    AppMethodBeat.i(186304);
    if (this.ajTx != (v)this) {}
    for (v localv1 = this.ajTx;; localv1 = null)
    {
      v localv2 = this.ajTy;
      s.checkNotNull(localv2);
      localv2.ajTx = this.ajTx;
      localv2 = this.ajTx;
      s.checkNotNull(localv2);
      localv2.ajTy = this.ajTy;
      this.ajTx = null;
      this.ajTy = null;
      AppMethodBeat.o(186304);
      return localv1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.v
 * JD-Core Version:    0.7.0.1
 */