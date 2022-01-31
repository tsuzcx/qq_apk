package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebsearch.Statics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TongChengView
  extends LinearLayout
{
  public static final String KEY_AREA = "area";
  public static final String KEY_MARK = "mark";
  public static final String KEY_ORDERSUM = "ordersum";
  public static final String KEY_PRICE = "price";
  public static final String KEY_SCORE = "score";
  public static final String KEY_TITLE = "title";
  public static final String KEY_TYPE = "type";
  public static final int TYPE_CAR = 7;
  public static final int TYPE_HOUSE = 3;
  public static final int TYPE_HOUSEKEEPING = 8;
  public static final int TYPE_JOB = 2;
  public static final int TYPE_JOB_FULL = 1;
  public static final int TYPE_PET = 5;
  public static final int TYPE_RENT = 4;
  public static final int TYPE_SECOND = 6;
  private TextView addressView;
  private int failDrawableId;
  private ImageView iconView;
  private Context mContext;
  private int markResourceId;
  private TextView markView;
  private TextView orderView;
  private TextView priceView;
  View rootView;
  private LinearLayout starLayout;
  private TextView titleView;
  
  public TongChengView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public TongChengView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public TongChengView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void checkAndSet(TextView paramTextView, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.trim();
    }
    paramTextView.setText(str);
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125837, null);
    this.iconView = ((ImageView)localView.findViewById(2114453563));
    this.titleView = ((TextView)localView.findViewById(2114453565));
    this.markView = ((TextView)localView.findViewById(2114453566));
    this.priceView = ((TextView)localView.findViewById(2114453567));
    this.addressView = ((TextView)localView.findViewById(2114453570));
    this.orderView = ((TextView)localView.findViewById(2114453569));
    this.starLayout = ((LinearLayout)localView.findViewById(2114453506));
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = -1;
    localView.setLayoutParams(localLayoutParams);
    this.rootView = localView;
  }
  
  private void initResourceByType(int paramInt)
  {
    this.markResourceId = 2114060301;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      this.markResourceId = 2114060301;
      return;
    case 1: 
      this.markResourceId = 2114060301;
      return;
    case 4: 
      this.markResourceId = 2114060300;
      return;
    case 5: 
      this.markResourceId = 2114060304;
      return;
    case 6: 
      this.markResourceId = 2114060302;
      return;
    case 7: 
      this.markResourceId = 2114060298;
      return;
    }
    this.markResourceId = 2114060303;
  }
  
  public void setData(String paramString)
  {
    this.priceView.setVisibility(8);
    this.starLayout.setVisibility(0);
    for (;;)
    {
      StringBuffer localStringBuffer;
      JSONObject localJSONObject;
      try
      {
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(this.mContext.getString(2114322451)).append(";");
        localJSONObject = new JSONObject(paramString);
        Object localObject = localJSONObject.optString("name");
        String str = localJSONObject.optString("keyword");
        paramString = (String)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramString = ((String)localObject).trim();
          localStringBuffer.append(paramString).append(";");
        }
        localObject = localJSONObject.optJSONArray("highlight");
        SearchViewBuilder.bindText(this.titleView, paramString, (JSONArray)localObject, str);
        if (localJSONObject.optBoolean("clickable", false))
        {
          setBackgroundResource(2114060291);
          setClickable(true);
        }
        checkAndSet(this.markView, localJSONObject.optString("mark"));
        localStringBuffer.append(localJSONObject.optString("mark")).append(";");
        i = localJSONObject.optInt("type");
        initResourceByType(i);
        this.markView.setBackgroundResource(this.markResourceId);
        Statics.setImage(this.iconView, localJSONObject.optString("pic_url"), SearchViewBuilder.getImageWidthInPixels(this.mContext), SearchViewBuilder.getImageHeightInPixels(this.mContext), this.failDrawableId);
        switch (i)
        {
        case 1: 
          this.rootView.setContentDescription(localStringBuffer);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      this.starLayout.setVisibility(8);
      this.priceView.setVisibility(0);
      checkAndSet(this.priceView, localJSONObject.optString("price"));
      checkAndSet(this.addressView, localJSONObject.optString("area"));
      localStringBuffer.append(this.priceView).append(";");
      localStringBuffer.append(this.addressView).append(";");
      continue;
      this.priceView.setVisibility(8);
      double d = localJSONObject.optDouble("score", -1.0D);
      int i = 0;
      if (d != -1.0D)
      {
        this.starLayout.setVisibility(0);
        SearchViewBuilder.setStars(this.starLayout, d);
        localStringBuffer.append(this.mContext.getString(2114322454, new Object[] { Double.valueOf(d) })).append(";");
        label459:
        paramString = localJSONObject.optString("ordersum");
        if (!TextUtils.isEmpty(paramString)) {
          break label551;
        }
      }
      label551:
      for (paramString = "0人预约";; paramString = paramString + "人预约")
      {
        if (i != 0) {
          new StringBuilder().append("暂无评分，").append(paramString).toString();
        }
        paramString = localJSONObject.optString("area");
        checkAndSet(this.addressView, paramString);
        localStringBuffer.append(paramString).append(";");
        break;
        this.starLayout.setVisibility(8);
        i = 1;
        break label459;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.TongChengView
 * JD-Core Version:    0.7.0.1
 */