package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.picker.a.d;
import com.tencent.mm.ui.widget.picker.d.g;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class h
  extends a
  implements View.OnClickListener
{
  j Lbi;
  boolean Lbj;
  private String TAG;
  private Context context;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(192712);
    this.TAG = "TimePickerView";
    this.Lbj = false;
    this.Lbi = new j(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(192712);
  }
  
  public final void a(com.tencent.mm.ui.widget.picker.c.a parama)
  {
    AppMethodBeat.i(192713);
    this.Lax = parama;
    Object localObject5 = parama.context;
    aQa();
    aPX();
    aPY();
    LayoutInflater.from((Context)localObject5).inflate(2131496156, this.iLP);
    Object localObject1 = (TextView)findViewById(2131306103);
    Object localObject2 = (RelativeLayout)findViewById(2131304274);
    Object localObject3 = (Button)findViewById(2131297582);
    Object localObject4 = (Button)findViewById(2131297577);
    ((Button)localObject3).setTag("submit");
    ((Button)localObject4).setTag("cancel");
    ((Button)localObject3).setOnClickListener(this);
    ((Button)localObject4).setOnClickListener(this);
    label167:
    label189:
    int i;
    label482:
    int j;
    int k;
    label563:
    label638:
    int i1;
    int n;
    int m;
    if (TextUtils.isEmpty(this.Lax.iLB))
    {
      parama = ((Context)localObject5).getResources().getString(2131761930);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.Lax.iLC)) {
        break label1327;
      }
      parama = ((Context)localObject5).getResources().getString(2131761924);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.Lax.iLD)) {
        break label1338;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.Lax.iLE);
      ((Button)localObject4).setTextColor(this.Lax.iLF);
      ((TextView)localObject1).setTextColor(this.Lax.iLG);
      ((RelativeLayout)localObject2).setBackgroundColor(this.Lax.iLI);
      ((Button)localObject3).setTextSize(this.Lax.iLJ);
      ((Button)localObject4).setTextSize(this.Lax.iLJ);
      ((TextView)localObject1).setTextSize(this.Lax.iLK);
      parama = this.Lbi;
      localObject1 = this.Lax.iLp;
      i = this.Lax.iLA;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.iLp = ((boolean[])localObject1);
      parama.gravity = i;
      if (this.Lax.Lck != null) {
        this.Lbi.Lbx = new com.tencent.mm.ui.widget.picker.d.a()
        {
          public final void aPW()
          {
            AppMethodBeat.i(192711);
            try
            {
              j.iMi.parse(h.a(h.this).aQi());
              h.this.Lax.Lck.fMK();
              AppMethodBeat.o(192711);
              return;
            }
            catch (ParseException localParseException)
            {
              ap.printErrStackTrace(h.b(h.this), localParseException, "", new Object[0]);
              AppMethodBeat.o(192711);
            }
          }
        };
      }
      if ((this.Lax.startYear != 0) && (this.Lax.endYear != 0) && (this.Lax.startYear <= this.Lax.endYear))
      {
        this.Lbi.startYear = this.Lax.startYear;
        this.Lbi.endYear = this.Lax.endYear;
      }
      if ((this.Lax.iLr == null) || (this.Lax.iLs == null)) {
        break label1349;
      }
      if (this.Lax.iLr.getTimeInMillis() > this.Lax.iLs.getTimeInMillis())
      {
        ap.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null", new Object[0]);
        this.Lax.iLr = null;
      }
      parama = this.Lbi;
      localObject1 = this.Lax.iLr;
      localObject2 = this.Lax.iLs;
      if ((localObject1 != null) || (localObject2 == null)) {
        break label1524;
      }
      i = ((Calendar)localObject2).get(1);
      j = ((Calendar)localObject2).get(2) + 1;
      k = ((Calendar)localObject2).get(5);
      if (i <= parama.startYear) {
        break label1453;
      }
      parama.endYear = i;
      parama.iMq = j;
      parama.iMs = k;
      if (!this.Lbj)
      {
        if ((this.Lax.iLr == null) || (this.Lax.iLs == null)) {
          break label1818;
        }
        if ((this.Lax.iLq != null) && (this.Lax.iLq.getTimeInMillis() >= this.Lax.iLr.getTimeInMillis())) {
          break label1777;
        }
        this.Lax.iLq = this.Lax.iLr;
      }
      if (this.Lax.iLq != null) {
        break label1872;
      }
      parama = Calendar.getInstance();
      parama.setTimeInMillis(System.currentTimeMillis());
      i = parama.get(1);
      i1 = parama.get(2);
      n = parama.get(5);
      m = parama.get(11);
      k = parama.get(12);
      j = parama.get(13);
      label702:
      parama = this.Lbi;
      parama.iMx = i;
      parama.Lbo = ((WheelView)parama.view.findViewById(2131307138));
      parama.Lbp = ((WheelView)parama.view.findViewById(2131302450));
      parama.Lbq = ((WheelView)parama.view.findViewById(2131298935));
      parama.Lbu = new com.tencent.mm.ui.widget.picker.a.f(parama.startYear, parama.endYear, parama.ctx);
      parama.Lbo.setAdapter(parama.Lbu);
      parama.Lbo.setCurrentItem(i - parama.startYear);
      parama.Lbo.setGravity(parama.gravity);
      if (parama.startYear != parama.endYear) {
        break label1954;
      }
      parama.Lbp.setAdapter(new d(parama.iMp, parama.iMq, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
      parama.Lbp.setCurrentItem(i1 + 1 - parama.iMp);
      label881:
      parama.Lbp.setGravity(parama.gravity);
      if (!parama.Lbv) {
        break label3660;
      }
    }
    label1327:
    label1338:
    label1349:
    label3270:
    label3660:
    for (int i2 = i - 1;; i2 = i)
    {
      if ((parama.startYear == parama.endYear) && (parama.iMp == parama.iMq)) {
        if (parama.iMB.contains(String.valueOf(i1 + 1)))
        {
          if (parama.iMs > 31) {
            parama.iMs = 31;
          }
          parama.Lbq.setAdapter(new d(parama.iMr, parama.iMs));
          label982:
          parama.Lbq.setCurrentItem(n - parama.iMr);
          parama.Lbq.setGravity(parama.gravity);
          parama.Lbr = ((WheelView)parama.view.findViewById(2131300765));
          parama.Lbr.setAdapter(new d(parama.iMt, parama.iMv));
          parama.Lbr.setCurrentItem(m - parama.iMt);
          parama.Lbr.setGravity(parama.gravity);
          parama.Lbs = ((WheelView)parama.view.findViewById(2131302275));
          if ((m != parama.iMt) || (parama.iMt != parama.iMv)) {
            break label2949;
          }
          parama.Lbs.setAdapter(new d(parama.iMu, parama.iMw));
          if (k >= parama.iMu) {
            break label2914;
          }
          parama.Lbs.setCurrentItem(0);
        }
      }
      for (;;)
      {
        parama.Lbs.setGravity(parama.gravity);
        parama.Lbt = ((WheelView)parama.view.findViewById(2131304457));
        parama.Lbt.setAdapter(new d(0, 59));
        parama.Lbt.setCurrentItem(j);
        parama.Lbt.setGravity(parama.gravity);
        parama.Lbr.setOnItemSelectedListener(new j.3(parama));
        parama.Lbo.setOnItemSelectedListener(new j.2(parama));
        parama.Lbp.setOnItemSelectedListener(new j.1(parama));
        parama.a(parama.Lbq);
        parama.a(parama.Lbr);
        parama.a(parama.Lbs);
        parama.a(parama.Lbt);
        if (parama.iLp.length == 6) {
          break label3107;
        }
        parama = new IllegalArgumentException("type[] length is not 6");
        AppMethodBeat.o(192713);
        throw parama;
        parama = this.Lax.iLB;
        break;
        parama = this.Lax.iLC;
        break label167;
        parama = this.Lax.iLD;
        break label189;
        if (this.Lax.iLr != null)
        {
          if (this.Lax.iLr.get(1) >= 1900) {
            break label482;
          }
          ap.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null", new Object[0]);
          this.Lax.iLr = null;
          break label482;
        }
        if ((this.Lax.iLs == null) || (this.Lax.iLs.get(1) <= 2100)) {
          break label482;
        }
        ap.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null", new Object[0]);
        this.Lax.iLr = null;
        break label482;
        if (i != parama.startYear) {
          break label563;
        }
        if (j > parama.iMp)
        {
          parama.endYear = i;
          parama.iMq = j;
          parama.iMs = k;
          break label563;
        }
        if ((j != parama.iMp) || (k <= parama.iMr)) {
          break label563;
        }
        parama.endYear = i;
        parama.iMq = j;
        parama.iMs = k;
        break label563;
        label1524:
        if ((localObject1 != null) && (localObject2 == null))
        {
          i = ((Calendar)localObject1).get(1);
          j = ((Calendar)localObject1).get(2) + 1;
          k = ((Calendar)localObject1).get(5);
          if (i < parama.endYear)
          {
            parama.iMp = j;
            parama.iMr = k;
            parama.startYear = i;
            break label563;
          }
          if (i != parama.endYear) {
            break label563;
          }
          if (j < parama.iMq)
          {
            parama.iMp = j;
            parama.iMr = k;
            parama.startYear = i;
            break label563;
          }
          if ((j != parama.iMq) || (k >= parama.iMs)) {
            break label563;
          }
          parama.iMp = j;
          parama.iMr = k;
          parama.startYear = i;
          break label563;
        }
        if ((localObject1 == null) || (localObject2 == null)) {
          break label563;
        }
        parama.startYear = ((Calendar)localObject1).get(1);
        parama.endYear = ((Calendar)localObject2).get(1);
        parama.iMp = (((Calendar)localObject1).get(2) + 1);
        parama.iMq = (((Calendar)localObject2).get(2) + 1);
        parama.iMr = ((Calendar)localObject1).get(5);
        parama.iMs = ((Calendar)localObject2).get(5);
        parama.iMt = ((Calendar)localObject1).get(11);
        parama.iMu = ((Calendar)localObject1).get(12);
        parama.iMv = ((Calendar)localObject2).get(11);
        parama.iMw = ((Calendar)localObject2).get(12);
        break label563;
        label1777:
        if (this.Lax.iLq.getTimeInMillis() <= this.Lax.iLs.getTimeInMillis()) {
          break label638;
        }
        this.Lax.iLq = this.Lax.iLs;
        break label638;
        if (this.Lax.iLr != null)
        {
          this.Lax.iLq = this.Lax.iLr;
          break label638;
        }
        if (this.Lax.iLs == null) {
          break label638;
        }
        this.Lax.iLq = this.Lax.iLs;
        break label638;
        label1872:
        i = this.Lax.iLq.get(1);
        i1 = this.Lax.iLq.get(2);
        n = this.Lax.iLq.get(5);
        m = this.Lax.iLq.get(11);
        k = this.Lax.iLq.get(12);
        j = this.Lax.iLq.get(13);
        break label702;
        if (i == parama.startYear)
        {
          parama.Lbp.setAdapter(new d(parama.iMp, 12, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
          parama.Lbp.setCurrentItem(i1 + 1 - parama.iMp);
          break label881;
        }
        if (i == parama.endYear)
        {
          parama.Lbp.setAdapter(new d(1, parama.iMq, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
          parama.Lbp.setCurrentItem(i1);
          break label881;
        }
        if ((parama.Lbv) && (i - 1 == parama.startYear))
        {
          parama.Lbp.setAdapter(new d(parama.iMp, 12, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
          parama.Lbp.setCurrentItem(i1 + 1 - parama.iMp);
          break label881;
        }
        parama.Lbp.setAdapter(new d(1, 12, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
        parama.Lbp.setCurrentItem(i1);
        break label881;
        if (parama.iMC.contains(String.valueOf(i1 + 1)))
        {
          if (parama.iMs > 30) {
            parama.iMs = 30;
          }
          parama.Lbq.setAdapter(new d(parama.iMr, parama.iMs));
          break label982;
        }
        if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
        {
          if (parama.iMs > 29) {
            parama.iMs = 29;
          }
          parama.Lbq.setAdapter(new d(parama.iMr, parama.iMs));
          break label982;
        }
        if (parama.iMs > 28) {
          parama.iMs = 28;
        }
        parama.Lbq.setAdapter(new d(parama.iMr, parama.iMs));
        break label982;
        if ((i2 == parama.startYear) && (i1 + 1 == parama.iMp))
        {
          if (parama.iMB.contains(String.valueOf(i1 + 1))) {
            parama.Lbq.setAdapter(new d(parama.iMr, 31));
          }
          for (;;)
          {
            parama.Lbq.setCurrentItem(n - parama.iMr);
            break;
            if (parama.iMC.contains(String.valueOf(i1 + 1))) {
              parama.Lbq.setAdapter(new d(parama.iMr, 30));
            } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
              parama.Lbq.setAdapter(new d(parama.iMr, 29));
            } else {
              parama.Lbq.setAdapter(new d(parama.iMr, 28));
            }
          }
        }
        if ((i2 == parama.endYear) && (i1 + 1 == parama.iMq))
        {
          if (parama.iMB.contains(String.valueOf(i1 + 1)))
          {
            if (parama.iMs > 31) {
              parama.iMs = 31;
            }
            parama.Lbq.setAdapter(new d(1, parama.iMs));
          }
          for (;;)
          {
            parama.Lbq.setCurrentItem(n - 1);
            break;
            if (parama.iMC.contains(String.valueOf(i1 + 1)))
            {
              if (parama.iMs > 30) {
                parama.iMs = 30;
              }
              parama.Lbq.setAdapter(new d(1, parama.iMs));
            }
            else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
            {
              if (parama.iMs > 29) {
                parama.iMs = 29;
              }
              parama.Lbq.setAdapter(new d(1, parama.iMs));
            }
            else
            {
              if (parama.iMs > 28) {
                parama.iMs = 28;
              }
              parama.Lbq.setAdapter(new d(1, parama.iMs));
            }
          }
        }
        if (parama.iMB.contains(String.valueOf(i1 + 1))) {
          parama.Lbq.setAdapter(new d(1, 31));
        }
        for (;;)
        {
          parama.Lbq.setCurrentItem(n - 1);
          break;
          if (parama.iMC.contains(String.valueOf(i1 + 1))) {
            parama.Lbq.setAdapter(new d(1, 30));
          } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
            parama.Lbq.setAdapter(new d(1, 29));
          } else {
            parama.Lbq.setAdapter(new d(1, 28));
          }
        }
        label2914:
        if (k > parama.iMw)
        {
          parama.Lbs.setCurrentItem(parama.iMw);
        }
        else
        {
          parama.Lbs.setCurrentItem(k);
          continue;
          if (m == parama.iMt)
          {
            parama.Lbs.setAdapter(new d(parama.iMu, 59));
            if (k < parama.iMu) {
              parama.Lbs.setCurrentItem(0);
            } else {
              parama.Lbs.setCurrentItem(k - parama.iMu);
            }
          }
          else if (m == parama.iMv)
          {
            parama.Lbs.setAdapter(new d(0, parama.iMw));
            if (k >= parama.iMw) {
              parama.Lbs.setCurrentItem(parama.iMw);
            } else {
              parama.Lbs.setCurrentItem(k);
            }
          }
          else
          {
            parama.Lbs.setAdapter(new d(0, 59));
            parama.Lbs.setCurrentItem(k);
          }
        }
      }
      j.aH(parama.aQh());
      if ((parama.Lbv) && (i == 2))
      {
        parama.Lbp.afG(0);
        parama.Lbq.afG(0);
        parama.Lbp.invalidate();
        parama.Lbq.invalidate();
      }
      if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
      {
        parama = this.Lbi;
        localObject1 = this.Lax.iLt;
        localObject2 = this.Lax.iLu;
        localObject3 = this.Lax.iLv;
        localObject4 = this.Lax.iLw;
        localObject5 = this.Lax.iLx;
        String str = this.Lax.iLy;
        if (localObject1 == null) {
          break label3522;
        }
        parama.Lbo.setLabel((String)localObject1);
        if (localObject2 == null) {
          break label3545;
        }
        parama.Lbp.setLabel((String)localObject2);
        if (localObject3 == null) {
          break label3568;
        }
        parama.Lbq.setLabel((String)localObject3);
        label3284:
        if (localObject4 == null) {
          break label3591;
        }
        parama.Lbr.setLabel((String)localObject4);
        label3298:
        if (localObject5 == null) {
          break label3614;
        }
        parama.Lbs.setLabel((String)localObject5);
        label3312:
        if (str == null) {
          break label3637;
        }
        parama.Lbt.setLabel(str);
      }
      for (;;)
      {
        yV(this.Lax.ov);
        this.Lbi.setDividerColor(this.Lax.iKN);
        this.Lbi.Lbw = this.Lax.Lbw;
        parama = this.Lbi;
        boolean bool = this.Lax.iLn;
        parama.Lbo.setCyclic(bool);
        parama.Lbp.setCyclic(bool);
        parama.Lbq.setCyclic(bool);
        parama.Lbr.setCyclic(bool);
        parama.Lbs.setCyclic(bool);
        parama.Lbt.setCyclic(bool);
        this.Lbi.iLM = this.Lax.iLM;
        parama = this.Lbi;
        bool = this.Lax.iKG;
        parama.Lbq.iKG = bool;
        parama.Lbp.iKG = bool;
        parama.Lbo.iKG = bool;
        parama.Lbr.iKG = bool;
        parama.Lbs.iKG = bool;
        parama.Lbt.iKG = bool;
        AppMethodBeat.o(192713);
        return;
        parama.Lbo.setLabel(parama.view.getContext().getString(2131761931));
        break;
        label3545:
        parama.Lbp.setLabel(parama.view.getContext().getString(2131761928));
        break label3270;
        label3568:
        parama.Lbq.setLabel(parama.view.getContext().getString(2131761925));
        break label3284;
        parama.Lbr.setLabel(parama.view.getContext().getString(2131761926));
        break label3298;
        parama.Lbs.setLabel(parama.view.getContext().getString(2131761927));
        break label3312;
        parama.Lbt.setLabel(parama.view.getContext().getString(2131761929));
      }
    }
  }
  
  public final boolean aQb()
  {
    return this.Lax.iLN;
  }
  
  public final void aQc()
  {
    AppMethodBeat.i(192715);
    if (this.Lax.Lcj != null) {
      try
      {
        Date localDate = j.iMi.parse(this.Lbi.aQi());
        this.Lax.Lcj.a(localDate);
        AppMethodBeat.o(192715);
        return;
      }
      catch (ParseException localParseException)
      {
        ap.printErrStackTrace(this.TAG, localParseException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(192715);
  }
  
  public final View aQe()
  {
    AppMethodBeat.i(192716);
    if (this.Lbi.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131496156, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131305844);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.Lbi.view = localLinearLayout;
    }
    View localView = this.Lbi.view;
    AppMethodBeat.o(192716);
    return localView;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192718);
    this.Lbi.du(paramInt1, paramInt2);
    AppMethodBeat.o(192718);
  }
  
  public final List<WheelView> fMP()
  {
    AppMethodBeat.i(221680);
    List localList = this.Lbi.aQh();
    AppMethodBeat.o(221680);
    return localList;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(192714);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (((String)paramView.getTag()).equals("submit")) {
      aQc();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(192714);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(192717);
    if (this.Lbi != null) {
      this.Lbi.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(192717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.h
 * JD-Core Version:    0.7.0.1
 */