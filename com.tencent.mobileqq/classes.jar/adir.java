import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.widget.QQTabHost;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class adir
  implements bett
{
  private Map<View, ArrayList<View>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public adir(MainFragment paramMainFragment) {}
  
  private void a(View paramView, ArrayList<View> paramArrayList)
  {
    if ((paramView == null) || (!(paramView instanceof ViewGroup))) {}
    for (;;)
    {
      return;
      paramView = (ViewGroup)paramView;
      if ((((paramView instanceof FPSXListView)) || ((paramView instanceof FPSSwipListView))) && (!paramArrayList.contains(paramView))) {
        paramArrayList.add(paramView);
      }
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramArrayList);
        i += 1;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).getCurrentView();
    Object localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(localView);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ArrayList();
      a(localView, (ArrayList)localObject1);
      this.jdField_a_of_type_JavaUtilMap.put(localView, localObject1);
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (View)((Iterator)localObject1).next();
      if ((localObject2 instanceof FPSXListView)) {
        ((FPSXListView)localObject2).b(paramBoolean);
      } else if ((localObject2 instanceof FPSSwipListView)) {
        ((FPSSwipListView)localObject2).a(paramBoolean);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    a(false);
  }
  
  public void b(Bundle paramBundle)
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adir
 * JD-Core Version:    0.7.0.1
 */