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

public abstract class aipl
  extends bfur
  implements baxz, bfos
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private baxy jdField_a_of_type_Baxy;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ExpandableListView a;
  
  public aipl(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Baxy = new baxy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this);
    bbef.a();
  }
  
  protected void a(aipm paramaipm, Bitmap paramBitmap)
  {
    a(paramaipm, paramBitmap, true);
  }
  
  protected void a(aipm paramaipm, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaipm.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (ajsd.z.equals(paramaipm.jdField_a_of_type_JavaLangString))
    {
      paramaipm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843409);
      return;
    }
    if (ajsd.A.equals(paramaipm.jdField_a_of_type_JavaLangString))
    {
      paramaipm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843407);
      return;
    }
    if (ajsd.B.equals(paramaipm.jdField_a_of_type_JavaLangString))
    {
      paramaipm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843412);
      return;
    }
    if (ajsd.y.equals(paramaipm.jdField_a_of_type_JavaLangString))
    {
      paramaipm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839295);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if ((ajsd.aa.equals(paramaipm.jdField_a_of_type_JavaLangString)) && ((paramaipm instanceof aiql)))
      {
        Object localObject = (Friends)((aiql)paramaipm).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramaipm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
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
          if (!(paramaipm instanceof aiqt)) {
            break label368;
          }
        }
      }
      label368:
      for (paramBitmap = bbef.h();; paramBitmap = bbef.a())
      {
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Baxy.a())
        {
          this.jdField_a_of_type_Baxy.a(paramaipm.jdField_a_of_type_JavaLangString, paramaipm.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
        if (localBitmap == null) {
          break;
        }
        if ((paramaipm.jdField_a_of_type_Int != 1) || (!(paramaipm.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(paramaipm instanceof aiql))) {
          break label399;
        }
        if (((aiql)paramaipm).b) {
          break label375;
        }
        paramaipm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((DynamicAvatarView)paramaipm.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramaipm.jdField_a_of_type_JavaLangString, 100, false, true, 1);
        return;
        paramBitmap = this.jdField_a_of_type_Baxy.a(paramaipm.jdField_a_of_type_Int, paramaipm.jdField_a_of_type_JavaLangString);
        break label205;
      }
      label375:
      paramaipm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
      label399:
      paramaipm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof aipm)))
      {
        localObject = (aipm)localObject;
        if (paramString != null) {
          break label69;
        }
        a((aipm)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((aipm)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break;
      }
      if (paramBitmap != null)
      {
        if ((((aipm)localObject).jdField_a_of_type_Int != 1) || (!(((aipm)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(localObject instanceof aiql))) {
          break label175;
        }
        if (((aiql)localObject).b) {
          break label151;
        }
        ((DynamicAvatarView)((aipm)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      }
    }
    return;
    label151:
    ((aipm)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    return;
    label175:
    ((aipm)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Baxy.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Baxy.a();
      this.jdField_a_of_type_Baxy.c();
      baxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_Baxy.a())
    {
      this.jdField_a_of_type_Baxy.a();
      this.jdField_a_of_type_Baxy.b();
      a(null, null);
    }
    baxo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aipl
 * JD-Core Version:    0.7.0.1
 */