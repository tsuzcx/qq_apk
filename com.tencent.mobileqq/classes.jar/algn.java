import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class algn
{
  public int a;
  public long a;
  public alfy a;
  public algd a;
  public algf a;
  public algp a;
  public algv a;
  public alhu a;
  public aljd a;
  public aucf a;
  public TranslateResult a;
  public String a;
  public long b = 0L;
  
  public algn()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Alfy = null;
  }
  
  public static alfv a(ArrayList<ARRecognition> paramArrayList, algn paramalgn)
  {
    alfv localalfv = new alfv();
    if (paramalgn == null) {
      return localalfv;
    }
    akze localakze = ARRecognition.a(paramArrayList, paramalgn);
    if (localakze.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localalfv;
      if (paramalgn.jdField_a_of_type_Alfy.jdField_a_of_type_Boolean) {
        paramArrayList = paramalgn.jdField_a_of_type_Alfy.jdField_a_of_type_Alfv;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.jdField_a_of_type_Int);
      return paramArrayList;
      if (localakze.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localalfv;
        if (paramalgn.jdField_a_of_type_Algd.jdField_a_of_type_Boolean) {
          paramArrayList = paramalgn.jdField_a_of_type_Algd.jdField_a_of_type_Alfv;
        }
      }
      else if (localakze.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localalfv;
        if (paramalgn.jdField_a_of_type_Alhu.jdField_a_of_type_Boolean) {
          paramArrayList = paramalgn.jdField_a_of_type_Alhu.jdField_a_of_type_Alfv;
        }
      }
      else
      {
        paramArrayList = localalfv;
        if (localakze.jdField_a_of_type_Long == 2048L)
        {
          paramArrayList = localalfv;
          if (paramalgn.jdField_a_of_type_Algv.jdField_a_of_type_Boolean) {
            paramArrayList = paramalgn.jdField_a_of_type_Algv.jdField_a_of_type_Alfv;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, algn paramalgn)
  {
    Object localObject = null;
    if (paramalgn == null) {
      return null;
    }
    akze localakze = ARRecognition.a(paramArrayList, paramalgn);
    if (localakze.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (!paramalgn.jdField_a_of_type_Alfy.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        paramalgn = alfx.a(new String(paramalgn.jdField_a_of_type_Alfy.jdField_a_of_type_ArrayOfAlfz[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramalgn != null) {
          paramArrayList = paramalgn.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramalgn = null;
        continue;
      }
      if (localakze.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localObject;
        if (!paramalgn.jdField_a_of_type_Algd.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramalgn = alfx.a(new String(paramalgn.jdField_a_of_type_Algd.jdField_a_of_type_ArrayOfAlge[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          paramArrayList = localObject;
          if (paramalgn == null) {
            continue;
          }
          paramArrayList = paramalgn.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramalgn = null;
          }
        }
      }
      if (localakze.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localObject;
        if (!paramalgn.jdField_a_of_type_Alhu.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramalgn = alfx.a(new String(paramalgn.jdField_a_of_type_Alhu.a(), "utf-8"));
          paramArrayList = localObject;
          if (paramalgn == null) {
            continue;
          }
          paramArrayList = paramalgn.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramalgn = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localakze.jdField_a_of_type_Long != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramalgn.jdField_a_of_type_Algv.jdField_a_of_type_Boolean) {
        continue;
      }
      try
      {
        paramalgn = alfx.a(new String(paramalgn.jdField_a_of_type_Algv.jdField_a_of_type_ArrayOfAlgw[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramalgn == null) {
          continue;
        }
        paramArrayList = paramalgn.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramalgn = null;
        }
      }
    }
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, algn paramalgn)
  {
    if (paramalgn == null) {
      return "";
    }
    String str = "";
    akze localakze = ARRecognition.a(paramArrayList, paramalgn);
    if (localakze.jdField_a_of_type_Long == 1L) {
      paramArrayList = paramalgn.jdField_a_of_type_Alfy.jdField_a_of_type_ArrayOfAlfz[0].jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localakze.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = paramalgn.jdField_a_of_type_Algd.jdField_a_of_type_ArrayOfAlge[0].jdField_a_of_type_JavaLangString;
      }
      else if (localakze.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = paramalgn.jdField_a_of_type_Algv.jdField_a_of_type_ArrayOfAlgw[0].jdField_a_of_type_JavaLangString;
      }
      else
      {
        paramArrayList = str;
        if (localakze.jdField_a_of_type_Long == 128L) {
          paramArrayList = paramalgn.jdField_a_of_type_Alhu.e;
        }
      }
    }
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, algn paramalgn, alfv paramalfv)
  {
    if (paramalgn == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramalfv.jdField_a_of_type_Int);
      paramArrayList = ARRecognition.a(paramArrayList, paramalgn);
      if (paramArrayList.jdField_a_of_type_Long == 1L)
      {
        paramalgn.jdField_a_of_type_Alfy.jdField_a_of_type_Alfv = paramalfv;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 2L)
      {
        paramalgn.jdField_a_of_type_Algd.jdField_a_of_type_Alfv = paramalfv;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 128L)
      {
        paramalgn.jdField_a_of_type_Alhu.jdField_a_of_type_Alfv = paramalfv;
        return;
      }
    } while (paramArrayList.jdField_a_of_type_Long != 2048L);
    paramalgn.jdField_a_of_type_Algv.jdField_a_of_type_Alfv = paramalfv;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, algn paramalgn)
  {
    boolean bool = false;
    if (paramalgn == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramalgn);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramalgn.jdField_a_of_type_Alfy.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.jdField_a_of_type_Long == 2L) {
        bool = paramalgn.jdField_a_of_type_Algd.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
        bool = paramalgn.jdField_a_of_type_Alhu.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
        bool = paramalgn.jdField_a_of_type_Algv.jdField_a_of_type_Boolean;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.jdField_a_of_type_JavaLangString + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.jdField_a_of_type_Int + ", markerResult = " + this.jdField_a_of_type_Alfy + ", objectClassifyResult = " + this.jdField_a_of_type_Algd + ", faceResult = " + this.jdField_a_of_type_Algp + ", ocrResult = " + this.jdField_a_of_type_Aucf + ", preOcrResult = " + this.jdField_a_of_type_Algf + ", questionResult = " + this.jdField_a_of_type_Aljd + ", sceneRecogResult = " + this.jdField_a_of_type_Algv + ", translateReslut = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult + ", uin = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     algn
 * JD-Core Version:    0.7.0.1
 */