package com.tencent.mm.plugin.setting.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView
  extends GridLayout
{
  private static int yKY;
  public boolean iUN;
  private String jku;
  private boolean yKZ;
  private boolean yLa;
  private boolean yLb;
  public String yLc;
  public AnimatorSet yLd;
  public List<String> yLe;
  public List<d> yLf;
  public List<View> yLg;
  private b yLh;
  private a yLi;
  private c yLj;
  
  public SwitchAccountGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74644);
    this.yLe = new ArrayList();
    this.yLf = new ArrayList();
    this.yLg = new ArrayList();
    yKY = getResources().getDimensionPixelOffset(2131165188) * 2;
    AppMethodBeat.o(74644);
  }
  
  public final void aB(Map<String, SwitchAccountModel> paramMap)
  {
    AppMethodBeat.i(74645);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.yLe.addAll(paramMap.keySet());
      Collections.sort(this.yLe);
    }
    ad.i("MicroMsg.SwitchAccountGridView", "account count %d", new Object[] { Integer.valueOf(this.yLe.size()) });
    int i = 0;
    d locald;
    if (i < this.yLe.size())
    {
      localObject1 = ((Activity)getContext()).getLayoutInflater().inflate(2131495407, null);
      localImageView = (ImageView)((View)localObject1).findViewById(2131296329);
      localObject2 = (ImageView)((View)localObject1).findViewById(2131296332);
      Object localObject4 = ((View)localObject1).findViewById(2131298894);
      localObject3 = (String)this.yLe.get(i);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131296338);
      locald = new d((byte)0);
      locald.iWu = localImageView;
      locald.yJy = ((ImageView)localObject2);
      locald.usF = localTextView;
      locald.yLn = ((View)localObject4);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject4 = ((SwitchAccountModel)paramMap.get(localObject3)).rBN;
      for (;;)
      {
        try
        {
          if (!bt.isNullOrNil((String)localObject4))
          {
            if (!this.yLb) {
              continue;
            }
            ad.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
            localObject4 = i.aY((String)localObject4, 0, (int)i.aYo((String)localObject4));
            if (localObject4 != null)
            {
              localObject4 = BitmapFactory.decodeByteArray((byte[])localObject4, 0, localObject4.length);
              if (localObject4 != null) {
                localImageView.setImageBitmap((Bitmap)localObject4);
              }
            }
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.SwitchAccountGridView", localException, "get avatar error", new Object[0]);
          continue;
          a.b.c(locald.iWu, (String)localObject3);
          continue;
        }
        localTextView.setText(k.b(getContext(), ((SwitchAccountModel)paramMap.get(localObject3)).username, localTextView.getTextSize()));
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74638);
            b localb = new b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.i("MicroMsg.SwitchAccountGridView", "click %s", new Object[] { this.yLk });
            if ((!SwitchAccountGridView.a(SwitchAccountGridView.this)) && (SwitchAccountGridView.b(SwitchAccountGridView.this) != null)) {
              SwitchAccountGridView.b(SwitchAccountGridView.this).axg(this.yLk);
            }
            a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74638);
          }
        });
        ((ImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74639);
            b localb = new b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (SwitchAccountGridView.c(SwitchAccountGridView.this) != null) {
              SwitchAccountGridView.c(SwitchAccountGridView.this).axh(this.yLk);
            }
            a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74639);
          }
        });
        this.yLf.add(locald);
        this.yLg.add(localObject1);
        i += 1;
        break;
        localObject4 = e.Dd((String)localObject4);
        if (localObject4 == null) {
          continue;
        }
        localImageView.setImageBitmap((Bitmap)localObject4);
      }
    }
    paramMap = ((Activity)getContext()).getLayoutInflater().inflate(2131495407, null);
    Object localObject1 = (ImageView)paramMap.findViewById(2131296329);
    ImageView localImageView = (ImageView)paramMap.findViewById(2131296332);
    Object localObject2 = (TextView)paramMap.findViewById(2131296338);
    Object localObject3 = new d((byte)0);
    ((d)localObject3).iWu = ((ImageView)localObject1);
    ((d)localObject3).yJy = localImageView;
    ((d)localObject3).usF = ((TextView)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setImageResource(2131231164);
    ((TextView)localObject2).setText(getContext().getResources().getString(2131763439));
    ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74640);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.SwitchAccountGridView", "click addBtn");
        if (SwitchAccountGridView.b(SwitchAccountGridView.this) != null) {
          SwitchAccountGridView.b(SwitchAccountGridView.this).axg(null);
        }
        a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74640);
      }
    });
    this.yLf.add(localObject3);
    this.yLg.add(paramMap);
    AppMethodBeat.o(74645);
  }
  
  public final void dOp()
  {
    AppMethodBeat.i(74646);
    if (this.iUN)
    {
      ad.i("MicroMsg.SwitchAccountGridView", "playing animation");
      AppMethodBeat.o(74646);
      return;
    }
    removeAllViews();
    int j = Math.min(2, this.yLe.size());
    int i = 0;
    label103:
    GridLayout.LayoutParams localLayoutParams;
    if (i < j)
    {
      if ((this.yKZ) && (!((String)this.yLe.get(i)).equals(this.jku)))
      {
        ((d)this.yLf.get(i)).yJy.setVisibility(0);
        ((d)this.yLf.get(i)).yLn.setVisibility(4);
        if ((!bt.isNullOrNil(this.jku)) && (((String)this.yLe.get(i)).equals(this.jku)))
        {
          if (!this.yLa) {
            break label525;
          }
          ((ImageView)((d)this.yLf.get(i)).yLn.findViewById(2131298895)).setImageResource(2131232610);
          label194:
          if (!this.yLa) {
            break label559;
          }
          ((TextView)((d)this.yLf.get(i)).yLn.findViewById(2131298897)).setText(getContext().getResources().getString(2131766297));
        }
      }
      for (;;)
      {
        ((d)this.yLf.get(i)).yLn.findViewById(2131296335).setVisibility(8);
        ((d)this.yLf.get(i)).yLn.findViewById(2131298895).setVisibility(0);
        ((d)this.yLf.get(i)).yLn.setVisibility(0);
        if ((!bt.isNullOrNil(this.yLc)) && (((String)this.yLe.get(i)).equals(this.yLc)))
        {
          ((TextView)((d)this.yLf.get(i)).yLn.findViewById(2131298897)).setText(getContext().getResources().getString(2131760781));
          ((d)this.yLf.get(i)).yLn.findViewById(2131298895).setVisibility(8);
          ((d)this.yLf.get(i)).yLn.findViewById(2131296335).setVisibility(0);
          ((d)this.yLf.get(i)).yLn.setVisibility(0);
        }
        localLayoutParams = new GridLayout.LayoutParams();
        localLayoutParams.width = yKY;
        addView((View)this.yLg.get(i), localLayoutParams);
        i += 1;
        break;
        ((d)this.yLf.get(i)).yJy.setVisibility(4);
        break label103;
        label525:
        ((ImageView)((d)this.yLf.get(i)).yLn.findViewById(2131298895)).setImageResource(2131232608);
        break label194;
        label559:
        ((TextView)((d)this.yLf.get(i)).yLn.findViewById(2131298897)).setText(getContext().getResources().getString(2131763442));
      }
    }
    if (getChildCount() < 2)
    {
      ((d)this.yLf.get(this.yLf.size() - 1)).yJy.setVisibility(4);
      localLayoutParams = new GridLayout.LayoutParams();
      localLayoutParams.width = yKY;
      addView((View)this.yLg.get(this.yLg.size() - 1), localLayoutParams);
    }
    AppMethodBeat.o(74646);
  }
  
  public int getAccountCount()
  {
    AppMethodBeat.i(74647);
    int i = this.yLe.size();
    AppMethodBeat.o(74647);
    return i;
  }
  
  public void setDeleteState(boolean paramBoolean)
  {
    this.yKZ = paramBoolean;
  }
  
  public void setLastLoginWxUsername(String paramString)
  {
    this.jku = paramString;
  }
  
  public void setLogoutState(boolean paramBoolean)
  {
    this.yLa = paramBoolean;
  }
  
  public void setOnAnimatorEndListener(a parama)
  {
    this.yLi = parama;
  }
  
  public void setOnClickAvatarListener(b paramb)
  {
    this.yLh = paramb;
  }
  
  public void setOnDeleteAvatarListener(c paramc)
  {
    this.yLj = paramc;
  }
  
  public void setSwitchToWxUsername(String paramString)
  {
    this.yLc = paramString;
  }
  
  public void setUseSystemDecoder(boolean paramBoolean)
  {
    this.yLb = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void dOb();
  }
  
  public static abstract interface b
  {
    public abstract void axg(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void axh(String paramString);
  }
  
  final class d
  {
    public ImageView iWu;
    public TextView usF;
    public ImageView yJy;
    public View yLn;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView
 * JD-Core Version:    0.7.0.1
 */