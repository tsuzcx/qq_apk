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
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class RecordMsgBaseUI
  extends BaseFavDetailReportUI
{
  protected String appId = "";
  protected long cpO = -1L;
  protected ListView gJa = null;
  private View pZA;
  protected h pZz;
  
  private void c(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)getResources().getDimension(2131427862);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected void cfU()
  {
    this.pZz = cfV();
    this.cpO = getIntent().getLongExtra("message_id", -1L);
    this.appId = getIntent().getStringExtra("record_app_id");
    this.gJa = ((ListView)findViewById(2131827122));
    cgc();
    Object localObject1 = cfX();
    Object localObject2 = cfY();
    View localView;
    if ((bo.isNullOrNil((String)localObject1)) || (bo.isNullOrNil((String)localObject2)))
    {
      ab.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      localObject1 = new View(getContext());
      ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(2131427825)));
      this.gJa.addHeaderView((View)localObject1, null, false);
      localView = View.inflate(getContext(), 2130970546, null);
      if (!bo.isNullOrNil(this.appId)) {
        break label572;
      }
      aw.aaz();
      localObject1 = c.YC().kB(this.cpO);
      localObject1 = j.b.ab(((dd)localObject1).field_content, ((dd)localObject1).field_reserved);
      if (localObject1 == null) {
        break label638;
      }
      this.appId = ((j.b)localObject1).appId;
      localObject2 = g.em(this.appId, ((j.b)localObject1).bDc);
      if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName.trim().length() > 0)) {
        break label564;
      }
      localObject1 = ((j.b)localObject1).appName;
    }
    for (;;)
    {
      label232:
      ImageView localImageView;
      if ((!bo.isNullOrNil(this.appId)) && (localObject2 != null))
      {
        this.pZA = localView.findViewById(2131827119);
        this.pZA.setVisibility(0);
        localImageView = (ImageView)localView.findViewById(2131827120);
        TextView localTextView = (TextView)localView.findViewById(2131827121);
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        int i = (int)(localTextView.getTextSize() * 1.5D);
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        localImageView.setLayoutParams(localLayoutParams);
        localObject1 = g.b(getContext(), (com.tencent.mm.pluginsdk.model.app.f)localObject2, (String)localObject1);
        localTextView.setText(getResources().getString(2131302038, new Object[] { localObject1 }));
        localObject1 = g.b(this.appId, 1, com.tencent.mm.cb.a.getDensity(getContext()));
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label619;
        }
        c(localImageView, (Bitmap)localObject1);
      }
      for (;;)
      {
        this.gJa.addFooterView(localView, null, false);
        this.gJa.setAdapter(this.pZz);
        this.pZz.mListView = this.gJa;
        this.pZz.cga();
        this.gJa.setOnScrollListener(new RecordMsgBaseUI.1(this));
        setBackBtn(new RecordMsgBaseUI.2(this));
        cfZ();
        this.gJa.postDelayed(new RecordMsgBaseUI.3(this), 100L);
        return;
        localObject1 = localObject1.split(" ")[0];
        localObject2 = localObject2.split(" ")[0];
        if (((String)localObject1).equals(localObject2)) {}
        for (this.pZz.pZt = false;; this.pZz.pZt = true)
        {
          setMMSubTitle((String)localObject1);
          break;
          localObject1 = (String)localObject1 + "~" + (String)localObject2;
        }
        label564:
        localObject1 = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName;
        break label232;
        label572:
        localObject2 = g.ca(this.appId, true);
        if ((localObject2 == null) || (((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName.trim().length() <= 0)) {}
        for (localObject1 = "";; localObject1 = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName) {
          break;
        }
        label619:
        c(localImageView, BitmapFactory.decodeResource(getResources(), 2130839824));
      }
      label638:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  protected abstract h cfV();
  
  protected abstract String cfW();
  
  protected abstract String cfX();
  
  protected abstract String cfY();
  
  protected abstract void cfZ();
  
  protected final void cgc()
  {
    String str2 = cfW();
    String str3 = getContext().getString(2131299503);
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
    setMMTitle(j.b(getContext(), str1, getResources().getDimensionPixelSize(2131427501)));
  }
  
  protected abstract void d(int paramInt1, int paramInt2, Intent paramIntent);
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970547;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.pluginsdk.f.m(this);
    super.onCreate(paramBundle);
    cfU();
    com.tencent.mm.pluginsdk.f.n(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.pZz != null) {
      this.pZz.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.pZz != null)
    {
      localObject = this.pZz;
      int i = 0;
      while (i < ((h)localObject).pZs.size())
      {
        h.b localb = (h.b)((h)localObject).pZs.valueAt(i);
        if (localb != null) {
          localb.pause();
        }
        i += 1;
      }
    }
    Object localObject = new ua();
    ((ua)localObject).cKz.type = 1;
    com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
  }
  
  public void onResume()
  {
    super.onResume();
    ua localua = new ua();
    if (this.gJa != null)
    {
      localua.cKz.type = 0;
      localua.cKz.cKA = this.gJa.getFirstVisiblePosition();
      localua.cKz.cKB = this.gJa.getLastVisiblePosition();
      localua.cKz.cKC = this.gJa.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.ymk.l(localua);
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