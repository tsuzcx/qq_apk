package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
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
  
  private void dK(String paramString, int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)inflate(getContext(), R.i.fts_main_ui_education_cell_layout_all, null);
    localLinearLayout.findViewById(R.h.textview_all).setOnClickListener(this.kCk);
    ((TextView)localLinearLayout.findViewById(R.h.textview_all)).setText(paramString);
    this.kEJ.add(localLinearLayout);
    this.kEK.put(Integer.valueOf(paramInt), (TextView)localLinearLayout.findViewById(R.h.textview_all));
    addView(localLinearLayout);
  }
  
  protected final boolean Q(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    JSONArray localJSONArray;
    do
    {
      return false;
      localJSONArray = paramJSONObject.optJSONArray("items");
    } while (localJSONArray == null);
    int i;
    int j;
    Object localObject2;
    Object localObject1;
    String str2;
    String str1;
    label58:
    JSONObject localJSONObject;
    if (x.fB(ae.getContext()).equalsIgnoreCase("en"))
    {
      i = com.tencent.mm.cb.a.aa(getContext(), R.f.BigerMoreTextSize);
      j = 0;
      localObject2 = null;
      localObject1 = null;
      str2 = null;
      str1 = null;
      if (j >= localJSONArray.length()) {
        break label175;
      }
      localJSONObject = localJSONArray.optJSONObject(j);
      if (j % 3 != 0) {
        break label115;
      }
      str1 = localJSONObject.optString("hotword");
      localObject1 = localJSONObject;
    }
    for (;;)
    {
      j += 1;
      break label58;
      i = com.tencent.mm.cb.a.aa(getContext(), R.f.NormalTextSize);
      break;
      label115:
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
    label175:
    if ((str1 != null) && (localObject1 != null)) {
      a(str1, localObject1, str2, localObject2, null, null, i);
    }
    paramJSONObject = paramJSONObject.optJSONArray("all");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      aWG();
    }
    for (;;)
    {
      return true;
      paramJSONObject = paramJSONObject.optJSONObject(0);
      dK(paramJSONObject.optString("hotword"), paramJSONObject.optInt("businessType"));
    }
  }
  
  protected final void aWG()
  {
    dK(getContext().getResources().getString(R.l.search_option_all), com.tencent.mm.bc.a.a(null, getContext().getString(R.l.search_option_all), getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll
 * JD-Core Version:    0.7.0.1
 */