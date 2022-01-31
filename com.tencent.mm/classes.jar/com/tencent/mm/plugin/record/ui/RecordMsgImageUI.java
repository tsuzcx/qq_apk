package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class RecordMsgImageUI
  extends MMActivity
  implements com.tencent.mm.plugin.record.a.c
{
  private long bIt = -1L;
  private List<xv> drc = new LinkedList();
  private j gGp;
  private MMGestureGallery itv;
  private n.d jfN = new RecordMsgImageUI.9(this);
  private Map<String, nb> kbT = new HashMap();
  private com.tencent.mm.sdk.b.c kbV = new RecordMsgImageUI.3(this);
  private Runnable kbl = new RecordMsgImageUI.2(this);
  private com.tencent.mm.plugin.record.b.f nud;
  private RecordMsgImageUI.a nuk;
  private int nul = 0;
  private String nun = null;
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.f paramf)
  {
    Iterator localIterator = this.drc.iterator();
    while (localIterator.hasNext()) {
      if (((xv)localIterator.next()).kgC.equals(paramf.field_dataId)) {
        ai.d(this.kbl);
      }
    }
  }
  
  final String bvO()
  {
    int i = this.itv.getSelectedItemPosition();
    if (-1 == i)
    {
      y.w("MicroMsg.ShowImageUI", "error position");
      return null;
    }
    String str = com.tencent.mm.plugin.record.b.h.c(this.nuk.wC(i), this.bIt);
    y.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[] { Integer.valueOf(i), str });
    return str;
  }
  
  protected final void dealContentView(View paramView)
  {
    ak.g(ak.a(getWindow(), null), this.mController.uMz);
    ((ViewGroup)this.mController.uMz.getParent()).removeView(this.mController.uMz);
    ((ViewGroup)getWindow().getDecorView()).addView(this.mController.uMz, 0);
  }
  
  protected final int getLayoutId()
  {
    return R.i.show_image_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((1001 == paramInt1) && (-1 == paramInt2))
    {
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label46;
        }
      }
      label46:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        if (!bk.bl((String)localObject)) {
          break label57;
        }
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label57:
      Object localObject = bk.G(((String)localObject).split(","));
      if (bk.dk((List)localObject))
      {
        y.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
        return;
      }
      RecordMsgImageUI.10 local10 = new RecordMsgImageUI.10(this, com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(R.l.favorite_forward_tips), false, null));
      au.DS().O(new RecordMsgImageUI.11(this, (List)localObject, paramIntent, local10));
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    this.nud = new com.tencent.mm.plugin.record.b.f();
    this.bIt = getIntent().getLongExtra("message_id", -1L);
    paramBundle = getIntent().getStringExtra("record_data_id");
    Object localObject = com.tencent.mm.plugin.record.b.h.LH(getIntent().getStringExtra("record_xml"));
    if (localObject == null)
    {
      y.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
      finish();
      return;
    }
    localObject = ((com.tencent.mm.protocal.b.a.c)localObject).dTx.iterator();
    while (((Iterator)localObject).hasNext())
    {
      xv localxv = (xv)((Iterator)localObject).next();
      if (localxv.aYU == 2)
      {
        this.drc.add(localxv);
        if (localxv.kgC.equals(paramBundle)) {
          this.nul = (this.drc.size() - 1);
        }
      }
    }
    if (this.drc.isEmpty())
    {
      y.w("MicroMsg.ShowImageUI", "get image data error, empty");
      finish();
      return;
    }
    this.itv = ((MMGestureGallery)findViewById(R.h.gallery));
    this.itv.setVerticalFadingEdgeEnabled(false);
    this.itv.setHorizontalFadingEdgeEnabled(false);
    this.nuk = new RecordMsgImageUI.a((byte)0);
    this.nuk.drc = this.drc;
    this.nuk.bIt = this.bIt;
    this.nuk.nud = this.nud;
    this.itv.setAdapter(this.nuk);
    this.itv.setSelection(this.nul);
    this.itv.setOnItemSelectedListener(new RecordMsgImageUI.1(this));
    this.itv.setSingleClickOverListener(new RecordMsgImageUI.4(this));
    this.itv.setLongClickOverListener(new RecordMsgImageUI.5(this));
    fullScreenNoTitleBar(true);
    setBackBtn(new RecordMsgImageUI.6(this));
    n.getRecordMsgCDNStorage().a(this);
    com.tencent.mm.sdk.b.a.udP.c(this.kbV);
  }
  
  protected void onDestroy()
  {
    n.getRecordMsgCDNStorage().b(this);
    this.nud.destory();
    com.tencent.mm.sdk.b.a.udP.d(this.kbV);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI
 * JD-Core Version:    0.7.0.1
 */