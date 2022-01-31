import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;

public class alyu
{
  public int a;
  public String a;
  public ArrayList<alyv> a;
  public int b;
  public int c;
  public int d;
  
  public static alyu a(oidb_0x74b.HeadInfo paramHeadInfo)
  {
    Object localObject;
    if (paramHeadInfo == null) {
      localObject = null;
    }
    alyu localalyu;
    do
    {
      return localObject;
      localalyu = new alyu();
      if (paramHeadInfo.uint32_id.has()) {
        localalyu.jdField_a_of_type_Int = paramHeadInfo.uint32_id.get();
      }
      if (paramHeadInfo.str_photohead.has()) {
        localalyu.jdField_a_of_type_JavaLangString = paramHeadInfo.str_photohead.get();
      }
      if (paramHeadInfo.uint32_invalid.has()) {
        localalyu.b = paramHeadInfo.uint32_invalid.get();
      }
      if (paramHeadInfo.uint32_timestamp.has()) {
        localalyu.c = paramHeadInfo.uint32_timestamp.get();
      }
      if (paramHeadInfo.uint32_type.has()) {
        localalyu.d = paramHeadInfo.uint32_type.get();
      }
      localObject = localalyu;
    } while (!paramHeadInfo.rpt_videoheadlist.has());
    localalyu.jdField_a_of_type_JavaUtilArrayList = alyv.a(paramHeadInfo.rpt_videoheadlist.get());
    return localalyu;
  }
  
  public static ArrayList<alyu> a(List<oidb_0x74b.HeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      alyu localalyu = a((oidb_0x74b.HeadInfo)paramList.next());
      if (localalyu != null) {
        localArrayList.add(localalyu);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyu
 * JD-Core Version:    0.7.0.1
 */