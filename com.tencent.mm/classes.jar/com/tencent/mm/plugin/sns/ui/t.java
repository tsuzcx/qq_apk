package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.k.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public final class t
  extends LinearLayout
  implements w
{
  private Context context;
  private boolean diE;
  private int diF;
  private String diQ;
  private String fki;
  private int nBH;
  b xmI;
  private p xmJ;
  private a xmK;
  private View.OnTouchListener xmL;
  private boolean xmM;
  
  public t(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(97887);
    this.xmI = new b();
    this.xmJ = null;
    this.nBH = 0;
    this.diQ = "";
    this.diE = false;
    this.xmL = bt.eGL();
    this.fki = "";
    this.xmM = true;
    this.nBH = paramInt;
    this.diE = paramBoolean;
    init(paramContext);
    AppMethodBeat.o(97887);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97889);
    this.context = paramContext;
    if (this.nBH == -1)
    {
      AppMethodBeat.o(97889);
      return;
    }
    this.fki = u.aqG();
    View localView = LayoutInflater.from(paramContext).inflate(2131495547, this, true);
    this.xmI.xmP = ((LinearLayout)localView.findViewById(2131305188));
    this.xmI.xmY = ((LinearLayout)localView.findViewById(2131306430));
    this.xmI.xmS = ((LinearLayout)localView.findViewById(2131301418));
    this.xmI.xmS.setOnTouchListener(this.xmL);
    this.xmI.xmT = ((ImageView)localView.findViewById(2131300985));
    this.xmI.xmU = ((LinearLayout)localView.findViewById(2131298526));
    this.xmI.xmU.setOnTouchListener(this.xmL);
    this.xmI.xmV = ((LinearLayout)localView.findViewById(2131298759));
    this.xmI.qrL = ((TextView)localView.findViewById(2131304953));
    this.xmI.xmX = ((TextView)localView.findViewById(2131304954));
    this.xmI.xmW = ((TextView)localView.findViewById(2131300683));
    this.xmI.xmQ = ((TextView)localView.findViewById(2131304601));
    this.xmI.xmR = ((LinearLayout)localView.findViewById(2131304602));
    this.xmI.lEA = ((TextView)localView.findViewById(2131304968));
    this.xmI.xnc = ((LinearLayout)localView.findViewById(2131301011));
    ((LinearLayout)localView.findViewById(2131301011)).getBackground().setAlpha(50);
    this.xmI.fuj = ((ImageView)localView.findViewById(2131297021));
    this.xmI.xmZ = ((ImageView)localView.findViewById(2131301548));
    this.xmI.xna = ((ImageView)localView.findViewById(2131299518));
    this.xmI.xnb = ((LinearLayout)localView.findViewById(2131298959));
    this.xmI.xnd = ((TextView)localView.findViewById(2131298961));
    if (this.nBH == 2)
    {
      this.xmI.xmY.setVisibility(8);
      this.xmI.xnb.setVisibility(8);
      this.xmI.xmR.setVisibility(0);
    }
    for (;;)
    {
      this.xmI.xmS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97881);
          if (t.a(t.this) == null)
          {
            AppMethodBeat.o(97881);
            return;
          }
          if (t.a(t.this).field_likeFlag == 0) {
            if (t.a(t.this).dxW())
            {
              am.a.a(t.a(t.this), 1, "", "", t.b(t.this));
              t.a(t.this).field_likeFlag = 1;
              af.dtu().J(t.a(t.this));
              f.wQY.duX().dRv = 2L;
              label107:
              if (t.a(t.this).field_snsId != 0L) {
                break label294;
              }
            }
          }
          label294:
          for (paramAnonymousView = "";; paramAnonymousView = com.tencent.mm.plugin.sns.data.q.st(t.a(t.this).field_snsId))
          {
            h.vKh.f(11989, new Object[] { Integer.valueOf(1), paramAnonymousView, Integer.valueOf(0) });
            new ap().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97880);
                t.this.refresh();
                AppMethodBeat.o(97880);
              }
            }, 500L);
            AppMethodBeat.o(97881);
            return;
            am.a.a(t.a(t.this).field_userName, 5, "", t.a(t.this), t.b(t.this));
            break;
            t.a(t.this).field_likeFlag = 0;
            af.dtu().J(t.a(t.this));
            am.a.aoK(t.a(t.this).getSnsId());
            t.a(t.this, af.dtu().th(t.a(t.this).field_snsId));
            f.wQY.duX().dRv = 4L;
            break label107;
          }
        }
      });
      this.xmI.xmU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97882);
          ad.d("MicroMsg.GalleryFooter", "comment cmd");
          if (t.a(t.this) == null)
          {
            AppMethodBeat.o(97882);
            return;
          }
          int i = t.a(t.this).xiB;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("sns_comment_localId", i);
          ((Intent)localObject).putExtra("sns_source", t.b(t.this));
          ((Intent)localObject).setClass(paramContext, SnsCommentUI.class);
          if (t.a(t.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = com.tencent.mm.plugin.sns.data.q.st(t.a(t.this).field_snsId))
          {
            h.vKh.f(11989, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(0) });
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(97882);
            return;
          }
        }
      });
      this.xmI.xmV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97883);
          if (t.a(t.this) == null)
          {
            AppMethodBeat.o(97883);
            return;
          }
          if (t.a(t.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = com.tencent.mm.plugin.sns.data.q.st(t.a(t.this).field_snsId))
          {
            h.vKh.f(11989, new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(0) });
            int i = t.a(t.this).xiB;
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(paramContext, SnsCommentDetailUI.class);
            paramAnonymousView.putExtra("INTENT_TALKER", t.a(t.this).field_userName);
            paramAnonymousView.putExtra("INTENT_SNS_LOCAL_ID", x.bi("sns_table_", i));
            paramAnonymousView.putExtra("INTENT_FROMGALLERY", true);
            ((MMActivity)paramContext).startActivityForResult(paramAnonymousView, 1);
            f.wQY.duX().dRn = 1L;
            AppMethodBeat.o(97883);
            return;
          }
        }
      });
      this.xmI.xmQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97884);
          if (t.c(t.this) != null) {
            t.c(t.this).dyG();
          }
          AppMethodBeat.o(97884);
        }
      });
      this.xmI.xnd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97885);
          if (t.c(t.this) != null) {
            t.c(t.this);
          }
          AppMethodBeat.o(97885);
        }
      });
      AppMethodBeat.o(97889);
      return;
      if (this.nBH == 3)
      {
        this.xmI.xmY.setVisibility(8);
        this.xmI.xmR.setVisibility(8);
        this.xmI.xnb.setVisibility(0);
      }
      else
      {
        this.xmI.xmY.setVisibility(0);
        this.xmI.xmR.setVisibility(8);
        this.xmI.xnb.setVisibility(8);
      }
    }
  }
  
  public final void aqo(String paramString)
  {
    AppMethodBeat.i(97892);
    setFooter(paramString);
    AppMethodBeat.o(97892);
  }
  
  public final int getFooterH()
  {
    AppMethodBeat.i(97893);
    if (this.xmI.xmP != null)
    {
      int i = this.xmI.xmP.getHeight();
      AppMethodBeat.o(97893);
      return i;
    }
    AppMethodBeat.o(97893);
    return 10;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(97890);
    if (this.nBH == -1)
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.xmJ = af.dtu().apK(this.diQ);
    if ((bt.isNullOrNil(this.diQ)) || (this.xmJ == null))
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.xmI.xna.setVisibility(8);
    if (aj.ap(this.xmJ.field_localPrivate, this.diE))
    {
      this.xmI.xmU.setVisibility(8);
      this.xmI.xmS.setVisibility(8);
      localObject = aj.t(this.xmJ);
      if (localObject != null)
      {
        if (this.xmJ.dxW())
        {
          int i = ((SnsObject)localObject).CommentCount;
          if (i <= 0) {
            break label528;
          }
          this.xmI.xmX.setText(String.valueOf(i));
          this.xmI.xmX.setVisibility(0);
          label165:
          int j = ((SnsObject)localObject).LikeCount;
          if (j <= 0) {
            break label543;
          }
          this.xmI.qrL.setText(String.valueOf(j));
          this.xmI.qrL.setVisibility(0);
          label199:
          ad.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + j);
          if (this.xmJ.field_likeFlag != 1) {
            break label558;
          }
          localObject = getResources().getString(2131763835);
          this.xmI.xmW.setText((CharSequence)localObject);
          this.xmI.xmT.setImageResource(2131690240);
          label278:
          f.wQY.duX().dRs = i;
          f.wQY.duX().dRt = j;
        }
        if ((this.fki.equals(this.xmJ.field_userName)) || (!this.diE)) {
          break label599;
        }
        this.xmI.fuj.setVisibility(0);
        a.b.c(this.xmI.fuj, this.xmJ.field_userName);
      }
    }
    for (;;)
    {
      if (this.xmJ.dxy() != null) {
        break label614;
      }
      this.xmI.lEA.setVisibility(8);
      AppMethodBeat.o(97890);
      return;
      if (!this.xmJ.dxW())
      {
        this.xmI.xnc.setVisibility(0);
        this.xmI.xmY.setVisibility(0);
        this.xmI.xmP.setVisibility(8);
        this.xmI.xmV.setVisibility(8);
        this.xmI.xmU.setVisibility(8);
        this.xmI.xmS.setVisibility(8);
        break;
      }
      if (this.xmM) {
        this.xmI.xmP.setVisibility(0);
      }
      this.xmI.xmV.setVisibility(0);
      this.xmI.xmU.setVisibility(0);
      this.xmI.xmS.setVisibility(0);
      this.xmI.xmY.setVisibility(0);
      break;
      label528:
      this.xmI.xmX.setVisibility(8);
      break label165;
      label543:
      this.xmI.qrL.setVisibility(8);
      break label199;
      label558:
      localObject = getResources().getString(2131763836);
      this.xmI.xmW.setText(String.valueOf(localObject));
      this.xmI.xmT.setImageResource(2131690241);
      break label278;
      label599:
      this.xmI.fuj.setVisibility(8);
    }
    label614:
    Object localObject = this.xmJ.dxy().Etj;
    if ((localObject == null) || (((String)localObject).equals("")))
    {
      this.xmI.lEA.setText("");
      this.xmI.lEA.setVisibility(8);
      if (!aj.ap(this.xmJ.field_localPrivate, this.diE)) {
        break label828;
      }
      this.xmI.xmZ.setVisibility(0);
      this.xmI.lEA.setVisibility(0);
    }
    for (;;)
    {
      if ((this.diE) && (this.xmJ.dxZ()))
      {
        this.xmI.xmV.setVisibility(0);
        this.xmI.lEA.setVisibility(0);
        this.xmI.xna.setVisibility(0);
      }
      AppMethodBeat.o(97890);
      return;
      this.xmI.lEA.setText(k.b(getContext(), (String)localObject + " ", this.xmI.lEA.getTextSize()));
      this.xmI.lEA.setVisibility(0);
      f.wQY.duX().dRk = 1L;
      break;
      label828:
      this.xmI.xmZ.setVisibility(8);
    }
  }
  
  public final void setCallBack(a parama)
  {
    this.xmK = parama;
  }
  
  public final void setFooter(String paramString)
  {
    AppMethodBeat.i(97891);
    this.diQ = paramString;
    refresh();
    AppMethodBeat.o(97891);
  }
  
  public final void setSnsSource(int paramInt)
  {
    this.diF = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(97888);
    this.nBH = paramInt;
    init(this.context);
    AppMethodBeat.o(97888);
  }
  
  public final void setVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(97886);
    if ((this.nBH == 2) || (this.nBH == 3))
    {
      super.setVisibility(paramInt);
      if (paramInt == 8) {}
      for (;;)
      {
        this.xmM = bool;
        AppMethodBeat.o(97886);
        return;
        bool = true;
      }
    }
    if ((this.xmJ != null) && (!this.xmJ.dxW()))
    {
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 8)
    {
      this.xmI.xmP.setVisibility(8);
      this.xmM = false;
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 0)
    {
      this.xmI.xmP.setVisibility(0);
      this.xmM = true;
    }
    AppMethodBeat.o(97886);
  }
  
  public static abstract interface a
  {
    public abstract void dyG();
  }
  
  final class b
  {
    ImageView fuj;
    TextView lEA;
    TextView qrL;
    LinearLayout xmP;
    TextView xmQ;
    LinearLayout xmR;
    LinearLayout xmS;
    ImageView xmT;
    LinearLayout xmU;
    LinearLayout xmV;
    TextView xmW;
    TextView xmX;
    LinearLayout xmY;
    ImageView xmZ;
    ImageView xna;
    LinearLayout xnb;
    LinearLayout xnc;
    TextView xnd;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.t
 * JD-Core Version:    0.7.0.1
 */