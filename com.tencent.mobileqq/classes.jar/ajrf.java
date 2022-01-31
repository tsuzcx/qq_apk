import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ajrf
{
  private ajrg jdField_a_of_type_Ajrg;
  private ConcurrentHashMap<Integer, ajrk> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public ajrf(ajrg paramajrg)
  {
    this.jdField_a_of_type_Ajrg = paramajrg;
  }
  
  public ajrk a(int paramInt)
  {
    return (ajrk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      ajrk localajrk = (ajrk)localIterator.next();
      localajrk.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localajrk.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(ajrk paramajrk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramajrk.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramajrk.jdField_a_of_type_Int), paramajrk);
    if (this.jdField_a_of_type_Ajrg != null) {
      this.jdField_a_of_type_Ajrg.a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrf
 * JD-Core Version:    0.7.0.1
 */