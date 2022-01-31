import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.richmedia.subtitles.BarrageParcelItem;
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

public class ahyh
  extends ahyk
{
  private final int jdField_a_of_type_Int = 4;
  private ahza jdField_a_of_type_Ahza;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private ArrayList<Float> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private LinkedList<Integer> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<Long, ArrayList<ahyj>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int = 150;
  private ahza jdField_b_of_type_Ahza;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private Map<Integer, LinkedList<ahyj>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_c_of_type_Int = 92;
  private ahza jdField_c_of_type_Ahza;
  private int jdField_d_of_type_Int = 136;
  private ahza jdField_d_of_type_Ahza;
  private int e = 5;
  private int f = 15;
  private int g = 25;
  private int h = 6;
  
  private float a(int paramInt)
  {
    return this.jdField_c_of_type_Int * paramInt + this.jdField_d_of_type_Int;
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
  
  private ArrayList<BarrageParcelItem> a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      paramArrayOfByte = new ArrayList();
      localParcel.readTypedList(paramArrayOfByte, BarrageParcelItem.CREATOR);
      if (localParcel != null) {
        localParcel.recycle();
      }
      return paramArrayOfByte;
    }
    return new ArrayList();
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, String paramString, ArrayList<ahyj> paramArrayList, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2)
  {
    LinkedList localLinkedList2 = (LinkedList)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt2));
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null)
    {
      localLinkedList1 = new LinkedList();
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt2), localLinkedList1);
    }
    float f1 = a(paramInt2);
    float f2 = (int)a(true);
    paramString = new ahyj(paramLong1, a(paramLong2), a(), b(), paramFloat2, d(), paramString, paramFloat1, paramInt1, f2, f1, -1.0F, this.jdField_c_of_type_Int, this.e, this.jdField_a_of_type_AndroidGraphicsTypeface);
    paramArrayList.add(paramString);
    localLinkedList1.add(paramString);
  }
  
  private byte[] a(ArrayList<BarrageParcelItem> paramArrayList)
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
    if (this.jdField_d_of_type_Ahza == null) {
      this.jdField_d_of_type_Ahza = new ahza(this.h, 2);
    }
    int i = this.jdField_d_of_type_Ahza.a();
    if ((this.jdField_a_of_type_ArrayOfFloat != null) && (i >= 0) && (i < this.jdField_a_of_type_ArrayOfFloat.length)) {
      return this.jdField_a_of_type_ArrayOfFloat[i] * c() / 1000.0F;
    }
    return (i + this.g) * this.f * c() / 1000.0F;
  }
  
  private int e()
  {
    if (this.jdField_a_of_type_Ahza == null) {
      this.jdField_a_of_type_Ahza = new ahza(4, 2);
    }
    return this.jdField_a_of_type_Ahza.a();
  }
  
  private int f()
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() == 0)) {
      return 0;
    }
    if (this.jdField_c_of_type_Ahza == null) {
      this.jdField_c_of_type_Ahza = new ahza(this.jdField_b_of_type_JavaUtilArrayList.size(), 1);
    }
    int i = this.jdField_c_of_type_Ahza.a();
    return ((Integer)this.jdField_b_of_type_JavaUtilArrayList.get(i)).intValue() | 0xFF000000;
  }
  
  private int g()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return 0;
    }
    if (this.jdField_b_of_type_Ahza == null) {
      this.jdField_b_of_type_Ahza = new ahza(this.jdField_a_of_type_JavaUtilArrayList.size(), 2);
    }
    return this.jdField_b_of_type_Ahza.a();
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
        ((ahyj)localIterator2.next()).g();
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (paramContext != null) {}
    for (float f1 = paramContext.getResources().getDisplayMetrics().density;; f1 = 1.0F)
    {
      f1 = f1 / 2.0F * a();
      this.jdField_a_of_type_JavaUtilArrayList.add(Float.valueOf(32.0F * f1));
      this.jdField_a_of_type_JavaUtilArrayList.add(Float.valueOf(44.0F * f1));
      this.jdField_a_of_type_JavaUtilArrayList.add(Float.valueOf(56.0F * f1));
      this.jdField_a_of_type_JavaUtilArrayList.add(Float.valueOf(60.0F * f1));
      this.jdField_a_of_type_JavaUtilArrayList.add(Float.valueOf(86.0F * f1));
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(13405665));
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(5756121));
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(16763139));
      this.jdField_c_of_type_Int = ((int)(this.jdField_c_of_type_Int * f1));
      this.jdField_d_of_type_Int = ((int)(this.jdField_d_of_type_Int * f1));
      this.e = ((int)(this.e * f1));
      this.jdField_b_of_type_Int = ((int)(this.jdField_b_of_type_Int * f1));
      this.f = ((int)(this.f * f1));
      f1 = f1 * (paramContext.getResources().getDisplayMetrics().widthPixels * 60) / 375.0F;
      this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F * f1, 1.2F * f1, 1.4F * f1, 1.6F * f1, 1.8F * f1, f1 * 2.0F };
      this.jdField_a_of_type_AndroidGraphicsTypeface = a(paramString);
      return;
    }
  }
  
  public void a(WordingItem paramWordingItem)
  {
    if (paramWordingItem == null) {}
    ArrayList localArrayList;
    int j;
    int m;
    float f1;
    int i1;
    int i3;
    int i2;
    float f2;
    int i4;
    int i;
    int k;
    float f3;
    int n;
    label417:
    label462:
    label613:
    label630:
    label639:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BaseAnimDrawer", 2, "barrage setText id：" + paramWordingItem.jdField_a_of_type_Long + "  text: " + paramWordingItem.jdField_a_of_type_JavaLangString + " time:" + paramWordingItem.b + "-" + paramWordingItem.c);
      }
      localArrayList = a(paramWordingItem.jdField_a_of_type_ArrayOfByte);
      localObject = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramWordingItem.jdField_a_of_type_Long));
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramWordingItem.jdField_a_of_type_Long), localObject);
      }
      int i5;
      for (;;)
      {
        if ((localArrayList == null) || (localArrayList.size() < 3)) {
          break label417;
        }
        i5 = ((BarrageParcelItem)localArrayList.get(0)).jdField_a_of_type_Int;
        j = ((BarrageParcelItem)localArrayList.get(0)).jdField_b_of_type_Int;
        m = ((BarrageParcelItem)localArrayList.get(0)).jdField_c_of_type_Int;
        f1 = ((BarrageParcelItem)localArrayList.get(0)).jdField_a_of_type_Float;
        i1 = ((BarrageParcelItem)localArrayList.get(1)).jdField_a_of_type_Int;
        i3 = ((BarrageParcelItem)localArrayList.get(1)).jdField_b_of_type_Int;
        i2 = ((BarrageParcelItem)localArrayList.get(1)).jdField_c_of_type_Int;
        f2 = ((BarrageParcelItem)localArrayList.get(1)).jdField_a_of_type_Float;
        i4 = ((BarrageParcelItem)localArrayList.get(2)).jdField_a_of_type_Int;
        i = ((BarrageParcelItem)localArrayList.get(2)).jdField_b_of_type_Int;
        k = ((BarrageParcelItem)localArrayList.get(2)).jdField_c_of_type_Int;
        f3 = ((BarrageParcelItem)localArrayList.get(2)).jdField_a_of_type_Float;
        n = i;
        i = i5;
        if (((ArrayList)localObject).size() <= 0) {
          break label639;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ahyj)((Iterator)localObject).next()).a(paramWordingItem.jdField_a_of_type_JavaLangString);
        }
        break;
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "item exsit, update ,size：" + ((ArrayList)localObject).size());
        }
      }
      if (this.jdField_a_of_type_Ahza == null) {
        this.jdField_a_of_type_Ahza = new ahza(4, 2);
      }
      j = a(0);
      int i6;
      if (j >= 0)
      {
        this.jdField_a_of_type_Ahza.a(j);
        i = j;
        i1 = f();
        i6 = g();
        f1 = c();
        k = a(j + 1);
        if (k < 0) {
          break label613;
        }
        this.jdField_a_of_type_Ahza.a(k);
        m = k;
        j = k;
        k = m;
        i4 = f();
        i3 = g();
        f2 = c();
        k = a(k + 1);
        if (k < 0) {
          break label630;
        }
        this.jdField_a_of_type_Ahza.a(k);
      }
      for (;;)
      {
        i5 = f();
        n = g();
        f3 = c();
        i2 = j;
        j = i6;
        m = i;
        i = i1;
        i1 = i4;
        i4 = i5;
        break;
        i = e();
        j = 0;
        break label462;
        m = e();
        k = j;
        j = m;
        break label515;
        k = e();
      }
      a(paramWordingItem.jdField_a_of_type_Long, 300L + paramWordingItem.b, paramWordingItem.c, paramWordingItem.jdField_a_of_type_JavaLangString, (ArrayList)localObject, i, ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(j)).floatValue(), m, f1);
      a(paramWordingItem.jdField_a_of_type_Long, paramWordingItem.b + 200L, paramWordingItem.c, paramWordingItem.jdField_a_of_type_JavaLangString, (ArrayList)localObject, i1, ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(i3)).floatValue(), i2, f2);
      a(paramWordingItem.jdField_a_of_type_Long, paramWordingItem.b, paramWordingItem.c, paramWordingItem.jdField_a_of_type_JavaLangString, (ArrayList)localObject, i4, ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(n)).floatValue(), k, f3);
    } while ((localArrayList == null) || (localArrayList.size() != 0));
    label515:
    Object localObject = new BarrageParcelItem();
    ((BarrageParcelItem)localObject).jdField_a_of_type_Int = i;
    ((BarrageParcelItem)localObject).jdField_c_of_type_Int = m;
    ((BarrageParcelItem)localObject).jdField_b_of_type_Int = j;
    ((BarrageParcelItem)localObject).jdField_a_of_type_Float = f1;
    localArrayList.add(localObject);
    localObject = new BarrageParcelItem();
    ((BarrageParcelItem)localObject).jdField_a_of_type_Int = i1;
    ((BarrageParcelItem)localObject).jdField_c_of_type_Int = i2;
    ((BarrageParcelItem)localObject).jdField_b_of_type_Int = i3;
    ((BarrageParcelItem)localObject).jdField_a_of_type_Float = f2;
    localArrayList.add(localObject);
    localObject = new BarrageParcelItem();
    ((BarrageParcelItem)localObject).jdField_a_of_type_Int = i4;
    ((BarrageParcelItem)localObject).jdField_c_of_type_Int = k;
    ((BarrageParcelItem)localObject).jdField_b_of_type_Int = n;
    ((BarrageParcelItem)localObject).jdField_a_of_type_Float = f3;
    localArrayList.add(localObject);
    paramWordingItem.jdField_a_of_type_ArrayOfByte = a(localArrayList);
  }
  
  public boolean a()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        ((ahyj)localIterator2.next()).d();
      }
    }
    return true;
  }
  
  public boolean a(Canvas paramCanvas, RenderBuffer paramRenderBuffer, long paramLong1, long paramLong2)
  {
    boolean bool2;
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseAnimDrawer", 2, "mID2ItemsMap size is 0.");
      }
      bool2 = false;
      return bool2;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    boolean bool1 = false;
    Object localObject1;
    do
    {
      bool2 = bool1;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (LinkedList)localIterator.next();
    } while ((localObject1 == null) || (((LinkedList)localObject1).size() == 0));
    Object localObject2 = ((LinkedList)localObject1).iterator();
    int i = 0;
    label102:
    if (((Iterator)localObject2).hasNext())
    {
      if (((ahyj)((Iterator)localObject2).next()).a(2) > paramLong1) {
        break label500;
      }
      i += 1;
    }
    label500:
    for (;;)
    {
      break label102;
      localObject1 = ((LinkedList)localObject1).iterator();
      bool2 = bool1;
      for (;;)
      {
        bool1 = bool2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ahyj)((Iterator)localObject1).next();
        if (((ahyj)localObject2).a(2) == paramLong1) {
          ((ahyj)localObject2).a(6, a(true));
        }
        int j = 1;
        if ((((ahyj)localObject2).a(6) > a(true)) || (((ahyj)localObject2).a(6) + ((ahyj)localObject2).a(3) < 0.0F) || (((ahyj)localObject2).a(2) > paramLong1))
        {
          int k = 0;
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.d("BaseAnimDrawer", 2, "barrage invisible: posx:" + ((ahyj)localObject2).a(6) + "  width:" + ((ahyj)localObject2).a(3) + "  index:" + ((ahyj)localObject2).a(2) + " curindex:" + paramLong1);
            j = k;
          }
        }
        if ((j == 0) && (((ahyj)localObject2).a(6) < 0.0F))
        {
          if (i > 1)
          {
            ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(((ahyj)localObject2).a(1)));
            if (localArrayList != null)
            {
              localArrayList.remove(localObject2);
              if (localArrayList.size() == 0) {
                this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(((ahyj)localObject2).a(1)));
              }
            }
            ((Iterator)localObject1).remove();
            ((ahyj)localObject2).g();
            i -= 1;
          }
          else
          {
            ((ahyj)localObject2).c();
          }
        }
        else if (((ahyj)localObject2).a(2) <= paramLong1)
        {
          if (!c()) {
            ((ahyj)localObject2).a();
          }
          if (paramCanvas != null) {
            ((ahyj)localObject2).a(paramCanvas);
          }
          if (paramRenderBuffer != null) {
            ((ahyj)localObject2).a(paramRenderBuffer);
          }
          bool2 = true;
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
 * Qualified Name:     ahyh
 * JD-Core Version:    0.7.0.1
 */