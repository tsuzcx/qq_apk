import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class akxm
  implements akxl
{
  private int jdField_a_of_type_Int;
  private akyn jdField_a_of_type_Akyn;
  public WeakReference<Context> a;
  
  public akxm(Activity paramActivity, akyn paramakyn, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Akyn = paramakyn;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 200;
  }
  
  public akrw a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    akyn localakyn = this.jdField_a_of_type_Akyn;
    if ((!(localAppRuntime instanceof QQAppInterface)) || (localakyn == null)) {}
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
        localakyn.e(paramString2);
        return null;
      }
      if ("cs.create_room.local".equals(paramString1))
      {
        localakyn.f(paramString2);
        return null;
      }
      if ("cs.join_room.local".equals(paramString1))
      {
        localakyn.g(paramString2);
        return null;
      }
      if ("cs.game_start.local".equals(paramString1))
      {
        localakyn.h(paramString2);
        return null;
      }
      if ("cs.make_room_min.local".equals(paramString1))
      {
        localakyn.b();
        return null;
      }
      if ("cs.close_room.local".equals(paramString1))
      {
        localakyn.c();
        return null;
      }
      if ("cs.game_tips.local".equals(paramString1))
      {
        localakyn.i(ApolloUtil.a(paramString2, "tips"));
        return null;
      }
      if ("cs.check_pubAccount_state.local".equals(paramString1))
      {
        localakyn.a(paramString2, paramInt1);
        return null;
      }
    } while (!"cs.on_get_open_key.local".equals(paramString1));
    localakyn.b(paramString2, paramInt1);
    return null;
  }
  
  public akyn a()
  {
    return this.jdField_a_of_type_Akyn;
  }
  
  public void a()
  {
    QLog.i("CmGameHandler", 1, "[destroyHandler]");
    this.jdField_a_of_type_Akyn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxm
 * JD-Core Version:    0.7.0.1
 */