import android.content.Intent;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper.1;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper.2;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class aebq
  implements anrm
{
  public static final String a;
  public int a;
  public aebs a;
  public Uri a;
  Handler.Callback a;
  public anrl a;
  public bisl a;
  public bkys a;
  public final BaseActivity a;
  public QQAppInterface a;
  public Runnable a;
  public boolean a;
  public byte[] a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = aebq.class.getSimpleName();
  }
  
  public aebq(BaseActivity paramBaseActivity, aebs paramaebs)
  {
    this.jdField_a_of_type_JavaLangRunnable = new FriendProfilePhotoHelper.2(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new aebr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Aebs = paramaebs;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramBaseActivity = (anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramBaseActivity != null) {
      this.jdField_a_of_type_Anrl = paramBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anrl != null)
    {
      ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_Anrl);
      this.jdField_a_of_type_Anrl = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.b = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onSendFailed resultCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    this.jdField_a_of_type_Bkys.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    c();
    int i = 2131719836;
    if (paramInt == 1503) {
      i = 2131698757;
    }
    this.jdField_a_of_type_Aebs.a(i, 1);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      this.jdField_a_of_type_Aebs.a(2131694305, 1);
    }
    label21:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            ArrayList localArrayList;
            do
            {
              break label21;
              break label21;
              break label21;
              do
              {
                return;
              } while (paramIntent == null);
              i = paramIntent.getIntExtra("req_code_key", 0);
              if (i != 1025) {
                break;
              }
              localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            } while ((localArrayList == null) || (localArrayList.size() <= 0));
            anri localanri = (anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
            {
              localanri.a((String)localArrayList.get(0));
              b();
              this.jdField_a_of_type_Bkys.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
              return;
            }
            localanri.a(localArrayList);
            b();
            return;
            if (i != 1020) {
              break;
            }
          } while ((paramInt != -1) || (paramIntent == null));
          paramIntent = paramIntent.getStringExtra("key_cover_selected_img_path");
        } while (TextUtils.isEmpty(paramIntent));
        a(paramIntent);
        return;
        if (i != 1021) {
          break;
        }
      } while (paramInt != -1);
      this.jdField_a_of_type_AndroidNetUri = ((Uri)paramIntent.getParcelableExtra("upload_uri_key"));
      a(bheg.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidNetUri));
      return;
    } while ((i != 2002) || (paramInt != -1));
    paramIntent = azrc.a(paramIntent.getStringExtra("card_url_key"));
    this.jdField_a_of_type_Aebs.a(paramIntent);
  }
  
  public void a(Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
    {
      b(paramArrayList);
      return;
    }
    a(paramArrayList);
  }
  
  public void a(Card paramCard)
  {
    if (paramCard != null)
    {
      paramCard = paramCard.getCoverData(this.jdField_a_of_type_Int);
      String str = (String)paramCard[0];
      if ((!TextUtils.isEmpty(str)) && (!str.equals(this.b)))
      {
        this.b = str;
        this.jdField_a_of_type_Int = ((Integer)paramCard[1]).intValue();
      }
    }
  }
  
  protected void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("action_cover_pick_gallery", true);
    localIntent.putExtra("PhotoConst.32_Bit_Config", true);
    PhotoUtils.startPhotoEdit(localIntent, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName(), bhaa.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), bhaa.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), bhaa.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), bhaa.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), paramString, bhaa.a());
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_Aebs.a(2131694305, 1);
      return;
    }
    ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramArrayList);
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("is_default_key", paramBoolean);
    aeow.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, PublicFragmentActivity.class, CustomCoverFragment.class, 1024);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.excute(new FriendProfilePhotoHelper.1(this), 16, null, false);
  }
  
  protected void b()
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
      {
        this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_Bisl.setCancelable(false);
        this.jdField_a_of_type_Bisl.c(2131690806);
        this.jdField_a_of_type_Bisl.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_Aebs.a(2131694305, 1);
      return;
    }
    ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((String)paramArrayList.get(0));
    b();
    this.jdField_a_of_type_Bkys.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    int k = 0;
    this.jdField_a_of_type_Bkys.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    c();
    this.jdField_a_of_type_Aebs.a(2131719835, 2);
    if (paramArrayOfByte != null)
    {
      Object localObject = ByteBuffer.wrap(paramArrayOfByte);
      int j = ((ByteBuffer)localObject).get();
      if (j != 0) {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "error retCode:" + j);
        }
      }
      do
      {
        return;
        byte[] arrayOfByte1 = new byte[4];
        byte[] arrayOfByte2 = new byte[4];
        j = 0;
        while (j < 4)
        {
          int i = ((ByteBuffer)localObject).get();
          arrayOfByte1[j] = i;
          arrayOfByte2[(3 - j)] = i;
          j += 1;
        }
        int m = (int)bghk.a(arrayOfByte1);
        if (m <= paramArrayOfByte.length - 5)
        {
          j = m;
          if (m >= 0) {}
        }
        else
        {
          j = (int)bghk.a(arrayOfByte2);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "len:" + j + " bLength:" + HexUtil.bytes2HexStr(arrayOfByte1) + " bFlipLength:" + HexUtil.bytes2HexStr(arrayOfByte2));
        }
        if ((j <= paramArrayOfByte.length - 5) && (j >= 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "长度超出! len:" + j + " extraInfo.length:" + paramArrayOfByte.length);
      return;
      localObject = new byte[j];
      while (k < j)
      {
        localObject[k] = paramArrayOfByte[(k + 5)];
        k += 1;
      }
      this.jdField_a_of_type_Aebs.b((byte[])localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send finish extraInfo is null");
    }
    this.jdField_a_of_type_Aebs.b(null);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bisl.dismiss();
      this.jdField_a_of_type_Bisl = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebq
 * JD-Core Version:    0.7.0.1
 */