package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebsearch.Statics;
import com.tencent.image.URLImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class EduView
  extends LinearLayout
{
  public static final int ITEM_TYPE_LIVE = 1;
  public static final int ITEM_TYPE_REC = 0;
  public static final String KEY_EDU_LIVE = "live";
  public static final String KEY_EDU_PEOPLE_COUNT = "people_num";
  public static final String KEY_EDU_PRICE = "price";
  TextView comment;
  ImageView coverView;
  URLImageView image;
  private Context mContext;
  TextView name;
  TextView priceText;
  View rootView;
  
  public EduView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public EduView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public EduView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125829, null);
    this.name = ((TextView)localView.findViewById(2114453533));
    this.priceText = ((TextView)localView.findViewById(2114453534));
    this.comment = ((TextView)localView.findViewById(2114453535));
    this.image = ((URLImageView)localView.findViewById(2114453532));
    this.coverView = ((ImageView)localView.findViewById(2114453517));
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
      localStringBuffer.append(this.mContext.getString(2114322448)).append(";");
      JSONObject localJSONObject = new JSONObject(paramString);
      Object localObject = localJSONObject.optString("keyword");
      String str1 = localJSONObject.optString("name");
      paramString = Double.valueOf(localJSONObject.optDouble("price"));
      int i = localJSONObject.optInt("people_num");
      int j = localJSONObject.optInt("live");
      String str2 = localJSONObject.optString("pic_url");
      if (localJSONObject.optBoolean("clickable", false))
      {
        setBackgroundResource(2114060291);
        setClickable(true);
      }
      localObject = new HighlightModel(localJSONObject.optJSONArray("highlight"), (String)localObject).getHighlightWords(str1);
      if (localObject != null)
      {
        this.name.setText((CharSequence)localObject);
        localStringBuffer.append(this.mContext.getString(2114322480, new Object[] { str1 })).append(";");
      }
      if (paramString.doubleValue() > 0.0D)
      {
        str1 = String.format("¥ %.2f", new Object[] { paramString });
        this.priceText.setText(str1);
        this.priceText.setTextColor(getResources().getColor(2114191360));
        localStringBuffer.append(this.mContext.getString(2114322481, new Object[] { paramString })).append(";");
      }
      for (;;)
      {
        this.comment.setText(paramString);
        localStringBuffer.append(paramString).append(";");
        Statics.setImage(this.image, str2, SearchViewBuilder.getImageWidthInPixels(this.mContext), SearchViewBuilder.getImageHeightInPixels(this.mContext));
        i = localJSONObject.optInt("video_or_music");
        Statics.dealWithCover(this.image, this.coverView, i);
        this.rootView.setContentDescription(localStringBuffer);
        return;
        paramString = getResources().getString(2114322482);
        this.priceText.setText(paramString);
        this.priceText.setTextColor(getResources().getColor(2114191361));
        localStringBuffer.append("价格:" + paramString).append(";");
        do
        {
          if (i < 10000)
          {
            paramString = "" + i;
            break label517;
          }
          paramString = i / 10000 + "万";
          break label517;
          paramString = this.mContext.getString(2114322483, new Object[] { paramString });
          break;
          paramString = this.mContext.getString(2114322484, new Object[] { paramString });
          break;
          str1 = "";
        } while (i >= 0);
        paramString = "0";
        label517:
        switch (j)
        {
        }
        paramString = str1;
      }
      return;
    }
    catch (JSONException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.EduView
 * JD-Core Version:    0.7.0.1
 */