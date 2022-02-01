package com.tencent.mm.plugin.sns.ad.widget.shakead;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.ad.adxml.d.a;
import com.tencent.mm.plugin.sns.ad.adxml.d.a.a;
import com.tencent.mm.plugin.sns.ad.d.t.a;
import com.tencent.mm.plugin.sns.ad.widget.gllib.GLViewContainer;
import com.tencent.mm.plugin.sns.ad.widget.gllib.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;

public class GLCardAnimView
  extends GLViewContainer
{
  private int Qic;
  private int Qid;
  private int Qie;
  private View Qif;
  private ArrayList<com.tencent.mm.plugin.sns.ad.widget.gllib.b> Qih;
  public boolean Qii;
  private ShakeCardAnimView.a Qij;
  private com.tencent.mm.plugin.sns.ad.widget.gllib.b Qim;
  private final String TAG;
  private Context mContext;
  
  public GLCardAnimView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(310527);
    this.TAG = "GLCardAnimView";
    this.Qih = new ArrayList();
    this.Qii = false;
    init(paramContext);
    AppMethodBeat.o(310527);
  }
  
  public GLCardAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310536);
    this.TAG = "GLCardAnimView";
    this.Qih = new ArrayList();
    this.Qii = false;
    init(paramContext);
    AppMethodBeat.o(310536);
  }
  
  private void b(final com.tencent.mm.plugin.sns.ad.widget.gllib.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310582);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramb, "translationY", new float[] { -(getHeight() / 2 + this.Qid / 2 + this.Qie), 0.0F });
    localObjectAnimator1.setDuration(500L);
    localObjectAnimator1.addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(310624);
        paramb.setVisibility(0);
        AppMethodBeat.o(310624);
      }
    });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramb, "scaleX", new float[] { 0.3333333F, 1.0F });
    localObjectAnimator2.setDuration(500L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramb, "scaleY", new float[] { 0.3333333F, 1.0F });
    localObjectAnimator3.setDuration(500L);
    paramb = ObjectAnimator.ofFloat(paramb, "translationX", new float[] { 0.0F, paramInt2 });
    paramb.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
    localAnimatorSet.play(paramb).after(localObjectAnimator1);
    localAnimatorSet.setStartDelay(paramInt1);
    localAnimatorSet.start();
    AppMethodBeat.o(310582);
  }
  
  private static ArrayList<d.a.a> bA(ArrayList<d.a.a> paramArrayList)
  {
    AppMethodBeat.i(310568);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add((d.a.a)paramArrayList.get(3));
      localArrayList.add((d.a.a)paramArrayList.get(1));
      localArrayList.add((d.a.a)paramArrayList.get(0));
      localArrayList.add((d.a.a)paramArrayList.get(2));
      localArrayList.add((d.a.a)paramArrayList.get(4));
      label78:
      AppMethodBeat.o(310568);
      return localArrayList;
    }
    catch (Exception paramArrayList)
    {
      break label78;
    }
  }
  
  /* Error */
  private void bz(ArrayList<d.a.a> paramArrayList)
  {
    // Byte code:
    //   0: ldc 159
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 161	com/tencent/mm/plugin/sns/ad/widget/shakead/GLCardAnimView:mContext	Landroid/content/Context;
    //   9: ldc 162
    //   11: invokestatic 168	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;F)I
    //   14: istore 4
    //   16: iconst_0
    //   17: istore_3
    //   18: iload_3
    //   19: iconst_5
    //   20: if_icmpge +201 -> 221
    //   23: aload_0
    //   24: getfield 55	com/tencent/mm/plugin/sns/ad/widget/shakead/GLCardAnimView:Qih	Ljava/util/ArrayList;
    //   27: iload_3
    //   28: invokevirtual 148	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   31: checkcast 170	com/tencent/mm/plugin/sns/ad/widget/gllib/b
    //   34: astore 6
    //   36: aload_1
    //   37: iload_3
    //   38: invokevirtual 148	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   41: checkcast 150	com/tencent/mm/plugin/sns/ad/adxml/d$a$a
    //   44: astore 7
    //   46: aload 7
    //   48: getfield 173	com/tencent/mm/plugin/sns/ad/adxml/d$a$a:nRQ	Ljava/lang/String;
    //   51: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifne +33 -> 87
    //   57: aload 7
    //   59: getfield 173	com/tencent/mm/plugin/sns/ad/adxml/d$a$a:nRQ	Ljava/lang/String;
    //   62: invokestatic 185	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   65: istore 5
    //   67: aload 6
    //   69: aload_0
    //   70: getfield 187	com/tencent/mm/plugin/sns/ad/widget/shakead/GLCardAnimView:Qic	I
    //   73: aload_0
    //   74: getfield 86	com/tencent/mm/plugin/sns/ad/widget/shakead/GLCardAnimView:Qid	I
    //   77: iload 5
    //   79: iload 4
    //   81: invokestatic 193	com/tencent/mm/plugin/sns/ad/widget/gllib/e:X	(IIII)Landroid/graphics/Bitmap;
    //   84: invokevirtual 197	com/tencent/mm/plugin/sns/ad/widget/gllib/b:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   87: aload 7
    //   89: getfield 200	com/tencent/mm/plugin/sns/ad/adxml/d$a$a:ADt	Ljava/lang/String;
    //   92: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne +76 -> 171
    //   98: aload 7
    //   100: getfield 200	com/tencent/mm/plugin/sns/ad/adxml/d$a$a:ADt	Ljava/lang/String;
    //   103: astore 7
    //   105: iload 4
    //   107: i2f
    //   108: fstore_2
    //   109: aload 7
    //   111: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +57 -> 171
    //   117: ldc 202
    //   119: new 204	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 206
    //   125: invokespecial 209	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload 6
    //   130: invokevirtual 214	java/lang/Object:hashCode	()I
    //   133: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 220
    //   138: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 7
    //   143: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: ldc 235
    //   154: aload 7
    //   156: new 237	com/tencent/mm/plugin/sns/ad/j/c$5
    //   159: dup
    //   160: aload 6
    //   162: aload 7
    //   164: fload_2
    //   165: invokespecial 240	com/tencent/mm/plugin/sns/ad/j/c$5:<init>	(Lcom/tencent/mm/plugin/sns/ad/widget/gllib/b;Ljava/lang/String;F)V
    //   168: invokestatic 245	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/k:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g$a;)V
    //   171: iload_3
    //   172: iconst_1
    //   173: iadd
    //   174: istore_3
    //   175: goto -157 -> 18
    //   178: astore 8
    //   180: ldc 46
    //   182: new 204	java/lang/StringBuilder
    //   185: dup
    //   186: ldc 247
    //   188: invokespecial 209	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload 8
    //   193: invokevirtual 250	java/lang/Throwable:toString	()Ljava/lang/String;
    //   196: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 252
    //   201: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 7
    //   206: getfield 173	com/tencent/mm/plugin/sns/ad/adxml/d$a$a:nRQ	Ljava/lang/String;
    //   209: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: goto -131 -> 87
    //   221: ldc 159
    //   223: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	GLCardAnimView
    //   0	227	1	paramArrayList	ArrayList<d.a.a>
    //   108	57	2	f	float
    //   17	158	3	i	int
    //   14	92	4	j	int
    //   65	13	5	k	int
    //   34	127	6	localb	com.tencent.mm.plugin.sns.ad.widget.gllib.b
    //   44	161	7	localObject1	Object
    //   178	14	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   57	87	178	finally
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(310546);
    this.mContext = paramContext;
    this.Qic = a.fromDPToPix(this.mContext, 96);
    this.Qid = a.fromDPToPix(this.mContext, 162);
    this.Qie = a.fromDPToPix(this.mContext, 72);
    jN(this.mContext);
    AppMethodBeat.o(310546);
  }
  
  private void jN(Context paramContext)
  {
    AppMethodBeat.i(310552);
    int i = 0;
    while (i < 5)
    {
      com.tencent.mm.plugin.sns.ad.widget.gllib.b localb = new com.tencent.mm.plugin.sns.ad.widget.gllib.b(paramContext);
      localb.setScaleType(1);
      localb.a(new b.a(this.Qic, this.Qid));
      a(localb);
      this.Qih.add(localb);
      i += 1;
    }
    setCardVisibility(4);
    AppMethodBeat.o(310552);
  }
  
  private void setCardVisibility(int paramInt)
  {
    AppMethodBeat.i(310576);
    int i = 0;
    while (i < this.Qih.size())
    {
      ((com.tencent.mm.plugin.sns.ad.widget.gllib.b)this.Qih.get(i)).setVisibility(paramInt);
      i += 1;
    }
    AppMethodBeat.o(310576);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(310617);
    if (parama == null)
    {
      Log.e("GLCardAnimView", "initData, ShakeCardInfo==null");
      AppMethodBeat.o(310617);
      return;
    }
    if ((parama.PMp == null) || (parama.PMp.size() != 5))
    {
      StringBuilder localStringBuilder = new StringBuilder("initData, cardItem.size=");
      if (parama.PMp == null) {}
      for (int i = 0;; i = parama.PMp.size())
      {
        Log.e("GLCardAnimView", i);
        AppMethodBeat.o(310617);
        return;
      }
    }
    bz(bA(parama.PMp));
    AppMethodBeat.o(310617);
  }
  
  public final void eow()
  {
    AppMethodBeat.i(310638);
    int i = 0;
    while (i < this.Qih.size())
    {
      com.tencent.mm.plugin.sns.ad.widget.gllib.b localb = (com.tencent.mm.plugin.sns.ad.widget.gllib.b)this.Qih.get(i);
      localb.setAlpha(1.0F);
      localb.ccT = (-0.0F);
      localb.invalidate();
      localb.ceY = 0.0F;
      localb.invalidate();
      localb.ceS = 0.0F;
      localb.invalidate();
      localb.ceT = 0.0F;
      localb.invalidate();
      localb.ceV = 1.0F;
      localb.invalidate();
      localb.ceW = 1.0F;
      localb.invalidate();
      i += 1;
    }
    AppMethodBeat.o(310638);
  }
  
  public final void hds()
  {
    AppMethodBeat.i(310642);
    this.Qii = true;
    int i = a.fromDPToPix(this.mContext, 140);
    Object localObject1 = (com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(0);
    Object localObject2 = (com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(4);
    b((com.tencent.mm.plugin.sns.ad.widget.gllib.b)localObject1, 0, -i);
    b((com.tencent.mm.plugin.sns.ad.widget.gllib.b)localObject2, 0, i);
    Object localObject3 = (com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(2);
    this.Qim = ((com.tencent.mm.plugin.sns.ad.widget.gllib.b)localObject3);
    this.Qim.setAlpha(1.0F);
    localObject1 = ObjectAnimator.ofFloat(localObject3, "translationY", new float[] { -(getHeight() / 2 + this.Qid / 2 + this.Qie), 0.0F });
    ((ObjectAnimator)localObject1).setDuration(500L);
    ((ObjectAnimator)localObject1).addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(310620);
        this.Qin.setVisibility(0);
        AppMethodBeat.o(310620);
      }
    });
    localObject2 = ObjectAnimator.ofFloat(localObject3, "scaleX", new float[] { 0.3333333F, 1.0F });
    ((ObjectAnimator)localObject2).setDuration(500L);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject3, "scaleY", new float[] { 0.3333333F, 1.0F });
    localObjectAnimator1.setDuration(500L);
    ((ObjectAnimator)localObject1).addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(310616);
        if (GLCardAnimView.a(GLCardAnimView.this) != null)
        {
          Log.i("GLCardAnimView", "onPrepareCard");
          GLCardAnimView.a(GLCardAnimView.this).haV();
        }
        if (GLCardAnimView.b(GLCardAnimView.this) == null)
        {
          Log.e("GLCardAnimView", "playMainCardAnim, targetView==null");
          AppMethodBeat.o(310616);
          return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310610);
            Log.i("GLCardAnimView", "startFlip");
            GLCardAnimView.c(GLCardAnimView.this);
            AppMethodBeat.o(310610);
          }
        }, 100L);
        AppMethodBeat.o(310616);
      }
    });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject3, "scaleX", new float[] { 1.0F, 3.333333F });
    localObjectAnimator2.setDuration(500L);
    localObject3 = ObjectAnimator.ofFloat(localObject3, "scaleY", new float[] { 1.0F, 3.333333F });
    ((ObjectAnimator)localObject3).setDuration(500L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.Qif, "scaleX", new float[] { 0.3333333F, 1.0F });
    localObjectAnimator3.setDuration(500L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.Qif, "scaleY", new float[] { 0.3333333F, 1.0F });
    localObjectAnimator4.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2, localObjectAnimator1 });
    localAnimatorSet.play(localObjectAnimator2).with((Animator)localObject3).with(localObjectAnimator3).with(localObjectAnimator4).after((Animator)localObject2);
    localAnimatorSet.setStartDelay(100L);
    localAnimatorSet.start();
    localObject1 = (com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(1);
    localObject2 = (com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(3);
    b((com.tencent.mm.plugin.sns.ad.widget.gllib.b)localObject1, 50, -i);
    b((com.tencent.mm.plugin.sns.ad.widget.gllib.b)localObject2, 50, i);
    AppMethodBeat.o(310642);
  }
  
  public final void lh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310630);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(310630);
      return;
    }
    paramInt2 = a.fromDPToPix(this.mContext, 16);
    int i = paramInt1 / 2 - this.Qic / 2;
    int j = getHeight() / 2;
    paramInt1 = j - this.Qid / 2;
    j = this.Qid / 2 + j;
    ((com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(2)).W(i, paramInt1, this.Qic + i, j);
    int k = i - (this.Qic + paramInt2);
    ((com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(1)).W(k, paramInt1, this.Qic + k, j);
    k = i - (this.Qic + paramInt2) * 2;
    ((com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(0)).W(k, paramInt1, this.Qic + k, j);
    k = i + (this.Qic + paramInt2);
    ((com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(3)).W(k, paramInt1, this.Qic + k, j);
    paramInt2 = i + (this.Qic + paramInt2) * 2;
    ((com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(4)).W(paramInt2, paramInt1, this.Qic + paramInt2, j);
    AppMethodBeat.o(310630);
  }
  
  public void setAnimCardView(View paramView)
  {
    AppMethodBeat.i(310646);
    StringBuilder localStringBuilder = new StringBuilder("setAnimCardView, target=null?");
    if (paramView == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("GLCardAnimView", bool);
      this.Qif = paramView;
      AppMethodBeat.o(310646);
      return;
    }
  }
  
  public void setOnCardAnimListener(ShakeCardAnimView.a parama)
  {
    this.Qij = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.shakead.GLCardAnimView
 * JD-Core Version:    0.7.0.1
 */