package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdg
  extends cqk
{
  public String FhW;
  public dfo FrS;
  public LinkedList<ps> FrT;
  public String FrU;
  public String FrV;
  public String FrW;
  public dfo FrX;
  public String FrY;
  
  public cdg()
  {
    AppMethodBeat.i(117890);
    this.FrT = new LinkedList();
    AppMethodBeat.o(117890);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117891);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FhW != null) {
        paramVarArgs.d(2, this.FhW);
      }
      if (this.FrS != null)
      {
        paramVarArgs.ln(3, this.FrS.computeSize());
        this.FrS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.FrT);
      if (this.FrU != null) {
        paramVarArgs.d(5, this.FrU);
      }
      if (this.FrV != null) {
        paramVarArgs.d(6, this.FrV);
      }
      if (this.FrW != null) {
        paramVarArgs.d(7, this.FrW);
      }
      if (this.FrX != null)
      {
        paramVarArgs.ln(8, this.FrX.computeSize());
        this.FrX.writeFields(paramVarArgs);
      }
      if (this.FrY != null) {
        paramVarArgs.d(9, this.FrY);
      }
      AppMethodBeat.o(117891);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FhW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FhW);
      }
      i = paramInt;
      if (this.FrS != null) {
        i = paramInt + f.a.a.a.lm(3, this.FrS.computeSize());
      }
      i += f.a.a.a.c(4, 8, this.FrT);
      paramInt = i;
      if (this.FrU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FrU);
      }
      i = paramInt;
      if (this.FrV != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FrV);
      }
      paramInt = i;
      if (this.FrW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FrW);
      }
      i = paramInt;
      if (this.FrX != null) {
        i = paramInt + f.a.a.a.lm(8, this.FrX.computeSize());
      }
      paramInt = i;
      if (this.FrY != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FrY);
      }
      AppMethodBeat.o(117891);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FrT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117891);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdg localcdg = (cdg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117891);
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
            localcdg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 2: 
          localcdg.FhW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdg.FrS = ((dfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ps();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ps)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdg.FrT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 5: 
          localcdg.FrU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 6: 
          localcdg.FrV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 7: 
          localcdg.FrW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdg.FrX = ((dfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        }
        localcdg.FrY = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117891);
        return 0;
      }
      AppMethodBeat.o(117891);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdg
 * JD-Core Version:    0.7.0.1
 */