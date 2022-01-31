import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ahzv
{
  private ahzw jdField_a_of_type_Ahzw;
  private ConcurrentHashMap<Integer, aiaa> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public ahzv(ahzw paramahzw)
  {
    this.jdField_a_of_type_Ahzw = paramahzw;
  }
  
  public aiaa a(int paramInt)
  {
    return (aiaa)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      aiaa localaiaa = (aiaa)localIterator.next();
      localaiaa.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localaiaa.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(aiaa paramaiaa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramaiaa.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramaiaa.jdField_a_of_type_Int), paramaiaa);
    if (this.jdField_a_of_type_Ahzw != null) {
      this.jdField_a_of_type_Ahzw.a();
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
 * Qualified Name:     ahzv
 * JD-Core Version:    0.7.0.1
 */