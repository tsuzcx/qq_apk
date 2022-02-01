import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;

class alyk
  implements FaceDecoder.DecodeTaskCompletionListener
{
  protected FaceDecoder a;
  boolean jdField_a_of_type_Boolean = true;
  
  public alyk(alyc paramalyc, Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramContext, paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private Bitmap a(String paramString, int paramInt1, byte paramByte, int paramInt2)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCacheFrom(paramInt1, paramString, paramInt2);
      localObject = localBitmap;
    } while (localBitmap != null);
    QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "requestDecodeFace, uin[" + paramString + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, paramInt1, true, paramByte);
    return bheg.a();
  }
  
  public Bitmap a(TroopMemberInfo paramTroopMemberInfo)
  {
    return a(paramTroopMemberInfo.memberuin, 1, (byte)0, 0);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "onDecodeTaskCompleted, uin[" + paramString + "]");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    alyc.a(this.jdField_a_of_type_Alyc, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyk
 * JD-Core Version:    0.7.0.1
 */