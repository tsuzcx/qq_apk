package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class BindMobileOrQQHeaderView
  extends LinearLayout
{
  private WeImageView sfv;
  private TextView wor;
  private a wos;
  private View.OnClickListener wot;
  
  public BindMobileOrQQHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89803);
    this.wot = new BindMobileOrQQHeaderView.1(this);
    this.wos = a.wow;
    aM(paramContext);
    AppMethodBeat.o(89803);
  }
  
  public BindMobileOrQQHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89802);
    this.wot = new BindMobileOrQQHeaderView.1(this);
    aM(paramContext);
    AppMethodBeat.o(89802);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(89804);
    paramContext = View.inflate(paramContext, 2131494999, this);
    this.wor = ((TextView)paramContext.findViewById(2131302701));
    this.sfv = ((WeImageView)paramContext.findViewById(2131302683));
    switch (2.wov[this.wos.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89804);
      return;
      setOnClickListener(this.wot);
      this.sfv.setImageResource(2131690530);
      AppMethodBeat.o(89804);
      return;
      setOnClickListener(this.wot);
      this.sfv.setImageResource(2131690548);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89801);
      wow = new a("Mobile", 0);
      wox = new a("UploadContact", 1);
      woy = new a[] { wow, wox };
      AppMethodBeat.o(89801);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView
 * JD-Core Version:    0.7.0.1
 */