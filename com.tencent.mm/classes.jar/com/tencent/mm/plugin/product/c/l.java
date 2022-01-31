package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class l
  extends com.tencent.mm.bv.a
{
  public int puy;
  public String pvc;
  public int pvd;
  public LinkedList<e> pve;
  public String url;
  
  public l()
  {
    AppMethodBeat.i(56635);
    this.pve = new LinkedList();
    AppMethodBeat.o(56635);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56636);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pvc == null)
      {
        paramVarArgs = new b("Not all required fields were included: id_info");
        AppMethodBeat.o(56636);
        throw paramVarArgs;
      }
      if (this.pvc != null) {
        paramVarArgs.e(1, this.pvc);
      }
      paramVarArgs.aO(2, this.pvd);
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      paramVarArgs.e(4, 8, this.pve);
      paramVarArgs.aO(5, this.puy);
      AppMethodBeat.o(56636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pvc == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = e.a.a.b.b.a.f(1, this.pvc) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pvd);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.url);
      }
      i = e.a.a.a.c(4, 8, this.pve);
      int j = e.a.a.b.b.a.bl(5, this.puy);
      AppMethodBeat.o(56636);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pve.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pvc == null)
        {
          paramVarArgs = new b("Not all required fields were included: id_info");
          AppMethodBeat.o(56636);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56636);
          return -1;
        case 1: 
          locall.pvc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56636);
          return 0;
        case 2: 
          locall.pvd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56636);
          return 0;
        case 3: 
          locall.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56636);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locall.pve.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56636);
          return 0;
        }
        locall.puy = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56636);
        return 0;
      }
      AppMethodBeat.o(56636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.l
 * JD-Core Version:    0.7.0.1
 */