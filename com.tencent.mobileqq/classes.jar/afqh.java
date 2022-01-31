import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.mobileqq.nearby.smooth.ItemManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.ListView;

public class afqh
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  ItemManager jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  final AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener;
  boolean jdField_a_of_type_Boolean;
  
  public afqh(AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidWidgetListAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = null;
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = null;
  }
  
  View.OnTouchListener a()
  {
    return this.jdField_a_of_type_AndroidViewView$OnTouchListener;
  }
  
  public ListAdapter a()
  {
    ListAdapter localListAdapter2 = (ListAdapter)this.jdField_a_of_type_ComTencentWidgetAbsListView.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof WrapperListAdapter)) {
      localListAdapter1 = ((WrapperListAdapter)localListAdapter2).getWrappedAdapter();
    }
    return localListAdapter1;
  }
  
  public ListAdapter a(ListAdapter paramListAdapter)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager, paramListAdapter);
  }
  
  ListAdapter a(ItemManager paramItemManager, ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    Object localObject = paramListAdapter;
    if (paramItemManager != null)
    {
      localObject = paramListAdapter;
      if (paramListAdapter != null) {
        localObject = new afqc(paramItemManager, (BaseAdapter)paramListAdapter);
      }
    }
    return localObject;
  }
  
  AbsListView.OnScrollListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  }
  
  public AbsListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAbsListView;
  }
  
  AdapterView.OnItemSelectedListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager.b();
    }
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
  }
  
  @TargetApi(11)
  void a(ListAdapter paramListAdapter)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setAdapter(paramListAdapter);
    }
    while (!(this.jdField_a_of_type_ComTencentWidgetAbsListView instanceof ListView)) {
      return;
    }
    ((ListView)this.jdField_a_of_type_ComTencentWidgetAbsListView).setAdapter(paramListAdapter);
  }
  
  public void a(ItemManager paramItemManager)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager.a(null);
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager = null;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramItemManager != null)
    {
      paramItemManager.a(this);
      a(a(paramItemManager, this.jdField_a_of_type_AndroidWidgetListAdapter));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager = paramItemManager;
      this.jdField_a_of_type_Boolean = false;
      b();
      return;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
      a(this.jdField_a_of_type_AndroidWidgetListAdapter);
    }
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void a(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager != null;
  }
  
  public void b()
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afqh
 * JD-Core Version:    0.7.0.1
 */