package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.mt.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

final class SelectPoiCategoryUI$a
  extends c<mt>
{
  SelectPoiCategoryUI pfV;
  
  public SelectPoiCategoryUI$a(SelectPoiCategoryUI paramSelectPoiCategoryUI)
  {
    super(0);
    AppMethodBeat.i(23000);
    this.__eventId = mt.class.getName().hashCode();
    AppMethodBeat.o(23000);
  }
  
  private boolean a(mt parammt)
  {
    AppMethodBeat.i(23001);
    SelectPoiCategoryUI localSelectPoiCategoryUI;
    Object localObject;
    if ((parammt instanceof mt))
    {
      localSelectPoiCategoryUI = this.pfV;
      parammt = parammt.cCO.content;
      localObject = new File(SelectPoiCategoryUI.pfP);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
    }
    try
    {
      localObject = SelectPoiCategoryUI.pfP + "/lastest_poi_categories.dat";
      File localFile = new File((String)localObject);
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      e.b((String)localObject, parammt, parammt.length);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + localException.getMessage());
      }
    }
    localSelectPoiCategoryUI.bd(parammt);
    localSelectPoiCategoryUI.bWQ();
    AppMethodBeat.o(23001);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI.a
 * JD-Core Version:    0.7.0.1
 */