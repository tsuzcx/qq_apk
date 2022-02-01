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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class aido
  extends AbstractImageAdapter
{
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private aicx jdField_a_of_type_Aicx;
  public aidz a;
  private Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  blhq jdField_a_of_type_Blhq = new blhq(ThreadManager.getSubThreadLooper(), null);
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private int d = -1;
  private int e = -1;
  
  public aido(Activity paramActivity, int paramInt, aicx paramaicx, aidz paramaidz, GridView paramGridView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aicx = paramaicx;
    paramaicx.d(4);
    this.jdField_a_of_type_Aidz = paramaidz;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_b_of_type_Int = agej.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  private void a(int paramInt1, int paramInt2, View paramView, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    String str;
    do
    {
      do
      {
        return;
        a(paramInt2, paramView);
        return;
      } while (!aids.class.isInstance(paramObject));
      paramObject = (aids)paramObject;
      str = (String)getItem(paramInt2);
      paramObject.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        paramInt1 = paramInt2 / 4;
        paramObject.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131699026) + (paramInt1 + 1) + anzj.a(2131699029) + str);
      }
    } while (!a());
    ViewGroup localViewGroup = (ViewGroup)paramObject.jdField_a_of_type_AndroidWidgetCheckBox.getParent();
    if (localViewGroup != null) {
      localViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839397));
    }
    paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Aicx.jdField_a_of_type_Aidu.a(str));
    paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setClickable(false);
    paramView.setOnClickListener(new aidp(this, str));
  }
  
  private void a(aidw paramaidw, ImageView paramImageView1, ImageView paramImageView2)
  {
    if (this.jdField_a_of_type_Boolean) {
      switch (paramaidw.b())
      {
      default: 
        if (paramImageView1 != null) {
          paramImageView1.setVisibility(4);
        }
        if (paramImageView2 != null) {
          paramImageView2.setVisibility(4);
        }
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramImageView1 != null) {
            paramImageView1.setVisibility(0);
          }
        } while (paramImageView2 == null);
        paramImageView2.setImageResource(2130845709);
        paramImageView2.setVisibility(0);
        return;
        if (paramImageView1 != null) {
          paramImageView1.setVisibility(4);
        }
      } while (paramImageView2 == null);
      paramImageView2.setImageResource(2130845706);
      paramImageView2.setVisibility(0);
      return;
      if (paramImageView1 != null) {
        paramImageView1.setVisibility(4);
      }
    } while (paramImageView2 == null);
    paramImageView2.setVisibility(4);
  }
  
  private void a(aidw paramaidw, ImageView paramImageView, TextView paramTextView, URLImageView paramURLImageView)
  {
    paramImageView.setVisibility(4);
    paramTextView.setVisibility(4);
    paramaidw = (AIOImageData)paramaidw.a;
    paramTextView = paramaidw.a(1);
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    String str;
    if (paramTextView != null)
    {
      paramaidw = paramURLImageView.getDrawable();
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_Int;
      localURLDrawableOptions.mLoadingDrawable = beyq.b;
      if ((paramaidw instanceof URLDrawable))
      {
        str = ((URLDrawable)paramaidw).getURL().toString();
        paramaidw = "";
      }
    }
    try
    {
      paramImageView = paramTextView.toURI().toURL().toString();
      paramaidw = paramImageView;
    }
    catch (MalformedURLException paramImageView)
    {
      label101:
      break label101;
    }
    if (!paramaidw.equals(str)) {
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramTextView, localURLDrawableOptions));
    }
    return;
    paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramTextView, localURLDrawableOptions));
    return;
    if (paramaidw.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838072);
      }
      paramURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramURLImageView.setImageDrawable(beyq.b);
    this.jdField_a_of_type_Blhq.post(new AIOPhotoListAdapter.1(this, paramaidw));
  }
  
  private void a(View paramView, aidw paramaidw, ImageView paramImageView, TextView paramTextView, URLImageView paramURLImageView, aidq paramaidq)
  {
    paramView.setVisibility(0);
    paramView = (AIOShortVideoData)paramaidw.a;
    if (paramView.jdField_b_of_type_Int == 0)
    {
      paramImageView.setImageResource(2130839483);
      paramTextView.setText(ShortVideoUtils.a(paramView.jdField_a_of_type_Int * 1000));
      paramTextView.setVisibility(0);
      paramImageView.setVisibility(0);
      if (paramView.a(0) == null) {
        break label173;
      }
      paramView = paramView.a(0);
      paramaidw = URLDrawable.URLDrawableOptions.obtain();
      paramImageView = paramURLImageView.getDrawable();
      paramaidw.mRequestWidth = this.jdField_a_of_type_Int;
      paramaidw.mRequestHeight = this.jdField_a_of_type_Int;
      paramaidw.mLoadingDrawable = beyq.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (!(paramImageView instanceof URLDrawable)) {
        break label162;
      }
      paramImageView = ((URLDrawable)paramImageView).getURL().toString();
      if ((paramView != null) && (!paramView.equals(paramImageView))) {
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramaidw));
      }
    }
    label162:
    label173:
    while (paramView.jdField_a_of_type_Boolean)
    {
      return;
      paramImageView.setImageResource(2130839340);
      paramaidq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramaidw));
      return;
    }
    paramURLImageView.setImageDrawable(beyq.b);
    this.jdField_a_of_type_Blhq.post(new AIOPhotoListAdapter.2(this, paramView));
  }
  
  private void a(ImageView paramImageView, TextView paramTextView, aidw paramaidw, URLImageView paramURLImageView)
  {
    paramImageView.setVisibility(4);
    paramTextView.setVisibility(4);
    AIOFilePicData localAIOFilePicData = (AIOFilePicData)paramaidw.a;
    paramTextView = localAIOFilePicData.a(18);
    paramImageView = localAIOFilePicData.a(18);
    if (paramTextView != null)
    {
      if (paramTextView == null) {
        break label163;
      }
      paramTextView = paramURLImageView.getDrawable();
      paramaidw = URLDrawable.URLDrawableOptions.obtain();
      paramaidw.mRequestWidth = this.jdField_a_of_type_Int;
      paramaidw.mRequestHeight = this.jdField_a_of_type_Int;
      paramaidw.mLoadingDrawable = beyq.b;
      if (!(paramTextView instanceof URLDrawable)) {
        break label152;
      }
      if (!paramImageView.equals(((URLDrawable)paramTextView).getURL().toString())) {
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramImageView, paramaidw));
      }
    }
    label152:
    label163:
    do
    {
      return;
      paramaidw = localAIOFilePicData.a(16);
      paramImageView = localAIOFilePicData.a(16);
      paramTextView = paramaidw;
      if (paramaidw != null) {
        break;
      }
      paramTextView = localAIOFilePicData.a(20);
      paramImageView = localAIOFilePicData.a(20);
      break;
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramImageView, paramaidw));
      return;
      if (localAIOFilePicData.jdField_c_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838072);
        }
        paramURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      paramURLImageView.setImageDrawable(beyq.b);
    } while ((!atyt.a()) && (this.jdField_c_of_type_Int == 2));
    this.jdField_a_of_type_Blhq.post(new AIOPhotoListAdapter.3(this, localAIOFilePicData));
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, ImageView paramImageView, TextView paramTextView1, View paramView, TextView paramTextView2, URLImageView paramURLImageView)
  {
    paramView.setVisibility(0);
    paramImageView.setImageResource(2130839483);
    paramImageView.setVisibility(0);
    paramTextView1.setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAIOFileVideoData.h));
    paramTextView1.setVisibility(0);
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    float f2 = this.jdField_a_of_type_Int * 2;
    paramTextView2.setText((String)TextUtils.ellipsize(paramAIOFileVideoData.a, paramTextView2.getPaint(), f2 - f1 * 4.0F * 8.0F, TextUtils.TruncateAt.END));
    paramTextView2.setVisibility(0);
    if (paramAIOFileVideoData.a(0) != null)
    {
      paramAIOFileVideoData = paramAIOFileVideoData.a(16);
      paramImageView = paramURLImageView.getDrawable();
      paramTextView1 = URLDrawable.URLDrawableOptions.obtain();
      paramTextView1.mRequestWidth = this.jdField_a_of_type_Int;
      paramTextView1.mRequestHeight = this.jdField_a_of_type_Int;
      paramTextView1.mLoadingDrawable = beyq.b;
      if ((paramImageView instanceof URLDrawable))
      {
        if (!paramAIOFileVideoData.equals(((URLDrawable)paramImageView).getURL().toString())) {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOFileVideoData, paramTextView1));
        }
        return;
      }
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOFileVideoData, paramTextView1));
      return;
    }
    paramURLImageView.setImageDrawable(null);
    paramURLImageView.setBackgroundColor(Color.parseColor("#D8DAE0"));
  }
  
  private void a(AIOLightVideoData paramAIOLightVideoData, ImageView paramImageView, TextView paramTextView, URLImageView paramURLImageView)
  {
    paramImageView.setImageResource(2130839340);
    paramTextView.setText(ShortVideoUtils.a(paramAIOLightVideoData.jdField_a_of_type_Int * 1000));
    paramTextView.setVisibility(0);
    paramImageView.setVisibility(0);
    if (paramAIOLightVideoData.a(0) != null)
    {
      paramAIOLightVideoData = paramAIOLightVideoData.a(0);
      paramImageView = URLDrawable.URLDrawableOptions.obtain();
      paramTextView = paramURLImageView.getDrawable();
      paramImageView.mRequestWidth = this.jdField_a_of_type_Int;
      paramImageView.mRequestHeight = this.jdField_a_of_type_Int;
      paramImageView.mLoadingDrawable = beyq.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if ((paramTextView instanceof URLDrawable))
      {
        paramTextView = ((URLDrawable)paramTextView).getURL().toString();
        if ((paramAIOLightVideoData != null) && (!paramAIOLightVideoData.equals(paramTextView))) {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOLightVideoData, paramImageView));
        }
        return;
      }
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOLightVideoData, paramImageView));
      return;
    }
    paramURLImageView.setImageDrawable(beyq.b);
    this.jdField_a_of_type_Blhq.post(new AIOPhotoListAdapter.4(this, paramAIOLightVideoData));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aicx == null) {}
    while (!this.jdField_a_of_type_Aicx.a()) {
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
    Object localObject1 = paramView.getTag();
    if (!aidw.class.isInstance(localObject2))
    {
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] is not AIORichMediaInfo, position:" + paramInt);
      return;
    }
    if (!(localObject1 instanceof aidq))
    {
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] is not ContentHolder, position:" + paramInt);
      return;
    }
    localObject1 = (aidq)localObject1;
    aidw localaidw = (aidw)localObject2;
    URLImageView localURLImageView = ((aidq)localObject1).jdField_a_of_type_ComTencentImageURLImageView;
    ImageView localImageView1 = ((aidq)localObject1).jdField_a_of_type_AndroidWidgetImageView;
    ImageView localImageView2 = ((aidq)localObject1).jdField_b_of_type_AndroidWidgetImageView;
    ImageView localImageView3 = ((aidq)localObject1).c;
    TextView localTextView1 = ((aidq)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    TextView localTextView2 = ((aidq)localObject1).jdField_b_of_type_AndroidWidgetTextView;
    View localView = ((aidq)localObject1).jdField_a_of_type_AndroidViewView;
    localView.setVisibility(8);
    localTextView2.setVisibility(8);
    localURLImageView.setBackgroundColor(0);
    localObject2 = null;
    if (AIOImageData.class.isInstance(localaidw.a))
    {
      a(localaidw, localImageView3, localTextView1, localURLImageView);
      localObject1 = localObject2;
      if (AppSetting.jdField_c_of_type_Boolean) {
        localObject1 = anzj.a(2131699030);
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        int i = paramInt / 4;
        paramView.setContentDescription(anzj.a(2131699031) + (i + 1) + anzj.a(2131699032) + (paramInt % 4 + 1) + (String)localObject1);
      }
      a(localaidw, localImageView1, localImageView2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] cost: " + (SystemClock.uptimeMillis() - l) + " data" + localaidw.a);
      return;
      if (AIOShortVideoData.class.isInstance(localaidw.a))
      {
        a(localView, localaidw, localImageView3, localTextView1, localURLImageView, (aidq)localObject1);
        localObject1 = localObject2;
        if (AppSetting.jdField_c_of_type_Boolean) {
          localObject1 = anzj.a(2131699028);
        }
      }
      else
      {
        if (!AIOFilePicData.class.isInstance(localaidw.a)) {
          break label442;
        }
        a(localImageView3, localTextView1, localaidw, localURLImageView);
        localObject1 = localObject2;
        if (AppSetting.jdField_c_of_type_Boolean) {
          localObject1 = anzj.a(2131699024);
        }
      }
    }
    label442:
    if (AIOFileVideoData.class.isInstance(localaidw.a))
    {
      a((AIOFileVideoData)localaidw.a, localImageView3, localTextView1, localView, localTextView2, localURLImageView);
      if (!AppSetting.jdField_c_of_type_Boolean) {
        break label558;
      }
    }
    label558:
    for (localObject1 = anzj.a(2131699027);; localObject1 = null)
    {
      break;
      localObject1 = localObject2;
      if (!AIOLightVideoData.class.isInstance(localaidw.a)) {
        break;
      }
      localView.setVisibility(0);
      a((AIOLightVideoData)localaidw.a, localImageView3, localTextView1, localURLImageView);
      localObject1 = localObject2;
      if (!AppSetting.jdField_c_of_type_Boolean) {
        break;
      }
      localObject1 = anzj.a(2131699025);
      break;
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
    int i = this.jdField_a_of_type_Aicx.g();
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
      return this.jdField_a_of_type_Aicx.a(paramInt);
    }
    if (paramInt < this.jdField_a_of_type_Aicx.g()) {
      return this.jdField_a_of_type_Aicx.a(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return jdField_a_of_type_JavaLangObject;
    }
    return aicx.b;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof aidw)) {}
    do
    {
      return 0;
      if (aicx.b.equals(localObject)) {
        return 1;
      }
      if ((localObject instanceof String)) {
        return 2;
      }
      if (aicx.jdField_a_of_type_JavaLangObject.equals(localObject)) {
        return 3;
      }
    } while (!jdField_a_of_type_JavaLangObject.equals(localObject));
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = null;
      switch (i)
      {
      default: 
        localObject2 = localObject1;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
    }
    for (;;)
    {
      a(i, paramInt, (View)localObject1, paramView);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = paramView.getTag();
      break;
      if (aidq.class.isInstance(localObject1))
      {
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        if ((QLog.isColorLevel()) && (paramView != null))
        {
          paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
          QLog.d("AIOPhotoListAdapter", 2, "[getView] type 0 while convertView type " + paramView.jdField_a_of_type_Int);
        }
        localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561406, null);
        ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        paramView = new aidq(this);
        paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)((View)localObject2).findViewById(2131372580));
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131368936));
        paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131372585));
        paramView.c = ((ImageView)((View)localObject2).findViewById(2131372511));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131380874));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131366640));
        paramView.jdField_a_of_type_AndroidViewView = ((View)localObject2).findViewById(2131363630);
        ((View)localObject2).setTag(paramView);
        paramView = (View)localObject1;
        localObject1 = localObject2;
        continue;
        if (aicx.b.equals(localObject1))
        {
          localObject2 = paramView;
          paramView = (View)localObject1;
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = new View(this.jdField_a_of_type_AndroidContentContext);
          ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
          ((View)localObject2).setTag(aicx.b);
          paramView = (View)localObject1;
          localObject1 = localObject2;
          continue;
          if (aids.class.isInstance(localObject1))
          {
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
          }
          else
          {
            localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561398, null);
            paramView = new aids(this);
            paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131378764));
            paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((View)localObject2).findViewById(2131369210));
            localObject1 = new aidr(this, this.jdField_a_of_type_AndroidContentContext);
            Object localObject3 = ((View)localObject2).getLayoutParams();
            if (localObject3 != null)
            {
              ((View)localObject2).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
              ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
            }
            ((FrameLayout)localObject1).addView((View)localObject2);
            ((View)localObject1).setTag(paramView);
            continue;
            if (aicx.jdField_a_of_type_JavaLangObject.equals(localObject1))
            {
              localObject2 = paramView;
              paramView = (View)localObject1;
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = new View(this.jdField_a_of_type_AndroidContentContext);
              ((View)localObject2).setMinimumHeight(this.jdField_b_of_type_Int);
              ((View)localObject2).setVisibility(4);
              ((View)localObject2).setTag(aicx.jdField_a_of_type_JavaLangObject);
              paramView = (View)localObject1;
              localObject1 = localObject2;
              continue;
              if (jdField_a_of_type_JavaLangObject.equals(localObject1))
              {
                localObject2 = paramView;
                paramView = (View)localObject1;
                localObject1 = localObject2;
              }
              else
              {
                localObject2 = new aidr(this, this.jdField_a_of_type_AndroidContentContext);
                paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561397, null);
                localObject3 = new FrameLayout.LayoutParams(-2, -2);
                ((FrameLayout.LayoutParams)localObject3).gravity = 17;
                paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                ((aidr)localObject2).addView(paramView);
                ((View)localObject2).setTag(jdField_a_of_type_JavaLangObject);
                paramView = (View)localObject1;
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
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
 * Qualified Name:     aido
 * JD-Core Version:    0.7.0.1
 */