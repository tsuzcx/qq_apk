package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.aa;
import j.f;
import j.h;
import j.i;
import j.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.s;

final class d
{
  static final c[] ajQu;
  static final Map<i, Integer> ajQv;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(186910);
    ajQu = new c[] { new c(c.ajQq, ""), new c(c.ajQn, "GET"), new c(c.ajQn, "POST"), new c(c.ajQo, "/"), new c(c.ajQo, "/index.html"), new c(c.ajQp, "http"), new c(c.ajQp, "https"), new c(c.ajQm, "200"), new c(c.ajQm, "204"), new c(c.ajQm, "206"), new c(c.ajQm, "304"), new c(c.ajQm, "400"), new c(c.ajQm, "404"), new c(c.ajQm, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "") };
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(ajQu.length);
    while (i < ajQu.length)
    {
      if (!localLinkedHashMap.containsKey(ajQu[i].ajQr)) {
        localLinkedHashMap.put(ajQu[i].ajQr, Integer.valueOf(i));
      }
      i += 1;
    }
    ajQv = Collections.unmodifiableMap(localLinkedHashMap);
    AppMethodBeat.o(186910);
  }
  
  static i a(i parami)
  {
    AppMethodBeat.i(186881);
    int i = 0;
    int j = parami.kIN();
    while (i < j)
    {
      int k = parami.aNp(i);
      if ((k >= 65) && (k <= 90))
      {
        parami = new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + parami.kIJ());
        AppMethodBeat.o(186881);
        throw parami;
      }
      i += 1;
    }
    AppMethodBeat.o(186881);
    return parami;
  }
  
  static final class a
  {
    int ajQA;
    int ajQB;
    private final List<c> ajQw;
    private final int ajQx;
    private int ajQy;
    c[] ajQz;
    private final h cnO;
    int xZt;
    
    a(aa paramaa)
    {
      this(paramaa, (byte)0);
    }
    
    private a(aa paramaa, byte paramByte)
    {
      AppMethodBeat.i(186968);
      this.ajQw = new ArrayList();
      this.ajQz = new c[8];
      this.ajQA = (this.ajQz.length - 1);
      this.xZt = 0;
      this.ajQB = 0;
      this.ajQx = 4096;
      this.ajQy = 4096;
      this.cnO = q.b(paramaa);
      AppMethodBeat.o(186968);
    }
    
    private void a(c paramc)
    {
      AppMethodBeat.i(187045);
      this.ajQw.add(paramc);
      int i = paramc.ajQt;
      if (i > this.ajQy)
      {
        kHI();
        AppMethodBeat.o(187045);
        return;
      }
      aMX(this.ajQB + i - this.ajQy);
      if (this.xZt + 1 > this.ajQz.length)
      {
        c[] arrayOfc = new c[this.ajQz.length * 2];
        System.arraycopy(this.ajQz, 0, arrayOfc, this.ajQz.length, this.ajQz.length);
        this.ajQA = (this.ajQz.length - 1);
        this.ajQz = arrayOfc;
      }
      int j = this.ajQA;
      this.ajQA = (j - 1);
      this.ajQz[j] = paramc;
      this.xZt += 1;
      this.ajQB = (i + this.ajQB);
      AppMethodBeat.o(187045);
    }
    
    private int aMX(int paramInt)
    {
      AppMethodBeat.i(186998);
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.ajQz.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.ajQA) && (j > 0))
        {
          j -= this.ajQz[i].ajQt;
          this.ajQB -= this.ajQz[i].ajQt;
          this.xZt -= 1;
          paramInt += 1;
          i -= 1;
        }
        System.arraycopy(this.ajQz, this.ajQA + 1, this.ajQz, this.ajQA + 1 + paramInt, this.xZt);
        this.ajQA += paramInt;
        i = paramInt;
      }
      AppMethodBeat.o(186998);
      return i;
    }
    
    private int aMY(int paramInt)
    {
      return this.ajQA + 1 + paramInt;
    }
    
    private i aMZ(int paramInt)
    {
      AppMethodBeat.i(187023);
      if (aNa(paramInt))
      {
        localObject = d.ajQu[paramInt].ajQr;
        AppMethodBeat.o(187023);
        return localObject;
      }
      int i = aMY(paramInt - d.ajQu.length);
      if ((i < 0) || (i >= this.ajQz.length))
      {
        localObject = new IOException("Header index too large " + (paramInt + 1));
        AppMethodBeat.o(187023);
        throw ((Throwable)localObject);
      }
      Object localObject = this.ajQz[i].ajQr;
      AppMethodBeat.o(187023);
      return localObject;
    }
    
    private static boolean aNa(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= d.ajQu.length - 1);
    }
    
    private int bT(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(187064);
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2)
      {
        AppMethodBeat.o(187064);
        return paramInt1;
      }
      paramInt1 = 0;
      int i;
      for (;;)
      {
        i = kHL();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      AppMethodBeat.o(187064);
      return (i << paramInt1) + paramInt2;
    }
    
    private void kHH()
    {
      AppMethodBeat.i(186975);
      if (this.ajQy < this.ajQB)
      {
        if (this.ajQy == 0)
        {
          kHI();
          AppMethodBeat.o(186975);
          return;
        }
        aMX(this.ajQB - this.ajQy);
      }
      AppMethodBeat.o(186975);
    }
    
    private void kHI()
    {
      AppMethodBeat.i(186983);
      Arrays.fill(this.ajQz, null);
      this.ajQA = (this.ajQz.length - 1);
      this.xZt = 0;
      this.ajQB = 0;
      AppMethodBeat.o(186983);
    }
    
    private int kHL()
    {
      AppMethodBeat.i(187051);
      int i = this.cnO.readByte();
      AppMethodBeat.o(187051);
      return i & 0xFF;
    }
    
    private i kHM()
    {
      AppMethodBeat.i(187075);
      int j = kHL();
      if ((j & 0x80) == 128) {}
      for (int i = 1;; i = 0)
      {
        j = bT(j, 127);
        if (i == 0) {
          break;
        }
        locali = i.ef(k.kIc().decode(this.cnO.Ch(j)));
        AppMethodBeat.o(187075);
        return locali;
      }
      i locali = this.cnO.Ce(j);
      AppMethodBeat.o(187075);
      return locali;
    }
    
    final void kHJ()
    {
      AppMethodBeat.i(187118);
      while (!this.cnO.kIy())
      {
        int i = this.cnO.readByte() & 0xFF;
        Object localObject;
        if (i == 128)
        {
          localObject = new IOException("index == 0");
          AppMethodBeat.o(187118);
          throw ((Throwable)localObject);
        }
        if ((i & 0x80) == 128)
        {
          i = bT(i, 127) - 1;
          if (aNa(i))
          {
            localObject = d.ajQu[i];
            this.ajQw.add(localObject);
          }
          else
          {
            int j = aMY(i - d.ajQu.length);
            if ((j < 0) || (j >= this.ajQz.length))
            {
              localObject = new IOException("Header index too large " + (i + 1));
              AppMethodBeat.o(187118);
              throw ((Throwable)localObject);
            }
            this.ajQw.add(this.ajQz[j]);
          }
        }
        else if (i == 64)
        {
          a(new c(d.a(kHM()), kHM()));
        }
        else if ((i & 0x40) == 64)
        {
          a(new c(aMZ(bT(i, 63) - 1), kHM()));
        }
        else if ((i & 0x20) == 32)
        {
          this.ajQy = bT(i, 31);
          if ((this.ajQy < 0) || (this.ajQy > this.ajQx))
          {
            localObject = new IOException("Invalid dynamic table size update " + this.ajQy);
            AppMethodBeat.o(187118);
            throw ((Throwable)localObject);
          }
          kHH();
        }
        else
        {
          i locali;
          if ((i == 16) || (i == 0))
          {
            localObject = d.a(kHM());
            locali = kHM();
            this.ajQw.add(new c((i)localObject, locali));
          }
          else
          {
            localObject = aMZ(bT(i, 15) - 1);
            locali = kHM();
            this.ajQw.add(new c((i)localObject, locali));
          }
        }
      }
      AppMethodBeat.o(187118);
    }
    
    public final List<c> kHK()
    {
      AppMethodBeat.i(187128);
      ArrayList localArrayList = new ArrayList(this.ajQw);
      this.ajQw.clear();
      AppMethodBeat.o(187128);
      return localArrayList;
    }
  }
  
  static final class b
  {
    int ajQA;
    int ajQB;
    private final f ajQC;
    private final boolean ajQD;
    private int ajQE;
    private boolean ajQF;
    int ajQx;
    int ajQy;
    c[] ajQz;
    int xZt;
    
    b(f paramf)
    {
      this(paramf, (byte)0);
    }
    
    private b(f paramf, byte paramByte)
    {
      AppMethodBeat.i(186966);
      this.ajQE = 2147483647;
      this.ajQz = new c[8];
      this.ajQA = (this.ajQz.length - 1);
      this.xZt = 0;
      this.ajQB = 0;
      this.ajQx = 4096;
      this.ajQy = 4096;
      this.ajQD = true;
      this.ajQC = paramf;
      AppMethodBeat.o(186966);
    }
    
    private int aMX(int paramInt)
    {
      AppMethodBeat.i(186988);
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.ajQz.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.ajQA) && (j > 0))
        {
          j -= this.ajQz[i].ajQt;
          this.ajQB -= this.ajQz[i].ajQt;
          this.xZt -= 1;
          paramInt += 1;
          i -= 1;
        }
        System.arraycopy(this.ajQz, this.ajQA + 1, this.ajQz, this.ajQA + 1 + paramInt, this.xZt);
        Arrays.fill(this.ajQz, this.ajQA + 1, this.ajQA + 1 + paramInt, null);
        this.ajQA += paramInt;
        i = paramInt;
      }
      AppMethodBeat.o(186988);
      return i;
    }
    
    private void b(i parami)
    {
      AppMethodBeat.i(187030);
      if (this.ajQD)
      {
        k.kIc();
        if (k.c(parami) < parami.kIN())
        {
          f localf = new f();
          k.kIc();
          k.a(parami, localf);
          parami = localf.kHM();
          bT(parami.kIN(), 127, 128);
          this.ajQC.d(parami);
          AppMethodBeat.o(187030);
          return;
        }
      }
      bT(parami.kIN(), 127, 0);
      this.ajQC.d(parami);
      AppMethodBeat.o(187030);
    }
    
    private void b(c paramc)
    {
      AppMethodBeat.i(187007);
      int i = paramc.ajQt;
      if (i > this.ajQy)
      {
        kHI();
        AppMethodBeat.o(187007);
        return;
      }
      aMX(this.ajQB + i - this.ajQy);
      if (this.xZt + 1 > this.ajQz.length)
      {
        c[] arrayOfc = new c[this.ajQz.length * 2];
        System.arraycopy(this.ajQz, 0, arrayOfc, this.ajQz.length, this.ajQz.length);
        this.ajQA = (this.ajQz.length - 1);
        this.ajQz = arrayOfc;
      }
      int j = this.ajQA;
      this.ajQA = (j - 1);
      this.ajQz[j] = paramc;
      this.xZt += 1;
      this.ajQB = (i + this.ajQB);
      AppMethodBeat.o(187007);
    }
    
    private void bT(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(187017);
      if (paramInt1 < paramInt2)
      {
        this.ajQC.aNg(paramInt3 | paramInt1);
        AppMethodBeat.o(187017);
        return;
      }
      this.ajQC.aNg(paramInt3 | paramInt2);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.ajQC.aNg(paramInt1 & 0x7F | 0x80);
        paramInt1 >>>= 7;
      }
      this.ajQC.aNg(paramInt1);
      AppMethodBeat.o(187017);
    }
    
    private void kHI()
    {
      AppMethodBeat.i(186974);
      Arrays.fill(this.ajQz, null);
      this.ajQA = (this.ajQz.length - 1);
      this.xZt = 0;
      this.ajQB = 0;
      AppMethodBeat.o(186974);
    }
    
    final void aNb(int paramInt)
    {
      AppMethodBeat.i(187079);
      this.ajQx = paramInt;
      paramInt = Math.min(paramInt, 16384);
      if (this.ajQy == paramInt)
      {
        AppMethodBeat.o(187079);
        return;
      }
      if (paramInt < this.ajQy) {
        this.ajQE = Math.min(this.ajQE, paramInt);
      }
      this.ajQF = true;
      this.ajQy = paramInt;
      if (this.ajQy < this.ajQB)
      {
        if (this.ajQy == 0)
        {
          kHI();
          AppMethodBeat.o(187079);
          return;
        }
        aMX(this.ajQB - this.ajQy);
      }
      AppMethodBeat.o(187079);
    }
    
    final void pl(List<c> paramList)
    {
      AppMethodBeat.i(187066);
      if (this.ajQF)
      {
        if (this.ajQE < this.ajQy) {
          bT(this.ajQE, 31, 32);
        }
        this.ajQF = false;
        this.ajQE = 2147483647;
        bT(this.ajQy, 31, 32);
      }
      int i2 = paramList.size();
      int k = 0;
      c localc;
      i locali1;
      i locali2;
      Object localObject;
      int i;
      int m;
      int j;
      if (k < i2)
      {
        localc = (c)paramList.get(k);
        locali1 = localc.ajQr.kIM();
        locali2 = localc.ajQs;
        localObject = (Integer)d.ajQv.get(locali1);
        if (localObject == null) {
          break label478;
        }
        i = ((Integer)localObject).intValue() + 1;
        if ((i <= 1) || (i >= 8)) {
          break label473;
        }
        if (okhttp3.internal.c.equal(d.ajQu[(i - 1)].ajQs, locali2))
        {
          m = i;
          j = i;
          i = m;
        }
      }
      for (;;)
      {
        label171:
        int n = i;
        int i1 = j;
        if (j == -1)
        {
          m = this.ajQA + 1;
          int i3 = this.ajQz.length;
          label197:
          n = i;
          i1 = j;
          if (m < i3)
          {
            n = i;
            if (!okhttp3.internal.c.equal(this.ajQz[m].ajQr, locali1)) {
              break label337;
            }
            if (!okhttp3.internal.c.equal(this.ajQz[m].ajQs, locali2)) {
              break label315;
            }
            i1 = m - this.ajQA + d.ajQu.length;
            n = i;
          }
        }
        if (i1 != -1) {
          bT(i1, 127, 128);
        }
        for (;;)
        {
          k += 1;
          break;
          if (!okhttp3.internal.c.equal(d.ajQu[i].ajQs, locali2)) {
            break label473;
          }
          j = i + 1;
          break label171;
          label315:
          n = i;
          if (i == -1) {
            n = m - this.ajQA + d.ajQu.length;
          }
          label337:
          m += 1;
          i = n;
          break label197;
          if (n == -1)
          {
            this.ajQC.aNg(64);
            b(locali1);
            b(locali2);
            b(localc);
          }
          else
          {
            localObject = c.ajQl;
            s.u(localObject, "prefix");
            if ((locali1.a((i)localObject, ((i)localObject).kIN())) && (!c.ajQq.equals(locali1)))
            {
              bT(n, 15, 0);
              b(locali2);
            }
            else
            {
              bT(n, 63, 64);
              b(locali2);
              b(localc);
            }
          }
        }
        AppMethodBeat.o(187066);
        return;
        label473:
        j = -1;
        continue;
        label478:
        i = -1;
        j = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.d
 * JD-Core Version:    0.7.0.1
 */