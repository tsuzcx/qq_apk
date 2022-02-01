package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class deb
  extends dop
{
  public String HuS;
  public int MJd;
  public int MJe;
  public ja MJf;
  public int MJg;
  public String MJh;
  public int yba;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91624);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MJd);
      paramVarArgs.aM(3, this.MJe);
      if (this.MJf != null)
      {
        paramVarArgs.ni(4, this.MJf.computeSize());
        this.MJf.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.yba);
      paramVarArgs.aM(6, this.MJg);
      if (this.MJh != null) {
        paramVarArgs.e(7, this.MJh);
      }
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MJd) + g.a.a.b.b.a.bu(3, this.MJe);
      paramInt = i;
      if (this.MJf != null) {
        paramInt = i + g.a.a.a.nh(4, this.MJf.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.yba) + g.a.a.b.b.a.bu(6, this.MJg);
      paramInt = i;
      if (this.MJh != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MJh);
      }
      i = paramInt;
      if (this.HuS != null) {
        i = paramInt + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91624);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        deb localdeb = (deb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91624);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdeb.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 2: 
          localdeb.MJd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91624);
          return 0;
        case 3: 
          localdeb.MJe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91624);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ja();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ja)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdeb.MJf = ((ja)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 5: 
          localdeb.yba = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91624);
          return 0;
        case 6: 
          localdeb.MJg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91624);
          return 0;
        case 7: 
          localdeb.MJh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91624);
          return 0;
        }
        localdeb.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91624);
        return 0;
      }
      AppMethodBeat.o(91624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deb
 * JD-Core Version:    0.7.0.1
 */