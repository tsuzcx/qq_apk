import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ahnf
{
  private ahng jdField_a_of_type_Ahng;
  private ConcurrentHashMap<Integer, ahnk> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public ahnf(ahng paramahng)
  {
    this.jdField_a_of_type_Ahng = paramahng;
  }
  
  public ahnk a(int paramInt)
  {
    return (ahnk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      ahnk localahnk = (ahnk)localIterator.next();
      localahnk.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localahnk.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(ahnk paramahnk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramahnk.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramahnk.jdField_a_of_type_Int), paramahnk);
    if (this.jdField_a_of_type_Ahng != null) {
      this.jdField_a_of_type_Ahng.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahnf
 * JD-Core Version:    0.7.0.1
 */