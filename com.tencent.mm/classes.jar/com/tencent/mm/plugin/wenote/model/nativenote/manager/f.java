package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class f
{
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> dataList;
  private static String oQI;
  
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> bZB()
  {
    AppMethodBeat.i(30464);
    ArrayList localArrayList = new ArrayList();
    if (dataList == null)
    {
      AppMethodBeat.o(30464);
      return localArrayList;
    }
    Iterator localIterator = dataList.iterator();
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
          if (!bs.isNullOrNil(str))
          {
            i = j;
            if (i.eA(str)) {}
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
          if (!bs.isNullOrNil(str))
          {
            j = i;
            if (i.eA(str)) {}
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
  
  public static boolean bZD()
  {
    AppMethodBeat.i(30466);
    ClipboardManager localClipboardManager = (ClipboardManager)ai.getContext().getSystemService("clipboard");
    if (localClipboardManager.getText().length() >= 16384)
    {
      AppMethodBeat.o(30466);
      return true;
    }
    if (com.tencent.mm.plugin.wenote.c.c.Xg(localClipboardManager.getText().toString()) >= 16384)
    {
      AppMethodBeat.o(30466);
      return true;
    }
    AppMethodBeat.o(30466);
    return false;
  }
  
  public static int bZE()
  {
    AppMethodBeat.i(30467);
    Object localObject = (ClipboardManager)ai.getContext().getSystemService("clipboard");
    if ((localObject == null) || (((ClipboardManager)localObject).getText() == null) || (((ClipboardManager)localObject).getText().length() <= 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((dataList == null) || (dataList.size() <= 0)) {}
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
          for (localObject = b.a((Spanned)localObject); ((String)localObject).equals(oQI); localObject = ((CharSequence)localObject).toString())
          {
            AppMethodBeat.o(30467);
            return 3;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("WNNoteClipboardManager", "get clipboard data error : ", new Object[] { localException });
            String str = "";
          }
          AppMethodBeat.o(30467);
          return 2;
        }
      }
    }
  }
  
  public static void c(Context paramContext, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
    AppMethodBeat.i(30463);
    if (dataList != null) {
      dataList.clear();
    }
    dataList = paramArrayList;
    paramArrayList = new HashSet();
    if (dataList != null)
    {
      Iterator localIterator = dataList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        String str = com.tencent.mm.plugin.wenote.c.c.d((com.tencent.mm.plugin.wenote.model.a.c)localObject);
        if (!bs.isNullOrNil(str)) {
          paramArrayList.add(str);
        }
        localObject = com.tencent.mm.plugin.wenote.c.c.e((com.tencent.mm.plugin.wenote.model.a.c)localObject);
        if (!bs.isNullOrNil((String)localObject)) {
          paramArrayList.add(localObject);
        }
      }
    }
    com.tencent.mm.plugin.fav.a.ao.qJQ = paramArrayList;
    paramArrayList = new StringBuilder("");
    if (dataList != null)
    {
      int i = 0;
      if (i < dataList.size())
      {
        if (i != dataList.size() - 1) {
          paramArrayList.append(com.tencent.mm.plugin.wenote.c.c.a(paramContext, (com.tencent.mm.plugin.wenote.model.a.c)dataList.get(i))).append("<br/>");
        }
        for (;;)
        {
          i += 1;
          break;
          paramArrayList.append(com.tencent.mm.plugin.wenote.c.c.a(paramContext, (com.tencent.mm.plugin.wenote.model.a.c)dataList.get(i)));
        }
      }
    }
    oQI = com.tencent.mm.plugin.wenote.c.c.Xi(paramArrayList.toString());
    paramContext = (ClipboardManager)ai.getContext().getSystemService("clipboard");
    if (paramContext != null) {
      paramContext.setText(a.Xo(oQI));
    }
    AppMethodBeat.o(30463);
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(30465);
    if (dataList != null) {
      dataList.clear();
    }
    oQI = "";
    com.tencent.mm.plugin.fav.a.ao.qJQ = null;
    AppMethodBeat.o(30465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */