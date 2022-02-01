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
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsUserUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMFragment;
import java.util.Iterator;
import java.util.List;

public class SnsAlbumUI
  extends MMFragment
  implements i.a, a.a
{
  private RecyclerView alu;
  private String lhM;
  private boolean ySS;
  private String ySX;
  private int ySZ;
  private am.a yXB;
  private Runnable yXS;
  private LinearLayout zaE;
  private LinearLayout zaF;
  private a zaG;
  private int zaH;
  
  public SnsAlbumUI()
  {
    AppMethodBeat.i(99882);
    this.alu = null;
    this.zaE = null;
    this.zaF = null;
    this.zaG = null;
    this.ySX = null;
    this.lhM = null;
    this.ySZ = 0;
    this.ySS = false;
    this.yXB = null;
    this.zaH = 0;
    this.yXS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99876);
        if (SnsAlbumUI.a(SnsAlbumUI.this) != null)
        {
          SnsAlbumUI.a(SnsAlbumUI.this).dQh();
          SnsAlbumUI.a(SnsAlbumUI.this).rp(true);
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
    if ((this.ySX.equals(this.lhM)) && (paramb.dGj() != 0L))
    {
      g.agS();
      g.agR().agA().set(ah.a.GLx, Long.valueOf(paramb.dGj()));
      this.zaG.xQ(paramb.dGj());
    }
    if (paramb.dGe()) {
      this.zaG.avT(paramb.dGk());
    }
    label199:
    label202:
    for (;;)
    {
      if ((bs.isNullOrNil(this.zaG.zae)) && (this.zaG != null))
      {
        this.zaG.zad = paramString;
        this.zaG.dQh();
        this.zaG.rp(true);
      }
      AppMethodBeat.o(99886);
      return;
      if (!paramb.dGf()) {
        if (this.zaH >= 2) {
          break label199;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label202;
        }
        this.zaH += 1;
        this.yXB.b(10, this.lhM, true, this.ySZ);
        break;
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(99887);
    af.cMM().removeCallbacks(this.yXS);
    if ((this.ySX.equals(this.lhM)) && (paramb.dGj() != 0L))
    {
      g.agS();
      g.agR().agA().set(ah.a.GLx, Long.valueOf(paramb.dGj()));
      this.zaG.xQ(paramb.dGj());
    }
    if (paramb.dGe())
    {
      this.zaG.avT(paramb.dGk());
      if (this.zaG.getItemCount() > 0)
      {
        this.zaG.cj(this.zaG.getItemCount() - 1);
        AppMethodBeat.o(99887);
      }
    }
    else if (this.zaG != null)
    {
      this.zaG.zaf = paramb.dGg();
      this.zaG.zad = paramString;
      this.zaG.dQh();
      this.zaG.rp(true);
    }
    AppMethodBeat.o(99887);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(99883);
    super.dealContentView(paramView);
    this.yXB = af.dHH();
    this.ySZ = getActivity().getIntent().getIntExtra("sns_source", 0);
    this.lhM = getActivity().getIntent().getStringExtra("sns_userName");
    this.ySX = u.axw();
    this.zaG = new a(getContext(), this.lhM, this);
    this.zaG.zal = new c.a()
    {
      public final void bY(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(99878);
        ac.i("MicroMsg.SnsAlbumUI", "onClickItem localId=%s, mediaId=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        SnsAlbumUI.a(SnsAlbumUI.this, paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(99878);
      }
    };
    this.zaE = ((LinearLayout)paramView.findViewById(2131296604));
    this.zaF = ((LinearLayout)paramView.findViewById(2131296603));
    this.alu = ((RecyclerView)paramView.findViewById(2131296606));
    this.zaF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99879);
        Object localObject = new Intent(SnsAlbumUI.this.getActivity(), SnsUserUI.class);
        ((Intent)localObject).putExtra("sns_rpt_scene", 21);
        ((Intent)localObject).putExtra("sns_userName", SnsAlbumUI.b(SnsAlbumUI.this));
        paramAnonymousView = SnsAlbumUI.this.getActivity();
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(99879);
      }
    });
    this.alu.setAdapter(this.zaG);
    paramView = this.alu;
    getContext();
    paramView.setLayoutManager(new LinearLayoutManager());
    this.alu.a(new d()
    {
      public final void Xa()
      {
        AppMethodBeat.i(99880);
        ac.d("MicroMsg.SnsAlbumUI", "onLoadMore");
        SnsAlbumUI.d(SnsAlbumUI.this).b(10, SnsAlbumUI.b(SnsAlbumUI.this), true, SnsAlbumUI.c(SnsAlbumUI.this));
        af.cMM().postDelayed(SnsAlbumUI.e(SnsAlbumUI.this), 3000L);
        AppMethodBeat.o(99880);
      }
    });
    this.alu.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99881);
        if (SnsAlbumUI.f(SnsAlbumUI.this))
        {
          ac.w("MicroMsg.SnsAlbumUI", "too fast that it finish");
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
  
  public final void fQ(List<a.b> paramList)
  {
    AppMethodBeat.i(99889);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.alu.setVisibility(0);
      this.zaE.setVisibility(8);
      AppMethodBeat.o(99889);
      return;
    }
    this.alu.setVisibility(8);
    this.zaE.setVisibility(0);
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
    ac.d("MicroMsg.SnsAlbumUI", "onActivityResult result=%s request=%s intent=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramIntent });
    if ((paramInt1 == 8) && (paramIntent != null) && (paramIntent.getParcelableExtra("sns_cmd_list") != null) && ((paramIntent.getParcelableExtra("sns_cmd_list") instanceof SnsCmdList))) {
      paramIntent = ((SnsCmdList)paramIntent.getParcelableExtra("sns_cmd_list")).xNr.iterator();
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
        locala = this.zaG;
        Object localObject = this.alu;
        paramInt1 = 0;
        label201:
        int j;
        int i;
        label240:
        int k;
        int m;
        if (paramInt1 < locala.zac.size())
        {
          Iterator localIterator = ((a.b)locala.zac.get(paramInt1)).zao.iterator();
          for (;;)
          {
            if (localIterator.hasNext()) {
              if (n == ((p)localIterator.next()).yvp)
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
                if (paramInt1 >= ((c)localObject).zay.size()) {
                  break label337;
                }
                k = j;
                m = i;
                if (((a.d)((c)localObject).zay.get(paramInt1)).dwR == n)
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
          ((c)localObject).zay.remove(j);
          paramInt1 += 1;
        }
        paramInt1 = ((c)localObject).zay.size();
        ((c)localObject).ar(j, i);
      }
      for (;;)
      {
        if (paramInt1 > 0) {
          break label426;
        }
        locala.zac.remove(paramInt2);
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
    this.ySS = true;
    af.cMM().removeCallbacks(this.yXS);
    g.agS();
    if ((g.agP().afY()) && (this.yXB != null)) {
      this.yXB.a(this, 10);
    }
    AppMethodBeat.o(99888);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(99885);
    ac.d("MicroMsg.SnsAlbumUI", "onViewCreated");
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