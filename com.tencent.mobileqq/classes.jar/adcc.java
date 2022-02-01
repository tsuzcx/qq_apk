import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class adcc
{
  public float a;
  public int a;
  public long a;
  public abey a;
  public String a;
  public boolean a;
  public float b;
  public long b;
  private String b;
  public boolean b;
  public float c;
  public boolean c;
  public float d;
  public boolean d;
  public boolean e;
  
  /* Error */
  public adcc()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 21	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 23
    //   7: putfield 25	adcc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: aload_0
    //   11: bipush 15
    //   13: putfield 27	adcc:jdField_a_of_type_Int	I
    //   16: aload_0
    //   17: ldc2_w 28
    //   20: putfield 31	adcc:jdField_a_of_type_Long	J
    //   23: aload_0
    //   24: ldc 32
    //   26: putfield 34	adcc:jdField_b_of_type_Float	F
    //   29: aload_0
    //   30: ldc 32
    //   32: putfield 36	adcc:jdField_c_of_type_Float	F
    //   35: aload_0
    //   36: ldc 38
    //   38: putfield 40	adcc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   41: aload_0
    //   42: iconst_1
    //   43: putfield 42	adcc:jdField_d_of_type_Boolean	Z
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 44	adcc:e	Z
    //   51: aload_0
    //   52: ldc 45
    //   54: putfield 47	adcc:jdField_d_of_type_Float	F
    //   57: aload_0
    //   58: ldc2_w 48
    //   61: putfield 51	adcc:jdField_b_of_type_Long	J
    //   64: invokestatic 56	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   67: astore_1
    //   68: invokestatic 61	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   71: invokevirtual 64	com/tencent/mfsdk/MagnifierSDK:a	()Ladby;
    //   74: invokeinterface 69 1 0
    //   79: astore_2
    //   80: aload_0
    //   81: new 71	abey
    //   84: dup
    //   85: ldc 73
    //   87: invokespecial 76	abey:<init>	(Ljava/lang/String;)V
    //   90: putfield 78	adcc:jdField_a_of_type_Abey	Labey;
    //   93: aload_0
    //   94: getfield 78	adcc:jdField_a_of_type_Abey	Labey;
    //   97: iconst_1
    //   98: putfield 80	abey:jdField_a_of_type_Boolean	Z
    //   101: aload_0
    //   102: invokespecial 82	adcc:a	()V
    //   105: aload_2
    //   106: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne +12 -> 121
    //   112: aload_2
    //   113: ldc 90
    //   115: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifeq +4 -> 122
    //   121: return
    //   122: aload_2
    //   123: ldc 98
    //   125: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   128: astore_2
    //   129: aload_2
    //   130: arraylength
    //   131: iconst_1
    //   132: if_icmple +237 -> 369
    //   135: aload_2
    //   136: aload_1
    //   137: getfield 103	com/tencent/mobileqq/app/DeviceProfileManager:jdField_a_of_type_Int	I
    //   140: aload_2
    //   141: arraylength
    //   142: irem
    //   143: aaload
    //   144: astore_1
    //   145: aload_1
    //   146: ldc 105
    //   148: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   151: astore_1
    //   152: aload_1
    //   153: arraylength
    //   154: bipush 7
    //   156: if_icmplt -35 -> 121
    //   159: aload_1
    //   160: iconst_1
    //   161: aaload
    //   162: ldc 107
    //   164: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   167: astore_2
    //   168: aload_2
    //   169: iconst_0
    //   170: aaload
    //   171: ldc 109
    //   173: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifeq +46 -> 222
    //   179: aload_0
    //   180: iconst_1
    //   181: putfield 110	adcc:jdField_a_of_type_Boolean	Z
    //   184: aload_0
    //   185: aload_2
    //   186: iconst_1
    //   187: aaload
    //   188: invokestatic 116	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   191: putfield 27	adcc:jdField_a_of_type_Int	I
    //   194: aload_0
    //   195: getfield 27	adcc:jdField_a_of_type_Int	I
    //   198: bipush 50
    //   200: if_icmple +9 -> 209
    //   203: aload_0
    //   204: bipush 50
    //   206: putfield 27	adcc:jdField_a_of_type_Int	I
    //   209: aload_0
    //   210: getfield 27	adcc:jdField_a_of_type_Int	I
    //   213: iconst_1
    //   214: if_icmpge +8 -> 222
    //   217: aload_0
    //   218: iconst_1
    //   219: putfield 27	adcc:jdField_a_of_type_Int	I
    //   222: aload_0
    //   223: aload_1
    //   224: iconst_2
    //   225: aaload
    //   226: putfield 25	adcc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   229: aload_0
    //   230: aload_1
    //   231: iconst_4
    //   232: aaload
    //   233: invokestatic 122	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   236: invokevirtual 126	java/lang/Float:floatValue	()F
    //   239: putfield 128	adcc:jdField_a_of_type_Float	F
    //   242: aload_0
    //   243: getfield 128	adcc:jdField_a_of_type_Float	F
    //   246: fconst_1
    //   247: fcmpl
    //   248: ifle +8 -> 256
    //   251: aload_0
    //   252: fconst_1
    //   253: putfield 128	adcc:jdField_a_of_type_Float	F
    //   256: aload_0
    //   257: aload_1
    //   258: bipush 6
    //   260: aaload
    //   261: invokestatic 132	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   264: putfield 34	adcc:jdField_b_of_type_Float	F
    //   267: aload_1
    //   268: arraylength
    //   269: bipush 9
    //   271: if_icmplt +8 -> 279
    //   274: aload_0
    //   275: aload_1
    //   276: invokespecial 135	adcc:a	([Ljava/lang/String;)V
    //   279: aload_1
    //   280: arraylength
    //   281: bipush 10
    //   283: if_icmplt +20 -> 303
    //   286: ldc 109
    //   288: aload_1
    //   289: bipush 9
    //   291: aaload
    //   292: invokevirtual 139	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   295: ifeq +100 -> 395
    //   298: aload_0
    //   299: iconst_1
    //   300: putfield 44	adcc:e	Z
    //   303: aload_1
    //   304: arraylength
    //   305: bipush 11
    //   307: if_icmplt +39 -> 346
    //   310: aload_1
    //   311: bipush 10
    //   313: aaload
    //   314: ldc 107
    //   316: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   319: astore_2
    //   320: aload_2
    //   321: arraylength
    //   322: iconst_2
    //   323: if_icmplt +23 -> 346
    //   326: aload_0
    //   327: aload_2
    //   328: iconst_0
    //   329: aaload
    //   330: invokestatic 132	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   333: putfield 47	adcc:jdField_d_of_type_Float	F
    //   336: aload_0
    //   337: aload_2
    //   338: iconst_1
    //   339: aaload
    //   340: invokestatic 145	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   343: putfield 51	adcc:jdField_b_of_type_Long	J
    //   346: aload_0
    //   347: aload_1
    //   348: invokespecial 147	adcc:b	([Ljava/lang/String;)V
    //   351: return
    //   352: astore_1
    //   353: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -235 -> 121
    //   359: ldc 155
    //   361: iconst_2
    //   362: ldc 157
    //   364: aload_1
    //   365: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   368: return
    //   369: aload_2
    //   370: iconst_0
    //   371: aaload
    //   372: astore_1
    //   373: goto -228 -> 145
    //   376: astore_2
    //   377: aload_0
    //   378: fconst_0
    //   379: putfield 128	adcc:jdField_a_of_type_Float	F
    //   382: goto -126 -> 256
    //   385: astore_2
    //   386: aload_0
    //   387: ldc 161
    //   389: putfield 34	adcc:jdField_b_of_type_Float	F
    //   392: goto -125 -> 267
    //   395: aload_0
    //   396: iconst_0
    //   397: putfield 44	adcc:e	Z
    //   400: goto -97 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	adcc
    //   67	281	1	localObject1	Object
    //   352	13	1	localException1	Exception
    //   372	1	1	localObject2	Object
    //   79	291	2	localObject3	Object
    //   376	1	2	localException2	Exception
    //   385	1	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   145	209	352	java/lang/Exception
    //   209	222	352	java/lang/Exception
    //   222	229	352	java/lang/Exception
    //   267	279	352	java/lang/Exception
    //   279	303	352	java/lang/Exception
    //   303	346	352	java/lang/Exception
    //   346	351	352	java/lang/Exception
    //   377	382	352	java/lang/Exception
    //   386	392	352	java/lang/Exception
    //   395	400	352	java/lang/Exception
    //   229	256	376	java/lang/Exception
    //   256	267	385	java/lang/Exception
  }
  
  private void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 4);
    int j = ((SharedPreferences)localObject).getInt(this.jdField_b_of_type_JavaLangString, -1);
    int i = j;
    if (j == -1)
    {
      i = new Random().nextInt(1000);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(this.jdField_b_of_type_JavaLangString, i);
      if (Build.VERSION.SDK_INT < 9) {
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    else
    {
      this.jdField_b_of_type_Boolean = false;
      if (i % 2 == 0) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (0.001F < Math.random()) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      ((SharedPreferences.Editor)localObject).apply();
      break;
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        paramArrayOfString = paramArrayOfString[8].split(";");
        if (paramArrayOfString.length < 5) {
          break;
        }
        if (this.jdField_a_of_type_Abey == null)
        {
          this.jdField_a_of_type_Abey = new abey(this.jdField_a_of_type_JavaLangString);
          if (paramArrayOfString[0].equals("1"))
          {
            this.jdField_a_of_type_Abey.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_Abey.b = Integer.parseInt(paramArrayOfString[1]);
            Object localObject = paramArrayOfString[2].split(",");
            if (localObject.length >= 4)
            {
              localObject = new abez(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Float.parseFloat(localObject[2]), Float.parseFloat(localObject[3]));
              this.jdField_a_of_type_Abey.jdField_a_of_type_AndroidUtilSparseArray.put(1, localObject);
            }
            localObject = paramArrayOfString[3].split(",");
            if (localObject.length >= 4)
            {
              localObject = new abez(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Float.parseFloat(localObject[2]), Float.parseFloat(localObject[3]));
              this.jdField_a_of_type_Abey.jdField_a_of_type_AndroidUtilSparseArray.put(2, localObject);
            }
            paramArrayOfString = paramArrayOfString[4].split(",");
            if (paramArrayOfString.length >= 4)
            {
              paramArrayOfString = new abez(Integer.parseInt(paramArrayOfString[0]), Integer.parseInt(paramArrayOfString[1]), Float.parseFloat(paramArrayOfString[2]), Float.parseFloat(paramArrayOfString[3]));
              this.jdField_a_of_type_Abey.jdField_a_of_type_AndroidUtilSparseArray.put(3, paramArrayOfString);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.Memory.MemoryConfigs", 2, "mClearMemoryConfig= " + this.jdField_a_of_type_Abey);
          }
        }
        else
        {
          this.jdField_a_of_type_Abey.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          continue;
        }
        if (!paramArrayOfString[0].equals("0")) {
          break label324;
        }
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
      this.jdField_a_of_type_Abey.jdField_a_of_type_Boolean = false;
      continue;
      label324:
      if (BaseApplicationImpl.sProcessId == 1) {
        this.jdField_a_of_type_Abey.jdField_a_of_type_Boolean = true;
      } else if (paramArrayOfString[0].equals("3")) {
        this.jdField_a_of_type_Abey.jdField_a_of_type_Boolean = true;
      } else if (paramArrayOfString[0].equals("4")) {
        this.jdField_a_of_type_Abey.jdField_a_of_type_Boolean = false;
      } else {
        this.jdField_a_of_type_Abey.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length >= 12) {
      if (!"1".equalsIgnoreCase(paramArrayOfString[11])) {
        break label44;
      }
    }
    label44:
    for (this.jdField_d_of_type_Boolean = true; this.e; this.jdField_d_of_type_Boolean = false)
    {
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcc
 * JD-Core Version:    0.7.0.1
 */