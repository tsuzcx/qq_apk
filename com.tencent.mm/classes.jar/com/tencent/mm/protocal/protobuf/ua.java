package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ua
  extends com.tencent.mm.bw.a
{
  public String KDM;
  public String LcO;
  public String LcP;
  public String LcQ;
  public String LcR;
  public String LcS;
  public LinkedList<tz> LcT;
  public int LcU;
  public String LcV;
  public String LcW;
  public String LcX;
  public int LcY;
  public String LcZ;
  public int Lda;
  public String Ldb;
  public int Ldc;
  public String Ldd;
  public un Lde;
  public String Ldf;
  public String Ldg;
  
  public ua()
  {
    AppMethodBeat.i(113951);
    this.LcT = new LinkedList();
    AppMethodBeat.o(113951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113952);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KDM != null) {
        paramVarArgs.e(1, this.KDM);
      }
      if (this.LcO != null) {
        paramVarArgs.e(2, this.LcO);
      }
      if (this.LcP != null) {
        paramVarArgs.e(3, this.LcP);
      }
      if (this.LcQ != null) {
        paramVarArgs.e(4, this.LcQ);
      }
      if (this.LcR != null) {
        paramVarArgs.e(5, this.LcR);
      }
      if (this.LcS != null) {
        paramVarArgs.e(6, this.LcS);
      }
      paramVarArgs.e(7, 8, this.LcT);
      paramVarArgs.aM(8, this.LcU);
      if (this.LcV != null) {
        paramVarArgs.e(9, this.LcV);
      }
      if (this.LcW != null) {
        paramVarArgs.e(10, this.LcW);
      }
      if (this.LcX != null) {
        paramVarArgs.e(11, this.LcX);
      }
      paramVarArgs.aM(12, this.LcY);
      if (this.LcZ != null) {
        paramVarArgs.e(13, this.LcZ);
      }
      paramVarArgs.aM(14, this.Lda);
      if (this.Ldb != null) {
        paramVarArgs.e(15, this.Ldb);
      }
      paramVarArgs.aM(16, this.Ldc);
      if (this.Ldd != null) {
        paramVarArgs.e(17, this.Ldd);
      }
      if (this.Lde != null)
      {
        paramVarArgs.ni(18, this.Lde.computeSize());
        this.Lde.writeFields(paramVarArgs);
      }
      if (this.Ldf != null) {
        paramVarArgs.e(19, this.Ldf);
      }
      if (this.Ldg != null) {
        paramVarArgs.e(20, this.Ldg);
      }
      AppMethodBeat.o(113952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KDM == null) {
        break label1494;
      }
    }
    label1494:
    for (int i = g.a.a.b.b.a.f(1, this.KDM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LcO != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LcO);
      }
      i = paramInt;
      if (this.LcP != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LcP);
      }
      paramInt = i;
      if (this.LcQ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LcQ);
      }
      i = paramInt;
      if (this.LcR != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LcR);
      }
      paramInt = i;
      if (this.LcS != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LcS);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.LcT) + g.a.a.b.b.a.bu(8, this.LcU);
      paramInt = i;
      if (this.LcV != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LcV);
      }
      i = paramInt;
      if (this.LcW != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.LcW);
      }
      paramInt = i;
      if (this.LcX != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LcX);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.LcY);
      paramInt = i;
      if (this.LcZ != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.LcZ);
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.Lda);
      paramInt = i;
      if (this.Ldb != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.Ldb);
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.Ldc);
      paramInt = i;
      if (this.Ldd != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.Ldd);
      }
      i = paramInt;
      if (this.Lde != null) {
        i = paramInt + g.a.a.a.nh(18, this.Lde.computeSize());
      }
      paramInt = i;
      if (this.Ldf != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.Ldf);
      }
      i = paramInt;
      if (this.Ldg != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.Ldg);
      }
      AppMethodBeat.o(113952);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LcT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113952);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ua localua = (ua)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113952);
          return -1;
        case 1: 
          localua.KDM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 2: 
          localua.LcO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 3: 
          localua.LcP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 4: 
          localua.LcQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 5: 
          localua.LcR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 6: 
          localua.LcS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localua.LcT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        case 8: 
          localua.LcU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113952);
          return 0;
        case 9: 
          localua.LcV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 10: 
          localua.LcW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 11: 
          localua.LcX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 12: 
          localua.LcY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113952);
          return 0;
        case 13: 
          localua.LcZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 14: 
          localua.Lda = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113952);
          return 0;
        case 15: 
          localua.Ldb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 16: 
          localua.Ldc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113952);
          return 0;
        case 17: 
          localua.Ldd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localua.Lde = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        case 19: 
          localua.Ldf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113952);
          return 0;
        }
        localua.Ldg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113952);
        return 0;
      }
      AppMethodBeat.o(113952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ua
 * JD-Core Version:    0.7.0.1
 */