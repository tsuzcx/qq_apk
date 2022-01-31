import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class akif
  implements ajfe
{
  public static final String TAG = "AppletsObserver";
  
  protected void onAppletsSettingSwitchChange(int paramInt) {}
  
  protected void onGetAppletsDetail(boolean paramBoolean, List<AppletsAccountInfo> paramList) {}
  
  protected void onGetAppletsPushUnreadInfo(Object paramObject) {}
  
  protected void onGetAppletsSettingSwitch(boolean paramBoolean, List<akio> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 2, "onGetAppletsSettingSwitch:  isSuccess: " + paramBoolean);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (agxk)((QQAppInterface)localObject1).getManager(315);; localObject1 = null)
    {
      if (localObject1 == null) {
        return;
      }
      HashSet localHashSet = new HashSet();
      if ((paramList != null) && (paramBoolean) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject2 = (akio)paramList.next();
          if ((((akio)localObject2).a != null) && (((akio)localObject2).a.size() > 0) && (((akio)localObject2).a.get(0) != null) && (((AppletItem)((akio)localObject2).a.get(0)).a() == 1L))
          {
            localObject2 = (AppletItem)((akio)localObject2).a.get(0);
            if (((AppletItem)localObject2).b() == 1) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((agxk)localObject1).a(paramBoolean);
              onAppletsSettingSwitchChange(((AppletItem)localObject2).b());
              break;
            }
          }
          if ((((akio)localObject2).a != null) && (((akio)localObject2).a.size() > 0))
          {
            localObject2 = ((akio)localObject2).a.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              AppletItem localAppletItem = (AppletItem)((Iterator)localObject2).next();
              if ((localAppletItem.a() != 1L) && (localAppletItem.b() != 1)) {
                localHashSet.add(String.valueOf(localAppletItem.a()));
              }
            }
          }
        }
      }
      ((agxk)localObject1).a(localHashSet);
      return;
    }
  }
  
  protected void onReceiveAppletsMessageUnreadInfo(Map<String, Integer> paramMap) {}
  
  protected void onSetAppletsSettingSwitch(boolean paramBoolean, List<AppletItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 2, "onSetAppletsSettingSwitch:  isSuccess: " + paramBoolean);
    }
    agxk localagxk = null;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localagxk = (agxk)((QQAppInterface)localObject).getManager(315);
    }
    if (localagxk == null) {}
    for (;;)
    {
      return;
      if ((paramList != null) && (paramBoolean))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (AppletItem)paramList.next();
          int i = ((AppletItem)localObject).b();
          if (((AppletItem)localObject).a() == 1L)
          {
            if (i == 1) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              localagxk.a(paramBoolean);
              onAppletsSettingSwitchChange(i);
              break;
            }
          }
          if (localagxk != null) {
            if (i == 0) {
              localagxk.c(String.valueOf(((AppletItem)localObject).a()));
            } else {
              localagxk.d(String.valueOf(((AppletItem)localObject).a()));
            }
          }
        }
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      onGetAppletsDetail(paramBoolean, (List)paramObject);
      return;
    case 2: 
      onGetAppletsSettingSwitch(paramBoolean, (List)paramObject);
      return;
    case 3: 
      onSetAppletsSettingSwitch(paramBoolean, (List)paramObject);
      return;
    case 8: 
      onReceiveAppletsMessageUnreadInfo((Map)paramObject);
      return;
    }
    onGetAppletsPushUnreadInfo(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akif
 * JD-Core Version:    0.7.0.1
 */