package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f;
import kotlinx.a.e.b;
import kotlinx.a.e.k;
import kotlinx.a.e.l;
import kotlinx.a.e.m;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/JsonParser;", "", "configuration", "Lkotlinx/serialization/json/internal/JsonConf;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/internal/JsonConf;Lkotlinx/serialization/json/internal/JsonReader;)V", "isLenient", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readObject", "readValue", "isString", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class d
{
  private final e ajEB;
  private final boolean ajEs;
  
  public d(c paramc, e parame)
  {
    AppMethodBeat.i(188517);
    this.ajEB = parame;
    this.ajEs = paramc.ajEs;
    AppMethodBeat.o(188517);
  }
  
  private final kotlinx.a.e.e PP(boolean paramBoolean)
  {
    AppMethodBeat.i(188507);
    if ((!this.ajEs) && (paramBoolean)) {}
    for (Object localObject = this.ajEB.kFJ();; localObject = this.ajEB.kFI())
    {
      localObject = (kotlinx.a.e.e)new k(localObject, paramBoolean);
      AppMethodBeat.o(188507);
      return localObject;
    }
  }
  
  private final kotlinx.a.e.e kFE()
  {
    int j = 1;
    AppMethodBeat.i(188483);
    Object localObject1 = this.ajEB;
    if (((e)localObject1).ajEC != 6)
    {
      ((e)localObject1).jV("Expected start of the object", ((e)localObject1).ajED);
      localObject1 = new f();
      AppMethodBeat.o(188483);
      throw ((Throwable)localObject1);
    }
    this.ajEB.kFK();
    localObject1 = this.ajEB;
    if (this.ajEB.ajEC != 4) {}
    for (int i = 1;; i = 0)
    {
      int k = this.ajEB.EuH;
      if (i != 0) {
        break;
      }
      ((e)localObject1).jV("Unexpected leading comma", k);
      localObject1 = new f();
      AppMethodBeat.o(188483);
      throw ((Throwable)localObject1);
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    i = 0;
    while (this.ajEB.kFH())
    {
      if (this.ajEs) {}
      for (localObject1 = this.ajEB.kFI();; localObject1 = this.ajEB.kFJ())
      {
        localObject2 = this.ajEB;
        if (((e)localObject2).ajEC == 5) {
          break;
        }
        ((e)localObject2).jV("Expected ':'", ((e)localObject2).ajED);
        localObject1 = new f();
        AppMethodBeat.o(188483);
        throw ((Throwable)localObject1);
      }
      this.ajEB.kFK();
      Object localObject2 = kFG();
      ((Map)localLinkedHashMap).put(localObject1, localObject2);
      if (this.ajEB.ajEC != 4)
      {
        localObject1 = this.ajEB;
        if (((e)localObject1).ajEC != 7)
        {
          ((e)localObject1).jV("Expected end of the object or comma", ((e)localObject1).ajED);
          localObject1 = new f();
          AppMethodBeat.o(188483);
          throw ((Throwable)localObject1);
        }
        i = 0;
      }
      else
      {
        this.ajEB.kFK();
        i = 1;
      }
    }
    localObject1 = this.ajEB;
    if ((i == 0) && (this.ajEB.ajEC == 7)) {}
    for (i = j;; i = 0)
    {
      j = this.ajEB.EuH;
      if (i != 0) {
        break;
      }
      ((e)localObject1).jV("Expected end of the object", j);
      localObject1 = new f();
      AppMethodBeat.o(188483);
      throw ((Throwable)localObject1);
    }
    this.ajEB.kFK();
    localObject1 = (kotlinx.a.e.e)new m((Map)localLinkedHashMap);
    AppMethodBeat.o(188483);
    return localObject1;
  }
  
  private final kotlinx.a.e.e kFF()
  {
    int j = 1;
    AppMethodBeat.i(188496);
    Object localObject = this.ajEB;
    if (((e)localObject).ajEC != 8)
    {
      ((e)localObject).jV("Expected start of the array", ((e)localObject).ajED);
      localObject = new f();
      AppMethodBeat.o(188496);
      throw ((Throwable)localObject);
    }
    this.ajEB.kFK();
    localObject = this.ajEB;
    if (this.ajEB.ajEC != 4) {}
    for (int i = 1;; i = 0)
    {
      int k = this.ajEB.EuH;
      if (i != 0) {
        break;
      }
      ((e)localObject).jV("Unexpected leading comma", k);
      localObject = new f();
      AppMethodBeat.o(188496);
      throw ((Throwable)localObject);
    }
    localObject = new ArrayList();
    i = 0;
    while (this.ajEB.kFH())
    {
      ((ArrayList)localObject).add(kFG());
      if (this.ajEB.ajEC != 4)
      {
        locale = this.ajEB;
        if (locale.ajEC != 9)
        {
          locale.jV("Expected end of the array or comma", locale.ajED);
          localObject = new f();
          AppMethodBeat.o(188496);
          throw ((Throwable)localObject);
        }
        i = 0;
      }
      else
      {
        this.ajEB.kFK();
        i = 1;
      }
    }
    e locale = this.ajEB;
    if (i == 0) {}
    for (i = j;; i = 0)
    {
      j = this.ajEB.EuH;
      if (i != 0) {
        break;
      }
      locale.jV("Unexpected trailing comma", j);
      localObject = new f();
      AppMethodBeat.o(188496);
      throw ((Throwable)localObject);
    }
    this.ajEB.kFK();
    localObject = (kotlinx.a.e.e)new b((List)localObject);
    AppMethodBeat.o(188496);
    return localObject;
  }
  
  public final kotlinx.a.e.e kFG()
  {
    AppMethodBeat.i(188533);
    if (!this.ajEB.kFH())
    {
      e.a(this.ajEB, "Can't begin reading value from here");
      localObject = new f();
      AppMethodBeat.o(188533);
      throw ((Throwable)localObject);
    }
    switch (this.ajEB.ajEC)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      e.a(this.ajEB, "Can't begin reading element, unexpected token");
      localObject = new f();
      AppMethodBeat.o(188533);
      throw ((Throwable)localObject);
    case 10: 
      localObject = l.ajEh;
      this.ajEB.kFK();
      localObject = (kotlinx.a.e.e)localObject;
      AppMethodBeat.o(188533);
      return localObject;
    case 1: 
      localObject = PP(true);
      AppMethodBeat.o(188533);
      return localObject;
    case 0: 
      localObject = PP(false);
      AppMethodBeat.o(188533);
      return localObject;
    case 6: 
      localObject = kFE();
      AppMethodBeat.o(188533);
      return localObject;
    }
    Object localObject = kFF();
    AppMethodBeat.o(188533);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.d
 * JD-Core Version:    0.7.0.1
 */