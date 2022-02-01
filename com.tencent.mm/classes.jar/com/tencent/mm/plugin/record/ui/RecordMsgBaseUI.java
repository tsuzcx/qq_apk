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
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
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
  protected h BHV;
  private View BHW;
  private IListener<ha> BHX = new IListener() {};
  protected String appId = "";
  protected ListView krb = null;
  protected long msgId = -1L;
  
  private String aLb(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime();
      String str = (String)DateFormat.format(getContext().getString(2131760832), l);
      return str;
    }
    catch (ParseException localParseException) {}
    return paramString;
  }
  
  private void b(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)getResources().getDimension(2131165594);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected final void eIA()
  {
    String str2 = eIu();
    String str3 = getContext().getString(2131758945);
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
    setMMTitle(l.e(getContext(), str1, getResources().getDimensionPixelSize(2131165195)));
  }
  
  protected void eIs()
  {
    this.BHV = eIt();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.appId = getIntent().getStringExtra("record_app_id");
    this.krb = ((ListView)findViewById(2131306731));
    eIA();
    Object localObject2 = eIv();
    Object localObject3 = eIw();
    Object localObject1;
    Object localObject4;
    if ((Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject3)))
    {
      Log.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      localObject2 = View.inflate(getContext(), 2131496065, null);
      localObject3 = (TextView)((View)localObject2).findViewById(2131309247);
      localObject1 = eIv();
      localObject4 = eIw();
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject4))) {
        break label652;
      }
      Log.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      this.krb.addHeaderView((View)localObject2, null, false);
      localObject3 = View.inflate(getContext(), 2131496064, null);
      if (!Util.isNullOrNil(this.appId)) {
        break label753;
      }
      bg.aVF();
      localObject1 = c.aSQ().Hb(this.msgId);
      localObject1 = k.b.aD(((eo)localObject1).field_content, ((eo)localObject1).field_reserved);
      if (localObject1 == null) {
        break label820;
      }
      this.appId = ((k.b)localObject1).appId;
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.gE(this.appId, ((k.b)localObject1).appVersion);
      if ((localObject2 != null) && (((g)localObject2).field_appName != null) && (((g)localObject2).field_appName.trim().length() > 0)) {
        break label745;
      }
      localObject1 = ((k.b)localObject1).appName;
    }
    for (;;)
    {
      label256:
      if ((!Util.isNullOrNil(this.appId)) && (localObject2 != null))
      {
        this.BHW = ((View)localObject3).findViewById(2131305637);
        this.BHW.setVisibility(0);
        localObject4 = (ImageView)((View)localObject3).findViewById(2131297038);
        TextView localTextView = (TextView)((View)localObject3).findViewById(2131297039);
        ViewGroup.LayoutParams localLayoutParams = ((ImageView)localObject4).getLayoutParams();
        int i = (int)(localTextView.getTextSize() * 1.5D);
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        ((ImageView)localObject4).setLayoutParams(localLayoutParams);
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (g)localObject2, (String)localObject1);
        localTextView.setText(getResources().getString(2131763802, new Object[] { localObject1 }));
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.c(this.appId, 1, a.getDensity(getContext()));
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label801;
        }
        b((ImageView)localObject4, (Bitmap)localObject1);
      }
      for (;;)
      {
        this.krb.addFooterView((View)localObject3, null, false);
        this.krb.setAdapter(this.BHV);
        this.BHV.mListView = this.krb;
        this.BHV.eIy();
        this.BHV.BHS = getIntent().getIntExtra("preChatTYPE", 0);
        this.krb.setOnScrollListener(new RecordMsgBaseUI.2(this));
        setBackBtn(new RecordMsgBaseUI.3(this));
        eIx();
        this.krb.postDelayed(new RecordMsgBaseUI.4(this), 100L);
        return;
        localObject1 = localObject2.split(" ")[0];
        localObject4 = localObject3.split(" ")[0];
        if (!localObject2.split("-")[0].equals(localObject3.split("-")[0]))
        {
          this.BHV.BHN = true;
          localObject1 = null;
        }
        for (;;)
        {
          setMMSubTitle((String)localObject1);
          break;
          if (((String)localObject1).equals(localObject4))
          {
            this.BHV.BHO = false;
          }
          else
          {
            localObject1 = (String)localObject1 + "~" + (String)localObject4;
            this.BHV.BHO = true;
          }
        }
        label652:
        localObject1 = aLb(localObject1.split(" ")[0]);
        localObject4 = aLb(localObject4.split(" ")[0]);
        if (((String)localObject1).equals(localObject4)) {}
        for (;;)
        {
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break;
          localObject1 = (String)localObject1 + " " + getString(2131766777) + " " + (String)localObject4;
        }
        label745:
        localObject1 = ((g)localObject2).field_appName;
        break label256;
        label753:
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(this.appId, true, false);
        if ((localObject2 == null) || (((g)localObject2).field_appName == null) || (((g)localObject2).field_appName.trim().length() <= 0)) {}
        for (localObject1 = "";; localObject1 = ((g)localObject2).field_appName) {
          break;
        }
        label801:
        b((ImageView)localObject4, BitmapFactory.decodeResource(getResources(), 2131234282));
      }
      label820:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  protected abstract h eIt();
  
  protected abstract String eIu();
  
  protected abstract String eIv();
  
  protected abstract String eIw();
  
  protected abstract void eIx();
  
  protected abstract void f(int paramInt1, int paramInt2, Intent paramIntent);
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496066;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    f(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    eIs();
    this.BHX.alive();
    com.tencent.mm.pluginsdk.h.r(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.BHX.dead();
    if (this.BHV != null) {
      this.BHV.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.BHV != null)
    {
      localObject = this.BHV;
      int i = 0;
      while (i < ((h)localObject).BHM.size())
      {
        h.b localb = (h.b)((h)localObject).BHM.valueAt(i);
        if (localb != null) {
          localb.pause();
        }
        i += 1;
      }
    }
    Object localObject = new yh();
    ((yh)localObject).eeC.type = 1;
    EventCenter.instance.publish((IEvent)localObject);
  }
  
  public void onResume()
  {
    super.onResume();
    yh localyh = new yh();
    if (this.krb != null)
    {
      localyh.eeC.type = 0;
      localyh.eeC.eeD = this.krb.getFirstVisiblePosition();
      localyh.eeC.eeE = this.krb.getLastVisiblePosition();
      localyh.eeC.eeF = this.krb.getHeaderViewsCount();
      EventCenter.instance.publish(localyh);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
 * JD-Core Version:    0.7.0.1
 */