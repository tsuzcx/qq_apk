package com.tencent.mm.ui.tools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.r;
import java.util.ArrayList;
import java.util.Iterator;

final class ShareImgUI$2
  implements ShareImgUI.b
{
  ShareImgUI$2(ShareImgUI paramShareImgUI) {}
  
  public final void as(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(34936);
    this.Axx.Aqm = paramArrayList;
    if ((this.Axx.Aqm == null) || (this.Axx.Aqm.size() == 0))
    {
      ab.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
      ShareImgUI.b(this.Axx);
      this.Axx.finish();
      AppMethodBeat.o(34936);
      return;
    }
    paramArrayList = this.Axx.Aqm.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (r.aoY(str))
      {
        ab.i("MicroMsg.ShareImgUI", "%s is not image", new Object[] { str });
        ShareImgUI.b(this.Axx);
        this.Axx.finish();
        AppMethodBeat.o(34936);
        return;
      }
    }
    paramArrayList = this.Axx.getIntent().resolveType(this.Axx);
    if ((paramArrayList == null) || (!paramArrayList.contains("image")))
    {
      ab.i("MicroMsg.ShareImgUI", "mime type is not image, try to set it");
      this.Axx.getIntent().setDataAndType(this.Axx.getIntent().getData(), "image/*");
    }
    ShareImgUI.c(this.Axx);
    AppMethodBeat.o(34936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI.2
 * JD-Core Version:    0.7.0.1
 */