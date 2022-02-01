import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.PAImageView;
import java.util.ArrayList;

public class agjg
  extends aexf
{
  View.OnClickListener a;
  
  public agjg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agjh(this);
  }
  
  private void a(MessageForPubAccount paramMessageForPubAccount, agji paramagji, long paramLong, String paramString)
  {
    if ((paramagji == null) || (paramMessageForPubAccount == null)) {}
    do
    {
      return;
      if (paramLong > 0L) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramMessageForPubAccount.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramLong), "", "", "");
      }
      ofx localofx = (ofx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      ogr localogr = (ogr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(88);
      if ((localofx != null) && (localogr != null) && (localofx.a(paramMessageForPubAccount.senderuin))) {
        localogr.a(false, paramMessageForPubAccount, paramagji.d + 1, paramString);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) == null) || (!((amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (paramMessageForPubAccount.mPAMessage.items == null) || (paramMessageForPubAccount.mPAMessage.items.size() <= 0));
    zxp.a(paramMessageForPubAccount.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, ((PAMessage.Item)paramMessageForPubAccount.mPAMessage.items.get(0)).title });
  }
  
  private void a(PAMessage.Item paramItem, agji paramagji, String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bfvp localbfvp = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
      int i;
      if (localbfvp == null) {
        if (paramItem.appId != 0L)
        {
          i = 1;
          if (i == 0) {
            break label155;
          }
          if (agjj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            break label132;
          }
          agjj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramagji.jdField_a_of_type_JavaLangString, paramagji.jdField_b_of_type_JavaLangString, paramagji.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, paramLong);
        }
      }
      for (;;)
      {
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "Pb_account_lifeservice", "mp_msg_sys_35", "singlepic_allclick");
        return;
        i = 0;
        break;
        label132:
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
        continue;
        label155:
        agjj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramagji.jdField_a_of_type_JavaLangString, paramagji.jdField_b_of_type_JavaLangString, paramagji.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, paramLong);
        continue;
        if (TextUtils.isEmpty(localbfvp.a()))
        {
          if (!agjj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            agjj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramagji.jdField_a_of_type_JavaLangString, paramagji.jdField_b_of_type_JavaLangString, paramagji.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, paramLong);
          } else {
            PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
          }
        }
        else if (!localbfvp.a()) {
          agjj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramagji.jdField_a_of_type_JavaLangString, paramagji.jdField_b_of_type_JavaLangString, paramagji.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, paramLong);
        } else {
          PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "Pb_account_lifeservice", "mp_msg_sys_36", "singlepic_mqqclick");
        }
      }
    }
    agjj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramagji.jdField_a_of_type_JavaLangString, paramagji.jdField_b_of_type_JavaLangString, paramagji.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, paramLong);
  }
  
  protected aexg a()
  {
    return new agji(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afce paramafce)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafce);
    if (paramChatMessage != null)
    {
      paramChatMessage.setId(2131364441);
      paramChatMessage.setClickable(true);
      paramChatMessage.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
    }
    return paramChatMessage;
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
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
      paramaexg = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramaexg.setText(localPAMessage.grayTips);
      paramaexg.setGravity(17);
      paramaexg.setSingleLine();
      paramaexg.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).leftMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).topMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).gravity = 17;
      paramaexg.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramaexg.setBackgroundResource(2130844661);
      paramaexg.setPadding(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 9.0F), DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 4.0F), DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 9.0F), DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 4.0F));
      paramaexg.setTextColor(-1);
      paramaexg.setTextSize(12.0F);
      localViewGroup.addView(paramaexg);
    }
    int i = 0;
    label376:
    Object localObject2;
    if (i < localArrayList.size())
    {
      localObject1 = new agji(this);
      PAMessage.Item localItem = (PAMessage.Item)localArrayList.get(i);
      ((agji)localObject1).jdField_b_of_type_Int = 5;
      ((agji)localObject1).jdField_c_of_type_JavaLangString = localItem.url;
      ((agji)localObject1).jdField_c_of_type_Int = localPAMessage.type;
      ((agji)localObject1).jdField_b_of_type_JavaLangString = localItem.actionUrl;
      ((agji)localObject1).jdField_a_of_type_JavaLangString = localItem.nativeJumpString;
      ((agji)localObject1).jdField_a_of_type_Long = paramLinearLayout.uniseq;
      ((agji)localObject1).d = i;
      Object localObject3;
      int j;
      if (i == 0)
      {
        paramaexg = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558847, null);
        localObject3 = (TextView)paramaexg.findViewById(2131372169);
        localObject2 = (ImageView)paramaexg.findViewById(2131372168);
        if ((i == 0) && ((localObject2 instanceof PAImageView))) {
          ((PAImageView)localObject2).setUseRadiusRound(true, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296448));
        }
        String str = npn.c(localItem.title);
        ((TextView)localObject3).setText(str);
        if (localItem.mVideoFlag == 1)
        {
          Object localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (i != 0) {
            break label953;
          }
          j = 2130842671;
          label481:
          localObject4 = ((Resources)localObject4).getDrawable(j);
          j = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F);
          ((Drawable)localObject4).setBounds(j, 0, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 17.0F) + j, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 20.0F));
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
          int m = AIOUtils.dp2px(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          int n = AIOUtils.dp2px(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (j - m);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = n;
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(uet.a(localItem.cover, 0), (URLDrawable.URLDrawableOptions)localObject3));
        }
        catch (Exception localException)
        {
          label953:
          ((ImageView)localObject2).setImageResource(2130838097);
          continue;
        }
        localViewGroup.addView(paramaexg);
        paramaexg.setTag(localObject1);
        paramaexg.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramaexg.setOnTouchListener(paramafce);
        paramaexg.setOnLongClickListener(paramafce);
        i += 1;
        break;
        if (i == localArrayList.size() - 1)
        {
          paramaexg = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramaexg.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramaexg.setBackgroundResource(2131165929);
          localViewGroup.addView(paramaexg);
          paramaexg = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558845, null);
          break label376;
        }
        if (i != 1)
        {
          paramaexg = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramaexg.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramaexg.setBackgroundResource(2131165929);
          localViewGroup.addView(paramaexg);
        }
        paramaexg = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558846, null);
        break label376;
        j = 2130842672;
        break label481;
        j = AIOUtils.dp2px(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      }
    }
    paramView.setBackgroundResource(2130838341);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) != null) && (((amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramLinearLayout.mPAMessage.items != null) && (paramLinearLayout.mPAMessage.items.size() > 0)) {
      zxp.a(paramLinearLayout.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, ((PAMessage.Item)paramLinearLayout.mPAMessage.items.get(0)).title });
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
    paramContext = acvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      acvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      ugf.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public bgbb[] a(View paramView)
  {
    paramView = new bgaz();
    paramView.a(2131365382, this.jdField_a_of_type_AndroidContentContext.getString(2131690679), 2130838966);
    a(paramView);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjg
 * JD-Core Version:    0.7.0.1
 */