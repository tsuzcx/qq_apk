import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingFragment;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.2;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.3;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.5;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class aizw
  extends QIPCModule
{
  public static boolean a;
  public static boolean b;
  private long jdField_a_of_type_Long;
  private ajcn jdField_a_of_type_Ajcn = new ajcn();
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  private WeakReference<CmGameLoadingFragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean c;
  
  public aizw(String paramString)
  {
    super(paramString);
  }
  
  public static aizw a()
  {
    return ajad.a();
  }
  
  public static void b()
  {
    aizw localaizw = a();
    if (!jdField_a_of_type_Boolean)
    {
      QIPCServerHelper.getInstance().register(localaizw);
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Ajcn != null) {
      return this.jdField_a_of_type_Ajcn.a();
    }
    QLog.w("cmgame_process.CmGameServerQIPCModule", 1, "no running game.");
    return -1;
  }
  
  public ajcm a(int paramInt)
  {
    if (this.jdField_a_of_type_Ajcn != null) {
      return this.jdField_a_of_type_Ajcn.a(paramInt);
    }
    return null;
  }
  
  public ajcn a()
  {
    return this.jdField_a_of_type_Ajcn;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "closeAllGames");
    }
    if (this.jdField_a_of_type_Ajcn != null)
    {
      List localList = this.jdField_a_of_type_Ajcn.a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          ajcm localajcm = (ajcm)localList.get(i);
          if ((localajcm != null) && (!ajae.a(localajcm.a())) && (!ajae.a(localajcm.a())))
          {
            aizu.a(localajcm.a());
            QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "closeAllGame gameId:" + localajcm.a());
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
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (ajae.a(BaseApplicationImpl.getContext())))
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
  
  public void a(ArrayList<String> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("CmShow onDressChanged uins.size:");
      if (paramArrayList == null) {
        break label80;
      }
    }
    label80:
    for (int i = paramArrayList.size();; i = 0)
    {
      QLog.i("cmgame_process.CmGameServerQIPCModule", 1, i);
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("key_dress_change_uin", paramArrayList);
      QIPCServerHelper.getInstance().callClient(LocalMultiProcConfig.PROCESS_NAME, "cm_game_client_module", "action_dress_changed", (Bundle)localObject, new ajac(this));
      return;
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
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface)) {
      return null;
    }
    try
    {
      if ("action_aduio_query_voice_status".equals(paramString))
      {
        paramString = paramBundle.getString("key_game_friUin");
        paramBundle = (airz)((QQAppInterface)localObject1).getManager(153);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("isOpen", paramBundle.a().a(paramString));
        ((Bundle)localObject1).putBoolean("display", aiyr.b);
        callbackResult(paramInt, EIPCResult.createSuccessResult((Bundle)localObject1));
      }
      else if ("action_audio_exit_room".equals(paramString))
      {
        paramString = paramBundle.getString("key_game_friUin");
        ((airz)((QQAppInterface)localObject1).getManager(153)).a().c(paramString, 318);
      }
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameServerQIPCModule", 1, paramString, new Object[0]);
    }
    int i;
    label518:
    label629:
    int j;
    if ("action_aduio_enter_room".equals(paramString))
    {
      paramString = paramBundle.getString("key_game_friUin");
      boolean bool = paramBundle.getBoolean("key_open_voice", false);
      paramBundle = ((airz)((QQAppInterface)localObject1).getManager(153)).a();
      if ((bool) || ((aiyr.jdField_a_of_type_Boolean) && (!paramBundle.b()))) {
        paramBundle.b(paramString, 318);
      }
    }
    else if ("action_voice_switch".equals(paramString))
    {
      paramString = paramBundle.getString("key_game_friUin");
      ((airz)((QQAppInterface)localObject1).getManager(153)).a().a(paramString, 318);
    }
    else if ("action_chanel_req".equals(paramString))
    {
      CmGameCmdChannel.a((QQAppInterface)localObject1).a(paramBundle.getString("cmd"), paramBundle.getString("reqData"), paramBundle.getBoolean("async"), paramInt, paramBundle.getInt("gameId"));
    }
    else if ("action_get_accountInfo".equals(paramString))
    {
      i = paramBundle.getInt("type");
      paramString = paramBundle.getString("uin");
      CmGameCmdChannel.a((QQAppInterface)localObject1).a(paramInt, paramString, i);
    }
    else if ("action_loadyoutu".equals(paramString))
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString != null) && ((paramString instanceof QQAppInterface)))
      {
        paramString = (QQAppInterface)paramString;
        break label2203;
        paramString = new oeh(paramString, BaseApplicationImpl.getContext());
        b = true;
        paramString.a(new aizx(this, paramInt));
        paramString.a();
        break label2201;
      }
    }
    else
    {
      if ("onGameCheckStart".equals(paramString))
      {
        if (!QLog.isColorLevel()) {
          break label2209;
        }
        QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_START_CHECKER_ONGAMECHECKSTART" });
        break label2209;
        paramString = ajae.a();
        if (!(paramString instanceof QQAppInterface)) {
          return null;
        }
        paramString = (QQAppInterface)paramString;
        paramBundle = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        if (paramBundle == null) {
          return null;
        }
        if (ajae.a(paramBundle.gameId))
        {
          if (!QLog.isColorLevel()) {
            break label2215;
          }
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "the game is IsLand");
          break label2215;
        }
        ApolloGameUtil.a(paramString, paramBundle);
        break label2201;
      }
      if ("onDownloadGameResDown".equals(paramString))
      {
        if (!QLog.isColorLevel()) {
          break label2217;
        }
        QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_START_CHECKER_ONDOWNLOADGAMERESDOWN" });
        break label2217;
        paramString = ajae.a();
        if (!(paramString instanceof QQAppInterface)) {
          return null;
        }
        paramString = (QQAppInterface)paramString;
        paramBundle = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        if ((paramBundle == null) || (paramBundle.game == null)) {
          break label2223;
        }
        ApolloGameUtil.b(paramString, paramBundle);
        break label2201;
      }
      if ("game_activity_lifecycle".equals(paramString))
      {
        paramInt = paramBundle.getInt("gameId");
        i = paramBundle.getInt("status");
        j = paramBundle.getInt("activityId");
        paramString = paramBundle.getSerializable("para");
        if ((paramString != null) && ((paramString instanceof CmGameStartChecker.StartCheckParam)))
        {
          paramString = (CmGameStartChecker.StartCheckParam)paramString;
          label739:
          if (this.jdField_a_of_type_Ajcn == null) {
            break label2201;
          }
          this.jdField_a_of_type_Ajcn.a(paramInt, i, j, paramString);
          break label2201;
        }
      }
      else if ("action_get_action_data".equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_GET_ACTION_DATA params:" + paramBundle });
        }
        paramString = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramString == null) || (!(paramString instanceof QQAppInterface))) {
          break label2186;
        }
        paramString = (QQAppInterface)paramString;
      }
    }
    label2186:
    label2201:
    label2203:
    label2209:
    label2215:
    label2217:
    label2223:
    while (paramString != null)
    {
      ThreadManager.post(new CmGameServerQIPCModule.2(this, paramString, paramBundle.getString("reqData"), paramInt), 5, null, true);
      break label2201;
      if ("action_update_game_push".equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_UPDATE_GAME_PUSH params:" + paramBundle);
        }
        paramString = (QQAppInterface)ajae.a();
        if (paramString == null) {
          return null;
        }
        paramBundle = (CmGamePushItem)paramBundle.getSerializable("CmGamePushItem");
        if (paramBundle != null) {
          ((airz)paramString.getManager(153)).a().a(paramBundle);
        }
      }
      else if ("action_query_check_game_data".equals(paramString))
      {
        paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_QUERY_CHECK_GAME_DATA params:" + paramString);
        }
        if (paramString != null)
        {
          paramBundle = new Bundle();
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mCreateTs != paramString.mCreateTs))
          {
            paramBundle.putInt("result", -1);
            paramBundle.putSerializable("StartCheckParam", paramString);
            callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
          }
          while (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            paramString = (CmGameLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramString == null) {
              break;
            }
            paramString.a(this.c);
            break;
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
        }
      }
      else if ("action_on_game_activity_closed".equals(paramString))
      {
        paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_ON_GAME_ACTIVITY_CLOSED params:" + paramString);
        }
        if ((paramString != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
        {
          paramString = (CmGameLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((paramString != null) && (paramString.getActivity() != null))
          {
            paramString.a(100L);
            if (QLog.isColorLevel()) {
              QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_ON_GAME_ACTIVITY_CLOSED close loadingView");
            }
          }
        }
      }
      else if ("action_render_view_get_initavatar_js".equals(paramString))
      {
        paramBundle.setClassLoader(IPCSpriteContext.class.getClassLoader());
        ThreadManagerV2.excute(new CmGameServerQIPCModule.3(this, (IPCSpriteContext)paramBundle.getParcelable("IPCSpriteContext"), paramInt), 16, null, false);
      }
      else if ("action_render_view_get_base_data".equals(paramString))
      {
        if ((localObject1 instanceof QQAppInterface)) {
          ajkk.a((QQAppInterface)localObject1);
        }
        paramString = new Bundle();
        paramString.putString("sApolloBaseScriptId", ajmu.au);
        callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
      }
      else
      {
        Object localObject2;
        if ("action_init_cmshow_data".equals(paramString))
        {
          paramString = paramBundle.getString("selfUin");
          paramBundle = paramBundle.getString("friendUin");
          QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA selfUin:" + ApolloUtil.d(paramString) + " friendUin:" + ApolloUtil.d(paramBundle));
          if ((localObject1 instanceof QQAppInterface))
          {
            Object localObject3 = (airz)((QQAppInterface)localObject1).getManager(153);
            localObject1 = (bbqp)((QQAppInterface)localObject1).a(71);
            localObject2 = ((airz)localObject3).b(paramString);
            ApolloBaseInfo localApolloBaseInfo = ((airz)localObject3).b(paramBundle);
            localObject3 = new ArrayList();
            if ((localObject2 == null) || (((ApolloBaseInfo)localObject2).apolloLocalTS != ((ApolloBaseInfo)localObject2).apolloServerTS)) {
              ((List)localObject3).add(paramString);
            }
            if ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS)) {
              ((List)localObject3).add(paramBundle);
            }
            if (!((List)localObject3).isEmpty())
            {
              QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA but ApolloBaseInfo need update size:" + ((List)localObject3).size());
              localObject2 = new String[((List)localObject3).size()];
              i = 0;
              while (i < ((List)localObject3).size())
              {
                localObject2[i] = ((String)((List)localObject3).get(i));
                i += 1;
              }
              ((bbqp)localObject1).a(new aizy(this, (List)localObject3, paramString, paramBundle, paramInt));
              ((bbqp)localObject1).a((String[])localObject2);
            }
            else
            {
              i = airz.a(ApolloUtil.a(), paramString, true);
              j = airz.a(ApolloUtil.a(), paramBundle, true);
              paramString = new Bundle();
              paramString.putInt("selfUinStatus", i);
              paramString.putInt("friendUinStatus", j);
              callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
            }
          }
        }
        else if ("action_render_view_play_action".equals(paramString))
        {
          long l = System.currentTimeMillis();
          QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "CmShow ACTION_RENDER_VIEW_PLAY_ACTION");
          paramBundle.setClassLoader(IPCSpriteContext.class.getClassLoader());
          paramString = (IPCSpriteContext)paramBundle.getParcelable("IPCSpriteContext");
          paramBundle = (CmShowRenderView.PlayActionConfig)paramBundle.getParcelable("PlayActionConfig");
          if ((paramBundle == null) || (paramString == null))
          {
            QLog.e("cmgame_process.CmGameServerQIPCModule", 1, "ACTION_RENDER_VIEW_PLAY_ACTION playActionConfig == null || ipcSpriteContext == null");
            return null;
          }
          i = paramBundle.a;
          j = paramBundle.b;
          localObject1 = new SpriteTaskParam();
          ((SpriteTaskParam)localObject1).f = i;
          ThreadManagerV2.excute(new CmGameServerQIPCModule.5(this, i, (SpriteTaskParam)localObject1, paramString, j, paramBundle, l, paramInt), 16, null, false);
        }
        else if ("action_render_view_preload_res".equals(paramString))
        {
          QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "CmShow ACTION_RENDER_VIEW_PRELOAD_RES");
          paramString = paramBundle.getIntArray("actionIds");
          if ((paramString == null) || (paramString.length < 0))
          {
            QLog.e("cmgame_process.CmGameServerQIPCModule", 1, "ACTION_RENDER_VIEW_PRELOAD_RES actionIds==null");
            callbackResult(paramInt, EIPCResult.createResult(-1, null));
          }
          else
          {
            paramBundle = new ArrayList();
            i = 0;
            while (i < paramString.length)
            {
              localObject1 = ajfj.a(ApolloUtil.a(), paramString[i]);
              localObject2 = new ajid(3, paramString[i]);
              ((ajid)localObject2).c = ((ApolloActionData)localObject1).actionType;
              paramBundle.add(localObject2);
              i += 1;
            }
            ajhw.a(ApolloUtil.a(), "", new ajaa(this, paramInt), paramBundle, false);
          }
        }
        else if ("action_render_view_open_store".equals(paramString))
        {
          paramString = paramBundle.getString("url");
          ApolloUtil.a(BaseApplicationImpl.getContext(), null, null, paramString, null);
          QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_OPEN_STORE url:" + paramString);
          callbackResult(paramInt, EIPCResult.createResult(0, null));
        }
        else if ("action_render_view_change_mode".equals(paramString))
        {
          i = paramBundle.getInt("mode");
          paramString = (bbqp)((QQAppInterface)localObject1).a(71);
          paramString.a(new ajab(this, paramString, paramInt));
          if (i == 2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            paramString.c("cmshow_sdk", paramInt);
            break;
          }
          paramString = null;
          continue;
          paramString = null;
          break label739;
          paramString = null;
          break label2203;
        }
      }
      return null;
      if (paramString != null) {
        break;
      }
      return null;
      if (paramBundle != null) {
        break label518;
      }
      return null;
      return null;
      if (paramBundle != null) {
        break label629;
      }
      return null;
      return null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aizw
 * JD-Core Version:    0.7.0.1
 */