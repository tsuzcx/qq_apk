import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class akrf
  implements akql
{
  akrf(akrc paramakrc, long paramLong, aksh paramaksh) {}
  
  public void a(int paramInt, String paramString, aksc paramaksc)
  {
    akrc.c(this.jdField_a_of_type_Akrc, false);
    if (akrc.a(this.jdField_a_of_type_Akrc)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_Akrc;
        if ((paramaksc == null) || (paramaksc.jdField_a_of_type_Akrn == null)) {
          continue;
        }
        i = paramaksc.jdField_a_of_type_Akrn.c;
        ((akrc)localObject).i = i;
        akrc localakrc = this.jdField_a_of_type_Akrc;
        if ((paramaksc == null) || (paramaksc.jdField_a_of_type_Akrn == null) || (paramaksc.jdField_a_of_type_Akrn.a == null) || (paramaksc.jdField_a_of_type_Akrn.a.length <= 0)) {
          continue;
        }
        localObject = paramaksc.jdField_a_of_type_Akrn.a[0].jdField_a_of_type_JavaLangString;
        localakrc.jdField_a_of_type_JavaLangString = ((String)localObject);
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
        akrc.a(this.jdField_a_of_type_Akrc).a(paramInt, paramaksc);
        return;
      }
      if (this.jdField_a_of_type_Akrc.c != 0L) {
        this.jdField_a_of_type_Akrc.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Akrc.c);
      }
      if (this.jdField_a_of_type_Akrc.d != 0L)
      {
        localObject = this.jdField_a_of_type_Akrc;
        ((akrc)localObject).g += System.currentTimeMillis() - this.jdField_a_of_type_Akrc.d;
      }
      if (akrc.a(this.jdField_a_of_type_Akrc) != null) {
        akrc.a(this.jdField_a_of_type_Akrc).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (akrc.a(this.jdField_a_of_type_Akrc) == null) {
        break;
      }
      if ((paramInt == 0) && (paramaksc != null) && ((akrn.a(paramaksc.jdField_a_of_type_Akrn)) || (akrs.a(paramaksc.jdField_a_of_type_Akrs)) || (aktj.a(paramaksc.jdField_a_of_type_Aktj)) || (akse.a(paramaksc.jdField_a_of_type_Akse)) || (aksk.a(paramaksc.jdField_a_of_type_Aksk))))
      {
        QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.jdField_a_of_type_Akrc.jdField_j_of_type_Int);
        this.jdField_a_of_type_Akrc.jdField_j_of_type_Int = 0;
      }
      if ((paramaksc != null) && (akrn.a(paramaksc.jdField_a_of_type_Akrn))) {
        paramaksc.jdField_a_of_type_Akrn.b = this.jdField_a_of_type_Aksh.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramaksc != null) && (akrs.a(paramaksc.jdField_a_of_type_Akrs))) {
        paramaksc.jdField_a_of_type_Akrs.b = this.jdField_a_of_type_Aksh.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramaksc != null) && (aksk.a(paramaksc.jdField_a_of_type_Aksk))) {
        paramaksc.jdField_a_of_type_Aksk.b = this.jdField_a_of_type_Aksh.a.jdField_a_of_type_JavaLangString;
      }
      if (!akrc.c(this.jdField_a_of_type_Akrc))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramInt == 0)
        {
          bool1 = bool2;
          if (paramaksc != null) {
            if ((!akrn.a(paramaksc.jdField_a_of_type_Akrn)) && (!akrs.a(paramaksc.jdField_a_of_type_Akrs)) && (!akse.a(paramaksc.jdField_a_of_type_Akse)) && (!akru.a(paramaksc.jdField_a_of_type_Akru)))
            {
              bool1 = bool2;
              if (!aksk.a(paramaksc.jdField_a_of_type_Aksk)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        l1 = akrc.a(this.jdField_a_of_type_Akrc).b();
        akpc.a().a(bool1, l1);
        akrc.d(this.jdField_a_of_type_Akrc, true);
      }
      if ((!akrc.d(this.jdField_a_of_type_Akrc)) && (paramInt == 0) && (paramaksc != null) && ((akrn.a(paramaksc.jdField_a_of_type_Akrn)) || (akrs.a(paramaksc.jdField_a_of_type_Akrs)) || (akse.a(paramaksc.jdField_a_of_type_Akse)) || (akru.a(paramaksc.jdField_a_of_type_Akru)) || (aksk.a(paramaksc.jdField_a_of_type_Aksk))))
      {
        l1 = akrc.a(this.jdField_a_of_type_Akrc).b();
        akpc.a().a(l1, this.jdField_a_of_type_Akrc.jdField_a_of_type_Akrj.c);
        akrc.e(this.jdField_a_of_type_Akrc, true);
      }
      if (akrc.a(this.jdField_a_of_type_Akrc) != null) {
        akrc.a(this.jdField_a_of_type_Akrc).add(paramString);
      }
      if ((this.jdField_a_of_type_Akrc.jdField_j_of_type_Int != 0) || (!aksc.a(this.jdField_a_of_type_Akrc.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramaksc))) {
        break label932;
      }
      if (this.jdField_a_of_type_Akrc.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.switchLBSLocation != 1) {
        break label917;
      }
      if ((paramaksc.jdField_a_of_type_Long == 128L) && ((paramaksc.jdField_a_of_type_Long != 128L) || (!akrc.a(this.jdField_a_of_type_Akrc).a(paramaksc.jdField_a_of_type_Aktj)))) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
      akrc.a(this.jdField_a_of_type_Akrc, paramInt, paramaksc);
      return;
      i = 0;
      continue;
      localObject = "";
    }
    label917:
    akrc.a(this.jdField_a_of_type_Akrc).a(2, null);
    return;
    label932:
    akrc.a(this.jdField_a_of_type_Akrc).a(paramInt, paramaksc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akrf
 * JD-Core Version:    0.7.0.1
 */