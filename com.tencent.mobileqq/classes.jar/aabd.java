import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import java.util.ArrayList;
import java.util.List;

public class aabd
  extends aabe
{
  private final int jdField_a_of_type_Int;
  private QCircleBlockContainer jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer;
  protected final ArrayList<aabp> a;
  private int b;
  private int c;
  
  public aabd()
  {
    this(0);
  }
  
  public aabd(int paramInt)
  {
    this(paramInt, null);
  }
  
  public aabd(int paramInt, List<aabp> paramList)
  {
    this(paramInt, paramList, 3, 1);
  }
  
  public aabd(int paramInt1, List<aabp> paramList, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    this.c = paramInt2;
    this.b = paramInt3;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public QCircleBlockContainer a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer;
  }
  
  public QCircleStatusView a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer != null) {
      return (QCircleStatusView)this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a();
    }
    return null;
  }
  
  public String a()
  {
    return "BlockPart";
  }
  
  public ArrayList<aabp> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (this.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer = ((QCircleBlockContainer)paramView.findViewById(this.jdField_a_of_type_Int));
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer == null) {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer = new QCircleBlockContainer(paramView.getContext());
    }
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setLayoutManagerType(this.c, this.b);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setBlockWrapper(this);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setParentFragment(a());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.c();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a())) {
      return true;
    }
    return super.a();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityDestroyed(paramActivity);
    }
    if (a() != null) {
      a().b();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityPaused(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityResumed(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityStarted(paramActivity);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityStopped(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabd
 * JD-Core Version:    0.7.0.1
 */