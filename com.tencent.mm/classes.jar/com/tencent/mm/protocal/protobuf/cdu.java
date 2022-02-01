package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cdu
  extends dyy
{
  public int TlA;
  public aim TlB;
  public aim TlC;
  public String TlD;
  public boolean Tly = false;
  public int Tlz;
  public String llI;
  public String llJ;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249984);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(249984);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.co(2, this.Tly);
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.llI != null) {
        paramVarArgs.f(4, this.llI);
      }
      if (this.llJ != null) {
        paramVarArgs.f(5, this.llJ);
      }
      if (this.url != null) {
        paramVarArgs.f(6, this.url);
      }
      paramVarArgs.aY(7, this.Tlz);
      paramVarArgs.aY(8, this.TlA);
      if (this.TlB != null)
      {
        paramVarArgs.oE(9, this.TlB.computeSize());
        this.TlB.writeFields(paramVarArgs);
      }
      if (this.TlC != null)
      {
        paramVarArgs.oE(10, this.TlC.computeSize());
        this.TlC.writeFields(paramVarArgs);
      }
      if (this.TlD != null) {
        paramVarArgs.f(11, this.TlD);
      }
      AppMethodBeat.o(249984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1040;
      }
    }
    label1040:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.title);
      }
      i = paramInt;
      if (this.llI != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.llI);
      }
      paramInt = i;
      if (this.llJ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.llJ);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.url);
      }
      i = i + g.a.a.b.b.a.bM(7, this.Tlz) + g.a.a.b.b.a.bM(8, this.TlA);
      paramInt = i;
      if (this.TlB != null) {
        paramInt = i + g.a.a.a.oD(9, this.TlB.computeSize());
      }
      i = paramInt;
      if (this.TlC != null) {
        i = paramInt + g.a.a.a.oD(10, this.TlC.computeSize());
      }
      paramInt = i;
      if (this.TlD != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.TlD);
      }
      AppMethodBeat.o(249984);
      return paramInt;
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
          AppMethodBeat.o(249984);
          throw paramVarArgs;
        }
        AppMethodBeat.o(249984);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cdu localcdu = (cdu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(249984);
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
            localcdu.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249984);
          return 0;
        case 2: 
          localcdu.Tly = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(249984);
          return 0;
        case 3: 
          localcdu.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(249984);
          return 0;
        case 4: 
          localcdu.llI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(249984);
          return 0;
        case 5: 
          localcdu.llJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(249984);
          return 0;
        case 6: 
          localcdu.url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(249984);
          return 0;
        case 7: 
          localcdu.Tlz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(249984);
          return 0;
        case 8: 
          localcdu.TlA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(249984);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aim();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aim)localObject2).parseFrom((byte[])localObject1);
            }
            localcdu.TlB = ((aim)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249984);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aim();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aim)localObject2).parseFrom((byte[])localObject1);
            }
            localcdu.TlC = ((aim)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249984);
          return 0;
        }
        localcdu.TlD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249984);
        return 0;
      }
      AppMethodBeat.o(249984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdu
 * JD-Core Version:    0.7.0.1
 */