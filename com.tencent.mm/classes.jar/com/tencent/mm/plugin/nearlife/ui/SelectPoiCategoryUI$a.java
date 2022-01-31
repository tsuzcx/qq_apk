package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.mm.a.e;
import com.tencent.mm.h.a.mb;
import com.tencent.mm.h.a.mb.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class SelectPoiCategoryUI$a
  extends c<mb>
{
  SelectPoiCategoryUI mFP;
  
  public SelectPoiCategoryUI$a(SelectPoiCategoryUI paramSelectPoiCategoryUI)
  {
    super(0);
    this.udX = mb.class.getName().hashCode();
  }
  
  private boolean a(mb parammb)
  {
    SelectPoiCategoryUI localSelectPoiCategoryUI;
    Object localObject;
    if ((parammb instanceof mb))
    {
      localSelectPoiCategoryUI = this.mFP;
      parammb = parammb.bVg.content;
      localObject = new File(SelectPoiCategoryUI.mFJ);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
    }
    try
    {
      localObject = SelectPoiCategoryUI.mFJ + "/lastest_poi_categories.dat";
      File localFile = new File((String)localObject);
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      e.b((String)localObject, parammb, parammb.length);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + localException.getMessage());
      }
    }
    localSelectPoiCategoryUI.aF(parammb);
    localSelectPoiCategoryUI.bor();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI.a
 * JD-Core Version:    0.7.0.1
 */