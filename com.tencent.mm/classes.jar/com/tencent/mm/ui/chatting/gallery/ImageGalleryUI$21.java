package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.5;
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.b;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

final class ImageGalleryUI$21
  implements o.f
{
  ImageGalleryUI$21(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(233331);
    paramm.clear();
    if ((ImageGalleryUI.d(this.PzQ, 2)) && (ImageGalleryUI.c(this.PzQ, ImageGalleryUI.b(this.PzQ).CFJ)))
    {
      ScanCodeSheetItemLogic localScanCodeSheetItemLogic = ImageGalleryUI.e(this.PzQ);
      int i = ImageGalleryUI.b(this.PzQ).dFL;
      String str = ImageGalleryUI.b(this.PzQ).CFJ;
      Object localObject1 = ImageGalleryUI.d(this.PzQ);
      if ((localScanCodeSheetItemLogic.CAh == null) || ((!Util.isEqual(localScanCodeSheetItemLogic.CAh.LRh, str)) && (localScanCodeSheetItemLogic.CAh != localScanCodeSheetItemLogic.CAi)))
      {
        if (g.ci(i, str))
        {
          localObject1 = new com.tencent.mm.ui.base.n(paramm.mContext, 3, 0);
          ((com.tencent.mm.ui.base.n)localObject1).Bno = true;
          paramm.ORD.add(localObject1);
          AppMethodBeat.o(233331);
          return;
        }
        paramm.b(3, localScanCodeSheetItemLogic.Wp(i), 2131690890);
        AppMethodBeat.o(233331);
        return;
      }
      if ((localScanCodeSheetItemLogic.CAh.Ret != 0) || (Util.isNullOrNil(localScanCodeSheetItemLogic.CAh.UserName)))
      {
        if ((g.cb(i, str)) || (g.cd(i, str)) || (g.cc(i, str)) || (g.ce(i, str)))
        {
          paramm.a(3, localScanCodeSheetItemLogic.mContext.getString(2131764926), 2131690890, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099746));
          AppMethodBeat.o(233331);
          return;
        }
        if (g.ca(i, str))
        {
          paramm.a(3, localScanCodeSheetItemLogic.mContext.getString(2131764928), 2131690890, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099746));
          AppMethodBeat.o(233331);
          return;
        }
        if (g.ch(i, str))
        {
          paramm.a(3, localScanCodeSheetItemLogic.mContext.getString(2131764925), 2131690940, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099746));
          AppMethodBeat.o(233331);
          return;
        }
        if (g.cg(i, str))
        {
          paramm.a(3, localScanCodeSheetItemLogic.mContext.getString(2131764927), 2131690875, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099746));
          AppMethodBeat.o(233331);
          return;
        }
        localObject1 = localScanCodeSheetItemLogic.mContext.getString(2131764926);
        if (!e.d.ahw(i)) {
          localObject1 = localScanCodeSheetItemLogic.mContext.getString(2131764924);
        }
        paramm.a(3, (CharSequence)localObject1, 2131690890, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099746));
        AppMethodBeat.o(233331);
        return;
      }
      str = localScanCodeSheetItemLogic.CAh.UserName;
      Object localObject2 = new ScanCodeSheetItemLogic.5(localScanCodeSheetItemLogic);
      ((e)localObject1).QNQ = ((o.b)localObject2);
      ((e)localObject1).QNP = ((o.b)localObject2);
      if (localScanCodeSheetItemLogic.CAh.Mcw == 4)
      {
        paramm.a(str, localScanCodeSheetItemLogic.mContext.getString(2131764880), 0);
        AppMethodBeat.o(233331);
        return;
      }
      if (localScanCodeSheetItemLogic.CAh.Mcw == 3)
      {
        paramm.a(str, localScanCodeSheetItemLogic.mContext.getString(2131764892), 0);
        AppMethodBeat.o(233331);
        return;
      }
      if (localScanCodeSheetItemLogic.CAh.Mcw == 1)
      {
        paramm.a(str, localScanCodeSheetItemLogic.mContext.getString(2131764965), 0);
        AppMethodBeat.o(233331);
        return;
      }
      if (localScanCodeSheetItemLogic.CAh.Mcw == 2)
      {
        paramm.a(str, localScanCodeSheetItemLogic.mContext.getString(2131764921), localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099746));
        AppMethodBeat.o(233331);
        return;
      }
      if (localScanCodeSheetItemLogic.CAh.Mcw == 7)
      {
        localObject1 = new SpannableStringBuilder();
        str = str + " ";
        ((SpannableStringBuilder)localObject1).append(str);
        localObject2 = "@" + localScanCodeSheetItemLogic.CAh.Mcy;
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099792)), str.length(), str.length() + ((String)localObject2).length(), 33);
        paramm.a((CharSequence)localObject1, localScanCodeSheetItemLogic.mContext.getString(2131765002), 0);
        AppMethodBeat.o(233331);
        return;
      }
      if (localScanCodeSheetItemLogic.CAh.Mcw == 6)
      {
        paramm.a(Util.safeFormatString(localScanCodeSheetItemLogic.mContext.getString(2131764964), new Object[] { localScanCodeSheetItemLogic.CAh.UserName }), localScanCodeSheetItemLogic.mContext.getString(2131764963), localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099746));
        AppMethodBeat.o(233331);
        return;
      }
      if (localScanCodeSheetItemLogic.CAh.Mcw == 5) {
        paramm.a(Util.safeFormatString(localScanCodeSheetItemLogic.mContext.getString(2131764986), new Object[] { localScanCodeSheetItemLogic.CAh.UserName }), localScanCodeSheetItemLogic.mContext.getString(2131764985), localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099746));
      }
    }
    AppMethodBeat.o(233331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.21
 * JD-Core Version:    0.7.0.1
 */