package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dze
  extends dop
{
  public long Id;
  public dmo KHJ;
  public SKBuiltinBuffer_t MYJ;
  public SKBuiltinBuffer_t MYK;
  public int MYL;
  public int Scene;
  public int xub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125766);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.Id);
      paramVarArgs.aM(3, this.Scene);
      if (this.MYJ != null)
      {
        paramVarArgs.ni(4, this.MYJ.computeSize());
        this.MYJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.xub);
      if (this.MYK != null)
      {
        paramVarArgs.ni(6, this.MYK.computeSize());
        this.MYK.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.MYL);
      if (this.KHJ != null)
      {
        paramVarArgs.ni(8, this.KHJ.computeSize());
        this.KHJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.Id) + g.a.a.b.b.a.bu(3, this.Scene);
      paramInt = i;
      if (this.MYJ != null) {
        paramInt = i + g.a.a.a.nh(4, this.MYJ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.xub);
      paramInt = i;
      if (this.MYK != null) {
        paramInt = i + g.a.a.a.nh(6, this.MYK.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.MYL);
      paramInt = i;
      if (this.KHJ != null) {
        paramInt = i + g.a.a.a.nh(8, this.KHJ.computeSize());
      }
      AppMethodBeat.o(125766);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dze localdze = (dze)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125766);
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
            localdze.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 2: 
          localdze.Id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125766);
          return 0;
        case 3: 
          localdze.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125766);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdze.MYJ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 5: 
          localdze.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125766);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdze.MYK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 7: 
          localdze.MYL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125766);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdze.KHJ = ((dmo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      AppMethodBeat.o(125766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dze
 * JD-Core Version:    0.7.0.1
 */