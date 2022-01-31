package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebsearch.Statics;
import com.tencent.biz.lebsearch.util.PatternUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArticleView
  extends LinearLayout
{
  public static final String KEY_AUTHOR = "article_author";
  public static final String KEY_BRIEF = "brief";
  public static final String KEY_HIGHlIGHT = "highlight";
  public static final String KEY_TIME = "create_time";
  public static final String KEY_VIDEO_ARTICLE = "video_article";
  private TextView authorView;
  private TextView briefView;
  private ImageView cover;
  private ImageView iconView;
  private Context mContext;
  View rootView;
  private TextView timeView;
  private TextView titleView;
  private ImageView watermark;
  
  public ArticleView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public ArticleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public ArticleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  public static SpannableString generateHighLightString(String paramString, List<String> paramList, boolean paramBoolean)
  {
    if (paramString == null) {
      paramString = null;
    }
    Object localObject;
    int j;
    SpannableString localSpannableString;
    do
    {
      return paramString;
      if (paramList == null) {
        return new SpannableString(paramString);
      }
      i = paramString.length();
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        j = getKeywordIndexNoCareCase((String)((Iterator)localObject).next(), paramString);
        if ((j >= 0) && (j < i)) {
          i = j;
        }
      }
      localObject = paramString;
      if (i > 8)
      {
        localObject = paramString;
        if (i != paramString.length())
        {
          localObject = paramString;
          if (paramBoolean) {
            localObject = "…" + paramString.substring(i - 8);
          }
        }
      }
      localSpannableString = new SpannableString((CharSequence)localObject);
      paramList = paramList.iterator();
      paramString = localSpannableString;
    } while (!paramList.hasNext());
    String str = (String)paramList.next();
    paramString = (String)localObject;
    int i = 0;
    for (;;)
    {
      int k = getKeywordIndexNoCareCase(str, paramString);
      if (k < 0) {
        break;
      }
      j = k + str.length();
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), i + k, i + j, 34);
      i += j;
      paramString = paramString.substring(j);
    }
  }
  
  private static int getKeywordIndexNoCareCase(String paramString1, String paramString2)
  {
    int i = paramString2.indexOf(paramString1);
    if (i >= 0) {
      return i;
    }
    return paramString2.toLowerCase().indexOf(paramString1.toLowerCase());
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125825, null);
    this.iconView = ((ImageView)localView.findViewById(2114453509));
    this.titleView = ((TextView)localView.findViewById(2114453511));
    this.briefView = ((TextView)localView.findViewById(2114453513));
    this.authorView = ((TextView)localView.findViewById(2114453514));
    this.timeView = ((TextView)localView.findViewById(2114453515));
    this.watermark = ((ImageView)localView.findViewById(2114453512));
    this.watermark.setVisibility(4);
    this.cover = ((ImageView)localView.findViewById(2114453510));
    this.cover.setVisibility(4);
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
      localStringBuffer.append(this.mContext.getString(2114322452)).append(";");
      Object localObject3 = new JSONObject(paramString);
      Object localObject2 = ((JSONObject)localObject3).optString("name");
      paramString = ((JSONObject)localObject3).getJSONArray("highlight");
      Object localObject1 = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        ((List)localObject1).add(paramString.getString(i));
        i += 1;
      }
      String str2 = ((JSONObject)localObject3).optString("brief");
      String str3 = ((JSONObject)localObject3).optString("pic_url");
      paramString = ((JSONObject)localObject3).optString("create_time");
      String str1 = ((JSONObject)localObject3).optString("article_author");
      ((JSONObject)localObject3).optInt("video_article");
      if (((JSONObject)localObject3).optBoolean("clickable", false))
      {
        setBackgroundResource(2114060291);
        setClickable(true);
      }
      Statics.setImage(this.iconView, str3, SearchViewBuilder.getImageWidthInPixels(this.mContext), SearchViewBuilder.getImageHeightInPixels(this.mContext));
      localObject3 = ((JSONObject)localObject3).optString("keyword");
      localObject2 = new HighlightModel((List)localObject1, (String)localObject3).getHighlightWords((String)localObject2, true);
      if (localObject2 != null)
      {
        this.titleView.setText((CharSequence)localObject2);
        localStringBuffer.append((CharSequence)localObject2).append(";");
      }
      localObject1 = new HighlightModel((List)localObject1, (String)localObject3);
      str2 = PatternUtil.getStrRemoveSpace(str2);
      localObject1 = ((HighlightModel)localObject1).getHighlightWords(str2);
      Statics.dealTitleAndSecondText(this.titleView, this.briefView, (CharSequence)localObject2, null);
      if (localObject1 != null)
      {
        this.briefView.setText((CharSequence)localObject1);
        localStringBuffer.append(str2).append(";");
      }
      this.authorView.setText("来自 " + str1);
      localStringBuffer.append(str1).append(";");
      this.timeView.setText(paramString);
      localStringBuffer.append(paramString).append(";");
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
 * Qualified Name:     com.tencent.biz.lebsearch.widget.ArticleView
 * JD-Core Version:    0.7.0.1
 */