package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static volatile c rHv = null;
  public ArrayList<com.tencent.mm.plugin.wenote.model.a.c> hka = null;
  public int rHA = 0;
  public boolean rHB = false;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a rHw = null;
  public xv rHx = null;
  public int rHy = 0;
  public int rHz = 0;
  
  private boolean Dr(int paramInt)
  {
    if ((this.hka != null) && (paramInt >= 0) && (paramInt < this.hka.size()))
    {
      a((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(paramInt), false);
      this.hka.remove(paramInt);
      return true;
    }
    return false;
  }
  
  private void a(com.tencent.mm.plugin.wenote.model.a.c paramc, boolean paramBoolean)
  {
    if (paramc == null) {
      return;
    }
    if (paramc.getType() == 1)
    {
      int i = com.tencent.mm.plugin.wenote.b.c.UE(((i)paramc).content);
      if (paramBoolean)
      {
        this.rHz = (i + this.rHz);
        return;
      }
      this.rHz -= i;
      return;
    }
    if (paramBoolean)
    {
      this.rHA += 1;
      return;
    }
    this.rHA -= 1;
  }
  
  private void b(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    if (paramc == null) {}
    for (;;)
    {
      return;
      o localo1 = (o)paramc;
      Object localObject;
      if (localo1.getType() > 1)
      {
        if (bk.bl(localo1.rGI))
        {
          if ((this.rHy == 0) && (this.hka != null))
          {
            localObject = this.hka.iterator();
            while (((Iterator)localObject).hasNext())
            {
              o localo2 = (o)((Iterator)localObject).next();
              if (localo2.rGI.startsWith("WeNote_"))
              {
                i = bk.getInt(localo2.rGI.substring(7), -1);
                if (i > this.rHy) {}
                for (;;)
                {
                  this.rHy = i;
                  break;
                  i = this.rHy;
                }
              }
            }
          }
          localObject = new StringBuilder("WeNote_");
          int i = this.rHy + 1;
          this.rHy = i;
          localo1.rGI = i;
        }
        localObject = com.tencent.mm.plugin.wenote.model.c.chu().rFh;
        if (localObject != null) {
          break label217;
        }
        y.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", new Object[] { paramc.toString() });
      }
      while (bk.bl(paramc.kgC))
      {
        paramc.kgC = com.tencent.mm.plugin.wenote.model.f.Ur(paramc.toString());
        return;
        label217:
        if (((com.tencent.mm.plugin.wenote.model.d)localObject).rFn == null) {
          y.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", new Object[] { paramc.toString() });
        } else {
          ((com.tencent.mm.plugin.wenote.model.d)localObject).rFn.put(localo1.rGI, localo1);
        }
      }
    }
  }
  
  private boolean b(int paramInt, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    if ((paramc != null) && (this.hka != null) && (paramInt >= 0) && (paramInt <= this.hka.size()))
    {
      this.hka.add(paramInt, paramc);
      a(paramc, true);
      return true;
    }
    return false;
  }
  
  public static c chX()
  {
    if (rHv == null) {}
    try
    {
      if (rHv == null) {
        rHv = new c();
      }
      return rHv;
    }
    finally {}
  }
  
  private void cib()
  {
    if (this.hka != null)
    {
      Iterator localIterator = this.hka.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        localc.rGn = false;
        localc.rGt = false;
      }
    }
  }
  
  private static String dc(String paramString, int paramInt)
  {
    return String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[] { Integer.valueOf(paramInt), paramString, paramString });
  }
  
  public final com.tencent.mm.plugin.wenote.model.a.c Dq(int paramInt)
  {
    if ((this.hka != null) && (paramInt >= 0) && (paramInt < this.hka.size())) {
      return (com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(paramInt);
    }
    return null;
  }
  
  public final yj Uy(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
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
        if (i >= this.hka.size()) {
          break label772;
        }
        localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i);
        if (bk.bl(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).kgC)) {
          ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).kgC = com.tencent.mm.plugin.wenote.model.f.Ur(localObject1.toString());
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
            ((i)localObject2).kgC = ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).kgC;
            ((i)localObject2).rGI = "-1";
            ((i)localObject2).type = 1;
            ((i)localObject2).rGH = null;
            localArrayList.add(localObject2);
          }
        }
      }
      finally {}
      if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() >= -1)
      {
        if (((((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 6) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 4)) && (bk.bl(((o)localObject1).bTY)))
        {
          localObject2 = new xv();
          ((xv)localObject2).XH(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).kgC);
          ((xv)localObject2).XE(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).chB());
          localObject2 = com.tencent.mm.plugin.wenote.model.f.o((xv)localObject2);
          if (com.tencent.mm.vfs.e.bK((String)localObject2))
          {
            y.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType()) });
            ((o)localObject1).bTY = ((String)localObject2);
          }
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() != 1)
        {
          localArrayList.add((o)localObject1);
        }
        else
        {
          localObject1 = (i)localObject1;
          if (bk.bl(((i)localObject1).content))
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
              ((i)localObject2).kgC = ((i)localObject1).kgC;
              ((i)localObject2).rGI = ((i)localObject1).rGI;
              ((i)localObject2).type = ((i)localObject1).type;
              ((i)localObject2).rGH = null;
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
            while ((i + 1 < this.hka.size()) && (((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i + 1)).getType() == 1) && (!bk.bl(((i)this.hka.get(i + 1)).content)))
            {
              localObject1 = new StringBuilder();
              localObject2 = (i)localArrayList.get(localArrayList.size() - 1);
              ((i)localObject2).content += "<br/>";
              break;
              localObject2 = new i();
              ((i)localObject2).content = ((i)localObject1).content;
              ((i)localObject2).kgC = ((i)localObject1).kgC;
              ((i)localObject2).rGI = ((i)localObject1).rGI;
              ((i)localObject2).type = ((i)localObject1).type;
              ((i)localObject2).rGH = null;
              localArrayList.add(localObject2);
              continue;
              label772:
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
                    this.rHx.XI((String)localObject2);
                    y.i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
                    return com.tencent.mm.plugin.wenote.model.d.a((String)localObject1, localArrayList, this.rHx);
                  }
                  catch (IOException paramString)
                  {
                    y.printErrStackTrace("MicroMsg.Note.NoteDataManager", paramString, "", new Object[0]);
                    return null;
                  }
                  paramString = paramString;
                  y.printErrStackTrace("MicroMsg.Note.NoteDataManager", paramString, "", new Object[0]);
                  y.e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
                  i = 1;
                  paramString = null;
                }
              }
              this.rHx.EH(8);
              this.rHx.XR("WeNoteHtmlFile");
              this.rHx.mk(true);
              this.rHx.XE(".htm");
              this.rHx.XH(com.tencent.mm.plugin.wenote.model.f.Ur(this.rHx.toString()));
              localObject2 = com.tencent.mm.plugin.wenote.model.f.o(this.rHx);
              y.i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", new Object[] { localObject2 });
              localObject3 = new com.tencent.mm.vfs.b((String)localObject2);
              if (((com.tencent.mm.vfs.b)localObject3).exists()) {
                ((com.tencent.mm.vfs.b)localObject3).delete();
              }
              if (!((com.tencent.mm.vfs.b)localObject3).exists()) {}
              y.i("MicroMsg.Note.NoteDataManager", "writefile error,return");
              Toast.makeText(ae.getContext(), ae.getContext().getString(R.l.favorite_save_fail), 1).show();
              return null;
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public final String Uz(String paramString)
  {
    label169:
    label177:
    label183:
    label186:
    label193:
    label203:
    label210:
    for (;;)
    {
      int i;
      try
      {
        if (this.hka == null) {
          break label183;
        }
        i = 0;
        if (i >= this.hka.size()) {
          break label210;
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i)).getType() != 1) {
          break label177;
        }
        localObject = com.tencent.mm.plugin.wenote.b.b.UB(((i)this.hka.get(i)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
        if (bk.bl((String)localObject)) {
          break label177;
        }
        localObject = ((String)localObject).split("\n");
        j = 0;
        if (j >= localObject.length) {
          break label169;
        }
        if (bk.bl(localObject[j].trim())) {
          break label203;
        }
        localObject = localObject[j];
        j = 1;
      }
      finally {}
      Object localObject = paramString;
      if (paramString.length() > 1000) {
        localObject = paramString.substring(0, 1000);
      }
      return localObject;
      int j = 0;
      localObject = paramString;
      break label186;
      localObject = paramString;
      break label193;
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
  
  public final int a(com.tencent.mm.plugin.wenote.model.a.c paramc, WXRTEditText paramWXRTEditText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramc == null) {
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramc);
    return a(localArrayList, paramWXRTEditText, true, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public final int a(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.hka == null) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt4 < paramInt3))
    {
      y.e("MicroMsg.Note.NoteDataManager", "pasteItemList,error,return");
      return -1;
    }
    if (com.tencent.mm.plugin.wenote.model.c.chu().rFh == null)
    {
      y.e("MicroMsg.Note.NoteDataManager", "pasteItemList, but get wnnote base is null, return");
      return -1;
    }
    Object localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(paramArrayList.size() - 1);
    if (localObject1 == null)
    {
      y.e("MicroMsg.Note.NoteDataManager", "pasteItemList, lastInsertItem is null");
      return -1;
    }
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).rGp = -1;
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).rGn = true;
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).rGt = false;
    Object localObject3 = Dq(paramInt2);
    if (localObject3 == null)
    {
      y.e("MicroMsg.Note.NoteDataManager", "pasteItemList, item is null");
      return -1;
    }
    for (;;)
    {
      label457:
      label462:
      int j;
      int i;
      try
      {
        cib();
        if ((paramInt1 != 0) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType() != 1)) {
          break label848;
        }
        Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Uw(((i)localObject3).content);
        if ((localObject2 == null) || (paramInt3 > ((Spanned)localObject2).length()) || (paramInt4 > ((Spanned)localObject2).length()))
        {
          if (localObject2 == null)
          {
            paramInt1 = -1;
            y.e("MicroMsg.Note.NoteDataManager", "pasteItemList error, oriText:%d  startOff:%d  endOff:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
        if (!bk.bl((String)localObject2))
        {
          if (!((String)localObject2).endsWith("<br/>")) {
            break label831;
          }
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
          ((i)localObject3).content = ((String)localObject2);
          paramInt2 += 1;
          paramInt1 = paramInt2;
          if (bk.bl((String)localObject1)) {
            break label834;
          }
          localObject3 = new i();
          ((i)localObject3).type = 1;
          localObject2 = localObject1;
          if (((String)localObject1).startsWith("<br/>")) {
            localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
          }
          ((i)localObject3).content = ((String)localObject2);
          ((i)localObject3).rGp = 0;
          ((i)localObject3).rGn = false;
          ((i)localObject3).rGt = false;
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
              break label828;
            }
            paramInt3 += 1;
            break label828;
          }
        }
        else
        {
          if (!bk.bl((String)localObject1))
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
          Dr(paramInt2);
          paramInt1 = paramInt2;
          if (this.rHw == null) {
            break label834;
          }
          this.rHw.Dl(paramInt2);
          paramInt1 = paramInt2;
          break label834;
          label605:
          paramArrayList = paramArrayList.iterator();
          paramInt2 = paramInt1;
          if (!paramArrayList.hasNext()) {
            break label863;
          }
          localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
          b((com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          if (!b(paramInt2, (com.tencent.mm.plugin.wenote.model.a.c)localObject1)) {
            break label820;
          }
          paramInt2 += 1;
          break label860;
        }
        if ((j - 1 >= 0) && (j - 1 < chX().size()))
        {
          paramInt1 = j - 1;
          if (this.rHw != null)
          {
            paramInt3 = j - i;
            paramInt2 = paramInt3;
            if (paramInt4 != 0) {
              paramInt2 = paramInt3 + 1;
            }
            if ((i >= 0) && (paramInt2 > 0)) {
              this.rHw.eM(i, paramInt2);
            }
            if (i <= 0) {
              break label792;
            }
            this.rHw.eN(i - 1, chX().size() - (i - 1));
            this.rHw.Dm(paramInt1);
          }
          cig();
          return paramInt1;
        }
      }
      finally {}
      paramInt1 = chX().size() - 1;
      continue;
      label792:
      if (i == 0)
      {
        this.rHw.eN(i, chX().size() - i);
        continue;
        label820:
        break label860;
        label828:
        label831:
        label834:
        label848:
        do
        {
          paramInt1 = paramInt2;
          break label605;
          break label462;
          break;
          paramInt4 = 0;
          paramInt2 = paramInt1;
          paramInt3 = paramInt1;
          paramInt1 = paramInt4;
          break label457;
        } while (paramInt1 == 1);
        paramInt1 = paramInt2 + 1;
        continue;
        label860:
        continue;
        label863:
        paramInt4 = 0;
        j = paramInt2;
        i = paramInt1;
      }
    }
  }
  
  public final int a(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, WXRTEditText paramWXRTEditText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.hka == null))
    {
      y.e("MicroMsg.Note.NoteDataManager", "insertItemList,error,return");
      return -1;
    }
    if (com.tencent.mm.plugin.wenote.model.c.chu().rFh == null)
    {
      y.e("MicroMsg.Note.NoteDataManager", "insertItemList, but get wnnote base is null, return");
      return -1;
    }
    if ((paramBoolean2) && (aa(paramArrayList)) && (this.rHw != null))
    {
      this.rHw.chH();
      return -1;
    }
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(paramArrayList.size() - 1);
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).rGp = -1;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).rGn = true;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).rGt = false;
      if ((paramWXRTEditText != null) && (paramWXRTEditText.rIz))
      {
        if (paramWXRTEditText.getEditTextType() != 2) {
          break label262;
        }
        ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).rGw = 2;
      }
    }
    label170:
    int n;
    int i;
    label259:
    label262:
    int i1;
    label391:
    label419:
    int k;
    int m;
    for (;;)
    {
      paramWXRTEditText.rIz = false;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).rGx = paramWXRTEditText.rGx;
      paramWXRTEditText.rGx = 0;
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getRecyclerItemPosition() != 0)) {
        if (paramWXRTEditText != null) {
          break label616;
        }
      }
      label503:
      Object localObject2;
      label584:
      label616:
      Object localObject3;
      try
      {
        n = size();
        cib();
        paramArrayList = paramArrayList.iterator();
        i = n;
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
            b(paramWXRTEditText);
            if ((paramWXRTEditText == null) || (this.hka == null)) {
              break label1230;
            }
            this.hka.add(paramWXRTEditText);
            a(paramWXRTEditText, true);
            j = 1;
            if (j == 0) {
              break label1236;
            }
            i += 1;
            continue;
            if (paramWXRTEditText.getEditTextType() != 1) {
              break;
            }
            ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).rGw = 1;
            break;
            if ((paramWXRTEditText.getEditTextType() == 2) || (paramWXRTEditText.getSelectionStart() != 0) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
              break label170;
            }
            i = ((com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(0)).getType();
            if ((i != 2) && (i != 6) && (i != 5) && (i != 3) && (i != 4)) {
              break label170;
            }
            localObject1 = new i();
            ((i)localObject1).content = "";
            ((i)localObject1).rGn = false;
            ((i)localObject1).rGt = false;
            paramArrayList.add(0, localObject1);
            break label170;
          }
        }
        i1 = 0;
        if ((i - 1 < 0) || (i - 1 >= chX().size())) {
          break;
        }
        j = i - 1;
        k = j;
        m = i;
        if (paramBoolean4)
        {
          j += 1;
          i += 1;
          cib();
          if (j >= chX().size()) {
            break label1125;
          }
          paramArrayList = chX().Dq(j);
          k = j;
          m = i;
          if (paramArrayList != null)
          {
            paramArrayList.rGp = 0;
            paramArrayList.rGn = true;
            paramArrayList.rGt = false;
            m = i;
            k = j;
          }
        }
        if (this.rHw != null)
        {
          j = m - n;
          i = j;
          if (i1 != 0) {
            i = j + 1;
          }
          if ((n >= 0) && (i > 0)) {
            this.rHw.eM(n, i);
          }
          if (n <= 0) {
            break label1179;
          }
          this.rHw.eN(n - 1, chX().size() - (n - 1));
          if (paramBoolean3) {
            this.rHw.chG();
          }
          this.rHw.Dm(k);
        }
        cig();
        return k;
      }
      finally {}
    }
    int j = paramWXRTEditText.getRecyclerItemPosition();
    localObject2 = Dq(j);
    if (localObject2 == null) {
      return -1;
    }
    cib();
    if ((paramWXRTEditText.getEditTextType() == 0) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() == 1))
    {
      localObject1 = paramWXRTEditText.getSelection();
      localObject3 = paramWXRTEditText.getText();
      paramWXRTEditText = ((Editable)localObject3).subSequence(0, ((e)localObject1).aiH);
      localObject3 = ((Editable)localObject3).subSequence(((e)localObject1).Eo, ((Editable)localObject3).length());
      localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)paramWXRTEditText);
      paramWXRTEditText = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject3);
      localObject2 = (i)localObject2;
      if (!bk.bl((String)localObject1))
      {
        if (((String)localObject1).endsWith("<br/>"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
          label765:
          ((i)localObject2).content = ((String)localObject1);
          j += 1;
          i = j;
          if (bk.bl(paramWXRTEditText)) {
            break label1249;
          }
          localObject2 = new i();
          ((i)localObject2).type = 1;
          localObject1 = paramWXRTEditText;
          if (paramWXRTEditText.startsWith("<br/>")) {
            localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
          }
          ((i)localObject2).content = ((String)localObject1);
          ((i)localObject2).rGp = 0;
          ((i)localObject2).rGn = false;
          ((i)localObject2).rGt = false;
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
          label881:
          paramArrayList = paramArrayList.iterator();
          m = i;
          label890:
          i = m;
          n = j;
          i1 = k;
          if (!paramArrayList.hasNext()) {
            break;
          }
          paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
          b(paramWXRTEditText);
          if (!b(m, paramWXRTEditText)) {
            break label1223;
          }
          i = m + 1;
          break label1239;
          if (bk.bl(paramWXRTEditText)) {
            break label1005;
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
        label1005:
        Dr(j);
        i = j;
        if (this.rHw == null) {
          break label1249;
        }
        this.rHw.Dl(j);
        i = j;
        break label1249;
      }
    }
    else if (paramWXRTEditText.getEditTextType() != 1)
    {
      j += 1;
      label1055:
      paramArrayList = paramArrayList.iterator();
      i = j;
    }
    label1125:
    label1259:
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
        b(paramWXRTEditText);
        if (!b(i, paramWXRTEditText)) {
          break label1217;
        }
        i += 1;
        break label1259;
        j = chX().size() - 1;
        break label419;
        paramArrayList = new i();
        paramArrayList.type = 1;
        paramArrayList.content = "";
        paramArrayList.rGp = 0;
        paramArrayList.rGn = true;
        paramArrayList.rGt = false;
        b(j, paramArrayList);
        k = j;
        m = i;
        break label503;
        if (n != 0) {
          break label584;
        }
        this.rHw.eN(n, chX().size() - n);
        break label584;
      }
      i1 = 0;
      n = j;
      break label391;
      break label1259;
      break label1055;
      i = m;
      break label1239;
      j = 0;
      break;
      break label259;
      m = i;
      break label890;
      break label765;
      j = i;
      k = 0;
      break label881;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.hka == null) {
          return;
        }
        if (i < this.hka.size())
        {
          if (!((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i)).chA().equals(paramString)) {
            break label114;
          }
          a((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i), false);
          this.hka.set(i, paramc);
          a(paramc, true);
          if ((i == -1) || (this.rHw == null)) {
            break label113;
          }
          this.rHw.Dj(i);
          return;
        }
      }
      finally {}
      i = -1;
      continue;
      label113:
      return;
      label114:
      i += 1;
    }
  }
  
  public final boolean a(int paramInt, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.hka == null) || (paramInt < 0) || (paramInt > this.hka.size())) {
          break label119;
        }
        this.hka.add(paramInt, paramc);
        a(paramc, true);
        if ((bool) && (this.rHw != null))
        {
          this.rHw.Dk(paramInt);
          if (paramInt > 0) {
            this.rHw.eN(paramInt - 1, this.hka.size() - (paramInt - 1));
          }
        }
        else
        {
          return bool;
        }
      }
      finally {}
      this.rHw.eN(paramInt, this.hka.size() - paramInt);
      return bool;
      label119:
      bool = false;
    }
  }
  
  public final boolean a(int paramInt, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
    boolean bool2;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      bool2 = false;
      return bool2;
    }
    for (;;)
    {
      int k;
      int m;
      try
      {
        if (this.hka == null) {
          break label162;
        }
        k = 0;
        j = 0;
        i = paramInt;
        paramInt = j;
        if ((k >= paramArrayList.size()) || (i < 0) || (i > this.hka.size())) {
          break label191;
        }
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(k);
        j = paramInt;
        m = i;
        if (localc == null) {
          break label176;
        }
        b(localc);
        this.hka.add(i, localc);
        j = paramInt + 1;
        m = i + 1;
        a(localc, true);
      }
      finally {}
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (this.rHw == null) {
        break;
      }
      this.rHw.eM(i - paramInt, paramInt);
      return bool1;
      label162:
      boolean bool1 = false;
      int j = 0;
      int i = paramInt;
      paramInt = j;
      continue;
      label176:
      k += 1;
      paramInt = j;
      i = m;
      continue;
      label191:
      bool1 = true;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    boolean bool = true;
    if (paramc != null) {}
    for (;;)
    {
      try
      {
        if (this.hka != null)
        {
          this.hka.add(paramc);
          a(paramc, true);
          return bool;
        }
      }
      finally {}
      bool = false;
    }
  }
  
  public final boolean aa(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList)
  {
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
    return eP(com.tencent.mm.plugin.wenote.b.c.UE(localStringBuilder.toString()), i);
  }
  
  public final boolean ag(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.hka != null)
      {
        bool1 = bool2;
        if (paramInt >= 0)
        {
          bool1 = bool2;
          if (paramInt < this.hka.size())
          {
            a((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(paramInt), false);
            this.hka.remove(paramInt);
            bool1 = true;
          }
        }
      }
      if ((bool1) && (paramBoolean) && (this.rHw != null))
      {
        this.rHw.Dl(paramInt);
        if (paramInt > 0) {
          this.rHw.eN(paramInt - 1, this.hka.size() - (paramInt - 1));
        }
      }
      else
      {
        return bool1;
      }
    }
    finally {}
    this.rHw.eN(paramInt, this.hka.size() - paramInt);
    return bool1;
  }
  
  public final void ah(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.hka == null) {
          return;
        }
        if ((paramInt >= 0) && (paramInt < this.hka.size()))
        {
          com.tencent.mm.plugin.wenote.model.a.c localc1 = (com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(paramInt);
          if ((localc1 != null) && (localc1.rGu != paramBoolean))
          {
            localc1.rGu = paramBoolean;
            if (this.rHw != null) {
              this.rHw.Dj(paramInt);
            }
          }
          return;
        }
      }
      finally {}
      if (paramInt == -1)
      {
        paramInt = 0;
        while (paramInt < this.hka.size())
        {
          com.tencent.mm.plugin.wenote.model.a.c localc2 = (com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(paramInt);
          if ((localc2 != null) && (localc2.rGu != paramBoolean))
          {
            localc2.rGu = paramBoolean;
            if (this.rHw != null) {
              this.rHw.Dj(paramInt);
            }
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public final void ai(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((this.hka != null) && (paramInt >= 0) && (paramInt < this.hka.size())) {
          break label119;
        }
        return;
      }
      finally {}
      if (i < this.hka.size())
      {
        if (i == paramInt)
        {
          ((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i)).rGn = true;
          ((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i)).rGt = paramBoolean;
        }
        else
        {
          ((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i)).rGn = false;
          ((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i)).rGt = false;
        }
      }
      else
      {
        return;
        label119:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public final void chY()
  {
    if (this.hka != null) {}
    for (int i = this.hka.size();; i = 0)
    {
      y.i("MicroMsg.Note.NoteDataManager", "clear mDataList, size:%d", new Object[] { Integer.valueOf(i) });
      try
      {
        if (this.hka != null) {
          this.hka.clear();
        }
        this.rHA = 0;
        this.rHz = 0;
        return;
      }
      finally {}
    }
  }
  
  public final int chZ()
  {
    for (;;)
    {
      try
      {
        if (this.hka != null)
        {
          i = 0;
          if (i < this.hka.size())
          {
            if (!((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i)).rGn) {
              break label53;
            }
            return i;
          }
        }
      }
      finally {}
      int i = -1;
      continue;
      label53:
      i += 1;
    }
  }
  
  public final void cia()
  {
    try
    {
      if (this.hka != null)
      {
        Iterator localIterator = this.hka.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
          localc.rGn = false;
          localc.rGt = false;
        }
      }
    }
    finally {}
  }
  
  public final int cic()
  {
    for (;;)
    {
      try
      {
        if (this.hka != null)
        {
          i = 0;
          if (i < this.hka.size())
          {
            if ((((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i)).getType() != 4) || (!((l)this.hka.get(i)).rGB.booleanValue())) {
              break label74;
            }
            return i;
          }
        }
      }
      finally {}
      int i = -1;
      continue;
      label74:
      i += 1;
    }
  }
  
  public final String cid()
  {
    for (;;)
    {
      try
      {
        if ((this.rHy != 0) || (this.hka == null)) {
          break;
        }
        Iterator localIterator = this.hka.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        o localo = (o)localIterator.next();
        if (localo.rGI.startsWith("WeNote_"))
        {
          i = bk.getInt(localo.rGI.substring(7), -1);
          if (i > this.rHy) {
            this.rHy = i;
          } else {
            i = this.rHy;
          }
        }
      }
      finally {}
    }
    Object localObject2 = new StringBuilder("WeNote_");
    int i = this.rHy + 1;
    this.rHy = i;
    localObject2 = i;
    return localObject2;
  }
  
  public final String cie()
  {
    Object localObject1 = "";
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        if ((this.hka != null) && (this.hka.size() > 0)) {
          break label530;
        }
        return "";
      }
      finally {}
      if (i < this.hka.size()) {
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i);
      }
      switch (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType())
      {
      case 1: 
        localObject3 = (i)localObject3;
        if (bk.bl(((i)localObject3).content))
        {
          localObject1 = (String)localObject1 + "<br/>";
        }
        else
        {
          localObject3 = (String)localObject1 + ((i)localObject3).content;
          localObject1 = localObject3;
          if (i + 1 < this.hka.size())
          {
            localObject1 = localObject3;
            if (((com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i + 1)).getType() == 1)
            {
              localObject1 = localObject3;
              if (!bk.bl(((i)this.hka.get(i + 1)).content)) {
                localObject1 = (String)localObject3 + "<br/>";
              }
            }
          }
        }
        break;
      case 2: 
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.f)localObject3;
        localObject1 = (String)localObject1 + dc(((com.tencent.mm.plugin.wenote.model.a.f)localObject3).rGI, 2);
        break;
      case 6: 
        localObject3 = (k)localObject3;
        localObject1 = (String)localObject1 + dc(((k)localObject3).rGI, 6);
        break;
      case 20: 
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.b)localObject3;
        localObject1 = (String)localObject1 + dc(((com.tencent.mm.plugin.wenote.model.a.b)localObject3).rGI, 20);
        break;
      case 4: 
        localObject3 = (l)localObject3;
        localObject1 = (String)localObject1 + dc(((l)localObject3).rGI, ((l)localObject3).getType());
        break;
      case 3: 
        localObject3 = (g)localObject3;
        localObject1 = (String)localObject1 + dc(((g)localObject3).rGI, 3);
        break;
      case 5: 
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.d)localObject3;
        localObject1 = (String)localObject1 + dc(((com.tencent.mm.plugin.wenote.model.a.d)localObject3).rGI, 5);
        break;
      case -1: 
        localObject1 = (String)localObject1 + "<hr/>";
        break label535;
        localObject1 = ((String)localObject1).replaceAll("\n", "<br/>");
        return localObject1;
        i = 0;
        break;
      default: 
        label530:
        label535:
        i += 1;
      }
    }
  }
  
  public final ArrayList<com.tencent.mm.plugin.wenote.model.a.c> cif()
  {
    if (this.hka == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.hka.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(com.tencent.mm.plugin.wenote.b.c.c((com.tencent.mm.plugin.wenote.model.a.c)localIterator.next()));
      }
    }
    finally {}
    return localArrayList1;
  }
  
  public final void cig()
  {
    au.DS().O(new c.3(this));
  }
  
  public final int cih()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.hka != null) {
          break label71;
        }
        return -1;
      }
      finally {}
      if (i < this.hka.size())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i);
        if ((localc != null) && (localc.getType() != -3) && (localc.getType() != -2)) {
          return i;
        }
      }
      else
      {
        return -1;
        label71:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public final int cii()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.hka == null) {
          return -1;
        }
        i = this.hka.size() - 1;
        if (i >= 0)
        {
          com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(i);
          if ((localc != null) && (localc.getType() != -3) && (localc.getType() != -2)) {
            return i;
          }
        }
        else
        {
          return -1;
        }
      }
      finally {}
      i -= 1;
    }
  }
  
  public final boolean eP(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (paramInt2 < 0) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (this.rHz + paramInt1 > 16384)) {}
        while ((j != 0) && (this.rHA + paramInt2 > 30)) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final void eQ(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(true) });
    try
    {
      if (this.hka != null) {
        break label459;
      }
      return;
    }
    finally {}
    if (paramInt2 >= this.hka.size())
    {
      paramInt2 = this.hka.size() - 1;
      paramInt1 = -1;
    }
    for (;;)
    {
      int j;
      int i;
      if (paramInt2 > j)
      {
        Object localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(paramInt2);
        Object localObject3 = (com.tencent.mm.plugin.wenote.model.a.c)this.hka.get(paramInt2 - 1);
        i = paramInt1;
        if (localObject1 != null)
        {
          i = paramInt1;
          if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 1)
          {
            i = paramInt1;
            if (localObject3 != null)
            {
              i = paramInt1;
              if (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType() == 1)
              {
                paramInt1 = paramInt2 - 1;
                localObject1 = (i)localObject1;
                localObject3 = (i)localObject3;
                Spanned localSpanned2;
                if (!bk.bl(((i)localObject1).content))
                {
                  Spanned localSpanned1 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Uw(((i)localObject1).content);
                  localSpanned2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Uw(((i)localObject3).content);
                  ((i)localObject3).content = (((i)localObject3).content + "<br/>" + ((i)localObject1).content);
                  if (((i)localObject1).rGn)
                  {
                    ((i)localObject3).rGn = true;
                    ((i)localObject3).rGt = false;
                    if ((((i)localObject1).rGp == -1) || (((i)localObject1).rGp >= localSpanned1.length())) {
                      ((i)localObject3).rGp = -1;
                    }
                  }
                }
                for (;;)
                {
                  y.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem remove position: %d", new Object[] { Integer.valueOf(paramInt2) });
                  Dr(paramInt2);
                  i = paramInt1;
                  if (this.rHw == null) {
                    break;
                  }
                  this.rHw.Dl(paramInt2);
                  i = paramInt1;
                  break;
                  i = localSpanned2.length();
                  ((i)localObject1).rGp += i + 1;
                  continue;
                  if ((((i)localObject3).rGn) && (((i)localObject3).rGp == -1))
                  {
                    ((i)localObject3).rGp = localSpanned2.length();
                    continue;
                    if (localObject2.rGn)
                    {
                      ((i)localObject3).rGn = true;
                      ((i)localObject3).rGt = false;
                      ((i)localObject3).rGp = -1;
                    }
                  }
                }
              }
            }
          }
        }
      }
      else
      {
        if ((paramInt1 != -1) && (this.rHw != null)) {
          this.rHw.eN(paramInt1, this.hka.size() - paramInt1);
        }
        cig();
        return;
        paramInt1 = -1;
        continue;
        label459:
        j = paramInt1;
        if (paramInt1 > 0) {
          break;
        }
        j = 0;
        break;
      }
      paramInt2 -= 1;
      paramInt1 = i;
    }
  }
  
  public final int size()
  {
    if (this.hka != null) {
      return this.hka.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.c
 * JD-Core Version:    0.7.0.1
 */