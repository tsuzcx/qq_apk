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

public class ajck
{
  public static String a;
  public int a;
  private ajbl jdField_a_of_type_Ajbl;
  private ajbz jdField_a_of_type_Ajbz;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "cmgame_process.CmGameLifeCycle";
  }
  
  public ajck(int paramInt)
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
    AppInterface localAppInterface = ajac.a();
    if ((localAppInterface instanceof QQAppInterface)) {
      return (QQAppInterface)localAppInterface;
    }
    return null;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public ajcm a()
  {
    if (this.jdField_a_of_type_Ajbl == null) {
      return null;
    }
    return this.jdField_a_of_type_Ajbl.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajbl != null) {
      this.jdField_a_of_type_Ajbl.a();
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
                if ((2 == paramInt2) && (this.jdField_a_of_type_Ajbl != null))
                {
                  localObject2 = this.jdField_a_of_type_Ajbl.a();
                  if (localObject2 != null) {
                    ((ajcm)localObject2).d();
                  }
                }
                if (4 != paramInt2) {
                  break;
                }
              } while (this.jdField_a_of_type_Ajbl == null);
              localObject1 = this.jdField_a_of_type_Ajbl.a();
            } while (localObject1 == null);
            ((ajcm)localObject1).e();
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
            if (this.jdField_a_of_type_Ajbl != null) {
              CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Ajbl);
            }
            if (this.jdField_a_of_type_Ajbz != null) {
              CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Ajbz);
            }
            this.jdField_a_of_type_Ajbz = new ajbz((Activity)localObject2, (QQAppInterface)localObject1, this.b);
            CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_Ajbz);
            if ((!ajac.a(this.b)) && (!ajac.b(this.b)))
            {
              ajcm localajcm = new ajcm((Activity)localObject2, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
              this.jdField_a_of_type_Ajbl = new ajbl((Activity)localObject2, localajcm, this.b);
              CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_Ajbl);
              localajcm.a((Activity)localObject2);
              localajcm.f();
              localajcm.g();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null);
          QLog.e(jdField_a_of_type_JavaLangString, 1, "land or game box game data not exit");
          ApolloGameUtil.a((QQAppInterface)localObject1, 0L);
          return;
        } while (5 != paramInt2);
        if (this.jdField_a_of_type_Ajbl != null)
        {
          localObject2 = this.jdField_a_of_type_Ajbl.a();
          if (localObject2 != null) {
            ((ajcm)localObject2).j();
          }
          this.jdField_a_of_type_Ajbl.a();
          CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Ajbl);
          this.jdField_a_of_type_Ajbl = null;
        }
        if (this.jdField_a_of_type_Ajbz != null)
        {
          this.jdField_a_of_type_Ajbz.a();
          CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Ajbz);
          this.jdField_a_of_type_Ajbz = null;
        }
      } while ((ajac.a(this.b)) || (ajac.b(this.b)) || (a() == null));
      localObject1 = (airx)a().getManager(153);
    } while ((localObject1 == null) || (!((airx)localObject1).j()) || (ajac.a(null)) || (((airx)localObject1).k) || (((airx)localObject1).h()) || (((airx)localObject1).i()) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
    ((airx)localObject1).h = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src != 319) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src != 318)) {
      ajac.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
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
    if (this.jdField_a_of_type_Ajbl != null)
    {
      ajcm localajcm = this.jdField_a_of_type_Ajbl.a();
      if ((localajcm != null) && (localajcm.a)) {
        ThreadManagerV2.getUIHandlerV2().post(new CmGameLifeCycle.1(this, localajcm));
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ajbl != null)
    {
      ajcm localajcm = this.jdField_a_of_type_Ajbl.a();
      if ((localajcm != null) && (localajcm.a)) {
        localajcm.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajck
 * JD-Core Version:    0.7.0.1
 */