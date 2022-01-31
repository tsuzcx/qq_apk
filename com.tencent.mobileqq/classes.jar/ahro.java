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

public abstract class ahro
  extends besd
  implements bdbc, bhtv
{
  private int jdField_a_of_type_Int = 0;
  protected Context a;
  protected bdbb a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  
  public ahro(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    }
    this.jdField_a_of_type_Bdbb = new bdbb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bdbb.a(this);
    bdhj.a();
  }
  
  protected void a(akml paramakml, Bitmap paramBitmap)
  {
    a(paramakml, paramBitmap, true);
  }
  
  protected void a(akml paramakml, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramakml.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (alof.z.equals(paramakml.jdField_a_of_type_JavaLangString))
    {
      paramakml.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843834);
      return;
    }
    if (alof.A.equals(paramakml.jdField_a_of_type_JavaLangString))
    {
      paramakml.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843832);
      return;
    }
    if (alof.B.equals(paramakml.jdField_a_of_type_JavaLangString))
    {
      paramakml.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843837);
      return;
    }
    if (alof.y.equals(paramakml.jdField_a_of_type_JavaLangString))
    {
      paramakml.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839385);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if (alof.aa.equals(paramakml.jdField_a_of_type_JavaLangString))
      {
        Object localObject = (Friends)paramakml.jdField_a_of_type_JavaLangObject;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramakml.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
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
          paramBitmap = bdhj.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Bdbb.a())
        {
          this.jdField_a_of_type_Bdbb.a(paramakml.jdField_a_of_type_JavaLangString, paramakml.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramakml.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      if ((paramakml.jdField_a_of_type_Int == 1) && ((paramakml.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) && ((paramakml instanceof akml)))
      {
        if (!paramakml.b)
        {
          paramakml.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramakml.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramakml.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          return;
          paramBitmap = this.jdField_a_of_type_Bdbb.a(paramakml.jdField_a_of_type_Int, paramakml.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramakml.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        }
      }
      else
      {
        paramakml.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
        if ((localObject != null) && ((localObject instanceof akml)))
        {
          localObject = (akml)localObject;
          if (paramString != null) {
            break label77;
          }
          a((akml)localObject, null, false);
        }
      }
      while (!paramString.equals(((akml)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break label19;
        break;
      }
    } while (paramBitmap == null);
    if ((((akml)localObject).jdField_a_of_type_Int == 1) && ((((akml)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)))
    {
      if (!((akml)localObject).b)
      {
        ((DynamicAvatarView)((akml)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
      ((akml)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      return;
    }
    ((akml)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
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
    if ((!this.jdField_a_of_type_Bdbb.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Bdbb.a();
      this.jdField_a_of_type_Bdbb.c();
      bdar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_Bdbb.a())
    {
      this.jdField_a_of_type_Bdbb.a();
      this.jdField_a_of_type_Bdbb.b();
      a(null, null);
    }
    bdar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahro
 * JD-Core Version:    0.7.0.1
 */