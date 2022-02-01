package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class f
{
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> jhZ;
  private static String pAW;
  
  public static void c(Context paramContext, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
    AppMethodBeat.i(30463);
    if (jhZ != null) {
      jhZ.clear();
    }
    jhZ = paramArrayList;
    paramArrayList = new HashSet();
    if (jhZ != null)
    {
      Iterator localIterator = jhZ.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        String str = com.tencent.mm.plugin.wenote.c.c.d((com.tencent.mm.plugin.wenote.model.a.c)localObject);
        if (!bu.isNullOrNil(str)) {
          paramArrayList.add(str);
        }
        localObject = com.tencent.mm.plugin.wenote.c.c.e((com.tencent.mm.plugin.wenote.model.a.c)localObject);
        if (!bu.isNullOrNil((String)localObject)) {
          paramArrayList.add(localObject);
        }
      }
    }
    com.tencent.mm.plugin.fav.a.ao.rCe = paramArrayList;
    paramArrayList = new StringBuilder("");
    if (jhZ != null)
    {
      int i = 0;
      if (i < jhZ.size())
      {
        if (i != jhZ.size() - 1) {
          paramArrayList.append(com.tencent.mm.plugin.wenote.c.c.a(paramContext, (com.tencent.mm.plugin.wenote.model.a.c)jhZ.get(i))).append("<br/>");
        }
        for (;;)
        {
          i += 1;
          break;
          paramArrayList.append(com.tencent.mm.plugin.wenote.c.c.a(paramContext, (com.tencent.mm.plugin.wenote.model.a.c)jhZ.get(i)));
        }
      }
    }
    pAW = com.tencent.mm.plugin.wenote.c.c.abG(paramArrayList.toString());
    paramContext = (ClipboardManager)ak.getContext().getSystemService("clipboard");
    if (paramContext != null) {
      paramContext.setText(a.abM(pAW));
    }
    AppMethodBeat.o(30463);
  }
  
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> cfu()
  {
    AppMethodBeat.i(30464);
    ArrayList localArrayList = new ArrayList();
    if (jhZ == null)
    {
      AppMethodBeat.o(30464);
      return localArrayList;
    }
    Iterator localIterator = jhZ.iterator();
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
          if (!bu.isNullOrNil(str))
          {
            i = j;
            if (o.fB(str)) {}
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
          if (!bu.isNullOrNil(str))
          {
            j = i;
            if (o.fB(str)) {}
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
  
  public static boolean cfw()
  {
    AppMethodBeat.i(30466);
    ClipboardManager localClipboardManager = (ClipboardManager)ak.getContext().getSystemService("clipboard");
    if (localClipboardManager.getText().length() >= 16384)
    {
      AppMethodBeat.o(30466);
      return true;
    }
    if (com.tencent.mm.plugin.wenote.c.c.abE(localClipboardManager.getText().toString()) >= 16384)
    {
      AppMethodBeat.o(30466);
      return true;
    }
    AppMethodBeat.o(30466);
    return false;
  }
  
  public static int cfx()
  {
    AppMethodBeat.i(30467);
    Object localObject = (ClipboardManager)ak.getContext().getSystemService("clipboard");
    if ((localObject == null) || (((ClipboardManager)localObject).getText() == null) || (((ClipboardManager)localObject).getText().length() <= 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((jhZ == null) || (jhZ.size() <= 0)) {}
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
          for (localObject = b.a((Spanned)localObject); ((String)localObject).equals(pAW); localObject = ((CharSequence)localObject).toString())
          {
            AppMethodBeat.o(30467);
            return 3;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("WNNoteClipboardManager", "get clipboard data error : ", new Object[] { localException });
            String str = "";
          }
          AppMethodBeat.o(30467);
          return 2;
        }
      }
    }
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(30465);
    if (jhZ != null) {
      jhZ.clear();
    }
    pAW = "";
    com.tencent.mm.plugin.fav.a.ao.rCe = null;
    AppMethodBeat.o(30465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */