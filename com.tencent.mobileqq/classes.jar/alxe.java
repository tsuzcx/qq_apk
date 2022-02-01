import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class alxe
  implements alxd
{
  private int jdField_a_of_type_Int;
  private alyf jdField_a_of_type_Alyf;
  public WeakReference<Context> a;
  
  public alxe(Activity paramActivity, alyf paramalyf, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Alyf = paramalyf;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 200;
  }
  
  public alrq a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    alyf localalyf = this.jdField_a_of_type_Alyf;
    if ((!(localAppRuntime instanceof QQAppInterface)) || (localalyf == null)) {}
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
        localalyf.e(paramString2);
        return null;
      }
      if ("cs.create_room.local".equals(paramString1))
      {
        localalyf.f(paramString2);
        return null;
      }
      if ("cs.join_room.local".equals(paramString1))
      {
        localalyf.g(paramString2);
        return null;
      }
      if ("cs.game_start.local".equals(paramString1))
      {
        localalyf.h(paramString2);
        return null;
      }
      if ("cs.make_room_min.local".equals(paramString1))
      {
        localalyf.b();
        return null;
      }
      if ("cs.close_room.local".equals(paramString1))
      {
        localalyf.c();
        return null;
      }
      if ("cs.game_tips.local".equals(paramString1))
      {
        localalyf.i(ApolloUtil.a(paramString2, "tips"));
        return null;
      }
      if ("cs.check_pubAccount_state.local".equals(paramString1))
      {
        localalyf.a(paramString2, paramInt1);
        return null;
      }
    } while (!"cs.on_get_open_key.local".equals(paramString1));
    localalyf.b(paramString2, paramInt1);
    return null;
  }
  
  public alyf a()
  {
    return this.jdField_a_of_type_Alyf;
  }
  
  public void a()
  {
    QLog.i("CmGameHandler", 1, "[destroyHandler]");
    this.jdField_a_of_type_Alyf = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxe
 * JD-Core Version:    0.7.0.1
 */