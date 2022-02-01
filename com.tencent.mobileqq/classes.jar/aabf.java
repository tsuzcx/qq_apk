import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.BasePartFragment;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class aabf
  implements Application.ActivityLifecycleCallbacks
{
  private View jdField_a_of_type_AndroidViewView;
  private BasePartFragment jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment;
  private final LinkedHashMap<String, aabe> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public aabf(BasePartFragment paramBasePartFragment, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment = paramBasePartFragment;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public aabe a(String paramString)
  {
    return (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
  }
  
  public Object a(String paramString, Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null)
      {
        localObject = ((aabe)localObject).a(paramString, paramObject);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((aabe)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((aabe)localObject).a(paramConfiguration);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(String paramString, Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((aabe)localObject).a(paramString, paramObject);
      }
    }
  }
  
  public void a(List<aabe> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aabe localaabe = (aabe)paramList.next();
      localaabe.a(this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment, this.jdField_a_of_type_AndroidViewView, this);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localaabe.getClass().getSimpleName(), localaabe);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if ((localObject != null) && (((aabe)localObject).a())) {
        return true;
      }
    }
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null)
      {
        ((aabe)localObject).onActivityCreated(paramActivity, paramBundle);
        ((aabe)localObject).a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((aabe)localObject).onActivityDestroyed(paramActivity);
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment = null;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((aabe)localObject).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    paramActivity = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (paramActivity.hasNext())
    {
      Object localObject = (String)paramActivity.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((aabe)localObject).onActivityResumed(this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment.getActivity());
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((aabe)localObject).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aabe)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((aabe)localObject).onActivityStopped(paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabf
 * JD-Core Version:    0.7.0.1
 */