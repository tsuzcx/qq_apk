package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.az;

public class ArtistHeader
  extends LinearLayout
  implements b.b
{
  private Context context;
  private View jbK;
  private com.tencent.mm.ui.base.i mGI;
  private ArtistHeader.b rEC;
  private ImageView rED;
  private ProgressBar rEE;
  private fo rEx;
  
  public ArtistHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38108);
    this.rEx = null;
    this.mGI = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(38108);
  }
  
  public ArtistHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38109);
    this.rEx = null;
    this.mGI = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(38109);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(38110);
    View localView = LayoutInflater.from(paramContext).inflate(2130970807, this, true);
    this.context = paramContext;
    this.rEC = new ArtistHeader.b(this);
    this.rEC.ehv = ((ImageView)localView.findViewById(2131827904));
    this.rEC.hsI = ((TextView)localView.findViewById(2131827907));
    this.rEC.rEH = ((TextView)localView.findViewById(2131827905));
    this.rEC.rEI = ((TextView)localView.findViewById(2131827908));
    this.rEC.titleTv = ((TextView)localView.findViewById(2131827906));
    this.rEC.ehv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38106);
        if ((ArtistHeader.a(ArtistHeader.this) != null) && (ArtistHeader.a(ArtistHeader.this).isShowing()))
        {
          AppMethodBeat.o(38106);
          return;
        }
        if (ArtistHeader.b(ArtistHeader.this) == null)
        {
          AppMethodBeat.o(38106);
          return;
        }
        paramAnonymousView = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(2130971080, null);
        ArtistHeader.a(ArtistHeader.this, new com.tencent.mm.ui.base.i(ArtistHeader.this.getContext(), 2131493880));
        paramAnonymousView.setOnClickListener(new ArtistHeader.1.1(this));
        ArtistHeader.a(ArtistHeader.this).setCanceledOnTouchOutside(true);
        ArtistHeader.a(ArtistHeader.this).setContentView(paramAnonymousView);
        ArtistHeader.a(ArtistHeader.this).show();
        ArtistHeader.a(ArtistHeader.this, (ImageView)paramAnonymousView.findViewById(2131828738));
        ArtistHeader.a(ArtistHeader.this, (ProgressBar)paramAnonymousView.findViewById(2131828740));
        ArtistHeader.a(ArtistHeader.this, paramAnonymousView.findViewById(2131828739));
        paramAnonymousView = ag.cpc().a(ArtistHeader.b(ArtistHeader.this).wrE.wrF, ArtistHeader.c(ArtistHeader.this), paramContext.hashCode(), true, az.yNU, false);
        if (com.tencent.mm.plugin.sns.data.i.A(paramAnonymousView))
        {
          ArtistHeader.a(ArtistHeader.this, paramAnonymousView);
          ArtistHeader.d(ArtistHeader.this).setVisibility(4);
          ArtistHeader.e(ArtistHeader.this).setVisibility(4);
          AppMethodBeat.o(38106);
          return;
        }
        ag.cpc().b(ArtistHeader.b(ArtistHeader.this).wrE.wrF, ArtistHeader.c(ArtistHeader.this), paramContext.hashCode(), az.yNU);
        AppMethodBeat.o(38106);
      }
    });
    AppMethodBeat.o(38110);
  }
  
  public final void ZU(String paramString) {}
  
  public final void bp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(38112);
    if (this.rEx == null)
    {
      AppMethodBeat.o(38112);
      return;
    }
    if ((this.mGI != null) && (this.mGI.isShowing()))
    {
      if (!paramBoolean)
      {
        bcs localbcs = this.rEx.wrE.wrF;
        if ((localbcs.Id != null) && (localbcs.Id.equals(paramString)))
        {
          Toast.makeText(this.context, this.context.getString(2131303799), 0).show();
          AppMethodBeat.o(38112);
          return;
        }
      }
      if (this.rED != null) {
        this.rED.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38107);
            Bitmap localBitmap = ag.cpc().a(ArtistHeader.b(ArtistHeader.this).wrE.wrF, ArtistHeader.c(ArtistHeader.this), ArtistHeader.f(ArtistHeader.this).hashCode(), true, az.yNU, false);
            if (com.tencent.mm.plugin.sns.data.i.A(localBitmap))
            {
              ArtistHeader.a(ArtistHeader.this, localBitmap);
              ArtistHeader.d(ArtistHeader.this).setVisibility(4);
              ArtistHeader.e(ArtistHeader.this).setVisibility(4);
              AppMethodBeat.o(38107);
              return;
            }
            AppMethodBeat.o(38107);
          }
        });
      }
    }
    AppMethodBeat.o(38112);
  }
  
  public final void bq(String paramString, boolean paramBoolean) {}
  
  public final void cnV() {}
  
  public void setBackClickListener(ArtistHeader.a parama) {}
  
  public void setUserName(fo paramfo)
  {
    AppMethodBeat.i(38111);
    if (paramfo == null)
    {
      ab.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
      AppMethodBeat.o(38111);
      return;
    }
    this.rEx = paramfo;
    ag.cpc().b(paramfo.wrE.wrF, this.rEC.ehv, this.context.hashCode(), az.yNU);
    this.rEC.rEH.setText(paramfo.Name);
    this.rEC.hsI.setText(paramfo.woO);
    this.rEC.titleTv.setText(paramfo.Title);
    this.rEC.rEI.setText(paramfo.wrD);
    AppMethodBeat.o(38111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistHeader
 * JD-Core Version:    0.7.0.1
 */