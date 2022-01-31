import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.Conversation;

public class aavy
  implements Handler.Callback
{
  public aavy(Conversation paramConversation) {}
  
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
    //   17: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   20: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   23: bipush 12
    //   25: iconst_0
    //   26: invokevirtual 37	ahkf:a	(II)V
    //   29: aload_1
    //   30: getfield 26	android/os/Message:what	I
    //   33: ldc 38
    //   35: if_icmpeq +18 -> 53
    //   38: aload_0
    //   39: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   42: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   48: ifne +5 -> 53
    //   51: iconst_1
    //   52: ireturn
    //   53: aload_1
    //   54: getfield 26	android/os/Message:what	I
    //   57: lookupswitch	default:+739->796, 1009:+750->807, 1010:+785->842, 1014:+2917->2974, 1016:+2927->2984, 1017:+2994->3051, 1019:+3325->3382, 1020:+3004->3061, 1023:+1176->1233, 1024:+3344->3401, 1025:+741->798, 1027:+1193->1250, 1030:+3368->3425, 1032:+2805->2862, 1033:+2833->2890, 1035:+3475->3532, 1038:+3484->3541, 1039:+3512->3569, 1040:+2861->2918, 1041:+2889->2946, 1042:+3596->3653, 1044:+3625->3682, 1048:+3647->3704, 1049:+3540->3597, 1050:+3568->3625, 1052:+3724->3781, 1053:+3769->3826, 1054:+3798->3855, 1055:+3876->3933, 1059:+4519->4576, 1060:+4537->4594, 1061:+4554->4611, 1062:+861->918, 1063:+1087->1144, 1064:+1143->1200, 1067:+4567->4624, 1068:+4161->4218, 1069:+4053->4110, 1070:+4269->4326, 1071:+4576->4633, 10000:+3013->3070, 10001:+774->831, 10002:+774->831, 10003:+774->831, 1134010:+1782->1839, 1134011:+1845->1902, 1134012:+2742->2799, 1134013:+2768->2825, 1134014:+2794->2851, 1134015:+2716->2773, 1134018:+1347->1404, 1134019:+1528->1585, 1134020:+1611->1668, 1134021:+2513->2570, 1134022:+2541->2598, 1134024:+2683->2740, 1134025:+3377->3434, 1134026:+3429->3486, 1134027:+1929->1986, 1134028:+1986->2043, 1134030:+3778->3835, 1134039:+2273->2330, 1134040:+2330->2387, 1134041:+2358->2415, 1134042:+2415->2472, 1134043:+2014->2071, 1134044:+2042->2099, 1134045:+1621->1678, 1134047:+1631->1688, 1134048:+1648->1705, 1134049:+2443->2500, 1134050:+2485->2542, 1134051:+2070->2127, 1134052:+2122->2179, 1134053:+2166->2223, 1134054:+-6->51, 1134057:+1665->1722, 1134058:+1682->1739, 1134059:+1873->1930, 1134060:+1901->1958, 1134061:+4302->4359, 1134062:+4336->4393, 1134063:+4425->4482, 1134064:+4486->4543, 1134065:+1810->1867, 1134066:+2569->2626, 1134067:+2626->2683, 1134068:+4348->4405, 1134200:+3928->3985, 1134201:+3974->4031, 11340003:+1216->1273, 11340004:+1754->1811
    //   797: ireturn
    //   798: aload_0
    //   799: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   802: invokestatic 49	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   805: iconst_1
    //   806: ireturn
    //   807: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   810: ifeq +11 -> 821
    //   813: ldc 56
    //   815: iconst_2
    //   816: ldc 58
    //   818: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   821: aload_0
    //   822: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   825: lconst_0
    //   826: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   829: iconst_1
    //   830: ireturn
    //   831: aload_0
    //   832: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   835: aload_1
    //   836: iconst_1
    //   837: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   840: iconst_1
    //   841: ireturn
    //   842: aload_0
    //   843: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   846: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   849: invokevirtual 71	ahkf:c	()Z
    //   852: ifeq +38 -> 890
    //   855: aload_0
    //   856: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   859: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   862: bipush 21
    //   864: iconst_2
    //   865: invokevirtual 37	ahkf:a	(II)V
    //   868: aload_0
    //   869: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   872: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   875: bipush 21
    //   877: aload_1
    //   878: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   881: aload_0
    //   882: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   885: invokestatic 77	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   888: iconst_1
    //   889: ireturn
    //   890: aload_0
    //   891: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   894: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   897: bipush 21
    //   899: iconst_0
    //   900: invokevirtual 37	ahkf:a	(II)V
    //   903: aload_0
    //   904: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   907: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   910: bipush 21
    //   912: aconst_null
    //   913: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   916: iconst_1
    //   917: ireturn
    //   918: aload_1
    //   919: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   922: astore 10
    //   924: aload 10
    //   926: ifnonnull +72 -> 998
    //   929: aload_0
    //   930: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   933: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   936: invokevirtual 83	ahkf:b	()Z
    //   939: ifeq +31 -> 970
    //   942: aload_0
    //   943: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   946: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   949: bipush 20
    //   951: iconst_2
    //   952: invokevirtual 37	ahkf:a	(II)V
    //   955: aload_0
    //   956: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   959: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   962: bipush 20
    //   964: aload_1
    //   965: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   968: iconst_1
    //   969: ireturn
    //   970: aload_0
    //   971: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   974: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   977: bipush 20
    //   979: iconst_0
    //   980: invokevirtual 37	ahkf:a	(II)V
    //   983: aload_0
    //   984: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   987: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   990: bipush 20
    //   992: aconst_null
    //   993: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   996: iconst_1
    //   997: ireturn
    //   998: aload 10
    //   1000: instanceof 85
    //   1003: ifeq -952 -> 51
    //   1006: aload 10
    //   1008: checkcast 85	[Landroid/view/View;
    //   1011: checkcast 85	[Landroid/view/View;
    //   1014: astore 10
    //   1016: aload 10
    //   1018: arraylength
    //   1019: iconst_3
    //   1020: if_icmpne -969 -> 51
    //   1023: aload 10
    //   1025: iconst_0
    //   1026: aaload
    //   1027: astore_1
    //   1028: aload 10
    //   1030: iconst_1
    //   1031: aaload
    //   1032: astore 11
    //   1034: aload 10
    //   1036: iconst_2
    //   1037: aaload
    //   1038: astore 10
    //   1040: aload_1
    //   1041: ifnull -990 -> 51
    //   1044: aload_1
    //   1045: invokevirtual 91	android/view/View:getParent	()Landroid/view/ViewParent;
    //   1048: ifnonnull -997 -> 51
    //   1051: aload_0
    //   1052: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1055: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1058: ldc 95
    //   1060: invokevirtual 101	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   1063: astore 11
    //   1065: aload 11
    //   1067: ifnull +15 -> 1082
    //   1070: aload_0
    //   1071: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1074: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1077: aload 11
    //   1079: invokevirtual 105	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   1082: aload_0
    //   1083: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1086: invokestatic 108	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   1089: ifnull +24 -> 1113
    //   1092: aload_0
    //   1093: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1096: invokestatic 108	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   1099: invokeinterface 113 1 0
    //   1104: ifeq +9 -> 1113
    //   1107: aload_1
    //   1108: bipush 8
    //   1110: invokevirtual 117	android/view/View:setVisibility	(I)V
    //   1113: aload_0
    //   1114: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1117: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1120: aload_1
    //   1121: invokevirtual 120	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1124: aload 10
    //   1126: ifnull -1075 -> 51
    //   1129: aload 10
    //   1131: new 122	aavz
    //   1134: dup
    //   1135: aload_0
    //   1136: invokespecial 125	aavz:<init>	(Laavy;)V
    //   1139: invokevirtual 129	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1142: iconst_1
    //   1143: ireturn
    //   1144: aload_0
    //   1145: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1148: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1151: ifnull +13 -> 1164
    //   1154: aload_0
    //   1155: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1158: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1161: invokevirtual 132	ahkf:f	()V
    //   1164: aload_0
    //   1165: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1168: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1171: ldc 95
    //   1173: invokevirtual 101	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   1176: astore_1
    //   1177: aload_1
    //   1178: ifnull -1127 -> 51
    //   1181: aload_1
    //   1182: bipush 8
    //   1184: invokevirtual 117	android/view/View:setVisibility	(I)V
    //   1187: aload_0
    //   1188: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1191: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1194: aload_1
    //   1195: invokevirtual 105	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   1198: iconst_1
    //   1199: ireturn
    //   1200: aload_1
    //   1201: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1204: astore_1
    //   1205: aload_1
    //   1206: ifnull -1155 -> 51
    //   1209: aload_1
    //   1210: instanceof 134
    //   1213: ifeq -1162 -> 51
    //   1216: new 136	com/tencent/mobileqq/activity/Conversation$1$2
    //   1219: dup
    //   1220: aload_0
    //   1221: aload_1
    //   1222: checkcast 134	java/lang/String
    //   1225: invokespecial 139	com/tencent/mobileqq/activity/Conversation$1$2:<init>	(Laavy;Ljava/lang/String;)V
    //   1228: invokestatic 145	com/tencent/mobileqq/app/ThreadManagerV2:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   1231: iconst_1
    //   1232: ireturn
    //   1233: invokestatic 151	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1236: new 153	com/tencent/mobileqq/activity/Conversation$1$3
    //   1239: dup
    //   1240: aload_0
    //   1241: invokespecial 154	com/tencent/mobileqq/activity/Conversation$1$3:<init>	(Laavy;)V
    //   1244: invokevirtual 160	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1247: pop
    //   1248: iconst_1
    //   1249: ireturn
    //   1250: aload_0
    //   1251: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1254: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1257: invokestatic 165	amgg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lamgg;
    //   1260: aload_0
    //   1261: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1264: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1267: aload_1
    //   1268: invokevirtual 168	amgg:a	(Lahkf;Landroid/os/Message;)V
    //   1271: iconst_1
    //   1272: ireturn
    //   1273: invokestatic 173	akva:a	()Lakva;
    //   1276: invokevirtual 176	akva:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   1279: astore 10
    //   1281: aload 10
    //   1283: getfield 181	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1286: ifnull -1235 -> 51
    //   1289: aload_0
    //   1290: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1293: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1296: invokevirtual 185	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   1299: astore 11
    //   1301: aload 11
    //   1303: ldc 187
    //   1305: lconst_0
    //   1306: invokeinterface 193 4 0
    //   1311: lstore 5
    //   1313: new 195	java/util/Date
    //   1316: dup
    //   1317: invokespecial 196	java/util/Date:<init>	()V
    //   1320: invokevirtual 200	java/util/Date:getTime	()J
    //   1323: lstore 7
    //   1325: lload 7
    //   1327: lload 5
    //   1329: lsub
    //   1330: aload 10
    //   1332: getfield 181	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1335: getfield 206	com/tencent/mobileqq/app/NewUpgradeConfig:dialog	Lakbv;
    //   1338: getfield 210	akbv:b	I
    //   1341: bipush 24
    //   1343: imul
    //   1344: bipush 60
    //   1346: imul
    //   1347: bipush 60
    //   1349: imul
    //   1350: sipush 1000
    //   1353: imul
    //   1354: i2l
    //   1355: lcmp
    //   1356: ifle -1305 -> 51
    //   1359: aload_0
    //   1360: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1363: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1366: bipush 12
    //   1368: iconst_2
    //   1369: invokevirtual 37	ahkf:a	(II)V
    //   1372: aload_0
    //   1373: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1376: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1379: bipush 12
    //   1381: aload_1
    //   1382: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   1385: aload 11
    //   1387: invokeinterface 214 1 0
    //   1392: ldc 187
    //   1394: lload 7
    //   1396: invokeinterface 220 4 0
    //   1401: pop
    //   1402: iconst_1
    //   1403: ireturn
    //   1404: invokestatic 173	akva:a	()Lakva;
    //   1407: invokevirtual 176	akva:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   1410: astore 10
    //   1412: aload 10
    //   1414: getfield 181	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1417: ifnull -1366 -> 51
    //   1420: aload_0
    //   1421: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1424: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1427: invokevirtual 185	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   1430: astore 11
    //   1432: aload 11
    //   1434: ldc 187
    //   1436: lconst_0
    //   1437: invokeinterface 193 4 0
    //   1442: lstore 5
    //   1444: new 195	java/util/Date
    //   1447: dup
    //   1448: invokespecial 196	java/util/Date:<init>	()V
    //   1451: invokevirtual 200	java/util/Date:getTime	()J
    //   1454: lstore 7
    //   1456: lload 7
    //   1458: lload 5
    //   1460: lsub
    //   1461: aload 10
    //   1463: getfield 181	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1466: getfield 206	com/tencent/mobileqq/app/NewUpgradeConfig:dialog	Lakbv;
    //   1469: getfield 210	akbv:b	I
    //   1472: bipush 24
    //   1474: imul
    //   1475: bipush 60
    //   1477: imul
    //   1478: bipush 60
    //   1480: imul
    //   1481: sipush 1000
    //   1484: imul
    //   1485: i2l
    //   1486: lcmp
    //   1487: ifle +64 -> 1551
    //   1490: aload_0
    //   1491: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1494: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1497: bipush 14
    //   1499: iconst_2
    //   1500: invokevirtual 37	ahkf:a	(II)V
    //   1503: aload_0
    //   1504: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1507: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1510: bipush 12
    //   1512: iconst_0
    //   1513: invokevirtual 37	ahkf:a	(II)V
    //   1516: aload_0
    //   1517: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1520: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1523: bipush 14
    //   1525: aload_1
    //   1526: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   1529: aload 11
    //   1531: invokeinterface 214 1 0
    //   1536: ldc 187
    //   1538: lload 7
    //   1540: invokeinterface 220 4 0
    //   1545: invokeinterface 223 1 0
    //   1550: pop
    //   1551: aload_1
    //   1552: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1555: ifnull -1504 -> 51
    //   1558: aload_1
    //   1559: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1562: instanceof 225
    //   1565: ifeq -1514 -> 51
    //   1568: aload_1
    //   1569: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1572: checkcast 225	com/tencent/mobileqq/activity/UpgradeActivity
    //   1575: astore_1
    //   1576: invokestatic 173	akva:a	()Lakva;
    //   1579: aload_1
    //   1580: invokevirtual 228	akva:a	(Landroid/content/Context;)V
    //   1583: iconst_1
    //   1584: ireturn
    //   1585: aload_0
    //   1586: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1589: invokestatic 231	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1592: ifnull +22 -> 1614
    //   1595: aload_0
    //   1596: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1599: invokestatic 231	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1602: invokevirtual 236	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   1605: aload_0
    //   1606: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1609: aconst_null
    //   1610: invokestatic 239	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1613: pop
    //   1614: aload_0
    //   1615: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1618: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1621: bipush 14
    //   1623: iconst_0
    //   1624: invokevirtual 37	ahkf:a	(II)V
    //   1627: aload_0
    //   1628: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1631: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1634: bipush 14
    //   1636: aload_1
    //   1637: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   1640: iconst_1
    //   1641: ireturn
    //   1642: astore 10
    //   1644: aload_0
    //   1645: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1648: aconst_null
    //   1649: invokestatic 239	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1652: pop
    //   1653: goto -39 -> 1614
    //   1656: astore_1
    //   1657: aload_0
    //   1658: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1661: aconst_null
    //   1662: invokestatic 239	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1665: pop
    //   1666: aload_1
    //   1667: athrow
    //   1668: aload_0
    //   1669: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1672: aload_1
    //   1673: invokestatic 242	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1676: iconst_1
    //   1677: ireturn
    //   1678: aload_0
    //   1679: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1682: aload_1
    //   1683: invokestatic 244	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1686: iconst_1
    //   1687: ireturn
    //   1688: invokestatic 151	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1691: new 246	com/tencent/mobileqq/activity/Conversation$1$4
    //   1694: dup
    //   1695: aload_0
    //   1696: invokespecial 247	com/tencent/mobileqq/activity/Conversation$1$4:<init>	(Laavy;)V
    //   1699: invokevirtual 160	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1702: pop
    //   1703: iconst_1
    //   1704: ireturn
    //   1705: invokestatic 151	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1708: new 249	com/tencent/mobileqq/activity/Conversation$1$5
    //   1711: dup
    //   1712: aload_0
    //   1713: invokespecial 250	com/tencent/mobileqq/activity/Conversation$1$5:<init>	(Laavy;)V
    //   1716: invokevirtual 160	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1719: pop
    //   1720: iconst_1
    //   1721: ireturn
    //   1722: new 252	com/tencent/mobileqq/activity/Conversation$1$6
    //   1725: dup
    //   1726: aload_0
    //   1727: invokespecial 253	com/tencent/mobileqq/activity/Conversation$1$6:<init>	(Laavy;)V
    //   1730: bipush 8
    //   1732: aconst_null
    //   1733: iconst_1
    //   1734: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1737: iconst_1
    //   1738: ireturn
    //   1739: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1742: ifeq +12 -> 1754
    //   1745: ldc 56
    //   1747: iconst_2
    //   1748: ldc_w 258
    //   1751: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1754: aload_0
    //   1755: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1758: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1761: invokestatic 266	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;
    //   1764: astore 10
    //   1766: aload 10
    //   1768: invokevirtual 268	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	()V
    //   1771: aload_0
    //   1772: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1775: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1778: aload 10
    //   1780: invokestatic 271	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   1783: aload_0
    //   1784: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1787: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1790: bipush 26
    //   1792: iconst_0
    //   1793: invokevirtual 37	ahkf:a	(II)V
    //   1796: aload_0
    //   1797: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1800: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1803: bipush 26
    //   1805: aload_1
    //   1806: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   1809: iconst_1
    //   1810: ireturn
    //   1811: aload_0
    //   1812: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1815: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1818: bipush 12
    //   1820: iconst_0
    //   1821: invokevirtual 37	ahkf:a	(II)V
    //   1824: aload_0
    //   1825: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1828: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1831: bipush 12
    //   1833: aload_1
    //   1834: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   1837: iconst_1
    //   1838: ireturn
    //   1839: aload_0
    //   1840: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1843: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1846: bipush 36
    //   1848: iconst_2
    //   1849: invokevirtual 37	ahkf:a	(II)V
    //   1852: aload_0
    //   1853: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1856: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1859: bipush 36
    //   1861: aload_1
    //   1862: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   1865: iconst_1
    //   1866: ireturn
    //   1867: aload_1
    //   1868: ifnull -1817 -> 51
    //   1871: aload_0
    //   1872: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1875: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1878: bipush 10
    //   1880: aload_1
    //   1881: getfield 274	android/os/Message:arg1	I
    //   1884: invokevirtual 37	ahkf:a	(II)V
    //   1887: aload_0
    //   1888: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1891: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1894: bipush 10
    //   1896: aload_1
    //   1897: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   1900: iconst_1
    //   1901: ireturn
    //   1902: aload_0
    //   1903: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1906: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1909: bipush 36
    //   1911: iconst_0
    //   1912: invokevirtual 37	ahkf:a	(II)V
    //   1915: aload_0
    //   1916: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1919: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1922: bipush 36
    //   1924: aload_1
    //   1925: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   1928: iconst_1
    //   1929: ireturn
    //   1930: aload_0
    //   1931: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1934: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1937: bipush 34
    //   1939: iconst_2
    //   1940: invokevirtual 37	ahkf:a	(II)V
    //   1943: aload_0
    //   1944: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1947: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1950: bipush 34
    //   1952: aload_1
    //   1953: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   1956: iconst_1
    //   1957: ireturn
    //   1958: aload_0
    //   1959: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1962: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1965: bipush 34
    //   1967: iconst_0
    //   1968: invokevirtual 37	ahkf:a	(II)V
    //   1971: aload_0
    //   1972: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1975: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   1978: bipush 34
    //   1980: aload_1
    //   1981: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   1984: iconst_1
    //   1985: ireturn
    //   1986: aload_0
    //   1987: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1990: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1993: ldc_w 278
    //   1996: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   1999: ifeq +16 -> 2015
    //   2002: aload_0
    //   2003: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2006: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2009: ldc_w 278
    //   2012: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2015: aload_0
    //   2016: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2019: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2022: bipush 28
    //   2024: iconst_2
    //   2025: invokevirtual 37	ahkf:a	(II)V
    //   2028: aload_0
    //   2029: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2032: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2035: bipush 28
    //   2037: aload_1
    //   2038: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2041: iconst_1
    //   2042: ireturn
    //   2043: aload_0
    //   2044: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2047: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2050: bipush 28
    //   2052: iconst_0
    //   2053: invokevirtual 37	ahkf:a	(II)V
    //   2056: aload_0
    //   2057: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2060: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2063: bipush 28
    //   2065: aload_1
    //   2066: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2069: iconst_1
    //   2070: ireturn
    //   2071: aload_0
    //   2072: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2075: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2078: bipush 32
    //   2080: iconst_2
    //   2081: invokevirtual 37	ahkf:a	(II)V
    //   2084: aload_0
    //   2085: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2088: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2091: bipush 32
    //   2093: aload_1
    //   2094: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2097: iconst_1
    //   2098: ireturn
    //   2099: aload_0
    //   2100: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2103: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2106: bipush 32
    //   2108: iconst_0
    //   2109: invokevirtual 37	ahkf:a	(II)V
    //   2112: aload_0
    //   2113: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2116: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2119: bipush 32
    //   2121: aload_1
    //   2122: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2125: iconst_1
    //   2126: ireturn
    //   2127: aload_1
    //   2128: getfield 274	android/os/Message:arg1	I
    //   2131: iconst_1
    //   2132: if_icmpeq +16 -> 2148
    //   2135: aload_0
    //   2136: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2139: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2142: bipush 33
    //   2144: iconst_2
    //   2145: invokevirtual 37	ahkf:a	(II)V
    //   2148: aload_0
    //   2149: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2152: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2155: bipush 33
    //   2157: aload_1
    //   2158: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2161: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2164: ifeq -2113 -> 51
    //   2167: ldc_w 287
    //   2170: iconst_2
    //   2171: ldc_w 289
    //   2174: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2177: iconst_1
    //   2178: ireturn
    //   2179: aload_0
    //   2180: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2183: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2186: bipush 33
    //   2188: iconst_0
    //   2189: invokevirtual 37	ahkf:a	(II)V
    //   2192: aload_0
    //   2193: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2196: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2199: bipush 33
    //   2201: aload_1
    //   2202: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2205: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2208: ifeq -2157 -> 51
    //   2211: ldc_w 287
    //   2214: iconst_2
    //   2215: ldc_w 291
    //   2218: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2221: iconst_1
    //   2222: ireturn
    //   2223: aload_0
    //   2224: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2227: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2230: sipush 153
    //   2233: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2236: checkcast 297	airz
    //   2239: astore 10
    //   2241: aconst_null
    //   2242: invokestatic 302	ajae:a	(Ljava/lang/Object;)Z
    //   2245: ifeq +9 -> 2254
    //   2248: aload 10
    //   2250: iconst_1
    //   2251: putfield 306	airz:k	Z
    //   2254: aload_0
    //   2255: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2258: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2261: getfield 309	com/tencent/mobileqq/app/QQAppInterface:o	Z
    //   2264: ifeq +10 -> 2274
    //   2267: aconst_null
    //   2268: invokestatic 302	ajae:a	(Ljava/lang/Object;)Z
    //   2271: ifeq +19 -> 2290
    //   2274: aload 10
    //   2276: ifnull -2225 -> 51
    //   2279: aload 10
    //   2281: iconst_1
    //   2282: putfield 312	airz:j	Z
    //   2285: iconst_1
    //   2286: ireturn
    //   2287: astore_1
    //   2288: iconst_1
    //   2289: ireturn
    //   2290: invokestatic 315	com/tencent/mobileqq/app/FrameHelperActivity:b	()Z
    //   2293: ifeq +10 -> 2303
    //   2296: iconst_1
    //   2297: invokestatic 318	com/tencent/mobileqq/app/FrameHelperActivity:c	(Z)V
    //   2300: invokestatic 321	com/tencent/mobileqq/app/FrameHelperActivity:s	()V
    //   2303: aload_0
    //   2304: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2307: getfield 323	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   2310: aload_1
    //   2311: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   2314: checkcast 134	java/lang/String
    //   2317: invokestatic 326	ajae:a	(Landroid/view/View;Ljava/lang/String;)V
    //   2320: aload_0
    //   2321: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2324: iconst_1
    //   2325: putfield 328	com/tencent/mobileqq/activity/Conversation:d	Z
    //   2328: iconst_1
    //   2329: ireturn
    //   2330: aload_0
    //   2331: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2334: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2337: ldc_w 329
    //   2340: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2343: ifeq +16 -> 2359
    //   2346: aload_0
    //   2347: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2350: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2353: ldc_w 329
    //   2356: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2359: aload_0
    //   2360: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2363: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2366: bipush 29
    //   2368: iconst_2
    //   2369: invokevirtual 37	ahkf:a	(II)V
    //   2372: aload_0
    //   2373: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2376: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2379: bipush 29
    //   2381: aload_1
    //   2382: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2385: iconst_1
    //   2386: ireturn
    //   2387: aload_0
    //   2388: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2391: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2394: bipush 29
    //   2396: iconst_0
    //   2397: invokevirtual 37	ahkf:a	(II)V
    //   2400: aload_0
    //   2401: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2404: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2407: bipush 29
    //   2409: aload_1
    //   2410: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2413: iconst_1
    //   2414: ireturn
    //   2415: aload_0
    //   2416: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2419: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2422: ldc_w 330
    //   2425: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2428: ifeq +16 -> 2444
    //   2431: aload_0
    //   2432: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2435: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2438: ldc_w 330
    //   2441: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2444: aload_0
    //   2445: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2448: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2451: bipush 30
    //   2453: iconst_2
    //   2454: invokevirtual 37	ahkf:a	(II)V
    //   2457: aload_0
    //   2458: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2461: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2464: bipush 30
    //   2466: aload_1
    //   2467: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2470: iconst_1
    //   2471: ireturn
    //   2472: aload_0
    //   2473: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2476: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2479: bipush 30
    //   2481: iconst_0
    //   2482: invokevirtual 37	ahkf:a	(II)V
    //   2485: aload_0
    //   2486: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2489: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2492: bipush 30
    //   2494: aload_1
    //   2495: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2498: iconst_1
    //   2499: ireturn
    //   2500: aload_0
    //   2501: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2504: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2507: ldc_w 331
    //   2510: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2513: ifeq +16 -> 2529
    //   2516: aload_0
    //   2517: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2520: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2523: ldc_w 331
    //   2526: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2529: aload_0
    //   2530: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2533: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2536: aload_1
    //   2537: invokevirtual 334	ahkf:a	(Landroid/os/Message;)V
    //   2540: iconst_1
    //   2541: ireturn
    //   2542: aload_0
    //   2543: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2546: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2549: bipush 31
    //   2551: iconst_0
    //   2552: invokevirtual 37	ahkf:a	(II)V
    //   2555: aload_0
    //   2556: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2559: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2562: bipush 31
    //   2564: aload_1
    //   2565: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2568: iconst_1
    //   2569: ireturn
    //   2570: aload_0
    //   2571: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2574: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2577: bipush 7
    //   2579: iconst_2
    //   2580: invokevirtual 37	ahkf:a	(II)V
    //   2583: aload_0
    //   2584: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2587: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2590: bipush 7
    //   2592: aload_1
    //   2593: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2596: iconst_1
    //   2597: ireturn
    //   2598: aload_0
    //   2599: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2602: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2605: bipush 7
    //   2607: iconst_0
    //   2608: invokevirtual 37	ahkf:a	(II)V
    //   2611: aload_0
    //   2612: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2615: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2618: bipush 7
    //   2620: aload_1
    //   2621: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2624: iconst_1
    //   2625: ireturn
    //   2626: aload_0
    //   2627: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2630: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2633: ldc_w 335
    //   2636: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2639: ifeq +16 -> 2655
    //   2642: aload_0
    //   2643: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2646: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2649: ldc_w 335
    //   2652: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2655: aload_0
    //   2656: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2659: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2662: bipush 41
    //   2664: iconst_2
    //   2665: invokevirtual 37	ahkf:a	(II)V
    //   2668: aload_0
    //   2669: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2672: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2675: bipush 41
    //   2677: aload_1
    //   2678: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2681: iconst_1
    //   2682: ireturn
    //   2683: aload_0
    //   2684: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2687: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2690: ldc_w 336
    //   2693: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2696: ifeq +16 -> 2712
    //   2699: aload_0
    //   2700: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2703: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2706: ldc_w 336
    //   2709: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2712: aload_0
    //   2713: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2716: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2719: bipush 41
    //   2721: iconst_0
    //   2722: invokevirtual 37	ahkf:a	(II)V
    //   2725: aload_0
    //   2726: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2729: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2732: bipush 41
    //   2734: aload_1
    //   2735: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2738: iconst_1
    //   2739: ireturn
    //   2740: aload_1
    //   2741: getfield 274	android/os/Message:arg1	I
    //   2744: istore_2
    //   2745: aload_0
    //   2746: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2749: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2752: bipush 8
    //   2754: iload_2
    //   2755: invokevirtual 37	ahkf:a	(II)V
    //   2758: aload_0
    //   2759: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2762: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2765: bipush 8
    //   2767: aload_1
    //   2768: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2771: iconst_1
    //   2772: ireturn
    //   2773: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2776: ifeq +12 -> 2788
    //   2779: ldc 56
    //   2781: iconst_2
    //   2782: ldc_w 338
    //   2785: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2788: aload_0
    //   2789: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2792: aload_1
    //   2793: iconst_0
    //   2794: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2797: iconst_1
    //   2798: ireturn
    //   2799: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2802: ifeq +12 -> 2814
    //   2805: ldc 56
    //   2807: iconst_2
    //   2808: ldc_w 340
    //   2811: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2814: aload_0
    //   2815: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2818: aload_1
    //   2819: iconst_1
    //   2820: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2823: iconst_1
    //   2824: ireturn
    //   2825: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2828: ifeq +12 -> 2840
    //   2831: ldc 56
    //   2833: iconst_2
    //   2834: ldc_w 342
    //   2837: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2840: aload_0
    //   2841: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2844: aload_1
    //   2845: iconst_1
    //   2846: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2849: iconst_1
    //   2850: ireturn
    //   2851: aload_0
    //   2852: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2855: aconst_null
    //   2856: iconst_1
    //   2857: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2860: iconst_1
    //   2861: ireturn
    //   2862: aload_0
    //   2863: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2866: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2869: bipush 22
    //   2871: iconst_2
    //   2872: invokevirtual 37	ahkf:a	(II)V
    //   2875: aload_0
    //   2876: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2879: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2882: bipush 22
    //   2884: aload_1
    //   2885: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2888: iconst_1
    //   2889: ireturn
    //   2890: aload_0
    //   2891: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2894: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2897: bipush 22
    //   2899: iconst_0
    //   2900: invokevirtual 37	ahkf:a	(II)V
    //   2903: aload_0
    //   2904: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2907: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2910: bipush 22
    //   2912: aload_1
    //   2913: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2916: iconst_1
    //   2917: ireturn
    //   2918: aload_0
    //   2919: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2922: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2925: bipush 6
    //   2927: iconst_2
    //   2928: invokevirtual 37	ahkf:a	(II)V
    //   2931: aload_0
    //   2932: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2935: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2938: bipush 6
    //   2940: aload_1
    //   2941: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2944: iconst_1
    //   2945: ireturn
    //   2946: aload_0
    //   2947: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2950: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2953: bipush 6
    //   2955: iconst_0
    //   2956: invokevirtual 37	ahkf:a	(II)V
    //   2959: aload_0
    //   2960: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2963: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   2966: bipush 6
    //   2968: aload_1
    //   2969: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   2972: iconst_1
    //   2973: ireturn
    //   2974: aload_0
    //   2975: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2978: lconst_0
    //   2979: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   2982: iconst_1
    //   2983: ireturn
    //   2984: aload_0
    //   2985: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2988: iconst_0
    //   2989: putfield 345	com/tencent/mobileqq/activity/Conversation:g	Z
    //   2992: aload_0
    //   2993: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2996: invokestatic 348	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   2999: ifnull +13 -> 3012
    //   3002: aload_0
    //   3003: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3006: invokestatic 348	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3009: invokevirtual 353	com/tencent/mobileqq/fpsreport/FPSSwipListView:springBackOverScrollHeaderView	()V
    //   3012: aload_0
    //   3013: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3016: getfield 356	com/tencent/mobileqq/activity/Conversation:c	J
    //   3019: lconst_0
    //   3020: lcmp
    //   3021: ifle +20 -> 3041
    //   3024: ldc_w 358
    //   3027: invokestatic 363	android/os/SystemClock:uptimeMillis	()J
    //   3030: aload_0
    //   3031: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3034: getfield 356	com/tencent/mobileqq/activity/Conversation:c	J
    //   3037: lsub
    //   3038: invokestatic 368	bbjv:a	(Ljava/lang/String;J)V
    //   3041: aload_0
    //   3042: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3045: lconst_0
    //   3046: putfield 356	com/tencent/mobileqq/activity/Conversation:c	J
    //   3049: iconst_1
    //   3050: ireturn
    //   3051: aload_0
    //   3052: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3055: lconst_0
    //   3056: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   3059: iconst_1
    //   3060: ireturn
    //   3061: aload_0
    //   3062: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3065: invokevirtual 371	com/tencent/mobileqq/activity/Conversation:r	()V
    //   3068: iconst_1
    //   3069: ireturn
    //   3070: invokestatic 376	java/lang/System:currentTimeMillis	()J
    //   3073: aload_0
    //   3074: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3077: getfield 379	com/tencent/mobileqq/activity/Conversation:e	J
    //   3080: lsub
    //   3081: invokestatic 385	java/lang/Math:abs	(J)J
    //   3084: lstore 5
    //   3086: invokestatic 388	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3089: ifeq +49 -> 3138
    //   3092: ldc 56
    //   3094: iconst_4
    //   3095: new 390	java/lang/StringBuilder
    //   3098: dup
    //   3099: invokespecial 391	java/lang/StringBuilder:<init>	()V
    //   3102: ldc_w 393
    //   3105: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3108: aload_1
    //   3109: getfield 274	android/os/Message:arg1	I
    //   3112: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3115: ldc_w 402
    //   3118: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3121: lload 5
    //   3123: invokevirtual 405	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3126: ldc_w 407
    //   3129: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3132: invokevirtual 411	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3135: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3138: lload 5
    //   3140: lconst_0
    //   3141: lcmp
    //   3142: ifge +1552 -> 4694
    //   3145: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3148: ifeq +52 -> 3200
    //   3151: ldc 56
    //   3153: iconst_2
    //   3154: new 390	java/lang/StringBuilder
    //   3157: dup
    //   3158: invokespecial 391	java/lang/StringBuilder:<init>	()V
    //   3161: ldc_w 413
    //   3164: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3167: lload 5
    //   3169: invokevirtual 405	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3172: ldc_w 402
    //   3175: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3178: aload_0
    //   3179: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3182: getfield 379	com/tencent/mobileqq/activity/Conversation:e	J
    //   3185: invokevirtual 405	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3188: ldc_w 407
    //   3191: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3194: invokevirtual 411	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3197: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3200: aload_0
    //   3201: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3204: getfield 415	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   3207: lconst_1
    //   3208: ladd
    //   3209: lstore 5
    //   3211: aload_1
    //   3212: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3215: checkcast 417	java/util/List
    //   3218: astore 10
    //   3220: aload_1
    //   3221: getfield 420	android/os/Message:arg2	I
    //   3224: iconst_1
    //   3225: if_icmpeq +85 -> 3310
    //   3228: lload 5
    //   3230: aload_0
    //   3231: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3234: getfield 415	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   3237: lcmp
    //   3238: ifge +72 -> 3310
    //   3241: aload_0
    //   3242: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3245: aload 10
    //   3247: putfield 423	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3250: invokestatic 427	android/os/Message:obtain	()Landroid/os/Message;
    //   3253: astore_1
    //   3254: aload_1
    //   3255: sipush 10000
    //   3258: putfield 26	android/os/Message:what	I
    //   3261: aload_1
    //   3262: aload_0
    //   3263: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3266: getfield 423	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3269: putfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3272: aload_1
    //   3273: iconst_0
    //   3274: putfield 274	android/os/Message:arg1	I
    //   3277: aload_1
    //   3278: iconst_1
    //   3279: putfield 420	android/os/Message:arg2	I
    //   3282: aload_0
    //   3283: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3286: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3289: aload_1
    //   3290: aload_0
    //   3291: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3294: getfield 415	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   3297: lload 5
    //   3299: lsub
    //   3300: ldc2_w 428
    //   3303: ladd
    //   3304: invokevirtual 433	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   3307: pop
    //   3308: iconst_1
    //   3309: ireturn
    //   3310: aload_1
    //   3311: getfield 420	android/os/Message:arg2	I
    //   3314: iconst_1
    //   3315: if_icmpne +53 -> 3368
    //   3318: aload 10
    //   3320: aload_0
    //   3321: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3324: getfield 423	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3327: if_acmpne +36 -> 3363
    //   3330: iconst_1
    //   3331: istore_2
    //   3332: iload_2
    //   3333: ifeq -3282 -> 51
    //   3336: aload_0
    //   3337: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3340: iconst_0
    //   3341: aload_0
    //   3342: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3345: getfield 423	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3348: invokevirtual 436	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   3351: aload_0
    //   3352: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3355: invokestatic 376	java/lang/System:currentTimeMillis	()J
    //   3358: putfield 379	com/tencent/mobileqq/activity/Conversation:e	J
    //   3361: iconst_1
    //   3362: ireturn
    //   3363: iconst_0
    //   3364: istore_2
    //   3365: goto -33 -> 3332
    //   3368: aload_0
    //   3369: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3372: aload 10
    //   3374: putfield 423	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3377: iconst_1
    //   3378: istore_2
    //   3379: goto -47 -> 3332
    //   3382: aload_1
    //   3383: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3386: checkcast 417	java/util/List
    //   3389: astore_1
    //   3390: aload_0
    //   3391: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3394: iconst_1
    //   3395: aload_1
    //   3396: invokevirtual 436	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   3399: iconst_1
    //   3400: ireturn
    //   3401: aload_0
    //   3402: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3405: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3408: ifnull -3357 -> 51
    //   3411: aload_0
    //   3412: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3415: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3418: iconst_1
    //   3419: iconst_0
    //   3420: invokevirtual 439	com/tencent/mobileqq/app/QQAppInterface:a	(ZI)V
    //   3423: iconst_1
    //   3424: ireturn
    //   3425: aload_0
    //   3426: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3429: invokestatic 441	com/tencent/mobileqq/activity/Conversation:c	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   3432: iconst_1
    //   3433: ireturn
    //   3434: aload_0
    //   3435: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3438: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3441: astore 10
    //   3443: iload_3
    //   3444: istore_2
    //   3445: aload_0
    //   3446: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3449: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3452: invokevirtual 444	com/tencent/mobileqq/app/QQAppInterface:a	()Lbgmt;
    //   3455: invokevirtual 449	bgmt:a	()I
    //   3458: ifeq +5 -> 3463
    //   3461: iconst_2
    //   3462: istore_2
    //   3463: aload 10
    //   3465: bipush 38
    //   3467: iload_2
    //   3468: invokevirtual 37	ahkf:a	(II)V
    //   3471: aload_0
    //   3472: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3475: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3478: bipush 38
    //   3480: aload_1
    //   3481: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   3484: iconst_1
    //   3485: ireturn
    //   3486: aload_0
    //   3487: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3490: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3493: astore 10
    //   3495: invokestatic 454	apke:a	()Lapke;
    //   3498: invokevirtual 456	apke:a	()Z
    //   3501: ifeq +26 -> 3527
    //   3504: aload 10
    //   3506: bipush 39
    //   3508: iload_2
    //   3509: invokevirtual 37	ahkf:a	(II)V
    //   3512: aload_0
    //   3513: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3516: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3519: bipush 39
    //   3521: aload_1
    //   3522: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   3525: iconst_1
    //   3526: ireturn
    //   3527: iconst_0
    //   3528: istore_2
    //   3529: goto -25 -> 3504
    //   3532: aload_0
    //   3533: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3536: invokevirtual 459	com/tencent/mobileqq/activity/Conversation:w	()V
    //   3539: iconst_1
    //   3540: ireturn
    //   3541: aload_0
    //   3542: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3545: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3548: bipush 24
    //   3550: iconst_2
    //   3551: invokevirtual 37	ahkf:a	(II)V
    //   3554: aload_0
    //   3555: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3558: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3561: bipush 24
    //   3563: aload_1
    //   3564: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   3567: iconst_1
    //   3568: ireturn
    //   3569: aload_0
    //   3570: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3573: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3576: bipush 24
    //   3578: iconst_0
    //   3579: invokevirtual 37	ahkf:a	(II)V
    //   3582: aload_0
    //   3583: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3586: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3589: bipush 24
    //   3591: aload_1
    //   3592: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   3595: iconst_1
    //   3596: ireturn
    //   3597: aload_0
    //   3598: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3601: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3604: bipush 25
    //   3606: iconst_2
    //   3607: invokevirtual 37	ahkf:a	(II)V
    //   3610: aload_0
    //   3611: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3614: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3617: bipush 25
    //   3619: aload_1
    //   3620: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   3623: iconst_1
    //   3624: ireturn
    //   3625: aload_0
    //   3626: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3629: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3632: bipush 25
    //   3634: iconst_0
    //   3635: invokevirtual 37	ahkf:a	(II)V
    //   3638: aload_0
    //   3639: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3642: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3645: bipush 25
    //   3647: aload_1
    //   3648: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   3651: iconst_1
    //   3652: ireturn
    //   3653: aload_0
    //   3654: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3657: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3660: iconst_5
    //   3661: aload_1
    //   3662: getfield 274	android/os/Message:arg1	I
    //   3665: invokevirtual 37	ahkf:a	(II)V
    //   3668: aload_0
    //   3669: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3672: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3675: iconst_5
    //   3676: aload_1
    //   3677: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   3680: iconst_1
    //   3681: ireturn
    //   3682: aload_0
    //   3683: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3686: getfield 462	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahmx	Lahmx;
    //   3689: ifnull -3638 -> 51
    //   3692: aload_0
    //   3693: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3696: getfield 462	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahmx	Lahmx;
    //   3699: invokevirtual 465	ahmx:a	()V
    //   3702: iconst_1
    //   3703: ireturn
    //   3704: aload_0
    //   3705: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3708: getfield 468	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3711: ifnull -3660 -> 51
    //   3714: aload_1
    //   3715: getfield 274	android/os/Message:arg1	I
    //   3718: iconst_1
    //   3719: if_icmpne +38 -> 3757
    //   3722: iconst_1
    //   3723: istore_2
    //   3724: iload_2
    //   3725: ifeq +37 -> 3762
    //   3728: new 470	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   3731: dup
    //   3732: invokespecial 471	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   3735: astore_1
    //   3736: aload_1
    //   3737: getfield 475	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3740: iconst_0
    //   3741: invokevirtual 480	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3744: aload_0
    //   3745: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3748: getfield 468	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3751: aload_1
    //   3752: invokevirtual 485	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;)V
    //   3755: iconst_1
    //   3756: ireturn
    //   3757: iconst_0
    //   3758: istore_2
    //   3759: goto -35 -> 3724
    //   3762: aload_0
    //   3763: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3766: getfield 468	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3769: new 487	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   3772: dup
    //   3773: invokespecial 488	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   3776: invokevirtual 491	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   3779: iconst_1
    //   3780: ireturn
    //   3781: aload_0
    //   3782: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3785: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3788: astore 10
    //   3790: aload_1
    //   3791: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3794: ifnonnull +27 -> 3821
    //   3797: iload 4
    //   3799: istore_2
    //   3800: aload 10
    //   3802: iconst_3
    //   3803: iload_2
    //   3804: invokevirtual 37	ahkf:a	(II)V
    //   3807: aload_0
    //   3808: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3811: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3814: iconst_3
    //   3815: aload_1
    //   3816: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   3819: iconst_1
    //   3820: ireturn
    //   3821: iconst_2
    //   3822: istore_2
    //   3823: goto -23 -> 3800
    //   3826: aload_0
    //   3827: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3830: invokestatic 77	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   3833: iconst_1
    //   3834: ireturn
    //   3835: aload_0
    //   3836: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3839: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3842: bipush 10
    //   3844: invokevirtual 494	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   3847: checkcast 496	akfm
    //   3850: invokevirtual 498	akfm:b	()V
    //   3853: iconst_1
    //   3854: ireturn
    //   3855: aload_0
    //   3856: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3859: getfield 501	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   3862: getfield 504	com/tencent/mobileqq/app/FrameHelperActivity:a	Landroid/widget/ImageView;
    //   3865: astore_1
    //   3866: aload_0
    //   3867: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3870: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3873: sipush 250
    //   3876: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3879: checkcast 506	com/tencent/mobileqq/medalwall/MedalWallMng
    //   3882: aload_0
    //   3883: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3886: invokevirtual 509	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   3889: aload_1
    //   3890: iconst_1
    //   3891: aconst_null
    //   3892: invokevirtual 512	com/tencent/mobileqq/medalwall/MedalWallMng:a	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/view/View;ILjava/lang/Object;)Z
    //   3895: istore 9
    //   3897: invokestatic 388	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3900: ifeq -3849 -> 51
    //   3903: ldc_w 514
    //   3906: iconst_4
    //   3907: invokestatic 520	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   3910: ldc_w 522
    //   3913: iconst_1
    //   3914: anewarray 4	java/lang/Object
    //   3917: dup
    //   3918: iconst_0
    //   3919: iload 9
    //   3921: invokestatic 528	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3924: aastore
    //   3925: invokestatic 532	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3928: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3931: iconst_1
    //   3932: ireturn
    //   3933: ldc 56
    //   3935: ldc_w 534
    //   3938: invokestatic 539	veg:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3941: aload_0
    //   3942: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3945: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3948: ifnull +20 -> 3968
    //   3951: aload_0
    //   3952: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3955: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3958: sipush 181
    //   3961: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3964: checkcast 541	ssw
    //   3967: astore_1
    //   3968: new 543	com/tencent/mobileqq/activity/Conversation$1$7
    //   3971: dup
    //   3972: aload_0
    //   3973: invokespecial 544	com/tencent/mobileqq/activity/Conversation$1$7:<init>	(Laavy;)V
    //   3976: bipush 8
    //   3978: aconst_null
    //   3979: iconst_1
    //   3980: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   3983: iconst_1
    //   3984: ireturn
    //   3985: aload_0
    //   3986: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3989: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   3992: invokevirtual 546	ahkf:a	()Lmqq/os/MqqHandler;
    //   3995: astore 10
    //   3997: aload 10
    //   3999: ifnull -3948 -> 51
    //   4002: aload 10
    //   4004: sipush 200
    //   4007: invokevirtual 550	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   4010: astore 11
    //   4012: aload 11
    //   4014: aload_1
    //   4015: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4018: putfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4021: aload 10
    //   4023: aload 11
    //   4025: invokevirtual 553	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   4028: pop
    //   4029: iconst_1
    //   4030: ireturn
    //   4031: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4034: ifeq +30 -> 4064
    //   4037: ldc_w 555
    //   4040: iconst_2
    //   4041: new 390	java/lang/StringBuilder
    //   4044: dup
    //   4045: invokespecial 391	java/lang/StringBuilder:<init>	()V
    //   4048: ldc_w 557
    //   4051: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4054: aload_1
    //   4055: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4058: invokevirtual 411	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4061: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4064: aload_0
    //   4065: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4068: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   4071: invokevirtual 546	ahkf:a	()Lmqq/os/MqqHandler;
    //   4074: astore 10
    //   4076: aload 10
    //   4078: ifnull -4027 -> 51
    //   4081: aload 10
    //   4083: sipush 201
    //   4086: invokevirtual 550	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   4089: astore 11
    //   4091: aload 11
    //   4093: aload_1
    //   4094: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4097: putfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4100: aload 10
    //   4102: aload 11
    //   4104: invokevirtual 553	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   4107: pop
    //   4108: iconst_1
    //   4109: ireturn
    //   4110: invokestatic 565	com/tencent/mobileqq/theme/ThemeUtil:isDefaultTheme	()Z
    //   4113: ifne +38 -> 4151
    //   4116: iconst_0
    //   4117: invokestatic 569	com/tencent/mobileqq/theme/ThemeUtil:isSimpleDayTheme	(Z)Z
    //   4120: ifne +31 -> 4151
    //   4123: aload_0
    //   4124: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4127: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4130: sipush 1069
    //   4133: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4136: aload_0
    //   4137: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4140: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4143: sipush 1068
    //   4146: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4149: iconst_1
    //   4150: ireturn
    //   4151: aload_0
    //   4152: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4155: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4158: sipush 1068
    //   4161: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   4164: ifeq +16 -> 4180
    //   4167: aload_0
    //   4168: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4171: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4174: sipush 1068
    //   4177: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4180: aload_0
    //   4181: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4184: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   4187: iconst_0
    //   4188: invokevirtual 571	ahkf:d	(Z)V
    //   4191: aload_0
    //   4192: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4195: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   4198: invokevirtual 546	ahkf:a	()Lmqq/os/MqqHandler;
    //   4201: ifnull -4150 -> 51
    //   4204: aload_0
    //   4205: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4208: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   4211: iconst_m1
    //   4212: aconst_null
    //   4213: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   4216: iconst_1
    //   4217: ireturn
    //   4218: invokestatic 565	com/tencent/mobileqq/theme/ThemeUtil:isDefaultTheme	()Z
    //   4221: ifne +38 -> 4259
    //   4224: iconst_0
    //   4225: invokestatic 569	com/tencent/mobileqq/theme/ThemeUtil:isSimpleDayTheme	(Z)Z
    //   4228: ifne +31 -> 4259
    //   4231: aload_0
    //   4232: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4235: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4238: sipush 1069
    //   4241: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4244: aload_0
    //   4245: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4248: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4251: sipush 1068
    //   4254: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4257: iconst_1
    //   4258: ireturn
    //   4259: aload_0
    //   4260: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4263: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4266: sipush 1069
    //   4269: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   4272: ifeq +16 -> 4288
    //   4275: aload_0
    //   4276: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4279: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4282: sipush 1069
    //   4285: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4288: aload_0
    //   4289: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4292: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   4295: iconst_1
    //   4296: invokevirtual 571	ahkf:d	(Z)V
    //   4299: aload_0
    //   4300: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4303: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   4306: invokevirtual 546	ahkf:a	()Lmqq/os/MqqHandler;
    //   4309: ifnull -4258 -> 51
    //   4312: aload_0
    //   4313: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4316: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   4319: iconst_m1
    //   4320: aconst_null
    //   4321: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   4324: iconst_1
    //   4325: ireturn
    //   4326: aload_0
    //   4327: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4330: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4333: sipush 1070
    //   4336: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4339: aload_0
    //   4340: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4343: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4346: bipush 36
    //   4348: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4351: checkcast 573	avpq
    //   4354: invokevirtual 574	avpq:b	()V
    //   4357: iconst_1
    //   4358: ireturn
    //   4359: aload_0
    //   4360: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4363: getfield 576	com/tencent/mobileqq/activity/Conversation:f	Z
    //   4366: ifeq -4315 -> 51
    //   4369: aload_0
    //   4370: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4373: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4376: ldc_w 577
    //   4379: getstatic 581	axqt:a	I
    //   4382: sipush 1000
    //   4385: imul
    //   4386: i2l
    //   4387: invokevirtual 585	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   4390: pop
    //   4391: iconst_1
    //   4392: ireturn
    //   4393: aload_0
    //   4394: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4397: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4400: invokestatic 588	axqt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   4403: iconst_1
    //   4404: ireturn
    //   4405: aload_1
    //   4406: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4409: instanceof 590
    //   4412: ifeq -4361 -> 51
    //   4415: aload_0
    //   4416: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4419: getfield 593	com/tencent/mobileqq/activity/Conversation:h	Z
    //   4422: ifne -4371 -> 51
    //   4425: aload_1
    //   4426: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4429: checkcast 590	[Ljava/lang/String;
    //   4432: checkcast 590	[Ljava/lang/String;
    //   4435: astore 11
    //   4437: aload 11
    //   4439: arraylength
    //   4440: iconst_3
    //   4441: if_icmpne -4390 -> 51
    //   4444: aload 11
    //   4446: iconst_0
    //   4447: aaload
    //   4448: astore_1
    //   4449: aload 11
    //   4451: iconst_1
    //   4452: aaload
    //   4453: astore 10
    //   4455: aload 11
    //   4457: iconst_2
    //   4458: aaload
    //   4459: astore 11
    //   4461: new 595	aaxr
    //   4464: dup
    //   4465: aload_0
    //   4466: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4469: aload_1
    //   4470: aload 10
    //   4472: aload 11
    //   4474: invokespecial 598	aaxr:<init>	(Lcom/tencent/mobileqq/activity/Conversation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4477: invokevirtual 599	aaxr:a	()V
    //   4480: iconst_1
    //   4481: ireturn
    //   4482: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4485: ifeq +32 -> 4517
    //   4488: ldc 56
    //   4490: iconst_2
    //   4491: new 390	java/lang/StringBuilder
    //   4494: dup
    //   4495: invokespecial 391	java/lang/StringBuilder:<init>	()V
    //   4498: ldc_w 601
    //   4501: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4504: aload_1
    //   4505: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4508: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4511: invokevirtual 411	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4514: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4517: aload_0
    //   4518: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4521: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   4524: iconst_2
    //   4525: iconst_2
    //   4526: invokevirtual 37	ahkf:a	(II)V
    //   4529: aload_0
    //   4530: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4533: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   4536: iconst_2
    //   4537: aload_1
    //   4538: invokevirtual 74	ahkf:a	(ILandroid/os/Message;)V
    //   4541: iconst_1
    //   4542: ireturn
    //   4543: aload_0
    //   4544: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4547: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkf	Lahkf;
    //   4550: invokevirtual 602	ahkf:a	()V
    //   4553: aload_0
    //   4554: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4557: iconst_1
    //   4558: putfield 604	com/tencent/mobileqq/activity/Conversation:r	Z
    //   4561: aload_0
    //   4562: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4565: getfield 606	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4568: bipush 18
    //   4570: invokevirtual 609	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   4573: pop
    //   4574: iconst_1
    //   4575: ireturn
    //   4576: aload_0
    //   4577: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4580: ldc_w 610
    //   4583: invokevirtual 612	com/tencent/mobileqq/activity/Conversation:a	(I)Landroid/view/View;
    //   4586: checkcast 614	android/widget/TextView
    //   4589: invokestatic 619	ia:a	(Landroid/widget/TextView;)V
    //   4592: iconst_1
    //   4593: ireturn
    //   4594: aload_0
    //   4595: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4598: ldc_w 610
    //   4601: invokevirtual 612	com/tencent/mobileqq/activity/Conversation:a	(I)Landroid/view/View;
    //   4604: bipush 8
    //   4606: invokevirtual 117	android/view/View:setVisibility	(I)V
    //   4609: iconst_1
    //   4610: ireturn
    //   4611: new 621	com/tencent/mobileqq/activity/Conversation$1$8
    //   4614: dup
    //   4615: aload_0
    //   4616: invokespecial 622	com/tencent/mobileqq/activity/Conversation$1$8:<init>	(Laavy;)V
    //   4619: invokestatic 623	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   4622: iconst_1
    //   4623: ireturn
    //   4624: aload_0
    //   4625: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4628: invokestatic 625	com/tencent/mobileqq/activity/Conversation:d	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   4631: iconst_1
    //   4632: ireturn
    //   4633: invokestatic 629	amtc:g	()Z
    //   4636: ifeq -3840 -> 796
    //   4639: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4642: ifeq +12 -> 4654
    //   4645: ldc 56
    //   4647: iconst_2
    //   4648: ldc_w 631
    //   4651: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4654: aload_0
    //   4655: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4658: iconst_1
    //   4659: invokestatic 634	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)Z
    //   4662: pop
    //   4663: aload_0
    //   4664: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4667: invokestatic 637	android/os/SystemClock:elapsedRealtime	()J
    //   4670: invokestatic 640	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;J)J
    //   4673: pop2
    //   4674: aload_0
    //   4675: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4678: invokestatic 348	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   4681: iconst_0
    //   4682: invokevirtual 643	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   4685: aload_0
    //   4686: getfield 12	aavy:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4689: invokestatic 645	com/tencent/mobileqq/activity/Conversation:e	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   4692: iconst_1
    //   4693: ireturn
    //   4694: goto -1483 -> 3211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4697	0	this	aavy
    //   0	4697	1	paramMessage	android.os.Message
    //   1	3822	2	i	int
    //   6	3438	3	j	int
    //   3	3795	4	k	int
    //   1311	1987	5	l1	long
    //   1323	216	7	l2	long
    //   3895	25	9	bool	boolean
    //   922	540	10	localObject1	Object
    //   1642	1	10	localException	java.lang.Exception
    //   1764	2707	10	localObject2	Object
    //   1032	3441	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   1595	1605	1642	java/lang/Exception
    //   1595	1605	1656	finally
    //   2223	2254	2287	java/lang/Exception
    //   2254	2274	2287	java/lang/Exception
    //   2279	2285	2287	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aavy
 * JD-Core Version:    0.7.0.1
 */