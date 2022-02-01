import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ApolloHelper.3;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class afpu
  implements afrc, afrp
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private long b;
  
  public afpu(afqw paramafqw, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
    this.jdField_a_of_type_Long = DeviceInfoUtil.getPortraitWidth();
    this.b = DeviceInfoUtil.getPortraitHeight();
    paramafqw.a(this);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
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
    case 13: 
      a();
      return;
    case 6: 
      amkr.a("aio_pre");
      return;
    case 18: 
      l = DeviceInfoUtil.getPortraitWidth(true);
      if ((this.jdField_a_of_type_Long != l) && (this.jdField_a_of_type_Long != this.b)) {
        QLog.d("ApolloHelper", 1, new Object[] { "[doOnConfigurationChanged] screenWidth:", Long.valueOf(l), ",mLastScreenWidth:", Long.valueOf(this.jdField_a_of_type_Long), ",mLastScreenHeight:", Long.valueOf(this.b) });
      }
      break;
    }
    for (paramInt = i;; paramInt = 0)
    {
      this.jdField_a_of_type_Long = l;
      this.b = DeviceInfoUtil.getPortraitHeight();
      if (paramInt == 0) {
        break;
      }
      amal localamal = ambc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localamal != null) {
        localamal.a(this.jdField_a_of_type_Long, this.b, ambc.b(), ambc.a());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      amkr.a();
      if (QLog.isColorLevel()) {
        QLog.i("ChatPieApolloViewController", 1, "START");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloViewController == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloViewController = new alps();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if ((paramIntent != null) && (paramInt1 == 14002) && (paramInt2 == -1))
    {
      localObject = bchh.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localObject != null) {}
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          String str = paramIntent.getStringExtra("uin");
          paramInt1 = paramIntent.getIntExtra("uintype", -1);
          paramInt2 = paramIntent.getIntExtra("cmshow_game_id", -1);
          bfyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramInt1, (AbsStructMsg)localObject, null);
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(paramInt1), 0, new String[] { Integer.toString(paramInt2) });
          return;
          if (paramInt1 == 9999)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, "isActionBack");
              }
              ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(71)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 128, "apolloPanel");
            }
          }
          else if (paramInt1 == 14003)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, "check slave");
              }
              ((alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(null);
            }
          }
          else if (paramInt1 == 14004) {
            try
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloPanel != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloPanel.l();
                return;
              }
            }
            catch (Throwable paramIntent)
            {
              QLog.e("ApolloHelper", 1, paramIntent, new Object[0]);
              return;
            }
          }
        }
      } while ((paramInt1 != 14006) && (paramInt1 != 14005));
      localObject = alvx.a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).runRenderTask(new ApolloHelper.3(this, (ApolloSurfaceView)localObject, paramInt1, paramInt2, paramIntent));
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAuthcmShowDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAuthcmShowDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAuthcmShowDialog.dismiss();
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
            paramObject = (amir)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
            Object localObject3 = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
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
              String str3 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690045);
              String str4 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690045);
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
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, 0, paramObject, (CharSequence)localObject1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694576), (String)localObject3, (DialogInterface.OnClickListener)localObject2, new afpw(this));
              if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
                this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
              i = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
              localObject3 = "" + m;
              paramObject = str1;
              if (TextUtils.isEmpty(str1)) {
                paramObject = "0";
              }
              VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "add_action", (String)localObject2, i, 0, new String[] { localObject3, "", paramObject, String.valueOf(System.currentTimeMillis() / 1000L) });
              return;
            case 31004: 
            case 31005: 
              ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
              return;
            case 31006: 
              label579:
              paramObject = (String)((Map)localObject1).get("content");
              if (TextUtils.isEmpty(paramObject)) {
                paramObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690037);
              }
              break;
            }
            for (;;)
            {
              localObject1 = (String)((Map)localObject1).get("url");
              localObject1 = (String)localObject1 + "&actionid=" + m;
              str2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690036);
              localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690036);
              localObject2 = new afpv(this, (String)localObject1, m);
              VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "activity_alert_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "" + m, "1" });
              localObject1 = paramObject;
              paramObject = str2;
              break label579;
              QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690027), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
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
    return new int[] { 13, 6, 18, 4 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpu
 * JD-Core Version:    0.7.0.1
 */