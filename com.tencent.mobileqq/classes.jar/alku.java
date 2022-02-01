import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

public class alku
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<Integer, alkr> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public alku(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  /* Error */
  @android.support.annotation.Nullable
  public alkr a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	alku:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 37 2 0
    //   15: ifeq +24 -> 39
    //   18: aload_0
    //   19: getfield 20	alku:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   22: iload_1
    //   23: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: invokeinterface 41 2 0
    //   31: checkcast 43	alkr
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: iload_1
    //   40: invokestatic 47	alkv:a	(I)Lalkr;
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 20	alku:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   48: iload_1
    //   49: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aload_2
    //   53: invokeinterface 51 3 0
    //   58: pop
    //   59: goto -24 -> 35
    //   62: astore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	alku
    //   0	67	1	paramInt	int
    //   34	19	2	localalkr	alkr
    //   62	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	62	finally
    //   39	59	62	finally
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alku
 * JD-Core Version:    0.7.0.1
 */