package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static volatile c EzT = null;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a EzU = null;
  public boolean EzV = false;
  public ArrayList<com.tencent.mm.plugin.wenote.model.a.c> mDataList = null;
  public ajn puv = null;
  public int puw = 0;
  public int pux = 0;
  public int puy = 0;
  
  private boolean BB(int paramInt)
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
      int i = com.tencent.mm.plugin.wenote.c.c.aaM(((com.tencent.mm.plugin.wenote.model.a.i)paramc).content);
      if (paramBoolean)
      {
        this.pux = (i + this.pux);
        AppMethodBeat.o(30441);
        return;
      }
      this.pux -= i;
      AppMethodBeat.o(30441);
      return;
    }
    if (paramBoolean)
    {
      this.puy += 1;
      AppMethodBeat.o(30441);
      return;
    }
    this.puy -= 1;
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
      if (bt.isNullOrNil(localo.ptS)) {
        localo.ptS = ceq();
      }
      locald = com.tencent.mm.plugin.wenote.model.c.eWI().EyD;
      if (locald != null) {
        break label105;
      }
      ad.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", new Object[] { paramc.toString() });
    }
    for (;;)
    {
      if (bt.isNullOrNil(paramc.dsU)) {
        paramc.dsU = com.tencent.mm.plugin.wenote.model.f.aaU(paramc.toString());
      }
      AppMethodBeat.o(30437);
      return;
      label105:
      if (locald.EyK == null) {
        ad.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", new Object[] { paramc.toString() });
      } else {
        locald.EyK.put(localo.ptS, localo);
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
  
  private static String cP(String paramString, int paramInt)
  {
    AppMethodBeat.i(30432);
    paramString = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[] { Integer.valueOf(paramInt), paramString, paramString });
    AppMethodBeat.o(30432);
    return paramString;
  }
  
  private void cen()
  {
    AppMethodBeat.i(30426);
    if (this.mDataList != null)
    {
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        localc.ptF = false;
        localc.ptL = false;
      }
    }
    AppMethodBeat.o(30426);
  }
  
  private String ceq()
  {
    AppMethodBeat.i(30430);
    if ((this.puw == 0) && (this.mDataList != null))
    {
      localObject = this.mDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        o localo = (o)((Iterator)localObject).next();
        if (localo.ptS.startsWith("WeNote_"))
        {
          i = bt.getInt(localo.ptS.substring(7), -1);
          if (i > this.puw) {}
          for (;;)
          {
            this.puw = i;
            break;
            i = this.puw;
          }
        }
      }
    }
    Object localObject = new StringBuilder("WeNote_");
    int i = this.puw + 1;
    this.puw = i;
    localObject = i;
    AppMethodBeat.o(30430);
    return localObject;
  }
  
  public static c eWU()
  {
    AppMethodBeat.i(30410);
    if (EzT == null) {}
    try
    {
      if (EzT == null) {
        EzT = new c();
      }
      c localc = EzT;
      AppMethodBeat.o(30410);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(30410);
    }
  }
  
  public final void BC(int paramInt)
  {
    AppMethodBeat.i(30419);
    if (this.EzU != null) {
      this.EzU.Bv(paramInt);
    }
    AppMethodBeat.o(30419);
  }
  
  public final boolean N(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
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
        localStringBuilder.append(((com.tencent.mm.plugin.wenote.model.a.i)localc).content);
      }
    }
    boolean bool = ff(com.tencent.mm.plugin.wenote.c.c.aaM(localStringBuilder.toString()), i);
    AppMethodBeat.o(30439);
    return bool;
  }
  
  public final boolean W(int paramInt, boolean paramBoolean)
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
        if ((bool1) && (paramBoolean) && (this.EzU != null))
        {
          this.EzU.Bx(paramInt);
          if (paramInt > 0) {
            this.EzU.fd(paramInt - 1, this.mDataList.size() - (paramInt - 1));
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
      this.EzU.fd(paramInt, this.mDataList.size() - paramInt);
    }
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30423);
    for (;;)
    {
      try
      {
        if (this.mDataList == null) {
          return;
        }
        if ((paramInt >= 0) && (paramInt < this.mDataList.size()))
        {
          localc = (com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(paramInt);
          if ((localc != null) && (localc.ptM != paramBoolean))
          {
            localc.ptM = paramBoolean;
            if (this.EzU != null) {
              this.EzU.Bv(paramInt);
            }
          }
          return;
        }
        if (paramInt != -1) {
          continue;
        }
        paramInt = 0;
        if (paramInt >= this.mDataList.size()) {
          continue;
        }
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(paramInt);
        if ((localc != null) && (localc.ptM != paramBoolean))
        {
          localc.ptM = paramBoolean;
          if (this.EzU != null) {
            this.EzU.Bv(paramInt);
          }
        }
      }
      finally
      {
        AppMethodBeat.o(30423);
      }
      paramInt += 1;
    }
  }
  
  public final com.tencent.mm.plugin.wenote.model.a.c XY(int paramInt)
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
  
  public final void Y(int paramInt, boolean paramBoolean)
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
            ((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).ptF = true;
            ((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).ptL = paramBoolean;
          }
          else
          {
            ((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).ptF = false;
            ((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).ptL = false;
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
      ad.e("MicroMsg.Note.NoteDataManager", "pasteItemList,error,return");
      AppMethodBeat.o(30436);
      return -1;
    }
    if (com.tencent.mm.plugin.wenote.model.c.eWI().EyD == null)
    {
      ad.e("MicroMsg.Note.NoteDataManager", "pasteItemList, but get wnnote base is null, return");
      AppMethodBeat.o(30436);
      return -1;
    }
    Object localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(paramArrayList.size() - 1);
    if (localObject1 == null)
    {
      ad.e("MicroMsg.Note.NoteDataManager", "pasteItemList, lastInsertItem is null");
      AppMethodBeat.o(30436);
      return -1;
    }
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).ptH = -1;
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).ptF = true;
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).ptL = false;
    Object localObject3 = XY(paramInt2);
    if (localObject3 == null)
    {
      ad.e("MicroMsg.Note.NoteDataManager", "pasteItemList, item is null");
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
        cen();
        if ((paramInt1 != 0) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType() != 1)) {
          break label896;
        }
        Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.aaV(((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content);
        if ((localObject2 == null) || (paramInt3 > ((Spanned)localObject2).length()) || (paramInt4 > ((Spanned)localObject2).length()))
        {
          if (localObject2 == null)
          {
            paramInt1 = -1;
            ad.e("MicroMsg.Note.NoteDataManager", "pasteItemList error, oriText:%d  startOff:%d  endOff:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
            return -1;
          }
          paramInt1 = ((Spanned)localObject2).length();
          continue;
        }
        localObject1 = ((Spanned)localObject2).subSequence(0, paramInt3);
        CharSequence localCharSequence = ((Spanned)localObject2).subSequence(paramInt4, ((Spanned)localObject2).length());
        localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject1);
        localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localCharSequence);
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.i)localObject3;
        if (!bt.isNullOrNil((String)localObject2))
        {
          if (!((String)localObject2).endsWith("<br/>")) {
            break label879;
          }
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content = ((String)localObject2);
          paramInt2 += 1;
          paramInt1 = paramInt2;
          if (bt.isNullOrNil((String)localObject1)) {
            break label882;
          }
          localObject3 = new com.tencent.mm.plugin.wenote.model.a.i();
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).type = 1;
          localObject2 = localObject1;
          if (((String)localObject1).startsWith("<br/>")) {
            localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
          }
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content = ((String)localObject2);
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptH = 0;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptF = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptL = false;
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
          if (!bt.isNullOrNil((String)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).startsWith("<br/>")) {
              localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
            }
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content = ((String)localObject2);
            paramInt1 = 0;
            paramInt4 = paramInt2;
            paramInt3 = paramInt2;
            paramInt2 = paramInt4;
            continue;
          }
          BB(paramInt2);
          paramInt1 = paramInt2;
          if (this.EzU == null) {
            break label882;
          }
          this.EzU.Bx(paramInt2);
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
        if ((j - 1 >= 0) && (j - 1 < eWU().size()))
        {
          paramInt1 = j - 1;
          if (this.EzU != null)
          {
            paramInt3 = j - i;
            paramInt2 = paramInt3;
            if (paramInt4 != 0) {
              paramInt2 = paramInt3 + 1;
            }
            if ((i >= 0) && (paramInt2 > 0)) {
              this.EzU.fc(i, paramInt2);
            }
            if (i <= 0) {
              break label840;
            }
            this.EzU.fd(i - 1, eWU().size() - (i - 1));
            this.EzU.By(paramInt1);
          }
          cet();
          AppMethodBeat.o(30436);
          return paramInt1;
        }
      }
      finally
      {
        AppMethodBeat.o(30436);
      }
      paramInt1 = eWU().size() - 1;
      continue;
      label840:
      if (i == 0)
      {
        this.EzU.fd(i, eWU().size() - i);
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
      ad.e("MicroMsg.Note.NoteDataManager", "insertItemList,error,return");
      AppMethodBeat.o(30435);
      return -1;
    }
    if (com.tencent.mm.plugin.wenote.model.c.eWI().EyD == null)
    {
      ad.e("MicroMsg.Note.NoteDataManager", "insertItemList, but get wnnote base is null, return");
      AppMethodBeat.o(30435);
      return -1;
    }
    if ((paramBoolean2) && (N(paramArrayList)) && (this.EzU != null))
    {
      this.EzU.cds();
      AppMethodBeat.o(30435);
      return -1;
    }
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(paramArrayList.size() - 1);
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).ptH = -1;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).ptF = true;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).ptL = false;
      if ((paramWXRTEditText != null) && (paramWXRTEditText.pvv))
      {
        if (paramWXRTEditText.getEditTextType() != 2) {
          break label286;
        }
        ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).ptO = 2;
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
      paramWXRTEditText.pvv = false;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).ptP = paramWXRTEditText.ptP;
      paramWXRTEditText.ptP = 0;
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getRecyclerItemPosition() != 0)) {
        if (paramWXRTEditText != null) {
          break label646;
        }
      }
      try
      {
        n = size();
        cen();
        paramArrayList = paramArrayList.iterator();
        i = n;
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
            b(paramWXRTEditText);
            if ((paramWXRTEditText == null) || (this.mDataList == null)) {
              break label1272;
            }
            this.mDataList.add(paramWXRTEditText);
            a(paramWXRTEditText, true);
            j = 1;
            if (j == 0) {
              break label1278;
            }
            i += 1;
            continue;
            if (paramWXRTEditText.getEditTextType() != 1) {
              break;
            }
            ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).ptO = 1;
            break;
            if ((paramWXRTEditText.getEditTextType() == 2) || (paramWXRTEditText.getSelectionStart() != 0) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
              break label194;
            }
            i = ((com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(0)).getType();
            if ((i != 2) && (i != 6) && (i != 5) && (i != 3) && (i != 4)) {
              break label194;
            }
            localObject1 = new com.tencent.mm.plugin.wenote.model.a.i();
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content = "";
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).ptF = false;
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).ptL = false;
            paramArrayList.add(0, localObject1);
            break label194;
          }
        }
        i1 = 0;
        if ((i - 1 < 0) || (i - 1 >= eWU().size())) {
          break;
        }
        j = i - 1;
        k = j;
        m = i;
        if (paramBoolean4)
        {
          j += 1;
          i += 1;
          cen();
          if (j >= eWU().size()) {
            break label1167;
          }
          paramArrayList = eWU().XY(j);
          k = j;
          m = i;
          if (paramArrayList != null)
          {
            paramArrayList.ptH = 0;
            paramArrayList.ptF = true;
            paramArrayList.ptL = false;
            m = i;
            k = j;
          }
        }
        label527:
        if (this.EzU != null)
        {
          j = m - n;
          i = j;
          if (i1 != 0) {
            i = j + 1;
          }
          if ((n >= 0) && (i > 0)) {
            this.EzU.fc(n, i);
          }
          if (n <= 0) {
            break label1221;
          }
          this.EzU.fd(n - 1, eWU().size() - (n - 1));
          label608:
          if (paramBoolean3) {
            this.EzU.cdr();
          }
          this.EzU.By(k);
        }
        cet();
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
    localObject2 = XY(j);
    if (localObject2 == null)
    {
      AppMethodBeat.o(30435);
      return -1;
    }
    cen();
    if ((paramWXRTEditText.getEditTextType() == 0) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() == 1))
    {
      localObject1 = paramWXRTEditText.getSelection();
      localObject3 = paramWXRTEditText.getText();
      paramWXRTEditText = ((Editable)localObject3).subSequence(0, ((e)localObject1).avj);
      localObject3 = ((Editable)localObject3).subSequence(((e)localObject1).OQ, ((Editable)localObject3).length());
      localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)paramWXRTEditText);
      paramWXRTEditText = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject3);
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.i)localObject2;
      if (!bt.isNullOrNil((String)localObject1))
      {
        if (((String)localObject1).endsWith("<br/>"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
          label801:
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content = ((String)localObject1);
          j += 1;
          i = j;
          if (bt.isNullOrNil(paramWXRTEditText)) {
            break label1291;
          }
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.i();
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).type = 1;
          localObject1 = paramWXRTEditText;
          if (paramWXRTEditText.startsWith("<br/>")) {
            localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
          }
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content = ((String)localObject1);
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptH = 0;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptF = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptL = false;
          b(j, (com.tencent.mm.plugin.wenote.model.a.c)localObject2);
          i = j;
          k = 1;
          m = j;
          j = i;
          i = m;
        }
      }
      else
      {
        for (;;)
        {
          label917:
          paramArrayList = paramArrayList.iterator();
          m = i;
          label926:
          i = m;
          n = j;
          i1 = k;
          if (!paramArrayList.hasNext()) {
            break;
          }
          paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
          b(paramWXRTEditText);
          if (!b(m, paramWXRTEditText)) {
            break label1265;
          }
          i = m + 1;
          break label1281;
          if (bt.isNullOrNil(paramWXRTEditText)) {
            break label1041;
          }
          localObject1 = paramWXRTEditText;
          if (paramWXRTEditText.startsWith("<br/>")) {
            localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
          }
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content = ((String)localObject1);
          k = j;
          m = 0;
          i = j;
          j = k;
          k = m;
        }
        label1041:
        BB(j);
        i = j;
        if (this.EzU == null) {
          break label1291;
        }
        this.EzU.Bx(j);
        i = j;
        break label1291;
      }
    }
    else if (paramWXRTEditText.getEditTextType() != 1)
    {
      j += 1;
      label1091:
      paramArrayList = paramArrayList.iterator();
      i = j;
    }
    label1167:
    label1301:
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
        b(paramWXRTEditText);
        if (!b(i, paramWXRTEditText)) {
          break label1259;
        }
        i += 1;
        break label1301;
        j = eWU().size() - 1;
        break label443;
        paramArrayList = new com.tencent.mm.plugin.wenote.model.a.i();
        paramArrayList.type = 1;
        paramArrayList.content = "";
        paramArrayList.ptH = 0;
        paramArrayList.ptF = true;
        paramArrayList.ptL = false;
        b(j, paramArrayList);
        k = j;
        m = i;
        break label527;
        label1221:
        if (n != 0) {
          break label608;
        }
        this.EzU.fd(n, eWU().size() - n);
        break label608;
      }
      i1 = 0;
      n = j;
      break label415;
      label1259:
      break label1301;
      break label1091;
      label1265:
      i = m;
      break label1281;
      label1272:
      j = 0;
      break;
      label1278:
      break label283;
      m = i;
      break label926;
      break label801;
      j = i;
      k = 0;
      break label917;
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
          if (!((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).eWO().equals(paramString)) {
            continue;
          }
          a((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i), false);
          this.mDataList.set(i, paramc);
          a(paramc, true);
          if ((i != -1) && (this.EzU != null)) {
            this.EzU.Bv(i);
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
        if ((bool) && (this.EzU != null))
        {
          this.EzU.Bw(paramInt);
          if (paramInt > 0) {
            this.EzU.fd(paramInt - 1, this.mDataList.size() - (paramInt - 1));
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
      this.EzU.fd(paramInt, this.mDataList.size() - paramInt);
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
  
  public final void aKi(String paramString)
  {
    AppMethodBeat.i(30421);
    if ((bt.isNullOrNil(paramString)) || (this.mDataList == null))
    {
      AppMethodBeat.o(30421);
      return;
    }
    Object localObject = com.tencent.mm.plugin.wenote.c.b.aaQ(paramString);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      for (;;)
      {
        try
        {
          ad.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, mHasInitDataListFinish :％B", new Object[] { Boolean.valueOf(this.EzV) });
          paramString = ba.ajF();
          localObject = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(30408);
              ArrayList localArrayList = h.a(c.d(c.this), this.EzX, false);
              ad.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, start mNotifyListener.setUpNoteData(dataItems, true)");
              if (c.e(c.this) != null) {
                c.e(c.this).g(localArrayList, true);
              }
              AppMethodBeat.o(30408);
            }
          };
          if (!this.EzV) {
            continue;
          }
          l = 500L;
          paramString.n((Runnable)localObject, l);
        }
        catch (Exception paramString)
        {
          long l;
          ad.e("MicroMsg.Note.NoteDataManager", "updateDataByHtml exception,%s", new Object[] { paramString.toString() });
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
  
  public final String aKj(String paramString)
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
        localObject = com.tencent.mm.plugin.wenote.c.b.aaR(((com.tencent.mm.plugin.wenote.model.a.i)this.mDataList.get(i)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
        if (bt.isNullOrNil((String)localObject)) {
          break label196;
        }
        localObject = ((String)localObject).split("\n");
        j = 0;
        if (j >= localObject.length) {
          break label188;
        }
        if (bt.isNullOrNil(localObject[j].trim())) {
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
  
  public final akd aaX(String paramString)
  {
    AppMethodBeat.i(30433);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
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
        if (bt.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).dsU)) {
          ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).dsU = com.tencent.mm.plugin.wenote.model.f.aaU(localObject1.toString());
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == -1) {
          if ((localArrayList.size() > 0) && (((o)localArrayList.get(localArrayList.size() - 1)).type == 1))
          {
            localObject1 = new StringBuilder();
            localObject2 = (com.tencent.mm.plugin.wenote.model.a.i)localArrayList.get(localArrayList.size() - 1);
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content += "\n";
          }
          else
          {
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.i();
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content = "\n";
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).dsU = ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).dsU;
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptS = "-1";
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).type = 1;
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptR = null;
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
        if (((((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 6) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 4)) && (bt.isNullOrNil(((o)localObject1).dBx)))
        {
          localObject2 = new ajn();
          ((ajn)localObject2).aOs(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).dsU);
          ((ajn)localObject2).aOp(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).ceb());
          localObject2 = com.tencent.mm.plugin.wenote.model.f.b((ajn)localObject2);
          if (com.tencent.mm.vfs.i.fv((String)localObject2))
          {
            ad.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType()) });
            ((o)localObject1).dBx = ((String)localObject2);
          }
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() != 1)
        {
          localArrayList.add((o)localObject1);
        }
        else
        {
          localObject1 = (com.tencent.mm.plugin.wenote.model.a.i)localObject1;
          if (bt.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content))
          {
            if ((localArrayList.size() > 0) && (((o)localArrayList.get(localArrayList.size() - 1)).getType() == 1))
            {
              localObject1 = new StringBuilder();
              localObject2 = (com.tencent.mm.plugin.wenote.model.a.i)localArrayList.get(localArrayList.size() - 1);
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content += "<br/>";
            }
            else
            {
              localObject2 = new com.tencent.mm.plugin.wenote.model.a.i();
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content = "<br/>";
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).dsU = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).dsU;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptS = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).ptS;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).type = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).type;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptR = null;
              localArrayList.add(localObject2);
            }
          }
          else
          {
            Object localObject3;
            if ((localArrayList.size() > 0) && (((o)localArrayList.get(localArrayList.size() - 1)).getType() == 1))
            {
              localObject2 = new StringBuilder();
              localObject3 = (com.tencent.mm.plugin.wenote.model.a.i)localArrayList.get(localArrayList.size() - 1);
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content += ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content;
            }
            while ((i + 1 < this.mDataList.size()) && (((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i + 1)).getType() == 1) && (!bt.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i)this.mDataList.get(i + 1)).content)))
            {
              localObject1 = new StringBuilder();
              localObject2 = (com.tencent.mm.plugin.wenote.model.a.i)localArrayList.get(localArrayList.size() - 1);
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content += "<br/>";
              break;
              localObject2 = new com.tencent.mm.plugin.wenote.model.a.i();
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).dsU = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).dsU;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptS = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).ptS;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).type = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).type;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptR = null;
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
                    ((com.tencent.mm.vfs.e)localObject3).createNewFile();
                    if ((i != 0) || (com.tencent.mm.vfs.i.f((String)localObject2, paramString, paramString.length) != 0)) {
                      break;
                    }
                    this.puv.aOt((String)localObject2);
                    ad.i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
                    paramString = com.tencent.mm.plugin.wenote.model.d.a((String)localObject1, localArrayList, this.puv);
                    AppMethodBeat.o(30433);
                    return paramString;
                  }
                  catch (IOException paramString)
                  {
                    ad.printErrStackTrace("MicroMsg.Note.NoteDataManager", paramString, "", new Object[0]);
                    AppMethodBeat.o(30433);
                    return null;
                  }
                  paramString = paramString;
                  ad.printErrStackTrace("MicroMsg.Note.NoteDataManager", paramString, "", new Object[0]);
                  ad.e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
                  i = 1;
                  paramString = null;
                }
              }
              this.puv.ZI(8);
              this.puv.aOC("WeNoteHtmlFile");
              this.puv.wl(true);
              this.puv.aOp(".htm");
              this.puv.aOs(com.tencent.mm.plugin.wenote.model.f.aaU(this.puv.toString()));
              localObject2 = com.tencent.mm.plugin.wenote.model.f.b(this.puv);
              ad.i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", new Object[] { localObject2 });
              localObject3 = new com.tencent.mm.vfs.e((String)localObject2);
              if (((com.tencent.mm.vfs.e)localObject3).exists()) {
                ((com.tencent.mm.vfs.e)localObject3).delete();
              }
              if (!((com.tencent.mm.vfs.e)localObject3).exists()) {}
              ad.i("MicroMsg.Note.NoteDataManager", "writefile error,return");
              Toast.makeText(aj.getContext(), aj.getContext().getString(2131758993), 1).show();
              AppMethodBeat.o(30433);
              return null;
            }
          }
        }
      }
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
      if ((bool) && (this.EzU != null)) {
        this.EzU.fc(i - paramInt, paramInt);
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
  
  public final void cek()
  {
    AppMethodBeat.i(30422);
    if (this.mDataList != null) {}
    for (int i = this.mDataList.size();; i = 0)
    {
      ad.i("MicroMsg.Note.NoteDataManager", "clear mDataList, size:%d", new Object[] { Integer.valueOf(i) });
      try
      {
        if (this.mDataList != null) {
          this.mDataList.clear();
        }
        this.puy = 0;
        this.pux = 0;
        AppMethodBeat.o(30422);
        return;
      }
      finally
      {
        AppMethodBeat.o(30422);
      }
    }
  }
  
  public final int cel()
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
            if (((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).ptF) {
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
  
  public final void cem()
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
          localc.ptF = false;
          localc.ptL = false;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(30425);
    }
    AppMethodBeat.o(30425);
  }
  
  public final int ceo()
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
            if ((((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i)).getType() == 4) && (((l)this.mDataList.get(i)).puc.booleanValue())) {
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
  
  public final String cep()
  {
    AppMethodBeat.i(30429);
    for (;;)
    {
      try
      {
        if ((this.puw != 0) || (this.mDataList == null)) {
          break;
        }
        Iterator localIterator = this.mDataList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        o localo = (o)localIterator.next();
        if (localo.ptS.startsWith("WeNote_"))
        {
          i = bt.getInt(localo.ptS.substring(7), -1);
          if (i > this.puw) {
            this.puw = i;
          } else {
            i = this.puw;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(30429);
      }
    }
    Object localObject2 = new StringBuilder("WeNote_");
    int i = this.puw + 1;
    this.puw = i;
    localObject2 = i;
    AppMethodBeat.o(30429);
    return localObject2;
  }
  
  public final String cer()
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
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.i)localObject3;
          if (bt.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content))
          {
            localObject1 = (String)localObject1 + "<br/>";
          }
          else
          {
            localObject3 = (String)localObject1 + ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content;
            localObject1 = localObject3;
            if (i + 1 < this.mDataList.size())
            {
              localObject1 = localObject3;
              if (((com.tencent.mm.plugin.wenote.model.a.c)this.mDataList.get(i + 1)).getType() == 1)
              {
                localObject1 = localObject3;
                if (!bt.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i)this.mDataList.get(i + 1)).content)) {
                  localObject1 = (String)localObject3 + "<br/>";
                }
              }
            }
          }
          break;
        case 2: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.f)localObject3;
          localObject1 = (String)localObject1 + cP(((com.tencent.mm.plugin.wenote.model.a.f)localObject3).ptS, 2);
          break;
        case 6: 
          localObject3 = (k)localObject3;
          localObject1 = (String)localObject1 + cP(((k)localObject3).ptS, 6);
          break;
        case 20: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.b)localObject3;
          localObject1 = (String)localObject1 + cP(((com.tencent.mm.plugin.wenote.model.a.b)localObject3).ptS, 20);
          break;
        case 4: 
          localObject3 = (l)localObject3;
          localObject1 = (String)localObject1 + cP(((l)localObject3).ptS, ((l)localObject3).getType());
          break;
        case 3: 
          localObject3 = (g)localObject3;
          localObject1 = (String)localObject1 + cP(((g)localObject3).ptS, 3);
          break;
        case 5: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.d)localObject3;
          localObject1 = (String)localObject1 + cP(((com.tencent.mm.plugin.wenote.model.a.d)localObject3).ptS, 5);
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
  
  public final ArrayList<com.tencent.mm.plugin.wenote.model.a.c> ces()
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
  
  public final void cet()
  {
    AppMethodBeat.i(30440);
    ba.ajF().ay(new Runnable()
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
              localStringBuilder.append(((com.tencent.mm.plugin.wenote.model.a.i)localc1).content);
            }
          }
        }
        c.a(c.this, com.tencent.mm.plugin.wenote.c.c.aaM(localObject.toString()));
        c.b(c.this, i);
        AppMethodBeat.o(30409);
      }
    });
    AppMethodBeat.o(30440);
  }
  
  public final int ceu()
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
  
  public final int cev()
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
  
  public final void eWV()
  {
    AppMethodBeat.i(179744);
    this.EzU = null;
    if (this.mDataList != null)
    {
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        localc.EzC = null;
        localc.EzA = null;
        localc.EzB = null;
      }
    }
    AppMethodBeat.o(179744);
  }
  
  public final boolean ff(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (paramInt2 < 0) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (this.pux + paramInt1 > 16384)) {}
        while ((j != 0) && (this.puy + paramInt2 > 30)) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final void fg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30442);
    ad.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.TRUE });
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
        localObject1 = (com.tencent.mm.plugin.wenote.model.a.i)localObject1;
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.i)localObject3;
        if (bt.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content)) {
          break label414;
        }
        Spanned localSpanned1 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.aaV(((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content);
        localSpanned2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.aaV(((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content);
        ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content = (((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content + "<br/>" + ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content);
        if (((com.tencent.mm.plugin.wenote.model.a.i)localObject1).ptF)
        {
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptF = true;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptL = false;
          if ((((com.tencent.mm.plugin.wenote.model.a.i)localObject1).ptH == -1) || (((com.tencent.mm.plugin.wenote.model.a.i)localObject1).ptH >= localSpanned1.length()))
          {
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptH = -1;
            ad.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem remove position: %d", new Object[] { Integer.valueOf(paramInt2) });
            BB(paramInt2);
            i = paramInt1;
            if (this.EzU == null) {
              break label492;
            }
            this.EzU.Bx(paramInt2);
            i = paramInt1;
            break label492;
          }
          i = localSpanned2.length();
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).ptH += i + 1;
          continue;
        }
        if (!((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptF) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(30442);
      }
      if (((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptH == -1)
      {
        ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptH = localSpanned2.length();
        continue;
        label414:
        if (localObject2.ptF)
        {
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptF = true;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptL = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).ptH = -1;
          continue;
          label443:
          if ((paramInt1 != -1) && (this.EzU != null)) {
            this.EzU.fd(paramInt1, this.mDataList.size() - paramInt1);
          }
          cet();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.c
 * JD-Core Version:    0.7.0.1
 */