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

public class aatw
  extends aaub
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, File> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public aatw(aatd paramaatd, aauc paramaauc, String paramString)
  {
    super(paramaatd, paramaauc, paramString);
    paramaatd = a();
    int i = 0;
    while (i < paramaatd.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramaauc = (String)paramaatd.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramString = a(paramaauc, ".mp4");
      paramaatd.jdField_b_of_type_JavaUtilArrayList.add(paramString);
      if ((!new File(paramString).exists()) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramaauc)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramaauc);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramaauc, new File(paramString));
      }
      i += 1;
    }
    if (!TextUtils.isEmpty(paramaatd.jdField_b_of_type_JavaLangString))
    {
      paramaauc = new File(a(paramaatd.jdField_b_of_type_JavaLangString, ".m4a"));
      if (!paramaauc.exists())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramaatd.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramaatd.jdField_b_of_type_JavaLangString, new File(paramaauc.getAbsolutePath()));
      }
      paramaatd.d = paramaauc.getAbsolutePath();
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
    aatn localaatn = a();
    if (localaatn.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Aauc.b(this);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new bihu(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, this.c);
      ((bihu)localObject2).b = 3;
      this.jdField_a_of_type_Aatd.a().a((bihu)localObject2, new aatx(this, localaatn, localArrayList, l), (Bundle)localObject1);
      label111:
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.c);
      }
    }
    else
    {
      try
      {
        localObject1 = localaatn.jdField_b_of_type_JavaUtilArrayList.iterator();
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
            zom.a(new File((String)localObject2), localFile);
            i += 1;
          }
        }
        b();
      }
      catch (IOException localIOException)
      {
        QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
        this.jdField_a_of_type_Aauc.a(this);
        localaatn.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        this.jdField_a_of_type_Aauc.b(this);
        this.jdField_a_of_type_Aaub = new aato(this.jdField_a_of_type_Aatd, this.jdField_a_of_type_Aauc, this.c, localaatn.jdField_b_of_type_JavaUtilArrayList, localaatn.d, localaatn.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
    }
    for (;;)
    {
      QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - l));
      break label111;
      break;
      if (localaatn.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Aauc.b(this.jdField_a_of_type_Aaub);
      }
      else
      {
        this.jdField_a_of_type_Aaub.d = "lib not ready";
        this.jdField_a_of_type_Aauc.a(this.jdField_a_of_type_Aaub);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatw
 * JD-Core Version:    0.7.0.1
 */