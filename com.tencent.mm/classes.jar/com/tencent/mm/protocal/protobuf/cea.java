package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cea
  extends cqk
{
  public String EJP;
  public String EJQ;
  public String FsE;
  public int pAG;
  public String pAH;
  public String thh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91584);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91584);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EJP != null) {
        paramVarArgs.d(2, this.EJP);
      }
      if (this.thh != null) {
        paramVarArgs.d(3, this.thh);
      }
      if (this.EJQ != null) {
        paramVarArgs.d(4, this.EJQ);
      }
      paramVarArgs.aR(5, this.pAG);
      if (this.pAH != null) {
        paramVarArgs.d(6, this.pAH);
      }
      if (this.FsE != null) {
        paramVarArgs.d(7, this.FsE);
      }
      AppMethodBeat.o(91584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EJP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EJP);
      }
      i = paramInt;
      if (this.thh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thh);
      }
      paramInt = i;
      if (this.EJQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EJQ);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.pAG);
      paramInt = i;
      if (this.pAH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.pAH);
      }
      i = paramInt;
      if (this.FsE != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FsE);
      }
      AppMethodBeat.o(91584);
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
          AppMethodBeat.o(91584);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91584);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cea localcea = (cea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91584);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcea.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91584);
          return 0;
        case 2: 
          localcea.EJP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91584);
          return 0;
        case 3: 
          localcea.thh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91584);
          return 0;
        case 4: 
          localcea.EJQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91584);
          return 0;
        case 5: 
          localcea.pAG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91584);
          return 0;
        case 6: 
          localcea.pAH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91584);
          return 0;
        }
        localcea.FsE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91584);
        return 0;
      }
      AppMethodBeat.o(91584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cea
 * JD-Core Version:    0.7.0.1
 */