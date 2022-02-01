package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.c.a.a;
import com.tencent.tbs.c.a.b;

class t
{
  private static t e = null;
  v a;
  Context b;
  b c;
  a d;
  
  private t(Context paramContext)
  {
    AppMethodBeat.i(55196);
    this.a = null;
    this.b = paramContext.getApplicationContext();
    this.a = new v(this.b);
    AppMethodBeat.o(55196);
  }
  
  public static t a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(188201);
      if (e == null) {
        e = new t(paramContext);
      }
      paramContext = e;
      AppMethodBeat.o(188201);
      return paramContext;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  void a(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(55201);
    this.a.a(paramActivity, paramInt);
    AppMethodBeat.o(55201);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(188203);
    this.a.a();
    boolean bool = this.a.b();
    AppMethodBeat.o(188203);
    return bool;
  }
  
  public boolean a(String paramString, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(188202);
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
        AppMethodBeat.o(188202);
        return false;
      }
      this.c = paramb;
      this.d = new a()
      {
        public void onUserStateChanged()
        {
          AppMethodBeat.i(188318);
          t.this.a.c();
          AppMethodBeat.o(188318);
        }
      };
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
      AppMethodBeat.o(188202);
      return true;
      localBundle.putInt("callMode", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.t
 * JD-Core Version:    0.7.0.1
 */