import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

class airk
  implements airv
{
  airk(airj paramairj) {}
  
  public void a(List<MayKnowRecommend> paramList)
  {
    Object localObject2 = this.a.a(3);
    boolean bool3 = ((aire)localObject2).c;
    Object localObject1 = ((aire)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject3;
    boolean bool2;
    boolean bool1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      ((aire)localObject2).jdField_a_of_type_JavaLangString = airj.a(this.a).getApp().getResources().getString(2131698330);
      ((aire)localObject2).b = "";
      ((aire)localObject2).jdField_a_of_type_JavaLangObject = paramList;
      localObject3 = (amvo)airj.a(this.a).getManager(159);
      if (localObject3 == null) {
        break label262;
      }
      bool2 = ((amvo)localObject3).b("sp_mayknow_entry_list_recommend");
      bool1 = ((amvo)localObject3).b("sp_mayknow_entry_list_head");
    }
    for (;;)
    {
      label128:
      Object localObject4;
      if ((bool1) && (!bool2))
      {
        ((aire)localObject2).c = true;
        airj.a(this.a);
        if (QLog.isColorLevel())
        {
          localObject3 = Locale.getDefault();
          bool1 = ((aire)localObject2).c;
          localObject4 = ((aire)localObject2).jdField_a_of_type_JavaLangObject;
          localObject2 = ((aire)localObject2).b;
          if (paramList == null) {
            break label257;
          }
        }
      }
      label257:
      for (int i = paramList.size();; i = 0)
      {
        QLog.i("CTEntryMng", 2, String.format((Locale)localObject3, "updateMayKnow pre: [%s,%s], cur: [%s,%s], subtitle: %s recommends:%s", new Object[] { Boolean.valueOf(bool3), localObject1, Boolean.valueOf(bool1), localObject4, localObject2, Integer.valueOf(i) }));
        return;
        ((aire)localObject2).jdField_a_of_type_JavaLangObject = null;
        ((aire)localObject2).b = null;
        break;
        ((aire)localObject2).c = false;
        break label128;
      }
      label262:
      bool1 = true;
      bool2 = false;
    }
  }
  
  public boolean a()
  {
    aire localaire = this.a.a(3);
    airq localairq = this.a.a(3);
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "isMayKnowEntryShown, canBeShown = " + localaire.c + ", flagValue = " + localairq.b);
    }
    return (localaire.c) && (localairq.b == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airk
 * JD-Core Version:    0.7.0.1
 */