package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aze
  extends cqk
{
  public com.tencent.mm.bw.b EQB;
  public LinkedList<bqf> EQD;
  public int EQE;
  public LinkedList<String> EQF;
  public int EQG;
  public boolean EQH;
  public bqc EQI;
  
  public aze()
  {
    AppMethodBeat.i(190861);
    this.EQD = new LinkedList();
    this.EQF = new LinkedList();
    AppMethodBeat.o(190861);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190862);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(190862);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.EQD);
      if (this.EQB != null) {
        paramVarArgs.c(3, this.EQB);
      }
      paramVarArgs.aR(4, this.EQE);
      paramVarArgs.e(5, 1, this.EQF);
      paramVarArgs.aR(6, this.EQG);
      paramVarArgs.bl(7, this.EQH);
      if (this.EQI != null)
      {
        paramVarArgs.ln(8, this.EQI.computeSize());
        this.EQI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(190862);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.EQD);
      paramInt = i;
      if (this.EQB != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.EQB);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.EQE) + f.a.a.a.c(5, 1, this.EQF) + f.a.a.b.b.a.bx(6, this.EQG) + (f.a.a.b.b.a.fK(7) + 1);
      paramInt = i;
      if (this.EQI != null) {
        paramInt = i + f.a.a.a.lm(8, this.EQI.computeSize());
      }
      AppMethodBeat.o(190862);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EQD.clear();
        this.EQF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(190862);
          throw paramVarArgs;
        }
        AppMethodBeat.o(190862);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aze localaze = (aze)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190862);
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
            localaze.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190862);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaze.EQD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190862);
          return 0;
        case 3: 
          localaze.EQB = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(190862);
          return 0;
        case 4: 
          localaze.EQE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(190862);
          return 0;
        case 5: 
          localaze.EQF.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(190862);
          return 0;
        case 6: 
          localaze.EQG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(190862);
          return 0;
        case 7: 
          localaze.EQH = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(190862);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaze.EQI = ((bqc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(190862);
        return 0;
      }
      AppMethodBeat.o(190862);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aze
 * JD-Core Version:    0.7.0.1
 */