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
  j LWA;
  com.tencent.thumbplayer.a.e LWC;
  com.tencent.thumbplayer.a.c LWE;
  g LWF;
  com.tencent.thumbplayer.a.b LWH;
  private a LWY;
  List<com.tencent.thumbplayer.b.a.e> LWZ;
  com.tencent.thumbplayer.a.a.b LWz;
  int LXa;
  boolean LXb;
  boolean LXc;
  LinkedList<Long> LXd;
  private Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(191670);
    this.LXa = 0;
    this.mContext = paramContext;
    this.LWA = new j();
    this.LWE = new com.tencent.thumbplayer.a.c();
    this.LWY = new a((byte)0);
    this.LWC = new com.tencent.thumbplayer.a.e("TPThumbPlayer[TPSystemClipPlayer.java]");
    this.LWF = new g(this.LWA);
    this.LWZ = new ArrayList();
    AppMethodBeat.o(191670);
  }
  
  private void a(com.tencent.thumbplayer.a.a.b paramb)
  {
    AppMethodBeat.i(191712);
    if (1 == this.LWE.LWl.mType) {
      paramb.b(this.LWE.LWl.LWV);
    }
    if (this.LWE.LWl.mType == 0) {
      paramb.setDataSource(this.LWE.LWl.mUrl, this.LWE.LWl.mHttpHeaders);
    }
    Iterator localIterator = this.LWE.fWf().iterator();
    while (localIterator.hasNext()) {
      paramb.b((com.tencent.thumbplayer.b.f)localIterator.next());
    }
    localIterator = this.LWE.fWd().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.d)localIterator.next();
      paramb.bk(((com.tencent.thumbplayer.a.c.d)localObject).url, ((com.tencent.thumbplayer.a.c.d)localObject).mimeType, ((com.tencent.thumbplayer.a.c.d)localObject).name);
    }
    localIterator = this.LWE.fWe().iterator();
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.a)localIterator.next();
      paramb.g(((com.tencent.thumbplayer.a.c.a)localObject).url, ((com.tencent.thumbplayer.a.c.a)localObject).name, ((com.tencent.thumbplayer.a.c.a)localObject).LWt);
    }
    if (this.LWE.LWm != null) {
      paramb.c(this.LWE.LWm.LWu, this.LWE.LWm.LWv, this.LWE.LWm.LWw);
    }
    paramb.zw(this.LWE.LWn);
    if (this.LWE.LWo != 0.0F) {
      paramb.ci(this.LWE.LWo);
    }
    if (this.LWE.LWp != 0.0F) {
      paramb.cj(this.LWE.LWp);
    }
    if (this.LWE.mSurface != null) {
      paramb.setSurface(this.LWE.mSurface);
    }
    paramb.a(this.LWY);
    paramb.a(this.LWY);
    paramb.a(this.LWY);
    paramb.a(this.LWY);
    paramb.a(this.LWY);
    paramb.a(this.LWY);
    paramb.a(this.LWY);
    AppMethodBeat.o(191712);
  }
  
  private void agZ(int paramInt)
  {
    AppMethodBeat.i(191692);
    int i = 0;
    for (;;)
    {
      if (i < this.LWZ.size())
      {
        long l;
        if ((((com.tencent.thumbplayer.b.a.e)this.LWZ.get(i)).fWI() <= paramInt) && (paramInt <= ((com.tencent.thumbplayer.b.a.e)this.LWZ.get(i)).fWI() + ((com.tencent.thumbplayer.b.a.e)this.LWZ.get(i)).fWH())) {
          l = paramInt;
        }
        try
        {
          aT(i, l - ((com.tencent.thumbplayer.b.a.e)this.LWZ.get(i)).fWI());
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
    AppMethodBeat.o(191692);
  }
  
  private static List<com.tencent.thumbplayer.b.a.e> b(com.tencent.thumbplayer.b.a.a parama)
  {
    int i = 0;
    AppMethodBeat.i(191691);
    if ((!(parama instanceof com.tencent.thumbplayer.d.b)) && (!(parama instanceof com.tencent.thumbplayer.d.d)) && (!(parama instanceof com.tencent.thumbplayer.d.e)))
    {
      parama = new IllegalStateException("system mediaPlayer : media asset is illegal source!");
      AppMethodBeat.o(191691);
      throw parama;
    }
    ArrayList localArrayList = new ArrayList();
    if ((parama instanceof com.tencent.thumbplayer.d.b))
    {
      parama = ((com.tencent.thumbplayer.d.b)parama).Maj;
      if ((com.tencent.thumbplayer.utils.a.isEmpty(parama)) || (parama.get(0) == null))
      {
        parama = new IllegalStateException("empty av tracks when set data source!");
        AppMethodBeat.o(191691);
        throw parama;
      }
      parama = ((com.tencent.thumbplayer.b.a.d)parama.get(0)).fWE();
    }
    for (;;)
    {
      long l = 0L;
      while (i < parama.size())
      {
        ((com.tencent.thumbplayer.b.a.e)parama.get(i)).EZ(l);
        l += ((com.tencent.thumbplayer.b.a.e)parama.get(i)).fWH();
        i += 1;
      }
      if ((parama instanceof com.tencent.thumbplayer.d.d))
      {
        parama = ((com.tencent.thumbplayer.d.d)parama).Maq;
      }
      else
      {
        localArrayList.add((com.tencent.thumbplayer.b.a.e)parama);
        parama = localArrayList;
      }
    }
    AppMethodBeat.o(191691);
    return parama;
  }
  
  private com.tencent.thumbplayer.b.a.e fWk()
  {
    AppMethodBeat.i(191710);
    com.tencent.thumbplayer.b.a.e locale = (com.tencent.thumbplayer.b.a.e)this.LWZ.get(this.LXa);
    AppMethodBeat.o(191710);
    return locale;
  }
  
  private com.tencent.thumbplayer.a.a.b fWl()
  {
    AppMethodBeat.i(191711);
    c localc = new c(this.mContext);
    if (this.LWH == null) {
      this.LWH = new com.tencent.thumbplayer.a.b();
    }
    a(localc);
    AppMethodBeat.o(191711);
    return localc;
  }
  
  public final void M(String paramString, int paramInt, long paramLong) {}
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(191708);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(191708);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    this.LWC.LWL = paramb;
  }
  
  public final void a(c.c paramc)
  {
    this.LWC.LWN = paramc;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    this.LWC.LWM = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.LWC.LWK = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.LWC.LWO = paramf;
  }
  
  public final void a(c.h paramh)
  {
    this.LWC.LWQ = paramh;
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(191707);
    parami = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(191707);
    throw parami;
  }
  
  public final void a(c.j paramj)
  {
    this.LWC.LWP = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(191676);
    parama = b(parama);
    try
    {
      this.LWZ = parama;
      this.LWE.setDataSource(((com.tencent.thumbplayer.b.a.e)this.LWZ.get(this.LXa)).getFilePath());
      this.LWA.changeState(2);
      AppMethodBeat.o(191676);
      return;
    }
    catch (Exception parama)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemClipPlayer.java]", parama);
      parama = new IllegalStateException("exception when system clip player set data source!");
      AppMethodBeat.o(191676);
      throw parama;
    }
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(191690);
    parama = b(parama);
    if (com.tencent.thumbplayer.utils.a.isEmpty(parama))
    {
      parama = new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
      AppMethodBeat.o(191690);
      throw parama;
    }
    long l = getCurrentPositionMs();
    try
    {
      this.LWZ = parama;
      this.LXc = true;
      if (com.tencent.thumbplayer.utils.a.isEmpty(this.LXd)) {
        this.LXd = new LinkedList();
      }
      this.LXd.offer(Long.valueOf(paramLong));
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemClipPlayer.java]", "try to switch definition with system clip player, current clipNo:" + this.LXa);
      agZ((int)l);
      AppMethodBeat.o(191690);
      return;
    }
    catch (Exception parama)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemClipPlayer.java]", parama);
      parama = new IllegalStateException("exception when system clip player switch definition!");
      AppMethodBeat.o(191690);
      throw parama;
    }
  }
  
  public final void a(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(191706);
    if (this.LWz != null) {
      this.LWz.a(parame, paramd);
    }
    AppMethodBeat.o(191706);
  }
  
  public final void aQ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191679);
    if (!this.LWF.agX(3))
    {
      AppMethodBeat.o(191679);
      return;
    }
    n[] arrayOfn = fWg();
    if (arrayOfn != null)
    {
      this.LWE.a(paramInt, paramLong, arrayOfn[paramInt]);
      if (this.LWz != null) {
        this.LWz.aQ(paramInt, paramLong);
      }
    }
    AppMethodBeat.o(191679);
  }
  
  public final void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191680);
    if (!this.LWF.agX(3))
    {
      AppMethodBeat.o(191680);
      return;
    }
    if (this.LWz != null) {
      this.LWz.aR(paramInt, paramLong);
    }
    n[] arrayOfn = fWg();
    if (arrayOfn != null) {
      this.LWE.a(paramInt, arrayOfn[paramInt]);
    }
    AppMethodBeat.o(191680);
  }
  
  public final void aS(int paramInt, long paramLong) {}
  
  final void aT(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191709);
    com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPSystemClipPlayer.java]", "switchPlayer: clipNo:" + paramInt + "   startPostion:" + paramLong);
    if (this.LWz != null) {
      this.LWz.release();
    }
    this.LXb = true;
    this.LXa = paramInt;
    this.LWE.setDataSource(((com.tencent.thumbplayer.b.a.e)this.LWZ.get(this.LXa)).getFilePath());
    this.LWz = fWl();
    if (this.LWz == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(191709);
      throw ((Throwable)localObject);
    }
    Object localObject = new com.tencent.thumbplayer.b.f().aU(100, paramLong);
    this.LWz.b((com.tencent.thumbplayer.b.f)localObject);
    this.LWz.prepare();
    AppMethodBeat.o(191709);
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(191675);
    this.LWE.b(paramParcelFileDescriptor);
    this.LWA.changeState(2);
    AppMethodBeat.o(191675);
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(191671);
    if (!this.LWF.agX(3))
    {
      paramf = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(191671);
      throw paramf;
    }
    if (paramf.key == 100)
    {
      int j = (int)paramf.LYO.value;
      com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPSystemClipPlayer.java]", "start position:".concat(String.valueOf(j)));
      int i = 0;
      while (i < this.LWZ.size())
      {
        if ((((com.tencent.thumbplayer.b.a.e)this.LWZ.get(i)).fWI() <= j) && (j <= ((com.tencent.thumbplayer.b.a.e)this.LWZ.get(i)).fWI() + ((com.tencent.thumbplayer.b.a.e)this.LWZ.get(i)).fWH()))
        {
          this.LXa = i;
          this.LWE.setDataSource(((com.tencent.thumbplayer.b.a.e)this.LWZ.get(i)).getFilePath());
          paramf.LYO.value = (j - ((com.tencent.thumbplayer.b.a.e)this.LWZ.get(i)).fWI());
        }
        i += 1;
      }
    }
    if (this.LWz != null) {
      this.LWz.b(paramf);
    }
    this.LWE.a(paramf);
    AppMethodBeat.o(191671);
  }
  
  public final void bk(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(191677);
    if (!this.LWF.agX(3))
    {
      AppMethodBeat.o(191677);
      return;
    }
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemClipPlayer.java]", "addSubtitleSource， url: " + paramString1 + ", name: " + paramString3 + ", mimeType: " + paramString2);
    this.LWE.bk(paramString1, paramString2, paramString3);
    if (this.LWz != null) {
      this.LWz.bk(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(191677);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191697);
    if (!this.LWF.agX(3))
    {
      AppMethodBeat.o(191697);
      return;
    }
    if (this.LWz != null) {
      this.LWz.c(paramBoolean, paramLong1, paramLong2);
    }
    this.LWE.c(paramBoolean, paramLong1, paramLong2);
    AppMethodBeat.o(191697);
  }
  
  public final void ci(float paramFloat)
  {
    AppMethodBeat.i(191694);
    if (!this.LWF.agX(3))
    {
      AppMethodBeat.o(191694);
      return;
    }
    if (this.LWz != null) {
      this.LWz.ci(paramFloat);
    }
    this.LWE.LWo = paramFloat;
    AppMethodBeat.o(191694);
  }
  
  public final void cj(float paramFloat)
  {
    AppMethodBeat.i(191695);
    if (!this.LWF.agX(3))
    {
      AppMethodBeat.o(191695);
      return;
    }
    if (this.LWz != null) {
      this.LWz.cj(paramFloat);
    }
    this.LWE.LWp = paramFloat;
    AppMethodBeat.o(191695);
  }
  
  public final n[] fWg()
  {
    AppMethodBeat.i(191705);
    if (this.LWz != null)
    {
      n[] arrayOfn = this.LWz.fWg();
      AppMethodBeat.o(191705);
      return arrayOfn;
    }
    AppMethodBeat.o(191705);
    return null;
  }
  
  public final k[] fWh()
  {
    return new k[0];
  }
  
  public final void g(String paramString1, String paramString2, List<com.tencent.thumbplayer.b.f> paramList)
  {
    AppMethodBeat.i(191678);
    if (this.LWz != null) {
      this.LWz.g(paramString1, paramString2, paramList);
    }
    AppMethodBeat.o(191678);
  }
  
  public final long getBufferedDurationMs()
  {
    AppMethodBeat.i(191702);
    if (!this.LWF.agX(15))
    {
      if (this.LWH != null)
      {
        l = this.LWH.LWf;
        AppMethodBeat.o(191702);
        return l;
      }
      AppMethodBeat.o(191702);
      return 0L;
    }
    long l = this.LWz.getBufferedDurationMs();
    AppMethodBeat.o(191702);
    return l;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(191701);
    long l1 = 0L;
    int i = 0;
    while ((i < this.LWZ.size()) && (i < this.LXa))
    {
      l1 += ((com.tencent.thumbplayer.b.a.e)this.LWZ.get(i)).fWH();
      i += 1;
    }
    if (!this.LWF.agX(12))
    {
      AppMethodBeat.o(191701);
      return l1;
    }
    long l2 = this.LWz.getCurrentPositionMs();
    AppMethodBeat.o(191701);
    return l1 + l2;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(191700);
    Iterator localIterator = this.LWZ.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((com.tencent.thumbplayer.b.a.e)localIterator.next()).fWH() + l) {}
    AppMethodBeat.o(191700);
    return l;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(191698);
    if (this.LWz != null)
    {
      long l = this.LWz.getPropertyLong(paramInt);
      AppMethodBeat.o(191698);
      return l;
    }
    AppMethodBeat.o(191698);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(191699);
    if (this.LWz != null)
    {
      String str = this.LWz.getPropertyString(paramInt);
      AppMethodBeat.o(191699);
      return str;
    }
    AppMethodBeat.o(191699);
    return "";
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(191704);
    if (this.LWH == null)
    {
      AppMethodBeat.o(191704);
      return 0;
    }
    if (this.LWH.bbt > 0L)
    {
      i = (int)this.LWH.bbt;
      AppMethodBeat.o(191704);
      return i;
    }
    if (!this.LWF.agX(13))
    {
      AppMethodBeat.o(191704);
      return 0;
    }
    this.LWH.bbt = this.LWz.getVideoHeight();
    int i = (int)this.LWH.bbt;
    AppMethodBeat.o(191704);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(191703);
    if (this.LWH == null)
    {
      AppMethodBeat.o(191703);
      return 0;
    }
    if (this.LWH.bbs > 0L)
    {
      i = (int)this.LWH.bbs;
      AppMethodBeat.o(191703);
      return i;
    }
    if (!this.LWF.agX(13))
    {
      AppMethodBeat.o(191703);
      return 0;
    }
    this.LWH.bbs = this.LWz.getVideoWidth();
    int i = (int)this.LWH.bbs;
    AppMethodBeat.o(191703);
    return i;
  }
  
  public final void kS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191689);
    if (!this.LWF.agX(9))
    {
      AppMethodBeat.o(191689);
      return;
    }
    if ((paramInt1 >= fWk().fWI()) && (paramInt1 <= fWk().fWI() + fWk().fWH()))
    {
      if (this.LWz != null)
      {
        com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPSystemClipPlayer.java]", "seek to:" + paramInt1 + "/mode=" + paramInt2);
        this.LWz.kS((int)(paramInt1 - fWk().fWI()), paramInt2);
        AppMethodBeat.o(191689);
      }
    }
    else {
      agZ(paramInt1);
    }
    AppMethodBeat.o(191689);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(191684);
    if (!this.LWF.agX(6))
    {
      AppMethodBeat.o(191684);
      return;
    }
    if (this.LWz == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(191684);
      throw localIllegalStateException1;
    }
    try
    {
      this.LWz.pause();
      this.LWA.changeState(6);
      AppMethodBeat.o(191684);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(191684);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(191681);
    if (!this.LWF.agX(1))
    {
      AppMethodBeat.o(191681);
      return;
    }
    Object localObject;
    if (!this.LWE.fWc())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(191681);
      throw ((Throwable)localObject);
    }
    this.LWz = fWl();
    if (this.LWz == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(191681);
      throw ((Throwable)localObject);
    }
    this.LWA.changeState(3);
    this.LWz.prepare();
    AppMethodBeat.o(191681);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(191682);
    if (!this.LWF.agX(1))
    {
      AppMethodBeat.o(191682);
      return;
    }
    Object localObject;
    if (!this.LWE.fWc())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(191682);
      throw ((Throwable)localObject);
    }
    this.LWz = fWl();
    if (this.LWz == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(191682);
      throw ((Throwable)localObject);
    }
    this.LWA.changeState(3);
    this.LWz.prepareAsync();
    AppMethodBeat.o(191682);
  }
  
  public final void release()
  {
    AppMethodBeat.i(191687);
    if (!this.LWF.agX(16))
    {
      AppMethodBeat.o(191687);
      return;
    }
    try
    {
      if (this.LWz != null) {
        this.LWz.release();
      }
      return;
    }
    catch (Exception localException)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , release , exception");
      AppMethodBeat.o(191687);
      throw localIllegalStateException;
    }
    finally
    {
      this.LWE.reset();
      this.LWC.clear();
      this.LWA.changeState(10);
      AppMethodBeat.o(191687);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191686);
    if (!this.LWF.agX(8))
    {
      AppMethodBeat.o(191686);
      return;
    }
    try
    {
      if (this.LWz != null) {
        this.LWz.reset();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      IllegalStateException localIllegalStateException2 = new IllegalStateException("error , reset ,state invalid");
      AppMethodBeat.o(191686);
      throw localIllegalStateException2;
    }
    finally
    {
      this.LWE.reset();
      this.LWC.clear();
      this.LWA.changeState(1);
      AppMethodBeat.o(191686);
    }
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(191688);
    if (!this.LWF.agX(9))
    {
      AppMethodBeat.o(191688);
      return;
    }
    if ((paramInt >= fWk().fWI()) && (paramInt <= fWk().fWI() + fWk().fWH()))
    {
      if (this.LWz != null)
      {
        com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPSystemClipPlayer.java]", "seek to:".concat(String.valueOf(paramInt)));
        this.LWz.seekTo((int)(paramInt - fWk().fWI()));
        AppMethodBeat.o(191688);
      }
    }
    else {
      agZ(paramInt);
    }
    AppMethodBeat.o(191688);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(191673);
    setDataSource(paramString, null);
    AppMethodBeat.o(191673);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(191674);
    this.LWE.setDataSource(paramString, paramMap);
    this.LWA.changeState(2);
    AppMethodBeat.o(191674);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(191672);
    if (!this.LWF.agX(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(191672);
      throw paramSurface;
    }
    if (this.LWz != null) {
      this.LWz.setSurface(paramSurface);
    }
    this.LWE.mSurface = paramSurface;
    AppMethodBeat.o(191672);
  }
  
  public final void start()
  {
    AppMethodBeat.i(191683);
    if (!this.LWF.agX(5))
    {
      AppMethodBeat.o(191683);
      return;
    }
    if (this.LWz == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(191683);
      throw localIllegalStateException1;
    }
    try
    {
      this.LWz.start();
      this.LWA.changeState(5);
      AppMethodBeat.o(191683);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(191683);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(191685);
    if (!this.LWF.agX(7))
    {
      AppMethodBeat.o(191685);
      return;
    }
    if (this.LWz == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(191685);
      throw localIllegalStateException1;
    }
    try
    {
      this.LWz.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(191685);
      throw localIllegalStateException3;
    }
    finally
    {
      this.LWA.changeState(8);
      AppMethodBeat.o(191685);
    }
  }
  
  public final void zv(boolean paramBoolean)
  {
    AppMethodBeat.i(191696);
    if (!this.LWF.agX(3))
    {
      AppMethodBeat.o(191696);
      return;
    }
    if (this.LWz != null) {
      this.LWz.zv(paramBoolean);
    }
    this.LWE.zv(paramBoolean);
    AppMethodBeat.o(191696);
  }
  
  public final void zw(boolean paramBoolean)
  {
    AppMethodBeat.i(191693);
    if (!this.LWF.agX(3))
    {
      AppMethodBeat.o(191693);
      return;
    }
    if (this.LWz != null) {
      this.LWz.zw(paramBoolean);
    }
    this.LWE.LWn = paramBoolean;
    AppMethodBeat.o(191693);
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.h, c.i, c.j
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191664);
      b localb = b.this;
      if (localb.LWF.agY(4)) {
        localb.LWC.a(paramInt1, paramInt2, paramLong1, paramLong2);
      }
      AppMethodBeat.o(191664);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(191663);
      b localb = b.this;
      if (localb.LWF.agY(3)) {
        localb.LWC.a(paramInt, paramLong1, paramLong2, paramObject);
      }
      AppMethodBeat.o(191663);
    }
    
    public final void a(com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(191669);
      b localb = b.this;
      if (localb.LWF.agY(7)) {
        localb.LWC.a(paramc);
      }
      AppMethodBeat.o(191669);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(191667);
      b localb = b.this;
      if (localb.LWF.agY(7)) {
        localb.LWC.a(paramm);
      }
      AppMethodBeat.o(191667);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(191668);
      b localb = b.this;
      if (localb.LWF.agY(7)) {
        localb.LWC.a(paramo);
      }
      AppMethodBeat.o(191668);
    }
    
    public final void aD(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191666);
      b localb = b.this;
      if (localb.LWF.agY(6))
      {
        localb.LWH.bbt = paramLong2;
        localb.LWH.bbs = paramLong1;
        localb.LWC.aD(paramLong1, paramLong2);
      }
      AppMethodBeat.o(191666);
    }
    
    public final void ckp()
    {
      AppMethodBeat.i(191665);
      b localb = b.this;
      if (localb.LWF.agY(5)) {
        localb.LWC.ckp();
      }
      AppMethodBeat.o(191665);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(191662);
      b localb = b.this;
      if (localb.LWF.agY(2))
      {
        if (localb.LXa >= localb.LWZ.size() - 1)
        {
          localb.LWA.changeState(7);
          localb.LWC.onCompletion();
          AppMethodBeat.o(191662);
          return;
        }
        try
        {
          localb.aT(localb.LXa + 1, 0L);
          AppMethodBeat.o(191662);
          return;
        }
        catch (IOException localIOException)
        {
          com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemClipPlayer.java]", "handleOnComplete:" + localIOException.toString());
        }
      }
      AppMethodBeat.o(191662);
    }
    
    public final void ta()
    {
      AppMethodBeat.i(191661);
      b localb = b.this;
      if (localb.LWC != null) {
        localb.LWC.a(152, localb.LXa, 0L, null);
      }
      Object localObject;
      if (localb.LXb)
      {
        localb.start();
        if ((localb.LXc) && (localb.LWC != null) && (!com.tencent.thumbplayer.utils.a.isEmpty(localb.LXd)))
        {
          localObject = (Long)localb.LXd.poll();
          if (localObject != null) {
            localb.LWC.a(3, ((Long)localObject).longValue(), 0L, null);
          }
          localb.LXc = false;
        }
        AppMethodBeat.o(191661);
        return;
      }
      if (localb.LWF.agY(1))
      {
        localb.LWA.changeState(4);
        if (localb.LWC != null) {
          localb.LWC.ta();
        }
        localObject = localb.LWz;
        n[] arrayOfn = localb.fWg();
        if (arrayOfn != null)
        {
          int i = 0;
          while (i < arrayOfn.length)
          {
            int j = arrayOfn[i].trackType;
            n localn = (n)localb.LWE.LWq.get(Integer.valueOf(j));
            if (arrayOfn[i].equals(localn)) {
              ((com.tencent.thumbplayer.a.a.b)localObject).aQ(i, -1L);
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(191661);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */