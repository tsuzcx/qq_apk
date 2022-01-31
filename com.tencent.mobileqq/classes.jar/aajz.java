import com.tencent.mobileqq.ark.ArkActionAppMgr;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

class aajz
  implements Runnable
{
  aajz(aajy paramaajy, Object paramObject, boolean paramBoolean, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    aakg localaakg = (aakg)this.jdField_a_of_type_JavaLangObject;
    if (this.jdField_a_of_type_Boolean)
    {
      long l1 = ArkActionAppMgr.a(this.jdField_a_of_type_Aajy.a, 2, this.jdField_a_of_type_JavaUtilArrayList);
      long l2 = ArkActionAppMgr.a(this.jdField_a_of_type_Aajy.a, 1, this.b);
      if ((l1 < 0L) || (l2 < 0L))
      {
        ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("getContextActionAppList, fail, gray-app-id=%d, app-id=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
        ArkActionAppMgr.a(this.jdField_a_of_type_Aajy.a, localaakg, false);
        return;
      }
      ArkActionAppMgr.a(this.jdField_a_of_type_Aajy.a, localaakg, true);
      return;
    }
    ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("getContextActionAppList, fail, success is false.", new Object[0]));
    ArkActionAppMgr.a(this.jdField_a_of_type_Aajy.a, localaakg, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajz
 * JD-Core Version:    0.7.0.1
 */