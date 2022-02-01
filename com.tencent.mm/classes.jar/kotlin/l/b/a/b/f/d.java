package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.a.k;
import kotlin.g.a.b;

public final class d
{
  private static final Pattern ajeA;
  private static final b<String, f> ajeB;
  private static final f ajez;
  public final String ajeC;
  private transient c ajeD;
  private transient d ajeE;
  private transient f ajeF;
  
  static
  {
    AppMethodBeat.i(59315);
    ajez = f.bJg("<root>");
    ajeA = Pattern.compile("\\.");
    ajeB = new b() {};
    AppMethodBeat.o(59315);
  }
  
  private d(String paramString)
  {
    AppMethodBeat.i(59299);
    this.ajeC = paramString;
    AppMethodBeat.o(59299);
  }
  
  d(String paramString, c paramc)
  {
    AppMethodBeat.i(59298);
    this.ajeC = paramString;
    this.ajeD = paramc;
    AppMethodBeat.o(59298);
  }
  
  private d(String paramString, d paramd, f paramf)
  {
    AppMethodBeat.i(59300);
    this.ajeC = paramString;
    this.ajeE = paramd;
    this.ajeF = paramf;
    AppMethodBeat.o(59300);
  }
  
  private void compute()
  {
    AppMethodBeat.i(59301);
    int i = this.ajeC.lastIndexOf('.');
    if (i >= 0)
    {
      this.ajeF = f.bJh(this.ajeC.substring(i + 1));
      this.ajeE = new d(this.ajeC.substring(0, i));
      AppMethodBeat.o(59301);
      return;
    }
    this.ajeF = f.bJh(this.ajeC);
    this.ajeE = c.ajew.kxR();
    AppMethodBeat.o(59301);
  }
  
  public static d u(f paramf)
  {
    AppMethodBeat.i(59311);
    if (paramf == null) {
      aKu(16);
    }
    paramf = new d(paramf.PF(), c.ajew.kxR(), paramf);
    AppMethodBeat.o(59311);
    return paramf;
  }
  
  public final String PF()
  {
    AppMethodBeat.i(59302);
    String str = this.ajeC;
    if (str == null) {
      aKu(4);
    }
    AppMethodBeat.o(59302);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59313);
    if (this == paramObject)
    {
      AppMethodBeat.o(59313);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    paramObject = (d)paramObject;
    if (!this.ajeC.equals(paramObject.ajeC))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    AppMethodBeat.o(59313);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59314);
    int i = this.ajeC.hashCode();
    AppMethodBeat.o(59314);
    return i;
  }
  
  public final f kxT()
  {
    AppMethodBeat.i(59307);
    if (this.ajeF != null)
    {
      localObject = this.ajeF;
      if (localObject == null) {
        aKu(10);
      }
      AppMethodBeat.o(59307);
      return localObject;
    }
    if (this.ajeC.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59307);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.ajeF;
    if (localObject == null) {
      aKu(11);
    }
    AppMethodBeat.o(59307);
    return localObject;
  }
  
  public final f kxU()
  {
    AppMethodBeat.i(59308);
    if (this.ajeC.isEmpty())
    {
      localf = ajez;
      if (localf == null) {
        aKu(12);
      }
      AppMethodBeat.o(59308);
      return localf;
    }
    f localf = kxT();
    if (localf == null) {
      aKu(13);
    }
    AppMethodBeat.o(59308);
    return localf;
  }
  
  public final List<f> kxV()
  {
    AppMethodBeat.i(59309);
    if (this.ajeC.isEmpty()) {}
    for (List localList = Collections.emptyList();; localList = k.a(ajeA.split(this.ajeC), ajeB))
    {
      if (localList == null) {
        aKu(14);
      }
      AppMethodBeat.o(59309);
      return localList;
    }
  }
  
  public final boolean kxW()
  {
    AppMethodBeat.i(59303);
    if ((this.ajeD != null) || (PF().indexOf('<') < 0))
    {
      AppMethodBeat.o(59303);
      return true;
    }
    AppMethodBeat.o(59303);
    return false;
  }
  
  public final c kxX()
  {
    AppMethodBeat.i(59304);
    if (this.ajeD != null)
    {
      localc = this.ajeD;
      if (localc == null) {
        aKu(5);
      }
      AppMethodBeat.o(59304);
      return localc;
    }
    this.ajeD = new c(this);
    c localc = this.ajeD;
    if (localc == null) {
      aKu(6);
    }
    AppMethodBeat.o(59304);
    return localc;
  }
  
  public final d kxY()
  {
    AppMethodBeat.i(59305);
    if (this.ajeE != null)
    {
      localObject = this.ajeE;
      if (localObject == null) {
        aKu(7);
      }
      AppMethodBeat.o(59305);
      return localObject;
    }
    if (this.ajeC.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59305);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.ajeE;
    if (localObject == null) {
      aKu(8);
    }
    AppMethodBeat.o(59305);
    return localObject;
  }
  
  public final boolean r(f paramf)
  {
    AppMethodBeat.i(59310);
    if (paramf == null) {
      aKu(15);
    }
    if (this.ajeC.isEmpty())
    {
      AppMethodBeat.o(59310);
      return false;
    }
    int j = this.ajeC.indexOf('.');
    String str = this.ajeC;
    paramf = paramf.PF();
    int i = j;
    if (j == -1) {
      i = this.ajeC.length();
    }
    boolean bool = str.regionMatches(0, paramf, 0, i);
    AppMethodBeat.o(59310);
    return bool;
  }
  
  public final d t(f paramf)
  {
    AppMethodBeat.i(59306);
    if (paramf == null) {
      aKu(9);
    }
    if (this.ajeC.isEmpty()) {}
    for (String str = paramf.PF();; str = this.ajeC + "." + paramf.PF())
    {
      paramf = new d(str, this, paramf);
      AppMethodBeat.o(59306);
      return paramf;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59312);
    if (this.ajeC.isEmpty()) {}
    for (String str = ajez.PF();; str = this.ajeC)
    {
      if (str == null) {
        aKu(17);
      }
      AppMethodBeat.o(59312);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.f.d
 * JD-Core Version:    0.7.0.1
 */