package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference
  extends Preference
{
  private String Xsh;
  private TextView Xsi;
  private TextView Xsj;
  private TextView Xsk;
  private String title;
  private TextView titleTv;
  private boolean vkO;
  
  public DomainMailListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37816);
    init();
    AppMethodBeat.o(37816);
  }
  
  public DomainMailListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37817);
    init();
    AppMethodBeat.o(37817);
  }
  
  private void init()
  {
    this.vkO = false;
    this.title = "";
    this.Xsh = "";
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(37819);
    this.titleTv = ((TextView)paramView.findViewById(R.h.title));
    this.Xsi = ((TextView)paramView.findViewById(R.h.dHb));
    this.Xsj = ((TextView)paramView.findViewById(R.h.dTu));
    this.Xsk = ((TextView)paramView.findViewById(R.h.dWz));
    this.vkO = true;
    if (!this.vkO)
    {
      Log.e("MicroMsg.DomainMailPreference", "initView : unbind view");
      super.onBindView(paramView);
      AppMethodBeat.o(37819);
      return;
    }
    this.titleTv.setText(Util.nullAsNil(this.title));
    String[] arrayOfString = this.Xsh.split(";");
    if (Util.nullAsNil(this.Xsh).length() <= 0)
    {
      this.Xsi.setVisibility(8);
      this.Xsj.setVisibility(8);
    }
    label263:
    for (;;)
    {
      this.Xsk.setVisibility(8);
      break;
      if (arrayOfString.length > 0)
      {
        this.Xsi.setVisibility(0);
        this.Xsi.setText(Util.nullAsNil(arrayOfString[0]));
        label184:
        if (arrayOfString.length <= 1) {
          break label253;
        }
        this.Xsj.setVisibility(0);
        this.Xsj.setText(Util.nullAsNil(arrayOfString[1]));
      }
      for (;;)
      {
        if (arrayOfString.length <= 2) {
          break label263;
        }
        this.Xsk.setVisibility(0);
        this.Xsk.setText(Util.nullAsNil(arrayOfString[2]));
        break;
        this.Xsi.setVisibility(8);
        break label184;
        label253:
        this.Xsj.setVisibility(8);
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37818);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.eiP, localViewGroup);
    AppMethodBeat.o(37818);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.DomainMailListPreference
 * JD-Core Version:    0.7.0.1
 */