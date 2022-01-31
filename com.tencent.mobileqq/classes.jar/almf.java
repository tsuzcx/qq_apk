import IMMsgBodyPack.MsgType0x210SubMsgType0x13;
import IMMsgBodyPack.MsgType0x210SubMsgType0x13_MsgItem;
import IMMsgBodyPack.Type_1_QQDataTextMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class almf
  extends allz
{
  public almf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type == 1L) {
      b(paramInt, paramShort, paramMsgType0x210SubMsgType0x13);
    }
  }
  
  private void b(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type != 1L) {}
    ayty localayty;
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid)))
      {
        localayty = new ayty(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint32_size), Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid), localayty);
      }
      for (;;)
      {
        Type_1_QQDataTextMsg localType_1_QQDataTextMsg = new Type_1_QQDataTextMsg();
        localType_1_QQDataTextMsg.readFrom(new JceInputStream(paramMsgType0x210SubMsgType0x13.bytes_buf));
        localObject = new String();
        int i = 0;
        while (i < localType_1_QQDataTextMsg.msg_item.size())
        {
          String str = new String(((MsgType0x210SubMsgType0x13_MsgItem)localType_1_QQDataTextMsg.msg_item.get(i)).bytes_text);
          localObject = (String)localObject + str;
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, str);
          }
          i += 1;
        }
        localayty = (ayty)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
      }
      localayty.a((int)paramMsgType0x210SubMsgType0x13.uint32_index, (String)localObject);
    } while (!localayty.a());
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
    Object localObject = new DataLineMsgRecord();
    ((DataLineMsgRecord)localObject).msgId = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).sessionid = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).msg = localayty.a();
    ((DataLineMsgRecord)localObject).msgtype = -1000;
    ((DataLineMsgRecord)localObject).issend = 0;
    ((DataLineMsgRecord)localObject).isread = false;
    ((DataLineMsgRecord)localObject).time = paramInt;
    ((DataLineMsgRecord)localObject).issuc = true;
    ((DataLineMsgRecord)localObject).sessionid = ((DataLineMsgRecord)localObject).msgId;
    ((DataLineMsgRecord)localObject).shmsgseq = paramShort;
    paramShort = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject).sessionid);
    this.app.a().a(paramShort).a((DataLineMsgRecord)localObject, true);
    this.app.a(1, true, true);
    a(8, true, new Object[] { Integer.valueOf(paramInt), localayty.a(), Long.valueOf(((DataLineMsgRecord)localObject).sessionid) });
  }
  
  /* Error */
  public void a(msf.msgcomm.msg_comm.Msg paramMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 204	allz:a	(Lmsf/msgcomm/msg_comm$Msg;)V
    //   5: new 206	msf/msgcomm/msg_comm$MsgType0x210
    //   8: dup
    //   9: invokespecial 207	msf/msgcomm/msg_comm$MsgType0x210:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_1
    //   15: getfield 213	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   18: invokevirtual 218	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   21: checkcast 215	tencent/im/msg/im_msg_body$MsgBody
    //   24: getfield 222	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   27: invokevirtual 227	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   30: invokevirtual 233	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   33: invokevirtual 237	msf/msgcomm/msg_comm$MsgType0x210:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   36: checkcast 206	msf/msgcomm/msg_comm$MsgType0x210
    //   39: astore_3
    //   40: aload_3
    //   41: astore_2
    //   42: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc 110
    //   50: iconst_2
    //   51: ldc 239
    //   53: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: new 57	com/qq/taf/jce/JceInputStream
    //   59: dup
    //   60: aload_2
    //   61: getfield 240	msf/msgcomm/msg_comm$MsgType0x210:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   64: invokevirtual 227	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   67: invokevirtual 233	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   70: invokespecial 64	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   73: astore_3
    //   74: new 242	IMMsgBodyPack/MsgType0x210
    //   77: dup
    //   78: invokespecial 243	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   81: astore_2
    //   82: aload_2
    //   83: aload_3
    //   84: invokevirtual 244	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   87: new 130	com/tencent/mobileqq/data/DataLineMsgRecord
    //   90: dup
    //   91: invokespecial 131	com/tencent/mobileqq/data/DataLineMsgRecord:<init>	()V
    //   94: astore_3
    //   95: aload_3
    //   96: aload_1
    //   97: getfield 248	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   100: invokevirtual 251	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   103: checkcast 250	msf/msgcomm/msg_comm$MsgHead
    //   106: getfield 255	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 259	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: i2l
    //   113: putfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   116: aload_3
    //   117: aload_1
    //   118: getfield 248	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   121: invokevirtual 251	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   124: checkcast 250	msf/msgcomm/msg_comm$MsgHead
    //   127: getfield 262	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 259	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: i2l
    //   134: putfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   137: aload_3
    //   138: aload_1
    //   139: getfield 248	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   142: invokevirtual 251	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   145: checkcast 250	msf/msgcomm/msg_comm$MsgHead
    //   148: getfield 266	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   151: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   154: putfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   157: aload_0
    //   158: aload_3
    //   159: iconst_1
    //   160: invokevirtual 274	almf:a	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;I)Z
    //   163: ifeq +78 -> 241
    //   166: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +51 -> 220
    //   172: ldc 110
    //   174: iconst_2
    //   175: new 93	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 276
    //   185: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_3
    //   189: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   192: invokevirtual 279	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: ldc_w 281
    //   198: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_3
    //   202: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   205: invokevirtual 279	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: ldc_w 283
    //   211: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: return
    //   221: astore_3
    //   222: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +13 -> 238
    //   228: ldc 110
    //   230: iconst_2
    //   231: ldc_w 285
    //   234: aload_3
    //   235: invokestatic 289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: goto -196 -> 42
    //   241: aload_0
    //   242: getfield 171	almf:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   245: bipush 10
    //   247: invokevirtual 292	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   250: checkcast 294	alxb
    //   253: astore_1
    //   254: aload_1
    //   255: ifnull +16 -> 271
    //   258: aload_1
    //   259: invokevirtual 296	alxb:d	()I
    //   262: iconst_1
    //   263: if_icmpeq +8 -> 271
    //   266: aload_1
    //   267: iconst_1
    //   268: invokevirtual 299	alxb:e	(I)V
    //   271: aload_2
    //   272: getfield 302	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   275: ldc2_w 303
    //   278: lcmp
    //   279: ifne +69 -> 348
    //   282: aload_0
    //   283: aload_2
    //   284: getfield 308	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   287: getfield 311	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_app_id	J
    //   290: l2i
    //   291: aload_2
    //   292: getfield 308	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   295: getfield 314	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_inst_id	J
    //   298: l2i
    //   299: invokevirtual 317	almf:a	(II)Z
    //   302: ifne -82 -> 220
    //   305: aload_0
    //   306: aload_2
    //   307: getfield 308	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   310: getfield 320	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_app_id	J
    //   313: l2i
    //   314: aload_2
    //   315: getfield 308	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   318: getfield 323	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_inst_id	J
    //   321: l2i
    //   322: invokevirtual 325	almf:b	(II)Z
    //   325: ifeq -105 -> 220
    //   328: aload_0
    //   329: aload_3
    //   330: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   333: l2i
    //   334: aload_3
    //   335: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   338: l2i
    //   339: i2s
    //   340: aload_2
    //   341: getfield 308	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   344: invokespecial 327	almf:a	(ISLIMMsgBodyPack/MsgType0x210SubMsgType0x13;)V
    //   347: return
    //   348: aload_2
    //   349: getfield 302	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   352: ldc2_w 328
    //   355: lcmp
    //   356: ifne +161 -> 517
    //   359: aload_0
    //   360: aload_2
    //   361: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   364: getfield 338	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcAppId	J
    //   367: l2i
    //   368: aload_2
    //   369: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   372: getfield 341	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcInstId	J
    //   375: l2i
    //   376: invokevirtual 317	almf:a	(II)Z
    //   379: ifne -159 -> 220
    //   382: aload_0
    //   383: aload_2
    //   384: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   387: getfield 344	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstAppId	J
    //   390: l2i
    //   391: aload_2
    //   392: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   395: getfield 347	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstInstId	J
    //   398: l2i
    //   399: invokevirtual 325	almf:b	(II)Z
    //   402: ifeq -182 -> 220
    //   405: aload_0
    //   406: getfield 350	almf:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   409: aload_2
    //   410: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   413: getfield 353	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lSessionId	J
    //   416: aload_2
    //   417: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   420: getfield 356	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uOriginfiletype	J
    //   423: aload_2
    //   424: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   427: getfield 359	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstUin	J
    //   430: new 70	java/lang/String
    //   433: dup
    //   434: aload_2
    //   435: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   438: getfield 362	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileName	[B
    //   441: invokespecial 91	java/lang/String:<init>	([B)V
    //   444: aload_2
    //   445: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   448: getfield 365	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lFileLen	J
    //   451: aload_2
    //   452: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   455: getfield 368	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileMd5	[B
    //   458: new 70	java/lang/String
    //   461: dup
    //   462: aload_2
    //   463: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   466: getfield 371	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileIndex	[B
    //   469: invokespecial 91	java/lang/String:<init>	([B)V
    //   472: aload_2
    //   473: getfield 333	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   476: getfield 374	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strOriginfile_md5	[B
    //   479: iconst_0
    //   480: iconst_0
    //   481: iconst_0
    //   482: iconst_0
    //   483: aload_3
    //   484: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   487: l2i
    //   488: i2l
    //   489: aload_3
    //   490: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   493: l2i
    //   494: i2s
    //   495: i2l
    //   496: aload_3
    //   497: getfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   500: iconst_0
    //   501: invokevirtual 380	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFTNNotify_0x210	(JJJLjava/lang/String;J[BLjava/lang/String;[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   504: astore_1
    //   505: aload_0
    //   506: getfield 383	almf:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   509: aload_1
    //   510: invokevirtual 389	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   513: return
    //   514: astore_1
    //   515: aload_1
    //   516: athrow
    //   517: aload_2
    //   518: getfield 302	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   521: ldc2_w 390
    //   524: lcmp
    //   525: ifne +172 -> 697
    //   528: aload_0
    //   529: aload_2
    //   530: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   533: getfield 398	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcAppId	J
    //   536: l2i
    //   537: aload_2
    //   538: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   541: getfield 399	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcInstId	J
    //   544: l2i
    //   545: invokevirtual 317	almf:a	(II)Z
    //   548: ifne -328 -> 220
    //   551: aload_0
    //   552: aload_2
    //   553: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   556: getfield 400	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstAppId	J
    //   559: l2i
    //   560: aload_2
    //   561: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   564: getfield 401	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstInstId	J
    //   567: l2i
    //   568: invokevirtual 325	almf:b	(II)Z
    //   571: ifeq -351 -> 220
    //   574: aload_0
    //   575: getfield 350	almf:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   578: aload_2
    //   579: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   582: getfield 402	IMMsgBodyPack/MsgType0x210SubMsgType0xa:lSessionId	J
    //   585: aload_2
    //   586: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   589: getfield 403	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uOriginfiletype	J
    //   592: aload_2
    //   593: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   596: getfield 404	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstUin	J
    //   599: new 70	java/lang/String
    //   602: dup
    //   603: aload_2
    //   604: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   607: getfield 405	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strFileName	[B
    //   610: invokespecial 91	java/lang/String:<init>	([B)V
    //   613: aload_2
    //   614: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   617: getfield 408	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uFileLen	J
    //   620: aload_2
    //   621: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   624: getfield 411	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vMd5	[B
    //   627: aload_2
    //   628: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   631: getfield 414	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerIp	J
    //   634: aload_2
    //   635: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   638: getfield 417	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerPort	J
    //   641: aload_2
    //   642: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   645: getfield 420	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vUrlNotify	[B
    //   648: aload_2
    //   649: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   652: getfield 423	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vTokenKey	[B
    //   655: aload_2
    //   656: getfield 395	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   659: getfield 424	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strOriginfile_md5	[B
    //   662: iconst_0
    //   663: iconst_0
    //   664: iconst_0
    //   665: iconst_0
    //   666: aload_3
    //   667: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   670: l2i
    //   671: i2l
    //   672: aload_3
    //   673: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   676: l2i
    //   677: i2s
    //   678: i2l
    //   679: aload_3
    //   680: getfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   683: iconst_0
    //   684: invokevirtual 428	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromNFCNotify_0x210	(JJJLjava/lang/String;J[BJJ[B[B[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   687: astore_1
    //   688: aload_0
    //   689: getfield 383	almf:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   692: aload_1
    //   693: invokevirtual 389	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   696: return
    //   697: aload_2
    //   698: getfield 302	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   701: ldc2_w 429
    //   704: lcmp
    //   705: ifne -485 -> 220
    //   708: aload_0
    //   709: aload_2
    //   710: getfield 434	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   713: getfield 437	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_app_id	J
    //   716: l2i
    //   717: aload_2
    //   718: getfield 434	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   721: getfield 438	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_inst_id	J
    //   724: l2i
    //   725: invokevirtual 317	almf:a	(II)Z
    //   728: ifne -508 -> 220
    //   731: aload_0
    //   732: aload_2
    //   733: getfield 434	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   736: getfield 439	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_app_id	J
    //   739: l2i
    //   740: aload_2
    //   741: getfield 434	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   744: getfield 440	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_inst_id	J
    //   747: l2i
    //   748: invokevirtual 325	almf:b	(II)Z
    //   751: ifeq -531 -> 220
    //   754: aload_0
    //   755: getfield 350	almf:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   758: aload_2
    //   759: getfield 434	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   762: getfield 441	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint64_sessionid	J
    //   765: aload_2
    //   766: getfield 434	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   769: getfield 444	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_operate	J
    //   772: iconst_0
    //   773: aload_3
    //   774: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   777: l2i
    //   778: aload_3
    //   779: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   782: l2i
    //   783: i2s
    //   784: invokevirtual 448	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFileControl_0x210	(JJIIS)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   787: astore_1
    //   788: aload_0
    //   789: getfield 383	almf:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   792: aload_1
    //   793: invokevirtual 389	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   796: return
    //   797: astore_1
    //   798: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	this	almf
    //   0	799	1	paramMsg	msf.msgcomm.msg_comm.Msg
    //   12	754	2	localObject1	Object
    //   39	163	3	localObject2	Object
    //   221	558	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   13	40	221	java/lang/Exception
    //   82	220	514	finally
    //   241	254	514	finally
    //   258	271	514	finally
    //   271	347	514	finally
    //   348	513	514	finally
    //   517	696	514	finally
    //   697	796	514	finally
    //   82	220	797	java/lang/Exception
    //   241	254	797	java/lang/Exception
    //   258	271	797	java/lang/Exception
    //   271	347	797	java/lang/Exception
    //   348	513	797	java/lang/Exception
    //   517	696	797	java/lang/Exception
    //   697	796	797	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     almf
 * JD-Core Version:    0.7.0.1
 */