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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class RecordMsgBaseUI
  extends BaseFavDetailReportUI
{
  protected String appId = "";
  protected ListView jpT = null;
  protected long msgId = -1L;
  protected h xrX;
  private View xrY;
  private com.tencent.mm.sdk.b.c<gv> xrZ = new com.tencent.mm.sdk.b.c() {};
  
  private String avu(String paramString)
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
  
  protected void dEo()
  {
    this.xrX = dEp();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.appId = getIntent().getStringExtra("record_app_id");
    this.jpT = ((ListView)findViewById(2131303902));
    dEw();
    Object localObject2 = dEr();
    Object localObject3 = dEs();
    Object localObject1;
    Object localObject4;
    if ((bt.isNullOrNil((String)localObject2)) || (bt.isNullOrNil((String)localObject3)))
    {
      ad.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      localObject2 = View.inflate(getContext(), 2131496420, null);
      localObject3 = (TextView)((View)localObject2).findViewById(2131308221);
      localObject1 = dEr();
      localObject4 = dEs();
      if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil((String)localObject4))) {
        break label631;
      }
      ad.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      this.jpT.addHeaderView((View)localObject2, null, false);
      localObject3 = View.inflate(getContext(), 2131495221, null);
      if (!bt.isNullOrNil(this.appId)) {
        break label732;
      }
      ba.aBQ();
      localObject1 = com.tencent.mm.model.c.azs().xY(this.msgId);
      localObject1 = k.b.aA(((ei)localObject1).field_content, ((ei)localObject1).field_reserved);
      if (localObject1 == null) {
        break label799;
      }
      this.appId = ((k.b)localObject1).appId;
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.fX(this.appId, ((k.b)localObject1).aDD);
      if ((localObject2 != null) && (((g)localObject2).field_appName != null) && (((g)localObject2).field_appName.trim().length() > 0)) {
        break label724;
      }
      localObject1 = ((k.b)localObject1).appName;
    }
    for (;;)
    {
      label256:
      if ((!bt.isNullOrNil(this.appId)) && (localObject2 != null))
      {
        this.xrY = ((View)localObject3).findViewById(2131303034);
        this.xrY.setVisibility(0);
        localObject4 = (ImageView)((View)localObject3).findViewById(2131296932);
        TextView localTextView = (TextView)((View)localObject3).findViewById(2131296933);
        ViewGroup.LayoutParams localLayoutParams = ((ImageView)localObject4).getLayoutParams();
        int i = (int)(localTextView.getTextSize() * 1.5D);
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        ((ImageView)localObject4).setLayoutParams(localLayoutParams);
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (g)localObject2, (String)localObject1);
        localTextView.setText(getResources().getString(2131761823, new Object[] { localObject1 }));
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.c(this.appId, 1, com.tencent.mm.cc.a.getDensity(getContext()));
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label780;
        }
        b((ImageView)localObject4, (Bitmap)localObject1);
      }
      for (;;)
      {
        this.jpT.addFooterView((View)localObject3, null, false);
        this.jpT.setAdapter(this.xrX);
        this.xrX.mListView = this.jpT;
        this.xrX.dEu();
        this.jpT.setOnScrollListener(new AbsListView.OnScrollListener()
        {
          public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            paramAnonymousInt2 = 0;
            AppMethodBeat.i(27873);
            if (paramAnonymousInt1 == 0)
            {
              paramAnonymousAbsListView = RecordMsgBaseUI.this.jpT.getChildAt(0);
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
              paramAnonymousAbsListView = new xc();
              paramAnonymousAbsListView.dLv.type = 5;
              paramAnonymousAbsListView.dLv.dLw = RecordMsgBaseUI.this.jpT.getFirstVisiblePosition();
              paramAnonymousAbsListView.dLv.dLx = RecordMsgBaseUI.this.jpT.getLastVisiblePosition();
              paramAnonymousAbsListView.dLv.dLy = RecordMsgBaseUI.this.jpT.getHeaderViewsCount();
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousAbsListView);
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
        dEt();
        this.jpT.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27875);
            View localView = RecordMsgBaseUI.this.jpT.getChildAt(RecordMsgBaseUI.this.jpT.getLastVisiblePosition());
            if ((localView != null) && (RecordMsgBaseUI.a(RecordMsgBaseUI.this) != null) && (RecordMsgBaseUI.a(RecordMsgBaseUI.this).getVisibility() == 0))
            {
              int j = localView.getBottom();
              int k = RecordMsgBaseUI.this.jpT.getBottom();
              ad.d("MicroMsg.RecordMsgBaseUI", "footerBotm %d, listBotm %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
              int i = com.tencent.mm.cc.a.fromDPToPix(RecordMsgBaseUI.this.getContext(), 64);
              if (k - j > 0)
              {
                j = k - j + com.tencent.mm.cc.a.fromDPToPix(RecordMsgBaseUI.this.getContext(), 15);
                ad.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[] { Integer.valueOf(j) });
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
          this.xrX.xrQ = true;
          localObject1 = null;
        }
        for (;;)
        {
          setMMSubTitle((String)localObject1);
          break;
          if (((String)localObject1).equals(localObject4))
          {
            this.xrX.xrR = false;
          }
          else
          {
            localObject1 = (String)localObject1 + "~" + (String)localObject4;
            this.xrX.xrR = true;
          }
        }
        label631:
        localObject1 = avu(localObject1.split(" ")[0]);
        localObject4 = avu(localObject4.split(" ")[0]);
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
  
  protected abstract h dEp();
  
  protected abstract String dEq();
  
  protected abstract String dEr();
  
  protected abstract String dEs();
  
  protected abstract void dEt();
  
  protected final void dEw()
  {
    String str2 = dEq();
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
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    dEo();
    this.xrZ.alive();
    com.tencent.mm.pluginsdk.h.r(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.xrZ.dead();
    if (this.xrX != null) {
      this.xrX.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.xrX != null)
    {
      localObject = this.xrX;
      int i = 0;
      while (i < ((h)localObject).xrP.size())
      {
        h.b localb = (h.b)((h)localObject).xrP.valueAt(i);
        if (localb != null) {
          localb.pause();
        }
        i += 1;
      }
    }
    Object localObject = new xc();
    ((xc)localObject).dLv.type = 1;
    com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
  }
  
  public void onResume()
  {
    super.onResume();
    xc localxc = new xc();
    if (this.jpT != null)
    {
      localxc.dLv.type = 0;
      localxc.dLv.dLw = this.jpT.getFirstVisiblePosition();
      localxc.dLv.dLx = this.jpT.getLastVisiblePosition();
      localxc.dLv.dLy = this.jpT.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.IbL.l(localxc);
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