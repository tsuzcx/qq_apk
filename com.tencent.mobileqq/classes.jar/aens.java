import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class aens
  implements aenz, View.OnClickListener
{
  private aent jdField_a_of_type_Aent;
  private aeob jdField_a_of_type_Aeob;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public aens(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aeob paramaeob, BaseChatPie paramBaseChatPie, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Aeob = paramaeob;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public static aent a(QQAppInterface paramQQAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0);
    if (localSharedPreferences != null)
    {
      paramQQAppInterface = localSharedPreferences.getString("selfuin_" + paramQQAppInterface.getCurrentAccountUin() + "_puin_" + paramString + "_msgdata", null);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        try
        {
          paramQQAppInterface = new aent(new JSONObject(paramQQAppInterface));
          return paramQQAppInterface;
        }
        catch (JSONException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PubAccountTips", 2, "getLastPATipsMsg JSONException:", paramQQAppInterface);
          }
        }
      }
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, aent paramaent, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PubAccountTips", 2, "refreshLocalTips. puin:" + paramString1 + " ,pushData:" + paramString2);
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0);
    if (paramaent != null)
    {
      paramQQAppInterface.a().b(paramString1, 1008, paramaent.jdField_d_of_type_Long, true);
      if (QLog.isColorLevel()) {
        QLog.i("PubAccountTips", 2, "removeMsgByUniseq. uniqSeqno:" + paramaent.jdField_d_of_type_Long);
      }
    }
    paramaent = localSharedPreferences.edit();
    paramQQAppInterface = "selfuin_" + paramQQAppInterface.getCurrentAccountUin() + "_puin_" + paramString1 + "_msgdata";
    if (paramString2 != null) {
      paramaent.putString(paramQQAppInterface, paramString2);
    }
    for (;;)
    {
      paramaent.commit();
      return;
      paramaent.remove(paramQQAppInterface);
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 155	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody
    //   8: dup
    //   9: invokespecial 156	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: aload_1
    //   15: invokevirtual 160	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   18: checkcast 155	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody
    //   21: astore_1
    //   22: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +64 -> 89
    //   28: ldc 98
    //   30: iconst_2
    //   31: new 50	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   38: ldc 162
    //   40: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: getfield 166	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   47: invokevirtual 172	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   50: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 177
    //   55: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: getfield 181	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:bytes_push_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: ldc 191
    //   70: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: getfield 195	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:uint64_timestamp	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   77: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   80: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload_1
    //   90: getfield 166	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   96: ifeq -92 -> 4
    //   99: aload_1
    //   100: getfield 181	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:bytes_push_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: invokevirtual 206	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   106: ifeq -102 -> 4
    //   109: aload_1
    //   110: getfield 166	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   113: invokevirtual 172	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   116: istore_2
    //   117: iload_2
    //   118: iconst_1
    //   119: if_icmpne -115 -> 4
    //   122: new 84	org/json/JSONObject
    //   125: dup
    //   126: new 208	java/lang/String
    //   129: dup
    //   130: aload_1
    //   131: getfield 181	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:bytes_push_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   134: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   137: invokevirtual 214	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   140: ldc 216
    //   142: invokespecial 219	java/lang/String:<init>	([BLjava/lang/String;)V
    //   145: invokespecial 87	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore_1
    //   149: new 82	aent
    //   152: dup
    //   153: aload_1
    //   154: invokespecial 90	aent:<init>	(Lorg/json/JSONObject;)V
    //   157: astore_3
    //   158: aload_3
    //   159: invokevirtual 221	aent:a	()Z
    //   162: ifeq -158 -> 4
    //   165: aload_3
    //   166: getfield 224	aent:jdField_b_of_type_Int	I
    //   169: iconst_1
    //   170: if_icmpne +145 -> 315
    //   173: sipush -2011
    //   176: invokestatic 229	awbi:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   179: checkcast 231	com/tencent/mobileqq/data/MessageForStructing
    //   182: astore 4
    //   184: aload_0
    //   185: invokevirtual 61	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   188: astore 5
    //   190: new 50	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   197: ldc 233
    //   199: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_3
    //   203: getfield 235	aent:jdField_a_of_type_Long	J
    //   206: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   209: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: astore 7
    //   214: aload_3
    //   215: getfield 238	aent:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   218: astore 6
    //   220: aload 4
    //   222: aload 5
    //   224: aload 7
    //   226: aload 7
    //   228: aload 6
    //   230: lconst_0
    //   231: sipush -2011
    //   234: sipush 1008
    //   237: lconst_0
    //   238: invokevirtual 242	com/tencent/mobileqq/data/MessageForStructing:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   241: invokestatic 247	awuw:a	()Lcom/tencent/mobileqq/structmsg/StructMsgForGeneralShare;
    //   244: astore 7
    //   246: aload 7
    //   248: aload 6
    //   250: putfield 252	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgBrief	Ljava/lang/String;
    //   253: aload 7
    //   255: aload_3
    //   256: getfield 255	aent:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   259: putfield 258	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   262: aload 7
    //   264: bipush 85
    //   266: putfield 261	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   269: aload 4
    //   271: aload 7
    //   273: putfield 265	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   276: aload 4
    //   278: ldc_w 267
    //   281: ldc_w 269
    //   284: invokevirtual 273	com/tencent/mobileqq/data/MessageForStructing:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_0
    //   288: invokevirtual 116	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   291: aload 4
    //   293: aload 5
    //   295: iconst_1
    //   296: iconst_1
    //   297: iconst_1
    //   298: iconst_0
    //   299: invokevirtual 276	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;ZZZZ)V
    //   302: aload_1
    //   303: ldc_w 278
    //   306: aload 4
    //   308: getfield 281	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   311: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   314: pop
    //   315: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +44 -> 362
    //   321: ldc 98
    //   323: iconst_2
    //   324: new 50	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 287
    //   334: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_3
    //   338: getfield 289	aent:jdField_a_of_type_Int	I
    //   341: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc 177
    //   346: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_1
    //   350: invokevirtual 290	org/json/JSONObject:toString	()Ljava/lang/String;
    //   353: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload_0
    //   363: invokevirtual 40	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   366: ldc 42
    //   368: iconst_0
    //   369: invokevirtual 48	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   372: ifnull -368 -> 4
    //   375: aload_0
    //   376: new 50	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   383: ldc 233
    //   385: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_3
    //   389: getfield 235	aent:jdField_a_of_type_Long	J
    //   392: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   395: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 292	aens:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Laent;
    //   401: astore 4
    //   403: aload_0
    //   404: new 50	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   411: ldc 233
    //   413: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_3
    //   417: getfield 235	aent:jdField_a_of_type_Long	J
    //   420: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   423: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: aload 4
    //   428: aload_1
    //   429: invokevirtual 290	org/json/JSONObject:toString	()Ljava/lang/String;
    //   432: invokestatic 294	aens:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Laent;Ljava/lang/String;)V
    //   435: aload_0
    //   436: ldc_w 296
    //   439: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   442: astore_0
    //   443: aload_0
    //   444: ifnull -440 -> 4
    //   447: aload_0
    //   448: bipush 38
    //   450: invokevirtual 306	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   453: pop
    //   454: return
    //   455: astore_0
    //   456: aload_0
    //   457: invokevirtual 309	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   460: return
    //   461: astore_0
    //   462: aload_0
    //   463: invokevirtual 310	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   466: return
    //   467: astore_0
    //   468: aload_0
    //   469: invokevirtual 311	org/json/JSONException:printStackTrace	()V
    //   472: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	paramQQAppInterface	QQAppInterface
    //   0	473	1	paramArrayOfByte	byte[]
    //   116	4	2	i	int
    //   12	405	3	localObject1	Object
    //   182	245	4	localObject2	Object
    //   188	106	5	str1	String
    //   218	31	6	str2	String
    //   212	60	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   122	315	455	java/io/UnsupportedEncodingException
    //   315	362	455	java/io/UnsupportedEncodingException
    //   362	443	455	java/io/UnsupportedEncodingException
    //   447	454	455	java/io/UnsupportedEncodingException
    //   13	89	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   89	117	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	315	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   315	362	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   362	443	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   447	454	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   456	460	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   468	472	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	315	467	org/json/JSONException
    //   315	362	467	org/json/JSONException
    //   362	443	467	org/json/JSONException
    //   447	454	467	org/json/JSONException
  }
  
  public int a()
  {
    return 10;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2131494204, null);
    ImageView localImageView;
    if (this.jdField_a_of_type_Aent != null)
    {
      if (this.jdField_a_of_type_Aent.jdField_a_of_type_Int != 1) {
        break label106;
      }
      paramVarArgs.setBackgroundResource(2131100194);
      ((TextView)paramVarArgs.findViewById(2131296866)).setText(this.jdField_a_of_type_Aent.jdField_a_of_type_JavaLangString);
      localImageView = (ImageView)paramVarArgs.findViewById(2131296862);
      String str = this.jdField_a_of_type_Aent.jdField_b_of_type_JavaLangString;
      if (TextUtils.isEmpty(str)) {
        break label127;
      }
      localImageView.setImageDrawable(axwd.a(str, null, null));
    }
    for (;;)
    {
      paramVarArgs.setOnClickListener(this);
      return paramVarArgs;
      label106:
      if (this.jdField_a_of_type_Aent.jdField_a_of_type_Int != 2) {
        break;
      }
      paramVarArgs.setBackgroundResource(2131100195);
      break;
      label127:
      localImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    do
    {
      do
      {
        return;
        paramVarArgs = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } while ((paramVarArgs == null) || (!paramVarArgs.a()));
      if ((paramVarArgs.e < 0) || (paramVarArgs.e >= paramVarArgs.jdField_c_of_type_Int) || (paramVarArgs.b())) {
        break;
      }
      this.jdField_a_of_type_Aent = paramVarArgs;
    } while (!this.jdField_a_of_type_Aeob.a(this, new Object[0]));
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "school", "school.aio.tips.show", 0, 0, "" + paramVarArgs.jdField_d_of_type_Int, "", "", "");
    return;
    if (QLog.isColorLevel()) {
      QLog.w("PubAccountTips", 2, "onAIOEvent():ON_SHOW tips expired!");
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramVarArgs, null);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 7;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (this.jdField_a_of_type_Aent != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aent.jdField_c_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0);
      if (localObject != null)
      {
        paramView = "selfuin_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_puin_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_msgdata";
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountTips", 2, "clickedTimes:" + (this.jdField_a_of_type_Aent.e + 1));
        }
        aent localaent = this.jdField_a_of_type_Aent;
        int i = localaent.e + 1;
        localaent.e = i;
        if (i < this.jdField_a_of_type_Aent.jdField_c_of_type_Int) {
          break label313;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "" + this.jdField_a_of_type_Aent.jdField_a_of_type_Long, this.jdField_a_of_type_Aent, null);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(28, 2000L);
      }
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
      localObject = new Intent(paramView, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Aent.jdField_c_of_type_JavaLangString);
      paramView.startActivity((Intent)localObject);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "school", "school.aio.tips.click", 0, 0, "" + this.jdField_a_of_type_Aent.jdField_d_of_type_Int, "", "", "");
      return;
      label313:
      localObject = ((SharedPreferences)localObject).edit();
      try
      {
        this.jdField_a_of_type_Aent.jdField_a_of_type_OrgJsonJSONObject.put("clicked", this.jdField_a_of_type_Aent.e);
        ((SharedPreferences.Editor)localObject).putString(paramView, this.jdField_a_of_type_Aent.jdField_a_of_type_OrgJsonJSONObject.toString()).commit();
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aens
 * JD-Core Version:    0.7.0.1
 */