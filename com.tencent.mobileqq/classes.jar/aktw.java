import android.app.Activity;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle.1;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aktw
{
  public static String a;
  public int a;
  private aksx jdField_a_of_type_Aksx;
  private aktl jdField_a_of_type_Aktl;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "cmgame_process.CmGameLifeCycle";
  }
  
  public aktw(int paramInt)
  {
    this.b = paramInt;
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  private QQAppInterface a()
  {
    AppInterface localAppInterface = akro.a();
    if ((localAppInterface instanceof QQAppInterface)) {
      return (QQAppInterface)localAppInterface;
    }
    return null;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public akty a()
  {
    if (this.jdField_a_of_type_Aksx == null) {
      return null;
    }
    return this.jdField_a_of_type_Aksx.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aksx != null) {
      this.jdField_a_of_type_Aksx.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[handleActLifeCycle], gameId:" + paramInt1 + ",status:" + paramInt2);
    Object localObject1 = a();
    if (localObject1 == null) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "app is null.");
    }
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((2 == paramInt2) && (this.jdField_a_of_type_Aksx != null))
                {
                  localObject2 = this.jdField_a_of_type_Aksx.a();
                  if (localObject2 != null) {
                    ((akty)localObject2).d();
                  }
                }
                if (4 != paramInt2) {
                  break;
                }
              } while (this.jdField_a_of_type_Aksx == null);
              localObject1 = this.jdField_a_of_type_Aksx.a();
            } while (localObject1 == null);
            ((akty)localObject1).e();
            return;
            if (1 != paramInt2) {
              break;
            }
            localObject2 = a();
            if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (localObject2 == null))
            {
              QLog.w(jdField_a_of_type_JavaLangString, 1, "null error.");
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId != paramInt1)
            {
              QLog.w(jdField_a_of_type_JavaLangString, 1, "not the same game.");
              return;
            }
            if (this.jdField_a_of_type_Aksx != null) {
              CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Aksx);
            }
            if (this.jdField_a_of_type_Aktl != null) {
              CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Aktl);
            }
            this.jdField_a_of_type_Aktl = new aktl((Activity)localObject2, (QQAppInterface)localObject1, this.b);
            CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_Aktl);
            if ((!akro.a(this.b)) && (!akro.b(this.b)))
            {
              akty localakty = new akty((Activity)localObject2, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
              this.jdField_a_of_type_Aksx = new aksx((Activity)localObject2, localakty, this.b);
              CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_Aksx);
              localakty.a((Activity)localObject2);
              localakty.f();
              localakty.g();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null);
          QLog.e(jdField_a_of_type_JavaLangString, 1, "land or game box game data not exit");
          ApolloGameUtil.a((QQAppInterface)localObject1, 0L);
          return;
        } while (5 != paramInt2);
        if (this.jdField_a_of_type_Aksx != null)
        {
          localObject2 = this.jdField_a_of_type_Aksx.a();
          if (localObject2 != null) {
            ((akty)localObject2).j();
          }
          this.jdField_a_of_type_Aksx.a();
          CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Aksx);
          this.jdField_a_of_type_Aksx = null;
        }
        if (this.jdField_a_of_type_Aktl != null)
        {
          this.jdField_a_of_type_Aktl.a();
          CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Aktl);
          this.jdField_a_of_type_Aktl = null;
        }
      } while ((akro.a(this.b)) || (akro.b(this.b)) || (a() == null));
      localObject1 = (akji)a().getManager(153);
    } while ((localObject1 == null) || (!((akji)localObject1).j()) || (akro.a(null)) || (((akji)localObject1).k) || (((akji)localObject1).h()) || (((akji)localObject1).i()) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
    ((akji)localObject1).h = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src != 319) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src != 318)) {
      akro.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "plus status first play goBackToPlus");
  }
  
  public void a(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game = paramStartCheckParam.game;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aksx != null)
    {
      akty localakty = this.jdField_a_of_type_Aksx.a();
      if ((localakty != null) && (localakty.a)) {
        ThreadManagerV2.getUIHandlerV2().post(new CmGameLifeCycle.1(this, localakty));
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aksx != null)
    {
      akty localakty = this.jdField_a_of_type_Aksx.a();
      if ((localakty != null) && (localakty.a)) {
        localakty.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktw
 * JD-Core Version:    0.7.0.1
 */