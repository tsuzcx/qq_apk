package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zl;
import com.tencent.mm.autogen.mmdata.rpt.py;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.cedit.api.c;
import java.io.IOException;
import java.util.ArrayList;

final class SnsUploadUI$5$1
  implements c.a
{
  SnsUploadUI$5$1(SnsUploadUI.5 param5) {}
  
  public final void Tw(String paramString)
  {
    AppMethodBeat.i(369949);
    Log.i("MicroMsg.SnsUploadUI", "commit after check");
    SnsUploadUI.a(this.akiT.REd, 3);
    SnsUploadUI.u(this.akiT.REd);
    int i = SnsUploadUI.v(this.akiT.REd).getSyncFlag();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().B(68404, Integer.valueOf(i));
    SnsUploadUI.c(this.akiT.REd, SnsUploadUI.a(this.akiT.REd).getText().toString());
    int j = 0;
    if (TextUtils.equals(SnsUploadUI.w(this.akiT.REd), SnsUploadUI.a(this.akiT.REd).getPasterContent()))
    {
      Log.i("MicroMsg.SnsUploadUI", "paste clip board to send");
      j = 1;
    }
    boolean bool1 = SnsUploadUI.a(this.akiT.REd).getSimilarPasteChange();
    paramString = SnsUploadUI.a(this.akiT.REd).getSimilarPasteSeqStr();
    boolean bool2 = ClipboardHelper.isCopyFromWX(SnsUploadUI.a(this.akiT.REd).getText());
    SnsUploadUI.a(this.akiT.REd).jFl();
    i = 0;
    if (j != 0)
    {
      if (bool2)
      {
        i = 4;
        i |= 0x0;
      }
    }
    else
    {
      if (!bool1) {
        break label1392;
      }
      if (!bool2) {
        break label1142;
      }
      j = 16;
      i = j | i;
    }
    label1291:
    label1296:
    label1301:
    label1349:
    label1392:
    for (;;)
    {
      com.tencent.mm.plugin.sns.l.a.P(1, i, paramString);
      i = SnsUploadUI.a(this.akiT.REd).getPasterLen();
      j = SnsUploadUI.v(this.akiT.REd).getPrivated();
      int k = SnsUploadUI.v(this.akiT.REd).getSyncFlag();
      SnsUploadUI.x(this.akiT.REd);
      if (SnsUploadUI.y(this.akiT.REd)) {
        this.akiT.REd.setResult(-1, new Intent());
      }
      if ((SnsUploadUI.b(this.akiT.REd) instanceof at)) {
        ((at)SnsUploadUI.b(this.akiT.REd)).Ric = SnsUploadUI.z(this.akiT.REd).getCurLocation();
      }
      if ((SnsUploadUI.b(this.akiT.REd) instanceof ap)) {
        SnsUploadUI.a(this.akiT.REd).setText("");
      }
      SnsUploadUI.A(this.akiT.REd);
      paramString = new PInt();
      Object localObject;
      if ((SnsUploadUI.b(this.akiT.REd) instanceof a))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("param_is_privated", j);
        ((Bundle)localObject).putString("param_description", SnsUploadUI.w(this.akiT.REd));
        ((Bundle)localObject).putStringArrayList("param_with_list", new ArrayList(SnsUploadUI.B(this.akiT.REd).getAtList()));
        ((Bundle)localObject).putInt("param_paste_len", i);
      }
      for (;;)
      {
        try
        {
          ((Bundle)localObject).putByteArray("param_localtion", SnsUploadUI.z(this.akiT.REd).getLocation().toByteArray());
          ((Bundle)localObject).putBoolean("param_is_black_group", SnsUploadUI.C(this.akiT.REd));
          ((Bundle)localObject).putStringArrayList("param_group_user", SnsUploadUI.D(this.akiT.REd));
          ((Bundle)localObject).putInt("param_contact_tag_count", SnsUploadUI.E(this.akiT.REd));
          ((Bundle)localObject).putInt("param_temp_user_count", SnsUploadUI.F(this.akiT.REd));
          paramString.value = ((a)SnsUploadUI.b(this.akiT.REd)).hlr();
          SnsUploadUI.b(this.akiT.REd);
          SnsUploadUI.H(this.akiT.REd);
          localObject = com.tencent.mm.plugin.report.service.h.OAn;
          long l1 = SnsUploadUI.I(this.akiT.REd);
          long l2 = Util.nowSecond();
          if (!SnsUploadUI.J(this.akiT.REd)) {
            break label1291;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject).b(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramString.value), "" });
          l1 = SnsUploadUI.I(this.akiT.REd);
          l2 = Util.nowSecond();
          if (!SnsUploadUI.J(this.akiT.REd)) {
            break label1296;
          }
          i = 0;
          Log.d("MicroMsg.SnsUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramString.value) });
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10910, "1");
          if (!Util.isNullOrNil(SnsUploadUI.K(this.akiT.REd)))
          {
            if (!SnsUploadUI.C(this.akiT.REd)) {
              break label1301;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(11455, new Object[] { "", SnsUploadUI.K(this.akiT.REd), Integer.valueOf(-1), Integer.valueOf(-1) });
          }
          if (SnsUploadUI.L(this.akiT.REd))
          {
            localObject = new Intent(this.akiT.REd, SnsTimeLineUI.class);
            ((Intent)localObject).putExtra("sns_resume_state", false);
            ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
            ((Intent)localObject).addFlags(67108864);
            paramString = this.akiT.REd;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$13$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$13$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          r.bU(this.akiT.REd.getIntent());
          new zl().publish();
          SnsUploadUI.b(this.akiT.REd, 1);
          SnsUploadUI.l(this.akiT.REd);
          if (!SnsUploadUI.m(this.akiT.REd)) {
            break label1349;
          }
          j.QFS.QGE.jpR = 1L;
          j.QFS.QGE.xe(t.heR());
          t.heS();
          AppMethodBeat.o(369949);
          return;
          i = 8;
          break;
          label1142:
          j = 32;
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.SnsUploadUI", localIOException, "parse location error", new Object[0]);
          continue;
        }
        SnsUploadUI.b(this.akiT.REd).a(j, k, SnsUploadUI.v(this.akiT.REd).getTwitterAccessToken(), SnsUploadUI.w(this.akiT.REd), SnsUploadUI.B(this.akiT.REd).getAtList(), SnsUploadUI.z(this.akiT.REd).getLocation(), null, i, SnsUploadUI.C(this.akiT.REd), SnsUploadUI.D(this.akiT.REd), paramString, SnsUploadUI.G(this.akiT.REd), SnsUploadUI.E(this.akiT.REd), SnsUploadUI.F(this.akiT.REd));
        continue;
        i = 1;
        continue;
        i = 1;
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.b(11455, new Object[] { SnsUploadUI.K(this.akiT.REd), "", Integer.valueOf(-1), Integer.valueOf(-1) });
        continue;
        j.QFS.QGE.xe(SnsUploadUI.k(this.akiT.REd));
        j.QFS.QGD.xe(SnsUploadUI.k(this.akiT.REd));
      }
    }
  }
  
  public final void Tx(String paramString) {}
  
  public final void eY(String paramString)
  {
    AppMethodBeat.i(369950);
    k.s(this.akiT.REd, b.j.sns_upload_post_text_invalid_more, b.j.sns_upload_post_text_invalid_title);
    AppMethodBeat.o(369950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.5.1
 * JD-Core Version:    0.7.0.1
 */