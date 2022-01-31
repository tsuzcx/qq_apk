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

public abstract class aicu
  extends bemg
  implements azwh, begh
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private azwg jdField_a_of_type_Azwg;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ExpandableListView a;
  
  public aicu(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
    bacm.a();
  }
  
  protected void a(aicv paramaicv, Bitmap paramBitmap)
  {
    a(paramaicv, paramBitmap, true);
  }
  
  protected void a(aicv paramaicv, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaicv.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (ajed.z.equals(paramaicv.jdField_a_of_type_JavaLangString))
    {
      paramaicv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843326);
      return;
    }
    if (ajed.A.equals(paramaicv.jdField_a_of_type_JavaLangString))
    {
      paramaicv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843324);
      return;
    }
    if (ajed.B.equals(paramaicv.jdField_a_of_type_JavaLangString))
    {
      paramaicv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843329);
      return;
    }
    if (ajed.y.equals(paramaicv.jdField_a_of_type_JavaLangString))
    {
      paramaicv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839271);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if ((ajed.Z.equals(paramaicv.jdField_a_of_type_JavaLangString)) && ((paramaicv instanceof aidu)))
      {
        Object localObject = (Friends)((aidu)paramaicv).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramaicv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
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
          if (!(paramaicv instanceof aiec)) {
            break label368;
          }
        }
      }
      label368:
      for (paramBitmap = bacm.h();; paramBitmap = bacm.a())
      {
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Azwg.a())
        {
          this.jdField_a_of_type_Azwg.a(paramaicv.jdField_a_of_type_JavaLangString, paramaicv.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
        if (localBitmap == null) {
          break;
        }
        if ((paramaicv.jdField_a_of_type_Int != 1) || (!(paramaicv.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(paramaicv instanceof aidu))) {
          break label399;
        }
        if (((aidu)paramaicv).b) {
          break label375;
        }
        paramaicv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((DynamicAvatarView)paramaicv.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramaicv.jdField_a_of_type_JavaLangString, 100, false, true, 1);
        return;
        paramBitmap = this.jdField_a_of_type_Azwg.a(paramaicv.jdField_a_of_type_Int, paramaicv.jdField_a_of_type_JavaLangString);
        break label205;
      }
      label375:
      paramaicv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
      label399:
      paramaicv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof aicv)))
      {
        localObject = (aicv)localObject;
        if (paramString != null) {
          break label69;
        }
        a((aicv)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((aicv)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break;
      }
      if (paramBitmap != null)
      {
        if ((((aicv)localObject).jdField_a_of_type_Int != 1) || (!(((aicv)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(localObject instanceof aidu))) {
          break label175;
        }
        if (((aidu)localObject).b) {
          break label151;
        }
        ((DynamicAvatarView)((aicv)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      }
    }
    return;
    label151:
    ((aicv)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    return;
    label175:
    ((aicv)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aicu
 * JD-Core Version:    0.7.0.1
 */