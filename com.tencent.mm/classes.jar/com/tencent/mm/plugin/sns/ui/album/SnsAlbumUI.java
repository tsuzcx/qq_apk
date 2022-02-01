package com.tencent.mm.plugin.sns.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.c.k.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.List;

public class SnsAlbumUI
  extends MMFragment
  implements k.a, a.a
{
  private Runnable REH;
  private ar.a REp;
  private LinearLayout RHT;
  private LinearLayout RHU;
  private a RHV;
  private int RHW;
  private boolean Rzf;
  private String Rzk;
  private int Rzm;
  private RecyclerView mRecyclerView;
  private String sWX;
  
  public SnsAlbumUI()
  {
    AppMethodBeat.i(99882);
    this.mRecyclerView = null;
    this.RHT = null;
    this.RHU = null;
    this.RHV = null;
    this.Rzk = null;
    this.sWX = null;
    this.Rzm = 0;
    this.Rzf = false;
    this.REp = null;
    this.RHW = 0;
    this.REH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99876);
        if (SnsAlbumUI.a(SnsAlbumUI.this) != null)
        {
          SnsAlbumUI.a(SnsAlbumUI.this).hpl();
          SnsAlbumUI.a(SnsAlbumUI.this).Ek(true);
        }
        AppMethodBeat.o(99876);
      }
    };
    AppMethodBeat.o(99882);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, com.tencent.mm.plugin.sns.c.b paramb, boolean paramBoolean2) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb)
  {
    AppMethodBeat.i(99886);
    if ((this.Rzk.equals(this.sWX)) && (paramb.hea() != 0L))
    {
      h.baF();
      h.baE().ban().set(at.a.acPN, Long.valueOf(paramb.hea()));
      this.RHV.vr(paramb.hea());
    }
    if (paramb.hdV()) {
      this.RHV.baV(paramb.heb());
    }
    label199:
    label202:
    for (;;)
    {
      if ((Util.isNullOrNil(this.RHV.RHs)) && (this.RHV != null))
      {
        this.RHV.RHr = paramString;
        this.RHV.hpl();
        this.RHV.Ek(true);
      }
      AppMethodBeat.o(99886);
      return;
      if (!paramb.hdW()) {
        if (this.RHW >= 2) {
          break label199;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label202;
        }
        this.RHW += 1;
        this.REp.b(10, this.sWX, true, this.Rzm);
        break;
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb)
  {
    AppMethodBeat.i(99887);
    al.fAG().removeCallbacks(this.REH);
    if ((this.Rzk.equals(this.sWX)) && (paramb.hea() != 0L))
    {
      h.baF();
      h.baE().ban().set(at.a.acPN, Long.valueOf(paramb.hea()));
      this.RHV.vr(paramb.hea());
    }
    if (paramb.hdV())
    {
      this.RHV.baV(paramb.heb());
      if (this.RHV.getItemCount() > 0)
      {
        this.RHV.fV(this.RHV.getItemCount() - 1);
        AppMethodBeat.o(99887);
      }
    }
    else if (this.RHV != null)
    {
      this.RHV.RHt = paramb.hdX();
      this.RHV.RHr = paramString;
      this.RHV.hpl();
      this.RHV.Ek(true);
    }
    AppMethodBeat.o(99887);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(99883);
    super.dealContentView(paramView);
    this.REp = al.hgr();
    this.Rzm = getActivity().getIntent().getIntExtra("sns_source", 0);
    this.sWX = getActivity().getIntent().getStringExtra("sns_userName");
    this.Rzk = z.bAM();
    this.RHV = new a(getContext(), this.sWX, this);
    this.RHV.RHz = new SnsAlbumUI.3(this);
    this.RHT = ((LinearLayout)paramView.findViewById(b.f.album_sns_no_data_tip_layout));
    this.RHU = ((LinearLayout)paramView.findViewById(b.f.album_sns_no_data_go_timeline_layout));
    this.mRecyclerView = ((RecyclerView)paramView.findViewById(b.f.album_sns_recycler));
    this.RHU.setOnClickListener(new SnsAlbumUI.4(this));
    this.mRecyclerView.setAdapter(this.RHV);
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
        al.fAG().postDelayed(SnsAlbumUI.e(SnsAlbumUI.this), 3000L);
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
    return b.g.sns_album_layout;
  }
  
  public final void kR(List<a.b> paramList)
  {
    AppMethodBeat.i(99889);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.mRecyclerView.setVisibility(0);
      this.RHT.setVisibility(8);
      AppMethodBeat.o(99889);
      return;
    }
    this.mRecyclerView.setVisibility(8);
    this.RHT.setVisibility(0);
    AppMethodBeat.o(99889);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99890);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MicroMsg.SnsAlbumUI", "onActivityResult result=%s request=%s intent=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramIntent });
    if ((paramInt1 == 8) && (paramIntent != null) && (paramIntent.getParcelableExtra("sns_cmd_list") != null) && ((paramIntent.getParcelableExtra("sns_cmd_list") instanceof SnsCmdList))) {
      paramIntent = ((SnsCmdList)paramIntent.getParcelableExtra("sns_cmd_list")).QnS.iterator();
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
        locala = this.RHV;
        Object localObject = this.mRecyclerView;
        paramInt1 = 0;
        label201:
        int j;
        int i;
        label240:
        int k;
        int m;
        if (paramInt1 < locala.RHq.size())
        {
          Iterator localIterator = ((a.b)locala.RHq.get(paramInt1)).RHC.iterator();
          for (;;)
          {
            if (localIterator.hasNext()) {
              if (n == ((SnsInfo)localIterator.next()).localid)
              {
                paramInt2 = paramInt1;
                if (paramInt2 == -1) {
                  break label322;
                }
                localObject = ((RecyclerView)localObject).fU(paramInt2);
                if (!(localObject instanceof a.f)) {
                  break;
                }
                localObject = a.f.a((a.f)localObject);
                j = -1;
                i = 1;
                paramInt1 = 0;
                if (paramInt1 >= ((c)localObject).RHN.size()) {
                  break label337;
                }
                k = j;
                m = i;
                if (((a.d)((c)localObject).RHN.get(paramInt1)).icg == n)
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
          ((c)localObject).RHN.remove(j);
          paramInt1 += 1;
        }
        paramInt1 = ((c)localObject).RHN.size();
        ((c)localObject).bB(j, i);
      }
      for (;;)
      {
        if (paramInt1 > 0) {
          break label426;
        }
        locala.RHq.remove(paramInt2);
        locala.fX(paramInt2);
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
    aw.bW(getActivity());
    super.onCreate(paramBundle);
    setMMTitle(b.j.album_title);
    setBackBtn(new SnsAlbumUI.2(this));
    AppMethodBeat.o(99884);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99888);
    super.onDestroy();
    this.Rzf = true;
    al.hgr().aYz(this.sWX);
    al.fAG().removeCallbacks(this.REH);
    h.baF();
    if ((h.baC().aZN()) && (this.REp != null)) {
      this.REp.a(this, 10);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI
 * JD-Core Version:    0.7.0.1
 */