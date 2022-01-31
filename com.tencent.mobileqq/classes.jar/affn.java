import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class affn
  extends WebViewPlugin
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener
{
  private bbjq jdField_a_of_type_Bbjq;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public affn()
  {
    this.mPluginNameSpace = "newLogin";
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
    localIntent.putExtra("sms_body", paramString);
    this.mRuntime.a().startActivity(localIntent);
  }
  
  private List<bbjs>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    bbjs localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696716);
    localbbjs.jdField_b_of_type_Int = 2130838758;
    localbbjs.c = 9;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696699);
    localbbjs.jdField_b_of_type_Int = 2130838752;
    localbbjs.c = 10;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = ajya.a(2131705837);
    localbbjs.jdField_b_of_type_Int = 2130838750;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.c = 1;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696688);
    localbbjs.jdField_b_of_type_Int = 2130838750;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.c = 1;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user denied = sms");
    bcql.a(this.mRuntime.a(), ajya.a(2131705835), 1).a();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user grant = sms");
    if (!TextUtils.isEmpty(this.c)) {
      a(this.c);
    }
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +57 -> 60
    //   6: ldc 124
    //   8: iconst_2
    //   9: new 163	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   16: ldc 166
    //   18: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 172
    //   27: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload 4
    //   32: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 174
    //   37: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_3
    //   41: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 176
    //   46: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 5
    //   51: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 186	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: ldc 19
    //   62: aload_3
    //   63: invokevirtual 191	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifne +5 -> 71
    //   69: iconst_0
    //   70: ireturn
    //   71: ldc 193
    //   73: aload 4
    //   75: invokevirtual 197	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   78: ifeq +121 -> 199
    //   81: aload 5
    //   83: ifnull +10 -> 93
    //   86: aload 5
    //   88: arraylength
    //   89: iconst_1
    //   90: if_icmpeq +5 -> 95
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 5
    //   97: iconst_0
    //   98: aaload
    //   99: astore_1
    //   100: new 199	org/json/JSONObject
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 201	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   108: astore_1
    //   109: aload_1
    //   110: ldc 203
    //   112: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_2
    //   116: aload_0
    //   117: aload_1
    //   118: ldc 208
    //   120: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: putfield 209	affn:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   126: getstatic 214	android/os/Build$VERSION:SDK_INT	I
    //   129: bipush 23
    //   131: if_icmplt +60 -> 191
    //   134: aload_0
    //   135: getfield 55	affn:mRuntime	Lbcdp;
    //   138: invokevirtual 60	bcdp:a	()Landroid/app/Activity;
    //   141: ldc 216
    //   143: invokevirtual 220	android/app/Activity:checkSelfPermission	(Ljava/lang/String;)I
    //   146: ifeq +37 -> 183
    //   149: aload_0
    //   150: aload_2
    //   151: putfield 149	affn:c	Ljava/lang/String;
    //   154: aload_0
    //   155: getfield 55	affn:mRuntime	Lbcdp;
    //   158: invokevirtual 60	bcdp:a	()Landroid/app/Activity;
    //   161: checkcast 222	mqq/app/AppActivity
    //   164: aload_0
    //   165: iconst_1
    //   166: iconst_1
    //   167: anewarray 188	java/lang/String
    //   170: dup
    //   171: iconst_0
    //   172: ldc 216
    //   174: aastore
    //   175: invokevirtual 226	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   178: iconst_1
    //   179: ireturn
    //   180: astore_1
    //   181: iconst_0
    //   182: ireturn
    //   183: aload_0
    //   184: aload_2
    //   185: invokespecial 151	affn:a	(Ljava/lang/String;)V
    //   188: goto -10 -> 178
    //   191: aload_0
    //   192: aload_2
    //   193: invokespecial 151	affn:a	(Ljava/lang/String;)V
    //   196: goto -18 -> 178
    //   199: ldc 228
    //   201: aload 4
    //   203: invokevirtual 197	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   206: ifeq -28 -> 178
    //   209: aload 5
    //   211: ifnull +10 -> 221
    //   214: aload 5
    //   216: arraylength
    //   217: iconst_1
    //   218: if_icmpeq +5 -> 223
    //   221: iconst_0
    //   222: ireturn
    //   223: aload 5
    //   225: iconst_0
    //   226: aaload
    //   227: astore_1
    //   228: aload_0
    //   229: new 199	org/json/JSONObject
    //   232: dup
    //   233: aload_1
    //   234: invokespecial 201	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: ldc 208
    //   239: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: putfield 229	affn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   245: aload_0
    //   246: getfield 55	affn:mRuntime	Lbcdp;
    //   249: invokevirtual 60	bcdp:a	()Landroid/app/Activity;
    //   252: astore_1
    //   253: aload_0
    //   254: getfield 231	affn:jdField_a_of_type_Bbjq	Lbbjq;
    //   257: ifnonnull +15 -> 272
    //   260: aload_0
    //   261: new 233	bbjq
    //   264: dup
    //   265: aload_1
    //   266: invokespecial 236	bbjq:<init>	(Landroid/content/Context;)V
    //   269: putfield 231	affn:jdField_a_of_type_Bbjq	Lbbjq;
    //   272: aload_0
    //   273: getfield 231	affn:jdField_a_of_type_Bbjq	Lbbjq;
    //   276: ldc 237
    //   278: invokestatic 107	ajya:a	(I)Ljava/lang/String;
    //   281: invokevirtual 240	bbjq:a	(Ljava/lang/CharSequence;)V
    //   284: aload_0
    //   285: getfield 231	affn:jdField_a_of_type_Bbjq	Lbbjq;
    //   288: aload_0
    //   289: invokespecial 242	affn:a	()[Ljava/util/List;
    //   292: invokevirtual 245	bbjq:a	([Ljava/util/List;)V
    //   295: aload_0
    //   296: getfield 231	affn:jdField_a_of_type_Bbjq	Lbbjq;
    //   299: aload_0
    //   300: invokevirtual 248	bbjq:a	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   303: aload_0
    //   304: getfield 231	affn:jdField_a_of_type_Bbjq	Lbbjq;
    //   307: aload_0
    //   308: invokevirtual 251	bbjq:a	(Landroid/content/DialogInterface$OnDismissListener;)V
    //   311: aload_1
    //   312: invokevirtual 254	android/app/Activity:isFinishing	()Z
    //   315: ifne +78 -> 393
    //   318: aload_0
    //   319: getfield 231	affn:jdField_a_of_type_Bbjq	Lbbjq;
    //   322: invokevirtual 256	bbjq:a	()V
    //   325: aconst_null
    //   326: ldc_w 258
    //   329: ldc 94
    //   331: ldc 94
    //   333: ldc_w 260
    //   336: ldc_w 260
    //   339: iconst_0
    //   340: iconst_0
    //   341: ldc 94
    //   343: ldc 94
    //   345: ldc 94
    //   347: ldc 94
    //   349: invokestatic 265	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   352: iconst_1
    //   353: ireturn
    //   354: astore_1
    //   355: iconst_0
    //   356: ireturn
    //   357: astore_1
    //   358: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq -9 -> 352
    //   364: ldc 124
    //   366: iconst_2
    //   367: new 163	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   374: ldc_w 267
    //   377: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_1
    //   381: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: goto -38 -> 352
    //   393: iconst_0
    //   394: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	affn
    //   0	395	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	395	2	paramString1	String
    //   0	395	3	paramString2	String
    //   0	395	4	paramString3	String
    //   0	395	5	paramVarArgs	String[]
    // Exception table:
    //   from	to	target	type
    //   100	126	180	org/json/JSONException
    //   228	245	354	org/json/JSONException
    //   318	352	357	java/lang/Exception
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramInt) });
    paramAdapterView = "";
    if (paramInt == 0) {
      paramAdapterView = "0X80096FA";
    }
    for (;;)
    {
      if (!"".equals(paramAdapterView)) {
        axqy.b(null, "dc00898", "", "", paramAdapterView, paramAdapterView, 0, 0, "", "", "", "");
      }
      return;
      if (paramInt == 1) {
        paramAdapterView = "0X80096FB";
      } else if (paramInt == 2) {
        paramAdapterView = "0X80096FC";
      } else if (paramInt == 3) {
        paramAdapterView = "0X80096FD";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     affn
 * JD-Core Version:    0.7.0.1
 */