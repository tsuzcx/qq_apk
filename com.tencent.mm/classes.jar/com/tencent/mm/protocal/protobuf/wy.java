package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class wy
  extends cwj
{
  public ehl GoD;
  public boolean GoE;
  public String GoF;
  public String GoG;
  public boolean GoH;
  public String GoI;
  public String GoJ;
  public String GoK;
  public String GoL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GoD != null)
      {
        paramVarArgs.lJ(2, this.GoD.computeSize());
        this.GoD.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(3, this.GoE);
      if (this.GoF != null) {
        paramVarArgs.d(4, this.GoF);
      }
      if (this.GoG != null) {
        paramVarArgs.d(5, this.GoG);
      }
      paramVarArgs.bC(6, this.GoH);
      if (this.GoI != null) {
        paramVarArgs.d(7, this.GoI);
      }
      if (this.GoJ != null) {
        paramVarArgs.d(8, this.GoJ);
      }
      if (this.GoK != null) {
        paramVarArgs.d(9, this.GoK);
      }
      if (this.GoL != null) {
        paramVarArgs.d(10, this.GoL);
      }
      AppMethodBeat.o(123562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GoD != null) {
        i = paramInt + f.a.a.a.lI(2, this.GoD.computeSize());
      }
      i += f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.GoF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GoF);
      }
      i = paramInt;
      if (this.GoG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GoG);
      }
      i += f.a.a.b.b.a.amF(6);
      paramInt = i;
      if (this.GoI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GoI);
      }
      i = paramInt;
      if (this.GoJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GoJ);
      }
      paramInt = i;
      if (this.GoK != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GoK);
      }
      i = paramInt;
      if (this.GoL != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GoL);
      }
      AppMethodBeat.o(123562);
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
          AppMethodBeat.o(123562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wy localwy = (wy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123562);
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
            localwy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwy.GoD = ((ehl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 3: 
          localwy.GoE = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(123562);
          return 0;
        case 4: 
          localwy.GoF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 5: 
          localwy.GoG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 6: 
          localwy.GoH = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(123562);
          return 0;
        case 7: 
          localwy.GoI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 8: 
          localwy.GoJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 9: 
          localwy.GoK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123562);
          return 0;
        }
        localwy.GoL = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123562);
        return 0;
      }
      AppMethodBeat.o(123562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wy
 * JD-Core Version:    0.7.0.1
 */