package com.tencent.mm.plugin.shake.shakecard.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.plugin.shake.model.l.a;
import com.tencent.mm.plugin.shake.model.l.b;
import com.tencent.mm.plugin.shake.model.m;
import com.tencent.mm.plugin.shake.shakecard.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Map;

public final class f
  extends l.b
  implements com.tencent.mm.am.h
{
  private static int PzN = 0;
  private b PAi;
  private d PAj;
  private boolean PAk;
  private boolean PAl;
  private long PzO;
  private int lCR;
  private float lsA;
  private b.a lsF;
  private float lsz;
  private MMHandler mHandler;
  private com.tencent.mm.modelgeo.d owr;
  private String ryZ;
  public int wuj;
  
  public f(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28202);
    this.PAj = new d();
    this.PzO = 0L;
    this.mHandler = new MMHandler();
    this.lCR = 0;
    this.ryZ = "";
    this.PAk = false;
    this.PAl = false;
    this.lsz = -85.0F;
    this.lsA = -1000.0F;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(273544);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(273544);
          return true;
        }
        if ((f.a(f.this) == -85.0F) && (f.b(f.this) == -1000.0F))
        {
          f.a(f.this, paramAnonymousFloat2);
          f.b(f.this, paramAnonymousFloat1);
          m.gXj().lsz = f.a(f.this);
          m.gXj().lsA = f.b(f.this);
          if (f.c(f.this))
          {
            Log.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
            f.d(f.this);
          }
        }
        AppMethodBeat.o(273544);
        return false;
      }
    };
    AppMethodBeat.o(28202);
  }
  
  private void djg()
  {
    AppMethodBeat.i(28212);
    this.owr = com.tencent.mm.modelgeo.d.bJl();
    this.owr.a(this.lsF, true, true);
    l.kK(22, 10);
    AppMethodBeat.o(28212);
  }
  
  private void dji()
  {
    AppMethodBeat.i(28213);
    if (this.owr != null) {
      this.owr.a(this.lsF);
    }
    AppMethodBeat.o(28213);
  }
  
  private void gXn()
  {
    AppMethodBeat.i(28208);
    if (this.PAk)
    {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
      AppMethodBeat.o(28208);
      return;
    }
    this.PAk = true;
    this.PAl = false;
    Log.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
    this.PAi = new b(this.lsA, this.lsz, this.lCR, this.ryZ);
    bh.aZW().a(this.PAi, 0);
    AppMethodBeat.o(28208);
  }
  
  private void gXo()
  {
    AppMethodBeat.i(28215);
    long l2 = System.currentTimeMillis() / 1000L;
    if (a.ajd(PzN)) {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
    }
    for (long l1 = a.aje(PzN);; l1 = a.ajf(a.gXB()))
    {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(l1)));
      this.PzO = (l1 + l2);
      AppMethodBeat.o(28215);
      return;
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
    }
  }
  
  public final void QX(String paramString)
  {
    AppMethodBeat.i(28204);
    if ((paramString != null) && (paramString.length() <= 256))
    {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.ryZ);
      this.ryZ = paramString;
      AppMethodBeat.o(28204);
      return;
    }
    Log.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28204);
  }
  
  public final void gWH()
  {
    AppMethodBeat.i(28211);
    bh.aZW().b(1250, this);
    dji();
    super.gWH();
    AppMethodBeat.o(28211);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28205);
    PzN = m.gXj().PzN;
    this.PzO = m.gXj().PzO;
    this.lsz = m.gXj().lsz;
    this.lsA = m.gXj().lsA;
    bh.aZW().a(1250, this);
    djg();
    AppMethodBeat.o(28205);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(28214);
    if ((paramp instanceof b))
    {
      paramp = (b)paramp;
      paramString = this.PAj;
      paramp = paramp.PzM;
      paramString.wuj = paramp.wuj;
      paramString.wsy = paramp.wsy;
      paramString.iaJ = paramp.iaJ;
      paramString.title = paramp.title;
      paramString.wsz = paramp.wsz;
      paramString.wsA = paramp.wsA;
      paramString.mee = paramp.mee;
      paramString.nQG = paramp.nQG;
      paramString.nRQ = paramp.nRQ;
      paramString.PzN = paramp.PzN;
      paramString.PzQ = paramp.PzQ;
      paramString.PzR = paramp.PzR;
      paramString.PzS = paramp.PzS;
      paramString.PzT = paramp.PzT;
      paramString.PzU = paramp.PzU;
      paramString.end_time = paramp.end_time;
      paramString.PzV = paramp.PzV;
      paramString.PzW = paramp.PzW;
      this.wuj = this.PAj.wuj;
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.wuj + "  frequency_level:" + PzN + " control_flag:" + this.PAj.PzQ);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label344;
      }
      PzN = this.PAj.PzN;
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
      if (this.Pzt != null) {
        this.Pzt.a(1250, this.PAj, 1L);
      }
      gXo();
    }
    for (;;)
    {
      m.gXj().PzN = PzN;
      m.gXj().PzO = this.PzO;
      this.PAk = false;
      AppMethodBeat.o(28214);
      return;
      label344:
      if (((paramInt1 == 5) && (paramInt2 == -1)) || ((paramInt1 == 4) && (paramInt2 != 0)))
      {
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.Pzt != null) {
          this.Pzt.a(1250, this.PAj, 2L);
        }
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = a.ajf(a.gXB());
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(l2)));
        this.PzO = (l1 + l2);
      }
      else
      {
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.Pzt != null) {
          this.Pzt.a(1250, this.PAj, 2L);
        }
        gXo();
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28209);
    dji();
    AppMethodBeat.o(28209);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28206);
    if (this.PAi != null) {
      bh.aZW().a(this.PAi);
    }
    AppMethodBeat.o(28206);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28210);
    if (this.owr != null)
    {
      this.owr.a(this.lsF, true, true);
      l.kK(22, 10);
    }
    AppMethodBeat.o(28210);
  }
  
  public final void setFromScene(int paramInt)
  {
    AppMethodBeat.i(28203);
    this.lCR = paramInt;
    Log.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(28203);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28207);
    init();
    reset();
    if (this.owr == null) {
      djg();
    }
    this.owr.a(this.lsF, true);
    l.kK(22, 10);
    Object localObject = m.gXj();
    if ((!TextUtils.isEmpty("key_shake_card_item")) && (((c)localObject).wrx.containsKey("key_shake_card_item"))) {}
    long l1;
    long l2;
    for (localObject = ((c)localObject).wrx.get("key_shake_card_item");; localObject = null)
    {
      l1 = System.currentTimeMillis() / 1000L;
      l2 = this.PzO;
      if ((localObject == null) || (!(localObject instanceof d))) {
        break;
      }
      localObject = (d)localObject;
      this.Pzt.a(1250, (d)localObject, 1L);
      m.gXj().z("key_shake_card_item", null);
      Log.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
      AppMethodBeat.o(28207);
      return;
    }
    int i;
    if (this.PzO == 0L) {
      i = 1;
    }
    while (i != 0) {
      if (this.PAk)
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
          com.tencent.mm.plugin.report.service.h.OAn.b(11666, new Object[] { Integer.valueOf(this.lCR) });
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28200);
              f.e(f.this).wuj = 3;
              f.a(f.this, f.e(f.this).wuj);
              f.e(f.this).PzU = m.gXj().PzP;
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
        if ((this.lsz == -85.0F) || (this.lsA == -1000.0F))
        {
          this.PAl = true;
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
        gXn();
      }
    }
    AppMethodBeat.o(28207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.shakecard.a.f
 * JD-Core Version:    0.7.0.1
 */