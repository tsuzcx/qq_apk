package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.content.res.Resources;
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

public class MusicView
  extends LinearLayout
{
  public static final int ITEM_TYPE_ALBUM = 3;
  public static final int ITEM_TYPE_SINGER = 2;
  public static final int ITEM_TYPE_SONG = 1;
  public static final String KEY_MUSIC_ALBUM = "album";
  public static final String KEY_MUSIC_ALBUM_CNT = "album_cnt";
  public static final String KEY_MUSIC_SINGER = "singer_name";
  public static final String KEY_MUSIC_SONG_CNT = "song_cnt";
  public static final String KEY_MUSIC_SONG_THEME = "theme";
  public static final String KEY_MUSIC_TYPE = "type";
  private ImageView coverView;
  private Context mContext;
  private ImageView mImage;
  private TextView mMusicName;
  private View mRootView;
  private TextView mSecondLine;
  private TextView mThirdLine;
  private TextView mark;
  
  public MusicView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public MusicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public MusicView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125833, null);
    this.mMusicName = ((TextView)localView.findViewById(2114453548));
    this.mImage = ((ImageView)localView.findViewById(2114453547));
    this.mSecondLine = ((TextView)localView.findViewById(2114453549));
    this.mThirdLine = ((TextView)localView.findViewById(2114453550));
    this.coverView = ((ImageView)localView.findViewById(2114453517));
    this.mThirdLine.setVisibility(8);
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
      StringBuffer localStringBuffer;
      int k;
      String str2;
      String str1;
      Object localObject2;
      int i;
      int j;
      Object localObject3;
      try
      {
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(this.mContext.getString(2114322447)).append(";");
        paramString = new JSONObject(paramString);
        k = paramString.optInt("type", -1);
        if (k == -1) {
          return;
        }
        str2 = paramString.optString("name");
        Object localObject1 = paramString.optString("keyword");
        str1 = paramString.optString("pic_url");
        if (paramString.optBoolean("clickable", false))
        {
          setBackgroundResource(2114060291);
          setClickable(true);
        }
        localObject2 = new HighlightModel(paramString.optJSONArray("highlight"), (String)localObject1);
        localObject1 = ((HighlightModel)localObject2).getHighlightWords(str2, true);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.mMusicName.setText((CharSequence)localObject1);
        }
        i = SearchViewBuilder.getImageWidthInPixels(this.mContext);
        j = SearchViewBuilder.getImageHeightInPixels(this.mContext);
        if (k != 1) {
          break label458;
        }
        localObject3 = paramString.optString("singer_name");
        String str3 = paramString.optString("album");
        localStringBuffer.append(this.mContext.getString(2114322477, new Object[] { str2, localObject3, str3 })).append(";");
        str2 = paramString.optString("theme");
        if (TextUtils.isEmpty(str2))
        {
          this.mark.setVisibility(8);
          localObject3 = ((HighlightModel)localObject2).getHighlightWords(String.format("%s·%s", new Object[] { localObject3, str3 }));
          this.mSecondLine.setText((CharSequence)localObject3);
          if (!TextUtils.isEmpty(str2))
          {
            this.mThirdLine.setVisibility(0);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("《").append(str2).append("》");
            localObject2 = ((HighlightModel)localObject2).getHighlightWords(((StringBuilder)localObject3).toString());
            this.mThirdLine.setText((CharSequence)localObject2);
            ((LinearLayout.LayoutParams)this.mSecondLine.getLayoutParams()).setMargins(0, (int)getResources().getDimension(2114256906), 0, 0);
          }
          Statics.setImage(this.mImage, str1, i, j);
          i = paramString.optInt("video_or_music");
          Statics.dealWithCover(this.mImage, this.coverView, i);
          Statics.dealTitleAndSecondText(this.mMusicName, this.mSecondLine, (CharSequence)localObject1, this.mark);
          this.mRootView.setContentDescription(localStringBuffer.toString());
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      this.mark.setVisibility(0);
      this.mark.setText("主题曲");
      continue;
      label458:
      if (k == 2)
      {
        k = paramString.optInt("song_cnt");
        int m = paramString.optInt("album_cnt");
        localStringBuffer.append(this.mContext.getString(2114322478, new Object[] { str2, Integer.valueOf(k), Integer.valueOf(m) })).append(";");
        localObject2 = ((HighlightModel)localObject2).getHighlightWords(String.format("单曲: %s 专辑: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m) }));
        this.mSecondLine.setText((CharSequence)localObject2);
        this.mark.setVisibility(0);
        this.mark.setText("歌手");
        Statics.setImage(this.mImage, str1, i, j);
      }
      else if (k == 3)
      {
        localStringBuffer.append(str2);
        localObject3 = paramString.optString("singer_name");
        localStringBuffer.append(this.mContext.getString(2114322479, new Object[] { str2, localObject3 })).append(";");
        localObject2 = ((HighlightModel)localObject2).getHighlightWords((String)localObject3);
        localStringBuffer.append((CharSequence)localObject2);
        this.mSecondLine.setText((CharSequence)localObject2);
        this.mark.setVisibility(0);
        this.mark.setText("专辑");
        Statics.setImage(this.mImage, str1, i, j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.MusicView
 * JD-Core Version:    0.7.0.1
 */