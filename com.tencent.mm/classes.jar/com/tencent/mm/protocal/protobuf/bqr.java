package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bqr
  extends esc
{
  public int BeA;
  public b ZEQ;
  public b ZIF;
  public bku ZKN;
  public int ZKX;
  public LinkedList<bna> ZYB;
  public boolean ZYC;
  public boolean ZYD;
  public boolean akhs;
  public int wrl;
  
  public bqr()
  {
    AppMethodBeat.i(257630);
    this.ZYB = new LinkedList();
    AppMethodBeat.o(257630);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257634);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZYB);
      if (this.ZKN != null)
      {
        paramVarArgs.qD(3, this.ZKN.computeSize());
        this.ZKN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.ZKX);
      if (this.ZIF != null) {
        paramVarArgs.d(5, this.ZIF);
      }
      paramVarArgs.bS(6, this.wrl);
      if (this.ZEQ != null) {
        paramVarArgs.d(7, this.ZEQ);
      }
      paramVarArgs.di(8, this.ZYC);
      paramVarArgs.di(9, this.ZYD);
      paramVarArgs.bS(11, this.BeA);
      paramVarArgs.di(12, this.akhs);
      AppMethodBeat.o(257634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label936;
      }
    }
    label936:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZYB);
      paramInt = i;
      if (this.ZKN != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZKN.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.ZKX);
      paramInt = i;
      if (this.ZIF != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.ZIF);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.wrl);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.ZEQ);
      }
      i = i.a.a.b.b.a.ko(8);
      int j = i.a.a.b.b.a.ko(9);
      int k = i.a.a.b.b.a.cJ(11, this.BeA);
      int m = i.a.a.b.b.a.ko(12);
      AppMethodBeat.o(257634);
      return paramInt + (i + 1) + (j + 1) + k + (m + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZYB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bqr localbqr = (bqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 10: 
        default: 
          AppMethodBeat.o(257634);
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
            localbqr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257634);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bna();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bna)localObject2).parseFrom((byte[])localObject1);
            }
            localbqr.ZYB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257634);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bku)localObject2).parseFrom((byte[])localObject1);
            }
            localbqr.ZKN = ((bku)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257634);
          return 0;
        case 4: 
          localbqr.ZKX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257634);
          return 0;
        case 5: 
          localbqr.ZIF = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257634);
          return 0;
        case 6: 
          localbqr.wrl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257634);
          return 0;
        case 7: 
          localbqr.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257634);
          return 0;
        case 8: 
          localbqr.ZYC = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257634);
          return 0;
        case 9: 
          localbqr.ZYD = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257634);
          return 0;
        case 11: 
          localbqr.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257634);
          return 0;
        }
        localbqr.akhs = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(257634);
        return 0;
      }
      AppMethodBeat.o(257634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqr
 * JD-Core Version:    0.7.0.1
 */