package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  private View Hl;
  private View.OnClickListener Hm;
  private int e;
  private int fb;
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 22	android/widget/FrameLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 24	com/google/android/gms/common/SignInButton:Hm	Landroid/view/View$OnClickListener;
    //   12: aload_1
    //   13: invokevirtual 30	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   16: aload_2
    //   17: getstatic 36	com/google/android/gms/e:Gm	[I
    //   20: iconst_0
    //   21: iconst_0
    //   22: invokevirtual 42	android/content/res/Resources$Theme:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: getstatic 45	com/google/android/gms/e:Gn	I
    //   31: iconst_0
    //   32: invokevirtual 51	android/content/res/TypedArray:getInt	(II)I
    //   35: putfield 53	com/google/android/gms/common/SignInButton:e	I
    //   38: aload_0
    //   39: aload_1
    //   40: getstatic 56	com/google/android/gms/e:Go	I
    //   43: iconst_2
    //   44: invokevirtual 51	android/content/res/TypedArray:getInt	(II)I
    //   47: putfield 58	com/google/android/gms/common/SignInButton:fb	I
    //   50: aload_1
    //   51: invokevirtual 62	android/content/res/TypedArray:recycle	()V
    //   54: aload_0
    //   55: getfield 53	com/google/android/gms/common/SignInButton:e	I
    //   58: istore_3
    //   59: aload_0
    //   60: getfield 58	com/google/android/gms/common/SignInButton:fb	I
    //   63: istore 4
    //   65: aload_0
    //   66: iload_3
    //   67: putfield 53	com/google/android/gms/common/SignInButton:e	I
    //   70: aload_0
    //   71: iload 4
    //   73: putfield 58	com/google/android/gms/common/SignInButton:fb	I
    //   76: aload_0
    //   77: invokevirtual 66	com/google/android/gms/common/SignInButton:getContext	()Landroid/content/Context;
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 68	com/google/android/gms/common/SignInButton:Hl	Landroid/view/View;
    //   85: ifnull +11 -> 96
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 68	com/google/android/gms/common/SignInButton:Hl	Landroid/view/View;
    //   93: invokevirtual 72	com/google/android/gms/common/SignInButton:removeView	(Landroid/view/View;)V
    //   96: aload_0
    //   97: aload_1
    //   98: aload_0
    //   99: getfield 53	com/google/android/gms/common/SignInButton:e	I
    //   102: aload_0
    //   103: getfield 58	com/google/android/gms/common/SignInButton:fb	I
    //   106: invokestatic 78	com/google/android/gms/common/internal/h:b	(Landroid/content/Context;II)Landroid/view/View;
    //   109: putfield 68	com/google/android/gms/common/SignInButton:Hl	Landroid/view/View;
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 68	com/google/android/gms/common/SignInButton:Hl	Landroid/view/View;
    //   117: invokevirtual 81	com/google/android/gms/common/SignInButton:addView	(Landroid/view/View;)V
    //   120: aload_0
    //   121: getfield 68	com/google/android/gms/common/SignInButton:Hl	Landroid/view/View;
    //   124: aload_0
    //   125: invokevirtual 85	com/google/android/gms/common/SignInButton:isEnabled	()Z
    //   128: invokevirtual 91	android/view/View:setEnabled	(Z)V
    //   131: aload_0
    //   132: getfield 68	com/google/android/gms/common/SignInButton:Hl	Landroid/view/View;
    //   135: aload_0
    //   136: invokevirtual 95	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   139: return
    //   140: astore_2
    //   141: aload_1
    //   142: invokevirtual 62	android/content/res/TypedArray:recycle	()V
    //   145: aload_2
    //   146: athrow
    //   147: astore_2
    //   148: ldc 97
    //   150: ldc 99
    //   152: invokestatic 105	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   155: pop
    //   156: aload_0
    //   157: getfield 53	com/google/android/gms/common/SignInButton:e	I
    //   160: istore_3
    //   161: aload_0
    //   162: getfield 58	com/google/android/gms/common/SignInButton:fb	I
    //   165: istore 4
    //   167: new 107	com/google/android/gms/common/internal/zzak
    //   170: dup
    //   171: aload_1
    //   172: invokespecial 110	com/google/android/gms/common/internal/zzak:<init>	(Landroid/content/Context;)V
    //   175: astore_2
    //   176: aload_2
    //   177: aload_1
    //   178: invokevirtual 114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   181: iload_3
    //   182: iload 4
    //   184: invokevirtual 118	com/google/android/gms/common/internal/zzak:a	(Landroid/content/res/Resources;II)V
    //   187: aload_0
    //   188: aload_2
    //   189: putfield 68	com/google/android/gms/common/SignInButton:Hl	Landroid/view/View;
    //   192: goto -80 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	SignInButton
    //   0	195	1	paramContext	Context
    //   0	195	2	paramAttributeSet	AttributeSet
    //   0	195	3	paramInt	int
    //   63	120	4	i	int
    // Exception table:
    //   from	to	target	type
    //   26	50	140	finally
    //   96	112	147	com/google/android/gms/a/f
  }
  
  public final void onClick(View paramView)
  {
    if ((this.Hm != null) && (paramView == this.Hl)) {
      this.Hm.onClick(this);
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.Hl.setEnabled(paramBoolean);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Hm = paramOnClickListener;
    if (this.Hl != null) {
      this.Hl.setOnClickListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.SignInButton
 * JD-Core Version:    0.7.0.1
 */