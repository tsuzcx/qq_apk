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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class adoz
  extends BaseBubbleBuilder
  implements acuq
{
  private aotz jdField_a_of_type_Aotz;
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
      if ((paramString2.cloudType == 1) && (apue.a(paramString2))) {
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
    paramString1.status = apue.b(paramString1.status);
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
  private View a(adph paramadph)
  {
    return new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(long paramLong1, long paramLong2, String paramString)
  {
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (TransFileInfo)localaukn.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString });
    localaukn.a();
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
  
  private void a(adph paramadph, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramadph.c.setVisibility(8);
    }
    String str;
    do
    {
      return;
      if (paramMessageForFile.fakeSenderType != 0)
      {
        paramadph.c.setText("");
        return;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692475);
      boolean bool = paramMessageForFile.isSend();
      if (paramMessageForFile.isMultiMsg) {
        bool = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFile);
      }
      switch (paramFileManagerEntity.status)
      {
      case 2: 
      case 14: 
      case 15: 
      default: 
        paramadph.c.setVisibility(4);
        return;
      case 0: 
        paramadph.c.setVisibility(0);
        if (bool)
        {
          if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 5))
          {
            paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692486));
            return;
          }
          paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692485));
          return;
        }
        paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692484));
        return;
      case 16: 
        paramadph.c.setVisibility(0);
        paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692481));
        return;
      case -1: 
        paramadph.c.setVisibility(0);
        if (bool)
        {
          paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692486));
          return;
        }
        paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692487));
        return;
      case 1: 
        paramadph.c.setVisibility(0);
        if (bool) {
          paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692486));
        }
        while ((AppSetting.d) && (paramadph.e >= 0))
        {
          QQAppInterface.f(ajyc.a(2131704515));
          paramadph.e = -1;
          return;
          if (paramFileManagerEntity.getCloudType() == 0) {
            paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131694809));
          } else {
            paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692478));
          }
        }
      case 3: 
        paramadph.c.setVisibility(0);
        if (!bool) {
          break label697;
        }
        if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 5))
        {
          paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692486));
          return;
        }
        break;
      }
    } while (3 != paramFileManagerEntity.getCloudType());
    paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692477));
    return;
    label697:
    paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692477));
    return;
    paramadph.c.setVisibility(0);
    paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692487));
    return;
    paramadph.c.setVisibility(0);
    paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692481));
    return;
    paramadph.c.setVisibility(0);
    paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692487));
    return;
    paramadph.c.setVisibility(0);
    paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692481));
    return;
    paramadph.c.setVisibility(0);
    paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692481));
    return;
    paramadph.c.setVisibility(0);
    paramadph.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131692487));
  }
  
  private void a(adph paramadph, FileManagerEntity paramFileManagerEntity)
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
        paramadph.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
        paramadph.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((paramadph.e >= 0) && (i - paramadph.e > 1))
        {
          paramadph.e = i;
          QQAppInterface.f(ajyc.a(2131704514) + i);
        }
        paramadph.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(ajyc.a(2131704516) + i);
      }
      break;
    }
    while (paramadph.jdField_a_of_type_AndroidWidgetProgressBar == null)
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
    paramadph.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
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
      paramMessageForFile.fileSizeString = apvb.a(paramMessageForFile.fileSize);
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
    if ((paramView.isMultiMsg) && (!apue.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    Object localObject;
    do
    {
      return;
      localObject = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      if (apvk.a((FileManagerEntity)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileItemBuilder<FileAssistant>", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    paramView = new apud();
    paramView.b = "file_viewer_in";
    paramView.jdField_a_of_type_Int = 9;
    paramView.c = apvb.a(((FileManagerEntity)localObject).fileName);
    paramView.d = apue.a(((FileManagerEntity)localObject).getCloudType(), ((FileManagerEntity)localObject).peerType);
    apuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView);
    apuc.a("0X8004AE3");
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
      paramView = new apoe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject, 10004);
      localObject = new Bundle();
      ((Bundle)localObject).putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.a((Bundle)localObject);
      paramView = new apog(this.jdField_a_of_type_AndroidContentContext, paramView);
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
  
  public acun a()
  {
    return new adph(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxn);
    paramViewGroup = (acun)actn.a(paramView);
    this.jdField_a_of_type_Aotz.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    adph localadph = (adph)paramacun;
    paramacun = paramView;
    if (paramView == null)
    {
      paramacun = a(localadph);
      localadph.jdField_a_of_type_AndroidViewView = paramacun;
    }
    paramChatMessage = (MessageForFile)paramChatMessage;
    a(paramChatMessage);
    a(paramBaseChatItemLayout, paramChatMessage, localadph, paramChatMessage.status);
    paramacun.setOnClickListener(this);
    super.a(paramacun, paramacxn);
    localadph.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramacun;
  }
  
  public bblr a(bblr parambblr, ChatMessage paramChatMessage, acve paramacve)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    long l = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
    paramacve = ancb.a().c();
    paramChatMessage = paramacve;
    if (TextUtils.isEmpty(paramacve)) {
      paramChatMessage = ayfv.jdField_a_of_type_JavaLangString;
    }
    int i;
    if ((16 != localFileManagerEntity.status) && (localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)))
    {
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        parambblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692420), 2130838606);
      }
      if (this.g)
      {
        this.h = anbl.a().c();
        this.g = false;
      }
      if ((this.h) && (localFileManagerEntity != null) && (ayfv.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, paramChatMessage)))
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
        parambblr.a(2131376910, this.jdField_a_of_type_AndroidContentContext.getString(2131720121), 2130838617);
      }
      if (actn.a(5) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          parambblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692416), 2130838605);
        }
        return parambblr;
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
    paramView = (acve)actn.a(paramView);
    if (paramView.a.isMultiMsg) {
      return (MessageForFile)apue.a(paramView.a);
    }
    return (MessageForFile)paramView.a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bbet.a(paramChatMessage.issend)) {
      return ajyc.a(2131704518);
    }
    return ajyc.a(2131704517);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject);
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      return;
      long l1 = awzw.a();
      long l2 = paramChatMessage.time;
      if ((paramChatMessage.msgtype == -2005) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
      {
        aptv.a(ajyc.a(2131704513));
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
        return;
      }
      a(paramChatMessage);
      apuc.a("0X8005E4B");
      continue;
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      continue;
      super.d(paramChatMessage);
      continue;
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
      if (apsz.a((MessageForFile)localObject).a(false))
      {
        if (bcvm.a((Activity)paramContext, 5, new adpa(this, (MessageForFile)localObject, paramContext))) {
          aptr.a(paramContext, 2131692672, 2131692675, new adpb(this, (MessageForFile)localObject, paramContext));
        }
      }
      else
      {
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject, paramContext);
        continue;
        paramContext = new apud();
        paramContext.b = "file_forward";
        paramContext.jdField_a_of_type_Int = 9;
        paramContext.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
        paramContext.c = apvb.a(localFileManagerEntity.fileName);
        paramContext.d = apue.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
        apuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramContext);
        paramContext = new Bundle();
        paramContext.putInt("forward_type", 0);
        paramContext.putBoolean("not_forward", true);
        paramContext.putInt("selection_mode", this.b);
        paramContext.putParcelable("fileinfo", aqce.a(localFileManagerEntity, paramChatMessage));
        paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        paramChatMessage.putExtra("forward_text", ajyc.a(2131704511) + apue.d(localFileManagerEntity.fileName) + ajyc.a(2131704512) + apvb.a(localFileManagerEntity.fileSize) + "。");
        paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
        paramChatMessage.putExtra("forward _key_nojump", true);
        paramChatMessage.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (!bbev.d(BaseApplication.getContext())) {
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131694672, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        }
        for (;;)
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
          if (!((MessageForFile)localObject).isMultiMsg) {
            break;
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
          break;
          aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        }
        axqw.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!bbev.d(BaseApplication.getContext()))
        {
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131694672, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        }
        else
        {
          apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject, paramContext);
          continue;
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644D", "0X800644D", 0, 0, "6", "", "", "");
          apuc.a("0X8005080");
          apsz.a(localFileManagerEntity).a(false, paramContext, new adpc(this, localFileManagerEntity));
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          continue;
          apuc.a("0X8005081");
          if (localFileManagerEntity.getCloudType() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            continue;
            apuc.a("0X8005082");
            boolean bool = localFileManagerEntity.isSend();
            apsz.a(localFileManagerEntity).a(bool, paramContext, new adpd(this, localFileManagerEntity));
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            continue;
            new bgpd(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, paramChatMessage, false);
            if (((MessageForFile)localObject).isMultiMsg)
            {
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
              continue;
              ayec.a(localFileManagerEntity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
              if (((MessageForFile)localObject).isMultiMsg)
              {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
                continue;
                try
                {
                  paramContext = axwi.a(axwi.a(localFileManagerEntity.strFilePath));
                  if (paramContext == null) {
                    continue;
                  }
                  localObject = new SessionInfo();
                  ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
                  ((SessionInfo)localObject).jdField_a_of_type_Int = paramChatMessage.istroop;
                  aaod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject, paramContext);
                }
                catch (Exception paramContext)
                {
                  bcpw.a(this.jdField_a_of_type_AndroidContentContext, ajyc.a(2131704509), 1).a();
                }
                continue;
                ApolloUtil.a(localFileManagerEntity.fileName, localFileManagerEntity.strFilePath, new adpe(this, localFileManagerEntity));
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
    adph localadph = (adph)actn.a(paramView);
    BaseChatItemLayout localBaseChatItemLayout = localadph.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramView = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    if (paramView.getCloudType() == 5)
    {
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.getString(2131689995);
    this.jdField_a_of_type_AndroidContentContext.getString(2131689996);
    String str;
    switch (paramView.nOpType)
    {
    case 6: 
    case 7: 
    default: 
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692446);
    }
    for (paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131692445); localMessageForFile.isSendFromLocal(); paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131692443))
    {
      bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbfol.c(str);
      localbfol.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690596));
      localbfol.a(paramView);
      localbfol.a(new adpf(this, localMessageForFile, localbfol, localBaseChatItemLayout, localadph));
      localbfol.show();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692444);
    }
    paramView = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
    paramView.c(this.jdField_a_of_type_AndroidContentContext.getString(2131692444));
    paramView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690596));
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131692443));
    paramView.a(new adpg(this, localMessageForFile, paramView, localBaseChatItemLayout, localadph));
    paramView.show();
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForFile paramMessageForFile, adph paramadph, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFile);
    Object localObject = localFileManagerEntity.fileName + localFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject))
    {
      axqw.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
    }
    apue.b(localFileManagerEntity);
    paramMessageForFile.fileName = localFileManagerEntity.fileName;
    paramMessageForFile.fileSize = localFileManagerEntity.fileSize;
    paramMessageForFile.status = localFileManagerEntity.status;
    paramMessageForFile.urlAtServer = localFileManagerEntity.strServerPath;
    paramMessageForFile.url = localFileManagerEntity.getFilePath();
    paramMessageForFile.fileSizeString = apvb.a(localFileManagerEntity.fileSize);
    if ((localFileManagerEntity.getCloudType() == 3) || (localFileManagerEntity.getCloudType() == 5)) {
      if (paramadph.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() == 0)
      {
        paramadph.jdField_a_of_type_AndroidWidgetTextView.post(new FileItemBuilder.8(this, paramadph, localFileManagerEntity));
        if ((localFileManagerEntity == null) || (15 != localFileManagerEntity.status) || (9 != localFileManagerEntity.nOpType)) {
          break label433;
        }
        paramadph.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131692864));
      }
    }
    for (;;)
    {
      if (5 != localFileManagerEntity.getCloudType()) {
        break label463;
      }
      return;
      localObject = paramadph.jdField_a_of_type_AndroidWidgetTextView;
      String str = localFileManagerEntity.fileName;
      boolean bool = this.f;
      int j = paramadph.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      TextPaint localTextPaint = paramadph.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.f) {}
      for (int i = 2;; i = 3)
      {
        ((TextView)localObject).setText(apue.a(str, bool, j, localTextPaint, i));
        break;
      }
      if (paramadph.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() == 0)
      {
        paramadph.jdField_a_of_type_AndroidWidgetTextView.post(new FileItemBuilder.9(this, paramadph, localFileManagerEntity));
        break;
      }
      localObject = paramadph.jdField_a_of_type_AndroidWidgetTextView;
      str = localFileManagerEntity.strSrcName;
      bool = this.f;
      j = paramadph.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      localTextPaint = paramadph.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.f) {}
      for (i = 2;; i = 3)
      {
        ((TextView)localObject).setText(apue.a(str, bool, j, localTextPaint, i));
        break;
      }
      label433:
      paramadph.b.setText(apvb.a(paramMessageForFile.fileSize, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    }
    label463:
    a(paramadph, localFileManagerEntity);
    a(paramadph, paramMessageForFile, localFileManagerEntity);
    paramBaseChatItemLayout.setFailedIconVisable(b(localFileManagerEntity), this);
    paramMessageForFile.status = paramInt;
    if (localFileManagerEntity == null)
    {
      apue.a(paramadph.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForFile.fileName);
      return;
    }
    apue.a(paramadph.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacun, paramInt1, paramInt2);
    if (paramChatMessage.isSend())
    {
      paramacun.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848934);
      return;
    }
    paramacun.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848758);
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return (paramFileManagerEntity != null) && ((paramFileManagerEntity.nOpType == 24) || (paramFileManagerEntity.nOpType == 25)) && ((paramFileManagerEntity.status == 2) || (paramFileManagerEntity.status == 0));
  }
  
  public bblt[] a(View paramView)
  {
    paramView = a(paramView);
    bblr localbblr = new bblr();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      a(localbblr, paramView, null);
    }
    for (;;)
    {
      return localbblr.a();
      label38:
      b(localbblr, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  public bblr b(bblr parambblr, ChatMessage paramChatMessage, acve paramacve)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    long l = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
    paramacve = ancb.a().c();
    paramChatMessage = paramacve;
    if (TextUtils.isEmpty(paramacve)) {
      paramChatMessage = ayfv.jdField_a_of_type_JavaLangString;
    }
    int j = 0;
    int i = j;
    if (16 != localFileManagerEntity.status)
    {
      if ((localFileManagerEntity.nOpType == -1) && (localFileManagerEntity.status == -1)) {
        parambblr.a(2131365348, this.jdField_a_of_type_AndroidContentContext.getString(2131692682), 2130838602);
      }
      if (((localFileManagerEntity.nOpType == 0) || (localFileManagerEntity.nOpType == 11)) && (localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.status == 1)) {
        parambblr.a(2131365348, this.jdField_a_of_type_AndroidContentContext.getString(2131692682), 2130838602);
      }
      if ((localFileManagerEntity.nOpType == 11) && (localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.status == 13)) {
        parambblr.a(2131365348, this.jdField_a_of_type_AndroidContentContext.getString(2131692682), 2130838602);
      }
      if (((localFileManagerEntity.nOpType == 7) || (localFileManagerEntity.nOpType == 28) || (localFileManagerEntity.nOpType == 21) || (localFileManagerEntity.nOpType == 22) || (localFileManagerEntity.nOpType == 3) || (localFileManagerEntity.nOpType == 24) || (localFileManagerEntity.nOpType == 25)) && ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1))) {
        parambblr.a(2131365348, this.jdField_a_of_type_AndroidContentContext.getString(2131692682), 2130838602);
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
              parambblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692420), 2130838606);
            }
            if (this.g)
            {
              this.h = anbl.a().c();
              this.g = false;
            }
            if ((this.h) && (localFileManagerEntity != null) && (ayfv.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, paramChatMessage)))
            {
              j = 0;
              if (localFileManagerEntity.status == 16) {
                break label938;
              }
              i = 1;
              label512:
              if ((i != 0) && (localFileManagerEntity.fileSize <= l))
              {
                parambblr.a(2131376910, this.jdField_a_of_type_AndroidContentContext.getString(2131720121), 2130838617);
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
              }
            }
            if (actn.a(5) != 1) {
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
      ApolloUtil.a(parambblr, localFileManagerEntity.fileName);
      a(localMessageForFile, parambblr);
      if (QLog.isColorLevel()) {
        QLog.i("msgrevoke", 2, "FileMenuitem entity.status:" + localFileManagerEntity.status);
      }
      if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
        a(parambblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForFile);
      }
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        super.c(parambblr, this.jdField_a_of_type_AndroidContentContext);
      }
      a(parambblr, localMessageForFile);
      if (i != 0) {
        parambblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692416), 2130838605);
      }
      if (16 != localFileManagerEntity.status) {
        b(localMessageForFile, parambblr);
      }
      super.e(parambblr, this.jdField_a_of_type_AndroidContentContext);
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
        parambblr.a(2131366659, this.jdField_a_of_type_AndroidContentContext.getString(2131692473), 2130838606);
      }
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
        parambblr.a(2131375571, this.jdField_a_of_type_AndroidContentContext.getString(2131692472), 2130838606);
      }
      return parambblr;
      parambblr.a(2131365348, this.jdField_a_of_type_AndroidContentContext.getString(2131692682), 2130838602);
      break;
      parambblr.a(2131371297, this.jdField_a_of_type_AndroidContentContext.getString(2131692684), 2130838609);
      break;
      parambblr.a(2131375196, this.jdField_a_of_type_AndroidContentContext.getString(2131692842), 2130838611);
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
    actn.n = true;
    if (super.a()) {
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131364118: 
    default: 
      return;
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", 0, 0, "4", "", "", "");
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adoz
 * JD-Core Version:    0.7.0.1
 */