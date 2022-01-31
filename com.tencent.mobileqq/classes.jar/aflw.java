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

public class aflw
  extends BaseBubbleBuilder
  implements aeql
{
  private aqrk jdField_a_of_type_Aqrk;
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
      if ((paramString2.cloudType == 1) && (arrr.a(paramString2))) {
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
    paramString1.status = arrr.b(paramString1.status);
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
  private View a(afme paramafme)
  {
    return new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(long paramLong1, long paramLong2, String paramString)
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (TransFileInfo)localawgf.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString });
    localawgf.a();
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
  
  private void a(afme paramafme, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramafme.c.setVisibility(8);
    }
    String str;
    do
    {
      return;
      if (paramMessageForFile.fakeSenderType != 0)
      {
        paramafme.c.setText("");
        return;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692553);
      boolean bool = paramMessageForFile.isSend();
      if (paramMessageForFile.isMultiMsg) {
        bool = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFile);
      }
      switch (paramFileManagerEntity.status)
      {
      case 2: 
      case 14: 
      case 15: 
      default: 
        paramafme.c.setVisibility(4);
        return;
      case 0: 
        paramafme.c.setVisibility(0);
        if (bool)
        {
          if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 5))
          {
            paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692564));
            return;
          }
          paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692563));
          return;
        }
        paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692562));
        return;
      case 16: 
        paramafme.c.setVisibility(0);
        paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692559));
        return;
      case -1: 
        paramafme.c.setVisibility(0);
        if (bool)
        {
          paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692564));
          return;
        }
        paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692565));
        return;
      case 1: 
        paramafme.c.setVisibility(0);
        if (bool) {
          paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692564));
        }
        while ((AppSetting.c) && (paramafme.e >= 0))
        {
          QQAppInterface.f(alud.a(2131704910));
          paramafme.e = -1;
          return;
          if (paramFileManagerEntity.getCloudType() == 0) {
            paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131694969));
          } else {
            paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692556));
          }
        }
      case 3: 
        paramafme.c.setVisibility(0);
        if (!bool) {
          break label697;
        }
        if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 5))
        {
          paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692564));
          return;
        }
        break;
      }
    } while (3 != paramFileManagerEntity.getCloudType());
    paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692555));
    return;
    label697:
    paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692555));
    return;
    paramafme.c.setVisibility(0);
    paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692565));
    return;
    paramafme.c.setVisibility(0);
    paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692559));
    return;
    paramafme.c.setVisibility(0);
    paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692565));
    return;
    paramafme.c.setVisibility(0);
    paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692559));
    return;
    paramafme.c.setVisibility(0);
    paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692559));
    return;
    paramafme.c.setVisibility(0);
    paramafme.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692565));
  }
  
  private void a(afme paramafme, FileManagerEntity paramFileManagerEntity)
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
        paramafme.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
        paramafme.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((paramafme.e >= 0) && (i - paramafme.e > 1))
        {
          paramafme.e = i;
          QQAppInterface.f(alud.a(2131704909) + i);
        }
        paramafme.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(alud.a(2131704911) + i);
      }
      break;
    }
    while (paramafme.jdField_a_of_type_AndroidWidgetProgressBar == null)
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
    paramafme.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
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
      paramMessageForFile.fileSizeString = arso.a(paramMessageForFile.fileSize);
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
    if ((paramView.isMultiMsg) && (!arrr.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    Object localObject;
    do
    {
      return;
      localObject = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      if (arsx.a((FileManagerEntity)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileItemBuilder<FileAssistant>", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    paramView = new arrq();
    paramView.b = "file_viewer_in";
    paramView.jdField_a_of_type_Int = 9;
    paramView.c = arso.a(((FileManagerEntity)localObject).fileName);
    paramView.d = arrr.a(((FileManagerEntity)localObject).getCloudType(), ((FileManagerEntity)localObject).peerType);
    arrp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView);
    arrp.a("0X8004AE3");
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
      paramView = new arlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject, 10004);
      localObject = new Bundle();
      ((Bundle)localObject).putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.a((Bundle)localObject);
      paramView = new arls(this.jdField_a_of_type_AndroidContentContext, paramView);
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
  
  public aeqi a()
  {
    return new afme(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    paramViewGroup = (aeqi)aepi.a(paramView);
    this.jdField_a_of_type_Aqrk.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    afme localafme = (afme)paramaeqi;
    paramaeqi = paramView;
    if (paramView == null)
    {
      paramaeqi = a(localafme);
      localafme.jdField_a_of_type_AndroidViewView = paramaeqi;
    }
    paramChatMessage = (MessageForFile)paramChatMessage;
    a(paramChatMessage);
    a(paramBaseChatItemLayout, paramChatMessage, localafme, paramChatMessage.status);
    paramaeqi.setOnClickListener(this);
    super.a(paramaeqi, paramaetk);
    localafme.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramaeqi;
  }
  
  public bdpi a(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    long l = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
    paramaeqz = aoxw.a().c();
    paramChatMessage = paramaeqz;
    if (TextUtils.isEmpty(paramaeqz)) {
      paramChatMessage = baic.jdField_a_of_type_JavaLangString;
    }
    int i;
    if ((16 != localFileManagerEntity.status) && (localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)))
    {
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692498), 2130838678);
      }
      if (this.g)
      {
        this.h = aoxg.a().c();
        this.g = false;
      }
      if ((this.h) && (localFileManagerEntity != null) && (baic.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, paramChatMessage)))
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
        parambdpi.a(2131377486, this.jdField_a_of_type_AndroidContentContext.getString(2131720680), 2130838689);
      }
      if (aepi.a(5) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692494), 2130838677);
        }
        return parambdpi;
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
    paramView = (aeqz)aepi.a(paramView);
    if (paramView.a.isMultiMsg) {
      return (MessageForFile)arrr.a(paramView.a);
    }
    return (MessageForFile)paramView.a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bdil.a(paramChatMessage.issend)) {
      return alud.a(2131704913);
    }
    return alud.a(2131704912);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject);
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      return;
      long l1 = ayzl.a();
      long l2 = paramChatMessage.time;
      if ((paramChatMessage.msgtype == -2005) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
      {
        arri.a(alud.a(2131704908));
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
        return;
      }
      a(paramChatMessage);
      arrp.a("0X8005E4B");
      continue;
      acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      continue;
      super.d(paramChatMessage);
      continue;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
      if (arqo.a((MessageForFile)localObject).a(false))
      {
        if (bezm.a((Activity)paramContext, 5, new aflx(this, (MessageForFile)localObject, paramContext))) {
          arre.a(paramContext, 2131692754, 2131692757, new afly(this, (MessageForFile)localObject, paramContext));
        }
      }
      else
      {
        arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject, paramContext);
        continue;
        paramContext = new arrq();
        paramContext.b = "file_forward";
        paramContext.jdField_a_of_type_Int = 9;
        paramContext.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
        paramContext.c = arso.a(localFileManagerEntity.fileName);
        paramContext.d = arrr.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
        arrp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramContext);
        paramContext = new Bundle();
        paramContext.putInt("forward_type", 0);
        paramContext.putBoolean("not_forward", true);
        paramContext.putInt("selection_mode", this.b);
        paramContext.putParcelable("fileinfo", arzx.a(localFileManagerEntity, paramChatMessage));
        paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        paramChatMessage.putExtra("forward_text", alud.a(2131704906) + arrr.d(localFileManagerEntity.fileName) + alud.a(2131704907) + arso.a(localFileManagerEntity.fileSize) + "。");
        paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
        paramChatMessage.putExtra("forward _key_nojump", true);
        paramChatMessage.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (!bdin.d(BaseApplication.getContext())) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694831, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        }
        for (;;)
        {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
          if (!((MessageForFile)localObject).isMultiMsg) {
            break;
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
          break;
          aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        }
        azqs.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!bdin.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694831, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        }
        else
        {
          arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject, paramContext);
          continue;
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644D", "0X800644D", 0, 0, "6", "", "", "");
          arrp.a("0X8005080");
          arqo.a(localFileManagerEntity).a(false, paramContext, new aflz(this, localFileManagerEntity));
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          continue;
          arrp.a("0X8005081");
          if (localFileManagerEntity.getCloudType() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            continue;
            arrp.a("0X8005082");
            boolean bool = localFileManagerEntity.isSend();
            arqo.a(localFileManagerEntity).a(bool, paramContext, new afma(this, localFileManagerEntity));
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            continue;
            new biva(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, paramChatMessage, false);
            if (((MessageForFile)localObject).isMultiMsg)
            {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
              continue;
              bagk.a(localFileManagerEntity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
              if (((MessageForFile)localObject).isMultiMsg)
              {
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
                continue;
                try
                {
                  paramContext = azwn.a(azwn.a(localFileManagerEntity.strFilePath));
                  if (paramContext == null) {
                    continue;
                  }
                  localObject = new SessionInfo();
                  ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
                  ((SessionInfo)localObject).jdField_a_of_type_Int = paramChatMessage.istroop;
                  acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject, paramContext);
                }
                catch (Exception paramContext)
                {
                  QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131704904), 1).a();
                }
                continue;
                ApolloUtil.a(localFileManagerEntity.fileName, localFileManagerEntity.strFilePath, new afmb(this, localFileManagerEntity));
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
    afme localafme = (afme)aepi.a(paramView);
    BaseChatItemLayout localBaseChatItemLayout = localafme.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramView = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    if (paramView.getCloudType() == 5)
    {
      arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView);
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
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692524);
    }
    for (paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131692523); localMessageForFile.isSendFromLocal(); paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131692521))
    {
      bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbhuf.c(str);
      localbhuf.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690648));
      localbhuf.a(paramView);
      localbhuf.a(new afmc(this, localMessageForFile, localbhuf, localBaseChatItemLayout, localafme));
      localbhuf.show();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692522);
    }
    paramView = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
    paramView.c(this.jdField_a_of_type_AndroidContentContext.getString(2131692522));
    paramView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690648));
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131692521));
    paramView.a(new afmd(this, localMessageForFile, paramView, localBaseChatItemLayout, localafme));
    paramView.show();
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForFile paramMessageForFile, afme paramafme, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFile);
    Object localObject = localFileManagerEntity.fileName + localFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject))
    {
      azqs.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
    }
    arrr.b(localFileManagerEntity);
    paramMessageForFile.fileName = localFileManagerEntity.fileName;
    paramMessageForFile.fileSize = localFileManagerEntity.fileSize;
    paramMessageForFile.status = localFileManagerEntity.status;
    paramMessageForFile.urlAtServer = localFileManagerEntity.strServerPath;
    paramMessageForFile.url = localFileManagerEntity.getFilePath();
    paramMessageForFile.fileSizeString = arso.a(localFileManagerEntity.fileSize);
    if ((localFileManagerEntity.getCloudType() == 3) || (localFileManagerEntity.getCloudType() == 5)) {
      if (paramafme.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() == 0)
      {
        paramafme.jdField_a_of_type_AndroidWidgetTextView.post(new FileItemBuilder.8(this, paramafme, localFileManagerEntity));
        if ((localFileManagerEntity == null) || (15 != localFileManagerEntity.status) || (9 != localFileManagerEntity.nOpType)) {
          break label433;
        }
        paramafme.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131692949));
      }
    }
    for (;;)
    {
      if (5 != localFileManagerEntity.getCloudType()) {
        break label463;
      }
      return;
      localObject = paramafme.jdField_a_of_type_AndroidWidgetTextView;
      String str = localFileManagerEntity.fileName;
      boolean bool = this.f;
      int j = paramafme.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      TextPaint localTextPaint = paramafme.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.f) {}
      for (int i = 2;; i = 3)
      {
        ((TextView)localObject).setText(arrr.a(str, bool, j, localTextPaint, i));
        break;
      }
      if (paramafme.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() == 0)
      {
        paramafme.jdField_a_of_type_AndroidWidgetTextView.post(new FileItemBuilder.9(this, paramafme, localFileManagerEntity));
        break;
      }
      localObject = paramafme.jdField_a_of_type_AndroidWidgetTextView;
      str = localFileManagerEntity.strSrcName;
      bool = this.f;
      j = paramafme.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      localTextPaint = paramafme.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.f) {}
      for (i = 2;; i = 3)
      {
        ((TextView)localObject).setText(arrr.a(str, bool, j, localTextPaint, i));
        break;
      }
      label433:
      paramafme.b.setText(arso.a(paramMessageForFile.fileSize, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    }
    label463:
    a(paramafme, localFileManagerEntity);
    a(paramafme, paramMessageForFile, localFileManagerEntity);
    paramBaseChatItemLayout.setFailedIconVisable(b(localFileManagerEntity), this);
    paramMessageForFile.status = paramInt;
    if (localFileManagerEntity == null)
    {
      arrr.a(paramafme.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForFile.fileName);
      return;
    }
    arrr.a(paramafme.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aeqi paramaeqi, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaeqi, paramInt1, paramInt2);
    if (paramChatMessage.isSend())
    {
      paramaeqi.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849444);
      return;
    }
    paramaeqi.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849268);
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return (paramFileManagerEntity != null) && ((paramFileManagerEntity.nOpType == 24) || (paramFileManagerEntity.nOpType == 25)) && ((paramFileManagerEntity.status == 2) || (paramFileManagerEntity.status == 0));
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = a(paramView);
    bdpi localbdpi = new bdpi();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      a(localbdpi, paramView, null);
    }
    for (;;)
    {
      return localbdpi.a();
      label38:
      b(localbdpi, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  public bdpi b(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    long l = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
    paramaeqz = aoxw.a().c();
    paramChatMessage = paramaeqz;
    if (TextUtils.isEmpty(paramaeqz)) {
      paramChatMessage = baic.jdField_a_of_type_JavaLangString;
    }
    int j = 0;
    int i = j;
    if (16 != localFileManagerEntity.status)
    {
      if ((localFileManagerEntity.nOpType == -1) && (localFileManagerEntity.status == -1)) {
        parambdpi.a(2131365434, this.jdField_a_of_type_AndroidContentContext.getString(2131692764), 2130838674);
      }
      if (((localFileManagerEntity.nOpType == 0) || (localFileManagerEntity.nOpType == 11)) && (localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.status == 1)) {
        parambdpi.a(2131365434, this.jdField_a_of_type_AndroidContentContext.getString(2131692764), 2130838674);
      }
      if ((localFileManagerEntity.nOpType == 11) && (localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.status == 13)) {
        parambdpi.a(2131365434, this.jdField_a_of_type_AndroidContentContext.getString(2131692764), 2130838674);
      }
      if (((localFileManagerEntity.nOpType == 7) || (localFileManagerEntity.nOpType == 28) || (localFileManagerEntity.nOpType == 21) || (localFileManagerEntity.nOpType == 22) || (localFileManagerEntity.nOpType == 3) || (localFileManagerEntity.nOpType == 24) || (localFileManagerEntity.nOpType == 25)) && ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1))) {
        parambdpi.a(2131365434, this.jdField_a_of_type_AndroidContentContext.getString(2131692764), 2130838674);
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
              parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692498), 2130838678);
            }
            if (this.g)
            {
              this.h = aoxg.a().c();
              this.g = false;
            }
            if ((this.h) && (localFileManagerEntity != null) && (baic.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, paramChatMessage)))
            {
              j = 0;
              if (localFileManagerEntity.status == 16) {
                break label938;
              }
              i = 1;
              label512:
              if ((i != 0) && (localFileManagerEntity.fileSize <= l))
              {
                parambdpi.a(2131377486, this.jdField_a_of_type_AndroidContentContext.getString(2131720680), 2130838689);
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
              }
            }
            if (aepi.a(5) != 1) {
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
      ApolloUtil.a(parambdpi, localFileManagerEntity.fileName);
      a(localMessageForFile, parambdpi);
      if (QLog.isColorLevel()) {
        QLog.i("msgrevoke", 2, "FileMenuitem entity.status:" + localFileManagerEntity.status);
      }
      if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
        a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForFile);
      }
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
      }
      a(parambdpi, localMessageForFile);
      if (i != 0) {
        parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692494), 2130838677);
      }
      if (16 != localFileManagerEntity.status) {
        b(localMessageForFile, parambdpi);
      }
      super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
        parambdpi.a(2131366787, this.jdField_a_of_type_AndroidContentContext.getString(2131692551), 2130838678);
      }
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
        parambdpi.a(2131376117, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838678);
      }
      return parambdpi;
      parambdpi.a(2131365434, this.jdField_a_of_type_AndroidContentContext.getString(2131692764), 2130838674);
      break;
      parambdpi.a(2131371631, this.jdField_a_of_type_AndroidContentContext.getString(2131692766), 2130838681);
      break;
      parambdpi.a(2131375731, this.jdField_a_of_type_AndroidContentContext.getString(2131692927), 2130838683);
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
    aepi.n = true;
    if (super.a()) {
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131364181: 
    default: 
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", 0, 0, "4", "", "", "");
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflw
 * JD-Core Version:    0.7.0.1
 */