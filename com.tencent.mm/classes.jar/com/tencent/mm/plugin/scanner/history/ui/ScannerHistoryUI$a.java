package com.tencent.mm.plugin.scanner.history.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.p;

final class ScannerHistoryUI$a
  extends p<com.tencent.mm.plugin.scanner.history.a.a>
{
  public ScannerHistoryUI$a(ScannerHistoryUI paramScannerHistoryUI)
  {
    super(paramScannerHistoryUI, new com.tencent.mm.plugin.scanner.history.a.a());
    AppMethodBeat.i(80807);
    qp(true);
    AppMethodBeat.o(80807);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(80808);
    setCursor(com.tencent.mm.plugin.scanner.e.chX().cib().getAll());
    notifyDataSetChanged();
    AppMethodBeat.o(80808);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(80809);
    bKb();
    Ku();
    AppMethodBeat.o(80809);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(80810);
    Object localObject = (com.tencent.mm.plugin.scanner.history.a.a)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.qtO.getContext(), 2130970602, null);
      paramViewGroup = new ScannerHistoryUI.b(this.qtO, (byte)0);
      paramViewGroup.iTH = ((ImageView)paramView.findViewById(2131823589));
      paramViewGroup.kxu = ((TextView)paramView.findViewById(2131823680));
      paramViewGroup.kxv = ((TextView)paramView.findViewById(2131824193));
      paramViewGroup.kxw = ((TextView)paramView.findViewById(2131826402));
      paramView.setTag(paramViewGroup);
      q.a locala = k.dg(((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_xmlContent, ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_funcType);
      paramViewGroup.kxu.setText(locala.field_title);
      long l = ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_ScanTime;
      paramViewGroup.kxv.setText(h.c(this.qtO, l, true));
      paramViewGroup.kxw.setText(locala.field_subtitle);
      int i = this.qtO.getResources().getDimensionPixelSize(2131428648);
      paramViewGroup.iTH.setImageResource(2130839944);
      ab.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + paramInt + " logo_url :  " + locala.field_thumburl);
      if (TextUtils.isEmpty(locala.field_thumburl)) {
        break label423;
      }
      c.a locala1 = new c.a();
      locala1.eNP = com.tencent.mm.compatible.util.e.eQz;
      o.ahH();
      locala1.eOd = null;
      localObject = com.tencent.mm.plugin.scanner.e.chX();
      String str = locala.field_thumburl;
      if (!com.tencent.mm.kernel.g.RG()) {
        break label415;
      }
      localObject = String.format("%s/scanbook_%s", new Object[] { ((com.tencent.mm.plugin.scanner.e)localObject).eHR + "image/scan/img", com.tencent.mm.a.g.w(str.getBytes()) });
      label327:
      locala1.eNO = ((String)localObject);
      locala1.eNM = true;
      locala1.eOk = false;
      locala1.eNK = true;
      locala1.eNT = i;
      locala1.eNS = i;
      locala1.eNY = 2130839944;
      localObject = locala1.ahY();
      o.ahG().a(locala.field_thumburl, paramViewGroup.iTH, (c)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(80810);
      return paramView;
      paramViewGroup = (ScannerHistoryUI.b)paramView.getTag();
      break;
      label415:
      localObject = "";
      break label327;
      label423:
      paramViewGroup.iTH.setImageResource(2130839944);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.a
 * JD-Core Version:    0.7.0.1
 */