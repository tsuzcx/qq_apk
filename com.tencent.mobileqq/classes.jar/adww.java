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

public class adww
  extends adwy
{
  private Drawable a;
  private float jdField_b_of_type_Float = 0.5625F;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d = BaseChatItemLayout.e;
  
  public adww(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = ((int)(BaseChatItemLayout.e * this.jdField_b_of_type_Float));
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new adkl(Color.argb(255, 242, 242, 242), 255, f * 14.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localBitmap = null;
      if (!(aywk.b() instanceof SkinnableBitmapDrawable)) {
        break label59;
      }
      localBitmap = ((SkinnableBitmapDrawable)aywk.b()).getBitmap();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new anos(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label59:
      if ((aywk.b() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)aywk.b()).getBitmap();
      }
    }
  }
  
  private Drawable a(adwx paramadwx)
  {
    Object localObject = this.jdField_a_of_type_Aoym.b();
    if (bbdj.b((String)localObject))
    {
      i = this.jdField_a_of_type_Aoym.a();
      int j = this.jdField_a_of_type_Aoym.b();
      if ((i == 0) || (j == 0)) {
        a(paramadwx, (String)localObject);
      }
      Drawable localDrawable1 = a(paramadwx.e, paramadwx.f);
      Drawable localDrawable2 = a(paramadwx.e, paramadwx.f);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      paramadwx = localDrawable1;
      if (localObject != null) {
        paramadwx = aywk.a((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return paramadwx;
    }
    int i = this.jdField_a_of_type_Aoym.f();
    if (i == 1)
    {
      a(paramadwx, i);
      return a();
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Aoym.a();
      return a(paramadwx.e, paramadwx.f);
    }
    this.jdField_a_of_type_Aoym.a();
    paramadwx.jdField_c_of_type_AndroidViewView.setVisibility(0);
    return a();
  }
  
  private void a(adwx paramadwx)
  {
    FrameLayout localFrameLayout = paramadwx.jdField_a_of_type_AndroidWidgetFrameLayout;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368272);
      localTextView.setText(2131693372);
      localTextView.setCompoundDrawablePadding(actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130848693, 0, 0);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramadwx.e, paramadwx.f));
      return;
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(adwx paramadwx, int paramInt)
  {
    FrameLayout localFrameLayout;
    if (paramInt == 1)
    {
      localFrameLayout = paramadwx.jdField_a_of_type_AndroidWidgetFrameLayout;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT < 16) {
        break label158;
      }
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368272);
      localTextView.setText(2131692522);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(actn.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844009);
      localDrawable.setBounds(0, 0, actn.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramadwx.e, paramadwx.f));
      return;
      label158:
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(adwx paramadwx, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramadwx.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      paramadwx.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    b(paramadwx);
    paramadwx.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = a(paramadwx);
    paramadwx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    localObject = bbdj.a(this.jdField_a_of_type_Aoym.a());
    a(this.jdField_a_of_type_Aoym.a(), (String)localObject, paramadwx);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramadwx, paramBaseChatItemLayout);
  }
  
  private void a(adwx paramadwx, String paramString)
  {
    if (!bbdj.b(paramString)) {
      return;
    }
    paramString = apue.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramadwx.e = i;
      paramadwx.f = j;
      this.jdField_a_of_type_Aoym.a(i, j);
    }
    b(paramadwx);
  }
  
  private void a(adwx paramadwx, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramadwx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
      {
        localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
        localPicProgressView.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.a);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(6, 2131371608);
        localLayoutParams.addRule(8, 2131371608);
        localLayoutParams.addRule(5, 2131371608);
        localLayoutParams.addRule(7, 2131371608);
        ((RelativeLayout)paramadwx.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        paramadwx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        paramadwx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramadwx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadwx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramadwx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (paramadwx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramadwx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.jdField_a_of_type_Aoym.e());
      }
    }
    if (!paramadwx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramadwx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadwx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      ((RelativeLayout)paramadwx.jdField_a_of_type_AndroidViewView).removeView(paramadwx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramadwx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    paramadwx.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private void a(String paramString1, String paramString2, adwx paramadwx)
  {
    if (paramadwx.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadwx.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadwx.jdField_a_of_type_AndroidViewView).removeView(paramadwx.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131366235);
    localRelativeLayout.setBackgroundResource(2130838791);
    paramadwx.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, actn.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131371608);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131371608);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131371608);
    ((RelativeLayout)paramadwx.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = apvk.a(paramadwx.e, paramadwx.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131364078);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131364081);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131364078);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = apvk.a(this.jdField_a_of_type_AndroidContentContext, i, paramadwx.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
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
  
  private void b(adwx paramadwx)
  {
    Object localObject = this.jdField_a_of_type_Aoym.b();
    localObject = apuw.a(this.jdField_a_of_type_Aoym.a(), this.jdField_a_of_type_Aoym.b(), (String)localObject);
    int i = ((apux)localObject).jdField_a_of_type_Int;
    int j = ((apux)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramadwx.e = i;
      paramadwx.f = j;
      localObject = paramadwx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(paramadwx.e, paramadwx.f);
      paramadwx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == paramadwx.e) && (((ViewGroup.LayoutParams)localObject).height == paramadwx.f))
    {
      return;
      paramadwx.e = this.jdField_c_of_type_Int;
      paramadwx.f = this.d;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramadwx.e;
    ((ViewGroup.LayoutParams)localObject).height = paramadwx.f;
    paramadwx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(adwx paramadwx, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Aoym.c();
    if (i == 1)
    {
      if (!bbdj.b(this.jdField_a_of_type_Aoym.b()))
      {
        b(paramadwx);
        a(paramadwx);
        paramadwx.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if (paramadwx.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          paramadwx.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
          ((RelativeLayout)paramadwx.jdField_a_of_type_AndroidViewView).removeView(paramadwx.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
      }
      return;
    }
    if (i == 3)
    {
      a(paramadwx, true);
      paramadwx.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    if (i == 4)
    {
      a(paramadwx, false);
      return;
    }
    a(paramadwx, false);
  }
  
  public acum a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (adwx.class.isInstance(paramView))) {
        return ((adwx)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected View a(acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    Object localObject1;
    if ((paramacun instanceof adwx))
    {
      localObject1 = (adwx)paramacun;
      paramacun = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramacun;
      if (paramacun == null)
      {
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacun = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramacun.e = true;
        }
        paramacun.setId(2131371608);
        paramacun.setAdjustViewBounds(true);
        paramacun.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramacun.setRadius(15.0F);
        paramacun.d(false);
        paramacun.setShowEdge(true);
        ((RelativeLayout)localObject1).addView(paramacun, new RelativeLayout.LayoutParams(-2, -2));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramacun;
        paramacun = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131368272);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
        Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        paramacun.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramacun.setVisibility(8);
        ((RelativeLayout)localObject1).addView(paramacun, new RelativeLayout.LayoutParams(-1, -1));
        paramView.jdField_a_of_type_AndroidWidgetFrameLayout = paramacun;
        paramacun = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacun.setOrientation(1);
        paramacun.setGravity(1);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((RelativeLayout)localObject1).addView(paramacun, (ViewGroup.LayoutParams)localObject2);
        paramView.jdField_c_of_type_AndroidViewView = paramacun;
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setImageResource(2130839140);
        paramacun.addView((View)localObject2, new LinearLayout.LayoutParams(actn.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setText(2131692524);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = actn.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramacun.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setOnClickListener(this);
        super.a((View)localObject1, paramacxn);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a(paramView, paramBaseChatItemLayout);
      return localObject1;
      paramView = new adwx(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramacun.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramacun.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramacun.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Ambh = paramacun.jdField_a_of_type_Ambh;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramacun.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramacun.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramacun.jdField_b_of_type_Int;
      paramView.jdField_c_of_type_Int = paramacun.jdField_c_of_type_Int;
      paramView.d = paramacun.d;
      paramView.jdField_a_of_type_JavaLangString = paramacun.jdField_a_of_type_JavaLangString;
      paramacun = null;
    }
  }
  
  protected List<Integer> a(bblr parambblr, acve paramacve)
  {
    return this.jdField_a_of_type_Aoym.a(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aoym.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131370494: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected acun b()
  {
    return new adwx(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bbet.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692519);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692516);
  }
  
  protected List<Integer> b(bblr parambblr, acve paramacve)
  {
    return this.jdField_a_of_type_Aoym.b(2);
  }
  
  protected void d(View paramView)
  {
    if (paramView.getId() == 2131364110)
    {
      paramView = actn.a(paramView);
      if (paramView == null) {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
      }
    }
    else
    {
      return;
    }
    if (!adwx.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (adwx)paramView;
    this.jdField_a_of_type_Aoym.a(2, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adww
 * JD-Core Version:    0.7.0.1
 */