import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;

class aecu
  implements Runnable
{
  aecu(aect paramaect, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aect.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Aect.a.a(2, "编辑资料成功");
      this.jdField_a_of_type_Aect.a.a(true);
      this.jdField_a_of_type_Aect.a.finish();
      NearbySPUtil.a(this.jdField_a_of_type_Aect.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    this.jdField_a_of_type_Aect.a.a(1, "更新交友资料失败，请重试。");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aecu
 * JD-Core Version:    0.7.0.1
 */