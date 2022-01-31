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

public class albf
  implements Manager
{
  private alaq jdField_a_of_type_Alaq;
  private alaw jdField_a_of_type_Alaw;
  private alax jdField_a_of_type_Alax;
  private alba jdField_a_of_type_Alba;
  private albb jdField_a_of_type_Albb;
  private albe jdField_a_of_type_Albe;
  private albg jdField_a_of_type_Albg;
  private algn jdField_a_of_type_Algn;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<albr>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public albf(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_Alba = new alba(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_Alba);
    this.jdField_a_of_type_Albg = new albg(this.jdField_a_of_type_Alba, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_Albe = new albe(this.jdField_a_of_type_Alba, this.jdField_a_of_type_Albg);
    this.jdField_a_of_type_Albb = new albb(this.jdField_a_of_type_Alba);
    this.jdField_a_of_type_Alax = new alax(this.jdField_a_of_type_Alba, this.jdField_a_of_type_Albg, this.jdField_a_of_type_Albb);
    this.jdField_a_of_type_Alba.a(this.jdField_a_of_type_Albb);
  }
  
  public alaq a()
  {
    return this.jdField_a_of_type_Alaq;
  }
  
  public alaw a()
  {
    return this.jdField_a_of_type_Alaw;
  }
  
  public alax a()
  {
    return this.jdField_a_of_type_Alax;
  }
  
  public alba a()
  {
    return this.jdField_a_of_type_Alba;
  }
  
  public albb a()
  {
    return this.jdField_a_of_type_Albb;
  }
  
  public albe a()
  {
    return this.jdField_a_of_type_Albe;
  }
  
  public albg a()
  {
    return this.jdField_a_of_type_Albg;
  }
  
  public algn a()
  {
    return this.jdField_a_of_type_Algn;
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
    if (this.jdField_a_of_type_Alax != null) {
      this.jdField_a_of_type_Alax.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!albi.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = albi.a(a());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.jdField_a_of_type_Alaw == null);
    this.jdField_a_of_type_Alaw.c();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = albi.a(a());
    if (localObject != null) {
      ((alar)localObject).a(paramInt, paramArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      albr localalbr = (albr)((WeakReference)((Iterator)localObject).next()).get();
      if (localalbr != null) {
        localalbr.a(paramInt, paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      alhp.a(albi.b(this.jdField_a_of_type_Alba.e), 1, paramInt, 0L, paramVarArgs);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      albr localalbr = (albr)((WeakReference)localIterator.next()).get();
      if (localalbr != null) {
        localalbr.a(paramInt, paramVarArgs);
      }
    }
  }
  
  public void a(akra paramakra)
  {
    if (paramakra == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Alba.a(paramakra);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramakra);
  }
  
  public void a(albr paramalbr)
  {
    if (paramalbr != null)
    {
      paramalbr = new WeakReference(paramalbr);
      this.jdField_a_of_type_JavaUtilList.add(paramalbr);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Alba.a(paramBaseChatPie);
    paramBaseChatPie = a();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (akpm)paramBaseChatPie.getManager(232);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_Algn == null) {
      this.jdField_a_of_type_Algn = new algn(this.jdField_a_of_type_Alba);
    }
    if (this.jdField_a_of_type_Alaq == null) {
      this.jdField_a_of_type_Alaq = new alaq(this.jdField_a_of_type_Alba);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.jdField_a_of_type_Alba.a(paramSessionInfo.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Alba.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_Alaw = new alaw(this.jdField_a_of_type_Alba, paramApolloTextureView);
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.d(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_Alba == null) || (this.jdField_a_of_type_Alax == null) || (this.jdField_a_of_type_Albe == null)) {
      return;
    }
    this.jdField_a_of_type_Alba.c(true);
    int i = albi.b(this.jdField_a_of_type_Alba.e);
    this.jdField_a_of_type_Alba.b(i);
    if (!this.jdField_a_of_type_Alba.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_Alba.a(paramInt, 0);
    this.jdField_a_of_type_Alba.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Alba.b();
    this.jdField_a_of_type_Alba.a();
    if (!albi.b(a(), paramInt, paramString))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    alhp.a(i, 200);
    this.jdField_a_of_type_Alax.a(this.jdField_a_of_type_Algn);
    this.jdField_a_of_type_Albe.a();
    alhp.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Alba.b(true);
    QQAppInterface localQQAppInterface;
    if (!this.jdField_a_of_type_Albg.b(null))
    {
      alhp.a(i, 300);
      this.jdField_a_of_type_Alax.a(this.jdField_a_of_type_Alba);
      alhp.a(i, 300, 0, new Object[] { "initSprite done" });
      alhp.a(i, 1, 0, new Object[] { "terminal all done" });
      alhp.a(i, null, new int[] { alho.a(i, false, this.jdField_a_of_type_Alba.b, paramInt, true) });
      this.jdField_a_of_type_Boolean = true;
      localQQAppInterface = a();
      if (this.jdField_a_of_type_Alba.d != 1) {
        break label421;
      }
    }
    label421:
    for (i = 1;; i = 0)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ApolloUtil.h(this.jdField_a_of_type_Alba.b), new String[] { Integer.toString(ApolloUtil.b(paramInt)), "", "", paramString });
      return;
      alhp.a(i, null, new int[] { alho.a(i, true, this.jdField_a_of_type_Alba.b, paramInt, true) });
      break;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!albi.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = albi.a(a());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.jdField_a_of_type_Alaw == null);
    this.jdField_a_of_type_Alaw.d();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Albb != null) {
      this.jdField_a_of_type_Albb.a();
    }
    Object localObject = this.jdField_a_of_type_Alba.a();
    if (localObject != null)
    {
      localObject = ((akra)localObject).getRenderImpl();
      if (localObject != null) {
        ((akpl)localObject).c();
      }
    }
    if (this.jdField_a_of_type_Algn != null)
    {
      this.jdField_a_of_type_Algn.a();
      this.jdField_a_of_type_Algn = null;
    }
    if (this.jdField_a_of_type_Alaq != null)
    {
      this.jdField_a_of_type_Alaq.a();
      this.jdField_a_of_type_Alaq = null;
    }
    if (this.jdField_a_of_type_Alaw != null)
    {
      this.jdField_a_of_type_Alaw.f();
      this.jdField_a_of_type_Alaw = null;
    }
    this.jdField_a_of_type_Albg.a();
    this.jdField_a_of_type_Albe.b();
    this.jdField_a_of_type_Alax.b();
    this.jdField_a_of_type_Alba.c();
    this.jdField_a_of_type_Boolean = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = a();
    if (localObject == null) {}
    while (this.jdField_a_of_type_Alba.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Alba.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albf
 * JD-Core Version:    0.7.0.1
 */