package com.tencent.mm.ui.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ci.a.a;
import com.tencent.mm.ci.a.c;
import com.tencent.mm.ci.a.d;
import com.tencent.mm.ci.a.e;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ci.a.h;
import com.tencent.mm.ci.a.j;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;

public class c
  extends Dialog
  implements DialogInterface
{
  CheckBox Ve;
  private boolean fsA;
  private TextView hrg;
  private Button jQx;
  private View la;
  public EditText ln;
  private Context mContext;
  private boolean needEdit = false;
  public Button qFr;
  private LinearLayout uLY;
  public TextView uLZ;
  private TextView uMa;
  public LinearLayout uMb;
  private LinearLayout uMc;
  private ViewStub wmA;
  private ViewGroup wmB;
  private ViewGroup wmC;
  private View wmD;
  private boolean wmE = false;
  private Animation wmF;
  private Animation wmG;
  private Animation wmH;
  private Animation wmI;
  private c.a.d wmJ;
  public DialogInterface.OnDismissListener wmK;
  private TextView wmu;
  private TextView wmv;
  private TextView wmw;
  private ImageView wmx;
  private View wmy;
  private LinearLayout wmz;
  
  public c(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    this.mContext = paramContext;
    this.uLY = ((LinearLayout)View.inflate(this.mContext, a.g.mm_alert_comfirm, null));
    this.qFr = ((Button)this.uLY.findViewById(a.f.mm_alert_ok_btn));
    this.jQx = ((Button)this.uLY.findViewById(a.f.mm_alert_cancel_btn));
    this.hrg = ((TextView)this.uLY.findViewById(a.f.mm_alert_title));
    this.wmu = ((TextView)this.uLY.findViewById(a.f.mm_alert_title_desc));
    this.uLZ = ((TextView)this.uLY.findViewById(a.f.mm_alert_msg));
    this.uMa = ((TextView)this.uLY.findViewById(a.f.mm_alert_msg_subtitle));
    this.wmv = ((TextView)this.uLY.findViewById(a.f.mm_alert_msg_subdesc));
    this.wmw = ((TextView)this.uLY.findViewById(a.f.confirm_dialog_content_desc_tv));
    this.ln = ((EditText)this.uLY.findViewById(a.f.confirm_dialog_text_et));
    this.Ve = ((CheckBox)this.uLY.findViewById(a.f.confirm_dialog_checkbox));
    this.wmx = ((ImageView)this.uLY.findViewById(a.f.mm_alert_msg_icon));
    this.wmz = ((LinearLayout)this.uLY.findViewById(a.f.mm_alert_title_area));
    this.wmA = ((ViewStub)this.uLY.findViewById(a.f.title_image_ll));
    this.uMb = ((LinearLayout)this.uLY.findViewById(a.f.mm_alert_msg_area));
    this.wmB = ((ViewGroup)this.uLY.findViewById(a.f.mm_alert_bottom_view));
    this.wmD = this.uLY.findViewById(a.f.mm_alert_button_view);
    this.uMc = ((LinearLayout)this.uLY.findViewById(a.f.mm_alert_custom_area));
    this.wmC = ((ViewGroup)this.uLY.findViewById(a.f.title_image_detail_area));
    setCanceledOnTouchOutside(true);
    this.wmF = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_in);
    this.wmG = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_in);
    this.wmH = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_out);
    this.wmI = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_out);
  }
  
  private void FO(int paramInt)
  {
    if (this.uLZ != null) {
      this.uLZ.setTextColor(this.uLZ.getContext().getResources().getColor(paramInt));
    }
  }
  
  private void Im(int paramInt)
  {
    if (this.uMb != null) {
      this.uMb.setVisibility(paramInt);
    }
    if (this.uMc != null) {
      this.uMc.setVisibility(paramInt);
    }
    if ((this.wmw != null) && (this.wmE)) {
      this.wmw.setVisibility(paramInt);
    }
    if (this.ln != null)
    {
      if (!this.needEdit) {
        this.ln.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.ln.setVisibility(paramInt);
  }
  
  private void Z(View paramView, int paramInt)
  {
    this.la = paramView;
    if (this.la != null)
    {
      this.uMb.setVisibility(0);
      this.uMc.setVisibility(0);
      this.uMc.removeAllViews();
      this.uMc.setGravity(1);
      this.uMc.addView(this.la, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
  }
  
  private void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.wmD.setVisibility(8);
    this.wmB.removeAllViews();
    this.wmB.addView(paramView, paramLayoutParams);
  }
  
  private void nS(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = ap.fromDPToPix(this.mContext, 8);
      this.uMb.setVisibility(0);
      this.uMb.setPadding(i, i, i, i);
      this.uMb.setBackgroundResource(a.e.dialog_content_background);
    }
  }
  
  public final void In(int paramInt)
  {
    this.qFr.setTextColor(paramInt);
  }
  
  public final void Io(int paramInt)
  {
    this.jQx.setTextColor(paramInt);
  }
  
  public final void a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    a(this.mContext.getString(paramInt), true, paramOnClickListener);
  }
  
  public final void a(a parama)
  {
    if ((parama.title != null) && (parama.title.length() > 0)) {
      setTitle(parama.title);
    }
    Object localObject3;
    Object localObject1;
    if ((parama.wlB != null) && (parama.wlB.length() > 0))
    {
      localObject3 = parama.wlB;
      this.wmz.setVisibility(0);
      this.wmu.setVisibility(0);
      localObject1 = localObject3;
      if (this.wmJ != null) {
        localObject1 = this.wmJ.c(((CharSequence)localObject3).toString(), this.hrg.getTextSize());
      }
      this.wmu.setText((CharSequence)localObject1);
    }
    int i;
    if (parama.rYa != 0)
    {
      i = parama.rYa;
      this.hrg.setTextColor(ColorStateList.valueOf(i));
    }
    if (parama.wmj != 0)
    {
      i = parama.wmj;
      this.hrg.setMaxLines(i);
    }
    if (parama.wmk != 0)
    {
      i = parama.wmk;
      this.uLZ.setMaxLines(i);
    }
    if (parama.rod != null) {
      Z(parama.rod, -1);
    }
    if (parama.wmh != null)
    {
      localObject3 = parama.wmh;
      this.wmz.setVisibility(0);
      this.wmA.setLayoutResource(a.g.confirm_dialog_custom_title);
    }
    try
    {
      localObject1 = (LinearLayout)this.wmA.inflate();
      ((LinearLayout)localObject1).addView((View)localObject3);
      if (parama.wmi != null)
      {
        this.wmy = parama.wmi;
        if (this.wmy != null)
        {
          this.uMb.setVisibility(8);
          this.wmw.setVisibility(8);
          this.ln.setVisibility(8);
          this.wmC.removeAllViews();
          this.wmC.addView(this.wmy, new LinearLayout.LayoutParams(-1, -1));
          this.wmC.setVisibility(8);
        }
      }
      if (parama.wlO != null)
      {
        localObject1 = parama.wlO;
        if (this.la == null)
        {
          this.uMb.setVisibility(0);
          this.wmx.setVisibility(0);
          this.wmx.setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if ((parama.wlR != null) && (parama.wlR.length() > 0)) {
        setMessage(parama.wlR);
      }
      nS(parama.wma);
      if (parama.thumbPath != null)
      {
        localObject1 = parama.thumbPath;
        i = ap.fromDPToPix(this.mContext, 120);
        this.uMb.setVisibility(0);
        this.wmx.setVisibility(0);
        if ((this.wmx instanceof com.tencent.mm.ui.e.a)) {
          ((com.tencent.mm.ui.e.a)this.wmx).ah((String)localObject1, i, i);
        }
        i = parama.wmn;
        this.uMb.setVisibility(i);
        this.wmx.setVisibility(i);
      }
      if ((!parama.wmr) && (!parama.wms))
      {
        if ((parama.wlR != null) && (parama.wlR.length() > 0)) {
          setMessage(parama.wlR);
        }
        if ((parama.wlS == null) || (parama.wlS.length() <= 0)) {
          break label2304;
        }
        localObject1 = parama.wlS;
        this.uMb.setVisibility(0);
        this.uMa.setVisibility(0);
        this.uMa.setMaxLines(2);
        this.uMa.setText((CharSequence)localObject1);
        if ((parama.wlT != null) && (parama.wlT.length() > 0))
        {
          localObject3 = parama.wlT;
          if (localObject3 != null)
          {
            this.uMb.setVisibility(0);
            this.wmv.setVisibility(0);
            localObject1 = localObject3;
            if (this.wmJ != null)
            {
              localObject1 = this.wmJ;
              this.wmv.getContext();
              localObject1 = ((c.a.d)localObject1).c(((CharSequence)localObject3).toString(), this.wmv.getTextSize());
            }
            this.wmv.setText((CharSequence)localObject1);
          }
        }
        if (parama.wlP != null)
        {
          localObject1 = parama.wlP;
          if (this.la == null)
          {
            this.uMb.setVisibility(0);
            this.wmx.setVisibility(0);
            this.wmx.setImageBitmap((Bitmap)localObject1);
          }
        }
      }
      boolean bool;
      if (parama.wmr)
      {
        localObject1 = parama.wlP;
        localObject4 = parama.wlS;
        localObject3 = parama.wlT;
        localObject5 = View.inflate(this.mContext, a.g.confirm_dialog_icon_left, null);
        if (localObject1 != null)
        {
          localObject6 = (ImageView)((View)localObject5).findViewById(a.f.mm_alert_msg_icon);
          ((ImageView)localObject6).setVisibility(0);
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
        }
        if (localObject4 != null)
        {
          localObject6 = (TextView)((View)localObject5).findViewById(a.f.mm_alert_msg_subtitle);
          ((TextView)localObject6).setVisibility(0);
          localObject1 = localObject4;
          if (this.wmJ != null) {
            localObject1 = this.wmJ.c(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
          }
          ((TextView)localObject6).setText((CharSequence)localObject1);
        }
        if (localObject3 != null)
        {
          localObject4 = (TextView)((View)localObject5).findViewById(a.f.mm_alert_msg_subdesc);
          ((TextView)localObject4).setVisibility(0);
          if (this.wmJ == null) {
            break label2901;
          }
          localObject1 = this.wmJ.c(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        Z((View)localObject5, -1);
        if ((parama.wlG != null) || (parama.wlH != null))
        {
          localObject6 = parama.wlG;
          localObject4 = parama.wlH;
          bool = parama.wlI;
          localObject5 = parama.wlK;
          localObject7 = parama.wlL;
          this.wmA.setLayoutResource(a.g.confirm_dialog_title_image);
          localObject1 = null;
        }
      }
      try
      {
        localObject3 = (LinearLayout)this.wmA.inflate();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i2;
          int j;
          float f;
          int m;
          int k;
          int i1;
          int n;
          this.wmA.setVisibility(0);
          continue;
          if (this.uMc != null)
          {
            this.uMc.setOnClickListener(new c.3(this, (c.a.b)localObject2));
            continue;
            if ((f >= 0.5D) && (f < 1.0F))
            {
              m = (int)(i * f);
              j = m;
              k = i;
              n = i;
            }
            else if ((f >= 1.0F) && (f < 2.0F))
            {
              n = (int)(i / f);
              j = i;
              k = n;
              m = i;
            }
            else if (f >= 2.0F)
            {
              m = (int)(i1 * f);
              k = i1;
              n = i1;
              j = i;
              continue;
              localBitmap = am.b(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
              if (localBitmap == null)
              {
                localObject2 = null;
              }
              else
              {
                localObject4 = new Canvas(localBitmap);
                localObject7 = new Paint();
                Rect localRect = new Rect(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
                RectF localRectF = new RectF(localRect);
                ((Paint)localObject7).setAntiAlias(true);
                ((Paint)localObject7).setDither(true);
                ((Paint)localObject7).setFilterBitmap(true);
                ((Canvas)localObject4).drawARGB(0, 0, 0, 0);
                ((Paint)localObject7).setColor(-4144960);
                ((Canvas)localObject4).drawRoundRect(localRectF, f, f, (Paint)localObject7);
                ((Paint)localObject7).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                ((Canvas)localObject4).drawBitmap((Bitmap)localObject2, localRect, localRect, (Paint)localObject7);
                ao.t("getRoundedCornerBitmap bitmap recycle %s", new Object[] { localObject2 });
                ((Bitmap)localObject2).recycle();
                localObject2 = localBitmap;
                continue;
                ((ImageView)localObject2).setVisibility(0);
                if (i2 == 1)
                {
                  ((ImageView)localObject2).setImageResource(a.h.sight_icon_in_gird);
                }
                else if (i2 == 2)
                {
                  ((ImageView)localObject2).setImageResource(a.h.video_icon_in_gird);
                  continue;
                  this.ln.setVisibility(8);
                  continue;
                  localObject2 = localBitmap;
                  continue;
                  localObject2 = localBitmap;
                }
              }
            }
          }
        }
      }
      if ((localObject1 != null) && (localObject6 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(a.f.title_image);
        ((ImageView)localObject3).setVisibility(0);
        if (localObject7 != null) {
          ((c.a.a)localObject7).q((ImageView)localObject3, (String)localObject6);
        }
      }
      if ((localObject1 != null) && (localObject4 != null))
      {
        localObject6 = (TextView)((LinearLayout)localObject1).findViewById(a.f.title_text);
        ((TextView)localObject6).setVisibility(0);
        localObject3 = localObject4;
        if (this.wmJ != null) {
          localObject3 = this.wmJ.c(((CharSequence)localObject4).toString(), this.hrg.getTextSize());
        }
        ((TextView)localObject6).setText((CharSequence)localObject3);
      }
      if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(a.f.image_title_detail_icon);
        ((ImageView)localObject3).setVisibility(0);
        Im(0);
        ((LinearLayout)localObject1).setOnClickListener(new c.1(this, (c.a.c)localObject5, (ImageView)localObject3));
      }
      if (parama.wlM != null)
      {
        localObject1 = parama.wlM;
        if ((this.uMb != null) && (this.uMb.getVisibility() == 0)) {
          this.uMb.setOnClickListener(new c.2(this, (c.a.b)localObject1));
        }
      }
      else
      {
        if ((parama.wlQ != null) && (!parama.wlQ.isRecycled()))
        {
          localObject3 = parama.wlQ;
          bool = parama.wmb;
          i2 = parama.wmm;
          if (localObject3 != null)
          {
            nS(false);
            this.uMb.setVisibility(0);
            this.uMb.setGravity(1);
            this.uMb.setPadding(0, 0, 0, 0);
            localObject5 = View.inflate(this.mContext, a.g.confirm_dialog_image_center, null);
            localObject6 = (ImageView)((View)localObject5).findViewById(a.f.mm_alert_msg_icon);
            if (!bool) {
              break label2887;
            }
            i = ((Bitmap)localObject3).getWidth();
            j = ((Bitmap)localObject3).getHeight();
            localObject4 = null;
            f = j / i;
            m = 0;
            k = 0;
            i1 = ap.ab(this.mContext, a.d.DialogBigImageMinHeight);
            i = ap.ab(this.mContext, a.d.DialogBigImageMaxHeight);
            n = 0;
            j = 0;
            if ((f <= 0.0F) || (f >= 0.5D)) {
              break label2557;
            }
            k = (int)(i1 / f);
            j = i1;
            m = i1;
            n = i;
            localObject1 = localObject4;
            if (m > 0)
            {
              localObject1 = localObject4;
              if (k > 0)
              {
                localObject1 = localObject4;
                if (localObject3 != null)
                {
                  localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, k, m, true);
                  ((ImageView)localObject6).setLayoutParams(new FrameLayout.LayoutParams(n, j));
                }
              }
            }
            f = ap.fromDPToPix(this.mContext, 3);
            if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
              break label2652;
            }
            ao.v("getRoundedCornerBitmap in bitmap is null", new Object[0]);
            localObject1 = null;
            ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
            localObject1 = (ImageView)((View)localObject5).findViewById(a.f.image_status_icon);
            if (i2 != 0) {
              break label2835;
            }
            ((ImageView)localObject1).setVisibility(8);
            Z((View)localObject5, -2);
          }
        }
        if ((parama.wlC != null) && (parama.wlC.length() > 0))
        {
          localObject1 = parama.wlC;
          if (localObject1 != null)
          {
            this.wmw.setVisibility(0);
            this.wmw.setText((CharSequence)localObject1);
          }
          this.wmE = true;
          i = parama.wml;
          if (this.wmw != null) {
            this.wmw.setGravity(i);
          }
        }
        if ((parama.wlD != null) && (parama.wlD.length() > 0))
        {
          localObject1 = parama.wlD;
          this.ln.setVisibility(0);
          this.ln.setHint((CharSequence)localObject1);
        }
        if ((parama.wlE != null) && (parama.wlE.length() > 0))
        {
          localObject1 = parama.wlE;
          this.Ve.setVisibility(0);
          this.Ve.setText((CharSequence)localObject1);
        }
        if (parama.wlF)
        {
          this.needEdit = parama.wlF;
          if (!parama.wlF) {
            break label2875;
          }
          this.ln.setVisibility(0);
        }
        if ((parama.wlU != null) && (parama.wlU.length() > 0)) {
          a(parama.wlU, parama.wmq, parama.wmc);
        }
        if ((parama.wlV != null) && (parama.wlV.length() > 0)) {
          b(parama.wlV, true, parama.wmd);
        }
        if (parama.wmp != 0) {
          In(parama.wmp);
        }
        if (parama.wmo != 0) {
          Io(parama.wmo);
        }
        if (parama.Oi != null) {
          setOnCancelListener(parama.Oi);
        }
        if (parama.Oj != null)
        {
          this.wmK = parama.Oj;
          setOnDismissListener(parama.Oj);
        }
        if (parama.wlN != null) {
          this.wmJ = parama.wlN;
        }
        setCancelable(parama.fsA);
        this.fsA = parama.fsA;
        if (!this.fsA) {
          super.setCancelable(parama.wlZ);
        }
        if ((parama.wlW != null) || (parama.wlX != null) || (parama.wlY != null))
        {
          localObject1 = View.inflate(this.mContext, a.g.confirm_dialog_multi_btn, null);
          localObject3 = (Button)((View)localObject1).findViewById(a.f.mm_alert_btn_first);
          localObject4 = (Button)((View)localObject1).findViewById(a.f.mm_alert_btn_second);
          localObject5 = (Button)((View)localObject1).findViewById(a.f.mm_alert_btn_third);
          if (parama.wlW != null)
          {
            ((Button)localObject3).setVisibility(0);
            ((Button)localObject3).setText(parama.wlW);
            ((Button)localObject3).setOnClickListener(new c.6(this, parama));
          }
          if (parama.wlX != null)
          {
            ((Button)localObject4).setVisibility(0);
            ((Button)localObject4).setText(parama.wlX);
            ((Button)localObject4).setOnClickListener(new c.7(this, parama));
          }
          if (parama.wlY != null)
          {
            ((Button)localObject5).setVisibility(0);
            ((Button)localObject5).setText(parama.wlY);
            ((Button)localObject5).setOnClickListener(new c.8(this, parama));
          }
          a((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
        }
        if (parama.wlJ)
        {
          localObject1 = View.inflate(this.mContext, a.g.confirm_dialog_btn_up_down, null);
          this.jQx = ((Button)((View)localObject1).findViewById(a.f.mm_alert_cancel_btn));
          this.qFr = ((Button)((View)localObject1).findViewById(a.f.mm_alert_ok_btn));
          if (parama.wmp != 0) {
            In(parama.wmp);
          }
          if (parama.wmo != 0) {
            Io(parama.wmo);
          }
          if ((parama.wlU != null) && (parama.wlU.length() > 0)) {
            a(parama.wlU, parama.wmq, parama.wmc);
          }
          if ((parama.wlV != null) && (parama.wlV.length() > 0)) {
            b(parama.wlV, true, parama.wmd);
          }
          a((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
        }
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        Object localObject6;
        Object localObject7;
        this.wmA.setVisibility(0);
        Object localObject2 = null;
        continue;
        label2304:
        nS(false);
        continue;
        label2835:
        label2875:
        label2887:
        label2901:
        if (parama.wms)
        {
          localObject2 = parama.wlP;
          localObject4 = parama.wlS;
          localObject3 = parama.wlT;
          localObject5 = View.inflate(this.mContext, a.g.confirm_dialog_icon_right, null);
          if (localObject2 != null)
          {
            localObject6 = (ImageView)((View)localObject5).findViewById(a.f.mm_alert_msg_icon);
            ((ImageView)localObject6).setVisibility(0);
            ((ImageView)localObject6).setImageBitmap((Bitmap)localObject2);
          }
          if (localObject4 != null)
          {
            localObject6 = (TextView)((View)localObject5).findViewById(a.f.mm_alert_msg_subtitle);
            ((TextView)localObject6).setVisibility(0);
            localObject2 = localObject4;
            if (this.wmJ != null) {
              localObject2 = this.wmJ.c(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
            }
            ((TextView)localObject6).setText((CharSequence)localObject2);
          }
          if (localObject3 != null)
          {
            localObject4 = (TextView)((View)localObject5).findViewById(a.f.mm_alert_msg_subdesc);
            ((TextView)localObject4).setVisibility(0);
            if (this.wmJ != null)
            {
              localObject2 = this.wmJ.c(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
              ((TextView)localObject4).setText((CharSequence)localObject2);
            }
          }
          else
          {
            Z((View)localObject5, -1);
            continue;
          }
          label2557:
          Bitmap localBitmap;
          label2652:
          localObject2 = localBitmap;
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (this.qFr == null) {
      return;
    }
    this.qFr.setVisibility(0);
    this.qFr.setText(paramCharSequence);
    this.qFr.setOnClickListener(new c.4(this, paramOnClickListener, paramBoolean));
  }
  
  public final void b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    b(this.mContext.getString(paramInt), true, paramOnClickListener);
  }
  
  public final void b(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (this.jQx == null) {
      return;
    }
    this.jQx.setVisibility(0);
    this.jQx.setText(paramCharSequence);
    this.jQx.setOnClickListener(new c.5(this, paramOnClickListener, paramBoolean));
  }
  
  public final String cKe()
  {
    if (this.ln == null) {
      return null;
    }
    return this.ln.getText().toString();
  }
  
  public void dismiss()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new c.9(this));
      ao.v("dialog dismiss error!", new Object[0]);
      return;
    }
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      ao.v("dismiss exception, e = " + localException.getMessage(), new Object[0]);
    }
  }
  
  public final Button getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.qFr;
    }
    return this.jQx;
  }
  
  public View getContentView()
  {
    return this.uLY;
  }
  
  public final void nT(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.uLY);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    this.fsA = paramBoolean;
    setCanceledOnTouchOutside(this.fsA);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    this.uMb.setVisibility(0);
    this.uLZ.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.wmJ != null)
    {
      localObject = this.wmJ;
      this.uLZ.getContext();
      localObject = ((c.a.d)localObject).c(paramCharSequence.toString(), this.uLZ.getTextSize());
    }
    this.uLZ.setText((CharSequence)localObject);
  }
  
  public void setTitle(int paramInt)
  {
    this.wmz.setVisibility(0);
    this.hrg.setVisibility(0);
    this.hrg.setMaxLines(2);
    this.hrg.setText(paramInt);
    FO(a.c.dialog_msg_color);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.wmz.setVisibility(0);
    this.hrg.setVisibility(0);
    CharSequence localCharSequence = paramCharSequence;
    if (this.wmJ != null) {
      localCharSequence = this.wmJ.c(paramCharSequence.toString(), this.hrg.getTextSize());
    }
    this.hrg.setMaxLines(2);
    this.hrg.setText(localCharSequence);
    FO(a.c.dialog_msg_color);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      ao.a(localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.c
 * JD-Core Version:    0.7.0.1
 */