import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.Conversation;

public class acms
  implements Handler.Callback
{
  public acms(Conversation paramConversation) {}
  
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
    //   17: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   20: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   23: bipush 12
    //   25: iconst_0
    //   26: invokevirtual 37	ajbm:a	(II)V
    //   29: aload_1
    //   30: getfield 26	android/os/Message:what	I
    //   33: ldc 38
    //   35: if_icmpeq +18 -> 53
    //   38: aload_0
    //   39: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   42: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   48: ifne +5 -> 53
    //   51: iconst_1
    //   52: ireturn
    //   53: aload_1
    //   54: getfield 26	android/os/Message:what	I
    //   57: lookupswitch	default:+747->804, 1009:+758->815, 1010:+793->850, 1014:+2925->2982, 1016:+2935->2992, 1017:+3002->3059, 1019:+3333->3390, 1020:+3012->3069, 1023:+1184->1241, 1024:+3352->3409, 1025:+749->806, 1027:+1201->1258, 1030:+3376->3433, 1032:+2813->2870, 1033:+2841->2898, 1035:+3483->3540, 1038:+3492->3549, 1039:+3520->3577, 1040:+2869->2926, 1041:+2897->2954, 1042:+3604->3661, 1044:+3633->3690, 1048:+3655->3712, 1049:+3548->3605, 1050:+3576->3633, 1052:+3732->3789, 1053:+3777->3834, 1054:+3806->3863, 1055:+3884->3941, 1059:+4504->4561, 1060:+4522->4579, 1061:+4539->4596, 1062:+869->926, 1063:+1095->1152, 1064:+1151->1208, 1067:+4552->4609, 1068:+4169->4226, 1069:+4061->4118, 1070:+4277->4334, 1071:+4561->4618, 1072:+4622->4679, 10000:+3021->3078, 10001:+782->839, 10002:+782->839, 10003:+782->839, 1134010:+1790->1847, 1134011:+1853->1910, 1134012:+2750->2807, 1134013:+2776->2833, 1134014:+2802->2859, 1134015:+2724->2781, 1134018:+1355->1412, 1134019:+1536->1593, 1134020:+1619->1676, 1134021:+2521->2578, 1134022:+2549->2606, 1134024:+2691->2748, 1134025:+3385->3442, 1134026:+3437->3494, 1134027:+1937->1994, 1134028:+1994->2051, 1134030:+3786->3843, 1134039:+2281->2338, 1134040:+2338->2395, 1134041:+2366->2423, 1134042:+2423->2480, 1134043:+2022->2079, 1134044:+2050->2107, 1134045:+1629->1686, 1134047:+1639->1696, 1134048:+1656->1713, 1134049:+2451->2508, 1134050:+2493->2550, 1134051:+2078->2135, 1134052:+2130->2187, 1134053:+2174->2231, 1134054:+-6->51, 1134057:+1673->1730, 1134058:+1690->1747, 1134059:+1881->1938, 1134060:+1909->1966, 1134061:+4310->4367, 1134062:+4344->4401, 1134063:+4433->4490, 1134064:+4494->4551, 1134065:+1818->1875, 1134066:+2577->2634, 1134067:+2634->2691, 1134068:+4356->4413, 1134200:+3936->3993, 1134201:+3982->4039, 11340003:+1224->1281, 11340004:+1762->1819
    //   805: ireturn
    //   806: aload_0
    //   807: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   810: invokestatic 49	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   813: iconst_1
    //   814: ireturn
    //   815: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   818: ifeq +11 -> 829
    //   821: ldc 56
    //   823: iconst_2
    //   824: ldc 58
    //   826: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   829: aload_0
    //   830: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   833: lconst_0
    //   834: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   837: iconst_1
    //   838: ireturn
    //   839: aload_0
    //   840: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   843: aload_1
    //   844: iconst_1
    //   845: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   848: iconst_1
    //   849: ireturn
    //   850: aload_0
    //   851: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   854: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   857: invokevirtual 71	ajbm:c	()Z
    //   860: ifeq +38 -> 898
    //   863: aload_0
    //   864: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   867: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   870: bipush 21
    //   872: iconst_2
    //   873: invokevirtual 37	ajbm:a	(II)V
    //   876: aload_0
    //   877: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   880: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   883: bipush 21
    //   885: aload_1
    //   886: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   889: aload_0
    //   890: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   893: invokestatic 77	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   896: iconst_1
    //   897: ireturn
    //   898: aload_0
    //   899: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   902: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   905: bipush 21
    //   907: iconst_0
    //   908: invokevirtual 37	ajbm:a	(II)V
    //   911: aload_0
    //   912: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   915: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   918: bipush 21
    //   920: aconst_null
    //   921: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   924: iconst_1
    //   925: ireturn
    //   926: aload_1
    //   927: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   930: astore 10
    //   932: aload 10
    //   934: ifnonnull +72 -> 1006
    //   937: aload_0
    //   938: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   941: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   944: invokevirtual 83	ajbm:b	()Z
    //   947: ifeq +31 -> 978
    //   950: aload_0
    //   951: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   954: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   957: bipush 20
    //   959: iconst_2
    //   960: invokevirtual 37	ajbm:a	(II)V
    //   963: aload_0
    //   964: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   967: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   970: bipush 20
    //   972: aload_1
    //   973: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   976: iconst_1
    //   977: ireturn
    //   978: aload_0
    //   979: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   982: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   985: bipush 20
    //   987: iconst_0
    //   988: invokevirtual 37	ajbm:a	(II)V
    //   991: aload_0
    //   992: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   995: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   998: bipush 20
    //   1000: aconst_null
    //   1001: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1004: iconst_1
    //   1005: ireturn
    //   1006: aload 10
    //   1008: instanceof 85
    //   1011: ifeq -960 -> 51
    //   1014: aload 10
    //   1016: checkcast 85	[Landroid/view/View;
    //   1019: checkcast 85	[Landroid/view/View;
    //   1022: astore 10
    //   1024: aload 10
    //   1026: arraylength
    //   1027: iconst_3
    //   1028: if_icmpne -977 -> 51
    //   1031: aload 10
    //   1033: iconst_0
    //   1034: aaload
    //   1035: astore_1
    //   1036: aload 10
    //   1038: iconst_1
    //   1039: aaload
    //   1040: astore 11
    //   1042: aload 10
    //   1044: iconst_2
    //   1045: aaload
    //   1046: astore 10
    //   1048: aload_1
    //   1049: ifnull -998 -> 51
    //   1052: aload_1
    //   1053: invokevirtual 91	android/view/View:getParent	()Landroid/view/ViewParent;
    //   1056: ifnonnull -1005 -> 51
    //   1059: aload_0
    //   1060: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1063: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1066: ldc 95
    //   1068: invokevirtual 101	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   1071: astore 11
    //   1073: aload 11
    //   1075: ifnull +15 -> 1090
    //   1078: aload_0
    //   1079: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1082: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1085: aload 11
    //   1087: invokevirtual 105	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   1090: aload_0
    //   1091: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1094: invokestatic 108	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   1097: ifnull +24 -> 1121
    //   1100: aload_0
    //   1101: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1104: invokestatic 108	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   1107: invokeinterface 113 1 0
    //   1112: ifeq +9 -> 1121
    //   1115: aload_1
    //   1116: bipush 8
    //   1118: invokevirtual 117	android/view/View:setVisibility	(I)V
    //   1121: aload_0
    //   1122: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1125: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1128: aload_1
    //   1129: invokevirtual 120	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1132: aload 10
    //   1134: ifnull -1083 -> 51
    //   1137: aload 10
    //   1139: new 122	acmt
    //   1142: dup
    //   1143: aload_0
    //   1144: invokespecial 125	acmt:<init>	(Lacms;)V
    //   1147: invokevirtual 129	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1150: iconst_1
    //   1151: ireturn
    //   1152: aload_0
    //   1153: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1156: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1159: ifnull +13 -> 1172
    //   1162: aload_0
    //   1163: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1166: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1169: invokevirtual 132	ajbm:f	()V
    //   1172: aload_0
    //   1173: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1176: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1179: ldc 95
    //   1181: invokevirtual 101	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   1184: astore_1
    //   1185: aload_1
    //   1186: ifnull -1135 -> 51
    //   1189: aload_1
    //   1190: bipush 8
    //   1192: invokevirtual 117	android/view/View:setVisibility	(I)V
    //   1195: aload_0
    //   1196: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1199: getfield 94	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1202: aload_1
    //   1203: invokevirtual 105	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   1206: iconst_1
    //   1207: ireturn
    //   1208: aload_1
    //   1209: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1212: astore_1
    //   1213: aload_1
    //   1214: ifnull -1163 -> 51
    //   1217: aload_1
    //   1218: instanceof 134
    //   1221: ifeq -1170 -> 51
    //   1224: new 136	com/tencent/mobileqq/activity/Conversation$1$2
    //   1227: dup
    //   1228: aload_0
    //   1229: aload_1
    //   1230: checkcast 134	java/lang/String
    //   1233: invokespecial 139	com/tencent/mobileqq/activity/Conversation$1$2:<init>	(Lacms;Ljava/lang/String;)V
    //   1236: invokestatic 145	com/tencent/mobileqq/app/ThreadManagerV2:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   1239: iconst_1
    //   1240: ireturn
    //   1241: invokestatic 151	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1244: new 153	com/tencent/mobileqq/activity/Conversation$1$3
    //   1247: dup
    //   1248: aload_0
    //   1249: invokespecial 154	com/tencent/mobileqq/activity/Conversation$1$3:<init>	(Lacms;)V
    //   1252: invokevirtual 160	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1255: pop
    //   1256: iconst_1
    //   1257: ireturn
    //   1258: aload_0
    //   1259: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1262: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1265: invokestatic 165	anxf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lanxf;
    //   1268: aload_0
    //   1269: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1272: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1275: aload_1
    //   1276: invokevirtual 168	anxf:a	(Lajbm;Landroid/os/Message;)V
    //   1279: iconst_1
    //   1280: ireturn
    //   1281: invokestatic 173	amlp:a	()Lamlp;
    //   1284: invokevirtual 176	amlp:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   1287: astore 10
    //   1289: aload 10
    //   1291: getfield 181	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1294: ifnull -1243 -> 51
    //   1297: aload_0
    //   1298: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1301: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1304: invokevirtual 185	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   1307: astore 11
    //   1309: aload 11
    //   1311: ldc 187
    //   1313: lconst_0
    //   1314: invokeinterface 193 4 0
    //   1319: lstore 5
    //   1321: new 195	java/util/Date
    //   1324: dup
    //   1325: invokespecial 196	java/util/Date:<init>	()V
    //   1328: invokevirtual 200	java/util/Date:getTime	()J
    //   1331: lstore 7
    //   1333: lload 7
    //   1335: lload 5
    //   1337: lsub
    //   1338: aload 10
    //   1340: getfield 181	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1343: getfield 206	com/tencent/mobileqq/app/NewUpgradeConfig:dialog	Laltj;
    //   1346: getfield 210	altj:b	I
    //   1349: bipush 24
    //   1351: imul
    //   1352: bipush 60
    //   1354: imul
    //   1355: bipush 60
    //   1357: imul
    //   1358: sipush 1000
    //   1361: imul
    //   1362: i2l
    //   1363: lcmp
    //   1364: ifle -1313 -> 51
    //   1367: aload_0
    //   1368: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1371: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1374: bipush 12
    //   1376: iconst_2
    //   1377: invokevirtual 37	ajbm:a	(II)V
    //   1380: aload_0
    //   1381: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1384: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1387: bipush 12
    //   1389: aload_1
    //   1390: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1393: aload 11
    //   1395: invokeinterface 214 1 0
    //   1400: ldc 187
    //   1402: lload 7
    //   1404: invokeinterface 220 4 0
    //   1409: pop
    //   1410: iconst_1
    //   1411: ireturn
    //   1412: invokestatic 173	amlp:a	()Lamlp;
    //   1415: invokevirtual 176	amlp:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   1418: astore 10
    //   1420: aload 10
    //   1422: getfield 181	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1425: ifnull -1374 -> 51
    //   1428: aload_0
    //   1429: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1432: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1435: invokevirtual 185	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   1438: astore 11
    //   1440: aload 11
    //   1442: ldc 187
    //   1444: lconst_0
    //   1445: invokeinterface 193 4 0
    //   1450: lstore 5
    //   1452: new 195	java/util/Date
    //   1455: dup
    //   1456: invokespecial 196	java/util/Date:<init>	()V
    //   1459: invokevirtual 200	java/util/Date:getTime	()J
    //   1462: lstore 7
    //   1464: lload 7
    //   1466: lload 5
    //   1468: lsub
    //   1469: aload 10
    //   1471: getfield 181	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   1474: getfield 206	com/tencent/mobileqq/app/NewUpgradeConfig:dialog	Laltj;
    //   1477: getfield 210	altj:b	I
    //   1480: bipush 24
    //   1482: imul
    //   1483: bipush 60
    //   1485: imul
    //   1486: bipush 60
    //   1488: imul
    //   1489: sipush 1000
    //   1492: imul
    //   1493: i2l
    //   1494: lcmp
    //   1495: ifle +64 -> 1559
    //   1498: aload_0
    //   1499: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1502: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1505: bipush 14
    //   1507: iconst_2
    //   1508: invokevirtual 37	ajbm:a	(II)V
    //   1511: aload_0
    //   1512: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1515: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1518: bipush 12
    //   1520: iconst_0
    //   1521: invokevirtual 37	ajbm:a	(II)V
    //   1524: aload_0
    //   1525: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1528: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1531: bipush 14
    //   1533: aload_1
    //   1534: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1537: aload 11
    //   1539: invokeinterface 214 1 0
    //   1544: ldc 187
    //   1546: lload 7
    //   1548: invokeinterface 220 4 0
    //   1553: invokeinterface 223 1 0
    //   1558: pop
    //   1559: aload_1
    //   1560: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1563: ifnull -1512 -> 51
    //   1566: aload_1
    //   1567: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1570: instanceof 225
    //   1573: ifeq -1522 -> 51
    //   1576: aload_1
    //   1577: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   1580: checkcast 225	com/tencent/mobileqq/activity/UpgradeActivity
    //   1583: astore_1
    //   1584: invokestatic 173	amlp:a	()Lamlp;
    //   1587: aload_1
    //   1588: invokevirtual 228	amlp:a	(Landroid/content/Context;)V
    //   1591: iconst_1
    //   1592: ireturn
    //   1593: aload_0
    //   1594: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1597: invokestatic 231	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1600: ifnull +22 -> 1622
    //   1603: aload_0
    //   1604: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1607: invokestatic 231	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1610: invokevirtual 236	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   1613: aload_0
    //   1614: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1617: aconst_null
    //   1618: invokestatic 239	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1621: pop
    //   1622: aload_0
    //   1623: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1626: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1629: bipush 14
    //   1631: iconst_0
    //   1632: invokevirtual 37	ajbm:a	(II)V
    //   1635: aload_0
    //   1636: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1639: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1642: bipush 14
    //   1644: aload_1
    //   1645: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1648: iconst_1
    //   1649: ireturn
    //   1650: astore 10
    //   1652: aload_0
    //   1653: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1656: aconst_null
    //   1657: invokestatic 239	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1660: pop
    //   1661: goto -39 -> 1622
    //   1664: astore_1
    //   1665: aload_0
    //   1666: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1669: aconst_null
    //   1670: invokestatic 239	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1673: pop
    //   1674: aload_1
    //   1675: athrow
    //   1676: aload_0
    //   1677: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1680: aload_1
    //   1681: invokestatic 242	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1684: iconst_1
    //   1685: ireturn
    //   1686: aload_0
    //   1687: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1690: aload_1
    //   1691: invokestatic 244	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1694: iconst_1
    //   1695: ireturn
    //   1696: invokestatic 151	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1699: new 246	com/tencent/mobileqq/activity/Conversation$1$4
    //   1702: dup
    //   1703: aload_0
    //   1704: invokespecial 247	com/tencent/mobileqq/activity/Conversation$1$4:<init>	(Lacms;)V
    //   1707: invokevirtual 160	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1710: pop
    //   1711: iconst_1
    //   1712: ireturn
    //   1713: invokestatic 151	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1716: new 249	com/tencent/mobileqq/activity/Conversation$1$5
    //   1719: dup
    //   1720: aload_0
    //   1721: invokespecial 250	com/tencent/mobileqq/activity/Conversation$1$5:<init>	(Lacms;)V
    //   1724: invokevirtual 160	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1727: pop
    //   1728: iconst_1
    //   1729: ireturn
    //   1730: new 252	com/tencent/mobileqq/activity/Conversation$1$6
    //   1733: dup
    //   1734: aload_0
    //   1735: invokespecial 253	com/tencent/mobileqq/activity/Conversation$1$6:<init>	(Lacms;)V
    //   1738: bipush 8
    //   1740: aconst_null
    //   1741: iconst_1
    //   1742: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1745: iconst_1
    //   1746: ireturn
    //   1747: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1750: ifeq +12 -> 1762
    //   1753: ldc 56
    //   1755: iconst_2
    //   1756: ldc_w 258
    //   1759: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1762: aload_0
    //   1763: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1766: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1769: invokestatic 266	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;
    //   1772: astore 10
    //   1774: aload 10
    //   1776: invokevirtual 268	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	()V
    //   1779: aload_0
    //   1780: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1783: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1786: aload 10
    //   1788: invokestatic 271	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   1791: aload_0
    //   1792: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1795: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1798: bipush 26
    //   1800: iconst_0
    //   1801: invokevirtual 37	ajbm:a	(II)V
    //   1804: aload_0
    //   1805: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1808: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1811: bipush 26
    //   1813: aload_1
    //   1814: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1817: iconst_1
    //   1818: ireturn
    //   1819: aload_0
    //   1820: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1823: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1826: bipush 12
    //   1828: iconst_0
    //   1829: invokevirtual 37	ajbm:a	(II)V
    //   1832: aload_0
    //   1833: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1836: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1839: bipush 12
    //   1841: aload_1
    //   1842: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1845: iconst_1
    //   1846: ireturn
    //   1847: aload_0
    //   1848: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1851: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1854: bipush 36
    //   1856: iconst_2
    //   1857: invokevirtual 37	ajbm:a	(II)V
    //   1860: aload_0
    //   1861: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1864: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1867: bipush 36
    //   1869: aload_1
    //   1870: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1873: iconst_1
    //   1874: ireturn
    //   1875: aload_1
    //   1876: ifnull -1825 -> 51
    //   1879: aload_0
    //   1880: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1883: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1886: bipush 10
    //   1888: aload_1
    //   1889: getfield 274	android/os/Message:arg1	I
    //   1892: invokevirtual 37	ajbm:a	(II)V
    //   1895: aload_0
    //   1896: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1899: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1902: bipush 10
    //   1904: aload_1
    //   1905: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1908: iconst_1
    //   1909: ireturn
    //   1910: aload_0
    //   1911: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1914: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1917: bipush 36
    //   1919: iconst_0
    //   1920: invokevirtual 37	ajbm:a	(II)V
    //   1923: aload_0
    //   1924: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1927: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1930: bipush 36
    //   1932: aload_1
    //   1933: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1936: iconst_1
    //   1937: ireturn
    //   1938: aload_0
    //   1939: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1942: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1945: bipush 34
    //   1947: iconst_2
    //   1948: invokevirtual 37	ajbm:a	(II)V
    //   1951: aload_0
    //   1952: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1955: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1958: bipush 34
    //   1960: aload_1
    //   1961: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1964: iconst_1
    //   1965: ireturn
    //   1966: aload_0
    //   1967: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1970: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1973: bipush 34
    //   1975: iconst_0
    //   1976: invokevirtual 37	ajbm:a	(II)V
    //   1979: aload_0
    //   1980: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1983: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   1986: bipush 34
    //   1988: aload_1
    //   1989: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   1992: iconst_1
    //   1993: ireturn
    //   1994: aload_0
    //   1995: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1998: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2001: ldc_w 278
    //   2004: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2007: ifeq +16 -> 2023
    //   2010: aload_0
    //   2011: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2014: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2017: ldc_w 278
    //   2020: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2023: aload_0
    //   2024: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2027: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2030: bipush 28
    //   2032: iconst_2
    //   2033: invokevirtual 37	ajbm:a	(II)V
    //   2036: aload_0
    //   2037: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2040: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2043: bipush 28
    //   2045: aload_1
    //   2046: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2049: iconst_1
    //   2050: ireturn
    //   2051: aload_0
    //   2052: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2055: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2058: bipush 28
    //   2060: iconst_0
    //   2061: invokevirtual 37	ajbm:a	(II)V
    //   2064: aload_0
    //   2065: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2068: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2071: bipush 28
    //   2073: aload_1
    //   2074: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2077: iconst_1
    //   2078: ireturn
    //   2079: aload_0
    //   2080: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2083: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2086: bipush 32
    //   2088: iconst_2
    //   2089: invokevirtual 37	ajbm:a	(II)V
    //   2092: aload_0
    //   2093: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2096: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2099: bipush 32
    //   2101: aload_1
    //   2102: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2105: iconst_1
    //   2106: ireturn
    //   2107: aload_0
    //   2108: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2111: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2114: bipush 32
    //   2116: iconst_0
    //   2117: invokevirtual 37	ajbm:a	(II)V
    //   2120: aload_0
    //   2121: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2124: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2127: bipush 32
    //   2129: aload_1
    //   2130: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2133: iconst_1
    //   2134: ireturn
    //   2135: aload_1
    //   2136: getfield 274	android/os/Message:arg1	I
    //   2139: iconst_1
    //   2140: if_icmpeq +16 -> 2156
    //   2143: aload_0
    //   2144: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2147: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2150: bipush 33
    //   2152: iconst_2
    //   2153: invokevirtual 37	ajbm:a	(II)V
    //   2156: aload_0
    //   2157: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2160: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2163: bipush 33
    //   2165: aload_1
    //   2166: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2169: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2172: ifeq -2121 -> 51
    //   2175: ldc_w 287
    //   2178: iconst_2
    //   2179: ldc_w 289
    //   2182: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2185: iconst_1
    //   2186: ireturn
    //   2187: aload_0
    //   2188: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2191: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2194: bipush 33
    //   2196: iconst_0
    //   2197: invokevirtual 37	ajbm:a	(II)V
    //   2200: aload_0
    //   2201: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2204: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2207: bipush 33
    //   2209: aload_1
    //   2210: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2213: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2216: ifeq -2165 -> 51
    //   2219: ldc_w 287
    //   2222: iconst_2
    //   2223: ldc_w 291
    //   2226: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2229: iconst_1
    //   2230: ireturn
    //   2231: aload_0
    //   2232: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2235: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2238: sipush 153
    //   2241: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2244: checkcast 297	akji
    //   2247: astore 10
    //   2249: aconst_null
    //   2250: invokestatic 302	akro:a	(Ljava/lang/Object;)Z
    //   2253: ifeq +9 -> 2262
    //   2256: aload 10
    //   2258: iconst_1
    //   2259: putfield 306	akji:k	Z
    //   2262: aload_0
    //   2263: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2266: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2269: getfield 309	com/tencent/mobileqq/app/QQAppInterface:o	Z
    //   2272: ifeq +10 -> 2282
    //   2275: aconst_null
    //   2276: invokestatic 302	akro:a	(Ljava/lang/Object;)Z
    //   2279: ifeq +19 -> 2298
    //   2282: aload 10
    //   2284: ifnull -2233 -> 51
    //   2287: aload 10
    //   2289: iconst_1
    //   2290: putfield 312	akji:j	Z
    //   2293: iconst_1
    //   2294: ireturn
    //   2295: astore_1
    //   2296: iconst_1
    //   2297: ireturn
    //   2298: invokestatic 315	com/tencent/mobileqq/app/FrameHelperActivity:b	()Z
    //   2301: ifeq +10 -> 2311
    //   2304: iconst_1
    //   2305: invokestatic 318	com/tencent/mobileqq/app/FrameHelperActivity:c	(Z)V
    //   2308: invokestatic 321	com/tencent/mobileqq/app/FrameHelperActivity:s	()V
    //   2311: aload_0
    //   2312: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2315: getfield 323	com/tencent/mobileqq/activity/Conversation:b	Landroid/widget/RelativeLayout;
    //   2318: aload_1
    //   2319: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   2322: checkcast 134	java/lang/String
    //   2325: invokestatic 326	akro:a	(Landroid/view/View;Ljava/lang/String;)V
    //   2328: aload_0
    //   2329: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2332: iconst_1
    //   2333: putfield 328	com/tencent/mobileqq/activity/Conversation:d	Z
    //   2336: iconst_1
    //   2337: ireturn
    //   2338: aload_0
    //   2339: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2342: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2345: ldc_w 329
    //   2348: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2351: ifeq +16 -> 2367
    //   2354: aload_0
    //   2355: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2358: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2361: ldc_w 329
    //   2364: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2367: aload_0
    //   2368: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2371: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2374: bipush 29
    //   2376: iconst_2
    //   2377: invokevirtual 37	ajbm:a	(II)V
    //   2380: aload_0
    //   2381: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2384: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2387: bipush 29
    //   2389: aload_1
    //   2390: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2393: iconst_1
    //   2394: ireturn
    //   2395: aload_0
    //   2396: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2399: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2402: bipush 29
    //   2404: iconst_0
    //   2405: invokevirtual 37	ajbm:a	(II)V
    //   2408: aload_0
    //   2409: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2412: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2415: bipush 29
    //   2417: aload_1
    //   2418: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2421: iconst_1
    //   2422: ireturn
    //   2423: aload_0
    //   2424: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2427: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2430: ldc_w 330
    //   2433: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2436: ifeq +16 -> 2452
    //   2439: aload_0
    //   2440: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2443: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2446: ldc_w 330
    //   2449: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2452: aload_0
    //   2453: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2456: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2459: bipush 30
    //   2461: iconst_2
    //   2462: invokevirtual 37	ajbm:a	(II)V
    //   2465: aload_0
    //   2466: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2469: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2472: bipush 30
    //   2474: aload_1
    //   2475: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2478: iconst_1
    //   2479: ireturn
    //   2480: aload_0
    //   2481: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2484: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2487: bipush 30
    //   2489: iconst_0
    //   2490: invokevirtual 37	ajbm:a	(II)V
    //   2493: aload_0
    //   2494: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2497: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2500: bipush 30
    //   2502: aload_1
    //   2503: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2506: iconst_1
    //   2507: ireturn
    //   2508: aload_0
    //   2509: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2512: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2515: ldc_w 331
    //   2518: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2521: ifeq +16 -> 2537
    //   2524: aload_0
    //   2525: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2528: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2531: ldc_w 331
    //   2534: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2537: aload_0
    //   2538: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2541: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2544: aload_1
    //   2545: invokevirtual 334	ajbm:a	(Landroid/os/Message;)V
    //   2548: iconst_1
    //   2549: ireturn
    //   2550: aload_0
    //   2551: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2554: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2557: bipush 31
    //   2559: iconst_0
    //   2560: invokevirtual 37	ajbm:a	(II)V
    //   2563: aload_0
    //   2564: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2567: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2570: bipush 31
    //   2572: aload_1
    //   2573: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2576: iconst_1
    //   2577: ireturn
    //   2578: aload_0
    //   2579: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2582: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2585: bipush 7
    //   2587: iconst_2
    //   2588: invokevirtual 37	ajbm:a	(II)V
    //   2591: aload_0
    //   2592: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2595: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2598: bipush 7
    //   2600: aload_1
    //   2601: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2604: iconst_1
    //   2605: ireturn
    //   2606: aload_0
    //   2607: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2610: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2613: bipush 7
    //   2615: iconst_0
    //   2616: invokevirtual 37	ajbm:a	(II)V
    //   2619: aload_0
    //   2620: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2623: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2626: bipush 7
    //   2628: aload_1
    //   2629: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2632: iconst_1
    //   2633: ireturn
    //   2634: aload_0
    //   2635: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2638: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2641: ldc_w 335
    //   2644: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2647: ifeq +16 -> 2663
    //   2650: aload_0
    //   2651: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2654: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2657: ldc_w 335
    //   2660: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2663: aload_0
    //   2664: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2667: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2670: bipush 41
    //   2672: iconst_2
    //   2673: invokevirtual 37	ajbm:a	(II)V
    //   2676: aload_0
    //   2677: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2680: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2683: bipush 41
    //   2685: aload_1
    //   2686: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2689: iconst_1
    //   2690: ireturn
    //   2691: aload_0
    //   2692: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2695: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2698: ldc_w 336
    //   2701: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2704: ifeq +16 -> 2720
    //   2707: aload_0
    //   2708: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2711: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2714: ldc_w 336
    //   2717: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   2720: aload_0
    //   2721: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2724: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2727: bipush 41
    //   2729: iconst_0
    //   2730: invokevirtual 37	ajbm:a	(II)V
    //   2733: aload_0
    //   2734: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2737: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2740: bipush 41
    //   2742: aload_1
    //   2743: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2746: iconst_1
    //   2747: ireturn
    //   2748: aload_1
    //   2749: getfield 274	android/os/Message:arg1	I
    //   2752: istore_2
    //   2753: aload_0
    //   2754: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2757: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2760: bipush 8
    //   2762: iload_2
    //   2763: invokevirtual 37	ajbm:a	(II)V
    //   2766: aload_0
    //   2767: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2770: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2773: bipush 8
    //   2775: aload_1
    //   2776: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2779: iconst_1
    //   2780: ireturn
    //   2781: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2784: ifeq +12 -> 2796
    //   2787: ldc 56
    //   2789: iconst_2
    //   2790: ldc_w 338
    //   2793: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2796: aload_0
    //   2797: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2800: aload_1
    //   2801: iconst_0
    //   2802: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2805: iconst_1
    //   2806: ireturn
    //   2807: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2810: ifeq +12 -> 2822
    //   2813: ldc 56
    //   2815: iconst_2
    //   2816: ldc_w 340
    //   2819: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2822: aload_0
    //   2823: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2826: aload_1
    //   2827: iconst_1
    //   2828: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2831: iconst_1
    //   2832: ireturn
    //   2833: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2836: ifeq +12 -> 2848
    //   2839: ldc 56
    //   2841: iconst_2
    //   2842: ldc_w 342
    //   2845: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2848: aload_0
    //   2849: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2852: aload_1
    //   2853: iconst_1
    //   2854: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2857: iconst_1
    //   2858: ireturn
    //   2859: aload_0
    //   2860: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2863: aconst_null
    //   2864: iconst_1
    //   2865: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2868: iconst_1
    //   2869: ireturn
    //   2870: aload_0
    //   2871: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2874: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2877: bipush 22
    //   2879: iconst_2
    //   2880: invokevirtual 37	ajbm:a	(II)V
    //   2883: aload_0
    //   2884: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2887: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2890: bipush 22
    //   2892: aload_1
    //   2893: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2896: iconst_1
    //   2897: ireturn
    //   2898: aload_0
    //   2899: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2902: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2905: bipush 22
    //   2907: iconst_0
    //   2908: invokevirtual 37	ajbm:a	(II)V
    //   2911: aload_0
    //   2912: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2915: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2918: bipush 22
    //   2920: aload_1
    //   2921: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2924: iconst_1
    //   2925: ireturn
    //   2926: aload_0
    //   2927: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2930: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2933: bipush 6
    //   2935: iconst_2
    //   2936: invokevirtual 37	ajbm:a	(II)V
    //   2939: aload_0
    //   2940: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2943: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2946: bipush 6
    //   2948: aload_1
    //   2949: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2952: iconst_1
    //   2953: ireturn
    //   2954: aload_0
    //   2955: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2958: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2961: bipush 6
    //   2963: iconst_0
    //   2964: invokevirtual 37	ajbm:a	(II)V
    //   2967: aload_0
    //   2968: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2971: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   2974: bipush 6
    //   2976: aload_1
    //   2977: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   2980: iconst_1
    //   2981: ireturn
    //   2982: aload_0
    //   2983: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2986: lconst_0
    //   2987: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   2990: iconst_1
    //   2991: ireturn
    //   2992: aload_0
    //   2993: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2996: iconst_0
    //   2997: putfield 345	com/tencent/mobileqq/activity/Conversation:g	Z
    //   3000: aload_0
    //   3001: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3004: invokestatic 348	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3007: ifnull +13 -> 3020
    //   3010: aload_0
    //   3011: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3014: invokestatic 348	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3017: invokevirtual 353	com/tencent/mobileqq/fpsreport/FPSSwipListView:springBackOverScrollHeaderView	()V
    //   3020: aload_0
    //   3021: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3024: getfield 356	com/tencent/mobileqq/activity/Conversation:c	J
    //   3027: lconst_0
    //   3028: lcmp
    //   3029: ifle +20 -> 3049
    //   3032: ldc_w 358
    //   3035: invokestatic 363	android/os/SystemClock:uptimeMillis	()J
    //   3038: aload_0
    //   3039: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3042: getfield 356	com/tencent/mobileqq/activity/Conversation:c	J
    //   3045: lsub
    //   3046: invokestatic 368	bdjd:a	(Ljava/lang/String;J)V
    //   3049: aload_0
    //   3050: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3053: lconst_0
    //   3054: putfield 356	com/tencent/mobileqq/activity/Conversation:c	J
    //   3057: iconst_1
    //   3058: ireturn
    //   3059: aload_0
    //   3060: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3063: lconst_0
    //   3064: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   3067: iconst_1
    //   3068: ireturn
    //   3069: aload_0
    //   3070: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3073: invokevirtual 369	com/tencent/mobileqq/activity/Conversation:s	()V
    //   3076: iconst_1
    //   3077: ireturn
    //   3078: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   3081: aload_0
    //   3082: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3085: getfield 377	com/tencent/mobileqq/activity/Conversation:e	J
    //   3088: lsub
    //   3089: invokestatic 383	java/lang/Math:abs	(J)J
    //   3092: lstore 5
    //   3094: invokestatic 386	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3097: ifeq +49 -> 3146
    //   3100: ldc 56
    //   3102: iconst_4
    //   3103: new 388	java/lang/StringBuilder
    //   3106: dup
    //   3107: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   3110: ldc_w 391
    //   3113: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3116: aload_1
    //   3117: getfield 274	android/os/Message:arg1	I
    //   3120: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3123: ldc_w 400
    //   3126: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3129: lload 5
    //   3131: invokevirtual 403	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3134: ldc_w 405
    //   3137: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3140: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3143: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3146: lload 5
    //   3148: lconst_0
    //   3149: lcmp
    //   3150: ifge +1538 -> 4688
    //   3153: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3156: ifeq +52 -> 3208
    //   3159: ldc 56
    //   3161: iconst_2
    //   3162: new 388	java/lang/StringBuilder
    //   3165: dup
    //   3166: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   3169: ldc_w 411
    //   3172: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3175: lload 5
    //   3177: invokevirtual 403	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3180: ldc_w 400
    //   3183: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3186: aload_0
    //   3187: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3190: getfield 377	com/tencent/mobileqq/activity/Conversation:e	J
    //   3193: invokevirtual 403	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3196: ldc_w 405
    //   3199: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3202: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3205: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3208: aload_0
    //   3209: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3212: getfield 413	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   3215: lconst_1
    //   3216: ladd
    //   3217: lstore 5
    //   3219: aload_1
    //   3220: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3223: checkcast 415	java/util/List
    //   3226: astore 10
    //   3228: aload_1
    //   3229: getfield 418	android/os/Message:arg2	I
    //   3232: iconst_1
    //   3233: if_icmpeq +85 -> 3318
    //   3236: lload 5
    //   3238: aload_0
    //   3239: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3242: getfield 413	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   3245: lcmp
    //   3246: ifge +72 -> 3318
    //   3249: aload_0
    //   3250: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3253: aload 10
    //   3255: putfield 421	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3258: invokestatic 425	android/os/Message:obtain	()Landroid/os/Message;
    //   3261: astore_1
    //   3262: aload_1
    //   3263: sipush 10000
    //   3266: putfield 26	android/os/Message:what	I
    //   3269: aload_1
    //   3270: aload_0
    //   3271: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3274: getfield 421	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3277: putfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3280: aload_1
    //   3281: iconst_0
    //   3282: putfield 274	android/os/Message:arg1	I
    //   3285: aload_1
    //   3286: iconst_1
    //   3287: putfield 418	android/os/Message:arg2	I
    //   3290: aload_0
    //   3291: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3294: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3297: aload_1
    //   3298: aload_0
    //   3299: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3302: getfield 413	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   3305: lload 5
    //   3307: lsub
    //   3308: ldc2_w 426
    //   3311: ladd
    //   3312: invokevirtual 431	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   3315: pop
    //   3316: iconst_1
    //   3317: ireturn
    //   3318: aload_1
    //   3319: getfield 418	android/os/Message:arg2	I
    //   3322: iconst_1
    //   3323: if_icmpne +53 -> 3376
    //   3326: aload 10
    //   3328: aload_0
    //   3329: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3332: getfield 421	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3335: if_acmpne +36 -> 3371
    //   3338: iconst_1
    //   3339: istore_2
    //   3340: iload_2
    //   3341: ifeq -3290 -> 51
    //   3344: aload_0
    //   3345: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3348: iconst_0
    //   3349: aload_0
    //   3350: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3353: getfield 421	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3356: invokevirtual 434	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   3359: aload_0
    //   3360: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3363: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   3366: putfield 377	com/tencent/mobileqq/activity/Conversation:e	J
    //   3369: iconst_1
    //   3370: ireturn
    //   3371: iconst_0
    //   3372: istore_2
    //   3373: goto -33 -> 3340
    //   3376: aload_0
    //   3377: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3380: aload 10
    //   3382: putfield 421	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3385: iconst_1
    //   3386: istore_2
    //   3387: goto -47 -> 3340
    //   3390: aload_1
    //   3391: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3394: checkcast 415	java/util/List
    //   3397: astore_1
    //   3398: aload_0
    //   3399: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3402: iconst_1
    //   3403: aload_1
    //   3404: invokevirtual 434	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   3407: iconst_1
    //   3408: ireturn
    //   3409: aload_0
    //   3410: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3413: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3416: ifnull -3365 -> 51
    //   3419: aload_0
    //   3420: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3423: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3426: iconst_1
    //   3427: iconst_0
    //   3428: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	(ZI)V
    //   3431: iconst_1
    //   3432: ireturn
    //   3433: aload_0
    //   3434: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3437: invokestatic 439	com/tencent/mobileqq/activity/Conversation:c	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   3440: iconst_1
    //   3441: ireturn
    //   3442: aload_0
    //   3443: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3446: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3449: astore 10
    //   3451: iload_3
    //   3452: istore_2
    //   3453: aload_0
    //   3454: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3457: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3460: invokevirtual 442	com/tencent/mobileqq/app/QQAppInterface:a	()Lbioj;
    //   3463: invokevirtual 447	bioj:a	()I
    //   3466: ifeq +5 -> 3471
    //   3469: iconst_2
    //   3470: istore_2
    //   3471: aload 10
    //   3473: bipush 38
    //   3475: iload_2
    //   3476: invokevirtual 37	ajbm:a	(II)V
    //   3479: aload_0
    //   3480: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3483: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3486: bipush 38
    //   3488: aload_1
    //   3489: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   3492: iconst_1
    //   3493: ireturn
    //   3494: aload_0
    //   3495: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3498: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3501: astore 10
    //   3503: invokestatic 452	ardf:a	()Lardf;
    //   3506: invokevirtual 454	ardf:a	()Z
    //   3509: ifeq +26 -> 3535
    //   3512: aload 10
    //   3514: bipush 39
    //   3516: iload_2
    //   3517: invokevirtual 37	ajbm:a	(II)V
    //   3520: aload_0
    //   3521: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3524: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3527: bipush 39
    //   3529: aload_1
    //   3530: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   3533: iconst_1
    //   3534: ireturn
    //   3535: iconst_0
    //   3536: istore_2
    //   3537: goto -25 -> 3512
    //   3540: aload_0
    //   3541: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3544: invokevirtual 457	com/tencent/mobileqq/activity/Conversation:x	()V
    //   3547: iconst_1
    //   3548: ireturn
    //   3549: aload_0
    //   3550: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3553: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3556: bipush 24
    //   3558: iconst_2
    //   3559: invokevirtual 37	ajbm:a	(II)V
    //   3562: aload_0
    //   3563: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3566: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3569: bipush 24
    //   3571: aload_1
    //   3572: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   3575: iconst_1
    //   3576: ireturn
    //   3577: aload_0
    //   3578: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3581: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3584: bipush 24
    //   3586: iconst_0
    //   3587: invokevirtual 37	ajbm:a	(II)V
    //   3590: aload_0
    //   3591: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3594: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3597: bipush 24
    //   3599: aload_1
    //   3600: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   3603: iconst_1
    //   3604: ireturn
    //   3605: aload_0
    //   3606: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3609: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3612: bipush 25
    //   3614: iconst_2
    //   3615: invokevirtual 37	ajbm:a	(II)V
    //   3618: aload_0
    //   3619: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3622: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3625: bipush 25
    //   3627: aload_1
    //   3628: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   3631: iconst_1
    //   3632: ireturn
    //   3633: aload_0
    //   3634: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3637: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3640: bipush 25
    //   3642: iconst_0
    //   3643: invokevirtual 37	ajbm:a	(II)V
    //   3646: aload_0
    //   3647: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3650: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3653: bipush 25
    //   3655: aload_1
    //   3656: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   3659: iconst_1
    //   3660: ireturn
    //   3661: aload_0
    //   3662: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3665: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3668: iconst_5
    //   3669: aload_1
    //   3670: getfield 274	android/os/Message:arg1	I
    //   3673: invokevirtual 37	ajbm:a	(II)V
    //   3676: aload_0
    //   3677: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3680: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3683: iconst_5
    //   3684: aload_1
    //   3685: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   3688: iconst_1
    //   3689: ireturn
    //   3690: aload_0
    //   3691: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3694: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajee	Lajee;
    //   3697: ifnull -3646 -> 51
    //   3700: aload_0
    //   3701: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3704: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajee	Lajee;
    //   3707: invokevirtual 463	ajee:a	()V
    //   3710: iconst_1
    //   3711: ireturn
    //   3712: aload_0
    //   3713: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3716: getfield 466	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3719: ifnull -3668 -> 51
    //   3722: aload_1
    //   3723: getfield 274	android/os/Message:arg1	I
    //   3726: iconst_1
    //   3727: if_icmpne +38 -> 3765
    //   3730: iconst_1
    //   3731: istore_2
    //   3732: iload_2
    //   3733: ifeq +37 -> 3770
    //   3736: new 468	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   3739: dup
    //   3740: invokespecial 469	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   3743: astore_1
    //   3744: aload_1
    //   3745: getfield 473	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3748: iconst_0
    //   3749: invokevirtual 478	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3752: aload_0
    //   3753: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3756: getfield 466	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3759: aload_1
    //   3760: invokevirtual 483	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;)V
    //   3763: iconst_1
    //   3764: ireturn
    //   3765: iconst_0
    //   3766: istore_2
    //   3767: goto -35 -> 3732
    //   3770: aload_0
    //   3771: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3774: getfield 466	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3777: new 485	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   3780: dup
    //   3781: invokespecial 486	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   3784: invokevirtual 489	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   3787: iconst_1
    //   3788: ireturn
    //   3789: aload_0
    //   3790: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3793: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3796: astore 10
    //   3798: aload_1
    //   3799: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   3802: ifnonnull +27 -> 3829
    //   3805: iload 4
    //   3807: istore_2
    //   3808: aload 10
    //   3810: iconst_3
    //   3811: iload_2
    //   3812: invokevirtual 37	ajbm:a	(II)V
    //   3815: aload_0
    //   3816: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3819: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   3822: iconst_3
    //   3823: aload_1
    //   3824: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   3827: iconst_1
    //   3828: ireturn
    //   3829: iconst_2
    //   3830: istore_2
    //   3831: goto -23 -> 3808
    //   3834: aload_0
    //   3835: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3838: invokestatic 77	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   3841: iconst_1
    //   3842: ireturn
    //   3843: aload_0
    //   3844: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3847: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3850: bipush 10
    //   3852: invokevirtual 492	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   3855: checkcast 494	alxb
    //   3858: invokevirtual 496	alxb:b	()V
    //   3861: iconst_1
    //   3862: ireturn
    //   3863: aload_0
    //   3864: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3867: getfield 499	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   3870: getfield 502	com/tencent/mobileqq/app/FrameHelperActivity:a	Landroid/widget/ImageView;
    //   3873: astore_1
    //   3874: aload_0
    //   3875: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3878: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3881: sipush 250
    //   3884: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3887: checkcast 504	com/tencent/mobileqq/medalwall/MedalWallMng
    //   3890: aload_0
    //   3891: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3894: invokevirtual 507	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   3897: aload_1
    //   3898: iconst_1
    //   3899: aconst_null
    //   3900: invokevirtual 510	com/tencent/mobileqq/medalwall/MedalWallMng:a	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/view/View;ILjava/lang/Object;)Z
    //   3903: istore 9
    //   3905: invokestatic 386	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3908: ifeq -3857 -> 51
    //   3911: ldc_w 512
    //   3914: iconst_4
    //   3915: invokestatic 518	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   3918: ldc_w 520
    //   3921: iconst_1
    //   3922: anewarray 4	java/lang/Object
    //   3925: dup
    //   3926: iconst_0
    //   3927: iload 9
    //   3929: invokestatic 526	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3932: aastore
    //   3933: invokestatic 530	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3936: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3939: iconst_1
    //   3940: ireturn
    //   3941: ldc 56
    //   3943: ldc_w 532
    //   3946: invokestatic 537	wsv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3949: aload_0
    //   3950: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3953: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3956: ifnull +20 -> 3976
    //   3959: aload_0
    //   3960: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3963: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3966: sipush 181
    //   3969: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3972: checkcast 539	uhl
    //   3975: astore_1
    //   3976: new 541	com/tencent/mobileqq/activity/Conversation$1$7
    //   3979: dup
    //   3980: aload_0
    //   3981: invokespecial 542	com/tencent/mobileqq/activity/Conversation$1$7:<init>	(Lacms;)V
    //   3984: bipush 8
    //   3986: aconst_null
    //   3987: iconst_1
    //   3988: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   3991: iconst_1
    //   3992: ireturn
    //   3993: aload_0
    //   3994: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3997: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   4000: invokevirtual 544	ajbm:a	()Lmqq/os/MqqHandler;
    //   4003: astore 10
    //   4005: aload 10
    //   4007: ifnull -3956 -> 51
    //   4010: aload 10
    //   4012: sipush 200
    //   4015: invokevirtual 548	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   4018: astore 11
    //   4020: aload 11
    //   4022: aload_1
    //   4023: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4026: putfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4029: aload 10
    //   4031: aload 11
    //   4033: invokevirtual 551	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   4036: pop
    //   4037: iconst_1
    //   4038: ireturn
    //   4039: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4042: ifeq +30 -> 4072
    //   4045: ldc_w 553
    //   4048: iconst_2
    //   4049: new 388	java/lang/StringBuilder
    //   4052: dup
    //   4053: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   4056: ldc_w 555
    //   4059: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4062: aload_1
    //   4063: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4066: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4069: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4072: aload_0
    //   4073: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4076: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   4079: invokevirtual 544	ajbm:a	()Lmqq/os/MqqHandler;
    //   4082: astore 10
    //   4084: aload 10
    //   4086: ifnull -4035 -> 51
    //   4089: aload 10
    //   4091: sipush 201
    //   4094: invokevirtual 548	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   4097: astore 11
    //   4099: aload 11
    //   4101: aload_1
    //   4102: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4105: putfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4108: aload 10
    //   4110: aload 11
    //   4112: invokevirtual 551	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   4115: pop
    //   4116: iconst_1
    //   4117: ireturn
    //   4118: invokestatic 563	com/tencent/mobileqq/theme/ThemeUtil:isDefaultTheme	()Z
    //   4121: ifne +38 -> 4159
    //   4124: iconst_0
    //   4125: invokestatic 567	com/tencent/mobileqq/theme/ThemeUtil:isSimpleDayTheme	(Z)Z
    //   4128: ifne +31 -> 4159
    //   4131: aload_0
    //   4132: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4135: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4138: sipush 1069
    //   4141: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4144: aload_0
    //   4145: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4148: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4151: sipush 1068
    //   4154: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4157: iconst_1
    //   4158: ireturn
    //   4159: aload_0
    //   4160: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4163: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4166: sipush 1068
    //   4169: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   4172: ifeq +16 -> 4188
    //   4175: aload_0
    //   4176: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4179: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4182: sipush 1068
    //   4185: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4188: aload_0
    //   4189: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4192: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   4195: iconst_0
    //   4196: invokevirtual 569	ajbm:d	(Z)V
    //   4199: aload_0
    //   4200: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4203: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   4206: invokevirtual 544	ajbm:a	()Lmqq/os/MqqHandler;
    //   4209: ifnull -4158 -> 51
    //   4212: aload_0
    //   4213: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4216: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   4219: iconst_m1
    //   4220: aconst_null
    //   4221: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   4224: iconst_1
    //   4225: ireturn
    //   4226: invokestatic 563	com/tencent/mobileqq/theme/ThemeUtil:isDefaultTheme	()Z
    //   4229: ifne +38 -> 4267
    //   4232: iconst_0
    //   4233: invokestatic 567	com/tencent/mobileqq/theme/ThemeUtil:isSimpleDayTheme	(Z)Z
    //   4236: ifne +31 -> 4267
    //   4239: aload_0
    //   4240: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4243: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4246: sipush 1069
    //   4249: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4252: aload_0
    //   4253: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4256: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4259: sipush 1068
    //   4262: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4265: iconst_1
    //   4266: ireturn
    //   4267: aload_0
    //   4268: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4271: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4274: sipush 1069
    //   4277: invokevirtual 282	mqq/os/MqqHandler:hasMessages	(I)Z
    //   4280: ifeq +16 -> 4296
    //   4283: aload_0
    //   4284: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4287: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4290: sipush 1069
    //   4293: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4296: aload_0
    //   4297: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4300: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   4303: iconst_1
    //   4304: invokevirtual 569	ajbm:d	(Z)V
    //   4307: aload_0
    //   4308: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4311: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   4314: invokevirtual 544	ajbm:a	()Lmqq/os/MqqHandler;
    //   4317: ifnull -4266 -> 51
    //   4320: aload_0
    //   4321: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4324: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   4327: iconst_m1
    //   4328: aconst_null
    //   4329: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   4332: iconst_1
    //   4333: ireturn
    //   4334: aload_0
    //   4335: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4338: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4341: sipush 1070
    //   4344: invokevirtual 285	mqq/os/MqqHandler:removeMessages	(I)V
    //   4347: aload_0
    //   4348: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4351: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4354: bipush 36
    //   4356: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4359: checkcast 571	axho
    //   4362: invokevirtual 572	axho:b	()V
    //   4365: iconst_1
    //   4366: ireturn
    //   4367: aload_0
    //   4368: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4371: getfield 574	com/tencent/mobileqq/activity/Conversation:f	Z
    //   4374: ifeq -4323 -> 51
    //   4377: aload_0
    //   4378: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4381: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4384: ldc_w 575
    //   4387: getstatic 579	azmg:a	I
    //   4390: sipush 1000
    //   4393: imul
    //   4394: i2l
    //   4395: invokevirtual 583	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   4398: pop
    //   4399: iconst_1
    //   4400: ireturn
    //   4401: aload_0
    //   4402: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4405: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4408: invokestatic 586	azmg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   4411: iconst_1
    //   4412: ireturn
    //   4413: aload_1
    //   4414: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4417: instanceof 588
    //   4420: ifeq -4369 -> 51
    //   4423: aload_0
    //   4424: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4427: getfield 591	com/tencent/mobileqq/activity/Conversation:h	Z
    //   4430: ifne -4379 -> 51
    //   4433: aload_1
    //   4434: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4437: checkcast 588	[Ljava/lang/String;
    //   4440: checkcast 588	[Ljava/lang/String;
    //   4443: astore 11
    //   4445: aload 11
    //   4447: arraylength
    //   4448: iconst_3
    //   4449: if_icmpne -4398 -> 51
    //   4452: aload 11
    //   4454: iconst_0
    //   4455: aaload
    //   4456: astore_1
    //   4457: aload 11
    //   4459: iconst_1
    //   4460: aaload
    //   4461: astore 10
    //   4463: aload 11
    //   4465: iconst_2
    //   4466: aaload
    //   4467: astore 11
    //   4469: new 593	acom
    //   4472: dup
    //   4473: aload_0
    //   4474: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4477: aload_1
    //   4478: aload 10
    //   4480: aload 11
    //   4482: invokespecial 596	acom:<init>	(Lcom/tencent/mobileqq/activity/Conversation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4485: invokevirtual 597	acom:a	()V
    //   4488: iconst_1
    //   4489: ireturn
    //   4490: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4493: ifeq +32 -> 4525
    //   4496: ldc 56
    //   4498: iconst_2
    //   4499: new 388	java/lang/StringBuilder
    //   4502: dup
    //   4503: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   4506: ldc_w 599
    //   4509: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4512: aload_1
    //   4513: getfield 81	android/os/Message:obj	Ljava/lang/Object;
    //   4516: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4519: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4522: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4525: aload_0
    //   4526: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4529: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   4532: iconst_2
    //   4533: iconst_2
    //   4534: invokevirtual 37	ajbm:a	(II)V
    //   4537: aload_0
    //   4538: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4541: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   4544: iconst_2
    //   4545: aload_1
    //   4546: invokevirtual 74	ajbm:a	(ILandroid/os/Message;)V
    //   4549: iconst_1
    //   4550: ireturn
    //   4551: aload_0
    //   4552: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4555: iconst_1
    //   4556: invokestatic 602	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;I)V
    //   4559: iconst_1
    //   4560: ireturn
    //   4561: aload_0
    //   4562: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4565: ldc_w 603
    //   4568: invokevirtual 605	com/tencent/mobileqq/activity/Conversation:a	(I)Landroid/view/View;
    //   4571: checkcast 607	android/widget/TextView
    //   4574: invokestatic 612	gj:a	(Landroid/widget/TextView;)V
    //   4577: iconst_1
    //   4578: ireturn
    //   4579: aload_0
    //   4580: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4583: ldc_w 603
    //   4586: invokevirtual 605	com/tencent/mobileqq/activity/Conversation:a	(I)Landroid/view/View;
    //   4589: bipush 8
    //   4591: invokevirtual 117	android/view/View:setVisibility	(I)V
    //   4594: iconst_1
    //   4595: ireturn
    //   4596: new 614	com/tencent/mobileqq/activity/Conversation$1$8
    //   4599: dup
    //   4600: aload_0
    //   4601: invokespecial 615	com/tencent/mobileqq/activity/Conversation$1$8:<init>	(Lacms;)V
    //   4604: invokestatic 616	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   4607: iconst_1
    //   4608: ireturn
    //   4609: aload_0
    //   4610: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4613: invokestatic 618	com/tencent/mobileqq/activity/Conversation:d	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   4616: iconst_1
    //   4617: ireturn
    //   4618: invokestatic 622	aokd:g	()Z
    //   4621: ifeq +58 -> 4679
    //   4624: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4627: ifeq +12 -> 4639
    //   4630: ldc 56
    //   4632: iconst_2
    //   4633: ldc_w 624
    //   4636: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4639: aload_0
    //   4640: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4643: iconst_1
    //   4644: invokestatic 627	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)Z
    //   4647: pop
    //   4648: aload_0
    //   4649: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4652: invokestatic 630	android/os/SystemClock:elapsedRealtime	()J
    //   4655: invokestatic 633	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;J)J
    //   4658: pop2
    //   4659: aload_0
    //   4660: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4663: invokestatic 348	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   4666: iconst_0
    //   4667: invokevirtual 636	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   4670: aload_0
    //   4671: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4674: invokestatic 638	com/tencent/mobileqq/activity/Conversation:e	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   4677: iconst_1
    //   4678: ireturn
    //   4679: aload_0
    //   4680: getfield 12	acms:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4683: invokestatic 640	com/tencent/mobileqq/activity/Conversation:f	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   4686: iconst_1
    //   4687: ireturn
    //   4688: goto -1469 -> 3219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4691	0	this	acms
    //   0	4691	1	paramMessage	android.os.Message
    //   1	3830	2	i	int
    //   6	3446	3	j	int
    //   3	3803	4	k	int
    //   1319	1987	5	l1	long
    //   1331	216	7	l2	long
    //   3903	25	9	bool	boolean
    //   930	540	10	localObject1	Object
    //   1650	1	10	localException	java.lang.Exception
    //   1772	2707	10	localObject2	Object
    //   1040	3441	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   1603	1613	1650	java/lang/Exception
    //   1603	1613	1664	finally
    //   2231	2262	2295	java/lang/Exception
    //   2262	2282	2295	java/lang/Exception
    //   2287	2293	2295	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acms
 * JD-Core Version:    0.7.0.1
 */