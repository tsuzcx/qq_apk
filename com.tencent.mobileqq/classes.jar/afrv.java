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

public class afrv
  extends aekw
{
  View.OnClickListener a;
  
  public afrv(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afrw(this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    if (swh.a(paramString1, paramContext)) {
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
    paramString1.putExtra("assignBackText", paramContext.getResources().getString(2131690623));
    paramString1.putExtra("puin", paramString4);
    if (paramLong >= 0L) {
      paramString1.putExtra("msg_id", String.valueOf(paramLong));
    }
    paramString1.putExtra("source_name", paramString5);
    paramString1.putExtra("fromAio", true);
    paramString1.putExtra("uin_type", 1008);
    paramString1.putExtra("big_brother_source_key", syb.b(paramString4));
    syb.a(paramString1, paramString3);
    paramContext.startActivity(paramString1);
    azmj.b(null, "P_CliOper", "Pb_account_lifeservice", paramString4, "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString3, "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    int i = 0;
    paramString2 = Uri.parse(paramString2);
    paramString1 = paramString2.getScheme();
    paramString2 = paramString2.getHost();
    if ((!TextUtils.isEmpty(paramString1)) && (bfij.a(paramString1)))
    {
      ayup localayup = new ayup();
      if (ayup.a(paramString2) == 0) {}
      Bundle localBundle;
      int j;
      for (;;)
      {
        localBundle = ayup.a(paramString2);
        j = localBundle.getInt("a_launch_mode", 268435456);
        if (i == 0) {
          break;
        }
        localayup.a(paramQQAppInterface, paramContext, String.valueOf(paramLong), paramString2, paramString1, j);
        return true;
        i = 1;
      }
      return bfij.a(paramContext, paramString1, localBundle, j);
    }
    return false;
  }
  
  protected aekx a()
  {
    return new afrx(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramLinearLayout.setPadding(0, aekt.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = paramView;
    if (paramView == null) {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558778, null);
    }
    paramView = (MessageForPubAccount)paramMessageRecord;
    paramaekx = (afrx)paramaekx;
    View localView = paramLinearLayout.findViewById(2131371510);
    Object localObject5 = (TextView)paramLinearLayout.findViewById(2131371496);
    Object localObject2 = (TextView)paramLinearLayout.findViewById(2131371512);
    Object localObject3 = (TextView)paramLinearLayout.findViewById(2131371511);
    Object localObject1 = (ImageView)paramLinearLayout.findViewById(2131371509);
    Object localObject6 = (TextView)paramLinearLayout.findViewById(2131371501);
    Object localObject7 = (TextView)paramLinearLayout.findViewById(2131371502);
    Object localObject8 = (TextView)paramLinearLayout.findViewById(2131371503);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(2131371504);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(2131371505);
    Object localObject4 = (TextView)paramLinearLayout.findViewById(2131371507);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject6);
    localArrayList.add(localObject7);
    localArrayList.add(localObject8);
    localArrayList.add(localTextView1);
    localArrayList.add(localTextView2);
    localObject6 = paramView.mPAMessage;
    label392:
    int i;
    long l;
    if (((PAMessage)localObject6).grayTips != null)
    {
      ((TextView)localObject5).setText(((PAMessage)localObject6).grayTips);
      ((TextView)localObject5).setVisibility(0);
      localObject5 = (PAMessage.Item)((PAMessage)localObject6).items.get(0);
      paramaekx.jdField_c_of_type_JavaLangString = ((PAMessage.Item)localObject5).url;
      paramaekx.jdField_b_of_type_JavaLangString = ((PAMessage.Item)localObject5).actionUrl;
      paramaekx.jdField_a_of_type_JavaLangString = ((PAMessage.Item)localObject5).nativeJumpString;
      paramaekx.jdField_c_of_type_Int = ((PAMessage)localObject6).type;
      paramaekx.jdField_b_of_type_Int = 5;
      paramaekx.jdField_a_of_type_JavaLangObject = Long.valueOf(paramView.uniseq);
      paramaekx.d = ((PAMessage)localObject6).moreText;
      paramaekx.jdField_a_of_type_Long = ((PAMessage.Item)localObject5).appId;
      paramaekx.e = ((PAMessage.Item)localObject5).actionData;
      paramaekx.f = ((PAMessage.Item)localObject5).a_actionData;
      paramaekx.g = ((PAMessage.Item)localObject5).i_actionData;
      if (TextUtils.isEmpty(((PAMessage)localObject6).moreText)) {
        break label817;
      }
      ((TextView)localObject4).setText(((PAMessage)localObject6).moreText);
      localObject4 = ndq.c(((PAMessage.Item)localObject5).title);
      ((TextView)localObject2).setText((CharSequence)localObject4);
      if (((PAMessage.Item)localObject5).mVideoFlag == 1)
      {
        localObject7 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842291);
        i = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        ((Drawable)localObject7).setBounds(i, 0, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + i, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
        localObject8 = new SpannableString((String)localObject4 + "1");
        ((SpannableString)localObject8).setSpan(new ImageSpan((Drawable)localObject7, 0), ((String)localObject4).length(), ((String)localObject4).length() + 1, 17);
        ((TextView)localObject2).setText((CharSequence)localObject8);
      }
      if (((PAMessage.Item)localObject5).time == 0L) {
        break label828;
      }
      l = ((PAMessage.Item)localObject5).time;
      label559:
      if (l == 0L) {
        break label838;
      }
      ((TextView)localObject3).setText(bdjj.a(this.jdField_a_of_type_AndroidContentContext, l * 1000L));
      ((TextView)localObject3).setVisibility(0);
    }
    for (;;)
    {
      try
      {
        localObject2 = swu.a(((PAMessage.Item)localObject5).cover, 0);
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        int j = aekt.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        int k = aekt.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
              label817:
              ((TextView)localObject4).setText(2131695103);
              break label392;
              label828:
              l = ((PAMessage)localObject6).sendTime;
              break label559;
              label838:
              ((TextView)localObject3).setVisibility(8);
              continue;
            }
          }
        }
      }
      catch (Exception paramMessageRecord)
      {
        ((ImageView)localObject1).setImageResource(2130837967);
        continue;
        ((TextView)localObject1).setVisibility(8);
        continue;
        localView.setTag(paramaekx);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setOnTouchListener(paramaeov);
        localView.setOnLongClickListener(paramaeov);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) != null) && (((aluw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramView.mPAMessage.items != null) && (paramView.mPAMessage.items.size() > 0)) {
          yvu.a(paramView.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localObject4 });
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
    paramContext = acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      syb.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public bdlb[] a(View paramView)
  {
    paramView = new bdkz();
    paramView.a(2131365069, this.jdField_a_of_type_AndroidContentContext.getString(2131690760), 2130838672);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrv
 * JD-Core Version:    0.7.0.1
 */