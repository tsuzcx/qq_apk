import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aift
  implements aifr
{
  private int jdField_a_of_type_Int;
  private DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  public boolean a;
  public boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  private aift(aifg paramaifg)
  {
    b();
    SharedPreferences localSharedPreferences = paramaifg.a.getApp().getSharedPreferences("apollo_sp" + paramaifg.a.c(), 0);
    if (localSharedPreferences.getInt("key_panel_meet_3d_action", 0) == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (localSharedPreferences.getInt("key_panel_shown_guide_for_action", 0) != 1) {
        break label134;
      }
      bool1 = true;
      label90:
      this.c = bool1;
      if (localSharedPreferences.getInt("key_panel_shown_guide_for_json", 0) != 1) {
        break label139;
      }
    }
    label134:
    label139:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.d = bool1;
      paramaifg.a(this);
      aiwm.a(paramaifg.a);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label90;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem = new DrawerPushItem();
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot = 0;
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_type = 10;
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id = "aio_panel_bubble_guide3d_action";
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.priority = 1000;
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.start_ts = ((int)NetConnInfoCenter.getServerTime() - 1000);
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.end_ts = (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.start_ts + 172800000);
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.send_time = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.start_ts;
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content = ajjy.a(2131634666);
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts = 1;
    this.jdField_a_of_type_Aifg.c(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
    a(true);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      int i;
      SharedPreferences localSharedPreferences;
      try
      {
        if (!aifs.jdField_a_of_type_Boolean)
        {
          QLog.d("ApolloManager", 1, new Object[] { "parseGuide3DBubble", " mIs3dAvailable:", Boolean.valueOf(this.b), " mApolloStatus: " + this.jdField_a_of_type_Int + ", show: " + aifs.jdField_a_of_type_Boolean });
          return;
        }
        try
        {
          i = (int)(paramJSONObject.optLong("startTime") / 1000L);
          localSharedPreferences = this.jdField_a_of_type_Aifg.a.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_Aifg.a.c(), 0);
          if (i != localSharedPreferences.getInt("key_panel_bubble_guide3d_start_time", 0)) {
            break label180;
          }
          QLog.d("ApolloManager", 1, "start time is same");
        }
        catch (Exception paramJSONObject)
        {
          QLog.e("ApolloManager", 1, "checkPackageBubbleInfo Exception:", paramJSONObject);
        }
        continue;
        localDrawerPushItem = new DrawerPushItem();
      }
      finally {}
      label180:
      DrawerPushItem localDrawerPushItem;
      localDrawerPushItem.is_reddot = 0;
      localDrawerPushItem.msg_id = "aio_panel_bubble_guide3d_push";
      localDrawerPushItem.msg_type = 10;
      localDrawerPushItem.priority = 900;
      localDrawerPushItem.start_ts = i;
      localDrawerPushItem.end_ts = ((int)NetConnInfoCenter.getServerTime() + (int)(paramJSONObject.optLong("interval") / 1000L));
      localDrawerPushItem.send_time = i;
      localDrawerPushItem.content = paramJSONObject.optString("bubbleText");
      localDrawerPushItem.show_counts = paramJSONObject.optInt("showCount");
      if (localDrawerPushItem.show_counts == 0) {
        localDrawerPushItem.show_counts = 1;
      }
      int j = paramJSONObject.optInt("packageId");
      this.jdField_a_of_type_Aifg.c(localDrawerPushItem);
      localSharedPreferences.edit().putInt("key_panel_bubble_guide3d_start_time", i).commit();
      b(true);
      if (this.e) {
        ((aifc)this.jdField_a_of_type_Aifg.a.getManager(211)).a.a(this.jdField_a_of_type_Aifg.a);
      }
      QLog.d("ApolloManager", 1, new Object[] { "parseGuide3DBubble", " push bubble:", localDrawerPushItem.toString(), " ,packageId", Integer.valueOf(j) });
    }
  }
  
  private void b()
  {
    this.b = aifg.a(this.jdField_a_of_type_Aifg.a);
    this.jdField_a_of_type_Int = aifg.a(this.jdField_a_of_type_Aifg.a);
  }
  
  /* Error */
  private void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 241	aift:e	Z
    //   7: iload_1
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: invokespecial 24	aift:b	()V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 91	aift:jdField_a_of_type_ComTencentMobileqqDrawerPushItem	Lcom/tencent/mobileqq/DrawerPushItem;
    //   22: ifnull -7 -> 15
    //   25: aload_0
    //   26: getfield 19	aift:jdField_a_of_type_Aifg	Laifg;
    //   29: aload_0
    //   30: getfield 91	aift:jdField_a_of_type_ComTencentMobileqqDrawerPushItem	Lcom/tencent/mobileqq/DrawerPushItem;
    //   33: invokevirtual 271	aifg:a	(Lcom/tencent/mobileqq/DrawerPushItem;)V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 91	aift:jdField_a_of_type_ComTencentMobileqqDrawerPushItem	Lcom/tencent/mobileqq/DrawerPushItem;
    //   41: goto -26 -> 15
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	aift
    //   0	49	1	paramBoolean	boolean
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   11	15	44	finally
    //   18	41	44	finally
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      b();
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      this.c = paramBoolean;
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_Aifg.a.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_Aifg.a.c(), 0).edit();
      if (paramBoolean) {
        i = 1;
      }
      localEditor.putInt("key_panel_shown_guide_for_action", i).commit();
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (aifs.jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (this.b)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_Int == 1)
            {
              bool1 = bool2;
              if (!aiwm.jdField_a_of_type_Boolean)
              {
                bool1 = bool2;
                if (!paramMessageForApollo.isSend())
                {
                  bool1 = bool2;
                  if (paramMessageForApollo.is3dAction())
                  {
                    this.jdField_a_of_type_Boolean = true;
                    this.jdField_a_of_type_Aifg.a.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_Aifg.a.c(), 0).edit().putInt("key_panel_meet_3d_action", 1).commit();
                    a();
                    ((aifc)this.jdField_a_of_type_Aifg.a.getManager(211)).a.a(this.jdField_a_of_type_Aifg.a);
                    QLog.d("ApolloManager", 2, "accept bubble for first 3D action");
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      this.d = paramBoolean;
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_Aifg.a.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_Aifg.a.c(), 0).edit();
      if (paramBoolean) {
        i = 1;
      }
      localEditor.putInt("key_panel_shown_guide_for_json", i).commit();
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	aift:d	Z
    //   6: ifeq +17 -> 23
    //   9: getstatic 274	aiwm:jdField_a_of_type_Boolean	Z
    //   12: istore_1
    //   13: iload_1
    //   14: ifne +9 -> 23
    //   17: iconst_1
    //   18: istore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_1
    //   25: goto -6 -> 19
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	aift
    //   12	13	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aift
 * JD-Core Version:    0.7.0.1
 */