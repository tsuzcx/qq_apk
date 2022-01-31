package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.ui.w;

public class DirectionSwitchFooter
  extends LinearLayout
  implements a
{
  private Context context;
  private ImageView iWb;
  private c uMJ;
  private TextView uNq;
  private a.a uNt;
  private View uNv;
  private View uNw;
  private View uNx;
  private View uNy;
  
  public DirectionSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91571);
    c.a locala = new c.a();
    locala.eNM = true;
    locala.eNL = true;
    this.uMJ = locala.ahY();
    this.context = paramContext;
    init();
    AppMethodBeat.o(91571);
  }
  
  public DirectionSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91572);
    paramAttributeSet = new c.a();
    paramAttributeSet.eNM = true;
    paramAttributeSet.eNL = true;
    this.uMJ = paramAttributeSet.ahY();
    this.context = paramContext;
    init();
    AppMethodBeat.o(91572);
  }
  
  private void init()
  {
    AppMethodBeat.i(91573);
    ViewGroup localViewGroup = (ViewGroup)w.hM(this.context).inflate(2130971327, this);
    this.uNq = ((TextView)localViewGroup.findViewById(2131829593));
    this.iWb = ((ImageView)localViewGroup.findViewById(2131829592));
    this.uNv = localViewGroup.findViewById(2131829597);
    this.uNw = localViewGroup.findViewById(2131821555);
    this.uNx = localViewGroup.findViewById(2131829596);
    this.uNy = localViewGroup.findViewById(2131829598);
    this.uNx.setOnClickListener(new DirectionSwitchFooter.1(this));
    this.uNy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(91570);
        if (DirectionSwitchFooter.a(DirectionSwitchFooter.this) != null) {
          DirectionSwitchFooter.a(DirectionSwitchFooter.this).das();
        }
        AppMethodBeat.o(91570);
      }
    });
    AppMethodBeat.o(91573);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(91576);
    this.uNt = parama;
    if (parama != null)
    {
      if (parama.getItemCount() == 1)
      {
        this.uNx.setVisibility(8);
        this.uNy.setVisibility(8);
      }
      if (this.uNt != null)
      {
        if (!this.uNt.hasNext())
        {
          this.uNy.setEnabled(false);
          this.uNw.setEnabled(false);
        }
        while (!this.uNt.hasPrevious())
        {
          this.uNv.setEnabled(false);
          this.uNx.setEnabled(false);
          AppMethodBeat.o(91576);
          return;
          this.uNw.setEnabled(true);
          this.uNy.setEnabled(true);
        }
        this.uNx.setEnabled(true);
        this.uNv.setEnabled(true);
      }
    }
    AppMethodBeat.o(91576);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(91575);
    if (TextUtils.isEmpty(paramString))
    {
      this.iWb.setVisibility(8);
      AppMethodBeat.o(91575);
      return;
    }
    this.iWb.setVisibility(0);
    com.tencent.mm.at.a.a.ahM().a(paramString, this.iWb, this.uMJ);
    AppMethodBeat.o(91575);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(91574);
    this.uNq.setText(paramString);
    AppMethodBeat.o(91574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter
 * JD-Core Version:    0.7.0.1
 */