package com.tencent.mm.recovery.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.RecoveryCrash.Record;
import com.tencent.mm.recoveryv2.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.recovery.wx.R.string;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RecoveryUI
  extends AppCompatActivity
{
  private Button IQq;
  private TextView acjF;
  private TextView acjG;
  private RecoveryCrash.Record acjH;
  private ProgressBar qgC;
  
  private void iQA()
  {
    AppMethodBeat.i(242777);
    this.IQq.setClickable(true);
    this.IQq.setVisibility(0);
    this.qgC.setVisibility(8);
    AppMethodBeat.o(242777);
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(242790);
    if (MMApplicationContext.getResources() == null)
    {
      localResources = super.getResources();
      AppMethodBeat.o(242790);
      return localResources;
    }
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(242790);
    return localResources;
  }
  
  public void onBackPressed() {}
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 417
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 419	androidx/appcompat/app/AppCompatActivity:onCreate	(Landroid/os/Bundle;)V
    //   11: ldc 77
    //   13: ldc_w 421
    //   16: aload_0
    //   17: invokestatic 396	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual 399	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 84	com/tencent/mm/recoveryv2/e:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: iconst_1
    //   28: invokevirtual 424	com/tencent/mm/recovery/ui/RecoveryUI:setRequestedOrientation	(I)V
    //   31: aload_0
    //   32: getstatic 429	com/tencent/recovery/wx/R$layout:activity_recovery	I
    //   35: invokevirtual 432	com/tencent/mm/recovery/ui/RecoveryUI:setContentView	(I)V
    //   38: aload_0
    //   39: aload_0
    //   40: getstatic 437	com/tencent/recovery/wx/R$id:tv_main	I
    //   43: invokevirtual 441	com/tencent/mm/recovery/ui/RecoveryUI:findViewById	(I)Landroid/view/View;
    //   46: checkcast 443	android/widget/TextView
    //   49: putfield 445	com/tencent/mm/recovery/ui/RecoveryUI:acjF	Landroid/widget/TextView;
    //   52: aload_0
    //   53: aload_0
    //   54: getstatic 448	com/tencent/recovery/wx/R$id:tv_tips	I
    //   57: invokevirtual 441	com/tencent/mm/recovery/ui/RecoveryUI:findViewById	(I)Landroid/view/View;
    //   60: checkcast 443	android/widget/TextView
    //   63: putfield 66	com/tencent/mm/recovery/ui/RecoveryUI:acjG	Landroid/widget/TextView;
    //   66: aload_0
    //   67: aload_0
    //   68: getstatic 451	com/tencent/recovery/wx/R$id:btn_main	I
    //   71: invokevirtual 441	com/tencent/mm/recovery/ui/RecoveryUI:findViewById	(I)Landroid/view/View;
    //   74: checkcast 47	android/widget/Button
    //   77: putfield 45	com/tencent/mm/recovery/ui/RecoveryUI:IQq	Landroid/widget/Button;
    //   80: aload_0
    //   81: aload_0
    //   82: getstatic 454	com/tencent/recovery/wx/R$id:progress_main	I
    //   85: invokevirtual 441	com/tencent/mm/recovery/ui/RecoveryUI:findViewById	(I)Landroid/view/View;
    //   88: checkcast 58	android/widget/ProgressBar
    //   91: putfield 56	com/tencent/mm/recovery/ui/RecoveryUI:qgC	Landroid/widget/ProgressBar;
    //   94: aload_0
    //   95: getfield 45	com/tencent/mm/recovery/ui/RecoveryUI:IQq	Landroid/widget/Button;
    //   98: new 6	com/tencent/mm/recovery/ui/RecoveryUI$1
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 456	com/tencent/mm/recovery/ui/RecoveryUI$1:<init>	(Lcom/tencent/mm/recovery/ui/RecoveryUI;)V
    //   106: invokevirtual 460	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   109: aload_0
    //   110: invokevirtual 464	com/tencent/mm/recovery/ui/RecoveryUI:getSupportActionBar	()Landroidx/appcompat/app/ActionBar;
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 469	androidx/appcompat/app/ActionBar:hide	()V
    //   122: aload_0
    //   123: invokespecial 71	com/tencent/mm/recovery/ui/RecoveryUI:iQA	()V
    //   126: aload_0
    //   127: getfield 445	com/tencent/mm/recovery/ui/RecoveryUI:acjF	Landroid/widget/TextView;
    //   130: aload_0
    //   131: invokevirtual 470	com/tencent/mm/recovery/ui/RecoveryUI:getResources	()Landroid/content/res/Resources;
    //   134: getstatic 475	com/tencent/recovery/wx/R$string:recovery_logo	I
    //   137: invokevirtual 481	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   140: invokevirtual 485	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   143: aload_0
    //   144: getfield 66	com/tencent/mm/recovery/ui/RecoveryUI:acjG	Landroid/widget/TextView;
    //   147: aload_0
    //   148: invokevirtual 470	com/tencent/mm/recovery/ui/RecoveryUI:getResources	()Landroid/content/res/Resources;
    //   151: getstatic 488	com/tencent/recovery/wx/R$string:recovery_tips_pre	I
    //   154: invokevirtual 481	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   157: invokevirtual 485	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   160: aload_0
    //   161: getfield 45	com/tencent/mm/recovery/ui/RecoveryUI:IQq	Landroid/widget/Button;
    //   164: aload_0
    //   165: invokevirtual 470	com/tencent/mm/recovery/ui/RecoveryUI:getResources	()Landroid/content/res/Resources;
    //   168: getstatic 491	com/tencent/recovery/wx/R$string:recovery_btn_start	I
    //   171: invokevirtual 481	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   174: invokevirtual 492	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   177: aload_0
    //   178: aload_0
    //   179: invokevirtual 363	com/tencent/mm/recovery/ui/RecoveryUI:getIntent	()Landroid/content/Intent;
    //   182: ldc_w 494
    //   185: invokevirtual 498	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   188: checkcast 212	com/tencent/mm/recoveryv2/RecoveryCrash$Record
    //   191: putfield 194	com/tencent/mm/recovery/ui/RecoveryUI:acjH	Lcom/tencent/mm/recoveryv2/RecoveryCrash$Record;
    //   194: aload_0
    //   195: invokevirtual 88	com/tencent/mm/recovery/ui/RecoveryUI:getApplication	()Landroid/app/Application;
    //   198: invokestatic 94	com/tencent/mm/recoveryv2/i:lV	(Landroid/content/Context;)Lcom/tencent/mm/recoveryv2/i;
    //   201: astore_1
    //   202: aload_1
    //   203: iconst_0
    //   204: putfield 98	com/tencent/mm/recoveryv2/i:acks	Z
    //   207: aload_1
    //   208: iconst_1
    //   209: putfield 501	com/tencent/mm/recoveryv2/i:ackp	Z
    //   212: aload_1
    //   213: invokevirtual 104	com/tencent/mm/recoveryv2/i:sz	()V
    //   216: ldc_w 417
    //   219: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: return
    //   223: astore_1
    //   224: ldc 77
    //   226: ldc_w 503
    //   229: aload_1
    //   230: invokestatic 354	com/tencent/mm/recoveryv2/e:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   233: goto -202 -> 31
    //   236: astore_1
    //   237: ldc 77
    //   239: ldc_w 505
    //   242: aload_1
    //   243: invokestatic 354	com/tencent/mm/recoveryv2/e:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: aload_0
    //   247: getstatic 508	com/tencent/recovery/wx/R$layout:activity_recovery_raw	I
    //   250: invokevirtual 432	com/tencent/mm/recovery/ui/RecoveryUI:setContentView	(I)V
    //   253: goto -215 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	RecoveryUI
    //   0	256	1	paramBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   26	31	223	finally
    //   31	38	236	finally
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(242797);
    super.onDestroy();
    e.i("MicroMsg.recovery.ui", "activity onDestroy, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(242797);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(242794);
    super.onNewIntent(paramIntent);
    e.i("MicroMsg.recovery.ui", "activity onNewIntent, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(242794);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recovery.ui.RecoveryUI
 * JD-Core Version:    0.7.0.1
 */