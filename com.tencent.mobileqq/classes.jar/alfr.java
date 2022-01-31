import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class alfr
  implements alex
{
  alfr(alfo paramalfo, long paramLong, algt paramalgt) {}
  
  public void a(int paramInt, String paramString, algo paramalgo)
  {
    alfo.c(this.jdField_a_of_type_Alfo, false);
    if (alfo.a(this.jdField_a_of_type_Alfo)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_Alfo;
        if ((paramalgo == null) || (paramalgo.jdField_a_of_type_Alfz == null)) {
          continue;
        }
        i = paramalgo.jdField_a_of_type_Alfz.c;
        ((alfo)localObject).i = i;
        alfo localalfo = this.jdField_a_of_type_Alfo;
        if ((paramalgo == null) || (paramalgo.jdField_a_of_type_Alfz == null) || (paramalgo.jdField_a_of_type_Alfz.a == null) || (paramalgo.jdField_a_of_type_Alfz.a.length <= 0)) {
          continue;
        }
        localObject = paramalgo.jdField_a_of_type_Alfz.a[0].jdField_a_of_type_JavaLangString;
        localalfo.jdField_a_of_type_JavaLangString = ((String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        long l1;
        long l2;
        boolean bool2;
        boolean bool1;
        QLog.i("AREngine_ARCloudControl", 1, "  mCloudTime  mImageId " + localException.getMessage());
        continue;
        int i = 0;
        continue;
        QLog.i("AREngine_ARCloudControl", 1, "MIGObjectClaasify not need  run requestToCheckLBSLocation.");
        alfo.a(this.jdField_a_of_type_Alfo).a(paramInt, paramalgo);
        return;
      }
      if (this.jdField_a_of_type_Alfo.c != 0L) {
        this.jdField_a_of_type_Alfo.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Alfo.c);
      }
      if (this.jdField_a_of_type_Alfo.d != 0L)
      {
        localObject = this.jdField_a_of_type_Alfo;
        ((alfo)localObject).g += System.currentTimeMillis() - this.jdField_a_of_type_Alfo.d;
      }
      if (alfo.a(this.jdField_a_of_type_Alfo) != null) {
        alfo.a(this.jdField_a_of_type_Alfo).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (alfo.a(this.jdField_a_of_type_Alfo) == null) {
        break;
      }
      if ((paramInt == 0) && (paramalgo != null) && ((alfz.a(paramalgo.jdField_a_of_type_Alfz)) || (alge.a(paramalgo.jdField_a_of_type_Alge)) || (alhv.a(paramalgo.jdField_a_of_type_Alhv)) || (algq.a(paramalgo.jdField_a_of_type_Algq)) || (algw.a(paramalgo.jdField_a_of_type_Algw))))
      {
        QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.jdField_a_of_type_Alfo.jdField_j_of_type_Int);
        this.jdField_a_of_type_Alfo.jdField_j_of_type_Int = 0;
      }
      if ((paramalgo != null) && (alfz.a(paramalgo.jdField_a_of_type_Alfz))) {
        paramalgo.jdField_a_of_type_Alfz.b = this.jdField_a_of_type_Algt.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramalgo != null) && (alge.a(paramalgo.jdField_a_of_type_Alge))) {
        paramalgo.jdField_a_of_type_Alge.b = this.jdField_a_of_type_Algt.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramalgo != null) && (algw.a(paramalgo.jdField_a_of_type_Algw))) {
        paramalgo.jdField_a_of_type_Algw.b = this.jdField_a_of_type_Algt.a.jdField_a_of_type_JavaLangString;
      }
      if (!alfo.c(this.jdField_a_of_type_Alfo))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramInt == 0)
        {
          bool1 = bool2;
          if (paramalgo != null) {
            if ((!alfz.a(paramalgo.jdField_a_of_type_Alfz)) && (!alge.a(paramalgo.jdField_a_of_type_Alge)) && (!algq.a(paramalgo.jdField_a_of_type_Algq)) && (!algg.a(paramalgo.jdField_a_of_type_Algg)))
            {
              bool1 = bool2;
              if (!algw.a(paramalgo.jdField_a_of_type_Algw)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        l1 = alfo.a(this.jdField_a_of_type_Alfo).b();
        aldo.a().a(bool1, l1);
        alfo.d(this.jdField_a_of_type_Alfo, true);
      }
      if ((!alfo.d(this.jdField_a_of_type_Alfo)) && (paramInt == 0) && (paramalgo != null) && ((alfz.a(paramalgo.jdField_a_of_type_Alfz)) || (alge.a(paramalgo.jdField_a_of_type_Alge)) || (algq.a(paramalgo.jdField_a_of_type_Algq)) || (algg.a(paramalgo.jdField_a_of_type_Algg)) || (algw.a(paramalgo.jdField_a_of_type_Algw))))
      {
        l1 = alfo.a(this.jdField_a_of_type_Alfo).b();
        aldo.a().a(l1, this.jdField_a_of_type_Alfo.jdField_a_of_type_Alfv.c);
        alfo.e(this.jdField_a_of_type_Alfo, true);
      }
      if (alfo.a(this.jdField_a_of_type_Alfo) != null) {
        alfo.a(this.jdField_a_of_type_Alfo).add(paramString);
      }
      if ((this.jdField_a_of_type_Alfo.jdField_j_of_type_Int != 0) || (!algo.a(this.jdField_a_of_type_Alfo.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramalgo))) {
        break label932;
      }
      if (this.jdField_a_of_type_Alfo.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.switchLBSLocation != 1) {
        break label917;
      }
      if ((paramalgo.jdField_a_of_type_Long == 128L) && ((paramalgo.jdField_a_of_type_Long != 128L) || (!alfo.a(this.jdField_a_of_type_Alfo).a(paramalgo.jdField_a_of_type_Alhv)))) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
      alfo.a(this.jdField_a_of_type_Alfo, paramInt, paramalgo);
      return;
      i = 0;
      continue;
      localObject = "";
    }
    label917:
    alfo.a(this.jdField_a_of_type_Alfo).a(2, null);
    return;
    label932:
    alfo.a(this.jdField_a_of_type_Alfo).a(paramInt, paramalgo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alfr
 * JD-Core Version:    0.7.0.1
 */