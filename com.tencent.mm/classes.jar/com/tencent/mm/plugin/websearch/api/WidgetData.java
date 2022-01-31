package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.j.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.net.URLEncoder;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WidgetData
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetData> CREATOR = new WidgetData.1();
  public String bVk;
  public MoreFooter qVn;
  public WidgetData.Info qVo;
  public WidgetData.Style qVp;
  public int qVq;
  public String qVr;
  
  public WidgetData() {}
  
  protected WidgetData(Parcel paramParcel)
  {
    this.qVn = ((MoreFooter)paramParcel.readParcelable(MoreFooter.class.getClassLoader()));
    this.qVo = ((WidgetData.Info)paramParcel.readParcelable(WidgetData.Info.class.getClassLoader()));
    this.qVp = ((WidgetData.Style)paramParcel.readParcelable(WidgetData.Style.class.getClassLoader()));
    this.qVq = paramParcel.readInt();
    this.bVk = paramParcel.readString();
    this.qVr = paramParcel.readString();
  }
  
  /* Error */
  public static WidgetData Rz(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 80	java/lang/String:length	()I
    //   8: ifne +12 -> 20
    //   11: ldc 82
    //   13: ldc 84
    //   15: invokestatic 90	com/tencent/luggage/j/c:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: aconst_null
    //   19: areturn
    //   20: invokestatic 94	com/tencent/mm/plugin/websearch/api/WidgetData:bZY	()Lcom/tencent/mm/plugin/websearch/api/WidgetData;
    //   23: astore 5
    //   25: new 96	org/json/JSONObject
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 99	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   33: astore_0
    //   34: aload 5
    //   36: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   39: aload_0
    //   40: ldc 101
    //   42: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: putfield 108	com/tencent/mm/plugin/websearch/api/WidgetData$Info:bOL	Ljava/lang/String;
    //   48: aload 5
    //   50: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   53: aload_0
    //   54: ldc 110
    //   56: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   59: putfield 116	com/tencent/mm/plugin/websearch/api/WidgetData$Info:version	I
    //   62: aload 5
    //   64: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   67: aload_0
    //   68: ldc 118
    //   70: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   73: putfield 121	com/tencent/mm/plugin/websearch/api/WidgetData$Info:aVr	Ljava/lang/String;
    //   76: aload 5
    //   78: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   81: aload_0
    //   82: ldc 123
    //   84: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: putfield 126	com/tencent/mm/plugin/websearch/api/WidgetData$Info:userName	Ljava/lang/String;
    //   90: aload 5
    //   92: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   95: aload_0
    //   96: ldc 128
    //   98: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: putfield 131	com/tencent/mm/plugin/websearch/api/WidgetData$Info:dZY	Ljava/lang/String;
    //   104: aload 5
    //   106: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   109: aload_0
    //   110: ldc 133
    //   112: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: putfield 136	com/tencent/mm/plugin/websearch/api/WidgetData$Info:qVs	Ljava/lang/String;
    //   118: aload 5
    //   120: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   123: aload_0
    //   124: ldc 138
    //   126: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: putfield 141	com/tencent/mm/plugin/websearch/api/WidgetData$Info:bFw	Ljava/lang/String;
    //   132: aload 5
    //   134: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   137: aload_0
    //   138: ldc 143
    //   140: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 146	com/tencent/mm/plugin/websearch/api/WidgetData$Info:qVt	Ljava/lang/String;
    //   146: aload 5
    //   148: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   151: aload_0
    //   152: ldc 148
    //   154: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: putfield 151	com/tencent/mm/plugin/websearch/api/WidgetData$Info:qVu	Ljava/lang/String;
    //   160: aload 5
    //   162: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   165: aload_0
    //   166: ldc 153
    //   168: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: invokestatic 158	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   174: putfield 161	com/tencent/mm/plugin/websearch/api/WidgetData$Info:dWx	I
    //   177: aload 5
    //   179: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   182: astore 6
    //   184: aload_0
    //   185: ldc 163
    //   187: invokevirtual 167	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   190: ifne +254 -> 444
    //   193: iconst_0
    //   194: istore_3
    //   195: aload 6
    //   197: iload_3
    //   198: putfield 170	com/tencent/mm/plugin/websearch/api/WidgetData$Info:qVv	I
    //   201: aload 5
    //   203: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   206: aload_0
    //   207: ldc 172
    //   209: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 175	com/tencent/mm/plugin/websearch/api/WidgetData$Info:fTF	Ljava/lang/String;
    //   215: aload_0
    //   216: ldc 177
    //   218: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   221: astore 6
    //   223: aload 6
    //   225: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +39 -> 267
    //   231: new 96	org/json/JSONObject
    //   234: dup
    //   235: aload 6
    //   237: invokespecial 99	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   240: astore 6
    //   242: aload 6
    //   244: ldc 185
    //   246: invokevirtual 167	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   249: ifeq +18 -> 267
    //   252: aload 5
    //   254: getfield 55	com/tencent/mm/plugin/websearch/api/WidgetData:qVo	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Info;
    //   257: aload 6
    //   259: ldc 185
    //   261: invokevirtual 189	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   264: putfield 193	com/tencent/mm/plugin/websearch/api/WidgetData$Info:qVy	J
    //   267: aload 5
    //   269: getfield 57	com/tencent/mm/plugin/websearch/api/WidgetData:qVp	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Style;
    //   272: astore 6
    //   274: aload_0
    //   275: ldc 195
    //   277: invokevirtual 167	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   280: ifeq +192 -> 472
    //   283: aload_0
    //   284: ldc 195
    //   286: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   289: istore_3
    //   290: aload 6
    //   292: iload_3
    //   293: putfield 198	com/tencent/mm/plugin/websearch/api/WidgetData$Style:qVE	I
    //   296: aload 5
    //   298: getfield 57	com/tencent/mm/plugin/websearch/api/WidgetData:qVp	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Style;
    //   301: aload_0
    //   302: ldc 200
    //   304: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   307: putfield 202	com/tencent/mm/plugin/websearch/api/WidgetData$Style:height	I
    //   310: aload 5
    //   312: getfield 57	com/tencent/mm/plugin/websearch/api/WidgetData:qVp	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Style;
    //   315: aload_0
    //   316: ldc 204
    //   318: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   321: putfield 206	com/tencent/mm/plugin/websearch/api/WidgetData$Style:width	I
    //   324: aload 5
    //   326: getfield 57	com/tencent/mm/plugin/websearch/api/WidgetData:qVp	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Style;
    //   329: aload_0
    //   330: ldc 208
    //   332: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: putfield 211	com/tencent/mm/plugin/websearch/api/WidgetData$Style:fNR	Ljava/lang/String;
    //   338: aload 5
    //   340: getfield 57	com/tencent/mm/plugin/websearch/api/WidgetData:qVp	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Style;
    //   343: astore 6
    //   345: aload_0
    //   346: ldc 213
    //   348: invokevirtual 167	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   351: ifeq +127 -> 478
    //   354: aload_0
    //   355: ldc 213
    //   357: invokevirtual 217	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   360: dstore_1
    //   361: aload 6
    //   363: dload_1
    //   364: putfield 221	com/tencent/mm/plugin/websearch/api/WidgetData$Style:qVD	D
    //   367: aload 5
    //   369: getfield 57	com/tencent/mm/plugin/websearch/api/WidgetData:qVp	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Style;
    //   372: aload_0
    //   373: ldc 223
    //   375: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   378: putfield 225	com/tencent/mm/plugin/websearch/api/WidgetData$Style:offsetX	I
    //   381: aload 5
    //   383: getfield 57	com/tencent/mm/plugin/websearch/api/WidgetData:qVp	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Style;
    //   386: aload_0
    //   387: ldc 227
    //   389: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   392: putfield 229	com/tencent/mm/plugin/websearch/api/WidgetData$Style:offsetY	I
    //   395: aload 5
    //   397: getfield 57	com/tencent/mm/plugin/websearch/api/WidgetData:qVp	Lcom/tencent/mm/plugin/websearch/api/WidgetData$Style;
    //   400: astore 6
    //   402: aload_0
    //   403: ldc 231
    //   405: invokevirtual 167	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   408: ifeq +75 -> 483
    //   411: aload_0
    //   412: ldc 231
    //   414: invokevirtual 234	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   417: istore 4
    //   419: aload 6
    //   421: iload 4
    //   423: putfield 238	com/tencent/mm/plugin/websearch/api/WidgetData$Style:qVF	Z
    //   426: aload 5
    //   428: areturn
    //   429: astore_0
    //   430: ldc 82
    //   432: aload_0
    //   433: ldc 240
    //   435: iconst_0
    //   436: anewarray 4	java/lang/Object
    //   439: invokestatic 244	com/tencent/luggage/j/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: aconst_null
    //   443: areturn
    //   444: aload_0
    //   445: ldc 163
    //   447: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   450: istore_3
    //   451: goto -256 -> 195
    //   454: astore 6
    //   456: ldc 82
    //   458: aload 6
    //   460: ldc 240
    //   462: iconst_0
    //   463: anewarray 4	java/lang/Object
    //   466: invokestatic 244	com/tencent/luggage/j/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   469: goto -202 -> 267
    //   472: ldc 245
    //   474: istore_3
    //   475: goto -185 -> 290
    //   478: dconst_0
    //   479: dstore_1
    //   480: goto -119 -> 361
    //   483: iconst_1
    //   484: istore 4
    //   486: goto -67 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	paramString	String
    //   360	120	1	d	double
    //   194	281	3	i	int
    //   417	68	4	bool	boolean
    //   23	404	5	localWidgetData	WidgetData
    //   182	238	6	localObject	Object
    //   454	5	6	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   25	193	429	org/json/JSONException
    //   195	223	429	org/json/JSONException
    //   267	290	429	org/json/JSONException
    //   290	361	429	org/json/JSONException
    //   361	419	429	org/json/JSONException
    //   419	426	429	org/json/JSONException
    //   444	451	429	org/json/JSONException
    //   456	469	429	org/json/JSONException
    //   223	267	454	org/json/JSONException
  }
  
  private static WidgetData bZY()
  {
    WidgetData localWidgetData = new WidgetData();
    localWidgetData.qVo = new WidgetData.Info();
    localWidgetData.qVp = new WidgetData.Style();
    return localWidgetData;
  }
  
  public static WidgetData m(JSONObject paramJSONObject, String paramString)
  {
    int i = 1;
    WidgetData localWidgetData = bZY();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("boxInfo").getJSONObject("providerInfo");
        if (localJSONObject == null) {
          return null;
        }
        localWidgetData.qVo.bOL = paramJSONObject.optString("appID");
        localWidgetData.qVo.version = paramJSONObject.optInt("appVersion");
        localWidgetData.qVo.qVw = paramJSONObject.optString("docID");
        localWidgetData.qVo.iconUrl = paramJSONObject.optString("iconUrl");
        localWidgetData.qVo.aVr = paramJSONObject.optString("nickName");
        localWidgetData.qVo.userName = paramJSONObject.optString("username");
        Object localObject1 = URLEncoder.encode(localJSONObject.optString("widgetData"));
        localWidgetData.qVo.qVs = ("widgetData=" + (String)localObject1);
        localWidgetData.qVo.bFw = (localJSONObject.optString("jumpUrl") + "&" + localWidgetData.qVo.qVs);
        localWidgetData.qVo.qVt = localJSONObject.optString("wxaData");
        localWidgetData.qVo.dWx = localJSONObject.optInt("type");
        try
        {
          localObject1 = localJSONObject.optString("relay_info");
          if (localObject1 != null)
          {
            localObject1 = new JSONObject((String)localObject1);
            localWidgetData.qVo.qVx = ((JSONObject)localObject1).optString("widget_stat_buffer");
            localWidgetData.qVo.downloadUrl = ((JSONObject)localObject1).optString("downloadurl");
            localWidgetData.qVo.qVu = ((JSONObject)localObject1).optString("launchwxawidget");
            localWidgetData.qVo.qVv = ((JSONObject)localObject1).optInt("widget_version_type");
            localWidgetData.qVo.dZY = ((JSONObject)localObject1).optString("appid");
            Object localObject2 = ((JSONObject)localObject1).optJSONArray("widget_labels");
            if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
              continue;
            }
            localWidgetData.qVo.label = ((JSONArray)localObject2).optString(0);
            localObject2 = localWidgetData.qVo;
            if (((JSONObject)localObject1).optInt("need_localsearch_footer") != 1) {
              break label652;
            }
            bool = true;
            ((WidgetData.Info)localObject2).qVA = bool;
            localWidgetData.qVo.qVz = ((JSONObject)localObject1).optString("localsearch_header");
            localWidgetData.qVo.ilQ = ((JSONObject)localObject1).optString("localsearch_footer");
            localWidgetData.qVo.qVy = ((JSONObject)localObject1).optLong("openapp_permission");
            if (!((JSONObject)localObject1).has("footer")) {
              break label719;
            }
            localObject1 = ((JSONObject)localObject1).optJSONObject("footer");
            if (((JSONObject)localObject1).has("type")) {
              i = ((JSONObject)localObject1).optInt("type");
            }
            localWidgetData.qVq = i;
            switch (localWidgetData.qVq)
            {
            case 2: 
              c.w("WidgetData", "unknow footer type %d", new Object[] { Integer.valueOf(localWidgetData.qVq) });
            }
          }
        }
        catch (JSONException localJSONException)
        {
          c.printErrStackTrace("WidgetData", localJSONException, "", new Object[0]);
          continue;
        }
        localWidgetData.qVo.fTF = paramString;
        localWidgetData.qVp.qVE = paramJSONObject.optInt("maxHeight");
        localWidgetData.qVp.height = a.ad(ae.getContext(), localJSONObject.optInt("height"));
        localWidgetData.qVp.width = a.ad(ae.getContext(), localJSONObject.optInt("width"));
        return localWidgetData;
      }
      catch (JSONException paramJSONObject)
      {
        c.printErrStackTrace("WidgetData", paramJSONObject, "", new Object[0]);
        return null;
      }
      localWidgetData.qVo.label = null;
      continue;
      label652:
      boolean bool = false;
      continue;
      localWidgetData.qVn = new MoreFooter();
      localWidgetData.qVn.title = localJSONException.optString("title");
      localWidgetData.qVn.qVB = localJSONException.optString("username");
      localWidgetData.qVn.qVC = localJSONException.optString("jumpurl");
      continue;
      label719:
      localWidgetData.qVq = 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof WidgetData)) {
        return false;
      }
      paramObject = (WidgetData)paramObject;
    } while ((this.qVq == paramObject.qVq) && (Objects.equals(this.qVn, paramObject.qVn)) && (Objects.equals(this.qVo, paramObject.qVo)) && (Objects.equals(this.qVp, paramObject.qVp)) && (Objects.equals(this.bVk, paramObject.bVk)) && (Objects.equals(this.qVr, paramObject.qVr)));
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.qVn, this.qVo, this.qVp, Integer.valueOf(this.qVq), this.bVk, this.qVr });
  }
  
  public String toString()
  {
    String str1;
    if (this.qVo == null)
    {
      str1 = "";
      if (this.qVp != null) {
        break label50;
      }
    }
    label50:
    for (String str2 = "";; str2 = this.qVp.toString())
    {
      return String.format("info: [%s], style:[%s]", new Object[] { str1, str2 });
      str1 = this.qVo.toString();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.qVn, paramInt);
    paramParcel.writeParcelable(this.qVo, paramInt);
    paramParcel.writeParcelable(this.qVp, paramInt);
    paramParcel.writeInt(this.qVq);
    paramParcel.writeString(this.bVk);
    paramParcel.writeString(this.qVr);
  }
  
  public static class MoreFooter
    implements Parcelable
  {
    public static final Parcelable.Creator<MoreFooter> CREATOR = new WidgetData.MoreFooter.1();
    public String qVB;
    public String qVC;
    public String title;
    
    public MoreFooter() {}
    
    protected MoreFooter(Parcel paramParcel)
    {
      this.title = paramParcel.readString();
      this.qVB = paramParcel.readString();
      this.qVC = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof MoreFooter)) {
          return false;
        }
        paramObject = (MoreFooter)paramObject;
      } while ((Objects.equals(this.title, paramObject.title)) && (Objects.equals(this.qVB, paramObject.qVB)) && (Objects.equals(this.qVC, paramObject.qVC)));
      return false;
    }
    
    public int hashCode()
    {
      return Objects.hash(new Object[] { this.title, this.qVB, this.qVC });
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.qVB);
      paramParcel.writeString(this.qVC);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData
 * JD-Core Version:    0.7.0.1
 */