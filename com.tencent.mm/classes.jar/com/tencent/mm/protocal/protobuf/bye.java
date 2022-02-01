package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bye
  extends dyy
{
  public LinkedList<uc> SeF;
  public int TdA;
  public int TdB;
  public uy TdC;
  public LinkedList<ug> Tds;
  public int Tdw;
  public up Tdy;
  public String Tdz;
  public up Tht;
  public String Thu;
  public String Thv;
  public int tqa;
  public String tqb;
  public int ufi;
  
  public bye()
  {
    AppMethodBeat.i(246258);
    this.SeF = new LinkedList();
    this.Tds = new LinkedList();
    AppMethodBeat.o(246258);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(246259);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(246259);
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
      paramVarArgs.e(6, 8, this.SeF);
      if (this.TdC != null)
      {
        paramVarArgs.oE(7, this.TdC.computeSize());
        this.TdC.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.TdA);
      paramVarArgs.aY(9, this.TdB);
      if (this.Tdy != null)
      {
        paramVarArgs.oE(10, this.Tdy.computeSize());
        this.Tdy.writeFields(paramVarArgs);
      }
      if (this.Tdz != null) {
        paramVarArgs.f(11, this.Tdz);
      }
      if (this.Tht != null)
      {
        paramVarArgs.oE(12, this.Tht.computeSize());
        this.Tht.writeFields(paramVarArgs);
      }
      if (this.Thu != null) {
        paramVarArgs.f(13, this.Thu);
      }
      if (this.Thv != null) {
        paramVarArgs.f(14, this.Thv);
      }
      paramVarArgs.e(15, 8, this.Tds);
      AppMethodBeat.o(246259);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1442;
      }
    }
    label1442:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.ufi) + g.a.a.b.b.a.bM(5, this.Tdw) + g.a.a.a.c(6, 8, this.SeF);
      paramInt = i;
      if (this.TdC != null) {
        paramInt = i + g.a.a.a.oD(7, this.TdC.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.TdA) + g.a.a.b.b.a.bM(9, this.TdB);
      paramInt = i;
      if (this.Tdy != null) {
        paramInt = i + g.a.a.a.oD(10, this.Tdy.computeSize());
      }
      i = paramInt;
      if (this.Tdz != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.Tdz);
      }
      paramInt = i;
      if (this.Tht != null) {
        paramInt = i + g.a.a.a.oD(12, this.Tht.computeSize());
      }
      i = paramInt;
      if (this.Thu != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.Thu);
      }
      paramInt = i;
      if (this.Thv != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Thv);
      }
      i = g.a.a.a.c(15, 8, this.Tds);
      AppMethodBeat.o(246259);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SeF.clear();
        this.Tds.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(246259);
          throw paramVarArgs;
        }
        AppMethodBeat.o(246259);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bye localbye = (bye)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(246259);
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
            localbye.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246259);
          return 0;
        case 2: 
          localbye.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(246259);
          return 0;
        case 3: 
          localbye.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(246259);
          return 0;
        case 4: 
          localbye.ufi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(246259);
          return 0;
        case 5: 
          localbye.Tdw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(246259);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uc)localObject2).parseFrom((byte[])localObject1);
            }
            localbye.SeF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246259);
          return 0;
        case 7: 
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
            localbye.TdC = ((uy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246259);
          return 0;
        case 8: 
          localbye.TdA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(246259);
          return 0;
        case 9: 
          localbye.TdB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(246259);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new up();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((up)localObject2).parseFrom((byte[])localObject1);
            }
            localbye.Tdy = ((up)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246259);
          return 0;
        case 11: 
          localbye.Tdz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(246259);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new up();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((up)localObject2).parseFrom((byte[])localObject1);
            }
            localbye.Tht = ((up)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246259);
          return 0;
        case 13: 
          localbye.Thu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(246259);
          return 0;
        case 14: 
          localbye.Thv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(246259);
          return 0;
        }
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
          localbye.Tds.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(246259);
        return 0;
      }
      AppMethodBeat.o(246259);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bye
 * JD-Core Version:    0.7.0.1
 */