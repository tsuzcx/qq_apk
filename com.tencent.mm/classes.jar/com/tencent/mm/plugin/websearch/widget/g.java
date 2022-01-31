package com.tencent.mm.plugin.websearch.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.widget.picker.CustomTimePicker;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends y
{
  Context context;
  
  public g(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(final String paramString1, final String paramString2, final t paramt)
  {
    AppMethodBeat.i(91455);
    al.d(new Runnable()
    {
      public final void run()
      {
        Object localObject7 = null;
        AppMethodBeat.i(91451);
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
              break label983;
            }
            str1 = ((JSONObject)localObject13).optString("mode");
            i = -1;
            switch (str1.hashCode())
            {
            case 1191572447: 
              ab.i("WxaShowPickerListenerImpl", "unknown mode %s", new Object[] { paramString1 });
              AppMethodBeat.o(91451);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            String str1;
            ab.printErrStackTrace("WxaShowPickerListenerImpl", localJSONException, "", new Object[0]);
            AppMethodBeat.o(91451);
            return;
          }
          if (str1.equals("selector"))
          {
            i = 0;
            break label986;
            if (str1.equals("date"))
            {
              i = 1;
              break label986;
              if (str1.equals("time"))
              {
                i = 2;
                break label986;
                g.a(g.this, (JSONObject)localObject13, localBundle, paramt);
                AppMethodBeat.o(91451);
                return;
                Object localObject9 = g.this;
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
                          localObject13 = new a(((g)localObject9).context);
                          ((a)localObject13).AIQ = new g.3((g)localObject9, (a)localObject13, (SimpleDateFormat)localObject12, localBundle, (t)localObject10);
                          if (localObject1 != null) {
                            ((a)localObject13).aA(((Date)localObject1).getYear() + 1900, ((Date)localObject1).getMonth() + 1, ((Date)localObject1).getDate());
                          }
                          if (localObject4 != null) {
                            ((a)localObject13).aB(((Date)localObject4).getYear() + 1900, ((Date)localObject4).getMonth() + 1, ((Date)localObject4).getDate());
                          }
                          if (localObject7 != null) {
                            ((a)localObject13).aC(((Date)localObject7).getYear() + 1900, ((Date)localObject7).getMonth() + 1, ((Date)localObject7).getDate());
                          }
                          if (!TextUtils.isEmpty((CharSequence)localObject11))
                          {
                            if (!((String)localObject11).equals("year")) {
                              break label556;
                            }
                            ((a)localObject13).am(false, false);
                            if (((String)localObject11).equals("day")) {
                              ((a)localObject13).am(true, true);
                            }
                          }
                          ((a)localObject13).show();
                          AppMethodBeat.o(91451);
                          return;
                          if (!"year".equals(localObject11)) {
                            break;
                          }
                          localObject1 = "yyyy";
                          break;
                          localParseException1 = localParseException1;
                          ab.printErrStackTrace("WxaShowPickerListenerImpl", localParseException1, "", new Object[0]);
                          localObject2 = null;
                          continue;
                          localParseException3 = localParseException3;
                          ab.printErrStackTrace("WxaShowPickerListenerImpl", localParseException3, "", new Object[0]);
                          localObject5 = null;
                        }
                      }
                      catch (ParseException localParseException5)
                      {
                        for (;;)
                        {
                          ab.printErrStackTrace("WxaShowPickerListenerImpl", localParseException5, "", new Object[0]);
                          localObject8 = null;
                          continue;
                          label556:
                          if (((String)localObject11).equals("month")) {
                            ((a)localObject13).am(true, false);
                          }
                        }
                      }
                    }
                  }
                }
                localObject10 = g.this;
                localObject11 = paramt;
                Object localObject12 = new com.tencent.mm.ui.widget.picker.c(((g)localObject10).context);
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
                          ab.printErrStackTrace("WxaShowPickerListenerImpl", localParseException6, "", new Object[0]);
                        }
                      }
                      if (localObject2 != null)
                      {
                        i = ((Date)localObject2).getHours();
                        j = ((Date)localObject2).getMinutes();
                        if (((com.tencent.mm.ui.widget.picker.c)localObject12).AIY != null)
                        {
                          localObject2 = ((com.tencent.mm.ui.widget.picker.c)localObject12).AIY;
                          if ((f.qL(i)) && (f.qK(j)))
                          {
                            ((CustomTimePicker)localObject2).setCurrentHour(Integer.valueOf(i));
                            ((CustomTimePicker)localObject2).setCurrentMinute(Integer.valueOf(j));
                          }
                          ((CustomTimePicker)localObject2).aRT();
                        }
                      }
                      if (localObject5 != null)
                      {
                        i = ((Date)localObject5).getHours();
                        j = ((Date)localObject5).getMinutes();
                        if (((com.tencent.mm.ui.widget.picker.c)localObject12).AIY != null)
                        {
                          localObject2 = ((com.tencent.mm.ui.widget.picker.c)localObject12).AIY;
                          ((CustomTimePicker)localObject2).hWY = i;
                          ((CustomTimePicker)localObject2).hWZ = j;
                          if ((f.qL(((CustomTimePicker)localObject2).hWY)) && (((CustomTimePicker)localObject2).jsD != null)) {
                            ((CustomTimePicker)localObject2).jsD.setMinValue(((CustomTimePicker)localObject2).hWY);
                          }
                        }
                      }
                      if (localObject8 != null)
                      {
                        i = localObject8.getHours();
                        j = localObject8.getMinutes();
                        if (((com.tencent.mm.ui.widget.picker.c)localObject12).AIY != null)
                        {
                          localObject2 = ((com.tencent.mm.ui.widget.picker.c)localObject12).AIY;
                          ((CustomTimePicker)localObject2).hXa = i;
                          ((CustomTimePicker)localObject2).hXb = j;
                          if ((f.qL(((CustomTimePicker)localObject2).hXa)) && (((CustomTimePicker)localObject2).jsD != null)) {
                            ((CustomTimePicker)localObject2).jsD.setMaxValue(((CustomTimePicker)localObject2).hXa);
                          }
                        }
                      }
                      ((com.tencent.mm.ui.widget.picker.c)localObject12).AIZ = new g.2((g)localObject10, (com.tencent.mm.ui.widget.picker.c)localObject12, localBundle, (t)localObject11);
                      if (((com.tencent.mm.ui.widget.picker.c)localObject12).zRa != null)
                      {
                        if (((com.tencent.mm.ui.widget.picker.c)localObject12).AIY != null) {
                          ((com.tencent.mm.ui.widget.picker.c)localObject12).AIY.aRT();
                        }
                        ((com.tencent.mm.ui.widget.picker.c)localObject12).zRa.show();
                      }
                      AppMethodBeat.o(91451);
                      return;
                      localParseException2 = localParseException2;
                      ab.printErrStackTrace("WxaShowPickerListenerImpl", localParseException2, "", new Object[0]);
                      localObject3 = null;
                    }
                  }
                  catch (ParseException localParseException4)
                  {
                    for (;;)
                    {
                      ab.printErrStackTrace("WxaShowPickerListenerImpl", localParseException4, "", new Object[0]);
                      localObject6 = null;
                    }
                  }
                }
                label983:
                continue;
              }
            }
          }
          label986:
          switch (i)
          {
          }
        }
      }
    });
    AppMethodBeat.o(91455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.g
 * JD-Core Version:    0.7.0.1
 */