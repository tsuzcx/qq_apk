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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;

public abstract class ajgz
  extends bhzk
  implements aobv, bkhe
{
  private int jdField_a_of_type_Int = 0;
  protected Context a;
  protected aobu a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  
  public ajgz(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    }
    this.jdField_a_of_type_Aobu = new aobu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aobu.a(this);
    bgmo.a();
  }
  
  protected void a(ajjg paramajjg, Bitmap paramBitmap)
  {
    a(paramajjg, paramBitmap, true);
  }
  
  protected void a(ajjg paramajjg, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramajjg.d == null) {
      return;
    }
    if (anhk.z.equals(paramajjg.jdField_a_of_type_JavaLangString))
    {
      paramajjg.d.setBackgroundResource(2130844220);
      return;
    }
    if (anhk.A.equals(paramajjg.jdField_a_of_type_JavaLangString))
    {
      paramajjg.d.setBackgroundResource(2130844218);
      return;
    }
    if (anhk.B.equals(paramajjg.jdField_a_of_type_JavaLangString))
    {
      paramajjg.d.setBackgroundResource(2130844223);
      return;
    }
    if (anhk.y.equals(paramajjg.jdField_a_of_type_JavaLangString))
    {
      paramajjg.d.setBackgroundResource(2130839564);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if (anhk.aa.equals(paramajjg.jdField_a_of_type_JavaLangString))
      {
        Object localObject = (Friends)paramajjg.jdField_a_of_type_JavaLangObject;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramajjg.d.setBackgroundDrawable((Drawable)localObject);
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
          paramBitmap = bgmo.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Aobu.a())
        {
          this.jdField_a_of_type_Aobu.a(paramajjg.jdField_a_of_type_JavaLangString, paramajjg.jdField_b_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramajjg.d.setImageDrawable(null);
      if ((paramajjg.jdField_b_of_type_Int == 1) && ((paramajjg.d instanceof DynamicAvatarView)) && ((paramajjg instanceof ajjg)))
      {
        if (!paramajjg.jdField_b_of_type_Boolean)
        {
          paramajjg.d.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramajjg.d).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramajjg.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          return;
          paramBitmap = this.jdField_a_of_type_Aobu.a(paramajjg.jdField_b_of_type_Int, paramajjg.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramajjg.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        }
      }
      else
      {
        paramajjg.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
        if ((localObject != null) && ((localObject instanceof ajjg)))
        {
          localObject = (ajjg)localObject;
          if (paramString != null) {
            break label77;
          }
          a((ajjg)localObject, null, false);
        }
      }
      while (!paramString.equals(((ajjg)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break label19;
        break;
      }
    } while (paramBitmap == null);
    if ((((ajjg)localObject).jdField_b_of_type_Int == 1) && ((((ajjg)localObject).d instanceof DynamicAvatarView)))
    {
      if (!((ajjg)localObject).jdField_b_of_type_Boolean)
      {
        ((DynamicAvatarView)((ajjg)localObject).d).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
      ((ajjg)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      return;
    }
    ((ajjg)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.d();
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
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Aobu.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Aobu.a();
      this.jdField_a_of_type_Aobu.c();
      aobo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_Aobu.a())
    {
      this.jdField_a_of_type_Aobu.a();
      this.jdField_a_of_type_Aobu.b();
      a(null, null);
    }
    aobo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgz
 * JD-Core Version:    0.7.0.1
 */