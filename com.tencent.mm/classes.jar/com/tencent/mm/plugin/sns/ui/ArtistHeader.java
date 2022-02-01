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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.model.f.e;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.i;

public class ArtistHeader
  extends LinearLayout
  implements b.b
{
  private Context context;
  private View gZU;
  private i thN;
  private gr zOm;
  private b zOr;
  private ImageView zOs;
  private ProgressBar zOt;
  
  public ArtistHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97731);
    this.zOm = null;
    this.thN = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97731);
  }
  
  public ArtistHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97732);
    this.zOm = null;
    this.thN = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97732);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97733);
    View localView = LayoutInflater.from(paramContext).inflate(2131495527, this, true);
    this.context = paramContext;
    this.zOr = new b();
    this.zOr.fRd = ((ImageView)localView.findViewById(2131296947));
    this.zOr.gUs = ((TextView)localView.findViewById(2131296284));
    this.zOr.weC = ((TextView)localView.findViewById(2131296287));
    this.zOr.zOx = ((TextView)localView.findViewById(2131296285));
    this.zOr.titleTv = ((TextView)localView.findViewById(2131296286));
    this.zOr.fRd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97728);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
        paramAnonymousView = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(2131495846, null);
        ArtistHeader.a(ArtistHeader.this, new i(ArtistHeader.this.getContext(), 2131821722));
        paramAnonymousView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(97726);
            b localb = new b();
            localb.bd(paramAnonymous2View);
            a.b("com/tencent/mm/plugin/sns/ui/ArtistHeader$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ArtistHeader.a(ArtistHeader.this).dismiss();
            a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97726);
          }
        });
        ArtistHeader.a(ArtistHeader.this).setCanceledOnTouchOutside(true);
        ArtistHeader.a(ArtistHeader.this).setContentView(paramAnonymousView);
        ArtistHeader.a(ArtistHeader.this).show();
        ArtistHeader.a(ArtistHeader.this, (ImageView)paramAnonymousView.findViewById(2131300688));
        ArtistHeader.a(ArtistHeader.this, (ProgressBar)paramAnonymousView.findViewById(2131300689));
        ArtistHeader.a(ArtistHeader.this, paramAnonymousView.findViewById(2131300690));
        ag.dUb().a(ArtistHeader.b(ArtistHeader.this).FyJ.FyK, ArtistHeader.c(ArtistHeader.this), paramContext.hashCode(), true, bj.ILV, false, new f.e()
        {
          public final void al(Bitmap paramAnonymous2Bitmap)
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
            ag.dUb().b(ArtistHeader.b(ArtistHeader.this).FyJ.FyK, ArtistHeader.c(ArtistHeader.this), ArtistHeader.1.this.val$context.hashCode(), bj.ILV);
            AppMethodBeat.o(97727);
          }
        });
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97728);
      }
    });
    AppMethodBeat.o(97733);
  }
  
  public final void ays(String paramString) {}
  
  public final void bM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97735);
    if (this.zOm == null)
    {
      AppMethodBeat.o(97735);
      return;
    }
    if ((this.thN != null) && (this.thN.isShowing()))
    {
      if (!paramBoolean)
      {
        byn localbyn = this.zOm.FyJ.FyK;
        if ((localbyn.Id != null) && (localbyn.Id.equals(paramString)))
        {
          Toast.makeText(this.context, this.context.getString(2131763806), 0).show();
          AppMethodBeat.o(97735);
          return;
        }
      }
      if (this.zOs != null) {
        this.zOs.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97730);
            ag.dUb().a(ArtistHeader.b(ArtistHeader.this).FyJ.FyK, ArtistHeader.c(ArtistHeader.this), ArtistHeader.f(ArtistHeader.this).hashCode(), true, bj.ILV, false, new f.e()
            {
              public final void al(Bitmap paramAnonymous2Bitmap)
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
  
  public final void bN(String paramString, boolean paramBoolean) {}
  
  public final void dTb() {}
  
  public void setBackClickListener(a parama) {}
  
  public void setUserName(gr paramgr)
  {
    AppMethodBeat.i(97734);
    if (paramgr == null)
    {
      ad.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
      AppMethodBeat.o(97734);
      return;
    }
    this.zOm = paramgr;
    ag.dUb().b(paramgr.FyJ.FyK, this.zOr.fRd, this.context.hashCode(), bj.ILV);
    this.zOr.weC.setText(paramgr.Name);
    this.zOr.gUs.setText(paramgr.Fvh);
    this.zOr.titleTv.setText(paramgr.Title);
    this.zOr.zOx.setText(paramgr.FyI);
    AppMethodBeat.o(97734);
  }
  
  public static abstract interface a {}
  
  final class b
  {
    ImageView fRd;
    TextView gUs;
    TextView titleTv;
    TextView weC;
    TextView zOx;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistHeader
 * JD-Core Version:    0.7.0.1
 */