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

public abstract class akgw
  extends bhvo
  implements bcwt, bhpo
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private bcws jdField_a_of_type_Bcws;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ExpandableListView a;
  
  public akgw(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Bcws = new bcws(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this);
    bdda.a();
  }
  
  protected void a(akgx paramakgx, Bitmap paramBitmap)
  {
    a(paramakgx, paramBitmap, true);
  }
  
  protected void a(akgx paramakgx, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramakgx.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (aljq.z.equals(paramakgx.jdField_a_of_type_JavaLangString))
    {
      paramakgx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843762);
      return;
    }
    if (aljq.A.equals(paramakgx.jdField_a_of_type_JavaLangString))
    {
      paramakgx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843760);
      return;
    }
    if (aljq.B.equals(paramakgx.jdField_a_of_type_JavaLangString))
    {
      paramakgx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843765);
      return;
    }
    if (aljq.y.equals(paramakgx.jdField_a_of_type_JavaLangString))
    {
      paramakgx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839384);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if ((aljq.aa.equals(paramakgx.jdField_a_of_type_JavaLangString)) && ((paramakgx instanceof akhw)))
      {
        Object localObject = (Friends)((akhw)paramakgx).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramakgx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
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
          if (!(paramakgx instanceof akie)) {
            break label368;
          }
        }
      }
      label368:
      for (paramBitmap = bdda.h();; paramBitmap = bdda.a())
      {
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Bcws.a())
        {
          this.jdField_a_of_type_Bcws.a(paramakgx.jdField_a_of_type_JavaLangString, paramakgx.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
        if (localBitmap == null) {
          break;
        }
        if ((paramakgx.jdField_a_of_type_Int != 1) || (!(paramakgx.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(paramakgx instanceof akhw))) {
          break label399;
        }
        if (((akhw)paramakgx).b) {
          break label375;
        }
        paramakgx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((DynamicAvatarView)paramakgx.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramakgx.jdField_a_of_type_JavaLangString, 100, false, true, 1);
        return;
        paramBitmap = this.jdField_a_of_type_Bcws.a(paramakgx.jdField_a_of_type_Int, paramakgx.jdField_a_of_type_JavaLangString);
        break label205;
      }
      label375:
      paramakgx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
      label399:
      paramakgx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof akgx)))
      {
        localObject = (akgx)localObject;
        if (paramString != null) {
          break label69;
        }
        a((akgx)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((akgx)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break;
      }
      if (paramBitmap != null)
      {
        if ((((akgx)localObject).jdField_a_of_type_Int != 1) || (!(((akgx)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(localObject instanceof akhw))) {
          break label175;
        }
        if (((akhw)localObject).b) {
          break label151;
        }
        ((DynamicAvatarView)((akgx)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      }
    }
    return;
    label151:
    ((akgx)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    return;
    label175:
    ((akgx)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
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
 * Qualified Name:     akgw
 * JD-Core Version:    0.7.0.1
 */