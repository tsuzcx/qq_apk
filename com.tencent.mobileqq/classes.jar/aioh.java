import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class aioh
  extends BaseAdapter
  implements View.OnClickListener, bklf
{
  public static int a;
  private float jdField_a_of_type_Float;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  public List<aioj> a;
  public MqqHandler a;
  public int b;
  private long b;
  public List<aioj> b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  static
  {
    jdField_a_of_type_Int = 6;
  }
  
  public aioh(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    int i = 0;
    while (i < jdField_a_of_type_Int)
    {
      this.jdField_b_of_type_JavaUtilList.add(new aioj());
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.c = afur.a(85.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.d = afur.a(85.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.e = afur.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.f = afur.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.g = afur.a(2.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public aioj a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (aioj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "[ZhituPicAdapter]-resetData");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = -1;
    notifyDataSetChanged();
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ZhituManager", 2, "ZhituPicAdapter setPicItemCount: picCount = ,mReqKey = " + paramString + ",this.mReqKey =" + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    while (paramInt <= 0) {
      return;
    }
    if (!paramString.equals(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008C71", "0X8008C71", ains.a(ains.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()), 0, "", "", "", "");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    while (i < paramInt)
    {
      this.jdField_a_of_type_JavaUtilList.add(new aioj());
      i += 1;
    }
    this.jdField_b_of_type_Int = -1;
    notifyDataSetChanged();
  }
  
  public void a(aioj paramaioj)
  {
    if (paramaioj != null)
    {
      int i = paramaioj.jdField_a_of_type_Int;
      if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
        ((aioj)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramaioj);
      }
      notifyDataSetChanged();
    }
  }
  
  public void a(View paramView) {}
  
  public void b()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (TextUtils.isEmpty(((aioj)this.jdField_a_of_type_JavaUtilList.get(i - 1)).d)) {}
    while (i <= this.jdField_b_of_type_Int) {
      return;
    }
    this.jdField_b_of_type_Int = i;
    ains.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString);
  }
  
  public void b(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof aioi)))
    {
      paramView = (aioi)paramView.getTag();
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= getCount())
    {
      QLog.e("ZhituManager", 2, "get view position exception , position = " + paramInt + ",size = " + this.jdField_a_of_type_JavaUtilList.size());
      localObject1 = paramView;
    }
    aioj localaioj;
    for (paramView = null;; paramView = (View)localObject2)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localaioj = a(paramInt);
      if (localaioj != null) {
        break;
      }
      QLog.e("ZhituManager", 1, "getView emoticon empty position = " + paramInt);
      localObject2 = null;
      localObject1 = paramView;
    }
    label374:
    Object localObject3;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject1 = new aioi(null);
      ((aioi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ViewGroup.LayoutParams(-2, this.d);
      ((aioi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(5.0F);
      ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b = false;
      ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramView = new RelativeLayout.LayoutParams(-2, this.f);
      paramView.addRule(13, -1);
      ((aioi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramView);
      ((aioi)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
      ((aioi)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839402));
      paramView = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 30.0F), (int)(this.jdField_a_of_type_Float * 30.0F));
      paramView.addRule(13, -1);
      ((aioi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((aioi)localObject1).jdField_a_of_type_AndroidWidgetProgressBar, paramView);
      paramView = ((aioi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(localObject1);
      paramView.setOnClickListener(this);
      ((aioi)localObject1).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localaioj);
      ((aioi)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if (!localaioj.jdField_a_of_type_Boolean) {
        break label892;
      }
      String str = ains.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localaioj);
      localObject3 = ains.a(str);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        ains.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(localaioj);
        localObject2 = localObject3;
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, "get gif image from cache fail, " + str);
        }
      }
    }
    label601:
    label885:
    label892:
    for (Object localObject2 = localObject3;; localObject2 = null)
    {
      if ((localaioj.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (localObject2 != null))
      {
        ((aioi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setMinimumWidth(0);
        localObject3 = localaioj.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(localaioj.jdField_a_of_type_JavaLangString + localaioj.e);
        if (localObject2 == null) {
          break label885;
        }
      }
      for (localObject2 = new GifDrawable((AbstractGifImage)localObject2);; localObject2 = localObject3)
      {
        int i = ((Drawable)localObject2).getIntrinsicWidth();
        int j = ((Drawable)localObject2).getIntrinsicHeight();
        if (j == this.f)
        {
          ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER);
          ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().width = i;
          ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject2);
          ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
          ((aioi)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          if (paramInt != 0) {
            break label844;
          }
          ((aioi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = (this.g + i);
          ((aioi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, this.g, 0);
        }
        for (;;)
        {
          if ((localaioj.jdField_a_of_type_Aiok != null) && (!localaioj.jdField_a_of_type_Aiok.jdField_a_of_type_Boolean))
          {
            ains.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localaioj);
            localaioj.jdField_a_of_type_Aiok.jdField_a_of_type_Boolean = true;
          }
          localObject1 = paramView;
          break;
          localObject1 = (aioi)paramView.getTag();
          break label374;
          if (j > this.f)
          {
            i = i * this.f / j;
            ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            break label601;
          }
          i = i * this.e / j;
          ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          break label601;
          ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
          ((aioi)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().width = this.c;
          i = this.c;
          ((aioi)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          break label643;
          ((aioi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = (this.g * 2 + i);
          ((aioi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.g, 0, this.g, 0);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_b_of_type_Long < 200L) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "filter multi click");
      }
    }
    label175:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_Long = l;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof aioi))) {}
      for (localObject = (aioi)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label175;
        }
        localObject = (aioj)((aioi)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject == null) || (((aioj)localObject).jdField_a_of_type_JavaLangString == null) || (((aioj)localObject).jdField_a_of_type_Aiok == null)) {
          break;
        }
        ThreadManager.post(new ZhituPicAdapter.1(this, (aioj)localObject), 8, null, false);
        ains.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((aioj)localObject);
        if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
          break;
        }
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(84);
        ((Message)localObject).arg1 = 1;
        ((Message)localObject).sendToTarget();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioh
 * JD-Core Version:    0.7.0.1
 */