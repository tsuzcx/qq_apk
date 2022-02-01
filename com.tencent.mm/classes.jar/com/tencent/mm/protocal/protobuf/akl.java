package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akl
  extends ckq
{
  public aht Dkw;
  public float DlV;
  public float DlW;
  public int DlX;
  public FinderObjectDesc DlY;
  public long DlZ;
  public LinkedList<String> Dma;
  public String clientId;
  public float dpb;
  public float dqQ;
  public int originalFlag;
  public String refObjectNonceId;
  public String username;
  
  public akl()
  {
    AppMethodBeat.i(169036);
    this.Dma = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.DlY != null)
      {
        paramVarArgs.kX(3, this.DlY.computeSize());
        this.DlY.writeFields(paramVarArgs);
      }
      if (this.clientId != null) {
        paramVarArgs.d(4, this.clientId);
      }
      paramVarArgs.aG(5, this.DlZ);
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      if (this.Dkw != null)
      {
        paramVarArgs.kX(7, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      paramVarArgs.x(8, this.dqQ);
      paramVarArgs.x(9, this.dpb);
      paramVarArgs.x(10, this.DlV);
      paramVarArgs.x(11, this.DlW);
      paramVarArgs.aR(12, this.DlX);
      paramVarArgs.e(13, 1, this.Dma);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.DlY != null) {
        i = paramInt + f.a.a.a.kW(3, this.DlY.computeSize());
      }
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.DlZ);
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.Dkw != null) {
        i = paramInt + f.a.a.a.kW(7, this.Dkw.computeSize());
      }
      paramInt = f.a.a.b.b.a.fY(8);
      int j = f.a.a.b.b.a.fY(9);
      int k = f.a.a.b.b.a.fY(10);
      int m = f.a.a.b.b.a.fY(11);
      int n = f.a.a.b.b.a.bA(12, this.DlX);
      int i1 = f.a.a.a.c(13, 1, this.Dma);
      int i2 = f.a.a.b.b.a.bA(14, this.originalFlag);
      AppMethodBeat.o(169037);
      return i + (paramInt + 4) + (j + 4) + (k + 4) + (m + 4) + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dma.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169037);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akl localakl = (akl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169037);
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
            localakl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 2: 
          localakl.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObjectDesc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObjectDesc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakl.DlY = ((FinderObjectDesc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 4: 
          localakl.clientId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 5: 
          localakl.DlZ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169037);
          return 0;
        case 6: 
          localakl.refObjectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakl.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 8: 
          localakl.dqQ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169037);
          return 0;
        case 9: 
          localakl.dpb = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169037);
          return 0;
        case 10: 
          localakl.DlV = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169037);
          return 0;
        case 11: 
          localakl.DlW = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169037);
          return 0;
        case 12: 
          localakl.DlX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169037);
          return 0;
        case 13: 
          localakl.Dma.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(169037);
          return 0;
        }
        localakl.originalFlag = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169037);
        return 0;
      }
      AppMethodBeat.o(169037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akl
 * JD-Core Version:    0.7.0.1
 */