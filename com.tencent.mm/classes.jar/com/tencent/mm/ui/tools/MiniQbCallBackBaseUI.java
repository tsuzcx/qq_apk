package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.f.a;
import org.json.JSONObject;

public class MiniQbCallBackBaseUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return -1;
  }
  
  protected String getTag()
  {
    return "MicroMsg.FilesFloatBall.MiniQbCallBackBaseUI";
  }
  
  protected void h(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(39075);
    ac.i(getTag(), "dealEvent() processName:%s appId:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(39075);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39074);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      ac.e(getTag(), "deal() getIntent() == null");
      finish();
      AppMethodBeat.o(39074);
      return;
    }
    ac.d(getTag(), "deal() %s %s", new Object[] { getIntent(), getIntent().getExtras() });
    String str1 = "";
    localObject5 = "";
    Object localObject3 = "";
    localObject2 = "";
    str3 = "";
    str2 = "";
    i = -1;
    localObject6 = localObject2;
    localObject1 = localObject3;
    paramBundle = str1;
    if (getIntent().hasExtra("thirdCtx"))
    {
      localObject5 = getIntent().getStringExtra("thirdCtx");
      localObject1 = localObject3;
      paramBundle = str1;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)localObject5);
      localObject1 = localObject3;
      paramBundle = str1;
      str1 = localJSONObject.getString("type");
      localObject1 = localObject3;
      paramBundle = str1;
      localObject6 = localJSONObject.getString("processName");
      localObject1 = localObject3;
      paramBundle = str1;
      localObject5 = localJSONObject.getString("appid");
      localObject1 = localObject5;
      paramBundle = str1;
      localObject3 = localJSONObject.getString("filePath");
      localObject2 = localObject3;
      paramBundle = str1;
      localObject3 = localObject6;
      localObject1 = localObject5;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.i(getTag(), "deal() thirdCtx Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        Object localObject4 = ai.getProcessName();
        continue;
        if (getIntent().hasExtra("menuId")) {
          i = getIntent().getIntExtra("menuId", -1);
        }
        localObject2 = str3;
        if (getIntent().hasExtra("activity_status")) {
          localObject2 = getIntent().getStringExtra("activity_status");
        }
        localObject4 = str2;
        if (getIntent().hasExtra("change_file")) {
          localObject4 = getIntent().getStringExtra("change_file");
        }
        ac.i(getTag(), "id:%s  activityStatus:%s  changeFileName:%s", new Object[] { Integer.valueOf(i), localObject2, localObject4 });
        if (bs.lr(paramBundle, "miniqb")) {
          h((String)localObject5, localObject1, i, (String)localObject6);
        } else {
          ac.e(getTag(), "deal() unknow source(type:%s)", new Object[] { paramBundle });
        }
      }
    }
    ac.i(getTag(), "deal() type:%s processName:%s appId:%s filePath:%s", new Object[] { paramBundle, localObject3, localObject1, localObject2 });
    localObject5 = localObject3;
    localObject6 = localObject2;
    if (!a.isFileExist((String)localObject6))
    {
      ac.e(getTag(), "deal() filePath not exitst");
      finish();
      AppMethodBeat.o(39074);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MiniQbCallBackBaseUI
 * JD-Core Version:    0.7.0.1
 */