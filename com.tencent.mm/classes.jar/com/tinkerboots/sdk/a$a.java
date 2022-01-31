package com.tinkerboots.sdk;

import android.content.Context;
import com.tencent.tinker.lib.c.a;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;

public final class a$a
{
  public final ApplicationLike applicationLike;
  public final Context context;
  public com.tencent.tinker.lib.b.b wWk;
  public c wWl;
  public d wWm;
  public a xnH;
  public Class<? extends AbstractResultService> xnI;
  public com.tinkerboots.sdk.a.a.b xnJ;
  
  public a$a(ApplicationLike paramApplicationLike)
  {
    if (paramApplicationLike == null) {
      throw new TinkerRuntimeException("applicationLike must not be null.");
    }
    this.context = paramApplicationLike.getApplication();
    this.applicationLike = paramApplicationLike;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tinkerboots.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */