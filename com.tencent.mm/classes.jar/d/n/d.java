package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.nio.charset.Charset;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"})
public final class d
{
  public static final Charset ISO_8859_1;
  public static final d KcC;
  public static final Charset US_ASCII;
  public static final Charset UTF_16;
  public static final Charset UTF_16BE;
  public static final Charset UTF_16LE;
  public static final Charset UTF_8;
  
  static
  {
    AppMethodBeat.i(129459);
    KcC = new d();
    Charset localCharset = Charset.forName("UTF-8");
    k.g(localCharset, "Charset.forName(\"UTF-8\")");
    UTF_8 = localCharset;
    localCharset = Charset.forName("UTF-16");
    k.g(localCharset, "Charset.forName(\"UTF-16\")");
    UTF_16 = localCharset;
    localCharset = Charset.forName("UTF-16BE");
    k.g(localCharset, "Charset.forName(\"UTF-16BE\")");
    UTF_16BE = localCharset;
    localCharset = Charset.forName("UTF-16LE");
    k.g(localCharset, "Charset.forName(\"UTF-16LE\")");
    UTF_16LE = localCharset;
    localCharset = Charset.forName("US-ASCII");
    k.g(localCharset, "Charset.forName(\"US-ASCII\")");
    US_ASCII = localCharset;
    localCharset = Charset.forName("ISO-8859-1");
    k.g(localCharset, "Charset.forName(\"ISO-8859-1\")");
    ISO_8859_1 = localCharset;
    AppMethodBeat.o(129459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.n.d
 * JD-Core Version:    0.7.0.1
 */