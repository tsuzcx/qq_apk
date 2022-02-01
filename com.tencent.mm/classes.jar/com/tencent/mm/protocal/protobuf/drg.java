package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class drg
  extends dyy
{
  public String OmF;
  public String TUa;
  public String TUb;
  public aw TXG;
  public erl TXH;
  public dmv TXI;
  public String TXJ;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72565);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72565);
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
      if (this.TUa != null) {
        paramVarArgs.f(4, this.TUa);
      }
      if (this.TUb != null) {
        paramVarArgs.f(5, this.TUb);
      }
      if (this.TXG != null)
      {
        paramVarArgs.oE(6, this.TXG.computeSize());
        this.TXG.writeFields(paramVarArgs);
      }
      if (this.TXH != null)
      {
        paramVarArgs.oE(7, this.TXH.computeSize());
        this.TXH.writeFields(paramVarArgs);
      }
      if (this.TXI != null)
      {
        paramVarArgs.oE(8, this.TXI.computeSize());
        this.TXI.writeFields(paramVarArgs);
      }
      if (this.TXJ != null) {
        paramVarArgs.f(9, this.TXJ);
      }
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(72565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1122;
      }
    }
    label1122:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.TUa != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TUa);
      }
      paramInt = i;
      if (this.TUb != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TUb);
      }
      i = paramInt;
      if (this.TXG != null) {
        i = paramInt + g.a.a.a.oD(6, this.TXG.computeSize());
      }
      paramInt = i;
      if (this.TXH != null) {
        paramInt = i + g.a.a.a.oD(7, this.TXH.computeSize());
      }
      i = paramInt;
      if (this.TXI != null) {
        i = paramInt + g.a.a.a.oD(8, this.TXI.computeSize());
      }
      paramInt = i;
      if (this.TXJ != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TXJ);
      }
      i = paramInt;
      if (this.OmF != null) {
        i = paramInt + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(72565);
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
          AppMethodBeat.o(72565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drg localdrg = (drg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72565);
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
            localdrg.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 2: 
          localdrg.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72565);
          return 0;
        case 3: 
          localdrg.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 4: 
          localdrg.TUa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 5: 
          localdrg.TUb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aw)localObject2).parseFrom((byte[])localObject1);
            }
            localdrg.TXG = ((aw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erl)localObject2).parseFrom((byte[])localObject1);
            }
            localdrg.TXH = ((erl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmv)localObject2).parseFrom((byte[])localObject1);
            }
            localdrg.TXI = ((dmv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 9: 
          localdrg.TXJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72565);
          return 0;
        }
        localdrg.OmF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(72565);
        return 0;
      }
      AppMethodBeat.o(72565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drg
 * JD-Core Version:    0.7.0.1
 */