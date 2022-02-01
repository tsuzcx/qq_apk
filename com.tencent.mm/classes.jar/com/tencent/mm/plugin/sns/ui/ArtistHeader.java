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
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.model.g.e;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.protocal.protobuf.hf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.i;

public class ArtistHeader
  extends LinearLayout
  implements c.b
{
  private he EnQ;
  private b EnV;
  private ImageView EnW;
  private ProgressBar EnX;
  private Context context;
  private View maskView;
  private i wGm;
  
  public ArtistHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97731);
    this.EnQ = null;
    this.wGm = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97731);
  }
  
  public ArtistHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97732);
    this.EnQ = null;
    this.wGm = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97732);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97733);
    View localView = LayoutInflater.from(paramContext).inflate(2131496415, this, true);
    this.context = paramContext;
    this.EnV = new b();
    this.EnV.gyr = ((ImageView)localView.findViewById(2131297054));
    this.EnV.hPW = ((TextView)localView.findViewById(2131296285));
    this.EnV.zQY = ((TextView)localView.findViewById(2131296288));
    this.EnV.Eob = ((TextView)localView.findViewById(2131296286));
    this.EnV.titleTv = ((TextView)localView.findViewById(2131296287));
    this.EnV.gyr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97728);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
        paramAnonymousView = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(2131496815, null);
        ArtistHeader.a(ArtistHeader.this, new i(ArtistHeader.this.getContext(), 2131821771));
        paramAnonymousView.setOnClickListener(new ArtistHeader.1.1(this));
        ArtistHeader.a(ArtistHeader.this).setCanceledOnTouchOutside(true);
        ArtistHeader.a(ArtistHeader.this).setContentView(paramAnonymousView);
        ArtistHeader.a(ArtistHeader.this).show();
        ArtistHeader.a(ArtistHeader.this, (ImageView)paramAnonymousView.findViewById(2131302257));
        ArtistHeader.a(ArtistHeader.this, (ProgressBar)paramAnonymousView.findViewById(2131302258));
        ArtistHeader.a(ArtistHeader.this, paramAnonymousView.findViewById(2131302259));
        aj.faL().a(ArtistHeader.b(ArtistHeader.this).KKO.KKP, ArtistHeader.c(ArtistHeader.this), paramContext.hashCode(), true, bp.Oqt, false, new g.e()
        {
          public final void ax(Bitmap paramAnonymous2Bitmap)
          {
            AppMethodBeat.i(97727);
            if (r.M(paramAnonymous2Bitmap))
            {
              ArtistHeader.a(ArtistHeader.this, paramAnonymous2Bitmap);
              ArtistHeader.d(ArtistHeader.this).setVisibility(4);
              ArtistHeader.e(ArtistHeader.this).setVisibility(4);
              AppMethodBeat.o(97727);
              return;
            }
            aj.faL().b(ArtistHeader.b(ArtistHeader.this).KKO.KKP, ArtistHeader.c(ArtistHeader.this), ArtistHeader.1.this.val$context.hashCode(), bp.Oqt);
            AppMethodBeat.o(97727);
          }
        });
        a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97728);
      }
    });
    AppMethodBeat.o(97733);
  }
  
  public final void aOG(String paramString) {}
  
  public final void ci(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97735);
    if (this.EnQ == null)
    {
      AppMethodBeat.o(97735);
      return;
    }
    if ((this.wGm != null) && (this.wGm.isShowing()))
    {
      if (!paramBoolean)
      {
        cnb localcnb = this.EnQ.KKO.KKP;
        if ((localcnb.Id != null) && (localcnb.Id.equals(paramString)))
        {
          Toast.makeText(this.context, this.context.getString(2131766030), 0).show();
          AppMethodBeat.o(97735);
          return;
        }
      }
      if (this.EnW != null) {
        this.EnW.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97730);
            aj.faL().a(ArtistHeader.b(ArtistHeader.this).KKO.KKP, ArtistHeader.c(ArtistHeader.this), ArtistHeader.f(ArtistHeader.this).hashCode(), true, bp.Oqt, false, new g.e()
            {
              public final void ax(Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(97729);
                if (r.M(paramAnonymous2Bitmap))
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
  
  public final void cj(String paramString, boolean paramBoolean) {}
  
  public final void eZJ() {}
  
  public void setBackClickListener(a parama) {}
  
  public void setUserName(he paramhe)
  {
    AppMethodBeat.i(97734);
    if (paramhe == null)
    {
      Log.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
      AppMethodBeat.o(97734);
      return;
    }
    this.EnQ = paramhe;
    aj.faL().b(paramhe.KKO.KKP, this.EnV.gyr, this.context.hashCode(), bp.Oqt);
    this.EnV.zQY.setText(paramhe.Name);
    this.EnV.hPW.setText(paramhe.KHk);
    this.EnV.titleTv.setText(paramhe.Title);
    this.EnV.Eob.setText(paramhe.KKN);
    AppMethodBeat.o(97734);
  }
  
  public static abstract interface a {}
  
  final class b
  {
    TextView Eob;
    ImageView gyr;
    TextView hPW;
    TextView titleTv;
    TextView zQY;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistHeader
 * JD-Core Version:    0.7.0.1
 */