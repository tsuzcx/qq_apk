import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Locale;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class ajat
  extends aiyz
  implements View.OnClickListener
{
  public long a;
  private aizi jdField_a_of_type_Aizi;
  private String jdField_a_of_type_JavaLangString;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private long b;
  
  public ajat(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((ajbi)paramajbn).a.getSystemMsg();
    this.jdField_b_of_type_Long = ((ajbi)paramajbn).a.uniseq;
    this.jdField_a_of_type_Blfk = a(paramContext);
    this.jdField_a_of_type_Aizi = ((aizi)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.has()) {}
    for (int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get();; i = 0)
    {
      if ((i & 0x8) == 8)
      {
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.has()) {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.get();
        }
        if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
          break label362;
        }
      }
      label343:
      label362:
      for (paramajav = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();; paramajav = null)
      {
        if (this.jdField_a_of_type_Long != 0L)
        {
          this.jdField_a_of_type_JavaLangString = ContactUtils.getDiscussionNameCanNull(paramQQAppInterface, String.valueOf(this.jdField_a_of_type_Long));
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            paramQQAppInterface = (antl)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(this.jdField_a_of_type_Long);
            }
            if (QLog.isColorLevel())
            {
              paramajbn = Locale.getDefault();
              long l = this.jdField_a_of_type_Long;
              if (paramQQAppInterface != null) {
                break label343;
              }
              paramQQAppInterface = "handler is null";
              QLog.i("addFriendTag", 2, String.format(paramajbn, "SystemMsgItemBuilder need get discuss info %d  %s", new Object[] { Long.valueOf(l), paramQQAppInterface }));
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString, paramajav }));
        }
        for (;;)
        {
          this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131297424);
          return;
          paramQQAppInterface = "handler is not null";
          break;
          this.jdField_a_of_type_JavaLangString = null;
          this.jdField_a_of_type_Long = 0L;
        }
      }
    }
  }
  
  private void a(ajau paramajau)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgItemBuilder", 2, "handleBuddySystemMsg! start " + paramajau.jdField_a_of_type_Long);
    }
    int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (ajbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramajau.h.getText().toString(), "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    switch (j)
    {
    case 11: 
    default: 
      i = 0;
    case 1: 
    case 9: 
    case 10: 
    case 0: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      for (;;)
      {
        Object localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramajau.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843B", "0X800843B", 0, 0, "", "", "", "");
        }
        a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject2, 227);
        this.jdField_a_of_type_Aizi.g();
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    case 2: 
    case 3: 
      ajas.a(this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      return;
    }
    paramajau = new Intent();
    paramajau.putExtra("param_wzry_data", localWZRYUIinfo);
    ajas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramajau);
  }
  
  private void a(ajau paramajau, int paramInt, View.OnClickListener paramOnClickListener)
  {
    paramajau.jdField_a_of_type_Long = paramInt;
    paramajau.jdField_f_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    paramajau.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    a(paramajau, paramInt, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    this.jdField_a_of_type_Ajav.a(paramajau);
    paramajau.jdField_f_of_type_AndroidWidgetImageView.setTag(paramajau);
    paramajau.l.setVisibility(8);
    f(paramajau);
    a(paramajau, paramOnClickListener);
  }
  
  private void a(ajau paramajau, int paramInt, String paramString)
  {
    Object localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
    localObject1 = ((anvk)localObject1).b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    if ((localObject1 != null) && (!TextUtils.isEmpty(((Friends)localObject1).remark))) {
      localObject2 = ((Friends)localObject1).remark;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (ajbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_game_nick.has())
        {
          String str = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_game_nick.get().toByteArray());
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = KplRoleInfo.WZRYUIinfo.buildNickName((String)localObject2, str);
          }
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramString;
      }
      paramajau.h.setText((CharSequence)localObject2);
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.has()) {}
      for (localObject1 = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.get().toByteArray());; localObject1 = null)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramajau.n.setVisibility(8);
          if ((TextUtils.isEmpty(paramString)) || (!bhbx.b(paramString))) {
            break label447;
          }
          paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841803);
          paramString.setBounds(0, 0, AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramajau.h.setCompoundDrawables(null, null, paramString, null);
          paramajau.h.setCompoundDrawablePadding(AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|position is : " + paramInt + ",name is : " + (String)localObject2 + ",source is : " + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
          }
          return;
          paramajau.n.setVisibility(0);
          localObject1 = "（" + (String)localObject1 + "）";
          paramajau.n.setText((CharSequence)localObject1);
          break;
          label447:
          paramajau.h.setCompoundDrawables(null, null, null, null);
        }
      }
    }
  }
  
  private void a(ajau paramajau, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
    {
      e(paramajau);
      int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|myAllowFlag : " + i);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      paramajau.jdField_a_of_type_AndroidWidgetButton.setTag(paramajau);
      paramajau.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      return;
      b(paramajau);
      continue;
      paramajau.k.setVisibility(0);
      String str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramajau.k.setText(str);
      paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      g(paramajau);
      continue;
      paramajau.k.setVisibility(8);
      paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      d(paramajau);
      continue;
      paramajau.k.setVisibility(0);
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramajau.k.setText(str);
      paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      c(paramajau);
      continue;
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.has()) {
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 1)
        {
          paramajau.k.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramajau.k.setText(str);
          paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        else if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 2)
        {
          paramajau.k.setVisibility(8);
          paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramajau.k.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramajau.k.setText(str);
          paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramajau.j.setVisibility(8);
        }
      }
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bdzx.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      bdzx.a().b(l);
      bdzx.a().a(paramLong);
    }
  }
  
  private void b(ajau paramajau)
  {
    String str;
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
    {
      paramajau.k.setVisibility(8);
      paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
      paramajau.jdField_a_of_type_AndroidWidgetButton.setText(str);
    }
    for (;;)
    {
      g(paramajau);
      return;
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() == 0))
      {
        paramajau.k.setVisibility(0);
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
        paramajau.k.setText(str);
        paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
  }
  
  private void c(ajau paramajau)
  {
    String str;
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
    {
      paramajau.k.setVisibility(8);
      paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
      paramajau.jdField_a_of_type_AndroidWidgetButton.setText(str);
    }
    for (;;)
    {
      g(paramajau);
      return;
      paramajau.k.setVisibility(0);
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramajau.k.setText(str);
      paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  private void d(ajau paramajau)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))
    {
      paramajau.j.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
      paramajau.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
    }
    for (;;)
    {
      paramajau.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramajau.k.setVisibility(8);
      return;
      paramajau.j.setVisibility(8);
    }
  }
  
  private void e(ajau paramajau)
  {
    paramajau.i.setText(ajbi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg));
  }
  
  private void f(ajau paramajau)
  {
    String str = null;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
    }
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (str = String.format(Locale.getDefault(), anvx.a(2131714090), new Object[] { str, this.jdField_a_of_type_JavaLangString });; str = String.format(Locale.getDefault(), anvx.a(2131714093), new Object[] { str }))
      {
        paramajau.j.setText(str);
        paramajau.j.setVisibility(0);
        return;
      }
    }
    paramajau.j.setVisibility(8);
  }
  
  private void g(ajau paramajau)
  {
    int i = -1;
    int j = 0;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has()) {
      j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get();
    }
    a(paramajau.l, i, j, null);
  }
  
  protected int a()
  {
    return ((ajbi)this.jdField_a_of_type_Ajbn).a.mSysmsgMenuFlag;
  }
  
  public View a(int paramInt, View paramView)
  {
    ajau localajau;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajau)))
    {
      localajau = new ajau();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561541, localajau);
      a(paramView, this.jdField_b_of_type_Int);
      localajau.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localajau.h = ((TextView)paramView.findViewById(2131371981));
      localajau.n = ((TextView)paramView.findViewById(2131377860));
      localajau.i = ((TextView)paramView.findViewById(2131376609));
      localajau.l = ((TextView)paramView.findViewById(2131362310));
      localajau.j = ((TextView)paramView.findViewById(2131377905));
      localajau.k = ((TextView)paramView.findViewById(2131376606));
      localajau.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376596));
      b(localajau.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localajau);
      localajau.g.setTag(localajau);
      localajau.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajbn, localajau, this);
      if (this.jdField_a_of_type_Ajbn.a()) {
        break label288;
      }
      a(localajau.g, true);
      if (bhbx.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826D", "0X800826D", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      a(localajau, paramInt, this);
      return paramView;
      localajau = (ajau)paramView.getTag();
      break;
      label288:
      a(localajau.g, false);
    }
  }
  
  protected void a()
  {
    MessageForSystemMsg localMessageForSystemMsg = ((ajbi)this.jdField_a_of_type_Ajbn).a;
    this.jdField_a_of_type_Ajav.a.j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, localMessageForSystemMsg.frienduin, localMessageForSystemMsg.istroop, localMessageForSystemMsg.uniseq);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
    if (ajbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843D", "0X800843D", 0, 0, "", "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    int i;
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof ajau)))
      {
        localObject1 = (ajau)localObject1;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 1)
        {
          a((ajau)localObject1);
          switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
          {
          default: 
            break;
          case 1: 
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80076FF", "0X80076FF", 0, 0, "", "", "", "");
            break;
          case 2: 
          case 3: 
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007701", "0X8007701", 0, 0, "", "", "", "");
            break;
          case 13: 
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007702", "0X8007702", 0, 0, "", "", "", "");
            break;
          case 6: 
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007703", "0X8007703", 0, 0, "", "", "", "");
            continue;
            localObject1 = paramView.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof ajau))) {
              if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692125), 0).b(c());
              }
              else
              {
                localObject1 = (ajau)localObject1;
                a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
                long l1 = bdzx.a().b();
                localObject1 = bdzx.a().a(Long.valueOf(l1));
                if (localObject1 == null) {
                  break label865;
                }
                i = ((structmsg.StructMsg)localObject1).msg_type.get();
                l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
                long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
                int j = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
                int k = ((structmsg.StructMsg)localObject1).msg.src_id.get();
                int m = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
                int n = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
                localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
                if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
                  break label812;
                }
                localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
                ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
                ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
                structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
                localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
                localAddFrdSNInfo.uint32_set_sn.set(0);
                ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
                i = 1;
                if (i != 0) {
                  this.jdField_a_of_type_Ajav.a.a.c();
                }
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007700", "0X8007700", 0, 0, "", "", "", "");
                if (bhbx.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
                  bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                }
                if (ajbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
                  bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843C", "0X800843C", 0, 0, "", "", "", "");
                }
              }
            }
            break;
          }
        }
      }
    }
    label812:
    Object localObject1 = new StringBuilder().append("agree, ");
    if (localObject2 != null)
    {
      i = ((List)localObject2).size();
      label840:
      QLog.d("SystemMsgItemBuilder", 1, i);
    }
    for (;;)
    {
      i = 0;
      break;
      i = -1;
      break label840;
      label865:
      QLog.d("SystemMsgItemBuilder", 1, "agree");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajat
 * JD-Core Version:    0.7.0.1
 */