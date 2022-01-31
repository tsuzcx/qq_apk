import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.richmedia.subtitles.PacmanParcelItem;
import com.tencent.mobileqq.activity.richmedia.subtitles.WordingItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ahmf
  extends ahls
{
  private final int jdField_a_of_type_Int = 4;
  private ahmi jdField_a_of_type_Ahmi;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  private LinkedList<ahlw> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<Long, ArrayList<ahmh>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int = 102;
  private ahmi jdField_b_of_type_Ahmi;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Map<Integer, LinkedList<ahmh>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_c_of_type_Int = 136;
  private ahmi jdField_c_of_type_Ahmi;
  private int d = 150;
  private int e = 30;
  private int f = 25;
  private int g = 6;
  
  private float a(int paramInt)
  {
    return this.jdField_b_of_type_Int * paramInt + this.jdField_c_of_type_Int;
  }
  
  private int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 4) && (this.jdField_b_of_type_JavaUtilMap.size() < 4)) {
      while (paramInt < 4)
      {
        List localList = (List)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        if ((localList != null) && (localList.size() > 0)) {
          paramInt += 1;
        } else {
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  private ArrayList<PacmanParcelItem> a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      paramArrayOfByte = new ArrayList();
      localParcel.readTypedList(paramArrayOfByte, PacmanParcelItem.CREATOR);
      if (localParcel != null) {
        localParcel.recycle();
      }
      return paramArrayOfByte;
    }
    return new ArrayList();
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, String paramString, ArrayList<ahmh> paramArrayList, int paramInt1, int paramInt2, float paramFloat)
  {
    LinkedList localLinkedList = (LinkedList)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt2));
    if (localLinkedList == null)
    {
      localLinkedList = new LinkedList();
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt2), localLinkedList);
    }
    for (;;)
    {
      int i;
      if (paramInt1 >= 0)
      {
        i = paramInt1;
        if (paramInt1 <= this.jdField_a_of_type_JavaUtilLinkedList.size()) {}
      }
      else
      {
        i = 0;
      }
      ahlw localahlw = (ahlw)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
      float f4 = a(paramInt2);
      float f2 = (int)a(true);
      float f1;
      if (localLinkedList.size() == 0) {
        f1 = f2;
      }
      for (;;)
      {
        paramString = new ahmh(paramLong1, a(paramLong2), a(), b(), paramFloat, d(), paramString, localahlw, f1, f4, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsTypeface);
        paramArrayList.add(paramString);
        localLinkedList.add(paramString);
        return;
        ahmh localahmh = (ahmh)localLinkedList.getLast();
        f1 = localahmh.a(6);
        float f3 = localahmh.a(3) + f1 + this.d;
        f1 = f2;
        if (f3 > f2) {
          f1 = f3;
        }
      }
    }
  }
  
  private byte[] a(ArrayList<PacmanParcelItem> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.writeTypedList(paramArrayList);
      paramArrayList = localParcel.marshall();
      localParcel.recycle();
      return paramArrayList;
    }
    return null;
  }
  
  private float c()
  {
    if (this.jdField_c_of_type_Ahmi == null) {
      this.jdField_c_of_type_Ahmi = new ahmi(this.g, 2);
    }
    int i = this.jdField_c_of_type_Ahmi.a();
    if ((this.jdField_a_of_type_ArrayOfFloat != null) && (i >= 0) && (i < this.jdField_a_of_type_ArrayOfFloat.length)) {
      return this.jdField_a_of_type_ArrayOfFloat[i] * c() / 1000.0F;
    }
    return (i + this.f) * this.e * c() / 1000.0F;
  }
  
  private int e()
  {
    if (this.jdField_a_of_type_Ahmi == null) {
      this.jdField_a_of_type_Ahmi = new ahmi(4, 2);
    }
    return this.jdField_a_of_type_Ahmi.a();
  }
  
  private int f()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList == null) || (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0)) {
      return 0;
    }
    if (this.jdField_b_of_type_Ahmi == null) {
      this.jdField_b_of_type_Ahmi = new ahmi(this.jdField_a_of_type_JavaUtilLinkedList.size(), 2);
    }
    return this.jdField_b_of_type_Ahmi.a();
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      if (localList == null) {
        break label54;
      }
      i = localList.size() + i;
    }
    label54:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public void a()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        ((ahmh)localIterator2.next()).g();
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
  }
  
  public void a(Context paramContext, String paramString)
  {
    float f1 = 1.0F;
    if (paramContext != null) {
      f1 = paramContext.getResources().getDisplayMetrics().density;
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130841705);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130841706);
      f1 = f1 / 2.0F * a();
      this.jdField_a_of_type_JavaUtilLinkedList.add(new ahlw(28.0F * f1, 72.0F * f1, 42.0F * f1, 10.0F * f1, 8.0F * f1, 4.0F * f1));
      this.jdField_a_of_type_JavaUtilLinkedList.add(new ahlw(34.0F * f1, 76.0F * f1, 52.0F * f1, 10.0F * f1, 8.0F * f1, 4.0F * f1));
      this.jdField_a_of_type_JavaUtilLinkedList.add(new ahlw(38.0F * f1, 90.0F * f1, 58.0F * f1, 10.0F * f1, 8.0F * f1, 4.0F * f1));
      this.jdField_a_of_type_JavaUtilLinkedList.add(new ahlw(48.0F * f1, 102.0F * f1, 70.0F * f1, 10.0F * f1, 8.0F * f1, 4.0F * f1));
      this.jdField_b_of_type_Int = ((int)(this.jdField_b_of_type_Int * f1));
      this.jdField_c_of_type_Int = ((int)(this.jdField_c_of_type_Int * f1));
      this.d = ((int)(this.d * f1));
      this.e = ((int)(this.e * f1));
      f1 = paramContext.getResources().getDisplayMetrics().widthPixels * 60 * f1 / 375.0F;
      this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.5F * f1, 1.0F * f1, 1.5F * f1, 2.0F * f1, 2.5F * f1, f1 * 3.0F };
      this.jdField_a_of_type_AndroidGraphicsTypeface = a(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(WordingItem paramWordingItem)
  {
    if (paramWordingItem == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseAnimDrawer", 2, "setText ：" + paramWordingItem.jdField_a_of_type_JavaLangString + " time:" + paramWordingItem.b + "-" + paramWordingItem.c);
    }
    ArrayList localArrayList = a(paramWordingItem.jdField_a_of_type_ArrayOfByte);
    Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramWordingItem.jdField_a_of_type_Long));
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramWordingItem.jdField_a_of_type_Long), localObject);
    }
    for (;;)
    {
      int i;
      float f1;
      int m;
      int n;
      float f2;
      int i1;
      int k;
      float f3;
      if ((localArrayList != null) && (localArrayList.size() >= 3))
      {
        i = ((PacmanParcelItem)localArrayList.get(0)).jdField_a_of_type_Int;
        j = ((PacmanParcelItem)localArrayList.get(0)).jdField_b_of_type_Int;
        f1 = ((PacmanParcelItem)localArrayList.get(0)).jdField_a_of_type_Float;
        m = ((PacmanParcelItem)localArrayList.get(1)).jdField_a_of_type_Int;
        n = ((PacmanParcelItem)localArrayList.get(1)).jdField_b_of_type_Int;
        f2 = ((PacmanParcelItem)localArrayList.get(1)).jdField_a_of_type_Float;
        i1 = ((PacmanParcelItem)localArrayList.get(2)).jdField_a_of_type_Int;
        k = ((PacmanParcelItem)localArrayList.get(2)).jdField_b_of_type_Int;
        f3 = ((PacmanParcelItem)localArrayList.get(2)).jdField_a_of_type_Float;
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "itemlist size：" + ((ArrayList)localObject).size());
        }
        if (((ArrayList)localObject).size() <= 0) {
          break label547;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ahmh)((Iterator)localObject).next()).a(paramWordingItem.jdField_a_of_type_JavaLangString);
        }
        break;
      }
      if (this.jdField_a_of_type_Ahmi == null) {
        this.jdField_a_of_type_Ahmi = new ahmi(4, 2);
      }
      int j = a(0);
      if (j >= 0)
      {
        this.jdField_a_of_type_Ahmi.a(j);
        i = j;
        label396:
        i1 = f();
        f1 = c();
        k = a(j + 1);
        if (k < 0) {
          break label521;
        }
        this.jdField_a_of_type_Ahmi.a(k);
        m = k;
        j = k;
        k = m;
        label443:
        m = f();
        f2 = c();
        k = a(k + 1);
        if (k < 0) {
          break label538;
        }
        this.jdField_a_of_type_Ahmi.a(k);
      }
      for (;;)
      {
        int i2 = f();
        f3 = c();
        n = j;
        j = i;
        i = i1;
        i1 = i2;
        break;
        i = e();
        j = 0;
        break label396;
        label521:
        m = e();
        k = j;
        j = m;
        break label443;
        label538:
        k = e();
      }
      label547:
      long l1 = paramWordingItem.jdField_a_of_type_Long;
      long l2 = paramWordingItem.b;
      a(l1, this.jdField_a_of_type_JavaUtilRandom.nextInt(300) + l2, paramWordingItem.c, paramWordingItem.jdField_a_of_type_JavaLangString, (ArrayList)localObject, i, j, f1);
      a(paramWordingItem.jdField_a_of_type_Long, paramWordingItem.b + this.jdField_a_of_type_JavaUtilRandom.nextInt(200), paramWordingItem.c, paramWordingItem.jdField_a_of_type_JavaLangString, (ArrayList)localObject, m, n, f2);
      a(paramWordingItem.jdField_a_of_type_Long, paramWordingItem.b, paramWordingItem.c, paramWordingItem.jdField_a_of_type_JavaLangString, (ArrayList)localObject, i1, k, f3);
      if ((localArrayList == null) || (localArrayList.size() != 0)) {
        break;
      }
      localObject = new PacmanParcelItem();
      ((PacmanParcelItem)localObject).jdField_b_of_type_Int = j;
      ((PacmanParcelItem)localObject).jdField_a_of_type_Int = i;
      ((PacmanParcelItem)localObject).jdField_a_of_type_Float = f1;
      localArrayList.add(localObject);
      localObject = new PacmanParcelItem();
      ((PacmanParcelItem)localObject).jdField_b_of_type_Int = n;
      ((PacmanParcelItem)localObject).jdField_a_of_type_Int = m;
      ((PacmanParcelItem)localObject).jdField_a_of_type_Float = f2;
      localArrayList.add(localObject);
      localObject = new PacmanParcelItem();
      ((PacmanParcelItem)localObject).jdField_b_of_type_Int = k;
      ((PacmanParcelItem)localObject).jdField_a_of_type_Int = i1;
      ((PacmanParcelItem)localObject).jdField_a_of_type_Float = f3;
      localArrayList.add(localObject);
      paramWordingItem.jdField_a_of_type_ArrayOfByte = a(localArrayList);
      return;
    }
  }
  
  public boolean a()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        ((ahmh)localIterator2.next()).d();
      }
    }
    return true;
  }
  
  public boolean a(Canvas paramCanvas, RenderBuffer paramRenderBuffer, long paramLong1, long paramLong2)
  {
    boolean bool2;
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0)
    {
      bool2 = false;
      return bool2;
    }
    Iterator localIterator1 = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    boolean bool1 = false;
    for (;;)
    {
      bool2 = bool1;
      if (!localIterator1.hasNext()) {
        break;
      }
      LinkedList localLinkedList = (LinkedList)localIterator1.next();
      if ((localLinkedList != null) && (localLinkedList.size() != 0))
      {
        Iterator localIterator2 = localLinkedList.iterator();
        label490:
        while (localIterator2.hasNext())
        {
          ahmh localahmh = (ahmh)localIterator2.next();
          if ((localahmh.a(2) != paramLong1) || (localLinkedList.size() <= 1)) {}
          int i;
          for (;;)
          {
            i = 1;
            if ((localahmh.a(6) > a(true)) || (localahmh.a(6) + localahmh.a(3) < 0.0F) || (localahmh.a(2) > paramLong1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("BaseAnimDrawer", 2, "invisible: posx:" + localahmh.a(6) + "  width:" + localahmh.a(3) + "  index:" + localahmh.a(2) + " curindex:" + paramLong1);
              }
              i = 0;
            }
            if ((i != 0) || (localahmh.a(6) >= 0.0F)) {
              break label364;
            }
            ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localahmh.a(1)));
            if (localArrayList != null)
            {
              localArrayList.remove(localahmh);
              if (localArrayList.size() == 0) {
                this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(localahmh.a(1)));
              }
            }
            localIterator2.remove();
            localahmh.g();
            break;
            localahmh.b(a(true));
          }
          label364:
          if (localahmh.a(2) <= paramLong1)
          {
            if (localahmh.jdField_a_of_type_Int == 1)
            {
              if (!c()) {
                localahmh.a(-1.0F * localahmh.a(5) / 2.0F);
              }
              bool2 = bool1;
              if (i != 0)
              {
                if (paramCanvas == null) {
                  break label490;
                }
                localahmh.a(paramCanvas);
              }
              for (;;)
              {
                bool2 = true;
                bool1 = bool2;
                if (i == 0) {
                  break;
                }
                bool1 = bool2;
                if (localahmh.a(6) >= a(true) / 2.0F) {
                  break;
                }
                bool1 = bool2;
                if (localahmh.a(6) <= 0.0F) {
                  break;
                }
                localahmh.jdField_a_of_type_Int = 2;
                bool1 = bool2;
                break;
                localahmh.a(paramRenderBuffer);
              }
            }
            if (!c()) {
              localahmh.a(-1.0F * localahmh.a(5) / 2.0F);
            }
            if (i != 0)
            {
              if (paramCanvas != null) {
                localahmh.a(paramCanvas);
              }
              for (;;)
              {
                bool1 = true;
                break;
                localahmh.a(paramRenderBuffer);
              }
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public boolean b()
  {
    b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahmf
 * JD-Core Version:    0.7.0.1
 */