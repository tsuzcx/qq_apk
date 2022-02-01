package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cev
  extends com.tencent.mm.bx.a
{
  public String Fvw;
  public String GYF;
  public String GYG;
  public String GYR;
  public String GYT;
  public String GYU;
  public String GYV;
  public String GYW;
  public cew GYX;
  public String app_id;
  public int dnh;
  public int ePk;
  public String iHA;
  public String iTM;
  public String nickname;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152638);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iHA != null) {
        paramVarArgs.d(1, this.iHA);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      paramVarArgs.aS(3, this.type);
      if (this.iTM != null) {
        paramVarArgs.d(4, this.iTM);
      }
      if (this.GYF != null) {
        paramVarArgs.d(5, this.GYF);
      }
      if (this.GYG != null) {
        paramVarArgs.d(6, this.GYG);
      }
      paramVarArgs.aS(7, this.dnh);
      if (this.GYT != null) {
        paramVarArgs.d(8, this.GYT);
      }
      if (this.GYU != null) {
        paramVarArgs.d(9, this.GYU);
      }
      if (this.GYV != null) {
        paramVarArgs.d(10, this.GYV);
      }
      if (this.GYW != null) {
        paramVarArgs.d(11, this.GYW);
      }
      if (this.GYX != null)
      {
        paramVarArgs.lC(12, this.GYX.computeSize());
        this.GYX.writeFields(paramVarArgs);
      }
      if (this.Fvw != null) {
        paramVarArgs.d(13, this.Fvw);
      }
      if (this.app_id != null) {
        paramVarArgs.d(14, this.app_id);
      }
      paramVarArgs.aS(15, this.ePk);
      if (this.GYR != null) {
        paramVarArgs.d(16, this.GYR);
      }
      AppMethodBeat.o(152638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iHA == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.b.b.a.e(1, this.iHA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nickname);
      }
      i += f.a.a.b.b.a.bz(3, this.type);
      paramInt = i;
      if (this.iTM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iTM);
      }
      i = paramInt;
      if (this.GYF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GYF);
      }
      paramInt = i;
      if (this.GYG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GYG);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.dnh);
      paramInt = i;
      if (this.GYT != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GYT);
      }
      i = paramInt;
      if (this.GYU != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GYU);
      }
      paramInt = i;
      if (this.GYV != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GYV);
      }
      i = paramInt;
      if (this.GYW != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GYW);
      }
      paramInt = i;
      if (this.GYX != null) {
        paramInt = i + f.a.a.a.lB(12, this.GYX.computeSize());
      }
      i = paramInt;
      if (this.Fvw != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Fvw);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.app_id);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.ePk);
      paramInt = i;
      if (this.GYR != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GYR);
      }
      AppMethodBeat.o(152638);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cev localcev = (cev)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152638);
          return -1;
        case 1: 
          localcev.iHA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 2: 
          localcev.nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 3: 
          localcev.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152638);
          return 0;
        case 4: 
          localcev.iTM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 5: 
          localcev.GYF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 6: 
          localcev.GYG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 7: 
          localcev.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152638);
          return 0;
        case 8: 
          localcev.GYT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 9: 
          localcev.GYU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 10: 
          localcev.GYV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 11: 
          localcev.GYW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cew();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcev.GYX = ((cew)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152638);
          return 0;
        case 13: 
          localcev.Fvw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 14: 
          localcev.app_id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 15: 
          localcev.ePk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152638);
          return 0;
        }
        localcev.GYR = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152638);
        return 0;
      }
      AppMethodBeat.o(152638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cev
 * JD-Core Version:    0.7.0.1
 */