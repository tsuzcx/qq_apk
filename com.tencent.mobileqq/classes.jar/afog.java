import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class afog
{
  private static afog a;
  public int a;
  private int b = -1;
  
  private afog()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  /* Error */
  public static afog a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	afog:jdField_a_of_type_Afog	Lafog;
    //   6: ifnonnull +22 -> 28
    //   9: new 2	afog
    //   12: dup
    //   13: invokespecial 21	afog:<init>	()V
    //   16: putstatic 20	afog:jdField_a_of_type_Afog	Lafog;
    //   19: getstatic 20	afog:jdField_a_of_type_Afog	Lafog;
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 20	afog:jdField_a_of_type_Afog	Lafog;
    //   31: iconst_1
    //   32: putfield 14	afog:jdField_a_of_type_Int	I
    //   35: goto -16 -> 19
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	5	0	localafog	afog
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
      if ((DeviceInfoUtil.getSystemTotalMemory() >>> 20 <= 1390L) || (DeviceInfoUtil.getCpuNumber() <= 3) || (DeviceInfoUtil.getCpuFrequency() <= 1433L)) {
        break label48;
      }
      this.b = 1;
    }
    for (;;)
    {
      return this.b;
      label48:
      if ((DeviceInfoUtil.getSystemTotalMemory() >>> 20 > 926L) && (DeviceInfoUtil.getCpuNumber() > 1) && (DeviceInfoUtil.getCpuFrequency() > 961L)) {
        this.b = 2;
      } else {
        this.b = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afog
 * JD-Core Version:    0.7.0.1
 */