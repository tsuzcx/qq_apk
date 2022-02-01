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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/JsonParser;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/JsonReader;)V", "isLenient", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readObject", "readValue", "isString", "kotlinx-serialization-runtime"})
public final class d
{
  private final boolean abCI;
  private final f abDx;
  
  public d(kotlinx.a.c.d paramd, f paramf)
  {
    AppMethodBeat.i(256359);
    this.abDx = paramf;
    this.abCI = paramd.abCI;
    AppMethodBeat.o(256359);
  }
  
  private final kotlinx.a.c.f JL(boolean paramBoolean)
  {
    AppMethodBeat.i(256357);
    if ((!this.abCI) && (paramBoolean)) {}
    for (Object localObject = this.abDx.iUh();; localObject = this.abDx.iUg())
    {
      localObject = (kotlinx.a.c.f)new o(localObject, paramBoolean);
      AppMethodBeat.o(256357);
      return localObject;
    }
  }
  
  private final kotlinx.a.c.f iUc()
  {
    int j = 1;
    AppMethodBeat.i(256352);
    Object localObject1 = this.abDx;
    if (((f)localObject1).abDz != 6)
    {
      ((f)localObject1).iK("Expected start of the object", ((f)localObject1).abDA);
      AppMethodBeat.o(256352);
      throw null;
    }
    this.abDx.iUj();
    localObject1 = this.abDx;
    if (this.abDx.abDz != 4) {}
    for (int i = 1;; i = 0)
    {
      int k = this.abDx.zrB;
      if (i != 0) {
        break;
      }
      ((f)localObject1).iK("Unexpected leading comma", k);
      AppMethodBeat.o(256352);
      throw null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    i = 0;
    while (this.abDx.iUf())
    {
      if (this.abCI) {}
      for (localObject1 = this.abDx.iUg();; localObject1 = this.abDx.iUh())
      {
        localObject2 = this.abDx;
        if (((f)localObject2).abDz == 5) {
          break;
        }
        ((f)localObject2).iK("Expected ':'", ((f)localObject2).abDA);
        AppMethodBeat.o(256352);
        throw null;
      }
      this.abDx.iUj();
      Object localObject2 = iUe();
      ((Map)localLinkedHashMap).put(localObject1, localObject2);
      if (this.abDx.abDz != 4)
      {
        localObject1 = this.abDx;
        if (((f)localObject1).abDz != 7)
        {
          ((f)localObject1).iK("Expected end of the object or comma", ((f)localObject1).abDA);
          AppMethodBeat.o(256352);
          throw null;
        }
        i = 0;
      }
      else
      {
        this.abDx.iUj();
        i = 1;
      }
    }
    localObject1 = this.abDx;
    if ((i == 0) && (this.abDx.abDz == 7)) {}
    for (i = j;; i = 0)
    {
      j = this.abDx.zrB;
      if (i != 0) {
        break;
      }
      ((f)localObject1).iK("Expected end of the object", j);
      AppMethodBeat.o(256352);
      throw null;
    }
    this.abDx.iUj();
    localObject1 = (kotlinx.a.c.f)new s((Map)localLinkedHashMap);
    AppMethodBeat.o(256352);
    return localObject1;
  }
  
  private final kotlinx.a.c.f iUd()
  {
    int j = 1;
    AppMethodBeat.i(256355);
    Object localObject = this.abDx;
    if (((f)localObject).abDz != 8)
    {
      ((f)localObject).iK("Expected start of the array", ((f)localObject).abDA);
      AppMethodBeat.o(256355);
      throw null;
    }
    this.abDx.iUj();
    localObject = this.abDx;
    if (this.abDx.abDz != 4) {}
    for (int i = 1;; i = 0)
    {
      int k = this.abDx.zrB;
      if (i != 0) {
        break;
      }
      ((f)localObject).iK("Unexpected leading comma", k);
      AppMethodBeat.o(256355);
      throw null;
    }
    localObject = new ArrayList();
    i = 0;
    while (this.abDx.iUf())
    {
      ((ArrayList)localObject).add(iUe());
      if (this.abDx.abDz != 4)
      {
        localf = this.abDx;
        if (localf.abDz != 9)
        {
          localf.iK("Expected end of the array or comma", localf.abDA);
          AppMethodBeat.o(256355);
          throw null;
        }
        i = 0;
      }
      else
      {
        this.abDx.iUj();
        i = 1;
      }
    }
    f localf = this.abDx;
    if (i == 0) {}
    for (i = j;; i = 0)
    {
      j = this.abDx.zrB;
      if (i != 0) {
        break;
      }
      localf.iK("Unexpected trailing comma", j);
      AppMethodBeat.o(256355);
      throw null;
    }
    this.abDx.iUj();
    localObject = (kotlinx.a.c.f)new b((List)localObject);
    AppMethodBeat.o(256355);
    return localObject;
  }
  
  public final kotlinx.a.c.f iUe()
  {
    AppMethodBeat.i(256358);
    if (!this.abDx.iUf())
    {
      f.a(this.abDx, "Can't begin reading value from here");
      AppMethodBeat.o(256358);
      throw null;
    }
    switch (this.abDx.abDz)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      f.a(this.abDx, "Can't begin reading element, unexpected token");
      AppMethodBeat.o(256358);
      throw null;
    case 10: 
      localObject = q.abDi;
      this.abDx.iUj();
      localObject = (kotlinx.a.c.f)localObject;
      AppMethodBeat.o(256358);
      return localObject;
    case 1: 
      localObject = JL(true);
      AppMethodBeat.o(256358);
      return localObject;
    case 0: 
      localObject = JL(false);
      AppMethodBeat.o(256358);
      return localObject;
    case 6: 
      localObject = iUc();
      AppMethodBeat.o(256358);
      return localObject;
    }
    Object localObject = iUd();
    AppMethodBeat.o(256358);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */