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

public class ahom
  extends ahoo
{
  private Drawable a;
  private float jdField_b_of_type_Float = 0.5625F;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d = BaseChatItemLayout.f;
  
  public ahom(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = ((int)(BaseChatItemLayout.f * this.jdField_b_of_type_Float));
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new agxw(Color.argb(255, 242, 242, 242), 255, f * 14.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localBitmap = null;
      if (!(beyq.b() instanceof SkinnableBitmapDrawable)) {
        break label59;
      }
      localBitmap = ((SkinnableBitmapDrawable)beyq.b()).getBitmap();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ascx(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label59:
      if ((beyq.b() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)beyq.b()).getBitmap();
      }
    }
  }
  
  private Drawable a(ahon paramahon)
  {
    Object localObject = this.jdField_a_of_type_Attx.b();
    if (bhmi.b((String)localObject))
    {
      i = this.jdField_a_of_type_Attx.a();
      int j = this.jdField_a_of_type_Attx.b();
      if ((i == 0) || (j == 0)) {
        a(paramahon, (String)localObject);
      }
      Drawable localDrawable1 = a(paramahon.e, paramahon.f);
      Drawable localDrawable2 = a(paramahon.e, paramahon.f);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      paramahon = localDrawable1;
      if (localObject != null) {
        paramahon = beyq.a((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return paramahon;
    }
    int i = this.jdField_a_of_type_Attx.f();
    if (i == 1)
    {
      a(paramahon, i);
      return a();
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Attx.a();
      return a(paramahon.e, paramahon.f);
    }
    this.jdField_a_of_type_Attx.a();
    paramahon.jdField_c_of_type_AndroidViewView.setVisibility(0);
    return a();
  }
  
  private void a(ahon paramahon)
  {
    FrameLayout localFrameLayout = paramahon.jdField_a_of_type_AndroidWidgetFrameLayout;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368804);
      localTextView.setText(2131692953);
      localTextView.setCompoundDrawablePadding(agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130849764, 0, 0);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramahon.e, paramahon.f));
      return;
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(ahon paramahon, int paramInt)
  {
    FrameLayout localFrameLayout;
    if (paramInt == 1)
    {
      localFrameLayout = paramahon.jdField_a_of_type_AndroidWidgetFrameLayout;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT < 16) {
        break label158;
      }
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368804);
      localTextView.setText(2131692194);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(agej.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844833);
      localDrawable.setBounds(0, 0, agej.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramahon.e, paramahon.f));
      return;
      label158:
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(ahon paramahon, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramahon.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      paramahon.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    b(paramahon);
    paramahon.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = a(paramahon);
    paramahon.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    localObject = bhmi.a(this.jdField_a_of_type_Attx.a());
    a(this.jdField_a_of_type_Attx.a(), (String)localObject, paramahon);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramahon, paramBaseChatItemLayout);
  }
  
  private void a(ahon paramahon, String paramString)
  {
    if (!bhmi.b(paramString)) {
      return;
    }
    paramString = aunj.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramahon.e = i;
      paramahon.f = j;
      this.jdField_a_of_type_Attx.a(i, j);
    }
    b(paramahon);
  }
  
  private void a(ahon paramahon, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramahon.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
      {
        localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
        localPicProgressView.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.a);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(6, 2131372628);
        localLayoutParams.addRule(8, 2131372628);
        localLayoutParams.addRule(5, 2131372628);
        localLayoutParams.addRule(7, 2131372628);
        ((RelativeLayout)paramahon.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        paramahon.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        paramahon.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramahon.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahon.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramahon.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (paramahon.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramahon.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.jdField_a_of_type_Attx.e());
      }
    }
    if (!paramahon.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramahon.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahon.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      ((RelativeLayout)paramahon.jdField_a_of_type_AndroidViewView).removeView(paramahon.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramahon.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    paramahon.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private void a(String paramString1, String paramString2, ahon paramahon)
  {
    if (paramahon.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramahon.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramahon.jdField_a_of_type_AndroidViewView).removeView(paramahon.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131366627);
    localRelativeLayout.setBackgroundResource(2130839121);
    paramahon.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, agej.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131372628);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131372628);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131372628);
    ((RelativeLayout)paramahon.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = auoo.a(paramahon.e, paramahon.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131364391);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131364394);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131364391);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = auoo.a(this.jdField_a_of_type_AndroidContentContext, i, paramahon.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
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
  
  private void b(ahon paramahon)
  {
    Object localObject = this.jdField_a_of_type_Attx.b();
    localObject = auob.a(this.jdField_a_of_type_Attx.a(), this.jdField_a_of_type_Attx.b(), (String)localObject);
    int i = ((auoc)localObject).jdField_a_of_type_Int;
    int j = ((auoc)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramahon.e = i;
      paramahon.f = j;
      localObject = paramahon.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(paramahon.e, paramahon.f);
      paramahon.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == paramahon.e) && (((ViewGroup.LayoutParams)localObject).height == paramahon.f))
    {
      return;
      paramahon.e = this.jdField_c_of_type_Int;
      paramahon.f = this.d;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramahon.e;
    ((ViewGroup.LayoutParams)localObject).height = paramahon.f;
    paramahon.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(ahon paramahon, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Attx.c();
    if (i == 1)
    {
      if (!bhmi.b(this.jdField_a_of_type_Attx.b()))
      {
        b(paramahon);
        a(paramahon);
        paramahon.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if (paramahon.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          paramahon.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
          ((RelativeLayout)paramahon.jdField_a_of_type_AndroidViewView).removeView(paramahon.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
      }
      return;
    }
    if (i == 3)
    {
      a(paramahon, true);
      paramahon.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    if (i == 4)
    {
      a(paramahon, false);
      return;
    }
    a(paramahon, false);
  }
  
  public aggk a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (ahon.class.isInstance(paramView))) {
        return ((ahon)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected View a(aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    Object localObject1;
    if ((paramaggl instanceof ahon))
    {
      localObject1 = (ahon)paramaggl;
      paramaggl = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramaggl;
      if (paramaggl == null)
      {
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaggl = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramaggl.e = true;
        }
        paramaggl.setId(2131372628);
        paramaggl.setAdjustViewBounds(true);
        paramaggl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramaggl.setRadius(15.0F);
        paramaggl.d(false);
        paramaggl.setShowEdge(true);
        ((RelativeLayout)localObject1).addView(paramaggl, new RelativeLayout.LayoutParams(-2, -2));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramaggl;
        paramaggl = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131368804);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
        Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        paramaggl.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramaggl.setVisibility(8);
        ((RelativeLayout)localObject1).addView(paramaggl, new RelativeLayout.LayoutParams(-1, -1));
        paramView.jdField_a_of_type_AndroidWidgetFrameLayout = paramaggl;
        paramaggl = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaggl.setOrientation(1);
        paramaggl.setGravity(1);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((RelativeLayout)localObject1).addView(paramaggl, (ViewGroup.LayoutParams)localObject2);
        paramView.jdField_c_of_type_AndroidViewView = paramaggl;
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setImageResource(2130839410);
        paramaggl.addView((View)localObject2, new LinearLayout.LayoutParams(agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setText(2131692196);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = agej.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramaggl.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setOnClickListener(this);
        super.a((View)localObject1, paramagjk);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a(paramView, paramBaseChatItemLayout);
      return localObject1;
      paramView = new ahon(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramaggl.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramaggl.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramaggl.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Aqkt = paramaggl.jdField_a_of_type_Aqkt;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramaggl.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramaggl.jdField_b_of_type_Int;
      paramView.jdField_c_of_type_Int = paramaggl.jdField_c_of_type_Int;
      paramView.d = paramaggl.d;
      paramView.jdField_a_of_type_JavaLangString = paramaggl.jdField_a_of_type_JavaLangString;
      paramaggl = null;
    }
  }
  
  protected List<Integer> a(bhuk parambhuk, aghd paramaghd)
  {
    return this.jdField_a_of_type_Attx.a(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Attx.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131371487: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected aggl b()
  {
    return new ahon(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bhnt.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692191);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692188);
  }
  
  protected List<Integer> b(bhuk parambhuk, aghd paramaghd)
  {
    return this.jdField_a_of_type_Attx.b(2);
  }
  
  protected void e(View paramView)
  {
    if (paramView.getId() == 2131364423)
    {
      paramView = agej.a(paramView);
      if (paramView == null) {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
      }
    }
    else
    {
      return;
    }
    if (!ahon.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (ahon)paramView;
    this.jdField_a_of_type_Attx.a(2, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahom
 * JD-Core Version:    0.7.0.1
 */