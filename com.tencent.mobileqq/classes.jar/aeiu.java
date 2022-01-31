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

public class aeiu
  extends AbstractImageAdapter
{
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private aeie jdField_a_of_type_Aeie;
  public aejd a;
  private Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  bfnk jdField_a_of_type_Bfnk = new bfnk(ThreadManager.getSubThreadLooper(), null);
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c = 0;
  
  public aeiu(Activity paramActivity, int paramInt, aeie paramaeie, aejd paramaejd, GridView paramGridView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aeie = paramaeie;
    paramaeie.d(4);
    this.jdField_a_of_type_Aejd = paramaejd;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_b_of_type_Int = actn.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
    if (!aeja.class.isInstance(localObject2))
    {
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] is not AIORichMediaInfo, position:" + paramInt);
      return;
    }
    if (!(localObject1 instanceof aeiv))
    {
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] is not ContentHolder, position:" + paramInt);
      return;
    }
    localObject1 = (aeiv)localObject1;
    aeja localaeja = (aeja)localObject2;
    URLImageView localURLImageView = ((aeiv)localObject1).jdField_a_of_type_ComTencentImageURLImageView;
    ImageView localImageView1 = ((aeiv)localObject1).jdField_a_of_type_AndroidWidgetImageView;
    ImageView localImageView2 = ((aeiv)localObject1).jdField_b_of_type_AndroidWidgetImageView;
    localObject2 = ((aeiv)localObject1).c;
    Object localObject3 = ((aeiv)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    TextView localTextView = ((aeiv)localObject1).jdField_b_of_type_AndroidWidgetTextView;
    Object localObject4 = ((aeiv)localObject1).jdField_a_of_type_AndroidViewView;
    ((View)localObject4).setVisibility(8);
    localTextView.setVisibility(8);
    localURLImageView.setBackgroundColor(0);
    File localFile = null;
    if (AIOImageData.class.isInstance(localaeja.a))
    {
      ((ImageView)localObject2).setVisibility(4);
      ((TextView)localObject3).setVisibility(4);
      localObject1 = (AIOImageData)localaeja.a;
      localFile = ((AIOImageData)localObject1).a(1);
      if (localFile != null)
      {
        localObject1 = localURLImageView.getDrawable();
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = aywk.b;
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
        label663:
        label813:
        label828:
        label1090:
        continue;
        label924:
        label1075:
        localObject1 = null;
      }
    }
    if (!((String)localObject1).equals(localObject4)) {
      localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject3));
    }
    if (AppSetting.d)
    {
      localObject1 = ajyc.a(2131700105);
      if (localObject1 != null)
      {
        i = paramInt / 4;
        paramView.setContentDescription(ajyc.a(2131700106) + (i + 1) + ajyc.a(2131700107) + (paramInt % 4 + 1) + (String)localObject1);
      }
      if (this.jdField_a_of_type_Boolean) {
        switch (localaeja.b())
        {
        default: 
          if (localImageView1 != null) {
            localImageView1.setVisibility(4);
          }
          if (localImageView2 != null) {
            localImageView2.setVisibility(4);
          }
          break;
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("AIOPhotoListAdapter", 2, "[updateView] cost: " + (SystemClock.uptimeMillis() - l) + " data" + localaeja.a);
        return;
        localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject3));
        break label324;
        if (((AIOImageData)localObject1).jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911);
          }
          localURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label324;
        }
        localURLImageView.setImageDrawable(aywk.b);
        this.jdField_a_of_type_Bfnk.post(new AIOPhotoListAdapter.1(this, (AIOImageData)localObject1));
        break label324;
        if (AIOShortVideoData.class.isInstance(localaeja.a))
        {
          ((View)localObject4).setVisibility(0);
          localObject4 = (AIOShortVideoData)localaeja.a;
          if (((AIOShortVideoData)localObject4).jdField_b_of_type_Int == 0)
          {
            ((ImageView)localObject2).setImageResource(2130839207);
            ((TextView)localObject3).setText(ShortVideoUtils.a(((AIOShortVideoData)localObject4).jdField_a_of_type_Int * 1000));
            ((TextView)localObject3).setVisibility(0);
            ((ImageView)localObject2).setVisibility(0);
            if (((AIOShortVideoData)localObject4).a(0) == null) {
              break label828;
            }
            localObject1 = ((AIOShortVideoData)localObject4).a(0);
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = localURLImageView.getDrawable();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aywk.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (!(localObject3 instanceof URLDrawable)) {
              break label813;
            }
            localObject3 = ((URLDrawable)localObject3).getURL().toString();
            if ((localObject1 != null) && (!((String)localObject1).equals(localObject3))) {
              localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.d) {
              break;
            }
            localObject1 = ajyc.a(2131700103);
            break;
            ((ImageView)localObject2).setImageResource(2130839075);
            ((aeiv)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
            break label663;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
            continue;
            if (!((AIOShortVideoData)localObject4).jdField_a_of_type_Boolean)
            {
              localURLImageView.setImageDrawable(aywk.b);
              this.jdField_a_of_type_Bfnk.post(new AIOPhotoListAdapter.2(this, (AIOShortVideoData)localObject4));
            }
          }
        }
        if (AIOFilePicData.class.isInstance(localaeja.a))
        {
          ((ImageView)localObject2).setVisibility(4);
          ((TextView)localObject3).setVisibility(4);
          localObject4 = (AIOFilePicData)localaeja.a;
          localObject2 = ((AIOFilePicData)localObject4).a(18);
          localObject1 = ((AIOFilePicData)localObject4).a(18);
          if (localObject2 != null)
          {
            if (localObject2 == null) {
              break label1090;
            }
            localObject2 = localURLImageView.getDrawable();
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = aywk.b;
            if (!(localObject2 instanceof URLDrawable)) {
              break label1075;
            }
            if (!((String)localObject1).equals(((URLDrawable)localObject2).getURL().toString())) {
              localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.d) {
              break;
            }
            localObject1 = ajyc.a(2131700099);
            break;
            localObject3 = ((AIOFilePicData)localObject4).a(16);
            localObject1 = ((AIOFilePicData)localObject4).a(16);
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label924;
            }
            localObject2 = ((AIOFilePicData)localObject4).a(20);
            localObject1 = ((AIOFilePicData)localObject4).a(20);
            break label924;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            continue;
            if (((AIOFilePicData)localObject4).c)
            {
              if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911);
              }
              localURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            }
            else
            {
              localURLImageView.setImageDrawable(aywk.b);
              if ((apee.a()) || (this.c != 2)) {
                this.jdField_a_of_type_Bfnk.post(new AIOPhotoListAdapter.3(this, (AIOFilePicData)localObject4));
              }
            }
          }
        }
        if (AIOFileVideoData.class.isInstance(localaeja.a))
        {
          localObject1 = (AIOFileVideoData)localaeja.a;
          ((View)localObject4).setVisibility(0);
          ((ImageView)localObject2).setImageResource(2130839207);
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
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = aywk.b;
            if ((localObject2 instanceof URLDrawable)) {
              if (!((String)localObject1).equals(((URLDrawable)localObject2).getURL().toString())) {
                localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
              }
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.d) {
              break;
            }
            localObject1 = ajyc.a(2131700102);
            break;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            continue;
            localURLImageView.setImageDrawable(null);
            localURLImageView.setBackgroundColor(Color.parseColor("#D8DAE0"));
          }
        }
        localObject1 = localFile;
        if (!AIOLightVideoData.class.isInstance(localaeja.a)) {
          break label337;
        }
        ((View)localObject4).setVisibility(0);
        localObject1 = (AIOLightVideoData)localaeja.a;
        ((ImageView)localObject2).setImageResource(2130839075);
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
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aywk.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
          if (!AppSetting.d) {
            break;
          }
          localObject1 = ajyc.a(2131700100);
          break;
          localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
          continue;
          localURLImageView.setImageDrawable(aywk.b);
          this.jdField_a_of_type_Bfnk.post(new AIOPhotoListAdapter.4(this, (AIOLightVideoData)localObject1));
        }
        if (localImageView1 != null) {
          localImageView1.setVisibility(0);
        }
        if (localImageView2 != null)
        {
          localImageView2.setImageResource(2130844861);
          localImageView2.setVisibility(0);
          continue;
          if (localImageView1 != null) {
            localImageView1.setVisibility(4);
          }
          if (localImageView2 != null)
          {
            localImageView2.setImageResource(2130844858);
            localImageView2.setVisibility(0);
            continue;
            if (localImageView1 != null) {
              localImageView1.setVisibility(4);
            }
            if (localImageView2 != null) {
              localImageView2.setVisibility(4);
            }
          }
        }
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
    int i = this.jdField_a_of_type_Aeie.g();
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
      return this.jdField_a_of_type_Aeie.a(paramInt);
    }
    if (paramInt < this.jdField_a_of_type_Aeie.g()) {
      return this.jdField_a_of_type_Aeie.a(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return jdField_a_of_type_JavaLangObject;
    }
    return aeie.b;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof aeja)) {}
    do
    {
      return 0;
      if (aeie.b.equals(localObject)) {
        return 1;
      }
      if ((localObject instanceof String)) {
        return 2;
      }
      if (aeie.jdField_a_of_type_JavaLangObject.equals(localObject)) {
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
        if (aeiv.class.isInstance(paramViewGroup)) {
          break label48;
        }
        if ((QLog.isColorLevel()) && (paramView != null))
        {
          paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
          QLog.d("AIOPhotoListAdapter", 2, "[getView] type 0 while convertView type " + paramView.jdField_a_of_type_Int);
        }
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560956, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        localObject1 = new aeiv(this);
        ((aeiv)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131371559));
        ((aeiv)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
        ((aeiv)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368351));
        ((aeiv)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371564));
        ((aeiv)localObject1).c = ((ImageView)paramView.findViewById(2131371491));
        ((aeiv)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379012));
        ((aeiv)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366249));
        ((aeiv)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363374);
        paramView.setTag(localObject1);
        break label48;
        if (aeie.b.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        paramView.setTag(aeie.b);
        break label48;
        if (aeix.class.isInstance(paramViewGroup)) {
          break label48;
        }
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560948, null);
        paramViewGroup = new aeix(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131377188));
        paramView = new aeiw(this, this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((View)localObject1).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
          paramView.setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
        }
        ((FrameLayout)paramView).addView((View)localObject1);
        paramView.setTag(paramViewGroup);
        break label48;
        if (aeie.jdField_a_of_type_JavaLangObject.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setMinimumHeight(this.jdField_b_of_type_Int);
        paramView.setVisibility(4);
        paramView.setTag(aeie.jdField_a_of_type_JavaLangObject);
        break label48;
        if (jdField_a_of_type_JavaLangObject.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new aeiw(this, this.jdField_a_of_type_AndroidContentContext);
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560947, null);
        localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramView.addView((View)localObject1);
        paramView.setTag(jdField_a_of_type_JavaLangObject);
        break label48;
        a(paramInt, paramView);
        return paramView;
      } while (!aeix.class.isInstance(paramViewGroup));
      paramViewGroup = (aeix)paramViewGroup;
      localObject1 = (String)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    } while (!AppSetting.d);
    paramInt /= 4;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajyc.a(2131700101) + (paramInt + 1) + ajyc.a(2131700104) + (String)localObject1);
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
 * Qualified Name:     aeiu
 * JD-Core Version:    0.7.0.1
 */