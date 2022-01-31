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
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;

public class afdh
  implements View.OnClickListener
{
  public afdh(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a()) {}
    afdm localafdm;
    do
    {
      return;
      localafdm = (afdm)aekt.a(paramView);
    } while ((localafdm == null) || (localafdm.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (localafdm.jdField_a_of_type_ComTencentImageURLImageView == null));
    int i = localafdm.e;
    Object localObject1;
    if ((paramView instanceof TextView))
    {
      Object localObject2;
      int j;
      if (akji.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
      {
        ApolloUtil.a(paramView.getContext(), null, "aio", alef.ah, null);
        paramView = "1";
        localObject1 = ((akji)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i = ApolloUtil.b(localafdm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop);
        j = localafdm.e;
        if (localObject1 != null) {
          break label312;
        }
      }
      label312:
      for (localObject1 = "0";; localObject1 = ((ApolloBaseInfo)localObject1).apolloStatus + "")
      {
        VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "clk_icon", i, 0, new String[] { String.valueOf(j), localObject1, paramView, akji.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + "" });
        return;
        if (!akji.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {}
        for (localObject1 = alef.U;; localObject1 = alef.V + i)
        {
          localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramView.getContext(), (String)localObject1, -1L, (Intent)localObject2, false, -1);
          paramView = "0";
          break;
        }
      }
    }
    if (new File(afdl.a(i)).exists()) {
      ApolloItemBuilder.a(this.a.jdField_a_of_type_AndroidContentContext, localafdm.jdField_a_of_type_ComTencentImageURLImageView, (MessageForApollo)localafdm.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (paramView = "0";; paramView = "1")
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_gif", ApolloUtil.b(localafdm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop), 0, new String[] { String.valueOf(i), paramView, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      localObject1 = localafdm.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      if ((localObject1 != null) && ((localObject1 instanceof URLDrawable)))
      {
        localObject1 = (URLDrawable)localObject1;
        if ((((URLDrawable)localObject1).getStatus() == 3) || (((URLDrawable)localObject1).getStatus() == 2))
        {
          if (!bdee.g(paramView.getContext())) {
            break;
          }
          this.a.a(localafdm, paramView.getResources(), true);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdh
 * JD-Core Version:    0.7.0.1
 */