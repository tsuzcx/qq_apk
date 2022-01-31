package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.c.aav;
import com.tencent.mm.protocal.c.aaw;
import com.tencent.mm.protocal.c.ahp;
import com.tencent.mm.protocal.c.ahq;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  private static final m oKZ = new m();
  private Map<Long, String> cache = new HashMap();
  private d oLa = af.bDG();
  public com.tencent.mm.plugin.sns.storage.y oLb = af.bDH();
  public Map<String, String> oLc = new HashMap();
  
  private m()
  {
    HandlerThread localHandlerThread = e.aap("OpenCanvasMgr");
    localHandlerThread.start();
    new ah(localHandlerThread.getLooper()).postDelayed(new m.1(this), 5000L);
  }
  
  public static m bFY()
  {
    return oKZ;
  }
  
  public final String i(final long paramLong, int paramInt1, int paramInt2)
  {
    com.tencent.mm.sdk.platformtools.y.i("OpenCanvasMgr", "open pageId %d, preLoad %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    Object localObject2;
    if (paramLong <= 0L)
    {
      localObject2 = "";
      return localObject2;
    }
    Object localObject1 = "";
    if (paramInt2 != 1)
    {
      if (!this.cache.containsKey(Long.valueOf(paramLong))) {
        break label209;
      }
      localObject1 = (String)this.cache.get(Long.valueOf(paramLong));
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramInt1 != 1) {
        break;
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      localObject1 = new com.tencent.mm.plugin.sns.storage.c();
      ((com.tencent.mm.plugin.sns.storage.c)localObject1).field_canvasId = paramLong;
      localObject2 = new b.a();
      ((b.a)localObject2).ecH = new aav();
      ((b.a)localObject2).ecI = new aaw();
      ((b.a)localObject2).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
      ((b.a)localObject2).ecG = 1286;
      localObject2 = ((b.a)localObject2).Kt();
      ((aav)((b)localObject2).ecE.ecN).tat = paramLong;
      w.a((b)localObject2, new w.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, com.tencent.mm.ah.m paramAnonymousm)
        {
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            com.tencent.mm.sdk.platformtools.y.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.oLf), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
          do
          {
            return 0;
            paramAnonymousString = (aaw)paramAnonymousb.ecF.ecN;
            com.tencent.mm.sdk.platformtools.y.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(paramLong), paramAnonymousString.tau });
          } while (TextUtils.isEmpty(paramAnonymousString.tau));
          m.b(m.this).put(Long.valueOf(paramLong), paramAnonymousString.tau);
          this.oLg.field_canvasXml = paramAnonymousString.tau;
          m.c(m.this).a(this.oLg);
          return 0;
        }
      });
      return "";
      label209:
      localObject1 = new com.tencent.mm.plugin.sns.storage.c();
      ((com.tencent.mm.plugin.sns.storage.c)localObject1).field_canvasId = paramLong;
      this.oLa.b((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
      if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.c)localObject1).field_canvasXml))
      {
        this.cache.put(Long.valueOf(paramLong), ((com.tencent.mm.plugin.sns.storage.c)localObject1).field_canvasXml);
        localObject1 = ((com.tencent.mm.plugin.sns.storage.c)localObject1).field_canvasXml;
      }
      else
      {
        localObject1 = "";
      }
    }
  }
  
  public final String k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    com.tencent.mm.sdk.platformtools.y.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    Object localObject2;
    if (bk.bl(paramString1))
    {
      localObject2 = "";
      return localObject2;
    }
    Object localObject1 = "";
    if (paramInt2 != 1) {
      if (bk.bl(paramString2)) {
        break label338;
      }
    }
    label338:
    for (localObject1 = paramString1 + paramString2;; localObject1 = paramString1)
    {
      if (this.oLc.containsKey(localObject1)) {
        localObject1 = (String)this.oLc.get(localObject1);
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (paramInt1 != 1) {
          break;
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = new x();
        ((x)localObject1).field_canvasId = paramString1;
        localObject2 = new b.a();
        ((b.a)localObject2).ecH = new ahp();
        ((b.a)localObject2).ecI = new ahq();
        ((b.a)localObject2).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
        ((b.a)localObject2).ecG = 1890;
        localObject2 = ((b.a)localObject2).Kt();
        ahp localahp = (ahp)((b)localObject2).ecE.ecN;
        localahp.tfd = paramString1;
        localahp.tfe = paramString2;
        w.a((b)localObject2, new m.3(this, paramString1, paramInt1, (x)localObject1));
        return "";
        localObject2 = new x();
        ((x)localObject2).field_canvasId = paramString1;
        ((x)localObject2).field_canvasExt = paramString2;
        this.oLb.b((com.tencent.mm.sdk.e.c)localObject2, new String[] { "canvasId", "canvasExt" });
        if (!TextUtils.isEmpty(((x)localObject2).field_canvasXml))
        {
          this.oLc.put(localObject1, ((x)localObject2).field_canvasXml);
          localObject1 = ((x)localObject2).field_canvasXml;
        }
        else
        {
          localObject1 = "";
        }
      }
    }
  }
  
  public final void t(long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      this.cache.put(Long.valueOf(paramLong), paramString);
      com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
      localc.field_canvasId = paramLong;
      localc.field_canvasXml = paramString;
      this.oLa.a(localc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m
 * JD-Core Version:    0.7.0.1
 */