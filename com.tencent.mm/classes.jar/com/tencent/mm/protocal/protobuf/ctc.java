package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctc
  extends com.tencent.mm.cd.a
{
  public String TAJ;
  public boolean TAK;
  public ij TAL;
  public String TAM;
  public boolean TAN;
  public int TAO;
  public String TAP;
  public int TAQ;
  public ery TAR;
  public acs TAS;
  public String TAT;
  public String TAU;
  public LinkedList<vm> Tbw;
  
  public ctc()
  {
    AppMethodBeat.i(91533);
    this.Tbw = new LinkedList();
    AppMethodBeat.o(91533);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91534);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TAJ != null) {
        paramVarArgs.f(1, this.TAJ);
      }
      paramVarArgs.e(2, 8, this.Tbw);
      paramVarArgs.co(3, this.TAK);
      if (this.TAL != null)
      {
        paramVarArgs.oE(4, this.TAL.computeSize());
        this.TAL.writeFields(paramVarArgs);
      }
      if (this.TAM != null) {
        paramVarArgs.f(5, this.TAM);
      }
      paramVarArgs.co(6, this.TAN);
      paramVarArgs.aY(7, this.TAO);
      if (this.TAP != null) {
        paramVarArgs.f(8, this.TAP);
      }
      paramVarArgs.aY(9, this.TAQ);
      if (this.TAR != null)
      {
        paramVarArgs.oE(10, this.TAR.computeSize());
        this.TAR.writeFields(paramVarArgs);
      }
      if (this.TAS != null)
      {
        paramVarArgs.oE(11, this.TAS.computeSize());
        this.TAS.writeFields(paramVarArgs);
      }
      if (this.TAT != null) {
        paramVarArgs.f(12, this.TAT);
      }
      if (this.TAU != null) {
        paramVarArgs.f(13, this.TAU);
      }
      AppMethodBeat.o(91534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TAJ == null) {
        break label1154;
      }
    }
    label1154:
    for (paramInt = g.a.a.b.b.a.g(1, this.TAJ) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Tbw) + (g.a.a.b.b.a.gL(3) + 1);
      paramInt = i;
      if (this.TAL != null) {
        paramInt = i + g.a.a.a.oD(4, this.TAL.computeSize());
      }
      i = paramInt;
      if (this.TAM != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TAM);
      }
      i = i + (g.a.a.b.b.a.gL(6) + 1) + g.a.a.b.b.a.bM(7, this.TAO);
      paramInt = i;
      if (this.TAP != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TAP);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.TAQ);
      paramInt = i;
      if (this.TAR != null) {
        paramInt = i + g.a.a.a.oD(10, this.TAR.computeSize());
      }
      i = paramInt;
      if (this.TAS != null) {
        i = paramInt + g.a.a.a.oD(11, this.TAS.computeSize());
      }
      paramInt = i;
      if (this.TAT != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TAT);
      }
      i = paramInt;
      if (this.TAU != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.TAU);
      }
      AppMethodBeat.o(91534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tbw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ctc localctc = (ctc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91534);
          return -1;
        case 1: 
          localctc.TAJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vm)localObject2).parseFrom((byte[])localObject1);
            }
            localctc.Tbw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 3: 
          localctc.TAK = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91534);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ij();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ij)localObject2).parseFrom((byte[])localObject1);
            }
            localctc.TAL = ((ij)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 5: 
          localctc.TAM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 6: 
          localctc.TAN = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91534);
          return 0;
        case 7: 
          localctc.TAO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91534);
          return 0;
        case 8: 
          localctc.TAP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 9: 
          localctc.TAQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91534);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ery();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ery)localObject2).parseFrom((byte[])localObject1);
            }
            localctc.TAR = ((ery)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acs)localObject2).parseFrom((byte[])localObject1);
            }
            localctc.TAS = ((acs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 12: 
          localctc.TAT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91534);
          return 0;
        }
        localctc.TAU = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91534);
        return 0;
      }
      AppMethodBeat.o(91534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctc
 * JD-Core Version:    0.7.0.1
 */