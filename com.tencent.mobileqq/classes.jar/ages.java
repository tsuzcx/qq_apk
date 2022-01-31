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

public class ages
  implements zec
{
  public static final Object a;
  public static final Object b;
  int jdField_a_of_type_Int;
  agfo jdField_a_of_type_Agfo = new agfo();
  agfq jdField_a_of_type_Agfq;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  List<agfq> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  agfq jdField_b_of_type_Agfq;
  List<agfq> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  List<agfq> jdField_c_of_type_JavaUtilList = new ArrayList();
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
  
  public ages(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
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
        break label683;
      }
      localObject = localList.get(i);
      if ((!paramBoolean) || (agfq.class.isInstance(localObject))) {
        break label70;
      }
    }
    label70:
    label355:
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
            localObject = ((agfq)localObject).a;
            if (!AIOImageData.class.isInstance(localObject)) {
              break label355;
            }
            localObject = (AIOImageData)localObject;
          } while ((((AIOImageData)localObject).jdField_f_of_type_Long != paramLong) || (((AIOImageData)localObject).jdField_f_of_type_Int != paramInt1));
          if ("I:E".equals(paramString)) {
            switch (paramInt2)
            {
            }
          }
          do
          {
            return i;
            ((AIOImageData)localObject).jdField_b_of_type_Boolean = true;
            return i;
            ((AIOImageData)localObject).jdField_c_of_type_Boolean = true;
            return i;
            ((AIOImageData)localObject).jdField_a_of_type_Boolean = true;
            return i;
            switch (paramInt2)
            {
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            default: 
              return i;
            case 1: 
              ((AIOImageData)localObject).jdField_a_of_type_JavaLangString = paramString;
              return i;
            case 2: 
              ((AIOImageData)localObject).jdField_b_of_type_JavaLangString = paramString;
            }
          } while ((((AIOImageData)localObject).g) || (!new File(((AIOImageData)localObject).jdField_a_of_type_JavaLangString + "_hd").exists()));
          ((AIOImageData)localObject).jdField_a_of_type_JavaLangString += "_hd";
          return i;
          ((AIOImageData)localObject).jdField_c_of_type_JavaLangString = paramString;
          return i;
          ((AIOImageData)localObject).d = paramString;
          return i;
          if (!AIOShortVideoData.class.isInstance(localObject)) {
            break label483;
          }
          localObject = (AIOShortVideoData)localObject;
        } while (((AIOShortVideoData)localObject).jdField_f_of_type_Long != paramLong);
        if ("I:E".equals(paramString))
        {
          switch (paramInt2)
          {
          default: 
            return i;
          case 0: 
            ((AIOShortVideoData)localObject).jdField_a_of_type_Boolean = true;
            return i;
          }
          ((AIOShortVideoData)localObject).jdField_b_of_type_Boolean = true;
          return i;
        }
        switch (paramInt2)
        {
        default: 
          return i;
        case 0: 
          ((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString = paramString;
          return i;
        }
        ((AIOShortVideoData)localObject).jdField_b_of_type_JavaLangString = paramString;
        return i;
        if (!AIOFilePicData.class.isInstance(localObject)) {
          break label657;
        }
        localObject = (AIOFilePicData)localObject;
      } while (((AIOFilePicData)localObject).jdField_f_of_type_Long != paramLong);
      if ("I:E".equals(paramString))
      {
        switch (paramInt2)
        {
        case 17: 
        case 19: 
        default: 
          return i;
        case 16: 
          ((AIOFilePicData)localObject).jdField_c_of_type_Boolean = true;
          return i;
        case 18: 
          ((AIOFilePicData)localObject).jdField_a_of_type_Boolean = true;
          return i;
        }
        ((AIOFilePicData)localObject).jdField_b_of_type_Boolean = true;
        return i;
      }
      switch (paramInt2)
      {
      case 17: 
      case 19: 
      default: 
        return i;
      case 16: 
        ((AIOFilePicData)localObject).jdField_b_of_type_JavaLangString = paramString;
        return i;
      case 18: 
        ((AIOFilePicData)localObject).jdField_c_of_type_JavaLangString = paramString;
        return i;
      }
      ((AIOFilePicData)localObject).d = paramString;
      return i;
    } while ((!AIOFileVideoData.class.isInstance(localObject)) || (((AIOFileVideoData)localObject).jdField_f_of_type_Long != paramLong));
    label483:
    return i;
    label657:
    label683:
    return -1;
  }
  
  public agfq a()
  {
    return this.jdField_b_of_type_Agfq;
  }
  
  public agfq a(int paramInt)
  {
    if ((paramInt < this.jdField_b_of_type_JavaUtilList.size()) && (paramInt >= 0)) {
      return (agfq)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public agfq a(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          agfq localagfq = (agfq)localIterator.next();
          if (localagfq.a.jdField_f_of_type_Long != paramLong) {
            continue;
          }
          if (localagfq != null)
          {
            this.jdField_a_of_type_JavaUtilList.remove(localagfq);
            this.jdField_b_of_type_JavaUtilList.remove(localagfq);
            a(true, this.jdField_a_of_type_JavaUtilList);
          }
          return localagfq;
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
  
  public List<agfq> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<agfq> a(List<agfq> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_d_of_type_Boolean)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        agfq localagfq = (agfq)paramList.next();
        if (!AIOImageProviderService.a(localagfq.a)) {
          localArrayList.add(localagfq);
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
      this.jdField_f_of_type_Int = this.jdField_d_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_Agfq);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Agfq = a(paramInt);
    this.jdField_f_of_type_Int = this.jdField_d_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_Agfq);
  }
  
  public void a(agfq paramagfq)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Agfq = paramagfq;
    this.jdField_b_of_type_Agfq.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Agfq = this.jdField_b_of_type_Agfq;
    this.jdField_a_of_type_JavaUtilList.add(paramagfq);
    this.jdField_b_of_type_JavaUtilList.add(paramagfq);
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
  
  public void a(boolean paramBoolean, List<agfq> paramList)
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
        this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(ayvc.a() * 1000L);
      }
      i = paramList.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label284;
      }
      localObject = (agfq)paramList.get(i);
      String str = a(this.jdField_a_of_type_JavaUtilCalendar, ((agfq)localObject).a.g);
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
                this.jdField_a_of_type_Agfo.a(this.jdField_d_of_type_JavaUtilList, this.jdField_d_of_type_Int);
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
    Object localObject = this.jdField_a_of_type_Agfo;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (!paramList.isEmpty()) {}
    }
    else
    {
      paramBoolean = true;
    }
    ((agfo)localObject).a(paramBoolean, this.jdField_d_of_type_Int, this.jdField_d_of_type_JavaUtilList);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Agfo.a(this.jdField_d_of_type_JavaUtilList, this.jdField_d_of_type_Int);
  }
  
  public boolean a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfAIORichMediaData.length - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = paramArrayOfAIORichMediaData[i];
      if ((this.jdField_a_of_type_Agfq == null) || (this.jdField_b_of_type_Agfq == null))
      {
        localObject = new agfq((AIORichMediaData)localObject);
        this.jdField_b_of_type_Agfq = ((agfq)localObject);
        this.jdField_a_of_type_Agfq = ((agfq)localObject);
      }
    }
    i = 0;
    if (i < paramArrayOfAIORichMediaData.length)
    {
      localObject = paramArrayOfAIORichMediaData[i];
      if (this.jdField_a_of_type_Boolean) {
        localArrayList.add(new agfq((AIORichMediaData)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_a_of_type_Agfq.a.jdField_f_of_type_Long == ((AIORichMediaData)localObject).jdField_f_of_type_Long) && (this.jdField_a_of_type_Agfq.a.jdField_f_of_type_Int == ((AIORichMediaData)localObject).jdField_f_of_type_Int))
        {
          this.jdField_a_of_type_Agfq.jdField_d_of_type_Boolean = true;
          if (this.jdField_a_of_type_Agfq == this.jdField_b_of_type_Agfq) {
            this.jdField_c_of_type_Boolean = true;
          }
          localArrayList.add(this.jdField_a_of_type_Agfq);
        }
        else if ((this.jdField_b_of_type_Agfq.a.jdField_f_of_type_Long == ((AIORichMediaData)localObject).jdField_f_of_type_Long) && (this.jdField_b_of_type_Agfq.a.jdField_f_of_type_Int == ((AIORichMediaData)localObject).jdField_f_of_type_Int))
        {
          localArrayList.add(this.jdField_b_of_type_Agfq);
        }
        else
        {
          localArrayList.add(new agfq((AIORichMediaData)localObject));
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
    if (this.jdField_a_of_type_Agfq != null) {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_Agfq);
    }
    if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_b_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_Agfq);
    }
    a(true, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public agfq b()
  {
    return this.jdField_a_of_type_Agfq;
  }
  
  public void b()
  {
    a(true, this.jdField_a_of_type_JavaUtilList);
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(agfq paramagfq)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramagfq);
    this.jdField_b_of_type_JavaUtilList.remove(paramagfq);
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
    if (!agfq.class.isInstance(localObject)) {
      return;
    }
    this.jdField_b_of_type_Agfq = ((agfq)localObject);
    this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_Agfq);
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
    return g() + this.jdField_a_of_type_Agfo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ages
 * JD-Core Version:    0.7.0.1
 */