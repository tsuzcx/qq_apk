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

public class adwu
  extends adww
{
  private Drawable a;
  private float jdField_b_of_type_Float = 0.5625F;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d = BaseChatItemLayout.e;
  
  public adwu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = ((int)(BaseChatItemLayout.e * this.jdField_b_of_type_Float));
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new adkj(Color.argb(255, 242, 242, 242), 255, f * 14.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localBitmap = null;
      if (!(aywm.b() instanceof SkinnableBitmapDrawable)) {
        break label59;
      }
      localBitmap = ((SkinnableBitmapDrawable)aywm.b()).getBitmap();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new anox(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label59:
      if ((aywm.b() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)aywm.b()).getBitmap();
      }
    }
  }
  
  private Drawable a(adwv paramadwv)
  {
    Object localObject = this.jdField_a_of_type_Aoyq.b();
    if (bbdx.b((String)localObject))
    {
      i = this.jdField_a_of_type_Aoyq.a();
      int j = this.jdField_a_of_type_Aoyq.b();
      if ((i == 0) || (j == 0)) {
        a(paramadwv, (String)localObject);
      }
      Drawable localDrawable1 = a(paramadwv.e, paramadwv.f);
      Drawable localDrawable2 = a(paramadwv.e, paramadwv.f);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      paramadwv = localDrawable1;
      if (localObject != null) {
        paramadwv = aywm.a((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return paramadwv;
    }
    int i = this.jdField_a_of_type_Aoyq.f();
    if (i == 1)
    {
      a(paramadwv, i);
      return a();
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Aoyq.a();
      return a(paramadwv.e, paramadwv.f);
    }
    this.jdField_a_of_type_Aoyq.a();
    paramadwv.jdField_c_of_type_AndroidViewView.setVisibility(0);
    return a();
  }
  
  private void a(adwv paramadwv)
  {
    FrameLayout localFrameLayout = paramadwv.jdField_a_of_type_AndroidWidgetFrameLayout;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368272);
      localTextView.setText(2131693373);
      localTextView.setCompoundDrawablePadding(actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130848699, 0, 0);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramadwv.e, paramadwv.f));
      return;
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(adwv paramadwv, int paramInt)
  {
    FrameLayout localFrameLayout;
    if (paramInt == 1)
    {
      localFrameLayout = paramadwv.jdField_a_of_type_AndroidWidgetFrameLayout;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT < 16) {
        break label158;
      }
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368272);
      localTextView.setText(2131692523);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(actj.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844010);
      localDrawable.setBounds(0, 0, actj.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramadwv.e, paramadwv.f));
      return;
      label158:
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(adwv paramadwv, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramadwv.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      paramadwv.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    b(paramadwv);
    paramadwv.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = a(paramadwv);
    paramadwv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    localObject = bbdx.a(this.jdField_a_of_type_Aoyq.a());
    a(this.jdField_a_of_type_Aoyq.a(), (String)localObject, paramadwv);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramadwv, paramBaseChatItemLayout);
  }
  
  private void a(adwv paramadwv, String paramString)
  {
    if (!bbdx.b(paramString)) {
      return;
    }
    paramString = apug.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramadwv.e = i;
      paramadwv.f = j;
      this.jdField_a_of_type_Aoyq.a(i, j);
    }
    b(paramadwv);
  }
  
  private void a(adwv paramadwv, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramadwv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
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
        ((RelativeLayout)paramadwv.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        paramadwv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        paramadwv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramadwv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadwv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramadwv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (paramadwv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramadwv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.jdField_a_of_type_Aoyq.e());
      }
    }
    if (!paramadwv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramadwv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadwv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      ((RelativeLayout)paramadwv.jdField_a_of_type_AndroidViewView).removeView(paramadwv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramadwv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    paramadwv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private void a(String paramString1, String paramString2, adwv paramadwv)
  {
    if (paramadwv.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadwv.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadwv.jdField_a_of_type_AndroidViewView).removeView(paramadwv.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131366235);
    localRelativeLayout.setBackgroundResource(2130838791);
    paramadwv.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, actj.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131371608);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131371608);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131371608);
    ((RelativeLayout)paramadwv.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = apvm.a(paramadwv.e, paramadwv.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131364077);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131364080);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131364077);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = apvm.a(this.jdField_a_of_type_AndroidContentContext, i, paramadwv.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
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
  
  private void b(adwv paramadwv)
  {
    Object localObject = this.jdField_a_of_type_Aoyq.b();
    localObject = apuy.a(this.jdField_a_of_type_Aoyq.a(), this.jdField_a_of_type_Aoyq.b(), (String)localObject);
    int i = ((apuz)localObject).jdField_a_of_type_Int;
    int j = ((apuz)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramadwv.e = i;
      paramadwv.f = j;
      localObject = paramadwv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(paramadwv.e, paramadwv.f);
      paramadwv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == paramadwv.e) && (((ViewGroup.LayoutParams)localObject).height == paramadwv.f))
    {
      return;
      paramadwv.e = this.jdField_c_of_type_Int;
      paramadwv.f = this.d;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramadwv.e;
    ((ViewGroup.LayoutParams)localObject).height = paramadwv.f;
    paramadwv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(adwv paramadwv, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Aoyq.c();
    if (i == 1)
    {
      if (!bbdx.b(this.jdField_a_of_type_Aoyq.b()))
      {
        b(paramadwv);
        a(paramadwv);
        paramadwv.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if (paramadwv.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          paramadwv.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
          ((RelativeLayout)paramadwv.jdField_a_of_type_AndroidViewView).removeView(paramadwv.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
      }
      return;
    }
    if (i == 3)
    {
      a(paramadwv, true);
      paramadwv.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    if (i == 4)
    {
      a(paramadwv, false);
      return;
    }
    a(paramadwv, false);
  }
  
  public acui a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (adwv.class.isInstance(paramView))) {
        return ((adwv)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected View a(acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    Object localObject1;
    if ((paramacuj instanceof adwv))
    {
      localObject1 = (adwv)paramacuj;
      paramacuj = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramacuj;
      if (paramacuj == null)
      {
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacuj = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramacuj.e = true;
        }
        paramacuj.setId(2131371608);
        paramacuj.setAdjustViewBounds(true);
        paramacuj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramacuj.setRadius(15.0F);
        paramacuj.d(false);
        paramacuj.setShowEdge(true);
        ((RelativeLayout)localObject1).addView(paramacuj, new RelativeLayout.LayoutParams(-2, -2));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramacuj;
        paramacuj = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131368272);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
        Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        paramacuj.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramacuj.setVisibility(8);
        ((RelativeLayout)localObject1).addView(paramacuj, new RelativeLayout.LayoutParams(-1, -1));
        paramView.jdField_a_of_type_AndroidWidgetFrameLayout = paramacuj;
        paramacuj = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacuj.setOrientation(1);
        paramacuj.setGravity(1);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((RelativeLayout)localObject1).addView(paramacuj, (ViewGroup.LayoutParams)localObject2);
        paramView.jdField_c_of_type_AndroidViewView = paramacuj;
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setImageResource(2130839140);
        paramacuj.addView((View)localObject2, new LinearLayout.LayoutParams(actj.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setText(2131692525);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramacuj.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setOnClickListener(this);
        super.a((View)localObject1, paramacxj);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a(paramView, paramBaseChatItemLayout);
      return localObject1;
      paramView = new adwv(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramacuj.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramacuj.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramacuj.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Ambg = paramacuj.jdField_a_of_type_Ambg;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramacuj.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramacuj.jdField_b_of_type_Int;
      paramView.jdField_c_of_type_Int = paramacuj.jdField_c_of_type_Int;
      paramView.d = paramacuj.d;
      paramView.jdField_a_of_type_JavaLangString = paramacuj.jdField_a_of_type_JavaLangString;
      paramacuj = null;
    }
  }
  
  protected List<Integer> a(bbmf parambbmf, acva paramacva)
  {
    return this.jdField_a_of_type_Aoyq.a(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aoyq.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131370493: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected acuj b()
  {
    return new adwv(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bbfh.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692520);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692517);
  }
  
  protected List<Integer> b(bbmf parambbmf, acva paramacva)
  {
    return this.jdField_a_of_type_Aoyq.b(2);
  }
  
  protected void d(View paramView)
  {
    if (paramView.getId() == 2131364109)
    {
      paramView = actj.a(paramView);
      if (paramView == null) {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
      }
    }
    else
    {
      return;
    }
    if (!adwv.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (adwv)paramView;
    this.jdField_a_of_type_Aoyq.a(2, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwu
 * JD-Core Version:    0.7.0.1
 */