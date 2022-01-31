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

public abstract class aipn
  extends bfua
  implements baxl, bfob
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private baxk jdField_a_of_type_Baxk;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ExpandableListView a;
  
  public aipn(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Baxk = new baxk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Baxk.a(this);
    bbdr.a();
  }
  
  protected void a(aipo paramaipo, Bitmap paramBitmap)
  {
    a(paramaipo, paramBitmap, true);
  }
  
  protected void a(aipo paramaipo, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaipo.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (ajsf.z.equals(paramaipo.jdField_a_of_type_JavaLangString))
    {
      paramaipo.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843408);
      return;
    }
    if (ajsf.A.equals(paramaipo.jdField_a_of_type_JavaLangString))
    {
      paramaipo.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843406);
      return;
    }
    if (ajsf.B.equals(paramaipo.jdField_a_of_type_JavaLangString))
    {
      paramaipo.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843411);
      return;
    }
    if (ajsf.y.equals(paramaipo.jdField_a_of_type_JavaLangString))
    {
      paramaipo.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839295);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if ((ajsf.aa.equals(paramaipo.jdField_a_of_type_JavaLangString)) && ((paramaipo instanceof aiqn)))
      {
        Object localObject = (Friends)((aiqn)paramaipo).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramaipo.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
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
          if (!(paramaipo instanceof aiqv)) {
            break label368;
          }
        }
      }
      label368:
      for (paramBitmap = bbdr.h();; paramBitmap = bbdr.a())
      {
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Baxk.a())
        {
          this.jdField_a_of_type_Baxk.a(paramaipo.jdField_a_of_type_JavaLangString, paramaipo.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
        if (localBitmap == null) {
          break;
        }
        if ((paramaipo.jdField_a_of_type_Int != 1) || (!(paramaipo.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(paramaipo instanceof aiqn))) {
          break label399;
        }
        if (((aiqn)paramaipo).b) {
          break label375;
        }
        paramaipo.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((DynamicAvatarView)paramaipo.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramaipo.jdField_a_of_type_JavaLangString, 100, false, true, 1);
        return;
        paramBitmap = this.jdField_a_of_type_Baxk.a(paramaipo.jdField_a_of_type_Int, paramaipo.jdField_a_of_type_JavaLangString);
        break label205;
      }
      label375:
      paramaipo.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
      label399:
      paramaipo.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof aipo)))
      {
        localObject = (aipo)localObject;
        if (paramString != null) {
          break label69;
        }
        a((aipo)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((aipo)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break;
      }
      if (paramBitmap != null)
      {
        if ((((aipo)localObject).jdField_a_of_type_Int != 1) || (!(((aipo)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(localObject instanceof aiqn))) {
          break label175;
        }
        if (((aiqn)localObject).b) {
          break label151;
        }
        ((DynamicAvatarView)((aipo)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      }
    }
    return;
    label151:
    ((aipo)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    return;
    label175:
    ((aipo)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Baxk != null) {
      this.jdField_a_of_type_Baxk.d();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aipn
 * JD-Core Version:    0.7.0.1
 */