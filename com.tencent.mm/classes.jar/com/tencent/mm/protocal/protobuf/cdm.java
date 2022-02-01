package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cdm
  extends cqk
{
  public String EJP;
  public String EJQ;
  public dvk EJV;
  public String Fsm;
  public int pAG;
  public String pAH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91572);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EJQ != null) {
        paramVarArgs.d(2, this.EJQ);
      }
      paramVarArgs.aR(3, this.pAG);
      if (this.pAH != null) {
        paramVarArgs.d(4, this.pAH);
      }
      if (this.EJP != null) {
        paramVarArgs.d(5, this.EJP);
      }
      if (this.Fsm != null) {
        paramVarArgs.d(6, this.Fsm);
      }
      if (this.EJV != null)
      {
        paramVarArgs.ln(7, this.EJV.computeSize());
        this.EJV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EJQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EJQ);
      }
      i += f.a.a.b.b.a.bx(3, this.pAG);
      paramInt = i;
      if (this.pAH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pAH);
      }
      i = paramInt;
      if (this.EJP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EJP);
      }
      paramInt = i;
      if (this.Fsm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fsm);
      }
      i = paramInt;
      if (this.EJV != null) {
        i = paramInt + f.a.a.a.lm(7, this.EJV.computeSize());
      }
      AppMethodBeat.o(91572);
      return i;
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
          AppMethodBeat.o(91572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdm localcdm = (cdm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91572);
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
            localcdm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91572);
          return 0;
        case 2: 
          localcdm.EJQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 3: 
          localcdm.pAG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91572);
          return 0;
        case 4: 
          localcdm.pAH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 5: 
          localcdm.EJP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 6: 
          localcdm.Fsm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91572);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dvk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdm.EJV = ((dvk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91572);
        return 0;
      }
      AppMethodBeat.o(91572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdm
 * JD-Core Version:    0.7.0.1
 */