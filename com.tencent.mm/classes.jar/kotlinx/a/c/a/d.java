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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/internal/JsonParser;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/JsonReader;)V", "isLenient", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readObject", "readValue", "isString", "kotlinx-serialization-runtime"})
public final class d
{
  private final boolean Okx;
  private final f Olm;
  
  public d(kotlinx.a.c.d paramd, f paramf)
  {
    AppMethodBeat.i(199955);
    this.Olm = paramf;
    this.Okx = paramd.Okx;
    AppMethodBeat.o(199955);
  }
  
  private final kotlinx.a.c.f AM(boolean paramBoolean)
  {
    AppMethodBeat.i(199953);
    if ((!this.Okx) && (paramBoolean)) {}
    for (Object localObject = this.Olm.gBT();; localObject = this.Olm.gBS())
    {
      localObject = (kotlinx.a.c.f)new o(localObject, paramBoolean);
      AppMethodBeat.o(199953);
      return localObject;
    }
  }
  
  private final kotlinx.a.c.f gBO()
  {
    int j = 1;
    AppMethodBeat.i(199951);
    Object localObject1 = this.Olm;
    if (((f)localObject1).Olo != 6)
    {
      ((f)localObject1).hF("Expected start of the object", ((f)localObject1).Olp);
      AppMethodBeat.o(199951);
      throw null;
    }
    this.Olm.gBV();
    localObject1 = this.Olm;
    if (this.Olm.Olo != 4) {}
    for (int i = 1;; i = 0)
    {
      int k = this.Olm.vFD;
      if (i != 0) {
        break;
      }
      ((f)localObject1).hF("Unexpected leading comma", k);
      AppMethodBeat.o(199951);
      throw null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    i = 0;
    while (this.Olm.gBR())
    {
      if (this.Okx) {}
      for (localObject1 = this.Olm.gBS();; localObject1 = this.Olm.gBT())
      {
        localObject2 = this.Olm;
        if (((f)localObject2).Olo == 5) {
          break;
        }
        ((f)localObject2).hF("Expected ':'", ((f)localObject2).Olp);
        AppMethodBeat.o(199951);
        throw null;
      }
      this.Olm.gBV();
      Object localObject2 = gBQ();
      ((Map)localLinkedHashMap).put(localObject1, localObject2);
      if (this.Olm.Olo != 4)
      {
        localObject1 = this.Olm;
        if (((f)localObject1).Olo != 7)
        {
          ((f)localObject1).hF("Expected end of the object or comma", ((f)localObject1).Olp);
          AppMethodBeat.o(199951);
          throw null;
        }
        i = 0;
      }
      else
      {
        this.Olm.gBV();
        i = 1;
      }
    }
    localObject1 = this.Olm;
    if ((i == 0) && (this.Olm.Olo == 7)) {}
    for (i = j;; i = 0)
    {
      j = this.Olm.vFD;
      if (i != 0) {
        break;
      }
      ((f)localObject1).hF("Expected end of the object", j);
      AppMethodBeat.o(199951);
      throw null;
    }
    this.Olm.gBV();
    localObject1 = (kotlinx.a.c.f)new s((Map)localLinkedHashMap);
    AppMethodBeat.o(199951);
    return localObject1;
  }
  
  private final kotlinx.a.c.f gBP()
  {
    int j = 1;
    AppMethodBeat.i(199952);
    Object localObject = this.Olm;
    if (((f)localObject).Olo != 8)
    {
      ((f)localObject).hF("Expected start of the array", ((f)localObject).Olp);
      AppMethodBeat.o(199952);
      throw null;
    }
    this.Olm.gBV();
    localObject = this.Olm;
    if (this.Olm.Olo != 4) {}
    for (int i = 1;; i = 0)
    {
      int k = this.Olm.vFD;
      if (i != 0) {
        break;
      }
      ((f)localObject).hF("Unexpected leading comma", k);
      AppMethodBeat.o(199952);
      throw null;
    }
    localObject = new ArrayList();
    i = 0;
    while (this.Olm.gBR())
    {
      ((ArrayList)localObject).add(gBQ());
      if (this.Olm.Olo != 4)
      {
        localf = this.Olm;
        if (localf.Olo != 9)
        {
          localf.hF("Expected end of the array or comma", localf.Olp);
          AppMethodBeat.o(199952);
          throw null;
        }
        i = 0;
      }
      else
      {
        this.Olm.gBV();
        i = 1;
      }
    }
    f localf = this.Olm;
    if (i == 0) {}
    for (i = j;; i = 0)
    {
      j = this.Olm.vFD;
      if (i != 0) {
        break;
      }
      localf.hF("Unexpected trailing comma", j);
      AppMethodBeat.o(199952);
      throw null;
    }
    this.Olm.gBV();
    localObject = (kotlinx.a.c.f)new b((List)localObject);
    AppMethodBeat.o(199952);
    return localObject;
  }
  
  public final kotlinx.a.c.f gBQ()
  {
    AppMethodBeat.i(199954);
    if (!this.Olm.gBR())
    {
      f.a(this.Olm, "Can't begin reading value from here");
      AppMethodBeat.o(199954);
      throw null;
    }
    switch (this.Olm.Olo)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      f.a(this.Olm, "Can't begin reading element, unexpected token");
      AppMethodBeat.o(199954);
      throw null;
    case 10: 
      localObject = q.OkX;
      this.Olm.gBV();
      localObject = (kotlinx.a.c.f)localObject;
      AppMethodBeat.o(199954);
      return localObject;
    case 1: 
      localObject = AM(true);
      AppMethodBeat.o(199954);
      return localObject;
    case 0: 
      localObject = AM(false);
      AppMethodBeat.o(199954);
      return localObject;
    case 6: 
      localObject = gBO();
      AppMethodBeat.o(199954);
      return localObject;
    }
    Object localObject = gBP();
    AppMethodBeat.o(199954);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */