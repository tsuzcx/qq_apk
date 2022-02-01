import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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

public class amaz
  implements Manager
{
  private amak jdField_a_of_type_Amak;
  private amaq jdField_a_of_type_Amaq;
  private amar jdField_a_of_type_Amar;
  private amau jdField_a_of_type_Amau;
  private amav jdField_a_of_type_Amav;
  private amay jdField_a_of_type_Amay;
  private amba jdField_a_of_type_Amba;
  private amgi jdField_a_of_type_Amgi;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<ambl>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public amaz(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_Amau = new amau(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_Amau);
    this.jdField_a_of_type_Amba = new amba(this.jdField_a_of_type_Amau, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_Amay = new amay(this.jdField_a_of_type_Amau, this.jdField_a_of_type_Amba);
    this.jdField_a_of_type_Amav = new amav(this.jdField_a_of_type_Amau);
    this.jdField_a_of_type_Amar = new amar(this.jdField_a_of_type_Amau, this.jdField_a_of_type_Amba, this.jdField_a_of_type_Amav);
    this.jdField_a_of_type_Amau.a(this.jdField_a_of_type_Amav);
  }
  
  public amak a()
  {
    return this.jdField_a_of_type_Amak;
  }
  
  public amaq a()
  {
    return this.jdField_a_of_type_Amaq;
  }
  
  public amar a()
  {
    return this.jdField_a_of_type_Amar;
  }
  
  public amau a()
  {
    return this.jdField_a_of_type_Amau;
  }
  
  public amav a()
  {
    return this.jdField_a_of_type_Amav;
  }
  
  public amay a()
  {
    return this.jdField_a_of_type_Amay;
  }
  
  public amba a()
  {
    return this.jdField_a_of_type_Amba;
  }
  
  public amgi a()
  {
    return this.jdField_a_of_type_Amgi;
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
    if (this.jdField_a_of_type_Amar != null) {
      this.jdField_a_of_type_Amar.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!ambc.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = ambc.a(a());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.jdField_a_of_type_Amaq == null);
    this.jdField_a_of_type_Amaq.c();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = ambc.a(a());
    if (localObject != null) {
      ((amal)localObject).a(paramInt, paramArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ambl localambl = (ambl)((WeakReference)((Iterator)localObject).next()).get();
      if (localambl != null) {
        localambl.a(paramInt, paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      amhk.a(ambc.b(this.jdField_a_of_type_Amau.e), 1, paramInt, 0L, paramVarArgs);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ambl localambl = (ambl)((WeakReference)localIterator.next()).get();
      if (localambl != null) {
        localambl.a(paramInt, paramVarArgs);
      }
    }
  }
  
  public void a(alqu paramalqu)
  {
    if (paramalqu == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Amau.a(paramalqu);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Amau.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramalqu);
  }
  
  public void a(ambl paramambl)
  {
    if (paramambl != null)
    {
      paramambl = new WeakReference(paramambl);
      this.jdField_a_of_type_JavaUtilList.add(paramambl);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.jdField_a_of_type_Amau.a(paramSessionInfo.curType, 0);
      this.jdField_a_of_type_Amau.jdField_a_of_type_JavaLangString = paramSessionInfo.curFriendUin;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Amau.a(paramBaseChatPie);
    paramBaseChatPie = a();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (alpg)paramBaseChatPie.getManager(232);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_Amgi == null) {
      this.jdField_a_of_type_Amgi = new amgi(this.jdField_a_of_type_Amau);
    }
    if (this.jdField_a_of_type_Amak == null) {
      this.jdField_a_of_type_Amak = new amak(this.jdField_a_of_type_Amau);
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_Amaq = new amaq(this.jdField_a_of_type_Amau, paramApolloTextureView);
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.d(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_Amau == null) || (this.jdField_a_of_type_Amar == null) || (this.jdField_a_of_type_Amay == null)) {
      return;
    }
    this.jdField_a_of_type_Amau.c(true);
    int i = ambc.b(this.jdField_a_of_type_Amau.e);
    this.jdField_a_of_type_Amau.b(i);
    if (!this.jdField_a_of_type_Amau.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_Amau.a(paramInt, 0);
    this.jdField_a_of_type_Amau.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Amau.b();
    this.jdField_a_of_type_Amau.a();
    if (!ambc.b(a(), paramInt, paramString))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    amhk.a(i, 200);
    this.jdField_a_of_type_Amar.a(this.jdField_a_of_type_Amgi);
    this.jdField_a_of_type_Amay.a();
    amhk.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Amau.b(true);
    String str1;
    if (!this.jdField_a_of_type_Amba.b(null))
    {
      amhk.a(i, 300);
      this.jdField_a_of_type_Amar.a(this.jdField_a_of_type_Amau);
      amhk.a(i, 300, 0, new Object[] { "initSprite done" });
      amhk.a(i, 1, 0, new Object[] { "terminal all done" });
      amhk.a(i, null, new int[] { amhj.a(i, false, this.jdField_a_of_type_Amau.b, paramInt, true) });
      this.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (paramInt != 0)) {
        break label487;
      }
      i = amge.a(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentUin(), (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      str1 = String.valueOf(amge.a(paramString, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
    }
    for (String str2 = String.valueOf(i);; str2 = "")
    {
      QQAppInterface localQQAppInterface = a();
      if (this.jdField_a_of_type_Amau.d == 1) {}
      for (i = 1;; i = 0)
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ApolloUtil.h(this.jdField_a_of_type_Amau.b), new String[] { Integer.toString(ApolloUtil.b(paramInt)), str2, str1, paramString });
        return;
        amhk.a(i, null, new int[] { amhj.a(i, true, this.jdField_a_of_type_Amau.b, paramInt, true) });
        break;
      }
      label487:
      str1 = "";
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!ambc.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = ambc.a(a());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.jdField_a_of_type_Amaq == null);
    this.jdField_a_of_type_Amaq.d();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Amav != null) {
      this.jdField_a_of_type_Amav.a();
    }
    Object localObject = this.jdField_a_of_type_Amau.a();
    if (localObject != null)
    {
      localObject = ((alqu)localObject).getRenderImpl();
      if (localObject != null) {
        ((alpf)localObject).c();
      }
    }
    if (this.jdField_a_of_type_Amgi != null)
    {
      this.jdField_a_of_type_Amgi.a();
      this.jdField_a_of_type_Amgi = null;
    }
    if (this.jdField_a_of_type_Amak != null)
    {
      this.jdField_a_of_type_Amak.a();
      this.jdField_a_of_type_Amak = null;
    }
    if (this.jdField_a_of_type_Amaq != null)
    {
      this.jdField_a_of_type_Amaq.f();
      this.jdField_a_of_type_Amaq = null;
    }
    this.jdField_a_of_type_Amba.a();
    this.jdField_a_of_type_Amay.b();
    this.jdField_a_of_type_Amar.b();
    this.jdField_a_of_type_Amau.c();
    this.jdField_a_of_type_Boolean = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = a();
    if (localObject == null) {}
    while (this.jdField_a_of_type_Amau.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Amau.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amaz
 * JD-Core Version:    0.7.0.1
 */