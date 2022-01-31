import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ahzx
{
  private ahzy jdField_a_of_type_Ahzy;
  private ConcurrentHashMap<Integer, aiac> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public ahzx(ahzy paramahzy)
  {
    this.jdField_a_of_type_Ahzy = paramahzy;
  }
  
  public aiac a(int paramInt)
  {
    return (aiac)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      aiac localaiac = (aiac)localIterator.next();
      localaiac.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localaiac.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(aiac paramaiac)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramaiac.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramaiac.jdField_a_of_type_Int), paramaiac);
    if (this.jdField_a_of_type_Ahzy != null) {
      this.jdField_a_of_type_Ahzy.a();
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
 * Qualified Name:     ahzx
 * JD-Core Version:    0.7.0.1
 */