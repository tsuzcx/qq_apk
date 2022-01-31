package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class f
{
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> hgv;
  private static String rHX;
  
  public static void adg()
  {
    if (hgv != null) {
      hgv.clear();
    }
    rHX = "";
    com.tencent.mm.plugin.fav.a.an.kag = null;
  }
  
  public static void c(Context paramContext, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
    if (hgv != null) {
      hgv.clear();
    }
    hgv = paramArrayList;
    paramArrayList = new HashSet();
    if (hgv != null)
    {
      Iterator localIterator = hgv.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        String str = com.tencent.mm.plugin.wenote.b.c.d((com.tencent.mm.plugin.wenote.model.a.c)localObject);
        if (!bk.bl(str)) {
          paramArrayList.add(str);
        }
        localObject = com.tencent.mm.plugin.wenote.b.c.e((com.tencent.mm.plugin.wenote.model.a.c)localObject);
        if (!bk.bl((String)localObject)) {
          paramArrayList.add(localObject);
        }
      }
    }
    com.tencent.mm.plugin.fav.a.an.kag = paramArrayList;
    paramArrayList = new StringBuilder("");
    if (hgv != null)
    {
      int i = 0;
      if (i < hgv.size())
      {
        if (i != hgv.size() - 1) {
          paramArrayList.append(com.tencent.mm.plugin.wenote.b.c.a(paramContext, (com.tencent.mm.plugin.wenote.model.a.c)hgv.get(i))).append("<br/>");
        }
        for (;;)
        {
          i += 1;
          break;
          paramArrayList.append(com.tencent.mm.plugin.wenote.b.c.a(paramContext, (com.tencent.mm.plugin.wenote.model.a.c)hgv.get(i)));
        }
      }
    }
    rHX = com.tencent.mm.plugin.wenote.b.c.UH(paramArrayList.toString());
    paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
    if (paramContext != null) {
      paramContext.setText(a.Uw(rHX));
    }
  }
  
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> cim()
  {
    ArrayList localArrayList = new ArrayList();
    if (hgv == null) {
      return localArrayList;
    }
    Iterator localIterator = hgv.iterator();
    label169:
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.b.c.c((com.tencent.mm.plugin.wenote.model.a.c)localIterator.next());
      int j;
      if (localc == null) {
        j = 0;
      }
      for (;;)
      {
        if (j == 0) {
          break label169;
        }
        localArrayList.add(localc);
        break;
        j = 1;
        int k = localc.getType();
        int i;
        String str;
        if ((k != 2) && (k != 6) && (k != 4))
        {
          i = j;
          if (k != 5) {}
        }
        else
        {
          str = com.tencent.mm.plugin.wenote.b.c.d(localc);
          if (!bk.bl(str))
          {
            i = j;
            if (e.bK(str)) {}
          }
          else
          {
            i = 0;
          }
        }
        if (k != 2)
        {
          j = i;
          if (k != 6) {}
        }
        else
        {
          str = com.tencent.mm.plugin.wenote.b.c.e(localc);
          if (!bk.bl(str))
          {
            j = i;
            if (e.bK(str)) {}
          }
          else
          {
            j = 0;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean eD(Context paramContext)
  {
    paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
    if (paramContext.getText().length() >= 16384) {
      return true;
    }
    return com.tencent.mm.plugin.wenote.b.c.UF(paramContext.getText().toString()) >= 16384;
  }
  
  public static int eE(Context paramContext)
  {
    paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
    if ((paramContext == null) || (paramContext.getText() == null) || (paramContext.getText().length() <= 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((hgv == null) || (hgv.size() <= 0)) {}
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (j != 0)) {
          return 1;
        }
        if ((i == 0) && (j != 0)) {
          return 2;
        }
        if (i != 0) {
          return 3;
        }
        try
        {
          paramContext = paramContext.getText();
          if ((paramContext instanceof Spanned)) {}
          for (paramContext = b.a((Spanned)paramContext); paramContext.equals(rHX); paramContext = paramContext.toString()) {
            return 3;
          }
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            y.e("WNNoteClipboardManager", "get clipboard data error : ", new Object[] { paramContext });
            paramContext = "";
          }
        }
        return 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */