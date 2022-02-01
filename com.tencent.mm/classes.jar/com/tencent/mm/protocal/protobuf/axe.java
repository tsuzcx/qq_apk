package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axe
  extends cwj
{
  public int GOB;
  public String GOC;
  public String GOD;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.aS(4, this.GOB);
      if (this.GOC != null) {
        paramVarArgs.d(5, this.GOC);
      }
      if (this.GOD != null) {
        paramVarArgs.d(6, this.GOD);
      }
      AppMethodBeat.o(91476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GOB);
      paramInt = i;
      if (this.GOC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GOC);
      }
      i = paramInt;
      if (this.GOD != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GOD);
      }
      AppMethodBeat.o(91476);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axe localaxe = (axe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91476);
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
            localaxe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91476);
          return 0;
        case 2: 
          localaxe.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91476);
          return 0;
        case 3: 
          localaxe.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91476);
          return 0;
        case 4: 
          localaxe.GOB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91476);
          return 0;
        case 5: 
          localaxe.GOC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91476);
          return 0;
        }
        localaxe.GOD = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91476);
        return 0;
      }
      AppMethodBeat.o(91476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axe
 * JD-Core Version:    0.7.0.1
 */