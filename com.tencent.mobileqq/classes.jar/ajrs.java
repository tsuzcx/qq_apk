import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class ajrs
  implements Manager
{
  public static boolean a;
  private final int jdField_a_of_type_Int = 10000;
  private atmp jdField_a_of_type_Atmp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final int b = 10001;
  
  public ajrs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("search_keyword" + paramQQAppInterface.getCurrentAccountUin(), "");
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ajjj localajjj = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    paramString = localajjj.e(paramString);
    if (paramString != null)
    {
      paramString = localajjj.a(paramString.groupid + "");
      if (paramString == null) {}
    }
    for (paramString = paramString.group_name;; paramString = null) {
      return paramString;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_Boolean = true;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString("search_keyword" + paramQQAppInterface.getCurrentAccountUin(), paramString);
    localEditor.commit();
  }
  
  /* Error */
  public java.util.ArrayList<SearchHistory> a()
  {
    // Byte code:
    //   0: new 131	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 132	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 23	ajrs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: bipush 51
    //   15: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   18: checkcast 88	ajjj
    //   21: astore 8
    //   23: aload_0
    //   24: getfield 23	ajrs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: bipush 52
    //   29: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   32: checkcast 134	com/tencent/mobileqq/app/TroopManager
    //   35: astore 9
    //   37: aload_0
    //   38: getfield 23	ajrs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   41: bipush 11
    //   43: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   46: checkcast 136	com/tencent/mobileqq/app/PhoneContactManagerImp
    //   49: astore 10
    //   51: aload_0
    //   52: getfield 37	ajrs:jdField_a_of_type_Atmp	Latmp;
    //   55: iconst_0
    //   56: ldc 138
    //   58: invokevirtual 143	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: ldc 145
    //   68: aconst_null
    //   69: invokevirtual 150	atmp:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 6
    //   74: iconst_0
    //   75: istore_3
    //   76: aload 6
    //   78: ifnull +386 -> 464
    //   81: aload 6
    //   83: invokeinterface 155 1 0
    //   88: ifeq +376 -> 464
    //   91: new 138	com/tencent/mobileqq/data/SearchHistory
    //   94: dup
    //   95: invokespecial 156	com/tencent/mobileqq/data/SearchHistory:<init>	()V
    //   98: astore 11
    //   100: aload 11
    //   102: aload 6
    //   104: aload 6
    //   106: ldc 158
    //   108: invokeinterface 162 2 0
    //   113: invokeinterface 165 2 0
    //   118: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   121: aload 11
    //   123: aload 6
    //   125: aload 6
    //   127: ldc 169
    //   129: invokeinterface 162 2 0
    //   134: invokeinterface 165 2 0
    //   139: putfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   142: aload 11
    //   144: aload 6
    //   146: aload 6
    //   148: ldc 173
    //   150: invokeinterface 162 2 0
    //   155: invokeinterface 165 2 0
    //   160: putfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   163: aload 11
    //   165: aload 6
    //   167: aload 6
    //   169: ldc 177
    //   171: invokeinterface 162 2 0
    //   176: invokeinterface 165 2 0
    //   181: putfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   184: aload 11
    //   186: aload 6
    //   188: aload 6
    //   190: ldc 181
    //   192: invokeinterface 162 2 0
    //   197: invokeinterface 185 2 0
    //   202: putfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   205: aload 11
    //   207: aload 6
    //   209: aload 6
    //   211: ldc 189
    //   213: invokeinterface 162 2 0
    //   218: invokeinterface 165 2 0
    //   223: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   226: aload 11
    //   228: aload 6
    //   230: aload 6
    //   232: ldc 193
    //   234: invokeinterface 162 2 0
    //   239: invokeinterface 185 2 0
    //   244: putfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   247: aload 11
    //   249: aload 6
    //   251: aload 6
    //   253: ldc 197
    //   255: invokeinterface 162 2 0
    //   260: invokeinterface 201 2 0
    //   265: putfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   268: aload 11
    //   270: aload 6
    //   272: aload 6
    //   274: ldc 206
    //   276: invokeinterface 162 2 0
    //   281: invokeinterface 185 2 0
    //   286: i2l
    //   287: invokevirtual 210	com/tencent/mobileqq/data/SearchHistory:setId	(J)V
    //   290: iconst_0
    //   291: istore_2
    //   292: iconst_0
    //   293: istore 4
    //   295: iconst_0
    //   296: istore_1
    //   297: aload 11
    //   299: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   302: lookupswitch	default:+711->1013, 0:+177->479, 1:+324->626, 1000:+195->497, 1004:+195->497, 1008:+380->682, 1021:+733->1035, 3000:+342->644, 7220:+427->729, 56939:+567->869, 56940:+466->768, 56941:+517->819, 56942:+612->914
    //   409: ifeq +538 -> 947
    //   412: aload_0
    //   413: getfield 37	ajrs:jdField_a_of_type_Atmp	Latmp;
    //   416: ldc 138
    //   418: aload 11
    //   420: getfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   423: invokevirtual 213	atmp:a	(Ljava/lang/Class;Ljava/lang/String;)Latmo;
    //   426: checkcast 138	com/tencent/mobileqq/data/SearchHistory
    //   429: astore 11
    //   431: aload 11
    //   433: ifnull +13 -> 446
    //   436: aload_0
    //   437: getfield 37	ajrs:jdField_a_of_type_Atmp	Latmp;
    //   440: aload 11
    //   442: invokevirtual 216	atmp:b	(Latmo;)Z
    //   445: pop
    //   446: iload_3
    //   447: iconst_1
    //   448: iadd
    //   449: istore_3
    //   450: aload 6
    //   452: invokeinterface 219 1 0
    //   457: istore 5
    //   459: iload 5
    //   461: ifne -370 -> 91
    //   464: aload 6
    //   466: ifnull +10 -> 476
    //   469: aload 6
    //   471: invokeinterface 222 1 0
    //   476: aload 7
    //   478: areturn
    //   479: aload 8
    //   481: aload 11
    //   483: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   486: invokevirtual 225	ajjj:b	(Ljava/lang/String;)Z
    //   489: ifne +524 -> 1013
    //   492: iconst_1
    //   493: istore_1
    //   494: goto +521 -> 1015
    //   497: aload 8
    //   499: aload 11
    //   501: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   504: invokevirtual 225	ajjj:b	(Ljava/lang/String;)Z
    //   507: ifeq +5 -> 512
    //   510: iconst_1
    //   511: istore_1
    //   512: aload 11
    //   514: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   517: sipush 1000
    //   520: if_icmpne +47 -> 567
    //   523: aload_0
    //   524: getfield 23	ajrs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   527: bipush 52
    //   529: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   532: checkcast 134	com/tencent/mobileqq/app/TroopManager
    //   535: astore 12
    //   537: iload_1
    //   538: istore_2
    //   539: aload 12
    //   541: aload 12
    //   543: aload 11
    //   545: getfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   548: invokevirtual 228	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   551: aload 11
    //   553: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   556: invokevirtual 231	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   559: ifnonnull +454 -> 1013
    //   562: iconst_1
    //   563: istore_1
    //   564: goto +451 -> 1015
    //   567: iload_1
    //   568: istore_2
    //   569: aload 11
    //   571: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   574: sipush 1004
    //   577: if_icmpne +436 -> 1013
    //   580: aload_0
    //   581: getfield 23	ajrs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   584: bipush 53
    //   586: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   589: checkcast 233	ajhh
    //   592: aload 11
    //   594: getfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   597: invokevirtual 236	ajhh:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   600: astore 12
    //   602: aload 12
    //   604: ifnull +421 -> 1025
    //   607: aload 12
    //   609: invokevirtual 241	com/tencent/mobileqq/data/DiscussionInfo:isDiscussHrMeeting	()Z
    //   612: ifne +413 -> 1025
    //   615: aload 12
    //   617: invokevirtual 244	com/tencent/mobileqq/data/DiscussionInfo:isHidden	()Z
    //   620: ifeq +407 -> 1027
    //   623: goto +402 -> 1025
    //   626: aload 9
    //   628: aload 11
    //   630: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   633: invokevirtual 247	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   636: ifnonnull +377 -> 1013
    //   639: iconst_1
    //   640: istore_1
    //   641: goto +374 -> 1015
    //   644: aload_0
    //   645: getfield 23	ajrs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   648: bipush 53
    //   650: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   653: checkcast 233	ajhh
    //   656: aload 11
    //   658: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   661: invokevirtual 236	ajhh:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   664: astore 12
    //   666: aload 12
    //   668: ifnull +362 -> 1030
    //   671: aload 12
    //   673: invokevirtual 244	com/tencent/mobileqq/data/DiscussionInfo:isHidden	()Z
    //   676: ifeq +337 -> 1013
    //   679: goto +351 -> 1030
    //   682: aload 11
    //   684: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   687: getstatic 252	ajed:ay	Ljava/lang/String;
    //   690: invokestatic 256	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   693: ifeq +347 -> 1040
    //   696: aload_0
    //   697: getfield 23	ajrs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   700: invokestatic 261	bgmq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   703: ifeq +6 -> 709
    //   706: goto +334 -> 1040
    //   709: aload 11
    //   711: aload_0
    //   712: getfield 23	ajrs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   715: invokestatic 264	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   718: invokestatic 269	rsp:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Ljava/lang/String;
    //   721: putfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   724: iconst_0
    //   725: istore_1
    //   726: goto +289 -> 1015
    //   729: aload_0
    //   730: getfield 23	ajrs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   733: invokestatic 261	bgmq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   736: ifeq +309 -> 1045
    //   739: invokestatic 272	bgmq:k	()Z
    //   742: ifeq +6 -> 748
    //   745: goto +300 -> 1045
    //   748: aload 11
    //   750: aload_0
    //   751: getfield 23	ajrs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   754: invokestatic 264	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   757: invokestatic 274	rsp:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Ljava/lang/String;
    //   760: putfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   763: iconst_0
    //   764: istore_1
    //   765: goto +250 -> 1015
    //   768: aload 10
    //   770: invokevirtual 277	com/tencent/mobileqq/app/PhoneContactManagerImp:h	()Z
    //   773: ifeq +8 -> 781
    //   776: iconst_1
    //   777: istore_1
    //   778: goto +237 -> 1015
    //   781: aload 10
    //   783: aload 11
    //   785: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   788: invokevirtual 280	com/tencent/mobileqq/app/PhoneContactManagerImp:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PhoneContact;
    //   791: astore 12
    //   793: aload 12
    //   795: ifnonnull +8 -> 803
    //   798: iconst_1
    //   799: istore_1
    //   800: goto +215 -> 1015
    //   803: aload 12
    //   805: getfield 283	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   808: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   811: ifeq +202 -> 1013
    //   814: iconst_1
    //   815: istore_1
    //   816: goto +199 -> 1015
    //   819: aload 10
    //   821: invokevirtual 277	com/tencent/mobileqq/app/PhoneContactManagerImp:h	()Z
    //   824: ifne +8 -> 832
    //   827: iconst_1
    //   828: istore_1
    //   829: goto +186 -> 1015
    //   832: aload 10
    //   834: aload 11
    //   836: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   839: invokevirtual 280	com/tencent/mobileqq/app/PhoneContactManagerImp:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PhoneContact;
    //   842: astore 12
    //   844: aload 12
    //   846: ifnull +204 -> 1050
    //   849: iload 4
    //   851: istore_1
    //   852: ldc_w 285
    //   855: aload 12
    //   857: getfield 283	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   860: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   863: ifne +189 -> 1052
    //   866: goto +184 -> 1050
    //   869: aload 10
    //   871: aload 11
    //   873: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   876: invokevirtual 280	com/tencent/mobileqq/app/PhoneContactManagerImp:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PhoneContact;
    //   879: astore 12
    //   881: aload 12
    //   883: ifnull +172 -> 1055
    //   886: aload 12
    //   888: getfield 283	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   891: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   894: ifne +161 -> 1055
    //   897: ldc_w 285
    //   900: aload 12
    //   902: getfield 283	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   905: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   908: ifeq +105 -> 1013
    //   911: goto +144 -> 1055
    //   914: aload 10
    //   916: aload 11
    //   918: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   921: invokevirtual 280	com/tencent/mobileqq/app/PhoneContactManagerImp:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PhoneContact;
    //   924: astore 12
    //   926: aload 12
    //   928: ifnull +85 -> 1013
    //   931: aload 12
    //   933: getfield 283	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   936: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   939: ifeq +121 -> 1060
    //   942: iconst_0
    //   943: istore_1
    //   944: goto +71 -> 1015
    //   947: iload_3
    //   948: iconst_5
    //   949: if_icmpge -503 -> 446
    //   952: aload 7
    //   954: aload 11
    //   956: invokevirtual 293	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   959: pop
    //   960: goto -514 -> 446
    //   963: astore 8
    //   965: aload 6
    //   967: ifnull -491 -> 476
    //   970: aload 6
    //   972: invokeinterface 222 1 0
    //   977: aload 7
    //   979: areturn
    //   980: astore 7
    //   982: aconst_null
    //   983: astore 6
    //   985: aload 6
    //   987: ifnull +10 -> 997
    //   990: aload 6
    //   992: invokeinterface 222 1 0
    //   997: aload 7
    //   999: athrow
    //   1000: astore 7
    //   1002: goto -17 -> 985
    //   1005: astore 6
    //   1007: aconst_null
    //   1008: astore 6
    //   1010: goto -45 -> 965
    //   1013: iload_2
    //   1014: istore_1
    //   1015: iload_3
    //   1016: iconst_5
    //   1017: if_icmplt -609 -> 408
    //   1020: iconst_1
    //   1021: istore_1
    //   1022: goto -614 -> 408
    //   1025: iconst_1
    //   1026: istore_1
    //   1027: goto -12 -> 1015
    //   1030: iconst_1
    //   1031: istore_1
    //   1032: goto -17 -> 1015
    //   1035: iconst_1
    //   1036: istore_1
    //   1037: goto -22 -> 1015
    //   1040: iconst_1
    //   1041: istore_1
    //   1042: goto -27 -> 1015
    //   1045: iconst_1
    //   1046: istore_1
    //   1047: goto -32 -> 1015
    //   1050: iconst_1
    //   1051: istore_1
    //   1052: goto -37 -> 1015
    //   1055: iconst_1
    //   1056: istore_1
    //   1057: goto -42 -> 1015
    //   1060: iconst_1
    //   1061: istore_1
    //   1062: goto -47 -> 1015
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1065	0	this	ajrs
    //   296	766	1	i	int
    //   291	723	2	j	int
    //   75	943	3	k	int
    //   293	557	4	m	int
    //   457	3	5	bool	boolean
    //   72	919	6	localCursor	android.database.Cursor
    //   1005	1	6	localException1	java.lang.Exception
    //   1008	1	6	localObject1	Object
    //   7	971	7	localArrayList	java.util.ArrayList
    //   980	18	7	localObject2	Object
    //   1000	1	7	localObject3	Object
    //   21	477	8	localajjj	ajjj
    //   963	1	8	localException2	java.lang.Exception
    //   35	592	9	localTroopManager	com.tencent.mobileqq.app.TroopManager
    //   49	866	10	localPhoneContactManagerImp	com.tencent.mobileqq.app.PhoneContactManagerImp
    //   98	857	11	localSearchHistory	SearchHistory
    //   535	397	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   81	91	963	java/lang/Exception
    //   91	290	963	java/lang/Exception
    //   297	408	963	java/lang/Exception
    //   412	431	963	java/lang/Exception
    //   436	446	963	java/lang/Exception
    //   450	459	963	java/lang/Exception
    //   479	492	963	java/lang/Exception
    //   497	510	963	java/lang/Exception
    //   512	537	963	java/lang/Exception
    //   539	562	963	java/lang/Exception
    //   569	602	963	java/lang/Exception
    //   607	615	963	java/lang/Exception
    //   615	623	963	java/lang/Exception
    //   626	639	963	java/lang/Exception
    //   644	666	963	java/lang/Exception
    //   671	679	963	java/lang/Exception
    //   682	706	963	java/lang/Exception
    //   709	724	963	java/lang/Exception
    //   729	745	963	java/lang/Exception
    //   748	763	963	java/lang/Exception
    //   768	776	963	java/lang/Exception
    //   781	793	963	java/lang/Exception
    //   803	814	963	java/lang/Exception
    //   819	827	963	java/lang/Exception
    //   832	844	963	java/lang/Exception
    //   852	866	963	java/lang/Exception
    //   869	881	963	java/lang/Exception
    //   886	897	963	java/lang/Exception
    //   897	911	963	java/lang/Exception
    //   914	926	963	java/lang/Exception
    //   931	942	963	java/lang/Exception
    //   952	960	963	java/lang/Exception
    //   51	74	980	finally
    //   81	91	1000	finally
    //   91	290	1000	finally
    //   297	408	1000	finally
    //   412	431	1000	finally
    //   436	446	1000	finally
    //   450	459	1000	finally
    //   479	492	1000	finally
    //   497	510	1000	finally
    //   512	537	1000	finally
    //   539	562	1000	finally
    //   569	602	1000	finally
    //   607	615	1000	finally
    //   615	623	1000	finally
    //   626	639	1000	finally
    //   644	666	1000	finally
    //   671	679	1000	finally
    //   682	706	1000	finally
    //   709	724	1000	finally
    //   729	745	1000	finally
    //   748	763	1000	finally
    //   768	776	1000	finally
    //   781	793	1000	finally
    //   803	814	1000	finally
    //   819	827	1000	finally
    //   832	844	1000	finally
    //   852	866	1000	finally
    //   869	881	1000	finally
    //   886	897	1000	finally
    //   897	911	1000	finally
    //   914	926	1000	finally
    //   931	942	1000	finally
    //   952	960	1000	finally
    //   51	74	1005	java/lang/Exception
  }
  
  /* Error */
  public void a(SearchHistory paramSearchHistory)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   5: aload_1
    //   6: invokestatic 302	java/lang/System:currentTimeMillis	()J
    //   9: putfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   12: aload_1
    //   13: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   16: lookupswitch	default:+124->140, 0:+125->141, 1:+273->289, 1000:+393->409, 1004:+433->449, 1006:+353->369, 1008:+513->529, 1021:+473->489, 3000:+313->329, 7220:+566->582, 56938:+353->369, 56939:+353->369, 56940:+353->369, 56941:+353->369, 56942:+353->369
    //   141: aload_1
    //   142: aload_0
    //   143: aload_1
    //   144: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   147: invokespecial 304	ajrs:a	(Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   153: aload_1
    //   154: getfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   157: ifnonnull +13 -> 170
    //   160: aload_1
    //   161: ldc_w 305
    //   164: invokestatic 309	ajjy:a	(I)Ljava/lang/String;
    //   167: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   170: aload_1
    //   171: new 53	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   178: aload_1
    //   179: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   182: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: sipush 10001
    //   188: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   197: aload_0
    //   198: getfield 37	ajrs:jdField_a_of_type_Atmp	Latmp;
    //   201: ldc 138
    //   203: aload_1
    //   204: getfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   207: invokevirtual 213	atmp:a	(Ljava/lang/Class;Ljava/lang/String;)Latmo;
    //   210: checkcast 138	com/tencent/mobileqq/data/SearchHistory
    //   213: astore_2
    //   214: aload_2
    //   215: ifnull +407 -> 622
    //   218: aload_2
    //   219: aload_1
    //   220: getfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   223: putfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   226: aload_2
    //   227: aload_2
    //   228: getfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   231: iconst_1
    //   232: iadd
    //   233: putfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   236: aload_2
    //   237: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   240: aload_1
    //   241: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   244: if_icmpeq +35 -> 279
    //   247: aload_2
    //   248: aload_1
    //   249: getfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   252: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   255: aload_2
    //   256: aload_1
    //   257: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   260: putfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   263: aload_2
    //   264: aload_1
    //   265: getfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   268: putfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   271: aload_2
    //   272: aload_1
    //   273: getfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   276: putfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   279: aload_0
    //   280: getfield 37	ajrs:jdField_a_of_type_Atmp	Latmp;
    //   283: aload_2
    //   284: invokevirtual 311	atmp:a	(Latmo;)Z
    //   287: pop
    //   288: return
    //   289: aload_1
    //   290: ldc_w 312
    //   293: invokestatic 309	ajjy:a	(I)Ljava/lang/String;
    //   296: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   299: aload_1
    //   300: new 53	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   307: aload_1
    //   308: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   311: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: sipush 10000
    //   317: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   326: goto -129 -> 197
    //   329: aload_1
    //   330: ldc_w 313
    //   333: invokestatic 309	ajjy:a	(I)Ljava/lang/String;
    //   336: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   339: aload_1
    //   340: new 53	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   347: aload_1
    //   348: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   351: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: sipush 10000
    //   357: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   360: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   366: goto -169 -> 197
    //   369: aload_1
    //   370: ldc_w 314
    //   373: invokestatic 309	ajjy:a	(I)Ljava/lang/String;
    //   376: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   379: aload_1
    //   380: new 53	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   387: aload_1
    //   388: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   391: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: sipush 10001
    //   397: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   406: goto -209 -> 197
    //   409: aload_1
    //   410: ldc_w 315
    //   413: invokestatic 309	ajjy:a	(I)Ljava/lang/String;
    //   416: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   419: aload_1
    //   420: new 53	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   427: aload_1
    //   428: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   431: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: sipush 10001
    //   437: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   446: goto -249 -> 197
    //   449: aload_1
    //   450: ldc_w 316
    //   453: invokestatic 309	ajjy:a	(I)Ljava/lang/String;
    //   456: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   459: aload_1
    //   460: new 53	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   467: aload_1
    //   468: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   471: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: sipush 10001
    //   477: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   486: goto -289 -> 197
    //   489: aload_1
    //   490: ldc_w 317
    //   493: invokestatic 309	ajjy:a	(I)Ljava/lang/String;
    //   496: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   499: aload_1
    //   500: new 53	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   507: aload_1
    //   508: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   511: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: sipush 10001
    //   517: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   520: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   526: goto -329 -> 197
    //   529: aload_1
    //   530: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   533: getstatic 252	ajed:ay	Ljava/lang/String;
    //   536: invokestatic 256	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   539: ifeq -342 -> 197
    //   542: aload_1
    //   543: ldc_w 318
    //   546: invokestatic 309	ajjy:a	(I)Ljava/lang/String;
    //   549: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   552: aload_1
    //   553: new 53	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   560: aload_1
    //   561: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   564: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: sipush 10001
    //   570: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   579: goto -382 -> 197
    //   582: aload_1
    //   583: ldc_w 319
    //   586: invokestatic 309	ajjy:a	(I)Ljava/lang/String;
    //   589: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   592: aload_1
    //   593: new 53	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   600: aload_1
    //   601: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   604: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: sipush 10001
    //   610: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   619: goto -422 -> 197
    //   622: aload_0
    //   623: getfield 37	ajrs:jdField_a_of_type_Atmp	Latmp;
    //   626: iconst_0
    //   627: ldc 138
    //   629: invokevirtual 143	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   632: aconst_null
    //   633: aconst_null
    //   634: aconst_null
    //   635: aconst_null
    //   636: aconst_null
    //   637: ldc_w 321
    //   640: aconst_null
    //   641: invokevirtual 150	atmp:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   644: astore_3
    //   645: aload_3
    //   646: ifnull +173 -> 819
    //   649: aload_3
    //   650: astore_2
    //   651: iconst_5
    //   652: aload_3
    //   653: invokeinterface 325 1 0
    //   658: if_icmpgt +161 -> 819
    //   661: aload_3
    //   662: astore_2
    //   663: aload_3
    //   664: invokeinterface 155 1 0
    //   669: ifeq +139 -> 808
    //   672: aload_3
    //   673: astore_2
    //   674: aload_3
    //   675: aload_3
    //   676: ldc 158
    //   678: invokeinterface 162 2 0
    //   683: invokeinterface 165 2 0
    //   688: astore 4
    //   690: aload_3
    //   691: astore_2
    //   692: aload_0
    //   693: getfield 37	ajrs:jdField_a_of_type_Atmp	Latmp;
    //   696: ldc 138
    //   698: aload 4
    //   700: invokevirtual 213	atmp:a	(Ljava/lang/Class;Ljava/lang/String;)Latmo;
    //   703: checkcast 138	com/tencent/mobileqq/data/SearchHistory
    //   706: astore 4
    //   708: aload_3
    //   709: astore_2
    //   710: aload 4
    //   712: aload_1
    //   713: getfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   716: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   719: aload_3
    //   720: astore_2
    //   721: aload 4
    //   723: aload_1
    //   724: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   727: putfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   730: aload_3
    //   731: astore_2
    //   732: aload 4
    //   734: aload_1
    //   735: getfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   738: putfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   741: aload_3
    //   742: astore_2
    //   743: aload 4
    //   745: aload_1
    //   746: getfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   749: putfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   752: aload_3
    //   753: astore_2
    //   754: aload 4
    //   756: aload_1
    //   757: getfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   760: putfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   763: aload_3
    //   764: astore_2
    //   765: aload 4
    //   767: aload_1
    //   768: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   771: putfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   774: aload_3
    //   775: astore_2
    //   776: aload 4
    //   778: aload_1
    //   779: getfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   782: putfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   785: aload_3
    //   786: astore_2
    //   787: aload 4
    //   789: aload_1
    //   790: getfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   793: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   796: aload_3
    //   797: astore_2
    //   798: aload_0
    //   799: getfield 37	ajrs:jdField_a_of_type_Atmp	Latmp;
    //   802: aload 4
    //   804: invokevirtual 311	atmp:a	(Latmo;)Z
    //   807: pop
    //   808: aload_3
    //   809: ifnull -669 -> 140
    //   812: aload_3
    //   813: invokeinterface 222 1 0
    //   818: return
    //   819: aload_3
    //   820: astore_2
    //   821: aload_0
    //   822: getfield 37	ajrs:jdField_a_of_type_Atmp	Latmp;
    //   825: aload_1
    //   826: invokevirtual 328	atmp:a	(Latmo;)V
    //   829: goto -21 -> 808
    //   832: astore_1
    //   833: aload_3
    //   834: astore_2
    //   835: aload_1
    //   836: invokevirtual 331	java/lang/Exception:printStackTrace	()V
    //   839: aload_3
    //   840: ifnull -700 -> 140
    //   843: aload_3
    //   844: invokeinterface 222 1 0
    //   849: return
    //   850: astore_1
    //   851: aconst_null
    //   852: astore_2
    //   853: aload_2
    //   854: ifnull +9 -> 863
    //   857: aload_2
    //   858: invokeinterface 222 1 0
    //   863: aload_1
    //   864: athrow
    //   865: astore_1
    //   866: goto -13 -> 853
    //   869: astore_1
    //   870: aconst_null
    //   871: astore_3
    //   872: goto -39 -> 833
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	875	0	this	ajrs
    //   0	875	1	paramSearchHistory	SearchHistory
    //   213	645	2	localObject1	Object
    //   644	228	3	localCursor	android.database.Cursor
    //   688	115	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   651	661	832	java/lang/Exception
    //   663	672	832	java/lang/Exception
    //   674	690	832	java/lang/Exception
    //   692	708	832	java/lang/Exception
    //   710	719	832	java/lang/Exception
    //   721	730	832	java/lang/Exception
    //   732	741	832	java/lang/Exception
    //   743	752	832	java/lang/Exception
    //   754	763	832	java/lang/Exception
    //   765	774	832	java/lang/Exception
    //   776	785	832	java/lang/Exception
    //   787	796	832	java/lang/Exception
    //   798	808	832	java/lang/Exception
    //   821	829	832	java/lang/Exception
    //   622	645	850	finally
    //   651	661	865	finally
    //   663	672	865	finally
    //   674	690	865	finally
    //   692	708	865	finally
    //   710	719	865	finally
    //   721	730	865	finally
    //   732	741	865	finally
    //   743	752	865	finally
    //   754	763	865	finally
    //   765	774	865	finally
    //   776	785	865	finally
    //   787	796	865	finally
    //   798	808	865	finally
    //   821	829	865	finally
    //   835	839	865	finally
    //   622	645	869	java/lang/Exception
  }
  
  public boolean a(SearchHistory paramSearchHistory)
  {
    boolean bool = false;
    if (paramSearchHistory != null)
    {
      paramSearchHistory.setStatus(1001);
      bool = this.jdField_a_of_type_Atmp.b(paramSearchHistory);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajrs
 * JD-Core Version:    0.7.0.1
 */