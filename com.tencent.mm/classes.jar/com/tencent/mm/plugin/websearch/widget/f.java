package com.tencent.mm.plugin.websearch.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.picker.CustomTimePickerNew;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends x
{
  Context context;
  
  public f(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(final String paramString1, final String paramString2, final t paramt)
  {
    AppMethodBeat.i(116650);
    MMHandlerThread.postToMainThread(new Runnable()
    {
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
            localObject13 = new JSONObject(paramString2);
            localBundle = new Bundle();
            str1 = paramString1;
            if (!paramString1.equals("date")) {
              break label903;
            }
            str1 = ((JSONObject)localObject13).optString("mode");
            i = -1;
            switch (str1.hashCode())
            {
            case 1191572447: 
              Log.i("MicroMsg.WebSearch.WxaShowPickerListenerImpl", "unknown mode %s", new Object[] { paramString1 });
              AppMethodBeat.o(116646);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            String str1;
            Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localJSONException, "", new Object[0]);
            AppMethodBeat.o(116646);
            return;
          }
          if (str1.equals("selector"))
          {
            i = 0;
            break label906;
            if (str1.equals("date"))
            {
              i = 1;
              break label906;
              if (str1.equals("time"))
              {
                i = 2;
                break label906;
                f.a(f.this, (JSONObject)localObject13, localBundle, paramt);
                AppMethodBeat.o(116646);
                return;
                Object localObject9 = f.this;
                Object localObject10 = paramt;
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
                          localObject13 = new com.tencent.mm.ui.widget.picker.a(((f)localObject9).context);
                          ((com.tencent.mm.ui.widget.picker.a)localObject13).agjU = new f.3((f)localObject9, (com.tencent.mm.ui.widget.picker.a)localObject13, (SimpleDateFormat)localObject12, localBundle, (t)localObject10);
                          if (localObject1 != null) {
                            ((com.tencent.mm.ui.widget.picker.a)localObject13).bC(((Date)localObject1).getYear() + 1900, ((Date)localObject1).getMonth() + 1, ((Date)localObject1).getDate());
                          }
                          if (localObject4 != null) {
                            ((com.tencent.mm.ui.widget.picker.a)localObject13).bD(((Date)localObject4).getYear() + 1900, ((Date)localObject4).getMonth() + 1, ((Date)localObject4).getDate());
                          }
                          if (localObject7 != null) {
                            ((com.tencent.mm.ui.widget.picker.a)localObject13).bE(((Date)localObject7).getYear() + 1900, ((Date)localObject7).getMonth() + 1, ((Date)localObject7).getDate());
                          }
                          if (!TextUtils.isEmpty((CharSequence)localObject11))
                          {
                            if (!((String)localObject11).equals("year")) {
                              break label556;
                            }
                            ((com.tencent.mm.ui.widget.picker.a)localObject13).bP(false, false);
                            if (((String)localObject11).equals("day")) {
                              ((com.tencent.mm.ui.widget.picker.a)localObject13).bP(true, true);
                            }
                          }
                          ((com.tencent.mm.ui.widget.picker.a)localObject13).show();
                          AppMethodBeat.o(116646);
                          return;
                          if (!"year".equals(localObject11)) {
                            break;
                          }
                          localObject1 = "yyyy";
                          break;
                          localParseException1 = localParseException1;
                          Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException1, "", new Object[0]);
                          localObject2 = null;
                          continue;
                          localParseException3 = localParseException3;
                          Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException3, "", new Object[0]);
                          localObject5 = null;
                        }
                      }
                      catch (ParseException localParseException5)
                      {
                        for (;;)
                        {
                          Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException5, "", new Object[0]);
                          localObject8 = null;
                          continue;
                          label556:
                          if (((String)localObject11).equals("month")) {
                            ((com.tencent.mm.ui.widget.picker.a)localObject13).bP(true, false);
                          }
                        }
                      }
                    }
                  }
                }
                localObject10 = f.this;
                localObject11 = paramt;
                Object localObject12 = new c(((f)localObject10).context);
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
                          int j;
                          Object localObject3;
                          Object localObject6;
                          Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException6, "", new Object[0]);
                        }
                      }
                      if (localObject2 != null)
                      {
                        i = ((Date)localObject2).getHours();
                        j = ((Date)localObject2).getMinutes();
                        if (((c)localObject12).agkl != null)
                        {
                          localObject2 = ((c)localObject12).agkl;
                          ((CustomTimePickerNew)localObject2).sqv = i;
                          ((CustomTimePickerNew)localObject2).sqw = j;
                        }
                      }
                      if (localObject5 != null)
                      {
                        i = ((Date)localObject5).getHours();
                        j = ((Date)localObject5).getMinutes();
                        if (((c)localObject12).agkl != null)
                        {
                          localObject2 = ((c)localObject12).agkl;
                          ((CustomTimePickerNew)localObject2).mMinTimeHour = i;
                          ((CustomTimePickerNew)localObject2).mMinTimeMinute = j;
                        }
                      }
                      if (localObject8 != null)
                      {
                        i = localObject8.getHours();
                        j = localObject8.getMinutes();
                        if (((c)localObject12).agkl != null)
                        {
                          localObject2 = ((c)localObject12).agkl;
                          ((CustomTimePickerNew)localObject2).mMaxTimeHour = i;
                          ((CustomTimePickerNew)localObject2).mMaxTimeMinute = j;
                        }
                      }
                      ((c)localObject12).agkm = new f.2((f)localObject10, (c)localObject12, localBundle, (t)localObject11);
                      if (((c)localObject12).Jjv != null)
                      {
                        if (((c)localObject12).agkl != null) {
                          ((c)localObject12).agkl.onShow();
                        }
                        ((c)localObject12).Jjv.show();
                      }
                      AppMethodBeat.o(116646);
                      return;
                      localParseException2 = localParseException2;
                      Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException2, "", new Object[0]);
                      localObject3 = null;
                    }
                  }
                  catch (ParseException localParseException4)
                  {
                    for (;;)
                    {
                      Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", localParseException4, "", new Object[0]);
                      localObject6 = null;
                    }
                  }
                }
                label903:
                continue;
              }
            }
          }
          label906:
          switch (i)
          {
          }
        }
      }
    });
    AppMethodBeat.o(116650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.f
 * JD-Core Version:    0.7.0.1
 */