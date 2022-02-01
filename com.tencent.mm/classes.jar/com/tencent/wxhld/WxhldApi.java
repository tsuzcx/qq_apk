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
  private Context mContext;
  private Handler mHandler;
  WxhldEventListener mWxhldEventListener = null;
  WxhldLoginStatusListener mWxhldLoginStatusListener = null;
  
  static
  {
    AppMethodBeat.i(244066);
    sSingleton = new Singleton()
    {
      protected final WxhldApi createInstance()
      {
        AppMethodBeat.i(244043);
        WxhldApi localWxhldApi = new WxhldApi();
        AppMethodBeat.o(244043);
        return localWxhldApi;
      }
    };
    System.loadLibrary("c++_shared");
    System.loadLibrary("wechatxlog");
    System.loadLibrary("private_protobuf");
    System.loadLibrary("ilink_xlog");
    System.loadLibrary("linkid");
    System.loadLibrary("ilink_network");
    System.loadLibrary("ilink_tdi");
    System.loadLibrary("wxhld");
    System.loadLibrary("wxhld_jni");
    AppMethodBeat.o(244066);
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
    AppMethodBeat.i(244054);
    WxhldApi localWxhldApi = (WxhldApi)sSingleton.getInstance();
    AppMethodBeat.o(244054);
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
    AppMethodBeat.i(244059);
    new StringBuilder("onCandidateListUpdate session is ").append(paramLong1).append(", new_iterator is ").append(paramLong2);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnCandidateListUpdate(paramLong1, paramLong2, paramInt);
    }
    AppMethodBeat.o(244059);
  }
  
  private static void onCandidateSelected(long paramLong)
  {
    AppMethodBeat.i(244060);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnCandidateSelected(paramLong);
    }
    AppMethodBeat.o(244060);
  }
  
  private static void onEmitInputToScreen(long paramLong, String paramString)
  {
    AppMethodBeat.i(244061);
    new StringBuilder("onEmitInputToScreen session is ").append(paramLong).append(", text is ").append(paramString);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnEmitInputToScreen(paramLong, paramString);
    }
    AppMethodBeat.o(244061);
  }
  
  private static void onLoginStatusEvent(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244065);
    if (getInstance().mWxhldLoginStatusListener == null)
    {
      AppMethodBeat.o(244065);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(244065);
      return;
      getInstance().mWxhldLoginStatusListener.OnLoginComplete(paramInt2);
      AppMethodBeat.o(244065);
      return;
      getInstance().mWxhldLoginStatusListener.OnLogouted();
      AppMethodBeat.o(244065);
      return;
      getInstance().mWxhldLoginStatusListener.OnSessionExpired();
    }
  }
  
  @Deprecated
  private static void onPendingInputUpdate(long paramLong, String paramString)
  {
    AppMethodBeat.i(244062);
    new StringBuilder("onPendingInputUpdate session is ").append(paramLong).append(", pending_input is ").append(paramString);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnPendingInputUpdate(paramLong, paramString);
    }
    AppMethodBeat.o(244062);
  }
  
  private static void onPendingInputUpdateV2(long paramLong, PendingInput[] paramArrayOfPendingInput)
  {
    AppMethodBeat.i(244064);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnPendingInputUpdateV2(paramLong, paramArrayOfPendingInput);
    }
    AppMethodBeat.o(244064);
  }
  
  private static void onSyllableListUpdate(long paramLong, Syllable[] paramArrayOfSyllable)
  {
    AppMethodBeat.i(244063);
    if (getInstance().mWxhldEventListener != null) {
      getInstance().mWxhldEventListener.OnSyllableListUpdate(paramLong, paramArrayOfSyllable);
    }
    AppMethodBeat.o(244063);
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
    AppMethodBeat.i(244055);
    if (this.mContext != null)
    {
      AppMethodBeat.o(244055);
      return;
    }
    this.mHandler = new Handler(paramContext.getMainLooper());
    this.mContext = paramContext.getApplicationContext();
    PlatformComm.init(this.mContext, this.mHandler);
    AppMethodBeat.o(244055);
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