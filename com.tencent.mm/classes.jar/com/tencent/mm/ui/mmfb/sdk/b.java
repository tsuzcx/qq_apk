package com.tencent.mm.ui.mmfb.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.b.a;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private Uri uri;
  
  public b(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(250203);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.uri = CustomTabLoginMethodHandler.f("m.facebook.com", "v8.0/dialog/".concat(String.valueOf(paramString)), localBundle);
    AppMethodBeat.o(250203);
  }
  
  public final boolean t(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(250210);
    Object localObject = new b.a((byte)0);
    if (((b.a)localObject).zm != null) {
      ((b.a)localObject).mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", ((b.a)localObject).zm);
    }
    if (((b.a)localObject).zo != null) {
      ((b.a)localObject).mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", ((b.a)localObject).zo);
    }
    ((b.a)localObject).mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", ((b.a)localObject).zp);
    localObject = new androidx.browser.customtabs.b(((b.a)localObject).mIntent, ((b.a)localObject).zn);
    ((androidx.browser.customtabs.b)localObject).intent.setPackage(paramString);
    ((androidx.browser.customtabs.b)localObject).intent.addFlags(1073741824);
    try
    {
      paramString = this.uri;
      ((androidx.browser.customtabs.b)localObject).intent.setData(paramString);
      a.a(paramActivity, ((androidx.browser.customtabs.b)localObject).intent, ((androidx.browser.customtabs.b)localObject).zl);
      AppMethodBeat.o(250210);
      return true;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      AppMethodBeat.o(250210);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.b
 * JD-Core Version:    0.7.0.1
 */