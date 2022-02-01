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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
  extends LinearLayout
  implements ab
{
  b Rdv;
  private SnsInfo Rdw;
  private y.a Rdx;
  private View.OnTouchListener Rdy;
  private boolean Rdz;
  private Context context;
  private String hHB;
  private boolean hHq;
  private int hHr;
  private String ltf;
  private int viewType;
  
  public y(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(97887);
    this.Rdv = new b();
    this.Rdw = null;
    this.viewType = 0;
    this.hHB = "";
    this.hHq = false;
    this.Rdy = Util.genLinearPressedListener();
    this.ltf = "";
    this.Rdz = true;
    this.viewType = paramInt;
    this.hHq = paramBoolean;
    init(paramContext);
    AppMethodBeat.o(97887);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97889);
    this.context = paramContext;
    if (this.viewType == -1)
    {
      AppMethodBeat.o(97889);
      return;
    }
    this.ltf = z.bAM();
    View localView = LayoutInflater.from(paramContext).inflate(b.g.sns_gallery_footer, this, true);
    this.Rdv.RdC = ((LinearLayout)localView.findViewById(b.f.state_ll));
    this.Rdv.RdK = ((LinearLayout)localView.findViewById(b.f.view_media));
    this.Rdv.RdF = ((LinearLayout)localView.findViewById(b.f.like_ll));
    this.Rdv.RdF.setOnTouchListener(this.Rdy);
    this.Rdv.nhO = ((ImageView)localView.findViewById(b.f.img_button_like));
    this.Rdv.RdG = ((LinearLayout)localView.findViewById(b.f.comment_ll));
    this.Rdv.RdG.setOnTouchListener(this.Rdy);
    this.Rdv.RdH = ((LinearLayout)localView.findViewById(b.f.content_info));
    this.Rdv.nga = ((TextView)localView.findViewById(b.f.sns_cm1_tv));
    this.Rdv.RdJ = ((TextView)localView.findViewById(b.f.sns_cm2_tv));
    this.Rdv.RdI = ((TextView)localView.findViewById(b.f.has_like_tv));
    this.Rdv.RdD = ((TextView)localView.findViewById(b.f.set_bg));
    this.Rdv.RdE = ((LinearLayout)localView.findViewById(b.f.set_bg_ll));
    this.Rdv.descTv = ((TextView)localView.findViewById(b.f.sns_desc));
    this.Rdv.RdO = ((LinearLayout)localView.findViewById(b.f.info_line));
    ((LinearLayout)localView.findViewById(b.f.info_line)).getBackground().setAlpha(50);
    this.Rdv.lKK = ((ImageView)localView.findViewById(b.f.avatar_with));
    this.Rdv.RdL = ((ImageView)localView.findViewById(b.f.lock_icon));
    this.Rdv.RdM = ((ImageView)localView.findViewById(b.f.error_icon));
    this.Rdv.RdN = ((LinearLayout)localView.findViewById(b.f.del_ll));
    this.Rdv.RdP = ((TextView)localView.findViewById(b.f.del_tv));
    if (this.viewType == 2)
    {
      this.Rdv.RdK.setVisibility(8);
      this.Rdv.RdN.setVisibility(8);
      this.Rdv.RdE.setVisibility(0);
    }
    for (;;)
    {
      this.Rdv.RdF.setOnClickListener(new y.1(this));
      this.Rdv.RdG.setOnClickListener(new y.2(this, paramContext));
      this.Rdv.RdH.setOnClickListener(new y.3(this, paramContext));
      this.Rdv.RdD.setOnClickListener(new y.4(this));
      this.Rdv.RdP.setOnClickListener(new y.5(this));
      AppMethodBeat.o(97889);
      return;
      if (this.viewType == 3)
      {
        this.Rdv.RdK.setVisibility(8);
        this.Rdv.RdE.setVisibility(8);
        this.Rdv.RdN.setVisibility(0);
      }
      else
      {
        this.Rdv.RdK.setVisibility(0);
        this.Rdv.RdE.setVisibility(8);
        this.Rdv.RdN.setVisibility(8);
      }
    }
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(97890);
    if (this.viewType == -1)
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.Rdw = al.hgB().aZL(this.hHB);
    if ((Util.isNullOrNil(this.hHB)) || (this.Rdw == null))
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.Rdv.RdM.setVisibility(8);
    if (ap.bG(this.Rdw.getLocalPrivate(), this.hHq))
    {
      this.Rdv.RdG.setVisibility(8);
      this.Rdv.RdF.setVisibility(8);
      localObject = ap.E(this.Rdw);
      if (localObject != null)
      {
        if (this.Rdw.isExtFlag())
        {
          int i = ((SnsObject)localObject).CommentCount;
          if (i <= 0) {
            break label570;
          }
          this.Rdv.RdJ.setText(String.valueOf(i));
          this.Rdv.RdJ.setVisibility(0);
          label168:
          int j = ((SnsObject)localObject).LikeCount;
          if (j <= 0) {
            break label585;
          }
          this.Rdv.nga.setText(String.valueOf(j));
          this.Rdv.nga.setVisibility(0);
          label202:
          this.Rdv.RdH.setContentDescription(getResources().getString(b.j.sns_gallery_like_comment_count, new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
          Log.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + j);
          if (this.Rdw.getLikeFlag() != 1) {
            break label600;
          }
          localObject = getResources().getString(b.j.sns_gallery_has_like);
          label295:
          this.Rdv.RdI.setText((CharSequence)localObject);
          this.Rdv.nhO.setImageResource(b.i.friendactivity_comment_likeicon_normal);
          j.QFS.hip().jeT = i;
          j.QFS.hip().jeU = j;
        }
        if ((this.ltf.equals(this.Rdw.getUserName())) || (!this.hHq)) {
          break label614;
        }
        this.Rdv.lKK.setVisibility(0);
        a.b.g(this.Rdv.lKK, this.Rdw.getUserName());
      }
    }
    for (;;)
    {
      if (this.Rdw.getTimeLine() != null) {
        break label629;
      }
      this.Rdv.descTv.setVisibility(8);
      AppMethodBeat.o(97890);
      return;
      if (!this.Rdw.isExtFlag())
      {
        this.Rdv.RdO.setVisibility(0);
        this.Rdv.RdK.setVisibility(0);
        this.Rdv.RdC.setVisibility(8);
        this.Rdv.RdH.setVisibility(8);
        this.Rdv.RdG.setVisibility(8);
        this.Rdv.RdF.setVisibility(8);
        break;
      }
      if (this.Rdz) {
        this.Rdv.RdC.setVisibility(0);
      }
      this.Rdv.RdH.setVisibility(0);
      this.Rdv.RdG.setVisibility(0);
      this.Rdv.RdF.setVisibility(0);
      this.Rdv.RdK.setVisibility(0);
      break;
      label570:
      this.Rdv.RdJ.setVisibility(8);
      break label168;
      label585:
      this.Rdv.nga.setVisibility(8);
      break label202;
      label600:
      localObject = getResources().getString(b.j.sns_gallery_like);
      break label295;
      label614:
      this.Rdv.lKK.setVisibility(8);
    }
    label629:
    Object localObject = this.Rdw.getTimeLine().ContentDesc;
    if ((localObject == null) || (((String)localObject).equals("")))
    {
      this.Rdv.descTv.setText("");
      this.Rdv.descTv.setVisibility(8);
      if (!ap.bG(this.Rdw.getLocalPrivate(), this.hHq)) {
        break label844;
      }
      this.Rdv.RdL.setVisibility(0);
      this.Rdv.descTv.setVisibility(0);
    }
    for (;;)
    {
      if ((this.hHq) && (this.Rdw.isDieItem()))
      {
        this.Rdv.RdH.setVisibility(0);
        this.Rdv.descTv.setVisibility(0);
        this.Rdv.RdM.setVisibility(0);
      }
      AppMethodBeat.o(97890);
      return;
      this.Rdv.descTv.setText(p.b(getContext(), (String)localObject + " ", this.Rdv.descTv.getTextSize()));
      this.Rdv.descTv.setVisibility(0);
      j.QFS.hip().jeL = 1L;
      break;
      label844:
      this.Rdv.RdL.setVisibility(8);
    }
  }
  
  public final void bav(String paramString)
  {
    AppMethodBeat.i(97892);
    setFooter(paramString);
    AppMethodBeat.o(97892);
  }
  
  public final int getFooterH()
  {
    AppMethodBeat.i(97893);
    if (this.Rdv.RdC != null)
    {
      int i = this.Rdv.RdC.getHeight();
      AppMethodBeat.o(97893);
      return i;
    }
    AppMethodBeat.o(97893);
    return 10;
  }
  
  public final void setCallBack(y.a parama)
  {
    this.Rdx = parama;
  }
  
  public final void setFooter(String paramString)
  {
    AppMethodBeat.i(97891);
    this.hHB = paramString;
    bDL();
    AppMethodBeat.o(97891);
  }
  
  public final void setSnsSource(int paramInt)
  {
    this.hHr = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(97888);
    this.viewType = paramInt;
    init(this.context);
    AppMethodBeat.o(97888);
  }
  
  public final void setVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(97886);
    if ((this.viewType == 2) || (this.viewType == 3))
    {
      super.setVisibility(paramInt);
      if (paramInt == 8) {}
      for (;;)
      {
        this.Rdz = bool;
        AppMethodBeat.o(97886);
        return;
        bool = true;
      }
    }
    if ((this.Rdw != null) && (!this.Rdw.isExtFlag()))
    {
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 8)
    {
      this.Rdv.RdC.setVisibility(8);
      this.Rdz = false;
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 0)
    {
      this.Rdv.RdC.setVisibility(0);
      this.Rdz = true;
    }
    AppMethodBeat.o(97886);
  }
  
  final class b
  {
    LinearLayout RdC;
    TextView RdD;
    LinearLayout RdE;
    LinearLayout RdF;
    LinearLayout RdG;
    LinearLayout RdH;
    TextView RdI;
    TextView RdJ;
    LinearLayout RdK;
    ImageView RdL;
    ImageView RdM;
    LinearLayout RdN;
    LinearLayout RdO;
    TextView RdP;
    TextView descTv;
    ImageView lKK;
    TextView nga;
    ImageView nhO;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.y
 * JD-Core Version:    0.7.0.1
 */