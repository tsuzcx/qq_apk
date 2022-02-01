package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class af
  extends cld
{
  public int CtB;
  public yb CtF;
  public boolean CtG;
  public int CtH;
  public int Ctr;
  public String Cts;
  public ctl Ctt;
  public cij Ctu;
  
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Ctr);
      if (this.Cts != null) {
        paramVarArgs.d(3, this.Cts);
      }
      if (this.Ctt != null)
      {
        paramVarArgs.kX(4, this.Ctt.computeSize());
        this.Ctt.writeFields(paramVarArgs);
      }
      if (this.Ctu != null)
      {
        paramVarArgs.kX(5, this.Ctu.computeSize());
        this.Ctu.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.CtB);
      if (this.CtF != null)
      {
        paramVarArgs.kX(7, this.CtF.computeSize());
        this.CtF.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(8, this.CtG);
      paramVarArgs.aR(9, this.CtH);
      AppMethodBeat.o(32100);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1081;
      }
    }
    label1081:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Ctr);
      paramInt = i;
      if (this.Cts != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Cts);
      }
      i = paramInt;
      if (this.Ctt != null) {
        i = paramInt + f.a.a.a.kW(4, this.Ctt.computeSize());
      }
      paramInt = i;
      if (this.Ctu != null) {
        paramInt = i + f.a.a.a.kW(5, this.Ctu.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.CtB);
      paramInt = i;
      if (this.CtF != null) {
        paramInt = i + f.a.a.a.kW(7, this.CtF.computeSize());
      }
      i = f.a.a.b.b.a.fY(8);
      int j = f.a.a.b.b.a.bA(9, this.CtH);
      AppMethodBeat.o(32100);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 2: 
          localaf.Ctr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32100);
          return 0;
        case 3: 
          localaf.Cts = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32100);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.Ctt = ((ctl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cij();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.Ctu = ((cij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 6: 
          localaf.CtB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32100);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.CtF = ((yb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 8: 
          localaf.CtG = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(32100);
          return 0;
        }
        localaf.CtH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32100);
        return 0;
      }
      AppMethodBeat.o(32100);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.af
 * JD-Core Version:    0.7.0.1
 */