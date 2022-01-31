import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;

public class alkh
{
  public int a;
  public String a;
  public ArrayList<alki> a;
  public int b;
  public int c;
  public int d;
  
  public static alkh a(oidb_0x74b.HeadInfo paramHeadInfo)
  {
    Object localObject;
    if (paramHeadInfo == null) {
      localObject = null;
    }
    alkh localalkh;
    do
    {
      return localObject;
      localalkh = new alkh();
      if (paramHeadInfo.uint32_id.has()) {
        localalkh.jdField_a_of_type_Int = paramHeadInfo.uint32_id.get();
      }
      if (paramHeadInfo.str_photohead.has()) {
        localalkh.jdField_a_of_type_JavaLangString = paramHeadInfo.str_photohead.get();
      }
      if (paramHeadInfo.uint32_invalid.has()) {
        localalkh.b = paramHeadInfo.uint32_invalid.get();
      }
      if (paramHeadInfo.uint32_timestamp.has()) {
        localalkh.c = paramHeadInfo.uint32_timestamp.get();
      }
      if (paramHeadInfo.uint32_type.has()) {
        localalkh.d = paramHeadInfo.uint32_type.get();
      }
      localObject = localalkh;
    } while (!paramHeadInfo.rpt_videoheadlist.has());
    localalkh.jdField_a_of_type_JavaUtilArrayList = alki.a(paramHeadInfo.rpt_videoheadlist.get());
    return localalkh;
  }
  
  public static ArrayList<alkh> a(List<oidb_0x74b.HeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      alkh localalkh = a((oidb_0x74b.HeadInfo)paramList.next());
      if (localalkh != null) {
        localArrayList.add(localalkh);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alkh
 * JD-Core Version:    0.7.0.1
 */