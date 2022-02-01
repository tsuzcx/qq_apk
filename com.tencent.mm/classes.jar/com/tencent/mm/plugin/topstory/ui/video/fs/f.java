package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.b;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class f
  extends g
{
  public TextView Ddd;
  private esy MWv;
  public ImageView MZm;
  public View NbA;
  public TextView NbB;
  public TextView NbC;
  public ImageView NbD;
  public ImageView NbE;
  public View NbF;
  MTimerHandler NbG;
  private a NbH;
  private boolean NbI;
  public View Nbq;
  public View Nbr;
  public ImageView Nbs;
  public TextView Nbt;
  public View Nbu;
  public View Nbv;
  public View Nbw;
  public View Nbx;
  public View Nby;
  public View Nbz;
  public TextView titleTv;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean bVd()
  {
    AppMethodBeat.i(126309);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(126309);
      return true;
    }
    AppMethodBeat.o(126309);
    return false;
  }
  
  public final void bVi()
  {
    AppMethodBeat.i(126312);
    if (this.NbG != null)
    {
      this.NbG.stopTimer();
      this.NbG.startTimer(2000L);
    }
    AppMethodBeat.o(126312);
  }
  
  public final void bWO()
  {
    AppMethodBeat.i(126321);
    super.bWO();
    if ((this.NbH != null) && (this.MWv != null)) {
      this.NbH.b(this.MWv, this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126321);
  }
  
  public final void cEO()
  {
    AppMethodBeat.i(126311);
    if (this.NbG != null) {
      this.NbG.stopTimer();
    }
    AppMethodBeat.o(126311);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(126313);
    int i = this.pCb.getWidth();
    AppMethodBeat.o(126313);
    return i;
  }
  
  public int getLayoutId()
  {
    return c.e.top_story_fs_video_control_bar;
  }
  
  public View getWowView()
  {
    return this.Nbr;
  }
  
  public final void grN()
  {
    AppMethodBeat.i(126319);
    this.pCc.setVisibility(8);
    AppMethodBeat.o(126319);
  }
  
  public final void grO()
  {
    AppMethodBeat.i(126320);
    this.pCc.setVisibility(0);
    AppMethodBeat.o(126320);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(292767);
    setVisibility(8);
    AppMethodBeat.o(292767);
  }
  
  public void init()
  {
    AppMethodBeat.i(126305);
    super.init();
    this.Nbu = this.contentView.findViewById(c.d.content_area_layout);
    this.Nbq = this.contentView.findViewById(c.d.share_iv);
    this.Nbr = this.contentView.findViewById(c.d.wow_iv);
    this.Nbs = ((ImageView)this.contentView.findViewById(c.d.wow_icon_view));
    this.Nbt = ((TextView)this.contentView.findViewById(c.d.wow_icon_text));
    this.Nbv = this.contentView.findViewById(c.d.progress_root_bg);
    this.Nbw = this.contentView.findViewById(c.d.progress_root);
    this.Nbx = this.contentView.findViewById(c.d.tag_desc_layout);
    this.Nby = this.contentView.findViewById(c.d.bottom_tag_layout);
    this.Nbz = this.contentView.findViewById(c.d.tag_1_ll);
    this.NbA = this.contentView.findViewById(c.d.tag_2_ll);
    this.NbB = ((TextView)this.contentView.findViewById(c.d.tag_1_tv));
    this.NbC = ((TextView)this.contentView.findViewById(c.d.tag_2_tv));
    this.NbD = ((ImageView)this.contentView.findViewById(c.d.tag_1_icon));
    this.NbE = ((ImageView)this.contentView.findViewById(c.d.tag_2_icon));
    this.MZm = ((ImageView)this.contentView.findViewById(c.d.source_iv));
    this.Ddd = ((TextView)this.contentView.findViewById(c.d.source_tv));
    this.NbF = this.contentView.findViewById(c.d.source_arrow);
    this.titleTv = ((TextView)this.contentView.findViewById(c.d.title_tv));
    AppMethodBeat.o(126305);
  }
  
  public final void m(esy paramesy)
  {
    AppMethodBeat.i(126306);
    if ((paramesy.Uvd & 0x80) > 0)
    {
      this.Nbr.setVisibility(0);
      if (paramesy.Uvi)
      {
        this.Nbs.setImageResource(c.f.top_story_wow_selected);
        this.Nbt.setTextColor(getResources().getColor(c.a.top_story_wow_like));
      }
      for (;;)
      {
        this.Nbt.setText(d.ajw(paramesy.Uvm));
        AppMethodBeat.o(126306);
        return;
        this.Nbs.setImageResource(c.f.top_story_wow_unselected);
        this.Nbt.setTextColor(getResources().getColor(c.a.white_text_color));
      }
    }
    this.Nbr.setVisibility(8);
    AppMethodBeat.o(126306);
  }
  
  public void n(esy paramesy)
  {
    AppMethodBeat.i(126307);
    this.MWv = paramesy;
    this.Nbq.setVisibility(0);
    float f = getResources().getDimensionPixelSize(c.b.fts_web_video_fullscreen_control_bar_time_textsize);
    this.pCd.setTextSize(0, f);
    this.pCe.setTextSize(0, f);
    Object localObject = this.Nbw.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(c.b.fts_web_video_fullscreen_control_bar_height);
    this.Nbw.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramesy.Crg.size() > 0)
    {
      if (this.Nbx != null) {
        this.Nbx.setVisibility(0);
      }
      this.Nby.setVisibility(0);
      localObject = (eij)paramesy.Crg.get(0);
      this.Nbz.setTag(localObject);
      this.NbB.setText(((eij)localObject).wording);
      this.NbB.setVisibility(0);
      this.Nbz.setVisibility(0);
      this.NbD.setVisibility(8);
      if (!Util.isNullOrNil(((eij)localObject).icon))
      {
        q.bml().a(((eij)localObject).icon, this.NbD, d.MWG);
        this.NbD.setVisibility(0);
      }
      if (paramesy.Crg.size() > 1)
      {
        localObject = (eij)paramesy.Crg.get(1);
        this.NbA.setTag(localObject);
        this.NbC.setText(((eij)localObject).wording);
        this.NbC.setVisibility(0);
        this.NbA.setVisibility(0);
        this.NbE.setVisibility(8);
        if (!Util.isNullOrNil(((eij)localObject).icon))
        {
          q.bml().a(((eij)localObject).icon, this.NbE, d.MWG);
          this.NbE.setVisibility(0);
        }
        m(paramesy);
        if (this.NbI) {
          this.Nby.setVisibility(8);
        }
        if ((this.NbF != null) && (this.Ddd != null) && (this.MZm != null))
        {
          this.NbF.setVisibility(8);
          this.Ddd.setVisibility(8);
          this.MZm.setVisibility(8);
          if (!Util.isNullOrNil(paramesy.source))
          {
            this.Ddd.setText(paramesy.source);
            this.Ddd.setVisibility(0);
            if (n.i(paramesy)) {
              this.NbF.setVisibility(0);
            }
            if (Util.isNullOrNil(paramesy.TIg)) {
              break label527;
            }
            q.bml().a(paramesy.TIg, this.MZm, d.MWF);
          }
        }
      }
    }
    for (;;)
    {
      this.MZm.setVisibility(0);
      if (this.titleTv != null) {
        this.titleTv.setText(paramesy.title);
      }
      AppMethodBeat.o(126307);
      return;
      this.NbA.setVisibility(8);
      this.NbC.setVisibility(8);
      break;
      if (this.Nbx != null) {
        this.Nbx.setVisibility(8);
      }
      this.Nby.setVisibility(8);
      break;
      label527:
      this.MZm.setImageResource(c.c.default_avatar);
    }
  }
  
  public void setOnUpdateProgressLenListener(a parama)
  {
    this.NbH = parama;
  }
  
  public void setOnlyFS(boolean paramBoolean)
  {
    this.NbI = paramBoolean;
  }
  
  public void setShareBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126314);
    this.Nbq.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126314);
  }
  
  public void setSourceItemClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126317);
    if (this.Ddd != null) {
      this.Ddd.setOnClickListener(paramOnClickListener);
    }
    if (this.MZm != null) {
      this.MZm.setOnClickListener(paramOnClickListener);
    }
    if (this.NbF != null) {
      this.NbF.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(126317);
  }
  
  public void setTagBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126315);
    this.Nbz.setOnClickListener(paramOnClickListener);
    this.NbA.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126315);
  }
  
  public void setTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126318);
    this.titleTv.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126318);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(126322);
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      if (this.NbH != null)
      {
        this.NbH.grM();
        AppMethodBeat.o(126322);
      }
    }
    else if ((paramInt == 0) && (this.NbH != null)) {
      this.NbH.grL();
    }
    AppMethodBeat.o(126322);
  }
  
  public void setWowBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126316);
    this.Nbr.setVisibility(0);
    this.Nbr.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126316);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126310);
    setVisibility(0);
    grO();
    if (this.NbG == null) {
      this.NbG = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(126304);
          f.this.setVisibility(8);
          f.a(f.this).stopTimer();
          AppMethodBeat.o(126304);
          return false;
        }
      }, false);
    }
    this.NbG.stopTimer();
    this.NbG.startTimer(2000L);
    AppMethodBeat.o(126310);
  }
  
  public static abstract interface a
  {
    public abstract void b(esy paramesy, int paramInt1, int paramInt2);
    
    public abstract void grL();
    
    public abstract void grM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.f
 * JD-Core Version:    0.7.0.1
 */