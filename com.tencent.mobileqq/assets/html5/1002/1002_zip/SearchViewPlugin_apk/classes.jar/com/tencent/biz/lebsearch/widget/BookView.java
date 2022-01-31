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
import com.tencent.biz.lebsearch.util.PatternUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class BookView
  extends LinearLayout
{
  public static final String KEY_BOOK_AUTHOR = "auth";
  public static final String KEY_BOOK_DETAIL = "brief";
  public static final String KEY_BOOK_TYPE = "cate";
  TextView bookDetailText;
  ImageView bookImage;
  TextView bookNameText;
  TextView bookTypeAndAuthorText;
  private Context mContext;
  View rootView;
  
  public BookView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public BookView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public BookView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125835, null);
    this.bookNameText = ((TextView)localView.findViewById(2114453560));
    this.bookTypeAndAuthorText = ((TextView)localView.findViewById(2114453562));
    this.bookDetailText = ((TextView)localView.findViewById(2114453561));
    this.bookImage = ((ImageView)localView.findViewById(2114453559));
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
      localStringBuffer.append(this.mContext.getString(2114322445)).append(";");
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("name");
      String str2 = "《" + paramString + "》";
      String str3 = ((JSONObject)localObject).optString("auth");
      String str4 = ((JSONObject)localObject).optString("cate");
      String str5 = ((JSONObject)localObject).optString("brief");
      paramString = ((JSONObject)localObject).optString("pic_url");
      String str1 = ((JSONObject)localObject).optString("keyword");
      if (((JSONObject)localObject).optBoolean("clickable", false))
      {
        setBackgroundResource(2114060291);
        setClickable(true);
      }
      localObject = new HighlightModel(((JSONObject)localObject).optJSONArray("highlight"), str1).getHighlightWords(str2);
      if (localObject != null)
      {
        this.bookNameText.setText((CharSequence)localObject);
        localStringBuffer.append(this.mContext.getString(2114322457, new Object[] { str2 })).append(";");
      }
      if ((str4 != null) && (str3 != null))
      {
        this.bookTypeAndAuthorText.setText(SearchViewBuilder.getHighLightText(str4 + "，" + str3, str1));
        localStringBuffer.append(this.mContext.getString(2114322458, new Object[] { str4, str3 })).append(";");
      }
      if (!TextUtils.isEmpty(str5))
      {
        str2 = PatternUtil.getStrRemoveSpace(str5);
        this.bookDetailText.setText(SearchViewBuilder.getHighLightText(str2.trim(), str1));
      }
      Statics.setImage(this.bookImage, paramString, SearchViewBuilder.getImageWidthInPixels(this.mContext), SearchViewBuilder.getImageHeightInPixels(this.mContext));
      Statics.dealTitleAndSecondText(this.bookNameText, this.bookDetailText, (CharSequence)localObject, null);
      this.rootView.setContentDescription(localStringBuffer);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.BookView
 * JD-Core Version:    0.7.0.1
 */