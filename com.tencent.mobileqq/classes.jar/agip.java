import android.widget.ImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.1;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.2;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class agip
  extends areo
{
  agip(agif paramagif) {}
  
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
          paramList = (agis)localIterator.next();
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
    agis localagis;
    if (paramInt != 0)
    {
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localagis = (agis)((Iterator)localObject).next();
        if ((localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
          }
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.7.1(this, localagis));
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
          this.a.jdField_a_of_type_JavaUtilList.remove(localagis);
          return;
          break label118;
          while ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().isChatting()) || (paramEmoticonPackage == null)) {}
          localObject = ((avsq)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramEmoticonPackage.epId);
        } while (localObject == null);
        a(paramEmoticonPackage, Boolean.valueOf(false), (List)localObject);
        localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      } while (!((Iterator)localObject).hasNext());
      localagis = (agis)((Iterator)localObject).next();
    } while ((localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (!paramEmoticonPackage.epId.equals(localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)));
    if (localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 2) {
      bgae.a(this.a.b, null);
    }
    this.a.jdField_a_of_type_JavaUtilList.remove(localagis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agip
 * JD-Core Version:    0.7.0.1
 */