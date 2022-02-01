package com.unionpay;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.b;
import com.unionpay.utils.i;
import org.json.JSONArray;
import org.json.JSONObject;

final class c
  implements Handler.Callback
{
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(207295);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207295);
      return true;
      try
      {
        if (paramMessage.obj != null)
        {
          localObject = new JSONObject((String)paramMessage.obj);
          str2 = i.v((JSONObject)localObject, "sign");
        }
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          Object localObject;
          String str2;
          int i;
          label78:
          String str3;
          String str1;
        }
      }
      try
      {
        i = Integer.parseInt(a.a());
        str3 = new String(Base64.decode(((JSONObject)localObject).getString("configs"), 2));
        str1 = "";
        if (((JSONObject)localObject).has("sePayConf")) {
          str1 = new String(Base64.decode(((JSONObject)localObject).getString("sePayConf"), 2));
        }
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
        str1 = "";
        localObject = b.a(UPUtils.a(str3 + str1 + a.b()));
        str2 = UPUtils.forConfig(i, str2);
        if ((!TextUtils.isEmpty(str2)) && (str2.equals(localObject)))
        {
          UPUtils.a(a.kkx(), (String)paramMessage.obj, "configs" + a.d());
          UPUtils.a(a.kkx(), a.a(), "mode" + a.d());
          UPUtils.a(a.kkx(), a.b(), "or" + a.d());
          if (!TextUtils.isEmpty(a.e())) {
            UPUtils.a(a.kkx(), str1, "se_configs" + a.e());
          }
          if (!a.f())
          {
            a.ad(a.f(new JSONArray(str3), "sort"));
            a.b(str1);
          }
        }
        if (a.f()) {
          continue;
        }
        a.a(a.kkx(), a.g(), a.h());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        i = 0;
        break label78;
      }
      a.i();
      a.a(a.kkx(), a.g(), a.h());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.c
 * JD-Core Version:    0.7.0.1
 */