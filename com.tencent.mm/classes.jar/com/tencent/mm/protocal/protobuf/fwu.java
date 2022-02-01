package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fwu
  extends erp
{
  public int YKH;
  public gol YKa;
  public gol YKb;
  public String aayW;
  public LinkedList<fwr> abUA;
  public int abUB;
  public LinkedList<Integer> abUC;
  public int abUD;
  public LinkedList<fwt> abUE;
  public int abUF;
  public String abUG;
  public int abUz;
  
  public fwu()
  {
    AppMethodBeat.i(152726);
    this.abUA = new LinkedList();
    this.abUC = new LinkedList();
    this.abUE = new LinkedList();
    AppMethodBeat.o(152726);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152727);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YKH);
      paramVarArgs.bS(3, this.abUz);
      paramVarArgs.e(4, 8, this.abUA);
      if (this.aayW != null) {
        paramVarArgs.g(5, this.aayW);
      }
      paramVarArgs.bS(6, this.abUB);
      paramVarArgs.f(7, 2, this.abUC);
      paramVarArgs.bS(8, this.abUD);
      paramVarArgs.e(9, 8, this.abUE);
      if (this.YKa != null)
      {
        paramVarArgs.qD(10, this.YKa.computeSize());
        this.YKa.writeFields(paramVarArgs);
      }
      if (this.YKb != null)
      {
        paramVarArgs.qD(11, this.YKb.computeSize());
        this.YKb.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.abUF);
      if (this.abUG != null) {
        paramVarArgs.g(13, this.abUG);
      }
      AppMethodBeat.o(152727);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1203;
      }
    }
    label1203:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YKH) + i.a.a.b.b.a.cJ(3, this.abUz) + i.a.a.a.c(4, 8, this.abUA);
      paramInt = i;
      if (this.aayW != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aayW);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abUB) + i.a.a.a.d(7, 2, this.abUC) + i.a.a.b.b.a.cJ(8, this.abUD) + i.a.a.a.c(9, 8, this.abUE);
      paramInt = i;
      if (this.YKa != null) {
        paramInt = i + i.a.a.a.qC(10, this.YKa.computeSize());
      }
      i = paramInt;
      if (this.YKb != null) {
        i = paramInt + i.a.a.a.qC(11, this.YKb.computeSize());
      }
      i += i.a.a.b.b.a.cJ(12, this.abUF);
      paramInt = i;
      if (this.abUG != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abUG);
      }
      AppMethodBeat.o(152727);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abUA.clear();
        this.abUC.clear();
        this.abUE.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152727);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fwu localfwu = (fwu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152727);
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
            localfwu.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 2: 
          localfwu.YKH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152727);
          return 0;
        case 3: 
          localfwu.abUz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152727);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fwr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fwr)localObject2).parseFrom((byte[])localObject1);
            }
            localfwu.abUA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 5: 
          localfwu.aayW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152727);
          return 0;
        case 6: 
          localfwu.abUB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152727);
          return 0;
        case 7: 
          localfwu.abUC = new i.a.a.a.a(((i.a.a.a.a)localObject1).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
          AppMethodBeat.o(152727);
          return 0;
        case 8: 
          localfwu.abUD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152727);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fwt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fwt)localObject2).parseFrom((byte[])localObject1);
            }
            localfwu.abUE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfwu.YKa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfwu.YKb = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 12: 
          localfwu.abUF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152727);
          return 0;
        }
        localfwu.abUG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(152727);
        return 0;
      }
      AppMethodBeat.o(152727);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fwu
 * JD-Core Version:    0.7.0.1
 */