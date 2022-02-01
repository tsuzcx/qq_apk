package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static volatile c CVX = null;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a CVY = null;
  public boolean CVZ = false;
  public ArrayList<com.tencent.mm.plugin.wenote.model.a.c> ijj = null;
  public agx oQL = null;
  public int oQM = 0;
  public int oQN = 0;
  public int oQO = 0;
  
  private boolean AT(int paramInt)
  {
    AppMethodBeat.i(30418);
    if ((this.ijj != null) && (paramInt >= 0) && (paramInt < this.ijj.size()))
    {
      a((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(paramInt), false);
      this.ijj.remove(paramInt);
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
      int i = com.tencent.mm.plugin.wenote.c.c.Xf(((com.tencent.mm.plugin.wenote.model.a.i)paramc).content);
      if (paramBoolean)
      {
        this.oQN = (i + this.oQN);
        AppMethodBeat.o(30441);
        return;
      }
      this.oQN -= i;
      AppMethodBeat.o(30441);
      return;
    }
    if (paramBoolean)
    {
      this.oQO += 1;
      AppMethodBeat.o(30441);
      return;
    }
    this.oQO -= 1;
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
      if (bs.isNullOrNil(localo.oQi)) {
        localo.oQi = bZM();
      }
      locald = com.tencent.mm.plugin.wenote.model.c.eHP().CUG;
      if (locald != null) {
        break label105;
      }
      ac.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", new Object[] { paramc.toString() });
    }
    for (;;)
    {
      if (bs.isNullOrNil(paramc.dhw)) {
        paramc.dhw = com.tencent.mm.plugin.wenote.model.f.Xn(paramc.toString());
      }
      AppMethodBeat.o(30437);
      return;
      label105:
      if (locald.CUN == null) {
        ac.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", new Object[] { paramc.toString() });
      } else {
        locald.CUN.put(localo.oQi, localo);
      }
    }
  }
  
  private boolean b(int paramInt, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(30416);
    if ((paramc != null) && (this.ijj != null) && (paramInt >= 0) && (paramInt <= this.ijj.size()))
    {
      this.ijj.add(paramInt, paramc);
      a(paramc, true);
    }
    for (;;)
    {
      AppMethodBeat.o(30416);
      return bool;
      bool = false;
    }
  }
  
  private void bZJ()
  {
    AppMethodBeat.i(30426);
    if (this.ijj != null)
    {
      Iterator localIterator = this.ijj.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        localc.oPV = false;
        localc.oQb = false;
      }
    }
    AppMethodBeat.o(30426);
  }
  
  private String bZM()
  {
    AppMethodBeat.i(30430);
    if ((this.oQM == 0) && (this.ijj != null))
    {
      localObject = this.ijj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        o localo = (o)((Iterator)localObject).next();
        if (localo.oQi.startsWith("WeNote_"))
        {
          i = bs.getInt(localo.oQi.substring(7), -1);
          if (i > this.oQM) {}
          for (;;)
          {
            this.oQM = i;
            break;
            i = this.oQM;
          }
        }
      }
    }
    Object localObject = new StringBuilder("WeNote_");
    int i = this.oQM + 1;
    this.oQM = i;
    localObject = i;
    AppMethodBeat.o(30430);
    return localObject;
  }
  
  private static String cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(30432);
    paramString = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[] { Integer.valueOf(paramInt), paramString, paramString });
    AppMethodBeat.o(30432);
    return paramString;
  }
  
  public static c eIb()
  {
    AppMethodBeat.i(30410);
    if (CVX == null) {}
    try
    {
      if (CVX == null) {
        CVX = new c();
      }
      c localc = CVX;
      AppMethodBeat.o(30410);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(30410);
    }
  }
  
  public final void AU(int paramInt)
  {
    AppMethodBeat.i(30419);
    if (this.CVY != null) {
      this.CVY.AN(paramInt);
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
    boolean bool = fb(com.tencent.mm.plugin.wenote.c.c.Xf(localStringBuilder.toString()), i);
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
        if (this.ijj != null)
        {
          bool1 = bool2;
          if (paramInt >= 0)
          {
            bool1 = bool2;
            if (paramInt < this.ijj.size())
            {
              a((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(paramInt), false);
              this.ijj.remove(paramInt);
              bool1 = true;
            }
          }
        }
        if ((bool1) && (paramBoolean) && (this.CVY != null))
        {
          this.CVY.AP(paramInt);
          if (paramInt > 0) {
            this.CVY.eZ(paramInt - 1, this.ijj.size() - (paramInt - 1));
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
      this.CVY.eZ(paramInt, this.ijj.size() - paramInt);
    }
  }
  
  public final com.tencent.mm.plugin.wenote.model.a.c Wh(int paramInt)
  {
    AppMethodBeat.i(30412);
    if ((this.ijj != null) && (paramInt >= 0) && (paramInt < this.ijj.size()))
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(paramInt);
      AppMethodBeat.o(30412);
      return localc;
    }
    AppMethodBeat.o(30412);
    return null;
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30423);
    for (;;)
    {
      try
      {
        if (this.ijj == null) {
          return;
        }
        if ((paramInt >= 0) && (paramInt < this.ijj.size()))
        {
          localc = (com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(paramInt);
          if ((localc != null) && (localc.oQc != paramBoolean))
          {
            localc.oQc = paramBoolean;
            if (this.CVY != null) {
              this.CVY.AN(paramInt);
            }
          }
          return;
        }
        if (paramInt != -1) {
          continue;
        }
        paramInt = 0;
        if (paramInt >= this.ijj.size()) {
          continue;
        }
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(paramInt);
        if ((localc != null) && (localc.oQc != paramBoolean))
        {
          localc.oQc = paramBoolean;
          if (this.CVY != null) {
            this.CVY.AN(paramInt);
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
  
  public final ahn Xq(String paramString)
  {
    AppMethodBeat.i(30433);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
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
        if (i >= this.ijj.size()) {
          break label794;
        }
        localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i);
        if (bs.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).dhw)) {
          ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).dhw = com.tencent.mm.plugin.wenote.model.f.Xn(localObject1.toString());
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
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).dhw = ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).dhw;
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oQi = "-1";
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).type = 1;
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oQh = null;
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
        if (((((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 6) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() == 4)) && (bs.isNullOrNil(((o)localObject1).dpK)))
        {
          localObject2 = new agx();
          ((agx)localObject2).aIP(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).dhw);
          ((agx)localObject2).aIM(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).bZx());
          localObject2 = com.tencent.mm.plugin.wenote.model.f.b((agx)localObject2);
          if (com.tencent.mm.vfs.i.eA((String)localObject2))
          {
            ac.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType()) });
            ((o)localObject1).dpK = ((String)localObject2);
          }
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject1).getType() != 1)
        {
          localArrayList.add((o)localObject1);
        }
        else
        {
          localObject1 = (com.tencent.mm.plugin.wenote.model.a.i)localObject1;
          if (bs.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content))
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
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).dhw = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).dhw;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oQi = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).oQi;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).type = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).type;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oQh = null;
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
            while ((i + 1 < this.ijj.size()) && (((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i + 1)).getType() == 1) && (!bs.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i)this.ijj.get(i + 1)).content)))
            {
              localObject1 = new StringBuilder();
              localObject2 = (com.tencent.mm.plugin.wenote.model.a.i)localArrayList.get(localArrayList.size() - 1);
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content += "<br/>";
              break;
              localObject2 = new com.tencent.mm.plugin.wenote.model.a.i();
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).dhw = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).dhw;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oQi = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).oQi;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).type = ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).type;
              ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oQh = null;
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
                    this.oQL.aIQ((String)localObject2);
                    ac.i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
                    paramString = com.tencent.mm.plugin.wenote.model.d.a((String)localObject1, localArrayList, this.oQL);
                    AppMethodBeat.o(30433);
                    return paramString;
                  }
                  catch (IOException paramString)
                  {
                    ac.printErrStackTrace("MicroMsg.Note.NoteDataManager", paramString, "", new Object[0]);
                    AppMethodBeat.o(30433);
                    return null;
                  }
                  paramString = paramString;
                  ac.printErrStackTrace("MicroMsg.Note.NoteDataManager", paramString, "", new Object[0]);
                  ac.e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
                  i = 1;
                  paramString = null;
                }
              }
              this.oQL.XM(8);
              this.oQL.aIZ("WeNoteHtmlFile");
              this.oQL.vz(true);
              this.oQL.aIM(".htm");
              this.oQL.aIP(com.tencent.mm.plugin.wenote.model.f.Xn(this.oQL.toString()));
              localObject2 = com.tencent.mm.plugin.wenote.model.f.b(this.oQL);
              ac.i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", new Object[] { localObject2 });
              localObject3 = new com.tencent.mm.vfs.e((String)localObject2);
              if (((com.tencent.mm.vfs.e)localObject3).exists()) {
                ((com.tencent.mm.vfs.e)localObject3).delete();
              }
              if (!((com.tencent.mm.vfs.e)localObject3).exists()) {}
              ac.i("MicroMsg.Note.NoteDataManager", "writefile error,return");
              Toast.makeText(ai.getContext(), ai.getContext().getString(2131758993), 1).show();
              AppMethodBeat.o(30433);
              return null;
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public final void Y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30427);
    for (;;)
    {
      int i;
      try
      {
        if ((this.ijj == null) || (paramInt < 0) || (paramInt >= this.ijj.size())) {
          return;
        }
        i = 0;
        if (i < this.ijj.size()) {
          if (i == paramInt)
          {
            ((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i)).oPV = true;
            ((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i)).oQb = paramBoolean;
          }
          else
          {
            ((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i)).oPV = false;
            ((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i)).oQb = false;
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
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.ijj == null) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt4 < paramInt3))
    {
      ac.e("MicroMsg.Note.NoteDataManager", "pasteItemList,error,return");
      AppMethodBeat.o(30436);
      return -1;
    }
    if (com.tencent.mm.plugin.wenote.model.c.eHP().CUG == null)
    {
      ac.e("MicroMsg.Note.NoteDataManager", "pasteItemList, but get wnnote base is null, return");
      AppMethodBeat.o(30436);
      return -1;
    }
    Object localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(paramArrayList.size() - 1);
    if (localObject1 == null)
    {
      ac.e("MicroMsg.Note.NoteDataManager", "pasteItemList, lastInsertItem is null");
      AppMethodBeat.o(30436);
      return -1;
    }
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).oPX = -1;
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).oPV = true;
    ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).oQb = false;
    Object localObject3 = Wh(paramInt2);
    if (localObject3 == null)
    {
      ac.e("MicroMsg.Note.NoteDataManager", "pasteItemList, item is null");
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
        bZJ();
        if ((paramInt1 != 0) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType() != 1)) {
          break label896;
        }
        Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Xo(((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content);
        if ((localObject2 == null) || (paramInt3 > ((Spanned)localObject2).length()) || (paramInt4 > ((Spanned)localObject2).length()))
        {
          if (localObject2 == null)
          {
            paramInt1 = -1;
            ac.e("MicroMsg.Note.NoteDataManager", "pasteItemList error, oriText:%d  startOff:%d  endOff:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
        if (!bs.isNullOrNil((String)localObject2))
        {
          if (!((String)localObject2).endsWith("<br/>")) {
            break label879;
          }
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content = ((String)localObject2);
          paramInt2 += 1;
          paramInt1 = paramInt2;
          if (bs.isNullOrNil((String)localObject1)) {
            break label882;
          }
          localObject3 = new com.tencent.mm.plugin.wenote.model.a.i();
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).type = 1;
          localObject2 = localObject1;
          if (((String)localObject1).startsWith("<br/>")) {
            localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
          }
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content = ((String)localObject2);
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oPX = 0;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oPV = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oQb = false;
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
          if (!bs.isNullOrNil((String)localObject1))
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
          AT(paramInt2);
          paramInt1 = paramInt2;
          if (this.CVY == null) {
            break label882;
          }
          this.CVY.AP(paramInt2);
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
        if ((j - 1 >= 0) && (j - 1 < eIb().size()))
        {
          paramInt1 = j - 1;
          if (this.CVY != null)
          {
            paramInt3 = j - i;
            paramInt2 = paramInt3;
            if (paramInt4 != 0) {
              paramInt2 = paramInt3 + 1;
            }
            if ((i >= 0) && (paramInt2 > 0)) {
              this.CVY.eY(i, paramInt2);
            }
            if (i <= 0) {
              break label840;
            }
            this.CVY.eZ(i - 1, eIb().size() - (i - 1));
            this.CVY.AQ(paramInt1);
          }
          bZP();
          AppMethodBeat.o(30436);
          return paramInt1;
        }
      }
      finally
      {
        AppMethodBeat.o(30436);
      }
      paramInt1 = eIb().size() - 1;
      continue;
      label840:
      if (i == 0)
      {
        this.CVY.eZ(i, eIb().size() - i);
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
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.ijj == null))
    {
      ac.e("MicroMsg.Note.NoteDataManager", "insertItemList,error,return");
      AppMethodBeat.o(30435);
      return -1;
    }
    if (com.tencent.mm.plugin.wenote.model.c.eHP().CUG == null)
    {
      ac.e("MicroMsg.Note.NoteDataManager", "insertItemList, but get wnnote base is null, return");
      AppMethodBeat.o(30435);
      return -1;
    }
    if ((paramBoolean2) && (N(paramArrayList)) && (this.CVY != null))
    {
      this.CVY.bYO();
      AppMethodBeat.o(30435);
      return -1;
    }
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(paramArrayList.size() - 1);
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).oPX = -1;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).oPV = true;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).oQb = false;
      if ((paramWXRTEditText != null) && (paramWXRTEditText.oRL))
      {
        if (paramWXRTEditText.getEditTextType() != 2) {
          break label286;
        }
        ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).oQe = 2;
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
      paramWXRTEditText.oRL = false;
      ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).oQf = paramWXRTEditText.oQf;
      paramWXRTEditText.oQf = 0;
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getRecyclerItemPosition() != 0)) {
        if (paramWXRTEditText != null) {
          break label646;
        }
      }
      try
      {
        n = size();
        bZJ();
        paramArrayList = paramArrayList.iterator();
        i = n;
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            paramWXRTEditText = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.next();
            b(paramWXRTEditText);
            if ((paramWXRTEditText == null) || (this.ijj == null)) {
              break label1272;
            }
            this.ijj.add(paramWXRTEditText);
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
            ((com.tencent.mm.plugin.wenote.model.a.c)localObject1).oQe = 1;
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
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).oPV = false;
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).oQb = false;
            paramArrayList.add(0, localObject1);
            break label194;
          }
        }
        i1 = 0;
        if ((i - 1 < 0) || (i - 1 >= eIb().size())) {
          break;
        }
        j = i - 1;
        k = j;
        m = i;
        if (paramBoolean4)
        {
          j += 1;
          i += 1;
          bZJ();
          if (j >= eIb().size()) {
            break label1167;
          }
          paramArrayList = eIb().Wh(j);
          k = j;
          m = i;
          if (paramArrayList != null)
          {
            paramArrayList.oPX = 0;
            paramArrayList.oPV = true;
            paramArrayList.oQb = false;
            m = i;
            k = j;
          }
        }
        label527:
        if (this.CVY != null)
        {
          j = m - n;
          i = j;
          if (i1 != 0) {
            i = j + 1;
          }
          if ((n >= 0) && (i > 0)) {
            this.CVY.eY(n, i);
          }
          if (n <= 0) {
            break label1221;
          }
          this.CVY.eZ(n - 1, eIb().size() - (n - 1));
          label608:
          if (paramBoolean3) {
            this.CVY.bYN();
          }
          this.CVY.AQ(k);
        }
        bZP();
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
    localObject2 = Wh(j);
    if (localObject2 == null)
    {
      AppMethodBeat.o(30435);
      return -1;
    }
    bZJ();
    if ((paramWXRTEditText.getEditTextType() == 0) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() == 1))
    {
      localObject1 = paramWXRTEditText.getSelection();
      localObject3 = paramWXRTEditText.getText();
      paramWXRTEditText = ((Editable)localObject3).subSequence(0, ((e)localObject1).atr);
      localObject3 = ((Editable)localObject3).subSequence(((e)localObject1).MZ, ((Editable)localObject3).length());
      localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)paramWXRTEditText);
      paramWXRTEditText = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject3);
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.i)localObject2;
      if (!bs.isNullOrNil((String)localObject1))
      {
        if (((String)localObject1).endsWith("<br/>"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
          label801:
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content = ((String)localObject1);
          j += 1;
          i = j;
          if (bs.isNullOrNil(paramWXRTEditText)) {
            break label1291;
          }
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.i();
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).type = 1;
          localObject1 = paramWXRTEditText;
          if (paramWXRTEditText.startsWith("<br/>")) {
            localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
          }
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content = ((String)localObject1);
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oPX = 0;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oPV = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oQb = false;
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
          if (bs.isNullOrNil(paramWXRTEditText)) {
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
        AT(j);
        i = j;
        if (this.CVY == null) {
          break label1291;
        }
        this.CVY.AP(j);
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
        j = eIb().size() - 1;
        break label443;
        paramArrayList = new com.tencent.mm.plugin.wenote.model.a.i();
        paramArrayList.type = 1;
        paramArrayList.content = "";
        paramArrayList.oPX = 0;
        paramArrayList.oPV = true;
        paramArrayList.oQb = false;
        b(j, paramArrayList);
        k = j;
        m = i;
        break label527;
        label1221:
        if (n != 0) {
          break label608;
        }
        this.CVY.eZ(n, eIb().size() - n);
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
        if (this.ijj == null)
        {
          return;
          i += 1;
        }
        if (i < this.ijj.size())
        {
          if (!((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i)).eHV().equals(paramString)) {
            continue;
          }
          a((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i), false);
          this.ijj.set(i, paramc);
          a(paramc, true);
          if ((i != -1) && (this.CVY != null)) {
            this.CVY.AN(i);
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
        if ((this.ijj == null) || (paramInt < 0) || (paramInt > this.ijj.size())) {
          break label138;
        }
        this.ijj.add(paramInt, paramc);
        a(paramc, true);
        if ((bool) && (this.CVY != null))
        {
          this.CVY.AO(paramInt);
          if (paramInt > 0) {
            this.CVY.eZ(paramInt - 1, this.ijj.size() - (paramInt - 1));
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
      this.CVY.eZ(paramInt, this.ijj.size() - paramInt);
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
        if (this.ijj != null)
        {
          this.ijj.add(paramc);
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
  
  public final void aEI(String paramString)
  {
    AppMethodBeat.i(30421);
    if ((bs.isNullOrNil(paramString)) || (this.ijj == null))
    {
      AppMethodBeat.o(30421);
      return;
    }
    Object localObject = com.tencent.mm.plugin.wenote.c.b.Xj(paramString);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      for (;;)
      {
        try
        {
          ac.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, mHasInitDataListFinish :％B", new Object[] { Boolean.valueOf(this.CVZ) });
          paramString = az.agU();
          localObject = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(30408);
              ArrayList localArrayList = h.a(c.d(c.this), this.CWb, false);
              ac.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, start mNotifyListener.setUpNoteData(dataItems, true)");
              if (c.e(c.this) != null) {
                c.e(c.this).f(localArrayList, true);
              }
              AppMethodBeat.o(30408);
            }
          };
          if (!this.CVZ) {
            continue;
          }
          l = 500L;
          paramString.m((Runnable)localObject, l);
        }
        catch (Exception paramString)
        {
          long l;
          ac.e("MicroMsg.Note.NoteDataManager", "updateDataByHtml exception,%s", new Object[] { paramString.toString() });
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
  
  public final String aEJ(String paramString)
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
        if (this.ijj == null) {
          break label202;
        }
        i = 0;
        if (i >= this.ijj.size()) {
          break label229;
        }
        if (((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i)).getType() != 1) {
          break label196;
        }
        localObject = com.tencent.mm.plugin.wenote.c.b.Xk(((com.tencent.mm.plugin.wenote.model.a.i)this.ijj.get(i)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
        if (bs.isNullOrNil((String)localObject)) {
          break label196;
        }
        localObject = ((String)localObject).split("\n");
        j = 0;
        if (j >= localObject.length) {
          break label188;
        }
        if (bs.isNullOrNil(localObject[j].trim())) {
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
        if (this.ijj == null) {
          break label174;
        }
        k = 0;
        j = 0;
        i = paramInt;
        paramInt = j;
        if ((k >= paramArrayList.size()) || (i < 0) || (i > this.ijj.size())) {
          break label203;
        }
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)paramArrayList.get(k);
        j = paramInt;
        m = i;
        if (localc == null) {
          break label188;
        }
        b(localc);
        this.ijj.add(i, localc);
        j = paramInt + 1;
        m = i + 1;
        a(localc, true);
      }
      finally
      {
        AppMethodBeat.o(30414);
      }
      if ((bool) && (this.CVY != null)) {
        this.CVY.eY(i - paramInt, paramInt);
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
  
  public final void bZG()
  {
    AppMethodBeat.i(30422);
    if (this.ijj != null) {}
    for (int i = this.ijj.size();; i = 0)
    {
      ac.i("MicroMsg.Note.NoteDataManager", "clear mDataList, size:%d", new Object[] { Integer.valueOf(i) });
      try
      {
        if (this.ijj != null) {
          this.ijj.clear();
        }
        this.oQO = 0;
        this.oQN = 0;
        AppMethodBeat.o(30422);
        return;
      }
      finally
      {
        AppMethodBeat.o(30422);
      }
    }
  }
  
  public final int bZH()
  {
    AppMethodBeat.i(30424);
    for (;;)
    {
      try
      {
        if (this.ijj != null)
        {
          i = 0;
          if (i < this.ijj.size())
          {
            if (((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i)).oPV) {
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
  
  public final void bZI()
  {
    AppMethodBeat.i(30425);
    try
    {
      if (this.ijj != null)
      {
        Iterator localIterator = this.ijj.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
          localc.oPV = false;
          localc.oQb = false;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(30425);
    }
    AppMethodBeat.o(30425);
  }
  
  public final int bZK()
  {
    AppMethodBeat.i(30428);
    for (;;)
    {
      try
      {
        if (this.ijj != null)
        {
          i = 0;
          if (i < this.ijj.size())
          {
            if ((((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i)).getType() == 4) && (((l)this.ijj.get(i)).oQs.booleanValue())) {
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
  
  public final String bZL()
  {
    AppMethodBeat.i(30429);
    for (;;)
    {
      try
      {
        if ((this.oQM != 0) || (this.ijj == null)) {
          break;
        }
        Iterator localIterator = this.ijj.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        o localo = (o)localIterator.next();
        if (localo.oQi.startsWith("WeNote_"))
        {
          i = bs.getInt(localo.oQi.substring(7), -1);
          if (i > this.oQM) {
            this.oQM = i;
          } else {
            i = this.oQM;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(30429);
      }
    }
    Object localObject2 = new StringBuilder("WeNote_");
    int i = this.oQM + 1;
    this.oQM = i;
    localObject2 = i;
    AppMethodBeat.o(30429);
    return localObject2;
  }
  
  public final String bZN()
  {
    AppMethodBeat.i(30431);
    Object localObject1 = "";
    for (;;)
    {
      int i;
      try
      {
        if ((this.ijj == null) || (this.ijj.size() <= 0)) {
          return "";
        }
        i = 0;
        Object localObject3;
        if (i < this.ijj.size()) {
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i);
        }
        switch (((com.tencent.mm.plugin.wenote.model.a.c)localObject3).getType())
        {
        case 1: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.i)localObject3;
          if (bs.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content))
          {
            localObject1 = (String)localObject1 + "<br/>";
          }
          else
          {
            localObject3 = (String)localObject1 + ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content;
            localObject1 = localObject3;
            if (i + 1 < this.ijj.size())
            {
              localObject1 = localObject3;
              if (((com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i + 1)).getType() == 1)
              {
                localObject1 = localObject3;
                if (!bs.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i)this.ijj.get(i + 1)).content)) {
                  localObject1 = (String)localObject3 + "<br/>";
                }
              }
            }
          }
          break;
        case 2: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.f)localObject3;
          localObject1 = (String)localObject1 + cM(((com.tencent.mm.plugin.wenote.model.a.f)localObject3).oQi, 2);
          break;
        case 6: 
          localObject3 = (k)localObject3;
          localObject1 = (String)localObject1 + cM(((k)localObject3).oQi, 6);
          break;
        case 20: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.b)localObject3;
          localObject1 = (String)localObject1 + cM(((com.tencent.mm.plugin.wenote.model.a.b)localObject3).oQi, 20);
          break;
        case 4: 
          localObject3 = (l)localObject3;
          localObject1 = (String)localObject1 + cM(((l)localObject3).oQi, ((l)localObject3).getType());
          break;
        case 3: 
          localObject3 = (g)localObject3;
          localObject1 = (String)localObject1 + cM(((g)localObject3).oQi, 3);
          break;
        case 5: 
          localObject3 = (com.tencent.mm.plugin.wenote.model.a.d)localObject3;
          localObject1 = (String)localObject1 + cM(((com.tencent.mm.plugin.wenote.model.a.d)localObject3).oQi, 5);
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
  
  public final ArrayList<com.tencent.mm.plugin.wenote.model.a.c> bZO()
  {
    AppMethodBeat.i(30438);
    if (this.ijj == null)
    {
      AppMethodBeat.o(30438);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.ijj.iterator();
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
  
  public final void bZP()
  {
    AppMethodBeat.i(30440);
    az.agU().az(new Runnable()
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
        c.a(c.this, com.tencent.mm.plugin.wenote.c.c.Xf(localObject.toString()));
        c.b(c.this, i);
        AppMethodBeat.o(30409);
      }
    });
    AppMethodBeat.o(30440);
  }
  
  public final int bZQ()
  {
    AppMethodBeat.i(30444);
    try
    {
      if (this.ijj == null) {
        return -1;
      }
      int i = 0;
      while (i < this.ijj.size())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i);
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
  
  public final int bZR()
  {
    AppMethodBeat.i(30445);
    try
    {
      if (this.ijj == null) {
        return -1;
      }
      int i = this.ijj.size() - 1;
      while (i >= 0)
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(i);
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
  
  public final void eIc()
  {
    AppMethodBeat.i(179744);
    this.CVY = null;
    if (this.ijj != null)
    {
      Iterator localIterator = this.ijj.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        localc.CVF = null;
        localc.CVD = null;
        localc.CVE = null;
      }
    }
    AppMethodBeat.o(179744);
  }
  
  public final boolean fb(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (paramInt2 < 0) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (this.oQN + paramInt1 > 16384)) {}
        while ((j != 0) && (this.oQO + paramInt2 > 30)) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final void fc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30442);
    ac.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.TRUE });
    for (;;)
    {
      Object localObject3;
      int i;
      Spanned localSpanned2;
      try
      {
        if (this.ijj == null) {
          return;
        }
        int j = paramInt1;
        if (paramInt1 <= 0) {
          j = 0;
        }
        if (paramInt2 < this.ijj.size()) {
          break label487;
        }
        paramInt2 = this.ijj.size() - 1;
        paramInt1 = -1;
        if (paramInt2 <= j) {
          break label443;
        }
        Object localObject1 = (com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(paramInt2);
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.c)this.ijj.get(paramInt2 - 1);
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
        if (bs.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content)) {
          break label414;
        }
        Spanned localSpanned1 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Xo(((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content);
        localSpanned2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Xo(((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content);
        ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content = (((com.tencent.mm.plugin.wenote.model.a.i)localObject3).content + "<br/>" + ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content);
        if (((com.tencent.mm.plugin.wenote.model.a.i)localObject1).oPV)
        {
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oPV = true;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oQb = false;
          if ((((com.tencent.mm.plugin.wenote.model.a.i)localObject1).oPX == -1) || (((com.tencent.mm.plugin.wenote.model.a.i)localObject1).oPX >= localSpanned1.length()))
          {
            ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oPX = -1;
            ac.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem remove position: %d", new Object[] { Integer.valueOf(paramInt2) });
            AT(paramInt2);
            i = paramInt1;
            if (this.CVY == null) {
              break label492;
            }
            this.CVY.AP(paramInt2);
            i = paramInt1;
            break label492;
          }
          i = localSpanned2.length();
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).oPX += i + 1;
          continue;
        }
        if (!((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oPV) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(30442);
      }
      if (((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oPX == -1)
      {
        ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oPX = localSpanned2.length();
        continue;
        label414:
        if (localObject2.oPV)
        {
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oPV = true;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oQb = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject3).oPX = -1;
          continue;
          label443:
          if ((paramInt1 != -1) && (this.CVY != null)) {
            this.CVY.eZ(paramInt1, this.ijj.size() - paramInt1);
          }
          bZP();
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
    if (this.ijj != null)
    {
      int i = this.ijj.size();
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