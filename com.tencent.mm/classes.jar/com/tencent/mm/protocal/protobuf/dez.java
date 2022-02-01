package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dez
  extends com.tencent.mm.bx.a
{
  public aft aaKU;
  public LinkedList<dfj> aaKV;
  public int eQp;
  public String hMi;
  
  public dez()
  {
    AppMethodBeat.i(258464);
    this.eQp = 0;
    this.aaKV = new LinkedList();
    AppMethodBeat.o(258464);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258468);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaKU == null)
      {
        paramVarArgs = new b("Not all required fields were included: idInfo");
        AppMethodBeat.o(258468);
        throw paramVarArgs;
      }
      if (this.aaKU != null)
      {
        paramVarArgs.qD(1, this.aaKU.computeSize());
        this.aaKU.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.eQp);
      if (this.hMi != null) {
        paramVarArgs.g(3, this.hMi);
      }
      paramVarArgs.e(4, 8, this.aaKV);
      AppMethodBeat.o(258468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaKU == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.a.qC(1, this.aaKU.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.eQp);
      paramInt = i;
      if (this.hMi != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hMi);
      }
      i = i.a.a.a.c(4, 8, this.aaKV);
      AppMethodBeat.o(258468);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaKV.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaKU == null)
        {
          paramVarArgs = new b("Not all required fields were included: idInfo");
          AppMethodBeat.o(258468);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dez localdez = (dez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258468);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aft();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aft)localObject2).parseFrom((byte[])localObject1);
            }
            localdez.aaKU = ((aft)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258468);
          return 0;
        case 2: 
          localdez.eQp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258468);
          return 0;
        case 3: 
          localdez.hMi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258468);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dfj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dfj)localObject2).parseFrom((byte[])localObject1);
          }
          localdez.aaKV.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258468);
        return 0;
      }
      AppMethodBeat.o(258468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dez
 * JD-Core Version:    0.7.0.1
 */