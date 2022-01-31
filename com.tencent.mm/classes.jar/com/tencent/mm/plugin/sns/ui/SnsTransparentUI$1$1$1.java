package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class SnsTransparentUI$1$1$1
  implements f.a
{
  SnsTransparentUI$1$1$1(SnsTransparentUI.1.1 param1, WXMediaMessage paramWXMediaMessage, String paramString) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(39631);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      SnsTransparentUI.a(this.saN.saL.saK).put(this.saN.saL.saG, paramString);
      if ((paramString != null) && (!paramString.isRecycled()))
      {
        ab.i("SnsTransparentUI", "thumb image is not null");
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramString.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
        this.saM.thumbData = localByteArrayOutputStream.toByteArray();
      }
      paramString = new qg();
      paramString.cGL.cyF = this.saM;
      paramString.cGL.toUser = this.saN.bZZ;
      paramString.cGL.cGM = 49;
      paramString.cGL.cGN = "";
      paramString.cGL.cGO = "";
      paramString.cGL.cGU = this.saN.saL.saJ;
      a.ymk.l(paramString);
      if (!TextUtils.isEmpty(this.val$text))
      {
        paramString = new qj();
        paramString.cGX.cGY = this.saN.bZZ;
        paramString.cGX.content = this.val$text;
        paramString.cGX.type = t.oF(this.saN.bZZ);
        paramString.cGX.flags = 0;
        a.ymk.l(paramString);
      }
      h.bO(this.saN.val$context, this.saN.val$context.getString(2131297076));
      this.saN.saL.saK.finish();
      AppMethodBeat.o(39631);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("SnsTransparentUI", "this has a error : " + paramString.toString());
      this.saN.saL.saK.finish();
      AppMethodBeat.o(39631);
    }
  }
  
  public final void coe()
  {
    AppMethodBeat.i(39630);
    h.bO(this.saN.val$context, this.saN.val$context.getString(2131303663));
    this.saN.saL.saK.finish();
    AppMethodBeat.o(39630);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI.1.1.1
 * JD-Core Version:    0.7.0.1
 */