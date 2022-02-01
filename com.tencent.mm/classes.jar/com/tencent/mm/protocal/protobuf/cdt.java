package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdt
  extends com.tencent.mm.bx.a
{
  public yq DZW;
  public bpx DZY;
  public String doh;
  public String ntj;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.doh != null) {
        paramVarArgs.d(1, this.doh);
      }
      paramVarArgs.aR(2, this.type);
      if (this.ntj != null) {
        paramVarArgs.d(3, this.ntj);
      }
      if (this.DZY != null)
      {
        paramVarArgs.kX(4, this.DZY.computeSize());
        this.DZY.writeFields(paramVarArgs);
      }
      if (this.DZW != null)
      {
        paramVarArgs.kX(5, this.DZW.computeSize());
        this.DZW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.doh == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.b.b.a.e(1, this.doh) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.type);
      paramInt = i;
      if (this.ntj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ntj);
      }
      i = paramInt;
      if (this.DZY != null) {
        i = paramInt + f.a.a.a.kW(4, this.DZY.computeSize());
      }
      paramInt = i;
      if (this.DZW != null) {
        paramInt = i + f.a.a.a.kW(5, this.DZW.computeSize());
      }
      AppMethodBeat.o(195473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(195473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdt localcdt = (cdt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195473);
          return -1;
        case 1: 
          localcdt.doh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195473);
          return 0;
        case 2: 
          localcdt.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(195473);
          return 0;
        case 3: 
          localcdt.ntj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195473);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdt.DZY = ((bpx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195473);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdt.DZW = ((yq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195473);
        return 0;
      }
      AppMethodBeat.o(195473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdt
 * JD-Core Version:    0.7.0.1
 */