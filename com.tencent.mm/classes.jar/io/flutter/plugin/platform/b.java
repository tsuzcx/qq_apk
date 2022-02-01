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
  private final f KLq;
  private f.h KPx;
  int KPy;
  private final f.f KPz;
  final Activity activity;
  
  public b(Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(9883);
    this.KPz = new f.f()
    {
      public final CharSequence a(f.c paramAnonymousc)
      {
        AppMethodBeat.i(9913);
        b localb = b.this;
        ClipData localClipData = ((ClipboardManager)localb.activity.getSystemService("clipboard")).getPrimaryClip();
        if ((localClipData != null) && ((paramAnonymousc == null) || (paramAnonymousc == f.c.KNp)))
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
        switch (b.2.KPB[paramAnonymouse.ordinal()])
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
          localView.performHapticFeedback(6);
          AppMethodBeat.o(9906);
          return;
          localView.performHapticFeedback(4);
        }
      }
      
      public final void a(f.g paramAnonymousg)
      {
        AppMethodBeat.i(9905);
        b localb = b.this;
        if (paramAnonymousg == f.g.KNC) {
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
      
      public final void aVQ(String paramAnonymousString)
      {
        AppMethodBeat.i(9914);
        ((ClipboardManager)b.this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", paramAnonymousString));
        AppMethodBeat.o(9914);
      }
      
      public final void agy(int paramAnonymousInt)
      {
        AppMethodBeat.i(9907);
        b.this.activity.setRequestedOrientation(paramAnonymousInt);
        AppMethodBeat.o(9907);
      }
      
      public final void be(ArrayList<Rect> paramAnonymousArrayList)
      {
        AppMethodBeat.i(192771);
        b localb = b.this;
        if (Build.VERSION.SDK_INT >= 29) {
          localb.activity.getWindow().getDecorView().setSystemGestureExclusionRects(paramAnonymousArrayList);
        }
        AppMethodBeat.o(192771);
      }
      
      public final void fND()
      {
        AppMethodBeat.i(9910);
        b.this.fNK();
        AppMethodBeat.o(9910);
      }
      
      public final void fNE()
      {
        AppMethodBeat.i(9912);
        b.this.activity.finish();
        AppMethodBeat.o(9912);
      }
      
      public final List<Rect> fNF()
      {
        AppMethodBeat.i(192770);
        Object localObject = b.this;
        if (Build.VERSION.SDK_INT >= 29)
        {
          localObject = ((b)localObject).activity.getWindow().getDecorView().getSystemGestureExclusionRects();
          AppMethodBeat.o(192770);
          return localObject;
        }
        AppMethodBeat.o(192770);
        return null;
      }
      
      public final void iK(List<f.i> paramAnonymousList)
      {
        AppMethodBeat.i(9909);
        b localb = b.this;
        int i = 1798;
        if (paramAnonymousList.size() == 0) {
          i = 5894;
        }
        int j = 0;
        if (j < paramAnonymousList.size())
        {
          f.i locali = (f.i)paramAnonymousList.get(j);
          switch (b.2.KNk[locali.ordinal()])
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
        localb.KPy = i;
        localb.fNK();
        AppMethodBeat.o(9909);
      }
    };
    this.activity = paramActivity;
    this.KLq = paramf;
    this.KLq.KNg = this.KPz;
    this.KPy = 1280;
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
      if (paramh.KNH == null) {}
    }
    switch (2.KPC[paramh.KNH.ordinal()])
    {
    default: 
      j = k;
      i = j;
      if (paramh.KNG != null)
      {
        localWindow.setNavigationBarColor(paramh.KNG.intValue());
        i = j;
      }
      k = i;
      if (Build.VERSION.SDK_INT >= 23)
      {
        j = i;
        if (paramh.KNF != null) {
          switch (2.KPC[paramh.KNF.ordinal()])
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
      if (paramh.KNE != null)
      {
        localWindow.setStatusBarColor(paramh.KNE.intValue());
        k = j;
      }
      localView.setSystemUiVisibility(k);
      this.KPx = paramh;
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
    this.KLq.KNg = null;
  }
  
  public final void fNK()
  {
    AppMethodBeat.i(9884);
    this.activity.getWindow().getDecorView().setSystemUiVisibility(this.KPy);
    if (this.KPx != null) {
      b(this.KPx);
    }
    AppMethodBeat.o(9884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.b
 * JD-Core Version:    0.7.0.1
 */