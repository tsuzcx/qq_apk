import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.widget.PAImageView;
import java.util.ArrayList;

public class advh
  extends actq
{
  View.OnClickListener a;
  
  public advh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new advi(this);
  }
  
  protected actr a()
  {
    return new advj(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxn);
    if (paramChatMessage != null)
    {
      paramChatMessage.setId(2131364110);
      paramChatMessage.setClickable(true);
      paramChatMessage.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
    }
    return paramChatMessage;
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)paramView).setOrientation(1);
    paramLinearLayout = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = paramLinearLayout.mPAMessage;
    int k = (int)(0.5D * BaseChatItemLayout.d);
    ArrayList localArrayList = localPAMessage.items;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    Object localObject1;
    if (localPAMessage.grayTips != null)
    {
      paramactr = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramactr.setText(localPAMessage.grayTips);
      paramactr.setGravity(17);
      paramactr.setSingleLine();
      paramactr.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).leftMargin = bawz.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).topMargin = bawz.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = bawz.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = bawz.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).gravity = 17;
      paramactr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramactr.setBackgroundResource(2130843961);
      paramactr.setPadding(bawz.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), bawz.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), bawz.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), bawz.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
      paramactr.setTextColor(-1);
      paramactr.setTextSize(12.0F);
      localViewGroup.addView(paramactr);
    }
    int i = 0;
    label365:
    Object localObject2;
    if (i < localArrayList.size())
    {
      localObject1 = new advj(this);
      PAMessage.Item localItem = (PAMessage.Item)localArrayList.get(i);
      ((advj)localObject1).jdField_b_of_type_Int = 5;
      ((advj)localObject1).jdField_c_of_type_JavaLangString = localItem.url;
      ((advj)localObject1).jdField_c_of_type_Int = localPAMessage.type;
      ((advj)localObject1).jdField_b_of_type_JavaLangString = localItem.actionUrl;
      ((advj)localObject1).jdField_a_of_type_JavaLangString = localItem.nativeJumpString;
      ((advj)localObject1).jdField_a_of_type_Long = paramLinearLayout.uniseq;
      ((advj)localObject1).d = i;
      Object localObject3;
      int j;
      if (i == 0)
      {
        paramactr = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558741, null);
        localObject3 = (TextView)paramactr.findViewById(2131371188);
        localObject2 = (ImageView)paramactr.findViewById(2131371187);
        if ((i == 0) && ((localObject2 instanceof PAImageView))) {
          ((PAImageView)localObject2).setUseRadiusRound(true, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296351));
        }
        String str = nax.c(localItem.title);
        ((TextView)localObject3).setText(str);
        if (localItem.mVideoFlag == 1)
        {
          Object localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (i != 0) {
            break label937;
          }
          j = 2130842136;
          label467:
          localObject4 = ((Resources)localObject4).getDrawable(j);
          j = bawz.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
          ((Drawable)localObject4).setBounds(j, 0, bawz.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + j, bawz.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
          SpannableString localSpannableString = new SpannableString(str + "1");
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject4, 0), str.length(), str.length() + 1, 17);
          ((TextView)localObject3).setText(localSpannableString);
        }
      }
      for (;;)
      {
        try
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject3).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = paramMessageRecord;
          if (i != 0) {
            continue;
          }
          j = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
          int m = actn.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          int n = actn.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (j - m);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = n;
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(sfd.a(localItem.cover, 0), (URLDrawable.URLDrawableOptions)localObject3));
        }
        catch (Exception localException)
        {
          label937:
          ((ImageView)localObject2).setImageResource(2130837911);
          continue;
        }
        localViewGroup.addView(paramactr);
        paramactr.setTag(localObject1);
        paramactr.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramactr.setOnTouchListener(paramacxn);
        paramactr.setOnLongClickListener(paramacxn);
        i += 1;
        break;
        if (i == localArrayList.size() - 1)
        {
          paramactr = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = bawz.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramactr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramactr.setBackgroundResource(2131165817);
          localViewGroup.addView(paramactr);
          paramactr = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558739, null);
          break label365;
        }
        if (i != 1)
        {
          paramactr = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = bawz.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramactr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramactr.setBackgroundResource(2131165817);
          localViewGroup.addView(paramactr);
        }
        paramactr = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558740, null);
        break label365;
        j = 2130842137;
        break label467;
        j = actn.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      }
    }
    paramView.setBackgroundResource(2130838136);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) != null) && (((akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramLinearLayout.mPAMessage.items != null) && (paramLinearLayout.mPAMessage.items.size() > 0)) {
      xhe.a(paramLinearLayout.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)paramLinearLayout.mPAMessage.items.get(0)).title });
    }
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    paramContext = aaod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      aaod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      sgj.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public bblt[] a(View paramView)
  {
    paramView = new bblr();
    paramView.a(2131364985, this.jdField_a_of_type_AndroidContentContext.getString(2131690708), 2130838601);
    a(paramView);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     advh
 * JD-Core Version:    0.7.0.1
 */