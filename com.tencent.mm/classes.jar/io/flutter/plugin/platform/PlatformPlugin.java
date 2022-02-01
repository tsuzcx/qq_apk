package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.AppSwitcherDescription;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.Brightness;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemChromeStyle;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay;
import java.io.FileNotFoundException;
import java.util.List;

public class PlatformPlugin
{
  public static final int DEFAULT_SYSTEM_UI = 1280;
  private static final String TAG = "PlatformPlugin";
  private final Activity activity;
  private PlatformChannel.SystemChromeStyle currentTheme;
  private int mEnabledOverlays;
  final PlatformChannel.PlatformMessageHandler mPlatformMessageHandler;
  private final PlatformChannel platformChannel;
  private final PlatformPluginDelegate platformPluginDelegate;
  
  public PlatformPlugin(Activity paramActivity, PlatformChannel paramPlatformChannel)
  {
    this(paramActivity, paramPlatformChannel, null);
    AppMethodBeat.i(9883);
    AppMethodBeat.o(9883);
  }
  
  public PlatformPlugin(Activity paramActivity, PlatformChannel paramPlatformChannel, PlatformPluginDelegate paramPlatformPluginDelegate)
  {
    AppMethodBeat.i(189869);
    this.mPlatformMessageHandler = new PlatformChannel.PlatformMessageHandler()
    {
      public boolean clipboardHasStrings()
      {
        AppMethodBeat.i(190037);
        CharSequence localCharSequence = PlatformPlugin.access$700(PlatformPlugin.this, PlatformChannel.ClipboardContentFormat.PLAIN_TEXT);
        if ((localCharSequence != null) && (localCharSequence.length() > 0))
        {
          AppMethodBeat.o(190037);
          return true;
        }
        AppMethodBeat.o(190037);
        return false;
      }
      
      public CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat paramAnonymousClipboardContentFormat)
      {
        AppMethodBeat.i(9913);
        paramAnonymousClipboardContentFormat = PlatformPlugin.access$700(PlatformPlugin.this, paramAnonymousClipboardContentFormat);
        AppMethodBeat.o(9913);
        return paramAnonymousClipboardContentFormat;
      }
      
      public void playSystemSound(PlatformChannel.SoundType paramAnonymousSoundType)
      {
        AppMethodBeat.i(9905);
        PlatformPlugin.access$000(PlatformPlugin.this, paramAnonymousSoundType);
        AppMethodBeat.o(9905);
      }
      
      public void popSystemNavigator()
      {
        AppMethodBeat.i(9912);
        PlatformPlugin.access$600(PlatformPlugin.this);
        AppMethodBeat.o(9912);
      }
      
      public void restoreSystemUiOverlays()
      {
        AppMethodBeat.i(9910);
        PlatformPlugin.access$400(PlatformPlugin.this);
        AppMethodBeat.o(9910);
      }
      
      public void setApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription paramAnonymousAppSwitcherDescription)
      {
        AppMethodBeat.i(9908);
        PlatformPlugin.access$200(PlatformPlugin.this, paramAnonymousAppSwitcherDescription);
        AppMethodBeat.o(9908);
      }
      
      public void setClipboardData(String paramAnonymousString)
      {
        AppMethodBeat.i(9914);
        PlatformPlugin.access$800(PlatformPlugin.this, paramAnonymousString);
        AppMethodBeat.o(9914);
      }
      
      public void setPreferredOrientations(int paramAnonymousInt)
      {
        AppMethodBeat.i(9907);
        PlatformPlugin.access$100(PlatformPlugin.this, paramAnonymousInt);
        AppMethodBeat.o(9907);
      }
      
      public void setSystemUiOverlayStyle(PlatformChannel.SystemChromeStyle paramAnonymousSystemChromeStyle)
      {
        AppMethodBeat.i(9911);
        PlatformPlugin.access$500(PlatformPlugin.this, paramAnonymousSystemChromeStyle);
        AppMethodBeat.o(9911);
      }
      
      public void showSystemOverlays(List<PlatformChannel.SystemUiOverlay> paramAnonymousList)
      {
        AppMethodBeat.i(9909);
        PlatformPlugin.access$300(PlatformPlugin.this, paramAnonymousList);
        AppMethodBeat.o(9909);
      }
      
      public void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType paramAnonymousHapticFeedbackType)
      {
        AppMethodBeat.i(9906);
        PlatformPlugin.this.vibrateHapticFeedback(paramAnonymousHapticFeedbackType);
        AppMethodBeat.o(9906);
      }
    };
    this.activity = paramActivity;
    this.platformChannel = paramPlatformChannel;
    this.platformChannel.setPlatformMessageHandler(this.mPlatformMessageHandler);
    this.platformPluginDelegate = paramPlatformPluginDelegate;
    this.mEnabledOverlays = 1280;
    AppMethodBeat.o(189869);
  }
  
  private CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat paramClipboardContentFormat)
  {
    AppMethodBeat.i(189928);
    Object localObject = (ClipboardManager)this.activity.getSystemService("clipboard");
    if (!((ClipboardManager)localObject).hasPrimaryClip())
    {
      AppMethodBeat.o(189928);
      return null;
    }
    try
    {
      localObject = ((ClipboardManager)localObject).getPrimaryClip();
      if (localObject == null)
      {
        AppMethodBeat.o(189928);
        return null;
      }
      if ((paramClipboardContentFormat == null) || (paramClipboardContentFormat == PlatformChannel.ClipboardContentFormat.PLAIN_TEXT))
      {
        paramClipboardContentFormat = ((ClipData)localObject).getItemAt(0);
        if (paramClipboardContentFormat.getUri() != null) {
          this.activity.getContentResolver().openTypedAssetFileDescriptor(paramClipboardContentFormat.getUri(), "text/*", null);
        }
        paramClipboardContentFormat = paramClipboardContentFormat.coerceToText(this.activity);
        AppMethodBeat.o(189928);
        return paramClipboardContentFormat;
      }
    }
    catch (SecurityException paramClipboardContentFormat)
    {
      Log.w("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", paramClipboardContentFormat);
      AppMethodBeat.o(189928);
      return null;
    }
    catch (FileNotFoundException paramClipboardContentFormat)
    {
      AppMethodBeat.o(189928);
      return null;
    }
    AppMethodBeat.o(189928);
    return null;
  }
  
  private void playSystemSound(PlatformChannel.SoundType paramSoundType)
  {
    AppMethodBeat.i(189875);
    if (paramSoundType == PlatformChannel.SoundType.CLICK) {
      this.activity.getWindow().getDecorView().playSoundEffect(0);
    }
    AppMethodBeat.o(189875);
  }
  
  private void popSystemNavigator()
  {
    AppMethodBeat.i(189920);
    if ((this.platformPluginDelegate != null) && (this.platformPluginDelegate.popSystemNavigator()))
    {
      AppMethodBeat.o(189920);
      return;
    }
    if ((this.activity instanceof c)) {
      try
      {
        ((c)this.activity).getOnBackPressedDispatcher().onBackPressed();
        AppMethodBeat.o(189920);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(189920);
        return;
      }
    }
    this.activity.finish();
    AppMethodBeat.o(189920);
  }
  
  private void restoreSystemChromeSystemUIOverlays()
  {
    AppMethodBeat.i(189905);
    updateSystemUiOverlays();
    AppMethodBeat.o(189905);
  }
  
  private void setClipboardData(String paramString)
  {
    AppMethodBeat.i(189935);
    ((ClipboardManager)this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", paramString));
    AppMethodBeat.o(189935);
  }
  
  private void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription paramAppSwitcherDescription)
  {
    AppMethodBeat.i(189894);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(189894);
      return;
    }
    if ((Build.VERSION.SDK_INT < 28) && (Build.VERSION.SDK_INT > 21)) {
      this.activity.setTaskDescription(new ActivityManager.TaskDescription(paramAppSwitcherDescription.label, null, paramAppSwitcherDescription.color));
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramAppSwitcherDescription = new ActivityManager.TaskDescription(paramAppSwitcherDescription.label, 0, paramAppSwitcherDescription.color);
      this.activity.setTaskDescription(paramAppSwitcherDescription);
    }
    AppMethodBeat.o(189894);
  }
  
  private void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> paramList)
  {
    AppMethodBeat.i(189901);
    int j = 1798;
    int i = j;
    if (paramList.size() == 0)
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 19) {
        i = 5894;
      }
    }
    j = 0;
    if (j < paramList.size())
    {
      PlatformChannel.SystemUiOverlay localSystemUiOverlay = (PlatformChannel.SystemUiOverlay)paramList.get(j);
      switch (2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[localSystemUiOverlay.ordinal()])
      {
      }
      for (;;)
      {
        j += 1;
        break;
        i &= 0xFFFFFFFB;
        continue;
        i = i & 0xFFFFFDFF & 0xFFFFFFFD;
      }
    }
    this.mEnabledOverlays = i;
    updateSystemUiOverlays();
    AppMethodBeat.o(189901);
  }
  
  private void setSystemChromePreferredOrientations(int paramInt)
  {
    AppMethodBeat.i(189886);
    this.activity.setRequestedOrientation(paramInt);
    AppMethodBeat.o(189886);
  }
  
  private void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle paramSystemChromeStyle)
  {
    AppMethodBeat.i(9885);
    Window localWindow = this.activity.getWindow();
    View localView = localWindow.getDecorView();
    int k = localView.getSystemUiVisibility();
    int i = k;
    int j;
    if (Build.VERSION.SDK_INT >= 26)
    {
      j = k;
      if (paramSystemChromeStyle.systemNavigationBarIconBrightness == null) {}
    }
    switch (2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[paramSystemChromeStyle.systemNavigationBarIconBrightness.ordinal()])
    {
    default: 
      j = k;
      i = j;
      if (paramSystemChromeStyle.systemNavigationBarColor != null)
      {
        localWindow.setNavigationBarColor(paramSystemChromeStyle.systemNavigationBarColor.intValue());
        i = j;
      }
      k = i;
      if (Build.VERSION.SDK_INT >= 23)
      {
        j = i;
        if (paramSystemChromeStyle.statusBarIconBrightness != null) {
          switch (2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[paramSystemChromeStyle.statusBarIconBrightness.ordinal()])
          {
          default: 
            j = i;
          }
        }
      }
      break;
    }
    for (;;)
    {
      k = j;
      if (paramSystemChromeStyle.statusBarColor != null)
      {
        localWindow.setStatusBarColor(paramSystemChromeStyle.statusBarColor.intValue());
        k = j;
      }
      if ((paramSystemChromeStyle.systemNavigationBarDividerColor != null) && (Build.VERSION.SDK_INT >= 28))
      {
        localWindow.addFlags(-2147483648);
        localWindow.clearFlags(134217728);
        localWindow.setNavigationBarDividerColor(paramSystemChromeStyle.systemNavigationBarDividerColor.intValue());
      }
      localView.setSystemUiVisibility(k);
      this.currentTheme = paramSystemChromeStyle;
      AppMethodBeat.o(9885);
      return;
      j = k | 0x10;
      break;
      j = k & 0xFFFFFFEF;
      break;
      j = i | 0x2000;
      continue;
      j = i & 0xFFFFDFFF;
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(190012);
    this.platformChannel.setPlatformMessageHandler(null);
    AppMethodBeat.o(190012);
  }
  
  public void updateSystemUiOverlays()
  {
    AppMethodBeat.i(9884);
    this.activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
    if (this.currentTheme != null) {
      setSystemChromeSystemUIOverlayStyle(this.currentTheme);
    }
    AppMethodBeat.o(9884);
  }
  
  void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType paramHapticFeedbackType)
  {
    AppMethodBeat.i(190020);
    View localView = this.activity.getWindow().getDecorView();
    switch (2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[paramHapticFeedbackType.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190020);
      return;
      localView.performHapticFeedback(0);
      AppMethodBeat.o(190020);
      return;
      localView.performHapticFeedback(1);
      AppMethodBeat.o(190020);
      return;
      localView.performHapticFeedback(3);
      AppMethodBeat.o(190020);
      return;
      if (Build.VERSION.SDK_INT >= 23)
      {
        localView.performHapticFeedback(6);
        AppMethodBeat.o(190020);
        return;
        if (Build.VERSION.SDK_INT >= 21) {
          localView.performHapticFeedback(4);
        }
      }
    }
  }
  
  public static abstract interface PlatformPluginDelegate
  {
    public abstract boolean popSystemNavigator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformPlugin
 * JD-Core Version:    0.7.0.1
 */