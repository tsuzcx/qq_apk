package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bff
  extends cqk
{
  public int EUA;
  public LinkedList<crm> EUB;
  public String EUC;
  public int EUD;
  public String EUE;
  public int EUF;
  public SKBuiltinBuffer_t EUG;
  public int EUw;
  public String EUx;
  public int EUy;
  public String EUz;
  
  public bff()
  {
    AppMethodBeat.i(152605);
    this.EUB = new LinkedList();
    AppMethodBeat.o(152605);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152606);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152606);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EUw);
      if (this.EUx != null) {
        paramVarArgs.d(3, this.EUx);
      }
      paramVarArgs.aR(4, this.EUy);
      if (this.EUz != null) {
        paramVarArgs.d(5, this.EUz);
      }
      paramVarArgs.aR(6, this.EUA);
      paramVarArgs.e(7, 8, this.EUB);
      if (this.EUC != null) {
        paramVarArgs.d(8, this.EUC);
      }
      paramVarArgs.aR(9, this.EUD);
      if (this.EUE != null) {
        paramVarArgs.d(10, this.EUE);
      }
      paramVarArgs.aR(11, this.EUF);
      if (this.EUG != null)
      {
        paramVarArgs.ln(12, this.EUG.computeSize());
        this.EUG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EUw);
      paramInt = i;
      if (this.EUx != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EUx);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.EUy);
      paramInt = i;
      if (this.EUz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EUz);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.EUA) + f.a.a.a.c(7, 8, this.EUB);
      paramInt = i;
      if (this.EUC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EUC);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.EUD);
      paramInt = i;
      if (this.EUE != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.EUE);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.EUF);
      paramInt = i;
      if (this.EUG != null) {
        paramInt = i + f.a.a.a.lm(12, this.EUG.computeSize());
      }
      AppMethodBeat.o(152606);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EUB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152606);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bff localbff = (bff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152606);
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
            localbff.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 2: 
          localbff.EUw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152606);
          return 0;
        case 3: 
          localbff.EUx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 4: 
          localbff.EUy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152606);
          return 0;
        case 5: 
          localbff.EUz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 6: 
          localbff.EUA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152606);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbff.EUB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 8: 
          localbff.EUC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 9: 
          localbff.EUD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152606);
          return 0;
        case 10: 
          localbff.EUE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 11: 
          localbff.EUF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152606);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbff.EUG = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      AppMethodBeat.o(152606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bff
 * JD-Core Version:    0.7.0.1
 */