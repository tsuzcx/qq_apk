package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.l;
import kotlinx.a.c.b;
import kotlinx.a.c.o;
import kotlinx.a.c.q;
import kotlinx.a.c.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/JsonParser;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/JsonReader;)V", "isLenient", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readObject", "readValue", "isString", "kotlinx-serialization-runtime"})
public final class d
{
  private final boolean TZs;
  private final f Uaj;
  
  public d(kotlinx.a.c.d paramd, f paramf)
  {
    AppMethodBeat.i(225727);
    this.Uaj = paramf;
    this.TZs = paramd.TZs;
    AppMethodBeat.o(225727);
  }
  
  private final kotlinx.a.c.f Fc(boolean paramBoolean)
  {
    AppMethodBeat.i(225725);
    if ((!this.TZs) && (paramBoolean)) {}
    for (Object localObject = this.Uaj.hPa();; localObject = this.Uaj.hOZ())
    {
      localObject = (kotlinx.a.c.f)new o(localObject, paramBoolean);
      AppMethodBeat.o(225725);
      return localObject;
    }
  }
  
  private final kotlinx.a.c.f hOV()
  {
    int j = 1;
    AppMethodBeat.i(225723);
    Object localObject1 = this.Uaj;
    if (((f)localObject1).Ual != 6)
    {
      ((f)localObject1).ib("Expected start of the object", ((f)localObject1).Uam);
      AppMethodBeat.o(225723);
      throw null;
    }
    this.Uaj.hPc();
    localObject1 = this.Uaj;
    if (this.Uaj.Ual != 4) {}
    for (int i = 1;; i = 0)
    {
      int k = this.Uaj.zaD;
      if (i != 0) {
        break;
      }
      ((f)localObject1).ib("Unexpected leading comma", k);
      AppMethodBeat.o(225723);
      throw null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    i = 0;
    while (this.Uaj.hOY())
    {
      if (this.TZs) {}
      for (localObject1 = this.Uaj.hOZ();; localObject1 = this.Uaj.hPa())
      {
        localObject2 = this.Uaj;
        if (((f)localObject2).Ual == 5) {
          break;
        }
        ((f)localObject2).ib("Expected ':'", ((f)localObject2).Uam);
        AppMethodBeat.o(225723);
        throw null;
      }
      this.Uaj.hPc();
      Object localObject2 = hOX();
      ((Map)localLinkedHashMap).put(localObject1, localObject2);
      if (this.Uaj.Ual != 4)
      {
        localObject1 = this.Uaj;
        if (((f)localObject1).Ual != 7)
        {
          ((f)localObject1).ib("Expected end of the object or comma", ((f)localObject1).Uam);
          AppMethodBeat.o(225723);
          throw null;
        }
        i = 0;
      }
      else
      {
        this.Uaj.hPc();
        i = 1;
      }
    }
    localObject1 = this.Uaj;
    if ((i == 0) && (this.Uaj.Ual == 7)) {}
    for (i = j;; i = 0)
    {
      j = this.Uaj.zaD;
      if (i != 0) {
        break;
      }
      ((f)localObject1).ib("Expected end of the object", j);
      AppMethodBeat.o(225723);
      throw null;
    }
    this.Uaj.hPc();
    localObject1 = (kotlinx.a.c.f)new s((Map)localLinkedHashMap);
    AppMethodBeat.o(225723);
    return localObject1;
  }
  
  private final kotlinx.a.c.f hOW()
  {
    int j = 1;
    AppMethodBeat.i(225724);
    Object localObject = this.Uaj;
    if (((f)localObject).Ual != 8)
    {
      ((f)localObject).ib("Expected start of the array", ((f)localObject).Uam);
      AppMethodBeat.o(225724);
      throw null;
    }
    this.Uaj.hPc();
    localObject = this.Uaj;
    if (this.Uaj.Ual != 4) {}
    for (int i = 1;; i = 0)
    {
      int k = this.Uaj.zaD;
      if (i != 0) {
        break;
      }
      ((f)localObject).ib("Unexpected leading comma", k);
      AppMethodBeat.o(225724);
      throw null;
    }
    localObject = new ArrayList();
    i = 0;
    while (this.Uaj.hOY())
    {
      ((ArrayList)localObject).add(hOX());
      if (this.Uaj.Ual != 4)
      {
        localf = this.Uaj;
        if (localf.Ual != 9)
        {
          localf.ib("Expected end of the array or comma", localf.Uam);
          AppMethodBeat.o(225724);
          throw null;
        }
        i = 0;
      }
      else
      {
        this.Uaj.hPc();
        i = 1;
      }
    }
    f localf = this.Uaj;
    if (i == 0) {}
    for (i = j;; i = 0)
    {
      j = this.Uaj.zaD;
      if (i != 0) {
        break;
      }
      localf.ib("Unexpected trailing comma", j);
      AppMethodBeat.o(225724);
      throw null;
    }
    this.Uaj.hPc();
    localObject = (kotlinx.a.c.f)new b((List)localObject);
    AppMethodBeat.o(225724);
    return localObject;
  }
  
  public final kotlinx.a.c.f hOX()
  {
    AppMethodBeat.i(225726);
    if (!this.Uaj.hOY())
    {
      f.a(this.Uaj, "Can't begin reading value from here");
      AppMethodBeat.o(225726);
      throw null;
    }
    switch (this.Uaj.Ual)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      f.a(this.Uaj, "Can't begin reading element, unexpected token");
      AppMethodBeat.o(225726);
      throw null;
    case 10: 
      localObject = q.TZU;
      this.Uaj.hPc();
      localObject = (kotlinx.a.c.f)localObject;
      AppMethodBeat.o(225726);
      return localObject;
    case 1: 
      localObject = Fc(true);
      AppMethodBeat.o(225726);
      return localObject;
    case 0: 
      localObject = Fc(false);
      AppMethodBeat.o(225726);
      return localObject;
    case 6: 
      localObject = hOV();
      AppMethodBeat.o(225726);
      return localObject;
    }
    Object localObject = hOW();
    AppMethodBeat.o(225726);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */