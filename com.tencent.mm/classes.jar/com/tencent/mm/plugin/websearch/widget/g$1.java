package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.NumberPicker;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.picker.CustomTimePicker;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.f;
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
    for (;;)
    {
      Object localObject13;
      Bundle localBundle;
      int i;
      try
      {
        localObject13 = new JSONObject(this.val$data);
        localBundle = new Bundle();
        str1 = this.qXk;
        if (!this.qXk.equals("date")) {
          break label954;
        }
        str1 = ((JSONObject)localObject13).optString("mode");
        i = -1;
        switch (str1.hashCode())
        {
        case 1191572447: 
          y.i("WxaShowPickerListenerImpl", "unknown mode %s", new Object[] { this.qXk });
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        String str1;
        y.printErrStackTrace("WxaShowPickerListenerImpl", localJSONException, "", new Object[0]);
        return;
      }
      if (str1.equals("selector"))
      {
        i = 0;
        break label957;
        if (str1.equals("date"))
        {
          i = 1;
          break label957;
          if (str1.equals("time"))
          {
            i = 2;
            break label957;
            g.a(this.qXm, (JSONObject)localObject13, localBundle, this.qXl);
            return;
            Object localObject9 = this.qXm;
            Object localObject10 = this.qXl;
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
                      ((a)localObject13).woo = new g.3((g)localObject9, (a)localObject13, (SimpleDateFormat)localObject12, localBundle, (t)localObject10);
                      if (localObject1 != null) {
                        ((a)localObject13).ao(((Date)localObject1).getYear() + 1900, ((Date)localObject1).getMonth() + 1, ((Date)localObject1).getDate());
                      }
                      if (localObject4 != null) {
                        ((a)localObject13).ap(((Date)localObject4).getYear() + 1900, ((Date)localObject4).getMonth() + 1, ((Date)localObject4).getDate());
                      }
                      if (localObject7 != null) {
                        ((a)localObject13).aq(((Date)localObject7).getYear() + 1900, ((Date)localObject7).getMonth() + 1, ((Date)localObject7).getDate());
                      }
                      if (!TextUtils.isEmpty((CharSequence)localObject11))
                      {
                        if (!((String)localObject11).equals("year")) {
                          break label532;
                        }
                        ((a)localObject13).Z(false, false);
                        if (((String)localObject11).equals("day")) {
                          ((a)localObject13).Z(true, true);
                        }
                      }
                      ((a)localObject13).show();
                      return;
                      if (!"year".equals(localObject11)) {
                        break;
                      }
                      localObject1 = "yyyy";
                      break;
                      localParseException1 = localParseException1;
                      y.printErrStackTrace("WxaShowPickerListenerImpl", localParseException1, "", new Object[0]);
                      localObject2 = null;
                      continue;
                      localParseException3 = localParseException3;
                      y.printErrStackTrace("WxaShowPickerListenerImpl", localParseException3, "", new Object[0]);
                      localObject5 = null;
                    }
                  }
                  catch (ParseException localParseException5)
                  {
                    for (;;)
                    {
                      y.printErrStackTrace("WxaShowPickerListenerImpl", localParseException5, "", new Object[0]);
                      localObject8 = null;
                      continue;
                      label532:
                      if (((String)localObject11).equals("month")) {
                        ((a)localObject13).Z(true, false);
                      }
                    }
                  }
                }
              }
            }
            localObject10 = this.qXm;
            localObject11 = this.qXl;
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
                      y.printErrStackTrace("WxaShowPickerListenerImpl", localParseException6, "", new Object[0]);
                    }
                  }
                  if (localObject2 != null)
                  {
                    i = ((Date)localObject2).getHours();
                    j = ((Date)localObject2).getMinutes();
                    if (((com.tencent.mm.ui.widget.picker.c)localObject12).wox != null)
                    {
                      localObject2 = ((com.tencent.mm.ui.widget.picker.c)localObject12).wox;
                      if ((f.ne(i)) && (f.nd(j)))
                      {
                        ((CustomTimePicker)localObject2).setCurrentHour(Integer.valueOf(i));
                        ((CustomTimePicker)localObject2).setCurrentMinute(Integer.valueOf(j));
                      }
                      ((CustomTimePicker)localObject2).asR();
                    }
                  }
                  if (localObject5 != null)
                  {
                    i = ((Date)localObject5).getHours();
                    j = ((Date)localObject5).getMinutes();
                    if (((com.tencent.mm.ui.widget.picker.c)localObject12).wox != null)
                    {
                      localObject2 = ((com.tencent.mm.ui.widget.picker.c)localObject12).wox;
                      ((CustomTimePicker)localObject2).gzX = i;
                      ((CustomTimePicker)localObject2).gzY = j;
                      if ((f.ne(((CustomTimePicker)localObject2).gzX)) && (((CustomTimePicker)localObject2).hAo != null)) {
                        ((CustomTimePicker)localObject2).hAo.setMinValue(((CustomTimePicker)localObject2).gzX);
                      }
                    }
                  }
                  if (localObject8 != null)
                  {
                    i = localObject8.getHours();
                    j = localObject8.getMinutes();
                    if (((com.tencent.mm.ui.widget.picker.c)localObject12).wox != null)
                    {
                      localObject2 = ((com.tencent.mm.ui.widget.picker.c)localObject12).wox;
                      ((CustomTimePicker)localObject2).gzZ = i;
                      ((CustomTimePicker)localObject2).gAa = j;
                      if ((f.ne(((CustomTimePicker)localObject2).gzZ)) && (((CustomTimePicker)localObject2).hAo != null)) {
                        ((CustomTimePicker)localObject2).hAo.setMaxValue(((CustomTimePicker)localObject2).gzZ);
                      }
                    }
                  }
                  ((com.tencent.mm.ui.widget.picker.c)localObject12).woy = new g.2((g)localObject10, (com.tencent.mm.ui.widget.picker.c)localObject12, localBundle, (t)localObject11);
                  if (((com.tencent.mm.ui.widget.picker.c)localObject12).vAB == null) {
                    return;
                  }
                  if (((com.tencent.mm.ui.widget.picker.c)localObject12).wox != null) {
                    ((com.tencent.mm.ui.widget.picker.c)localObject12).wox.asR();
                  }
                  ((com.tencent.mm.ui.widget.picker.c)localObject12).vAB.show();
                  return;
                  localParseException2 = localParseException2;
                  y.printErrStackTrace("WxaShowPickerListenerImpl", localParseException2, "", new Object[0]);
                  localObject3 = null;
                }
              }
              catch (ParseException localParseException4)
              {
                for (;;)
                {
                  y.printErrStackTrace("WxaShowPickerListenerImpl", localParseException4, "", new Object[0]);
                  localObject6 = null;
                }
              }
            }
            label954:
            continue;
          }
        }
      }
      label957:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.g.1
 * JD-Core Version:    0.7.0.1
 */