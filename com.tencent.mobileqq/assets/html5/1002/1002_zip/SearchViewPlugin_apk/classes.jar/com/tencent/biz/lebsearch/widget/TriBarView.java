package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebsearch.Statics;
import com.tencent.biz.lebsearch.util.DateUtil;
import com.tencent.biz.lebsearch.util.PatternUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TriBarView
  extends LinearLayout
{
  public static final int ITEM_TYPE_BAR = 0;
  public static final int ITEM_TYPE_POST = 1;
  public static final String KEY_TRIBAR_BAR_CONTENT = "content";
  public static final String KEY_TRIBAR_BAR_DISCUSS_CNT = "discuss";
  public static final String KEY_TRIBAR_BAR_FROM = "from_gbar_name";
  public static final String KEY_TRIBAR_BAR_NAME = "gbar_name";
  public static final String KEY_TRIBAR_BAR_POST_CREATE_TIME = "create_time";
  public static final String KEY_TRIBAR_BAR_PRAISE_CNT = "praise";
  public static final String KEY_TRIBAR_FOLLOW = "follow";
  public static final String KEY_TRIBAR_NEW = "new";
  public static final String KEY_TRIBAR_TYPE = "type";
  private ImageView coverView;
  private TextView mBarIcon;
  private TextView mBarName;
  private Context mContext;
  private ImageView mImage;
  private View mRootView;
  private TextView mSecondLine;
  private TextView mThirdLineFrom;
  private TextView mThirdLinePostTime;
  
  public TriBarView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public TriBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public TriBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125838, null);
    this.mBarName = ((TextView)localView.findViewById(2114453572));
    this.mBarIcon = ((TextView)localView.findViewById(2114453573));
    this.mImage = ((ImageView)localView.findViewById(2114453571));
    this.mSecondLine = ((TextView)localView.findViewById(2114453574));
    this.mThirdLineFrom = ((TextView)localView.findViewById(2114453575));
    this.mThirdLinePostTime = ((TextView)localView.findViewById(2114453576));
    this.coverView = ((ImageView)localView.findViewById(2114453517));
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = -1;
    localView.setLayoutParams(localLayoutParams);
    this.mRootView = localView;
  }
  
  public void setData(String paramString)
  {
    label771:
    label1039:
    for (;;)
    {
      StringBuffer localStringBuffer;
      int i;
      int j;
      int k;
      String str4;
      HighlightModel localHighlightModel;
      try
      {
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(this.mContext.getString(2114322446)).append(";");
        JSONObject localJSONObject = new JSONObject(paramString);
        i = localJSONObject.optInt("type", -1);
        if (i == -1) {
          return;
        }
        str2 = localJSONObject.optString("name");
        localObject = localJSONObject.optString("keyword");
        String str3 = localJSONObject.optString("pic_url");
        j = localJSONObject.optInt("follow", 0);
        k = localJSONObject.optInt("new", 0);
        str4 = localJSONObject.optString("content");
        str1 = localJSONObject.optString("from_gbar_name");
        paramString = localJSONObject.optString("create_time");
        localJSONObject.optInt("praise", 0);
        localJSONObject.optInt("discuss", 0);
        if (localJSONObject.optBoolean("clickable", false))
        {
          setBackgroundResource(2114060291);
          setClickable(true);
        }
        localHighlightModel = new HighlightModel(localJSONObject.optJSONArray("highlight"), (String)localObject);
        localObject = localHighlightModel.getHighlightWords(str2, true);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.mBarName.setText((CharSequence)localObject);
        }
        if (i != 0) {
          break label783;
        }
        localStringBuffer.append(this.mContext.getString(2114322472, new Object[] { str2 })).append(";");
        if (j > 10000)
        {
          paramString = (int)(j / 10000.0F + 0.5D) + "万";
          if (j <= 10000) {
            break label694;
          }
          str1 = (int)(j / 10000.0F + 0.5D) + "万";
          if (k <= 10000) {
            break label719;
          }
          str2 = (int)(k / 10000.0F + 0.5D) + "万";
          if (k <= 10000) {
            break label745;
          }
          localObject = (int)(k / 10000.0F + 0.5D) + "万";
          paramString = this.mContext.getString(2114322467, new Object[] { paramString, str2 });
          localStringBuffer.append(this.mContext.getString(2114322473, new Object[] { paramString })).append(";");
          if (TextUtils.isEmpty(str4)) {
            break label771;
          }
          str2 = PatternUtil.getStrRemoveSpace(str4);
          this.mSecondLine.setText(localHighlightModel.getHighlightWords(str2.trim()));
          this.mSecondLine.setVisibility(0);
          localStringBuffer.append(this.mContext.getString(2114322468, new Object[] { str1, localObject })).append(";");
          this.mThirdLineFrom.setText(paramString.trim());
          this.mThirdLineFrom.setVisibility(0);
          this.mThirdLinePostTime.setVisibility(8);
          this.mBarIcon.setText(2114322470);
          this.mBarIcon.setBackgroundResource(2114060301);
          if (i != 1) {
            break label1094;
          }
          this.mBarIcon.setVisibility(8);
          Statics.setImage(this.mImage, str3, SearchViewBuilder.getImageWidthInPixels(this.mContext), SearchViewBuilder.getImageHeightInPixels(this.mContext));
          i = localJSONObject.optInt("video_or_music");
          Statics.dealWithCover(this.mImage, this.coverView, i);
          Statics.dealTitleAndSecondText(this.mBarName, this.mSecondLine, this.mBarName.getText(), this.mBarIcon);
          this.mRootView.setContentDescription(localStringBuffer.toString());
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = "" + j;
      continue;
      label694:
      String str1 = "" + j;
      continue;
      label719:
      String str2 = "" + k;
      continue;
      label745:
      Object localObject = "" + k;
      continue;
      this.mSecondLine.setVisibility(8);
      continue;
      label783:
      if (i == 1)
      {
        localStringBuffer.append(this.mContext.getString(2114322475, new Object[] { str2 })).append(";");
        if (!TextUtils.isEmpty(str4))
        {
          localStringBuffer.append(this.mContext.getString(2114322476, new Object[] { str4 })).append(";");
          str2 = PatternUtil.getStrRemoveSpace(str4);
          this.mSecondLine.setText(localHighlightModel.getHighlightWords(str2.trim()));
          this.mSecondLine.setVisibility(0);
          label888:
          if (TextUtils.isEmpty(str1)) {
            break label1039;
          }
          this.mThirdLineFrom.setText(str1.trim());
          this.mThirdLineFrom.setVisibility(0);
          localStringBuffer.append(str1).append(";");
          boolean bool = TextUtils.isEmpty(paramString);
          if (bool) {
            break label1082;
          }
        }
        for (;;)
        {
          try
          {
            str1 = DateUtil.getDateString(Long.parseLong(paramString));
            Log.i("TriBarView", "time :" + str1 + ", postCreateTime: " + paramString);
            this.mThirdLinePostTime.setText(str1);
            this.mThirdLinePostTime.setVisibility(0);
            this.mBarIcon.setText(2114322471);
            this.mBarIcon.setBackgroundResource(2114060300);
            break;
            this.mSecondLine.setVisibility(8);
            break label888;
            this.mThirdLineFrom.setVisibility(8);
          }
          catch (Exception paramString)
          {
            Log.e("TriBarView", "time error:" + paramString);
            continue;
          }
          label1082:
          this.mThirdLinePostTime.setVisibility(8);
        }
        label1094:
        this.mBarIcon.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.TriBarView
 * JD-Core Version:    0.7.0.1
 */