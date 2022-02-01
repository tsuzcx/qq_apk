package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class doq
  extends dop
{
  public int Cjg;
  public String Cjt;
  public String Cju;
  public String KKI;
  public int KYp;
  public String MBV;
  public int MRP;
  public String MRQ;
  public int MRR;
  public int MRS;
  public b MRT;
  public String dDj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72581);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Cjt != null) {
        paramVarArgs.e(2, this.Cjt);
      }
      if (this.Cju != null) {
        paramVarArgs.e(3, this.Cju);
      }
      if (this.dDj != null) {
        paramVarArgs.e(4, this.dDj);
      }
      paramVarArgs.aM(5, this.Cjg);
      paramVarArgs.aM(6, this.MRP);
      if (this.MRQ != null) {
        paramVarArgs.e(7, this.MRQ);
      }
      paramVarArgs.aM(8, this.MRR);
      paramVarArgs.aM(9, this.MRS);
      if (this.KKI != null) {
        paramVarArgs.e(10, this.KKI);
      }
      if (this.MBV != null) {
        paramVarArgs.e(11, this.MBV);
      }
      if (this.MRT != null) {
        paramVarArgs.c(12, this.MRT);
      }
      paramVarArgs.aM(13, this.KYp);
      AppMethodBeat.o(72581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Cjt != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Cjt);
      }
      i = paramInt;
      if (this.Cju != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Cju);
      }
      paramInt = i;
      if (this.dDj != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dDj);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Cjg) + g.a.a.b.b.a.bu(6, this.MRP);
      paramInt = i;
      if (this.MRQ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MRQ);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.MRR) + g.a.a.b.b.a.bu(9, this.MRS);
      paramInt = i;
      if (this.KKI != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KKI);
      }
      i = paramInt;
      if (this.MBV != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.MBV);
      }
      paramInt = i;
      if (this.MRT != null) {
        paramInt = i + g.a.a.b.b.a.b(12, this.MRT);
      }
      i = g.a.a.b.b.a.bu(13, this.KYp);
      AppMethodBeat.o(72581);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        doq localdoq = (doq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72581);
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
            localdoq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72581);
          return 0;
        case 2: 
          localdoq.Cjt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 3: 
          localdoq.Cju = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 4: 
          localdoq.dDj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 5: 
          localdoq.Cjg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72581);
          return 0;
        case 6: 
          localdoq.MRP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72581);
          return 0;
        case 7: 
          localdoq.MRQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 8: 
          localdoq.MRR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72581);
          return 0;
        case 9: 
          localdoq.MRS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72581);
          return 0;
        case 10: 
          localdoq.KKI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 11: 
          localdoq.MBV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 12: 
          localdoq.MRT = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(72581);
          return 0;
        }
        localdoq.KYp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(72581);
        return 0;
      }
      AppMethodBeat.o(72581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doq
 * JD-Core Version:    0.7.0.1
 */