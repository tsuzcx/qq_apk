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
  j LxJ;
  boolean LxK;
  private String TAG;
  private Context context;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200485);
    this.TAG = "TimePickerView";
    this.LxK = false;
    this.LxJ = new j(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(200485);
  }
  
  public final void a(com.tencent.mm.ui.widget.picker.c.a parama)
  {
    AppMethodBeat.i(200486);
    this.LwV = parama;
    Object localObject5 = parama.context;
    aQz();
    aQw();
    aQx();
    LayoutInflater.from((Context)localObject5).inflate(2131496156, this.iOI);
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
    if (TextUtils.isEmpty(this.LwV.iOu))
    {
      parama = ((Context)localObject5).getResources().getString(2131761930);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.LwV.iOv)) {
        break label1327;
      }
      parama = ((Context)localObject5).getResources().getString(2131761924);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.LwV.iOw)) {
        break label1338;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.LwV.iOx);
      ((Button)localObject4).setTextColor(this.LwV.iOy);
      ((TextView)localObject1).setTextColor(this.LwV.iOz);
      ((RelativeLayout)localObject2).setBackgroundColor(this.LwV.iOB);
      ((Button)localObject3).setTextSize(this.LwV.iOC);
      ((Button)localObject4).setTextSize(this.LwV.iOC);
      ((TextView)localObject1).setTextSize(this.LwV.iOD);
      parama = this.LxJ;
      localObject1 = this.LwV.iOi;
      i = this.LwV.iOt;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.iOi = ((boolean[])localObject1);
      parama.gravity = i;
      if (this.LwV.LyL != null) {
        this.LxJ.LxY = new com.tencent.mm.ui.widget.picker.d.a()
        {
          public final void aQv()
          {
            AppMethodBeat.i(200484);
            try
            {
              j.iPb.parse(h.a(h.this).aQH());
              h.this.LwV.LyL.fRe();
              AppMethodBeat.o(200484);
              return;
            }
            catch (ParseException localParseException)
            {
              ap.printErrStackTrace(h.b(h.this), localParseException, "", new Object[0]);
              AppMethodBeat.o(200484);
            }
          }
        };
      }
      if ((this.LwV.startYear != 0) && (this.LwV.endYear != 0) && (this.LwV.startYear <= this.LwV.endYear))
      {
        this.LxJ.startYear = this.LwV.startYear;
        this.LxJ.endYear = this.LwV.endYear;
      }
      if ((this.LwV.iOk == null) || (this.LwV.iOl == null)) {
        break label1349;
      }
      if (this.LwV.iOk.getTimeInMillis() > this.LwV.iOl.getTimeInMillis())
      {
        ap.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null", new Object[0]);
        this.LwV.iOk = null;
      }
      parama = this.LxJ;
      localObject1 = this.LwV.iOk;
      localObject2 = this.LwV.iOl;
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
      parama.iPj = j;
      parama.iPl = k;
      if (!this.LxK)
      {
        if ((this.LwV.iOk == null) || (this.LwV.iOl == null)) {
          break label1818;
        }
        if ((this.LwV.iOj != null) && (this.LwV.iOj.getTimeInMillis() >= this.LwV.iOk.getTimeInMillis())) {
          break label1777;
        }
        this.LwV.iOj = this.LwV.iOk;
      }
      if (this.LwV.iOj != null) {
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
      parama = this.LxJ;
      parama.iPq = i;
      parama.LxP = ((WheelView)parama.view.findViewById(2131307138));
      parama.LxQ = ((WheelView)parama.view.findViewById(2131302450));
      parama.LxR = ((WheelView)parama.view.findViewById(2131298935));
      parama.LxV = new com.tencent.mm.ui.widget.picker.a.f(parama.startYear, parama.endYear, parama.ctx);
      parama.LxP.setAdapter(parama.LxV);
      parama.LxP.setCurrentItem(i - parama.startYear);
      parama.LxP.setGravity(parama.gravity);
      if (parama.startYear != parama.endYear) {
        break label1954;
      }
      parama.LxQ.setAdapter(new d(parama.iPi, parama.iPj, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
      parama.LxQ.setCurrentItem(i1 + 1 - parama.iPi);
      label881:
      parama.LxQ.setGravity(parama.gravity);
      if (!parama.LxW) {
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
      if ((parama.startYear == parama.endYear) && (parama.iPi == parama.iPj)) {
        if (parama.iPu.contains(String.valueOf(i1 + 1)))
        {
          if (parama.iPl > 31) {
            parama.iPl = 31;
          }
          parama.LxR.setAdapter(new d(parama.iPk, parama.iPl));
          label982:
          parama.LxR.setCurrentItem(n - parama.iPk);
          parama.LxR.setGravity(parama.gravity);
          parama.LxS = ((WheelView)parama.view.findViewById(2131300765));
          parama.LxS.setAdapter(new d(parama.iPm, parama.iPo));
          parama.LxS.setCurrentItem(m - parama.iPm);
          parama.LxS.setGravity(parama.gravity);
          parama.LxT = ((WheelView)parama.view.findViewById(2131302275));
          if ((m != parama.iPm) || (parama.iPm != parama.iPo)) {
            break label2949;
          }
          parama.LxT.setAdapter(new d(parama.iPn, parama.iPp));
          if (k >= parama.iPn) {
            break label2914;
          }
          parama.LxT.setCurrentItem(0);
        }
      }
      for (;;)
      {
        parama.LxT.setGravity(parama.gravity);
        parama.LxU = ((WheelView)parama.view.findViewById(2131304457));
        parama.LxU.setAdapter(new d(0, 59));
        parama.LxU.setCurrentItem(j);
        parama.LxU.setGravity(parama.gravity);
        parama.LxS.setOnItemSelectedListener(new j.3(parama));
        parama.LxP.setOnItemSelectedListener(new j.2(parama));
        parama.LxQ.setOnItemSelectedListener(new j.1(parama));
        parama.a(parama.LxR);
        parama.a(parama.LxS);
        parama.a(parama.LxT);
        parama.a(parama.LxU);
        if (parama.iOi.length == 6) {
          break label3107;
        }
        parama = new IllegalArgumentException("type[] length is not 6");
        AppMethodBeat.o(200486);
        throw parama;
        parama = this.LwV.iOu;
        break;
        parama = this.LwV.iOv;
        break label167;
        parama = this.LwV.iOw;
        break label189;
        if (this.LwV.iOk != null)
        {
          if (this.LwV.iOk.get(1) >= 1900) {
            break label482;
          }
          ap.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null", new Object[0]);
          this.LwV.iOk = null;
          break label482;
        }
        if ((this.LwV.iOl == null) || (this.LwV.iOl.get(1) <= 2100)) {
          break label482;
        }
        ap.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null", new Object[0]);
        this.LwV.iOk = null;
        break label482;
        if (i != parama.startYear) {
          break label563;
        }
        if (j > parama.iPi)
        {
          parama.endYear = i;
          parama.iPj = j;
          parama.iPl = k;
          break label563;
        }
        if ((j != parama.iPi) || (k <= parama.iPk)) {
          break label563;
        }
        parama.endYear = i;
        parama.iPj = j;
        parama.iPl = k;
        break label563;
        label1524:
        if ((localObject1 != null) && (localObject2 == null))
        {
          i = ((Calendar)localObject1).get(1);
          j = ((Calendar)localObject1).get(2) + 1;
          k = ((Calendar)localObject1).get(5);
          if (i < parama.endYear)
          {
            parama.iPi = j;
            parama.iPk = k;
            parama.startYear = i;
            break label563;
          }
          if (i != parama.endYear) {
            break label563;
          }
          if (j < parama.iPj)
          {
            parama.iPi = j;
            parama.iPk = k;
            parama.startYear = i;
            break label563;
          }
          if ((j != parama.iPj) || (k >= parama.iPl)) {
            break label563;
          }
          parama.iPi = j;
          parama.iPk = k;
          parama.startYear = i;
          break label563;
        }
        if ((localObject1 == null) || (localObject2 == null)) {
          break label563;
        }
        parama.startYear = ((Calendar)localObject1).get(1);
        parama.endYear = ((Calendar)localObject2).get(1);
        parama.iPi = (((Calendar)localObject1).get(2) + 1);
        parama.iPj = (((Calendar)localObject2).get(2) + 1);
        parama.iPk = ((Calendar)localObject1).get(5);
        parama.iPl = ((Calendar)localObject2).get(5);
        parama.iPm = ((Calendar)localObject1).get(11);
        parama.iPn = ((Calendar)localObject1).get(12);
        parama.iPo = ((Calendar)localObject2).get(11);
        parama.iPp = ((Calendar)localObject2).get(12);
        break label563;
        label1777:
        if (this.LwV.iOj.getTimeInMillis() <= this.LwV.iOl.getTimeInMillis()) {
          break label638;
        }
        this.LwV.iOj = this.LwV.iOl;
        break label638;
        if (this.LwV.iOk != null)
        {
          this.LwV.iOj = this.LwV.iOk;
          break label638;
        }
        if (this.LwV.iOl == null) {
          break label638;
        }
        this.LwV.iOj = this.LwV.iOl;
        break label638;
        label1872:
        i = this.LwV.iOj.get(1);
        i1 = this.LwV.iOj.get(2);
        n = this.LwV.iOj.get(5);
        m = this.LwV.iOj.get(11);
        k = this.LwV.iOj.get(12);
        j = this.LwV.iOj.get(13);
        break label702;
        if (i == parama.startYear)
        {
          parama.LxQ.setAdapter(new d(parama.iPi, 12, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
          parama.LxQ.setCurrentItem(i1 + 1 - parama.iPi);
          break label881;
        }
        if (i == parama.endYear)
        {
          parama.LxQ.setAdapter(new d(1, parama.iPj, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
          parama.LxQ.setCurrentItem(i1);
          break label881;
        }
        if ((parama.LxW) && (i - 1 == parama.startYear))
        {
          parama.LxQ.setAdapter(new d(parama.iPi, 12, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
          parama.LxQ.setCurrentItem(i1 + 1 - parama.iPi);
          break label881;
        }
        parama.LxQ.setAdapter(new d(1, 12, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
        parama.LxQ.setCurrentItem(i1);
        break label881;
        if (parama.iPw.contains(String.valueOf(i1 + 1)))
        {
          if (parama.iPl > 30) {
            parama.iPl = 30;
          }
          parama.LxR.setAdapter(new d(parama.iPk, parama.iPl));
          break label982;
        }
        if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
        {
          if (parama.iPl > 29) {
            parama.iPl = 29;
          }
          parama.LxR.setAdapter(new d(parama.iPk, parama.iPl));
          break label982;
        }
        if (parama.iPl > 28) {
          parama.iPl = 28;
        }
        parama.LxR.setAdapter(new d(parama.iPk, parama.iPl));
        break label982;
        if ((i2 == parama.startYear) && (i1 + 1 == parama.iPi))
        {
          if (parama.iPu.contains(String.valueOf(i1 + 1))) {
            parama.LxR.setAdapter(new d(parama.iPk, 31));
          }
          for (;;)
          {
            parama.LxR.setCurrentItem(n - parama.iPk);
            break;
            if (parama.iPw.contains(String.valueOf(i1 + 1))) {
              parama.LxR.setAdapter(new d(parama.iPk, 30));
            } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
              parama.LxR.setAdapter(new d(parama.iPk, 29));
            } else {
              parama.LxR.setAdapter(new d(parama.iPk, 28));
            }
          }
        }
        if ((i2 == parama.endYear) && (i1 + 1 == parama.iPj))
        {
          if (parama.iPu.contains(String.valueOf(i1 + 1)))
          {
            if (parama.iPl > 31) {
              parama.iPl = 31;
            }
            parama.LxR.setAdapter(new d(1, parama.iPl));
          }
          for (;;)
          {
            parama.LxR.setCurrentItem(n - 1);
            break;
            if (parama.iPw.contains(String.valueOf(i1 + 1)))
            {
              if (parama.iPl > 30) {
                parama.iPl = 30;
              }
              parama.LxR.setAdapter(new d(1, parama.iPl));
            }
            else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
            {
              if (parama.iPl > 29) {
                parama.iPl = 29;
              }
              parama.LxR.setAdapter(new d(1, parama.iPl));
            }
            else
            {
              if (parama.iPl > 28) {
                parama.iPl = 28;
              }
              parama.LxR.setAdapter(new d(1, parama.iPl));
            }
          }
        }
        if (parama.iPu.contains(String.valueOf(i1 + 1))) {
          parama.LxR.setAdapter(new d(1, 31));
        }
        for (;;)
        {
          parama.LxR.setCurrentItem(n - 1);
          break;
          if (parama.iPw.contains(String.valueOf(i1 + 1))) {
            parama.LxR.setAdapter(new d(1, 30));
          } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
            parama.LxR.setAdapter(new d(1, 29));
          } else {
            parama.LxR.setAdapter(new d(1, 28));
          }
        }
        label2914:
        if (k > parama.iPp)
        {
          parama.LxT.setCurrentItem(parama.iPp);
        }
        else
        {
          parama.LxT.setCurrentItem(k);
          continue;
          if (m == parama.iPm)
          {
            parama.LxT.setAdapter(new d(parama.iPn, 59));
            if (k < parama.iPn) {
              parama.LxT.setCurrentItem(0);
            } else {
              parama.LxT.setCurrentItem(k - parama.iPn);
            }
          }
          else if (m == parama.iPo)
          {
            parama.LxT.setAdapter(new d(0, parama.iPp));
            if (k >= parama.iPp) {
              parama.LxT.setCurrentItem(parama.iPp);
            } else {
              parama.LxT.setCurrentItem(k);
            }
          }
          else
          {
            parama.LxT.setAdapter(new d(0, 59));
            parama.LxT.setCurrentItem(k);
          }
        }
      }
      j.aH(parama.aQG());
      if ((parama.LxW) && (i == 2))
      {
        parama.LxQ.agp(0);
        parama.LxR.agp(0);
        parama.LxQ.invalidate();
        parama.LxR.invalidate();
      }
      if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
      {
        parama = this.LxJ;
        localObject1 = this.LwV.iOm;
        localObject2 = this.LwV.iOn;
        localObject3 = this.LwV.iOo;
        localObject4 = this.LwV.iOp;
        localObject5 = this.LwV.iOq;
        String str = this.LwV.iOr;
        if (localObject1 == null) {
          break label3522;
        }
        parama.LxP.setLabel((String)localObject1);
        if (localObject2 == null) {
          break label3545;
        }
        parama.LxQ.setLabel((String)localObject2);
        if (localObject3 == null) {
          break label3568;
        }
        parama.LxR.setLabel((String)localObject3);
        label3284:
        if (localObject4 == null) {
          break label3591;
        }
        parama.LxS.setLabel((String)localObject4);
        label3298:
        if (localObject5 == null) {
          break label3614;
        }
        parama.LxT.setLabel((String)localObject5);
        label3312:
        if (str == null) {
          break label3637;
        }
        parama.LxU.setLabel(str);
      }
      for (;;)
      {
        zj(this.LwV.ov);
        this.LxJ.setDividerColor(this.LwV.iNG);
        this.LxJ.LxX = this.LwV.LxX;
        parama = this.LxJ;
        boolean bool = this.LwV.iOg;
        parama.LxP.setCyclic(bool);
        parama.LxQ.setCyclic(bool);
        parama.LxR.setCyclic(bool);
        parama.LxS.setCyclic(bool);
        parama.LxT.setCyclic(bool);
        parama.LxU.setCyclic(bool);
        this.LxJ.iOF = this.LwV.iOF;
        parama = this.LxJ;
        bool = this.LwV.iNz;
        parama.LxR.iNz = bool;
        parama.LxQ.iNz = bool;
        parama.LxP.iNz = bool;
        parama.LxS.iNz = bool;
        parama.LxT.iNz = bool;
        parama.LxU.iNz = bool;
        AppMethodBeat.o(200486);
        return;
        parama.LxP.setLabel(parama.view.getContext().getString(2131761931));
        break;
        label3545:
        parama.LxQ.setLabel(parama.view.getContext().getString(2131761928));
        break label3270;
        label3568:
        parama.LxR.setLabel(parama.view.getContext().getString(2131761925));
        break label3284;
        parama.LxS.setLabel(parama.view.getContext().getString(2131761926));
        break label3298;
        parama.LxT.setLabel(parama.view.getContext().getString(2131761927));
        break label3312;
        parama.LxU.setLabel(parama.view.getContext().getString(2131761929));
      }
    }
  }
  
  public final boolean aQA()
  {
    return this.LwV.iOG;
  }
  
  public final void aQB()
  {
    AppMethodBeat.i(200488);
    if (this.LwV.LyK != null) {
      try
      {
        Date localDate = j.iPb.parse(this.LxJ.aQH());
        this.LwV.LyK.a(localDate);
        AppMethodBeat.o(200488);
        return;
      }
      catch (ParseException localParseException)
      {
        ap.printErrStackTrace(this.TAG, localParseException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(200488);
  }
  
  public final View aQD()
  {
    AppMethodBeat.i(200489);
    if (this.LxJ.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131496156, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131305844);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.LxJ.view = localLinearLayout;
    }
    View localView = this.LxJ.view;
    AppMethodBeat.o(200489);
    return localView;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200491);
    this.LxJ.du(paramInt1, paramInt2);
    AppMethodBeat.o(200491);
  }
  
  public final List<WheelView> fRk()
  {
    AppMethodBeat.i(224522);
    List localList = this.LxJ.aQG();
    AppMethodBeat.o(224522);
    return localList;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200487);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (((String)paramView.getTag()).equals("submit")) {
      aQB();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(200487);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(200490);
    if (this.LxJ != null) {
      this.LxJ.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(200490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.h
 * JD-Core Version:    0.7.0.1
 */