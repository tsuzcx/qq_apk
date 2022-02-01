package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class af
  extends cqk
{
  public int DLI;
  public String DLJ;
  public cyw DLK;
  public cnp DLL;
  public int DLS;
  public yw DLW;
  public boolean DLX;
  public int DLY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32100);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32100);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DLI);
      if (this.DLJ != null) {
        paramVarArgs.d(3, this.DLJ);
      }
      if (this.DLK != null)
      {
        paramVarArgs.ln(4, this.DLK.computeSize());
        this.DLK.writeFields(paramVarArgs);
      }
      if (this.DLL != null)
      {
        paramVarArgs.ln(5, this.DLL.computeSize());
        this.DLL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.DLS);
      if (this.DLW != null)
      {
        paramVarArgs.ln(7, this.DLW.computeSize());
        this.DLW.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(8, this.DLX);
      paramVarArgs.aR(9, this.DLY);
      AppMethodBeat.o(32100);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1081;
      }
    }
    label1081:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DLI);
      paramInt = i;
      if (this.DLJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DLJ);
      }
      i = paramInt;
      if (this.DLK != null) {
        i = paramInt + f.a.a.a.lm(4, this.DLK.computeSize());
      }
      paramInt = i;
      if (this.DLL != null) {
        paramInt = i + f.a.a.a.lm(5, this.DLL.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.DLS);
      paramInt = i;
      if (this.DLW != null) {
        paramInt = i + f.a.a.a.lm(7, this.DLW.computeSize());
      }
      i = f.a.a.b.b.a.fK(8);
      int j = f.a.a.b.b.a.bx(9, this.DLY);
      AppMethodBeat.o(32100);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32100);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32100);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        af localaf = (af)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32100);
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
            localaf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 2: 
          localaf.DLI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32100);
          return 0;
        case 3: 
          localaf.DLJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32100);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.DLK = ((cyw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.DLL = ((cnp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 6: 
          localaf.DLS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32100);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.DLW = ((yw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 8: 
          localaf.DLX = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(32100);
          return 0;
        }
        localaf.DLY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32100);
        return 0;
      }
      AppMethodBeat.o(32100);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.af
 * JD-Core Version:    0.7.0.1
 */