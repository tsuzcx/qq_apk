package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.d;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

final class g$1
  implements Runnable
{
  g$1(g paramg, String paramString1, String paramString2, t paramt) {}
  
  public final void run()
  {
    Object localObject7 = null;
    AppMethodBeat.i(116646);
    for (;;)
    {
      Object localObject13;
      Bundle localBundle;
      int i;
      try
      {
        localObject13 = new JSONObject(this.val$data);
        localBundle = new Bundle();
        str1 = this.Cbx;
        if (!this.Cbx.equals("date")) {
          break label794;
        }
        str1 = ((JSONObject)localObject13).optString("mode");
        i = -1;
        switch (str1.hashCode())
        {
        case 1191572447: 
          ac.i("MicroMsg.WebSearch.WxaShowPickerListenerImpl", "unknown mode %s", new Object[] { this.Cbx });
          AppMethodBeat.o(116646);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        String str1;
        ac.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localJSONException, "", new Object[0]);
        AppMethodBeat.o(116646);
        return;
      }
      if (str1.equals("selector"))
      {
        i = 0;
        break label797;
        if (str1.equals("date"))
        {
          i = 1;
          break label797;
          if (str1.equals("time"))
          {
            i = 2;
            break label797;
            g.a(this.Cbz, (JSONObject)localObject13, localBundle, this.Cby);
            AppMethodBeat.o(116646);
            return;
            Object localObject9 = this.Cbz;
            Object localObject10 = this.Cby;
            String str2 = ((JSONObject)localObject13).optString("value");
            Object localObject4 = ((JSONObject)localObject13).optString("start");
            localObject7 = ((JSONObject)localObject13).optString("end");
            Object localObject11 = ((JSONObject)localObject13).optString("fields");
            Object localObject1 = "yyyy-MM-dd";
            if ("month".equals(localObject11)) {
              localObject1 = "yyyy-MM";
            }
            Object localObject8;
            for (;;)
            {
              localObject12 = new SimpleDateFormat((String)localObject1);
              try
              {
                localObject1 = ((SimpleDateFormat)localObject12).parse(str2);
              }
              catch (ParseException localParseException3)
              {
                try
                {
                  localObject4 = ((SimpleDateFormat)localObject12).parse((String)localObject4);
                }
                catch (ParseException localParseException3)
                {
                  try
                  {
                    for (;;)
                    {
                      localObject7 = ((SimpleDateFormat)localObject12).parse((String)localObject7);
                      localObject13 = new b(((g)localObject9).context);
                      ((b)localObject13).Jjn = new g.3((g)localObject9, (b)localObject13, (SimpleDateFormat)localObject12, localBundle, (t)localObject10);
                      if (localObject1 != null) {
                        ((b)localObject13).aO(((Date)localObject1).getYear() + 1900, ((Date)localObject1).getMonth() + 1, ((Date)localObject1).getDate());
                      }
                      if (localObject4 != null) {
                        ((b)localObject13).aP(((Date)localObject4).getYear() + 1900, ((Date)localObject4).getMonth() + 1, ((Date)localObject4).getDate());
                      }
                      if (localObject7 != null) {
                        ((b)localObject13).aQ(((Date)localObject7).getYear() + 1900, ((Date)localObject7).getMonth() + 1, ((Date)localObject7).getDate());
                      }
                      if (!TextUtils.isEmpty((CharSequence)localObject11))
                      {
                        if (!((String)localObject11).equals("year")) {
                          break label546;
                        }
                        ((b)localObject13).aP(false, false);
                        if (((String)localObject11).equals("day")) {
                          ((b)localObject13).aP(true, true);
                        }
                      }
                      ((b)localObject13).show();
                      AppMethodBeat.o(116646);
                      return;
                      if (!"year".equals(localObject11)) {
                        break;
                      }
                      localObject1 = "yyyy";
                      break;
                      localParseException1 = localParseException1;
                      ac.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException1, "", new Object[0]);
                      localObject2 = null;
                      continue;
                      localParseException3 = localParseException3;
                      ac.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException3, "", new Object[0]);
                      localObject5 = null;
                    }
                  }
                  catch (ParseException localParseException5)
                  {
                    for (;;)
                    {
                      ac.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException5, "", new Object[0]);
                      localObject8 = null;
                      continue;
                      label546:
                      if (((String)localObject11).equals("month")) {
                        ((b)localObject13).aP(true, false);
                      }
                    }
                  }
                }
              }
            }
            localObject10 = this.Cbz;
            localObject11 = this.Cby;
            Object localObject12 = new d(((g)localObject10).context);
            Object localObject2 = ((JSONObject)localObject13).optString("value");
            Object localObject5 = ((JSONObject)localObject13).optString("start");
            localObject9 = ((JSONObject)localObject13).optString("end");
            localObject13 = new SimpleDateFormat("hh:mm");
            try
            {
              localObject2 = ((SimpleDateFormat)localObject13).parse((String)localObject2);
            }
            catch (ParseException localParseException2)
            {
              try
              {
                for (;;)
                {
                  localObject5 = ((SimpleDateFormat)localObject13).parse((String)localObject5);
                  try
                  {
                    localObject9 = ((SimpleDateFormat)localObject13).parse((String)localObject9);
                    localObject8 = localObject9;
                  }
                  catch (ParseException localParseException6)
                  {
                    for (;;)
                    {
                      Object localObject3;
                      Object localObject6;
                      ac.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException6, "", new Object[0]);
                    }
                  }
                  if (localObject2 != null) {
                    ((d)localObject12).jY(((Date)localObject2).getHours(), ((Date)localObject2).getMinutes());
                  }
                  if (localObject5 != null) {
                    ((d)localObject12).setMinTime(((Date)localObject5).getHours(), ((Date)localObject5).getMinutes());
                  }
                  if (localObject8 != null) {
                    ((d)localObject12).setMaxTime(localObject8.getHours(), localObject8.getMinutes());
                  }
                  ((d)localObject12).Jjz = new g.2((g)localObject10, (d)localObject12, localBundle, (t)localObject11);
                  ((d)localObject12).show();
                  AppMethodBeat.o(116646);
                  return;
                  localParseException2 = localParseException2;
                  ac.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException2, "", new Object[0]);
                  localObject3 = null;
                }
              }
              catch (ParseException localParseException4)
              {
                for (;;)
                {
                  ac.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException4, "", new Object[0]);
                  localObject6 = null;
                }
              }
            }
            label794:
            continue;
          }
        }
      }
      label797:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.g.1
 * JD-Core Version:    0.7.0.1
 */