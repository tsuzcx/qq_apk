import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.richmedia.subtitles.WordingItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahyu
  extends ahyk
{
  private int jdField_a_of_type_Int = 522;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private List<ahyt> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b = 350;
  private int c = 270;
  private int d = 40;
  private int e = 44;
  private int f = 30;
  private int g = -1;
  private int h = -136515;
  private int i = 4;
  private int j = 3;
  private int k = 3000;
  
  private void a(ahyt paramahyt)
  {
    if (paramahyt == null) {}
    label60:
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label60;
        }
        ahyt localahyt = (ahyt)localIterator.next();
        if (localahyt == paramahyt) {
          break;
        }
        localIterator.remove();
        localahyt.jdField_a_of_type_Ahyv.g();
        localahyt.jdField_b_of_type_Ahyv.g();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ahyt localahyt = (ahyt)localIterator.next();
      if (localahyt != null)
      {
        localahyt.jdField_a_of_type_Ahyv.g();
        localahyt.jdField_b_of_type_Ahyv.g();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(Context paramContext, String paramString)
  {
    float f1 = 1.0F;
    if (paramContext != null) {
      f1 = paramContext.getResources().getDisplayMetrics().density;
    }
    f1 = f1 / 2.0F * a();
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * f1));
    this.b = ((int)(this.b * f1));
    this.c = ((int)(this.c * f1));
    this.d = ((int)(this.d * f1));
    this.e = ((int)(this.e * f1));
    this.f = ((int)(this.f * f1));
    this.i = ((int)(this.i * f1));
    this.j = ((int)(f1 * this.j));
    this.jdField_a_of_type_AndroidGraphicsTypeface = a(paramString);
  }
  
  public void a(WordingItem paramWordingItem)
  {
    if (paramWordingItem == null) {}
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BaseAnimDrawer", 2, "setText ：" + paramWordingItem.jdField_a_of_type_JavaLangString + " ID:" + paramWordingItem.jdField_a_of_type_Long + " baseIndex:" + a(paramWordingItem.jdField_b_of_type_Long) + " time:" + paramWordingItem.jdField_b_of_type_Long + "-" + paramWordingItem.c);
      }
      l = paramWordingItem.jdField_a_of_type_Long;
    } while ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (((ahyt)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long > l));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    ahyt localahyt;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localahyt = (ahyt)localIterator.next();
    } while (localahyt.jdField_a_of_type_Long != paramWordingItem.jdField_a_of_type_Long);
    for (;;)
    {
      if (localahyt != null)
      {
        if (localahyt.jdField_a_of_type_Ahyv != null)
        {
          localahyt.jdField_a_of_type_Ahyv.a(paramWordingItem.jdField_a_of_type_JavaLangString);
          if (localahyt.jdField_b_of_type_Ahyv == null) {
            break label314;
          }
          localahyt.jdField_b_of_type_Ahyv.a(paramWordingItem.jdField_b_of_type_JavaLangString);
        }
        for (;;)
        {
          localahyt.jdField_b_of_type_Long = (paramWordingItem.c - paramWordingItem.jdField_b_of_type_Long);
          return;
          localahyt.jdField_a_of_type_Ahyv = new ahyv(l, a(paramWordingItem.jdField_b_of_type_Long), d(), paramWordingItem.jdField_a_of_type_JavaLangString, this.e, this.g, this.i, this.d, this.c, a(true) - this.d - this.d, -1.0F, this.jdField_a_of_type_AndroidGraphicsTypeface);
          break;
          label314:
          localahyt.jdField_b_of_type_Ahyv = new ahyv(l, a(paramWordingItem.jdField_b_of_type_Long), d(), paramWordingItem.jdField_b_of_type_JavaLangString, this.f, this.h, this.j, this.d, this.c, a(true) - this.d - this.d, -1.0F, this.jdField_a_of_type_AndroidGraphicsTypeface);
        }
      }
      localahyt = new ahyt();
      localahyt.jdField_a_of_type_Long = paramWordingItem.jdField_a_of_type_Long;
      localahyt.jdField_a_of_type_Ahyv = new ahyv(l, a(paramWordingItem.jdField_b_of_type_Long), d(), paramWordingItem.jdField_a_of_type_JavaLangString, this.e, this.g, this.i, this.d, this.c, a(true) - this.d - this.d, -1.0F, this.jdField_a_of_type_AndroidGraphicsTypeface);
      localahyt.jdField_b_of_type_Ahyv = new ahyv(l, a(paramWordingItem.jdField_b_of_type_Long), d(), paramWordingItem.jdField_b_of_type_JavaLangString, this.f, this.h, this.j, this.d, this.c, a(true) - this.d - this.d, -1.0F, this.jdField_a_of_type_AndroidGraphicsTypeface);
      localahyt.jdField_b_of_type_Long = (paramWordingItem.c - paramWordingItem.jdField_b_of_type_Long);
      this.jdField_a_of_type_JavaUtilList.add(localahyt);
      return;
      localahyt = null;
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ahyt localahyt = (ahyt)localIterator.next();
      if (localahyt.jdField_b_of_type_Ahyv != null) {
        localahyt.jdField_b_of_type_Ahyv.d();
      }
      if (localahyt.jdField_a_of_type_Ahyv != null) {
        localahyt.jdField_a_of_type_Ahyv.d();
      }
    }
    return true;
  }
  
  public boolean a(Canvas paramCanvas, RenderBuffer paramRenderBuffer, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject = null;
    ahyt localahyt;
    long l;
    if (localIterator.hasNext())
    {
      localahyt = (ahyt)localIterator.next();
      l = localahyt.jdField_a_of_type_Ahyv.a(2);
      if ((!QLog.isColorLevel()) || ((l <= paramLong1) && ((paramLong1 - l) * paramLong2 < this.k + localahyt.jdField_b_of_type_Long)))
      {
        localObject = localahyt;
        if (!QLog.isColorLevel()) {}
      }
    }
    for (;;)
    {
      break;
      if (l <= paramLong1)
      {
        localIterator.remove();
        localahyt.jdField_a_of_type_Ahyv.g();
        localahyt.jdField_b_of_type_Ahyv.g();
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "removed");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {}
        a(localObject);
        if (localObject != null)
        {
          float f1 = localObject.jdField_a_of_type_Ahyv.a(4);
          float f2 = localObject.jdField_b_of_type_Ahyv.a(4);
          if ((b() == 1) || (b() == 0))
          {
            localObject.jdField_a_of_type_Ahyv.a(7, b(true) - (f1 + f2 + this.jdField_a_of_type_Int));
            localObject.jdField_b_of_type_Ahyv.a(7, b(true) - (f2 + this.jdField_a_of_type_Int));
            if (paramCanvas == null) {
              break label401;
            }
            localObject.jdField_a_of_type_Ahyv.a(paramCanvas);
            localObject.jdField_b_of_type_Ahyv.a(paramCanvas);
          }
          for (;;)
          {
            return true;
            if (b() == 2)
            {
              localObject.jdField_a_of_type_Ahyv.a(7, b(true) - (f1 + f2 + this.b));
              localObject.jdField_b_of_type_Ahyv.a(7, b(true) - (f2 + this.b));
              break;
            }
            localObject.jdField_a_of_type_Ahyv.a(7, b(true) - (f1 + f2 + this.c));
            localObject.jdField_b_of_type_Ahyv.a(7, b(true) - (f2 + this.c));
            break;
            label401:
            localObject.jdField_a_of_type_Ahyv.a(paramRenderBuffer);
            localObject.jdField_b_of_type_Ahyv.a(paramRenderBuffer);
          }
        }
        return false;
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public boolean b()
  {
    b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahyu
 * JD-Core Version:    0.7.0.1
 */