import ActionMsg.MsgBody;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.10;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.mobileqq.widget.PatchedTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PttRec;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aarj
  extends CursorAdapter
{
  protected int a;
  public Context a;
  protected LayoutInflater a;
  protected int b;
  public int c = -1;
  
  public aarj(ChatHistory paramChatHistory, Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramChatHistory.jdField_a_of_type_Float < 1.0F)
    {
      paramChatHistory.g = ((int)(100.0F * paramChatHistory.jdField_a_of_type_Float));
      paramChatHistory.f = ((int)(paramChatHistory.jdField_a_of_type_Float * 34.0F));
      paramChatHistory.h = ((int)(paramChatHistory.jdField_a_of_type_Float * 14.0F));
    }
    for (paramChatHistory.i = ((int)(paramChatHistory.jdField_a_of_type_Float * 15.0F));; paramChatHistory.i = ((int)(paramChatHistory.jdField_a_of_type_Float * 15.0F)))
    {
      paramChatHistory = paramContext.getResources().getDisplayMetrics();
      this.b = Math.min(paramChatHistory.widthPixels, paramChatHistory.heightPixels);
      return;
      paramChatHistory.g = ((int)(120.0F * paramChatHistory.jdField_a_of_type_Float));
      paramChatHistory.f = ((int)(paramChatHistory.jdField_a_of_type_Float * 34.0F));
      paramChatHistory.h = ((int)(paramChatHistory.jdField_a_of_type_Float * 14.0F));
    }
  }
  
  protected int a(int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
    int i;
    if (paramInt >= 60) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g;
    }
    do
    {
      do
      {
        return i;
        if ((paramInt > 45) && (paramInt < 60)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 15 / 16 + (paramInt - 45) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        if ((paramInt > 30) && (paramInt <= 45)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 13 / 16 + (paramInt - 30) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 2 / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        if ((paramInt > 15) && (paramInt <= 30)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 9 / 16 + (paramInt - 15) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 4 / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        i = j;
      } while (paramInt <= 0);
      i = j;
    } while (paramInt > 15);
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * paramInt * 9 / 16 / 15 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
  }
  
  protected String a(long paramLong)
  {
    Time localTime1 = new Time();
    Time localTime2 = new Time();
    localTime1.set(paramLong);
    localTime2.setToNow();
    if (localTime1.year != localTime2.year) {
      return localTime1.format("%Y-%m-%d %H:%M:%S");
    }
    if (localTime1.yearDay != localTime2.yearDay) {
      return localTime1.format("%m-%d %H:%M:%S");
    }
    return localTime1.format("%H:%M:%S");
  }
  
  public void a()
  {
    super.changeCursor(null);
  }
  
  protected void a(abjj paramabjj)
  {
    Object localObject = advu.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramabjj.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    paramabjj.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    paramabjj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    int i = paramabjj.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.msgtype;
    localObject = paramabjj.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.action;
    paramabjj.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new aarr(this, i, paramabjj, (String)localObject));
  }
  
  public void a(Cursor paramCursor, TextView paramTextView1, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, TextView paramTextView2, aart paramaart, ImageView paramImageView1, CharSequence paramCharSequence, ChatThumbView paramChatThumbView, View paramView1, View paramView2, ImageView paramImageView2, long paramLong)
  {
    Object localObject = paramCursor.getString(paramCursor.getColumnIndex("extStr"));
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("Emoji_Sticker_Info"))
      {
        i = new JSONObject(((JSONObject)localObject).getString("Emoji_Sticker_Info")).getInt("msgType");
        if (i != -1000) {
          break label290;
        }
        i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
        paramTextView1.setVisibility(0);
        if (!axas.a(paramInt1))
        {
          paramTextView1.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
          paramTextView1.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
        }
        if (!String.valueOf(ajsf.G).equals(paramString1)) {
          break label184;
        }
        paramCursor = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, paramString2, paramString3, i);
        if (paramCursor != null)
        {
          paramTextView1.setText(paramCursor.message);
          if (paramInt2 == 32769) {
            paramTextView2.setText(paramCursor.troopCode);
          }
        }
      }
    }
    for (;;)
    {
      return;
      label184:
      if (-2008 == i)
      {
        paramTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131719130));
        return;
      }
      if (-1002 == i)
      {
        paramTextView1.setText(paramaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("sens_msg_original_text"));
        return;
      }
      paramInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
      if ((paramImageView1 != null) && (paramInt1 == 32768)) {
        paramImageView1.setVisibility(0);
      }
      paramTextView1.setText(new ayki(paramCharSequence, 13, 32, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int));
      return;
      label290:
      if (i == -2000)
      {
        if ((paramaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
        {
          if (ajwd.a(paramaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
          {
            paramTextView1.setVisibility(0);
            paramTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131691293));
            paramTextView1.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
            paramTextView1.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
            return;
          }
          paramCursor = (MessageForPic)paramaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          paramCursor.parse();
          paramTextView1 = new abjj();
          paramChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
          paramChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
          paramTextView1.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramCursor;
          paramTextView1.jdField_a_of_type_ComTencentImageURLImageView = paramChatThumbView;
          if (QLog.isColorLevel()) {
            QLog.d("history", 2, "bindView pic.path:" + paramCursor.path + ",pic.uuid:" + paramCursor.uuid);
          }
          if ((paramTextView1.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramTextView1.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.path != null)) {
            a(paramTextView1);
          }
        }
        else if ((QLog.isColorLevel()) && (paramaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
        {
          QLog.d("history", 2, "not messageforpicuniseq:" + paramaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ",dbid:" + paramaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getId() + "istroop:" + paramaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop + ",msgtype:" + paramaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype);
        }
      }
      else if (i == -2007)
      {
        paramCursor = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
        try
        {
          paramCursor = akwb.a(paramCursor);
          if ((paramCursor instanceof MarkFaceMessage))
          {
            paramChatThumbView.setVisibility(0);
            paramTextView1.setVisibility(8);
            paramImageView1.setVisibility(8);
            paramView1.setVisibility(8);
            paramView2.setVisibility(8);
            paramChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
            paramChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
            paramChatThumbView.setTag(paramString1 + paramLong);
            paramImageView2.setTag(null);
            a(paramChatThumbView, (MarkFaceMessage)paramCursor, paramImageView2, paramaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            return;
          }
        }
        catch (Exception paramCursor)
        {
          QLog.e("ChatHistory", 1, "dealStikerMessage e = " + paramCursor);
        }
      }
    }
  }
  
  public void a(ImageView paramImageView, int paramInt, aobk paramaobk, MessageRecord paramMessageRecord)
  {
    if (paramaobk == null) {
      paramImageView.setImageResource(2130837710);
    }
    do
    {
      for (;;)
      {
        paramImageView.setOnClickListener(new aarp(this, paramMessageRecord));
        return;
        if (paramInt != 2) {
          break label242;
        }
        if (paramaobk.b()) {
          break;
        }
        paramaobk = paramaobk.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float);
        if (paramaobk != null)
        {
          paramImageView.setImageDrawable(paramaobk);
          paramImageView.setOnClickListener(null);
        }
      }
    } while (paramaobk.a("fromAIO", true) == null);
    paramImageView.setOnClickListener(new aaro(this, paramaobk));
    Object localObject = (View)paramImageView.getParent();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aaru != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aaru.a(0, paramImageView.getTag())))
    {
      paramaobk = anzm.o.replace("[epId]", paramaobk.a.epId).replace("[eId]", paramaobk.a.eId);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aaru.a((View)localObject, paramaobk);
      if (localObject == null) {
        break label450;
      }
    }
    label450:
    for (paramaobk = (ImageView)((View)localObject).findViewById(2131376182);; paramaobk = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(paramaobk);
      break;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131376182);; localObject = null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b((ImageView)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(paramImageView, paramaobk);
        break;
        label242:
        if (paramInt == 1)
        {
          paramaobk = paramaobk.a();
          if (paramaobk == null) {
            break;
          }
          paramImageView.setImageDrawable(paramaobk);
          break;
        }
        if (paramInt == 3)
        {
          aduu localaduu = new aduu();
          paramImageView.setOnClickListener(null);
          localaduu.e = paramImageView;
          localaduu.jdField_a_of_type_Aobk = paramaobk;
          ascc localascc = (ascc)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(83);
          localaduu.jdField_a_of_type_Long = paramaobk.a.getId();
          MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)localaduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          String str = "";
          localObject = str;
          if (localMessageForMarketFace != null)
          {
            localObject = str;
            if (localMessageForMarketFace.mMarkFaceMessage != null)
            {
              localObject = str;
              if (localMessageForMarketFace.mMarkFaceMessage.mobileparam != null)
              {
                localObject = str;
                if (localMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0) {
                  localObject = new String(localMessageForMarketFace.mMarkFaceMessage.mobileparam);
                }
              }
            }
          }
          localascc.a((String)localObject, localaduu, paramaobk.a.getId(), false, false, null);
          break;
        }
        if (paramInt != 0) {
          break;
        }
        paramImageView.setImageResource(2130837710);
        break;
      }
    }
  }
  
  protected void a(ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord)
  {
    if (paramMarkFaceMessage == null)
    {
      a(paramImageView1, 0, null, paramMessageRecord);
      return;
    }
    ((askd)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(14)).a(paramMarkFaceMessage, new aarq(this, paramImageView2, paramMarkFaceMessage, paramImageView1, paramMessageRecord));
  }
  
  public void a(MixedMsgLinearLayout paramMixedMsgLinearLayout, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageForMixedMsg.parse();
    int j = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      if (((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).time == 0L)) {
        MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
      }
      i += 1;
    }
    paramMixedMsgLinearLayout.a(paramMessageForMixedMsg.msgElemList, null);
    Object localObject1 = new acxm();
    ((acxm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    int k = paramMessageForMixedMsg.msgElemList.size();
    i = 0;
    if (i < k)
    {
      Object localObject2 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      View localView = paramMixedMsgLinearLayout.getChildAt(i);
      Object localObject3;
      if ((localObject2 instanceof MessageForText))
      {
        localObject3 = (AnimationTextView)localView;
        ((AnimationTextView)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getColor(2131166915));
        ((AnimationTextView)localObject3).setTextSize(0, actn.a(16.0F, paramMixedMsgLinearLayout.getContext().getResources()));
        if (TextUtils.isEmpty(((MessageForText)localObject2).sb2))
        {
          ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb);
          label226:
          localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.l;
          if (i != j - 1) {
            break label412;
          }
        }
      }
      label412:
      for (((LinearLayout.LayoutParams)localObject2).bottomMargin = BaseChatItemLayout.l;; ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0)
      {
        localView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
        localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
        i += 1;
        break;
        ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb2);
        break label226;
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = (MessageForPic)localObject2;
          localObject3 = (ChatThumbView)localView;
          URLDrawable localURLDrawable = advu.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject2, (ChatThumbView)localObject3);
          ((ChatThumbView)localObject3).setTag(2131364124, localObject2);
          ((ChatThumbView)localObject3).setImageDrawable(localURLDrawable);
          ((ChatThumbView)localObject3).setOnClickListener((View.OnClickListener)localObject1);
          break label226;
        }
        if (!QLog.isColorLevel()) {
          break label226;
        }
        QLog.e("ChatHistory", 2, "mixed type not support yet." + localObject2.getClass().getSimpleName());
        break label226;
      }
    }
    paramMixedMsgLinearLayout.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
    paramMixedMsgLinearLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.getSubThreadHandler().post(new ChatHistory.ChatHistoryAdapter.10(this, paramInt1, paramInt2, paramString));
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    aart localaart = (aart)paramView.getTag();
    if (localaart == null)
    {
      localaart = new aart(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory);
      paramView.setTag(localaart);
    }
    label697:
    label1724:
    label3644:
    label5821:
    label5824:
    for (;;)
    {
      Object localObject1 = MessageRecord.getTableName(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int);
      localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a().a(MessageRecord.class, (String)localObject1, paramCursor));
      if (localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        if (QLog.isColorLevel()) {
          QLog.w("ChatHistory", 2, "bindView message is null !!");
        }
      }
      label100:
      TextView localTextView1;
      PatchedTextView localPatchedTextView;
      ImageView localImageView1;
      int j;
      label727:
      label1509:
      label1515:
      label1782:
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.d) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().a(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          }
          long l3 = paramCursor.getLong(0);
          localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.setId(l3);
          LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131369147);
          TextView localTextView3 = (TextView)paramView.findViewById(2131377849);
          localTextView1 = (TextView)paramView.findViewById(2131378016);
          TextView localTextView4 = (TextView)paramView.findViewById(2131378017);
          localPatchedTextView = (PatchedTextView)paramView.findViewById(2131378020);
          localImageView1 = (ImageView)paramView.findViewById(2131375549);
          MixedMsgLinearLayout localMixedMsgLinearLayout = (MixedMsgLinearLayout)paramView.findViewById(2131370341);
          TextView localTextView2 = (TextView)paramView.findViewById(2131378015);
          localLinearLayout.setVisibility(0);
          localPatchedTextView.setVisibility(0);
          localTextView2.setVisibility(8);
          ChatThumbView localChatThumbView = (ChatThumbView)paramView.findViewById(2131367918);
          localChatThumbView.jdField_a_of_type_Boolean = false;
          ImageView localImageView3 = (ImageView)paramView.findViewById(2131367922);
          Button localButton = (Button)paramView.findViewById(2131372061);
          ImageView localImageView2 = (ImageView)paramView.findViewById(2131376182);
          localImageView2.setVisibility(8);
          localTextView3.setVisibility(8);
          localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
          String str1 = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
          String str2 = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
          i = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
          int k = paramCursor.getInt(paramCursor.getColumnIndex("issend"));
          j = paramCursor.getInt(paramCursor.getColumnIndex("time"));
          int m;
          Object localObject3;
          Object localObject6;
          Object localObject5;
          if ((paramCursor.getColumnIndex("versionCode") < 0) || (paramCursor.getInt(paramCursor.getColumnIndex("versionCode")) <= 0))
          {
            localObject1 = paramCursor.getString(paramCursor.getColumnIndex("msg"));
            m = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(i, m, (String)localObject1, k).msg;
            localObject3 = bajb.a(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            localObject6 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(52);
            localObject5 = ((TroopManager)localObject6).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b);
            if ((localObject5 != null) && (((TroopInfo)localObject5).cGroupRankSysFlag == 1) && (((TroopInfo)localObject5).cGroupRankUserFlag == 1) && (localObject3 == null))
            {
              localObject6 = ((TroopManager)localObject6).b(str1, str2);
              localObject5 = azrd.a().a((TroopMemberInfo)localObject6, (TroopInfo)localObject5);
              if (localObject5 != null)
              {
                localTextView3.setVisibility(0);
                localTextView3.setText(((azre)localObject5).jdField_a_of_type_JavaLangString);
                azrd.a(localTextView3, ((azre)localObject5).b);
              }
            }
            if (localObject3 == null) {
              break label1309;
            }
            localTextView1.setText(((bajc)localObject3).c);
            localTextView3.setVisibility(0);
            localTextView3.setText(((bajc)localObject3).jdField_d_of_type_JavaLangString);
            localTextView3.setBackgroundDrawable(bamn.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources(), ((bajc)localObject3).jdField_d_of_type_Int));
            if ((localObject3 == null) || (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, false, null))) {
              break label1488;
            }
            localTextView1.setTextColor(((bajc)localObject3).b);
            localTextView4.setText(a(j * 1000L));
            j = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
            if (j != 32768) {
              break label1509;
            }
          }
          for (i = 1;; i = 0)
          {
            for (;;)
            {
              if (i != 0) {
                localPatchedTextView.setMaxWidth((int)(paramContext.getResources().getDisplayMetrics().widthPixels - 70.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float));
              }
              localChatThumbView.setVisibility(8);
              localPatchedTextView.setVisibility(8);
              localImageView1.setVisibility(8);
              localImageView3.setVisibility(8);
              localButton.setVisibility(8);
              localMixedMsgLinearLayout.setVisibility(8);
              localPatchedTextView.setOnTouchListener(null);
              localPatchedTextView.setOnLongClickListener(null);
              localPatchedTextView.setOnClickListener(null);
              localButton.setOnClickListener(null);
              m = paramCursor.getInt(getCursor().getColumnIndex("msgtype"));
              if (m != -2007) {
                break label1515;
              }
              localChatThumbView.setVisibility(0);
              localPatchedTextView.setVisibility(8);
              localImageView1.setVisibility(8);
              localImageView3.setVisibility(8);
              localButton.setVisibility(8);
              localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              localChatThumbView.setTag(str1 + l3);
              localImageView2.setTag(null);
              try
              {
                a(localChatThumbView, (MarkFaceMessage)akwb.a(paramView), localImageView2, localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                return;
              }
              catch (Exception paramView)
              {
                paramView.printStackTrace();
                a(localChatThumbView, null, localImageView2, localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                return;
              }
              if (((localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForFoldMsg)) || ((localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForUniteGrayTip)))
              {
                localObject1 = localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg;
                break;
              }
              try
              {
                localObject5 = new String(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")), "UTF-8");
                for (;;)
                {
                  try
                  {
                    localObject1 = new StringBuilder((String)localObject5);
                    localObject3 = localObject1;
                    if ((localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForText))
                    {
                      localObject3 = localObject1;
                      if (localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 3000)
                      {
                        localObject6 = localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("disc_at_info_list");
                        bool = TextUtils.isEmpty((CharSequence)localObject6);
                        localObject3 = localObject1;
                        if (bool) {}
                      }
                    }
                    try
                    {
                      localObject3 = BaseApplicationImpl.sApplication.getRuntime();
                      if (!QQAppInterface.class.isInstance(localObject3)) {
                        continue;
                      }
                      localObject3 = bafh.a((QQAppInterface)localObject3, (StringBuilder)localObject1, (String)localObject6, str1, localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
                      localObject1 = localObject3;
                      localObject3 = localObject1;
                    }
                    catch (Exception localException2)
                    {
                      QLog.e("ChatHistory", 1, "replaceAtMsgByMarkName", localException2);
                      localObject4 = localObject1;
                      continue;
                    }
                    localObject1 = ((StringBuilder)localObject3).toString();
                  }
                  catch (Exception localException1)
                  {
                    localObject4 = localObject5;
                    localObject5 = localException1;
                    localObject2 = localObject4;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ChatHistory", 2, "We get error AppRuntime");
                  }
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  boolean bool;
                  Object localObject4;
                  long l2;
                  long l1;
                  Object localObject2 = "";
                  continue;
                }
              }
            }
            QLog.e("ChatHistory", 1, "cursor Error", (Throwable)localObject5);
            break;
            if (mye.a(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
            {
              localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getString(2131697494) + mye.a(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).b);
              localTextView3.setVisibility(8);
              break label697;
            }
            if (baja.a(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
            {
              localTextView1.setText(sfh.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, BaseApplicationImpl.getContext()));
              break label697;
            }
            if ((!TextUtils.isEmpty(localaart.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localaart.b)) && (localaart.b.equals(str2)))
            {
              localTextView1.setText(localaart.jdField_a_of_type_JavaLangString);
              break label697;
            }
            localaart.b = str2;
            ThreadManager.post(new ChatHistory.ChatHistoryAdapter.1(this, k, str2, localaart, localTextView1), 8, null, true);
            break label697;
            localTextView1.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getColor(2131166862));
            break label727;
          }
          if (m == -2058) {
            try
            {
              a(paramCursor, localPatchedTextView, m, str1, (String)localObject2, str2, j, localTextView1, localaart, localImageView1, (CharSequence)localObject2, localChatThumbView, localImageView3, localButton, localImageView2, l3);
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              a(localChatThumbView, null, localImageView2, localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
              return;
            }
          }
          if (m == -2039)
          {
            paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
            paramContext = new MessageForApollo();
            paramContext.msgData = paramView;
            paramContext.parse();
            localPatchedTextView.setVisibility(0);
            if (!TextUtils.isEmpty(paramContext.msg))
            {
              localPatchedTextView.setText(paramContext.msg);
              return;
            }
            localPatchedTextView.setText(ajyc.a(2131701622));
            return;
          }
          if (m == -2010)
          {
            localChatThumbView.setVisibility(8);
            localPatchedTextView.setVisibility(0);
            localImageView1.setVisibility(8);
            localImageView3.setVisibility(8);
            localButton.setVisibility(8);
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
            if ((localObject2 == null) || (((String)localObject2).length() <= 0) || (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b(((String)localObject2).toString()))) {
              break label5587;
            }
            paramContext = localObject2.split("\026")[1].split("\\|");
            paramCursor = paramContext[0];
            if (paramContext.length >= 2) {
              break label5061;
            }
            i = 1;
            if (paramContext.length >= 5) {
              localObject4 = paramContext[4];
            }
            if (paramContext.length >= 6) {
              aywi.a(((String)localObject2).toString());
            }
            l2 = 0L;
            l1 = l2;
            if (paramContext != null)
            {
              l1 = l2;
              if (paramContext.length > 1) {
                if (paramContext[1] != null) {
                  break label5075;
                }
              }
            }
          }
          for (paramContext = "0";; paramContext = paramContext[1])
          {
            for (;;)
            {
              l1 = Long.parseLong(paramContext);
              Uri.parse(paramCursor);
              switch (i)
              {
              default: 
                return;
              case 0: 
                localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131692397));
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                return;
                if ((m == -2011) || (m == -2051) || (m == -7002) || (m == -2054))
                {
                  paramCursor = axuy.a(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")));
                  paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(paramCursor);
                  if ((localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing))
                  {
                    paramContext = (MessageForStructing)localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                    if (((paramContext.istroop == 1024) && (!bdto.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, paramContext.frienduin))) || (nbc.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, paramContext.frienduin, paramContext.istroop)))
                    {
                      paramContext = paramView;
                      if (TextUtils.isEmpty(paramView))
                      {
                        paramContext = paramView;
                        if (paramCursor != null)
                        {
                          paramContext = paramView;
                          if ((paramCursor instanceof AbsShareMsg))
                          {
                            paramContext = ((AbsShareMsg)paramCursor).getStructMsgItemLists().iterator();
                            while (paramContext.hasNext())
                            {
                              paramCursor = (axun)paramContext.next();
                              if (!(paramCursor instanceof axuo)) {
                                break label5824;
                              }
                              paramCursor = ((axuo)paramCursor).a.iterator();
                              do
                              {
                                if (!paramCursor.hasNext()) {
                                  break;
                                }
                                localObject2 = (axun)paramCursor.next();
                              } while (!(localObject2 instanceof StructMsgItemTitle));
                              paramView = ((StructMsgItemTitle)localObject2).b();
                            }
                            paramContext = paramView;
                          }
                        }
                      }
                      if (TextUtils.isEmpty(paramContext)) {
                        break label100;
                      }
                      paramView = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getApp().getString(2131697920), new Object[] { ajyc.a(2131701576) });
                      localPatchedTextView.setText(paramView + paramContext);
                      localPatchedTextView.setVisibility(0);
                      localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                      localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                      return;
                    }
                  }
                  if (TextUtils.isEmpty(paramView)) {
                    break label100;
                  }
                  paramContext = paramView;
                  if (baja.a(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
                  {
                    paramContext = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getApp().getString(2131697920), new Object[] { sfh.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, BaseApplicationImpl.getContext()) });
                    paramContext = paramContext + paramView;
                  }
                  localPatchedTextView.setText(paramContext);
                  localPatchedTextView.setVisibility(0);
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  return;
                }
                if (m == -3006)
                {
                  paramView = MessageForPubAccount.getMsgSummary(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, true);
                  if (TextUtils.isEmpty(paramView)) {
                    break label100;
                  }
                  localPatchedTextView.setText(paramView);
                  localPatchedTextView.setVisibility(0);
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  return;
                }
                if (m == -5008)
                {
                  paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                  paramContext = new ArkAppMessage();
                  paramContext.fromBytes(paramView);
                  paramView = paramContext.promptText;
                  if (TextUtils.isEmpty(paramView)) {
                    break label100;
                  }
                  localPatchedTextView.setText(paramView);
                  localPatchedTextView.setVisibility(0);
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  return;
                }
                if (m == -5017)
                {
                  paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                  paramContext = new ArkAppMessage();
                  paramContext.fromBytes(paramView);
                  paramView = paramContext.promptText;
                  if (TextUtils.isEmpty(paramView)) {
                    break label100;
                  }
                  localPatchedTextView.setText(paramView);
                  localPatchedTextView.setVisibility(0);
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  return;
                }
                if (m == -5016)
                {
                  paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                  paramContext = new MessageForArkBabyqReply();
                  paramContext.fromBytes(paramView);
                  paramView = paramContext.babyqReplyText;
                  if (TextUtils.isEmpty(paramView)) {
                    break label100;
                  }
                  localPatchedTextView.setText(paramView);
                  localPatchedTextView.setVisibility(0);
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  return;
                }
                if (m == -5013)
                {
                  paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                  paramContext = new ArkFlashChatMessage();
                  paramContext.fromBytes(paramView);
                  paramView = paramContext.promptText;
                  if (TextUtils.isEmpty(paramView)) {
                    break label100;
                  }
                  localPatchedTextView.setText(paramView);
                  localPatchedTextView.setVisibility(0);
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  return;
                }
                if (m != -5014) {
                  break label2901;
                }
                paramContext = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                try
                {
                  paramContext = ((HiBoomMessage)akwb.a(paramContext)).text;
                  if (TextUtils.isEmpty(paramContext)) {
                    break label100;
                  }
                  localPatchedTextView.setText(paramContext);
                  localPatchedTextView.setVisibility(0);
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  return;
                }
                catch (Exception paramContext)
                {
                  paramContext.printStackTrace();
                }
              }
            }
            break label1724;
            if ((m == -2000) || (m == -20000) || (m == -3004) || (m == -3005) || (m == -3000) || (m == -3001) || (m == -5015))
            {
              if ((localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)))
              {
                if (ajwd.a(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
                {
                  localPatchedTextView.setVisibility(0);
                  localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131691293));
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                  return;
                }
                paramView = (MessageForPic)localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                paramView.parse();
                paramContext = new abjj();
                localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramView;
                paramContext.jdField_a_of_type_ComTencentImageURLImageView = localChatThumbView;
                if (QLog.isColorLevel()) {
                  QLog.d("history", 2, "bindView pic.path:" + paramView.path + ",pic.uuid:" + paramView.uuid);
                }
                if ((paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) || (paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.path == null)) {
                  break;
                }
                a(paramContext);
                return;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("history", 2, "not messageforpicuniseq:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ",dbid:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getId() + "istroop:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop + ",msgtype:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype);
              return;
            }
            if (m == -2002)
            {
              localObject4 = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramContext = new RichMsg.PttRec();
              try
              {
                paramContext.mergeFrom((byte[])localObject4);
                i = 1;
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  i = 0;
                  localException3.printStackTrace();
                  continue;
                  bool = false;
                  continue;
                  j = 0;
                }
                localButton.setText(String.valueOf(j) + "\"");
                localButton.setPadding(k, 0, a(j), 0);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aaru == null) {
                  break label3746;
                }
              }
              if (i == 0) {
                break label1724;
              }
              i = paramContext.voiceLength.get();
              if ((localaart == null) || (localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt))) {
                break label5821;
              }
              if (((MessageForPtt)localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).voiceChangeFlag == 1)
              {
                bool = true;
                localaart.jdField_a_of_type_Boolean = bool;
                if (i > 0) {
                  break label5821;
                }
                i = QQRecorder.a(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                bool = localaart.jdField_a_of_type_Boolean;
                if (!paramContext.voiceType.has()) {
                  break label3638;
                }
                j = paramContext.voiceType.get();
                paramCursor = MessageForPtt.getLocalFilePath(j, paramContext.localPath.get());
                l1 = paramContext.size.get();
                k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.h;
                j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.i;
                localButton.setTag(paramCursor + str1 + l3);
                localButton.setVisibility(0);
                localButton.setText("");
                localButton.setText(null);
                localButton.setCompoundDrawables(null, null, null, null);
                localButton.setPadding(k, 0, j, 0);
                localButton.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                localButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                j = i;
                if (i <= 0) {
                  j = QQRecorder.a(paramCursor);
                }
                if ((paramCursor.startsWith(ajsf.aV)) && (j > 0)) {
                  break label3644;
                }
                localButton.setCompoundDrawables(null, null, null, null);
                localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131695518) + "]");
                localButton.setOnClickListener(null);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aaru.a(0, localButton.getTag()))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aaru.a(paramView, paramCursor);
                localButton.setOnClickListener(new aark(this, j, paramCursor));
                return;
              }
              if (bool) {}
              for (paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848903);; paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848902))
              {
                paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
                localButton.setCompoundDrawables(paramView, null, null, null);
                if (l1 > 0L) {
                  break;
                }
                localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131695522) + "]");
                break;
              }
            }
            if (m == -1035)
            {
              localMixedMsgLinearLayout.setVisibility(0);
              a(localMixedMsgLinearLayout, (MessageForMixedMsg)localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
              return;
            }
            if (m == -7001)
            {
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131694433));
              return;
            }
            if (m == -2017)
            {
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(bbet.a(null));
              return;
            }
            if (m == -2020)
            {
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setOnClickListener(new aarl(this, str1));
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              if (bbet.a(k))
              {
                localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getApp().getString(2131719405, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString }));
                return;
              }
              localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getApp().getString(2131719404));
              return;
            }
            if (m == -3008)
            {
              localPatchedTextView.setText(BaseApplicationImpl.getContext().getString(2131692436) + "\"" + (String)localObject2 + "\"");
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              return;
            }
            if (m == -2022)
            {
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131719565));
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              return;
            }
            if (m == -5002)
            {
              if ((localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForIncompatibleGrayTips)))
              {
                paramView = (MessageForIncompatibleGrayTips)localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                paramView.parse();
                localPatchedTextView.setText(paramView.msg);
                localPatchedTextView.setVisibility(0);
                paramCursor = paramView.url;
                paramContext = new SpannableString(paramView.msg);
                paramCursor = new aarm(this, paramCursor, str1);
                paramContext.setSpan(new ForegroundColorSpan(2131167048), paramView.linkStart, paramView.linkEnd, 33);
                paramContext.setSpan(paramCursor, paramView.linkStart, paramView.linkEnd, 33);
                localPatchedTextView.setText(paramContext);
                localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
                localPatchedTextView.setHighlightColor(17170445);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
                return;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("history", 2, "not MessageForIncompatibleGrayTipsuniseq:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ",dbid:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getId() + "istroop:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop + ",msgtype:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype);
              return;
            }
            if (m == -2025)
            {
              paramView = new MessageForQQWalletMsg();
              paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramView.parse();
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(paramView.getMsgSummary());
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              return;
            }
            if (m == -2036)
            {
              paramView = new MessageForTroopFee();
              paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramView.parse();
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(paramView.getSummaryMsg());
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              return;
            }
            if (m == -2035)
            {
              if (QLog.isColorLevel()) {
                QLog.d(".troop.send_gift", 2, "ChatHistory decode MessageForDeliverGiftTips. seq:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq + "msgtype:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype + "msg:" + localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg);
              }
              paramView = (MessageForDeliverGiftTips)localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
              localLinearLayout.setVisibility(8);
              localPatchedTextView.setVisibility(8);
              localTextView2.setVisibility(0);
              localTextView2.setClickable(true);
              localTextView2.setFocusable(true);
              localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
              localTextView2.setVisibility(0);
              localTextView2.setText(paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, this.jdField_a_of_type_AndroidContentContext, false, localTextView2));
              return;
            }
            if (m == -2038)
            {
              paramView = new MessageForTroopGift();
              paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramView.parse();
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(paramView.summary);
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              return;
            }
            if (m == -2048)
            {
              paramView = new MessageForTroopReward();
              paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramView.parse();
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(paramView.getSummaryMsg());
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              return;
            }
            if ((m == -2052) || (m == -2057) || (m == -2059))
            {
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(((ChatMessage)localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).getSummaryMsg());
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
              return;
            }
            if (m != -2071) {
              break label1724;
            }
            localPatchedTextView.setVisibility(0);
            localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131691294));
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
            return;
            i = Integer.valueOf(paramContext[2]).intValue();
            break label1782;
          }
          localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
          localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
          return;
          k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.h;
          i = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.i;
          localButton.setTag(paramCursor + str1 + l3);
          localButton.setVisibility(0);
          localButton.setText("");
          localButton.setText(null);
          localButton.setCompoundDrawables(null, null, null, null);
          localButton.setPadding(k, 0, i, 0);
          localButton.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
          localButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
          j = 0;
          i = j;
          if (localaart != null)
          {
            i = j;
            if (localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
            {
              i = j;
              if ((localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt)) {
                i = QQRecorder.a(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
              }
            }
          }
          j = i;
          if (i <= 0) {
            j = QQRecorder.a(paramCursor);
          }
          if ((!paramCursor.startsWith(ajsf.aW)) || (j <= 0))
          {
            localButton.setCompoundDrawables(null, null, null, null);
            localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131695518) + "]");
            localButton.setOnClickListener(null);
            return;
          }
          localButton.setText(String.valueOf(j) + "\"");
          localButton.setPadding(k, 0, a(j), 0);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aaru != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aaru.a(0, localButton.getTag()))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aaru.a(paramView, paramCursor);
          }
          for (;;)
          {
            localButton.setOnClickListener(new aarn(this, j, paramCursor));
            return;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848902);
            paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
            localButton.setCompoundDrawables(paramView, null, null, null);
            if (l1 <= 0L) {
              localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131695522) + "]");
            }
          }
          localChatThumbView.setVisibility(0);
          localChatThumbView.setOnClickListener(null);
          localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
          localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
          localChatThumbView.setImageResource(2130838761);
          return;
          i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
          localPatchedTextView.setVisibility(0);
          if (!axas.a(m))
          {
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aars);
          }
          if (!String.valueOf(ajsf.G).equals(str1)) {
            break;
          }
          paramView = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, (String)localObject2, str2, i);
        } while (paramView == null);
        localPatchedTextView.setText(paramView.message);
      } while (j != 32769);
      label1488:
      label2901:
      localTextView1.setText(paramView.troopCode);
      label5061:
      label5075:
      return;
      label5587:
      if (-2008 == i)
      {
        localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131719130));
        return;
      }
      if (-1002 == i)
      {
        localPatchedTextView.setText(localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("sens_msg_original_text"));
        return;
      }
      int i = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
      if ((localImageView1 != null) && (i == 32768)) {
        localImageView1.setVisibility(0);
      }
      localPatchedTextView.setText(new ayki((CharSequence)localObject2, 13, 32, localaart.jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
      return;
    }
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      if (getCursor() != null) {
        getCursor().deactivate();
      }
      super.changeCursor(paramCursor);
      notifyDataSetChanged();
    }
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558780, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aarj
 * JD-Core Version:    0.7.0.1
 */