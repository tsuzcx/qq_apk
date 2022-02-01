import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

public abstract class ambm
  extends bkng
  implements aobv, bkhe
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private aobu jdField_a_of_type_Aobu;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ExpandableListView a;
  
  public ambm(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Aobu = new aobu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aobu.a(this);
    bgmo.a();
  }
  
  protected void a(amcl paramamcl, Bitmap paramBitmap)
  {
    a(paramamcl, paramBitmap, true);
  }
  
  protected void a(amcl paramamcl, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramamcl.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (anhk.z.equals(paramamcl.a))
    {
      paramamcl.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844220);
      return;
    }
    if (anhk.A.equals(paramamcl.a))
    {
      paramamcl.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844218);
      return;
    }
    if (anhk.B.equals(paramamcl.a))
    {
      paramamcl.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844223);
      return;
    }
    if (anhk.y.equals(paramamcl.a))
    {
      paramamcl.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130839564);
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Aobu.a(paramamcl.jdField_c_of_type_Int, paramamcl.a);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bgmo.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Aobu.a())
        {
          this.jdField_a_of_type_Aobu.a(paramamcl.a, paramamcl.jdField_c_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramamcl.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof amcl)))
      {
        localObject = (amcl)localObject;
        if (paramString != null) {
          break label69;
        }
        a((amcl)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((amcl)localObject).a))
      {
        i += 1;
        break;
      }
      ((amcl)localObject).jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.d();
    }
  }
  
  public int c_()
  {
    return 0;
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
    if ((!this.jdField_a_of_type_Aobu.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Aobu.a();
      this.jdField_a_of_type_Aobu.c();
    }
    while (!this.jdField_a_of_type_Aobu.a()) {
      return;
    }
    this.jdField_a_of_type_Aobu.a();
    this.jdField_a_of_type_Aobu.b();
    a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambm
 * JD-Core Version:    0.7.0.1
 */