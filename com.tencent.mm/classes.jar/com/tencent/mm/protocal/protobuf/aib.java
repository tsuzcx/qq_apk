package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aib
  extends ckq
{
  public b DkG;
  public ahz DkH;
  public int DkI;
  public int DkJ;
  public aht Dkw;
  public String gLg;
  public String nickname;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.DkG != null) {
        paramVarArgs.c(3, this.DkG);
      }
      if (this.gLg != null) {
        paramVarArgs.d(4, this.gLg);
      }
      if (this.Dkw != null)
      {
        paramVarArgs.kX(5, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      if (this.signature != null) {
        paramVarArgs.d(6, this.signature);
      }
      if (this.DkH != null)
      {
        paramVarArgs.kX(7, this.DkH.computeSize());
        this.DkH.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.DkI);
      paramVarArgs.aR(9, this.DkJ);
      AppMethodBeat.o(168948);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label958;
      }
    }
    label958:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.DkG != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.DkG);
      }
      paramInt = i;
      if (this.gLg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gLg);
      }
      i = paramInt;
      if (this.Dkw != null) {
        i = paramInt + f.a.a.a.kW(5, this.Dkw.computeSize());
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.signature);
      }
      i = paramInt;
      if (this.DkH != null) {
        i = paramInt + f.a.a.a.kW(7, this.DkH.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(8, this.DkI);
      int j = f.a.a.b.b.a.bA(9, this.DkJ);
      AppMethodBeat.o(168948);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168948);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aib localaib = (aib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168948);
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
            localaib.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 2: 
          localaib.nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 3: 
          localaib.DkG = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(168948);
          return 0;
        case 4: 
          localaib.gLg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaib.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 6: 
          localaib.signature = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaib.DkH = ((ahz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 8: 
          localaib.DkI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168948);
          return 0;
        }
        localaib.DkJ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168948);
        return 0;
      }
      AppMethodBeat.o(168948);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aib
 * JD-Core Version:    0.7.0.1
 */