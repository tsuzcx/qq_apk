import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class aljm
  implements alcz
{
  private int jdField_a_of_type_Int;
  
  aljm(aljj paramaljj) {}
  
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
      this.jdField_a_of_type_Aljj.a();
      return;
      aljj.c(this.jdField_a_of_type_Aljj, true);
      continue;
      aljj.d(this.jdField_a_of_type_Aljj, true);
      continue;
      aljj.e(this.jdField_a_of_type_Aljj, true);
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
      Iterator localIterator = aljj.a(this.jdField_a_of_type_Aljj).iterator();
      while (localIterator.hasNext())
      {
        aljn localaljn = (aljn)((WeakReference)localIterator.next()).get();
        if (localaljn != null) {
          localaljn.b(this.jdField_a_of_type_Int);
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
      Iterator localIterator = aljj.a(this.jdField_a_of_type_Aljj).iterator();
      while (localIterator.hasNext())
      {
        aljn localaljn = (aljn)((WeakReference)localIterator.next()).get();
        if (localaljn != null) {
          localaljn.c(paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aljm
 * JD-Core Version:    0.7.0.1
 */