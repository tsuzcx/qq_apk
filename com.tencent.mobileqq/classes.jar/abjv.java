import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import java.lang.ref.WeakReference;

public class abjv
  implements ajnz, ajoa
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<JumpActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public abjv(JumpActivity paramJumpActivity, int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramJumpActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    JumpActivity localJumpActivity = (JumpActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localJumpActivity == null) || (localJumpActivity.app == null)) {
      return;
    }
    if (paramBoolean)
    {
      airx localairx = (airx)localJumpActivity.app.getManager(153);
      CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_Int, true, "launch", 0L, 10, 0, 0, 0, "", 222, null);
      localStartCheckParam.extendJson = this.jdField_a_of_type_JavaLangString;
      localStartCheckParam.version = localairx.a(this.jdField_a_of_type_Int);
      ApolloGameUtil.a(localJumpActivity, localStartCheckParam);
      JumpActivity.a(localJumpActivity, true);
      localJumpActivity.a();
      return;
    }
    bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131705920), 0).a();
    localJumpActivity.finish();
  }
  
  public void b(boolean paramBoolean)
  {
    JumpActivity localJumpActivity = (JumpActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localJumpActivity == null) || (localJumpActivity.app == null)) {}
    WebProcessManager localWebProcessManager;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      ApolloGameUtil.a(localJumpActivity.app, true);
      localWebProcessManager = (WebProcessManager)localJumpActivity.app.getManager(13);
    } while (localWebProcessManager == null);
    localWebProcessManager.a(100, new abjw(this, localJumpActivity));
    return;
    bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131705919), 0).a();
    ApolloGameUtil.a(localJumpActivity.app, false);
    localJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abjv
 * JD-Core Version:    0.7.0.1
 */