package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amx
  extends cpx
{
  public aiu EDL;
  public float EFU;
  public float EFV;
  public int EFW;
  public FinderObjectDesc EFX;
  public long EFY;
  public LinkedList<String> EFZ;
  public String clientId;
  public float dmL;
  public float doB;
  public int originalFlag;
  public String refObjectNonceId;
  public String username;
  
  public amx()
  {
    AppMethodBeat.i(169036);
    this.EFZ = new LinkedList();
    AppMethodBeat.o(169036);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169037);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.EFX != null)
      {
        paramVarArgs.ln(3, this.EFX.computeSize());
        this.EFX.writeFields(paramVarArgs);
      }
      if (this.clientId != null) {
        paramVarArgs.d(4, this.clientId);
      }
      paramVarArgs.aO(5, this.EFY);
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      if (this.EDL != null)
      {
        paramVarArgs.ln(7, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      paramVarArgs.x(8, this.doB);
      paramVarArgs.x(9, this.dmL);
      paramVarArgs.x(10, this.EFU);
      paramVarArgs.x(11, this.EFV);
      paramVarArgs.aR(12, this.EFW);
      paramVarArgs.e(13, 1, this.EFZ);
      paramVarArgs.aR(14, this.originalFlag);
      AppMethodBeat.o(169037);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.EFX != null) {
        i = paramInt + f.a.a.a.lm(3, this.EFX.computeSize());
      }
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.EFY);
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.EDL != null) {
        i = paramInt + f.a.a.a.lm(7, this.EDL.computeSize());
      }
      paramInt = f.a.a.b.b.a.fK(8);
      int j = f.a.a.b.b.a.fK(9);
      int k = f.a.a.b.b.a.fK(10);
      int m = f.a.a.b.b.a.fK(11);
      int n = f.a.a.b.b.a.bx(12, this.EFW);
      int i1 = f.a.a.a.c(13, 1, this.EFZ);
      int i2 = f.a.a.b.b.a.bx(14, this.originalFlag);
      AppMethodBeat.o(169037);
      return i + (paramInt + 4) + (j + 4) + (k + 4) + (m + 4) + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EFZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169037);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amx localamx = (amx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169037);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 2: 
          localamx.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObjectDesc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObjectDesc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamx.EFX = ((FinderObjectDesc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 4: 
          localamx.clientId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 5: 
          localamx.EFY = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169037);
          return 0;
        case 6: 
          localamx.refObjectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamx.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 8: 
          localamx.doB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(169037);
          return 0;
        case 9: 
          localamx.dmL = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(169037);
          return 0;
        case 10: 
          localamx.EFU = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(169037);
          return 0;
        case 11: 
          localamx.EFV = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(169037);
          return 0;
        case 12: 
          localamx.EFW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169037);
          return 0;
        case 13: 
          localamx.EFZ.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(169037);
          return 0;
        }
        localamx.originalFlag = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169037);
        return 0;
      }
      AppMethodBeat.o(169037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amx
 * JD-Core Version:    0.7.0.1
 */