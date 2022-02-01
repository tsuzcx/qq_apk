package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.x;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.b;

public class NewBizInfoMessagePreference
  extends Preference
{
  private RecyclerView fPw;
  private MMActivity imP;
  private View lZo;
  private boolean paC;
  private int state;
  private a uFO;
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27542);
    this.state = 1;
    this.paC = false;
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27542);
  }
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27543);
    this.state = 1;
    this.paC = false;
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27543);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27544);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.fPw = ((RecyclerView)paramView.findViewById(2131302734));
    this.fPw.setLayoutParams(new FrameLayout.LayoutParams(-1, localDisplayMetrics.heightPixels));
    this.fPw.setLayoutManager(new LinearLayoutManager());
    this.fPw.setHasFixedSize(true);
    this.lZo = paramView.findViewById(2131302722);
    this.paC = true;
    if (this.paC)
    {
      if (this.state != 1) {
        break label125;
      }
      this.lZo.setVisibility(0);
    }
    label125:
    do
    {
      this.fPw.setVisibility(8);
      AppMethodBeat.o(27544);
      return;
      if (this.state == 2)
      {
        this.fPw.setVisibility(8);
        this.lZo.setVisibility(0);
        AppMethodBeat.o(27544);
        return;
      }
    } while (this.state != 3);
    this.lZo.setVisibility(8);
    this.fPw.setVisibility(0);
    this.fPw.setAdapter(this.uFO);
    AppMethodBeat.o(27544);
  }
  
  public static final class a
    extends RecyclerView.a<a>
  {
    private static int uFQ;
    private static final int uFR;
    private static int uFS;
    private static int uFT;
    private static int uFU;
    private static int uFV;
    private static int uFW;
    private af contact;
    private MMActivity imP;
    protected mw uFP;
    private int uFX;
    
    static
    {
      AppMethodBeat.i(27541);
      uFQ = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 6);
      uFR = aj.getResources().getDimensionPixelSize(2131165572);
      uFS = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 4);
      uFT = 13;
      uFU = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 1);
      uFV = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 8);
      uFW = 13;
      AppMethodBeat.o(27541);
    }
    
    public final int getItemCount()
    {
      int i = 0;
      AppMethodBeat.i(27538);
      if ((this.uFP == null) || (this.uFP.CKt == null))
      {
        AppMethodBeat.o(27538);
        return 0;
      }
      int j = a.ey(this.uFP.CKt);
      if (this.uFP.CKu.CKN == 0) {
        i = 1;
      }
      AppMethodBeat.o(27538);
      return i + j;
    }
    
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      public TextView ful;
      public ImageView fxT;
      public View jpE;
      public LinearLayout nMd;
      public ImageView uCn;
      public com.tencent.mm.plugin.profile.ui.newbizinfo.b.b uFY;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(27536);
        this.uCn = ((ImageView)paramView.findViewById(2131302732));
        this.fxT = ((ImageView)paramView.findViewById(2131302731));
        this.ful = ((TextView)paramView.findViewById(2131302735));
        this.nMd = ((LinearLayout)paramView.findViewById(2131302728));
        this.jpE = paramView.findViewById(2131302730);
        paramView.setOnClickListener(this);
        AppMethodBeat.o(27536);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(27537);
        ad.i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", new Object[] { this.uFY.uGt });
        int i = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
        Intent localIntent = new Intent();
        String str = m.d(this.uFY.uGt, 126, i, 0);
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("vertical_scroll", true);
        localIntent.putExtra("geta8key_scene", 3);
        Object localObject = NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this).getIntent().getStringExtra("prePublishId");
        if (!bt.isNullOrNil((String)localObject))
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
          if ((this.uFY.type == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBR()))
          {
            localIntent.putExtra(e.b.FHP, 126);
            localIntent.putExtra(e.b.FHQ, i);
            localIntent.putExtra("biz_video_session_id", u.getSessionId());
            localObject = new x();
            ((x)localObject).gKw = localIntent.getStringExtra("KPublisherId");
            ((x)localObject).dfT = NewBizInfoMessagePreference.a.b(NewBizInfoMessagePreference.a.this).field_username;
            ((x)localObject).gKv = NewBizInfoMessagePreference.a.b(NewBizInfoMessagePreference.a.this).ZW();
            ((x)localObject).gKx.url = str;
            ((x)localObject).gKx.title = this.uFY.title;
            ((x)localObject).gKx.gKF = this.uFY.uGy;
            ((x)localObject).gKx.gKD = this.uFY.coverImgUrl;
            ((x)localObject).gKx.type = this.uFY.type;
            ((x)localObject).gKx.time = this.uFY.tGD;
            ((x)localObject).gKx.gKH = this.uFY.videoDuration;
            ((x)localObject).gKx.videoWidth = this.uFY.videoWidth;
            ((x)localObject).gKx.videoHeight = this.uFY.videoHeight;
            ((x)localObject).gKx.gGC = this.uFY.gGC;
            ((x)localObject).t(localIntent);
            ad.i("MicroMsg.NewBizInfoMessagePreference", "jump to native video");
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
          if ((!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(6)) || (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(NewBizInfoMessagePreference.a.a(NewBizInfoMessagePreference.a.this), str, this.uFY.type, 126, i, localIntent))) {
            break;
          }
          ad.i("MicroMsg.NewBizInfoMessagePreference", "jump to TmplWebview");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference
 * JD-Core Version:    0.7.0.1
 */