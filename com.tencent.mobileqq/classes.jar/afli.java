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
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class afli
  extends afjv
  implements View.OnClickListener
{
  public long a;
  private akbo jdField_a_of_type_Akbo;
  private String jdField_a_of_type_JavaLangString;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private long b;
  
  public afli(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((atyt)paramatyy).a.getSystemMsg();
    this.jdField_b_of_type_Long = ((atyt)paramatyy).a.uniseq;
    this.jdField_a_of_type_Bfvm = a(paramContext);
    this.jdField_a_of_type_Akbo = ((akbo)paramQQAppInterface.getManager(34));
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
      for (paramaipp = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();; paramaipp = null)
      {
        if (this.jdField_a_of_type_Long != 0L)
        {
          this.jdField_a_of_type_JavaLangString = bbcl.c(paramQQAppInterface, String.valueOf(this.jdField_a_of_type_Long));
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            paramQQAppInterface = (ajvi)paramQQAppInterface.a(6);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(this.jdField_a_of_type_Long);
            }
            if (QLog.isColorLevel())
            {
              paramatyy = Locale.getDefault();
              long l = this.jdField_a_of_type_Long;
              if (paramQQAppInterface != null) {
                break label341;
              }
              paramQQAppInterface = "handler is null";
              QLog.i("addFriendTag", 2, String.format(paramatyy, "SystemMsgItemBuilder need get discuss info %d  %s", new Object[] { Long.valueOf(l), paramQQAppInterface }));
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString, paramaipp }));
        }
        for (;;)
        {
          this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131297274);
          return;
          paramQQAppInterface = "handler is not null";
          break;
          this.jdField_a_of_type_JavaLangString = null;
          this.jdField_a_of_type_Long = 0L;
        }
      }
    }
  }
  
  private void a(aflj paramaflj)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgItemBuilder", 2, "handleBuddySystemMsg! start " + paramaflj.jdField_a_of_type_Long);
    }
    int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (atyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaflj.h.getText().toString(), "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
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
    case 2: 
    case 3: 
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
        ((Intent)localObject2).putExtra("infoid", paramaflj.jdField_a_of_type_Long);
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
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843B", "0X800843B", 0, 0, "", "", "", "");
        }
        a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject2, 227);
        this.jdField_a_of_type_Akbo.g();
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    }
    paramaflj = new Intent();
    paramaflj.putExtra("param_wzry_data", localWZRYUIinfo);
    aflh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramaflj);
  }
  
  private void a(aflj paramaflj, int paramInt, View.OnClickListener paramOnClickListener)
  {
    Object localObject3 = null;
    paramaflj.jdField_a_of_type_Long = paramInt;
    paramaflj.jdField_f_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    paramaflj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    String str1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    Object localObject1 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
    localObject1 = ((ajxn)localObject1).b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    if ((localObject1 != null) && (!TextUtils.isEmpty(((Friends)localObject1).remark))) {
      localObject2 = ((Friends)localObject1).remark;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (atyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_game_nick.has())
        {
          String str2 = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_game_nick.get().toByteArray());
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str2)) {
            localObject1 = KplRoleInfo.WZRYUIinfo.buildNickName((String)localObject2, str2);
          }
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = str1;
      }
      paramaflj.h.setText((CharSequence)localObject2);
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.has()) {}
      for (localObject1 = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.get().toByteArray());; localObject1 = null)
      {
        label387:
        label645:
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramaflj.n.setVisibility(8);
          if ((TextUtils.isEmpty(str1)) || (!bbbd.b(str1))) {
            break label830;
          }
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841313);
          ((Drawable)localObject1).setBounds(0, 0, actn.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramaflj.h.setCompoundDrawables(null, null, (Drawable)localObject1, null);
          paramaflj.h.setCompoundDrawablePadding(actn.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          if (QLog.isColorLevel()) {
            QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|position is : " + paramInt + ",name is : " + (String)localObject2 + ",source is : " + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
          }
          this.jdField_a_of_type_Aipp.a(paramaflj);
          paramaflj.jdField_f_of_type_AndroidWidgetImageView.setTag(paramaflj);
          paramaflj.l.setVisibility(8);
          localObject1 = localObject3;
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label870;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break label844;
          }
          localObject1 = String.format(Locale.getDefault(), ajyc.a(2131714707), new Object[] { localObject1, this.jdField_a_of_type_JavaLangString });
          label560:
          paramaflj.j.setText((CharSequence)localObject1);
          paramaflj.j.setVisibility(0);
          label577:
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get())) {
              break label905;
            }
            if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_qna.get())) {
              break label882;
            }
            paramaflj.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_qna.get());
            paramInt = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
            if (QLog.isColorLevel()) {
              QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|myAllowFlag : " + paramInt);
            }
            switch (paramInt)
            {
            }
          }
        }
        for (;;)
        {
          paramaflj.jdField_a_of_type_AndroidWidgetButton.setTag(paramaflj);
          paramaflj.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
          return;
          paramaflj.n.setVisibility(0);
          localObject1 = "（" + (String)localObject1 + "）";
          paramaflj.n.setText((CharSequence)localObject1);
          break;
          label830:
          paramaflj.h.setCompoundDrawables(null, null, null, null);
          break label387;
          label844:
          localObject1 = String.format(Locale.getDefault(), ajyc.a(2131714710), new Object[] { localObject1 });
          break label560;
          label870:
          paramaflj.j.setVisibility(8);
          break label577;
          label882:
          paramaflj.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
          break label645;
          label905:
          paramaflj.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
          break label645;
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaflj.k.setVisibility(8);
            paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            localObject1 = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
            paramaflj.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
          }
          for (;;)
          {
            b(paramaflj);
            break;
            if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() == 0))
            {
              paramaflj.k.setVisibility(0);
              localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
              paramaflj.k.setText((CharSequence)localObject1);
              paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
          }
          paramaflj.k.setVisibility(0);
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramaflj.k.setText((CharSequence)localObject1);
          paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaflj);
          continue;
          paramaflj.k.setVisibility(0);
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramaflj.k.setText((CharSequence)localObject1);
          paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaflj);
          continue;
          paramaflj.k.setVisibility(8);
          paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramaflj.k.setVisibility(8);
          paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))
          {
            paramaflj.j.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
            paramaflj.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
          }
          for (;;)
          {
            paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramaflj.k.setVisibility(8);
            break;
            paramaflj.j.setVisibility(8);
          }
          paramaflj.k.setVisibility(0);
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramaflj.k.setText((CharSequence)localObject1);
          paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaflj);
          continue;
          paramaflj.k.setVisibility(0);
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramaflj.k.setText((CharSequence)localObject1);
          paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaflj.k.setVisibility(8);
            paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            localObject1 = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
            paramaflj.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
          }
          for (;;)
          {
            b(paramaflj);
            break;
            paramaflj.k.setVisibility(0);
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
            paramaflj.k.setText((CharSequence)localObject1);
            paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaflj.k.setVisibility(8);
            paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            localObject1 = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
            paramaflj.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
          }
          for (;;)
          {
            b(paramaflj);
            break;
            paramaflj.k.setVisibility(0);
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
            paramaflj.k.setText((CharSequence)localObject1);
            paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.has()) {
            if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 1)
            {
              paramaflj.k.setVisibility(0);
              localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
              paramaflj.k.setText((CharSequence)localObject1);
              paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
            else if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 2)
            {
              paramaflj.k.setVisibility(8);
              paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              continue;
              paramaflj.k.setVisibility(0);
              localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
              paramaflj.k.setText((CharSequence)localObject1);
              paramaflj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramaflj.j.setVisibility(8);
            }
          }
        }
      }
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      ayda.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      ayda.a().b(l);
      ayda.a().a(paramLong);
    }
  }
  
  private void b(aflj paramaflj)
  {
    int i = -1;
    int j = 0;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has()) {
      j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get();
    }
    a(paramaflj.l, i, j, null);
  }
  
  protected int a()
  {
    return ((atyt)this.jdField_a_of_type_Atyy).a.mSysmsgMenuFlag;
  }
  
  public View a(int paramInt, View paramView)
  {
    aflj localaflj;
    if ((paramView == null) || (!(paramView.getTag() instanceof aflj)))
    {
      localaflj = new aflj();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561123, localaflj);
      a(paramView, this.jdField_b_of_type_Int);
      localaflj.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaflj.h = ((TextView)paramView.findViewById(2131370832));
      localaflj.n = ((TextView)paramView.findViewById(2131376296));
      localaflj.i = ((TextView)paramView.findViewById(2131375194));
      localaflj.l = ((TextView)paramView.findViewById(2131362196));
      localaflj.j = ((TextView)paramView.findViewById(2131376339));
      localaflj.k = ((TextView)paramView.findViewById(2131375191));
      localaflj.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375181));
      b(localaflj.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaflj);
      localaflj.g.setTag(localaflj);
      localaflj.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atyy, localaflj, this);
      if (this.jdField_a_of_type_Atyy.a()) {
        break label288;
      }
      a(localaflj.g, true);
      if (bbbd.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826D", "0X800826D", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      a(localaflj, paramInt, this);
      return paramView;
      localaflj = (aflj)paramView.getTag();
      break;
      label288:
      a(localaflj.g, false);
    }
  }
  
  protected void a()
  {
    MessageForSystemMsg localMessageForSystemMsg = ((atyt)this.jdField_a_of_type_Atyy).a;
    this.jdField_a_of_type_Aipp.a.j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, localMessageForSystemMsg.frienduin, localMessageForSystemMsg.istroop, localMessageForSystemMsg.uniseq);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
    if (atyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843D", "0X800843D", 0, 0, "", "", "", "");
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
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = paramView.getTag();
          } while ((paramView == null) || (!(paramView instanceof aflj)));
          paramView = (aflj)paramView;
        } while (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() != 1);
        a(paramView);
        switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
        {
        default: 
          return;
        case 1: 
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80076FF", "0X80076FF", 0, 0, "", "", "", "");
          return;
        case 2: 
        case 3: 
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007701", "0X8007701", 0, 0, "", "", "", "");
          return;
        case 13: 
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007702", "0X8007702", 0, 0, "", "", "", "");
          return;
        }
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007703", "0X8007703", 0, 0, "", "", "", "");
        return;
        paramView = paramView.getTag();
      } while ((paramView == null) || (!(paramView instanceof aflj)));
      if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
      {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(c());
        return;
      }
      paramView = (aflj)paramView;
      a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
      long l1 = ayda.a().b();
      paramView = ayda.a().a(Long.valueOf(l1));
      if (paramView == null) {
        break label817;
      }
      i = paramView.msg_type.get();
      l1 = paramView.msg_seq.get();
      long l2 = paramView.req_uin.get();
      int j = paramView.msg.sub_type.get();
      int k = paramView.msg.src_id.get();
      int m = paramView.msg.sub_src_id.get();
      int n = paramView.msg.group_msg_type.get();
      localObject = paramView.msg.actions.get();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).remark.set("");
      ((structmsg.SystemMsgActionInfo)localObject).group_id.set(0);
      structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
      localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
      localAddFrdSNInfo.uint32_set_sn.set(0);
      ((structmsg.SystemMsgActionInfo)localObject).addFrdSNInfo.set(localAddFrdSNInfo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 0, paramView, false);
      i = 1;
      if (i != 0) {
        this.jdField_a_of_type_Aipp.a.a.c();
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007700", "0X8007700", 0, 0, "", "", "", "");
      if (bbbd.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
      }
    } while (!atyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true));
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843C", "0X800843C", 0, 0, "", "", "", "");
    return;
    paramView = new StringBuilder().append("agree, ");
    if (localObject != null)
    {
      i = ((List)localObject).size();
      label793:
      QLog.d("SystemMsgItemBuilder", 1, i);
    }
    for (;;)
    {
      i = 0;
      break;
      i = -1;
      break label793;
      label817:
      QLog.d("SystemMsgItemBuilder", 1, "agree");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afli
 * JD-Core Version:    0.7.0.1
 */