import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class ajbn
  implements ajbm
{
  private int jdField_a_of_type_Int;
  private ajco jdField_a_of_type_Ajco;
  public WeakReference<Context> a;
  
  public ajbn(Activity paramActivity, ajco paramajco, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Ajco = paramajco;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 200;
  }
  
  public aivx a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    ajco localajco = this.jdField_a_of_type_Ajco;
    if ((!(localAppRuntime instanceof QQAppInterface)) || (localajco == null)) {}
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
        localajco.e(paramString2);
        return null;
      }
      if ("cs.create_room.local".equals(paramString1))
      {
        localajco.f(paramString2);
        return null;
      }
      if ("cs.join_room.local".equals(paramString1))
      {
        localajco.g(paramString2);
        return null;
      }
      if ("cs.game_start.local".equals(paramString1))
      {
        localajco.h(paramString2);
        return null;
      }
      if ("cs.make_room_min.local".equals(paramString1))
      {
        localajco.b();
        return null;
      }
      if ("cs.close_room.local".equals(paramString1))
      {
        localajco.c();
        return null;
      }
      if ("cs.game_tips.local".equals(paramString1))
      {
        localajco.i(ApolloUtil.a(paramString2, "tips"));
        return null;
      }
      if ("cs.check_pubAccount_state.local".equals(paramString1))
      {
        localajco.a(paramString2, paramInt1);
        return null;
      }
    } while (!"cs.on_get_open_key.local".equals(paramString1));
    localajco.b(paramString2, paramInt1);
    return null;
  }
  
  public ajco a()
  {
    return this.jdField_a_of_type_Ajco;
  }
  
  public void a()
  {
    QLog.i("CmGameHandler", 1, "[destroyHandler]");
    this.jdField_a_of_type_Ajco = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajbn
 * JD-Core Version:    0.7.0.1
 */