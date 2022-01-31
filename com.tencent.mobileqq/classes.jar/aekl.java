public class aekl
{
  private static aekl a;
  public int a;
  private int b = -1;
  
  private aekl()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  /* Error */
  public static aekl a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	aekl:jdField_a_of_type_Aekl	Laekl;
    //   6: ifnonnull +22 -> 28
    //   9: new 2	aekl
    //   12: dup
    //   13: invokespecial 21	aekl:<init>	()V
    //   16: putstatic 20	aekl:jdField_a_of_type_Aekl	Laekl;
    //   19: getstatic 20	aekl:jdField_a_of_type_Aekl	Laekl;
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 20	aekl:jdField_a_of_type_Aekl	Laekl;
    //   31: iconst_1
    //   32: putfield 14	aekl:jdField_a_of_type_Int	I
    //   35: goto -16 -> 19
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	5	0	localaekl	aekl
    //   38	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	38	finally
    //   19	23	38	finally
    //   28	35	38	finally
  }
  
  public int a()
  {
    if (-1 == this.b)
    {
      if ((bdcb.d() >>> 20 <= 1390L) || (bdcb.b() <= 3) || (bdcb.a() <= 1433L)) {
        break label48;
      }
      this.b = 1;
    }
    for (;;)
    {
      return this.b;
      label48:
      if ((bdcb.d() >>> 20 > 926L) && (bdcb.b() > 1) && (bdcb.a() > 961L)) {
        this.b = 2;
      } else {
        this.b = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekl
 * JD-Core Version:    0.7.0.1
 */