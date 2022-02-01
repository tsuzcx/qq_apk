package j.a.a;

import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.k;
import java.io.IOException;

public final class d
  extends b
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener
{
  private String UpK;
  private boolean UpL;
  private boolean UpM;
  private c UpN = c.UpG;
  private String UpO = "speakers";
  private int UpP = -1;
  private a UpQ;
  private boolean bcY = false;
  private boolean bfW = false;
  private MediaPlayer goA;
  private double iJG = 1.0D;
  private float rate = 1.0F;
  private boolean released = true;
  private String url;
  
  d(a parama, String paramString)
  {
    this.UpQ = parama;
    this.UpK = paramString;
  }
  
  private void a(MediaPlayer paramMediaPlayer, Context paramContext)
  {
    AppMethodBeat.i(204530);
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (objectEquals(this.UpO, "speakers"))
      {
        paramContext = new AudioAttributes.Builder();
        if (this.UpL) {}
        for (i = 6;; i = 1)
        {
          paramMediaPlayer.setAudioAttributes(paramContext.setUsage(i).setContentType(2).build());
          AppMethodBeat.o(204530);
          return;
        }
      }
      paramMediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(2).setContentType(2).build());
      if (paramContext != null)
      {
        ((AudioManager)paramContext.getSystemService("audio")).setSpeakerphoneOn(false);
        AppMethodBeat.o(204530);
      }
    }
    else
    {
      if (objectEquals(this.UpO, "speakers"))
      {
        if (this.UpL) {}
        for (i = 2;; i = 3)
        {
          paramMediaPlayer.setAudioStreamType(i);
          AppMethodBeat.o(204530);
          return;
        }
      }
      paramMediaPlayer.setAudioStreamType(0);
    }
    AppMethodBeat.o(204530);
  }
  
  private MediaPlayer mc(Context paramContext)
  {
    AppMethodBeat.i(204528);
    MediaPlayer localMediaPlayer = new MediaPlayer();
    localMediaPlayer.setOnPreparedListener(this);
    localMediaPlayer.setOnCompletionListener(this);
    localMediaPlayer.setOnSeekCompleteListener(this);
    localMediaPlayer.setOnErrorListener(this);
    a(localMediaPlayer, paramContext);
    localMediaPlayer.setVolume((float)this.iJG, (float)this.iJG);
    if (this.UpN == c.UpH) {}
    for (boolean bool = true;; bool = false)
    {
      localMediaPlayer.setLooping(bool);
      AppMethodBeat.o(204528);
      return localMediaPlayer;
    }
  }
  
  private void setSource(String paramString)
  {
    AppMethodBeat.i(204529);
    try
    {
      this.goA.setDataSource(paramString);
      AppMethodBeat.o(204529);
      return;
    }
    catch (IOException paramString)
    {
      paramString = new RuntimeException("Unable to access resource", paramString);
      AppMethodBeat.o(204529);
      throw paramString;
    }
  }
  
  final int P(double paramDouble)
  {
    AppMethodBeat.i(204515);
    if (Build.VERSION.SDK_INT < 23)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("The method 'setRate' is available only on Android SDK version 23 or higher!");
      AppMethodBeat.o(204515);
      throw localUnsupportedOperationException;
    }
    if (this.goA != null)
    {
      this.rate = ((float)paramDouble);
      this.goA.setPlaybackParams(this.goA.getPlaybackParams().setSpeed(this.rate));
      AppMethodBeat.o(204515);
      return 1;
    }
    AppMethodBeat.o(204515);
    return 0;
  }
  
  final void a(c paramc)
  {
    AppMethodBeat.i(204517);
    MediaPlayer localMediaPlayer;
    if (this.UpN != paramc)
    {
      this.UpN = paramc;
      if (!this.released)
      {
        localMediaPlayer = this.goA;
        if (paramc != c.UpH) {
          break label50;
        }
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      localMediaPlayer.setLooping(bool);
      AppMethodBeat.o(204517);
      return;
    }
  }
  
  final void a(String paramString, boolean paramBoolean, Context paramContext)
  {
    paramBoolean = false;
    AppMethodBeat.i(204512);
    if (!objectEquals(this.url, paramString))
    {
      this.url = paramString;
      if (!this.released) {
        break label101;
      }
      this.goA = mc(paramContext);
      this.released = false;
    }
    for (;;)
    {
      setSource(paramString);
      this.goA.setVolume((float)this.iJG, (float)this.iJG);
      paramString = this.goA;
      if (this.UpN == c.UpH) {
        paramBoolean = true;
      }
      paramString.setLooping(paramBoolean);
      this.goA.prepareAsync();
      AppMethodBeat.o(204512);
      return;
      label101:
      if (this.bcY)
      {
        this.goA.reset();
        this.bcY = false;
      }
    }
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext)
  {
    AppMethodBeat.i(204516);
    if (this.UpL != paramBoolean1)
    {
      this.UpL = paramBoolean1;
      if (!this.released) {
        a(this.goA, paramContext);
      }
    }
    if (this.UpM != paramBoolean2)
    {
      this.UpM = paramBoolean2;
      if ((!this.released) && (this.UpM)) {
        this.goA.setWakeMode(paramContext, 1);
      }
    }
    AppMethodBeat.o(204516);
  }
  
  final String esX()
  {
    return this.UpK;
  }
  
  final int getCurrentPosition()
  {
    AppMethodBeat.i(204519);
    int i = this.goA.getCurrentPosition();
    AppMethodBeat.o(204519);
    return i;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(204518);
    int i = this.goA.getDuration();
    AppMethodBeat.o(204518);
    return i;
  }
  
  final boolean hRs()
  {
    return (this.bfW) && (this.bcY);
  }
  
  final void mb(Context paramContext)
  {
    AppMethodBeat.i(204520);
    if (!this.bfW)
    {
      this.bfW = true;
      if (this.released)
      {
        this.released = false;
        this.goA = mc(paramContext);
        setSource(this.url);
        this.goA.prepareAsync();
        AppMethodBeat.o(204520);
        return;
      }
      if (this.bcY)
      {
        this.goA.start();
        this.UpQ.hRr();
      }
    }
    AppMethodBeat.o(204520);
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(204526);
    if (this.UpN != c.UpH) {
      stop();
    }
    this.UpQ.bbv.a("audio.onComplete", a.J(esX(), Boolean.TRUE), null);
    AppMethodBeat.o(204526);
  }
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204527);
    Object localObject1;
    if (paramInt1 == 100)
    {
      paramMediaPlayer = "MEDIA_ERROR_SERVER_DIED";
      switch (paramInt2)
      {
      default: 
        localObject1 = "MEDIA_ERROR_UNKNOWN {extra:" + paramInt2 + "}";
        paramMediaPlayer = (MediaPlayer)localObject1;
      }
    }
    for (;;)
    {
      Object localObject2 = this.UpQ;
      paramMediaPlayer = "MediaPlayer error with what:" + (String)localObject1 + " extra:" + paramMediaPlayer;
      ((a)localObject2).bbv.a("audio.onError", a.J(esX(), paramMediaPlayer), null);
      AppMethodBeat.o(204527);
      return false;
      paramMediaPlayer = "MEDIA_ERROR_UNKNOWN {what:" + paramInt1 + "}";
      break;
      localObject2 = "MEDIA_ERROR_SYSTEM";
      localObject1 = paramMediaPlayer;
      paramMediaPlayer = (MediaPlayer)localObject2;
      continue;
      localObject2 = "MEDIA_ERROR_IO";
      localObject1 = paramMediaPlayer;
      paramMediaPlayer = (MediaPlayer)localObject2;
      continue;
      localObject2 = "MEDIA_ERROR_MALFORMED";
      localObject1 = paramMediaPlayer;
      paramMediaPlayer = (MediaPlayer)localObject2;
      continue;
      localObject2 = "MEDIA_ERROR_UNSUPPORTED";
      localObject1 = paramMediaPlayer;
      paramMediaPlayer = (MediaPlayer)localObject2;
      continue;
      localObject2 = "MEDIA_ERROR_TIMED_OUT";
      localObject1 = paramMediaPlayer;
      paramMediaPlayer = (MediaPlayer)localObject2;
    }
  }
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(204525);
    this.bcY = true;
    this.UpQ.bbv.a("audio.onDuration", a.J(esX(), Integer.valueOf(getDuration())), null);
    if (this.bfW)
    {
      this.goA.start();
      this.UpQ.hRr();
    }
    if (this.UpP >= 0)
    {
      this.goA.seekTo(this.UpP);
      this.UpP = -1;
    }
    AppMethodBeat.o(204525);
  }
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    this.UpQ.UpB = true;
  }
  
  final void p(String paramString, Context paramContext)
  {
    AppMethodBeat.i(204514);
    boolean bool;
    if (!objectEquals(this.UpO, paramString))
    {
      bool = this.bfW;
      if (bool) {
        pause();
      }
      this.UpO = paramString;
      if (this.goA == null) {
        break label130;
      }
    }
    label130:
    for (int i = this.goA.getCurrentPosition();; i = 0)
    {
      this.released = false;
      this.goA = mc(paramContext);
      setSource(this.url);
      try
      {
        this.goA.prepare();
        seek(i);
        if (bool)
        {
          this.bfW = true;
          this.goA.start();
        }
        AppMethodBeat.o(204514);
        return;
      }
      catch (IOException paramString)
      {
        paramString = new RuntimeException("Unable to access resource", paramString);
        AppMethodBeat.o(204514);
        throw paramString;
      }
    }
  }
  
  final void pause()
  {
    AppMethodBeat.i(204523);
    if (this.bfW)
    {
      this.bfW = false;
      this.goA.pause();
    }
    AppMethodBeat.o(204523);
  }
  
  final void release()
  {
    AppMethodBeat.i(204522);
    if (this.released)
    {
      AppMethodBeat.o(204522);
      return;
    }
    if (this.bfW) {
      this.goA.stop();
    }
    this.goA.reset();
    this.goA.release();
    this.goA = null;
    this.bcY = false;
    this.released = true;
    this.bfW = false;
    AppMethodBeat.o(204522);
  }
  
  final void seek(int paramInt)
  {
    AppMethodBeat.i(204524);
    if (this.bcY)
    {
      this.goA.seekTo(paramInt);
      AppMethodBeat.o(204524);
      return;
    }
    this.UpP = paramInt;
    AppMethodBeat.o(204524);
  }
  
  final void stop()
  {
    AppMethodBeat.i(204521);
    if (this.released)
    {
      AppMethodBeat.o(204521);
      return;
    }
    if (this.UpN != c.UpG)
    {
      if (this.bfW)
      {
        this.bfW = false;
        this.goA.pause();
        this.goA.seekTo(0);
        AppMethodBeat.o(204521);
      }
    }
    else {
      release();
    }
    AppMethodBeat.o(204521);
  }
  
  final void u(double paramDouble)
  {
    AppMethodBeat.i(204513);
    if (this.iJG != paramDouble)
    {
      this.iJG = paramDouble;
      if (!this.released) {
        this.goA.setVolume((float)paramDouble, (float)paramDouble);
      }
    }
    AppMethodBeat.o(204513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     j.a.a.d
 * JD-Core Version:    0.7.0.1
 */