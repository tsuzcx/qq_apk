package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebsearch.Statics;
import com.tencent.image.URLImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class ShoppingView
  extends LinearLayout
{
  public static final int CASE_MARK_COLOR_BLUE = 1;
  public static final int CASE_MARK_COLOR_CYAN = 2;
  public static final int CASE_MARK_COLOR_ORANGE = 3;
  public static final int CASE_MARK_COLOR_PURPLE = 4;
  public static final String KEY_SHOPPING_COMMENT_COUNT = "ev_num";
  public static final String KEY_SHOPPING_COMMENT_RATE = "ev_rate";
  public static final String KEY_SHOPPING_MARK_COLOR = "type_color";
  public static final String KEY_SHOPPING_PRICE = "price";
  public static final String KEY_SHOPPING_TYPE_NAME = "type_name";
  TextView comment;
  URLImageView image;
  private Context mContext;
  TextView mark;
  TextView name;
  TextView priceText;
  View rootView;
  
  public ShoppingView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public ShoppingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public ShoppingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125836, null);
    this.name = ((TextView)localView.findViewById(2114453533));
    this.priceText = ((TextView)localView.findViewById(2114453534));
    this.comment = ((TextView)localView.findViewById(2114453535));
    this.image = ((URLImageView)localView.findViewById(2114453532));
    this.mark = ((TextView)localView.findViewById(2114453541));
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = -1;
    localView.setLayoutParams(localLayoutParams);
    this.rootView = localView;
  }
  
  public void setData(String paramString)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(this.mContext.getString(2114322443)).append(";");
      Object localObject2 = new JSONObject(paramString);
      String str3 = ((JSONObject)localObject2).optString("keyword");
      String str2 = ((JSONObject)localObject2).optString("name");
      Object localObject1 = Double.valueOf(((JSONObject)localObject2).optDouble("price"));
      int i = ((JSONObject)localObject2).optInt("ev_num");
      int j = ((JSONObject)localObject2).optInt("ev_rate");
      paramString = ((JSONObject)localObject2).optString("pic_url");
      String str1 = ((JSONObject)localObject2).optString("type_name");
      int k = ((JSONObject)localObject2).optInt("type_color", -1);
      if (((JSONObject)localObject2).optBoolean("clickable", false))
      {
        setBackgroundResource(2114060291);
        setClickable(true);
      }
      localObject2 = new HighlightModel(((JSONObject)localObject2).optJSONArray("highlight"), str3).getHighlightWords(str2);
      if (localObject2 != null)
      {
        this.name.setText((CharSequence)localObject2);
        localStringBuffer.append(str2).append(";");
      }
      if (((Double)localObject1).doubleValue() > 0.0D)
      {
        str2 = String.format("¥ %.2f", new Object[] { localObject1 });
        this.priceText.setText(str2);
        localStringBuffer.append(this.mContext.getString(2114322465, new Object[] { localObject1 })).append(";");
        this.priceText.setVisibility(0);
        localObject1 = this.mContext.getString(2114322436, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        this.comment.setText((CharSequence)localObject1);
        localStringBuffer.append(this.mContext.getString(2114322466, new Object[] { Integer.valueOf(i), Integer.valueOf(j) })).append(";");
        if (!TextUtils.isEmpty(str1))
        {
          this.mark.setVisibility(0);
          this.mark.setText(str1);
          switch (k)
          {
          }
        }
      }
      for (;;)
      {
        Statics.setImage(this.image, paramString, SearchViewBuilder.getImageWidthInPixels(this.mContext), SearchViewBuilder.getImageHeightInPixels(this.mContext));
        this.rootView.setContentDescription(localStringBuffer);
        return;
        this.priceText.setVisibility(8);
        break;
        this.mark.setBackgroundResource(2114060299);
        continue;
        this.mark.setBackgroundResource(2114060300);
        continue;
        this.mark.setBackgroundResource(2114060301);
        continue;
        this.mark.setBackgroundResource(2114060303);
      }
      return;
    }
    catch (JSONException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.ShoppingView
 * JD-Core Version:    0.7.0.1
 */