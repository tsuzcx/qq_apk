import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

public class akex
{
  public QQAppInterface a;
  
  public boolean a(MessageForScribble paramMessageForScribble, String paramString, ayeo paramayeo)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 262153;
    localTransferRequest.mSelfUin = paramMessageForScribble.selfuin;
    localTransferRequest.mPeerUin = paramMessageForScribble.frienduin;
    localTransferRequest.mUinType = paramMessageForScribble.istroop;
    localTransferRequest.mUniseq = paramMessageForScribble.uniseq;
    localTransferRequest.mUpCallBack = paramayeo;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mRec = paramMessageForScribble;
    paramMessageForScribble.fileUploadStatus = 3;
    this.a.getTransFileController().transferAsync(localTransferRequest);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akex
 * JD-Core Version:    0.7.0.1
 */