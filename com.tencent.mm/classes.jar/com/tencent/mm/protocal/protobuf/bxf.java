package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxf
  extends esc
{
  public LinkedList<FinderContact> ZJH;
  public int aabV;
  public LinkedList<FinderContact> aabr;
  public gol aafS;
  public adx aagd;
  public aun aage;
  public int continueFlag;
  public LinkedList<auw> zMR;
  
  public bxf()
  {
    AppMethodBeat.i(169062);
    this.ZJH = new LinkedList();
    this.aabr = new LinkedList();
    this.zMR = new LinkedList();
    AppMethodBeat.o(169062);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169063);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aagd != null)
      {
        paramVarArgs.qD(2, this.aagd.computeSize());
        this.aagd.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.continueFlag);
      if (this.aafS != null)
      {
        paramVarArgs.qD(4, this.aafS.computeSize());
        this.aafS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.ZJH);
      paramVarArgs.e(6, 8, this.aabr);
      paramVarArgs.e(7, 8, this.zMR);
      paramVarArgs.bS(8, this.aabV);
      if (this.aage != null)
      {
        paramVarArgs.qD(9, this.aage.computeSize());
        this.aage.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169063);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1124;
      }
    }
    label1124:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aagd != null) {
        i = paramInt + i.a.a.a.qC(2, this.aagd.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.continueFlag);
      paramInt = i;
      if (this.aafS != null) {
        paramInt = i + i.a.a.a.qC(4, this.aafS.computeSize());
      }
      i = paramInt + i.a.a.a.c(5, 8, this.ZJH) + i.a.a.a.c(6, 8, this.aabr) + i.a.a.a.c(7, 8, this.zMR) + i.a.a.b.b.a.cJ(8, this.aabV);
      paramInt = i;
      if (this.aage != null) {
        paramInt = i + i.a.a.a.qC(9, this.aage.computeSize());
      }
      AppMethodBeat.o(169063);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZJH.clear();
        this.aabr.clear();
        this.zMR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169063);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bxf localbxf = (bxf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169063);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbxf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new adx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((adx)localObject2).parseFrom((byte[])localObject1);
            }
            localbxf.aagd = ((adx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 3: 
          localbxf.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169063);
          return 0;
        case 4: 
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
            localbxf.aafS = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbxf.ZJH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbxf.aabr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new auw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((auw)localObject2).parseFrom((byte[])localObject1);
            }
            localbxf.zMR.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 8: 
          localbxf.aabV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169063);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aun();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aun)localObject2).parseFrom((byte[])localObject1);
          }
          localbxf.aage = ((aun)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169063);
        return 0;
      }
      AppMethodBeat.o(169063);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxf
 * JD-Core Version:    0.7.0.1
 */