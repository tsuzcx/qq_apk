package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aif
  extends dyy
{
  public int HmZ;
  public int Hna;
  public int Hnb;
  public eae Hnc;
  public String UserName;
  public String lVG;
  public String lVJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9591);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.lVJ != null) {
        paramVarArgs.f(3, this.lVJ);
      }
      if (this.UserName != null) {
        paramVarArgs.f(4, this.UserName);
      }
      paramVarArgs.aY(5, this.HmZ);
      paramVarArgs.aY(6, this.Hna);
      paramVarArgs.aY(7, this.Hnb);
      if (this.Hnc != null)
      {
        paramVarArgs.oE(8, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(9591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label848;
      }
    }
    label848:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.lVJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lVJ);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UserName);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.HmZ) + g.a.a.b.b.a.bM(6, this.Hna) + g.a.a.b.b.a.bM(7, this.Hnb);
      paramInt = i;
      if (this.Hnc != null) {
        paramInt = i + g.a.a.a.oD(8, this.Hnc.computeSize());
      }
      AppMethodBeat.o(9591);
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
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aif localaif = (aif)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9591);
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
            localaif.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(9591);
          return 0;
        case 2: 
          localaif.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 3: 
          localaif.lVJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 4: 
          localaif.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 5: 
          localaif.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(9591);
          return 0;
        case 6: 
          localaif.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(9591);
          return 0;
        case 7: 
          localaif.Hnb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(9591);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localaif.Hnc = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      AppMethodBeat.o(9591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aif
 * JD-Core Version:    0.7.0.1
 */