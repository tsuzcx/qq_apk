package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.x;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.b;

public final class NewBizInfoMessagePreference$a
  extends RecyclerView.a<a>
{
  private static int BjI;
  private static final int BjJ;
  private static int BjK;
  private static int BjL;
  private static int BjM;
  private static int BjN;
  private static int BjO;
  protected ov BjH;
  private int BjP;
  private as contact;
  private MMActivity gte;
  
  static
  {
    AppMethodBeat.i(27541);
    BjI = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
    BjJ = MMApplicationContext.getResources().getDimensionPixelSize(2131165590);
    BjK = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    BjL = 13;
    BjM = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
    BjN = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    BjO = 13;
    AppMethodBeat.o(27541);
  }
  
  public final int getItemCount()
  {
    int i = 0;
    AppMethodBeat.i(27538);
    if ((this.BjH == null) || (this.BjH.KVw == null))
    {
      AppMethodBeat.o(27538);
      return 0;
    }
    int j = a.fT(this.BjH.KVw);
    if (this.BjH.KVx.KWa == 0) {
      i = 1;
    }
    AppMethodBeat.o(27538);
    return i + j;
  }
  
  public final class a
    extends RecyclerView.v
    implements View.OnClickListener
  {
    public ImageView Bga;
    public com.tencent.mm.plugin.profile.ui.newbizinfo.b.b BjQ;
    public ImageView gBZ;
    public TextView gyt;
    public View lrc;
    public LinearLayout qnZ;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(27536);
      this.Bga = ((ImageView)paramView.findViewById(2131305299));
      this.gBZ = ((ImageView)paramView.findViewById(2131305298));
      this.gyt = ((TextView)paramView.findViewById(2131305302));
      this.qnZ = ((LinearLayout)paramView.findViewById(2131305295));
      this.lrc = paramView.findViewById(2131305297);
      paramView.setOnClickListener(this);
      AppMethodBeat.o(27536);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(27537);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMessagePreference$messageItemAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      Log.i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", new Object[] { this.BjQ.Bko });
      int i = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
      localObject1 = new Intent();
      String str = m.d(this.BjQ.Bko, 126, i, 0);
      ((Intent)localObject1).putExtra("rawUrl", str);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      Object localObject2 = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("prePublishId");
      if (!Util.isNullOrNil((String)localObject2))
      {
        ((Intent)localObject1).putExtra("KPublisherId", (String)localObject2);
        ((Intent)localObject1).putExtra("prePublishId", (String)localObject2);
        ((Intent)localObject1).putExtra("preUsername", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("preUsername"));
        ((Intent)localObject1).putExtra("preChatName", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("preChatName"));
        ((Intent)localObject1).putExtra("preChatTYPE", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("preChatTYPE", 0));
        i = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
        if ((this.BjQ.type == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()))
        {
          ((Intent)localObject1).putExtra(e.b.OyQ, 126);
          ((Intent)localObject1).putExtra(e.b.OyR, i);
          ((Intent)localObject1).putExtra("biz_video_session_id", ab.getSessionId());
          localObject2 = new x();
          ((x)localObject2).iAh = ((Intent)localObject1).getStringExtra("KPublisherId");
          ((x)localObject2).dHc = NewBizInfoMessagePreference.a.b(NewBizInfoMessagePreference.a.this).field_username;
          ((x)localObject2).iAg = NewBizInfoMessagePreference.a.b(NewBizInfoMessagePreference.a.this).arI();
          ((x)localObject2).iAi.url = str;
          ((x)localObject2).iAi.title = this.BjQ.title;
          ((x)localObject2).iAi.iAq = this.BjQ.Bkt;
          ((x)localObject2).iAi.iAo = this.BjQ.coverImgUrl;
          ((x)localObject2).iAi.type = this.BjQ.type;
          ((x)localObject2).iAi.time = this.BjQ.hXs;
          ((x)localObject2).iAi.iAs = this.BjQ.videoDuration;
          ((x)localObject2).iAi.videoWidth = this.BjQ.videoWidth;
          ((x)localObject2).iAi.videoHeight = this.BjQ.videoHeight;
          ((x)localObject2).iAi.vid = this.BjQ.vid;
          ((x)localObject2).t((Intent)localObject1);
          Log.i("MicroMsg.NewBizInfoMessagePreference", "jump to native video");
          localObject2 = new int[2];
          paramView = paramView.findViewById(2131305299);
          if (paramView != null)
          {
            int j = paramView.getWidth();
            int k = paramView.getHeight();
            paramView.getLocationInWindow((int[])localObject2);
            ((Intent)localObject1).putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
          }
          ((Intent)localObject1).addFlags(268435456);
        }
        if ((!((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(6)) || (!((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this), str, this.BjQ.type, 126, i, (Intent)localObject1))) {
          break label730;
        }
        Log.i("MicroMsg.NewBizInfoMessagePreference", "jump to TmplWebview");
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
        c.b(NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference.a
 * JD-Core Version:    0.7.0.1
 */