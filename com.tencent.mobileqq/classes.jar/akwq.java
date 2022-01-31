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

public class akwq
  implements Manager
{
  private akwb jdField_a_of_type_Akwb;
  private akwh jdField_a_of_type_Akwh;
  private akwi jdField_a_of_type_Akwi;
  private akwl jdField_a_of_type_Akwl;
  private akwm jdField_a_of_type_Akwm;
  private akwp jdField_a_of_type_Akwp;
  private akwr jdField_a_of_type_Akwr;
  private alby jdField_a_of_type_Alby;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<akxc>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public akwq(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_Akwl = new akwl(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_Akwl);
    this.jdField_a_of_type_Akwr = new akwr(this.jdField_a_of_type_Akwl, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_Akwp = new akwp(this.jdField_a_of_type_Akwl, this.jdField_a_of_type_Akwr);
    this.jdField_a_of_type_Akwm = new akwm(this.jdField_a_of_type_Akwl);
    this.jdField_a_of_type_Akwi = new akwi(this.jdField_a_of_type_Akwl, this.jdField_a_of_type_Akwr, this.jdField_a_of_type_Akwm);
    this.jdField_a_of_type_Akwl.a(this.jdField_a_of_type_Akwm);
  }
  
  public akwb a()
  {
    return this.jdField_a_of_type_Akwb;
  }
  
  public akwh a()
  {
    return this.jdField_a_of_type_Akwh;
  }
  
  public akwi a()
  {
    return this.jdField_a_of_type_Akwi;
  }
  
  public akwl a()
  {
    return this.jdField_a_of_type_Akwl;
  }
  
  public akwm a()
  {
    return this.jdField_a_of_type_Akwm;
  }
  
  public akwp a()
  {
    return this.jdField_a_of_type_Akwp;
  }
  
  public akwr a()
  {
    return this.jdField_a_of_type_Akwr;
  }
  
  public alby a()
  {
    return this.jdField_a_of_type_Alby;
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
    if (this.jdField_a_of_type_Akwi != null) {
      this.jdField_a_of_type_Akwi.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!akwt.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = akwt.a(a());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.jdField_a_of_type_Akwh == null);
    this.jdField_a_of_type_Akwh.c();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = akwt.a(a());
    if (localObject != null) {
      ((akwc)localObject).a(paramInt, paramArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      akxc localakxc = (akxc)((WeakReference)((Iterator)localObject).next()).get();
      if (localakxc != null) {
        localakxc.a(paramInt, paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      alda.a(akwt.b(this.jdField_a_of_type_Akwl.e), 1, paramInt, 0L, paramVarArgs);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      akxc localakxc = (akxc)((WeakReference)localIterator.next()).get();
      if (localakxc != null) {
        localakxc.a(paramInt, paramVarArgs);
      }
    }
  }
  
  public void a(akml paramakml)
  {
    if (paramakml == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Akwl.a(paramakml);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Akwl.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramakml);
  }
  
  public void a(akxc paramakxc)
  {
    if (paramakxc != null)
    {
      paramakxc = new WeakReference(paramakxc);
      this.jdField_a_of_type_JavaUtilList.add(paramakxc);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Akwl.a(paramBaseChatPie);
    paramBaseChatPie = a();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (akkx)paramBaseChatPie.getManager(232);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_Alby == null) {
      this.jdField_a_of_type_Alby = new alby(this.jdField_a_of_type_Akwl);
    }
    if (this.jdField_a_of_type_Akwb == null) {
      this.jdField_a_of_type_Akwb = new akwb(this.jdField_a_of_type_Akwl);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.jdField_a_of_type_Akwl.a(paramSessionInfo.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Akwl.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_Akwh = new akwh(this.jdField_a_of_type_Akwl, paramApolloTextureView);
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.d(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_Akwl == null) || (this.jdField_a_of_type_Akwi == null) || (this.jdField_a_of_type_Akwp == null)) {
      return;
    }
    this.jdField_a_of_type_Akwl.c(true);
    int i = akwt.b(this.jdField_a_of_type_Akwl.e);
    this.jdField_a_of_type_Akwl.b(i);
    if (!this.jdField_a_of_type_Akwl.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_Akwl.a(paramInt, 0);
    this.jdField_a_of_type_Akwl.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Akwl.b();
    this.jdField_a_of_type_Akwl.a();
    if (!akwt.b(a(), paramInt, paramString))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    alda.a(i, 200);
    this.jdField_a_of_type_Akwi.a(this.jdField_a_of_type_Alby);
    this.jdField_a_of_type_Akwp.a();
    alda.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Akwl.b(true);
    QQAppInterface localQQAppInterface;
    if (!this.jdField_a_of_type_Akwr.b(null))
    {
      alda.a(i, 300);
      this.jdField_a_of_type_Akwi.a(this.jdField_a_of_type_Akwl);
      alda.a(i, 300, 0, new Object[] { "initSprite done" });
      alda.a(i, 1, 0, new Object[] { "terminal all done" });
      alda.a(i, null, new int[] { alcz.a(i, false, this.jdField_a_of_type_Akwl.b, paramInt, true) });
      this.jdField_a_of_type_Boolean = true;
      localQQAppInterface = a();
      if (this.jdField_a_of_type_Akwl.d != 1) {
        break label421;
      }
    }
    label421:
    for (i = 1;; i = 0)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ApolloUtil.h(this.jdField_a_of_type_Akwl.b), new String[] { Integer.toString(ApolloUtil.b(paramInt)), "", "", paramString });
      return;
      alda.a(i, null, new int[] { alcz.a(i, true, this.jdField_a_of_type_Akwl.b, paramInt, true) });
      break;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!akwt.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = akwt.a(a());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.jdField_a_of_type_Akwh == null);
    this.jdField_a_of_type_Akwh.d();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Akwm != null) {
      this.jdField_a_of_type_Akwm.a();
    }
    Object localObject = this.jdField_a_of_type_Akwl.a();
    if (localObject != null)
    {
      localObject = ((akml)localObject).getRenderImpl();
      if (localObject != null) {
        ((akkw)localObject).c();
      }
    }
    if (this.jdField_a_of_type_Alby != null)
    {
      this.jdField_a_of_type_Alby.a();
      this.jdField_a_of_type_Alby = null;
    }
    if (this.jdField_a_of_type_Akwb != null)
    {
      this.jdField_a_of_type_Akwb.a();
      this.jdField_a_of_type_Akwb = null;
    }
    if (this.jdField_a_of_type_Akwh != null)
    {
      this.jdField_a_of_type_Akwh.f();
      this.jdField_a_of_type_Akwh = null;
    }
    this.jdField_a_of_type_Akwr.a();
    this.jdField_a_of_type_Akwp.b();
    this.jdField_a_of_type_Akwi.b();
    this.jdField_a_of_type_Akwl.c();
    this.jdField_a_of_type_Boolean = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = a();
    if (localObject == null) {}
    while (this.jdField_a_of_type_Akwl.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Akwl.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwq
 * JD-Core Version:    0.7.0.1
 */