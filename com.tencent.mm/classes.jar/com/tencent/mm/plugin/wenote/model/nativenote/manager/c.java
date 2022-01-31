package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static volatile c vyc = null;
  public ArrayList<com.tencent.mm.plugin.wenote.model.a.c> iVH = null;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a vyd = null;
  public aca vye = null;
  public int vyf = 0;
  public int vyg = 0;
  public int vyh = 0;
  public boolean vyi = false;
  
  private boolean Lk(int paramInt)
  {
    AppMethodBeat.i(26725);
    if ((this.iVH != null) && (paramInt >= 0) && (paramInt < this.iVH.size()))
    {
      a((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(paramInt), false);
      this.iVH.remove(paramInt);
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(26725);
      return bool;
    }
  }
  
  private void a(com.tencent.mm.plugin.wenote.model.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(26748);
    if (paramc == null)
    {
      AppMethodBeat.o(26748);
      return;
    }
    if (paramc.getType() == 1)
    {
      int i = com.tencent.mm.plugin.wenote.b.c.ajU(((i)paramc).content);
      if (paramBoolean)
      {
        this.vyg = (i + this.vyg);
        AppMethodBeat.o(26748);
        return;
      }
      this.vyg -= i;
      AppMethodBeat.o(26748);
      return;
    }
    if (paramBoolean)
    {
      this.vyh += 1;
      AppMethodBeat.o(26748);
      return;
    }
    this.vyh -= 1;
    AppMethodBeat.o(26748);
  }
  
  private void b(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    AppMethodBeat.i(26744);
    if (paramc == null)
    {
      AppMethodBeat.o(26744);
      return;
    }
    o localo = (o)paramc;
    com.tencent.mm.plugin.wenote.model.d locald;
    if (localo.getType() > 1)
    {
      if (bo.isNullOrNil(localo.vxr)) {
        localo.vxr = diu();
      }
      locald = com.tencent.mm.plugin.wenote.model.c.dhH().vvQ;
      if (locald != null) {
        break label105;
      }
      ab.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", new Object[] { paramc.toString() });
    }
    for (;;)
    {
      if (bo.isNullOrNil(paramc.mBq)) {
        paramc.mBq = com.tencent.mm.plugin.wenote.model.f.ajF(paramc.toString());
      }
      AppMethodBeat.o(26744);
      return;
      label105:
      if (locald.vvW == null) {
        ab.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", new Object[] { paramc.toString() });
      } else {
        locald.vvW.put(localo.vxr, localo);
      }
    }
  }
  
  private boolean b(int paramInt, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(26723);
    if ((paramc != null) && (this.iVH != null) && (paramInt >= 0) && (paramInt <= this.iVH.size()))
    {
      this.iVH.add(paramInt, paramc);
      a(paramc, true);
    }
    for (;;)
    {
      AppMethodBeat.o(26723);
      return bool;
      bool = false;
    }
  }
  
  public static c din()
  {
    AppMethodBeat.i(26717);
    if (vyc == null) {}
    try
    {
      if (vyc == null) {
        vyc = new c();
      }
      c localc = vyc;
      AppMethodBeat.o(26717);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(26717);
    }
  }
  
  private void dir()
  {
    AppMethodBeat.i(26733);
    if (this.iVH != null)
    {
      Iterator localIterator = this.iVH.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        localc.vwW = false;
        localc.vxc = false;
      }
    }
    AppMethodBeat.o(26733);
  }
  
  private String diu()
  {
    AppMethodBeat.i(26737);
    if ((this.vyf == 0) && (this.iVH != null))
    {
      localObject = this.iVH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        o localo = (o)((Iterator)localObject).next();
        if (localo.vxr.startsWith("WeNote_"))
        {
          i = bo.getInt(localo.vxr.substring(7), -1);
          if (i > this.vyf) {}
          for (;;)
          {
            this.vyf = i;
            break;
            i = this.vyf;
          }
        }
      }
    }
    Object localObject = new StringBuilder("WeNote_");
    int i = this.vyf + 1;
    this.vyf = i;
    localObject = i;
    AppMethodBeat.o(26737);
    return localObject;
  }
  
  private static String ed(String paramString, int paramInt)
  {
    AppMethodBeat.i(26739);
    paramString = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[] { Integer.valueOf(paramInt), paramString, paramString });
    AppMethodBeat.o(26739);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.wenote.model.a.c Lj(int paramInt)
  {
    AppMethodBeat.i(26719);
    if ((this.iVH != null) && (paramInt >= 0) && (paramInt < this.iVH.size()))
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(paramInt);
      AppMethodBeat.o(26719);
      return localc;
    }
    AppMethodBeat.o(26719);
    return null;
  }
  
  public final void Ll(int paramInt)
  {
    AppMethodBeat.i(26726);
    if (this.vyd != null) {
      this.vyd.Lc(paramInt);
    }
    AppMethodBeat.o(26726);
  }
  
  public final int a(com.tencent.mm.plugin.wenote.model.a.c paramc, WXRTEditText paramWXRTEditText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(26741);
    if (paramc == null)
    {
      AppMethodBeat.o(26741);
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramc);
    int i = a(localArrayList, paramWXRTEditText, true, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(26741);
    return i;
  }
  
  public final int a(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(26743);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.iVH == null) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt4 < paramInt3))
    {
      ab.e("MicroMsg.Note.NoteDataManager", "pasteItemList,error,return");
      AppMethodBeat.o(26743);
      return -1;
    }
    if (com.tencent.mm.plugin.wenote.model.c.dhH().vvQ == null)
    {
      ab.e("MicroMsg.Note.NoteDataManager", "pasteItemList, but get wnnote base is null, return");
      AppMethodBeat.o(26743);
      return -1;
    }
    Object localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(paramArrayList.size() - 1);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.Note.NoteDataManager", "pasteItemList, lastInsertItem is null");
      AppMethodBeat.o(26743);
      return -1;
    }
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).vwY = -1;
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).vwW = true;
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).vxc = false;
    Object localObject3 = Lj(paramInt2);
    if (localObject3 == null)
    {
      ab.e("MicroMsg.Note.NoteDataManager", "pasteItemList, item is null");
      AppMethodBeat.o(26743);
      return -1;
    }
    label905:
    label908:
    for (;;)
    {
      label490:
      label495:
      int j;
      int i;
      try
      {
        dir();
        if ((paramInt1 != 0) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType() != 1)) {
          break label893;
        }
        Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ajK(((i)localObject3).content);
        if ((localObject2 == null) || (paramInt3 > ((Spanned)localObject2).length()) || (paramInt4 > ((Spanned)localObject2).length()))
        {
          if (localObject2 == null)
          {
            paramInt1 = -1;
            ab.e("MicroMsg.Note.NoteDataManager", "pasteItemList error, oriText:%d  startOff:%d  endOff:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
        if (!bo.isNullOrNil((String)localObject2))
        {
          if (!((String)localObject2).endsWith("<br/>")) {
            break label876;
          }
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
          ((i)localObject3).content = ((String)localObject2);
          paramInt2 += 1;
          paramInt1 = paramInt2;
          if (bo.isNullOrNil((String)localObject1)) {
            break label879;
          }
          localObject3 = new i();
          ((i)localObject3).type = 1;
          localObject2 = localObject1;
          if (((String)localObject1).startsWith("<br/>")) {
            localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
          }
          ((i)localObject3).content = ((String)localObject2);
          ((i)localObject3).vwY = 0;
          ((i)localObject3).vwW = false;
          ((i)localObject3).vxc = false;
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
              break label873;
            }
            paramInt3 += 1;
            break label873;
          }
        }
        else
        {
          if (!bo.isNullOrNil((String)localObject1))
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
          Lk(paramInt2);
          paramInt1 = paramInt2;
          if (this.vyd == null) {
            break label879;
          }
          this.vyd.Le(paramInt2);
          paramInt1 = paramInt2;
          break label879;
          label638:
          paramArrayList = paramArrayList.iterator();
          paramInt2 = paramInt1;
          if (!paramArrayList.hasNext()) {
            break label908;
          }
          localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
          b((com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          if (!b(paramInt2, (com.tencent.mm.plugin.wenote.model.a.c)localObject1)) {
            break label865;
          }
          paramInt2 += 1;
          break label905;
        }
        if ((j - 1 >= 0) && (j - 1 < din().size()))
        {
          paramInt1 = j - 1;
          if (this.vyd != null)
          {
            paramInt3 = j - i;
            paramInt2 = paramInt3;
            if (paramInt4 != 0) {
              paramInt2 = paramInt3 + 1;
            }
            if ((i >= 0) && (paramInt2 > 0)) {
              this.vyd.gS(i, paramInt2);
            }
            if (i <= 0) {
              break label837;
            }
            this.vyd.gT(i - 1, din().size() - (i - 1));
            this.vyd.Lf(paramInt1);
          }
          dix();
          AppMethodBeat.o(26743);
          return paramInt1;
        }
      }
      finally
      {
        AppMethodBeat.o(26743);
      }
      paramInt1 = din().size() - 1;
      continue;
      label837:
      if (i == 0)
      {
        this.vyd.gT(i, din().size() - i);
        continue;
        label865:
        break label905;
        label873:
        label876:
        label879:
        label893:
        do
        {
          paramInt1 = paramInt2;
          break label638;
          break label495;
          break;
          paramInt4 = 0;
          paramInt2 = paramInt1;
          paramInt3 = paramInt1;
          paramInt1 = paramInt4;
          break label490;
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
    AppMethodBeat.i(26742);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.iVH == null))
    {
      ab.e("MicroMsg.Note.NoteDataManager", "insertItemList,error,return");
      AppMethodBeat.o(26742);
      return -1;
    }
    if (com.tencent.mm.plugin.wenote.model.c.dhH().vvQ == null)
    {
      ab.e("MicroMsg.Note.NoteDataManager", "insertItemList, but get wnnote base is null, return");
      AppMethodBeat.o(26742);
      return -1;
    }
    if ((paramBoolean2) && (ag(paramArrayList)) && (this.vyd != null))
    {
      this.vyd.dhX();
      AppMethodBeat.o(26742);
      return -1;
    }
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(paramArrayList.size() - 1);
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).vwY = -1;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).vwW = true;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).vxc = false;
      if ((paramWXRTEditText != null) && (paramWXRTEditText.vzf))
      {
        if (paramWXRTEditText.getEditTextType() != 2) {
          break label286;
        }
        ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).vxf = 2;
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
      paramWXRTEditText.vzf = false;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).vxg = paramWXRTEditText.vxg;
      paramWXRTEditText.vxg = 0;
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getRecyclerItemPosition() != 0)) {
        if (paramWXRTEditText != null) {
          break label646;
        }
      }
      try
      {
        n = size();
        dir();
        paramArrayList = paramArrayList.iterator();
        i = n;
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
            b(paramWXRTEditText);
            if ((paramWXRTEditText == null) || (this.iVH == null)) {
              break label1272;
            }
            this.iVH.add(paramWXRTEditText);
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
            ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).vxf = 1;
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
            ((i)localObject1).vwW = false;
            ((i)localObject1).vxc = false;
            paramArrayList.add(0, localObject1);
            break label194;
          }
        }
        i1 = 0;
        if ((i - 1 < 0) || (i - 1 >= din().size())) {
          break;
        }
        j = i - 1;
        k = j;
        m = i;
        if (paramBoolean4)
        {
          j += 1;
          i += 1;
          dir();
          if (j >= din().size()) {
            break label1167;
          }
          paramArrayList = din().Lj(j);
          k = j;
          m = i;
          if (paramArrayList != null)
          {
            paramArrayList.vwY = 0;
            paramArrayList.vwW = true;
            paramArrayList.vxc = false;
            m = i;
            k = j;
          }
        }
        label527:
        if (this.vyd != null)
        {
          j = m - n;
          i = j;
          if (i1 != 0) {
            i = j + 1;
          }
          if ((n >= 0) && (i > 0)) {
            this.vyd.gS(n, i);
          }
          if (n <= 0) {
            break label1221;
          }
          this.vyd.gT(n - 1, din().size() - (n - 1));
          label608:
          if (paramBoolean3) {
            this.vyd.dhW();
          }
          this.vyd.Lf(k);
        }
        dix();
        AppMethodBeat.o(26742);
        return k;
      }
      finally
      {
        label646:
        Object localObject2;
        Object localObject3;
        AppMethodBeat.o(26742);
      }
    }
    int j = paramWXRTEditText.getRecyclerItemPosition();
    localObject2 = Lj(j);
    if (localObject2 == null)
    {
      AppMethodBeat.o(26742);
      return -1;
    }
    dir();
    if ((paramWXRTEditText.getEditTextType() == 0) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() == 1))
    {
      localObject1 = paramWXRTEditText.getSelection();
      localObject3 = paramWXRTEditText.getText();
      paramWXRTEditText = ((Editable)localObject3).subSequence(0, ((e)localObject1).akX);
      localObject3 = ((Editable)localObject3).subSequence(((e)localObject1).Fe, ((Editable)localObject3).length());
      localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)paramWXRTEditText);
      paramWXRTEditText = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject3);
      localObject2 = (i)localObject2;
      if (!bo.isNullOrNil((String)localObject1))
      {
        if (((String)localObject1).endsWith("<br/>"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
          label801:
          ((i)localObject2).content = ((String)localObject1);
          j += 1;
          i = j;
          if (bo.isNullOrNil(paramWXRTEditText)) {
            break label1291;
          }
          localObject2 = new i();
          ((i)localObject2).type = 1;
          localObject1 = paramWXRTEditText;
          if (paramWXRTEditText.startsWith("<br/>")) {
            localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
          }
          ((i)localObject2).content = ((String)localObject1);
          ((i)localObject2).vwY = 0;
          ((i)localObject2).vwW = false;
          ((i)localObject2).vxc = false;
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
          if (bo.isNullOrNil(paramWXRTEditText)) {
            break label1041;
          }
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
        }
        label1041:
        Lk(j);
        i = j;
        if (this.vyd == null) {
          break label1291;
        }
        this.vyd.Le(j);
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
        j = din().size() - 1;
        break label443;
        paramArrayList = new i();
        paramArrayList.type = 1;
        paramArrayList.content = "";
        paramArrayList.vwY = 0;
        paramArrayList.vwW = true;
        paramArrayList.vxc = false;
        b(j, paramArrayList);
        k = j;
        m = i;
        break label527;
        label1221:
        if (n != 0) {
          break label608;
        }
        this.vyd.gT(n, din().size() - n);
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
    AppMethodBeat.i(26727);
    for (;;)
    {
      try
      {
        if (this.iVH == null)
        {
          return;
          i += 1;
        }
        if (i < this.iVH.size())
        {
          if (!((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i)).dhQ().equals(paramString)) {
            continue;
          }
          a((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i), false);
          this.iVH.set(i, paramc);
          a(paramc, true);
          if ((i != -1) && (this.vyd != null)) {
            this.vyd.Lc(i);
          }
          AppMethodBeat.o(26727);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(26727);
      }
      i = -1;
    }
  }
  
  public final boolean a(int paramInt, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(26722);
    for (;;)
    {
      try
      {
        if ((this.iVH == null) || (paramInt < 0) || (paramInt > this.iVH.size())) {
          break label138;
        }
        this.iVH.add(paramInt, paramc);
        a(paramc, true);
        if ((bool) && (this.vyd != null))
        {
          this.vyd.Ld(paramInt);
          if (paramInt > 0) {
            this.vyd.gT(paramInt - 1, this.iVH.size() - (paramInt - 1));
          }
        }
        else
        {
          AppMethodBeat.o(26722);
          return bool;
        }
      }
      finally
      {
        AppMethodBeat.o(26722);
      }
      this.vyd.gT(paramInt, this.iVH.size() - paramInt);
      continue;
      label138:
      bool = false;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(26720);
    if (paramc != null) {}
    for (;;)
    {
      try
      {
        if (this.iVH != null)
        {
          this.iVH.add(paramc);
          a(paramc, true);
          return bool;
        }
      }
      finally
      {
        AppMethodBeat.o(26720);
      }
      bool = false;
    }
  }
  
  public final boolean ag(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
    AppMethodBeat.i(26746);
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
    boolean bool = gV(com.tencent.mm.plugin.wenote.b.c.ajU(localStringBuilder.toString()), i);
    AppMethodBeat.o(26746);
    return bool;
  }
  
  public final void ajM(String paramString)
  {
    AppMethodBeat.i(26728);
    if ((bo.isNullOrNil(paramString)) || (this.iVH == null))
    {
      AppMethodBeat.o(26728);
      return;
    }
    Object localObject = com.tencent.mm.plugin.wenote.b.b.ajP(paramString);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      for (;;)
      {
        try
        {
          ab.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, mHasInitDataListFinish :％B", new Object[] { Boolean.valueOf(this.vyi) });
          paramString = aw.RO();
          localObject = new c.2(this, (ArrayList)localObject);
          if (!this.vyi) {
            continue;
          }
          l = 500L;
          paramString.o((Runnable)localObject, l);
        }
        catch (Exception paramString)
        {
          long l;
          ab.e("MicroMsg.Note.NoteDataManager", "updateDataByHtml exception,%s", new Object[] { paramString.toString() });
          continue;
        }
        finally
        {
          AppMethodBeat.o(26728);
        }
        AppMethodBeat.o(26728);
        return;
        l = 1000L;
      }
    }
    AppMethodBeat.o(26728);
  }
  
  public final acq ajN(String paramString)
  {
    AppMethodBeat.i(26740);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
      AppMethodBeat.o(26740);
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
        if (i >= this.iVH.size()) {
          break label794;
        }
        localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i);
        if (bo.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).mBq)) {
          ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).mBq = com.tencent.mm.plugin.wenote.model.f.ajF(localObject1.toString());
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
            ((i)localObject2).mBq = ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).mBq;
            ((i)localObject2).vxr = "-1";
            ((i)localObject2).type = 1;
            ((i)localObject2).vxq = null;
            localArrayList.add(localObject2);
          }
        }
      }
      finally
      {
        AppMethodBeat.o(26740);
      }
      if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() >= -1)
      {
        if (((((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 6) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 4)) && (bo.isNullOrNil(((o)localObject1).cBD)))
        {
          localObject2 = new aca();
          ((aca)localObject2).anD(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).mBq);
          ((aca)localObject2).anA(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).dhR());
          localObject2 = com.tencent.mm.plugin.wenote.model.f.o((aca)localObject2);
          if (com.tencent.mm.vfs.e.cN((String)localObject2))
          {
            ab.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType()) });
            ((o)localObject1).cBD = ((String)localObject2);
          }
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() != 1)
        {
          localArrayList.add((o)localObject1);
        }
        else
        {
          localObject1 = (i)localObject1;
          if (bo.isNullOrNil(((i)localObject1).content))
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
              ((i)localObject2).mBq = ((i)localObject1).mBq;
              ((i)localObject2).vxr = ((i)localObject1).vxr;
              ((i)localObject2).type = ((i)localObject1).type;
              ((i)localObject2).vxq = null;
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
            while ((i + 1 < this.iVH.size()) && (((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i + 1)).getType() == 1) && (!bo.isNullOrNil(((i)this.iVH.get(i + 1)).content)))
            {
              localObject1 = new StringBuilder();
              localObject2 = (i)localArrayList.get(localArrayList.size() - 1);
              ((i)localObject2).content += "<br/>";
              break;
              localObject2 = new i();
              ((i)localObject2).content = ((i)localObject1).content;
              ((i)localObject2).mBq = ((i)localObject1).mBq;
              ((i)localObject2).vxr = ((i)localObject1).vxr;
              ((i)localObject2).type = ((i)localObject1).type;
              ((i)localObject2).vxq = null;
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
                    ((com.tencent.mm.vfs.b)localObject3).createNewFile();
                    if ((i != 0) || (com.tencent.mm.vfs.e.b((String)localObject2, paramString, paramString.length) != 0)) {
                      break;
                    }
                    this.vye.anE((String)localObject2);
                    ab.i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
                    paramString = com.tencent.mm.plugin.wenote.model.d.a((String)localObject1, localArrayList, this.vye);
                    AppMethodBeat.o(26740);
                    return paramString;
                  }
                  catch (IOException paramString)
                  {
                    ab.printErrStackTrace("MicroMsg.Note.NoteDataManager", paramString, "", new Object[0]);
                    AppMethodBeat.o(26740);
                    return null;
                  }
                  paramString = paramString;
                  ab.printErrStackTrace("MicroMsg.Note.NoteDataManager", paramString, "", new Object[0]);
                  ab.e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
                  i = 1;
                  paramString = null;
                }
              }
              this.vye.MI(8);
              this.vye.anN("WeNoteHtmlFile");
              this.vye.pz(true);
              this.vye.anA(".htm");
              this.vye.anD(com.tencent.mm.plugin.wenote.model.f.ajF(this.vye.toString()));
              localObject2 = com.tencent.mm.plugin.wenote.model.f.o(this.vye);
              ab.i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", new Object[] { localObject2 });
              localObject3 = new com.tencent.mm.vfs.b((String)localObject2);
              if (((com.tencent.mm.vfs.b)localObject3).exists()) {
                ((com.tencent.mm.vfs.b)localObject3).delete();
              }
              if (!((com.tencent.mm.vfs.b)localObject3).exists()) {}
              ab.i("MicroMsg.Note.NoteDataManager", "writefile error,return");
              Toast.makeText(ah.getContext(), ah.getContext().getString(2131299818), 1).show();
              AppMethodBeat.o(26740);
              return null;
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public final String ajO(String paramString)
  {
    AppMethodBeat.i(26750);
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
        if (this.iVH == null) {
          break label202;
        }
        i = 0;
        if (i >= this.iVH.size()) {
          break label229;
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i)).getType() != 1) {
          break label196;
        }
        localObject = com.tencent.mm.plugin.wenote.b.b.ajQ(((i)this.iVH.get(i)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
        if (bo.isNullOrNil((String)localObject)) {
          break label196;
        }
        localObject = ((String)localObject).split("\n");
        j = 0;
        if (j >= localObject.length) {
          break label188;
        }
        if (bo.isNullOrNil(localObject[j].trim())) {
          break label222;
        }
        localObject = localObject[j];
        j = 1;
      }
      finally
      {
        AppMethodBeat.o(26750);
      }
      Object localObject = paramString;
      if (paramString.length() > 1000) {
        localObject = paramString.substring(0, 1000);
      }
      AppMethodBeat.o(26750);
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
  
  public final boolean av(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(26724);
    boolean bool1 = bool2;
    for (;;)
    {
      try
      {
        if (this.iVH != null)
        {
          bool1 = bool2;
          if (paramInt >= 0)
          {
            bool1 = bool2;
            if (paramInt < this.iVH.size())
            {
              a((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(paramInt), false);
              this.iVH.remove(paramInt);
              bool1 = true;
            }
          }
        }
        if ((bool1) && (paramBoolean) && (this.vyd != null))
        {
          this.vyd.Le(paramInt);
          if (paramInt > 0) {
            this.vyd.gT(paramInt - 1, this.iVH.size() - (paramInt - 1));
          }
        }
        else
        {
          AppMethodBeat.o(26724);
          return bool1;
        }
      }
      finally
      {
        AppMethodBeat.o(26724);
      }
      this.vyd.gT(paramInt, this.iVH.size() - paramInt);
    }
  }
  
  public final void aw(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(26730);
    for (;;)
    {
      try
      {
        if (this.iVH == null) {
          return;
        }
        if ((paramInt >= 0) && (paramInt < this.iVH.size()))
        {
          localc = (com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(paramInt);
          if ((localc != null) && (localc.vxd != paramBoolean))
          {
            localc.vxd = paramBoolean;
            if (this.vyd != null) {
              this.vyd.Lc(paramInt);
            }
          }
          return;
        }
        if (paramInt != -1) {
          continue;
        }
        paramInt = 0;
        if (paramInt >= this.iVH.size()) {
          continue;
        }
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(paramInt);
        if ((localc != null) && (localc.vxd != paramBoolean))
        {
          localc.vxd = paramBoolean;
          if (this.vyd != null) {
            this.vyd.Lc(paramInt);
          }
        }
      }
      finally
      {
        AppMethodBeat.o(26730);
      }
      paramInt += 1;
    }
  }
  
  public final void ax(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(26734);
    for (;;)
    {
      int i;
      try
      {
        if ((this.iVH == null) || (paramInt < 0) || (paramInt >= this.iVH.size())) {
          return;
        }
        i = 0;
        if (i < this.iVH.size()) {
          if (i == paramInt)
          {
            ((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i)).vwW = true;
            ((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i)).vxc = paramBoolean;
          }
          else
          {
            ((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i)).vwW = false;
            ((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i)).vxc = false;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(26734);
      }
      AppMethodBeat.o(26734);
      return;
      i += 1;
    }
  }
  
  public final boolean d(int paramInt, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
    AppMethodBeat.i(26721);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      AppMethodBeat.o(26721);
      return false;
    }
    for (;;)
    {
      int k;
      int m;
      try
      {
        if (this.iVH == null) {
          break label174;
        }
        k = 0;
        j = 0;
        i = paramInt;
        paramInt = j;
        if ((k >= paramArrayList.size()) || (i < 0) || (i > this.iVH.size())) {
          break label203;
        }
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(k);
        j = paramInt;
        m = i;
        if (localc == null) {
          break label188;
        }
        b(localc);
        this.iVH.add(i, localc);
        j = paramInt + 1;
        m = i + 1;
        a(localc, true);
      }
      finally
      {
        AppMethodBeat.o(26721);
      }
      if ((bool) && (this.vyd != null)) {
        this.vyd.gS(i - paramInt, paramInt);
      }
      AppMethodBeat.o(26721);
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
  
  public final void dio()
  {
    AppMethodBeat.i(26729);
    if (this.iVH != null) {}
    for (int i = this.iVH.size();; i = 0)
    {
      ab.i("MicroMsg.Note.NoteDataManager", "clear mDataList, size:%d", new Object[] { Integer.valueOf(i) });
      try
      {
        if (this.iVH != null) {
          this.iVH.clear();
        }
        this.vyh = 0;
        this.vyg = 0;
        AppMethodBeat.o(26729);
        return;
      }
      finally
      {
        AppMethodBeat.o(26729);
      }
    }
  }
  
  public final int dip()
  {
    AppMethodBeat.i(26731);
    for (;;)
    {
      try
      {
        if (this.iVH != null)
        {
          i = 0;
          if (i < this.iVH.size())
          {
            if (((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i)).vwW) {
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
        AppMethodBeat.o(26731);
      }
    }
  }
  
  public final void diq()
  {
    AppMethodBeat.i(26732);
    try
    {
      if (this.iVH != null)
      {
        Iterator localIterator = this.iVH.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
          localc.vwW = false;
          localc.vxc = false;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(26732);
    }
    AppMethodBeat.o(26732);
  }
  
  public final int dis()
  {
    AppMethodBeat.i(26735);
    for (;;)
    {
      try
      {
        if (this.iVH != null)
        {
          i = 0;
          if (i < this.iVH.size())
          {
            if ((((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i)).getType() == 4) && (((l)this.iVH.get(i)).vxk.booleanValue())) {
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
        AppMethodBeat.o(26735);
      }
    }
  }
  
  public final String dit()
  {
    AppMethodBeat.i(26736);
    for (;;)
    {
      try
      {
        if ((this.vyf != 0) || (this.iVH == null)) {
          break;
        }
        Iterator localIterator = this.iVH.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        o localo = (o)localIterator.next();
        if (localo.vxr.startsWith("WeNote_"))
        {
          i = bo.getInt(localo.vxr.substring(7), -1);
          if (i > this.vyf) {
            this.vyf = i;
          } else {
            i = this.vyf;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(26736);
      }
    }
    Object localObject2 = new StringBuilder("WeNote_");
    int i = this.vyf + 1;
    this.vyf = i;
    localObject2 = i;
    AppMethodBeat.o(26736);
    return localObject2;
  }
  
  public final String div()
  {
    AppMethodBeat.i(26738);
    Object localObject1 = "";
    for (;;)
    {
      int i;
      try
      {
        if ((this.iVH == null) || (this.iVH.size() <= 0)) {
          return "";
        }
        i = 0;
        Object localObject3;
        if (i < this.iVH.size()) {
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i);
        }
        switch (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType())
        {
        case 1: 
          localObject3 = (i)localObject3;
          if (bo.isNullOrNil(((i)localObject3).content))
          {
            localObject1 = (String)localObject1 + "<br/>";
          }
          else
          {
            localObject3 = (String)localObject1 + ((i)localObject3).content;
            localObject1 = localObject3;
            if (i + 1 < this.iVH.size())
            {
              localObject1 = localObject3;
              if (((com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i + 1)).getType() == 1)
              {
                localObject1 = localObject3;
                if (!bo.isNullOrNil(((i)this.iVH.get(i + 1)).content)) {
                  localObject1 = (String)localObject3 + "<br/>";
                }
              }
            }
          }
          break;
        case 2: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.f)localObject3;
          localObject1 = (String)localObject1 + ed(((com.tencent.mm.plugin.wenote.model.a.f)localObject3).vxr, 2);
          break;
        case 6: 
          localObject3 = (k)localObject3;
          localObject1 = (String)localObject1 + ed(((k)localObject3).vxr, 6);
          break;
        case 20: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.b)localObject3;
          localObject1 = (String)localObject1 + ed(((com.tencent.mm.plugin.wenote.model.a.b)localObject3).vxr, 20);
          break;
        case 4: 
          localObject3 = (l)localObject3;
          localObject1 = (String)localObject1 + ed(((l)localObject3).vxr, ((l)localObject3).getType());
          break;
        case 3: 
          localObject3 = (g)localObject3;
          localObject1 = (String)localObject1 + ed(((g)localObject3).vxr, 3);
          break;
        case 5: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.d)localObject3;
          localObject1 = (String)localObject1 + ed(((com.tencent.mm.plugin.wenote.model.a.d)localObject3).vxr, 5);
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
        AppMethodBeat.o(26738);
      }
      i += 1;
    }
  }
  
  public final ArrayList<com.tencent.mm.plugin.wenote.model.a.c> diw()
  {
    AppMethodBeat.i(26745);
    if (this.iVH == null)
    {
      AppMethodBeat.o(26745);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.iVH.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(com.tencent.mm.plugin.wenote.b.c.c((com.tencent.mm.plugin.wenote.model.a.c)localIterator.next()));
      }
    }
    finally
    {
      AppMethodBeat.o(26745);
    }
    AppMethodBeat.o(26745);
    return localArrayList1;
  }
  
  public final void dix()
  {
    AppMethodBeat.i(26747);
    aw.RO().ac(new c.3(this));
    AppMethodBeat.o(26747);
  }
  
  public final int diy()
  {
    AppMethodBeat.i(26751);
    try
    {
      if (this.iVH == null) {
        return -1;
      }
      int i = 0;
      while (i < this.iVH.size())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i);
        if ((localc != null) && (localc.getType() != -3) && (localc.getType() != -2)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    finally
    {
      AppMethodBeat.o(26751);
    }
  }
  
  public final int diz()
  {
    AppMethodBeat.i(26752);
    try
    {
      if (this.iVH == null) {
        return -1;
      }
      int i = this.iVH.size() - 1;
      while (i >= 0)
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(i);
        if ((localc != null) && (localc.getType() != -3) && (localc.getType() != -2)) {
          return i;
        }
        i -= 1;
      }
      return -1;
    }
    finally
    {
      AppMethodBeat.o(26752);
    }
  }
  
  public final boolean gV(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (paramInt2 < 0) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (this.vyg + paramInt1 > 16384)) {}
        while ((j != 0) && (this.vyh + paramInt2 > 30)) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final void gW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26749);
    ab.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.TRUE });
    for (;;)
    {
      Object localObject3;
      int i;
      Spanned localSpanned2;
      try
      {
        if (this.iVH == null) {
          return;
        }
        int j = paramInt1;
        if (paramInt1 <= 0) {
          j = 0;
        }
        if (paramInt2 < this.iVH.size()) {
          break label487;
        }
        paramInt2 = this.iVH.size() - 1;
        paramInt1 = -1;
        if (paramInt2 <= j) {
          break label443;
        }
        Object localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(paramInt2);
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.c)this.iVH.get(paramInt2 - 1);
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
        if (bo.isNullOrNil(((i)localObject1).content)) {
          break label414;
        }
        Spanned localSpanned1 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ajK(((i)localObject1).content);
        localSpanned2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ajK(((i)localObject3).content);
        ((i)localObject3).content = (((i)localObject3).content + "<br/>" + ((i)localObject1).content);
        if (((i)localObject1).vwW)
        {
          ((i)localObject3).vwW = true;
          ((i)localObject3).vxc = false;
          if ((((i)localObject1).vwY == -1) || (((i)localObject1).vwY >= localSpanned1.length()))
          {
            ((i)localObject3).vwY = -1;
            ab.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem remove position: %d", new Object[] { Integer.valueOf(paramInt2) });
            Lk(paramInt2);
            i = paramInt1;
            if (this.vyd == null) {
              break label492;
            }
            this.vyd.Le(paramInt2);
            i = paramInt1;
            break label492;
          }
          i = localSpanned2.length();
          ((i)localObject1).vwY += i + 1;
          continue;
        }
        if (!((i)localObject3).vwW) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(26749);
      }
      if (((i)localObject3).vwY == -1)
      {
        ((i)localObject3).vwY = localSpanned2.length();
        continue;
        label414:
        if (localObject2.vwW)
        {
          ((i)localObject3).vwW = true;
          ((i)localObject3).vxc = false;
          ((i)localObject3).vwY = -1;
          continue;
          label443:
          if ((paramInt1 != -1) && (this.vyd != null)) {
            this.vyd.gT(paramInt1, this.iVH.size() - paramInt1);
          }
          dix();
          AppMethodBeat.o(26749);
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
    AppMethodBeat.i(26718);
    if (this.iVH != null)
    {
      int i = this.iVH.size();
      AppMethodBeat.o(26718);
      return i;
    }
    AppMethodBeat.o(26718);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.c
 * JD-Core Version:    0.7.0.1
 */