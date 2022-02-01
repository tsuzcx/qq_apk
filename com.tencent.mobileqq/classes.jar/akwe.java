import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class akwe
{
  private akwf jdField_a_of_type_Akwf;
  private ConcurrentHashMap<Integer, akwj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public akwe(akwf paramakwf)
  {
    this.jdField_a_of_type_Akwf = paramakwf;
  }
  
  public akwj a(int paramInt)
  {
    return (akwj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      akwj localakwj = (akwj)localIterator.next();
      localakwj.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localakwj.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(akwj paramakwj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramakwj.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramakwj.jdField_a_of_type_Int), paramakwj);
    if (this.jdField_a_of_type_Akwf != null) {
      this.jdField_a_of_type_Akwf.a();
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
 * Qualified Name:     akwe
 * JD-Core Version:    0.7.0.1
 */