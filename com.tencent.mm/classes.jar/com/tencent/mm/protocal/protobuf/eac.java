package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eac
  extends com.tencent.mm.bx.a
{
  public String LWN;
  public amh NZv;
  public fxy Zbl;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258594);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.LWN == null)
      {
        paramVarArgs = new b("Not all required fields were included: pagPath");
        AppMethodBeat.o(258594);
        throw paramVarArgs;
      }
      if (this.Zbl == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(258594);
        throw paramVarArgs;
      }
      if (this.LWN != null) {
        paramVarArgs.g(1, this.LWN);
      }
      if (this.text != null) {
        paramVarArgs.g(2, this.text);
      }
      if (this.Zbl != null)
      {
        paramVarArgs.qD(3, this.Zbl.computeSize());
        this.Zbl.writeFields(paramVarArgs);
      }
      if (this.NZv != null)
      {
        paramVarArgs.qD(4, this.NZv.computeSize());
        this.NZv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258594);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LWN == null) {
        break label634;
      }
    }
    label634:
    for (int i = i.a.a.b.b.a.h(1, this.LWN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.text != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.text);
      }
      i = paramInt;
      if (this.Zbl != null) {
        i = paramInt + i.a.a.a.qC(3, this.Zbl.computeSize());
      }
      paramInt = i;
      if (this.NZv != null) {
        paramInt = i + i.a.a.a.qC(4, this.NZv.computeSize());
      }
      AppMethodBeat.o(258594);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.LWN == null)
        {
          paramVarArgs = new b("Not all required fields were included: pagPath");
          AppMethodBeat.o(258594);
          throw paramVarArgs;
        }
        if (this.Zbl == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(258594);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258594);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eac localeac = (eac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258594);
          return -1;
        case 1: 
          localeac.LWN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258594);
          return 0;
        case 2: 
          localeac.text = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258594);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxy)localObject2).parseFrom((byte[])localObject1);
            }
            localeac.Zbl = ((fxy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258594);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new amh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((amh)localObject2).parseFrom((byte[])localObject1);
          }
          localeac.NZv = ((amh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258594);
        return 0;
      }
      AppMethodBeat.o(258594);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eac
 * JD-Core Version:    0.7.0.1
 */