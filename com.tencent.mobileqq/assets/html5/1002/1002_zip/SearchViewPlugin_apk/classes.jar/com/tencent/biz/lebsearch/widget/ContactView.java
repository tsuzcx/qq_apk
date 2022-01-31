package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ContactView
  extends LinearLayout
{
  public static final int ITEM_TYPE_ARTICLE = 2049;
  public static final int ITEM_TYPE_GAME = 4096;
  public static final int ITEM_TYPE_TRIBE_TOPIC = 64;
  public static final String KEY_BRIEF = "brief";
  public static final String KEY_BUSINESS_MASK = "busi_mask";
  public static final String KEY_CONTACT_CREATE_TIME = "create_time";
  public static final String KEY_CONTACT_FROM = "from";
  public static final String KEY_GAME_DESCRIPTION = "description";
  public static final String KEY_HIGHlIGHT = "highlight";
  public static final String KEY_TRIBAR_BAR_CONTENT = "content";
  private TextView briefView;
  private ImageView coverView;
  private TextView fromView;
  private ImageView iconView;
  private Context mContext;
  View rootView;
  private TextView timeView;
  private TextView titleView;
  
  public ContactView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public ContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public ContactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2114125827, null);
    this.iconView = ((ImageView)localView.findViewById(2114453522));
    this.titleView = ((TextView)localView.findViewById(2114453523));
    this.briefView = ((TextView)localView.findViewById(2114453524));
    this.fromView = ((TextView)localView.findViewById(2114453525));
    this.timeView = ((TextView)localView.findViewById(2114453526));
    this.coverView = ((ImageView)localView.findViewById(2114453517));
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = -1;
    localView.setLayoutParams(localLayoutParams);
    this.rootView = localView;
  }
  
  /* Error */
  public void setData(String paramString)
  {
    // Byte code:
    //   0: new 127	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 129	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: new 131	org/json/JSONObject
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 133	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore 9
    //   19: aload 9
    //   21: ldc 135
    //   23: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 8
    //   28: aload 9
    //   30: ldc 30
    //   32: invokevirtual 143	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   35: astore_1
    //   36: new 145	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 146	java/util/ArrayList:<init>	()V
    //   43: astore 7
    //   45: aload_1
    //   46: ifnull +33 -> 79
    //   49: iconst_0
    //   50: istore_2
    //   51: iload_2
    //   52: aload_1
    //   53: invokevirtual 152	org/json/JSONArray:length	()I
    //   56: if_icmpge +23 -> 79
    //   59: aload 7
    //   61: aload_1
    //   62: iload_2
    //   63: invokevirtual 156	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   66: invokeinterface 162 2 0
    //   71: pop
    //   72: iload_2
    //   73: iconst_1
    //   74: iadd
    //   75: istore_2
    //   76: goto -25 -> 51
    //   79: aload 9
    //   81: ldc 164
    //   83: iconst_0
    //   84: invokevirtual 168	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   87: ifeq +14 -> 101
    //   90: aload_0
    //   91: ldc 169
    //   93: invokevirtual 173	com/tencent/biz/lebsearch/widget/ContactView:setBackgroundResource	(I)V
    //   96: aload_0
    //   97: iconst_1
    //   98: invokevirtual 177	com/tencent/biz/lebsearch/widget/ContactView:setClickable	(Z)V
    //   101: aload 9
    //   103: ldc 179
    //   105: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 83	com/tencent/biz/lebsearch/widget/ContactView:iconView	Landroid/widget/ImageView;
    //   113: aload_1
    //   114: aload_0
    //   115: getfield 51	com/tencent/biz/lebsearch/widget/ContactView:mContext	Landroid/content/Context;
    //   118: invokestatic 185	com/tencent/biz/lebsearch/widget/SearchViewBuilder:getImageWidthInPixels	(Landroid/content/Context;)I
    //   121: aload_0
    //   122: getfield 51	com/tencent/biz/lebsearch/widget/ContactView:mContext	Landroid/content/Context;
    //   125: invokestatic 188	com/tencent/biz/lebsearch/widget/SearchViewBuilder:getImageHeightInPixels	(Landroid/content/Context;)I
    //   128: invokestatic 194	com/tencent/biz/lebsearch/Statics:setImage	(Landroid/widget/ImageView;Ljava/lang/String;II)V
    //   131: aload 9
    //   133: ldc 196
    //   135: invokevirtual 200	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   138: istore_2
    //   139: aload_0
    //   140: getfield 83	com/tencent/biz/lebsearch/widget/ContactView:iconView	Landroid/widget/ImageView;
    //   143: aload_0
    //   144: getfield 100	com/tencent/biz/lebsearch/widget/ContactView:coverView	Landroid/widget/ImageView;
    //   147: iload_2
    //   148: invokestatic 204	com/tencent/biz/lebsearch/Statics:dealWithCover	(Landroid/widget/ImageView;Landroid/widget/ImageView;I)V
    //   151: aconst_null
    //   152: astore 5
    //   154: aconst_null
    //   155: astore_1
    //   156: aconst_null
    //   157: astore 4
    //   159: aconst_null
    //   160: astore_3
    //   161: ldc 206
    //   163: new 208	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   170: ldc 211
    //   172: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 9
    //   177: invokevirtual 219	org/json/JSONObject:toString	()Ljava/lang/String;
    //   180: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 226	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   189: pop
    //   190: aload 9
    //   192: ldc 18
    //   194: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   197: astore 10
    //   199: aload 10
    //   201: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifne +308 -> 512
    //   207: aload 10
    //   209: invokestatic 237	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   212: sipush 2049
    //   215: if_icmpne +237 -> 452
    //   218: aload 9
    //   220: ldc 15
    //   222: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   225: astore_1
    //   226: aload_1
    //   227: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: ifeq +265 -> 495
    //   233: aload_0
    //   234: getfield 91	com/tencent/biz/lebsearch/widget/ContactView:briefView	Landroid/widget/TextView;
    //   237: bipush 8
    //   239: invokevirtual 240	android/widget/TextView:setVisibility	(I)V
    //   242: aload 9
    //   244: ldc 24
    //   246: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 4
    //   251: aload 9
    //   253: ldc 21
    //   255: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   258: astore_3
    //   259: aload 9
    //   261: ldc 242
    //   263: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   266: astore 9
    //   268: new 244	com/tencent/biz/lebsearch/widget/HighlightModel
    //   271: dup
    //   272: aload 7
    //   274: aload 9
    //   276: invokespecial 247	com/tencent/biz/lebsearch/widget/HighlightModel:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   279: aload 8
    //   281: iconst_1
    //   282: invokevirtual 251	com/tencent/biz/lebsearch/widget/HighlightModel:getHighlightWords	(Ljava/lang/String;Z)Landroid/text/SpannableString;
    //   285: astore 5
    //   287: aload 5
    //   289: ifnull +26 -> 315
    //   292: aload_0
    //   293: getfield 88	com/tencent/biz/lebsearch/widget/ContactView:titleView	Landroid/widget/TextView;
    //   296: aload 5
    //   298: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   301: aload 6
    //   303: aload 5
    //   305: invokevirtual 258	java/lang/StringBuffer:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuffer;
    //   308: ldc_w 260
    //   311: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   314: pop
    //   315: new 244	com/tencent/biz/lebsearch/widget/HighlightModel
    //   318: dup
    //   319: aload 7
    //   321: aload 9
    //   323: invokespecial 247	com/tencent/biz/lebsearch/widget/HighlightModel:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   326: astore 7
    //   328: aload_1
    //   329: invokestatic 268	com/tencent/biz/lebsearch/util/PatternUtil:getStrRemoveSpace	(Ljava/lang/String;)Ljava/lang/String;
    //   332: astore_1
    //   333: aload 7
    //   335: aload_1
    //   336: invokevirtual 271	com/tencent/biz/lebsearch/widget/HighlightModel:getHighlightWords	(Ljava/lang/String;)Landroid/text/SpannableString;
    //   339: astore 7
    //   341: aload_0
    //   342: getfield 88	com/tencent/biz/lebsearch/widget/ContactView:titleView	Landroid/widget/TextView;
    //   345: aload_0
    //   346: getfield 91	com/tencent/biz/lebsearch/widget/ContactView:briefView	Landroid/widget/TextView;
    //   349: aload 5
    //   351: aconst_null
    //   352: invokestatic 275	com/tencent/biz/lebsearch/Statics:dealTitleAndSecondText	(Landroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/CharSequence;Landroid/widget/TextView;)V
    //   355: aload 7
    //   357: ifnull +33 -> 390
    //   360: aload_0
    //   361: getfield 91	com/tencent/biz/lebsearch/widget/ContactView:briefView	Landroid/widget/TextView;
    //   364: aload 7
    //   366: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   369: aload_0
    //   370: getfield 91	com/tencent/biz/lebsearch/widget/ContactView:briefView	Landroid/widget/TextView;
    //   373: iconst_0
    //   374: invokevirtual 240	android/widget/TextView:setVisibility	(I)V
    //   377: aload 6
    //   379: aload_1
    //   380: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   383: ldc_w 260
    //   386: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   389: pop
    //   390: aload_0
    //   391: getfield 94	com/tencent/biz/lebsearch/widget/ContactView:fromView	Landroid/widget/TextView;
    //   394: aload 4
    //   396: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   399: aload 6
    //   401: aload 4
    //   403: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   406: ldc_w 260
    //   409: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   412: pop
    //   413: aload_3
    //   414: invokestatic 281	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   417: invokestatic 287	com/tencent/biz/lebsearch/util/DateUtil:getDateString	(J)Ljava/lang/String;
    //   420: astore_1
    //   421: aload_0
    //   422: getfield 97	com/tencent/biz/lebsearch/widget/ContactView:timeView	Landroid/widget/TextView;
    //   425: aload_1
    //   426: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   429: aload 6
    //   431: aload_1
    //   432: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   435: ldc_w 260
    //   438: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   441: pop
    //   442: aload_0
    //   443: getfield 119	com/tencent/biz/lebsearch/widget/ContactView:rootView	Landroid/view/View;
    //   446: aload 6
    //   448: invokevirtual 290	android/view/View:setContentDescription	(Ljava/lang/CharSequence;)V
    //   451: return
    //   452: aload 10
    //   454: invokestatic 237	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   457: bipush 64
    //   459: if_icmpne +14 -> 473
    //   462: aload 9
    //   464: ldc 33
    //   466: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   469: astore_1
    //   470: goto -244 -> 226
    //   473: aload 10
    //   475: invokestatic 237	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   478: sipush 4096
    //   481: if_icmpne -255 -> 226
    //   484: aload 9
    //   486: ldc 27
    //   488: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: astore_1
    //   492: goto -266 -> 226
    //   495: aload_0
    //   496: getfield 91	com/tencent/biz/lebsearch/widget/ContactView:briefView	Landroid/widget/TextView;
    //   499: iconst_0
    //   500: invokevirtual 240	android/widget/TextView:setVisibility	(I)V
    //   503: goto -261 -> 242
    //   506: astore_1
    //   507: aload_1
    //   508: invokevirtual 293	org/json/JSONException:printStackTrace	()V
    //   511: return
    //   512: ldc 206
    //   514: ldc_w 295
    //   517: invokestatic 226	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   520: pop
    //   521: aload 5
    //   523: astore_1
    //   524: goto -265 -> 259
    //   527: astore_1
    //   528: ldc_w 297
    //   531: new 208	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   538: aload_1
    //   539: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   542: ldc_w 302
    //   545: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 305	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   554: pop
    //   555: aload_3
    //   556: astore_1
    //   557: goto -136 -> 421
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	this	ContactView
    //   0	560	1	paramString	String
    //   50	98	2	i	int
    //   160	396	3	str1	String
    //   157	245	4	str2	String
    //   152	370	5	localSpannableString	android.text.SpannableString
    //   7	440	6	localStringBuffer	java.lang.StringBuffer
    //   43	322	7	localObject1	java.lang.Object
    //   26	254	8	str3	String
    //   17	468	9	localObject2	java.lang.Object
    //   197	277	10	str4	String
    // Exception table:
    //   from	to	target	type
    //   0	45	506	org/json/JSONException
    //   51	72	506	org/json/JSONException
    //   79	101	506	org/json/JSONException
    //   101	151	506	org/json/JSONException
    //   161	226	506	org/json/JSONException
    //   226	242	506	org/json/JSONException
    //   242	259	506	org/json/JSONException
    //   259	287	506	org/json/JSONException
    //   292	315	506	org/json/JSONException
    //   315	355	506	org/json/JSONException
    //   360	390	506	org/json/JSONException
    //   390	413	506	org/json/JSONException
    //   413	421	506	org/json/JSONException
    //   421	451	506	org/json/JSONException
    //   452	470	506	org/json/JSONException
    //   473	492	506	org/json/JSONException
    //   495	503	506	org/json/JSONException
    //   512	521	506	org/json/JSONException
    //   528	555	506	org/json/JSONException
    //   413	421	527	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.ContactView
 * JD-Core Version:    0.7.0.1
 */