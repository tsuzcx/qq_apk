package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.c;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class BindMobileOrQQHeaderView
  extends LinearLayout
{
  private TextView tZY;
  private WeImageView tZZ;
  private a uaa;
  private View.OnClickListener uab;
  
  public BindMobileOrQQHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89803);
    this.uab = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89797);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
        paramAnonymousView.putExtra("key_upload_scene", 7);
        MMWizardActivity.V(BindMobileOrQQHeaderView.this.getContext(), paramAnonymousView);
        if (g.asX().uz("3") != null)
        {
          g.asX().uz("3").result = "1";
          f.uE("3");
        }
        AppMethodBeat.o(89797);
      }
    };
    this.uaa = a.uae;
    aL(paramContext);
    AppMethodBeat.o(89803);
  }
  
  public BindMobileOrQQHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89802);
    this.uab = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89797);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
        paramAnonymousView.putExtra("key_upload_scene", 7);
        MMWizardActivity.V(BindMobileOrQQHeaderView.this.getContext(), paramAnonymousView);
        if (g.asX().uz("3") != null)
        {
          g.asX().uz("3").result = "1";
          f.uE("3");
        }
        AppMethodBeat.o(89797);
      }
    };
    aL(paramContext);
    AppMethodBeat.o(89802);
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(89804);
    paramContext = View.inflate(paramContext, 2131494999, this);
    this.tZY = ((TextView)paramContext.findViewById(2131302701));
    this.tZZ = ((WeImageView)paramContext.findViewById(2131302683));
    switch (2.uad[this.uaa.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89804);
      return;
      setOnClickListener(this.uab);
      this.tZZ.setImageResource(2131690530);
      AppMethodBeat.o(89804);
      return;
      setOnClickListener(this.uab);
      this.tZZ.setImageResource(2131690548);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89801);
      uae = new a("Mobile", 0);
      uaf = new a("UploadContact", 1);
      uag = new a[] { uae, uaf };
      AppMethodBeat.o(89801);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView
 * JD-Core Version:    0.7.0.1
 */