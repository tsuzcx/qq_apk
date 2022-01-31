import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class ajfe
  implements Manager
{
  private ajep jdField_a_of_type_Ajep;
  private ajev jdField_a_of_type_Ajev;
  private ajew jdField_a_of_type_Ajew;
  private ajez jdField_a_of_type_Ajez;
  private ajfa jdField_a_of_type_Ajfa;
  private ajfd jdField_a_of_type_Ajfd;
  private ajff jdField_a_of_type_Ajff;
  private ajkm jdField_a_of_type_Ajkm;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<ajfq>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public ajfe(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_Ajez = new ajez(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_Ajez);
    this.jdField_a_of_type_Ajff = new ajff(this.jdField_a_of_type_Ajez, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_Ajfd = new ajfd(this.jdField_a_of_type_Ajez, this.jdField_a_of_type_Ajff);
    this.jdField_a_of_type_Ajfa = new ajfa(this.jdField_a_of_type_Ajez);
    this.jdField_a_of_type_Ajew = new ajew(this.jdField_a_of_type_Ajez, this.jdField_a_of_type_Ajff, this.jdField_a_of_type_Ajfa);
    this.jdField_a_of_type_Ajez.a(this.jdField_a_of_type_Ajfa);
  }
  
  public ajep a()
  {
    return this.jdField_a_of_type_Ajep;
  }
  
  public ajev a()
  {
    return this.jdField_a_of_type_Ajev;
  }
  
  public ajew a()
  {
    return this.jdField_a_of_type_Ajew;
  }
  
  public ajez a()
  {
    return this.jdField_a_of_type_Ajez;
  }
  
  public ajfa a()
  {
    return this.jdField_a_of_type_Ajfa;
  }
  
  public ajfd a()
  {
    return this.jdField_a_of_type_Ajfd;
  }
  
  public ajff a()
  {
    return this.jdField_a_of_type_Ajff;
  }
  
  public ajkm a()
  {
    return this.jdField_a_of_type_Ajkm;
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
    if (this.jdField_a_of_type_Ajew != null) {
      this.jdField_a_of_type_Ajew.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!ajfh.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = ajfh.a(a());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.jdField_a_of_type_Ajev == null);
    this.jdField_a_of_type_Ajev.c();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = ajfh.a(a());
    if (localObject != null) {
      ((ajeq)localObject).a(paramInt, paramArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ajfq localajfq = (ajfq)((WeakReference)((Iterator)localObject).next()).get();
      if (localajfq != null) {
        localajfq.a(paramInt, paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      ajlo.a(ajfh.b(this.jdField_a_of_type_Ajez.e), 1, paramInt, 0L, paramVarArgs);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ajfq localajfq = (ajfq)((WeakReference)localIterator.next()).get();
      if (localajfq != null) {
        localajfq.a(paramInt, paramVarArgs);
      }
    }
  }
  
  public void a(aiuz paramaiuz)
  {
    if (paramaiuz == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Ajez.a(paramaiuz);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ajez.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramaiuz);
  }
  
  public void a(ajfq paramajfq)
  {
    if (paramajfq != null)
    {
      paramajfq = new WeakReference(paramajfq);
      this.jdField_a_of_type_JavaUtilList.add(paramajfq);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Ajez.a(paramBaseChatPie);
    paramBaseChatPie = a();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (aitl)paramBaseChatPie.getManager(232);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_Ajkm == null) {
      this.jdField_a_of_type_Ajkm = new ajkm(this.jdField_a_of_type_Ajez);
    }
    if (this.jdField_a_of_type_Ajep == null) {
      this.jdField_a_of_type_Ajep = new ajep(this.jdField_a_of_type_Ajez);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.jdField_a_of_type_Ajez.a(paramSessionInfo.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Ajez.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_Ajev = new ajev(this.jdField_a_of_type_Ajez, paramApolloTextureView);
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.d(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_Ajez == null) || (this.jdField_a_of_type_Ajew == null) || (this.jdField_a_of_type_Ajfd == null)) {
      return;
    }
    this.jdField_a_of_type_Ajez.c(true);
    int i = ajfh.b(this.jdField_a_of_type_Ajez.e);
    this.jdField_a_of_type_Ajez.b(i);
    if (!this.jdField_a_of_type_Ajez.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_Ajez.a(paramInt, 0);
    this.jdField_a_of_type_Ajez.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ajez.b();
    this.jdField_a_of_type_Ajez.a();
    if (!ajfh.b(a(), paramInt, paramString))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    ajlo.a(i, 200);
    this.jdField_a_of_type_Ajew.a(this.jdField_a_of_type_Ajkm);
    this.jdField_a_of_type_Ajfd.a();
    ajlo.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Ajez.b(true);
    QQAppInterface localQQAppInterface;
    if (!this.jdField_a_of_type_Ajff.b(null))
    {
      ajlo.a(i, 300);
      this.jdField_a_of_type_Ajew.a(this.jdField_a_of_type_Ajez);
      ajlo.a(i, 300, 0, new Object[] { "initSprite done" });
      ajlo.a(i, 1, 0, new Object[] { "terminal all done" });
      ajlo.a(i, null, new int[] { ajln.a(i, false, this.jdField_a_of_type_Ajez.b, paramInt, true) });
      this.jdField_a_of_type_Boolean = true;
      localQQAppInterface = a();
      if (this.jdField_a_of_type_Ajez.d != 1) {
        break label421;
      }
    }
    label421:
    for (i = 1;; i = 0)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ApolloUtil.h(this.jdField_a_of_type_Ajez.b), new String[] { Integer.toString(ApolloUtil.b(paramInt)), "", "", paramString });
      return;
      ajlo.a(i, null, new int[] { ajln.a(i, true, this.jdField_a_of_type_Ajez.b, paramInt, true) });
      break;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!ajfh.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = ajfh.a(a());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.jdField_a_of_type_Ajev == null);
    this.jdField_a_of_type_Ajev.d();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Ajfa != null) {
      this.jdField_a_of_type_Ajfa.a();
    }
    Object localObject = this.jdField_a_of_type_Ajez.a();
    if (localObject != null)
    {
      localObject = ((aiuz)localObject).getRenderImpl();
      if (localObject != null) {
        ((aitk)localObject).c();
      }
    }
    if (this.jdField_a_of_type_Ajkm != null)
    {
      this.jdField_a_of_type_Ajkm.a();
      this.jdField_a_of_type_Ajkm = null;
    }
    if (this.jdField_a_of_type_Ajep != null)
    {
      this.jdField_a_of_type_Ajep.a();
      this.jdField_a_of_type_Ajep = null;
    }
    if (this.jdField_a_of_type_Ajev != null)
    {
      this.jdField_a_of_type_Ajev.f();
      this.jdField_a_of_type_Ajev = null;
    }
    this.jdField_a_of_type_Ajff.a();
    this.jdField_a_of_type_Ajfd.b();
    this.jdField_a_of_type_Ajew.b();
    this.jdField_a_of_type_Ajez.c();
    this.jdField_a_of_type_Boolean = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = a();
    if (localObject == null) {}
    while (this.jdField_a_of_type_Ajez.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Ajez.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfe
 * JD-Core Version:    0.7.0.1
 */