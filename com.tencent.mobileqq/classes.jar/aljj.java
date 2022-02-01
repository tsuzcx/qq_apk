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

public class aljj
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bfzk jdField_a_of_type_Bfzk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public aljj(RecentItemTroopMsgData paramRecentItemTroopMsgData, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, bfzk parambfzk, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bfzk = parambfzk;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = paramBoolean;
  }
  
  private void a(alkr paramalkr, MessageRecord paramMessageRecord)
  {
    if ((MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForFuDai)) || ((this.jdField_a_of_type_JavaLangObject instanceof alkw))) {}
    do
    {
      do
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg instanceof allh)) {
          break;
        }
        if (((allh)this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg).c == 1)
        {
          this.jdField_a_of_type_Int = 2131167110;
          return;
        }
      } while (!bglm.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin));
      this.jdField_a_of_type_Int = 2131167110;
      return;
      if (((this.jdField_a_of_type_JavaLangObject instanceof bmjx)) && (((bmjx)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697174))))
      {
        this.jdField_a_of_type_Int = 2131167110;
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof allg)) && (((allg)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697159))))
      {
        this.jdField_a_of_type_Int = 2131167110;
        return;
      }
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof allc)) || ((!((allc)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697155))) && (!((allc)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131692693)))));
    this.jdField_a_of_type_Int = 2131167110;
  }
  
  private void b(alkr paramalkr, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramalkr = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramalkr.messageType == 7) || (paramalkr.messageType == 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = this.jdField_a_of_type_AndroidContentContext.getString(2131718518);
      }
    }
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForFuDai))
      {
        ((MessageForFuDai)paramMessageRecord).parse();
        paramalkr = ((MessageForFuDai)paramMessageRecord).highlightMsg();
        if (!TextUtils.isEmpty(paramalkr))
        {
          paramalkr = anvx.a(2131712650) + paramalkr + "]";
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramalkr;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg instanceof allh))
      {
        paramMessageRecord = (allh)this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg;
        bgll localbgll = bglm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin);
        if (paramMessageRecord.c == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = this.jdField_a_of_type_AndroidContentContext.getString(2131697053);
          return;
        }
        if (bglm.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramalkr.a;
          return;
        }
        if (localbgll != null)
        {
          if (localbgll.a.isEmpty())
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramalkr.a;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof alld))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof allk)) && (((allk)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697157))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof allb)) && (((allb)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697160))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof alli)) && (((alli)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697162))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof allf));
    this.b = true;
  }
  
  private void c(alkr paramalkr, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramalkr = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramalkr.messageType == 7) || (paramalkr.messageType == 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = this.jdField_a_of_type_AndroidContentContext.getString(2131718518);
      }
    }
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForFuDai))
      {
        ((MessageForFuDai)paramMessageRecord).parse();
        paramalkr = ((MessageForFuDai)paramMessageRecord).highlightMsg();
        if (!TextUtils.isEmpty(paramalkr))
        {
          paramalkr = anvx.a(2131712650) + paramalkr + "]";
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = paramalkr;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = "";
        return;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof alkw))
      {
        paramalkr = String.format(anvx.a(2131712623), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mTitleName });
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = paramalkr;
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof allf));
    this.b = true;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aljj a()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof alkr))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUnreadNum == 0) && (!(this.jdField_a_of_type_JavaLangObject instanceof allh)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, mUnreadNum:" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUnreadNum);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = "";
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      alkr localalkr = (alkr)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = localalkr.a;
      this.jdField_a_of_type_Int = 2131167138;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = localalkr.b;
      long l = this.jdField_a_of_type_Bfzk.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin);
      MessageRecord localMessageRecord = null;
      if (l != 0L) {
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq4Troop(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.getType(), l);
      }
      a(localalkr, localMessageRecord);
      b(localalkr, localMessageRecord);
      c(localalkr, localMessageRecord);
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
 * Qualified Name:     aljj
 * JD-Core Version:    0.7.0.1
 */