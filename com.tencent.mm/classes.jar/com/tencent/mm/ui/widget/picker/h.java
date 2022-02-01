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
  j HJo;
  boolean HJp;
  private String TAG;
  private Context context;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(195296);
    this.TAG = "TimePickerView";
    this.HJp = false;
    this.HJo = new j(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(195296);
  }
  
  public final void a(com.tencent.mm.ui.widget.picker.c.a parama)
  {
    AppMethodBeat.i(195297);
    this.HID = parama;
    Object localObject5 = parama.context;
    aGc();
    aFZ();
    aGa();
    LayoutInflater.from((Context)localObject5).inflate(2131496156, this.hSH);
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
    if (TextUtils.isEmpty(this.HID.hSt))
    {
      parama = ((Context)localObject5).getResources().getString(2131761930);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.HID.hSu)) {
        break label1316;
      }
      parama = ((Context)localObject5).getResources().getString(2131761924);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.HID.hSv)) {
        break label1327;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.HID.hSw);
      ((Button)localObject4).setTextColor(this.HID.hSx);
      ((TextView)localObject1).setTextColor(this.HID.hSy);
      ((RelativeLayout)localObject2).setBackgroundColor(this.HID.hSA);
      ((Button)localObject3).setTextSize(this.HID.hSB);
      ((Button)localObject4).setTextSize(this.HID.hSB);
      ((TextView)localObject1).setTextSize(this.HID.hSC);
      parama = this.HJo;
      localObject1 = this.HID.hSh;
      i = this.HID.hSs;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.hSh = ((boolean[])localObject1);
      parama.gravity = i;
      if (this.HID.HKq != null) {
        this.HJo.HJD = new com.tencent.mm.ui.widget.picker.d.a()
        {
          public final void aFY()
          {
            AppMethodBeat.i(195295);
            try
            {
              j.hTa.parse(h.a(h.this).aGk());
              h.this.HID.HKq.ffX();
              AppMethodBeat.o(195295);
              return;
            }
            catch (ParseException localParseException)
            {
              an.printErrStackTrace(h.b(h.this), localParseException, "", new Object[0]);
              AppMethodBeat.o(195295);
            }
          }
        };
      }
      if ((this.HID.startYear != 0) && (this.HID.endYear != 0) && (this.HID.startYear <= this.HID.endYear))
      {
        this.HJo.startYear = this.HID.startYear;
        this.HJo.endYear = this.HID.endYear;
      }
      if ((this.HID.hSj == null) || (this.HID.hSk == null)) {
        break label1338;
      }
      if (this.HID.hSj.getTimeInMillis() > this.HID.hSk.getTimeInMillis())
      {
        an.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null", new Object[0]);
        this.HID.hSj = null;
      }
      parama = this.HJo;
      localObject1 = this.HID.hSj;
      localObject2 = this.HID.hSk;
      if ((localObject1 != null) || (localObject2 == null)) {
        break label1513;
      }
      i = ((Calendar)localObject2).get(1);
      j = ((Calendar)localObject2).get(2) + 1;
      k = ((Calendar)localObject2).get(5);
      if (i <= parama.startYear) {
        break label1442;
      }
      parama.endYear = i;
      parama.hTi = j;
      parama.hTk = k;
      if (!this.HJp)
      {
        if ((this.HID.hSj == null) || (this.HID.hSk == null)) {
          break label1807;
        }
        if ((this.HID.hSi != null) && (this.HID.hSi.getTimeInMillis() >= this.HID.hSj.getTimeInMillis())) {
          break label1766;
        }
        this.HID.hSi = this.HID.hSj;
      }
      if (this.HID.hSi != null) {
        break label1861;
      }
      parama = Calendar.getInstance();
      parama.setTimeInMillis(System.currentTimeMillis());
      i1 = parama.get(1);
      n = parama.get(2);
      m = parama.get(5);
      k = parama.get(11);
      j = parama.get(12);
      i = parama.get(13);
      label702:
      parama = this.HJo;
      parama.hTp = i1;
      parama.HJu = ((WheelView)parama.view.findViewById(2131307138));
      parama.HJv = ((WheelView)parama.view.findViewById(2131302450));
      parama.HJw = ((WheelView)parama.view.findViewById(2131298935));
      parama.HJA = new com.tencent.mm.ui.widget.picker.a.f(parama.startYear, parama.endYear, parama.ctx);
      parama.HJu.setAdapter(parama.HJA);
      parama.HJu.setCurrentItem(i1 - parama.startYear);
      parama.HJu.setGravity(parama.gravity);
      if (parama.startYear != parama.endYear) {
        break label1943;
      }
      parama.HJv.setAdapter(new d(parama.hTh, parama.hTi, new b(parama.ctx)));
      parama.HJv.setCurrentItem(n + 1 - parama.hTh);
      label883:
      parama.HJv.setGravity(parama.gravity);
      if ((parama.startYear != parama.endYear) || (parama.hTh != parama.hTi)) {
        break label2256;
      }
      if (!parama.hTt.contains(String.valueOf(n + 1))) {
        break label2093;
      }
      if (parama.hTk > 31) {
        parama.hTk = 31;
      }
      parama.HJw.setAdapter(new d(parama.hTj, parama.hTk));
      label972:
      parama.HJw.setCurrentItem(m - parama.hTj);
      parama.HJw.setGravity(parama.gravity);
      parama.HJx = ((WheelView)parama.view.findViewById(2131300765));
      parama.HJx.setAdapter(new d(parama.hTl, parama.hTn));
      parama.HJx.setCurrentItem(k - parama.hTl);
      parama.HJx.setGravity(parama.gravity);
      parama.HJy = ((WheelView)parama.view.findViewById(2131302275));
      if ((k != parama.hTl) || (parama.hTl != parama.hTn)) {
        break label2871;
      }
      parama.HJy.setAdapter(new d(parama.hTm, parama.hTo));
      if (j >= parama.hTm) {
        break label2838;
      }
      parama.HJy.setCurrentItem(0);
    }
    for (;;)
    {
      parama.HJy.setGravity(parama.gravity);
      parama.HJz = ((WheelView)parama.view.findViewById(2131304457));
      parama.HJz.setAdapter(new d(0, 59));
      parama.HJz.setCurrentItem(i);
      parama.HJz.setGravity(parama.gravity);
      parama.HJx.setOnItemSelectedListener(new j.3(parama));
      parama.HJu.setOnItemSelectedListener(new j.2(parama));
      parama.HJv.setOnItemSelectedListener(new j.1(parama));
      parama.a(parama.HJw);
      parama.a(parama.HJx);
      parama.a(parama.HJy);
      parama.a(parama.HJz);
      if (parama.hSh.length == 6) {
        break label3024;
      }
      parama = new IllegalArgumentException("type[] length is not 6");
      AppMethodBeat.o(195297);
      throw parama;
      parama = this.HID.hSt;
      break;
      label1316:
      parama = this.HID.hSu;
      break label167;
      label1327:
      parama = this.HID.hSv;
      break label189;
      label1338:
      if (this.HID.hSj != null)
      {
        if (this.HID.hSj.get(1) >= 1900) {
          break label482;
        }
        an.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null", new Object[0]);
        this.HID.hSj = null;
        break label482;
      }
      if ((this.HID.hSk == null) || (this.HID.hSk.get(1) <= 2100)) {
        break label482;
      }
      an.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null", new Object[0]);
      this.HID.hSj = null;
      break label482;
      label1442:
      if (i != parama.startYear) {
        break label563;
      }
      if (j > parama.hTh)
      {
        parama.endYear = i;
        parama.hTi = j;
        parama.hTk = k;
        break label563;
      }
      if ((j != parama.hTh) || (k <= parama.hTj)) {
        break label563;
      }
      parama.endYear = i;
      parama.hTi = j;
      parama.hTk = k;
      break label563;
      label1513:
      if ((localObject1 != null) && (localObject2 == null))
      {
        i = ((Calendar)localObject1).get(1);
        j = ((Calendar)localObject1).get(2) + 1;
        k = ((Calendar)localObject1).get(5);
        if (i < parama.endYear)
        {
          parama.hTh = j;
          parama.hTj = k;
          parama.startYear = i;
          break label563;
        }
        if (i != parama.endYear) {
          break label563;
        }
        if (j < parama.hTi)
        {
          parama.hTh = j;
          parama.hTj = k;
          parama.startYear = i;
          break label563;
        }
        if ((j != parama.hTi) || (k >= parama.hTk)) {
          break label563;
        }
        parama.hTh = j;
        parama.hTj = k;
        parama.startYear = i;
        break label563;
      }
      if ((localObject1 == null) || (localObject2 == null)) {
        break label563;
      }
      parama.startYear = ((Calendar)localObject1).get(1);
      parama.endYear = ((Calendar)localObject2).get(1);
      parama.hTh = (((Calendar)localObject1).get(2) + 1);
      parama.hTi = (((Calendar)localObject2).get(2) + 1);
      parama.hTj = ((Calendar)localObject1).get(5);
      parama.hTk = ((Calendar)localObject2).get(5);
      parama.hTl = ((Calendar)localObject1).get(11);
      parama.hTm = ((Calendar)localObject1).get(12);
      parama.hTn = ((Calendar)localObject2).get(11);
      parama.hTo = ((Calendar)localObject2).get(12);
      break label563;
      label1766:
      if (this.HID.hSi.getTimeInMillis() <= this.HID.hSk.getTimeInMillis()) {
        break label638;
      }
      this.HID.hSi = this.HID.hSk;
      break label638;
      label1807:
      if (this.HID.hSj != null)
      {
        this.HID.hSi = this.HID.hSj;
        break label638;
      }
      if (this.HID.hSk == null) {
        break label638;
      }
      this.HID.hSi = this.HID.hSk;
      break label638;
      label1861:
      i1 = this.HID.hSi.get(1);
      n = this.HID.hSi.get(2);
      m = this.HID.hSi.get(5);
      k = this.HID.hSi.get(11);
      j = this.HID.hSi.get(12);
      i = this.HID.hSi.get(13);
      break label702;
      label1943:
      if (i1 == parama.startYear)
      {
        parama.HJv.setAdapter(new d(parama.hTh, 12, new b(parama.ctx)));
        parama.HJv.setCurrentItem(n + 1 - parama.hTh);
        break label883;
      }
      if (i1 == parama.endYear)
      {
        parama.HJv.setAdapter(new d(1, parama.hTi, new b(parama.ctx)));
        parama.HJv.setCurrentItem(n);
        break label883;
      }
      parama.HJv.setAdapter(new d(1, 12, new b(parama.ctx)));
      parama.HJv.setCurrentItem(n);
      break label883;
      label2093:
      if (parama.hTu.contains(String.valueOf(n + 1)))
      {
        if (parama.hTk > 30) {
          parama.hTk = 30;
        }
        parama.HJw.setAdapter(new d(parama.hTj, parama.hTk));
        break label972;
      }
      if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
      {
        if (parama.hTk > 29) {
          parama.hTk = 29;
        }
        parama.HJw.setAdapter(new d(parama.hTj, parama.hTk));
        break label972;
      }
      if (parama.hTk > 28) {
        parama.hTk = 28;
      }
      parama.HJw.setAdapter(new d(parama.hTj, parama.hTk));
      break label972;
      label2256:
      if ((i1 == parama.startYear) && (n + 1 == parama.hTh))
      {
        if (parama.hTt.contains(String.valueOf(n + 1))) {
          parama.HJw.setAdapter(new d(parama.hTj, 31));
        }
        for (;;)
        {
          parama.HJw.setCurrentItem(m - parama.hTj);
          break;
          if (parama.hTu.contains(String.valueOf(n + 1))) {
            parama.HJw.setAdapter(new d(parama.hTj, 30));
          } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
            parama.HJw.setAdapter(new d(parama.hTj, 29));
          } else {
            parama.HJw.setAdapter(new d(parama.hTj, 28));
          }
        }
      }
      if ((i1 == parama.endYear) && (n + 1 == parama.hTi))
      {
        if (parama.hTt.contains(String.valueOf(n + 1)))
        {
          if (parama.hTk > 31) {
            parama.hTk = 31;
          }
          parama.HJw.setAdapter(new d(1, parama.hTk));
        }
        for (;;)
        {
          parama.HJw.setCurrentItem(m - 1);
          break;
          if (parama.hTu.contains(String.valueOf(n + 1)))
          {
            if (parama.hTk > 30) {
              parama.hTk = 30;
            }
            parama.HJw.setAdapter(new d(1, parama.hTk));
          }
          else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
          {
            if (parama.hTk > 29) {
              parama.hTk = 29;
            }
            parama.HJw.setAdapter(new d(1, parama.hTk));
          }
          else
          {
            if (parama.hTk > 28) {
              parama.hTk = 28;
            }
            parama.HJw.setAdapter(new d(1, parama.hTk));
          }
        }
      }
      if (parama.hTt.contains(String.valueOf(n + 1))) {
        parama.HJw.setAdapter(new d(1, 31));
      }
      for (;;)
      {
        parama.HJw.setCurrentItem(m - 1);
        break;
        if (parama.hTu.contains(String.valueOf(n + 1))) {
          parama.HJw.setAdapter(new d(1, 30));
        } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
          parama.HJw.setAdapter(new d(1, 29));
        } else {
          parama.HJw.setAdapter(new d(1, 28));
        }
      }
      label2838:
      if (j > parama.hTo)
      {
        parama.HJy.setCurrentItem(parama.hTo);
      }
      else
      {
        parama.HJy.setCurrentItem(j);
        continue;
        label2871:
        if (k == parama.hTl)
        {
          parama.HJy.setAdapter(new d(parama.hTm, 59));
          if (j < parama.hTm) {
            parama.HJy.setCurrentItem(0);
          } else {
            parama.HJy.setCurrentItem(j - parama.hTm);
          }
        }
        else if (k == parama.hTn)
        {
          parama.HJy.setAdapter(new d(0, parama.hTo));
          if (j >= parama.hTo) {
            parama.HJy.setCurrentItem(parama.hTo);
          } else {
            parama.HJy.setCurrentItem(j);
          }
        }
        else
        {
          parama.HJy.setAdapter(new d(0, 59));
          parama.HJy.setCurrentItem(j);
        }
      }
    }
    label3024:
    j.aJ(parama.aGj());
    if ((parama.HJB) && (i1 == 2))
    {
      parama.HJv.aaU(0);
      parama.HJw.aaU(0);
      parama.HJv.invalidate();
      parama.HJw.invalidate();
    }
    if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
    {
      parama = this.HJo;
      localObject1 = this.HID.hSl;
      localObject2 = this.HID.hSm;
      localObject3 = this.HID.hSn;
      localObject4 = this.HID.hSo;
      localObject5 = this.HID.hSp;
      String str = this.HID.hSq;
      if (localObject1 == null) {
        break label3440;
      }
      parama.HJu.setLabel((String)localObject1);
      if (localObject2 == null) {
        break label3463;
      }
      parama.HJv.setLabel((String)localObject2);
      label3188:
      if (localObject3 == null) {
        break label3486;
      }
      parama.HJw.setLabel((String)localObject3);
      label3202:
      if (localObject4 == null) {
        break label3509;
      }
      parama.HJx.setLabel((String)localObject4);
      label3216:
      if (localObject5 == null) {
        break label3532;
      }
      parama.HJy.setLabel((String)localObject5);
      label3230:
      if (str == null) {
        break label3555;
      }
      parama.HJz.setLabel(str);
    }
    for (;;)
    {
      xa(this.HID.lA);
      this.HJo.setDividerColor(this.HID.hRF);
      this.HJo.HJC = this.HID.HJC;
      parama = this.HJo;
      boolean bool = this.HID.hSf;
      parama.HJu.setCyclic(bool);
      parama.HJv.setCyclic(bool);
      parama.HJw.setCyclic(bool);
      parama.HJx.setCyclic(bool);
      parama.HJy.setCyclic(bool);
      parama.HJz.setCyclic(bool);
      this.HJo.hSE = this.HID.hSE;
      parama = this.HJo;
      bool = this.HID.hRy;
      parama.HJw.hRy = bool;
      parama.HJv.hRy = bool;
      parama.HJu.hRy = bool;
      parama.HJx.hRy = bool;
      parama.HJy.hRy = bool;
      parama.HJz.hRy = bool;
      AppMethodBeat.o(195297);
      return;
      label3440:
      parama.HJu.setLabel(parama.view.getContext().getString(2131761931));
      break;
      label3463:
      parama.HJv.setLabel(parama.view.getContext().getString(2131761928));
      break label3188;
      label3486:
      parama.HJw.setLabel(parama.view.getContext().getString(2131761925));
      break label3202;
      label3509:
      parama.HJx.setLabel(parama.view.getContext().getString(2131761926));
      break label3216;
      label3532:
      parama.HJy.setLabel(parama.view.getContext().getString(2131761927));
      break label3230;
      label3555:
      parama.HJz.setLabel(parama.view.getContext().getString(2131761929));
    }
  }
  
  public final boolean aGd()
  {
    return this.HID.hSF;
  }
  
  public final void aGe()
  {
    AppMethodBeat.i(195299);
    if (this.HID.HKp != null) {
      try
      {
        Date localDate = j.hTa.parse(this.HJo.aGk());
        this.HID.HKp.a(localDate);
        AppMethodBeat.o(195299);
        return;
      }
      catch (ParseException localParseException)
      {
        an.printErrStackTrace(this.TAG, localParseException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(195299);
  }
  
  public final View aGg()
  {
    AppMethodBeat.i(195300);
    if (this.HJo.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131496156, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131305844);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.HJo.view = localLinearLayout;
    }
    View localView = this.HJo.view;
    AppMethodBeat.o(195300);
    return localView;
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195302);
    this.HJo.ds(paramInt1, paramInt2);
    AppMethodBeat.o(195302);
  }
  
  public final List<WheelView> fgc()
  {
    AppMethodBeat.i(202397);
    List localList = this.HJo.aGj();
    AppMethodBeat.o(202397);
    return localList;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195298);
    if (((String)paramView.getTag()).equals("submit")) {
      aGe();
    }
    dismiss();
    AppMethodBeat.o(195298);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(195301);
    if (this.HJo != null) {
      this.HJo.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(195301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.h
 * JD-Core Version:    0.7.0.1
 */