import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

public class aknp
  implements Runnable
{
  public aknp(ShareActionSheetBuilder paramShareActionSheetBuilder) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.a.jdField_a_of_type_Int) {
      this.a.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (this.a.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.a.jdField_b_of_type_Int)
    {
      this.a.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
      this.a.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.a.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aknp
 * JD-Core Version:    0.7.0.1
 */