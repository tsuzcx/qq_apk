import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder.8;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder.9;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afhh
  extends BaseBubbleBuilder
  implements aelw
{
  private aqnb jdField_a_of_type_Aqnb;
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  Handler b;
  private boolean f;
  private boolean g;
  private boolean h;
  
  private int a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong4, paramString1, paramInt, -1L);
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("chaosli", 2, "getFileTransStatus processor.getFileStatus() " + i);
      }
      return i;
    }
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong4, paramString1, paramInt);
    if (paramString2 != null)
    {
      if ((paramString2.cloudType == 1) && (arni.a(paramString2))) {
        paramString2.status = 16;
      }
      return paramString2.status;
    }
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString1 = (TransFileInfo)paramString2.a(TransFileInfo.class, new String[] { String.valueOf(paramLong3), String.valueOf(paramLong2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1 });
    paramString2.a();
    if (paramString1 == null) {
      return 0;
    }
    paramString1.status = arni.b(paramString1.status);
    if (paramString1.status == 2) {
      paramString1.status = 0;
    }
    return paramString1.status;
  }
  
  private long a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString2 = (TransFileInfo)paramString1.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2 });
    paramString1.a();
    if (paramString2 != null) {
      return paramString2.transferedSize;
    }
    return 0L;
  }
  
  @SuppressLint({"ResourceAsColor"})
  private View a(afhp paramafhp)
  {
    return new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(long paramLong1, long paramLong2, String paramString)
  {
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (TransFileInfo)localawbw.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString });
    localawbw.a();
    if (paramString != null) {
      return paramString.fileName;
    }
    return "";
  }
  
  private String a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 == null) && (paramString2 != null))
    {
      paramString2 = a(paramLong1, paramLong2, paramString2);
      if (paramString2 != null)
      {
        i = paramString2.lastIndexOf(".");
        if (i >= 0) {}
      }
    }
    do
    {
      return paramString2;
      return paramString2.substring(0, i);
      if (paramString1 == null) {
        return null;
      }
      i = paramString1.lastIndexOf(File.separator);
      paramString2 = paramString1;
    } while (i < 0);
    String str = "";
    paramString2 = str;
    if (i > 0)
    {
      paramString2 = str;
      if (i + 1 < paramString1.length()) {
        paramString2 = paramString1.substring(i + 1);
      }
    }
    return paramString2;
  }
  
  private String a(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.lastIndexOf(".");
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      str1 = str2;
      if (j > 0)
      {
        str1 = str2;
        if (j > i)
        {
          str1 = str2;
          if (j + 1 < paramString.length()) {
            str1 = paramString.substring(j + 1);
          }
        }
      }
    }
    return str1;
  }
  
  private void a(afhp paramafhp, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramafhp.c.setVisibility(8);
    }
    String str;
    do
    {
      return;
      if (paramMessageForFile.fakeSenderType != 0)
      {
        paramafhp.c.setText("");
        return;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692552);
      boolean bool = paramMessageForFile.isSend();
      if (paramMessageForFile.isMultiMsg) {
        bool = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFile);
      }
      switch (paramFileManagerEntity.status)
      {
      case 2: 
      case 14: 
      case 15: 
      default: 
        paramafhp.c.setVisibility(4);
        return;
      case 0: 
        paramafhp.c.setVisibility(0);
        if (bool)
        {
          if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 5))
          {
            paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692563));
            return;
          }
          paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692562));
          return;
        }
        paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692561));
        return;
      case 16: 
        paramafhp.c.setVisibility(0);
        paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692558));
        return;
      case -1: 
        paramafhp.c.setVisibility(0);
        if (bool)
        {
          paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692563));
          return;
        }
        paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692564));
        return;
      case 1: 
        paramafhp.c.setVisibility(0);
        if (bool) {
          paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692563));
        }
        while ((AppSetting.c) && (paramafhp.e >= 0))
        {
          QQAppInterface.f(alpo.a(2131704898));
          paramafhp.e = -1;
          return;
          if (paramFileManagerEntity.getCloudType() == 0) {
            paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131694967));
          } else {
            paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692555));
          }
        }
      case 3: 
        paramafhp.c.setVisibility(0);
        if (!bool) {
          break label697;
        }
        if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 5))
        {
          paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692563));
          return;
        }
        break;
      }
    } while (3 != paramFileManagerEntity.getCloudType());
    paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692554));
    return;
    label697:
    paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692554));
    return;
    paramafhp.c.setVisibility(0);
    paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692564));
    return;
    paramafhp.c.setVisibility(0);
    paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692558));
    return;
    paramafhp.c.setVisibility(0);
    paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692564));
    return;
    paramafhp.c.setVisibility(0);
    paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692558));
    return;
    paramafhp.c.setVisibility(0);
    paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692558));
    return;
    paramafhp.c.setVisibility(0);
    paramafhp.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692564));
  }
  
  private void a(afhp paramafhp, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null) {}
    int i;
    switch (paramFileManagerEntity.status)
    {
    default: 
      i = 0;
      label46:
      if (i != 0)
      {
        i = (int)(paramFileManagerEntity.fProgress * 100.0F);
        paramafhp.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
        paramafhp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((paramafhp.e >= 0) && (i - paramafhp.e > 1))
        {
          paramafhp.e = i;
          QQAppInterface.f(alpo.a(2131704897) + i);
        }
        paramafhp.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(alpo.a(2131704899) + i);
      }
      break;
    }
    while (paramafhp.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      return;
      i = 1;
      break label46;
      if (9 != paramFileManagerEntity.nOpType) {
        break;
      }
      i = 1;
      break label46;
    }
    paramafhp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void a(MessageForFile paramMessageForFile)
  {
    String str = paramMessageForFile.frienduin;
    for (;;)
    {
      try
      {
        if ((paramMessageForFile.tempMsg == null) || (paramMessageForFile.tempMsg.length <= 0)) {
          continue;
        }
        localObject1 = paramMessageForFile.tempMsg[0].substring(1);
        paramMessageForFile.url = ((String)localObject1);
        if (paramMessageForFile.url.length() == 0)
        {
          paramMessageForFile.url = a(paramMessageForFile.msgseq, paramMessageForFile.time, str);
          if ((paramMessageForFile.tempMsg != null) && (paramMessageForFile.tempMsg.length > 1)) {
            paramMessageForFile.tempMsg[1] = String.valueOf(a(paramMessageForFile.msgseq, paramMessageForFile.time, "", str));
          }
        }
        paramMessageForFile.fileName = a(paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.url, str);
        paramMessageForFile.fileType = a(paramMessageForFile.url);
        if ((paramMessageForFile.tempMsg == null) || (paramMessageForFile.tempMsg.length <= 1) || (paramMessageForFile.tempMsg[1] == null) || (Long.valueOf(paramMessageForFile.tempMsg[1]).longValue() <= 0L)) {
          continue;
        }
        paramMessageForFile.fileSize = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
      }
      catch (Exception localException)
      {
        Object localObject1;
        QLog.e("FileItemBuilder<FileAssistant>", 1, localException.toString());
        continue;
        long l = 0L;
        continue;
        l = 0L;
        continue;
        if (paramMessageForFile.tempMsg == null) {
          continue;
        }
        if (paramMessageForFile.tempMsg.length <= 1) {
          continue;
        }
        l = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
        paramMessageForFile.fileSize = l;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileItemBuilder<FileAssistant>", 2, "--------->>bindView 2 filePath:" + paramMessageForFile.url + "fileMsgLength:" + paramMessageForFile.tempMsg.length + ", fileSize:" + paramMessageForFile.fileSize);
        continue;
        l = 0L;
        continue;
        Object localObject2 = null;
        continue;
      }
      paramMessageForFile.fileSizeString = arof.a(paramMessageForFile.fileSize);
      if (paramMessageForFile.tempMsg != null)
      {
        if (paramMessageForFile.tempMsg.length <= 4) {
          continue;
        }
        localObject1 = paramMessageForFile.tempMsg[4];
        paramMessageForFile.urlAtServer = ((String)localObject1);
      }
      paramMessageForFile.status = a(str, paramMessageForFile.url, paramMessageForFile.isSendFromLocal(), paramMessageForFile.fileSize, paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.uniseq, paramMessageForFile.istroop);
      return;
      localObject1 = "";
      continue;
      if (!paramMessageForFile.isSendFromLocal()) {
        continue;
      }
      localObject1 = new File(paramMessageForFile.url);
      if (!((File)localObject1).exists()) {
        continue;
      }
      l = ((File)localObject1).length();
      paramMessageForFile.fileSize = l;
      if (QLog.isColorLevel()) {
        QLog.d("FileItemBuilder<FileAssistant>", 2, "--------->>bindView 1 filePath:" + paramMessageForFile.url + ",fileExists:" + ((File)localObject1).exists() + ", fileSize:" + ((File)localObject1).length());
      }
      if ((paramMessageForFile.fileSize == 0L) && (paramMessageForFile.tempMsg != null))
      {
        if (paramMessageForFile.tempMsg.length <= 1) {
          continue;
        }
        l = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
        paramMessageForFile.fileSize = l;
      }
    }
  }
  
  private boolean b(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {
      return false;
    }
    switch (paramFileManagerEntity.status)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 9: 
    case 12: 
    case 13: 
    case 15: 
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((paramFileManagerEntity.status != 0) || (paramFileManagerEntity.isSend() != true) || (paramFileManagerEntity.bOnceSuccess)) {
        break;
      }
      continue;
      if (13 != paramFileManagerEntity.nOpType) {
        break;
      }
      bool = false;
      continue;
      if (10 == paramFileManagerEntity.nOpType)
      {
        bool = false;
      }
      else
      {
        bool = false;
        continue;
        if (13 != paramFileManagerEntity.nOpType) {
          break;
        }
        bool = false;
        continue;
        if ((!paramFileManagerEntity.isSend()) || (paramFileManagerEntity.bOnceSuccess)) {
          break;
        }
      }
    }
  }
  
  private void d(View paramView)
  {
    paramView = a(paramView);
    if (QLog.isColorLevel()) {
      QLog.d("FileItemBuilder<FileAssistant>", 2, "TransfileUtile.TYPE_FILE uniseq " + paramView.uniseq + " itemStatus" + paramView.status);
    }
    if ((paramView.isMultiMsg) && (!arni.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    Object localObject;
    do
    {
      return;
      localObject = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      if (aroo.a((FileManagerEntity)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileItemBuilder<FileAssistant>", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    paramView = new arnh();
    paramView.b = "file_viewer_in";
    paramView.jdField_a_of_type_Int = 9;
    paramView.c = arof.a(((FileManagerEntity)localObject).fileName);
    paramView.d = arni.a(((FileManagerEntity)localObject).getCloudType(), ((FileManagerEntity)localObject).peerType);
    arng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView);
    arng.a("0X8004AE3");
    if ((((FileManagerEntity)localObject).TroopUin != 0L) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).strTroopFileID)) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).strTroopFilePath)))
    {
      paramView = new ForwardFileInfo();
      paramView.b(((FileManagerEntity)localObject).nSessionId);
      paramView.d(4);
      paramView.b(10006);
      paramView.a(((FileManagerEntity)localObject).getFilePath());
      paramView.d(((FileManagerEntity)localObject).fileName);
      paramView.d(((FileManagerEntity)localObject).fileSize);
      paramView.a(((FileManagerEntity)localObject).TroopUin);
      localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
      Intent localIntent = new Intent((Context)localObject, TroopFileDetailBrowserActivity.class);
      localIntent.putExtra("fileinfo", paramView);
      localIntent.putExtra("removemementity", true);
      localIntent.putExtra("forward_from_troop_file", true);
      localIntent.putExtra("not_forward", true);
      ((Activity)localObject).startActivityForResult(localIntent, 102);
      return;
    }
    int i = 0;
    if (((FileManagerEntity)localObject).peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      paramView = new arhh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject, 10004);
      localObject = new Bundle();
      ((Bundle)localObject).putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.a((Bundle)localObject);
      paramView = new arhj(this.jdField_a_of_type_AndroidContentContext, paramView);
      paramView.a(i);
      paramView.a();
      return;
      if (((FileManagerEntity)localObject).peerType == 3000) {
        i = 5;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new afhp(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    paramViewGroup = (aelt)aekt.a(paramView);
    this.jdField_a_of_type_Aqnb.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    afhp localafhp = (afhp)paramaelt;
    paramaelt = paramView;
    if (paramView == null)
    {
      paramaelt = a(localafhp);
      localafhp.jdField_a_of_type_AndroidViewView = paramaelt;
    }
    paramChatMessage = (MessageForFile)paramChatMessage;
    a(paramChatMessage);
    a(paramBaseChatItemLayout, paramChatMessage, localafhp, paramChatMessage.status);
    paramaelt.setOnClickListener(this);
    super.a(paramaelt, paramaeov);
    localafhp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramaelt;
  }
  
  public bdkz a(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    long l = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
    paramaemk = aotn.a().c();
    paramChatMessage = paramaemk;
    if (TextUtils.isEmpty(paramaemk)) {
      paramChatMessage = badt.jdField_a_of_type_JavaLangString;
    }
    int i;
    if ((16 != localFileManagerEntity.status) && (localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)))
    {
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692497), 2130838677);
      }
      if (this.g)
      {
        this.h = aosx.a().c();
        this.g = false;
      }
      if ((this.h) && (localFileManagerEntity != null) && (badt.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, paramChatMessage)))
      {
        if (localFileManagerEntity.status == 16) {
          break label242;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (localFileManagerEntity.fileSize <= l)) {
        parambdkz.a(2131377432, this.jdField_a_of_type_AndroidContentContext.getString(2131720668), 2130838688);
      }
      if (aekt.a(5) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692493), 2130838676);
        }
        return parambdkz;
        label242:
        if (TextUtils.isEmpty(localFileManagerEntity.strFilePath)) {
          break label289;
        }
        paramChatMessage = new File(localFileManagerEntity.strFilePath);
        if ((paramChatMessage == null) || (!paramChatMessage.exists())) {
          break label289;
        }
        i = 1;
        break;
      }
      label289:
      i = 0;
    }
  }
  
  public MessageForFile a(View paramView)
  {
    paramView = (aemk)aekt.a(paramView);
    if (paramView.a.isMultiMsg) {
      return (MessageForFile)arni.a(paramView.a);
    }
    return (MessageForFile)paramView.a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bdec.a(paramChatMessage.issend)) {
      return alpo.a(2131704901);
    }
    return alpo.a(2131704900);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject);
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      return;
      long l1 = ayvc.a();
      long l2 = paramChatMessage.time;
      if ((paramChatMessage.msgtype == -2005) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
      {
        armz.a(alpo.a(2131704896));
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
        return;
      }
      a(paramChatMessage);
      arng.a("0X8005E4B");
      continue;
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      continue;
      super.d(paramChatMessage);
      continue;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
      if (armf.a((MessageForFile)localObject).a(false))
      {
        if (bevd.a((Activity)paramContext, 5, new afhi(this, (MessageForFile)localObject, paramContext))) {
          armv.a(paramContext, 2131692752, 2131692755, new afhj(this, (MessageForFile)localObject, paramContext));
        }
      }
      else
      {
        arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject, paramContext);
        continue;
        paramContext = new arnh();
        paramContext.b = "file_forward";
        paramContext.jdField_a_of_type_Int = 9;
        paramContext.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
        paramContext.c = arof.a(localFileManagerEntity.fileName);
        paramContext.d = arni.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
        arng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramContext);
        paramContext = new Bundle();
        paramContext.putInt("forward_type", 0);
        paramContext.putBoolean("not_forward", true);
        paramContext.putInt("selection_mode", this.b);
        paramContext.putParcelable("fileinfo", arvo.a(localFileManagerEntity, paramChatMessage));
        paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        paramChatMessage.putExtra("forward_text", alpo.a(2131704894) + arni.d(localFileManagerEntity.fileName) + alpo.a(2131704895) + arof.a(localFileManagerEntity.fileSize) + "。");
        paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
        paramChatMessage.putExtra("forward _key_nojump", true);
        paramChatMessage.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (!bdee.d(BaseApplication.getContext())) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694829, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        }
        for (;;)
        {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
          if (!((MessageForFile)localObject).isMultiMsg) {
            break;
          }
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
          break;
          arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        }
        azmj.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!bdee.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694829, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        }
        else
        {
          arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject, paramContext);
          continue;
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644D", "0X800644D", 0, 0, "6", "", "", "");
          arng.a("0X8005080");
          armf.a(localFileManagerEntity).a(false, paramContext, new afhk(this, localFileManagerEntity));
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          continue;
          arng.a("0X8005081");
          if (localFileManagerEntity.getCloudType() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            continue;
            arng.a("0X8005082");
            boolean bool = localFileManagerEntity.isSend();
            armf.a(localFileManagerEntity).a(bool, paramContext, new afhl(this, localFileManagerEntity));
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            continue;
            new biqt(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, paramChatMessage, false);
            if (((MessageForFile)localObject).isMultiMsg)
            {
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
              continue;
              bacb.a(localFileManagerEntity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
              if (((MessageForFile)localObject).isMultiMsg)
              {
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
                continue;
                try
                {
                  paramContext = azse.a(azse.a(localFileManagerEntity.strFilePath));
                  if (paramContext == null) {
                    continue;
                  }
                  localObject = new SessionInfo();
                  ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
                  ((SessionInfo)localObject).jdField_a_of_type_Int = paramChatMessage.istroop;
                  acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject, paramContext);
                }
                catch (Exception paramContext)
                {
                  QQToast.a(this.jdField_a_of_type_AndroidContentContext, alpo.a(2131704892), 1).a();
                }
                continue;
                ApolloUtil.a(localFileManagerEntity.fileName, localFileManagerEntity.strFilePath, new afhm(this, localFileManagerEntity));
                continue;
                ApolloUtil.f(localFileManagerEntity.strFilePath);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    MessageForFile localMessageForFile = a(paramView);
    afhp localafhp = (afhp)aekt.a(paramView);
    BaseChatItemLayout localBaseChatItemLayout = localafhp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramView = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    if (paramView.getCloudType() == 5)
    {
      arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.getString(2131690042);
    this.jdField_a_of_type_AndroidContentContext.getString(2131690043);
    String str;
    switch (paramView.nOpType)
    {
    case 6: 
    case 7: 
    default: 
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692523);
    }
    for (paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131692522); localMessageForFile.isSendFromLocal(); paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131692520))
    {
      bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbhpy.c(str);
      localbhpy.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690648));
      localbhpy.a(paramView);
      localbhpy.a(new afhn(this, localMessageForFile, localbhpy, localBaseChatItemLayout, localafhp));
      localbhpy.show();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692521);
    }
    paramView = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
    paramView.c(this.jdField_a_of_type_AndroidContentContext.getString(2131692521));
    paramView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690648));
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131692520));
    paramView.a(new afho(this, localMessageForFile, paramView, localBaseChatItemLayout, localafhp));
    paramView.show();
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForFile paramMessageForFile, afhp paramafhp, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFile);
    Object localObject = localFileManagerEntity.fileName + localFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject))
    {
      azmj.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
    }
    arni.b(localFileManagerEntity);
    paramMessageForFile.fileName = localFileManagerEntity.fileName;
    paramMessageForFile.fileSize = localFileManagerEntity.fileSize;
    paramMessageForFile.status = localFileManagerEntity.status;
    paramMessageForFile.urlAtServer = localFileManagerEntity.strServerPath;
    paramMessageForFile.url = localFileManagerEntity.getFilePath();
    paramMessageForFile.fileSizeString = arof.a(localFileManagerEntity.fileSize);
    if ((localFileManagerEntity.getCloudType() == 3) || (localFileManagerEntity.getCloudType() == 5)) {
      if (paramafhp.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() == 0)
      {
        paramafhp.jdField_a_of_type_AndroidWidgetTextView.post(new FileItemBuilder.8(this, paramafhp, localFileManagerEntity));
        if ((localFileManagerEntity == null) || (15 != localFileManagerEntity.status) || (9 != localFileManagerEntity.nOpType)) {
          break label433;
        }
        paramafhp.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131692947));
      }
    }
    for (;;)
    {
      if (5 != localFileManagerEntity.getCloudType()) {
        break label463;
      }
      return;
      localObject = paramafhp.jdField_a_of_type_AndroidWidgetTextView;
      String str = localFileManagerEntity.fileName;
      boolean bool = this.f;
      int j = paramafhp.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      TextPaint localTextPaint = paramafhp.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.f) {}
      for (int i = 2;; i = 3)
      {
        ((TextView)localObject).setText(arni.a(str, bool, j, localTextPaint, i));
        break;
      }
      if (paramafhp.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() == 0)
      {
        paramafhp.jdField_a_of_type_AndroidWidgetTextView.post(new FileItemBuilder.9(this, paramafhp, localFileManagerEntity));
        break;
      }
      localObject = paramafhp.jdField_a_of_type_AndroidWidgetTextView;
      str = localFileManagerEntity.strSrcName;
      bool = this.f;
      j = paramafhp.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      localTextPaint = paramafhp.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.f) {}
      for (i = 2;; i = 3)
      {
        ((TextView)localObject).setText(arni.a(str, bool, j, localTextPaint, i));
        break;
      }
      label433:
      paramafhp.b.setText(arof.a(paramMessageForFile.fileSize, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    }
    label463:
    a(paramafhp, localFileManagerEntity);
    a(paramafhp, paramMessageForFile, localFileManagerEntity);
    paramBaseChatItemLayout.setFailedIconVisable(b(localFileManagerEntity), this);
    paramMessageForFile.status = paramInt;
    if (localFileManagerEntity == null)
    {
      arni.a(paramafhp.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForFile.fileName);
      return;
    }
    arni.a(paramafhp.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaelt, paramInt1, paramInt2);
    if (paramChatMessage.isSend())
    {
      paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849371);
      return;
    }
    paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849195);
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return (paramFileManagerEntity != null) && ((paramFileManagerEntity.nOpType == 24) || (paramFileManagerEntity.nOpType == 25)) && ((paramFileManagerEntity.status == 2) || (paramFileManagerEntity.status == 0));
  }
  
  public bdlb[] a(View paramView)
  {
    paramView = a(paramView);
    bdkz localbdkz = new bdkz();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      a(localbdkz, paramView, null);
    }
    for (;;)
    {
      return localbdkz.a();
      label38:
      b(localbdkz, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  public bdkz b(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    long l = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
    paramaemk = aotn.a().c();
    paramChatMessage = paramaemk;
    if (TextUtils.isEmpty(paramaemk)) {
      paramChatMessage = badt.jdField_a_of_type_JavaLangString;
    }
    int j = 0;
    int i = j;
    if (16 != localFileManagerEntity.status)
    {
      if ((localFileManagerEntity.nOpType == -1) && (localFileManagerEntity.status == -1)) {
        parambdkz.a(2131365432, this.jdField_a_of_type_AndroidContentContext.getString(2131692762), 2130838673);
      }
      if (((localFileManagerEntity.nOpType == 0) || (localFileManagerEntity.nOpType == 11)) && (localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.status == 1)) {
        parambdkz.a(2131365432, this.jdField_a_of_type_AndroidContentContext.getString(2131692762), 2130838673);
      }
      if ((localFileManagerEntity.nOpType == 11) && (localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.status == 13)) {
        parambdkz.a(2131365432, this.jdField_a_of_type_AndroidContentContext.getString(2131692762), 2130838673);
      }
      if (((localFileManagerEntity.nOpType == 7) || (localFileManagerEntity.nOpType == 28) || (localFileManagerEntity.nOpType == 21) || (localFileManagerEntity.nOpType == 22) || (localFileManagerEntity.nOpType == 3) || (localFileManagerEntity.nOpType == 24) || (localFileManagerEntity.nOpType == 25)) && ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1))) {
        parambdkz.a(2131365432, this.jdField_a_of_type_AndroidContentContext.getString(2131692762), 2130838673);
      }
      if (localFileManagerEntity.nOpType == 1) {}
      switch (localFileManagerEntity.status)
      {
      default: 
        i = j;
        if (localFileManagerEntity.getCloudType() != 0)
        {
          i = j;
          if (!a(localFileManagerEntity))
          {
            if (!localFileManagerEntity.sendCloudUnsuccessful()) {
              parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692497), 2130838677);
            }
            if (this.g)
            {
              this.h = aosx.a().c();
              this.g = false;
            }
            if ((this.h) && (localFileManagerEntity != null) && (badt.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, paramChatMessage)))
            {
              j = 0;
              if (localFileManagerEntity.status == 16) {
                break label938;
              }
              i = 1;
              label512:
              if ((i != 0) && (localFileManagerEntity.fileSize <= l))
              {
                parambdkz.a(2131377432, this.jdField_a_of_type_AndroidContentContext.getString(2131720668), 2130838688);
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
              }
            }
            if (aekt.a(5) != 1) {
              break label991;
            }
          }
        }
        break;
      }
    }
    label938:
    label991:
    for (i = 1;; i = 0)
    {
      ApolloUtil.a(parambdkz, localFileManagerEntity.fileName);
      a(localMessageForFile, parambdkz);
      if (QLog.isColorLevel()) {
        QLog.i("msgrevoke", 2, "FileMenuitem entity.status:" + localFileManagerEntity.status);
      }
      if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
        a(parambdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForFile);
      }
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
      }
      a(parambdkz, localMessageForFile);
      if (i != 0) {
        parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692493), 2130838676);
      }
      if (16 != localFileManagerEntity.status) {
        b(localMessageForFile, parambdkz);
      }
      super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
        parambdkz.a(2131366777, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838677);
      }
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
        parambdkz.a(2131376063, this.jdField_a_of_type_AndroidContentContext.getString(2131692549), 2130838677);
      }
      return parambdkz;
      parambdkz.a(2131365432, this.jdField_a_of_type_AndroidContentContext.getString(2131692762), 2130838673);
      break;
      parambdkz.a(2131371612, this.jdField_a_of_type_AndroidContentContext.getString(2131692764), 2130838680);
      break;
      parambdkz.a(2131375680, this.jdField_a_of_type_AndroidContentContext.getString(2131692925), 2130838682);
      break;
      i = j;
      if (TextUtils.isEmpty(localFileManagerEntity.strFilePath)) {
        break label512;
      }
      paramChatMessage = new File(localFileManagerEntity.strFilePath);
      i = j;
      if (paramChatMessage == null) {
        break label512;
      }
      i = j;
      if (!paramChatMessage.exists()) {
        break label512;
      }
      i = 1;
      break label512;
    }
  }
  
  public void onClick(View paramView)
  {
    aekt.n = true;
    if (super.a()) {
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131364179: 
    default: 
      return;
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", 0, 0, "4", "", "", "");
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhh
 * JD-Core Version:    0.7.0.1
 */