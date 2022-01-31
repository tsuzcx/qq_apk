import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public abstract class ailo
  extends BaseAdapter
  implements awiv, baxz, bfos
{
  private int jdField_a_of_type_Int = 0;
  protected awim a;
  private awiq jdField_a_of_type_Awiq;
  private baxy jdField_a_of_type_Baxy;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<? extends awij> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  private List<awij> b;
  
  public ailo(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<? extends awij> paramList)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_Baxy = new baxy(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = new ArrayList();
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Baxy.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Baxy.a()) {
      this.jdField_a_of_type_Baxy.a(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return bbef.a();
    }
    if (paramInt == 101) {
      return bbef.h();
    }
    if (paramInt == 4) {
      return bbef.f();
    }
    if (paramInt == 11) {
      return bbef.b();
    }
    if (paramInt == 110) {
      return bbef.d();
    }
    if (paramInt == 111) {
      return bbef.e();
    }
    return bbef.a();
  }
  
  public void a()
  {
    if (this.b != null)
    {
      this.b.clear();
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, List<? extends awij> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    paramList.clear();
    if (this.jdField_a_of_type_Awim != null) {
      this.jdField_a_of_type_Awim.a(paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void a(List<? extends awij> paramList)
  {
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  protected boolean a(ailp paramailp)
  {
    return (paramailp != null) && (!TextUtils.isEmpty(paramailp.jdField_a_of_type_JavaLangString));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Awiq != null) {
      this.jdField_a_of_type_Awiq.cancel(true);
    }
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.b != null) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    int i;
    if ((!this.jdField_a_of_type_Baxy.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < i)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof ailp)))
        {
          localObject = (ailp)localObject;
          if ((localObject != null) && (!TextUtils.isEmpty(((ailp)localObject).jdField_a_of_type_JavaLangString)) && (((ailp)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (paramInt2 == ((ailp)localObject).jdField_a_of_type_Int)) {
            ((ailp)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
      }
      else
      {
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      if (this.jdField_a_of_type_Baxy.a()) {
        this.jdField_a_of_type_Baxy.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && ((paramAbsListView instanceof ailp)))
        {
          paramAbsListView = (ailp)paramAbsListView;
          if (a(paramAbsListView)) {
            paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramAbsListView.jdField_a_of_type_JavaLangString, paramAbsListView.jdField_a_of_type_Int));
          }
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Baxy.a();
    this.jdField_a_of_type_Baxy.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ailo
 * JD-Core Version:    0.7.0.1
 */