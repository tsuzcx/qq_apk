package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"})
public final class d
{
  public static final Charset ISO_8859_1;
  public static final Charset UTF_8;
  public static final Charset abvr;
  public static final Charset abvs;
  public static final Charset abvt;
  public static final Charset abvu;
  public static final d abvv;
  
  static
  {
    AppMethodBeat.i(129459);
    abvv = new d();
    Charset localCharset = Charset.forName("UTF-8");
    p.j(localCharset, "Charset.forName(\"UTF-8\")");
    UTF_8 = localCharset;
    localCharset = Charset.forName("UTF-16");
    p.j(localCharset, "Charset.forName(\"UTF-16\")");
    abvr = localCharset;
    localCharset = Charset.forName("UTF-16BE");
    p.j(localCharset, "Charset.forName(\"UTF-16BE\")");
    abvs = localCharset;
    localCharset = Charset.forName("UTF-16LE");
    p.j(localCharset, "Charset.forName(\"UTF-16LE\")");
    abvt = localCharset;
    localCharset = Charset.forName("US-ASCII");
    p.j(localCharset, "Charset.forName(\"US-ASCII\")");
    abvu = localCharset;
    localCharset = Charset.forName("ISO-8859-1");
    p.j(localCharset, "Charset.forName(\"ISO-8859-1\")");
    ISO_8859_1 = localCharset;
    AppMethodBeat.o(129459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.d
 * JD-Core Version:    0.7.0.1
 */