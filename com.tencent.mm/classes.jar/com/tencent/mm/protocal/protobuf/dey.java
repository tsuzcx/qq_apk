package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dey
  extends dyl
{
  public String OIl;
  public String RQs;
  public String RQt;
  public String TMA;
  public String TMB;
  public int TMC;
  public String TMD;
  public boolean TMz;
  public int fOu;
  public int fUN;
  public String fvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72530);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RQs != null) {
        paramVarArgs.f(2, this.RQs);
      }
      if (this.RQt != null) {
        paramVarArgs.f(3, this.RQt);
      }
      if (this.TMA != null) {
        paramVarArgs.f(4, this.TMA);
      }
      if (this.TMB != null) {
        paramVarArgs.f(5, this.TMB);
      }
      if (this.OIl != null) {
        paramVarArgs.f(6, this.OIl);
      }
      if (this.fvP != null) {
        paramVarArgs.f(7, this.fvP);
      }
      paramVarArgs.aY(8, this.fOu);
      paramVarArgs.aY(9, this.TMC);
      paramVarArgs.co(10, this.TMz);
      paramVarArgs.aY(11, this.fUN);
      if (this.TMD != null) {
        paramVarArgs.f(12, this.TMD);
      }
      AppMethodBeat.o(72530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label892;
      }
    }
    label892:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RQs != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RQs);
      }
      i = paramInt;
      if (this.RQt != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RQt);
      }
      paramInt = i;
      if (this.TMA != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TMA);
      }
      i = paramInt;
      if (this.TMB != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TMB);
      }
      paramInt = i;
      if (this.OIl != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.OIl);
      }
      i = paramInt;
      if (this.fvP != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.fvP);
      }
      i = i + g.a.a.b.b.a.bM(8, this.fOu) + g.a.a.b.b.a.bM(9, this.TMC) + (g.a.a.b.b.a.gL(10) + 1) + g.a.a.b.b.a.bM(11, this.fUN);
      paramInt = i;
      if (this.TMD != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TMD);
      }
      AppMethodBeat.o(72530);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72530);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dey localdey = (dey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72530);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdey.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72530);
          return 0;
        case 2: 
          localdey.RQs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 3: 
          localdey.RQt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 4: 
          localdey.TMA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 5: 
          localdey.TMB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 6: 
          localdey.OIl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 7: 
          localdey.fvP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 8: 
          localdey.fOu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72530);
          return 0;
        case 9: 
          localdey.TMC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72530);
          return 0;
        case 10: 
          localdey.TMz = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(72530);
          return 0;
        case 11: 
          localdey.fUN = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72530);
          return 0;
        }
        localdey.TMD = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72530);
        return 0;
      }
      AppMethodBeat.o(72530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dey
 * JD-Core Version:    0.7.0.1
 */