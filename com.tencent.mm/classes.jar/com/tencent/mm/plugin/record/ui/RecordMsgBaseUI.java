package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.si;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public abstract class RecordMsgBaseUI
  extends BaseFavDetailReportUI
{
  protected long bIt = -1L;
  protected ListView fry = null;
  protected h ntS;
  
  protected void bvD()
  {
    this.ntS = bvE();
    this.bIt = getIntent().getLongExtra("message_id", -1L);
    this.fry = ((ListView)findViewById(R.h.record_listview));
    bvL();
    Object localObject = bvG();
    String str = bvH();
    if ((bk.bl((String)localObject)) || (bk.bl(str)))
    {
      y.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
      localObject = new View(this.mController.uMN);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.f.RecordListTopMargin)));
      this.fry.addHeaderView((View)localObject, null, false);
      localObject = View.inflate(this.mController.uMN, R.i.record_listview_footer, null);
      this.fry.setAdapter(this.ntS);
      this.ntS.Nn = this.fry;
      this.ntS.bvJ();
      this.fry.setOnScrollListener(new RecordMsgBaseUI.1(this));
      setBackBtn(new RecordMsgBaseUI.2(this));
      bvI();
      this.fry.postDelayed(new RecordMsgBaseUI.3(this, (View)localObject), 100L);
      return;
    }
    localObject = localObject.split(" ")[0];
    str = str.split(" ")[0];
    if (((String)localObject).equals(str)) {}
    for (this.ntS.ntM = false;; this.ntS.ntM = true)
    {
      setMMSubTitle((String)localObject);
      break;
      localObject = (String)localObject + "~" + str;
    }
  }
  
  protected abstract h bvE();
  
  protected abstract String bvF();
  
  protected abstract String bvG();
  
  protected abstract String bvH();
  
  protected abstract void bvI();
  
  protected final void bvL()
  {
    String str2 = bvF();
    String str3 = this.mController.uMN.getString(R.l.expose_example);
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
    N(j.b(this.mController.uMN, str1, getResources().getDimensionPixelSize(R.f.BigTextSize)));
  }
  
  protected abstract void d(int paramInt1, int paramInt2, Intent paramIntent);
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.record_msg_detail_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    e.k(this);
    super.onCreate(paramBundle);
    bvD();
    e.l(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.ntS != null) {
      this.ntS.destroy();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.ntS != null)
    {
      localObject = this.ntS;
      int i = 0;
      while (i < ((h)localObject).ntL.size())
      {
        h.b localb = (h.b)((h)localObject).ntL.valueAt(i);
        if (localb != null) {
          localb.pause();
        }
        i += 1;
      }
    }
    Object localObject = new si();
    ((si)localObject).cbT.type = 1;
    a.udP.m((b)localObject);
  }
  
  protected void onResume()
  {
    super.onResume();
    si localsi = new si();
    if (this.fry != null)
    {
      localsi.cbT.type = 0;
      localsi.cbT.cbU = this.fry.getFirstVisiblePosition();
      localsi.cbT.cbV = this.fry.getLastVisiblePosition();
      localsi.cbT.cbW = this.fry.getHeaderViewsCount();
      a.udP.m(localsi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
 * JD-Core Version:    0.7.0.1
 */