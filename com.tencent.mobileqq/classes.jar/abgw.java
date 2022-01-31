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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class abgw
  implements ajtm
{
  public static final String a;
  public int a;
  public abgy a;
  public ajtl a;
  public Uri a;
  Handler.Callback a;
  public bcqf a;
  public bfob a;
  public final BaseActivity a;
  public QQAppInterface a;
  public Runnable a;
  public boolean a;
  public byte[] a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = abgw.class.getSimpleName();
  }
  
  public abgw(BaseActivity paramBaseActivity, abgy paramabgy)
  {
    this.jdField_a_of_type_JavaLangRunnable = new FriendProfilePhotoHelper.2(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new abgx(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Abgy = paramabgy;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_Bfob = new bfob(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramBaseActivity = (ajti)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
    if (paramBaseActivity != null) {
      this.jdField_a_of_type_Ajtl = paramBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajtl != null)
    {
      ((ajti)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_Ajtl);
      this.jdField_a_of_type_Ajtl = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.b = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (!bbfj.d(BaseApplication.getContext())) {
      this.jdField_a_of_type_Abgy.a(2131694673, 1);
    }
    do
    {
      do
      {
        return;
      } while ((paramInt != -1) || (paramIntent == null));
      paramIntent = paramIntent.getStringArrayListExtra("key_cover_selected_img_path");
    } while ((paramIntent == null) || (paramIntent.size() <= 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pick photo from qzone size:" + paramIntent.size());
    }
    ((ajti)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(paramIntent);
    b();
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
    PhotoUtils.a(localIntent, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName(), bbac.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), bbac.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), bbac.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), bbac.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), paramString, bbac.c());
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (!bbfj.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_Abgy.a(2131694673, 1);
      return;
    }
    ((ajti)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(paramArrayList);
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("is_default_key", paramBoolean);
    abtq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, PublicFragmentActivity.class, CustomCoverFragment.class, 1024);
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
        this.jdField_a_of_type_Bcqf = new bcqf(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_Bcqf.setCancelable(false);
        this.jdField_a_of_type_Bcqf.c(2131690774);
        this.jdField_a_of_type_Bcqf.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(int paramInt, Intent paramIntent)
  {
    if (!bbfj.d(BaseApplication.getContext())) {
      this.jdField_a_of_type_Abgy.a(2131694673, 1);
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
            ajti localajti = (ajti)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
            if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
            {
              localajti.b((String)localArrayList.get(0));
              b();
              this.jdField_a_of_type_Bfob.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
              return;
            }
            localajti.a(localArrayList);
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
      a(bbef.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidNetUri));
      return;
    } while ((i != 2002) || (paramInt != -1));
    paramIntent = auuz.a(paramIntent.getStringExtra("card_url_key"));
    this.jdField_a_of_type_Abgy.a(paramIntent);
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    if (!bbfj.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_Abgy.a(2131694673, 1);
      return;
    }
    ((ajti)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).b((String)paramArrayList.get(0));
    b();
    this.jdField_a_of_type_Bfob.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    int k = 0;
    this.jdField_a_of_type_Bfob.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    c();
    this.jdField_a_of_type_Abgy.a(2131720691, 2);
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
        int m = (int)baie.a(arrayOfByte1);
        if (m <= paramArrayOfByte.length - 5)
        {
          j = m;
          if (m >= 0) {}
        }
        else
        {
          j = (int)baie.a(arrayOfByte2);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "len:" + j + " bLength:" + bbea.a(arrayOfByte1) + " bFlipLength:" + bbea.a(arrayOfByte2));
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
      this.jdField_a_of_type_Abgy.b((byte[])localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send finish extraInfo is null");
    }
    this.jdField_a_of_type_Abgy.b(null);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      this.jdField_a_of_type_Bcqf = null;
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
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onSendFailed activity=%s", new Object[] { this }));
    }
    this.jdField_a_of_type_Bfob.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    c();
    this.jdField_a_of_type_Abgy.a(2131720693, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abgw
 * JD-Core Version:    0.7.0.1
 */