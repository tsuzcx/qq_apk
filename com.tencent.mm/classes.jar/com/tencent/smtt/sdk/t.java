package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

class t
  extends FrameLayout
  implements MediaPlayer.OnErrorListener
{
  private byte _hellAccFlag_;
  private Object a;
  private u b;
  private VideoView c;
  private Context d;
  private String e;
  
  public t(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    AppMethodBeat.i(55196);
    this.d = null;
    this.d = paramContext;
    AppMethodBeat.o(55196);
  }
  
  private void b(Bundle paramBundle, Object paramObject)
  {
    AppMethodBeat.i(55198);
    a();
    if (b()) {
      paramBundle.putInt("callMode", paramBundle.getInt("callMode"));
    }
    for (boolean bool = this.b.a(this.a, paramBundle, this, paramObject);; bool = false)
    {
      if (!bool)
      {
        if (this.c != null) {
          this.c.stopPlayback();
        }
        if (this.c == null) {
          this.c = new VideoView(getContext());
        }
        this.e = paramBundle.getString("videoUrl");
        this.c.setVideoURI(Uri.parse(this.e));
        this.c.setOnErrorListener(this);
        paramObject = new Intent("com.tencent.smtt.tbs.video.PLAY");
        paramObject.addFlags(268435456);
        paramBundle = getContext().getApplicationContext();
        paramObject.setPackage(paramBundle.getPackageName());
        paramObject = new com.tencent.mm.hellhoundlib.b.a().bd(paramObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramBundle, paramObject.adn(), "com/tencent/smtt/sdk/t", "b", "(Landroid/os/Bundle;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramBundle.startActivity((Intent)paramObject.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/smtt/sdk/t", "b", "(Landroid/os/Bundle;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(55198);
      return;
    }
  }
  
  void a()
  {
    DexLoader localDexLoader = null;
    AppMethodBeat.i(55199);
    setBackgroundColor(-16777216);
    if (this.b == null)
    {
      e.a(true).a(getContext().getApplicationContext(), false, false, null);
      TbsWizard localTbsWizard = e.a(true).a();
      if (localTbsWizard != null) {
        localDexLoader = localTbsWizard.dexLoader();
      }
      if ((localDexLoader != null) && (QbSdk.canLoadVideo(getContext()))) {
        this.b = new u(localDexLoader);
      }
    }
    if ((this.b != null) && (this.a == null)) {
      this.a = this.b.a(getContext().getApplicationContext());
    }
    AppMethodBeat.o(55199);
  }
  
  public void a(Activity paramActivity)
  {
    AppMethodBeat.i(55200);
    if ((!b()) && (this.c != null))
    {
      if (this.c.getParent() == null)
      {
        Window localWindow = paramActivity.getWindow();
        FrameLayout localFrameLayout = (FrameLayout)localWindow.getDecorView();
        localWindow.addFlags(1024);
        localWindow.addFlags(128);
        localFrameLayout.setBackgroundColor(-16777216);
        paramActivity = new MediaController(paramActivity);
        paramActivity.setMediaPlayer(this.c);
        this.c.setMediaController(paramActivity);
        paramActivity = new FrameLayout.LayoutParams(-1, -1);
        paramActivity.gravity = 17;
        localFrameLayout.addView(this.c, paramActivity);
      }
      if (Build.VERSION.SDK_INT >= 8) {
        this.c.start();
      }
    }
    AppMethodBeat.o(55200);
  }
  
  void a(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(55201);
    if ((paramInt == 3) && (!b()) && (this.c != null)) {
      this.c.pause();
    }
    if (paramInt == 4)
    {
      this.d = null;
      if ((!b()) && (this.c != null))
      {
        this.c.stopPlayback();
        this.c = null;
      }
    }
    if ((paramInt == 2) && (!b()))
    {
      this.d = paramActivity;
      a(paramActivity);
    }
    if (b()) {
      this.b.a(this.a, paramActivity, paramInt);
    }
    AppMethodBeat.o(55201);
  }
  
  void a(Bundle paramBundle, Object paramObject)
  {
    AppMethodBeat.i(55197);
    b(paramBundle, paramObject);
    AppMethodBeat.o(55197);
  }
  
  public boolean b()
  {
    return (this.b != null) && (this.a != null);
  }
  
  public void c()
  {
    AppMethodBeat.i(55203);
    if (b()) {
      this.b.a(this.a);
    }
    AppMethodBeat.o(55203);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55202);
    try
    {
      if ((this.d instanceof Activity))
      {
        paramMediaPlayer = (Activity)this.d;
        if (!paramMediaPlayer.isFinishing()) {
          paramMediaPlayer.finish();
        }
      }
      paramMediaPlayer = getContext();
      if (paramMediaPlayer != null)
      {
        Toast.makeText(paramMediaPlayer, "播放失败，请选择其它播放器播放", 1).show();
        paramMediaPlayer = paramMediaPlayer.getApplicationContext();
        Object localObject = new Intent("android.intent.action.VIEW");
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).setDataAndType(Uri.parse(this.e), "video/*");
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramMediaPlayer, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/smtt/sdk/t", "onError", "(Landroid/media/MediaPlayer;II)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramMediaPlayer.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramMediaPlayer, "com/tencent/smtt/sdk/t", "onError", "(Landroid/media/MediaPlayer;II)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(55202);
      return true;
    }
    catch (Throwable paramMediaPlayer)
    {
      AppMethodBeat.o(55202);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.t
 * JD-Core Version:    0.7.0.1
 */