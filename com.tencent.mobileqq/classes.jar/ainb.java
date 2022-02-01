import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.PttSliceUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.WXVadSeg;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ainb
{
  private int jdField_a_of_type_Int;
  private aine jdField_a_of_type_Aine;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ainc(this);
  private String jdField_a_of_type_JavaLangString;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private aing[] jdField_a_of_type_ArrayOfAing;
  private String b;
  
  private List<WXVadSeg> a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "vadHelper  vad start");
    }
    bhik localbhik = new bhik();
    localbhik.d();
    List localList = localbhik.a(this.b);
    localbhik.b();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "vadHelper  vad start");
    }
    return localList;
  }
  
  private void a(String paramString, List<WXVadSeg> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper size=" + paramList.size() + " unFinishSegSize=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " isSttFinish=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      int i = 0;
      while (i < paramList.size())
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.mIsUp = true;
        localTransferRequest.mCommandId = 68;
        localTransferRequest.mLocalPath = paramString;
        localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
        localTransferRequest.mPeerUin = this.jdField_a_of_type_JavaLangString;
        localTransferRequest.mFileType = 327696;
        localTransferRequest.mRichTag = "pttSliceToText";
        localTransferRequest.pcmForVadPath = this.b;
        localTransferRequest.pcmForVadNum = paramList.size();
        localTransferRequest.pcmForVadPos = i;
        localTransferRequest.vadSeg = ((WXVadSeg)paramList.get(i));
        localTransferRequest.chatType = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.transferAsync(localTransferRequest);
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest pos=" + i);
        }
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localTransferRequest.mUniseq));
        i += 1;
      }
    }
  }
  
  int a(int paramInt)
  {
    if (paramInt == 3000) {}
    for (int i = 1;; i = 2)
    {
      if (paramInt == 0) {
        return 2;
      }
      return i;
    }
  }
  
  String a(aing paramaing, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAing[paramInt] = paramaing;
    paramaing = new StringBuffer();
    paramInt = 0;
    for (;;)
    {
      aing localaing;
      if (paramInt < this.jdField_a_of_type_ArrayOfAing.length)
      {
        localaing = this.jdField_a_of_type_ArrayOfAing[paramInt];
        if (localaing != null) {
          break label42;
        }
      }
      label42:
      do
      {
        return paramaing.toString();
        paramaing.append(localaing.jdField_a_of_type_JavaLangString);
      } while (!localaing.jdField_a_of_type_Boolean);
      paramInt += 1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "cancelAllRequest sendIds len=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.cancelVoiceTextTask(this.jdField_a_of_type_JavaLangString, ((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue());
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(aine paramaine)
  {
    this.jdField_a_of_type_Aine = paramaine;
  }
  
  void a(aing paramaing, int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfAing == null) || (paramInt >= this.jdField_a_of_type_ArrayOfAing.length) || ((this.jdField_a_of_type_ArrayOfAing[paramInt] != null) && (this.jdField_a_of_type_ArrayOfAing[paramInt].jdField_a_of_type_Boolean))) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "updateText fail");
      }
    }
    do
    {
      return;
      paramaing = a(paramaing, paramInt);
    } while (this.jdField_a_of_type_Aine == null);
    this.jdField_a_of_type_Aine.a(paramaing);
  }
  
  public void a(String paramString)
  {
    bjum.a(new VoiceTextSttQueryController.2(this, paramString));
  }
  
  void a(String paramString1, QQAppInterface paramQQAppInterface, aine paramaine, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.jdField_a_of_type_Aine = paramaine;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { PttSliceUploadProcessor.class });
  }
  
  public void b()
  {
    a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainb
 * JD-Core Version:    0.7.0.1
 */