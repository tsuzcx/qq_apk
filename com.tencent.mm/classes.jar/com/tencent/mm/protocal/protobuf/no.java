package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class no
  extends cvc
{
  public LinkedList<nw> FHP;
  public int FHQ;
  public int FHR;
  public String FHS;
  public long FHT;
  public String FHU;
  public sv FHV;
  public nn FHW;
  public fd FHX;
  public String FHY;
  
  public no()
  {
    AppMethodBeat.i(207228);
    this.FHP = new LinkedList();
    AppMethodBeat.o(207228);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207229);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FHP);
      paramVarArgs.aS(3, this.FHQ);
      paramVarArgs.aS(4, this.FHR);
      if (this.FHS != null) {
        paramVarArgs.d(5, this.FHS);
      }
      paramVarArgs.aY(6, this.FHT);
      if (this.FHU != null) {
        paramVarArgs.d(7, this.FHU);
      }
      if (this.FHV != null)
      {
        paramVarArgs.lC(8, this.FHV.computeSize());
        this.FHV.writeFields(paramVarArgs);
      }
      if (this.FHW != null)
      {
        paramVarArgs.lC(9, this.FHW.computeSize());
        this.FHW.writeFields(paramVarArgs);
      }
      if (this.FHX != null)
      {
        paramVarArgs.lC(10, this.FHX.computeSize());
        this.FHX.writeFields(paramVarArgs);
      }
      if (this.FHY != null) {
        paramVarArgs.d(11, this.FHY);
      }
      AppMethodBeat.o(207229);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1234;
      }
    }
    label1234:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FHP) + f.a.a.b.b.a.bz(3, this.FHQ) + f.a.a.b.b.a.bz(4, this.FHR);
      paramInt = i;
      if (this.FHS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FHS);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.FHT);
      paramInt = i;
      if (this.FHU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FHU);
      }
      i = paramInt;
      if (this.FHV != null) {
        i = paramInt + f.a.a.a.lB(8, this.FHV.computeSize());
      }
      paramInt = i;
      if (this.FHW != null) {
        paramInt = i + f.a.a.a.lB(9, this.FHW.computeSize());
      }
      i = paramInt;
      if (this.FHX != null) {
        i = paramInt + f.a.a.a.lB(10, this.FHX.computeSize());
      }
      paramInt = i;
      if (this.FHY != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FHY);
      }
      AppMethodBeat.o(207229);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FHP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(207229);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        no localno = (no)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207229);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localno.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207229);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localno.FHP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207229);
          return 0;
        case 3: 
          localno.FHQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(207229);
          return 0;
        case 4: 
          localno.FHR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(207229);
          return 0;
        case 5: 
          localno.FHS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207229);
          return 0;
        case 6: 
          localno.FHT = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(207229);
          return 0;
        case 7: 
          localno.FHU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207229);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localno.FHV = ((sv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207229);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localno.FHW = ((nn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207229);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localno.FHX = ((fd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207229);
          return 0;
        }
        localno.FHY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207229);
        return 0;
      }
      AppMethodBeat.o(207229);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.no
 * JD-Core Version:    0.7.0.1
 */