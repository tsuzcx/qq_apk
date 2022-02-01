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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.model.f.e;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.base.i;

public class ArtistHeader
  extends LinearLayout
  implements b.b
{
  private Context context;
  private View lRB;
  private i rcR;
  private gg xkh;
  private b xkm;
  private ImageView xkn;
  private ProgressBar xko;
  
  public ArtistHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97731);
    this.xkh = null;
    this.rcR = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97731);
  }
  
  public ArtistHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97732);
    this.xkh = null;
    this.rcR = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97732);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97733);
    View localView = LayoutInflater.from(paramContext).inflate(2131495527, this, true);
    this.context = paramContext;
    this.xkm = new b();
    this.xkm.fuj = ((ImageView)localView.findViewById(2131296947));
    this.xkm.lEA = ((TextView)localView.findViewById(2131296284));
    this.xkm.xks = ((TextView)localView.findViewById(2131296287));
    this.xkm.xkt = ((TextView)localView.findViewById(2131296285));
    this.xkm.titleTv = ((TextView)localView.findViewById(2131296286));
    this.xkm.fuj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97728);
        if ((ArtistHeader.a(ArtistHeader.this) != null) && (ArtistHeader.a(ArtistHeader.this).isShowing()))
        {
          AppMethodBeat.o(97728);
          return;
        }
        if (ArtistHeader.b(ArtistHeader.this) == null)
        {
          AppMethodBeat.o(97728);
          return;
        }
        paramAnonymousView = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(2131495846, null);
        ArtistHeader.a(ArtistHeader.this, new i(ArtistHeader.this.getContext(), 2131821722));
        paramAnonymousView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(97726);
            ArtistHeader.a(ArtistHeader.this).dismiss();
            AppMethodBeat.o(97726);
          }
        });
        ArtistHeader.a(ArtistHeader.this).setCanceledOnTouchOutside(true);
        ArtistHeader.a(ArtistHeader.this).setContentView(paramAnonymousView);
        ArtistHeader.a(ArtistHeader.this).show();
        ArtistHeader.a(ArtistHeader.this, (ImageView)paramAnonymousView.findViewById(2131300688));
        ArtistHeader.a(ArtistHeader.this, (ProgressBar)paramAnonymousView.findViewById(2131300689));
        ArtistHeader.a(ArtistHeader.this, paramAnonymousView.findViewById(2131300690));
        af.dtr().a(ArtistHeader.b(ArtistHeader.this).CAS.CAT, ArtistHeader.c(ArtistHeader.this), paramContext.hashCode(), true, bc.FzF, false, new f.e()
        {
          public final void ai(Bitmap paramAnonymous2Bitmap)
          {
            AppMethodBeat.i(97727);
            if (q.I(paramAnonymous2Bitmap))
            {
              ArtistHeader.a(ArtistHeader.this, paramAnonymous2Bitmap);
              ArtistHeader.d(ArtistHeader.this).setVisibility(4);
              ArtistHeader.e(ArtistHeader.this).setVisibility(4);
              AppMethodBeat.o(97727);
              return;
            }
            af.dtr().b(ArtistHeader.b(ArtistHeader.this).CAS.CAT, ArtistHeader.c(ArtistHeader.this), ArtistHeader.1.this.val$context.hashCode(), bc.FzF);
            AppMethodBeat.o(97727);
          }
        });
        AppMethodBeat.o(97728);
      }
    });
    AppMethodBeat.o(97733);
  }
  
  public final void aob(String paramString) {}
  
  public final void by(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97735);
    if (this.xkh == null)
    {
      AppMethodBeat.o(97735);
      return;
    }
    if ((this.rcR != null) && (this.rcR.isShowing()))
    {
      if (!paramBoolean)
      {
        bpi localbpi = this.xkh.CAS.CAT;
        if ((localbpi.Id != null) && (localbpi.Id.equals(paramString)))
        {
          Toast.makeText(this.context, this.context.getString(2131763806), 0).show();
          AppMethodBeat.o(97735);
          return;
        }
      }
      if (this.xkn != null) {
        this.xkn.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97730);
            af.dtr().a(ArtistHeader.b(ArtistHeader.this).CAS.CAT, ArtistHeader.c(ArtistHeader.this), ArtistHeader.f(ArtistHeader.this).hashCode(), true, bc.FzF, false, new f.e()
            {
              public final void ai(Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(97729);
                if (q.I(paramAnonymous2Bitmap))
                {
                  ArtistHeader.a(ArtistHeader.this, paramAnonymous2Bitmap);
                  ArtistHeader.d(ArtistHeader.this).setVisibility(4);
                  ArtistHeader.e(ArtistHeader.this).setVisibility(4);
                }
                AppMethodBeat.o(97729);
              }
            });
            AppMethodBeat.o(97730);
          }
        });
      }
    }
    AppMethodBeat.o(97735);
  }
  
  public final void bz(String paramString, boolean paramBoolean) {}
  
  public final void dsp() {}
  
  public void setBackClickListener(a parama) {}
  
  public void setUserName(gg paramgg)
  {
    AppMethodBeat.i(97734);
    if (paramgg == null)
    {
      ad.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
      AppMethodBeat.o(97734);
      return;
    }
    this.xkh = paramgg;
    af.dtr().b(paramgg.CAS.CAT, this.xkm.fuj, this.context.hashCode(), bc.FzF);
    this.xkm.xks.setText(paramgg.Name);
    this.xkm.lEA.setText(paramgg.Cxw);
    this.xkm.titleTv.setText(paramgg.Title);
    this.xkm.xkt.setText(paramgg.CAR);
    AppMethodBeat.o(97734);
  }
  
  public static abstract interface a {}
  
  final class b
  {
    ImageView fuj;
    TextView lEA;
    TextView titleTv;
    TextView xks;
    TextView xkt;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistHeader
 * JD-Core Version:    0.7.0.1
 */