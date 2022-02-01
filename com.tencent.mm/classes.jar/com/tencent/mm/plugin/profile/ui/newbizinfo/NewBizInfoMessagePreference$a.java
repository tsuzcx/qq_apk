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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.x;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.b;

public final class NewBizInfoMessagePreference$a
  extends RecyclerView.a<a>
{
  private static int vOH;
  private static final int vOI;
  private static int vOJ;
  private static int vOK;
  private static int vOL;
  private static int vOM;
  private static int vON;
  private com.tencent.mm.storage.ai contact;
  private MMActivity iMV;
  protected nd vOG;
  private int vOO;
  
  static
  {
    AppMethodBeat.i(27541);
    vOH = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 6);
    vOI = com.tencent.mm.sdk.platformtools.ai.getResources().getDimensionPixelSize(2131165572);
    vOJ = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 4);
    vOK = 13;
    vOL = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 1);
    vOM = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 8);
    vON = 13;
    AppMethodBeat.o(27541);
  }
  
  public final int getItemCount()
  {
    int i = 0;
    AppMethodBeat.i(27538);
    if ((this.vOG == null) || (this.vOG.EcV == null))
    {
      AppMethodBeat.o(27538);
      return 0;
    }
    int j = a.eC(this.vOG.EcV);
    if (this.vOG.EcW.Edp == 0) {
      i = 1;
    }
    AppMethodBeat.o(27538);
    return i + j;
  }
  
  public final class a
    extends RecyclerView.w
    implements View.OnClickListener
  {
    public ImageView fBA;
    public TextView fxS;
    public View jPT;
    public LinearLayout opd;
    public ImageView vLg;
    public com.tencent.mm.plugin.profile.ui.newbizinfo.b.b vOP;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(27536);
      this.vLg = ((ImageView)paramView.findViewById(2131302732));
      this.fBA = ((ImageView)paramView.findViewById(2131302731));
      this.fxS = ((TextView)paramView.findViewById(2131302735));
      this.opd = ((LinearLayout)paramView.findViewById(2131302728));
      this.jPT = paramView.findViewById(2131302730);
      paramView.setOnClickListener(this);
      AppMethodBeat.o(27536);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(27537);
      ac.i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", new Object[] { this.vOP.vPk });
      int i = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
      Intent localIntent = new Intent();
      String str = m.d(this.vOP.vPk, 126, i, 0);
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("geta8key_scene", 3);
      Object localObject = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("prePublishId");
      if (!bs.isNullOrNil((String)localObject))
      {
        localIntent.putExtra("KPublisherId", (String)localObject);
        localIntent.putExtra("prePublishId", (String)localObject);
        localIntent.putExtra("preUsername", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("preUsername"));
        localIntent.putExtra("preChatName", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("preChatName"));
      }
      for (;;)
      {
        localIntent.putExtra("preChatTYPE", NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("preChatTYPE", 0));
        i = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
        if ((this.vOP.type == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIP()))
        {
          localIntent.putExtra(e.b.HgX, 126);
          localIntent.putExtra(e.b.HgY, i);
          localIntent.putExtra("biz_video_session_id", v.getSessionId());
          localObject = new x();
          ((x)localObject).hkW = localIntent.getStringExtra("KPublisherId");
          ((x)localObject).ddo = NewBizInfoMessagePreference.a.b(NewBizInfoMessagePreference.a.this).field_username;
          ((x)localObject).hkV = NewBizInfoMessagePreference.a.b(NewBizInfoMessagePreference.a.this).aaR();
          ((x)localObject).hkX.url = str;
          ((x)localObject).hkX.title = this.vOP.title;
          ((x)localObject).hkX.hlf = this.vOP.vPp;
          ((x)localObject).hkX.hld = this.vOP.coverImgUrl;
          ((x)localObject).hkX.type = this.vOP.type;
          ((x)localObject).hkX.time = this.vOP.gIh;
          ((x)localObject).hkX.hlh = this.vOP.videoDuration;
          ((x)localObject).hkX.videoWidth = this.vOP.videoWidth;
          ((x)localObject).hkX.videoHeight = this.vOP.videoHeight;
          ((x)localObject).hkX.hhd = this.vOP.hhd;
          ((x)localObject).t(localIntent);
          ac.i("MicroMsg.NewBizInfoMessagePreference", "jump to native video");
          localObject = new int[2];
          paramView = paramView.findViewById(2131302732);
          if (paramView != null)
          {
            int j = paramView.getWidth();
            int k = paramView.getHeight();
            paramView.getLocationInWindow((int[])localObject);
            localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", localObject[0]).putExtra("img_gallery_top", localObject[1]);
          }
          localIntent.addFlags(268435456);
        }
        if ((!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(6)) || (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this), str, this.vOP.type, 126, i, localIntent))) {
          break;
        }
        ac.i("MicroMsg.NewBizInfoMessagePreference", "jump to TmplWebview");
        AppMethodBeat.o(27537);
        return;
        localIntent.putExtra("prePublishId", "brand_profile");
        localIntent.putExtra("KPublisherId", "brand_profile");
      }
      d.b(NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(27537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference.a
 * JD-Core Version:    0.7.0.1
 */