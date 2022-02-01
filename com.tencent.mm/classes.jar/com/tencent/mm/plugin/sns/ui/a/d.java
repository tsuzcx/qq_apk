package com.tencent.mm.plugin.sns.ui.a;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI;
import com.tencent.mm.plugin.sns.ui.ad;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.base.Vending;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends BaseAdapter
  implements ad
{
  public bn RGC;
  private SnsWsFoldDetailUI RGT;
  List<bo> dataList;
  
  public d(SnsWsFoldDetailUI paramSnsWsFoldDetailUI, ListView paramListView, c paramc, i parami)
  {
    AppMethodBeat.i(308326);
    this.dataList = new ArrayList();
    this.RGC = new bn(paramSnsWsFoldDetailUI, paramListView, paramc, parami, this);
    this.RGT = paramSnsWsFoldDetailUI;
    AppMethodBeat.o(308326);
  }
  
  public final SnsInfo alF(int paramInt)
  {
    AppMethodBeat.i(308335);
    SnsInfo localSnsInfo = ((bo)this.dataList.get(paramInt)).PJQ;
    AppMethodBeat.o(308335);
    return localSnsInfo;
  }
  
  public final bo alG(int paramInt)
  {
    AppMethodBeat.i(308329);
    bo localbo = (bo)this.dataList.get(paramInt);
    AppMethodBeat.o(308329);
    return localbo;
  }
  
  public final void b(final SnsWsFoldDetailUI paramSnsWsFoldDetailUI)
  {
    AppMethodBeat.i(308332);
    if (!paramSnsWsFoldDetailUI.nzW) {
      al.gHI().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(308330);
          if (paramSnsWsFoldDetailUI.nzW)
          {
            AppMethodBeat.o(308330);
            return;
          }
          Cursor localCursor;
          ArrayList localArrayList;
          if (paramSnsWsFoldDetailUI.username != null)
          {
            localCursor = al.hgB().bc(paramSnsWsFoldDetailUI.username, t.uB(paramSnsWsFoldDetailUI.maxId), t.uB(paramSnsWsFoldDetailUI.Qsh));
            localArrayList = new ArrayList();
            if (localCursor == null)
            {
              Log.w("MicroMsg.SnsWsFoldDetailAdapter", "cursor == null");
              AppMethodBeat.o(308330);
              return;
            }
            if (!localCursor.moveToFirst())
            {
              localCursor.close();
              Log.w("MicroMsg.SnsWsFoldDetailAdapter", "cursor.moveToFirst == false");
              AppMethodBeat.o(308330);
              return;
            }
            if (paramSnsWsFoldDetailUI.nzW)
            {
              AppMethodBeat.o(308330);
              return;
            }
          }
          for (;;)
          {
            try
            {
              Object localObject2 = new SnsInfo();
              ((SnsInfo)localObject2).convertFrom(localCursor);
              localArrayList.add(localObject2);
              if (localCursor.moveToNext()) {
                continue;
              }
              int j = localArrayList.size();
              localObject2 = new ArrayList();
              Iterator localIterator = localArrayList.iterator();
              int i = 0;
              if (localIterator.hasNext())
              {
                SnsInfo localSnsInfo = (SnsInfo)localIterator.next();
                SnsObject localSnsObject = ap.E(localSnsInfo);
                SnsWsFoldDetailUI localSnsWsFoldDetailUI = paramSnsWsFoldDetailUI;
                bn localbn = d.this.RGC;
                if (i >= j) {
                  break label416;
                }
                bool = true;
                ((List)localObject2).add(t.a(localSnsInfo, localSnsObject, localSnsWsFoldDetailUI, localbn, bool, paramSnsWsFoldDetailUI.psc, paramSnsWsFoldDetailUI.ltf, paramSnsWsFoldDetailUI.REQ, paramSnsWsFoldDetailUI.RER, paramSnsWsFoldDetailUI.RES));
                i += 1;
                continue;
              }
              Log.i("MicroMsg.SnsWsFoldDetailAdapter", "loadData finish, snsInfoList.size:%s, structlist.size:%s", new Object[] { Integer.valueOf(localArrayList.size()), Integer.valueOf(((List)localObject2).size()) });
              al.fAG().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(308328);
                  Object localObject = d.1.this.RGU;
                  ((SnsWsFoldDetailUI)localObject).sIX.setVisibility(8);
                  ((SnsWsFoldDetailUI)localObject).qgc.setVisibility(0);
                  localObject = d.this;
                  List localList = this.RGW;
                  ((d)localObject).dataList.clear();
                  ((d)localObject).dataList.addAll(localList);
                  d.this.notifyDataSetChanged();
                  AppMethodBeat.o(308328);
                }
              });
              return;
            }
            finally
            {
              if (localCursor != null) {
                localCursor.close();
              }
              AppMethodBeat.o(308330);
            }
            AppMethodBeat.o(308330);
            return;
            label416:
            boolean bool = false;
          }
        }
      });
    }
    AppMethodBeat.o(308332);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(308327);
    int i = this.dataList.size();
    AppMethodBeat.o(308327);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(308337);
    if ((paramInt >= 0) && (paramInt < this.dataList.size()))
    {
      paramViewGroup = (bo)this.dataList.get(paramInt);
      j localj = j.QFS;
      long l = paramViewGroup.RBq;
      if (!localj.QGQ.contains(Long.valueOf(l))) {
        localj.QGQ.add(Long.valueOf(l));
      }
    }
    paramView = this.RGC.y(paramInt, paramView);
    AppMethodBeat.o(308337);
    return paramView;
  }
  
  public final void hmc()
  {
    AppMethodBeat.i(308333);
    this.RGC.notifyDataSetChanged();
    AppMethodBeat.o(308333);
  }
  
  public final Vending hmd()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.d
 * JD-Core Version:    0.7.0.1
 */