import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class aicx
  implements abjt
{
  public static final Object a;
  public static final Object b;
  int jdField_a_of_type_Int;
  aidu jdField_a_of_type_Aidu = new aidu();
  aidw jdField_a_of_type_Aidw;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  List<aidw> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  aidw jdField_b_of_type_Aidw;
  List<aidw> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  List<aidw> jdField_c_of_type_JavaUtilList = new ArrayList();
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  List<Object> jdField_d_of_type_JavaUtilList = new ArrayList();
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = -1;
  boolean jdField_e_of_type_Boolean = false;
  int f;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
  }
  
  public aicx(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  private void a(int paramInt, String paramString, AIOFilePicData paramAIOFilePicData)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      case 17: 
      case 19: 
      default: 
        return;
      case 18: 
        paramAIOFilePicData.jdField_a_of_type_Boolean = true;
        return;
      case 20: 
        paramAIOFilePicData.jdField_b_of_type_Boolean = true;
        return;
      }
      paramAIOFilePicData.jdField_c_of_type_Boolean = true;
      return;
    }
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      return;
    case 16: 
      paramAIOFilePicData.jdField_b_of_type_JavaLangString = paramString;
      return;
    case 18: 
      paramAIOFilePicData.jdField_c_of_type_JavaLangString = paramString;
      return;
    }
    paramAIOFilePicData.d = paramString;
  }
  
  private void a(int paramInt, String paramString, AIOImageData paramAIOImageData)
  {
    if ("I:E".equals(paramString)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      paramAIOImageData.jdField_b_of_type_Boolean = true;
      return;
      paramAIOImageData.jdField_c_of_type_Boolean = true;
      return;
      paramAIOImageData.jdField_a_of_type_Boolean = true;
      return;
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        return;
      case 1: 
        paramAIOImageData.jdField_a_of_type_JavaLangString = paramString;
        return;
      case 2: 
        paramAIOImageData.jdField_b_of_type_JavaLangString = paramString;
      }
    } while ((paramAIOImageData.g) || (!new File(paramAIOImageData.jdField_a_of_type_JavaLangString + "_hd").exists()));
    paramAIOImageData.jdField_a_of_type_JavaLangString += "_hd";
    return;
    paramAIOImageData.jdField_c_of_type_JavaLangString = paramString;
    return;
    paramAIOImageData.d = paramString;
  }
  
  private void a(int paramInt, String paramString, AIOShortVideoData paramAIOShortVideoData)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        paramAIOShortVideoData.jdField_a_of_type_Boolean = true;
        return;
      }
      paramAIOShortVideoData.jdField_b_of_type_Boolean = true;
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramAIOShortVideoData.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    paramAIOShortVideoData.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    List localList;
    int i;
    label14:
    Object localObject;
    if (paramBoolean)
    {
      localList = this.jdField_d_of_type_JavaUtilList;
      i = 0;
      if (i >= localList.size()) {
        break label235;
      }
      localObject = localList.get(i);
      if ((!paramBoolean) || (aidw.class.isInstance(localObject))) {
        break label70;
      }
    }
    label70:
    label209:
    do
    {
      do
      {
        do
        {
          do
          {
            i += 1;
            break label14;
            localList = this.jdField_b_of_type_JavaUtilList;
            break;
            localObject = ((aidw)localObject).a;
            if (!AIOImageData.class.isInstance(localObject)) {
              break label129;
            }
            localObject = (AIOImageData)localObject;
          } while ((((AIOImageData)localObject).jdField_f_of_type_Long != paramLong) || (((AIOImageData)localObject).jdField_f_of_type_Int != paramInt1));
          a(paramInt2, paramString, (AIOImageData)localObject);
          return i;
          if (!AIOShortVideoData.class.isInstance(localObject)) {
            break label169;
          }
          localObject = (AIOShortVideoData)localObject;
        } while (((AIOShortVideoData)localObject).jdField_f_of_type_Long != paramLong);
        a(paramInt2, paramString, (AIOShortVideoData)localObject);
        return i;
        if (!AIOFilePicData.class.isInstance(localObject)) {
          break label209;
        }
        localObject = (AIOFilePicData)localObject;
      } while (((AIOFilePicData)localObject).jdField_f_of_type_Long != paramLong);
      a(paramInt2, paramString, (AIOFilePicData)localObject);
      return i;
    } while ((!AIOFileVideoData.class.isInstance(localObject)) || (((AIOFileVideoData)localObject).jdField_f_of_type_Long != paramLong));
    label129:
    label169:
    return i;
    label235:
    return -1;
  }
  
  public aidw a()
  {
    return this.jdField_b_of_type_Aidw;
  }
  
  public aidw a(int paramInt)
  {
    if ((paramInt < this.jdField_b_of_type_JavaUtilList.size()) && (paramInt >= 0)) {
      return (aidw)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public aidw a(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          aidw localaidw = (aidw)localIterator.next();
          if (localaidw.a.jdField_f_of_type_Long != paramLong) {
            continue;
          }
          if (localaidw != null)
          {
            this.jdField_a_of_type_JavaUtilList.remove(localaidw);
            this.jdField_b_of_type_JavaUtilList.remove(localaidw);
            a(true, this.jdField_a_of_type_JavaUtilList);
          }
          return localaidw;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_d_of_type_JavaUtilList.get(paramInt);
  }
  
  String a(Calendar paramCalendar, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = paramCalendar.get(1);
    int j = localCalendar.get(1);
    int k = localCalendar.get(2);
    if ((i == j) && (paramCalendar.get(6) - localCalendar.get(6) < 7)) {
      return "7天内";
    }
    return String.format(Locale.CHINA, "%d年%d月", new Object[] { Integer.valueOf(j), Integer.valueOf(k + 1) });
  }
  
  public List<aidw> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<aidw> a(List<aidw> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_d_of_type_Boolean)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aidw localaidw = (aidw)paramList.next();
        if (!AIOImageProviderService.a(localaidw.a)) {
          localArrayList.add(localaidw);
        }
      }
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_d_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      a(false, this.jdField_a_of_type_JavaUtilList);
      this.jdField_f_of_type_Int = this.jdField_d_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_Aidw);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Aidw = a(paramInt);
    this.jdField_f_of_type_Int = this.jdField_d_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_Aidw);
  }
  
  public void a(aidw paramaidw)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Aidw = paramaidw;
    this.jdField_b_of_type_Aidw.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Aidw = this.jdField_b_of_type_Aidw;
    this.jdField_a_of_type_JavaUtilList.add(paramaidw);
    this.jdField_b_of_type_JavaUtilList.add(paramaidw);
    a(false, this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      Collections.reverse(this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_JavaUtilList.size() - 1 - this.jdField_a_of_type_Int);
    }
  }
  
  public void a(boolean paramBoolean, List<aidw> paramList)
  {
    boolean bool = false;
    if (this.jdField_d_of_type_Int == 0) {
      return;
    }
    int i;
    if (paramBoolean)
    {
      this.jdField_d_of_type_JavaUtilList.clear();
      this.jdField_e_of_type_Int = -1;
      this.jdField_a_of_type_JavaLangString = null;
      if (this.jdField_a_of_type_JavaUtilCalendar == null)
      {
        this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
        this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(bcrg.a() * 1000L);
      }
      i = paramList.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label284;
      }
      localObject = (aidw)paramList.get(i);
      String str = a(this.jdField_a_of_type_JavaUtilCalendar, ((aidw)localObject).a.g);
      if (!str.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = str;
        if (this.jdField_e_of_type_Int != -1)
        {
          int k = this.jdField_e_of_type_Int % this.jdField_d_of_type_Int;
          if (k > 0)
          {
            j = 0;
            for (;;)
            {
              if (j < this.jdField_d_of_type_Int - k)
              {
                this.jdField_d_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangObject);
                j += 1;
                continue;
                this.jdField_a_of_type_Aidu.a(this.jdField_d_of_type_JavaUtilList, this.jdField_d_of_type_Int);
                break;
              }
            }
          }
        }
        this.jdField_e_of_type_Int = 0;
        this.jdField_d_of_type_JavaUtilList.add(str);
        int j = 0;
        while (j < this.jdField_d_of_type_Int - 1)
        {
          this.jdField_d_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangObject);
          j += 1;
        }
      }
      this.jdField_d_of_type_JavaUtilList.add(localObject);
      this.jdField_e_of_type_Int += 1;
      i -= 1;
    }
    label284:
    Object localObject = this.jdField_a_of_type_Aidu;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (!paramList.isEmpty()) {}
    }
    else
    {
      paramBoolean = true;
    }
    ((aidu)localObject).a(paramBoolean, this.jdField_d_of_type_Int, this.jdField_d_of_type_JavaUtilList);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aidu.a(this.jdField_d_of_type_JavaUtilList, this.jdField_d_of_type_Int);
  }
  
  public boolean a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfAIORichMediaData.length - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = paramArrayOfAIORichMediaData[i];
      if ((this.jdField_a_of_type_Aidw == null) || (this.jdField_b_of_type_Aidw == null))
      {
        localObject = new aidw((AIORichMediaData)localObject);
        this.jdField_b_of_type_Aidw = ((aidw)localObject);
        this.jdField_a_of_type_Aidw = ((aidw)localObject);
      }
    }
    i = 0;
    if (i < paramArrayOfAIORichMediaData.length)
    {
      localObject = paramArrayOfAIORichMediaData[i];
      if (this.jdField_a_of_type_Boolean) {
        localArrayList.add(new aidw((AIORichMediaData)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_a_of_type_Aidw.a.jdField_f_of_type_Long == ((AIORichMediaData)localObject).jdField_f_of_type_Long) && (this.jdField_a_of_type_Aidw.a.jdField_f_of_type_Int == ((AIORichMediaData)localObject).jdField_f_of_type_Int))
        {
          this.jdField_a_of_type_Aidw.jdField_d_of_type_Boolean = true;
          if (this.jdField_a_of_type_Aidw == this.jdField_b_of_type_Aidw) {
            this.jdField_c_of_type_Boolean = true;
          }
          localArrayList.add(this.jdField_a_of_type_Aidw);
        }
        else if ((this.jdField_b_of_type_Aidw.a.jdField_f_of_type_Long == ((AIORichMediaData)localObject).jdField_f_of_type_Long) && (this.jdField_b_of_type_Aidw.a.jdField_f_of_type_Int == ((AIORichMediaData)localObject).jdField_f_of_type_Int))
        {
          localArrayList.add(this.jdField_b_of_type_Aidw);
        }
        else
        {
          localArrayList.add(new aidw((AIORichMediaData)localObject));
        }
      }
    }
    if (((paramInt < 0) || (paramInt < paramArrayOfAIORichMediaData.length)) || (this.jdField_a_of_type_Boolean)) {
      this.jdField_c_of_type_JavaUtilList.addAll(0, localArrayList);
    }
    while (!this.jdField_c_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    this.jdField_b_of_type_JavaUtilList = a(localArrayList);
    if (this.jdField_b_of_type_Boolean) {
      Collections.reverse(this.jdField_b_of_type_JavaUtilList);
    }
    if (this.jdField_a_of_type_Aidw != null) {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_Aidw);
    }
    if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_b_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_Aidw);
    }
    a(true, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aidw b()
  {
    return this.jdField_a_of_type_Aidw;
  }
  
  public void b()
  {
    a(true, this.jdField_a_of_type_JavaUtilList);
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(aidw paramaidw)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramaidw);
    this.jdField_b_of_type_JavaUtilList.remove(paramaidw);
    a(true, this.jdField_a_of_type_JavaUtilList);
  }
  
  public boolean b()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    int i;
    do
    {
      return false;
      i = this.jdField_c_of_type_JavaUtilList.size();
    } while (i <= 0);
    this.jdField_b_of_type_Int += i;
    this.jdField_c_of_type_Int = (i + this.jdField_c_of_type_Int);
    this.jdField_a_of_type_JavaUtilList.addAll(0, this.jdField_c_of_type_JavaUtilList);
    List localList = a(this.jdField_c_of_type_JavaUtilList);
    a(false, localList);
    if (this.jdField_b_of_type_Boolean)
    {
      Collections.reverse(localList);
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      return true;
      this.jdField_a_of_type_Int += localList.size();
      this.jdField_b_of_type_JavaUtilList.addAll(0, localList);
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void e(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    Object localObject = a(paramInt);
    if (!aidw.class.isInstance(localObject)) {
      return;
    }
    this.jdField_b_of_type_Aidw = ((aidw)localObject);
    this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_Aidw);
  }
  
  public int f()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public int g()
  {
    return this.jdField_d_of_type_JavaUtilList.size();
  }
  
  public int h()
  {
    return g() + this.jdField_a_of_type_Aidu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicx
 * JD-Core Version:    0.7.0.1
 */