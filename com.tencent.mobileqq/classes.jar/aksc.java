import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aksc
{
  public int a;
  public long a;
  public akrn a;
  public akrs a;
  public akru a;
  public akse a;
  public aksk a;
  public aktj a;
  public akus a;
  public atfc a;
  public TranslateResult a;
  public String a;
  public long b = 0L;
  
  public aksc()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Akrn = null;
  }
  
  public static akrk a(ArrayList<ARRecognition> paramArrayList, aksc paramaksc)
  {
    akrk localakrk = new akrk();
    if (paramaksc == null) {
      return localakrk;
    }
    akkt localakkt = ARRecognition.a(paramArrayList, paramaksc);
    if (localakkt.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localakrk;
      if (paramaksc.jdField_a_of_type_Akrn.jdField_a_of_type_Boolean) {
        paramArrayList = paramaksc.jdField_a_of_type_Akrn.jdField_a_of_type_Akrk;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.jdField_a_of_type_Int);
      return paramArrayList;
      if (localakkt.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localakrk;
        if (paramaksc.jdField_a_of_type_Akrs.jdField_a_of_type_Boolean) {
          paramArrayList = paramaksc.jdField_a_of_type_Akrs.jdField_a_of_type_Akrk;
        }
      }
      else if (localakkt.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localakrk;
        if (paramaksc.jdField_a_of_type_Aktj.jdField_a_of_type_Boolean) {
          paramArrayList = paramaksc.jdField_a_of_type_Aktj.jdField_a_of_type_Akrk;
        }
      }
      else
      {
        paramArrayList = localakrk;
        if (localakkt.jdField_a_of_type_Long == 2048L)
        {
          paramArrayList = localakrk;
          if (paramaksc.jdField_a_of_type_Aksk.jdField_a_of_type_Boolean) {
            paramArrayList = paramaksc.jdField_a_of_type_Aksk.jdField_a_of_type_Akrk;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, aksc paramaksc)
  {
    Object localObject = null;
    if (paramaksc == null) {
      return null;
    }
    akkt localakkt = ARRecognition.a(paramArrayList, paramaksc);
    if (localakkt.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (!paramaksc.jdField_a_of_type_Akrn.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        paramaksc = akrm.a(new String(paramaksc.jdField_a_of_type_Akrn.jdField_a_of_type_ArrayOfAkro[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramaksc != null) {
          paramArrayList = paramaksc.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramaksc = null;
        continue;
      }
      if (localakkt.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localObject;
        if (!paramaksc.jdField_a_of_type_Akrs.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramaksc = akrm.a(new String(paramaksc.jdField_a_of_type_Akrs.jdField_a_of_type_ArrayOfAkrt[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          paramArrayList = localObject;
          if (paramaksc == null) {
            continue;
          }
          paramArrayList = paramaksc.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramaksc = null;
          }
        }
      }
      if (localakkt.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localObject;
        if (!paramaksc.jdField_a_of_type_Aktj.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramaksc = akrm.a(new String(paramaksc.jdField_a_of_type_Aktj.a(), "utf-8"));
          paramArrayList = localObject;
          if (paramaksc == null) {
            continue;
          }
          paramArrayList = paramaksc.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramaksc = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localakkt.jdField_a_of_type_Long != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramaksc.jdField_a_of_type_Aksk.jdField_a_of_type_Boolean) {
        continue;
      }
      try
      {
        paramaksc = akrm.a(new String(paramaksc.jdField_a_of_type_Aksk.jdField_a_of_type_ArrayOfAksl[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramaksc == null) {
          continue;
        }
        paramArrayList = paramaksc.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramaksc = null;
        }
      }
    }
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, aksc paramaksc)
  {
    if (paramaksc == null) {
      return "";
    }
    String str = "";
    akkt localakkt = ARRecognition.a(paramArrayList, paramaksc);
    if (localakkt.jdField_a_of_type_Long == 1L) {
      paramArrayList = paramaksc.jdField_a_of_type_Akrn.jdField_a_of_type_ArrayOfAkro[0].jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localakkt.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = paramaksc.jdField_a_of_type_Akrs.jdField_a_of_type_ArrayOfAkrt[0].jdField_a_of_type_JavaLangString;
      }
      else if (localakkt.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = paramaksc.jdField_a_of_type_Aksk.jdField_a_of_type_ArrayOfAksl[0].jdField_a_of_type_JavaLangString;
      }
      else
      {
        paramArrayList = str;
        if (localakkt.jdField_a_of_type_Long == 128L) {
          paramArrayList = paramaksc.jdField_a_of_type_Aktj.e;
        }
      }
    }
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, aksc paramaksc, akrk paramakrk)
  {
    if (paramaksc == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramakrk.jdField_a_of_type_Int);
      paramArrayList = ARRecognition.a(paramArrayList, paramaksc);
      if (paramArrayList.jdField_a_of_type_Long == 1L)
      {
        paramaksc.jdField_a_of_type_Akrn.jdField_a_of_type_Akrk = paramakrk;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 2L)
      {
        paramaksc.jdField_a_of_type_Akrs.jdField_a_of_type_Akrk = paramakrk;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 128L)
      {
        paramaksc.jdField_a_of_type_Aktj.jdField_a_of_type_Akrk = paramakrk;
        return;
      }
    } while (paramArrayList.jdField_a_of_type_Long != 2048L);
    paramaksc.jdField_a_of_type_Aksk.jdField_a_of_type_Akrk = paramakrk;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, aksc paramaksc)
  {
    boolean bool = false;
    if (paramaksc == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramaksc);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramaksc.jdField_a_of_type_Akrn.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.jdField_a_of_type_Long == 2L) {
        bool = paramaksc.jdField_a_of_type_Akrs.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
        bool = paramaksc.jdField_a_of_type_Aktj.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
        bool = paramaksc.jdField_a_of_type_Aksk.jdField_a_of_type_Boolean;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.jdField_a_of_type_JavaLangString + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.jdField_a_of_type_Int + ", markerResult = " + this.jdField_a_of_type_Akrn + ", objectClassifyResult = " + this.jdField_a_of_type_Akrs + ", faceResult = " + this.jdField_a_of_type_Akse + ", ocrResult = " + this.jdField_a_of_type_Atfc + ", preOcrResult = " + this.jdField_a_of_type_Akru + ", questionResult = " + this.jdField_a_of_type_Akus + ", sceneRecogResult = " + this.jdField_a_of_type_Aksk + ", translateReslut = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult + ", uin = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aksc
 * JD-Core Version:    0.7.0.1
 */