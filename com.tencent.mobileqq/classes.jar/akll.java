import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

public abstract class akll
  extends bhzv
  implements bdbc, bhtv
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private bdbb jdField_a_of_type_Bdbb;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ExpandableListView a;
  
  public akll(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Bdbb = new bdbb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bdbb.a(this);
    bdhj.a();
  }
  
  protected void a(aklm paramaklm, Bitmap paramBitmap)
  {
    a(paramaklm, paramBitmap, true);
  }
  
  protected void a(aklm paramaklm, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaklm.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (alof.z.equals(paramaklm.jdField_a_of_type_JavaLangString))
    {
      paramaklm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843834);
      return;
    }
    if (alof.A.equals(paramaklm.jdField_a_of_type_JavaLangString))
    {
      paramaklm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843832);
      return;
    }
    if (alof.B.equals(paramaklm.jdField_a_of_type_JavaLangString))
    {
      paramaklm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843837);
      return;
    }
    if (alof.y.equals(paramaklm.jdField_a_of_type_JavaLangString))
    {
      paramaklm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839385);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if ((alof.aa.equals(paramaklm.jdField_a_of_type_JavaLangString)) && ((paramaklm instanceof akml)))
      {
        Object localObject = (Friends)((akml)paramaklm).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramaklm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
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
      label205:
      localBitmap = paramBitmap;
      if (paramBitmap == null) {
        if (paramBoolean) {
          if (!(paramaklm instanceof akmt)) {
            break label368;
          }
        }
      }
      label368:
      for (paramBitmap = bdhj.h();; paramBitmap = bdhj.a())
      {
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Bdbb.a())
        {
          this.jdField_a_of_type_Bdbb.a(paramaklm.jdField_a_of_type_JavaLangString, paramaklm.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
        if (localBitmap == null) {
          break;
        }
        if ((paramaklm.jdField_a_of_type_Int != 1) || (!(paramaklm.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(paramaklm instanceof akml))) {
          break label399;
        }
        if (((akml)paramaklm).b) {
          break label375;
        }
        paramaklm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((DynamicAvatarView)paramaklm.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramaklm.jdField_a_of_type_JavaLangString, 100, false, true, 1);
        return;
        paramBitmap = this.jdField_a_of_type_Bdbb.a(paramaklm.jdField_a_of_type_Int, paramaklm.jdField_a_of_type_JavaLangString);
        break label205;
      }
      label375:
      paramaklm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
      label399:
      paramaklm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof aklm)))
      {
        localObject = (aklm)localObject;
        if (paramString != null) {
          break label69;
        }
        a((aklm)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((aklm)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break;
      }
      if (paramBitmap != null)
      {
        if ((((aklm)localObject).jdField_a_of_type_Int != 1) || (!(((aklm)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(localObject instanceof akml))) {
          break label175;
        }
        if (((akml)localObject).b) {
          break label151;
        }
        ((DynamicAvatarView)((aklm)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      }
    }
    return;
    label151:
    ((aklm)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    return;
    label175:
    ((aklm)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
    }
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
 * Qualified Name:     akll
 * JD-Core Version:    0.7.0.1
 */