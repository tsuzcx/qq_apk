package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.a.e;

public final class c
{
  private static final f TCT;
  private static final Pattern TCU;
  private static final kotlin.g.a.b<String, f> TCV;
  public final String TCW;
  private transient b TCX;
  private transient c TCY;
  private transient f TCZ;
  
  static
  {
    AppMethodBeat.i(59315);
    TCT = f.bua("<root>");
    TCU = Pattern.compile("\\.");
    TCV = new kotlin.g.a.b() {};
    AppMethodBeat.o(59315);
  }
  
  private c(String paramString)
  {
    AppMethodBeat.i(59299);
    this.TCW = paramString;
    AppMethodBeat.o(59299);
  }
  
  c(String paramString, b paramb)
  {
    AppMethodBeat.i(59298);
    this.TCW = paramString;
    this.TCX = paramb;
    AppMethodBeat.o(59298);
  }
  
  private c(String paramString, c paramc, f paramf)
  {
    AppMethodBeat.i(59300);
    this.TCW = paramString;
    this.TCY = paramc;
    this.TCZ = paramf;
    AppMethodBeat.o(59300);
  }
  
  private void compute()
  {
    AppMethodBeat.i(59301);
    int i = this.TCW.lastIndexOf('.');
    if (i >= 0)
    {
      this.TCZ = f.bub(this.TCW.substring(i + 1));
      this.TCY = new c(this.TCW.substring(0, i));
      AppMethodBeat.o(59301);
      return;
    }
    this.TCZ = f.bub(this.TCW);
    this.TCY = b.TCQ.hJe();
    AppMethodBeat.o(59301);
  }
  
  public static c t(f paramf)
  {
    AppMethodBeat.i(59311);
    if (paramf == null) {
      atM(16);
    }
    paramf = new c(paramf.sG(), b.TCQ.hJe(), paramf);
    AppMethodBeat.o(59311);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59313);
    if (this == paramObject)
    {
      AppMethodBeat.o(59313);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    paramObject = (c)paramObject;
    if (!this.TCW.equals(paramObject.TCW))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    AppMethodBeat.o(59313);
    return true;
  }
  
  public final f hJg()
  {
    AppMethodBeat.i(59307);
    if (this.TCZ != null)
    {
      localObject = this.TCZ;
      if (localObject == null) {
        atM(10);
      }
      AppMethodBeat.o(59307);
      return localObject;
    }
    if (this.TCW.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59307);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.TCZ;
    if (localObject == null) {
      atM(11);
    }
    AppMethodBeat.o(59307);
    return localObject;
  }
  
  public final f hJh()
  {
    AppMethodBeat.i(59308);
    if (this.TCW.isEmpty())
    {
      localf = TCT;
      if (localf == null) {
        atM(12);
      }
      AppMethodBeat.o(59308);
      return localf;
    }
    f localf = hJg();
    if (localf == null) {
      atM(13);
    }
    AppMethodBeat.o(59308);
    return localf;
  }
  
  public final boolean hJi()
  {
    AppMethodBeat.i(59303);
    if ((this.TCX != null) || (sG().indexOf('<') < 0))
    {
      AppMethodBeat.o(59303);
      return true;
    }
    AppMethodBeat.o(59303);
    return false;
  }
  
  public final b hJj()
  {
    AppMethodBeat.i(59304);
    if (this.TCX != null)
    {
      localb = this.TCX;
      if (localb == null) {
        atM(5);
      }
      AppMethodBeat.o(59304);
      return localb;
    }
    this.TCX = new b(this);
    b localb = this.TCX;
    if (localb == null) {
      atM(6);
    }
    AppMethodBeat.o(59304);
    return localb;
  }
  
  public final c hJk()
  {
    AppMethodBeat.i(59305);
    if (this.TCY != null)
    {
      localObject = this.TCY;
      if (localObject == null) {
        atM(7);
      }
      AppMethodBeat.o(59305);
      return localObject;
    }
    if (this.TCW.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59305);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.TCY;
    if (localObject == null) {
      atM(8);
    }
    AppMethodBeat.o(59305);
    return localObject;
  }
  
  public final List<f> hJl()
  {
    AppMethodBeat.i(59309);
    if (this.TCW.isEmpty()) {}
    for (List localList = Collections.emptyList();; localList = e.a(TCU.split(this.TCW), TCV))
    {
      if (localList == null) {
        atM(14);
      }
      AppMethodBeat.o(59309);
      return localList;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59314);
    int i = this.TCW.hashCode();
    AppMethodBeat.o(59314);
    return i;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59310);
    if (paramf == null) {
      atM(15);
    }
    if (this.TCW.isEmpty())
    {
      AppMethodBeat.o(59310);
      return false;
    }
    int j = this.TCW.indexOf('.');
    String str = this.TCW;
    paramf = paramf.sG();
    int i = j;
    if (j == -1) {
      i = this.TCW.length();
    }
    boolean bool = str.regionMatches(0, paramf, 0, i);
    AppMethodBeat.o(59310);
    return bool;
  }
  
  public final c s(f paramf)
  {
    AppMethodBeat.i(59306);
    if (paramf == null) {
      atM(9);
    }
    if (this.TCW.isEmpty()) {}
    for (String str = paramf.sG();; str = this.TCW + "." + paramf.sG())
    {
      paramf = new c(str, this, paramf);
      AppMethodBeat.o(59306);
      return paramf;
    }
  }
  
  public final String sG()
  {
    AppMethodBeat.i(59302);
    String str = this.TCW;
    if (str == null) {
      atM(4);
    }
    AppMethodBeat.o(59302);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59312);
    if (this.TCW.isEmpty()) {}
    for (String str = TCT.sG();; str = this.TCW)
    {
      if (str == null) {
        atM(17);
      }
      AppMethodBeat.o(59312);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.f.c
 * JD-Core Version:    0.7.0.1
 */