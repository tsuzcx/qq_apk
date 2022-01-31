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

public class aiao
  extends BaseAdapter
  implements Handler.Callback
{
  int jdField_a_of_type_Int;
  aawn jdField_a_of_type_Aawn;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean = false;
  Drawable b;
  
  public aiao(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131166245));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130849384);
    this.b = paramContext.getResources().getDrawable(2130849385);
    this.jdField_a_of_type_MqqOsMqqHandler = new babk(Looper.getMainLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
  }
  
  public void a(aawn paramaawn)
  {
    this.jdField_a_of_type_Aawn = paramaawn;
  }
  
  public void a(aawp paramaawp, View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      a(paramView);
      paramView.setTag(paramaawp.b);
      paramaawp = (ImageView)paramView.findViewById(2131302158);
    } while (paramaawp == null);
    paramaawp.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        paramView = (ImageProgressCircle)paramView.findViewById(2131302255);
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
  
  public void b(aawp paramaawp, View paramView)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadThumbImage() path = " + paramaawp.b);
    }
    try
    {
      URL localURL = new URL("profile_img_thumb", null, paramaawp.b);
      if (this.jdField_a_of_type_Aawn != null) {
        localObject1 = this.jdField_a_of_type_Aawn.a();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramView.setTag(paramaawp.b);
      ((ImageView)paramView.findViewById(2131302158)).setImageDrawable((Drawable)localObject1);
      return;
    }
    catch (MalformedURLException paramaawp)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.PhotoWall", 2, paramaawp.toString());
    }
  }
  
  public void c(aawp paramaawp, View paramView)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadBigImage() path = " + paramaawp.c);
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
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_thumb", null, paramaawp.b));
        localURL = new URL("profile_img_big_fhd", null, paramaawp.c);
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          if (i == 0) {
            break label164;
          }
          localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          paramView.setTag(paramaawp.c);
          paramaawp = (ImageView)paramView.findViewById(2131302158);
          if (paramaawp == null) {
            break;
          }
          paramaawp.setImageDrawable((Drawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException paramaawp)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.PhotoWall", 2, paramaawp.toString());
        }
        paramView.setTag(null);
        return;
      }
      i = 0;
    }
    label164:
    if (this.jdField_a_of_type_Aawn != null) {}
    for (Object localObject1 = this.jdField_a_of_type_Aawn.a();; localObject1 = null)
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
    if (this.jdField_a_of_type_Aawn != null) {
      return this.jdField_a_of_type_Aawn.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Aawn != null) {
      return this.jdField_a_of_type_Aawn.a(paramInt);
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
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493572, null);
      paramView = (ImageProgressCircle)paramViewGroup.findViewById(2131302255);
      paramView.setVisibility(4);
      localImageView = (ImageView)paramViewGroup.findViewById(2131302158);
      localImageView.setMinimumWidth(this.jdField_a_of_type_Int);
      localImageView.setMinimumHeight(this.jdField_a_of_type_Int);
      localObject = (aawp)getItem(paramInt);
      if (localObject != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label156;
        }
        localObject = this.jdField_a_of_type_Aawn.a.a(this.jdField_a_of_type_Aawn.b, (byte)1, false, false);
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = bacm.c();
        }
        localImageView.setImageDrawable(paramView);
      }
    }
    for (;;)
    {
      localObject = paramViewGroup;
      if (AppSetting.c)
      {
        localImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131625599));
        localObject = paramViewGroup;
      }
      return localObject;
      label156:
      if (((aawp)localObject).jdField_a_of_type_Int == 6)
      {
        c((aawp)localObject, paramViewGroup);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, paramInt + "," + ((aawp)localObject).c);
        }
      }
      else if ((((aawp)localObject).jdField_a_of_type_Int == 3) || (((aawp)localObject).jdField_a_of_type_Int == 4))
      {
        b((aawp)localObject, paramViewGroup);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, "thumb: " + paramInt + "," + ((aawp)localObject).b);
        }
        if (((aawp)localObject).jdField_a_of_type_Boolean) {
          a(paramView);
        }
      }
      else
      {
        localImageView.setImageResource(2130849385);
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
 * Qualified Name:     aiao
 * JD-Core Version:    0.7.0.1
 */