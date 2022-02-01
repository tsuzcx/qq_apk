import android.widget.ImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.1;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.2;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ahbg
  extends asiu
{
  ahbg(ahaw paramahaw) {}
  
  private void a(EmoticonPackage paramEmoticonPackage, Boolean paramBoolean, List<Emoticon> paramList)
  {
    Boolean localBoolean = null;
    paramList = paramList.iterator();
    Emoticon localEmoticon;
    boolean bool;
    if (paramList.hasNext())
    {
      localEmoticon = (Emoticon)paramList.next();
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramList = (ahbj)localIterator.next();
          if ((paramList.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(paramList.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
          {
            paramBoolean = paramList.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((paramList.jdField_a_of_type_Boolean) && (paramList.e.hasWindowFocus()))
            {
              bool = true;
              localBoolean = Boolean.valueOf(bool);
              paramList.jdField_a_of_type_Boolean = false;
              paramEmoticonPackage = paramList;
              paramList = paramBoolean;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localBoolean.booleanValue()) {
        if (paramList != null)
        {
          paramBoolean = paramList.senderuin;
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.7.2(this, localEmoticon, paramBoolean, paramEmoticonPackage));
        }
      }
      while ((localEmoticon == null) || (localEmoticon.jobType != 4))
      {
        return;
        bool = false;
        break;
      }
      ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.7.3(this, paramEmoticonPackage, localEmoticon));
      return;
      paramList = null;
      paramEmoticonPackage = localBoolean;
      localBoolean = paramBoolean;
    }
  }
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    Object localObject;
    ahbj localahbj;
    if (paramInt != 0)
    {
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localahbj = (ahbj)((Iterator)localObject).next();
        if ((localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
          }
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.7.1(this, localahbj));
        }
      }
    }
    label118:
    do
    {
      do
      {
        do
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(localahbj);
          return;
          break label118;
          while ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().isChatting()) || (paramEmoticonPackage == null)) {}
          localObject = ((awyr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticonPackage.epId);
        } while (localObject == null);
        a(paramEmoticonPackage, Boolean.valueOf(false), (List)localObject);
        localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      } while (!((Iterator)localObject).hasNext());
      localahbj = (ahbj)((Iterator)localObject).next();
    } while ((localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (!paramEmoticonPackage.epId.equals(localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)));
    if (localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 2) {
      bhiw.a(this.a.b, null);
    }
    this.a.jdField_a_of_type_JavaUtilList.remove(localahbj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbg
 * JD-Core Version:    0.7.0.1
 */