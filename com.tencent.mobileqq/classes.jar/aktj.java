import android.graphics.RectF;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchDetail;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchRsp;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSkuItem;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.Rectangle;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;

public class aktj
  extends akrp
  implements akrr
{
  public static final String a;
  public int a;
  public long a;
  public aktm a;
  public aktp a;
  public aktq[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131634936);
  }
  
  public aktj()
  {
    super(2, 0);
    this.jdField_a_of_type_Int = -1;
  }
  
  public static aktm a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    int j = -1;
    float f2 = 0.0F;
    aktm localaktm = new aktm();
    int i;
    Object localObject1;
    label57:
    label106:
    Object localObject2;
    label132:
    label158:
    float f1;
    label212:
    label243:
    aktl localaktl;
    if (paramJdSearchRsp.jd_search_errorcode.has())
    {
      i = paramJdSearchRsp.jd_search_errorcode.get();
      localaktm.jdField_a_of_type_Int = i;
      if (!paramJdSearchRsp.jd_search_errormsg.has()) {
        break label633;
      }
      localObject1 = paramJdSearchRsp.jd_search_errormsg.get();
      localaktm.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (!paramJdSearchRsp.jd_search_detail.has()) {
        break label707;
      }
      localObject1 = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
      if (!((JDSearch.JdSearchDetail)localObject1).errorcode.has()) {
        break label640;
      }
      i = ((JDSearch.JdSearchDetail)localObject1).errorcode.get();
      localaktm.jdField_b_of_type_Int = i;
      if (!((JDSearch.JdSearchDetail)localObject1).errormsg.has()) {
        break label645;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).errormsg.get();
      localaktm.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      if (!((JDSearch.JdSearchDetail)localObject1).jd_more_url.has()) {
        break label651;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_more_url.get();
      localaktm.d = paramJdSearchRsp;
      if (((JDSearch.JdSearchDetail)localObject1).rectangle.has())
      {
        paramJdSearchRsp = (JDSearch.Rectangle)((JDSearch.JdSearchDetail)localObject1).rectangle.get();
        localObject2 = localaktm.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.left.has()) {
          break label657;
        }
        f1 = paramJdSearchRsp.left.get();
        ((RectF)localObject2).left = f1;
        localObject2 = localaktm.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.top.has()) {
          break label662;
        }
        f1 = paramJdSearchRsp.top.get();
        ((RectF)localObject2).top = f1;
        localObject2 = localaktm.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.right.has()) {
          break label667;
        }
        f1 = paramJdSearchRsp.right.get();
        label274:
        ((RectF)localObject2).right = f1;
        localObject2 = localaktm.jdField_a_of_type_AndroidGraphicsRectF;
        f1 = f2;
        if (paramJdSearchRsp.bottom.has()) {
          f1 = paramJdSearchRsp.bottom.get();
        }
        ((RectF)localObject2).bottom = f1;
        i = j;
        if (paramJdSearchRsp.is_user_rectangle.has()) {
          i = paramJdSearchRsp.is_user_rectangle.get();
        }
        localaktm.c = i;
      }
      if (!((JDSearch.JdSearchDetail)localObject1).jd_sku_item.has()) {
        break label672;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_sku_item.get();
      label360:
      if ((paramJdSearchRsp != null) && (!paramJdSearchRsp.isEmpty())) {
        localaktm.jdField_a_of_type_ArrayOfAktl = new aktl[paramJdSearchRsp.size()];
      }
      if ((paramJdSearchRsp == null) || (paramJdSearchRsp.size() <= 0)) {
        break label707;
      }
      localObject1 = paramJdSearchRsp.iterator();
      i = 0;
      label410:
      if (!((Iterator)localObject1).hasNext()) {
        break label707;
      }
      localObject2 = (JDSearch.JdSkuItem)((Iterator)localObject1).next();
      localaktm.jdField_a_of_type_ArrayOfAktl[i] = new aktl();
      localaktl = localaktm.jdField_a_of_type_ArrayOfAktl[i];
      if (!((JDSearch.JdSkuItem)localObject2).detail_url.has()) {
        break label677;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).detail_url.get();
      label475:
      localaktl.jdField_a_of_type_JavaLangString = paramJdSearchRsp;
      localaktl = localaktm.jdField_a_of_type_ArrayOfAktl[i];
      if (!((JDSearch.JdSkuItem)localObject2).image_url.has()) {
        break label683;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).image_url.get();
      label510:
      localaktl.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      localaktl = localaktm.jdField_a_of_type_ArrayOfAktl[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_id.has()) {
        break label689;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_id.get();
      label545:
      localaktl.c = paramJdSearchRsp;
      localaktl = localaktm.jdField_a_of_type_ArrayOfAktl[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_name.has()) {
        break label695;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_name.get();
      label580:
      localaktl.d = paramJdSearchRsp;
      localaktl = localaktm.jdField_a_of_type_ArrayOfAktl[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_price.has()) {
        break label701;
      }
    }
    label640:
    label645:
    label651:
    label657:
    label662:
    label667:
    label672:
    label677:
    label683:
    label689:
    label695:
    label701:
    for (paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_price.get();; paramJdSearchRsp = "")
    {
      localaktl.e = paramJdSearchRsp;
      i += 1;
      break label410;
      i = -1;
      break;
      label633:
      localObject1 = "";
      break label57;
      i = -1;
      break label106;
      paramJdSearchRsp = "";
      break label132;
      paramJdSearchRsp = "";
      break label158;
      f1 = 0.0F;
      break label212;
      f1 = 0.0F;
      break label243;
      f1 = 0.0F;
      break label274;
      paramJdSearchRsp = null;
      break label360;
      paramJdSearchRsp = "";
      break label475;
      paramJdSearchRsp = "";
      break label510;
      paramJdSearchRsp = "";
      break label545;
      paramJdSearchRsp = "";
      break label580;
    }
    label707:
    return localaktm;
  }
  
  private akto a()
  {
    boolean bool2 = false;
    if (c())
    {
      akto localakto = new akto();
      aktr localaktr = a();
      if (localaktr == null) {
        return null;
      }
      if (this.jdField_a_of_type_Aktp != null)
      {
        localakto.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Aktp.jdField_a_of_type_Int, this.jdField_a_of_type_Aktp.c, this.jdField_a_of_type_Aktp.jdField_b_of_type_Int, this.jdField_a_of_type_Aktp.d);
        if (!localaktr.jdField_b_of_type_Boolean) {
          break label127;
        }
        localakto.jdField_a_of_type_JavaLangString = localaktr.jdField_a_of_type_JavaLangString;
        localakto.jdField_a_of_type_Boolean = false;
        localakto.jdField_a_of_type_Double = localaktr.jdField_a_of_type_Double;
      }
      for (;;)
      {
        return localakto;
        localakto.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        break;
        label127:
        localakto.jdField_a_of_type_JavaLangString = localaktr.jdField_a_of_type_Aktn.jdField_a_of_type_JavaLangString;
        boolean bool1 = bool2;
        if (localaktr.jdField_a_of_type_ArrayOfByte != null)
        {
          bool1 = bool2;
          if (localaktr.jdField_a_of_type_ArrayOfByte.length > 20) {
            bool1 = true;
          }
        }
        localakto.jdField_a_of_type_Boolean = bool1;
        localakto.jdField_a_of_type_Double = localaktr.jdField_a_of_type_Double;
        localakto.jdField_a_of_type_ArrayOfByte = localaktr.jdField_a_of_type_ArrayOfByte;
        localakto.jdField_b_of_type_JavaLangString = localaktr.d;
        localakto.c = localaktr.e;
        localakto.d = localaktr.f;
        localakto.jdField_b_of_type_Boolean = localaktr.jdField_a_of_type_Boolean;
      }
    }
    return null;
  }
  
  private aktr a()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!c()) {}
    do
    {
      do
      {
        return localObject2;
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfAktq.length)
        {
          int j = 0;
          while ((this.jdField_a_of_type_ArrayOfAktq[i].jdField_a_of_type_ArrayOfAktr != null) && (j < this.jdField_a_of_type_ArrayOfAktq[i].jdField_a_of_type_ArrayOfAktr.length))
          {
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (this.jdField_a_of_type_ArrayOfAktq[i].jdField_a_of_type_ArrayOfAktr[j].jdField_a_of_type_Double >= ((aktr)localObject1).jdField_a_of_type_Double) {}
            }
            else
            {
              localObject2 = this.jdField_a_of_type_ArrayOfAktq[i].jdField_a_of_type_ArrayOfAktr[i];
            }
            j += 1;
            localObject1 = localObject2;
          }
          i += 1;
        }
        localObject2 = localObject1;
      } while (localObject1 != null);
      localObject2 = localObject1;
    } while (this.jdField_a_of_type_ArrayOfAktq.length != 1);
    localObject1 = new aktr();
    ((aktr)localObject1).jdField_b_of_type_Boolean = true;
    ((aktr)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfAktq[0].jdField_a_of_type_JavaLangString;
    ((aktr)localObject1).jdField_a_of_type_Double = this.jdField_a_of_type_ArrayOfAktq[0].jdField_a_of_type_Double;
    ((aktr)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfAktq[0].jdField_a_of_type_JavaLangString;
    ((aktr)localObject1).c = 0;
    ((aktr)localObject1).g = "";
    return localObject1;
  }
  
  public int a()
  {
    if (!a()) {
      return -1;
    }
    if (c())
    {
      aktr localaktr = a();
      if ((localaktr != null) && (localaktr.jdField_a_of_type_ArrayOfByte != null) && (localaktr.jdField_a_of_type_ArrayOfByte.length > 20)) {
        return 1;
      }
    }
    return 0;
  }
  
  public aktk a()
  {
    aktk localaktk = new aktk();
    localaktk.jdField_a_of_type_Boolean = true;
    localaktk.jdField_a_of_type_Aktm = this.jdField_a_of_type_Aktm;
    localaktk.jdField_a_of_type_Akto = a();
    localaktk.c = false;
    return localaktk;
  }
  
  public String a()
  {
    aktr localaktr = a();
    if (localaktr == null) {
      return "";
    }
    return localaktr.g;
  }
  
  public boolean a()
  {
    return c();
  }
  
  public boolean a(aktj paramaktj)
  {
    if (paramaktj == null) {}
    aktr localaktr;
    do
    {
      return false;
      paramaktj = paramaktj.a();
      localaktr = a();
    } while ((paramaktj == null) || (localaktr == null) || (!paramaktj.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localaktr.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public byte[] a()
  {
    akto localakto = a();
    if ((localakto != null) && (localakto.jdField_a_of_type_Boolean)) {
      return localakto.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Aktm != null) && (this.jdField_a_of_type_Aktm.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Aktm.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Aktm.jdField_a_of_type_ArrayOfAktl != null) && (this.jdField_a_of_type_Aktm.jdField_a_of_type_ArrayOfAktl.length > 0);
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Int == 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ArrayOfAktq != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ArrayOfAktq.length > 0)
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_ArrayOfAktq[0].jdField_a_of_type_JavaLangString.equalsIgnoreCase(jdField_a_of_type_JavaLangString)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean d()
  {
    boolean bool = true;
    aktr localaktr = a();
    if (localaktr == null) {
      return false;
    }
    if (localaktr.c == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (c()) {
      localStringBuilder.append("\n {migObjectClassifyResult:" + this.jdField_a_of_type_ArrayOfAktq[0].toString() + "} \n");
    }
    if (b()) {
      localStringBuilder.append("\n {jdSearchResult:" + this.jdField_a_of_type_Aktm.toString() + "}\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aktj
 * JD-Core Version:    0.7.0.1
 */