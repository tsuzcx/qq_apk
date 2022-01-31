import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;

public abstract class afdo
  extends bblf
  implements azwh, begh
{
  private int jdField_a_of_type_Int = 0;
  protected Context a;
  protected azwg a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  
  public afdo(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    }
    this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
    bacm.a();
  }
  
  protected void a(aidu paramaidu, Bitmap paramBitmap)
  {
    a(paramaidu, paramBitmap, true);
  }
  
  protected void a(aidu paramaidu, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaidu.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (ajed.z.equals(paramaidu.jdField_a_of_type_JavaLangString))
    {
      paramaidu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843326);
      return;
    }
    if (ajed.A.equals(paramaidu.jdField_a_of_type_JavaLangString))
    {
      paramaidu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843324);
      return;
    }
    if (ajed.B.equals(paramaidu.jdField_a_of_type_JavaLangString))
    {
      paramaidu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843329);
      return;
    }
    if (ajed.y.equals(paramaidu.jdField_a_of_type_JavaLangString))
    {
      paramaidu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839271);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if (ajed.Z.equals(paramaidu.jdField_a_of_type_JavaLangString))
      {
        Object localObject = (Friends)paramaidu.jdField_a_of_type_JavaLangObject;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramaidu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
            }
          }
          else
          {
            localBitmap = DeviceHeadMgr.getInstance().getDeviceHeadByDin(((Friends)localObject).name);
          }
        }
        paramBitmap = localBitmap;
      }
    }
    for (;;)
    {
      localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bacm.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Azwg.a())
        {
          this.jdField_a_of_type_Azwg.a(paramaidu.jdField_a_of_type_JavaLangString, paramaidu.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramaidu.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      if ((paramaidu.jdField_a_of_type_Int == 1) && ((paramaidu.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) && ((paramaidu instanceof aidu)))
      {
        if (!paramaidu.b)
        {
          paramaidu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramaidu.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramaidu.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          return;
          paramBitmap = this.jdField_a_of_type_Azwg.a(paramaidu.jdField_a_of_type_Int, paramaidu.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramaidu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        }
      }
      else
      {
        paramaidu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        return;
      }
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    label19:
    Object localObject;
    label77:
    do
    {
      return;
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int i = 0;
      if (i < j)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof aidu)))
        {
          localObject = (aidu)localObject;
          if (paramString != null) {
            break label77;
          }
          a((aidu)localObject, null, false);
        }
      }
      while (!paramString.equals(((aidu)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break label19;
        break;
      }
    } while (paramBitmap == null);
    if ((((aidu)localObject).jdField_a_of_type_Int == 1) && ((((aidu)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)))
    {
      if (!((aidu)localObject).b)
      {
        ((DynamicAvatarView)((aidu)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
      ((aidu)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      return;
    }
    ((aidu)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
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
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Azwg.a();
      this.jdField_a_of_type_Azwg.c();
      azvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_Azwg.a())
    {
      this.jdField_a_of_type_Azwg.a();
      this.jdField_a_of_type_Azwg.b();
      a(null, null);
    }
    azvw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afdo
 * JD-Core Version:    0.7.0.1
 */