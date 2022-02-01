import android.content.Context;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class alqa
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bgiw jdField_a_of_type_Bgiw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public alqa(RecentItemTroopMsgData paramRecentItemTroopMsgData, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, bgiw parambgiw, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bgiw = parambgiw;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = paramBoolean;
  }
  
  private void a(alqb paramalqb, MessageRecord paramMessageRecord)
  {
    if ((MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForFuDai)) || ((this.jdField_a_of_type_JavaLangObject instanceof alqg))) {}
    do
    {
      do
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg instanceof alqr)) {
          break;
        }
        if (((alqr)this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg).c == 1)
        {
          this.jdField_a_of_type_Int = 2131167074;
          return;
        }
      } while (!bgts.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin));
      this.jdField_a_of_type_Int = 2131167074;
      return;
      if (((this.jdField_a_of_type_JavaLangObject instanceof bnth)) && (((bnth)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696759))))
      {
        this.jdField_a_of_type_Int = 2131167074;
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof alqq)) && (((alqq)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696744))))
      {
        this.jdField_a_of_type_Int = 2131167074;
        return;
      }
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof alqm)) || ((!((alqm)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696740))) && (!((alqm)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131692543)))));
    this.jdField_a_of_type_Int = 2131167074;
  }
  
  private void b(alqb paramalqb, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramalqb = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramalqb.messageType == 7) || (paramalqb.messageType == 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = this.jdField_a_of_type_AndroidContentContext.getString(2131717893);
      }
    }
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForFuDai))
      {
        ((MessageForFuDai)paramMessageRecord).parse();
        paramalqb = ((MessageForFuDai)paramMessageRecord).highlightMsg();
        if (!TextUtils.isEmpty(paramalqb))
        {
          paramalqb = anzj.a(2131712071) + paramalqb + "]";
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramalqb;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg instanceof alqr))
      {
        paramMessageRecord = (alqr)this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg;
        bgtr localbgtr = bgts.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin);
        if (paramMessageRecord.c == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = this.jdField_a_of_type_AndroidContentContext.getString(2131696645);
          return;
        }
        if (bgts.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramalqb.a;
          return;
        }
        if (localbgtr != null)
        {
          if (localbgtr.a.isEmpty())
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramalqb.a;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof alqn))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof alqu)) && (((alqu)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696742))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof alql)) && (((alql)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696745))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof alqs)) && (((alqs)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696747))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof alqp));
    this.b = true;
  }
  
  private void c(alqb paramalqb, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramalqb = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramalqb.messageType == 7) || (paramalqb.messageType == 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = this.jdField_a_of_type_AndroidContentContext.getString(2131717893);
      }
    }
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForFuDai))
      {
        ((MessageForFuDai)paramMessageRecord).parse();
        paramalqb = ((MessageForFuDai)paramMessageRecord).highlightMsg();
        if (!TextUtils.isEmpty(paramalqb))
        {
          paramalqb = anzj.a(2131712071) + paramalqb + "]";
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = paramalqb;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = "";
        return;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof alqg))
      {
        paramalqb = String.format(anzj.a(2131712044), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mTitleName });
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = paramalqb;
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof alqp));
    this.b = true;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public alqa a()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof alqb))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUnreadNum == 0) && (!(this.jdField_a_of_type_JavaLangObject instanceof alqr)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, mUnreadNum:" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUnreadNum);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = "";
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      alqb localalqb = (alqb)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = localalqb.a;
      this.jdField_a_of_type_Int = 2131167102;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = localalqb.b;
      long l = this.jdField_a_of_type_Bgiw.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin);
      MessageRecord localMessageRecord = null;
      if (l != 0L) {
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.getType(), l);
      }
      a(localalqb, localMessageRecord);
      b(localalqb, localMessageRecord);
      c(localalqb, localMessageRecord);
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqa
 * JD-Core Version:    0.7.0.1
 */