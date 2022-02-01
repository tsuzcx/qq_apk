public class akpv
  extends akpu
{
  private static final byte[] a;
  private static final byte[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = "WEBP".getBytes();
    jdField_b_of_type_ArrayOfByte = "RIFF".getBytes();
  }
  
  public akpv(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_JavaLangString = "PhotoIncompatibleWebp";
    this.jdField_b_of_type_JavaLangString = "reportGenerateWebp";
  }
  
  /* Error */
  static boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: bipush 16
    //   5: newarray byte
    //   7: astore 7
    //   9: new 44	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 45	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 6
    //   21: astore_0
    //   22: aload 6
    //   24: aload 7
    //   26: invokevirtual 49	java/io/FileInputStream:read	([B)I
    //   29: pop
    //   30: aload 6
    //   32: astore_0
    //   33: aload 7
    //   35: arraylength
    //   36: istore_1
    //   37: iload_1
    //   38: bipush 12
    //   40: if_icmpge +31 -> 71
    //   43: iload 5
    //   45: istore 4
    //   47: aload 6
    //   49: ifnull +12 -> 61
    //   52: aload 6
    //   54: invokevirtual 52	java/io/FileInputStream:close	()V
    //   57: iload 5
    //   59: istore 4
    //   61: iload 4
    //   63: ireturn
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   69: iconst_0
    //   70: ireturn
    //   71: iconst_0
    //   72: istore_1
    //   73: aload 6
    //   75: astore_0
    //   76: iload_1
    //   77: getstatic 23	akpv:jdField_b_of_type_ArrayOfByte	[B
    //   80: arraylength
    //   81: if_icmpge +52 -> 133
    //   84: aload 6
    //   86: astore_0
    //   87: getstatic 23	akpv:jdField_b_of_type_ArrayOfByte	[B
    //   90: iload_1
    //   91: baload
    //   92: istore_2
    //   93: aload 7
    //   95: iload_1
    //   96: baload
    //   97: istore_3
    //   98: iload_2
    //   99: iload_3
    //   100: if_icmpeq +26 -> 126
    //   103: iload 5
    //   105: istore 4
    //   107: aload 6
    //   109: ifnull -48 -> 61
    //   112: aload 6
    //   114: invokevirtual 52	java/io/FileInputStream:close	()V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   124: iconst_0
    //   125: ireturn
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_1
    //   130: goto -57 -> 73
    //   133: bipush 8
    //   135: istore_1
    //   136: iload_1
    //   137: bipush 12
    //   139: if_icmpge +55 -> 194
    //   142: aload 6
    //   144: astore_0
    //   145: getstatic 19	akpv:jdField_a_of_type_ArrayOfByte	[B
    //   148: iload_1
    //   149: bipush 8
    //   151: isub
    //   152: baload
    //   153: istore_2
    //   154: aload 7
    //   156: iload_1
    //   157: baload
    //   158: istore_3
    //   159: iload_2
    //   160: iload_3
    //   161: if_icmpeq +26 -> 187
    //   164: iload 5
    //   166: istore 4
    //   168: aload 6
    //   170: ifnull -109 -> 61
    //   173: aload 6
    //   175: invokevirtual 52	java/io/FileInputStream:close	()V
    //   178: iconst_0
    //   179: ireturn
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   185: iconst_0
    //   186: ireturn
    //   187: iload_1
    //   188: iconst_1
    //   189: iadd
    //   190: istore_1
    //   191: goto -55 -> 136
    //   194: iconst_1
    //   195: istore 4
    //   197: aload 6
    //   199: ifnull -138 -> 61
    //   202: aload 6
    //   204: invokevirtual 52	java/io/FileInputStream:close	()V
    //   207: iconst_1
    //   208: ireturn
    //   209: astore_0
    //   210: aload_0
    //   211: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   214: iconst_1
    //   215: ireturn
    //   216: astore 7
    //   218: aconst_null
    //   219: astore 6
    //   221: aload 6
    //   223: astore_0
    //   224: aload 7
    //   226: invokevirtual 56	java/lang/Exception:printStackTrace	()V
    //   229: iload 5
    //   231: istore 4
    //   233: aload 6
    //   235: ifnull -174 -> 61
    //   238: aload 6
    //   240: invokevirtual 52	java/io/FileInputStream:close	()V
    //   243: iconst_0
    //   244: ireturn
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   250: iconst_0
    //   251: ireturn
    //   252: astore 6
    //   254: aconst_null
    //   255: astore_0
    //   256: aload_0
    //   257: ifnull +7 -> 264
    //   260: aload_0
    //   261: invokevirtual 52	java/io/FileInputStream:close	()V
    //   264: aload 6
    //   266: athrow
    //   267: astore_0
    //   268: aload_0
    //   269: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   272: goto -8 -> 264
    //   275: astore 6
    //   277: goto -21 -> 256
    //   280: astore 7
    //   282: goto -61 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramString	String
    //   36	155	1	i	int
    //   92	70	2	j	int
    //   97	65	3	k	int
    //   45	187	4	bool1	boolean
    //   1	229	5	bool2	boolean
    //   17	222	6	localFileInputStream	java.io.FileInputStream
    //   252	13	6	localObject1	java.lang.Object
    //   275	1	6	localObject2	java.lang.Object
    //   7	148	7	arrayOfByte	byte[]
    //   216	9	7	localException1	java.lang.Exception
    //   280	1	7	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   52	57	64	java/io/IOException
    //   112	117	119	java/io/IOException
    //   173	178	180	java/io/IOException
    //   202	207	209	java/io/IOException
    //   9	19	216	java/lang/Exception
    //   238	243	245	java/io/IOException
    //   9	19	252	finally
    //   260	264	267	java/io/IOException
    //   22	30	275	finally
    //   33	37	275	finally
    //   76	84	275	finally
    //   87	93	275	finally
    //   145	154	275	finally
    //   224	229	275	finally
    //   22	30	280	java/lang/Exception
    //   33	37	280	java/lang/Exception
    //   76	84	280	java/lang/Exception
    //   87	93	280	java/lang/Exception
    //   145	154	280	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpv
 * JD-Core Version:    0.7.0.1
 */