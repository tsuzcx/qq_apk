import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

public abstract class ailn
  extends bfur
  implements baxz, bfos
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private baxy jdField_a_of_type_Baxy;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ExpandableListView a;
  
  public ailn(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Baxy = new baxy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this);
    bbef.a();
  }
  
  public int a()
  {
    return 0;
  }
  
  protected void a(aimt paramaimt, Bitmap paramBitmap)
  {
    a(paramaimt, paramBitmap, true);
  }
  
  protected void a(aimt paramaimt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaimt.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (ajsd.z.equals(paramaimt.a))
    {
      paramaimt.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843409);
      return;
    }
    if (ajsd.A.equals(paramaimt.a))
    {
      paramaimt.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843407);
      return;
    }
    if (ajsd.B.equals(paramaimt.a))
    {
      paramaimt.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843412);
      return;
    }
    if (ajsd.y.equals(paramaimt.a))
    {
      paramaimt.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130839295);
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Baxy.a(paramaimt.jdField_c_of_type_Int, paramaimt.a);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bbef.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Baxy.a())
        {
          this.jdField_a_of_type_Baxy.a(paramaimt.a, paramaimt.jdField_c_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramaimt.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof aimt)))
      {
        localObject = (aimt)localObject;
        if (paramString != null) {
          break label69;
        }
        a((aimt)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((aimt)localObject).a))
      {
        i += 1;
        break;
      }
      ((aimt)localObject).jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
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
    if ((!this.jdField_a_of_type_Baxy.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Baxy.a();
      this.jdField_a_of_type_Baxy.c();
    }
    while (!this.jdField_a_of_type_Baxy.a()) {
      return;
    }
    this.jdField_a_of_type_Baxy.a();
    this.jdField_a_of_type_Baxy.b();
    a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ailn
 * JD-Core Version:    0.7.0.1
 */