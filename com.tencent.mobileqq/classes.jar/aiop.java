import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class aiop
  implements aioo
{
  private int jdField_a_of_type_Int;
  private aipq jdField_a_of_type_Aipq;
  public WeakReference<Context> a;
  
  public aiop(Activity paramActivity, aipq paramaipq, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Aipq = paramaipq;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 200;
  }
  
  public aije a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    aipq localaipq = this.jdField_a_of_type_Aipq;
    if ((!(localAppRuntime instanceof QQAppInterface)) || (localaipq == null)) {}
    do
    {
      do
      {
        return null;
        if (this.jdField_a_of_type_Int == paramInt2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CmGameHandler", 2, new Object[] { "not the same gameId, self:", Integer.valueOf(this.jdField_a_of_type_Int), "cmd gameId:", Integer.valueOf(paramInt2), ",cmd:", paramString1 });
      return null;
      if ("cs.first_frame_drawn.local".equals(paramString1))
      {
        localaipq.e(paramString2);
        return null;
      }
      if ("cs.create_room.local".equals(paramString1))
      {
        localaipq.f(paramString2);
        return null;
      }
      if ("cs.join_room.local".equals(paramString1))
      {
        localaipq.g(paramString2);
        return null;
      }
      if ("cs.game_start.local".equals(paramString1))
      {
        localaipq.h(paramString2);
        return null;
      }
      if ("cs.make_room_min.local".equals(paramString1))
      {
        localaipq.b();
        return null;
      }
      if ("cs.close_room.local".equals(paramString1))
      {
        localaipq.c();
        return null;
      }
      if ("cs.game_tips.local".equals(paramString1))
      {
        localaipq.i(ApolloUtil.a(paramString2, "tips"));
        return null;
      }
      if ("cs.check_pubAccount_state.local".equals(paramString1))
      {
        localaipq.a(paramString2, paramInt1);
        return null;
      }
    } while (!"cs.on_get_open_key.local".equals(paramString1));
    localaipq.b(paramString2, paramInt1);
    return null;
  }
  
  public aipq a()
  {
    return this.jdField_a_of_type_Aipq;
  }
  
  public void a()
  {
    QLog.i("CmGameHandler", 1, "[destroyHandler]");
    this.jdField_a_of_type_Aipq = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiop
 * JD-Core Version:    0.7.0.1
 */