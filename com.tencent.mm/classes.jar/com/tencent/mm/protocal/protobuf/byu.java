package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byu
  extends ckq
{
  public az CPi;
  public int DVC;
  public String uoY;
  public int upf;
  public String upq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91575);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DVC);
      if (this.uoY != null) {
        paramVarArgs.d(3, this.uoY);
      }
      paramVarArgs.aR(4, this.upf);
      if (this.upq != null) {
        paramVarArgs.d(5, this.upq);
      }
      if (this.CPi != null)
      {
        paramVarArgs.kX(6, this.CPi.computeSize());
        this.CPi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DVC);
      paramInt = i;
      if (this.uoY != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uoY);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.upf);
      paramInt = i;
      if (this.upq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.upq);
      }
      i = paramInt;
      if (this.CPi != null) {
        i = paramInt + f.a.a.a.kW(6, this.CPi.computeSize());
      }
      AppMethodBeat.o(91575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byu localbyu = (byu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91575);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyu.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91575);
          return 0;
        case 2: 
          localbyu.DVC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91575);
          return 0;
        case 3: 
          localbyu.uoY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91575);
          return 0;
        case 4: 
          localbyu.upf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91575);
          return 0;
        case 5: 
          localbyu.upq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91575);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new az();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyu.CPi = ((az)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      AppMethodBeat.o(91575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byu
 * JD-Core Version:    0.7.0.1
 */