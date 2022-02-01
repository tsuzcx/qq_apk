package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ci.a;
import com.tencent.mm.f.a.hh;
import com.tencent.mm.f.a.zo;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class RecordMsgBaseUI
  extends BaseFavDetailReportUI
{
  protected h HEc;
  private View HEd;
  private IListener<hh> HEe = new IListener() {};
  protected String appId = "";
  protected long msgId = -1L;
  protected ListView niO = null;
  
  private String aVC(String paramString)
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
  
  protected abstract void f(int paramInt1, int paramInt2, Intent paramIntent);
  
  protected abstract String fuA();
  
  protected abstract String fuB();
  
  protected abstract void fuC();
  
  protected final void fuF()
  {
    String str2 = fuz();
    String str3 = getContext().getString(R.l.eEq);
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
    setMMTitle(l.d(getContext(), str1, getResources().getDimensionPixelSize(R.f.BigTextSize)));
  }
  
  protected void fux()
  {
    this.HEc = fuy();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.appId = getIntent().getStringExtra("record_app_id");
    this.niO = ((ListView)findViewById(R.h.dSA));
    fuF();
    Object localObject1 = fuA();
    Object localObject2 = fuB();
    Object localObject3;
    Object localObject4;
    if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil((String)localObject2)))
    {
      Log.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      localObject2 = View.inflate(getContext(), R.i.ekt, null);
      localObject3 = (TextView)((View)localObject2).findViewById(R.h.dXz);
      localObject1 = fuA();
      localObject4 = fuB();
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject4))) {
        break label645;
      }
      Log.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      this.niO.addHeaderView((View)localObject2, null, false);
      localObject3 = View.inflate(getContext(), R.i.eks, null);
      if (!Util.isNullOrNil(this.appId)) {
        break label746;
      }
      bh.beI();
      localObject1 = c.bbO().Oq(this.msgId);
      localObject1 = k.b.aG(((et)localObject1).field_content, ((et)localObject1).field_reserved);
      if (localObject1 == null) {
        break label813;
      }
      this.appId = ((k.b)localObject1).appId;
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.hn(this.appId, ((k.b)localObject1).appVersion);
      if ((localObject2 != null) && (((g)localObject2).field_appName != null) && (((g)localObject2).field_appName.trim().length() > 0)) {
        break label738;
      }
      localObject1 = ((k.b)localObject1).appName;
    }
    for (;;)
    {
      label258:
      if ((!Util.isNullOrNil(this.appId)) && (localObject2 != null))
      {
        this.HEd = ((View)localObject3).findViewById(R.h.dQE);
        this.HEd.setVisibility(0);
        localObject4 = (ImageView)((View)localObject3).findViewById(R.h.drU);
        TextView localTextView = (TextView)((View)localObject3).findViewById(R.h.drV);
        ViewGroup.LayoutParams localLayoutParams = ((ImageView)localObject4).getLayoutParams();
        int i = (int)(localTextView.getTextSize() * 1.5D);
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        ((ImageView)localObject4).setLayoutParams(localLayoutParams);
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (g)localObject2, (String)localObject1);
        localTextView.setText(getResources().getString(R.l.opensdk_source_tv_record, new Object[] { localObject1 }));
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.c(this.appId, 1, a.getDensity(getContext()));
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label794;
        }
        b((ImageView)localObject4, (Bitmap)localObject1);
      }
      for (;;)
      {
        this.niO.addFooterView((View)localObject3, null, false);
        this.niO.setAdapter(this.HEc);
        this.HEc.mListView = this.niO;
        this.HEc.fuD();
        this.HEc.HDZ = getIntent().getIntExtra("preChatTYPE", 0);
        this.niO.setOnScrollListener(new AbsListView.OnScrollListener()
        {
          public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            paramAnonymousInt2 = 0;
            AppMethodBeat.i(27873);
            if (paramAnonymousInt1 == 0)
            {
              paramAnonymousAbsListView = RecordMsgBaseUI.this.niO.getChildAt(0);
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
              paramAnonymousAbsListView = new zo();
              paramAnonymousAbsListView.fYR.type = 5;
              paramAnonymousAbsListView.fYR.fYS = RecordMsgBaseUI.this.niO.getFirstVisiblePosition();
              paramAnonymousAbsListView.fYR.fYT = RecordMsgBaseUI.this.niO.getLastVisiblePosition();
              paramAnonymousAbsListView.fYR.fYU = RecordMsgBaseUI.this.niO.getHeaderViewsCount();
              EventCenter.instance.publish(paramAnonymousAbsListView);
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
        fuC();
        this.niO.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27875);
            View localView = RecordMsgBaseUI.this.niO.getChildAt(RecordMsgBaseUI.this.niO.getLastVisiblePosition());
            if ((localView != null) && (RecordMsgBaseUI.a(RecordMsgBaseUI.this) != null) && (RecordMsgBaseUI.a(RecordMsgBaseUI.this).getVisibility() == 0))
            {
              int j = localView.getBottom();
              int k = RecordMsgBaseUI.this.niO.getBottom();
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
          this.HEc.HDU = true;
          break;
        }
        if (((String)localObject3).equals(localObject4))
        {
          this.HEc.HDV = false;
          break;
        }
        new StringBuilder().append((String)localObject3).append("~").append((String)localObject4);
        this.HEc.HDV = true;
        break;
        label645:
        localObject1 = aVC(localObject1.split(" ")[0]);
        localObject4 = aVC(localObject4.split(" ")[0]);
        if (((String)localObject1).equals(localObject4)) {}
        for (;;)
        {
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break;
          localObject1 = (String)localObject1 + " " + getString(R.l.time_to) + " " + (String)localObject4;
        }
        label738:
        localObject1 = ((g)localObject2).field_appName;
        break label258;
        label746:
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(this.appId, true, false);
        if ((localObject2 == null) || (((g)localObject2).field_appName == null) || (((g)localObject2).field_appName.trim().length() <= 0)) {}
        for (localObject1 = "";; localObject1 = ((g)localObject2).field_appName) {
          break;
        }
        label794:
        b((ImageView)localObject4, BitmapFactory.decodeResource(getResources(), R.g.nosdcard_watermark_icon));
      }
      label813:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  protected abstract h fuy();
  
  protected abstract String fuz();
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.eku;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    f(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.pluginsdk.h.r(this);
    super.onCreate(paramBundle);
    fux();
    this.HEe.alive();
    com.tencent.mm.pluginsdk.h.s(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.HEe.dead();
    if (this.HEc != null) {
      this.HEc.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.HEc != null)
    {
      localObject = this.HEc;
      int i = 0;
      while (i < ((h)localObject).HDT.size())
      {
        h.b localb = (h.b)((h)localObject).HDT.valueAt(i);
        if (localb != null) {
          localb.pause();
        }
        i += 1;
      }
    }
    Object localObject = new zo();
    ((zo)localObject).fYR.type = 1;
    EventCenter.instance.publish((IEvent)localObject);
  }
  
  public void onResume()
  {
    super.onResume();
    zo localzo = new zo();
    if (this.niO != null)
    {
      localzo.fYR.type = 0;
      localzo.fYR.fYS = this.niO.getFirstVisiblePosition();
      localzo.fYR.fYT = this.niO.getLastVisiblePosition();
      localzo.fYR.fYU = this.niO.getHeaderViewsCount();
      EventCenter.instance.publish(localzo);
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