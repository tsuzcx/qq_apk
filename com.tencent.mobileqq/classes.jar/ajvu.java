import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ajvu
{
  private ajvv jdField_a_of_type_Ajvv;
  private ConcurrentHashMap<Integer, ajvz> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public ajvu(ajvv paramajvv)
  {
    this.jdField_a_of_type_Ajvv = paramajvv;
  }
  
  public ajvz a(int paramInt)
  {
    return (ajvz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      ajvz localajvz = (ajvz)localIterator.next();
      localajvz.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localajvz.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(ajvz paramajvz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramajvz.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramajvz.jdField_a_of_type_Int), paramajvz);
    if (this.jdField_a_of_type_Ajvv != null) {
      this.jdField_a_of_type_Ajvv.a();
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
 * Qualified Name:     ajvu
 * JD-Core Version:    0.7.0.1
 */