package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class all
  extends ckq
{
  public aht Dkw;
  public SKBuiltinBuffer_t DmH;
  public LinkedList<FinderContact> DmI;
  public LinkedList<FinderContact> Dmo;
  public String finderUsername;
  public int hkT;
  
  public all()
  {
    AppMethodBeat.i(169060);
    this.DmI = new LinkedList();
    this.Dmo = new LinkedList();
    AppMethodBeat.o(169060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169061);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.hkT);
      if (this.DmH != null)
      {
        paramVarArgs.kX(3, this.DmH.computeSize());
        this.DmH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.DmI);
      paramVarArgs.e(5, 8, this.Dmo);
      if (this.finderUsername != null) {
        paramVarArgs.d(6, this.finderUsername);
      }
      if (this.Dkw != null)
      {
        paramVarArgs.kX(7, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1006;
      }
    }
    label1006:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.hkT);
      paramInt = i;
      if (this.DmH != null) {
        paramInt = i + f.a.a.a.kW(3, this.DmH.computeSize());
      }
      i = paramInt + f.a.a.a.c(4, 8, this.DmI) + f.a.a.a.c(5, 8, this.Dmo);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.finderUsername);
      }
      i = paramInt;
      if (this.Dkw != null) {
        i = paramInt + f.a.a.a.kW(7, this.Dkw.computeSize());
      }
      AppMethodBeat.o(169061);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DmI.clear();
        this.Dmo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        all localall = (all)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169061);
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
            localall.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 2: 
          localall.hkT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169061);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localall.DmH = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localall.DmI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localall.Dmo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 6: 
          localall.finderUsername = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169061);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aht();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localall.Dkw = ((aht)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169061);
        return 0;
      }
      AppMethodBeat.o(169061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.all
 * JD-Core Version:    0.7.0.1
 */