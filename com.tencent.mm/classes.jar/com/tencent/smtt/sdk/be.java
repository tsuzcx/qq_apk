package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.f.a.a.a;
import com.tencent.f.a.a.b;

class be
{
  private static be e = null;
  bh a = null;
  Context b;
  b c;
  a d;
  
  private be(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.a = new bh(this.b);
  }
  
  public static be a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new be(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  void a(Activity paramActivity, int paramInt)
  {
    this.a.a(paramActivity, paramInt);
  }
  
  public boolean a()
  {
    this.a.a();
    return this.a.b();
  }
  
  public boolean a(String paramString, Bundle paramBundle, b paramb)
  {
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
      if (!this.a.b()) {
        return false;
      }
      this.c = paramb;
      this.d = new bf(this);
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
      return true;
      localBundle.putInt("callMode", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.be
 * JD-Core Version:    0.7.0.1
 */