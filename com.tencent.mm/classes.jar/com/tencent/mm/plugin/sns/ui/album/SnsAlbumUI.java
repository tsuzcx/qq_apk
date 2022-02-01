package com.tencent.mm.plugin.sns.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsUserUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMFragment;
import java.util.Iterator;
import java.util.List;

public class SnsAlbumUI
  extends MMFragment
  implements i.a, a.a
{
  private int AkB;
  private boolean Aku;
  private String Akz;
  private Runnable ApD;
  private an.a Apm;
  private LinearLayout Asv;
  private LinearLayout Asw;
  private a Asx;
  private int Asy;
  private RecyclerView anl;
  private String lEN;
  
  public SnsAlbumUI()
  {
    AppMethodBeat.i(99882);
    this.anl = null;
    this.Asv = null;
    this.Asw = null;
    this.Asx = null;
    this.Akz = null;
    this.lEN = null;
    this.AkB = 0;
    this.Aku = false;
    this.Apm = null;
    this.Asy = 0;
    this.ApD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99876);
        if (SnsAlbumUI.a(SnsAlbumUI.this) != null)
        {
          SnsAlbumUI.a(SnsAlbumUI.this).ecx();
          SnsAlbumUI.a(SnsAlbumUI.this).rT(true);
        }
        AppMethodBeat.o(99876);
      }
    };
    AppMethodBeat.o(99882);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99886);
    if ((this.Akz.equals(this.lEN)) && (paramb.dSw() != 0L))
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IxP, Long.valueOf(paramb.dSw()));
      this.Asx.Ao(paramb.dSw());
    }
    if (paramb.dSr()) {
      this.Asx.aBa(paramb.dSx());
    }
    label199:
    label202:
    for (;;)
    {
      if ((bt.isNullOrNil(this.Asx.ArV)) && (this.Asx != null))
      {
        this.Asx.ArU = paramString;
        this.Asx.ecx();
        this.Asx.rT(true);
      }
      AppMethodBeat.o(99886);
      return;
      if (!paramb.dSs()) {
        if (this.Asy >= 2) {
          break label199;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label202;
        }
        this.Asy += 1;
        this.Apm.b(10, this.lEN, true, this.AkB);
        break;
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99887);
    ag.cVf().removeCallbacks(this.ApD);
    if ((this.Akz.equals(this.lEN)) && (paramb.dSw() != 0L))
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IxP, Long.valueOf(paramb.dSw()));
      this.Asx.Ao(paramb.dSw());
    }
    if (paramb.dSr())
    {
      this.Asx.aBa(paramb.dSx());
      if (this.Asx.getItemCount() > 0)
      {
        this.Asx.cj(this.Asx.getItemCount() - 1);
        AppMethodBeat.o(99887);
      }
    }
    else if (this.Asx != null)
    {
      this.Asx.ArW = paramb.dSt();
      this.Asx.ArU = paramString;
      this.Asx.ecx();
      this.Asx.rT(true);
    }
    AppMethodBeat.o(99887);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(99883);
    super.dealContentView(paramView);
    this.Apm = ag.dTU();
    this.AkB = getActivity().getIntent().getIntExtra("sns_source", 0);
    this.lEN = getActivity().getIntent().getStringExtra("sns_userName");
    this.Akz = u.aAm();
    this.Asx = new a(getContext(), this.lEN, this);
    this.Asx.Asc = new c.a()
    {
      public final void cf(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(99878);
        ad.i("MicroMsg.SnsAlbumUI", "onClickItem localId=%s, mediaId=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        SnsAlbumUI.a(SnsAlbumUI.this, paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(99878);
      }
    };
    this.Asv = ((LinearLayout)paramView.findViewById(2131296604));
    this.Asw = ((LinearLayout)paramView.findViewById(2131296603));
    this.anl = ((RecyclerView)paramView.findViewById(2131296606));
    this.Asw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99879);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = new Intent(SnsAlbumUI.this.getActivity(), SnsUserUI.class);
        ((Intent)localObject).putExtra("sns_rpt_scene", 21);
        ((Intent)localObject).putExtra("sns_userName", SnsAlbumUI.b(SnsAlbumUI.this));
        paramAnonymousView = SnsAlbumUI.this.getActivity();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99879);
      }
    });
    this.anl.setAdapter(this.Asx);
    paramView = this.anl;
    getContext();
    paramView.setLayoutManager(new LinearLayoutManager());
    this.anl.a(new d()
    {
      public final void Zt()
      {
        AppMethodBeat.i(99880);
        ad.d("MicroMsg.SnsAlbumUI", "onLoadMore");
        SnsAlbumUI.d(SnsAlbumUI.this).b(10, SnsAlbumUI.b(SnsAlbumUI.this), true, SnsAlbumUI.c(SnsAlbumUI.this));
        ag.cVf().postDelayed(SnsAlbumUI.e(SnsAlbumUI.this), 3000L);
        AppMethodBeat.o(99880);
      }
    });
    this.anl.postDelayed(new Runnable()
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
  
  public final void gb(List<a.b> paramList)
  {
    AppMethodBeat.i(99889);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.anl.setVisibility(0);
      this.Asv.setVisibility(8);
      AppMethodBeat.o(99889);
      return;
    }
    this.anl.setVisibility(8);
    this.Asv.setVisibility(0);
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
      paramIntent = ((SnsCmdList)paramIntent.getParcelableExtra("sns_cmd_list")).zdl.iterator();
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
        locala = this.Asx;
        Object localObject = this.anl;
        paramInt1 = 0;
        label201:
        int j;
        int i;
        label240:
        int k;
        int m;
        if (paramInt1 < locala.ArT.size())
        {
          Iterator localIterator = ((a.b)locala.ArT.get(paramInt1)).Asf.iterator();
          for (;;)
          {
            if (localIterator.hasNext()) {
              if (n == ((p)localIterator.next()).zMC)
              {
                paramInt2 = paramInt1;
                if (paramInt2 == -1) {
                  break label322;
                }
                localObject = ((RecyclerView)localObject).ci(paramInt2);
                if (!(localObject instanceof a.f)) {
                  break;
                }
                localObject = a.f.a((a.f)localObject);
                j = -1;
                i = 1;
                paramInt1 = 0;
                if (paramInt1 >= ((c)localObject).Asp.size()) {
                  break label337;
                }
                k = j;
                m = i;
                if (((a.d)((c)localObject).Asp.get(paramInt1)).dJd == n)
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
          ((c)localObject).Asp.remove(j);
          paramInt1 += 1;
        }
        paramInt1 = ((c)localObject).Asp.size();
        ((c)localObject).as(j, i);
      }
      for (;;)
      {
        if (paramInt1 > 0) {
          break label426;
        }
        locala.ArT.remove(paramInt2);
        locala.cl(paramInt2);
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99877);
        if (SnsAlbumUI.this.getActivity() != null) {
          SnsAlbumUI.this.getActivity().finish();
        }
        AppMethodBeat.o(99877);
        return true;
      }
    });
    AppMethodBeat.o(99884);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99888);
    super.onDestroy();
    this.Aku = true;
    ag.cVf().removeCallbacks(this.ApD);
    g.ajD();
    if ((g.ajA().aiK()) && (this.Apm != null)) {
      this.Apm.a(this, 10);
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