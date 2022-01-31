import android.content.Context;
import android.content.res.Resources;
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
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
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

public class afxw
  extends afxy
{
  private Drawable a;
  private float jdField_b_of_type_Float = 0.5625F;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d = BaseChatItemLayout.e;
  
  public afxw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = ((int)(BaseChatItemLayout.e * this.jdField_b_of_type_Float));
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new afhi(Color.argb(255, 242, 242, 242), 255, f * 14.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localBitmap = null;
      if (!(bayu.b() instanceof SkinnableBitmapDrawable)) {
        break label59;
      }
      localBitmap = ((SkinnableBitmapDrawable)bayu.b()).getBitmap();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new apkn(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label59:
      if ((bayu.b() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)bayu.b()).getBitmap();
      }
    }
  }
  
  private Drawable a(afxx paramafxx)
  {
    Object localObject = this.jdField_a_of_type_Aqvx.b();
    if (bdhb.b((String)localObject))
    {
      i = this.jdField_a_of_type_Aqvx.a();
      int j = this.jdField_a_of_type_Aqvx.b();
      if ((i == 0) || (j == 0)) {
        a(paramafxx, (String)localObject);
      }
      Drawable localDrawable1 = a(paramafxx.e, paramafxx.f);
      Drawable localDrawable2 = a(paramafxx.e, paramafxx.f);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      paramafxx = localDrawable1;
      if (localObject != null) {
        paramafxx = bayu.a((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return paramafxx;
    }
    int i = this.jdField_a_of_type_Aqvx.f();
    if (i == 1)
    {
      a(paramafxx, i);
      return a();
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Aqvx.a();
      return a(paramafxx.e, paramafxx.f);
    }
    this.jdField_a_of_type_Aqvx.a();
    paramafxx.jdField_c_of_type_AndroidViewView.setVisibility(0);
    return a();
  }
  
  private void a(afxx paramafxx)
  {
    FrameLayout localFrameLayout = paramafxx.jdField_a_of_type_AndroidWidgetFrameLayout;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368429);
      localTextView.setText(2131693476);
      localTextView.setCompoundDrawablePadding(aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130849204, 0, 0);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramafxx.e, paramafxx.f));
      return;
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(afxx paramafxx, int paramInt)
  {
    FrameLayout localFrameLayout;
    if (paramInt == 1)
    {
      localFrameLayout = paramafxx.jdField_a_of_type_AndroidWidgetFrameLayout;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT < 16) {
        break label158;
      }
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368429);
      localTextView.setText(2131692600);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(aepi.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844425);
      localDrawable.setBounds(0, 0, aepi.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramafxx.e, paramafxx.f));
      return;
      label158:
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(afxx paramafxx, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramafxx.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      paramafxx.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    b(paramafxx);
    paramafxx.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = a(paramafxx);
    paramafxx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    localObject = bdhb.a(this.jdField_a_of_type_Aqvx.a());
    a(this.jdField_a_of_type_Aqvx.a(), (String)localObject, paramafxx);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramafxx, paramBaseChatItemLayout);
  }
  
  private void a(afxx paramafxx, String paramString)
  {
    if (!bdhb.b(paramString)) {
      return;
    }
    paramString = arrr.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramafxx.e = i;
      paramafxx.f = j;
      this.jdField_a_of_type_Aqvx.a(i, j);
    }
    b(paramafxx);
  }
  
  private void a(afxx paramafxx, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramafxx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
      {
        localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
        localPicProgressView.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.a);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(6, 2131371945);
        localLayoutParams.addRule(8, 2131371945);
        localLayoutParams.addRule(5, 2131371945);
        localLayoutParams.addRule(7, 2131371945);
        ((RelativeLayout)paramafxx.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        paramafxx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        paramafxx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramafxx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramafxx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (paramafxx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramafxx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.jdField_a_of_type_Aqvx.e());
      }
    }
    if (!paramafxx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramafxx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      ((RelativeLayout)paramafxx.jdField_a_of_type_AndroidViewView).removeView(paramafxx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramafxx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    paramafxx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private void a(String paramString1, String paramString2, afxx paramafxx)
  {
    if (paramafxx.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramafxx.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramafxx.jdField_a_of_type_AndroidViewView).removeView(paramafxx.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131366325);
    localRelativeLayout.setBackgroundResource(2130838947);
    paramafxx.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, aepi.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131371945);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131371945);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131371945);
    ((RelativeLayout)paramafxx.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = arsx.a(paramafxx.e, paramafxx.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131364141);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131364144);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131364141);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = arsx.a(this.jdField_a_of_type_AndroidContentContext, i, paramafxx.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
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
  
  private void b(afxx paramafxx)
  {
    Object localObject = this.jdField_a_of_type_Aqvx.b();
    localObject = arsj.a(this.jdField_a_of_type_Aqvx.a(), this.jdField_a_of_type_Aqvx.b(), (String)localObject);
    int i = ((arsk)localObject).jdField_a_of_type_Int;
    int j = ((arsk)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramafxx.e = i;
      paramafxx.f = j;
      localObject = paramafxx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(paramafxx.e, paramafxx.f);
      paramafxx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == paramafxx.e) && (((ViewGroup.LayoutParams)localObject).height == paramafxx.f))
    {
      return;
      paramafxx.e = this.jdField_c_of_type_Int;
      paramafxx.f = this.d;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramafxx.e;
    ((ViewGroup.LayoutParams)localObject).height = paramafxx.f;
    paramafxx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(afxx paramafxx, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Aqvx.c();
    if (i == 1)
    {
      if (!bdhb.b(this.jdField_a_of_type_Aqvx.b()))
      {
        b(paramafxx);
        a(paramafxx);
        paramafxx.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if (paramafxx.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          paramafxx.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
          ((RelativeLayout)paramafxx.jdField_a_of_type_AndroidViewView).removeView(paramafxx.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
      }
      return;
    }
    if (i == 3)
    {
      a(paramafxx, true);
      paramafxx.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    if (i == 4)
    {
      a(paramafxx, false);
      return;
    }
    a(paramafxx, false);
  }
  
  public aeqh a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (afxx.class.isInstance(paramView))) {
        return ((afxx)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected View a(aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    Object localObject1;
    if ((paramaeqi instanceof afxx))
    {
      localObject1 = (afxx)paramaeqi;
      paramaeqi = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramaeqi;
      if (paramaeqi == null)
      {
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaeqi = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramaeqi.e = true;
        }
        paramaeqi.setId(2131371945);
        paramaeqi.setAdjustViewBounds(true);
        paramaeqi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramaeqi.setRadius(15.0F);
        paramaeqi.d(false);
        paramaeqi.setShowEdge(true);
        ((RelativeLayout)localObject1).addView(paramaeqi, new RelativeLayout.LayoutParams(-2, -2));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramaeqi;
        paramaeqi = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131368429);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
        Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        paramaeqi.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramaeqi.setVisibility(8);
        ((RelativeLayout)localObject1).addView(paramaeqi, new RelativeLayout.LayoutParams(-1, -1));
        paramView.jdField_a_of_type_AndroidWidgetFrameLayout = paramaeqi;
        paramaeqi = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaeqi.setOrientation(1);
        paramaeqi.setGravity(1);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((RelativeLayout)localObject1).addView(paramaeqi, (ViewGroup.LayoutParams)localObject2);
        paramView.jdField_c_of_type_AndroidViewView = paramaeqi;
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setImageResource(2130839225);
        paramaeqi.addView((View)localObject2, new LinearLayout.LayoutParams(aepi.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setText(2131692602);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = aepi.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramaeqi.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setOnClickListener(this);
        super.a((View)localObject1, paramaetk);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a(paramView, paramBaseChatItemLayout);
      return localObject1;
      paramView = new afxx(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramaeqi.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramaeqi.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramaeqi.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Anwo = paramaeqi.jdField_a_of_type_Anwo;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramaeqi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramaeqi.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramaeqi.jdField_b_of_type_Int;
      paramView.jdField_c_of_type_Int = paramaeqi.jdField_c_of_type_Int;
      paramView.d = paramaeqi.d;
      paramView.jdField_a_of_type_JavaLangString = paramaeqi.jdField_a_of_type_JavaLangString;
      paramaeqi = null;
    }
  }
  
  protected List<Integer> a(bdpi parambdpi, aeqz paramaeqz)
  {
    return this.jdField_a_of_type_Aqvx.a(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aqvx.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131370818: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected aeqi b()
  {
    return new afxx(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bdil.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692597);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692594);
  }
  
  protected List<Integer> b(bdpi parambdpi, aeqz paramaeqz)
  {
    return this.jdField_a_of_type_Aqvx.b(2);
  }
  
  protected void d(View paramView)
  {
    if (paramView.getId() == 2131364173)
    {
      paramView = aepi.a(paramView);
      if (paramView == null) {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
      }
    }
    else
    {
      return;
    }
    if (!afxx.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (afxx)paramView;
    this.jdField_a_of_type_Aqvx.a(2, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxw
 * JD-Core Version:    0.7.0.1
 */