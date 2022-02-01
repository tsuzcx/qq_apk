package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class ab
{
  public final a ajNZ;
  public final InetSocketAddress ajOa;
  public final Proxy uuH;
  
  public ab(a parama, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    AppMethodBeat.i(186548);
    if (parama == null)
    {
      parama = new NullPointerException("address == null");
      AppMethodBeat.o(186548);
      throw parama;
    }
    if (paramProxy == null)
    {
      parama = new NullPointerException("proxy == null");
      AppMethodBeat.o(186548);
      throw parama;
    }
    if (paramInetSocketAddress == null)
    {
      parama = new NullPointerException("inetSocketAddress == null");
      AppMethodBeat.o(186548);
      throw parama;
    }
    this.ajNZ = parama;
    this.uuH = paramProxy;
    this.ajOa = paramInetSocketAddress;
    AppMethodBeat.o(186548);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186559);
    if (((paramObject instanceof ab)) && (((ab)paramObject).ajNZ.equals(this.ajNZ)) && (((ab)paramObject).uuH.equals(this.uuH)) && (((ab)paramObject).ajOa.equals(this.ajOa)))
    {
      AppMethodBeat.o(186559);
      return true;
    }
    AppMethodBeat.o(186559);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186567);
    int i = this.ajNZ.hashCode();
    int j = this.uuH.hashCode();
    int k = this.ajOa.hashCode();
    AppMethodBeat.o(186567);
    return ((i + 527) * 31 + j) * 31 + k;
  }
  
  public final boolean kHk()
  {
    AppMethodBeat.i(186553);
    if ((this.ajNZ.ajIU != null) && (this.uuH.type() == Proxy.Type.HTTP))
    {
      AppMethodBeat.o(186553);
      return true;
    }
    AppMethodBeat.o(186553);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186575);
    String str = "Route{" + this.ajOa + "}";
    AppMethodBeat.o(186575);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.ab
 * JD-Core Version:    0.7.0.1
 */