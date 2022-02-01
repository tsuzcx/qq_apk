package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ffl
  extends erp
{
  public gol abCX;
  public int abCZ;
  public String abDu;
  public long abDv;
  public long abEV;
  public int abEW;
  public long abEX;
  public int abEY;
  public LinkedList<Long> abEZ;
  public int abFa;
  public int abFb;
  public long abFc;
  public long abFd;
  public long abFe;
  public int abFf;
  public long abFg;
  public gol abFh;
  
  public ffl()
  {
    AppMethodBeat.i(125826);
    this.abEZ = new LinkedList();
    AppMethodBeat.o(125826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125827);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abDu != null) {
        paramVarArgs.g(2, this.abDu);
      }
      paramVarArgs.bv(3, this.abDv);
      paramVarArgs.bv(4, this.abEV);
      paramVarArgs.bS(5, this.abEW);
      paramVarArgs.bv(6, this.abEX);
      if (this.abCX != null)
      {
        paramVarArgs.qD(7, this.abCX.computeSize());
        this.abCX.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.abCZ);
      paramVarArgs.bS(11, this.abEY);
      paramVarArgs.f(12, 3, this.abEZ);
      paramVarArgs.bS(13, this.abFa);
      paramVarArgs.bS(14, this.abFb);
      paramVarArgs.bv(15, this.abFc);
      paramVarArgs.bv(16, this.abFd);
      paramVarArgs.bv(17, this.abFe);
      paramVarArgs.bS(18, this.abFf);
      paramVarArgs.bv(19, this.abFg);
      if (this.abFh != null)
      {
        paramVarArgs.qD(20, this.abFh.computeSize());
        this.abFh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1267;
      }
    }
    label1267:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abDu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abDu);
      }
      i = i + i.a.a.b.b.a.q(3, this.abDv) + i.a.a.b.b.a.q(4, this.abEV) + i.a.a.b.b.a.cJ(5, this.abEW) + i.a.a.b.b.a.q(6, this.abEX);
      paramInt = i;
      if (this.abCX != null) {
        paramInt = i + i.a.a.a.qC(7, this.abCX.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.abCZ) + i.a.a.b.b.a.cJ(11, this.abEY) + i.a.a.a.d(12, 3, this.abEZ) + i.a.a.b.b.a.cJ(13, this.abFa) + i.a.a.b.b.a.cJ(14, this.abFb) + i.a.a.b.b.a.q(15, this.abFc) + i.a.a.b.b.a.q(16, this.abFd) + i.a.a.b.b.a.q(17, this.abFe) + i.a.a.b.b.a.cJ(18, this.abFf) + i.a.a.b.b.a.q(19, this.abFg);
      paramInt = i;
      if (this.abFh != null) {
        paramInt = i + i.a.a.a.qC(20, this.abFh.computeSize());
      }
      AppMethodBeat.o(125827);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abEZ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ffl localffl = (ffl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(125827);
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
            localffl.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 2: 
          localffl.abDu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125827);
          return 0;
        case 3: 
          localffl.abDv = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125827);
          return 0;
        case 4: 
          localffl.abEV = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125827);
          return 0;
        case 5: 
          localffl.abEW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125827);
          return 0;
        case 6: 
          localffl.abEX = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125827);
          return 0;
        case 7: 
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
            localffl.abCX = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 8: 
          localffl.abCZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125827);
          return 0;
        case 11: 
          localffl.abEY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125827);
          return 0;
        case 12: 
          localffl.abEZ = new i.a.a.a.a(((i.a.a.a.a)localObject1).ajGk.kFX().Op, unknownTagHandler).ajGk.kFW();
          AppMethodBeat.o(125827);
          return 0;
        case 13: 
          localffl.abFa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125827);
          return 0;
        case 14: 
          localffl.abFb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125827);
          return 0;
        case 15: 
          localffl.abFc = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125827);
          return 0;
        case 16: 
          localffl.abFd = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125827);
          return 0;
        case 17: 
          localffl.abFe = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125827);
          return 0;
        case 18: 
          localffl.abFf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125827);
          return 0;
        case 19: 
          localffl.abFg = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125827);
          return 0;
        }
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
          localffl.abFh = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125827);
        return 0;
      }
      AppMethodBeat.o(125827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffl
 * JD-Core Version:    0.7.0.1
 */