package com.tencent.wxhld;

import android.content.Context;
import android.os.Handler;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxhld.info.Candidate;
import com.tencent.wxhld.info.DictInfo;
import com.tencent.wxhld.info.InitInfo;
import com.tencent.wxhld.info.NetworkInfo;
import com.tencent.wxhld.info.PendingInput;
import com.tencent.wxhld.info.PunctToScreenEvent;
import com.tencent.wxhld.info.SessionConfig;
import com.tencent.wxhld.info.Syllable;

public class WxhldApi
{
  private static final String TAG = "WXHLD_JNI";
  private static final Singleton<WxhldApi> sSingleton;
  private byte _hellAccFlag_;
  private Context mContext;
  private Handler mHandler;
  WxhldEventListener mWxhldEventListener = null;
  WxhldLoginStatusListener mWxhldLoginStatusListener = null;
  
  static
  {
    AppMethodBeat.i(212325);
    sSingleton = new Singleton()
    {
      protected final WxhldApi createInstance()
      {
        AppMethodBeat.i(212291);
        WxhldApi localWxhldApi = new WxhldApi();
        AppMethodBeat.o(212291);
        return localWxhldApi;
      }
    };
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("c++_shared");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("wechatxlog");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("private_protobuf");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("ilink_xlog");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("linkid");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("ilink_network");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("ilink_tdi");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("wxhld");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("wxhld_jni");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxhld/WxhldApi", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(212325);
  }
  
  public static native void add_cell_dict(String paramString, int paramInt);
  
  public static native void attempt_to_drop_emitted_text(long paramLong);
  
  public static native Candidate[] candidate_get_n(long paramLong, int paramInt);
  
  public static native Candidate candidate_next(long paramLong);
  
  public static native void clear_cell_dicts();
  
  public static native void config_dict(DictInfo[] paramArrayOfDictInfo, String paramString);
  
  public static native long create_session(SessionConfig paramSessionConfig);
  
  public static native void delete_candidate_iterator(long paramLong);
  
  public static native boolean destroy_session(long paramLong);
  
  public static native boolean drop_last(long paramLong);
  
  public static native void finalize1();
  
  public static native void force_emit_pending_input(long paramLong);
  
  public static native void gc_sessions();
  
  public static WxhldApi getInstance()
  {
    AppMethodBeat.i(212296);
    WxhldApi localWxhldApi = (WxhldApi)sSingleton.getInstance();
    AppMethodBeat.o(212296);
    return localWxhldApi;
  }
  
  public static native long get_commit_time();
  
  public static native String[] get_most_commonly_used_punctuations(int paramInt);
  
  public static native void get_most_likely_sequel(long paramLong);
  
  public static native String[] get_puncts_classification(int paramInt);
  
  public static native String get_version();
  
  public static native boolean has_session(long paramLong);
  
  public static native void init_network(String paramString);
  
  public static native void initialize(InitInfo paramInitInfo);
  
  public static native boolean is_login_status_ok();
  
  public static native boolean load_bootstrap_dict(String paramString);
  
  public static native void network_login(NetworkInfo paramNetworkInfo);
  
  private static void onCandidateListUpdate(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(212315);
    new StringBuilder("onCandidateListUpdate session is ").append(paramLong1).append(", new_iterator is ").append(paramLong2);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnCandidateListUpdate(paramLong1, paramLong2, paramInt);
    }
    AppMethodBeat.o(212315);
  }
  
  private static void onCandidateSelected(long paramLong)
  {
    AppMethodBeat.i(212316);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnCandidateSelected(paramLong);
    }
    AppMethodBeat.o(212316);
  }
  
  private static void onEmitInputToScreen(long paramLong, String paramString)
  {
    AppMethodBeat.i(212318);
    new StringBuilder("onEmitInputToScreen session is ").append(paramLong).append(", text is ").append(paramString);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnEmitInputToScreen(paramLong, paramString);
    }
    AppMethodBeat.o(212318);
  }
  
  private static void onLoginStatusEvent(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212324);
    if (getInstance().mWxhldLoginStatusListener == null)
    {
      AppMethodBeat.o(212324);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212324);
      return;
      getInstance().mWxhldLoginStatusListener.OnLoginComplete(paramInt2);
      AppMethodBeat.o(212324);
      return;
      getInstance().mWxhldLoginStatusListener.OnLogouted();
      AppMethodBeat.o(212324);
      return;
      getInstance().mWxhldLoginStatusListener.OnSessionExpired();
    }
  }
  
  @Deprecated
  private static void onPendingInputUpdate(long paramLong, String paramString)
  {
    AppMethodBeat.i(212319);
    new StringBuilder("onPendingInputUpdate session is ").append(paramLong).append(", pending_input is ").append(paramString);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnPendingInputUpdate(paramLong, paramString);
    }
    AppMethodBeat.o(212319);
  }
  
  private static void onPendingInputUpdateV2(long paramLong, PendingInput[] paramArrayOfPendingInput)
  {
    AppMethodBeat.i(212322);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnPendingInputUpdateV2(paramLong, paramArrayOfPendingInput);
    }
    AppMethodBeat.o(212322);
  }
  
  private static void onSyllableListUpdate(long paramLong, Syllable[] paramArrayOfSyllable)
  {
    AppMethodBeat.i(212321);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnSyllableListUpdate(paramLong, paramArrayOfSyllable);
    }
    AppMethodBeat.o(212321);
  }
  
  public static native void process_input(long paramLong, String paramString);
  
  public static native void refresh_local_contacts(String[] paramArrayOfString);
  
  public static native void report_input_to_screen(String paramString);
  
  public static native void report_punct_input_to_screen(PunctToScreenEvent paramPunctToScreenEvent);
  
  public static native void reset_user_dict();
  
  public static native void select_candidate(long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2);
  
  public static native boolean session_get_bool_option(long paramLong, int paramInt);
  
  public static native void session_set_bool_option(long paramLong, int paramInt, boolean paramBoolean);
  
  public static native void session_set_internal_cursor(long paramLong, int paramInt);
  
  public static native void session_set_syllable_hint(long paramLong, byte[] paramArrayOfByte, int paramInt, String paramString);
  
  public static native void set_debug_console_log(boolean paramBoolean);
  
  public static native void set_text_around_cursor(long paramLong, String paramString1, String paramString2);
  
  public static native void test(int paramInt, String paramString);
  
  public void SetWxhldEventListener(WxhldEventListener paramWxhldEventListener)
  {
    this.mWxhldEventListener = paramWxhldEventListener;
  }
  
  public void SetWxhldLoginStatusListener(WxhldLoginStatusListener paramWxhldLoginStatusListener)
  {
    this.mWxhldLoginStatusListener = paramWxhldLoginStatusListener;
  }
  
  public void init(Context paramContext)
  {
    AppMethodBeat.i(212327);
    if (this.mContext != null)
    {
      AppMethodBeat.o(212327);
      return;
    }
    this.mHandler = new Handler(paramContext.getMainLooper());
    this.mContext = paramContext.getApplicationContext();
    PlatformComm.init(this.mContext, this.mHandler);
    AppMethodBeat.o(212327);
  }
  
  public static abstract class Singleton<T>
  {
    private volatile T mInstance;
    
    protected abstract T createInstance();
    
    public final T getInstance()
    {
      if (this.mInstance == null) {}
      try
      {
        if (this.mInstance == null) {
          this.mInstance = createInstance();
        }
        return this.mInstance;
      }
      finally {}
    }
  }
  
  public static abstract interface WxhldEventListener
  {
    public abstract void OnCandidateListUpdate(long paramLong1, long paramLong2, int paramInt);
    
    public abstract void OnCandidateSelected(long paramLong);
    
    public abstract void OnEmitInputToScreen(long paramLong, String paramString);
    
    @Deprecated
    public abstract void OnPendingInputUpdate(long paramLong, String paramString);
    
    public abstract void OnPendingInputUpdateV2(long paramLong, PendingInput[] paramArrayOfPendingInput);
    
    public abstract void OnSyllableListUpdate(long paramLong, Syllable[] paramArrayOfSyllable);
  }
  
  public static abstract interface WxhldLoginStatusListener
  {
    public abstract void OnLoginComplete(int paramInt);
    
    public abstract void OnLogouted();
    
    public abstract void OnSessionExpired();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wxhld.WxhldApi
 * JD-Core Version:    0.7.0.1
 */