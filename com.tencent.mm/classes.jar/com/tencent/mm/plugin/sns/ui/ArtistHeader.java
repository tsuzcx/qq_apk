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
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.model.g.e;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.i;

public class ArtistHeader
  extends LinearLayout
  implements c.b
{
  private i Bso;
  private gs KAZ;
  private b KBe;
  private ImageView KBf;
  private ProgressBar KBg;
  private Context context;
  private View maskView;
  
  public ArtistHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97731);
    this.KAZ = null;
    this.Bso = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97731);
  }
  
  public ArtistHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97732);
    this.KAZ = null;
    this.Bso = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97732);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97733);
    View localView = LayoutInflater.from(paramContext).inflate(i.g.sns_artist_header, this, true);
    this.context = paramContext;
    this.KBe = new b();
    this.KBe.jiu = ((ImageView)localView.findViewById(i.f.artist_avatar));
    this.KBe.kEs = ((TextView)localView.findViewById(i.f.a_desc));
    this.KBe.FwB = ((TextView)localView.findViewById(i.f.a_username));
    this.KBe.KBk = ((TextView)localView.findViewById(i.f.a_sign));
    this.KBe.titleTv = ((TextView)localView.findViewById(i.f.a_title));
    this.KBe.jiu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97728);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
        paramAnonymousView = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(i.g.view_get_hd_avatar_dialogview, null);
        ArtistHeader.a(ArtistHeader.this, new i(ArtistHeader.this.getContext(), i.k.mmAvatarDialog));
        paramAnonymousView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(97726);
            b localb = new b();
            localb.bn(paramAnonymous2View);
            a.c("com/tencent/mm/plugin/sns/ui/ArtistHeader$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            ArtistHeader.a(ArtistHeader.this).dismiss();
            a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97726);
          }
        });
        ArtistHeader.a(ArtistHeader.this).setCanceledOnTouchOutside(true);
        ArtistHeader.a(ArtistHeader.this).setContentView(paramAnonymousView);
        ArtistHeader.a(ArtistHeader.this).show();
        ArtistHeader.a(ArtistHeader.this, (ImageView)paramAnonymousView.findViewById(i.f.hd_avatar_iv));
        ArtistHeader.a(ArtistHeader.this, (ProgressBar)paramAnonymousView.findViewById(i.f.hd_avatar_laoding_pb));
        ArtistHeader.a(ArtistHeader.this, paramAnonymousView.findViewById(i.f.hd_avatar_mask_view));
        aj.fOF().a(ArtistHeader.b(ArtistHeader.this).RLG.RLH, ArtistHeader.c(ArtistHeader.this), paramContext.hashCode(), true, bp.VGp, false, new g.e()
        {
          public final void au(Bitmap paramAnonymous2Bitmap)
          {
            AppMethodBeat.i(97727);
            if (t.K(paramAnonymous2Bitmap))
            {
              ArtistHeader.a(ArtistHeader.this, paramAnonymous2Bitmap);
              ArtistHeader.d(ArtistHeader.this).setVisibility(4);
              ArtistHeader.e(ArtistHeader.this).setVisibility(4);
              AppMethodBeat.o(97727);
              return;
            }
            aj.fOF().b(ArtistHeader.b(ArtistHeader.this).RLG.RLH, ArtistHeader.c(ArtistHeader.this), ArtistHeader.1.this.val$context.hashCode(), bp.VGp);
            AppMethodBeat.o(97727);
          }
        });
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97728);
      }
    });
    AppMethodBeat.o(97733);
  }
  
  public final void aYK(String paramString) {}
  
  public final void cq(String paramString, boolean paramBoolean) {}
  
  public final void cr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97735);
    if (this.KAZ == null)
    {
      AppMethodBeat.o(97735);
      return;
    }
    if ((this.Bso != null) && (this.Bso.isShowing()))
    {
      if (!paramBoolean)
      {
        cvt localcvt = this.KAZ.RLG.RLH;
        if ((localcvt.Id != null) && (localcvt.Id.equals(paramString)))
        {
          Toast.makeText(this.context, this.context.getString(i.j.sns_down_error), 0).show();
          AppMethodBeat.o(97735);
          return;
        }
      }
      if (this.KBf != null) {
        this.KBf.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97730);
            aj.fOF().a(ArtistHeader.b(ArtistHeader.this).RLG.RLH, ArtistHeader.c(ArtistHeader.this), ArtistHeader.f(ArtistHeader.this).hashCode(), true, bp.VGp, false, new g.e()
            {
              public final void au(Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(97729);
                if (t.K(paramAnonymous2Bitmap))
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
  
  public final void fLL() {}
  
  public void setBackClickListener(a parama) {}
  
  public void setUserName(gs paramgs)
  {
    AppMethodBeat.i(97734);
    if (paramgs == null)
    {
      Log.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
      AppMethodBeat.o(97734);
      return;
    }
    this.KAZ = paramgs;
    aj.fOF().b(paramgs.RLG.RLH, this.KBe.jiu, this.context.hashCode(), bp.VGp);
    this.KBe.FwB.setText(paramgs.CMP);
    this.KBe.kEs.setText(paramgs.RIC);
    this.KBe.titleTv.setText(paramgs.fwr);
    this.KBe.KBk.setText(paramgs.RLF);
    AppMethodBeat.o(97734);
  }
  
  public static abstract interface a {}
  
  final class b
  {
    TextView FwB;
    TextView KBk;
    ImageView jiu;
    TextView kEs;
    TextView titleTv;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistHeader
 * JD-Core Version:    0.7.0.1
 */