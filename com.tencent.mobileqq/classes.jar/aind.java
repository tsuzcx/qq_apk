import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingFragment;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.2;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.List;

public class aind
  extends QIPCModule
{
  public static boolean a;
  public static boolean b;
  private long jdField_a_of_type_Long;
  private aipp jdField_a_of_type_Aipp = new aipp();
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  private WeakReference<CmGameLoadingFragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean c;
  
  public aind(String paramString)
  {
    super(paramString);
  }
  
  public static aind a()
  {
    return ainf.a();
  }
  
  public static void b()
  {
    aind localaind = a();
    if (!jdField_a_of_type_Boolean)
    {
      QIPCServerHelper.getInstance().register(localaind);
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aipp != null) {
      return this.jdField_a_of_type_Aipp.a();
    }
    QLog.w("cmgame_process.CmGameServerQIPCModule", 1, "no running game.");
    return -1;
  }
  
  public aipo a(int paramInt)
  {
    if (this.jdField_a_of_type_Aipp != null) {
      return this.jdField_a_of_type_Aipp.a(paramInt);
    }
    return null;
  }
  
  public aipp a()
  {
    return this.jdField_a_of_type_Aipp;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "closeAllGames");
    }
    if (this.jdField_a_of_type_Aipp != null)
    {
      List localList = this.jdField_a_of_type_Aipp.a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          aipo localaipo = (aipo)localList.get(i);
          if ((localaipo != null) && (!aing.a(localaipo.a())) && (!aing.a(localaipo.a())))
          {
            ainb.a(localaipo.a());
            QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "closeAllGame gameId:" + localaipo.a());
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", System.currentTimeMillis());
    localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_start_cmgame_direct", localBundle, null);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong, CmGameInitParams paramCmGameInitParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "onGameLoadingCheckEnd cmGameInitParams:", paramCmGameInitParams });
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
    if (paramStartCheckParam != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    }
    this.jdField_a_of_type_Long = paramLong;
    if (paramLong != 0L) {
      ApolloGameUtil.a(paramStartCheckParam, true);
    }
    this.c = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (aing.a(BaseApplicationImpl.getContext())))
    {
      paramStartCheckParam = new Bundle();
      paramStartCheckParam.putSerializable("StartCheckParam", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      paramStartCheckParam.putLong("ResultCode", this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
        paramStartCheckParam.putSerializable("CmGameInitParams", this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams);
      }
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_check_game_data", paramStartCheckParam, null);
    }
  }
  
  public void a(CmGameLoadingFragment paramCmGameLoadingFragment, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCmGameLoadingFragment);
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "onGameLoadingStart startCheckParam:", paramStartCheckParam });
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpen", paramBoolean);
    localBundle.putString("key_game_friUin", paramString);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_update_audio_status", localBundle, null);
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "onGameLoadingCheckEnd startCheckParam:", paramStartCheckParam });
    }
    ApolloGameUtil.a(paramStartCheckParam, true);
    paramStartCheckParam = new Bundle();
    paramStartCheckParam.putSerializable("StartCheckParam", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    paramStartCheckParam.putLong("ResultCode", this.jdField_a_of_type_Long);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_game_loading_closed", paramStartCheckParam, null);
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    super.callbackResult(paramInt, paramEIPCResult);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "onCall main server action=" + paramString);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {}
    label1153:
    label1264:
    label1267:
    label1269:
    label1272:
    label1274:
    label1277:
    for (;;)
    {
      return null;
      try
      {
        if ("action_aduio_query_voice_status".equals(paramString))
        {
          paramString = paramBundle.getString("key_game_friUin");
          paramBundle = (aifg)((QQAppInterface)localObject).getManager(153);
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("isOpen", paramBundle.a().a(paramString));
          ((Bundle)localObject).putBoolean("display", aily.b);
          callbackResult(paramInt, EIPCResult.createSuccessResult((Bundle)localObject));
          return null;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameServerQIPCModule", 1, paramString, new Object[0]);
        return null;
      }
      if ("action_audio_exit_room".equals(paramString))
      {
        paramString = paramBundle.getString("key_game_friUin");
        ((aifg)((QQAppInterface)localObject).getManager(153)).a().c(paramString, 318);
        return null;
      }
      if ("action_aduio_enter_room".equals(paramString))
      {
        paramString = paramBundle.getString("key_game_friUin");
        boolean bool = paramBundle.getBoolean("key_open_voice", false);
        paramBundle = ((aifg)((QQAppInterface)localObject).getManager(153)).a();
        if ((bool) || ((aily.jdField_a_of_type_Boolean) && (!paramBundle.b())))
        {
          paramBundle.b(paramString, 318);
          return null;
        }
      }
      else
      {
        if ("action_voice_switch".equals(paramString))
        {
          paramString = paramBundle.getString("key_game_friUin");
          ((aifg)((QQAppInterface)localObject).getManager(153)).a().a(paramString, 318);
          return null;
        }
        if ("action_chanel_req".equals(paramString))
        {
          CmGameCmdChannel.a((QQAppInterface)localObject).a(paramBundle.getString("cmd"), paramBundle.getString("reqData"), paramBundle.getBoolean("async"), paramInt, paramBundle.getInt("gameId"));
          return null;
        }
        int i;
        if ("action_get_accountInfo".equals(paramString))
        {
          i = paramBundle.getInt("type");
          paramString = paramBundle.getString("uin");
          CmGameCmdChannel.a((QQAppInterface)localObject).a(paramInt, paramString, i);
          return null;
        }
        if ("action_loadyoutu".equals(paramString))
        {
          paramString = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramString == null) || (!(paramString instanceof QQAppInterface))) {
            break label1274;
          }
        }
        for (paramString = (QQAppInterface)paramString;; paramString = null)
        {
          if (paramString == null) {
            break label1277;
          }
          paramString = new nsx(paramString, BaseApplicationImpl.getContext());
          b = true;
          paramString.a(new aine(this, paramInt));
          paramString.a();
          return null;
          if ("onGameCheckStart".equals(paramString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_START_CHECKER_ONGAMECHECKSTART" });
            }
            if (paramBundle == null) {
              break;
            }
            paramString = aing.a();
            if (!(paramString instanceof QQAppInterface)) {
              break;
            }
            paramString = (QQAppInterface)paramString;
            paramBundle = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
            if (paramBundle == null) {
              break;
            }
            if (aing.a(paramBundle.gameId))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "the game is IsLand");
              return null;
            }
            ApolloGameUtil.a(paramString, paramBundle);
            return null;
          }
          if ("onDownloadGameResDown".equals(paramString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_START_CHECKER_ONDOWNLOADGAMERESDOWN" });
            }
            if (paramBundle == null) {
              break;
            }
            paramString = aing.a();
            if (!(paramString instanceof QQAppInterface)) {
              break;
            }
            paramString = (QQAppInterface)paramString;
            paramBundle = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
            if ((paramBundle == null) || (paramBundle.game == null)) {
              break;
            }
            ApolloGameUtil.b(paramString, paramBundle);
            return null;
          }
          int j;
          if ("game_activity_lifecycle".equals(paramString))
          {
            paramInt = paramBundle.getInt("gameId");
            i = paramBundle.getInt("status");
            j = paramBundle.getInt("activityId");
            paramString = paramBundle.getSerializable("para");
            if ((paramString == null) || (!(paramString instanceof CmGameStartChecker.StartCheckParam))) {
              break label1269;
            }
          }
          for (paramString = (CmGameStartChecker.StartCheckParam)paramString;; paramString = null)
          {
            if (this.jdField_a_of_type_Aipp == null) {
              break label1272;
            }
            this.jdField_a_of_type_Aipp.a(paramInt, i, j, paramString);
            return null;
            if ("action_get_action_data".equals(paramString))
            {
              if (QLog.isColorLevel()) {
                QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_GET_ACTION_DATA params:" + paramBundle });
              }
              paramString = BaseApplicationImpl.getApplication().getRuntime();
              if ((paramString == null) || (!(paramString instanceof QQAppInterface))) {
                break label1264;
              }
            }
            for (paramString = (QQAppInterface)paramString;; paramString = null)
            {
              if (paramString == null) {
                break label1267;
              }
              ThreadManager.post(new CmGameServerQIPCModule.2(this, paramString, paramBundle.getString("reqData"), paramInt), 5, null, true);
              return null;
              if ("action_update_game_push".equals(paramString))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_UPDATE_GAME_PUSH params:" + paramBundle);
                }
                paramString = (QQAppInterface)aing.a();
                if (paramString == null) {
                  break;
                }
                paramBundle = (CmGamePushItem)paramBundle.getSerializable("CmGamePushItem");
                if (paramBundle == null) {
                  break;
                }
                ((aifg)paramString.getManager(153)).a().a(paramBundle);
                return null;
              }
              if ("action_query_check_game_data".equals(paramString))
              {
                paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
                if (QLog.isColorLevel()) {
                  QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_QUERY_CHECK_GAME_DATA params:" + paramString);
                }
                if (paramString == null) {
                  break;
                }
                paramBundle = new Bundle();
                if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mCreateTs != paramString.mCreateTs))
                {
                  paramBundle.putInt("result", -1);
                  paramBundle.putSerializable("StartCheckParam", paramString);
                  callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
                }
                for (;;)
                {
                  if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
                    break label1153;
                  }
                  paramString = (CmGameLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                  if (paramString == null) {
                    break;
                  }
                  paramString.a(this.c);
                  return null;
                  if (this.c)
                  {
                    paramBundle.putInt("result", 0);
                    paramBundle.putLong("ResultCode", this.jdField_a_of_type_Long);
                    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
                      paramBundle.putSerializable("CmGameInitParams", this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams);
                    }
                    paramBundle.putSerializable("StartCheckParam", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
                    callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
                  }
                  else
                  {
                    QLog.e("cmgame_process.CmGameServerQIPCModule", 1, "ACTION_QUERY_CHECK_GAME_DATA mCheckGameEnd false");
                  }
                }
                break;
              }
              if (!"action_on_game_activity_closed".equals(paramString)) {
                break;
              }
              paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
              if (QLog.isColorLevel()) {
                QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_ON_GAME_ACTIVITY_CLOSED params:" + paramString);
              }
              if ((paramString == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null)) {
                break;
              }
              paramString = (CmGameLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
              if ((paramString == null) || (paramString.getActivity() == null)) {
                break;
              }
              paramString.a(100L);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_ON_GAME_ACTIVITY_CLOSED close loadingView");
              return null;
            }
            break;
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aind
 * JD-Core Version:    0.7.0.1
 */