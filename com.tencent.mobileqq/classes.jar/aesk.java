import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource.PublishCommentCallback;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSourceImpl;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

public class aesk
  extends ProtoUtils.TroopGiftProtocolObserver
{
  public aesk(CommentsDataSourceImpl paramCommentsDataSourceImpl, CommentsDataSource.PublishCommentCallback paramPublishCommentCallback, Comments.Comment paramComment) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("CommentsDataSource", 1, "errorCode:" + paramInt);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.i("CommentsDataSource", 2, "err_msg:   " + paramBundle.err_msg.get());
        }
        if (!paramBundle.busi_buf.has())
        {
          QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource$PublishCommentCallback.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1);
          return;
        }
        paramArrayOfByte = new NowNearbyVideoCommentProto.AddCommentResp();
        paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
        QLog.i("CommentsDataSource", 1, "id: " + paramArrayOfByte.comment_id.get() + ",ret:" + paramArrayOfByte.result.get());
        if (paramArrayOfByte.result.get() != 0L)
        {
          QLog.i("CommentsDataSource", 1, "error code :" + paramArrayOfByte.result.get());
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource$PublishCommentCallback.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, (int)paramArrayOfByte.result.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("CommentsDataSource", 1, "merge publish resp data error");
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource$PublishCommentCallback.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1);
        return;
      }
      if (paramArrayOfByte.comment_id.get() > 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment.a = paramArrayOfByte.comment_id.get();
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource$PublishCommentCallback.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment);
        CommentsDataSourceImpl.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSourceImpl).add(Long.valueOf(paramArrayOfByte.comment_id.get()));
        paramArrayOfByte = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramArrayOfByte != null) {
          ((NearbyMomentManager)paramArrayOfByte.getManager(262)).f(CommentsDataSourceImpl.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSourceImpl).a);
        }
      }
    }
    else
    {
      QLog.i("CommentsDataSource", 1, "publishComment failed");
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource$PublishCommentCallback.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aesk
 * JD-Core Version:    0.7.0.1
 */