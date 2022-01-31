import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;

public class alyv
{
  public int a;
  public String a;
  public ArrayList<alyw> a;
  public int b;
  public int c;
  public int d;
  
  public static alyv a(oidb_0x74b.HeadInfo paramHeadInfo)
  {
    Object localObject;
    if (paramHeadInfo == null) {
      localObject = null;
    }
    alyv localalyv;
    do
    {
      return localObject;
      localalyv = new alyv();
      if (paramHeadInfo.uint32_id.has()) {
        localalyv.jdField_a_of_type_Int = paramHeadInfo.uint32_id.get();
      }
      if (paramHeadInfo.str_photohead.has()) {
        localalyv.jdField_a_of_type_JavaLangString = paramHeadInfo.str_photohead.get();
      }
      if (paramHeadInfo.uint32_invalid.has()) {
        localalyv.b = paramHeadInfo.uint32_invalid.get();
      }
      if (paramHeadInfo.uint32_timestamp.has()) {
        localalyv.c = paramHeadInfo.uint32_timestamp.get();
      }
      if (paramHeadInfo.uint32_type.has()) {
        localalyv.d = paramHeadInfo.uint32_type.get();
      }
      localObject = localalyv;
    } while (!paramHeadInfo.rpt_videoheadlist.has());
    localalyv.jdField_a_of_type_JavaUtilArrayList = alyw.a(paramHeadInfo.rpt_videoheadlist.get());
    return localalyv;
  }
  
  public static ArrayList<alyv> a(List<oidb_0x74b.HeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      alyv localalyv = a((oidb_0x74b.HeadInfo)paramList.next());
      if (localalyv != null) {
        localArrayList.add(localalyv);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyv
 * JD-Core Version:    0.7.0.1
 */