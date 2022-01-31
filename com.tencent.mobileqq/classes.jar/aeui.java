import com.tencent.mobileqq.nearby.now.protocol.CsTask.Callback;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;

public class aeui
  implements CsTask.Callback
{
  public aeui(SmallVideoCameraCaptureFragment paramSmallVideoCameraCaptureFragment) {}
  
  /* Error */
  public void a(int paramInt, byte[] paramArrayOfByte, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 21	com/tencent/ilive_feeds/ShortVideo$CheckAuthRsp
    //   5: dup
    //   6: invokespecial 22	com/tencent/ilive_feeds/ShortVideo$CheckAuthRsp:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: aload_2
    //   14: invokevirtual 26	com/tencent/ilive_feeds/ShortVideo$CheckAuthRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   17: pop
    //   18: ldc 28
    //   20: iconst_1
    //   21: new 30	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   28: ldc 33
    //   30: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 4
    //   35: getfield 41	com/tencent/ilive_feeds/ShortVideo$CheckAuthRsp:retcode	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   38: invokevirtual 47	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   41: invokevirtual 50	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 60	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload 4
    //   52: getfield 41	com/tencent/ilive_feeds/ShortVideo$CheckAuthRsp:retcode	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   55: invokevirtual 47	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   58: istore_1
    //   59: aload 4
    //   61: getfield 64	com/tencent/ilive_feeds/ShortVideo$CheckAuthRsp:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   64: invokevirtual 68	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   67: invokevirtual 71	java/lang/String:toString	()Ljava/lang/String;
    //   70: astore_2
    //   71: aload_0
    //   72: getfield 12	aeui:a	Lcom/tencent/mobileqq/nearby/now/send/SmallVideoCameraCaptureFragment;
    //   75: astore 4
    //   77: aload_2
    //   78: astore_3
    //   79: aload_2
    //   80: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   83: ifeq +6 -> 89
    //   86: ldc 79
    //   88: astore_3
    //   89: aload 4
    //   91: aload_3
    //   92: invokestatic 84	com/tencent/mobileqq/nearby/now/send/SmallVideoCameraCaptureFragment:a	(Lcom/tencent/mobileqq/nearby/now/send/SmallVideoCameraCaptureFragment;Ljava/lang/String;)Ljava/lang/String;
    //   95: pop
    //   96: iload_1
    //   97: ifeq +62 -> 159
    //   100: invokestatic 90	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   103: new 92	aeuj
    //   106: dup
    //   107: aload_0
    //   108: invokespecial 95	aeuj:<init>	(Laeui;)V
    //   111: invokevirtual 101	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   114: pop
    //   115: iload_1
    //   116: sipush 10008
    //   119: if_icmpeq +12 -> 131
    //   122: aload_0
    //   123: getfield 12	aeui:a	Lcom/tencent/mobileqq/nearby/now/send/SmallVideoCameraCaptureFragment;
    //   126: iconst_1
    //   127: invokestatic 104	com/tencent/mobileqq/nearby/now/send/SmallVideoCameraCaptureFragment:a	(Lcom/tencent/mobileqq/nearby/now/send/SmallVideoCameraCaptureFragment;Z)Z
    //   130: pop
    //   131: invokestatic 90	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   134: new 106	aeuk
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 107	aeuk:<init>	(Laeui;)V
    //   142: invokevirtual 101	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   145: pop
    //   146: return
    //   147: astore_2
    //   148: bipush 253
    //   150: istore_1
    //   151: aload_3
    //   152: astore_2
    //   153: goto -82 -> 71
    //   156: astore_2
    //   157: aload_2
    //   158: athrow
    //   159: aload_0
    //   160: getfield 12	aeui:a	Lcom/tencent/mobileqq/nearby/now/send/SmallVideoCameraCaptureFragment;
    //   163: iconst_1
    //   164: invokestatic 104	com/tencent/mobileqq/nearby/now/send/SmallVideoCameraCaptureFragment:a	(Lcom/tencent/mobileqq/nearby/now/send/SmallVideoCameraCaptureFragment;Z)Z
    //   167: pop
    //   168: goto -37 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	aeui
    //   0	171	1	paramInt	int
    //   0	171	2	paramArrayOfByte	byte[]
    //   0	171	3	paramBundle	android.os.Bundle
    //   9	81	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	71	147	java/lang/Exception
    //   2	71	156	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeui
 * JD-Core Version:    0.7.0.1
 */