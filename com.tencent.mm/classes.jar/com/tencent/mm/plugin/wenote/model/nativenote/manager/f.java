package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class f
{
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> pUj;
  private static String xyP;
  
  public static void clearData()
  {
    AppMethodBeat.i(30465);
    if (pUj != null) {
      pUj.clear();
    }
    xyP = "";
    com.tencent.mm.plugin.fav.a.aq.Aec = null;
    AppMethodBeat.o(30465);
  }
  
  public static void d(Context paramContext, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
    AppMethodBeat.i(30463);
    if (pUj != null) {
      pUj.clear();
    }
    pUj = paramArrayList;
    paramArrayList = new HashSet();
    if (pUj != null)
    {
      Iterator localIterator = pUj.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        String str = com.tencent.mm.plugin.wenote.c.c.d((com.tencent.mm.plugin.wenote.model.a.c)localObject);
        if (!Util.isNullOrNil(str)) {
          paramArrayList.add(str);
        }
        localObject = com.tencent.mm.plugin.wenote.c.c.e((com.tencent.mm.plugin.wenote.model.a.c)localObject);
        if (!Util.isNullOrNil((String)localObject)) {
          paramArrayList.add(localObject);
        }
      }
    }
    com.tencent.mm.plugin.fav.a.aq.Aec = paramArrayList;
    paramArrayList = new StringBuilder("");
    if (pUj != null)
    {
      int i = 0;
      if (i < pUj.size())
      {
        if (i != pUj.size() - 1) {
          paramArrayList.append(com.tencent.mm.plugin.wenote.c.c.a(paramContext, (com.tencent.mm.plugin.wenote.model.a.c)pUj.get(i))).append("<br/>");
        }
        for (;;)
        {
          i += 1;
          break;
          paramArrayList.append(com.tencent.mm.plugin.wenote.c.c.a(paramContext, (com.tencent.mm.plugin.wenote.model.a.c)pUj.get(i)));
        }
      }
    }
    paramContext = com.tencent.mm.plugin.wenote.c.c.anu(paramArrayList.toString());
    xyP = paramContext;
    ClipboardHelper.setText(a.anA(paramContext));
    AppMethodBeat.o(30463);
  }
  
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> dwi()
  {
    AppMethodBeat.i(30464);
    ArrayList localArrayList = new ArrayList();
    if (pUj == null)
    {
      AppMethodBeat.o(30464);
      return localArrayList;
    }
    Iterator localIterator = pUj.iterator();
    label181:
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.c.c.c((com.tencent.mm.plugin.wenote.model.a.c)localIterator.next());
      int j;
      if (localc == null) {
        j = 0;
      }
      for (;;)
      {
        if (j == 0) {
          break label181;
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
          str = com.tencent.mm.plugin.wenote.c.c.d(localc);
          if (!Util.isNullOrNil(str))
          {
            i = j;
            if (y.ZC(str)) {}
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
          str = com.tencent.mm.plugin.wenote.c.c.e(localc);
          if (!Util.isNullOrNil(str))
          {
            j = i;
            if (y.ZC(str)) {}
          }
          else
          {
            j = 0;
          }
        }
      }
    }
    AppMethodBeat.o(30464);
    return localArrayList;
  }
  
  public static boolean dwk()
  {
    AppMethodBeat.i(30466);
    ClipboardManager localClipboardManager = (ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard");
    if (localClipboardManager.getText().length() >= 16384)
    {
      AppMethodBeat.o(30466);
      return true;
    }
    if (com.tencent.mm.plugin.wenote.c.c.ans(localClipboardManager.getText().toString()) >= 16384)
    {
      AppMethodBeat.o(30466);
      return true;
    }
    AppMethodBeat.o(30466);
    return false;
  }
  
  public static int dwl()
  {
    AppMethodBeat.i(30467);
    Object localObject = (ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard");
    if ((localObject == null) || (((ClipboardManager)localObject).getText() == null) || (((ClipboardManager)localObject).getText().length() <= 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((pUj == null) || (pUj.size() <= 0)) {}
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (j != 0))
        {
          AppMethodBeat.o(30467);
          return 1;
        }
        if ((i == 0) && (j != 0))
        {
          AppMethodBeat.o(30467);
          return 2;
        }
        if (i != 0)
        {
          AppMethodBeat.o(30467);
          return 3;
        }
        try
        {
          localObject = ((ClipboardManager)localObject).getText();
          if ((localObject instanceof Spanned)) {}
          for (localObject = b.a((Spanned)localObject); ((String)localObject).equals(xyP); localObject = ((CharSequence)localObject).toString())
          {
            AppMethodBeat.o(30467);
            return 3;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("WNNoteClipboardManager", "get clipboard data error : ", new Object[] { localException });
            String str = "";
          }
          AppMethodBeat.o(30467);
          return 2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */