package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgb
  extends dop
{
  public String HWx;
  public int HuF;
  public String HuS;
  public String MJh;
  public int MKM;
  public int MKN;
  public int MKO;
  public String Mnk;
  public String Mnl;
  public String dDj;
  public int yba;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Mnl != null) {
        paramVarArgs.e(2, this.Mnl);
      }
      paramVarArgs.aM(3, this.MKM);
      paramVarArgs.aM(4, this.yba);
      if (this.Mnk != null) {
        paramVarArgs.e(5, this.Mnk);
      }
      if (this.MJh != null) {
        paramVarArgs.e(7, this.MJh);
      }
      paramVarArgs.aM(8, this.HuF);
      if (this.dDj != null) {
        paramVarArgs.e(9, this.dDj);
      }
      if (this.HWx != null) {
        paramVarArgs.e(10, this.HWx);
      }
      paramVarArgs.aM(11, this.MKN);
      paramVarArgs.aM(12, this.MKO);
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label946;
      }
    }
    label946:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Mnl != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Mnl);
      }
      i = i + g.a.a.b.b.a.bu(3, this.MKM) + g.a.a.b.b.a.bu(4, this.yba);
      paramInt = i;
      if (this.Mnk != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Mnk);
      }
      i = paramInt;
      if (this.MJh != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MJh);
      }
      i += g.a.a.b.b.a.bu(8, this.HuF);
      paramInt = i;
      if (this.dDj != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.dDj);
      }
      i = paramInt;
      if (this.HWx != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.HWx);
      }
      i = i + g.a.a.b.b.a.bu(11, this.MKN) + g.a.a.b.b.a.bu(12, this.MKO);
      paramInt = i;
      if (this.HuS != null) {
        paramInt = i + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dgb localdgb = (dgb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91636);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdgb.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91636);
          return 0;
        case 2: 
          localdgb.Mnl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 3: 
          localdgb.MKM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91636);
          return 0;
        case 4: 
          localdgb.yba = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91636);
          return 0;
        case 5: 
          localdgb.Mnk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 7: 
          localdgb.MJh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 8: 
          localdgb.HuF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91636);
          return 0;
        case 9: 
          localdgb.dDj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 10: 
          localdgb.HWx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 11: 
          localdgb.MKN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91636);
          return 0;
        case 12: 
          localdgb.MKO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91636);
          return 0;
        }
        localdgb.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91636);
        return 0;
      }
      AppMethodBeat.o(91636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgb
 * JD-Core Version:    0.7.0.1
 */