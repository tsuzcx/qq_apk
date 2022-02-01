import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DnaDetail;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.NewDnaInfo;

public class agmf
{
  public int a;
  public String a;
  public ArrayList<agmg> a;
  public String b;
  public String c;
  public String d;
  
  public static ArrayList<agmf> a(List<oidb_0xcf4.NewDnaInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (oidb_0xcf4.NewDnaInfo)paramList.next();
      if ((localObject != null) && (((oidb_0xcf4.NewDnaInfo)localObject).has()))
      {
        agmf localagmf = new agmf();
        if (((oidb_0xcf4.NewDnaInfo)localObject).eDnaType.has()) {
          localagmf.jdField_a_of_type_Int = ((oidb_0xcf4.NewDnaInfo)localObject).eDnaType.get();
        }
        if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_title.has()) {
          localagmf.jdField_a_of_type_JavaLangString = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_title.get().toStringUtf8();
        }
        if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_url.has()) {
          localagmf.b = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_url.get().toStringUtf8();
        }
        if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_cover_url.has()) {
          localagmf.c = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_cover_url.get().toStringUtf8();
        }
        if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_minapp_url.has()) {
          localagmf.d = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_minapp_url.get().toStringUtf8();
        }
        if (((oidb_0xcf4.NewDnaInfo)localObject).rpt_detail.has())
        {
          localObject = ((oidb_0xcf4.NewDnaInfo)localObject).rpt_detail.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            agmg localagmg = agmg.a((oidb_0xcf4.DnaDetail)((Iterator)localObject).next());
            if (localagmg != null)
            {
              if (localagmf.jdField_a_of_type_JavaUtilArrayList == null) {
                localagmf.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              localagmf.jdField_a_of_type_JavaUtilArrayList.add(localagmg);
            }
          }
        }
        localArrayList.add(localagmf);
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return "NewDnaInfo{type=" + this.jdField_a_of_type_Int + ", title=" + this.jdField_a_of_type_JavaLangString + ", jumpUrl=" + this.b + ", coverUrl=" + this.c + ", jumpMinappUrl=" + this.d + ", details=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmf
 * JD-Core Version:    0.7.0.1
 */