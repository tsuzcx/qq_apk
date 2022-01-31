import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordItem;
import com.tencent.mobileqq.widget.ContainerView;

public class acex
  implements amdf
{
  public acex(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(int paramInt, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    amda.a(this.a.app, this.a.e, paramArrayOfHotWordItem);
    paramArrayOfHotWordItem = bbos.a(this.a.e, this.a.f, 30, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 13);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this.a))
    {
      this.a.jdField_a_of_type_JavaLangCharSequence = paramArrayOfHotWordItem;
      return;
    }
    this.a.jdField_a_of_type_JavaLangCharSequence = null;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramArrayOfHotWordItem);
    this.a.i = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acex
 * JD-Core Version:    0.7.0.1
 */