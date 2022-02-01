package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wr
  extends dpc
{
  public String Cpg;
  public String LhF;
  public String LhI;
  public String LhK;
  public String LhL;
  public String LhO;
  public String LhP;
  public String LhQ;
  public LinkedList<Integer> Lhn;
  public int Lhp;
  public String Lhz;
  public int dDN;
  public String desc;
  public String qwn;
  
  public wr()
  {
    AppMethodBeat.i(72440);
    this.Lhn = new LinkedList();
    AppMethodBeat.o(72440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72441);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.LhF != null) {
        paramVarArgs.e(4, this.LhF);
      }
      paramVarArgs.e(5, 2, this.Lhn);
      if (this.desc != null) {
        paramVarArgs.e(6, this.desc);
      }
      if (this.LhO != null) {
        paramVarArgs.e(7, this.LhO);
      }
      if (this.Cpg != null) {
        paramVarArgs.e(8, this.Cpg);
      }
      if (this.LhI != null) {
        paramVarArgs.e(9, this.LhI);
      }
      if (this.LhK != null) {
        paramVarArgs.e(10, this.LhK);
      }
      if (this.LhL != null) {
        paramVarArgs.e(11, this.LhL);
      }
      paramVarArgs.aM(12, this.Lhp);
      if (this.Lhz != null) {
        paramVarArgs.e(13, this.Lhz);
      }
      if (this.LhP != null) {
        paramVarArgs.e(14, this.LhP);
      }
      if (this.LhQ != null) {
        paramVarArgs.e(15, this.LhQ);
      }
      AppMethodBeat.o(72441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1189;
      }
    }
    label1189:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.LhF != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.LhF);
      }
      i += g.a.a.a.c(5, 2, this.Lhn);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.desc);
      }
      i = paramInt;
      if (this.LhO != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LhO);
      }
      paramInt = i;
      if (this.Cpg != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Cpg);
      }
      i = paramInt;
      if (this.LhI != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LhI);
      }
      paramInt = i;
      if (this.LhK != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LhK);
      }
      i = paramInt;
      if (this.LhL != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LhL);
      }
      i += g.a.a.b.b.a.bu(12, this.Lhp);
      paramInt = i;
      if (this.Lhz != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Lhz);
      }
      i = paramInt;
      if (this.LhP != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.LhP);
      }
      paramInt = i;
      if (this.LhQ != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.LhQ);
      }
      AppMethodBeat.o(72441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lhn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wr localwr = (wr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72441);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localwr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72441);
          return 0;
        case 2: 
          localwr.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72441);
          return 0;
        case 3: 
          localwr.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 4: 
          localwr.LhF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 5: 
          localwr.Lhn.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(72441);
          return 0;
        case 6: 
          localwr.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 7: 
          localwr.LhO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 8: 
          localwr.Cpg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 9: 
          localwr.LhI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 10: 
          localwr.LhK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 11: 
          localwr.LhL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 12: 
          localwr.Lhp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72441);
          return 0;
        case 13: 
          localwr.Lhz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 14: 
          localwr.LhP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72441);
          return 0;
        }
        localwr.LhQ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72441);
        return 0;
      }
      AppMethodBeat.o(72441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wr
 * JD-Core Version:    0.7.0.1
 */