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

public class alhv
  extends algb
  implements algd
{
  public static final String a;
  public int a;
  public long a;
  public alhy a;
  public alib a;
  public alic[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = ajyc.a(2131700720);
  }
  
  public alhv()
  {
    super(2, 0);
    this.jdField_a_of_type_Int = -1;
  }
  
  public static alhy a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    int j = -1;
    float f2 = 0.0F;
    alhy localalhy = new alhy();
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
    alhx localalhx;
    if (paramJdSearchRsp.jd_search_errorcode.has())
    {
      i = paramJdSearchRsp.jd_search_errorcode.get();
      localalhy.jdField_a_of_type_Int = i;
      if (!paramJdSearchRsp.jd_search_errormsg.has()) {
        break label633;
      }
      localObject1 = paramJdSearchRsp.jd_search_errormsg.get();
      localalhy.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (!paramJdSearchRsp.jd_search_detail.has()) {
        break label707;
      }
      localObject1 = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
      if (!((JDSearch.JdSearchDetail)localObject1).errorcode.has()) {
        break label640;
      }
      i = ((JDSearch.JdSearchDetail)localObject1).errorcode.get();
      localalhy.jdField_b_of_type_Int = i;
      if (!((JDSearch.JdSearchDetail)localObject1).errormsg.has()) {
        break label645;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).errormsg.get();
      localalhy.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      if (!((JDSearch.JdSearchDetail)localObject1).jd_more_url.has()) {
        break label651;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_more_url.get();
      localalhy.d = paramJdSearchRsp;
      if (((JDSearch.JdSearchDetail)localObject1).rectangle.has())
      {
        paramJdSearchRsp = (JDSearch.Rectangle)((JDSearch.JdSearchDetail)localObject1).rectangle.get();
        localObject2 = localalhy.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.left.has()) {
          break label657;
        }
        f1 = paramJdSearchRsp.left.get();
        ((RectF)localObject2).left = f1;
        localObject2 = localalhy.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.top.has()) {
          break label662;
        }
        f1 = paramJdSearchRsp.top.get();
        ((RectF)localObject2).top = f1;
        localObject2 = localalhy.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.right.has()) {
          break label667;
        }
        f1 = paramJdSearchRsp.right.get();
        label274:
        ((RectF)localObject2).right = f1;
        localObject2 = localalhy.jdField_a_of_type_AndroidGraphicsRectF;
        f1 = f2;
        if (paramJdSearchRsp.bottom.has()) {
          f1 = paramJdSearchRsp.bottom.get();
        }
        ((RectF)localObject2).bottom = f1;
        i = j;
        if (paramJdSearchRsp.is_user_rectangle.has()) {
          i = paramJdSearchRsp.is_user_rectangle.get();
        }
        localalhy.c = i;
      }
      if (!((JDSearch.JdSearchDetail)localObject1).jd_sku_item.has()) {
        break label672;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_sku_item.get();
      label360:
      if ((paramJdSearchRsp != null) && (!paramJdSearchRsp.isEmpty())) {
        localalhy.jdField_a_of_type_ArrayOfAlhx = new alhx[paramJdSearchRsp.size()];
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
      localalhy.jdField_a_of_type_ArrayOfAlhx[i] = new alhx();
      localalhx = localalhy.jdField_a_of_type_ArrayOfAlhx[i];
      if (!((JDSearch.JdSkuItem)localObject2).detail_url.has()) {
        break label677;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).detail_url.get();
      label475:
      localalhx.jdField_a_of_type_JavaLangString = paramJdSearchRsp;
      localalhx = localalhy.jdField_a_of_type_ArrayOfAlhx[i];
      if (!((JDSearch.JdSkuItem)localObject2).image_url.has()) {
        break label683;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).image_url.get();
      label510:
      localalhx.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      localalhx = localalhy.jdField_a_of_type_ArrayOfAlhx[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_id.has()) {
        break label689;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_id.get();
      label545:
      localalhx.c = paramJdSearchRsp;
      localalhx = localalhy.jdField_a_of_type_ArrayOfAlhx[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_name.has()) {
        break label695;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_name.get();
      label580:
      localalhx.d = paramJdSearchRsp;
      localalhx = localalhy.jdField_a_of_type_ArrayOfAlhx[i];
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
      localalhx.e = paramJdSearchRsp;
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
    return localalhy;
  }
  
  private alia a()
  {
    boolean bool2 = false;
    if (c())
    {
      alia localalia = new alia();
      alid localalid = a();
      if (localalid == null) {
        return null;
      }
      if (this.jdField_a_of_type_Alib != null)
      {
        localalia.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Alib.jdField_a_of_type_Int, this.jdField_a_of_type_Alib.c, this.jdField_a_of_type_Alib.jdField_b_of_type_Int, this.jdField_a_of_type_Alib.d);
        if (!localalid.jdField_b_of_type_Boolean) {
          break label127;
        }
        localalia.jdField_a_of_type_JavaLangString = localalid.jdField_a_of_type_JavaLangString;
        localalia.jdField_a_of_type_Boolean = false;
        localalia.jdField_a_of_type_Double = localalid.jdField_a_of_type_Double;
      }
      for (;;)
      {
        return localalia;
        localalia.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        break;
        label127:
        localalia.jdField_a_of_type_JavaLangString = localalid.jdField_a_of_type_Alhz.jdField_a_of_type_JavaLangString;
        boolean bool1 = bool2;
        if (localalid.jdField_a_of_type_ArrayOfByte != null)
        {
          bool1 = bool2;
          if (localalid.jdField_a_of_type_ArrayOfByte.length > 20) {
            bool1 = true;
          }
        }
        localalia.jdField_a_of_type_Boolean = bool1;
        localalia.jdField_a_of_type_Double = localalid.jdField_a_of_type_Double;
        localalia.jdField_a_of_type_ArrayOfByte = localalid.jdField_a_of_type_ArrayOfByte;
        localalia.jdField_b_of_type_JavaLangString = localalid.d;
        localalia.c = localalid.e;
        localalia.d = localalid.f;
        localalia.jdField_b_of_type_Boolean = localalid.jdField_a_of_type_Boolean;
      }
    }
    return null;
  }
  
  private alid a()
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
        while (i < this.jdField_a_of_type_ArrayOfAlic.length)
        {
          int j = 0;
          while ((this.jdField_a_of_type_ArrayOfAlic[i].jdField_a_of_type_ArrayOfAlid != null) && (j < this.jdField_a_of_type_ArrayOfAlic[i].jdField_a_of_type_ArrayOfAlid.length))
          {
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (this.jdField_a_of_type_ArrayOfAlic[i].jdField_a_of_type_ArrayOfAlid[j].jdField_a_of_type_Double >= ((alid)localObject1).jdField_a_of_type_Double) {}
            }
            else
            {
              localObject2 = this.jdField_a_of_type_ArrayOfAlic[i].jdField_a_of_type_ArrayOfAlid[i];
            }
            j += 1;
            localObject1 = localObject2;
          }
          i += 1;
        }
        localObject2 = localObject1;
      } while (localObject1 != null);
      localObject2 = localObject1;
    } while (this.jdField_a_of_type_ArrayOfAlic.length != 1);
    localObject1 = new alid();
    ((alid)localObject1).jdField_b_of_type_Boolean = true;
    ((alid)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfAlic[0].jdField_a_of_type_JavaLangString;
    ((alid)localObject1).jdField_a_of_type_Double = this.jdField_a_of_type_ArrayOfAlic[0].jdField_a_of_type_Double;
    ((alid)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfAlic[0].jdField_a_of_type_JavaLangString;
    ((alid)localObject1).c = 0;
    ((alid)localObject1).g = "";
    return localObject1;
  }
  
  public int a()
  {
    if (!a()) {
      return -1;
    }
    if (c())
    {
      alid localalid = a();
      if ((localalid != null) && (localalid.jdField_a_of_type_ArrayOfByte != null) && (localalid.jdField_a_of_type_ArrayOfByte.length > 20)) {
        return 1;
      }
    }
    return 0;
  }
  
  public alhw a()
  {
    alhw localalhw = new alhw();
    localalhw.jdField_a_of_type_Boolean = true;
    localalhw.jdField_a_of_type_Alhy = this.jdField_a_of_type_Alhy;
    localalhw.jdField_a_of_type_Alia = a();
    localalhw.c = false;
    return localalhw;
  }
  
  public String a()
  {
    alid localalid = a();
    if (localalid == null) {
      return "";
    }
    return localalid.g;
  }
  
  public boolean a()
  {
    return c();
  }
  
  public boolean a(alhv paramalhv)
  {
    if (paramalhv == null) {}
    alid localalid;
    do
    {
      return false;
      paramalhv = paramalhv.a();
      localalid = a();
    } while ((paramalhv == null) || (localalid == null) || (!paramalhv.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localalid.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public byte[] a()
  {
    alia localalia = a();
    if ((localalia != null) && (localalia.jdField_a_of_type_Boolean)) {
      return localalia.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Alhy != null) && (this.jdField_a_of_type_Alhy.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Alhy.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Alhy.jdField_a_of_type_ArrayOfAlhx != null) && (this.jdField_a_of_type_Alhy.jdField_a_of_type_ArrayOfAlhx.length > 0);
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
        if (this.jdField_a_of_type_ArrayOfAlic != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ArrayOfAlic.length > 0)
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_ArrayOfAlic[0].jdField_a_of_type_JavaLangString.equalsIgnoreCase(jdField_a_of_type_JavaLangString)) {
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
    alid localalid = a();
    if (localalid == null) {
      return false;
    }
    if (localalid.c == 1) {}
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
      localStringBuilder.append("\n {migObjectClassifyResult:" + this.jdField_a_of_type_ArrayOfAlic[0].toString() + "} \n");
    }
    if (b()) {
      localStringBuilder.append("\n {jdSearchResult:" + this.jdField_a_of_type_Alhy.toString() + "}\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alhv
 * JD-Core Version:    0.7.0.1
 */