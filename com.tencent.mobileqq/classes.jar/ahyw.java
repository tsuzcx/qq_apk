import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

public abstract class ahyw
  extends bemg
  implements azwh, begh
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private azwg jdField_a_of_type_Azwg;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ExpandableListView a;
  
  public ahyw(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
    bacm.a();
  }
  
  public int a()
  {
    return 0;
  }
  
  protected void a(aiac paramaiac, Bitmap paramBitmap)
  {
    a(paramaiac, paramBitmap, true);
  }
  
  protected void a(aiac paramaiac, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaiac.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (ajed.z.equals(paramaiac.a))
    {
      paramaiac.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843326);
      return;
    }
    if (ajed.A.equals(paramaiac.a))
    {
      paramaiac.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843324);
      return;
    }
    if (ajed.B.equals(paramaiac.a))
    {
      paramaiac.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843329);
      return;
    }
    if (ajed.y.equals(paramaiac.a))
    {
      paramaiac.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130839271);
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Azwg.a(paramaiac.jdField_c_of_type_Int, paramaiac.a);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bacm.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Azwg.a())
        {
          this.jdField_a_of_type_Azwg.a(paramaiac.a, paramaiac.jdField_c_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramaiac.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof aiac)))
      {
        localObject = (aiac)localObject;
        if (paramString != null) {
          break label69;
        }
        a((aiac)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((aiac)localObject).a))
      {
        i += 1;
        break;
      }
      ((aiac)localObject).jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return null;
  }
  
  public int getGroupCount()
  {
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Azwg.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Azwg.a();
      this.jdField_a_of_type_Azwg.c();
    }
    while (!this.jdField_a_of_type_Azwg.a()) {
      return;
    }
    this.jdField_a_of_type_Azwg.a();
    this.jdField_a_of_type_Azwg.b();
    a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahyw
 * JD-Core Version:    0.7.0.1
 */