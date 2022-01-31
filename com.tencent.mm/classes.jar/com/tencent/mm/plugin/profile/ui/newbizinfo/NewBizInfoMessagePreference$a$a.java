package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;

public final class NewBizInfoMessagePreference$a$a
  extends RecyclerView.v
  implements View.OnClickListener
{
  public TextView ehx;
  public View hrR;
  public ImageView iQd;
  public LinearLayout kFc;
  public ImageView pAE;
  public com.tencent.mm.plugin.profile.ui.newbizinfo.b.b pDU;
  
  public NewBizInfoMessagePreference$a$a(NewBizInfoMessagePreference.a parama, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(23883);
    this.pAE = ((ImageView)paramView.findViewById(2131823152));
    this.iQd = ((ImageView)paramView.findViewById(2131823153));
    this.ehx = ((TextView)paramView.findViewById(2131823154));
    this.kFc = ((LinearLayout)paramView.findViewById(2131823036));
    this.hrR = paramView.findViewById(2131823155);
    paramView.setOnClickListener(this);
    AppMethodBeat.o(23883);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = true;
    AppMethodBeat.i(23884);
    ab.i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", new Object[] { this.pDU.pEm });
    int i = NewBizInfoMessagePreference.a.a(this.pDV).getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
    Intent localIntent = new Intent();
    String str = l.c(this.pDU.pEm, 126, i, 0);
    localIntent.putExtra("rawUrl", str);
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("geta8key_scene", 3);
    Object localObject = NewBizInfoMessagePreference.a.a(this.pDV).getIntent().getStringExtra("prePublishId");
    if (!bo.isNullOrNil((String)localObject))
    {
      localIntent.putExtra("KPublisherId", (String)localObject);
      localIntent.putExtra("prePublishId", (String)localObject);
      localIntent.putExtra("preUsername", NewBizInfoMessagePreference.a.a(this.pDV).getIntent().getStringExtra("preUsername"));
      localIntent.putExtra("preChatName", NewBizInfoMessagePreference.a.a(this.pDV).getIntent().getStringExtra("preChatName"));
      localIntent.putExtra("preChatTYPE", NewBizInfoMessagePreference.a.a(this.pDV).getIntent().getIntExtra("preChatTYPE", 0));
      i = NewBizInfoMessagePreference.a.a(this.pDV).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      if ((this.pDU.type != 5) || (!((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).aWm())) {
        break label714;
      }
      localIntent.putExtra("biz_video_scene", 126);
      localIntent.putExtra("biz_video_subscene", i);
      localIntent.putExtra("biz_video_session_id", com.tencent.mm.storage.s.getSessionId());
      localObject = new com.tencent.mm.af.s();
      ((com.tencent.mm.af.s)localObject).fjC = localIntent.getStringExtra("KPublisherId");
      ((com.tencent.mm.af.s)localObject).cqX = NewBizInfoMessagePreference.a.b(this.pDV).field_username;
      ((com.tencent.mm.af.s)localObject).fjB = NewBizInfoMessagePreference.a.b(this.pDV).Oe();
      ((com.tencent.mm.af.s)localObject).fjD.url = str;
      ((com.tencent.mm.af.s)localObject).fjD.title = this.pDU.title;
      ((com.tencent.mm.af.s)localObject).fjD.fjL = this.pDU.pEr;
      ((com.tencent.mm.af.s)localObject).fjD.fjJ = this.pDU.hBL;
      ((com.tencent.mm.af.s)localObject).fjD.type = this.pDU.type;
      ((com.tencent.mm.af.s)localObject).fjD.time = this.pDU.oLs;
      ((com.tencent.mm.af.s)localObject).fjD.fjN = this.pDU.eVA;
      ((com.tencent.mm.af.s)localObject).fjD.videoWidth = this.pDU.videoWidth;
      ((com.tencent.mm.af.s)localObject).fjD.videoHeight = this.pDU.videoHeight;
      ((com.tencent.mm.af.s)localObject).fjD.fgl = this.pDU.fgl;
      ((com.tencent.mm.af.s)localObject).t(localIntent);
      ab.i("MicroMsg.NewBizInfoMessagePreference", "jump to native video");
      localObject = new int[2];
      paramView = paramView.findViewById(2131823152);
      if (paramView != null)
      {
        int j = paramView.getWidth();
        int k = paramView.getHeight();
        paramView.getLocationInWindow((int[])localObject);
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", localObject[0]).putExtra("img_gallery_top", localObject[1]);
      }
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      if ((((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rU(6)) && (((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a(NewBizInfoMessagePreference.a.a(this.pDV), str, this.pDU.type, bool, 126, i, localIntent)))
      {
        ab.i("MicroMsg.NewBizInfoMessagePreference", "jump to TmplWebview");
        AppMethodBeat.o(23884);
        return;
        localIntent.putExtra("prePublishId", "brand_profile");
        localIntent.putExtra("KPublisherId", "brand_profile");
        break;
      }
      d.b(NewBizInfoMessagePreference.a.a(this.pDV), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(23884);
      return;
      label714:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference.a.a
 * JD-Core Version:    0.7.0.1
 */