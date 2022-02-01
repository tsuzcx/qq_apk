package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.c.e;

public final class d
{
  public static final d ajJx;
  public static final d ajJy;
  public final boolean Gdb;
  public final boolean ajJA;
  public final int ajJB;
  private final int ajJC;
  public final boolean ajJD;
  public final boolean ajJE;
  public final int ajJF;
  public final int ajJG;
  public final boolean ajJH;
  private final boolean ajJI;
  String ajJJ;
  public final boolean ajJz;
  private final boolean dIW;
  
  static
  {
    AppMethodBeat.i(186657);
    a locala = new a();
    locala.ajJz = true;
    ajJx = locala.kGC();
    locala = new a();
    locala.ajJH = true;
    long l = TimeUnit.SECONDS.toSeconds(2147483647L);
    if (l > 2147483647L) {}
    for (int i = 2147483647;; i = (int)l)
    {
      locala.ajJF = i;
      ajJy = locala.kGC();
      AppMethodBeat.o(186657);
      return;
    }
  }
  
  d(a parama)
  {
    this.ajJz = parama.ajJz;
    this.ajJA = parama.ajJA;
    this.ajJB = parama.ajJB;
    this.ajJC = -1;
    this.Gdb = false;
    this.ajJD = false;
    this.ajJE = false;
    this.ajJF = parama.ajJF;
    this.ajJG = parama.ajJG;
    this.ajJH = parama.ajJH;
    this.ajJI = parama.ajJI;
    this.dIW = parama.dIW;
  }
  
  private d(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, String paramString)
  {
    this.ajJz = paramBoolean1;
    this.ajJA = paramBoolean2;
    this.ajJB = paramInt1;
    this.ajJC = paramInt2;
    this.Gdb = paramBoolean3;
    this.ajJD = paramBoolean4;
    this.ajJE = paramBoolean5;
    this.ajJF = paramInt3;
    this.ajJG = paramInt4;
    this.ajJH = paramBoolean6;
    this.ajJI = paramBoolean7;
    this.dIW = paramBoolean8;
    this.ajJJ = paramString;
  }
  
  public static d b(q paramq)
  {
    AppMethodBeat.i(186652);
    boolean bool1 = false;
    boolean bool7 = false;
    int i1 = -1;
    int n = -1;
    boolean bool8 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    int m = -1;
    int k = -1;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    int j = 1;
    Object localObject1 = null;
    int i8 = paramq.ajMS.length / 2;
    int i2 = 0;
    while (i2 < i8)
    {
      Object localObject2 = paramq.aMS(i2);
      String str1 = paramq.aMT(i2);
      int i;
      if (((String)localObject2).equalsIgnoreCase("Cache-Control")) {
        if (localObject1 != null)
        {
          j = 0;
          i = 0;
        }
      }
      for (;;)
      {
        label99:
        localObject2 = localObject1;
        bool16 = bool7;
        i7 = i1;
        i6 = n;
        bool15 = bool8;
        bool14 = bool6;
        bool13 = bool5;
        i5 = m;
        i4 = k;
        bool12 = bool4;
        bool11 = bool2;
        bool10 = bool3;
        i3 = j;
        bool9 = bool1;
        if (i >= str1.length()) {
          break label607;
        }
        i3 = e.Y(str1, i, "=,;");
        String str2 = str1.substring(i, i3).trim();
        if ((i3 == str1.length()) || (str1.charAt(i3) == ',') || (str1.charAt(i3) == ';'))
        {
          i = i3 + 1;
          localObject2 = null;
        }
        for (;;)
        {
          if (!"no-cache".equalsIgnoreCase(str2)) {
            break label357;
          }
          bool1 = true;
          break label99;
          localObject1 = str1;
          break;
          if (!((String)localObject2).equalsIgnoreCase("Pragma")) {
            break label553;
          }
          j = 0;
          break;
          i3 = e.jX(str1, i3 + 1);
          if ((i3 < str1.length()) && (str1.charAt(i3) == '"'))
          {
            i = i3 + 1;
            i3 = e.Y(str1, i, "\"");
            localObject2 = str1.substring(i, i3);
            i = i3 + 1;
          }
          else
          {
            i = e.Y(str1, i3, ",;");
            localObject2 = str1.substring(i3, i).trim();
          }
        }
        label357:
        if ("no-store".equalsIgnoreCase(str2)) {
          bool7 = true;
        } else if ("max-age".equalsIgnoreCase(str2)) {
          i1 = e.jY((String)localObject2, -1);
        } else if ("s-maxage".equalsIgnoreCase(str2)) {
          n = e.jY((String)localObject2, -1);
        } else if ("private".equalsIgnoreCase(str2)) {
          bool8 = true;
        } else if ("public".equalsIgnoreCase(str2)) {
          bool6 = true;
        } else if ("must-revalidate".equalsIgnoreCase(str2)) {
          bool5 = true;
        } else if ("max-stale".equalsIgnoreCase(str2)) {
          m = e.jY((String)localObject2, 2147483647);
        } else if ("min-fresh".equalsIgnoreCase(str2)) {
          k = e.jY((String)localObject2, -1);
        } else if ("only-if-cached".equalsIgnoreCase(str2)) {
          bool4 = true;
        } else if ("no-transform".equalsIgnoreCase(str2)) {
          bool2 = true;
        } else if ("immutable".equalsIgnoreCase(str2)) {
          bool3 = true;
        }
      }
      label553:
      boolean bool9 = bool1;
      int i3 = j;
      boolean bool10 = bool3;
      boolean bool11 = bool2;
      boolean bool12 = bool4;
      int i4 = k;
      int i5 = m;
      boolean bool13 = bool5;
      boolean bool14 = bool6;
      boolean bool15 = bool8;
      int i6 = n;
      int i7 = i1;
      boolean bool16 = bool7;
      localObject2 = localObject1;
      label607:
      i2 += 1;
      bool1 = bool9;
      localObject1 = localObject2;
      bool7 = bool16;
      i1 = i7;
      n = i6;
      bool8 = bool15;
      bool6 = bool14;
      bool5 = bool13;
      m = i5;
      k = i4;
      bool4 = bool12;
      bool2 = bool11;
      bool3 = bool10;
      j = i3;
    }
    if (j == 0) {}
    for (paramq = null;; paramq = localObject1)
    {
      paramq = new d(bool1, bool7, i1, n, bool8, bool6, bool5, m, k, bool4, bool2, bool3, paramq);
      AppMethodBeat.o(186652);
      return paramq;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186673);
    Object localObject = this.ajJJ;
    if (localObject != null)
    {
      AppMethodBeat.o(186673);
      return localObject;
    }
    localObject = new StringBuilder();
    if (this.ajJz) {
      ((StringBuilder)localObject).append("no-cache, ");
    }
    if (this.ajJA) {
      ((StringBuilder)localObject).append("no-store, ");
    }
    if (this.ajJB != -1) {
      ((StringBuilder)localObject).append("max-age=").append(this.ajJB).append(", ");
    }
    if (this.ajJC != -1) {
      ((StringBuilder)localObject).append("s-maxage=").append(this.ajJC).append(", ");
    }
    if (this.Gdb) {
      ((StringBuilder)localObject).append("private, ");
    }
    if (this.ajJD) {
      ((StringBuilder)localObject).append("public, ");
    }
    if (this.ajJE) {
      ((StringBuilder)localObject).append("must-revalidate, ");
    }
    if (this.ajJF != -1) {
      ((StringBuilder)localObject).append("max-stale=").append(this.ajJF).append(", ");
    }
    if (this.ajJG != -1) {
      ((StringBuilder)localObject).append("min-fresh=").append(this.ajJG).append(", ");
    }
    if (this.ajJH) {
      ((StringBuilder)localObject).append("only-if-cached, ");
    }
    if (this.ajJI) {
      ((StringBuilder)localObject).append("no-transform, ");
    }
    if (this.dIW) {
      ((StringBuilder)localObject).append("immutable, ");
    }
    if (((StringBuilder)localObject).length() == 0) {}
    for (localObject = "";; localObject = ((StringBuilder)localObject).toString())
    {
      this.ajJJ = ((String)localObject);
      AppMethodBeat.o(186673);
      return localObject;
      ((StringBuilder)localObject).delete(((StringBuilder)localObject).length() - 2, ((StringBuilder)localObject).length());
    }
  }
  
  public static final class a
  {
    public boolean ajJA;
    int ajJB = -1;
    int ajJF = -1;
    int ajJG = -1;
    public boolean ajJH;
    boolean ajJI;
    public boolean ajJz;
    boolean dIW;
    
    public final d kGC()
    {
      AppMethodBeat.i(186596);
      d locald = new d(this);
      AppMethodBeat.o(186596);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.d
 * JD-Core Version:    0.7.0.1
 */