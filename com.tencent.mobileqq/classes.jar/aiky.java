import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aiky
  extends aiks
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static boolean d;
  long a;
  public DrawerPushItem a;
  int b;
  int c;
  
  public aiky(QQAppInterface paramQQAppInterface, DrawerPushItem paramDrawerPushItem)
  {
    super(paramQQAppInterface);
    this.jdField_c_of_type_Int = 7;
    this.jdField_a_of_type_Int = paramDrawerPushItem.priority;
    jdField_a_of_type_JavaLangString = paramDrawerPushItem.content;
    this.jdField_b_of_type_Int = paramDrawerPushItem.action_id;
    jdField_b_of_type_JavaLangString = paramDrawerPushItem.ext_url;
    jdField_d_of_type_JavaLangString = paramDrawerPushItem.msg_id;
    jdField_c_of_type_JavaLangString = paramDrawerPushItem.tips_str;
    if (paramDrawerPushItem.bubble_res_id == 32) {
      this.jdField_c_of_type_Int = 7;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem = paramDrawerPushItem;
      return;
      if (paramDrawerPushItem.bubble_res_id == 33) {
        this.jdField_c_of_type_Int = 6;
      } else {
        this.jdField_c_of_type_Int = 9;
      }
    }
  }
  
  public int a(aisu paramaisu, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts)) {
      return super.a(paramaisu, paramInt, paramAppInterface, paramContext);
    }
    int i;
    boolean bool;
    if (this.jdField_b_of_type_Int > aiys.jdField_a_of_type_Int)
    {
      i = 3;
      bool = ApolloUtil.c(5, this.jdField_b_of_type_Int);
      if (this.jdField_b_of_type_Int <= 0) {
        break label225;
      }
      if (!bool) {
        break label172;
      }
      paramAppInterface = new ApolloActionData();
      paramAppInterface.actionId = this.jdField_b_of_type_Int;
      paramAppInterface.actionType = 0;
      paramInt = 6;
      aisl.a(paramaisu, 6, paramAppInterface);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AplloDrawerStatus", 2, new Object[] { "PushDrawerStatus onExecAction:", Integer.valueOf(this.jdField_b_of_type_Int), ",rscType:", Integer.valueOf(paramInt), ",isRscDone:", Boolean.valueOf(bool) });
      }
      return 0;
      i = 2;
      break;
      label172:
      super.a(paramaisu, i, paramInt, paramAppInterface, paramContext);
      aitw.a(paramAppInterface, ApolloUtil.c(this.jdField_b_of_type_Int) + "/d.zip", ApolloUtil.d(this.jdField_b_of_type_Int));
      paramInt = 0;
      continue;
      label225:
      super.a(paramaisu, i, paramInt, paramAppInterface, paramContext);
      paramInt = 0;
    }
  }
  
  public void a(aisu paramaisu, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramContext);
  }
  
  public void a(aisu paramaisu, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts))
    {
      jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.i("AplloDrawerStatus", 2, "ShowCount Max:" + this.jdField_a_of_type_Boolean);
      }
      return;
    }
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot == 0)
    {
      bool = true;
      jdField_d_of_type_Boolean = bool;
      this.jdField_b_of_type_Boolean = true;
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        aisl.a(paramaisu, jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.bubble_res_id);
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramaisu = (aifg)paramQQAppInterface.getManager(153);
      paramContext = jdField_d_of_type_JavaLangString;
      if (!paramaisu.jdField_d_of_type_Boolean) {
        break label202;
      }
    }
    label202:
    for (paramInt = 0;; paramInt = 1)
    {
      bajr.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotShow", 0, 0, new String[] { paramContext, String.valueOf(paramInt), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
      return;
      bool = false;
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {}
    do
    {
      return;
      aifg localaifg = (aifg)paramQQAppInterface.getManager(153);
      if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 1) {
        localaifg.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      }
      this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts;
    } while (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 1);
    ((auqh)paramQQAppInterface.getManager(36)).b(String.valueOf("103100.103200"));
  }
  
  public void a(QQAppInterface paramQQAppInterface, aisu paramaisu)
  {
    super.a(paramQQAppInterface, paramaisu);
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_Long == 0L)) {}
    do
    {
      return;
      jdField_d_of_type_Boolean = false;
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L);
    a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
    paramaisu = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
    paramaisu.show_sum += 1;
    paramQQAppInterface = (aifg)paramQQAppInterface.getManager(153);
    if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 1))
    {
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      return;
    }
    paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {
      return;
    }
    a(paramQQAppInterface);
    aifg localaifg = (aifg)paramQQAppInterface.getManager(153);
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotGameId > 0)
    {
      QLog.d("AplloDrawerStatus", 1, "onBubbleClick play game id:" + this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotGameId);
      ApolloGameUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotGameId, 0L, 0, null, 323, null);
      paramContext = jdField_d_of_type_JavaLangString;
      if (!localaifg.jdField_d_of_type_Boolean) {
        break label168;
      }
    }
    label168:
    for (int i = 0;; i = 1)
    {
      bajr.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotClear", 0, 0, new String[] { paramContext, String.valueOf(i), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
      return;
      localaifg.a(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.scheme, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.ext_url, "drawer");
      break;
    }
  }
  
  public void b(aisu paramaisu, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiky
 * JD-Core Version:    0.7.0.1
 */