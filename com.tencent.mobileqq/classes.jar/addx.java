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
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class addx
  extends BaseBubbleBuilder
  implements acjx
{
  private aodf jdField_a_of_type_Aodf;
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
      if ((paramString2.cloudType == 1) && (apck.a(paramString2))) {
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
    paramString1.status = apck.b(paramString1.status);
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
  private View a(adef paramadef)
  {
    View localView = admc.a(this.jdField_a_of_type_AndroidContentContext);
    paramadef.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localView.findViewById(2131298521));
    paramadef.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298523));
    paramadef.c = ((TextView)localView.findViewById(2131298525));
    paramadef.b = ((TextView)localView.findViewById(2131298520));
    paramadef.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131298524));
    paramadef = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    if ((ajia.a() > 17.0F) || (paramadef.widthPixels <= 500))
    {
      this.f = true;
      return localView;
    }
    this.f = false;
    return localView;
  }
  
  private String a(long paramLong1, long paramLong2, String paramString)
  {
    atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (TransFileInfo)localatmp.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString });
    localatmp.a();
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
  
  private void a(adef paramadef, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramadef.c.setVisibility(8);
    }
    String str;
    do
    {
      return;
      if (paramMessageForFile.fakeSenderType != 0)
      {
        paramadef.c.setText("");
        return;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131626862);
      boolean bool = paramMessageForFile.isSend();
      if (paramMessageForFile.isMultiMsg) {
        bool = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFile);
      }
      switch (paramFileManagerEntity.status)
      {
      case 2: 
      case 14: 
      case 15: 
      default: 
        paramadef.c.setVisibility(4);
        return;
      case 0: 
        paramadef.c.setVisibility(0);
        if (bool)
        {
          if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 5))
          {
            paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626873));
            return;
          }
          paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626872));
          return;
        }
        paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626871));
        return;
      case 16: 
        paramadef.c.setVisibility(0);
        paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626868));
        return;
      case -1: 
        paramadef.c.setVisibility(0);
        if (bool)
        {
          paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626873));
          return;
        }
        paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626874));
        return;
      case 1: 
        paramadef.c.setVisibility(0);
        if (bool) {
          paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626873));
        }
        while ((AppSetting.c) && (paramadef.e >= 0))
        {
          QQAppInterface.f(ajjy.a(2131638730));
          paramadef.e = -1;
          return;
          if (paramFileManagerEntity.getCloudType() == 0) {
            paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131629132));
          } else {
            paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626865));
          }
        }
      case 3: 
        paramadef.c.setVisibility(0);
        if (!bool) {
          break label709;
        }
        if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 5))
        {
          paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626873));
          return;
        }
        break;
      }
    } while (3 != paramFileManagerEntity.getCloudType());
    paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626864));
    return;
    label709:
    paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626864));
    return;
    paramadef.c.setVisibility(0);
    paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626874));
    return;
    paramadef.c.setVisibility(0);
    paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626868));
    return;
    paramadef.c.setVisibility(0);
    paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626874));
    return;
    paramadef.c.setVisibility(0);
    paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626868));
    return;
    paramadef.c.setVisibility(0);
    paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626868));
    return;
    paramadef.c.setVisibility(0);
    paramadef.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131626874));
  }
  
  private void a(adef paramadef, FileManagerEntity paramFileManagerEntity)
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
        paramadef.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
        paramadef.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((paramadef.e >= 0) && (i - paramadef.e > 1))
        {
          paramadef.e = i;
          QQAppInterface.f(ajjy.a(2131638729) + i);
        }
        paramadef.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(ajjy.a(2131638731) + i);
      }
      break;
    }
    while (paramadef.jdField_a_of_type_AndroidWidgetProgressBar == null)
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
    paramadef.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
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
      paramMessageForFile.fileSizeString = apdh.a(paramMessageForFile.fileSize);
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
    if ((paramView.isMultiMsg) && (!apck.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    Object localObject;
    do
    {
      return;
      localObject = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      if (apdq.a((FileManagerEntity)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileItemBuilder<FileAssistant>", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    paramView = new apcj();
    paramView.b = "file_viewer_in";
    paramView.jdField_a_of_type_Int = 9;
    paramView.c = apdh.a(((FileManagerEntity)localObject).fileName);
    paramView.d = apck.a(((FileManagerEntity)localObject).getCloudType(), ((FileManagerEntity)localObject).peerType);
    apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView);
    apci.a("0X8004AE3");
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
      paramView = new aowq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject, 10004);
      localObject = new Bundle();
      ((Bundle)localObject).putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.a((Bundle)localObject);
      paramView = new aows(this.jdField_a_of_type_AndroidContentContext, paramView);
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
  
  public acju a()
  {
    return new adef(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    paramViewGroup = (acju)aciy.a(paramView);
    this.jdField_a_of_type_Aodf.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    adef localadef = (adef)paramacju;
    paramacju = paramView;
    if (paramView == null)
    {
      paramacju = a(localadef);
      localadef.jdField_a_of_type_AndroidViewView = paramacju;
    }
    paramChatMessage = (MessageForFile)paramChatMessage;
    a(paramChatMessage);
    a(paramBaseChatItemLayout, paramChatMessage, localadef, paramChatMessage.status);
    paramacju.setOnClickListener(this);
    super.a(paramacju, paramacmv);
    localadef.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramacju;
  }
  
  public bakh a(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    long l = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
    paramackl = amlu.a().c();
    paramChatMessage = paramackl;
    if (TextUtils.isEmpty(paramackl)) {
      paramChatMessage = axfs.jdField_a_of_type_JavaLangString;
    }
    int i;
    if ((16 != localFileManagerEntity.status) && (localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)))
    {
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131626819), 2130838599);
      }
      if (this.g)
      {
        this.h = amlh.a().c();
        this.g = false;
      }
      if ((this.h) && (localFileManagerEntity != null) && (axfs.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, paramChatMessage)))
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
        parambakh.a(2131311102, this.jdField_a_of_type_AndroidContentContext.getString(2131654231), 2130838610);
      }
      if (aciy.a(5) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626815), 2130838598);
        }
        return parambakh;
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
    paramView = (ackl)aciy.a(paramView);
    if (paramView.a.isMultiMsg) {
      return (MessageForFile)apck.a(paramView.a);
    }
    return (MessageForFile)paramView.a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bado.a(paramChatMessage.issend)) {
      return ajjy.a(2131638733);
    }
    return ajjy.a(2131638732);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject);
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      return;
      long l1 = awao.a();
      long l2 = paramChatMessage.time;
      if ((paramChatMessage.msgtype == -2005) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
      {
        apcb.a(ajjy.a(2131638728));
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
        return;
      }
      a(paramChatMessage);
      apci.a("0X8005E4B");
      continue;
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      continue;
      super.d(paramChatMessage);
      continue;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
      if (apbf.a((MessageForFile)localObject).a(false))
      {
        if (bbrm.a((Activity)paramContext, 5, new addy(this, (MessageForFile)localObject, paramContext))) {
          apbx.a(paramContext, 2131627035, 2131627038, new addz(this, (MessageForFile)localObject, paramContext));
        }
      }
      else
      {
        apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject, paramContext);
        continue;
        paramContext = new apcj();
        paramContext.b = "file_forward";
        paramContext.jdField_a_of_type_Int = 9;
        paramContext.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
        paramContext.c = apdh.a(localFileManagerEntity.fileName);
        paramContext.d = apck.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
        apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramContext);
        paramContext = new Bundle();
        paramContext.putInt("forward_type", 0);
        paramContext.putBoolean("not_forward", true);
        paramContext.putInt("selection_mode", this.b);
        paramContext.putParcelable("fileinfo", apir.a(localFileManagerEntity, paramChatMessage));
        paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        paramChatMessage.putExtra("forward_text", ajjy.a(2131638726) + apck.d(localFileManagerEntity.fileName) + ajjy.a(2131638727) + apdh.a(localFileManagerEntity.fileSize) + "。");
        paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
        paramChatMessage.putExtra("forward _key_nojump", true);
        paramChatMessage.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (!badq.d(BaseApplication.getContext())) {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131629008, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        }
        for (;;)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
          if (!((MessageForFile)localObject).isMultiMsg) {
            break;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
          break;
          aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        }
        awqx.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!badq.d(BaseApplication.getContext()))
        {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131629008, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        }
        else
        {
          apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject, paramContext);
          continue;
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644D", "0X800644D", 0, 0, "6", "", "", "");
          apci.a("0X8005080");
          apbf.a(localFileManagerEntity).a(false, paramContext, new adea(this, localFileManagerEntity));
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          continue;
          apci.a("0X8005081");
          if (localFileManagerEntity.getCloudType() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            continue;
            apci.a("0X8005082");
            boolean bool = localFileManagerEntity.isSend();
            apbf.a(localFileManagerEntity).a(bool, paramContext, new adeb(this, localFileManagerEntity));
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            continue;
            new bfhl(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, paramChatMessage, false);
            if (((MessageForFile)localObject).isMultiMsg)
            {
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
              continue;
              axea.a(localFileManagerEntity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
              if (((MessageForFile)localObject).isMultiMsg)
              {
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
                continue;
                try
                {
                  paramContext = awwg.a(awwg.a(localFileManagerEntity.strFilePath));
                  if (paramContext == null) {
                    continue;
                  }
                  localObject = new SessionInfo();
                  ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
                  ((SessionInfo)localObject).jdField_a_of_type_Int = paramChatMessage.istroop;
                  aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject, paramContext);
                }
                catch (Exception paramContext)
                {
                  bbmy.a(this.jdField_a_of_type_AndroidContentContext, ajjy.a(2131638724), 1).a();
                }
                continue;
                ApolloUtil.a(localFileManagerEntity.fileName, localFileManagerEntity.strFilePath, new adec(this, localFileManagerEntity));
                continue;
                ApolloUtil.e(localFileManagerEntity.strFilePath);
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
    adef localadef = (adef)aciy.a(paramView);
    BaseChatItemLayout localBaseChatItemLayout = localadef.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramView = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    if (paramView.getCloudType() == 5)
    {
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.getString(2131624443);
    this.jdField_a_of_type_AndroidContentContext.getString(2131624444);
    String str;
    switch (paramView.nOpType)
    {
    case 6: 
    case 7: 
    default: 
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131626845);
    }
    for (paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131626844); localMessageForFile.isSendFromLocal(); paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131626842))
    {
      begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbegr.c(str);
      localbegr.d(this.jdField_a_of_type_AndroidContentContext.getString(2131625035));
      localbegr.a(paramView);
      localbegr.a(new aded(this, localMessageForFile, localbegr, localBaseChatItemLayout, localadef));
      localbegr.show();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131626843);
    }
    paramView = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
    paramView.c(this.jdField_a_of_type_AndroidContentContext.getString(2131626843));
    paramView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131625035));
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131626842));
    paramView.a(new adee(this, localMessageForFile, paramView, localBaseChatItemLayout, localadef));
    paramView.show();
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForFile paramMessageForFile, adef paramadef, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFile);
    Object localObject = localFileManagerEntity.fileName + localFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject))
    {
      awqx.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
    }
    apck.b(localFileManagerEntity);
    paramMessageForFile.fileName = localFileManagerEntity.fileName;
    paramMessageForFile.fileSize = localFileManagerEntity.fileSize;
    paramMessageForFile.status = localFileManagerEntity.status;
    paramMessageForFile.urlAtServer = localFileManagerEntity.strServerPath;
    paramMessageForFile.url = localFileManagerEntity.getFilePath();
    paramMessageForFile.fileSizeString = apdh.a(localFileManagerEntity.fileSize);
    if ((localFileManagerEntity.getCloudType() == 3) || (localFileManagerEntity.getCloudType() == 5)) {
      if (paramadef.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() == 0)
      {
        paramadef.jdField_a_of_type_AndroidWidgetTextView.post(new FileItemBuilder.8(this, paramadef, localFileManagerEntity));
        if ((localFileManagerEntity == null) || (15 != localFileManagerEntity.status) || (9 != localFileManagerEntity.nOpType)) {
          break label433;
        }
        paramadef.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131627226));
      }
    }
    for (;;)
    {
      if (5 != localFileManagerEntity.getCloudType()) {
        break label463;
      }
      return;
      localObject = paramadef.jdField_a_of_type_AndroidWidgetTextView;
      String str = localFileManagerEntity.fileName;
      boolean bool = this.f;
      int j = paramadef.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      TextPaint localTextPaint = paramadef.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.f) {}
      for (int i = 2;; i = 3)
      {
        ((TextView)localObject).setText(apck.a(str, bool, j, localTextPaint, i));
        break;
      }
      if (paramadef.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() == 0)
      {
        paramadef.jdField_a_of_type_AndroidWidgetTextView.post(new FileItemBuilder.9(this, paramadef, localFileManagerEntity));
        break;
      }
      localObject = paramadef.jdField_a_of_type_AndroidWidgetTextView;
      str = localFileManagerEntity.strSrcName;
      bool = this.f;
      j = paramadef.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      localTextPaint = paramadef.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.f) {}
      for (i = 2;; i = 3)
      {
        ((TextView)localObject).setText(apck.a(str, bool, j, localTextPaint, i));
        break;
      }
      label433:
      paramadef.b.setText(apdh.a(paramMessageForFile.fileSize, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    }
    label463:
    a(paramadef, localFileManagerEntity);
    a(paramadef, paramMessageForFile, localFileManagerEntity);
    paramBaseChatItemLayout.setFailedIconVisable(b(localFileManagerEntity), this);
    paramMessageForFile.status = paramInt;
    if (localFileManagerEntity == null)
    {
      apck.a(paramadef.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForFile.fileName);
      return;
    }
    apck.a(paramadef.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
    if (paramChatMessage.isSend())
    {
      paramacju.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848708);
      return;
    }
    paramacju.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848515);
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return (paramFileManagerEntity != null) && ((paramFileManagerEntity.nOpType == 24) || (paramFileManagerEntity.nOpType == 25)) && ((paramFileManagerEntity.status == 2) || (paramFileManagerEntity.status == 0));
  }
  
  public bakj[] a(View paramView)
  {
    paramView = a(paramView);
    bakh localbakh = new bakh();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      a(localbakh, paramView, null);
    }
    for (;;)
    {
      return localbakh.a();
      label38:
      b(localbakh, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  public bakh b(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    long l = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
    paramackl = amlu.a().c();
    paramChatMessage = paramackl;
    if (TextUtils.isEmpty(paramackl)) {
      paramChatMessage = axfs.jdField_a_of_type_JavaLangString;
    }
    int j = 0;
    int i = j;
    if (16 != localFileManagerEntity.status)
    {
      if ((localFileManagerEntity.nOpType == -1) && (localFileManagerEntity.status == -1)) {
        parambakh.a(2131299781, this.jdField_a_of_type_AndroidContentContext.getString(2131627045), 2130838595);
      }
      if (((localFileManagerEntity.nOpType == 0) || (localFileManagerEntity.nOpType == 11)) && (localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.status == 1)) {
        parambakh.a(2131299781, this.jdField_a_of_type_AndroidContentContext.getString(2131627045), 2130838595);
      }
      if ((localFileManagerEntity.nOpType == 11) && (localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.status == 13)) {
        parambakh.a(2131299781, this.jdField_a_of_type_AndroidContentContext.getString(2131627045), 2130838595);
      }
      if (((localFileManagerEntity.nOpType == 7) || (localFileManagerEntity.nOpType == 28) || (localFileManagerEntity.nOpType == 21) || (localFileManagerEntity.nOpType == 22) || (localFileManagerEntity.nOpType == 3) || (localFileManagerEntity.nOpType == 24) || (localFileManagerEntity.nOpType == 25)) && ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1))) {
        parambakh.a(2131299781, this.jdField_a_of_type_AndroidContentContext.getString(2131627045), 2130838595);
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
              parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131626819), 2130838599);
            }
            if (this.g)
            {
              this.h = amlh.a().c();
              this.g = false;
            }
            if ((this.h) && (localFileManagerEntity != null) && (axfs.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, paramChatMessage)))
            {
              j = 0;
              if (localFileManagerEntity.status == 16) {
                break label938;
              }
              i = 1;
              label512:
              if ((i != 0) && (localFileManagerEntity.fileSize <= l))
              {
                parambakh.a(2131311102, this.jdField_a_of_type_AndroidContentContext.getString(2131654231), 2130838610);
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
              }
            }
            if (aciy.a(5) != 1) {
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
      ApolloUtil.a(parambakh, localFileManagerEntity.fileName);
      a(localMessageForFile, parambakh);
      if (QLog.isColorLevel()) {
        QLog.i("msgrevoke", 2, "FileMenuitem entity.status:" + localFileManagerEntity.status);
      }
      if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
        a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForFile);
      }
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        super.c(parambakh, this.jdField_a_of_type_AndroidContentContext);
      }
      a(parambakh, localMessageForFile);
      if (i != 0) {
        parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626815), 2130838598);
      }
      if (16 != localFileManagerEntity.status) {
        b(localMessageForFile, parambakh);
      }
      super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
        parambakh.a(2131301048, this.jdField_a_of_type_AndroidContentContext.getString(2131626860), 2130838599);
      }
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
        parambakh.a(2131309812, this.jdField_a_of_type_AndroidContentContext.getString(2131626859), 2130838599);
      }
      return parambakh;
      parambakh.a(2131299781, this.jdField_a_of_type_AndroidContentContext.getString(2131627045), 2130838595);
      break;
      parambakh.a(2131305601, this.jdField_a_of_type_AndroidContentContext.getString(2131627047), 2130838602);
      break;
      parambakh.a(2131309448, this.jdField_a_of_type_AndroidContentContext.getString(2131627204), 2130838604);
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
    aciy.n = true;
    if (super.a()) {
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131298560: 
    default: 
      return;
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", 0, 0, "4", "", "", "");
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     addx
 * JD-Core Version:    0.7.0.1
 */