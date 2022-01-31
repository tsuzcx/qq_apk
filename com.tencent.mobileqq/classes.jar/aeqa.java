import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;

class aeqa
  implements Runnable
{
  aeqa(aepz paramaepz, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aepz.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Aepz.a.a(2, "编辑资料成功");
      this.jdField_a_of_type_Aepz.a.a(true);
      this.jdField_a_of_type_Aepz.a.finish();
      NearbySPUtil.a(this.jdField_a_of_type_Aepz.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    this.jdField_a_of_type_Aepz.a.a(1, "更新交友资料失败，请重试。");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeqa
 * JD-Core Version:    0.7.0.1
 */