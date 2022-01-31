import android.content.Context;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class aghk
  implements adif
{
  public static String a;
  int jdField_a_of_type_Int = 0;
  private aggw jdField_a_of_type_Aggw;
  private akat jdField_a_of_type_Akat = new aghl(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "MiniPie.MiniPieHelper";
  }
  
  public aghk(aggw paramaggw)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramaggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramaggw.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Aggw = paramaggw;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramaggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    jdField_a_of_type_JavaLangString = paramaggw.jdField_a_of_type_JavaLangString + ".Helper";
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  static int b(ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doNewRefreshForAio");
    }
    int j;
    int i;
    if (paramChatXListView.getLastVisiblePosition() >= 0)
    {
      paramList1 = paramChatXListView.getChildAt(paramChatXListView.getChildCount() - 1);
      if (paramList1 != null)
      {
        paramInt = paramList1.getBottom();
        j = paramChatXListView.getHeight();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshlistadapter=====lastbuttom=" + paramInt + " listHeight=" + j);
        }
        i = paramInt;
        paramInt = j;
      }
    }
    for (;;)
    {
      j = k;
      if (i <= paramInt) {
        j = 3;
      }
      return j;
      paramInt = 0;
      break;
      paramInt = 0;
      i = 0;
    }
  }
  
  int a(ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "keepPostionScroll");
    }
    return BaseChatpieHelper.a(jdField_a_of_type_JavaLangString, paramChatXListView, paramInt, paramList1, paramList2);
  }
  
  int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doDefaultSrollPosition");
    }
    int i = paramInt;
    int k;
    int j;
    long l;
    if (paramList1 != paramList2)
    {
      k = paramList1.size();
      j = paramList2.size();
      if ((k <= 0) || (j <= 0)) {
        break label197;
      }
      l = ((ChatMessage)paramList1.get(k - 1)).uniseq;
      i = j - 1;
      if (i < 0) {
        break label197;
      }
      if ((i != j - 1) || (!aqvc.a((MessageRecord)paramList2.get(i)))) {
        break label132;
      }
      i = -1;
    }
    for (;;)
    {
      label107:
      if (i >= 0) {
        i = j - (k - paramInt + j - 1 - i);
      }
      label132:
      do
      {
        do
        {
          return i;
          if (((ChatMessage)paramList2.get(i)).uniseq == l) {
            break label107;
          }
          i -= 1;
          break;
          i = paramInt;
        } while (j <= 0);
        i = paramInt;
      } while (aqvc.a((MessageRecord)paramList2.get(j - 1)));
      return j;
      label197:
      i = -1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aggw.b()) {
      agfy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aggw);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Akat);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aggw);
      a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aggw);
    b();
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    int j = ((ChatXListView)localObject).getFooterViewsCount();
    int m = ((ChatXListView)localObject).getHeaderViewsCount();
    int k = paramInt3 - m - j;
    int i = k - (paramInt1 - m) - paramInt2;
    if (QLog.isColorLevel()) {
      QLog.d("MiniPie.onScroll", 2, " listSize =" + k + " chatPie.mReadedCnt =" + this.jdField_a_of_type_Aggw.g);
    }
    Message localMessage;
    if (this.jdField_a_of_type_Aggw.g < k)
    {
      paramInt2 = paramInt1 + paramInt2 - j - m;
      paramInt1 = paramInt2;
      if (paramInt2 >= paramInt3 - m - j) {
        paramInt1 = k - 1;
      }
      if (paramInt1 >= this.jdField_a_of_type_Aggw.g) {
        this.jdField_a_of_type_Aggw.g = (paramInt1 + j);
      }
      if (i == 0) {
        this.jdField_a_of_type_Aggw.g = k;
      }
      paramInt1 = k - this.jdField_a_of_type_Aggw.g;
      if (paramInt1 != this.jdField_a_of_type_Aggw.h)
      {
        if (this.jdField_a_of_type_Aggw.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5)) {
          this.jdField_a_of_type_Aggw.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5);
        }
        localObject = this.jdField_a_of_type_Aggw.jdField_a_of_type_MqqOsMqqHandler;
        localMessage = this.jdField_a_of_type_Aggw.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(5, paramInt1, i);
        if (!this.jdField_a_of_type_Aggw.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
          break label291;
        }
      }
    }
    label291:
    for (long l = 1500L;; l = 0L)
    {
      ((MqqHandler)localObject).sendMessageDelayed(localMessage, l);
      this.jdField_a_of_type_Aggw.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      this.jdField_a_of_type_Aggw.h = paramInt1;
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  protected void a(aaog paramaaog)
  {
    paramaaog.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    paramaaog.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramaaog.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    paramaaog.jdField_c_of_type_Int = bbfj.a(BaseApplication.getContext());
    paramaaog.jdField_a_of_type_Long = System.currentTimeMillis();
    paramaaog.jdField_d_of_type_Boolean = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.m;
    paramaaog.jdField_b_of_type_Long = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c;
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    if ((localSourceMsgInfo != null) && (localSourceMsgInfo.mSourceMsgText.length() > BaseChatPie.p))
    {
      localSourceMsgInfo.mSourceMsgText = localSourceMsgInfo.mSourceMsgText.substring(0, BaseChatPie.p);
      localSourceMsgInfo.mSourceSummaryFlag = 0;
      if (localSourceMsgInfo.mType == -1036) {
        localSourceMsgInfo.oriMsgType = 1;
      }
    }
    paramaaog.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = localSourceMsgInfo;
  }
  
  public int[] a()
  {
    return new int[] { 2, 11 };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aggw.b())
    {
      agfy.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aggw);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (!agfy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  protected void c()
  {
    Object localObject1 = "";
    if (this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null) {
      localObject1 = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    int i = ((String)localObject1).length();
    localObject1 = this.jdField_a_of_type_Aggw;
    if (i > aggw.e)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131719284, 1);
      return;
    }
    Object localObject3 = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    Object localObject2 = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    if (((XEditTextEx)localObject3).getTag(2131372739) == null) {
      localObject2 = null;
    }
    for (;;)
    {
      if ((0 == 0) && (localObject2 != null)) {}
      label904:
      for (localObject1 = aevd.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForReplyText.SourceMsgInfo)localObject2);; localObject1 = null)
      {
        Object localObject4 = new aaog();
        a((aaog)localObject4);
        ((aaog)localObject4).jdField_d_of_type_Int = amle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1);
        Object localObject5;
        if (((aaog)localObject4).jdField_d_of_type_Boolean)
        {
          ((aaog)localObject4).jdField_d_of_type_Int = amle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1);
          if ((((aaog)localObject4).jdField_d_of_type_Int == 1) || (((aaog)localObject4).jdField_d_of_type_Int == 3)) {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A883", "0X800A883", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if ((this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
            break label777;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
          }
          if ((localObject2 == null) || (!TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject2).mAnonymousNickName)) || (localObject1 != null)) {
            break label910;
          }
          localObject1 = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          i = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
          localObject5 = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i, -1L, true);
          i = ((List)localObject5).size() - 1;
          label383:
          if (i < 0) {
            break label904;
          }
          localObject1 = (ChatMessage)((List)localObject5).get(i);
          if (((ChatMessage)localObject1).shmsgseq != ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSeq) {
            break label734;
          }
          label414:
          MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "suc_replyMsg", "reply_suc", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (ChatMessage)localObject1);
        }
        label777:
        label910:
        for (;;)
        {
          if (((aaog)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
          {
            ((aaog)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
            if (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForMixedMsg))) {
              ((aaog)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.oriMsgType = 1;
            }
            if (localObject1 != null) {
              ((aaog)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.packSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1);
            }
          }
          ArrayList localArrayList1 = new ArrayList();
          localObject5 = bafv.a(((XEditTextEx)localObject3).getEditableText(), localArrayList1);
          localObject2 = this.jdField_a_of_type_Aggw.a(true);
          ArrayList localArrayList2 = new ArrayList();
          localObject3 = bafv.a(((XEditTextEx)localObject3).getEditableText(), localArrayList2);
          if (this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
          {
            i = 1;
            label561:
            if (i == 0) {
              break label746;
            }
            avqy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject5, localArrayList1, (aaog)localObject4, (MessageRecord)localObject1, (String)localObject3, localArrayList2);
            if (((aaog)localObject4).jdField_d_of_type_Boolean)
            {
              localObject3 = amlb.a();
              long l1 = ((aaog)localObject4).jdField_a_of_type_Long;
              long l2 = ((aaog)localObject4).jdField_b_of_type_Long;
              localObject4 = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
              long l3 = this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq;
              localObject1 = localObject2;
              if (localArrayList1.isEmpty()) {
                localObject1 = null;
              }
              ((amlb)localObject3).a(l1, l2, (String)localObject5, (String)localObject4, l3, (SpannableString)localObject1);
            }
          }
          for (;;)
          {
            d();
            return;
            if ((((aaog)localObject4).jdField_d_of_type_Int != 2) && (((aaog)localObject4).jdField_d_of_type_Int != 4)) {
              break;
            }
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A884", "0X800A884", 0, 0, "", "", "", "");
            break;
            label734:
            i -= 1;
            break label383;
            i = 0;
            break label561;
            label746:
            aanz.a(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject5, localArrayList1, (aaog)localObject4);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
            }
            localObject1 = new ArrayList();
            localObject2 = bafv.a(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
            aanz.a(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject2, (ArrayList)localObject1, (aaog)localObject4);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
            }
          }
          localObject1 = null;
          break label414;
        }
      }
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131372739, null);
    this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
    this.jdField_a_of_type_Aggw.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    if (this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMinHeight(actj.a(36.0F, this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
    }
    this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
    this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.m = false;
    this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghk
 * JD-Core Version:    0.7.0.1
 */