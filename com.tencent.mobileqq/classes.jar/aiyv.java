import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.WXVad;
import com.wx.voice.vad.WXVadParam;
import com.wx.voice.vad.WXVadSeg;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class aiyv
{
  private int jdField_a_of_type_Int;
  private WXVad jdField_a_of_type_ComWxVoiceVadWXVad;
  private WXVadParam jdField_a_of_type_ComWxVoiceVadWXVadParam;
  private String jdField_a_of_type_JavaLangString;
  public List<WXVadSeg> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public boolean a;
  
  static
  {
    System.loadLibrary("wx-asr-vad");
  }
  
  public aiyv()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam = new WXVadParam();
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.mode = 1;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.sample_rate = 16000;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.opt_spk_time = 3000;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_min_spk_time = 80;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_max_spk_time = 50000;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_min_nspk_time = 50;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_min_process_time = 10000;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_remove_sil = true;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_padding_btime = 100;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_padding_etime = 150;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_min_sil_time = 600;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_rtcmode = 3;
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: new 85	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 87	aiyv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 6
    //   13: new 91	java/io/FileInputStream
    //   16: dup
    //   17: aload 6
    //   19: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 5
    //   24: aload 5
    //   26: astore 4
    //   28: aload 6
    //   30: invokevirtual 98	java/io/File:length	()J
    //   33: lstore_2
    //   34: aload 5
    //   36: astore 4
    //   38: aload 5
    //   40: aload_0
    //   41: getfield 100	aiyv:jdField_a_of_type_Int	I
    //   44: i2l
    //   45: invokevirtual 104	java/io/FileInputStream:skip	(J)J
    //   48: pop2
    //   49: aload 5
    //   51: astore 4
    //   53: lload_2
    //   54: aload_0
    //   55: getfield 100	aiyv:jdField_a_of_type_Int	I
    //   58: i2l
    //   59: lsub
    //   60: l2i
    //   61: newarray byte
    //   63: astore 6
    //   65: aload 5
    //   67: astore 4
    //   69: aload 5
    //   71: aload 6
    //   73: invokevirtual 108	java/io/FileInputStream:read	([B)I
    //   76: pop
    //   77: aload 5
    //   79: astore 4
    //   81: aload 6
    //   83: invokestatic 114	com/wx/voice/vad/Utils:toShortArray	([B)[S
    //   86: astore 6
    //   88: aload 5
    //   90: astore 4
    //   92: aload_0
    //   93: getfield 116	aiyv:jdField_a_of_type_ComWxVoiceVadWXVad	Lcom/wx/voice/vad/WXVad;
    //   96: aload 6
    //   98: aload 6
    //   100: arraylength
    //   101: i2l
    //   102: invokevirtual 122	com/wx/voice/vad/WXVad:OfflineProcess	([SJ)Lcom/wx/voice/vad/WXVadData;
    //   105: astore 6
    //   107: aload 5
    //   109: astore 4
    //   111: aload 6
    //   113: getfield 127	com/wx/voice/vad/WXVadData:RET_STATE	I
    //   116: iconst_1
    //   117: if_icmpeq +62 -> 179
    //   120: iconst_0
    //   121: istore_1
    //   122: aload 5
    //   124: astore 4
    //   126: iload_1
    //   127: aload 6
    //   129: getfield 131	com/wx/voice/vad/WXVadData:offline_odata	Ljava/util/ArrayList;
    //   132: invokevirtual 135	java/util/ArrayList:size	()I
    //   135: if_icmpge +44 -> 179
    //   138: aload 5
    //   140: astore 4
    //   142: aload 6
    //   144: getfield 131	com/wx/voice/vad/WXVadData:offline_odata	Ljava/util/ArrayList;
    //   147: iload_1
    //   148: invokevirtual 139	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   151: checkcast 141	com/wx/voice/vad/WXVadSeg
    //   154: astore 7
    //   156: aload 5
    //   158: astore 4
    //   160: aload_0
    //   161: getfield 37	aiyv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   164: aload 7
    //   166: invokeinterface 147 2 0
    //   171: pop
    //   172: iload_1
    //   173: iconst_1
    //   174: iadd
    //   175: istore_1
    //   176: goto -54 -> 122
    //   179: aload 5
    //   181: astore 4
    //   183: aload_0
    //   184: getfield 116	aiyv:jdField_a_of_type_ComWxVoiceVadWXVad	Lcom/wx/voice/vad/WXVad;
    //   187: invokevirtual 150	com/wx/voice/vad/WXVad:Reset	()I
    //   190: pop
    //   191: aload 5
    //   193: astore 4
    //   195: aload_0
    //   196: getfield 32	aiyv:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   199: iconst_0
    //   200: invokevirtual 154	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   203: aload 5
    //   205: invokevirtual 157	java/io/FileInputStream:close	()V
    //   208: return
    //   209: astore 4
    //   211: aload 4
    //   213: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   216: return
    //   217: astore 6
    //   219: aconst_null
    //   220: astore 5
    //   222: aload 5
    //   224: astore 4
    //   226: aload 6
    //   228: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   231: aload 5
    //   233: astore 4
    //   235: aload_0
    //   236: getfield 32	aiyv:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   239: iconst_0
    //   240: invokevirtual 154	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   243: aload 5
    //   245: invokevirtual 157	java/io/FileInputStream:close	()V
    //   248: return
    //   249: astore 4
    //   251: aload 4
    //   253: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   256: return
    //   257: astore 5
    //   259: aconst_null
    //   260: astore 4
    //   262: aload 4
    //   264: invokevirtual 157	java/io/FileInputStream:close	()V
    //   267: aload 5
    //   269: athrow
    //   270: astore 4
    //   272: aload 4
    //   274: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   277: goto -10 -> 267
    //   280: astore 5
    //   282: goto -20 -> 262
    //   285: astore 6
    //   287: goto -65 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	aiyv
    //   121	55	1	i	int
    //   33	21	2	l	long
    //   26	168	4	localFileInputStream1	java.io.FileInputStream
    //   209	3	4	localException1	java.lang.Exception
    //   224	10	4	localFileInputStream2	java.io.FileInputStream
    //   249	3	4	localException2	java.lang.Exception
    //   260	3	4	localObject1	Object
    //   270	3	4	localException3	java.lang.Exception
    //   22	222	5	localFileInputStream3	java.io.FileInputStream
    //   257	11	5	localObject2	Object
    //   280	1	5	localObject3	Object
    //   11	132	6	localObject4	Object
    //   217	10	6	localException4	java.lang.Exception
    //   285	1	6	localException5	java.lang.Exception
    //   154	11	7	localWXVadSeg	WXVadSeg
    // Exception table:
    //   from	to	target	type
    //   203	208	209	java/lang/Exception
    //   13	24	217	java/lang/Exception
    //   243	248	249	java/lang/Exception
    //   13	24	257	finally
    //   262	267	270	java/lang/Exception
    //   28	34	280	finally
    //   38	49	280	finally
    //   53	65	280	finally
    //   69	77	280	finally
    //   81	88	280	finally
    //   92	107	280	finally
    //   111	120	280	finally
    //   126	138	280	finally
    //   142	156	280	finally
    //   160	172	280	finally
    //   183	191	280	finally
    //   195	203	280	finally
    //   226	231	280	finally
    //   235	243	280	finally
    //   28	34	285	java/lang/Exception
    //   38	49	285	java/lang/Exception
    //   53	65	285	java/lang/Exception
    //   69	77	285	java/lang/Exception
    //   81	88	285	java/lang/Exception
    //   92	107	285	java/lang/Exception
    //   111	120	285	java/lang/Exception
    //   126	138	285	java/lang/Exception
    //   142	156	285	java/lang/Exception
    //   160	172	285	java/lang/Exception
    //   183	191	285	java/lang/Exception
    //   195	203	285	java/lang/Exception
  }
  
  public void a()
  {
    d();
    this.jdField_a_of_type_ComWxVoiceVadWXVad = new WXVad();
    if (1 == this.jdField_a_of_type_ComWxVoiceVadWXVad.Init(this.jdField_a_of_type_ComWxVoiceVadWXVadParam))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VadUtils", 2, "WXVad Error reading configure");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    e();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComWxVoiceVadWXVad != null) {
      this.jdField_a_of_type_ComWxVoiceVadWXVad.Release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyv
 * JD-Core Version:    0.7.0.1
 */