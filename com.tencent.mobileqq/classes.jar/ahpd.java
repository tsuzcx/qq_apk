import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/item/view/ApolloIceBreakShow;", "", "context", "Landroid/content/Context;", "width", "", "height", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Landroid/content/Context;IILcom/tencent/mobileqq/app/QQAppInterface;)V", "mBrickPlayer", "Lcom/tencent/mobileqq/apollo/ApolloBrickPlayer;", "mCMSAction", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "mIsPlaying", "", "mSessionInfo", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "mType", "name", "", "getView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isPlaying", "isReady", "onSend", "", "chatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "pause", "play", "resume", "setJson", "jsonObject", "Lorg/json/JSONObject;", "sessionInfo", "stop", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ahpd
{
  public static final ahpe a;
  private static final String jdField_b_of_type_JavaLangString = "ApolloIceBreakShow";
  private static final String jdField_c_of_type_JavaLangString = "actionId";
  private static final String d = "id";
  private static final String e = "actionType";
  private static final String f = "extJson";
  private static final String g = "type";
  private static final String h = "name";
  private int jdField_a_of_type_Int;
  private final amlm jdField_a_of_type_Amlm;
  private final Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private CMSAction jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private final int jdField_c_of_type_Int;
  
  static
  {
    jdField_a_of_type_Ahpe = new ahpe(null);
  }
  
  public ahpd(@NotNull Context paramContext, int paramInt1, int paramInt2, @NotNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amlm = new amlm(new amnc(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public final View a()
  {
    return this.jdField_a_of_type_Amlm.a();
  }
  
  public final void a()
  {
    if (!a())
    {
      QLog.w(jdField_b_of_type_JavaLangString, 1, "play not ready");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      int i = ((CMSAction)localObject).a().f;
      localObject = (AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localSessionInfo == null) {
        Intrinsics.throwNpe();
      }
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "y_gjcbq_expose", "", ApolloUtil.b(localSessionInfo.curType), 0, new String[] { String.valueOf(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Amlm.a();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final void a(@Nullable BaseChatPie paramBaseChatPie)
  {
    QLog.d(jdField_b_of_type_JavaLangString, 1, "onSend");
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction != null)
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          int i = ((CMSAction)localObject).a().f;
          localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          localObject = ((CMSAction)localObject).a().jdField_b_of_type_JavaLangString;
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = "0";
            if (paramBaseChatPie != null)
            {
              AppInterface localAppInterface = (AppInterface)paramBaseChatPie.app;
              SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
              if (localSessionInfo == null) {
                Intrinsics.throwNpe();
              }
              VipUtils.a(localAppInterface, "cmshow", "Apollo", "y_gjcbq_click", "", ApolloUtil.b(localSessionInfo.curType), 0, new String[] { String.valueOf(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_JavaLangString });
            }
            anlv.a.a(paramBaseChatPie, i, 0, (String)localObject, this.jdField_a_of_type_Int, 3);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramBaseChatPie)
      {
        QLog.e(jdField_b_of_type_JavaLangString, 1, "onSend error", (Throwable)paramBaseChatPie);
        return;
      }
    }
  }
  
  public final void a(@Nullable JSONObject paramJSONObject, @Nullable SessionInfo paramSessionInfo)
  {
    if ((paramJSONObject == null) || (paramSessionInfo == null)) {
      return;
    }
    QLog.d(jdField_b_of_type_JavaLangString, 4, "setJson: json = " + paramJSONObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    Object localObject1;
    try
    {
      if (!paramJSONObject.has(jdField_c_of_type_JavaLangString)) {
        break label157;
      }
      localObject1 = paramJSONObject.get(jdField_c_of_type_JavaLangString);
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 1, "setJson error", (Throwable)paramJSONObject);
      return;
    }
    int i = ((Integer)localObject1).intValue();
    label100:
    Object localObject2;
    label157:
    label204:
    int j;
    label249:
    int k;
    label284:
    String str;
    for (;;)
    {
      if (i != -1)
      {
        try
        {
          localObject1 = paramJSONObject.get(e);
          if (localObject1 != null) {
            break label204;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        catch (Exception localException)
        {
          localObject2 = paramJSONObject.get(e);
          if (localObject2 != null) {
            break label249;
          }
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        if (paramJSONObject.has(d))
        {
          localObject2 = paramJSONObject.get(d);
          if (localObject2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
          }
          i = ((Integer)localObject2).intValue();
          continue;
          j = ((Integer)localObject2).intValue();
          while (paramJSONObject.has(g))
          {
            localObject2 = paramJSONObject.get(g);
            if (localObject2 == null)
            {
              throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
              j = Integer.parseInt((String)localObject2);
            }
            else
            {
              this.jdField_a_of_type_Int = ((Integer)localObject2).intValue();
            }
          }
          if (paramSessionInfo.troopUin == null) {
            break label526;
          }
          k = 1;
          paramSessionInfo = BaseApplicationImpl.getApplication();
          Intrinsics.checkExpressionValueIsNotNull(paramSessionInfo, "BaseApplicationImpl.getApplication()");
          paramSessionInfo = paramSessionInfo.getRuntime();
          Intrinsics.checkExpressionValueIsNotNull(paramSessionInfo, "BaseApplicationImpl.getApplication().runtime");
          str = paramSessionInfo.getAccount();
          localObject2 = "";
          paramSessionInfo = (SessionInfo)localObject2;
          if (this.jdField_a_of_type_Int == 1)
          {
            paramSessionInfo = (SessionInfo)localObject2;
            if (k == 0)
            {
              paramSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
              if (paramSessionInfo == null) {
                break label532;
              }
            }
          }
        }
      }
    }
    label526:
    label532:
    for (paramSessionInfo = paramSessionInfo.curFriendUin;; paramSessionInfo = null)
    {
      if (paramSessionInfo == null) {
        Intrinsics.throwNpe();
      }
      paramSessionInfo = paramSessionInfo.toString();
      localObject2 = "";
      if (paramJSONObject.has(f))
      {
        localObject2 = paramJSONObject.get(f);
        if (localObject2 == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        localObject2 = (String)localObject2;
      }
      Intrinsics.checkExpressionValueIsNotNull(str, "senderUin");
      this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = ((CMSAction)new amvo(i, j, str, paramSessionInfo, (String)localObject2));
      if (paramJSONObject.has(h))
      {
        paramJSONObject = paramJSONObject.get(h);
        if (paramJSONObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        this.jdField_a_of_type_JavaLangString = ((String)paramJSONObject);
      }
      this.jdField_a_of_type_Amlm.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction);
      QLog.d(jdField_b_of_type_JavaLangString, 4, "setJson: CMSCommonAction = " + this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction);
      return;
      i = -1;
      break label100;
      break;
      k = 0;
      break label284;
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction != null;
  }
  
  public final void b()
  {
    if (!a())
    {
      QLog.w(jdField_b_of_type_JavaLangString, 1, "pause not ready");
      return;
    }
    this.jdField_a_of_type_Amlm.c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public final boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final void c()
  {
    if (!a())
    {
      QLog.w(jdField_b_of_type_JavaLangString, 1, "stop not ready");
      return;
    }
    this.jdField_a_of_type_Amlm.d();
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = ((CMSAction)null);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpd
 * JD-Core Version:    0.7.0.1
 */