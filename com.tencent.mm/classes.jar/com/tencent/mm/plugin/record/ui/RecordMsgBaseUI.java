package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public abstract class RecordMsgBaseUI
  extends BaseFavDetailReportUI
{
  protected String appId = "";
  protected ListView iWK = null;
  protected long msgId = -1L;
  protected h wkg;
  private View wkh;
  private com.tencent.mm.sdk.b.c<gs> wki = new com.tencent.mm.sdk.b.c() {};
  
  private void b(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)getResources().getDimension(2131165576);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected void dtR()
  {
    this.wkg = dtS();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.appId = getIntent().getStringExtra("record_app_id");
    this.iWK = ((ListView)findViewById(2131303902));
    dtZ();
    Object localObject1 = dtU();
    Object localObject2 = dtV();
    View localView;
    if ((bs.isNullOrNil((String)localObject1)) || (bs.isNullOrNil((String)localObject2)))
    {
      ac.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      localObject1 = new View(getContext());
      ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(2131165535)));
      this.iWK.addHeaderView((View)localObject1, null, false);
      localView = View.inflate(getContext(), 2131495221, null);
      if (!bs.isNullOrNil(this.appId)) {
        break label573;
      }
      az.ayM();
      localObject1 = com.tencent.mm.model.c.awD().vP(this.msgId);
      localObject1 = k.b.az(((dy)localObject1).field_content, ((dy)localObject1).field_reserved);
      if (localObject1 == null) {
        break label640;
      }
      this.appId = ((k.b)localObject1).appId;
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.fA(this.appId, ((k.b)localObject1).aBM);
      if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName.trim().length() > 0)) {
        break label565;
      }
      localObject1 = ((k.b)localObject1).appName;
    }
    for (;;)
    {
      label232:
      ImageView localImageView;
      if ((!bs.isNullOrNil(this.appId)) && (localObject2 != null))
      {
        this.wkh = localView.findViewById(2131303034);
        this.wkh.setVisibility(0);
        localImageView = (ImageView)localView.findViewById(2131296932);
        TextView localTextView = (TextView)localView.findViewById(2131296933);
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        int i = (int)(localTextView.getTextSize() * 1.5D);
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        localImageView.setLayoutParams(localLayoutParams);
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2, (String)localObject1);
        localTextView.setText(getResources().getString(2131761823, new Object[] { localObject1 }));
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.c(this.appId, 1, com.tencent.mm.cc.a.getDensity(getContext()));
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label621;
        }
        b(localImageView, (Bitmap)localObject1);
      }
      for (;;)
      {
        this.iWK.addFooterView(localView, null, false);
        this.iWK.setAdapter(this.wkg);
        this.wkg.mListView = this.iWK;
        this.wkg.dtX();
        this.iWK.setOnScrollListener(new AbsListView.OnScrollListener()
        {
          public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            paramAnonymousInt2 = 0;
            AppMethodBeat.i(27873);
            if (paramAnonymousInt1 == 0)
            {
              paramAnonymousAbsListView = RecordMsgBaseUI.this.iWK.getChildAt(0);
              if (paramAnonymousAbsListView == null) {}
              for (paramAnonymousInt1 = paramAnonymousInt2; paramAnonymousInt1 == 0; paramAnonymousInt1 = paramAnonymousAbsListView.getTop())
              {
                RecordMsgBaseUI.this.hideActionbarLine();
                AppMethodBeat.o(27873);
                return;
              }
            }
            RecordMsgBaseUI.this.showActionbarLine();
            AppMethodBeat.o(27873);
          }
          
          public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
          {
            AppMethodBeat.i(27872);
            if (paramAnonymousInt == 0)
            {
              paramAnonymousAbsListView = new wj();
              paramAnonymousAbsListView.dzj.type = 5;
              paramAnonymousAbsListView.dzj.dzk = RecordMsgBaseUI.this.iWK.getFirstVisiblePosition();
              paramAnonymousAbsListView.dzj.dzl = RecordMsgBaseUI.this.iWK.getLastVisiblePosition();
              paramAnonymousAbsListView.dzj.dzm = RecordMsgBaseUI.this.iWK.getHeaderViewsCount();
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousAbsListView);
            }
            AppMethodBeat.o(27872);
          }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(27874);
            RecordMsgBaseUI.this.finish();
            AppMethodBeat.o(27874);
            return true;
          }
        });
        dtW();
        this.iWK.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27875);
            View localView = RecordMsgBaseUI.this.iWK.getChildAt(RecordMsgBaseUI.this.iWK.getLastVisiblePosition());
            if ((localView != null) && (RecordMsgBaseUI.a(RecordMsgBaseUI.this) != null) && (RecordMsgBaseUI.a(RecordMsgBaseUI.this).getVisibility() == 0))
            {
              int j = localView.getBottom();
              int k = RecordMsgBaseUI.this.iWK.getBottom();
              ac.d("MicroMsg.RecordMsgBaseUI", "footerBotm %d, listBotm %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
              int i = com.tencent.mm.cc.a.fromDPToPix(RecordMsgBaseUI.this.getContext(), 64);
              if (k - j > 0)
              {
                j = k - j + com.tencent.mm.cc.a.fromDPToPix(RecordMsgBaseUI.this.getContext(), 15);
                ac.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[] { Integer.valueOf(j) });
                if (j > i) {
                  RecordMsgBaseUI.a(RecordMsgBaseUI.this).setPadding(0, j, 0, 0);
                }
              }
            }
            AppMethodBeat.o(27875);
          }
        }, 100L);
        return;
        localObject1 = localObject1.split(" ")[0];
        localObject2 = localObject2.split(" ")[0];
        if (((String)localObject1).equals(localObject2)) {}
        for (this.wkg.wka = true;; this.wkg.wka = true)
        {
          setMMSubTitle((String)localObject1);
          break;
          localObject1 = (String)localObject1 + "~" + (String)localObject2;
        }
        label565:
        localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
        break label232;
        label573:
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.k(this.appId, true, false);
        if ((localObject2 == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName.trim().length() <= 0)) {}
        for (localObject1 = "";; localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName) {
          break;
        }
        label621:
        b(localImageView, BitmapFactory.decodeResource(getResources(), 2131233479));
      }
      label640:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  protected abstract h dtS();
  
  protected abstract String dtT();
  
  protected abstract String dtU();
  
  protected abstract String dtV();
  
  protected abstract void dtW();
  
  protected final void dtZ()
  {
    String str2 = dtT();
    String str3 = getContext().getString(2131758637);
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.endsWith(str3))
      {
        str1 = str2;
        if (str2.lastIndexOf(str3) > 0) {
          str1 = str2.substring(0, str2.lastIndexOf(str3) - 1);
        }
      }
    }
    setMMTitle(k.b(getContext(), str1, getResources().getDimensionPixelSize(2131165192)));
  }
  
  protected abstract void e(int paramInt1, int paramInt2, Intent paramIntent);
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495222;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    e(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.pluginsdk.g.o(this);
    super.onCreate(paramBundle);
    dtR();
    this.wki.alive();
    com.tencent.mm.pluginsdk.g.p(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.wki.dead();
    if (this.wkg != null) {
      this.wkg.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.wkg != null)
    {
      localObject = this.wkg;
      int i = 0;
      while (i < ((h)localObject).wjZ.size())
      {
        h.b localb = (h.b)((h)localObject).wjZ.valueAt(i);
        if (localb != null) {
          localb.pause();
        }
        i += 1;
      }
    }
    Object localObject = new wj();
    ((wj)localObject).dzj.type = 1;
    com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
  }
  
  public void onResume()
  {
    super.onResume();
    wj localwj = new wj();
    if (this.iWK != null)
    {
      localwj.dzj.type = 0;
      localwj.dzj.dzk = this.iWK.getFirstVisiblePosition();
      localwj.dzj.dzl = this.iWK.getLastVisiblePosition();
      localwj.dzj.dzm = this.iWK.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.GpY.l(localwj);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
 * JD-Core Version:    0.7.0.1
 */