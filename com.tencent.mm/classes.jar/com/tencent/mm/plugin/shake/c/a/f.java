package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.c.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Map;

public final class f
  extends l.b
  implements i
{
  private static int JmX = 0;
  private long JmY;
  private b Jns;
  private d Jnt;
  private boolean Jnu;
  private boolean Jnv;
  private float iQD;
  private float iQE;
  private b.a iQJ;
  private int jaR;
  private com.tencent.mm.modelgeo.d lEL;
  private MMHandler mHandler;
  private String ovF;
  public int tpK;
  
  public f(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28202);
    this.Jnt = new d();
    this.JmY = 0L;
    this.mHandler = new MMHandler();
    this.jaR = 0;
    this.ovF = "";
    this.Jnu = false;
    this.Jnv = false;
    this.iQD = -85.0F;
    this.iQE = -1000.0F;
    this.iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28199);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(28199);
          return true;
        }
        if ((f.a(f.this) == -85.0F) && (f.b(f.this) == -1000.0F))
        {
          f.a(f.this, paramAnonymousFloat2);
          f.b(f.this, paramAnonymousFloat1);
          m.fHu().iQD = f.a(f.this);
          m.fHu().iQE = f.b(f.this);
          if (f.c(f.this))
          {
            Log.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
            f.d(f.this);
          }
        }
        AppMethodBeat.o(28199);
        return false;
      }
    };
    AppMethodBeat.o(28202);
  }
  
  private void cFO()
  {
    AppMethodBeat.i(28212);
    this.lEL = com.tencent.mm.modelgeo.d.blq();
    this.lEL.a(this.iQJ, true);
    AppMethodBeat.o(28212);
  }
  
  private void cFQ()
  {
    AppMethodBeat.i(28213);
    if (this.lEL != null) {
      this.lEL.b(this.iQJ);
    }
    AppMethodBeat.o(28213);
  }
  
  private void fHy()
  {
    AppMethodBeat.i(28208);
    if (this.Jnu)
    {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
      AppMethodBeat.o(28208);
      return;
    }
    this.Jnu = true;
    this.Jnv = false;
    Log.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
    this.Jns = new b(this.iQE, this.iQD, this.jaR, this.ovF);
    bh.aGY().a(this.Jns, 0);
    AppMethodBeat.o(28208);
  }
  
  private void fHz()
  {
    AppMethodBeat.i(28215);
    long l2 = System.currentTimeMillis() / 1000L;
    if (a.aew(JmX)) {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
    }
    for (long l1 = a.aex(JmX);; l1 = a.aey(a.fHL()))
    {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(l1)));
      this.JmY = (l1 + l2);
      AppMethodBeat.o(28215);
      return;
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
    }
  }
  
  public final void YS(String paramString)
  {
    AppMethodBeat.i(28204);
    if ((paramString != null) && (paramString.length() <= 256))
    {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.ovF);
      this.ovF = paramString;
      AppMethodBeat.o(28204);
      return;
    }
    Log.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28204);
  }
  
  public final void fGS()
  {
    AppMethodBeat.i(28211);
    bh.aGY().b(1250, this);
    cFQ();
    super.fGS();
    AppMethodBeat.o(28211);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28205);
    JmX = m.fHu().JmX;
    this.JmY = m.fHu().JmY;
    this.iQD = m.fHu().iQD;
    this.iQE = m.fHu().iQE;
    bh.aGY().a(1250, this);
    cFO();
    AppMethodBeat.o(28205);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(28214);
    if ((paramq instanceof b))
    {
      paramq = (b)paramq;
      paramString = this.Jnt;
      paramq = paramq.JmW;
      paramString.tpK = paramq.tpK;
      paramString.tnX = paramq.tnX;
      paramString.fUM = paramq.fUM;
      paramString.title = paramq.title;
      paramString.tnY = paramq.tnY;
      paramString.tnZ = paramq.tnZ;
      paramString.jEi = paramq.jEi;
      paramString.llI = paramq.llI;
      paramString.lmL = paramq.lmL;
      paramString.JmX = paramq.JmX;
      paramString.Jna = paramq.Jna;
      paramString.Jnb = paramq.Jnb;
      paramString.Jnc = paramq.Jnc;
      paramString.Jnd = paramq.Jnd;
      paramString.Jne = paramq.Jne;
      paramString.end_time = paramq.end_time;
      paramString.Jnf = paramq.Jnf;
      paramString.Jng = paramq.Jng;
      this.tpK = this.Jnt.tpK;
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.tpK + "  frequency_level:" + JmX + " control_flag:" + this.Jnt.Jna);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label344;
      }
      JmX = this.Jnt.JmX;
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
      if (this.JmD != null) {
        this.JmD.a(1250, this.Jnt, 1L);
      }
      fHz();
    }
    for (;;)
    {
      m.fHu().JmX = JmX;
      m.fHu().JmY = this.JmY;
      this.Jnu = false;
      AppMethodBeat.o(28214);
      return;
      label344:
      if (((paramInt1 == 5) && (paramInt2 == -1)) || ((paramInt1 == 4) && (paramInt2 != 0)))
      {
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.JmD != null) {
          this.JmD.a(1250, this.Jnt, 2L);
        }
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = a.aey(a.fHL());
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(l2)));
        this.JmY = (l1 + l2);
      }
      else
      {
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.JmD != null) {
          this.JmD.a(1250, this.Jnt, 2L);
        }
        fHz();
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28209);
    cFQ();
    AppMethodBeat.o(28209);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28206);
    if (this.Jns != null) {
      bh.aGY().a(this.Jns);
    }
    AppMethodBeat.o(28206);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28210);
    if (this.lEL != null) {
      this.lEL.a(this.iQJ, true);
    }
    AppMethodBeat.o(28210);
  }
  
  public final void setFromScene(int paramInt)
  {
    AppMethodBeat.i(28203);
    this.jaR = paramInt;
    Log.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(28203);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28207);
    init();
    reset();
    if (this.lEL == null) {
      cFO();
    }
    this.lEL.b(this.iQJ, true);
    Object localObject = m.fHu();
    if ((!TextUtils.isEmpty("key_shake_card_item")) && (((c)localObject).tmX.containsKey("key_shake_card_item"))) {}
    long l1;
    long l2;
    for (localObject = ((c)localObject).tmX.get("key_shake_card_item");; localObject = null)
    {
      l1 = System.currentTimeMillis() / 1000L;
      l2 = this.JmY;
      if ((localObject == null) || (!(localObject instanceof d))) {
        break;
      }
      localObject = (d)localObject;
      this.JmD.a(1250, (d)localObject, 1L);
      m.fHu().r("key_shake_card_item", null);
      Log.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
      AppMethodBeat.o(28207);
      return;
    }
    int i;
    if (this.JmY == 0L) {
      i = 1;
    }
    while (i != 0) {
      if (this.Jnu)
      {
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
        AppMethodBeat.o(28207);
        return;
        if (l1 - l2 >= 0L)
        {
          i = 1;
        }
        else
        {
          h.IzE.a(11666, new Object[] { Integer.valueOf(this.jaR) });
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28200);
              f.e(f.this).tpK = 3;
              f.a(f.this, f.e(f.this).tpK);
              f.e(f.this).Jne = m.fHu().JmZ;
              if (f.f(f.this) != null) {
                f.g(f.this).a(1250, f.e(f.this), 2L);
              }
              AppMethodBeat.o(28200);
            }
          }, 3000L);
          Log.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
          i = 0;
        }
      }
      else
      {
        if ((this.iQD == -85.0F) || (this.iQE == -1000.0F))
        {
          this.Jnv = true;
          Log.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28201);
              if (!f.h(f.this)) {
                f.d(f.this);
              }
              AppMethodBeat.o(28201);
            }
          }, 4000L);
          AppMethodBeat.o(28207);
          return;
        }
        fHy();
      }
    }
    AppMethodBeat.o(28207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.f
 * JD-Core Version:    0.7.0.1
 */