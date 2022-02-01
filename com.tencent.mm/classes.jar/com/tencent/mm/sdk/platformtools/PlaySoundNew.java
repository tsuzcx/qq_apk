package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Looper;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.thread.ThreadKt;
import com.tencent.threadpool.i;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/PlaySoundNew;", "", "()V", "TAG", "", "job", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "destroy", "", "play", "context", "Landroid/content/Context;", "pathId", "", "speakeron", "Lcom/tencent/mm/sdk/platformtools/PlaySoundNew$SPEAKERON;", "looping", "", "listener", "Lcom/tencent/mm/sdk/platformtools/PlaySoundNew$OnPlayCompletionListener;", "playRootExo", "stream", "playRootTP", "OnPlayCompletionListener", "SPEAKERON", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PlaySoundNew
{
  public static final PlaySoundNew INSTANCE;
  private static final String TAG = "MicroMsg.PlaySoundNew";
  private static cb job;
  private static final aq scope;
  
  static
  {
    AppMethodBeat.i(243690);
    INSTANCE = new PlaySoundNew();
    scope = ar.b(ar.kBZ(), (f)cx.g(null));
    AppMethodBeat.o(243690);
  }
  
  public static final void play(Context paramContext, int paramInt, PlaySoundNew.SPEAKERON paramSPEAKERON, boolean paramBoolean, OnPlayCompletionListener paramOnPlayCompletionListener)
  {
    AppMethodBeat.i(243674);
    s.u(paramContext, "context");
    s.u(paramSPEAKERON, "speakeron");
    playRootTP(paramContext, paramInt, paramSPEAKERON, -1, paramBoolean, paramOnPlayCompletionListener);
    AppMethodBeat.o(243674);
  }
  
  public static final void play(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2, OnPlayCompletionListener paramOnPlayCompletionListener)
  {
    AppMethodBeat.i(243676);
    s.u(paramContext, "context");
    if (paramBoolean1) {}
    for (PlaySoundNew.SPEAKERON localSPEAKERON = PlaySoundNew.SPEAKERON.ON;; localSPEAKERON = PlaySoundNew.SPEAKERON.OFF)
    {
      playRootTP(paramContext, paramInt, localSPEAKERON, -1, paramBoolean2, paramOnPlayCompletionListener);
      AppMethodBeat.o(243676);
      return;
    }
  }
  
  public static final void playRootExo(Context paramContext, int paramInt1, PlaySoundNew.SPEAKERON paramSPEAKERON, int paramInt2, boolean paramBoolean, final OnPlayCompletionListener paramOnPlayCompletionListener)
  {
    AppMethodBeat.i(243672);
    s.u(paramSPEAKERON, "speakeron");
    if (paramContext == null)
    {
      Log.e("MicroMsg.PlaySoundNew", "play Err context:%s pathId:%d speekeron:%s looping:%b listener:%s", new Object[] { paramContext, Integer.valueOf(paramInt1), paramSPEAKERON, Boolean.valueOf(paramBoolean), paramOnPlayCompletionListener });
      AppMethodBeat.o(243672);
      return;
    }
    String str = paramContext.getString(paramInt1);
    s.s(str, "context.getString(pathId)");
    v localv = com.google.android.exoplayer2.g.a(paramContext, (com.google.android.exoplayer2.g.h)new com.google.android.exoplayer2.g.c((f.a)new a.a((d)new l())));
    if ((paramSPEAKERON != PlaySoundNew.SPEAKERON.NOTSET) && (-1 == paramInt2)) {
      if (paramSPEAKERON == PlaySoundNew.SPEAKERON.ON) {
        paramInt2 = 3;
      }
    }
    for (;;)
    {
      localv.setAudioStreamType(paramInt2);
      label137:
      Log.i("MicroMsg.PlaySoundNew", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b listener:%s ", new Object[] { Integer.valueOf(localv.hashCode()), str, paramContext, Integer.valueOf(paramInt1), paramSPEAKERON, Boolean.valueOf(paramBoolean), paramOnPlayCompletionListener });
      try
      {
        Log.i("MicroMsg.PlaySoundNew", s.X("play prepare path:", str));
        paramSPEAKERON = new j(Uri.parse(s.X("file:///android_asset/", str)));
        paramContext = new com.google.android.exoplayer2.h.c(paramContext);
        paramContext.a(paramSPEAKERON);
        paramSPEAKERON = new PlaySoundNew..ExternalSyntheticLambda0(paramContext);
        paramContext = new com.google.android.exoplayer2.source.h(paramContext.uri, paramSPEAKERON, (com.google.android.exoplayer2.c.h)new com.google.android.exoplayer2.c.c(), null, null);
        localv.a((q.a)new q.a()
        {
          private static final void onPlayerError$lambda-1(v paramAnonymousv, PlaySoundNew.OnPlayCompletionListener paramAnonymousOnPlayCompletionListener)
          {
            AppMethodBeat.i(243884);
            paramAnonymousv.stop();
            paramAnonymousv.release();
            com.tencent.threadpool.h.ahAA.bk(new PlaySoundNew.playRootExo.1..ExternalSyntheticLambda3(paramAnonymousOnPlayCompletionListener));
            AppMethodBeat.o(243884);
          }
          
          private static final void onPlayerError$lambda-1$lambda-0(PlaySoundNew.OnPlayCompletionListener paramAnonymousOnPlayCompletionListener)
          {
            AppMethodBeat.i(243878);
            if (paramAnonymousOnPlayCompletionListener != null) {
              paramAnonymousOnPlayCompletionListener.onCompletion();
            }
            AppMethodBeat.o(243878);
          }
          
          private static final void onPlayerStateChanged$lambda-3(v paramAnonymousv, PlaySoundNew.OnPlayCompletionListener paramAnonymousOnPlayCompletionListener)
          {
            AppMethodBeat.i(243903);
            paramAnonymousv.stop();
            paramAnonymousv.release();
            com.tencent.threadpool.h.ahAA.bk(new PlaySoundNew.playRootExo.1..ExternalSyntheticLambda2(paramAnonymousOnPlayCompletionListener));
            AppMethodBeat.o(243903);
          }
          
          private static final void onPlayerStateChanged$lambda-3$lambda-2(PlaySoundNew.OnPlayCompletionListener paramAnonymousOnPlayCompletionListener)
          {
            AppMethodBeat.i(243894);
            if (paramAnonymousOnPlayCompletionListener != null) {
              paramAnonymousOnPlayCompletionListener.onCompletion();
            }
            AppMethodBeat.o(243894);
          }
          
          public final void onLoadingChanged(boolean paramAnonymousBoolean) {}
          
          public final void onPlaybackParametersChanged(p paramAnonymousp) {}
          
          public final void onPlayerError(e paramAnonymouse)
          {
            AppMethodBeat.i(243954);
            if (paramAnonymouse == null) {}
            for (paramAnonymouse = null;; paramAnonymouse = paramAnonymouse.getLocalizedMessage())
            {
              Log.i("MicroMsg.PlaySoundNew", s.X("onPlayerError error:", paramAnonymouse));
              com.tencent.threadpool.h.ahAA.bm(new PlaySoundNew.playRootExo.1..ExternalSyntheticLambda0(this.$player, paramOnPlayCompletionListener));
              AppMethodBeat.o(243954);
              return;
            }
          }
          
          public final void onPlayerStateChanged(boolean paramAnonymousBoolean, int paramAnonymousInt)
          {
            AppMethodBeat.i(243967);
            Log.i("MicroMsg.PlaySoundNew", "onPlayerStateChanged playWhenReady:" + paramAnonymousBoolean + ", playbackState:" + paramAnonymousInt);
            if (paramAnonymousInt == 4)
            {
              Log.i("MicroMsg.PlaySoundNew", "play end");
              com.tencent.threadpool.h.ahAA.bm(new PlaySoundNew.playRootExo.1..ExternalSyntheticLambda1(this.$player, paramOnPlayCompletionListener));
            }
            AppMethodBeat.o(243967);
          }
          
          public final void onPositionDiscontinuity() {}
          
          public final void onRepeatModeChanged(int paramAnonymousInt) {}
          
          public final void onTimelineChanged(w paramAnonymousw, Object paramAnonymousObject) {}
          
          public final void onTracksChanged(r paramAnonymousr, com.google.android.exoplayer2.g.g paramAnonymousg) {}
        });
        localv.bv(true);
        localv.J(0);
        localv.a((k)paramContext);
        paramInt2 = localv.hashCode();
        if (Looper.myLooper() != null)
        {
          paramBoolean = true;
          label328:
          if (Looper.getMainLooper() == null) {
            break label404;
          }
        }
        label404:
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.PlaySoundNew", "play start mp finish [%d], myLooper[%b] mainLooper[%b]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
          AppMethodBeat.o(243672);
          return;
          paramInt2 = 8;
          break;
          if (paramInt2 == -1) {
            break label137;
          }
          localv.setAudioStreamType(paramInt2);
          break label137;
          paramBoolean = false;
          break label328;
        }
        return;
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.PlaySoundNew", "play failed pathId:%d e:%s", new Object[] { Integer.valueOf(paramInt1), paramContext.getMessage() });
        Log.printErrStackTrace("MicroMsg.PlaySoundNew", (Throwable)paramContext, "", new Object[0]);
        com.tencent.threadpool.h.ahAA.bm(new PlaySoundNew..ExternalSyntheticLambda2(localv));
        AppMethodBeat.o(243672);
      }
    }
  }
  
  private static final com.google.android.exoplayer2.h.g playRootExo$lambda-1(com.google.android.exoplayer2.h.c paramc)
  {
    AppMethodBeat.i(243683);
    s.u(paramc, "$assetDataSource");
    paramc = (com.google.android.exoplayer2.h.g)paramc;
    AppMethodBeat.o(243683);
    return paramc;
  }
  
  private static final void playRootExo$lambda-2(v paramv)
  {
    AppMethodBeat.i(243685);
    paramv.stop();
    paramv.release();
    AppMethodBeat.o(243685);
  }
  
  public static final void playRootTP(Context paramContext, int paramInt1, PlaySoundNew.SPEAKERON paramSPEAKERON, int paramInt2, boolean paramBoolean, OnPlayCompletionListener paramOnPlayCompletionListener)
  {
    AppMethodBeat.i(243667);
    s.u(paramSPEAKERON, "speakeron");
    if (paramContext == null)
    {
      Log.e("MicroMsg.PlaySoundNew", "play Err context:%s pathId:%d speekeron:%s looping:%b listener:%s", new Object[] { paramContext, Integer.valueOf(paramInt1), paramSPEAKERON, Boolean.valueOf(paramBoolean), paramOnPlayCompletionListener });
      AppMethodBeat.o(243667);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new PlaySoundNew..ExternalSyntheticLambda1(paramContext, paramInt1, paramSPEAKERON, paramInt2, paramOnPlayCompletionListener));
    AppMethodBeat.o(243667);
  }
  
  private static final void playRootTP$lambda-0(Context paramContext, int paramInt1, PlaySoundNew.SPEAKERON paramSPEAKERON, int paramInt2, OnPlayCompletionListener paramOnPlayCompletionListener)
  {
    AppMethodBeat.i(243682);
    s.u(paramSPEAKERON, "$speakeron");
    try
    {
      String str = paramContext.getString(paramInt1);
      s.s(str, "context.getString(pathId)");
      Log.i("MicroMsg.PlaySoundNew", "play asset path:" + str + ", pathId:" + paramInt1);
      ITPPlayer localITPPlayer = TPPlayerFactory.createTPPlayer(paramContext);
      if (localITPPlayer == null)
      {
        AppMethodBeat.o(243682);
        return;
      }
      localITPPlayer.setDataSource(paramContext.getAssets().openFd(str));
      if ((paramSPEAKERON != PlaySoundNew.SPEAKERON.NOTSET) && (-1 == paramInt2))
      {
        paramContext = new TPOptionalParam();
        if (paramSPEAKERON == PlaySoundNew.SPEAKERON.ON)
        {
          paramInt1 = 3;
          localITPPlayer.setPlayerOptionalParam(paramContext.buildLong(302, paramInt1));
        }
      }
      for (;;)
      {
        localITPPlayer.setLoopback(false);
        paramContext = new ITPPlayerListener.IOnCompletionListener()
        {
          private static final void onCompletion$lambda-0(ITPPlayer paramAnonymousITPPlayer, PlaySoundNew.OnPlayCompletionListener paramAnonymousOnPlayCompletionListener)
          {
            AppMethodBeat.i(243818);
            if (paramAnonymousITPPlayer != null) {}
            try
            {
              paramAnonymousITPPlayer.stopAsync();
              if (paramAnonymousITPPlayer != null) {
                paramAnonymousITPPlayer.release();
              }
              return;
            }
            catch (Exception paramAnonymousITPPlayer)
            {
              Log.printErrStackTrace("MicroMsg.PlaySoundNew", (Throwable)paramAnonymousITPPlayer, "onCompletion release player error", new Object[0]);
              return;
            }
            finally
            {
              ThreadKt.uiThread((a)new u(paramAnonymousOnPlayCompletionListener)
              {
                public final void invoke()
                {
                  AppMethodBeat.i(243595);
                  PlaySoundNew.OnPlayCompletionListener localOnPlayCompletionListener = this.$listener;
                  if (localOnPlayCompletionListener != null) {
                    localOnPlayCompletionListener.onCompletion();
                  }
                  AppMethodBeat.o(243595);
                }
              });
              AppMethodBeat.o(243818);
            }
          }
          
          private static final void onError$lambda-1(ITPPlayer paramAnonymousITPPlayer)
          {
            AppMethodBeat.i(243823);
            if (paramAnonymousITPPlayer != null) {}
            try
            {
              paramAnonymousITPPlayer.stopAsync();
              if (paramAnonymousITPPlayer != null)
              {
                paramAnonymousITPPlayer.release();
                AppMethodBeat.o(243823);
                return;
              }
            }
            catch (Exception paramAnonymousITPPlayer)
            {
              Log.printErrStackTrace("MicroMsg.PlaySoundNew", (Throwable)paramAnonymousITPPlayer, "onError release player error", new Object[0]);
              AppMethodBeat.o(243823);
            }
          }
          
          public final void onCompletion(ITPPlayer paramAnonymousITPPlayer)
          {
            AppMethodBeat.i(243848);
            Log.i("MicroMsg.PlaySoundNew", "onCompletion");
            com.tencent.threadpool.h.ahAA.bm(new PlaySoundNew.playRootTP.1.playerListener.1..ExternalSyntheticLambda1(paramAnonymousITPPlayer, this.$listener));
            AppMethodBeat.o(243848);
          }
          
          public final void onError(ITPPlayer paramAnonymousITPPlayer, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
          {
            AppMethodBeat.i(243853);
            Log.i("MicroMsg.PlaySoundNew", "onError errType:" + paramAnonymousInt1 + " errorCode:" + paramAnonymousInt2 + ", arg:" + paramAnonymousLong1 + ' ' + paramAnonymousLong2);
            com.tencent.threadpool.h.ahAA.bm(new PlaySoundNew.playRootTP.1.playerListener.1..ExternalSyntheticLambda0(paramAnonymousITPPlayer));
            AppMethodBeat.o(243853);
          }
          
          public final void onInfo(ITPPlayer paramAnonymousITPPlayer, int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(243840);
            Log.i("MicroMsg.PlaySoundNew", "onInfo, what:" + paramAnonymousInt + ' ' + paramAnonymousLong1 + ' ' + paramAnonymousLong2 + ' ' + paramAnonymousObject);
            AppMethodBeat.o(243840);
          }
          
          public final void onPrepared(ITPPlayer paramAnonymousITPPlayer)
          {
            AppMethodBeat.i(243835);
            Log.i("MicroMsg.PlaySoundNew", "onPrepared");
            if (paramAnonymousITPPlayer != null) {
              paramAnonymousITPPlayer.start();
            }
            AppMethodBeat.o(243835);
          }
          
          public final void onStateChange(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(243844);
            Log.i("MicroMsg.PlaySoundNew", "onStateChange " + paramAnonymousInt1 + ' ' + paramAnonymousInt2);
            AppMethodBeat.o(243844);
          }
        };
        localITPPlayer.setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)paramContext);
        localITPPlayer.setOnInfoListener((ITPPlayerListener.IOnInfoListener)paramContext);
        localITPPlayer.setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)paramContext);
        localITPPlayer.setOnCompletionListener((ITPPlayerListener.IOnCompletionListener)paramContext);
        localITPPlayer.setOnErrorListener((ITPPlayerListener.IOnErrorListener)paramContext);
        localITPPlayer.prepareAsync();
        AppMethodBeat.o(243682);
        return;
        paramInt1 = 8;
        break;
        if (paramInt2 != -1) {
          localITPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(302, paramInt2));
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.PlaySoundNew", (Throwable)paramContext, "", new Object[0]);
      AppMethodBeat.o(243682);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(243706);
    ar.a(scope, null);
    AppMethodBeat.o(243706);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/PlaySoundNew$OnPlayCompletionListener;", "", "onCompletion", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface OnPlayCompletionListener
  {
    public abstract void onCompletion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PlaySoundNew
 * JD-Core Version:    0.7.0.1
 */