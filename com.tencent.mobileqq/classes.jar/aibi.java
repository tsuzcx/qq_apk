import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransFileController.ProcHandler;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class aibi
{
  protected long a;
  private aibi jdField_a_of_type_Aibi;
  protected String a;
  protected AtomicBoolean a;
  private aibi[] jdField_a_of_type_ArrayOfAibi;
  protected AtomicBoolean b = new AtomicBoolean(false);
  
  aibi(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangString = "ForwardStep";
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 4, this.jdField_a_of_type_JavaLangString + "|doStep");
    }
    if ((this.jdField_a_of_type_ArrayOfAibi != null) && (this.jdField_a_of_type_ArrayOfAibi.length > 0))
    {
      aibi[] arrayOfaibi = this.jdField_a_of_type_ArrayOfAibi;
      int m = arrayOfaibi.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        aibi localaibi = arrayOfaibi[j];
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.share.ForwardSdkShareProcessor", 4, this.jdField_a_of_type_JavaLangString + "|finished=" + localaibi.a() + ",processing=" + localaibi.b());
        }
        if (!localaibi.a())
        {
          if (!localaibi.b()) {
            localaibi.a();
          }
          i = 0;
        }
        j += 1;
      }
    }
    int k = 1;
    if ((k != 0) && (!a()) && (!b()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      d();
    }
  }
  
  public void a(aibi[] paramArrayOfaibi)
  {
    this.jdField_a_of_type_ArrayOfAibi = paramArrayOfaibi;
    if ((this.jdField_a_of_type_ArrayOfAibi != null) && (this.jdField_a_of_type_ArrayOfAibi.length > 0))
    {
      paramArrayOfaibi = this.jdField_a_of_type_ArrayOfAibi;
      int j = paramArrayOfaibi.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfaibi[i].jdField_a_of_type_Aibi = this;
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  void b()
  {
    long l = 0L;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 4, this.jdField_a_of_type_JavaLangString + "|doNextStep");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, this.jdField_a_of_type_JavaLangString + "|finished,cost=" + l);
    }
    if ((this.jdField_a_of_type_Aibi != null) && (!this.b.get())) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.a.a.post(new aibj(this));
    }
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  void c()
  {
    long l = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.jdField_a_of_type_JavaLangString + "|doError,cost=" + l);
    this.jdField_a_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.d();
  }
  
  protected abstract void d();
  
  public void e()
  {
    if (a()) {}
    for (;;)
    {
      return;
      this.b.set(true);
      if ((this.jdField_a_of_type_ArrayOfAibi != null) && (this.jdField_a_of_type_ArrayOfAibi.length > 0))
      {
        aibi[] arrayOfaibi = this.jdField_a_of_type_ArrayOfAibi;
        int j = arrayOfaibi.length;
        int i = 0;
        while (i < j)
        {
          arrayOfaibi[i].e();
          i += 1;
        }
      }
    }
  }
  
  protected void f()
  {
    long l = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.jdField_a_of_type_JavaLangString + "|doCancel,cost=" + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aibi
 * JD-Core Version:    0.7.0.1
 */