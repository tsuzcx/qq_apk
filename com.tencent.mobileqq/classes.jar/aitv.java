import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.widget.XListView;

public class aitv
  implements bbtd
{
  public aitv(SearchBaseFragment paramSearchBaseFragment) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 201)) {}
    for (;;)
    {
      return;
      if ((this.a.e == 0) && (this.a.a != null))
      {
        int i = this.a.a.getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramBitmap = this.a.a.getChildAt(paramInt2).getTag();
          if ((paramBitmap != null) && ((paramBitmap instanceof aity)))
          {
            paramBitmap = (aity)paramBitmap;
            if (paramBitmap.jdField_a_of_type_Int == paramInt1) {
              this.a.a(paramBitmap, paramBitmap.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitv
 * JD-Core Version:    0.7.0.1
 */