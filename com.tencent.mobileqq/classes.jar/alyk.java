import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.subtitles.EncodeRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class alyk
  extends bbon
{
  alyk(alyi paramalyi) {}
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(alyi.a(), 2, "onSessionClose sessionid:" + paramLong + " result:" + paramInt);
    }
    synchronized (this.a)
    {
      if (alyi.a(this.a) == null) {
        return;
      }
      if (alyi.a(this.a).jdField_a_of_type_Long != paramLong) {
        return;
      }
    }
    alyi.a(this.a, false);
    alyi.a(this.a).jdField_b_of_type_Int = 0;
    alyi.c(this.a);
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(alyi.a(), 2, "onTranslate:  sessionid:" + paramLong + " startseq:" + paramInt1 + " endseq:" + paramInt2 + "[" + paramInt2 * 1.0F + "] status:" + paramInt3 + " CN:" + paramString1 + " EN:" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramInt2 *= 2;
    alyl localalyl = null;
    synchronized (this.a)
    {
      if (alyi.a(this.a) == null) {
        return;
      }
    }
    if (alyi.a(this.a).jdField_a_of_type_Long != paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d(alyi.a(), 2, "onTranslate, session not match:" + paramLong + "-" + alyi.a(this.a).jdField_a_of_type_Long);
      }
      return;
    }
    if (!this.a.a()) {
      return;
    }
    if (alyi.a(this.a).jdField_a_of_type_JavaLangRefWeakReference != null) {
      localalyl = (alyl)alyi.a(this.a).jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (QLog.isColorLevel()) {
      QLog.d(alyi.a(), 2, "onTranslate, :  localtime:" + alyi.a(this.a).c);
    }
    alzq localalzq = (alzq)alyi.a(this.a).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    long l1;
    label460:
    long l2;
    if (localalzq == null)
    {
      l1 = (int)(paramInt2 * 1.0F) * 20 * alyi.a(this.a).jdField_a_of_type_Int - 500;
      paramLong = System.currentTimeMillis() - alyi.a(this.a).c - 500L;
      if (!QLog.isColorLevel()) {
        break label751;
      }
      QLog.d(alyi.a(), 2, "onTranslate startiem: " + l1 + "-" + paramLong);
      break label751;
      localalzq = new alzq(paramLong, paramInt1, paramInt2);
      alyi.a(this.a).jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), localalzq);
      l1 = paramLong;
      paramLong = (int)(paramInt2 * 1.0F) * 20 * alyi.a(this.a).jdField_a_of_type_Int;
      l2 = System.currentTimeMillis() - alyi.a(this.a).c - 500L;
      if (!QLog.isColorLevel()) {
        break label776;
      }
      QLog.d(alyi.a(), 2, "onTranslate endtime: " + paramLong + "-" + l2);
      break label776;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(alyi.a(), 2, "onTranslate, starttime-endtime: " + l1 + "-" + l2);
      }
      if (localalyl != null) {
        if (paramInt3 != 2) {
          break label739;
        }
      }
      label739:
      for (boolean bool = true;; bool = false)
      {
        localalyl.a(l1, l2, paramString1, paramString2, bool);
        if (!alyi.a(this.a)) {
          break;
        }
        paramString1 = String.valueOf(System.currentTimeMillis() - alyi.a(this.a));
        paramString2 = new HashMap();
        paramString2.put("startTranslateCost", paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("PeakAudioTransHandler", 2, "startTranslateCost:" + paramString1);
        }
        bdmc.a(BaseApplicationImpl.getApplication()).a(null, "actSubtitleTranslate", true, 0L, 0L, paramString2, null);
        alyi.a(this.a, false);
        return;
        l1 = localalzq.jdField_a_of_type_Long;
        break label460;
      }
      for (;;)
      {
        break label786;
        for (;;)
        {
          break;
          label751:
          if (l1 > paramLong) {
            l1 = paramLong;
          }
        }
        paramLong = l1;
        if (l1 >= 0L) {
          break;
        }
        paramLong = 0L;
        break;
        label776:
        if (paramLong > l2) {
          paramLong = l2;
        }
      }
      label786:
      l2 = paramLong;
      if (paramLong <= l1) {
        l2 = 1000L + l1;
      }
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, bbjl parambbjl)
  {
    if (QLog.isColorLevel()) {
      QLog.d(alyi.a(), 2, "onSessionOpen sessionid:" + paramLong + " combineNum:" + paramInt1 + " heratbeat:" + paramInt2 + ",endPoint = " + parambbjl);
    }
    synchronized (this.a)
    {
      if (alyi.a(this.a) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(alyi.a(), 2, "TransContext is null");
        }
        return;
      }
      if (alyi.a(this.a).jdField_b_of_type_Int != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(alyi.a(), 2, "onSessionOpen state error:" + alyi.a(this.a).jdField_b_of_type_Int);
        }
        return;
      }
    }
    if ((alyi.a(this.a).jdField_a_of_type_Long != -1L) && (QLog.isColorLevel())) {
      QLog.d(alyi.a(), 2, "onSessionOpen, old session not closed " + alyi.a(this.a).jdField_a_of_type_Long);
    }
    alyi.a(this.a).jdField_a_of_type_Long = paramLong;
    alyi.a(this.a).jdField_a_of_type_Int = paramInt1;
    alyi.a(this.a).jdField_b_of_type_Int = 3;
    alyi.a(this.a).jdField_a_of_type_Bbjl = parambbjl;
    if (alyi.a(this.a).jdField_b_of_type_Boolean) {
      alyi.b(this.a);
    }
    if (alyi.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable != null) {
      alyi.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.a(paramLong, paramInt1);
    }
    for (;;)
    {
      alyi.a(this.a, alyi.a(this.a), true, paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(alyi.a(), 2, "onSessionOpen encoderunnable error" + paramLong);
      }
    }
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(alyi.a(), 2, "onSessionChanged sessionid:" + paramLong + " combinenum:" + paramInt);
    }
    synchronized (this.a)
    {
      if (alyi.a(this.a) == null) {
        return;
      }
      if ((alyi.a(this.a).jdField_a_of_type_Long == paramLong) && (alyi.a(this.a).jdField_a_of_type_Int != paramInt))
      {
        alyi.a(this.a).jdField_a_of_type_Int = paramInt;
        if (alyi.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable != null) {
          alyi.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.a(paramLong, paramInt);
        }
      }
      return;
    }
  }
  
  protected void c(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(alyi.a(), 2, "onSessionError sessionid:" + paramLong + " result:" + paramInt);
    }
    synchronized (this.a)
    {
      if (alyi.a(this.a) == null) {
        return;
      }
      if ((alyi.a(this.a).jdField_a_of_type_Long != -1L) && (alyi.a(this.a).jdField_a_of_type_Long != paramLong)) {
        return;
      }
    }
    if ((alyi.a(this.a).jdField_a_of_type_Long != paramLong) && (alyi.a(this.a).jdField_a_of_type_JavaLangRefWeakReference == null)) {
      return;
    }
    alyi.a(this.a).jdField_b_of_type_Int = 0;
    alyi.c(this.a);
    alyi.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyk
 * JD-Core Version:    0.7.0.1
 */