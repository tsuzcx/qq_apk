import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegDataDest;
import java.io.File;

public final class aglp
  implements JpegDataDest
{
  public aglp(File paramFile, CompressInfo paramCompressInfo) {}
  
  /* Error */
  public void dataArrived(java.nio.ByteBuffer paramByteBuffer, boolean paramBoolean, Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 25	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 13	aglp:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   10: iconst_1
    //   11: invokespecial 28	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   14: invokevirtual 32	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   17: astore 4
    //   19: aload 4
    //   21: astore_3
    //   22: aload_3
    //   23: aload_1
    //   24: invokevirtual 38	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   27: pop
    //   28: aload_3
    //   29: ifnull +53 -> 82
    //   32: iload_2
    //   33: ifeq +45 -> 78
    //   36: aload_3
    //   37: iconst_1
    //   38: invokevirtual 42	java/nio/channels/FileChannel:force	(Z)V
    //   41: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +34 -> 78
    //   47: ldc 50
    //   49: iconst_2
    //   50: new 52	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   57: ldc 55
    //   59: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 13	aglp:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   66: invokevirtual 65	java/io/File:length	()J
    //   69: invokevirtual 68	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 76	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_3
    //   79: invokevirtual 79	java/nio/channels/FileChannel:close	()V
    //   82: return
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   88: goto -10 -> 78
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   96: return
    //   97: astore_1
    //   98: aload_3
    //   99: astore_1
    //   100: aload_0
    //   101: getfield 15	aglp:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   104: ifnull +11 -> 115
    //   107: aload_0
    //   108: getfield 15	aglp:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   111: iconst_1
    //   112: invokevirtual 87	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   115: aload_1
    //   116: ifnull -34 -> 82
    //   119: iload_2
    //   120: ifeq +45 -> 165
    //   123: aload_1
    //   124: iconst_1
    //   125: invokevirtual 42	java/nio/channels/FileChannel:force	(Z)V
    //   128: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +34 -> 165
    //   134: ldc 50
    //   136: iconst_2
    //   137: new 52	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   144: ldc 55
    //   146: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: getfield 13	aglp:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   153: invokevirtual 65	java/io/File:length	()J
    //   156: invokevirtual 68	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   159: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 76	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_1
    //   166: invokevirtual 79	java/nio/channels/FileChannel:close	()V
    //   169: return
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   175: return
    //   176: astore_3
    //   177: aload_3
    //   178: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   181: goto -16 -> 165
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_3
    //   188: ifnull +53 -> 241
    //   191: iload_2
    //   192: ifeq +45 -> 237
    //   195: aload_3
    //   196: iconst_1
    //   197: invokevirtual 42	java/nio/channels/FileChannel:force	(Z)V
    //   200: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +34 -> 237
    //   206: ldc 50
    //   208: iconst_2
    //   209: new 52	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   216: ldc 55
    //   218: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: getfield 13	aglp:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   225: invokevirtual 65	java/io/File:length	()J
    //   228: invokevirtual 68	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 76	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_3
    //   238: invokevirtual 79	java/nio/channels/FileChannel:close	()V
    //   241: aload_1
    //   242: athrow
    //   243: astore 4
    //   245: aload 4
    //   247: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   250: goto -13 -> 237
    //   253: astore_3
    //   254: aload_3
    //   255: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   258: goto -17 -> 241
    //   261: astore_1
    //   262: goto -75 -> 187
    //   265: astore 4
    //   267: aload_1
    //   268: astore_3
    //   269: aload 4
    //   271: astore_1
    //   272: goto -85 -> 187
    //   275: astore_1
    //   276: aload_3
    //   277: astore_1
    //   278: goto -178 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	aglp
    //   0	281	1	paramByteBuffer	java.nio.ByteBuffer
    //   0	281	2	paramBoolean	boolean
    //   0	281	3	paramObject	Object
    //   17	3	4	localFileChannel	java.nio.channels.FileChannel
    //   243	3	4	localIOException	java.io.IOException
    //   265	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	78	83	java/io/IOException
    //   78	82	91	java/io/IOException
    //   2	19	97	java/io/IOException
    //   165	169	170	java/io/IOException
    //   123	165	176	java/io/IOException
    //   2	19	184	finally
    //   195	237	243	java/io/IOException
    //   237	241	253	java/io/IOException
    //   22	28	261	finally
    //   100	115	265	finally
    //   22	28	275	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aglp
 * JD-Core Version:    0.7.0.1
 */