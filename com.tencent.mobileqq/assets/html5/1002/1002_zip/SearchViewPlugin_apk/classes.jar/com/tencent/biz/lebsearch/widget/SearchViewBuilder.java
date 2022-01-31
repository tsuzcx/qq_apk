package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONArray;

public class SearchViewBuilder
{
  public static final String KEY_ACTIVE_SEARCH_IMG_RUL = "pic_url";
  public static final String KEY_ACTIVE_SEARCH_ITEM_NAME = "name";
  public static final String KEY_ACTIVE_SEARCH_KEY = "keyword";
  public static final String KEY_CLICKABLE = "clickable";
  public static final String KEY_HIGHLIGHT = "highlight";
  public static final String KEY_SEARCH_ITEM_JUMP_URL = "jump_url";
  public static final int VIEW_TYPE_APP = 1;
  public static final int VIEW_TYPE_ARTICLE = 2049;
  public static final int VIEW_TYPE_COMIC = 8192;
  public static final int VIEW_TYPE_CONTACT = 1073745984;
  public static final int VIEW_TYPE_COUPON = 4;
  public static final int VIEW_TYPE_EDU = 256;
  public static final int VIEW_TYPE_FUNCTION = 268435456;
  public static final int VIEW_TYPE_GAME = 513;
  public static final int VIEW_TYPE_GAME_WALKTHROUGH = 4097;
  public static final int VIEW_TYPE_MOVIE = 16;
  public static final int VIEW_TYPE_MUSIC = 128;
  public static final int VIEW_TYPE_QOZNE = 1024;
  public static final int VIEW_TYPE_READ = 8;
  public static final int VIEW_TYPE_SHOPPING = 2;
  public static final int VIEW_TYPE_STAR = 536870912;
  public static final int VIEW_TYPE_TONGCHENG = 2048;
  public static final int VIEW_TYPE_TRIBAR = 32;
  
  public static void bindText(TextView paramTextView, String paramString1, JSONArray paramJSONArray, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramTextView.setVisibility(0);
      if (paramJSONArray != null)
      {
        paramTextView.setText(new HighlightModel(paramJSONArray, paramString2).getHighlightWords(paramString1));
        return;
      }
      paramTextView.setText(paramString1);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public static SpannableString getHighLightText(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 == null) {
      return new SpannableString(paramString1);
    }
    int j = paramString1.indexOf(paramString2);
    if (j != -1)
    {
      int i = j;
      String str = paramString1;
      if (j > 10)
      {
        str = "…" + paramString1.substring(j - 6);
        i = 7;
      }
      paramString1 = new SpannableString(str);
      paramString1.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), i, paramString2.length() + i, 34);
      return paramString1;
    }
    return new SpannableString(paramString1);
  }
  
  public static int getImageHeightInPixels(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getDimensionPixelSize(2114256897);
  }
  
  public static int getImageWidthInPixels(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getDimensionPixelSize(2114256896);
  }
  
  public static View getView(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 16: 
      return new MovieView(paramContext);
    case 1: 
      return new AppView(paramContext);
    case 4: 
      return new CouponView(paramContext);
    case 8: 
      return new BookView(paramContext);
    case 2: 
      return new ShoppingView(paramContext);
    case 32: 
      return new TriBarView(paramContext);
    case 128: 
      return new MusicView(paramContext);
    case 256: 
      return new EduView(paramContext);
    case 513: 
      return new GameView(paramContext);
    case 1024: 
      return new QzoneView(paramContext);
    case 2048: 
      return new TongChengView(paramContext);
    case 2049: 
      return new ArticleView(paramContext);
    case 4097: 
      return new GameWalkthroughView(paramContext);
    case 8192: 
      return new ComicView(paramContext);
    case 268435456: 
    case 536870912: 
      return new FunctionView(paramContext);
    }
    return new ContactView(paramContext);
  }
  
  public static void setStars(LinearLayout paramLinearLayout, double paramDouble)
  {
    if ((paramDouble <= paramLinearLayout.getChildCount()) && (paramDouble >= 0.0D))
    {
      int j = (int)paramDouble;
      int i = 0;
      while (i < j)
      {
        ((ImageView)paramLinearLayout.getChildAt(i)).setImageResource(2114060295);
        i += 1;
      }
      if (paramDouble * 10.0D % 10.0D != 0.0D) {
        ((ImageView)paramLinearLayout.getChildAt(i)).setImageResource(2114060293);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.SearchViewBuilder
 * JD-Core Version:    0.7.0.1
 */