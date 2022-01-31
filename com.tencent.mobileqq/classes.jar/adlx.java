import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;
import java.util.List;

public class adlx
  extends adlz
{
  private Drawable a;
  private float jdField_b_of_type_Float = 0.5625F;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c = (int)(BaseChatItemLayout.e * this.jdField_b_of_type_Float);
  private int d = BaseChatItemLayout.e;
  
  public adlx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new aczj(Color.argb(255, 242, 242, 242), 255, f * 14.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localBitmap = null;
      if (!(axwd.b() instanceof SkinnableBitmapDrawable)) {
        break label59;
      }
      localBitmap = ((SkinnableBitmapDrawable)axwd.b()).getBitmap();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new amyk(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label59:
      if ((axwd.b() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)axwd.b()).getBitmap();
      }
    }
  }
  
  private Drawable a(adly paramadly)
  {
    Object localObject = this.jdField_a_of_type_Aohs.b();
    if (bace.b((String)localObject))
    {
      int i = this.jdField_a_of_type_Aohs.a();
      int j = this.jdField_a_of_type_Aohs.b();
      if ((i == 0) || (j == 0)) {
        a(paramadly, (String)localObject);
      }
      Drawable localDrawable1 = a(paramadly.e, paramadly.f);
      Drawable localDrawable2 = a(paramadly.e, paramadly.f);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      paramadly = localDrawable1;
      if (localObject != null) {
        paramadly = axwd.a((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return paramadly;
    }
    this.jdField_a_of_type_Aohs.a();
    return a(paramadly.e, paramadly.f);
  }
  
  private void a(adly paramadly)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(2131627731);
      ((TextView)localObject).setCompoundDrawablePadding(aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130848457, 0, 0);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localFrameLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramadly.e, paramadly.f);
      ((RelativeLayout)paramadly.jdField_a_of_type_AndroidViewView).addView(localFrameLayout, (ViewGroup.LayoutParams)localObject);
      paramadly.jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
      return;
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(adly paramadly, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramadly.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      paramadly.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      ((RelativeLayout)paramadly.jdField_a_of_type_AndroidViewView).removeView(paramadly.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
    b(paramadly);
    Object localObject = a(paramadly);
    paramadly.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    localObject = bace.a(this.jdField_a_of_type_Aohs.a());
    a(this.jdField_a_of_type_Aohs.a(), (String)localObject, paramadly);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramadly, paramBaseChatItemLayout);
  }
  
  private void a(adly paramadly, String paramString)
  {
    if (!bace.b(paramString)) {
      return;
    }
    paramString = apck.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramadly.e = i;
      paramadly.f = j;
      this.jdField_a_of_type_Aohs.a(i, j);
    }
    b(paramadly);
  }
  
  private void a(adly paramadly, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramadly.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
      {
        localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
        localPicProgressView.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.a);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(6, 2131305912);
        localLayoutParams.addRule(8, 2131305912);
        localLayoutParams.addRule(5, 2131305912);
        localLayoutParams.addRule(7, 2131305912);
        ((RelativeLayout)paramadly.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        paramadly.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        paramadly.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramadly.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadly.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramadly.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (paramadly.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramadly.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.jdField_a_of_type_Aohs.e());
      }
    }
    if (!paramadly.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramadly.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadly.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      ((RelativeLayout)paramadly.jdField_a_of_type_AndroidViewView).removeView(paramadly.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramadly.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    paramadly.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private void a(String paramString1, String paramString2, adly paramadly)
  {
    if (paramadly.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadly.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadly.jdField_a_of_type_AndroidViewView).removeView(paramadly.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131300633);
    localRelativeLayout.setBackgroundResource(2130838764);
    paramadly.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, aciy.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131305912);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131305912);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131305912);
    ((RelativeLayout)paramadly.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = apdq.a(paramadly.e, paramadly.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131298520);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131298523);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131298520);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = apdq.a(this.jdField_a_of_type_AndroidContentContext, i, paramadly.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
      switch (i)
      {
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText(paramString1);
      ((TextView)localObject1).setText(paramString2);
      return;
      localLayoutParams.addRule(12);
      break;
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setGravity(3);
      continue;
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject1).setGravity(5);
    }
  }
  
  private void b(adly paramadly)
  {
    Object localObject = this.jdField_a_of_type_Aohs.b();
    localObject = apdc.a(this.jdField_a_of_type_Aohs.a(), this.jdField_a_of_type_Aohs.b(), (String)localObject);
    int i = ((apdd)localObject).jdField_a_of_type_Int;
    int j = ((apdd)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramadly.e = i;
      paramadly.f = j;
      localObject = paramadly.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(paramadly.e, paramadly.f);
      paramadly.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == paramadly.e) && (((ViewGroup.LayoutParams)localObject).height == paramadly.f))
    {
      return;
      paramadly.e = this.c;
      paramadly.f = this.d;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramadly.e;
    ((ViewGroup.LayoutParams)localObject).height = paramadly.f;
    paramadly.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(adly paramadly, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Aohs.c();
    if (i == 1)
    {
      if (!bace.b(this.jdField_a_of_type_Aohs.b()))
      {
        b(paramadly);
        a(paramadly);
      }
      return;
    }
    if (i == 3)
    {
      a(paramadly, true);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    if (i == 4)
    {
      a(paramadly, false);
      return;
    }
    a(paramadly, false);
  }
  
  public acjt a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (adly.class.isInstance(paramView))) {
        return ((adly)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected View a(acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    Object localObject;
    if ((paramacju instanceof adly))
    {
      localObject = (adly)paramacju;
      paramacju = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramacju;
      if (paramacju == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacju = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramacju.e = true;
        }
        paramacju.setId(2131305912);
        paramacju.setAdjustViewBounds(true);
        paramacju.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramacju.setRadius(15.0F);
        paramacju.d(false);
        paramacju.setShowEdge(true);
        ((RelativeLayout)localObject).addView(paramacju, new RelativeLayout.LayoutParams(-2, -2));
        ((View)localObject).setOnClickListener(this);
        super.a((View)localObject, paramacmv);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramacju;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new adly(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramacju.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramacju.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramacju.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Almt = paramacju.jdField_a_of_type_Almt;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramacju.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramacju.jdField_b_of_type_Int;
      paramView.c = paramacju.c;
      paramView.d = paramacju.d;
      paramView.jdField_a_of_type_JavaLangString = paramacju.jdField_a_of_type_JavaLangString;
      paramacju = null;
    }
  }
  
  protected List<Integer> a(bakh parambakh, ackl paramackl)
  {
    return this.jdField_a_of_type_Aohs.a(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aohs.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131304829: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected acju b()
  {
    return new adly(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bado.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131626904);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131626901);
  }
  
  protected List<Integer> b(bakh parambakh, ackl paramackl)
  {
    return this.jdField_a_of_type_Aohs.b(2);
  }
  
  protected void d(View paramView)
  {
    if (paramView.getId() == 2131298552)
    {
      paramView = aciy.a(paramView);
      if (paramView == null) {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
      }
    }
    else
    {
      return;
    }
    if (!adly.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (adly)paramView;
    this.jdField_a_of_type_Aohs.a(2, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adlx
 * JD-Core Version:    0.7.0.1
 */