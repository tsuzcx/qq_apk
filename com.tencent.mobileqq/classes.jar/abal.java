import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.qphone.base.util.QLog;

class abal
  implements View.OnClickListener
{
  abal(abai paramabai) {}
  
  public void onClick(View paramView)
  {
    try
    {
      i = ((Integer)paramView.getTag(-1)).intValue();
      if (i > -1)
      {
        localamnq = (amnq)this.a.jdField_a_of_type_Aiba.getItem(i);
        localauqh = (auqh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if ((localamnq == null) || (localamnq.a == null) || (localamnq.a.uiResId != msg.a)) {
          break label141;
        }
        urp.a("dynamic", "clk_story", 0, ((mmy)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).c(), new String[0]);
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        int i;
        amnq localamnq;
        auqh localauqh;
        label141:
        QLog.w("Q.lebatab.leba", 2, "" + localNullPointerException);
        continue;
        if ((localamnq != null) && (localamnq.a != null) && (826L == localamnq.a.uiResId))
        {
          this.a.a(paramView, i);
          return;
        }
        if ((localamnq != null) && (localamnq.a != null) && (7720L == localamnq.a.uiResId))
        {
          PublicFragmentActivity.a(this.a.a(), ExtendFriendFragment.class);
          awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + localamnq.a.uiResId, "", "", "");
          if ((localamnq.a != null) && (localamnq.a.uiResId > 0L)) {
            localNullPointerException.a((int)localamnq.a.uiResId, 31);
          }
        }
        else if ((localamnq != null) && (localamnq.a != null) && (7759L == localamnq.a.uiResId))
        {
          alxu localalxu = ((alxy)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
          String str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
          Object localObject = str;
          if (localalxu != null)
          {
            localObject = str;
            if (!TextUtils.isEmpty(localalxu.l)) {
              localObject = localalxu.l;
            }
          }
          localamnq.a.strGotoUrl = ((String)localObject);
        }
      }
    }
    this.a.jdField_a_of_type_Behi.onItemClick(this.a.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, paramView, ((Integer)paramView.getTag(-1)).intValue(), 0L);
    return;
    if ((localamnq != null) && (localamnq.a != null) && (7719L == localamnq.a.uiResId))
    {
      abai.e(this.a);
      awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + localamnq.a.uiResId, "", "", "");
      localauqh.a(100510, 31);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abal
 * JD-Core Version:    0.7.0.1
 */