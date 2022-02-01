package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvm
  extends com.tencent.mm.bx.a
{
  public String CxM;
  public String DSK;
  public String DSM;
  public String DSN;
  public String DSO;
  public String DSP;
  public bvn DSQ;
  public String DSy;
  public String DSz;
  public String app_id;
  public int dep;
  public int evp;
  public String hNH;
  public String iaz;
  public String nickname;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152638);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hNH != null) {
        paramVarArgs.d(1, this.hNH);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      paramVarArgs.aR(3, this.type);
      if (this.iaz != null) {
        paramVarArgs.d(4, this.iaz);
      }
      if (this.DSy != null) {
        paramVarArgs.d(5, this.DSy);
      }
      if (this.DSz != null) {
        paramVarArgs.d(6, this.DSz);
      }
      paramVarArgs.aR(7, this.dep);
      if (this.DSM != null) {
        paramVarArgs.d(8, this.DSM);
      }
      if (this.DSN != null) {
        paramVarArgs.d(9, this.DSN);
      }
      if (this.DSO != null) {
        paramVarArgs.d(10, this.DSO);
      }
      if (this.DSP != null) {
        paramVarArgs.d(11, this.DSP);
      }
      if (this.DSQ != null)
      {
        paramVarArgs.kX(12, this.DSQ.computeSize());
        this.DSQ.writeFields(paramVarArgs);
      }
      if (this.CxM != null) {
        paramVarArgs.d(13, this.CxM);
      }
      if (this.app_id != null) {
        paramVarArgs.d(14, this.app_id);
      }
      paramVarArgs.aR(15, this.evp);
      if (this.DSK != null) {
        paramVarArgs.d(16, this.DSK);
      }
      AppMethodBeat.o(152638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hNH == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.b.b.a.e(1, this.hNH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nickname);
      }
      i += f.a.a.b.b.a.bA(3, this.type);
      paramInt = i;
      if (this.iaz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iaz);
      }
      i = paramInt;
      if (this.DSy != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DSy);
      }
      paramInt = i;
      if (this.DSz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DSz);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.dep);
      paramInt = i;
      if (this.DSM != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DSM);
      }
      i = paramInt;
      if (this.DSN != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DSN);
      }
      paramInt = i;
      if (this.DSO != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DSO);
      }
      i = paramInt;
      if (this.DSP != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DSP);
      }
      paramInt = i;
      if (this.DSQ != null) {
        paramInt = i + f.a.a.a.kW(12, this.DSQ.computeSize());
      }
      i = paramInt;
      if (this.CxM != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.CxM);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.app_id);
      }
      i = paramInt + f.a.a.b.b.a.bA(15, this.evp);
      paramInt = i;
      if (this.DSK != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DSK);
      }
      AppMethodBeat.o(152638);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvm localbvm = (bvm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152638);
          return -1;
        case 1: 
          localbvm.hNH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 2: 
          localbvm.nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 3: 
          localbvm.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152638);
          return 0;
        case 4: 
          localbvm.iaz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 5: 
          localbvm.DSy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 6: 
          localbvm.DSz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 7: 
          localbvm.dep = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152638);
          return 0;
        case 8: 
          localbvm.DSM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 9: 
          localbvm.DSN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 10: 
          localbvm.DSO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 11: 
          localbvm.DSP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bvn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvm.DSQ = ((bvn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152638);
          return 0;
        case 13: 
          localbvm.CxM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 14: 
          localbvm.app_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 15: 
          localbvm.evp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152638);
          return 0;
        }
        localbvm.DSK = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152638);
        return 0;
      }
      AppMethodBeat.o(152638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvm
 * JD-Core Version:    0.7.0.1
 */