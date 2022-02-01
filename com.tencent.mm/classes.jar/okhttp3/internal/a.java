package okhttp3.internal;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.ab;
import okhttp3.e;
import okhttp3.i;
import okhttp3.internal.b.c;
import okhttp3.internal.b.d;
import okhttp3.internal.b.g;
import okhttp3.j;
import okhttp3.q.a;
import okhttp3.z.a;

public abstract class a
{
  public static a ajOh;
  
  public abstract int a(z.a parama);
  
  public abstract Socket a(i parami, okhttp3.a parama, g paramg);
  
  public abstract c a(i parami, okhttp3.a parama, g paramg, ab paramab);
  
  public abstract d a(i parami);
  
  public abstract void a(j paramj, SSLSocket paramSSLSocket, boolean paramBoolean);
  
  public abstract void a(q.a parama, String paramString);
  
  public abstract void a(q.a parama, String paramString1, String paramString2);
  
  public abstract boolean a(okhttp3.a parama1, okhttp3.a parama2);
  
  public abstract boolean a(i parami, c paramc);
  
  public abstract IOException b(e parame, IOException paramIOException);
  
  public abstract void b(i parami, c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.a
 * JD-Core Version:    0.7.0.1
 */