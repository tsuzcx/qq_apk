package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bve
  extends ckq
{
  public String CFs;
  public String CFt;
  public boolean DSl;
  public String DSm;
  public String DSn;
  public int DSo;
  public String DSp;
  public String dca;
  public int dsB;
  public int dye;
  public String zWw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CFs != null) {
        paramVarArgs.d(2, this.CFs);
      }
      if (this.CFt != null) {
        paramVarArgs.d(3, this.CFt);
      }
      if (this.DSm != null) {
        paramVarArgs.d(4, this.DSm);
      }
      if (this.DSn != null) {
        paramVarArgs.d(5, this.DSn);
      }
      if (this.zWw != null) {
        paramVarArgs.d(6, this.zWw);
      }
      if (this.dca != null) {
        paramVarArgs.d(7, this.dca);
      }
      paramVarArgs.aR(8, this.dsB);
      paramVarArgs.aR(9, this.DSo);
      paramVarArgs.bg(10, this.DSl);
      paramVarArgs.aR(11, this.dye);
      if (this.DSp != null) {
        paramVarArgs.d(12, this.DSp);
      }
      AppMethodBeat.o(72530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CFs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CFs);
      }
      i = paramInt;
      if (this.CFt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CFt);
      }
      paramInt = i;
      if (this.DSm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DSm);
      }
      i = paramInt;
      if (this.DSn != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DSn);
      }
      paramInt = i;
      if (this.zWw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.zWw);
      }
      i = paramInt;
      if (this.dca != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dca);
      }
      i = i + f.a.a.b.b.a.bA(8, this.dsB) + f.a.a.b.b.a.bA(9, this.DSo) + (f.a.a.b.b.a.fY(10) + 1) + f.a.a.b.b.a.bA(11, this.dye);
      paramInt = i;
      if (this.DSp != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DSp);
      }
      AppMethodBeat.o(72530);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72530);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bve localbve = (bve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72530);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbve.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72530);
          return 0;
        case 2: 
          localbve.CFs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 3: 
          localbve.CFt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 4: 
          localbve.DSm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 5: 
          localbve.DSn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 6: 
          localbve.zWw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 7: 
          localbve.dca = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 8: 
          localbve.dsB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72530);
          return 0;
        case 9: 
          localbve.DSo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72530);
          return 0;
        case 10: 
          localbve.DSl = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(72530);
          return 0;
        case 11: 
          localbve.dye = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72530);
          return 0;
        }
        localbve.DSp = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72530);
        return 0;
      }
      AppMethodBeat.o(72530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bve
 * JD-Core Version:    0.7.0.1
 */