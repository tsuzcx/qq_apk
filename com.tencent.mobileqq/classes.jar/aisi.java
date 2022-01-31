import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class aisi
  implements Manager
{
  private airt jdField_a_of_type_Airt;
  private airz jdField_a_of_type_Airz;
  private aisa jdField_a_of_type_Aisa;
  private aisd jdField_a_of_type_Aisd;
  private aise jdField_a_of_type_Aise;
  private aish jdField_a_of_type_Aish;
  private aisj jdField_a_of_type_Aisj;
  private aiwm jdField_a_of_type_Aiwm;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<aisu>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public aisi(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_Aisd = new aisd(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_Aisd);
    this.jdField_a_of_type_Aisj = new aisj(this.jdField_a_of_type_Aisd, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_Aish = new aish(this.jdField_a_of_type_Aisd, this.jdField_a_of_type_Aisj);
    this.jdField_a_of_type_Aise = new aise(this.jdField_a_of_type_Aisd);
    this.jdField_a_of_type_Aisa = new aisa(this.jdField_a_of_type_Aisd, this.jdField_a_of_type_Aisj, this.jdField_a_of_type_Aise);
    this.jdField_a_of_type_Aisd.a(this.jdField_a_of_type_Aise);
  }
  
  public airt a()
  {
    return this.jdField_a_of_type_Airt;
  }
  
  public airz a()
  {
    return this.jdField_a_of_type_Airz;
  }
  
  public aisa a()
  {
    return this.jdField_a_of_type_Aisa;
  }
  
  public aisd a()
  {
    return this.jdField_a_of_type_Aisd;
  }
  
  public aise a()
  {
    return this.jdField_a_of_type_Aise;
  }
  
  public aish a()
  {
    return this.jdField_a_of_type_Aish;
  }
  
  public aisj a()
  {
    return this.jdField_a_of_type_Aisj;
  }
  
  public aiwm a()
  {
    return this.jdField_a_of_type_Aiwm;
  }
  
  public SpriteUIHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aisa != null) {
      this.jdField_a_of_type_Aisa.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!aisl.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = aisl.a(a());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.jdField_a_of_type_Airz == null);
    this.jdField_a_of_type_Airz.c();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = aisl.a(a());
    if (localObject != null) {
      ((airu)localObject).a(paramInt, paramArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aisu localaisu = (aisu)((WeakReference)((Iterator)localObject).next()).get();
      if (localaisu != null) {
        localaisu.a(paramInt, paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      aixo.a(aisl.b(this.jdField_a_of_type_Aisd.e), 1, paramInt, 0L, paramVarArgs);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      aisu localaisu = (aisu)((WeakReference)localIterator.next()).get();
      if (localaisu != null) {
        localaisu.a(paramInt, paramVarArgs);
      }
    }
  }
  
  public void a(aiii paramaiii)
  {
    if (paramaiii == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Aisd.a(paramaiii);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Aisd.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramaiii);
  }
  
  public void a(aisu paramaisu)
  {
    if (paramaisu != null)
    {
      paramaisu = new WeakReference(paramaisu);
      this.jdField_a_of_type_JavaUtilList.add(paramaisu);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Aisd.a(paramBaseChatPie);
    paramBaseChatPie = a();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (aigu)paramBaseChatPie.getManager(232);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_Aiwm == null) {
      this.jdField_a_of_type_Aiwm = new aiwm(this.jdField_a_of_type_Aisd);
    }
    if (this.jdField_a_of_type_Airt == null) {
      this.jdField_a_of_type_Airt = new airt(this.jdField_a_of_type_Aisd);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.jdField_a_of_type_Aisd.a(paramSessionInfo.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Aisd.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_Airz = new airz(this.jdField_a_of_type_Aisd, paramApolloTextureView);
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.d(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_Aisd == null) || (this.jdField_a_of_type_Aisa == null) || (this.jdField_a_of_type_Aish == null)) {
      return;
    }
    this.jdField_a_of_type_Aisd.c(true);
    int i = aisl.b(this.jdField_a_of_type_Aisd.e);
    this.jdField_a_of_type_Aisd.b(i);
    if (!this.jdField_a_of_type_Aisd.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_Aisd.a(paramInt, 0);
    this.jdField_a_of_type_Aisd.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aisd.b();
    this.jdField_a_of_type_Aisd.a();
    if (!aisl.b(a(), paramInt, paramString))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    aixo.a(i, 200);
    this.jdField_a_of_type_Aisa.a(this.jdField_a_of_type_Aiwm);
    this.jdField_a_of_type_Aish.a();
    aixo.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Aisd.b(true);
    QQAppInterface localQQAppInterface;
    if (!this.jdField_a_of_type_Aisj.b(null))
    {
      aixo.a(i, 300);
      this.jdField_a_of_type_Aisa.a(this.jdField_a_of_type_Aisd);
      aixo.a(i, 300, 0, new Object[] { "initSprite done" });
      aixo.a(i, 1, 0, new Object[] { "terminal all done" });
      aixo.a(i, null, new int[] { aixn.a(i, false, this.jdField_a_of_type_Aisd.b, paramInt, true) });
      this.jdField_a_of_type_Boolean = true;
      localQQAppInterface = a();
      if (this.jdField_a_of_type_Aisd.d != 1) {
        break label421;
      }
    }
    label421:
    for (i = 1;; i = 0)
    {
      bajr.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ApolloUtil.h(this.jdField_a_of_type_Aisd.b), new String[] { Integer.toString(ApolloUtil.b(paramInt)), "", "", paramString });
      return;
      aixo.a(i, null, new int[] { aixn.a(i, true, this.jdField_a_of_type_Aisd.b, paramInt, true) });
      break;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!aisl.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = aisl.a(a());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.jdField_a_of_type_Airz == null);
    this.jdField_a_of_type_Airz.d();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aise != null) {
      this.jdField_a_of_type_Aise.a();
    }
    Object localObject = this.jdField_a_of_type_Aisd.a();
    if (localObject != null)
    {
      localObject = ((aiii)localObject).getRenderImpl();
      if (localObject != null) {
        ((aigt)localObject).c();
      }
    }
    if (this.jdField_a_of_type_Aiwm != null)
    {
      this.jdField_a_of_type_Aiwm.a();
      this.jdField_a_of_type_Aiwm = null;
    }
    if (this.jdField_a_of_type_Airt != null)
    {
      this.jdField_a_of_type_Airt.a();
      this.jdField_a_of_type_Airt = null;
    }
    if (this.jdField_a_of_type_Airz != null)
    {
      this.jdField_a_of_type_Airz.f();
      this.jdField_a_of_type_Airz = null;
    }
    this.jdField_a_of_type_Aisj.a();
    this.jdField_a_of_type_Aish.b();
    this.jdField_a_of_type_Aisa.b();
    this.jdField_a_of_type_Aisd.c();
    this.jdField_a_of_type_Boolean = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = a();
    if (localObject == null) {}
    while (this.jdField_a_of_type_Aisd.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Aisd.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisi
 * JD-Core Version:    0.7.0.1
 */