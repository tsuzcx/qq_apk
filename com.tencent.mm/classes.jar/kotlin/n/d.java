package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class d
{
  public static final Charset ISO_8859_1;
  public static final Charset UTF_8;
  public static final Charset ajuA;
  public static final Charset ajuB;
  public static final Charset ajuC;
  public static final d ajuD;
  public static final Charset ajuz;
  
  static
  {
    AppMethodBeat.i(129459);
    ajuD = new d();
    Charset localCharset = Charset.forName("UTF-8");
    s.s(localCharset, "Charset.forName(\"UTF-8\")");
    UTF_8 = localCharset;
    localCharset = Charset.forName("UTF-16");
    s.s(localCharset, "Charset.forName(\"UTF-16\")");
    ajuz = localCharset;
    localCharset = Charset.forName("UTF-16BE");
    s.s(localCharset, "Charset.forName(\"UTF-16BE\")");
    ajuA = localCharset;
    localCharset = Charset.forName("UTF-16LE");
    s.s(localCharset, "Charset.forName(\"UTF-16LE\")");
    ajuB = localCharset;
    localCharset = Charset.forName("US-ASCII");
    s.s(localCharset, "Charset.forName(\"US-ASCII\")");
    ajuC = localCharset;
    localCharset = Charset.forName("ISO-8859-1");
    s.s(localCharset, "Charset.forName(\"ISO-8859-1\")");
    ISO_8859_1 = localCharset;
    AppMethodBeat.o(129459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.n.d
 * JD-Core Version:    0.7.0.1
 */