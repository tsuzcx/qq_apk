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

public class aezs
  extends aeyf
  implements View.OnClickListener
{
  public long a;
  private ajnf jdField_a_of_type_Ajnf;
  private String jdField_a_of_type_JavaLangString;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private long b;
  
  public aezs(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((atcp)paramatcu).a.getSystemMsg();
    this.jdField_b_of_type_Long = ((atcp)paramatcu).a.uniseq;
    this.jdField_a_of_type_Bens = a(paramContext);
    this.jdField_a_of_type_Ajnf = ((ajnf)paramQQAppInterface.getManager(34));
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
      for (paramaicw = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();; paramaicw = null)
      {
        if (this.jdField_a_of_type_Long != 0L)
        {
          this.jdField_a_of_type_JavaLangString = babh.c(paramQQAppInterface, String.valueOf(this.jdField_a_of_type_Long));
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            paramQQAppInterface = (ajhf)paramQQAppInterface.a(6);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(this.jdField_a_of_type_Long);
            }
            if (QLog.isColorLevel())
            {
              paramatcu = Locale.getDefault();
              long l = this.jdField_a_of_type_Long;
              if (paramQQAppInterface != null) {
                break label341;
              }
              paramQQAppInterface = "handler is null";
              QLog.i("addFriendTag", 2, String.format(paramatcu, "SystemMsgItemBuilder need get discuss info %d  %s", new Object[] { Long.valueOf(l), paramQQAppInterface }));
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString, paramaicw }));
        }
        for (;;)
        {
          this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131166193);
          return;
          paramQQAppInterface = "handler is not null";
          break;
          this.jdField_a_of_type_JavaLangString = null;
          this.jdField_a_of_type_Long = 0L;
        }
      }
    }
  }
  
  private void a(aezt paramaezt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgItemBuilder", 2, "handleBuddySystemMsg! start " + paramaezt.jdField_a_of_type_Long);
    }
    int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (atcp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaezt.h.getText().toString(), "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
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
        ((Intent)localObject2).putExtra("infoid", paramaezt.jdField_a_of_type_Long);
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
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843B", "0X800843B", 0, 0, "", "", "", "");
        }
        a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject2, 227);
        this.jdField_a_of_type_Ajnf.g();
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    }
    paramaezt = new Intent();
    paramaezt.putExtra("param_wzry_data", localWZRYUIinfo);
    aezr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramaezt);
  }
  
  private void a(aezt paramaezt, int paramInt, View.OnClickListener paramOnClickListener)
  {
    Object localObject3 = null;
    paramaezt.jdField_a_of_type_Long = paramInt;
    paramaezt.jdField_f_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    paramaezt.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    String str1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    Object localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
    localObject1 = ((ajjj)localObject1).b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    if ((localObject1 != null) && (!TextUtils.isEmpty(((Friends)localObject1).remark))) {
      localObject2 = ((Friends)localObject1).remark;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (atcp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true))
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
      paramaezt.h.setText((CharSequence)localObject2);
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.has()) {}
      for (localObject1 = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.get().toByteArray());; localObject1 = null)
      {
        label387:
        label645:
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramaezt.n.setVisibility(8);
          if ((TextUtils.isEmpty(str1)) || (!azzz.b(str1))) {
            break label830;
          }
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841234);
          ((Drawable)localObject1).setBounds(0, 0, aciy.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramaezt.h.setCompoundDrawables(null, null, (Drawable)localObject1, null);
          paramaezt.h.setCompoundDrawablePadding(aciy.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          if (QLog.isColorLevel()) {
            QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|position is : " + paramInt + ",name is : " + (String)localObject2 + ",source is : " + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
          }
          this.jdField_a_of_type_Aicw.a(paramaezt);
          paramaezt.jdField_f_of_type_AndroidWidgetImageView.setTag(paramaezt);
          paramaezt.l.setVisibility(8);
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
          localObject1 = String.format(Locale.getDefault(), ajjy.a(2131648918), new Object[] { localObject1, this.jdField_a_of_type_JavaLangString });
          label560:
          paramaezt.j.setText((CharSequence)localObject1);
          paramaezt.j.setVisibility(0);
          label577:
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get())) {
              break label905;
            }
            if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_qna.get())) {
              break label882;
            }
            paramaezt.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_qna.get());
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
          paramaezt.jdField_a_of_type_AndroidWidgetButton.setTag(paramaezt);
          paramaezt.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
          return;
          paramaezt.n.setVisibility(0);
          localObject1 = "（" + (String)localObject1 + "）";
          paramaezt.n.setText((CharSequence)localObject1);
          break;
          label830:
          paramaezt.h.setCompoundDrawables(null, null, null, null);
          break label387;
          label844:
          localObject1 = String.format(Locale.getDefault(), ajjy.a(2131648921), new Object[] { localObject1 });
          break label560;
          label870:
          paramaezt.j.setVisibility(8);
          break label577;
          label882:
          paramaezt.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
          break label645;
          label905:
          paramaezt.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
          break label645;
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaezt.k.setVisibility(8);
            paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            localObject1 = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
            paramaezt.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
          }
          for (;;)
          {
            b(paramaezt);
            break;
            if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() == 0))
            {
              paramaezt.k.setVisibility(0);
              localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
              paramaezt.k.setText((CharSequence)localObject1);
              paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
          }
          paramaezt.k.setVisibility(0);
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramaezt.k.setText((CharSequence)localObject1);
          paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaezt);
          continue;
          paramaezt.k.setVisibility(0);
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramaezt.k.setText((CharSequence)localObject1);
          paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaezt);
          continue;
          paramaezt.k.setVisibility(8);
          paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramaezt.k.setVisibility(8);
          paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))
          {
            paramaezt.j.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
            paramaezt.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
          }
          for (;;)
          {
            paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramaezt.k.setVisibility(8);
            break;
            paramaezt.j.setVisibility(8);
          }
          paramaezt.k.setVisibility(0);
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramaezt.k.setText((CharSequence)localObject1);
          paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaezt);
          continue;
          paramaezt.k.setVisibility(0);
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramaezt.k.setText((CharSequence)localObject1);
          paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaezt.k.setVisibility(8);
            paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            localObject1 = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
            paramaezt.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
          }
          for (;;)
          {
            b(paramaezt);
            break;
            paramaezt.k.setVisibility(0);
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
            paramaezt.k.setText((CharSequence)localObject1);
            paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaezt.k.setVisibility(8);
            paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            localObject1 = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
            paramaezt.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
          }
          for (;;)
          {
            b(paramaezt);
            break;
            paramaezt.k.setVisibility(0);
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
            paramaezt.k.setText((CharSequence)localObject1);
            paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.has()) {
            if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 1)
            {
              paramaezt.k.setVisibility(0);
              localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
              paramaezt.k.setText((CharSequence)localObject1);
              paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
            else if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 2)
            {
              paramaezt.k.setVisibility(8);
              paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              continue;
              paramaezt.k.setVisibility(0);
              localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
              paramaezt.k.setText((CharSequence)localObject1);
              paramaezt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramaezt.j.setVisibility(8);
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
      axcy.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      axcy.a().b(l);
      axcy.a().a(paramLong);
    }
  }
  
  private void b(aezt paramaezt)
  {
    int i = -1;
    int j = 0;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has()) {
      j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get();
    }
    a(paramaezt.l, i, j, null);
  }
  
  protected int a()
  {
    return ((atcp)this.jdField_a_of_type_Atcu).a.mSysmsgMenuFlag;
  }
  
  public View a(int paramInt, View paramView)
  {
    aezt localaezt;
    if ((paramView == null) || (!(paramView.getTag() instanceof aezt)))
    {
      localaezt = new aezt();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131495535, localaezt);
      a(paramView, this.jdField_b_of_type_Int);
      localaezt.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296259));
      localaezt.h = ((TextView)paramView.findViewById(2131305159));
      localaezt.n = ((TextView)paramView.findViewById(2131310504));
      localaezt.i = ((TextView)paramView.findViewById(2131309446));
      localaezt.l = ((TextView)paramView.findViewById(2131296655));
      localaezt.j = ((TextView)paramView.findViewById(2131310547));
      localaezt.k = ((TextView)paramView.findViewById(2131309443));
      localaezt.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131309433));
      b(localaezt.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaezt);
      localaezt.g.setTag(localaezt);
      localaezt.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atcu, localaezt, this);
      if (this.jdField_a_of_type_Atcu.a()) {
        break label288;
      }
      a(localaezt.g, true);
      if (azzz.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826D", "0X800826D", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      a(localaezt, paramInt, this);
      return paramView;
      localaezt = (aezt)paramView.getTag();
      break;
      label288:
      a(localaezt.g, false);
    }
  }
  
  protected void a()
  {
    MessageForSystemMsg localMessageForSystemMsg = ((atcp)this.jdField_a_of_type_Atcu).a;
    this.jdField_a_of_type_Aicw.a.j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, localMessageForSystemMsg.frienduin, localMessageForSystemMsg.istroop, localMessageForSystemMsg.uniseq);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
    if (atcp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843D", "0X800843D", 0, 0, "", "", "", "");
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
          } while ((paramView == null) || (!(paramView instanceof aezt)));
          paramView = (aezt)paramView;
        } while (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() != 1);
        a(paramView);
        switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
        {
        default: 
          return;
        case 1: 
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80076FF", "0X80076FF", 0, 0, "", "", "", "");
          return;
        case 2: 
        case 3: 
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007701", "0X8007701", 0, 0, "", "", "", "");
          return;
        case 13: 
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007702", "0X8007702", 0, 0, "", "", "", "");
          return;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007703", "0X8007703", 0, 0, "", "", "", "");
        return;
        paramView = paramView.getTag();
      } while ((paramView == null) || (!(paramView instanceof aezt)));
      if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626719), 0).b(c());
        return;
      }
      paramView = (aezt)paramView;
      a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
      long l1 = axcy.a().b();
      paramView = axcy.a().a(Long.valueOf(l1));
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
        this.jdField_a_of_type_Aicw.a.a.c();
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007700", "0X8007700", 0, 0, "", "", "", "");
      if (azzz.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
      }
    } while (!atcp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true));
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843C", "0X800843C", 0, 0, "", "", "", "");
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
 * Qualified Name:     aezs
 * JD-Core Version:    0.7.0.1
 */