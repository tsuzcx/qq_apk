package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static volatile c XAS = null;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a XAT = null;
  public boolean XAU = false;
  public ArrayList<com.tencent.mm.plugin.wenote.model.a.c> mDataList = null;
  public arf xyS = null;
  public int xyT = 0;
  public int xyU = 0;
  public int xyV = 0;
  
  private boolean JM(int paramInt)
  {
    AppMethodBeat.i(30418);
    if ((this.mDataList != null) && (paramInt >= 0) && (paramInt < this.mDataList.size()))
    {
      a((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(paramInt), false);
      this.mDataList.remove(paramInt);
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(30418);
      return bool;
    }
  }
  
  private void a(com.tencent.mm.plugin.wenote.model.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(30441);
    if (paramc == null)
    {
      AppMethodBeat.o(30441);
      return;
    }
    if (paramc.getType() == 1)
    {
      int i = com.tencent.mm.plugin.wenote.c.c.anr(((i)paramc).content);
      if (paramBoolean)
      {
        this.xyU = (i + this.xyU);
        AppMethodBeat.o(30441);
        return;
      }
      this.xyU -= i;
      AppMethodBeat.o(30441);
      return;
    }
    if (paramBoolean)
    {
      this.xyV += 1;
      AppMethodBeat.o(30441);
      return;
    }
    this.xyV -= 1;
    AppMethodBeat.o(30441);
  }
  
  private void b(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    AppMethodBeat.i(30437);
    if (paramc == null)
    {
      AppMethodBeat.o(30437);
      return;
    }
    o localo = (o)paramc;
    com.tencent.mm.plugin.wenote.model.d locald;
    if (localo.getType() > 1)
    {
      if (Util.isNullOrNil(localo.xyo)) {
        localo.xyo = dwt();
      }
      locald = com.tencent.mm.plugin.wenote.model.c.iDT().XzB;
      if (locald != null) {
        break label105;
      }
      Log.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", new Object[] { paramc.toString() });
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramc.hIQ)) {
        paramc.hIQ = com.tencent.mm.plugin.wenote.model.f.anz(paramc.toString());
      }
      AppMethodBeat.o(30437);
      return;
      label105:
      if (locald.XzI == null) {
        Log.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", new Object[] { paramc.toString() });
      } else {
        locald.XzI.put(localo.xyo, localo);
      }
    }
  }
  
  private boolean b(int paramInt, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(30416);
    if ((paramc != null) && (this.mDataList != null) && (paramInt >= 0) && (paramInt <= this.mDataList.size()))
    {
      this.mDataList.add(paramInt, paramc);
      a(paramc, true);
    }
    for (;;)
    {
      AppMethodBeat.o(30416);
      return bool;
      bool = false;
    }
  }
  
  private static String dT(String paramString, int paramInt)
  {
    AppMethodBeat.i(30432);
    paramString = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[] { Integer.valueOf(paramInt), paramString, paramString });
    AppMethodBeat.o(30432);
    return paramString;
  }
  
  private void dwq()
  {
    AppMethodBeat.i(30426);
    if (this.mDataList != null)
    {
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        localc.xyb = false;
        localc.xyh = false;
      }
    }
    AppMethodBeat.o(30426);
  }
  
  private String dwt()
  {
    AppMethodBeat.i(30430);
    if ((this.xyT == 0) && (this.mDataList != null))
    {
      localObject = this.mDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        o localo = (o)((Iterator)localObject).next();
        if (localo.xyo.startsWith("WeNote_"))
        {
          i = Util.getInt(localo.xyo.substring(7), -1);
          if (i > this.xyT) {}
          for (;;)
          {
            this.xyT = i;
            break;
            i = this.xyT;
          }
        }
      }
    }
    Object localObject = new StringBuilder("WeNote_");
    int i = this.xyT + 1;
    this.xyT = i;
    localObject = i;
    AppMethodBeat.o(30430);
    return localObject;
  }
  
  public static c iEg()
  {
    AppMethodBeat.i(30410);
    if (XAS == null) {}
    try
    {
      if (XAS == null) {
        XAS = new c();
      }
      c localc = XAS;
      AppMethodBeat.o(30410);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(30410);
    }
  }
  
  public final void JN(int paramInt)
  {
    AppMethodBeat.i(30419);
    if (this.XAT != null) {
      this.XAT.JG(paramInt);
    }
    AppMethodBeat.o(30419);
  }
  
  public final boolean Y(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
    AppMethodBeat.i(30439);
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
      if (localc.getType() != 1) {
        i += 1;
      } else {
        localStringBuilder.append(((i)localc).content);
      }
    }
    boolean bool = gK(com.tencent.mm.plugin.wenote.c.c.anr(localStringBuilder.toString()), i);
    AppMethodBeat.o(30439);
    return bool;
  }
  
  public final int a(com.tencent.mm.plugin.wenote.model.a.c paramc, WXRTEditText paramWXRTEditText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(30434);
    if (paramc == null)
    {
      AppMethodBeat.o(30434);
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramc);
    int i = a(localArrayList, paramWXRTEditText, true, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(30434);
    return i;
  }
  
  public final int a(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30436);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.mDataList == null) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt4 < paramInt3))
    {
      Log.e("MicroMsg.Note.NoteDataManager", "pasteItemList,error,return");
      AppMethodBeat.o(30436);
      return -1;
    }
    if (com.tencent.mm.plugin.wenote.model.c.iDT().XzB == null)
    {
      Log.e("MicroMsg.Note.NoteDataManager", "pasteItemList, but get wnnote base is null, return");
      AppMethodBeat.o(30436);
      return -1;
    }
    Object localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(paramArrayList.size() - 1);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.Note.NoteDataManager", "pasteItemList, lastInsertItem is null");
      AppMethodBeat.o(30436);
      return -1;
    }
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).xyd = -1;
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).xyb = true;
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).xyh = false;
    Object localObject3 = avf(paramInt2);
    if (localObject3 == null)
    {
      Log.e("MicroMsg.Note.NoteDataManager", "pasteItemList, item is null");
      AppMethodBeat.o(30436);
      return -1;
    }
    label641:
    label908:
    label911:
    for (;;)
    {
      label493:
      label498:
      int j;
      int i;
      try
      {
        dwq();
        if ((paramInt1 != 0) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType() != 1)) {
          break label896;
        }
        Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.anA(((i)localObject3).content);
        if ((localObject2 == null) || (paramInt3 > ((Spanned)localObject2).length()) || (paramInt4 > ((Spanned)localObject2).length()))
        {
          if (localObject2 == null)
          {
            paramInt1 = -1;
            Log.e("MicroMsg.Note.NoteDataManager", "pasteItemList error, oriText:%d  startOff:%d  endOff:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
            return -1;
          }
          paramInt1 = ((Spanned)localObject2).length();
          continue;
        }
        localObject1 = ((Spanned)localObject2).subSequence(0, paramInt3);
        CharSequence localCharSequence = ((Spanned)localObject2).subSequence(paramInt4, ((Spanned)localObject2).length());
        localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject1);
        localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localCharSequence);
        localObject3 = (i)localObject3;
        if (!Util.isNullOrNil((String)localObject2))
        {
          if (!((String)localObject2).endsWith("<br/>")) {
            break label879;
          }
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
          ((i)localObject3).content = ((String)localObject2);
          paramInt2 += 1;
          paramInt1 = paramInt2;
          if (Util.isNullOrNil((String)localObject1)) {
            break label882;
          }
          localObject3 = new i();
          ((i)localObject3).type = 1;
          localObject2 = localObject1;
          if (((String)localObject1).startsWith("<br/>")) {
            localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
          }
          ((i)localObject3).content = ((String)localObject2);
          ((i)localObject3).xyd = 0;
          ((i)localObject3).xyb = false;
          ((i)localObject3).xyh = false;
          b(paramInt2, (com.tencent.mm.plugin.wenote.model.a.c)localObject3);
          paramInt4 = 1;
          paramInt1 = paramInt2;
          paramInt3 = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = paramInt4;
          paramArrayList = paramArrayList.iterator();
          j = paramInt3;
          paramInt4 = paramInt1;
          i = paramInt2;
          if (paramArrayList.hasNext())
          {
            localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
            b((com.tencent.mm.plugin.wenote.model.a.c)localObject1);
            if (!b(paramInt3, (com.tencent.mm.plugin.wenote.model.a.c)localObject1)) {
              break label876;
            }
            paramInt3 += 1;
            break label876;
          }
        }
        else
        {
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).startsWith("<br/>")) {
              localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
            }
            ((i)localObject3).content = ((String)localObject2);
            paramInt1 = 0;
            paramInt4 = paramInt2;
            paramInt3 = paramInt2;
            paramInt2 = paramInt4;
            continue;
          }
          JM(paramInt2);
          paramInt1 = paramInt2;
          if (this.XAT == null) {
            break label882;
          }
          this.XAT.JI(paramInt2);
          paramInt1 = paramInt2;
          break label882;
          paramArrayList = paramArrayList.iterator();
          paramInt2 = paramInt1;
          if (!paramArrayList.hasNext()) {
            break label911;
          }
          localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
          b((com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          if (!b(paramInt2, (com.tencent.mm.plugin.wenote.model.a.c)localObject1)) {
            break label868;
          }
          paramInt2 += 1;
          break label908;
        }
        if ((j - 1 >= 0) && (j - 1 < iEg().size()))
        {
          paramInt1 = j - 1;
          if (this.XAT != null)
          {
            paramInt3 = j - i;
            paramInt2 = paramInt3;
            if (paramInt4 != 0) {
              paramInt2 = paramInt3 + 1;
            }
            if ((i >= 0) && (paramInt2 > 0)) {
              this.XAT.gH(i, paramInt2);
            }
            if (i <= 0) {
              break label840;
            }
            this.XAT.gI(i - 1, iEg().size() - (i - 1));
            this.XAT.JJ(paramInt1);
          }
          dww();
          AppMethodBeat.o(30436);
          return paramInt1;
        }
      }
      finally
      {
        AppMethodBeat.o(30436);
      }
      paramInt1 = iEg().size() - 1;
      continue;
      label840:
      if (i == 0)
      {
        this.XAT.gI(i, iEg().size() - i);
        continue;
        label868:
        break label908;
        label876:
        label879:
        label882:
        do
        {
          paramInt1 = paramInt2;
          break label641;
          break label498;
          break;
          paramInt4 = 0;
          paramInt2 = paramInt1;
          paramInt3 = paramInt1;
          paramInt1 = paramInt4;
          break label493;
        } while (paramInt1 == 1);
        paramInt1 = paramInt2 + 1;
        continue;
        continue;
        paramInt4 = 0;
        j = paramInt2;
        i = paramInt1;
      }
    }
  }
  
  public final int a(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, WXRTEditText paramWXRTEditText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(30435);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.mDataList == null))
    {
      Log.e("MicroMsg.Note.NoteDataManager", "insertItemList,error,return");
      AppMethodBeat.o(30435);
      return -1;
    }
    if (com.tencent.mm.plugin.wenote.model.c.iDT().XzB == null)
    {
      Log.e("MicroMsg.Note.NoteDataManager", "insertItemList, but get wnnote base is null, return");
      AppMethodBeat.o(30435);
      return -1;
    }
    if ((paramBoolean2) && (Y(paramArrayList)) && (this.XAT != null))
    {
      this.XAT.dvv();
      AppMethodBeat.o(30435);
      return -1;
    }
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(paramArrayList.size() - 1);
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).xyd = -1;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).xyb = true;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).xyh = false;
      if ((paramWXRTEditText != null) && (paramWXRTEditText.xzU))
      {
        if (paramWXRTEditText.getEditTextType() != 2) {
          break label286;
        }
        ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).xyk = 2;
      }
    }
    label194:
    int n;
    int i;
    label283:
    label286:
    int i1;
    label415:
    label443:
    int k;
    int m;
    for (;;)
    {
      paramWXRTEditText.xzU = false;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).xyl = paramWXRTEditText.xyl;
      paramWXRTEditText.xyl = 0;
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getRecyclerItemPosition() != 0)) {
        if (paramWXRTEditText != null) {
          break label646;
        }
      }
      try
      {
        n = size();
        dwq();
        paramArrayList = paramArrayList.iterator();
        i = n;
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
            b(paramWXRTEditText);
            if ((paramWXRTEditText == null) || (this.mDataList == null)) {
              break label1274;
            }
            this.mDataList.add(paramWXRTEditText);
            a(paramWXRTEditText, true);
            j = 1;
            if (j == 0) {
              break label1280;
            }
            i += 1;
            continue;
            if (paramWXRTEditText.getEditTextType() != 1) {
              break;
            }
            ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).xyk = 1;
            break;
            if ((paramWXRTEditText.getEditTextType() == 2) || (paramWXRTEditText.getSelectionStart() != 0) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
              break label194;
            }
            i = ((com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(0)).getType();
            if ((i != 2) && (i != 6) && (i != 5) && (i != 3) && (i != 4)) {
              break label194;
            }
            localObject1 = new i();
            ((i)localObject1).content = "";
            ((i)localObject1).xyb = false;
            ((i)localObject1).xyh = false;
            paramArrayList.add(0, localObject1);
            break label194;
          }
        }
        i1 = 0;
        if ((i - 1 < 0) || (i - 1 >= iEg().size())) {
          break;
        }
        j = i - 1;
        k = j;
        m = i;
        if (paramBoolean4)
        {
          j += 1;
          i += 1;
          dwq();
          if (j >= iEg().size()) {
            break label1169;
          }
          paramArrayList = iEg().avf(j);
          k = j;
          m = i;
          if (paramArrayList != null)
          {
            paramArrayList.xyd = 0;
            paramArrayList.xyb = true;
            paramArrayList.xyh = false;
            m = i;
            k = j;
          }
        }
        label527:
        if (this.XAT != null)
        {
          j = m - n;
          i = j;
          if (i1 != 0) {
            i = j + 1;
          }
          if ((n >= 0) && (i > 0)) {
            this.XAT.gH(n, i);
          }
          if (n <= 0) {
            break label1223;
          }
          this.XAT.gI(n - 1, iEg().size() - (n - 1));
          label608:
          if (paramBoolean3) {
            this.XAT.dvu();
          }
          this.XAT.JJ(k);
        }
        dww();
        AppMethodBeat.o(30435);
        return k;
      }
      finally
      {
        label646:
        Object localObject2;
        Object localObject3;
        AppMethodBeat.o(30435);
      }
    }
    int j = paramWXRTEditText.getRecyclerItemPosition();
    localObject2 = avf(j);
    if (localObject2 == null)
    {
      AppMethodBeat.o(30435);
      return -1;
    }
    dwq();
    if ((paramWXRTEditText.getEditTextType() == 0) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() == 1))
    {
      localObject1 = paramWXRTEditText.getSelection();
      localObject3 = paramWXRTEditText.getText();
      paramWXRTEditText = ((Editable)localObject3).subSequence(0, ((e)localObject1).uG);
      localObject3 = ((Editable)localObject3).subSequence(((e)localObject1).uH, ((Editable)localObject3).length());
      localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)paramWXRTEditText);
      paramWXRTEditText = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject3);
      localObject2 = (i)localObject2;
      if (!Util.isNullOrNil((String)localObject1))
      {
        if (!((String)localObject1).endsWith("<br/>")) {
          break label1290;
        }
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
        label801:
        ((i)localObject2).content = ((String)localObject1);
        j += 1;
        i = j;
        if (Util.isNullOrNil(paramWXRTEditText)) {
          break label1293;
        }
        localObject2 = new i();
        ((i)localObject2).type = 1;
        localObject1 = paramWXRTEditText;
        if (paramWXRTEditText.startsWith("<br/>")) {
          localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
        }
        ((i)localObject2).content = ((String)localObject1);
        ((i)localObject2).xyd = 0;
        ((i)localObject2).xyb = false;
        ((i)localObject2).xyh = false;
        b(j, (com.tencent.mm.plugin.wenote.model.a.c)localObject2);
        i = j;
        k = 1;
        m = j;
        j = i;
        i = m;
      }
    }
    for (;;)
    {
      label917:
      paramArrayList = paramArrayList.iterator();
      for (m = i;; m = i)
      {
        i = m;
        n = j;
        i1 = k;
        if (!paramArrayList.hasNext()) {
          break label415;
        }
        paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
        b(paramWXRTEditText);
        if (b(m, paramWXRTEditText))
        {
          i = m + 1;
          continue;
          if (!Util.isNullOrNil(paramWXRTEditText))
          {
            localObject1 = paramWXRTEditText;
            if (paramWXRTEditText.startsWith("<br/>")) {
              localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
            }
            ((i)localObject2).content = ((String)localObject1);
            k = j;
            m = 0;
            i = j;
            j = k;
            k = m;
            break label917;
          }
          JM(j);
          i = j;
          if (this.XAT == null) {
            break label1293;
          }
          this.XAT.JI(j);
          i = j;
          break label1293;
          if (paramWXRTEditText.getEditTextType() != 1) {
            j += 1;
          }
          for (;;)
          {
            paramArrayList = paramArrayList.iterator();
            i = j;
            label1100:
            if (paramArrayList.hasNext())
            {
              paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
              b(paramWXRTEditText);
              paramBoolean1 = b(i, paramWXRTEditText);
              if (!paramBoolean1) {
                break label1261;
              }
              i += 1;
            }
            label1169:
            label1223:
            label1261:
            for (;;)
            {
              break label1100;
              j = iEg().size() - 1;
              break label443;
              paramArrayList = new i();
              paramArrayList.type = 1;
              paramArrayList.content = "";
              paramArrayList.xyd = 0;
              paramArrayList.xyb = true;
              paramArrayList.xyh = false;
              b(j, paramArrayList);
              k = j;
              m = i;
              break label527;
              if (n != 0) {
                break label608;
              }
              this.XAT.gI(n, iEg().size() - n);
              break label608;
              i1 = 0;
              n = j;
              break;
            }
          }
        }
        i = m;
        continue;
        label1274:
        j = 0;
        break;
        label1280:
        break label283;
      }
      label1290:
      break label801;
      label1293:
      j = i;
      k = 0;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    int i = 0;
    AppMethodBeat.i(30420);
    for (;;)
    {
      try
      {
        if (this.mDataList == null)
        {
          return;
          i += 1;
        }
        if (i < this.mDataList.size())
        {
          if (!((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).iEa().equals(paramString)) {
            continue;
          }
          a((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i), false);
          this.mDataList.set(i, paramc);
          a(paramc, true);
          if ((i != -1) && (this.XAT != null)) {
            this.XAT.JG(i);
          }
          AppMethodBeat.o(30420);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(30420);
      }
      i = -1;
    }
  }
  
  public final boolean a(int paramInt, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(30415);
    for (;;)
    {
      try
      {
        if ((this.mDataList == null) || (paramInt < 0) || (paramInt > this.mDataList.size())) {
          break label138;
        }
        this.mDataList.add(paramInt, paramc);
        a(paramc, true);
        if ((bool) && (this.XAT != null))
        {
          this.XAT.JH(paramInt);
          if (paramInt > 0) {
            this.XAT.gI(paramInt - 1, this.mDataList.size() - (paramInt - 1));
          }
        }
        else
        {
          AppMethodBeat.o(30415);
          return bool;
        }
      }
      finally
      {
        AppMethodBeat.o(30415);
      }
      this.XAT.gI(paramInt, this.mDataList.size() - paramInt);
      continue;
      label138:
      bool = false;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(30413);
    if (paramc != null) {}
    for (;;)
    {
      try
      {
        if (this.mDataList != null)
        {
          this.mDataList.add(paramc);
          a(paramc, true);
          return bool;
        }
      }
      finally
      {
        AppMethodBeat.o(30413);
      }
      bool = false;
    }
  }
  
  public final arv anD(String paramString)
  {
    AppMethodBeat.i(30433);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
      AppMethodBeat.o(30433);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        if (i >= this.mDataList.size()) {
          break label794;
        }
        localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i);
        if (Util.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).hIQ)) {
          ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).hIQ = com.tencent.mm.plugin.wenote.model.f.anz(localObject1.toString());
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == -1) {
          if ((localArrayList.size() > 0) && (((o)localArrayList.get(localArrayList.size() - 1)).type == 1))
          {
            localObject1 = new StringBuilder();
            localObject2 = (i)localArrayList.get(localArrayList.size() - 1);
            ((i)localObject2).content += "\n";
          }
          else
          {
            localObject2 = new i();
            ((i)localObject2).content = "\n";
            ((i)localObject2).hIQ = ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).hIQ;
            ((i)localObject2).xyo = "-1";
            ((i)localObject2).type = 1;
            ((i)localObject2).xyn = null;
            localArrayList.add(localObject2);
          }
        }
      }
      finally
      {
        AppMethodBeat.o(30433);
      }
      if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() >= -1)
      {
        if (((((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 6) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 4)) && (Util.isNullOrNil(((o)localObject1).hTM)))
        {
          localObject2 = new arf();
          ((arf)localObject2).bsB(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).hIQ);
          ((arf)localObject2).bsy(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).dwe());
          localObject2 = com.tencent.mm.plugin.wenote.model.f.b((arf)localObject2);
          if (y.ZC((String)localObject2))
          {
            Log.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType()) });
            ((o)localObject1).hTM = ((String)localObject2);
          }
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() != 1)
        {
          localArrayList.add((o)localObject1);
        }
        else
        {
          localObject1 = (i)localObject1;
          if (Util.isNullOrNil(((i)localObject1).content))
          {
            if ((localArrayList.size() > 0) && (((o)localArrayList.get(localArrayList.size() - 1)).getType() == 1))
            {
              localObject1 = new StringBuilder();
              localObject2 = (i)localArrayList.get(localArrayList.size() - 1);
              ((i)localObject2).content += "<br/>";
            }
            else
            {
              localObject2 = new i();
              ((i)localObject2).content = "<br/>";
              ((i)localObject2).hIQ = ((i)localObject1).hIQ;
              ((i)localObject2).xyo = ((i)localObject1).xyo;
              ((i)localObject2).type = ((i)localObject1).type;
              ((i)localObject2).xyn = null;
              localArrayList.add(localObject2);
            }
          }
          else
          {
            Object localObject3;
            if ((localArrayList.size() > 0) && (((o)localArrayList.get(localArrayList.size() - 1)).getType() == 1))
            {
              localObject2 = new StringBuilder();
              localObject3 = (i)localArrayList.get(localArrayList.size() - 1);
              ((i)localObject3).content += ((i)localObject1).content;
            }
            while ((i + 1 < this.mDataList.size()) && (((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i + 1)).getType() == 1) && (!Util.isNullOrNil(((i)this.mDataList.get(i + 1)).content)))
            {
              localObject1 = new StringBuilder();
              localObject2 = (i)localArrayList.get(localArrayList.size() - 1);
              ((i)localObject2).content += "<br/>";
              break;
              localObject2 = new i();
              ((i)localObject2).content = ((i)localObject1).content;
              ((i)localObject2).hIQ = ((i)localObject1).hIQ;
              ((i)localObject2).xyo = ((i)localObject1).xyo;
              ((i)localObject2).type = ((i)localObject1).type;
              ((i)localObject2).xyn = null;
              localArrayList.add(localObject2);
              continue;
              label794:
              paramString = Pattern.compile("<wx-", 2).matcher(paramString).replaceAll("<");
              localObject1 = Pattern.compile("</wx-", 2).matcher(paramString).replaceAll("</");
              try
              {
                paramString = ((String)localObject1).getBytes("UTF-8");
                i = 0;
              }
              catch (UnsupportedEncodingException paramString)
              {
                for (;;)
                {
                  try
                  {
                    ((u)localObject3).jKZ();
                    if ((i != 0) || (y.f((String)localObject2, paramString, paramString.length) != 0)) {
                      break;
                    }
                    this.xyS.bsC((String)localObject2);
                    Log.i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
                    paramString = com.tencent.mm.plugin.wenote.model.d.a((String)localObject1, localArrayList, this.xyS);
                    AppMethodBeat.o(30433);
                    return paramString;
                  }
                  catch (IOException paramString)
                  {
                    Log.printErrStackTrace("MicroMsg.Note.NoteDataManager", paramString, "", new Object[0]);
                    AppMethodBeat.o(30433);
                    return null;
                  }
                  paramString = paramString;
                  Log.printErrStackTrace("MicroMsg.Note.NoteDataManager", paramString, "", new Object[0]);
                  Log.e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
                  i = 1;
                  paramString = null;
                }
              }
              this.xyS.axy(8);
              this.xyS.bsL("WeNoteHtmlFile");
              this.xyS.Kk(true);
              this.xyS.bsy(".htm");
              this.xyS.bsB(com.tencent.mm.plugin.wenote.model.f.anz(this.xyS.toString()));
              localObject2 = com.tencent.mm.plugin.wenote.model.f.b(this.xyS);
              Log.i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", new Object[] { localObject2 });
              localObject3 = new u((String)localObject2);
              if (((u)localObject3).jKS()) {
                ((u)localObject3).diJ();
              }
              if (!((u)localObject3).jKS()) {}
              Log.i("MicroMsg.Note.NoteDataManager", "writefile error,return");
              Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.favorite_save_fail), 1).show();
              AppMethodBeat.o(30433);
              return null;
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public final boolean av(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(30417);
    boolean bool1 = bool2;
    for (;;)
    {
      try
      {
        if (this.mDataList != null)
        {
          bool1 = bool2;
          if (paramInt >= 0)
          {
            bool1 = bool2;
            if (paramInt < this.mDataList.size())
            {
              a((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(paramInt), false);
              this.mDataList.remove(paramInt);
              bool1 = true;
            }
          }
        }
        if ((bool1) && (paramBoolean) && (this.XAT != null))
        {
          this.XAT.JI(paramInt);
          if (paramInt > 0) {
            this.XAT.gI(paramInt - 1, this.mDataList.size() - (paramInt - 1));
          }
        }
        else
        {
          AppMethodBeat.o(30417);
          return bool1;
        }
      }
      finally
      {
        AppMethodBeat.o(30417);
      }
      this.XAT.gI(paramInt, this.mDataList.size() - paramInt);
    }
  }
  
  public final com.tencent.mm.plugin.wenote.model.a.c avf(int paramInt)
  {
    AppMethodBeat.i(30412);
    if ((this.mDataList != null) && (paramInt >= 0) && (paramInt < this.mDataList.size()))
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(paramInt);
      AppMethodBeat.o(30412);
      return localc;
    }
    AppMethodBeat.o(30412);
    return null;
  }
  
  /* Error */
  public final void aw(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 30423
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 35	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:mDataList	Ljava/util/ArrayList;
    //   12: ifnonnull +12 -> 24
    //   15: aload_0
    //   16: monitorexit
    //   17: sipush 30423
    //   20: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: iload_1
    //   25: iflt +69 -> 94
    //   28: iload_1
    //   29: aload_0
    //   30: getfield 35	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:mDataList	Ljava/util/ArrayList;
    //   33: invokevirtual 61	java/util/ArrayList:size	()I
    //   36: if_icmpge +58 -> 94
    //   39: aload_0
    //   40: getfield 35	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:mDataList	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: invokevirtual 65	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   47: checkcast 67	com/tencent/mm/plugin/wenote/model/a/c
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +33 -> 85
    //   55: aload_3
    //   56: getfield 572	com/tencent/mm/plugin/wenote/model/a/c:xyi	Z
    //   59: iload_2
    //   60: if_icmpeq +25 -> 85
    //   63: aload_3
    //   64: iload_2
    //   65: putfield 572	com/tencent/mm/plugin/wenote/model/a/c:xyi	Z
    //   68: aload_0
    //   69: getfield 37	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:XAT	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/a;
    //   72: ifnull +13 -> 85
    //   75: aload_0
    //   76: getfield 37	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:XAT	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/a;
    //   79: iload_1
    //   80: invokeinterface 238 2 0
    //   85: aload_0
    //   86: monitorexit
    //   87: sipush 30423
    //   90: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: iload_1
    //   95: iconst_m1
    //   96: if_icmpne -11 -> 85
    //   99: iconst_0
    //   100: istore_1
    //   101: iload_1
    //   102: aload_0
    //   103: getfield 35	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:mDataList	Ljava/util/ArrayList;
    //   106: invokevirtual 61	java/util/ArrayList:size	()I
    //   109: if_icmpge -24 -> 85
    //   112: aload_0
    //   113: getfield 35	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:mDataList	Ljava/util/ArrayList;
    //   116: iload_1
    //   117: invokevirtual 65	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   120: checkcast 67	com/tencent/mm/plugin/wenote/model/a/c
    //   123: astore_3
    //   124: aload_3
    //   125: ifnull +33 -> 158
    //   128: aload_3
    //   129: getfield 572	com/tencent/mm/plugin/wenote/model/a/c:xyi	Z
    //   132: iload_2
    //   133: if_icmpeq +25 -> 158
    //   136: aload_3
    //   137: iload_2
    //   138: putfield 572	com/tencent/mm/plugin/wenote/model/a/c:xyi	Z
    //   141: aload_0
    //   142: getfield 37	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:XAT	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/a;
    //   145: ifnull +13 -> 158
    //   148: aload_0
    //   149: getfield 37	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:XAT	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/a;
    //   152: iload_1
    //   153: invokeinterface 238 2 0
    //   158: iload_1
    //   159: iconst_1
    //   160: iadd
    //   161: istore_1
    //   162: goto -61 -> 101
    //   165: astore_3
    //   166: aload_0
    //   167: monitorexit
    //   168: sipush 30423
    //   171: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_3
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	c
    //   0	176	1	paramInt	int
    //   0	176	2	paramBoolean	boolean
    //   50	87	3	localc	com.tencent.mm.plugin.wenote.model.a.c
    //   165	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	165	finally
    //   28	51	165	finally
    //   55	85	165	finally
    //   85	87	165	finally
    //   101	124	165	finally
    //   128	158	165	finally
  }
  
  public final void ax(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30427);
    for (;;)
    {
      int i;
      try
      {
        if ((this.mDataList == null) || (paramInt < 0) || (paramInt >= this.mDataList.size())) {
          return;
        }
        i = 0;
        if (i < this.mDataList.size()) {
          if (i == paramInt)
          {
            ((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).xyb = true;
            ((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).xyh = paramBoolean;
          }
          else
          {
            ((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).xyb = false;
            ((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).xyh = false;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(30427);
      }
      AppMethodBeat.o(30427);
      return;
      i += 1;
    }
  }
  
  public final boolean b(int paramInt, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
    AppMethodBeat.i(30414);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      AppMethodBeat.o(30414);
      return false;
    }
    for (;;)
    {
      int k;
      int m;
      try
      {
        if (this.mDataList == null) {
          break label174;
        }
        k = 0;
        j = 0;
        i = paramInt;
        paramInt = j;
        if ((k >= paramArrayList.size()) || (i < 0) || (i > this.mDataList.size())) {
          break label203;
        }
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(k);
        j = paramInt;
        m = i;
        if (localc == null) {
          break label188;
        }
        b(localc);
        this.mDataList.add(i, localc);
        j = paramInt + 1;
        m = i + 1;
        a(localc, true);
      }
      finally
      {
        AppMethodBeat.o(30414);
      }
      if ((bool) && (this.XAT != null)) {
        this.XAT.gH(i - paramInt, paramInt);
      }
      AppMethodBeat.o(30414);
      return bool;
      label174:
      boolean bool = false;
      int j = 0;
      int i = paramInt;
      paramInt = j;
      continue;
      label188:
      k += 1;
      paramInt = j;
      i = m;
      continue;
      label203:
      bool = true;
    }
  }
  
  public final void bnI(String paramString)
  {
    AppMethodBeat.i(30421);
    if ((Util.isNullOrNil(paramString)) || (this.mDataList == null))
    {
      AppMethodBeat.o(30421);
      return;
    }
    Object localObject = com.tencent.mm.plugin.wenote.c.b.anv(paramString);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      for (;;)
      {
        try
        {
          Log.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, mHasInitDataListFinish :％B", new Object[] { Boolean.valueOf(this.XAU) });
          paramString = bh.baH();
          localObject = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(30408);
              ArrayList localArrayList = h.a(c.d(c.this), this.XAW, false);
              Log.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, start mNotifyListener.setUpNoteData(dataItems, true)");
              if (c.e(c.this) != null) {
                c.e(c.this).j(localArrayList, true);
              }
              AppMethodBeat.o(30408);
            }
          };
          if (!this.XAU) {
            continue;
          }
          l = 500L;
          paramString.postToWorkerDelayed((Runnable)localObject, l);
        }
        catch (Exception paramString)
        {
          long l;
          Log.e("MicroMsg.Note.NoteDataManager", "updateDataByHtml exception,%s", new Object[] { paramString.toString() });
          continue;
        }
        finally
        {
          AppMethodBeat.o(30421);
        }
        AppMethodBeat.o(30421);
        return;
        l = 1000L;
      }
    }
    AppMethodBeat.o(30421);
  }
  
  public final String bnJ(String paramString)
  {
    AppMethodBeat.i(30443);
    label188:
    label196:
    label202:
    label205:
    label212:
    label222:
    label229:
    for (;;)
    {
      int i;
      try
      {
        if (this.mDataList == null) {
          break label202;
        }
        i = 0;
        if (i >= this.mDataList.size()) {
          break label229;
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).getType() != 1) {
          break label196;
        }
        localObject = com.tencent.mm.plugin.wenote.c.b.anw(((i)this.mDataList.get(i)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
        if (Util.isNullOrNil((String)localObject)) {
          break label196;
        }
        localObject = ((String)localObject).split("\n");
        j = 0;
        if (j >= localObject.length) {
          break label188;
        }
        if (Util.isNullOrNil(localObject[j].trim())) {
          break label222;
        }
        localObject = localObject[j];
        j = 1;
      }
      finally
      {
        AppMethodBeat.o(30443);
      }
      Object localObject = paramString;
      if (paramString.length() > 1000) {
        localObject = paramString.substring(0, 1000);
      }
      AppMethodBeat.o(30443);
      return localObject;
      int j = 0;
      localObject = paramString;
      break label205;
      localObject = paramString;
      break label212;
      continue;
      paramString = (String)localObject;
      if (j == 0)
      {
        i += 1;
        paramString = (String)localObject;
        continue;
        j += 1;
      }
    }
  }
  
  public final void dwn()
  {
    AppMethodBeat.i(30422);
    if (this.mDataList != null) {}
    for (int i = this.mDataList.size();; i = 0)
    {
      Log.i("MicroMsg.Note.NoteDataManager", "clear mDataList, size:%d", new Object[] { Integer.valueOf(i) });
      try
      {
        if (this.mDataList != null) {
          this.mDataList.clear();
        }
        this.xyV = 0;
        this.xyU = 0;
        AppMethodBeat.o(30422);
        return;
      }
      finally
      {
        AppMethodBeat.o(30422);
      }
    }
  }
  
  public final int dwo()
  {
    AppMethodBeat.i(30424);
    for (;;)
    {
      try
      {
        if (this.mDataList != null)
        {
          i = 0;
          if (i < this.mDataList.size())
          {
            if (((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).xyb) {
              return i;
            }
            i += 1;
            continue;
          }
        }
        int i = -1;
      }
      finally
      {
        AppMethodBeat.o(30424);
      }
    }
  }
  
  public final void dwp()
  {
    AppMethodBeat.i(30425);
    try
    {
      if (this.mDataList != null)
      {
        Iterator localIterator = this.mDataList.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
          localc.xyb = false;
          localc.xyh = false;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(30425);
    }
    AppMethodBeat.o(30425);
  }
  
  public final int dwr()
  {
    AppMethodBeat.i(30428);
    for (;;)
    {
      try
      {
        if (this.mDataList != null)
        {
          i = 0;
          if (i < this.mDataList.size())
          {
            if ((((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).getType() == 4) && (((l)this.mDataList.get(i)).xyz.booleanValue())) {
              return i;
            }
            i += 1;
            continue;
          }
        }
        int i = -1;
      }
      finally
      {
        AppMethodBeat.o(30428);
      }
    }
  }
  
  public final String dws()
  {
    AppMethodBeat.i(30429);
    for (;;)
    {
      try
      {
        if ((this.xyT != 0) || (this.mDataList == null)) {
          break;
        }
        Iterator localIterator = this.mDataList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        o localo = (o)localIterator.next();
        if (localo.xyo.startsWith("WeNote_"))
        {
          i = Util.getInt(localo.xyo.substring(7), -1);
          if (i > this.xyT) {
            this.xyT = i;
          } else {
            i = this.xyT;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(30429);
      }
    }
    Object localObject2 = new StringBuilder("WeNote_");
    int i = this.xyT + 1;
    this.xyT = i;
    localObject2 = i;
    AppMethodBeat.o(30429);
    return localObject2;
  }
  
  public final String dwu()
  {
    AppMethodBeat.i(30431);
    Object localObject1 = "";
    for (;;)
    {
      int i;
      try
      {
        if ((this.mDataList == null) || (this.mDataList.size() <= 0)) {
          return "";
        }
        i = 0;
        Object localObject3;
        if (i < this.mDataList.size()) {
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i);
        }
        switch (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType())
        {
        case 1: 
          localObject3 = (i)localObject3;
          if (Util.isNullOrNil(((i)localObject3).content))
          {
            localObject1 = (String)localObject1 + "<br/>";
          }
          else
          {
            localObject3 = (String)localObject1 + ((i)localObject3).content;
            localObject1 = localObject3;
            if (i + 1 < this.mDataList.size())
            {
              localObject1 = localObject3;
              if (((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i + 1)).getType() == 1)
              {
                localObject1 = localObject3;
                if (!Util.isNullOrNil(((i)this.mDataList.get(i + 1)).content)) {
                  localObject1 = (String)localObject3 + "<br/>";
                }
              }
            }
          }
          break;
        case 2: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.f)localObject3;
          localObject1 = (String)localObject1 + dT(((com.tencent.mm.plugin.wenote.model.a.f)localObject3).xyo, 2);
          break;
        case 6: 
          localObject3 = (k)localObject3;
          localObject1 = (String)localObject1 + dT(((k)localObject3).xyo, 6);
          break;
        case 20: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.b)localObject3;
          localObject1 = (String)localObject1 + dT(((com.tencent.mm.plugin.wenote.model.a.b)localObject3).xyo, 20);
          break;
        case 4: 
          localObject3 = (l)localObject3;
          localObject1 = (String)localObject1 + dT(((l)localObject3).xyo, ((l)localObject3).getType());
          break;
        case 3: 
          localObject3 = (g)localObject3;
          localObject1 = (String)localObject1 + dT(((g)localObject3).xyo, 3);
          break;
        case 5: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.d)localObject3;
          localObject1 = (String)localObject1 + dT(((com.tencent.mm.plugin.wenote.model.a.d)localObject3).xyo, 5);
          break;
        case -1: 
          localObject1 = (String)localObject1 + "<hr/>";
          break;
          localObject1 = ((String)localObject1).replaceAll("\n", "<br/>");
          return localObject1;
        }
      }
      finally
      {
        AppMethodBeat.o(30431);
      }
      i += 1;
    }
  }
  
  public final ArrayList<com.tencent.mm.plugin.wenote.model.a.c> dwv()
  {
    AppMethodBeat.i(30438);
    if (this.mDataList == null)
    {
      AppMethodBeat.o(30438);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(com.tencent.mm.plugin.wenote.c.c.c((com.tencent.mm.plugin.wenote.model.a.c)localIterator.next()));
      }
    }
    finally
    {
      AppMethodBeat.o(30438);
    }
    AppMethodBeat.o(30438);
    return localArrayList1;
  }
  
  public final void dww()
  {
    AppMethodBeat.i(30440);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30409);
        int i;
        synchronized (c.this)
        {
          if (c.d(c.this) == null)
          {
            AppMethodBeat.o(30409);
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = c.d(c.this).iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            com.tencent.mm.plugin.wenote.model.a.c localc1 = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
            if (localc1.getType() != 1) {
              i += 1;
            } else {
              localStringBuilder.append(((i)localc1).content);
            }
          }
        }
        c.a(c.this, com.tencent.mm.plugin.wenote.c.c.anr(localObject.toString()));
        c.b(c.this, i);
        AppMethodBeat.o(30409);
      }
    });
    AppMethodBeat.o(30440);
  }
  
  public final int dwx()
  {
    AppMethodBeat.i(30444);
    try
    {
      if (this.mDataList == null) {
        return -1;
      }
      int i = 0;
      while (i < this.mDataList.size())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i);
        if ((localc != null) && (localc.getType() != -3) && (localc.getType() != -2)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    finally
    {
      AppMethodBeat.o(30444);
    }
  }
  
  public final int dwy()
  {
    AppMethodBeat.i(30445);
    try
    {
      if (this.mDataList == null) {
        return -1;
      }
      int i = this.mDataList.size() - 1;
      while (i >= 0)
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i);
        if ((localc != null) && (localc.getType() != -3) && (localc.getType() != -2)) {
          return i;
        }
        i -= 1;
      }
      return -1;
    }
    finally
    {
      AppMethodBeat.o(30445);
    }
  }
  
  public final boolean gK(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (paramInt2 < 0) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (this.xyU + paramInt1 > 16384)) {}
        while ((j != 0) && (this.xyV + paramInt2 > 30)) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final void gL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30442);
    Log.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.TRUE });
    for (;;)
    {
      Object localObject3;
      int i;
      Spanned localSpanned2;
      try
      {
        if (this.mDataList == null) {
          return;
        }
        int j = paramInt1;
        if (paramInt1 <= 0) {
          j = 0;
        }
        if (paramInt2 < this.mDataList.size()) {
          break label487;
        }
        paramInt2 = this.mDataList.size() - 1;
        paramInt1 = -1;
        if (paramInt2 <= j) {
          break label443;
        }
        Object localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(paramInt2);
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(paramInt2 - 1);
        i = paramInt1;
        if (localObject1 == null) {
          break label492;
        }
        i = paramInt1;
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() != 1) {
          break label492;
        }
        i = paramInt1;
        if (localObject3 == null) {
          break label492;
        }
        i = paramInt1;
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType() != 1) {
          break label492;
        }
        paramInt1 = paramInt2 - 1;
        localObject1 = (i)localObject1;
        localObject3 = (i)localObject3;
        if (Util.isNullOrNil(((i)localObject1).content)) {
          break label414;
        }
        Spanned localSpanned1 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.anA(((i)localObject1).content);
        localSpanned2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.anA(((i)localObject3).content);
        ((i)localObject3).content = (((i)localObject3).content + "<br/>" + ((i)localObject1).content);
        if (((i)localObject1).xyb)
        {
          ((i)localObject3).xyb = true;
          ((i)localObject3).xyh = false;
          if ((((i)localObject1).xyd == -1) || (((i)localObject1).xyd >= localSpanned1.length()))
          {
            ((i)localObject3).xyd = -1;
            Log.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem remove position: %d", new Object[] { Integer.valueOf(paramInt2) });
            JM(paramInt2);
            i = paramInt1;
            if (this.XAT == null) {
              break label492;
            }
            this.XAT.JI(paramInt2);
            i = paramInt1;
            break label492;
          }
          i = localSpanned2.length();
          ((i)localObject1).xyd += i + 1;
          continue;
        }
        if (!((i)localObject3).xyb) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(30442);
      }
      if (((i)localObject3).xyd == -1)
      {
        ((i)localObject3).xyd = localSpanned2.length();
        continue;
        label414:
        if (localObject2.xyb)
        {
          ((i)localObject3).xyb = true;
          ((i)localObject3).xyh = false;
          ((i)localObject3).xyd = -1;
          continue;
          label443:
          if ((paramInt1 != -1) && (this.XAT != null)) {
            this.XAT.gI(paramInt1, this.mDataList.size() - paramInt1);
          }
          dww();
          AppMethodBeat.o(30442);
          return;
          label487:
          paramInt1 = -1;
          continue;
          label492:
          paramInt2 -= 1;
          paramInt1 = i;
        }
      }
    }
  }
  
  public final void iEh()
  {
    AppMethodBeat.i(179744);
    this.XAT = null;
    if (this.mDataList != null)
    {
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        localc.XAB = null;
        localc.XAz = null;
        localc.XAA = null;
      }
    }
    AppMethodBeat.o(179744);
  }
  
  public final int size()
  {
    AppMethodBeat.i(30411);
    if (this.mDataList != null)
    {
      int i = this.mDataList.size();
      AppMethodBeat.o(30411);
      return i;
    }
    AppMethodBeat.o(30411);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.c
 * JD-Core Version:    0.7.0.1
 */