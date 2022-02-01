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
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.ui.y;

public class DownArrowSwitchFooter
  extends LinearLayout
  implements a
{
  private TextView AJY;
  private View AJZ;
  private c AJq;
  private a.a AKb;
  private Context context;
  private ImageView lKn;
  
  public DownArrowSwitchFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116752);
    c.a locala = new c.a();
    locala.hjU = true;
    locala.hjT = true;
    this.AJq = locala.azc();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116752);
  }
  
  public DownArrowSwitchFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116753);
    paramAttributeSet = new c.a();
    paramAttributeSet.hjU = true;
    paramAttributeSet.hjT = true;
    this.AJq = paramAttributeSet.azc();
    this.context = paramContext;
    init();
    AppMethodBeat.o(116753);
  }
  
  private void init()
  {
    AppMethodBeat.i(116754);
    ViewGroup localViewGroup = (ViewGroup)y.js(this.context).inflate(2131496111, this);
    this.AJZ = localViewGroup.findViewById(2131299188);
    this.AJY = ((TextView)localViewGroup.findViewById(2131300214));
    this.lKn = ((ImageView)localViewGroup.findViewById(2131300201));
    localViewGroup.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116751);
        if (DownArrowSwitchFooter.a(DownArrowSwitchFooter.this) != null) {
          DownArrowSwitchFooter.a(DownArrowSwitchFooter.this).eiP();
        }
        AppMethodBeat.o(116751);
      }
    });
    AppMethodBeat.o(116754);
  }
  
  public void setCallback(a.a parama)
  {
    AppMethodBeat.i(116757);
    this.AKb = parama;
    if (parama != null)
    {
      if (parama.getItemCount() > 1)
      {
        this.AJZ.setVisibility(0);
        AppMethodBeat.o(116757);
        return;
      }
      this.AJZ.setVisibility(8);
    }
    AppMethodBeat.o(116757);
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(116756);
    if (TextUtils.isEmpty(paramString))
    {
      this.lKn.setVisibility(8);
      AppMethodBeat.o(116756);
      return;
    }
    this.lKn.setVisibility(0);
    com.tencent.mm.aw.a.a.ayO().a(paramString, this.lKn, this.AJq);
    AppMethodBeat.o(116756);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(116755);
    this.AJY.setText(paramString);
    AppMethodBeat.o(116755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter
 * JD-Core Version:    0.7.0.1
 */