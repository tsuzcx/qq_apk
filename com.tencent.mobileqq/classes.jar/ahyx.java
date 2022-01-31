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

public abstract class ahyx
  extends BaseAdapter
  implements avja, azwh, begh
{
  private int jdField_a_of_type_Int = 0;
  protected avir a;
  private aviv jdField_a_of_type_Aviv;
  private azwg jdField_a_of_type_Azwg;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<? extends avio> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  private List<avio> b;
  
  public ahyx(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<? extends avio> paramList)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_Azwg = new azwg(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = new ArrayList();
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Azwg.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Azwg.a()) {
      this.jdField_a_of_type_Azwg.a(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return bacm.a();
    }
    if (paramInt == 101) {
      return bacm.h();
    }
    if (paramInt == 4) {
      return bacm.f();
    }
    if (paramInt == 11) {
      return bacm.b();
    }
    if (paramInt == 110) {
      return bacm.d();
    }
    if (paramInt == 111) {
      return bacm.e();
    }
    return bacm.a();
  }
  
  public void a()
  {
    if (this.b != null)
    {
      this.b.clear();
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, List<? extends avio> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    paramList.clear();
    if (this.jdField_a_of_type_Avir != null) {
      this.jdField_a_of_type_Avir.a(paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void a(List<? extends avio> paramList)
  {
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  protected boolean a(ahyy paramahyy)
  {
    return (paramahyy != null) && (!TextUtils.isEmpty(paramahyy.jdField_a_of_type_JavaLangString));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aviv != null) {
      this.jdField_a_of_type_Aviv.cancel(true);
    }
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
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
    if ((!this.jdField_a_of_type_Azwg.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < i)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof ahyy)))
        {
          localObject = (ahyy)localObject;
          if ((localObject != null) && (!TextUtils.isEmpty(((ahyy)localObject).jdField_a_of_type_JavaLangString)) && (((ahyy)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (paramInt2 == ((ahyy)localObject).jdField_a_of_type_Int)) {
            ((ahyy)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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
      if (this.jdField_a_of_type_Azwg.a()) {
        this.jdField_a_of_type_Azwg.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && ((paramAbsListView instanceof ahyy)))
        {
          paramAbsListView = (ahyy)paramAbsListView;
          if (a(paramAbsListView)) {
            paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramAbsListView.jdField_a_of_type_JavaLangString, paramAbsListView.jdField_a_of_type_Int));
          }
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Azwg.a();
    this.jdField_a_of_type_Azwg.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahyx
 * JD-Core Version:    0.7.0.1
 */