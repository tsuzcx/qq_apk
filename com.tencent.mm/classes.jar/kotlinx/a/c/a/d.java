package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.a.c.b;
import kotlinx.a.c.o;
import kotlinx.a.c.q;
import kotlinx.a.c.s;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/internal/JsonParser;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/JsonReader;)V", "isLenient", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readObject", "readValue", "isString", "kotlinx-serialization-runtime"})
public final class d
{
  private final boolean NNr;
  private final f NOg;
  
  public d(kotlinx.a.c.d paramd, f paramf)
  {
    AppMethodBeat.i(191367);
    this.NOg = paramf;
    this.NNr = paramd.NNr;
    AppMethodBeat.o(191367);
  }
  
  private final kotlinx.a.c.f Az(boolean paramBoolean)
  {
    AppMethodBeat.i(191365);
    if ((!this.NNr) && (paramBoolean)) {}
    for (Object localObject = this.NOg.gxr();; localObject = this.NOg.gxq())
    {
      localObject = (kotlinx.a.c.f)new o(localObject, paramBoolean);
      AppMethodBeat.o(191365);
      return localObject;
    }
  }
  
  private final kotlinx.a.c.f gxm()
  {
    int j = 1;
    AppMethodBeat.i(191363);
    Object localObject1 = this.NOg;
    if (((f)localObject1).NOi != 6)
    {
      ((f)localObject1).hw("Expected start of the object", ((f)localObject1).NOj);
      AppMethodBeat.o(191363);
      throw null;
    }
    this.NOg.gxt();
    localObject1 = this.NOg;
    if (this.NOg.NOi != 4) {}
    for (int i = 1;; i = 0)
    {
      int k = this.NOg.vty;
      if (i != 0) {
        break;
      }
      ((f)localObject1).hw("Unexpected leading comma", k);
      AppMethodBeat.o(191363);
      throw null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    i = 0;
    while (this.NOg.gxp())
    {
      if (this.NNr) {}
      for (localObject1 = this.NOg.gxq();; localObject1 = this.NOg.gxr())
      {
        localObject2 = this.NOg;
        if (((f)localObject2).NOi == 5) {
          break;
        }
        ((f)localObject2).hw("Expected ':'", ((f)localObject2).NOj);
        AppMethodBeat.o(191363);
        throw null;
      }
      this.NOg.gxt();
      Object localObject2 = gxo();
      ((Map)localLinkedHashMap).put(localObject1, localObject2);
      if (this.NOg.NOi != 4)
      {
        localObject1 = this.NOg;
        if (((f)localObject1).NOi != 7)
        {
          ((f)localObject1).hw("Expected end of the object or comma", ((f)localObject1).NOj);
          AppMethodBeat.o(191363);
          throw null;
        }
        i = 0;
      }
      else
      {
        this.NOg.gxt();
        i = 1;
      }
    }
    localObject1 = this.NOg;
    if ((i == 0) && (this.NOg.NOi == 7)) {}
    for (i = j;; i = 0)
    {
      j = this.NOg.vty;
      if (i != 0) {
        break;
      }
      ((f)localObject1).hw("Expected end of the object", j);
      AppMethodBeat.o(191363);
      throw null;
    }
    this.NOg.gxt();
    localObject1 = (kotlinx.a.c.f)new s((Map)localLinkedHashMap);
    AppMethodBeat.o(191363);
    return localObject1;
  }
  
  private final kotlinx.a.c.f gxn()
  {
    int j = 1;
    AppMethodBeat.i(191364);
    Object localObject = this.NOg;
    if (((f)localObject).NOi != 8)
    {
      ((f)localObject).hw("Expected start of the array", ((f)localObject).NOj);
      AppMethodBeat.o(191364);
      throw null;
    }
    this.NOg.gxt();
    localObject = this.NOg;
    if (this.NOg.NOi != 4) {}
    for (int i = 1;; i = 0)
    {
      int k = this.NOg.vty;
      if (i != 0) {
        break;
      }
      ((f)localObject).hw("Unexpected leading comma", k);
      AppMethodBeat.o(191364);
      throw null;
    }
    localObject = new ArrayList();
    i = 0;
    while (this.NOg.gxp())
    {
      ((ArrayList)localObject).add(gxo());
      if (this.NOg.NOi != 4)
      {
        localf = this.NOg;
        if (localf.NOi != 9)
        {
          localf.hw("Expected end of the array or comma", localf.NOj);
          AppMethodBeat.o(191364);
          throw null;
        }
        i = 0;
      }
      else
      {
        this.NOg.gxt();
        i = 1;
      }
    }
    f localf = this.NOg;
    if (i == 0) {}
    for (i = j;; i = 0)
    {
      j = this.NOg.vty;
      if (i != 0) {
        break;
      }
      localf.hw("Unexpected trailing comma", j);
      AppMethodBeat.o(191364);
      throw null;
    }
    this.NOg.gxt();
    localObject = (kotlinx.a.c.f)new b((List)localObject);
    AppMethodBeat.o(191364);
    return localObject;
  }
  
  public final kotlinx.a.c.f gxo()
  {
    AppMethodBeat.i(191366);
    if (!this.NOg.gxp())
    {
      f.a(this.NOg, "Can't begin reading value from here");
      AppMethodBeat.o(191366);
      throw null;
    }
    switch (this.NOg.NOi)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      f.a(this.NOg, "Can't begin reading element, unexpected token");
      AppMethodBeat.o(191366);
      throw null;
    case 10: 
      localObject = q.NNR;
      this.NOg.gxt();
      localObject = (kotlinx.a.c.f)localObject;
      AppMethodBeat.o(191366);
      return localObject;
    case 1: 
      localObject = Az(true);
      AppMethodBeat.o(191366);
      return localObject;
    case 0: 
      localObject = Az(false);
      AppMethodBeat.o(191366);
      return localObject;
    case 6: 
      localObject = gxm();
      AppMethodBeat.o(191366);
      return localObject;
    }
    Object localObject = gxn();
    AppMethodBeat.o(191366);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */