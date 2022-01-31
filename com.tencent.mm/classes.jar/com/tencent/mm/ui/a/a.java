package com.tencent.mm.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.mm.ac.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public final class a
{
  private AccessibilityManager eV;
  Vibrator ibr;
  TextToSpeech uRu = null;
  public Context ze;
  
  public a(Context paramContext)
  {
    this.ze = paramContext;
    this.eV = ((AccessibilityManager)this.ze.getSystemService("accessibility"));
  }
  
  public final void S(View paramView, int paramInt)
  {
    if (!cAi()) {}
    while ((this.ze == null) || (paramView == null)) {
      return;
    }
    paramInt = Math.max(paramInt, 1);
    b localb = new b();
    localb.acY(this.ze.getResources().getQuantityString(a.i.chatting_voice_item_desc, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    localb.dB(paramView);
  }
  
  public final void a(View paramView, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (!cAi()) {}
    while ((this.ze == null) || (paramView == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    b localb = new b();
    localb.acY(paramString1);
    if (paramInt > 0) {
      localb.acY(this.ze.getResources().getQuantityString(a.i.conversation_item_desc_unread, 1, new Object[] { Integer.valueOf(paramInt) }));
    }
    localb.acY(paramString2).acY(paramString3);
    localb.dB(paramView);
  }
  
  public final boolean cAi()
  {
    boolean bool1 = this.eV.isEnabled();
    boolean bool2 = this.eV.isTouchExplorationEnabled();
    return (bool1) && (bool2);
  }
  
  private static final class a
  {
    private static final a uRw = new a(ae.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.a.a
 * JD-Core Version:    0.7.0.1
 */