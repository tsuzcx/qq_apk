package com.tencent.mm.plugin.scanner.history.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.a.g;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.history.a.b;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.s;

final class ScannerHistoryUI$a
  extends r<com.tencent.mm.plugin.scanner.history.a.a>
{
  public ScannerHistoryUI$a(ScannerHistoryUI paramScannerHistoryUI)
  {
    super(paramScannerHistoryUI, new com.tencent.mm.plugin.scanner.history.a.a());
    mR(true);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (com.tencent.mm.plugin.scanner.history.a.a)getItem(paramInt);
    o.a locala;
    int i;
    c.a locala1;
    String str;
    if (paramView == null)
    {
      paramView = View.inflate(this.nGx.mController.uMN, R.i.scan_history_item_layout, null);
      paramViewGroup = new ScannerHistoryUI.b(this.nGx, (byte)0);
      paramViewGroup.hic = ((ImageView)paramView.findViewById(R.h.item_icon));
      paramViewGroup.iwq = ((TextView)paramView.findViewById(R.h.item_title));
      paramViewGroup.iwr = ((TextView)paramView.findViewById(R.h.item_time));
      paramViewGroup.iws = ((TextView)paramView.findViewById(R.h.item_desc));
      paramView.setTag(paramViewGroup);
      locala = j.cm(((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_xmlContent, ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_funcType);
      paramViewGroup.iwq.setText(locala.field_title);
      long l = ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_ScanTime;
      paramViewGroup.iwr.setText(h.c(this.nGx, l, true));
      paramViewGroup.iws.setText(locala.field_subtitle);
      i = this.nGx.getResources().getDimensionPixelSize(R.f.scan_history_icon_size);
      paramViewGroup.hic.setImageResource(R.g.pic_thumb_bg);
      y.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + paramInt + " logo_url :  " + locala.field_thumburl);
      if (TextUtils.isEmpty(locala.field_thumburl)) {
        break label424;
      }
      locala1 = new c.a();
      locala1.eri = e.bkH;
      o.OO();
      locala1.erB = null;
      localObject = com.tencent.mm.plugin.scanner.c.bxd();
      str = locala.field_thumburl;
      if (!au.DK()) {
        break label416;
      }
    }
    label416:
    for (localObject = String.format("%s/scanbook_%s", new Object[] { ((com.tencent.mm.plugin.scanner.c)localObject).dKt + "image/scan/img", g.o(str.getBytes()) });; localObject = "")
    {
      locala1.erh = ((String)localObject);
      locala1.erf = true;
      locala1.erD = false;
      locala1.erd = true;
      locala1.erm = i;
      locala1.erl = i;
      locala1.eru = R.g.pic_thumb_bg;
      localObject = locala1.OV();
      o.ON().a(locala.field_thumburl, paramViewGroup.hic, (com.tencent.mm.as.a.a.c)localObject);
      return paramView;
      paramViewGroup = (ScannerHistoryUI.b)paramView.getTag();
      break;
    }
    label424:
    paramViewGroup.hic.setImageResource(R.g.pic_thumb_bg);
    return paramView;
  }
  
  public final void yc()
  {
    setCursor(com.tencent.mm.plugin.scanner.c.bxe().aAn());
    notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.a
 * JD-Core Version:    0.7.0.1
 */