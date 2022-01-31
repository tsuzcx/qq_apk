package com.tencent.biz.lebsearch.widget;

import android.annotation.TargetApi;
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
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FunctionView
  extends LinearLayout
{
  public static final int BUSINNESS_ID_ALBUM = 5;
  public static final int BUSINNESS_ID_ANIME = 18;
  public static final int BUSINNESS_ID_CITY_SERVICE = 22;
  public static final int BUSINNESS_ID_CM_SHOW = 11;
  public static final int BUSINNESS_ID_EAT_AND_DRINK = 21;
  public static final int BUSINNESS_ID_FACE_TO_FACE_SEND = 30;
  public static final int BUSINNESS_ID_FACE_TO_FACE_WALLET = 33;
  public static final int BUSINNESS_ID_GAMES = 13;
  public static final int BUSINNESS_ID_INTERESTED_TRIBES = 12;
  public static final int BUSINNESS_ID_JINGDONG = 16;
  public static final int BUSINNESS_ID_MUSIC = 19;
  public static final int BUSINNESS_ID_MY_COMPUTER = 28;
  public static final int BUSINNESS_ID_MY_FAVORITES = 4;
  public static final int BUSINNESS_ID_MY_FILE = 6;
  public static final int BUSINNESS_ID_NEARBY = 10;
  public static final int BUSINNESS_ID_NOW_LIVE = 20;
  public static final int BUSINNESS_ID_PAY = 32;
  public static final int BUSINNESS_ID_PENGUIN_COUNSELING = 26;
  public static final int BUSINNESS_ID_PERSONALITY_DRESS_UP = 3;
  public static final int BUSINNESS_ID_PHONE_CONTACTS = 8;
  public static final int BUSINNESS_ID_PUBLIC_ACCOUNT = 27;
  public static final int BUSINNESS_ID_QQ_DAREN = 7;
  public static final int BUSINNESS_ID_QQ_KANDIAN = 15;
  public static final int BUSINNESS_ID_QQ_MEMBER = 1;
  public static final int BUSINNESS_ID_QQ_PHONE = 29;
  public static final int BUSINNESS_ID_QQ_RED_ENVELOPES = 39;
  public static final int BUSINNESS_ID_QQ_STORY = 14;
  public static final int BUSINNESS_ID_QQ_WALLET = 2;
  public static final int BUSINNESS_ID_QQ_ZONE = 9;
  public static final int BUSINNESS_ID_READ = 17;
  public static final int BUSINNESS_ID_SCAN = 31;
  public static final int BUSINNESS_ID_SHOOT = 34;
  public static final int BUSINNESS_ID_SHOPPING_ACCOUNT = 36;
  public static final int BUSINNESS_ID_SPORTS = 24;
  public static final int BUSINNESS_ID_TENCENT_CLASSROOM = 25;
  public static final int BUSINNESS_ID_TENCENT_NEWS = 23;
  public static final int BUSINNESS_ID_TROOP_ASSITANT = 35;
  public static final int BUSINNESS_ID_TROOP_NOTIFACATION = 37;
  public static final int BUSINNESS_ID_YINGYONGBAO = 38;
  public static final String KEY_BUSINESS_ID = "fid";
  public static final String KEY_BUSINESS_URL = "funurl";
  public static final String KEY_ICON = "icurl";
  public static final String KEY_URL = "url";
  public static final String KEY_URL_MODEL = "url_model";
  public static final String KYE_CLASS_NAME = "className";
  public static final List<Integer> sSupportFunctionIDList = new ArrayList();
  private ImageView coverView;
  private Context mContext;
  private ImageView mIcon;
  private int mIconWidth = 0;
  private ImageView mImage;
  private int mImageWidth = 0;
  private View mRootView;
  private TextView mTitle;
  
  static
  {
    sSupportFunctionIDList.add(Integer.valueOf(1));
    sSupportFunctionIDList.add(Integer.valueOf(2));
    sSupportFunctionIDList.add(Integer.valueOf(3));
    sSupportFunctionIDList.add(Integer.valueOf(4));
    sSupportFunctionIDList.add(Integer.valueOf(5));
    sSupportFunctionIDList.add(Integer.valueOf(6));
    sSupportFunctionIDList.add(Integer.valueOf(7));
    sSupportFunctionIDList.add(Integer.valueOf(8));
    sSupportFunctionIDList.add(Integer.valueOf(9));
    sSupportFunctionIDList.add(Integer.valueOf(10));
    sSupportFunctionIDList.add(Integer.valueOf(11));
    sSupportFunctionIDList.add(Integer.valueOf(12));
    sSupportFunctionIDList.add(Integer.valueOf(13));
    sSupportFunctionIDList.add(Integer.valueOf(14));
    sSupportFunctionIDList.add(Integer.valueOf(15));
    sSupportFunctionIDList.add(Integer.valueOf(16));
    sSupportFunctionIDList.add(Integer.valueOf(17));
    sSupportFunctionIDList.add(Integer.valueOf(18));
    sSupportFunctionIDList.add(Integer.valueOf(19));
    sSupportFunctionIDList.add(Integer.valueOf(20));
    sSupportFunctionIDList.add(Integer.valueOf(21));
    sSupportFunctionIDList.add(Integer.valueOf(22));
    sSupportFunctionIDList.add(Integer.valueOf(23));
    sSupportFunctionIDList.add(Integer.valueOf(24));
    sSupportFunctionIDList.add(Integer.valueOf(25));
    sSupportFunctionIDList.add(Integer.valueOf(26));
    sSupportFunctionIDList.add(Integer.valueOf(27));
    sSupportFunctionIDList.add(Integer.valueOf(28));
    sSupportFunctionIDList.add(Integer.valueOf(30));
    sSupportFunctionIDList.add(Integer.valueOf(31));
    sSupportFunctionIDList.add(Integer.valueOf(32));
    sSupportFunctionIDList.add(Integer.valueOf(33));
    sSupportFunctionIDList.add(Integer.valueOf(35));
    sSupportFunctionIDList.add(Integer.valueOf(36));
    sSupportFunctionIDList.add(Integer.valueOf(37));
    sSupportFunctionIDList.add(Integer.valueOf(38));
    sSupportFunctionIDList.add(Integer.valueOf(39));
  }
  
  public FunctionView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public FunctionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  @TargetApi(11)
  public FunctionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
    this.mImageWidth = SearchViewBuilder.getImageWidthInPixels(this.mContext);
    if (this.mContext != null) {
      this.mIconWidth = this.mContext.getResources().getDimensionPixelSize(2114256907);
    }
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125830, null);
    this.mTitle = ((TextView)localView.findViewById(2114453537));
    this.mImage = ((ImageView)localView.findViewById(2114453536));
    this.mIcon = ((ImageView)localView.findViewById(2114453538));
    this.coverView = ((ImageView)localView.findViewById(2114453517));
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = -1;
    localView.setLayoutParams(localLayoutParams);
    this.mRootView = localView;
  }
  
  public void gotoFunctionPage(String paramString1, String paramString2, Context paramContext, HashMap<String, Object> paramHashMap)
  {
    ClassLoader localClassLoader = getContext().getClassLoader();
    try
    {
      paramString1 = localClassLoader.loadClass(paramString1).getMethod(paramString2, new Class[] { Context.class, HashMap.class });
      paramString1.setAccessible(true);
      paramString1.invoke(null, new Object[] { paramContext, paramHashMap });
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void gotoFunctionWeb(String paramString1, String paramString2, Context paramContext, HashMap<String, Object> paramHashMap)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      System.out.println("FunctionView gotoFunctionWeb url=" + paramString2);
      return;
    }
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap(1);
    }
    ((HashMap)localObject).put("url", paramString2);
    paramString2 = getContext().getClassLoader();
    try
    {
      paramString1 = paramString2.loadClass(paramString1).getMethod("gotoWebView", new Class[] { Context.class, HashMap.class });
      paramString1.setAccessible(true);
      paramString1.invoke(null, new Object[] { paramContext, localObject });
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void handlePluginOnClickListener(int paramInt, String paramString)
  {
    Object localObject;
    try
    {
      System.out.println("FunctionView registerOnClickListener data=" + paramString);
      new StringBuffer();
      localObject = new JSONObject(paramString);
      paramString = new HashMap();
      if (paramInt != 268435456) {
        break label830;
      }
      paramInt = ((JSONObject)localObject).optInt("fid");
      paramString.put("fid", Integer.valueOf(paramInt));
      localObject = ((JSONObject)localObject).optString("funurl");
      System.out.println("CommonFunctionView registerOnClickListener businessID=" + paramInt);
      switch (paramInt)
      {
      case 1: 
      case 3: 
      case 7: 
      case 11: 
      case 12: 
      case 16: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 39: 
        gotoFunctionWeb("com.tencent.biz.lebasearch.Utils", (String)localObject, getContext(), paramString);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    paramString.put("className", "cooperation.qwallet.plugin.QWalletPluginProxyActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "cooperation.qqfav.QfavPluginProxyActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "cooperation.qzone.QzoneGPUPluginProxyActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("url_model", "gameCenter");
    gotoFunctionWeb("com.tencent.biz.lebasearch.Utils", (String)localObject, getContext(), paramString);
    return;
    paramString.put("className", "com.tencent.mobileqq.activity.phone.SettingActivity2");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "cooperation.qzone.QzoneFeedsPluginProxyActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "com.tencent.mobileqq.activity.NearbyActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "com.tencent.biz.qqstory.storyHome.QQStoryMainActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "cooperation.qqreader.QRBridgeActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "cooperation.comic.VipComicProxyActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "com.dataline.activities.LiteActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFaceToFaceSend", getContext(), paramString);
    return;
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoScan", getContext(), paramString);
    return;
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoPay", getContext(), paramString);
    return;
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoF2fRedPacket", getContext(), null);
    return;
    paramString.put("className", "com.tencent.mobileqq.activity.TroopAssistantActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "com.tencent.mobileqq.activity.contact.troop.TroopActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    paramString.put("className", "com.tencent.open.applist.QZoneAppListActivity");
    gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoFunctionActivity", getContext(), paramString);
    return;
    label830:
    if (paramInt == 536870912)
    {
      paramString.put("uin", Long.valueOf(((JSONObject)localObject).optLong("proid")));
      gotoFunctionPage("com.tencent.biz.lebasearch.Utils", "gotoStoryBigVipPage", getContext(), paramString);
      return;
    }
  }
  
  public void setData(String paramString)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      paramString = new JSONObject(paramString);
      String str1 = paramString.optString("name");
      Object localObject = paramString.optString("keyword");
      String str2 = paramString.optString("pic_url");
      String str3 = paramString.optString("icurl");
      if (paramString.optBoolean("clickable", false))
      {
        setBackgroundResource(2114060291);
        setClickable(true);
      }
      localObject = new HighlightModel(paramString.optJSONArray("highlight"), (String)localObject).getHighlightWords(str1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.mTitle.setText((CharSequence)localObject);
      }
      localStringBuffer.append(this.mContext.getString(2114322487, new Object[] { str1 })).append(";");
      Statics.setImage(this.mImage, str2, this.mImageWidth, this.mImageWidth, this.mImageWidth / 2, 0);
      if (TextUtils.isEmpty(str3)) {
        this.mIcon.setVisibility(8);
      }
      for (;;)
      {
        int i = paramString.optInt("video_or_music");
        Statics.dealWithCover(this.mIcon, this.coverView, i);
        this.mRootView.setContentDescription(localStringBuffer.toString());
        return;
        this.mIcon.setVisibility(0);
        Statics.setImage(this.mIcon, str3, this.mIconWidth, this.mIconWidth, 0.0F, 0);
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.FunctionView
 * JD-Core Version:    0.7.0.1
 */