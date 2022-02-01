package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(7)
public class LuggageStubUI
  extends MMActivity
  implements a.a, MMActivity.a
{
  private void atF(int paramInt)
  {
    AppMethodBeat.i(295864);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.ACTION_LOCATION_FROM_JSAPI");
    localIntent.putExtra("key_permission_request_code", getIntent().getIntExtra("key_permission_request_code", 0));
    localIntent.putExtra("key_result_code", paramInt);
    MMApplicationContext.getContext().sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
    finish();
    AppMethodBeat.o(295864);
  }
  
  public static boolean f(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(295862);
    if (paramContext == null)
    {
      AppMethodBeat.o(295862);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (androidx.core.content.a.checkSelfPermission(paramContext, str) != 0) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(295862);
      return false;
    }
    paramArrayOfString = new Intent();
    if (!(paramContext instanceof Activity)) {
      paramArrayOfString.addFlags(268435456);
    }
    paramArrayOfString.putExtra("key_action_code", 1);
    paramArrayOfString.putExtra("key_permission_types", (String[])localArrayList.toArray(new String[localArrayList.size()]));
    paramArrayOfString.putExtra("key_permission_request_code", 75);
    c.b(paramContext, "webview", ".luggage.LuggageStubUI", paramArrayOfString);
    AppMethodBeat.o(295862);
    return true;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(295870);
    atF(0);
    AppMethodBeat.o(295870);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(295867);
    super.onCreate(paramBundle);
    switch (getIntent().getIntExtra("key_action_code", -1))
    {
    default: 
      finish();
      AppMethodBeat.o(295867);
      return;
    }
    androidx.core.app.a.a(this, getIntent().getStringArrayExtra("key_permission_types"), getIntent().getIntExtra("key_permission_request_code", 0));
    AppMethodBeat.o(295867);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(295871);
    switch (paramInt)
    {
    default: 
      atF(0);
      AppMethodBeat.o(295871);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      atF(-1);
      AppMethodBeat.o(295871);
      return;
    }
    atF(0);
    AppMethodBeat.o(295871);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.LuggageStubUI
 * JD-Core Version:    0.7.0.1
 */