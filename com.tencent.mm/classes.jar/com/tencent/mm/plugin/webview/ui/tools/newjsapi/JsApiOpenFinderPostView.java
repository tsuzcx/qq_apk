package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "openFinderPostView", "OpenFinderPostViewTask", "OpenFinderViewTaskData", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiOpenFinderPostView
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final JsApiOpenFinderPostView XnA;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297538);
    XnA = new JsApiOpenFinderPostView();
    OOk = 416;
    idA = "openFinderPostView";
    AppMethodBeat.o(297538);
  }
  
  private static final void c(h paramh, p paramp, IPCBoolean paramIPCBoolean)
  {
    AppMethodBeat.i(297532);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    HashMap localHashMap = new HashMap();
    if (paramIPCBoolean.value)
    {
      localHashMap.put("code", Integer.valueOf(100));
      localHashMap.put("message", "post successful");
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localHashMap);
      AppMethodBeat.o(297532);
      return;
    }
    localHashMap.put("code", Integer.valueOf(200));
    localHashMap.put("message", "post cancel");
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), (Map)localHashMap);
    AppMethodBeat.o(297532);
  }
  
  /* Error */
  private static boolean l(h paramh, p paramp)
  {
    // Byte code:
    //   0: ldc 146
    //   2: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: getfield 150	com/tencent/mm/plugin/webview/jsapi/p:params	Ljava/util/Map;
    //   9: ldc 152
    //   11: invokeinterface 156 2 0
    //   16: checkcast 158	java/lang/String
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull +264 -> 285
    //   24: ldc 159
    //   26: astore_2
    //   27: aload_1
    //   28: getfield 150	com/tencent/mm/plugin/webview/jsapi/p:params	Ljava/util/Map;
    //   31: ldc 161
    //   33: invokeinterface 156 2 0
    //   38: checkcast 158	java/lang/String
    //   41: astore_3
    //   42: aload_3
    //   43: ifnonnull +245 -> 288
    //   46: ldc 159
    //   48: astore_3
    //   49: aload_1
    //   50: getfield 150	com/tencent/mm/plugin/webview/jsapi/p:params	Ljava/util/Map;
    //   53: ldc 163
    //   55: invokeinterface 156 2 0
    //   60: checkcast 158	java/lang/String
    //   63: astore 4
    //   65: aload 4
    //   67: ifnonnull +224 -> 291
    //   70: ldc 159
    //   72: astore 4
    //   74: aload_1
    //   75: getfield 150	com/tencent/mm/plugin/webview/jsapi/p:params	Ljava/util/Map;
    //   78: ldc 165
    //   80: invokeinterface 156 2 0
    //   85: checkcast 158	java/lang/String
    //   88: astore 6
    //   90: aload 6
    //   92: astore 5
    //   94: aload 6
    //   96: ifnonnull +7 -> 103
    //   99: ldc 159
    //   101: astore 5
    //   103: new 167	org/json/JSONObject
    //   106: dup
    //   107: invokespecial 168	org/json/JSONObject:<init>	()V
    //   110: astore 6
    //   112: aload 6
    //   114: ldc 152
    //   116: new 167	org/json/JSONObject
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 171	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   124: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   127: pop
    //   128: aload 6
    //   130: ldc 161
    //   132: new 167	org/json/JSONObject
    //   135: dup
    //   136: aload_3
    //   137: invokespecial 171	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   140: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload 6
    //   146: ldc 163
    //   148: aload 4
    //   150: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload 6
    //   156: ldc 165
    //   158: new 167	org/json/JSONObject
    //   161: dup
    //   162: aload 5
    //   164: invokespecial 171	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   167: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   170: pop
    //   171: ldc 176
    //   173: new 178	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 180
    //   179: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload_1
    //   183: getfield 150	com/tencent/mm/plugin/webview/jsapi/p:params	Ljava/util/Map;
    //   186: ldc 152
    //   188: invokeinterface 156 2 0
    //   193: checkcast 158	java/lang/String
    //   196: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: ldc 187
    //   201: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_1
    //   205: getfield 150	com/tencent/mm/plugin/webview/jsapi/p:params	Ljava/util/Map;
    //   208: ldc 161
    //   210: invokeinterface 156 2 0
    //   215: checkcast 158	java/lang/String
    //   218: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc 176
    //   229: ldc 200
    //   231: aload 6
    //   233: invokestatic 131	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   236: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: getstatic 205	com/tencent/mm/ipcinvoker/wx_extension/service/MainProcessIPCService:PROCESS_NAME	Ljava/lang/String;
    //   242: astore_2
    //   243: aload 6
    //   245: invokevirtual 206	org/json/JSONObject:toString	()Ljava/lang/String;
    //   248: astore_3
    //   249: aload_3
    //   250: ldc 208
    //   252: invokestatic 211	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   255: aload_2
    //   256: new 6	com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView$OpenFinderViewTaskData
    //   259: dup
    //   260: aload_3
    //   261: invokespecial 212	com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView$OpenFinderViewTaskData:<init>	(Ljava/lang/String;)V
    //   264: ldc 12
    //   266: new 214	com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView$$ExternalSyntheticLambda0
    //   269: dup
    //   270: aload_0
    //   271: aload_1
    //   272: invokespecial 217	com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/webview/jsapi/h;Lcom/tencent/mm/plugin/webview/jsapi/p;)V
    //   275: invokestatic 222	com/tencent/mm/ipcinvoker/extension/XIPCInvoker:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;Lcom/tencent/mm/ipcinvoker/f;)V
    //   278: ldc 146
    //   280: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_1
    //   284: ireturn
    //   285: goto -258 -> 27
    //   288: goto -239 -> 49
    //   291: goto -217 -> 74
    //   294: astore_2
    //   295: goto -124 -> 171
    //   298: astore_2
    //   299: goto -145 -> 154
    //   302: astore_2
    //   303: goto -159 -> 144
    //   306: astore_2
    //   307: goto -179 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramh	h
    //   0	310	1	paramp	p
    //   19	237	2	str1	String
    //   294	1	2	localObject1	Object
    //   298	1	2	localObject2	Object
    //   302	1	2	localObject3	Object
    //   306	1	2	localObject4	Object
    //   41	220	3	str2	String
    //   63	86	4	str3	String
    //   92	71	5	localObject5	Object
    //   88	156	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   154	171	294	finally
    //   144	154	298	finally
    //   128	144	302	finally
    //   112	128	306	finally
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297558);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.JsApiOpenFinderPostView", "openFinderPostView");
    boolean bool = l(paramh, paramp);
    AppMethodBeat.o(297558);
    return bool;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView$OpenFinderViewTaskData;", "Landroid/os/Parcelable;", "extInfo", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "json", "getJson", "()Ljava/lang/String;", "setJson", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class OpenFinderViewTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    String hMi;
    
    static
    {
      AppMethodBeat.i(297837);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(297837);
    }
    
    public OpenFinderViewTaskData(Parcel paramParcel)
    {
      AppMethodBeat.i(297832);
      this.hMi = "";
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.hMi = paramParcel;
      AppMethodBeat.o(297832);
    }
    
    public OpenFinderViewTaskData(String paramString)
    {
      AppMethodBeat.i(297821);
      this.hMi = "";
      this.hMi = paramString;
      AppMethodBeat.o(297821);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(297842);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.hMi);
      AppMethodBeat.o(297842);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView$OpenFinderViewTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView$OpenFinderViewTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView$OpenFinderViewTaskData;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiOpenFinderPostView.OpenFinderViewTaskData>
    {}
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView$OpenFinderPostViewTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderPostView$OpenFinderViewTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<JsApiOpenFinderPostView.OpenFinderViewTaskData, IPCBoolean>
  {
    private static final void b(f paramf, int paramInt, String paramString)
    {
      AppMethodBeat.i(297823);
      if (paramInt == 1)
      {
        if (paramf != null)
        {
          paramf.onCallback(new IPCBoolean(true));
          AppMethodBeat.o(297823);
        }
      }
      else if (paramf != null) {
        paramf.onCallback(new IPCBoolean(false));
      }
      AppMethodBeat.o(297823);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenFinderPostView
 * JD-Core Version:    0.7.0.1
 */