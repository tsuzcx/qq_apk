import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.widget.XListView;

public class alxf
  implements avck
{
  public alxf(SearchResultActivity paramSearchResultActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 201)) {}
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_Int == 0)
      {
        int i = this.a.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramBitmap = this.a.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt2).getTag();
          if ((paramBitmap != null) && ((paramBitmap instanceof alxh)))
          {
            paramBitmap = (alxh)paramBitmap;
            if (paramBitmap.jdField_a_of_type_Int == paramInt1) {
              SearchResultActivity.a(this.a, paramBitmap, paramBitmap.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alxf
 * JD-Core Version:    0.7.0.1
 */