package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejs
  extends dpc
{
  public dju LgT;
  public int NiZ;
  public dmp Nja;
  public String dQx;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72589);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      if (this.LgT != null)
      {
        paramVarArgs.ni(4, this.LgT.computeSize());
        this.LgT.writeFields(paramVarArgs);
      }
      if (this.Nja != null)
      {
        paramVarArgs.ni(5, this.Nja.computeSize());
        this.Nja.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.NiZ);
      if (this.dQx != null) {
        paramVarArgs.e(7, this.dQx);
      }
      AppMethodBeat.o(72589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.LgT != null) {
        i = paramInt + g.a.a.a.nh(4, this.LgT.computeSize());
      }
      paramInt = i;
      if (this.Nja != null) {
        paramInt = i + g.a.a.a.nh(5, this.Nja.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.NiZ);
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.dQx);
      }
      AppMethodBeat.o(72589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ejs localejs = (ejs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72589);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localejs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 2: 
          localejs.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72589);
          return 0;
        case 3: 
          localejs.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72589);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dju();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dju)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localejs.LgT = ((dju)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localejs.Nja = ((dmp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 6: 
          localejs.NiZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72589);
          return 0;
        }
        localejs.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72589);
        return 0;
      }
      AppMethodBeat.o(72589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejs
 * JD-Core Version:    0.7.0.1
 */