import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class alts
  implements altt
{
  protected int a(ColorNote paramColorNote)
  {
    switch (alsr.a(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      return 2130843465;
    case 16973824: 
      return 2130843410;
    case 17039360: 
      return 2130838943;
    case 16842752: 
      return 2130838944;
    case 16908288: 
      return 2130838945;
    }
    return 2130843256;
  }
  
  public int a(ColorNote paramColorNote, boolean paramBoolean)
  {
    int i;
    switch (paramColorNote.getServiceType() & 0xFFFF0000)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (alsr.b(paramColorNote))
      {
        if (!paramBoolean) {
          break;
        }
        i = 2130838960;
      }
      return i;
      if (paramBoolean)
      {
        i = 2130838955;
      }
      else
      {
        i = 2130838956;
        continue;
        if (paramBoolean)
        {
          i = 2130838949;
        }
        else
        {
          i = 2130838950;
          continue;
          if (paramBoolean)
          {
            i = 2130838952;
          }
          else
          {
            i = 2130838953;
            continue;
            if (paramBoolean) {
              i = 2130838958;
            } else {
              i = 2130838959;
            }
          }
        }
      }
    }
    return 2130838961;
  }
  
  public void a(alti paramalti, int paramInt, boolean paramBoolean)
  {
    ColorNote localColorNote = paramalti.a(paramInt);
    localResources = paramalti.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources();
    paramInt = a(localColorNote);
    for (;;)
    {
      try
      {
        localObject1 = new URL(localColorNote.getPicUrl());
        bool = "resdrawable".equals(((URL)localObject1).getProtocol());
        if (!bool) {
          continue;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject1;
        boolean bool;
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        localObject2 = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, localMalformedURLException, new Object[0]);
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        Object localObject2 = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, localNullPointerException, new Object[0]);
        continue;
        paramalti.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramalti.jdField_a_of_type_Alsg, null);
        paramalti.jdField_a_of_type_Alsg.a(300);
        localObject2 = paramalti.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130838955;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramalti.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838964);
        continue;
        paramInt = 2130838956;
        continue;
        paramalti.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramalti.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130838949;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramalti.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838962);
        continue;
        paramInt = 2130838950;
        continue;
        paramalti.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramalti.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130838952;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramalti.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838963);
        continue;
        paramInt = 2130838953;
        continue;
        paramalti.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramalti.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130838958;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramalti.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838965);
        continue;
        paramInt = 2130838959;
        continue;
        paramInt = 2130838961;
        continue;
      }
      try
      {
        localObject1 = localResources.getDrawable(Integer.parseInt(((URL)localObject1).getHost()));
        paramalti.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        bool = alsr.b(localColorNote);
        switch (alsr.a(localColorNote.getServiceType() & 0xFFFF0000))
        {
        default: 
          paramalti.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          if (bool)
          {
            localObject1 = paramalti.jdField_a_of_type_AndroidViewView;
            if (!paramBoolean) {
              continue;
            }
            paramInt = 2130838960;
            ((View)localObject1).setBackgroundResource(paramInt);
          }
          paramalti.jdField_a_of_type_AndroidWidgetTextView.setText(localColorNote.getMainTitle());
          paramalti.jdField_b_of_type_AndroidWidgetTextView.setText(localColorNote.getSubTitle());
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject2 = localResources.getDrawable(paramInt);
        continue;
      }
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = aciy.a(40.0F, localResources);
      localURLDrawableOptions.mRequestHeight = aciy.a(40.0F, localResources);
      localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(paramInt);
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
    }
  }
  
  public void a(ColorNote paramColorNote, View paramView, ImageView paramImageView, boolean paramBoolean)
  {
    i = a(paramColorNote, paramBoolean);
    if (i != 0) {
      paramView.setBackgroundResource(i);
    }
    paramView = paramView.getContext().getResources();
    i = a(paramColorNote);
    for (;;)
    {
      try
      {
        paramColorNote = new URL(paramColorNote.getPicUrl());
        paramBoolean = "resdrawable".equals(paramColorNote.getProtocol());
        if (!paramBoolean) {
          continue;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        paramColorNote = paramView.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, localMalformedURLException, new Object[0]);
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        paramColorNote = paramView.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, localNullPointerException, new Object[0]);
        continue;
      }
      try
      {
        paramColorNote = paramView.getDrawable(Integer.parseInt(paramColorNote.getHost()));
        paramImageView.setImageDrawable(paramColorNote);
        return;
      }
      catch (NumberFormatException paramColorNote)
      {
        paramColorNote = paramView.getDrawable(i);
        continue;
      }
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = aciy.a(40.0F, paramView);
      localURLDrawableOptions.mRequestHeight = aciy.a(40.0F, paramView);
      localURLDrawableOptions.mLoadingDrawable = paramView.getDrawable(i);
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      paramColorNote = URLDrawable.getDrawable(paramColorNote, localURLDrawableOptions);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alts
 * JD-Core Version:    0.7.0.1
 */