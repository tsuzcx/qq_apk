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

public abstract class ajsi
  extends bjai
  implements aoog, blih
{
  private int jdField_a_of_type_Int = 0;
  protected Context a;
  protected aoof a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  
  public ajsi(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    }
    this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
    bhmq.a();
  }
  
  protected void a(ajup paramajup, Bitmap paramBitmap)
  {
    a(paramajup, paramBitmap, true);
  }
  
  protected void a(ajup paramajup, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramajup.d == null) {
      return;
    }
    if (antf.z.equals(paramajup.jdField_a_of_type_JavaLangString))
    {
      paramajup.d.setBackgroundResource(2130844234);
      return;
    }
    if (antf.A.equals(paramajup.jdField_a_of_type_JavaLangString))
    {
      paramajup.d.setBackgroundResource(2130844232);
      return;
    }
    if (antf.B.equals(paramajup.jdField_a_of_type_JavaLangString))
    {
      paramajup.d.setBackgroundResource(2130844237);
      return;
    }
    if (antf.y.equals(paramajup.jdField_a_of_type_JavaLangString))
    {
      paramajup.d.setBackgroundResource(2130839573);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if (antf.aa.equals(paramajup.jdField_a_of_type_JavaLangString))
      {
        Object localObject = (Friends)paramajup.jdField_a_of_type_JavaLangObject;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramajup.d.setBackgroundDrawable((Drawable)localObject);
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
          paramBitmap = bhmq.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Aoof.a())
        {
          this.jdField_a_of_type_Aoof.a(paramajup.jdField_a_of_type_JavaLangString, paramajup.jdField_b_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramajup.d.setImageDrawable(null);
      if ((paramajup.jdField_b_of_type_Int == 1) && ((paramajup.d instanceof DynamicAvatarView)) && ((paramajup instanceof ajup)))
      {
        if (!paramajup.jdField_b_of_type_Boolean)
        {
          paramajup.d.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramajup.d).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramajup.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          return;
          paramBitmap = this.jdField_a_of_type_Aoof.a(paramajup.jdField_b_of_type_Int, paramajup.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramajup.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        }
      }
      else
      {
        paramajup.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
        if ((localObject != null) && ((localObject instanceof ajup)))
        {
          localObject = (ajup)localObject;
          if (paramString != null) {
            break label77;
          }
          a((ajup)localObject, null, false);
        }
      }
      while (!paramString.equals(((ajup)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break label19;
        break;
      }
    } while (paramBitmap == null);
    if ((((ajup)localObject).jdField_b_of_type_Int == 1) && ((((ajup)localObject).d instanceof DynamicAvatarView)))
    {
      if (!((ajup)localObject).jdField_b_of_type_Boolean)
      {
        ((DynamicAvatarView)((ajup)localObject).d).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
      ((ajup)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      return;
    }
    ((ajup)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
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
    if ((!this.jdField_a_of_type_Aoof.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Aoof.a();
      this.jdField_a_of_type_Aoof.c();
      aonz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_Aoof.a())
    {
      this.jdField_a_of_type_Aoof.a();
      this.jdField_a_of_type_Aoof.b();
      a(null, null);
    }
    aonz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsi
 * JD-Core Version:    0.7.0.1
 */