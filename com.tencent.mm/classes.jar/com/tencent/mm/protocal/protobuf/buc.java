package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buc
  extends dop
{
  public int MaL;
  public int MaM;
  public vf MaN;
  public aat MaO;
  public int MaP;
  public long clK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50089);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MaL);
      paramVarArgs.aM(3, this.MaM);
      if (this.MaN != null)
      {
        paramVarArgs.ni(4, this.MaN.computeSize());
        this.MaN.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(5, this.clK);
      if (this.MaO != null)
      {
        paramVarArgs.ni(6, this.MaO.computeSize());
        this.MaO.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.MaP);
      AppMethodBeat.o(50089);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MaL) + g.a.a.b.b.a.bu(3, this.MaM);
      paramInt = i;
      if (this.MaN != null) {
        paramInt = i + g.a.a.a.nh(4, this.MaN.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.clK);
      paramInt = i;
      if (this.MaO != null) {
        paramInt = i + g.a.a.a.nh(6, this.MaO.computeSize());
      }
      i = g.a.a.b.b.a.bu(7, this.MaP);
      AppMethodBeat.o(50089);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(50089);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        buc localbuc = (buc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50089);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuc.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 2: 
          localbuc.MaL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(50089);
          return 0;
        case 3: 
          localbuc.MaM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(50089);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuc.MaN = ((vf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 5: 
          localbuc.clK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(50089);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aat();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuc.MaO = ((aat)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        }
        localbuc.MaP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(50089);
        return 0;
      }
      AppMethodBeat.o(50089);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buc
 * JD-Core Version:    0.7.0.1
 */