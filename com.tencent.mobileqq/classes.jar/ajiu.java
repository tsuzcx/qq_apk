import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public abstract class ajiu
  extends birb
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  protected Context a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected FaceDecoder a;
  protected XListView a;
  
  public ajiu(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    bheg.a();
  }
  
  protected void a(ajlb paramajlb, Bitmap paramBitmap)
  {
    a(paramajlb, paramBitmap, true);
  }
  
  protected void a(ajlb paramajlb, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramajlb.d == null) {
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramajlb.jdField_a_of_type_JavaLangString))
    {
      paramajlb.d.setBackgroundResource(2130844186);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramajlb.jdField_a_of_type_JavaLangString))
    {
      paramajlb.d.setBackgroundResource(2130844184);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramajlb.jdField_a_of_type_JavaLangString))
    {
      paramajlb.d.setBackgroundResource(2130844189);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramajlb.jdField_a_of_type_JavaLangString))
    {
      paramajlb.d.setBackgroundResource(2130839629);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if (AppConstants.SMARTDEVICE_UIN.equals(paramajlb.jdField_a_of_type_JavaLangString))
      {
        Object localObject = (Friends)paramajlb.jdField_a_of_type_JavaLangObject;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramajlb.d.setBackgroundDrawable((Drawable)localObject);
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
          paramBitmap = bheg.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramajlb.jdField_a_of_type_JavaLangString, paramajlb.jdField_b_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramajlb.d.setImageDrawable(null);
      if ((paramajlb.jdField_b_of_type_Int == 1) && ((paramajlb.d instanceof DynamicAvatarView)) && ((paramajlb instanceof ajlb)))
      {
        if (!paramajlb.jdField_b_of_type_Boolean)
        {
          paramajlb.d.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramajlb.d).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramajlb.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          return;
          paramBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(paramajlb.jdField_b_of_type_Int, paramajlb.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramajlb.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        }
      }
      else
      {
        paramajlb.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
        if ((localObject != null) && ((localObject instanceof ajlb)))
        {
          localObject = (ajlb)localObject;
          if (paramString != null) {
            break label77;
          }
          a((ajlb)localObject, null, false);
        }
      }
      while (!paramString.equals(((ajlb)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break label19;
        break;
      }
    } while (paramBitmap == null);
    if ((((ajlb)localObject).jdField_b_of_type_Int == 1) && ((((ajlb)localObject).d instanceof DynamicAvatarView)))
    {
      if (!((ajlb)localObject).jdField_b_of_type_Boolean)
      {
        ((DynamicAvatarView)((ajlb)localObject).d).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
      ((ajlb)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      return;
    }
    ((ajlb)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
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
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
      aokb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
      a(null, null);
    }
    aokb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajiu
 * JD-Core Version:    0.7.0.1
 */