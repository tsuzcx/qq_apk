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

public abstract class afpk
  extends bcod
  implements baxl, bfob
{
  private int jdField_a_of_type_Int = 0;
  protected Context a;
  protected baxk a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  
  public afpk(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    }
    this.jdField_a_of_type_Baxk = new baxk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Baxk.a(this);
    bbdr.a();
  }
  
  protected void a(aiqn paramaiqn, Bitmap paramBitmap)
  {
    a(paramaiqn, paramBitmap, true);
  }
  
  protected void a(aiqn paramaiqn, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaiqn.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (ajsf.z.equals(paramaiqn.jdField_a_of_type_JavaLangString))
    {
      paramaiqn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843408);
      return;
    }
    if (ajsf.A.equals(paramaiqn.jdField_a_of_type_JavaLangString))
    {
      paramaiqn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843406);
      return;
    }
    if (ajsf.B.equals(paramaiqn.jdField_a_of_type_JavaLangString))
    {
      paramaiqn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843411);
      return;
    }
    if (ajsf.y.equals(paramaiqn.jdField_a_of_type_JavaLangString))
    {
      paramaiqn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839295);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if (ajsf.aa.equals(paramaiqn.jdField_a_of_type_JavaLangString))
      {
        Object localObject = (Friends)paramaiqn.jdField_a_of_type_JavaLangObject;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramaiqn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
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
          paramBitmap = bbdr.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Baxk.a())
        {
          this.jdField_a_of_type_Baxk.a(paramaiqn.jdField_a_of_type_JavaLangString, paramaiqn.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramaiqn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      if ((paramaiqn.jdField_a_of_type_Int == 1) && ((paramaiqn.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) && ((paramaiqn instanceof aiqn)))
      {
        if (!paramaiqn.b)
        {
          paramaiqn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramaiqn.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramaiqn.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          return;
          paramBitmap = this.jdField_a_of_type_Baxk.a(paramaiqn.jdField_a_of_type_Int, paramaiqn.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramaiqn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        }
      }
      else
      {
        paramaiqn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
        if ((localObject != null) && ((localObject instanceof aiqn)))
        {
          localObject = (aiqn)localObject;
          if (paramString != null) {
            break label77;
          }
          a((aiqn)localObject, null, false);
        }
      }
      while (!paramString.equals(((aiqn)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break label19;
        break;
      }
    } while (paramBitmap == null);
    if ((((aiqn)localObject).jdField_a_of_type_Int == 1) && ((((aiqn)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)))
    {
      if (!((aiqn)localObject).b)
      {
        ((DynamicAvatarView)((aiqn)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
      ((aiqn)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      return;
    }
    ((aiqn)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Baxk != null) {
      this.jdField_a_of_type_Baxk.d();
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
    if ((!this.jdField_a_of_type_Baxk.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Baxk.a();
      this.jdField_a_of_type_Baxk.c();
      baxa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_Baxk.a())
    {
      this.jdField_a_of_type_Baxk.a();
      this.jdField_a_of_type_Baxk.b();
      a(null, null);
    }
    baxa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afpk
 * JD-Core Version:    0.7.0.1
 */