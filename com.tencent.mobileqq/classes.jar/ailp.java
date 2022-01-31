import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

public abstract class ailp
  extends bfua
  implements baxl, bfob
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private baxk jdField_a_of_type_Baxk;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ExpandableListView a;
  
  public ailp(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Baxk = new baxk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Baxk.a(this);
    bbdr.a();
  }
  
  public int a()
  {
    return 0;
  }
  
  protected void a(aimv paramaimv, Bitmap paramBitmap)
  {
    a(paramaimv, paramBitmap, true);
  }
  
  protected void a(aimv paramaimv, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaimv.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (ajsf.z.equals(paramaimv.a))
    {
      paramaimv.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843408);
      return;
    }
    if (ajsf.A.equals(paramaimv.a))
    {
      paramaimv.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843406);
      return;
    }
    if (ajsf.B.equals(paramaimv.a))
    {
      paramaimv.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843411);
      return;
    }
    if (ajsf.y.equals(paramaimv.a))
    {
      paramaimv.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130839295);
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Baxk.a(paramaimv.jdField_c_of_type_Int, paramaimv.a);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bbdr.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Baxk.a())
        {
          this.jdField_a_of_type_Baxk.a(paramaimv.a, paramaimv.jdField_c_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramaimv.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof aimv)))
      {
        localObject = (aimv)localObject;
        if (paramString != null) {
          break label69;
        }
        a((aimv)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((aimv)localObject).a))
      {
        i += 1;
        break;
      }
      ((aimv)localObject).jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Baxk != null) {
      this.jdField_a_of_type_Baxk.d();
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
    if ((!this.jdField_a_of_type_Baxk.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Baxk.a();
      this.jdField_a_of_type_Baxk.c();
    }
    while (!this.jdField_a_of_type_Baxk.a()) {
      return;
    }
    this.jdField_a_of_type_Baxk.a();
    this.jdField_a_of_type_Baxk.b();
    a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ailp
 * JD-Core Version:    0.7.0.1
 */