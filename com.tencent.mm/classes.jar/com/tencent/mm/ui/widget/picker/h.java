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
import com.tencent.mm.ui.as;
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
  j QTy;
  boolean QTz;
  private String TAG;
  private Context context;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(198443);
    this.TAG = "TimePickerView";
    this.QTz = false;
    this.QTy = new j(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(198443);
  }
  
  public final void a(com.tencent.mm.ui.widget.picker.c.a parama)
  {
    AppMethodBeat.i(198444);
    this.QSH = parama;
    Object localObject5 = parama.context;
    ble();
    blb();
    blc();
    LayoutInflater.from((Context)localObject5).inflate(2131495933, this.jLx);
    Object localObject1 = (TextView)findViewById(2131309446);
    Object localObject2 = (RelativeLayout)findViewById(2131307202);
    Object localObject3 = (Button)findViewById(2131297822);
    Object localObject4 = (Button)findViewById(2131297816);
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
    if (TextUtils.isEmpty(this.QSH.jLj))
    {
      parama = ((Context)localObject5).getResources().getString(2131763936);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.QSH.jLk)) {
        break label1327;
      }
      parama = ((Context)localObject5).getResources().getString(2131763930);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.QSH.jLl)) {
        break label1338;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.QSH.jLm);
      ((Button)localObject4).setTextColor(this.QSH.jLn);
      ((TextView)localObject1).setTextColor(this.QSH.jLo);
      ((RelativeLayout)localObject2).setBackgroundColor(this.QSH.jLq);
      ((Button)localObject3).setTextSize(this.QSH.jLr);
      ((Button)localObject4).setTextSize(this.QSH.jLr);
      ((TextView)localObject1).setTextSize(this.QSH.jLs);
      parama = this.QTy;
      localObject1 = this.QSH.jKX;
      i = this.QSH.jLi;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.jKX = ((boolean[])localObject1);
      parama.gravity = i;
      if (this.QSH.QUB != null) {
        this.QTy.QTN = new com.tencent.mm.ui.widget.picker.d.a()
        {
          public final void bla()
          {
            AppMethodBeat.i(198442);
            try
            {
              j.dateFormat.parse(h.a(h.this).getTime());
              h.this.QSH.QUB.hce();
              AppMethodBeat.o(198442);
              return;
            }
            catch (ParseException localParseException)
            {
              as.printErrStackTrace(h.b(h.this), localParseException, "", new Object[0]);
              AppMethodBeat.o(198442);
            }
          }
        };
      }
      if ((this.QSH.startYear != 0) && (this.QSH.endYear != 0) && (this.QSH.startYear <= this.QSH.endYear))
      {
        this.QTy.startYear = this.QSH.startYear;
        this.QTy.endYear = this.QSH.endYear;
      }
      if ((this.QSH.jKZ == null) || (this.QSH.jLa == null)) {
        break label1349;
      }
      if (this.QSH.jKZ.getTimeInMillis() > this.QSH.jLa.getTimeInMillis())
      {
        as.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null", new Object[0]);
        this.QSH.jKZ = null;
      }
      parama = this.QTy;
      localObject1 = this.QSH.jKZ;
      localObject2 = this.QSH.jLa;
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
      parama.jLX = j;
      parama.jLZ = k;
      if (!this.QTz)
      {
        if ((this.QSH.jKZ == null) || (this.QSH.jLa == null)) {
          break label1818;
        }
        if ((this.QSH.jKY != null) && (this.QSH.jKY.getTimeInMillis() >= this.QSH.jKZ.getTimeInMillis())) {
          break label1777;
        }
        this.QSH.jKY = this.QSH.jKZ;
      }
      if (this.QSH.jKY != null) {
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
      parama = this.QTy;
      parama.jMe = i;
      parama.QTE = ((WheelView)parama.view.findViewById(2131310679));
      parama.QTF = ((WheelView)parama.view.findViewById(2131304853));
      parama.QTG = ((WheelView)parama.view.findViewById(2131299421));
      parama.QTK = new com.tencent.mm.ui.widget.picker.a.f(parama.startYear, parama.endYear, parama.ctx);
      parama.QTE.setAdapter(parama.QTK);
      parama.QTE.setCurrentItem(i - parama.startYear);
      parama.QTE.setGravity(parama.gravity);
      if (parama.startYear != parama.endYear) {
        break label1954;
      }
      parama.QTF.setAdapter(new d(parama.jLW, parama.jLX, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
      parama.QTF.setCurrentItem(i1 + 1 - parama.jLW);
      label881:
      parama.QTF.setGravity(parama.gravity);
      if (!parama.QTL) {
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
      if ((parama.startYear == parama.endYear) && (parama.jLW == parama.jLX)) {
        if (parama.jMi.contains(String.valueOf(i1 + 1)))
        {
          if (parama.jLZ > 31) {
            parama.jLZ = 31;
          }
          parama.QTG.setAdapter(new d(parama.jLY, parama.jLZ));
          label982:
          parama.QTG.setCurrentItem(n - parama.jLY);
          parama.QTG.setGravity(parama.gravity);
          parama.QTH = ((WheelView)parama.view.findViewById(2131302359));
          parama.QTH.setAdapter(new d(parama.jMa, parama.jMc));
          parama.QTH.setCurrentItem(m - parama.jMa);
          parama.QTH.setGravity(parama.gravity);
          parama.QTI = ((WheelView)parama.view.findViewById(2131304668));
          if ((m != parama.jMa) || (parama.jMa != parama.jMc)) {
            break label2949;
          }
          parama.QTI.setAdapter(new d(parama.jMb, parama.jMd));
          if (k >= parama.jMb) {
            break label2914;
          }
          parama.QTI.setCurrentItem(0);
        }
      }
      for (;;)
      {
        parama.QTI.setGravity(parama.gravity);
        parama.QTJ = ((WheelView)parama.view.findViewById(2131307433));
        parama.QTJ.setAdapter(new d(0, 59));
        parama.QTJ.setCurrentItem(j);
        parama.QTJ.setGravity(parama.gravity);
        parama.QTH.setOnItemSelectedListener(new j.3(parama));
        parama.QTE.setOnItemSelectedListener(new j.2(parama));
        parama.QTF.setOnItemSelectedListener(new j.1(parama));
        parama.a(parama.QTG);
        parama.a(parama.QTH);
        parama.a(parama.QTI);
        parama.a(parama.QTJ);
        if (parama.jKX.length == 6) {
          break label3107;
        }
        parama = new IllegalArgumentException("type[] length is not 6");
        AppMethodBeat.o(198444);
        throw parama;
        parama = this.QSH.jLj;
        break;
        parama = this.QSH.jLk;
        break label167;
        parama = this.QSH.jLl;
        break label189;
        if (this.QSH.jKZ != null)
        {
          if (this.QSH.jKZ.get(1) >= 1900) {
            break label482;
          }
          as.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null", new Object[0]);
          this.QSH.jKZ = null;
          break label482;
        }
        if ((this.QSH.jLa == null) || (this.QSH.jLa.get(1) <= 2100)) {
          break label482;
        }
        as.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null", new Object[0]);
        this.QSH.jKZ = null;
        break label482;
        if (i != parama.startYear) {
          break label563;
        }
        if (j > parama.jLW)
        {
          parama.endYear = i;
          parama.jLX = j;
          parama.jLZ = k;
          break label563;
        }
        if ((j != parama.jLW) || (k <= parama.jLY)) {
          break label563;
        }
        parama.endYear = i;
        parama.jLX = j;
        parama.jLZ = k;
        break label563;
        label1524:
        if ((localObject1 != null) && (localObject2 == null))
        {
          i = ((Calendar)localObject1).get(1);
          j = ((Calendar)localObject1).get(2) + 1;
          k = ((Calendar)localObject1).get(5);
          if (i < parama.endYear)
          {
            parama.jLW = j;
            parama.jLY = k;
            parama.startYear = i;
            break label563;
          }
          if (i != parama.endYear) {
            break label563;
          }
          if (j < parama.jLX)
          {
            parama.jLW = j;
            parama.jLY = k;
            parama.startYear = i;
            break label563;
          }
          if ((j != parama.jLX) || (k >= parama.jLZ)) {
            break label563;
          }
          parama.jLW = j;
          parama.jLY = k;
          parama.startYear = i;
          break label563;
        }
        if ((localObject1 == null) || (localObject2 == null)) {
          break label563;
        }
        parama.startYear = ((Calendar)localObject1).get(1);
        parama.endYear = ((Calendar)localObject2).get(1);
        parama.jLW = (((Calendar)localObject1).get(2) + 1);
        parama.jLX = (((Calendar)localObject2).get(2) + 1);
        parama.jLY = ((Calendar)localObject1).get(5);
        parama.jLZ = ((Calendar)localObject2).get(5);
        parama.jMa = ((Calendar)localObject1).get(11);
        parama.jMb = ((Calendar)localObject1).get(12);
        parama.jMc = ((Calendar)localObject2).get(11);
        parama.jMd = ((Calendar)localObject2).get(12);
        break label563;
        label1777:
        if (this.QSH.jKY.getTimeInMillis() <= this.QSH.jLa.getTimeInMillis()) {
          break label638;
        }
        this.QSH.jKY = this.QSH.jLa;
        break label638;
        if (this.QSH.jKZ != null)
        {
          this.QSH.jKY = this.QSH.jKZ;
          break label638;
        }
        if (this.QSH.jLa == null) {
          break label638;
        }
        this.QSH.jKY = this.QSH.jLa;
        break label638;
        label1872:
        i = this.QSH.jKY.get(1);
        i1 = this.QSH.jKY.get(2);
        n = this.QSH.jKY.get(5);
        m = this.QSH.jKY.get(11);
        k = this.QSH.jKY.get(12);
        j = this.QSH.jKY.get(13);
        break label702;
        if (i == parama.startYear)
        {
          parama.QTF.setAdapter(new d(parama.jLW, 12, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
          parama.QTF.setCurrentItem(i1 + 1 - parama.jLW);
          break label881;
        }
        if (i == parama.endYear)
        {
          parama.QTF.setAdapter(new d(1, parama.jLX, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
          parama.QTF.setCurrentItem(i1);
          break label881;
        }
        if ((parama.QTL) && (i - 1 == parama.startYear))
        {
          parama.QTF.setAdapter(new d(parama.jLW, 12, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
          parama.QTF.setCurrentItem(i1 + 1 - parama.jLW);
          break label881;
        }
        parama.QTF.setAdapter(new d(1, 12, new com.tencent.mm.ui.widget.picker.a.b(parama.ctx)));
        parama.QTF.setCurrentItem(i1);
        break label881;
        if (parama.jMj.contains(String.valueOf(i1 + 1)))
        {
          if (parama.jLZ > 30) {
            parama.jLZ = 30;
          }
          parama.QTG.setAdapter(new d(parama.jLY, parama.jLZ));
          break label982;
        }
        if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
        {
          if (parama.jLZ > 29) {
            parama.jLZ = 29;
          }
          parama.QTG.setAdapter(new d(parama.jLY, parama.jLZ));
          break label982;
        }
        if (parama.jLZ > 28) {
          parama.jLZ = 28;
        }
        parama.QTG.setAdapter(new d(parama.jLY, parama.jLZ));
        break label982;
        if ((i2 == parama.startYear) && (i1 + 1 == parama.jLW))
        {
          if (parama.jMi.contains(String.valueOf(i1 + 1))) {
            parama.QTG.setAdapter(new d(parama.jLY, 31));
          }
          for (;;)
          {
            parama.QTG.setCurrentItem(n - parama.jLY);
            break;
            if (parama.jMj.contains(String.valueOf(i1 + 1))) {
              parama.QTG.setAdapter(new d(parama.jLY, 30));
            } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
              parama.QTG.setAdapter(new d(parama.jLY, 29));
            } else {
              parama.QTG.setAdapter(new d(parama.jLY, 28));
            }
          }
        }
        if ((i2 == parama.endYear) && (i1 + 1 == parama.jLX))
        {
          if (parama.jMi.contains(String.valueOf(i1 + 1)))
          {
            if (parama.jLZ > 31) {
              parama.jLZ = 31;
            }
            parama.QTG.setAdapter(new d(1, parama.jLZ));
          }
          for (;;)
          {
            parama.QTG.setCurrentItem(n - 1);
            break;
            if (parama.jMj.contains(String.valueOf(i1 + 1)))
            {
              if (parama.jLZ > 30) {
                parama.jLZ = 30;
              }
              parama.QTG.setAdapter(new d(1, parama.jLZ));
            }
            else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
            {
              if (parama.jLZ > 29) {
                parama.jLZ = 29;
              }
              parama.QTG.setAdapter(new d(1, parama.jLZ));
            }
            else
            {
              if (parama.jLZ > 28) {
                parama.jLZ = 28;
              }
              parama.QTG.setAdapter(new d(1, parama.jLZ));
            }
          }
        }
        if (parama.jMi.contains(String.valueOf(i1 + 1))) {
          parama.QTG.setAdapter(new d(1, 31));
        }
        for (;;)
        {
          parama.QTG.setCurrentItem(n - 1);
          break;
          if (parama.jMj.contains(String.valueOf(i1 + 1))) {
            parama.QTG.setAdapter(new d(1, 30));
          } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
            parama.QTG.setAdapter(new d(1, 29));
          } else {
            parama.QTG.setAdapter(new d(1, 28));
          }
        }
        label2914:
        if (k > parama.jMd)
        {
          parama.QTI.setCurrentItem(parama.jMd);
        }
        else
        {
          parama.QTI.setCurrentItem(k);
          continue;
          if (m == parama.jMa)
          {
            parama.QTI.setAdapter(new d(parama.jMb, 59));
            if (k < parama.jMb) {
              parama.QTI.setCurrentItem(0);
            } else {
              parama.QTI.setCurrentItem(k - parama.jMb);
            }
          }
          else if (m == parama.jMc)
          {
            parama.QTI.setAdapter(new d(0, parama.jMd));
            if (k >= parama.jMd) {
              parama.QTI.setCurrentItem(parama.jMd);
            } else {
              parama.QTI.setCurrentItem(k);
            }
          }
          else
          {
            parama.QTI.setAdapter(new d(0, 59));
            parama.QTI.setCurrentItem(k);
          }
        }
      }
      j.aP(parama.bll());
      if ((parama.QTL) && (i == 2))
      {
        parama.QTF.aps(0);
        parama.QTG.aps(0);
        parama.QTF.invalidate();
        parama.QTG.invalidate();
      }
      if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
      {
        parama = this.QTy;
        localObject1 = this.QSH.jLb;
        localObject2 = this.QSH.jLc;
        localObject3 = this.QSH.jLd;
        localObject4 = this.QSH.jLe;
        localObject5 = this.QSH.jLf;
        String str = this.QSH.jLg;
        if (localObject1 == null) {
          break label3522;
        }
        parama.QTE.setLabel((String)localObject1);
        if (localObject2 == null) {
          break label3545;
        }
        parama.QTF.setLabel((String)localObject2);
        if (localObject3 == null) {
          break label3568;
        }
        parama.QTG.setLabel((String)localObject3);
        label3284:
        if (localObject4 == null) {
          break label3591;
        }
        parama.QTH.setLabel((String)localObject4);
        label3298:
        if (localObject5 == null) {
          break label3614;
        }
        parama.QTI.setLabel((String)localObject5);
        label3312:
        if (str == null) {
          break label3637;
        }
        parama.QTJ.setLabel(str);
      }
      for (;;)
      {
        Ds(this.QSH.ox);
        this.QTy.setDividerColor(this.QSH.jKu);
        this.QTy.QTM = this.QSH.QTM;
        parama = this.QTy;
        boolean bool = this.QSH.jKV;
        parama.QTE.setCyclic(bool);
        parama.QTF.setCyclic(bool);
        parama.QTG.setCyclic(bool);
        parama.QTH.setCyclic(bool);
        parama.QTI.setCyclic(bool);
        parama.QTJ.setCyclic(bool);
        this.QTy.jLu = this.QSH.jLu;
        parama = this.QTy;
        bool = this.QSH.jKn;
        parama.QTG.jKn = bool;
        parama.QTF.jKn = bool;
        parama.QTE.jKn = bool;
        parama.QTH.jKn = bool;
        parama.QTI.jKn = bool;
        parama.QTJ.jKn = bool;
        AppMethodBeat.o(198444);
        return;
        parama.QTE.setLabel(parama.view.getContext().getString(2131763937));
        break;
        label3545:
        parama.QTF.setLabel(parama.view.getContext().getString(2131763934));
        break label3270;
        label3568:
        parama.QTG.setLabel(parama.view.getContext().getString(2131763931));
        break label3284;
        parama.QTH.setLabel(parama.view.getContext().getString(2131763932));
        break label3298;
        parama.QTI.setLabel(parama.view.getContext().getString(2131763933));
        break label3312;
        parama.QTJ.setLabel(parama.view.getContext().getString(2131763935));
      }
    }
  }
  
  public final boolean blf()
  {
    return this.QSH.jLv;
  }
  
  public final void blg()
  {
    AppMethodBeat.i(198446);
    if (this.QSH.QUA != null) {
      try
      {
        Date localDate = j.dateFormat.parse(this.QTy.getTime());
        this.QSH.QUA.a(localDate);
        AppMethodBeat.o(198446);
        return;
      }
      catch (ParseException localParseException)
      {
        as.printErrStackTrace(this.TAG, localParseException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(198446);
  }
  
  public final View bli()
  {
    AppMethodBeat.i(198447);
    if (this.QTy.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131495933, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131309124);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.QTy.view = localLinearLayout;
    }
    View localView = this.QTy.view;
    AppMethodBeat.o(198447);
    return localView;
  }
  
  public final void dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198449);
    this.QTy.dE(paramInt1, paramInt2);
    AppMethodBeat.o(198449);
  }
  
  public final List<WheelView> hcm()
  {
    AppMethodBeat.i(258313);
    List localList = this.QTy.bll();
    AppMethodBeat.o(258313);
    return localList;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(198445);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (((String)paramView.getTag()).equals("submit")) {
      blg();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(198445);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(198448);
    if (this.QTy != null) {
      this.QTy.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(198448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.h
 * JD-Core Version:    0.7.0.1
 */