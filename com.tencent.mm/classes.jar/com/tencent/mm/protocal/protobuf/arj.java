package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arj
  extends ckq
{
  public String CtT;
  public String CtU;
  public int CtV;
  public LinkedList<rb> CtY;
  public String DrO;
  public int dye;
  public String odK;
  public String odc;
  public String sign;
  
  public arj()
  {
    AppMethodBeat.i(114012);
    this.CtY = new LinkedList();
    AppMethodBeat.o(114012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.CtY);
      paramVarArgs.aR(3, this.dye);
      if (this.odK != null) {
        paramVarArgs.d(4, this.odK);
      }
      if (this.odc != null) {
        paramVarArgs.d(5, this.odc);
      }
      if (this.sign != null) {
        paramVarArgs.d(6, this.sign);
      }
      if (this.CtT != null) {
        paramVarArgs.d(7, this.CtT);
      }
      if (this.CtU != null) {
        paramVarArgs.d(8, this.CtU);
      }
      if (this.DrO != null) {
        paramVarArgs.d(9, this.DrO);
      }
      paramVarArgs.aR(10, this.CtV);
      AppMethodBeat.o(114013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.CtY) + f.a.a.b.b.a.bA(3, this.dye);
      paramInt = i;
      if (this.odK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.odK);
      }
      i = paramInt;
      if (this.odc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.odc);
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sign);
      }
      i = paramInt;
      if (this.CtT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CtT);
      }
      paramInt = i;
      if (this.CtU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CtU);
      }
      i = paramInt;
      if (this.DrO != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DrO);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.CtV);
      AppMethodBeat.o(114013);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CtY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arj localarj = (arj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114013);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarj.CtY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 3: 
          localarj.dye = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114013);
          return 0;
        case 4: 
          localarj.odK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 5: 
          localarj.odc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 6: 
          localarj.sign = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 7: 
          localarj.CtT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 8: 
          localarj.CtU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 9: 
          localarj.DrO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114013);
          return 0;
        }
        localarj.CtV = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(114013);
        return 0;
      }
      AppMethodBeat.o(114013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arj
 * JD-Core Version:    0.7.0.1
 */