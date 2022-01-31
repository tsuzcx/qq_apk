import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class aiwm
  implements aisp
{
  public static boolean a;
  private int jdField_a_of_type_Int = 1;
  aisd jdField_a_of_type_Aisd;
  private boolean b;
  private boolean c;
  
  public aiwm(aisd paramaisd)
  {
    this.jdField_a_of_type_Aisd = paramaisd;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      if (localSharedPreferences.getInt(paramQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_" + ApolloUtil.a(), 0) >= localSharedPreferences.getInt("sp_key_aio_bubble_max_count", 3)) {
        bool = true;
      }
      jdField_a_of_type_Boolean = bool;
    }
  }
  
  private void b()
  {
    if (!this.b) {}
    Object localObject;
    aifc localaifc;
    aifg localaifg;
    do
    {
      do
      {
        return;
        this.b = false;
        localObject = this.jdField_a_of_type_Aisd.a();
      } while (localObject == null);
      localaifc = (aifc)((QQAppInterface)localObject).getManager(211);
      localaifg = (aifg)((QQAppInterface)localObject).getManager(153);
      localObject = null;
      if (localaifc.jdField_a_of_type_Aiwk != null) {
        localObject = localaifc.jdField_a_of_type_Aiwk.a();
      }
    } while ((localObject == null) || ((((DrawerPushItem)localObject).msg_type != 7) && (((DrawerPushItem)localObject).msg_type != 9) && (((DrawerPushItem)localObject).msg_type != 2) && (((DrawerPushItem)localObject).msg_type != 10)));
    QLog.i("ApolloBubbleLogic", 1, "checkIfPanelBubble remove panel bubble");
    localaifg.a((DrawerPushItem)localObject);
    localaifc.jdField_a_of_type_Aiwk.a();
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp", 0);
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_";
    String str1 = (String)localObject1 + ApolloUtil.a();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    if (((SharedPreferences)localObject2).contains(str1)) {
      localEditor.putInt(str1, ((SharedPreferences)localObject2).getInt(str1, 0) + 1);
    }
    for (;;)
    {
      localEditor.commit();
      a(paramQQAppInterface);
      return;
      Object localObject3 = ((SharedPreferences)localObject2).getAll();
      localObject2 = new ArrayList();
      if (localObject3 != null)
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          String str2 = (String)localEntry.getKey();
          if ((str2 != null) && (str2.startsWith((String)localObject1))) {
            ((List)localObject2).add(localEntry.getKey());
          }
        }
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localEditor.remove((String)((Iterator)localObject1).next());
        }
      }
      localEditor.putInt(str1, 1);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aisd != null)
    {
      aifc localaifc = (aifc)this.jdField_a_of_type_Aisd.a().getManager(211);
      localaifc.jdField_a_of_type_Int = -1;
      localaifc.a(-1, -1);
    }
    this.jdField_a_of_type_Aisd = null;
    this.c = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    label304:
    for (;;)
    {
      return;
      b();
      return;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_Aisd.a();
      if ((localQQAppInterface != null) && (this.jdField_a_of_type_Aisd.a() != null) && (aisl.a(localQQAppInterface) != null))
      {
        SharedPreferences localSharedPreferences = localQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
        int i = localSharedPreferences.getInt(localQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_" + ApolloUtil.a(), 0);
        int j = localSharedPreferences.getInt("sp_key_aio_bubble_max_count", 3);
        if (i >= j)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "AIO Bubble show count limited:", Integer.valueOf(j) });
          }
        }
        else if (this.c)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, "current AIO has play bubble, wait for next time");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, "start play bubble");
          }
          if (a(localQQAppInterface)) {
            paramInt = 2;
          }
          for (;;)
          {
            if (paramInt <= 0) {
              break label304;
            }
            this.b = true;
            this.c = true;
            b(localQQAppInterface);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "AIO bubble play type:", Integer.valueOf(paramInt), ",current count:", Integer.valueOf(i), ",maxCount:", Integer.valueOf(j) });
            return;
            if (b(localQQAppInterface)) {
              paramInt = 3;
            } else {
              paramInt = 0;
            }
          }
        }
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    aifc localaifc = (aifc)paramQQAppInterface.getManager(211);
    if (localaifc.jdField_a_of_type_Aiwk != null) {}
    for (DrawerPushItem localDrawerPushItem = localaifc.jdField_a_of_type_Aiwk.a();; localDrawerPushItem = null)
    {
      if ((localDrawerPushItem != null) && (localDrawerPushItem.msg_type != 7) && (localaifc.jdField_a_of_type_Aiwk.a(paramQQAppInterface, this.jdField_a_of_type_Aisd.jdField_a_of_type_Int)))
      {
        if (localDrawerPushItem.reddotGameId > 0)
        {
          localaifc.jdField_a_of_type_Int = localDrawerPushItem.reddotGameId;
          localaifc.a(localDrawerPushItem.reddotGameId, 3);
          bajr.a(paramQQAppInterface, "cmshow", "Apollo", "aio_msg_display", ApolloUtil.b(this.jdField_a_of_type_Aisd.jdField_a_of_type_Int), 3, new String[] { String.valueOf(localDrawerPushItem.reddotGameId), String.valueOf(localDrawerPushItem.reddotRedId) });
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "show aio bubble for reddot game, game id=", Integer.valueOf(localDrawerPushItem.reddotGameId) });
          }
        }
        return true;
      }
      return false;
    }
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    aifc localaifc = (aifc)paramQQAppInterface.getManager(211);
    if (localaifc.jdField_a_of_type_Aiwk != null) {}
    for (Object localObject = localaifc.jdField_a_of_type_Aiwk.a();; localObject = null)
    {
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((DrawerPushItem)localObject).msg_type == 7)
        {
          localObject = (aifg)paramQQAppInterface.getManager(153);
          bool1 = bool2;
          if (localaifc.jdField_a_of_type_Aiwk.a(paramQQAppInterface, this.jdField_a_of_type_Aisd.jdField_a_of_type_Int))
          {
            if (localObject != null) {
              ((aifg)localObject).o = true;
            }
            bajr.a(null, "cmshow", "Apollo", "peoplebubble", ApolloUtil.b(this.jdField_a_of_type_Aisd.jdField_a_of_type_Int), 0, new String[] { String.valueOf(1) });
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiwm
 * JD-Core Version:    0.7.0.1
 */