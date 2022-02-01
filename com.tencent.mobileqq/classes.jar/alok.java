import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class alok
{
  private alol jdField_a_of_type_Alol;
  private ConcurrentHashMap<Integer, alop> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public alok(alol paramalol)
  {
    this.jdField_a_of_type_Alol = paramalol;
  }
  
  public alop a(int paramInt)
  {
    return (alop)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      alop localalop = (alop)localIterator.next();
      localalop.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localalop.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(alop paramalop)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramalop.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramalop.jdField_a_of_type_Int), paramalop);
    if (this.jdField_a_of_type_Alol != null) {
      this.jdField_a_of_type_Alol.a();
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
 * Qualified Name:     alok
 * JD-Core Version:    0.7.0.1
 */