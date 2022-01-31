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
  private TextView pcA;
  private WeImageView pcB;
  private BindMobileOrQQHeaderView.a pcC;
  private View.OnClickListener pcD;
  
  public BindMobileOrQQHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(55406);
    this.pcD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55400);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
        paramAnonymousView.putExtra("key_upload_scene", 7);
        MMWizardActivity.J(BindMobileOrQQHeaderView.this.getContext(), paramAnonymousView);
        if (g.abw().pL("3") != null)
        {
          g.abw().pL("3").result = "1";
          f.pQ("3");
        }
        AppMethodBeat.o(55400);
      }
    };
    this.pcC = BindMobileOrQQHeaderView.a.pcG;
    aA(paramContext);
    AppMethodBeat.o(55406);
  }
  
  public BindMobileOrQQHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55405);
    this.pcD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55400);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
        paramAnonymousView.putExtra("key_upload_scene", 7);
        MMWizardActivity.J(BindMobileOrQQHeaderView.this.getContext(), paramAnonymousView);
        if (g.abw().pL("3") != null)
        {
          g.abw().pL("3").result = "1";
          f.pQ("3");
        }
        AppMethodBeat.o(55400);
      }
    };
    aA(paramContext);
    AppMethodBeat.o(55405);
  }
  
  private void aA(Context paramContext)
  {
    AppMethodBeat.i(55407);
    paramContext = View.inflate(paramContext, 2130970342, this);
    this.pcA = ((TextView)paramContext.findViewById(2131826487));
    this.pcB = ((WeImageView)paramContext.findViewById(2131826486));
    switch (2.pcF[this.pcC.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55407);
      return;
      setOnClickListener(this.pcD);
      this.pcB.setImageResource(2131231491);
      AppMethodBeat.o(55407);
      return;
      setOnClickListener(this.pcD);
      this.pcB.setImageResource(2131231498);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView
 * JD-Core Version:    0.7.0.1
 */