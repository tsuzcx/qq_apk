public class afuj
{
  private static afuj a;
  public int a;
  private int b = -1;
  
  private afuj()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  /* Error */
  public static afuj a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	afuj:jdField_a_of_type_Afuj	Lafuj;
    //   6: ifnonnull +22 -> 28
    //   9: new 2	afuj
    //   12: dup
    //   13: invokespecial 21	afuj:<init>	()V
    //   16: putstatic 20	afuj:jdField_a_of_type_Afuj	Lafuj;
    //   19: getstatic 20	afuj:jdField_a_of_type_Afuj	Lafuj;
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 20	afuj:jdField_a_of_type_Afuj	Lafuj;
    //   31: iconst_1
    //   32: putfield 14	afuj:jdField_a_of_type_Int	I
    //   35: goto -16 -> 19
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	5	0	localafuj	afuj
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
      if ((bgln.d() >>> 20 <= 1390L) || (bgln.b() <= 3) || (bgln.a() <= 1433L)) {
        break label48;
      }
      this.b = 1;
    }
    for (;;)
    {
      return this.b;
      label48:
      if ((bgln.d() >>> 20 > 926L) && (bgln.b() > 1) && (bgln.a() > 961L)) {
        this.b = 2;
      } else {
        this.b = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afuj
 * JD-Core Version:    0.7.0.1
 */