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
  private String afdI;
  private TextView afdJ;
  private TextView afdK;
  private TextView afdL;
  private String title;
  private TextView titleTv;
  private boolean yxr;
  
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
    this.yxr = false;
    this.title = "";
    this.afdI = "";
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(37819);
    this.titleTv = ((TextView)paramView.findViewById(R.h.title));
    this.afdJ = ((TextView)paramView.findViewById(R.h.fIk));
    this.afdK = ((TextView)paramView.findViewById(R.h.fVB));
    this.afdL = ((TextView)paramView.findViewById(R.h.fZf));
    this.yxr = true;
    if (!this.yxr)
    {
      Log.e("MicroMsg.DomainMailPreference", "initView : unbind view");
      super.onBindView(paramView);
      AppMethodBeat.o(37819);
      return;
    }
    this.titleTv.setText(Util.nullAsNil(this.title));
    String[] arrayOfString = this.afdI.split(";");
    if (Util.nullAsNil(this.afdI).length() <= 0)
    {
      this.afdJ.setVisibility(8);
      this.afdK.setVisibility(8);
    }
    label263:
    for (;;)
    {
      this.afdL.setVisibility(8);
      break;
      if (arrayOfString.length > 0)
      {
        this.afdJ.setVisibility(0);
        this.afdJ.setText(Util.nullAsNil(arrayOfString[0]));
        label184:
        if (arrayOfString.length <= 1) {
          break label253;
        }
        this.afdK.setVisibility(0);
        this.afdK.setText(Util.nullAsNil(arrayOfString[1]));
      }
      for (;;)
      {
        if (arrayOfString.length <= 2) {
          break label263;
        }
        this.afdL.setVisibility(0);
        this.afdL.setText(Util.nullAsNil(arrayOfString[2]));
        break;
        this.afdJ.setVisibility(8);
        break label184;
        label253:
        this.afdK.setVisibility(8);
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
    localLayoutInflater.inflate(R.i.glO, localViewGroup);
    AppMethodBeat.o(37818);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.DomainMailListPreference
 * JD-Core Version:    0.7.0.1
 */