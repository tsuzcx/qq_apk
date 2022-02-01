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

public class aknr
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bese jdField_a_of_type_Bese;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public aknr(RecentItemTroopMsgData paramRecentItemTroopMsgData, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, bese parambese, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bese = parambese;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = paramBoolean;
  }
  
  private void a(akns paramakns, MessageRecord paramMessageRecord)
  {
    if ((MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForFuDai)) || ((this.jdField_a_of_type_JavaLangObject instanceof aknx))) {}
    do
    {
      do
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg instanceof akoi)) {
          break;
        }
        if (((akoi)this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg).c == 1)
        {
          this.jdField_a_of_type_Int = 2131167096;
          return;
        }
      } while (!bfdg.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin));
      this.jdField_a_of_type_Int = 2131167096;
      return;
      if (((this.jdField_a_of_type_JavaLangObject instanceof bkyo)) && (((bkyo)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696900))))
      {
        this.jdField_a_of_type_Int = 2131167096;
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof akoh)) && (((akoh)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696885))))
      {
        this.jdField_a_of_type_Int = 2131167096;
        return;
      }
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof akod)) || ((!((akod)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696881))) && (!((akod)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131692591)))));
    this.jdField_a_of_type_Int = 2131167096;
  }
  
  private void b(akns paramakns, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramakns = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramakns.messageType == 7) || (paramakns.messageType == 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = this.jdField_a_of_type_AndroidContentContext.getString(2131718133);
      }
    }
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForFuDai))
      {
        ((MessageForFuDai)paramMessageRecord).parse();
        paramakns = ((MessageForFuDai)paramMessageRecord).highlightMsg();
        if (!TextUtils.isEmpty(paramakns))
        {
          paramakns = amtj.a(2131712303) + paramakns + "]";
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramakns;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg instanceof akoi))
      {
        paramMessageRecord = (akoi)this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg;
        bfdf localbfdf = bfdg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin);
        if (paramMessageRecord.c == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = this.jdField_a_of_type_AndroidContentContext.getString(2131696786);
          return;
        }
        if (bfdg.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramakns.a;
          return;
        }
        if (localbfdf != null)
        {
          if (localbfdf.a.isEmpty())
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramakns.a;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof akoe))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof akol)) && (((akol)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696883))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof akoc)) && (((akoc)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696886))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof akoj)) && (((akoj)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131696888))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof akog));
    this.b = true;
  }
  
  private void c(akns paramakns, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramakns = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramakns.messageType == 7) || (paramakns.messageType == 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = this.jdField_a_of_type_AndroidContentContext.getString(2131718133);
      }
    }
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForFuDai))
      {
        ((MessageForFuDai)paramMessageRecord).parse();
        paramakns = ((MessageForFuDai)paramMessageRecord).highlightMsg();
        if (!TextUtils.isEmpty(paramakns))
        {
          paramakns = amtj.a(2131712303) + paramakns + "]";
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = paramakns;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = "";
        return;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof aknx))
      {
        paramakns = String.format(amtj.a(2131712276), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mTitleName });
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = paramakns;
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof akog));
    this.b = true;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aknr a()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof akns))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUnreadNum == 0) && (!(this.jdField_a_of_type_JavaLangObject instanceof akoi)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, mUnreadNum:" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUnreadNum);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = "";
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      akns localakns = (akns)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = localakns.a;
      this.jdField_a_of_type_Int = 2131167124;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = localakns.b;
      long l = this.jdField_a_of_type_Bese.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin);
      MessageRecord localMessageRecord = null;
      if (l != 0L) {
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq4Troop(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.getType(), l);
      }
      a(localakns, localMessageRecord);
      b(localakns, localMessageRecord);
      c(localakns, localMessageRecord);
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
 * Qualified Name:     aknr
 * JD-Core Version:    0.7.0.1
 */