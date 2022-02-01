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
import com.tencent.thumbplayer.b.a.a;
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
  com.tencent.thumbplayer.a.a.b KcD;
  j KcE;
  com.tencent.thumbplayer.a.e KcG;
  com.tencent.thumbplayer.a.c KcI;
  g KcJ;
  com.tencent.thumbplayer.a.b KcL;
  private a Kdc;
  List<com.tencent.thumbplayer.b.a.e> Kdd;
  int Kde;
  boolean Kdf;
  boolean Kdg;
  LinkedList<Long> Kdh;
  private Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(187649);
    this.Kde = 0;
    this.mContext = paramContext;
    this.KcE = new j();
    this.KcI = new com.tencent.thumbplayer.a.c();
    this.Kdc = new a((byte)0);
    this.KcG = new com.tencent.thumbplayer.a.e("TPThumbPlayer[TPSystemClipPlayer.java]");
    this.KcJ = new g(this.KcE);
    this.Kdd = new ArrayList();
    AppMethodBeat.o(187649);
  }
  
  private void a(com.tencent.thumbplayer.a.a.b paramb)
  {
    AppMethodBeat.i(187691);
    if (1 == this.KcI.Kcp.mType) {
      paramb.b(this.KcI.Kcp.KcZ);
    }
    if (this.KcI.Kcp.mType == 0) {
      paramb.setDataSource(this.KcI.Kcp.mUrl, this.KcI.Kcp.mHttpHeaders);
    }
    Iterator localIterator = this.KcI.fEN().iterator();
    while (localIterator.hasNext()) {
      paramb.b((com.tencent.thumbplayer.b.f)localIterator.next());
    }
    localIterator = this.KcI.fEL().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.d)localIterator.next();
      paramb.bb(((com.tencent.thumbplayer.a.c.d)localObject).url, ((com.tencent.thumbplayer.a.c.d)localObject).mimeType, ((com.tencent.thumbplayer.a.c.d)localObject).name);
    }
    localIterator = this.KcI.fEM().iterator();
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.a)localIterator.next();
      paramb.g(((com.tencent.thumbplayer.a.c.a)localObject).url, ((com.tencent.thumbplayer.a.c.a)localObject).name, ((com.tencent.thumbplayer.a.c.a)localObject).Kcx);
    }
    if (this.KcI.Kcq != null) {
      paramb.c(this.KcI.Kcq.Kcy, this.KcI.Kcq.Kcz, this.KcI.Kcq.KcA);
    }
    paramb.yJ(this.KcI.Kcr);
    if (this.KcI.Kcs != 0.0F) {
      paramb.cd(this.KcI.Kcs);
    }
    if (this.KcI.Kct != 0.0F) {
      paramb.ce(this.KcI.Kct);
    }
    if (this.KcI.mSurface != null) {
      paramb.setSurface(this.KcI.mSurface);
    }
    paramb.a(this.Kdc);
    paramb.a(this.Kdc);
    paramb.a(this.Kdc);
    paramb.a(this.Kdc);
    paramb.a(this.Kdc);
    paramb.a(this.Kdc);
    paramb.a(this.Kdc);
    AppMethodBeat.o(187691);
  }
  
  private void aez(int paramInt)
  {
    AppMethodBeat.i(187671);
    int i = 0;
    for (;;)
    {
      if (i < this.Kdd.size())
      {
        long l;
        if ((((com.tencent.thumbplayer.b.a.e)this.Kdd.get(i)).fFt() <= paramInt) && (paramInt <= ((com.tencent.thumbplayer.b.a.e)this.Kdd.get(i)).fFt() + ((com.tencent.thumbplayer.b.a.e)this.Kdd.get(i)).fFs())) {
          l = paramInt;
        }
        try
        {
          aJ(i, l - ((com.tencent.thumbplayer.b.a.e)this.Kdd.get(i)).fFt());
          i += 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemClipPlayer.java]", "selectClipPlayer:" + localIOException.toString());
          }
        }
      }
    }
    AppMethodBeat.o(187671);
  }
  
  private static List<com.tencent.thumbplayer.b.a.e> b(a parama)
  {
    int i = 0;
    AppMethodBeat.i(187670);
    if ((!(parama instanceof com.tencent.thumbplayer.d.b)) && (!(parama instanceof com.tencent.thumbplayer.d.d)) && (!(parama instanceof com.tencent.thumbplayer.d.e)))
    {
      parama = new IllegalStateException("system mediaPlayer : media asset is illegal source!");
      AppMethodBeat.o(187670);
      throw parama;
    }
    ArrayList localArrayList = new ArrayList();
    if ((parama instanceof com.tencent.thumbplayer.d.b))
    {
      parama = ((com.tencent.thumbplayer.d.b)parama).KgT;
      if ((com.tencent.thumbplayer.utils.b.isEmpty(parama)) || (parama.get(0) == null))
      {
        parama = new IllegalStateException("empty av tracks when set data source!");
        AppMethodBeat.o(187670);
        throw parama;
      }
      parama = ((com.tencent.thumbplayer.b.a.d)parama.get(0)).fFn();
    }
    for (;;)
    {
      long l = 0L;
      while (i < parama.size())
      {
        ((com.tencent.thumbplayer.b.a.e)parama.get(i)).BX(l);
        l += ((com.tencent.thumbplayer.b.a.e)parama.get(i)).fFs();
        i += 1;
      }
      if ((parama instanceof com.tencent.thumbplayer.d.d))
      {
        parama = ((com.tencent.thumbplayer.d.d)parama).Kha;
      }
      else
      {
        localArrayList.add((com.tencent.thumbplayer.b.a.e)parama);
        parama = localArrayList;
      }
    }
    AppMethodBeat.o(187670);
    return parama;
  }
  
  private com.tencent.thumbplayer.b.a.e fES()
  {
    AppMethodBeat.i(187689);
    com.tencent.thumbplayer.b.a.e locale = (com.tencent.thumbplayer.b.a.e)this.Kdd.get(this.Kde);
    AppMethodBeat.o(187689);
    return locale;
  }
  
  private com.tencent.thumbplayer.a.a.b fET()
  {
    AppMethodBeat.i(187690);
    c localc = new c(this.mContext);
    if (this.KcL == null) {
      this.KcL = new com.tencent.thumbplayer.a.b();
    }
    a(localc);
    AppMethodBeat.o(187690);
    return localc;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(187687);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(187687);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    this.KcG.KcP = paramb;
  }
  
  public final void a(c.c paramc)
  {
    this.KcG.KcR = paramc;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    this.KcG.KcQ = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.KcG.KcO = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.KcG.KcS = paramf;
  }
  
  public final void a(c.h paramh)
  {
    this.KcG.KcU = paramh;
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(187686);
    parami = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(187686);
    throw parami;
  }
  
  public final void a(c.j paramj)
  {
    this.KcG.KcT = paramj;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(187655);
    parama = b(parama);
    try
    {
      this.Kdd = parama;
      this.KcI.setDataSource(((com.tencent.thumbplayer.b.a.e)this.Kdd.get(this.Kde)).getFilePath());
      this.KcE.changeState(2);
      AppMethodBeat.o(187655);
      return;
    }
    catch (Exception parama)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemClipPlayer.java]", parama);
      parama = new IllegalStateException("exception when system clip player set data source!");
      AppMethodBeat.o(187655);
      throw parama;
    }
  }
  
  public final void a(a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(187669);
    parama = b(parama);
    if (com.tencent.thumbplayer.utils.b.isEmpty(parama))
    {
      parama = new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
      AppMethodBeat.o(187669);
      throw parama;
    }
    long l = getCurrentPositionMs();
    try
    {
      this.Kdd = parama;
      this.Kdg = true;
      if (com.tencent.thumbplayer.utils.b.isEmpty(this.Kdh)) {
        this.Kdh = new LinkedList();
      }
      this.Kdh.offer(Long.valueOf(paramLong));
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemClipPlayer.java]", "try to switch definition with system clip player, current clipNo:" + this.Kde);
      aez((int)l);
      AppMethodBeat.o(187669);
      return;
    }
    catch (Exception parama)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemClipPlayer.java]", parama);
      parama = new IllegalStateException("exception when system clip player switch definition!");
      AppMethodBeat.o(187669);
      throw parama;
    }
  }
  
  public final void a(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(187685);
    if (this.KcD != null) {
      this.KcD.a(parame, paramd);
    }
    AppMethodBeat.o(187685);
  }
  
  public final void aG(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187658);
    if (!this.KcJ.aex(3))
    {
      AppMethodBeat.o(187658);
      return;
    }
    n[] arrayOfn = fEO();
    if (arrayOfn != null)
    {
      this.KcI.a(paramInt, paramLong, arrayOfn[paramInt]);
      if (this.KcD != null) {
        this.KcD.aG(paramInt, paramLong);
      }
    }
    AppMethodBeat.o(187658);
  }
  
  public final void aH(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187659);
    if (!this.KcJ.aex(3))
    {
      AppMethodBeat.o(187659);
      return;
    }
    if (this.KcD != null) {
      this.KcD.aH(paramInt, paramLong);
    }
    n[] arrayOfn = fEO();
    if (arrayOfn != null) {
      this.KcI.a(paramInt, arrayOfn[paramInt]);
    }
    AppMethodBeat.o(187659);
  }
  
  public final void aI(int paramInt, long paramLong) {}
  
  final void aJ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187688);
    com.tencent.thumbplayer.utils.f.d("TPThumbPlayer[TPSystemClipPlayer.java]", "switchPlayer: clipNo:" + paramInt + "   startPostion:" + paramLong);
    if (this.KcD != null) {
      this.KcD.release();
    }
    this.Kdf = true;
    this.Kde = paramInt;
    this.KcI.setDataSource(((com.tencent.thumbplayer.b.a.e)this.Kdd.get(this.Kde)).getFilePath());
    this.KcD = fET();
    if (this.KcD == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(187688);
      throw ((Throwable)localObject);
    }
    Object localObject = new com.tencent.thumbplayer.b.f().aK(100, paramLong);
    this.KcD.b((com.tencent.thumbplayer.b.f)localObject);
    this.KcD.prepare();
    AppMethodBeat.o(187688);
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(187654);
    this.KcI.b(paramParcelFileDescriptor);
    this.KcE.changeState(2);
    AppMethodBeat.o(187654);
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(187650);
    if (!this.KcJ.aex(3))
    {
      paramf = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(187650);
      throw paramf;
    }
    if (paramf.key == 100)
    {
      int j = (int)paramf.KeS.value;
      com.tencent.thumbplayer.utils.f.d("TPThumbPlayer[TPSystemClipPlayer.java]", "start position:".concat(String.valueOf(j)));
      int i = 0;
      while (i < this.Kdd.size())
      {
        if ((((com.tencent.thumbplayer.b.a.e)this.Kdd.get(i)).fFt() <= j) && (j <= ((com.tencent.thumbplayer.b.a.e)this.Kdd.get(i)).fFt() + ((com.tencent.thumbplayer.b.a.e)this.Kdd.get(i)).fFs()))
        {
          this.Kde = i;
          this.KcI.setDataSource(((com.tencent.thumbplayer.b.a.e)this.Kdd.get(i)).getFilePath());
          paramf.KeS.value = (j - ((com.tencent.thumbplayer.b.a.e)this.Kdd.get(i)).fFt());
        }
        i += 1;
      }
    }
    if (this.KcD != null) {
      this.KcD.b(paramf);
    }
    this.KcI.a(paramf);
    AppMethodBeat.o(187650);
  }
  
  public final void bb(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187656);
    if (!this.KcJ.aex(3))
    {
      AppMethodBeat.o(187656);
      return;
    }
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemClipPlayer.java]", "addSubtitleSource， url: " + paramString1 + ", name: " + paramString3 + ", mimeType: " + paramString2);
    this.KcI.bb(paramString1, paramString2, paramString3);
    if (this.KcD != null) {
      this.KcD.bb(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(187656);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187676);
    if (!this.KcJ.aex(3))
    {
      AppMethodBeat.o(187676);
      return;
    }
    if (this.KcD != null) {
      this.KcD.c(paramBoolean, paramLong1, paramLong2);
    }
    this.KcI.c(paramBoolean, paramLong1, paramLong2);
    AppMethodBeat.o(187676);
  }
  
  public final void cd(float paramFloat)
  {
    AppMethodBeat.i(187673);
    if (!this.KcJ.aex(3))
    {
      AppMethodBeat.o(187673);
      return;
    }
    if (this.KcD != null) {
      this.KcD.cd(paramFloat);
    }
    this.KcI.Kcs = paramFloat;
    AppMethodBeat.o(187673);
  }
  
  public final void ce(float paramFloat)
  {
    AppMethodBeat.i(187674);
    if (!this.KcJ.aex(3))
    {
      AppMethodBeat.o(187674);
      return;
    }
    if (this.KcD != null) {
      this.KcD.ce(paramFloat);
    }
    this.KcI.Kct = paramFloat;
    AppMethodBeat.o(187674);
  }
  
  public final n[] fEO()
  {
    AppMethodBeat.i(187684);
    if (this.KcD != null)
    {
      n[] arrayOfn = this.KcD.fEO();
      AppMethodBeat.o(187684);
      return arrayOfn;
    }
    AppMethodBeat.o(187684);
    return null;
  }
  
  public final k[] fEP()
  {
    return new k[0];
  }
  
  public final void g(String paramString1, String paramString2, List<com.tencent.thumbplayer.b.f> paramList)
  {
    AppMethodBeat.i(187657);
    if (this.KcD != null) {
      this.KcD.g(paramString1, paramString2, paramList);
    }
    AppMethodBeat.o(187657);
  }
  
  public final long getBufferedDurationMs()
  {
    AppMethodBeat.i(187681);
    if (!this.KcJ.aex(15))
    {
      if (this.KcL != null)
      {
        l = this.KcL.Kcj;
        AppMethodBeat.o(187681);
        return l;
      }
      AppMethodBeat.o(187681);
      return 0L;
    }
    long l = this.KcD.getBufferedDurationMs();
    AppMethodBeat.o(187681);
    return l;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(187680);
    long l1 = 0L;
    int i = 0;
    while ((i < this.Kdd.size()) && (i < this.Kde))
    {
      l1 += ((com.tencent.thumbplayer.b.a.e)this.Kdd.get(i)).fFs();
      i += 1;
    }
    if (!this.KcJ.aex(12))
    {
      AppMethodBeat.o(187680);
      return l1;
    }
    long l2 = this.KcD.getCurrentPositionMs();
    AppMethodBeat.o(187680);
    return l1 + l2;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(187679);
    Iterator localIterator = this.Kdd.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((com.tencent.thumbplayer.b.a.e)localIterator.next()).fFs() + l) {}
    AppMethodBeat.o(187679);
    return l;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(187677);
    if (this.KcD != null)
    {
      long l = this.KcD.getPropertyLong(paramInt);
      AppMethodBeat.o(187677);
      return l;
    }
    AppMethodBeat.o(187677);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(187678);
    if (this.KcD != null)
    {
      String str = this.KcD.getPropertyString(paramInt);
      AppMethodBeat.o(187678);
      return str;
    }
    AppMethodBeat.o(187678);
    return "";
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(187683);
    if (this.KcL == null)
    {
      AppMethodBeat.o(187683);
      return 0;
    }
    if (this.KcL.aQY > 0L)
    {
      i = (int)this.KcL.aQY;
      AppMethodBeat.o(187683);
      return i;
    }
    if (!this.KcJ.aex(13))
    {
      AppMethodBeat.o(187683);
      return 0;
    }
    this.KcL.aQY = this.KcD.getVideoHeight();
    int i = (int)this.KcL.aQY;
    AppMethodBeat.o(187683);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(187682);
    if (this.KcL == null)
    {
      AppMethodBeat.o(187682);
      return 0;
    }
    if (this.KcL.aQX > 0L)
    {
      i = (int)this.KcL.aQX;
      AppMethodBeat.o(187682);
      return i;
    }
    if (!this.KcJ.aex(13))
    {
      AppMethodBeat.o(187682);
      return 0;
    }
    this.KcL.aQX = this.KcD.getVideoWidth();
    int i = (int)this.KcL.aQX;
    AppMethodBeat.o(187682);
    return i;
  }
  
  public final void kD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187668);
    if (!this.KcJ.aex(9))
    {
      AppMethodBeat.o(187668);
      return;
    }
    if ((paramInt1 >= fES().fFt()) && (paramInt1 <= fES().fFt() + fES().fFs()))
    {
      if (this.KcD != null)
      {
        com.tencent.thumbplayer.utils.f.d("TPThumbPlayer[TPSystemClipPlayer.java]", "seek to:" + paramInt1 + "/mode=" + paramInt2);
        this.KcD.kD((int)(paramInt1 - fES().fFt()), paramInt2);
        AppMethodBeat.o(187668);
      }
    }
    else {
      aez(paramInt1);
    }
    AppMethodBeat.o(187668);
  }
  
  public final void p(String paramString, int paramInt, long paramLong) {}
  
  public final void pause()
  {
    AppMethodBeat.i(187663);
    if (!this.KcJ.aex(6))
    {
      AppMethodBeat.o(187663);
      return;
    }
    if (this.KcD == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(187663);
      throw localIllegalStateException1;
    }
    try
    {
      this.KcD.pause();
      this.KcE.changeState(6);
      AppMethodBeat.o(187663);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(187663);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(187660);
    if (!this.KcJ.aex(1))
    {
      AppMethodBeat.o(187660);
      return;
    }
    Object localObject;
    if (!this.KcI.fEK())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(187660);
      throw ((Throwable)localObject);
    }
    this.KcD = fET();
    if (this.KcD == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(187660);
      throw ((Throwable)localObject);
    }
    this.KcE.changeState(3);
    this.KcD.prepare();
    AppMethodBeat.o(187660);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(187661);
    if (!this.KcJ.aex(1))
    {
      AppMethodBeat.o(187661);
      return;
    }
    Object localObject;
    if (!this.KcI.fEK())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(187661);
      throw ((Throwable)localObject);
    }
    this.KcD = fET();
    if (this.KcD == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(187661);
      throw ((Throwable)localObject);
    }
    this.KcE.changeState(3);
    this.KcD.prepareAsync();
    AppMethodBeat.o(187661);
  }
  
  public final void release()
  {
    AppMethodBeat.i(187666);
    if (!this.KcJ.aex(16))
    {
      AppMethodBeat.o(187666);
      return;
    }
    try
    {
      if (this.KcD != null) {
        this.KcD.release();
      }
      return;
    }
    catch (Exception localException)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , release , exception");
      AppMethodBeat.o(187666);
      throw localIllegalStateException;
    }
    finally
    {
      this.KcI.reset();
      this.KcG.clear();
      this.KcE.changeState(10);
      AppMethodBeat.o(187666);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(187665);
    if (!this.KcJ.aex(8))
    {
      AppMethodBeat.o(187665);
      return;
    }
    try
    {
      if (this.KcD != null) {
        this.KcD.reset();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      IllegalStateException localIllegalStateException2 = new IllegalStateException("error , reset ,state invalid");
      AppMethodBeat.o(187665);
      throw localIllegalStateException2;
    }
    finally
    {
      this.KcI.reset();
      this.KcG.clear();
      this.KcE.changeState(1);
      AppMethodBeat.o(187665);
    }
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(187667);
    if (!this.KcJ.aex(9))
    {
      AppMethodBeat.o(187667);
      return;
    }
    if ((paramInt >= fES().fFt()) && (paramInt <= fES().fFt() + fES().fFs()))
    {
      if (this.KcD != null)
      {
        com.tencent.thumbplayer.utils.f.d("TPThumbPlayer[TPSystemClipPlayer.java]", "seek to:".concat(String.valueOf(paramInt)));
        this.KcD.seekTo((int)(paramInt - fES().fFt()));
        AppMethodBeat.o(187667);
      }
    }
    else {
      aez(paramInt);
    }
    AppMethodBeat.o(187667);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(187652);
    setDataSource(paramString, null);
    AppMethodBeat.o(187652);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(187653);
    this.KcI.setDataSource(paramString, paramMap);
    this.KcE.changeState(2);
    AppMethodBeat.o(187653);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(187651);
    if (!this.KcJ.aex(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(187651);
      throw paramSurface;
    }
    if (this.KcD != null) {
      this.KcD.setSurface(paramSurface);
    }
    this.KcI.mSurface = paramSurface;
    AppMethodBeat.o(187651);
  }
  
  public final void start()
  {
    AppMethodBeat.i(187662);
    if (!this.KcJ.aex(5))
    {
      AppMethodBeat.o(187662);
      return;
    }
    if (this.KcD == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(187662);
      throw localIllegalStateException1;
    }
    try
    {
      this.KcD.start();
      this.KcE.changeState(5);
      AppMethodBeat.o(187662);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(187662);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(187664);
    if (!this.KcJ.aex(7))
    {
      AppMethodBeat.o(187664);
      return;
    }
    if (this.KcD == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(187664);
      throw localIllegalStateException1;
    }
    try
    {
      this.KcD.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(187664);
      throw localIllegalStateException3;
    }
    finally
    {
      this.KcE.changeState(8);
      AppMethodBeat.o(187664);
    }
  }
  
  public final void yI(boolean paramBoolean)
  {
    AppMethodBeat.i(187675);
    if (!this.KcJ.aex(3))
    {
      AppMethodBeat.o(187675);
      return;
    }
    if (this.KcD != null) {
      this.KcD.yI(paramBoolean);
    }
    this.KcI.yI(paramBoolean);
    AppMethodBeat.o(187675);
  }
  
  public final void yJ(boolean paramBoolean)
  {
    AppMethodBeat.i(187672);
    if (!this.KcJ.aex(3))
    {
      AppMethodBeat.o(187672);
      return;
    }
    if (this.KcD != null) {
      this.KcD.yJ(paramBoolean);
    }
    this.KcI.Kcr = paramBoolean;
    AppMethodBeat.o(187672);
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.h, c.i, c.j
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187643);
      b localb = b.this;
      if (localb.KcJ.aey(4)) {
        localb.KcG.a(paramInt1, paramInt2, paramLong1, paramLong2);
      }
      AppMethodBeat.o(187643);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(187642);
      b localb = b.this;
      if (localb.KcJ.aey(3)) {
        localb.KcG.a(paramInt, paramLong1, paramLong2, paramObject);
      }
      AppMethodBeat.o(187642);
    }
    
    public final void a(com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(187648);
      b localb = b.this;
      if (localb.KcJ.aey(7)) {
        localb.KcG.a(paramc);
      }
      AppMethodBeat.o(187648);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(187646);
      b localb = b.this;
      if (localb.KcJ.aey(7)) {
        localb.KcG.a(paramm);
      }
      AppMethodBeat.o(187646);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(187647);
      b localb = b.this;
      if (localb.KcJ.aey(7)) {
        localb.KcG.a(paramo);
      }
      AppMethodBeat.o(187647);
    }
    
    public final void ay(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187645);
      b localb = b.this;
      if (localb.KcJ.aey(6))
      {
        localb.KcL.aQY = paramLong2;
        localb.KcL.aQX = paramLong1;
        localb.KcG.ay(paramLong1, paramLong2);
      }
      AppMethodBeat.o(187645);
    }
    
    public final void cfM()
    {
      AppMethodBeat.i(187644);
      b localb = b.this;
      if (localb.KcJ.aey(5)) {
        localb.KcG.cfM();
      }
      AppMethodBeat.o(187644);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(187641);
      b localb = b.this;
      if (localb.KcJ.aey(2))
      {
        if (localb.Kde >= localb.Kdd.size() - 1)
        {
          localb.KcE.changeState(7);
          localb.KcG.onCompletion();
          AppMethodBeat.o(187641);
          return;
        }
        try
        {
          localb.aJ(localb.Kde + 1, 0L);
          AppMethodBeat.o(187641);
          return;
        }
        catch (IOException localIOException)
        {
          com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemClipPlayer.java]", "handleOnComplete:" + localIOException.toString());
        }
      }
      AppMethodBeat.o(187641);
    }
    
    public final void rB()
    {
      AppMethodBeat.i(187640);
      b localb = b.this;
      if (localb.KcG != null) {
        localb.KcG.a(152, localb.Kde, 0L, null);
      }
      Object localObject;
      if (localb.Kdf)
      {
        localb.start();
        if ((localb.Kdg) && (localb.KcG != null) && (!com.tencent.thumbplayer.utils.b.isEmpty(localb.Kdh)))
        {
          localObject = (Long)localb.Kdh.poll();
          if (localObject != null) {
            localb.KcG.a(3, ((Long)localObject).longValue(), 0L, null);
          }
          localb.Kdg = false;
        }
        AppMethodBeat.o(187640);
        return;
      }
      if (localb.KcJ.aey(1))
      {
        localb.KcE.changeState(4);
        if (localb.KcG != null) {
          localb.KcG.rB();
        }
        localObject = localb.KcD;
        n[] arrayOfn = localb.fEO();
        if (arrayOfn != null)
        {
          int i = 0;
          while (i < arrayOfn.length)
          {
            int j = arrayOfn[i].trackType;
            n localn = (n)localb.KcI.Kcu.get(Integer.valueOf(j));
            if (arrayOfn[i].equals(localn)) {
              ((com.tencent.thumbplayer.a.a.b)localObject).aG(i, -1L);
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(187640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */