import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class agnl
  implements View.OnClickListener
{
  public agnl(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a()) {}
    Object localObject2;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject2 = (agnq)AIOUtils.getHolder(paramView);
    } while ((localObject2 == null) || (((agnq)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (((agnq)localObject2).jdField_a_of_type_ComTencentImageURLImageView == null));
    int i = ((agnq)localObject2).e;
    if ((paramView instanceof TextView))
    {
      ApolloBaseInfo localApolloBaseInfo;
      Object localObject3;
      int j;
      if (amme.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
      {
        ApolloUtil.a(paramView.getContext(), null, "aio", anka.u, null);
        localObject1 = "1";
        localApolloBaseInfo = ((amme)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i = ApolloUtil.b(((agnq)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop);
        j = ((agnq)localObject2).e;
        if (localApolloBaseInfo != null) {
          break label324;
        }
      }
      label324:
      for (localObject2 = "0";; localObject2 = localApolloBaseInfo.apolloStatus + "")
      {
        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "clk_icon", i, 0, new String[] { String.valueOf(j), localObject2, localObject1, amme.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + "" });
        break;
        if (!amme.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {}
        for (localObject1 = anka.h;; localObject1 = anka.i + i)
        {
          localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramView.getContext(), (String)localObject1, -1L, (Intent)localObject3, false, -1);
          localObject1 = "0";
          break;
        }
      }
    }
    if (new File(agnp.a(i)).exists()) {
      ApolloItemBuilder.a(this.a.jdField_a_of_type_AndroidContentContext, ((agnq)localObject2).jdField_a_of_type_ComTencentImageURLImageView, (MessageForApollo)((agnq)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_gif", ApolloUtil.b(((agnq)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop), 0, new String[] { String.valueOf(i), localObject1, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
      break;
      localObject1 = ((agnq)localObject2).jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      if ((localObject1 != null) && ((localObject1 instanceof URLDrawable)))
      {
        localObject1 = (URLDrawable)localObject1;
        if ((((URLDrawable)localObject1).getStatus() == 3) || (((URLDrawable)localObject1).getStatus() == 2))
        {
          if (!NetworkUtil.isNetworkAvailable(paramView.getContext())) {
            break;
          }
          this.a.a((agnq)localObject2, paramView.getResources(), true);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnl
 * JD-Core Version:    0.7.0.1
 */