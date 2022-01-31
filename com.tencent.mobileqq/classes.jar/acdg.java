import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import java.lang.ref.WeakReference;

public class acdg
  extends ClickableSpan
{
  private HotChatShare jdField_a_of_type_ComTencentMobileqqAppHotChatShare;
  private ShareHotChatGrayTips jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference b;
  
  public acdg(QQAppInterface paramQQAppInterface, Context paramContext, ShareHotChatGrayTips paramShareHotChatGrayTips, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips = paramShareHotChatGrayTips;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare = new HotChatShare((BaseActivity)paramContext, paramQQAppInterface, null);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (((Context)this.b.get() != null) && (this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips != null))
    {
      paramView = ((HotChatManager)paramView.getManager(59)).a(this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips.mTroopUin);
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare.a(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acdg
 * JD-Core Version:    0.7.0.1
 */