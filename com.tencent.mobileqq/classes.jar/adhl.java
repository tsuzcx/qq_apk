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
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class adhl
  implements adih
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private bbgg jdField_a_of_type_Bbgg;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private long b;
  
  public adhl(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_Long = bbct.i();
    this.b = bbct.j();
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
      this.jdField_a_of_type_Bbgg.dismiss();
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
      ajou.a("aio_pre");
      return;
    case 16: 
      l = bbct.a(true);
      if ((this.jdField_a_of_type_Long != l) && (this.jdField_a_of_type_Long != this.b)) {
        QLog.d("ApolloHelper", 1, new Object[] { "[doOnConfigurationChanged] screenWidth:", Long.valueOf(l), ",mLastScreenWidth:", Long.valueOf(this.jdField_a_of_type_Long), ",mLastScreenHeight:", Long.valueOf(this.b) });
      }
      break;
    }
    for (paramInt = i;; paramInt = 0)
    {
      this.jdField_a_of_type_Long = l;
      this.b = bbct.j();
      if (paramInt == 0) {
        break;
      }
      ajes localajes = ajfj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localajes != null) {
        localajes.a(this.jdField_a_of_type_Long, this.b, ajfj.b(), ajfj.a());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      ajou.a();
      if (QLog.isColorLevel()) {
        QLog.i("ChatPieApolloViewController", 1, "START");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitz == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitz = new aitz();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitz.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.dismiss();
      }
      localObject2 = new ApolloFavActionData();
      localObject1 = (HashMap)paramObject;
      paramObject = (String)((Map)localObject1).get("optFrom");
    } while ((TextUtils.isEmpty(paramObject)) || (!"actionAdd".equals(paramObject)));
    int m = Integer.parseInt((String)((Map)localObject1).get("id"));
    String str1 = (String)((Map)localObject1).get("actionText");
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
            paramObject = (ajmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
            Object localObject3 = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
            ((ApolloFavActionData)localObject2).textType = i;
            ((ApolloFavActionData)localObject2).text = str1;
            ((ApolloFavActionData)localObject2).acitonId = m;
            ((ApolloFavActionData)localObject2).audioId = j;
            ((ApolloFavActionData)localObject2).audioStartTime = f;
            ((ApolloFavActionData)localObject2).playOriginalAudio = k;
            if (paramBoolean)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloHelper", 2, "action auth success from add fav action=" + ((ApolloFavActionData)localObject2).toString());
              }
              ApolloItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (ApolloFavActionData)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              return;
            }
            i = Integer.parseInt((String)((Map)localObject1).get("ret"));
            String str2 = "";
            Object localObject4 = null;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloHelper", 2, "action auth fail from fav add action=" + ((ApolloFavActionData)localObject2).toString() + " errcode = " + i);
            }
            paramObject.a(m);
            switch (i)
            {
            default: 
              String str3 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690092);
              String str4 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690092);
              paramObject = str3;
              localObject1 = str4;
              localObject3 = str2;
              localObject2 = localObject4;
              if (QLog.isColorLevel())
              {
                QLog.d("ApolloHelper", 2, "unknown action auth errcode");
                localObject2 = localObject4;
                localObject3 = str2;
                localObject1 = str4;
                paramObject = str3;
              }
              this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 0, paramObject, (CharSequence)localObject1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695350), (String)localObject3, (DialogInterface.OnClickListener)localObject2, new adhn(this));
              if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
                this.jdField_a_of_type_Bbgg.show();
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
              i = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              localObject3 = "" + m;
              paramObject = str1;
              if (TextUtils.isEmpty(str1)) {
                paramObject = "0";
              }
              VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "add_action", (String)localObject2, i, 0, new String[] { localObject3, "", paramObject, String.valueOf(System.currentTimeMillis() / 1000L) });
              return;
            case 31004: 
            case 31005: 
              ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
              return;
            case 31006: 
              label567:
              paramObject = (String)((Map)localObject1).get("content");
              if (TextUtils.isEmpty(paramObject)) {
                paramObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690077);
              }
              break;
            }
            for (;;)
            {
              localObject1 = (String)((Map)localObject1).get("url");
              localObject1 = (String)localObject1 + "&actionid=" + m;
              str2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690076);
              localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690076);
              localObject2 = new adhm(this, (String)localObject1, m);
              VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "activity_alert_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + m, "1" });
              localObject1 = paramObject;
              paramObject = str2;
              break label567;
              bcpw.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690063), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
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
  
  public int[] a()
  {
    return new int[] { 11, 5, 16, 3 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhl
 * JD-Core Version:    0.7.0.1
 */