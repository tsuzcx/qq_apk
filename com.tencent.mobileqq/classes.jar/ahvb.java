import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;
import com.tencent.mobileqq.activity.contacts.fragment.TroopFragment.ContactsPinnedHeaderExpandableListView;
import com.tencent.mobileqq.activity.contacts.view.AlphabetPinnedHeaderListView;
import com.tencent.mobileqq.activity.contacts.view.ContactsFPSPinnedHeaderExpandableListView;

public class ahvb
{
  private int jdField_a_of_type_Int = Build.VERSION.SDK_INT;
  private ahvc jdField_a_of_type_Ahvc;
  
  private View a()
  {
    if (this.jdField_a_of_type_Ahvc == null) {
      return null;
    }
    return this.jdField_a_of_type_Ahvc.a();
  }
  
  private boolean a(android.widget.AdapterView paramAdapterView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdapterView != null)
    {
      bool1 = bool2;
      if (paramAdapterView.getFirstVisiblePosition() == 0)
      {
        paramAdapterView = paramAdapterView.getChildAt(0);
        if (paramAdapterView != null)
        {
          bool1 = bool2;
          if (paramAdapterView.getTop() != 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(ScrollView paramScrollView)
  {
    return (paramScrollView == null) || (paramScrollView.getScrollY() <= 0);
  }
  
  private boolean a(com.tencent.widget.AdapterView paramAdapterView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdapterView != null)
    {
      bool1 = bool2;
      if (paramAdapterView.getFirstVisiblePosition() == 0)
      {
        paramAdapterView = paramAdapterView.getChildAt(0);
        if (paramAdapterView != null)
        {
          bool1 = bool2;
          if (paramAdapterView.getTop() != 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = a();
    if ((localView instanceof android.widget.AbsListView)) {
      ((android.widget.AbsListView)localView).smoothScrollBy(paramInt2, paramInt3);
    }
    do
    {
      return;
      if ((localView instanceof com.tencent.widget.AbsListView))
      {
        ((com.tencent.widget.AbsListView)localView).smoothScrollBy(paramInt2, paramInt3);
        return;
      }
      if ((localView instanceof ScrollView))
      {
        ((ScrollView)localView).fling(paramInt1);
        return;
      }
    } while (!(localView instanceof WebView));
    ((WebView)localView).flingScroll(0, paramInt1);
  }
  
  public void a(ahvc paramahvc)
  {
    this.jdField_a_of_type_Ahvc = paramahvc;
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = a();
    if (localView != null)
    {
      if (!(localView instanceof ContactsFPSPinnedHeaderExpandableListView)) {
        break label25;
      }
      ((ContactsFPSPinnedHeaderExpandableListView)localView).setChildViewCanAction(paramBoolean);
    }
    label25:
    do
    {
      return;
      if ((localView instanceof TroopFragment.ContactsPinnedHeaderExpandableListView))
      {
        ((TroopFragment.ContactsPinnedHeaderExpandableListView)localView).setChildViewCanAction(paramBoolean);
        return;
      }
    } while (!(localView instanceof AlphabetPinnedHeaderListView));
    ((AlphabetPinnedHeaderListView)localView).setChildViewCanAction(paramBoolean);
  }
  
  public boolean a()
  {
    View localView = a();
    if (localView == null) {
      return true;
    }
    if ((localView instanceof com.tencent.widget.AdapterView)) {
      return a((com.tencent.widget.AdapterView)localView);
    }
    if ((localView instanceof android.widget.AdapterView)) {
      return a((android.widget.AdapterView)localView);
    }
    if ((localView instanceof ScrollView)) {
      return a((ScrollView)localView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvb
 * JD-Core Version:    0.7.0.1
 */