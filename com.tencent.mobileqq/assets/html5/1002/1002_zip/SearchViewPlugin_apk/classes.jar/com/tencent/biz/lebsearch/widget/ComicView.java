package com.tencent.biz.lebsearch.widget;

import android.content.Context;
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

public class ComicView
  extends LinearLayout
{
  public static final String KEY_COMIC_AUTHOR = "auth";
  public static final String KEY_COMIC_DETAIL = "brief";
  public static final String KEY_COMIC_ICON = "icon";
  public static final String KEY_COMIC_TYPE = "cate";
  TextView comicDetailText;
  TextView comicIconTxt;
  ImageView comicImage;
  TextView comicNameText;
  TextView comicTypeAndAuthorText;
  private Context mContext;
  View rootView;
  
  public ComicView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public ComicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public ComicView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125826, null);
    this.comicNameText = ((TextView)localView.findViewById(2114453518));
    this.comicIconTxt = ((TextView)localView.findViewById(2114453519));
    this.comicTypeAndAuthorText = ((TextView)localView.findViewById(2114453521));
    this.comicDetailText = ((TextView)localView.findViewById(2114453520));
    this.comicImage = ((ImageView)localView.findViewById(2114453516));
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = -1;
    localView.setLayoutParams(localLayoutParams);
    this.rootView = localView;
  }
  
  public void setData(String paramString)
  {
    for (;;)
    {
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(this.mContext.getString(2114322453)).append(";");
        paramString = new JSONObject(paramString);
        String str1 = paramString.optString("name");
        str1 = "《" + str1 + "》";
        Integer localInteger = Integer.valueOf(paramString.optInt("icon"));
        String str2 = paramString.optString("auth");
        String str3 = paramString.optString("cate");
        String str4 = paramString.optString("brief");
        String str5 = paramString.optString("pic_url");
        String str6 = paramString.optString("keyword");
        if (paramString.optBoolean("clickable", false))
        {
          setBackgroundResource(2114060291);
          setClickable(true);
        }
        paramString = new HighlightModel(paramString.optJSONArray("highlight"), str6).getHighlightWords(str1);
        if (paramString != null)
        {
          this.comicNameText.setText(paramString);
          if (localInteger.intValue() == 8)
          {
            this.comicIconTxt.setText("轻小说");
            this.comicIconTxt.setBackgroundResource(2114060301);
            localStringBuffer.append(this.mContext.getString(2114322457, new Object[] { str1 })).append(";");
          }
        }
        else
        {
          if ((str3 != null) && (str2 != null))
          {
            this.comicTypeAndAuthorText.setText(SearchViewBuilder.getHighLightText(str3 + "，" + str2, str6));
            localStringBuffer.append(this.mContext.getString(2114322458, new Object[] { str3, str2 })).append(";");
          }
          if (str4 != null) {
            this.comicDetailText.setText(SearchViewBuilder.getHighLightText(str4.trim(), str6));
          }
          Statics.dealTitleAndSecondText(this.comicNameText, this.comicDetailText, paramString, this.comicIconTxt);
          Statics.setImage(this.comicImage, str5, SearchViewBuilder.getImageWidthInPixels(this.mContext), SearchViewBuilder.getImageHeightInPixels(this.mContext));
          this.rootView.setContentDescription(localStringBuffer);
          return;
        }
        if ((localInteger.intValue() >= 100) && (localInteger.intValue() <= 300)) {
          this.comicIconTxt.setText("动画");
        } else {
          this.comicIconTxt.setText("漫画");
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.ComicView
 * JD-Core Version:    0.7.0.1
 */