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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public final class u
  extends LinearLayout
  implements x
{
  private Context context;
  private String drH;
  private boolean drv;
  private int drw;
  private String fFK;
  private int oIb;
  b zQR;
  private p zQS;
  private a zQT;
  private View.OnTouchListener zQU;
  private boolean zQV;
  
  public u(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(97887);
    this.zQR = new b();
    this.zQS = null;
    this.oIb = 0;
    this.drH = "";
    this.drv = false;
    this.zQU = bt.flQ();
    this.fFK = "";
    this.zQV = true;
    this.oIb = paramInt;
    this.drv = paramBoolean;
    init(paramContext);
    AppMethodBeat.o(97887);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97889);
    this.context = paramContext;
    if (this.oIb == -1)
    {
      AppMethodBeat.o(97889);
      return;
    }
    this.fFK = com.tencent.mm.model.u.aAm();
    View localView = LayoutInflater.from(paramContext).inflate(2131495547, this, true);
    this.zQR.zQY = ((LinearLayout)localView.findViewById(2131305188));
    this.zQR.zRg = ((LinearLayout)localView.findViewById(2131306430));
    this.zQR.zRb = ((LinearLayout)localView.findViewById(2131301418));
    this.zQR.zRb.setOnTouchListener(this.zQU);
    this.zQR.gUF = ((ImageView)localView.findViewById(2131300985));
    this.zQR.zRc = ((LinearLayout)localView.findViewById(2131298526));
    this.zQR.zRc.setOnTouchListener(this.zQU);
    this.zQR.zRd = ((LinearLayout)localView.findViewById(2131298759));
    this.zQR.gSC = ((TextView)localView.findViewById(2131304953));
    this.zQR.zRf = ((TextView)localView.findViewById(2131304954));
    this.zQR.zRe = ((TextView)localView.findViewById(2131300683));
    this.zQR.zQZ = ((TextView)localView.findViewById(2131304601));
    this.zQR.zRa = ((LinearLayout)localView.findViewById(2131304602));
    this.zQR.gUs = ((TextView)localView.findViewById(2131304968));
    this.zQR.zRk = ((LinearLayout)localView.findViewById(2131301011));
    ((LinearLayout)localView.findViewById(2131301011)).getBackground().setAlpha(50);
    this.zQR.fRd = ((ImageView)localView.findViewById(2131297021));
    this.zQR.zRh = ((ImageView)localView.findViewById(2131301548));
    this.zQR.zRi = ((ImageView)localView.findViewById(2131299518));
    this.zQR.zRj = ((LinearLayout)localView.findViewById(2131298959));
    this.zQR.zRl = ((TextView)localView.findViewById(2131298961));
    if (this.oIb == 2)
    {
      this.zQR.zRg.setVisibility(8);
      this.zQR.zRj.setVisibility(8);
      this.zQR.zRa.setVisibility(0);
    }
    for (;;)
    {
      this.zQR.zRb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97881);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (u.a(u.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97881);
            return;
          }
          if (u.a(u.this).field_likeFlag == 0) {
            if (u.a(u.this).dYJ())
            {
              an.a.a(u.a(u.this), 1, "", "", u.b(u.this));
              u.a(u.this).field_likeFlag = 1;
              ag.dUe().M(u.a(u.this));
              e.ztz.dVJ().ejw = 2L;
              label148:
              if (u.a(u.this).field_snsId != 0L) {
                break label347;
              }
            }
          }
          label347:
          for (paramAnonymousView = "";; paramAnonymousView = com.tencent.mm.plugin.sns.data.q.zw(u.a(u.this).field_snsId))
          {
            g.yhR.f(11989, new Object[] { Integer.valueOf(1), paramAnonymousView, Integer.valueOf(0) });
            new ap().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97880);
                u.this.refresh();
                AppMethodBeat.o(97880);
              }
            }, 500L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97881);
            return;
            an.a.a(u.a(u.this).field_userName, 5, "", u.a(u.this), u.b(u.this));
            break;
            u.a(u.this).field_likeFlag = 0;
            ag.dUe().M(u.a(u.this));
            an.a.azb(u.a(u.this).getSnsId());
            u.a(u.this, ag.dUe().Ai(u.a(u.this).field_snsId));
            e.ztz.dVJ().ejw = 4L;
            break label148;
          }
        }
      });
      this.zQR.zRc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97882);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          ad.d("MicroMsg.GalleryFooter", "comment cmd");
          if (u.a(u.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97882);
            return;
          }
          int i = u.a(u.this).zMC;
          localObject = new Intent();
          ((Intent)localObject).putExtra("sns_comment_localId", i);
          ((Intent)localObject).putExtra("sns_source", u.b(u.this));
          ((Intent)localObject).setClass(paramContext, SnsCommentUI.class);
          if (u.a(u.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = com.tencent.mm.plugin.sns.data.q.zw(u.a(u.this).field_snsId))
          {
            g.yhR.f(11989, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(0) });
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97882);
            return;
          }
        }
      });
      this.zQR.zRd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97883);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (u.a(u.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97883);
            return;
          }
          if (u.a(u.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = com.tencent.mm.plugin.sns.data.q.zw(u.a(u.this).field_snsId))
          {
            g.yhR.f(11989, new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(0) });
            int i = u.a(u.this).zMC;
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(paramContext, SnsCommentDetailUI.class);
            paramAnonymousView.putExtra("INTENT_TALKER", u.a(u.this).field_userName);
            paramAnonymousView.putExtra("INTENT_SNS_LOCAL_ID", com.tencent.mm.plugin.sns.storage.x.bn("sns_table_", i));
            paramAnonymousView.putExtra("INTENT_FROMGALLERY", true);
            ((MMActivity)paramContext).startActivityForResult(paramAnonymousView, 1);
            e.ztz.dVJ().ejo = 1L;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97883);
            return;
          }
        }
      });
      this.zQR.zQZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97884);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (u.c(u.this) != null) {
            u.c(u.this).dZs();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97884);
        }
      });
      this.zQR.zRl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97885);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (u.c(u.this) != null) {
            u.c(u.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97885);
        }
      });
      AppMethodBeat.o(97889);
      return;
      if (this.oIb == 3)
      {
        this.zQR.zRg.setVisibility(8);
        this.zQR.zRa.setVisibility(8);
        this.zQR.zRj.setVisibility(0);
      }
      else
      {
        this.zQR.zRg.setVisibility(0);
        this.zQR.zRa.setVisibility(8);
        this.zQR.zRj.setVisibility(8);
      }
    }
  }
  
  public final void aAE(String paramString)
  {
    AppMethodBeat.i(97892);
    setFooter(paramString);
    AppMethodBeat.o(97892);
  }
  
  public final int getFooterH()
  {
    AppMethodBeat.i(97893);
    if (this.zQR.zQY != null)
    {
      int i = this.zQR.zQY.getHeight();
      AppMethodBeat.o(97893);
      return i;
    }
    AppMethodBeat.o(97893);
    return 10;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(97890);
    if (this.oIb == -1)
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.zQS = ag.dUe().aAa(this.drH);
    if ((bt.isNullOrNil(this.drH)) || (this.zQS == null))
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.zQR.zRi.setVisibility(8);
    if (ak.ax(this.zQS.field_localPrivate, this.drv))
    {
      this.zQR.zRc.setVisibility(8);
      this.zQR.zRb.setVisibility(8);
      localObject = ak.v(this.zQS);
      if (localObject != null)
      {
        if (this.zQS.dYJ())
        {
          int i = ((SnsObject)localObject).CommentCount;
          if (i <= 0) {
            break label528;
          }
          this.zQR.zRf.setText(String.valueOf(i));
          this.zQR.zRf.setVisibility(0);
          label165:
          int j = ((SnsObject)localObject).LikeCount;
          if (j <= 0) {
            break label543;
          }
          this.zQR.gSC.setText(String.valueOf(j));
          this.zQR.gSC.setVisibility(0);
          label199:
          ad.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + j);
          if (this.zQS.field_likeFlag != 1) {
            break label558;
          }
          localObject = getResources().getString(2131763835);
          this.zQR.zRe.setText((CharSequence)localObject);
          this.zQR.gUF.setImageResource(2131690240);
          label278:
          e.ztz.dVJ().ejt = i;
          e.ztz.dVJ().eju = j;
        }
        if ((this.fFK.equals(this.zQS.field_userName)) || (!this.drv)) {
          break label599;
        }
        this.zQR.fRd.setVisibility(0);
        a.b.c(this.zQR.fRd, this.zQS.field_userName);
      }
    }
    for (;;)
    {
      if (this.zQS.dYl() != null) {
        break label614;
      }
      this.zQR.gUs.setVisibility(8);
      AppMethodBeat.o(97890);
      return;
      if (!this.zQS.dYJ())
      {
        this.zQR.zRk.setVisibility(0);
        this.zQR.zRg.setVisibility(0);
        this.zQR.zQY.setVisibility(8);
        this.zQR.zRd.setVisibility(8);
        this.zQR.zRc.setVisibility(8);
        this.zQR.zRb.setVisibility(8);
        break;
      }
      if (this.zQV) {
        this.zQR.zQY.setVisibility(0);
      }
      this.zQR.zRd.setVisibility(0);
      this.zQR.zRc.setVisibility(0);
      this.zQR.zRb.setVisibility(0);
      this.zQR.zRg.setVisibility(0);
      break;
      label528:
      this.zQR.zRf.setVisibility(8);
      break label165;
      label543:
      this.zQR.gSC.setVisibility(8);
      break label199;
      label558:
      localObject = getResources().getString(2131763836);
      this.zQR.zRe.setText(String.valueOf(localObject));
      this.zQR.gUF.setImageResource(2131690241);
      break label278;
      label599:
      this.zQR.fRd.setVisibility(8);
    }
    label614:
    Object localObject = this.zQS.dYl().HAQ;
    if ((localObject == null) || (((String)localObject).equals("")))
    {
      this.zQR.gUs.setText("");
      this.zQR.gUs.setVisibility(8);
      if (!ak.ax(this.zQS.field_localPrivate, this.drv)) {
        break label828;
      }
      this.zQR.zRh.setVisibility(0);
      this.zQR.gUs.setVisibility(0);
    }
    for (;;)
    {
      if ((this.drv) && (this.zQS.dYM()))
      {
        this.zQR.zRd.setVisibility(0);
        this.zQR.gUs.setVisibility(0);
        this.zQR.zRi.setVisibility(0);
      }
      AppMethodBeat.o(97890);
      return;
      this.zQR.gUs.setText(k.b(getContext(), (String)localObject + " ", this.zQR.gUs.getTextSize()));
      this.zQR.gUs.setVisibility(0);
      e.ztz.dVJ().ejl = 1L;
      break;
      label828:
      this.zQR.zRh.setVisibility(8);
    }
  }
  
  public final void setCallBack(a parama)
  {
    this.zQT = parama;
  }
  
  public final void setFooter(String paramString)
  {
    AppMethodBeat.i(97891);
    this.drH = paramString;
    refresh();
    AppMethodBeat.o(97891);
  }
  
  public final void setSnsSource(int paramInt)
  {
    this.drw = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(97888);
    this.oIb = paramInt;
    init(this.context);
    AppMethodBeat.o(97888);
  }
  
  public final void setVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(97886);
    if ((this.oIb == 2) || (this.oIb == 3))
    {
      super.setVisibility(paramInt);
      if (paramInt == 8) {}
      for (;;)
      {
        this.zQV = bool;
        AppMethodBeat.o(97886);
        return;
        bool = true;
      }
    }
    if ((this.zQS != null) && (!this.zQS.dYJ()))
    {
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 8)
    {
      this.zQR.zQY.setVisibility(8);
      this.zQV = false;
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 0)
    {
      this.zQR.zQY.setVisibility(0);
      this.zQV = true;
    }
    AppMethodBeat.o(97886);
  }
  
  public static abstract interface a
  {
    public abstract void dZs();
  }
  
  final class b
  {
    ImageView fRd;
    TextView gSC;
    ImageView gUF;
    TextView gUs;
    LinearLayout zQY;
    TextView zQZ;
    LinearLayout zRa;
    LinearLayout zRb;
    LinearLayout zRc;
    LinearLayout zRd;
    TextView zRe;
    TextView zRf;
    LinearLayout zRg;
    ImageView zRh;
    ImageView zRi;
    LinearLayout zRj;
    LinearLayout zRk;
    TextView zRl;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.u
 * JD-Core Version:    0.7.0.1
 */