import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForC2C;

public class aimk
  extends FileTransferObserver
{
  public aimk(TeamWorkFileImportJobForC2C paramTeamWorkFileImportJobForC2C) {}
  
  /* Error */
  protected void a(boolean paramBoolean, long paramLong1, java.lang.String paramString1, java.lang.String paramString2, com.tencent.mobileqq.pb.ByteStringMicro paramByteStringMicro, java.lang.String paramString3, short paramShort, java.lang.String paramString4, java.util.List paramList, int paramInt, java.lang.String paramString5, long paramLong2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: new 19	org/json/JSONObject
    //   6: dup
    //   7: invokespecial 20	org/json/JSONObject:<init>	()V
    //   10: astore 6
    //   12: iload_1
    //   13: ifeq +340 -> 353
    //   16: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +68 -> 87
    //   22: ldc 28
    //   24: iconst_2
    //   25: new 30	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   32: ldc 33
    //   34: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: lload_2
    //   38: invokevirtual 40	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: ldc 42
    //   43: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload 4
    //   48: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 44
    //   53: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 5
    //   58: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 46
    //   63: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 7
    //   68: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 48
    //   73: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: iload 8
    //   78: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 59	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: new 30	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 61
    //   93: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: astore 4
    //   98: aload 4
    //   100: aload 7
    //   102: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 66
    //   107: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 8
    //   112: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: aload 9
    //   117: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: new 68	org/json/JSONArray
    //   124: dup
    //   125: invokespecial 69	org/json/JSONArray:<init>	()V
    //   128: astore 7
    //   130: aload 7
    //   132: iconst_0
    //   133: aload 4
    //   135: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokevirtual 73	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   141: pop
    //   142: aload 6
    //   144: ldc 75
    //   146: aload 7
    //   148: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload 6
    //   154: ldc 80
    //   156: aload 12
    //   158: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload 6
    //   164: ldc 82
    //   166: aload 5
    //   168: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: iconst_1
    //   173: istore 8
    //   175: iconst_0
    //   176: istore 11
    //   178: aload_0
    //   179: getfield 10	aimk:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C;
    //   182: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   185: ifnull +96 -> 281
    //   188: iload 8
    //   190: ifne +21 -> 211
    //   193: aload 6
    //   195: ldc 80
    //   197: aload_0
    //   198: getfield 10	aimk:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C;
    //   201: getfield 90	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   204: getfield 96	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:b	Ljava/lang/String;
    //   207: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   210: pop
    //   211: aload 6
    //   213: ldc 98
    //   215: iconst_1
    //   216: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   219: pop
    //   220: aload 6
    //   222: ldc 103
    //   224: aload_0
    //   225: getfield 10	aimk:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C;
    //   228: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   231: getfield 108	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   234: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   237: pop
    //   238: aload 6
    //   240: ldc 110
    //   242: aload_0
    //   243: getfield 10	aimk:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C;
    //   246: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   249: getfield 113	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   252: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload_0
    //   257: getfield 10	aimk:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C;
    //   260: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   263: getfield 117	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   266: ifeq +134 -> 400
    //   269: aload 6
    //   271: ldc 119
    //   273: iconst_1
    //   274: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   277: pop
    //   278: iconst_1
    //   279: istore 11
    //   281: iload 11
    //   283: ifne +8 -> 291
    //   286: iload 8
    //   288: ifeq +161 -> 449
    //   291: aload 6
    //   293: ifnull +156 -> 449
    //   296: aload_0
    //   297: getfield 10	aimk:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C;
    //   300: getfield 122	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportHandler;
    //   303: aload 6
    //   305: aload_0
    //   306: getfield 10	aimk:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C;
    //   309: getfield 90	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   312: invokevirtual 127	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)V
    //   315: return
    //   316: astore 4
    //   318: iconst_0
    //   319: istore 8
    //   321: ldc 28
    //   323: iconst_2
    //   324: new 30	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   331: ldc 129
    //   333: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 4
    //   338: invokevirtual 130	java/lang/Exception:toString	()Ljava/lang/String;
    //   341: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: goto -175 -> 175
    //   353: ldc 28
    //   355: iconst_1
    //   356: new 30	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   363: ldc 33
    //   365: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: lload_2
    //   369: invokevirtual 40	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   372: ldc 135
    //   374: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 12
    //   379: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc 137
    //   384: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: iload 11
    //   395: istore 8
    //   397: goto -222 -> 175
    //   400: aload 6
    //   402: ldc 119
    //   404: iconst_2
    //   405: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   408: pop
    //   409: goto -131 -> 278
    //   412: astore 4
    //   414: ldc 28
    //   416: iconst_2
    //   417: new 30	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   424: ldc 139
    //   426: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload 4
    //   431: invokevirtual 130	java/lang/Exception:toString	()Ljava/lang/String;
    //   434: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: iconst_0
    //   444: istore 11
    //   446: goto -165 -> 281
    //   449: aload_0
    //   450: getfield 10	aimk:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C;
    //   453: iconst_1
    //   454: invokevirtual 142	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForC2C:a	(Z)V
    //   457: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	aimk
    //   0	458	1	paramBoolean	boolean
    //   0	458	2	paramLong1	long
    //   0	458	4	paramString1	java.lang.String
    //   0	458	5	paramString2	java.lang.String
    //   0	458	6	paramByteStringMicro	com.tencent.mobileqq.pb.ByteStringMicro
    //   0	458	7	paramString3	java.lang.String
    //   0	458	8	paramShort	short
    //   0	458	9	paramString4	java.lang.String
    //   0	458	10	paramList	java.util.List
    //   0	458	11	paramInt	int
    //   0	458	12	paramString5	java.lang.String
    //   0	458	13	paramLong2	long
    // Exception table:
    //   from	to	target	type
    //   121	172	316	java/lang/Exception
    //   178	188	412	java/lang/Exception
    //   193	211	412	java/lang/Exception
    //   211	278	412	java/lang/Exception
    //   400	409	412	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimk
 * JD-Core Version:    0.7.0.1
 */