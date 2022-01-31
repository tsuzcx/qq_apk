import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class aljl
  implements alcy
{
  private int jdField_a_of_type_Int;
  
  aljl(alji paramalji) {}
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, String.format("onMiniDownloadSuccess type=%d", new Object[] { Integer.valueOf(paramInt) }));
      }
      this.jdField_a_of_type_Alji.a();
      return;
      alji.c(this.jdField_a_of_type_Alji, true);
      continue;
      alji.d(this.jdField_a_of_type_Alji, true);
      continue;
      alji.e(this.jdField_a_of_type_Alji, true);
      this.jdField_a_of_type_Int = 100;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    while (paramInt1 == 0)
    {
      Iterator localIterator = alji.a(this.jdField_a_of_type_Alji).iterator();
      while (localIterator.hasNext())
      {
        aljm localaljm = (aljm)((WeakReference)localIterator.next()).get();
        if (localaljm != null) {
          localaljm.b(this.jdField_a_of_type_Int);
        }
      }
      this.jdField_a_of_type_Int = paramInt2;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onMiniDownloadError type=%d error=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 0)
    {
      Iterator localIterator = alji.a(this.jdField_a_of_type_Alji).iterator();
      while (localIterator.hasNext())
      {
        aljm localaljm = (aljm)((WeakReference)localIterator.next()).get();
        if (localaljm != null) {
          localaljm.c(paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aljl
 * JD-Core Version:    0.7.0.1
 */