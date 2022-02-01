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
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView
  extends GridLayout
{
  private static int xwn;
  public boolean iBD;
  private String iRm;
  private boolean xwo;
  private boolean xwp;
  private boolean xwq;
  public String xwr;
  public AnimatorSet xws;
  public List<String> xwt;
  public List<d> xwu;
  public List<View> xwv;
  private b xww;
  private a xwx;
  private c xwy;
  
  public SwitchAccountGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74644);
    this.xwt = new ArrayList();
    this.xwu = new ArrayList();
    this.xwv = new ArrayList();
    xwn = getResources().getDimensionPixelOffset(2131165188) * 2;
    AppMethodBeat.o(74644);
  }
  
  public final void ay(Map<String, SwitchAccountModel> paramMap)
  {
    AppMethodBeat.i(74645);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.xwt.addAll(paramMap.keySet());
      Collections.sort(this.xwt);
    }
    ac.i("MicroMsg.SwitchAccountGridView", "account count %d", new Object[] { Integer.valueOf(this.xwt.size()) });
    int i = 0;
    d locald;
    if (i < this.xwt.size())
    {
      localObject1 = ((Activity)getContext()).getLayoutInflater().inflate(2131495407, null);
      localImageView = (ImageView)((View)localObject1).findViewById(2131296329);
      localObject2 = (ImageView)((View)localObject1).findViewById(2131296332);
      Object localObject4 = ((View)localObject1).findViewById(2131298894);
      localObject3 = (String)this.xwt.get(i);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131296338);
      locald = new d((byte)0);
      locald.iDk = localImageView;
      locald.xuN = ((ImageView)localObject2);
      locald.tug = localTextView;
      locald.xwC = ((View)localObject4);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject4 = ((SwitchAccountModel)paramMap.get(localObject3)).qRN;
      for (;;)
      {
        try
        {
          if (!bs.isNullOrNil((String)localObject4))
          {
            if (!this.xwq) {
              continue;
            }
            ac.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
            localObject4 = i.aU((String)localObject4, 0, (int)i.aSp((String)localObject4));
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
          ac.printErrStackTrace("MicroMsg.SwitchAccountGridView", localException, "get avatar error", new Object[0]);
          continue;
          a.b.c(locald.iDk, (String)localObject3);
          continue;
        }
        localTextView.setText(k.b(getContext(), ((SwitchAccountModel)paramMap.get(localObject3)).username, localTextView.getTextSize()));
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74638);
            ac.i("MicroMsg.SwitchAccountGridView", "click %s", new Object[] { this.xwz });
            if ((!SwitchAccountGridView.a(SwitchAccountGridView.this)) && (SwitchAccountGridView.b(SwitchAccountGridView.this) != null)) {
              SwitchAccountGridView.b(SwitchAccountGridView.this).asg(this.xwz);
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
              SwitchAccountGridView.c(SwitchAccountGridView.this).ash(this.xwz);
            }
            AppMethodBeat.o(74639);
          }
        });
        this.xwu.add(locald);
        this.xwv.add(localObject1);
        i += 1;
        break;
        localObject4 = e.Ae((String)localObject4);
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
    ((d)localObject3).iDk = ((ImageView)localObject1);
    ((d)localObject3).xuN = localImageView;
    ((d)localObject3).tug = ((TextView)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setImageResource(2131231164);
    ((TextView)localObject2).setText(getContext().getResources().getString(2131763439));
    ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74640);
        ac.i("MicroMsg.SwitchAccountGridView", "click addBtn");
        if (SwitchAccountGridView.b(SwitchAccountGridView.this) != null) {
          SwitchAccountGridView.b(SwitchAccountGridView.this).asg(null);
        }
        AppMethodBeat.o(74640);
      }
    });
    this.xwu.add(localObject3);
    this.xwv.add(paramMap);
    AppMethodBeat.o(74645);
  }
  
  public final void dCM()
  {
    AppMethodBeat.i(74646);
    if (this.iBD)
    {
      ac.i("MicroMsg.SwitchAccountGridView", "playing animation");
      AppMethodBeat.o(74646);
      return;
    }
    removeAllViews();
    int j = Math.min(2, this.xwt.size());
    int i = 0;
    label103:
    GridLayout.LayoutParams localLayoutParams;
    if (i < j)
    {
      if ((this.xwo) && (!((String)this.xwt.get(i)).equals(this.iRm)))
      {
        ((d)this.xwu.get(i)).xuN.setVisibility(0);
        ((d)this.xwu.get(i)).xwC.setVisibility(4);
        if ((!bs.isNullOrNil(this.iRm)) && (((String)this.xwt.get(i)).equals(this.iRm)))
        {
          if (!this.xwp) {
            break label525;
          }
          ((ImageView)((d)this.xwu.get(i)).xwC.findViewById(2131298895)).setImageResource(2131232610);
          label194:
          if (!this.xwp) {
            break label559;
          }
          ((TextView)((d)this.xwu.get(i)).xwC.findViewById(2131298897)).setText(getContext().getResources().getString(2131766297));
        }
      }
      for (;;)
      {
        ((d)this.xwu.get(i)).xwC.findViewById(2131296335).setVisibility(8);
        ((d)this.xwu.get(i)).xwC.findViewById(2131298895).setVisibility(0);
        ((d)this.xwu.get(i)).xwC.setVisibility(0);
        if ((!bs.isNullOrNil(this.xwr)) && (((String)this.xwt.get(i)).equals(this.xwr)))
        {
          ((TextView)((d)this.xwu.get(i)).xwC.findViewById(2131298897)).setText(getContext().getResources().getString(2131760781));
          ((d)this.xwu.get(i)).xwC.findViewById(2131298895).setVisibility(8);
          ((d)this.xwu.get(i)).xwC.findViewById(2131296335).setVisibility(0);
          ((d)this.xwu.get(i)).xwC.setVisibility(0);
        }
        localLayoutParams = new GridLayout.LayoutParams();
        localLayoutParams.width = xwn;
        addView((View)this.xwv.get(i), localLayoutParams);
        i += 1;
        break;
        ((d)this.xwu.get(i)).xuN.setVisibility(4);
        break label103;
        label525:
        ((ImageView)((d)this.xwu.get(i)).xwC.findViewById(2131298895)).setImageResource(2131232608);
        break label194;
        label559:
        ((TextView)((d)this.xwu.get(i)).xwC.findViewById(2131298897)).setText(getContext().getResources().getString(2131763442));
      }
    }
    if (getChildCount() < 2)
    {
      ((d)this.xwu.get(this.xwu.size() - 1)).xuN.setVisibility(4);
      localLayoutParams = new GridLayout.LayoutParams();
      localLayoutParams.width = xwn;
      addView((View)this.xwv.get(this.xwv.size() - 1), localLayoutParams);
    }
    AppMethodBeat.o(74646);
  }
  
  public int getAccountCount()
  {
    AppMethodBeat.i(74647);
    int i = this.xwt.size();
    AppMethodBeat.o(74647);
    return i;
  }
  
  public void setDeleteState(boolean paramBoolean)
  {
    this.xwo = paramBoolean;
  }
  
  public void setLastLoginWxUsername(String paramString)
  {
    this.iRm = paramString;
  }
  
  public void setLogoutState(boolean paramBoolean)
  {
    this.xwp = paramBoolean;
  }
  
  public void setOnAnimatorEndListener(a parama)
  {
    this.xwx = parama;
  }
  
  public void setOnClickAvatarListener(b paramb)
  {
    this.xww = paramb;
  }
  
  public void setOnDeleteAvatarListener(c paramc)
  {
    this.xwy = paramc;
  }
  
  public void setSwitchToWxUsername(String paramString)
  {
    this.xwr = paramString;
  }
  
  public void setUseSystemDecoder(boolean paramBoolean)
  {
    this.xwq = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void dCy();
  }
  
  public static abstract interface b
  {
    public abstract void asg(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void ash(String paramString);
  }
  
  final class d
  {
    public ImageView iDk;
    public TextView tug;
    public ImageView xuN;
    public View xwC;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView
 * JD-Core Version:    0.7.0.1
 */