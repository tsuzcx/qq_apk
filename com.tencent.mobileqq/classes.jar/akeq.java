import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class akeq
  extends BaseAdapter
  implements Handler.Callback
{
  int jdField_a_of_type_Int;
  acxg jdField_a_of_type_Acxg;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean = false;
  Drawable b;
  
  public akeq(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297345));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130850063);
    this.b = paramContext.getResources().getDrawable(2130850064);
    this.jdField_a_of_type_MqqOsMqqHandler = new bdbw(Looper.getMainLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
  }
  
  public void a(acxg paramacxg)
  {
    this.jdField_a_of_type_Acxg = paramacxg;
  }
  
  public void a(acxi paramacxi, View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      a(paramView);
      paramView.setTag(paramacxi.b);
      paramacxi = (ImageView)paramView.findViewById(2131367910);
    } while (paramacxi == null);
    paramacxi.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        paramView = (ImageProgressCircle)paramView.findViewById(2131368010);
      } while (paramView == null);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1, paramView);
    } while (paramView.getVisibility() == 4);
    paramView.setVisibility(4);
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "showProgress() progressCircle = " + paramImageProgressCircle);
    }
    if (paramImageProgressCircle == null) {}
    while (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1, paramImageProgressCircle)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramImageProgressCircle;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 550L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(acxi paramacxi, View paramView)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadThumbImage() path = " + paramacxi.b);
    }
    try
    {
      URL localURL = new URL("profile_img_thumb", null, paramacxi.b);
      if (this.jdField_a_of_type_Acxg != null) {
        localObject1 = this.jdField_a_of_type_Acxg.a();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramView.setTag(paramacxi.b);
      ((ImageView)paramView.findViewById(2131367910)).setImageDrawable((Drawable)localObject1);
      return;
    }
    catch (MalformedURLException paramacxi)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.PhotoWall", 2, paramacxi.toString());
    }
  }
  
  public void c(acxi paramacxi, View paramView)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadBigImage() path = " + paramacxi.c);
    }
    if (paramView == null) {
      return;
    }
    URL localURL;
    for (;;)
    {
      try
      {
        a(paramView);
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_thumb", null, paramacxi.b));
        localURL = new URL("profile_img_big_fhd", null, paramacxi.c);
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          if (i == 0) {
            break label164;
          }
          localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          paramView.setTag(paramacxi.c);
          paramacxi = (ImageView)paramView.findViewById(2131367910);
          if (paramacxi == null) {
            break;
          }
          paramacxi.setImageDrawable((Drawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException paramacxi)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.PhotoWall", 2, paramacxi.toString());
        }
        paramView.setTag(null);
        return;
      }
      i = 0;
    }
    label164:
    if (this.jdField_a_of_type_Acxg != null) {}
    for (Object localObject1 = this.jdField_a_of_type_Acxg.a();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Acxg != null) {
      return this.jdField_a_of_type_Acxg.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Acxg != null) {
      return this.jdField_a_of_type_Acxg.a(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    ImageView localImageView;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559184, null);
      paramView = (ImageProgressCircle)paramViewGroup.findViewById(2131368010);
      paramView.setVisibility(4);
      localImageView = (ImageView)paramViewGroup.findViewById(2131367910);
      localImageView.setMinimumWidth(this.jdField_a_of_type_Int);
      localImageView.setMinimumHeight(this.jdField_a_of_type_Int);
      localObject = (acxi)getItem(paramInt);
      if (localObject != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label156;
        }
        localObject = this.jdField_a_of_type_Acxg.a.a(this.jdField_a_of_type_Acxg.b, (byte)1, false, false);
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = bdda.c();
        }
        localImageView.setImageDrawable(paramView);
      }
    }
    for (;;)
    {
      localObject = paramViewGroup;
      if (AppSetting.c)
      {
        localImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131691224));
        localObject = paramViewGroup;
      }
      return localObject;
      label156:
      if (((acxi)localObject).jdField_a_of_type_Int == 6)
      {
        c((acxi)localObject, paramViewGroup);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, paramInt + "," + ((acxi)localObject).c);
        }
      }
      else if ((((acxi)localObject).jdField_a_of_type_Int == 3) || (((acxi)localObject).jdField_a_of_type_Int == 4))
      {
        b((acxi)localObject, paramViewGroup);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, "thumb: " + paramInt + "," + ((acxi)localObject).b);
        }
        if (((acxi)localObject).jdField_a_of_type_Boolean) {
          a(paramView);
        }
      }
      else
      {
        localImageView.setImageResource(2130850064);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof ImageProgressCircle)))
    {
      paramMessage = (ImageProgressCircle)paramMessage.obj;
      if (paramMessage.getVisibility() != 0) {
        paramMessage.setVisibility(0);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akeq
 * JD-Core Version:    0.7.0.1
 */