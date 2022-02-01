package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aga
  extends cqk
{
  public int Eyk;
  public int dae;
  public String oxf;
  public String pBl;
  public String uhB;
  public String uiY;
  public String uiZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      if (this.uhB != null) {
        paramVarArgs.d(4, this.uhB);
      }
      if (this.pBl != null) {
        paramVarArgs.d(5, this.pBl);
      }
      paramVarArgs.aR(6, this.Eyk);
      if (this.uiZ != null) {
        paramVarArgs.d(7, this.uiZ);
      }
      if (this.uiY != null) {
        paramVarArgs.d(8, this.uiY);
      }
      AppMethodBeat.o(91455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.uhB != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uhB);
      }
      paramInt = i;
      if (this.pBl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.pBl);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.Eyk);
      paramInt = i;
      if (this.uiZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.uiZ);
      }
      i = paramInt;
      if (this.uiY != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.uiY);
      }
      AppMethodBeat.o(91455);
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
          AppMethodBeat.o(91455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aga localaga = (aga)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91455);
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
            localaga.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91455);
          return 0;
        case 2: 
          localaga.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91455);
          return 0;
        case 3: 
          localaga.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 4: 
          localaga.uhB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 5: 
          localaga.pBl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 6: 
          localaga.Eyk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91455);
          return 0;
        case 7: 
          localaga.uiZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91455);
          return 0;
        }
        localaga.uiY = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91455);
        return 0;
      }
      AppMethodBeat.o(91455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aga
 * JD-Core Version:    0.7.0.1
 */