import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class amac
{
  private amad jdField_a_of_type_Amad;
  private ConcurrentHashMap<Integer, amah> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public amac(amad paramamad)
  {
    this.jdField_a_of_type_Amad = paramamad;
  }
  
  public amah a(int paramInt)
  {
    return (amah)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      amah localamah = (amah)localIterator.next();
      localamah.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localamah.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(amah paramamah)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramamah.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramamah.jdField_a_of_type_Int), paramamah);
    if (this.jdField_a_of_type_Amad != null) {
      this.jdField_a_of_type_Amad.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amac
 * JD-Core Version:    0.7.0.1
 */