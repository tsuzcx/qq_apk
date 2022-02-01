package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.b;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class f
  extends g
{
  public TextView IXv;
  private foh TIZ;
  public ImageView TLV;
  public View TNZ;
  public View TOa;
  public ImageView TOb;
  public TextView TOc;
  public View TOd;
  public View TOe;
  public View TOf;
  public View TOg;
  public View TOh;
  public View TOi;
  public View TOj;
  public TextView TOk;
  public TextView TOl;
  public ImageView TOm;
  public ImageView TOn;
  public View TOo;
  MTimerHandler TOp;
  private a TOq;
  private boolean TOr;
  public TextView titleTv;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean cvt()
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
  
  public final void cvy()
  {
    AppMethodBeat.i(126312);
    if (this.TOp != null)
    {
      this.TOp.stopTimer();
      this.TOp.startTimer(2000L);
    }
    AppMethodBeat.o(126312);
  }
  
  public final void cxb()
  {
    AppMethodBeat.i(126321);
    super.cxb();
    if ((this.TOq != null) && (this.TIZ != null)) {
      this.TOq.b(this.TIZ, this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126321);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(126313);
    int i = this.sHo.getWidth();
    AppMethodBeat.o(126313);
    return i;
  }
  
  public int getLayoutId()
  {
    return c.e.top_story_fs_video_control_bar;
  }
  
  public View getWowView()
  {
    return this.TOa;
  }
  
  public final void hON()
  {
    AppMethodBeat.i(126311);
    if (this.TOp != null) {
      this.TOp.stopTimer();
    }
    AppMethodBeat.o(126311);
  }
  
  public final void hOO()
  {
    AppMethodBeat.i(126319);
    this.sHp.setVisibility(8);
    AppMethodBeat.o(126319);
  }
  
  public final void hOP()
  {
    AppMethodBeat.i(126320);
    this.sHp.setVisibility(0);
    AppMethodBeat.o(126320);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(369749);
    setVisibility(8);
    AppMethodBeat.o(369749);
  }
  
  public void init()
  {
    AppMethodBeat.i(126305);
    super.init();
    this.TOd = this.contentView.findViewById(c.d.content_area_layout);
    this.TNZ = this.contentView.findViewById(c.d.share_iv);
    this.TOa = this.contentView.findViewById(c.d.wow_iv);
    this.TOb = ((ImageView)this.contentView.findViewById(c.d.wow_icon_view));
    this.TOc = ((TextView)this.contentView.findViewById(c.d.wow_icon_text));
    this.TOe = this.contentView.findViewById(c.d.progress_root_bg);
    this.TOf = this.contentView.findViewById(c.d.progress_root);
    this.TOg = this.contentView.findViewById(c.d.tag_desc_layout);
    this.TOh = this.contentView.findViewById(c.d.bottom_tag_layout);
    this.TOi = this.contentView.findViewById(c.d.tag_1_ll);
    this.TOj = this.contentView.findViewById(c.d.tag_2_ll);
    this.TOk = ((TextView)this.contentView.findViewById(c.d.tag_1_tv));
    this.TOl = ((TextView)this.contentView.findViewById(c.d.tag_2_tv));
    this.TOm = ((ImageView)this.contentView.findViewById(c.d.tag_1_icon));
    this.TOn = ((ImageView)this.contentView.findViewById(c.d.tag_2_icon));
    this.TLV = ((ImageView)this.contentView.findViewById(c.d.source_iv));
    this.IXv = ((TextView)this.contentView.findViewById(c.d.source_tv));
    this.TOo = this.contentView.findViewById(c.d.source_arrow);
    this.titleTv = ((TextView)this.contentView.findViewById(c.d.title_tv));
    AppMethodBeat.o(126305);
  }
  
  public final void m(foh paramfoh)
  {
    AppMethodBeat.i(126306);
    if ((paramfoh.abOE & 0x80) > 0)
    {
      this.TOa.setVisibility(0);
      if (paramfoh.abOJ)
      {
        this.TOb.setImageResource(c.f.top_story_wow_selected);
        this.TOc.setTextColor(getResources().getColor(c.a.top_story_wow_like));
      }
      for (;;)
      {
        this.TOc.setText(d.aoN(paramfoh.abON));
        AppMethodBeat.o(126306);
        return;
        this.TOb.setImageResource(c.f.top_story_wow_unselected);
        this.TOc.setTextColor(getResources().getColor(c.a.white_text_color));
      }
    }
    this.TOa.setVisibility(8);
    AppMethodBeat.o(126306);
  }
  
  public void n(foh paramfoh)
  {
    AppMethodBeat.i(126307);
    this.TIZ = paramfoh;
    this.TNZ.setVisibility(0);
    float f = getResources().getDimensionPixelSize(c.b.fts_web_video_fullscreen_control_bar_time_textsize);
    this.sHq.setTextSize(0, f);
    this.sHr.setTextSize(0, f);
    Object localObject = this.TOf.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(c.b.fts_web_video_fullscreen_control_bar_height);
    this.TOf.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramfoh.Idn.size() > 0)
    {
      if (this.TOg != null) {
        this.TOg.setVisibility(0);
      }
      this.TOh.setVisibility(0);
      localObject = (fcl)paramfoh.Idn.get(0);
      this.TOi.setTag(localObject);
      this.TOk.setText(((fcl)localObject).wording);
      this.TOk.setVisibility(0);
      this.TOi.setVisibility(0);
      this.TOm.setVisibility(8);
      if (!Util.isNullOrNil(((fcl)localObject).icon))
      {
        r.bKe().a(((fcl)localObject).icon, this.TOm, d.TJk);
        this.TOm.setVisibility(0);
      }
      if (paramfoh.Idn.size() > 1)
      {
        localObject = (fcl)paramfoh.Idn.get(1);
        this.TOj.setTag(localObject);
        this.TOl.setText(((fcl)localObject).wording);
        this.TOl.setVisibility(0);
        this.TOj.setVisibility(0);
        this.TOn.setVisibility(8);
        if (!Util.isNullOrNil(((fcl)localObject).icon))
        {
          r.bKe().a(((fcl)localObject).icon, this.TOn, d.TJk);
          this.TOn.setVisibility(0);
        }
        m(paramfoh);
        if (this.TOr) {
          this.TOh.setVisibility(8);
        }
        if ((this.TOo != null) && (this.IXv != null) && (this.TLV != null))
        {
          this.TOo.setVisibility(8);
          this.IXv.setVisibility(8);
          this.TLV.setVisibility(8);
          if (!Util.isNullOrNil(paramfoh.source))
          {
            this.IXv.setText(paramfoh.source);
            this.IXv.setVisibility(0);
            if (n.i(paramfoh)) {
              this.TOo.setVisibility(0);
            }
            if (Util.isNullOrNil(paramfoh.aaXP)) {
              break label527;
            }
            r.bKe().a(paramfoh.aaXP, this.TLV, d.TJj);
          }
        }
      }
    }
    for (;;)
    {
      this.TLV.setVisibility(0);
      if (this.titleTv != null) {
        this.titleTv.setText(paramfoh.title);
      }
      AppMethodBeat.o(126307);
      return;
      this.TOj.setVisibility(8);
      this.TOl.setVisibility(8);
      break;
      if (this.TOg != null) {
        this.TOg.setVisibility(8);
      }
      this.TOh.setVisibility(8);
      break;
      label527:
      this.TLV.setImageResource(c.c.default_avatar);
    }
  }
  
  public void setOnUpdateProgressLenListener(a parama)
  {
    this.TOq = parama;
  }
  
  public void setOnlyFS(boolean paramBoolean)
  {
    this.TOr = paramBoolean;
  }
  
  public void setShareBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126314);
    this.TNZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126314);
  }
  
  public void setSourceItemClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126317);
    if (this.IXv != null) {
      this.IXv.setOnClickListener(paramOnClickListener);
    }
    if (this.TLV != null) {
      this.TLV.setOnClickListener(paramOnClickListener);
    }
    if (this.TOo != null) {
      this.TOo.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(126317);
  }
  
  public void setTagBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126315);
    this.TOi.setOnClickListener(paramOnClickListener);
    this.TOj.setOnClickListener(paramOnClickListener);
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
      if (this.TOq != null)
      {
        this.TOq.hOM();
        AppMethodBeat.o(126322);
      }
    }
    else if ((paramInt == 0) && (this.TOq != null)) {
      this.TOq.hOL();
    }
    AppMethodBeat.o(126322);
  }
  
  public void setWowBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126316);
    this.TOa.setVisibility(0);
    this.TOa.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126316);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126310);
    setVisibility(0);
    hOP();
    if (this.TOp == null) {
      this.TOp = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.TOp.stopTimer();
    this.TOp.startTimer(2000L);
    AppMethodBeat.o(126310);
  }
  
  public static abstract interface a
  {
    public abstract void b(foh paramfoh, int paramInt1, int paramInt2);
    
    public abstract void hOL();
    
    public abstract void hOM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.f
 * JD-Core Version:    0.7.0.1
 */