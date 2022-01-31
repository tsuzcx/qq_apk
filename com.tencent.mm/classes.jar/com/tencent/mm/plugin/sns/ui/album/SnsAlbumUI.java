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
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import java.util.Iterator;
import java.util.List;

public class SnsAlbumUI
  extends MMFragment
  implements h.a, a.a
{
  private RecyclerView adt;
  private String ikj;
  private String rXD;
  private int rXF;
  private boolean rXy;
  private an.a sbY;
  private Runnable scd;
  private LinearLayout seG;
  private LinearLayout seH;
  private a seI;
  private int seJ;
  
  public SnsAlbumUI()
  {
    AppMethodBeat.i(39992);
    this.adt = null;
    this.seG = null;
    this.seH = null;
    this.seI = null;
    this.rXD = null;
    this.ikj = null;
    this.rXF = 0;
    this.rXy = false;
    this.sbY = null;
    this.seJ = 0;
    this.scd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39986);
        if (SnsAlbumUI.a(SnsAlbumUI.this) != null)
        {
          SnsAlbumUI.a(SnsAlbumUI.this).cvL();
          SnsAlbumUI.a(SnsAlbumUI.this).lE(true);
        }
        AppMethodBeat.o(39986);
      }
    };
    AppMethodBeat.o(39992);
  }
  
  private boolean cwS()
  {
    return this.seJ < 3;
  }
  
  public final void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(39997);
    ag.bEf().removeCallbacks(this.scd);
    if ((this.rXD.equals(this.ikj)) && (paramLong != 0L))
    {
      g.RM();
      g.RL().Ru().set(ac.a.yEZ, Long.valueOf(paramLong));
      this.seI.me(paramLong);
    }
    if (paramBoolean1)
    {
      this.seI.cwR();
      AppMethodBeat.o(39997);
      return;
    }
    if (cwS())
    {
      this.seJ += 1;
      this.sbY.b(2, this.ikj, true, this.rXF);
      AppMethodBeat.o(39997);
      return;
    }
    if (this.seI != null)
    {
      this.seJ = 0;
      this.seI.seg = paramBoolean2;
      this.seI.see = paramString1;
      this.seI.cvL();
      this.seI.lE(true);
    }
    AppMethodBeat.o(39997);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(39996);
    if ((this.rXD.equals(this.ikj)) && (paramLong != 0L))
    {
      g.RM();
      g.RL().Ru().set(ac.a.yEZ, Long.valueOf(paramLong));
      this.seI.me(paramLong);
    }
    if (paramBoolean2) {
      this.seI.cwR();
    }
    for (;;)
    {
      if ((bo.isNullOrNil(this.seI.sef)) && (this.seI != null))
      {
        this.seI.see = paramString1;
        this.seI.cvL();
        this.seI.lE(true);
      }
      AppMethodBeat.o(39996);
      return;
      if ((paramBoolean1) || (cwS()))
      {
        this.seJ += 1;
        this.sbY.b(2, this.ikj, true, this.rXF);
      }
    }
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(39993);
    super.dealContentView(paramView);
    this.sbY = ag.coV();
    this.rXF = getActivity().getIntent().getIntExtra("sns_source", 0);
    this.ikj = getActivity().getIntent().getStringExtra("sns_userName");
    this.rXD = r.Zn();
    this.seI = new a(getContext(), this.ikj, this);
    this.seI.sen = new SnsAlbumUI.3(this);
    this.seG = ((LinearLayout)paramView.findViewById(2131827899));
    this.seH = ((LinearLayout)paramView.findViewById(2131827901));
    this.adt = ((RecyclerView)paramView.findViewById(2131827902));
    this.seH.setOnClickListener(new SnsAlbumUI.4(this));
    this.adt.setAdapter(this.seI);
    paramView = this.adt;
    getContext();
    paramView.setLayoutManager(new LinearLayoutManager());
    this.adt.a(new SnsAlbumUI.5(this));
    this.adt.postDelayed(new SnsAlbumUI.6(this), 500L);
    AppMethodBeat.o(39993);
  }
  
  public final void dq(List<a.b> paramList)
  {
    AppMethodBeat.i(39999);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.adt.setVisibility(0);
      this.seG.setVisibility(8);
      AppMethodBeat.o(39999);
      return;
    }
    this.adt.setVisibility(8);
    this.seG.setVisibility(0);
    AppMethodBeat.o(39999);
  }
  
  public int getLayoutId()
  {
    return 2130970805;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(40000);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.d("MicroMsg.SnsAlbumUI", "onActivityResult result=%s request=%s intent=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramIntent });
    if ((paramInt1 == 8) && (paramIntent != null) && (paramIntent.getParcelableExtra("sns_cmd_list") != null) && ((paramIntent.getParcelableExtra("sns_cmd_list") instanceof SnsCmdList))) {
      paramIntent = ((SnsCmdList)paramIntent.getParcelableExtra("sns_cmd_list")).rbg.iterator();
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
        locala = this.seI;
        Object localObject = this.adt;
        paramInt1 = 0;
        label201:
        int j;
        int i;
        label240:
        int k;
        int m;
        if (paramInt1 < locala.sed.size())
        {
          Iterator localIterator = ((a.b)locala.sed.get(paramInt1)).seq.iterator();
          for (;;)
          {
            if (localIterator.hasNext()) {
              if (n == ((n)localIterator.next()).rCV)
              {
                paramInt2 = paramInt1;
                if (paramInt2 == -1) {
                  break label322;
                }
                localObject = ((RecyclerView)localObject).bQ(paramInt2);
                if (!(localObject instanceof a.f)) {
                  break;
                }
                localObject = a.f.a((a.f)localObject);
                j = -1;
                i = 1;
                paramInt1 = 0;
                if (paramInt1 >= ((c)localObject).seA.size()) {
                  break label337;
                }
                k = j;
                m = i;
                if (((a.d)((c)localObject).seA.get(paramInt1)).cIp == n)
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
          ((c)localObject).seA.remove(j);
          paramInt1 += 1;
        }
        paramInt1 = ((c)localObject).seA.size();
        ((c)localObject).aq(j, i);
      }
      for (;;)
      {
        if (paramInt1 > 0) {
          break label426;
        }
        locala.sed.remove(paramInt2);
        locala.bT(paramInt2);
        break;
        AppMethodBeat.o(40000);
        return;
        paramInt1 = 0;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39994);
    super.onCreate(paramBundle);
    setMMTitle(2131296518);
    setBackBtn(new SnsAlbumUI.2(this));
    AppMethodBeat.o(39994);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39998);
    super.onDestroy();
    this.rXy = true;
    ag.bEf().removeCallbacks(this.scd);
    g.RM();
    if ((g.RJ().QU()) && (this.sbY != null)) {
      this.sbY.a(this, 2);
    }
    AppMethodBeat.o(39998);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(39995);
    ab.d("MicroMsg.SnsAlbumUI", "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    AppMethodBeat.o(39995);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI
 * JD-Core Version:    0.7.0.1
 */