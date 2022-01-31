import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;

public class aczx
  implements View.OnClickListener
{
  public aczx(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a()) {}
    adac localadac;
    do
    {
      return;
      localadac = (adac)aciy.a(paramView);
    } while ((localadac == null) || (localadac.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (localadac.jdField_a_of_type_ComTencentImageURLImageView == null));
    int i = localadac.e;
    Object localObject1;
    if ((paramView instanceof TextView))
    {
      Object localObject2;
      int j;
      if (aifg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
      {
        ApolloUtil.a(paramView.getContext(), null, "aio", aiys.ah, null);
        paramView = "1";
        localObject1 = ((aifg)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i = ApolloUtil.b(localadac.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop);
        j = localadac.e;
        if (localObject1 != null) {
          break label312;
        }
      }
      label312:
      for (localObject1 = "0";; localObject1 = ((ApolloBaseInfo)localObject1).apolloStatus + "")
      {
        bajr.a((AppInterface)localObject2, "cmshow", "Apollo", "clk_icon", i, 0, new String[] { String.valueOf(j), localObject1, paramView, aifg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + "" });
        return;
        if (!aifg.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {}
        for (localObject1 = aiys.U;; localObject1 = aiys.V + i)
        {
          localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramView.getContext(), (String)localObject1, -1L, (Intent)localObject2, false, -1);
          paramView = "0";
          break;
        }
      }
    }
    if (new File(adab.a(i)).exists()) {
      ApolloItemBuilder.a(this.a.jdField_a_of_type_AndroidContentContext, localadac.jdField_a_of_type_ComTencentImageURLImageView, (MessageForApollo)localadac.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (paramView = "0";; paramView = "1")
    {
      bajr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_gif", ApolloUtil.b(localadac.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop), 0, new String[] { String.valueOf(i), paramView, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      localObject1 = localadac.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      if ((localObject1 != null) && ((localObject1 instanceof URLDrawable)))
      {
        localObject1 = (URLDrawable)localObject1;
        if ((((URLDrawable)localObject1).getStatus() == 3) || (((URLDrawable)localObject1).getStatus() == 2))
        {
          if (!badq.g(paramView.getContext())) {
            break;
          }
          this.a.a(localadac, paramView.getResources(), true);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aczx
 * JD-Core Version:    0.7.0.1
 */