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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;

public class ArtistHeader
  extends LinearLayout
  implements b.b
{
  private Context context = null;
  private View hoY;
  private com.tencent.mm.ui.base.i klR = null;
  private el oMM = null;
  private ArtistHeader.b oMR;
  private ImageView oMS;
  private ProgressBar oMT;
  
  public ArtistHeader(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ArtistHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(final Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(i.g.sns_artist_header, this, true);
    this.context = paramContext;
    this.oMR = new ArtistHeader.b(this);
    this.oMR.dpY = ((ImageView)localView.findViewById(i.f.artist_avatar));
    this.oMR.gaI = ((TextView)localView.findViewById(i.f.a_desc));
    this.oMR.oMW = ((TextView)localView.findViewById(i.f.a_username));
    this.oMR.oMX = ((TextView)localView.findViewById(i.f.a_sign));
    this.oMR.eXr = ((TextView)localView.findViewById(i.f.a_title));
    this.oMR.dpY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ((ArtistHeader.a(ArtistHeader.this) != null) && (ArtistHeader.a(ArtistHeader.this).isShowing())) {}
        while (ArtistHeader.b(ArtistHeader.this) == null) {
          return;
        }
        paramAnonymousView = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(i.g.view_get_hd_avatar_dialogview, null);
        ArtistHeader.a(ArtistHeader.this, new com.tencent.mm.ui.base.i(ArtistHeader.this.getContext(), i.k.mmAvatarDialog));
        paramAnonymousView.setOnClickListener(new ArtistHeader.1.1(this));
        ArtistHeader.a(ArtistHeader.this).setCanceledOnTouchOutside(true);
        ArtistHeader.a(ArtistHeader.this).setContentView(paramAnonymousView);
        ArtistHeader.a(ArtistHeader.this).show();
        ArtistHeader.a(ArtistHeader.this, (ImageView)paramAnonymousView.findViewById(i.f.hd_avatar_iv));
        ArtistHeader.a(ArtistHeader.this, (ProgressBar)paramAnonymousView.findViewById(i.f.hd_avatar_laoding_pb));
        ArtistHeader.a(ArtistHeader.this, paramAnonymousView.findViewById(i.f.hd_avatar_mask_view));
        paramAnonymousView = af.bDC().a(ArtistHeader.b(ArtistHeader.this).sya.syb, ArtistHeader.c(ArtistHeader.this), paramContext.hashCode(), true, az.uBK, false);
        if (com.tencent.mm.plugin.sns.data.i.s(paramAnonymousView))
        {
          ArtistHeader.a(ArtistHeader.this, paramAnonymousView);
          ArtistHeader.d(ArtistHeader.this).setVisibility(4);
          ArtistHeader.e(ArtistHeader.this).setVisibility(4);
          return;
        }
        af.bDC().b(ArtistHeader.b(ArtistHeader.this).sya.syb, ArtistHeader.c(ArtistHeader.this), paramContext.hashCode(), az.uBK);
      }
    });
  }
  
  public final void Ni(String paramString) {}
  
  public final void bCt() {}
  
  public final void ba(String paramString, boolean paramBoolean)
  {
    if (this.oMM == null) {}
    do
    {
      do
      {
        return;
      } while ((this.klR == null) || (!this.klR.isShowing()));
      if (!paramBoolean)
      {
        awd localawd = this.oMM.sya.syb;
        if ((localawd.lsK != null) && (localawd.lsK.equals(paramString)))
        {
          Toast.makeText(this.context, this.context.getString(i.j.sns_down_error), 0).show();
          return;
        }
      }
    } while (this.oMS == null);
    this.oMS.post(new Runnable()
    {
      public final void run()
      {
        Bitmap localBitmap = af.bDC().a(ArtistHeader.b(ArtistHeader.this).sya.syb, ArtistHeader.c(ArtistHeader.this), ArtistHeader.f(ArtistHeader.this).hashCode(), true, az.uBK, false);
        if (com.tencent.mm.plugin.sns.data.i.s(localBitmap))
        {
          ArtistHeader.a(ArtistHeader.this, localBitmap);
          ArtistHeader.d(ArtistHeader.this).setVisibility(4);
          ArtistHeader.e(ArtistHeader.this).setVisibility(4);
        }
      }
    });
  }
  
  public final void bb(String paramString, boolean paramBoolean) {}
  
  public void setBackClickListener(ArtistHeader.a parama) {}
  
  public void setUserName(el paramel)
  {
    if (paramel == null)
    {
      y.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
      return;
    }
    this.oMM = paramel;
    af.bDC().b(paramel.sya.syb, this.oMR.dpY, this.context.hashCode(), az.uBK);
    this.oMR.oMW.setText(paramel.kRZ);
    this.oMR.gaI.setText(paramel.sxZ);
    this.oMR.eXr.setText(paramel.bGw);
    this.oMR.oMX.setText(paramel.sxY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistHeader
 * JD-Core Version:    0.7.0.1
 */