import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.NetSearchTemplateMovieItem;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;

public class ahgn
  implements View.OnClickListener
{
  public ahgn(SearchTemplatePresenter paramSearchTemplatePresenter, NetSearchTemplateMovieItem paramNetSearchTemplateMovieItem) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateMovieItem.e))
    {
      localObject = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateMovieItem.e);
      if (localObject == null) {
        break label47;
      }
      ((JumpAction)localObject).b();
    }
    label47:
    while ((!this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateMovieItem.e.startsWith("http://")) && (!this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateMovieItem.e.startsWith("https://"))) {
      return;
    }
    paramView = paramView.getContext();
    Object localObject = new Intent(paramView, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateMovieItem.e);
    paramView.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahgn
 * JD-Core Version:    0.7.0.1
 */