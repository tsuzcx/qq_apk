package com.tencent.mm.plugin.websearch.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayoutWithAll
  extends FTSMainUIEducationLayout
{
  public FTSMainUIEducationLayoutWithAll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FTSMainUIEducationLayoutWithAll(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void fa(String paramString, int paramInt)
  {
    AppMethodBeat.i(116568);
    LinearLayout localLinearLayout = (LinearLayout)inflate(getContext(), 2131494211, null);
    localLinearLayout.findViewById(2131305758).setOnClickListener(this.sDy);
    ((TextView)localLinearLayout.findViewById(2131305758)).setText(paramString);
    this.sGh.add(localLinearLayout);
    this.sGi.put(Integer.valueOf(paramInt), (TextView)localLinearLayout.findViewById(2131305758));
    addView(localLinearLayout);
    AppMethodBeat.o(116568);
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(116569);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(116569);
      return false;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("items");
    if (localJSONArray == null)
    {
      AppMethodBeat.o(116569);
      return false;
    }
    int i;
    int j;
    Object localObject2;
    Object localObject1;
    String str2;
    String str1;
    label74:
    JSONObject localJSONObject;
    if (ab.iC(ai.getContext()).equalsIgnoreCase("en"))
    {
      i = a.au(getContext(), 2131165197);
      j = 0;
      localObject2 = null;
      localObject1 = null;
      str2 = null;
      str1 = null;
      if (j >= localJSONArray.length()) {
        break label190;
      }
      localJSONObject = localJSONArray.optJSONObject(j);
      if (j % 3 != 0) {
        break label130;
      }
      str1 = localJSONObject.optString("hotword");
      localObject1 = localJSONObject;
    }
    for (;;)
    {
      j += 1;
      break label74;
      i = a.au(getContext(), 2131165517);
      break;
      label130:
      if (j % 3 == 1)
      {
        str2 = localJSONObject.optString("hotword");
        localObject2 = localJSONObject;
      }
      else
      {
        a(str1, localObject1, str2, localObject2, localJSONObject.optString("hotword"), localJSONObject, i);
        localObject2 = null;
        localObject1 = null;
        str2 = null;
        str1 = null;
      }
    }
    label190:
    if ((str1 != null) && (localObject1 != null)) {
      a(str1, localObject1, str2, localObject2, null, null, i);
    }
    paramJSONObject = paramJSONObject.optJSONArray("all");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      cLC();
    }
    for (;;)
    {
      AppMethodBeat.o(116569);
      return true;
      paramJSONObject = paramJSONObject.optJSONObject(0);
      fa(paramJSONObject.optString("hotword"), paramJSONObject.optInt("businessType"));
    }
  }
  
  public final void cLC()
  {
    AppMethodBeat.i(116567);
    String str1 = getContext().getResources().getString(2131762960);
    String str2 = getContext().getString(2131762960);
    Context localContext = getContext();
    int i = 0;
    if (str2.equals(localContext.getString(2131762938))) {
      i = 2;
    }
    for (;;)
    {
      fa(str1, i);
      AppMethodBeat.o(116567);
      return;
      if (str2.equals(localContext.getString(2131762942))) {
        i = 8;
      } else if (str2.equals(localContext.getString(2131762939))) {
        i = 1;
      } else {
        ac.i("MicroMsg.FTS.FTSMainUIEducationLayoutWithFull", "option " + str2 + " no type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.widget.FTSMainUIEducationLayoutWithAll
 * JD-Core Version:    0.7.0.1
 */