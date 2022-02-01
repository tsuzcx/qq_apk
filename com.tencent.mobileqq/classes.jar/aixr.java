import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.WXVadSeg;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class aixr
{
  private int jdField_a_of_type_Int;
  private aixu jdField_a_of_type_Aixu;
  private aiyv jdField_a_of_type_Aiyv;
  private beyb jdField_a_of_type_Beyb;
  private beyf jdField_a_of_type_Beyf = new aixs(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private aixw[] jdField_a_of_type_ArrayOfAixw;
  private String b;
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "vadHelper size=" + this.jdField_a_of_type_Aiyv.jdField_a_of_type_JavaUtilList.size() + " unFinishSegSize=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " isSttFinish=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_Aiyv.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_Beyb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.jdField_a_of_type_Beyb.a(this.jdField_a_of_type_Beyf);
      beyg localbeyg = new beyg();
      localbeyg.jdField_a_of_type_Boolean = true;
      localbeyg.jdField_c_of_type_Int = 68;
      localbeyg.i = paramString;
      localbeyg.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
      localbeyg.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localbeyg.b = 327696;
      localbeyg.jdField_a_of_type_JavaLangString = "pttSliceToText";
      localbeyg.n = this.b;
      localbeyg.o = this.jdField_a_of_type_Aiyv.jdField_a_of_type_JavaUtilList.size();
      localbeyg.p = i;
      localbeyg.jdField_a_of_type_ComWxVoiceVadWXVadSeg = ((WXVadSeg)this.jdField_a_of_type_Aiyv.jdField_a_of_type_JavaUtilList.get(i));
      localbeyg.q = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Beyb.a(localbeyg);
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest pos=" + i);
      }
      this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localbeyg.jdField_a_of_type_Long));
      i += 1;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "vadHelper  vad start");
    }
    this.jdField_a_of_type_Aiyv = new aiyv();
    this.jdField_a_of_type_Aiyv.a(this.b);
    this.jdField_a_of_type_Aiyv.a();
    this.jdField_a_of_type_Aiyv.b();
    this.jdField_a_of_type_Aiyv.c();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "vadHelper  vad start");
    }
  }
  
  int a(int paramInt)
  {
    if (paramInt == 3000) {}
    for (int i = 1;; i = 2)
    {
      if (paramInt == 0) {
        return 2;
      }
      return i;
    }
  }
  
  String a(aixw paramaixw, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAixw[paramInt] = paramaixw;
    paramaixw = new StringBuffer();
    paramInt = 0;
    for (;;)
    {
      aixw localaixw;
      if (paramInt < this.jdField_a_of_type_ArrayOfAixw.length)
      {
        localaixw = this.jdField_a_of_type_ArrayOfAixw[paramInt];
        if (localaixw != null) {
          break label42;
        }
      }
      label42:
      do
      {
        return paramaixw.toString();
        paramaixw.append(localaixw.jdField_a_of_type_JavaLangString);
      } while (!localaixw.jdField_a_of_type_Boolean);
      paramInt += 1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "cancelAllRequest sendIds len=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_Beyb.d(this.jdField_a_of_type_JavaLangString, ((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue());
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(aixu paramaixu)
  {
    this.jdField_a_of_type_Aixu = paramaixu;
  }
  
  void a(aixw paramaixw, int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfAixw == null) || (paramInt >= this.jdField_a_of_type_ArrayOfAixw.length) || ((this.jdField_a_of_type_ArrayOfAixw[paramInt] != null) && (this.jdField_a_of_type_ArrayOfAixw[paramInt].jdField_a_of_type_Boolean))) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "updateText fail");
      }
    }
    do
    {
      return;
      paramaixw = a(paramaixw, paramInt);
    } while (this.jdField_a_of_type_Aixu == null);
    this.jdField_a_of_type_Aixu.a(paramaixw);
  }
  
  public void a(String paramString)
  {
    bkdz.a(new VoiceTextSttQueryController.2(this, paramString));
  }
  
  void a(String paramString1, QQAppInterface paramQQAppInterface, aixu paramaixu, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.jdField_a_of_type_Aixu = paramaixu;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = a(paramInt);
    this.jdField_a_of_type_Beyf.addFilter(new Class[] { bewb.class });
  }
  
  public void b()
  {
    a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Beyb != null) {
      this.jdField_a_of_type_Beyb.b(this.jdField_a_of_type_Beyf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixr
 * JD-Core Version:    0.7.0.1
 */