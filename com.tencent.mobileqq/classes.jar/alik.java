import com.tencent.qqprotect.qsec.QSecLibMgr;
import com.tencent.qqprotect.qsec.QSecLibMgr.LibEventListener;
import com.tencent.qqprotect.qsec.QSecPushServiceMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class alik
  implements QSecLibMgr.LibEventListener
{
  public alik(QSecPushServiceMgr paramQSecPushServiceMgr) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (QSecPushServiceMgr.a(this.a))
      {
        Object localObject2 = (List)QSecPushServiceMgr.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          QSecPushServiceMgr.a(this.a).remove(Integer.valueOf(paramInt2));
          QSecPushServiceMgr.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (alil)((Iterator)???).next();
            QSecPushServiceMgr.a(this.a).a(((alil)localObject2).jdField_a_of_type_Int, ((alil)localObject2).b, ((alil)localObject2).c, new Object[] { ((alil)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alik
 * JD-Core Version:    0.7.0.1
 */