import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.open.adapter.OpenAppClient;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ahmw
  extends agem
{
  View.OnClickListener a;
  
  public ahmw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahmx(this);
  }
  
  private void a(ahmy paramahmy, ChatMessage paramChatMessage, long paramLong)
  {
    if ((paramahmy == null) || (paramChatMessage == null)) {}
    label25:
    oek localoek;
    ofe localofe;
    label93:
    label226:
    label232:
    label255:
    do
    {
      return;
      String str;
      bhmr localbhmr;
      int i;
      if (TextUtils.isEmpty(paramahmy.f))
      {
        str = paramahmy.e;
        localoek = (oek)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
        localofe = (ofe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
        if (TextUtils.isEmpty(str)) {
          break label467;
        }
        localbhmr = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str);
        if (localbhmr != null) {
          break label296;
        }
        if (paramahmy.jdField_a_of_type_Long != 0L) {
          break label226;
        }
        i = 0;
        if (i == 0) {
          break label255;
        }
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmy.jdField_a_of_type_JavaLangString, paramahmy.jdField_a_of_type_Long, str)) {
          break label232;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmy.jdField_a_of_type_JavaLangString, paramahmy.jdField_b_of_type_JavaLangString, paramahmy.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
      }
      for (;;)
      {
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_32", "singlepic_allclick");
        if ((paramChatMessage == null) || (localoek == null) || (localofe == null) || (!localoek.a(paramChatMessage.senderuin))) {
          break;
        }
        localofe.a(false, paramChatMessage, 1, str);
        return;
        str = paramahmy.f;
        break label25;
        i = 1;
        break label93;
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
        continue;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmy.jdField_a_of_type_JavaLangString, paramahmy.jdField_b_of_type_JavaLangString, paramahmy.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        continue;
        if (TextUtils.isEmpty(localbhmr.a()))
        {
          if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmy.jdField_a_of_type_JavaLangString, paramahmy.jdField_a_of_type_Long, str)) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmy.jdField_a_of_type_JavaLangString, paramahmy.jdField_b_of_type_JavaLangString, paramahmy.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
          } else {
            PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
          }
        }
        else if (!localbhmr.a()) {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmy.jdField_a_of_type_JavaLangString, paramahmy.jdField_b_of_type_JavaLangString, paramahmy.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        } else {
          PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_33", "singlepic_mqqclick");
        }
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmy.jdField_a_of_type_JavaLangString, paramahmy.jdField_b_of_type_JavaLangString, paramahmy.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
    } while ((paramChatMessage == null) || (localoek == null) || (localofe == null) || (!localoek.a(paramChatMessage.senderuin)));
    label296:
    label467:
    localofe.a(false, paramChatMessage, 1, paramahmy.jdField_c_of_type_JavaLangString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    if (txr.a(paramString1, paramContext)) {
      return;
    }
    if ((paramString2 != null) && (paramString2.equals("open_local")))
    {
      paramString1 = new Bundle();
      paramString1.putString("schemaurl", paramString3);
      paramString1.putString("uin", paramQQAppInterface.getCurrentAccountUin());
      OpenAppClient.b((Activity)paramContext, paramString1);
      return;
    }
    paramString1 = new Intent(paramContext, PublicAccountBrowser.class);
    paramString1.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramString1.putExtra("url", paramString3);
    paramString1.putExtra("assignBackText", paramContext.getResources().getString(2131690559));
    paramString1.putExtra("puin", paramString4);
    if (paramLong >= 0L) {
      paramString1.putExtra("msg_id", String.valueOf(paramLong));
    }
    paramString1.putExtra("source_name", paramString5);
    paramString1.putExtra("fromAio", true);
    paramString1.putExtra("uin_type", 1008);
    paramString1.putExtra("big_brother_source_key", tzq.b(paramString4));
    tzq.a(paramString1, paramString3);
    paramContext.startActivity(paramString1);
    bdll.b(null, "P_CliOper", "Pb_account_lifeservice", paramString4, "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString3, "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    int i = 0;
    paramString2 = Uri.parse(paramString2);
    paramString1 = paramString2.getScheme();
    paramString2 = paramString2.getHost();
    if ((!TextUtils.isEmpty(paramString1)) && (bjva.a(paramString1)))
    {
      bcqt localbcqt = new bcqt();
      if (bcqt.a(paramString2) == 0) {}
      Bundle localBundle;
      int j;
      for (;;)
      {
        localBundle = bcqt.a(paramString2);
        j = localBundle.getInt("a_launch_mode", 268435456);
        if (i == 0) {
          break;
        }
        localbcqt.a(paramQQAppInterface, paramContext, String.valueOf(paramLong), paramString2, paramString1, j);
        return true;
        i = 1;
      }
      return bjva.a(paramContext, paramString1, localBundle, j);
    }
    return false;
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPubAccount))
    {
      paramChatMessage = (MessageForPubAccount)paramChatMessage;
      if ((paramChatMessage.mPAMessage != null) && (paramChatMessage.mPAMessage.mMsgId > 0L))
      {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramChatMessage.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramChatMessage.mPAMessage.mMsgId), "", "", "");
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) != null) && (((aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramChatMessage.mPAMessage.items != null) && (paramChatMessage.mPAMessage.items.size() > 0))
        {
          String str = ((PAMessage.Item)paramChatMessage.mPAMessage.items.get(0)).title;
          abbe.a(paramChatMessage.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, str });
        }
      }
    }
  }
  
  protected agen a()
  {
    return new ahmy(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramLinearLayout.setPadding(0, agej.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = paramView;
    if (paramView == null) {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558840, null);
    }
    paramView = (MessageForPubAccount)paramMessageRecord;
    paramagen = (ahmy)paramagen;
    View localView = paramLinearLayout.findViewById(2131372214);
    Object localObject5 = (TextView)paramLinearLayout.findViewById(2131372200);
    Object localObject2 = (TextView)paramLinearLayout.findViewById(2131372216);
    Object localObject3 = (TextView)paramLinearLayout.findViewById(2131372215);
    Object localObject1 = (ImageView)paramLinearLayout.findViewById(2131372213);
    Object localObject6 = (TextView)paramLinearLayout.findViewById(2131372205);
    Object localObject7 = (TextView)paramLinearLayout.findViewById(2131372206);
    Object localObject8 = (TextView)paramLinearLayout.findViewById(2131372207);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(2131372208);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(2131372209);
    Object localObject4 = (TextView)paramLinearLayout.findViewById(2131372211);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject6);
    localArrayList.add(localObject7);
    localArrayList.add(localObject8);
    localArrayList.add(localTextView1);
    localArrayList.add(localTextView2);
    localObject6 = paramView.mPAMessage;
    label405:
    int i;
    long l;
    if (((PAMessage)localObject6).grayTips != null)
    {
      ((TextView)localObject5).setText(((PAMessage)localObject6).grayTips);
      ((TextView)localObject5).setVisibility(0);
      localObject5 = (PAMessage.Item)((PAMessage)localObject6).items.get(0);
      paramagen.jdField_c_of_type_JavaLangString = ((PAMessage.Item)localObject5).url;
      paramagen.jdField_b_of_type_JavaLangString = ((PAMessage.Item)localObject5).actionUrl;
      paramagen.jdField_a_of_type_JavaLangString = ((PAMessage.Item)localObject5).nativeJumpString;
      paramagen.jdField_c_of_type_Int = ((PAMessage)localObject6).type;
      paramagen.jdField_b_of_type_Int = 5;
      paramagen.jdField_a_of_type_JavaLangObject = Long.valueOf(paramView.uniseq);
      paramagen.d = ((PAMessage)localObject6).moreText;
      paramagen.jdField_a_of_type_Long = ((PAMessage.Item)localObject5).appId;
      paramagen.e = ((PAMessage.Item)localObject5).actionData;
      paramagen.f = ((PAMessage.Item)localObject5).a_actionData;
      paramagen.g = ((PAMessage.Item)localObject5).i_actionData;
      if (TextUtils.isEmpty(((PAMessage)localObject6).moreText)) {
        break label830;
      }
      ((TextView)localObject4).setText(((PAMessage)localObject6).moreText);
      localObject4 = noe.c(((PAMessage.Item)localObject5).title);
      ((TextView)localObject2).setText((CharSequence)localObject4);
      if (((PAMessage.Item)localObject5).mVideoFlag == 1)
      {
        localObject7 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842627);
        i = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        ((Drawable)localObject7).setBounds(i, 0, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + i, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
        localObject8 = new SpannableString((String)localObject4 + "1");
        ((SpannableString)localObject8).setSpan(new ImageSpan((Drawable)localObject7, 0), ((String)localObject4).length(), ((String)localObject4).length() + 1, 17);
        ((TextView)localObject2).setText((CharSequence)localObject8);
      }
      if (((PAMessage.Item)localObject5).time == 0L) {
        break label841;
      }
      l = ((PAMessage.Item)localObject5).time;
      label572:
      if (l == 0L) {
        break label851;
      }
      ((TextView)localObject3).setText(bhsw.a(this.jdField_a_of_type_AndroidContentContext, l * 1000L));
      ((TextView)localObject3).setVisibility(0);
    }
    for (;;)
    {
      try
      {
        localObject2 = tye.a(((PAMessage.Item)localObject5).cover, 0);
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        int j = agej.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        int k = agej.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (i - j);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = k;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
        ((URLDrawable.URLDrawableOptions)localObject3).mGifRoundCorner = 0.0F;
        ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = paramMessageRecord;
        paramMessageRecord = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        paramMessageRecord.addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((ImageView)localObject1).setImageDrawable(paramMessageRecord);
        paramMessageRecord = ((PAMessage.Item)localObject5).digestList;
        if (paramMessageRecord != null)
        {
          i = paramMessageRecord.size();
          j = 0;
          if (j < localArrayList.size())
          {
            localObject1 = (TextView)localArrayList.get(j);
            if (i > j)
            {
              ((TextView)localObject1).setText((CharSequence)paramMessageRecord.get(j));
              ((TextView)localObject1).setVisibility(0);
              j += 1;
              continue;
              ((TextView)localObject5).setVisibility(8);
              break;
              label830:
              ((TextView)localObject4).setText(2131694183);
              break label405;
              label841:
              l = ((PAMessage)localObject6).sendTime;
              break label572;
              label851:
              ((TextView)localObject3).setVisibility(8);
              continue;
            }
          }
        }
      }
      catch (Exception paramMessageRecord)
      {
        ((ImageView)localObject1).setImageResource(2130838072);
        continue;
        ((TextView)localObject1).setVisibility(8);
        continue;
        localView.setTag(paramagen);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setOnTouchListener(paramagjk);
        localView.setOnLongClickListener(paramagjk);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) != null) && (((aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramView.mPAMessage.items != null) && (paramView.mPAMessage.items.size() > 0)) {
          abbe.a(paramView.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localObject4 });
        }
        return paramLinearLayout;
      }
      i = 0;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramContext = aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      tzq.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public bhum[] a(View paramView)
  {
    paramView = new bhuk();
    paramView.a(2131365352, this.jdField_a_of_type_AndroidContentContext.getString(2131690639), 2130838934);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmw
 * JD-Core Version:    0.7.0.1
 */