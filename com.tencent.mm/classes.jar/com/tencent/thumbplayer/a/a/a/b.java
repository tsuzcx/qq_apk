package com.tencent.thumbplayer.a.a.a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.c;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.h;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.a.g;
import com.tencent.thumbplayer.b.f.b;
import com.tencent.thumbplayer.b.j;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.m;
import com.tencent.thumbplayer.b.n;
import com.tencent.thumbplayer.b.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.thumbplayer.a.a.b
{
  g MtA;
  com.tencent.thumbplayer.a.b MtC;
  private a MtT;
  List<com.tencent.thumbplayer.b.a.e> MtU;
  int MtV;
  boolean MtW;
  boolean MtX;
  LinkedList<Long> MtY;
  com.tencent.thumbplayer.a.a.b Mtu;
  j Mtv;
  com.tencent.thumbplayer.a.e Mtx;
  com.tencent.thumbplayer.a.c Mtz;
  private Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(194348);
    this.MtV = 0;
    this.mContext = paramContext;
    this.Mtv = new j();
    this.Mtz = new com.tencent.thumbplayer.a.c();
    this.MtT = new a((byte)0);
    this.Mtx = new com.tencent.thumbplayer.a.e("TPThumbPlayer[TPSystemClipPlayer.java]");
    this.MtA = new g(this.Mtv);
    this.MtU = new ArrayList();
    AppMethodBeat.o(194348);
  }
  
  private void a(com.tencent.thumbplayer.a.a.b paramb)
  {
    AppMethodBeat.i(194390);
    if (1 == this.Mtz.Mtg.mType) {
      paramb.b(this.Mtz.Mtg.MtQ);
    }
    if (this.Mtz.Mtg.mType == 0) {
      paramb.setDataSource(this.Mtz.Mtg.mUrl, this.Mtz.Mtg.mHttpHeaders);
    }
    Iterator localIterator = this.Mtz.gaE().iterator();
    while (localIterator.hasNext()) {
      paramb.b((com.tencent.thumbplayer.b.f)localIterator.next());
    }
    localIterator = this.Mtz.gaC().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.d)localIterator.next();
      paramb.bl(((com.tencent.thumbplayer.a.c.d)localObject).url, ((com.tencent.thumbplayer.a.c.d)localObject).mimeType, ((com.tencent.thumbplayer.a.c.d)localObject).name);
    }
    localIterator = this.Mtz.gaD().iterator();
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.a)localIterator.next();
      paramb.g(((com.tencent.thumbplayer.a.c.a)localObject).url, ((com.tencent.thumbplayer.a.c.a)localObject).name, ((com.tencent.thumbplayer.a.c.a)localObject).Mto);
    }
    if (this.Mtz.Mth != null) {
      paramb.c(this.Mtz.Mth.Mtp, this.Mtz.Mth.Mtq, this.Mtz.Mth.Mtr);
    }
    paramb.zK(this.Mtz.Mti);
    if (this.Mtz.Mtj != 0.0F) {
      paramb.cg(this.Mtz.Mtj);
    }
    if (this.Mtz.Mtk != 0.0F) {
      paramb.ch(this.Mtz.Mtk);
    }
    if (this.Mtz.mSurface != null) {
      paramb.setSurface(this.Mtz.mSurface);
    }
    paramb.a(this.MtT);
    paramb.a(this.MtT);
    paramb.a(this.MtT);
    paramb.a(this.MtT);
    paramb.a(this.MtT);
    paramb.a(this.MtT);
    paramb.a(this.MtT);
    AppMethodBeat.o(194390);
  }
  
  private void ahI(int paramInt)
  {
    AppMethodBeat.i(194370);
    int i = 0;
    for (;;)
    {
      if (i < this.MtU.size())
      {
        long l;
        if ((((com.tencent.thumbplayer.b.a.e)this.MtU.get(i)).gbh() <= paramInt) && (paramInt <= ((com.tencent.thumbplayer.b.a.e)this.MtU.get(i)).gbh() + ((com.tencent.thumbplayer.b.a.e)this.MtU.get(i)).gbg())) {
          l = paramInt;
        }
        try
        {
          aU(i, l - ((com.tencent.thumbplayer.b.a.e)this.MtU.get(i)).gbh());
          i += 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemClipPlayer.java]", "selectClipPlayer:" + localIOException.toString());
          }
        }
      }
    }
    AppMethodBeat.o(194370);
  }
  
  private static List<com.tencent.thumbplayer.b.a.e> b(com.tencent.thumbplayer.b.a.a parama)
  {
    int i = 0;
    AppMethodBeat.i(194369);
    if ((!(parama instanceof com.tencent.thumbplayer.d.b)) && (!(parama instanceof com.tencent.thumbplayer.d.d)) && (!(parama instanceof com.tencent.thumbplayer.d.e)))
    {
      parama = new IllegalStateException("system mediaPlayer : media asset is illegal source!");
      AppMethodBeat.o(194369);
      throw parama;
    }
    ArrayList localArrayList = new ArrayList();
    if ((parama instanceof com.tencent.thumbplayer.d.b))
    {
      parama = ((com.tencent.thumbplayer.d.b)parama).Mxe;
      if ((com.tencent.thumbplayer.utils.a.isEmpty(parama)) || (parama.get(0) == null))
      {
        parama = new IllegalStateException("empty av tracks when set data source!");
        AppMethodBeat.o(194369);
        throw parama;
      }
      parama = ((com.tencent.thumbplayer.b.a.d)parama.get(0)).gbd();
    }
    for (;;)
    {
      long l = 0L;
      while (i < parama.size())
      {
        ((com.tencent.thumbplayer.b.a.e)parama.get(i)).FB(l);
        l += ((com.tencent.thumbplayer.b.a.e)parama.get(i)).gbg();
        i += 1;
      }
      if ((parama instanceof com.tencent.thumbplayer.d.d))
      {
        parama = ((com.tencent.thumbplayer.d.d)parama).Mxl;
      }
      else
      {
        localArrayList.add((com.tencent.thumbplayer.b.a.e)parama);
        parama = localArrayList;
      }
    }
    AppMethodBeat.o(194369);
    return parama;
  }
  
  private com.tencent.thumbplayer.b.a.e gaJ()
  {
    AppMethodBeat.i(194388);
    com.tencent.thumbplayer.b.a.e locale = (com.tencent.thumbplayer.b.a.e)this.MtU.get(this.MtV);
    AppMethodBeat.o(194388);
    return locale;
  }
  
  private com.tencent.thumbplayer.a.a.b gaK()
  {
    AppMethodBeat.i(194389);
    c localc = new c(this.mContext);
    if (this.MtC == null) {
      this.MtC = new com.tencent.thumbplayer.a.b();
    }
    a(localc);
    AppMethodBeat.o(194389);
    return localc;
  }
  
  public final void L(String paramString, int paramInt, long paramLong) {}
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(194386);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(194386);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    this.Mtx.MtG = paramb;
  }
  
  public final void a(c.c paramc)
  {
    this.Mtx.MtI = paramc;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    this.Mtx.MtH = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.Mtx.MtF = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.Mtx.MtJ = paramf;
  }
  
  public final void a(c.h paramh)
  {
    this.Mtx.MtL = paramh;
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(194385);
    parami = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(194385);
    throw parami;
  }
  
  public final void a(c.j paramj)
  {
    this.Mtx.MtK = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(194354);
    parama = b(parama);
    try
    {
      this.MtU = parama;
      this.Mtz.setDataSource(((com.tencent.thumbplayer.b.a.e)this.MtU.get(this.MtV)).getFilePath());
      this.Mtv.changeState(2);
      AppMethodBeat.o(194354);
      return;
    }
    catch (Exception parama)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemClipPlayer.java]", parama);
      parama = new IllegalStateException("exception when system clip player set data source!");
      AppMethodBeat.o(194354);
      throw parama;
    }
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(194368);
    parama = b(parama);
    if (com.tencent.thumbplayer.utils.a.isEmpty(parama))
    {
      parama = new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
      AppMethodBeat.o(194368);
      throw parama;
    }
    long l = getCurrentPositionMs();
    try
    {
      this.MtU = parama;
      this.MtX = true;
      if (com.tencent.thumbplayer.utils.a.isEmpty(this.MtY)) {
        this.MtY = new LinkedList();
      }
      this.MtY.offer(Long.valueOf(paramLong));
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemClipPlayer.java]", "try to switch definition with system clip player, current clipNo:" + this.MtV);
      ahI((int)l);
      AppMethodBeat.o(194368);
      return;
    }
    catch (Exception parama)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemClipPlayer.java]", parama);
      parama = new IllegalStateException("exception when system clip player switch definition!");
      AppMethodBeat.o(194368);
      throw parama;
    }
  }
  
  public final void a(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(194384);
    if (this.Mtu != null) {
      this.Mtu.a(parame, paramd);
    }
    AppMethodBeat.o(194384);
  }
  
  public final void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194357);
    if (!this.MtA.ahG(3))
    {
      AppMethodBeat.o(194357);
      return;
    }
    n[] arrayOfn = gaF();
    if (arrayOfn != null)
    {
      this.Mtz.a(paramInt, paramLong, arrayOfn[paramInt]);
      if (this.Mtu != null) {
        this.Mtu.aR(paramInt, paramLong);
      }
    }
    AppMethodBeat.o(194357);
  }
  
  public final void aS(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194358);
    if (!this.MtA.ahG(3))
    {
      AppMethodBeat.o(194358);
      return;
    }
    if (this.Mtu != null) {
      this.Mtu.aS(paramInt, paramLong);
    }
    n[] arrayOfn = gaF();
    if (arrayOfn != null) {
      this.Mtz.a(paramInt, arrayOfn[paramInt]);
    }
    AppMethodBeat.o(194358);
  }
  
  public final void aT(int paramInt, long paramLong) {}
  
  final void aU(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194387);
    com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPSystemClipPlayer.java]", "switchPlayer: clipNo:" + paramInt + "   startPostion:" + paramLong);
    if (this.Mtu != null) {
      this.Mtu.release();
    }
    this.MtW = true;
    this.MtV = paramInt;
    this.Mtz.setDataSource(((com.tencent.thumbplayer.b.a.e)this.MtU.get(this.MtV)).getFilePath());
    this.Mtu = gaK();
    if (this.Mtu == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(194387);
      throw ((Throwable)localObject);
    }
    Object localObject = new com.tencent.thumbplayer.b.f().aV(100, paramLong);
    this.Mtu.b((com.tencent.thumbplayer.b.f)localObject);
    this.Mtu.prepare();
    AppMethodBeat.o(194387);
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(194353);
    this.Mtz.b(paramParcelFileDescriptor);
    this.Mtv.changeState(2);
    AppMethodBeat.o(194353);
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(194349);
    if (!this.MtA.ahG(3))
    {
      paramf = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(194349);
      throw paramf;
    }
    if (paramf.key == 100)
    {
      int j = (int)paramf.MvJ.value;
      com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPSystemClipPlayer.java]", "start position:".concat(String.valueOf(j)));
      int i = 0;
      while (i < this.MtU.size())
      {
        if ((((com.tencent.thumbplayer.b.a.e)this.MtU.get(i)).gbh() <= j) && (j <= ((com.tencent.thumbplayer.b.a.e)this.MtU.get(i)).gbh() + ((com.tencent.thumbplayer.b.a.e)this.MtU.get(i)).gbg()))
        {
          this.MtV = i;
          this.Mtz.setDataSource(((com.tencent.thumbplayer.b.a.e)this.MtU.get(i)).getFilePath());
          paramf.MvJ.value = (j - ((com.tencent.thumbplayer.b.a.e)this.MtU.get(i)).gbh());
        }
        i += 1;
      }
    }
    if (this.Mtu != null) {
      this.Mtu.b(paramf);
    }
    this.Mtz.a(paramf);
    AppMethodBeat.o(194349);
  }
  
  public final void bl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194355);
    if (!this.MtA.ahG(3))
    {
      AppMethodBeat.o(194355);
      return;
    }
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemClipPlayer.java]", "addSubtitleSource， url: " + paramString1 + ", name: " + paramString3 + ", mimeType: " + paramString2);
    this.Mtz.bl(paramString1, paramString2, paramString3);
    if (this.Mtu != null) {
      this.Mtu.bl(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(194355);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194375);
    if (!this.MtA.ahG(3))
    {
      AppMethodBeat.o(194375);
      return;
    }
    if (this.Mtu != null) {
      this.Mtu.c(paramBoolean, paramLong1, paramLong2);
    }
    this.Mtz.c(paramBoolean, paramLong1, paramLong2);
    AppMethodBeat.o(194375);
  }
  
  public final void cg(float paramFloat)
  {
    AppMethodBeat.i(194372);
    if (!this.MtA.ahG(3))
    {
      AppMethodBeat.o(194372);
      return;
    }
    if (this.Mtu != null) {
      this.Mtu.cg(paramFloat);
    }
    this.Mtz.Mtj = paramFloat;
    AppMethodBeat.o(194372);
  }
  
  public final void ch(float paramFloat)
  {
    AppMethodBeat.i(194373);
    if (!this.MtA.ahG(3))
    {
      AppMethodBeat.o(194373);
      return;
    }
    if (this.Mtu != null) {
      this.Mtu.ch(paramFloat);
    }
    this.Mtz.Mtk = paramFloat;
    AppMethodBeat.o(194373);
  }
  
  public final void g(String paramString1, String paramString2, List<com.tencent.thumbplayer.b.f> paramList)
  {
    AppMethodBeat.i(194356);
    if (this.Mtu != null) {
      this.Mtu.g(paramString1, paramString2, paramList);
    }
    AppMethodBeat.o(194356);
  }
  
  public final n[] gaF()
  {
    AppMethodBeat.i(194383);
    if (this.Mtu != null)
    {
      n[] arrayOfn = this.Mtu.gaF();
      AppMethodBeat.o(194383);
      return arrayOfn;
    }
    AppMethodBeat.o(194383);
    return null;
  }
  
  public final k[] gaG()
  {
    return new k[0];
  }
  
  public final long getBufferedDurationMs()
  {
    AppMethodBeat.i(194380);
    if (!this.MtA.ahG(15))
    {
      if (this.MtC != null)
      {
        l = this.MtC.Mta;
        AppMethodBeat.o(194380);
        return l;
      }
      AppMethodBeat.o(194380);
      return 0L;
    }
    long l = this.Mtu.getBufferedDurationMs();
    AppMethodBeat.o(194380);
    return l;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(194379);
    long l1 = 0L;
    int i = 0;
    while ((i < this.MtU.size()) && (i < this.MtV))
    {
      l1 += ((com.tencent.thumbplayer.b.a.e)this.MtU.get(i)).gbg();
      i += 1;
    }
    if (!this.MtA.ahG(12))
    {
      AppMethodBeat.o(194379);
      return l1;
    }
    long l2 = this.Mtu.getCurrentPositionMs();
    AppMethodBeat.o(194379);
    return l1 + l2;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(194378);
    Iterator localIterator = this.MtU.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((com.tencent.thumbplayer.b.a.e)localIterator.next()).gbg() + l) {}
    AppMethodBeat.o(194378);
    return l;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(194376);
    if (this.Mtu != null)
    {
      long l = this.Mtu.getPropertyLong(paramInt);
      AppMethodBeat.o(194376);
      return l;
    }
    AppMethodBeat.o(194376);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(194377);
    if (this.Mtu != null)
    {
      String str = this.Mtu.getPropertyString(paramInt);
      AppMethodBeat.o(194377);
      return str;
    }
    AppMethodBeat.o(194377);
    return "";
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(194382);
    if (this.MtC == null)
    {
      AppMethodBeat.o(194382);
      return 0;
    }
    if (this.MtC.bbt > 0L)
    {
      i = (int)this.MtC.bbt;
      AppMethodBeat.o(194382);
      return i;
    }
    if (!this.MtA.ahG(13))
    {
      AppMethodBeat.o(194382);
      return 0;
    }
    this.MtC.bbt = this.Mtu.getVideoHeight();
    int i = (int)this.MtC.bbt;
    AppMethodBeat.o(194382);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(194381);
    if (this.MtC == null)
    {
      AppMethodBeat.o(194381);
      return 0;
    }
    if (this.MtC.bbs > 0L)
    {
      i = (int)this.MtC.bbs;
      AppMethodBeat.o(194381);
      return i;
    }
    if (!this.MtA.ahG(13))
    {
      AppMethodBeat.o(194381);
      return 0;
    }
    this.MtC.bbs = this.Mtu.getVideoWidth();
    int i = (int)this.MtC.bbs;
    AppMethodBeat.o(194381);
    return i;
  }
  
  public final void kZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194367);
    if (!this.MtA.ahG(9))
    {
      AppMethodBeat.o(194367);
      return;
    }
    if ((paramInt1 >= gaJ().gbh()) && (paramInt1 <= gaJ().gbh() + gaJ().gbg()))
    {
      if (this.Mtu != null)
      {
        com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPSystemClipPlayer.java]", "seek to:" + paramInt1 + "/mode=" + paramInt2);
        this.Mtu.kZ((int)(paramInt1 - gaJ().gbh()), paramInt2);
        AppMethodBeat.o(194367);
      }
    }
    else {
      ahI(paramInt1);
    }
    AppMethodBeat.o(194367);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(194362);
    if (!this.MtA.ahG(6))
    {
      AppMethodBeat.o(194362);
      return;
    }
    if (this.Mtu == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(194362);
      throw localIllegalStateException1;
    }
    try
    {
      this.Mtu.pause();
      this.Mtv.changeState(6);
      AppMethodBeat.o(194362);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(194362);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(194359);
    if (!this.MtA.ahG(1))
    {
      AppMethodBeat.o(194359);
      return;
    }
    Object localObject;
    if (!this.Mtz.gaB())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(194359);
      throw ((Throwable)localObject);
    }
    this.Mtu = gaK();
    if (this.Mtu == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(194359);
      throw ((Throwable)localObject);
    }
    this.Mtv.changeState(3);
    this.Mtu.prepare();
    AppMethodBeat.o(194359);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(194360);
    if (!this.MtA.ahG(1))
    {
      AppMethodBeat.o(194360);
      return;
    }
    Object localObject;
    if (!this.Mtz.gaB())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(194360);
      throw ((Throwable)localObject);
    }
    this.Mtu = gaK();
    if (this.Mtu == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(194360);
      throw ((Throwable)localObject);
    }
    this.Mtv.changeState(3);
    this.Mtu.prepareAsync();
    AppMethodBeat.o(194360);
  }
  
  public final void release()
  {
    AppMethodBeat.i(194365);
    if (!this.MtA.ahG(16))
    {
      AppMethodBeat.o(194365);
      return;
    }
    try
    {
      if (this.Mtu != null) {
        this.Mtu.release();
      }
      return;
    }
    catch (Exception localException)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , release , exception");
      AppMethodBeat.o(194365);
      throw localIllegalStateException;
    }
    finally
    {
      this.Mtz.reset();
      this.Mtx.clear();
      this.Mtv.changeState(10);
      AppMethodBeat.o(194365);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194364);
    if (!this.MtA.ahG(8))
    {
      AppMethodBeat.o(194364);
      return;
    }
    try
    {
      if (this.Mtu != null) {
        this.Mtu.reset();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      IllegalStateException localIllegalStateException2 = new IllegalStateException("error , reset ,state invalid");
      AppMethodBeat.o(194364);
      throw localIllegalStateException2;
    }
    finally
    {
      this.Mtz.reset();
      this.Mtx.clear();
      this.Mtv.changeState(1);
      AppMethodBeat.o(194364);
    }
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(194366);
    if (!this.MtA.ahG(9))
    {
      AppMethodBeat.o(194366);
      return;
    }
    if ((paramInt >= gaJ().gbh()) && (paramInt <= gaJ().gbh() + gaJ().gbg()))
    {
      if (this.Mtu != null)
      {
        com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPSystemClipPlayer.java]", "seek to:".concat(String.valueOf(paramInt)));
        this.Mtu.seekTo((int)(paramInt - gaJ().gbh()));
        AppMethodBeat.o(194366);
      }
    }
    else {
      ahI(paramInt);
    }
    AppMethodBeat.o(194366);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(194351);
    setDataSource(paramString, null);
    AppMethodBeat.o(194351);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(194352);
    this.Mtz.setDataSource(paramString, paramMap);
    this.Mtv.changeState(2);
    AppMethodBeat.o(194352);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(194350);
    if (!this.MtA.ahG(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(194350);
      throw paramSurface;
    }
    if (this.Mtu != null) {
      this.Mtu.setSurface(paramSurface);
    }
    this.Mtz.mSurface = paramSurface;
    AppMethodBeat.o(194350);
  }
  
  public final void start()
  {
    AppMethodBeat.i(194361);
    if (!this.MtA.ahG(5))
    {
      AppMethodBeat.o(194361);
      return;
    }
    if (this.Mtu == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(194361);
      throw localIllegalStateException1;
    }
    try
    {
      this.Mtu.start();
      this.Mtv.changeState(5);
      AppMethodBeat.o(194361);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(194361);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194363);
    if (!this.MtA.ahG(7))
    {
      AppMethodBeat.o(194363);
      return;
    }
    if (this.Mtu == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(194363);
      throw localIllegalStateException1;
    }
    try
    {
      this.Mtu.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(194363);
      throw localIllegalStateException3;
    }
    finally
    {
      this.Mtv.changeState(8);
      AppMethodBeat.o(194363);
    }
  }
  
  public final void zJ(boolean paramBoolean)
  {
    AppMethodBeat.i(194374);
    if (!this.MtA.ahG(3))
    {
      AppMethodBeat.o(194374);
      return;
    }
    if (this.Mtu != null) {
      this.Mtu.zJ(paramBoolean);
    }
    this.Mtz.zJ(paramBoolean);
    AppMethodBeat.o(194374);
  }
  
  public final void zK(boolean paramBoolean)
  {
    AppMethodBeat.i(194371);
    if (!this.MtA.ahG(3))
    {
      AppMethodBeat.o(194371);
      return;
    }
    if (this.Mtu != null) {
      this.Mtu.zK(paramBoolean);
    }
    this.Mtz.Mti = paramBoolean;
    AppMethodBeat.o(194371);
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.h, c.i, c.j
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194342);
      b localb = b.this;
      if (localb.MtA.ahH(4)) {
        localb.Mtx.a(paramInt1, paramInt2, paramLong1, paramLong2);
      }
      AppMethodBeat.o(194342);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(194341);
      b localb = b.this;
      if (localb.MtA.ahH(3)) {
        localb.Mtx.a(paramInt, paramLong1, paramLong2, paramObject);
      }
      AppMethodBeat.o(194341);
    }
    
    public final void a(com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(194347);
      b localb = b.this;
      if (localb.MtA.ahH(7)) {
        localb.Mtx.a(paramc);
      }
      AppMethodBeat.o(194347);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(194345);
      b localb = b.this;
      if (localb.MtA.ahH(7)) {
        localb.Mtx.a(paramm);
      }
      AppMethodBeat.o(194345);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(194346);
      b localb = b.this;
      if (localb.MtA.ahH(7)) {
        localb.Mtx.a(paramo);
      }
      AppMethodBeat.o(194346);
    }
    
    public final void aC(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194344);
      b localb = b.this;
      if (localb.MtA.ahH(6))
      {
        localb.MtC.bbt = paramLong2;
        localb.MtC.bbs = paramLong1;
        localb.Mtx.aC(paramLong1, paramLong2);
      }
      AppMethodBeat.o(194344);
    }
    
    public final void clF()
    {
      AppMethodBeat.i(194343);
      b localb = b.this;
      if (localb.MtA.ahH(5)) {
        localb.Mtx.clF();
      }
      AppMethodBeat.o(194343);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(194340);
      b localb = b.this;
      if (localb.MtA.ahH(2))
      {
        if (localb.MtV >= localb.MtU.size() - 1)
        {
          localb.Mtv.changeState(7);
          localb.Mtx.onCompletion();
          AppMethodBeat.o(194340);
          return;
        }
        try
        {
          localb.aU(localb.MtV + 1, 0L);
          AppMethodBeat.o(194340);
          return;
        }
        catch (IOException localIOException)
        {
          com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemClipPlayer.java]", "handleOnComplete:" + localIOException.toString());
        }
      }
      AppMethodBeat.o(194340);
    }
    
    public final void ta()
    {
      AppMethodBeat.i(194339);
      b localb = b.this;
      if (localb.Mtx != null) {
        localb.Mtx.a(152, localb.MtV, 0L, null);
      }
      Object localObject;
      if (localb.MtW)
      {
        localb.start();
        if ((localb.MtX) && (localb.Mtx != null) && (!com.tencent.thumbplayer.utils.a.isEmpty(localb.MtY)))
        {
          localObject = (Long)localb.MtY.poll();
          if (localObject != null) {
            localb.Mtx.a(3, ((Long)localObject).longValue(), 0L, null);
          }
          localb.MtX = false;
        }
        AppMethodBeat.o(194339);
        return;
      }
      if (localb.MtA.ahH(1))
      {
        localb.Mtv.changeState(4);
        if (localb.Mtx != null) {
          localb.Mtx.ta();
        }
        localObject = localb.Mtu;
        n[] arrayOfn = localb.gaF();
        if (arrayOfn != null)
        {
          int i = 0;
          while (i < arrayOfn.length)
          {
            int j = arrayOfn[i].trackType;
            n localn = (n)localb.Mtz.Mtl.get(Integer.valueOf(j));
            if (arrayOfn[i].equals(localn)) {
              ((com.tencent.thumbplayer.a.a.b)localObject).aR(i, -1L);
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(194339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */