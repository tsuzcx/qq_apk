package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.g;
import io.flutter.embedding.engine.c.g.a;
import io.flutter.embedding.engine.c.g.b;
import io.flutter.embedding.engine.c.g.c;
import io.flutter.embedding.engine.c.g.e;
import io.flutter.embedding.engine.c.g.f;
import io.flutter.embedding.engine.c.g.g;
import io.flutter.embedding.engine.c.g.h;
import io.flutter.embedding.engine.c.g.i;
import java.util.List;

public final class b
{
  private final g SOe;
  private g.h STb;
  int STc;
  private final g.f STd;
  final Activity activity;
  
  public b(Activity paramActivity, g paramg)
  {
    AppMethodBeat.i(9883);
    this.STd = new g.f()
    {
      public final CharSequence a(g.c paramAnonymousc)
      {
        AppMethodBeat.i(9913);
        b localb = b.this;
        ClipData localClipData = ((ClipboardManager)localb.activity.getSystemService("clipboard")).getPrimaryClip();
        if ((localClipData != null) && ((paramAnonymousc == null) || (paramAnonymousc == g.c.SQn)))
        {
          paramAnonymousc = localClipData.getItemAt(0).coerceToText(localb.activity);
          AppMethodBeat.o(9913);
          return paramAnonymousc;
        }
        AppMethodBeat.o(9913);
        return null;
      }
      
      public final void a(g.a paramAnonymousa)
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
      
      public final void a(g.e paramAnonymouse)
      {
        AppMethodBeat.i(9906);
        View localView = b.this.activity.getWindow().getDecorView();
        switch (b.2.STf[paramAnonymouse.ordinal()])
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
      
      public final void a(g.g paramAnonymousg)
      {
        AppMethodBeat.i(9905);
        b localb = b.this;
        if (paramAnonymousg == g.g.SQA) {
          localb.activity.getWindow().getDecorView().playSoundEffect(0);
        }
        AppMethodBeat.o(9905);
      }
      
      public final void a(g.h paramAnonymoush)
      {
        AppMethodBeat.i(9911);
        b.this.b(paramAnonymoush);
        AppMethodBeat.o(9911);
      }
      
      public final void ats(int paramAnonymousInt)
      {
        AppMethodBeat.i(9907);
        b.this.activity.setRequestedOrientation(paramAnonymousInt);
        AppMethodBeat.o(9907);
      }
      
      public final void btl(String paramAnonymousString)
      {
        AppMethodBeat.i(9914);
        ((ClipboardManager)b.this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", paramAnonymousString));
        AppMethodBeat.o(9914);
      }
      
      public final void hxg()
      {
        AppMethodBeat.i(9910);
        b.this.hxp();
        AppMethodBeat.o(9910);
      }
      
      public final void hxh()
      {
        AppMethodBeat.i(9912);
        b.this.activity.finish();
        AppMethodBeat.o(9912);
      }
      
      public final void kn(List<g.i> paramAnonymousList)
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
          g.i locali = (g.i)paramAnonymousList.get(j);
          switch (b.2.SQi[locali.ordinal()])
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
        localb.STc = i;
        localb.hxp();
        AppMethodBeat.o(9909);
      }
    };
    this.activity = paramActivity;
    this.SOe = paramg;
    this.SOe.SQf = this.STd;
    this.STc = 1280;
    AppMethodBeat.o(9883);
  }
  
  final void b(g.h paramh)
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
      if (paramh.SQF == null) {}
    }
    switch (2.STg[paramh.SQF.ordinal()])
    {
    default: 
      j = k;
      i = j;
      if (paramh.SQE != null)
      {
        localWindow.setNavigationBarColor(paramh.SQE.intValue());
        i = j;
      }
      k = i;
      if (Build.VERSION.SDK_INT >= 23)
      {
        j = i;
        if (paramh.SQD != null) {
          switch (2.STg[paramh.SQD.ordinal()])
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
      if (paramh.SQC != null)
      {
        localWindow.setStatusBarColor(paramh.SQC.intValue());
        k = j;
      }
      localView.setSystemUiVisibility(k);
      this.STb = paramh;
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
    this.SOe.SQf = null;
  }
  
  public final void hxp()
  {
    AppMethodBeat.i(9884);
    this.activity.getWindow().getDecorView().setSystemUiVisibility(this.STc);
    if (this.STb != null) {
      b(this.STb);
    }
    AppMethodBeat.o(9884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.plugin.platform.b
 * JD-Core Version:    0.7.0.1
 */