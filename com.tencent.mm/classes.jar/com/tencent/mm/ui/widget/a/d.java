package com.tencent.mm.ui.widget.a;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class d
  extends Dialog
  implements DialogInterface
{
  private Button FNQ;
  private Button HRF;
  private LinearLayout NIA;
  private TextView NIB;
  public TextView NIC;
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
  public DialogInterface.OnDismissListener NIV;
  private d.a.d QNz;
  CheckBox afU;
  private View ahJ;
  public c iOnDialogDismissListener;
  private TextView jUu;
  private Context mContext;
  public EditText mEditText;
  private boolean needEdit;
  private LinearLayout nmr;
  private boolean ox;
  
  public d(Context paramContext)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(159314);
    this.NIP = false;
    this.needEdit = false;
    this.mContext = paramContext;
    hbj();
    AppMethodBeat.o(159314);
  }
  
  public d(Context paramContext, byte paramByte)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(198217);
    this.NIP = false;
    this.needEdit = false;
    this.mContext = paramContext;
    hbj();
    AppMethodBeat.o(198217);
  }
  
  private void AH(boolean paramBoolean)
  {
    AppMethodBeat.i(159320);
    if (paramBoolean)
    {
      int i = at.fromDPToPix(this.mContext, 8);
      this.NIK.setVisibility(0);
      this.NIK.setPadding(i, i, i, i);
    }
    AppMethodBeat.o(159320);
  }
  
  private void aN(View paramView, int paramInt)
  {
    AppMethodBeat.i(159325);
    this.ahJ = paramView;
    if (this.ahJ != null)
    {
      this.NIK.setVisibility(0);
      this.NIM.setVisibility(0);
      this.NIM.removeAllViews();
      this.NIM.setGravity(1);
      this.NIM.addView(this.ahJ, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
    AppMethodBeat.o(159325);
  }
  
  private void ajJ(int paramInt)
  {
    AppMethodBeat.i(159318);
    if (this.NIC != null) {
      this.NIC.setTextColor(paramInt);
    }
    AppMethodBeat.o(159318);
  }
  
  private void ajK(int paramInt)
  {
    AppMethodBeat.i(159324);
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
        AppMethodBeat.o(159324);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(159324);
  }
  
  private void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(159334);
    this.NIO.setVisibility(8);
    this.NIL.removeAllViews();
    this.NIL.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(159334);
  }
  
  private void hbj()
  {
    AppMethodBeat.i(198218);
    this.NIA = ((LinearLayout)View.inflate(this.mContext, 2131495498, null));
    this.HRF = ((Button)this.NIA.findViewById(2131304709));
    this.FNQ = ((Button)this.NIA.findViewById(2131304695));
    this.jUu = ((TextView)this.NIA.findViewById(2131304710));
    this.NIB = ((TextView)this.NIA.findViewById(2131304712));
    this.NIC = ((TextView)this.NIA.findViewById(2131304701));
    this.NIE = ((TextView)this.NIA.findViewById(2131304707));
    this.NIF = ((TextView)this.NIA.findViewById(2131304706));
    this.NIG = ((TextView)this.NIA.findViewById(2131298999));
    this.mEditText = ((EditText)this.NIA.findViewById(2131299004));
    this.afU = ((CheckBox)this.NIA.findViewById(2131298996));
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
    AppMethodBeat.o(198218);
  }
  
  public final void Dg(boolean paramBoolean)
  {
    AppMethodBeat.i(198222);
    if (paramBoolean)
    {
      this.mEditText.setVisibility(0);
      AppMethodBeat.o(198222);
      return;
    }
    this.mEditText.setVisibility(8);
    AppMethodBeat.o(198222);
  }
  
  public final void Dh(boolean paramBoolean)
  {
    AppMethodBeat.i(159333);
    super.setCancelable(paramBoolean);
    AppMethodBeat.o(159333);
  }
  
  public final void a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159329);
    a(com.tencent.mm.ui.e.a.kn(this.mContext).getString(paramInt), true, paramOnClickListener);
    AppMethodBeat.o(159329);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(159335);
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      aoM(parama.NIs);
      setTitle(parama.title);
    }
    Object localObject3;
    Object localObject1;
    if ((parama.NHK != null) && (parama.NHK.length() > 0))
    {
      localObject3 = parama.NHK;
      this.nmr.setVisibility(0);
      this.NIB.setVisibility(0);
      localObject1 = localObject3;
      if (this.QNz != null) {
        localObject1 = this.QNz.a(((CharSequence)localObject3).toString(), this.jUu.getTextSize());
      }
      this.NIB.setText((CharSequence)localObject1);
    }
    int i;
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
      aN(parama.vk, -1);
    }
    if (parama.NIn != null)
    {
      localObject3 = parama.NIn;
      this.nmr.setVisibility(0);
      this.NIJ.setLayoutResource(2131493697);
    }
    try
    {
      localObject1 = (LinearLayout)this.NIJ.inflate();
      ((LinearLayout)localObject1).addView((View)localObject3);
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
          break label2234;
        }
        localObject1 = parama.NHY;
        this.NIK.setVisibility(0);
        this.NIE.setVisibility(0);
        this.NIE.setMaxLines(2);
        this.NIE.setText((CharSequence)localObject1);
        if ((parama.NHZ != null) && (parama.NHZ.length() > 0))
        {
          localObject3 = parama.NHZ;
          if (localObject3 != null)
          {
            this.NIK.setVisibility(0);
            this.NIF.setVisibility(0);
            localObject1 = localObject3;
            if (this.QNz != null)
            {
              localObject1 = this.QNz;
              this.NIF.getContext();
              localObject1 = ((d.a.d)localObject1).a(((CharSequence)localObject3).toString(), this.NIF.getTextSize());
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
      boolean bool;
      d.a.a locala;
      if (parama.NIy)
      {
        localObject1 = parama.NHW;
        localObject4 = parama.NHY;
        localObject3 = parama.NHZ;
        localObject5 = View.inflate(this.mContext, 2131493700, null);
        if (localObject1 != null)
        {
          localObject6 = (ImageView)((View)localObject5).findViewById(2131304705);
          ((ImageView)localObject6).setVisibility(0);
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
        }
        if (localObject4 != null)
        {
          localObject6 = (TextView)((View)localObject5).findViewById(2131304707);
          ((TextView)localObject6).setVisibility(0);
          localObject1 = localObject4;
          if (this.QNz != null) {
            localObject1 = this.QNz.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
          }
          ((TextView)localObject6).setText((CharSequence)localObject1);
        }
        if (localObject3 != null)
        {
          localObject4 = (TextView)((View)localObject5).findViewById(2131304706);
          ((TextView)localObject4).setVisibility(0);
          if (this.QNz == null) {
            break label2607;
          }
          localObject1 = this.QNz.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        aN((View)localObject5, -1);
        if ((parama.NHO != null) || (parama.NHP != null))
        {
          localObject6 = parama.NHO;
          localObject4 = parama.NHP;
          bool = parama.NHQ;
          localObject5 = parama.QNt;
          locala = parama.QNu;
          this.NIJ.setLayoutResource(2131493710);
          localObject1 = null;
        }
      }
      try
      {
        localObject3 = (LinearLayout)this.NIJ.inflate();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i2;
          int j;
          float f;
          int n;
          int m;
          int i1;
          int k;
          this.NIJ.setVisibility(0);
          continue;
          if ((f >= 0.5D) && (f < 1.0F))
          {
            n = (int)(i * f);
            j = n;
            k = i;
            m = i;
          }
          else if ((f >= 1.0F) && (f < 2.0F))
          {
            m = (int)(i / f);
            j = i;
            k = m;
            n = i;
          }
          else if (f >= 2.0F)
          {
            n = (int)(i1 * f);
            k = i1;
            m = i1;
            j = i;
            continue;
            ((ImageView)localObject2).setVisibility(0);
            if (i2 == 1)
            {
              ((ImageView)localObject2).setImageResource(2131691490);
            }
            else if (i2 == 2)
            {
              ((ImageView)localObject2).setImageResource(2131691695);
              continue;
              localObject2 = localException2;
              continue;
              localObject2 = localException2;
            }
          }
        }
      }
      if ((localObject1 != null) && (localObject6 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(2131309220);
        ((ImageView)localObject3).setVisibility(0);
        if (locala != null) {
          locala.C((ImageView)localObject3, (String)localObject6);
        }
      }
      if ((localObject1 != null) && (localObject4 != null))
      {
        localObject6 = (TextView)((LinearLayout)localObject1).findViewById(2131309245);
        ((TextView)localObject6).setVisibility(0);
        localObject3 = localObject4;
        if (this.QNz != null) {
          localObject3 = this.QNz.a(((CharSequence)localObject4).toString(), this.jUu.getTextSize());
        }
        ((TextView)localObject6).setText((CharSequence)localObject3);
      }
      if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(2131302598);
        ((ImageView)localObject3).setVisibility(0);
        ajK(0);
        ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159297);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (this.QNA != null) {
              this.QNA.gpw();
            }
            if (this.NIX.isSelected())
            {
              d.e(d.this).startAnimation(d.d(d.this));
              d.d(d.this).setAnimationListener(new Animation.AnimationListener()
              {
                public final void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159294);
                  d.e(d.this).setVisibility(8);
                  d.a(d.this, 0);
                  AppMethodBeat.o(159294);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159293);
                  d.a(d.this, d.f(d.this));
                  AppMethodBeat.o(159293);
                }
              });
              ObjectAnimator.ofFloat(this.NIX, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
              this.NIX.setSelected(false);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159297);
              return;
              d.e(d.this).startAnimation(d.g(d.this));
              d.g(d.this).setAnimationListener(new Animation.AnimationListener()
              {
                public final void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159296);
                  d.e(d.this).setVisibility(0);
                  d.a(d.this, 8);
                  AppMethodBeat.o(159296);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159295);
                  d.a(d.this, d.h(d.this));
                  AppMethodBeat.o(159295);
                }
              });
              ObjectAnimator.ofFloat(this.NIX, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
              this.NIX.setSelected(true);
            }
          }
        });
      }
      if (parama.QNv != null) {
        b(parama.QNv);
      }
      if ((parama.QNx != null) && (!parama.QNx.isRecycled()))
      {
        localObject3 = parama.QNx;
        bool = parama.NIh;
        i2 = parama.NIt;
        if (localObject3 != null)
        {
          AH(false);
          this.NIK.setVisibility(0);
          this.NIK.setGravity(1);
          this.NIK.setPadding(0, 0, 0, 0);
          localObject5 = View.inflate(this.mContext, 2131493702, null);
          localObject6 = (ImageView)((View)localObject5).findViewById(2131304705);
          if (!bool) {
            break label2593;
          }
          i = ((Bitmap)localObject3).getWidth();
          j = ((Bitmap)localObject3).getHeight();
          localObject4 = null;
          f = j / i;
          n = 0;
          m = 0;
          i1 = at.aH(this.mContext, 2131165264);
          i = at.aH(this.mContext, 2131165263);
          k = 0;
          j = 0;
          if ((f <= 0.0F) || (f >= 0.5D)) {
            break label2458;
          }
          m = (int)(i1 / f);
          j = i1;
          n = i1;
          k = i;
          localObject1 = localObject4;
          if (n > 0)
          {
            localObject1 = localObject4;
            if (m > 0)
            {
              localObject1 = localObject4;
              if (localObject3 != null)
              {
                localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, m, n, true);
                ((ImageView)localObject6).setLayoutParams(new FrameLayout.LayoutParams(k, j));
              }
            }
          }
          localObject1 = aq.a((Bitmap)localObject1, at.fromDPToPix(this.mContext, 3));
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
          localObject1 = (ImageView)((View)localObject5).findViewById(2131302597);
          if (i2 != 0) {
            break label2553;
          }
          ((ImageView)localObject1).setVisibility(8);
          aN((View)localObject5, -2);
        }
      }
      if ((parama.NHL != null) && (parama.NHL.length() > 0))
      {
        localObject1 = parama.NHL;
        if (localObject1 != null)
        {
          this.NIG.setVisibility(0);
          this.NIG.setText((CharSequence)localObject1);
        }
        this.NIP = true;
        aoN(parama.NIr);
      }
      if ((parama.NHM != null) && (parama.NHM.length() > 0)) {
        ay(parama.NHM);
      }
      if ((parama.QNs != null) && (parama.QNs.length() > 0))
      {
        localObject1 = parama.QNs;
        this.afU.setVisibility(0);
        this.afU.setText((CharSequence)localObject1);
      }
      if (parama.NHN)
      {
        this.needEdit = parama.NHN;
        Dg(parama.NHN);
      }
      if ((parama.NIa != null) && (parama.NIa.length() > 0)) {
        a(parama.NIa, parama.NIx, parama.NIi);
      }
      if ((parama.NIb != null) && (parama.NIb.length() > 0)) {
        b(parama.NIb, true, parama.NIj);
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
      if (parama.QNw != null) {
        this.QNz = parama.QNw;
      }
      setCancelable(parama.ox);
      this.ox = parama.ox;
      if (!this.ox) {
        super.setCancelable(parama.NIf);
      }
      if ((parama.NIc != null) || (parama.NId != null) || (parama.NIe != null))
      {
        localObject1 = View.inflate(this.mContext, 2131493709, null);
        localObject3 = (Button)((View)localObject1).findViewById(2131304691);
        localObject4 = (Button)((View)localObject1).findViewById(2131304692);
        localObject5 = (Button)((View)localObject1).findViewById(2131304693);
        if (parama.NIc != null)
        {
          ((Button)localObject3).setVisibility(0);
          ((Button)localObject3).setText(parama.NIc);
          ((Button)localObject3).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(159302);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (parama.NIk != null) {
                parama.NIk.onClick(d.this, -1);
              }
              d.this.dismiss();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159302);
            }
          });
        }
        if (parama.NId != null)
        {
          ((Button)localObject4).setVisibility(0);
          ((Button)localObject4).setText(parama.NId);
          ((Button)localObject4).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(159303);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (parama.NIl != null) {
                parama.NIl.onClick(d.this, -2);
              }
              d.this.dismiss();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159303);
            }
          });
        }
        if (parama.NIe != null)
        {
          ((Button)localObject5).setVisibility(0);
          ((Button)localObject5).setText(parama.NIe);
          ((Button)localObject5).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(159304);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (parama.NIm != null) {
                parama.NIm.onClick(d.this, -3);
              }
              d.this.dismiss();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159304);
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
          b(parama.NIb, true, parama.NIj);
        }
        b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
      }
      AppMethodBeat.o(159335);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        Object localObject6;
        this.NIJ.setVisibility(0);
        Object localObject2 = null;
        continue;
        label2234:
        AH(false);
        continue;
        label2458:
        label2593:
        label2607:
        if (parama.NIz)
        {
          localObject2 = parama.NHW;
          localObject4 = parama.NHY;
          localObject3 = parama.NHZ;
          localObject5 = View.inflate(this.mContext, 2131493701, null);
          if (localObject2 != null)
          {
            localObject6 = (ImageView)((View)localObject5).findViewById(2131304705);
            ((ImageView)localObject6).setVisibility(0);
            ((ImageView)localObject6).setImageBitmap((Bitmap)localObject2);
          }
          if (localObject4 != null)
          {
            localObject6 = (TextView)((View)localObject5).findViewById(2131304707);
            ((TextView)localObject6).setVisibility(0);
            localObject2 = localObject4;
            if (this.QNz != null) {
              localObject2 = this.QNz.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
            }
            ((TextView)localObject6).setText((CharSequence)localObject2);
          }
          if (localObject3 != null)
          {
            localObject4 = (TextView)((View)localObject5).findViewById(2131304706);
            ((TextView)localObject4).setVisibility(0);
            if (this.QNz != null)
            {
              localObject2 = this.QNz.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
              ((TextView)localObject4).setText((CharSequence)localObject2);
            }
          }
          else
          {
            aN((View)localObject5, -1);
            continue;
          }
          label2553:
          localObject2 = localException2;
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159326);
    if (this.HRF == null)
    {
      AppMethodBeat.o(159326);
      return;
    }
    this.HRF.setVisibility(0);
    this.HRF.setText(paramCharSequence);
    this.HRF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159300);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(d.this, -1);
        }
        if (paramBoolean) {
          d.this.dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159300);
      }
    });
    AppMethodBeat.o(159326);
  }
  
  public final void ajL(int paramInt)
  {
    AppMethodBeat.i(159327);
    this.HRF.setTextColor(paramInt);
    AppMethodBeat.o(159327);
  }
  
  public final void ajM(int paramInt)
  {
    AppMethodBeat.i(159328);
    this.FNQ.setTextColor(paramInt);
    AppMethodBeat.o(159328);
  }
  
  public final void aoM(int paramInt)
  {
    AppMethodBeat.i(198219);
    if (this.jUu != null) {
      this.jUu.setGravity(paramInt);
    }
    AppMethodBeat.o(198219);
  }
  
  public final void aoN(int paramInt)
  {
    AppMethodBeat.i(198220);
    if (this.NIG != null) {
      this.NIG.setGravity(paramInt);
    }
    AppMethodBeat.o(198220);
  }
  
  public final void ay(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(198221);
    this.mEditText.setVisibility(0);
    this.mEditText.setHint(paramCharSequence);
    AppMethodBeat.o(198221);
  }
  
  public final void b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159331);
    b(com.tencent.mm.ui.e.a.kn(this.mContext).getString(paramInt), true, paramOnClickListener);
    AppMethodBeat.o(159331);
  }
  
  public final void b(final d.a.b paramb)
  {
    AppMethodBeat.i(159323);
    if ((this.NIK != null) && (this.NIK.getVisibility() == 0))
    {
      this.NIK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159298);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (paramb != null) {
            paramb.cXd();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159298);
        }
      });
      AppMethodBeat.o(159323);
      return;
    }
    if (this.NIM != null) {
      this.NIM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159299);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (paramb != null) {
            paramb.cXd();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159299);
        }
      });
    }
    AppMethodBeat.o(159323);
  }
  
  public final void b(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159330);
    if (this.FNQ == null)
    {
      AppMethodBeat.o(159330);
      return;
    }
    this.FNQ.setVisibility(0);
    this.FNQ.setText(paramCharSequence);
    this.FNQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159301);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(d.this, -2);
        }
        if (paramBoolean) {
          d.this.cancel();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159301);
      }
    });
    AppMethodBeat.o(159330);
  }
  
  public final void bT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(198223);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(198223);
      return;
      if (paramBoolean)
      {
        this.HRF.setVisibility(0);
        AppMethodBeat.o(198223);
        return;
      }
      this.HRF.setVisibility(8);
      AppMethodBeat.o(198223);
      return;
      if (paramBoolean)
      {
        this.FNQ.setVisibility(0);
        AppMethodBeat.o(198223);
        return;
      }
      this.FNQ.setVisibility(8);
    }
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(159337);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(159305);
          d.this.dismiss();
          AppMethodBeat.o(159305);
        }
      });
      as.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      AppMethodBeat.o(159337);
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
        AppMethodBeat.o(159337);
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
  
  public final Button getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.HRF;
    }
    return this.FNQ;
  }
  
  public View getContentView()
  {
    return this.NIA;
  }
  
  public final String hbk()
  {
    AppMethodBeat.i(159321);
    if (this.mEditText == null)
    {
      AppMethodBeat.o(159321);
      return null;
    }
    String str = this.mEditText.getText().toString();
    AppMethodBeat.o(159321);
    return str;
  }
  
  public final int hbl()
  {
    AppMethodBeat.i(159322);
    if ((this.mEditText instanceof PasterEditText))
    {
      int i = ((PasterEditText)this.mEditText).getPasterLen();
      AppMethodBeat.o(159322);
      return i;
    }
    AppMethodBeat.o(159322);
    return 0;
  }
  
  public final ImageView hbm()
  {
    return this.NIH;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159315);
    super.onCreate(paramBundle);
    setContentView(this.NIA);
    AppMethodBeat.o(159315);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(159332);
    super.setCancelable(paramBoolean);
    this.ox = paramBoolean;
    setCanceledOnTouchOutside(this.ox);
    AppMethodBeat.o(159332);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159319);
    this.NIK.setVisibility(0);
    this.NIC.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.QNz != null)
    {
      localObject = this.QNz;
      this.NIC.getContext();
      localObject = ((d.a.d)localObject).a(paramCharSequence.toString(), this.NIC.getTextSize());
    }
    this.NIC.setText((CharSequence)localObject);
    AppMethodBeat.o(159319);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159317);
    this.nmr.setVisibility(0);
    this.jUu.setVisibility(0);
    this.jUu.setMaxLines(2);
    this.jUu.setText(paramInt);
    this.jUu.getPaint().setFakeBoldText(true);
    ajJ(this.mContext.getResources().getColor(2131099748));
    AppMethodBeat.o(159317);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159316);
    this.nmr.setVisibility(0);
    this.jUu.setVisibility(0);
    CharSequence localCharSequence = paramCharSequence;
    if (this.QNz != null) {
      localCharSequence = this.QNz.a(paramCharSequence.toString(), this.jUu.getTextSize());
    }
    this.jUu.setMaxLines(2);
    this.jUu.setText(localCharSequence);
    this.jUu.getPaint().setFakeBoldText(true);
    ajJ(this.mContext.getResources().getColor(2131099748));
    AppMethodBeat.o(159316);
  }
  
  public void show()
  {
    AppMethodBeat.i(159336);
    try
    {
      super.show();
      AppMethodBeat.o(159336);
      return;
    }
    catch (Exception localException)
    {
      as.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(159336);
    }
  }
  
  public static final class a
  {
    public a QNF;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159306);
      this.mContext = paramContext;
      this.QNF = new a();
      AppMethodBeat.o(159306);
    }
    
    public final a Di(boolean paramBoolean)
    {
      this.QNF.NIg = paramBoolean;
      return this;
    }
    
    public final a Dj(boolean paramBoolean)
    {
      this.QNF.NHN = paramBoolean;
      return this;
    }
    
    public final a Dk(boolean paramBoolean)
    {
      this.QNF.ox = paramBoolean;
      return this;
    }
    
    public final a Dl(boolean paramBoolean)
    {
      this.QNF.NIf = paramBoolean;
      return this;
    }
    
    public final a a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.QNF.XZ = paramOnDismissListener;
      return this;
    }
    
    public final a a(d paramd)
    {
      this.QNF.QNw = paramd;
      return this;
    }
    
    public final a a(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, c paramc, a parama)
    {
      AppMethodBeat.i(159309);
      this.QNF.NHO = paramString;
      this.QNF.NHP = paramCharSequence;
      this.QNF.NHQ = paramBoolean.booleanValue();
      this.QNF.QNt = paramc;
      this.QNF.QNu = parama;
      AppMethodBeat.o(159309);
      return this;
    }
    
    public final a a(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.QNF.NIi = paramOnClickListener;
      this.QNF.NIx = paramBoolean;
      return this;
    }
    
    public final a aA(CharSequence paramCharSequence)
    {
      this.QNF.NHK = paramCharSequence;
      return this;
    }
    
    public final a aB(CharSequence paramCharSequence)
    {
      this.QNF.NHY = paramCharSequence;
      return this;
    }
    
    public final a aN(Bitmap paramBitmap)
    {
      this.QNF.NHW = paramBitmap;
      return this;
    }
    
    public final a aoO(int paramInt)
    {
      AppMethodBeat.i(159307);
      this.QNF.title = com.tencent.mm.ui.e.a.kn(this.mContext).getString(paramInt);
      AppMethodBeat.o(159307);
      return this;
    }
    
    public final a aoP(int paramInt)
    {
      this.QNF.Kaw = paramInt;
      return this;
    }
    
    public final a aoQ(int paramInt)
    {
      this.QNF.NIp = paramInt;
      return this;
    }
    
    public final a aoR(int paramInt)
    {
      this.QNF.NIs = paramInt;
      return this;
    }
    
    public final a aoS(int paramInt)
    {
      AppMethodBeat.i(159308);
      this.QNF.NHX = com.tencent.mm.ui.e.a.kn(this.mContext).getString(paramInt);
      AppMethodBeat.o(159308);
      return this;
    }
    
    public final a aoT(int paramInt)
    {
      this.QNF.NIq = paramInt;
      return this;
    }
    
    public final a aoU(int paramInt)
    {
      this.QNF.NIr = paramInt;
      return this;
    }
    
    public final a aoV(int paramInt)
    {
      AppMethodBeat.i(159310);
      this.QNF.NIa = com.tencent.mm.ui.e.a.kn(this.mContext).getString(paramInt);
      AppMethodBeat.o(159310);
      return this;
    }
    
    public final a aoW(int paramInt)
    {
      AppMethodBeat.i(159311);
      this.QNF.NIb = com.tencent.mm.ui.e.a.kn(this.mContext).getString(paramInt);
      AppMethodBeat.o(159311);
      return this;
    }
    
    public final a aoX(int paramInt)
    {
      this.QNF.NIw = paramInt;
      return this;
    }
    
    public final a aoY(int paramInt)
    {
      this.QNF.NIv = paramInt;
      return this;
    }
    
    public final a az(CharSequence paramCharSequence)
    {
      this.QNF.title = paramCharSequence;
      return this;
    }
    
    public final a b(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      this.QNF.QNx = paramBitmap;
      this.QNF.NIh = paramBoolean;
      this.QNF.NIt = paramInt;
      return this;
    }
    
    public final a bon(String paramString)
    {
      this.QNF.title = paramString;
      return this;
    }
    
    public final a boo(String paramString)
    {
      this.QNF.NHX = paramString;
      return this;
    }
    
    public final a bop(String paramString)
    {
      this.QNF.NHZ = paramString;
      return this;
    }
    
    public final a boq(String paramString)
    {
      this.QNF.thumbPath = paramString;
      return this;
    }
    
    public final a bor(String paramString)
    {
      this.QNF.NHL = paramString;
      return this;
    }
    
    public final a bos(String paramString)
    {
      this.QNF.NHM = paramString;
      return this;
    }
    
    public final a bot(String paramString)
    {
      this.QNF.QNs = paramString;
      return this;
    }
    
    public final a bou(String paramString)
    {
      this.QNF.NIa = paramString;
      return this;
    }
    
    public final a bov(String paramString)
    {
      this.QNF.NIb = paramString;
      return this;
    }
    
    public final a c(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.QNF.NIi = paramOnClickListener;
      return this;
    }
    
    public final a c(b paramb)
    {
      this.QNF.QNv = paramb;
      return this;
    }
    
    public final a d(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.QNF.NIj = paramOnClickListener;
      return this;
    }
    
    public final a f(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.QNF.XY = paramOnCancelListener;
      return this;
    }
    
    public final d hbn()
    {
      AppMethodBeat.i(159312);
      d locald = new d(this.mContext, (byte)0);
      locald.a(this.QNF);
      AppMethodBeat.o(159312);
      return locald;
    }
    
    public final a hs(View paramView)
    {
      this.QNF.vk = paramView;
      return this;
    }
    
    public final a ht(View paramView)
    {
      this.QNF.NIn = paramView;
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(258310);
      hbn().show();
      AppMethodBeat.o(258310);
    }
    
    public static abstract interface a
    {
      public abstract void C(ImageView paramImageView, String paramString);
    }
    
    public static abstract interface b
    {
      public abstract void cXd();
    }
    
    public static abstract interface c
    {
      public abstract void gpw();
    }
    
    public static abstract interface d
    {
      public abstract CharSequence a(CharSequence paramCharSequence, float paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.d
 * JD-Core Version:    0.7.0.1
 */