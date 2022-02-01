import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahcj
  extends BaseBubbleBuilder
  implements aggk, arwz
{
  protected final float b;
  
  public ahcj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggk a(View paramView)
  {
    paramView = agej.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public aggl a()
  {
    return new ahcm(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramView = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    if (("device_groupchat".equals(((MessageForDeviceFile)paramChatMessage).extStr)) && (paramView != null))
    {
      paramChatMessage = (MessageForDeviceFile)paramChatMessage;
      if ((TextUtils.isEmpty(paramChatMessage.filePath)) || (aunj.a(paramChatMessage.filePath) == 0L))
      {
        paramViewGroup = (abzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        if (!TextUtils.isEmpty(paramChatMessage.strMediaKey)) {
          paramViewGroup.a().a(paramChatMessage, paramView, this);
        }
      }
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    ahcm localahcm = (ahcm)paramaggl;
    paramaggl = paramView;
    if (paramView == null)
    {
      paramaggl = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131372628);
      if (!jdField_a_of_type_Boolean) {
        paramView.setAdjustViewBounds(true);
      }
      paramView.setMaxWidth((int)(this.jdField_b_of_type_Float * 100.0F + 0.5F));
      paramView.setMaxHeight((int)(this.jdField_b_of_type_Float * 100.0F + 0.5F));
      paramView.setAsyncClipSize((int)(this.jdField_b_of_type_Float * 100.0F + 0.5F), (int)(this.jdField_b_of_type_Float * 100.0F + 0.5F));
      paramView.setDefaultImageByMargin();
      paramView.setIsDrawRound(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      paramaggl.addView(paramView, localLayoutParams);
      localahcm.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = paramView;
      paramView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setTextColor(-1);
      int i = (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
      paramView.setTextSize(2, 15.0F);
      paramView.setGravity(17);
      if (jdField_a_of_type_Boolean) {
        paramView.setDisplayInTextView(false, i, -1);
      }
      paramView.setBackgroundDrawable(new agxx(2130706432, this.jdField_b_of_type_Float * 12.0F));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131372628);
      localLayoutParams.addRule(8, 2131372628);
      localLayoutParams.addRule(5, 2131372628);
      localLayoutParams.addRule(7, 2131372628);
      paramaggl.addView(paramView, localLayoutParams);
      paramView.setVisibility(8);
      localahcm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = paramView;
      paramaggl.setOnClickListener(this);
      paramaggl.setOnTouchListener(paramagjk);
      paramaggl.setOnLongClickListener(paramagjk);
    }
    paramBaseChatItemLayout.setTag(localahcm);
    paramChatMessage = (MessageForDeviceFile)paramChatMessage;
    if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.msgStatus == 2))
    {
      paramView = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramView instanceof QQAppInterface))
      {
        paramView = (QQAppInterface)paramView;
        if (!bhnv.d(BaseApplication.getContext()))
        {
          paramChatMessage.nFileStatus = 6;
          paramChatMessage.msgStatus = 1;
          paramChatMessage.serial();
          paramView.a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq, paramChatMessage.msgData);
        }
      }
    }
    a(paramBaseChatItemLayout, paramChatMessage, localahcm);
    ((abzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramaggl, this);
    return paramaggl;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anzj.a(2131702098);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131365352) {
        break label36;
      }
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131371530)
      {
        super.d(paramChatMessage);
        return;
      }
    } while (paramInt != 2131367078);
    paramChatMessage = new Bundle();
    paramChatMessage.putInt("forward_type", 1);
    paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramChatMessage.putInt("selection_mode", this.jdField_b_of_type_Int);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_filepath", paramContext.filePath);
    localIntent.putExtra("BUSI_TYPE", 1009);
    localIntent.putExtra("forward_download_image_org_uin", paramContext.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramContext.istroop);
    localIntent.putExtra("forward_photo_isSend", paramContext.issend);
    localIntent.putExtras(paramChatMessage);
    auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (agej.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForDeviceFile)((ahcm)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.isSendFromLocal())
    {
      localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
      localblir.a(2131689933, 5);
      localblir.c(2131690580);
      localblir.a(new ahck(this, paramView, localblir));
      localblir.show();
      return;
    }
    blir localblir = blir.a(this.jdField_a_of_type_AndroidContentContext);
    localblir.a(2131691389);
    localblir.b(2131691388);
    localblir.c(2131690580);
    localblir.a(new ahcl(this, paramView, localblir));
    localblir.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, MessageForDeviceFile paramMessageForDeviceFile)
  {
    paramView = (ahcm)agej.a(paramView);
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DevicePicItemBuilder", 2, "error get holder in updateview");
      }
    }
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (localMessageForDeviceFile.uniseq != paramMessageForDeviceFile.uniseq);
    localMessageForDeviceFile.msgStatus = paramMessageForDeviceFile.msgStatus;
    localMessageForDeviceFile.nFileStatus = paramMessageForDeviceFile.nFileStatus;
    localMessageForDeviceFile.progress = paramMessageForDeviceFile.progress;
    localMessageForDeviceFile.msg = paramMessageForDeviceFile.msg;
    a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForDeviceFile, paramView);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, ahcm paramahcm)
  {
    boolean bool = false;
    String str = paramMessageForDeviceFile.filePath;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      if (!TextUtils.isEmpty(str)) {
        paramahcm.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(str);
      }
      break;
    }
    for (;;)
    {
      paramBaseChatItemLayout.setFailedIconVisable(bool, this);
      return;
      if (paramMessageForDeviceFile.issend == 0)
      {
        paramahcm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        break;
      }
      paramahcm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
      paramahcm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
      break;
      paramahcm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
      paramahcm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
      break;
      paramahcm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
      break;
      paramahcm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
      break;
      paramahcm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
      bool = true;
      break;
      paramahcm.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawableDefault();
    }
  }
  
  void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      auna.a(2131692319);
      return;
    }
    if (bhmi.b(paramMessageForDeviceFile.filePath)) {
      ((abzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(abzb.d, paramMessageForDeviceFile);
    }
    b();
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    aean.a(localbhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((ahcm)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localbhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
    }
    super.c(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = agej.a(paramView);
    if (localChatMessage == null) {}
    do
    {
      do
      {
        return;
      } while (localChatMessage.istroop != 9501);
      if (localChatMessage.isSendFromLocal())
      {
        super.b(paramView);
        return;
      }
    } while (!"device_groupchat".equals(localChatMessage.extStr));
    super.b(paramView);
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      auna.a(2131692319);
      return;
    }
    ((abzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    if (super.a())
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject1;
    Intent localIntent;
    if (paramView.getId() == 2131364423) {
      try
      {
        Object localObject2 = (MessageForDeviceFile)agej.a(paramView);
        FileManagerEntity localFileManagerEntity = aunj.a((MessageForDeviceFile)localObject2);
        localObject1 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject1).b(10009);
        ((ForwardFileInfo)localObject1).d(8);
        ((ForwardFileInfo)localObject1).b(localFileManagerEntity.nSessionId);
        ((ForwardFileInfo)localObject1).d(localFileManagerEntity.fileName);
        ((ForwardFileInfo)localObject1).c(localFileManagerEntity.uniseq);
        ((ForwardFileInfo)localObject1).d(localFileManagerEntity.fileSize);
        ((ForwardFileInfo)localObject1).a(localFileManagerEntity.getFilePath());
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
        localIntent.putExtra("fileinfo", (Parcelable)localObject1);
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(String.valueOf(localFileManagerEntity.nSessionId));
        if (localFileManagerEntity.nFileType == 0)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForDeviceFile)localObject2).frienduin, ((MessageForDeviceFile)localObject2).istroop);
          if ((localObject2 != null) && (((List)localObject2).size() != 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
              if (((ChatMessage)localObject3).msgtype == -4500)
              {
                localObject3 = (MessageForDeviceFile)localObject3;
                if (aunj.a(((MessageForDeviceFile)localObject3).filePath) == localFileManagerEntity.nFileType)
                {
                  localObject3 = aunj.a((MessageForDeviceFile)localObject3);
                  if (!((ArrayList)localObject1).contains(String.valueOf(((FileManagerEntity)localObject3).nSessionId)))
                  {
                    ((ArrayList)localObject1).add(String.valueOf(((FileManagerEntity)localObject3).nSessionId));
                    continue;
                    super.onClick(paramView);
                  }
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    for (;;)
    {
      break;
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcj
 * JD-Core Version:    0.7.0.1
 */