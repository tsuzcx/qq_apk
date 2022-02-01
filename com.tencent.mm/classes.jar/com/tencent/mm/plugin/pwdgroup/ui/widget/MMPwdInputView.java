package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.profile.ui.a.b;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import org.xwalk.core.Log;

public class MMPwdInputView
  extends LinearLayout
{
  private boolean NhY;
  private ImageView NhZ;
  private ImageView Nia;
  private ImageView Nib;
  private ImageView Nic;
  private a Nid;
  private MMPwdInputView.b Nie;
  public StringBuilder lOv;
  public int zYG;
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27697);
    this.lOv = new StringBuilder();
    this.NhY = false;
    this.Nie = MMPwdInputView.b.Nig;
    paramContext = inflate(getContext(), R.i.gnn, null);
    this.NhZ = ((ImageView)paramContext.findViewById(R.h.fIj));
    this.Nia = ((ImageView)paramContext.findViewById(R.h.second));
    this.Nib = ((ImageView)paramContext.findViewById(R.h.fZe));
    this.Nic = ((ImageView)paramContext.findViewById(R.h.fIP));
    this.NhZ.setImageResource(R.g.fmA);
    this.Nia.setImageResource(R.g.fmA);
    this.Nib.setImageResource(R.g.fmA);
    this.Nic.setImageResource(R.g.fmA);
    addView(paramContext);
    AppMethodBeat.o(27697);
  }
  
  private static void w(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(27700);
    if (paramImageView == null)
    {
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("0"))
    {
      paramImageView.setImageResource(R.g.fmq);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("1"))
    {
      paramImageView.setImageResource(R.g.fmr);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("2"))
    {
      paramImageView.setImageResource(R.g.fms);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("3"))
    {
      paramImageView.setImageResource(R.g.fmt);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("4"))
    {
      paramImageView.setImageResource(R.g.fmu);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("5"))
    {
      paramImageView.setImageResource(R.g.fmv);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("6"))
    {
      paramImageView.setImageResource(R.g.fmw);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("7"))
    {
      paramImageView.setImageResource(R.g.fmx);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("8"))
    {
      paramImageView.setImageResource(R.g.fmy);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("9"))
    {
      paramImageView.setImageResource(R.g.fmz);
      AppMethodBeat.o(27700);
      return;
    }
    paramImageView.setImageResource(R.g.fmA);
    AppMethodBeat.o(27700);
  }
  
  public final void aSi(String paramString)
  {
    AppMethodBeat.i(27703);
    if ((TextUtils.isEmpty(paramString)) || (this.NhY))
    {
      AppMethodBeat.o(27703);
      return;
    }
    this.lOv.append(paramString);
    dPM();
    gDF();
    AppMethodBeat.o(27703);
  }
  
  public final void cju()
  {
    AppMethodBeat.i(27702);
    if (this.zYG > 0) {
      this.lOv.delete(0, this.zYG);
    }
    dPM();
    gDF();
    AppMethodBeat.o(27702);
  }
  
  public final void dPM()
  {
    AppMethodBeat.i(27701);
    if (this.lOv != null)
    {
      this.zYG = this.lOv.length();
      if (this.zYG < 4) {
        break label79;
      }
    }
    label79:
    for (this.NhY = true;; this.NhY = false)
    {
      if (this.Nid != null) {
        this.Nid.ar(this.NhY, this.lOv.toString());
      }
      AppMethodBeat.o(27701);
      return;
      this.zYG = 0;
      break;
    }
  }
  
  public final void gDF()
  {
    AppMethodBeat.i(27699);
    int i = 0;
    if (i < 4)
    {
      String str;
      if (this.zYG > i)
      {
        str = this.lOv.toString().charAt(i);
        label46:
        switch (i)
        {
        }
      }
      for (;;)
      {
        i += 1;
        break;
        str = "";
        break label46;
        w(this.NhZ, str);
        k localk = k.aeZF;
        ((b)k.nq(getContext()).q(b.class)).setValue("title_num_1", str);
        Log.i("MicroMsg.Facing.MMPwdInputView", "1, number = ".concat(String.valueOf(str)));
        continue;
        w(this.Nia, str);
        localk = k.aeZF;
        ((b)k.nq(getContext()).q(b.class)).setValue("title_num_2", str);
        Log.i("MicroMsg.Facing.MMPwdInputView", "2, number = ".concat(String.valueOf(str)));
        continue;
        w(this.Nib, str);
        localk = k.aeZF;
        ((b)k.nq(getContext()).q(b.class)).setValue("title_num_3", str);
        Log.i("MicroMsg.Facing.MMPwdInputView", "3, number = ".concat(String.valueOf(str)));
        continue;
        w(this.Nic, str);
        localk = k.aeZF;
        ((b)k.nq(getContext()).q(b.class)).setValue("title_num_4", str);
        Log.i("MicroMsg.Facing.MMPwdInputView", "4, number = ".concat(String.valueOf(str)));
      }
    }
    AppMethodBeat.o(27699);
  }
  
  public void setNumberStyle(MMPwdInputView.b paramb)
  {
    this.Nie = paramb;
  }
  
  public void setNumberWidth(int paramInt)
  {
    AppMethodBeat.i(27698);
    if (this.NhZ != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.NhZ.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.NhZ.setLayoutParams(localLayoutParams);
      this.Nia.setLayoutParams(localLayoutParams);
      this.Nib.setLayoutParams(localLayoutParams);
      this.Nic.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(27698);
  }
  
  public void setOnFinishInputListener(a parama)
  {
    this.Nid = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ar(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView
 * JD-Core Version:    0.7.0.1
 */