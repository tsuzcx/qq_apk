package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aiv
  extends ckq
{
  public aht Dkw;
  public long Dlj;
  public int Dlk;
  public String Dll;
  public int Lxs;
  public int direction;
  public String finderUsername;
  public b lastBuffer;
  public long objectId;
  public String objectNonceId;
  public long qoB;
  public long qoE;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168973);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.objectId);
      paramVarArgs.aG(3, this.Dlj);
      paramVarArgs.aR(4, this.Dlk);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.aG(6, this.qoB);
      if (this.finderUsername != null) {
        paramVarArgs.d(7, this.finderUsername);
      }
      paramVarArgs.aG(8, this.qoE);
      paramVarArgs.aR(9, this.scene);
      paramVarArgs.aR(10, this.direction);
      if (this.Dll != null) {
        paramVarArgs.d(11, this.Dll);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(12, this.objectNonceId);
      }
      if (this.Dkw != null)
      {
        paramVarArgs.kX(13, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.Lxs);
      AppMethodBeat.o(168973);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.objectId) + f.a.a.b.b.a.q(3, this.Dlj) + f.a.a.b.b.a.bA(4, this.Dlk);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.q(6, this.qoB);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.finderUsername);
      }
      i = paramInt + f.a.a.b.b.a.q(8, this.qoE) + f.a.a.b.b.a.bA(9, this.scene) + f.a.a.b.b.a.bA(10, this.direction);
      paramInt = i;
      if (this.Dll != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Dll);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.objectNonceId);
      }
      paramInt = i;
      if (this.Dkw != null) {
        paramInt = i + f.a.a.a.kW(13, this.Dkw.computeSize());
      }
      i = f.a.a.b.b.a.bA(14, this.Lxs);
      AppMethodBeat.o(168973);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168973);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aiv localaiv = (aiv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168973);
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
            localaiv.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 2: 
          localaiv.objectId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168973);
          return 0;
        case 3: 
          localaiv.Dlj = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168973);
          return 0;
        case 4: 
          localaiv.Dlk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168973);
          return 0;
        case 5: 
          localaiv.lastBuffer = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(168973);
          return 0;
        case 6: 
          localaiv.qoB = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168973);
          return 0;
        case 7: 
          localaiv.finderUsername = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 8: 
          localaiv.qoE = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168973);
          return 0;
        case 9: 
          localaiv.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168973);
          return 0;
        case 10: 
          localaiv.direction = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168973);
          return 0;
        case 11: 
          localaiv.Dll = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 12: 
          localaiv.objectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaiv.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        }
        localaiv.Lxs = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168973);
        return 0;
      }
      AppMethodBeat.o(168973);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiv
 * JD-Core Version:    0.7.0.1
 */