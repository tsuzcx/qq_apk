package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.f;
import io.flutter.embedding.engine.c.f.a;
import io.flutter.embedding.engine.c.f.b;
import io.flutter.embedding.engine.c.f.c;
import io.flutter.embedding.engine.c.f.e;
import io.flutter.embedding.engine.c.f.f;
import io.flutter.embedding.engine.c.f.g;
import io.flutter.embedding.engine.c.f.h;
import io.flutter.embedding.engine.c.f.i;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private final f MZs;
  private f.h NdB;
  int NdC;
  private final f.f NdD;
  final Activity activity;
  
  public b(Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(9883);
    this.NdD = new f.f()
    {
      public final CharSequence a(f.c paramAnonymousc)
      {
        AppMethodBeat.i(9913);
        b localb = b.this;
        ClipData localClipData = ((ClipboardManager)localb.activity.getSystemService("clipboard")).getPrimaryClip();
        if ((localClipData != null) && ((paramAnonymousc == null) || (paramAnonymousc == f.c.Nbs)))
        {
          paramAnonymousc = localClipData.getItemAt(0).coerceToText(localb.activity);
          AppMethodBeat.o(9913);
          return paramAnonymousc;
        }
        AppMethodBeat.o(9913);
        return null;
      }
      
      public final void a(f.a paramAnonymousa)
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
      
      public final void a(f.e paramAnonymouse)
      {
        AppMethodBeat.i(9906);
        View localView = b.this.activity.getWindow().getDecorView();
        switch (b.2.NdF[paramAnonymouse.ordinal()])
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
      
      public final void a(f.g paramAnonymousg)
      {
        AppMethodBeat.i(9905);
        b localb = b.this;
        if (paramAnonymousg == f.g.NbF) {
          localb.activity.getWindow().getDecorView().playSoundEffect(0);
        }
        AppMethodBeat.o(9905);
      }
      
      public final void a(f.h paramAnonymoush)
      {
        AppMethodBeat.i(9911);
        b.this.b(paramAnonymoush);
        AppMethodBeat.o(9911);
      }
      
      public final void ajJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(9907);
        b.this.activity.setRequestedOrientation(paramAnonymousInt);
        AppMethodBeat.o(9907);
      }
      
      public final void bc(ArrayList<Rect> paramAnonymousArrayList)
      {
        AppMethodBeat.i(197797);
        b localb = b.this;
        if (Build.VERSION.SDK_INT >= 29) {
          localb.activity.getWindow().getDecorView().setSystemGestureExclusionRects(paramAnonymousArrayList);
        }
        AppMethodBeat.o(197797);
      }
      
      public final void bdx(String paramAnonymousString)
      {
        AppMethodBeat.i(9914);
        ((ClipboardManager)b.this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", paramAnonymousString));
        AppMethodBeat.o(9914);
      }
      
      public final void gjE()
      {
        AppMethodBeat.i(9910);
        b.this.gjL();
        AppMethodBeat.o(9910);
      }
      
      public final void gjF()
      {
        AppMethodBeat.i(9912);
        b.this.activity.finish();
        AppMethodBeat.o(9912);
      }
      
      public final List<Rect> gjG()
      {
        AppMethodBeat.i(197796);
        Object localObject = b.this;
        if (Build.VERSION.SDK_INT >= 29)
        {
          localObject = ((b)localObject).activity.getWindow().getDecorView().getSystemGestureExclusionRects();
          AppMethodBeat.o(197796);
          return localObject;
        }
        AppMethodBeat.o(197796);
        return null;
      }
      
      public final void jh(List<f.i> paramAnonymousList)
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
          f.i locali = (f.i)paramAnonymousList.get(j);
          switch (b.2.Nbn[locali.ordinal()])
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
        localb.NdC = i;
        localb.gjL();
        AppMethodBeat.o(9909);
      }
    };
    this.activity = paramActivity;
    this.MZs = paramf;
    this.MZs.Nbj = this.NdD;
    this.NdC = 1280;
    AppMethodBeat.o(9883);
  }
  
  final void b(f.h paramh)
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
      if (paramh.NbK == null) {}
    }
    switch (2.NdG[paramh.NbK.ordinal()])
    {
    default: 
      j = k;
      i = j;
      if (paramh.NbJ != null)
      {
        localWindow.setNavigationBarColor(paramh.NbJ.intValue());
        i = j;
      }
      k = i;
      if (Build.VERSION.SDK_INT >= 23)
      {
        j = i;
        if (paramh.NbI != null) {
          switch (2.NdG[paramh.NbI.ordinal()])
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
      if (paramh.NbH != null)
      {
        localWindow.setStatusBarColor(paramh.NbH.intValue());
        k = j;
      }
      localView.setSystemUiVisibility(k);
      this.NdB = paramh;
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
    this.MZs.Nbj = null;
  }
  
  public final void gjL()
  {
    AppMethodBeat.i(9884);
    this.activity.getWindow().getDecorView().setSystemUiVisibility(this.NdC);
    if (this.NdB != null) {
      b(this.NdB);
    }
    AppMethodBeat.o(9884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.platform.b
 * JD-Core Version:    0.7.0.1
 */