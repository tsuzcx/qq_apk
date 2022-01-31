import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahdj
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  Intent jdField_a_of_type_AndroidContentIntent;
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  String jdField_a_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  WeakReference<BaseActivity> jdField_b_of_type_JavaLangRefWeakReference;
  int c;
  
  public ahdj(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidContentIntent = paramBaseActivity.getIntent();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_entrance", 0);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
    this.jdField_b_of_type_Int = 2;
    this.c = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    if (QLog.isColorLevel()) {
      QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: create");
    }
  }
  
  protected Integer a(Void... arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.e("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: doInBackground start");
    }
    long l = SystemClock.elapsedRealtime();
    ??? = (BaseActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (??? == null) {
      return Integer.valueOf(5);
    }
    if (!TextUtils.isEmpty(BlessSelectMemberActivity.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: currVideoPath is not null");
      }
      return Integer.valueOf(1);
    }
    SendVideoActivity.a(this.jdField_a_of_type_AndroidContentIntent);
    azib.z = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("sv_total_frame_count", 0);
    azib.y = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("sv_total_record_time", 0);
    if (!bdhb.b(this.jdField_a_of_type_JavaLangString)) {
      return Integer.valueOf(2);
    }
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    localObject1 = URLDrawable.getDrawable(new File(this.jdField_a_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject1);
    ((URLDrawable)localObject1).downloadImediatly();
    if (((URLDrawable)localObject1).getStatus() == 1)
    {
      localObject1 = azdd.a(0, this.jdField_b_of_type_Int);
      azen localazen = azdd.a(this.jdField_a_of_type_AndroidContentIntent, (azdx)localObject1);
      if (localazen == null) {
        return Integer.valueOf(5);
      }
      localazen.d = true;
      localazen.a = false;
      if ((localazen.r != null) && (localazen.r.length() == 39)) {
        localazen.r = localazen.r.substring(0, 28);
      }
      ((azdx)localObject1).a(localazen);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)new azcn(???.app).a(localazen));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo instanceof MessageForBlessPTV)) {
        ((MessageForBlessPTV)this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo).videoFileName = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("bless_ptv_mp4_path");
      }
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: generate req and mr success, cost:" + (SystemClock.elapsedRealtime() - l));
      }
      l = SystemClock.elapsedRealtime();
      ((ahcr)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(138)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      if (BlessSelectMemberActivity.a() == null) {
        break label452;
      }
      BlessSelectMemberActivity.a().sendEmptyMessage(3);
    }
    try
    {
      synchronized (BlessSelectMemberActivity.a())
      {
        BlessSelectMemberActivity.a().wait(BlessSelectMemberActivity.a());
        BlessSelectMemberActivity.b(SystemClock.elapsedRealtime() - l);
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: encodeVideo cost = " + (SystemClock.elapsedRealtime() - l));
        }
        if (BlessSelectMemberActivity.b() >= BlessSelectMemberActivity.a())
        {
          return Integer.valueOf(9);
          return Integer.valueOf(2);
          label452:
          QLog.e("BlessSelectMemberActivity", 1, "mUIHandler is null!");
        }
      }
      return Integer.valueOf(BlessSelectMemberActivity.a());
    }
    catch (InterruptedException ???)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: wait exception = " + ???.getMessage());
      }
      return Integer.valueOf(5);
    }
  }
  
  protected void a(Integer arg1)
  {
    super.onPostExecute(???);
    if (QLog.isColorLevel()) {
      QLog.i("BlessSelectMemberActivity", 1, "BlessPTVProcessTask: onPostExecute result=" + ???);
    }
    BlessSelectMemberActivity.b(???.intValue());
    synchronized (BlessSelectMemberActivity.b())
    {
      BlessSelectMemberActivity.b().set(true);
      BlessSelectMemberActivity.b().notifyAll();
      return;
    }
  }
  
  public boolean a()
  {
    if (ShortVideoUtils.a()) {
      return true;
    }
    ShortVideoUtils.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    return ShortVideoUtils.a();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    BlessSelectMemberActivity.b(1);
    QLog.d("BlessSelectMemberActivity", 1, "Is video useable:" + a() + ", mEntrance:" + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdj
 * JD-Core Version:    0.7.0.1
 */