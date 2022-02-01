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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.model.g.e;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.a.i;

public class ArtistHeader
  extends LinearLayout
  implements c.b
{
  private i GYB;
  private hl RaG;
  private b RaL;
  private ImageView RaM;
  private ProgressBar RaN;
  private Context context;
  private View maskView;
  
  public ArtistHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97731);
    this.RaG = null;
    this.GYB = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97731);
  }
  
  public ArtistHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97732);
    this.RaG = null;
    this.GYB = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97732);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97733);
    View localView = LayoutInflater.from(paramContext).inflate(b.g.sns_artist_header, this, true);
    this.context = paramContext;
    this.RaL = new b();
    this.RaL.lKK = ((ImageView)localView.findViewById(b.f.artist_avatar));
    this.RaL.descTv = ((TextView)localView.findViewById(b.f.a_desc));
    this.RaL.LsN = ((TextView)localView.findViewById(b.f.a_username));
    this.RaL.RaR = ((TextView)localView.findViewById(b.f.a_sign));
    this.RaL.titleTv = ((TextView)localView.findViewById(b.f.a_title));
    this.RaL.lKK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97728);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((ArtistHeader.a(ArtistHeader.this) != null) && (ArtistHeader.a(ArtistHeader.this).isShowing()))
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97728);
          return;
        }
        if (ArtistHeader.b(ArtistHeader.this) == null)
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97728);
          return;
        }
        paramAnonymousView = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(b.g.view_get_hd_avatar_dialogview, null);
        ArtistHeader.a(ArtistHeader.this, new i(ArtistHeader.this.getContext(), b.k.mmAvatarDialog));
        paramAnonymousView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(97726);
            b localb = new b();
            localb.cH(paramAnonymous2View);
            a.c("com/tencent/mm/plugin/sns/ui/ArtistHeader$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            ArtistHeader.a(ArtistHeader.this).dismiss();
            a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97726);
          }
        });
        ArtistHeader.a(ArtistHeader.this).setCanceledOnTouchOutside(true);
        ArtistHeader.a(ArtistHeader.this).setContentView(paramAnonymousView);
        ArtistHeader.a(ArtistHeader.this).show();
        ArtistHeader.a(ArtistHeader.this, (ImageView)paramAnonymousView.findViewById(b.f.hd_avatar_iv));
        ArtistHeader.a(ArtistHeader.this, (ProgressBar)paramAnonymousView.findViewById(b.f.hd_avatar_laoding_pb));
        ArtistHeader.a(ArtistHeader.this, paramAnonymousView.findViewById(b.f.hd_avatar_mask_view));
        al.hgy().a(ArtistHeader.b(ArtistHeader.this).YIR.YIS, ArtistHeader.c(ArtistHeader.this), paramContext.hashCode(), true, br.adkd, false, new g.e()
        {
          public final void aN(Bitmap paramAnonymous2Bitmap)
          {
            AppMethodBeat.i(97727);
            if (t.S(paramAnonymous2Bitmap))
            {
              ArtistHeader.a(ArtistHeader.this, paramAnonymous2Bitmap);
              ArtistHeader.d(ArtistHeader.this).setVisibility(4);
              ArtistHeader.e(ArtistHeader.this).setVisibility(4);
              AppMethodBeat.o(97727);
              return;
            }
            al.hgy().b(ArtistHeader.b(ArtistHeader.this).YIR.YIS, ArtistHeader.c(ArtistHeader.this), ArtistHeader.1.this.val$context.hashCode(), br.adkd);
            AppMethodBeat.o(97727);
          }
        });
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97728);
      }
    });
    AppMethodBeat.o(97733);
  }
  
  public final void EE(String paramString) {}
  
  public final void aXr() {}
  
  public void setBackClickListener(a parama) {}
  
  public void setUserName(hl paramhl)
  {
    AppMethodBeat.i(97734);
    if (paramhl == null)
    {
      Log.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
      AppMethodBeat.o(97734);
      return;
    }
    this.RaG = paramhl;
    al.hgy().b(paramhl.YIR.YIS, this.RaL.lKK, this.context.hashCode(), br.adkd);
    this.RaL.LsN.setText(paramhl.IGU);
    this.RaL.descTv.setText(paramhl.crB);
    this.RaL.titleTv.setText(paramhl.hAP);
    this.RaL.RaR.setText(paramhl.YIQ);
    AppMethodBeat.o(97734);
  }
  
  public final void w(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97735);
    if (this.RaG == null)
    {
      AppMethodBeat.o(97735);
      return;
    }
    if ((this.GYB != null) && (this.GYB.isShowing()))
    {
      if (!paramBoolean)
      {
        dmz localdmz = this.RaG.YIR.YIS;
        if ((localdmz.Id != null) && (localdmz.Id.equals(paramString)))
        {
          Toast.makeText(this.context, this.context.getString(b.j.sns_down_error), 0).show();
          AppMethodBeat.o(97735);
          return;
        }
      }
      if (this.RaM != null) {
        this.RaM.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97730);
            al.hgy().a(ArtistHeader.b(ArtistHeader.this).YIR.YIS, ArtistHeader.c(ArtistHeader.this), ArtistHeader.f(ArtistHeader.this).hashCode(), true, br.adkd, false, new g.e()
            {
              public final void aN(Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(97729);
                if (t.S(paramAnonymous2Bitmap))
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
  
  public final void x(String paramString, boolean paramBoolean) {}
  
  public static abstract interface a {}
  
  final class b
  {
    TextView LsN;
    TextView RaR;
    TextView descTv;
    ImageView lKK;
    TextView titleTv;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistHeader
 * JD-Core Version:    0.7.0.1
 */