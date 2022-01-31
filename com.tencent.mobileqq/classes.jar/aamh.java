import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.Conversation;

public class aamh
  implements Handler.Callback
{
  public aamh(Conversation paramConversation) {}
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_1
    //   8: getfield 26	android/os/Message:what	I
    //   11: ldc 27
    //   13: if_icmpne +16 -> 29
    //   16: aload_0
    //   17: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   20: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   23: bipush 12
    //   25: iconst_0
    //   26: invokevirtual 37	agxq:a	(II)V
    //   29: aload_1
    //   30: getfield 26	android/os/Message:what	I
    //   33: ldc 38
    //   35: if_icmpeq +18 -> 53
    //   38: aload_0
    //   39: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   42: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   48: ifne +5 -> 53
    //   51: iconst_1
    //   52: ireturn
    //   53: aload_1
    //   54: getfield 26	android/os/Message:what	I
    //   57: lookupswitch	default:+731->788, 1009:+742->799, 1010:+777->834, 1014:+2885->2942, 1016:+2895->2952, 1017:+2962->3019, 1019:+3293->3350, 1020:+2972->3029, 1023:+1168->1225, 1024:+3312->3369, 1025:+733->790, 1030:+3336->3393, 1032:+2773->2830, 1033:+2801->2858, 1035:+3443->3500, 1038:+3452->3509, 1039:+3480->3537, 1040:+2829->2886, 1041:+2857->2914, 1042:+3564->3621, 1044:+3593->3650, 1048:+3615->3672, 1049:+3508->3565, 1050:+3536->3593, 1052:+3692->3749, 1053:+3737->3794, 1054:+3766->3823, 1055:+3844->3901, 1059:+4487->4544, 1060:+4505->4562, 1061:+4522->4579, 1062:+853->910, 1063:+1079->1136, 1064:+1135->1192, 1067:+4535->4592, 1068:+4129->4186, 1069:+4021->4078, 1070:+4237->4294, 1071:+4544->4601, 10000:+2981->3038, 10001:+766->823, 10002:+766->823, 10003:+766->823, 1134010:+1750->1807, 1134011:+1813->1870, 1134012:+2710->2767, 1134013:+2736->2793, 1134014:+2762->2819, 1134015:+2684->2741, 1134018:+1316->1373, 1134019:+1497->1554, 1134020:+1580->1637, 1134021:+2481->2538, 1134022:+2509->2566, 1134024:+2651->2708, 1134025:+3345->3402, 1134026:+3397->3454, 1134027:+1897->1954, 1134028:+1954->2011, 1134030:+3746->3803, 1134039:+2241->2298, 1134040:+2298->2355, 1134041:+2326->2383, 1134042:+2383->2440, 1134043:+1982->2039, 1134044:+2010->2067, 1134045:+1590->1647, 1134047:+1600->1657, 1134048:+1617->1674, 1134049:+2411->2468, 1134050:+2453->2510, 1134051:+2038->2095, 1134052:+2090->2147, 1134053:+2134->2191, 1134054:+-6->51, 1134057:+1634->1691, 1134058:+1651->1708, 1134059:+1841->1898, 1134060:+1869->1926, 1134061:+4270->4327, 1134062:+4304->4361, 1134063:+4393->4450, 1134064:+4454->4511, 1134065:+1778->1835, 1134066:+2537->2594, 1134067:+2594->2651, 1134068:+4316->4373, 1134200:+3896->3953, 1134201:+3942->3999, 11340003:+1185->1242, 11340004:+1722->1779
    //   789: ireturn
    //   790: aload_0
    //   791: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   794: invokestatic 49	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   797: iconst_1
    //   798: ireturn
    //   799: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq +11 -> 813
    //   805: ldc 56
    //   807: iconst_2
    //   808: ldc 58
    //   810: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   813: aload_0
    //   814: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   817: lconst_0
    //   818: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   821: iconst_1
    //   822: ireturn
    //   823: aload_0
    //   824: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   827: aload_1
    //   828: iconst_1
    //   829: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   832: iconst_1
    //   833: ireturn
    //   834: aload_0
    //   835: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   838: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   841: invokevirtual 71	agxq:c	()Z
    //   844: ifeq +38 -> 882
    //   847: aload_0
    //   848: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   851: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   854: bipush 20
    //   856: iconst_2
    //   857: invokevirtual 37	agxq:a	(II)V
    //   860: aload_0
    //   861: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   864: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   867: bipush 20
    //   869: aload_1
    //   870: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   873: aload_0
    //   874: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   877: invokestatic 77	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   880: iconst_1
    //   881: ireturn
    //   882: aload_0
    //   883: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   886: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   889: bipush 20
    //   891: iconst_0
    //   892: invokevirtual 37	agxq:a	(II)V
    //   895: aload_0
    //   896: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   899: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   902: bipush 20
    //   904: aconst_null
    //   905: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   908: iconst_1
    //   909: ireturn
    //   910: aload_1
    //   911: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   914: astore 10
    //   916: aload 10
    //   918: ifnonnull +72 -> 990
    //   921: aload_0
    //   922: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   925: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   928: invokevirtual 83	agxq:b	()Z
    //   931: ifeq +31 -> 962
    //   934: aload_0
    //   935: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   938: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   941: bipush 19
    //   943: iconst_2
    //   944: invokevirtual 37	agxq:a	(II)V
    //   947: aload_0
    //   948: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   951: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   954: bipush 19
    //   956: aload_1
    //   957: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   960: iconst_1
    //   961: ireturn
    //   962: aload_0
    //   963: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   966: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   969: bipush 19
    //   971: iconst_0
    //   972: invokevirtual 37	agxq:a	(II)V
    //   975: aload_0
    //   976: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   979: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   982: bipush 19
    //   984: aconst_null
    //   985: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   988: iconst_1
    //   989: ireturn
    //   990: aload 10
    //   992: instanceof 85
    //   995: ifeq -944 -> 51
    //   998: aload 10
    //   1000: checkcast 85	[Landroid/view/View;
    //   1003: checkcast 85	[Landroid/view/View;
    //   1006: astore 10
    //   1008: aload 10
    //   1010: arraylength
    //   1011: iconst_3
    //   1012: if_icmpne -961 -> 51
    //   1015: aload 10
    //   1017: iconst_0
    //   1018: aaload
    //   1019: astore_1
    //   1020: aload 10
    //   1022: iconst_1
    //   1023: aaload
    //   1024: astore 11
    //   1026: aload 10
    //   1028: iconst_2
    //   1029: aaload
    //   1030: astore 10
    //   1032: aload_1
    //   1033: ifnull -982 -> 51
    //   1036: aload_1
    //   1037: invokevirtual 91	android/view/View:getParent	()Landroid/view/ViewParent;
    //   1040: ifnonnull -989 -> 51
    //   1043: aload_0
    //   1044: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1047: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1050: ldc 95
    //   1052: invokevirtual 101	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   1055: astore 11
    //   1057: aload 11
    //   1059: ifnull +15 -> 1074
    //   1062: aload_0
    //   1063: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1066: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1069: aload 11
    //   1071: invokevirtual 105	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   1074: aload_0
    //   1075: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1078: invokestatic 108	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   1081: ifnull +24 -> 1105
    //   1084: aload_0
    //   1085: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1088: invokestatic 108	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   1091: invokeinterface 113 1 0
    //   1096: ifeq +9 -> 1105
    //   1099: aload_1
    //   1100: bipush 8
    //   1102: invokevirtual 117	android/view/View:setVisibility	(I)V
    //   1105: aload_0
    //   1106: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1109: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1112: aload_1
    //   1113: invokevirtual 120	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1116: aload 10
    //   1118: ifnull -1067 -> 51
    //   1121: aload 10
    //   1123: new 122	aami
    //   1126: dup
    //   1127: aload_0
    //   1128: invokespecial 125	aami:<init>	(Laamh;)V
    //   1131: invokevirtual 129	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1134: iconst_1
    //   1135: ireturn
    //   1136: aload_0
    //   1137: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1140: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1143: ifnull +13 -> 1156
    //   1146: aload_0
    //   1147: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1150: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1153: invokevirtual 132	agxq:f	()V
    //   1156: aload_0
    //   1157: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1160: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1163: ldc 95
    //   1165: invokevirtual 101	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   1168: astore_1
    //   1169: aload_1
    //   1170: ifnull -1119 -> 51
    //   1173: aload_1
    //   1174: bipush 8
    //   1176: invokevirtual 117	android/view/View:setVisibility	(I)V
    //   1179: aload_0
    //   1180: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1183: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1186: aload_1
    //   1187: invokevirtual 105	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   1190: iconst_1
    //   1191: ireturn
    //   1192: aload_1
    //   1193: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1196: astore_1
    //   1197: aload_1
    //   1198: ifnull -1147 -> 51
    //   1201: aload_1
    //   1202: instanceof 134
    //   1205: ifeq -1154 -> 51
    //   1208: new 136	com/tencent/mobileqq/activity/Conversation$1$2
    //   1211: dup
    //   1212: aload_0
    //   1213: aload_1
    //   1214: checkcast 134	java/lang/String
    //   1217: invokespecial 139	com/tencent/mobileqq/activity/Conversation$1$2:<init>	(Laamh;Ljava/lang/String;)V
    //   1220: invokestatic 145	com/tencent/mobileqq/app/ThreadManagerV2:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   1223: iconst_1
    //   1224: ireturn
    //   1225: invokestatic 151	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1228: new 153	com/tencent/mobileqq/activity/Conversation$1$3
    //   1231: dup
    //   1232: aload_0
    //   1233: invokespecial 154	com/tencent/mobileqq/activity/Conversation$1$3:<init>	(Laamh;)V
    //   1236: invokevirtual 160	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1239: pop
    //   1240: iconst_1
    //   1241: ireturn
    //   1242: invokestatic 165	akgo:a	()Lakgo;
    //   1245: invokevirtual 168	akgo:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   1248: astore 10
    //   1250: aload 10
    //   1252: getfield 173	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1255: ifnull -1204 -> 51
    //   1258: aload_0
    //   1259: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1262: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1265: invokevirtual 177	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   1268: astore 11
    //   1270: aload 11
    //   1272: ldc 179
    //   1274: lconst_0
    //   1275: invokeinterface 185 4 0
    //   1280: lstore 5
    //   1282: new 187	java/util/Date
    //   1285: dup
    //   1286: invokespecial 188	java/util/Date:<init>	()V
    //   1289: invokevirtual 192	java/util/Date:getTime	()J
    //   1292: lstore 7
    //   1294: lload 7
    //   1296: lload 5
    //   1298: lsub
    //   1299: aload 10
    //   1301: getfield 173	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1304: getfield 198	com/tencent/mobileqq/app/NewUpgradeConfig:dialog	Lajnl;
    //   1307: getfield 202	ajnl:b	I
    //   1310: bipush 24
    //   1312: imul
    //   1313: bipush 60
    //   1315: imul
    //   1316: bipush 60
    //   1318: imul
    //   1319: sipush 1000
    //   1322: imul
    //   1323: i2l
    //   1324: lcmp
    //   1325: ifle -1274 -> 51
    //   1328: aload_0
    //   1329: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1332: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1335: bipush 12
    //   1337: iconst_2
    //   1338: invokevirtual 37	agxq:a	(II)V
    //   1341: aload_0
    //   1342: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1345: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1348: bipush 12
    //   1350: aload_1
    //   1351: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   1354: aload 11
    //   1356: invokeinterface 206 1 0
    //   1361: ldc 179
    //   1363: lload 7
    //   1365: invokeinterface 212 4 0
    //   1370: pop
    //   1371: iconst_1
    //   1372: ireturn
    //   1373: invokestatic 165	akgo:a	()Lakgo;
    //   1376: invokevirtual 168	akgo:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   1379: astore 10
    //   1381: aload 10
    //   1383: getfield 173	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1386: ifnull -1335 -> 51
    //   1389: aload_0
    //   1390: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1393: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1396: invokevirtual 177	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   1399: astore 11
    //   1401: aload 11
    //   1403: ldc 179
    //   1405: lconst_0
    //   1406: invokeinterface 185 4 0
    //   1411: lstore 5
    //   1413: new 187	java/util/Date
    //   1416: dup
    //   1417: invokespecial 188	java/util/Date:<init>	()V
    //   1420: invokevirtual 192	java/util/Date:getTime	()J
    //   1423: lstore 7
    //   1425: lload 7
    //   1427: lload 5
    //   1429: lsub
    //   1430: aload 10
    //   1432: getfield 173	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1435: getfield 198	com/tencent/mobileqq/app/NewUpgradeConfig:dialog	Lajnl;
    //   1438: getfield 202	ajnl:b	I
    //   1441: bipush 24
    //   1443: imul
    //   1444: bipush 60
    //   1446: imul
    //   1447: bipush 60
    //   1449: imul
    //   1450: sipush 1000
    //   1453: imul
    //   1454: i2l
    //   1455: lcmp
    //   1456: ifle +64 -> 1520
    //   1459: aload_0
    //   1460: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1463: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1466: bipush 14
    //   1468: iconst_2
    //   1469: invokevirtual 37	agxq:a	(II)V
    //   1472: aload_0
    //   1473: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1476: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1479: bipush 12
    //   1481: iconst_0
    //   1482: invokevirtual 37	agxq:a	(II)V
    //   1485: aload_0
    //   1486: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1489: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1492: bipush 14
    //   1494: aload_1
    //   1495: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   1498: aload 11
    //   1500: invokeinterface 206 1 0
    //   1505: ldc 179
    //   1507: lload 7
    //   1509: invokeinterface 212 4 0
    //   1514: invokeinterface 215 1 0
    //   1519: pop
    //   1520: aload_1
    //   1521: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1524: ifnull -1473 -> 51
    //   1527: aload_1
    //   1528: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1531: instanceof 217
    //   1534: ifeq -1483 -> 51
    //   1537: aload_1
    //   1538: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1541: checkcast 217	com/tencent/mobileqq/activity/UpgradeActivity
    //   1544: astore_1
    //   1545: invokestatic 165	akgo:a	()Lakgo;
    //   1548: aload_1
    //   1549: invokevirtual 220	akgo:a	(Landroid/content/Context;)V
    //   1552: iconst_1
    //   1553: ireturn
    //   1554: aload_0
    //   1555: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1558: invokestatic 223	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1561: ifnull +22 -> 1583
    //   1564: aload_0
    //   1565: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1568: invokestatic 223	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1571: invokevirtual 228	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   1574: aload_0
    //   1575: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1578: aconst_null
    //   1579: invokestatic 231	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1582: pop
    //   1583: aload_0
    //   1584: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1587: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1590: bipush 14
    //   1592: iconst_0
    //   1593: invokevirtual 37	agxq:a	(II)V
    //   1596: aload_0
    //   1597: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1600: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1603: bipush 14
    //   1605: aload_1
    //   1606: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   1609: iconst_1
    //   1610: ireturn
    //   1611: astore 10
    //   1613: aload_0
    //   1614: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1617: aconst_null
    //   1618: invokestatic 231	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1621: pop
    //   1622: goto -39 -> 1583
    //   1625: astore_1
    //   1626: aload_0
    //   1627: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1630: aconst_null
    //   1631: invokestatic 231	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1634: pop
    //   1635: aload_1
    //   1636: athrow
    //   1637: aload_0
    //   1638: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1641: aload_1
    //   1642: invokestatic 234	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1645: iconst_1
    //   1646: ireturn
    //   1647: aload_0
    //   1648: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1651: aload_1
    //   1652: invokestatic 236	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1655: iconst_1
    //   1656: ireturn
    //   1657: invokestatic 151	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1660: new 238	com/tencent/mobileqq/activity/Conversation$1$4
    //   1663: dup
    //   1664: aload_0
    //   1665: invokespecial 239	com/tencent/mobileqq/activity/Conversation$1$4:<init>	(Laamh;)V
    //   1668: invokevirtual 160	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1671: pop
    //   1672: iconst_1
    //   1673: ireturn
    //   1674: invokestatic 151	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1677: new 241	com/tencent/mobileqq/activity/Conversation$1$5
    //   1680: dup
    //   1681: aload_0
    //   1682: invokespecial 242	com/tencent/mobileqq/activity/Conversation$1$5:<init>	(Laamh;)V
    //   1685: invokevirtual 160	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1688: pop
    //   1689: iconst_1
    //   1690: ireturn
    //   1691: new 244	com/tencent/mobileqq/activity/Conversation$1$6
    //   1694: dup
    //   1695: aload_0
    //   1696: invokespecial 245	com/tencent/mobileqq/activity/Conversation$1$6:<init>	(Laamh;)V
    //   1699: bipush 8
    //   1701: aconst_null
    //   1702: iconst_1
    //   1703: invokestatic 248	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1706: iconst_1
    //   1707: ireturn
    //   1708: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1711: ifeq +11 -> 1722
    //   1714: ldc 56
    //   1716: iconst_2
    //   1717: ldc 250
    //   1719: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1722: aload_0
    //   1723: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1726: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1729: invokestatic 258	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;
    //   1732: astore 10
    //   1734: aload 10
    //   1736: invokevirtual 260	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	()V
    //   1739: aload_0
    //   1740: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1743: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1746: aload 10
    //   1748: invokestatic 263	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   1751: aload_0
    //   1752: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1755: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1758: bipush 25
    //   1760: iconst_0
    //   1761: invokevirtual 37	agxq:a	(II)V
    //   1764: aload_0
    //   1765: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1768: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1771: bipush 25
    //   1773: aload_1
    //   1774: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   1777: iconst_1
    //   1778: ireturn
    //   1779: aload_0
    //   1780: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1783: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1786: bipush 12
    //   1788: iconst_0
    //   1789: invokevirtual 37	agxq:a	(II)V
    //   1792: aload_0
    //   1793: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1796: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1799: bipush 12
    //   1801: aload_1
    //   1802: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   1805: iconst_1
    //   1806: ireturn
    //   1807: aload_0
    //   1808: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1811: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1814: bipush 35
    //   1816: iconst_2
    //   1817: invokevirtual 37	agxq:a	(II)V
    //   1820: aload_0
    //   1821: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1824: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1827: bipush 35
    //   1829: aload_1
    //   1830: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   1833: iconst_1
    //   1834: ireturn
    //   1835: aload_1
    //   1836: ifnull -1785 -> 51
    //   1839: aload_0
    //   1840: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1843: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1846: bipush 10
    //   1848: aload_1
    //   1849: getfield 266	android/os/Message:arg1	I
    //   1852: invokevirtual 37	agxq:a	(II)V
    //   1855: aload_0
    //   1856: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1859: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1862: bipush 10
    //   1864: aload_1
    //   1865: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   1868: iconst_1
    //   1869: ireturn
    //   1870: aload_0
    //   1871: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1874: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1877: bipush 35
    //   1879: iconst_0
    //   1880: invokevirtual 37	agxq:a	(II)V
    //   1883: aload_0
    //   1884: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1887: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1890: bipush 35
    //   1892: aload_1
    //   1893: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   1896: iconst_1
    //   1897: ireturn
    //   1898: aload_0
    //   1899: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1902: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1905: bipush 33
    //   1907: iconst_2
    //   1908: invokevirtual 37	agxq:a	(II)V
    //   1911: aload_0
    //   1912: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1915: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1918: bipush 33
    //   1920: aload_1
    //   1921: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   1924: iconst_1
    //   1925: ireturn
    //   1926: aload_0
    //   1927: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1930: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1933: bipush 33
    //   1935: iconst_0
    //   1936: invokevirtual 37	agxq:a	(II)V
    //   1939: aload_0
    //   1940: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1943: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1946: bipush 33
    //   1948: aload_1
    //   1949: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   1952: iconst_1
    //   1953: ireturn
    //   1954: aload_0
    //   1955: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1958: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1961: ldc_w 270
    //   1964: invokevirtual 274	mqq/os/MqqHandler:hasMessages	(I)Z
    //   1967: ifeq +16 -> 1983
    //   1970: aload_0
    //   1971: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1974: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1977: ldc_w 270
    //   1980: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   1983: aload_0
    //   1984: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1987: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   1990: bipush 27
    //   1992: iconst_2
    //   1993: invokevirtual 37	agxq:a	(II)V
    //   1996: aload_0
    //   1997: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2000: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2003: bipush 27
    //   2005: aload_1
    //   2006: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2009: iconst_1
    //   2010: ireturn
    //   2011: aload_0
    //   2012: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2015: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2018: bipush 27
    //   2020: iconst_0
    //   2021: invokevirtual 37	agxq:a	(II)V
    //   2024: aload_0
    //   2025: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2028: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2031: bipush 27
    //   2033: aload_1
    //   2034: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2037: iconst_1
    //   2038: ireturn
    //   2039: aload_0
    //   2040: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2043: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2046: bipush 31
    //   2048: iconst_2
    //   2049: invokevirtual 37	agxq:a	(II)V
    //   2052: aload_0
    //   2053: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2056: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2059: bipush 31
    //   2061: aload_1
    //   2062: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2065: iconst_1
    //   2066: ireturn
    //   2067: aload_0
    //   2068: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2071: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2074: bipush 31
    //   2076: iconst_0
    //   2077: invokevirtual 37	agxq:a	(II)V
    //   2080: aload_0
    //   2081: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2084: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2087: bipush 31
    //   2089: aload_1
    //   2090: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2093: iconst_1
    //   2094: ireturn
    //   2095: aload_1
    //   2096: getfield 266	android/os/Message:arg1	I
    //   2099: iconst_1
    //   2100: if_icmpeq +16 -> 2116
    //   2103: aload_0
    //   2104: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2107: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2110: bipush 32
    //   2112: iconst_2
    //   2113: invokevirtual 37	agxq:a	(II)V
    //   2116: aload_0
    //   2117: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2120: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2123: bipush 32
    //   2125: aload_1
    //   2126: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2129: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2132: ifeq -2081 -> 51
    //   2135: ldc_w 279
    //   2138: iconst_2
    //   2139: ldc_w 281
    //   2142: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2145: iconst_1
    //   2146: ireturn
    //   2147: aload_0
    //   2148: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2151: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2154: bipush 32
    //   2156: iconst_0
    //   2157: invokevirtual 37	agxq:a	(II)V
    //   2160: aload_0
    //   2161: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2164: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2167: bipush 32
    //   2169: aload_1
    //   2170: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2173: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2176: ifeq -2125 -> 51
    //   2179: ldc_w 279
    //   2182: iconst_2
    //   2183: ldc_w 283
    //   2186: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2189: iconst_1
    //   2190: ireturn
    //   2191: aload_0
    //   2192: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2195: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2198: sipush 153
    //   2201: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2204: checkcast 289	aifg
    //   2207: astore 10
    //   2209: aconst_null
    //   2210: invokestatic 294	aing:a	(Ljava/lang/Object;)Z
    //   2213: ifeq +9 -> 2222
    //   2216: aload 10
    //   2218: iconst_1
    //   2219: putfield 298	aifg:k	Z
    //   2222: aload_0
    //   2223: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2226: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2229: getfield 301	com/tencent/mobileqq/app/QQAppInterface:o	Z
    //   2232: ifeq +10 -> 2242
    //   2235: aconst_null
    //   2236: invokestatic 294	aing:a	(Ljava/lang/Object;)Z
    //   2239: ifeq +19 -> 2258
    //   2242: aload 10
    //   2244: ifnull -2193 -> 51
    //   2247: aload 10
    //   2249: iconst_1
    //   2250: putfield 304	aifg:j	Z
    //   2253: iconst_1
    //   2254: ireturn
    //   2255: astore_1
    //   2256: iconst_1
    //   2257: ireturn
    //   2258: invokestatic 307	com/tencent/mobileqq/app/FrameHelperActivity:b	()Z
    //   2261: ifeq +10 -> 2271
    //   2264: iconst_1
    //   2265: invokestatic 310	com/tencent/mobileqq/app/FrameHelperActivity:c	(Z)V
    //   2268: invokestatic 313	com/tencent/mobileqq/app/FrameHelperActivity:s	()V
    //   2271: aload_0
    //   2272: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2275: getfield 315	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   2278: aload_1
    //   2279: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   2282: checkcast 134	java/lang/String
    //   2285: invokestatic 318	aing:a	(Landroid/view/View;Ljava/lang/String;)V
    //   2288: aload_0
    //   2289: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2292: iconst_1
    //   2293: putfield 320	com/tencent/mobileqq/activity/Conversation:d	Z
    //   2296: iconst_1
    //   2297: ireturn
    //   2298: aload_0
    //   2299: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2302: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2305: ldc_w 321
    //   2308: invokevirtual 274	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2311: ifeq +16 -> 2327
    //   2314: aload_0
    //   2315: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2318: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2321: ldc_w 321
    //   2324: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   2327: aload_0
    //   2328: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2331: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2334: bipush 28
    //   2336: iconst_2
    //   2337: invokevirtual 37	agxq:a	(II)V
    //   2340: aload_0
    //   2341: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2344: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2347: bipush 28
    //   2349: aload_1
    //   2350: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2353: iconst_1
    //   2354: ireturn
    //   2355: aload_0
    //   2356: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2359: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2362: bipush 28
    //   2364: iconst_0
    //   2365: invokevirtual 37	agxq:a	(II)V
    //   2368: aload_0
    //   2369: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2372: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2375: bipush 28
    //   2377: aload_1
    //   2378: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2381: iconst_1
    //   2382: ireturn
    //   2383: aload_0
    //   2384: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2387: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2390: ldc_w 322
    //   2393: invokevirtual 274	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2396: ifeq +16 -> 2412
    //   2399: aload_0
    //   2400: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2403: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2406: ldc_w 322
    //   2409: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   2412: aload_0
    //   2413: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2416: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2419: bipush 29
    //   2421: iconst_2
    //   2422: invokevirtual 37	agxq:a	(II)V
    //   2425: aload_0
    //   2426: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2429: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2432: bipush 29
    //   2434: aload_1
    //   2435: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2438: iconst_1
    //   2439: ireturn
    //   2440: aload_0
    //   2441: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2444: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2447: bipush 29
    //   2449: iconst_0
    //   2450: invokevirtual 37	agxq:a	(II)V
    //   2453: aload_0
    //   2454: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2457: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2460: bipush 29
    //   2462: aload_1
    //   2463: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2466: iconst_1
    //   2467: ireturn
    //   2468: aload_0
    //   2469: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2472: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2475: ldc_w 323
    //   2478: invokevirtual 274	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2481: ifeq +16 -> 2497
    //   2484: aload_0
    //   2485: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2488: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2491: ldc_w 323
    //   2494: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   2497: aload_0
    //   2498: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2501: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2504: aload_1
    //   2505: invokevirtual 326	agxq:a	(Landroid/os/Message;)V
    //   2508: iconst_1
    //   2509: ireturn
    //   2510: aload_0
    //   2511: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2514: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2517: bipush 30
    //   2519: iconst_0
    //   2520: invokevirtual 37	agxq:a	(II)V
    //   2523: aload_0
    //   2524: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2527: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2530: bipush 30
    //   2532: aload_1
    //   2533: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2536: iconst_1
    //   2537: ireturn
    //   2538: aload_0
    //   2539: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2542: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2545: bipush 7
    //   2547: iconst_2
    //   2548: invokevirtual 37	agxq:a	(II)V
    //   2551: aload_0
    //   2552: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2555: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2558: bipush 7
    //   2560: aload_1
    //   2561: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2564: iconst_1
    //   2565: ireturn
    //   2566: aload_0
    //   2567: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2570: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2573: bipush 7
    //   2575: iconst_0
    //   2576: invokevirtual 37	agxq:a	(II)V
    //   2579: aload_0
    //   2580: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2583: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2586: bipush 7
    //   2588: aload_1
    //   2589: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2592: iconst_1
    //   2593: ireturn
    //   2594: aload_0
    //   2595: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2598: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2601: ldc_w 327
    //   2604: invokevirtual 274	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2607: ifeq +16 -> 2623
    //   2610: aload_0
    //   2611: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2614: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2617: ldc_w 327
    //   2620: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   2623: aload_0
    //   2624: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2627: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2630: bipush 40
    //   2632: iconst_2
    //   2633: invokevirtual 37	agxq:a	(II)V
    //   2636: aload_0
    //   2637: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2640: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2643: bipush 40
    //   2645: aload_1
    //   2646: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2649: iconst_1
    //   2650: ireturn
    //   2651: aload_0
    //   2652: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2655: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2658: ldc_w 328
    //   2661: invokevirtual 274	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2664: ifeq +16 -> 2680
    //   2667: aload_0
    //   2668: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2671: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2674: ldc_w 328
    //   2677: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   2680: aload_0
    //   2681: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2684: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2687: bipush 40
    //   2689: iconst_0
    //   2690: invokevirtual 37	agxq:a	(II)V
    //   2693: aload_0
    //   2694: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2697: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2700: bipush 40
    //   2702: aload_1
    //   2703: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2706: iconst_1
    //   2707: ireturn
    //   2708: aload_1
    //   2709: getfield 266	android/os/Message:arg1	I
    //   2712: istore_2
    //   2713: aload_0
    //   2714: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2717: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2720: bipush 8
    //   2722: iload_2
    //   2723: invokevirtual 37	agxq:a	(II)V
    //   2726: aload_0
    //   2727: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2730: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2733: bipush 8
    //   2735: aload_1
    //   2736: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2739: iconst_1
    //   2740: ireturn
    //   2741: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2744: ifeq +12 -> 2756
    //   2747: ldc 56
    //   2749: iconst_2
    //   2750: ldc_w 330
    //   2753: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2756: aload_0
    //   2757: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2760: aload_1
    //   2761: iconst_0
    //   2762: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2765: iconst_1
    //   2766: ireturn
    //   2767: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2770: ifeq +12 -> 2782
    //   2773: ldc 56
    //   2775: iconst_2
    //   2776: ldc_w 332
    //   2779: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2782: aload_0
    //   2783: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2786: aload_1
    //   2787: iconst_1
    //   2788: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2791: iconst_1
    //   2792: ireturn
    //   2793: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2796: ifeq +12 -> 2808
    //   2799: ldc 56
    //   2801: iconst_2
    //   2802: ldc_w 334
    //   2805: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2808: aload_0
    //   2809: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2812: aload_1
    //   2813: iconst_1
    //   2814: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2817: iconst_1
    //   2818: ireturn
    //   2819: aload_0
    //   2820: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2823: aconst_null
    //   2824: iconst_1
    //   2825: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2828: iconst_1
    //   2829: ireturn
    //   2830: aload_0
    //   2831: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2834: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2837: bipush 21
    //   2839: iconst_2
    //   2840: invokevirtual 37	agxq:a	(II)V
    //   2843: aload_0
    //   2844: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2847: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2850: bipush 21
    //   2852: aload_1
    //   2853: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2856: iconst_1
    //   2857: ireturn
    //   2858: aload_0
    //   2859: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2862: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2865: bipush 21
    //   2867: iconst_0
    //   2868: invokevirtual 37	agxq:a	(II)V
    //   2871: aload_0
    //   2872: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2875: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2878: bipush 21
    //   2880: aload_1
    //   2881: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2884: iconst_1
    //   2885: ireturn
    //   2886: aload_0
    //   2887: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2890: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2893: bipush 6
    //   2895: iconst_2
    //   2896: invokevirtual 37	agxq:a	(II)V
    //   2899: aload_0
    //   2900: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2903: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2906: bipush 6
    //   2908: aload_1
    //   2909: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2912: iconst_1
    //   2913: ireturn
    //   2914: aload_0
    //   2915: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2918: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2921: bipush 6
    //   2923: iconst_0
    //   2924: invokevirtual 37	agxq:a	(II)V
    //   2927: aload_0
    //   2928: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2931: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   2934: bipush 6
    //   2936: aload_1
    //   2937: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   2940: iconst_1
    //   2941: ireturn
    //   2942: aload_0
    //   2943: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2946: lconst_0
    //   2947: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   2950: iconst_1
    //   2951: ireturn
    //   2952: aload_0
    //   2953: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2956: iconst_0
    //   2957: putfield 337	com/tencent/mobileqq/activity/Conversation:g	Z
    //   2960: aload_0
    //   2961: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2964: invokestatic 340	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   2967: ifnull +13 -> 2980
    //   2970: aload_0
    //   2971: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2974: invokestatic 340	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   2977: invokevirtual 345	com/tencent/mobileqq/fpsreport/FPSSwipListView:springBackOverScrollHeaderView	()V
    //   2980: aload_0
    //   2981: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2984: getfield 348	com/tencent/mobileqq/activity/Conversation:c	J
    //   2987: lconst_0
    //   2988: lcmp
    //   2989: ifle +20 -> 3009
    //   2992: ldc_w 350
    //   2995: invokestatic 355	android/os/SystemClock:uptimeMillis	()J
    //   2998: aload_0
    //   2999: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3002: getfield 348	com/tencent/mobileqq/activity/Conversation:c	J
    //   3005: lsub
    //   3006: invokestatic 360	baio:a	(Ljava/lang/String;J)V
    //   3009: aload_0
    //   3010: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3013: lconst_0
    //   3014: putfield 348	com/tencent/mobileqq/activity/Conversation:c	J
    //   3017: iconst_1
    //   3018: ireturn
    //   3019: aload_0
    //   3020: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3023: lconst_0
    //   3024: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   3027: iconst_1
    //   3028: ireturn
    //   3029: aload_0
    //   3030: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3033: invokevirtual 363	com/tencent/mobileqq/activity/Conversation:r	()V
    //   3036: iconst_1
    //   3037: ireturn
    //   3038: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   3041: aload_0
    //   3042: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3045: getfield 371	com/tencent/mobileqq/activity/Conversation:e	J
    //   3048: lsub
    //   3049: invokestatic 377	java/lang/Math:abs	(J)J
    //   3052: lstore 5
    //   3054: invokestatic 380	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3057: ifeq +49 -> 3106
    //   3060: ldc 56
    //   3062: iconst_4
    //   3063: new 382	java/lang/StringBuilder
    //   3066: dup
    //   3067: invokespecial 383	java/lang/StringBuilder:<init>	()V
    //   3070: ldc_w 385
    //   3073: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3076: aload_1
    //   3077: getfield 266	android/os/Message:arg1	I
    //   3080: invokevirtual 392	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3083: ldc_w 394
    //   3086: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3089: lload 5
    //   3091: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3094: ldc_w 399
    //   3097: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3100: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3103: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3106: lload 5
    //   3108: lconst_0
    //   3109: lcmp
    //   3110: ifge +1552 -> 4662
    //   3113: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3116: ifeq +52 -> 3168
    //   3119: ldc 56
    //   3121: iconst_2
    //   3122: new 382	java/lang/StringBuilder
    //   3125: dup
    //   3126: invokespecial 383	java/lang/StringBuilder:<init>	()V
    //   3129: ldc_w 405
    //   3132: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3135: lload 5
    //   3137: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3140: ldc_w 394
    //   3143: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3146: aload_0
    //   3147: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3150: getfield 371	com/tencent/mobileqq/activity/Conversation:e	J
    //   3153: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3156: ldc_w 399
    //   3159: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3162: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3165: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3168: aload_0
    //   3169: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3172: getfield 407	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   3175: lconst_1
    //   3176: ladd
    //   3177: lstore 5
    //   3179: aload_1
    //   3180: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3183: checkcast 409	java/util/List
    //   3186: astore 10
    //   3188: aload_1
    //   3189: getfield 412	android/os/Message:arg2	I
    //   3192: iconst_1
    //   3193: if_icmpeq +85 -> 3278
    //   3196: lload 5
    //   3198: aload_0
    //   3199: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3202: getfield 407	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   3205: lcmp
    //   3206: ifge +72 -> 3278
    //   3209: aload_0
    //   3210: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3213: aload 10
    //   3215: putfield 415	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3218: invokestatic 419	android/os/Message:obtain	()Landroid/os/Message;
    //   3221: astore_1
    //   3222: aload_1
    //   3223: sipush 10000
    //   3226: putfield 26	android/os/Message:what	I
    //   3229: aload_1
    //   3230: aload_0
    //   3231: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3234: getfield 415	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3237: putfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3240: aload_1
    //   3241: iconst_0
    //   3242: putfield 266	android/os/Message:arg1	I
    //   3245: aload_1
    //   3246: iconst_1
    //   3247: putfield 412	android/os/Message:arg2	I
    //   3250: aload_0
    //   3251: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3254: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3257: aload_1
    //   3258: aload_0
    //   3259: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3262: getfield 407	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   3265: lload 5
    //   3267: lsub
    //   3268: ldc2_w 420
    //   3271: ladd
    //   3272: invokevirtual 425	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   3275: pop
    //   3276: iconst_1
    //   3277: ireturn
    //   3278: aload_1
    //   3279: getfield 412	android/os/Message:arg2	I
    //   3282: iconst_1
    //   3283: if_icmpne +53 -> 3336
    //   3286: aload 10
    //   3288: aload_0
    //   3289: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3292: getfield 415	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3295: if_acmpne +36 -> 3331
    //   3298: iconst_1
    //   3299: istore_2
    //   3300: iload_2
    //   3301: ifeq -3250 -> 51
    //   3304: aload_0
    //   3305: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3308: iconst_0
    //   3309: aload_0
    //   3310: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3313: getfield 415	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3316: invokevirtual 428	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   3319: aload_0
    //   3320: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3323: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   3326: putfield 371	com/tencent/mobileqq/activity/Conversation:e	J
    //   3329: iconst_1
    //   3330: ireturn
    //   3331: iconst_0
    //   3332: istore_2
    //   3333: goto -33 -> 3300
    //   3336: aload_0
    //   3337: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3340: aload 10
    //   3342: putfield 415	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3345: iconst_1
    //   3346: istore_2
    //   3347: goto -47 -> 3300
    //   3350: aload_1
    //   3351: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3354: checkcast 409	java/util/List
    //   3357: astore_1
    //   3358: aload_0
    //   3359: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3362: iconst_1
    //   3363: aload_1
    //   3364: invokevirtual 428	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   3367: iconst_1
    //   3368: ireturn
    //   3369: aload_0
    //   3370: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3373: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3376: ifnull -3325 -> 51
    //   3379: aload_0
    //   3380: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3383: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3386: iconst_1
    //   3387: iconst_0
    //   3388: invokevirtual 431	com/tencent/mobileqq/app/QQAppInterface:a	(ZI)V
    //   3391: iconst_1
    //   3392: ireturn
    //   3393: aload_0
    //   3394: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3397: invokestatic 433	com/tencent/mobileqq/activity/Conversation:c	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   3400: iconst_1
    //   3401: ireturn
    //   3402: aload_0
    //   3403: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3406: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3409: astore 10
    //   3411: iload_3
    //   3412: istore_2
    //   3413: aload_0
    //   3414: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3417: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3420: invokevirtual 436	com/tencent/mobileqq/app/QQAppInterface:a	()Lbffc;
    //   3423: invokevirtual 441	bffc:a	()I
    //   3426: ifeq +5 -> 3431
    //   3429: iconst_2
    //   3430: istore_2
    //   3431: aload 10
    //   3433: bipush 37
    //   3435: iload_2
    //   3436: invokevirtual 37	agxq:a	(II)V
    //   3439: aload_0
    //   3440: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3443: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3446: bipush 37
    //   3448: aload_1
    //   3449: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   3452: iconst_1
    //   3453: ireturn
    //   3454: aload_0
    //   3455: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3458: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3461: astore 10
    //   3463: invokestatic 446	aosu:a	()Laosu;
    //   3466: invokevirtual 448	aosu:a	()Z
    //   3469: ifeq +26 -> 3495
    //   3472: aload 10
    //   3474: bipush 38
    //   3476: iload_2
    //   3477: invokevirtual 37	agxq:a	(II)V
    //   3480: aload_0
    //   3481: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3484: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3487: bipush 38
    //   3489: aload_1
    //   3490: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   3493: iconst_1
    //   3494: ireturn
    //   3495: iconst_0
    //   3496: istore_2
    //   3497: goto -25 -> 3472
    //   3500: aload_0
    //   3501: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3504: invokevirtual 451	com/tencent/mobileqq/activity/Conversation:w	()V
    //   3507: iconst_1
    //   3508: ireturn
    //   3509: aload_0
    //   3510: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3513: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3516: bipush 23
    //   3518: iconst_2
    //   3519: invokevirtual 37	agxq:a	(II)V
    //   3522: aload_0
    //   3523: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3526: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3529: bipush 23
    //   3531: aload_1
    //   3532: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   3535: iconst_1
    //   3536: ireturn
    //   3537: aload_0
    //   3538: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3541: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3544: bipush 23
    //   3546: iconst_0
    //   3547: invokevirtual 37	agxq:a	(II)V
    //   3550: aload_0
    //   3551: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3554: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3557: bipush 23
    //   3559: aload_1
    //   3560: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   3563: iconst_1
    //   3564: ireturn
    //   3565: aload_0
    //   3566: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3569: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3572: bipush 24
    //   3574: iconst_2
    //   3575: invokevirtual 37	agxq:a	(II)V
    //   3578: aload_0
    //   3579: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3582: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3585: bipush 24
    //   3587: aload_1
    //   3588: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   3591: iconst_1
    //   3592: ireturn
    //   3593: aload_0
    //   3594: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3597: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3600: bipush 24
    //   3602: iconst_0
    //   3603: invokevirtual 37	agxq:a	(II)V
    //   3606: aload_0
    //   3607: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3610: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3613: bipush 24
    //   3615: aload_1
    //   3616: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   3619: iconst_1
    //   3620: ireturn
    //   3621: aload_0
    //   3622: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3625: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3628: iconst_5
    //   3629: aload_1
    //   3630: getfield 266	android/os/Message:arg1	I
    //   3633: invokevirtual 37	agxq:a	(II)V
    //   3636: aload_0
    //   3637: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3640: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3643: iconst_5
    //   3644: aload_1
    //   3645: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   3648: iconst_1
    //   3649: ireturn
    //   3650: aload_0
    //   3651: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3654: getfield 454	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahai	Lahai;
    //   3657: ifnull -3606 -> 51
    //   3660: aload_0
    //   3661: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3664: getfield 454	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahai	Lahai;
    //   3667: invokevirtual 457	ahai:a	()V
    //   3670: iconst_1
    //   3671: ireturn
    //   3672: aload_0
    //   3673: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3676: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3679: ifnull -3628 -> 51
    //   3682: aload_1
    //   3683: getfield 266	android/os/Message:arg1	I
    //   3686: iconst_1
    //   3687: if_icmpne +38 -> 3725
    //   3690: iconst_1
    //   3691: istore_2
    //   3692: iload_2
    //   3693: ifeq +37 -> 3730
    //   3696: new 462	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   3699: dup
    //   3700: invokespecial 463	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   3703: astore_1
    //   3704: aload_1
    //   3705: getfield 467	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3708: iconst_0
    //   3709: invokevirtual 472	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3712: aload_0
    //   3713: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3716: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3719: aload_1
    //   3720: invokevirtual 477	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;)V
    //   3723: iconst_1
    //   3724: ireturn
    //   3725: iconst_0
    //   3726: istore_2
    //   3727: goto -35 -> 3692
    //   3730: aload_0
    //   3731: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3734: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3737: new 479	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   3740: dup
    //   3741: invokespecial 480	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   3744: invokevirtual 483	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   3747: iconst_1
    //   3748: ireturn
    //   3749: aload_0
    //   3750: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3753: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3756: astore 10
    //   3758: aload_1
    //   3759: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3762: ifnonnull +27 -> 3789
    //   3765: iload 4
    //   3767: istore_2
    //   3768: aload 10
    //   3770: iconst_3
    //   3771: iload_2
    //   3772: invokevirtual 37	agxq:a	(II)V
    //   3775: aload_0
    //   3776: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3779: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3782: iconst_3
    //   3783: aload_1
    //   3784: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   3787: iconst_1
    //   3788: ireturn
    //   3789: iconst_2
    //   3790: istore_2
    //   3791: goto -23 -> 3768
    //   3794: aload_0
    //   3795: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3798: invokestatic 77	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   3801: iconst_1
    //   3802: ireturn
    //   3803: aload_0
    //   3804: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3807: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3810: bipush 10
    //   3812: invokevirtual 486	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   3815: checkcast 488	ajrc
    //   3818: invokevirtual 490	ajrc:b	()V
    //   3821: iconst_1
    //   3822: ireturn
    //   3823: aload_0
    //   3824: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3827: getfield 493	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   3830: getfield 496	com/tencent/mobileqq/app/FrameHelperActivity:a	Landroid/widget/ImageView;
    //   3833: astore_1
    //   3834: aload_0
    //   3835: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3838: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3841: sipush 250
    //   3844: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3847: checkcast 498	com/tencent/mobileqq/medalwall/MedalWallMng
    //   3850: aload_0
    //   3851: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3854: invokevirtual 501	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   3857: aload_1
    //   3858: iconst_1
    //   3859: aconst_null
    //   3860: invokevirtual 504	com/tencent/mobileqq/medalwall/MedalWallMng:a	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/view/View;ILjava/lang/Object;)Z
    //   3863: istore 9
    //   3865: invokestatic 380	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3868: ifeq -3817 -> 51
    //   3871: ldc_w 506
    //   3874: iconst_4
    //   3875: invokestatic 512	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   3878: ldc_w 514
    //   3881: iconst_1
    //   3882: anewarray 4	java/lang/Object
    //   3885: dup
    //   3886: iconst_0
    //   3887: iload 9
    //   3889: invokestatic 520	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3892: aastore
    //   3893: invokestatic 524	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3896: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3899: iconst_1
    //   3900: ireturn
    //   3901: ldc 56
    //   3903: ldc_w 526
    //   3906: invokestatic 531	urk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3909: aload_0
    //   3910: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3913: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3916: ifnull +20 -> 3936
    //   3919: aload_0
    //   3920: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3923: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3926: sipush 181
    //   3929: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3932: checkcast 533	sga
    //   3935: astore_1
    //   3936: new 535	com/tencent/mobileqq/activity/Conversation$1$7
    //   3939: dup
    //   3940: aload_0
    //   3941: invokespecial 536	com/tencent/mobileqq/activity/Conversation$1$7:<init>	(Laamh;)V
    //   3944: bipush 8
    //   3946: aconst_null
    //   3947: iconst_1
    //   3948: invokestatic 248	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   3951: iconst_1
    //   3952: ireturn
    //   3953: aload_0
    //   3954: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3957: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   3960: invokevirtual 538	agxq:a	()Lmqq/os/MqqHandler;
    //   3963: astore 10
    //   3965: aload 10
    //   3967: ifnull -3916 -> 51
    //   3970: aload 10
    //   3972: sipush 200
    //   3975: invokevirtual 542	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   3978: astore 11
    //   3980: aload 11
    //   3982: aload_1
    //   3983: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3986: putfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3989: aload 10
    //   3991: aload 11
    //   3993: invokevirtual 545	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   3996: pop
    //   3997: iconst_1
    //   3998: ireturn
    //   3999: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4002: ifeq +30 -> 4032
    //   4005: ldc_w 547
    //   4008: iconst_2
    //   4009: new 382	java/lang/StringBuilder
    //   4012: dup
    //   4013: invokespecial 383	java/lang/StringBuilder:<init>	()V
    //   4016: ldc_w 549
    //   4019: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4022: aload_1
    //   4023: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4026: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4029: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4032: aload_0
    //   4033: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4036: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   4039: invokevirtual 538	agxq:a	()Lmqq/os/MqqHandler;
    //   4042: astore 10
    //   4044: aload 10
    //   4046: ifnull -3995 -> 51
    //   4049: aload 10
    //   4051: sipush 201
    //   4054: invokevirtual 542	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   4057: astore 11
    //   4059: aload 11
    //   4061: aload_1
    //   4062: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4065: putfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4068: aload 10
    //   4070: aload 11
    //   4072: invokevirtual 545	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   4075: pop
    //   4076: iconst_1
    //   4077: ireturn
    //   4078: invokestatic 557	com/tencent/mobileqq/theme/ThemeUtil:isDefaultTheme	()Z
    //   4081: ifne +38 -> 4119
    //   4084: iconst_0
    //   4085: invokestatic 561	com/tencent/mobileqq/theme/ThemeUtil:isSimpleDayTheme	(Z)Z
    //   4088: ifne +31 -> 4119
    //   4091: aload_0
    //   4092: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4095: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4098: sipush 1069
    //   4101: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   4104: aload_0
    //   4105: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4108: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4111: sipush 1068
    //   4114: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   4117: iconst_1
    //   4118: ireturn
    //   4119: aload_0
    //   4120: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4123: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4126: sipush 1068
    //   4129: invokevirtual 274	mqq/os/MqqHandler:hasMessages	(I)Z
    //   4132: ifeq +16 -> 4148
    //   4135: aload_0
    //   4136: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4139: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4142: sipush 1068
    //   4145: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   4148: aload_0
    //   4149: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4152: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   4155: iconst_0
    //   4156: invokevirtual 563	agxq:d	(Z)V
    //   4159: aload_0
    //   4160: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4163: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   4166: invokevirtual 538	agxq:a	()Lmqq/os/MqqHandler;
    //   4169: ifnull -4118 -> 51
    //   4172: aload_0
    //   4173: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4176: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   4179: iconst_m1
    //   4180: aconst_null
    //   4181: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   4184: iconst_1
    //   4185: ireturn
    //   4186: invokestatic 557	com/tencent/mobileqq/theme/ThemeUtil:isDefaultTheme	()Z
    //   4189: ifne +38 -> 4227
    //   4192: iconst_0
    //   4193: invokestatic 561	com/tencent/mobileqq/theme/ThemeUtil:isSimpleDayTheme	(Z)Z
    //   4196: ifne +31 -> 4227
    //   4199: aload_0
    //   4200: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4203: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4206: sipush 1069
    //   4209: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   4212: aload_0
    //   4213: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4216: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4219: sipush 1068
    //   4222: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   4225: iconst_1
    //   4226: ireturn
    //   4227: aload_0
    //   4228: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4231: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4234: sipush 1069
    //   4237: invokevirtual 274	mqq/os/MqqHandler:hasMessages	(I)Z
    //   4240: ifeq +16 -> 4256
    //   4243: aload_0
    //   4244: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4247: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4250: sipush 1069
    //   4253: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   4256: aload_0
    //   4257: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4260: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   4263: iconst_1
    //   4264: invokevirtual 563	agxq:d	(Z)V
    //   4267: aload_0
    //   4268: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4271: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   4274: invokevirtual 538	agxq:a	()Lmqq/os/MqqHandler;
    //   4277: ifnull -4226 -> 51
    //   4280: aload_0
    //   4281: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4284: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   4287: iconst_m1
    //   4288: aconst_null
    //   4289: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   4292: iconst_1
    //   4293: ireturn
    //   4294: aload_0
    //   4295: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4298: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4301: sipush 1070
    //   4304: invokevirtual 277	mqq/os/MqqHandler:removeMessages	(I)V
    //   4307: aload_0
    //   4308: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4311: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4314: bipush 36
    //   4316: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4319: checkcast 565	auqh
    //   4322: invokevirtual 566	auqh:b	()V
    //   4325: iconst_1
    //   4326: ireturn
    //   4327: aload_0
    //   4328: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4331: getfield 568	com/tencent/mobileqq/activity/Conversation:f	Z
    //   4334: ifeq -4283 -> 51
    //   4337: aload_0
    //   4338: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4341: getfield 269	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4344: ldc_w 569
    //   4347: getstatic 573	awqu:a	I
    //   4350: sipush 1000
    //   4353: imul
    //   4354: i2l
    //   4355: invokevirtual 577	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   4358: pop
    //   4359: iconst_1
    //   4360: ireturn
    //   4361: aload_0
    //   4362: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4365: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4368: invokestatic 580	awqu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   4371: iconst_1
    //   4372: ireturn
    //   4373: aload_1
    //   4374: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4377: instanceof 582
    //   4380: ifeq -4329 -> 51
    //   4383: aload_0
    //   4384: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4387: getfield 585	com/tencent/mobileqq/activity/Conversation:h	Z
    //   4390: ifne -4339 -> 51
    //   4393: aload_1
    //   4394: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4397: checkcast 582	[Ljava/lang/String;
    //   4400: checkcast 582	[Ljava/lang/String;
    //   4403: astore 11
    //   4405: aload 11
    //   4407: arraylength
    //   4408: iconst_3
    //   4409: if_icmpne -4358 -> 51
    //   4412: aload 11
    //   4414: iconst_0
    //   4415: aaload
    //   4416: astore_1
    //   4417: aload 11
    //   4419: iconst_1
    //   4420: aaload
    //   4421: astore 10
    //   4423: aload 11
    //   4425: iconst_2
    //   4426: aaload
    //   4427: astore 11
    //   4429: new 587	aaoa
    //   4432: dup
    //   4433: aload_0
    //   4434: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4437: aload_1
    //   4438: aload 10
    //   4440: aload 11
    //   4442: invokespecial 590	aaoa:<init>	(Lcom/tencent/mobileqq/activity/Conversation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4445: invokevirtual 591	aaoa:a	()V
    //   4448: iconst_1
    //   4449: ireturn
    //   4450: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4453: ifeq +32 -> 4485
    //   4456: ldc 56
    //   4458: iconst_2
    //   4459: new 382	java/lang/StringBuilder
    //   4462: dup
    //   4463: invokespecial 383	java/lang/StringBuilder:<init>	()V
    //   4466: ldc_w 593
    //   4469: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4472: aload_1
    //   4473: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4476: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4479: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4482: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4485: aload_0
    //   4486: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4489: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   4492: iconst_2
    //   4493: iconst_2
    //   4494: invokevirtual 37	agxq:a	(II)V
    //   4497: aload_0
    //   4498: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4501: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   4504: iconst_2
    //   4505: aload_1
    //   4506: invokevirtual 74	agxq:a	(ILandroid/os/Message;)V
    //   4509: iconst_1
    //   4510: ireturn
    //   4511: aload_0
    //   4512: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4515: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   4518: invokevirtual 594	agxq:a	()V
    //   4521: aload_0
    //   4522: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4525: iconst_1
    //   4526: putfield 596	com/tencent/mobileqq/activity/Conversation:r	Z
    //   4529: aload_0
    //   4530: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4533: getfield 598	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4536: bipush 18
    //   4538: invokevirtual 601	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   4541: pop
    //   4542: iconst_1
    //   4543: ireturn
    //   4544: aload_0
    //   4545: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4548: ldc_w 602
    //   4551: invokevirtual 604	com/tencent/mobileqq/activity/Conversation:a	(I)Landroid/view/View;
    //   4554: checkcast 606	android/widget/TextView
    //   4557: invokestatic 611	gh:a	(Landroid/widget/TextView;)V
    //   4560: iconst_1
    //   4561: ireturn
    //   4562: aload_0
    //   4563: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4566: ldc_w 602
    //   4569: invokevirtual 604	com/tencent/mobileqq/activity/Conversation:a	(I)Landroid/view/View;
    //   4572: bipush 8
    //   4574: invokevirtual 117	android/view/View:setVisibility	(I)V
    //   4577: iconst_1
    //   4578: ireturn
    //   4579: new 613	com/tencent/mobileqq/activity/Conversation$1$8
    //   4582: dup
    //   4583: aload_0
    //   4584: invokespecial 614	com/tencent/mobileqq/activity/Conversation$1$8:<init>	(Laamh;)V
    //   4587: invokestatic 615	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   4590: iconst_1
    //   4591: ireturn
    //   4592: aload_0
    //   4593: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4596: invokestatic 617	com/tencent/mobileqq/activity/Conversation:d	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   4599: iconst_1
    //   4600: ireturn
    //   4601: invokestatic 621	amda:g	()Z
    //   4604: ifeq -3816 -> 788
    //   4607: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4610: ifeq +12 -> 4622
    //   4613: ldc 56
    //   4615: iconst_2
    //   4616: ldc_w 623
    //   4619: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4622: aload_0
    //   4623: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4626: iconst_1
    //   4627: invokestatic 626	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)Z
    //   4630: pop
    //   4631: aload_0
    //   4632: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4635: invokestatic 629	android/os/SystemClock:elapsedRealtime	()J
    //   4638: invokestatic 632	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;J)J
    //   4641: pop2
    //   4642: aload_0
    //   4643: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4646: invokestatic 340	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   4649: iconst_0
    //   4650: invokevirtual 635	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   4653: aload_0
    //   4654: getfield 12	aamh:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4657: invokestatic 637	com/tencent/mobileqq/activity/Conversation:e	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   4660: iconst_1
    //   4661: ireturn
    //   4662: goto -1483 -> 3179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4665	0	this	aamh
    //   0	4665	1	paramMessage	android.os.Message
    //   1	3790	2	i	int
    //   6	3406	3	j	int
    //   3	3763	4	k	int
    //   1280	1986	5	l1	long
    //   1292	216	7	l2	long
    //   3863	25	9	bool	boolean
    //   914	517	10	localObject1	Object
    //   1611	1	10	localException	java.lang.Exception
    //   1732	2707	10	localObject2	Object
    //   1024	3417	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   1564	1574	1611	java/lang/Exception
    //   1564	1574	1625	finally
    //   2191	2222	2255	java/lang/Exception
    //   2222	2242	2255	java/lang/Exception
    //   2247	2253	2255	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aamh
 * JD-Core Version:    0.7.0.1
 */