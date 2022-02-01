package com.tencent.mm.plugin.sns.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sns.c.b;
import com.tencent.mm.plugin.sns.c.i.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMFragment;
import java.util.Iterator;
import java.util.List;

public class SnsAlbumUI
  extends MMFragment
  implements i.a, a.a
{
  private RecyclerView akA;
  private String kGt;
  private boolean xGf;
  private String xGk;
  private int xGm;
  private am.a xKM;
  private Runnable xLd;
  private LinearLayout xNO;
  private LinearLayout xNP;
  private a xNQ;
  private int xNR;
  
  public SnsAlbumUI()
  {
    AppMethodBeat.i(99882);
    this.akA = null;
    this.xNO = null;
    this.xNP = null;
    this.xNQ = null;
    this.xGk = null;
    this.kGt = null;
    this.xGm = 0;
    this.xGf = false;
    this.xKM = null;
    this.xNR = 0;
    this.xLd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99876);
        if (SnsAlbumUI.a(SnsAlbumUI.this) != null)
        {
          SnsAlbumUI.a(SnsAlbumUI.this).dBK();
          SnsAlbumUI.a(SnsAlbumUI.this).qr(true);
        }
        AppMethodBeat.o(99876);
      }
    };
    AppMethodBeat.o(99882);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(99886);
    if ((this.xGk.equals(this.kGt)) && (paramb.drK() != 0L))
    {
      g.afC();
      g.afB().afk().set(ae.a.FnI, Long.valueOf(paramb.drK()));
      this.xNQ.tn(paramb.drK());
    }
    if (paramb.drF()) {
      this.xNQ.aqK(paramb.drL());
    }
    label199:
    label202:
    for (;;)
    {
      if ((bt.isNullOrNil(this.xNQ.xNo)) && (this.xNQ != null))
      {
        this.xNQ.xNn = paramString;
        this.xNQ.dBK();
        this.xNQ.qr(true);
      }
      AppMethodBeat.o(99886);
      return;
      if (!paramb.drG()) {
        if (this.xNR >= 2) {
          break label199;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label202;
        }
        this.xNR += 1;
        this.xKM.b(10, this.kGt, true, this.xGm);
        break;
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(99887);
    af.czA().removeCallbacks(this.xLd);
    if ((this.xGk.equals(this.kGt)) && (paramb.drK() != 0L))
    {
      g.afC();
      g.afB().afk().set(ae.a.FnI, Long.valueOf(paramb.drK()));
      this.xNQ.tn(paramb.drK());
    }
    if (paramb.drF())
    {
      this.xNQ.aqK(paramb.drL());
      if (this.xNQ.getItemCount() > 0)
      {
        this.xNQ.ck(this.xNQ.getItemCount() - 1);
        AppMethodBeat.o(99887);
      }
    }
    else if (this.xNQ != null)
    {
      this.xNQ.xNp = paramb.drH();
      this.xNQ.xNn = paramString;
      this.xNQ.dBK();
      this.xNQ.qr(true);
    }
    AppMethodBeat.o(99887);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(99883);
    super.dealContentView(paramView);
    this.xKM = af.dtk();
    this.xGm = getActivity().getIntent().getIntExtra("sns_source", 0);
    this.kGt = getActivity().getIntent().getStringExtra("sns_userName");
    this.xGk = u.aqG();
    this.xNQ = new a(getContext(), this.kGt, this);
    this.xNQ.xNv = new c.a()
    {
      public final void bU(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(99878);
        ad.i("MicroMsg.SnsAlbumUI", "onClickItem localId=%s, mediaId=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        SnsAlbumUI.a(SnsAlbumUI.this, paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(99878);
      }
    };
    this.xNO = ((LinearLayout)paramView.findViewById(2131296604));
    this.xNP = ((LinearLayout)paramView.findViewById(2131296603));
    this.akA = ((RecyclerView)paramView.findViewById(2131296606));
    this.xNP.setOnClickListener(new SnsAlbumUI.4(this));
    this.akA.setAdapter(this.xNQ);
    paramView = this.akA;
    getContext();
    paramView.setLayoutManager(new LinearLayoutManager());
    this.akA.a(new d()
    {
      public final void Wc()
      {
        AppMethodBeat.i(99880);
        ad.d("MicroMsg.SnsAlbumUI", "onLoadMore");
        SnsAlbumUI.d(SnsAlbumUI.this).b(10, SnsAlbumUI.b(SnsAlbumUI.this), true, SnsAlbumUI.c(SnsAlbumUI.this));
        af.czA().postDelayed(SnsAlbumUI.e(SnsAlbumUI.this), 3000L);
        AppMethodBeat.o(99880);
      }
    });
    this.akA.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99881);
        if (SnsAlbumUI.f(SnsAlbumUI.this))
        {
          ad.w("MicroMsg.SnsAlbumUI", "too fast that it finish");
          AppMethodBeat.o(99881);
          return;
        }
        SnsAlbumUI.d(SnsAlbumUI.this).a(10, SnsAlbumUI.b(SnsAlbumUI.this), SnsAlbumUI.this);
        SnsAlbumUI.d(SnsAlbumUI.this).a(10, SnsAlbumUI.b(SnsAlbumUI.this), true, SnsAlbumUI.c(SnsAlbumUI.this));
        AppMethodBeat.o(99881);
      }
    }, 500L);
    AppMethodBeat.o(99883);
  }
  
  public final void fI(List<a.b> paramList)
  {
    AppMethodBeat.i(99889);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.akA.setVisibility(0);
      this.xNO.setVisibility(8);
      AppMethodBeat.o(99889);
      return;
    }
    this.akA.setVisibility(8);
    this.xNO.setVisibility(0);
    AppMethodBeat.o(99889);
  }
  
  public int getLayoutId()
  {
    return 2131495525;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99890);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.d("MicroMsg.SnsAlbumUI", "onActivityResult result=%s request=%s intent=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramIntent });
    if ((paramInt1 == 8) && (paramIntent != null) && (paramIntent.getParcelableExtra("sns_cmd_list") != null) && ((paramIntent.getParcelableExtra("sns_cmd_list") instanceof SnsCmdList))) {
      paramIntent = ((SnsCmdList)paramIntent.getParcelableExtra("sns_cmd_list")).wAX.iterator();
    }
    label133:
    label423:
    label426:
    for (;;)
    {
      a locala;
      if (paramIntent.hasNext())
      {
        int n = ((Integer)paramIntent.next()).intValue();
        locala = this.xNQ;
        Object localObject = this.akA;
        paramInt1 = 0;
        label201:
        int j;
        int i;
        label240:
        int k;
        int m;
        if (paramInt1 < locala.xNm.size())
        {
          Iterator localIterator = ((a.b)locala.xNm.get(paramInt1)).xNy.iterator();
          for (;;)
          {
            if (localIterator.hasNext()) {
              if (n == ((p)localIterator.next()).xiB)
              {
                paramInt2 = paramInt1;
                if (paramInt2 == -1) {
                  break label322;
                }
                localObject = ((RecyclerView)localObject).cj(paramInt2);
                if (!(localObject instanceof a.f)) {
                  break;
                }
                localObject = a.f.a((a.f)localObject);
                j = -1;
                i = 1;
                paramInt1 = 0;
                if (paramInt1 >= ((c)localObject).xNI.size()) {
                  break label337;
                }
                k = j;
                m = i;
                if (((a.d)((c)localObject).xNI.get(paramInt1)).dzf == n)
                {
                  if (j != -1) {
                    break label324;
                  }
                  k = paramInt1;
                  m = i;
                }
              }
            }
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          j = k;
          i = m;
          break label240;
          paramInt1 += 1;
          break label133;
          paramInt2 = -1;
          break label201;
          label322:
          break;
          label324:
          m = i + 1;
          k = j;
        }
        label337:
        if (j == -1) {
          break label423;
        }
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          ((c)localObject).xNI.remove(j);
          paramInt1 += 1;
        }
        paramInt1 = ((c)localObject).xNI.size();
        ((c)localObject).ar(j, i);
      }
      for (;;)
      {
        if (paramInt1 > 0) {
          break label426;
        }
        locala.xNm.remove(paramInt2);
        locala.cm(paramInt2);
        break;
        AppMethodBeat.o(99890);
        return;
        paramInt1 = 0;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99884);
    super.onCreate(paramBundle);
    setMMTitle(2131755251);
    setBackBtn(new SnsAlbumUI.2(this));
    AppMethodBeat.o(99884);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99888);
    super.onDestroy();
    this.xGf = true;
    af.czA().removeCallbacks(this.xLd);
    g.afC();
    if ((g.afz().aeI()) && (this.xKM != null)) {
      this.xKM.a(this, 10);
    }
    AppMethodBeat.o(99888);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(99885);
    ad.d("MicroMsg.SnsAlbumUI", "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    AppMethodBeat.o(99885);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI
 * JD-Core Version:    0.7.0.1
 */