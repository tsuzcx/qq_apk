package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.abi;
import com.tencent.mm.autogen.a.hs;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.cd.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class RecordMsgBaseUI
  extends BaseFavDetailReportUI
{
  protected h NBE;
  private View NBF;
  private IListener<hs> NBG = new IListener(f.hfK) {};
  protected String appId = "";
  protected long msgId = -1L;
  protected ListView qgc = null;
  
  private String aSK(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime();
      String str = (String)DateFormat.format(getContext().getString(R.l.fmt_longdate), l);
      return str;
    }
    catch (ParseException localParseException) {}
    return paramString;
  }
  
  private void b(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)getResources().getDimension(R.f.SmallestTextSize);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected void gGm()
  {
    this.NBE = gGn();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.appId = getIntent().getStringExtra("record_app_id");
    this.qgc = ((ListView)findViewById(R.h.fUA));
    gGu();
    Object localObject1 = gGp();
    Object localObject2 = gGq();
    Object localObject3;
    Object localObject4;
    if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil((String)localObject2)))
    {
      Log.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      localObject2 = View.inflate(getContext(), R.i.gny, null);
      localObject3 = (TextView)((View)localObject2).findViewById(R.h.gae);
      localObject1 = gGp();
      localObject4 = gGq();
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject4))) {
        break label649;
      }
      Log.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      this.qgc.addHeaderView((View)localObject2, null, false);
      localObject3 = View.inflate(getContext(), R.i.gnx, null);
      if (!Util.isNullOrNil(this.appId)) {
        break label750;
      }
      bh.bCz();
      localObject1 = c.bzD().sl(this.msgId);
      if (localObject1 == null) {
        break label817;
      }
      localObject1 = k.b.aP(((fi)localObject1).field_content, ((fi)localObject1).field_reserved);
      if (localObject1 == null) {
        break label817;
      }
      this.appId = ((k.b)localObject1).appId;
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.is(this.appId, ((k.b)localObject1).appVersion);
      if ((localObject2 != null) && (((g)localObject2).field_appName != null) && (((g)localObject2).field_appName.trim().length() > 0)) {
        break label742;
      }
      localObject1 = ((k.b)localObject1).appName;
    }
    for (;;)
    {
      label262:
      if ((!Util.isNullOrNil(this.appId)) && (localObject2 != null))
      {
        this.NBF = ((View)localObject3).findViewById(R.h.fSJ);
        this.NBF.setVisibility(0);
        localObject4 = (ImageView)((View)localObject3).findViewById(R.h.fsm);
        TextView localTextView = (TextView)((View)localObject3).findViewById(R.h.fsn);
        ViewGroup.LayoutParams localLayoutParams = ((ImageView)localObject4).getLayoutParams();
        int i = (int)(localTextView.getTextSize() * 1.5D);
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        ((ImageView)localObject4).setLayoutParams(localLayoutParams);
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (g)localObject2, (String)localObject1);
        localTextView.setText(getResources().getString(R.l.opensdk_source_tv_record, new Object[] { localObject1 }));
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.c(this.appId, 1, a.getDensity(getContext()));
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label798;
        }
        b((ImageView)localObject4, (Bitmap)localObject1);
      }
      for (;;)
      {
        this.qgc.addFooterView((View)localObject3, null, false);
        this.qgc.setAdapter(this.NBE);
        this.NBE.mListView = this.qgc;
        this.NBE.gGs();
        this.NBE.NBB = getIntent().getIntExtra("preChatTYPE", 0);
        this.qgc.setOnScrollListener(new AbsListView.OnScrollListener()
        {
          public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            paramAnonymousInt2 = 0;
            AppMethodBeat.i(27873);
            if (paramAnonymousInt1 == 0)
            {
              paramAnonymousAbsListView = RecordMsgBaseUI.this.qgc.getChildAt(0);
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
              paramAnonymousAbsListView = new abi();
              paramAnonymousAbsListView.ieT.type = 5;
              paramAnonymousAbsListView.ieT.ieU = RecordMsgBaseUI.this.qgc.getFirstVisiblePosition();
              paramAnonymousAbsListView.ieT.ieV = RecordMsgBaseUI.this.qgc.getLastVisiblePosition();
              paramAnonymousAbsListView.ieT.ieW = RecordMsgBaseUI.this.qgc.getHeaderViewsCount();
              paramAnonymousAbsListView.publish();
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
        gGr();
        this.qgc.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27875);
            View localView = RecordMsgBaseUI.this.qgc.getChildAt(RecordMsgBaseUI.this.qgc.getLastVisiblePosition());
            if ((localView != null) && (RecordMsgBaseUI.a(RecordMsgBaseUI.this) != null) && (RecordMsgBaseUI.a(RecordMsgBaseUI.this).getVisibility() == 0))
            {
              int j = localView.getBottom();
              int k = RecordMsgBaseUI.this.qgc.getBottom();
              Log.d("MicroMsg.RecordMsgBaseUI", "footerBotm %d, listBotm %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
              int i = a.fromDPToPix(RecordMsgBaseUI.this.getContext(), 64);
              if (k - j > 0)
              {
                j = k - j + a.fromDPToPix(RecordMsgBaseUI.this.getContext(), 15);
                Log.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[] { Integer.valueOf(j) });
                if (j > i) {
                  RecordMsgBaseUI.a(RecordMsgBaseUI.this).setPadding(0, j, 0, 0);
                }
              }
            }
            AppMethodBeat.o(27875);
          }
        }, 100L);
        return;
        localObject3 = localObject1.split(" ")[0];
        localObject4 = localObject2.split(" ")[0];
        if (!localObject1.split("-")[0].equals(localObject2.split("-")[0]))
        {
          this.NBE.NBw = true;
          break;
        }
        if (((String)localObject3).equals(localObject4))
        {
          this.NBE.NBx = false;
          break;
        }
        new StringBuilder().append((String)localObject3).append("~").append((String)localObject4);
        this.NBE.NBx = true;
        break;
        label649:
        localObject1 = aSK(localObject1.split(" ")[0]);
        localObject4 = aSK(localObject4.split(" ")[0]);
        if (((String)localObject1).equals(localObject4)) {}
        for (;;)
        {
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break;
          localObject1 = (String)localObject1 + " " + getString(R.l.time_to) + " " + (String)localObject4;
        }
        label742:
        localObject1 = ((g)localObject2).field_appName;
        break label262;
        label750:
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.s(this.appId, true, false);
        if ((localObject2 == null) || (((g)localObject2).field_appName == null) || (((g)localObject2).field_appName.trim().length() <= 0)) {}
        for (localObject1 = "";; localObject1 = ((g)localObject2).field_appName) {
          break;
        }
        label798:
        b((ImageView)localObject4, BitmapFactory.decodeResource(getResources(), R.g.nosdcard_watermark_icon));
      }
      label817:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  protected abstract h gGn();
  
  protected abstract String gGo();
  
  protected abstract String gGp();
  
  protected abstract String gGq();
  
  protected abstract void gGr();
  
  protected final void gGu()
  {
    String str2 = gGo();
    String str3 = getContext().getString(R.l.gHj);
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
    setMMTitle(p.d(getContext(), str1, getResources().getDimensionPixelSize(R.f.BigTextSize)));
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gnz;
  }
  
  protected abstract void i(int paramInt1, int paramInt2, Intent paramIntent);
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    i(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.pluginsdk.h.w(this);
    super.onCreate(paramBundle);
    gGm();
    this.NBG.alive();
    com.tencent.mm.pluginsdk.h.x(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.NBG.dead();
    if (this.NBE != null) {
      this.NBE.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.NBE != null)
    {
      localObject = this.NBE;
      int i = 0;
      while (i < ((h)localObject).NBv.size())
      {
        h.b localb = (h.b)((h)localObject).NBv.valueAt(i);
        if (localb != null) {
          localb.pause();
        }
        i += 1;
      }
    }
    Object localObject = new abi();
    ((abi)localObject).ieT.type = 1;
    ((abi)localObject).publish();
  }
  
  public void onResume()
  {
    super.onResume();
    abi localabi = new abi();
    if (this.qgc != null)
    {
      localabi.ieT.type = 0;
      localabi.ieT.ieU = this.qgc.getFirstVisiblePosition();
      localabi.ieT.ieV = this.qgc.getLastVisiblePosition();
      localabi.ieT.ieW = this.qgc.getHeaderViewsCount();
      localabi.publish();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
 * JD-Core Version:    0.7.0.1
 */