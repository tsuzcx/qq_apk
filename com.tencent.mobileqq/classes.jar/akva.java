import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class akva
  implements akon
{
  private int jdField_a_of_type_Int;
  
  akva(akux paramakux) {}
  
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
      this.jdField_a_of_type_Akux.a();
      return;
      akux.c(this.jdField_a_of_type_Akux, true);
      continue;
      akux.d(this.jdField_a_of_type_Akux, true);
      continue;
      akux.e(this.jdField_a_of_type_Akux, true);
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
      Iterator localIterator = akux.a(this.jdField_a_of_type_Akux).iterator();
      while (localIterator.hasNext())
      {
        akvb localakvb = (akvb)((WeakReference)localIterator.next()).get();
        if (localakvb != null) {
          localakvb.b(this.jdField_a_of_type_Int);
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
      Iterator localIterator = akux.a(this.jdField_a_of_type_Akux).iterator();
      while (localIterator.hasNext())
      {
        akvb localakvb = (akvb)((WeakReference)localIterator.next()).get();
        if (localakvb != null) {
          localakvb.c(paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akva
 * JD-Core Version:    0.7.0.1
 */