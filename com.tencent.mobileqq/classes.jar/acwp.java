import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class acwp
  implements acxg
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private bafb jdField_a_of_type_Bafb;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private long b;
  
  public acwp(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_Long = babp.i();
    this.b = babp.j();
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    int i = 1;
    long l;
    switch (paramInt)
    {
    default: 
      return;
    case 11: 
      a();
      return;
    case 5: 
      ajas.a("aio_pre");
      return;
    case 16: 
      l = babp.a(true);
      if ((this.jdField_a_of_type_Long != l) && (this.jdField_a_of_type_Long != this.b)) {
        QLog.d("ApolloHelper", 1, new Object[] { "[doOnConfigurationChanged] screenWidth:", Long.valueOf(l), ",mLastScreenWidth:", Long.valueOf(this.jdField_a_of_type_Long), ",mLastScreenHeight:", Long.valueOf(this.b) });
      }
      break;
    }
    for (paramInt = i;; paramInt = 0)
    {
      this.jdField_a_of_type_Long = l;
      this.b = babp.j();
      if (paramInt == 0) {
        break;
      }
      airu localairu = aisl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localairu != null) {
        localairu.a(this.jdField_a_of_type_Long, this.b, aisl.b(), aisl.a());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      ajas.a();
      if (QLog.isColorLevel()) {
        QLog.i("ChatPieApolloViewController", 1, "START");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aihg == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aihg = new aihg();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aihg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    Object localObject3;
    Object localObject1;
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.dismiss();
      }
      localObject3 = new ApolloFavActionData();
      localObject1 = (HashMap)paramObject;
      paramObject = (String)((Map)localObject1).get("optFrom");
    } while ((TextUtils.isEmpty(paramObject)) || (!"actionAdd".equals(paramObject)));
    int m = Integer.parseInt((String)((Map)localObject1).get("id"));
    String str2 = (String)((Map)localObject1).get("actionText");
    if (!TextUtils.isEmpty((String)((Map)localObject1).get("textType"))) {}
    for (int i = Integer.parseInt((String)((Map)localObject1).get("textType"));; i = 0)
    {
      paramObject = (String)((Map)localObject1).get("audioId");
      if (!TextUtils.isEmpty(paramObject)) {}
      for (int j = Integer.parseInt(paramObject);; j = 0)
      {
        paramObject = (String)((Map)localObject1).get("audioTime");
        if (!TextUtils.isEmpty(paramObject)) {}
        for (float f = Float.parseFloat(paramObject);; f = 0.0F)
        {
          paramObject = (String)((Map)localObject1).get("isPlayDefultAudio");
          if (!TextUtils.isEmpty(paramObject)) {}
          for (int k = Integer.parseInt(paramObject);; k = 0)
          {
            paramObject = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
            ((aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            ((ApolloFavActionData)localObject3).textType = i;
            ((ApolloFavActionData)localObject3).text = str2;
            ((ApolloFavActionData)localObject3).acitonId = m;
            ((ApolloFavActionData)localObject3).audioId = j;
            ((ApolloFavActionData)localObject3).audioStartTime = f;
            ((ApolloFavActionData)localObject3).playOriginalAudio = k;
            if (paramBoolean)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloHelper", 2, "action auth success from add fav action=" + ((ApolloFavActionData)localObject3).toString());
              }
              ApolloItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (ApolloFavActionData)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              return;
            }
            i = Integer.parseInt((String)((Map)localObject1).get("ret"));
            String str1 = "";
            Object localObject2 = null;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloHelper", 2, "action auth fail from fav add action=" + ((ApolloFavActionData)localObject3).toString() + " errcode = " + i);
            }
            ApolloActionData localApolloActionData = paramObject.a(m);
            switch (i)
            {
            default: 
              paramObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624538);
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624538);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloHelper", 2, "unknown action auth errcode");
              }
              this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidAppActivity, 0, paramObject, (CharSequence)localObject1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131629669), str1, (DialogInterface.OnClickListener)localObject2, new acws(this));
              if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
                this.jdField_a_of_type_Bafb.show();
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
              i = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              localObject2 = "" + m;
              paramObject = str2;
              if (TextUtils.isEmpty(str2)) {
                paramObject = "0";
              }
              bajr.a((AppInterface)localObject1, "cmshow", "Apollo", "add_action", str1, i, 0, new String[] { localObject2, "", paramObject, String.valueOf(System.currentTimeMillis() / 1000L) });
              return;
            case 31004: 
            case 31005: 
              label548:
              paramObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624526);
              localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624531);
              if (localApolloActionData != null) {
                paramObject = String.format(paramObject, new Object[] { localApolloActionData.actionName });
              }
              break;
            }
            for (;;)
            {
              str1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624525);
              localObject2 = new acwq(this, m);
              bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + m, "1" });
              localObject1 = paramObject;
              paramObject = localObject3;
              break label548;
              paramObject = (String)((Map)localObject1).get("content");
              if (TextUtils.isEmpty(paramObject)) {
                paramObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624523);
              }
              for (;;)
              {
                localObject1 = (String)((Map)localObject1).get("url");
                localObject1 = (String)localObject1 + "&actionid=" + m;
                localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624522);
                str1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624522);
                localObject2 = new acwr(this, (String)localObject1, m);
                bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "activity_alert_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + m, "1" });
                localObject1 = paramObject;
                paramObject = localObject3;
                break label548;
                bbmy.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624509), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("ApolloHelper", 2, "fav action network error");
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public int[] a()
  {
    return new int[] { 11, 5, 16, 3 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwp
 * JD-Core Version:    0.7.0.1
 */