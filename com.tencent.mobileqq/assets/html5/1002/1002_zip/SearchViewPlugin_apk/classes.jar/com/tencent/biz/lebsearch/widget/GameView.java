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

public class GameView
  extends LinearLayout
{
  public static final String KEY_GAME_DESCRIPTION = "description";
  public static final String KEY_GAME_NEW_MARK = "android_new_game";
  public static final String KEY_GAME_TYPE = "type";
  private Context mContext;
  private TextView mGameName;
  private ImageView mImage;
  private View mRootView;
  private TextView mSecondLine;
  private TextView mark;
  
  public GameView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public GameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public GameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125831, null);
    this.mGameName = ((TextView)localView.findViewById(2114453540));
    this.mImage = ((ImageView)localView.findViewById(2114453539));
    this.mSecondLine = ((TextView)localView.findViewById(2114453542));
    this.mark = ((TextView)localView.findViewById(2114453541));
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = -1;
    localView.setLayoutParams(localLayoutParams);
    this.mRootView = localView;
  }
  
  public void setData(String paramString)
  {
    for (;;)
    {
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(this.mContext.getString(2114322449)).append(";");
        Object localObject2 = new JSONObject(paramString);
        String str2 = ((JSONObject)localObject2).optString("name");
        Object localObject1 = ((JSONObject)localObject2).optString("keyword");
        paramString = ((JSONObject)localObject2).optString("pic_url");
        if (((JSONObject)localObject2).optBoolean("clickable", false))
        {
          setBackgroundResource(2114060291);
          setClickable(true);
        }
        SpannableString localSpannableString = new HighlightModel(((JSONObject)localObject2).optJSONArray("highlight"), (String)localObject1).getHighlightWords(str2);
        if (!TextUtils.isEmpty(localSpannableString)) {
          this.mGameName.setText(localSpannableString);
        }
        int i = SearchViewBuilder.getImageWidthInPixels(this.mContext);
        int j = SearchViewBuilder.getImageHeightInPixels(this.mContext);
        String str1 = ((JSONObject)localObject2).optString("description");
        int k = ((JSONObject)localObject2).optInt("android_new_game");
        localStringBuffer.append(this.mContext.getString(2114322485, new Object[] { str2 })).append(";");
        localObject2 = ((JSONObject)localObject2).optString("type");
        if (k == 1)
        {
          this.mark.setVisibility(0);
          this.mark.setText(2114322486);
          localObject1 = SearchViewBuilder.getHighLightText(str1, (String)localObject1);
          this.mSecondLine.setText((CharSequence)localObject1);
          Statics.setImage(this.mImage, paramString, i, j);
          Statics.dealTitleAndSecondText(this.mGameName, this.mSecondLine, localSpannableString, this.mark);
          this.mRootView.setContentDescription(localStringBuffer.toString());
          return;
        }
        if (((String)localObject2).equals("攻略"))
        {
          this.mark.setText("攻略");
          this.mark.setVisibility(8);
        }
        else
        {
          this.mark.setVisibility(8);
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
 * Qualified Name:     com.tencent.biz.lebsearch.widget.GameView
 * JD-Core Version:    0.7.0.1
 */