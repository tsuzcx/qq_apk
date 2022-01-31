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

public class ainf
  extends BaseAdapter
  implements Handler.Callback
{
  int jdField_a_of_type_Int;
  abgg jdField_a_of_type_Abgg;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean = false;
  Drawable b;
  
  public ainf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297326));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130849629);
    this.b = paramContext.getResources().getDrawable(2130849630);
    this.jdField_a_of_type_MqqOsMqqHandler = new bbdc(Looper.getMainLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
  }
  
  public void a(abgg paramabgg)
  {
    this.jdField_a_of_type_Abgg = paramabgg;
  }
  
  public void a(abgi paramabgi, View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      a(paramView);
      paramView.setTag(paramabgi.b);
      paramabgi = (ImageView)paramView.findViewById(2131367776);
    } while (paramabgi == null);
    paramabgi.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        paramView = (ImageProgressCircle)paramView.findViewById(2131367875);
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
  
  public void b(abgi paramabgi, View paramView)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadThumbImage() path = " + paramabgi.b);
    }
    try
    {
      URL localURL = new URL("profile_img_thumb", null, paramabgi.b);
      if (this.jdField_a_of_type_Abgg != null) {
        localObject1 = this.jdField_a_of_type_Abgg.a();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramView.setTag(paramabgi.b);
      ((ImageView)paramView.findViewById(2131367776)).setImageDrawable((Drawable)localObject1);
      return;
    }
    catch (MalformedURLException paramabgi)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.PhotoWall", 2, paramabgi.toString());
    }
  }
  
  public void c(abgi paramabgi, View paramView)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadBigImage() path = " + paramabgi.c);
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
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_thumb", null, paramabgi.b));
        localURL = new URL("profile_img_big_fhd", null, paramabgi.c);
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          if (i == 0) {
            break label164;
          }
          localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          paramView.setTag(paramabgi.c);
          paramabgi = (ImageView)paramView.findViewById(2131367776);
          if (paramabgi == null) {
            break;
          }
          paramabgi.setImageDrawable((Drawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException paramabgi)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.PhotoWall", 2, paramabgi.toString());
        }
        paramView.setTag(null);
        return;
      }
      i = 0;
    }
    label164:
    if (this.jdField_a_of_type_Abgg != null) {}
    for (Object localObject1 = this.jdField_a_of_type_Abgg.a();; localObject1 = null)
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
    if (this.jdField_a_of_type_Abgg != null) {
      return this.jdField_a_of_type_Abgg.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Abgg != null) {
      return this.jdField_a_of_type_Abgg.a(paramInt);
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
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559141, null);
      paramView = (ImageProgressCircle)paramViewGroup.findViewById(2131367875);
      paramView.setVisibility(4);
      localImageView = (ImageView)paramViewGroup.findViewById(2131367776);
      localImageView.setMinimumWidth(this.jdField_a_of_type_Int);
      localImageView.setMinimumHeight(this.jdField_a_of_type_Int);
      localObject = (abgi)getItem(paramInt);
      if (localObject != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label156;
        }
        localObject = this.jdField_a_of_type_Abgg.a.a(this.jdField_a_of_type_Abgg.b, (byte)1, false, false);
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = bbef.c();
        }
        localImageView.setImageDrawable(paramView);
      }
    }
    for (;;)
    {
      localObject = paramViewGroup;
      if (AppSetting.d)
      {
        localImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131691171));
        localObject = paramViewGroup;
      }
      return localObject;
      label156:
      if (((abgi)localObject).jdField_a_of_type_Int == 6)
      {
        c((abgi)localObject, paramViewGroup);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, paramInt + "," + ((abgi)localObject).c);
        }
      }
      else if ((((abgi)localObject).jdField_a_of_type_Int == 3) || (((abgi)localObject).jdField_a_of_type_Int == 4))
      {
        b((abgi)localObject, paramViewGroup);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, "thumb: " + paramInt + "," + ((abgi)localObject).b);
        }
        if (((abgi)localObject).jdField_a_of_type_Boolean) {
          a(paramView);
        }
      }
      else
      {
        localImageView.setImageResource(2130849630);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ainf
 * JD-Core Version:    0.7.0.1
 */