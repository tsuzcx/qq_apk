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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
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
  implements i.a, a.a
{
  private boolean ELe;
  private String ELj;
  private int ELl;
  private aq.a EQi;
  private Runnable EQz;
  private LinearLayout ETC;
  private LinearLayout ETD;
  private a ETE;
  private int ETF;
  private String mRa;
  private RecyclerView mRecyclerView;
  
  public SnsAlbumUI()
  {
    AppMethodBeat.i(99882);
    this.mRecyclerView = null;
    this.ETC = null;
    this.ETD = null;
    this.ETE = null;
    this.ELj = null;
    this.mRa = null;
    this.ELl = 0;
    this.ELe = false;
    this.EQi = null;
    this.ETF = 0;
    this.EQz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99876);
        if (SnsAlbumUI.a(SnsAlbumUI.this) != null)
        {
          SnsAlbumUI.a(SnsAlbumUI.this).fiE();
          SnsAlbumUI.a(SnsAlbumUI.this).vw(true);
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
    if ((this.ELj.equals(this.mRa)) && (paramb.eZf() != 0L))
    {
      g.aAi();
      g.aAh().azQ().set(ar.a.Oap, Long.valueOf(paramb.eZf()));
      this.ETE.JR(paramb.eZf());
    }
    if (paramb.eZa()) {
      this.ETE.aRn(paramb.eZg());
    }
    label199:
    label202:
    for (;;)
    {
      if ((Util.isNullOrNil(this.ETE.ETc)) && (this.ETE != null))
      {
        this.ETE.ETb = paramString;
        this.ETE.fiE();
        this.ETE.vw(true);
      }
      AppMethodBeat.o(99886);
      return;
      if (!paramb.eZb()) {
        if (this.ETF >= 2) {
          break label199;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label202;
        }
        this.ETF += 1;
        this.EQi.b(10, this.mRa, true, this.ELl);
        break;
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(99887);
    aj.dRd().removeCallbacks(this.EQz);
    if ((this.ELj.equals(this.mRa)) && (paramb.eZf() != 0L))
    {
      g.aAi();
      g.aAh().azQ().set(ar.a.Oap, Long.valueOf(paramb.eZf()));
      this.ETE.JR(paramb.eZf());
    }
    if (paramb.eZa())
    {
      this.ETE.aRn(paramb.eZg());
      if (this.ETE.getItemCount() > 0)
      {
        this.ETE.ci(this.ETE.getItemCount() - 1);
        AppMethodBeat.o(99887);
      }
    }
    else if (this.ETE != null)
    {
      this.ETE.ETd = paramb.eZc();
      this.ETE.ETb = paramString;
      this.ETE.fiE();
      this.ETE.vw(true);
    }
    AppMethodBeat.o(99887);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(99883);
    super.dealContentView(paramView);
    this.EQi = aj.faE();
    this.ELl = getActivity().getIntent().getIntExtra("sns_source", 0);
    this.mRa = getActivity().getIntent().getStringExtra("sns_userName");
    this.ELj = z.aTY();
    this.ETE = new a(getContext(), this.mRa, this);
    this.ETE.ETj = new SnsAlbumUI.3(this);
    this.ETC = ((LinearLayout)paramView.findViewById(2131296681));
    this.ETD = ((LinearLayout)paramView.findViewById(2131296680));
    this.mRecyclerView = ((RecyclerView)paramView.findViewById(2131296683));
    this.ETD.setOnClickListener(new SnsAlbumUI.4(this));
    this.mRecyclerView.setAdapter(this.ETE);
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
        aj.dRd().postDelayed(SnsAlbumUI.e(SnsAlbumUI.this), 3000L);
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
    return 2131496413;
  }
  
  public final void hh(List<a.b> paramList)
  {
    AppMethodBeat.i(99889);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.mRecyclerView.setVisibility(0);
      this.ETC.setVisibility(8);
      AppMethodBeat.o(99889);
      return;
    }
    this.mRecyclerView.setVisibility(8);
    this.ETC.setVisibility(0);
    AppMethodBeat.o(99889);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99890);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MicroMsg.SnsAlbumUI", "onActivityResult result=%s request=%s intent=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramIntent });
    if ((paramInt1 == 8) && (paramIntent != null) && (paramIntent.getParcelableExtra("sns_cmd_list") != null) && ((paramIntent.getParcelableExtra("sns_cmd_list") instanceof SnsCmdList))) {
      paramIntent = ((SnsCmdList)paramIntent.getParcelableExtra("sns_cmd_list")).DEl.iterator();
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
        locala = this.ETE;
        Object localObject = this.mRecyclerView;
        paramInt1 = 0;
        label201:
        int j;
        int i;
        label240:
        int k;
        int m;
        if (paramInt1 < locala.ETa.size())
        {
          Iterator localIterator = ((a.b)locala.ETa.get(paramInt1)).ETm.iterator();
          for (;;)
          {
            if (localIterator.hasNext()) {
              if (n == ((SnsInfo)localIterator.next()).localid)
              {
                paramInt2 = paramInt1;
                if (paramInt2 == -1) {
                  break label322;
                }
                localObject = ((RecyclerView)localObject).ch(paramInt2);
                if (!(localObject instanceof a.f)) {
                  break;
                }
                localObject = a.f.a((a.f)localObject);
                j = -1;
                i = 1;
                paramInt1 = 0;
                if (paramInt1 >= ((c)localObject).ETw.size()) {
                  break label337;
                }
                k = j;
                m = i;
                if (((a.d)((c)localObject).ETw.get(paramInt1)).ecf == n)
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
          ((c)localObject).ETw.remove(j);
          paramInt1 += 1;
        }
        paramInt1 = ((c)localObject).ETw.size();
        ((c)localObject).at(j, i);
      }
      for (;;)
      {
        if (paramInt1 > 0) {
          break label426;
        }
        locala.ETa.remove(paramInt2);
        locala.ck(paramInt2);
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
    setMMTitle(2131755286);
    setBackBtn(new SnsAlbumUI.2(this));
    AppMethodBeat.o(99884);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99888);
    super.onDestroy();
    this.ELe = true;
    aj.dRd().removeCallbacks(this.EQz);
    g.aAi();
    if ((g.aAf().azp()) && (this.EQi != null)) {
      this.EQi.a(this, 10);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI
 * JD-Core Version:    0.7.0.1
 */