package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class af
  extends cwj
{
  public boolean FJA;
  public int FJB;
  public int FJl;
  public String FJm;
  public dfd FJn;
  public ctm FJo;
  public int FJv;
  public abe FJz;
  
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FJl);
      if (this.FJm != null) {
        paramVarArgs.d(3, this.FJm);
      }
      if (this.FJn != null)
      {
        paramVarArgs.lJ(4, this.FJn.computeSize());
        this.FJn.writeFields(paramVarArgs);
      }
      if (this.FJo != null)
      {
        paramVarArgs.lJ(5, this.FJo.computeSize());
        this.FJo.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FJv);
      if (this.FJz != null)
      {
        paramVarArgs.lJ(7, this.FJz.computeSize());
        this.FJz.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(8, this.FJA);
      paramVarArgs.aS(9, this.FJB);
      AppMethodBeat.o(32100);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1081;
      }
    }
    label1081:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FJl);
      paramInt = i;
      if (this.FJm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FJm);
      }
      i = paramInt;
      if (this.FJn != null) {
        i = paramInt + f.a.a.a.lI(4, this.FJn.computeSize());
      }
      paramInt = i;
      if (this.FJo != null) {
        paramInt = i + f.a.a.a.lI(5, this.FJo.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FJv);
      paramInt = i;
      if (this.FJz != null) {
        paramInt = i + f.a.a.a.lI(7, this.FJz.computeSize());
      }
      i = f.a.a.b.b.a.amF(8);
      int j = f.a.a.b.b.a.bz(9, this.FJB);
      AppMethodBeat.o(32100);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 2: 
          localaf.FJl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32100);
          return 0;
        case 3: 
          localaf.FJm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32100);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.FJn = ((dfd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.FJo = ((ctm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 6: 
          localaf.FJv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32100);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.FJz = ((abe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 8: 
          localaf.FJA = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(32100);
          return 0;
        }
        localaf.FJB = ((f.a.a.a.a)localObject1).OmT.zc();
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