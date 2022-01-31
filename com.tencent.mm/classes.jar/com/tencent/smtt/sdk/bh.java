package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.g.a.a.a;
import com.tencent.g.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

class bh
{
  private static bh e = null;
  bk a;
  Context b;
  b c;
  a d;
  
  private bh(Context paramContext)
  {
    AppMethodBeat.i(64633);
    this.a = null;
    this.b = paramContext.getApplicationContext();
    this.a = new bk(this.b);
    AppMethodBeat.o(64633);
  }
  
  public static bh a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(139391);
      if (e == null) {
        e = new bh(paramContext);
      }
      paramContext = e;
      AppMethodBeat.o(139391);
      return paramContext;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  void a(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(64638);
    this.a.a(paramActivity, paramInt);
    AppMethodBeat.o(64638);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(139393);
    this.a.a();
    boolean bool = this.a.b();
    AppMethodBeat.o(139393);
    return bool;
  }
  
  public boolean a(String paramString, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(139392);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("videoUrl", paramString);
    }
    if (paramb != null)
    {
      this.a.a();
      if (!this.a.b())
      {
        AppMethodBeat.o(139392);
        return false;
      }
      this.c = paramb;
      this.d = new bi(this);
      localBundle.putInt("callMode", 3);
    }
    for (;;)
    {
      paramBundle = this.a;
      paramString = this;
      if (paramb == null) {
        paramString = null;
      }
      paramBundle.a(localBundle, paramString);
      AppMethodBeat.o(139392);
      return true;
      localBundle.putInt("callMode", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.bh
 * JD-Core Version:    0.7.0.1
 */