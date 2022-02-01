package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.x;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.b;

public final class NewBizInfoMessagePreference$a
  extends RecyclerView.a<a>
{
  private static int wVQ;
  private static final int wVR;
  private static int wVS;
  private static int wVT;
  private static int wVU;
  private static int wVV;
  private static int wVW;
  private am contact;
  private MMActivity fLP;
  protected nz wVP;
  private int wVX;
  
  static
  {
    AppMethodBeat.i(27541);
    wVQ = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 6);
    wVR = aj.getResources().getDimensionPixelSize(2131165572);
    wVS = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 4);
    wVT = 13;
    wVU = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 1);
    wVV = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8);
    wVW = 13;
    AppMethodBeat.o(27541);
  }
  
  public final int getItemCount()
  {
    int i = 0;
    AppMethodBeat.i(27538);
    if ((this.wVP == null) || (this.wVP.FIZ == null))
    {
      AppMethodBeat.o(27538);
      return 0;
    }
    int j = a.eP(this.wVP.FIZ);
    if (this.wVP.FJa.FJy == 0) {
      i = 1;
    }
    AppMethodBeat.o(27538);
    return i + j;
  }
  
  public final class a
    extends RecyclerView.w
    implements View.OnClickListener
  {
    public TextView fRf;
    public ImageView fUN;
    public View kke;
    public LinearLayout oSy;
    public ImageView wSp;
    public com.tencent.mm.plugin.profile.ui.newbizinfo.b.b wVY;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(27536);
      this.wSp = ((ImageView)paramView.findViewById(2131302732));
      this.fUN = ((ImageView)paramView.findViewById(2131302731));
      this.fRf = ((TextView)paramView.findViewById(2131302735));
      this.oSy = ((LinearLayout)paramView.findViewById(2131302728));
      this.kke = paramView.findViewById(2131302730);
      paramView.setOnClickListener(this);
      AppMethodBeat.o(27536);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(27537);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMessagePreference$messageItemAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      ad.i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", new Object[] { this.wVY.wWv });
      int i = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
      localObject1 = new Intent();
      String str = m.d(this.wVY.wWv, 126, i, 0);
      ((Intent)localObject1).putExtra("rawUrl", str);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      Object localObject2 = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("prePublishId");
      if (!bt.isNullOrNil((String)localObject2))
      {
        ((Intent)localObject1).putExtra("KPublisherId", (String)localObject2);
        ((Intent)localObject1).putExtra("prePublishId", (String)localObject2);
        ((Intent)localObject1).putExtra("preUsername", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("preUsername"));
        ((Intent)localObject1).putExtra("preChatName", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("preChatName"));
        ((Intent)localObject1).putExtra("preChatTYPE", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("preChatTYPE", 0));
        i = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
        if ((this.wVY.type == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNg()))
        {
          ((Intent)localObject1).putExtra(e.b.IUn, 126);
          ((Intent)localObject1).putExtra(e.b.IUo, i);
          ((Intent)localObject1).putExtra("biz_video_session_id", y.getSessionId());
          localObject2 = new x();
          ((x)localObject2).hDf = ((Intent)localObject1).getStringExtra("KPublisherId");
          ((x)localObject2).doK = NewBizInfoMessagePreference.a.b(NewBizInfoMessagePreference.a.this).field_username;
          ((x)localObject2).hDe = NewBizInfoMessagePreference.a.b(NewBizInfoMessagePreference.a.this).adu();
          ((x)localObject2).hDg.url = str;
          ((x)localObject2).hDg.title = this.wVY.title;
          ((x)localObject2).hDg.hDo = this.wVY.wWA;
          ((x)localObject2).hDg.hDm = this.wVY.coverImgUrl;
          ((x)localObject2).hDg.type = this.wVY.type;
          ((x)localObject2).hDg.time = this.wVY.hbR;
          ((x)localObject2).hDg.hDq = this.wVY.videoDuration;
          ((x)localObject2).hDg.videoWidth = this.wVY.videoWidth;
          ((x)localObject2).hDg.videoHeight = this.wVY.videoHeight;
          ((x)localObject2).hDg.hzm = this.wVY.hzm;
          ((x)localObject2).t((Intent)localObject1);
          ad.i("MicroMsg.NewBizInfoMessagePreference", "jump to native video");
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
        if ((!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(6)) || (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this), str, this.wVY.type, 126, i, (Intent)localObject1))) {
          break label730;
        }
        ad.i("MicroMsg.NewBizInfoMessagePreference", "jump to TmplWebview");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference.a
 * JD-Core Version:    0.7.0.1
 */