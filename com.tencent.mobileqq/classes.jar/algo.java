import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class algo
{
  public int a;
  public long a;
  public alfz a;
  public alge a;
  public algg a;
  public algq a;
  public algw a;
  public alhv a;
  public alje a;
  public aucd a;
  public TranslateResult a;
  public String a;
  public long b = 0L;
  
  public algo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Alfz = null;
  }
  
  public static alfw a(ArrayList<ARRecognition> paramArrayList, algo paramalgo)
  {
    alfw localalfw = new alfw();
    if (paramalgo == null) {
      return localalfw;
    }
    akzf localakzf = ARRecognition.a(paramArrayList, paramalgo);
    if (localakzf.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localalfw;
      if (paramalgo.jdField_a_of_type_Alfz.jdField_a_of_type_Boolean) {
        paramArrayList = paramalgo.jdField_a_of_type_Alfz.jdField_a_of_type_Alfw;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.jdField_a_of_type_Int);
      return paramArrayList;
      if (localakzf.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localalfw;
        if (paramalgo.jdField_a_of_type_Alge.jdField_a_of_type_Boolean) {
          paramArrayList = paramalgo.jdField_a_of_type_Alge.jdField_a_of_type_Alfw;
        }
      }
      else if (localakzf.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localalfw;
        if (paramalgo.jdField_a_of_type_Alhv.jdField_a_of_type_Boolean) {
          paramArrayList = paramalgo.jdField_a_of_type_Alhv.jdField_a_of_type_Alfw;
        }
      }
      else
      {
        paramArrayList = localalfw;
        if (localakzf.jdField_a_of_type_Long == 2048L)
        {
          paramArrayList = localalfw;
          if (paramalgo.jdField_a_of_type_Algw.jdField_a_of_type_Boolean) {
            paramArrayList = paramalgo.jdField_a_of_type_Algw.jdField_a_of_type_Alfw;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, algo paramalgo)
  {
    Object localObject = null;
    if (paramalgo == null) {
      return null;
    }
    akzf localakzf = ARRecognition.a(paramArrayList, paramalgo);
    if (localakzf.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (!paramalgo.jdField_a_of_type_Alfz.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        paramalgo = alfy.a(new String(paramalgo.jdField_a_of_type_Alfz.jdField_a_of_type_ArrayOfAlga[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramalgo != null) {
          paramArrayList = paramalgo.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramalgo = null;
        continue;
      }
      if (localakzf.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localObject;
        if (!paramalgo.jdField_a_of_type_Alge.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramalgo = alfy.a(new String(paramalgo.jdField_a_of_type_Alge.jdField_a_of_type_ArrayOfAlgf[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          paramArrayList = localObject;
          if (paramalgo == null) {
            continue;
          }
          paramArrayList = paramalgo.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramalgo = null;
          }
        }
      }
      if (localakzf.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localObject;
        if (!paramalgo.jdField_a_of_type_Alhv.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramalgo = alfy.a(new String(paramalgo.jdField_a_of_type_Alhv.a(), "utf-8"));
          paramArrayList = localObject;
          if (paramalgo == null) {
            continue;
          }
          paramArrayList = paramalgo.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramalgo = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localakzf.jdField_a_of_type_Long != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramalgo.jdField_a_of_type_Algw.jdField_a_of_type_Boolean) {
        continue;
      }
      try
      {
        paramalgo = alfy.a(new String(paramalgo.jdField_a_of_type_Algw.jdField_a_of_type_ArrayOfAlgx[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramalgo == null) {
          continue;
        }
        paramArrayList = paramalgo.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramalgo = null;
        }
      }
    }
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, algo paramalgo)
  {
    if (paramalgo == null) {
      return "";
    }
    String str = "";
    akzf localakzf = ARRecognition.a(paramArrayList, paramalgo);
    if (localakzf.jdField_a_of_type_Long == 1L) {
      paramArrayList = paramalgo.jdField_a_of_type_Alfz.jdField_a_of_type_ArrayOfAlga[0].jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localakzf.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = paramalgo.jdField_a_of_type_Alge.jdField_a_of_type_ArrayOfAlgf[0].jdField_a_of_type_JavaLangString;
      }
      else if (localakzf.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = paramalgo.jdField_a_of_type_Algw.jdField_a_of_type_ArrayOfAlgx[0].jdField_a_of_type_JavaLangString;
      }
      else
      {
        paramArrayList = str;
        if (localakzf.jdField_a_of_type_Long == 128L) {
          paramArrayList = paramalgo.jdField_a_of_type_Alhv.e;
        }
      }
    }
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, algo paramalgo, alfw paramalfw)
  {
    if (paramalgo == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramalfw.jdField_a_of_type_Int);
      paramArrayList = ARRecognition.a(paramArrayList, paramalgo);
      if (paramArrayList.jdField_a_of_type_Long == 1L)
      {
        paramalgo.jdField_a_of_type_Alfz.jdField_a_of_type_Alfw = paramalfw;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 2L)
      {
        paramalgo.jdField_a_of_type_Alge.jdField_a_of_type_Alfw = paramalfw;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 128L)
      {
        paramalgo.jdField_a_of_type_Alhv.jdField_a_of_type_Alfw = paramalfw;
        return;
      }
    } while (paramArrayList.jdField_a_of_type_Long != 2048L);
    paramalgo.jdField_a_of_type_Algw.jdField_a_of_type_Alfw = paramalfw;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, algo paramalgo)
  {
    boolean bool = false;
    if (paramalgo == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramalgo);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramalgo.jdField_a_of_type_Alfz.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.jdField_a_of_type_Long == 2L) {
        bool = paramalgo.jdField_a_of_type_Alge.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
        bool = paramalgo.jdField_a_of_type_Alhv.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
        bool = paramalgo.jdField_a_of_type_Algw.jdField_a_of_type_Boolean;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.jdField_a_of_type_JavaLangString + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.jdField_a_of_type_Int + ", markerResult = " + this.jdField_a_of_type_Alfz + ", objectClassifyResult = " + this.jdField_a_of_type_Alge + ", faceResult = " + this.jdField_a_of_type_Algq + ", ocrResult = " + this.jdField_a_of_type_Aucd + ", preOcrResult = " + this.jdField_a_of_type_Algg + ", questionResult = " + this.jdField_a_of_type_Alje + ", sceneRecogResult = " + this.jdField_a_of_type_Algw + ", translateReslut = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult + ", uin = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     algo
 * JD-Core Version:    0.7.0.1
 */