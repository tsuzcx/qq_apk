package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/h5component/wheelpicker/WheelPickerCaller;", "", "()V", "TAG", "", "handleOpenWheelPicker", "", "context", "Landroid/content/Context;", "callbackId", "paramsJson", "Lorg/json/JSONObject;", "callbackInterface", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/h5component/IJsCallbackInterface;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b QTe;
  
  static
  {
    AppMethodBeat.i(307192);
    QTe = new b();
    AppMethodBeat.o(307192);
  }
  
  public static final void a(Context paramContext, String paramString, JSONObject paramJSONObject, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a.a parama)
  {
    AppMethodBeat.i(307167);
    s.u(paramContext, "context");
    s.u(paramString, "callbackId");
    s.u(paramJSONObject, "paramsJson");
    s.u(parama, "callbackInterface");
    if (!(paramContext instanceof Activity))
    {
      Log.w("WheelPickerCaller", "handleOpenWheelPicker error");
      AppMethodBeat.o(307167);
      return;
    }
    try
    {
      Object localObject2 = new JSONObject(paramJSONObject.optString("pickerParams"));
      Object localObject1 = ((JSONObject)localObject2).optString("title");
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = "";
      }
      localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.b)new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a.a(paramContext, a.bQ((JSONObject)localObject2));
      localObject2 = new j(paramContext, 1, 2);
      ((j)localObject2).d((CharSequence)paramContext.getString(b.j.app_cancel), (CharSequence)paramContext.getString(b.j.app_ok));
      ((j)localObject2).aFd(0);
      ((j)localObject2).a(new b..ExternalSyntheticLambda0(parama, paramString, (j)localObject2), new b..ExternalSyntheticLambda1((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.b)localObject1, parama, paramString, (j)localObject2));
      paramString = new LinearLayout(paramContext);
      parama = new TextView(paramContext);
      parama.setGravity(17);
      int i = com.tencent.mm.cd.a.br(paramContext, b.d.sns_ad_time_picker_title_text);
      parama.setText((CharSequence)paramJSONObject);
      aw.a((Paint)parama.getPaint(), 0.8F);
      parama.setTextColor(com.tencent.mm.cd.a.w(paramContext, b.c.dialog_msg_title_color));
      parama.setTextSize(0, i);
      paramString.addView((View)parama, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, com.tencent.mm.cd.a.bs(paramContext, b.d.sns_ad_picker_title_height)));
      paramString.setGravity(17);
      ((j)localObject2).setHeaderView((View)paramString);
      paramString = new RelativeLayout(paramContext);
      paramString.addView((View)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.b)localObject1).hkv(), -1, com.tencent.mm.cd.a.bs(paramContext, b.d.sns_ad_picker_height));
      ((j)localObject2).setCustomView((View)paramString);
      ((j)localObject2).dDn();
      AppMethodBeat.o(307167);
      return;
    }
    catch (Exception paramContext)
    {
      Log.w("WheelPickerCaller", "handleOpenWheelPicker error params");
      AppMethodBeat.o(307167);
    }
  }
  
  private static final void a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a.a parama, String paramString, j paramj)
  {
    AppMethodBeat.i(307173);
    s.u(parama, "$callbackInterface");
    s.u(paramString, "$callbackId");
    s.u(paramj, "$mHalfBottomDialog");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("ret", Integer.valueOf(-1));
    parama.h(paramString, "user canceled", (Map)localHashMap);
    paramj.cyW();
    AppMethodBeat.o(307173);
  }
  
  private static final void a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.b paramb, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a.a parama, String paramString, j paramj)
  {
    AppMethodBeat.i(307185);
    s.u(paramb, "$iPickerUserInterface");
    s.u(parama, "$callbackInterface");
    s.u(paramString, "$callbackId");
    s.u(paramj, "$mHalfBottomDialog");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("ret", Integer.valueOf(0));
    Object localObject;
    try
    {
      localObject = new JSONArray();
      paramb = paramb.hku().iterator();
      while (paramb.hasNext())
      {
        d locald = (d)paramb.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("k", locald.key);
        localJSONObject.put("v", locald.label);
        ((JSONArray)localObject).put(localJSONObject);
        continue;
        parama.h(paramString, "ok", (Map)localHashMap);
      }
    }
    catch (Exception paramb) {}
    for (;;)
    {
      paramj.cyW();
      AppMethodBeat.o(307185);
      return;
      ((Map)localHashMap).put("jsapi_callback_json_special_key", "result");
      paramb = (Map)localHashMap;
      localObject = ((JSONArray)localObject).toString();
      s.s(localObject, "ary.toString()");
      paramb.put("result", localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a.a.b
 * JD-Core Version:    0.7.0.1
 */