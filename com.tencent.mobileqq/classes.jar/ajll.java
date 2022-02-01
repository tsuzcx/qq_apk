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
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class ajll
  extends ajjr
  implements View.OnClickListener
{
  public long a;
  private ajka jdField_a_of_type_Ajka;
  private String jdField_a_of_type_JavaLangString;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private long b;
  
  public ajll(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((ajma)paramajmf).a.getSystemMsg();
    this.jdField_b_of_type_Long = ((ajma)paramajmf).a.uniseq;
    this.jdField_a_of_type_Blpv = a(paramContext);
    this.jdField_a_of_type_Ajka = ((ajka)paramQQAppInterface.getManager(34));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.has()) {}
    for (int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get();; i = 0)
    {
      if ((i & 0x8) == 8)
      {
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.has()) {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.get();
        }
        if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
          break label360;
        }
      }
      label341:
      label360:
      for (paramajln = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();; paramajln = null)
      {
        if (this.jdField_a_of_type_Long != 0L)
        {
          this.jdField_a_of_type_JavaLangString = bhlg.c(paramQQAppInterface, String.valueOf(this.jdField_a_of_type_Long));
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            paramQQAppInterface = (anwo)paramQQAppInterface.a(6);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(this.jdField_a_of_type_Long);
            }
            if (QLog.isColorLevel())
            {
              paramajmf = Locale.getDefault();
              long l = this.jdField_a_of_type_Long;
              if (paramQQAppInterface != null) {
                break label341;
              }
              paramQQAppInterface = "handler is null";
              QLog.i("addFriendTag", 2, String.format(paramajmf, "SystemMsgItemBuilder need get discuss info %d  %s", new Object[] { Long.valueOf(l), paramQQAppInterface }));
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString, paramajln }));
        }
        for (;;)
        {
          this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131297368);
          return;
          paramQQAppInterface = "handler is not null";
          break;
          this.jdField_a_of_type_JavaLangString = null;
          this.jdField_a_of_type_Long = 0L;
        }
      }
    }
  }
  
  private void a(ajlm paramajlm)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgItemBuilder", 2, "handleBuddySystemMsg! start " + paramajlm.jdField_a_of_type_Long);
    }
    int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (ajma.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramajlm.h.getText().toString(), "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
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
        ((Intent)localObject2).putExtra("infoid", paramajlm.jdField_a_of_type_Long);
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
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843B", "0X800843B", 0, 0, "", "", "", "");
        }
        a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject2, 227);
        this.jdField_a_of_type_Ajka.g();
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    case 2: 
    case 3: 
      ajlk.a(this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      return;
    }
    paramajlm = new Intent();
    paramajlm.putExtra("param_wzry_data", localWZRYUIinfo);
    ajlk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramajlm);
  }
  
  private void a(ajlm paramajlm, int paramInt, View.OnClickListener paramOnClickListener)
  {
    paramajlm.jdField_a_of_type_Long = paramInt;
    paramajlm.jdField_f_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    paramajlm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    a(paramajlm, paramInt, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    this.jdField_a_of_type_Ajln.a(paramajlm);
    paramajlm.jdField_f_of_type_AndroidWidgetImageView.setTag(paramajlm);
    paramajlm.l.setVisibility(8);
    f(paramajlm);
    a(paramajlm, paramOnClickListener);
  }
  
  private void a(ajlm paramajlm, int paramInt, String paramString)
  {
    Object localObject1 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
    localObject1 = ((anyw)localObject1).b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    if ((localObject1 != null) && (!TextUtils.isEmpty(((Friends)localObject1).remark))) {
      localObject2 = ((Friends)localObject1).remark;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (ajma.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true))
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
      paramajlm.h.setText((CharSequence)localObject2);
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.has()) {}
      for (localObject1 = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.get().toByteArray());; localObject1 = null)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramajlm.n.setVisibility(8);
          if ((TextUtils.isEmpty(paramString)) || (!bhjx.b(paramString))) {
            break label446;
          }
          paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841751);
          paramString.setBounds(0, 0, agej.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramajlm.h.setCompoundDrawables(null, null, paramString, null);
          paramajlm.h.setCompoundDrawablePadding(agej.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|position is : " + paramInt + ",name is : " + (String)localObject2 + ",source is : " + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
          }
          return;
          paramajlm.n.setVisibility(0);
          localObject1 = "（" + (String)localObject1 + "）";
          paramajlm.n.setText((CharSequence)localObject1);
          break;
          label446:
          paramajlm.h.setCompoundDrawables(null, null, null, null);
        }
      }
    }
  }
  
  private void a(ajlm paramajlm, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
    {
      e(paramajlm);
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
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setTag(paramajlm);
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      return;
      b(paramajlm);
      continue;
      paramajlm.k.setVisibility(0);
      String str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramajlm.k.setText(str);
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      g(paramajlm);
      continue;
      paramajlm.k.setVisibility(8);
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      d(paramajlm);
      continue;
      paramajlm.k.setVisibility(0);
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramajlm.k.setText(str);
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      c(paramajlm);
      continue;
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.has()) {
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 1)
        {
          paramajlm.k.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramajlm.k.setText(str);
          paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        else if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 2)
        {
          paramajlm.k.setVisibility(8);
          paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramajlm.k.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramajlm.k.setText(str);
          paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramajlm.j.setVisibility(8);
        }
      }
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bdzh.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      bdzh.a().b(l);
      bdzh.a().a(paramLong);
    }
  }
  
  private void b(ajlm paramajlm)
  {
    String str;
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
    {
      paramajlm.k.setVisibility(8);
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setText(str);
    }
    for (;;)
    {
      g(paramajlm);
      return;
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() == 0))
      {
        paramajlm.k.setVisibility(0);
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
        paramajlm.k.setText(str);
        paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
  }
  
  private void c(ajlm paramajlm)
  {
    String str;
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
    {
      paramajlm.k.setVisibility(8);
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setText(str);
    }
    for (;;)
    {
      g(paramajlm);
      return;
      paramajlm.k.setVisibility(0);
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramajlm.k.setText(str);
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  private void d(ajlm paramajlm)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))
    {
      paramajlm.j.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
      paramajlm.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
    }
    for (;;)
    {
      paramajlm.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramajlm.k.setVisibility(8);
      return;
      paramajlm.j.setVisibility(8);
    }
  }
  
  private void e(ajlm paramajlm)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_qna.get()))
      {
        paramajlm.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_qna.get());
        return;
      }
      paramajlm.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
      return;
    }
    paramajlm.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
  }
  
  private void f(ajlm paramajlm)
  {
    String str = null;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
    }
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (str = String.format(Locale.getDefault(), anzj.a(2131713511), new Object[] { str, this.jdField_a_of_type_JavaLangString });; str = String.format(Locale.getDefault(), anzj.a(2131713514), new Object[] { str }))
      {
        paramajlm.j.setText(str);
        paramajlm.j.setVisibility(0);
        return;
      }
    }
    paramajlm.j.setVisibility(8);
  }
  
  private void g(ajlm paramajlm)
  {
    int i = -1;
    int j = 0;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has()) {
      j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get();
    }
    a(paramajlm.l, i, j, null);
  }
  
  protected int a()
  {
    return ((ajma)this.jdField_a_of_type_Ajmf).a.mSysmsgMenuFlag;
  }
  
  public View a(int paramInt, View paramView)
  {
    ajlm localajlm;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajlm)))
    {
      localajlm = new ajlm();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561601, localajlm);
      a(paramView, this.jdField_b_of_type_Int);
      localajlm.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localajlm.h = ((TextView)paramView.findViewById(2131371827));
      localajlm.n = ((TextView)paramView.findViewById(2131377816));
      localajlm.i = ((TextView)paramView.findViewById(2131376588));
      localajlm.l = ((TextView)paramView.findViewById(2131362302));
      localajlm.j = ((TextView)paramView.findViewById(2131377861));
      localajlm.k = ((TextView)paramView.findViewById(2131376585));
      localajlm.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376575));
      b(localajlm.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localajlm);
      localajlm.g.setTag(localajlm);
      localajlm.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajmf, localajlm, this);
      if (this.jdField_a_of_type_Ajmf.a()) {
        break label288;
      }
      a(localajlm.g, true);
      if (bhjx.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826D", "0X800826D", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      a(localajlm, paramInt, this);
      return paramView;
      localajlm = (ajlm)paramView.getTag();
      break;
      label288:
      a(localajlm.g, false);
    }
  }
  
  protected void a()
  {
    MessageForSystemMsg localMessageForSystemMsg = ((ajma)this.jdField_a_of_type_Ajmf).a;
    this.jdField_a_of_type_Ajln.a.j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, localMessageForSystemMsg.frienduin, localMessageForSystemMsg.istroop, localMessageForSystemMsg.uniseq);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
    if (ajma.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843D", "0X800843D", 0, 0, "", "", "", "");
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
      if ((localObject1 != null) && ((localObject1 instanceof ajlm)))
      {
        localObject1 = (ajlm)localObject1;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 1)
        {
          a((ajlm)localObject1);
          switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
          {
          default: 
            break;
          case 1: 
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80076FF", "0X80076FF", 0, 0, "", "", "", "");
            break;
          case 2: 
          case 3: 
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007701", "0X8007701", 0, 0, "", "", "", "");
            break;
          case 13: 
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007702", "0X8007702", 0, 0, "", "", "", "");
            break;
          case 6: 
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007703", "0X8007703", 0, 0, "", "", "", "");
            continue;
            localObject1 = paramView.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof ajlm))) {
              if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691989), 0).b(c());
              }
              else
              {
                localObject1 = (ajlm)localObject1;
                a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
                long l1 = bdzh.a().b();
                localObject1 = bdzh.a().a(Long.valueOf(l1));
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
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
                i = 1;
                if (i != 0) {
                  this.jdField_a_of_type_Ajln.a.a.c();
                }
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007700", "0X8007700", 0, 0, "", "", "", "");
                if (bhjx.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                }
                if (ajma.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843C", "0X800843C", 0, 0, "", "", "", "");
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
 * Qualified Name:     ajll
 * JD-Core Version:    0.7.0.1
 */