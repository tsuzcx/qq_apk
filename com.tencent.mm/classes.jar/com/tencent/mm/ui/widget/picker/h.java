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
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.widget.picker.a.b;
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
  j JjL;
  boolean JjM;
  private String TAG;
  private Context context;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(199766);
    this.TAG = "TimePickerView";
    this.JjM = false;
    this.JjL = new j(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(199766);
  }
  
  public final void a(com.tencent.mm.ui.widget.picker.c.a parama)
  {
    AppMethodBeat.i(199767);
    this.Jja = parama;
    Object localObject5 = parama.context;
    aMP();
    aMM();
    aMN();
    LayoutInflater.from((Context)localObject5).inflate(2131496156, this.isM);
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
    if (TextUtils.isEmpty(this.Jja.isy))
    {
      parama = ((Context)localObject5).getResources().getString(2131761930);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.Jja.isz)) {
        break label1327;
      }
      parama = ((Context)localObject5).getResources().getString(2131761924);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.Jja.isA)) {
        break label1338;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.Jja.isB);
      ((Button)localObject4).setTextColor(this.Jja.isC);
      ((TextView)localObject1).setTextColor(this.Jja.isD);
      ((RelativeLayout)localObject2).setBackgroundColor(this.Jja.isF);
      ((Button)localObject3).setTextSize(this.Jja.isG);
      ((Button)localObject4).setTextSize(this.Jja.isG);
      ((TextView)localObject1).setTextSize(this.Jja.isH);
      parama = this.JjL;
      localObject1 = this.Jja.ism;
      i = this.Jja.isx;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.ism = ((boolean[])localObject1);
      parama.gravity = i;
      if (this.Jja.JkN != null) {
        this.JjL.Jka = new com.tencent.mm.ui.widget.picker.d.a()
        {
          public final void aML()
          {
            AppMethodBeat.i(199765);
            try
            {
              j.itf.parse(h.a(h.this).aMX());
              h.this.Jja.JkN.fvW();
              AppMethodBeat.o(199765);
              return;
            }
            catch (ParseException localParseException)
            {
              an.printErrStackTrace(h.b(h.this), localParseException, "", new Object[0]);
              AppMethodBeat.o(199765);
            }
          }
        };
      }
      if ((this.Jja.startYear != 0) && (this.Jja.endYear != 0) && (this.Jja.startYear <= this.Jja.endYear))
      {
        this.JjL.startYear = this.Jja.startYear;
        this.JjL.endYear = this.Jja.endYear;
      }
      if ((this.Jja.iso == null) || (this.Jja.isp == null)) {
        break label1349;
      }
      if (this.Jja.iso.getTimeInMillis() > this.Jja.isp.getTimeInMillis())
      {
        an.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null", new Object[0]);
        this.Jja.iso = null;
      }
      parama = this.JjL;
      localObject1 = this.Jja.iso;
      localObject2 = this.Jja.isp;
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
      parama.itn = j;
      parama.itp = k;
      if (!this.JjM)
      {
        if ((this.Jja.iso == null) || (this.Jja.isp == null)) {
          break label1818;
        }
        if ((this.Jja.isn != null) && (this.Jja.isn.getTimeInMillis() >= this.Jja.iso.getTimeInMillis())) {
          break label1777;
        }
        this.Jja.isn = this.Jja.iso;
      }
      if (this.Jja.isn != null) {
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
      parama = this.JjL;
      parama.itu = i;
      parama.JjR = ((WheelView)parama.view.findViewById(2131307138));
      parama.JjS = ((WheelView)parama.view.findViewById(2131302450));
      parama.JjT = ((WheelView)parama.view.findViewById(2131298935));
      parama.JjX = new com.tencent.mm.ui.widget.picker.a.f(parama.startYear, parama.endYear, parama.ctx);
      parama.JjR.setAdapter(parama.JjX);
      parama.JjR.setCurrentItem(i - parama.startYear);
      parama.JjR.setGravity(parama.gravity);
      if (parama.startYear != parama.endYear) {
        break label1954;
      }
      parama.JjS.setAdapter(new d(parama.itm, parama.itn, new b(parama.ctx)));
      parama.JjS.setCurrentItem(i1 + 1 - parama.itm);
      label881:
      parama.JjS.setGravity(parama.gravity);
      if (!parama.JjY) {
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
      if ((parama.startYear == parama.endYear) && (parama.itm == parama.itn)) {
        if (parama.ity.contains(String.valueOf(i1 + 1)))
        {
          if (parama.itp > 31) {
            parama.itp = 31;
          }
          parama.JjT.setAdapter(new d(parama.ito, parama.itp));
          label982:
          parama.JjT.setCurrentItem(n - parama.ito);
          parama.JjT.setGravity(parama.gravity);
          parama.JjU = ((WheelView)parama.view.findViewById(2131300765));
          parama.JjU.setAdapter(new d(parama.itq, parama.its));
          parama.JjU.setCurrentItem(m - parama.itq);
          parama.JjU.setGravity(parama.gravity);
          parama.JjV = ((WheelView)parama.view.findViewById(2131302275));
          if ((m != parama.itq) || (parama.itq != parama.its)) {
            break label2949;
          }
          parama.JjV.setAdapter(new d(parama.itr, parama.itt));
          if (k >= parama.itr) {
            break label2914;
          }
          parama.JjV.setCurrentItem(0);
        }
      }
      for (;;)
      {
        parama.JjV.setGravity(parama.gravity);
        parama.JjW = ((WheelView)parama.view.findViewById(2131304457));
        parama.JjW.setAdapter(new d(0, 59));
        parama.JjW.setCurrentItem(j);
        parama.JjW.setGravity(parama.gravity);
        parama.JjU.setOnItemSelectedListener(new j.3(parama));
        parama.JjR.setOnItemSelectedListener(new j.2(parama));
        parama.JjS.setOnItemSelectedListener(new j.1(parama));
        parama.a(parama.JjT);
        parama.a(parama.JjU);
        parama.a(parama.JjV);
        parama.a(parama.JjW);
        if (parama.ism.length == 6) {
          break label3107;
        }
        parama = new IllegalArgumentException("type[] length is not 6");
        AppMethodBeat.o(199767);
        throw parama;
        parama = this.Jja.isy;
        break;
        parama = this.Jja.isz;
        break label167;
        parama = this.Jja.isA;
        break label189;
        if (this.Jja.iso != null)
        {
          if (this.Jja.iso.get(1) >= 1900) {
            break label482;
          }
          an.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null", new Object[0]);
          this.Jja.iso = null;
          break label482;
        }
        if ((this.Jja.isp == null) || (this.Jja.isp.get(1) <= 2100)) {
          break label482;
        }
        an.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null", new Object[0]);
        this.Jja.iso = null;
        break label482;
        if (i != parama.startYear) {
          break label563;
        }
        if (j > parama.itm)
        {
          parama.endYear = i;
          parama.itn = j;
          parama.itp = k;
          break label563;
        }
        if ((j != parama.itm) || (k <= parama.ito)) {
          break label563;
        }
        parama.endYear = i;
        parama.itn = j;
        parama.itp = k;
        break label563;
        label1524:
        if ((localObject1 != null) && (localObject2 == null))
        {
          i = ((Calendar)localObject1).get(1);
          j = ((Calendar)localObject1).get(2) + 1;
          k = ((Calendar)localObject1).get(5);
          if (i < parama.endYear)
          {
            parama.itm = j;
            parama.ito = k;
            parama.startYear = i;
            break label563;
          }
          if (i != parama.endYear) {
            break label563;
          }
          if (j < parama.itn)
          {
            parama.itm = j;
            parama.ito = k;
            parama.startYear = i;
            break label563;
          }
          if ((j != parama.itn) || (k >= parama.itp)) {
            break label563;
          }
          parama.itm = j;
          parama.ito = k;
          parama.startYear = i;
          break label563;
        }
        if ((localObject1 == null) || (localObject2 == null)) {
          break label563;
        }
        parama.startYear = ((Calendar)localObject1).get(1);
        parama.endYear = ((Calendar)localObject2).get(1);
        parama.itm = (((Calendar)localObject1).get(2) + 1);
        parama.itn = (((Calendar)localObject2).get(2) + 1);
        parama.ito = ((Calendar)localObject1).get(5);
        parama.itp = ((Calendar)localObject2).get(5);
        parama.itq = ((Calendar)localObject1).get(11);
        parama.itr = ((Calendar)localObject1).get(12);
        parama.its = ((Calendar)localObject2).get(11);
        parama.itt = ((Calendar)localObject2).get(12);
        break label563;
        label1777:
        if (this.Jja.isn.getTimeInMillis() <= this.Jja.isp.getTimeInMillis()) {
          break label638;
        }
        this.Jja.isn = this.Jja.isp;
        break label638;
        if (this.Jja.iso != null)
        {
          this.Jja.isn = this.Jja.iso;
          break label638;
        }
        if (this.Jja.isp == null) {
          break label638;
        }
        this.Jja.isn = this.Jja.isp;
        break label638;
        label1872:
        i = this.Jja.isn.get(1);
        i1 = this.Jja.isn.get(2);
        n = this.Jja.isn.get(5);
        m = this.Jja.isn.get(11);
        k = this.Jja.isn.get(12);
        j = this.Jja.isn.get(13);
        break label702;
        if (i == parama.startYear)
        {
          parama.JjS.setAdapter(new d(parama.itm, 12, new b(parama.ctx)));
          parama.JjS.setCurrentItem(i1 + 1 - parama.itm);
          break label881;
        }
        if (i == parama.endYear)
        {
          parama.JjS.setAdapter(new d(1, parama.itn, new b(parama.ctx)));
          parama.JjS.setCurrentItem(i1);
          break label881;
        }
        if ((parama.JjY) && (i - 1 == parama.startYear))
        {
          parama.JjS.setAdapter(new d(parama.itm, 12, new b(parama.ctx)));
          parama.JjS.setCurrentItem(i1 + 1 - parama.itm);
          break label881;
        }
        parama.JjS.setAdapter(new d(1, 12, new b(parama.ctx)));
        parama.JjS.setCurrentItem(i1);
        break label881;
        if (parama.itz.contains(String.valueOf(i1 + 1)))
        {
          if (parama.itp > 30) {
            parama.itp = 30;
          }
          parama.JjT.setAdapter(new d(parama.ito, parama.itp));
          break label982;
        }
        if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
        {
          if (parama.itp > 29) {
            parama.itp = 29;
          }
          parama.JjT.setAdapter(new d(parama.ito, parama.itp));
          break label982;
        }
        if (parama.itp > 28) {
          parama.itp = 28;
        }
        parama.JjT.setAdapter(new d(parama.ito, parama.itp));
        break label982;
        if ((i2 == parama.startYear) && (i1 + 1 == parama.itm))
        {
          if (parama.ity.contains(String.valueOf(i1 + 1))) {
            parama.JjT.setAdapter(new d(parama.ito, 31));
          }
          for (;;)
          {
            parama.JjT.setCurrentItem(n - parama.ito);
            break;
            if (parama.itz.contains(String.valueOf(i1 + 1))) {
              parama.JjT.setAdapter(new d(parama.ito, 30));
            } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
              parama.JjT.setAdapter(new d(parama.ito, 29));
            } else {
              parama.JjT.setAdapter(new d(parama.ito, 28));
            }
          }
        }
        if ((i2 == parama.endYear) && (i1 + 1 == parama.itn))
        {
          if (parama.ity.contains(String.valueOf(i1 + 1)))
          {
            if (parama.itp > 31) {
              parama.itp = 31;
            }
            parama.JjT.setAdapter(new d(1, parama.itp));
          }
          for (;;)
          {
            parama.JjT.setCurrentItem(n - 1);
            break;
            if (parama.itz.contains(String.valueOf(i1 + 1)))
            {
              if (parama.itp > 30) {
                parama.itp = 30;
              }
              parama.JjT.setAdapter(new d(1, parama.itp));
            }
            else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
            {
              if (parama.itp > 29) {
                parama.itp = 29;
              }
              parama.JjT.setAdapter(new d(1, parama.itp));
            }
            else
            {
              if (parama.itp > 28) {
                parama.itp = 28;
              }
              parama.JjT.setAdapter(new d(1, parama.itp));
            }
          }
        }
        if (parama.ity.contains(String.valueOf(i1 + 1))) {
          parama.JjT.setAdapter(new d(1, 31));
        }
        for (;;)
        {
          parama.JjT.setCurrentItem(n - 1);
          break;
          if (parama.itz.contains(String.valueOf(i1 + 1))) {
            parama.JjT.setAdapter(new d(1, 30));
          } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
            parama.JjT.setAdapter(new d(1, 29));
          } else {
            parama.JjT.setAdapter(new d(1, 28));
          }
        }
        label2914:
        if (k > parama.itt)
        {
          parama.JjV.setCurrentItem(parama.itt);
        }
        else
        {
          parama.JjV.setCurrentItem(k);
          continue;
          if (m == parama.itq)
          {
            parama.JjV.setAdapter(new d(parama.itr, 59));
            if (k < parama.itr) {
              parama.JjV.setCurrentItem(0);
            } else {
              parama.JjV.setCurrentItem(k - parama.itr);
            }
          }
          else if (m == parama.its)
          {
            parama.JjV.setAdapter(new d(0, parama.itt));
            if (k >= parama.itt) {
              parama.JjV.setCurrentItem(parama.itt);
            } else {
              parama.JjV.setCurrentItem(k);
            }
          }
          else
          {
            parama.JjV.setAdapter(new d(0, 59));
            parama.JjV.setCurrentItem(k);
          }
        }
      }
      j.aG(parama.aMW());
      if ((parama.JjY) && (i == 2))
      {
        parama.JjS.adg(0);
        parama.JjT.adg(0);
        parama.JjS.invalidate();
        parama.JjT.invalidate();
      }
      if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
      {
        parama = this.JjL;
        localObject1 = this.Jja.isq;
        localObject2 = this.Jja.isr;
        localObject3 = this.Jja.iss;
        localObject4 = this.Jja.ist;
        localObject5 = this.Jja.isu;
        String str = this.Jja.isv;
        if (localObject1 == null) {
          break label3522;
        }
        parama.JjR.setLabel((String)localObject1);
        if (localObject2 == null) {
          break label3545;
        }
        parama.JjS.setLabel((String)localObject2);
        if (localObject3 == null) {
          break label3568;
        }
        parama.JjT.setLabel((String)localObject3);
        label3284:
        if (localObject4 == null) {
          break label3591;
        }
        parama.JjU.setLabel((String)localObject4);
        label3298:
        if (localObject5 == null) {
          break label3614;
        }
        parama.JjV.setLabel((String)localObject5);
        label3312:
        if (str == null) {
          break label3637;
        }
        parama.JjW.setLabel(str);
      }
      for (;;)
      {
        yj(this.Jja.mz);
        this.JjL.setDividerColor(this.Jja.irK);
        this.JjL.JjZ = this.Jja.JjZ;
        parama = this.JjL;
        boolean bool = this.Jja.isk;
        parama.JjR.setCyclic(bool);
        parama.JjS.setCyclic(bool);
        parama.JjT.setCyclic(bool);
        parama.JjU.setCyclic(bool);
        parama.JjV.setCyclic(bool);
        parama.JjW.setCyclic(bool);
        this.JjL.isJ = this.Jja.isJ;
        parama = this.JjL;
        bool = this.Jja.irD;
        parama.JjT.irD = bool;
        parama.JjS.irD = bool;
        parama.JjR.irD = bool;
        parama.JjU.irD = bool;
        parama.JjV.irD = bool;
        parama.JjW.irD = bool;
        AppMethodBeat.o(199767);
        return;
        parama.JjR.setLabel(parama.view.getContext().getString(2131761931));
        break;
        label3545:
        parama.JjS.setLabel(parama.view.getContext().getString(2131761928));
        break label3270;
        label3568:
        parama.JjT.setLabel(parama.view.getContext().getString(2131761925));
        break label3284;
        parama.JjU.setLabel(parama.view.getContext().getString(2131761926));
        break label3298;
        parama.JjV.setLabel(parama.view.getContext().getString(2131761927));
        break label3312;
        parama.JjW.setLabel(parama.view.getContext().getString(2131761929));
      }
    }
  }
  
  public final boolean aMQ()
  {
    return this.Jja.isK;
  }
  
  public final void aMR()
  {
    AppMethodBeat.i(199769);
    if (this.Jja.JkM != null) {
      try
      {
        Date localDate = j.itf.parse(this.JjL.aMX());
        this.Jja.JkM.a(localDate);
        AppMethodBeat.o(199769);
        return;
      }
      catch (ParseException localParseException)
      {
        an.printErrStackTrace(this.TAG, localParseException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(199769);
  }
  
  public final View aMT()
  {
    AppMethodBeat.i(199770);
    if (this.JjL.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131496156, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131305844);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.JjL.view = localLinearLayout;
    }
    View localView = this.JjL.view;
    AppMethodBeat.o(199770);
    return localView;
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199772);
    this.JjL.ds(paramInt1, paramInt2);
    AppMethodBeat.o(199772);
  }
  
  public final List<WheelView> fwb()
  {
    AppMethodBeat.i(210317);
    List localList = this.JjL.aMW();
    AppMethodBeat.o(210317);
    return localList;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199768);
    if (((String)paramView.getTag()).equals("submit")) {
      aMR();
    }
    dismiss();
    AppMethodBeat.o(199768);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(199771);
    if (this.JjL != null) {
      this.JjL.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(199771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.h
 * JD-Core Version:    0.7.0.1
 */