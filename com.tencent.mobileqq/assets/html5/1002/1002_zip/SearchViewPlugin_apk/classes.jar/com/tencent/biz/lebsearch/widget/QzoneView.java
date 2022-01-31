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

public class QzoneView
  extends LinearLayout
{
  public static final String KEY_ARTICLE_ABSTRACT = "article_abstract";
  public static final String KEY_ARTICLE_NAME = "article_name";
  public static final String KEY_DATE = "date";
  public static final String KEY_PHOTO_INTRODUCE = "photo_introduce";
  public static final String KEY_PHOTO_NAME = "photo_name";
  public static final String KEY_PHOTO_UPDATE = "photo_update";
  public static final String KEY_TALK_ABSTRACT = "talk_abstract";
  public static final String KEY_TYPE = "type";
  public static final String KEY_VIDOE = "video";
  public static final int TYPE_ALBUM = 4;
  public static final int TYPE_DIARY = 2;
  public static final int TYPE_TALK = 311;
  TextView dateText;
  View iconLayout;
  TextView line2Text;
  TextView line3Text;
  private Context mContext;
  TextView mark;
  TextView nameText;
  ImageView qzoneImg;
  View rootView;
  ImageView videoView;
  
  public QzoneView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public QzoneView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public QzoneView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125834, null);
    this.qzoneImg = ((ImageView)localView.findViewById(2114453552));
    this.nameText = ((TextView)localView.findViewById(2114453555));
    this.dateText = ((TextView)localView.findViewById(2114453556));
    this.line2Text = ((TextView)localView.findViewById(2114453557));
    this.line3Text = ((TextView)localView.findViewById(2114453558));
    this.mark = ((TextView)localView.findViewById(2114453541));
    this.videoView = ((ImageView)localView.findViewById(2114453553));
    this.iconLayout = localView.findViewById(2114453551);
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
      StringBuffer localStringBuffer;
      Object localObject1;
      String str1;
      String str2;
      int i;
      try
      {
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(this.mContext.getString(2114322450)).append(";");
        localObject2 = new JSONObject(paramString);
        localObject1 = ((JSONObject)localObject2).optString("name");
        str1 = ((JSONObject)localObject2).optString("keyword");
        str2 = ((JSONObject)localObject2).optString("pic_url");
        String str3 = ((JSONObject)localObject2).optString("date");
        i = ((JSONObject)localObject2).optInt("video");
        if (((JSONObject)localObject2).optBoolean("clickable", false))
        {
          setBackgroundResource(2114060291);
          setClickable(true);
        }
        paramString = (String)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = ((String)localObject1).trim();
        }
        localObject1 = ((JSONObject)localObject2).optJSONArray("highlight");
        SearchViewBuilder.bindText(this.nameText, paramString, (JSONArray)localObject1, str1);
        localStringBuffer.append(this.nameText).append(";");
        if (!TextUtils.isEmpty(str3))
        {
          this.dateText.setText(str3);
          localStringBuffer.append(str3).append(";");
        }
        switch (((JSONObject)localObject2).optInt("type"))
        {
        case 4: 
          this.mark.setVisibility(8);
          if (!TextUtils.isEmpty(str2)) {
            break label572;
          }
          this.qzoneImg.setVisibility(8);
          this.iconLayout.setVisibility(8);
          this.rootView.setContentDescription(localStringBuffer);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = ((JSONObject)localObject2).optString("photo_update");
      Object localObject2 = ((JSONObject)localObject2).optString("photo_introduce");
      this.line2Text.setSingleLine();
      this.line3Text.setSingleLine();
      SearchViewBuilder.bindText(this.line2Text, paramString, (JSONArray)localObject1, str1);
      localStringBuffer.append(this.line2Text).append(";");
      SearchViewBuilder.bindText(this.line3Text, (String)localObject2, (JSONArray)localObject1, str1);
      localStringBuffer.append(this.line3Text).append(";");
      this.mark.setText(2114322490);
      continue;
      paramString = ((JSONObject)localObject2).optString("article_name");
      localObject2 = ((JSONObject)localObject2).optString("article_abstract");
      this.line2Text.setSingleLine();
      this.line3Text.setSingleLine();
      SearchViewBuilder.bindText(this.line2Text, paramString, (JSONArray)localObject1, str1);
      localStringBuffer.append(this.line2Text).append(";");
      SearchViewBuilder.bindText(this.line3Text, (String)localObject2, (JSONArray)localObject1, str1);
      localStringBuffer.append(this.line3Text).append(";");
      this.mark.setText(2114322491);
      if ((!TextUtils.isEmpty(str2)) && (i == 1))
      {
        this.videoView.setVisibility(0);
        continue;
        paramString = ((JSONObject)localObject2).optString("talk_abstract");
        this.line2Text.setMaxLines(2);
        SearchViewBuilder.bindText(this.line2Text, paramString, (JSONArray)localObject1, str1);
        localStringBuffer.append(this.line2Text).append(";");
        this.line3Text.setVisibility(8);
        this.mark.setText(2114322489);
        if ((!TextUtils.isEmpty(str2)) && (i == 1))
        {
          this.videoView.setVisibility(0);
          continue;
          label572:
          Statics.setImage(this.qzoneImg, str2, SearchViewBuilder.getImageWidthInPixels(this.mContext), SearchViewBuilder.getImageHeightInPixels(this.mContext));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.QzoneView
 * JD-Core Version:    0.7.0.1
 */