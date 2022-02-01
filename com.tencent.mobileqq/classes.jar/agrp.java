import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class agrp
  extends afor
  implements arui
{
  protected final float a;
  View.OnClickListener a;
  
  public agrp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agrq(this);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    paramQQAppInterface = new Intent();
    paramQQAppInterface.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
  }
  
  private void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    if ((!FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strMediaPath)) && (NetworkUtil.isMobileNetWork(bizw.a().a())))
    {
      String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692476);
      String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692478);
      audn.a(this.jdField_a_of_type_AndroidContentContext, str1, str2, new agrr(this, paramMessageForDeviceSingleStruct));
      return;
    }
    b(paramMessageForDeviceSingleStruct);
  }
  
  private void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, DeviceInfo paramDeviceInfo, String paramString)
  {
    if ((paramMessageForDeviceSingleStruct.url.startsWith("http://")) || (paramMessageForDeviceSingleStruct.url.startsWith("https://")))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("url", paramMessageForDeviceSingleStruct.url);
      ((Intent)localObject).putExtra("device_info", paramDeviceInfo);
      ((Intent)localObject).putExtra("param_meta_data", paramString);
      bmij.a().a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject, "com.tencent.device.lightapp.DeviceWebViewActivity", -1, null, SmartDevicePluginProxyActivity.class);
    }
    do
    {
      return;
      paramMessageForDeviceSingleStruct = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForDeviceSingleStruct.url);
    } while ((paramMessageForDeviceSingleStruct == null) || (!"openLightApp".equals(paramMessageForDeviceSingleStruct.b)) || (!"url".equals(paramMessageForDeviceSingleStruct.c)));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("param_meta_data", paramString);
    absz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramDeviceInfo, paramMessageForDeviceSingleStruct.b("url_prefix"), (Bundle)localObject);
  }
  
  private boolean a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("reg");
      if (i == 1) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Exception paramString) {}
  }
  
  private void b(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    int i = auea.a(FileUtil.getExtension(paramMessageForDeviceSingleStruct.strMediaFileName));
    Object localObject2 = auea.a(paramMessageForDeviceSingleStruct);
    Object localObject1 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject1).b(10009);
    ((ForwardFileInfo)localObject1).d(8);
    ((ForwardFileInfo)localObject1).b(((FileManagerEntity)localObject2).nSessionId);
    ((ForwardFileInfo)localObject1).d(((FileManagerEntity)localObject2).fileName);
    ((ForwardFileInfo)localObject1).c(((FileManagerEntity)localObject2).uniseq);
    ((ForwardFileInfo)localObject1).d(((FileManagerEntity)localObject2).fileSize);
    ((ForwardFileInfo)localObject1).f(((FileManagerEntity)localObject2).strThumbPath);
    ((ForwardFileInfo)localObject1).a(((FileManagerEntity)localObject2).getFilePath());
    paramMessageForDeviceSingleStruct = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
    paramMessageForDeviceSingleStruct.putExtra("fileinfo", (Parcelable)localObject1);
    localObject1 = new ArrayList();
    if (i == 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAIOList(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType);
      if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
        return;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if ((localObject3 instanceof MessageForDeviceSingleStruct))
        {
          localObject3 = (MessageForDeviceSingleStruct)localObject3;
          if (auea.a(FileUtil.getExtension(((MessageForDeviceSingleStruct)localObject3).strMediaFileName)) == 0) {
            ((ArrayList)localObject1).add(String.valueOf(auea.a((MessageForDeviceSingleStruct)localObject3).nSessionId));
          }
        }
      }
      paramMessageForDeviceSingleStruct.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
    }
    for (;;)
    {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramMessageForDeviceSingleStruct, 102);
      return;
      if (i == 1)
      {
        ((ArrayList)localObject1).add(String.valueOf(((FileManagerEntity)localObject2).nSessionId));
        paramMessageForDeviceSingleStruct.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
      }
    }
  }
  
  protected afos a()
  {
    return new agrs(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramLinearLayout.setPadding(0, AIOUtils.dp2px(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = (agrs)paramafos;
    paramafos = paramView;
    if (paramView == null)
    {
      paramafos = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558864, null);
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramafos.findViewById(2131377809));
      paramLinearLayout.c = ((TextView)paramafos.findViewById(2131377808));
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramafos.findViewById(2131377799));
      paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramafos.findViewById(2131380934));
      paramLinearLayout.d = ((TextView)paramafos.findViewById(2131377794));
      paramLinearLayout.e = ((TextView)paramafos.findViewById(2131377796));
    }
    if ((paramLinearLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForDeviceSingleStruct)) {}
    for (paramMessageRecord = (MessageForDeviceSingleStruct)paramMessageRecord;; paramMessageRecord = null)
    {
      if (paramMessageRecord == null) {
        return paramafos;
      }
      long l;
      if ((paramMessageRecord.strTitle != null) && (!TextUtils.isEmpty(paramMessageRecord.strTitle)))
      {
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.strTitle);
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramMessageRecord.nAppearTime == 0L) {
          break label493;
        }
        l = paramMessageRecord.nAppearTime;
        label213:
        if (l == 0L) {
          break label502;
        }
        paramLinearLayout.c.setText(bhid.a(this.jdField_a_of_type_AndroidContentContext, l * 1000L));
        paramLinearLayout.c.setVisibility(0);
        label250:
        if ((paramMessageRecord.strDigest == null) || (TextUtils.isEmpty(paramMessageRecord.strDigest))) {
          break label515;
        }
        paramLinearLayout.d.setText(paramMessageRecord.strDigest);
        paramLinearLayout.d.setVisibility(0);
        label288:
        if ((paramMessageRecord.strGuideWords == null) || (TextUtils.isEmpty(paramMessageRecord.strGuideWords))) {
          break label528;
        }
        paramLinearLayout.e.setText(paramMessageRecord.strGuideWords);
        paramLinearLayout.e.setVisibility(0);
        label326:
        if (paramMessageRecord.nDataType != 2) {
          break label541;
        }
        paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label343:
        a(paramMessageRecord, paramLinearLayout);
        if (FileUtils.fileExistsAndNotEmpty(paramMessageRecord.strCoverPath)) {
          break label554;
        }
        ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramMessageRecord, paramafos, this);
      }
      for (;;)
      {
        if ((!FileUtils.fileExistsAndNotEmpty(paramMessageRecord.strMediaPath)) && (NetworkUtil.isWifiConnected(bizw.a().a())))
        {
          paramView = (abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
          ((abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramMessageRecord.senderuin));
          paramView.a().a(paramMessageRecord);
        }
        paramafos.setTag(paramLinearLayout);
        paramafos.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramafos.setOnTouchListener(paramaftk);
        paramafos.setOnLongClickListener(paramaftk);
        return paramafos;
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label493:
        l = paramMessageRecord.time;
        break label213;
        label502:
        paramLinearLayout.c.setVisibility(8);
        break label250;
        label515:
        paramLinearLayout.d.setVisibility(8);
        break label288;
        label528:
        paramLinearLayout.e.setVisibility(8);
        break label326;
        label541:
        paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label343;
        label554:
        if ((!TextUtils.isEmpty(paramMessageRecord.faceRect)) && (!FileUtils.fileExistsAndNotEmpty(paramMessageRecord.strMediaPath)))
        {
          paramView = (abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
          if (((abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramMessageRecord.senderuin)).isAdmin == 1) {
            paramView.a().a(paramMessageRecord);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      paramContext.setLeftTitleToCancle(paramChatMessage);
      paramContext.hideTroopFCView(true);
    } while (paramChatMessage == null);
    if (paramChatMessage.istroop == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + paramInt, "", "", "");
      return;
      if (paramChatMessage.istroop == 3000) {
        paramInt = 2;
      } else if (paramChatMessage.istroop == 1) {
        paramInt = 3;
      } else {
        paramInt = 4;
      }
    }
  }
  
  public void a(View paramView, MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    agrs localagrs = (agrs)AIOUtils.getHolder(paramView);
    if (localagrs == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceSingleStructBuilder", 2, "error get holder in updateview");
      }
    }
    do
    {
      do
      {
        return;
        paramView = null;
        if ((localagrs.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForDeviceSingleStruct)) {
          paramView = (MessageForDeviceSingleStruct)localagrs.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        }
      } while (paramView == null);
      if ((paramView.uniseq == paramMessageForDeviceSingleStruct.uniseq) && (paramView.nCoverSessionID == paramMessageForDeviceSingleStruct.nCoverSessionID))
      {
        paramView.strCoverPath = paramMessageForDeviceSingleStruct.strCoverPath;
        a(paramView, localagrs);
      }
    } while ((paramView.uniseq != paramMessageForDeviceSingleStruct.uniseq) || (paramView.nMediaSessionID != paramMessageForDeviceSingleStruct.nMediaSessionID));
    paramView.strMediaPath = paramMessageForDeviceSingleStruct.strMediaPath;
  }
  
  protected void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, agrs paramagrs)
  {
    if ((paramMessageForDeviceSingleStruct.nDataType == 1) && (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strMediaPath))) {}
    for (;;)
    {
      int k;
      int j;
      int i;
      try
      {
        k = ((WindowManager)bizw.a().a().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
        j = (int)(this.jdField_a_of_type_Float * 150.0F);
        i = k;
        if (k <= 0) {
          i = j;
        }
        paramMessageForDeviceSingleStruct = DeviceMsgThumbDownloader.getUrl(paramMessageForDeviceSingleStruct.strMediaPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
        if (paramMessageForDeviceSingleStruct != null)
        {
          paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
          paramagrs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForDeviceSingleStruct);
        }
        return;
      }
      catch (Exception paramMessageForDeviceSingleStruct)
      {
        paramagrs.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838108);
        return;
      }
      if (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strCoverPath)) {
        try
        {
          k = ((WindowManager)bizw.a().a().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
          j = (int)(this.jdField_a_of_type_Float * 150.0F);
          i = k;
          if (k <= 0) {
            i = j;
          }
          paramMessageForDeviceSingleStruct = DeviceMsgThumbDownloader.getUrl(paramMessageForDeviceSingleStruct.strCoverPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
          if (paramMessageForDeviceSingleStruct != null)
          {
            paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
            paramagrs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForDeviceSingleStruct);
            return;
          }
        }
        catch (Exception paramMessageForDeviceSingleStruct)
        {
          paramagrs.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838108);
          return;
        }
      }
    }
    paramagrs.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838108);
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = new bhjq();
    paramView.a(2131365475, this.jdField_a_of_type_AndroidContentContext.getString(2131690756), 2130838986);
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((localHotChatManager == null) || (!localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {}
      }
      i = 1;
    }
    if ((i != 0) && (axio.a().a())) {
      paramView.a(2131371684, this.jdField_a_of_type_AndroidContentContext.getString(2131694187), 2130839001);
    }
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrp
 * JD-Core Version:    0.7.0.1
 */