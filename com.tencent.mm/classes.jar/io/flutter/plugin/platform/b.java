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
import androidx.activity.OnBackPressedDispatcherOwner;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.h;
import io.flutter.embedding.engine.b.h.a;
import io.flutter.embedding.engine.b.h.b;
import io.flutter.embedding.engine.b.h.c;
import io.flutter.embedding.engine.b.h.e;
import io.flutter.embedding.engine.b.h.f;
import io.flutter.embedding.engine.b.h.g;
import io.flutter.embedding.engine.b.h.h;
import io.flutter.embedding.engine.b.h.i;
import java.io.FileNotFoundException;
import java.util.List;

public final class b
{
  private final h aaqd;
  private final a aavN;
  private h.h aavO;
  int aavP;
  final h.f aavQ;
  final Activity activity;
  
  public b(Activity paramActivity, h paramh)
  {
    this(paramActivity, paramh, null);
    AppMethodBeat.i(9883);
    AppMethodBeat.o(9883);
  }
  
  public b(Activity paramActivity, h paramh, a parama)
  {
    AppMethodBeat.i(253388);
    this.aavQ = new h.f()
    {
      public final CharSequence a(h.c paramAnonymousc)
      {
        AppMethodBeat.i(9913);
        paramAnonymousc = b.this.a(paramAnonymousc);
        AppMethodBeat.o(9913);
        return paramAnonymousc;
      }
      
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(9908);
        b localb = b.this;
        if (Build.VERSION.SDK_INT >= 21)
        {
          if ((Build.VERSION.SDK_INT < 28) && (Build.VERSION.SDK_INT > 21)) {
            localb.activity.setTaskDescription(new ActivityManager.TaskDescription(paramAnonymousa.label, null, paramAnonymousa.color));
          }
          if (Build.VERSION.SDK_INT >= 28)
          {
            paramAnonymousa = new ActivityManager.TaskDescription(paramAnonymousa.label, 0, paramAnonymousa.color);
            localb.activity.setTaskDescription(paramAnonymousa);
          }
        }
        AppMethodBeat.o(9908);
      }
      
      public final void a(h.e paramAnonymouse)
      {
        AppMethodBeat.i(9906);
        View localView = b.this.activity.getWindow().getDecorView();
        switch (b.2.aavS[paramAnonymouse.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(9906);
          return;
          localView.performHapticFeedback(0);
          AppMethodBeat.o(9906);
          return;
          localView.performHapticFeedback(1);
          AppMethodBeat.o(9906);
          return;
          localView.performHapticFeedback(3);
          AppMethodBeat.o(9906);
          return;
          if (Build.VERSION.SDK_INT >= 23)
          {
            localView.performHapticFeedback(6);
            AppMethodBeat.o(9906);
            return;
            if (Build.VERSION.SDK_INT >= 21) {
              localView.performHapticFeedback(4);
            }
          }
        }
      }
      
      public final void a(h.g paramAnonymousg)
      {
        AppMethodBeat.i(9905);
        b localb = b.this;
        if (paramAnonymousg == h.g.aasV) {
          localb.activity.getWindow().getDecorView().playSoundEffect(0);
        }
        AppMethodBeat.o(9905);
      }
      
      public final void a(h.h paramAnonymoush)
      {
        AppMethodBeat.i(9911);
        b.this.b(paramAnonymoush);
        AppMethodBeat.o(9911);
      }
      
      public final void aDn(int paramAnonymousInt)
      {
        AppMethodBeat.i(9907);
        b.this.activity.setRequestedOrientation(paramAnonymousInt);
        AppMethodBeat.o(9907);
      }
      
      public final void bGo(String paramAnonymousString)
      {
        AppMethodBeat.i(9914);
        ((ClipboardManager)b.this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", paramAnonymousString));
        AppMethodBeat.o(9914);
      }
      
      public final void iBh()
      {
        AppMethodBeat.i(9910);
        b.this.iBs();
        AppMethodBeat.o(9910);
      }
      
      public final void iBi()
      {
        AppMethodBeat.i(9912);
        b localb = b.this;
        if ((localb.activity instanceof OnBackPressedDispatcherOwner)) {
          try
          {
            ((OnBackPressedDispatcherOwner)localb.activity).getOnBackPressedDispatcher().onBackPressed();
            AppMethodBeat.o(9912);
            return;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(9912);
            return;
          }
        }
        localException.activity.finish();
        AppMethodBeat.o(9912);
      }
      
      public final boolean iBj()
      {
        AppMethodBeat.i(255460);
        CharSequence localCharSequence = b.this.a(h.c.aasI);
        if ((localCharSequence != null) && (localCharSequence.length() > 0))
        {
          AppMethodBeat.o(255460);
          return true;
        }
        AppMethodBeat.o(255460);
        return false;
      }
      
      public final void lh(List<h.i> paramAnonymousList)
      {
        AppMethodBeat.i(9909);
        b localb = b.this;
        int j = 1798;
        int i = j;
        if (paramAnonymousList.size() == 0)
        {
          i = j;
          if (Build.VERSION.SDK_INT >= 19) {
            i = 5894;
          }
        }
        j = 0;
        if (j < paramAnonymousList.size())
        {
          h.i locali = (h.i)paramAnonymousList.get(j);
          switch (b.2.aasD[locali.ordinal()])
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
        localb.aavP = i;
        localb.iBs();
        AppMethodBeat.o(9909);
      }
    };
    this.activity = paramActivity;
    this.aaqd = paramh;
    this.aaqd.aasA = this.aavQ;
    this.aavN = parama;
    this.aavP = 1280;
    AppMethodBeat.o(253388);
  }
  
  final CharSequence a(h.c paramc)
  {
    AppMethodBeat.i(253397);
    Object localObject = (ClipboardManager)this.activity.getSystemService("clipboard");
    if (!((ClipboardManager)localObject).hasPrimaryClip())
    {
      AppMethodBeat.o(253397);
      return null;
    }
    try
    {
      localObject = ((ClipboardManager)localObject).getPrimaryClip();
      if (localObject == null)
      {
        AppMethodBeat.o(253397);
        return null;
      }
      if ((paramc == null) || (paramc == h.c.aasI))
      {
        paramc = ((ClipData)localObject).getItemAt(0);
        if (paramc.getUri() != null) {
          this.activity.getContentResolver().openTypedAssetFileDescriptor(paramc.getUri(), "text/*", null);
        }
        paramc = paramc.coerceToText(this.activity);
        AppMethodBeat.o(253397);
        return paramc;
      }
    }
    catch (SecurityException paramc)
    {
      io.flutter.b.iAg();
      AppMethodBeat.o(253397);
      return null;
    }
    catch (FileNotFoundException paramc)
    {
      AppMethodBeat.o(253397);
      return null;
    }
    AppMethodBeat.o(253397);
    return null;
  }
  
  final void b(h.h paramh)
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
      if (paramh.aatb == null) {}
    }
    switch (2.aavT[paramh.aatb.ordinal()])
    {
    default: 
      j = k;
      i = j;
      if (paramh.aata != null)
      {
        localWindow.setNavigationBarColor(paramh.aata.intValue());
        i = j;
      }
      k = i;
      if (Build.VERSION.SDK_INT >= 23)
      {
        j = i;
        if (paramh.aasZ != null) {
          switch (2.aavT[paramh.aasZ.ordinal()])
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
      if (paramh.aasY != null)
      {
        localWindow.setStatusBarColor(paramh.aasY.intValue());
        k = j;
      }
      if ((paramh.aatc != null) && (Build.VERSION.SDK_INT >= 28))
      {
        localWindow.addFlags(-2147483648);
        localWindow.clearFlags(134217728);
        localWindow.setNavigationBarDividerColor(paramh.aatc.intValue());
      }
      localView.setSystemUiVisibility(k);
      this.aavO = paramh;
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
  
  public final void destroy()
  {
    this.aaqd.aasA = null;
  }
  
  public final void iBs()
  {
    AppMethodBeat.i(9884);
    this.activity.getWindow().getDecorView().setSystemUiVisibility(this.aavP);
    if (this.aavO != null) {
      b(this.aavO);
    }
    AppMethodBeat.o(9884);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.platform.b
 * JD-Core Version:    0.7.0.1
 */