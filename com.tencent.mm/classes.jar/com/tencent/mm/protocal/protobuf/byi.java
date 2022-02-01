package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class byi
  extends dyy
{
  public int TdA;
  public int TdB;
  public uy TdC;
  public int Tdw;
  public uj Tdx;
  public um ThA;
  public un Thx;
  public ug Thy;
  public String Thz;
  public int tqa;
  public String tqb;
  public int ufi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114029);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114029);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.aY(4, this.ufi);
      paramVarArgs.aY(5, this.Tdw);
      if (this.Tdx != null)
      {
        paramVarArgs.oE(6, this.Tdx.computeSize());
        this.Tdx.writeFields(paramVarArgs);
      }
      if (this.Thx != null)
      {
        paramVarArgs.oE(7, this.Thx.computeSize());
        this.Thx.writeFields(paramVarArgs);
      }
      if (this.Thy != null)
      {
        paramVarArgs.oE(8, this.Thy.computeSize());
        this.Thy.writeFields(paramVarArgs);
      }
      if (this.Thz != null) {
        paramVarArgs.f(10, this.Thz);
      }
      paramVarArgs.aY(11, this.TdA);
      paramVarArgs.aY(12, this.TdB);
      if (this.TdC != null)
      {
        paramVarArgs.oE(13, this.TdC.computeSize());
        this.TdC.writeFields(paramVarArgs);
      }
      if (this.ThA != null)
      {
        paramVarArgs.oE(14, this.ThA.computeSize());
        this.ThA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1354;
      }
    }
    label1354:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.ufi) + g.a.a.b.b.a.bM(5, this.Tdw);
      paramInt = i;
      if (this.Tdx != null) {
        paramInt = i + g.a.a.a.oD(6, this.Tdx.computeSize());
      }
      i = paramInt;
      if (this.Thx != null) {
        i = paramInt + g.a.a.a.oD(7, this.Thx.computeSize());
      }
      paramInt = i;
      if (this.Thy != null) {
        paramInt = i + g.a.a.a.oD(8, this.Thy.computeSize());
      }
      i = paramInt;
      if (this.Thz != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Thz);
      }
      i = i + g.a.a.b.b.a.bM(11, this.TdA) + g.a.a.b.b.a.bM(12, this.TdB);
      paramInt = i;
      if (this.TdC != null) {
        paramInt = i + g.a.a.a.oD(13, this.TdC.computeSize());
      }
      i = paramInt;
      if (this.ThA != null) {
        i = paramInt + g.a.a.a.oD(14, this.ThA.computeSize());
      }
      AppMethodBeat.o(114029);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114029);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        byi localbyi = (byi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(114029);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbyi.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 2: 
          localbyi.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114029);
          return 0;
        case 3: 
          localbyi.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 4: 
          localbyi.ufi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114029);
          return 0;
        case 5: 
          localbyi.Tdw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114029);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uj)localObject2).parseFrom((byte[])localObject1);
            }
            localbyi.Tdx = ((uj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new un();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((un)localObject2).parseFrom((byte[])localObject1);
            }
            localbyi.Thx = ((un)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ug();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ug)localObject2).parseFrom((byte[])localObject1);
            }
            localbyi.Thy = ((ug)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 10: 
          localbyi.Thz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 11: 
          localbyi.TdA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114029);
          return 0;
        case 12: 
          localbyi.TdB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114029);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uy)localObject2).parseFrom((byte[])localObject1);
            }
            localbyi.TdC = ((uy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new um();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((um)localObject2).parseFrom((byte[])localObject1);
          }
          localbyi.ThA = ((um)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      AppMethodBeat.o(114029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byi
 * JD-Core Version:    0.7.0.1
 */