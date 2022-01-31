import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.DecryptCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class akcp
  implements StoryShareEncryptHelper.DecryptCallback
{
  public akcp(JumpAction paramJumpAction) {}
  
  public void a(StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse paramStoryShareTranslateTokenResponse, QQProgressDialog paramQQProgressDialog)
  {
    if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
      paramQQProgressDialog.dismiss();
    }
    StoryShareEncryptHelper.a(JumpAction.a(this.a));
    if ((paramStoryShareTranslateTokenResponse != null) && (paramStoryShareTranslateTokenResponse.jdField_a_of_type_Int == 0))
    {
      StoryShareEncryptHelper.a(paramStoryShareTranslateTokenResponse.jdField_a_of_type_JavaLangString, JumpAction.a(this.a));
      JumpAction.a(this.a);
      return;
    }
    if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131434843, 1).a();
      return;
    }
    this.a.c = "open";
    JumpAction.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akcp
 * JD-Core Version:    0.7.0.1
 */