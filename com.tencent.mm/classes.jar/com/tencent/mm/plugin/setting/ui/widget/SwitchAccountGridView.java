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
import com.tencent.mm.aj.e;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView
  extends GridLayout
{
  private static int Dga;
  private boolean Dgb;
  private boolean Dgc;
  private boolean Dgd;
  public String Dge;
  public AnimatorSet Dgf;
  public List<String> Dgg;
  public List<d> Dgh;
  public List<View> Dgi;
  private b Dgj;
  private a Dgk;
  private c Dgl;
  public boolean jUE;
  private String klw;
  
  public SwitchAccountGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74644);
    this.Dgg = new ArrayList();
    this.Dgh = new ArrayList();
    this.Dgi = new ArrayList();
    Dga = getResources().getDimensionPixelOffset(2131165191) * 2;
    AppMethodBeat.o(74644);
  }
  
  public final void aG(Map<String, SwitchAccountModel> paramMap)
  {
    AppMethodBeat.i(74645);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.Dgg.addAll(paramMap.keySet());
      Collections.sort(this.Dgg);
    }
    Log.i("MicroMsg.SwitchAccountGridView", "account count %d", new Object[] { Integer.valueOf(this.Dgg.size()) });
    int i = 0;
    d locald;
    if (i < this.Dgg.size())
    {
      localObject1 = ((Activity)getContext()).getLayoutInflater().inflate(2131496269, null);
      localImageView = (ImageView)((View)localObject1).findViewById(2131296343);
      localObject2 = (ImageView)((View)localObject1).findViewById(2131296346);
      Object localObject4 = ((View)localObject1).findViewById(2131299370);
      localObject3 = (String)this.Dgg.get(i);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131296354);
      locald = new d((byte)0);
      locald.jWS = localImageView;
      locald.DeA = ((ImageView)localObject2);
      locald.xVW = localTextView;
      locald.Dgp = ((View)localObject4);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject4 = ((SwitchAccountModel)paramMap.get(localObject3)).tjJ;
      for (;;)
      {
        try
        {
          if (!Util.isNullOrNil((String)localObject4))
          {
            if (!this.Dgd) {
              continue;
            }
            Log.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
            localObject4 = s.aW((String)localObject4, 0, (int)s.boW((String)localObject4));
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
          Log.printErrStackTrace("MicroMsg.SwitchAccountGridView", localException, "get avatar error", new Object[0]);
          continue;
          a.b.c(locald.jWS, (String)localObject3);
          continue;
        }
        localTextView.setText(l.b(getContext(), ((SwitchAccountModel)paramMap.get(localObject3)).username, localTextView.getTextSize()));
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74638);
            b localb = new b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.SwitchAccountGridView", "click %s", new Object[] { this.Dgm });
            if ((!SwitchAccountGridView.a(SwitchAccountGridView.this)) && (SwitchAccountGridView.b(SwitchAccountGridView.this) != null)) {
              SwitchAccountGridView.b(SwitchAccountGridView.this).aNg(this.Dgm);
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
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (SwitchAccountGridView.c(SwitchAccountGridView.this) != null) {
              SwitchAccountGridView.c(SwitchAccountGridView.this).aNh(this.Dgm);
            }
            a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74639);
          }
        });
        this.Dgh.add(locald);
        this.Dgi.add(localObject1);
        i += 1;
        break;
        localObject4 = e.Mq((String)localObject4);
        if (localObject4 == null) {
          continue;
        }
        localImageView.setImageBitmap((Bitmap)localObject4);
      }
    }
    paramMap = ((Activity)getContext()).getLayoutInflater().inflate(2131496269, null);
    Object localObject1 = (ImageView)paramMap.findViewById(2131296343);
    ImageView localImageView = (ImageView)paramMap.findViewById(2131296346);
    Object localObject2 = (TextView)paramMap.findViewById(2131296354);
    Object localObject3 = new d((byte)0);
    ((d)localObject3).jWS = ((ImageView)localObject1);
    ((d)localObject3).DeA = localImageView;
    ((d)localObject3).xVW = ((TextView)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setImageResource(2131231212);
    ((TextView)localObject2).setText(getContext().getResources().getString(2131765621));
    ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74640);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.SwitchAccountGridView", "click addBtn");
        if (SwitchAccountGridView.b(SwitchAccountGridView.this) != null) {
          SwitchAccountGridView.b(SwitchAccountGridView.this).aNg(null);
        }
        a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74640);
      }
    });
    this.Dgh.add(localObject3);
    this.Dgi.add(paramMap);
    AppMethodBeat.o(74645);
  }
  
  public final void eTN()
  {
    AppMethodBeat.i(74646);
    if (this.jUE)
    {
      Log.i("MicroMsg.SwitchAccountGridView", "playing animation");
      AppMethodBeat.o(74646);
      return;
    }
    removeAllViews();
    int j = Math.min(2, this.Dgg.size());
    int i = 0;
    label103:
    GridLayout.LayoutParams localLayoutParams;
    if (i < j)
    {
      if ((this.Dgb) && (!((String)this.Dgg.get(i)).equals(this.klw)))
      {
        ((d)this.Dgh.get(i)).DeA.setVisibility(0);
        ((d)this.Dgh.get(i)).Dgp.setVisibility(4);
        if ((!Util.isNullOrNil(this.klw)) && (((String)this.Dgg.get(i)).equals(this.klw)))
        {
          if (!this.Dgc) {
            break label525;
          }
          ((ImageView)((d)this.Dgh.get(i)).Dgp.findViewById(2131299371)).setImageResource(2131233008);
          label194:
          if (!this.Dgc) {
            break label559;
          }
          ((TextView)((d)this.Dgh.get(i)).Dgp.findViewById(2131299373)).setText(getContext().getResources().getString(2131768808));
        }
      }
      for (;;)
      {
        ((d)this.Dgh.get(i)).Dgp.findViewById(2131296351).setVisibility(8);
        ((d)this.Dgh.get(i)).Dgp.findViewById(2131299371).setVisibility(0);
        ((d)this.Dgh.get(i)).Dgp.setVisibility(0);
        if ((!Util.isNullOrNil(this.Dge)) && (((String)this.Dgg.get(i)).equals(this.Dge)))
        {
          ((TextView)((d)this.Dgh.get(i)).Dgp.findViewById(2131299373)).setText(getContext().getResources().getString(2131762532));
          ((d)this.Dgh.get(i)).Dgp.findViewById(2131299371).setVisibility(8);
          ((d)this.Dgh.get(i)).Dgp.findViewById(2131296351).setVisibility(0);
          ((d)this.Dgh.get(i)).Dgp.setVisibility(0);
        }
        localLayoutParams = new GridLayout.LayoutParams();
        localLayoutParams.width = Dga;
        addView((View)this.Dgi.get(i), localLayoutParams);
        i += 1;
        break;
        ((d)this.Dgh.get(i)).DeA.setVisibility(4);
        break label103;
        label525:
        ((ImageView)((d)this.Dgh.get(i)).Dgp.findViewById(2131299371)).setImageResource(2131233004);
        break label194;
        label559:
        ((TextView)((d)this.Dgh.get(i)).Dgp.findViewById(2131299373)).setText(getContext().getResources().getString(2131765624));
      }
    }
    if (getChildCount() < 2)
    {
      ((d)this.Dgh.get(this.Dgh.size() - 1)).DeA.setVisibility(4);
      localLayoutParams = new GridLayout.LayoutParams();
      localLayoutParams.width = Dga;
      addView((View)this.Dgi.get(this.Dgi.size() - 1), localLayoutParams);
    }
    AppMethodBeat.o(74646);
  }
  
  public int getAccountCount()
  {
    AppMethodBeat.i(74647);
    int i = this.Dgg.size();
    AppMethodBeat.o(74647);
    return i;
  }
  
  public void setDeleteState(boolean paramBoolean)
  {
    this.Dgb = paramBoolean;
  }
  
  public void setLastLoginWxUsername(String paramString)
  {
    this.klw = paramString;
  }
  
  public void setLogoutState(boolean paramBoolean)
  {
    this.Dgc = paramBoolean;
  }
  
  public void setOnAnimatorEndListener(a parama)
  {
    this.Dgk = parama;
  }
  
  public void setOnClickAvatarListener(b paramb)
  {
    this.Dgj = paramb;
  }
  
  public void setOnDeleteAvatarListener(c paramc)
  {
    this.Dgl = paramc;
  }
  
  public void setSwitchToWxUsername(String paramString)
  {
    this.Dge = paramString;
  }
  
  public void setUseSystemDecoder(boolean paramBoolean)
  {
    this.Dgd = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void eTz();
  }
  
  public static abstract interface b
  {
    public abstract void aNg(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void aNh(String paramString);
  }
  
  final class d
  {
    public ImageView DeA;
    public View Dgp;
    public ImageView jWS;
    public TextView xVW;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView
 * JD-Core Version:    0.7.0.1
 */