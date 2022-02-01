package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bzt
  extends ckq
{
  public int CPd;
  public az CPi;
  public int Ctl;
  public String DWw;
  public String DWx;
  public b DWy;
  public int DWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91598);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DWw != null) {
        paramVarArgs.d(2, this.DWw);
      }
      if (this.DWx != null) {
        paramVarArgs.d(3, this.DWx);
      }
      if (this.DWy != null) {
        paramVarArgs.c(4, this.DWy);
      }
      paramVarArgs.aR(5, this.CPd);
      paramVarArgs.aR(6, this.Ctl);
      paramVarArgs.aR(7, this.DWz);
      if (this.CPi != null)
      {
        paramVarArgs.kX(8, this.CPi.computeSize());
        this.CPi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DWw);
      }
      i = paramInt;
      if (this.DWx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DWx);
      }
      paramInt = i;
      if (this.DWy != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.DWy);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CPd) + f.a.a.b.b.a.bA(6, this.Ctl) + f.a.a.b.b.a.bA(7, this.DWz);
      paramInt = i;
      if (this.CPi != null) {
        paramInt = i + f.a.a.a.kW(8, this.CPi.computeSize());
      }
      AppMethodBeat.o(91598);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzt localbzt = (bzt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91598);
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
            localbzt.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91598);
          return 0;
        case 2: 
          localbzt.DWw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 3: 
          localbzt.DWx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 4: 
          localbzt.DWy = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(91598);
          return 0;
        case 5: 
          localbzt.CPd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91598);
          return 0;
        case 6: 
          localbzt.Ctl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91598);
          return 0;
        case 7: 
          localbzt.DWz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91598);
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
          localbzt.CPi = ((az)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      AppMethodBeat.o(91598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzt
 * JD-Core Version:    0.7.0.1
 */