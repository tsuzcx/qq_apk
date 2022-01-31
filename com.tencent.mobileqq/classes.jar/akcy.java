import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

public abstract class akcy
  extends bhvo
  implements bcwt, bhpo
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private bcws jdField_a_of_type_Bcws;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ExpandableListView a;
  
  public akcy(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Bcws = new bcws(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this);
    bdda.a();
  }
  
  public int a()
  {
    return 0;
  }
  
  protected void a(akee paramakee, Bitmap paramBitmap)
  {
    a(paramakee, paramBitmap, true);
  }
  
  protected void a(akee paramakee, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramakee.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (aljq.z.equals(paramakee.a))
    {
      paramakee.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843762);
      return;
    }
    if (aljq.A.equals(paramakee.a))
    {
      paramakee.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843760);
      return;
    }
    if (aljq.B.equals(paramakee.a))
    {
      paramakee.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843765);
      return;
    }
    if (aljq.y.equals(paramakee.a))
    {
      paramakee.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130839384);
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Bcws.a(paramakee.jdField_c_of_type_Int, paramakee.a);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bdda.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Bcws.a())
        {
          this.jdField_a_of_type_Bcws.a(paramakee.a, paramakee.jdField_c_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramakee.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof akee)))
      {
        localObject = (akee)localObject;
        if (paramString != null) {
          break label69;
        }
        a((akee)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((akee)localObject).a))
      {
        i += 1;
        break;
      }
      ((akee)localObject).jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
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
    if ((!this.jdField_a_of_type_Bcws.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Bcws.a();
      this.jdField_a_of_type_Bcws.c();
    }
    while (!this.jdField_a_of_type_Bcws.a()) {
      return;
    }
    this.jdField_a_of_type_Bcws.a();
    this.jdField_a_of_type_Bcws.b();
    a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcy
 * JD-Core Version:    0.7.0.1
 */