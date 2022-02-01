import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import mqq.app.AppRuntime;

public class aafu
  extends aafz
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, File> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public aafu(aafb paramaafb, aaga paramaaga, String paramString)
  {
    super(paramaafb, paramaaga, paramString);
    paramaafb = a();
    if (paramaafb != null)
    {
      int i = 0;
      while (i < paramaafb.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramaaga = (String)paramaafb.jdField_a_of_type_JavaUtilArrayList.get(i);
        paramString = a(paramaaga, ".mp4");
        paramaafb.jdField_b_of_type_JavaUtilArrayList.add(paramString);
        if ((!new File(paramString).exists()) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramaaga)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramaaga);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramaaga, new File(paramString));
        }
        i += 1;
      }
      if (!TextUtils.isEmpty(paramaafb.jdField_b_of_type_JavaLangString))
      {
        paramaaga = new File(a(paramaafb.jdField_b_of_type_JavaLangString, ".m4a"));
        if (!paramaaga.exists())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramaafb.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramaafb.jdField_b_of_type_JavaLangString, new File(paramaaga.getAbsolutePath()));
        }
        paramaafb.d = paramaaga.getAbsolutePath();
      }
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString1 = UUID.nameUUIDFromBytes(paramString1.getBytes());
    paramString1 = b().getAbsolutePath() + File.separator + "v_" + paramString1.toString() + paramString2;
    paramString2 = new File(paramString1);
    if (!paramString2.getParentFile().exists()) {
      paramString2.mkdirs();
    }
    return paramString1;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new Bundle();
    aafl localaafl = a();
    if (localaafl.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Aaga.b(this);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new bhyo(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, this.c);
      ((bhyo)localObject2).b = 3;
      this.jdField_a_of_type_Aafb.a().a((bhyo)localObject2, new aafv(this, localaafl, localArrayList, l), (Bundle)localObject1);
      label111:
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.c);
      }
    }
    else
    {
      try
      {
        localObject1 = localaafl.jdField_b_of_type_JavaUtilArrayList.iterator();
        int i = 1;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          File localFile = new File(a() + File.separator + "v_" + i + ".mp4");
          localArrayList.add(localFile.getAbsolutePath());
          if (localFile.exists())
          {
            i += 1;
          }
          else
          {
            if (!localFile.exists()) {
              localFile.createNewFile();
            }
            zeb.a(new File((String)localObject2), localFile);
            i += 1;
          }
        }
        b();
      }
      catch (IOException localIOException)
      {
        QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
        this.jdField_a_of_type_Aaga.a(this);
        localaafl.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        this.jdField_a_of_type_Aaga.b(this);
        this.jdField_a_of_type_Aafz = new aafm(this.jdField_a_of_type_Aafb, this.jdField_a_of_type_Aaga, this.c, localaafl.jdField_b_of_type_JavaUtilArrayList, localaafl.d, localaafl.c);
        if (!VideoEnvironment.checkAVCodecLoadIsOK((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
    }
    for (;;)
    {
      QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - l));
      break label111;
      break;
      if (localaafl.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Aaga.b(this.jdField_a_of_type_Aafz);
      }
      else
      {
        this.jdField_a_of_type_Aafz.d = "lib not ready";
        this.jdField_a_of_type_Aaga.a(this.jdField_a_of_type_Aafz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafu
 * JD-Core Version:    0.7.0.1
 */