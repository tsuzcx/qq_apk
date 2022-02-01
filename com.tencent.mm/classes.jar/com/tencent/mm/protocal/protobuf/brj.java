package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class brj
  extends cwj
{
  public String FVY;
  public String GpD;
  public String GpE;
  public String GpF;
  public String GpG;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.GpD != null) {
        paramVarArgs.d(3, this.GpD);
      }
      if (this.FVY != null) {
        paramVarArgs.d(4, this.FVY);
      }
      if (this.GpE != null) {
        paramVarArgs.d(5, this.GpE);
      }
      if (this.GpF != null) {
        paramVarArgs.d(6, this.GpF);
      }
      if (this.GpG != null) {
        paramVarArgs.d(7, this.GpG);
      }
      AppMethodBeat.o(82437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.GpD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GpD);
      }
      paramInt = i;
      if (this.FVY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FVY);
      }
      i = paramInt;
      if (this.GpE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GpE);
      }
      paramInt = i;
      if (this.GpF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GpF);
      }
      i = paramInt;
      if (this.GpG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GpG);
      }
      AppMethodBeat.o(82437);
      return i;
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
          AppMethodBeat.o(82437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brj localbrj = (brj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82437);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82437);
          return 0;
        case 2: 
          localbrj.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 3: 
          localbrj.GpD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 4: 
          localbrj.FVY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 5: 
          localbrj.GpE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 6: 
          localbrj.GpF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82437);
          return 0;
        }
        localbrj.GpG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82437);
        return 0;
      }
      AppMethodBeat.o(82437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brj
 * JD-Core Version:    0.7.0.1
 */