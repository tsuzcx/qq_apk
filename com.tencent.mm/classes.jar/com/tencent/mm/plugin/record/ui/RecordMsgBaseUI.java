package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class RecordMsgBaseUI
  extends BaseFavDetailReportUI
{
  protected String appId = "";
  protected ListView jsM = null;
  protected long msgId = -1L;
  protected h xHU;
  private View xHV;
  private com.tencent.mm.sdk.b.c<gw> xHW = new com.tencent.mm.sdk.b.c() {};
  
  private String awJ(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime();
      String str = (String)DateFormat.format(getContext().getString(2131759517), l);
      return str;
    }
    catch (ParseException localParseException) {}
    return paramString;
  }
  
  private void b(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)getResources().getDimension(2131165576);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected void dHF()
  {
    this.xHU = dHG();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.appId = getIntent().getStringExtra("record_app_id");
    this.jsM = ((ListView)findViewById(2131303902));
    dHN();
    Object localObject2 = dHI();
    Object localObject3 = dHJ();
    Object localObject1;
    Object localObject4;
    if ((bu.isNullOrNil((String)localObject2)) || (bu.isNullOrNil((String)localObject3)))
    {
      ae.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      localObject2 = View.inflate(getContext(), 2131496420, null);
      localObject3 = (TextView)((View)localObject2).findViewById(2131308221);
      localObject1 = dHI();
      localObject4 = dHJ();
      if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil((String)localObject4))) {
        break label631;
      }
      ae.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      this.jsM.addHeaderView((View)localObject2, null, false);
      localObject3 = View.inflate(getContext(), 2131495221, null);
      if (!bu.isNullOrNil(this.appId)) {
        break label732;
      }
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azI().ys(this.msgId);
      localObject1 = k.b.aB(((ei)localObject1).field_content, ((ei)localObject1).field_reserved);
      if (localObject1 == null) {
        break label799;
      }
      this.appId = ((k.b)localObject1).appId;
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.gg(this.appId, ((k.b)localObject1).aDD);
      if ((localObject2 != null) && (((g)localObject2).field_appName != null) && (((g)localObject2).field_appName.trim().length() > 0)) {
        break label724;
      }
      localObject1 = ((k.b)localObject1).appName;
    }
    for (;;)
    {
      label256:
      if ((!bu.isNullOrNil(this.appId)) && (localObject2 != null))
      {
        this.xHV = ((View)localObject3).findViewById(2131303034);
        this.xHV.setVisibility(0);
        localObject4 = (ImageView)((View)localObject3).findViewById(2131296932);
        TextView localTextView = (TextView)((View)localObject3).findViewById(2131296933);
        ViewGroup.LayoutParams localLayoutParams = ((ImageView)localObject4).getLayoutParams();
        int i = (int)(localTextView.getTextSize() * 1.5D);
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        ((ImageView)localObject4).setLayoutParams(localLayoutParams);
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (g)localObject2, (String)localObject1);
        localTextView.setText(getResources().getString(2131761823, new Object[] { localObject1 }));
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.c(this.appId, 1, com.tencent.mm.cb.a.getDensity(getContext()));
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label780;
        }
        b((ImageView)localObject4, (Bitmap)localObject1);
      }
      for (;;)
      {
        this.jsM.addFooterView((View)localObject3, null, false);
        this.jsM.setAdapter(this.xHU);
        this.xHU.mListView = this.jsM;
        this.xHU.dHL();
        this.jsM.setOnScrollListener(new AbsListView.OnScrollListener()
        {
          public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            paramAnonymousInt2 = 0;
            AppMethodBeat.i(27873);
            if (paramAnonymousInt1 == 0)
            {
              paramAnonymousAbsListView = RecordMsgBaseUI.this.jsM.getChildAt(0);
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
              paramAnonymousAbsListView = new xg();
              paramAnonymousAbsListView.dMK.type = 5;
              paramAnonymousAbsListView.dMK.dML = RecordMsgBaseUI.this.jsM.getFirstVisiblePosition();
              paramAnonymousAbsListView.dMK.dMM = RecordMsgBaseUI.this.jsM.getLastVisiblePosition();
              paramAnonymousAbsListView.dMK.dMN = RecordMsgBaseUI.this.jsM.getHeaderViewsCount();
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousAbsListView);
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
        dHK();
        this.jsM.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27875);
            View localView = RecordMsgBaseUI.this.jsM.getChildAt(RecordMsgBaseUI.this.jsM.getLastVisiblePosition());
            if ((localView != null) && (RecordMsgBaseUI.a(RecordMsgBaseUI.this) != null) && (RecordMsgBaseUI.a(RecordMsgBaseUI.this).getVisibility() == 0))
            {
              int j = localView.getBottom();
              int k = RecordMsgBaseUI.this.jsM.getBottom();
              ae.d("MicroMsg.RecordMsgBaseUI", "footerBotm %d, listBotm %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
              int i = com.tencent.mm.cb.a.fromDPToPix(RecordMsgBaseUI.this.getContext(), 64);
              if (k - j > 0)
              {
                j = k - j + com.tencent.mm.cb.a.fromDPToPix(RecordMsgBaseUI.this.getContext(), 15);
                ae.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[] { Integer.valueOf(j) });
                if (j > i) {
                  RecordMsgBaseUI.a(RecordMsgBaseUI.this).setPadding(0, j, 0, 0);
                }
              }
            }
            AppMethodBeat.o(27875);
          }
        }, 100L);
        return;
        localObject1 = localObject2.split(" ")[0];
        localObject4 = localObject3.split(" ")[0];
        if (!localObject2.split("-")[0].equals(localObject3.split("-")[0]))
        {
          this.xHU.xHN = true;
          localObject1 = null;
        }
        for (;;)
        {
          setMMSubTitle((String)localObject1);
          break;
          if (((String)localObject1).equals(localObject4))
          {
            this.xHU.xHO = false;
          }
          else
          {
            localObject1 = (String)localObject1 + "~" + (String)localObject4;
            this.xHU.xHO = true;
          }
        }
        label631:
        localObject1 = awJ(localObject1.split(" ")[0]);
        localObject4 = awJ(localObject4.split(" ")[0]);
        if (((String)localObject1).equals(localObject4)) {}
        for (;;)
        {
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break;
          localObject1 = (String)localObject1 + " " + getString(2131766988) + " " + (String)localObject4;
        }
        label724:
        localObject1 = ((g)localObject2).field_appName;
        break label256;
        label732:
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.m(this.appId, true, false);
        if ((localObject2 == null) || (((g)localObject2).field_appName == null) || (((g)localObject2).field_appName.trim().length() <= 0)) {}
        for (localObject1 = "";; localObject1 = ((g)localObject2).field_appName) {
          break;
        }
        label780:
        b((ImageView)localObject4, BitmapFactory.decodeResource(getResources(), 2131233479));
      }
      label799:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  protected abstract h dHG();
  
  protected abstract String dHH();
  
  protected abstract String dHI();
  
  protected abstract String dHJ();
  
  protected abstract void dHK();
  
  protected final void dHN()
  {
    String str2 = dHH();
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
  
  protected abstract void f(int paramInt1, int paramInt2, Intent paramIntent);
  
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
    f(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    dHF();
    this.xHW.alive();
    com.tencent.mm.pluginsdk.h.r(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.xHW.dead();
    if (this.xHU != null) {
      this.xHU.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.xHU != null)
    {
      localObject = this.xHU;
      int i = 0;
      while (i < ((h)localObject).xHM.size())
      {
        h.b localb = (h.b)((h)localObject).xHM.valueAt(i);
        if (localb != null) {
          localb.pause();
        }
        i += 1;
      }
    }
    Object localObject = new xg();
    ((xg)localObject).dMK.type = 1;
    com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
  }
  
  public void onResume()
  {
    super.onResume();
    xg localxg = new xg();
    if (this.jsM != null)
    {
      localxg.dMK.type = 0;
      localxg.dMK.dML = this.jsM.getFirstVisiblePosition();
      localxg.dMK.dMM = this.jsM.getLastVisiblePosition();
      localxg.dMK.dMN = this.jsM.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.IvT.l(localxg);
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