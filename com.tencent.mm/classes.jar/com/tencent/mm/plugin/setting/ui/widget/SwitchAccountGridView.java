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
  private static int wkX;
  private String irg;
  public boolean qMy;
  private boolean wkY;
  private boolean wkZ;
  private boolean wla;
  public String wlb;
  public AnimatorSet wlc;
  public List<String> wld;
  public List<d> wle;
  public List<View> wlf;
  private b wlg;
  private a wlh;
  private c wli;
  
  public SwitchAccountGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74644);
    this.wld = new ArrayList();
    this.wle = new ArrayList();
    this.wlf = new ArrayList();
    wkX = getResources().getDimensionPixelOffset(2131165188) * 2;
    AppMethodBeat.o(74644);
  }
  
  public final void aw(Map<String, SwitchAccountModel> paramMap)
  {
    AppMethodBeat.i(74645);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.wld.addAll(paramMap.keySet());
      Collections.sort(this.wld);
    }
    ad.i("MicroMsg.SwitchAccountGridView", "account count %d", new Object[] { Integer.valueOf(this.wld.size()) });
    int i = 0;
    d locald;
    if (i < this.wld.size())
    {
      localObject1 = ((Activity)getContext()).getLayoutInflater().inflate(2131495407, null);
      localImageView = (ImageView)((View)localObject1).findViewById(2131296329);
      localObject2 = (ImageView)((View)localObject1).findViewById(2131296332);
      Object localObject4 = ((View)localObject1).findViewById(2131298894);
      localObject3 = (String)this.wld.get(i);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131296338);
      locald = new d((byte)0);
      locald.ida = localImageView;
      locald.wjx = ((ImageView)localObject2);
      locald.smn = localTextView;
      locald.wlm = ((View)localObject4);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject4 = ((SwitchAccountModel)paramMap.get(localObject3)).qjl;
      for (;;)
      {
        try
        {
          if (!bt.isNullOrNil((String)localObject4))
          {
            if (!this.wla) {
              continue;
            }
            ad.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
            localObject4 = i.aR((String)localObject4, 0, (int)i.aMN((String)localObject4));
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
          a.b.c(locald.ida, (String)localObject3);
          continue;
        }
        localTextView.setText(k.b(getContext(), ((SwitchAccountModel)paramMap.get(localObject3)).username, localTextView.getTextSize()));
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74638);
            ad.i("MicroMsg.SwitchAccountGridView", "click %s", new Object[] { this.wlj });
            if ((!SwitchAccountGridView.a(SwitchAccountGridView.this)) && (SwitchAccountGridView.b(SwitchAccountGridView.this) != null)) {
              SwitchAccountGridView.b(SwitchAccountGridView.this).amX(this.wlj);
            }
            AppMethodBeat.o(74638);
          }
        });
        ((ImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74639);
            if (SwitchAccountGridView.c(SwitchAccountGridView.this) != null) {
              SwitchAccountGridView.c(SwitchAccountGridView.this).amY(this.wlj);
            }
            AppMethodBeat.o(74639);
          }
        });
        this.wle.add(locald);
        this.wlf.add(localObject1);
        i += 1;
        break;
        localObject4 = e.vY((String)localObject4);
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
    ((d)localObject3).ida = ((ImageView)localObject1);
    ((d)localObject3).wjx = localImageView;
    ((d)localObject3).smn = ((TextView)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setImageResource(2131231164);
    ((TextView)localObject2).setText(getContext().getResources().getString(2131763439));
    ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74640);
        ad.i("MicroMsg.SwitchAccountGridView", "click addBtn");
        if (SwitchAccountGridView.b(SwitchAccountGridView.this) != null) {
          SwitchAccountGridView.b(SwitchAccountGridView.this).amX(null);
        }
        AppMethodBeat.o(74640);
      }
    });
    this.wle.add(localObject3);
    this.wlf.add(paramMap);
    AppMethodBeat.o(74645);
  }
  
  public final void doC()
  {
    AppMethodBeat.i(74646);
    if (this.qMy)
    {
      ad.i("MicroMsg.SwitchAccountGridView", "playing animation");
      AppMethodBeat.o(74646);
      return;
    }
    removeAllViews();
    int j = Math.min(2, this.wld.size());
    int i = 0;
    label103:
    GridLayout.LayoutParams localLayoutParams;
    if (i < j)
    {
      if ((this.wkY) && (!((String)this.wld.get(i)).equals(this.irg)))
      {
        ((d)this.wle.get(i)).wjx.setVisibility(0);
        ((d)this.wle.get(i)).wlm.setVisibility(4);
        if ((!bt.isNullOrNil(this.irg)) && (((String)this.wld.get(i)).equals(this.irg)))
        {
          if (!this.wkZ) {
            break label525;
          }
          ((ImageView)((d)this.wle.get(i)).wlm.findViewById(2131298895)).setImageResource(2131232610);
          label194:
          if (!this.wkZ) {
            break label559;
          }
          ((TextView)((d)this.wle.get(i)).wlm.findViewById(2131298897)).setText(getContext().getResources().getString(2131766297));
        }
      }
      for (;;)
      {
        ((d)this.wle.get(i)).wlm.findViewById(2131296335).setVisibility(8);
        ((d)this.wle.get(i)).wlm.findViewById(2131298895).setVisibility(0);
        ((d)this.wle.get(i)).wlm.setVisibility(0);
        if ((!bt.isNullOrNil(this.wlb)) && (((String)this.wld.get(i)).equals(this.wlb)))
        {
          ((TextView)((d)this.wle.get(i)).wlm.findViewById(2131298897)).setText(getContext().getResources().getString(2131760781));
          ((d)this.wle.get(i)).wlm.findViewById(2131298895).setVisibility(8);
          ((d)this.wle.get(i)).wlm.findViewById(2131296335).setVisibility(0);
          ((d)this.wle.get(i)).wlm.setVisibility(0);
        }
        localLayoutParams = new GridLayout.LayoutParams();
        localLayoutParams.width = wkX;
        addView((View)this.wlf.get(i), localLayoutParams);
        i += 1;
        break;
        ((d)this.wle.get(i)).wjx.setVisibility(4);
        break label103;
        label525:
        ((ImageView)((d)this.wle.get(i)).wlm.findViewById(2131298895)).setImageResource(2131232608);
        break label194;
        label559:
        ((TextView)((d)this.wle.get(i)).wlm.findViewById(2131298897)).setText(getContext().getResources().getString(2131763442));
      }
    }
    if (getChildCount() < 2)
    {
      ((d)this.wle.get(this.wle.size() - 1)).wjx.setVisibility(4);
      localLayoutParams = new GridLayout.LayoutParams();
      localLayoutParams.width = wkX;
      addView((View)this.wlf.get(this.wlf.size() - 1), localLayoutParams);
    }
    AppMethodBeat.o(74646);
  }
  
  public int getAccountCount()
  {
    AppMethodBeat.i(74647);
    int i = this.wld.size();
    AppMethodBeat.o(74647);
    return i;
  }
  
  public void setDeleteState(boolean paramBoolean)
  {
    this.wkY = paramBoolean;
  }
  
  public void setLastLoginWxUsername(String paramString)
  {
    this.irg = paramString;
  }
  
  public void setLogoutState(boolean paramBoolean)
  {
    this.wkZ = paramBoolean;
  }
  
  public void setOnAnimatorEndListener(a parama)
  {
    this.wlh = parama;
  }
  
  public void setOnClickAvatarListener(b paramb)
  {
    this.wlg = paramb;
  }
  
  public void setOnDeleteAvatarListener(c paramc)
  {
    this.wli = paramc;
  }
  
  public void setSwitchToWxUsername(String paramString)
  {
    this.wlb = paramString;
  }
  
  public void setUseSystemDecoder(boolean paramBoolean)
  {
    this.wla = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void doo();
  }
  
  public static abstract interface b
  {
    public abstract void amX(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void amY(String paramString);
  }
  
  final class d
  {
    public ImageView ida;
    public TextView smn;
    public ImageView wjx;
    public View wlm;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView
 * JD-Core Version:    0.7.0.1
 */