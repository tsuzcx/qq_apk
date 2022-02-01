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
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class afyz
  extends aexf
  implements aqqx
{
  protected final float a;
  View.OnClickListener a;
  
  public afyz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afza(this);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    paramQQAppInterface = new Intent();
    paramQQAppInterface.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
  }
  
  private void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    if ((!FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strMediaPath)) && (NetworkUtil.isMobileNetWork(bhpc.a().a())))
    {
      String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692374);
      String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692376);
      aszg.a(this.jdField_a_of_type_AndroidContentContext, str1, str2, new afzb(this, paramMessageForDeviceSingleStruct));
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
      bkxa.a().a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject, "com.tencent.device.lightapp.DeviceWebViewActivity", -1, null, SmartDevicePluginProxyActivity.class);
    }
    do
    {
      return;
      paramMessageForDeviceSingleStruct = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForDeviceSingleStruct.url);
    } while ((paramMessageForDeviceSingleStruct == null) || (!"openLightApp".equals(paramMessageForDeviceSingleStruct.b)) || (!"url".equals(paramMessageForDeviceSingleStruct.c)));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("param_meta_data", paramString);
    abdn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramDeviceInfo, paramMessageForDeviceSingleStruct.b("url_prefix"), (Bundle)localObject);
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
    int i = aszt.a(FileUtil.getExtension(paramMessageForDeviceSingleStruct.strMediaFileName));
    Object localObject2 = aszt.a(paramMessageForDeviceSingleStruct);
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
          if (aszt.a(FileUtil.getExtension(((MessageForDeviceSingleStruct)localObject3).strMediaFileName)) == 0) {
            ((ArrayList)localObject1).add(String.valueOf(aszt.a((MessageForDeviceSingleStruct)localObject3).nSessionId));
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
  
  protected aexg a()
  {
    return new afzc(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    paramLinearLayout.setPadding(0, AIOUtils.dp2px(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = (afzc)paramaexg;
    paramaexg = paramView;
    if (paramView == null)
    {
      paramaexg = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558839, null);
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramaexg.findViewById(2131377536));
      paramLinearLayout.c = ((TextView)paramaexg.findViewById(2131377535));
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramaexg.findViewById(2131377526));
      paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramaexg.findViewById(2131380589));
      paramLinearLayout.d = ((TextView)paramaexg.findViewById(2131377521));
      paramLinearLayout.e = ((TextView)paramaexg.findViewById(2131377523));
    }
    if ((paramLinearLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForDeviceSingleStruct)) {}
    for (paramMessageRecord = (MessageForDeviceSingleStruct)paramMessageRecord;; paramMessageRecord = null)
    {
      if (paramMessageRecord == null) {
        return paramaexg;
      }
      long l;
      if ((paramMessageRecord.strTitle != null) && (!TextUtils.isEmpty(paramMessageRecord.strTitle)))
      {
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.strTitle);
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramMessageRecord.nAppearTime == 0L) {
          break label490;
        }
        l = paramMessageRecord.nAppearTime;
        label213:
        if (l == 0L) {
          break label499;
        }
        paramLinearLayout.c.setText(bfzl.a(this.jdField_a_of_type_AndroidContentContext, l * 1000L));
        paramLinearLayout.c.setVisibility(0);
        label250:
        if ((paramMessageRecord.strDigest == null) || (TextUtils.isEmpty(paramMessageRecord.strDigest))) {
          break label512;
        }
        paramLinearLayout.d.setText(paramMessageRecord.strDigest);
        paramLinearLayout.d.setVisibility(0);
        label288:
        if ((paramMessageRecord.strGuideWords == null) || (TextUtils.isEmpty(paramMessageRecord.strGuideWords))) {
          break label525;
        }
        paramLinearLayout.e.setText(paramMessageRecord.strGuideWords);
        paramLinearLayout.e.setVisibility(0);
        label326:
        if (paramMessageRecord.nDataType != 2) {
          break label538;
        }
        paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label343:
        a(paramMessageRecord, paramLinearLayout);
        if (FileUtils.fileExistsAndNotEmpty(paramMessageRecord.strCoverPath)) {
          break label551;
        }
        ((aavk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(49)).a().a(paramMessageRecord, paramaexg, this);
      }
      for (;;)
      {
        if ((!FileUtils.fileExistsAndNotEmpty(paramMessageRecord.strMediaPath)) && (NetworkUtil.isWifiConnected(bhpc.a().a())))
        {
          paramView = (aavk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(49);
          ((aara)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(Long.parseLong(paramMessageRecord.senderuin));
          paramView.a().a(paramMessageRecord);
        }
        paramaexg.setTag(paramLinearLayout);
        paramaexg.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramaexg.setOnTouchListener(paramafce);
        paramaexg.setOnLongClickListener(paramafce);
        return paramaexg;
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label490:
        l = paramMessageRecord.time;
        break label213;
        label499:
        paramLinearLayout.c.setVisibility(8);
        break label250;
        label512:
        paramLinearLayout.d.setVisibility(8);
        break label288;
        label525:
        paramLinearLayout.e.setVisibility(8);
        break label326;
        label538:
        paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label343;
        label551:
        if ((!TextUtils.isEmpty(paramMessageRecord.faceRect)) && (!FileUtils.fileExistsAndNotEmpty(paramMessageRecord.strMediaPath)))
        {
          paramView = (aavk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(49);
          if (((aara)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(Long.parseLong(paramMessageRecord.senderuin)).isAdmin == 1) {
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
      acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + paramInt, "", "", "");
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
    afzc localafzc = (afzc)AIOUtils.getHolder(paramView);
    if (localafzc == null) {
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
        if ((localafzc.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForDeviceSingleStruct)) {
          paramView = (MessageForDeviceSingleStruct)localafzc.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        }
      } while (paramView == null);
      if ((paramView.uniseq == paramMessageForDeviceSingleStruct.uniseq) && (paramView.nCoverSessionID == paramMessageForDeviceSingleStruct.nCoverSessionID))
      {
        paramView.strCoverPath = paramMessageForDeviceSingleStruct.strCoverPath;
        a(paramView, localafzc);
      }
    } while ((paramView.uniseq != paramMessageForDeviceSingleStruct.uniseq) || (paramView.nMediaSessionID != paramMessageForDeviceSingleStruct.nMediaSessionID));
    paramView.strMediaPath = paramMessageForDeviceSingleStruct.strMediaPath;
  }
  
  protected void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, afzc paramafzc)
  {
    if ((paramMessageForDeviceSingleStruct.nDataType == 1) && (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strMediaPath))) {}
    for (;;)
    {
      int k;
      int j;
      int i;
      try
      {
        k = ((WindowManager)bhpc.a().a().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
        j = (int)(this.jdField_a_of_type_Float * 150.0F);
        i = k;
        if (k <= 0) {
          i = j;
        }
        paramMessageForDeviceSingleStruct = DeviceMsgThumbDownloader.getUrl(paramMessageForDeviceSingleStruct.strMediaPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
        if (paramMessageForDeviceSingleStruct != null)
        {
          paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
          paramafzc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForDeviceSingleStruct);
        }
        return;
      }
      catch (Exception paramMessageForDeviceSingleStruct)
      {
        paramafzc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838094);
        return;
      }
      if (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strCoverPath)) {
        try
        {
          k = ((WindowManager)bhpc.a().a().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
          j = (int)(this.jdField_a_of_type_Float * 150.0F);
          i = k;
          if (k <= 0) {
            i = j;
          }
          paramMessageForDeviceSingleStruct = DeviceMsgThumbDownloader.getUrl(paramMessageForDeviceSingleStruct.strCoverPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
          if (paramMessageForDeviceSingleStruct != null)
          {
            paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
            paramafzc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForDeviceSingleStruct);
            return;
          }
        }
        catch (Exception paramMessageForDeviceSingleStruct)
        {
          paramafzc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838094);
          return;
        }
      }
    }
    paramafzc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838094);
  }
  
  public bgbb[] a(View paramView)
  {
    paramView = new bgaz();
    paramView.a(2131365382, this.jdField_a_of_type_AndroidContentContext.getString(2131690679), 2130838966);
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if ((localHotChatManager == null) || (!localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {}
      }
      i = 1;
    }
    if ((i != 0) && (awcm.a().a())) {
      paramView.a(2131371498, this.jdField_a_of_type_AndroidContentContext.getString(2131693996), 2130838981);
    }
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyz
 * JD-Core Version:    0.7.0.1
 */