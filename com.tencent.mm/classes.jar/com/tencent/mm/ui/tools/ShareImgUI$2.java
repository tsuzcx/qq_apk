package com.tencent.mm.ui.tools;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

final class ShareImgUI$2
  implements ShareImgUI.b
{
  ShareImgUI$2(ShareImgUI paramShareImgUI) {}
  
  public final void aj(ArrayList<String> paramArrayList)
  {
    this.weH.vYa = paramArrayList;
    if ((this.weH.vYa == null) || (this.weH.vYa.size() == 0))
    {
      y.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
      ShareImgUI.b(this.weH);
      this.weH.finish();
      return;
    }
    paramArrayList = this.weH.vYa.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (o.Za(str))
      {
        y.i("MicroMsg.ShareImgUI", "%s is not image", new Object[] { str });
        ShareImgUI.b(this.weH);
        this.weH.finish();
        return;
      }
    }
    paramArrayList = this.weH.getIntent().resolveType(this.weH);
    if ((paramArrayList == null) || (!paramArrayList.contains("image")))
    {
      y.i("MicroMsg.ShareImgUI", "mime type is not image, try to set it");
      this.weH.getIntent().setDataAndType(this.weH.getIntent().getData(), "image/*");
    }
    ShareImgUI.c(this.weH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI.2
 * JD-Core Version:    0.7.0.1
 */