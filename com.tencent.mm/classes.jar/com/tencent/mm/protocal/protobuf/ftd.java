package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ftd
  extends erp
{
  public int abHt;
  public int abRl;
  public int abRm;
  public String abRn;
  public int abRo;
  public String abRp;
  public LinkedList<fha> abRq;
  public int abRr;
  public int abRs;
  public String abxv;
  public String hEl;
  public String hEr;
  public String nSt;
  
  public ftd()
  {
    AppMethodBeat.i(116818);
    this.abRq = new LinkedList();
    AppMethodBeat.o(116818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116819);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hEl != null) {
        paramVarArgs.g(2, this.hEl);
      }
      if (this.hEr != null) {
        paramVarArgs.g(3, this.hEr);
      }
      paramVarArgs.bS(4, this.abRl);
      paramVarArgs.bS(5, this.abRm);
      paramVarArgs.bS(6, this.abHt);
      if (this.abRn != null) {
        paramVarArgs.g(7, this.abRn);
      }
      if (this.abxv != null) {
        paramVarArgs.g(8, this.abxv);
      }
      if (this.nSt != null) {
        paramVarArgs.g(9, this.nSt);
      }
      paramVarArgs.bS(10, this.abRo);
      if (this.abRp != null) {
        paramVarArgs.g(11, this.abRp);
      }
      paramVarArgs.e(12, 8, this.abRq);
      paramVarArgs.bS(13, this.abRr);
      paramVarArgs.bS(14, this.abRs);
      AppMethodBeat.o(116819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1046;
      }
    }
    label1046:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hEl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hEl);
      }
      i = paramInt;
      if (this.hEr != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hEr);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.abRl) + i.a.a.b.b.a.cJ(5, this.abRm) + i.a.a.b.b.a.cJ(6, this.abHt);
      paramInt = i;
      if (this.abRn != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abRn);
      }
      i = paramInt;
      if (this.abxv != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abxv);
      }
      paramInt = i;
      if (this.nSt != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.nSt);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.abRo);
      paramInt = i;
      if (this.abRp != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.abRp);
      }
      i = i.a.a.a.c(12, 8, this.abRq);
      int j = i.a.a.b.b.a.cJ(13, this.abRr);
      int k = i.a.a.b.b.a.cJ(14, this.abRs);
      AppMethodBeat.o(116819);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abRq.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ftd localftd = (ftd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116819);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localftd.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 2: 
          localftd.hEl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 3: 
          localftd.hEr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 4: 
          localftd.abRl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(116819);
          return 0;
        case 5: 
          localftd.abRm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(116819);
          return 0;
        case 6: 
          localftd.abHt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(116819);
          return 0;
        case 7: 
          localftd.abRn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 8: 
          localftd.abxv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 9: 
          localftd.nSt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 10: 
          localftd.abRo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(116819);
          return 0;
        case 11: 
          localftd.abRp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fha();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fha)localObject2).parseFrom((byte[])localObject1);
            }
            localftd.abRq.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 13: 
          localftd.abRr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(116819);
          return 0;
        }
        localftd.abRs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(116819);
        return 0;
      }
      AppMethodBeat.o(116819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftd
 * JD-Core Version:    0.7.0.1
 */