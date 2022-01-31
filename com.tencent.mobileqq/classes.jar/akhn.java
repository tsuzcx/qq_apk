import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

public abstract class akhn
  extends bhzv
  implements bdbc, bhtv
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private bdbb jdField_a_of_type_Bdbb;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ExpandableListView a;
  
  public akhn(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Bdbb = new bdbb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bdbb.a(this);
    bdhj.a();
  }
  
  public int a()
  {
    return 0;
  }
  
  protected void a(akit paramakit, Bitmap paramBitmap)
  {
    a(paramakit, paramBitmap, true);
  }
  
  protected void a(akit paramakit, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramakit.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (alof.z.equals(paramakit.a))
    {
      paramakit.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843834);
      return;
    }
    if (alof.A.equals(paramakit.a))
    {
      paramakit.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843832);
      return;
    }
    if (alof.B.equals(paramakit.a))
    {
      paramakit.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843837);
      return;
    }
    if (alof.y.equals(paramakit.a))
    {
      paramakit.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130839385);
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Bdbb.a(paramakit.jdField_c_of_type_Int, paramakit.a);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bdhj.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Bdbb.a())
        {
          this.jdField_a_of_type_Bdbb.a(paramakit.a, paramakit.jdField_c_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramakit.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof akit)))
      {
        localObject = (akit)localObject;
        if (paramString != null) {
          break label69;
        }
        a((akit)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((akit)localObject).a))
      {
        i += 1;
        break;
      }
      ((akit)localObject).jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
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
    if ((!this.jdField_a_of_type_Bdbb.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Bdbb.a();
      this.jdField_a_of_type_Bdbb.c();
    }
    while (!this.jdField_a_of_type_Bdbb.a()) {
      return;
    }
    this.jdField_a_of_type_Bdbb.a();
    this.jdField_a_of_type_Bdbb.b();
    a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhn
 * JD-Core Version:    0.7.0.1
 */