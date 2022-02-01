package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class esv
  extends com.tencent.mm.cd.a
{
  public LinkedList<aci> Pye;
  public String UuD;
  public String UuE;
  public String UuF;
  public String UuG;
  public long UuH;
  public esy UuI;
  public eij UuJ;
  public boolean UuK;
  public LinkedList<esy> UuL;
  public int UuM;
  public int UuN;
  public String UuO;
  public int UuP;
  public boolean UuQ;
  public String fwe;
  public boolean iYs;
  public String jQi;
  public int offset;
  public int scene;
  public String wmL;
  
  public esv()
  {
    AppMethodBeat.i(153006);
    this.Pye = new LinkedList();
    this.UuL = new LinkedList();
    AppMethodBeat.o(153006);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153007);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UuD != null) {
        paramVarArgs.f(1, this.UuD);
      }
      if (this.UuE != null) {
        paramVarArgs.f(2, this.UuE);
      }
      if (this.UuF != null) {
        paramVarArgs.f(3, this.UuF);
      }
      if (this.UuG != null) {
        paramVarArgs.f(4, this.UuG);
      }
      paramVarArgs.bm(5, this.UuH);
      paramVarArgs.aY(6, this.scene);
      if (this.jQi != null) {
        paramVarArgs.f(7, this.jQi);
      }
      if (this.fwe != null) {
        paramVarArgs.f(8, this.fwe);
      }
      if (this.UuI != null)
      {
        paramVarArgs.oE(9, this.UuI.computeSize());
        this.UuI.writeFields(paramVarArgs);
      }
      if (this.UuJ != null)
      {
        paramVarArgs.oE(10, this.UuJ.computeSize());
        this.UuJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.Pye);
      if (this.wmL != null) {
        paramVarArgs.f(12, this.wmL);
      }
      paramVarArgs.aY(13, this.offset);
      paramVarArgs.co(14, this.UuK);
      paramVarArgs.e(15, 8, this.UuL);
      paramVarArgs.aY(16, this.UuM);
      paramVarArgs.aY(17, this.UuN);
      paramVarArgs.co(18, this.iYs);
      if (this.UuO != null) {
        paramVarArgs.f(19, this.UuO);
      }
      paramVarArgs.aY(20, this.UuP);
      paramVarArgs.co(21, this.UuQ);
      AppMethodBeat.o(153007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UuD == null) {
        break label1550;
      }
    }
    label1550:
    for (int i = g.a.a.b.b.a.g(1, this.UuD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UuE != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UuE);
      }
      i = paramInt;
      if (this.UuF != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UuF);
      }
      paramInt = i;
      if (this.UuG != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UuG);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.UuH) + g.a.a.b.b.a.bM(6, this.scene);
      paramInt = i;
      if (this.jQi != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.jQi);
      }
      i = paramInt;
      if (this.fwe != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.fwe);
      }
      paramInt = i;
      if (this.UuI != null) {
        paramInt = i + g.a.a.a.oD(9, this.UuI.computeSize());
      }
      i = paramInt;
      if (this.UuJ != null) {
        i = paramInt + g.a.a.a.oD(10, this.UuJ.computeSize());
      }
      i += g.a.a.a.c(11, 8, this.Pye);
      paramInt = i;
      if (this.wmL != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.wmL);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.offset) + (g.a.a.b.b.a.gL(14) + 1) + g.a.a.a.c(15, 8, this.UuL) + g.a.a.b.b.a.bM(16, this.UuM) + g.a.a.b.b.a.bM(17, this.UuN) + (g.a.a.b.b.a.gL(18) + 1);
      paramInt = i;
      if (this.UuO != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.UuO);
      }
      i = g.a.a.b.b.a.bM(20, this.UuP);
      int j = g.a.a.b.b.a.gL(21);
      AppMethodBeat.o(153007);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Pye.clear();
        this.UuL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        esv localesv = (esv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153007);
          return -1;
        case 1: 
          localesv.UuD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 2: 
          localesv.UuE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 3: 
          localesv.UuF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 4: 
          localesv.UuG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 5: 
          localesv.UuH = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(153007);
          return 0;
        case 6: 
          localesv.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153007);
          return 0;
        case 7: 
          localesv.jQi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 8: 
          localesv.fwe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esy)localObject2).parseFrom((byte[])localObject1);
            }
            localesv.UuI = ((esy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eij();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eij)localObject2).parseFrom((byte[])localObject1);
            }
            localesv.UuJ = ((eij)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aci();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aci)localObject2).parseFrom((byte[])localObject1);
            }
            localesv.Pye.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 12: 
          localesv.wmL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 13: 
          localesv.offset = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153007);
          return 0;
        case 14: 
          localesv.UuK = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(153007);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esy)localObject2).parseFrom((byte[])localObject1);
            }
            localesv.UuL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 16: 
          localesv.UuM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153007);
          return 0;
        case 17: 
          localesv.UuN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153007);
          return 0;
        case 18: 
          localesv.iYs = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(153007);
          return 0;
        case 19: 
          localesv.UuO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 20: 
          localesv.UuP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153007);
          return 0;
        }
        localesv.UuQ = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(153007);
        return 0;
      }
      AppMethodBeat.o(153007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esv
 * JD-Core Version:    0.7.0.1
 */