package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
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
  
  private void eU(String paramString, int paramInt)
  {
    AppMethodBeat.i(91588);
    LinearLayout localLinearLayout = (LinearLayout)inflate(getContext(), 2130969668, null);
    localLinearLayout.findViewById(2131824376).setOnClickListener(this.mYg);
    ((TextView)localLinearLayout.findViewById(2131824376)).setText(paramString);
    this.nbh.add(localLinearLayout);
    this.nbi.put(Integer.valueOf(paramInt), (TextView)localLinearLayout.findViewById(2131824376));
    addView(localLinearLayout);
    AppMethodBeat.o(91588);
  }
  
  public final boolean ab(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(91589);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(91589);
      return false;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("items");
    if (localJSONArray == null)
    {
      AppMethodBeat.o(91589);
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
    if (aa.gP(ah.getContext()).equalsIgnoreCase("en"))
    {
      i = com.tencent.mm.cb.a.ao(getContext(), 2131427504);
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
      i = com.tencent.mm.cb.a.ao(getContext(), 2131427809);
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
      bDn();
    }
    for (;;)
    {
      AppMethodBeat.o(91589);
      return true;
      paramJSONObject = paramJSONObject.optJSONObject(0);
      eU(paramJSONObject.optString("hotword"), paramJSONObject.optInt("businessType"));
    }
  }
  
  public final void bDn()
  {
    AppMethodBeat.i(91587);
    eU(getContext().getResources().getString(2131303018), com.tencent.mm.bd.a.a(null, getContext().getString(2131303018), getContext()));
    AppMethodBeat.o(91587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll
 * JD-Core Version:    0.7.0.1
 */