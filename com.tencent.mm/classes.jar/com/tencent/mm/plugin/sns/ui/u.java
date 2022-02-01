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
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public final class u
  extends LinearLayout
  implements x
{
  b AhY;
  private p AhZ;
  private a Aia;
  private View.OnTouchListener Aib;
  private boolean Aic;
  private Context context;
  private boolean dsB;
  private int dsC;
  private String dsN;
  private String fHO;
  private int oOD;
  
  public u(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(97887);
    this.AhY = new b();
    this.AhZ = null;
    this.oOD = 0;
    this.dsN = "";
    this.dsB = false;
    this.Aib = bu.fpL();
    this.fHO = "";
    this.Aic = true;
    this.oOD = paramInt;
    this.dsB = paramBoolean;
    init(paramContext);
    AppMethodBeat.o(97887);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97889);
    this.context = paramContext;
    if (this.oOD == -1)
    {
      AppMethodBeat.o(97889);
      return;
    }
    this.fHO = v.aAC();
    View localView = LayoutInflater.from(paramContext).inflate(2131495547, this, true);
    this.AhY.Aif = ((LinearLayout)localView.findViewById(2131305188));
    this.AhY.Ain = ((LinearLayout)localView.findViewById(2131306430));
    this.AhY.Aii = ((LinearLayout)localView.findViewById(2131301418));
    this.AhY.Aii.setOnTouchListener(this.Aib);
    this.AhY.gXo = ((ImageView)localView.findViewById(2131300985));
    this.AhY.Aij = ((LinearLayout)localView.findViewById(2131298526));
    this.AhY.Aij.setOnTouchListener(this.Aib);
    this.AhY.Aik = ((LinearLayout)localView.findViewById(2131298759));
    this.AhY.gVl = ((TextView)localView.findViewById(2131304953));
    this.AhY.Aim = ((TextView)localView.findViewById(2131304954));
    this.AhY.Ail = ((TextView)localView.findViewById(2131300683));
    this.AhY.Aig = ((TextView)localView.findViewById(2131304601));
    this.AhY.Aih = ((LinearLayout)localView.findViewById(2131304602));
    this.AhY.gXb = ((TextView)localView.findViewById(2131304968));
    this.AhY.Air = ((LinearLayout)localView.findViewById(2131301011));
    ((LinearLayout)localView.findViewById(2131301011)).getBackground().setAlpha(50);
    this.AhY.fTj = ((ImageView)localView.findViewById(2131297021));
    this.AhY.Aio = ((ImageView)localView.findViewById(2131301548));
    this.AhY.Aip = ((ImageView)localView.findViewById(2131299518));
    this.AhY.Aiq = ((LinearLayout)localView.findViewById(2131298959));
    this.AhY.Ais = ((TextView)localView.findViewById(2131298961));
    if (this.oOD == 2)
    {
      this.AhY.Ain.setVisibility(8);
      this.AhY.Aiq.setVisibility(8);
      this.AhY.Aih.setVisibility(0);
    }
    for (;;)
    {
      this.AhY.Aii.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97881);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (u.a(u.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97881);
            return;
          }
          if (u.a(u.this).field_likeFlag == 0) {
            if (u.a(u.this).ecn())
            {
              ao.a.a(u.a(u.this), 1, "", "", u.b(u.this));
              u.a(u.this).field_likeFlag = 1;
              ah.dXE().M(u.a(u.this));
              e.zKO.dZk().eld = 2L;
              label148:
              if (u.a(u.this).field_snsId != 0L) {
                break label347;
              }
            }
          }
          label347:
          for (paramAnonymousView = "";; paramAnonymousView = r.zV(u.a(u.this).field_snsId))
          {
            g.yxI.f(11989, new Object[] { Integer.valueOf(1), paramAnonymousView, Integer.valueOf(0) });
            new aq().postDelayed(new Runnable()
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
            ao.a.a(u.a(u.this).field_userName, 5, "", u.a(u.this), u.b(u.this));
            break;
            u.a(u.this).field_likeFlag = 0;
            ah.dXE().M(u.a(u.this));
            ao.a.aAs(u.a(u.this).getSnsId());
            u.a(u.this, ah.dXE().AG(u.a(u.this).field_snsId));
            e.zKO.dZk().eld = 4L;
            break label148;
          }
        }
      });
      this.AhY.Aij.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97882);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          ae.d("MicroMsg.GalleryFooter", "comment cmd");
          if (u.a(u.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97882);
            return;
          }
          int i = u.a(u.this).AdJ;
          localObject = new Intent();
          ((Intent)localObject).putExtra("sns_comment_localId", i);
          ((Intent)localObject).putExtra("sns_source", u.b(u.this));
          ((Intent)localObject).setClass(paramContext, SnsCommentUI.class);
          if (u.a(u.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = r.zV(u.a(u.this).field_snsId))
          {
            g.yxI.f(11989, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(0) });
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97882);
            return;
          }
        }
      });
      this.AhY.Aik.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97883);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (u.a(u.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97883);
            return;
          }
          if (u.a(u.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = r.zV(u.a(u.this).field_snsId))
          {
            g.yxI.f(11989, new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(0) });
            int i = u.a(u.this).AdJ;
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(paramContext, SnsCommentDetailUI.class);
            paramAnonymousView.putExtra("INTENT_TALKER", u.a(u.this).field_userName);
            paramAnonymousView.putExtra("INTENT_SNS_LOCAL_ID", com.tencent.mm.plugin.sns.storage.x.bo("sns_table_", i));
            paramAnonymousView.putExtra("INTENT_FROMGALLERY", true);
            ((MMActivity)paramContext).startActivityForResult(paramAnonymousView, 1);
            e.zKO.dZk().ekV = 1L;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97883);
            return;
          }
        }
      });
      this.AhY.Aig.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97884);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (u.c(u.this) != null) {
            u.c(u.this).ecX();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97884);
        }
      });
      this.AhY.Ais.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97885);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (u.c(u.this) != null) {
            u.c(u.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97885);
        }
      });
      AppMethodBeat.o(97889);
      return;
      if (this.oOD == 3)
      {
        this.AhY.Ain.setVisibility(8);
        this.AhY.Aih.setVisibility(8);
        this.AhY.Aiq.setVisibility(0);
      }
      else
      {
        this.AhY.Ain.setVisibility(0);
        this.AhY.Aih.setVisibility(8);
        this.AhY.Aiq.setVisibility(8);
      }
    }
  }
  
  public final void aBV(String paramString)
  {
    AppMethodBeat.i(97892);
    setFooter(paramString);
    AppMethodBeat.o(97892);
  }
  
  public final int getFooterH()
  {
    AppMethodBeat.i(97893);
    if (this.AhY.Aif != null)
    {
      int i = this.AhY.Aif.getHeight();
      AppMethodBeat.o(97893);
      return i;
    }
    AppMethodBeat.o(97893);
    return 10;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(97890);
    if (this.oOD == -1)
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.AhZ = ah.dXE().aBr(this.dsN);
    if ((bu.isNullOrNil(this.dsN)) || (this.AhZ == null))
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.AhY.Aip.setVisibility(8);
    if (al.aA(this.AhZ.field_localPrivate, this.dsB))
    {
      this.AhY.Aij.setVisibility(8);
      this.AhY.Aii.setVisibility(8);
      localObject = al.v(this.AhZ);
      if (localObject != null)
      {
        if (this.AhZ.ecn())
        {
          int i = ((SnsObject)localObject).CommentCount;
          if (i <= 0) {
            break label528;
          }
          this.AhY.Aim.setText(String.valueOf(i));
          this.AhY.Aim.setVisibility(0);
          label165:
          int j = ((SnsObject)localObject).LikeCount;
          if (j <= 0) {
            break label543;
          }
          this.AhY.gVl.setText(String.valueOf(j));
          this.AhY.gVl.setVisibility(0);
          label199:
          ae.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + j);
          if (this.AhZ.field_likeFlag != 1) {
            break label558;
          }
          localObject = getResources().getString(2131763835);
          this.AhY.Ail.setText((CharSequence)localObject);
          this.AhY.gXo.setImageResource(2131690240);
          label278:
          e.zKO.dZk().ela = i;
          e.zKO.dZk().elb = j;
        }
        if ((this.fHO.equals(this.AhZ.field_userName)) || (!this.dsB)) {
          break label599;
        }
        this.AhY.fTj.setVisibility(0);
        a.b.c(this.AhY.fTj, this.AhZ.field_userName);
      }
    }
    for (;;)
    {
      if (this.AhZ.ebP() != null) {
        break label614;
      }
      this.AhY.gXb.setVisibility(8);
      AppMethodBeat.o(97890);
      return;
      if (!this.AhZ.ecn())
      {
        this.AhY.Air.setVisibility(0);
        this.AhY.Ain.setVisibility(0);
        this.AhY.Aif.setVisibility(8);
        this.AhY.Aik.setVisibility(8);
        this.AhY.Aij.setVisibility(8);
        this.AhY.Aii.setVisibility(8);
        break;
      }
      if (this.Aic) {
        this.AhY.Aif.setVisibility(0);
      }
      this.AhY.Aik.setVisibility(0);
      this.AhY.Aij.setVisibility(0);
      this.AhY.Aii.setVisibility(0);
      this.AhY.Ain.setVisibility(0);
      break;
      label528:
      this.AhY.Aim.setVisibility(8);
      break label165;
      label543:
      this.AhY.gVl.setVisibility(8);
      break label199;
      label558:
      localObject = getResources().getString(2131763836);
      this.AhY.Ail.setText(String.valueOf(localObject));
      this.AhY.gXo.setImageResource(2131690241);
      break label278;
      label599:
      this.AhY.fTj.setVisibility(8);
    }
    label614:
    Object localObject = this.AhZ.ebP().HUD;
    if ((localObject == null) || (((String)localObject).equals("")))
    {
      this.AhY.gXb.setText("");
      this.AhY.gXb.setVisibility(8);
      if (!al.aA(this.AhZ.field_localPrivate, this.dsB)) {
        break label828;
      }
      this.AhY.Aio.setVisibility(0);
      this.AhY.gXb.setVisibility(0);
    }
    for (;;)
    {
      if ((this.dsB) && (this.AhZ.ecq()))
      {
        this.AhY.Aik.setVisibility(0);
        this.AhY.gXb.setVisibility(0);
        this.AhY.Aip.setVisibility(0);
      }
      AppMethodBeat.o(97890);
      return;
      this.AhY.gXb.setText(k.b(getContext(), (String)localObject + " ", this.AhY.gXb.getTextSize()));
      this.AhY.gXb.setVisibility(0);
      e.zKO.dZk().ekS = 1L;
      break;
      label828:
      this.AhY.Aio.setVisibility(8);
    }
  }
  
  public final void setCallBack(a parama)
  {
    this.Aia = parama;
  }
  
  public final void setFooter(String paramString)
  {
    AppMethodBeat.i(97891);
    this.dsN = paramString;
    refresh();
    AppMethodBeat.o(97891);
  }
  
  public final void setSnsSource(int paramInt)
  {
    this.dsC = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(97888);
    this.oOD = paramInt;
    init(this.context);
    AppMethodBeat.o(97888);
  }
  
  public final void setVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(97886);
    if ((this.oOD == 2) || (this.oOD == 3))
    {
      super.setVisibility(paramInt);
      if (paramInt == 8) {}
      for (;;)
      {
        this.Aic = bool;
        AppMethodBeat.o(97886);
        return;
        bool = true;
      }
    }
    if ((this.AhZ != null) && (!this.AhZ.ecn()))
    {
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 8)
    {
      this.AhY.Aif.setVisibility(8);
      this.Aic = false;
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 0)
    {
      this.AhY.Aif.setVisibility(0);
      this.Aic = true;
    }
    AppMethodBeat.o(97886);
  }
  
  public static abstract interface a
  {
    public abstract void ecX();
  }
  
  final class b
  {
    LinearLayout Aif;
    TextView Aig;
    LinearLayout Aih;
    LinearLayout Aii;
    LinearLayout Aij;
    LinearLayout Aik;
    TextView Ail;
    TextView Aim;
    LinearLayout Ain;
    ImageView Aio;
    ImageView Aip;
    LinearLayout Aiq;
    LinearLayout Air;
    TextView Ais;
    ImageView fTj;
    TextView gVl;
    TextView gXb;
    ImageView gXo;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.u
 * JD-Core Version:    0.7.0.1
 */