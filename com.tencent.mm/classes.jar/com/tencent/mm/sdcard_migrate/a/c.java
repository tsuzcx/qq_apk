package com.tencent.mm.sdcard_migrate.a;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;

public final class c
  extends Dialog
  implements DialogInterface
{
  private Button FNQ;
  private Button HRF;
  private LinearLayout NIA;
  private TextView NIB;
  public TextView NIC;
  public TextView NID;
  private TextView NIE;
  private TextView NIF;
  private TextView NIG;
  private ImageView NIH;
  private View NII;
  private ViewStub NIJ;
  public LinearLayout NIK;
  private ViewGroup NIL;
  private LinearLayout NIM;
  private ViewGroup NIN;
  private View NIO;
  private boolean NIP;
  private Animation NIQ;
  private Animation NIR;
  private Animation NIS;
  private Animation NIT;
  public c.a.c NIU;
  private DialogInterface.OnDismissListener NIV;
  private View ahJ;
  com.tencent.mm.ui.widget.a.c iOnDialogDismissListener;
  private TextView jUu;
  private Context mContext;
  private EditText mEditText;
  private boolean needEdit;
  private LinearLayout nmr;
  private boolean ox;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(204673);
    this.NIP = false;
    this.needEdit = false;
    this.mContext = paramContext;
    this.NIA = ((LinearLayout)View.inflate(this.mContext, 2131495500, null));
    this.HRF = ((Button)this.NIA.findViewById(2131304709));
    this.FNQ = ((Button)this.NIA.findViewById(2131304695));
    this.jUu = ((TextView)this.NIA.findViewById(2131304710));
    this.NIB = ((TextView)this.NIA.findViewById(2131304712));
    this.NIC = ((TextView)this.NIA.findViewById(2131304701));
    this.NID = ((TextView)this.NIA.findViewById(2131304702));
    this.NIE = ((TextView)this.NIA.findViewById(2131304707));
    this.NIF = ((TextView)this.NIA.findViewById(2131304706));
    this.NIG = ((TextView)this.NIA.findViewById(2131298999));
    this.mEditText = ((EditText)this.NIA.findViewById(2131299004));
    this.NIH = ((ImageView)this.NIA.findViewById(2131304705));
    this.nmr = ((LinearLayout)this.NIA.findViewById(2131304711));
    this.NIJ = ((ViewStub)this.NIA.findViewById(2131309231));
    this.NIK = ((LinearLayout)this.NIA.findViewById(2131304703));
    this.NIL = ((ViewGroup)this.NIA.findViewById(2131304689));
    this.NIO = this.NIA.findViewById(2131304694);
    this.NIM = ((LinearLayout)this.NIA.findViewById(2131304697));
    this.NIN = ((ViewGroup)this.NIA.findViewById(2131309230));
    setCanceledOnTouchOutside(true);
    this.NIQ = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.NIR = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.NIS = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    this.NIT = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    AppMethodBeat.o(204673);
  }
  
  private void AH(boolean paramBoolean)
  {
    AppMethodBeat.i(204679);
    if (paramBoolean)
    {
      int i = at.fromDPToPix(this.mContext, 8);
      this.NIK.setVisibility(0);
      this.NIK.setPadding(i, i, i, i);
      this.NIK.setBackgroundResource(2131232009);
    }
    AppMethodBeat.o(204679);
  }
  
  private void a(CharSequence paramCharSequence, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(204685);
    if (this.FNQ != null)
    {
      this.FNQ.setVisibility(0);
      this.FNQ.setText(paramCharSequence);
      this.FNQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(204665);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(c.this, -2);
          }
          if (this.NJe) {
            c.this.cancel();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(204665);
        }
      });
    }
    AppMethodBeat.o(204685);
  }
  
  private void a(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(204682);
    if (this.HRF == null)
    {
      AppMethodBeat.o(204682);
      return;
    }
    this.HRF.setVisibility(0);
    this.HRF.setText(paramCharSequence);
    this.HRF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204664);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(c.this, -1);
        }
        if (paramBoolean) {
          c.this.dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204664);
      }
    });
    AppMethodBeat.o(204682);
  }
  
  private void ajJ(int paramInt)
  {
    AppMethodBeat.i(204677);
    if (this.NIC != null) {
      this.NIC.setTextColor(paramInt);
    }
    AppMethodBeat.o(204677);
  }
  
  private void ajK(int paramInt)
  {
    AppMethodBeat.i(204680);
    if (this.NIK != null) {
      this.NIK.setVisibility(paramInt);
    }
    if (this.NIM != null) {
      this.NIM.setVisibility(paramInt);
    }
    if ((this.NIG != null) && (this.NIP)) {
      this.NIG.setVisibility(paramInt);
    }
    if (this.mEditText != null)
    {
      if (!this.needEdit)
      {
        this.mEditText.setVisibility(8);
        AppMethodBeat.o(204680);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(204680);
  }
  
  private void ajL(int paramInt)
  {
    AppMethodBeat.i(204683);
    this.HRF.setTextColor(paramInt);
    AppMethodBeat.o(204683);
  }
  
  private void ajM(int paramInt)
  {
    AppMethodBeat.i(204684);
    this.FNQ.setTextColor(paramInt);
    AppMethodBeat.o(204684);
  }
  
  private void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(204687);
    this.NIO.setVisibility(8);
    this.NIL.removeAllViews();
    this.NIL.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(204687);
  }
  
  private void gq(View paramView)
  {
    AppMethodBeat.i(204681);
    this.ahJ = paramView;
    if (this.ahJ != null)
    {
      this.NIK.setVisibility(0);
      this.NIM.setVisibility(0);
      this.NIM.removeAllViews();
      this.NIM.setGravity(1);
      this.NIM.addView(this.ahJ, new LinearLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(204681);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(204688);
    int i;
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      i = parama.NIs;
      if (this.jUu != null) {
        this.jUu.setGravity(i);
      }
      setTitle(parama.title);
    }
    Object localObject4;
    Object localObject1;
    if ((parama.NHK != null) && (parama.NHK.length() > 0))
    {
      localObject4 = parama.NHK;
      this.nmr.setVisibility(0);
      this.NIB.setVisibility(0);
      localObject1 = localObject4;
      if (this.NIU != null)
      {
        localObject1 = this.NIU;
        ((CharSequence)localObject4).toString();
        this.jUu.getTextSize();
        localObject1 = ((c.a.c)localObject1).gxn();
      }
      this.NIB.setText((CharSequence)localObject1);
    }
    if (parama.Kaw != 0)
    {
      i = parama.Kaw;
      this.jUu.setTextColor(ColorStateList.valueOf(i));
    }
    if (parama.NIp != 0)
    {
      i = parama.NIp;
      this.jUu.setMaxLines(i);
    }
    if (parama.NIq != 0)
    {
      i = parama.NIq;
      this.NIC.setMaxLines(i);
    }
    if (parama.vk != null) {
      gq(parama.vk);
    }
    if (parama.NIn != null)
    {
      localObject4 = parama.NIn;
      this.nmr.setVisibility(0);
      this.NIJ.setLayoutResource(2131493697);
    }
    try
    {
      localObject1 = (LinearLayout)this.NIJ.inflate();
      ((LinearLayout)localObject1).addView((View)localObject4);
      if (parama.NIo != null)
      {
        this.NII = parama.NIo;
        if (this.NII != null)
        {
          this.NIK.setVisibility(8);
          this.NIG.setVisibility(8);
          this.mEditText.setVisibility(8);
          this.NIN.removeAllViews();
          this.NIN.addView(this.NII, new LinearLayout.LayoutParams(-1, -1));
          this.NIN.setVisibility(8);
        }
      }
      if (parama.NHV != null)
      {
        localObject1 = parama.NHV;
        if (this.ahJ == null)
        {
          this.NIK.setVisibility(0);
          this.NIH.setVisibility(0);
          this.NIH.setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if ((parama.NHX != null) && (parama.NHX.length() > 0)) {
        setMessage(parama.NHX);
      }
      AH(parama.NIg);
      if (parama.thumbPath != null)
      {
        localObject1 = parama.thumbPath;
        i = at.fromDPToPix(this.mContext, 120);
        this.NIK.setVisibility(0);
        this.NIH.setVisibility(0);
        if ((this.NIH instanceof com.tencent.mm.ui.g.a)) {
          ((com.tencent.mm.ui.g.a)this.NIH).aM((String)localObject1, i, i);
        }
        i = parama.NIu;
        this.NIK.setVisibility(i);
        this.NIH.setVisibility(i);
      }
      if ((!parama.NIy) && (!parama.NIz))
      {
        if ((parama.NHX != null) && (parama.NHX.length() > 0)) {
          setMessage(parama.NHX);
        }
        if ((parama.NHY == null) || (parama.NHY.length() <= 0)) {
          break label1950;
        }
        localObject1 = parama.NHY;
        this.NIK.setVisibility(0);
        this.NIE.setVisibility(0);
        this.NIE.setMaxLines(2);
        this.NIE.setText((CharSequence)localObject1);
        if ((parama.NHZ != null) && (parama.NHZ.length() > 0))
        {
          localObject4 = parama.NHZ;
          if (localObject4 != null)
          {
            this.NIK.setVisibility(0);
            this.NIF.setVisibility(0);
            localObject1 = localObject4;
            if (this.NIU != null)
            {
              localObject1 = this.NIU;
              this.NIF.getContext();
              ((CharSequence)localObject4).toString();
              this.NIF.getTextSize();
              localObject1 = ((c.a.c)localObject1).gxn();
            }
            this.NIF.setText((CharSequence)localObject1);
          }
        }
        if (parama.NHW != null)
        {
          localObject1 = parama.NHW;
          if (this.ahJ == null)
          {
            this.NIK.setVisibility(0);
            this.NIH.setVisibility(0);
            this.NIH.setImageBitmap((Bitmap)localObject1);
          }
        }
      }
      if (parama.NIy)
      {
        localObject1 = parama.NHW;
        localObject5 = parama.NHY;
        localObject4 = parama.NHZ;
        localObject6 = View.inflate(this.mContext, 2131493700, null);
        if (localObject1 != null)
        {
          localObject7 = (ImageView)((View)localObject6).findViewById(2131304705);
          ((ImageView)localObject7).setVisibility(0);
          ((ImageView)localObject7).setImageBitmap((Bitmap)localObject1);
        }
        if (localObject5 != null)
        {
          localObject7 = (TextView)((View)localObject6).findViewById(2131304707);
          ((TextView)localObject7).setVisibility(0);
          localObject1 = localObject5;
          if (this.NIU != null)
          {
            localObject1 = this.NIU;
            ((CharSequence)localObject5).toString();
            ((TextView)localObject7).getTextSize();
            localObject1 = ((c.a.c)localObject1).gxn();
          }
          ((TextView)localObject7).setText((CharSequence)localObject1);
        }
        if (localObject4 != null)
        {
          localObject5 = (TextView)((View)localObject6).findViewById(2131304706);
          ((TextView)localObject5).setVisibility(0);
          if (this.NIU == null) {
            break label2233;
          }
          localObject1 = this.NIU;
          ((CharSequence)localObject4).toString();
          ((TextView)localObject5).getTextSize();
          localObject1 = ((c.a.c)localObject1).gxn();
          ((TextView)localObject5).setText((CharSequence)localObject1);
        }
        gq((View)localObject6);
        if ((parama.NHO != null) || (parama.NHP != null))
        {
          localObject4 = parama.NHO;
          localObject5 = parama.NHP;
          bool = parama.NHQ;
          localObject6 = parama.NHS;
          this.NIJ.setLayoutResource(2131493710);
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject5;
          Object localObject6;
          Object localObject7;
          boolean bool;
          localObject1 = (LinearLayout)this.NIJ.inflate();
          if ((localObject1 != null) && (localObject4 != null)) {
            ((ImageView)((LinearLayout)localObject1).findViewById(2131309220)).setVisibility(0);
          }
          if ((localObject1 != null) && (localObject5 != null))
          {
            localObject7 = (TextView)((LinearLayout)localObject1).findViewById(2131309245);
            ((TextView)localObject7).setVisibility(0);
            localObject4 = localObject5;
            if (this.NIU != null)
            {
              localObject4 = this.NIU;
              ((CharSequence)localObject5).toString();
              this.jUu.getTextSize();
              localObject4 = ((c.a.c)localObject4).gxn();
            }
            ((TextView)localObject7).setText((CharSequence)localObject4);
          }
          if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
          {
            localObject4 = (ImageView)((LinearLayout)localObject1).findViewById(2131302598);
            ((ImageView)localObject4).setVisibility(0);
            ajK(0);
            ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(204661);
                b localb = new b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                if (this.NIX.isSelected())
                {
                  c.b(c.this).startAnimation(c.a(c.this));
                  c.a(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(204658);
                      c.b(c.this).setVisibility(8);
                      c.a(c.this, 0);
                      AppMethodBeat.o(204658);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(204657);
                      c.a(c.this, c.c(c.this));
                      AppMethodBeat.o(204657);
                    }
                  });
                  ObjectAnimator.ofFloat(this.NIX, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
                  this.NIX.setSelected(false);
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(204661);
                  return;
                  c.b(c.this).startAnimation(c.d(c.this));
                  c.d(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(204660);
                      c.b(c.this).setVisibility(0);
                      c.a(c.this, 8);
                      AppMethodBeat.o(204660);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(204659);
                      c.a(c.this, c.e(c.this));
                      AppMethodBeat.o(204659);
                    }
                  });
                  ObjectAnimator.ofFloat(this.NIX, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
                  this.NIX.setSelected(true);
                }
              }
            });
          }
          if (parama.NHT != null)
          {
            localObject1 = parama.NHT;
            if ((this.NIK != null) && (this.NIK.getVisibility() == 0)) {
              this.NIK.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(204662);
                  b localb = new b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(204662);
                }
              });
            }
          }
          else
          {
            if ((parama.NHL != null) && (parama.NHL.length() > 0))
            {
              localObject1 = parama.NHL;
              if (localObject1 != null)
              {
                this.NIG.setVisibility(0);
                this.NIG.setText((CharSequence)localObject1);
              }
              this.NIP = true;
              i = parama.NIr;
              if (this.NIG != null) {
                this.NIG.setGravity(i);
              }
            }
            if ((parama.NHM != null) && (parama.NHM.length() > 0))
            {
              localObject1 = parama.NHM;
              this.mEditText.setVisibility(0);
              this.mEditText.setHint((CharSequence)localObject1);
            }
            if (parama.NHN)
            {
              this.needEdit = parama.NHN;
              if (!parama.NHN) {
                continue;
              }
              this.mEditText.setVisibility(0);
            }
            if ((parama.NIa != null) && (parama.NIa.length() > 0)) {
              a(parama.NIa, parama.NIx, parama.NIi);
            }
            if ((parama.NIb != null) && (parama.NIb.length() > 0)) {
              a(parama.NIb, parama.NIj);
            }
            if (parama.NIw != 0) {
              ajL(parama.NIw);
            }
            if (parama.NIv != 0) {
              ajM(parama.NIv);
            }
            if (parama.XY != null) {
              setOnCancelListener(parama.XY);
            }
            if (parama.XZ != null)
            {
              this.NIV = parama.XZ;
              setOnDismissListener(parama.XZ);
            }
            if (parama.NHU != null) {
              this.NIU = parama.NHU;
            }
            setCancelable(parama.ox);
            this.ox = parama.ox;
            if (!this.ox) {
              super.setCancelable(parama.NIf);
            }
            if ((parama.NIc != null) || (parama.NId != null) || (parama.NIe != null))
            {
              localObject1 = View.inflate(this.mContext, 2131493709, null);
              localObject4 = (Button)((View)localObject1).findViewById(2131304691);
              localObject5 = (Button)((View)localObject1).findViewById(2131304692);
              localObject6 = (Button)((View)localObject1).findViewById(2131304693);
              if (parama.NIc != null)
              {
                ((Button)localObject4).setVisibility(0);
                ((Button)localObject4).setText(parama.NIc);
                ((Button)localObject4).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(204666);
                    b localb = new b();
                    localb.bm(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    if (parama.NIk != null) {
                      parama.NIk.onClick(c.this, -1);
                    }
                    c.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(204666);
                  }
                });
              }
              if (parama.NId != null)
              {
                ((Button)localObject5).setVisibility(0);
                ((Button)localObject5).setText(parama.NId);
                ((Button)localObject5).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(204667);
                    b localb = new b();
                    localb.bm(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    if (parama.NIl != null) {
                      parama.NIl.onClick(c.this, -2);
                    }
                    c.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(204667);
                  }
                });
              }
              if (parama.NIe != null)
              {
                ((Button)localObject6).setVisibility(0);
                ((Button)localObject6).setText(parama.NIe);
                ((Button)localObject6).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(204668);
                    b localb = new b();
                    localb.bm(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    if (parama.NIm != null) {
                      parama.NIm.onClick(c.this, -3);
                    }
                    c.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(204668);
                  }
                });
              }
              b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            if (parama.NHR)
            {
              localObject1 = View.inflate(this.mContext, 2131493696, null);
              this.FNQ = ((Button)((View)localObject1).findViewById(2131304695));
              this.HRF = ((Button)((View)localObject1).findViewById(2131304709));
              if (parama.NIw != 0) {
                ajL(parama.NIw);
              }
              if (parama.NIv != 0) {
                ajM(parama.NIv);
              }
              if ((parama.NIa != null) && (parama.NIa.length() > 0)) {
                a(parama.NIa, parama.NIx, parama.NIi);
              }
              if ((parama.NIb != null) && (parama.NIb.length() > 0)) {
                a(parama.NIb, parama.NIj);
              }
              b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(204688);
            return;
            localException1 = localException1;
            this.NIJ.setVisibility(0);
            Object localObject2 = null;
            continue;
            label1950:
            AH(false);
            continue;
            if (!parama.NIz) {
              continue;
            }
            localObject2 = parama.NHW;
            localObject5 = parama.NHY;
            localObject4 = parama.NHZ;
            localObject6 = View.inflate(this.mContext, 2131493701, null);
            if (localObject2 != null)
            {
              localObject7 = (ImageView)((View)localObject6).findViewById(2131304705);
              ((ImageView)localObject7).setVisibility(0);
              ((ImageView)localObject7).setImageBitmap((Bitmap)localObject2);
            }
            if (localObject5 != null)
            {
              localObject7 = (TextView)((View)localObject6).findViewById(2131304707);
              ((TextView)localObject7).setVisibility(0);
              localObject2 = localObject5;
              if (this.NIU != null)
              {
                localObject2 = this.NIU;
                ((CharSequence)localObject5).toString();
                ((TextView)localObject7).getTextSize();
                localObject2 = ((c.a.c)localObject2).gxn();
              }
              ((TextView)localObject7).setText((CharSequence)localObject2);
            }
            if (localObject4 != null)
            {
              localObject5 = (TextView)((View)localObject6).findViewById(2131304706);
              ((TextView)localObject5).setVisibility(0);
              if (this.NIU == null) {
                continue;
              }
              localObject2 = this.NIU;
              ((CharSequence)localObject4).toString();
              ((TextView)localObject5).getTextSize();
              localObject2 = ((c.a.c)localObject2).gxn();
              ((TextView)localObject5).setText((CharSequence)localObject2);
            }
            gq((View)localObject6);
          }
        }
        catch (Exception localException2)
        {
          this.NIJ.setVisibility(0);
          localObject3 = null;
          continue;
          if (this.NIM == null) {
            continue;
          }
          this.NIM.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(204663);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(204663);
            }
          });
          continue;
          this.mEditText.setVisibility(8);
          continue;
          localObject3 = localObject4;
          continue;
        }
        label2233:
        Object localObject3 = localObject4;
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(204690);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204669);
          c.this.dismiss();
          AppMethodBeat.o(204669);
        }
      });
      as.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      AppMethodBeat.o(204690);
      return;
    }
    try
    {
      if ((this.mContext != null) && ((this.mContext instanceof Activity))) {
        if (!((Activity)this.mContext).isFinishing()) {
          super.dismiss();
        }
      }
      for (;;)
      {
        if (this.iOnDialogDismissListener != null) {
          this.iOnDialogDismissListener.onDialogDismiss(this);
        }
        AppMethodBeat.o(204690);
        return;
        super.dismiss();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        as.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204674);
    super.onCreate(paramBundle);
    setContentView(this.NIA);
    AppMethodBeat.o(204674);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(204686);
    super.setCancelable(paramBoolean);
    this.ox = paramBoolean;
    setCanceledOnTouchOutside(this.ox);
    AppMethodBeat.o(204686);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(204678);
    this.NIK.setVisibility(0);
    this.NIC.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.NIU != null)
    {
      localObject = this.NIU;
      this.NIC.getContext();
      paramCharSequence.toString();
      this.NIC.getTextSize();
      localObject = ((c.a.c)localObject).gxn();
    }
    this.NIC.setText((CharSequence)localObject);
    AppMethodBeat.o(204678);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(204676);
    this.nmr.setVisibility(0);
    this.jUu.setVisibility(0);
    this.jUu.setMaxLines(2);
    this.jUu.setText(paramInt);
    this.jUu.getPaint().setFakeBoldText(true);
    ajJ(this.mContext.getResources().getColor(2131099748));
    AppMethodBeat.o(204676);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(204675);
    this.nmr.setVisibility(0);
    this.jUu.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.NIU != null)
    {
      localObject = this.NIU;
      paramCharSequence.toString();
      this.jUu.getTextSize();
      localObject = ((c.a.c)localObject).gxn();
    }
    this.jUu.setMaxLines(2);
    this.jUu.setText((CharSequence)localObject);
    this.jUu.getPaint().setFakeBoldText(true);
    ajJ(this.mContext.getResources().getColor(2131099748));
    AppMethodBeat.o(204675);
  }
  
  public final void show()
  {
    AppMethodBeat.i(204689);
    try
    {
      super.show();
      AppMethodBeat.o(204689);
      return;
    }
    catch (Exception localException)
    {
      as.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(204689);
    }
  }
  
  public static final class a
  {
    private a NJg;
    private Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(204670);
      this.mContext = paramContext;
      this.NJg = new a();
      AppMethodBeat.o(204670);
    }
    
    public final a AI(boolean paramBoolean)
    {
      this.NJg.ox = false;
      return this;
    }
    
    public final a a(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.NJg.NIi = paramOnClickListener;
      return this;
    }
    
    public final a b(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.NJg.NIj = paramOnClickListener;
      return this;
    }
    
    public final a bhS(String paramString)
    {
      this.NJg.title = null;
      return this;
    }
    
    public final a bhT(String paramString)
    {
      this.NJg.NHX = paramString;
      return this;
    }
    
    public final a bhU(String paramString)
    {
      this.NJg.NIa = paramString;
      return this;
    }
    
    public final a bhV(String paramString)
    {
      this.NJg.NIb = paramString;
      return this;
    }
    
    public final a gxl()
    {
      AppMethodBeat.i(204671);
      this.NJg.NIa = this.mContext.getString(2131755921);
      AppMethodBeat.o(204671);
      return this;
    }
    
    public final c gxm()
    {
      AppMethodBeat.i(204672);
      c localc = new c(this.mContext);
      localc.a(this.NJg);
      AppMethodBeat.o(204672);
      return localc;
    }
    
    public static abstract interface a {}
    
    public static abstract interface b {}
    
    public static abstract interface c
    {
      public abstract CharSequence gxn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c
 * JD-Core Version:    0.7.0.1
 */