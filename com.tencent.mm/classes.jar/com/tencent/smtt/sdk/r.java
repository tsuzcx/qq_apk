package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.c.a.a;
import com.tencent.tbs.c.a.b;

class r
{
  private static r e = null;
  t a;
  Context b;
  b c;
  a d;
  
  private r(Context paramContext)
  {
    AppMethodBeat.i(55175);
    this.a = null;
    this.b = paramContext.getApplicationContext();
    this.a = new t(this.b);
    AppMethodBeat.o(55175);
  }
  
  public static r a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(55174);
      if (e == null) {
        e = new r(paramContext);
      }
      paramContext = e;
      AppMethodBeat.o(55174);
      return paramContext;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  void a(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(55177);
    this.a.a(paramActivity, paramInt);
    AppMethodBeat.o(55177);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(55178);
    this.a.a();
    boolean bool = this.a.b();
    AppMethodBeat.o(55178);
    return bool;
  }
  
  public boolean a(String paramString, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(55176);
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
        AppMethodBeat.o(55176);
        return false;
      }
      this.c = paramb;
      this.d = new a()
      {
        public void onUserStateChanged()
        {
          AppMethodBeat.i(54612);
          r.this.a.c();
          AppMethodBeat.o(54612);
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
      AppMethodBeat.o(55176);
      return true;
      localBundle.putInt("callMode", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.r
 * JD-Core Version:    0.7.0.1
 */