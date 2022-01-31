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

public class ajfg
  implements Manager
{
  private ajer jdField_a_of_type_Ajer;
  private ajex jdField_a_of_type_Ajex;
  private ajey jdField_a_of_type_Ajey;
  private ajfb jdField_a_of_type_Ajfb;
  private ajfc jdField_a_of_type_Ajfc;
  private ajff jdField_a_of_type_Ajff;
  private ajfh jdField_a_of_type_Ajfh;
  private ajko jdField_a_of_type_Ajko;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<ajfs>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public ajfg(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_Ajfb = new ajfb(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_Ajfb);
    this.jdField_a_of_type_Ajfh = new ajfh(this.jdField_a_of_type_Ajfb, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_Ajff = new ajff(this.jdField_a_of_type_Ajfb, this.jdField_a_of_type_Ajfh);
    this.jdField_a_of_type_Ajfc = new ajfc(this.jdField_a_of_type_Ajfb);
    this.jdField_a_of_type_Ajey = new ajey(this.jdField_a_of_type_Ajfb, this.jdField_a_of_type_Ajfh, this.jdField_a_of_type_Ajfc);
    this.jdField_a_of_type_Ajfb.a(this.jdField_a_of_type_Ajfc);
  }
  
  public ajer a()
  {
    return this.jdField_a_of_type_Ajer;
  }
  
  public ajex a()
  {
    return this.jdField_a_of_type_Ajex;
  }
  
  public ajey a()
  {
    return this.jdField_a_of_type_Ajey;
  }
  
  public ajfb a()
  {
    return this.jdField_a_of_type_Ajfb;
  }
  
  public ajfc a()
  {
    return this.jdField_a_of_type_Ajfc;
  }
  
  public ajff a()
  {
    return this.jdField_a_of_type_Ajff;
  }
  
  public ajfh a()
  {
    return this.jdField_a_of_type_Ajfh;
  }
  
  public ajko a()
  {
    return this.jdField_a_of_type_Ajko;
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
    if (this.jdField_a_of_type_Ajey != null) {
      this.jdField_a_of_type_Ajey.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!ajfj.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = ajfj.a(a());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.jdField_a_of_type_Ajex == null);
    this.jdField_a_of_type_Ajex.c();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = ajfj.a(a());
    if (localObject != null) {
      ((ajes)localObject).a(paramInt, paramArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ajfs localajfs = (ajfs)((WeakReference)((Iterator)localObject).next()).get();
      if (localajfs != null) {
        localajfs.a(paramInt, paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      ajlq.a(ajfj.b(this.jdField_a_of_type_Ajfb.e), 1, paramInt, 0L, paramVarArgs);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ajfs localajfs = (ajfs)((WeakReference)localIterator.next()).get();
      if (localajfs != null) {
        localajfs.a(paramInt, paramVarArgs);
      }
    }
  }
  
  public void a(aivb paramaivb)
  {
    if (paramaivb == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Ajfb.a(paramaivb);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ajfb.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramaivb);
  }
  
  public void a(ajfs paramajfs)
  {
    if (paramajfs != null)
    {
      paramajfs = new WeakReference(paramajfs);
      this.jdField_a_of_type_JavaUtilList.add(paramajfs);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Ajfb.a(paramBaseChatPie);
    paramBaseChatPie = a();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (aitn)paramBaseChatPie.getManager(232);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_Ajko == null) {
      this.jdField_a_of_type_Ajko = new ajko(this.jdField_a_of_type_Ajfb);
    }
    if (this.jdField_a_of_type_Ajer == null) {
      this.jdField_a_of_type_Ajer = new ajer(this.jdField_a_of_type_Ajfb);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.jdField_a_of_type_Ajfb.a(paramSessionInfo.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Ajfb.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_Ajex = new ajex(this.jdField_a_of_type_Ajfb, paramApolloTextureView);
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.d(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_Ajfb == null) || (this.jdField_a_of_type_Ajey == null) || (this.jdField_a_of_type_Ajff == null)) {
      return;
    }
    this.jdField_a_of_type_Ajfb.c(true);
    int i = ajfj.b(this.jdField_a_of_type_Ajfb.e);
    this.jdField_a_of_type_Ajfb.b(i);
    if (!this.jdField_a_of_type_Ajfb.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_Ajfb.a(paramInt, 0);
    this.jdField_a_of_type_Ajfb.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ajfb.b();
    this.jdField_a_of_type_Ajfb.a();
    if (!ajfj.b(a(), paramInt, paramString))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    ajlq.a(i, 200);
    this.jdField_a_of_type_Ajey.a(this.jdField_a_of_type_Ajko);
    this.jdField_a_of_type_Ajff.a();
    ajlq.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Ajfb.b(true);
    QQAppInterface localQQAppInterface;
    if (!this.jdField_a_of_type_Ajfh.b(null))
    {
      ajlq.a(i, 300);
      this.jdField_a_of_type_Ajey.a(this.jdField_a_of_type_Ajfb);
      ajlq.a(i, 300, 0, new Object[] { "initSprite done" });
      ajlq.a(i, 1, 0, new Object[] { "terminal all done" });
      ajlq.a(i, null, new int[] { ajlp.a(i, false, this.jdField_a_of_type_Ajfb.b, paramInt, true) });
      this.jdField_a_of_type_Boolean = true;
      localQQAppInterface = a();
      if (this.jdField_a_of_type_Ajfb.d != 1) {
        break label421;
      }
    }
    label421:
    for (i = 1;; i = 0)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ApolloUtil.h(this.jdField_a_of_type_Ajfb.b), new String[] { Integer.toString(ApolloUtil.b(paramInt)), "", "", paramString });
      return;
      ajlq.a(i, null, new int[] { ajlp.a(i, true, this.jdField_a_of_type_Ajfb.b, paramInt, true) });
      break;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!ajfj.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = ajfj.a(a());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.jdField_a_of_type_Ajex == null);
    this.jdField_a_of_type_Ajex.d();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Ajfc != null) {
      this.jdField_a_of_type_Ajfc.a();
    }
    Object localObject = this.jdField_a_of_type_Ajfb.a();
    if (localObject != null)
    {
      localObject = ((aivb)localObject).getRenderImpl();
      if (localObject != null) {
        ((aitm)localObject).c();
      }
    }
    if (this.jdField_a_of_type_Ajko != null)
    {
      this.jdField_a_of_type_Ajko.a();
      this.jdField_a_of_type_Ajko = null;
    }
    if (this.jdField_a_of_type_Ajer != null)
    {
      this.jdField_a_of_type_Ajer.a();
      this.jdField_a_of_type_Ajer = null;
    }
    if (this.jdField_a_of_type_Ajex != null)
    {
      this.jdField_a_of_type_Ajex.f();
      this.jdField_a_of_type_Ajex = null;
    }
    this.jdField_a_of_type_Ajfh.a();
    this.jdField_a_of_type_Ajff.b();
    this.jdField_a_of_type_Ajey.b();
    this.jdField_a_of_type_Ajfb.c();
    this.jdField_a_of_type_Boolean = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = a();
    if (localObject == null) {}
    while (this.jdField_a_of_type_Ajfb.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Ajfb.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfg
 * JD-Core Version:    0.7.0.1
 */