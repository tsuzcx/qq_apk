import android.content.Context;
import android.os.AsyncTask;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class aigj
  extends AsyncTask<Void, Void, Integer>
{
  public static ConcurrentHashMap<Long, aigj> a;
  private static wab jdField_a_of_type_Wab;
  private int jdField_a_of_type_Int;
  private aigm jdField_a_of_type_Aigm = new aigl(this);
  private aigo jdField_a_of_type_Aigo;
  private aigp jdField_a_of_type_Aigp;
  private Context jdField_a_of_type_AndroidContentContext;
  public PublishVideoEntry a;
  public MessageForShortVideo a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public aigj(Context paramContext, String paramString, boolean paramBoolean, aigp paramaigp)
  {
    this(paramContext, paramString, paramBoolean, paramaigp, false);
  }
  
  public aigj(Context paramContext, String paramString, boolean paramBoolean1, aigp paramaigp, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aigp = paramaigp;
    this.jdField_c_of_type_Boolean = paramBoolean1;
    if (paramaigp != null) {
      this.jdField_b_of_type_JavaLangString = paramaigp.jdField_a_of_type_JavaLangString;
    }
    this.jdField_d_of_type_Boolean = paramBoolean2;
  }
  
  public aigj(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, aigp paramaigp, MessageForShortVideo paramMessageForShortVideo)
  {
    this(paramContext, paramString, paramBoolean, paramaigp, false);
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.busiType == 1) && (paramQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      paramMessageForShortVideo.videoFileStatus = 998;
    }
    try
    {
      paramMessageForShortVideo.serial();
      paramQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "encodeVideoTask uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("EncodeVideoTask", 2, "CompressTask Init", paramQQAppInterface);
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, 0);
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramLong <= 0L) {}
    label121:
    label125:
    for (;;)
    {
      return;
      String str = "";
      HashMap localHashMap;
      if (paramInt1 == 1)
      {
        str = "actShortVideoGenerateSource";
        if (paramInt2 == 0) {
          break label121;
        }
        localHashMap = new HashMap();
        localHashMap.put("hcState", String.valueOf(paramInt2));
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str)) {
          break label125;
        }
        axrn.a(BaseApplicationImpl.getContext()).a(null, str, true, paramLong, 0L, localHashMap, "");
        return;
        if (paramInt1 == 2)
        {
          str = "actShortVideoGenerateAudio";
          break;
        }
        if (paramInt1 == 3)
        {
          str = "actShortVideoGeneratePic";
          break;
        }
        if (paramInt1 == 4)
        {
          str = "actMediaCodecMergeEdit";
          break;
        }
        if (paramInt1 != 5) {
          break;
        }
        str = "actMediaCodecMergeSelfAudio";
        break;
        localHashMap = null;
      }
    }
  }
  
  private static void b(String paramString, PublishVideoEntry paramPublishVideoEntry, aigm paramaigm)
  {
    String str = ShortVideoUtils.b(new File(paramPublishVideoEntry.mLocalRawVideoDir));
    if (jdField_a_of_type_Wab == null) {
      jdField_a_of_type_Wab = wab.a(BaseApplicationImpl.getApplication());
    }
    if (jdField_a_of_type_Wab.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files mFFmpeg is running!");
      }
      return;
    }
    try
    {
      aigq localaigq = new aigq(paramPublishVideoEntry, paramString, str, paramaigm);
      jdField_a_of_type_Wab.a(str);
      jdField_a_of_type_Wab.a(paramPublishVideoEntry.doodlePath, paramString, str, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, localaigq);
      return;
    }
    catch (Exception paramString)
    {
      paramaigm.a(-12);
      QLog.e("EncodeVideoTask", 2, "generate files save alum:", paramString);
    }
  }
  
  protected Integer a()
  {
    long l = System.currentTimeMillis();
    if (bjjc.jdField_c_of_type_Boolean) {
      bjjc.g.b();
    }
    PublishVideoEntry localPublishVideoEntry = swc.a(this.jdField_a_of_type_JavaLangString);
    if (localPublishVideoEntry == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "[StoryEncodeType]configure param error, fakeVid:" + this.jdField_a_of_type_JavaLangString);
      }
      return Integer.valueOf(-62);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = localPublishVideoEntry;
    if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "[StoryEncodeType]configure param error, fakeId:" + this.jdField_a_of_type_JavaLangString + ", EntryId:" + localPublishVideoEntry.fakeVid);
      }
      awai.a(new RuntimeException("onMediaCodecEncode failed"));
      return Integer.valueOf(-62);
    }
    String str = ShortVideoUtils.b(new File(localPublishVideoEntry.mLocalRawVideoDir).getParentFile());
    new swc().a(localPublishVideoEntry, str, false, true, new aigk(this, localPublishVideoEntry, str, l));
    return Integer.valueOf(0);
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return c(paramVarArgs);
    }
    return b(paramVarArgs);
  }
  
  public void a(int paramInt, PublishVideoEntry paramPublishVideoEntry, long paramLong)
  {
    if ((paramPublishVideoEntry != null) && (paramPublishVideoEntry.publishState == 0)) {}
    label336:
    label339:
    for (;;)
    {
      return;
      if (paramPublishVideoEntry != null)
      {
        paramPublishVideoEntry.publishState = 0;
        QQStoryContext.a().a().createEntityManager().a(paramPublishVideoEntry);
      }
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        if (paramInt != 0) {
          break label99;
        }
      }
      label99:
      for (String str = "1";; str = "0")
      {
        vei.a("AIOMergeVideoSuc", bool, 0L, new String[] { str });
        if (paramInt == 0) {
          break label107;
        }
        vei.a("AIOMergeVideoError", true, 0L, new String[] { String.valueOf(paramInt) });
        return;
        bool = false;
        break;
      }
      label107:
      if (paramLong == 0L)
      {
        paramLong = 0L;
        if ((paramPublishVideoEntry == null) || (!paramPublishVideoEntry.isPicture)) {
          break label336;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if ((!bjjc.jdField_c_of_type_Boolean) || (paramInt != 0) || (!bjjc.g.a())) {
          break label339;
        }
        long l1 = bjjc.g.a[0];
        long l2 = bjjc.g.a[1];
        long l3 = bjjc.g.a[2];
        long l4 = bjjc.g.a[3];
        long l5 = bjjc.g.a[4];
        if ((vei.a(paramLong, 0L, 120000L)) && (vei.a(l1, 0L, 120000L)) && (vei.a(l2, 0L, 120000L)) && (vei.a(l3, 0L, 10000L)) && (vei.a(l4, 0L, 120000L)) && (vei.a(l5, 0L, 120000L))) {
          vei.a("AIOMergeVideoCost", true, paramLong, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4), String.valueOf(l5) });
        }
        bjjc.g.c();
        return;
        paramLong = System.currentTimeMillis() - paramLong;
        break;
      }
    }
  }
  
  public void a(aigo paramaigo)
  {
    this.jdField_a_of_type_Aigo = paramaigo;
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInteger.intValue()));
    axrn localaxrn = axrn.a(BaseApplicationImpl.getContext());
    if (paramInteger.intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrn.a(null, "actMediaCodecEncodeSuccessRate", bool, 0L, 0L, localHashMap, "");
      if (paramInteger.intValue() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EncodeVideoTask", 2, "onPostExecute result:" + paramInteger);
        }
        this.jdField_a_of_type_Aigo.a(paramInteger.intValue());
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel = true;
      this.f = true;
      boolean bool = axko.a();
      wak.a();
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "shortVideoCancel, cancelMerge:" + bool);
      }
      return true;
    }
    return false;
  }
  
  protected Integer b(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Aigm.a(-61, null, null, null, 0L);
      return Integer.valueOf(-61);
    }
    long l = SystemClock.uptimeMillis();
    int i = aabg.a().a(0, 1, 1, Process.myTid(), 8000, 603, 1L, Process.myTid(), "video", true);
    int j = a().intValue();
    if (j != 0) {
      this.jdField_a_of_type_Aigm.a(j, null, null, null, 0L);
    }
    if (i != 0) {
      aabg.a().a(i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, new Object[] { "encode cost=" + (SystemClock.uptimeMillis() - l), " ret:", Integer.valueOf(j) });
    }
    return Integer.valueOf(j);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  protected Integer c(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return Integer.valueOf(-1);
    }
    PublishVideoEntry localPublishVideoEntry = swc.a(this.jdField_a_of_type_JavaLangString);
    if (localPublishVideoEntry == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "configure param error, fakeVid:" + this.jdField_a_of_type_JavaLangString);
      }
      return Integer.valueOf(-2);
    }
    axim.y = (int)localPublishVideoEntry.recordTime;
    axim.z = localPublishVideoEntry.recordFrames;
    if (localPublishVideoEntry.saveMode != 0) {
      axim.J = localPublishVideoEntry.saveMode;
    }
    int i;
    label131:
    int j;
    Object localObject2;
    Object localObject1;
    long l;
    if (localPublishVideoEntry.businessId == 2)
    {
      i = 0;
      axim.D = i;
      if (TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) {
        break label385;
      }
      i = 1;
      if (TextUtils.isEmpty(localPublishVideoEntry.doodlePath)) {
        break label390;
      }
      j = 1;
      localObject2 = new File(localPublishVideoEntry.mLocalRawVideoDir);
      localObject1 = ShortVideoUtils.c((File)localObject2);
      paramVarArgs = (Void[])localObject1;
      if (i == 0)
      {
        paramVarArgs = (Void[])localObject1;
        if (j == 0) {
          paramVarArgs = ShortVideoUtils.b((File)localObject2);
        }
      }
      l = System.currentTimeMillis();
      localObject1 = new EncodeThread(null, null, localPublishVideoEntry.mLocalRawVideoDir, paramVarArgs, null);
      ((EncodeThread)localObject1).a(false);
      ((EncodeThread)localObject1).b(false);
      ((EncodeThread)localObject1).d(localPublishVideoEntry.isMuteRecordVoice);
      if (localPublishVideoEntry.mMosaicMask != null) {
        ((EncodeThread)localObject1).a(localPublishVideoEntry.mMosaicMask, localPublishVideoEntry.mMosaicSize);
      }
      ((EncodeThread)localObject1).run();
      a(System.currentTimeMillis() - l, 1);
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files|first step cost:" + (System.currentTimeMillis() - l) / 1000.0D);
      }
      if (i == 0) {
        break label415;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ShortVideoUtils.d((File)localObject2);
        l = ShortVideoUtils.b(paramVarArgs);
        localObject2 = new aign(localPublishVideoEntry, paramVarArgs, (String)localObject1);
        ((aign)localObject2).a(this.jdField_a_of_type_Aigm);
        wak.b(this.jdField_a_of_type_AndroidContentContext, paramVarArgs, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l, (String)localObject1, (waa)localObject2);
        return Integer.valueOf(0);
        i = 1;
        break;
        label385:
        i = 0;
        break label131;
        label390:
        j = 0;
      }
      catch (Exception paramVarArgs)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EncodeVideoTask", 2, "generate error:", paramVarArgs);
        continue;
      }
      label415:
      this.jdField_a_of_type_Aigm.a(localPublishVideoEntry, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aigj
 * JD-Core Version:    0.7.0.1
 */