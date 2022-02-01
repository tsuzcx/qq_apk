package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.e.b.a;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.a;
import com.tencent.soter.a.f.e.b;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.i;

public final class l
  extends c
{
  e AWW = null;
  private e AWX = null;
  String Moe = null;
  private boolean Mpt = false;
  private boolean Mpw = false;
  private int mScene = -1;
  
  public l(int paramInt, e parame1, e parame2, boolean paramBoolean)
  {
    this.mScene = paramInt;
    this.AWW = parame1;
    this.Mpt = paramBoolean;
    this.Mpw = true;
    this.AWX = parame2;
  }
  
  private void fZL()
  {
    AppMethodBeat.i(126);
    hd(this.Moe, 1);
    b.a locala = new b.a().dk(this.Moe, this.Mpt);
    locala.Moh = new com.tencent.soter.a.e.a()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(120);
        d.w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", new Object[] { l.this.Moe, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        l.hd(l.this.Moe, 0);
        l.this.c(new com.tencent.soter.a.b.c(paramAnonymousInt, paramAnonymousString));
        AppMethodBeat.o(120);
      }
      
      public final void onSuccess()
      {
        AppMethodBeat.i(121);
        d.i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
        if (l.this.AWW != null) {
          l.hd(l.this.Moe, 2);
        }
        l locall;
        i locali;
        for (;;)
        {
          locall = l.this;
          locali = com.tencent.soter.core.a.baX(locall.Moe);
          if (locali != null) {
            break;
          }
          d.e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
          com.tencent.soter.core.a.dj(locall.Moe, false);
          locall.c(new com.tencent.soter.a.b.c(1006, "auth key model is null even after generation."));
          AppMethodBeat.o(121);
          return;
          l.hd(l.this.Moe, 0);
        }
        if (locall.AWW != null)
        {
          locall.AWW.setRequest(new e.a(locali.signature, locali.Mns));
          locall.AWW.a(new l.3(locall, locali));
          locall.AWW.execute();
          AppMethodBeat.o(121);
          return;
        }
        d.d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
        locall.c(new com.tencent.soter.a.b.c("treat as normal because you do not provide the net wrapper", locali));
        AppMethodBeat.o(121);
      }
    };
    locala.fZz().ha();
    AppMethodBeat.o(126);
  }
  
  final void execute()
  {
    AppMethodBeat.i(125);
    if ((!com.tencent.soter.core.a.fZc()) && (this.Mpw))
    {
      d.d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
      com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b() {}, false, this.AWX);
      AppMethodBeat.o(125);
      return;
    }
    fZL();
    AppMethodBeat.o(125);
  }
  
  @SuppressLint({"DefaultLocale"})
  final boolean fZB()
  {
    AppMethodBeat.i(123);
    if (!com.tencent.soter.a.c.b.fZv().isInit())
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
      c(new com.tencent.soter.a.b.c(1008));
      AppMethodBeat.o(123);
      return true;
    }
    if (!com.tencent.soter.a.c.b.fZv().fZr())
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
      c(new com.tencent.soter.a.b.c(2));
      AppMethodBeat.o(123);
      return true;
    }
    this.Moe = ((String)com.tencent.soter.a.c.b.fZv().fZx().get(this.mScene, ""));
    if (g.isNullOrNil(this.Moe))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
      c(new com.tencent.soter.a.b.c(1009, String.format("auth scene %d not initialized in map", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(123);
      return true;
    }
    boolean bool = com.tencent.soter.core.a.fZc();
    if ((!bool) && (com.tencent.soter.core.a.baV(this.Moe)))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
      com.tencent.soter.core.a.dj(this.Moe, false);
    }
    if ((!bool) && (!this.Mpw))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
      c(new com.tencent.soter.a.b.c(3));
      AppMethodBeat.o(123);
      return true;
    }
    if ((com.tencent.soter.core.a.baV(this.Moe)) && (!com.tencent.soter.core.a.baW(this.Moe)))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
      AppMethodBeat.o(123);
      return false;
    }
    if ((com.tencent.soter.core.a.baV(this.Moe)) && (!this.Mpt))
    {
      d.i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
      c(new com.tencent.soter.a.b.c(com.tencent.soter.core.a.baX(this.Moe)));
      AppMethodBeat.o(123);
      return true;
    }
    if (this.AWW == null) {
      d.w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
    }
    AppMethodBeat.o(123);
    return false;
  }
  
  final void fZC()
  {
    AppMethodBeat.i(124);
    d.w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", new Object[] { this.Moe });
    com.tencent.soter.core.a.dj(this.Moe, false);
    AppMethodBeat.o(124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.l
 * JD-Core Version:    0.7.0.1
 */