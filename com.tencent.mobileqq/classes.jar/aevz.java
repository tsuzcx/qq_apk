import java.util.ArrayList;

public class aevz
{
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public aevz()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
  }
  
  /* Error */
  public static aevz a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 14	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 15	java/util/ArrayList:<init>	()V
    //   16: astore 5
    //   18: new 31	org/json/JSONObject
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 34	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   26: astore_0
    //   27: aload_0
    //   28: ldc 36
    //   30: iconst_0
    //   31: invokevirtual 40	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   34: istore_1
    //   35: aload_0
    //   36: ldc 42
    //   38: invokevirtual 46	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   41: astore_0
    //   42: iload_1
    //   43: istore_3
    //   44: aload_0
    //   45: ifnull +54 -> 99
    //   48: iload_1
    //   49: istore_3
    //   50: aload_0
    //   51: invokevirtual 52	org/json/JSONArray:length	()I
    //   54: ifle +45 -> 99
    //   57: iconst_0
    //   58: istore_2
    //   59: iload_1
    //   60: istore_3
    //   61: iload_2
    //   62: aload_0
    //   63: invokevirtual 52	org/json/JSONArray:length	()I
    //   66: if_icmpge +33 -> 99
    //   69: aload 5
    //   71: aload_0
    //   72: iload_2
    //   73: invokevirtual 56	org/json/JSONArray:getInt	(I)I
    //   76: invokestatic 62	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 66	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: iload_2
    //   84: iconst_1
    //   85: iadd
    //   86: istore_2
    //   87: goto -28 -> 59
    //   90: astore_0
    //   91: iconst_0
    //   92: istore_1
    //   93: aload_0
    //   94: invokevirtual 69	org/json/JSONException:printStackTrace	()V
    //   97: iload_1
    //   98: istore_3
    //   99: new 2	aevz
    //   102: dup
    //   103: invokespecial 70	aevz:<init>	()V
    //   106: astore_0
    //   107: iload_3
    //   108: iconst_1
    //   109: if_icmpne +20 -> 129
    //   112: iconst_1
    //   113: istore 4
    //   115: aload_0
    //   116: iload 4
    //   118: putfield 19	aevz:jdField_a_of_type_Boolean	Z
    //   121: aload_0
    //   122: aload 5
    //   124: putfield 17	aevz:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   127: aload_0
    //   128: areturn
    //   129: iconst_0
    //   130: istore 4
    //   132: goto -17 -> 115
    //   135: astore_0
    //   136: goto -43 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   34	64	1	i	int
    //   58	29	2	j	int
    //   43	67	3	k	int
    //   113	18	4	bool	boolean
    //   16	107	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   18	35	90	org/json/JSONException
    //   35	42	135	org/json/JSONException
    //   50	57	135	org/json/JSONException
    //   61	83	135	org/json/JSONException
  }
  
  public boolean a(String paramString)
  {
    if (paramString.isEmpty()) {}
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        paramString = paramString.substring(paramString.length() - 1);
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(paramString)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevz
 * JD-Core Version:    0.7.0.1
 */