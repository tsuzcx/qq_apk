import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.subtitles.EncodeRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class ahyf
  extends awbj
{
  ahyf(ahyd paramahyd) {}
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahyd.a(), 2, "onSessionClose sessionid:" + paramLong + " result:" + paramInt);
    }
    synchronized (this.a)
    {
      if (ahyd.a(this.a) == null) {
        return;
      }
      if (ahyd.a(this.a).jdField_a_of_type_Long != paramLong) {
        return;
      }
    }
    ahyd.a(this.a, false);
    ahyd.a(this.a).jdField_b_of_type_Int = 0;
    ahyd.c(this.a);
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahyd.a(), 2, "onTranslate:  sessionid:" + paramLong + " startseq:" + paramInt1 + " endseq:" + paramInt2 + "[" + paramInt2 * 1.0F + "] status:" + paramInt3 + " CN:" + paramString1 + " EN:" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramInt2 *= 2;
    ahyg localahyg = null;
    synchronized (this.a)
    {
      if (ahyd.a(this.a) == null) {
        return;
      }
    }
    if (ahyd.a(this.a).jdField_a_of_type_Long != paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ahyd.a(), 2, "onTranslate, session not match:" + paramLong + "-" + ahyd.a(this.a).jdField_a_of_type_Long);
      }
      return;
    }
    if (!this.a.a()) {
      return;
    }
    if (ahyd.a(this.a).jdField_a_of_type_JavaLangRefWeakReference != null) {
      localahyg = (ahyg)ahyd.a(this.a).jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (QLog.isColorLevel()) {
      QLog.d(ahyd.a(), 2, "onTranslate, :  localtime:" + ahyd.a(this.a).c);
    }
    ahzl localahzl = (ahzl)ahyd.a(this.a).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    long l1;
    label460:
    long l2;
    if (localahzl == null)
    {
      l1 = (int)(paramInt2 * 1.0F) * 20 * ahyd.a(this.a).jdField_a_of_type_Int - 500;
      paramLong = System.currentTimeMillis() - ahyd.a(this.a).c - 500L;
      if (!QLog.isColorLevel()) {
        break label751;
      }
      QLog.d(ahyd.a(), 2, "onTranslate startiem: " + l1 + "-" + paramLong);
      break label751;
      localahzl = new ahzl(paramLong, paramInt1, paramInt2);
      ahyd.a(this.a).jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), localahzl);
      l1 = paramLong;
      paramLong = (int)(paramInt2 * 1.0F) * 20 * ahyd.a(this.a).jdField_a_of_type_Int;
      l2 = System.currentTimeMillis() - ahyd.a(this.a).c - 500L;
      if (!QLog.isColorLevel()) {
        break label776;
      }
      QLog.d(ahyd.a(), 2, "onTranslate endtime: " + paramLong + "-" + l2);
      break label776;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ahyd.a(), 2, "onTranslate, starttime-endtime: " + l1 + "-" + l2);
      }
      if (localahyg != null) {
        if (paramInt3 != 2) {
          break label739;
        }
      }
      label739:
      for (boolean bool = true;; bool = false)
      {
        localahyg.a(l1, l2, paramString1, paramString2, bool);
        if (!ahyd.a(this.a)) {
          break;
        }
        paramString1 = String.valueOf(System.currentTimeMillis() - ahyd.a(this.a));
        paramString2 = new HashMap();
        paramString2.put("startTranslateCost", paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("PeakAudioTransHandler", 2, "startTranslateCost:" + paramString1);
        }
        axrl.a(BaseApplicationImpl.getApplication()).a(null, "actSubtitleTranslate", true, 0L, 0L, paramString2, null);
        ahyd.a(this.a, false);
        return;
        l1 = localahzl.jdField_a_of_type_Long;
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
  
  protected void a(long paramLong, int paramInt1, int paramInt2, avwh paramavwh)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahyd.a(), 2, "onSessionOpen sessionid:" + paramLong + " combineNum:" + paramInt1 + " heratbeat:" + paramInt2 + ",endPoint = " + paramavwh);
    }
    synchronized (this.a)
    {
      if (ahyd.a(this.a) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(ahyd.a(), 2, "TransContext is null");
        }
        return;
      }
      if (ahyd.a(this.a).jdField_b_of_type_Int != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(ahyd.a(), 2, "onSessionOpen state error:" + ahyd.a(this.a).jdField_b_of_type_Int);
        }
        return;
      }
    }
    if ((ahyd.a(this.a).jdField_a_of_type_Long != -1L) && (QLog.isColorLevel())) {
      QLog.d(ahyd.a(), 2, "onSessionOpen, old session not closed " + ahyd.a(this.a).jdField_a_of_type_Long);
    }
    ahyd.a(this.a).jdField_a_of_type_Long = paramLong;
    ahyd.a(this.a).jdField_a_of_type_Int = paramInt1;
    ahyd.a(this.a).jdField_b_of_type_Int = 3;
    ahyd.a(this.a).jdField_a_of_type_Avwh = paramavwh;
    if (ahyd.a(this.a).jdField_b_of_type_Boolean) {
      ahyd.b(this.a);
    }
    if (ahyd.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable != null) {
      ahyd.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.a(paramLong, paramInt1);
    }
    for (;;)
    {
      ahyd.a(this.a, ahyd.a(this.a), true, paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(ahyd.a(), 2, "onSessionOpen encoderunnable error" + paramLong);
      }
    }
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahyd.a(), 2, "onSessionChanged sessionid:" + paramLong + " combinenum:" + paramInt);
    }
    synchronized (this.a)
    {
      if (ahyd.a(this.a) == null) {
        return;
      }
      if ((ahyd.a(this.a).jdField_a_of_type_Long == paramLong) && (ahyd.a(this.a).jdField_a_of_type_Int != paramInt))
      {
        ahyd.a(this.a).jdField_a_of_type_Int = paramInt;
        if (ahyd.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable != null) {
          ahyd.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.a(paramLong, paramInt);
        }
      }
      return;
    }
  }
  
  protected void c(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahyd.a(), 2, "onSessionError sessionid:" + paramLong + " result:" + paramInt);
    }
    synchronized (this.a)
    {
      if (ahyd.a(this.a) == null) {
        return;
      }
      if ((ahyd.a(this.a).jdField_a_of_type_Long != -1L) && (ahyd.a(this.a).jdField_a_of_type_Long != paramLong)) {
        return;
      }
    }
    if ((ahyd.a(this.a).jdField_a_of_type_Long != paramLong) && (ahyd.a(this.a).jdField_a_of_type_JavaLangRefWeakReference == null)) {
      return;
    }
    ahyd.a(this.a).jdField_b_of_type_Int = 0;
    ahyd.c(this.a);
    ahyd.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahyf
 * JD-Core Version:    0.7.0.1
 */