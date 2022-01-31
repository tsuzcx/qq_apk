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

public abstract class ahmz
  extends benu
  implements bcwt, bhpo
{
  private int jdField_a_of_type_Int = 0;
  protected Context a;
  protected bcws a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  
  public ahmz(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    }
    this.jdField_a_of_type_Bcws = new bcws(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this);
    bdda.a();
  }
  
  protected void a(akhw paramakhw, Bitmap paramBitmap)
  {
    a(paramakhw, paramBitmap, true);
  }
  
  protected void a(akhw paramakhw, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramakhw.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (aljq.z.equals(paramakhw.jdField_a_of_type_JavaLangString))
    {
      paramakhw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843762);
      return;
    }
    if (aljq.A.equals(paramakhw.jdField_a_of_type_JavaLangString))
    {
      paramakhw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843760);
      return;
    }
    if (aljq.B.equals(paramakhw.jdField_a_of_type_JavaLangString))
    {
      paramakhw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843765);
      return;
    }
    if (aljq.y.equals(paramakhw.jdField_a_of_type_JavaLangString))
    {
      paramakhw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839384);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if (aljq.aa.equals(paramakhw.jdField_a_of_type_JavaLangString))
      {
        Object localObject = (Friends)paramakhw.jdField_a_of_type_JavaLangObject;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramakhw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
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
          paramBitmap = bdda.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Bcws.a())
        {
          this.jdField_a_of_type_Bcws.a(paramakhw.jdField_a_of_type_JavaLangString, paramakhw.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramakhw.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      if ((paramakhw.jdField_a_of_type_Int == 1) && ((paramakhw.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) && ((paramakhw instanceof akhw)))
      {
        if (!paramakhw.b)
        {
          paramakhw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramakhw.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramakhw.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          return;
          paramBitmap = this.jdField_a_of_type_Bcws.a(paramakhw.jdField_a_of_type_Int, paramakhw.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramakhw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        }
      }
      else
      {
        paramakhw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
        if ((localObject != null) && ((localObject instanceof akhw)))
        {
          localObject = (akhw)localObject;
          if (paramString != null) {
            break label77;
          }
          a((akhw)localObject, null, false);
        }
      }
      while (!paramString.equals(((akhw)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break label19;
        break;
      }
    } while (paramBitmap == null);
    if ((((akhw)localObject).jdField_a_of_type_Int == 1) && ((((akhw)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)))
    {
      if (!((akhw)localObject).b)
      {
        ((DynamicAvatarView)((akhw)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
      ((akhw)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      return;
    }
    ((akhw)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
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
    if ((!this.jdField_a_of_type_Bcws.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Bcws.a();
      this.jdField_a_of_type_Bcws.c();
      bcwi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_Bcws.a())
    {
      this.jdField_a_of_type_Bcws.a();
      this.jdField_a_of_type_Bcws.b();
      a(null, null);
    }
    bcwi.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmz
 * JD-Core Version:    0.7.0.1
 */