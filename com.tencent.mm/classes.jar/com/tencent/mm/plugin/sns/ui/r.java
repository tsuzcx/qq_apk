package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class r
  extends LinearLayout
  implements u
{
  private String bMB = "";
  private boolean bMo = false;
  private int bMp;
  private Context context;
  private String diG = "";
  private int ivk = 0;
  r.b oOZ = new r.b(this);
  private n oPa = null;
  private r.a oPb;
  private View.OnTouchListener oPc = bk.crZ();
  private boolean oPd = true;
  
  public r(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.ivk = paramInt;
    this.bMo = paramBoolean;
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    if (this.ivk == -1) {
      return;
    }
    this.diG = q.Gj();
    View localView = LayoutInflater.from(paramContext).inflate(i.g.sns_gallery_footer, this, true);
    this.oOZ.oPg = ((LinearLayout)localView.findViewById(i.f.state_ll));
    this.oOZ.oPq = ((LinearLayout)localView.findViewById(i.f.view_media));
    this.oOZ.oPj = ((LinearLayout)localView.findViewById(i.f.like_ll));
    this.oOZ.oPj.setOnTouchListener(this.oPc);
    this.oOZ.oPk = ((ImageView)localView.findViewById(i.f.img_button_like));
    this.oOZ.oPl = ((LinearLayout)localView.findViewById(i.f.comment_ll));
    this.oOZ.oPl.setOnTouchListener(this.oPc);
    this.oOZ.oPm = ((LinearLayout)localView.findViewById(i.f.content_info));
    this.oOZ.oPo = ((TextView)localView.findViewById(i.f.sns_cm1_tv));
    this.oOZ.oPp = ((TextView)localView.findViewById(i.f.sns_cm2_tv));
    this.oOZ.oPn = ((TextView)localView.findViewById(i.f.has_like_tv));
    this.oOZ.oPh = ((TextView)localView.findViewById(i.f.set_bg));
    this.oOZ.oPi = ((LinearLayout)localView.findViewById(i.f.set_bg_ll));
    this.oOZ.gaI = ((TextView)localView.findViewById(i.f.sns_desc));
    this.oOZ.oPu = ((LinearLayout)localView.findViewById(i.f.info_line));
    ((LinearLayout)localView.findViewById(i.f.info_line)).getBackground().setAlpha(50);
    this.oOZ.dpY = ((ImageView)localView.findViewById(i.f.avatar_with));
    this.oOZ.oPr = ((ImageView)localView.findViewById(i.f.lock_icon));
    this.oOZ.oPs = ((ImageView)localView.findViewById(i.f.error_icon));
    this.oOZ.oPt = ((LinearLayout)localView.findViewById(i.f.del_ll));
    this.oOZ.oPv = ((TextView)localView.findViewById(i.f.del_tv));
    if (this.ivk == 2)
    {
      this.oOZ.oPq.setVisibility(8);
      this.oOZ.oPt.setVisibility(8);
      this.oOZ.oPi.setVisibility(0);
    }
    for (;;)
    {
      this.oOZ.oPj.setOnClickListener(new r.1(this));
      this.oOZ.oPl.setOnClickListener(new r.2(this, paramContext));
      this.oOZ.oPm.setOnClickListener(new r.3(this, paramContext));
      this.oOZ.oPh.setOnClickListener(new r.4(this));
      this.oOZ.oPv.setOnClickListener(new r.5(this));
      return;
      if (this.ivk == 3)
      {
        this.oOZ.oPq.setVisibility(8);
        this.oOZ.oPi.setVisibility(8);
        this.oOZ.oPt.setVisibility(0);
      }
      else
      {
        this.oOZ.oPq.setVisibility(0);
        this.oOZ.oPi.setVisibility(8);
        this.oOZ.oPt.setVisibility(8);
      }
    }
  }
  
  public final void Pd(String paramString)
  {
    setFooter(paramString);
  }
  
  public final int getFooterH()
  {
    if (this.oOZ.oPg != null) {
      return this.oOZ.oPg.getHeight();
    }
    return 10;
  }
  
  public final void refresh()
  {
    if (this.ivk == -1) {}
    label262:
    label780:
    for (;;)
    {
      return;
      this.oPa = af.bDF().OB(this.bMB);
      if ((!bk.bl(this.bMB)) && (this.oPa != null))
      {
        this.oOZ.oPs.setVisibility(8);
        if (aj.U(this.oPa.field_localPrivate, this.bMo))
        {
          this.oOZ.oPl.setVisibility(8);
          this.oOZ.oPj.setVisibility(8);
          localObject = aj.q(this.oPa);
          if (localObject != null)
          {
            if (this.oPa.bGD())
            {
              int i = ((bto)localObject).tJZ;
              if (i <= 0) {
                break label485;
              }
              this.oOZ.oPp.setText(String.valueOf(i));
              this.oOZ.oPp.setVisibility(0);
              label149:
              int j = ((bto)localObject).tJW;
              if (j <= 0) {
                break label500;
              }
              this.oOZ.oPo.setText(String.valueOf(j));
              this.oOZ.oPo.setVisibility(0);
              label183:
              y.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + j);
              if (this.oPa.field_likeFlag != 1) {
                break label515;
              }
              localObject = getResources().getString(i.j.sns_gallery_has_like);
              this.oOZ.oPn.setText((CharSequence)localObject);
              this.oOZ.oPk.setImageResource(i.i.friendactivity_comment_likeicon_havon);
            }
            if ((this.diG.equals(this.oPa.field_userName)) || (!this.bMo)) {
              break label553;
            }
            this.oOZ.dpY.setVisibility(0);
            a.b.a(this.oOZ.dpY, this.oPa.field_userName);
          }
        }
        for (;;)
        {
          if (this.oPa.bGe() != null) {
            break label568;
          }
          this.oOZ.gaI.setVisibility(8);
          return;
          if (!this.oPa.bGD())
          {
            this.oOZ.oPu.setVisibility(0);
            this.oOZ.oPq.setVisibility(0);
            this.oOZ.oPg.setVisibility(8);
            this.oOZ.oPm.setVisibility(8);
            this.oOZ.oPl.setVisibility(8);
            this.oOZ.oPj.setVisibility(8);
            break;
          }
          if (this.oPd) {
            this.oOZ.oPg.setVisibility(0);
          }
          this.oOZ.oPm.setVisibility(0);
          this.oOZ.oPl.setVisibility(0);
          this.oOZ.oPj.setVisibility(0);
          this.oOZ.oPq.setVisibility(0);
          break;
          label485:
          this.oOZ.oPp.setVisibility(8);
          break label149;
          label500:
          this.oOZ.oPo.setVisibility(8);
          break label183;
          localObject = getResources().getString(i.j.sns_gallery_like);
          this.oOZ.oPn.setText((CharSequence)localObject);
          this.oOZ.oPk.setImageResource(i.i.friendactivity_comment_likeicon_normal);
          break label262;
          label553:
          this.oOZ.dpY.setVisibility(8);
        }
        label568:
        Object localObject = this.oPa.bGe().tNo;
        if ((localObject == null) || (((String)localObject).equals("")))
        {
          this.oOZ.gaI.setText("");
          this.oOZ.gaI.setVisibility(8);
          if (!aj.U(this.oPa.field_localPrivate, this.bMo)) {
            break label767;
          }
          this.oOZ.oPr.setVisibility(0);
          this.oOZ.gaI.setVisibility(0);
        }
        for (;;)
        {
          if ((!this.bMo) || (!this.oPa.bGG())) {
            break label780;
          }
          this.oOZ.oPm.setVisibility(0);
          this.oOZ.gaI.setVisibility(0);
          this.oOZ.oPs.setVisibility(0);
          return;
          this.oOZ.gaI.setText(j.a(getContext(), (String)localObject + " ", this.oOZ.gaI.getTextSize()));
          this.oOZ.gaI.setVisibility(0);
          break;
          label767:
          this.oOZ.oPr.setVisibility(8);
        }
      }
    }
  }
  
  public final void setCallBack(r.a parama)
  {
    this.oPb = parama;
  }
  
  public final void setFooter(String paramString)
  {
    this.bMB = paramString;
    refresh();
  }
  
  public final void setSnsSource(int paramInt)
  {
    this.bMp = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    this.ivk = paramInt;
    init(this.context);
  }
  
  public final void setVisibility(int paramInt)
  {
    boolean bool = false;
    if ((this.ivk == 2) || (this.ivk == 3))
    {
      super.setVisibility(paramInt);
      if (paramInt == 8) {
        this.oPd = bool;
      }
    }
    do
    {
      do
      {
        return;
        bool = true;
        break;
      } while ((this.oPa != null) && (!this.oPa.bGD()));
      if (paramInt == 8)
      {
        this.oOZ.oPg.setVisibility(8);
        this.oPd = false;
        return;
      }
    } while (paramInt != 0);
    this.oOZ.oPg.setVisibility(0);
    this.oPd = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.r
 * JD-Core Version:    0.7.0.1
 */