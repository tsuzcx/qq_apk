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

public abstract class akcz
  extends BaseAdapter
  implements aydv, bcwt, bhpo
{
  private int jdField_a_of_type_Int = 0;
  protected aydm a;
  private aydq jdField_a_of_type_Aydq;
  private bcws jdField_a_of_type_Bcws;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<? extends aydj> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  private List<aydj> b;
  
  public akcz(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<? extends aydj> paramList)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_Bcws = new bcws(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = new ArrayList();
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Bcws.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Bcws.a()) {
      this.jdField_a_of_type_Bcws.a(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return bdda.a();
    }
    if (paramInt == 101) {
      return bdda.h();
    }
    if (paramInt == 4) {
      return bdda.f();
    }
    if (paramInt == 11) {
      return bdda.b();
    }
    if (paramInt == 110) {
      return bdda.d();
    }
    if (paramInt == 111) {
      return bdda.e();
    }
    return bdda.a();
  }
  
  public void a()
  {
    if (this.b != null)
    {
      this.b.clear();
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, List<? extends aydj> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    paramList.clear();
    if (this.jdField_a_of_type_Aydm != null) {
      this.jdField_a_of_type_Aydm.a(paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void a(List<? extends aydj> paramList)
  {
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  protected boolean a(akda paramakda)
  {
    return (paramakda != null) && (!TextUtils.isEmpty(paramakda.jdField_a_of_type_JavaLangString));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aydq != null) {
      this.jdField_a_of_type_Aydq.cancel(true);
    }
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
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
    if ((!this.jdField_a_of_type_Bcws.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < i)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof akda)))
        {
          localObject = (akda)localObject;
          if ((localObject != null) && (!TextUtils.isEmpty(((akda)localObject).jdField_a_of_type_JavaLangString)) && (((akda)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (paramInt2 == ((akda)localObject).jdField_a_of_type_Int)) {
            ((akda)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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
      if (this.jdField_a_of_type_Bcws.a()) {
        this.jdField_a_of_type_Bcws.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && ((paramAbsListView instanceof akda)))
        {
          paramAbsListView = (akda)paramAbsListView;
          if (a(paramAbsListView)) {
            paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramAbsListView.jdField_a_of_type_JavaLangString, paramAbsListView.jdField_a_of_type_Int));
          }
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Bcws.a();
    this.jdField_a_of_type_Bcws.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcz
 * JD-Core Version:    0.7.0.1
 */