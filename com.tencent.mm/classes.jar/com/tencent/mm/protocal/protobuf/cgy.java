package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgy
  extends cqk
{
  public int DWU;
  public String DWV;
  public int EPY;
  public String EhR;
  public LinkedList<afb> FuZ;
  public LinkedList<az> Fva;
  public int Fvb;
  
  public cgy()
  {
    AppMethodBeat.i(91628);
    this.FuZ = new LinkedList();
    this.Fva = new LinkedList();
    AppMethodBeat.o(91628);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91629);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EPY);
      paramVarArgs.e(3, 8, this.FuZ);
      if (this.EhR != null) {
        paramVarArgs.d(4, this.EhR);
      }
      paramVarArgs.aR(5, this.DWU);
      if (this.DWV != null) {
        paramVarArgs.d(6, this.DWV);
      }
      paramVarArgs.e(7, 8, this.Fva);
      paramVarArgs.aR(8, this.Fvb);
      AppMethodBeat.o(91629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EPY) + f.a.a.a.c(3, 8, this.FuZ);
      paramInt = i;
      if (this.EhR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EhR);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.DWU);
      paramInt = i;
      if (this.DWV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DWV);
      }
      i = f.a.a.a.c(7, 8, this.Fva);
      int j = f.a.a.b.b.a.bx(8, this.Fvb);
      AppMethodBeat.o(91629);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FuZ.clear();
        this.Fva.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgy localcgy = (cgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91629);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 2: 
          localcgy.EPY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91629);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgy.FuZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 4: 
          localcgy.EhR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 5: 
          localcgy.DWU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91629);
          return 0;
        case 6: 
          localcgy.DWV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new az();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgy.Fva.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        }
        localcgy.Fvb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91629);
        return 0;
      }
      AppMethodBeat.o(91629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgy
 * JD-Core Version:    0.7.0.1
 */