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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class x
  extends LinearLayout
  implements aa
{
  b KDT;
  private SnsInfo KDU;
  private a KDV;
  private View.OnTouchListener KDW;
  private boolean KDX;
  private Context context;
  private boolean fCB;
  private int fCC;
  private String fCM;
  private String iRj;
  private int viewType;
  
  public x(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(97887);
    this.KDT = new b();
    this.KDU = null;
    this.viewType = 0;
    this.fCM = "";
    this.fCB = false;
    this.KDW = Util.genLinearPressedListener();
    this.iRj = "";
    this.KDX = true;
    this.viewType = paramInt;
    this.fCB = paramBoolean;
    init(paramContext);
    AppMethodBeat.o(97887);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97889);
    this.context = paramContext;
    if (this.viewType == -1)
    {
      AppMethodBeat.o(97889);
      return;
    }
    this.iRj = z.bcZ();
    View localView = LayoutInflater.from(paramContext).inflate(i.g.sns_gallery_footer, this, true);
    this.KDT.KEa = ((LinearLayout)localView.findViewById(i.f.state_ll));
    this.KDT.KEi = ((LinearLayout)localView.findViewById(i.f.view_media));
    this.KDT.KEd = ((LinearLayout)localView.findViewById(i.f.like_ll));
    this.KDT.KEd.setOnTouchListener(this.KDW);
    this.KDT.kEG = ((ImageView)localView.findViewById(i.f.img_button_like));
    this.KDT.KEe = ((LinearLayout)localView.findViewById(i.f.comment_ll));
    this.KDT.KEe.setOnTouchListener(this.KDW);
    this.KDT.KEf = ((LinearLayout)localView.findViewById(i.f.content_info));
    this.KDT.kCB = ((TextView)localView.findViewById(i.f.sns_cm1_tv));
    this.KDT.KEh = ((TextView)localView.findViewById(i.f.sns_cm2_tv));
    this.KDT.KEg = ((TextView)localView.findViewById(i.f.has_like_tv));
    this.KDT.KEb = ((TextView)localView.findViewById(i.f.set_bg));
    this.KDT.KEc = ((LinearLayout)localView.findViewById(i.f.set_bg_ll));
    this.KDT.kEs = ((TextView)localView.findViewById(i.f.sns_desc));
    this.KDT.KEm = ((LinearLayout)localView.findViewById(i.f.info_line));
    ((LinearLayout)localView.findViewById(i.f.info_line)).getBackground().setAlpha(50);
    this.KDT.jiu = ((ImageView)localView.findViewById(i.f.avatar_with));
    this.KDT.KEj = ((ImageView)localView.findViewById(i.f.lock_icon));
    this.KDT.KEk = ((ImageView)localView.findViewById(i.f.error_icon));
    this.KDT.KEl = ((LinearLayout)localView.findViewById(i.f.del_ll));
    this.KDT.KEn = ((TextView)localView.findViewById(i.f.del_tv));
    if (this.viewType == 2)
    {
      this.KDT.KEi.setVisibility(8);
      this.KDT.KEl.setVisibility(8);
      this.KDT.KEc.setVisibility(0);
    }
    for (;;)
    {
      this.KDT.KEd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97881);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (x.a(x.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97881);
            return;
          }
          if (x.a(x.this).getLikeFlag() == 0) {
            if (x.a(x.this).isExtFlag())
            {
              ap.a.a(x.a(x.this), 1, "", "", x.b(x.this));
              x.a(x.this).setLikeFlag(1);
              aj.fOI().T(x.a(x.this));
              g.Kia.fQr().gOH = 2L;
              label148:
              if (x.a(x.this).field_snsId != 0L) {
                break label347;
              }
            }
          }
          label347:
          for (paramAnonymousView = "";; paramAnonymousView = t.Qu(x.a(x.this).field_snsId))
          {
            h.IzE.a(11989, new Object[] { Integer.valueOf(1), paramAnonymousView, Integer.valueOf(0) });
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97880);
                x.this.bfU();
                AppMethodBeat.o(97880);
              }
            }, 500L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97881);
            return;
            ap.a.a(x.a(x.this).field_userName, 5, "", x.a(x.this), x.b(x.this));
            break;
            x.a(x.this).setLikeFlag(0);
            aj.fOI().T(x.a(x.this));
            ap.a.bak(x.a(x.this).getSnsId());
            x.a(x.this, aj.fOI().Rd(x.a(x.this).field_snsId));
            g.Kia.fQr().gOH = 4L;
            break label148;
          }
        }
      });
      this.KDT.KEe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97882);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          Log.d("MicroMsg.GalleryFooter", "comment cmd");
          if (x.a(x.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97882);
            return;
          }
          int i = x.a(x.this).localid;
          localObject = new Intent();
          ((Intent)localObject).putExtra("sns_comment_localId", i);
          ((Intent)localObject).putExtra("sns_source", x.b(x.this));
          ((Intent)localObject).setClass(paramContext, SnsCommentUI.class);
          if (x.a(x.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = t.Qu(x.a(x.this).field_snsId))
          {
            h.IzE.a(11989, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(0) });
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97882);
            return;
          }
        }
      });
      this.KDT.KEf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97883);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (x.a(x.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97883);
            return;
          }
          if (x.a(x.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = t.Qu(x.a(x.this).field_snsId))
          {
            h.IzE.a(11989, new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(0) });
            int i = x.a(x.this).localid;
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(paramContext, SnsCommentDetailUI.class);
            paramAnonymousView.putExtra("INTENT_TALKER", x.a(x.this).getUserName());
            paramAnonymousView.putExtra("INTENT_SNS_LOCAL_ID", y.bt("sns_table_", i));
            paramAnonymousView.putExtra("INTENT_FROMGALLERY", true);
            ((MMActivity)paramContext).startActivityForResult(paramAnonymousView, 1);
            g.Kia.fQr().gOz = 1L;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97883);
            return;
          }
        }
      });
      this.KDT.KEb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97884);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/GalleryFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (x.c(x.this) != null) {
            x.c(x.this).fTf();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97884);
        }
      });
      this.KDT.KEn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97885);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/GalleryFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (x.c(x.this) != null) {
            x.c(x.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97885);
        }
      });
      AppMethodBeat.o(97889);
      return;
      if (this.viewType == 3)
      {
        this.KDT.KEi.setVisibility(8);
        this.KDT.KEc.setVisibility(8);
        this.KDT.KEl.setVisibility(0);
      }
      else
      {
        this.KDT.KEi.setVisibility(0);
        this.KDT.KEc.setVisibility(8);
        this.KDT.KEl.setVisibility(8);
      }
    }
  }
  
  public final void bbQ(String paramString)
  {
    AppMethodBeat.i(97892);
    setFooter(paramString);
    AppMethodBeat.o(97892);
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(97890);
    if (this.viewType == -1)
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.KDU = aj.fOI().bbl(this.fCM);
    if ((Util.isNullOrNil(this.fCM)) || (this.KDU == null))
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.KDT.KEk.setVisibility(8);
    if (an.aZ(this.KDU.getLocalPrivate(), this.fCB))
    {
      this.KDT.KEe.setVisibility(8);
      this.KDT.KEd.setVisibility(8);
      localObject = an.D(this.KDU);
      if (localObject != null)
      {
        if (this.KDU.isExtFlag())
        {
          int i = ((SnsObject)localObject).CommentCount;
          if (i <= 0) {
            break label570;
          }
          this.KDT.KEh.setText(String.valueOf(i));
          this.KDT.KEh.setVisibility(0);
          label168:
          int j = ((SnsObject)localObject).LikeCount;
          if (j <= 0) {
            break label585;
          }
          this.KDT.kCB.setText(String.valueOf(j));
          this.KDT.kCB.setVisibility(0);
          label202:
          this.KDT.KEf.setContentDescription(getResources().getString(i.j.sns_gallery_like_comment_count, new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
          Log.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + j);
          if (this.KDU.getLikeFlag() != 1) {
            break label600;
          }
          localObject = getResources().getString(i.j.sns_gallery_has_like);
          this.KDT.KEg.setText((CharSequence)localObject);
          this.KDT.kEG.setImageResource(i.i.friendactivity_comment_likeicon_havon);
          label319:
          g.Kia.fQr().gOE = i;
          g.Kia.fQr().gOF = j;
        }
        if ((this.iRj.equals(this.KDU.getUserName())) || (!this.fCB)) {
          break label641;
        }
        this.KDT.jiu.setVisibility(0);
        a.b.c(this.KDT.jiu, this.KDU.getUserName());
      }
    }
    for (;;)
    {
      if (this.KDU.getTimeLine() != null) {
        break label656;
      }
      this.KDT.kEs.setVisibility(8);
      AppMethodBeat.o(97890);
      return;
      if (!this.KDU.isExtFlag())
      {
        this.KDT.KEm.setVisibility(0);
        this.KDT.KEi.setVisibility(0);
        this.KDT.KEa.setVisibility(8);
        this.KDT.KEf.setVisibility(8);
        this.KDT.KEe.setVisibility(8);
        this.KDT.KEd.setVisibility(8);
        break;
      }
      if (this.KDX) {
        this.KDT.KEa.setVisibility(0);
      }
      this.KDT.KEf.setVisibility(0);
      this.KDT.KEe.setVisibility(0);
      this.KDT.KEd.setVisibility(0);
      this.KDT.KEi.setVisibility(0);
      break;
      label570:
      this.KDT.KEh.setVisibility(8);
      break label168;
      label585:
      this.KDT.kCB.setVisibility(8);
      break label202;
      label600:
      localObject = getResources().getString(i.j.sns_gallery_like);
      this.KDT.KEg.setText(String.valueOf(localObject));
      this.KDT.kEG.setImageResource(i.i.friendactivity_comment_likeicon_normal);
      break label319;
      label641:
      this.KDT.jiu.setVisibility(8);
    }
    label656:
    Object localObject = this.KDU.getTimeLine().ContentDesc;
    if ((localObject == null) || (((String)localObject).equals("")))
    {
      this.KDT.kEs.setText("");
      this.KDT.kEs.setVisibility(8);
      if (!an.aZ(this.KDU.getLocalPrivate(), this.fCB)) {
        break label871;
      }
      this.KDT.KEj.setVisibility(0);
      this.KDT.kEs.setVisibility(0);
    }
    for (;;)
    {
      if ((this.fCB) && (this.KDU.isDieItem()))
      {
        this.KDT.KEf.setVisibility(0);
        this.KDT.kEs.setVisibility(0);
        this.KDT.KEk.setVisibility(0);
      }
      AppMethodBeat.o(97890);
      return;
      this.KDT.kEs.setText(l.b(getContext(), (String)localObject + " ", this.KDT.kEs.getTextSize()));
      this.KDT.kEs.setVisibility(0);
      g.Kia.fQr().gOw = 1L;
      break;
      label871:
      this.KDT.KEj.setVisibility(8);
    }
  }
  
  public final int getFooterH()
  {
    AppMethodBeat.i(97893);
    if (this.KDT.KEa != null)
    {
      int i = this.KDT.KEa.getHeight();
      AppMethodBeat.o(97893);
      return i;
    }
    AppMethodBeat.o(97893);
    return 10;
  }
  
  public final void setCallBack(a parama)
  {
    this.KDV = parama;
  }
  
  public final void setFooter(String paramString)
  {
    AppMethodBeat.i(97891);
    this.fCM = paramString;
    bfU();
    AppMethodBeat.o(97891);
  }
  
  public final void setSnsSource(int paramInt)
  {
    this.fCC = paramInt;
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
        this.KDX = bool;
        AppMethodBeat.o(97886);
        return;
        bool = true;
      }
    }
    if ((this.KDU != null) && (!this.KDU.isExtFlag()))
    {
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 8)
    {
      this.KDT.KEa.setVisibility(8);
      this.KDX = false;
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 0)
    {
      this.KDT.KEa.setVisibility(0);
      this.KDX = true;
    }
    AppMethodBeat.o(97886);
  }
  
  public static abstract interface a
  {
    public abstract void fTf();
  }
  
  final class b
  {
    LinearLayout KEa;
    TextView KEb;
    LinearLayout KEc;
    LinearLayout KEd;
    LinearLayout KEe;
    LinearLayout KEf;
    TextView KEg;
    TextView KEh;
    LinearLayout KEi;
    ImageView KEj;
    ImageView KEk;
    LinearLayout KEl;
    LinearLayout KEm;
    TextView KEn;
    ImageView jiu;
    TextView kCB;
    ImageView kEG;
    TextView kEs;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.x
 * JD-Core Version:    0.7.0.1
 */