package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avp
  extends cqk
{
  public LinkedList<oi> DSZ;
  public int DTN;
  public long ELn;
  public int ENH;
  public int EfS;
  public int EfV;
  
  public avp()
  {
    AppMethodBeat.i(117869);
    this.DSZ = new LinkedList();
    AppMethodBeat.o(117869);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117870);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.DSZ);
      paramVarArgs.aR(3, this.EfS);
      paramVarArgs.aR(4, this.ENH);
      paramVarArgs.aR(5, this.DTN);
      paramVarArgs.aO(6, this.ELn);
      paramVarArgs.aR(7, this.EfV);
      AppMethodBeat.o(117870);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.DSZ);
      int j = f.a.a.b.b.a.bx(3, this.EfS);
      int k = f.a.a.b.b.a.bx(4, this.ENH);
      int m = f.a.a.b.b.a.bx(5, this.DTN);
      int n = f.a.a.b.b.a.p(6, this.ELn);
      int i1 = f.a.a.b.b.a.bx(7, this.EfV);
      AppMethodBeat.o(117870);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DSZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117870);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avp localavp = (avp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117870);
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
            localavp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavp.DSZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 3: 
          localavp.EfS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117870);
          return 0;
        case 4: 
          localavp.ENH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117870);
          return 0;
        case 5: 
          localavp.DTN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117870);
          return 0;
        case 6: 
          localavp.ELn = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(117870);
          return 0;
        }
        localavp.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117870);
        return 0;
      }
      AppMethodBeat.o(117870);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avp
 * JD-Core Version:    0.7.0.1
 */