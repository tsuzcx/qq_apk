package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class aq
{
  public boolean mInit = false;
  public String uAD;
  public int uAE = 2;
  public int uAF = 32;
  HashMap<String, String> uAG = new HashMap();
  public HashMap<String, ArrayList<String>> uAH = new HashMap();
  public HashMap<String, String> uAI = new HashMap();
  public HashMap<String, ArrayList<aq.a>> uAJ = new HashMap();
  public Comparator uAK = new aq.1(this);
  
  public final String Aw(String paramString)
  {
    Object localObject;
    if ((this.uAG != null) && (this.uAG.containsKey(paramString))) {
      localObject = (String)this.uAG.get(paramString);
    }
    c localc;
    String str1;
    String str2;
    do
    {
      return localObject;
      localc = ((d)g.t(d.class)).getEmojiStorageMgr().uBd;
      str1 = null;
      str2 = String.format("select %s from %s where %s=?", new Object[] { "desc", "EmojiInfoDesc", "md5_lang" });
      localObject = paramString + x.cqJ().toLowerCase();
      localObject = localc.dXw.a(str2, new String[] { localObject }, 2);
      if (((Cursor)localObject).moveToFirst()) {
        str1 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("desc"));
      }
      ((Cursor)localObject).close();
      localObject = str1;
    } while (!bk.bl(str1));
    paramString = paramString + "default";
    paramString = localc.dXw.a(str2, new String[] { paramString }, 2);
    if (paramString.moveToFirst()) {
      str1 = paramString.getString(paramString.getColumnIndex("desc"));
    }
    paramString.close();
    return str1;
  }
  
  public final void clear()
  {
    if (this.uAG != null) {
      this.uAG.clear();
    }
    if (this.uAH != null) {
      this.uAH.clear();
    }
    if (this.uAI != null) {
      this.uAI.clear();
    }
    if (this.uAJ != null) {
      this.uAJ.clear();
    }
  }
  
  public final void cuR()
  {
    g.DS().O(new aq.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.aq
 * JD-Core Version:    0.7.0.1
 */