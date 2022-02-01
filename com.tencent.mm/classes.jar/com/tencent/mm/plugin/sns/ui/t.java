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
import com.tencent.mm.plugin.sns.j.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public final class t
  extends LinearLayout
  implements w
{
  private Context context;
  private boolean dfZ;
  private int dga;
  private String dgl;
  private String fnC;
  private int oeH;
  b yzA;
  private p yzB;
  private a yzC;
  private View.OnTouchListener yzD;
  private boolean yzE;
  
  public t(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(97887);
    this.yzA = new b();
    this.yzB = null;
    this.oeH = 0;
    this.dgl = "";
    this.dfZ = false;
    this.yzD = bs.eWg();
    this.fnC = "";
    this.yzE = true;
    this.oeH = paramInt;
    this.dfZ = paramBoolean;
    init(paramContext);
    AppMethodBeat.o(97887);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97889);
    this.context = paramContext;
    if (this.oeH == -1)
    {
      AppMethodBeat.o(97889);
      return;
    }
    this.fnC = u.axw();
    View localView = LayoutInflater.from(paramContext).inflate(2131495547, this, true);
    this.yzA.yzH = ((LinearLayout)localView.findViewById(2131305188));
    this.yzA.yzP = ((LinearLayout)localView.findViewById(2131306430));
    this.yzA.yzK = ((LinearLayout)localView.findViewById(2131301418));
    this.yzA.yzK.setOnTouchListener(this.yzD);
    this.yzA.gAV = ((ImageView)localView.findViewById(2131300985));
    this.yzA.yzL = ((LinearLayout)localView.findViewById(2131298526));
    this.yzA.yzL.setOnTouchListener(this.yzD);
    this.yzA.yzM = ((LinearLayout)localView.findViewById(2131298759));
    this.yzA.gyR = ((TextView)localView.findViewById(2131304953));
    this.yzA.yzO = ((TextView)localView.findViewById(2131304954));
    this.yzA.yzN = ((TextView)localView.findViewById(2131300683));
    this.yzA.yzI = ((TextView)localView.findViewById(2131304601));
    this.yzA.yzJ = ((LinearLayout)localView.findViewById(2131304602));
    this.yzA.gAI = ((TextView)localView.findViewById(2131304968));
    this.yzA.yzT = ((LinearLayout)localView.findViewById(2131301011));
    ((LinearLayout)localView.findViewById(2131301011)).getBackground().setAlpha(50);
    this.yzA.fxQ = ((ImageView)localView.findViewById(2131297021));
    this.yzA.yzQ = ((ImageView)localView.findViewById(2131301548));
    this.yzA.yzR = ((ImageView)localView.findViewById(2131299518));
    this.yzA.yzS = ((LinearLayout)localView.findViewById(2131298959));
    this.yzA.yzU = ((TextView)localView.findViewById(2131298961));
    if (this.oeH == 2)
    {
      this.yzA.yzP.setVisibility(8);
      this.yzA.yzS.setVisibility(8);
      this.yzA.yzJ.setVisibility(0);
    }
    for (;;)
    {
      this.yzA.yzK.setOnClickListener(new View.OnClickListener()
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
            if (t.a(t.this).dMt())
            {
              am.a.a(t.a(t.this), 1, "", "", t.b(t.this));
              t.a(t.this).field_likeFlag = 1;
              af.dHR().K(t.a(t.this));
              f.ydE.dJw().dTj = 2L;
              label107:
              if (t.a(t.this).field_snsId != 0L) {
                break label294;
              }
            }
          }
          label294:
          for (paramAnonymousView = "";; paramAnonymousView = com.tencent.mm.plugin.sns.data.q.wW(t.a(t.this).field_snsId))
          {
            h.wUl.f(11989, new Object[] { Integer.valueOf(1), paramAnonymousView, Integer.valueOf(0) });
            new ao().postDelayed(new Runnable()
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
            af.dHR().K(t.a(t.this));
            am.a.atW(t.a(t.this).getSnsId());
            t.a(t.this, af.dHR().xK(t.a(t.this).field_snsId));
            f.ydE.dJw().dTj = 4L;
            break label107;
          }
        }
      });
      this.yzA.yzL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97882);
          ac.d("MicroMsg.GalleryFooter", "comment cmd");
          if (t.a(t.this) == null)
          {
            AppMethodBeat.o(97882);
            return;
          }
          int i = t.a(t.this).yvp;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("sns_comment_localId", i);
          ((Intent)localObject).putExtra("sns_source", t.b(t.this));
          ((Intent)localObject).setClass(paramContext, SnsCommentUI.class);
          if (t.a(t.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = com.tencent.mm.plugin.sns.data.q.wW(t.a(t.this).field_snsId))
          {
            h.wUl.f(11989, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(0) });
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(97882);
            return;
          }
        }
      });
      this.yzA.yzM.setOnClickListener(new View.OnClickListener()
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
          for (paramAnonymousView = "";; paramAnonymousView = com.tencent.mm.plugin.sns.data.q.wW(t.a(t.this).field_snsId))
          {
            h.wUl.f(11989, new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(0) });
            int i = t.a(t.this).yvp;
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(paramContext, SnsCommentDetailUI.class);
            paramAnonymousView.putExtra("INTENT_TALKER", t.a(t.this).field_userName);
            paramAnonymousView.putExtra("INTENT_SNS_LOCAL_ID", x.bk("sns_table_", i));
            paramAnonymousView.putExtra("INTENT_FROMGALLERY", true);
            ((MMActivity)paramContext).startActivityForResult(paramAnonymousView, 1);
            f.ydE.dJw().dTb = 1L;
            AppMethodBeat.o(97883);
            return;
          }
        }
      });
      this.yzA.yzI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97884);
          if (t.c(t.this) != null) {
            t.c(t.this).dNd();
          }
          AppMethodBeat.o(97884);
        }
      });
      this.yzA.yzU.setOnClickListener(new View.OnClickListener()
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
      if (this.oeH == 3)
      {
        this.yzA.yzP.setVisibility(8);
        this.yzA.yzJ.setVisibility(8);
        this.yzA.yzS.setVisibility(0);
      }
      else
      {
        this.yzA.yzP.setVisibility(0);
        this.yzA.yzJ.setVisibility(8);
        this.yzA.yzS.setVisibility(8);
      }
    }
  }
  
  public final void avx(String paramString)
  {
    AppMethodBeat.i(97892);
    setFooter(paramString);
    AppMethodBeat.o(97892);
  }
  
  public final int getFooterH()
  {
    AppMethodBeat.i(97893);
    if (this.yzA.yzH != null)
    {
      int i = this.yzA.yzH.getHeight();
      AppMethodBeat.o(97893);
      return i;
    }
    AppMethodBeat.o(97893);
    return 10;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(97890);
    if (this.oeH == -1)
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.yzB = af.dHR().auT(this.dgl);
    if ((bs.isNullOrNil(this.dgl)) || (this.yzB == null))
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.yzA.yzR.setVisibility(8);
    if (aj.as(this.yzB.field_localPrivate, this.dfZ))
    {
      this.yzA.yzL.setVisibility(8);
      this.yzA.yzK.setVisibility(8);
      localObject = aj.t(this.yzB);
      if (localObject != null)
      {
        if (this.yzB.dMt())
        {
          int i = ((SnsObject)localObject).CommentCount;
          if (i <= 0) {
            break label528;
          }
          this.yzA.yzO.setText(String.valueOf(i));
          this.yzA.yzO.setVisibility(0);
          label165:
          int j = ((SnsObject)localObject).LikeCount;
          if (j <= 0) {
            break label543;
          }
          this.yzA.gyR.setText(String.valueOf(j));
          this.yzA.gyR.setVisibility(0);
          label199:
          ac.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + j);
          if (this.yzB.field_likeFlag != 1) {
            break label558;
          }
          localObject = getResources().getString(2131763835);
          this.yzA.yzN.setText((CharSequence)localObject);
          this.yzA.gAV.setImageResource(2131690240);
          label278:
          f.ydE.dJw().dTg = i;
          f.ydE.dJw().dTh = j;
        }
        if ((this.fnC.equals(this.yzB.field_userName)) || (!this.dfZ)) {
          break label599;
        }
        this.yzA.fxQ.setVisibility(0);
        a.b.c(this.yzA.fxQ, this.yzB.field_userName);
      }
    }
    for (;;)
    {
      if (this.yzB.dLV() != null) {
        break label614;
      }
      this.yzA.gAI.setVisibility(8);
      AppMethodBeat.o(97890);
      return;
      if (!this.yzB.dMt())
      {
        this.yzA.yzT.setVisibility(0);
        this.yzA.yzP.setVisibility(0);
        this.yzA.yzH.setVisibility(8);
        this.yzA.yzM.setVisibility(8);
        this.yzA.yzL.setVisibility(8);
        this.yzA.yzK.setVisibility(8);
        break;
      }
      if (this.yzE) {
        this.yzA.yzH.setVisibility(0);
      }
      this.yzA.yzM.setVisibility(0);
      this.yzA.yzL.setVisibility(0);
      this.yzA.yzK.setVisibility(0);
      this.yzA.yzP.setVisibility(0);
      break;
      label528:
      this.yzA.yzO.setVisibility(8);
      break label165;
      label543:
      this.yzA.gyR.setVisibility(8);
      break label199;
      label558:
      localObject = getResources().getString(2131763836);
      this.yzA.yzN.setText(String.valueOf(localObject));
      this.yzA.gAV.setImageResource(2131690241);
      break label278;
      label599:
      this.yzA.fxQ.setVisibility(8);
    }
    label614:
    Object localObject = this.yzB.dLV().FQl;
    if ((localObject == null) || (((String)localObject).equals("")))
    {
      this.yzA.gAI.setText("");
      this.yzA.gAI.setVisibility(8);
      if (!aj.as(this.yzB.field_localPrivate, this.dfZ)) {
        break label828;
      }
      this.yzA.yzQ.setVisibility(0);
      this.yzA.gAI.setVisibility(0);
    }
    for (;;)
    {
      if ((this.dfZ) && (this.yzB.dMw()))
      {
        this.yzA.yzM.setVisibility(0);
        this.yzA.gAI.setVisibility(0);
        this.yzA.yzR.setVisibility(0);
      }
      AppMethodBeat.o(97890);
      return;
      this.yzA.gAI.setText(k.b(getContext(), (String)localObject + " ", this.yzA.gAI.getTextSize()));
      this.yzA.gAI.setVisibility(0);
      f.ydE.dJw().dSY = 1L;
      break;
      label828:
      this.yzA.yzQ.setVisibility(8);
    }
  }
  
  public final void setCallBack(a parama)
  {
    this.yzC = parama;
  }
  
  public final void setFooter(String paramString)
  {
    AppMethodBeat.i(97891);
    this.dgl = paramString;
    refresh();
    AppMethodBeat.o(97891);
  }
  
  public final void setSnsSource(int paramInt)
  {
    this.dga = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(97888);
    this.oeH = paramInt;
    init(this.context);
    AppMethodBeat.o(97888);
  }
  
  public final void setVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(97886);
    if ((this.oeH == 2) || (this.oeH == 3))
    {
      super.setVisibility(paramInt);
      if (paramInt == 8) {}
      for (;;)
      {
        this.yzE = bool;
        AppMethodBeat.o(97886);
        return;
        bool = true;
      }
    }
    if ((this.yzB != null) && (!this.yzB.dMt()))
    {
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 8)
    {
      this.yzA.yzH.setVisibility(8);
      this.yzE = false;
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 0)
    {
      this.yzA.yzH.setVisibility(0);
      this.yzE = true;
    }
    AppMethodBeat.o(97886);
  }
  
  public static abstract interface a
  {
    public abstract void dNd();
  }
  
  final class b
  {
    ImageView fxQ;
    TextView gAI;
    ImageView gAV;
    TextView gyR;
    LinearLayout yzH;
    TextView yzI;
    LinearLayout yzJ;
    LinearLayout yzK;
    LinearLayout yzL;
    LinearLayout yzM;
    TextView yzN;
    TextView yzO;
    LinearLayout yzP;
    ImageView yzQ;
    ImageView yzR;
    LinearLayout yzS;
    LinearLayout yzT;
    TextView yzU;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.t
 * JD-Core Version:    0.7.0.1
 */