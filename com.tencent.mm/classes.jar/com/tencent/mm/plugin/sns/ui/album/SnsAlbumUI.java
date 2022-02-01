package com.tencent.mm.plugin.sns.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.j.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsUserUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMFragment;
import java.util.Iterator;
import java.util.List;

public class SnsAlbumUI
  extends MMFragment
  implements j.a, a.a
{
  private boolean KZf;
  private String KZk;
  private int KZm;
  private ap.a Leg;
  private Runnable Lex;
  private LinearLayout LhE;
  private LinearLayout LhF;
  private a LhG;
  private int LhH;
  private RecyclerView mRecyclerView;
  private String pRV;
  
  public SnsAlbumUI()
  {
    AppMethodBeat.i(99882);
    this.mRecyclerView = null;
    this.LhE = null;
    this.LhF = null;
    this.LhG = null;
    this.KZk = null;
    this.pRV = null;
    this.KZm = 0;
    this.KZf = false;
    this.Leg = null;
    this.LhH = 0;
    this.Lex = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99876);
        if (SnsAlbumUI.a(SnsAlbumUI.this) != null)
        {
          SnsAlbumUI.a(SnsAlbumUI.this).fWS();
          SnsAlbumUI.a(SnsAlbumUI.this).za(true);
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
    if ((this.KZk.equals(this.pRV)) && (paramb.fMU() != 0L))
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.Vor, Long.valueOf(paramb.fMU()));
      this.LhG.Rl(paramb.fMU());
    }
    if (paramb.fMP()) {
      this.LhG.bcp(paramb.fMV());
    }
    label199:
    label202:
    for (;;)
    {
      if ((Util.isNullOrNil(this.LhG.Lhd)) && (this.LhG != null))
      {
        this.LhG.Lhc = paramString;
        this.LhG.fWS();
        this.LhG.za(true);
      }
      AppMethodBeat.o(99886);
      return;
      if (!paramb.fMQ()) {
        if (this.LhH >= 2) {
          break label199;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label202;
        }
        this.LhH += 1;
        this.Leg.b(10, this.pRV, true, this.KZm);
        break;
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99887);
    aj.etE().removeCallbacks(this.Lex);
    if ((this.KZk.equals(this.pRV)) && (paramb.fMU() != 0L))
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.Vor, Long.valueOf(paramb.fMU()));
      this.LhG.Rl(paramb.fMU());
    }
    if (paramb.fMP())
    {
      this.LhG.bcp(paramb.fMV());
      if (this.LhG.getItemCount() > 0)
      {
        this.LhG.cL(this.LhG.getItemCount() - 1);
        AppMethodBeat.o(99887);
      }
    }
    else if (this.LhG != null)
    {
      this.LhG.Lhe = paramb.fMR();
      this.LhG.Lhc = paramString;
      this.LhG.fWS();
      this.LhG.za(true);
    }
    AppMethodBeat.o(99887);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(99883);
    super.dealContentView(paramView);
    this.Leg = aj.fOy();
    this.KZm = getActivity().getIntent().getIntExtra("sns_source", 0);
    this.pRV = getActivity().getIntent().getStringExtra("sns_userName");
    this.KZk = z.bcZ();
    this.LhG = new a(getContext(), this.pRV, this);
    this.LhG.Lhk = new c.a()
    {
      public final void cx(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(99878);
        Log.i("MicroMsg.SnsAlbumUI", "onClickItem localId=%s, mediaId=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        SnsAlbumUI.a(SnsAlbumUI.this, paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(99878);
      }
    };
    this.LhE = ((LinearLayout)paramView.findViewById(i.f.album_sns_no_data_tip_layout));
    this.LhF = ((LinearLayout)paramView.findViewById(i.f.album_sns_no_data_go_timeline_layout));
    this.mRecyclerView = ((RecyclerView)paramView.findViewById(i.f.album_sns_recycler));
    this.LhF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99879);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = new Intent(SnsAlbumUI.this.getActivity(), SnsUserUI.class);
        ((Intent)localObject).putExtra("sns_rpt_scene", 21);
        ((Intent)localObject).putExtra("sns_userName", SnsAlbumUI.b(SnsAlbumUI.this));
        paramAnonymousView = SnsAlbumUI.this.getActivity();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99879);
      }
    });
    this.mRecyclerView.setAdapter(this.LhG);
    paramView = this.mRecyclerView;
    getContext();
    paramView.setLayoutManager(new LinearLayoutManager());
    this.mRecyclerView.a(new d()
    {
      public final void onLoadMore()
      {
        AppMethodBeat.i(99880);
        Log.d("MicroMsg.SnsAlbumUI", "onLoadMore");
        SnsAlbumUI.d(SnsAlbumUI.this).b(10, SnsAlbumUI.b(SnsAlbumUI.this), true, SnsAlbumUI.c(SnsAlbumUI.this));
        aj.etE().postDelayed(SnsAlbumUI.e(SnsAlbumUI.this), 3000L);
        AppMethodBeat.o(99880);
      }
    });
    this.mRecyclerView.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99881);
        if (SnsAlbumUI.f(SnsAlbumUI.this))
        {
          Log.w("MicroMsg.SnsAlbumUI", "too fast that it finish");
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
  
  public int getLayoutId()
  {
    return i.g.sns_album_layout;
  }
  
  public final void hQ(List<a.b> paramList)
  {
    AppMethodBeat.i(99889);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.mRecyclerView.setVisibility(0);
      this.LhE.setVisibility(8);
      AppMethodBeat.o(99889);
      return;
    }
    this.mRecyclerView.setVisibility(8);
    this.LhE.setVisibility(0);
    AppMethodBeat.o(99889);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99890);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MicroMsg.SnsAlbumUI", "onActivityResult result=%s request=%s intent=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramIntent });
    if ((paramInt1 == 8) && (paramIntent != null) && (paramIntent.getParcelableExtra("sns_cmd_list") != null) && ((paramIntent.getParcelableExtra("sns_cmd_list") instanceof SnsCmdList))) {
      paramIntent = ((SnsCmdList)paramIntent.getParcelableExtra("sns_cmd_list")).JRg.iterator();
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
        locala = this.LhG;
        Object localObject = this.mRecyclerView;
        paramInt1 = 0;
        label201:
        int j;
        int i;
        label240:
        int k;
        int m;
        if (paramInt1 < locala.Lhb.size())
        {
          Iterator localIterator = ((a.b)locala.Lhb.get(paramInt1)).Lhn.iterator();
          for (;;)
          {
            if (localIterator.hasNext()) {
              if (n == ((SnsInfo)localIterator.next()).localid)
              {
                paramInt2 = paramInt1;
                if (paramInt2 == -1) {
                  break label322;
                }
                localObject = ((RecyclerView)localObject).cK(paramInt2);
                if (!(localObject instanceof a.f)) {
                  break;
                }
                localObject = a.f.a((a.f)localObject);
                j = -1;
                i = 1;
                paramInt1 = 0;
                if (paramInt1 >= ((c)localObject).Lhy.size()) {
                  break label337;
                }
                k = j;
                m = i;
                if (((a.d)((c)localObject).Lhy.get(paramInt1)).fWh == n)
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
          ((c)localObject).Lhy.remove(j);
          paramInt1 += 1;
        }
        paramInt1 = ((c)localObject).Lhy.size();
        ((c)localObject).aH(j, i);
      }
      for (;;)
      {
        if (paramInt1 > 0) {
          break label426;
        }
        locala.Lhb.remove(paramInt2);
        locala.cN(paramInt2);
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
    setMMTitle(i.j.album_title);
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
    this.KZf = true;
    aj.fOy().bai(this.pRV);
    aj.etE().removeCallbacks(this.Lex);
    h.aHH();
    if ((h.aHE().aGM()) && (this.Leg != null)) {
      this.Leg.a(this, 10);
    }
    AppMethodBeat.o(99888);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(99885);
    Log.d("MicroMsg.SnsAlbumUI", "onViewCreated");
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