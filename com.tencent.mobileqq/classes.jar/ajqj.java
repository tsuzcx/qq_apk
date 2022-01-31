import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.concurrent.atomic.AtomicLong;

public class ajqj
  extends AsyncTask<Void, Void, Integer>
{
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ajqk jdField_a_of_type_Ajqk;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private azkl jdField_a_of_type_Azkl = new azkl();
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public ajqj(ajqk paramajqk)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ajqk = paramajqk;
    this.jdField_a_of_type_Long = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    this.jdField_e_of_type_JavaLangString = ("MediaCodecSendTask_[mSessionId=" + this.jdField_a_of_type_Long + "]");
  }
  
  private int a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ajqk.jdField_a_of_type_JavaLangString;
    a("cacheDir=" + this.jdField_a_of_type_JavaLangString, null);
    if (!bdhb.b(this.jdField_a_of_type_Ajqk.jdField_c_of_type_JavaLangString))
    {
      a("video file empty! path=" + this.jdField_a_of_type_Ajqk.jdField_c_of_type_JavaLangString, null);
      return -300;
    }
    if (!bdhb.b(this.jdField_a_of_type_Ajqk.jdField_f_of_type_JavaLangString))
    {
      a("thumb file empty! path=" + this.jdField_a_of_type_Ajqk.jdField_f_of_type_JavaLangString, null);
      return -301;
    }
    Intent localIntent = this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_b_of_type_Int = localIntent.getIntExtra("param_entrance", 0);
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("bless_ptv_mp4_path");
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("fake_id");
    int i = azkk.a(this.jdField_a_of_type_Ajqk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Azkl);
    if (i != 0)
    {
      a("MediaMetadataUtils: errcode=" + i, null);
      return i;
    }
    if (localIntent.getBooleanExtra("from_qzone_slideshow", false)) {}
    for (i = this.jdField_a_of_type_Ajqk.jdField_j_of_type_Int;; i = this.jdField_a_of_type_Azkl.a[3])
    {
      this.jdField_a_of_type_Int = ((i + 500) / 1000);
      if ((this.jdField_a_of_type_Ajqk.jdField_c_of_type_Int <= 0) || (this.jdField_a_of_type_Ajqk.jdField_d_of_type_Int <= 0))
      {
        i = this.jdField_a_of_type_Azkl.a[2];
        this.jdField_a_of_type_Ajqk.jdField_c_of_type_Int = this.jdField_a_of_type_Azkl.a[0];
        this.jdField_a_of_type_Ajqk.jdField_d_of_type_Int = this.jdField_a_of_type_Azkl.a[1];
        if ((i == 90) || (i == 270))
        {
          this.jdField_a_of_type_Ajqk.jdField_c_of_type_Int = this.jdField_a_of_type_Ajqk.jdField_d_of_type_Int;
          this.jdField_a_of_type_Ajqk.jdField_d_of_type_Int = this.jdField_a_of_type_Azkl.a[0];
        }
      }
      return b();
    }
  }
  
  private void a()
  {
    a("cancleProgressDailog", null);
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_a_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(Context paramContext, int paramInt)
  {
    a("showProgressDialog", null);
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131755801);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559437);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371894));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      a("showProgressDialog", paramContext);
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      QLog.i(this.jdField_e_of_type_JavaLangString, 1, "[@] " + paramString, paramThrowable);
      return;
    }
    QLog.i(this.jdField_e_of_type_JavaLangString, 1, "[@] " + paramString);
  }
  
  /* Error */
  private int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	ajqj:jdField_a_of_type_Ajqk	Lajqk;
    //   4: getfield 90	ajqk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7: aload_0
    //   8: getfield 43	ajqj:jdField_a_of_type_Ajqk	Lajqk;
    //   11: getfield 219	ajqk:jdField_a_of_type_Double	D
    //   14: aload_0
    //   15: getfield 43	ajqj:jdField_a_of_type_Ajqk	Lajqk;
    //   18: getfield 221	ajqk:jdField_b_of_type_Double	D
    //   21: invokestatic 226	bdhj:a	(Ljava/lang/String;DD)Z
    //   24: pop
    //   25: new 228	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: getfield 43	ajqj:jdField_a_of_type_Ajqk	Lajqk;
    //   33: getfield 90	ajqk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   36: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: new 233	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: getfield 43	ajqj:jdField_a_of_type_Ajqk	Lajqk;
    //   48: getfield 90	ajqk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: astore_1
    //   55: aload_0
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 237	java/io/File:length	()J
    //   61: invokestatic 243	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   64: invokestatic 249	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   67: putfield 251	ajqj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 254	java/io/FileInputStream:close	()V
    //   78: aload_0
    //   79: getfield 251	ajqj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   82: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifeq +23 -> 108
    //   88: aload_0
    //   89: ldc_w 262
    //   92: aconst_null
    //   93: invokespecial 78	ajqj:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: sipush -302
    //   99: ireturn
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   105: goto -27 -> 78
    //   108: aload_0
    //   109: getfield 251	ajqj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: ldc_w 267
    //   115: invokestatic 272	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 43	ajqj:jdField_a_of_type_Ajqk	Lajqk;
    //   123: getfield 90	ajqk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   126: aload_1
    //   127: invokestatic 275	bdhb:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   130: ifeq +13 -> 143
    //   133: aload_0
    //   134: getfield 43	ajqj:jdField_a_of_type_Ajqk	Lajqk;
    //   137: aload_1
    //   138: putfield 90	ajqk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   141: iconst_0
    //   142: ireturn
    //   143: aload_1
    //   144: invokestatic 85	bdhb:b	(Ljava/lang/String;)Z
    //   147: ifne -6 -> 141
    //   150: aload_0
    //   151: new 51	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 277
    //   161: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: getfield 43	ajqj:jdField_a_of_type_Ajqk	Lajqk;
    //   168: getfield 90	ajqk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   171: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 279
    //   177: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_1
    //   181: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aconst_null
    //   188: invokespecial 78	ajqj:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: sipush -301
    //   194: ireturn
    //   195: astore_1
    //   196: aconst_null
    //   197: astore_1
    //   198: goto -128 -> 70
    //   201: astore_2
    //   202: goto -132 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	ajqj
    //   54	21	1	localFileInputStream	java.io.FileInputStream
    //   100	2	1	localIOException	java.io.IOException
    //   118	63	1	str	String
    //   195	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   197	1	1	localObject	java.lang.Object
    //   39	19	2	localFile	java.io.File
    //   201	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   74	78	100	java/io/IOException
    //   40	55	195	java/io/FileNotFoundException
    //   55	70	201	java/io/FileNotFoundException
  }
  
  private void b(Intent paramIntent)
  {
    paramIntent.putExtra("mediacodec_encode_enable", true);
    paramIntent.putExtra("PhotoConst.IS_VIDEO_RECORDED", true);
    paramIntent.putExtra("file_video_source_dir", this.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_path", this.jdField_a_of_type_Ajqk.jdField_f_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_a_of_type_Ajqk.jdField_c_of_type_Int);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_a_of_type_Ajqk.jdField_d_of_type_Int);
    paramIntent.putExtra("thumbfile_md5", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("file_send_duration", this.jdField_a_of_type_Int * 1000);
    paramIntent.putExtra("need_process", true);
    paramIntent.putExtra("PhotoConst.VIDEO_TYPE", 0);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_a_of_type_Ajqk.jdField_k_of_type_JavaLangString);
    paramIntent.putExtra("video_is_generate_gif", this.jdField_a_of_type_Ajqk.jdField_e_of_type_Boolean);
    paramIntent.putExtra("video_mood_timer_delete", this.jdField_a_of_type_Ajqk.jdField_f_of_type_Boolean);
    Bundle localBundle = new Bundle();
    localBundle.putInt("sv_encode_max_bitrate", azib.r);
    localBundle.putInt("sv_encode_min_bitrate", azib.s);
    localBundle.putInt("sv_total_record_time", this.jdField_a_of_type_Int);
    paramIntent.putExtra("encode_video_params", localBundle);
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    int i = a();
    if (i != 0) {
      return Integer.valueOf(i);
    }
    a("doInBackground total:time=" + (System.currentTimeMillis() - l) / 1000.0D, null);
    return Integer.valueOf(0);
  }
  
  void a(Intent paramIntent)
  {
    paramIntent.putExtra("mediacodec_encode_enable", true);
    paramIntent.putExtra("file_video_source_dir", this.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_path", this.jdField_a_of_type_Ajqk.jdField_f_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_a_of_type_Ajqk.jdField_c_of_type_Int);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_a_of_type_Ajqk.jdField_d_of_type_Int);
    paramIntent.putExtra("thumbfile_md5", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("file_send_duration", this.jdField_a_of_type_Int);
    paramIntent.putExtra("sv_total_record_time", this.jdField_a_of_type_Int);
    paramIntent.putExtra("video_mood_content", this.jdField_a_of_type_Ajqk.jdField_g_of_type_JavaLangString);
    paramIntent.putExtra("video_mood_priv", this.jdField_a_of_type_Ajqk.jdField_e_of_type_Int);
    paramIntent.putExtra("video_mood_privUinList", this.jdField_a_of_type_Ajqk.jdField_a_of_type_JavaUtilArrayList);
    paramIntent.putExtra("enable_edit_video", this.jdField_a_of_type_Ajqk.jdField_a_of_type_Boolean);
    paramIntent.putExtra("video_topic_id", this.jdField_a_of_type_Ajqk.jdField_j_of_type_JavaLangString);
    paramIntent.putExtra("video_topic_sync_qzone", this.jdField_a_of_type_Ajqk.jdField_b_of_type_Boolean);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_a_of_type_Ajqk.jdField_k_of_type_JavaLangString);
    paramIntent.putExtra("video_is_generate_gif", this.jdField_a_of_type_Ajqk.jdField_e_of_type_Boolean);
    paramIntent.putExtra("video_mood_timer_delete", this.jdField_a_of_type_Ajqk.jdField_f_of_type_Boolean);
    paramIntent.putExtra("qzone_video_sync_to_qqstory", this.jdField_a_of_type_Ajqk.jdField_g_of_type_Boolean);
    paramIntent.putExtra("qzone_video_topic", this.jdField_a_of_type_Ajqk.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo);
    paramIntent.putExtra("param.isUploadOrigin", this.jdField_a_of_type_Ajqk.jdField_h_of_type_Boolean);
    paramIntent.putExtra("video_sync_to_story", this.jdField_a_of_type_Ajqk.jdField_c_of_type_Boolean);
    paramIntent.putExtra("param.fromAIO", this.jdField_a_of_type_Ajqk.jdField_i_of_type_Boolean);
    paramIntent.putExtra("extra_key_font_id", this.jdField_a_of_type_Ajqk.jdField_f_of_type_Int);
    paramIntent.putExtra("extra_key_font_format_type", this.jdField_a_of_type_Ajqk.jdField_g_of_type_Int);
    paramIntent.putExtra("extra_key_font_url", this.jdField_a_of_type_Ajqk.jdField_h_of_type_JavaLangString);
    paramIntent.putExtra("extra_key_super_font_id", this.jdField_a_of_type_Ajqk.jdField_h_of_type_Int);
    paramIntent.putExtra("extra_key_super_font_info", this.jdField_a_of_type_Ajqk.jdField_i_of_type_JavaLangString);
    paramIntent.putExtra("sv_encode_max_bitrate", azib.r);
    paramIntent.putExtra("sv_encode_min_bitrate", azib.s);
    if ((this.jdField_a_of_type_Ajqk.jdField_j_of_type_Int > 0) && (this.jdField_a_of_type_Ajqk.jdField_i_of_type_Int > 0)) {
      azjc.a("sv_filter_mediacodec_fps", this.jdField_a_of_type_Ajqk.jdField_i_of_type_Int * 1000 / this.jdField_a_of_type_Ajqk.jdField_j_of_type_Int);
    }
    String str = this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("forward_source_to_qzone");
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("forward_source_to_qzone", str);
    }
  }
  
  protected void a(Integer paramInteger)
  {
    int i = 1;
    a();
    if (paramInteger.intValue() == 0)
    {
      if (this.jdField_a_of_type_Ajqk.jdField_k_of_type_Int == 3)
      {
        paramInteger = new Intent(this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.getIntent());
        b(paramInteger);
        paramInteger.setFlags(536870912);
        if (paramInteger.getStringExtra("qzone_plugin_activity_name") == null) {
          QzonePluginProxyActivity.a(paramInteger, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
        }
        bjdt.a(this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity, "", paramInteger, -1);
        this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.finish();
        this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity = null;
        return;
      }
      if (this.jdField_a_of_type_Ajqk.jdField_k_of_type_Int == 5)
      {
        paramInteger = new Intent(this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.getIntent());
        b(paramInteger);
        paramInteger.setClass(this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity, NewPhotoListActivity.class);
        paramInteger.addFlags(603979776);
        this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.startActivity(paramInteger);
        this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.finish();
        this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity = null;
        return;
      }
      paramInteger = new Intent();
      a(paramInteger);
      if (this.jdField_a_of_type_Ajqk.jdField_a_of_type_Ajpz != null)
      {
        this.jdField_a_of_type_Ajqk.jdField_a_of_type_Ajpz.a(this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity, paramInteger);
        this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.finish();
        this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity = null;
        return;
      }
      paramInteger.putExtra("uin", this.jdField_a_of_type_Ajqk.jdField_d_of_type_JavaLangString);
      paramInteger.putExtra("uintype", this.jdField_a_of_type_Ajqk.jdField_b_of_type_Int);
      paramInteger.putExtra("troop_uin", this.jdField_a_of_type_Ajqk.jdField_e_of_type_JavaLangString);
      paramInteger.putExtra("file_send_business_type", 2);
      a("onPostExecute(), MediaCodecSendTask is to start  SendVideoActivity,mVideoCacheDir = " + this.jdField_a_of_type_JavaLangString, null);
      paramInteger.putExtra("ab_test_send_btn_click_time", this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
      paramInteger.putExtra("param_key_redbag_type", this.jdField_a_of_type_Ajqk.l);
      paramInteger.putExtra("special_video_type", this.jdField_a_of_type_Ajqk.m);
      if ((this.jdField_a_of_type_Ajqk.jdField_d_of_type_JavaLangString != null) && (this.jdField_a_of_type_Ajqk.jdField_d_of_type_JavaLangString.equals(MessageForBlessPTV.BLESS_REQ_UIN)))
      {
        paramInteger.putExtra("bless_ptv_mp4_path", this.jdField_c_of_type_JavaLangString);
        paramInteger.setClass(this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity, BlessSelectMemberActivity.class);
        paramInteger.putExtra("param_type", 9003);
        paramInteger.putExtra("param_only_friends", true);
        paramInteger.putExtra("param_donot_need_contacts", true);
        paramInteger.putExtra("param_title", this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.getString(2131690565));
        paramInteger.putExtra("param_done_button_wording", this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.getString(2131691089));
        paramInteger.putExtra("param_exit_animation", 1);
        paramInteger.putExtra("param_entrance", this.jdField_b_of_type_Int);
        paramInteger.putExtra("param_blesstype", 2);
        paramInteger.putExtra("encode_type", 1);
        paramInteger.putExtra("fake_id", this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramInteger, 10007);
        if (i == 0) {
          this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.finish();
        }
        this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity = null;
        return;
      }
      paramInteger.setClass(this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity, SendVideoActivity.class);
      this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.startActivity(paramInteger);
    }
    for (;;)
    {
      i = 0;
      break;
      QQToast.a(this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity, alud.a(2131706887), 0).b(this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      QLog.e(this.jdField_e_of_type_JavaLangString, 1, "" + paramInteger);
      a("onPostExecute(), MediaCodecSendTask error = " + paramInteger, null);
    }
  }
  
  protected void onPreExecute()
  {
    a(this.jdField_a_of_type_Ajqk.jdField_a_of_type_AndroidAppActivity, 2131695286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqj
 * JD-Core Version:    0.7.0.1
 */