package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.x;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ob;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.b;

public class NewBizInfoMessagePreference
  extends Preference
{
  private MMActivity fNT;
  private View gZB;
  private RecyclerView gpr;
  private boolean qnX;
  private int state;
  private a xlF;
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27542);
    this.state = 1;
    this.qnX = false;
    this.fNT = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(27542);
  }
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27543);
    this.state = 1;
    this.qnX = false;
    this.fNT = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(27543);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27544);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.gpr = ((RecyclerView)paramView.findViewById(2131302734));
    this.gpr.setLayoutParams(new FrameLayout.LayoutParams(-1, localDisplayMetrics.heightPixels));
    this.gpr.setLayoutManager(new LinearLayoutManager());
    this.gpr.setHasFixedSize(true);
    this.gZB = paramView.findViewById(2131302722);
    this.qnX = true;
    if (this.qnX)
    {
      if (this.state != 1) {
        break label125;
      }
      this.gZB.setVisibility(0);
    }
    label125:
    do
    {
      this.gpr.setVisibility(8);
      AppMethodBeat.o(27544);
      return;
      if (this.state == 2)
      {
        this.gpr.setVisibility(8);
        this.gZB.setVisibility(0);
        AppMethodBeat.o(27544);
        return;
      }
    } while (this.state != 3);
    this.gZB.setVisibility(8);
    this.gpr.setVisibility(0);
    this.gpr.setAdapter(this.xlF);
    AppMethodBeat.o(27544);
  }
  
  public static final class a
    extends RecyclerView.a<a>
  {
    private static int xlH;
    private static final int xlI;
    private static int xlJ;
    private static int xlK;
    private static int xlL;
    private static int xlM;
    private static int xlN;
    private an contact;
    private MMActivity fNT;
    protected ob xlG;
    private int xlO;
    
    static
    {
      AppMethodBeat.i(27541);
      xlH = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 6);
      xlI = ak.getResources().getDimensionPixelSize(2131165572);
      xlJ = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 4);
      xlK = 13;
      xlL = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 1);
      xlM = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
      xlN = 13;
      AppMethodBeat.o(27541);
    }
    
    public final int getItemCount()
    {
      int i = 0;
      AppMethodBeat.i(27538);
      if ((this.xlG == null) || (this.xlG.Gby == null))
      {
        AppMethodBeat.o(27538);
        return 0;
      }
      int j = a.eX(this.xlG.Gby);
      if (this.xlG.Gbz.GbX == 0) {
        i = 1;
      }
      AppMethodBeat.o(27538);
      return i + j;
    }
    
    public final class a
      extends RecyclerView.w
      implements View.OnClickListener
    {
      public TextView fTl;
      public ImageView fWT;
      public View knu;
      public LinearLayout oZa;
      public ImageView xig;
      public com.tencent.mm.plugin.profile.ui.newbizinfo.b.b xlP;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(27536);
        this.xig = ((ImageView)paramView.findViewById(2131302732));
        this.fWT = ((ImageView)paramView.findViewById(2131302731));
        this.fTl = ((TextView)paramView.findViewById(2131302735));
        this.oZa = ((LinearLayout)paramView.findViewById(2131302728));
        this.knu = paramView.findViewById(2131302730);
        paramView.setOnClickListener(this);
        AppMethodBeat.o(27536);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(27537);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMessagePreference$messageItemAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        ae.i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", new Object[] { this.xlP.xmm });
        int i = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
        localObject1 = new Intent();
        String str = m.d(this.xlP.xmm, 126, i, 0);
        ((Intent)localObject1).putExtra("rawUrl", str);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        ((Intent)localObject1).putExtra("geta8key_scene", 3);
        Object localObject2 = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("prePublishId");
        if (!bu.isNullOrNil((String)localObject2))
        {
          ((Intent)localObject1).putExtra("KPublisherId", (String)localObject2);
          ((Intent)localObject1).putExtra("prePublishId", (String)localObject2);
          ((Intent)localObject1).putExtra("preUsername", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("preUsername"));
          ((Intent)localObject1).putExtra("preChatName", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("preChatName"));
          ((Intent)localObject1).putExtra("preChatTYPE", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("preChatTYPE", 0));
          i = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          if ((this.xlP.type == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOe()))
          {
            ((Intent)localObject1).putExtra(e.b.JoV, 126);
            ((Intent)localObject1).putExtra(e.b.JoW, i);
            ((Intent)localObject1).putExtra("biz_video_session_id", y.getSessionId());
            localObject2 = new x();
            ((x)localObject2).hFX = ((Intent)localObject1).getStringExtra("KPublisherId");
            ((x)localObject2).dpP = NewBizInfoMessagePreference.a.b(NewBizInfoMessagePreference.a.this).field_username;
            ((x)localObject2).hFW = NewBizInfoMessagePreference.a.b(NewBizInfoMessagePreference.a.this).adF();
            ((x)localObject2).hFY.url = str;
            ((x)localObject2).hFY.title = this.xlP.title;
            ((x)localObject2).hFY.hGg = this.xlP.xmr;
            ((x)localObject2).hFY.hGe = this.xlP.coverImgUrl;
            ((x)localObject2).hFY.type = this.xlP.type;
            ((x)localObject2).hFY.time = this.xlP.heF;
            ((x)localObject2).hFY.hGi = this.xlP.videoDuration;
            ((x)localObject2).hFY.videoWidth = this.xlP.videoWidth;
            ((x)localObject2).hFY.videoHeight = this.xlP.videoHeight;
            ((x)localObject2).hFY.hCa = this.xlP.hCa;
            ((x)localObject2).t((Intent)localObject1);
            ae.i("MicroMsg.NewBizInfoMessagePreference", "jump to native video");
            localObject2 = new int[2];
            paramView = paramView.findViewById(2131302732);
            if (paramView != null)
            {
              int j = paramView.getWidth();
              int k = paramView.getHeight();
              paramView.getLocationInWindow((int[])localObject2);
              ((Intent)localObject1).putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
            }
            ((Intent)localObject1).addFlags(268435456);
          }
          if ((!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(6)) || (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this), str, this.xlP.type, 126, i, (Intent)localObject1))) {
            break label730;
          }
          ae.i("MicroMsg.NewBizInfoMessagePreference", "jump to TmplWebview");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMessagePreference$messageItemAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27537);
          return;
          ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
          ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
          break;
          label730:
          d.b(NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference
 * JD-Core Version:    0.7.0.1
 */