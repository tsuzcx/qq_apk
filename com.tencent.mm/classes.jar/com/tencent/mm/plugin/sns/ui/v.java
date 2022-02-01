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
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class v
  extends LinearLayout
  implements y
{
  b EqB;
  private SnsInfo EqC;
  private a EqD;
  private View.OnTouchListener EqE;
  private boolean EqF;
  private Context context;
  private boolean dJM;
  private int dJN;
  private String dJX;
  private String gna;
  private int qcr;
  
  public v(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(97887);
    this.EqB = new b();
    this.EqC = null;
    this.qcr = 0;
    this.dJX = "";
    this.dJM = false;
    this.EqE = Util.genLinearPressedListener();
    this.gna = "";
    this.EqF = true;
    this.qcr = paramInt;
    this.dJM = paramBoolean;
    init(paramContext);
    AppMethodBeat.o(97887);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(97889);
    this.context = paramContext;
    if (this.qcr == -1)
    {
      AppMethodBeat.o(97889);
      return;
    }
    this.gna = z.aTY();
    View localView = LayoutInflater.from(paramContext).inflate(2131496439, this, true);
    this.EqB.EqI = ((LinearLayout)localView.findViewById(2131308379));
    this.EqB.EqQ = ((LinearLayout)localView.findViewById(2131309862));
    this.EqB.EqL = ((LinearLayout)localView.findViewById(2131303188));
    this.EqB.EqL.setOnTouchListener(this.EqE);
    this.EqB.hQj = ((ImageView)localView.findViewById(2131302623));
    this.EqB.EqM = ((LinearLayout)localView.findViewById(2131298954));
    this.EqB.EqM.setOnTouchListener(this.EqE);
    this.EqB.EqN = ((LinearLayout)localView.findViewById(2131299203));
    this.EqB.hOf = ((TextView)localView.findViewById(2131308093));
    this.EqB.EqP = ((TextView)localView.findViewById(2131308094));
    this.EqB.EqO = ((TextView)localView.findViewById(2131302251));
    this.EqB.EqJ = ((TextView)localView.findViewById(2131307648));
    this.EqB.EqK = ((LinearLayout)localView.findViewById(2131307649));
    this.EqB.hPW = ((TextView)localView.findViewById(2131308108));
    this.EqB.EqU = ((LinearLayout)localView.findViewById(2131302655));
    ((LinearLayout)localView.findViewById(2131302655)).getBackground().setAlpha(50);
    this.EqB.gyr = ((ImageView)localView.findViewById(2131297150));
    this.EqB.EqR = ((ImageView)localView.findViewById(2131303761));
    this.EqB.EqS = ((ImageView)localView.findViewById(2131300156));
    this.EqB.EqT = ((LinearLayout)localView.findViewById(2131299453));
    this.EqB.EqV = ((TextView)localView.findViewById(2131299455));
    if (this.qcr == 2)
    {
      this.EqB.EqQ.setVisibility(8);
      this.EqB.EqT.setVisibility(8);
      this.EqB.EqK.setVisibility(0);
    }
    for (;;)
    {
      this.EqB.EqL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97881);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (v.a(v.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97881);
            return;
          }
          if (v.a(v.this).getLikeFlag() == 0) {
            if (v.a(v.this).isExtFlag())
            {
              aq.a.a(v.a(v.this), 1, "", "", v.b(v.this));
              v.a(v.this).setLikeFlag(1);
              aj.faO().S(v.a(v.this));
              e.DUQ.fcy().eOB = 2L;
              label148:
              if (v.a(v.this).field_snsId != 0L) {
                break label347;
              }
            }
          }
          label347:
          for (paramAnonymousView = "";; paramAnonymousView = r.Jb(v.a(v.this).field_snsId))
          {
            h.CyF.a(11989, new Object[] { Integer.valueOf(1), paramAnonymousView, Integer.valueOf(0) });
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97880);
                v.this.refresh();
                AppMethodBeat.o(97880);
              }
            }, 500L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97881);
            return;
            aq.a.a(v.a(v.this).field_userName, 5, "", v.a(v.this), v.b(v.this));
            break;
            v.a(v.this).setLikeFlag(0);
            aj.faO().S(v.a(v.this));
            aq.a.aPo(v.a(v.this).getSnsId());
            v.a(v.this, aj.faO().JJ(v.a(v.this).field_snsId));
            e.DUQ.fcy().eOB = 4L;
            break label148;
          }
        }
      });
      this.EqB.EqM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97882);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          Log.d("MicroMsg.GalleryFooter", "comment cmd");
          if (v.a(v.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97882);
            return;
          }
          int i = v.a(v.this).localid;
          localObject = new Intent();
          ((Intent)localObject).putExtra("sns_comment_localId", i);
          ((Intent)localObject).putExtra("sns_source", v.b(v.this));
          ((Intent)localObject).setClass(paramContext, SnsCommentUI.class);
          if (v.a(v.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = r.Jb(v.a(v.this).field_snsId))
          {
            h.CyF.a(11989, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(0) });
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97882);
            return;
          }
        }
      });
      this.EqB.EqN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97883);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (v.a(v.this) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97883);
            return;
          }
          if (v.a(v.this).field_snsId == 0L) {}
          for (paramAnonymousView = "";; paramAnonymousView = r.Jb(v.a(v.this).field_snsId))
          {
            h.CyF.a(11989, new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(0) });
            int i = v.a(v.this).localid;
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(paramContext, SnsCommentDetailUI.class);
            paramAnonymousView.putExtra("INTENT_TALKER", v.a(v.this).getUserName());
            paramAnonymousView.putExtra("INTENT_SNS_LOCAL_ID", com.tencent.mm.plugin.sns.storage.y.bq("sns_table_", i));
            paramAnonymousView.putExtra("INTENT_FROMGALLERY", true);
            ((MMActivity)paramContext).startActivityForResult(paramAnonymousView, 1);
            e.DUQ.fcy().eOt = 1L;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97883);
            return;
          }
        }
      });
      this.EqB.EqJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97884);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (v.c(v.this) != null) {
            v.c(v.this).ffk();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97884);
        }
      });
      this.EqB.EqV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97885);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (v.c(v.this) != null) {
            v.c(v.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97885);
        }
      });
      AppMethodBeat.o(97889);
      return;
      if (this.qcr == 3)
      {
        this.EqB.EqQ.setVisibility(8);
        this.EqB.EqK.setVisibility(8);
        this.EqB.EqT.setVisibility(0);
      }
      else
      {
        this.EqB.EqQ.setVisibility(0);
        this.EqB.EqK.setVisibility(8);
        this.EqB.EqT.setVisibility(8);
      }
    }
  }
  
  public final void aQQ(String paramString)
  {
    AppMethodBeat.i(97892);
    setFooter(paramString);
    AppMethodBeat.o(97892);
  }
  
  public final int getFooterH()
  {
    AppMethodBeat.i(97893);
    if (this.EqB.EqI != null)
    {
      int i = this.EqB.EqI.getHeight();
      AppMethodBeat.o(97893);
      return i;
    }
    AppMethodBeat.o(97893);
    return 10;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(97890);
    if (this.qcr == -1)
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.EqC = aj.faO().aQm(this.dJX);
    if ((Util.isNullOrNil(this.dJX)) || (this.EqC == null))
    {
      AppMethodBeat.o(97890);
      return;
    }
    this.EqB.EqS.setVisibility(8);
    if (an.aQ(this.EqC.getLocalPrivate(), this.dJM))
    {
      this.EqB.EqM.setVisibility(8);
      this.EqB.EqL.setVisibility(8);
      localObject = an.C(this.EqC);
      if (localObject != null)
      {
        if (this.EqC.isExtFlag())
        {
          int i = ((SnsObject)localObject).CommentCount;
          if (i <= 0) {
            break label528;
          }
          this.EqB.EqP.setText(String.valueOf(i));
          this.EqB.EqP.setVisibility(0);
          label165:
          int j = ((SnsObject)localObject).LikeCount;
          if (j <= 0) {
            break label543;
          }
          this.EqB.hOf.setText(String.valueOf(j));
          this.EqB.hOf.setVisibility(0);
          label199:
          Log.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + j);
          if (this.EqC.getLikeFlag() != 1) {
            break label558;
          }
          localObject = getResources().getString(2131766061);
          this.EqB.EqO.setText((CharSequence)localObject);
          this.EqB.hQj.setImageResource(2131690336);
          label278:
          e.DUQ.fcy().eOy = i;
          e.DUQ.fcy().eOz = j;
        }
        if ((this.gna.equals(this.EqC.getUserName())) || (!this.dJM)) {
          break label599;
        }
        this.EqB.gyr.setVisibility(0);
        a.b.c(this.EqB.gyr, this.EqC.getUserName());
      }
    }
    for (;;)
    {
      if (this.EqC.getTimeLine() != null) {
        break label614;
      }
      this.EqB.hPW.setVisibility(8);
      AppMethodBeat.o(97890);
      return;
      if (!this.EqC.isExtFlag())
      {
        this.EqB.EqU.setVisibility(0);
        this.EqB.EqQ.setVisibility(0);
        this.EqB.EqI.setVisibility(8);
        this.EqB.EqN.setVisibility(8);
        this.EqB.EqM.setVisibility(8);
        this.EqB.EqL.setVisibility(8);
        break;
      }
      if (this.EqF) {
        this.EqB.EqI.setVisibility(0);
      }
      this.EqB.EqN.setVisibility(0);
      this.EqB.EqM.setVisibility(0);
      this.EqB.EqL.setVisibility(0);
      this.EqB.EqQ.setVisibility(0);
      break;
      label528:
      this.EqB.EqP.setVisibility(8);
      break label165;
      label543:
      this.EqB.hOf.setVisibility(8);
      break label199;
      label558:
      localObject = getResources().getString(2131766062);
      this.EqB.EqO.setText(String.valueOf(localObject));
      this.EqB.hQj.setImageResource(2131690337);
      break label278;
      label599:
      this.EqB.gyr.setVisibility(8);
    }
    label614:
    Object localObject = this.EqC.getTimeLine().ContentDesc;
    if ((localObject == null) || (((String)localObject).equals("")))
    {
      this.EqB.hPW.setText("");
      this.EqB.hPW.setVisibility(8);
      if (!an.aQ(this.EqC.getLocalPrivate(), this.dJM)) {
        break label828;
      }
      this.EqB.EqR.setVisibility(0);
      this.EqB.hPW.setVisibility(0);
    }
    for (;;)
    {
      if ((this.dJM) && (this.EqC.isDieItem()))
      {
        this.EqB.EqN.setVisibility(0);
        this.EqB.hPW.setVisibility(0);
        this.EqB.EqS.setVisibility(0);
      }
      AppMethodBeat.o(97890);
      return;
      this.EqB.hPW.setText(l.b(getContext(), (String)localObject + " ", this.EqB.hPW.getTextSize()));
      this.EqB.hPW.setVisibility(0);
      e.DUQ.fcy().eOq = 1L;
      break;
      label828:
      this.EqB.EqR.setVisibility(8);
    }
  }
  
  public final void setCallBack(a parama)
  {
    this.EqD = parama;
  }
  
  public final void setFooter(String paramString)
  {
    AppMethodBeat.i(97891);
    this.dJX = paramString;
    refresh();
    AppMethodBeat.o(97891);
  }
  
  public final void setSnsSource(int paramInt)
  {
    this.dJN = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(97888);
    this.qcr = paramInt;
    init(this.context);
    AppMethodBeat.o(97888);
  }
  
  public final void setVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(97886);
    if ((this.qcr == 2) || (this.qcr == 3))
    {
      super.setVisibility(paramInt);
      if (paramInt == 8) {}
      for (;;)
      {
        this.EqF = bool;
        AppMethodBeat.o(97886);
        return;
        bool = true;
      }
    }
    if ((this.EqC != null) && (!this.EqC.isExtFlag()))
    {
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 8)
    {
      this.EqB.EqI.setVisibility(8);
      this.EqF = false;
      AppMethodBeat.o(97886);
      return;
    }
    if (paramInt == 0)
    {
      this.EqB.EqI.setVisibility(0);
      this.EqF = true;
    }
    AppMethodBeat.o(97886);
  }
  
  public static abstract interface a
  {
    public abstract void ffk();
  }
  
  final class b
  {
    LinearLayout EqI;
    TextView EqJ;
    LinearLayout EqK;
    LinearLayout EqL;
    LinearLayout EqM;
    LinearLayout EqN;
    TextView EqO;
    TextView EqP;
    LinearLayout EqQ;
    ImageView EqR;
    ImageView EqS;
    LinearLayout EqT;
    LinearLayout EqU;
    TextView EqV;
    ImageView gyr;
    TextView hOf;
    TextView hPW;
    ImageView hQj;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.v
 * JD-Core Version:    0.7.0.1
 */