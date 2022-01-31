package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.walletlock.c.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.a;

public final class c
  implements com.tencent.mm.ah.f, d
{
  private String frT = null;
  boolean ndI = false;
  d.a qPe = null;
  private d.a qPf = null;
  private boolean qPg = false;
  
  static void fm(String paramString1, String paramString2)
  {
    paramString1 = new e(paramString1, paramString2);
    com.tencent.mm.kernel.g.Dk().a(paramString1, 0);
  }
  
  private void kQ(boolean paramBoolean)
  {
    y.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    if (this.qPg) {}
    for (Object localObject = null;; localObject = new g(this.frT))
    {
      a.a(local1, paramBoolean, 3, (com.tencent.soter.a.f.e)localObject, new com.tencent.mm.plugin.soter.b.f());
      return;
    }
  }
  
  public final void a(d.a parama, Bundle paramBundle)
  {
    this.frT = paramBundle.getString("key_pay_passwd");
    this.qPg = paramBundle.getBoolean("key_fp_lock_offline_mode");
    y.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[] { this.frT, Boolean.valueOf(this.qPg) });
    this.qPe = parama;
    this.ndI = false;
    com.tencent.mm.plugin.walletlock.c.g.qQZ.qRa = null;
    com.tencent.mm.plugin.walletlock.c.g.qQZ.qRb = null;
    com.tencent.mm.kernel.g.Dk().a(1967, this);
    com.tencent.mm.kernel.g.Dk().a(1548, this);
    if (this.qPg)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.walletlock.c.g.qQZ.qRa = String.valueOf(l);
      kQ(false);
    }
    do
    {
      return;
      parama = ae.cqS();
      if (parama != null) {
        break;
      }
    } while (this.qPe == null);
    this.qPe.ai(2, "system error");
    return;
    paramBundle = parama.getString("cpu_id", null);
    String str = parama.getString("uid", null);
    y.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[] { paramBundle, str });
    if ((bk.bl(paramBundle)) || (bk.bl(str)))
    {
      com.tencent.mm.plugin.soter.e.b.a(true, true, new c.2(this, parama));
      return;
    }
    fm(paramBundle, str);
  }
  
  public final void a(d.a parama, String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
    this.qPf = parama;
    com.tencent.mm.kernel.g.Dk().a(new f(paramString2, paramString3, paramString1), 0);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
    if (this.ndI) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramm instanceof e)) {
              break;
            }
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              paramString = (e)paramm;
              paramm = paramString.klM;
              com.tencent.mm.plugin.walletlock.c.g.qQZ.qRa = paramm;
              kQ(paramString.qPj);
              return;
            }
          } while (this.qPe == null);
          this.qPe.ai(7, "get challenge failed");
          return;
        } while (!(paramm instanceof f));
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        h.kU(true);
      } while (this.qPf == null);
      this.qPf.ai(0, "open touch lock ok");
      return;
      h.kU(false);
    } while (this.qPf == null);
    this.qPf.ai(6, "open touch lock failed");
  }
  
  public final void release()
  {
    y.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
    this.qPe = null;
    this.qPf = null;
    this.ndI = true;
    com.tencent.mm.kernel.g.Dk().b(1967, this);
    com.tencent.mm.kernel.g.Dk().b(1548, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c
 * JD-Core Version:    0.7.0.1
 */