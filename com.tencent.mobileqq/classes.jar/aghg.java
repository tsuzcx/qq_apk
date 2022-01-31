import android.support.v4.app.FragmentActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ocr.question.SearchQuestionFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;

public class aghg
  implements Runnable
{
  public aghg(SearchQuestionFragment paramSearchQuestionFragment) {}
  
  public void run()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    localObject = URLDrawable.getDrawable(new File(this.a.b), (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).downloadImediatly();
    this.a.getActivity().runOnUiThread(new aghh(this, (URLDrawable)localObject));
    if (NetworkUtil.d(this.a.jdField_a_of_type_AndroidAppActivity))
    {
      this.a.a(this.a.b);
      return;
    }
    this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aghg
 * JD-Core Version:    0.7.0.1
 */