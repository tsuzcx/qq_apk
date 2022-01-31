package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class f
{
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> iRT;
  private static String vyD;
  
  public static void clearData()
  {
    AppMethodBeat.i(26772);
    if (iRT != null) {
      iRT.clear();
    }
    vyD = "";
    com.tencent.mm.plugin.fav.a.an.muC = null;
    AppMethodBeat.o(26772);
  }
  
  public static void d(Context paramContext, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
    AppMethodBeat.i(26770);
    if (iRT != null) {
      iRT.clear();
    }
    iRT = paramArrayList;
    paramArrayList = new HashSet();
    if (iRT != null)
    {
      Iterator localIterator = iRT.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        String str = com.tencent.mm.plugin.wenote.b.c.d((com.tencent.mm.plugin.wenote.model.a.c)localObject);
        if (!bo.isNullOrNil(str)) {
          paramArrayList.add(str);
        }
        localObject = com.tencent.mm.plugin.wenote.b.c.e((com.tencent.mm.plugin.wenote.model.a.c)localObject);
        if (!bo.isNullOrNil((String)localObject)) {
          paramArrayList.add(localObject);
        }
      }
    }
    com.tencent.mm.plugin.fav.a.an.muC = paramArrayList;
    paramArrayList = new StringBuilder("");
    if (iRT != null)
    {
      int i = 0;
      if (i < iRT.size())
      {
        if (i != iRT.size() - 1) {
          paramArrayList.append(com.tencent.mm.plugin.wenote.b.c.a(paramContext, (com.tencent.mm.plugin.wenote.model.a.c)iRT.get(i))).append("<br/>");
        }
        for (;;)
        {
          i += 1;
          break;
          paramArrayList.append(com.tencent.mm.plugin.wenote.b.c.a(paramContext, (com.tencent.mm.plugin.wenote.model.a.c)iRT.get(i)));
        }
      }
    }
    vyD = com.tencent.mm.plugin.wenote.b.c.ajX(paramArrayList.toString());
    paramContext = (ClipboardManager)ah.getContext().getSystemService("clipboard");
    if (paramContext != null) {
      paramContext.setText(a.ajK(vyD));
    }
    AppMethodBeat.o(26770);
  }
  
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> diB()
  {
    AppMethodBeat.i(26771);
    ArrayList localArrayList = new ArrayList();
    if (iRT == null)
    {
      AppMethodBeat.o(26771);
      return localArrayList;
    }
    Iterator localIterator = iRT.iterator();
    label181:
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
          str = com.tencent.mm.plugin.wenote.b.c.d(localc);
          if (!bo.isNullOrNil(str))
          {
            i = j;
            if (e.cN(str)) {}
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
          if (!bo.isNullOrNil(str))
          {
            j = i;
            if (e.cN(str)) {}
          }
          else
          {
            j = 0;
          }
        }
      }
    }
    AppMethodBeat.o(26771);
    return localArrayList;
  }
  
  public static boolean diC()
  {
    AppMethodBeat.i(26773);
    ClipboardManager localClipboardManager = (ClipboardManager)ah.getContext().getSystemService("clipboard");
    if (localClipboardManager.getText().length() >= 16384)
    {
      AppMethodBeat.o(26773);
      return true;
    }
    if (com.tencent.mm.plugin.wenote.b.c.ajV(localClipboardManager.getText().toString()) >= 16384)
    {
      AppMethodBeat.o(26773);
      return true;
    }
    AppMethodBeat.o(26773);
    return false;
  }
  
  public static int diD()
  {
    AppMethodBeat.i(26774);
    Object localObject = (ClipboardManager)ah.getContext().getSystemService("clipboard");
    if ((localObject == null) || (((ClipboardManager)localObject).getText() == null) || (((ClipboardManager)localObject).getText().length() <= 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((iRT == null) || (iRT.size() <= 0)) {}
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (j != 0))
        {
          AppMethodBeat.o(26774);
          return 1;
        }
        if ((i == 0) && (j != 0))
        {
          AppMethodBeat.o(26774);
          return 2;
        }
        if (i != 0)
        {
          AppMethodBeat.o(26774);
          return 3;
        }
        try
        {
          localObject = ((ClipboardManager)localObject).getText();
          if ((localObject instanceof Spanned)) {}
          for (localObject = b.a((Spanned)localObject); ((String)localObject).equals(vyD); localObject = ((CharSequence)localObject).toString())
          {
            AppMethodBeat.o(26774);
            return 3;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("WNNoteClipboardManager", "get clipboard data error : ", new Object[] { localException });
            String str = "";
          }
          AppMethodBeat.o(26774);
          return 2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */