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

public abstract class afpi
  extends bcos
  implements baxz, bfos
{
  private int jdField_a_of_type_Int = 0;
  protected Context a;
  protected baxy a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  
  public afpi(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    }
    this.jdField_a_of_type_Baxy = new baxy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this);
    bbef.a();
  }
  
  protected void a(aiql paramaiql, Bitmap paramBitmap)
  {
    a(paramaiql, paramBitmap, true);
  }
  
  protected void a(aiql paramaiql, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaiql.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (ajsd.z.equals(paramaiql.jdField_a_of_type_JavaLangString))
    {
      paramaiql.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843409);
      return;
    }
    if (ajsd.A.equals(paramaiql.jdField_a_of_type_JavaLangString))
    {
      paramaiql.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843407);
      return;
    }
    if (ajsd.B.equals(paramaiql.jdField_a_of_type_JavaLangString))
    {
      paramaiql.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843412);
      return;
    }
    if (ajsd.y.equals(paramaiql.jdField_a_of_type_JavaLangString))
    {
      paramaiql.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839295);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if (ajsd.aa.equals(paramaiql.jdField_a_of_type_JavaLangString))
      {
        Object localObject = (Friends)paramaiql.jdField_a_of_type_JavaLangObject;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramaiql.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
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
          paramBitmap = bbef.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Baxy.a())
        {
          this.jdField_a_of_type_Baxy.a(paramaiql.jdField_a_of_type_JavaLangString, paramaiql.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramaiql.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      if ((paramaiql.jdField_a_of_type_Int == 1) && ((paramaiql.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) && ((paramaiql instanceof aiql)))
      {
        if (!paramaiql.b)
        {
          paramaiql.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramaiql.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramaiql.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          return;
          paramBitmap = this.jdField_a_of_type_Baxy.a(paramaiql.jdField_a_of_type_Int, paramaiql.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramaiql.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        }
      }
      else
      {
        paramaiql.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
        if ((localObject != null) && ((localObject instanceof aiql)))
        {
          localObject = (aiql)localObject;
          if (paramString != null) {
            break label77;
          }
          a((aiql)localObject, null, false);
        }
      }
      while (!paramString.equals(((aiql)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break label19;
        break;
      }
    } while (paramBitmap == null);
    if ((((aiql)localObject).jdField_a_of_type_Int == 1) && ((((aiql)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)))
    {
      if (!((aiql)localObject).b)
      {
        ((DynamicAvatarView)((aiql)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
      ((aiql)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      return;
    }
    ((aiql)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
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
    if ((!this.jdField_a_of_type_Baxy.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afpi
 * JD-Core Version:    0.7.0.1
 */