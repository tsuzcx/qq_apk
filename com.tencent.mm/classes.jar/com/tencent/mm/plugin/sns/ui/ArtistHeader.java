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
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.protocal.protobuf.gl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.base.i;

public class ArtistHeader
  extends LinearLayout
  implements b.b
{
  private Context context;
  private View gGk;
  private i sll;
  private gk yxa;
  private b yxf;
  private ImageView yxg;
  private ProgressBar yxh;
  
  public ArtistHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97731);
    this.yxa = null;
    this.sll = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97731);
  }
  
  public ArtistHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97732);
    this.yxa = null;
    this.sll = null;
    this.context = null;
    init(paramContext);
    AppMethodBeat.o(97732);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97733);
    View localView = LayoutInflater.from(paramContext).inflate(2131495527, this, true);
    this.context = paramContext;
    this.yxf = new b();
    this.yxf.fxQ = ((ImageView)localView.findViewById(2131296947));
    this.yxf.gAI = ((TextView)localView.findViewById(2131296284));
    this.yxf.uZA = ((TextView)localView.findViewById(2131296287));
    this.yxf.yxl = ((TextView)localView.findViewById(2131296285));
    this.yxf.titleTv = ((TextView)localView.findViewById(2131296286));
    this.yxf.fxQ.setOnClickListener(new View.OnClickListener()
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
        af.dHO().a(ArtistHeader.b(ArtistHeader.this).DTq.DTr, ArtistHeader.c(ArtistHeader.this), paramContext.hashCode(), true, bf.GYH, false, new f.e()
        {
          public final void aj(Bitmap paramAnonymous2Bitmap)
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
            af.dHO().b(ArtistHeader.b(ArtistHeader.this).DTq.DTr, ArtistHeader.c(ArtistHeader.this), ArtistHeader.1.this.val$context.hashCode(), bf.GYH);
            AppMethodBeat.o(97727);
          }
        });
        AppMethodBeat.o(97728);
      }
    });
    AppMethodBeat.o(97733);
  }
  
  public final void atn(String paramString) {}
  
  public final void bF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97735);
    if (this.yxa == null)
    {
      AppMethodBeat.o(97735);
      return;
    }
    if ((this.sll != null) && (this.sll.isShowing()))
    {
      if (!paramBoolean)
      {
        btz localbtz = this.yxa.DTq.DTr;
        if ((localbtz.Id != null) && (localbtz.Id.equals(paramString)))
        {
          Toast.makeText(this.context, this.context.getString(2131763806), 0).show();
          AppMethodBeat.o(97735);
          return;
        }
      }
      if (this.yxg != null) {
        this.yxg.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97730);
            af.dHO().a(ArtistHeader.b(ArtistHeader.this).DTq.DTr, ArtistHeader.c(ArtistHeader.this), ArtistHeader.f(ArtistHeader.this).hashCode(), true, bf.GYH, false, new f.e()
            {
              public final void aj(Bitmap paramAnonymous2Bitmap)
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
  
  public final void bG(String paramString, boolean paramBoolean) {}
  
  public final void dGO() {}
  
  public void setBackClickListener(a parama) {}
  
  public void setUserName(gk paramgk)
  {
    AppMethodBeat.i(97734);
    if (paramgk == null)
    {
      ac.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
      AppMethodBeat.o(97734);
      return;
    }
    this.yxa = paramgk;
    af.dHO().b(paramgk.DTq.DTr, this.yxf.fxQ, this.context.hashCode(), bf.GYH);
    this.yxf.uZA.setText(paramgk.Name);
    this.yxf.gAI.setText(paramgk.DPS);
    this.yxf.titleTv.setText(paramgk.Title);
    this.yxf.yxl.setText(paramgk.DTp);
    AppMethodBeat.o(97734);
  }
  
  public static abstract interface a {}
  
  final class b
  {
    ImageView fxQ;
    TextView gAI;
    TextView titleTv;
    TextView uZA;
    TextView yxl;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistHeader
 * JD-Core Version:    0.7.0.1
 */