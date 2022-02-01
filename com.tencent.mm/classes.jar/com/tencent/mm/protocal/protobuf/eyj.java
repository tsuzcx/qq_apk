package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyj
  extends erp
{
  public String IMg;
  public String IMh;
  public String YCm;
  public String YCn;
  public String YCo;
  public String YFJ;
  public String YHk;
  public String aaGn;
  public String aaGp;
  public int abzD;
  public int abzE;
  public int abzF;
  public int abzG;
  public String abzH;
  public String abzI;
  public int abzJ;
  public String abzK;
  public int abzL;
  public String abzM;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259237);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YHk != null) {
        paramVarArgs.g(2, this.YHk);
      }
      if (this.IMh != null) {
        paramVarArgs.g(3, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(4, this.IMg);
      }
      if (this.aaGn != null) {
        paramVarArgs.g(5, this.aaGn);
      }
      if (this.aaGp != null) {
        paramVarArgs.g(6, this.aaGp);
      }
      paramVarArgs.bS(7, this.abzD);
      paramVarArgs.bS(8, this.abzE);
      paramVarArgs.bS(9, this.abzF);
      paramVarArgs.bS(10, this.abzG);
      if (this.YFJ != null) {
        paramVarArgs.g(11, this.YFJ);
      }
      if (this.abzH != null) {
        paramVarArgs.g(12, this.abzH);
      }
      if (this.abzI != null) {
        paramVarArgs.g(13, this.abzI);
      }
      paramVarArgs.bS(14, this.abzJ);
      if (this.abzK != null) {
        paramVarArgs.g(15, this.abzK);
      }
      paramVarArgs.bS(16, this.abzL);
      if (this.oOI != null) {
        paramVarArgs.g(17, this.oOI);
      }
      if (this.YCo != null) {
        paramVarArgs.g(18, this.YCo);
      }
      if (this.YCn != null) {
        paramVarArgs.g(19, this.YCn);
      }
      if (this.YCm != null) {
        paramVarArgs.g(20, this.YCm);
      }
      if (this.abzM != null) {
        paramVarArgs.g(21, this.abzM);
      }
      AppMethodBeat.o(259237);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1416;
      }
    }
    label1416:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YHk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YHk);
      }
      i = paramInt;
      if (this.IMh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IMh);
      }
      paramInt = i;
      if (this.IMg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IMg);
      }
      i = paramInt;
      if (this.aaGn != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaGn);
      }
      paramInt = i;
      if (this.aaGp != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaGp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.abzD) + i.a.a.b.b.a.cJ(8, this.abzE) + i.a.a.b.b.a.cJ(9, this.abzF) + i.a.a.b.b.a.cJ(10, this.abzG);
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YFJ);
      }
      i = paramInt;
      if (this.abzH != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.abzH);
      }
      paramInt = i;
      if (this.abzI != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abzI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.abzJ);
      paramInt = i;
      if (this.abzK != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.abzK);
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.abzL);
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.oOI);
      }
      i = paramInt;
      if (this.YCo != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.YCo);
      }
      paramInt = i;
      if (this.YCn != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.YCn);
      }
      i = paramInt;
      if (this.YCm != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.YCm);
      }
      paramInt = i;
      if (this.abzM != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.abzM);
      }
      AppMethodBeat.o(259237);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259237);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eyj localeyj = (eyj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259237);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localeyj.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259237);
          return 0;
        case 2: 
          localeyj.YHk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 3: 
          localeyj.IMh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 4: 
          localeyj.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 5: 
          localeyj.aaGn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 6: 
          localeyj.aaGp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 7: 
          localeyj.abzD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259237);
          return 0;
        case 8: 
          localeyj.abzE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259237);
          return 0;
        case 9: 
          localeyj.abzF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259237);
          return 0;
        case 10: 
          localeyj.abzG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259237);
          return 0;
        case 11: 
          localeyj.YFJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 12: 
          localeyj.abzH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 13: 
          localeyj.abzI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 14: 
          localeyj.abzJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259237);
          return 0;
        case 15: 
          localeyj.abzK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 16: 
          localeyj.abzL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259237);
          return 0;
        case 17: 
          localeyj.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 18: 
          localeyj.YCo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 19: 
          localeyj.YCn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        case 20: 
          localeyj.YCm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259237);
          return 0;
        }
        localeyj.abzM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259237);
        return 0;
      }
      AppMethodBeat.o(259237);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyj
 * JD-Core Version:    0.7.0.1
 */