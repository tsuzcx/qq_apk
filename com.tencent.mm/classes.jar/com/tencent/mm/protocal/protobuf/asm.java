package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asm
  extends cqk
{
  public LinkedList<String> ELT;
  public String ELU;
  public String oGS;
  public String title;
  
  public asm()
  {
    AppMethodBeat.i(181502);
    this.ELT = new LinkedList();
    AppMethodBeat.o(181502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181503);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.oGS != null) {
        paramVarArgs.d(2, this.oGS);
      }
      paramVarArgs.e(3, 1, this.ELT);
      if (this.ELU != null) {
        paramVarArgs.d(4, this.ELU);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      AppMethodBeat.o(181503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oGS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oGS);
      }
      i += f.a.a.a.c(3, 1, this.ELT);
      paramInt = i;
      if (this.ELU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ELU);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      AppMethodBeat.o(181503);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ELT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(181503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asm localasm = (asm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181503);
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
            localasm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(181503);
          return 0;
        case 2: 
          localasm.oGS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(181503);
          return 0;
        case 3: 
          localasm.ELT.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(181503);
          return 0;
        case 4: 
          localasm.ELU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(181503);
          return 0;
        }
        localasm.title = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(181503);
        return 0;
      }
      AppMethodBeat.o(181503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asm
 * JD-Core Version:    0.7.0.1
 */