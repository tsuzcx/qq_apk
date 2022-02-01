package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class clh
  extends com.tencent.mm.cd.a
{
  public int ELb;
  public String SoN;
  public b TsI;
  public b TsJ;
  public int TsM;
  public b TsN;
  public int TsO;
  public clh TsP;
  public clh TsQ;
  public int dataType;
  public int ddx;
  public boolean isPatch;
  public int lNK;
  public int lZN;
  public String md5;
  public String name;
  public String path;
  public String smT;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209467);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TsM);
      paramVarArgs.aY(2, this.dataType);
      paramVarArgs.aY(3, this.lZN);
      if (this.name != null) {
        paramVarArgs.f(4, this.name);
      }
      paramVarArgs.aY(5, this.version);
      paramVarArgs.aY(6, this.ddx);
      if (this.TsI != null) {
        paramVarArgs.c(7, this.TsI);
      }
      if (this.smT != null) {
        paramVarArgs.f(8, this.smT);
      }
      if (this.TsJ != null) {
        paramVarArgs.c(9, this.TsJ);
      }
      if (this.md5 != null) {
        paramVarArgs.f(10, this.md5);
      }
      if (this.TsN != null) {
        paramVarArgs.c(11, this.TsN);
      }
      if (this.path != null) {
        paramVarArgs.f(12, this.path);
      }
      paramVarArgs.aY(13, this.ELb);
      paramVarArgs.aY(14, this.lNK);
      if (this.SoN != null) {
        paramVarArgs.f(15, this.SoN);
      }
      paramVarArgs.aY(16, this.TsO);
      if (this.TsP != null)
      {
        paramVarArgs.oE(17, this.TsP.computeSize());
        this.TsP.writeFields(paramVarArgs);
      }
      paramVarArgs.co(18, this.isPatch);
      if (this.TsQ != null)
      {
        paramVarArgs.oE(19, this.TsQ.computeSize());
        this.TsQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TsM) + 0 + g.a.a.b.b.a.bM(2, this.dataType) + g.a.a.b.b.a.bM(3, this.lZN);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.name);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.version) + g.a.a.b.b.a.bM(6, this.ddx);
      paramInt = i;
      if (this.TsI != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.TsI);
      }
      i = paramInt;
      if (this.smT != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.smT);
      }
      paramInt = i;
      if (this.TsJ != null) {
        paramInt = i + g.a.a.b.b.a.b(9, this.TsJ);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.md5);
      }
      paramInt = i;
      if (this.TsN != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.TsN);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.path);
      }
      i = i + g.a.a.b.b.a.bM(13, this.ELb) + g.a.a.b.b.a.bM(14, this.lNK);
      paramInt = i;
      if (this.SoN != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.SoN);
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.TsO);
      paramInt = i;
      if (this.TsP != null) {
        paramInt = i + g.a.a.a.oD(17, this.TsP.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.gL(18) + 1);
      paramInt = i;
      if (this.TsQ != null) {
        paramInt = i + g.a.a.a.oD(19, this.TsQ.computeSize());
      }
      AppMethodBeat.o(209467);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(209467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      clh localclh1 = (clh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      clh localclh2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209467);
        return -1;
      case 1: 
        localclh1.TsM = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(209467);
        return 0;
      case 2: 
        localclh1.dataType = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(209467);
        return 0;
      case 3: 
        localclh1.lZN = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(209467);
        return 0;
      case 4: 
        localclh1.name = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(209467);
        return 0;
      case 5: 
        localclh1.version = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(209467);
        return 0;
      case 6: 
        localclh1.ddx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(209467);
        return 0;
      case 7: 
        localclh1.TsI = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(209467);
        return 0;
      case 8: 
        localclh1.smT = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(209467);
        return 0;
      case 9: 
        localclh1.TsJ = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(209467);
        return 0;
      case 10: 
        localclh1.md5 = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(209467);
        return 0;
      case 11: 
        localclh1.TsN = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(209467);
        return 0;
      case 12: 
        localclh1.path = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(209467);
        return 0;
      case 13: 
        localclh1.ELb = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(209467);
        return 0;
      case 14: 
        localclh1.lNK = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(209467);
        return 0;
      case 15: 
        localclh1.SoN = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(209467);
        return 0;
      case 16: 
        localclh1.TsO = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(209467);
        return 0;
      case 17: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localclh2 = new clh();
          if ((localObject != null) && (localObject.length > 0)) {
            localclh2.parseFrom((byte[])localObject);
          }
          localclh1.TsP = localclh2;
          paramInt += 1;
        }
        AppMethodBeat.o(209467);
        return 0;
      case 18: 
        localclh1.isPatch = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(209467);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localclh2 = new clh();
        if ((localObject != null) && (localObject.length > 0)) {
          localclh2.parseFrom((byte[])localObject);
        }
        localclh1.TsQ = localclh2;
        paramInt += 1;
      }
      AppMethodBeat.o(209467);
      return 0;
    }
    AppMethodBeat.o(209467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clh
 * JD-Core Version:    0.7.0.1
 */