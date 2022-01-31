import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.lightReply.LightReplyAdapter;
import com.tencent.mobileqq.lightReply.LightReplyAdapter.ViewHolder;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager.LightReplyEmotionClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class aekg
  implements AdapterView.OnItemClickListener
{
  public aekg(LightReplyMenuManager paramLightReplyMenuManager, boolean paramBoolean, String paramString, LightReplyMenuManager.LightReplyEmotionClickListener paramLightReplyEmotionClickListener, Context paramContext, int paramInt1, long paramLong, int paramInt2) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LightReplyEmojs localLightReplyEmojs;
    if (LightReplyMenuManager.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager) != null)
    {
      localLightReplyEmojs = (LightReplyEmojs)LightReplyMenuManager.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager).b.get(paramInt);
      if (localLightReplyEmojs != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label229;
        }
        paramAdapterView = BaseApplicationImpl.getApplication().getRuntime();
        if (!(paramAdapterView instanceof QQAppInterface)) {
          break label317;
        }
      }
    }
    label287:
    label317:
    for (paramAdapterView = (QQAppInterface)paramAdapterView;; paramAdapterView = null)
    {
      String str2 = this.jdField_a_of_type_JavaLangString;
      String str3 = localLightReplyEmojs.emoCode;
      String str1;
      if (LightReplyMenuManager.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager))
      {
        str1 = "0";
        ReportController.b(paramAdapterView, "dc00899", "Grp_replyPic", "", "Emoji_box", "send_emoji", 0, 0, str2, str3, str1, "");
        paramAdapterView = (LightReplyAdapter.ViewHolder)paramView.getTag();
        if ((paramAdapterView.a != null) && (paramAdapterView.a.getDrawable() != null)) {
          paramAdapterView.a.getDrawable().setAlpha(100);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager$LightReplyEmotionClickListener != null) && (paramAdapterView.a != null))
        {
          paramAdapterView = (URLDrawable)paramAdapterView.a.getDrawable();
          if ((paramAdapterView == null) || (paramAdapterView.getStatus() == 1)) {
            break label287;
          }
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, -1, "出错了，请稍后重试！", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a();
        return;
        str1 = "1";
        break;
        label229:
        str1 = this.jdField_a_of_type_JavaLangString;
        str2 = localLightReplyEmojs.emoCode;
        if (LightReplyMenuManager.a(this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager)) {}
        for (paramAdapterView = "0";; paramAdapterView = "1")
        {
          ReportController.b(null, "dc00899", "Grp_replyPic", "", "Emoji_box", "send_emoji", 0, 0, str1, str2, paramAdapterView, "");
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager$LightReplyEmotionClickListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.b, localLightReplyEmojs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekg
 * JD-Core Version:    0.7.0.1
 */