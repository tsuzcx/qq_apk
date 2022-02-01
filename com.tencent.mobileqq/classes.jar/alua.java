import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class alua
{
  private alub jdField_a_of_type_Alub;
  private ConcurrentHashMap<Integer, aluf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public alua(alub paramalub)
  {
    this.jdField_a_of_type_Alub = paramalub;
  }
  
  public aluf a(int paramInt)
  {
    return (aluf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      aluf localaluf = (aluf)localIterator.next();
      localaluf.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localaluf.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(aluf paramaluf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramaluf.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramaluf.jdField_a_of_type_Int), paramaluf);
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.a();
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
 * Qualified Name:     alua
 * JD-Core Version:    0.7.0.1
 */