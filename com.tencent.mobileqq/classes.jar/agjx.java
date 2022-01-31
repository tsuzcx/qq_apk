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
import android.widget.CheckBox;
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
import com.tencent.mobileqq.activity.ChatActivityUtils;
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

public class agjx
  extends AbstractImageAdapter
{
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private agjh jdField_a_of_type_Agjh;
  public agki a;
  private Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  bhtd jdField_a_of_type_Bhtd = new bhtd(ThreadManager.getSubThreadLooper(), null);
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private int d = -1;
  private int e = -1;
  
  public agjx(Activity paramActivity, int paramInt, agjh paramagjh, agki paramagki, GridView paramGridView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Agjh = paramagjh;
    paramagjh.d(4);
    this.jdField_a_of_type_Agki = paramagki;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_b_of_type_Int = aepi.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != -1) {}
    switch (Integer.valueOf(ChatActivityUtils.b(paramInt)).intValue())
    {
    case 1: 
    case 2: 
    default: 
      return -1;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agjh == null) {}
    while (!this.jdField_a_of_type_Agjh.a()) {
      return;
    }
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.e = a(this.d);
  }
  
  public void a(int paramInt, View paramView)
  {
    long l = SystemClock.uptimeMillis();
    Object localObject2 = getItem(paramInt);
    localObject1 = paramView.getTag();
    if (!agkf.class.isInstance(localObject2))
    {
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] is not AIORichMediaInfo, position:" + paramInt);
      return;
    }
    if (!(localObject1 instanceof agjz))
    {
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] is not ContentHolder, position:" + paramInt);
      return;
    }
    localObject1 = (agjz)localObject1;
    agkf localagkf = (agkf)localObject2;
    URLImageView localURLImageView = ((agjz)localObject1).jdField_a_of_type_ComTencentImageURLImageView;
    ImageView localImageView1 = ((agjz)localObject1).jdField_a_of_type_AndroidWidgetImageView;
    ImageView localImageView2 = ((agjz)localObject1).jdField_b_of_type_AndroidWidgetImageView;
    localObject2 = ((agjz)localObject1).c;
    Object localObject3 = ((agjz)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    TextView localTextView = ((agjz)localObject1).jdField_b_of_type_AndroidWidgetTextView;
    Object localObject4 = ((agjz)localObject1).jdField_a_of_type_AndroidViewView;
    ((View)localObject4).setVisibility(8);
    localTextView.setVisibility(8);
    localURLImageView.setBackgroundColor(0);
    File localFile = null;
    if (AIOImageData.class.isInstance(localagkf.a))
    {
      ((ImageView)localObject2).setVisibility(4);
      ((TextView)localObject3).setVisibility(4);
      localObject1 = (AIOImageData)localagkf.a;
      localFile = ((AIOImageData)localObject1).a(1);
      if (localFile != null)
      {
        localObject1 = localURLImageView.getDrawable();
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = bayu.b;
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
        label338:
        int i;
        label667:
        label817:
        label832:
        label1094:
        continue;
        label928:
        label1079:
        localObject1 = null;
      }
    }
    if (!((String)localObject1).equals(localObject4)) {
      localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject3));
    }
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      localObject1 = alud.a(2131700497);
      if (localObject1 != null)
      {
        i = paramInt / 4;
        paramView.setContentDescription(alud.a(2131700498) + (i + 1) + alud.a(2131700499) + (paramInt % 4 + 1) + (String)localObject1);
      }
      if (this.jdField_a_of_type_Boolean) {
        switch (localagkf.b())
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
        QLog.d("AIOPhotoListAdapter", 2, "[updateView] cost: " + (SystemClock.uptimeMillis() - l) + " data" + localagkf.a);
        return;
        localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject3));
        break label324;
        if (((AIOImageData)localObject1).jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837968);
          }
          localURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label324;
        }
        localURLImageView.setImageDrawable(bayu.b);
        this.jdField_a_of_type_Bhtd.post(new AIOPhotoListAdapter.1(this, (AIOImageData)localObject1));
        break label324;
        if (AIOShortVideoData.class.isInstance(localagkf.a))
        {
          ((View)localObject4).setVisibility(0);
          localObject4 = (AIOShortVideoData)localagkf.a;
          if (((AIOShortVideoData)localObject4).jdField_b_of_type_Int == 0)
          {
            ((ImageView)localObject2).setImageResource(2130839297);
            ((TextView)localObject3).setText(ShortVideoUtils.a(((AIOShortVideoData)localObject4).jdField_a_of_type_Int * 1000));
            ((TextView)localObject3).setVisibility(0);
            ((ImageView)localObject2).setVisibility(0);
            if (((AIOShortVideoData)localObject4).a(0) == null) {
              break label832;
            }
            localObject1 = ((AIOShortVideoData)localObject4).a(0);
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = localURLImageView.getDrawable();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = bayu.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (!(localObject3 instanceof URLDrawable)) {
              break label817;
            }
            localObject3 = ((URLDrawable)localObject3).getURL().toString();
            if ((localObject1 != null) && (!((String)localObject1).equals(localObject3))) {
              localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.jdField_c_of_type_Boolean) {
              break;
            }
            localObject1 = alud.a(2131700495);
            break;
            ((ImageView)localObject2).setImageResource(2130839157);
            ((agjz)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
            break label667;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
            continue;
            if (!((AIOShortVideoData)localObject4).jdField_a_of_type_Boolean)
            {
              localURLImageView.setImageDrawable(bayu.b);
              this.jdField_a_of_type_Bhtd.post(new AIOPhotoListAdapter.2(this, (AIOShortVideoData)localObject4));
            }
          }
        }
        if (AIOFilePicData.class.isInstance(localagkf.a))
        {
          ((ImageView)localObject2).setVisibility(4);
          ((TextView)localObject3).setVisibility(4);
          localObject4 = (AIOFilePicData)localagkf.a;
          localObject2 = ((AIOFilePicData)localObject4).a(18);
          localObject1 = ((AIOFilePicData)localObject4).a(18);
          if (localObject2 != null)
          {
            if (localObject2 == null) {
              break label1094;
            }
            localObject2 = localURLImageView.getDrawable();
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = bayu.b;
            if (!(localObject2 instanceof URLDrawable)) {
              break label1079;
            }
            if (!((String)localObject1).equals(((URLDrawable)localObject2).getURL().toString())) {
              localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.jdField_c_of_type_Boolean) {
              break;
            }
            localObject1 = alud.a(2131700491);
            break;
            localObject3 = ((AIOFilePicData)localObject4).a(16);
            localObject1 = ((AIOFilePicData)localObject4).a(16);
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label928;
            }
            localObject2 = ((AIOFilePicData)localObject4).a(20);
            localObject1 = ((AIOFilePicData)localObject4).a(20);
            break label928;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            continue;
            if (((AIOFilePicData)localObject4).jdField_c_of_type_Boolean)
            {
              if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837968);
              }
              localURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            }
            else
            {
              localURLImageView.setImageDrawable(bayu.b);
              if ((arbp.a()) || (this.jdField_c_of_type_Int != 2)) {
                this.jdField_a_of_type_Bhtd.post(new AIOPhotoListAdapter.3(this, (AIOFilePicData)localObject4));
              }
            }
          }
        }
        if (AIOFileVideoData.class.isInstance(localagkf.a))
        {
          localObject1 = (AIOFileVideoData)localagkf.a;
          ((View)localObject4).setVisibility(0);
          ((ImageView)localObject2).setImageResource(2130839297);
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
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = bayu.b;
            if ((localObject2 instanceof URLDrawable)) {
              if (!((String)localObject1).equals(((URLDrawable)localObject2).getURL().toString())) {
                localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
              }
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.jdField_c_of_type_Boolean) {
              break;
            }
            localObject1 = alud.a(2131700494);
            break;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            continue;
            localURLImageView.setImageDrawable(null);
            localURLImageView.setBackgroundColor(Color.parseColor("#D8DAE0"));
          }
        }
        localObject1 = localFile;
        if (!AIOLightVideoData.class.isInstance(localagkf.a)) {
          break label338;
        }
        ((View)localObject4).setVisibility(0);
        localObject1 = (AIOLightVideoData)localagkf.a;
        ((ImageView)localObject2).setImageResource(2130839157);
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
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = bayu.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
          if (!AppSetting.jdField_c_of_type_Boolean) {
            break;
          }
          localObject1 = alud.a(2131700492);
          break;
          localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
          continue;
          localURLImageView.setImageDrawable(bayu.b);
          this.jdField_a_of_type_Bhtd.post(new AIOPhotoListAdapter.4(this, (AIOLightVideoData)localObject1));
        }
        if (localImageView1 != null) {
          localImageView1.setVisibility(0);
        }
        if (localImageView2 != null)
        {
          localImageView2.setImageResource(2130845298);
          localImageView2.setVisibility(0);
          continue;
          if (localImageView1 != null) {
            localImageView1.setVisibility(4);
          }
          if (localImageView2 != null)
          {
            localImageView2.setImageResource(2130845295);
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
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Boolean) && (this.e != -1);
  }
  
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
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_Agjh.g();
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
      return this.jdField_a_of_type_Agjh.a(paramInt);
    }
    if (paramInt < this.jdField_a_of_type_Agjh.g()) {
      return this.jdField_a_of_type_Agjh.a(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return jdField_a_of_type_JavaLangObject;
    }
    return agjh.b;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof agkf)) {}
    do
    {
      return 0;
      if (agjh.b.equals(localObject)) {
        return 1;
      }
      if ((localObject instanceof String)) {
        return 2;
      }
      if (agjh.jdField_a_of_type_JavaLangObject.equals(localObject)) {
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
        if (agjz.class.isInstance(paramViewGroup)) {
          break label48;
        }
        if ((QLog.isColorLevel()) && (paramView != null))
        {
          paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
          QLog.d("AIOPhotoListAdapter", 2, "[getView] type 0 while convertView type " + paramView.jdField_a_of_type_Int);
        }
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561156, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        localObject1 = new agjz(this);
        ((agjz)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131371896));
        ((agjz)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
        ((agjz)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368534));
        ((agjz)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371901));
        ((agjz)localObject1).c = ((ImageView)paramView.findViewById(2131371827));
        ((agjz)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379740));
        ((agjz)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366339));
        ((agjz)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363412);
        paramView.setTag(localObject1);
        break label48;
        if (agjh.b.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        paramView.setTag(agjh.b);
        break label48;
        if (agkb.class.isInstance(paramViewGroup)) {
          break label48;
        }
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561148, null);
        paramViewGroup = new agkb(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131377765));
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((View)localObject1).findViewById(2131368775));
        paramView = new agka(this, this.jdField_a_of_type_AndroidContentContext);
        localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((View)localObject1).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
          paramView.setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
        }
        ((FrameLayout)paramView).addView((View)localObject1);
        paramView.setTag(paramViewGroup);
        break label48;
        if (agjh.jdField_a_of_type_JavaLangObject.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setMinimumHeight(this.jdField_b_of_type_Int);
        paramView.setVisibility(4);
        paramView.setTag(agjh.jdField_a_of_type_JavaLangObject);
        break label48;
        if (jdField_a_of_type_JavaLangObject.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new agka(this, this.jdField_a_of_type_AndroidContentContext);
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561147, null);
        localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramView.addView((View)localObject1);
        paramView.setTag(jdField_a_of_type_JavaLangObject);
        break label48;
        a(paramInt, paramView);
        return paramView;
      } while (!agkb.class.isInstance(paramViewGroup));
      paramViewGroup = (agkb)paramViewGroup;
      localObject1 = (String)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        paramInt /= 4;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131700493) + (paramInt + 1) + alud.a(2131700496) + (String)localObject1);
      }
    } while (!a());
    Object localObject2 = (ViewGroup)paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.getParent();
    if (localObject2 != null) {
      ((ViewGroup)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839212));
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Agjh.jdField_a_of_type_Agkd.a((String)localObject1));
    paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setClickable(false);
    paramView.setOnClickListener(new agjy(this, (String)localObject1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjx
 * JD-Core Version:    0.7.0.1
 */