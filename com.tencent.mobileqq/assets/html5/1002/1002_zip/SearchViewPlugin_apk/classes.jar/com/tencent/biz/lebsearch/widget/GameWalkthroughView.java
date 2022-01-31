package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebsearch.Statics;
import org.json.JSONException;
import org.json.JSONObject;

public class GameWalkthroughView
  extends LinearLayout
{
  public static final String KEY_GAME_DESCRIPTION = "description";
  public static final String KEY_GAME_TYPE = "type";
  private Context mContext;
  private ImageView mImage;
  private View mRootView;
  private TextView mSecondLine;
  private TextView mTitle;
  private TextView mark;
  
  public GameWalkthroughView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public GameWalkthroughView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public GameWalkthroughView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125839, null);
    this.mTitle = ((TextView)localView.findViewById(2114453578));
    this.mImage = ((ImageView)localView.findViewById(2114453577));
    this.mSecondLine = ((TextView)localView.findViewById(2114453579));
    this.mark = ((TextView)localView.findViewById(2114453541));
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = -1;
    localView.setLayoutParams(localLayoutParams);
    this.mRootView = localView;
  }
  
  public void setData(String paramString)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Object localObject2 = new JSONObject(paramString);
      Object localObject1 = ((JSONObject)localObject2).optString("name");
      String str2 = ((JSONObject)localObject2).optString("keyword");
      paramString = ((JSONObject)localObject2).optString("pic_url");
      String str1 = ((JSONObject)localObject2).optString("description");
      if (((JSONObject)localObject2).optBoolean("clickable", false))
      {
        setBackgroundResource(2114060291);
        setClickable(true);
      }
      localObject2 = new HighlightModel(((JSONObject)localObject2).optJSONArray("highlight"), str2).getHighlightWords((String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.mTitle.setText((CharSequence)localObject2);
      }
      int i = SearchViewBuilder.getImageWidthInPixels(this.mContext);
      int j = SearchViewBuilder.getImageHeightInPixels(this.mContext);
      localStringBuffer.append(this.mContext.getString(2114322487, new Object[] { localObject1 })).append(";");
      localObject1 = SearchViewBuilder.getHighLightText(str1, str2);
      if (((SpannableString)localObject1).length() >= 0) {
        localStringBuffer.append(this.mContext.getString(2114322488, new Object[] { str1 })).append(";");
      }
      this.mSecondLine.setText((CharSequence)localObject1);
      Statics.setImage(this.mImage, paramString, i, j);
      Statics.dealTitleAndSecondText(this.mTitle, this.mSecondLine, (CharSequence)localObject2, this.mark);
      if (this.mark != null) {
        this.mark.setVisibility(8);
      }
      this.mRootView.setContentDescription(localStringBuffer.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.GameWalkthroughView
 * JD-Core Version:    0.7.0.1
 */