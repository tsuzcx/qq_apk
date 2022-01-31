import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.1;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.2;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.3;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.4;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class adxv
  extends AbstractImageAdapter
{
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private adxf jdField_a_of_type_Adxf;
  public adye a;
  private Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  befq jdField_a_of_type_Befq = new befq(ThreadManager.getSubThreadLooper(), null);
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c = 0;
  
  public adxv(Activity paramActivity, int paramInt, adxf paramadxf, adye paramadye, GridView paramGridView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Adxf = paramadxf;
    paramadxf.d(4);
    this.jdField_a_of_type_Adye = paramadye;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_b_of_type_Int = aciy.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt, View paramView)
  {
    long l = SystemClock.uptimeMillis();
    Object localObject2 = getItem(paramInt);
    localObject1 = paramView.getTag();
    if (!adyb.class.isInstance(localObject2))
    {
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] is not AIORichMediaInfo, position:" + paramInt);
      return;
    }
    if (!(localObject1 instanceof adxw))
    {
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] is not ContentHolder, position:" + paramInt);
      return;
    }
    localObject1 = (adxw)localObject1;
    adyb localadyb = (adyb)localObject2;
    URLImageView localURLImageView = ((adxw)localObject1).jdField_a_of_type_ComTencentImageURLImageView;
    ImageView localImageView1 = ((adxw)localObject1).jdField_a_of_type_AndroidWidgetImageView;
    ImageView localImageView2 = ((adxw)localObject1).jdField_b_of_type_AndroidWidgetImageView;
    localObject2 = ((adxw)localObject1).c;
    Object localObject3 = ((adxw)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    TextView localTextView = ((adxw)localObject1).jdField_b_of_type_AndroidWidgetTextView;
    Object localObject4 = ((adxw)localObject1).jdField_a_of_type_AndroidViewView;
    ((View)localObject4).setVisibility(8);
    localTextView.setVisibility(8);
    localURLImageView.setBackgroundColor(0);
    File localFile = null;
    if (AIOImageData.class.isInstance(localadyb.a))
    {
      ((ImageView)localObject2).setVisibility(4);
      ((TextView)localObject3).setVisibility(4);
      localObject1 = (AIOImageData)localadyb.a;
      localFile = ((AIOImageData)localObject1).a(1);
      if (localFile != null)
      {
        localObject1 = localURLImageView.getDrawable();
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = axwd.b;
        if ((localObject1 instanceof URLDrawable))
        {
          localObject4 = ((URLDrawable)localObject1).getURL().toString();
          localObject1 = "";
        }
      }
    }
    try
    {
      localObject2 = localFile.toURI().toURL().toString();
      localObject1 = localObject2;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        label324:
        label337:
        int i;
        label653:
        label803:
        label818:
        label1080:
        continue;
        label914:
        label1065:
        localObject1 = null;
      }
    }
    if (!((String)localObject1).equals(localObject4)) {
      localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject3));
    }
    if (AppSetting.c)
    {
      localObject1 = ajjy.a(2131634317);
      if (localObject1 != null)
      {
        i = paramInt / 4;
        paramView.setContentDescription(ajjy.a(2131634318) + (i + 1) + ajjy.a(2131634319) + (paramInt % 4 + 1) + (String)localObject1);
      }
      if (this.jdField_a_of_type_Boolean) {
        switch (localadyb.b())
        {
        default: 
          localImageView1.setVisibility(4);
          localImageView2.setVisibility(4);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("AIOPhotoListAdapter", 2, "[updateView] cost: " + (SystemClock.uptimeMillis() - l) + " data" + localadyb.a);
        return;
        localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject3));
        break label324;
        if (((AIOImageData)localObject1).jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837854);
          }
          localURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label324;
        }
        localURLImageView.setImageDrawable(axwd.b);
        this.jdField_a_of_type_Befq.post(new AIOPhotoListAdapter.1(this, (AIOImageData)localObject1));
        break label324;
        if (AIOShortVideoData.class.isInstance(localadyb.a))
        {
          ((View)localObject4).setVisibility(0);
          localObject4 = (AIOShortVideoData)localadyb.a;
          if (((AIOShortVideoData)localObject4).jdField_b_of_type_Int == 0)
          {
            ((ImageView)localObject2).setImageResource(2130839182);
            ((TextView)localObject3).setText(ShortVideoUtils.a(((AIOShortVideoData)localObject4).jdField_a_of_type_Int * 1000));
            ((TextView)localObject3).setVisibility(0);
            ((ImageView)localObject2).setVisibility(0);
            if (((AIOShortVideoData)localObject4).a(0) == null) {
              break label818;
            }
            localObject1 = ((AIOShortVideoData)localObject4).a(0);
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = localURLImageView.getDrawable();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = axwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (!(localObject3 instanceof URLDrawable)) {
              break label803;
            }
            localObject3 = ((URLDrawable)localObject3).getURL().toString();
            if ((localObject1 != null) && (!((String)localObject1).equals(localObject3))) {
              localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.c) {
              break;
            }
            localObject1 = ajjy.a(2131634315);
            break;
            ((ImageView)localObject2).setImageResource(2130839047);
            ((adxw)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
            break label653;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
            continue;
            if (!((AIOShortVideoData)localObject4).jdField_a_of_type_Boolean)
            {
              localURLImageView.setImageDrawable(axwd.b);
              this.jdField_a_of_type_Befq.post(new AIOPhotoListAdapter.2(this, (AIOShortVideoData)localObject4));
            }
          }
        }
        if (AIOFilePicData.class.isInstance(localadyb.a))
        {
          ((ImageView)localObject2).setVisibility(4);
          ((TextView)localObject3).setVisibility(4);
          localObject4 = (AIOFilePicData)localadyb.a;
          localObject2 = ((AIOFilePicData)localObject4).a(18);
          localObject1 = ((AIOFilePicData)localObject4).a(18);
          if (localObject2 != null)
          {
            if (localObject2 == null) {
              break label1080;
            }
            localObject2 = localURLImageView.getDrawable();
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = axwd.b;
            if (!(localObject2 instanceof URLDrawable)) {
              break label1065;
            }
            if (!((String)localObject1).equals(((URLDrawable)localObject2).getURL().toString())) {
              localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.c) {
              break;
            }
            localObject1 = ajjy.a(2131634311);
            break;
            localObject3 = ((AIOFilePicData)localObject4).a(16);
            localObject1 = ((AIOFilePicData)localObject4).a(16);
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label914;
            }
            localObject2 = ((AIOFilePicData)localObject4).a(20);
            localObject1 = ((AIOFilePicData)localObject4).a(20);
            break label914;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            continue;
            if (((AIOFilePicData)localObject4).c)
            {
              if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837854);
              }
              localURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            }
            else
            {
              localURLImageView.setImageDrawable(axwd.b);
              if ((aonj.a()) || (this.c != 2)) {
                this.jdField_a_of_type_Befq.post(new AIOPhotoListAdapter.3(this, (AIOFilePicData)localObject4));
              }
            }
          }
        }
        if (AIOFileVideoData.class.isInstance(localadyb.a))
        {
          localObject1 = (AIOFileVideoData)localadyb.a;
          ((View)localObject4).setVisibility(0);
          ((ImageView)localObject2).setImageResource(2130839182);
          ((ImageView)localObject2).setVisibility(0);
          ((TextView)localObject3).setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, ((AIOFileVideoData)localObject1).h));
          ((TextView)localObject3).setVisibility(0);
          float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
          float f2 = this.jdField_a_of_type_Int * 2;
          localTextView.setText((String)TextUtils.ellipsize(((AIOFileVideoData)localObject1).a, localTextView.getPaint(), f2 - f1 * 4.0F * 8.0F, TextUtils.TruncateAt.END));
          localTextView.setVisibility(0);
          if (((AIOFileVideoData)localObject1).a(0) != null)
          {
            localObject1 = ((AIOFileVideoData)localObject1).a(16);
            localObject2 = localURLImageView.getDrawable();
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = axwd.b;
            if ((localObject2 instanceof URLDrawable)) {
              if (!((String)localObject1).equals(((URLDrawable)localObject2).getURL().toString())) {
                localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
              }
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.c) {
              break;
            }
            localObject1 = ajjy.a(2131634314);
            break;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            continue;
            localURLImageView.setImageDrawable(null);
            localURLImageView.setBackgroundColor(Color.parseColor("#D8DAE0"));
          }
        }
        localObject1 = localFile;
        if (!AIOLightVideoData.class.isInstance(localadyb.a)) {
          break label337;
        }
        ((View)localObject4).setVisibility(0);
        localObject1 = (AIOLightVideoData)localadyb.a;
        ((ImageView)localObject2).setImageResource(2130839047);
        ((TextView)localObject3).setText(ShortVideoUtils.a(((AIOLightVideoData)localObject1).jdField_a_of_type_Int * 1000));
        ((TextView)localObject3).setVisibility(0);
        ((ImageView)localObject2).setVisibility(0);
        if (((AIOLightVideoData)localObject1).a(0) != null)
        {
          localObject1 = ((AIOLightVideoData)localObject1).a(0);
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = localURLImageView.getDrawable();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = axwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          if ((localObject3 instanceof URLDrawable))
          {
            localObject3 = ((URLDrawable)localObject3).getURL().toString();
            if ((localObject1 != null) && (!((String)localObject1).equals(localObject3))) {
              localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
            }
          }
        }
        for (;;)
        {
          localObject1 = localFile;
          if (!AppSetting.c) {
            break;
          }
          localObject1 = ajjy.a(2131634312);
          break;
          localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
          continue;
          localURLImageView.setImageDrawable(axwd.b);
          this.jdField_a_of_type_Befq.post(new AIOPhotoListAdapter.4(this, (AIOLightVideoData)localObject1));
        }
        localImageView1.setVisibility(0);
        localImageView2.setImageResource(2130844780);
        localImageView2.setVisibility(0);
        continue;
        localImageView1.setVisibility(4);
        localImageView2.setImageResource(2130844778);
        localImageView2.setVisibility(0);
        continue;
        localImageView1.setVisibility(4);
        localImageView2.setVisibility(4);
      }
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_Adxf.g();
    int j = i;
    if (this.jdField_b_of_type_Boolean)
    {
      int k = i % 4;
      j = i;
      if (k > 0) {
        j = i + (4 - k);
      }
      j += 1;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_Adxf.a(paramInt);
    }
    if (paramInt < this.jdField_a_of_type_Adxf.g()) {
      return this.jdField_a_of_type_Adxf.a(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return jdField_a_of_type_JavaLangObject;
    }
    return adxf.b;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof adyb)) {}
    do
    {
      return 0;
      if (adxf.b.equals(localObject)) {
        return 1;
      }
      if ((localObject instanceof String)) {
        return 2;
      }
      if (adxf.jdField_a_of_type_JavaLangObject.equals(localObject)) {
        return 3;
      }
    } while (!jdField_a_of_type_JavaLangObject.equals(localObject));
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
    {
      paramViewGroup = null;
      switch (i)
      {
      default: 
        label48:
        switch (i)
        {
        }
        break;
      }
    }
    Object localObject1;
    do
    {
      do
      {
        return paramView;
        paramViewGroup = paramView.getTag();
        break;
        if (adxw.class.isInstance(paramViewGroup)) {
          break label48;
        }
        if ((QLog.isColorLevel()) && (paramView != null))
        {
          paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
          QLog.d("AIOPhotoListAdapter", 2, "[getView] type 0 while convertView type " + paramView.jdField_a_of_type_Int);
        }
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495377, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        localObject1 = new adxw(this);
        ((adxw)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131305863));
        ((adxw)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
        ((adxw)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131305867));
        ((adxw)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131305868));
        ((adxw)localObject1).c = ((ImageView)paramView.findViewById(2131305771));
        ((adxw)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131313177));
        ((adxw)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300647));
        ((adxw)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131297828);
        paramView.setTag(localObject1);
        break label48;
        if (adxf.b.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        paramView.setTag(adxf.b);
        break label48;
        if (adxy.class.isInstance(paramViewGroup)) {
          break label48;
        }
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495369, null);
        paramViewGroup = new adxy(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131311377));
        paramView = new adxx(this, this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((View)localObject1).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
          paramView.setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
        }
        ((FrameLayout)paramView).addView((View)localObject1);
        paramView.setTag(paramViewGroup);
        break label48;
        if (adxf.jdField_a_of_type_JavaLangObject.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setMinimumHeight(this.jdField_b_of_type_Int);
        paramView.setVisibility(4);
        paramView.setTag(adxf.jdField_a_of_type_JavaLangObject);
        break label48;
        if (jdField_a_of_type_JavaLangObject.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new adxx(this, this.jdField_a_of_type_AndroidContentContext);
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495368, null);
        localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramView.addView((View)localObject1);
        paramView.setTag(jdField_a_of_type_JavaLangObject);
        break label48;
        a(paramInt, paramView);
        return paramView;
      } while (!adxy.class.isInstance(paramViewGroup));
      paramViewGroup = (adxy)paramViewGroup;
      localObject1 = (String)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    } while (!AppSetting.c);
    paramInt /= 4;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131634313) + (paramInt + 1) + ajjy.a(2131634316) + (String)localObject1);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return getItemViewType(paramInt) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxv
 * JD-Core Version:    0.7.0.1
 */